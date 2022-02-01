import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class axtp
  implements axpo
{
  public static final String[] bU = { "NoNeedDown", "NoFound", "NeedDown" };
  public axpn a;
  axtp.a a;
  public int index;
  public String resId;
  public int resType;
  
  public axpn a()
  {
    Object localObject1 = this.jdField_a_of_type_Axpn;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      switch (this.resType)
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Axpn = ((axpn)localObject1);
      localObject2 = localObject1;
      return localObject2;
      localObject1 = ((axpr)axov.a(5)).a(this.resId);
      continue;
      localObject1 = ((axpr)axov.a(5)).a(this.resId);
      continue;
      localObject1 = axsq.a(this.resId);
      continue;
      localObject1 = axsq.a("", this.resId, "forPredownlaod", 0.0F, 0.0F, 0.0F);
      continue;
      localObject1 = axsq.b(this.resId);
      continue;
      localObject1 = axsq.a(this.resId, new ArrayList(), 0.0F, 0.0F, 0.0F);
    }
  }
  
  public void a(axpn paramaxpn) {}
  
  public void a(axpn paramaxpn, int paramInt)
  {
    this.jdField_a_of_type_Axtp$a.a(false, this);
  }
  
  public void a(axtp.a parama)
  {
    this.jdField_a_of_type_Axtp$a = parama;
  }
  
  public void b(axpn paramaxpn)
  {
    this.jdField_a_of_type_Axtp$a.a(true, this);
  }
  
  public void eON()
  {
    axpn localaxpn = a();
    if (localaxpn != null)
    {
      localaxpn.a(this);
      localaxpn.Rq();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QIMPredownManager", 2, "starDownload: " + this + localaxpn);
    }
  }
  
  public int getState()
  {
    axpn localaxpn = a();
    int i;
    if (localaxpn != null) {
      if (localaxpn.getState() == 2) {
        i = 2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMPredownManager", 2, String.format("getState %s %s %s %s ", new Object[] { toString(), "" + localaxpn, bU[i], axtq.jo[this.resType] }));
      }
      return i;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  public String toString()
  {
    return "QIMPredownJob{" + this.index + "," + axtq.jo[this.resType] + "," + this.resId + '}';
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, axtp paramaxtp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axtp
 * JD-Core Version:    0.7.0.1
 */