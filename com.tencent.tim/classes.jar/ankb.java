import android.os.Build;
import com.tencent.qphone.base.util.QLog;

public class ankb
{
  public static String[] ax = { "Le X620", "Nexus 5X", "ZTE A2017", "PRA-AL00X", "SM-W2015", "Redmi Note 3", "R7Plus", "vivo X6Plus A" };
  
  public static boolean axC()
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (anki.axI())
    {
      bool1 = bool3;
      if (!axw())
      {
        if (!iow.k(8, 1400000L))
        {
          bool1 = bool2;
          if (!iow.k(4, 2150000L)) {}
        }
        else
        {
          bool1 = true;
        }
        QLog.d("FaceDanceEntryUtil", 2, "FaceDanceEntryUtil check condition 2 +cpuNumber is" + bool1);
      }
    }
    return bool1;
  }
  
  public static boolean axD()
  {
    return (axC()) && (anhs.a().isGestureGameEnable());
  }
  
  public static boolean axw()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    String[] arrayOfString = ax;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].contains(str)) {
          bool1 = true;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("FaceDanceEntryUtil", 2, "isPhoneInBlackList ： phone = " + str + ", result=" + bool1);
        }
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ankb
 * JD-Core Version:    0.7.0.1
 */