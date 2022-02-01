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

public class BasePicOprerator$3
  implements Runnable
{
  public BasePicOprerator$3(akwv paramakwv, akxq paramakxq) {}
  
  public void run()
  {
    akxm localakxm = this.f.c;
    akxe.M(this.this$0.logTag, this.this$0.bUB, "doForward", "start");
    if (this.this$0.F == null)
    {
      localakxm.gT("doForward", "rec==null");
      this.this$0.a(4, localakxm.jdField_b_of_type_Akxn$a);
      return;
    }
    Object localObject1 = (MessageForPic)this.this$0.F;
    ((MessageForPic)localObject1).path = localakxm.jdField_b_of_type_Akxy.localPath;
    akwv.a(this.this$0, this.f, ((MessageForPic)localObject1).uniseq);
    if (this.f.b != null) {
      ((MessageForPic)localObject1).picExtraData = this.f.b;
    }
    Object localObject2 = new CompressInfo(((MessageForPic)localObject1).path, 0);
    akyj.c((CompressInfo)localObject2);
    aool.d locald;
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
      localObject2 = new aool();
      ((aool)localObject2).mSelfUin = this.this$0.mApp.getAccount();
      ((aool)localObject2).mPeerUin = this.this$0.F.frienduin;
      ((aool)localObject2).cmn = this.this$0.F.senderuin;
      ((aool)localObject2).mUinType = this.this$0.F.istroop;
      ((aool)localObject2).mFileType = 1;
      ((aool)localObject2).mUniseq = this.this$0.F.uniseq;
      ((aool)localObject2).cNy = true;
      ((aool)localObject2).mBusiType = localakxm.jdField_b_of_type_Akxy.busiType;
      ((aool)localObject2).dQ = localakxm.jdField_b_of_type_Akxy.localPath;
      locald = new aool.d();
      if (localakxm.jdField_b_of_type_Akxy.dpK != 1) {
        break label486;
      }
    }
    label486:
    for (boolean bool = true;; bool = false)
    {
      locald.cNJ = bool;
      ((aool)localObject2).F = ((MessageRecord)localObject1);
      ((aool)localObject2).en = locald;
      ((aool)localObject2).b = this.this$0;
      localObject1 = this.this$0.mApp.a();
      ((aooi)localObject1).oy(((aool)localObject2).mPeerUin + ((aool)localObject2).mUniseq);
      ((aooi)localObject1).a((aool)localObject2);
      this.this$0.b(this.this$0.F, localakxm.jdField_b_of_type_Akxy.aeM);
      akxe.M(this.this$0.logTag, this.this$0.bUB, "doForward", "end");
      return;
      ((MessageForPic)localObject1).thumbMsgUrl = ((CompressInfo)localObject2).destPath;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator.3
 * JD-Core Version:    0.7.0.1
 */