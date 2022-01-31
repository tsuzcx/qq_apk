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

class cxi
  implements Runnable
{
  cxi(cxh paramcxh, File paramFile) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Cxh.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Cxh.jdField_a_of_type_Cxf.k = this.jdField_a_of_type_Cxh.jdField_a_of_type_Cxf.f;
      ScreenShot.a(this.jdField_a_of_type_Cxh.jdField_a_of_type_Cxf.a, false);
      this.jdField_a_of_type_Cxh.jdField_a_of_type_Cxf.invalidate();
      this.jdField_a_of_type_Cxh.jdField_a_of_type_Cxf.scheduleDrawable(null, new cxj(this), SystemClock.uptimeMillis() + 1000L);
      String str = this.jdField_a_of_type_Cxh.jdField_a_of_type_Cxf.a.jdField_a_of_type_AndroidContentContext.getString(2131363195).replace("${path}", ScreenShot.jdField_a_of_type_JavaLangString);
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_Cxh.jdField_a_of_type_Cxf.a.jdField_a_of_type_AndroidContentContext).edit();
      localEditor.putString("LastScreenShotUri", Uri.fromFile(this.jdField_a_of_type_JavaIoFile).toString());
      localEditor.commit();
      this.jdField_a_of_type_Cxh.jdField_a_of_type_Cxf.a.jdField_a_of_type_AndroidContentContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(this.jdField_a_of_type_JavaIoFile)));
      Toast.makeText(this.jdField_a_of_type_Cxh.jdField_a_of_type_Cxf.a.jdField_a_of_type_AndroidContentContext.getApplicationContext(), str, 1).show();
      return;
    }
    Toast.makeText(this.jdField_a_of_type_Cxh.jdField_a_of_type_Cxf.a.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2131363196, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cxi
 * JD-Core Version:    0.7.0.1
 */