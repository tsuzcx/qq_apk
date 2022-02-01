package com.tencent.qqmail.activity.readmail;

import android.widget.Toast;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import rx.Subscriber;

class ReadMailFragment$124
  extends Subscriber<Void>
{
  ReadMailFragment$124(ReadMailFragment paramReadMailFragment, String paramString) {}
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable)
  {
    ReadMailFragment.access$4300(this.this$0);
    if ((paramThrowable instanceof QMCGIError))
    {
      paramThrowable = (QMCGIError)paramThrowable;
      if ((paramThrowable.appCode == -203) || (paramThrowable.appCode == -202) || (paramThrowable.appCode == -201) || (paramThrowable.appCode == -200))
      {
        ReadMailFragment.access$4400(this.this$0, paramThrowable.desp);
        return;
      }
    }
    Toast.makeText(this.this$0.getActivity(), this.this$0.getString(2131695956), 0).show();
  }
  
  public void onNext(Void paramVoid)
  {
    ReadMailFragment.access$000(this.this$0).setAppleIdVerifyCode(this.val$inputStr);
    QMMailManager.sharedInstance().loadRemoteMail(ReadMailFragment.access$000(this.this$0), ReadMailFragment.access$3000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.124
 * JD-Core Version:    0.7.0.1
 */