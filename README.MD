## Agent Communication Protocol (ACP) Java Example

This projects demonstrates how to implement the Agent Communication Protocol (ACP) in Java . ACP enables AI agents to communicate and collaborate seamlessly.
Convert your Java classes and methods into agents and actions using simple annotations.

```java
package org.example.service;

import com.t4a.annotations.Action;
import com.t4a.annotations.Agent;
import com.t4a.detect.ActionCallback;
import com.t4a.processor.AIProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Agent(groupName ="foodpreferences", groupDescription = "Provide persons name and then find out what does that person like")
@Slf4j
public class SimpleService {

    /**
     * Each action has access to AIProcessor and ActionCallback which are autowired by tools4ai
     */
    private ActionCallback callback;

    /**
     * Each action has access to AIProcessor and ActionCallback which are autowired by tools4ai
     */
    private AIProcessor processor;
    public SimpleService(){
      log.info(" Created Simple Service");
    }

    @Action(description = "Get the favourite food of a person")
    public String whatThisPersonFavFood(String name) {
        if("vishal".equalsIgnoreCase(name))
        return "Paneer Butter Masala";
        else if ("vinod".equalsIgnoreCase(name)) {
            return "aloo kofta";
        }else
            return "something yummy";
    }

}

```

This will create an agent with the group name `foodpreferences` and an action `whatThisPersonFavFood`. The action takes a person's name as input and returns their favorite food.

- Zero boilerplate integration using @Agent and @Action annotations
- Ideal for building intelligent microservices and AI-enhanced APIs

- ### Example: Create Car services with AI-Driven Spring Bean

We will add sevearl capabilities to the carservices agent , this agent is based on the groupname


```java
@Service
@Log
@Agent(groupName ="carservices", groupDescription = "all services related to cars and automobile")
public class CompareCarService{
    public CompareCarService() {
        log.info("created compare car service");
    }

    /**
     * Each action has access to AIProcessor and ActionCallback which are autowired by tools4ai
     */
    private ActionCallback callback;

    /**
     * Each action has access to AIProcessor and ActionCallback which are autowired by tools4ai
     */
    private AIProcessor processor;

    @Action(description = "compare 2 cars")
    public String compareCar(String car1 , String car2) {

        log.info(car2);
        log.info(car1);
        // implement the comparison logic here
        if(callback!=null) {
            callback.sendtStatus(car2+" is better than "+car1, ActionState.COMPLETED);
        }
        return " this is better - "+car2;
    }
}
```

Another capability of the same agent

```java
@Service
@Log
@Agent(groupName ="carservices", groupDescription = "Provide 2 cars and compare them")
public class BuyCarService {

    @Action( description = "Buy a car with cash and get a heavy discount")
    public String buyCarWithCash(String carModel, int cashAmount) {
        log.info("Buying car model: " + carModel + " with cash amount: " + cashAmount);
        return "Bought " + carModel + " with cash amount: " + cashAmount;

    }

    @Action( description = "Buy a car with loan and get a moderate discount")
    public String buyCarWithLoan(String carModel, int loanAmount, int downPayment) {
        log.info("Buying car model: " + carModel + " with loan amount: " + loanAmount + " and down payment: " + downPayment);
        return "Bought " + carModel + " with loan amount: " + loanAmount + " and down payment: " + downPayment;
    }
}

```

Now when you start the spring boot application, you will see the agent card generated automatically for carservices agent with 3 actions

This is the manifest file which gets generated 


```json
{
  "agents": [
    {
      "name": "carservices",
      "description": "all services related to cars and automobile",
      "inputContentTypes": [
        "text/plain",
        "application/json"
      ],
      "outputContentTypes": [
        "text/plain",
        "application/json"
      ],
      "metadata": {
        "annotations": null,
        "documentation": "all services related to cars and automobile",
        "license": null,
        "programmingLanguage": null,
        "naturalLanguages": null,
        "framework": "Tools4AI",
        "capabilities": [
          {
            "name": "compareCar",
            "description": "compare 2 cars"
          },
          {
            "name": "buyCarWithCash",
            "description": "Buy a car with cash and get a heavy discount"
          },
          {
            "name": "buyCarWithLoan",
            "description": "Buy a car with loan and get a moderate discount"
          }
        ],
        "domains": null,
        "tags": null,
        "createdAt": "2025-08-31T17:53:16.3146249-04:00",
        "updatedAt": "2025-08-31T17:53:16.3146249-04:00",
        "author": null,
        "contributors": null,
        "links": [
          {
            "type": "api",
            "url": "http://vishal:7860/agents/carservices"
          }
        ],
        "dependencies": null,
        "recommendedModels": null
      },
      "status": {
        "avgRunTokens": null,
        "avgRunTimeSeconds": null,
        "successRate": 100
      }
    },
    {
      "name": "customersupport",
      "description": "Create a ticket for customer",
      "inputContentTypes": [
        "text/plain",
        "application/json"
      ],
      "outputContentTypes": [
        "text/plain",
        "application/json"
      ],
      "metadata": {
        "annotations": null,
        "documentation": "Create a ticket for customer",
        "license": null,
        "programmingLanguage": null,
        "naturalLanguages": null,
        "framework": "Tools4AI",
        "capabilities": [
          {
            "name": "getTicketStatus",
            "description": "Get ticket status"
          },
          {
            "name": "raiseTicket",
            "description": "Raise a ticket for customer"
          }
        ],
        "domains": null,
        "tags": null,
        "createdAt": "2025-08-31T17:53:16.3156377-04:00",
        "updatedAt": "2025-08-31T17:53:16.3156377-04:00",
        "author": null,
        "contributors": null,
        "links": [
          {
            "type": "api",
            "url": "http://vishal:7860/agents/customersupport"
          }
        ],
        "dependencies": null,
        "recommendedModels": null
      },
      "status": {
        "avgRunTokens": null,
        "avgRunTimeSeconds": null,
        "successRate": 100
      }
    },
    {
      "name": "foodpreferences",
      "description": "Provide persons name and then find out what does that person like",
      "inputContentTypes": [
        "text/plain",
        "application/json"
      ],
      "outputContentTypes": [
        "text/plain",
        "application/json"
      ],
      "metadata": {
        "annotations": null,
        "documentation": "Provide persons name and then find out what does that person like",
        "license": null,
        "programmingLanguage": null,
        "naturalLanguages": null,
        "framework": "Tools4AI",
        "capabilities": [
          {
            "name": "whatThisPersonFavFood",
            "description": "Get the favourite food of a person"
          }
        ],
        "domains": null,
        "tags": null,
        "createdAt": "2025-08-31T17:53:16.3156377-04:00",
        "updatedAt": "2025-08-31T17:53:16.3156377-04:00",
        "author": null,
        "contributors": null,
        "links": [
          {
            "type": "api",
            "url": "http://vishal:7860/agents/foodpreferences"
          }
        ],
        "dependencies": null,
        "recommendedModels": null
      },
      "status": {
        "avgRunTokens": null,
        "avgRunTimeSeconds": null,
        "successRate": 100
      }
    }
  ]
}
```

## Running the Client

```java
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



```

and the output will be 

```bash
Available Agents:
- carservices: all services related to cars and automobile
  Capabilities:
    * compareCar: compare 2 cars
    * buyCarWithCash: Buy a car with cash and get a heavy discount
    * buyCarWithLoan: Buy a car with loan and get a moderate discount
- customersupport: Create a ticket for customer
  Capabilities:
    * getTicketStatus: Get ticket status
    * raiseTicket: Raise a ticket for customer
- foodpreferences: Provide persons name and then find out what does that person like
  Capabilities:
    * whatThisPersonFavFood: Get the favourite food of a person
Synchronous Run ID: e0ba5243-2426-4c4b-8edf-4760988a760a
Synchronous Run Status: COMPLETED
Response: Paneer Butter Masala
```