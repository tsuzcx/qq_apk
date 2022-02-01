import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class pvs
{
  public static boolean Jh()
  {
    return Build.VERSION.SDK_INT > 19;
  }
  
  public static puh a(@NonNull List<puh> paramList1, @NonNull List<puh> paramList2, @NonNull String paramString)
  {
    paramList2.clear();
    puh localpuh = null;
    Iterator localIterator = paramList1.iterator();
    paramList1 = localpuh;
    if (localIterator.hasNext())
    {
      localpuh = (puh)localIterator.next();
      if (j(localpuh)) {
        paramList2.add(localpuh);
      }
      if ((paramList1 != null) || (!TextUtils.equals(paramString, localpuh.unionId))) {
        break label76;
      }
      paramList1 = localpuh;
    }
    label76:
    for (;;)
    {
      break;
      return paramList1;
    }
  }
  
  public static int compareLong(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 == paramLong2) {
      return 0;
    }
    return 1;
  }
  
  public static boolean j(puh parampuh)
  {
    return (parampuh.nodeType == 5) || (parampuh.nodeType == 6) || (parampuh.nodeType == 7) || (parampuh.nodeType == 8) || (parampuh.nodeType == 9) || (parampuh.nodeType == 12) || (parampuh.nodeType == 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pvs
 * JD-Core Version:    0.7.0.1
 */