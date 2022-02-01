import android.os.FileObserver;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class ubo
  extends FileObserver
{
  ubo(ubn paramubn, String paramString1, int paramInt, String paramString2)
  {
    super(paramString1, paramInt);
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ScreenshotContentObserver", 2, "onEvent->time:" + System.currentTimeMillis() + ", path:" + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramInt != 256)) {}
    while ((paramString.equalsIgnoreCase(ubn.a(this.jdField_a_of_type_Ubn))) || (paramString.contains("temp")) || (ubn.a(this.jdField_a_of_type_Ubn) == null)) {
      return;
    }
    ubn.a(this.jdField_a_of_type_Ubn).a(null, this.jdField_a_of_type_JavaLangString + paramString, 1);
    ubn.a(this.jdField_a_of_type_Ubn, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ubo
 * JD-Core Version:    0.7.0.1
 */