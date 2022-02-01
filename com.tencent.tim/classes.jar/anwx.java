import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.Callable;

class anwx
  implements Callable<File>
{
  anwx(anww paramanww) {}
  
  public File G()
    throws Exception
  {
    if ((!anww.a(this.a).exists()) || (!anww.a(this.a)))
    {
      long l = System.currentTimeMillis();
      if (!anww.a(this.a, anww.a(this.a), anww.a(this.a), anww.a(this.a).getAbsolutePath())) {
        break label111;
      }
      QLog.i("studyroom.AssetsPmUpdater", 1, "copy asset pm success, cost=" + (System.currentTimeMillis() - l));
    }
    while (anww.a(this.a).exists())
    {
      return anww.a(this.a);
      label111:
      QLog.i("studyroom.AssetsPmUpdater", 1, "copy asset pm fail");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anwx
 * JD-Core Version:    0.7.0.1
 */