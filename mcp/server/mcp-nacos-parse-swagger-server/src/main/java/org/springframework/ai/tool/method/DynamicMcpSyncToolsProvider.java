package org.springframework.ai.tool.method;

import io.modelcontextprotocol.server.McpSyncServer;
import org.springframework.ai.mcp.McpToolUtils;
import org.springframework.ai.tool.RestfulToolCallback;
import org.springframework.ai.tool.definition.ToolDefinition;

/**
 * @author yingzi
 * @since 2025/7/9
 */

public class DynamicMcpSyncToolsProvider implements DynamicMcpToolsProvider {
    private final McpSyncServer mcpSyncServer;

    public DynamicMcpSyncToolsProvider(final McpSyncServer mcpSyncServer) {
        this.mcpSyncServer = mcpSyncServer;
    }

    @Override
    public void addTool(final ToolDefinition toolDefinition) {
        RestfulToolCallback restfulToolCallback = new RestfulToolCallback(toolDefinition);
        mcpSyncServer.addTool(McpToolUtils.toSyncToolSpecification(restfulToolCallback));
    }

    @Override
    public void removeTool(final String toolName) {
        mcpSyncServer.removeTool(toolName);
    }

}
