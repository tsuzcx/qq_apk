package dov.com.tencent.biz.qqstory.takevideo;

import acfp;
import android.content.Intent;
import aygz;
import ayhs;
import ayii;
import com.tencent.mobileqq.widget.QQToast;

public class EditVideoSave$1
  implements Runnable
{
  public EditVideoSave$1(ayhs paramayhs, int paramInt, Intent paramIntent) {}
  
  public void run()
  {
    this.this$0.dismissProgressDialog();
    if (this.val$requestCode == 222)
    {
      str = this.val$data.getStringExtra("key_video_save_path");
      this.this$0.b.adA(str);
    }
    while (this.this$0.b.a.tg() == 102)
    {
      String str;
      return;
    }
    QQToast.a(this.this$0.a.getContext(), 2, acfp.m(2131705538), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.1
 * JD-Core Version:    0.7.0.1
 */