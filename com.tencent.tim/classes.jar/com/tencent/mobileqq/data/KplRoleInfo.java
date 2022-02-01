package com.tencent.mobileqq.data;

import acff;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xa28.oidb_0xa28.RoleInfo;
import wki;
import ydz;

public class KplRoleInfo
  extends Entity
{
  public static final String KPL_TAG = "KplMessage";
  public static final String MSG_EXT_KEY = "msg_ext_key";
  public String roleName;
  public String roleScore;
  public String roleUrl;
  
  public static String getGameNickByUin(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = null;
    String str1 = null;
    String str2 = paramQQAppInterface.getPreferences().getString("key_kpl_nick_table", null);
    paramQQAppInterface = str1;
    if (!TextUtils.isEmpty(str2)) {}
    try
    {
      str1 = new JSONObject(str2).optString(paramString);
      paramQQAppInterface = str1;
      localObject = str1;
      if (QLog.isColorLevel())
      {
        localObject = str1;
        QLog.d("KplMessage", 2, "getGameNickByUin uin=" + paramString + " kpl_nick=" + str1);
        paramQQAppInterface = str1;
      }
      return paramQQAppInterface;
    }
    catch (JSONException paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "catch exception when getGameNickByUin json=" + str2 + " --uin=" + paramString);
      }
      paramQQAppInterface.printStackTrace();
    }
    return localObject;
  }
  
  public static String getKplVerifyMsg(QQAppInterface paramQQAppInterface)
  {
    String str = paramQQAppInterface.getPreferences().getString("key_kpl_nick_table" + paramQQAppInterface.getCurrentAccountUin(), null);
    if (QLog.isColorLevel()) {
      QLog.d("KplMessage", 2, "getKplVerifyMsg uin=" + paramQQAppInterface.getCurrentUin() + " kpl_verify_msg=" + str);
    }
    return str;
  }
  
  public static void handleKplFlag(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "handleKplFlag json=" + paramString);
      }
      paramQQAppInterface.getPreferences();
      try
      {
        paramString = new JSONObject(paramString);
        Iterator localIterator = paramString.keys();
        if (QLog.isColorLevel()) {
          QLog.d("KplMessage", 2, "handleKplFlag info: ----------------");
        }
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          saveGameNickWithUin(paramQQAppInterface, str, paramString.optString(str));
          continue;
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("KplMessage", 2, "handleKplFlag catch an exception");
        }
        paramQQAppInterface.printStackTrace();
      }
    }
    while (!QLog.isColorLevel()) {}
    QLog.d("KplMessage", 2, "------------------------------------");
  }
  
  public static boolean isKplPie(BaseChatPie paramBaseChatPie)
  {
    boolean bool;
    if (ydz.a(paramBaseChatPie.mContext, paramBaseChatPie.sessionInfo.cZ, false, false) != null) {
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "isKplPie=" + bool + " friendUin=" + paramBaseChatPie.sessionInfo.aTl);
      }
      return bool;
      if (paramBaseChatPie.sessionInfo.cZ == 1022)
      {
        List localList = paramBaseChatPie.a.getList();
        acff localacff = (acff)paramBaseChatPie.app.getManager(51);
        if ((localList != null) && (localList.size() > 0) && (!localacff.isFriend(paramBaseChatPie.sessionInfo.aTl)) && (!TextUtils.isEmpty(((ChatMessage)localList.get(localList.size() - 1)).getExtInfoFromExtStr("msg_ext_key"))))
        {
          bool = true;
          continue;
        }
      }
      bool = false;
    }
  }
  
  public static boolean isKplSession(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    boolean bool;
    if (ydz.a(paramContext, paramInt, false, false) != null) {
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "isKplSession=" + bool + " friendUin=" + paramString + " sessionType=" + paramInt);
      }
      return bool;
      paramContext = paramQQAppInterface.b().f(paramString, paramInt);
      paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
      if ((paramContext != null) && (paramContext.size() > 0) && (!paramQQAppInterface.isFriend(paramString)) && (!TextUtils.isEmpty(((ChatMessage)paramContext.get(paramContext.size() - 1)).getExtInfoFromExtStr("msg_ext_key")))) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public static KplRoleInfo parseJsonString(String paramString)
  {
    KplRoleInfo localKplRoleInfo = new KplRoleInfo();
    try
    {
      paramString = new JSONObject(paramString);
      localKplRoleInfo.roleName = paramString.optString("roleName");
      localKplRoleInfo.roleScore = paramString.optString("roleScore");
      localKplRoleInfo.roleUrl = paramString.optString("roleUrl");
      return localKplRoleInfo;
    }
    catch (Exception paramString)
    {
      QLog.e("KplRoleInfo", 1, "parseJsonString exception:");
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static KplRoleInfo parseProtoResp(oidb_0xa28.RoleInfo paramRoleInfo)
  {
    KplRoleInfo localKplRoleInfo = new KplRoleInfo();
    localKplRoleInfo.roleName = paramRoleInfo.bytes_role_name.get().toStringUtf8();
    localKplRoleInfo.roleScore = paramRoleInfo.bytes_role_score.get().toStringUtf8();
    localKplRoleInfo.roleUrl = paramRoleInfo.str_role_url.get();
    return localKplRoleInfo;
  }
  
  public static void saveGameNickWithUin(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
    String str = localSharedPreferences.getString("key_kpl_nick_table", null);
    paramQQAppInterface = str;
    try
    {
      if (!TextUtils.isEmpty(str)) {
        paramQQAppInterface = str;
      }
      for (Object localObject = new JSONObject(str);; localObject = new JSONObject())
      {
        paramQQAppInterface = str;
        ((JSONObject)localObject).put(paramString1, paramString2);
        paramQQAppInterface = str;
        localObject = ((JSONObject)localObject).toString();
        paramQQAppInterface = (QQAppInterface)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramQQAppInterface = (QQAppInterface)localObject;
        localSharedPreferences.edit().putString("key_kpl_nick_table", (String)localObject).commit();
        paramQQAppInterface = (QQAppInterface)localObject;
        if (!QLog.isColorLevel()) {
          break;
        }
        paramQQAppInterface = (QQAppInterface)localObject;
        QLog.d("KplMessage", 2, "saveGameNickWithUin uin=" + paramString1 + " kpl_nick=" + paramString2);
        return;
        paramQQAppInterface = str;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "catch exception when saveGameNickWithUin json=" + paramQQAppInterface + " --uin=" + paramString1 + " --gameNick=" + paramString2);
      }
    }
  }
  
  public static void saveKplVerifyMsg(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface.getPreferences().edit().putString("key_kpl_nick_table" + paramQQAppInterface.getCurrentAccountUin(), paramString).commit();
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "saveKplVerifyMsg uin=" + paramQQAppInterface.getCurrentUin() + " kpl_verify_msg=" + paramString);
      }
    }
  }
  
  public String toJsonString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("roleName", this.roleName);
      localJSONObject.put("roleScore", this.roleScore);
      localJSONObject.put("roleUrl", this.roleUrl);
      return localJSONObject.toString();
    }
    catch (Exception localException)
    {
      QLog.e("KplRoleInfo", 1, "toJsonString exception:");
      localException.printStackTrace();
    }
    return null;
  }
  
  public static class WZRYUIinfo
    implements Serializable
  {
    public String nick;
    public int sourceId;
    public int subSourceId;
    public String uin;
    public String verifyMsg;
    
    public static String buildNickName(String paramString1, String paramString2)
    {
      String str;
      if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
        str = "";
      }
      do
      {
        return str;
        str = paramString1;
      } while (TextUtils.isEmpty(paramString2));
      if (TextUtils.isEmpty(paramString1)) {
        return paramString2;
      }
      return paramString2 + "(" + paramString1 + ")";
    }
    
    public static WZRYUIinfo createInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
    {
      WZRYUIinfo localWZRYUIinfo = new WZRYUIinfo();
      localWZRYUIinfo.uin = paramString1;
      localWZRYUIinfo.nick = paramString2;
      localWZRYUIinfo.verifyMsg = paramString3;
      localWZRYUIinfo.sourceId = paramInt1;
      localWZRYUIinfo.subSourceId = paramInt2;
      return localWZRYUIinfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.KplRoleInfo
 * JD-Core Version:    0.7.0.1
 */