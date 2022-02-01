import android.media.ExifInterface;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.a;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;

public class aaqg
  implements CameraCover.a
{
  public aaqg(FlowCameraActivity2 paramFlowCameraActivity2, File paramFile) {}
  
  public void AE(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FlowCameraActivity", 2, "onPictureToken path " + paramString);
    }
    aqhu.a(paramString, this.this$0.bo, this.this$0.bp);
    if (QLog.isColorLevel()) {}
    try
    {
      Object localObject = Class.forName("android.media.ExifInterface").getDeclaredField("mAttributes");
      ((Field)localObject).setAccessible(true);
      localObject = (HashMap)((Field)localObject).get(new ExifInterface(paramString));
      QLog.i("FlowCameraActivity", 2, "exif " + localObject);
      if (paramString != null)
      {
        this.this$0.p(this.val$file);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      this.this$0.ff.setClickable(true);
      this.this$0.ff.setOnLongClickListener(this.this$0);
      this.this$0.fg.setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaqg
 * JD-Core Version:    0.7.0.1
 */