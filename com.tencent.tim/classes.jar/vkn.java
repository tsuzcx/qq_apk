import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.QQStoryMainController.b;
import com.tencent.mobileqq.activity.Now;

public class vkn
  implements QQStoryMainController.b
{
  public vkn(Now paramNow) {}
  
  public void bpH()
  {
    this.this$0.onBackPressed();
  }
  
  public void bpI()
  {
    this.this$0.xJ(false);
  }
  
  public void bpJ()
  {
    this.this$0.xJ(true);
  }
  
  public ImageView l()
  {
    if (this.this$0.pW != null) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool);
      return this.this$0.pW;
    }
  }
  
  public void rS(String paramString)
  {
    this.this$0.mTitle.setText(paramString);
  }
  
  public void td(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Now.a(this.this$0);
      return;
    }
    Now.b(this.this$0);
  }
  
  public void te(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      this.this$0.kn.setVisibility(i);
      return;
    }
  }
  
  public View y()
  {
    return this.this$0.mRootView;
  }
  
  public TextView y()
  {
    if (this.this$0.Dj != null) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool);
      return this.this$0.Dj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vkn
 * JD-Core Version:    0.7.0.1
 */