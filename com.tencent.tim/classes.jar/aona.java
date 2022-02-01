import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class aona
{
  public static aona.c a = new aona.a();
  public static aona.c b = new aona.b();
  public static aona.c c = new aona.e();
  private static int dPZ = 18;
  private static int dQa = 6;
  private static int dQb = 600000;
  
  public static int KO()
  {
    try
    {
      int i = dPZ;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int KP()
  {
    try
    {
      int i = dQa;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int KQ()
  {
    try
    {
      int i = dQb;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void Sa(String paramString)
  {
    int i = 0;
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        if (paramString.length() > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RichMediaStrategy", 2, "updataFromDpc: dpcString = " + paramString);
          }
          paramString = paramString.split("\\|");
          int j;
          if (paramString != null)
          {
            j = paramString.length;
            if (j == 3) {
              if (i >= 3) {
                continue;
              }
            }
          }
          try
          {
            j = Integer.valueOf(paramString[i]).intValue();
            if (j > 0) {
              continue;
            }
          }
          catch (NumberFormatException paramString)
          {
            QLog.e("RichMediaStrategy", 2, "updataFromDpc Erro", paramString);
            continue;
          }
          return;
          i += 1;
          continue;
          dPZ = Integer.valueOf(paramString[0]).intValue();
          dQa = Integer.valueOf(paramString[1]).intValue();
          dQb = Integer.valueOf(paramString[2]).intValue() * 1000;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("RichMediaStrategy", 2, "updataFromDpc: TryCount_dpc = " + dPZ + " FixSchedulTryCount_dpc = " + dQa + " TryTime_dpc = " + dQb);
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      finally {}
      QLog.d("RichMediaStrategy", 2, "updataFromDpc: dpcString is null !");
    }
  }
  
  public static aona.c a(int paramInt)
  {
    aona.c localc = a;
    switch (paramInt)
    {
    case 0: 
    case 2: 
    default: 
      return localc;
    case 1: 
    case 4: 
    case 5: 
      return c;
    }
    return b;
  }
  
  public static boolean isNetworkError(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 9052) || (paramInt == 9050) || (paramInt == 9051) || (paramInt == 9054) || (paramInt == 9053) || (paramInt == 9055) || (paramInt == 9014) || (paramInt == 9047)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean lQ(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 9361) || (paramInt == 9037)) {
      bool = true;
    }
    return bool;
  }
  
  public static class a
    extends aona.c
  {
    private int connectTimeout = 20000;
    private int dQc = 9;
    private int dQd = 3;
    private int dQe = 5000;
    private int readTimeout = 40000;
    private int timeLimit = 480000;
    
    public int getConnectTimeout()
    {
      return this.connectTimeout;
    }
    
    public int getReadTimeout()
    {
      return this.readTimeout;
    }
  }
  
  public static class b
    extends aona.c
  {
    private int connectTimeout = 15000;
    private int dQc = 9;
    private int dQd = 3;
    private int dQe = 4000;
    private int readTimeout = 30000;
    private int timeLimit = 420000;
    
    public int getConnectTimeout()
    {
      return this.connectTimeout;
    }
    
    public int getReadTimeout()
    {
      return this.readTimeout;
    }
  }
  
  public static class c
  {
    private int connectTimeout = 20000;
    private int dQc = 9;
    private int dQd = 3;
    private int dQe = 5000;
    private int readTimeout = 40000;
    private int timeLimit = 480000;
    
    public int getConnectTimeout()
    {
      return this.connectTimeout;
    }
    
    public int getReadTimeout()
    {
      return this.readTimeout;
    }
  }
  
  public static class d
  {
    public static boolean cNl;
    private aona.d.a c = new aona.d.a();
    
    public d()
    {
      Sb(DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.HttpTimeoutParam.name()));
      registerObserver();
    }
    
    private void registerObserver()
    {
      DeviceProfileManager.a(new aonb(this));
    }
    
    public void Sb(String paramString)
    {
      if ((paramString == null) || ("".equals(paramString))) {}
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("RichMediaStrategy", 2, "OldEngine Timeout Params : " + paramString);
        }
        paramString = paramString.split("\\|");
      } while ((paramString == null) || (paramString.length != 6));
      try
      {
        this.c.dQi = (Integer.valueOf(paramString[0]).intValue() * 1000);
        this.c.dQj = (Integer.valueOf(paramString[1]).intValue() * 1000);
        this.c.dQk = (Integer.valueOf(paramString[2]).intValue() * 1000);
        this.c.dQf = (Integer.valueOf(paramString[3]).intValue() * 1000);
        this.c.dQg = (Integer.valueOf(paramString[4]).intValue() * 1000);
        this.c.dQh = (Integer.valueOf(paramString[5]).intValue() * 1000);
        cNl = true;
        return;
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
      }
    }
    
    public aona.d.a b()
    {
      return this.c.c();
    }
    
    public static class a
    {
      public int dQf = 40000;
      public int dQg = 30000;
      public int dQh = 20000;
      public int dQi = 20000;
      public int dQj = 15000;
      public int dQk = 10000;
      private int dQl;
      
      public a() {}
      
      private a(a parama)
      {
        this.dQf = parama.dQf;
        this.dQg = parama.dQg;
        this.dQh = parama.dQh;
        this.dQi = parama.dQi;
        this.dQj = parama.dQj;
        this.dQk = parama.dQk;
      }
      
      public void VY(int paramInt)
      {
        this.dQl = (paramInt * 2000);
      }
      
      public a c()
      {
        return new a(this);
      }
      
      public int jB(int paramInt)
      {
        switch (paramInt)
        {
        case 2: 
        default: 
          return this.dQf;
        case 1: 
        case 4: 
        case 5: 
          return this.dQh;
        }
        return this.dQg;
      }
      
      public int jC(int paramInt)
      {
        switch (paramInt)
        {
        case 2: 
        default: 
          return this.dQi + this.dQl;
        case 1: 
        case 4: 
        case 5: 
          return this.dQk + this.dQl;
        }
        return this.dQj + this.dQl;
      }
    }
  }
  
  public static class e
    extends aona.c
  {
    private int connectTimeout = 10000;
    private int dQc = 9;
    private int dQd = 3;
    private int dQe = 3000;
    private int readTimeout = 20000;
    private int timeLimit = 360000;
    
    public int getConnectTimeout()
    {
      return this.connectTimeout;
    }
    
    public int getReadTimeout()
    {
      return this.readTimeout;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aona
 * JD-Core Version:    0.7.0.1
 */