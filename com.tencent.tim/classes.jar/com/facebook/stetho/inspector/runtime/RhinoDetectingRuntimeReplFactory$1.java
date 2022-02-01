package com.facebook.stetho.inspector.runtime;

import com.facebook.stetho.inspector.console.RuntimeRepl;

class RhinoDetectingRuntimeReplFactory$1
  implements RuntimeRepl
{
  RhinoDetectingRuntimeReplFactory$1(RhinoDetectingRuntimeReplFactory paramRhinoDetectingRuntimeReplFactory) {}
  
  public Object evaluate(String paramString)
    throws Exception
  {
    if (RhinoDetectingRuntimeReplFactory.access$000(this.this$0) != null) {
      return "stetho-js-rhino threw: " + RhinoDetectingRuntimeReplFactory.access$000(this.this$0).toString();
    }
    return "Not supported without stetho-js-rhino dependency";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.runtime.RhinoDetectingRuntimeReplFactory.1
 * JD-Core Version:    0.7.0.1
 */