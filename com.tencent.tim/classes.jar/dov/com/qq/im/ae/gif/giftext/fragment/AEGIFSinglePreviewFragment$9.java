package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import axem;

public class AEGIFSinglePreviewFragment$9
  implements Runnable
{
  public AEGIFSinglePreviewFragment$9(axem paramaxem) {}
  
  public void run()
  {
    if (!axem.a(this.this$0).isFinishing())
    {
      if ((axem.a(this.this$0) != null) && (axem.a(this.this$0).isShowing())) {
        axem.a(this.this$0).dismiss();
      }
      if (axem.a(this.this$0) != null) {
        axem.a(this.this$0).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.9
 * JD-Core Version:    0.7.0.1
 */