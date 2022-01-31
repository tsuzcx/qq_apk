package com.tencent.mobileqq.troop.data;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import emr;
import ems;
import emt;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopFeedsDataManager
  extends Observable
{
  public static final int a = 5;
  public static final String a = "TroopFeedsDataManager";
  public static final int b = 1000;
  public static final String b = "http://web.qun.qq.com/cgi-bin/notice/get_data_new";
  public static final int c = 1001;
  public static final String c = "http://web.qun.qq.com/cgi-bin/announce/del_feed";
  public static final int d = 101;
  public static String d = "controlType";
  public static final int e = 102;
  public static String e = "controlInfo";
  public static final int f = 103;
  public static String f;
  public static final int g = 104;
  public static String g;
  public static final int h = 2;
  public static String h;
  public static final int i = 3;
  public static String i;
  public static int j;
  public static String j;
  public static int k;
  public static int l;
  public Handler a;
  public QQAppInterface a;
  protected TroopFeedItem a;
  protected HttpWebCgiAsyncTask.Callback a;
  public Long a;
  public List a;
  protected boolean a;
  
  static
  {
    jdField_j_of_type_Int = 1;
    f = "compress";
    k = 1;
    g = "validTime";
    h = "needFilter";
    l = 1;
    i = "filterID";
    jdField_j_of_type_JavaLangString = "src";
  }
  
  public TroopFeedsDataManager(QQAppInterface paramQQAppInterface, Long paramLong)
  {
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new emr(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new emt(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangLong = paramLong;
  }
  
  protected int a(String paramString)
  {
    int m = 0;
    if (StringUtil.b(paramString)) {
      return 0;
    }
    int n = 5381;
    while (m < paramString.length())
    {
      n += (n << 5) + paramString.charAt(m);
      m += 1;
    }
    return 0x7FFFFFFF & n;
  }
  
  public TroopFeedItem a()
  {
    List localList = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44)).a("" + this.jdField_a_of_type_JavaLangLong);
    if (localList == null) {
      return this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem;
    }
    int n = localList.size() - 1;
    label274:
    label417:
    label481:
    label486:
    label491:
    label498:
    for (;;)
    {
      TroopNotificationCache localTroopNotificationCache;
      if (n >= 0)
      {
        localTroopNotificationCache = (TroopNotificationCache)localList.get(n);
        if (localTroopNotificationCache == null) {}
      }
      else
      {
        try
        {
          TroopFeedItem localTroopFeedItem = new TroopFeedItem();
          int m;
          Object localObject;
          TroopFeedsDataManager.ProclamationXmlHandler localProclamationXmlHandler;
          if (localTroopNotificationCache.serviceID == 27)
          {
            localTroopFeedItem.tag = "公告";
            localTroopFeedItem.type = 5;
            m = 0;
            localTroopFeedItem.id = localTroopNotificationCache.feedsId;
            localTroopFeedItem.orginType = localTroopNotificationCache.feedType;
            localTroopFeedItem.feedTime = ("" + localTroopNotificationCache.time);
            localTroopFeedItem.currentUin = localTroopNotificationCache.currentUin;
            localTroopFeedItem.troopUin = ("" + localTroopNotificationCache.troopUin);
            localObject = new ByteArrayInputStream(StructMsgUtils.a(localTroopNotificationCache.xmlBytes, m));
            localProclamationXmlHandler = new TroopFeedsDataManager.ProclamationXmlHandler(this);
            SAXParserFactory.newInstance().newSAXParser().parse((InputStream)localObject, localProclamationXmlHandler);
            ((InputStream)localObject).close();
            if (localTroopNotificationCache.serviceID == 20)
            {
              localTroopFeedItem.title = localProclamationXmlHandler.a;
              localTroopFeedItem.content = "";
              localTroopFeedItem.picPath = localProclamationXmlHandler.b;
              localTroopFeedItem.linkUrl = localProclamationXmlHandler.d;
              if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem == null) || (localTroopNotificationCache.serviceID == 27)) {
                this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = localTroopFeedItem;
              }
              m = localTroopNotificationCache.serviceID;
              if (m != 27) {
                break label498;
              }
              return this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem;
            }
          }
          else
          {
            if ((localTroopNotificationCache.serviceID != 20) || (localTroopNotificationCache.ctrlStr == null)) {
              break label481;
            }
            localObject = new JSONObject(localTroopNotificationCache.ctrlStr);
            if ((!((JSONObject)localObject).has(d)) || (((JSONObject)localObject).getInt(d) != jdField_j_of_type_Int)) {
              break label491;
            }
            localObject = ((JSONObject)localObject).getJSONObject(e);
            if (((JSONObject)localObject).getInt(f) != k) {
              break label486;
            }
            m = 1;
            long l1 = Long.parseLong(((JSONObject)localObject).getString(g));
            if (MessageCache.a() > l1) {
              return null;
            }
          }
          for (;;)
          {
            localTroopFeedItem.tag = "部落精华";
            localTroopFeedItem.type = 133;
            break;
            localTroopFeedItem.title = localTroopNotificationCache.title;
            localTroopFeedItem.content = localProclamationXmlHandler.c;
            break label274;
            m = 0;
            break;
            m = 0;
            break label417;
            m = 0;
          }
          n -= 1;
        }
        catch (Exception localException) {}
      }
    }
  }
  
  protected String a(List paramList)
  {
    localJSONArray = new JSONArray();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TroopFeedItem localTroopFeedItem = (TroopFeedItem)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("fid", localTroopFeedItem.id);
        localJSONObject.put("mod_time", Long.parseLong(localTroopFeedItem.feedTime));
        localJSONArray.put(localJSONObject);
      }
      return localJSONArray.toString();
    }
    catch (JSONException paramList)
    {
      return "";
    }
    catch (NumberFormatException paramList)
    {
      return "";
    }
    catch (Exception paramList)
    {
      return "";
    }
  }
  
  /* Error */
  public List a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 118	com/tencent/mobileqq/troop/data/TroopFeedsDataManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 364	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   7: invokevirtual 370	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   10: astore_3
    //   11: aload_3
    //   12: invokevirtual 375	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   15: astore_2
    //   16: aload_2
    //   17: invokevirtual 379	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   20: aload_3
    //   21: ldc 183
    //   23: iconst_1
    //   24: ldc_w 381
    //   27: iconst_2
    //   28: anewarray 131	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: aload_0
    //   34: getfield 120	com/tencent/mobileqq/troop/data/TroopFeedsDataManager:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   37: invokestatic 385	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: aload_0
    //   44: getfield 118	com/tencent/mobileqq/troop/data/TroopFeedsDataManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   47: invokevirtual 387	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   50: aastore
    //   51: aconst_null
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: invokevirtual 390	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   58: astore_1
    //   59: aload_1
    //   60: invokeinterface 334 1 0
    //   65: astore 4
    //   67: aload 4
    //   69: invokeinterface 340 1 0
    //   74: ifeq +28 -> 102
    //   77: aload_3
    //   78: aload 4
    //   80: invokeinterface 344 1 0
    //   85: checkcast 183	com/tencent/mobileqq/data/TroopFeedItem
    //   88: invokevirtual 393	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   91: pop
    //   92: goto -25 -> 67
    //   95: astore_3
    //   96: aload_2
    //   97: invokevirtual 395	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   100: aload_1
    //   101: areturn
    //   102: aload_2
    //   103: invokevirtual 397	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   106: aload_2
    //   107: invokevirtual 395	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   110: aload_1
    //   111: areturn
    //   112: astore_1
    //   113: aload_2
    //   114: invokevirtual 395	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   117: aload_1
    //   118: athrow
    //   119: astore_1
    //   120: aconst_null
    //   121: astore_1
    //   122: goto -26 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	TroopFeedsDataManager
    //   58	53	1	localList	List
    //   112	6	1	localObject1	Object
    //   119	1	1	localException1	Exception
    //   121	1	1	localObject2	Object
    //   15	99	2	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   10	68	3	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   95	1	3	localException2	Exception
    //   65	14	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   59	67	95	java/lang/Exception
    //   67	92	95	java/lang/Exception
    //   102	106	95	java/lang/Exception
    //   16	59	112	finally
    //   59	67	112	finally
    //   67	92	112	finally
    //   102	106	112	finally
    //   16	59	119	java/lang/Exception
  }
  
  public List a(List paramList1, List paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    int m = 5;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem != null)
    {
      localObject1 = paramList2.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TroopFeedItem)((Iterator)localObject1).next();
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem != null) && (((TroopFeedItem)localObject2).id.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem.id))) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = ((TroopFeedItem)localObject2);
        }
      }
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem);
      m = 4;
    }
    paramList1 = paramList1.iterator();
    do
    {
      if (paramList1.hasNext())
      {
        localObject1 = (String)paramList1.next();
        if (m > 0) {}
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = null;
        return localArrayList;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem != null) && (((String)localObject1).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem.id)));
    Object localObject2 = paramList2.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      TroopFeedItem localTroopFeedItem = (TroopFeedItem)((Iterator)localObject2).next();
      if (((String)localObject1).equalsIgnoreCase(localTroopFeedItem.id))
      {
        localArrayList.add(localTroopFeedItem);
        m -= 1;
      }
    }
    for (;;)
    {
      break;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopFeedsDataManager", 2, "begin load feed: " + System.currentTimeMillis());
    }
    ThreadManager.a().post(new ems(this));
  }
  
  public void a(TroopNotificationCache paramTroopNotificationCache)
  {
    b(paramTroopNotificationCache);
    setChanged();
    notifyObservers(Integer.valueOf(104));
  }
  
  public void a(TroopFeedItem paramTroopFeedItem)
  {
    Object localObject2 = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str = ((TicketManager)localObject2).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("qid", "" + this.jdField_a_of_type_JavaLangLong);
    ((Bundle)localObject2).putString("fid", "" + paramTroopFeedItem.id);
    ((Bundle)localObject2).putString("ft", "" + paramTroopFeedItem.orginType);
    ((Bundle)localObject2).putString("bkn", "" + a(str));
    ((Bundle)localObject2).putString("version", "3.4.0");
    ((Bundle)localObject2).putString("platform", "android");
    ((Bundle)localObject2).putString("Cookie", "uin=o" + (String)localObject1 + ";skey=" + str);
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("BUNDLE", localObject2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    ((HashMap)localObject1).put("CONTEXT", MobileQQ.getContext());
    new HttpWebCgiAsyncTask("http://web.qun.qq.com/cgi-bin/announce/del_feed", "POST", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback, 1001, null, true).execute(new HashMap[] { localObject1 });
    this.jdField_a_of_type_JavaUtilList.remove(paramTroopFeedItem);
    setChanged();
    notifyObservers(Integer.valueOf(102));
  }
  
  public void b()
  {
    Object localObject2 = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str = ((TicketManager)localObject2).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("qid", "" + this.jdField_a_of_type_JavaLangLong);
    ((Bundle)localObject2).putString("fnum", "5");
    ((Bundle)localObject2).putString("bkn", "" + a(str));
    ((Bundle)localObject2).putString("fids", a(this.jdField_a_of_type_JavaUtilList));
    ((Bundle)localObject2).putString("ver", "3.4.0");
    ((Bundle)localObject2).putString("src", "1");
    ((Bundle)localObject2).putString("platform", "android");
    ((Bundle)localObject2).putString("Cookie", "uin=o" + (String)localObject1 + ";skey=" + str);
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("BUNDLE", localObject2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    ((HashMap)localObject1).put("CONTEXT", MobileQQ.getContext());
    new HttpWebCgiAsyncTask("http://web.qun.qq.com/cgi-bin/notice/get_data_new", "GET", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback, 1000, null, true).execute(new HashMap[] { localObject1 });
    if (QLog.isColorLevel()) {
      QLog.d("TroopFeedsDataManager", 2, "get feed from server start: " + System.currentTimeMillis());
    }
  }
  
  public void b(TroopNotificationCache paramTroopNotificationCache)
  {
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    if (paramTroopNotificationCache != null) {}
    try
    {
      TroopFeedItem localTroopFeedItem = new TroopFeedItem();
      int m;
      Object localObject;
      TroopFeedsDataManager.ProclamationXmlHandler localProclamationXmlHandler;
      if (paramTroopNotificationCache.serviceID == 27)
      {
        localTroopFeedItem.tag = "公告";
        m = i2;
        localTroopFeedItem.type = 5;
        localTroopFeedItem.id = paramTroopNotificationCache.feedsId;
        localTroopFeedItem.orginType = paramTroopNotificationCache.feedType;
        localTroopFeedItem.feedTime = ("" + paramTroopNotificationCache.time);
        localTroopFeedItem.currentUin = paramTroopNotificationCache.currentUin;
        localTroopFeedItem.troopUin = ("" + paramTroopNotificationCache.troopUin);
        localObject = new ByteArrayInputStream(StructMsgUtils.a(paramTroopNotificationCache.xmlBytes, m));
        localProclamationXmlHandler = new TroopFeedsDataManager.ProclamationXmlHandler(this);
        SAXParserFactory.newInstance().newSAXParser().parse((InputStream)localObject, localProclamationXmlHandler);
        ((InputStream)localObject).close();
        if (paramTroopNotificationCache.serviceID != 20) {
          break label352;
        }
        localTroopFeedItem.title = localProclamationXmlHandler.a;
      }
      for (localTroopFeedItem.content = "";; localTroopFeedItem.content = localProclamationXmlHandler.c)
      {
        localTroopFeedItem.picPath = localProclamationXmlHandler.b;
        localTroopFeedItem.linkUrl = localProclamationXmlHandler.d;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = localTroopFeedItem;
        return;
        m = i2;
        if (paramTroopNotificationCache.serviceID != 20) {
          break;
        }
        m = i2;
        if (paramTroopNotificationCache.ctrlStr == null) {
          break;
        }
        localObject = new JSONObject(paramTroopNotificationCache.ctrlStr);
        m = i1;
        if (((JSONObject)localObject).has(d))
        {
          m = i1;
          if (((JSONObject)localObject).getInt(d) == jdField_j_of_type_Int)
          {
            localObject = ((JSONObject)localObject).getJSONObject(e);
            m = n;
            if (((JSONObject)localObject).getInt(f) == k) {
              m = 1;
            }
            long l1 = Long.parseLong(((JSONObject)localObject).getString(g));
            if (MessageCache.a() > l1) {
              break label374;
            }
          }
        }
        localTroopFeedItem.tag = "游戏";
        break;
        label352:
        localTroopFeedItem.title = paramTroopNotificationCache.title;
      }
      label374:
      return;
    }
    catch (Exception paramTroopNotificationCache) {}
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 118	com/tencent/mobileqq/troop/data/TroopFeedsDataManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 364	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   7: invokevirtual 370	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 375	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   15: astore_1
    //   16: aload_1
    //   17: invokevirtual 379	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   20: aload_0
    //   21: getfield 92	com/tencent/mobileqq/troop/data/TroopFeedsDataManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   24: invokeinterface 334 1 0
    //   29: astore_3
    //   30: aload_3
    //   31: invokeinterface 340 1 0
    //   36: ifeq +25 -> 61
    //   39: aload_2
    //   40: aload_3
    //   41: invokeinterface 344 1 0
    //   46: checkcast 183	com/tencent/mobileqq/data/TroopFeedItem
    //   49: invokevirtual 536	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   52: goto -22 -> 30
    //   55: astore_2
    //   56: aload_1
    //   57: invokevirtual 395	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   60: return
    //   61: aload_1
    //   62: invokevirtual 397	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   65: aload_1
    //   66: invokevirtual 395	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   69: return
    //   70: astore_2
    //   71: aload_1
    //   72: invokevirtual 395	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   75: aload_2
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	TroopFeedsDataManager
    //   15	57	1	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   10	30	2	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   55	1	2	localException	Exception
    //   70	6	2	localObject	Object
    //   29	12	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   16	30	55	java/lang/Exception
    //   30	52	55	java/lang/Exception
    //   61	65	55	java/lang/Exception
    //   16	30	70	finally
    //   30	52	70	finally
    //   61	65	70	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager
 * JD-Core Version:    0.7.0.1
 */