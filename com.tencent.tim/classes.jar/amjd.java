import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import java.util.Comparator;

public class amjd
  implements Comparator<ScribbleResMgr.ResInfo>
{
  public amjd(ScribbleResMgr paramScribbleResMgr) {}
  
  public int a(ScribbleResMgr.ResInfo paramResInfo1, ScribbleResMgr.ResInfo paramResInfo2)
  {
    if ((paramResInfo1 != null) && (paramResInfo2 != null)) {
      return paramResInfo1.orderIndex - paramResInfo2.orderIndex;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amjd
 * JD-Core Version:    0.7.0.1
 */