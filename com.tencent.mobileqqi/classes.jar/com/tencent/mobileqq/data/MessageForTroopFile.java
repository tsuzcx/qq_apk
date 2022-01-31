package com.tencent.mobileqq.data;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;

public class MessageForTroopFile
  extends ChatMessage
{
  public static final String TAG = MessageForTroopFile.class.getSimpleName();
  public String FromUin;
  public boolean bReported = false;
  public int bisID;
  public String dspFileName;
  public String dspFileSize;
  public String fileName;
  public long fileSize;
  public String url;
  public String uuid;
  
  public void doParse()
  {
    try
    {
      TroopFileData localTroopFileData = (TroopFileData)MessagePkgUtils.a(this.msgData);
      if (localTroopFileData != null)
      {
        this.url = localTroopFileData.fileUrl;
        this.dspFileSize = localTroopFileData.dspFileSize;
        this.dspFileName = localTroopFileData.dspFileName;
        this.bisID = localTroopFileData.bisID;
        this.uuid = localTroopFileData.uuid;
        this.fileSize = localTroopFileData.lfileSize;
        this.fileName = localTroopFileData.fileName;
        this.FromUin = localTroopFileData.FromUin;
      }
      this.msg = BaseApplicationImpl.getContext().getString(2131559232);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    serial();
  }
  
  public void serial()
  {
    TroopFileData localTroopFileData = new TroopFileData();
    localTroopFileData.fileUrl = this.url;
    localTroopFileData.fileName = this.fileName;
    localTroopFileData.dspFileName = this.dspFileName;
    localTroopFileData.dspFileSize = this.dspFileSize;
    localTroopFileData.bisID = this.bisID;
    localTroopFileData.uuid = this.uuid;
    localTroopFileData.lfileSize = this.fileSize;
    localTroopFileData.FromUin = this.FromUin;
    try
    {
      this.msgData = MessagePkgUtils.a(localTroopFileData);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTroopFile
 * JD-Core Version:    0.7.0.1
 */