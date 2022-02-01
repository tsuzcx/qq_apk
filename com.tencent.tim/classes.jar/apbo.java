import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Observable;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class apbo
  extends Observable
{
  public static String cnP = "controlType";
  public static String cnQ = "controlInfo";
  public static String cnR;
  public static String cnS;
  public static String cnT;
  public static String cnU = "filterID";
  public static String cnV = "src";
  public static int dTc = 1;
  public static int dTd;
  public static int dTe;
  public aprb.a a;
  protected TroopFeedItem a;
  public LinkedHashMap<String, Integer> ah = new LinkedHashMap();
  public Long aj;
  public JSONObject bR;
  public JSONObject bS;
  public int dTb;
  public QQAppInterface mApp;
  public List<TroopFeedItem> mItems = Collections.synchronizedList(new ArrayList());
  public Handler mUIHandler = new apbp(this, Looper.getMainLooper());
  
  static
  {
    cnR = "compress";
    dTd = 1;
    cnS = "validTime";
    cnT = "needFilter";
    dTe = 1;
  }
  
  public apbo(QQAppInterface paramQQAppInterface, Long paramLong)
  {
    this.jdField_a_of_type_Aprb$a = new apbq(this);
    this.mApp = paramQQAppInterface;
    this.aj = paramLong;
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, aprb.a parama)
  {
    Object localObject1 = (TicketManager)paramQQAppInterface.getManager(2);
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    Object localObject2 = ((TicketManager)localObject1).getSkey(paramQQAppInterface);
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("Cookie", "uin=o" + paramQQAppInterface + ";skey=" + (String)localObject2);
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("posid", "8020205751015455");
      ((JSONObject)localObject2).put("adposcount", 1);
      ((JSONObject)localObject2).put("count", 1);
      ((JSONObject)localObject2).put("posw", 100);
      ((JSONObject)localObject2).put("posh", 200);
      ((JSONObject)localObject2).put("uin", paramQQAppInterface);
      ((JSONObject)localObject2).put("muidtype", 1);
      ((JSONObject)localObject2).put("muid", MD5.toMD5(aqgz.getIMEI()));
      ((JSONObject)localObject2).put("carrier", aqgz.LU());
      ((JSONObject)localObject2).put("conn", jqc.getNetWorkType());
      ((JSONObject)localObject2).put("c_os", "android");
      ((JSONObject)localObject2).put("c_osver", Build.VERSION.RELEASE);
      ((JSONObject)localObject2).put("datatype", 2);
      ((JSONObject)localObject2).put("c_devicetype", 1);
      paramQQAppInterface = String.format("https://web.qun.qq.com/cgi-bin/announce/get_ad?&cnt=1&ext=%S", new Object[] { URLEncoder.encode(((JSONObject)localObject2).toString()) });
      if (paramQQAppInterface != null)
      {
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("BUNDLE", localObject1);
        ((HashMap)localObject2).put("CONTEXT", paramContext);
        new aprb(paramQQAppInterface, "GET", parama, paramInt, null, true).execute(new HashMap[] { localObject2 });
        if (QLog.isColorLevel()) {
          QLog.d("TroopFeedsDataManager", 2, "get requstTroopNotify from server start: " + System.currentTimeMillis());
        }
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("requstTroopNotifyAd", 2, "get ad exera fail, " + paramQQAppInterface);
        }
        paramQQAppInterface = null;
        continue;
        if (QLog.isColorLevel()) {
          QLog.e("requstTroopNotifyAd", 2, "get adURL ERROR empty!!!!");
        }
      }
    }
  }
  
  public String Q(List<TroopFeedItem> paramList)
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
  
  public void WA(int paramInt)
  {
    Object localObject2 = (TicketManager)this.mApp.getManager(2);
    Object localObject1 = this.mApp.getCurrentAccountUin();
    String str = ((TicketManager)localObject2).getSkey(this.mApp.getCurrentAccountUin());
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("qid", "" + this.aj);
    ((Bundle)localObject2).putString("ft", "23");
    ((Bundle)localObject2).putString("bkn", "" + apuh.eU(str));
    ((Bundle)localObject2).putString("ni", "1");
    if (paramInt == 1003) {
      ((Bundle)localObject2).putString("is_getinst", "1");
    }
    ((Bundle)localObject2).putString("n", "1");
    ((Bundle)localObject2).putString("i", "1");
    ((Bundle)localObject2).putString("s", "-1");
    ((Bundle)localObject2).putString("log_read", "1");
    ((Bundle)localObject2).putString("ver", "" + AppSetting.nT());
    ((Bundle)localObject2).putString("platform", "1");
    ((Bundle)localObject2).putString("Cookie", "uin=o" + (String)localObject1 + ";skey=" + str);
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("BUNDLE", localObject2);
    this.mApp.getApplication();
    ((HashMap)localObject1).put("CONTEXT", MobileQQ.getContext());
    new aprb("https://web.qun.qq.com/cgi-bin/announce/get_t_list", "GET", this.jdField_a_of_type_Aprb$a, paramInt, null, true).execute(new HashMap[] { localObject1 });
    if (QLog.isColorLevel()) {
      QLog.d("TroopFeedsDataManager", 2, "getRecentNoticeFromServer start: " + System.currentTimeMillis());
    }
  }
  
  public void Wz(int paramInt) {}
  
  public TroopFeedItem a()
  {
    List localList = ((TroopManager)this.mApp.getManager(52)).ak("" + this.aj);
    if (localList == null) {
      return this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem;
    }
    int j = localList.size() - 1;
    label282:
    label425:
    label492:
    label497:
    label502:
    label509:
    for (;;)
    {
      TroopNotificationCache localTroopNotificationCache;
      if (j >= 0)
      {
        localTroopNotificationCache = (TroopNotificationCache)localList.get(j);
        if (localTroopNotificationCache == null) {}
      }
      else
      {
        try
        {
          TroopFeedItem localTroopFeedItem = new TroopFeedItem();
          int i;
          Object localObject;
          apbo.a locala;
          if (localTroopNotificationCache.serviceID == 27)
          {
            localTroopFeedItem.tag = acfp.m(2131715669);
            localTroopFeedItem.type = 5;
            i = 0;
            localTroopFeedItem.id = localTroopNotificationCache.feedsId;
            localTroopFeedItem.orginType = localTroopNotificationCache.feedType;
            localTroopFeedItem.feedTime = ("" + localTroopNotificationCache.time);
            localTroopFeedItem.currentUin = localTroopNotificationCache.currentUin;
            localTroopFeedItem.troopUin = ("" + localTroopNotificationCache.troopUin);
            localObject = new ByteArrayInputStream(ansi.d(localTroopNotificationCache.xmlBytes, i));
            locala = new apbo.a();
            SAXParserFactory.newInstance().newSAXParser().parse((InputStream)localObject, locala);
            ((InputStream)localObject).close();
            if (localTroopNotificationCache.serviceID == 20)
            {
              localTroopFeedItem.title = locala.title;
              localTroopFeedItem.content = "";
              localTroopFeedItem.picPath = locala.picture;
              localTroopFeedItem.linkUrl = locala.linkUrl;
              if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem == null) || (localTroopNotificationCache.serviceID == 27)) {
                this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = localTroopFeedItem;
              }
              i = localTroopNotificationCache.serviceID;
              if (i != 27) {
                break label509;
              }
              return this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem;
            }
          }
          else
          {
            if ((localTroopNotificationCache.serviceID != 20) || (localTroopNotificationCache.ctrlStr == null)) {
              break label492;
            }
            localObject = new JSONObject(localTroopNotificationCache.ctrlStr);
            if ((!((JSONObject)localObject).has(cnP)) || (((JSONObject)localObject).getInt(cnP) != dTc)) {
              break label502;
            }
            localObject = ((JSONObject)localObject).getJSONObject(cnQ);
            if (((JSONObject)localObject).getInt(cnR) != dTd) {
              break label497;
            }
            i = 1;
            long l = Long.parseLong(((JSONObject)localObject).getString(cnS));
            if (anaz.gQ() > l) {
              return null;
            }
          }
          for (;;)
          {
            localTroopFeedItem.tag = acfp.m(2131715670);
            localTroopFeedItem.type = 133;
            break;
            localTroopFeedItem.title = localTroopNotificationCache.title;
            localTroopFeedItem.content = locala.summary;
            break label282;
            i = 0;
            break;
            i = 0;
            break label425;
            i = 0;
          }
          j -= 1;
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public void d(String paramString, Integer paramInteger)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopFeedsDataManager.troop.notification_center.auto_pull_down", 2, "setTroopNotificationCenterAutoPullDownFlag, troopUin:" + this.aj + ",feedsId:" + paramString + ",status:" + paramInteger);
      }
    } while (paramInteger.intValue() != 1);
    this.ah.put(paramString, paramInteger);
  }
  
  public void dO(int paramInt, String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      Object localObject2 = (TicketManager)this.mApp.getManager(2);
      Object localObject1 = this.mApp.getCurrentAccountUin();
      String str = ((TicketManager)localObject2).getSkey(this.mApp.getCurrentAccountUin());
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("qid", "" + this.aj);
      ((Bundle)localObject2).putString("fid", "" + paramString);
      ((Bundle)localObject2).putString("bkn", "" + apuh.eU(str));
      ((Bundle)localObject2).putString("ver", "3.4.4");
      ((Bundle)localObject2).putString("platform", "1");
      ((Bundle)localObject2).putString("Cookie", "uin=o" + (String)localObject1 + ";skey=" + str);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("BUNDLE", localObject2);
      this.mApp.getApplication();
      ((HashMap)localObject1).put("CONTEXT", MobileQQ.getContext());
      new aprb("https://web.qun.qq.com/cgi-bin/announce/get_feed", "GET", this.jdField_a_of_type_Aprb$a, paramInt, null, true).execute(new HashMap[] { localObject1 });
    } while (!QLog.isColorLevel());
    QLog.d("TroopFeedsDataManager", 2, "getNoticeFromServer start: " + System.currentTimeMillis() + ", feedId: " + paramString);
  }
  
  public void dYE()
  {
    this.mUIHandler.sendEmptyMessage(5);
  }
  
  public void dYF()
  {
    this.mUIHandler.sendEmptyMessage(6);
  }
  
  public void destroy()
  {
    if (this.mUIHandler != null) {
      this.mUIHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public List<TroopFeedItem> m(List<String> paramList, List<TroopFeedItem> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem != null)
    {
      localObject1 = paramList1.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TroopFeedItem)((Iterator)localObject1).next();
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem != null) && (((TroopFeedItem)localObject2).id.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem.id))) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = ((TroopFeedItem)localObject2);
        }
      }
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem);
      i = 0;
    }
    paramList = paramList.iterator();
    do
    {
      if (paramList.hasNext())
      {
        localObject1 = (String)paramList.next();
        if (i > 0) {}
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = null;
        return localArrayList;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem != null) && (((String)localObject1).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem.id)));
    Object localObject2 = paramList1.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      TroopFeedItem localTroopFeedItem = (TroopFeedItem)((Iterator)localObject2).next();
      if (((String)localObject1).equalsIgnoreCase(localTroopFeedItem.id))
      {
        localArrayList.add(localTroopFeedItem);
        i -= 1;
      }
    }
    for (;;)
    {
      break;
    }
  }
  
  public class a
    extends DefaultHandler
  {
    public String linkUrl;
    public String picture;
    public String summary;
    protected String tagName;
    public String title;
    
    public a() {}
    
    public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
      throws SAXException
    {
      if (this.tagName != null)
      {
        paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
        if (!this.tagName.equals("title")) {
          break label46;
        }
        if (aqmr.isEmpty(this.title)) {
          this.title = paramArrayOfChar;
        }
      }
      label46:
      while (!this.tagName.equals("summary")) {
        return;
      }
      this.summary = paramArrayOfChar;
    }
    
    public void endElement(String paramString1, String paramString2, String paramString3)
      throws SAXException
    {
      this.tagName = null;
    }
    
    public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
      throws SAXException
    {
      if (paramString2.equals("picture")) {
        this.picture = paramAttributes.getValue("cover");
      }
      for (;;)
      {
        this.tagName = paramString2;
        return;
        if (paramString2.equals("msg")) {
          this.linkUrl = paramAttributes.getValue("url");
        }
      }
    }
  }
  
  public static class b
  {
    public boolean aLW;
    public boolean cPJ = true;
    public boolean cPK;
    public String cnW;
    public String cnX;
    public String cnY;
    public String cnZ;
    public String content;
    public int dTf;
    public String feedId;
    public String fid;
    public int mType = 1;
    public String picPath;
    public long time;
    public String title;
    
    public static b a(QQAppInterface paramQQAppInterface, String paramString, JSONObject paramJSONObject)
    {
      boolean bool2 = true;
      if ((paramJSONObject == null) || (!paramJSONObject.has("msg"))) {}
      b localb;
      JSONObject localJSONObject;
      do
      {
        do
        {
          return null;
          localb = new b();
          localb.fid = paramJSONObject.optString("fid");
          localJSONObject = paramJSONObject.optJSONObject("msg");
        } while (localJSONObject == null);
        localb.content = localJSONObject.optString("text_face");
        if (localb.content != null) {
          localb.content = localb.content.replace("&#10;", "<br/>");
        }
        localb.title = localJSONObject.optString("title");
        if (localb.title != null) {
          localb.title = localb.title.replace("&#10;", "<br/>");
        }
      } while ((localb.title == null) || (localb.content == null));
      localb.feedId = paramJSONObject.optString("fid");
      Object localObject = localJSONObject.optJSONArray("pics");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        localObject = ((JSONArray)localObject).optJSONObject(0);
        if (localObject != null)
        {
          localb.picPath = ("https://gdynamic.qpic.cn/gdynamic/" + ((JSONObject)localObject).optString("id") + "/628");
          localb.cnW = ("https://gdynamic.qpic.cn/gdynamic/" + ((JSONObject)localObject).optString("id") + "/");
        }
      }
      localObject = paramJSONObject.optJSONObject("settings");
      if (localObject != null)
      {
        if (((JSONObject)localObject).optInt("is_show_edit_card", 0) != 1) {
          break label424;
        }
        bool1 = true;
        localb.aLW = bool1;
        if (((JSONObject)localObject).optInt("tip_window_type", 0) != 0) {
          break label429;
        }
        bool1 = true;
        label303:
        localb.cPJ = bool1;
        if (((JSONObject)localObject).optInt("confirm_required", 0) != 1) {
          break label434;
        }
      }
      label424:
      label429:
      label434:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localb.cPK = bool1;
        if (localJSONObject.has("v"))
        {
          localJSONObject = localJSONObject.optJSONObject("v");
          localb.cnX = localJSONObject.optString("l");
          localb.picPath = localJSONObject.optString("bi");
        }
        localb.cnY = paramJSONObject.optString("u");
        localb.cnZ = aqgv.h(paramQQAppInterface, paramString, localb.cnY);
        localb.time = paramJSONObject.optLong("pubt");
        localb.dTf = paramJSONObject.optInt("read_num");
        return localb;
        bool1 = false;
        break;
        bool1 = false;
        break label303;
      }
    }
  }
  
  public static class c
  {
    public String apurl;
    public String img;
    public String rl;
    
    public static c a(JSONObject paramJSONObject)
    {
      if (paramJSONObject != null)
      {
        c localc = new c();
        localc.apurl = paramJSONObject.optString("apurl");
        localc.img = paramJSONObject.optString("img");
        localc.rl = paramJSONObject.optString("rl");
        return localc;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apbo
 * JD-Core Version:    0.7.0.1
 */