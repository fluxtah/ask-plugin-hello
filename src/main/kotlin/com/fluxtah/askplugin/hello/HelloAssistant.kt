package com.fluxtah.askplugin.hello

import com.fluxtah.askpluginsdk.AskPlugin
import com.fluxtah.askpluginsdk.AssistantDefinition
import com.fluxtah.askpluginsdk.CreateAssistantDefinitionsConfig
import com.fluxtah.askpluginsdk.Fun
import com.fluxtah.askpluginsdk.logging.AskLogger

class HelloAssistantPlugin : AskPlugin {
    override fun createAssistantDefinitions(config: CreateAssistantDefinitionsConfig): List<AssistantDefinition> {
        return listOf(HelloAssistant(config.logger))
    }
}

class HelloAssistant(logger: AskLogger) : AssistantDefinition(
    logger = logger,
    id = "hello",
    name = "Hello Assistant",
    description = "A simple assistant that says hello",
    version = "1.0",
    model = "gpt-3.5-turbo",
    temperature = 0.5f,
    instructions = "Say hello to the user",
    functions = HelloFunctions()
)

class HelloFunctions {
    @Fun("Say hello to the user")
    fun hello(input: String): String {
        return "Hello! $input"
    }
}
