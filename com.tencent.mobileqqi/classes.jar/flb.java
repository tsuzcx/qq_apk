import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.tencent.mobileqq.app.ScreenShot;
import java.io.File;

class flb
  implements Runnable
{
  flb(fla paramfla, File paramFile) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Fla.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Fla.jdField_a_of_type_Fky.k = this.jdField_a_of_type_Fla.jdField_a_of_type_Fky.f;
      ScreenShot.a(this.jdField_a_of_type_Fla.jdField_a_of_type_Fky.a, false);
      this.jdField_a_of_type_Fla.jdField_a_of_type_Fky.invalidate();
      this.jdField_a_of_type_Fla.jdField_a_of_type_Fky.scheduleDrawable(null, new flc(this), SystemClock.uptimeMillis() + 1000L);
      String str = this.jdField_a_of_type_Fla.jdField_a_of_type_Fky.a.jdField_a_of_type_AndroidContentContext.getString(2131562807).replace("${path}", ScreenShot.jdField_a_of_type_JavaLangString);
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_Fla.jdField_a_of_type_Fky.a.jdField_a_of_type_AndroidContentContext).edit();
      localEditor.putString("LastScreenShotUri", Uri.fromFile(this.jdField_a_of_type_JavaIoFile).toString());
      localEditor.commit();
      this.jdField_a_of_type_Fla.jdField_a_of_type_Fky.a.jdField_a_of_type_AndroidContentContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(this.jdField_a_of_type_JavaIoFile)));
      Toast.makeText(this.jdField_a_of_type_Fla.jdField_a_of_type_Fky.a.jdField_a_of_type_AndroidContentContext, str, 1).show();
      return;
    }
    Toast.makeText(this.jdField_a_of_type_Fla.jdField_a_of_type_Fky.a.jdField_a_of_type_AndroidContentContext, 2131562817, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     flb
 * JD-Core Version:    0.7.0.1
 */