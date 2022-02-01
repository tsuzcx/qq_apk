import com.tencent.mobileqq.data.IntimateInfo;
import java.util.ArrayList;
import java.util.HashMap;

public class ahpp
  implements acci
{
  protected void L(boolean paramBoolean, long paramLong) {}
  
  protected void Z(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString, IntimateInfo paramIntimateInfo) {}
  
  protected void a(boolean paramBoolean, HashMap<Long, IntimateInfo> paramHashMap, Object paramObject) {}
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void b(boolean paramBoolean, long paramLong, ArrayList<Long> paramArrayList) {}
  
  protected void b(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void c(boolean paramBoolean, int paramInt, ArrayList<yxd> paramArrayList) {}
  
  protected void k(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if ((paramObject instanceof Object[]))
                  {
                    paramObject = (Object[])paramObject;
                    a(paramBoolean, (String)paramObject[0], (IntimateInfo)paramObject[1]);
                    return;
                  }
                  a(false, "", null);
                  return;
                  if ((paramObject instanceof Object[]))
                  {
                    paramObject = (Object[])paramObject;
                    k(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
                    return;
                  }
                  k(paramBoolean, "", false);
                  return;
                  if ((paramObject instanceof Object[]))
                  {
                    Z(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
                    return;
                  }
                  Z(false, "");
                  return;
                  if ((paramObject instanceof Object[]))
                  {
                    paramObject = (Object[])paramObject;
                    b(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
                    return;
                  }
                  b(false, "", -1, -1, -1);
                  return;
                  if ((paramBoolean) && ((paramObject instanceof Object[])))
                  {
                    a(paramBoolean, (Object[])paramObject);
                    return;
                  }
                  a(false, null);
                  return;
                } while (!(paramObject instanceof Object[]));
                paramObject = (Object[])paramObject;
              } while (paramObject.length < 2);
              b(paramBoolean, ((Long)paramObject[0]).longValue(), (ArrayList)paramObject[1]);
              return;
            } while (!(paramObject instanceof Object[]));
            paramObject = (Object[])paramObject;
          } while (paramObject.length < 1);
          L(paramBoolean, ((Long)paramObject[0]).longValue());
          return;
        } while (!(paramObject instanceof Object[]));
        paramObject = (Object[])paramObject;
      } while (paramObject.length < 2);
      a(paramBoolean, (HashMap)paramObject[0], paramObject[1]);
      return;
    } while (!(paramObject instanceof Object[]));
    paramObject = (Object[])paramObject;
    c(paramBoolean, ((Integer)paramObject[0]).intValue(), (ArrayList)paramObject[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahpp
 * JD-Core Version:    0.7.0.1
 */