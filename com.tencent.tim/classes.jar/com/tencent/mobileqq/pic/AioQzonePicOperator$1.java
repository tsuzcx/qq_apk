package com.tencent.mobileqq.pic;

import akwu;
import akwv;
import akxe;
import akxq;
import akxy;
import akyj;
import android.text.TextUtils;
import aooi;
import aool;
import aool.d;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.qphone.base.util.QLog;

public class AioQzonePicOperator$1
  implements Runnable
{
  public AioQzonePicOperator$1(akwu paramakwu, akxy paramakxy, akxq paramakxq) {}
  
  public void run()
  {
    this.this$0.mApp.getHwEngine().preConnect();
    ??? = this.a;
    Object localObject1 = new CompressInfo(((akxy)???).b.thumbPath, 0);
    akyj.c((CompressInfo)localObject1);
    if (((CompressInfo)localObject1).destPath != null)
    {
      ((akxy)???).thumbPath = ((CompressInfo)localObject1).destPath;
      ((akxy)???).thumbWidth = ((CompressInfo)localObject1).dpx;
      ((akxy)???).thumbHeight = ((CompressInfo)localObject1).dpy;
    }
    if ((((akxy)???).isBlessPic) && (((akxy)???).message != null)) {}
    for (localObject1 = (MessageForPic)((akxy)???).message; localObject1 == null; localObject1 = this.this$0.a((akxy)???))
    {
      akxe.b(this.this$0.logTag, "doSendPic", "error, mr==null, return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "doSendPic, entrance: " + ((MessageForPic)localObject1).msgVia);
    }
    if (MessageForPic.class.isInstance(localObject1))
    {
      if (this.d.b != null)
      {
        ((MessageForPic)localObject1).picExtraData = this.d.b;
        ??? = this.d.b;
        if (((PicMessageExtraData)???).stickerInfo != null) {
          ((MessageRecord)localObject1).saveExtInfoToExtStr("sticker_info", ((PicMessageExtraData)???).stickerInfo.toJsonString());
        }
        if (!TextUtils.isEmpty(((MessageRecord)localObject1).getExtInfoFromExtStr("sticker_info")))
        {
          EmojiStickerManager.a((MessageRecord)localObject1, null);
          EmojiStickerManager.a().aj((MessageRecord)localObject1);
        }
      }
      if (!((akxy)???).isQzonePic) {
        akwv.p((MessageForPic)localObject1);
      }
    }
    if (this.a.cuZ) {
      synchronized (this.a)
      {
        this.a.picExtraObject = localObject1;
        this.a.notifyAll();
        akxe.a(this.this$0.logTag, "doSendPic ", "PresendStatus: destPath:" + this.a.localPath + ",uuid:" + this.this$0.bUB + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        if (this.a.picExtraFlag == 3)
        {
          akxe.M(this.this$0.logTag, this.this$0.bUB, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          akxe.a(this.this$0.logTag, "doSendPic", "PresendStatus: destPath:" + this.a.localPath + ",uuid:" + this.this$0.bUB + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          return;
        }
      }
    }
    this.this$0.F = localObject2;
    long l = System.currentTimeMillis();
    ??? = new aool();
    ((aool)???).mSelfUin = this.this$0.mApp.getAccount();
    ((aool)???).mPeerUin = localObject2.frienduin;
    ((aool)???).cmn = localObject2.senderuin;
    ((aool)???).mUinType = localObject2.istroop;
    ((aool)???).mFileType = 1;
    ((aool)???).mUniseq = localObject2.uniseq;
    ((aool)???).cNy = true;
    ((aool)???).mBusiType = this.a.busiType;
    ((aool)???).dQ = this.a.localPath;
    ((aool)???).mMd5 = this.a.md5;
    ??? = new aool.d();
    if (this.a.getProtocolType() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((aool.d)???).cNJ = bool;
      ((aool)???).en = ???;
      ((aool)???).b = this.this$0;
      ((aool)???).F = this.this$0.F;
      ((aool)???).cND = this.a.cuZ;
      ((aool)???).cvb = this.a.cvb;
      if (this.d.busiType == 1045)
      {
        ((aool)???).isQzonePic = this.a.isQzonePic;
        ((aool)???).c = this.a.b;
      }
      if (!this.a.cuZ) {
        break label1074;
      }
      synchronized (this.a)
      {
        if (!this.a.cva) {
          break;
        }
        akxe.M(this.this$0.logTag, this.this$0.bUB, "PresendPic doSendPic cancel transferAsync!", "");
        akxe.a(this.this$0.logTag, "doSendPic ", "PresendStatus: destPath:" + this.a.localPath + ",uuid:" + this.this$0.bUB + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
        return;
      }
    }
    akxe.M(this.this$0.logTag, this.this$0.bUB, "PresendPic doSendPic start transferAsync!", "");
    this.this$0.mApp.a().a((aool)???);
    akxe.a(this.this$0.logTag, "doSendPic ", "PresendStatus: destPath:" + this.a.localPath + ",uuid:" + this.this$0.bUB + ",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
    for (;;)
    {
      akxe.M(this.this$0.logTag, this.this$0.bUB, "sendReq", "cost:" + (System.currentTimeMillis() - l));
      if ((this.a.cuY) && (!this.a.cuZ))
      {
        akxe.M(this.this$0.logTag, this.this$0.bUB, "sendPic", "@#addMsg");
        this.this$0.ar(localMessageRecord);
      }
      akxe.M(this.this$0.logTag, this.this$0.bUB, "getSendTask.start", "");
      return;
      label1074:
      this.this$0.mApp.a().a((aool)???);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.AioQzonePicOperator.1
 * JD-Core Version:    0.7.0.1
 */