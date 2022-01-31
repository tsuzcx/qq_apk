package btmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tmsdk.base.AbsTMSBaseConfig;
import com.tmsdk.base.utils.NetworkUtil;
import com.tmsdk.base.utils.PhoneInfoFetcher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class cg
  implements dp
{
  public static final boolean hP = bc.o().isUseIPList();
  private static String hQ = "mazu.3g.com.qq.com";
  private static cg hR = null;
  private static cg.a hX = null;
  private static cg.a hY = null;
  private cl hS;
  private final Object hT = new Object();
  private String hU = "key_notset";
  private cg.a hV;
  private cg.a hW;
  private boolean hi = false;
  private Context mContext;
  
  public cg(Context paramContext, boolean paramBoolean, cl paramcl, String paramString)
  {
    eh.e("HIPList", "[ip_list]HIPList() isTest: " + paramBoolean);
    this.mContext = paramContext;
    this.hi = paramBoolean;
    this.hS = paramcl;
    if (!TextUtils.isEmpty(paramString))
    {
      hQ = paramString;
      if (!hP) {
        break label135;
      }
      bd();
    }
    for (;;)
    {
      a(this);
      return;
      if (this.hi)
      {
        hQ = "mazutest.3g.com.qq.com";
        break;
      }
      if (this.hS.bo() == 1)
      {
        hQ = "mazu-hk.3g.com.qq.com";
        break;
      }
      hQ = "mazu.3g.com.qq.com";
      break;
      label135:
      eh.g("HIPList", "[ip_list]HIPList(), not enable, use default");
      be();
    }
  }
  
  public static String a(cl paramcl)
  {
    if (paramcl.bo() == 1) {
      return "mazuburst-hk.3g.com.qq.com";
    }
    return "mazuburst.3g.com.qq.com";
  }
  
  public static List a(List paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (f(str, paramBoolean)) {
          localArrayList.add(str);
        } else {
          eh.h("HIPList", "[ip_list]drop invalid ipport: " + str);
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(cg paramcg)
  {
    hR = paramcg;
  }
  
  private void a(String paramString, cg.a arg2, boolean paramBoolean)
  {
    if ((paramString == null) || (??? == null) || (!???.isValid()))
    {
      eh.h("HIPList", "[ip_list]setWorkingHIPList(), bad arg or invalid, ignore");
      return;
    }
    cg.a locala = new cg.a(???.hZ, ???.ia, ???.ib);
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      cg.a.a(locala, i(true));
      localStringBuilder = new StringBuilder().append("[ip_list]setWorkingHIPList for ");
      if (!this.hi) {
        break label182;
      }
    }
    label182:
    for (??? = " [test server]";; ??? = " [release server]")
    {
      eh.f("HIPList", ??? + ": " + locala.ia);
      synchronized (this.hT)
      {
        this.hV = locala;
        this.hW = cg.a.a(this.hV);
        eh.f("HIPList", "[ip_list]setWorkingHIPList(), key changed: " + this.hU + " -> " + paramString);
        this.hU = paramString;
        return;
      }
    }
  }
  
  public static cg bb()
  {
    return hR;
  }
  
  private void bd()
  {
    String str = bf();
    synchronized (this.hT)
    {
      if ((this.hU != null) && (this.hU.equals(str)) && (this.hV != null) && (this.hV.isValid()))
      {
        eh.f("HIPList", "[ip_list]refreshWorkingIPList(), not necessary, key unchanged: " + str);
        return;
      }
      ??? = e(str, true);
      if ((??? != null) && (((cg.a)???).isValid()))
      {
        a(str, (cg.a)???, true);
        return;
      }
    }
    be();
  }
  
  private void be()
  {
    eh.e("HIPList", "[ip_list]reset2Default()");
    synchronized (this.hT)
    {
      if ((this.hU != null) && (this.hU.equals("key_default")) && (this.hV != null) && (this.hV.isValid()))
      {
        eh.f("HIPList", "[ip_list]reset2Default(), not necessary, key unchanged");
        return;
      }
      a("key_default", h(true), false);
      return;
    }
  }
  
  private String bf()
  {
    Object localObject = new StringBuilder().append("");
    int i;
    if (this.hi)
    {
      str = "t_";
      localObject = str;
      i = cd.e(this.mContext);
      if (i != 1) {
        break label96;
      }
      str = NetworkUtil.getSSID();
    }
    label96:
    for (String str = "wifi_" + str;; str = "apn_" + i)
    {
      return (String)localObject + str;
      str = "r_";
      break;
    }
  }
  
  private int bh()
  {
    int i;
    if (4 == ei.og)
    {
      eh.e("HIPList", "[ip_list]getOperator(), wifi as china telecom");
      i = 2;
    }
    for (;;)
    {
      eh.e("HIPList", "[ip_list]getOperator(), 0-mobile, 1-unicom, 2-telecom: " + i);
      return i;
      String str = "";
      if (bc.o().isAllowImsi()) {
        str = PhoneInfoFetcher.getIMSI(this.mContext);
      }
      int j = ed.b(this.mContext, str);
      i = j;
      if (-1 == j)
      {
        eh.e("HIPList", "[ip_list]getOperator(), unknow as china telecom");
        i = 2;
      }
    }
  }
  
  private cg.a e(String paramString, boolean paramBoolean)
  {
    eh.f("HIPList", "[ip_list]loadSavedIPPortListInfo(), key: " + paramString);
    cg.a locala = this.hS.r(paramString);
    if (locala != null)
    {
      if (locala.isValid())
      {
        eh.f("HIPList", "[ip_list]loadSavedIPPortListInfo(), saved info for: " + paramString + ": " + locala.toString());
        return locala;
      }
      eh.g("HIPList", "[ip_list]loadSavedIPPortListInfo(), not valid");
      if (paramBoolean)
      {
        eh.g("HIPList", "[ip_list]loadSavedIPPortListInfo(), delete not valid info: " + paramString);
        this.hS.b(paramString, 0L, null);
        return null;
      }
    }
    else
    {
      eh.g("HIPList", "[ip_list]loadSavedIPPortListInfo(), no saved info for: " + paramString);
    }
    return null;
  }
  
  private static boolean f(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      int i;
      do
      {
        return false;
        i = paramString.lastIndexOf(":");
      } while ((i <= 0) || (i == paramString.length() - 1));
      str = paramString.substring(0, i);
      paramString = paramString.substring(i + 1);
    } while (((!paramBoolean) && (!u(str))) || (!TextUtils.isDigitsOnly(paramString)));
    return true;
  }
  
  private cg.a h(boolean paramBoolean)
  {
    if ((paramBoolean) && (hX != null)) {
      return hX;
    }
    if ((!paramBoolean) && (hY != null)) {
      return hY;
    }
    Object localObject1 = i(paramBoolean);
    Object localObject2 = j(paramBoolean);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)localObject1);
    if (hP) {
      localArrayList.addAll((Collection)localObject2);
    }
    localObject2 = new StringBuilder().append("[ip_list]getDefaultHIPListInfo for ");
    if (paramBoolean)
    {
      localObject1 = "tcp";
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1);
      if (!this.hi) {
        break label164;
      }
    }
    label164:
    for (localObject1 = " [test server]";; localObject1 = " [release server]")
    {
      eh.f("HIPList", (String)localObject1 + ": " + localArrayList);
      localObject1 = new cg.a(0L, localArrayList, true);
      if (!paramBoolean) {
        break label170;
      }
      hX = (cg.a)localObject1;
      return localObject1;
      localObject1 = "http";
      break;
    }
    label170:
    hY = (cg.a)localObject1;
    return localObject1;
  }
  
  private List i(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList();
    if (paramBoolean) {
      ((List)localObject).add(Integer.valueOf(443));
    }
    for (;;)
    {
      String str = hQ;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(String.format("%s:%d", new Object[] { str, Integer.valueOf(((Integer)((Iterator)localObject).next()).intValue()) }));
      }
      ((List)localObject).add(Integer.valueOf(80));
    }
    return localArrayList;
  }
  
  private List j(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.hi) {
      return localArrayList;
    }
    Object localObject2 = new ArrayList();
    if (paramBoolean) {
      ((List)localObject2).add(Integer.valueOf(443));
    }
    Object localObject1;
    while (this.hS.bo() == 1)
    {
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        int i = ((Integer)((Iterator)localObject1).next()).intValue();
        localArrayList.add(String.format("%s:%d", new Object[] { "203.205.143.147", Integer.valueOf(i) }));
        localArrayList.add(String.format("%s:%d", new Object[] { "203.205.146.46", Integer.valueOf(i) }));
        localArrayList.add(String.format("%s:%d", new Object[] { "203.205.146.45", Integer.valueOf(i) }));
      }
      ((List)localObject2).add(Integer.valueOf(80));
    }
    switch (bh())
    {
    default: 
      localObject1 = "120.198.203.156";
    }
    for (;;)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localArrayList.add(String.format("%s:%d", new Object[] { localObject1, Integer.valueOf(((Integer)((Iterator)localObject2).next()).intValue()) }));
      }
      localObject1 = "163.177.71.153";
      continue;
      localObject1 = "183.232.125.162";
    }
    return localArrayList;
  }
  
  private void k(boolean paramBoolean)
  {
    Object localObject2 = this.hT;
    if (paramBoolean) {}
    do
    {
      for (;;)
      {
        try
        {
          locala = this.hV;
          if (locala != null) {
            break;
          }
          bd();
          return;
        }
        finally {}
        cg.a locala = this.hW;
      }
    } while (localObject1.isValid());
    be();
  }
  
  private static dq.b t(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return null;
      i = paramString.lastIndexOf(":");
    } while ((i <= 0) || (i == paramString.length() - 1));
    String str1 = paramString.substring(0, i);
    String str2 = paramString.substring(i + 1);
    if (TextUtils.isDigitsOnly(str2))
    {
      eh.f("HIPList", "[ip_list]getIPEndPointByStr(), ip: " + str1 + " port: " + Integer.parseInt(str2));
      return new dq.b(str1, Integer.parseInt(str2));
    }
    eh.f("HIPList", "[ip_list]getIPEndPointByStr(), invalid: " + paramString);
    return null;
  }
  
  private String t(int paramInt)
  {
    Object localObject = new StringBuilder().append("");
    String str;
    if (this.hi)
    {
      str = "t_";
      localObject = str;
      if (paramInt != 1) {
        break label101;
      }
      if (!NetworkUtil.isWifiConnected()) {
        break label94;
      }
      str = NetworkUtil.getSSID();
      str = "wifi_" + str;
    }
    for (;;)
    {
      return (String)localObject + str;
      str = "r_";
      break;
      label94:
      str = "wifi_nonessid";
      continue;
      label101:
      str = "apn_" + paramInt;
    }
  }
  
  private static boolean u(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        if (paramString.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"))
        {
          paramString = paramString.split("\\.");
          if ((paramString.length >= 4) && (Integer.parseInt(paramString[0]) <= 255) && (Integer.parseInt(paramString[1]) <= 255) && (Integer.parseInt(paramString[2]) <= 255))
          {
            int i = Integer.parseInt(paramString[3]);
            if (i <= 255) {
              return true;
            }
          }
        }
      }
      catch (Exception paramString) {}
    }
    return false;
  }
  
  public void a(long paramLong, int paramInt, JceStruct paramJceStruct)
  {
    eh.i("HIPList", "[ip_list]onIPListPush(), |pushId=" + paramLong + "|seqNo=" + paramInt);
    if (!hP)
    {
      eh.g("HIPList", "[ip_list]onIPListPush(), not enable, use default");
      return;
    }
    if (paramJceStruct == null)
    {
      eh.h("HIPList", "[ip_list]onIPListPush(), bad arg: jceStruct == null");
      return;
    }
    if (!(paramJceStruct instanceof u))
    {
      eh.h("HIPList", "[ip_list]onIPListPush(), bad type, should be SCHIPList: " + paramJceStruct.getClass());
      return;
    }
    Object localObject = (u)paramJceStruct;
    paramJceStruct = new StringBuilder();
    paramJceStruct.append("SCHIPList: ").append("|hash=").append(((u)localObject).ay).append("|ipports=").append(((u)localObject).aG).append("|validperiod=").append(((u)localObject).aH).append("|doclose=").append(((u)localObject).aI).append("|apn=").append(((u)localObject).apn).append("|extra=").append(((u)localObject).aJ);
    eh.i("HIPList", "[ip_list]onIPListPush(), " + paramJceStruct.toString());
    paramJceStruct = new cg.a(System.currentTimeMillis() + 1000L * ((u)localObject).aH, a(((u)localObject).aG, false), false);
    if (!paramJceStruct.isValid())
    {
      eh.g("HIPList", "[ip_list]onIPListPush(), not valid");
      return;
    }
    paramInt = cd.e(this.mContext);
    int i = ((u)localObject).apn;
    if (i == paramInt)
    {
      localObject = bf();
      this.hS.b((String)localObject, paramJceStruct.hZ, paramJceStruct.ia);
      a((String)localObject, paramJceStruct, true);
      eh.f("HIPList", "[ip_list]onIPListPush(), saved, key: " + (String)localObject);
      return;
    }
    eh.h("HIPList", "[ip_list]onIPListPush(), apn not match， just save, curApn: " + paramInt + " pushedApn: " + i);
    localObject = t(i);
    this.hS.b((String)localObject, paramJceStruct.hZ, paramJceStruct.ia);
  }
  
  public boolean ao()
  {
    return this.hi;
  }
  
  public void bc()
  {
    if (!hP) {
      return;
    }
    eh.e("HIPList", "[ip_list]handleNetworkChange(), refreshWorkingHIPList, isTest: " + this.hi);
    bd();
  }
  
  public String bg()
  {
    Object localObject1 = null;
    Object localObject2 = l(false);
    if (localObject2 != null)
    {
      localObject2 = ((dq.b)localObject2).getIp();
      localObject1 = localObject2;
      if (localObject2 != null) {
        if (((String)localObject2).length() >= "http://".length())
        {
          localObject1 = localObject2;
          if (((String)localObject2).substring(0, "http://".length()).equalsIgnoreCase("http://")) {}
        }
        else
        {
          localObject1 = "http://" + (String)localObject2;
        }
      }
      eh.f("HIPList", "[ip_list]getHttpIp(), httpIp: " + (String)localObject1);
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = hQ;
      localObject2 = "http://" + (String)localObject1;
      eh.g("HIPList", "[ip_list]getHttpIp(), use default: " + (String)localObject2);
    }
    return localObject2;
  }
  
  public dq.b l(boolean paramBoolean)
  {
    k(true);
    Object localObject3 = this.hT;
    if (paramBoolean) {}
    try
    {
      for (Object localObject1 = this.hV; localObject1 != null; localObject1 = this.hW)
      {
        localObject1 = cg.a.b((cg.a)localObject1);
        return localObject1;
      }
      return null;
    }
    finally {}
  }
  
  public void m(boolean paramBoolean)
  {
    k(true);
    localObject2 = this.hT;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        locala = this.hV;
        if (locala != null) {
          cg.a.c(locala);
        }
        return;
      }
      finally {}
      cg.a locala = this.hW;
    }
  }
  
  public void n(boolean paramBoolean)
  {
    k(true);
    localObject2 = this.hT;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        locala = this.hV;
        if (locala != null) {
          cg.a.d(locala);
        }
        return;
      }
      finally {}
      cg.a locala = this.hW;
    }
  }
  
  public void o(boolean paramBoolean) {}
  
  public ArrayList p(boolean paramBoolean)
  {
    k(true);
    Object localObject3 = this.hT;
    if (paramBoolean) {}
    try
    {
      for (Object localObject1 = this.hV; localObject1 != null; localObject1 = this.hW)
      {
        localObject1 = (ArrayList)((cg.a)localObject1).ia;
        return localObject1;
      }
      return null;
    }
    finally {}
  }
  
  public int q(boolean paramBoolean)
  {
    ArrayList localArrayList = p(paramBoolean);
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cg
 * JD-Core Version:    0.7.0.1
 */