import android.widget.Button;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

public class cke
  implements FMDialogUtil.FMDialogInterface
{
  public cke(PhotoListActivity paramPhotoListActivity) {}
  
  public void a()
  {
    PhotoListActivity.e(this.a);
  }
  
  public void b()
  {
    this.a.c.setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cke
 * JD-Core Version:    0.7.0.1
 */