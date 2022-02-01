import com.tencent.av.app.VideoAppInterface;

public class ikt
  extends ijo
{
  private ikv jdField_a_of_type_Ikv;
  private iku[] jdField_a_of_type_ArrayOfIku = new iku[15];
  private Object lock = new Object();
  
  public ikt(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Ikv = new ikv(paramVideoAppInterface);
  }
  
  private iku a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfIku[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.lock)
    {
      iku localiku = this.jdField_a_of_type_ArrayOfIku[paramInt];
      localObject1 = localiku;
      if (localiku == null)
      {
        localiku = a(this.mApp, paramInt);
        localObject1 = localiku;
        if (localiku != null)
        {
          this.jdField_a_of_type_ArrayOfIku[paramInt] = localiku;
          localObject1 = localiku;
        }
      }
      return localObject1;
    }
  }
  
  private iku a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      localObject = this.jdField_a_of_type_Ikv;
    }
    for (;;)
    {
      if (localObject != null) {
        ((iku)localObject).onCreate();
      }
      long l2 = System.currentTimeMillis();
      igd.aJ("EffectSupportManager", "create Manager,cost time:" + (l2 - l1));
      return localObject;
      localObject = new iky(paramVideoAppInterface);
      continue;
      localObject = new ikw(paramVideoAppInterface);
      continue;
      localObject = new ikx(paramVideoAppInterface);
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    igd.aJ("EffectSupportManager", "EffectFaceSupportManager onSessionStatusChanged " + paramInt);
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 1: 
      kT(255);
      return;
    }
    restore();
  }
  
  public boolean b(int paramInt1, int paramInt2, String paramString)
  {
    iku localiku = a(paramInt1);
    if (localiku != null) {
      return localiku.e(paramInt2, paramString);
    }
    return false;
  }
  
  protected boolean cs(String paramString)
  {
    return true;
  }
  
  public boolean d(int paramInt, String paramString)
  {
    boolean bool = true;
    iku localiku = a(paramInt);
    if (localiku != null) {
      bool = localiku.ct(paramString);
    }
    return bool;
  }
  
  public int k(int paramInt, String paramString)
  {
    int i = 1;
    iku localiku = a(paramInt);
    paramInt = i;
    if (localiku != null) {
      paramInt = localiku.an(paramString);
    }
    return paramInt;
  }
  
  public void kT(int paramInt)
  {
    int i = 0;
    while (i < 15)
    {
      if ((paramInt == 255) || (paramInt == i))
      {
        iku localiku = a(i);
        if (localiku != null) {
          localiku.anD();
        }
      }
      i += 1;
    }
  }
  
  protected void onCreate() {}
  
  public void restore()
  {
    int i = 0;
    while (i < 15)
    {
      iku localiku = a(i);
      if (localiku != null) {
        localiku.restore();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ikt
 * JD-Core Version:    0.7.0.1
 */