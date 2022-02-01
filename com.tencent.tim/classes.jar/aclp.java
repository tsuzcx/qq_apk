import java.util.ArrayList;
import java.util.List;

public class aclp
  implements acci
{
  protected void FF(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, List<Long> paramList, int paramInt) {}
  
  protected void b(boolean paramBoolean, List<Long> paramList, int paramInt) {}
  
  protected void cMv() {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int j = 0;
    int i;
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      if ((paramObject instanceof long[])) {
        paramObject = (long[])paramObject;
      }
      Object[] arrayOfObject;
      for (i = 0;; i = ((Integer)arrayOfObject[1]).intValue())
      {
        int k = paramObject.length;
        while (j < k)
        {
          localArrayList.add(Long.valueOf(paramObject[j]));
          j += 1;
        }
        arrayOfObject = (Object[])paramObject;
        paramObject = (long[])arrayOfObject[0];
      }
      paramObject = localArrayList;
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        FF(paramBoolean);
        return;
      case 2: 
        t(paramBoolean, paramObject);
        a(paramBoolean, paramObject, i);
        return;
      case 3: 
        u(paramBoolean, paramObject);
        b(paramBoolean, paramObject, i);
        return;
      }
      cMv();
      return;
      paramObject = null;
      i = 0;
    }
  }
  
  protected void t(boolean paramBoolean, List<Long> paramList) {}
  
  protected void u(boolean paramBoolean, List<Long> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aclp
 * JD-Core Version:    0.7.0.1
 */