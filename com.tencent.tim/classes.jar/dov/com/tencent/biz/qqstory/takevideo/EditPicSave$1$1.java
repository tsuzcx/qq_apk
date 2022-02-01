package dov.com.tencent.biz.qqstory.takevideo;

import acfp;
import android.app.Activity;
import android.content.Intent;
import axcg;
import axiy;
import ayec;
import ayed;
import aygz;
import ayii;
import ayja;
import ayrk;
import ayrl;
import com.tencent.mobileqq.widget.QQToast;

public class EditPicSave$1$1
  implements Runnable
{
  public EditPicSave$1$1(ayed paramayed) {}
  
  public void run()
  {
    boolean bool = true;
    if (ayec.a(this.a.this$0)) {}
    int i;
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      if (ayec.a(this.a.this$0) == 49) {}
      for (i = 1;; i = 0)
      {
        localObject1 = ayec.a(this.a.this$0);
        this.a.this$0.b.changeState(0);
        this.a.this$0.aGH = true;
        this.a.this$0.updateProgress(100);
        this.a.this$0.dismissProgressDialog();
        if (this.a.this$0.b.a.tg() != 102) {
          break;
        }
        ayec.a(this.a.this$0, this.a.this$0.b.a.tg());
        return;
      }
      if (axcg.au(this.a.this$0.a.getActivity().getIntent()))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
        ((Intent)localObject1).putExtra("file_path", ayec.a(this.a.this$0));
        ((Intent)localObject1).putExtra("is_video", false);
        this.a.this$0.a.getActivity().sendBroadcast((Intent)localObject1);
        this.a.this$0.a.getActivity().setResult(-1, this.a.this$0.a.getActivity().getIntent());
        this.a.this$0.a.getActivity().finish();
        return;
      }
      if (this.a.this$0.b.a.tg() != 14) {
        break;
      }
      localObject2 = this.a.this$0.a.getActivity().getIntent();
    } while (axcg.am((Intent)localObject2));
    this.a.this$0.b.aHd = false;
    this.a.this$0.b.changeState(0);
    if (ayec.b(this.a.this$0))
    {
      if (((Intent)localObject2).getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {}
      while (i == 0)
      {
        ayja.k(this.a.this$0.a.getActivity(), ayec.a(this.a.this$0), bool);
        return;
        bool = false;
      }
      ayrl.a().adE(((Intent)localObject2).getStringExtra("widgetinfo"));
      localObject2 = ((Intent)localObject2).getStringExtra("key_camera_material_name");
      axiy.i("EditPicSave", "onPostRun---takeSameName=" + (String)localObject2);
      ayrl.a().adF((String)localObject2);
      ayrl.a().b(((ayrk)localObject1).uin, ((ayrk)localObject1).messageType, ayec.a(this.a.this$0), "", false);
      return;
    }
    QQToast.a(this.a.this$0.a.getContext(), 1, acfp.m(2131705458), 0).show();
    return;
    QQToast.a(this.a.this$0.a.getContext(), 2, acfp.m(2131705460), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave.1.1
 * JD-Core Version:    0.7.0.1
 */