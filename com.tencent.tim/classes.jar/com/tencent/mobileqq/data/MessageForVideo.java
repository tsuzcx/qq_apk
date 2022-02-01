package com.tencent.mobileqq.data;

import acfp;
import aqft;
import com.tencent.qphone.base.util.QLog;

public class MessageForVideo
  extends ChatMessage
{
  private static final String TAG = "MessageForVideo";
  public boolean isVideo;
  public String text;
  public int type;
  
  protected void doParse()
  {
    boolean bool2 = false;
    String[] arrayOfString;
    if (this.msg != null)
    {
      arrayOfString = this.msg.split("\\|");
      if ((arrayOfString == null) || (arrayOfString.length <= 0)) {
        break label92;
      }
      this.text = arrayOfString[0].trim();
      if ((arrayOfString == null) || (arrayOfString.length <= 1)) {
        break label230;
      }
    }
    for (;;)
    {
      try
      {
        this.type = Integer.parseInt(arrayOfString[1]);
        if ((arrayOfString == null) || (arrayOfString.length <= 3)) {
          break label286;
        }
        if (arrayOfString.length != 4) {
          break label238;
        }
        this.isVideo = "1".equals(arrayOfString[3]);
        return;
        arrayOfString = null;
        break;
        label92:
        this.text = "";
      }
      catch (Exception localException1)
      {
        if ((this.msg != null) && (this.msg.length() > 0) && (this.msg.charAt(0) == '\026')) {
          throw new RuntimeException("java.lang.NumberFormatException: Invalid int: " + arrayOfString[1] + " msg is " + this.msg);
        }
        this.type = 5;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MessageForVideo", 2, "java.lang.NumberFormatException: Invalid int: " + arrayOfString[1] + " msg byte " + aqft.pk(this.msg));
        continue;
      }
      label230:
      this.type = 5;
    }
    label238:
    if (arrayOfString.length > 5) {}
    for (;;)
    {
      try
      {
        bool1 = Boolean.parseBoolean(arrayOfString[5]);
        if (!bool1)
        {
          bool1 = bool2;
          if (!arrayOfString[0].contains(acfp.m(2131708178))) {}
        }
        else
        {
          bool1 = true;
        }
        this.isVideo = bool1;
        return;
      }
      catch (Exception localException2)
      {
        bool1 = false;
        continue;
      }
      label286:
      this.isVideo = true;
      return;
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForVideo
 * JD-Core Version:    0.7.0.1
 */