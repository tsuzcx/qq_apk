package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.RecentEmotionData;
import com.tencent.mobileqq.emoji.EmojiUtil;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlite.data.MarkFaceMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmoticonUtils
{
  private static final String a = "EmoticonUtils";
  
  public static Bundle a(AppInterface paramAppInterface)
  {
    paramAppInterface = a(paramAppInterface);
    if (paramAppInterface == null) {
      return null;
    }
    try
    {
      paramAppInterface = new JSONObject(paramAppInterface).getJSONObject("addbutton");
      if (Integer.parseInt(paramAppInterface.getString("hide")) == 1) {}
      for (boolean bool = false;; bool = true)
      {
        paramAppInterface = paramAppInterface.getString("url");
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("plusbutton", bool);
        localBundle.putString("url", paramAppInterface);
        return localBundle;
      }
      return null;
    }
    catch (JSONException paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
  }
  
  public static PicEmoticonInfo a(MarkFaceMessage paramMarkFaceMessage, QQAppInterface paramQQAppInterface)
  {
    if ((paramMarkFaceMessage == null) || (paramQQAppInterface == null)) {}
    String str1;
    do
    {
      return null;
      str1 = EmosmUtils.bytes2eId(paramMarkFaceMessage.sbufID, paramMarkFaceMessage.mediaType);
    } while (str1 == null);
    String str2 = String.valueOf(paramMarkFaceMessage.dwTabID);
    int i = paramMarkFaceMessage.imageWidth;
    int j = paramMarkFaceMessage.imageHeight;
    Emoticon localEmoticon = ((EmoticonManager)paramQQAppInterface.getManager(13)).a(str2, str1);
    if (localEmoticon != null)
    {
      paramQQAppInterface = new PicEmoticonInfo(paramQQAppInterface.a());
      paramQQAppInterface.c = 6;
      paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqDataEmoticon = localEmoticon;
      localEmoticon.encryptKey = new String(paramMarkFaceMessage.sbfKey);
      if (localEmoticon.width == 0) {
        localEmoticon.width = i;
      }
      if (localEmoticon.height == 0) {
        localEmoticon.height = j;
      }
      if ((paramMarkFaceMessage.mobileparam != null) && (paramMarkFaceMessage.mobileparam.length > 0))
      {
        localEmoticon.jobType = 2;
        localEmoticon.magicValue = new String(paramMarkFaceMessage.mobileparam);
      }
      localEmoticon.height = j;
      paramQQAppInterface.h = paramMarkFaceMessage.cSubType;
      return paramQQAppInterface;
    }
    paramQQAppInterface = new PicEmoticonInfo(paramQQAppInterface.a());
    paramQQAppInterface.c = 6;
    localEmoticon = new Emoticon();
    if (paramMarkFaceMessage.mediaType == 1) {
      localEmoticon.isSound = true;
    }
    for (;;)
    {
      if ((paramMarkFaceMessage.mobileparam != null) && (paramMarkFaceMessage.mobileparam.length > 0))
      {
        localEmoticon.jobType = 2;
        localEmoticon.magicValue = new String(paramMarkFaceMessage.mobileparam);
      }
      localEmoticon.epId = str2;
      localEmoticon.eId = str1;
      localEmoticon.encryptKey = new String(paramMarkFaceMessage.sbfKey);
      localEmoticon.width = i;
      localEmoticon.height = j;
      localEmoticon.name = paramMarkFaceMessage.faceName;
      paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqDataEmoticon = localEmoticon;
      paramQQAppInterface.h = paramMarkFaceMessage.cSubType;
      return paramQQAppInterface;
      if (paramMarkFaceMessage.mediaType == 2) {
        localEmoticon.jobType = 1;
      }
    }
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    paramAppInterface = new File(paramAppInterface.getApplication().getFilesDir() + "/recommend_magic_emotion_" + paramAppInterface.a() + ".json");
    if (paramAppInterface.exists())
    {
      paramAppInterface = FileUtils.a(paramAppInterface);
      try
      {
        paramAppInterface = new String(paramAppInterface, "UTF-8");
        return paramAppInterface;
      }
      catch (UnsupportedEncodingException paramAppInterface)
      {
        return null;
      }
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new File(paramQQAppInterface.getApplication().getFilesDir() + "/recommend_emoticon_" + paramQQAppInterface.a() + ".dat");
    byte[] arrayOfByte;
    if (paramQQAppInterface.exists())
    {
      arrayOfByte = FileUtils.a(paramQQAppInterface);
      paramQQAppInterface = new EmosmPb.SubCmd0x5RspBQRecommend();
    }
    try
    {
      paramQQAppInterface.mergeFrom(arrayOfByte);
      if (paramQQAppInterface == null) {
        return null;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface = null;
      }
    }
    return paramQQAppInterface.str_morebq_img_url.get();
  }
  
  public static List a(QQAppInterface paramQQAppInterface)
  {
    localObject = null;
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = new JSONObject(paramQQAppInterface).getJSONArray("rec");
        localArrayList = new ArrayList(paramQQAppInterface.length());
        j = 0;
      }
      catch (Exception paramQQAppInterface)
      {
        int j;
        JSONObject localJSONObject;
        int i;
        paramQQAppInterface.printStackTrace();
        return localObject;
      }
      try
      {
        if (j >= paramQQAppInterface.length()) {
          continue;
        }
        localObject = new EmoticonPackage();
        localJSONObject = paramQQAppInterface.getJSONObject(j);
        if ((!localJSONObject.has("packageId")) || (!localJSONObject.has("name")) || (!localJSONObject.has("label")) || (!localJSONObject.has("idlist"))) {
          continue;
        }
        ((EmoticonPackage)localObject).epId = localJSONObject.getString("packageId");
        ((EmoticonPackage)localObject).name = localJSONObject.getString("name");
        ((EmoticonPackage)localObject).upperLeftLable = Integer.parseInt(localJSONObject.getString("label"));
        ((EmoticonPackage)localObject).firstEmotionId = localJSONObject.getString("idlist").split(",")[0];
        ((EmoticonPackage)localObject).type = 1;
        k = 0;
        i = 0;
      }
      catch (Exception paramQQAppInterface)
      {
        localObject = localArrayList;
        continue;
        k += 1;
        continue;
      }
      if (k < localArrayList.size())
      {
        if (!((EmoticonPackage)localArrayList.get(k)).epId.equals(((EmoticonPackage)localObject).epId)) {
          break label265;
        }
        i = 1;
        break label265;
      }
      if (i == 0) {
        localArrayList.add(localObject);
      }
      j += 1;
    }
    return localArrayList;
  }
  
  public static List a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    List localList = localEntityManager.a(RecentEmotionData.class, false, null, null, null, null, null, null);
    EmoticonManager localEmoticonManager = (EmoticonManager)paramQQAppInterface.getManager(13);
    if (localList != null)
    {
      int i;
      int j;
      label96:
      RecentEmotionData localRecentEmotionData;
      Object localObject;
      if (localList.size() > 8)
      {
        i = localList.size() - 8;
        j = localList.size() - 1;
        if (j < i) {
          break label341;
        }
        localRecentEmotionData = (RecentEmotionData)localList.get(j);
        if (localRecentEmotionData.type != 4) {
          break label170;
        }
        localObject = new EmojiEmoticonInfo();
        ((EmojiEmoticonInfo)localObject).c = 2;
        ((EmojiEmoticonInfo)localObject).jdField_a_of_type_Int = localRecentEmotionData.emoIndex;
        localArrayList.add(localObject);
      }
      for (;;)
      {
        j -= 1;
        break label96;
        i = 0;
        break;
        label170:
        if (localRecentEmotionData.type == 0)
        {
          localObject = new SystemEmoticonInfo();
          ((SystemEmoticonInfo)localObject).c = 1;
          ((SystemEmoticonInfo)localObject).jdField_a_of_type_Int = localRecentEmotionData.emoIndex;
          localArrayList.add(localObject);
        }
        else if ((localRecentEmotionData.type == 5) && (d(paramInt)))
        {
          localObject = new PicEmoticonInfo(paramQQAppInterface.a());
          ((PicEmoticonInfo)localObject).c = 6;
          String str = localRecentEmotionData.emoPath;
          ((PicEmoticonInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticon = localEmoticonManager.a(String.valueOf(localRecentEmotionData.emoIndex), str);
          localArrayList.add(localObject);
        }
        else if (localRecentEmotionData.type == 3)
        {
          localObject = new FavoriteEmoticonInfo();
          ((FavoriteEmoticonInfo)localObject).c = 5;
          ((FavoriteEmoticonInfo)localObject).h = localRecentEmotionData.emoPath;
          localArrayList.add(localObject);
        }
      }
    }
    label341:
    localEntityManager.a();
    return localArrayList;
  }
  
  public static List a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, EmoticonCallback paramEmoticonCallback)
  {
    ArrayList localArrayList = new ArrayList(3);
    localArrayList.add(new RecentAndFavPanelViewBinder(paramQQAppInterface, paramContext, paramInt, paramEmoticonCallback, 0));
    if (EmojiUtil.a(paramContext) == EmotcationConstants.f) {
      localArrayList.add(new ClassicEmoticonPanelViewBinder(paramContext, paramEmoticonCallback, 7, 9, true));
    }
    for (;;)
    {
      localArrayList.add(new ActionTabViewBinder(100));
      return localArrayList;
      localArrayList.add(new SystemEmoticonPanelViewBinder(paramContext, paramEmoticonCallback, 0));
    }
  }
  
  public static List a(QQAppInterface paramQQAppInterface, Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = ((EmoticonManager)paramQQAppInterface.getManager(13)).b();
    if (ClubContentJsonTask.a(paramQQAppInterface).size() > 0) {
      localArrayList.add(new RecommendEmoticonViewBinder(paramQQAppInterface, paramContext, 0));
    }
    localArrayList.add(new MagicFaceViewBinder(paramQQAppInterface, paramContext, paramEmoticonCallback, 0));
    Object localObject;
    EmoticonPackage localEmoticonPackage1;
    if (localList != null)
    {
      localObject = localList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localEmoticonPackage1 = (EmoticonPackage)((Iterator)localObject).next();
        if ((!"100000".equals(localEmoticonPackage1.epId)) && (localEmoticonPackage1.type != 1) && (3 != localEmoticonPackage1.jobType) && (1 != localEmoticonPackage1.jobType)) {
          localArrayList.add(new BigEmoticonViewBinder(paramQQAppInterface, paramContext, paramEmoticonCallback, 0, localEmoticonPackage1));
        }
      }
      localObject = a(paramQQAppInterface.getApplication().getSharedPreferences("QQLite", 0).getString("emosm_recommend_tab_json", ""));
      if (localObject != null) {
        localObject = ((List)localObject).iterator();
      }
    }
    label358:
    label359:
    for (;;)
    {
      int i;
      if (((Iterator)localObject).hasNext())
      {
        localEmoticonPackage1 = (EmoticonPackage)((Iterator)localObject).next();
        Iterator localIterator = localList.iterator();
        i = 0;
        label249:
        if (localIterator.hasNext())
        {
          EmoticonPackage localEmoticonPackage2 = (EmoticonPackage)localIterator.next();
          if (!localEmoticonPackage1.epId.equalsIgnoreCase(localEmoticonPackage2.epId)) {
            break label358;
          }
          localEmoticonPackage2.isRecommendation = true;
          i = 1;
        }
      }
      for (;;)
      {
        break label249;
        if (i != 0) {
          break label359;
        }
        localEmoticonPackage1.isRecommendation = true;
        localEmoticonPackage1.valid = true;
        localArrayList.add(new BigEmoticonViewBinder(paramQQAppInterface, paramContext, paramEmoticonCallback, 0, localEmoticonPackage1));
        break;
        localArrayList.add(new ActionTabViewBinder(101));
        return localArrayList;
      }
    }
  }
  
  /* Error */
  public static List a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: ifnull +115 -> 121
    //   9: new 246	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 307	java/util/ArrayList:<init>	()V
    //   16: astore_3
    //   17: new 248	org/json/JSONArray
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 450	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   25: astore_0
    //   26: aload_0
    //   27: invokevirtual 252	org/json/JSONArray:length	()I
    //   30: istore_2
    //   31: iconst_0
    //   32: istore_1
    //   33: iload_1
    //   34: iload_2
    //   35: if_icmpge +86 -> 121
    //   38: new 257	com/tencent/mobileqq/data/EmoticonPackage
    //   41: dup
    //   42: invokespecial 258	com/tencent/mobileqq/data/EmoticonPackage:<init>	()V
    //   45: astore 4
    //   47: aload_0
    //   48: iload_1
    //   49: invokevirtual 451	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   52: checkcast 21	org/json/JSONObject
    //   55: astore 5
    //   57: aload 5
    //   59: ldc_w 268
    //   62: invokevirtual 267	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   65: ifeq +16 -> 81
    //   68: aload 4
    //   70: aload 5
    //   72: ldc_w 268
    //   75: invokevirtual 36	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   78: putfield 274	com/tencent/mobileqq/data/EmoticonPackage:name	Ljava/lang/String;
    //   81: aload 5
    //   83: ldc_w 263
    //   86: invokevirtual 267	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   89: ifeq +16 -> 105
    //   92: aload 4
    //   94: aload 5
    //   96: ldc_w 263
    //   99: invokevirtual 36	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   102: putfield 273	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   105: aload_3
    //   106: aload 4
    //   108: invokeinterface 304 2 0
    //   113: pop
    //   114: iload_1
    //   115: iconst_1
    //   116: iadd
    //   117: istore_1
    //   118: goto -85 -> 33
    //   121: aload_3
    //   122: areturn
    //   123: astore_3
    //   124: aload 4
    //   126: astore_0
    //   127: aload_3
    //   128: invokevirtual 305	java/lang/Exception:printStackTrace	()V
    //   131: aload_0
    //   132: areturn
    //   133: astore 4
    //   135: aload_3
    //   136: astore_0
    //   137: aload 4
    //   139: astore_3
    //   140: goto -13 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramString	String
    //   32	86	1	i	int
    //   30	6	2	j	int
    //   4	118	3	localArrayList	ArrayList
    //   123	13	3	localException1	Exception
    //   139	1	3	localException2	Exception
    //   1	124	4	localEmoticonPackage	EmoticonPackage
    //   133	5	4	localException3	Exception
    //   55	40	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   9	17	123	java/lang/Exception
    //   17	31	133	java/lang/Exception
    //   38	81	133	java/lang/Exception
    //   81	105	133	java/lang/Exception
    //   105	114	133	java/lang/Exception
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    FileUtils.a(paramQQAppInterface.getApplication().getFilesDir() + "/recommend_magic_emotion_" + paramQQAppInterface.a() + ".json", paramArrayOfByte, false);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = RecentEmotionData.class.getSimpleName();
    paramString = "delete from " + str + " where emoIndex = " + paramString;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonUtils", 2, paramString);
    }
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    boolean bool = paramQQAppInterface.b(paramString);
    paramQQAppInterface.a();
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    return FileUtils.a(paramQQAppInterface.getApplication().getFilesDir() + "/recommend_emoticon_" + paramQQAppInterface.a() + ".dat", paramArrayOfByte, false);
  }
  
  public static boolean a(EmoticonPackage paramEmoticonPackage)
  {
    return (paramEmoticonPackage != null) && (paramEmoticonPackage.status == 2) && ((paramEmoticonPackage.updateFlag & 0x1) == 1);
  }
  
  public static List b(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    EmoticonManager localEmoticonManager = (EmoticonManager)paramQQAppInterface.getManager(13);
    localEmoticonManager = (EmoticonManager)paramQQAppInterface.getManager(13);
    Object localObject2 = a(paramQQAppInterface);
    Object localObject3 = localEmoticonManager.b();
    Object localObject1 = new ArrayList();
    Object localObject4;
    if (localObject3 != null)
    {
      int i = 0;
      while (i < ((List)localObject3).size())
      {
        localObject4 = (EmoticonPackage)((List)localObject3).get(i);
        if ((3 != ((EmoticonPackage)localObject4).jobType) || ("100000".equals(((EmoticonPackage)localObject4).epId)))
        {
          i += 1;
        }
        else
        {
          int j;
          if (localObject2 != null) {
            j = 0;
          }
          for (;;)
          {
            if (j < ((List)localObject2).size())
            {
              if (((EmoticonPackage)((List)localObject2).get(j)).epId.equals(((EmoticonPackage)localObject4).epId)) {
                ((List)localObject2).remove(j);
              }
            }
            else
            {
              ((List)localObject1).add(localObject4);
              break;
            }
            j += 1;
          }
        }
      }
    }
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (EmoticonPackage)((Iterator)localObject2).next();
        localObject4 = new PicEmoticonInfo(paramQQAppInterface.a());
        ((PicEmoticonInfo)localObject4).c = 9;
        ((PicEmoticonInfo)localObject4).jdField_a_of_type_ComTencentMobileqqDataEmoticon = new Emoticon();
        ((PicEmoticonInfo)localObject4).jdField_a_of_type_ComTencentMobileqqDataEmoticon.name = ((EmoticonPackage)localObject3).name;
        ((PicEmoticonInfo)localObject4).jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId = ((EmoticonPackage)localObject3).epId;
        ((PicEmoticonInfo)localObject4).jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId = ((EmoticonPackage)localObject3).firstEmotionId;
        ((PicEmoticonInfo)localObject4).jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType = 2;
        ((PicEmoticonInfo)localObject4).jdField_a_of_type_Boolean = true;
        ((PicEmoticonInfo)localObject4).jdField_a_of_type_Int = ((EmoticonPackage)localObject3).upperLeftLable;
        localArrayList.add(localObject4);
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EmoticonPackage)((Iterator)localObject1).next();
      localObject3 = localEmoticonManager.a(((EmoticonPackage)localObject2).epId);
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Emoticon)((Iterator)localObject3).next();
          ((Emoticon)localObject4).jobType = 2;
          ((Emoticon)localObject4).name = ((EmoticonPackage)localObject2).name;
          ((Emoticon)localObject4).value = ((EmoticonPackage)localObject2).valid;
          PicEmoticonInfo localPicEmoticonInfo = new PicEmoticonInfo(paramQQAppInterface.a());
          localPicEmoticonInfo.c = 9;
          localPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon = ((Emoticon)localObject4);
          localArrayList.add(localPicEmoticonInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x2) == 2;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = a(paramQQAppInterface.getApplication().getSharedPreferences("QQLite", 0).getString("emosm_recommend_tab_json", ""));
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.iterator();
      while (paramQQAppInterface.hasNext()) {
        if (paramString.equals(((EmoticonPackage)paramQQAppInterface.next()).epId)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt & 0x4) == 4;
  }
  
  public static boolean d(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonUtils
 * JD-Core Version:    0.7.0.1
 */