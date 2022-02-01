import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class mst
{
  private static String Um;
  private static String akf = kxm.ads;
  private static String akg = kxm.ads;
  public static boolean anQ;
  private static mst b;
  private static long wA;
  private boolean Tn;
  protected boolean anM = true;
  private boolean anN;
  private boolean anO = true;
  public boolean anP;
  private int channelId = 0;
  public float jG;
  public float jH = -1.0F;
  public float jI = -1.0F;
  public Context mContext;
  private long wB = -1L;
  
  public mst()
  {
    this(-1);
  }
  
  private mst(int paramInt)
  {
    this.wB = paramInt;
    this.mContext = BaseApplicationImpl.getApplication().getApplicationContext();
    this.jG = this.mContext.getResources().getDisplayMetrics().heightPixels;
    this.jI = ((int)(this.mContext.getResources().getDisplayMetrics().widthPixels / 16.0D * 9.0D));
    this.jH = (2.0F * this.jI * 1.2F);
    if (Build.VERSION.SDK_INT >= 14) {}
    for (;;)
    {
      this.anM = bool;
      aRN();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "mDeviceAutoPlaySwitch : " + this.anM);
      }
      return;
      bool = false;
    }
  }
  
  public static boolean Ei()
  {
    if (wA == -1L) {
      return false;
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
      if (!str.equals(Um))
      {
        Um = str;
        wA = -1L;
        return false;
      }
    }
    if (System.currentTimeMillis() - wA < 600000L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static mst a()
  {
    try
    {
      if (b == null) {
        b = new mst();
      }
      mst localmst = b;
      return localmst;
    }
    finally {}
  }
  
  private void aRN()
  {
    if (this.anO) {
      akf = kxm.iP();
    }
  }
  
  public static boolean as(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected()) && (paramContext.getState() == NetworkInfo.State.CONNECTED))
        {
          int i = paramContext.getType();
          if (i == 1) {
            return true;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      QLog.d(mst.class.getSimpleName(), 2, paramContext.toString());
    }
    return false;
  }
  
  public boolean Ef()
  {
    return this.anN;
  }
  
  public boolean Eg()
  {
    if (kxm.adq.equals(akf)) {}
    while ((aqiw.isWifiConnected(this.mContext)) || (Ei())) {
      return false;
    }
    return true;
  }
  
  public boolean Eh()
  {
    if (kxm.adq.equals(akf)) {}
    while ((aqiw.isWifiConnected(this.mContext)) || (this.anP)) {
      return false;
    }
    return true;
  }
  
  public void eJ(long paramLong)
  {
    this.wB = paramLong;
  }
  
  public boolean isWifi()
  {
    return this.Tn;
  }
  
  public boolean nW()
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d("VideoAutoPlayController", 2, "canAutoPlayVideo：getKandianMode: " + kxm.nR());
    }
    QQAppInterface localQQAppInterface = kxm.a();
    if ((localQQAppInterface != null) && (localQQAppInterface.bF())) {}
    do
    {
      do
      {
        return false;
        if (kxm.nR() != 6) {
          break;
        }
        akg = kxm.aq(this.wB);
      } while (kxm.ads.equals(akg));
      if ((kxm.adq.equals(akg)) && (aqiw.isNetworkAvailable(this.mContext))) {
        return this.anM;
      }
      if ((this.Tn) && (this.anM)) {}
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
      akf = kxm.aq(this.wB);
    } while (kxm.ads.equals(akf));
    if ((kxm.adq.equals(akf)) && (aqiw.isNetworkAvailable(this.mContext))) {
      return this.anM;
    }
    if (this.channelId == 0)
    {
      if (((this.Tn) || (knc.al(a().mContext))) && (this.anM)) {}
      for (bool1 = bool2;; bool1 = false) {
        return bool1;
      }
    }
    if ((this.Tn) && (this.anM)) {}
    for (bool1 = bool3;; bool1 = false) {
      return bool1;
    }
  }
  
  public void oc(boolean paramBoolean)
  {
    this.anN = paramBoolean;
  }
  
  public void od(boolean paramBoolean)
  {
    this.Tn = paramBoolean;
  }
  
  public void setChannelId(int paramInt)
  {
    this.channelId = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mst
 * JD-Core Version:    0.7.0.1
 */