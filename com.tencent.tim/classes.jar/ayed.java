import android.view.View;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave.1.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class ayed
  implements ThreadExcutor.IThreadListener
{
  ayed(ayec paramayec) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if ((this.this$0.a == null) || (this.this$0.a.getActivity() == null)) {
      return;
    }
    this.this$0.a.getRootView().postDelayed(new EditPicSave.1.1(this), 500L);
  }
  
  public void onPreRun()
  {
    if (this.this$0.b.a.tg() == 14) {
      ayec.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayed
 * JD-Core Version:    0.7.0.1
 */