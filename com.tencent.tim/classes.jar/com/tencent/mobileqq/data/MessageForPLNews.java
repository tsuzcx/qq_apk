package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForPLNews
  extends ChatMessage
{
  public static final String TAG = "MessageForPLNews";
  public int bgColor;
  public String cover;
  public String text;
  public long ts;
  
  public MessageForPLNews()
  {
    this.msgtype = -2060;
    this.mNeedTimeStamp = false;
  }
  
  protected void doParse()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.msg);
      this.text = localJSONObject.optString("text");
      this.bgColor = localJSONObject.optInt("bgColor");
      this.cover = localJSONObject.optString("cover");
      this.ts = localJSONObject.optLong("ts");
      if (QLog.isDevelopLevel()) {
        QLog.i("MessageForPLNews", 4, "doParse:" + this.msg);
      }
      this.isread = true;
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MessageForPLNews", 2, "doParse", localJSONException);
        }
      }
    }
  }
  
  public boolean msgEquals(MessageForPLNews paramMessageForPLNews)
  {
    return paramMessageForPLNews.uniseq == this.uniseq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPLNews
 * JD-Core Version:    0.7.0.1
 */