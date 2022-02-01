import com.tencent.mobileqq.dating.FansEntity;
import java.util.List;

public class ajqz
  implements acci
{
  protected void Mk(boolean paramBoolean) {}
  
  public void Ml(boolean paramBoolean) {}
  
  public void O(boolean paramBoolean, List<FansEntity> paramList) {}
  
  public void a(boolean paramBoolean, String paramString1, List<ajuu> paramList, String paramString2, int paramInt1, int paramInt2) {}
  
  public void aM(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void aN(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void cj(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void e(String paramString1, String paramString2, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 9: 
    case 10: 
    case 11: 
    case 13: 
    default: 
      return;
    case 4: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (List)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
      return;
    case 12: 
      Mk(paramBoolean);
      return;
    case 5: 
      paramObject = (Object[])paramObject;
      if ((paramBoolean) && (paramObject != null) && (paramObject.length == 1))
      {
        O(paramBoolean, (List)paramObject[0]);
        return;
      }
      O(false, null);
      return;
    case 6: 
      cj(paramBoolean, ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
      return;
    case 7: 
      Ml(paramBoolean);
      return;
    case 8: 
      paramObject = (Object[])paramObject;
      e((String)paramObject[0], (String)paramObject[1], paramObject[2]);
      return;
    case 14: 
      aN(paramBoolean, ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
      return;
    }
    aM(paramBoolean, ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajqz
 * JD-Core Version:    0.7.0.1
 */