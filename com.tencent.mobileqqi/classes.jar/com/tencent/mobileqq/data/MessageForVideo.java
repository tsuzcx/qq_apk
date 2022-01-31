package com.tencent.mobileqq.data;

public class MessageForVideo
  extends ChatMessage
{
  private static final String TAG = "MessageForVideo";
  public boolean isVideo;
  public String text;
  public int type;
  
  protected void doParse()
  {
    boolean bool = true;
    String[] arrayOfString = this.msg.split("\\|");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      this.text = arrayOfString[0].trim();
      if ((arrayOfString == null) || (arrayOfString.length <= 1)) {}
    }
    for (;;)
    {
      try
      {
        this.type = Integer.parseInt(arrayOfString[1]);
        if ((arrayOfString == null) || (arrayOfString.length <= 3)) {
          break label164;
        }
        if ("1".equals(arrayOfString[3]))
        {
          this.isVideo = bool;
          return;
          this.text = "";
        }
      }
      catch (Exception localException)
      {
        if ((this.msg == null) || (this.msg.length() <= 0) || (this.msg.charAt(0) != '\026')) {
          continue;
        }
        throw new RuntimeException("java.lang.NumberFormatException: Invalid int: " + arrayOfString[1] + " msg is " + this.msg);
      }
      bool = false;
    }
    label164:
    this.isVideo = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForVideo
 * JD-Core Version:    0.7.0.1
 */