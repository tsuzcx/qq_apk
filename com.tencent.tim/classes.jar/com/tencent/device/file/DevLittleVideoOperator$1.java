package com.tencent.device.file;

import acfp;
import akxe;
import anaz;
import angt;
import aqiw;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import mqq.app.MobileQQ;
import syw;
import sza;
import szd;
import szy;
import xya;

public class DevLittleVideoOperator$1
  implements Runnable
{
  public DevLittleVideoOperator$1(sza paramsza, angt paramangt) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = null;
    if ((this.a.message instanceof MessageForDevLittleVideo)) {
      localMessageRecord = (MessageRecord)this.a.message;
    }
    if (localMessageRecord == null) {}
    Object localObject;
    label300:
    label322:
    label490:
    do
    {
      do
      {
        return;
      } while (!(localMessageRecord instanceof MessageForDevLittleVideo));
      boolean bool1 = aqiw.isNetworkAvailable(this.this$0.mApp.getApplication().getApplicationContext());
      localObject = (MessageForDevLittleVideo)localMessageRecord;
      int i;
      long l;
      if (bool1)
      {
        i = 1002;
        ((MessageForDevLittleVideo)localObject).videoFileStatus = i;
        ((MessageForDevLittleVideo)localObject).videoFileProgress = 0;
        ((MessageForDevLittleVideo)localObject).serial();
        this.this$0.mApp.b().c(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq, localMessageRecord.msgData);
        if (!bool1) {
          break label490;
        }
        l = System.currentTimeMillis();
        if (!this.this$0.gt(localMessageRecord.frienduin)) {
          break label322;
        }
        i = ((syw)this.this$0.mApp.getBusinessHandler(51)).a(Long.parseLong(((MessageForDevLittleVideo)localObject).frienduin), ((MessageForDevLittleVideo)localObject).videoFileName, ((MessageForDevLittleVideo)localObject).videoFileSize, ((MessageForDevLittleVideo)localObject).videoFileTime, ((MessageForDevLittleVideo)localObject).mThumbFilePath);
        if (i == 0) {
          break label300;
        }
        akxe.M(this.this$0.logTag, this.this$0.bUB, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
        xya.b(i, (MessageRecord)localObject);
      }
      for (;;)
      {
        akxe.M(this.this$0.logTag, this.this$0.bUB, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
        return;
        i = 1005;
        break;
        akxe.a(this.this$0.logTag, this.this$0.bUB, "doSendShortVideo failed");
        continue;
        ((szy)this.this$0.mApp.getBusinessHandler(49)).a().a(szy.aIm, ((MessageForDevLittleVideo)localObject).videoFileName, Long.parseLong(((MessageForDevLittleVideo)localObject).frienduin), localMessageRecord.uniseq, localMessageRecord.istroop, 0);
        bool1 = ((syw)this.this$0.mApp.getBusinessHandler(51)).a(Long.parseLong(localMessageRecord.frienduin)).booleanValue();
        boolean bool2 = SettingCloneUtil.readValue(this.this$0.mApp.getApp(), localMessageRecord.frienduin, null, "devicemsg_showvideotips_first", true);
        if ((bool1) && (bool2))
        {
          ((szy)this.this$0.mApp.getBusinessHandler(49)).a(localMessageRecord.frienduin, acfp.m(2131705038), anaz.gQ(), true, false, true);
          SettingCloneUtil.writeValue(this.this$0.mApp.getApp(), localMessageRecord.frienduin, null, "devicemsg_showvideotips_first", false);
        }
      }
      localObject = ((szy)this.this$0.mApp.getBusinessHandler(49)).a();
    } while (localObject == null);
    ((szd)localObject).a(localMessageRecord, Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.device.file.DevLittleVideoOperator.1
 * JD-Core Version:    0.7.0.1
 */