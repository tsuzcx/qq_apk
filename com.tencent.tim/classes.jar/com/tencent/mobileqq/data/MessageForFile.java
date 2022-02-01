package com.tencent.mobileqq.data;

import acfp;
import com.tencent.mobileqq.persistence.notColumn;
import java.io.File;

public class MessageForFile
  extends ChatMessage
{
  private static final String TAG = "MessageForFile";
  public String fileName;
  public String filePath;
  public long fileSize;
  public String fileSizeString;
  public String fileType;
  @notColumn
  public long originalMsgUid;
  @notColumn
  public long originalTime;
  @notColumn
  public long originalmsgShseq;
  public int status;
  public String[] tempMsg;
  public String url;
  public String urlAtServer;
  
  public void doParse()
  {
    if ((this.msg != null) && (this.msg.length() > 0) && (this.msg.charAt(0) == '\026'))
    {
      this.tempMsg = this.msg.split("\\|");
      String str;
      if (this.tempMsg.length > 0)
      {
        str = this.tempMsg[0];
        if ((str != null) && (str.length() > 0))
        {
          int i = str.lastIndexOf(File.separator);
          if (i == -1) {
            break label94;
          }
          this.fileName = str.substring(i + 1);
        }
      }
      return;
      label94:
      this.fileName = str;
      return;
    }
    this.tempMsg = null;
  }
  
  public String getSummaryMsg()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(acfp.m(2131708144));
    if (this.fileName == null) {}
    for (String str = "";; str = this.fileName) {
      return str;
    }
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public void postRead()
  {
    try
    {
      super.postRead();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForFile
 * JD-Core Version:    0.7.0.1
 */