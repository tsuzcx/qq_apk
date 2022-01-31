import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class wxw
  implements wxt
{
  wxw(wxv paramwxv, String paramString) {}
  
  public void a(Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("isSuccess", false);
    if (bool)
    {
      paramBundle = paramBundle.getString("data");
      this.jdField_a_of_type_Wxv.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle });
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(this.jdField_a_of_type_Wxv.TAG, 2, "getTroopBarPublishInfo() in callback isSuccess=" + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wxw
 * JD-Core Version:    0.7.0.1
 */