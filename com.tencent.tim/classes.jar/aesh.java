import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class aesh
{
  aesh.a a = new aesh.a();
  aesh.a b = new aesh.a();
  private String bAM = "";
  private String bAN = "";
  private String bAO = "暂不";
  boolean bWe = true;
  aesh.a c = new aesh.a();
  aesh.a d = new aesh.a();
  aesh.a e = new aesh.a();
  private int enable;
  aesh.a f = new aesh.a();
  aesh.a g = new aesh.a();
  aesh.a h = new aesh.a();
  aesh.a i = new aesh.a();
  
  @NonNull
  public static aesh a()
  {
    return a("{\"enable\":1,\"cacheFlag\":\"20200403\",\"intructionPageUrl\":\"https://act.qzone.qq.com/vip/meteor/blockly/p/4136x48826\",\"fullSpaceMessage\":{\"nonVIP\":\"当前群文件容量已满，新上传文件仅保留10天，开通超级会员可延长至30天。\",\"VIP\":\"当前群文件容量已满，会员新上传的文件仅保留20天，开通超级会员可延长至30天。\",\"SVIP\":\"当前群文件容量已满，你已享受超级会员特权，新上传的文件可保留30天。\"},\"redSubString\":{\"nonVIP\":\"容量已满\",\"VIP\":\"容量已满\",\"SVIP\":\"容量已满\"},\"blueSubString\":{\"nonVIP\":\"开通超级会员\",\"VIP\":\"开通超级会员\",\"SVIP\":\"超级会员特权\"},\"blueActionUrl\":{\"nonVIP\":\"https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_list&month=&type=svip&isAskFriendPay=0\",\"VIP\":\"https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_list&month=&type=svip&isAskFriendPay=0\",\"SVIP\":\"https://act.qzone.qq.com/vip/meteor/blockly/p/4136x48826\"},\"fullAlertMessage\":{\"nonVIP\":\"当前群文件容量已满，新上传的文件仅保留10天，超级会员可延长至30天。\",\"VIP\":\"当前群文件容量已满，会员新上传的文件仅保留20天，超级会员可延长至30天。\",\"SVIP\":\"\"},\"bigFileAlertMessage\":{\"nonVIP\":\"临时文件有效期10天，开通超级会员可将保存时间延长至30天\",\"VIP\":\"会员上传的临时文件有效期20天，开通超级会员可将保存时间延长至30天。\",\"SVIP\":\"\"},\"alertButtonTitle\":{\"nonVIP\":\"开通超级会员\",\"VIP\":\"开通超级会员\",\"SVIP\":\"\"},\"buttonActionUrl\":{\"nonVIP\":\"https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_tf&month=&type=svip&isAskFriendPay=0\",\"VIP\":\"https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_tf&month=&type=svip&isAskFriendPay=0\",\"SVIP\":\"\"},\"AIObuttonActionUrl\":{\"nonVIP\":\"https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_aio&month=&type=svip&isAskFriendPay=0\",\"VIP\":\"https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_aio&month=&type=svip&isAskFriendPay=0\",\"SVIP\":\"\"}}");
  }
  
  @NonNull
  public static aesh a(@Nullable String paramString)
  {
    aesh localaesh = new aesh();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        localaesh.enable = paramString.optInt("enable", localaesh.enable);
        localaesh.bAM = paramString.optString("cacheFlag", localaesh.bAM);
        localaesh.bAN = paramString.optString("intructionPageUrl", localaesh.bAN);
        localaesh.a = aesh.a.a(paramString.getJSONObject("fullSpaceMessage"));
        localaesh.b = aesh.a.a(paramString.getJSONObject("redSubString"));
        localaesh.c = aesh.a.a(paramString.getJSONObject("blueSubString"));
        localaesh.d = aesh.a.a(paramString.getJSONObject("blueActionUrl"));
        localaesh.e = aesh.a.a(paramString.getJSONObject("fullAlertMessage"));
        localaesh.f = aesh.a.a(paramString.getJSONObject("bigFileAlertMessage"));
        localaesh.g = aesh.a.a(paramString.getJSONObject("alertButtonTitle"));
        localaesh.h = aesh.a.a(paramString.getJSONObject("buttonActionUrl"));
        localaesh.i = aesh.a.a(paramString.getJSONObject("AIObuttonActionUrl"));
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.TROOP_FILE.ConfigProcessor", 1, " : " + localaesh.toString());
      }
      return localaesh;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("QVIP.TROOP_FILE.ConfigProcessor", 1, "json parse error:" + paramString);
      }
    }
  }
  
  private static void report(String paramString1, String paramString2, String paramString3)
  {
    int j;
    if ("normal".equals(paramString2)) {
      j = 1;
    }
    for (;;)
    {
      anot.b(null, "dc00898", "", "", "qq_vip", paramString1, j, 1, 0, "", "", paramString3, "");
      return;
      if ("vip".equals(paramString2)) {
        j = 2;
      } else if ("svip".equals(paramString2)) {
        j = 3;
      } else {
        j = 0;
      }
    }
  }
  
  void a(Context paramContext, String paramString1, String paramString2, Runnable paramRunnable, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = aqha.a(paramContext, 230, "", paramString1, this.bAO, this.g.getString(paramString2), new aesk(this, paramContext, paramBoolean1, paramString2, paramBoolean2), new aesl(this, paramRunnable, paramBoolean1, paramString2, paramBoolean2));
    paramContext.getTitleTextView().setVisibility(8);
    paramContext.show();
    if (paramBoolean1)
    {
      paramContext = "0X800AE69";
      if (!paramBoolean2) {
        break label94;
      }
    }
    label94:
    for (paramString1 = "size";; paramString1 = "full")
    {
      report(paramContext, paramString2, paramString1);
      return;
      paramContext = "0X800AE63";
      break;
    }
  }
  
  public boolean a(Context paramContext, Runnable paramRunnable, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    String str;
    int j;
    if (paramBoolean1)
    {
      str = this.f.getString(paramString);
      if (TextUtils.isEmpty(str)) {
        break label47;
      }
      j = 1;
      label26:
      if (j != 0) {
        break label53;
      }
    }
    label47:
    label53:
    while (!ahy())
    {
      return false;
      str = this.e.getString(paramString);
      break;
      j = 0;
      break label26;
    }
    a(paramContext, str, paramString, paramRunnable, paramBoolean2, paramBoolean1);
    return true;
  }
  
  public boolean a(@NonNull SpannableString paramSpannableString, @NonNull String paramString1, String paramString2)
  {
    int k = 0;
    Object localObject;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramSpannableString)))
    {
      localObject = Pattern.compile("[^0-9]").matcher(paramString1).replaceAll("").trim();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label46;
      }
    }
    for (;;)
    {
      return false;
      try
      {
        label46:
        int n = Integer.valueOf((String)localObject).intValue();
        if (paramSpannableString.toString().contains("\n")) {
          localObject = paramSpannableString.toString().replace("\n", "");
        }
        for (int j = 1;; j = 0)
        {
          int m = ((String)localObject).indexOf(paramString1);
          if ((n <= 10) || (m <= -1)) {
            break;
          }
          localObject = new aesj(this, paramString2);
          n = paramString1.length();
          if (j != 0) {
            k = 1;
          }
          paramSpannableString.setSpan(localObject, m, n + m + k, 33);
          report("0X800AE6C", paramString2, "");
          return true;
          localObject = paramSpannableString.toString();
        }
        return false;
      }
      catch (Exception paramSpannableString) {}
    }
  }
  
  boolean ahy()
  {
    boolean bool2;
    if (!this.bWe)
    {
      bool2 = false;
      return bool2;
    }
    this.bWe = false;
    SharedPreferences localSharedPreferences = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getPreferences();
    if (!TextUtils.equals(this.bAM, localSharedPreferences.getString("vas_guide_troop_file", null))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      localSharedPreferences.edit().putString("vas_guide_troop_file", this.bAM).apply();
      return bool1;
    }
  }
  
  public SpannableString d(String paramString)
  {
    String str1 = this.a.getString(paramString);
    String str2 = this.b.getString(paramString);
    String str3 = this.c.getString(paramString);
    String str4 = this.d.getString(paramString);
    SpannableString localSpannableString = new SpannableString(str1);
    int j = str1.indexOf(str2);
    if (j > -1) {
      localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF0000")), j, str2.length() + j, 33);
    }
    j = str1.indexOf(str3);
    if (j > -1) {
      localSpannableString.setSpan(new aesi(this, str4, paramString), j, str3.length() + j, 33);
    }
    report("0X800AE66", paramString, "");
    return localSpannableString;
  }
  
  public boolean isEnable()
  {
    return this.enable == 1;
  }
  
  public String toString()
  {
    return "QVipTroopFileConfig{enable=" + this.enable + ", cacheFlag='" + this.bAM + '\'' + ", intructionPageUrl='" + this.bAN + '\'' + ", fullSpaceMessage=" + this.a + ", redSubString=" + this.b + ", blueSubString=" + this.c + ", blueActionUrl=" + this.d + ", fullAlertMessage=" + this.e + ", bigFileAlertMessage=" + this.f + ", alertButtonTitle=" + this.g + ", buttonActionUrl=" + this.h + ", AIObuttonActionUrl=" + this.i + '}';
  }
  
  static class a
  {
    String bAR = "";
    String bAS = "";
    String bAT = "";
    
    static a a(JSONObject paramJSONObject)
    {
      a locala = new a();
      locala.bAR = paramJSONObject.optString("nonVIP", locala.bAR);
      locala.bAS = paramJSONObject.optString("VIP", locala.bAS);
      locala.bAT = paramJSONObject.optString("SVIP", locala.bAT);
      return locala;
    }
    
    String getString(String paramString)
    {
      if ("normal".equals(paramString)) {
        return this.bAR;
      }
      if ("vip".equals(paramString)) {
        return this.bAS;
      }
      return this.bAT;
    }
    
    public String toString()
    {
      return "Info{nonVIP='" + this.bAR + '\'' + ", VIP='" + this.bAS + '\'' + ", SVIP='" + this.bAT + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aesh
 * JD-Core Version:    0.7.0.1
 */