package com.tencent.mobileqq.avatar.dynamicavatar;

import acfp;
import advr;
import adwc;
import aqep;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;

class SelectCoverActivity$CoverTransProcessorHandler$2
  implements Runnable
{
  SelectCoverActivity$CoverTransProcessorHandler$2(SelectCoverActivity.a parama, SelectCoverActivity paramSelectCoverActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = this.a.a.bvK;
    File localFile = new File(str);
    if ((localFile != null) && (localFile.exists()))
    {
      adwc.a(this.val$app, str, 38, this.a.awN, 100);
      aqep.Us(str);
      return;
    }
    SelectCoverActivity.a(this.a, 2, acfp.m(2131714191), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.CoverTransProcessorHandler.2
 * JD-Core Version:    0.7.0.1
 */