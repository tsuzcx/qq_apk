import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.Dex2Oat.a;
import java.io.File;

class avgj
  implements Dex2Oat.a
{
  avgj(avgh paramavgh) {}
  
  public void a(File paramFile1, File paramFile2, File paramFile3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "dex2Oat onSuccess " + paramFile1.getAbsolutePath() + " o" + paramFile2.getAbsolutePath());
    }
  }
  
  public void a(File paramFile1, File paramFile2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "preDex2Oat onFailed " + paramFile1.getAbsolutePath() + " o" + paramFile2.getAbsolutePath());
    }
  }
  
  public void i(File paramFile1, File paramFile2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "dex2Oat onStart " + paramFile1.getAbsolutePath() + " o" + paramFile2.getAbsolutePath());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avgj
 * JD-Core Version:    0.7.0.1
 */