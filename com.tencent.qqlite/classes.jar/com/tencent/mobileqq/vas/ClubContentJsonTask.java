package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import eyz;
import eza;
import ezb;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ClubContentJsonTask
{
  public static final int a = 1;
  public static ClubContentJsonTask.TaskInfo a;
  public static final String a = "ClubContentJsonTask";
  public static ClubContentJsonTask.TaskInfo[] a;
  public static final int b = 2;
  public static ClubContentJsonTask.TaskInfo b;
  public static final String b = "clubContentVersion";
  public static final int c = 1;
  public static ClubContentJsonTask.TaskInfo c;
  public static final int d = 2;
  public static ClubContentJsonTask.TaskInfo d;
  public static final int e = 3;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo = new ClubContentJsonTask.TaskInfo("Emoticon_promotion.json", "http://i.gtimg.cn/qqshow/admindata/comdata/vipData_emoji_aio/", "http://i.gtimg.cn/qqshow/admindata/comdata/vipData_emoji_aio/xydata.json", "EPPromotionVersion", "promotion_json");
    b = new ClubContentJsonTask.TaskInfo("Individuation.json", "http://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation/", "http://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation/xydata.json", "IndividuationVersion", "individ_json");
    c = new ClubContentJsonTask.TaskInfo("EmoticonWording.json", "", "http://i.gtimg.cn/club/item/parcel/client_wording.json", "EmoticonWordingVersion", "wording_json");
    d = new ClubContentJsonTask.TaskInfo("keyword.json", "", "http://imgcache.qq.com/club/item/parcel/json/keyword_2.json", "EmoticonKeywordVersion", "keyword.json");
    jdField_a_of_type_ArrayOfComTencentMobileqqVasClubContentJsonTask$TaskInfo = new ClubContentJsonTask.TaskInfo[] { jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo, b, c };
  }
  
  public static int a(Context paramContext)
  {
    int k = 0;
    paramContext = new File(paramContext.getFilesDir(), b.jdField_a_of_type_JavaLangString);
    for (;;)
    {
      try
      {
        paramContext = FileUtils.a(paramContext);
        j = k;
        if (paramContext != null)
        {
          paramContext = new JSONObject(paramContext).getJSONObject("data").getJSONArray("showNewBiz");
          i = 0;
          j = k;
          if (i < paramContext.length())
          {
            if ((System.currentTimeMillis() >= Long.parseLong(paramContext.getJSONObject(i).getString("expireTime"))) || (paramContext.getJSONObject(i).getInt("bizType") != 1)) {
              continue;
            }
            j = paramContext.getJSONObject(i).getInt("newId");
          }
        }
      }
      catch (Exception paramContext)
      {
        int i;
        int j = k;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ClubContentJsonTask", 2, paramContext.getMessage());
      }
      return j;
      i += 1;
    }
    return 0;
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("clubContentVersion", 0).getInt(paramString, 0);
  }
  
  public static String a(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir(), b.jdField_a_of_type_JavaLangString);
    try
    {
      paramContext = new JSONObject(FileUtils.a(paramContext)).getJSONObject("data").getJSONArray("AttentionIcon").getJSONObject(0);
      if (System.currentTimeMillis() < Long.parseLong(paramContext.getString("expireTime")))
      {
        paramContext = b.c + paramContext.getString("bizIcon");
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentJsonTask", 2, paramContext.getMessage());
      }
    }
    return null;
  }
  
  public static String a(JSONArray paramJSONArray, long paramLong1, long paramLong2)
  {
    Object localObject;
    if (paramLong1 == -1L) {
      localObject = "";
    }
    for (;;)
    {
      return localObject;
      long l = paramLong1;
      if (paramLong1 == 0L) {
        l = 1L;
      }
      if (paramJSONArray == null) {
        break label261;
      }
      if (l >= 1L) {}
      try
      {
        if (l > paramJSONArray.length())
        {
          if (!QLog.isColorLevel()) {
            break label264;
          }
          QLog.d("ClubContentJsonTask", 2, "Illegal wordingId,wordingId=" + l + ",listSize=" + paramJSONArray.length());
          break label264;
        }
        str2 = ((JSONObject)paramJSONArray.get((int)l - 1)).getString("desc_mqq");
        localObject = str2;
        if (str2 != null)
        {
          localObject = str2;
          paramJSONArray = str2;
          try
          {
            if (str2.contains("$EXPIRE_DATE$"))
            {
              if (paramLong2 > 0L) {
                break label218;
              }
              str2 = "";
              localObject = str2;
              paramJSONArray = str2;
              if (QLog.isColorLevel())
              {
                paramJSONArray = str2;
                QLog.d("ClubContentJsonTask", 2, "Illegal expireTime, expireTime=" + paramLong2);
                return "";
              }
            }
          }
          catch (JSONException localJSONException1) {}
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          String str2;
          String str1;
          paramJSONArray = "";
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentJsonTask", 2, "Error occurred while parsing wording.json");
    }
    localJSONException1.printStackTrace();
    return paramJSONArray;
    label218:
    paramJSONArray = str2;
    str1 = str2.replaceAll("\\$EXPIRE_DATE\\$", new SimpleDateFormat("yyyy年MM月dd日").format(Long.valueOf(1000L * paramLong2)));
    return str1;
    label261:
    return "";
    label264:
    return "";
  }
  
  public static List a(Context paramContext)
  {
    localArrayList = new ArrayList();
    paramContext = new File(paramContext.getFilesDir(), b.jdField_a_of_type_JavaLangString);
    try
    {
      paramContext = FileUtils.a(paramContext);
      if (paramContext != null)
      {
        paramContext = new JSONObject(paramContext).getJSONObject("data").getJSONArray("showNewBiz");
        int i = 0;
        while (i < paramContext.length())
        {
          if (System.currentTimeMillis() < Long.parseLong(paramContext.getJSONObject(i).getString("expireTime")))
          {
            Bundle localBundle = new Bundle();
            localBundle.putInt("bizType", paramContext.getJSONObject(i).getInt("bizType"));
            localBundle.putInt("newId", paramContext.getJSONObject(i).getInt("newId"));
            localArrayList.add(localBundle);
          }
          i += 1;
        }
      }
      return localArrayList;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentJsonTask", 2, paramContext.getMessage());
      }
    }
  }
  
  public static List a(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo.jdField_a_of_type_JavaLangString);
    if (!((File)localObject1).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentJsonTask", 2, jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo.jdField_a_of_type_JavaLangString + " not exist.");
      }
      return localArrayList;
    }
    paramQQAppInterface = ((EmoticonManager)paramQQAppInterface.getManager(13)).b();
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(FileUtils.a((File)localObject1)).getJSONObject("data").getJSONArray("aioemoji");
        int i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = paramQQAppInterface.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            if (!((EmoticonPackage)((Iterator)localObject2).next()).epId.equals(((JSONArray)localObject1).getJSONObject(i).getString("id"))) {
              continue;
            }
            j = 1;
            if (j == 0)
            {
              localObject2 = new ClubContentJsonTask.PromotionEmoticonPkg();
              ((ClubContentJsonTask.PromotionEmoticonPkg)localObject2).d = ((JSONArray)localObject1).getJSONObject(i).getString("btn_desc");
              ((ClubContentJsonTask.PromotionEmoticonPkg)localObject2).e = ((JSONArray)localObject1).getJSONObject(i).getString("btn_url");
              ((ClubContentJsonTask.PromotionEmoticonPkg)localObject2).jdField_a_of_type_JavaLangString = ((JSONArray)localObject1).getJSONObject(i).getString("id");
              ((ClubContentJsonTask.PromotionEmoticonPkg)localObject2).jdField_b_of_type_JavaLangString = ((JSONArray)localObject1).getJSONObject(i).getString("img");
              ((ClubContentJsonTask.PromotionEmoticonPkg)localObject2).c = ((JSONArray)localObject1).getJSONObject(i).getString("pkg_desc");
              ((ClubContentJsonTask.PromotionEmoticonPkg)localObject2).jdField_a_of_type_Int = ((JSONArray)localObject1).getJSONObject(i).getInt("type");
              ((ClubContentJsonTask.PromotionEmoticonPkg)localObject2).jdField_b_of_type_Int = ((JSONArray)localObject1).getJSONObject(i).getInt("btn_url_type");
              localArrayList.add(localObject2);
            }
            i += 1;
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (JSONException paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, "Invalid json.");
        }
      }
      int j = 0;
    }
  }
  
  public static JSONArray a(Context paramContext)
  {
    paramContext = FileUtils.a(new File(paramContext.getFilesDir(), b.jdField_a_of_type_JavaLangString));
    if (paramContext != null) {
      try
      {
        paramContext = new JSONObject(paramContext).getJSONObject("data").getJSONArray("ABTestBanner");
        return paramContext;
      }
      catch (JSONException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, paramContext.getMessage());
        }
      }
    }
    return null;
  }
  
  public static JSONArray a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, c);
    paramQQAppInterface = FileUtils.a(new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), c.jdField_a_of_type_JavaLangString));
    if (paramQQAppInterface != null) {
      try
      {
        paramQQAppInterface = new JSONObject(paramQQAppInterface).getJSONArray("wording");
        return paramQQAppInterface;
      }
      catch (JSONException paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, paramQQAppInterface.getMessage());
        }
      }
    }
    return null;
  }
  
  public static JSONObject a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), d.jdField_a_of_type_JavaLangString);
    if (paramQQAppInterface.exists())
    {
      paramQQAppInterface = FileUtils.a(paramQQAppInterface);
      if (paramQQAppInterface != null) {
        try
        {
          paramQQAppInterface = new JSONObject(paramQQAppInterface);
          return paramQQAppInterface;
        }
        catch (JSONException paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentJsonTask", 2, paramQQAppInterface.getMessage());
          }
        }
      }
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext.getSharedPreferences("clubContentVersion", 0).edit().putInt(paramString, paramInt).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Context localContext = paramQQAppInterface.getApplication().getApplicationContext();
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfComTencentMobileqqVasClubContentJsonTask$TaskInfo.length)
    {
      String str = jdField_a_of_type_ArrayOfComTencentMobileqqVasClubContentJsonTask$TaskInfo[i].jdField_b_of_type_JavaLangString;
      File localFile = new File(localContext.getFilesDir(), jdField_a_of_type_ArrayOfComTencentMobileqqVasClubContentJsonTask$TaskInfo[i].jdField_a_of_type_JavaLangString);
      if (!localFile.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, "downloadAllIfNotExist, not found: " + jdField_a_of_type_ArrayOfComTencentMobileqqVasClubContentJsonTask$TaskInfo[i].jdField_a_of_type_JavaLangString);
        }
        paramQQAppInterface.a(new eza(str, localFile));
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ClubContentJsonTask.TaskInfo paramTaskInfo)
  {
    File localFile = new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), paramTaskInfo.jdField_a_of_type_JavaLangString);
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentJsonTask", 2, "downloadIfNotExist, not exist: " + paramTaskInfo.jdField_a_of_type_JavaLangString);
      }
      paramQQAppInterface.a(new eyz(paramTaskInfo, localFile));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ClubContentJsonTask", 2, "downloadIfNotExist, exists.");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ClubContentJsonTask.TaskInfo paramTaskInfo, int paramInt)
  {
    Context localContext = paramQQAppInterface.getApplication().getApplicationContext();
    paramQQAppInterface.a(new ezb(paramTaskInfo, new File(localContext.getFilesDir(), paramTaskInfo.jdField_a_of_type_JavaLangString), localContext, paramInt));
  }
  
  public static int b(Context paramContext, String paramString)
  {
    int j = 0;
    if (paramString.length() > 2)
    {
      paramContext = FileUtils.a(new File(paramContext.getFilesDir(), b.jdField_a_of_type_JavaLangString));
      if (paramContext == null) {}
    }
    JSONObject localJSONObject;
    int i;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramContext).getJSONObject("data").getJSONArray("ABTestUserRate").getJSONObject(0);
        if (localJSONObject.has("AList"))
        {
          paramContext = localJSONObject.getJSONArray("AList");
          break label232;
          if (i >= paramContext.length()) {
            break;
          }
          if (!paramString.equals(paramContext.getString(i))) {
            break label135;
          }
          return 1;
        }
        paramContext = new JSONArray();
      }
      catch (JSONException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, paramContext.getMessage());
        }
      }
      label133:
      return 1;
      label135:
      i += 1;
    }
    if (localJSONObject.has("BList"))
    {
      paramContext = localJSONObject.getJSONArray("BList");
      i = j;
    }
    for (;;)
    {
      if (i < paramContext.length())
      {
        if (paramString.equals(paramContext.getString(i)))
        {
          return 2;
          paramContext = new JSONArray();
          i = j;
        }
      }
      else
      {
        i = Integer.parseInt(localJSONObject.getString("ARate"));
        j = Integer.parseInt(paramString.substring(paramString.length() - 2));
        if (j <= i) {
          break label133;
        }
        return 2;
        label232:
        i = 0;
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ClubContentJsonTask
 * JD-Core Version:    0.7.0.1
 */