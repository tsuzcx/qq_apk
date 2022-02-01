package com.tencent.mobileqq.highway.config;

import android.content.Context;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class HardCodeIpList
{
  private CopyOnWriteArrayList<String> mHcIpCandicateListChinaMobile;
  private CopyOnWriteArrayList<String> mHcIpCandicateListChinaTelecom;
  private CopyOnWriteArrayList<String> mHcIpCandicateListChinaUnicom;
  private CopyOnWriteArrayList<String> mHcIpCandicateListOverseas;
  private CopyOnWriteArrayList<String> mHcIpCandicateListWifi;
  private ArrayList<Integer> mPort4HardCode = new ArrayList();
  
  public HardCodeIpList()
  {
    this.mPort4HardCode.add(Integer.valueOf(80));
    this.mPort4HardCode.add(Integer.valueOf(8080));
    this.mPort4HardCode.add(Integer.valueOf(443));
    if (this.mHcIpCandicateListWifi == null)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      localArrayList3.add(new Candiate("121.51.141.73"));
      localArrayList3.add(new Candiate("121.51.139.184"));
      localArrayList3.add(new Candiate("111.13.34.183"));
      localArrayList3.add(new Candiate("111.30.144.63"));
      localArrayList3.add(new Candiate("183.194.234.190"));
      localArrayList3.add(new Candiate("183.194.234.249"));
      Collections.sort(localArrayList3, new CustomComparator());
      localArrayList2.add(new Candiate("58.250.136.56"));
      localArrayList2.add(new Candiate("163.177.92.121"));
      localArrayList2.add(new Candiate("223.167.104.34"));
      localArrayList2.add(new Candiate("111.161.111.177"));
      localArrayList2.add(new Candiate("111.161.64.121"));
      localArrayList2.add(new Candiate("116.128.163.67"));
      Collections.sort(localArrayList2, new CustomComparator());
      localArrayList1.add(new Candiate("183.3.225.58"));
      localArrayList1.add(new Candiate("183.3.235.188"));
      localArrayList1.add(new Candiate("180.163.25.38"));
      localArrayList1.add(new Candiate("123.151.71.152"));
      localArrayList1.add(new Candiate("123.151.137.126"));
      localArrayList1.add(new Candiate("101.89.38.28"));
      Collections.sort(localArrayList1, new CustomComparator());
      localArrayList4.add(new Candiate("103.7.30.143"));
      localArrayList4.add(new Candiate("203.205.140.60"));
      Collections.sort(localArrayList4, new CustomComparator());
      this.mHcIpCandicateListWifi = new CopyOnWriteArrayList();
      this.mHcIpCandicateListWifi.add(((Candiate)localArrayList1.get(0)).ip);
      this.mHcIpCandicateListWifi.add(((Candiate)localArrayList2.get(0)).ip);
      this.mHcIpCandicateListWifi.add(((Candiate)localArrayList3.get(0)).ip);
      this.mHcIpCandicateListWifi.add(((Candiate)localArrayList4.get(0)).ip);
      this.mHcIpCandicateListWifi.add(((Candiate)localArrayList1.get(1)).ip);
      this.mHcIpCandicateListWifi.add(((Candiate)localArrayList2.get(1)).ip);
      this.mHcIpCandicateListWifi.add(((Candiate)localArrayList3.get(1)).ip);
      this.mHcIpCandicateListWifi.add(((Candiate)localArrayList4.get(1)).ip);
      this.mHcIpCandicateListWifi.add(((Candiate)localArrayList1.get(2)).ip);
      this.mHcIpCandicateListWifi.add(((Candiate)localArrayList2.get(2)).ip);
      this.mHcIpCandicateListWifi.add(((Candiate)localArrayList3.get(2)).ip);
      this.mHcIpCandicateListWifi.add(((Candiate)localArrayList1.get(3)).ip);
      this.mHcIpCandicateListWifi.add(((Candiate)localArrayList2.get(3)).ip);
      this.mHcIpCandicateListWifi.add(((Candiate)localArrayList3.get(3)).ip);
      this.mHcIpCandicateListWifi.add(((Candiate)localArrayList1.get(4)).ip);
      this.mHcIpCandicateListWifi.add(((Candiate)localArrayList2.get(4)).ip);
      this.mHcIpCandicateListWifi.add(((Candiate)localArrayList3.get(4)).ip);
      this.mHcIpCandicateListWifi.add(((Candiate)localArrayList1.get(5)).ip);
      this.mHcIpCandicateListWifi.add(((Candiate)localArrayList2.get(5)).ip);
      this.mHcIpCandicateListWifi.add(((Candiate)localArrayList3.get(5)).ip);
    }
    if (this.mHcIpCandicateListChinaMobile == null)
    {
      this.mHcIpCandicateListChinaMobile = new CopyOnWriteArrayList();
      this.mHcIpCandicateListChinaMobile.add("121.51.141.73");
      this.mHcIpCandicateListChinaMobile.add("121.51.139.184");
      this.mHcIpCandicateListChinaMobile.add("111.30.159.176");
      this.mHcIpCandicateListChinaMobile.add("111.30.159.160");
      this.mHcIpCandicateListChinaMobile.add("183.194.234.190");
      this.mHcIpCandicateListChinaMobile.add("183.194.234.249");
    }
    if (this.mHcIpCandicateListChinaUnicom == null)
    {
      this.mHcIpCandicateListChinaUnicom = new CopyOnWriteArrayList();
      this.mHcIpCandicateListChinaUnicom.add("58.250.136.56");
      this.mHcIpCandicateListChinaUnicom.add("163.177.92.121");
      this.mHcIpCandicateListChinaUnicom.add("223.167.104.34");
      this.mHcIpCandicateListChinaUnicom.add("220.194.95.148");
      this.mHcIpCandicateListChinaUnicom.add("220.194.95.147");
      this.mHcIpCandicateListChinaUnicom.add("116.128.163.67");
    }
    if (this.mHcIpCandicateListChinaTelecom == null)
    {
      this.mHcIpCandicateListChinaTelecom = new CopyOnWriteArrayList();
      this.mHcIpCandicateListChinaTelecom.add("183.3.225.58");
      this.mHcIpCandicateListChinaTelecom.add("183.3.235.188");
      this.mHcIpCandicateListChinaTelecom.add("180.163.25.38");
      this.mHcIpCandicateListChinaTelecom.add("123.151.190.162");
      this.mHcIpCandicateListChinaTelecom.add("123.151.190.163");
      this.mHcIpCandicateListChinaTelecom.add("101.89.38.28");
    }
    if (this.mHcIpCandicateListOverseas == null)
    {
      this.mHcIpCandicateListOverseas = new CopyOnWriteArrayList();
      this.mHcIpCandicateListOverseas.add("103.7.30.143");
      this.mHcIpCandicateListOverseas.add("203.205.140.60");
    }
  }
  
  public static boolean foundNRemoveIP(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList, String paramString)
  {
    if (paramCopyOnWriteArrayList == null) {
      return false;
    }
    Iterator localIterator = paramCopyOnWriteArrayList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((String)localIterator.next()).equalsIgnoreCase(paramString));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramCopyOnWriteArrayList.remove(paramString);
        return true;
      }
      return false;
    }
  }
  
  private EndPoint getOrderlyFromCandicate4HardCode(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList)
  {
    if ((paramCopyOnWriteArrayList != null) && (!paramCopyOnWriteArrayList.isEmpty())) {
      return new EndPoint((String)paramCopyOnWriteArrayList.get(0), ((Integer)this.mPort4HardCode.get(rand(this.mPort4HardCode.size() - 1))).intValue());
    }
    return null;
  }
  
  public static int rand(int paramInt)
  {
    return (int)(Math.random() * (paramInt + 1));
  }
  
  public boolean foundNRemove(String paramString)
  {
    if (foundNRemoveIP(this.mHcIpCandicateListWifi, paramString)) {}
    while ((foundNRemoveIP(this.mHcIpCandicateListChinaMobile, paramString)) || (foundNRemoveIP(this.mHcIpCandicateListChinaUnicom, paramString)) || (foundNRemoveIP(this.mHcIpCandicateListChinaTelecom, paramString))) {
      return true;
    }
    return false;
  }
  
  public EndPoint getNextIp(Context paramContext)
  {
    if (HwNetworkUtil.isWifiEnabled(paramContext)) {
      return getOrderlyFromCandicate4HardCode(this.mHcIpCandicateListWifi);
    }
    switch (HwNetworkUtil.getCarrierOperatorType(paramContext))
    {
    default: 
      return getRandomFromCandicate4HardCode(this.mHcIpCandicateListOverseas);
    case 2: 
      return getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaMobile);
    case 3: 
      return getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaUnicom);
    }
    return getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaTelecom);
  }
  
  public EndPoint getRandomFromCandicate4HardCode(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList)
  {
    if ((paramCopyOnWriteArrayList != null) && (!paramCopyOnWriteArrayList.isEmpty())) {
      return new EndPoint((String)paramCopyOnWriteArrayList.get(rand(paramCopyOnWriteArrayList.size() - 1)), ((Integer)this.mPort4HardCode.get(rand(this.mPort4HardCode.size() - 1))).intValue());
    }
    return null;
  }
  
  public boolean isEmpty(Context paramContext)
  {
    if (HwNetworkUtil.isWifiEnabled(paramContext)) {
      return this.mHcIpCandicateListWifi.isEmpty();
    }
    switch (HwNetworkUtil.getCarrierOperatorType(paramContext))
    {
    default: 
      return this.mHcIpCandicateListOverseas.isEmpty();
    case 2: 
      return this.mHcIpCandicateListChinaMobile.isEmpty();
    case 3: 
      return this.mHcIpCandicateListChinaUnicom.isEmpty();
    }
    return this.mHcIpCandicateListChinaTelecom.isEmpty();
  }
  
  class Candiate
  {
    public int index;
    public String ip;
    
    public Candiate(String paramString)
    {
      this.ip = paramString;
      this.index = HardCodeIpList.rand(100);
    }
  }
  
  public class CustomComparator
    implements Comparator<HardCodeIpList.Candiate>
  {
    public CustomComparator() {}
    
    public int compare(HardCodeIpList.Candiate paramCandiate1, HardCodeIpList.Candiate paramCandiate2)
    {
      if (paramCandiate1.index < paramCandiate2.index) {
        return -1;
      }
      if (paramCandiate1.index == paramCandiate2.index) {
        return 0;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.HardCodeIpList
 * JD-Core Version:    0.7.0.1
 */