package com.tencent.device.msg.data;

import acfp;
import aczw;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.Serializable;

public class MessageForDevPtt
  extends MessageForPtt
{
  public int channeltype;
  public long fileSessionId;
  public String strFileKey2;
  
  public void doParse()
  {
    super.doParse();
    if ((this.urlAtServer != null) && (!TextUtils.isEmpty(this.urlAtServer)) && (this.msgTime != 0L)) {}
    for (;;)
    {
      return;
      try
      {
        MessageForDevPttSerial localMessageForDevPttSerial = (MessageForDevPttSerial)aczw.c(this.msgData);
        if (localMessageForDevPttSerial == null) {
          continue;
        }
        this.url = localMessageForDevPttSerial.url;
        this.fileSize = localMessageForDevPttSerial.fileSize;
        this.itemType = localMessageForDevPttSerial.itemType;
        this.isReadPtt = localMessageForDevPttSerial.isReadPtt;
        this.urlAtServer = localMessageForDevPttSerial.urlAtServer;
        this.md5 = localMessageForDevPttSerial.md5;
        this.storageSource = localMessageForDevPttSerial.storageSource;
        this.subVersion = localMessageForDevPttSerial.subVersion;
        this.isReport = localMessageForDevPttSerial.isReport;
        this.sttAbility = localMessageForDevPttSerial.sttAbility;
        this.groupFileID = localMessageForDevPttSerial.groupFileID;
        this.sttText = localMessageForDevPttSerial.sttText;
        this.longPttVipFlag = localMessageForDevPttSerial.longPttVipFlag;
        this.expandStt = localMessageForDevPttSerial.expandStt;
        this.groupFileKeyStr = localMessageForDevPttSerial.groupFileKeyStr;
        this.msgTime = localMessageForDevPttSerial.msgTime;
        this.msgRecTime = localMessageForDevPttSerial.msgRecTime;
        this.voiceType = localMessageForDevPttSerial.voiceType;
        this.voiceLength = localMessageForDevPttSerial.voiceLength;
        this.voiceChangeFlag = localMessageForDevPttSerial.voiceChangeFlag;
        this.busiType = localMessageForDevPttSerial.busiType;
        this.directUrl = localMessageForDevPttSerial.directUrl;
        this.fullLocalPath = localMessageForDevPttSerial.fullLocalPath;
        this.extFlag = localMessageForDevPttSerial.extFlag;
        this.channeltype = localMessageForDevPttSerial.channeltype;
        this.strFileKey2 = localMessageForDevPttSerial.strFileKey2;
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
  }
  
  public String getSummary()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (this.fileSize > 0L)
      {
        if (isSendFromLocal()) {
          return ((QQAppInterface)localObject).getApp().getString(2131692316);
        }
        return acfp.m(2131708182);
      }
      if (this.fileSize == -1L)
      {
        if (isSendFromLocal()) {
          return ((QQAppInterface)localObject).getApp().getString(2131692316);
        }
        return acfp.m(2131708153);
      }
      return acfp.m(2131708154);
    }
    return null;
  }
  
  public void serial()
  {
    MessageForDevPttSerial localMessageForDevPttSerial = new MessageForDevPttSerial(null);
    localMessageForDevPttSerial.url = this.url;
    localMessageForDevPttSerial.fileSize = this.fileSize;
    localMessageForDevPttSerial.itemType = this.itemType;
    localMessageForDevPttSerial.isReadPtt = this.isReadPtt;
    localMessageForDevPttSerial.urlAtServer = this.urlAtServer;
    localMessageForDevPttSerial.md5 = this.md5;
    localMessageForDevPttSerial.storageSource = this.storageSource;
    localMessageForDevPttSerial.subVersion = this.subVersion;
    localMessageForDevPttSerial.isReport = this.isReport;
    localMessageForDevPttSerial.sttAbility = this.sttAbility;
    localMessageForDevPttSerial.groupFileID = this.groupFileID;
    localMessageForDevPttSerial.sttText = this.sttText;
    localMessageForDevPttSerial.longPttVipFlag = this.longPttVipFlag;
    localMessageForDevPttSerial.expandStt = this.expandStt;
    localMessageForDevPttSerial.groupFileKeyStr = this.groupFileKeyStr;
    localMessageForDevPttSerial.msgTime = this.msgTime;
    localMessageForDevPttSerial.msgRecTime = this.msgRecTime;
    localMessageForDevPttSerial.voiceType = this.voiceType;
    localMessageForDevPttSerial.voiceLength = this.voiceLength;
    localMessageForDevPttSerial.voiceChangeFlag = this.voiceChangeFlag;
    localMessageForDevPttSerial.busiType = this.busiType;
    localMessageForDevPttSerial.directUrl = this.directUrl;
    localMessageForDevPttSerial.fullLocalPath = this.fullLocalPath;
    localMessageForDevPttSerial.extFlag = this.extFlag;
    localMessageForDevPttSerial.channeltype = this.channeltype;
    localMessageForDevPttSerial.strFileKey2 = this.strFileKey2;
    try
    {
      this.msgData = aczw.b(localMessageForDevPttSerial);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  static class MessageForDevPttSerial
    implements Serializable
  {
    public int busiType;
    public int channeltype;
    public String directUrl;
    public boolean expandStt;
    public long extFlag;
    public long fileSize;
    public String fullLocalPath;
    public long groupFileID;
    public String groupFileKeyStr;
    public boolean isReadPtt;
    public int isReport;
    public int itemType;
    public int longPttVipFlag;
    public String md5;
    public long msgRecTime;
    public long msgTime;
    public String storageSource;
    public String strFileKey2;
    public int sttAbility;
    public String sttText;
    public int subVersion;
    public String url;
    public String urlAtServer;
    public int voiceChangeFlag;
    public int voiceLength;
    public int voiceType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.device.msg.data.MessageForDevPtt
 * JD-Core Version:    0.7.0.1
 */