package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import aqhq;
import aqhu;
import axcg;
import ayec;
import ayee;
import aygz;
import ayii;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import wmj;

public class EditPicSave$2$1
  implements Runnable
{
  public EditPicSave$2$1(ayee paramayee, String paramString) {}
  
  public void run()
  {
    try
    {
      if (axcg.au(this.a.this$0.a.getActivity().getIntent()))
      {
        ayec.a(this.a.this$0, MiniAppFileManager.getInstance().getTmpPathFromOut(this.azt, ayec.a(this.a.this$0, this.a.this$0.a.getContext())));
        aqhq.copyFile(new File(this.azt), new File(ayec.a(this.a.this$0)));
        return;
      }
      ayec.a(this.a.this$0, wmj.getCameraPath());
      File localFile = new File(ayec.a(this.a.this$0));
      if (aqhq.copyFile(new File(this.azt), localFile))
      {
        if (this.a.this$0.b.a.tg() == 14) {
          ayec.a(this.a.this$0, true);
        }
        aqhu.b(this.a.this$0.a.getActivity(), localFile);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EditPicSave", 2, "savePic " + localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicSave.2.1
 * JD-Core Version:    0.7.0.1
 */