package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.os.Build.VERSION;
import ayeh;
import ayii;

public class EditProviderPart$3
  implements Runnable
{
  public EditProviderPart$3(ayeh paramayeh) {}
  
  public void run()
  {
    if ((this.this$0.dyK) || (this.this$0.a == null)) {}
    while ((this.this$0.a.getActivity() == null) || (this.this$0.a.getActivity().isFinishing()) || ((Build.VERSION.SDK_INT > 16) && (this.this$0.a.getActivity().isDestroyed()))) {
      return;
    }
    this.this$0.dyK = true;
    this.this$0.Zk(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditProviderPart.3
 * JD-Core Version:    0.7.0.1
 */