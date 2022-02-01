package wf7;

import java.util.ArrayList;

class ef$1
  implements em.a
{
  ef$1(ef paramef, ef.a parama, int paramInt, dl paramdl) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList<ae> paramArrayList)
  {
    if (paramInt1 != 0)
    {
      this.lX.a(this.lY, 1, paramInt1, null);
      return;
    }
    if (paramArrayList == null)
    {
      this.lX.a(this.lY, 1, -21250000, null);
      return;
    }
    if (paramArrayList.size() <= 0)
    {
      this.lX.a(this.lY, 1, -21250000, null);
      return;
    }
    paramArrayList = (ae)paramArrayList.get(0);
    if (paramArrayList == null)
    {
      this.lX.a(this.lY, 1, -21250000, null);
      return;
    }
    if (paramArrayList.cc != 0)
    {
      this.lX.a(this.lY, 1, paramArrayList.cc, null);
      return;
    }
    if (paramArrayList.cd != 0)
    {
      this.lX.a(this.lY, 1, -21300000, null);
      return;
    }
    byte[] arrayOfByte = paramArrayList.data;
    if (arrayOfByte == null)
    {
      this.lX.a(this.lY, 1, -21000005, null);
      return;
    }
    aa localaa = new aa();
    try
    {
      paramArrayList = ee.a(ef.a(this.ma), ef.b(this.ma).cO().lv.getBytes(), arrayOfByte, localaa, false, paramArrayList.cf);
      if (paramArrayList == null)
      {
        this.lX.a(this.lY, 1, -21000400, null);
        return;
      }
      paramArrayList = (aa)paramArrayList;
      ef.a(this.ma, paramArrayList.aX, this.lZ, true);
      this.lX.a(this.lY, 1, 0, paramArrayList.aX);
      return;
    }
    catch (Exception paramArrayList)
    {
      label304:
      break label304;
    }
    this.lX.a(this.lY, 1, -21000400, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.ef.1
 * JD-Core Version:    0.7.0.1
 */