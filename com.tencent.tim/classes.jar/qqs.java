import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainController.b;

public class qqs
  implements QQStoryMainController.b
{
  public qqs(QQStoryMainActivity paramQQStoryMainActivity) {}
  
  public void bpH()
  {
    this.this$0.onBackEvent();
  }
  
  public void bpI() {}
  
  public void bpJ() {}
  
  public ImageView l()
  {
    return this.this$0.rightViewImg;
  }
  
  public void rS(String paramString)
  {
    QQStoryMainActivity.a(this.this$0, paramString);
  }
  
  public void td(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.this$0.startTitleProgress();
      return;
    }
    this.this$0.stopTitleProgress();
  }
  
  public void te(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QQStoryMainActivity.a(this.this$0, plr.asY, acfp.m(2131712349));
      return;
    }
    rS(plr.asY);
  }
  
  public View y()
  {
    return QQStoryMainActivity.a(this.this$0);
  }
  
  public TextView y()
  {
    return this.this$0.rightViewText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqs
 * JD-Core Version:    0.7.0.1
 */