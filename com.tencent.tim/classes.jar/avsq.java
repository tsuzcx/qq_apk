import android.content.Intent;
import cooperation.qzone.util.QZLog;

public class avsq
{
  public static boolean a(Object paramObject, int paramInt1, int paramInt2, Intent paramIntent)
  {
    QZLog.i("QZoneEventHandler", "handleActivityEvent: " + paramInt1 + " " + paramInt2);
    switch (paramInt1)
    {
    default: 
      return false;
    }
    if (((paramObject instanceof xys)) && (((xys)paramObject).a != null)) {
      ((xys)paramObject).a.h(paramInt1, paramInt2, paramIntent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avsq
 * JD-Core Version:    0.7.0.1
 */