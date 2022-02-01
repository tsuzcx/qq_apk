import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ypj
{
  public static boolean E(QQAppInterface paramQQAppInterface)
  {
    return false;
  }
  
  public static void bi(QQAppInterface paramQQAppInterface) {}
  
  public static void e(long paramLong, List<ypk> paramList)
  {
    int j = (int)(SystemClock.elapsedRealtime() - paramLong) / 1000;
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      if (!((ypk)paramList.next()).Ue()) {
        break label99;
      }
      i += 1;
    }
    label99:
    for (;;)
    {
      break;
      u("0X800AB63", i + "", j + "", "");
      return;
    }
  }
  
  public static void u(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactUtils", 2, " face2faceReport tValue = " + paramString1 + " r2 = " + paramString2 + " r3 = " + paramString3 + " r4 =" + paramString4);
    }
    anot.a(null, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, paramString4, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ypj
 * JD-Core Version:    0.7.0.1
 */