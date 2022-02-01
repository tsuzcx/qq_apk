package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Dialog;
import android.view.View;
import axem;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class AEGIFSinglePreviewFragment$8
  implements Runnable
{
  public AEGIFSinglePreviewFragment$8(axem paramaxem) {}
  
  public void run()
  {
    if (axem.a(this.this$0) == null)
    {
      axem.a(this.this$0, new ReportDialog(axem.a(this.this$0), 2131756467));
      axem.a(this.this$0).setCancelable(false);
      axem.a(this.this$0).setCanceledOnTouchOutside(false);
      axem.a(this.this$0).setContentView(2131559410);
    }
    if (axem.a(this.this$0) != null) {
      axem.a(this.this$0).setVisibility(0);
    }
    axem.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.8
 * JD-Core Version:    0.7.0.1
 */