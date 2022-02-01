package com.tencent.qqmail.activity.readmail;

import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import org.apache.commons.lang3.StringUtils;

class ReadMailFragment$99$1
  implements Runnable
{
  ReadMailFragment$99$1(ReadMailFragment.99 param99, Object paramObject) {}
  
  public void run()
  {
    if ((this.val$data != null) && (StringUtils.equals(this.val$data.toString(), "" + ReadMailFragment.access$400(this.this$1.this$0))))
    {
      QMNotification.unregistNotification("save_mail_as_note_done", this.this$1.this$0.mSaveMailSucc);
      Toast.makeText(QMApplicationContext.sharedInstance(), this.this$1.this$0.getString(2131718956), 0).show();
      QMLog.log(6, "ReadMailFragment", "savemailasnote ok");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.99.1
 * JD-Core Version:    0.7.0.1
 */