package com.tencent.qqmail.account;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.account.model.EmailDomainDefine;
import com.tencent.qqmail.account.watcher.QueryProviderWatcher;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.UMA.CmdQueryDomainConfigRsp;
import com.tencent.qqmail.protocol.UMA.DomainConfig;
import com.tencent.qqmail.protocol.UMA.EmailProtocolConfig;
import com.tencent.qqmail.protocol.UMA.EmailSecurityConfig;
import com.tencent.qqmail.provider.MailServiceProvider;
import com.tencent.qqmail.provider.MailServiceProviderSQLiteHelper;
import com.tencent.qqmail.provider.PlistHandler;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import moai.core.watcher.Watchers;
import org.xml.sax.InputSource;

public class MailServiceManager
{
  public static final String PROVIDER_COMPANY_126 = "6";
  public static final String PROVIDER_COMPANY_163 = "5";
  public static final String PROVIDER_COMPANY_GMAIL = "3";
  public static final String PROVIDER_COMPANY_OUTLOOK = "4";
  public static final String PROVIDER_COMPANY_QQMAIL = "1";
  public static final String PROVIDER_COMPANY_QQMAIL_BIZ = "2";
  public static final String PROVIDER_COMPANY_UNKNOWN = "0";
  private static final String TAG = "MailServiceManager";
  public static final String UMA_ERROR_NO_CONFIG_ON_SERVER = "no_config_on_server";
  public static final String UMA_ERROR_UNKNOWN_ERROR = "unknown_error";
  private static volatile MailServiceManager instance;
  private HashMap<String, MailServiceProvider> autoFillProviderMap = new HashMap();
  private MailServiceProviderSQLiteHelper sqliteHelper = new MailServiceProviderSQLiteHelper(QMApplicationContext.sharedInstance());
  
  private void addArrayToProviderMap(ArrayList<Object> paramArrayList)
  {
    Object localObject1 = new StringBuilder().append("addArrayToPlist.array size:");
    int i;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    if (paramArrayList == null)
    {
      i = -1;
      QMLog.log(4, "MailServiceManager", i);
      if (paramArrayList != null)
      {
        localObject1 = this.sqliteHelper.getWritableDatabase();
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        paramArrayList = paramArrayList.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!paramArrayList.hasNext()) {
          break label202;
        }
        Object localObject2 = paramArrayList.next();
        MailServiceProvider localMailServiceProvider = new MailServiceProvider();
        HashMap localHashMap = (HashMap)localObject2;
        localObject2 = convertHashMapToProvider(localMailServiceProvider, localHashMap);
        if (localObject2 != null)
        {
          int j = localObject2.length;
          i = 0;
          while (i < j)
          {
            localHashMap = localObject2[i];
            localArrayList1.add(localMailServiceProvider);
            localArrayList2.add(localHashMap);
            i += 1;
          }
          continue;
          i = paramArrayList.size();
          break;
        }
        QMLog.log(6, "MailServiceManager", "server config err:" + localHashMap.get("Provider Icon"));
      }
    }
    try
    {
      label202:
      ((SQLiteDatabase)localObject1).beginTransaction();
      this.sqliteHelper.insertMailServiceProvider((SQLiteDatabase)localObject1, localArrayList2, localArrayList1, 1);
      ((SQLiteDatabase)localObject1).setTransactionSuccessful();
      return;
    }
    catch (Exception paramArrayList)
    {
      QMLog.log(6, "MailServiceManager", "addArrayToProviderMap " + paramArrayList.getMessage());
      return;
    }
    finally
    {
      ((SQLiteDatabase)localObject1).endTransaction();
    }
  }
  
  private boolean checkASConfig(MailServiceProvider paramMailServiceProvider)
  {
    return ("ActiveSync".equals(paramMailServiceProvider.getDefaultRecvProtocol())) && (!StringExtention.isNullOrEmpty(paramMailServiceProvider.getActiveSyncServer()));
  }
  
  private boolean checkExchangeConfig(MailServiceProvider paramMailServiceProvider)
  {
    return ("Exchange".equals(paramMailServiceProvider.getDefaultRecvProtocol())) && (!StringExtention.isNullOrEmpty(paramMailServiceProvider.getExchangeServer()));
  }
  
  private boolean checkImapConfig(MailServiceProvider paramMailServiceProvider)
  {
    return ("IMAP".equals(paramMailServiceProvider.getDefaultRecvProtocol())) && (!StringExtention.isNullOrEmpty(paramMailServiceProvider.getImapServer())) && (((!paramMailServiceProvider.isImapUsingSSL()) && (paramMailServiceProvider.getImapPort() != 0)) || ((paramMailServiceProvider.isImapUsingSSL()) && (paramMailServiceProvider.getImapSSLPort() != 0)));
  }
  
  private boolean checkMailServiceProvider(MailServiceProvider paramMailServiceProvider)
  {
    return (checkASConfig(paramMailServiceProvider)) || (checkExchangeConfig(paramMailServiceProvider)) || (((checkPopConfig(paramMailServiceProvider)) || (checkImapConfig(paramMailServiceProvider))) && (checkSmtpConfig(paramMailServiceProvider)));
  }
  
  private boolean checkPopConfig(MailServiceProvider paramMailServiceProvider)
  {
    return ("POP3".equals(paramMailServiceProvider.getDefaultRecvProtocol())) && (!StringExtention.isNullOrEmpty(paramMailServiceProvider.getPop3Server())) && (((!paramMailServiceProvider.isPop3UsingSSL()) && (paramMailServiceProvider.getPop3Port() != 0)) || ((paramMailServiceProvider.isPop3UsingSSL()) && (paramMailServiceProvider.getPop3SSLPort() != 0)));
  }
  
  private boolean checkSmtpConfig(MailServiceProvider paramMailServiceProvider)
  {
    return (!StringExtention.isNullOrEmpty(paramMailServiceProvider.getSmtpServer())) && (((!paramMailServiceProvider.isSmtpUsingSSL()) && (paramMailServiceProvider.getSmtpPort() != 0)) || ((paramMailServiceProvider.isSmtpUsingSSL()) && (paramMailServiceProvider.getSmtpSSLPort() != 0)));
  }
  
  private boolean convertDomainCfgToProvider(MailServiceProvider paramMailServiceProvider, DomainConfig paramDomainConfig)
  {
    if (paramDomainConfig == null)
    {
      QMLog.log(5, "MailServiceManager", "convertDomainCfgToProvider. cfg is null");
      return false;
    }
    Object localObject = paramDomainConfig.fit_add_account_entry;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      localObject = ((List)localObject).iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      paramMailServiceProvider.addProviderCompanyEntry(String.valueOf(((Integer)((Iterator)localObject).next()).intValue()));
      continue;
      paramMailServiceProvider.addProviderCompanyEntry("0");
    }
    switch (paramDomainConfig.default_recv_type)
    {
    }
    while ((paramMailServiceProvider.getDefaultRecvProtocol() == null) || (paramMailServiceProvider.getDefaultRecvProtocol().equals("")))
    {
      QMLog.log(6, "MailServiceManager", "no Default Recv Protocol exist:" + paramDomainConfig.domain);
      return false;
      paramMailServiceProvider.setDefaultRecvProtocol("IMAP");
      continue;
      paramMailServiceProvider.setDefaultRecvProtocol("POP3");
      continue;
      paramMailServiceProvider.setDefaultRecvProtocol("ActiveSync");
      continue;
      paramMailServiceProvider.setDefaultRecvProtocol("Exchange");
    }
    localObject = paramDomainConfig.domain;
    if ((localObject != null) && (!((String)localObject).equals("")))
    {
      paramMailServiceProvider.setProviderName((String)localObject);
      paramMailServiceProvider.setProviderIcon((String)localObject);
      paramMailServiceProvider.setProviderAvatar((String)localObject);
      paramMailServiceProvider.setMailAddressSuffix(new String[] { localObject });
    }
    localObject = paramDomainConfig.available_proto_config;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmailProtocolConfig localEmailProtocolConfig = (EmailProtocolConfig)((Iterator)localObject).next();
        String str = localEmailProtocolConfig.host;
        int n = localEmailProtocolConfig.flag;
        Iterator localIterator = localEmailProtocolConfig.security.iterator();
        int j = 0;
        int k = 0;
        boolean bool = false;
        if (localIterator.hasNext())
        {
          EmailSecurityConfig localEmailSecurityConfig = (EmailSecurityConfig)localIterator.next();
          if (localEmailSecurityConfig.type == 2) {
            if (localEmailSecurityConfig.override_config != null) {
              if ((localEmailSecurityConfig.override_config.port != -2147483648) && (localEmailSecurityConfig.override_config.port != 0))
              {
                i = 1;
                label418:
                if (i == 0) {
                  break label445;
                }
                i = localEmailSecurityConfig.override_config.port;
                label431:
                bool = true;
              }
            }
          }
          for (;;)
          {
            k = i;
            break;
            i = 0;
            break label418;
            label445:
            i = localEmailProtocolConfig.port;
            break label431;
            i = localEmailProtocolConfig.port;
            bool = true;
            continue;
            if (localEmailSecurityConfig.override_config != null)
            {
              if ((localEmailSecurityConfig.override_config.port != -2147483648) && (localEmailSecurityConfig.override_config.port != 0))
              {
                i = 1;
                label501:
                if (i == 0) {
                  break label528;
                }
              }
              label528:
              for (i = localEmailSecurityConfig.override_config.port;; i = localEmailProtocolConfig.port)
              {
                j = i;
                i = k;
                break;
                i = 0;
                break label501;
              }
            }
            j = localEmailProtocolConfig.port;
            i = k;
          }
        }
        int m = k;
        int i = j;
        if (j == 0)
        {
          m = k;
          i = j;
          if (k == 0)
          {
            i = localEmailProtocolConfig.port;
            m = localEmailProtocolConfig.port;
          }
        }
        switch (localEmailProtocolConfig.type)
        {
        default: 
          break;
        case 1: 
        case 6: 
          paramMailServiceProvider.setImapServer(str);
          paramMailServiceProvider.setImapName(n);
          j = m;
          if (m == 0) {
            j = 993;
          }
          paramMailServiceProvider.setImapSSLPort(j);
          j = i;
          if (i == 0) {
            j = 143;
          }
          paramMailServiceProvider.setImapPort(j);
          paramMailServiceProvider.setImapUsingSSL(bool);
          break;
        case 2: 
          paramMailServiceProvider.setPop3Server(str);
          paramMailServiceProvider.setPop3Name(n);
          j = m;
          if (m == 0) {
            j = 995;
          }
          paramMailServiceProvider.setPop3SSLPort(j);
          j = i;
          if (i == 0) {
            j = 110;
          }
          paramMailServiceProvider.setPop3Port(j);
          paramMailServiceProvider.setPop3UsingSSL(bool);
          break;
        case 3: 
          paramMailServiceProvider.setActiveSyncDomain(localEmailProtocolConfig.exchange_domain);
          paramMailServiceProvider.setActiveSyncName(n);
          paramMailServiceProvider.setActiveSyncServer(str);
          paramMailServiceProvider.setActiveSyncUsingSSL(bool);
          break;
        case 4: 
          paramMailServiceProvider.setExchangeDomain(localEmailProtocolConfig.exchange_domain);
          paramMailServiceProvider.setExchangeName(n);
          paramMailServiceProvider.setExchangeServer(str);
          paramMailServiceProvider.setExchangeUsingSSL(bool);
          break;
        case 5: 
          paramMailServiceProvider.setSmtpServer(str);
          paramMailServiceProvider.setSmtpName(n);
          j = m;
          if (m == 0) {
            j = 465;
          }
          paramMailServiceProvider.setSmtpSSLPort(j);
          j = i;
          if (i == 0) {
            j = 25;
          }
          paramMailServiceProvider.setSmtpPort(j);
          paramMailServiceProvider.setSmtpUsingSSL(bool);
        }
      }
    }
    paramMailServiceProvider.setCloudEditEnable(paramDomainConfig.cloud_support_switch_editable);
    paramMailServiceProvider.setUseCloudSupport(paramDomainConfig.use_cloud_support);
    return true;
  }
  
  private String[] convertHashMapToProvider(MailServiceProvider paramMailServiceProvider, HashMap<String, Object> paramHashMap)
  {
    Object localObject1 = (String)paramHashMap.get("Provider Name");
    if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
      paramMailServiceProvider.setProviderIcon((String)localObject1);
    }
    paramMailServiceProvider.setProviderName((String)localObject1);
    localObject1 = (String)paramHashMap.get("Provider Icon");
    if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
      paramMailServiceProvider.setProviderIcon((String)localObject1);
    }
    localObject1 = (String)paramHashMap.get("Provider Avatar");
    if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
      paramMailServiceProvider.setProviderAvatar((String)localObject1);
    }
    Object localObject2;
    if ((paramHashMap.get("Provider Company") instanceof String))
    {
      localObject1 = (String)paramHashMap.get("Provider Company");
      if ((localObject1 != null) && (!((String)localObject1).equals("")))
      {
        localObject2 = new ArrayList();
        ((List)localObject2).add(localObject1);
        paramMailServiceProvider.setProviderCompanyEntrys((List)localObject2);
      }
    }
    for (;;)
    {
      localObject2 = (ArrayList)paramHashMap.get("Mail Address Suffix");
      if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0)) {
        break label1866;
      }
      int j = ((ArrayList)localObject2).size();
      localObject1 = new String[j];
      int i = 0;
      while (i < j)
      {
        localObject1[i] = ((String)((ArrayList)localObject2).get(i));
        i += 1;
      }
      localObject2 = (ArrayList)paramHashMap.get("Provider Company");
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject1 = new ArrayList();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((List)localObject1).add((String)((Iterator)localObject2).next());
        }
        paramMailServiceProvider.setProviderCompanyEntrys((List)localObject1);
      }
    }
    paramMailServiceProvider.setMailAddressSuffix((String[])localObject1);
    for (;;)
    {
      localObject2 = (String)paramHashMap.get("Default Recv Protocol");
      if ((localObject2 != null) && (!((String)localObject2).equals("")))
      {
        paramMailServiceProvider.setDefaultRecvProtocol((String)localObject2);
        localObject2 = (String)paramHashMap.get("Exchange Server");
        if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
          paramMailServiceProvider.setExchangeServer((String)localObject2);
        }
        localObject2 = (String)paramHashMap.get("Exchange Name");
        if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
          paramMailServiceProvider.setExchangeName(Integer.parseInt((String)localObject2));
        }
        if (!(paramHashMap.get("Exchange SSL") instanceof String)) {
          break label1491;
        }
        localObject2 = (String)paramHashMap.get("Exchange SSL");
        if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
          paramMailServiceProvider.setExchangeUsingSSL(((String)localObject2).equals("1"));
        }
        localObject2 = (String)paramHashMap.get("ActiveSync Server");
        if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
          paramMailServiceProvider.setActiveSyncServer((String)localObject2);
        }
        localObject2 = (String)paramHashMap.get("ActiveSync Name");
        if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
          paramMailServiceProvider.setActiveSyncName(Integer.parseInt((String)localObject2));
        }
        if (!(paramHashMap.get("ActiveSync SSL") instanceof String)) {
          break label1533;
        }
        localObject2 = (String)paramHashMap.get("ActiveSync SSL");
        if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
          paramMailServiceProvider.setActiveSyncUsingSSL(((String)localObject2).equals("1"));
        }
        label607:
        localObject2 = (String)paramHashMap.get("IMAP Server");
        if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
          paramMailServiceProvider.setImapServer((String)localObject2);
        }
        localObject2 = (String)paramHashMap.get("IMAP Name");
        if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
          paramMailServiceProvider.setImapName(Integer.parseInt((String)localObject2));
        }
        localObject2 = (HashMap)paramHashMap.get("IMAP Port");
        String str;
        if (localObject2 != null)
        {
          str = (String)((HashMap)localObject2).get("Port");
          if ((str != null) && (!str.equals(""))) {
            paramMailServiceProvider.setImapPort(Integer.parseInt(str));
          }
          localObject2 = (String)((HashMap)localObject2).get("SSL Port");
          if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
            paramMailServiceProvider.setImapSSLPort(Integer.parseInt((String)localObject2));
          }
        }
        if (!(paramHashMap.get("IMAP SSL") instanceof String)) {
          break label1575;
        }
        localObject2 = (String)paramHashMap.get("IMAP SSL");
        if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
          paramMailServiceProvider.setImapUsingSSL(((String)localObject2).equals("1"));
        }
        label823:
        localObject2 = (String)paramHashMap.get("POP3 Server");
        if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
          paramMailServiceProvider.setPop3Server((String)localObject2);
        }
        localObject2 = (String)paramHashMap.get("POP3 Name");
        if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
          paramMailServiceProvider.setPop3Name(Integer.parseInt((String)localObject2));
        }
        localObject2 = (HashMap)paramHashMap.get("POP3 Port");
        if (localObject2 != null)
        {
          str = (String)((HashMap)localObject2).get("Port");
          if ((str != null) && (!str.equals(""))) {
            paramMailServiceProvider.setPop3Port(Integer.parseInt(str));
          }
          localObject2 = (String)((HashMap)localObject2).get("SSL Port");
          if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
            paramMailServiceProvider.setPop3SSLPort(Integer.parseInt((String)localObject2));
          }
        }
        if (!(paramHashMap.get("POP3 SSL") instanceof String)) {
          break label1617;
        }
        localObject2 = (String)paramHashMap.get("POP3 SSL");
        if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
          paramMailServiceProvider.setPop3UsingSSL(((String)localObject2).equals("1"));
        }
        label1039:
        localObject2 = (String)paramHashMap.get("SMTP Server");
        if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
          paramMailServiceProvider.setSmtpServer((String)localObject2);
        }
        localObject2 = (String)paramHashMap.get("SMTP Name");
        if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
          paramMailServiceProvider.setSmtpName(Integer.parseInt((String)localObject2));
        }
        localObject2 = (HashMap)paramHashMap.get("SMTP Port");
        if (localObject2 != null)
        {
          str = (String)((HashMap)localObject2).get("Port");
          if ((str != null) && (!str.equals(""))) {
            paramMailServiceProvider.setSmtpPort(Integer.parseInt(str));
          }
          localObject2 = (String)((HashMap)localObject2).get("SSL Port");
          if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
            paramMailServiceProvider.setSmtpSSLPort(Integer.parseInt((String)localObject2));
          }
        }
        if (!(paramHashMap.get("SMTP SSL") instanceof String)) {
          break label1659;
        }
        localObject2 = (String)paramHashMap.get("SMTP SSL");
        if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
          paramMailServiceProvider.setSmtpUsingSSL(((String)localObject2).equals("1"));
        }
        label1255:
        if (!(paramHashMap.get("SSL Connection") instanceof String)) {
          break label1701;
        }
        localObject2 = (String)paramHashMap.get("SSL Connection");
        if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
          paramMailServiceProvider.setSslConnection(((String)localObject2).equals("1"));
        }
        label1307:
        if (!(paramHashMap.get("Need Authentication") instanceof String)) {
          break label1743;
        }
        localObject2 = (String)paramHashMap.get("Need Authentication");
        if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
          paramMailServiceProvider.setNeedAuthentication(((String)localObject2).equals("1"));
        }
        label1359:
        if (!(paramHashMap.get("Cloud Enable") instanceof String)) {
          break label1785;
        }
        localObject2 = (String)paramHashMap.get("Cloud Enable");
        if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
          paramMailServiceProvider.setCloudEditEnable(((String)localObject2).equals("1"));
        }
        label1411:
        if (!(paramHashMap.get("Use Cloud Support") instanceof String)) {
          break label1827;
        }
        paramHashMap = (String)paramHashMap.get("Use Cloud Support");
        if ((paramHashMap != null) && (!paramHashMap.equals(""))) {
          paramMailServiceProvider.setUseCloudSupport(paramHashMap.equals("1"));
        }
      }
      label1491:
      label1533:
      do
      {
        do
        {
          return localObject1;
          QMLog.log(6, "MailServiceManager", "convertHashMapToProvider err. no default recv protocol:" + paramHashMap);
          return null;
          if (!(paramHashMap.get("Exchange SSL") instanceof Boolean)) {
            break;
          }
          localObject2 = (Boolean)paramHashMap.get("Exchange SSL");
          if (localObject2 == null) {
            break;
          }
          paramMailServiceProvider.setExchangeUsingSSL(((Boolean)localObject2).booleanValue());
          break;
          if (!(paramHashMap.get("ActiveSync SSL") instanceof Boolean)) {
            break label607;
          }
          localObject2 = (Boolean)paramHashMap.get("ActiveSync SSL");
          if (localObject2 == null) {
            break label607;
          }
          paramMailServiceProvider.setActiveSyncUsingSSL(((Boolean)localObject2).booleanValue());
          break label607;
          if (!(paramHashMap.get("IMAP SSL") instanceof Boolean)) {
            break label823;
          }
          localObject2 = (Boolean)paramHashMap.get("IMAP SSL");
          if (localObject2 == null) {
            break label823;
          }
          paramMailServiceProvider.setImapUsingSSL(((Boolean)localObject2).booleanValue());
          break label823;
          if (!(paramHashMap.get("POP3 SSL") instanceof Boolean)) {
            break label1039;
          }
          localObject2 = (Boolean)paramHashMap.get("POP3 SSL");
          if (localObject2 == null) {
            break label1039;
          }
          paramMailServiceProvider.setPop3UsingSSL(((Boolean)localObject2).booleanValue());
          break label1039;
          if (!(paramHashMap.get("SMTP SSL") instanceof Boolean)) {
            break label1255;
          }
          localObject2 = (Boolean)paramHashMap.get("SMTP SSL");
          if (localObject2 == null) {
            break label1255;
          }
          paramMailServiceProvider.setSmtpUsingSSL(((Boolean)localObject2).booleanValue());
          break label1255;
          if (!(paramHashMap.get("SSL Connection") instanceof Boolean)) {
            break label1307;
          }
          localObject2 = (Boolean)paramHashMap.get("SSL Connection");
          if (localObject2 == null) {
            break label1307;
          }
          paramMailServiceProvider.setSslConnection(((Boolean)localObject2).booleanValue());
          break label1307;
          if (!(paramHashMap.get("Need Authentication") instanceof Boolean)) {
            break label1359;
          }
          localObject2 = (Boolean)paramHashMap.get("Need Authentication");
          if (localObject2 == null) {
            break label1359;
          }
          paramMailServiceProvider.setNeedAuthentication(((Boolean)localObject2).booleanValue());
          break label1359;
          if (!(paramHashMap.get("Cloud Enable") instanceof Boolean)) {
            break label1411;
          }
          localObject2 = (Boolean)paramHashMap.get("Cloud Enable");
          if (localObject2 == null) {
            break label1411;
          }
          paramMailServiceProvider.setCloudEditEnable(((Boolean)localObject2).booleanValue());
          break label1411;
        } while (!(paramHashMap.get("Use Cloud Support") instanceof Boolean));
        paramHashMap = (Boolean)paramHashMap.get("Use Cloud Support");
      } while (paramHashMap == null);
      label1575:
      label1617:
      label1659:
      paramMailServiceProvider.setUseCloudSupport(paramHashMap.booleanValue());
      label1701:
      label1743:
      label1785:
      return localObject1;
      label1827:
      label1866:
      localObject1 = null;
    }
  }
  
  public static MailServiceManager getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new MailServiceManager();
      }
      return instance;
    }
    finally {}
  }
  
  private ArrayList<MailServiceProvider> getMailServiceProvider(String paramString)
  {
    return this.sqliteHelper.getMailServiceProvider(this.sqliteHelper.getReadableDatabase(), paramString);
  }
  
  private ArrayList<MailServiceProvider> getProvidersByDomain(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = getMailServiceProvider(paramString);
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      MailServiceProvider localMailServiceProvider = (MailServiceProvider)localIterator.next();
      if ((localMailServiceProvider != null) && (!checkMailServiceProvider(localMailServiceProvider))) {
        autoFillMailServiceProvider(paramString, localMailServiceProvider);
      }
    }
    return localArrayList;
  }
  
  public static void initLocalDomainConfig()
  {
    Threads.runInBackground(new MailServiceManager.2(), 1000L);
  }
  
  /* Error */
  private String insertLocalMailProviderConfig()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: invokestatic 57	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   7: invokevirtual 542	com/tencent/qqmail/QMApplicationContext:getAssets	()Landroid/content/res/AssetManager;
    //   10: ldc_w 544
    //   13: invokevirtual 550	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   16: astore_3
    //   17: aload_3
    //   18: astore_1
    //   19: aload_3
    //   20: astore_2
    //   21: aload_3
    //   22: invokevirtual 555	java/io/InputStream:available	()I
    //   25: newarray byte
    //   27: astore 4
    //   29: aload_3
    //   30: astore_1
    //   31: aload_3
    //   32: astore_2
    //   33: aload_3
    //   34: aload 4
    //   36: invokevirtual 559	java/io/InputStream:read	([B)I
    //   39: pop
    //   40: aload_3
    //   41: astore_1
    //   42: aload_3
    //   43: astore_2
    //   44: iconst_4
    //   45: ldc 32
    //   47: ldc_w 561
    //   50: invokestatic 94	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   53: aload_3
    //   54: astore_1
    //   55: aload_3
    //   56: astore_2
    //   57: new 172	java/lang/String
    //   60: dup
    //   61: aload 4
    //   63: invokespecial 564	java/lang/String:<init>	([B)V
    //   66: astore 4
    //   68: aload_3
    //   69: ifnull +7 -> 76
    //   72: aload_3
    //   73: invokevirtual 567	java/io/InputStream:close	()V
    //   76: aload 4
    //   78: areturn
    //   79: astore_3
    //   80: aload_1
    //   81: astore_2
    //   82: bipush 6
    //   84: ldc 32
    //   86: new 74	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 569
    //   96: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_3
    //   100: invokevirtual 570	java/io/IOException:toString	()Ljava/lang/String;
    //   103: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 94	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   112: aload_1
    //   113: ifnull +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 567	java/io/InputStream:close	()V
    //   120: ldc_w 277
    //   123: areturn
    //   124: astore_1
    //   125: aload_2
    //   126: ifnull +7 -> 133
    //   129: aload_2
    //   130: invokevirtual 567	java/io/InputStream:close	()V
    //   133: aload_1
    //   134: athrow
    //   135: astore_1
    //   136: aload 4
    //   138: areturn
    //   139: astore_1
    //   140: goto -20 -> 120
    //   143: astore_2
    //   144: goto -11 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	MailServiceManager
    //   3	114	1	localObject1	Object
    //   124	10	1	localObject2	Object
    //   135	1	1	localException1	Exception
    //   139	1	1	localException2	Exception
    //   1	129	2	localObject3	Object
    //   143	1	2	localException3	Exception
    //   16	57	3	localInputStream	java.io.InputStream
    //   79	21	3	localIOException	java.io.IOException
    //   27	110	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   4	17	79	java/io/IOException
    //   21	29	79	java/io/IOException
    //   33	40	79	java/io/IOException
    //   44	53	79	java/io/IOException
    //   57	68	79	java/io/IOException
    //   4	17	124	finally
    //   21	29	124	finally
    //   33	40	124	finally
    //   44	53	124	finally
    //   57	68	124	finally
    //   82	112	124	finally
    //   72	76	135	java/lang/Exception
    //   116	120	139	java/lang/Exception
    //   129	133	143	java/lang/Exception
  }
  
  private void resetMailServicePrivider(MailServiceProvider paramMailServiceProvider)
  {
    paramMailServiceProvider.setDefaultRecvProtocol(null);
    paramMailServiceProvider.setNeedAuthentication(false);
    paramMailServiceProvider.setProviderName(null);
    paramMailServiceProvider.setProviderAvatar(null);
    paramMailServiceProvider.setProviderIcon(null);
    paramMailServiceProvider.setMailAddressSuffix(null);
    paramMailServiceProvider.setProviderCompanyEntrys(null);
    paramMailServiceProvider.setUseCloudSupport(false);
    paramMailServiceProvider.setCloudEditEnable(false);
    paramMailServiceProvider.setPop3Server(null);
    paramMailServiceProvider.setPop3Port(0);
    paramMailServiceProvider.setPop3SSLPort(0);
    paramMailServiceProvider.setPop3UsingSSL(false);
    paramMailServiceProvider.setPop3Name(0);
    paramMailServiceProvider.setImapServer(null);
    paramMailServiceProvider.setImapPort(0);
    paramMailServiceProvider.setImapSSLPort(0);
    paramMailServiceProvider.setImapUsingSSL(false);
    paramMailServiceProvider.setImapName(0);
    paramMailServiceProvider.setSmtpServer(null);
    paramMailServiceProvider.setSmtpPort(0);
    paramMailServiceProvider.setSmtpSSLPort(0);
    paramMailServiceProvider.setSmtpUsingSSL(false);
    paramMailServiceProvider.setSmtpName(0);
    paramMailServiceProvider.setActiveSyncServer(null);
    paramMailServiceProvider.setActiveSyncDomain(null);
    paramMailServiceProvider.setActiveSyncUsingSSL(false);
    paramMailServiceProvider.setActiveSyncName(0);
    paramMailServiceProvider.setExchangeServer(null);
    paramMailServiceProvider.setExchangeDomain(null);
    paramMailServiceProvider.setExchangeUsingSSL(false);
    paramMailServiceProvider.setExchangeName(0);
  }
  
  private PlistHandler saxParseXMLData(String paramString)
  {
    SAXParserFactory localSAXParserFactory = SAXParserFactory.newInstance();
    PlistHandler localPlistHandler = new PlistHandler();
    try
    {
      localSAXParserFactory.newSAXParser().parse(new InputSource(new StringReader(paramString)), localPlistHandler);
      return localPlistHandler;
    }
    catch (Exception paramString)
    {
      QMLog.log(6, "MailServiceManager", "SAXParserFactory parse xml err : " + paramString.toString());
    }
    return localPlistHandler;
  }
  
  public void autoFillMailServiceProvider(String paramString, MailServiceProvider paramMailServiceProvider)
  {
    if (paramMailServiceProvider == null) {}
    do
    {
      do
      {
        return;
      } while (("ActiveSync".equals(paramMailServiceProvider.getDefaultRecvProtocol())) || ("Exchange".equals(paramMailServiceProvider.getDefaultRecvProtocol())));
      if (!checkSmtpConfig(paramMailServiceProvider))
      {
        paramMailServiceProvider.setSmtpServer("stmp." + paramString);
        paramMailServiceProvider.setSmtpPort(Integer.parseInt(QMApplicationContext.sharedInstance().getString(2131720368)));
        paramMailServiceProvider.setSmtpSSLPort(Integer.parseInt(QMApplicationContext.sharedInstance().getString(2131720370)));
      }
      if (("IMAP".equals(paramMailServiceProvider.getDefaultRecvProtocol())) && (!checkImapConfig(paramMailServiceProvider)))
      {
        paramMailServiceProvider.setImapServer("imap." + paramString);
        paramMailServiceProvider.setImapPort(Integer.parseInt(QMApplicationContext.sharedInstance().getString(2131694785)));
        paramMailServiceProvider.setImapSSLPort(Integer.parseInt(QMApplicationContext.sharedInstance().getString(2131694786)));
      }
    } while ((!"POP3".equals(paramMailServiceProvider.getDefaultRecvProtocol())) || (checkPopConfig(paramMailServiceProvider)));
    paramMailServiceProvider.setPop3Server("pop3." + paramString);
    paramMailServiceProvider.setPop3Port(Integer.parseInt(QMApplicationContext.sharedInstance().getString(2131697035)));
    paramMailServiceProvider.setPop3SSLPort(Integer.parseInt(QMApplicationContext.sharedInstance().getString(2131697036)));
  }
  
  public final void bindQueryProviderListener(QueryProviderWatcher paramQueryProviderWatcher, boolean paramBoolean)
  {
    Watchers.bind(paramQueryProviderWatcher, paramBoolean);
  }
  
  public MailServiceProvider fillProviderWithProfile(Profile paramProfile)
  {
    MailServiceProvider localMailServiceProvider = new MailServiceProvider();
    if (paramProfile.protocolType == 0)
    {
      localMailServiceProvider.setDefaultRecvProtocol("POP3");
      localMailServiceProvider.setPop3UsingSSL(paramProfile.pop3UsingSSL);
      localMailServiceProvider.setPop3Server(paramProfile.pop3Server);
      localMailServiceProvider.setPop3Port(paramProfile.pop3Port);
      localMailServiceProvider.setPop3SSLPort(paramProfile.pop3SSLPort);
      localMailServiceProvider.setSmtpUsingSSL(paramProfile.smtpUsingSSL);
      localMailServiceProvider.setSmtpPort(paramProfile.smtpPort);
      localMailServiceProvider.setSmtpSSLPort(paramProfile.smtpSSLPort);
      localMailServiceProvider.setSmtpServer(paramProfile.smtpServer);
    }
    do
    {
      return localMailServiceProvider;
      if (paramProfile.protocolType == 1)
      {
        localMailServiceProvider.setDefaultRecvProtocol("IMAP");
        localMailServiceProvider.setImapUsingSSL(paramProfile.imapUsingSSL);
        localMailServiceProvider.setImapServer(paramProfile.imapServer);
        localMailServiceProvider.setImapPort(paramProfile.imapPort);
        localMailServiceProvider.setImapSSLPort(paramProfile.imapSSLPort);
        localMailServiceProvider.setSmtpUsingSSL(paramProfile.smtpUsingSSL);
        localMailServiceProvider.setSmtpPort(paramProfile.smtpPort);
        localMailServiceProvider.setSmtpSSLPort(paramProfile.smtpSSLPort);
        localMailServiceProvider.setSmtpServer(paramProfile.smtpServer);
        return localMailServiceProvider;
      }
      if (paramProfile.protocolType == 3)
      {
        localMailServiceProvider.setDefaultRecvProtocol("Exchange");
        localMailServiceProvider.setExchangeUsingSSL(paramProfile.exchangeUsingSSL);
        localMailServiceProvider.setExchangeServer(paramProfile.exchangeServer);
        localMailServiceProvider.setExchangeDomain(paramProfile.exchangeDomain);
        return localMailServiceProvider;
      }
    } while (paramProfile.protocolType != 4);
    localMailServiceProvider.setDefaultRecvProtocol("Exchange");
    localMailServiceProvider.setExchangeDomain(paramProfile.activeSyncDomain);
    localMailServiceProvider.setExchangeServer(paramProfile.activeSyncServer);
    localMailServiceProvider.setExchangeUsingSSL(paramProfile.activeSyncUsingSSL);
    return localMailServiceProvider;
  }
  
  public MailServiceProvider getAutoFillMailProvider(String paramString)
  {
    return (MailServiceProvider)this.autoFillProviderMap.get(paramString);
  }
  
  public MailServiceProvider getDefaultProvider(String paramString)
  {
    if (!EmailDomainDefine.hasLocalProvider(paramString)) {
      return null;
    }
    MailServiceProvider localMailServiceProvider = new MailServiceProvider();
    localMailServiceProvider.setDefaultRecvProtocol("IMAP");
    localMailServiceProvider.setImapServer("imap." + paramString);
    localMailServiceProvider.setImapUsingSSL(true);
    localMailServiceProvider.setImapPort(143);
    localMailServiceProvider.setImapSSLPort(993);
    localMailServiceProvider.setSmtpServer("smtp." + paramString);
    localMailServiceProvider.setSmtpUsingSSL(true);
    localMailServiceProvider.setSmtpPort(25);
    localMailServiceProvider.setSmtpSSLPort(465);
    localMailServiceProvider.setPop3Server("pop." + paramString);
    localMailServiceProvider.setPop3Port(110);
    localMailServiceProvider.setPop3SSLPort(995);
    localMailServiceProvider.setPop3UsingSSL(true);
    localMailServiceProvider.setExchangeServer("mail." + paramString);
    localMailServiceProvider.setExchangeUsingSSL(true);
    if (EmailDomainDefine.isWYMail(paramString)) {
      localMailServiceProvider.setActiveSyncServer("i.163.com");
    }
    for (;;)
    {
      localMailServiceProvider.setActiveSyncUsingSSL(true);
      return localMailServiceProvider;
      if (EmailDomainDefine.isOutlookMail(paramString))
      {
        localMailServiceProvider.setActiveSyncServer("eas.outlook.com");
        localMailServiceProvider.setImapServer("imap-mail." + paramString);
        localMailServiceProvider.setSmtpServer("smtp-mail." + paramString);
        localMailServiceProvider.setPop3Server("pop-mail." + paramString);
        localMailServiceProvider.setSmtpSSLPort(587);
      }
      else
      {
        localMailServiceProvider.setActiveSyncServer("mail." + paramString);
      }
    }
  }
  
  public MailServiceProvider getProviderByDomain(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = getProvidersByDomain(paramString);
    if (localArrayList.size() > 0) {
      return (MailServiceProvider)localArrayList.get(0);
    }
    QMLog.log(6, "MailServiceManager", "getProviderByDomain error " + paramString + " providerArrayList:" + localArrayList.size());
    return null;
  }
  
  public MailServiceProvider getProviderFromWeb(long paramLong, String paramString1, String paramString2)
  {
    return getProviderFromWeb(paramLong, paramString1, paramString2, null);
  }
  
  public MailServiceProvider getProviderFromWeb(long paramLong, String paramString1, String paramString2, AccountType paramAccountType)
  {
    MailServiceProvider localMailServiceProvider = new MailServiceProvider();
    QMPrivateProtocolManager.sharedInstance().queryDomainConfigFromWeb(paramString2, new MailServiceManager.3(this, paramLong, paramString1, paramAccountType));
    return localMailServiceProvider;
  }
  
  public MailServiceProvider getSecondProviderByDomain(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return null;
      paramString = getProvidersByDomain(paramString);
    } while (paramString.size() <= 1);
    return (MailServiceProvider)paramString.get(1);
  }
  
  public boolean isEmptyReceive(MailServiceProvider paramMailServiceProvider)
  {
    if ((paramMailServiceProvider == null) || (StringExtention.isNullOrEmpty(paramMailServiceProvider.getDefaultRecvProtocol()))) {}
    String str;
    do
    {
      return false;
      str = paramMailServiceProvider.getDefaultRecvProtocol();
    } while (((!"IMAP".equals(str)) || (StringExtention.isNullOrEmpty(paramMailServiceProvider.getImapServer()))) && ((!"POP3".equals(str)) || (StringExtention.isNullOrEmpty(paramMailServiceProvider.getPop3Server()))) && ((!"ActiveSync".equals(str)) || (StringExtention.isNullOrEmpty(paramMailServiceProvider.getExchangeServer()))));
    return true;
  }
  
  public boolean isLocalDomain(String paramString)
  {
    if (!StringExtention.isNullOrEmpty(paramString)) {
      return this.sqliteHelper.isLocalDomain(this.sqliteHelper.getReadableDatabase(), paramString);
    }
    return false;
  }
  
  public boolean isQQCompany(MailServiceProvider paramMailServiceProvider)
  {
    paramMailServiceProvider = paramMailServiceProvider.getProviderCompanyEntrys();
    return (paramMailServiceProvider != null) && ((paramMailServiceProvider.contains("1")) || (paramMailServiceProvider.contains("2")));
  }
  
  public boolean isSameCompany(MailServiceProvider paramMailServiceProvider1, MailServiceProvider paramMailServiceProvider2)
  {
    String str;
    Iterator localIterator;
    do
    {
      paramMailServiceProvider1 = paramMailServiceProvider1.getProviderCompanyEntrys().iterator();
      while (!localIterator.hasNext())
      {
        if (!paramMailServiceProvider1.hasNext()) {
          break;
        }
        str = (String)paramMailServiceProvider1.next();
        localIterator = paramMailServiceProvider2.getProviderCompanyEntrys().iterator();
      }
    } while (!str.equals((String)localIterator.next()));
    return true;
    return false;
  }
  
  public boolean isSameMailServiceProvider(MailServiceProvider paramMailServiceProvider1, MailServiceProvider paramMailServiceProvider2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramMailServiceProvider1.getDefaultRecvProtocol() != null) && (paramMailServiceProvider2.getDefaultRecvProtocol() != null) && (!paramMailServiceProvider1.getDefaultRecvProtocol().equalsIgnoreCase(paramMailServiceProvider2.getDefaultRecvProtocol()))) {
      bool1 = false;
    }
    label91:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return bool1;
                  if (!"ActiveSync".equals(paramMailServiceProvider1.getDefaultRecvProtocol())) {
                    break label91;
                  }
                  if ((paramMailServiceProvider1.getActiveSyncServer() == null) || (paramMailServiceProvider2.getActiveSyncServer() == null) || (!paramMailServiceProvider1.getActiveSyncServer().equals(paramMailServiceProvider2.getActiveSyncServer()))) {
                    break;
                  }
                  bool1 = bool2;
                } while (paramMailServiceProvider1.isActiveSyncUseSSL() == paramMailServiceProvider2.isActiveSyncUseSSL());
                return false;
                if (!"Exchange".equals(paramMailServiceProvider1.getDefaultRecvProtocol())) {
                  break label147;
                }
                if ((paramMailServiceProvider1.getExchangeServer() == null) || (paramMailServiceProvider2.getExchangeServer() == null) || (!paramMailServiceProvider1.getExchangeServer().equals(paramMailServiceProvider2.getExchangeServer()))) {
                  break;
                }
                bool1 = bool2;
              } while (paramMailServiceProvider1.isExchangeUsingSSL() == paramMailServiceProvider2.isExchangeUsingSSL());
              return false;
              if (paramMailServiceProvider1.getSmtpServer() != null) {
                break;
              }
              bool1 = bool2;
            } while (paramMailServiceProvider2.getSmtpServer() == null);
            if ((paramMailServiceProvider1.getSmtpServer() == null) || (paramMailServiceProvider2.getSmtpServer() == null) || (!paramMailServiceProvider1.getSmtpServer().equals(paramMailServiceProvider2.getSmtpServer())) || (paramMailServiceProvider1.isSmtpUsingSSL() != paramMailServiceProvider2.isSmtpUsingSSL()) || (((!paramMailServiceProvider1.isSmtpUsingSSL()) || (paramMailServiceProvider1.getSmtpSSLPort() != paramMailServiceProvider2.getSmtpSSLPort())) && ((paramMailServiceProvider1.isSmtpUsingSSL()) || (paramMailServiceProvider1.getSmtpPort() != paramMailServiceProvider2.getSmtpPort())))) {
              break label429;
            }
            if (!"IMAP".equals(paramMailServiceProvider1.getDefaultRecvProtocol())) {
              break label334;
            }
            if ((paramMailServiceProvider1.getImapServer() == null) || (paramMailServiceProvider2.getImapServer() == null) || (!paramMailServiceProvider1.getImapServer().equals(paramMailServiceProvider2.getImapServer())) || (paramMailServiceProvider1.isImapUsingSSL() != paramMailServiceProvider2.isImapUsingSSL())) {
              break label332;
            }
            if (!paramMailServiceProvider1.isImapUsingSSL()) {
              break;
            }
            bool1 = bool2;
          } while (paramMailServiceProvider1.getImapSSLPort() == paramMailServiceProvider2.getImapSSLPort());
          if (paramMailServiceProvider1.isImapUsingSSL()) {
            break;
          }
          bool1 = bool2;
        } while (paramMailServiceProvider1.getImapPort() == paramMailServiceProvider2.getImapPort());
        return false;
        if (!"POP3".equals(paramMailServiceProvider1.getDefaultRecvProtocol())) {
          break label429;
        }
        if ((paramMailServiceProvider1.getPop3Server() == null) || (paramMailServiceProvider2.getPop3Server() == null) || (!paramMailServiceProvider1.getPop3Server().equals(paramMailServiceProvider2.getPop3Server())) || (paramMailServiceProvider1.isPop3UsingSSL() != paramMailServiceProvider2.isPop3UsingSSL())) {
          break label427;
        }
        if (!paramMailServiceProvider1.isPop3UsingSSL()) {
          break;
        }
        bool1 = bool2;
      } while (paramMailServiceProvider1.getPop3SSLPort() == paramMailServiceProvider2.getPop3SSLPort());
      if (paramMailServiceProvider1.isPop3UsingSSL()) {
        break;
      }
      bool1 = bool2;
    } while (paramMailServiceProvider1.getPop3Port() == paramMailServiceProvider2.getPop3Port());
    label147:
    label332:
    label334:
    return false;
    label427:
    label429:
    return false;
  }
  
  public MailServiceProvider parseDomainConfig(CloudProtocolResult paramCloudProtocolResult)
  {
    MailServiceProvider localMailServiceProvider = new MailServiceProvider();
    convertDomainCfgToProvider(localMailServiceProvider, paramCloudProtocolResult.query_domain_rsp_.config);
    return localMailServiceProvider;
  }
  
  public void parseDomainConfigList(DomainConfig[] paramArrayOfDomainConfig)
  {
    QMLog.log(4, "MailServiceManager", "parseDomainConfigList size :" + paramArrayOfDomainConfig.length);
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int k = paramArrayOfDomainConfig.length;
    int i = 0;
    while (i < k)
    {
      Object localObject2 = paramArrayOfDomainConfig[i];
      MailServiceProvider localMailServiceProvider = new MailServiceProvider();
      if (convertDomainCfgToProvider(localMailServiceProvider, (DomainConfig)localObject2))
      {
        localObject2 = localMailServiceProvider.getMailAddressSuffix();
        int m = localObject2.length;
        int j = 0;
        while (j < m)
        {
          localArrayList2.add(localObject2[j]);
          localArrayList1.add(localMailServiceProvider);
          j += 1;
        }
      }
      i += 1;
    }
    paramArrayOfDomainConfig = this.sqliteHelper.getWritableDatabase();
    try
    {
      paramArrayOfDomainConfig.beginTransaction();
      this.sqliteHelper.insertMailServiceProvider(paramArrayOfDomainConfig, localArrayList2, localArrayList1, 0);
      paramArrayOfDomainConfig.setTransactionSuccessful();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "MailServiceManager", "insertDomainConfigArrayList " + localException.getMessage());
        paramArrayOfDomainConfig.endTransaction();
      }
    }
    finally
    {
      paramArrayOfDomainConfig.endTransaction();
    }
    QMLog.log(4, "MailServiceManager", "parseDomainConfigList spend : " + (System.currentTimeMillis() - l));
  }
  
  public void prepareLocalDomainConfig()
  {
    ArrayList localArrayList = (ArrayList)saxParseXMLData(insertLocalMailProviderConfig()).getArrayResult();
    long l = System.currentTimeMillis();
    addArrayToProviderMap(localArrayList);
    QMLog.log(4, "MailServiceManager", "prepareLocalDomainConfig spend: " + (System.currentTimeMillis() - l));
  }
  
  public void setAutoFillMailProvider(String paramString, MailServiceProvider paramMailServiceProvider)
  {
    this.autoFillProviderMap.put(paramString, paramMailServiceProvider);
  }
  
  protected void triggerQueryProviderError(long paramLong, String paramString, AccountType paramAccountType)
  {
    if (Threads.isOnMainThread())
    {
      Threads.runInBackground(new MailServiceManager.1(this, paramLong, paramString, paramAccountType));
      return;
    }
    ((QueryProviderWatcher)Watchers.of(QueryProviderWatcher.class)).onError(paramLong, paramString, paramAccountType);
  }
  
  protected void triggerQueryProviderSuccess(long paramLong, String paramString, MailServiceProvider paramMailServiceProvider)
  {
    ((QueryProviderWatcher)Watchers.of(QueryProviderWatcher.class)).onSuccess(paramLong, paramString, paramMailServiceProvider);
  }
  
  public static abstract interface QueryProviderListener
  {
    public abstract void onError(Object paramObject);
    
    public abstract void onSuccess(MailServiceProvider paramMailServiceProvider);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.MailServiceManager
 * JD-Core Version:    0.7.0.1
 */