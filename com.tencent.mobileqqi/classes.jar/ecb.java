import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import java.io.File;

public final class ecb
  implements DialogInterface.OnClickListener
{
  public ecb(Activity paramActivity, File paramFile1, File paramFile2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AIOGalleryUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaIoFile, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ecb
 * JD-Core Version:    0.7.0.1
 */