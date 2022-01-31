package com.tencent.mobileqq.emoticon;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.EmosmHandler.EmosmHandlerListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.web.MessengerService.EmoDataInfo;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fsf;
import fsg;
import fsh;
import fsi;
import fsj;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class EmoticonController
{
  public static final int a = 3;
  public static final long a = 35000L;
  private static EmoticonController jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController;
  public static final String a = "LAST_ADD_EMO_PACKAGE";
  public static final boolean a = false;
  public static final int b = 30000;
  public static long b = 0L;
  public static final String b = "LAST_ADD_EMO_PACKAGE_MAGIC";
  public static final int c = 1;
  public static long c = 0L;
  public static final String c = "1";
  public static final int d = 3;
  public static final String d = "http://imgcache.qq.com/club/item/parcel/android_tab.json";
  public static final String e = "2";
  public static final String f = "http://imgcache.qq.com/club/item/parcel/android_magictab.json";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Client jdField_a_of_type_ComTencentMobileqqEmosmClient;
  private MessengerService.EmoDataInfo jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService$EmoDataInfo = new fsf(this);
  public Integer a;
  public ArrayList a;
  ArrayList b;
  public ArrayList c;
  public ArrayList d = new ArrayList();
  private int e;
  public ArrayList e;
  public ArrayList f = new ArrayList();
  ArrayList g = new ArrayList();
  public ArrayList h = new ArrayList();
  private ArrayList i = new ArrayList();
  
  private EmoticonController(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(0);
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_b_of_type_Long = -1L;
    jdField_c_of_type_Long = -1L;
  }
  
  private int a(EmoticonController.ProgressHandler paramProgressHandler)
  {
    EPCoverTask localEPCoverTask = new EPCoverTask(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localEPCoverTask.a(paramProgressHandler);
    localEPCoverTask.a();
    return localEPCoverTask.a();
  }
  
  public static EmoticonController a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    while (TextUtils.isEmpty(paramQQAppInterface.a())) {
      return null;
    }
    if (jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController == null)
    {
      jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController = new EmoticonController(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "new app.islogin=" + paramQQAppInterface.isLogin() + " app:" + String.valueOf(paramQQAppInterface));
      }
    }
    for (;;)
    {
      return jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController;
      if (jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, "old app. isLogin=" + jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin());
        }
        jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController.a();
        jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController.b();
        jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController = null;
        jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController = new EmoticonController(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, "new app.islogin=" + paramQQAppInterface.isLogin() + " app:" + String.valueOf(paramQQAppInterface));
        }
      }
    }
  }
  
  private EmoticonManager a()
  {
    return (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
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
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if ((jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController != null) && (jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface))
    {
      jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController.a();
      jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController = null;
    }
  }
  
  private void a(Emoticon paramEmoticon, EmoticonController.ProgressHandler paramProgressHandler)
  {
    if ((paramEmoticon == null) || (paramProgressHandler == null)) {}
    while ((paramEmoticon.encryptKey != null) && (paramEmoticon.encryptKey.length() > 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramEmoticon);
    a(paramEmoticon.epId, localArrayList, paramProgressHandler, false);
  }
  
  private void a(EPJsonTask paramEPJsonTask, EmoticonController.ProgressHandler paramProgressHandler, boolean paramBoolean)
  {
    new ArrayList();
    ArrayList localArrayList;
    if (paramBoolean)
    {
      localArrayList = paramEPJsonTask.b();
      paramProgressHandler.jdField_a_of_type_Int = localArrayList.size();
      if (localArrayList.size() != 0) {
        break label58;
      }
      paramProgressHandler.jdField_a_of_type_Int = paramProgressHandler.jdField_b_of_type_Int;
      a(paramProgressHandler);
    }
    label58:
    int k;
    label643:
    do
    {
      for (;;)
      {
        return;
        localArrayList = paramEPJsonTask.a();
        break;
        if (paramEPJsonTask.a())
        {
          if (!NetworkUtil.e(BaseApplication.getContext()))
          {
            a(this.jdField_c_of_type_JavaUtilArrayList, paramProgressHandler);
            if (QLog.isColorLevel()) {
              QLog.d("Q.emoji.EmoDown", 2, "EPThread| fetchEncryptKeys fail.netUnSupport epId=" + paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
            }
            if (paramProgressHandler.a()) {
              b(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, 11003);
            }
            paramProgressHandler.a("param_step", 5);
            a(paramProgressHandler, 11003);
            return;
          }
          j = 0;
          do
          {
            paramProgressHandler.jdField_b_of_type_JavaLangString = null;
            if (QLog.isColorLevel()) {
              QLog.d("Q.emoji.EmoDown", 2, "EPThread| fetchEncryptKeys count=" + j);
            }
            a(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, localArrayList, paramProgressHandler, paramBoolean);
            k = j + 1;
            if ((paramProgressHandler.jdField_a_of_type_Boolean) || (!paramProgressHandler.a())) {
              break;
            }
            j = k;
          } while (k < 3);
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "EPThread| fetchEncryptKeys count=" + k + " keysSuccess=" + paramProgressHandler.jdField_a_of_type_Boolean);
          }
        }
        while (!paramProgressHandler.jdField_a_of_type_Boolean)
        {
          a(this.jdField_c_of_type_JavaUtilArrayList, paramProgressHandler);
          j = paramProgressHandler.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "qq_error|EPThread| fetchEncryptKeys fail.resultCode=" + j + " epId=" + paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId + " encryptGetKeySeq=" + paramProgressHandler.jdField_b_of_type_JavaLangString + " encryptKeysResultCode" + paramProgressHandler.c);
          }
          if (paramProgressHandler.a()) {
            b(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, j);
          }
          paramProgressHandler.a("param_step", 5);
          a(paramProgressHandler, j);
          return;
          paramProgressHandler.jdField_a_of_type_Boolean = true;
        }
        int m = localArrayList.size();
        int j = 0;
        while (j < m)
        {
          paramEPJsonTask = new EmoticonTask((Emoticon)localArrayList.get(j), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 14);
          paramEPJsonTask.a(paramProgressHandler);
          paramEPJsonTask.a();
          k = paramEPJsonTask.a();
          if (k != 0) {
            break label643;
          }
          paramProgressHandler.jdField_b_of_type_Int += 1;
          if ((paramBoolean) && (j == m - 1))
          {
            paramEPJsonTask = (ArrayList)a().a(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
            if (paramEPJsonTask != null)
            {
              k = localArrayList.size() - 1;
              while (k >= 0)
              {
                paramEPJsonTask.add(0, localArrayList.get(k));
                k -= 1;
              }
              a().c(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
              Iterator localIterator = paramEPJsonTask.iterator();
              while (localIterator.hasNext()) {
                ((Emoticon)localIterator.next()).setStatus(1000);
              }
              a().c(paramEPJsonTask);
            }
          }
          a(paramProgressHandler);
          j += 1;
        }
      }
    } while (!paramProgressHandler.a());
    b(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, k);
    a(paramProgressHandler, k);
  }
  
  private void a(EmoticonController.ProgressHandler paramProgressHandler)
  {
    if (paramProgressHandler == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "progress:epId=" + paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId + " all:" + paramProgressHandler.jdField_a_of_type_Int + " loaded:" + paramProgressHandler.jdField_b_of_type_Int);
      }
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((EmoticonPackageDownloadListener)((Iterator)localObject1).next()).onPackageProgress(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, paramProgressHandler.jdField_a_of_type_Int, paramProgressHandler.jdField_b_of_type_Int);
      }
    } while (paramProgressHandler.jdField_a_of_type_Int != paramProgressHandler.jdField_b_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, "localVersion=" + paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.localVersion + ",latestVersion=" + paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.latestVersion + ",updateFlag=" + paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.updateFlag);
    }
    Object localObject1 = paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
    ((EmoticonPackage)localObject1).updateFlag &= 0xFFFFFFFE;
    if (paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.latestVersion > paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.localVersion) {
      paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.localVersion = paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.latestVersion;
    }
    paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.hasReadUpdatePage = false;
    paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.status = 2;
    paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.valid = true;
    a().a(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
    localObject1 = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
    Object localObject2 = (ArrayList)((EmoticonManager)localObject1).b();
    Object localObject3 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject3).next();
      if (localEmoticonPackage.epId.equals(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))
      {
        ((ArrayList)localObject2).remove(localEmoticonPackage);
        ((ArrayList)localObject2).add(0, localEmoticonPackage);
      }
    }
    ((EmoticonManager)localObject1).c();
    localObject3 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject3).add(((EmoticonPackage)((Iterator)localObject2).next()).epId);
    }
    ((EmoticonManager)localObject1).b((List)localObject3);
    if (paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.isMagicFaceDownloading)
    {
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((EmoticonController.MagicFaceDownloader)((Iterator)localObject1).next()).a(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
      }
    }
    localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((EmoticonPackageDownloadListener)((Iterator)localObject1).next()).onPackageEnd(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, 0);
    }
    a(paramProgressHandler, 0);
  }
  
  private void a(EmoticonController.ProgressHandler paramProgressHandler, int paramInt)
  {
    if ((paramProgressHandler == null) || (paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (paramInt == 11007) || (paramInt == 11003) || (paramInt == 11001) || (paramInt == 11000)) {
      return;
    }
    boolean bool = true;
    if (paramInt != 0)
    {
      bool = false;
      paramProgressHandler.a("param_FailCode", paramInt);
    }
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), a(paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage), bool, 0L, 0L, paramProgressHandler.jdField_a_of_type_JavaUtilHashMap, "");
  }
  
  private void a(EmoticonController.ProgressHandler paramProgressHandler, int paramInt, long paramLong)
  {
    if ((paramInt == 11003) || (paramInt == 11001) || (paramInt == 11000)) {
      return;
    }
    int j = (int)(System.currentTimeMillis() - paramLong);
    boolean bool;
    if (paramInt != 0)
    {
      bool = false;
      paramProgressHandler.a("param_FailCode", Integer.toString(paramInt));
    }
    for (;;)
    {
      if (paramProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 1) {}
      for (String str = "actQFaceGif";; str = "actEmoAIO")
      {
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), str, bool, j, 0L, paramProgressHandler.jdField_a_of_type_JavaUtilHashMap, "");
        return;
      }
      bool = true;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", Integer.toString(11015));
    if (paramString2 != null) {
      localHashMap.put("param_error", paramString2);
    }
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString1, false, 0L, 0L, localHashMap, "");
  }
  
  private void a(String paramString, ArrayList paramArrayList, EmoticonController.ProgressHandler paramProgressHandler, boolean paramBoolean)
  {
    int j;
    try
    {
      j = Integer.parseInt(paramString);
      if ((paramArrayList == null) || (paramArrayList.size() == 0) || (paramProgressHandler == null)) {
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
    Object localObject = new fsh(this, paramProgressHandler, localEmosmHandler, paramBoolean, paramArrayList, paramString);
    localEmosmHandler.a((EmosmHandler.EmosmHandlerListener)localObject);
    this.h.add(localObject);
    int k = this.jdField_e_of_type_Int;
    this.jdField_e_of_type_Int = (k + 1);
    localObject = Integer.toString(k);
    paramProgressHandler.jdField_b_of_type_JavaLangString = ((String)localObject);
    paramProgressHandler.c = 11022;
    localEmosmHandler.a(j, paramArrayList, (String)localObject);
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
  
  private void a(ArrayList paramArrayList, Object paramObject)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0) || (paramObject == null)) {}
    do
    {
      return;
      while (!paramArrayList.hasNext()) {
        paramArrayList = paramArrayList.iterator();
      }
    } while (paramArrayList.next() != paramObject);
    paramArrayList.remove();
  }
  
  private void b(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "Package fail:epId=" + paramEmoticonPackage.epId + " resultCode:" + paramInt);
      }
      if ((paramEmoticonPackage.status == 2) && (EmoticonUtils.a(paramEmoticonPackage.updateFlag))) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_fail", 0, 0, paramEmoticonPackage.epId, "" + paramEmoticonPackage.localVersion, "" + paramEmoticonPackage.latestVersion, "");
      }
      for (;;)
      {
        if (!paramEmoticonPackage.isMagicFaceDownloading) {
          break label195;
        }
        localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((EmoticonController.MagicFaceDownloader)localIterator.next()).b(paramEmoticonPackage);
        }
        break;
        paramEmoticonPackage.status = 0;
      }
      label195:
      a().a(paramEmoticonPackage);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((EmoticonPackageDownloadListener)localIterator.next()).onPackageEnd(paramEmoticonPackage, paramInt);
      }
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
              QLog.d("EmoticonPackage", 2, "one of encrypts is null!" + paramString);
            }
            return false;
          }
          if ((paramBoolean.jobType == 2) && ((paramBoolean.encryptKey == null) || (paramBoolean.encryptKey.length() == 0)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonPackage", 2, "encrypt isn't exist.epId=" + paramString + " eId=" + paramBoolean.eId);
            }
            return false;
          }
          if (!new File(EmosmUtils.getEmoticonPreviewPath(paramString, paramBoolean.eId)).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonPackage", 2, "emo img preview do not be exist! epId=" + paramString + " eId=" + paramBoolean.eId);
            }
            return false;
          }
          if (!new File(EmosmUtils.getEmoticonEncryptPath(paramString, paramBoolean.eId)).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonPackage", 2, "emo img encrypt file do not be exist! epId=" + paramString + " eId=" + paramBoolean.eId);
            }
            return false;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPackage", 2, "emoticons do not be exist.epId=" + paramString);
        }
        return false;
      }
    }
    paramBoolean = "small";
    if (DeviceInfoUtil.f() >= 480L) {
      paramBoolean = "big";
    }
    Object localObject = new File(EmosmUtils.getEmoticonPackageFolder(paramString) + paramBoolean + File.separator + "video.ini");
    if (!((File)localObject).exists()) {
      return false;
    }
    localObject = FileUtils.a((File)localObject);
    int k;
    int j;
    if (localObject != null)
    {
      localObject = ((String)localObject).split("&");
      k = localObject.length;
      j = 0;
      while (j < k)
      {
        String str = localObject[j];
        if (!new File(EmosmUtils.getEmoticonPackageFolder(paramString) + paramBoolean + File.separator + str).exists()) {
          return false;
        }
        j += 1;
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
      k = paramBoolean.length;
      j = 0;
      while (j < k)
      {
        localObject = paramBoolean[j];
        if (!new File(EmosmUtils.getEmoticonPackageFolder(paramString) + "audio" + File.separator + (String)localObject).exists()) {
          return false;
        }
        j += 1;
      }
    }
    return true;
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
        QLog.d("EmoticonPackage", 2, "cover_pkg_thumb isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = EmosmUtils.getCoverPath(3, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPackage", 2, "cover_pkg_color isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = EmosmUtils.getCoverPath(4, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPackage", 2, "cover_pkg_gray isn't exist." + (String)localObject);
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
            QLog.d("EmoticonPackage", 2, "one of encrypts is null!" + paramString);
          }
          return false;
        }
        if ((localEmoticon.jobType == 0) && ((localEmoticon.encryptKey == null) || (localEmoticon.encryptKey.length() == 0)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonPackage", 2, "encrypt isn't exist.epId=" + paramString + " eId=" + localEmoticon.eId);
          }
          return false;
        }
        if (!new File(EmosmUtils.getEmoticonPreviewPath(paramString, localEmoticon.eId)).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonPackage", 2, "emo img preview do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
          }
          return false;
        }
      } while (new File(EmosmUtils.getEmoticonEncryptPath(paramString, localEmoticon.eId)).exists());
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPackage", 2, "emo img encrypt file do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPackage", 2, "emoticons do not be exist.epId=" + paramString);
    }
    return true;
  }
  
  private void f()
  {
    synchronized (this.jdField_a_of_type_JavaLangInteger)
    {
      if (this.jdField_a_of_type_JavaLangInteger.intValue() < 1)
      {
        new fsj(this).start();
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, "startEPThread| start ep thread");
        }
        Integer localInteger2 = this.jdField_a_of_type_JavaLangInteger;
        this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(this.jdField_a_of_type_JavaLangInteger.intValue() + 1);
      }
      return;
    }
  }
  
  private void g(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage.isMagicFaceDownloading)
    {
      localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((EmoticonController.MagicFaceDownloader)localIterator.next()).c(paramEmoticonPackage);
      }
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((EmoticonPackageDownloadListener)localIterator.next()).onPackageStart(paramEmoticonPackage);
    }
  }
  
  private void h(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage == null) || (paramEmoticonPackage.epId == null) || (paramEmoticonPackage.jobType != 1)) {
      return;
    }
    new fsi(this, EmosmUtils.getQFaceMaterialFolderPath(paramEmoticonPackage.epId, false)).start();
  }
  
  public float a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return -1.0F;
    }
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(this.jdField_c_of_type_JavaUtilArrayList);
    ((ArrayList)localObject).addAll(this.d);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmoticonController.ProgressHandler localProgressHandler = (EmoticonController.ProgressHandler)((Iterator)localObject).next();
      if ((localProgressHandler != null) && (paramString.equals(localProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId)) && (localProgressHandler.a())) {
        return localProgressHandler.a();
      }
    }
    return -1.0F;
  }
  
  public Client a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmosmClient;
  }
  
  public MessengerService.EmoDataInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService$EmoDataInfo;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, "clear History. uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + " app=" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    this.i.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.d.clear();
    this.g.clear();
    Object localObject1 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EmoticonController.ProgressHandler)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((EmoticonController.ProgressHandler)localObject2).a();
      }
    }
    localObject1 = (EmosmHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
    if (localObject1 != null)
    {
      localObject2 = this.h.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((EmosmHandler)localObject1).b((EmosmHandler.EmosmHandlerListener)((Iterator)localObject2).next());
      }
    }
    this.h.clear();
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    if (a() != null) {
      a().d();
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {}
    Object localObject1;
    do
    {
      return;
      if (3 == paramEmoticonPackage.jobType)
      {
        localObject1 = new ArrayList();
        localObject2 = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
        Iterator localIterator = ((EmoticonManager)localObject2).b().iterator();
        while (localIterator.hasNext())
        {
          EmoticonPackage localEmoticonPackage = (EmoticonPackage)localIterator.next();
          if (!"100000".equals(localEmoticonPackage.epId)) {
            ((ArrayList)localObject1).add(localEmoticonPackage.epId);
          }
        }
        ((EmoticonManager)localObject2).c();
        ((EmoticonManager)localObject2).b((List)localObject1);
      }
      localObject1 = this.i.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((EmoticonPackageChangedListener)((Iterator)localObject1).next()).b(paramEmoticonPackage);
      }
      localObject1 = BaseApplicationImpl.a().getSharedPreferences("mobileQQi", 0);
      Object localObject2 = ((SharedPreferences)localObject1).getString("LAST_ADD_EMO_PACKAGE", "");
      localObject2 = (String)localObject2 + "|" + paramEmoticonPackage.epId;
      ((SharedPreferences)localObject1).edit().putString("LAST_ADD_EMO_PACKAGE", (String)localObject2).commit();
    } while (3 != paramEmoticonPackage.jobType);
    ((SharedPreferences)localObject1).edit().putBoolean("LAST_ADD_EMO_PACKAGE_MAGIC", true).commit();
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((EmoticonPackageDownloadListener)localIterator.next()).onJsonComplete(paramEmoticonPackage, paramInt);
        }
      }
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext()) {
        ((EmoticonPackageChangedListener)localIterator.next()).a(paramEmoticonPackage, paramInt1, paramInt2);
      }
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if (paramInt2 != 0) {}
      for (;;)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((EmoticonPackageDownloadListener)localIterator.next()).onCoverComplete(paramEmoticonPackage, paramInt1, paramInt3);
        }
        paramInt3 = 0;
      }
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, boolean paramBoolean)
  {
    if ((paramEmoticonPackage == null) || (paramEmoticonPackage.epId == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, "try to pullEmoticonPackage ep:" + paramEmoticonPackage.epId);
    }
    if (!EmosmUtils.isNumeral(paramEmoticonPackage.epId))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "ep.epId=" + paramEmoticonPackage.epId + " isNumeral false.");
      }
      ??? = new HashMap();
      ((HashMap)???).put("param_FailCode", Integer.toString(11024));
      ((HashMap)???).put("param_epId", paramEmoticonPackage.epId);
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), a(paramEmoticonPackage), false, 0L, 0L, (HashMap)???, "");
      return;
    }
    synchronized (this.d)
    {
      if (a(paramEmoticonPackage.epId) >= 0.0F)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, "pullEmoticonPackage| queue already exist");
        }
        return;
      }
    }
    if (!paramEmoticonPackage.isMagicFaceDownloading) {
      if ((paramEmoticonPackage.status != 2) || (!EmoticonUtils.a(paramEmoticonPackage.updateFlag))) {
        break label329;
      }
    }
    for (;;)
    {
      paramEmoticonPackage.valid = true;
      a().a(paramEmoticonPackage);
      a().a(paramEmoticonPackage.epId);
      EmoticonController.ProgressHandler localProgressHandler = new EmoticonController.ProgressHandler(this, paramEmoticonPackage);
      this.d.add(localProgressHandler);
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "pullEmoticonPackage| add queue suc epId:" + paramEmoticonPackage.epId);
      }
      if (paramBoolean) {
        a(paramEmoticonPackage);
      }
      f();
      return;
      label329:
      paramEmoticonPackage.status = 0;
    }
  }
  
  public void a(EmoticonController.MagicFaceDownloader paramMagicFaceDownloader)
  {
    if ((paramMagicFaceDownloader == null) || (this.jdField_b_of_type_JavaUtilArrayList.contains(paramMagicFaceDownloader))) {}
    while (this.jdField_b_of_type_JavaUtilArrayList.contains(paramMagicFaceDownloader)) {
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList.add(paramMagicFaceDownloader);
  }
  
  public void a(EmoticonPackageChangedListener paramEmoticonPackageChangedListener)
  {
    if (paramEmoticonPackageChangedListener == null) {
      return;
    }
    synchronized (this.i)
    {
      this.i.add(paramEmoticonPackageChangedListener);
      return;
    }
  }
  
  public void a(EmoticonPackageDownloadListener paramEmoticonPackageDownloadListener)
  {
    if (paramEmoticonPackageDownloadListener == null) {}
    while (this.jdField_a_of_type_JavaUtilArrayList.contains(paramEmoticonPackageDownloadListener)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramEmoticonPackageDownloadListener);
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    ArrayList localArrayList;
    do
    {
      EmoticonController.ProgressHandler localProgressHandler;
      do
      {
        return;
        localArrayList = new ArrayList();
        localArrayList.addAll(this.jdField_c_of_type_JavaUtilArrayList);
        localIterator = localArrayList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localProgressHandler = (EmoticonController.ProgressHandler)localIterator.next();
        } while ((localProgressHandler == null) || (!localProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(paramString)) || (!localProgressHandler.a()));
        localProgressHandler.a();
        b(localProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, 11007);
      } while (!QLog.isColorLevel());
      QLog.d("Q.emoji.EmoDown", 2, "stopEmoticonPackage download ep:" + paramString);
      return;
      localArrayList.clear();
      localArrayList.addAll(this.d);
      Iterator localIterator = localArrayList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localProgressHandler = (EmoticonController.ProgressHandler)localIterator.next();
      } while ((localProgressHandler == null) || (!localProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(paramString)) || (!localProgressHandler.a()));
      localProgressHandler.a();
      b(localProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, 11007);
    } while (!QLog.isColorLevel());
    QLog.d("Q.emoji.EmoDown", 2, "stopEmoticonPackage download ep:" + paramString);
    return;
    localArrayList.clear();
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    synchronized (this.jdField_e_of_type_JavaUtilArrayList)
    {
      if (c(paramString) == true)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmosmDetailActivity", 2, "startDownloadEmosmJson|epId is in downloading:" + paramString);
        }
        return;
      }
      EmoticonPackage localEmoticonPackage2 = a().a(paramString);
      EmoticonPackage localEmoticonPackage1 = localEmoticonPackage2;
      if (localEmoticonPackage2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmosmDetailActivity", 2, "startDownloadEmosmJson|emoPackage is not exist:" + paramString);
        }
        localEmoticonPackage1 = new EmoticonPackage();
        localEmoticonPackage1.epId = paramString;
        localEmoticonPackage1.status = 0;
        a().a(localEmoticonPackage1);
      }
      paramString = new EmoticonController.ProgressHandler(this, localEmoticonPackage1);
      this.jdField_e_of_type_JavaUtilArrayList.add(paramString);
      a().a(localEmoticonPackage1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmosmDetailActivity", 2, "startDownloadEmosmJson| add queue suc epId:" + localEmoticonPackage1.epId);
      }
      paramString = new fsg(this, paramInt);
      if (paramBoolean)
      {
        new Thread(paramString).start();
        return;
      }
    }
    paramString.run();
  }
  
  public boolean a()
  {
    Log.d("getMagicFaceSendAccessControl", "MAGICFACEFIRSTSENDTIME=" + jdField_b_of_type_Long + "----MAGICFACESECONDSENDTIME=" + jdField_c_of_type_Long);
    if (-1L == jdField_b_of_type_Long)
    {
      jdField_b_of_type_Long = System.currentTimeMillis();
      return true;
    }
    if (-1L == jdField_c_of_type_Long)
    {
      jdField_c_of_type_Long = System.currentTimeMillis();
      return true;
    }
    long l = System.currentTimeMillis();
    if (l - jdField_b_of_type_Long > 30000L)
    {
      jdField_b_of_type_Long = jdField_c_of_type_Long;
      jdField_c_of_type_Long = l;
      return true;
    }
    return false;
  }
  
  public boolean a(Emoticon paramEmoticon, int paramInt)
  {
    if ((paramEmoticon == null) || (paramEmoticon.epId == null) || (paramEmoticon.eId == null)) {
      return false;
    }
    if (this.g != null)
    {
      Object localObject = new ArrayList();
      ((ArrayList)localObject).addAll(this.g);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          EmoticonTask localEmoticonTask = (EmoticonTask)((Iterator)localObject).next();
          if (localEmoticonTask != null)
          {
            Emoticon localEmoticon = localEmoticonTask.a();
            if ((localEmoticon != null) && (localEmoticon.epId.equals(paramEmoticon.epId)) && (localEmoticon.eId.equals(paramEmoticon.eId)) && ((localEmoticonTask.b() & paramInt) == paramInt)) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
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
  
  public void b()
  {
    if (a() != null) {
      a().e();
    }
  }
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext()) {
        ((EmoticonPackageChangedListener)localIterator.next()).a(paramEmoticonPackage);
      }
    }
  }
  
  public void b(EmoticonController.MagicFaceDownloader paramMagicFaceDownloader)
  {
    if (paramMagicFaceDownloader == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramMagicFaceDownloader);
  }
  
  public void b(EmoticonPackageChangedListener paramEmoticonPackageChangedListener)
  {
    if (paramEmoticonPackageChangedListener == null) {
      return;
    }
    synchronized (this.i)
    {
      this.i.remove(paramEmoticonPackageChangedListener);
      return;
    }
  }
  
  public void b(EmoticonPackageDownloadListener paramEmoticonPackageDownloadListener)
  {
    if (paramEmoticonPackageDownloadListener == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramEmoticonPackageDownloadListener);
  }
  
  public void b(String paramString)
  {
    a(paramString, EPJsonTask.jdField_a_of_type_Int, true);
  }
  
  public boolean b(Emoticon paramEmoticon, int paramInt)
  {
    boolean bool = false;
    EmoticonController.ProgressHandler localProgressHandler = new EmoticonController.ProgressHandler(this, paramEmoticon);
    EmoticonTask localEmoticonTask = new EmoticonTask(paramEmoticon, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt);
    localEmoticonTask.a(localProgressHandler);
    this.g.add(localEmoticonTask);
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, "downloadAIOEmoticon|taskvalue:" + paramInt + "epid:" + paramEmoticon.epId + " eid=" + paramEmoticon.eId);
    }
    if (Utils.e()) {
      if (Utils.b() < 1048576L)
      {
        this.g.remove(localEmoticonTask);
        localProgressHandler.a("param_step", 0);
        a(localProgressHandler, 11001, l);
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, "qq_error|sdcardcheck,sdcard full .return. epId=" + paramEmoticon.epId);
        }
      }
    }
    for (;;)
    {
      if ((localEmoticonTask.b() & 0x4) == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, "Emoticon need EncryptKey,fetching key pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + localEmoticonTask.b() + " time:" + System.currentTimeMillis());
        }
        a(paramEmoticon, localProgressHandler);
        if ((paramEmoticon.encryptKey == null) || (paramEmoticon.encryptKey.length() == 0))
        {
          this.g.remove(localEmoticonTask);
          paramInt = localProgressHandler.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "qq_error|Emotiocon need EncryptKey, fetched fail. resultCode=" + paramInt + "pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + localEmoticonTask.b() + " time:" + System.currentTimeMillis());
          }
          localProgressHandler.a("param_step", 5);
          a(localProgressHandler, paramInt, l);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "Emotiocon now start do task.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + localEmoticonTask.b() + " time:" + System.currentTimeMillis());
      }
      localEmoticonTask.a();
      paramInt = localEmoticonTask.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "downloadAIOEmoticon| Emotiocon task DONE. resultCode=" + paramInt + " pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + localEmoticonTask.b() + " time:" + System.currentTimeMillis());
      }
      this.g.remove(localEmoticonTask);
      a(localProgressHandler, paramInt, l);
      if (paramInt == 0) {
        bool = true;
      }
      return bool;
      this.g.remove(localEmoticonTask);
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "qq_error|sdcardcheck,has sdcard FALSE .return. epId=" + paramEmoticon.epId);
      }
      localProgressHandler.a("param_step", 0);
      a(localProgressHandler, 11000, l);
    }
  }
  
  public boolean b(String paramString)
  {
    return new File(EmosmUtils.getEmoticonPackageFolder(paramString) + "audio" + File.separator + "audio.ini").exists();
  }
  
  public void c()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
  }
  
  public void c(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((EmoticonController.MagicFaceDownloader)localIterator.next()).a(paramEmoticonPackage);
      }
    }
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
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(this.jdField_e_of_type_JavaUtilArrayList);
    ((ArrayList)localObject).addAll(this.f);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EmoticonController.ProgressHandler localProgressHandler = (EmoticonController.ProgressHandler)((Iterator)localObject).next();
      if ((localProgressHandler != null) && (paramString.equals(localProgressHandler.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId)) && (localProgressHandler.a())) {
        return true;
      }
    }
    return false;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, "===getRecommendEmoticonPackage=====");
    }
    new EPRecommendTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).execute(new String[] { "http://imgcache.qq.com/club/item/parcel/android_tab.json", "1" });
  }
  
  public void d(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage == null) || (paramEmoticonPackage.epId == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, "try to pullQFaceMaterial ep:" + paramEmoticonPackage.epId);
    }
    if (!EmosmUtils.isNumeral(paramEmoticonPackage.epId))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "ep.epId=" + paramEmoticonPackage.epId + " isNumeral false.");
      }
      ??? = new HashMap();
      ((HashMap)???).put("param_FailCode", Integer.toString(11024));
      ((HashMap)???).put("param_epId", paramEmoticonPackage.epId);
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), a(paramEmoticonPackage), false, 0L, 0L, (HashMap)???, "");
      return;
    }
    synchronized (this.d)
    {
      if (a(paramEmoticonPackage.epId) >= 0.0F)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, "pullQFaceMaterial| queue already exist");
        }
        return;
      }
    }
    paramEmoticonPackage.status = 0;
    a().a(paramEmoticonPackage);
    EmoticonController.ProgressHandler localProgressHandler = new EmoticonController.ProgressHandler(this, paramEmoticonPackage);
    this.d.add(localProgressHandler);
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, "pullQFaceMaterial| add queue suc epId:" + paramEmoticonPackage.epId);
    }
    f();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, "===getRecommendMagicEmoticonPackage=====");
    }
    new EPRecommendTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).execute(new String[] { "http://imgcache.qq.com/club/item/parcel/android_magictab.json", "2" });
  }
  
  public void e(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    a(paramEmoticonPackage.epId);
  }
  
  public void f(EmoticonPackage paramEmoticonPackage)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((EmoticonPackageChangedListener)localIterator.next()).b(paramEmoticonPackage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmoticonController
 * JD-Core Version:    0.7.0.1
 */