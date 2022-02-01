package com.tencent.qqmini.miniapp.util;

public class DebugUtils
{
  public class Body
  {
    public static final String DEBUG_ARK_CLIENT = "DebugArkClient";
    public static final String DEBUG_ARK_MASTER = "DebugArkMaster";
    public static final String DEBUG_MESSAGE_CLIENT = "DebugMessageClient";
    public static final String DEBUG_MESSAGE_MASTER = "DebugMessageMaster";
    public static final String DEBUG_PING = "DebugPing";
    public static final String DEBUG_PONG = "DebugPong";
    public static final String DEBUG_SOCKET_MESSAGE = "SocketMessage";
    
    public Body() {}
  }
  
  public class Code
  {
    public static final String CODE_TERMINAL_ENTER_ROOM_FAIL = "1002";
    public static final String CODE_TERMINAL_ENTER_ROOM_SUCC = "0002";
    public static final String CODE_TERMINAL_RE_ENTER_ROOM_SUCC = "0004";
    
    public Code() {}
  }
  
  public class Command
  {
    public static final String BREAK_POINT = "breakpoint";
    public static final String CALL_INTERFACE = "callInterface";
    public static final String CALL_INTERFACE_RESULT = "callInterfaceResult";
    public static final String CHROME_DEVTOOLS = "chromeDevtools";
    public static final String CHROME_DEVTOOLS_RESULT = "chromeDevtoolsResult";
    public static final String DOM_EVENT = "domEvent";
    public static final String DOM_OP = "domOp";
    public static final String EVALUATE_JAVASCRIPT = "evaluateJavascript";
    public static final String EVALUATE_JAVASCRIPT_RESULT = "evaluateJavascriptResult";
    public static final String SETUP_CONTEXT = "setupContext";
    public static final String SETUP_CONTEXT_RESULT = "setupContextResult";
    
    public Command() {}
  }
  
  public class JSONObject
  {
    public static final String CATEGORY = "category";
    public static final String CODE = "code";
    public static final String DEBUG_MESSAGE = "debug_message";
    
    public JSONObject() {}
  }
  
  public class Method
  {
    public static final String INVOKEHANDLER = "invokeHandler";
    public static final String PUBLISHHANDLER = "publishHandler";
    
    public Method() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.DebugUtils
 * JD-Core Version:    0.7.0.1
 */