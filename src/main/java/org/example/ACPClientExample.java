package org.example;

import io.github.vishalmysore.tools4ai.client.ACPClient;
import io.github.vishalmysore.tools4ai.domain.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ACPClientExample {

    public static void main(String[] args) {
        ACPClient client = new ACPClient("http://localhost:7860");
        if (!client.ping()) {
            System.out.println("Server is not available");
            return;
        }

        try {
            // List available agents
            System.out.println("Available Agents:");
            List<AgentManifest> agents = client.listAgents(10, 0);
            for (AgentManifest agent : agents) {
                System.out.println("- " + agent.getName() + ": " + agent.getDescription());
                System.out.println("  Capabilities:");
                for (Metadata.Capability capability : agent.getMetadata().getCapabilities()) {
                    System.out.println("    * " + capability.getName() + ": " + capability.getDescription());
                }
            }

            if (!agents.isEmpty()) {
                // Create a test message
                Message message = new Message();
                message.setRole(MessageRole.USER);

                MessagePart part = new MessagePart();
                part.setContentType("text/plain");
                part.setContent("What food Vishal Likes");
                message.setParts(List.of(part));
                Run syncRun = client.executeSync("foodpreferences", List.of(message));
                System.out.println("Synchronous Run ID: " + syncRun.getRunId());
                System.out.println("Synchronous Run Status: " + syncRun.getStatus());
                for (Message msg : syncRun.getOutput()) {
                    for (MessagePart p : msg.getParts()) {
                        System.out.println("Response: " + p.getContent());
                    }
                }

            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    }

