package com.tencent.biz.pubaccount.readinjoy.comment;

import android.support.v4.app.FragmentActivity;
import aojg;
import aooi;
import aook;
import aool;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ReadInJoyCommentComponentFragment$3
  implements Runnable
{
  ReadInJoyCommentComponentFragment$3(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment, String paramString) {}
  
  public void run()
  {
    if (!new File(this.val$path).exists())
    {
      this.this$0.aAt();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "startUploadPic file not exist, path=" + this.val$path);
      }
      return;
    }
    aooi localaooi = ReadInJoyCommentComponentFragment.a(this.this$0).app.a();
    this.this$0.a.addFilter(new Class[] { aojg.class });
    localaooi.a(this.this$0.a);
    aool localaool = new aool();
    localaool.cNy = true;
    localaool.dOM = 10;
    localaool.dQ = this.val$path;
    localaool.mUniseq = ((Math.random() * 1000000.0D));
    localaool.mPeerUin = "0";
    localaool.mFileType = 24;
    localaool.ckW = "KandianUGCPicUpload";
    localaooi.a(localaool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment.3
 * JD-Core Version:    0.7.0.1
 */