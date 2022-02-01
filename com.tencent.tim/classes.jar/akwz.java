import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class akwz
{
  public static long Wn = 0L;
  public static akwz.a a;
  public static boolean cuM;
  protected long Wo = 524288000L;
  protected long Wp = 31457280L;
  protected long Wq = 31457280L;
  protected long Wr = 31457280L;
  protected long aeA;
  protected long aez;
  protected QQAppInterface mApp;
  
  public static final void d(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    dDM();
    a.c(paramLong, paramBoolean1, paramBoolean2);
  }
  
  public static final void dDL()
  {
    dDM();
    a.dDO();
  }
  
  public static final void dDM()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new akwz.a();
        }
        return;
      }
      finally {}
    }
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    dDN();
    paramBoolean = asR();
    if (QLog.isColorLevel()) {
      akxe.a("PIC_TAG_PRELOAD", "isOverLimit", "isInDPCWhiteList:" + paramBoolean);
    }
    if ((paramInt2 == 0) || ((paramBoolean) && (paramInt2 != 3)))
    {
      if (this.aeA >= this.Wo)
      {
        akxp.ak(paramInt2, this.Wo);
        akxe.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowWIFI:" + this.aeA);
        return -8;
      }
    }
    else if (paramInt2 == 1)
    {
      if (this.aez >= this.Wp)
      {
        akxp.ak(paramInt2, this.Wp);
        akxe.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowXG:" + this.aez + ",PreDownMax4GFlow:" + this.Wp);
        return -8;
      }
    }
    else if (paramInt2 == 2)
    {
      if (this.aez >= this.Wq)
      {
        akxp.ak(paramInt2, this.Wq);
        akxe.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowXG:" + this.aez + ",PreDownMax3GFlow:" + this.Wq);
        return -8;
      }
    }
    else if ((paramInt2 == 3) && (this.aez >= this.Wr))
    {
      akxp.ak(paramInt2, this.Wr);
      akxe.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowXG:" + this.aez + ",PreDownMax2GFlow:" + this.Wr);
      return -8;
    }
    return 0;
  }
  
  public boolean asR()
  {
    return DeviceProfileManager.a().isFeatureSupported(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name());
  }
  
  public void dDN()
  {
    dDM();
    long[] arrayOfLong = a.i();
    this.aez = (arrayOfLong[0] + arrayOfLong[1]);
    this.aeA = (arrayOfLong[2] + arrayOfLong[3]);
    if (QLog.isColorLevel()) {
      akxe.M("PIC_TAG_PRELOAD", "", "updateTrafficData ", "picTrafficFlowXG:" + this.aez + ",C2CPicDownFlowXG:" + arrayOfLong[0] + ",Group/DiscussPicDownFlowXG:" + arrayOfLong[1] + ",picTrafficFlowWIFI:" + this.aeA + ",C2CPicDownFlowWIFI:" + arrayOfLong[2] + ",Group/DiscussPicDownFlowWIFI:" + arrayOfLong[3]);
    }
  }
  
  public void init()
  {
    cuM = akxo.a("PicPreDownSwitch", Boolean.valueOf(false)).booleanValue();
    Wn = akxo.i("PicAuDownTimePoint", 0L);
    this.Wo = akxo.i("MaxWifiFlow", 524288000L);
    this.Wp = akxo.i("Max4GFlow", 31457280L);
    this.Wq = akxo.i("Max3GFlow", 31457280L);
    this.Wr = akxo.i("Max2GFlow", 31457280L);
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD.BaseStrategy", 2, "initConfig(): PreDownUseLocalFlowSet=" + cuM + " PicAuDownTimePoint=" + Wn + " PreDownMaxWifiFlow=" + this.Wo + " PreDownMax4GFlow=" + this.Wp + " PreDownMax3GFlow=" + this.Wq + " PreDownMax2GFlow=" + this.Wr);
    }
  }
  
  public void z(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    init();
  }
  
  public static class a
  {
    private long aeB;
    private long aeC;
    public long aeD = this.pref.getLong("key_xg_c2c", 0L);
    public long aeE = this.pref.getLong("key_xg_grp", 0L);
    public long aeF = this.pref.getLong("key_wifi_c2c", 0L);
    public long aeG = this.pref.getLong("key_wifi_grp", 0L);
    public long lastUpdateTime = this.pref.getLong("key_update_time", System.currentTimeMillis());
    private SharedPreferences pref = BaseApplicationImpl.getApplication().getSharedPreferences("sp_pic_predown", 0);
    
    public boolean c(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    {
      boolean bool = false;
      for (;;)
      {
        try
        {
          long l = System.currentTimeMillis();
          int i;
          if (!cx(l))
          {
            i = 1;
            if (!paramBoolean1) {
              break label112;
            }
            if (paramBoolean2)
            {
              this.aeD += paramLong;
              if (Math.abs(l - this.lastUpdateTime) <= 60000L) {
                break label143;
              }
              j = 1;
              this.lastUpdateTime = l;
              if (i == 0)
              {
                paramBoolean1 = bool;
                if (j == 0) {}
              }
              else
              {
                paramBoolean1 = true;
              }
              return paramBoolean1;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          this.aeE += paramLong;
          continue;
          if (!paramBoolean2) {
            break label130;
          }
        }
        finally {}
        label112:
        this.aeF += paramLong;
        continue;
        label130:
        this.aeG += paramLong;
        continue;
        label143:
        int j = 0;
      }
    }
    
    /* Error */
    public boolean cx(long paramLong)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 84	akwz$a:aeB	J
      //   6: lconst_0
      //   7: lcmp
      //   8: ifne +47 -> 55
      //   11: invokestatic 90	java/util/TimeZone:getDefault	()Ljava/util/TimeZone;
      //   14: aload_0
      //   15: getfield 51	akwz$a:lastUpdateTime	J
      //   18: invokevirtual 94	java/util/TimeZone:getOffset	(J)I
      //   21: i2l
      //   22: lstore_3
      //   23: aload_0
      //   24: aload_0
      //   25: getfield 51	akwz$a:lastUpdateTime	J
      //   28: lload_3
      //   29: ladd
      //   30: ldc2_w 95
      //   33: ldiv
      //   34: ldc2_w 95
      //   37: lmul
      //   38: lload_3
      //   39: lsub
      //   40: putfield 98	akwz$a:aeC	J
      //   43: aload_0
      //   44: aload_0
      //   45: getfield 98	akwz$a:aeC	J
      //   48: ldc2_w 95
      //   51: ladd
      //   52: putfield 84	akwz$a:aeB	J
      //   55: lload_1
      //   56: aload_0
      //   57: getfield 84	akwz$a:aeB	J
      //   60: lcmp
      //   61: ifgt +12 -> 73
      //   64: lload_1
      //   65: aload_0
      //   66: getfield 98	akwz$a:aeC	J
      //   69: lcmp
      //   70: ifge +46 -> 116
      //   73: aload_0
      //   74: lconst_0
      //   75: putfield 84	akwz$a:aeB	J
      //   78: aload_0
      //   79: lconst_0
      //   80: putfield 98	akwz$a:aeC	J
      //   83: aload_0
      //   84: lconst_0
      //   85: putfield 67	akwz$a:aeG	J
      //   88: aload_0
      //   89: lconst_0
      //   90: putfield 63	akwz$a:aeF	J
      //   93: aload_0
      //   94: lconst_0
      //   95: putfield 59	akwz$a:aeE	J
      //   98: aload_0
      //   99: lconst_0
      //   100: putfield 55	akwz$a:aeD	J
      //   103: aload_0
      //   104: lload_1
      //   105: putfield 51	akwz$a:lastUpdateTime	J
      //   108: iconst_0
      //   109: istore 5
      //   111: aload_0
      //   112: monitorexit
      //   113: iload 5
      //   115: ireturn
      //   116: iconst_1
      //   117: istore 5
      //   119: goto -8 -> 111
      //   122: astore 6
      //   124: aload_0
      //   125: monitorexit
      //   126: aload 6
      //   128: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	129	0	this	a
      //   0	129	1	paramLong	long
      //   22	17	3	l	long
      //   109	9	5	bool	boolean
      //   122	5	6	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	55	122	finally
      //   55	73	122	finally
      //   73	108	122	finally
    }
    
    public void dDO()
    {
      try
      {
        SharedPreferences.Editor localEditor = this.pref.edit();
        localEditor.putLong("key_update_time", this.lastUpdateTime);
        localEditor.putLong("key_xg_c2c", this.aeD);
        localEditor.putLong("key_xg_grp", this.aeE);
        localEditor.putLong("key_wifi_c2c", this.aeF);
        localEditor.putLong("key_wifi_grp", this.aeG);
        localEditor.commit();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public long[] i()
    {
      try
      {
        cx(System.currentTimeMillis());
        long l1 = this.aeD;
        long l2 = this.aeE;
        long l3 = this.aeF;
        long l4 = this.aeG;
        return new long[] { l1, l2, l3, l4 };
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akwz
 * JD-Core Version:    0.7.0.1
 */