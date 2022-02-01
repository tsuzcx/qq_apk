import android.widget.TextView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import java.util.Iterator;
import java.util.List;

public class aims
{
  public static int a(boolean paramBoolean, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if ((!paramBoolean) || (paramRedTypeInfo == null)) {
      return 0;
    }
    if (paramRedTypeInfo.red_type.get() == 0) {
      return 1;
    }
    if (paramRedTypeInfo.red_type.get() == 5) {
      return 2;
    }
    return 3;
  }
  
  public static anpv a(String paramString)
  {
    anpv localanpv = new anpv();
    localanpv.cgr = "trends_tab";
    localanpv.cgs = "trends_plugin";
    localanpv.aBx = paramString;
    return localanpv;
  }
  
  public static int b(RedTouch paramRedTouch)
  {
    if ((paramRedTouch == null) || (!paramRedTouch.auw())) {}
    do
    {
      return 0;
      paramRedTouch = paramRedTouch.fU();
    } while ((paramRedTouch == null) || (paramRedTouch.isEmpty()));
    paramRedTouch = paramRedTouch.iterator();
    while (paramRedTouch.hasNext())
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramRedTouch.next();
      if (localRedTypeInfo.red_type.get() == 0) {
        return 1;
      }
      if (localRedTypeInfo.red_type.get() == 5) {
        return 2;
      }
      if (localRedTypeInfo.red_type.get() == 11) {
        return 3;
      }
    }
    return 3;
  }
  
  public static int c(RedTouch paramRedTouch)
  {
    if (paramRedTouch == null) {}
    while ((paramRedTouch.XW == null) || (paramRedTouch.XW.getVisibility() != 0)) {
      return 0;
    }
    return 1;
  }
  
  public static int ib(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aims
 * JD-Core Version:    0.7.0.1
 */