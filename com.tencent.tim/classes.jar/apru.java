import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger.1;
import com.tencent.qphone.base.util.QLog;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.Random;

public class apru
{
  protected static final List<String> Il = new ArrayList();
  protected static Map<String, apun> nM;
  protected acms c;
  protected final String cqM = "0x6ff0072";
  protected final String cqN = "5";
  protected final String cqO = "cgi-bin/httpconn";
  protected final String fileType = "3";
  public String mTroopUin;
  protected final String ver = "5520";
  
  static
  {
    Il.add("2408:8756:3af0:10::107");
    Il.add("240e:ff:f101:10::104");
    Il.add("2402:4e00:8010::132");
    Il.add("2402:4e00:8010::22");
    Il.add("2408:80f1:31:50::21");
    Il.add("240e:e1:a900:50::3d");
    Il.add("2402:4e00:8020:2::86");
    Il.add("2409:8c1e:8fd0:50::1c");
    Il.add("2408:8711:10:10::13");
    Il.add("240e:928:1400:10::23");
    Il.add("2402:4e00:8030:1::a0");
    Il.add("2409:8702:4860:10::41");
  }
  
  public apru(String paramString, Class<? extends apun> paramClass, acms paramacms)
  {
    this.c = paramacms;
    this.mTroopUin = paramString;
    if (nM == null) {
      nM = new HashMap();
    }
    if ((apun)nM.get(paramString) == null)
    {
      paramClass = apum.a(paramClass);
      nM.put(paramString, paramClass);
    }
  }
  
  private String q(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    try
    {
      paramString1 = new URL("http", paramString2, paramInt, "cgi-bin/httpconn").toString();
      return paramString1;
    }
    catch (MalformedURLException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  private String y(boolean paramBoolean)
  {
    boolean bool2 = true;
    Object localObject2;
    Object localObject1;
    if (!paramBoolean)
    {
      bool1 = true;
      localObject2 = e("htdata3.qq.com", "cgi-bin/httpconn", bool1);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        if (paramBoolean) {
          break label77;
        }
      }
    }
    label77:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localObject1 = e("htdata4.qq.com", "cgi-bin/httpconn", bool1);
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = C("cgi-bin/httpconn", paramBoolean);
      }
      return localObject2;
      bool1 = false;
      break;
    }
  }
  
  public String C(String paramString, boolean paramBoolean)
  {
    int i = new Random().nextInt(100);
    String str;
    if (paramBoolean)
    {
      int j = Il.size();
      str = (String)Il.get(Math.abs(i) % j);
    }
    for (;;)
    {
      paramString = q(paramString, str, 80);
      QLog.i("TroopAvatarManger", 1, String.format("tryGetIpByRandomIp ip=%s bIpv6=%b", new Object[] { str, Boolean.valueOf(paramBoolean) }));
      return paramString;
      if (Math.abs(i) % 2 == 0) {
        str = "14.17.18.20";
      } else {
        str = "112.90.139.96";
      }
    }
  }
  
  public void Tx(String paramString)
  {
    if (this.c != null) {
      this.c.EV(paramString);
    }
  }
  
  public List<String> a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramAppInterface = new ArrayList();
    boolean bool2 = acfq.a().aal();
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    Object localObject = aooa.a();
    ((aooa)localObject).init();
    if (i == 3)
    {
      String str = ((aooa)localObject).o(0, bool2);
      if (!TextUtils.isEmpty(str)) {
        paramAppInterface.add(str + "cgi-bin/httpconn");
      }
      if (!bool2) {}
      for (bool1 = true;; bool1 = false)
      {
        localObject = ((aooa)localObject).o(0, bool1);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramAppInterface.add((String)localObject + "cgi-bin/httpconn");
        }
        if (paramAppInterface.size() < 2)
        {
          localObject = y(false);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramAppInterface.add(localObject);
          }
        }
        localObject = q("cgi-bin/httpconn", "htdata3.qq.com", 80);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramAppInterface.add(localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.i("TroopAvatarManger", 2, String.format("getSrvAddr type=%d prefV6=%b getUrl=%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Arrays.toString(paramAppInterface.toArray()) }));
        }
        i = 0;
        while (i < paramAppInterface.size())
        {
          paramAppInterface.set(i, (String)paramAppInterface.get(i) + "?htcmd=" + "0x6ff0072" + "&ver=" + "5520" + "&ukey=" + paramString5 + "&range=" + paramString2 + "&uin=" + paramString4 + "&seq=23&groupuin=" + paramString3 + "&filetype=" + "3" + "&imagetype=" + "5" + "&userdata=" + paramString1);
          i += 1;
        }
      }
    }
    if (i == 2)
    {
      bool1 = true;
      label416:
      localObject = ((aooa)localObject).o(0, bool1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramAppInterface.add((String)localObject + "cgi-bin/httpconn");
      }
      if (i != 2) {
        break label533;
      }
    }
    label533:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject = y(bool1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramAppInterface.add(localObject);
      }
      localObject = q("cgi-bin/httpconn", "htdata3.qq.com", 80);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      paramAppInterface.add(localObject);
      break;
      bool1 = false;
      break label416;
    }
    return paramAppInterface;
  }
  
  public void a(Class<? extends Thread> paramClass, AppInterface paramAppInterface, ArrayList<TroopClipPic> paramArrayList, String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap)
  {
    ThreadManager.executeOnNetWorkThread(new TroopAvatarManger.1(this, paramAppInterface, paramString1, paramString3, paramString2, (apun)nM.get(this.mTroopUin), paramClass, paramArrayList, paramHashMap));
  }
  
  public void addObserver(Observer paramObserver)
  {
    ((apun)nM.get(this.mTroopUin)).addObserver(paramObserver);
  }
  
  public void d(String paramString, int paramInt, ArrayList<Integer> paramArrayList)
  {
    if (this.c != null) {
      this.c.c(paramString, paramInt, paramArrayList);
    }
  }
  
  public ArrayList<apul> dW()
  {
    return ((apun)nM.get(this.mTroopUin)).dW();
  }
  
  public String e(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = InetAddress.getAllByName(paramString1);
        if (localObject1 == null) {
          break label152;
        }
        int j = localObject1.length;
        if (i >= j) {
          break label152;
        }
        localObject2 = localObject1[i];
        if (((localObject2 instanceof Inet4Address)) && (paramBoolean))
        {
          localObject1 = localObject2.getHostAddress();
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label147;
          }
          paramString2 = q(paramString2, (String)localObject1, 80);
        }
      }
      catch (UnknownHostException paramString1)
      {
        Object localObject2;
        paramString2 = null;
        QLog.i("TroopAvatarManger", 1, "UnknownHostException", paramString1);
        return paramString2;
      }
      try
      {
        QLog.i("TroopAvatarManger", 1, String.format("tryGetIpByHost host[%s] %s", new Object[] { paramString1, localObject1 }));
        return paramString2;
      }
      catch (UnknownHostException paramString1)
      {
        continue;
      }
      if (((localObject2 instanceof Inet6Address)) && (!paramBoolean))
      {
        localObject1 = localObject2.getHostAddress();
      }
      else
      {
        i += 1;
        continue;
        label147:
        paramString2 = null;
        continue;
        label152:
        localObject1 = null;
      }
    }
  }
  
  public void f(Observer paramObserver)
  {
    ((apun)nM.get(this.mTroopUin)).g(paramObserver);
  }
  
  public void onDestroy()
  {
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apru
 * JD-Core Version:    0.7.0.1
 */