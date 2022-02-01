import MQQ.VipUserInfo;
import VIP.AIOSendRes;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class aquu
{
  private static aquu a;
  public static String cxl = "aioVipDonateInfoSpFile_";
  public static String cxm = "lastCheckTime_";
  public static String cxn = "sendDisable";
  public static String cxo = "checkFreq";
  public static String cxp = "grayTail";
  public static String cxq = "sendList";
  public static String cxr = "popGraytips";
  public static String cxs = "graytips";
  public static String cxt = "hightLight";
  public static String cxu = "jumpUrl";
  public static String cxw = "";
  public static int ecV = 1;
  public static int ecW = 1;
  private List<String> Jh;
  private String cxv;
  private String cxx;
  private int ecX = -1;
  private String grayTips;
  private int iCheckFreq = -1;
  private int iSendDisable = -1;
  private String jumpUrl;
  
  public static aquu a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aquu();
      }
      return a;
    }
    finally {}
  }
  
  public String L(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    if (TextUtils.isEmpty(this.grayTips)) {
      this.grayTips = paramQQAppInterface.getApplication().getSharedPreferences(cxl + paramQQAppInterface.getCurrentAccountUin(), 0).getString(cxs, null);
    }
    return this.grayTips;
  }
  
  public String M(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    if (TextUtils.isEmpty(this.cxx)) {
      this.cxx = paramQQAppInterface.getApplication().getSharedPreferences(cxl + paramQQAppInterface.getCurrentAccountUin(), 0).getString(cxt, null);
    }
    return this.cxx;
  }
  
  public String N(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    if (TextUtils.isEmpty(this.jumpUrl)) {
      this.jumpUrl = paramQQAppInterface.getApplication().getSharedPreferences(cxl + paramQQAppInterface.getCurrentAccountUin(), 0).getString(cxu, cxw);
    }
    return this.jumpUrl;
  }
  
  public void U(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    this.ecX = paramInt;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences(cxl + paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putInt(cxr, paramInt);
    if (Build.VERSION.SDK_INT < 9)
    {
      paramQQAppInterface.commit();
      return;
    }
    paramQQAppInterface.apply();
  }
  
  @TargetApi(9)
  public void a(QQAppInterface paramQQAppInterface, VipUserInfo paramVipUserInfo)
  {
    int j = 0;
    if ((paramQQAppInterface == null) || (paramVipUserInfo == null)) {
      return;
    }
    Object localObject = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences(cxl + (String)localObject, 0).edit();
    this.iSendDisable = paramVipUserInfo.iSendDisable;
    this.iCheckFreq = paramVipUserInfo.iCheckFreq;
    if (!TextUtils.isEmpty(paramVipUserInfo.sGrayTail))
    {
      this.cxv = paramVipUserInfo.sGrayTail;
      paramQQAppInterface.putString(cxp, paramVipUserInfo.sGrayTail);
    }
    if ((paramVipUserInfo.vSendList != null) && (paramVipUserInfo.vSendList.size() > 0))
    {
      localObject = new StringBuilder();
      int i = j;
      if (this.Jh == null)
      {
        this.Jh = new ArrayList();
        i = j;
      }
      while (i < paramVipUserInfo.vSendList.size())
      {
        String str = String.valueOf(paramVipUserInfo.vSendList.get(i));
        ((StringBuilder)localObject).append(str).append(",");
        this.Jh.add(str);
        i += 1;
      }
      paramQQAppInterface.putString(cxq, ((StringBuilder)localObject).toString());
    }
    paramQQAppInterface.putInt(cxn, this.iSendDisable);
    paramQQAppInterface.putInt(cxo, this.iCheckFreq);
    if (Build.VERSION.SDK_INT < 9)
    {
      paramQQAppInterface.commit();
      return;
    }
    paramQQAppInterface.apply();
  }
  
  @TargetApi(9)
  public void a(QQAppInterface paramQQAppInterface, AIOSendRes paramAIOSendRes)
  {
    if ((paramQQAppInterface == null) || (paramAIOSendRes == null)) {}
    label251:
    for (;;)
    {
      return;
      this.ecX = paramAIOSendRes.iPopGrayStip;
      this.grayTips = paramAIOSendRes.sGrayStipMsg;
      paramAIOSendRes = paramAIOSendRes.mHighLightMap;
      if ((paramAIOSendRes != null) && (paramAIOSendRes.size() > 0))
      {
        this.cxx = ((String)paramAIOSendRes.keySet().iterator().next());
        if (!TextUtils.isEmpty(this.cxx)) {
          this.jumpUrl = ((String)paramAIOSendRes.get(this.cxx));
        }
      }
      paramAIOSendRes = paramQQAppInterface.getApplication().getSharedPreferences(cxl, 0).edit();
      paramAIOSendRes.putInt(cxr, this.ecX);
      if (!TextUtils.isEmpty(this.grayTips)) {
        paramAIOSendRes.putString(cxs, this.grayTips);
      }
      if (!TextUtils.isEmpty(this.cxx)) {
        paramAIOSendRes.putString(cxt, this.cxx);
      }
      if (!TextUtils.isEmpty(this.jumpUrl)) {
        paramAIOSendRes.putString(cxu, this.jumpUrl);
      }
      if (Build.VERSION.SDK_INT < 9) {
        paramAIOSendRes.commit();
      }
      for (;;)
      {
        if (this.ecX != ecW) {
          break label251;
        }
        paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
        if (paramQQAppInterface == null) {
          break;
        }
        paramQQAppInterface.sendMessage(paramQQAppInterface.obtainMessage(58));
        return;
        paramAIOSendRes.apply();
      }
    }
  }
  
  public boolean ae(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return false;
      if ((this.Jh == null) || (this.Jh.size() < 1))
      {
        if (this.Jh == null) {
          this.Jh = new ArrayList();
        }
        paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences(cxl + paramQQAppInterface.getCurrentAccountUin(), 0).getString(cxq, null);
        if (!TextUtils.isEmpty(paramQQAppInterface))
        {
          paramQQAppInterface = paramQQAppInterface.split(",");
          int i = 0;
          while (i < paramQQAppInterface.length)
          {
            CharSequence localCharSequence = paramQQAppInterface[i];
            if (!TextUtils.isEmpty(localCharSequence)) {
              this.Jh.add(localCharSequence.trim());
            }
            i += 1;
          }
        }
      }
    } while ((this.Jh == null) || (!this.Jh.contains(paramString)));
    return true;
  }
  
  public boolean cq(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return false;
      if (this.iSendDisable == -1) {
        this.iSendDisable = paramQQAppInterface.getApplication().getSharedPreferences(cxl + paramQQAppInterface.getCurrentAccountUin(), 0).getInt(cxn, -1);
      }
    } while (this.iSendDisable != ecV);
    return true;
  }
  
  public boolean cr(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return false;
      String str = paramQQAppInterface.getCurrentAccountUin();
      if (TextUtils.isEmpty(this.cxv)) {
        this.cxv = paramQQAppInterface.getApplication().getSharedPreferences(cxl + paramQQAppInterface.getCurrentAccountUin(), 0).getString(cxp, null);
      }
      if (!TextUtils.isEmpty(this.cxv))
      {
        paramQQAppInterface = this.cxv.split(",");
        int i = 0;
        while (i < paramQQAppInterface.length)
        {
          CharSequence localCharSequence = paramQQAppInterface[i];
          if ((!TextUtils.isEmpty(localCharSequence)) && (str.endsWith(localCharSequence.trim()))) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean cs(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return false;
      if (this.ecX == -1) {
        this.ecX = paramQQAppInterface.getApplication().getSharedPreferences(cxl + paramQQAppInterface.getCurrentAccountUin(), 0).getInt(cxr, 0);
      }
    } while (this.ecX != ecW);
    return true;
  }
  
  public long r(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return -1L;
    }
    if (this.iCheckFreq == -1) {
      this.iCheckFreq = paramQQAppInterface.getApplication().getSharedPreferences(cxl + paramQQAppInterface.getCurrentAccountUin(), 0).getInt(cxo, -1);
    }
    return this.iCheckFreq * 60 * 1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aquu
 * JD-Core Version:    0.7.0.1
 */