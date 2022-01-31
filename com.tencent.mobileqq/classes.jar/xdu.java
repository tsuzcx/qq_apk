import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;

public class xdu
  implements View.OnClickListener
{
  public xdu(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    switch (this.a.b())
    {
    default: 
      return;
    case 0: 
      this.a.a(0);
      return;
    case 1: 
      this.a.l();
      return;
    case 2: 
      this.a.k();
      return;
    }
    this.a.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xdu
 * JD-Core Version:    0.7.0.1
 */