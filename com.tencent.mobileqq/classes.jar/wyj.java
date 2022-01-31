import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.widget.QQToast;

public class wyj
  implements View.OnClickListener
{
  public wyj(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.b.isChecked())
    {
      if (this.a.a() > 0)
      {
        QQToast.a(this.a, this.a.getResources().getString(2131435920), 0).b(this.a.getResources().getDimensionPixelSize(2131558448));
        return;
      }
      this.a.b.setChecked(true);
      return;
    }
    this.a.b.setChecked(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wyj
 * JD-Core Version:    0.7.0.1
 */