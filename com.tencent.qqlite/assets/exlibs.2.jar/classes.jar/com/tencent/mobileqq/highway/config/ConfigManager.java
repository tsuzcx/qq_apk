package com.tencent.mobileqq.highway.config;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.manager.ProxyIpManager;
import mqq.manager.ProxyIpManager.ProxyIp;

public class ConfigManager
  implements IHwManager
{
  private static final boolean FOR_MAX = false;
  public static final int HOLES_PER_SEGMENT = 12;
  private static final String HW_CONFIG_PUSH_FILENAME = "highway_config_push";
  private static final String HW_CONFIG_SSOGET_FILENAME = "highway_config_ssoget";
  private static final boolean IS_TEST_USE_CASE = false;
  public static final int MAX_CONNECT_NUM = 1;
  public static final int MAX_PARALLEL_SEGMENT = 50;
  private static final String PROXY_TAG = "PROXY_IP";
  public static final String TAG = "ConfigManager";
  private static volatile ConfigManager mUniqueInstance;
  private Context mContext4MSFGet;
  private boolean mDomainFirst = true;
  private ArrayList<HwNetSegConf> mHCNetSegConfList = new ArrayList();
  private HardCodeIpList mHardCodeIpList;
  private boolean mHasTriggerMSFGetSucc = false;
  private CopyOnWriteArrayList<String> mHcDomainCandicateList;
  private int mOperator;
  private ArrayList<Integer> mPort4HardCode;
  private IpContainer mPushIpList;
  private IpContainer mPushSsoGetIpList;
  private int mStatus = 0;
  private int maxConnNum = 1;
  
  private ConfigManager(Context paramContext, AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    this.mHCNetSegConfList.add(new HwNetSegConf(0L, 8192L, 8L, 1L));
    this.mHCNetSegConfList.add(new HwNetSegConf(1L, 32768L, 8L, 2L));
    this.mHCNetSegConfList.add(new HwNetSegConf(2L, 8192L, 2L, 1L));
    this.mHCNetSegConfList.add(new HwNetSegConf(3L, 16384L, 6L, 2L));
    this.mHCNetSegConfList.add(new HwNetSegConf(4L, 32768L, 8L, 2L));
    this.mPort4HardCode = new ArrayList();
    this.mPort4HardCode.add(Integer.valueOf(80));
    this.mPort4HardCode.add(Integer.valueOf(8080));
    this.mPort4HardCode.add(Integer.valueOf(443));
    resetSrvAddrState(paramContext, paramAppRuntime, paramString);
  }
  
  private boolean domainFirst(Context paramContext)
  {
    switch (HwNetworkUtil.getSystemNetwork(paramContext))
    {
    case 2: 
    case 3: 
    default: 
      return false;
    }
    return true;
  }
  
  private void enterError(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterError() last status = " + getSrvAddrStatusName(this.mStatus) + " Network: " + HwNetworkUtil.getNetworkName(paramContext));
    this.mStatus = 7;
  }
  
  private void enterHcDomain(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterHcDomain() last status = " + getSrvAddrStatusName(this.mStatus) + " Network: " + HwNetworkUtil.getNetworkName(paramContext));
    this.mStatus = 5;
    if (this.mHcDomainCandicateList.isEmpty())
    {
      if (this.mDomainFirst) {
        enterHcIp(paramContext, paramAppRuntime, paramString);
      }
    }
    else {
      return;
    }
    enterPushSsoGet(paramContext, paramAppRuntime, paramString);
  }
  
  private void enterHcIp(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterHcIp() last status = " + getSrvAddrStatusName(this.mStatus) + " Network: " + HwNetworkUtil.getNetworkName(paramContext));
    this.mStatus = 6;
    if (this.mHardCodeIpList.isEmpty(paramContext))
    {
      if (this.mDomainFirst) {
        enterPushSsoGet(paramContext, paramAppRuntime, paramString);
      }
    }
    else {
      return;
    }
    enterHcDomain(paramContext, paramAppRuntime, paramString);
  }
  
  private void enterInit(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterInit() last status = " + getSrvAddrStatusName(this.mStatus) + " Network: " + HwNetworkUtil.getNetworkName(paramContext));
    this.mStatus = 2;
    if (!this.mPushIpList.isEmpty(paramContext))
    {
      enterPushIp(paramContext, paramAppRuntime, paramString);
      return;
    }
    if (!this.mPushSsoGetIpList.isEmpty(paramContext))
    {
      enterPushSsoGet(paramContext, paramAppRuntime, paramString);
      return;
    }
    if (domainFirst(paramContext))
    {
      this.mDomainFirst = true;
      enterHcDomain(paramContext, paramAppRuntime, paramString);
      return;
    }
    this.mDomainFirst = false;
    enterHcIp(paramContext, paramAppRuntime, paramString);
  }
  
  private void enterPre(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterPre() last status = " + getSrvAddrStatusName(this.mStatus));
    this.mStatus = 1;
    this.mPushIpList = new IpContainer(paramContext, "highway_config_push", paramAppRuntime);
    this.mPushSsoGetIpList = new IpContainer(paramContext, "highway_config_ssoget", paramAppRuntime);
    this.mHcDomainCandicateList = new CopyOnWriteArrayList();
    this.mHcDomainCandicateList.add("htdata3.qq.com");
    this.mHardCodeIpList = new HardCodeIpList();
    enterInit(paramContext, paramAppRuntime, paramString);
  }
  
  private void enterPushIp(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterPushIp() last status = " + getSrvAddrStatusName(this.mStatus) + " Network: " + HwNetworkUtil.getNetworkName(paramContext));
    this.mStatus = 3;
    if (this.mPushIpList.isEmpty(paramContext)) {
      enterPushSsoGet(paramContext, paramAppRuntime, paramString);
    }
  }
  
  private void enterPushSsoGet(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterPushHttpget() last status = " + getSrvAddrStatusName(this.mStatus) + " Network: " + HwNetworkUtil.getNetworkName(paramContext));
    this.mStatus = 4;
    boolean bool = this.mPushSsoGetIpList.isEmpty(paramContext);
    if ((bool) || (!this.mHasTriggerMSFGetSucc))
    {
      this.mContext4MSFGet = paramContext;
      HwServlet.getConfig(paramAppRuntime, paramString);
    }
    if (bool) {
      enterError(paramContext, paramAppRuntime, paramString);
    }
  }
  
  private static boolean foundNRemoveIP(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList, String paramString)
  {
    if (paramCopyOnWriteArrayList == null) {}
    int i;
    do
    {
      return false;
      int j = 0;
      Iterator localIterator = paramCopyOnWriteArrayList.iterator();
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((String)localIterator.next()).equalsIgnoreCase(paramString));
      i = 1;
    } while (i == 0);
    paramCopyOnWriteArrayList.remove(paramString);
    return true;
  }
  
  public static ConfigManager getInstance(Context paramContext, AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    if (mUniqueInstance == null) {
      if ((paramContext == null) || (paramAppRuntime == null) || (paramInt == 0) || (paramString == null)) {
        return null;
      }
    }
    try
    {
      if (mUniqueInstance == null) {
        mUniqueInstance = new ConfigManager(paramContext, paramAppRuntime, paramInt, paramString);
      }
      return mUniqueInstance;
    }
    finally {}
  }
  
  private HwNetSegConf getNetSegConfByType(ArrayList<HwNetSegConf> paramArrayList, int paramInt)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      HwNetSegConf localHwNetSegConf = (HwNetSegConf)paramArrayList.next();
      if (localHwNetSegConf.netType == paramInt) {
        return localHwNetSegConf;
      }
    }
    return null;
  }
  
  private EndPoint getOrderlyFromCandicate4HardCode(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList)
  {
    if ((paramCopyOnWriteArrayList != null) && (!paramCopyOnWriteArrayList.isEmpty())) {
      return new EndPoint((String)paramCopyOnWriteArrayList.get(0), ((Integer)this.mPort4HardCode.get(rand(this.mPort4HardCode.size() - 1))).intValue());
    }
    return null;
  }
  
  private EndPoint getRandomFromCandicate4HardCode(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList)
  {
    if ((paramCopyOnWriteArrayList != null) && (!paramCopyOnWriteArrayList.isEmpty())) {
      return new EndPoint((String)paramCopyOnWriteArrayList.get(rand(paramCopyOnWriteArrayList.size() - 1)), ((Integer)this.mPort4HardCode.get(rand(this.mPort4HardCode.size() - 1))).intValue());
    }
    return null;
  }
  
  private String getSrvAddrStatusName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "NONE";
    case 0: 
      return "NONE";
    case 1: 
      return "PRE";
    case 2: 
      return "INIT";
    case 3: 
      return "PUSH_IP";
    case 4: 
      return "PUSH_SSOGET";
    case 5: 
      return "HC_DOMAIN";
    }
    return "HC_IP";
  }
  
  private static void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigManager", 2, paramString);
    }
  }
  
  private static int rand(int paramInt)
  {
    return (int)(Math.random() * (paramInt + 1));
  }
  
  public void changeMaxConnNum(int paramInt)
  {
    if (this.maxConnNum != paramInt) {
      this.maxConnNum = paramInt;
    }
  }
  
  public int getMaxConnNum()
  {
    return this.maxConnNum;
  }
  
  public HwNetSegConf getNetSegConf(Context paramContext)
  {
    int j = 1;
    Object localObject = this.mHCNetSegConfList;
    ArrayList localArrayList = this.mPushIpList.getNetSegConf(paramContext);
    int i;
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      localObject = localArrayList;
      i = 0;
      switch (HwNetworkUtil.getSystemNetwork(paramContext))
      {
      }
    }
    for (;;)
    {
      paramContext = getNetSegConfByType((ArrayList)localObject, i);
      if (paramContext == null) {
        break label172;
      }
      return paramContext;
      localArrayList = this.mPushSsoGetIpList.getNetSegConf(paramContext);
      if (localArrayList != null)
      {
        i = 1;
        label111:
        if (localArrayList.isEmpty()) {
          break label137;
        }
      }
      while ((i & j) != 0)
      {
        localObject = localArrayList;
        break;
        i = 0;
        break label111;
        label137:
        j = 0;
      }
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 1;
    }
    label172:
    log("getNetSegConf() cannot find segment config from PUSH or HTTP GET");
    return getNetSegConfByType(this.mHCNetSegConfList, i);
  }
  
  public EndPoint getNextSrvAddr(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    EndPoint localEndPoint;
    switch (this.mStatus)
    {
    default: 
      localEndPoint = null;
    }
    while (localEndPoint != null)
    {
      log("getNextSrvAddr() IP = " + localEndPoint.host + " port=" + localEndPoint.port + "  current status = " + getSrvAddrStatusName(this.mStatus));
      return localEndPoint;
      localEndPoint = null;
      continue;
      localEndPoint = this.mPushIpList.get(paramContext);
      continue;
      localEndPoint = this.mPushSsoGetIpList.get(paramContext);
      continue;
      localEndPoint = getRandomFromCandicate4HardCode(this.mHcDomainCandicateList);
      continue;
      localEndPoint = this.mHardCodeIpList.getNextIp(paramContext);
      continue;
      localEndPoint = null;
    }
    log("getNextSrvAddr() IP = none current  status = " + getSrvAddrStatusName(this.mStatus));
    resetSrvAddrState(paramContext, paramAppRuntime, paramString);
    return localEndPoint;
  }
  
  public void onDestroy() {}
  
  public void onInit() {}
  
  public void onNetWorkChange(Context paramContext, AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if ((this.mStatus == 7) && (!this.mHardCodeIpList.isEmpty(paramContext)))
    {
      log("onNetWorkChange() current status = " + getSrvAddrStatusName(this.mStatus));
      enterHcIp(paramContext, paramAppRuntime, paramString);
    }
    if (paramBoolean) {
      onProxyIpChanged(paramAppRuntime);
    }
  }
  
  public void onProxyIpChanged(AppRuntime paramAppRuntime)
  {
    this.mPushIpList.addProxyIp(paramAppRuntime, true);
    this.mPushSsoGetIpList.addProxyIp(paramAppRuntime, true);
  }
  
  public void onSrvAddrPush(Context paramContext, AppRuntime paramAppRuntime, String paramString, HwConfig paramHwConfig)
  {
    log("onSrvAddrPush() current status = " + getSrvAddrStatusName(this.mStatus));
    if (this.mPushIpList.addNew(paramContext, paramHwConfig, paramAppRuntime)) {
      enterInit(paramContext, paramAppRuntime, paramString);
    }
  }
  
  public void onSrvAddrSsoGet(HwConfig paramHwConfig, AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramHwConfig == null) || (paramHwConfig.ipList.isEmpty()) || (this.mContext4MSFGet == null)) {
      return;
    }
    log("onSrvAddrHttpGet() current status = " + getSrvAddrStatusName(this.mStatus));
    this.mHasTriggerMSFGetSucc = true;
    if ((this.mPushSsoGetIpList.addNew(this.mContext4MSFGet, paramHwConfig, paramAppRuntime)) && (this.mStatus == 7)) {
      enterPushSsoGet(this.mContext4MSFGet, paramAppRuntime, paramString);
    }
    this.mContext4MSFGet = null;
  }
  
  public void onSrvAddrUnavailable(Context paramContext, AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    if (paramInt == 3) {
      log("onSrvAddrUnavailable() connError_unreachable");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            log("onSrvAddrUnavailable() IP = " + paramString2);
            switch (this.mStatus)
            {
            case 2: 
            case 7: 
            default: 
              return;
            }
          } while (!this.mPushIpList.fail(paramString2));
          enterPushIp(paramContext, paramAppRuntime, paramString1);
          return;
        } while (!this.mPushSsoGetIpList.fail(paramString2));
        enterPushSsoGet(paramContext, paramAppRuntime, paramString1);
        return;
      } while (!foundNRemoveIP(this.mHcDomainCandicateList, paramString2));
      enterHcDomain(paramContext, paramAppRuntime, paramString1);
      return;
    } while ((this.mHardCodeIpList == null) || (!this.mHardCodeIpList.foundNRemove(paramString2)));
    enterHcIp(paramContext, paramAppRuntime, paramString1);
  }
  
  public void resetSrvAddrState(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("resetSrvAddrState()");
    enterPre(paramContext, paramAppRuntime, paramString);
  }
  
  public void setOperator(int paramInt)
  {
    this.mOperator = paramInt;
  }
  
  private class Candiate
  {
    public int index;
    public String ip;
    
    public Candiate(String paramString)
    {
      this.ip = paramString;
      this.index = ConfigManager.rand(100);
    }
  }
  
  public class CustomComparator
    implements Comparator<ConfigManager.Candiate>
  {
    public CustomComparator() {}
    
    public int compare(ConfigManager.Candiate paramCandiate1, ConfigManager.Candiate paramCandiate2)
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
  
  private class HardCodeIpList
  {
    private CopyOnWriteArrayList<String> mHcIpCandicateListChinaMobile;
    private CopyOnWriteArrayList<String> mHcIpCandicateListChinaTelecom;
    private CopyOnWriteArrayList<String> mHcIpCandicateListChinaUnicom;
    private CopyOnWriteArrayList<String> mHcIpCandicateListOverseas;
    private CopyOnWriteArrayList<String> mHcIpCandicateListWifi;
    
    public HardCodeIpList()
    {
      if (this.mHcIpCandicateListWifi == null)
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        ArrayList localArrayList4 = new ArrayList();
        localArrayList3.add(new ConfigManager.Candiate(ConfigManager.this, "183.195.232.27"));
        localArrayList3.add(new ConfigManager.Candiate(ConfigManager.this, "120.196.211.21"));
        Collections.sort(localArrayList3, new ConfigManager.CustomComparator(ConfigManager.this));
        localArrayList2.add(new ConfigManager.Candiate(ConfigManager.this, "183.61.32.34"));
        localArrayList2.add(new ConfigManager.Candiate(ConfigManager.this, "111.161.81.209"));
        localArrayList2.add(new ConfigManager.Candiate(ConfigManager.this, "112.90.138.217"));
        localArrayList2.add(new ConfigManager.Candiate(ConfigManager.this, "27.115.124.18"));
        localArrayList2.add(new ConfigManager.Candiate(ConfigManager.this, "111.161.83.190"));
        Collections.sort(localArrayList2, new ConfigManager.CustomComparator(ConfigManager.this));
        localArrayList1.add(new ConfigManager.Candiate(ConfigManager.this, "183.60.49.204"));
        localArrayList1.add(new ConfigManager.Candiate(ConfigManager.this, "183.60.49.235"));
        localArrayList1.add(new ConfigManager.Candiate(ConfigManager.this, "222.73.80.27"));
        localArrayList1.add(new ConfigManager.Candiate(ConfigManager.this, "119.147.45.109"));
        localArrayList1.add(new ConfigManager.Candiate(ConfigManager.this, "123.151.37.14"));
        Collections.sort(localArrayList1, new ConfigManager.CustomComparator(ConfigManager.this));
        localArrayList4.add(new ConfigManager.Candiate(ConfigManager.this, "103.7.30.143"));
        localArrayList4.add(new ConfigManager.Candiate(ConfigManager.this, "203.205.140.60"));
        Collections.sort(localArrayList4, new ConfigManager.CustomComparator(ConfigManager.this));
        this.mHcIpCandicateListWifi = new CopyOnWriteArrayList();
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList1.get(0)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList2.get(0)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList3.get(0)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList4.get(0)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList1.get(1)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList2.get(1)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList3.get(1)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList4.get(1)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList1.get(2)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList2.get(2)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList1.get(3)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList2.get(3)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList1.get(4)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList2.get(4)).ip);
      }
      if (this.mHcIpCandicateListChinaMobile == null)
      {
        this.mHcIpCandicateListChinaMobile = new CopyOnWriteArrayList();
        this.mHcIpCandicateListChinaMobile.add("183.195.232.27");
        this.mHcIpCandicateListChinaMobile.add("111.30.131.145");
        this.mHcIpCandicateListChinaMobile.add("120.196.211.21");
      }
      if (this.mHcIpCandicateListChinaUnicom == null)
      {
        this.mHcIpCandicateListChinaUnicom = new CopyOnWriteArrayList();
        this.mHcIpCandicateListChinaUnicom.add("183.61.32.34");
        this.mHcIpCandicateListChinaUnicom.add("111.161.81.209");
        this.mHcIpCandicateListChinaUnicom.add("112.90.138.217");
        this.mHcIpCandicateListChinaUnicom.add("27.115.124.18");
        this.mHcIpCandicateListChinaUnicom.add("111.161.83.190");
      }
      if (this.mHcIpCandicateListChinaTelecom == null)
      {
        this.mHcIpCandicateListChinaTelecom = new CopyOnWriteArrayList();
        this.mHcIpCandicateListChinaTelecom.add("183.60.49.204");
        this.mHcIpCandicateListChinaTelecom.add("183.60.49.235");
        this.mHcIpCandicateListChinaTelecom.add("222.73.80.27");
        this.mHcIpCandicateListChinaTelecom.add("119.147.45.109");
        this.mHcIpCandicateListChinaTelecom.add("123.151.37.14");
      }
      if (this.mHcIpCandicateListOverseas == null)
      {
        this.mHcIpCandicateListOverseas = new CopyOnWriteArrayList();
        this.mHcIpCandicateListOverseas.add("103.7.30.143");
        this.mHcIpCandicateListOverseas.add("203.205.140.60");
      }
    }
    
    public boolean foundNRemove(String paramString)
    {
      if (ConfigManager.foundNRemoveIP(this.mHcIpCandicateListWifi, paramString)) {}
      while ((ConfigManager.foundNRemoveIP(this.mHcIpCandicateListChinaMobile, paramString)) || (ConfigManager.foundNRemoveIP(this.mHcIpCandicateListChinaUnicom, paramString)) || (ConfigManager.foundNRemoveIP(this.mHcIpCandicateListChinaTelecom, paramString))) {
        return true;
      }
      return false;
    }
    
    public EndPoint getNextIp(Context paramContext)
    {
      if (HwNetworkUtil.isWifiEnabled(paramContext)) {
        return ConfigManager.this.getOrderlyFromCandicate4HardCode(this.mHcIpCandicateListWifi);
      }
      switch (HwNetworkUtil.getCarrierOperatorType(paramContext))
      {
      default: 
        return ConfigManager.this.getRandomFromCandicate4HardCode(this.mHcIpCandicateListOverseas);
      case 2: 
        return ConfigManager.this.getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaMobile);
      case 3: 
        return ConfigManager.this.getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaUnicom);
      }
      return ConfigManager.this.getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaTelecom);
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
  }
  
  public class IpContainer
  {
    private static final String KEY_PRE_APN = "APN_";
    private static final String KEY_PRE_BSSID = "BSSID_";
    private static final String KEY_PRE_SSID = "SSID_";
    private static final String SUB_TAG = "IpContainer.";
    private ConfigManager.PersistentConfig mCfg;
    private String mFileName;
    
    public IpContainer(Context paramContext, String paramString, AppRuntime paramAppRuntime)
    {
      this.mFileName = paramString;
      this.mCfg = readDiskOrCreateNew(paramContext, paramString);
      addProxyIp(paramAppRuntime, false);
    }
    
    private Result find(Context paramContext)
    {
      Result localResult = new Result(null);
      paramContext = getCurrentKey(paramContext);
      localResult.keyList = paramContext;
      localResult.found = false;
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        String str = (String)paramContext.next();
        ArrayList localArrayList = (ArrayList)this.mCfg.mIpList.get(str);
        if (localArrayList != null)
        {
          ConfigManager.log("IpContainer.find() key=" + str + "   value= " + ((EndPoint)localArrayList.get(0)).toString());
          localResult.found = true;
          localResult.epList = localArrayList;
        }
      }
      return localResult;
    }
    
    private boolean findNRemove(ArrayList<EndPoint> paramArrayList, String paramString)
    {
      if (paramArrayList == null)
      {
        bool2 = false;
        return bool2;
      }
      boolean bool2 = false;
      EndPoint localEndPoint = null;
      int i = 0;
      label22:
      for (boolean bool1 = bool2;; bool1 = true)
      {
        try
        {
          if (i < paramArrayList.size())
          {
            localEndPoint = (EndPoint)paramArrayList.get(i);
            if (localEndPoint.host.equalsIgnoreCase(paramString))
            {
              if (paramArrayList.size() <= i) {
                continue;
              }
              paramArrayList.remove(i);
              continue;
            }
          }
          else
          {
            bool2 = bool1;
            if (!bool1) {
              break;
            }
            bool2 = bool1;
            if (localEndPoint.protoType != 1) {
              break;
            }
            localEndPoint.protoType = 2;
            paramArrayList.add(paramArrayList.size(), localEndPoint);
            bool2 = bool1;
            break;
          }
        }
        finally {}
        i += 1;
        break label22;
      }
    }
    
    private ArrayList<String> getCurrentKey(Context paramContext)
    {
      ArrayList localArrayList = new ArrayList();
      switch (HwNetworkUtil.getSystemNetwork(paramContext))
      {
      default: 
        return localArrayList;
      case 1: 
        localArrayList.add("BSSID_" + HwNetworkUtil.getCurrentWifiBSSID(paramContext));
        localArrayList.add("SSID_" + HwNetworkUtil.getCurrentWifiSSID(paramContext));
        return localArrayList;
      }
      localArrayList.add("APN_" + HwNetworkUtil.getCurrentApn(paramContext));
      return localArrayList;
    }
    
    private void insertOrReplace(Context paramContext, ConfigManager.PersistentConfig paramPersistentConfig, ArrayList<EndPoint> paramArrayList)
    {
      paramContext = getCurrentKey(paramContext).iterator();
      while (paramContext.hasNext())
      {
        String str = (String)paramContext.next();
        ConfigManager.log("IpContainer.insert() key= " + str + "   value= " + ((EndPoint)paramArrayList.get(0)).toString());
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          EndPoint localEndPoint = (EndPoint)localIterator.next();
          localArrayList.add(new EndPoint(localEndPoint.host, localEndPoint.port, localEndPoint.type));
        }
        paramPersistentConfig.mIpList.put(str, localArrayList);
      }
    }
    
    /* Error */
    private ConfigManager.PersistentConfig loadFromDisk(Context paramContext, String paramString)
    {
      // Byte code:
      //   0: new 195	java/io/File
      //   3: dup
      //   4: aload_1
      //   5: invokevirtual 201	android/content/Context:getFilesDir	()Ljava/io/File;
      //   8: invokevirtual 204	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   11: aload_2
      //   12: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   15: invokevirtual 210	java/io/File:exists	()Z
      //   18: ifne +29 -> 47
      //   21: new 97	java/lang/StringBuilder
      //   24: dup
      //   25: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   28: ldc 212
      //   30: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   33: aload_2
      //   34: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   40: invokestatic 120	com/tencent/mobileqq/highway/config/ConfigManager:access$500	(Ljava/lang/String;)V
      //   43: aconst_null
      //   44: astore_1
      //   45: aload_1
      //   46: areturn
      //   47: aconst_null
      //   48: astore 10
      //   50: aconst_null
      //   51: astore 9
      //   53: new 214	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB
      //   56: dup
      //   57: invokespecial 215	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:<init>	()V
      //   60: astore 13
      //   62: aconst_null
      //   63: astore 6
      //   65: aconst_null
      //   66: astore 7
      //   68: aconst_null
      //   69: astore 4
      //   71: aconst_null
      //   72: astore 11
      //   74: aconst_null
      //   75: astore 12
      //   77: aconst_null
      //   78: astore 8
      //   80: aload 12
      //   82: astore 5
      //   84: aload_1
      //   85: aload_2
      //   86: invokevirtual 219	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
      //   89: astore_1
      //   90: aload 12
      //   92: astore 5
      //   94: aload_1
      //   95: astore 4
      //   97: aload_1
      //   98: astore 6
      //   100: aload_1
      //   101: astore 7
      //   103: new 221	java/io/ByteArrayOutputStream
      //   106: dup
      //   107: invokespecial 222	java/io/ByteArrayOutputStream:<init>	()V
      //   110: astore_2
      //   111: sipush 128
      //   114: newarray byte
      //   116: astore 4
      //   118: aload_1
      //   119: aload 4
      //   121: iconst_0
      //   122: aload 4
      //   124: arraylength
      //   125: invokevirtual 228	java/io/FileInputStream:read	([BII)I
      //   128: istore_3
      //   129: iload_3
      //   130: iconst_m1
      //   131: if_icmpeq +72 -> 203
      //   134: aload_2
      //   135: aload 4
      //   137: iconst_0
      //   138: iload_3
      //   139: invokevirtual 232	java/io/ByteArrayOutputStream:write	([BII)V
      //   142: goto -24 -> 118
      //   145: astore 8
      //   147: aload 9
      //   149: astore 6
      //   151: aload_2
      //   152: astore 5
      //   154: aload_1
      //   155: astore 4
      //   157: aload 8
      //   159: invokevirtual 235	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
      //   162: aload_2
      //   163: astore 5
      //   165: aload_1
      //   166: astore 4
      //   168: ldc 237
      //   170: invokestatic 120	com/tencent/mobileqq/highway/config/ConfigManager:access$500	(Ljava/lang/String;)V
      //   173: aload_1
      //   174: ifnull +7 -> 181
      //   177: aload_1
      //   178: invokevirtual 240	java/io/FileInputStream:close	()V
      //   181: aload 6
      //   183: astore_1
      //   184: aload_2
      //   185: ifnull -140 -> 45
      //   188: aload_2
      //   189: invokevirtual 241	java/io/ByteArrayOutputStream:close	()V
      //   192: aload 6
      //   194: areturn
      //   195: astore_1
      //   196: aload_1
      //   197: invokevirtual 242	java/io/IOException:printStackTrace	()V
      //   200: aload 6
      //   202: areturn
      //   203: aload_2
      //   204: invokevirtual 245	java/io/ByteArrayOutputStream:flush	()V
      //   207: aload 13
      //   209: aload_2
      //   210: invokevirtual 249	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   213: invokevirtual 253	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
      //   216: pop
      //   217: new 85	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig
      //   220: dup
      //   221: aload_0
      //   222: getfield 32	com/tencent/mobileqq/highway/config/ConfigManager$IpContainer:this$0	Lcom/tencent/mobileqq/highway/config/ConfigManager;
      //   225: aconst_null
      //   226: invokespecial 256	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:<init>	(Lcom/tencent/mobileqq/highway/config/ConfigManager;Lcom/tencent/mobileqq/highway/config/ConfigManager$1;)V
      //   229: astore 4
      //   231: aload 4
      //   233: new 91	java/util/concurrent/ConcurrentHashMap
      //   236: dup
      //   237: invokespecial 257	java/util/concurrent/ConcurrentHashMap:<init>	()V
      //   240: putfield 89	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mIpList	Ljava/util/concurrent/ConcurrentHashMap;
      //   243: aload 4
      //   245: new 67	java/util/ArrayList
      //   248: dup
      //   249: invokespecial 150	java/util/ArrayList:<init>	()V
      //   252: putfield 260	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mSegConf	Ljava/util/ArrayList;
      //   255: aload 13
      //   257: getfield 264	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_config_item_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   260: invokevirtual 269	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
      //   263: invokeinterface 272 1 0
      //   268: astore 5
      //   270: aload 5
      //   272: invokeinterface 77 1 0
      //   277: ifeq +191 -> 468
      //   280: aload 5
      //   282: invokeinterface 81 1 0
      //   287: checkcast 274	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB
      //   290: astore 7
      //   292: aload 7
      //   294: getfield 278	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:string_key	Lcom/tencent/mobileqq/pb/PBStringField;
      //   297: invokevirtual 282	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
      //   300: astore 6
      //   302: aload 7
      //   304: getfield 285	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:rpt_end_point_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   307: invokevirtual 269	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
      //   310: checkcast 67	java/util/ArrayList
      //   313: astore 8
      //   315: new 67	java/util/ArrayList
      //   318: dup
      //   319: invokespecial 150	java/util/ArrayList:<init>	()V
      //   322: astore 7
      //   324: aload 8
      //   326: invokevirtual 71	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   329: astore 8
      //   331: aload 8
      //   333: invokeinterface 77 1 0
      //   338: ifeq +55 -> 393
      //   341: aload 8
      //   343: invokeinterface 81 1 0
      //   348: checkcast 287	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB
      //   351: astore 9
      //   353: aload 7
      //   355: new 111	com/tencent/mobileqq/highway/utils/EndPoint
      //   358: dup
      //   359: aload 9
      //   361: getfield 290	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:string_host	Lcom/tencent/mobileqq/pb/PBStringField;
      //   364: invokevirtual 282	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
      //   367: aload 9
      //   369: getfield 294	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int32_port	Lcom/tencent/mobileqq/pb/PBInt32Field;
      //   372: invokevirtual 298	com/tencent/mobileqq/pb/PBInt32Field:get	()I
      //   375: aload 9
      //   377: getfield 302	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int64_timestampe	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   380: invokevirtual 307	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   383: invokespecial 310	com/tencent/mobileqq/highway/utils/EndPoint:<init>	(Ljava/lang/String;IJ)V
      //   386: invokevirtual 163	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   389: pop
      //   390: goto -59 -> 331
      //   393: aload 4
      //   395: getfield 89	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mIpList	Ljava/util/concurrent/ConcurrentHashMap;
      //   398: aload 6
      //   400: aload 7
      //   402: invokevirtual 187	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   405: pop
      //   406: goto -136 -> 270
      //   409: astore 8
      //   411: aload 4
      //   413: astore 7
      //   415: aload_2
      //   416: astore 5
      //   418: aload_1
      //   419: astore 4
      //   421: aload 8
      //   423: invokevirtual 242	java/io/IOException:printStackTrace	()V
      //   426: aload_2
      //   427: astore 5
      //   429: aload_1
      //   430: astore 4
      //   432: ldc_w 312
      //   435: invokestatic 120	com/tencent/mobileqq/highway/config/ConfigManager:access$500	(Ljava/lang/String;)V
      //   438: aload_1
      //   439: ifnull +7 -> 446
      //   442: aload_1
      //   443: invokevirtual 240	java/io/FileInputStream:close	()V
      //   446: aload 7
      //   448: astore_1
      //   449: aload_2
      //   450: ifnull -405 -> 45
      //   453: aload_2
      //   454: invokevirtual 241	java/io/ByteArrayOutputStream:close	()V
      //   457: aload 7
      //   459: areturn
      //   460: astore_1
      //   461: aload_1
      //   462: invokevirtual 242	java/io/IOException:printStackTrace	()V
      //   465: aload 7
      //   467: areturn
      //   468: aload 13
      //   470: getfield 315	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_net_seg_conf_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   473: invokevirtual 269	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
      //   476: invokeinterface 272 1 0
      //   481: astore 5
      //   483: aload 5
      //   485: invokeinterface 77 1 0
      //   490: ifeq +98 -> 588
      //   493: aload 5
      //   495: invokeinterface 81 1 0
      //   500: checkcast 317	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB
      //   503: astore 6
      //   505: new 319	com/tencent/mobileqq/highway/config/HwNetSegConf
      //   508: dup
      //   509: aload 6
      //   511: getfield 322	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_net_type	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   514: invokevirtual 307	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   517: aload 6
      //   519: getfield 325	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_size	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   522: invokevirtual 307	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   525: aload 6
      //   527: getfield 328	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   530: invokevirtual 307	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   533: aload 6
      //   535: getfield 331	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_cur_conn_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   538: invokevirtual 307	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   541: invokespecial 334	com/tencent/mobileqq/highway/config/HwNetSegConf:<init>	(JJJJ)V
      //   544: astore 6
      //   546: aload 4
      //   548: getfield 260	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mSegConf	Ljava/util/ArrayList;
      //   551: aload 6
      //   553: invokevirtual 163	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   556: pop
      //   557: goto -74 -> 483
      //   560: astore 4
      //   562: aload_2
      //   563: astore 5
      //   565: aload 4
      //   567: astore_2
      //   568: aload_1
      //   569: ifnull +7 -> 576
      //   572: aload_1
      //   573: invokevirtual 240	java/io/FileInputStream:close	()V
      //   576: aload 5
      //   578: ifnull +8 -> 586
      //   581: aload 5
      //   583: invokevirtual 241	java/io/ByteArrayOutputStream:close	()V
      //   586: aload_2
      //   587: athrow
      //   588: aload_1
      //   589: ifnull +7 -> 596
      //   592: aload_1
      //   593: invokevirtual 240	java/io/FileInputStream:close	()V
      //   596: aload_2
      //   597: ifnull +117 -> 714
      //   600: aload_2
      //   601: invokevirtual 241	java/io/ByteArrayOutputStream:close	()V
      //   604: aload 4
      //   606: areturn
      //   607: astore_1
      //   608: aload_1
      //   609: invokevirtual 242	java/io/IOException:printStackTrace	()V
      //   612: goto -16 -> 596
      //   615: astore_1
      //   616: aload_1
      //   617: invokevirtual 242	java/io/IOException:printStackTrace	()V
      //   620: aload 4
      //   622: areturn
      //   623: astore_1
      //   624: aload_1
      //   625: invokevirtual 242	java/io/IOException:printStackTrace	()V
      //   628: goto -447 -> 181
      //   631: astore_1
      //   632: aload_1
      //   633: invokevirtual 242	java/io/IOException:printStackTrace	()V
      //   636: goto -190 -> 446
      //   639: astore_1
      //   640: aload_1
      //   641: invokevirtual 242	java/io/IOException:printStackTrace	()V
      //   644: goto -68 -> 576
      //   647: astore_1
      //   648: aload_1
      //   649: invokevirtual 242	java/io/IOException:printStackTrace	()V
      //   652: goto -66 -> 586
      //   655: astore_2
      //   656: aload 4
      //   658: astore_1
      //   659: goto -91 -> 568
      //   662: astore 4
      //   664: aload_2
      //   665: astore 5
      //   667: aload 4
      //   669: astore_2
      //   670: goto -102 -> 568
      //   673: astore 8
      //   675: aload 11
      //   677: astore_2
      //   678: aload 10
      //   680: astore 7
      //   682: aload 6
      //   684: astore_1
      //   685: goto -270 -> 415
      //   688: astore 8
      //   690: aload 10
      //   692: astore 7
      //   694: goto -279 -> 415
      //   697: astore_1
      //   698: aload 8
      //   700: astore_2
      //   701: aload_1
      //   702: astore 8
      //   704: aload 9
      //   706: astore 6
      //   708: aload 7
      //   710: astore_1
      //   711: goto -560 -> 151
      //   714: aload 4
      //   716: areturn
      //   717: astore 8
      //   719: aload 4
      //   721: astore 6
      //   723: goto -572 -> 151
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	726	0	this	IpContainer
      //   0	726	1	paramContext	Context
      //   0	726	2	paramString	String
      //   128	11	3	i	int
      //   69	478	4	localObject1	Object
      //   560	97	4	localPersistentConfig1	ConfigManager.PersistentConfig
      //   662	58	4	localPersistentConfig2	ConfigManager.PersistentConfig
      //   82	584	5	localObject2	Object
      //   63	659	6	localObject3	Object
      //   66	643	7	localObject4	Object
      //   78	1	8	localObject5	Object
      //   145	13	8	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
      //   313	29	8	localObject6	Object
      //   409	13	8	localIOException1	java.io.IOException
      //   673	1	8	localIOException2	java.io.IOException
      //   688	11	8	localIOException3	java.io.IOException
      //   702	1	8	localContext	Context
      //   717	1	8	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
      //   51	654	9	localHwEndPointPB	com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwEndPointPB
      //   48	643	10	localObject7	Object
      //   72	604	11	localObject8	Object
      //   75	16	12	localObject9	Object
      //   60	409	13	localHwConfigPB	com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwConfigPB
      // Exception table:
      //   from	to	target	type
      //   111	118	145	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   118	129	145	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   134	142	145	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   203	231	145	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   188	192	195	java/io/IOException
      //   231	270	409	java/io/IOException
      //   270	331	409	java/io/IOException
      //   331	390	409	java/io/IOException
      //   393	406	409	java/io/IOException
      //   468	483	409	java/io/IOException
      //   483	557	409	java/io/IOException
      //   453	457	460	java/io/IOException
      //   231	270	560	finally
      //   270	331	560	finally
      //   331	390	560	finally
      //   393	406	560	finally
      //   468	483	560	finally
      //   483	557	560	finally
      //   592	596	607	java/io/IOException
      //   600	604	615	java/io/IOException
      //   177	181	623	java/io/IOException
      //   442	446	631	java/io/IOException
      //   572	576	639	java/io/IOException
      //   581	586	647	java/io/IOException
      //   84	90	655	finally
      //   103	111	655	finally
      //   157	162	655	finally
      //   168	173	655	finally
      //   421	426	655	finally
      //   432	438	655	finally
      //   111	118	662	finally
      //   118	129	662	finally
      //   134	142	662	finally
      //   203	231	662	finally
      //   84	90	673	java/io/IOException
      //   103	111	673	java/io/IOException
      //   111	118	688	java/io/IOException
      //   118	129	688	java/io/IOException
      //   134	142	688	java/io/IOException
      //   203	231	688	java/io/IOException
      //   84	90	697	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   103	111	697	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   231	270	717	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   270	331	717	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   331	390	717	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   393	406	717	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   468	483	717	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   483	557	717	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    }
    
    private ConfigManager.PersistentConfig readDiskOrCreateNew(Context paramContext, String paramString)
    {
      paramContext = loadFromDisk(paramContext, paramString);
      if (paramContext == null)
      {
        paramContext = new ConfigManager.PersistentConfig(ConfigManager.this, null);
        paramContext.mIpList = new ConcurrentHashMap();
        paramContext.mSegConf = new ArrayList();
        ConfigManager.log("IpContainer." + paramString + " does NOT exists.");
        return paramContext;
      }
      ConfigManager.log("IpContainer." + paramString + " does exists.");
      return paramContext;
    }
    
    /* Error */
    private void write2disk(Context paramContext, String paramString, ConfigManager.PersistentConfig paramPersistentConfig)
    {
      // Byte code:
      //   0: new 214	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB
      //   3: dup
      //   4: invokespecial 215	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:<init>	()V
      //   7: astore 6
      //   9: aload_3
      //   10: getfield 89	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mIpList	Ljava/util/concurrent/ConcurrentHashMap;
      //   13: invokevirtual 348	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
      //   16: invokeinterface 351 1 0
      //   21: astore 4
      //   23: aload 4
      //   25: invokeinterface 77 1 0
      //   30: ifeq +178 -> 208
      //   33: aload 4
      //   35: invokeinterface 81 1 0
      //   40: checkcast 353	java/util/Map$Entry
      //   43: astore 7
      //   45: aload 7
      //   47: invokeinterface 356 1 0
      //   52: checkcast 83	java/lang/String
      //   55: astore 5
      //   57: aload 7
      //   59: invokeinterface 359 1 0
      //   64: checkcast 67	java/util/ArrayList
      //   67: astore 8
      //   69: new 67	java/util/ArrayList
      //   72: dup
      //   73: invokespecial 150	java/util/ArrayList:<init>	()V
      //   76: astore 7
      //   78: aload 8
      //   80: invokevirtual 71	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   83: astore 8
      //   85: aload 8
      //   87: invokeinterface 77 1 0
      //   92: ifeq +74 -> 166
      //   95: aload 8
      //   97: invokeinterface 81 1 0
      //   102: checkcast 111	com/tencent/mobileqq/highway/utils/EndPoint
      //   105: astore 9
      //   107: new 287	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB
      //   110: dup
      //   111: invokespecial 360	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:<init>	()V
      //   114: astore 10
      //   116: aload 10
      //   118: getfield 290	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:string_host	Lcom/tencent/mobileqq/pb/PBStringField;
      //   121: aload 9
      //   123: getfield 132	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
      //   126: invokevirtual 363	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
      //   129: aload 10
      //   131: getfield 294	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int32_port	Lcom/tencent/mobileqq/pb/PBInt32Field;
      //   134: aload 9
      //   136: getfield 177	com/tencent/mobileqq/highway/utils/EndPoint:port	I
      //   139: invokevirtual 366	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
      //   142: aload 10
      //   144: getfield 302	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int64_timestampe	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   147: aload 9
      //   149: getfield 370	com/tencent/mobileqq/highway/utils/EndPoint:timestampe	J
      //   152: invokevirtual 373	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   155: aload 7
      //   157: aload 10
      //   159: invokevirtual 163	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   162: pop
      //   163: goto -78 -> 85
      //   166: new 274	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB
      //   169: dup
      //   170: invokespecial 374	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:<init>	()V
      //   173: astore 8
      //   175: aload 8
      //   177: getfield 278	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:string_key	Lcom/tencent/mobileqq/pb/PBStringField;
      //   180: aload 5
      //   182: invokevirtual 363	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
      //   185: aload 8
      //   187: getfield 285	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:rpt_end_point_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   190: aload 7
      //   192: invokevirtual 377	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
      //   195: aload 6
      //   197: getfield 264	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_config_item_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   200: aload 8
      //   202: invokevirtual 380	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
      //   205: goto -182 -> 23
      //   208: new 67	java/util/ArrayList
      //   211: dup
      //   212: invokespecial 150	java/util/ArrayList:<init>	()V
      //   215: astore 4
      //   217: aload_3
      //   218: getfield 260	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mSegConf	Ljava/util/ArrayList;
      //   221: invokevirtual 71	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   224: astore_3
      //   225: aload_3
      //   226: invokeinterface 77 1 0
      //   231: ifeq +86 -> 317
      //   234: aload_3
      //   235: invokeinterface 81 1 0
      //   240: checkcast 319	com/tencent/mobileqq/highway/config/HwNetSegConf
      //   243: astore 5
      //   245: new 317	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB
      //   248: dup
      //   249: invokespecial 381	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:<init>	()V
      //   252: astore 7
      //   254: aload 7
      //   256: getfield 322	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_net_type	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   259: aload 5
      //   261: getfield 384	com/tencent/mobileqq/highway/config/HwNetSegConf:netType	J
      //   264: invokevirtual 373	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   267: aload 7
      //   269: getfield 325	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_size	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   272: aload 5
      //   274: getfield 387	com/tencent/mobileqq/highway/config/HwNetSegConf:segSize	J
      //   277: invokevirtual 373	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   280: aload 7
      //   282: getfield 328	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   285: aload 5
      //   287: getfield 390	com/tencent/mobileqq/highway/config/HwNetSegConf:segNum	J
      //   290: invokevirtual 373	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   293: aload 7
      //   295: getfield 331	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_cur_conn_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   298: aload 5
      //   300: getfield 393	com/tencent/mobileqq/highway/config/HwNetSegConf:curConnNum	J
      //   303: invokevirtual 373	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   306: aload 4
      //   308: aload 7
      //   310: invokevirtual 163	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   313: pop
      //   314: goto -89 -> 225
      //   317: aload 6
      //   319: getfield 315	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_net_seg_conf_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   322: aload 4
      //   324: invokevirtual 377	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
      //   327: new 195	java/io/File
      //   330: dup
      //   331: aload_1
      //   332: invokevirtual 201	android/content/Context:getFilesDir	()Ljava/io/File;
      //   335: invokevirtual 204	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   338: aload_2
      //   339: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   342: astore_3
      //   343: aconst_null
      //   344: astore 5
      //   346: aconst_null
      //   347: astore_1
      //   348: aconst_null
      //   349: astore 4
      //   351: new 395	java/io/FileOutputStream
      //   354: dup
      //   355: aload_3
      //   356: invokespecial 398	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   359: astore_3
      //   360: aload_3
      //   361: aload 6
      //   363: invokevirtual 399	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:toByteArray	()[B
      //   366: invokevirtual 402	java/io/FileOutputStream:write	([B)V
      //   369: new 97	java/lang/StringBuilder
      //   372: dup
      //   373: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   376: ldc_w 404
      //   379: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   382: aload_2
      //   383: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   386: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   389: invokestatic 120	com/tencent/mobileqq/highway/config/ConfigManager:access$500	(Ljava/lang/String;)V
      //   392: aload_3
      //   393: ifnull +139 -> 532
      //   396: aload_3
      //   397: invokevirtual 405	java/io/FileOutputStream:close	()V
      //   400: return
      //   401: astore_1
      //   402: aload_1
      //   403: invokevirtual 242	java/io/IOException:printStackTrace	()V
      //   406: return
      //   407: astore_1
      //   408: aload 4
      //   410: astore_3
      //   411: aload_1
      //   412: astore 4
      //   414: aload_3
      //   415: astore_1
      //   416: aload 4
      //   418: invokevirtual 406	java/io/FileNotFoundException:printStackTrace	()V
      //   421: aload_3
      //   422: astore_1
      //   423: new 97	java/lang/StringBuilder
      //   426: dup
      //   427: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   430: ldc_w 408
      //   433: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   436: aload_2
      //   437: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   440: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   443: invokestatic 120	com/tencent/mobileqq/highway/config/ConfigManager:access$500	(Ljava/lang/String;)V
      //   446: aload_3
      //   447: ifnull -47 -> 400
      //   450: aload_3
      //   451: invokevirtual 405	java/io/FileOutputStream:close	()V
      //   454: return
      //   455: astore_1
      //   456: aload_1
      //   457: invokevirtual 242	java/io/IOException:printStackTrace	()V
      //   460: return
      //   461: astore_3
      //   462: aload 5
      //   464: astore_2
      //   465: aload_2
      //   466: astore_1
      //   467: aload_3
      //   468: invokevirtual 242	java/io/IOException:printStackTrace	()V
      //   471: aload_2
      //   472: astore_1
      //   473: ldc_w 410
      //   476: invokestatic 120	com/tencent/mobileqq/highway/config/ConfigManager:access$500	(Ljava/lang/String;)V
      //   479: aload_2
      //   480: ifnull -80 -> 400
      //   483: aload_2
      //   484: invokevirtual 405	java/io/FileOutputStream:close	()V
      //   487: return
      //   488: astore_1
      //   489: aload_1
      //   490: invokevirtual 242	java/io/IOException:printStackTrace	()V
      //   493: return
      //   494: astore_2
      //   495: aload_1
      //   496: ifnull +7 -> 503
      //   499: aload_1
      //   500: invokevirtual 405	java/io/FileOutputStream:close	()V
      //   503: aload_2
      //   504: athrow
      //   505: astore_1
      //   506: aload_1
      //   507: invokevirtual 242	java/io/IOException:printStackTrace	()V
      //   510: goto -7 -> 503
      //   513: astore_2
      //   514: aload_3
      //   515: astore_1
      //   516: goto -21 -> 495
      //   519: astore_1
      //   520: aload_3
      //   521: astore_2
      //   522: aload_1
      //   523: astore_3
      //   524: goto -59 -> 465
      //   527: astore 4
      //   529: goto -115 -> 414
      //   532: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	533	0	this	IpContainer
      //   0	533	1	paramContext	Context
      //   0	533	2	paramString	String
      //   0	533	3	paramPersistentConfig	ConfigManager.PersistentConfig
      //   21	396	4	localObject1	Object
      //   527	1	4	localFileNotFoundException	java.io.FileNotFoundException
      //   55	408	5	localObject2	Object
      //   7	355	6	localHwConfigPB	com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwConfigPB
      //   43	266	7	localObject3	Object
      //   67	134	8	localObject4	Object
      //   105	43	9	localEndPoint	EndPoint
      //   114	44	10	localHwEndPointPB	com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwEndPointPB
      // Exception table:
      //   from	to	target	type
      //   396	400	401	java/io/IOException
      //   351	360	407	java/io/FileNotFoundException
      //   450	454	455	java/io/IOException
      //   351	360	461	java/io/IOException
      //   483	487	488	java/io/IOException
      //   351	360	494	finally
      //   416	421	494	finally
      //   423	446	494	finally
      //   467	471	494	finally
      //   473	479	494	finally
      //   499	503	505	java/io/IOException
      //   360	392	513	finally
      //   360	392	519	java/io/IOException
      //   360	392	527	java/io/FileNotFoundException
    }
    
    public boolean addNew(Context paramContext, HwConfig paramHwConfig, AppRuntime paramAppRuntime)
    {
      try
      {
        ConfigManager.log("IpContainer.addNew() " + paramHwConfig.ipList2String());
        long l = SystemClock.uptimeMillis();
        localObject = paramHwConfig.ipList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((EndPoint)((Iterator)localObject).next()).timestampe = l;
        }
        bool2 = false;
      }
      finally {}
      Object localObject = readDiskOrCreateNew(paramContext, this.mFileName);
      boolean bool1 = bool2;
      if (paramHwConfig != null)
      {
        bool1 = bool2;
        if (paramHwConfig.ipList != null)
        {
          bool1 = bool2;
          if (!paramHwConfig.ipList.isEmpty())
          {
            bool1 = true;
            insertOrReplace(paramContext, (ConfigManager.PersistentConfig)localObject, paramHwConfig.ipList);
            insertOrReplace(paramContext, this.mCfg, paramHwConfig.ipList);
            addProxyIp(paramAppRuntime, false);
          }
        }
      }
      boolean bool2 = bool1;
      if (paramHwConfig != null)
      {
        bool2 = bool1;
        if (paramHwConfig.netSegConfList != null)
        {
          bool2 = bool1;
          if (!paramHwConfig.netSegConfList.isEmpty())
          {
            bool2 = true;
            ((ConfigManager.PersistentConfig)localObject).mSegConf = paramHwConfig.netSegConfList;
            this.mCfg.mSegConf = paramHwConfig.netSegConfList;
          }
        }
      }
      if (bool2) {
        write2disk(paramContext, this.mFileName, (ConfigManager.PersistentConfig)localObject);
      }
      return bool2;
    }
    
    public void addProxyIp(AppRuntime paramAppRuntime, boolean paramBoolean)
    {
      Object localObject1 = ((ProxyIpManager)paramAppRuntime.getManager(3)).getProxyIp(1);
      if ((localObject1 == null) || (((List)localObject1).isEmpty()))
      {
        if (paramBoolean) {
          deleteProxyIp();
        }
        if (QLog.isColorLevel()) {
          QLog.d("PROXY_IP", 2, "[TCP] Proxy IP List is empty!");
        }
      }
      do
      {
        return;
        deleteProxyIp();
        paramAppRuntime = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        Object localObject2;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ProxyIpManager.ProxyIp)((Iterator)localObject1).next();
          paramAppRuntime.add(new EndPoint(((ProxyIpManager.ProxyIp)localObject2).ip, ((ProxyIpManager.ProxyIp)localObject2).port, 1));
        }
        int i = 0;
        localObject1 = this.mCfg.mIpList.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (((String)localObject2).startsWith("APN_"))
          {
            i = 1;
            ((ArrayList)this.mCfg.mIpList.get(localObject2)).addAll(0, paramAppRuntime);
          }
        }
        if (i == 0)
        {
          localObject1 = getCurrentKey(BaseApplication.getContext()).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            if (((String)localObject2).startsWith("APN_")) {
              this.mCfg.mIpList.put(localObject2, paramAppRuntime);
            }
          }
        }
        ConfigManager.access$602(ConfigManager.this, 3);
      } while (!QLog.isColorLevel());
      QLog.d("PROXY_IP", 2, "[TCP] add " + paramAppRuntime.size() + " proxy ip to List success!");
    }
    
    public void deleteProxyIp()
    {
      if (QLog.isColorLevel()) {
        QLog.d("PROXY_IP", 2, "[TCP] clear proxy ip !");
      }
      Iterator localIterator1 = this.mCfg.mIpList.keySet().iterator();
      while (localIterator1.hasNext())
      {
        Object localObject = (String)localIterator1.next();
        if (((String)localObject).startsWith("APN_"))
        {
          localObject = (ArrayList)this.mCfg.mIpList.get(localObject);
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator2 = ((ArrayList)localObject).iterator();
          while (localIterator2.hasNext())
          {
            EndPoint localEndPoint = (EndPoint)localIterator2.next();
            if (localEndPoint.isPorxyIp()) {
              localArrayList.add(localEndPoint);
            }
          }
          ((ArrayList)localObject).removeAll(localArrayList);
        }
      }
    }
    
    public boolean fail(String paramString)
    {
      for (;;)
      {
        Object localObject;
        boolean bool1;
        try
        {
          if ((this.mCfg == null) || (this.mCfg.mIpList == null) || (this.mCfg.mIpList.isEmpty()))
          {
            ConfigManager.log("IpContainer.fail() found due to mCfg == null || mCfg.mIpList == null || mCfg.mIpList.isEmpty()");
            bool2 = false;
            return bool2;
          }
          localObject = new ArrayList();
          bool1 = false;
          Iterator localIterator = this.mCfg.mIpList.keySet().iterator();
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            ArrayList localArrayList = (ArrayList)this.mCfg.mIpList.get(str);
            bool2 = bool1;
            if (findNRemove(localArrayList, paramString))
            {
              bool2 = true;
              ConfigManager.log("IpContainer.fail() remove ip " + paramString + " in " + str + " which has " + (localArrayList.size() + 1) + " IPs");
            }
            bool1 = bool2;
            if (!localArrayList.isEmpty()) {
              continue;
            }
            ((ArrayList)localObject).add(str);
            bool1 = bool2;
            continue;
          }
          paramString = ((ArrayList)localObject).iterator();
        }
        finally {}
        while (paramString.hasNext())
        {
          localObject = (String)paramString.next();
          ConfigManager.log("IpContainer.fail() " + (String)localObject + " is empty, remove it");
          this.mCfg.mIpList.remove(localObject);
        }
        boolean bool2 = bool1;
        if (!bool1)
        {
          ConfigManager.log("IpContainer.fail() found NONE");
          bool2 = bool1;
        }
      }
    }
    
    public EndPoint get(Context paramContext)
    {
      for (;;)
      {
        Object localObject;
        try
        {
          if (isEmpty(paramContext))
          {
            ConfigManager.log("IpContainer.get() FAIL to find IP, due to IP List is EMPTY.");
            paramContext = null;
            return paramContext;
          }
          localObject = find(paramContext);
          if (((Result)localObject).found)
          {
            paramContext = (EndPoint)((Result)localObject).epList.get(0);
            ConfigManager.log("IpContainer.get() found IP= " + paramContext.toString() + " with key= " + (String)((Result)localObject).keyList.get(0));
            continue;
          }
          l = -1L;
        }
        finally {}
        long l;
        paramContext = null;
        Iterator localIterator = this.mCfg.mIpList.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject = (ArrayList)((Map.Entry)localIterator.next()).getValue();
          if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
          {
            localObject = (EndPoint)((ArrayList)localObject).get(0);
            if ((localObject != null) && (((EndPoint)localObject).timestampe > l))
            {
              l = ((EndPoint)localObject).timestampe;
              paramContext = (Context)localObject;
            }
          }
        }
        if (paramContext == null)
        {
          ConfigManager.log("IpContainer.get() FAIL to find IP from RECENT added record.");
          paramContext = null;
        }
        else
        {
          ConfigManager.log("IpContainer.get() found IP from RECENT added record, ip=" + paramContext.toString());
        }
      }
    }
    
    public ArrayList<HwNetSegConf> getNetSegConf(Context paramContext)
    {
      return this.mCfg.mSegConf;
    }
    
    public boolean isEmpty(Context paramContext)
    {
      if ((this.mCfg == null) || (this.mCfg.mIpList == null)) {
        return true;
      }
      return this.mCfg.mIpList.isEmpty();
    }
    
    private class Result
    {
      public ArrayList<EndPoint> epList;
      public boolean found;
      public ArrayList<String> keyList;
      
      private Result() {}
    }
  }
  
  private class PersistentConfig
  {
    public ConcurrentHashMap<String, ArrayList<EndPoint>> mIpList;
    public ArrayList<HwNetSegConf> mSegConf;
    
    private PersistentConfig() {}
  }
  
  private static abstract interface SrvAddrStatus
  {
    public static final int ERROR = 7;
    public static final int HC_DOMAIN = 5;
    public static final int HC_IP = 6;
    public static final int INIT = 2;
    public static final int NONE = 0;
    public static final int PRE = 1;
    public static final int PUSH_IP = 3;
    public static final int PUSH_SSOGET = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.ConfigManager
 * JD-Core Version:    0.7.0.1
 */