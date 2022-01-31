package com.tencent.mobileqq.troop.utils;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x857.TroopTips0x857.AIOGrayTipsInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.NotifyMsgBody;

public class TroopTipsMsgMgr
  implements Manager
{
  protected static final String a;
  protected static HashMap a;
  protected static final String b = "<([^>])+";
  protected static final String c = "<{text:'A',action:'',url:'',url_p:'schemel://xxx',actionData:'action:xxxx',actionData_i:'',actionData_a:''}>给用户<{text:'B',action:'',url:'',url_p:'schemel://xxx',actionData:'action:xxxx',actionData_i:'',actionData_a:''}>送了一朵<{icon:'/rose',url:'url.qq.com?rose.png',alt:'玫瑰'}>";
  protected QQAppInterface a;
  
  static
  {
    jdField_a_of_type_JavaLangString = TroopTipsMsgMgr.class.getSimpleName();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public TroopTipsMsgMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private MessageForGrayTips a(TroopTipsEntity paramTroopTipsEntity)
  {
    if (paramTroopTipsEntity == null) {
      return null;
    }
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(2024);
    localMessageForGrayTips.frienduin = paramTroopTipsEntity.troopUin;
    localMessageForGrayTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramTroopTipsEntity.troopUin, paramTroopTipsEntity.troopUin, paramTroopTipsEntity.optContent, paramTroopTipsEntity.time, 2024, 1, paramTroopTipsEntity.msgSeq);
    if (paramTroopTipsEntity.highlightNum != 0) {}
    for (;;)
    {
      Bundle localBundle;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramTroopTipsEntity.highlightItems);
        int i = 0;
        int k;
        int m;
        String str1;
        if (i < localJSONArray.length())
        {
          localObject2 = localJSONArray.getJSONObject(i);
          k = ((JSONObject)localObject2).getInt("startIndex");
          m = ((JSONObject)localObject2).getInt("endIndex");
          if (!((JSONObject)localObject2).has("cmd")) {
            break label374;
          }
          j = ((JSONObject)localObject2).getInt("cmd");
          if (!((JSONObject)localObject2).has("data")) {
            break label368;
          }
          str1 = ((JSONObject)localObject2).getString("data");
          if (!((JSONObject)localObject2).has("data_a")) {
            break label362;
          }
          str2 = ((JSONObject)localObject2).getString("data_a");
          if (!((JSONObject)localObject2).has("url")) {
            break label359;
          }
          str1 = ((JSONObject)localObject2).getString("url");
          localBundle = new Bundle();
          localBundle.putInt("key_action", j);
          localObject2 = localBundle;
        }
        switch (j)
        {
        case 4: 
          localMessageForGrayTips.addHightlightItem(k, m, (Bundle)localObject2);
          i += 1;
          break;
        case 1: 
        case 2: 
        case 3: 
          localBundle.putString("key_action_DATA", str1);
          localBundle.putString("key_a_action_DATA", str2);
          localObject2 = localBundle;
          continue;
          if (paramTroopTipsEntity.optShowLatest != 1) {
            break label326;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "addGrayTips==>JSONException");
        }
      }
      localMessageForGrayTips.shmsgseq = 0L;
      label326:
      localMessageForGrayTips.isread = true;
      return localMessageForGrayTips;
      localBundle.putString("troop_mem_uin", localJSONException);
      localBundle.putBoolean("need_update_nick", false);
      Object localObject2 = localBundle;
      continue;
      label359:
      continue;
      label362:
      String str2 = null;
      continue;
      label368:
      Object localObject1 = null;
      continue;
      label374:
      int j = -1;
      continue;
      localObject2 = null;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setUnreadAIOGrayTips");
    }
    jdField_a_of_type_JavaUtilHashMap.put(paramString1 + "_" + paramString2, Boolean.valueOf(true));
  }
  
  private void b(TroopTipsEntity paramTroopTipsEntity)
  {
    int i = 0;
    if ((paramTroopTipsEntity == null) || (paramTroopTipsEntity.optContent == null)) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "decodeContent ===> entity == null || content == null");
      }
    }
    JSONArray localJSONArray;
    label413:
    do
    {
      return;
      Matcher localMatcher = Pattern.compile("<([^>])+").matcher(paramTroopTipsEntity.optContent);
      paramTroopTipsEntity.highlightNum = 0;
      localJSONArray = new JSONArray();
      Object localObject3 = "";
      int j = 0;
      while (localMatcher.find())
      {
        int k = j + 1;
        paramTroopTipsEntity.highlightNum = k;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "match count=====>" + k);
        }
        int m = localMatcher.start();
        j = localMatcher.end();
        Object localObject2 = paramTroopTipsEntity.optContent.substring(m + 1, j);
        Object localObject1 = paramTroopTipsEntity.optContent.substring(i, m);
        localObject3 = (String)localObject3 + (String)localObject1;
        i = ((String)localObject3).length();
        m = j + 1;
        localObject1 = localObject3;
        StringBuilder localStringBuilder;
        JSONObject localJSONObject;
        try
        {
          localStringBuilder = new StringBuilder();
          localObject1 = localObject3;
          localJSONObject = new JSONObject((String)localObject2);
          localObject1 = localObject3;
          localJSONObject.put("startIndex", i);
          localObject2 = localObject3;
          localObject1 = localObject3;
          if (localJSONObject.has("text"))
          {
            localObject1 = localObject3;
            str = localJSONObject.get("text").toString();
            localObject2 = localObject3;
            if (str != null)
            {
              localObject1 = localObject3;
              localObject2 = (String)localObject3 + str;
              localObject1 = localObject2;
              localJSONObject.put("endIndex", str.length() + i);
            }
            localObject1 = localObject2;
            localStringBuilder.append("text==>");
            localObject1 = localObject2;
            localStringBuilder.append(str);
          }
          localObject1 = localObject2;
          boolean bool = localJSONObject.has("cmd");
          if (bool) {
            localObject1 = localObject2;
          }
        }
        catch (JSONException localJSONException2)
        {
          String str;
          i = m;
          localObject3 = localObject1;
          j = k;
        }
        try
        {
          j = Integer.parseInt(localJSONObject.get("cmd").toString());
          localObject1 = localObject2;
          localJSONObject.put("cmd", j);
          localObject1 = localObject2;
          localStringBuilder.append(",cmd==>");
          localObject1 = localObject2;
          localStringBuilder.append(j);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localJSONException1 = localJSONException2;
          if (!QLog.isColorLevel()) {
            break label413;
          }
          localJSONException1 = localJSONException2;
          QLog.e(jdField_a_of_type_JavaLangString, 2, "decodeContent==>NumberFormatException");
          break label413;
          localJSONException1 = localJSONException2;
          localJSONArray.put(localJSONObject);
          i = m;
          localObject3 = localJSONException2;
          j = k;
          localJSONException1 = localJSONException2;
        }
        localObject1 = localObject2;
        if (localJSONObject.has("data"))
        {
          localObject1 = localObject2;
          localObject3 = localJSONObject.get("data").toString();
          localObject1 = localObject2;
          localJSONObject.put("data", localObject3);
          localObject1 = localObject2;
          localStringBuilder.append(",data==>");
          localObject1 = localObject2;
          localStringBuilder.append((String)localObject3);
        }
        localObject1 = localObject2;
        if (localJSONObject.has("data_a"))
        {
          localObject1 = localObject2;
          localObject3 = localJSONObject.get("data_a").toString();
          localObject1 = localObject2;
          localJSONObject.put("data_a", localObject3);
          localObject1 = localObject2;
          localStringBuilder.append(",data_a==>");
          localObject1 = localObject2;
          localStringBuilder.append((String)localObject3);
        }
        localObject1 = localObject2;
        if (localJSONObject.has("url"))
        {
          localObject1 = localObject2;
          localObject3 = localJSONObject.get("url").toString();
          localObject1 = localObject2;
          localJSONObject.put("url", localObject3);
          localObject1 = localObject2;
          localStringBuilder.append(",url:");
          localObject1 = localObject2;
          localStringBuilder.append((String)localObject3);
        }
        localObject1 = localObject2;
        if (localJSONObject.has("icon"))
        {
          localObject1 = localObject2;
          localObject3 = localJSONObject.get("icon").toString();
          localObject1 = localObject2;
          localStringBuilder.append(",icon:");
          localObject1 = localObject2;
          localStringBuilder.append((String)localObject3);
        }
        localObject1 = localObject2;
        if (localJSONObject.has("alt"))
        {
          localObject1 = localObject2;
          localObject3 = localJSONObject.get("alt").toString();
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            str = "[" + (String)localObject3 + "]";
            localObject1 = localObject2;
            localObject3 = (String)localObject2 + str;
            localObject1 = localObject3;
            localJSONObject.put("endIndex", i + str.length());
            localObject1 = localObject3;
            localStringBuilder.append(",alt:");
            localObject1 = localObject3;
            localStringBuilder.append(str);
            i = m;
            j = k;
            continue;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e(jdField_a_of_type_JavaLangString, 2, "decodeContent:JSONException");
            i = m;
            localObject3 = localObject1;
            j = k;
            continue;
          }
        }
        JSONException localJSONException1;
        if (QLog.isColorLevel())
        {
          localJSONException1 = localJSONException2;
          QLog.d(jdField_a_of_type_JavaLangString, 2, "decodeContent==>" + localStringBuilder.toString());
          i = m;
          localObject3 = localJSONException2;
          j = k;
        }
      }
      paramTroopTipsEntity.optContent = ((String)localObject3 + paramTroopTipsEntity.optContent.substring(i, paramTroopTipsEntity.optContent.length()));
    } while (paramTroopTipsEntity.highlightNum == 0);
    paramTroopTipsEntity.highlightItems = localJSONArray.toString();
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "removeReadedAIOGrayTips");
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("read", Boolean.valueOf(true));
    boolean bool = localEntityManager.a(TroopTipsEntity.class.getSimpleName(), localContentValues, "troopUin=? and msgSeq=?", new String[] { paramString1, paramString2 });
    localEntityManager.a();
    if (bool)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "removeReadedAIOGrayTips ok troopUin:" + paramString1 + "msgSeq:" + paramString2);
      jdField_a_of_type_JavaUtilHashMap.remove(paramString1 + "_" + paramString2);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "removeReadedAIOGrayTips error");
  }
  
  public List a(String paramString)
  {
    if (paramString == null) {}
    Object localObject;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    do
    {
      return null;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      paramString = ((EntityManager)localObject).a(TroopTipsEntity.class, true, "troopUin=? and read=? and currentUin=?", new String[] { paramString, "0", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() }, null, null, "time ASC", null);
      ((EntityManager)localObject).a();
    } while (paramString == null);
    int i = 0;
    if (i < paramString.size())
    {
      localObject = (TroopTipsEntity)paramString.get(i);
      if ((((TroopTipsEntity)localObject).expireTime != 0L) && (NetConnInfoCenter.getServerTime() >= ((TroopTipsEntity)localObject).expireTime)) {}
      for (;;)
      {
        i += 1;
        break;
        if (((TroopTipsEntity)localObject).optShowLatest == 1) {
          localArrayList2.add(localObject);
        } else {
          localArrayList1.add(localObject);
        }
      }
    }
    localArrayList1.addAll(localArrayList2);
    return localArrayList1;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initTroopTipsFlag");
    }
    jdField_a_of_type_JavaUtilHashMap.clear();
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    Cursor localCursor = localEntityManager.a(true, TroopTipsEntity.class.getSimpleName(), new String[] { "troopUin" }, "read=?", new String[] { String.valueOf(0) }, "troopUin", null, null, null);
    int i;
    if (localCursor != null) {
      if (localCursor.moveToFirst())
      {
        i = localCursor.getColumnIndex("troopUin");
        if (i == -1) {
          break label186;
        }
      }
    }
    label186:
    for (paramQQAppInterface = localCursor.getString(i);; paramQQAppInterface = null)
    {
      i = localCursor.getColumnIndex("msgSeq");
      if (i != -1) {}
      for (String str = localCursor.getString(i);; str = null)
      {
        if ((paramQQAppInterface != null) && (str != null)) {
          a(paramQQAppInterface, str);
        }
        if (localCursor.moveToNext()) {
          break;
        }
        localCursor.close();
        localEntityManager.a();
        return;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, TroopTipsEntity paramTroopTipsEntity)
  {
    if (paramTroopTipsEntity == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveTroopTips");
    }
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    paramTroopTipsEntity.read = false;
    paramTroopTipsEntity.currentUin = paramQQAppInterface.a();
    a(paramTroopTipsEntity.troopUin, paramTroopTipsEntity.msgSeq + "");
    localEntityManager.a(paramTroopTipsEntity);
    localEntityManager.a();
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      paramQQAppInterface = a(paramString);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() != 0))
      {
        paramQQAppInterface = paramQQAppInterface.iterator();
        while (paramQQAppInterface.hasNext()) {
          a((TroopTipsEntity)paramQQAppInterface.next());
        }
      }
    }
  }
  
  public void a(TroopTipsEntity paramTroopTipsEntity)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramTroopTipsEntity == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(paramTroopTipsEntity));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    b(paramTroopTipsEntity.troopUin, paramTroopTipsEntity.msgSeq + "");
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {}
    label63:
    int i;
    long l2;
    long l1;
    do
    {
      do
      {
        for (;;)
        {
          return;
          localObject = new TroopTips0x857.NotifyMsgBody();
          try
          {
            paramArrayOfByte = (TroopTips0x857.NotifyMsgBody)((TroopTips0x857.NotifyMsgBody)localObject).mergeFrom(paramArrayOfByte);
            if (paramArrayOfByte != null) {
              break label63;
            }
            if (QLog.isColorLevel())
            {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "handleTroopTips ==> notifyMsgBody == null");
              return;
            }
          }
          catch (Exception paramArrayOfByte) {}
        }
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "handleTroopTips Exception");
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleTroopTips ==> msgSeq:" + paramInt);
      }
      i = paramArrayOfByte.opt_enum_type.get();
      l2 = paramArrayOfByte.opt_uint64_group_code.get();
      l1 = paramLong;
      if (paramLong == 0L) {
        l1 = NetConnInfoCenter.getServerTime();
      }
      paramLong = paramArrayOfByte.opt_uint64_msg_expires.get();
      if ((paramLong == 0L) || (NetConnInfoCenter.getServerTime() < paramLong)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "handleTroopTips ==> time expried!! promptType:" + i);
    return;
    Object localObject = new TroopTipsEntity();
    ((TroopTipsEntity)localObject).troopUin = String.valueOf(l2);
    ((TroopTipsEntity)localObject).time = l1;
    ((TroopTipsEntity)localObject).expireTime = paramLong;
    ((TroopTipsEntity)localObject).msgSeq = paramInt;
    ((TroopTipsEntity)localObject).isOfflineMsg = paramBoolean;
    switch (i)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((TroopTipsEntity)localObject).troopUin, (TroopTipsEntity)localObject);
      return;
      ((TroopTipsEntity)localObject).tipsPromptType = 1;
      ((TroopTipsEntity)localObject).currentUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      ((TroopTipsEntity)localObject).optContent = paramArrayOfByte.opt_msg_graytips.opt_bytes_content.get().toStringUtf8();
      if (TextUtils.isEmpty(((TroopTipsEntity)localObject).optContent)) {
        break;
      }
      ((TroopTipsEntity)localObject).optShowLatest = paramArrayOfByte.opt_msg_graytips.opt_uint32_show_lastest.get();
      b((TroopTipsEntity)localObject);
    }
  }
  
  public boolean a(String paramString)
  {
    return !jdField_a_of_type_JavaUtilHashMap.isEmpty();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr
 * JD-Core Version:    0.7.0.1
 */