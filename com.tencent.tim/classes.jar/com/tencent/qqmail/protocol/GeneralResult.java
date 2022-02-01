package com.tencent.qqmail.protocol;

public class GeneralResult
{
  public static final int GeneralResult_DebugLogSetting = 4;
  public static final int GeneralResult_KeyChange = 2;
  public static final int GeneralResult_RemoteWipe = 3;
  public static final int GeneralResult_VerifyCode = 1;
  public int debug_log_setting_duration;
  public int debug_log_setting_level;
  public String debug_log_setting_params;
  public String key_change_new_pub_key;
  public int result_type_;
  public long uma_id_;
  public String verify_code_code_image;
  public String verify_code_code_sid;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.GeneralResult
 * JD-Core Version:    0.7.0.1
 */