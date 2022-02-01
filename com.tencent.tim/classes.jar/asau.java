import com.tencent.open.model.AppInfo;
import java.util.List;

public class asau
  implements acci
{
  protected void W(boolean paramBoolean, List<AppInfo> paramList) {}
  
  protected void c(boolean paramBoolean, List<AppInfo> paramList, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (paramBoolean)
      {
        c(paramBoolean, (List)paramObject, null);
        return;
      }
      c(paramBoolean, null, (String)paramObject);
      return;
    }
    if (paramBoolean)
    {
      W(paramBoolean, (List)paramObject);
      return;
    }
    W(paramBoolean, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asau
 * JD-Core Version:    0.7.0.1
 */