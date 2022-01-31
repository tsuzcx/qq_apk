import android.widget.Button;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

public class emx
  implements FMDialogUtil.FMDialogInterface
{
  public emx(PhotoListActivity paramPhotoListActivity) {}
  
  public void a()
  {
    PhotoListActivity.e(this.a);
  }
  
  public void b()
  {
    this.a.d.setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     emx
 * JD-Core Version:    0.7.0.1
 */