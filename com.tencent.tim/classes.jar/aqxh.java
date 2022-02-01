import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.manager.Manager;

public class aqxh
  implements Manager
{
  private final String TAG = "VipGiftManager";
  private QQAppInterface a;
  private aqxg b = new aqxg();
  private String device;
  public long timeout = 10000L;
  
  public aqxh(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.device = getDeviceInfo();
    gk();
  }
  
  private String CC()
  {
    if (this.b != null) {
      return this.b.cyv + "|" + this.b.senderuin + "|" + this.b.time + "|" + this.b.progress + "|" + this.b.status + "|" + this.b.uniseq + "|" + this.b.cyw + "|" + this.b.resid + "|" + this.b.Cr + "|" + this.b.version;
    }
    return null;
  }
  
  /* Error */
  public boolean E(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: iload 6
    //   7: istore 5
    //   9: lload_3
    //   10: aload_0
    //   11: getfield 29	aqxh:b	Laqxg;
    //   14: getfield 76	aqxg:uniseq	J
    //   17: lcmp
    //   18: ifne +31 -> 49
    //   21: lload_1
    //   22: ldc2_w 94
    //   25: lcmp
    //   26: ifne +28 -> 54
    //   29: aload_0
    //   30: getfield 29	aqxh:b	Laqxg;
    //   33: getfield 73	aqxg:status	J
    //   36: lstore_3
    //   37: lload_3
    //   38: ldc2_w 96
    //   41: lcmp
    //   42: ifne +12 -> 54
    //   45: iload 6
    //   47: istore 5
    //   49: aload_0
    //   50: monitorexit
    //   51: iload 5
    //   53: ireturn
    //   54: aload_0
    //   55: getfield 29	aqxh:b	Laqxg;
    //   58: lload_1
    //   59: putfield 73	aqxg:status	J
    //   62: aload_0
    //   63: invokevirtual 101	aqxh:aFP	()Z
    //   66: istore 5
    //   68: goto -19 -> 49
    //   71: astore 7
    //   73: aload_0
    //   74: monitorexit
    //   75: aload 7
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	aqxh
    //   0	78	1	paramLong1	long
    //   0	78	3	paramLong2	long
    //   7	60	5	bool1	boolean
    //   1	45	6	bool2	boolean
    //   71	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	21	71	finally
    //   29	37	71	finally
    //   54	68	71	finally
  }
  
  public void S(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = paramString4;
    if (paramString4 == null) {
      str = this.b.cyw;
    }
    paramString4 = this.device;
    VipUtils.a(this.a, "Vip_Gift", paramString1, paramString1, 0, 0, new String[] { paramString2, paramString3, str, paramString4 });
  }
  
  public void VN(String paramString)
  {
    this.b.cyw = paramString;
    aFP();
  }
  
  public aqxg a()
  {
    return this.b;
  }
  
  public void a(aqxg paramaqxg, BaseActivity paramBaseActivity)
  {
    E(3L, paramaqxg.uniseq);
    String str = null;
    Object localObject;
    try
    {
      Uri localUri = Uri.parse(paramaqxg.cyw);
      localObject = str;
      if (localUri != null)
      {
        localObject = str;
        if (localUri.isHierarchical())
        {
          str = localUri.getQueryParameter("_bid");
          localObject = str;
          if (TextUtils.isEmpty(str))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VipGiftManager", 2, "TextUtils.isEmpty(bid) false");
            }
            E(5L, paramaqxg.uniseq);
            return;
          }
        }
      }
    }
    catch (Exception paramBaseActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipGiftManager", 2, "exception bid");
      }
      E(5L, paramaqxg.uniseq);
      return;
    }
    if (ar((String)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipGiftManager", 2, "showGifAnnimate.veryfyBid(" + (String)localObject + ") true,url:" + paramaqxg.cyw);
      }
      if (((String)localObject).equalsIgnoreCase("280")) {
        VN("https://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
      }
      S("0X8004B41", "2", "1", paramaqxg.cyw);
      localObject = new Intent(BaseApplication.getContext(), QQTranslucentBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramaqxg.cyw);
      ((Intent)localObject).putExtra("Gif_msg_uniseq_key", paramaqxg.uniseq);
      paramBaseActivity.startActivity((Intent)localObject);
      return;
    }
    if (ar("280"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipGiftManager", 2, "showGifAnnimate.veryfyBid(" + (String)localObject + ") false,url:" + paramaqxg.cyw);
      }
      VN("https://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
      S("0X8004B41", "2", "1", paramaqxg.cyw);
      localObject = new Intent(BaseApplication.getContext(), QQTranslucentBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramaqxg.cyw);
      ((Intent)localObject).putExtra("Gif_msg_uniseq_key", paramaqxg.uniseq);
      paramBaseActivity.startActivity((Intent)localObject);
      return;
    }
    E(5L, paramaqxg.uniseq);
  }
  
  public boolean aFO()
  {
    if (this.b == null) {
      this.b = new aqxg();
    }
    if ((this.b != null) && (this.b.status == 1L))
    {
      long l = NetConnInfoCenter.getServerTimeMillis() - this.b.Cr;
      if ((l > this.timeout) || (l <= 0L)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean aFP()
  {
    SharedPreferences.Editor localEditor = this.a.getPreferences().edit();
    localEditor.putString("Gif_Download_info_key_" + this.a.getCurrentAccountUin(), CC());
    if (QLog.isColorLevel()) {
      QLog.d("VipGiftManager", 2, "writeToSp:" + CC());
    }
    return localEditor.commit();
  }
  
  public boolean ar(String paramString)
  {
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    boolean bool2;
    do
    {
      do
      {
        return bool1;
      } while (jpa.dL(paramString) == null);
      str = jpe.dO(paramString) + paramString;
      bool2 = jqj.D(str, paramString);
      bool1 = bool2;
    } while (bool2);
    jpa.bn(str, paramString);
    return bool2;
  }
  
  public void bs(String paramString, long paramLong)
  {
    NewIntent localNewIntent = new NewIntent(this.a.getApplication(), anfc.class);
    localNewIntent.setAction("gif_ui_show");
    localNewIntent.putExtra("gif_ui_show_bid", Integer.parseInt(paramString));
    localNewIntent.putExtra("gif_ui_show_seq", paramLong);
    this.a.startServlet(localNewIntent);
  }
  
  public boolean c(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Build.VERSION.SDK_INT < 11) {}
    do
    {
      return true;
      if (paramBoolean2) {
        return false;
      }
    } while (paramInt == 2);
    return false;
  }
  
  public boolean cY(long paramLong)
  {
    if (this.b != null)
    {
      this.b.version = paramLong;
      return aFP();
    }
    return false;
  }
  
  public boolean cZ(long paramLong)
  {
    if (this.b == null) {}
    while ((this.b.status == 999L) || (this.b.status == 5L) || (this.b.status >= 2L) || (paramLong < this.b.time)) {
      return false;
    }
    return true;
  }
  
  public boolean f(MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing == null) {
      return false;
    }
    if (paramMessageForStructing.structingMsg == null) {
      return false;
    }
    S("0X8004B41", "1", "0", paramMessageForStructing.structingMsg.mResid);
    if (this.b == null) {
      this.b = new aqxg();
    }
    Uri localUri;
    boolean bool;
    try
    {
      localUri = Uri.parse(paramMessageForStructing.structingMsg.mResid);
      if ((localUri != null) && (localUri.isHierarchical()))
      {
        bool = TextUtils.isEmpty(localUri.getQueryParameter("_bid"));
        if (bool) {
          return false;
        }
      }
      else
      {
        return false;
      }
    }
    catch (Exception paramMessageForStructing)
    {
      return false;
    }
    long l;
    for (;;)
    {
      try
      {
        str = localUri.getQueryParameter("_gv");
        bool = TextUtils.isEmpty(str);
        if (!bool) {
          continue;
        }
        l = 0L;
      }
      catch (Exception localException)
      {
        String str;
        l = 0L;
        continue;
        if (this.b == null) {
          break label420;
        }
      }
      if (this.b.version > l)
      {
        S("0X8004B41", "2", "3", paramMessageForStructing.structingMsg.mResid);
        return false;
        l = Long.parseLong(str);
      }
      else if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null))
      {
        if (((this.b.status == 0L) && (paramMessageForStructing.time < this.b.time)) || (this.b.status == 4L) || (this.b.status == 999L) || (this.b.status == 5L) || (this.b.status == 6L) || (aFO()))
        {
          this.b.cyv = paramMessageForStructing.selfuin;
          this.b.senderuin = paramMessageForStructing.senderuin;
          this.b.time = paramMessageForStructing.time;
          this.b.progress = 0L;
          this.b.status = 0L;
          this.b.uniseq = paramMessageForStructing.uniseq;
          this.b.resid = paramMessageForStructing.structingMsg.mResid;
          this.b.cyw = paramMessageForStructing.structingMsg.mResid;
          this.b.Cr = 0L;
        }
      }
    }
    try
    {
      l = Long.parseLong(localUri.getQueryParameter("_to").trim());
      if (l > 0L) {
        this.timeout = l;
      }
    }
    catch (Exception paramMessageForStructing)
    {
      label398:
      label420:
      break label398;
    }
    return aFP();
    S("0X8004B41", "2", "2", paramMessageForStructing.structingMsg.mResid);
    return false;
  }
  
  public final String getDeviceInfo()
  {
    String str1 = Build.MODEL;
    String str2 = Build.VERSION.RELEASE;
    return "{\"model\":\"" + str1 + "\",\"systemName\":\"android\",\"systemVersion\":\"" + str2 + "\"}";
  }
  
  public void gk()
  {
    Object localObject = this.a.getPreferences().getString("Gif_Download_info_key_" + this.a.getCurrentAccountUin(), null);
    if ((localObject != null) && (this.b != null))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject != null) && (localObject.length == 10) && (this.b != null))
      {
        this.b.cyv = localObject[0];
        this.b.senderuin = localObject[1];
        this.b.time = Long.parseLong(localObject[2]);
        this.b.progress = Long.parseLong(localObject[3]);
        this.b.status = Long.parseLong(localObject[4]);
        this.b.uniseq = Long.parseLong(localObject[5]);
        this.b.cyw = localObject[6];
        this.b.resid = localObject[7];
        this.b.Cr = Long.parseLong(localObject[8]);
        this.b.version = Long.parseLong(localObject[9]);
      }
    }
  }
  
  public void me(long paramLong)
  {
    this.b.Cr = NetConnInfoCenter.getServerTimeMillis();
    E(1L, paramLong);
    Object localObject2 = null;
    int i;
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        try
        {
          Uri localUri = Uri.parse(this.b.resid);
          Object localObject1 = localObject2;
          if (localUri != null)
          {
            localObject1 = localObject2;
            if (localUri.isHierarchical()) {
              localObject1 = localUri.getQueryParameter("_bid");
            }
          }
          if ((localObject1 == null) || (((String)localObject1).length() == 0))
          {
            E(5L, paramLong);
            return;
          }
        }
        catch (Exception localException)
        {
          E(5L, paramLong);
          return;
        }
        i = aqiw.getSystemNetwork(BaseApplicationImpl.getContext());
        long l = System.currentTimeMillis();
        bool1 = ar(localException);
        if (QLog.isColorLevel()) {
          QLog.d("VipGiftManager", 2, "OfflineSecurity.verify bid:" + localException + ",cost:" + (System.currentTimeMillis() - l) + ",bigFlag:" + bool1);
        }
        l = System.currentTimeMillis();
        bool2 = ar("280");
        if (QLog.isColorLevel()) {
          QLog.d("VipGiftManager", 2, "OfflineSecurity.verify smalbid:280,cost:" + (System.currentTimeMillis() - l) + ",smallFlag:" + bool2);
        }
        if (i != 0) {
          break label295;
        }
        if (!bool1) {
          break;
        }
      } while (!E(2L, paramLong));
      bs(localException, paramLong);
      return;
    } while ((!bool2) || (!E(2L, paramLong)));
    VN("https://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
    bs("280", paramLong);
    return;
    label295:
    if (c(i, bool2, bool1))
    {
      if (bool2)
      {
        if (E(2L, paramLong))
        {
          VN("https://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
          bs("280", paramLong);
        }
        jpa.b("280", this.a, true, new aqxi(this));
        return;
      }
      v("280", null, paramLong);
      return;
    }
    if (bool1)
    {
      if (E(2L, paramLong)) {
        bs(localException, paramLong);
      }
      jpa.b(localException, this.a, true, new aqxj(this));
      return;
    }
    v(localException, "280", paramLong);
  }
  
  public void onDestroy() {}
  
  public void v(String paramString1, String paramString2, long paramLong)
  {
    long l = System.currentTimeMillis();
    jpa.b(paramString1, this.a, true, new aqxk(this, l, paramString1, paramLong, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqxh
 * JD-Core Version:    0.7.0.1
 */