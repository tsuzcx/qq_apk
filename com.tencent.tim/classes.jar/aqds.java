import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.HbThemeConfigManager.1;
import com.tencent.mobileqq.util.HbThemeConfigManager.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class aqds
{
  private static aqds a;
  private static String csr;
  private static byte[] mLock = new byte[0];
  private JSONObject ca;
  
  /* Error */
  public static aqds a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 23	aqds:a	Laqds;
    //   6: ifnonnull +27 -> 33
    //   9: getstatic 16	aqds:mLock	[B
    //   12: astore_0
    //   13: aload_0
    //   14: monitorenter
    //   15: getstatic 23	aqds:a	Laqds;
    //   18: ifnonnull +13 -> 31
    //   21: new 2	aqds
    //   24: dup
    //   25: invokespecial 24	aqds:<init>	()V
    //   28: putstatic 23	aqds:a	Laqds;
    //   31: aload_0
    //   32: monitorexit
    //   33: getstatic 23	aqds:a	Laqds;
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: areturn
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   47	5	0	localObject2	Object
    //   42	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	31	42	finally
    //   31	33	42	finally
    //   43	45	42	finally
    //   3	15	47	finally
    //   33	37	47	finally
    //   45	47	47	finally
  }
  
  private String l(AppInterface paramAppInterface)
  {
    return aagi.bcS + paramAppInterface.getCurrentAccountUin() + File.separator;
  }
  
  public String BO()
  {
    return csr;
  }
  
  public void Ur(String paramString)
  {
    csr = paramString;
  }
  
  public void b(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HbThemeConfigManager", 2, "updateFaceConfig failed : config = null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HbThemeConfigManager", 2, "updateFaceConfig config = " + paramJSONObject.toString());
    }
    paramQQAppInterface = new HbThemeConfigManager.1(this, paramQQAppInterface.getApp(), paramJSONObject, paramQQAppInterface);
    ThreadManager.getFileThreadHandler().post(paramQQAppInterface);
  }
  
  public void bc(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getCurrentAccountUin())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HbThemeConfigManager", 2, "update hbTheme config, but AppInterface is null or account is empty return. ");
      }
      return;
    }
    ThreadManager.post(new HbThemeConfigManager.2(this, paramString, paramQQAppInterface), 5, null, false);
  }
  
  public JSONObject d(Context paramContext)
  {
    if (this.ca == null)
    {
      paramContext = paramContext.getSharedPreferences("qb_tenpay_share_face", 0).getString("hb_face", "");
      if (TextUtils.isEmpty(paramContext)) {
        return null;
      }
    }
    try
    {
      this.ca = new JSONObject(paramContext);
      return this.ca;
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public void onDestory()
  {
    synchronized (mLock)
    {
      a = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqds
 * JD-Core Version:    0.7.0.1
 */