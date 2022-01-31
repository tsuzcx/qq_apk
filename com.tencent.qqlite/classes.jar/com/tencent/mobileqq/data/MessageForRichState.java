package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForRichState
  extends ChatMessage
{
  public static final int CLASS_ICON = 0;
  public static final int CLASS_IMAGE = 1;
  public static final String SIGN_MSG_ACTION_ID_KEY = "aid";
  public static final String SIGN_MSG_ACTION_TEXT_KEY = "actiontext";
  public static final String SIGN_MSG_DATA_ID_KEY = "did";
  public static final String SIGN_MSG_DATA_TEXT_KEY = "datatext";
  public static final String SIGN_MSG_LOC_TEXT_KEY = "loctext";
  public static final String SIGN_MSG_LOC_TEXT_POS_KEY = "loctextpos";
  public static final String SIGN_MSG_PLAIN_TEXT_KEY = "plaintext";
  public static final String SIGN_MSG_TIME_KEY = "time";
  public static final String SIGN_MSG_VER_KEY = "ver";
  public String actionId;
  public String actionText;
  public int clazz;
  public int data;
  public String dataId;
  public String dataText;
  public boolean isRickSignState = false;
  public String locPos;
  public String locText;
  public JSONArray plainText;
  public JSONObject signMsg;
  public int size;
  public long time;
  public int type;
  public String ver;
  
  protected void doParse()
  {
    for (;;)
    {
      try
      {
        this.signMsg = new JSONObject(this.msg);
        this.actionText = this.signMsg.optString("actiontext");
        this.dataText = this.signMsg.optString("datatext");
        if ((this.dataText != null) && (this.dataText.length() > 0))
        {
          this.isRickSignState = true;
          this.ver = this.signMsg.optString("ver");
          if ((this.ver == null) || (!this.ver.equals("1.0"))) {
            break;
          }
          this.time = Long.parseLong(this.signMsg.optString("time"));
          this.actionId = this.signMsg.optString("aid");
          this.dataId = this.signMsg.optString("did");
          this.plainText = this.signMsg.optJSONArray("plaintext");
          this.locText = this.signMsg.optString("loctext");
          this.locPos = this.signMsg.optString("loctextpos");
          return;
        }
        if ((this.actionText != null) && (this.actionText.length() > 0)) {
          this.isRickSignState = true;
        } else {
          this.isRickSignState = false;
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOSign", 2, "convert msg to json failed,error msg is:" + localJSONException.getMessage(), localJSONException);
        }
        this.isRickSignState = false;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForRichState
 * JD-Core Version:    0.7.0.1
 */