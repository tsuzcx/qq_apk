import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class apkg
  implements joy
{
  apkg(apke paramapke, long paramLong) {}
  
  public void loaded(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLibraryLoader", 2, "transToLocalUrl loadMode:" + paramInt + ", time:" + (System.currentTimeMillis() - this.val$startTime));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("SoLibraryLoader", 4, "transToLocalUrl transUrl:" + paramString);
    }
    paramString = jpe.dO(apke.a(this.this$0)) + apke.a(this.this$0) + File.separator + apke.b(this.this$0);
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SoLibraryLoader", 2, "file not exist! path = " + paramString);
      }
      return;
    }
    aqhq.copyFile(paramString, apke.a(this.this$0).getFilesDir().getAbsolutePath() + File.separator + apke.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apkg
 * JD-Core Version:    0.7.0.1
 */