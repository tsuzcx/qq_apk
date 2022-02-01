package dov.com.qq.im.aeeditor.arch;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import axiy;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import dov.com.qq.im.aeeditor.view.ProgressView;

class AEEditorBaseFragment$1
  implements Runnable
{
  AEEditorBaseFragment$1(AEEditorBaseFragment paramAEEditorBaseFragment, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean, CharSequence paramCharSequence) {}
  
  public void run()
  {
    if (this.this$0.getActivity().isFinishing())
    {
      axiy.w(AEEditorBaseFragment.access$000(), "Activity has been destroy.");
      return;
    }
    if (this.this$0.g == null)
    {
      this.this$0.a = new ProgressView(this.val$context);
      this.this$0.g = new ReportDialog(this.val$context);
      this.this$0.g.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      this.this$0.g.setCanceledOnTouchOutside(false);
      this.this$0.g.requestWindowFeature(1);
      this.this$0.g.setContentView(this.this$0.a);
      this.this$0.g.setOnDismissListener(this.val$dismissListener);
    }
    for (;;)
    {
      this.this$0.g.setCancelable(this.aEs);
      this.this$0.a.setProgressText(this.j);
      this.this$0.g.show();
      return;
      this.this$0.g.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */