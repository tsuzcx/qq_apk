package com.tencent.qqmail.activity.readmail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.LinearLayout;
import com.tencent.qqmail.model.uidomain.SendMailInterAppsManager;
import com.tencent.qqmail.view.QMReadMailView;

class ReadMailFragment$62
  implements DialogInterface.OnDismissListener
{
  ReadMailFragment$62(ReadMailFragment paramReadMailFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (SendMailInterAppsManager.getInstance().hasFile())
    {
      ReadMailFragment.access$2400(this.this$0).getAttachBubbleView().setVisibility(0);
      ReadMailFragment.access$2400(this.this$0).setBubbleContent(SendMailInterAppsManager.getInstance().getFilePaths());
    }
    if ((ReadMailFragment.access$2400(this.this$0) != null) && (ReadMailFragment.access$2400(this.this$0).getAttachBubbleView() != null)) {
      ReadMailFragment.access$2400(this.this$0).getAttachBubbleView().setTag(2131363628, Boolean.valueOf(true));
    }
    this.this$0.resumeObserveScreenShot();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.62
 * JD-Core Version:    0.7.0.1
 */