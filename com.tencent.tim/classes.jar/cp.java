import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cp
{
  private List<co> N;
  public co a;
  private cp.a jdField_a_of_type_Cp$a;
  private syv jdField_a_of_type_Syv;
  private acdl c;
  private QQAppInterface mApp;
  
  public cp(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.N = new ArrayList();
    this.c = new cq(this);
    this.jdField_a_of_type_Syv = new cr(this);
  }
  
  private void G(int paramInt)
  {
    i();
    if (this.jdField_a_of_type_Cp$a != null) {
      this.jdField_a_of_type_Cp$a.E(paramInt);
    }
  }
  
  public static DeviceInfo a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramLong != 0L)
    {
      paramQQAppInterface = (syw)paramQQAppInterface.getBusinessHandler(51);
      if (paramQQAppInterface.Nz())
      {
        DeviceInfo[] arrayOfDeviceInfo = paramQQAppInterface.b();
        if (arrayOfDeviceInfo != null)
        {
          int j = arrayOfDeviceInfo.length;
          int i = 0;
          while (i < j)
          {
            DeviceInfo localDeviceInfo = arrayOfDeviceInfo[i];
            if ((paramQQAppInterface.bn(localDeviceInfo.din)) && (paramQQAppInterface.i(localDeviceInfo.din, 17)) && (paramLong == localDeviceInfo.din)) {
              return localDeviceInfo;
            }
            i += 1;
          }
        }
      }
    }
    return null;
  }
  
  public boolean B(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      int i = ahav.getFileType(paramString);
      if ((i != 3) && (i != 0) && (i != 7) && (i != 6) && (i != 9))
      {
        bool1 = bool2;
        if (i != 10) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void I(String paramString)
  {
    if (paramString == null) {
      return;
    }
    String str = this.mApp.getCurrentAccountUin();
    aqfe.J(this.mApp.getApplication(), str + "_last_printer", paramString);
  }
  
  public boolean Y()
  {
    return ((ackv)this.mApp.getBusinessHandler(10)).bi() != 0;
  }
  
  public co a()
  {
    String str = this.mApp.getCurrentAccountUin();
    str = aqfe.get(this.mApp.getApplication(), str + "_last_printer");
    i();
    return b(str);
  }
  
  public co a(long paramLong)
  {
    if ((paramLong != 0L) && (this.N.size() > 0))
    {
      Iterator localIterator = this.N.iterator();
      while (localIterator.hasNext())
      {
        co localco = (co)localIterator.next();
        if (localco.ai == paramLong) {
          return localco;
        }
      }
    }
    return null;
  }
  
  public co a(String paramString)
  {
    cn localcn = null;
    if (paramString != null)
    {
      localcn = new cn();
      localcn.dB = 1;
      localcn.ai = 0L;
      localcn.bJ = paramString;
      localcn.by = true;
      localcn.isOnline = true;
      localcn.bv = true;
    }
    return localcn;
  }
  
  public void a(cp.a parama)
  {
    if (this.mApp != null)
    {
      this.mApp.addObserver(this.c);
      this.mApp.addObserver(this.jdField_a_of_type_Syv);
    }
    this.jdField_a_of_type_Cp$a = parama;
  }
  
  public co b(String paramString)
  {
    if ((paramString != null) && (this.N.size() > 0))
    {
      Iterator localIterator = this.N.iterator();
      while (localIterator.hasNext())
      {
        co localco = (co)localIterator.next();
        if (localco.bJ.equals(paramString)) {
          return localco;
        }
      }
    }
    return null;
  }
  
  public void ch()
  {
    if (this.mApp != null)
    {
      this.mApp.removeObserver(this.c);
      this.mApp.removeObserver(this.jdField_a_of_type_Syv);
    }
    this.jdField_a_of_type_Cp$a = null;
  }
  
  public List<co> i()
  {
    this.N.clear();
    Object localObject = (acde)this.mApp.getBusinessHandler(8);
    if (((acde)localObject).a.K != null)
    {
      localObject = ((acde)localObject).a.K.iterator();
      while (((Iterator)localObject).hasNext())
      {
        co localco = a((String)((Iterator)localObject).next());
        this.N.add(localco);
      }
    }
    return this.N;
  }
  
  public static abstract interface a
  {
    public abstract void E(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cp
 * JD-Core Version:    0.7.0.1
 */