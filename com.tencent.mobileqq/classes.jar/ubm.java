import android.os.FileObserver;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class ubm
  extends FileObserver
{
  ubm(ubl paramubl, String paramString1, int paramInt, String paramString2)
  {
    super(paramString1, paramInt);
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ScreenshotContentObserver", 2, "onEvent->time:" + System.currentTimeMillis() + ", path:" + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramInt != 256)) {}
    while ((paramString.equalsIgnoreCase(ubl.a(this.jdField_a_of_type_Ubl))) || (paramString.contains("temp")) || (ubl.a(this.jdField_a_of_type_Ubl) == null)) {
      return;
    }
    ubl.a(this.jdField_a_of_type_Ubl).a(null, this.jdField_a_of_type_JavaLangString + paramString, 1);
    ubl.a(this.jdField_a_of_type_Ubl, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ubm
 * JD-Core Version:    0.7.0.1
 */