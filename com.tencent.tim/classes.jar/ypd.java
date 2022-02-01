import java.util.List;

public class ypd
  implements acci
{
  private void L(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 8) {
        a(true, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4], ((Integer)paramObject[5]).intValue(), ((Integer)paramObject[6]).intValue(), ((Boolean)paramObject[7]).booleanValue());
      }
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length >= 2)
      {
        paramObject = (String)arrayOfObject[0];
        paramBoolean = ((Boolean)arrayOfObject[1]).booleanValue();
      }
    }
    for (;;)
    {
      a(false, paramObject, 0, null, 0, null, 60, 1200, paramBoolean);
      return;
      paramBoolean = false;
      paramObject = null;
    }
  }
  
  private void M(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 3) {
        h(true, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
      }
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length <= 0) {}
    }
    for (paramObject = (String)paramObject[0];; paramObject = null)
    {
      h(false, paramObject, 0, null);
      return;
    }
  }
  
  private void N(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 4) {
        a(true, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], (List)paramObject[3]);
      }
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length <= 0) {}
    }
    for (paramObject = (String)paramObject[0];; paramObject = null)
    {
      a(false, paramObject, 0, null, null);
      return;
    }
  }
  
  private void O(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 3) {
        a((String)paramObject[0], (String)paramObject[1], (List)paramObject[2]);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, List<ypk> paramList) {}
  
  public void a(boolean paramBoolean1, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, List<String> paramList) {}
  
  public void h(boolean paramBoolean, String paramString1, int paramInt, String paramString2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      L(paramBoolean, paramObject);
      return;
    case 2: 
      M(paramBoolean, paramObject);
      return;
    case 3: 
      N(paramBoolean, paramObject);
      return;
    }
    O(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ypd
 * JD-Core Version:    0.7.0.1
 */