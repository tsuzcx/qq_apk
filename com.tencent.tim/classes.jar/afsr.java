import com.tencent.mobileqq.data.Card;
import java.util.ArrayList;
import java.util.List;

public class afsr
  implements acci
{
  protected void Be(int paramInt) {}
  
  protected void Bv(boolean paramBoolean) {}
  
  protected void Ir(boolean paramBoolean) {}
  
  protected void Is(boolean paramBoolean) {}
  
  protected void It(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, aftr paramaftr, int paramInt3) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, aftr paramaftr, String paramString) {}
  
  protected void a(boolean paramBoolean, int paramInt, aftr paramaftr) {}
  
  protected void a(boolean paramBoolean, int paramInt, aftr paramaftr, String paramString) {}
  
  protected void a(boolean paramBoolean1, long paramLong, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<afua> paramList, aftq paramaftq) {}
  
  protected void a(boolean paramBoolean, aftr paramaftr) {}
  
  protected void a(boolean paramBoolean, afua paramafua, int paramInt) {}
  
  protected void a(boolean paramBoolean, Card paramCard) {}
  
  protected void a(boolean paramBoolean1, ArrayList<afub> paramArrayList, boolean paramBoolean2, int paramInt, ArrayList<String> paramArrayList1, boolean paramBoolean3) {}
  
  protected void aB(boolean paramBoolean, String paramString) {}
  
  protected void as(boolean paramBoolean, int paramInt) {}
  
  protected void bl(boolean paramBoolean, Object paramObject) {}
  
  protected void bm(boolean paramBoolean, Object paramObject) {}
  
  protected void f(boolean paramBoolean, ArrayList<Long> paramArrayList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int i = -1;
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
            return;
            xq(paramBoolean);
            return;
          } while ((paramObject == null) || (!(paramObject instanceof Object[])));
          paramObject = (Object[])paramObject;
          if ((paramBoolean) && (paramObject.length == 9))
          {
            a(true, ((Long)paramObject[0]).longValue(), (String)paramObject[1], ((Boolean)paramObject[2]).booleanValue(), (byte[])paramObject[3], ((Boolean)paramObject[4]).booleanValue(), ((Boolean)paramObject[5]).booleanValue(), ((Integer)paramObject[6]).intValue(), (List)paramObject[7], (aftq)paramObject[8]);
            return;
          }
        } while ((paramBoolean) || (paramObject.length != 2));
        a(false, ((Long)paramObject[0]).longValue(), (String)paramObject[1], false, null, false, false, 0, null, null);
        return;
        a(paramBoolean, (Card)paramObject);
        return;
        paramObject = (Object[])paramObject;
        a(paramBoolean, (afua)paramObject[0], ((Integer)paramObject[1]).intValue());
        return;
        Bv(((Boolean)paramObject).booleanValue());
        return;
        Ir(((Boolean)paramObject).booleanValue());
        return;
        if ((paramObject instanceof Object[]))
        {
          paramObject = (Object[])paramObject;
          if (paramObject.length == 4)
          {
            a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), (aftr)paramObject[2], ((Integer)paramObject[3]).intValue());
            return;
          }
          a(paramBoolean, -1, -1, null, -1);
          return;
        }
        a(paramBoolean, -1, -1, null, -1);
        return;
        if ((paramObject instanceof Object[]))
        {
          paramObject = (Object[])paramObject;
          if ((paramObject != null) && (paramObject.length == 2))
          {
            a(paramBoolean, ((Integer)paramObject[0]).intValue(), (aftr)paramObject[1]);
            return;
          }
          a(false, -1, null);
          return;
        }
        a(paramBoolean, -1, null);
        return;
        paramInt = i;
        if (paramObject != null)
        {
          paramInt = i;
          if ((paramObject instanceof Object[]))
          {
            paramObject = (Object[])paramObject;
            paramInt = i;
            if (paramObject != null)
            {
              paramInt = i;
              if (paramObject.length > 0) {
                paramInt = ((Integer)paramObject[0]).intValue();
              }
            }
          }
        }
        as(paramBoolean, paramInt);
        return;
        bl(paramBoolean, paramObject);
        return;
        if (paramBoolean)
        {
          if ((paramObject != null) && ((paramObject instanceof Object[])))
          {
            paramObject = (Object[])paramObject;
            if ((paramObject != null) && (paramObject.length == 4))
            {
              a(paramBoolean, ((Integer)paramObject[0]).intValue(), (aftr)paramObject[1], (String)paramObject[3]);
              return;
            }
            a(false, -1, null, null);
            return;
          }
          a(false, -1, null, null);
          return;
        }
        a(false, -1, null, null);
        return;
        if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
        {
          paramObject = (Object[])paramObject;
          if ((paramObject != null) && (paramObject.length == 1))
          {
            a(paramBoolean, (aftr)paramObject[0]);
            return;
          }
          a(false, null);
          return;
        }
        a(false, null);
        return;
        Is(paramBoolean);
        return;
        if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
        {
          paramObject = (Object[])paramObject;
          if ((paramObject != null) && (paramObject.length == 5))
          {
            a(true, (ArrayList)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Integer)paramObject[2]).intValue(), (ArrayList)paramObject[3], ((Boolean)paramObject[4]).booleanValue());
            return;
          }
          a(false, null, true, 0, null, false);
          return;
        }
        a(false, null, true, 0, null, false);
        return;
        It(paramBoolean);
        return;
        if (paramBoolean)
        {
          if ((paramObject != null) && ((paramObject instanceof Object[])))
          {
            paramObject = (Object[])paramObject;
            if ((paramObject != null) && (paramObject.length == 4))
            {
              a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[2]).intValue(), (aftr)paramObject[1], (String)paramObject[3]);
              return;
            }
            a(false, -1, -1, null, null);
            return;
          }
          a(false, -1, -1, null, null);
          return;
        }
        a(false, -1, -1, null, null);
        return;
        Be(((Integer)paramObject).intValue());
        return;
        wU(paramBoolean);
        return;
        f(paramBoolean, (ArrayList)paramObject);
        return;
        bm(paramBoolean, paramObject);
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length <= 0);
    aB(paramBoolean, (String)paramObject[0]);
  }
  
  protected void wU(boolean paramBoolean) {}
  
  protected void xq(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afsr
 * JD-Core Version:    0.7.0.1
 */