import android.os.FileObserver;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class oeb
  extends FileObserver
{
  oeb(oea paramoea, String paramString1, int paramInt, String paramString2)
  {
    super(paramString1, paramInt);
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ScreenshotContentObserver", 2, "onEvent->time:" + System.currentTimeMillis() + ", path:" + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramInt != 256)) {}
    while ((paramString.equalsIgnoreCase(oea.a(this.c))) || (paramString.contains("temp")) || (oea.a(this.c) == null)) {
      return;
    }
    oea.a(this.c).a(null, this.apW + paramString, 1);
    oea.a(this.c, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oeb
 * JD-Core Version:    0.7.0.1
 */