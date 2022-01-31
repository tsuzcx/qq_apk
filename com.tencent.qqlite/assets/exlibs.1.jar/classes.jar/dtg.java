import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.SurfaceView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;

class dtg
  implements Runnable
{
  dtg(dtf paramdtf, Bitmap paramBitmap) {}
  
  public void run()
  {
    LocalVideoFileView.a(this.jdField_a_of_type_Dtf.a).setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dtg
 * JD-Core Version:    0.7.0.1
 */