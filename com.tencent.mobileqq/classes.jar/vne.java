import android.media.ExifInterface;
import android.os.AsyncTask;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class vne
  extends AsyncTask
{
  public vne(AIOGalleryScene paramAIOGalleryScene, File paramFile, int paramInt) {}
  
  protected Void a(Void... paramVarArgs)
  {
    if (JpegExifReader.isCrashJpeg(this.jdField_a_of_type_JavaIoFile.getAbsolutePath())) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramVarArgs = new ExifInterface(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        if (this.jdField_a_of_type_Int == 0)
        {
          paramVarArgs.setAttribute("Orientation", String.valueOf(1));
          paramVarArgs.saveAttributes();
          paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene;
          paramVarArgs.k += 1;
          return null;
        }
      }
      catch (IOException paramVarArgs)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("AIOGalleryScene", 2, "save exif error", paramVarArgs);
        return null;
        if (this.jdField_a_of_type_Int != 1) {
          break label126;
        }
        paramVarArgs.setAttribute("Orientation", String.valueOf(6));
        continue;
      }
      catch (UnsupportedOperationException paramVarArgs) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("AIOGalleryScene", 2, "save exif error", paramVarArgs);
      return null;
      label126:
      if (this.jdField_a_of_type_Int == 2) {
        paramVarArgs.setAttribute("Orientation", String.valueOf(3));
      } else if (this.jdField_a_of_type_Int == 3) {
        paramVarArgs.setAttribute("Orientation", String.valueOf(8));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vne
 * JD-Core Version:    0.7.0.1
 */