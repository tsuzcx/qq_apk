package wf7;

import android.text.TextUtils;
import java.util.ArrayList;

class ej$1
  extends ek
{
  ej$1(ej paramej, String paramString, x paramx, ej.a parama, int paramInt)
  {
    super(paramString);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList<ae> paramArrayList)
  {
    if (paramInt1 != 0)
    {
      this.mx.a(this.lY, 152, paramInt1);
      return;
    }
    if (paramArrayList == null)
    {
      this.mx.a(this.lY, 152, -21250000);
      return;
    }
    if (paramArrayList.size() <= 0)
    {
      this.mx.a(this.lY, 152, -21250000);
      return;
    }
    paramArrayList = (ae)paramArrayList.get(0);
    if (paramArrayList == null)
    {
      this.mx.a(this.lY, 152, -21250000);
      return;
    }
    if (paramArrayList.cc != 0)
    {
      this.mx.a(this.lY, 152, paramArrayList.cc);
      return;
    }
    if (paramArrayList.cd != 0)
    {
      this.mx.a(this.lY, 152, -21300000);
      return;
    }
    if (paramArrayList.data == null)
    {
      this.mx.a(this.lY, 152, -21000005);
      return;
    }
    s locals = new s();
    try
    {
      paramArrayList = ee.a(null, this.mz.getBytes(), paramArrayList.data, locals, false, paramArrayList.cf);
      if (paramArrayList == null)
      {
        this.mx.a(this.lY, 152, -21000400);
        return;
      }
    }
    catch (Exception paramArrayList)
    {
      this.mx.a(this.lY, 152, -21000400);
      return;
    }
    paramArrayList = (s)paramArrayList;
    if (TextUtils.isEmpty(paramArrayList.aZ))
    {
      this.mx.a(this.lY, 152, -21280000);
      return;
    }
    ej.a(this.my, this.mz, paramArrayList.aZ);
    this.mx.a(this.lY, 152, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.ej.1
 * JD-Core Version:    0.7.0.1
 */