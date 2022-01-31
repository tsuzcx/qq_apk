import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.tencent.mobileqq.activity.SnapScreenActivity;
import java.io.File;

class doj
  implements Runnable
{
  doj(doi paramdoi, File paramFile) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Doi.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Doi.jdField_a_of_type_Dog.k = this.jdField_a_of_type_Doi.jdField_a_of_type_Dog.f;
      this.jdField_a_of_type_Doi.jdField_a_of_type_Dog.a.a(false);
      this.jdField_a_of_type_Doi.jdField_a_of_type_Dog.invalidate();
      this.jdField_a_of_type_Doi.jdField_a_of_type_Dog.scheduleDrawable(null, new dok(this), SystemClock.uptimeMillis() + 1000L);
      String str = this.jdField_a_of_type_Doi.jdField_a_of_type_Dog.a.jdField_a_of_type_AndroidContentContext.getString(2131562807).replace("${path}", SnapScreenActivity.jdField_a_of_type_JavaLangString);
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_Doi.jdField_a_of_type_Dog.a.jdField_a_of_type_AndroidContentContext).edit();
      localEditor.putString("LastScreenShotUri", Uri.fromFile(this.jdField_a_of_type_JavaIoFile).toString());
      localEditor.commit();
      this.jdField_a_of_type_Doi.jdField_a_of_type_Dog.a.jdField_a_of_type_AndroidContentContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(this.jdField_a_of_type_JavaIoFile)));
      Toast.makeText(this.jdField_a_of_type_Doi.jdField_a_of_type_Dog.a.jdField_a_of_type_AndroidContentContext, str, 1).show();
    }
    for (;;)
    {
      this.jdField_a_of_type_Doi.jdField_a_of_type_Dog.a.a();
      return;
      Toast.makeText(this.jdField_a_of_type_Doi.jdField_a_of_type_Dog.a.jdField_a_of_type_AndroidContentContext, 2131562817, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     doj
 * JD-Core Version:    0.7.0.1
 */