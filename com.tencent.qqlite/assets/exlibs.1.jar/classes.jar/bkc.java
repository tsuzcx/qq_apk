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

class bkc
  implements Runnable
{
  bkc(bkb parambkb, File paramFile) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Bkb.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bkb.jdField_a_of_type_Bjz.k = this.jdField_a_of_type_Bkb.jdField_a_of_type_Bjz.f;
      this.jdField_a_of_type_Bkb.jdField_a_of_type_Bjz.a.a(false);
      this.jdField_a_of_type_Bkb.jdField_a_of_type_Bjz.invalidate();
      this.jdField_a_of_type_Bkb.jdField_a_of_type_Bjz.scheduleDrawable(null, new bkd(this), SystemClock.uptimeMillis() + 1000L);
      String str = this.jdField_a_of_type_Bkb.jdField_a_of_type_Bjz.a.jdField_a_of_type_AndroidContentContext.getString(2131363195).replace("${path}", SnapScreenActivity.jdField_a_of_type_JavaLangString);
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_Bkb.jdField_a_of_type_Bjz.a.jdField_a_of_type_AndroidContentContext).edit();
      localEditor.putString("LastScreenShotUri", Uri.fromFile(this.jdField_a_of_type_JavaIoFile).toString());
      localEditor.commit();
      this.jdField_a_of_type_Bkb.jdField_a_of_type_Bjz.a.jdField_a_of_type_AndroidContentContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(this.jdField_a_of_type_JavaIoFile)));
      Toast.makeText(this.jdField_a_of_type_Bkb.jdField_a_of_type_Bjz.a.jdField_a_of_type_AndroidContentContext, str, 1).show();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkb.jdField_a_of_type_Bjz.a.a();
      return;
      Toast.makeText(this.jdField_a_of_type_Bkb.jdField_a_of_type_Bjz.a.jdField_a_of_type_AndroidContentContext, 2131363196, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bkc
 * JD-Core Version:    0.7.0.1
 */