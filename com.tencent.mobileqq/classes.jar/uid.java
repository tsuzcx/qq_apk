import android.os.FileObserver;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class uid
  extends FileObserver
{
  uid(uic paramuic, String paramString1, int paramInt, String paramString2)
  {
    super(paramString1, paramInt);
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ScreenshotContentObserver", 2, "onEvent->time:" + System.currentTimeMillis() + ", path:" + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramInt != 256)) {}
    while ((paramString.equalsIgnoreCase(uic.a(this.jdField_a_of_type_Uic))) || (paramString.contains("temp")) || (uic.a(this.jdField_a_of_type_Uic) == null)) {
      return;
    }
    uic.a(this.jdField_a_of_type_Uic).a(null, this.jdField_a_of_type_JavaLangString + paramString, 1);
    uic.a(this.jdField_a_of_type_Uic, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uid
 * JD-Core Version:    0.7.0.1
 */