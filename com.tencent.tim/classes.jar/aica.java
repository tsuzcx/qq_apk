import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.app.WtloginPrivacyListenerImpl;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;

public class aica
{
  aica.a a = new aica.a();
  long abi = 0L;
  WtloginHelper c;
  boolean isUpdating;
  List<aica.b> mListenerList = new ArrayList();
  
  private void k(String paramString, boolean paramBoolean, int paramInt)
  {
    Iterator localIterator = this.mListenerList.iterator();
    while (localIterator.hasNext())
    {
      aica.b localb = (aica.b)localIterator.next();
      if (localb != null) {
        localb.l(paramString, paramBoolean, paramInt);
      }
    }
    this.mListenerList.clear();
    this.isUpdating = false;
  }
  
  public aica.a a()
  {
    return this.a;
  }
  
  public void a(AppInterface paramAppInterface, String paramString1, Context paramContext, String paramString2, aica.b paramb)
  {
    if (!TextUtils.isEmpty(this.a.mOpenID))
    {
      if (paramb != null) {
        paramb.l(paramString1, true, 0);
      }
      return;
    }
    aicc localaicc = new aicc(this, paramb, paramString1);
    FastAuthorize.AuthorizeRequest localAuthorizeRequest = new FastAuthorize.AuthorizeRequest();
    localAuthorizeRequest.uin.set(Long.parseLong(paramAppInterface.getCurrentAccountUin()));
    localAuthorizeRequest.client_id.set(Long.parseLong(paramString2));
    localAuthorizeRequest.pf.set("");
    paramString2 = arxn.bI(paramContext);
    localAuthorizeRequest.qqv.set(paramString2);
    localAuthorizeRequest.sdkp.set("a");
    paramString2 = Build.DISPLAY;
    localAuthorizeRequest.os.set(paramString2);
    paramString2 = ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
    localAuthorizeRequest.skey.set(paramString2);
    paramString2 = "";
    if ((paramAppInterface instanceof QQAppInterface)) {
      paramString2 = ((QQAppInterface)paramAppInterface).rK();
    }
    for (;;)
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      localAuthorizeRequest.vkey.set(str);
      localAuthorizeRequest.flags.set(7);
      paramContext = new NewIntent(paramContext, jnl.class);
      localAuthorizeRequest.apk_sign.set("");
      paramContext.putExtra("cmd", "ConnAuthSvr.fast_qq_login");
      try
      {
        paramContext.putExtra("data", localAuthorizeRequest.toByteArray());
        paramContext.setObserver(localaicc);
        paramAppInterface.startServlet(paramContext);
        return;
        if (!(paramAppInterface instanceof BrowserAppInterface)) {
          continue;
        }
        paramString2 = ((BrowserAppInterface)paramAppInterface).getVkey();
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          paramb.l(paramString1, false, -10001);
        }
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, aica.b paramb, boolean paramBoolean, String paramString5)
  {
    QLog.i("XProxy", 2, "开始拉取A1，uin = " + paramString1 + " appid = " + paramString4);
    if ((this.a.ac != null) && (!paramBoolean) && (System.currentTimeMillis() - this.abi < 43200000L))
    {
      if (paramb != null) {
        paramb.l(paramString2, true, 0);
      }
      return true;
    }
    if (this.isUpdating)
    {
      this.mListenerList.add(paramb);
      return true;
    }
    this.isUpdating = true;
    if (this.c == null)
    {
      QLog.i("XProxy", 2, "new WtloginHelper");
      this.c = new WtloginHelper(BaseApplicationImpl.getContext(), WtloginPrivacyListenerImpl.getSingleton());
    }
    if (paramString3.equals("com.tencent.huayang"))
    {
      paramString5 = new byte[16];
      String tmp159_157 = paramString5;
      tmp159_157[0] = -33;
      String tmp165_159 = tmp159_157;
      tmp165_159[1] = 11;
      String tmp171_165 = tmp165_159;
      tmp171_165[2] = -29;
      String tmp177_171 = tmp171_165;
      tmp177_171[3] = -119;
      String tmp183_177 = tmp177_171;
      tmp183_177[4] = 66;
      String tmp189_183 = tmp183_177;
      tmp189_183[5] = 110;
      String tmp195_189 = tmp189_183;
      tmp195_189[6] = 87;
      String tmp202_195 = tmp195_189;
      tmp202_195[7] = 53;
      String tmp209_202 = tmp202_195;
      tmp209_202[8] = -16;
      String tmp216_209 = tmp209_202;
      tmp216_209[9] = -77;
      String tmp223_216 = tmp216_209;
      tmp223_216[10] = -121;
      String tmp230_223 = tmp223_216;
      tmp230_223[11] = -112;
      String tmp237_230 = tmp230_223;
      tmp237_230[12] = 46;
      String tmp244_237 = tmp237_230;
      tmp244_237[13] = 51;
      String tmp251_244 = tmp244_237;
      tmp251_244[14] = -96;
      String tmp258_251 = tmp251_244;
      tmp258_251[15] = 62;
      tmp258_251;
    }
    for (;;)
    {
      this.c.SetListener(new aicb(this, paramString2));
      this.mListenerList.add(paramb);
      int i = this.c.GetA1WithA1(paramString1, 16L, 16L, paramString3.getBytes(), 1L, Long.valueOf(paramString4).longValue(), 1L, "5.2".getBytes(), paramString5, new WUserSigInfo(), new WFastLoginInfo());
      if (i != -1001)
      {
        if (QLog.isColorLevel()) {
          QLog.i("XProxy", 2, "获取Now结合版A1票据失败，retCode = " + i);
        }
        k(paramString2, false, i);
      }
      return true;
      if (paramString3.equals("com.tencent.now"))
      {
        paramString5 = new byte[16];
        String tmp416_414 = paramString5;
        tmp416_414[0] = -51;
        String tmp422_416 = tmp416_414;
        tmp422_416[1] = 50;
        String tmp428_422 = tmp422_416;
        tmp428_422[2] = 114;
        String tmp434_428 = tmp428_422;
        tmp434_428[3] = -105;
        String tmp440_434 = tmp434_428;
        tmp440_434[4] = -54;
        String tmp446_440 = tmp440_434;
        tmp446_440[5] = -19;
        String tmp452_446 = tmp446_440;
        tmp452_446[6] = 112;
        String tmp459_452 = tmp452_446;
        tmp459_452[7] = -124;
        String tmp466_459 = tmp459_452;
        tmp466_459[8] = -125;
        String tmp473_466 = tmp466_459;
        tmp473_466[9] = -52;
        String tmp480_473 = tmp473_466;
        tmp480_473[10] = -72;
        String tmp487_480 = tmp480_473;
        tmp487_480[11] = -101;
        String tmp494_487 = tmp487_480;
        tmp494_487[12] = -27;
        String tmp501_494 = tmp494_487;
        tmp501_494[13] = 33;
        String tmp508_501 = tmp501_494;
        tmp508_501[14] = 65;
        String tmp515_508 = tmp508_501;
        tmp515_508[15] = -128;
        tmp515_508;
      }
      else
      {
        paramString5 = aqhs.hexStr2Bytes(paramString5);
      }
    }
  }
  
  public void drW()
  {
    this.a = new aica.a();
  }
  
  public class a
  {
    public long abj;
    public Intent ac;
    public String bMP = "";
    public String mAccessToken = "";
    public String mOpenID = "";
    
    public a() {}
  }
  
  public static abstract interface b
  {
    public abstract void l(String paramString, boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aica
 * JD-Core Version:    0.7.0.1
 */