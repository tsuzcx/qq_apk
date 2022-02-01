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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class cg
  implements dp
{
  public static final boolean hP = bc.o().isUseIPList();
  private static String hQ = "mazu.3g.com.qq.com";
  private static cg hR = null;
  private static a hX = null;
  private static a hY = null;
  private cl hS;
  private final Object hT = new Object();
  private String hU = "key_notset";
  private a hV;
  private a hW;
  private boolean hi = false;
  private Context mContext;
  
  public cg(Context paramContext, boolean paramBoolean, cl paramcl, String paramString)
  {
    eh.e("HIPList", "[ip_list]HIPList() isTest: ".concat(String.valueOf(paramBoolean)));
    this.mContext = paramContext;
    this.hi = paramBoolean;
    this.hS = paramcl;
    if (!TextUtils.isEmpty(paramString))
    {
      hQ = paramString;
    }
    else
    {
      if (this.hi) {
        paramContext = "mazutest.3g.com.qq.com";
      }
      for (;;)
      {
        hQ = paramContext;
        break;
        if (this.hS.bo() == 1) {
          paramContext = "mazu-hk.3g.com.qq.com";
        } else {
          paramContext = "mazu.3g.com.qq.com";
        }
      }
    }
    if (hP)
    {
      bd();
    }
    else
    {
      eh.g("HIPList", "[ip_list]HIPList(), not enable, use default");
      be();
    }
    a(this);
  }
  
  public static String a(cl paramcl)
  {
    if (paramcl.bo() == 1) {
      return "mazuburst-hk.3g.com.qq.com";
    }
    return "mazuburst.3g.com.qq.com";
  }
  
  public static List<String> a(List<String> paramList, boolean paramBoolean)
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
          eh.h("HIPList", "[ip_list]drop invalid ipport: ".concat(String.valueOf(str)));
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(cg paramcg)
  {
    hR = paramcg;
  }
  
  private void a(String paramString, a arg2, boolean paramBoolean)
  {
    if ((paramString != null) && (??? != null) && (???.isValid()))
    {
      Object localObject = new a(???.hZ, ???.ia, ???.ib);
      if (paramBoolean)
      {
        a.a((a)localObject, i(true));
        StringBuilder localStringBuilder = new StringBuilder("[ip_list]setWorkingHIPList for ");
        if (this.hi) {
          ??? = " [test server]";
        } else {
          ??? = " [release server]";
        }
        localStringBuilder.append(???);
        localStringBuilder.append(": ");
        localStringBuilder.append(((a)localObject).ia);
        eh.f("HIPList", localStringBuilder.toString());
      }
      synchronized (this.hT)
      {
        this.hV = ((a)localObject);
        this.hW = a.a(this.hV);
        localObject = new StringBuilder("[ip_list]setWorkingHIPList(), key changed: ");
        ((StringBuilder)localObject).append(this.hU);
        ((StringBuilder)localObject).append(" -> ");
        ((StringBuilder)localObject).append(paramString);
        eh.f("HIPList", ((StringBuilder)localObject).toString());
        this.hU = paramString;
        return;
      }
    }
    eh.h("HIPList", "[ip_list]setWorkingHIPList(), bad arg or invalid, ignore");
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
        eh.f("HIPList", "[ip_list]refreshWorkingIPList(), not necessary, key unchanged: ".concat(String.valueOf(str)));
        return;
      }
      ??? = e(str, true);
      if ((??? != null) && (((a)???).isValid()))
      {
        a(str, (a)???, true);
        return;
      }
      be();
      return;
    }
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    if (this.hi) {
      str1 = "t_";
    } else {
      str1 = "r_";
    }
    ((StringBuilder)localObject).append(str1);
    String str2 = ((StringBuilder)localObject).toString();
    int i = cd.e(this.mContext);
    if (i == 1)
    {
      str1 = NetworkUtil.getSSID();
      localObject = "wifi_";
      str1 = String.valueOf(str1);
    }
    else
    {
      localObject = "apn_";
      str1 = String.valueOf(i);
    }
    String str1 = ((String)localObject).concat(str1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(str1);
    return ((StringBuilder)localObject).toString();
  }
  
  private int bh()
  {
    int j = ei.og;
    int i = 2;
    if (4 == j) {}
    for (String str = "[ip_list]getOperator(), wifi as china telecom";; str = "[ip_list]getOperator(), unknow as china telecom")
    {
      eh.e("HIPList", str);
      break label68;
      str = "";
      if (bc.o().isAllowImsi()) {
        str = PhoneInfoFetcher.getIMSI(this.mContext);
      }
      j = ed.b(this.mContext, str);
      if (-1 != j) {
        break;
      }
    }
    i = j;
    label68:
    eh.e("HIPList", "[ip_list]getOperator(), 0-mobile, 1-unicom, 2-telecom: ".concat(String.valueOf(i)));
    return i;
  }
  
  private a e(String paramString, boolean paramBoolean)
  {
    eh.f("HIPList", "[ip_list]loadSavedIPPortListInfo(), key: ".concat(String.valueOf(paramString)));
    a locala = this.hS.r(paramString);
    if (locala != null)
    {
      if (locala.isValid())
      {
        StringBuilder localStringBuilder = new StringBuilder("[ip_list]loadSavedIPPortListInfo(), saved info for: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(": ");
        localStringBuilder.append(locala.toString());
        eh.f("HIPList", localStringBuilder.toString());
        return locala;
      }
      eh.g("HIPList", "[ip_list]loadSavedIPPortListInfo(), not valid");
      if (paramBoolean)
      {
        eh.g("HIPList", "[ip_list]loadSavedIPPortListInfo(), delete not valid info: ".concat(String.valueOf(paramString)));
        this.hS.b(paramString, 0L, null);
      }
    }
    else
    {
      eh.g("HIPList", "[ip_list]loadSavedIPPortListInfo(), no saved info for: ".concat(String.valueOf(paramString)));
    }
    return null;
  }
  
  private static boolean f(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = paramString.lastIndexOf(":");
    if (i > 0)
    {
      if (i == paramString.length() - 1) {
        return false;
      }
      String str = paramString.substring(0, i);
      paramString = paramString.substring(i + 1);
      if (((paramBoolean) || (u(str))) && (TextUtils.isDigitsOnly(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  private a h(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject1 = hX;
      if (localObject1 != null) {
        return localObject1;
      }
    }
    if (!paramBoolean)
    {
      localObject1 = hY;
      if (localObject1 != null) {
        return localObject1;
      }
    }
    Object localObject1 = i(paramBoolean);
    Object localObject2 = j(paramBoolean);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)localObject1);
    if (hP) {
      localArrayList.addAll((Collection)localObject2);
    }
    localObject2 = new StringBuilder("[ip_list]getDefaultHIPListInfo for ");
    if (paramBoolean) {
      localObject1 = "tcp";
    } else {
      localObject1 = "http";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    if (this.hi) {
      localObject1 = " [test server]";
    } else {
      localObject1 = " [release server]";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(": ");
    ((StringBuilder)localObject2).append(localArrayList);
    eh.f("HIPList", ((StringBuilder)localObject2).toString());
    localObject1 = new a(0L, localArrayList, true);
    if (paramBoolean)
    {
      hX = (a)localObject1;
      return localObject1;
    }
    hY = (a)localObject1;
    return localObject1;
  }
  
  private List<String> i(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList();
    int i;
    if (paramBoolean) {
      i = 443;
    } else {
      i = 80;
    }
    ((List)localObject).add(Integer.valueOf(i));
    String str = hQ;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(String.format("%s:%d", new Object[] { str, Integer.valueOf(((Integer)((Iterator)localObject).next()).intValue()) }));
    }
    return localArrayList;
  }
  
  private List<String> j(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.hi) {
      return localArrayList;
    }
    Object localObject2 = new ArrayList();
    int i;
    if (paramBoolean) {
      i = 443;
    } else {
      i = 80;
    }
    ((List)localObject2).add(Integer.valueOf(i));
    Object localObject1;
    if (this.hS.bo() == 1)
    {
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        i = ((Integer)((Iterator)localObject1).next()).intValue();
        localArrayList.add(String.format("%s:%d", new Object[] { "203.205.143.147", Integer.valueOf(i) }));
        localArrayList.add(String.format("%s:%d", new Object[] { "203.205.146.46", Integer.valueOf(i) }));
        localArrayList.add(String.format("%s:%d", new Object[] { "203.205.146.45", Integer.valueOf(i) }));
      }
    }
    switch (bh())
    {
    default: 
      localObject1 = "120.198.203.156";
      break;
    case 1: 
      localObject1 = "163.177.71.153";
      break;
    case 0: 
      localObject1 = "183.232.125.162";
    }
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localArrayList.add(String.format("%s:%d", new Object[] { localObject1, Integer.valueOf(((Integer)((Iterator)localObject2).next()).intValue()) }));
    }
    return localArrayList;
  }
  
  private void k(boolean paramBoolean)
  {
    Object localObject2 = this.hT;
    if (paramBoolean) {}
    try
    {
      a locala = this.hV;
      break label24;
      locala = this.hW;
      label24:
      if (locala == null)
      {
        bd();
        return;
      }
      if (!locala.isValid()) {
        be();
      }
      return;
    }
    finally {}
  }
  
  private static dq.b t(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramString.lastIndexOf(":");
    if (i > 0)
    {
      if (i == paramString.length() - 1) {
        return null;
      }
      String str1 = paramString.substring(0, i);
      String str2 = paramString.substring(i + 1);
      if (TextUtils.isDigitsOnly(str2))
      {
        paramString = new StringBuilder("[ip_list]getIPEndPointByStr(), ip: ");
        paramString.append(str1);
        paramString.append(" port: ");
        paramString.append(Integer.parseInt(str2));
        eh.f("HIPList", paramString.toString());
        return new dq.b(str1, Integer.parseInt(str2));
      }
      eh.f("HIPList", "[ip_list]getIPEndPointByStr(), invalid: ".concat(String.valueOf(paramString)));
    }
    return null;
  }
  
  private String t(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    if (this.hi) {
      str1 = "t_";
    } else {
      str1 = "r_";
    }
    ((StringBuilder)localObject).append(str1);
    String str2 = ((StringBuilder)localObject).toString();
    if (paramInt == 1)
    {
      if (NetworkUtil.isWifiConnected())
      {
        localObject = NetworkUtil.getSSID();
        str1 = "wifi_";
        localObject = String.valueOf(localObject);
      }
      else
      {
        str1 = "wifi_nonessid";
        break label95;
      }
    }
    else
    {
      str1 = "apn_";
      localObject = String.valueOf(paramInt);
    }
    String str1 = str1.concat((String)localObject);
    label95:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(str1);
    return ((StringBuilder)localObject).toString();
  }
  
  private static boolean u(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      if (paramString.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"))
      {
        paramString = paramString.split("\\.");
        if (paramString.length < 4) {
          return false;
        }
        if ((Integer.parseInt(paramString[0]) <= 255) && (Integer.parseInt(paramString[1]) <= 255) && (Integer.parseInt(paramString[2]) <= 255))
        {
          int i = Integer.parseInt(paramString[3]);
          if (i <= 255) {
            return true;
          }
        }
      }
      return false;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public void a(long paramLong, int paramInt, JceStruct paramJceStruct)
  {
    Object localObject = new StringBuilder("[ip_list]onIPListPush(), |pushId=");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("|seqNo=");
    ((StringBuilder)localObject).append(paramInt);
    eh.i("HIPList", ((StringBuilder)localObject).toString());
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
      localObject = new StringBuilder("[ip_list]onIPListPush(), bad type, should be SCHIPList: ");
      ((StringBuilder)localObject).append(paramJceStruct.getClass());
      eh.h("HIPList", ((StringBuilder)localObject).toString());
      return;
    }
    localObject = (u)paramJceStruct;
    paramJceStruct = new StringBuilder();
    paramJceStruct.append("SCHIPList: |hash=");
    paramJceStruct.append(((u)localObject).ay);
    paramJceStruct.append("|ipports=");
    paramJceStruct.append(((u)localObject).aG);
    paramJceStruct.append("|validperiod=");
    paramJceStruct.append(((u)localObject).aH);
    paramJceStruct.append("|doclose=");
    paramJceStruct.append(((u)localObject).aI);
    paramJceStruct.append("|apn=");
    paramJceStruct.append(((u)localObject).apn);
    paramJceStruct.append("|extra=");
    paramJceStruct.append(((u)localObject).aJ);
    StringBuilder localStringBuilder = new StringBuilder("[ip_list]onIPListPush(), ");
    localStringBuilder.append(paramJceStruct.toString());
    eh.i("HIPList", localStringBuilder.toString());
    paramJceStruct = new a(System.currentTimeMillis() + ((u)localObject).aH * 1000L, a(((u)localObject).aG, false), false);
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
      eh.f("HIPList", "[ip_list]onIPListPush(), saved, key: ".concat(String.valueOf(localObject)));
      return;
    }
    localObject = new StringBuilder("[ip_list]onIPListPush(), apn not match， just save, curApn: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" pushedApn: ");
    ((StringBuilder)localObject).append(i);
    eh.h("HIPList", ((StringBuilder)localObject).toString());
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
    StringBuilder localStringBuilder = new StringBuilder("[ip_list]handleNetworkChange(), refreshWorkingHIPList, isTest: ");
    localStringBuilder.append(this.hi);
    eh.e("HIPList", localStringBuilder.toString());
    bd();
  }
  
  public String bg()
  {
    Object localObject1 = l(false);
    if (localObject1 != null)
    {
      localObject2 = ((dq.b)localObject1).getIp();
      localObject1 = localObject2;
      if (localObject2 != null) {
        if (((String)localObject2).length() >= 7)
        {
          localObject1 = localObject2;
          if (((String)localObject2).substring(0, 7).equalsIgnoreCase("http://")) {}
        }
        else
        {
          localObject1 = "http://".concat(String.valueOf(localObject2));
        }
      }
      eh.f("HIPList", "[ip_list]getHttpIp(), httpIp: ".concat(String.valueOf(localObject1)));
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = "http://".concat(String.valueOf(hQ));
      eh.g("HIPList", "[ip_list]getHttpIp(), use default: ".concat(String.valueOf(localObject2)));
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
      Object localObject1 = this.hV;
      break label29;
      localObject1 = this.hW;
      label29:
      if (localObject1 != null)
      {
        localObject1 = a.b((a)localObject1);
        return localObject1;
      }
      return null;
    }
    finally {}
  }
  
  public void m(boolean paramBoolean)
  {
    k(true);
    Object localObject2 = this.hT;
    if (paramBoolean) {}
    try
    {
      a locala = this.hV;
      break label29;
      locala = this.hW;
      label29:
      if (locala != null) {
        a.c(locala);
      }
      return;
    }
    finally {}
  }
  
  public void n(boolean paramBoolean)
  {
    k(true);
    Object localObject2 = this.hT;
    if (paramBoolean) {}
    try
    {
      a locala = this.hV;
      break label29;
      locala = this.hW;
      label29:
      if (locala != null) {
        a.d(locala);
      }
      return;
    }
    finally {}
  }
  
  public void o(boolean paramBoolean) {}
  
  public ArrayList<String> p(boolean paramBoolean)
  {
    k(true);
    Object localObject3 = this.hT;
    if (paramBoolean) {}
    try
    {
      Object localObject1 = this.hV;
      break label29;
      localObject1 = this.hW;
      label29:
      if (localObject1 != null)
      {
        localObject1 = (ArrayList)((a)localObject1).ia;
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
  
  public static class a
  {
    public long hZ;
    public List<String> ia = new ArrayList();
    public boolean ib = false;
    private int ic = 0;
    
    public a(long paramLong, List<String> paramList, boolean paramBoolean)
    {
      this.hZ = paramLong;
      if (paramList != null) {
        this.ia.addAll(paramList);
      }
      this.ib = paramBoolean;
    }
    
    private void a(List<String> paramList)
    {
      int i = this.ia.size();
      if (i >= 2)
      {
        this.ia.addAll(i - 1, cg.a(paramList, true));
        return;
      }
      this.ia.addAll(cg.a(paramList, true));
    }
    
    private a bi()
    {
      LinkedHashSet localLinkedHashSet = new LinkedHashSet();
      Iterator localIterator = this.ia.iterator();
      while (localIterator.hasNext())
      {
        String str = w((String)localIterator.next());
        if (str != null) {
          localLinkedHashSet.add(str);
        }
      }
      return new a(this.hZ, new ArrayList(localLinkedHashSet), this.ib);
    }
    
    private dq.b bj()
    {
      if (this.ic >= this.ia.size()) {
        this.ic = 0;
      }
      return cg.v((String)this.ia.get(this.ic));
    }
    
    private void bk()
    {
      this.ic += 1;
      if (this.ic >= this.ia.size()) {
        this.ic = 0;
      }
    }
    
    private void bl()
    {
      this.ic = 0;
    }
    
    private static String w(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      int i = paramString.lastIndexOf(":");
      Object localObject;
      if (i >= 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, i));
        ((StringBuilder)localObject).append(":80");
        paramString = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(":80");
        localObject = ((StringBuilder)localObject).toString();
        eh.h("HIPList", "conv2HttpIPPort(): invalid ipPort(missing port): ".concat(String.valueOf(paramString)));
        paramString = (String)localObject;
      }
      if (paramString.length() >= 7)
      {
        localObject = paramString;
        if (paramString.substring(0, 7).equalsIgnoreCase("http://")) {}
      }
      else
      {
        localObject = "http://".concat(String.valueOf(paramString));
      }
      return localObject;
    }
    
    public boolean isValid()
    {
      return ((this.ib) || (System.currentTimeMillis() <= this.hZ)) && (this.ia.size() > 0);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("|mValidTimeMills=");
      localStringBuilder.append(this.hZ);
      localStringBuilder.append("|mIsDefault=");
      localStringBuilder.append(this.ib);
      localStringBuilder.append("|mIPPortList=");
      localStringBuilder.append(this.ia);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cg
 * JD-Core Version:    0.7.0.1
 */