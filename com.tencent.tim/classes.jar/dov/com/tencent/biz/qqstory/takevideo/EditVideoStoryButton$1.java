package dov.com.tencent.biz.qqstory.takevideo;

import android.content.Intent;
import axiy;
import aygz;
import ayia;
import ayii;
import ayja;
import ayrk;
import ayrl;

public class EditVideoStoryButton$1
  implements Runnable
{
  public EditVideoStoryButton$1(ayia paramayia, Intent paramIntent, boolean paramBoolean, ayrk paramayrk) {}
  
  public void run()
  {
    boolean bool = false;
    this.this$0.dismissProgressDialog();
    String str1;
    String str2;
    if (this.this$0.b.a.tg() != 102)
    {
      str1 = this.val$data.getStringExtra("key_video_save_path");
      str2 = this.val$data.getStringExtra("thumbfile_send_path");
      if (this.this$0.b.a.getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {
        bool = true;
      }
      if (this.dzm)
      {
        ayrl.a().adE(this.val$data.getStringExtra("widgetinfo"));
        String str3 = this.val$data.getStringExtra("key_camera_material_name");
        axiy.i("EditVideoStoryButton", "onPostRun---takeSameName=" + str3);
        ayrl.a().adF(str3);
        ayrl.a().b(this.c.uin, this.c.messageType, str1, str2, true);
      }
    }
    else
    {
      return;
    }
    ayja.a(this.this$0.a.getActivity(), str1, str2, bool, "caller_aecamera");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.1
 * JD-Core Version:    0.7.0.1
 */