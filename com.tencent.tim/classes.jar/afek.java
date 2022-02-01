import com.tencent.beacon.event.UserAction;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTReport;
import java.util.Map;

public class afek
  implements IDTReport
{
  private static volatile afek a;
  
  public static afek a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new afek();
      }
      return a;
    }
    finally {}
  }
  
  public boolean dtEvent(Object paramObject, String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    UserAction.onUserAction(paramString, true, -1L, -1L, paramMap, paramBoolean, paramBoolean);
    return true;
  }
  
  public boolean dtEvent(Object paramObject, String paramString1, Map<String, String> paramMap, boolean paramBoolean, String paramString2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afek
 * JD-Core Version:    0.7.0.1
 */