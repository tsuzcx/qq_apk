import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage.MemoCtrlInfo;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage.MessageContent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aptr
{
  public static String cnP;
  public static String cnQ;
  public static String cnR;
  public static String cnS;
  public static String cnT;
  public static String cnU = "filterID";
  public static String cnV = "src";
  public static int dTc;
  public static int dTd;
  public static int dTe;
  static final String[] hH;
  private static HashMap<String, Boolean> oA;
  private static HashMap<String, aptq> oB;
  private static HashMap<String, Boolean> oC;
  private static HashMap<String, Boolean> oD;
  static final int[] oM;
  public static HashMap<Long, byte[]> oy = new HashMap();
  private static HashMap<String, Boolean> oz = new HashMap();
  
  static
  {
    oA = new HashMap();
    oB = new HashMap();
    oC = new HashMap();
    oD = new HashMap();
    oM = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 80, 81, 82, 83, 84, 45, 85, 44, 43, 40, 41, 86, 42, 87, 57, 88, 52, 89, 63, 64, 65, 66, 67, 53, 69, 90, 91, 74, 92, 93, 75, 76, 77, 94, 95, 15, 16, 17, 18, 19, 26, 27, 28, 29, 46, 47, 48, 49, 60, 61, 62, 68, 70, 71, 72, 73, 78, 59, 20, 21, 22, 23, 24, 25, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 50, 51, 54, 55, 56, 58, 79, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134 };
    hH = new String[] { "微笑", "撇嘴", "色", "发呆", "得意", "流泪", "害羞", "闭嘴", "睡", "大哭", "尴尬", "发怒", "调皮", "呲牙", "惊讶", "难过", "酷", "冷汗", "抓狂", "吐", "偷笑", "可爱", "白眼", "傲慢", "饥饿", "困", "惊恐", "流汗", "憨笑", "大兵", "奋斗", "咒骂", "疑问", "嘘", "晕", "折磨", "衰", "骷髅", "敲打", "再见", "擦汗", "抠鼻", "鼓掌", "糗大了", "坏笑", "左哼哼", "右哼哼", "哈欠", "鄙视", "委屈", "快哭了", "阴险", "亲亲", "吓", "可怜", "菜刀", "西瓜", "啤酒", "篮球", "乒乓", "咖啡", "饭", "猪头", "玫瑰", "凋谢", "示爱", "爱心", "心碎", "蛋糕", "闪电", "炸弹", "刀", "足球", "瓢虫", "便便", "月亮", "太阳", "礼物", "拥抱", "强", "弱", "握手", "胜利", "抱拳", "勾引", "拳头", "差劲", "爱你", "NO", "OK", "爱情", "飞吻", "跳跳", "发抖", "怄火", "转圈", "磕头", "回头", "跳绳", "挥手", "激动", "街舞", "献吻", "左太极", "右太极", "潜水", "敬礼", "石化", "加油", "熬夜", "赢了", "输啦", "火炬", "金牌", "坑爹", "伤不起", "亲", "裁判", "跨栏" };
    cnP = "controlType";
    cnQ = "controlInfo";
    dTc = 1;
    cnR = "compress";
    dTd = 1;
    cnS = "validTime";
    cnT = "needFilter";
    dTe = 1;
  }
  
  public static String H(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      localObject = null;
    }
    int i;
    String str;
    do
    {
      return localObject;
      i = paramString1.indexOf(paramString2);
      str = "";
      localObject = paramString1;
    } while (i < 0);
    Object localObject = str;
    while (i >= 0)
    {
      localObject = (String)localObject + paramString1.substring(0, i) + paramString3;
      paramString1 = paramString1.substring(i + paramString2.length());
      i = paramString1.indexOf(paramString2);
    }
    return (String)localObject + paramString1;
  }
  
  public static void K(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((oy != null) && (oy.containsKey(paramString)))
    {
      byte[] arrayOfByte = (byte[])oy.get(paramString);
      ((acms)paramQQAppInterface.getBusinessHandler(20)).a(paramQQAppInterface, paramString, arrayOfByte, paramInt);
      return;
    }
    try
    {
      a(paramQQAppInterface, paramInt, Long.parseLong(paramString), Long.parseLong(paramString), Long.parseLong(paramQQAppInterface.getCurrentAccountUin()), "", (int)System.currentTimeMillis(), "OidbSvc.0x8ca_2", (short)0, true);
      return;
    }
    catch (NumberFormatException paramQQAppInterface) {}catch (Exception paramQQAppInterface) {}
  }
  
  public static void TW(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "setReadNewTroopNotification");
    }
    oz.remove(paramString);
  }
  
  public static aptq a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification");
    }
    Object localObject = (aptq)oB.get(paramString);
    if (localObject != null)
    {
      paramQQAppInterface = (QQAppInterface)localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification. type = " + ((aptq)localObject).dVP);
        paramQQAppInterface = (QQAppInterface)localObject;
      }
    }
    label314:
    do
    {
      do
      {
        return paramQQAppInterface;
        localObject = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramString);
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification. nothing in DB. return null");
          }
          return null;
        }
        if (((TroopInfo)localObject).feeds_id != null) {
          break label314;
        }
        if (!oA.containsKey(paramString)) {
          break;
        }
        localObject = (Boolean)oA.get(paramString);
        if ((localObject == null) || (((Boolean)localObject).booleanValue() != true)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification = false, but mTroopNotificationAIOFlag is set. Checking old version DB.");
        }
        localObject = paramQQAppInterface.a().createEntityManager();
        List localList = ((EntityManager)localObject).query(TroopNotificationCache.class, true, "troopUin=? and read=?", new String[] { paramString, "0" }, null, null, null, null);
        ((EntityManager)localObject).close();
        if ((localList == null) || (localList.size() <= 0) || (localList.get(0) == null) || (((TroopNotificationCache)localList.get(0)).feedsId == null)) {
          break;
        }
        q(paramQQAppInterface, ((TroopNotificationCache)localList.get(0)).feedsId, paramString, 0);
        paramString = (aptq)oB.get(paramString);
        paramQQAppInterface = paramString;
      } while (!QLog.isColorLevel());
      QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification(Old Flag). type = 0");
      return paramString;
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification. feedisId is empty. return null");
      }
      return null;
      paramString = new aptq(((TroopInfo)localObject).feeds_id, ((TroopInfo)localObject).troopRepeatType);
      paramQQAppInterface = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("TroopNotificationHelper", 2, "HasUnReadRepeatTroopNotification. type = " + paramString.dVP);
    return paramString;
  }
  
  public static aptr.a a(DataInputStream paramDataInputStream, boolean paramBoolean)
    throws IOException
  {
    paramDataInputStream.read();
    paramDataInputStream.readShort();
    int k = paramDataInputStream.readShort();
    paramDataInputStream.readInt();
    int m = paramDataInputStream.readInt();
    byte[] arrayOfByte2 = new byte[32];
    Arrays.fill(arrayOfByte2, (byte)0);
    paramDataInputStream.read(arrayOfByte2);
    paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    int n = paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    paramDataInputStream.skip(paramDataInputStream.readShort() * 5);
    paramDataInputStream.skip(16L);
    byte[] arrayOfByte1 = new byte[paramDataInputStream.readInt()];
    paramDataInputStream.read(arrayOfByte1);
    paramDataInputStream = new String(arrayOfByte2);
    int j = paramDataInputStream.indexOf(0);
    int i = j;
    if (j == -1) {
      i = paramDataInputStream.length();
    }
    paramDataInputStream = a(paramDataInputStream.substring(0, i), arrayOfByte1, paramBoolean);
    if (paramDataInputStream != null) {
      if (m >= 0) {
        break label197;
      }
    }
    label197:
    for (paramDataInputStream.fromUin = (m & 0xFFFFFFFF);; paramDataInputStream.fromUin = m)
    {
      paramDataInputStream.dVQ = n;
      paramDataInputStream.feedsType = k;
      return paramDataInputStream;
    }
  }
  
  public static aptr.a a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    label846:
    label855:
    Object localObject4;
    for (;;)
    {
      Object localObject5;
      long l2;
      try
      {
        group_feeds.GroupFeedsMessage localGroupFeedsMessage = new group_feeds.GroupFeedsMessage();
        localGroupFeedsMessage.mergeFrom(paramArrayOfByte);
        i = localGroupFeedsMessage.enum_feeds_type.get();
        Object localObject3;
        if ((i == 5) || (i == 19))
        {
          Object localObject2 = localGroupFeedsMessage.rpt_feeds_content.get();
          paramArrayOfByte = "群公告";
          if (paramBoolean) {
            paramArrayOfByte = "";
          }
          localObject1 = "";
          localObject5 = new StringBuilder();
          Iterator localIterator = ((List)localObject2).iterator();
          if (localIterator.hasNext())
          {
            localObject2 = (group_feeds.GroupFeedsMessage.MessageContent)localIterator.next();
            i = ((group_feeds.GroupFeedsMessage.MessageContent)localObject2).enum_content_type.get();
            if (i == 3)
            {
              localObject2 = String.format("https://gdynamic.qpic.cn/gdynamic/%s/72", new Object[] { ((group_feeds.GroupFeedsMessage.MessageContent)localObject2).bytes_pic_id.get().toStringUtf8() });
              localObject1 = paramArrayOfByte;
              paramArrayOfByte = (byte[])localObject2;
              break label878;
            }
            if (i == 0)
            {
              ((StringBuilder)localObject5).append(((group_feeds.GroupFeedsMessage.MessageContent)localObject2).bytes_content_value.get().toStringUtf8());
              localObject2 = paramArrayOfByte;
              paramArrayOfByte = (byte[])localObject1;
              localObject1 = localObject2;
              break label878;
            }
            if (i == 10)
            {
              localObject2 = ((group_feeds.GroupFeedsMessage.MessageContent)localObject2).bytes_content_value.get().toStringUtf8();
              paramArrayOfByte = (byte[])localObject1;
              localObject1 = localObject2;
              break label878;
            }
            if (i != 2) {
              break label868;
            }
            i = ((group_feeds.GroupFeedsMessage.MessageContent)localObject2).int32_face_idx.get();
            if (i >= 0) {}
            try
            {
              if (i < oM.length)
              {
                localObject2 = hH[i];
                ((StringBuilder)localObject5).append('[');
                ((StringBuilder)localObject5).append((String)localObject2);
                ((StringBuilder)localObject5).append(']');
              }
              localObject2 = paramArrayOfByte;
              paramArrayOfByte = (byte[])localObject1;
              localObject1 = localObject2;
            }
            catch (Exception localException)
            {
              localObject3 = paramArrayOfByte;
              paramArrayOfByte = (byte[])localObject1;
              localObject1 = localObject3;
            }
          }
          localObject3 = ((StringBuilder)localObject5).toString();
          localObject5 = new aptr.a();
          ((aptr.a)localObject5).title = paramArrayOfByte;
          ((aptr.a)localObject5).feedsId = paramString;
          ((aptr.a)localObject5).text = ((String)localObject3);
          ((aptr.a)localObject5).imageUrl = ((String)localObject1);
          ((aptr.a)localObject5).itemType = 1;
          if (!localGroupFeedsMessage.opt_uint32_ctl_flag.has()) {
            break label894;
          }
          i = localGroupFeedsMessage.opt_uint32_ctl_flag.get();
          ((aptr.a)localObject5).ctl_flag = i;
          if ((!localGroupFeedsMessage.memo_ctrl_info.has()) || (!((group_feeds.GroupFeedsMessage.MemoCtrlInfo)localGroupFeedsMessage.memo_ctrl_info.get()).uint32_need_confirmation.has())) {
            break label891;
          }
          if (((group_feeds.GroupFeedsMessage.MemoCtrlInfo)localGroupFeedsMessage.memo_ctrl_info.get()).uint32_need_confirmation.get() != 1) {
            break label899;
          }
          paramBoolean = bool1;
          ((aptr.a)localObject5).needConfirm = paramBoolean;
          break label891;
        }
        if (i == 22)
        {
          localObject5 = localGroupFeedsMessage.rpt_feeds_content.get().iterator();
          localObject1 = null;
          paramArrayOfByte = null;
          if (((Iterator)localObject5).hasNext())
          {
            localObject3 = (group_feeds.GroupFeedsMessage.MessageContent)((Iterator)localObject5).next();
            i = ((group_feeds.GroupFeedsMessage.MessageContent)localObject3).enum_content_type.get();
            if (i == 0)
            {
              localObject3 = ((group_feeds.GroupFeedsMessage.MessageContent)localObject3).bytes_content_value.get().toByteArray();
              paramArrayOfByte = (byte[])localObject1;
              localObject1 = localObject3;
              break label904;
            }
            if (i != 14) {
              break label855;
            }
            localObject1 = ((group_feeds.GroupFeedsMessage.MessageContent)localObject3).bytes_content_value.get().toStringUtf8();
            localObject3 = paramArrayOfByte;
            paramArrayOfByte = (byte[])localObject1;
            localObject1 = localObject3;
            break label904;
          }
          l2 = 0L;
          l1 = l2;
          try
          {
            localObject3 = new JSONObject((String)localObject1);
            l1 = l2;
            if (!((JSONObject)localObject3).has(cnP)) {
              break label846;
            }
            l1 = l2;
            if (((JSONObject)localObject3).getInt(cnP) != dTc) {
              break label846;
            }
            l1 = l2;
            localObject3 = ((JSONObject)localObject3).getJSONObject(cnQ);
            l1 = l2;
            l2 = ((JSONObject)localObject3).getLong(cnU);
            l1 = l2;
            i = ((JSONObject)localObject3).getInt(cnV);
            l1 = l2;
          }
          catch (JSONException localJSONException)
          {
            if (!QLog.isDevelopLevel()) {
              continue;
            }
            QLog.d("TroopNotificationHelper", 4, "decodeToFeedItem--JSONException");
            i = 0;
            continue;
            i = 0;
            continue;
          }
          localObject3 = new aptr.a();
          ((aptr.a)localObject3).feedsId = paramString;
          ((aptr.a)localObject3).xmlBytes = paramArrayOfByte;
          ((aptr.a)localObject3).crk = ((String)localObject1);
          ((aptr.a)localObject3).itemType = 2;
          ((aptr.a)localObject3).filterID = l1;
          ((aptr.a)localObject3).src = i;
          if (localGroupFeedsMessage.opt_uint32_ctl_flag.has())
          {
            i = localGroupFeedsMessage.opt_uint32_ctl_flag.get();
            ((aptr.a)localObject3).ctl_flag = i;
            if ((!localGroupFeedsMessage.memo_ctrl_info.has()) || (!((group_feeds.GroupFeedsMessage.MemoCtrlInfo)localGroupFeedsMessage.memo_ctrl_info.get()).uint32_need_confirmation.has())) {
              break;
            }
            paramBoolean = bool2;
            if (((group_feeds.GroupFeedsMessage.MemoCtrlInfo)localGroupFeedsMessage.memo_ctrl_info.get()).uint32_need_confirmation.get() == 1) {
              paramBoolean = true;
            }
            ((aptr.a)localObject3).needConfirm = paramBoolean;
            break;
          }
        }
        return null;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TroopNotificationCache.class.getSimpleName(), 2, paramString.getMessage());
        }
      }
      int i = 0;
      long l1 = l2;
      continue;
      localObject4 = paramArrayOfByte;
      paramArrayOfByte = (byte[])localObject1;
      Object localObject1 = localObject4;
      break label904;
      label868:
      localObject4 = localObject1;
      localObject1 = paramArrayOfByte;
      paramArrayOfByte = (byte[])localObject4;
      label878:
      localObject4 = localObject1;
      localObject1 = paramArrayOfByte;
      paramArrayOfByte = (byte[])localObject4;
      continue;
      label891:
      return localObject5;
      label894:
      i = 0;
      continue;
      label899:
      paramBoolean = false;
      continue;
      label904:
      localObject4 = localObject1;
      localObject1 = paramArrayOfByte;
      paramArrayOfByte = (byte[])localObject4;
    }
    return localObject4;
  }
  
  public static TroopNotificationCache a(aptr.a parama, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    if (parama != null)
    {
      if (parama.itemType == 1)
      {
        String str2 = oT(parama.text);
        int i = str2.lastIndexOf('&');
        String str1 = str2;
        if (i != -1)
        {
          str1 = str2;
          if (str2.indexOf(";", i) == -1) {
            str1 = str2.substring(0, i - 1);
          }
        }
        str2 = oT(parama.title);
        if (TextUtils.isEmpty(parama.title))
        {
          str2 = new SimpleDateFormat("yyyy年M月d日").format(new Date(parama.dVQ * 1000L));
          str2 = str2 + " 群公告";
        }
        paramString = String.format("https://web.qun.qq.com/mannounce/index.html?_wv=1031&amp;_bid=148#gc=%d&amp;feedType=%d&amp;gotoFid=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), paramString });
        TroopNotificationCache localTroopNotificationCache = new TroopNotificationCache();
        localTroopNotificationCache.title = parama.title;
        localTroopNotificationCache.feedType = paramInt1;
        localTroopNotificationCache.appId = paramInt2;
        localTroopNotificationCache.userUin = parama.fromUin;
        localTroopNotificationCache.troopUin = paramLong;
        localTroopNotificationCache.time = parama.dVQ;
        localTroopNotificationCache.feedsId = parama.feedsId;
        localTroopNotificationCache.serviceID = 27;
        localTroopNotificationCache.needConfirm = parama.needConfirm;
        String str3 = new SimpleDateFormat("M-d HH:mm").format(new Date(localTroopNotificationCache.time * 1000L));
        if (TextUtils.isEmpty(parama.imageUrl)) {}
        for (localTroopNotificationCache.xmlBytes = String.format("<?xml version=\"1.0\" encoding=\"utf-8\" ?><msg action=\"web\" serviceID=\"27\" templateID=\"\" actionData=\"\" url=\"%s\" flag=\"5\" brief=\"%s\"><item layout=\"1\"><title size=\"30\" color=\"#000000\">[公告] %s</title><hr /><title size=\"22\" color=\"#000000\">%s</title><summary size=\"28\" color=\"#808080\">%s</summary></item></msg>", new Object[] { paramString, "", str2, str3, str1 }).getBytes();; localTroopNotificationCache.xmlBytes = String.format("<?xml version=\"1.0\" encoding=\"utf-8\" ?><msg action=\"web\" serviceID=\"27\" templateID=\"\" actionData=\"\" url=\"%s\" flag=\"5\" brief=\"%s\"><item layout=\"6\"><title size=\"30\" color=\"#000000\">[公告] %s</title><hr /></item><item layout=\"2\"><picture cover=\"%s\"/><title size=\"22\" color=\"#000000\">%s</title><summary size=\"28\" color=\"#808080\">%s</summary></item></msg>", new Object[] { paramString, "", str2, parama.imageUrl, str3, str1 }).getBytes()) {
          return localTroopNotificationCache;
        }
      }
      if (parama.itemType == 2)
      {
        paramString = new TroopNotificationCache();
        paramString.feedType = paramInt1;
        paramString.appId = paramInt2;
        paramString.userUin = parama.fromUin;
        paramString.troopUin = paramLong;
        paramString.time = parama.dVQ;
        paramString.feedsId = parama.feedsId;
        paramString.ctrlStr = parama.crk;
        paramString.xmlBytes = parama.xmlBytes;
        paramString.src = parama.src;
        paramString.filterID = parama.filterID;
        paramString.serviceID = 20;
        return paramString;
      }
    }
    return null;
  }
  
  public static TroopNotificationCache a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "handle get troop guide");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    int i;
    try
    {
      paramArrayOfByte = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom(paramArrayOfByte);
      if ((paramArrayOfByte == null) || (!paramArrayOfByte.uint32_result.has())) {
        return null;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = localOIDBSSOPkg;
      }
      i = paramArrayOfByte.uint32_result.get();
      if (i != 0)
      {
        paramQQAppInterface = "oidb0x852_48 cResult=" + String.valueOf(i);
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationHelper", 2, paramQQAppInterface);
        }
        return null;
      }
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte.bytes_bodybuffer.get().toByteArray()));
        paramArrayOfByte.readInt();
        paramArrayOfByte.readInt();
        i = paramArrayOfByte.readShort();
        paramArrayOfByte.readShort();
        if (paramInt1 != 23) {
          break label312;
        }
        bool = true;
        paramArrayOfByte = a(paramArrayOfByte, bool);
        if (paramArrayOfByte != null)
        {
          if (paramInt1 == 23)
          {
            paramQQAppInterface = a(paramArrayOfByte, paramArrayOfByte.feedsId, i, paramInt2, paramLong2);
            if ((paramQQAppInterface == null) || (!TextUtils.isEmpty(paramQQAppInterface.title))) {
              break label310;
            }
            paramQQAppInterface.title = paramArrayOfByte.text;
            break label310;
          }
          if ((!d(paramQQAppInterface, Long.toString(paramLong2), paramArrayOfByte.feedsId)) && (paramBoolean)) {
            q(paramQQAppInterface, paramArrayOfByte.feedsId, Long.toString(paramLong2), 2);
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(aptr.class.getSimpleName(), 2, paramQQAppInterface.getMessage());
        continue;
      }
      return null;
      label310:
      return paramQQAppInterface;
      label312:
      boolean bool = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString1, int paramInt2, String paramString2, short paramShort, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "send0x580Cmd");
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramQQAppInterface.getCurrentAccountUin(), "OidbSvc.0x580_1");
    try
    {
      Object localObject = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeInt((int)paramLong2);
      byte[] arrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
      localDataOutputStream.close();
      ((ByteArrayOutputStream)localObject).close();
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1408);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(arrayOfByte));
      localToServiceMsg.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
      localToServiceMsg.extraData.putInt("appId", paramInt1);
      localToServiceMsg.extraData.putLong("troopUin", paramLong1);
      localToServiceMsg.extraData.putLong("troopCode", paramLong2);
      localToServiceMsg.extraData.putLong("userUin", paramLong3);
      localToServiceMsg.extraData.putString("feedsId", paramString1);
      localToServiceMsg.extraData.putInt("time", paramInt2);
      localToServiceMsg.extraData.putString("cmd", paramString2);
      localToServiceMsg.extraData.putInt("feedType", paramShort);
      localToServiceMsg.extraData.putBoolean("aioRequest", paramBoolean);
      localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      paramQQAppInterface.sendToService(localToServiceMsg);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(aptr.class.getSimpleName(), 2, localException.getMessage());
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString1, int paramInt2, String paramString2, short paramShort, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean2) && (oy != null) && (oy.containsKey(Long.valueOf(paramLong2))))
    {
      byte[] arrayOfByte = (byte[])oy.get(Long.valueOf(paramLong2));
      short s = (short)arrayOfByte.length;
      if ("OidbSvc.0x852_35".equals(paramString2))
      {
        oD.put(paramString1, Boolean.valueOf(true));
        a(paramQQAppInterface, paramInt1, paramLong1, paramLong2, s, arrayOfByte, paramLong3, paramString1, paramInt2);
      }
      while (!"OidbSvc.0x852_48".equals(paramString2)) {
        return;
      }
      a(paramQQAppInterface, paramInt1, paramLong1, paramLong2, s, arrayOfByte, paramShort, paramBoolean1);
      return;
    }
    if ("OidbSvc.0x852_35".equals(paramString2)) {
      oD.put(paramString1, Boolean.valueOf(true));
    }
    a(paramQQAppInterface, paramInt1, paramLong1, paramLong2, paramLong3, paramString1, paramInt2, paramString2, paramShort, paramBoolean1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt2, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "handle get notice");
    }
    Object localObject = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramArrayOfByte = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramArrayOfByte);
      if ((paramArrayOfByte == null) || (!paramArrayOfByte.uint32_result.has()))
      {
        oD.remove(paramString);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = (byte[])localObject;
      }
      paramInt2 = paramArrayOfByte.uint32_result.get();
      if (paramInt2 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationHelper", 2, "0x852_35 cResult=" + paramInt2);
        }
        oD.remove(paramString);
        return;
      }
    }
    try
    {
      paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte.bytes_bodybuffer.get().toByteArray()));
      paramArrayOfByte.readInt();
      localObject = a(paramArrayOfByte, false);
      if (localObject != null)
      {
        paramArrayOfByte = null;
        if ((((aptr.a)localObject).itemType == 1) || (((aptr.a)localObject).itemType == 2)) {
          paramArrayOfByte = a((aptr.a)localObject, paramString, 23, paramInt1, paramLong2);
        }
        QQMessageFacade localQQMessageFacade = paramQQAppInterface.b();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramArrayOfByte);
        paramInt1 = (int)anaz.gQ();
        localQQMessageFacade.a().a(paramQQAppInterface, String.valueOf(paramLong1), String.valueOf(paramLong2), localArrayList, 23, paramInt1, ((aptr.a)localObject).ctl_flag, ((aptr.a)localObject).feedsId);
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(aptr.class.getSimpleName(), 2, paramQQAppInterface.getMessage());
        }
      }
    }
    oD.remove(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong1, long paramLong2, short paramShort, byte[] paramArrayOfByte, long paramLong3, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "send get notices");
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramQQAppInterface.getCurrentAccountUin(), "OidbSvc.0x852_35");
    paramArrayOfByte = a(paramLong2, paramShort, paramArrayOfByte, paramString);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2130);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(35);
    if (paramArrayOfByte != null) {
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    localToServiceMsg.putWupBuffer(localOIDBSSOPkg.toByteArray());
    localToServiceMsg.extraData.putInt("appId", paramInt1);
    localToServiceMsg.extraData.putLong("troopUin", paramLong1);
    localToServiceMsg.extraData.putLong("troopCode", paramLong2);
    localToServiceMsg.extraData.putLong("userUin", paramLong3);
    localToServiceMsg.extraData.putString("feedsId", paramString);
    localToServiceMsg.extraData.putInt("time", paramInt2);
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    paramQQAppInterface.sendToService(localToServiceMsg);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong1, long paramLong2, short paramShort1, byte[] paramArrayOfByte, short paramShort2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "send get troop guide");
    }
    int i = (short)47;
    i = (int)paramLong2;
    Object localObject1 = paramQQAppInterface.getCurrentAccountUin();
    long l2 = 0L;
    try
    {
      l1 = Long.valueOf(((String)localObject1).trim()).longValue();
      l1 &= 0xFFFFFFFF;
    }
    catch (Exception localException)
    {
      try
      {
        do
        {
          int j;
          int k;
          byte[] arrayOfByte;
          int m;
          int n;
          localObject1 = new ByteArrayOutputStream();
          Object localObject2 = new DataOutputStream((OutputStream)localObject1);
          ((DataOutputStream)localObject2).writeInt(m);
          ((DataOutputStream)localObject2).write(1);
          ((DataOutputStream)localObject2).writeShort(n);
          ((DataOutputStream)localObject2).writeInt(i);
          ((DataOutputStream)localObject2).writeInt((int)l1);
          ((DataOutputStream)localObject2).writeShort(paramShort2);
          ((DataOutputStream)localObject2).writeInt(-1);
          ((DataOutputStream)localObject2).writeInt(1);
          ((DataOutputStream)localObject2).writeInt(j);
          ((DataOutputStream)localObject2).writeInt(k);
          ((DataOutputStream)localObject2).writeShort(paramShort1);
          ((DataOutputStream)localObject2).write(paramArrayOfByte);
          ((DataOutputStream)localObject2).write(arrayOfByte);
          paramArrayOfByte = ((ByteArrayOutputStream)localObject1).toByteArray();
          ((DataOutputStream)localObject2).close();
          ((ByteArrayOutputStream)localObject1).close();
          localObject1 = new ToServiceMsg("mobileqq.service", paramQQAppInterface.getCurrentAccountUin(), "OidbSvc.0x852_48");
          localObject2 = new oidb_sso.OIDBSSOPkg();
          ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2130);
          ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
          ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(48);
          ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
          ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
          ((ToServiceMsg)localObject1).extraData.putInt("appId", paramInt);
          ((ToServiceMsg)localObject1).extraData.putLong("troopUin", paramLong1);
          ((ToServiceMsg)localObject1).extraData.putLong("troopCode", paramLong2);
          ((ToServiceMsg)localObject1).extraData.putInt("feedType", paramShort2);
          ((ToServiceMsg)localObject1).extraData.putBoolean("aioRequest", paramBoolean);
          ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
          paramQQAppInterface.sendToService((ToServiceMsg)localObject1);
          return;
          localException = localException;
          l1 = l2;
        } while (!QLog.isColorLevel());
        QLog.d("TroopNotificationHelper", 2, localException.getMessage());
        long l1 = l2;
      }
      catch (Exception paramQQAppInterface)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(aptr.class.getSimpleName(), 2, paramQQAppInterface.getMessage());
      }
    }
    j = (int)(System.currentTimeMillis() / 1000L);
    k = (int)(System.currentTimeMillis() / 1000L);
    arrayOfByte = new byte[16];
    m = 47 + paramShort1;
    n = (short)m;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, List<TroopNotificationCache> paramList, int paramInt1, int paramInt2, String paramString2)
  {
    Object localObject = paramQQAppInterface.a().createEntityManager();
    paramList = paramList.iterator();
    boolean bool2 = false;
    boolean bool1 = false;
    int i = 0;
    TroopNotificationCache localTroopNotificationCache;
    if (paramList.hasNext())
    {
      localTroopNotificationCache = (TroopNotificationCache)paramList.next();
      if (localTroopNotificationCache.userUin == paramQQAppInterface.getLongAccountUin())
      {
        localTroopNotificationCache.read = true;
        label64:
        localTroopNotificationCache.currentUin = paramQQAppInterface.getCurrentAccountUin();
        ((EntityManager)localObject).persist(localTroopNotificationCache);
        if (localTroopNotificationCache.serviceID == 27) {
          bool2 = true;
        }
        if (!localTroopNotificationCache.needConfirm) {
          break label488;
        }
        bool1 = true;
      }
    }
    label342:
    label488:
    for (;;)
    {
      break;
      localTroopNotificationCache.read = false;
      i += 1;
      break label64;
      ((EntityManager)localObject).close();
      if (i == 0) {}
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "setUnReadFlag = " + i + ", isTroopNotifycation = " + bool2);
          }
          if (bool2)
          {
            paramList = win.b();
            if ((paramList != null) && (paramList.vn() < 5) && (paramList.oN().equals(paramString1)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("TroopNotificationHelper", 2, "AIO is opened. Do not popout troop notification.");
              }
              aZ(paramQQAppInterface, paramString1);
              return;
            }
          }
          q(paramQQAppInterface, paramString2, paramString1, 0);
          aX(paramQQAppInterface, paramString1);
          paramList = paramQQAppInterface.getHandler(Conversation.class);
        } while ((paramList == null) || (!bool2));
        paramString2 = paramQQAppInterface.a();
        paramString1 = paramString2.a().a(paramString1, 1);
      } while (paramQQAppInterface.cs(paramString1.uin) == 3);
      if (paramInt2 == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationHelper", 2, "update recent user list");
        }
        paramQQAppInterface = aajt.makeKey(paramString1.uin, paramString1.getType());
        aajt.a().Av(paramQQAppInterface);
        if (paramInt2 != 1) {
          break label449;
        }
        i = 29;
        paramString1.msgType = i;
        if (!(paramString1.msg instanceof aalz)) {
          break label469;
        }
        localObject = (aalz)paramString1.msg;
        if (!bool1) {
          break label456;
        }
        paramQQAppInterface = BaseApplication.getContext().getString(2131721138);
        label382:
        ((aalz)localObject).content = paramQQAppInterface;
      }
      for (;;)
      {
        ((aalz)paramString1.msg).ctl_flag = paramInt2;
        paramString1.lastmsgtime = paramInt1;
        paramString2.a().e(paramString1);
        paramList.sendEmptyMessage(1009);
        return;
        if ((!(paramString1.msg instanceof aalz)) || (((aalz)paramString1.msg).ctl_flag != 1)) {
          break;
        }
        return;
        i = 11;
        break label342;
        paramQQAppInterface = BaseApplication.getContext().getString(2131721137);
        break label382;
        paramString1.msg = new aalz(BaseApplication.getContext(), bool1);
      }
    }
  }
  
  public static byte[] a(long paramLong, short paramShort, byte[] paramArrayOfByte, String paramString)
  {
    int i = 0;
    int j = (short)65;
    j = (int)paramLong;
    byte[] arrayOfByte1 = new byte[32];
    Arrays.fill(arrayOfByte1, (byte)0);
    paramString = paramString.getBytes();
    while ((i < 32) && (i < paramString.length))
    {
      arrayOfByte1[i] = paramString[i];
      i += 1;
    }
    i = (int)(System.currentTimeMillis() / 1000L);
    int k = (int)(System.currentTimeMillis() / 1000L);
    byte[] arrayOfByte2 = new byte[16];
    int m = 65 + paramShort;
    int n = (short)m;
    try
    {
      paramString = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream(paramString);
      localDataOutputStream.writeInt(m);
      localDataOutputStream.write(1);
      localDataOutputStream.writeShort(n);
      localDataOutputStream.writeInt(j);
      localDataOutputStream.write(arrayOfByte1);
      localDataOutputStream.writeInt(i);
      localDataOutputStream.writeInt(k);
      localDataOutputStream.writeShort(paramShort);
      localDataOutputStream.write(paramArrayOfByte);
      localDataOutputStream.write(arrayOfByte2);
      paramArrayOfByte = paramString.toByteArray();
      localDataOutputStream.close();
      paramString.close();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d(aptr.class.getSimpleName(), 2, paramArrayOfByte.getMessage());
      }
    }
    return null;
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt2, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(aptr.class.getSimpleName(), 2, "handGetTroopAuth");
    }
    paramQQAppInterface = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramArrayOfByte = (oidb_sso.OIDBSSOPkg)paramQQAppInterface.mergeFrom((byte[])paramArrayOfByte);
      paramQQAppInterface = paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
      paramInt1 = paramQQAppInterface.uint32_result.get();
      if (paramInt1 == 0) {
        break label134;
      }
      if (!QLog.isColorLevel()) {
        break label123;
      }
      QLog.d("TroopNotificationHelper", 2, "0x580 cResult=" + paramInt1);
      label123:
      oD.remove(paramString);
      return null;
      try
      {
        label134:
        paramQQAppInterface = new ByteArrayInputStream(paramQQAppInterface.bytes_bodybuffer.get().toByteArray());
        paramString = new DataInputStream(paramQQAppInterface);
        paramString.readInt();
        paramString.readInt();
        paramString.readInt();
        paramString.readInt();
        paramString.skip(16L);
        paramString.readInt();
        paramString.readInt();
        paramString.skip(4L);
        paramArrayOfByte = new byte[paramString.readShort()];
        paramString.read(paramArrayOfByte);
        oy.put(Long.valueOf(paramLong2), paramArrayOfByte);
        paramString.close();
        paramQQAppInterface.close();
        return paramArrayOfByte;
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          break label279;
        }
        QLog.d(aptr.class.getSimpleName(), 2, paramQQAppInterface.getMessage());
      }
    }
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.uint32_result.has()))
    {
      oD.remove(paramString);
      return null;
    }
    label279:
    return null;
  }
  
  public static void aW(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "setReadNewTroopNotification");
    }
    oA.remove(paramString);
    BaseApplicationImpl.getContext().getSharedPreferences("new_notify_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit().remove(paramString).commit();
  }
  
  public static void aX(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "setUnReadAIONewTroopNotification.");
    }
    oA.put(paramString, Boolean.valueOf(true));
    BaseApplicationImpl.getContext().getSharedPreferences("new_notify_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean(paramString, true).commit();
    slz.tp("https://gdynamic.qpic.cn/gdynamic/");
  }
  
  public static void aY(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "setReadRepeatTroopNotification.");
    }
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
    TroopInfo localTroopInfo = paramQQAppInterface.b(paramString);
    if (localTroopInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationHelper", 2, "setReadRepeatTroopNotification. type: " + localTroopInfo.troopRepeatType);
      }
      localTroopInfo.feeds_id = "";
      localTroopInfo.troopRepeatType = 0;
      paramQQAppInterface.i(localTroopInfo);
    }
    if (oB.containsKey(paramString)) {
      oB.remove(paramString);
    }
  }
  
  public static void aZ(QQAppInterface paramQQAppInterface, String paramString)
  {
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
    List localList = localTroopManager.ak(paramString);
    if ((localList != null) && (localList.size() > 0) && (QLog.isColorLevel())) {
      QLog.d("TroopNotificationHelper", 2, "readTroopNotification--->troopNotificationCaches size:" + localList.size());
    }
    localTroopManager.Ft(paramString);
    TW(paramString);
    aW(paramQQAppInterface, paramString);
    aY(paramQQAppInterface, paramString);
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    boolean bool = true;
    if (paramString2 == null) {
      bool = false;
    }
    do
    {
      return bool;
      if (paramString2.isEmpty()) {
        return false;
      }
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
      paramString1 = paramQQAppInterface.query(TroopNotificationCache.class, true, "troopUin=? and read=? and feedsId=?", new String[] { paramString1, "1", paramString2 }, null, null, null, null);
      paramQQAppInterface.close();
    } while ((paramString1 != null) && (paramString1.size() > 0));
    return false;
  }
  
  public static void ebL()
  {
    if (oy != null) {
      oy.clear();
    }
  }
  
  public static void eo(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "initTroopNotificationFlag");
    }
    oA.clear();
    oz.clear();
    oC.clear();
    oB.clear();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface = localEntityManager.query(true, TroopNotificationCache.class.getSimpleName(), new String[] { "troopUin", "feedType", "serviceID" }, "read=?", new String[] { String.valueOf(0) }, "troopUin", null, null, null);
    if (paramQQAppInterface != null) {}
    for (;;)
    {
      try
      {
        if (paramQQAppInterface.moveToFirst())
        {
          i = paramQQAppInterface.getColumnIndex("troopUin");
          if (i != -1)
          {
            long l = paramQQAppInterface.getLong(i);
            i = paramQQAppInterface.getColumnIndex("serviceID");
            if (i == -1) {
              continue;
            }
            i = paramQQAppInterface.getInt(i);
            localHashMap1.put(String.valueOf(l), Boolean.valueOf(true));
            if (i == 27) {
              localHashMap3.put(String.valueOf(l), Boolean.valueOf(true));
            }
            i = paramQQAppInterface.getColumnIndex("feedType");
            if ((i != -1) && (paramQQAppInterface.getInt(i) == 34)) {
              localHashMap2.put(String.valueOf(l), Boolean.valueOf(true));
            }
          }
          boolean bool = paramQQAppInterface.moveToNext();
          if (bool) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        int i;
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopNotificationHelper", 2, "initTroopNotificationFlag Exception");
        paramQQAppInterface.close();
        continue;
      }
      finally
      {
        paramQQAppInterface.close();
      }
      localEntityManager.close();
      oA = localHashMap1;
      oz = localHashMap3;
      oC = localHashMap2;
      return;
      i = 27;
    }
  }
  
  public static String oT(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return H(H(H(H(H(paramString, "&", "&amp;"), "<", "&lt;"), ">", "&gt;"), "'", "&apos;"), "\"", "&quot;");
  }
  
  public static void q(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 == null) {}
    TroopInfo localTroopInfo;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationHelper", 2, "setUnReadRepeatTroopNotification, type: " + paramInt);
      }
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
      localTroopInfo = paramQQAppInterface.b(paramString2);
    } while (localTroopInfo == null);
    localTroopInfo.feeds_id = paramString1;
    localTroopInfo.troopRepeatType = paramInt;
    paramQQAppInterface.i(localTroopInfo);
    paramQQAppInterface = new aptq(paramString1, paramInt);
    oB.put(paramString2, paramQQAppInterface);
  }
  
  public static boolean qV(String paramString)
  {
    if (oz.containsKey(paramString)) {
      return ((Boolean)oz.get(paramString)).booleanValue();
    }
    return false;
  }
  
  public static boolean qW(String paramString)
  {
    if (oD.containsKey(paramString)) {
      return ((Boolean)oD.get(paramString)).booleanValue();
    }
    return false;
  }
  
  public static boolean qX(String paramString)
  {
    if (oC.containsKey(paramString)) {
      return ((Boolean)oC.get(paramString)).booleanValue();
    }
    return false;
  }
  
  public static void r(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 == null) {}
    do
    {
      do
      {
        return;
        q(paramQQAppInterface, paramString1, paramString2, paramInt);
        paramString1 = paramQQAppInterface.getHandler(Conversation.class);
      } while (paramString1 == null);
      paramQQAppInterface = paramQQAppInterface.a();
      paramString2 = paramQQAppInterface.a().a(paramString2, 1);
    } while (((paramString2.msg instanceof aalz)) && (((aalz)paramString2.msg).ctl_flag == 1));
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "setUnReadRepeatTroopNotificationPre, update recent user list");
    }
    Object localObject = aajt.makeKey(paramString2.uin, paramString2.getType());
    aajt.a().Av((String)localObject);
    paramString2.msgType = 11;
    localObject = new aalz(BaseApplication.getContext(), true);
    ((aalz)localObject).ctl_flag = 0;
    paramString2.msg = localObject;
    long l = anaz.gQ();
    if (l > paramString2.lastmsgtime) {}
    for (;;)
    {
      paramString2.lastmsgtime = l;
      paramQQAppInterface.a().e(paramString2);
      paramString1.sendEmptyMessage(1009);
      return;
      l = paramString2.lastmsgtime;
    }
  }
  
  public static void r(String paramString, QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    if ((paramString == null) || (paramQQAppInterface == null)) {}
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
        paramString = paramQQAppInterface.query(TroopNotificationCache.class, TroopNotificationCache.class.getSimpleName(), false, "troopUin=?", new String[] { paramString }, null, null, null, null);
      } while (paramString == null);
      while (i < paramString.size())
      {
        paramQQAppInterface.remove((TroopNotificationCache)paramString.get(i));
        i += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopNotificationHelper", 2, aptr.class.getSimpleName() + "-->clearTroopNotification");
  }
  
  public static void t(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("troop_new_guid", 0);
    if (!localSharedPreferences.getBoolean(paramString1, false)) {}
    try
    {
      localSharedPreferences.edit().putBoolean(paramString1, true).commit();
      long l = Long.parseLong(paramString1);
      a(paramQQAppInterface, 0, Long.parseLong(paramString2), l, Long.parseLong(paramQQAppInterface.getCurrentAccountUin()), "", (int)System.currentTimeMillis(), "OidbSvc.0x852_48", (short)34, true, true);
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopNotificationHelper", 2, "troopCode not long type!");
    }
  }
  
  public static class a
  {
    public String crk;
    public int ctl_flag;
    public int dVQ;
    public String feedsId;
    public int feedsType;
    public long filterID;
    public long fromUin;
    public String imageUrl;
    public int itemType;
    public boolean needConfirm;
    public int src;
    public String text;
    public String title;
    public byte[] xmlBytes;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aptr
 * JD-Core Version:    0.7.0.1
 */