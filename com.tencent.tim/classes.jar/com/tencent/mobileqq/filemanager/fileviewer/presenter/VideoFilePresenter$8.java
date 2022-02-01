package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import acfp;
import aguk;
import agxa;
import agxg;
import agyc;
import android.app.Activity;
import aqha;
import aqju;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class VideoFilePresenter$8
  implements Runnable
{
  public void run()
  {
    if ((this.cYQ != -6101) && (this.cYQ != -7003) && (this.cYQ != 201)) {
      this.this$0.jdField_a_of_type_Agyc.fR(this.this$0.jdField_a_of_type_Aguk.getFilePath(), this.this$0.mContext.getString(2131694159));
    }
    label301:
    for (;;)
    {
      return;
      Object localObject;
      if ((this.cYQ == -6101) || (this.cYQ == -7003))
      {
        localObject = this.this$0.mContext.getString(2131694128);
        this.this$0.jdField_a_of_type_Aguk.l(this.cYQ, this.val$msg);
      }
      for (;;)
      {
        if (BaseActivity.sTopActivity == null) {
          break label301;
        }
        localObject = aqha.a(BaseActivity.sTopActivity, 230, "", (CharSequence)localObject, null, acfp.m(2131716391), new agxg(this), null);
        if (((aqju)localObject).isShowing()) {
          break;
        }
        ((aqju)localObject).show();
        return;
        if (this.cYQ == 201)
        {
          if (!this.this$0.jdField_a_of_type_Aguk.cl()) {
            localObject = this.this$0.mContext.getString(2131694160);
          } else {
            this.this$0.jdField_a_of_type_Agyc.fR(this.this$0.jdField_a_of_type_Aguk.getFilePath(), this.this$0.mContext.getString(2131694159));
          }
        }
        else
        {
          String str = this.this$0.mContext.getString(2131694159);
          localObject = str;
          if (QLog.isColorLevel())
          {
            QLog.i("FileBrowserPresenter<FileAssistant>", 2, "can not handle video error. rc=[" + this.cYQ + "]  msg=[" + this.val$msg + "]");
            localObject = str;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.8
 * JD-Core Version:    0.7.0.1
 */