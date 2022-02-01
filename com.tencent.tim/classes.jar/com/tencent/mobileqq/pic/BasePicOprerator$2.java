package com.tencent.mobileqq.pic;

import akwv;
import akxe;
import akxm;
import akxq;
import akxy;
import akyj;
import anof;
import aooi;
import aool;
import aool.d;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;

public class BasePicOprerator$2
  implements Runnable
{
  public BasePicOprerator$2(akwv paramakwv, akxm paramakxm, akxq paramakxq) {}
  
  public void run()
  {
    akxe.M(this.this$0.logTag, this.this$0.bUB, "doFastForward", "start");
    if (this.this$0.F == null)
    {
      this.a.gT("doFastForward", "rec==null");
      this.this$0.a(4, this.a.jdField_b_of_type_Akxn$a);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.F;
    ((MessageForPic)localObject1).path = this.a.jdField_b_of_type_Akxy.localPath;
    akwv.a(this.this$0, this.f, ((MessageForPic)localObject1).uniseq);
    if (this.f.b != null) {
      ((MessageForPic)localObject1).picExtraData = this.f.b;
    }
    Object localObject2 = new CompressInfo(((MessageForPic)localObject1).path, 0);
    akyj.c((CompressInfo)localObject2);
    if (((CompressInfo)localObject2).destPath != null)
    {
      if (anof.ayA())
      {
        ((MessageForPic)localObject1).bigThumbMsgUrl = ((CompressInfo)localObject2).destPath;
        ((MessageForPic)localObject1).thumbWidth = ((CompressInfo)localObject2).dpx;
        ((MessageForPic)localObject1).thumbHeight = ((CompressInfo)localObject2).dpy;
      }
    }
    else
    {
      ((MessageForPic)localObject1).serial();
      this.this$0.mApp.b().c(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq, ((MessageForPic)localObject1).msgData);
      localObject1 = new aool();
      ((aool)localObject1).mSelfUin = this.this$0.mApp.getAccount();
      ((aool)localObject1).mPeerUin = this.this$0.F.frienduin;
      ((aool)localObject1).cmn = this.this$0.F.senderuin;
      ((aool)localObject1).mUinType = this.this$0.F.istroop;
      ((aool)localObject1).mFileType = 1;
      ((aool)localObject1).mUniseq = this.this$0.F.uniseq;
      ((aool)localObject1).cNy = true;
      ((aool)localObject1).mBusiType = this.a.jdField_b_of_type_Akxy.busiType;
      ((aool)localObject1).dQ = this.a.jdField_b_of_type_Akxy.localPath;
      localObject2 = new aool.d();
      if (this.a.jdField_b_of_type_Akxy.dpK != 1) {
        break label462;
      }
    }
    label462:
    for (boolean bool = true;; bool = false)
    {
      ((aool.d)localObject2).cNJ = bool;
      ((aool)localObject1).en = localObject2;
      ((aool)localObject1).b = this.this$0;
      ((aool)localObject1).cNC = true;
      if ((this.a.jdField_b_of_type_Akxy.md5 != null) && (this.a.jdField_b_of_type_Akxy.dpI != 0) && (this.a.jdField_b_of_type_Akxy.dpJ != 0) && (this.a.jdField_b_of_type_Akxy.aeI != 0L)) {
        break label467;
      }
      this.a.gT("doFastForward", "upInfo uncomplete!");
      this.this$0.a(4, this.a.jdField_b_of_type_Akxn$a);
      return;
      ((MessageForPic)localObject1).thumbMsgUrl = ((CompressInfo)localObject2).destPath;
      break;
    }
    label467:
    ((aool)localObject1).mMd5 = this.a.jdField_b_of_type_Akxy.md5;
    akxe.M(this.this$0.logTag, this.this$0.bUB, "doFastForward", " Get width/height/filesize from UploadInfo");
    ((aool)localObject1).dQJ = this.a.jdField_b_of_type_Akxy.dpI;
    ((aool)localObject1).dQK = this.a.jdField_b_of_type_Akxy.dpJ;
    ((aool)localObject1).aqp = this.a.jdField_b_of_type_Akxy.aeI;
    localObject2 = this.this$0.mApp.a();
    ((aooi)localObject2).oy(((aool)localObject1).mPeerUin + ((aool)localObject1).mUniseq);
    ((aooi)localObject2).a((aool)localObject1);
    this.this$0.b(this.this$0.F, this.a.jdField_b_of_type_Akxy.aeM);
    akxe.M(this.this$0.logTag, this.this$0.bUB, "doFastForward", "end, req.mFastForwardWidth = " + ((aool)localObject1).dQJ + ",req.mFastForwardHeight = " + ((aool)localObject1).dQK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator.2
 * JD-Core Version:    0.7.0.1
 */