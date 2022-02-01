package com.tencent.device.msg.data;

import acfp;
import aczw;
import aqgv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import java.io.Serializable;

public class MessageForDevLittleVideo
  extends MessageForShortVideo
{
  public String coverkey2;
  public String fileKey2;
  public String thumbFileKey;
  public String videoFileKey;
  
  public void doParse()
  {
    try
    {
      DevLittleVideoMsgSerial localDevLittleVideoMsgSerial = (DevLittleVideoMsgSerial)aczw.c(this.msgData);
      if (localDevLittleVideoMsgSerial != null)
      {
        this.thumbFileKey = localDevLittleVideoMsgSerial.thumbFileKey;
        this.videoFileKey = localDevLittleVideoMsgSerial.videoFileKey;
        this.fileKey2 = localDevLittleVideoMsgSerial.fileKey2;
        this.coverkey2 = localDevLittleVideoMsgSerial.coverKey2;
        this.videoFileSize = localDevLittleVideoMsgSerial.videoFileSize;
        this.videoFileFormat = localDevLittleVideoMsgSerial.videoFileFormat;
        this.videoFileTime = localDevLittleVideoMsgSerial.videoFileTime;
        this.uuid = localDevLittleVideoMsgSerial.uuid;
        this.md5 = localDevLittleVideoMsgSerial.md5;
        this.videoFileName = localDevLittleVideoMsgSerial.videoFileName;
        this.thumbWidth = localDevLittleVideoMsgSerial.thumbWidth;
        this.thumbHeight = localDevLittleVideoMsgSerial.thumbHeight;
        this.thumbMD5 = localDevLittleVideoMsgSerial.thumbMD5;
        this.mThumbFilePath = localDevLittleVideoMsgSerial.mThumbFilePath;
        this.mVideoFileSourceDir = localDevLittleVideoMsgSerial.mVideoFileSourceDir;
        this.videoFileStatus = localDevLittleVideoMsgSerial.videoFileStatus;
        this.videoFileProgress = localDevLittleVideoMsgSerial.videoFileProgress;
        this.fileType = localDevLittleVideoMsgSerial.fileType;
        this.fileSource = localDevLittleVideoMsgSerial.fileSource;
        this.lastModified = localDevLittleVideoMsgSerial.lastModified;
        this.thumbFileSize = localDevLittleVideoMsgSerial.thumbFileSize;
        this.busiType = localDevLittleVideoMsgSerial.busiType;
        this.fromChatType = localDevLittleVideoMsgSerial.fromChatType;
        this.toChatType = localDevLittleVideoMsgSerial.toChatType;
        this.uiOperatorFlag = localDevLittleVideoMsgSerial.uiOperatorFlag;
        this.issend = localDevLittleVideoMsgSerial.issend;
        this.senderuin = localDevLittleVideoMsgSerial.senderuin;
      }
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
  
  public String getSummary()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (isSendFromLocal()) {
        return acfp.m(2131708156);
      }
      return aqgv.b((QQAppInterface)localObject, this.senderuin, true) + acfp.m(2131708160);
    }
    return null;
  }
  
  public void serial()
  {
    DevLittleVideoMsgSerial localDevLittleVideoMsgSerial = new DevLittleVideoMsgSerial(null);
    localDevLittleVideoMsgSerial.thumbFileKey = this.thumbFileKey;
    localDevLittleVideoMsgSerial.videoFileKey = this.videoFileKey;
    localDevLittleVideoMsgSerial.fileKey2 = this.fileKey2;
    localDevLittleVideoMsgSerial.coverKey2 = this.coverkey2;
    localDevLittleVideoMsgSerial.videoFileSize = this.videoFileSize;
    localDevLittleVideoMsgSerial.videoFileFormat = this.videoFileFormat;
    localDevLittleVideoMsgSerial.videoFileTime = this.videoFileTime;
    localDevLittleVideoMsgSerial.uuid = this.uuid;
    localDevLittleVideoMsgSerial.md5 = this.md5;
    localDevLittleVideoMsgSerial.videoFileName = this.videoFileName;
    localDevLittleVideoMsgSerial.thumbWidth = this.thumbWidth;
    localDevLittleVideoMsgSerial.thumbHeight = this.thumbHeight;
    localDevLittleVideoMsgSerial.thumbMD5 = this.thumbMD5;
    localDevLittleVideoMsgSerial.mThumbFilePath = this.mThumbFilePath;
    localDevLittleVideoMsgSerial.mVideoFileSourceDir = this.mVideoFileSourceDir;
    localDevLittleVideoMsgSerial.videoFileStatus = this.videoFileStatus;
    localDevLittleVideoMsgSerial.videoFileProgress = this.videoFileProgress;
    localDevLittleVideoMsgSerial.fileType = this.fileType;
    localDevLittleVideoMsgSerial.fileSource = this.fileSource;
    localDevLittleVideoMsgSerial.lastModified = this.lastModified;
    localDevLittleVideoMsgSerial.thumbFileSize = this.thumbFileSize;
    localDevLittleVideoMsgSerial.busiType = this.busiType;
    localDevLittleVideoMsgSerial.fromChatType = this.fromChatType;
    localDevLittleVideoMsgSerial.toChatType = this.toChatType;
    localDevLittleVideoMsgSerial.uiOperatorFlag = this.uiOperatorFlag;
    localDevLittleVideoMsgSerial.issend = this.issend;
    localDevLittleVideoMsgSerial.senderuin = this.senderuin;
    try
    {
      this.msgData = aczw.b(localDevLittleVideoMsgSerial);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  static class DevLittleVideoMsgSerial
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public int busiType;
    public String coverKey2;
    public String fileKey2;
    public String fileSource;
    public int fileType;
    public int fromChatType = -1;
    public int issend;
    public long lastModified;
    public String mThumbFilePath;
    public String mVideoFileSourceDir;
    public String md5;
    public String senderuin;
    public String thumbFileKey;
    public int thumbFileSize;
    public int thumbHeight;
    public String thumbMD5;
    public int thumbWidth;
    public int toChatType = -1;
    public int uiOperatorFlag;
    public String uuid;
    public int videoFileFormat;
    public String videoFileKey;
    public String videoFileName;
    public int videoFileProgress;
    public int videoFileSize;
    public int videoFileStatus;
    public int videoFileTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.device.msg.data.MessageForDevLittleVideo
 * JD-Core Version:    0.7.0.1
 */