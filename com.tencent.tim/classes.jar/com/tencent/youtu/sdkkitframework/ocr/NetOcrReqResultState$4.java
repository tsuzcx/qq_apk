package com.tencent.youtu.sdkkitframework.ocr;

import java.util.HashMap;

class NetOcrReqResultState$4
  extends HashMap<String, Object>
{
  NetOcrReqResultState$4(NetOcrReqResultState paramNetOcrReqResultState, Exception paramException)
  {
    put("ui_action", "process_finished");
    put("ui_tips", "rst_failed");
    put("process_action", "failed");
    put("error_code", Integer.valueOf(4194304));
    put("message", this.val$e.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.ocr.NetOcrReqResultState.4
 * JD-Core Version:    0.7.0.1
 */