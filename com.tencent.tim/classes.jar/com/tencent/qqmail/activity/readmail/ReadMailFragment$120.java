package com.tencent.qqmail.activity.readmail;

import android.widget.Toast;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import rx.Subscriber;

class ReadMailFragment$120
  extends Subscriber<Integer>
{
  ReadMailFragment$120(ReadMailFragment paramReadMailFragment) {}
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable)
  {
    String str2 = "发送验证码失败, 请稍候再试";
    String str1 = str2;
    if ((paramThrowable instanceof QMCGIError))
    {
      paramThrowable = (QMCGIError)paramThrowable;
      if ((paramThrowable.appCode != -101) && (paramThrowable.appCode != -102) && (paramThrowable.appCode != -110) && (paramThrowable.appCode != -111))
      {
        str1 = str2;
        if (paramThrowable.appCode != -112) {}
      }
      else
      {
        str1 = paramThrowable.desp;
      }
    }
    Toast.makeText(this.this$0.getActivity(), str1, 0).show();
  }
  
  public void onNext(Integer paramInteger)
  {
    if (paramInteger.intValue() == 0)
    {
      ReadMailFragment.access$000(this.this$0).getStatus().setLoaded(false);
      ReadMailFragment.access$000(this.this$0).getStatus().setAttrAppleIdLoad(true);
      QMMailManager.sharedInstance().loadRemoteMail(ReadMailFragment.access$000(this.this$0), ReadMailFragment.access$3000(this.this$0));
      return;
    }
    ReadMailFragment.access$4400(this.this$0, this.this$0.getString(2131721665));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.120
 * JD-Core Version:    0.7.0.1
 */