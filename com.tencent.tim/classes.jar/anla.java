import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class anla
{
  public static int bba = -4;
  private static boolean cHS;
  private static final Object eU = new Object();
  
  public static boolean ayl()
  {
    boolean bool = false;
    if (cHS) {
      return true;
    }
    String str = ankq.aO(BaseApplicationImpl.getContext());
    if (str == null) {
      return false;
    }
    if (!aqhq.fileExists(str + "libObjectTracker.so")) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TrackerSoLoader", 2, " isTrackingSoExist =" + bool);
      }
      cHS = bool;
      return cHS;
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anla
 * JD-Core Version:    0.7.0.1
 */