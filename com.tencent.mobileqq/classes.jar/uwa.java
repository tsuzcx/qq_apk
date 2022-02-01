import android.os.FileObserver;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class uwa
  extends FileObserver
{
  uwa(uvz paramuvz, String paramString1, int paramInt, String paramString2)
  {
    super(paramString1, paramInt);
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ScreenshotContentObserver", 2, "onEvent->time:" + System.currentTimeMillis() + ", path:" + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramInt != 256)) {}
    while ((paramString.equalsIgnoreCase(uvz.a(this.jdField_a_of_type_Uvz))) || (paramString.contains("temp")) || (uvz.a(this.jdField_a_of_type_Uvz) == null)) {
      return;
    }
    uvz.a(this.jdField_a_of_type_Uvz).a(null, this.jdField_a_of_type_JavaLangString + paramString, 1);
    uvz.a(this.jdField_a_of_type_Uvz, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uwa
 * JD-Core Version:    0.7.0.1
 */