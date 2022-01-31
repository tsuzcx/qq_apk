import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;

public class wcm
  implements wcw
{
  public wcm(QQStoryMainActivity paramQQStoryMainActivity) {}
  
  public View a()
  {
    return QQStoryMainActivity.a(this.a);
  }
  
  public ImageView a()
  {
    return this.a.rightViewImg;
  }
  
  public TextView a()
  {
    return this.a.rightViewText;
  }
  
  public void a()
  {
    this.a.onBackEvent();
  }
  
  public void a(String paramString)
  {
    QQStoryMainActivity.a(this.a, paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.startTitleProgress();
      return;
    }
    this.a.stopTitleProgress();
  }
  
  public void b() {}
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QQStoryMainActivity.a(this.a, ugx.a, alpo.a(2131711329));
      return;
    }
    a(ugx.a);
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wcm
 * JD-Core Version:    0.7.0.1
 */