import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.protofile.getappinfo.GetAppInfoProto.Ads;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qconn.protofile.appType.AndroidInfo;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0xd55.RspBody;
import tencent.im.oidb.qqconnect.AndroidAppInfo;
import tencent.im.oidb.qqconnect.Appinfo;
import tencent.im.oidb.qqconnect.MobileAppInfo;

public class ahgf
{
  public List<svi.a> BV;
  public GetAppInfoProto.Ads ads;
  private String appName;
  private String bKr;
  private String bKs;
  private String bKt;
  private int cZQ;
  private boolean cgN;
  private String pkgName;
  private String sourceUrl;
  
  public static int a(qqconnect.Appinfo paramAppinfo)
  {
    int j = 0;
    if (paramAppinfo.icon_mini_url.has()) {
      j = 1;
    }
    int i;
    if (!paramAppinfo.icon_middle_url.has())
    {
      i = j;
      if (!paramAppinfo.icon_small_url.has()) {}
    }
    else
    {
      i = j | 0x2;
    }
    j = i;
    if (paramAppinfo.icon_url.has()) {
      j = i | 0x4;
    }
    return j;
  }
  
  public static ahgf a(GetAppInfoProto.GetAppinfoResponse paramGetAppinfoResponse)
  {
    ahgf localahgf = new ahgf();
    localahgf.ads = paramGetAppinfoResponse.ads;
    localahgf.BV = svi.b(paramGetAppinfoResponse.iconsURL);
    if (!localahgf.BV.isEmpty())
    {
      localahgf.bKr = svi.a(localahgf.BV, 16);
      localahgf.bKs = svi.a(localahgf.BV, 100);
      localahgf.cZQ = u(localahgf.BV);
    }
    GetAppInfoProto.AndroidInfo localAndroidInfo = paramGetAppinfoResponse.androidInfo;
    if (localAndroidInfo != null)
    {
      localahgf.cgN = true;
      if (!localAndroidInfo.sourceUrl.has()) {
        break label183;
      }
      paramGetAppinfoResponse = localAndroidInfo.sourceUrl.get();
      localahgf.sourceUrl = paramGetAppinfoResponse;
      if (!localAndroidInfo.messagetail.has()) {
        break label189;
      }
      paramGetAppinfoResponse = localAndroidInfo.messagetail.get();
      label131:
      localahgf.appName = paramGetAppinfoResponse;
      if (!localAndroidInfo.packName.has()) {
        break label195;
      }
    }
    label183:
    label189:
    label195:
    for (paramGetAppinfoResponse = localAndroidInfo.packName.get();; paramGetAppinfoResponse = "")
    {
      localahgf.pkgName = paramGetAppinfoResponse;
      QLog.d("SDK_LOGIN.AppInfo", 1, new Object[] { "convertToAppInfo AppInfo : ", localahgf.toString() });
      return localahgf;
      paramGetAppinfoResponse = "";
      break;
      paramGetAppinfoResponse = "";
      break label131;
    }
  }
  
  public static ahgf a(preAuth.PreAuthResponse paramPreAuthResponse, appType.AndroidInfo paramAndroidInfo)
  {
    ahgf localahgf = new ahgf();
    String str;
    if (paramAndroidInfo.message_tail.has())
    {
      str = paramAndroidInfo.message_tail.get();
      localahgf.appName = str;
      if (!paramAndroidInfo.pack_name.has()) {
        break label172;
      }
      str = paramAndroidInfo.pack_name.get();
      label49:
      localahgf.pkgName = str;
      if (!paramAndroidInfo.source_url.has()) {
        break label178;
      }
    }
    label172:
    label178:
    for (paramAndroidInfo = paramAndroidInfo.source_url.get();; paramAndroidInfo = "")
    {
      localahgf.sourceUrl = paramAndroidInfo;
      localahgf.cgN = true;
      localahgf.BV = svi.c(paramPreAuthResponse.icons_url);
      if (!localahgf.BV.isEmpty())
      {
        localahgf.bKr = svi.a(localahgf.BV, 16);
        localahgf.bKs = svi.a(localahgf.BV, 100);
        localahgf.cZQ = u(localahgf.BV);
      }
      QLog.d("SDK_LOGIN.AppInfo", 1, new Object[] { "convertToAppInfo AppInfo : ", localahgf.toString() });
      return localahgf;
      str = "";
      break;
      str = "";
      break label49;
    }
  }
  
  private static String a(qqconnect.Appinfo paramAppinfo, String paramString)
  {
    Iterator localIterator = null;
    Object localObject2 = null;
    Object localObject1 = localIterator;
    if (paramAppinfo.mobile_app_info.has())
    {
      localObject1 = localIterator;
      if (paramAppinfo.mobile_app_info.android_app_info.has())
      {
        localIterator = paramAppinfo.mobile_app_info.android_app_info.get().iterator();
        paramAppinfo = localObject2;
        localObject1 = paramAppinfo;
        if (localIterator.hasNext())
        {
          localObject1 = (qqconnect.AndroidAppInfo)localIterator.next();
          if (((qqconnect.AndroidAppInfo)localObject1).pack_name.has())
          {
            localObject1 = ((qqconnect.AndroidAppInfo)localObject1).pack_name.get();
            paramAppinfo = (qqconnect.Appinfo)localObject1;
            if (!((String)localObject1).equals(paramString)) {}
          }
        }
      }
    }
    while (TextUtils.isEmpty((CharSequence)localObject1))
    {
      return paramString;
      break;
    }
    return localObject1;
  }
  
  public static void a(oidb_0xd55.RspBody paramRspBody, String paramString, ahgf paramahgf)
  {
    paramahgf.cgN = true;
    qqconnect.Appinfo localAppinfo = paramRspBody.appinfo;
    paramahgf.bKr = localAppinfo.icon_mini_url.get();
    paramahgf.bKs = localAppinfo.icon_url.get();
    paramahgf.cZQ = a(localAppinfo);
    paramahgf.sourceUrl = localAppinfo.source_url.get();
    paramahgf.appName = localAppinfo.app_name.get();
    paramahgf.pkgName = a(localAppinfo, paramString);
    if (paramRspBody.wording.has()) {}
    for (paramRspBody = paramRspBody.wording.get();; paramRspBody = "")
    {
      paramahgf.bKt = paramRspBody;
      QLog.d("SDK_LOGIN.AppInfo", 1, new Object[] { "fillAppInfo AppInfo : ", paramahgf.toString() });
      return;
    }
  }
  
  private static int u(List<svi.a> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      svi.a locala = (svi.a)paramList.next();
      if ("16".equals(locala.size.get()))
      {
        i |= 0x1;
      }
      else if ("64".equals(locala.size.get()))
      {
        i |= 0x2;
      }
      else
      {
        if (!"100".equals(locala.size.get())) {
          break label96;
        }
        i |= 0x4;
      }
    }
    label96:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public int ER()
  {
    return this.cZQ;
  }
  
  public boolean ani()
  {
    return this.cgN;
  }
  
  public String getAppName()
  {
    return this.appName;
  }
  
  public String getPkgName()
  {
    return this.pkgName;
  }
  
  public String getSourceUrl()
  {
    return this.sourceUrl;
  }
  
  public String toString()
  {
    return "iconUrlMini=" + this.bKr + ", iconUrlBig=" + this.bKs + ", appLackOfIcons=" + this.cZQ + ", isAndroidInfoExist=" + this.cgN + ", sourceUrl=" + this.sourceUrl + ", appName=" + this.appName + ", pkgName=" + this.pkgName + ", mErrorWording=" + this.bKt;
  }
  
  public String wk()
  {
    return this.bKr;
  }
  
  public String wl()
  {
    return this.bKs;
  }
  
  public String wm()
  {
    return this.bKt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahgf
 * JD-Core Version:    0.7.0.1
 */