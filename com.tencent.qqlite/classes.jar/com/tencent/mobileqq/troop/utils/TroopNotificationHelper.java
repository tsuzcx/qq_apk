package com.tencent.mobileqq.troop.utils;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.msg.TroopAtAllMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopAtMeMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopNotificationMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopSpecialAttentionMsg;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage.MessageContent;
import eph;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopNotificationHelper
{
  public static int a = 0;
  public static final String a = "TroopNotificationHelper";
  public static HashMap a;
  static final int[] jdField_a_of_type_ArrayOfInt;
  static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  public static int b;
  public static String b;
  private static HashMap b;
  public static int c;
  public static String c;
  private static HashMap c;
  public static String d;
  private static HashMap d;
  public static String e;
  private static HashMap e;
  public static String f;
  public static String g = "filterID";
  public static String h = "src";
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_c_of_type_JavaUtilHashMap = new HashMap();
    jdField_d_of_type_JavaUtilHashMap = new HashMap();
    jdField_e_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 80, 81, 82, 83, 84, 45, 85, 44, 43, 40, 41, 86, 42, 87, 57, 88, 52, 89, 63, 64, 65, 66, 67, 53, 69, 90, 91, 74, 92, 93, 75, 76, 77, 94, 95, 15, 16, 17, 18, 19, 26, 27, 28, 29, 46, 47, 48, 49, 60, 61, 62, 68, 70, 71, 72, 73, 78, 59, 20, 21, 22, 23, 24, 25, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 50, 51, 54, 55, 56, 58, 79, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "微笑", "撇嘴", "色", "发呆", "得意", "流泪", "害羞", "闭嘴", "睡", "大哭", "尴尬", "发怒", "调皮", "呲牙", "惊讶", "难过", "酷", "冷汗", "抓狂", "吐", "偷笑", "可爱", "白眼", "傲慢", "饥饿", "困", "惊恐", "流汗", "憨笑", "大兵", "奋斗", "咒骂", "疑问", "嘘", "晕", "折磨", "衰", "骷髅", "敲打", "再见", "擦汗", "抠鼻", "鼓掌", "糗大了", "坏笑", "左哼哼", "右哼哼", "哈欠", "鄙视", "委屈", "快哭了", "阴险", "亲亲", "吓", "可怜", "菜刀", "西瓜", "啤酒", "篮球", "乒乓", "咖啡", "饭", "猪头", "玫瑰", "凋谢", "示爱", "爱心", "心碎", "蛋糕", "闪电", "炸弹", "刀", "足球", "瓢虫", "便便", "月亮", "太阳", "礼物", "拥抱", "强", "弱", "握手", "胜利", "抱拳", "勾引", "拳头", "差劲", "爱你", "NO", "OK", "爱情", "飞吻", "跳跳", "发抖", "怄火", "转圈", "磕头", "回头", "跳绳", "挥手", "激动", "街舞", "献吻", "左太极", "右太极", "潜水", "敬礼", "石化", "加油", "熬夜", "赢了", "输啦", "火炬", "金牌", "坑爹", "伤不起", "亲", "裁判", "跨栏" };
    jdField_b_of_type_JavaLangString = "controlType";
    jdField_c_of_type_JavaLangString = "controlInfo";
    jdField_a_of_type_Int = 1;
    jdField_d_of_type_JavaLangString = "compress";
    jdField_b_of_type_Int = 1;
    jdField_e_of_type_JavaLangString = "validTime";
    f = "needFilter";
    jdField_c_of_type_Int = 1;
  }
  
  public static TroopNotificationCache a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "handle get troop guide");
    }
    paramQQAppInterface = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramArrayOfByte = (oidb_sso.OIDBSSOPkg)paramQQAppInterface.mergeFrom(paramArrayOfByte);
      paramQQAppInterface = paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
      i = paramQQAppInterface.uint32_result.get();
      if (i == 0) {
        break label117;
      }
      paramQQAppInterface = "oidb0x852_48 cResult=" + String.valueOf(i);
      if (!QLog.isColorLevel()) {
        break label115;
      }
      QLog.d("TroopNotificationHelper", 2, paramQQAppInterface);
      label115:
      return null;
    }
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.uint32_result.has())) {
      return null;
    }
    for (;;)
    {
      try
      {
        label117:
        paramQQAppInterface = new DataInputStream(new ByteArrayInputStream(paramQQAppInterface.bytes_bodybuffer.get().toByteArray()));
        paramQQAppInterface.readInt();
        paramQQAppInterface.readInt();
        int i = paramQQAppInterface.readShort();
        paramQQAppInterface.readShort();
        if (paramInt1 != 23) {
          break label275;
        }
        bool = true;
        paramQQAppInterface = a(paramQQAppInterface, bool);
        if (paramQQAppInterface != null)
        {
          if (paramInt1 == 23)
          {
            paramArrayOfByte = a(paramQQAppInterface, paramQQAppInterface.jdField_b_of_type_JavaLangString, i, paramInt2, paramLong2);
            if ((paramArrayOfByte == null) || (!TextUtils.isEmpty(paramArrayOfByte.title))) {
              break label272;
            }
            paramArrayOfByte.title = paramQQAppInterface.jdField_c_of_type_JavaLangString;
            break label272;
          }
          paramQQAppInterface = a(paramQQAppInterface, paramQQAppInterface.jdField_b_of_type_JavaLangString, 34, paramInt2, paramLong2);
          return paramQQAppInterface;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TroopNotificationHelper.class.getSimpleName(), 2, paramQQAppInterface.getMessage());
        }
      }
      return null;
      label272:
      return paramArrayOfByte;
      label275:
      boolean bool = false;
    }
  }
  
  public static TroopNotificationCache a(eph parameph, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    if (parameph != null)
    {
      if (parameph.jdField_c_of_type_Int == 1)
      {
        String str2 = a(parameph.jdField_c_of_type_JavaLangString);
        int i = str2.lastIndexOf('&');
        String str1 = str2;
        if (i != -1)
        {
          str1 = str2;
          if (str2.indexOf(";", i) == -1) {
            str1 = str2.substring(0, i - 1);
          }
        }
        str2 = a(parameph.jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty(parameph.jdField_a_of_type_JavaLangString))
        {
          str2 = new SimpleDateFormat("yyyy年M月d日").format(new Date(parameph.jdField_e_of_type_Int * 1000L));
          str2 = str2 + " 群公告";
        }
        paramString = String.format("http://web.qun.qq.com/mannounce/index.html?_wv=1031&amp;_bid=148#gc=%d&amp;feedType=%d&amp;gotoFid=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), paramString });
        TroopNotificationCache localTroopNotificationCache = new TroopNotificationCache();
        localTroopNotificationCache.title = parameph.jdField_a_of_type_JavaLangString;
        localTroopNotificationCache.feedType = paramInt1;
        localTroopNotificationCache.appId = paramInt2;
        localTroopNotificationCache.userUin = parameph.jdField_d_of_type_Int;
        localTroopNotificationCache.troopUin = paramLong;
        localTroopNotificationCache.time = parameph.jdField_e_of_type_Int;
        localTroopNotificationCache.feedsId = parameph.jdField_b_of_type_JavaLangString;
        localTroopNotificationCache.serviceID = 27;
        String str3 = new SimpleDateFormat("M-d HH:mm").format(new Date(localTroopNotificationCache.time * 1000L));
        if (TextUtils.isEmpty(parameph.jdField_d_of_type_JavaLangString)) {}
        for (localTroopNotificationCache.xmlBytes = String.format("<?xml version=\"1.0\" encoding=\"utf-8\" ?><msg action=\"web\" serviceID=\"27\" templateID=\"\" actionData=\"\" url=\"%s\" flag=\"5\" brief=\"%s\"><item layout=\"1\"><title size=\"30\" color=\"#000000\">[公告] %s</title><hr /><title size=\"22\" color=\"#000000\">%s</title><summary size=\"28\" color=\"#808080\">%s</summary></item></msg>", new Object[] { paramString, "", str2, str3, str1 }).getBytes();; localTroopNotificationCache.xmlBytes = String.format("<?xml version=\"1.0\" encoding=\"utf-8\" ?><msg action=\"web\" serviceID=\"27\" templateID=\"\" actionData=\"\" url=\"%s\" flag=\"5\" brief=\"%s\"><item layout=\"6\"><title size=\"30\" color=\"#000000\">[公告] %s</title><hr /></item><item layout=\"2\"><picture cover=\"%s\"/><title size=\"22\" color=\"#000000\">%s</title><summary size=\"28\" color=\"#808080\">%s</summary></item></msg>", new Object[] { paramString, "", str2, parameph.jdField_d_of_type_JavaLangString, str3, str1 }).getBytes()) {
          return localTroopNotificationCache;
        }
      }
      if (parameph.jdField_c_of_type_Int == 2)
      {
        paramString = new TroopNotificationCache();
        paramString.feedType = paramInt1;
        paramString.appId = paramInt2;
        paramString.userUin = parameph.jdField_d_of_type_Int;
        paramString.troopUin = paramLong;
        paramString.time = parameph.jdField_e_of_type_Int;
        paramString.feedsId = parameph.jdField_b_of_type_JavaLangString;
        paramString.ctrlStr = parameph.jdField_e_of_type_JavaLangString;
        paramString.xmlBytes = parameph.jdField_a_of_type_ArrayOfByte;
        paramString.src = parameph.f;
        paramString.filterID = parameph.jdField_a_of_type_Long;
        paramString.serviceID = 20;
        return paramString;
      }
    }
    return null;
  }
  
  public static eph a(DataInputStream paramDataInputStream, boolean paramBoolean)
  {
    paramDataInputStream.read();
    paramDataInputStream.readShort();
    paramDataInputStream.readShort();
    paramDataInputStream.readInt();
    int k = paramDataInputStream.readInt();
    byte[] arrayOfByte2 = new byte[32];
    Arrays.fill(arrayOfByte2, (byte)0);
    paramDataInputStream.read(arrayOfByte2);
    paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    int m = paramDataInputStream.readInt();
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
    paramDataInputStream.jdField_d_of_type_Int = k;
    paramDataInputStream.jdField_e_of_type_Int = m;
    return paramDataInputStream;
  }
  
  public static eph a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int j = 0;
    for (;;)
    {
      int i;
      long l1;
      try
      {
        localObject1 = new group_feeds.GroupFeedsMessage();
        ((group_feeds.GroupFeedsMessage)localObject1).mergeFrom(paramArrayOfByte);
        i = ((group_feeds.GroupFeedsMessage)localObject1).type.get();
        Object localObject5;
        if ((i == 5) || (i == 19))
        {
          Object localObject2 = ((group_feeds.GroupFeedsMessage)localObject1).content.get();
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
            i = ((group_feeds.GroupFeedsMessage.MessageContent)localObject2).type.get();
            if (i == 3)
            {
              localObject2 = String.format("http://gdynamic.qpic.cn/gdynamic/%s/72", new Object[] { ((group_feeds.GroupFeedsMessage.MessageContent)localObject2).pic_id.get().toStringUtf8() });
              localObject1 = paramArrayOfByte;
              paramArrayOfByte = (byte[])localObject2;
              break label710;
            }
            if (i == 0)
            {
              ((StringBuilder)localObject5).append(((group_feeds.GroupFeedsMessage.MessageContent)localObject2).value.get().toStringUtf8());
              localObject2 = paramArrayOfByte;
              paramArrayOfByte = (byte[])localObject1;
              localObject1 = localObject2;
              break label710;
            }
            if (i == 10)
            {
              localObject2 = ((group_feeds.GroupFeedsMessage.MessageContent)localObject2).value.get().toStringUtf8();
              paramArrayOfByte = (byte[])localObject1;
              localObject1 = localObject2;
              break label710;
            }
            if (i != 2) {
              break label700;
            }
            i = ((group_feeds.GroupFeedsMessage.MessageContent)localObject2).face_idx.get();
            if (i >= 0) {}
            try
            {
              if (i < jdField_a_of_type_ArrayOfInt.length)
              {
                localObject2 = jdField_a_of_type_ArrayOfJavaLangString[i];
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
          localObject5 = new eph(null);
          ((eph)localObject5).jdField_a_of_type_JavaLangString = paramArrayOfByte;
          ((eph)localObject5).jdField_b_of_type_JavaLangString = paramString;
          ((eph)localObject5).jdField_c_of_type_JavaLangString = ((String)localObject3);
          ((eph)localObject5).jdField_d_of_type_JavaLangString = ((String)localObject1);
          ((eph)localObject5).jdField_c_of_type_Int = 1;
          return localObject5;
        }
        if (i == 22)
        {
          localObject5 = ((group_feeds.GroupFeedsMessage)localObject1).content.get().iterator();
          localObject1 = null;
          paramArrayOfByte = null;
          if (((Iterator)localObject5).hasNext())
          {
            localObject3 = (group_feeds.GroupFeedsMessage.MessageContent)((Iterator)localObject5).next();
            i = ((group_feeds.GroupFeedsMessage.MessageContent)localObject3).type.get();
            if (i == 0)
            {
              localObject3 = ((group_feeds.GroupFeedsMessage.MessageContent)localObject3).value.get().toByteArray();
              paramArrayOfByte = (byte[])localObject1;
              localObject1 = localObject3;
              break label723;
            }
            if (i != 14) {
              break label687;
            }
            localObject1 = ((group_feeds.GroupFeedsMessage.MessageContent)localObject3).value.get().toStringUtf8();
            localObject3 = paramArrayOfByte;
            paramArrayOfByte = (byte[])localObject1;
            localObject1 = localObject3;
            break label723;
          }
          l2 = 0L;
          l1 = l2;
        }
      }
      catch (Exception paramString)
      {
        Object localObject3;
        if (QLog.isColorLevel()) {
          QLog.d(TroopNotificationCache.class.getSimpleName(), 2, paramString.getMessage());
        }
      }
      try
      {
        localObject3 = new JSONObject((String)localObject1);
        l1 = l2;
        if (!((JSONObject)localObject3).has(jdField_b_of_type_JavaLangString)) {
          break label679;
        }
        l1 = l2;
        if (((JSONObject)localObject3).getInt(jdField_b_of_type_JavaLangString) != jdField_a_of_type_Int) {
          break label679;
        }
        l1 = l2;
        localObject3 = ((JSONObject)localObject3).getJSONObject(jdField_c_of_type_JavaLangString);
        l1 = l2;
        l2 = ((JSONObject)localObject3).getLong(g);
        l1 = l2;
        i = ((JSONObject)localObject3).getInt(h);
        l1 = l2;
      }
      catch (JSONException localJSONException)
      {
        i = j;
        l2 = l1;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("TroopNotificationHelper", 4, "decodeToFeedItem--JSONException");
        i = j;
        l2 = l1;
        continue;
        i = 0;
        l1 = 0L;
        continue;
      }
      long l2 = l1;
      localObject3 = new eph(null);
      ((eph)localObject3).jdField_b_of_type_JavaLangString = paramString;
      ((eph)localObject3).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      ((eph)localObject3).jdField_e_of_type_JavaLangString = ((String)localObject1);
      ((eph)localObject3).jdField_c_of_type_Int = 2;
      ((eph)localObject3).jdField_a_of_type_Long = l2;
      ((eph)localObject3).f = i;
      return localObject3;
      return null;
      label679:
      label687:
      Object localObject4 = paramArrayOfByte;
      paramArrayOfByte = (byte[])localObject1;
      Object localObject1 = localObject4;
      break label723;
      label700:
      localObject4 = localObject1;
      localObject1 = paramArrayOfByte;
      paramArrayOfByte = (byte[])localObject4;
      label710:
      localObject4 = localObject1;
      localObject1 = paramArrayOfByte;
      paramArrayOfByte = (byte[])localObject4;
      continue;
      label723:
      localObject4 = localObject1;
      localObject1 = paramArrayOfByte;
      paramArrayOfByte = (byte[])localObject4;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return "";
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return a(a(a(a(a(paramString, "&", "&amp;"), "<", "&lt;"), ">", "&gt;"), "'", "&apos;"), "\"", "&quot;");
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
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
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    localXmlSerializer.setOutput(localByteArrayOutputStream, "utf-8");
    localXmlSerializer.startDocument("utf-8", Boolean.valueOf(true));
    localXmlSerializer.startTag(null, "msg");
    localXmlSerializer.attribute(null, "action", "web");
    localXmlSerializer.attribute(null, "serviceID", "27");
    localXmlSerializer.attribute(null, "url", paramString4);
    localXmlSerializer.attribute(null, "flag", "5");
    localXmlSerializer.attribute(null, "brief", MessageUtils.a(paramString1, false));
    localXmlSerializer.startTag(null, "item");
    localXmlSerializer.attribute(null, "layout", "6");
    localXmlSerializer.startTag(null, "title");
    localXmlSerializer.text("群公告");
    localXmlSerializer.endTag(null, "title");
    localXmlSerializer.startTag(null, "hr");
    localXmlSerializer.endTag(null, "hr");
    if (!TextUtils.isEmpty(paramString5))
    {
      localXmlSerializer.endTag(null, "item");
      localXmlSerializer.startTag(null, "item");
      localXmlSerializer.attribute(null, "layout", "2");
    }
    if (!TextUtils.isEmpty(paramString5))
    {
      localXmlSerializer.startTag(null, "picture");
      localXmlSerializer.attribute(null, "cover", paramString5);
      localXmlSerializer.endTag(null, "picture");
    }
    localXmlSerializer.startTag(null, "title");
    localXmlSerializer.text(MessageUtils.a(paramString2, false));
    localXmlSerializer.endTag(null, "title");
    localXmlSerializer.startTag(null, "summary");
    localXmlSerializer.text(MessageUtils.a(paramString3, false));
    localXmlSerializer.endTag(null, "summary");
    localXmlSerializer.endTag(null, "item");
    localXmlSerializer.endTag(null, "msg");
    localXmlSerializer.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public static void a(TroopNotificationCache paramTroopNotificationCache, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface.b(paramTroopNotificationCache);
    paramQQAppInterface.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "initTroopNotificationFlag");
    }
    jdField_c_of_type_JavaUtilHashMap.clear();
    jdField_b_of_type_JavaUtilHashMap.clear();
    jdField_d_of_type_JavaUtilHashMap.clear();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    Cursor localCursor = paramQQAppInterface.a(true, TroopNotificationCache.class.getSimpleName(), new String[] { "troopUin", "feedType", "serviceID" }, "read=?", new String[] { String.valueOf(0) }, "troopUin", null, null, null);
    long l;
    if (localCursor != null) {
      if (localCursor.moveToFirst())
      {
        localCursor.getColumnIndex("troopUin");
        i = localCursor.getColumnIndex("serviceID");
        if (i != -1)
        {
          l = localCursor.getLong(i);
          i = localCursor.getColumnIndex("serviceID");
          if (i == -1) {
            break label313;
          }
        }
      }
    }
    label313:
    for (int i = localCursor.getInt(i);; i = 27)
    {
      localHashMap1.put(String.valueOf(l), Boolean.valueOf(true));
      if (i == 27) {
        localHashMap3.put(String.valueOf(l), Boolean.valueOf(true));
      }
      i = localCursor.getColumnIndex("feedType");
      if ((i != -1) && (localCursor.getInt(i) == 34)) {
        localHashMap2.put(String.valueOf(l), Boolean.valueOf(true));
      }
      if (localCursor.moveToNext()) {
        break;
      }
      localCursor.close();
      paramQQAppInterface.a();
      jdField_c_of_type_JavaUtilHashMap = localHashMap1;
      jdField_b_of_type_JavaUtilHashMap = localHashMap3;
      jdField_d_of_type_JavaUtilHashMap = localHashMap2;
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString1, int paramInt2, String paramString2, short paramShort, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "send0x580Cmd");
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramQQAppInterface.a(), "OidbSvc.0x580_1");
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
      paramQQAppInterface.a(localToServiceMsg);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TroopNotificationHelper.class.getSimpleName(), 2, localException.getMessage());
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString1, int paramInt2, String paramString2, short paramShort, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean2) && (jdField_a_of_type_JavaUtilHashMap != null) && (jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong2))))
    {
      byte[] arrayOfByte = (byte[])jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong2));
      short s = (short)arrayOfByte.length;
      if ("OidbSvc.0x852_35".equals(paramString2))
      {
        jdField_e_of_type_JavaUtilHashMap.put(paramString1, Boolean.valueOf(true));
        a(paramQQAppInterface, paramInt1, paramLong1, paramLong2, s, arrayOfByte, paramLong3, paramString1, paramInt2);
      }
      while (!"OidbSvc.0x852_48".equals(paramString2)) {
        return;
      }
      a(paramQQAppInterface, paramInt1, paramLong1, paramLong2, s, arrayOfByte, paramShort, paramBoolean1);
      return;
    }
    if ("OidbSvc.0x852_35".equals(paramString2)) {
      jdField_e_of_type_JavaUtilHashMap.put(paramString1, Boolean.valueOf(true));
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
        jdField_e_of_type_JavaUtilHashMap.remove(paramString);
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
        jdField_e_of_type_JavaUtilHashMap.remove(paramString);
        return;
      }
    }
    try
    {
      paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte.bytes_bodybuffer.get().toByteArray()));
      paramArrayOfByte.readInt();
      paramArrayOfByte = a(paramArrayOfByte, false);
      if (paramArrayOfByte == null) {
        break label266;
      }
      if ((paramArrayOfByte.jdField_c_of_type_Int != 1) && (paramArrayOfByte.jdField_c_of_type_Int != 2)) {
        break label299;
      }
      paramArrayOfByte = a(paramArrayOfByte, paramString, 23, paramInt1, paramLong2);
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        ArrayList localArrayList;
        if (QLog.isColorLevel())
        {
          QLog.d(TroopNotificationHelper.class.getSimpleName(), 2, paramQQAppInterface.getMessage());
          continue;
          paramArrayOfByte = null;
        }
      }
    }
    localObject = paramQQAppInterface.a();
    localArrayList = new ArrayList();
    localArrayList.add(paramArrayOfByte);
    paramInt1 = (int)MessageCache.a();
    ((QQMessageFacade)localObject).a().a(paramQQAppInterface, String.valueOf(paramLong1), String.valueOf(paramLong2), localArrayList, 23, paramInt1);
    label266:
    jdField_e_of_type_JavaUtilHashMap.remove(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong1, long paramLong2, short paramShort, byte[] paramArrayOfByte, long paramLong3, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "send get notices");
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramQQAppInterface.a(), "OidbSvc.0x852_35");
    paramArrayOfByte = a(paramLong2, paramShort, paramArrayOfByte, paramString);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2130);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(35);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localToServiceMsg.putWupBuffer(localOIDBSSOPkg.toByteArray());
    localToServiceMsg.extraData.putInt("appId", paramInt1);
    localToServiceMsg.extraData.putLong("troopUin", paramLong1);
    localToServiceMsg.extraData.putLong("troopCode", paramLong2);
    localToServiceMsg.extraData.putLong("userUin", paramLong3);
    localToServiceMsg.extraData.putString("feedsId", paramString);
    localToServiceMsg.extraData.putInt("time", paramInt2);
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    paramQQAppInterface.a(localToServiceMsg);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong1, long paramLong2, short paramShort1, byte[] paramArrayOfByte, short paramShort2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "send get troop guide");
    }
    int i = (short)47;
    i = (int)paramLong2;
    Object localObject1 = paramQQAppInterface.a();
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
          localObject1 = new ToServiceMsg("mobileqq.service", paramQQAppInterface.a(), "OidbSvc.0x852_48");
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
          paramQQAppInterface.a((ToServiceMsg)localObject1);
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
        QLog.d(TroopNotificationHelper.class.getSimpleName(), 2, paramQQAppInterface.getMessage());
      }
    }
    j = (int)(System.currentTimeMillis() / 1000L);
    k = (int)(System.currentTimeMillis() / 1000L);
    arrayOfByte = new byte[16];
    m = 47 + paramShort1;
    n = (short)m;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = (FriendsManagerImp)paramQQAppInterface.getManager(8);
    List localList = ((FriendsManagerImp)localObject).b(paramString);
    if ((localList != null) && (localList.size() > 0) && (QLog.isColorLevel())) {
      QLog.d("TroopNotificationHelper", 2, "readTroopNotification--->troopNotificationCaches size:" + localList.size());
    }
    ((FriendsManagerImp)localObject).j(paramString);
    if (!TroopAssistantManager.a().a(paramQQAppInterface, paramString))
    {
      paramQQAppInterface = paramQQAppInterface.a().a();
      localObject = paramQQAppInterface.a(paramString, 1);
      ((RecentUser)localObject).cleanMsgAndMsgData(((RecentUser)localObject).msgType);
      paramQQAppInterface.a((RecentUser)localObject);
    }
    a(paramString);
    c(paramString);
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, String paramString, List paramList)
  {
    // Byte code:
    //   0: new 955	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 956	java/util/ArrayList:<init>	()V
    //   7: astore 15
    //   9: new 955	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 956	java/util/ArrayList:<init>	()V
    //   16: astore 16
    //   18: new 955	java/util/ArrayList
    //   21: dup
    //   22: invokespecial 956	java/util/ArrayList:<init>	()V
    //   25: astore 17
    //   27: aload_2
    //   28: invokeinterface 603 1 0
    //   33: astore_2
    //   34: aload_2
    //   35: invokeinterface 608 1 0
    //   40: ifeq +666 -> 706
    //   43: aload_2
    //   44: invokeinterface 612 1 0
    //   49: checkcast 416	com/tencent/mobileqq/activity/TroopNotificationCache
    //   52: astore 18
    //   54: invokestatic 1064	com/tencent/mobileqq/service/message/MessageUtils:a	()I
    //   57: istore 7
    //   59: getstatic 1067	com/tencent/mobileqq/service/MobileQQService:jdField_c_of_type_Int	I
    //   62: istore_3
    //   63: iload_3
    //   64: iconst_1
    //   65: iadd
    //   66: putstatic 1067	com/tencent/mobileqq/service/MobileQQService:jdField_c_of_type_Int	I
    //   69: iload_3
    //   70: i2l
    //   71: lstore 11
    //   73: invokestatic 964	com/tencent/mobileqq/service/message/MessageCache:a	()J
    //   76: l2i
    //   77: istore 8
    //   79: sipush -2021
    //   82: invokestatic 1072	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   85: checkcast 1074	com/tencent/mobileqq/data/MessageForTroopNotification
    //   88: astore 19
    //   90: aload 19
    //   92: lconst_0
    //   93: putfield 1077	com/tencent/mobileqq/data/MessageForTroopNotification:shmsgseq	J
    //   96: aload 19
    //   98: sipush -2021
    //   101: putfield 1080	com/tencent/mobileqq/data/MessageForTroopNotification:msgtype	I
    //   104: aload 18
    //   106: getfield 530	com/tencent/mobileqq/activity/TroopNotificationCache:xmlBytes	[B
    //   109: ifnull -75 -> 34
    //   112: iconst_0
    //   113: istore 4
    //   115: iconst_0
    //   116: istore 5
    //   118: aload 18
    //   120: getfield 516	com/tencent/mobileqq/activity/TroopNotificationCache:serviceID	I
    //   123: bipush 27
    //   125: if_icmpne +73 -> 198
    //   128: iconst_0
    //   129: istore_3
    //   130: aload 19
    //   132: aload 18
    //   134: getfield 530	com/tencent/mobileqq/activity/TroopNotificationCache:xmlBytes	[B
    //   137: iload_3
    //   138: invokestatic 1085	com/tencent/mobileqq/structmsg/StructMsgFactory:a	([BI)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   141: putfield 1089	com/tencent/mobileqq/data/MessageForTroopNotification:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   144: aload 19
    //   146: getfield 1089	com/tencent/mobileqq/data/MessageForTroopNotification:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   149: ifnonnull +439 -> 588
    //   152: invokestatic 328	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq -121 -> 34
    //   158: ldc 10
    //   160: iconst_2
    //   161: new 358	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 359	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 1091
    //   171: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: new 41	java/lang/String
    //   177: dup
    //   178: aload 18
    //   180: getfield 530	com/tencent/mobileqq/activity/TroopNotificationCache:xmlBytes	[B
    //   183: invokespecial 565	java/lang/String:<init>	([B)V
    //   186: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 373	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 333	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: goto -161 -> 34
    //   198: iload 5
    //   200: istore_3
    //   201: aload 18
    //   203: getfield 516	com/tencent/mobileqq/activity/TroopNotificationCache:serviceID	I
    //   206: bipush 20
    //   208: if_icmpne -78 -> 130
    //   211: iload 5
    //   213: istore_3
    //   214: aload 18
    //   216: getfield 536	com/tencent/mobileqq/activity/TroopNotificationCache:ctrlStr	Ljava/lang/String;
    //   219: ifnull -89 -> 130
    //   222: new 641	org/json/JSONObject
    //   225: dup
    //   226: aload 18
    //   228: getfield 536	com/tencent/mobileqq/activity/TroopNotificationCache:ctrlStr	Ljava/lang/String;
    //   231: invokespecial 642	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   234: astore 20
    //   236: iload 5
    //   238: istore_3
    //   239: aload 20
    //   241: getstatic 285	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   244: invokevirtual 645	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   247: ifeq -117 -> 130
    //   250: iload 5
    //   252: istore_3
    //   253: aload 20
    //   255: getstatic 285	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   258: invokevirtual 649	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   261: getstatic 291	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:jdField_a_of_type_Int	I
    //   264: if_icmpne -134 -> 130
    //   267: aload 20
    //   269: getstatic 289	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   272: invokevirtual 653	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   275: astore 20
    //   277: aload 20
    //   279: getstatic 295	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   282: invokevirtual 649	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   285: istore_3
    //   286: getstatic 297	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:jdField_b_of_type_Int	I
    //   289: istore 5
    //   291: iload_3
    //   292: iload 5
    //   294: if_icmpne +97 -> 391
    //   297: iconst_1
    //   298: istore_3
    //   299: aload 20
    //   301: getstatic 301	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   304: invokevirtual 1094	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   307: astore 21
    //   309: aload 21
    //   311: invokestatic 1097	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   314: lstore 13
    //   316: invokestatic 964	com/tencent/mobileqq/service/message/MessageCache:a	()J
    //   319: lload 13
    //   321: lcmp
    //   322: ifle +84 -> 406
    //   325: aload 18
    //   327: aload_0
    //   328: invokestatic 1099	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:a	(Lcom/tencent/mobileqq/activity/TroopNotificationCache;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   331: goto -297 -> 34
    //   334: astore 20
    //   336: iload_3
    //   337: istore 4
    //   339: iload 4
    //   341: istore_3
    //   342: invokestatic 660	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   345: ifeq -215 -> 130
    //   348: ldc 10
    //   350: iconst_4
    //   351: new 358	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 359	java/lang/StringBuilder:<init>	()V
    //   358: ldc_w 1091
    //   361: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: new 41	java/lang/String
    //   367: dup
    //   368: aload 18
    //   370: getfield 530	com/tencent/mobileqq/activity/TroopNotificationCache:xmlBytes	[B
    //   373: invokespecial 565	java/lang/String:<init>	([B)V
    //   376: invokevirtual 365	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: invokevirtual 373	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 333	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: iload 4
    //   387: istore_3
    //   388: goto -258 -> 130
    //   391: iconst_0
    //   392: istore_3
    //   393: goto -94 -> 299
    //   396: astore 20
    //   398: aload 20
    //   400: invokevirtual 1100	java/lang/NumberFormatException:printStackTrace	()V
    //   403: goto -369 -> 34
    //   406: aload 20
    //   408: getstatic 305	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:f	Ljava/lang/String;
    //   411: invokevirtual 649	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   414: istore 6
    //   416: aload 20
    //   418: getstatic 311	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:g	Ljava/lang/String;
    //   421: invokevirtual 1094	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   424: astore 21
    //   426: aload 20
    //   428: getstatic 315	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:h	Ljava/lang/String;
    //   431: invokevirtual 649	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   434: istore 9
    //   436: iconst_0
    //   437: istore 5
    //   439: iconst_0
    //   440: istore 4
    //   442: iload 6
    //   444: getstatic 307	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:jdField_c_of_type_Int	I
    //   447: if_icmpne +138 -> 585
    //   450: iload 5
    //   452: istore 6
    //   454: aload 16
    //   456: iload 9
    //   458: invokestatic 488	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   461: invokevirtual 1103	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   464: ifeq +88 -> 552
    //   467: iload 5
    //   469: istore 6
    //   471: aload 17
    //   473: aload 21
    //   475: invokevirtual 1103	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   478: ifeq +74 -> 552
    //   481: aload 16
    //   483: invokevirtual 1104	java/util/ArrayList:size	()I
    //   486: aload 17
    //   488: invokevirtual 1104	java/util/ArrayList:size	()I
    //   491: invokestatic 1110	java/lang/Math:min	(II)I
    //   494: istore 10
    //   496: iconst_0
    //   497: istore 5
    //   499: iload 4
    //   501: istore 6
    //   503: iload 5
    //   505: iload 10
    //   507: if_icmpge +45 -> 552
    //   510: aload 16
    //   512: iload 5
    //   514: invokevirtual 1113	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   517: checkcast 485	java/lang/Integer
    //   520: invokevirtual 1116	java/lang/Integer:intValue	()I
    //   523: iload 9
    //   525: if_icmpne +200 -> 725
    //   528: aload 17
    //   530: iload 5
    //   532: invokevirtual 1113	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   535: checkcast 41	java/lang/String
    //   538: aload 21
    //   540: invokevirtual 929	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   543: ifeq +182 -> 725
    //   546: iconst_1
    //   547: istore 4
    //   549: goto +176 -> 725
    //   552: iload 6
    //   554: ifeq +12 -> 566
    //   557: aload 18
    //   559: aload_0
    //   560: invokestatic 1099	com/tencent/mobileqq/troop/utils/TroopNotificationHelper:a	(Lcom/tencent/mobileqq/activity/TroopNotificationCache;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   563: goto -529 -> 34
    //   566: aload 16
    //   568: iload 9
    //   570: invokestatic 488	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   573: invokevirtual 959	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   576: pop
    //   577: aload 17
    //   579: aload 21
    //   581: invokevirtual 959	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   584: pop
    //   585: goto -455 -> 130
    //   588: aload 19
    //   590: aload 19
    //   592: getfield 1089	com/tencent/mobileqq/data/MessageForTroopNotification:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   595: invokevirtual 1119	com/tencent/mobileqq/structmsg/AbsStructMsg:getBytes	()[B
    //   598: putfield 1122	com/tencent/mobileqq/data/MessageForTroopNotification:msgData	[B
    //   601: aload 19
    //   603: ldc_w 1124
    //   606: putfield 1126	com/tencent/mobileqq/data/MessageForTroopNotification:msg	Ljava/lang/String;
    //   609: aload 19
    //   611: aload_1
    //   612: putfield 1129	com/tencent/mobileqq/data/MessageForTroopNotification:frienduin	Ljava/lang/String;
    //   615: aload 19
    //   617: iconst_1
    //   618: putfield 1132	com/tencent/mobileqq/data/MessageForTroopNotification:istroop	I
    //   621: aload 19
    //   623: iconst_1
    //   624: putfield 1136	com/tencent/mobileqq/data/MessageForTroopNotification:isread	Z
    //   627: aload 19
    //   629: iload 8
    //   631: i2l
    //   632: putfield 1138	com/tencent/mobileqq/data/MessageForTroopNotification:time	J
    //   635: aload 19
    //   637: lload 11
    //   639: putfield 1141	com/tencent/mobileqq/data/MessageForTroopNotification:msgseq	J
    //   642: aload 19
    //   644: iload 7
    //   646: invokestatic 1143	com/tencent/mobileqq/service/message/MessageUtils:a	(I)J
    //   649: putfield 1146	com/tencent/mobileqq/data/MessageForTroopNotification:msgUid	J
    //   652: aload 15
    //   654: aload 19
    //   656: invokevirtual 959	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   659: pop
    //   660: aconst_null
    //   661: ldc_w 1148
    //   664: ldc_w 1150
    //   667: ldc_w 523
    //   670: ldc_w 1152
    //   673: ldc_w 1154
    //   676: iconst_0
    //   677: iconst_0
    //   678: aload 19
    //   680: getfield 1155	com/tencent/mobileqq/data/MessageForTroopNotification:troopUin	J
    //   683: invokestatic 823	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   686: aload 18
    //   688: getfield 495	com/tencent/mobileqq/activity/TroopNotificationCache:feedType	I
    //   691: invokestatic 369	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   694: ldc_w 523
    //   697: ldc_w 523
    //   700: invokestatic 1160	com/tencent/mobileqq/statistics/ReportController:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   703: goto -669 -> 34
    //   706: aload_0
    //   707: invokevirtual 953	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   710: aload 15
    //   712: aload_0
    //   713: invokevirtual 842	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   716: invokevirtual 1163	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/util/List;Ljava/lang/String;)V
    //   719: return
    //   720: astore 20
    //   722: goto -383 -> 339
    //   725: iload 5
    //   727: iconst_1
    //   728: iadd
    //   729: istore 5
    //   731: goto -232 -> 499
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	734	0	paramQQAppInterface	QQAppInterface
    //   0	734	1	paramString	String
    //   0	734	2	paramList	List
    //   62	331	3	i	int
    //   113	435	4	j	int
    //   116	614	5	k	int
    //   414	139	6	m	int
    //   57	588	7	n	int
    //   77	553	8	i1	int
    //   434	135	9	i2	int
    //   494	14	10	i3	int
    //   71	567	11	l1	long
    //   314	6	13	l2	long
    //   7	704	15	localArrayList1	ArrayList
    //   16	551	16	localArrayList2	ArrayList
    //   25	553	17	localArrayList3	ArrayList
    //   52	635	18	localTroopNotificationCache	TroopNotificationCache
    //   88	591	19	localMessageForTroopNotification	com.tencent.mobileqq.data.MessageForTroopNotification
    //   234	66	20	localJSONObject	JSONObject
    //   334	1	20	localJSONException1	JSONException
    //   396	31	20	localNumberFormatException	NumberFormatException
    //   720	1	20	localJSONException2	JSONException
    //   307	273	21	str	String
    // Exception table:
    //   from	to	target	type
    //   299	309	334	org/json/JSONException
    //   309	316	334	org/json/JSONException
    //   316	331	334	org/json/JSONException
    //   398	403	334	org/json/JSONException
    //   406	436	334	org/json/JSONException
    //   442	450	334	org/json/JSONException
    //   454	467	334	org/json/JSONException
    //   471	496	334	org/json/JSONException
    //   510	546	334	org/json/JSONException
    //   557	563	334	org/json/JSONException
    //   566	585	334	org/json/JSONException
    //   309	316	396	java/lang/NumberFormatException
    //   222	236	720	org/json/JSONException
    //   239	250	720	org/json/JSONException
    //   253	291	720	org/json/JSONException
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, List paramList, int paramInt)
  {
    Object localObject = paramQQAppInterface.a().createEntityManager();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      TroopNotificationCache localTroopNotificationCache = (TroopNotificationCache)paramList.next();
      localTroopNotificationCache.read = false;
      localTroopNotificationCache.currentUin = paramQQAppInterface.a();
      ((EntityManager)localObject).a(localTroopNotificationCache);
      if (localTroopNotificationCache.serviceID != 27) {
        break label269;
      }
      i = 1;
    }
    label269:
    for (;;)
    {
      break;
      ((EntityManager)localObject).a();
      if (TroopAssistantManager.a().a(paramQQAppInterface, paramString))
      {
        d(paramString);
        paramQQAppInterface = paramQQAppInterface.a(TroopAssistantActivity.class);
        if ((paramQQAppInterface != null) && (i != 0))
        {
          b(paramString);
          paramQQAppInterface.sendEmptyMessage(1);
        }
      }
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "save tips on conversations");
          }
          d(paramString);
          paramList = paramQQAppInterface.a(Conversation.class);
        } while ((paramList == null) || (i == 0));
        paramQQAppInterface = paramQQAppInterface.a();
        paramString = paramQQAppInterface.a().a(paramString, 1);
      } while (((paramString.msg instanceof TroopSpecialAttentionMsg)) || ((paramString.msg instanceof TroopAtMeMsg)) || ((paramString.msg instanceof TroopAtAllMsg)));
      localObject = RecentDataListManager.a(paramString.uin, paramString.type);
      RecentDataListManager.a().a((String)localObject);
      paramString.msgType = 1;
      paramString.msg = new TroopNotificationMsg(BaseApplication.getContext());
      paramString.lastmsgtime = paramInt;
      paramQQAppInterface.a().a(paramString);
      paramList.sendEmptyMessage(1009);
      return;
    }
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "setReadNewTroopNotification");
    }
    jdField_b_of_type_JavaUtilHashMap.remove(paramString);
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    if ((paramString == null) || (paramQQAppInterface == null)) {}
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
        paramString = paramQQAppInterface.a(TroopNotificationCache.class, TroopNotificationCache.class.getSimpleName(), false, "troopUin=?", new String[] { paramString }, null, null, null, null);
      } while (paramString == null);
      while (i < paramString.size())
      {
        paramQQAppInterface.b((TroopNotificationCache)paramString.get(i));
        i += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopNotificationHelper", 2, TroopNotificationHelper.class.getSimpleName() + "-->clearTroopNotification");
  }
  
  public static boolean a(String paramString)
  {
    if (jdField_b_of_type_JavaUtilHashMap.containsKey(paramString)) {
      return ((Boolean)jdField_b_of_type_JavaUtilHashMap.get(paramString)).booleanValue();
    }
    return false;
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
        QLog.d(TroopNotificationHelper.class.getSimpleName(), 2, paramArrayOfByte.getMessage());
      }
    }
    return null;
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt2, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TroopNotificationHelper.class.getSimpleName(), 2, "handGetTroopAuth");
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
        break label133;
      }
      if (!QLog.isColorLevel()) {
        break label122;
      }
      QLog.d("TroopNotificationHelper", 2, "0x580 cResult=" + paramInt1);
      label122:
      jdField_e_of_type_JavaUtilHashMap.remove(paramString);
      return null;
      try
      {
        label133:
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
        jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong2), paramArrayOfByte);
        paramString.close();
        paramQQAppInterface.close();
        return paramArrayOfByte;
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          break label278;
        }
        QLog.d(TroopNotificationHelper.class.getSimpleName(), 2, paramQQAppInterface.getMessage());
      }
    }
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.uint32_result.has()))
    {
      jdField_e_of_type_JavaUtilHashMap.remove(paramString);
      return null;
    }
    label278:
    return null;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    TroopNotificationCache localTroopNotificationCache = new TroopNotificationCache();
    localTroopNotificationCache.appId = 123;
    localTroopNotificationCache.feedsId = "234";
    localTroopNotificationCache.time = ((int)MessageCache.a());
    localTroopNotificationCache.troopUin = 265013133L;
    localTroopNotificationCache.xmlBytes = "<msg templateID=\"\"     url=\"http://www.baidu.com\"     serviceID=\"27\"     action=\"web\"     actionData=\"\"     a_actionData=\"\"     i_actionData=\"\"     brief=\"群公告\"     flag=\"5\">  <item layout=\"2\">    <picture cover=\"http://www.baidu.com\"/>    <title>[群公告更新]群公告标题</title>    <summary>群公告内容…………</summary>  </item></msg>".getBytes();
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localTroopNotificationCache);
    int i = (int)MessageCache.a();
    localQQMessageFacade.a().a(paramQQAppInterface, String.valueOf(localTroopNotificationCache.troopUin), String.valueOf(localTroopNotificationCache.troopUin), localArrayList, 23, i);
    paramQQAppInterface = paramQQAppInterface.a(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(1009);
    }
    b(String.valueOf(localTroopNotificationCache.troopUin));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((jdField_a_of_type_JavaUtilHashMap != null) && (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)))
    {
      byte[] arrayOfByte = (byte[])jdField_a_of_type_JavaUtilHashMap.get(paramString);
      ((TroopHandler)paramQQAppInterface.a(17)).a(paramQQAppInterface, paramString, arrayOfByte);
      return;
    }
    try
    {
      a(paramQQAppInterface, 0, Long.parseLong(paramString), Long.parseLong(paramString), Long.parseLong(paramQQAppInterface.a()), "", (int)System.currentTimeMillis(), "OidbSvc.0x8ca_2", (short)0, true);
      return;
    }
    catch (NumberFormatException paramQQAppInterface) {}catch (Exception paramQQAppInterface) {}
  }
  
  public static void b(String paramString)
  {
    jdField_b_of_type_JavaUtilHashMap.put(paramString, Boolean.valueOf(true));
  }
  
  public static boolean b(String paramString)
  {
    if (jdField_c_of_type_JavaUtilHashMap.containsKey(paramString)) {
      return ((Boolean)jdField_c_of_type_JavaUtilHashMap.get(paramString)).booleanValue();
    }
    return false;
  }
  
  public static void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "setReadNewTroopNotification");
    }
    jdField_c_of_type_JavaUtilHashMap.remove(paramString);
  }
  
  public static boolean c(String paramString)
  {
    if (jdField_e_of_type_JavaUtilHashMap.containsKey(paramString)) {
      return ((Boolean)jdField_e_of_type_JavaUtilHashMap.get(paramString)).booleanValue();
    }
    return false;
  }
  
  public static void d(String paramString)
  {
    jdField_c_of_type_JavaUtilHashMap.put(paramString, Boolean.valueOf(true));
  }
  
  public static boolean d(String paramString)
  {
    if (jdField_d_of_type_JavaUtilHashMap.containsKey(paramString)) {
      return ((Boolean)jdField_d_of_type_JavaUtilHashMap.get(paramString)).booleanValue();
    }
    return false;
  }
  
  public static void e(String paramString)
  {
    jdField_d_of_type_JavaUtilHashMap.remove(paramString);
  }
  
  public static void f(String paramString)
  {
    jdField_d_of_type_JavaUtilHashMap.put(paramString, Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopNotificationHelper
 * JD-Core Version:    0.7.0.1
 */