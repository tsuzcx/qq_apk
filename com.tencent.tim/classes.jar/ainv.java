import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.ISong;
import java.util.List;

public class ainv
  implements acci
{
  protected void O(String paramString1, String paramString2, boolean paramBoolean) {}
  
  protected void S(int paramInt, String paramString1, String paramString2) {}
  
  protected void a(boolean paramBoolean, ListenTogetherSession paramListenTogetherSession) {}
  
  protected void as(String paramString, int paramInt1, int paramInt2) {}
  
  protected void c(ISong paramISong) {}
  
  protected void cU(int paramInt, String paramString) {}
  
  protected void cV(int paramInt, String paramString) {}
  
  protected void cW(int paramInt, String paramString) {}
  
  protected void cX(int paramInt, String paramString) {}
  
  protected void cY(int paramInt, String paramString) {}
  
  protected void cZ(int paramInt, String paramString) {}
  
  protected void d(ListenTogetherSession paramListenTogetherSession) {}
  
  protected void d(boolean paramBoolean, String paramString, int paramInt, List<String> paramList) {}
  
  protected void da(int paramInt, String paramString) {}
  
  protected void db(int paramInt, String paramString) {}
  
  protected void e(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void eT(String paramString, int paramInt) {}
  
  protected void onThemeChange() {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      d((ListenTogetherSession)((Object[])(Object[])paramObject)[0]);
      return;
    case 5: 
      paramObject = (Object[])paramObject;
      s(((Integer)paramObject[0]).intValue(), (String)paramObject[1], ((Boolean)paramObject[2]).booleanValue());
      return;
    case 19: 
      paramObject = (Object[])paramObject;
      cV(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    case 6: 
      paramObject = (Object[])paramObject;
      cW(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    case 7: 
      paramObject = (Object[])paramObject;
      cX(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    case 21: 
      paramObject = (Object[])paramObject;
      cZ(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    case 20: 
      paramObject = (Object[])paramObject;
      cY(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    case 8: 
      paramObject = (Object[])paramObject;
      da(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    case 9: 
      paramObject = (Object[])paramObject;
      as((String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
      return;
    case 10: 
      paramObject = (Object[])paramObject;
      O((String)paramObject[0], (String)paramObject[1], ((Boolean)paramObject[2]).booleanValue());
      return;
    case 11: 
      paramObject = (Object[])paramObject;
      e(((Integer)paramObject[0]).intValue(), (String)paramObject[1], ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue());
      return;
    case 12: 
      paramObject = (Object[])paramObject;
      eT((String)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
    case 13: 
      c((ISong)((Object[])(Object[])paramObject)[0]);
      return;
    case 14: 
      paramObject = (Object[])paramObject;
      db(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    case 15: 
      paramObject = (Object[])paramObject;
      a(((Boolean)paramObject[0]).booleanValue(), (ListenTogetherSession)paramObject[1]);
      return;
    case 16: 
      onThemeChange();
      return;
    case 18: 
      paramObject = (Object[])paramObject;
      S(((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2]);
      return;
    case 22: 
      paramObject = (Object[])paramObject;
      cU(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    }
    paramObject = (Object[])paramObject;
    if (paramBoolean)
    {
      d(true, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (List)paramObject[2]);
      return;
    }
    d(true, (String)paramObject[0], 0, null);
  }
  
  protected void s(int paramInt, String paramString, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ainv
 * JD-Core Version:    0.7.0.1
 */