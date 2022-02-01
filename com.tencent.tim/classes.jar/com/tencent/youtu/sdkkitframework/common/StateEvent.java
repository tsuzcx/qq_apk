package com.tencent.youtu.sdkkitframework.common;

public class StateEvent
{
  public static class ActionValue
  {
    public static final String CAMERA_FOCUS = "need_focus";
    public static final String NET_REQ = "network_request";
    public static final String OCR_CARD_NOT_FOUND = "card_not_found";
    public static final String OCR_MANUAL_ON = "ocr_start_manual_mode";
    public static final String PROCESS_FIN = "process_finished";
    public static final String STAGE_NOTPASS = "not_pass";
    public static final String STAGE_PASS = "pass";
    public static final String TIMEOUT_COUNTDOWN_BEGIN = "timeout_count_begin";
  }
  
  public static class Name
  {
    public static final String CMP_MESSAGE = "cmp_message";
    public static final String CMP_SCORE = "cmp_score";
    public static final String COUNTDOWN_TIME = "countdown_time";
    public static final String ERROR_CODE = "error_code";
    public static final String ERROR_REASON_CODE = "error_reason_code";
    public static final String EXTRA_MESSAGE = "extra_message";
    public static final String MESSAGE = "message";
    public static final String PROCESS_RESULT = "process_action";
    public static final String UI_ACTION = "ui_action";
    public static final String UI_TIPS = "ui_tips";
  }
  
  public static class ProcessResult
  {
    public static final String FAILED = "failed";
    public static final String SUCCEED = "succeed";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.StateEvent
 * JD-Core Version:    0.7.0.1
 */