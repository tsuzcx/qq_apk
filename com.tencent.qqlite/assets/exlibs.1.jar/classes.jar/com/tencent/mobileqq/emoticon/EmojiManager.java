package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.EmosmHandler.EmosmHandlerListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ddp;
import ddq;
import ddr;
import dds;
import ddt;
import ddu;
import ddv;
import ddw;
import ddx;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmojiManager
  implements Manager
{
  public static final int a = 3;
  public static long a = 0L;
  public static final boolean a = false;
  public static final int b = 30000;
  public static long b = 0L;
  public static final String b = "LAST_ADD_EMO_PACKAGE";
  public static int c = 0;
  public static final long c = 35000L;
  public static final String c = "LAST_ADD_EMO_PACKAGE_MAGIC";
  public static int d = 0;
  public static final String d = "emoticonPackage";
  private static int e = 0;
  public static final String e = "vipEmoticonKey_";
  private static int jdField_f_of_type_Int = 0;
  public static final String f = "newPkgAdd";
  public static final String g = "isUpdate";
  public static final String h = "jsonType";
  public QQAppInterface a;
  public EmojiListenerManager a;
  DownloadListener a;
  public String a;
  public ArrayList a;
  public HashMap a;
  public Map a;
  public DownloadListener b;
  private Map b;
  public DownloadListener c;
  public DownloadListener d;
  public DownloadListener e;
  private DownloadListener jdField_f_of_type_ComTencentMobileqqVipDownloadListener = new ddp(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  private int g = 3000000;
  private int h = 0;
  
  static
  {
    jdField_e_of_type_Int = 0;
    jdField_f_of_type_Int = 1;
    jdField_a_of_type_Long = 1L;
    jdField_b_of_type_Long = 1L;
    jdField_c_of_type_Int = 1;
    jdField_d_of_type_Int = jdField_c_of_type_Int + 1;
  }
  
  public EmojiManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_JavaLangString = EmojiManager.class.getSimpleName();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager = null;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new ddq(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
    this.jdField_b_of_type_ComTencentMobileqqVipDownloadListener = new ddr(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
    this.jdField_c_of_type_ComTencentMobileqqVipDownloadListener = new dds(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
    this.jdField_d_of_type_ComTencentMobileqqVipDownloadListener = new ddt(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
    this.jdField_e_of_type_ComTencentMobileqqVipDownloadListener = new ddu(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
    this.jdField_b_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap(10, 1.1F, true));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager = new EmojiListenerManager();
  }
  
  private int a(EmoticonPackage paramEmoticonPackage, ArrayList paramArrayList, List paramList, Map paramMap, Bundle paramBundle, int paramInt)
  {
    int k = paramArrayList.size();
    int i = 0;
    if (i < k)
    {
      Emoticon localEmoticon = (Emoticon)paramArrayList.get(i);
      Object localObject;
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo imgPreview.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        localObject = c(localEmoticon);
        paramList.add(localObject[0]);
        paramMap.put(localObject[0], new File(localObject[1]));
        localObject = localObject[0];
        if (localEmoticon.jobType == 1)
        {
          j = 15;
          label167:
          paramBundle.putInt((String)localObject, j);
        }
      }
      else
      {
        if ((paramInt & 0x4) == 4)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo gif.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
          }
          if (paramEmoticonPackage.jobType != 1) {
            break label619;
          }
          localObject = d(localEmoticon);
          label271:
          if (!FileUtils.a(localObject[1])) {
            paramList.add(localObject[0]);
          }
          paramMap.put(localObject[0], new File(localObject[1]));
          if (paramEmoticonPackage.jobType != 1) {
            break label642;
          }
          paramBundle.putInt(localObject[0], 12);
        }
        if ((paramInt & 0x1) == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo AIO preview static.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt);
          }
          localObject = b(localEmoticon);
          paramList.add(localObject[0]);
          paramMap.put(localObject[0], new File(localObject[1]));
          localObject = localObject[0];
          if (localEmoticon.jobType != 1) {
            break label693;
          }
        }
      }
      label642:
      label693:
      for (int j = 15;; j = 8) {
        for (;;)
        {
          paramBundle.putInt((String)localObject, j);
          if ((localEmoticon.isSound) && ((paramInt & 0x8) == 8))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo sound.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt);
            }
            localObject = a(localEmoticon);
            paramList.add(localObject[0]);
            paramMap.put(localObject[0], new File(localObject[1]));
            paramBundle.putInt(localObject[0], 9);
          }
          i += 1;
          break;
          j = 6;
          break label167;
          label619:
          if (localEmoticon.hasEncryptKey())
          {
            localObject = e(localEmoticon);
            break label271;
          }
          return 11009;
          paramBundle.putInt(localObject[0], 7);
          synchronized (this.jdField_a_of_type_JavaUtilMap)
          {
            this.jdField_a_of_type_JavaUtilMap.put(localObject[0], localEmoticon.encryptKey);
          }
        }
      }
    }
    return 0;
  }
  
  private int a(File paramFile, EmoticonPackage paramEmoticonPackage, boolean paramBoolean, List paramList, Map paramMap, Bundle paramBundle, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ReqInfo localReqInfo = new ReqInfo();
    if (paramFile.exists()) {}
    for (paramFile = FileUtils.a(paramFile);; paramFile = null)
    {
      paramFile = a(paramEmoticonPackage, jdField_c_of_type_Int, paramFile, localArrayList1, localArrayList2, localReqInfo);
      if (paramFile == null) {
        break;
      }
      a("param_error", paramFile, null, 0, null);
      return 11008;
    }
    if (paramBoolean) {}
    for (paramFile = localArrayList2;; paramFile = localArrayList1)
    {
      paramBundle.putBoolean("isUpdate", paramBoolean);
      paramBundle.putSerializable("emoticonList", paramFile);
      if (localReqInfo.jdField_a_of_type_Boolean) {
        break;
      }
      int i = 0;
      int j;
      do
      {
        localReqInfo.jdField_a_of_type_JavaLangString = null;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| fetchEncryptKeys count=" + i);
        }
        a(paramEmoticonPackage.epId, paramFile, localReqInfo, false);
        j = i + 1;
        if (localReqInfo.jdField_a_of_type_Boolean) {
          break;
        }
        i = j;
      } while (j < 3);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| fetchEncryptKeys count=" + j + " encryptKeysSuccess=" + localReqInfo.jdField_a_of_type_Boolean);
      }
      if (localReqInfo.jdField_a_of_type_Boolean) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "qq_error|addEmoticonsTask| fetchEncryptKeys fail epId=" + paramEmoticonPackage.epId + " encryptGetKeySeq=" + localReqInfo.jdField_a_of_type_JavaLangString + " encryptKeysResultCode" + localReqInfo.jdField_a_of_type_Int);
      }
      a(paramEmoticonPackage, localReqInfo.a());
      return 11009;
    }
    paramInt = a(paramEmoticonPackage, paramFile, paramList, paramMap, paramBundle, paramInt);
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      a("param_step", String.valueOf(7), null, 0, null);
      return paramInt;
    }
    return 0;
  }
  
  private Bundle a(String paramString, int paramInt)
  {
    int j = -1;
    int i = 0;
    int k = 0;
    int i2 = 0;
    Object localObject = a().b(paramString);
    int i4;
    int i1;
    int n;
    int m;
    label187:
    int i3;
    if (localObject != null)
    {
      if (((EmoticonPackage)localObject).valid) {
        i = 1;
      }
    }
    else
    {
      i4 = i;
      if (paramInt == 2) {
        i4 = 1;
      }
      localObject = a().a("vipEmoticonKey_" + paramString);
      i1 = i2;
      n = k;
      m = j;
      if (localObject != null)
      {
        i1 = i2;
        n = k;
        m = j;
        if (!((DownloadTask)localObject).b())
        {
          m = 0;
          i1 = (int)((DownloadTask)localObject).a;
          n = 2;
        }
      }
      if (m != -1) {
        break label572;
      }
      i = i1;
      j = n;
      k = m;
      switch (paramInt)
      {
      default: 
        k = m;
        j = n;
        i = i1;
      case 2: 
        i3 = i;
        i2 = j;
        paramInt = k;
        if (QLog.isColorLevel())
        {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getPackageStatus| query result in DB or not DB, result=" + k + " status=" + j + " progress=" + i);
          paramInt = k;
          i2 = j;
          i3 = i;
        }
        break;
      }
    }
    for (;;)
    {
      i = paramInt;
      if (paramInt == -1)
      {
        i = 0;
        i2 = 0;
        i3 = 0;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("id", paramString);
      ((Bundle)localObject).putInt("result", i);
      ((Bundle)localObject).putInt("status", i2);
      ((Bundle)localObject).putInt("pluginStatus", 0);
      ((Bundle)localObject).putLong("pluginSize", 0L);
      ((Bundle)localObject).putInt("progress", i3);
      ((Bundle)localObject).putInt("dEmojiId", -1);
      ((Bundle)localObject).putInt("flag", i4);
      ((Bundle)localObject).putStringArrayList("srcList", null);
      ((Bundle)localObject).putStringArrayList("urlParamsList", null);
      return localObject;
      i = 0;
      break;
      localObject = a().b(paramString);
      i = i1;
      j = n;
      k = m;
      if (localObject == null) {
        break label187;
      }
      i = i1;
      j = n;
      k = m;
      if (((EmoticonPackage)localObject).status != 2) {
        break label187;
      }
      if (b(paramString))
      {
        if (EmoticonUtils.a(((EmoticonPackage)localObject).updateFlag))
        {
          k = 0;
          j = 4;
          i = 0;
          break label187;
        }
        k = 0;
        i = 100;
        j = 3;
        break label187;
      }
      k = 0;
      j = 0;
      i = 0;
      break label187;
      localObject = a().b(paramString);
      i = i1;
      j = n;
      k = m;
      if (localObject == null) {
        break label187;
      }
      i = i1;
      j = n;
      k = m;
      if (((EmoticonPackage)localObject).status != 2) {
        break label187;
      }
      if (a(paramString, Boolean.valueOf(true)))
      {
        k = 0;
        i = 100;
        j = 3;
        break label187;
      }
      k = 0;
      j = 0;
      i = 0;
      break label187;
      label572:
      i3 = i1;
      i2 = n;
      paramInt = m;
      if (QLog.isColorLevel())
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getPackageStatus| query result in running... result=" + m + " status=" + n + " progress=" + i1);
        i3 = i1;
        i2 = n;
        paramInt = m;
      }
    }
  }
  
  private DownloaderInterface a()
  {
    return ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).a(1);
  }
  
  private String a(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {
      return null;
    }
    switch (paramEmoticonPackage.jobType)
    {
    default: 
      return "actEmoPackage";
    case 0: 
      return "actEmoPackage";
    case 2: 
      return "actQFaceGifPackage";
    }
    return "actQFaceMaterial";
  }
  
  private void a(Emoticon paramEmoticon, int paramInt, long paramLong)
  {
    if ((paramInt == 11003) || (paramInt == 11001) || (paramInt == 11000)) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        HashMap localHashMap2 = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.clone();
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        int i = (int)(System.currentTimeMillis() - paramLong);
        if (paramInt == 0) {
          break label133;
        }
        bool = false;
        a("param_FailCode", String.valueOf(paramInt));
        if (paramEmoticon.jobType == 1)
        {
          paramEmoticon = "actQFaceGif";
          StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramEmoticon, bool, i, 0L, localHashMap2, "");
          return;
        }
      }
      paramEmoticon = "actEmoAIO";
      continue;
      label133:
      boolean bool = true;
    }
  }
  
  private void a(Emoticon paramEmoticon, ReqInfo paramReqInfo)
  {
    if ((paramEmoticon == null) || (paramReqInfo == null)) {}
    while ((paramEmoticon.encryptKey != null) && (paramEmoticon.encryptKey.length() > 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramEmoticon);
    a(paramEmoticon.epId, localArrayList, paramReqInfo, false);
  }
  
  private void a(String paramString, ArrayList paramArrayList, ReqInfo paramReqInfo, boolean paramBoolean)
  {
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if ((paramArrayList == null) || (paramArrayList.size() == 0) || (paramReqInfo == null)) {
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    paramString = new Object();
    EmosmHandler localEmosmHandler = (EmosmHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
    Object localObject = new ddw(this, paramReqInfo, localEmosmHandler, paramBoolean, paramArrayList, paramString);
    localEmosmHandler.a((EmosmHandler.EmosmHandlerListener)localObject);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    int j = this.h;
    this.h = (j + 1);
    localObject = Integer.toString(j);
    paramReqInfo.jdField_a_of_type_JavaLangString = ((String)localObject);
    paramReqInfo.jdField_a_of_type_Int = 11022;
    localEmosmHandler.a(i, paramArrayList, (String)localObject);
    try
    {
      try
      {
        paramString.wait(35000L);
        return;
      }
      finally {}
      return;
    }
    catch (InterruptedException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(List paramList, Map paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    String str1 = paramEmoticonPackage.epId;
    int j;
    if (paramEmoticonPackage.jobType == 2)
    {
      str1 = paramEmoticonPackage.kinId;
      j = 13;
    }
    for (int i = 14;; i = 4)
    {
      String str2 = EmosmUtils.getCoverUrl(j, str1);
      String str3 = EmosmUtils.getCoverPath(3, paramEmoticonPackage.epId);
      paramList.add(str2);
      paramMap.put(str2, new File(str3));
      paramBundle.putInt(str2, 3);
      str1 = EmosmUtils.getCoverUrl(i, str1);
      paramEmoticonPackage = EmosmUtils.getCoverPath(4, paramEmoticonPackage.epId);
      paramList.add(str1);
      paramMap.put(str1, new File(paramEmoticonPackage));
      paramBundle.putInt(str1, 4);
      return;
      j = 3;
    }
  }
  
  private String[] a(Emoticon paramEmoticon)
  {
    return new String[] { EmosmUtils.getEmoticonSoundUrl(paramEmoticon.epId, paramEmoticon.eId), EmosmUtils.getEmoticonSoundPath(paramEmoticon.epId, paramEmoticon.eId) };
  }
  
  private void b(List paramList, Map paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (paramEmoticonPackage.jobType == 2) {}
    for (String str = paramEmoticonPackage.kinId;; str = paramEmoticonPackage.epId)
    {
      str = EmosmUtils.getCoverUrl(2, str);
      paramEmoticonPackage = EmosmUtils.getCoverPath(2, paramEmoticonPackage.epId);
      paramList.add(str);
      paramMap.put(str, new File(paramEmoticonPackage));
      paramBundle.putInt(str, 2);
      return;
    }
  }
  
  private boolean b(String paramString, Boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
    if (paramBoolean.booleanValue())
    {
      paramBoolean = (ArrayList)a().a(paramString);
      if (paramBoolean != null)
      {
        paramBoolean = paramBoolean.iterator();
        if (paramBoolean.hasNext())
        {
          paramBoolean = (Emoticon)paramBoolean.next();
          if (paramBoolean == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "one of encrypts is null!" + paramString);
            }
            return false;
          }
          if ((paramBoolean.jobType == 2) && ((paramBoolean.encryptKey == null) || (paramBoolean.encryptKey.length() == 0)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "encrypt isn't exist.epId=" + paramString + " eId=" + paramBoolean.eId);
            }
            return false;
          }
          if (!new File(EmosmUtils.getEmoticonPreviewPath(paramString, paramBoolean.eId)).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emo img preview do not be exist! epId=" + paramString + " eId=" + paramBoolean.eId);
            }
            return false;
          }
          if (!new File(EmosmUtils.getEmoticonEncryptPath(paramString, paramBoolean.eId)).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emo img encrypt file do not be exist! epId=" + paramString + " eId=" + paramBoolean.eId);
            }
            return false;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emoticons do not be exist.epId=" + paramString);
        }
        return false;
      }
    }
    paramBoolean = MagicfaceResLoader.a();
    String str = EmosmUtils.getEmoticonPackageFolder(paramString) + paramBoolean + File.separator + "video.ini";
    File localFile = new File(str);
    Object localObject = localFile;
    if (!localFile.exists())
    {
      paramBoolean = "big";
      str = EmosmUtils.getEmoticonPackageFolder(paramString) + "big" + File.separator + "video.ini";
      localFile = new File(str);
      localObject = localFile;
      if (!localFile.exists()) {
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "videoConfigPath ==" + str);
    }
    localObject = FileUtils.a((File)localObject);
    int j;
    int i;
    if (localObject != null)
    {
      localObject = ((String)localObject).split("&");
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        str = localObject[i];
        if (!new File(EmosmUtils.getEmoticonPackageFolder(paramString) + paramBoolean + File.separator + str).exists()) {
          return false;
        }
        i += 1;
      }
    }
    paramBoolean = new File(EmosmUtils.getEmoticonPackageFolder(paramString) + "audio" + File.separator + "audio.ini");
    if (!paramBoolean.exists()) {
      return false;
    }
    paramBoolean = FileUtils.a(paramBoolean);
    if (paramBoolean != null)
    {
      paramBoolean = paramBoolean.split("&");
      j = paramBoolean.length;
      i = 0;
      while (i < j)
      {
        localObject = paramBoolean[i];
        if (!new File(EmosmUtils.getEmoticonPackageFolder(paramString) + "audio" + File.separator + (String)localObject).exists()) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  private String[] b(Emoticon paramEmoticon)
  {
    String str;
    if (paramEmoticon.jobType == 1) {
      str = EmosmUtils.getQFaceThumbUrl(paramEmoticon.epId, paramEmoticon.eId, paramEmoticon.encryptKey);
    }
    for (paramEmoticon = EmosmUtils.getEmoticonPreviewPath(paramEmoticon.epId, paramEmoticon.eId);; paramEmoticon = EmosmUtils.getEmoticonAIOPreviewPath(paramEmoticon.epId, paramEmoticon.eId))
    {
      return new String[] { str, paramEmoticon };
      str = EmosmUtils.getEmoticonAIOPreviewUrl(paramEmoticon.epId, paramEmoticon.eId);
    }
  }
  
  private void c(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage == null) || (paramEmoticonPackage.epId == null) || (paramEmoticonPackage.jobType != 1)) {
      return;
    }
    new ddx(this, EmosmUtils.getQFaceMaterialFolderPath(paramEmoticonPackage.epId, false)).start();
  }
  
  private void c(List paramList, Map paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (!a(paramEmoticonPackage.epId, jdField_f_of_type_Int))
    {
      String str = EmosmUtils.getMagicFaceMaterialPackageUrl(paramEmoticonPackage.epId, 1);
      paramEmoticonPackage = EmosmUtils.getMagicFaceZipPath(paramEmoticonPackage.epId);
      paramList.add(str);
      paramMap.put(str, new File(paramEmoticonPackage));
      paramBundle.putInt(str, 10);
    }
  }
  
  private String[] c(Emoticon paramEmoticon)
  {
    String str;
    if (paramEmoticon.jobType == 1) {
      str = EmosmUtils.getQFaceThumbUrl(paramEmoticon.epId, paramEmoticon.eId, paramEmoticon.encryptKey);
    }
    for (paramEmoticon = EmosmUtils.getEmoticonPreviewPath(paramEmoticon.epId, paramEmoticon.eId);; paramEmoticon = EmosmUtils.getEmoticonPreviewPath(paramEmoticon.epId, paramEmoticon.eId))
    {
      return new String[] { str, paramEmoticon };
      str = EmosmUtils.getEmoticonPreviewUrl(paramEmoticon.epId, paramEmoticon.eId);
    }
  }
  
  private void d(List paramList, Map paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (!a(paramEmoticonPackage.epId, jdField_e_of_type_Int))
    {
      String str = EmosmUtils.getMagicFaceMaterialPackageUrl(paramEmoticonPackage.epId, 0);
      paramEmoticonPackage = EmosmUtils.getMagicFaceZipPath(paramEmoticonPackage.epId);
      paramList.add(str);
      paramMap.put(str, new File(paramEmoticonPackage));
      paramBundle.putInt(str, 10);
    }
  }
  
  private boolean d(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject = EmosmUtils.getCoverPath(2, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "cover_pkg_thumb isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = EmosmUtils.getCoverPath(3, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "cover_pkg_color isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = EmosmUtils.getCoverPath(4, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "cover_pkg_gray isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = (ArrayList)a().a(paramString);
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      Emoticon localEmoticon;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localEmoticon = (Emoticon)((Iterator)localObject).next();
        if (localEmoticon == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "one of encrypts is null!" + paramString);
          }
          return false;
        }
        if ((localEmoticon.jobType == 0) && ((localEmoticon.encryptKey == null) || (localEmoticon.encryptKey.length() == 0)))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "encrypt isn't exist.epId=" + paramString + " eId=" + localEmoticon.eId);
          }
          return false;
        }
        if (!new File(EmosmUtils.getEmoticonPreviewPath(paramString, localEmoticon.eId)).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emo img preview do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
          }
          return false;
        }
      } while (new File(EmosmUtils.getEmoticonEncryptPath(paramString, localEmoticon.eId)).exists());
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emo img encrypt file do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emoticons do not be exist.epId=" + paramString);
    }
    return true;
  }
  
  private String[] d(Emoticon paramEmoticon)
  {
    return new String[] { EmosmUtils.getQFaceGifUrl(paramEmoticon.epId, paramEmoticon.eId, paramEmoticon.encryptKey), EmosmUtils.getQFaceGifPath(paramEmoticon.epId, paramEmoticon.eId) };
  }
  
  private String[] e(Emoticon paramEmoticon)
  {
    return new String[] { EmosmUtils.getEmoticonEncrytUrl(paramEmoticon.epId, paramEmoticon.eId), EmosmUtils.getEmoticonEncryptPath(paramEmoticon.epId, paramEmoticon.eId) };
  }
  
  public float a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return -1.0F;
      paramString = a().a("vipEmoticonKey_" + paramString);
    } while (paramString == null);
    return paramString.a;
  }
  
  public Bundle a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (ArrayList)a().b();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        if (localEmoticonPackage.jobType == 0) {
          localArrayList.add(a(localEmoticonPackage.epId, 1));
        } else if (localEmoticonPackage.jobType == 3) {
          localArrayList.add(a(localEmoticonPackage.epId, 3));
        } else if (localEmoticonPackage.kinId != null) {
          localArrayList.add(a(localEmoticonPackage.kinId, 2));
        }
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putParcelableArrayList("pkgStatusList", localArrayList);
    return localObject;
  }
  
  public Bundle a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    String str = String.valueOf(paramBundle.getInt("id"));
    int i = paramBundle.getInt("businessType");
    if (a().a("vipEmoticonKey_" + str) != null)
    {
      localBundle.putInt("result", 0);
      localBundle.putString("messge", "");
      return localBundle;
    }
    paramBundle = a().b(str);
    if ((paramBundle != null) && (paramBundle.status != 0))
    {
      switch (paramBundle.status)
      {
      default: 
        i = 1;
      }
      for (;;)
      {
        if ((paramBundle != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_detail", 0, 0, paramBundle.epId, "" + paramBundle.localVersion, "" + paramBundle.latestVersion, "");
        }
        localBundle.putInt("result", i);
        localBundle.putString("messge", "");
        return localBundle;
        if (EmoticonUtils.a(paramBundle.updateFlag))
        {
          a(paramBundle, true);
          i = 0;
        }
        else
        {
          i = 3;
          continue;
          i = 4;
        }
      }
    }
    EmoticonPackage localEmoticonPackage = a().a(str);
    paramBundle = localEmoticonPackage;
    if (localEmoticonPackage == null)
    {
      paramBundle = new EmoticonPackage();
      paramBundle.epId = str;
      paramBundle.wordingId = -1L;
      if (i != 2) {
        break label367;
      }
      paramBundle.jobType = 1;
    }
    for (;;)
    {
      paramBundle.isMagicFaceDownloading = false;
      a(paramBundle, true);
      localBundle.putInt("result", 0);
      localBundle.putString("messge", "");
      return localBundle;
      label367:
      if (i == 3) {
        paramBundle.jobType = 3;
      } else {
        paramBundle.jobType = 0;
      }
    }
  }
  
  public Bundle a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = a().a("vipEmoticonKey_" + paramString);
    if (paramString != null)
    {
      paramString.a(true);
      paramString = (EmoticonPackage)paramString.a().getSerializable("emoticonPackage");
      if (paramString != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramString, 11007, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    paramString = new Bundle();
    paramString.putInt("result", 0);
    paramString.putString("messge", "");
    return paramString;
  }
  
  public EmoticonManager a()
  {
    return (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
  }
  
  public String a(EmoticonPackage paramEmoticonPackage, int paramInt, byte[] paramArrayOfByte, ArrayList paramArrayList1, ArrayList paramArrayList2, ReqInfo paramReqInfo)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 1))
    {
      paramArrayOfByte = "json data is null";
      return paramArrayOfByte;
    }
    EmoticonManager localEmoticonManager = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    for (;;)
    {
      Object localObject1;
      String str1;
      Object localObject2;
      int j;
      int k;
      int m;
      int i;
      boolean bool;
      int n;
      String str2;
      String str3;
      int i1;
      int i2;
      try
      {
        localObject1 = new JSONObject(new String(paramArrayOfByte, "utf-8"));
        str1 = ((JSONObject)localObject1).getString("id");
        localObject2 = ((JSONObject)localObject1).getString("name");
        if (!((JSONObject)localObject1).has("mark")) {
          break label1233;
        }
        paramArrayOfByte = ((JSONObject)localObject1).getString("mark");
        if (!((JSONObject)localObject1).has("type")) {
          break label1227;
        }
        j = ((JSONObject)localObject1).getInt("type");
        if (!((JSONObject)localObject1).has("feetype")) {
          break label1221;
        }
        k = ((JSONObject)localObject1).getInt("feetype");
        if (!((JSONObject)localObject1).has("updateTime")) {
          break label1215;
        }
        m = ((JSONObject)localObject1).getInt("updateTime");
        i = 0;
        if (!((JSONObject)localObject1).has("ringtype")) {
          break label1209;
        }
        Object localObject3 = ((JSONObject)localObject1).getString("ringtype");
        if ("1".equals(localObject3))
        {
          bool = true;
          if ((!((JSONObject)localObject1).has("type")) || (1 != j)) {
            break label1206;
          }
          i = 3;
          n = 0;
          if (((JSONObject)localObject1).has("downloadcount")) {
            n = ((JSONObject)localObject1).getInt("downloadcount");
          }
          paramEmoticonPackage.name = ((String)localObject2);
          paramEmoticonPackage.mark = paramArrayOfByte;
          paramEmoticonPackage.type = j;
          paramEmoticonPackage.mobileFeetype = k;
          paramEmoticonPackage.hasSound = bool;
          paramEmoticonPackage.downloadCount = n;
          paramEmoticonPackage.jobType = i;
          if (paramInt != jdField_d_of_type_Int) {
            paramEmoticonPackage.localVersion = m;
          }
          if ((paramEmoticonPackage.mobileFeetype == 1) || (paramEmoticonPackage.isRecommendation) || (paramEmoticonPackage.jobType == 1))
          {
            paramEmoticonPackage.wordingId = 1L;
            localEmoticonManager.a(paramEmoticonPackage);
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "PARSE_EMOTICON_JSON epId[" + str1 + "]name[" + (String)localObject2 + "]mark[" + paramArrayOfByte + "]type[" + j + "]feetype[" + k + "]");
            }
            localObject3 = ((JSONObject)localObject1).getJSONArray("imgs");
            int i3 = ((JSONArray)localObject3).length();
            i = 1;
            k = 0;
            j = 0;
            if (k >= i3) {
              break label1171;
            }
            paramArrayOfByte = ((JSONArray)localObject3).getJSONObject(k);
            str2 = paramArrayOfByte.getString("id");
            str3 = paramArrayOfByte.getString("name");
            if (!paramArrayOfByte.has("wWidthInPhone")) {
              break label1200;
            }
            n = paramArrayOfByte.getInt("wWidthInPhone");
            if (!paramArrayOfByte.has("wHeightInPhone")) {
              break label1194;
            }
            i1 = paramArrayOfByte.getInt("wHeightInPhone");
            if (!paramArrayOfByte.has("keywords")) {
              break label1003;
            }
            localObject1 = paramArrayOfByte.getJSONArray("keywords");
            if (str3 != null) {
              ((JSONArray)localObject1).put(str3);
            }
            paramArrayOfByte = paramArrayOfByte.getJSONArray("keywords").toString();
            localObject2 = localEmoticonManager.a(str1, str2);
            i2 = 0;
            if (localObject2 != null) {
              break label1034;
            }
            m = i2;
            localObject1 = localObject2;
            if (paramInt != jdField_d_of_type_Int)
            {
              localObject2 = new Emoticon();
              ((Emoticon)localObject2).eId = str2;
              ((Emoticon)localObject2).epId = str1;
              ((Emoticon)localObject2).name = str3;
              ((Emoticon)localObject2).width = n;
              ((Emoticon)localObject2).height = i1;
              ((Emoticon)localObject2).keywords = paramArrayOfByte;
              n = 1;
              m = i2;
              localObject1 = localObject2;
              i = n;
              if (EmoticonUtils.a(paramEmoticonPackage))
              {
                paramArrayList2.add(localObject2);
                m = 1;
                i = n;
                localObject1 = localObject2;
              }
            }
            n = j;
            if (localObject1 != null)
            {
              if ((((Emoticon)localObject1).encryptKey == null) || (((Emoticon)localObject1).encryptKey.length() < 1)) {
                break label1240;
              }
              ((Emoticon)localObject1).isSound = paramEmoticonPackage.hasSound;
              paramArrayList1.add(localObject1);
              n = j;
            }
            if ((i != 0) && (m == 0)) {
              localEmoticonManager.a((Emoticon)localObject1);
            }
            if (!QLog.isColorLevel()) {
              break label1246;
            }
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emoticon eId[" + str2 + "]eName[" + str3 + "]");
            break label1246;
          }
        }
        else
        {
          if (!"2".equals(localObject3)) {
            break label1209;
          }
          i = 1;
          bool = false;
          continue;
        }
        localObject3 = localEmoticonManager.b(str1);
        if (localObject3 != null)
        {
          paramEmoticonPackage.wordingId = ((EmoticonPackage)localObject3).wordingId;
          continue;
        }
      }
      catch (JSONException paramArrayList2)
      {
        paramArrayList2.printStackTrace();
        paramArrayList1 = paramArrayList2.toString();
        paramArrayOfByte = paramArrayList1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "PARSE_EMOTICON_JSON fail 01 RESULT_CODE_JSON_PARSE_FAIL  ep=" + paramEmoticonPackage.epId + " exception=" + paramArrayList2.toString());
        return paramArrayList1;
        paramEmoticonPackage.wordingId = -1L;
        continue;
      }
      catch (Exception paramArrayList2)
      {
        paramArrayList2.printStackTrace();
        paramArrayList1 = paramArrayList2.toString();
        paramArrayOfByte = paramArrayList1;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "PARSE_EMOTICON_JSON fail 02 RESULT_CODE_JSON_PARSE_FAIL  ep=" + paramEmoticonPackage.epId + " exception=" + paramArrayList2.toString());
      return paramArrayList1;
      label1003:
      paramArrayOfByte = "[" + str3 + "]";
      continue;
      label1034:
      if ((!str2.equals(((Emoticon)localObject2).eId)) || (!str1.equals(((Emoticon)localObject2).epId)) || (!str3.equals(((Emoticon)localObject2).name)))
      {
        ((Emoticon)localObject2).eId = str2;
        ((Emoticon)localObject2).epId = str1;
        ((Emoticon)localObject2).name = str3;
        ((Emoticon)localObject2).width = n;
        ((Emoticon)localObject2).height = i1;
        ((Emoticon)localObject2).keywords = paramArrayOfByte;
        i = 1;
        m = i2;
        localObject1 = localObject2;
      }
      else
      {
        i = 0;
        m = i2;
        localObject1 = localObject2;
        if (!paramArrayOfByte.equals(((Emoticon)localObject2).keywords))
        {
          i = 1;
          ((Emoticon)localObject2).keywords = paramArrayOfByte;
          m = i2;
          localObject1 = localObject2;
          continue;
          label1171:
          if (j != 0)
          {
            paramReqInfo.jdField_a_of_type_Boolean = false;
            break label1259;
          }
          paramReqInfo.jdField_a_of_type_Boolean = true;
          break label1259;
          label1194:
          i1 = 0;
          continue;
          label1200:
          n = 0;
          continue;
          label1206:
          continue;
          label1209:
          bool = false;
          continue;
          label1215:
          m = 0;
          continue;
          label1221:
          k = 0;
          continue;
          label1227:
          j = 0;
          continue;
          label1233:
          paramArrayOfByte = "";
          continue;
          label1240:
          j = 1;
          continue;
          label1246:
          k += 1;
          j = n;
        }
      }
    }
    label1259:
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.c.clear();
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    b(paramEmoticonPackage, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramEmoticonPackage == null) || (paramInt == 11007) || (paramInt == 11003) || (paramInt == 11001) || (paramInt == 11000)) {
      return;
    }
    HashMap localHashMap1 = this.jdField_a_of_type_JavaUtilHashMap;
    boolean bool = true;
    if (paramInt != 0) {}
    try
    {
      a("param_FailCode", String.valueOf(paramInt), null, 0, null);
      bool = false;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        HashMap localHashMap2 = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.clone();
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), a(paramEmoticonPackage), bool, 0L, 0L, localHashMap2, "");
      }
      return;
    }
    finally {}
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "download emoji report actionResult=" + paramInt + ",epId=" + paramEmoticonPackage.epId + ",downloadTime=" + paramLong);
    }
    int i = 0;
    if (paramInt != 0) {
      i = 1;
    }
    paramInt = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext());
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "EMOJI_DOWN", a(paramEmoticonPackage), 0, i, paramEmoticonPackage.epId + "", paramInt + "", "", String.valueOf(paramLong));
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, DownloadListener paramDownloadListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleQFaceGifPackage ep:" + paramEmoticonPackage);
    }
    ArrayList localArrayList1 = (ArrayList)a().a(paramEmoticonPackage.epId);
    if (localArrayList1 == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, 0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleQFaceGifPackage|epId:" + paramEmoticonPackage.epId + " has not any emoticon");
      }
      return;
    }
    ArrayList localArrayList2 = new ArrayList();
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticonPackage", paramEmoticonPackage);
    a(localArrayList2, localHashMap, paramEmoticonPackage, localBundle);
    b(localArrayList2, localHashMap, paramEmoticonPackage, localBundle);
    int i = a(paramEmoticonPackage, localArrayList1, localArrayList2, localHashMap, localBundle, 14);
    if (i != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      a(paramEmoticonPackage, i);
      return;
    }
    paramEmoticonPackage = new DownloadTask(localArrayList2, localHashMap, "vipEmoticonKey_" + paramEmoticonPackage.epId);
    paramEmoticonPackage.e = this.g;
    a().a(paramEmoticonPackage, paramDownloadListener, localBundle);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmoticonPackage ep:" + paramEmoticonPackage);
    }
    Object localObject2 = EmosmUtils.getEmosmJsonUrl(paramEmoticonPackage.epId);
    Object localObject1 = new File(EmosmUtils.getEmosmJsonFile(paramEmoticonPackage.epId));
    localObject2 = new DownloadTask((String)localObject2, (File)localObject1);
    ((DownloadTask)localObject2).h = true;
    int i = DownloaderFactory.a((DownloadTask)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i != 0)
    {
      i = EmosmUtils.checkResultCode(i);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      a(paramEmoticonPackage, i);
    }
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      HashMap localHashMap = new HashMap();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putSerializable("emoticonPackage", paramEmoticonPackage);
      ((Bundle)localObject2).putBoolean("newPkgAdd", paramBoolean);
      paramBoolean = EmoticonUtils.a(paramEmoticonPackage);
      if (!paramBoolean)
      {
        a(localArrayList, localHashMap, paramEmoticonPackage, (Bundle)localObject2);
        b(localArrayList, localHashMap, paramEmoticonPackage, (Bundle)localObject2);
      }
      i = a((File)localObject1, paramEmoticonPackage, paramBoolean, localArrayList, localHashMap, (Bundle)localObject2, 14);
      if (i == 0)
      {
        localObject1 = new DownloadTask(localArrayList, localHashMap, "vipEmoticonKey_" + paramEmoticonPackage.epId);
        a().a((DownloadTask)localObject1, paramDownloadListener, (Bundle)localObject2);
      }
      while (QLog.isColorLevel())
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmoticonPackage| ep download finish resultCode:" + i + " epId:" + paramEmoticonPackage.epId);
        return;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        a(paramEmoticonPackage, i);
      }
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, boolean paramBoolean)
  {
    if ((paramEmoticonPackage == null) || (paramEmoticonPackage.epId == null)) {}
    HashMap localHashMap;
    do
    {
      do
      {
        return;
      } while (a().a("vipEmoticonKey_" + paramEmoticonPackage.epId) != null);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "try to pullEmoticonPackage ep:" + paramEmoticonPackage.epId);
      }
      if (EmosmUtils.isNumeral(paramEmoticonPackage.epId)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "ep.epId=" + paramEmoticonPackage.epId + " isNumeral false.");
      }
      localHashMap = new HashMap();
      localHashMap.put("param_FailCode", Integer.toString(11024));
      localHashMap.put("param_epId", paramEmoticonPackage.epId);
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), a(paramEmoticonPackage), false, 0L, 0L, localHashMap, "");
    return;
    if (!paramEmoticonPackage.isMagicFaceDownloading) {
      if ((paramEmoticonPackage.status != 2) || (!EmoticonUtils.a(paramEmoticonPackage.updateFlag))) {
        break label273;
      }
    }
    for (;;)
    {
      paramEmoticonPackage.valid = true;
      a().a(paramEmoticonPackage);
      a().a(paramEmoticonPackage.epId);
      ThreadManager.a(new ddv(this, paramEmoticonPackage, paramBoolean));
      return;
      label273:
      paramEmoticonPackage.status = 0;
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      paramString = a().a("vipEmoticonKey_" + paramString);
    } while (paramString == null);
    paramString.a(true);
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, this.jdField_f_of_type_ComTencentMobileqqVipDownloadListener);
  }
  
  public void a(String paramString1, int paramInt1, SogouEmoji.OnEmojiJsonBackSogou paramOnEmojiJsonBackSogou, int paramInt2, String paramString2)
  {
    this.jdField_b_of_type_JavaUtilMap.put(paramString1, new Object[] { paramOnEmojiJsonBackSogou, Integer.valueOf(paramInt2), paramString1, paramString2 });
    a(paramString1, paramInt1, this.jdField_f_of_type_ComTencentMobileqqVipDownloadListener);
  }
  
  public void a(String paramString, int paramInt, DownloadListener paramDownloadListener)
  {
    if (a(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startDownloadEmosmJson|epId is in downloading:" + paramString);
      }
      return;
    }
    Object localObject2 = a().a(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startDownloadEmosmJson|emoPackage is not exist:" + paramString);
      }
      localObject1 = new EmoticonPackage();
      ((EmoticonPackage)localObject1).epId = paramString;
      ((EmoticonPackage)localObject1).status = 0;
    }
    a().a((EmoticonPackage)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startDownloadEmosmJson epId:" + ((EmoticonPackage)localObject1).epId);
    }
    paramString = new DownloadTask(EmosmUtils.getEmosmJsonUrl(paramString), new File(EmosmUtils.getEmosmJsonFile(paramString)));
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("jsonType", paramInt);
    ((Bundle)localObject2).putSerializable("emoticonPackage", (Serializable)localObject1);
    paramString.e = this.g;
    a().a(paramString, paramDownloadListener, (Bundle)localObject2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null, 0, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramString2 == null) || (paramString2.length() <= 0)) {}
    while (("param_error".equals(paramString1)) || ("param_resp_content_read".equals(paramString1)) || ("param_resp_content".equals(paramString1)) || ("param_try_count".equals(paramString1))) {
      return;
    }
    if (("param_step".equals(paramString1)) && (Integer.toString(5).equals(paramString2)))
    {
      if ((paramString3 != null) && (paramString3.length() > 0)) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_key_seq", paramString3);
      }
      if (paramInt > 0) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_encrypt_keys", Integer.toString(paramInt));
      }
      if ((paramString4 != null) && (paramString4.length() > 0)) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_timeout", paramString4);
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public boolean a()
  {
    if (-1L == jdField_a_of_type_Long)
    {
      jdField_a_of_type_Long = System.currentTimeMillis();
      return true;
    }
    if (-1L == jdField_b_of_type_Long)
    {
      jdField_b_of_type_Long = System.currentTimeMillis();
      return true;
    }
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long > 30000L)
    {
      jdField_a_of_type_Long = jdField_b_of_type_Long;
      jdField_b_of_type_Long = l;
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4) || (paramInt == 2);
  }
  
  public boolean a(Emoticon paramEmoticon, int paramInt)
  {
    if ((paramEmoticon == null) || (paramEmoticon.epId == null) || (paramEmoticon.eId == null)) {}
    while (a().a("vipEmoticonKey_" + paramEmoticon.epId) == null) {
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return false;
      paramString = EmosmUtils.getEmosmJsonUrl(paramString);
      paramString = a().a(paramString);
    } while ((paramString == null) || (paramString.b()));
    return true;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    int i;
    if (paramInt == jdField_f_of_type_Int)
    {
      localObject1 = MagicfaceResLoader.a();
      String str = EmosmUtils.getEmoticonPackageFolder(paramString) + (String)localObject1 + File.separator + "video.ini";
      File localFile = new File(str);
      localObject2 = localFile;
      if (!localFile.exists())
      {
        localObject1 = "big";
        str = EmosmUtils.getEmoticonPackageFolder(paramString) + "big" + File.separator + "video.ini";
        localFile = new File(str);
        localObject2 = localFile;
        if (!localFile.exists()) {
          return false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "videoConfigPath ==" + str);
      }
      localObject2 = FileUtils.a((File)localObject2).split("&");
      i = localObject2.length;
      paramInt = 0;
      while (paramInt < i)
      {
        str = localObject2[paramInt];
        if (!new File(EmosmUtils.getEmoticonPackageFolder(paramString) + (String)localObject1 + File.separator + str).exists()) {
          return false;
        }
        paramInt += 1;
      }
    }
    if (paramInt == jdField_e_of_type_Int)
    {
      localObject1 = new File(EmosmUtils.getEmoticonPackageFolder(paramString) + "audio" + File.separator + "audio.ini");
      if (!((File)localObject1).exists()) {
        return false;
      }
      localObject1 = FileUtils.a((File)localObject1).split("&");
      i = localObject1.length;
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = localObject1[paramInt];
        if (!new File(EmosmUtils.getEmoticonPackageFolder(paramString) + "audio" + File.separator + (String)localObject2).exists()) {
          return false;
        }
        paramInt += 1;
      }
    }
    return true;
  }
  
  public boolean a(String paramString, Boolean paramBoolean)
  {
    boolean bool = b(paramString, paramBoolean);
    paramString = a().a(paramString);
    if (paramString != null)
    {
      if (!bool) {
        break label51;
      }
      if (paramString.status != 2)
      {
        paramString.status = 2;
        a().a(paramString);
      }
    }
    label51:
    while (paramString.status == 0) {
      return bool;
    }
    paramString.status = 0;
    a().a(paramString);
    return bool;
  }
  
  public Bundle b(Bundle paramBundle)
  {
    int i = 1;
    Object localObject = paramBundle.getString("id");
    int k = paramBundle.getInt("businessType");
    if ((paramBundle == null) || (localObject == null) || (((String)localObject).length() == 0)) {
      i = 0;
    }
    for (;;)
    {
      paramBundle = new Bundle();
      if (i != 0)
      {
        localObject = a((String)localObject, k);
        paramBundle.putInt("result", ((Bundle)localObject).getInt("result"));
        paramBundle.putString("messge", "");
        paramBundle.putInt("id", -1);
        paramBundle.putInt("status", ((Bundle)localObject).getInt("status"));
        paramBundle.putInt("pluginStatus", ((Bundle)localObject).getInt("pluginStatus"));
        paramBundle.putLong("pluginSize", ((Bundle)localObject).getLong("pluginSize"));
        paramBundle.putInt("progress", ((Bundle)localObject).getInt("progress"));
        paramBundle.putInt("dynamicEmojiId", ((Bundle)localObject).getInt("dEmojiId"));
        paramBundle.putStringArrayList("dynamicEmojiList", ((Bundle)localObject).getStringArrayList("srcList"));
        paramBundle.putStringArrayList("urlParamsList", ((Bundle)localObject).getStringArrayList("urlParamsList"));
        return paramBundle;
        try
        {
          j = Integer.parseInt((String)localObject);
          if (j == -1) {
            i = 0;
          }
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e(this.jdField_a_of_type_JavaLangString, 2, "clear History. uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + " app=" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
            }
            int j = -1;
          }
        }
      }
    }
    paramBundle.putInt("result", 0);
    paramBundle.putString("messge", "");
    paramBundle.putInt("id", -1);
    paramBundle.putInt("status", 0);
    paramBundle.putInt("pluginStatus", 0);
    paramBundle.putLong("pluginSize", 0L);
    paramBundle.putInt("progress", 0);
    paramBundle.putInt("dynamicEmojiId", -1);
    paramBundle.putStringArrayList("dynamicEmojiList", null);
    paramBundle.putStringArrayList("urlParamsList", null);
    return paramBundle;
  }
  
  public void b()
  {
    if (a() != null) {
      a().e();
    }
  }
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.c(paramEmoticonPackage);
  }
  
  public void b(EmoticonPackage paramEmoticonPackage, DownloadListener paramDownloadListener)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticonPackage", paramEmoticonPackage);
    a(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
    b(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
    paramEmoticonPackage = new DownloadTask(localArrayList, localHashMap, "vipEmoticonKey_cover_" + paramEmoticonPackage.epId);
    paramEmoticonPackage.e = this.g;
    a().a(paramEmoticonPackage, paramDownloadListener, localBundle);
  }
  
  public void b(EmoticonPackage paramEmoticonPackage, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "ep:" + paramEmoticonPackage);
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleMagicFacePackage| netUnSupport epId=" + paramEmoticonPackage.epId);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, 11003, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticonPackage", paramEmoticonPackage);
    localBundle.putBoolean("newPkgAdd", paramBoolean);
    Object localObject;
    if (!paramEmoticonPackage.isMagicFaceDownloading)
    {
      localObject = "vipEmoticonKey_" + paramEmoticonPackage.epId;
      String str = EmosmUtils.getEmosmJsonUrl(paramEmoticonPackage.epId);
      File localFile = new File(EmosmUtils.getEmosmJsonFile(paramEmoticonPackage.epId));
      int k = DownloaderFactory.a(new DownloadTask(str, localFile), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      i = EmosmUtils.checkResultCode(k);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, i);
      if (k != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        a("param_error", "json download fail");
        a(paramEmoticonPackage, i);
        return;
      }
      int j = a(localFile, paramEmoticonPackage, false, localArrayList, localHashMap, localBundle, 14);
      i = j;
      if (j != 0)
      {
        i = EmosmUtils.checkResultCode(k);
        a("param_error", "json data is null");
        a(paramEmoticonPackage, i);
      }
    }
    for (;;)
    {
      b(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
      c(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
      d(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
      localObject = new DownloadTask(localArrayList, localHashMap, (String)localObject);
      a().a((DownloadTask)localObject, paramDownloadListener, localBundle);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleMagicFacePackage| ep download finish resultCode:" + i + " epId:" + paramEmoticonPackage.epId);
      return;
      localObject = "vipEmoticonKey_auto_" + paramEmoticonPackage.epId;
    }
  }
  
  public boolean b(Emoticon paramEmoticon, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon|taskvalue:" + paramInt + "，epid:" + paramEmoticon.epId + "，eid=" + paramEmoticon.eId);
    }
    if (Utils.e())
    {
      if (Utils.b() < 1048576L)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "qq_error|sdcardcheck,sdcard full .return. epId=" + paramEmoticon.epId);
        }
        return false;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "qq_error|sdcardcheck,has sdcard FALSE .return. epId=" + paramEmoticon.epId);
      }
      return false;
    }
    Object localObject1;
    if ((paramInt & 0x2) == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo imgPreview.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
      }
      localObject1 = c(paramEmoticon);
      if (DownloaderFactory.a(new DownloadTask(localObject1[0], new File(localObject1[1])), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0)
      {
        a("param_step", String.valueOf(6));
        a(paramEmoticon, 11011, l);
        return false;
      }
    }
    File localFile;
    DownloadTask localDownloadTask;
    Object localObject2;
    if ((paramInt & 0x4) == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo gif.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
      }
      if (paramEmoticon.jobType == 1) {
        localObject1 = d(paramEmoticon);
      }
      do
      {
        localFile = new File(localObject1[1]);
        localDownloadTask = new DownloadTask(localObject1[0], localFile);
        if (DownloaderFactory.a(localDownloadTask, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) {
          break;
        }
        a("param_step", String.valueOf(7));
        a(paramEmoticon, 11011, l);
        return false;
        localObject1 = e(paramEmoticon);
        localObject2 = new ReqInfo();
        a(paramEmoticon, (ReqInfo)localObject2);
      } while ((paramEmoticon.encryptKey != null) && (paramEmoticon.encryptKey.length() != 0));
      paramInt = ((ReqInfo)localObject2).a();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "qq_error|Emotiocon need EncryptKey, fetched fail. resultCode=" + paramInt + "pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + 4 + " time:" + System.currentTimeMillis());
      }
      a("param_step", String.valueOf(5));
      a(paramEmoticon, paramInt, l);
      return false;
      if (paramEmoticon.jobType != 1)
      {
        localObject2 = null;
        localObject1 = null;
        if (localFile == null) {
          break label1229;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = FileUtils.a(localFile);
        localObject1 = localFile.getAbsolutePath();
        localFile.delete();
      }
      catch (Throwable localThrowable)
      {
        int i;
        localThrowable.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onProgress|qq_error| Emotiocon encode resource fail .EXCEPTION:" + localThrowable.toString() + " time:" + System.currentTimeMillis() + " url=" + localDownloadTask.b);
        a(paramEmoticon, 11019, l);
        return false;
      }
      a(paramEmoticon, 11019, l);
      return false;
      i = EmosmUtils.saveEmosm((byte[])localObject2, paramEmoticon.encryptKey, (String)localObject1);
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onProgress|qq_error|download encrypt exception, url=" + localDownloadTask.b);
        }
        if ((Utils.e()) && (Utils.b() > 1048576L)) {
          FileUtils.a(AppConstants.as + "err" + File.separator + String.valueOf(paramEmoticon.epId) + "_" + paramEmoticon.encryptKey + "_" + localFile.getName(), (byte[])localObject2, false);
        }
        a(paramEmoticon, 11017, l);
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onProgress| Emotiocon encode resource done.result=" + i + " time:" + System.currentTimeMillis() + " url=" + localDownloadTask.b);
      }
      if ((paramInt & 0x1) == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo AIO preview static.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt);
        }
        localObject1 = b(paramEmoticon);
        if (DownloaderFactory.a(new DownloadTask(localObject1[0], new File(localObject1[1])), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0)
        {
          a("param_step", String.valueOf(8));
          a(paramEmoticon, 11011, l);
          return false;
        }
      }
      String[] arrayOfString;
      if ((paramEmoticon.isSound) && ((paramInt & 0x8) == 8))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo sound.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        arrayOfString = a(paramEmoticon);
        if (DownloaderFactory.a(new DownloadTask(arrayOfString[0], new File(arrayOfString[1])), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0)
        {
          a("param_step", String.valueOf(9), null, 0, null);
          a(paramEmoticon, 11011, l);
          return false;
        }
      }
      return true;
      label1229:
      if (localObject2 != null) {
        if (arrayOfString != null) {}
      }
    }
  }
  
  public boolean b(String paramString)
  {
    boolean bool = d(paramString);
    paramString = a().a(paramString);
    if (paramString != null)
    {
      if (!bool) {
        break label50;
      }
      if (paramString.status != 2)
      {
        paramString.status = 2;
        a().a(paramString);
      }
    }
    label50:
    while (paramString.status == 0) {
      return bool;
    }
    paramString.status = 0;
    a().a(paramString);
    return bool;
  }
  
  public Bundle c(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    int j = paramBundle.getInt("result");
    String str3 = paramBundle.getString("qFace_name");
    int k = paramBundle.getInt("qFace_type");
    String str4 = paramBundle.getString("qFace_author");
    Object localObject = paramBundle.getString("qFace_material_id");
    String str1 = paramBundle.getString("qFace_pack_id");
    String str2 = paramBundle.getString("qFace_md5");
    ArrayList localArrayList1 = paramBundle.getStringArrayList("qFace_eId_arr");
    ArrayList localArrayList2 = paramBundle.getStringArrayList("qFace_shortcut_arr");
    if (((j == -1) && (localArrayList2 != null) && (localArrayList1 != null) && (localArrayList2.size() == localArrayList1.size()) && (str2 != null)) || (j == 102) || (j == 101)) {}
    for (int i = 1; i == 0; i = 0) {
      return null;
    }
    if (j != -1)
    {
      paramBundle = a().a((String)localObject);
      paramBundle.status = 0;
      a().a(paramBundle);
      c(paramBundle);
      paramBundle = new Bundle();
      paramBundle.putInt("result", 0);
      paramBundle.putString("messge", "");
      return paramBundle;
    }
    EmoticonPackage localEmoticonPackage = a().a((String)localObject);
    if (localEmoticonPackage != null)
    {
      paramBundle = null;
      if (localEmoticonPackage.kinId != null) {
        paramBundle = a().a(localEmoticonPackage.kinId);
      }
      if (paramBundle != null)
      {
        a().b(paramBundle.epId);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.b(paramBundle);
      }
      localEmoticonPackage.status = 2;
      localEmoticonPackage.kinId = str1;
      localEmoticonPackage.jobType = 1;
      a().a(localEmoticonPackage);
    }
    paramBundle = new EmoticonPackage();
    paramBundle.epId = str1;
    paramBundle.author = str4;
    paramBundle.kinId = ((String)localObject);
    paramBundle.jobType = 2;
    paramBundle.name = str3;
    paramBundle.status = 2;
    paramBundle.type = k;
    paramBundle.valid = true;
    a().a(paramBundle);
    j = localArrayList2.size();
    i = 0;
    while (i < j)
    {
      str3 = (String)localArrayList1.get(i);
      str4 = (String)localArrayList2.get(i);
      localObject = new Emoticon();
      ((Emoticon)localObject).eId = str3;
      ((Emoticon)localObject).epId = str1;
      ((Emoticon)localObject).jobType = 1;
      ((Emoticon)localObject).name = str4;
      ((Emoticon)localObject).encryptKey = str2;
      a().a((Emoticon)localObject);
      i += 1;
    }
    a().a(str1);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramBundle = new Bundle();
    paramBundle.putInt("result", 0);
    paramBundle.putString("messge", "");
    return paramBundle;
  }
  
  public boolean c(Emoticon paramEmoticon, int paramInt)
  {
    boolean bool1;
    if (paramEmoticon == null)
    {
      bool1 = true;
      return bool1;
    }
    String str;
    if ((paramInt & 0x1) == 1) {
      if (paramEmoticon.jobType == 1) {
        str = EmosmUtils.getEmoticonPreviewPath(paramEmoticon.epId, paramEmoticon.eId);
      }
    }
    label36:
    for (boolean bool2 = FileUtil.a(str);; bool2 = true)
    {
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if ((paramInt & 0x4) == 4) {
          if (paramEmoticon.jobType != 1) {
            break label182;
          }
        }
      }
      label182:
      for (str = EmosmUtils.getQFaceGifPath(paramEmoticon.epId, paramEmoticon.eId);; str = EmosmUtils.getEmoticonEncryptPath(paramEmoticon.epId, paramEmoticon.eId))
      {
        bool1 = FileUtil.a(str);
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if ((paramInt & 0x2) == 2) {
            bool2 = FileUtil.a(EmosmUtils.getEmoticonPreviewPath(paramEmoticon.epId, paramEmoticon.eId));
          }
        }
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        bool1 = bool2;
        if (!paramEmoticon.isSound) {
          break;
        }
        bool1 = bool2;
        if ((paramInt & 0x8) != 8) {
          break;
        }
        return FileUtil.a(EmosmUtils.getEmoticonSoundPath(paramEmoticon.epId, paramEmoticon.eId));
        str = EmosmUtils.getEmoticonAIOPreviewPath(paramEmoticon.epId, paramEmoticon.eId);
        break label36;
      }
    }
  }
  
  public boolean c(String paramString)
  {
    return new File(EmosmUtils.getEmoticonPackageFolder(paramString) + "audio" + File.separator + "audio.ini").exists();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "clear History. uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + " app=" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a();
    ??? = (EmosmHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
    if (??? != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((EmosmHandler)???).b((EmosmHandler.EmosmHandlerListener)localIterator.next());
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (a() != null) {
      a().d();
    }
    if (this.jdField_b_of_type_JavaUtilMap != null) {
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiManager
 * JD-Core Version:    0.7.0.1
 */