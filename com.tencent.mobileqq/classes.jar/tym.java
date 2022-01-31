import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo;

public class tym
  implements View.OnClickListener
{
  public tym(QCircleContentVideo paramQCircleContentVideo) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a() == null) {
      return;
    }
    if (this.a.a().a())
    {
      this.a.b();
      return;
    }
    if (QCircleContentVideo.a(this.a))
    {
      this.a.e();
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tym
 * JD-Core Version:    0.7.0.1
 */