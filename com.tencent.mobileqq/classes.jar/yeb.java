import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;

public class yeb
  implements yel
{
  public yeb(QQStoryMainActivity paramQQStoryMainActivity) {}
  
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
      QQStoryMainActivity.a(this.a, win.a, anzj.a(2131709826));
      return;
    }
    a(win.a);
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yeb
 * JD-Core Version:    0.7.0.1
 */