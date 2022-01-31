package com.tencent.mobileqq.filemanager.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;
import com.dataline.util.file.MediaStoreUtil;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FMConfig.eOfflineFuntion;
import com.tencent.mobileqq.filemanager.data.FMConfig.eOnlinePreViewSubkey;
import com.tencent.mobileqq.filemanager.data.FMConfig.eOpenForQQAppSubKey;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qlink.QlinkHelper;
import cooperation.qlink.QlinkPluginProxyActivity;
import gct;
import gcu;
import gcv;
import gcw;
import java.io.File;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.MobileQQ;
import org.apache.http.util.ByteArrayBuffer;

public class FileManagerUtil
{
  private static final int jdField_a_of_type_Int = 16;
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  static QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  public static final String a = "sdCard";
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  private static HashMap jdField_a_of_type_JavaUtilHashMap = null;
  public static final String b = "externalSdCard";
  private static ArrayList jdField_b_of_type_JavaUtilArrayList;
  private static HashMap jdField_b_of_type_JavaUtilHashMap = null;
  public static final String c = "ExternalFileOfFM";
  private static final String d = "FileManagerUtil";
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = null;
    jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil", 2, "unknow peer type[" + String.valueOf(paramInt) + "]!");
      }
      return -1;
    case 0: 
      return 0;
    case 1: 
      return 1;
    }
    return 3000;
  }
  
  public static int a(long paramLong)
  {
    return (short)((int)(0xFFFFFFFF & paramLong) & 0xFFFF);
  }
  
  public static int a(String paramString)
  {
    String str1 = FileUtil.a(paramString);
    if ((str1 == null) || (str1.length() == 0)) {
      return -1;
    }
    if (jdField_b_of_type_JavaUtilHashMap == null) {
      jdField_b_of_type_JavaUtilHashMap = new HashMap();
    }
    try
    {
      Object localObject = Class.forName("android.media.MediaFile").getDeclaredField("sFileTypeMap");
      ((Field)localObject).setAccessible(true);
      localObject = ((HashMap)((Field)localObject).get(null)).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        str2 = "." + str2;
        jdField_b_of_type_JavaUtilHashMap.put(str2.toLowerCase(), Integer.valueOf(1));
      }
      return 11;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
      jdField_b_of_type_JavaUtilHashMap.remove(".flv");
      jdField_b_of_type_JavaUtilHashMap.put(".bmp", Integer.valueOf(0));
      jdField_b_of_type_JavaUtilHashMap.put(".jpg", Integer.valueOf(0));
      jdField_b_of_type_JavaUtilHashMap.put(".jpeg", Integer.valueOf(0));
      jdField_b_of_type_JavaUtilHashMap.put(".png", Integer.valueOf(0));
      jdField_b_of_type_JavaUtilHashMap.put(".gif", Integer.valueOf(0));
      jdField_b_of_type_JavaUtilHashMap.put(".ico", Integer.valueOf(0));
      jdField_b_of_type_JavaUtilHashMap.put(".wmv", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".avi", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".rm", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".rmvb", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".asf", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".mov", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".mpg", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".3gp", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".m4u", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".mpeg", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".m4v", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".mp4", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".vob", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".mkv", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".mpe", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".doc", Integer.valueOf(3));
      jdField_b_of_type_JavaUtilHashMap.put(".docx", Integer.valueOf(3));
      jdField_b_of_type_JavaUtilHashMap.put(".zip", Integer.valueOf(4));
      jdField_b_of_type_JavaUtilHashMap.put(".rar", Integer.valueOf(4));
      jdField_b_of_type_JavaUtilHashMap.put(".7z", Integer.valueOf(4));
      jdField_b_of_type_JavaUtilHashMap.put(".tar", Integer.valueOf(4));
      jdField_b_of_type_JavaUtilHashMap.put(".apk", Integer.valueOf(5));
      jdField_b_of_type_JavaUtilHashMap.put(".xls", Integer.valueOf(6));
      jdField_b_of_type_JavaUtilHashMap.put(".xlsx", Integer.valueOf(6));
      jdField_b_of_type_JavaUtilHashMap.put(".csv", Integer.valueOf(6));
      jdField_b_of_type_JavaUtilHashMap.put(".ppt", Integer.valueOf(7));
      jdField_b_of_type_JavaUtilHashMap.put(".pptx", Integer.valueOf(7));
      jdField_b_of_type_JavaUtilHashMap.put(".pps", Integer.valueOf(7));
      jdField_b_of_type_JavaUtilHashMap.put(".htm", Integer.valueOf(8));
      jdField_b_of_type_JavaUtilHashMap.put(".html", Integer.valueOf(8));
      jdField_b_of_type_JavaUtilHashMap.put(".php", Integer.valueOf(8));
      jdField_b_of_type_JavaUtilHashMap.put(".pdf", Integer.valueOf(9));
      jdField_b_of_type_JavaUtilHashMap.put(".txt", Integer.valueOf(10));
      jdField_b_of_type_JavaUtilHashMap.put(".rtf", Integer.valueOf(10));
      jdField_b_of_type_JavaUtilHashMap.put(".c", Integer.valueOf(10));
      jdField_b_of_type_JavaUtilHashMap.put(".conf", Integer.valueOf(10));
      jdField_b_of_type_JavaUtilHashMap.put(".cpp", Integer.valueOf(10));
      jdField_b_of_type_JavaUtilHashMap.put(".h", Integer.valueOf(10));
      jdField_b_of_type_JavaUtilHashMap.put(".java", Integer.valueOf(10));
      jdField_b_of_type_JavaUtilHashMap.put(".log", Integer.valueOf(10));
      jdField_b_of_type_JavaUtilHashMap.put(".prop", Integer.valueOf(10));
      jdField_b_of_type_JavaUtilHashMap.put(".rc", Integer.valueOf(10));
      jdField_b_of_type_JavaUtilHashMap.put(".sh", Integer.valueOf(10));
      jdField_b_of_type_JavaUtilHashMap.put(".csv", Integer.valueOf(10));
      jdField_b_of_type_JavaUtilHashMap.put(".xml", Integer.valueOf(10));
      if (jdField_b_of_type_JavaUtilHashMap.containsKey(str1.toLowerCase())) {
        return ((Integer)jdField_b_of_type_JavaUtilHashMap.get(str1.toLowerCase())).intValue();
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        localClassNotFoundException.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        jdField_b_of_type_JavaUtilHashMap.put(".mp2", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".mp3", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".wav", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".ogg", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".mid", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".midi", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".m3u", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".m4a", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".m4b", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".m4p", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".mpga", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".wma", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".amr", Integer.valueOf(1));
      }
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerUtil", 2, "Unknow file Type[" + paramString + "]");
      }
    }
  }
  
  public static long a()
  {
    int i = MobileQQService.c;
    MobileQQService.c = i + 1;
    return (short)(int)((int)(i & 0xFFFFFFFF) & 0xFFFF);
  }
  
  public static long a(int paramInt)
  {
    switch (paramInt)
    {
    case 1002: 
    case 1003: 
    case 1005: 
    default: 
      return -1L;
    case 1004: 
      return 105L;
    case 1000: 
      return 104L;
    case 1001: 
      return 100L;
    }
    return 102L;
  }
  
  public static long a(String paramString)
  {
    long l = 0L;
    try
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        l = paramString.length();
      }
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public static SpannableString a(String paramString1, String paramString2, FileManagerUtil.TipsClickedInterface paramTipsClickedInterface)
  {
    int i = paramString1.indexOf(paramString2);
    if (i > 0) {}
    for (;;)
    {
      int j = paramString2.length() + i;
      paramString1 = new SpannableString(paramString1);
      paramString2 = new gcw(paramTipsClickedInterface);
      paramString1.setSpan(new ForegroundColorSpan(2131361799), i, j, 33);
      paramString1.setSpan(paramString2, i, j, 33);
      paramString1.setSpan(paramString2, i, j, 33);
      return paramString1;
      i = 0;
    }
  }
  
  public static FileManagerEntity a(FileInfo paramFileInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.cloudType = 3;
    localFileManagerEntity.fileName = paramFileInfo.d();
    localFileManagerEntity.strFilePath = paramFileInfo.c();
    localFileManagerEntity.fileSize = paramFileInfo.a();
    if (paramFileInfo.b() == 5) {}
    for (localFileManagerEntity.nFileType = 5;; localFileManagerEntity.nFileType = a(paramFileInfo.d()))
    {
      localFileManagerEntity.status = -1;
      ((QQAppInterface)BaseApplicationImpl.a().a()).a().d(localFileManagerEntity);
      return localFileManagerEntity;
    }
  }
  
  public static FileManagerEntity a(OfflineFileInfo paramOfflineFileInfo, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a().a();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.Uuid = paramOfflineFileInfo.jdField_a_of_type_JavaLangString;
    localFileManagerEntity.cloudType = 1;
    localFileManagerEntity.strThumbPath = paramOfflineFileInfo.jdField_c_of_type_JavaLangString;
    localFileManagerEntity.peerUin = String.valueOf(paramOfflineFileInfo.jdField_a_of_type_Long);
    localFileManagerEntity.peerNick = a(localQQAppInterface, localFileManagerEntity.peerUin, null, paramInt);
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.fileName = paramOfflineFileInfo.jdField_b_of_type_JavaLangString;
    localFileManagerEntity.fileSize = paramOfflineFileInfo.jdField_b_of_type_Long;
    localFileManagerEntity.nFileType = a(paramOfflineFileInfo.jdField_b_of_type_JavaLangString);
    localFileManagerEntity.lastTime = paramOfflineFileInfo.jdField_c_of_type_Long;
    localFileManagerEntity.status = -1;
    localFileManagerEntity.srvTime = paramOfflineFileInfo.d;
    localFileManagerEntity.bSend = paramOfflineFileInfo.jdField_a_of_type_Boolean;
    if ((localFileManagerEntity.Uuid == null) || (localFileManagerEntity.Uuid.length() == 0)) {
      localFileManagerEntity.nWeiYunSrcType = -1;
    }
    localQQAppInterface.a().d(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public static FileManagerEntity a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.WeiYunFileId = paramWeiYunFileInfo.jdField_a_of_type_JavaLangString;
    localFileManagerEntity.fileName = paramWeiYunFileInfo.jdField_b_of_type_JavaLangString;
    localFileManagerEntity.fileSize = paramWeiYunFileInfo.jdField_a_of_type_Long;
    localFileManagerEntity.nFileType = a(paramWeiYunFileInfo.jdField_b_of_type_JavaLangString);
    localFileManagerEntity.strThumbPath = paramWeiYunFileInfo.g;
    localFileManagerEntity.cloudType = 2;
    localFileManagerEntity.nWeiYunSrcType = paramWeiYunFileInfo.c;
    localFileManagerEntity.lastTime = paramWeiYunFileInfo.jdField_b_of_type_Long;
    localFileManagerEntity.status = -1;
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.strFileMd5 = paramWeiYunFileInfo.h;
    ((QQAppInterface)BaseApplicationImpl.a().a()).a().d(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public static FileManagerEntity a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.cloudType = 4;
    localFileManagerEntity.fileName = paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString;
    if (FileUtil.a(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) {
      localFileManagerEntity.strFilePath = paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString;
    }
    localFileManagerEntity.fileSize = paramTroopFileStatusInfo.jdField_b_of_type_Long;
    localFileManagerEntity.nFileType = a(paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString);
    localFileManagerEntity.status = -1;
    if (paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null) {
      localFileManagerEntity.strTroopFileID = paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString();
    }
    localFileManagerEntity.strTroopFilePath = paramTroopFileStatusInfo.d;
    localFileManagerEntity.busId = paramTroopFileStatusInfo.jdField_e_of_type_Int;
    localFileManagerEntity.TroopUin = paramTroopFileStatusInfo.jdField_a_of_type_Long;
    ((QQAppInterface)BaseApplicationImpl.a().a()).a().d(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public static Long a()
  {
    return Long.valueOf((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  }
  
  public static String a()
  {
    String str = "";
    try
    {
      StackTraceElement[] arrayOfStackTraceElement = (StackTraceElement[])Thread.getAllStackTraces().get(Thread.currentThread());
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
        QLog.e("FMERROR", 1, localStackTraceElement.toString());
        str = str + localStackTraceElement.toString() + "&";
        i += 1;
      }
      return str;
    }
    finally {}
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return BaseApplicationImpl.getContext().getString(2131559254);
    case 1: 
      return BaseApplicationImpl.getContext().getString(2131559250);
    case 0: 
      return BaseApplicationImpl.getContext().getString(2131559251);
    case 2: 
      return BaseApplicationImpl.getContext().getString(2131559252);
    }
    return BaseApplicationImpl.getContext().getString(2131559253);
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return String.valueOf(0);
    case 3: 
      return String.valueOf(1);
    case 1: 
      if (paramInt2 == 0) {
        return String.valueOf(2);
      }
      return String.valueOf(4);
    case 0: 
      return String.valueOf(7);
    }
    return String.valueOf(3);
  }
  
  public static String a(long paramLong)
  {
    if (paramLong == 0L) {
      return "0";
    }
    if (paramLong <= 512000L) {
      return "0-500k";
    }
    if (paramLong <= 1048576L) {
      return "500k-1m";
    }
    if (paramLong <= 3145728L) {
      return "1m-3m";
    }
    if (paramLong <= 5242880L) {
      return "3m-5m";
    }
    if (paramLong <= 10485760L) {
      return "5m-10m";
    }
    return ">10m";
  }
  
  public static String a(long paramLong, int paramInt, boolean paramBoolean)
  {
    long l = 0L;
    int i;
    int j;
    label128:
    label163:
    String str2;
    switch (paramInt)
    {
    default: 
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(l + paramLong);
      paramInt = localCalendar.get(1);
      i = localCalendar.get(2) + 1;
      j = localCalendar.get(5);
      str1 = paramInt + "-";
      if (i < 10)
      {
        str1 = str1 + "0" + i;
        if (j >= 10) {
          break label346;
        }
        str1 = str1 + "-0" + j;
        str2 = str1;
        if (paramBoolean)
        {
          paramInt = localCalendar.get(11);
          i = localCalendar.get(12);
          str1 = str1 + " ";
          if (paramInt >= 10) {
            break label377;
          }
        }
      }
      break;
    }
    label346:
    label377:
    for (String str1 = str1 + "0" + paramInt;; str1 = str1 + paramInt)
    {
      str1 = str1 + ":";
      if (i >= 10) {
        break label401;
      }
      str2 = str1 + "0" + i;
      return str2;
      l = 604800000L;
      break;
      l = 2592000000L;
      break;
      str1 = str1 + i;
      break label128;
      str1 = str1 + "-" + j;
      break label163;
    }
    label401:
    return str1 + i;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    paramQQAppInterface = paramQQAppInterface.a().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop);
    if (paramQQAppInterface == null) {
      return null;
    }
    if (paramQQAppInterface.nFileType == -1) {
      paramQQAppInterface.nFileType = a(paramQQAppInterface.strFilePath);
    }
    paramMessage = a(paramQQAppInterface.nFileType);
    return "[" + paramMessage + "]" + d(paramQQAppInterface.fileName);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    FriendManager localFriendManager = (FriendManager)paramQQAppInterface.getManager(8);
    switch (paramInt)
    {
    default: 
      return localFriendManager.c(String.valueOf(paramString1));
    case 3000: 
      if (paramString2 == null) {
        return BaseApplicationImpl.getContext().getString(2131559255);
      }
      return localFriendManager.d(paramString1, paramString2);
    }
    paramQQAppInterface = (PhoneContactManager)paramQQAppInterface.getManager(10);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.e(paramString1.replace("+86", ""));
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.name;
      }
    }
    return localFriendManager.c(String.valueOf(paramString1));
  }
  
  public static String a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      paramFileManagerEntity = "";
    }
    for (;;)
    {
      return paramFileManagerEntity;
      try
      {
        paramFileManagerEntity = "FileManagerEntity info, ], nSessionId[" + paramFileManagerEntity.nSessionId + "], fileName[" + paramFileManagerEntity.fileName + "], cloudType[" + paramFileManagerEntity.cloudType + "], uniseq[" + String.valueOf(paramFileManagerEntity.uniseq) + "], nRelatedSessionId[" + paramFileManagerEntity.nRelatedSessionId + "], bDelInAio[" + paramFileManagerEntity.bDelInAio + "], bDelInFM[" + paramFileManagerEntity.bDelInFM + "], fileSize[" + paramFileManagerEntity.fileSize + "], fProgress[" + paramFileManagerEntity.fProgress + "], lastTime[" + paramFileManagerEntity.lastTime + "], msgSeq[" + String.valueOf(paramFileManagerEntity.msgSeq) + "], msgUid[" + String.valueOf(paramFileManagerEntity.msgUid) + "], msgTime[" + String.valueOf(paramFileManagerEntity.msgTime) + "], nFileType[" + paramFileManagerEntity.nFileType + "], nOpType[" + paramFileManagerEntity.nOpType + "], nWeiYunSrcType[" + paramFileManagerEntity.nWeiYunSrcType + "], peerNick[" + paramFileManagerEntity.peerNick + "], peerType[" + paramFileManagerEntity.peerType + "], peerUin[" + e(paramFileManagerEntity.peerUin) + "], selfUin[" + e(paramFileManagerEntity.selfUin) + "], srvTime[" + paramFileManagerEntity.srvTime + "], status[" + paramFileManagerEntity.status + "], strFilePath[" + paramFileManagerEntity.strFilePath + "], strServerPath[" + paramFileManagerEntity.strServerPath + "], strThumbPath[" + paramFileManagerEntity.strThumbPath + "], Uuid[" + paramFileManagerEntity.Uuid + "], WeiYunFileId[" + paramFileManagerEntity.WeiYunFileId + "], nOLfileSessionId[" + paramFileManagerEntity.nOLfileSessionId + "], strFileMd5[" + paramFileManagerEntity.strFileMd5 + "], strFileSHA[" + paramFileManagerEntity.strFileSHA + "], nOLfileSessionId[" + paramFileManagerEntity.nOLfileSessionId + "], _status[" + paramFileManagerEntity.getStatus() + "]";
      }
      finally {}
    }
  }
  
  public static String a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FMERROR", 1, "getFileName but strFilePath is null");
      }
      a();
      localObject = "";
      return localObject;
    }
    int k = paramString.length();
    int i = paramString.lastIndexOf('/');
    int j = paramString.lastIndexOf('\\');
    if (j > i) {
      i = j;
    }
    for (;;)
    {
      if (i < 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerUtil", 2, "filepath without / ?");
        }
        i = 0;
      }
      String str2;
      String str1;
      for (;;)
      {
        str2 = paramString.substring(i, k);
        if ((QLog.isColorLevel()) && (str2.startsWith("."))) {
          QLog.e("FileManagerUtil", 2, "InvaildName ,filePath[" + paramString + "], subName[" + str2 + "]");
        }
        for (str1 = str2; str1.startsWith("."); str1 = str1.replaceFirst(".", "")) {}
        i += 1;
      }
      localObject = str1;
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      localObject = "InvaildName";
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("FileManagerUtil", 2, "InvaildName ,filePath[" + paramString + "], subName[" + str2 + "]");
      return "InvaildName";
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      return null;
    }
    if (paramString2 == null) {}
    for (int i = 0;; i = -1)
    {
      if (paramString3 == null) {}
      for (int j = paramString1.length();; j = -1)
      {
        int k = i;
        if (i == -1) {
          k = paramString1.indexOf(paramString2) + paramString2.length();
        }
        i = j;
        if (j == -1) {
          i = paramString1.indexOf(paramString3, k);
        }
        try
        {
          String str = paramString1.substring(k, i);
          return str;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerUtil", 2, "srcString[" + String.valueOf(paramString1) + "],beginString[" + String.valueOf(paramString2) + "],endString[" + String.valueOf(paramString3) + "],benginPos[" + String.valueOf(k) + "],endPos[" + String.valueOf(i) + "]");
        return null;
      }
    }
  }
  
  public static URL a(String paramString, int paramInt1, int paramInt2, File paramFile)
  {
    long l = paramFile.lastModified();
    paramString = paramString + "|" + paramInt1 + "|" + paramInt2 + "|" + l + "|1";
    try
    {
      paramString = new URL("fileassistantimage", "", paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramString.getMessage(), paramString);
      }
    }
    return null;
  }
  
  public static ArrayList a(boolean paramBoolean, int paramInt)
  {
    int i = 0;
    Object localObject1 = new File(b()).listFiles();
    if (localObject1 == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    Object localObject3;
    if (i < localObject1.length)
    {
      localObject2 = localObject1[i];
      localObject3 = ((File)localObject2).getPath();
      if ((!paramBoolean) && (((File)localObject2).getName().startsWith("."))) {}
      for (;;)
      {
        i += 1;
        break;
        FileInfo localFileInfo = new FileInfo();
        localFileInfo.c(((File)localObject2).getName());
        localFileInfo.a(((File)localObject2).isDirectory());
        localFileInfo.d((String)localObject3);
        localFileInfo.a(((File)localObject2).length());
        localFileInfo.b(((File)localObject2).lastModified());
        localArrayList.add(localFileInfo);
      }
    }
    try
    {
      localObject1 = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).getAll();
      if ((localObject1 != null) && (((Map)localObject1).size() > 0))
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Map.Entry)((Iterator)localObject1).next()).getKey();
          if (FileUtil.a((String)localObject2))
          {
            localObject2 = new File((String)localObject2);
            localObject3 = new FileInfo();
            ((FileInfo)localObject3).c(((File)localObject2).getName());
            ((FileInfo)localObject3).a(((File)localObject2).isDirectory());
            ((FileInfo)localObject3).d(((File)localObject2).getPath());
            ((FileInfo)localObject3).a(((File)localObject2).length());
            ((FileInfo)localObject3).b(((File)localObject2).lastModified());
            localArrayList.add(localObject3);
          }
        }
      }
      if (paramInt != 0) {
        break label329;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    Collections.sort(localArrayList, new FileUtil.MyFileCompare());
    for (;;)
    {
      return localArrayList;
      label329:
      Collections.sort(localArrayList, new FileCompare());
    }
  }
  
  /* Error */
  public static Map a()
  {
    // Byte code:
    //   0: new 96	java/util/HashMap
    //   3: dup
    //   4: bipush 10
    //   6: invokespecial 951	java/util/HashMap:<init>	(I)V
    //   9: astore 4
    //   11: new 33	java/util/ArrayList
    //   14: dup
    //   15: bipush 10
    //   17: invokespecial 952	java/util/ArrayList:<init>	(I)V
    //   20: astore 5
    //   22: new 33	java/util/ArrayList
    //   25: dup
    //   26: bipush 10
    //   28: invokespecial 952	java/util/ArrayList:<init>	(I)V
    //   31: astore 6
    //   33: aload 5
    //   35: getstatic 957	com/tencent/mobileqq/app/AppConstants:al	Ljava/lang/String;
    //   38: invokeinterface 960 2 0
    //   43: pop
    //   44: aload 6
    //   46: getstatic 957	com/tencent/mobileqq/app/AppConstants:al	Ljava/lang/String;
    //   49: invokeinterface 960 2 0
    //   54: pop
    //   55: new 323	java/io/File
    //   58: dup
    //   59: ldc_w 962
    //   62: invokespecial 326	java/io/File:<init>	(Ljava/lang/String;)V
    //   65: astore_2
    //   66: aload_2
    //   67: invokevirtual 329	java/io/File:exists	()Z
    //   70: ifeq +71 -> 141
    //   73: new 964	java/util/Scanner
    //   76: dup
    //   77: aload_2
    //   78: invokespecial 967	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   81: astore_2
    //   82: aload_2
    //   83: invokevirtual 968	java/util/Scanner:hasNext	()Z
    //   86: ifeq +55 -> 141
    //   89: aload_2
    //   90: invokevirtual 971	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   93: astore_3
    //   94: aload_3
    //   95: ldc_w 973
    //   98: invokevirtual 828	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   101: ifeq -19 -> 82
    //   104: aload_3
    //   105: ldc_w 634
    //   108: invokevirtual 977	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   111: iconst_1
    //   112: aaload
    //   113: astore_3
    //   114: aload_3
    //   115: getstatic 957	com/tencent/mobileqq/app/AppConstants:al	Ljava/lang/String;
    //   118: invokevirtual 980	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   121: ifne -39 -> 82
    //   124: aload 5
    //   126: aload_3
    //   127: invokeinterface 960 2 0
    //   132: pop
    //   133: goto -51 -> 82
    //   136: astore_2
    //   137: aload_2
    //   138: invokevirtual 938	java/lang/Exception:printStackTrace	()V
    //   141: new 323	java/io/File
    //   144: dup
    //   145: ldc_w 982
    //   148: invokespecial 326	java/io/File:<init>	(Ljava/lang/String;)V
    //   151: astore_2
    //   152: aload_2
    //   153: invokevirtual 329	java/io/File:exists	()Z
    //   156: ifeq +99 -> 255
    //   159: new 964	java/util/Scanner
    //   162: dup
    //   163: aload_2
    //   164: invokespecial 967	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   167: astore 7
    //   169: aload 7
    //   171: invokevirtual 968	java/util/Scanner:hasNext	()Z
    //   174: ifeq +81 -> 255
    //   177: aload 7
    //   179: invokevirtual 971	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   182: astore_2
    //   183: aload_2
    //   184: ldc_w 984
    //   187: invokevirtual 828	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   190: ifeq -21 -> 169
    //   193: aload_2
    //   194: ldc_w 634
    //   197: invokevirtual 977	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   200: iconst_2
    //   201: aaload
    //   202: astore_3
    //   203: aload_3
    //   204: astore_2
    //   205: aload_3
    //   206: ldc_w 636
    //   209: invokevirtual 987	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   212: ifeq +16 -> 228
    //   215: aload_3
    //   216: iconst_0
    //   217: aload_3
    //   218: ldc_w 636
    //   221: invokevirtual 335	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   224: invokevirtual 825	java/lang/String:substring	(II)Ljava/lang/String;
    //   227: astore_2
    //   228: aload_2
    //   229: getstatic 957	com/tencent/mobileqq/app/AppConstants:al	Ljava/lang/String;
    //   232: invokevirtual 980	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   235: ifne -66 -> 169
    //   238: aload 6
    //   240: aload_2
    //   241: invokeinterface 960 2 0
    //   246: pop
    //   247: goto -78 -> 169
    //   250: astore_2
    //   251: aload_2
    //   252: invokevirtual 938	java/lang/Exception:printStackTrace	()V
    //   255: new 323	java/io/File
    //   258: dup
    //   259: ldc_w 989
    //   262: invokespecial 326	java/io/File:<init>	(Ljava/lang/String;)V
    //   265: astore_2
    //   266: aload_2
    //   267: invokevirtual 329	java/io/File:exists	()Z
    //   270: ifeq +99 -> 369
    //   273: new 964	java/util/Scanner
    //   276: dup
    //   277: aload_2
    //   278: invokespecial 967	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   281: astore 7
    //   283: aload 7
    //   285: invokevirtual 968	java/util/Scanner:hasNext	()Z
    //   288: ifeq +81 -> 369
    //   291: aload 7
    //   293: invokevirtual 971	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   296: astore_2
    //   297: aload_2
    //   298: ldc_w 984
    //   301: invokevirtual 828	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   304: ifeq -21 -> 283
    //   307: aload_2
    //   308: ldc_w 634
    //   311: invokevirtual 977	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   314: iconst_2
    //   315: aaload
    //   316: astore_3
    //   317: aload_3
    //   318: astore_2
    //   319: aload_3
    //   320: ldc_w 636
    //   323: invokevirtual 987	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   326: ifeq +16 -> 342
    //   329: aload_3
    //   330: iconst_0
    //   331: aload_3
    //   332: ldc_w 636
    //   335: invokevirtual 335	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   338: invokevirtual 825	java/lang/String:substring	(II)Ljava/lang/String;
    //   341: astore_2
    //   342: aload_2
    //   343: getstatic 957	com/tencent/mobileqq/app/AppConstants:al	Ljava/lang/String;
    //   346: invokevirtual 980	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   349: ifne -66 -> 283
    //   352: aload 6
    //   354: aload_2
    //   355: invokeinterface 960 2 0
    //   360: pop
    //   361: goto -78 -> 283
    //   364: astore_2
    //   365: aload_2
    //   366: invokevirtual 938	java/lang/Exception:printStackTrace	()V
    //   369: new 323	java/io/File
    //   372: dup
    //   373: ldc_w 991
    //   376: invokespecial 326	java/io/File:<init>	(Ljava/lang/String;)V
    //   379: astore_2
    //   380: aload_2
    //   381: invokevirtual 329	java/io/File:exists	()Z
    //   384: ifeq +99 -> 483
    //   387: new 964	java/util/Scanner
    //   390: dup
    //   391: aload_2
    //   392: invokespecial 967	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   395: astore 7
    //   397: aload 7
    //   399: invokevirtual 968	java/util/Scanner:hasNext	()Z
    //   402: ifeq +81 -> 483
    //   405: aload 7
    //   407: invokevirtual 971	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   410: astore_2
    //   411: aload_2
    //   412: ldc_w 984
    //   415: invokevirtual 828	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   418: ifeq -21 -> 397
    //   421: aload_2
    //   422: ldc_w 634
    //   425: invokevirtual 977	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   428: iconst_2
    //   429: aaload
    //   430: astore_3
    //   431: aload_3
    //   432: astore_2
    //   433: aload_3
    //   434: ldc_w 636
    //   437: invokevirtual 987	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   440: ifeq +16 -> 456
    //   443: aload_3
    //   444: iconst_0
    //   445: aload_3
    //   446: ldc_w 636
    //   449: invokevirtual 335	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   452: invokevirtual 825	java/lang/String:substring	(II)Ljava/lang/String;
    //   455: astore_2
    //   456: aload_2
    //   457: getstatic 957	com/tencent/mobileqq/app/AppConstants:al	Ljava/lang/String;
    //   460: invokevirtual 980	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   463: ifne -66 -> 397
    //   466: aload 6
    //   468: aload_2
    //   469: invokeinterface 960 2 0
    //   474: pop
    //   475: goto -78 -> 397
    //   478: astore_2
    //   479: aload_2
    //   480: invokevirtual 938	java/lang/Exception:printStackTrace	()V
    //   483: iconst_0
    //   484: istore_0
    //   485: iload_0
    //   486: aload 5
    //   488: invokeinterface 992 1 0
    //   493: if_icmpge +46 -> 539
    //   496: iload_0
    //   497: istore_1
    //   498: aload 6
    //   500: aload 5
    //   502: iload_0
    //   503: invokeinterface 995 2 0
    //   508: checkcast 60	java/lang/String
    //   511: invokeinterface 997 2 0
    //   516: ifne +16 -> 532
    //   519: aload 5
    //   521: iload_0
    //   522: invokeinterface 999 2 0
    //   527: pop
    //   528: iload_0
    //   529: iconst_1
    //   530: isub
    //   531: istore_1
    //   532: iload_1
    //   533: iconst_1
    //   534: iadd
    //   535: istore_0
    //   536: goto -51 -> 485
    //   539: aload 6
    //   541: invokeinterface 1002 1 0
    //   546: new 33	java/util/ArrayList
    //   549: dup
    //   550: bipush 10
    //   552: invokespecial 952	java/util/ArrayList:<init>	(I)V
    //   555: astore 6
    //   557: aload 5
    //   559: invokeinterface 1003 1 0
    //   564: astore 7
    //   566: aload 7
    //   568: invokeinterface 136 1 0
    //   573: ifeq +245 -> 818
    //   576: new 323	java/io/File
    //   579: dup
    //   580: aload 7
    //   582: invokeinterface 140 1 0
    //   587: checkcast 60	java/lang/String
    //   590: invokespecial 326	java/io/File:<init>	(Ljava/lang/String;)V
    //   593: astore 8
    //   595: aload 8
    //   597: invokevirtual 329	java/io/File:exists	()Z
    //   600: ifeq -34 -> 566
    //   603: aload 8
    //   605: invokevirtual 900	java/io/File:isDirectory	()Z
    //   608: ifeq -42 -> 566
    //   611: aload 8
    //   613: invokevirtual 1006	java/io/File:canWrite	()Z
    //   616: ifeq -50 -> 566
    //   619: aload 8
    //   621: invokevirtual 888	java/io/File:listFiles	()[Ljava/io/File;
    //   624: astore 9
    //   626: ldc_w 659
    //   629: astore_2
    //   630: aload_2
    //   631: astore_3
    //   632: aload 9
    //   634: ifnull +72 -> 706
    //   637: aload 9
    //   639: arraylength
    //   640: istore_1
    //   641: iconst_0
    //   642: istore_0
    //   643: aload_2
    //   644: astore_3
    //   645: iload_0
    //   646: iload_1
    //   647: if_icmpge +59 -> 706
    //   650: aload 9
    //   652: iload_0
    //   653: aaload
    //   654: astore_3
    //   655: new 51	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   662: aload_2
    //   663: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload_3
    //   667: invokevirtual 894	java/io/File:getName	()Ljava/lang/String;
    //   670: invokevirtual 1009	java/lang/String:hashCode	()I
    //   673: invokevirtual 628	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   676: ldc_w 636
    //   679: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: aload_3
    //   683: invokevirtual 331	java/io/File:length	()J
    //   686: invokevirtual 698	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   689: ldc_w 1011
    //   692: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   698: astore_2
    //   699: iload_0
    //   700: iconst_1
    //   701: iadd
    //   702: istore_0
    //   703: goto -60 -> 643
    //   706: new 51	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   713: aload_3
    //   714: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: ldc_w 301
    //   720: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   726: astore_3
    //   727: aload 6
    //   729: aload_3
    //   730: invokeinterface 997 2 0
    //   735: ifne -169 -> 566
    //   738: new 51	java/lang/StringBuilder
    //   741: dup
    //   742: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   745: ldc_w 1013
    //   748: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: aload 4
    //   753: invokeinterface 926 1 0
    //   758: invokevirtual 628	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   761: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: astore_2
    //   765: aload 4
    //   767: invokeinterface 926 1 0
    //   772: ifne +29 -> 801
    //   775: ldc 12
    //   777: astore_2
    //   778: aload 6
    //   780: aload_3
    //   781: invokeinterface 960 2 0
    //   786: pop
    //   787: aload 4
    //   789: aload_2
    //   790: aload 8
    //   792: invokeinterface 1014 3 0
    //   797: pop
    //   798: goto -232 -> 566
    //   801: aload 4
    //   803: invokeinterface 926 1 0
    //   808: iconst_1
    //   809: if_icmpne -31 -> 778
    //   812: ldc 17
    //   814: astore_2
    //   815: goto -37 -> 778
    //   818: aload 5
    //   820: invokeinterface 1002 1 0
    //   825: aload 4
    //   827: invokeinterface 1016 1 0
    //   832: ifeq +16 -> 848
    //   835: aload 4
    //   837: ldc 12
    //   839: invokestatic 1022	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   842: invokeinterface 1014 3 0
    //   847: pop
    //   848: aload 4
    //   850: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   484	219	0	i	int
    //   497	151	1	j	int
    //   65	25	2	localObject1	Object
    //   136	2	2	localException1	Exception
    //   151	90	2	localObject2	Object
    //   250	2	2	localException2	Exception
    //   265	90	2	localObject3	Object
    //   364	2	2	localException3	Exception
    //   379	90	2	localObject4	Object
    //   478	2	2	localException4	Exception
    //   629	186	2	str1	String
    //   93	688	3	str2	String
    //   9	840	4	localHashMap	HashMap
    //   20	799	5	localArrayList1	ArrayList
    //   31	748	6	localArrayList2	ArrayList
    //   167	414	7	localObject5	Object
    //   593	198	8	localFile	File
    //   624	27	9	arrayOfFile	File[]
    // Exception table:
    //   from	to	target	type
    //   55	82	136	java/lang/Exception
    //   82	133	136	java/lang/Exception
    //   141	169	250	java/lang/Exception
    //   169	203	250	java/lang/Exception
    //   205	228	250	java/lang/Exception
    //   228	247	250	java/lang/Exception
    //   255	283	364	java/lang/Exception
    //   283	317	364	java/lang/Exception
    //   319	342	364	java/lang/Exception
    //   342	361	364	java/lang/Exception
    //   369	397	478	java/lang/Exception
    //   397	431	478	java/lang/Exception
    //   433	456	478	java/lang/Exception
    //   456	475	478	java/lang/Exception
  }
  
  public static void a()
  {
    Object localObject2 = AppConstants.as;
    Object localObject1 = AppConstants.au;
    File localFile = new File((String)localObject2);
    if (!FileUtils.a((String)localObject2)) {
      localFile.mkdirs();
    }
    localObject2 = new File((String)localObject1);
    if (!FileUtils.a((String)localObject1)) {
      ((File)localObject2).mkdirs();
    }
    localObject1 = new File(AppConstants.as + ".nomedia");
    if (((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
  }
  
  public static void a(long paramLong)
  {
    Object localObject = ((QQAppInterface)BaseApplicationImpl.a().a()).a().a(paramLong);
    if (localObject == null) {
      return;
    }
    switch (((FileManagerEntity)localObject).nOpType)
    {
    case -1: 
    case 0: 
    case 3: 
    case 7: 
    case 2: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    default: 
      return;
    case 1: 
    case 5: 
    case 8: 
      localObject = d(((FileManagerEntity)localObject).fileName);
      FMToastUtil.c((String)localObject + BaseApplicationImpl.getContext().getString(2131558717) + AppConstants.as);
      return;
    }
    FMToastUtil.c(BaseApplicationImpl.getContext().getString(2131558740, new Object[] { d(((FileManagerEntity)localObject).fileName) }));
  }
  
  public static void a(long paramLong, int paramInt, String paramString)
  {
    FileManagerEntity localFileManagerEntity = ((QQAppInterface)BaseApplicationImpl.a().a()).a().a(paramLong);
    if (localFileManagerEntity == null) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (localFileManagerEntity.nOpType)
          {
          case -1: 
          case 2: 
          default: 
            return;
          }
        } while (a(paramInt, localFileManagerEntity.fileName));
        if ((paramString == null) || (paramString.length() <= 0)) {
          break;
        }
        a(paramString);
        return;
        if ((paramString != null) && (paramString.length() > 0))
        {
          a(paramString);
          return;
        }
      } while (a(paramInt, localFileManagerEntity.fileName));
      a(13, localFileManagerEntity.fileName);
      return;
    } while (a(paramInt, localFileManagerEntity.fileName));
    if ((paramString != null) && (paramString.length() > 0))
    {
      a(paramString);
      return;
    }
    a(d(localFileManagerEntity.fileName) + BaseApplicationImpl.getContext().getString(2131558739));
    return;
    if ((paramString != null) && (paramString.length() > 0))
    {
      a(paramString);
      return;
    }
    a(11, localFileManagerEntity.fileName);
    return;
    if ((paramString != null) && (paramString.length() > 0))
    {
      a(paramString);
      return;
    }
    a(13, localFileManagerEntity.fileName);
    return;
    a(13, localFileManagerEntity.fileName);
    return;
    a(paramInt, null);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    File localFile = new File(paramString);
    if (localFile.exists()) {
      try
      {
        String str = a(paramString);
        Object localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        localObject = MimeTypesTools.a(paramActivity, str);
        Uri localUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        int i = MediaStoreUtil.a(paramString);
        ContentValues localContentValues = new ContentValues(7);
        localContentValues.put("title", str);
        localContentValues.put("_display_name", localFile.getName());
        localContentValues.put("date_modified", Long.valueOf(localFile.lastModified() / 1000L));
        localContentValues.put("mime_type", (String)localObject);
        localContentValues.put("orientation", Integer.valueOf(i));
        localContentValues.put("_data", paramString);
        localContentValues.put("_size", Long.valueOf(localFile.length()));
        paramActivity.getContentResolver().insert(localUri, localContentValues);
        FMToastUtil.b(2131558747);
        return;
      }
      catch (Exception paramActivity)
      {
        FMToastUtil.a(2131558746);
        return;
      }
      catch (OutOfMemoryError paramActivity)
      {
        FMToastUtil.a(2131558746);
        return;
      }
    }
    FMToastUtil.a(2131558746);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), FMLocalFileActivity.class);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", paramString);
    localIntent.putExtra("busiType", 1);
    localIntent.putExtra("sendprepare", paramInt1);
    localIntent.putExtra("apautocreate", paramBoolean);
    localIntent.putExtra("enterfrom", paramInt2);
    paramActivity.startActivityForResult(localIntent, 106);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = QlinkHelper.c();
    Bundle localBundle = new Bundle();
    localBundle.putInt("string_from", 1);
    localBundle.putString("string_uin", paramString2);
    localBundle.putString("string_nick", paramString3);
    localIntent.putExtra("string_bundle", localBundle);
    QlinkPluginProxyActivity.a(paramActivity, paramString1, localIntent, -1, null);
  }
  
  public static void a(Context paramContext, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2131558756;
    }
    while (NetworkUtil.e(paramContext)) {
      if ((a()) && (paramFileManagerEntity.fileSize > 5242880L) && (!a(paramFileManagerEntity)))
      {
        FMDialogUtil.a(paramContext, 2131558759, i, new gct(paramFileManagerEntity, paramQQAppInterface));
        return;
        i = 2131558757;
      }
      else
      {
        c(paramFileManagerEntity.nSessionId);
        paramQQAppInterface.a().a(paramFileManagerEntity.nSessionId);
        return;
      }
    }
    FMToastUtil.a(2131562488);
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    paramString = FileUtil.a(paramString);
    if (paramString == null)
    {
      paramImageView.setImageResource(2130838626);
      return;
    }
    paramImageView.setImageResource(b(paramString));
  }
  
  public static void a(TextView paramTextView)
  {
    if ((paramTextView != null) && (jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      paramTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public static void a(com.dataline.util.widget.AsyncImageView paramAsyncImageView, DataLineMsgRecord paramDataLineMsgRecord)
  {
    String str3 = FileUtil.a(paramDataLineMsgRecord.filename);
    if (str3 == null)
    {
      paramAsyncImageView.setImageResource(2130838626);
      label21:
      return;
    }
    String str2 = paramDataLineMsgRecord.filename;
    String str1 = str2;
    if (a(str3) == 0)
    {
      if (!FileUtils.b(paramDataLineMsgRecord.thumbPath)) {
        break label104;
      }
      str1 = paramDataLineMsgRecord.thumbPath;
    }
    for (;;)
    {
      paramAsyncImageView.setDefaultImage(b(str3));
      switch (a(str3))
      {
      default: 
        int i = b(str3);
        if (i == 0) {
          break label21;
        }
        paramAsyncImageView.setImageResource(i);
        return;
        label104:
        str1 = str2;
        if (paramDataLineMsgRecord.path != null)
        {
          str1 = str2;
          if (paramDataLineMsgRecord.path.length() > 0) {
            str1 = paramDataLineMsgRecord.path;
          }
        }
        break;
      }
    }
    paramAsyncImageView.setAsyncClipSize(128, 128);
    paramAsyncImageView.setAsyncImage(str1);
  }
  
  public static void a(BaseActivity paramBaseActivity, TextView paramTextView)
  {
    if ((paramTextView != null) && (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramBaseActivity.getResources().getDrawable(2130837852);
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    String str2 = "";
    if (paramLong2 < 0L) {
      paramLong2 = 0L;
    }
    for (;;)
    {
      String str1 = str2;
      if (paramString2 != null) {
        str1 = str2;
      }
      try
      {
        if (paramString2.length() > 0) {
          str1 = paramString2.substring(paramString2.indexOf("://") + 3, paramString2.lastIndexOf(":"));
        }
        paramString2 = str1;
      }
      catch (Exception localException)
      {
        label74:
        break label74;
      }
      localHashMap.put("param_serverip", paramString2);
      localHashMap.put("param_Server", paramString2);
      localHashMap.put("param_PeerUin", paramString3);
      localHashMap.put("param_uuid", paramString4);
      localHashMap.put("param_fsized", String.valueOf(paramLong4));
      localHashMap.put("param_fsizeo", String.valueOf(paramLong5));
      localHashMap.put("param_retry", String.valueOf(paramInt));
      localHashMap.put("param_nSessionId", String.valueOf(paramLong1));
      localHashMap.put("param_errMsg", String.valueOf(paramString5));
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), paramString1, true, paramLong2, paramLong3, localHashMap, paramString5);
      QLog.d("@@@@@@@", 1, "ReportFilemanagerInfo actType[" + paramString1 + "], isSuccess[" + String.valueOf(true) + "], nSessionId[" + String.valueOf(paramLong1) + "], duration[" + String.valueOf(paramLong2) + "], rpSize[" + String.valueOf(paramLong3) + "], transfSize[" + String.valueOf(paramLong4) + "], fileSize[" + String.valueOf(paramLong5) + "], retryTimes[" + String.valueOf(paramInt) + "], reserved[" + String.valueOf(paramString5) + "]");
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, long paramLong3, String paramString5, long paramLong4, long paramLong5, long paramLong6, String paramString6, String paramString7, int paramInt, String paramString8, String paramString9)
  {
    long l = paramLong2;
    if (paramLong2 == 0L) {
      l = System.currentTimeMillis();
    }
    String str1;
    if (l < 1L)
    {
      paramLong2 = 0L;
      String str2 = "";
      str1 = str2;
      if (paramString2 != null) {
        str1 = str2;
      }
    }
    try
    {
      if (paramString2.length() > 0) {
        str1 = paramString2.substring(paramString2.indexOf("://") + 3, paramString2.lastIndexOf(":"));
      }
      paramString2 = str1;
    }
    catch (Exception localException)
    {
      label710:
      for (;;)
      {
        int j;
        int i;
      }
    }
    if (paramLong2 < 0L)
    {
      paramLong2 = 0L;
      j = 0;
      i = j;
      if (paramString8 != null)
      {
        i = j;
        if (paramString8.length() > 0)
        {
          if (paramString8.indexOf("Network is unreachable") <= 0) {
            break label710;
          }
          i = 1;
        }
      }
      for (;;)
      {
        if (NetworkUtil.e(BaseApplication.getContext()))
        {
          str1 = paramString8;
          if (i == 0) {}
        }
        else
        {
          paramLong3 = 9004L;
          str1 = paramString8 + "_NotNetWork";
        }
        paramString8 = new HashMap();
        paramString8.put("param_serverip", String.valueOf(paramString2));
        paramString8.put("param_Server", String.valueOf(paramString2));
        paramString8.put("param_PeerUin", String.valueOf(paramString3));
        paramString8.put("param_uuid", String.valueOf(paramString4));
        paramString8.put("param_FailCode", Long.toString(paramLong3));
        paramString8.put("param_errorDesc", String.valueOf(paramString5));
        paramString8.put("param_fsized", String.valueOf(paramLong5));
        paramString8.put("param_fsizeo", String.valueOf(paramLong6));
        paramString8.put("param_url", String.valueOf(paramString6));
        paramString8.put("param_rspHeader", String.valueOf(paramString7));
        paramString8.put("param_retry", String.valueOf(paramInt));
        paramString8.put("param_errMsg", String.valueOf(str1 + "uin[" + paramQQAppInterface.a() + "]"));
        paramString8.put("param_nSessionId", String.valueOf(paramLong1));
        StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), paramString1, false, paramLong2, paramLong4, paramString8, paramString9);
        QLog.d("@@@@@@@", 1, "ReportFilemanagerInfo actType[" + paramString1 + "], isSuccess[" + String.valueOf(false) + "], nSessionId[" + String.valueOf(paramLong1) + "], param_FailCode[" + String.valueOf(paramLong3) + "], startTime[" + String.valueOf(l) + "], duration[" + String.valueOf(paramLong2) + "], rpSize[" + String.valueOf(paramLong4) + "], transfSize[" + String.valueOf(paramLong5) + "], fileSize[" + String.valueOf(paramLong6) + "], param_errorDesc[" + String.valueOf(paramString5) + "], retryTimes[" + String.valueOf(paramInt) + "], reserved[" + String.valueOf(paramString9) + "]");
        if (QLog.isColorLevel()) {
          QLog.e("@@@@@@@", 2, "ReportFilemanagerInfo Color Log actType[" + paramString1 + "], isSuccess[" + String.valueOf(false) + "], nSessionId[" + String.valueOf(paramLong1) + "], param_FailCode[" + String.valueOf(paramLong3) + "], errMsg[" + String.valueOf(str1) + "]");
        }
        return;
        paramLong2 = System.currentTimeMillis() - l;
        break;
        if (paramString8.indexOf("No route to host") > 0)
        {
          i = 1;
        }
        else
        {
          i = j;
          if (paramString8.indexOf("MalformedURLException") > 0) {
            i = 1;
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    String str = paramQQAppInterface.a();
    FileManagerReporter.a(paramQQAppInterface, paramActivity);
    a(paramQQAppInterface, str, paramActivity);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    if (!paramFileManagerEntity.bSend)
    {
      paramQQAppInterface = new gcu();
      DialogUtil.a(paramContext, 230, paramContext.getString(2131560920), paramContext.getString(2131560919), 2131563227, 2131562539, paramQQAppInterface, null).show();
      return;
    }
    String str1 = paramContext.getString(2131558689);
    String str2 = paramContext.getString(2131558687);
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramContext, null);
    localActionSheet.c(str1);
    localActionSheet.d(paramContext.getString(2131561746));
    localActionSheet.a(str2);
    localActionSheet.a(new gcv(paramQQAppInterface, paramFileManagerEntity, localActionSheet));
    localActionSheet.show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    File localFile = new File(paramQQAppInterface.getApplication().getFilesDir(), "FileOnlinePreviewConfig");
    for (;;)
    {
      int i;
      try
      {
        String str = paramString.replace(" ", "%20");
        i = 5;
        boolean bool = false;
        if (i > 0)
        {
          bool = HttpDownloadUtil.a(paramQQAppInterface, new URL(str), localFile);
          if (!bool) {
            break label233;
          }
        }
        if (!bool) {
          continue;
        }
        paramString = new FileManagerUtil.PreViewDataHandler();
      }
      catch (MalformedURLException paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FileManagerUtil", 2, "updateGuide with: " + QLog.getStackTraceString(paramQQAppInterface));
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FileManagerUtil", 2, "updateGuide download xml failed: " + paramString);
        continue;
      }
      finally
      {
        localFile.delete();
      }
      try
      {
        SAXParserFactory.newInstance().newSAXParser().parse(localFile, paramString);
        new FMConfig(paramQQAppInterface, paramString, paramLong);
        localFile.delete();
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FileManagerUtil", 2, "updateGuide with: " + QLog.getStackTraceString(paramQQAppInterface));
        continue;
      }
      label233:
      i -= 1;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, Activity paramActivity)
  {
    int i = StatisticAssist.a(paramActivity, paramString, "Stop_download_2-1_3-1");
    if (i > 0) {
      StatisticCollector.a(paramActivity).a(paramQQAppInterface, paramString, "", "Download", "Stop_download", 0, i, 0, "1", "1", null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Stop_download_2-1_3-0");
    if (i > 0) {
      StatisticCollector.a(paramActivity).a(paramQQAppInterface, paramString, "", "Download", "Stop_download", 0, i, 0, "1", "0", null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Stop_download_2-2_3-1");
    if (i > 0) {
      StatisticCollector.a(paramActivity).a(paramQQAppInterface, paramString, "", "Download", "Stop_download", 0, i, 0, "2", "1", null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Stop_download_2-2_3-0");
    if (i > 0) {
      StatisticCollector.a(paramActivity).a(paramQQAppInterface, paramString, "", "Download", "Stop_download", 0, i, 0, "2", "0", null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Start_download_2-0_3-1");
    if (i > 0) {
      StatisticCollector.a(paramActivity).a(paramQQAppInterface, paramString, "", "Download", "Start_download", 0, i, 0, "0", "1", null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Start_download_2-0_3-0");
    if (i > 0) {
      StatisticCollector.a(paramActivity).a(paramQQAppInterface, paramString, "", "Download", "Start_download", 0, i, 0, "0", "0", null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Start_download_2-3_3-1");
    if (i > 0) {
      StatisticCollector.a(paramActivity).a(paramQQAppInterface, paramString, "", "Download", "Start_download", 0, i, 0, "3", "1", null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Start_download_2-3_3-0");
    if (i > 0) {
      StatisticCollector.a(paramActivity).a(paramQQAppInterface, paramString, "", "Download", "Start_download", 0, i, 0, "3", "0", null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Complete_download_2_1");
    if (i > 0) {
      StatisticCollector.a(paramActivity).a(paramQQAppInterface, paramString, "", "Download", "Complete_download", 0, i, 0, "1", null, null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Stop_download_2-0_3-1");
    if (i > 0) {
      StatisticCollector.a(paramActivity).a(paramQQAppInterface, paramString, "", "Download", "Stop_download", 0, i, 0, "0", "1", null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Complete_download_2_0");
    if (i > 0) {
      StatisticCollector.a(paramActivity).a(paramQQAppInterface, paramString, "", "Download", "Complete_download", 0, i, 0, "0", null, null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Stop_download_2-0_3-0");
    if (i > 0) {
      StatisticCollector.a(paramActivity).a(paramQQAppInterface, paramString, "", "Download", "Stop_download", 0, i, 0, "0", "0", null, null);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.e("FileManagerUtil", 1, a());
      return;
    }
    int i = (int)a(paramFileManagerEntity.peerType);
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerUtil", 2, "setTempParam[" + i + "]");
    }
    paramFileManagerEntity.tmpSessionType = i;
    paramFileManagerEntity.tmpSessionSig = a(paramQQAppInterface, paramFileManagerEntity.peerUin, i);
    switch (i)
    {
    case 103: 
    default: 
      return;
    case 102: 
      paramFileManagerEntity.tmpSessionFromPhone = paramString1;
      paramFileManagerEntity.tmpSessionToPhone = paramString2;
      return;
    }
    paramFileManagerEntity.tmpSessionRelatedUin = paramString1;
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity.nFileType == -1) || (paramFileManagerEntity.nFileType == 5))
    {
      if (paramFileManagerEntity.strFilePath != null) {
        paramFileManagerEntity.nFileType = a(paramFileManagerEntity.strFilePath);
      }
    }
    else {
      return;
    }
    if ((paramFileManagerEntity.cloudType == 3) || (paramFileManagerEntity.cloudType == 5))
    {
      paramFileManagerEntity.nFileType = a(paramFileManagerEntity.fileName);
      return;
    }
    paramFileManagerEntity.nFileType = a(paramFileManagerEntity.strSrcName);
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    a(paramFileManagerEntity);
    String str2 = paramFileManagerEntity.strFilePath;
    String str1 = str2;
    if (paramFileManagerEntity.nFileType == 0)
    {
      if (!FileUtils.b(paramFileManagerEntity.strThumbPath)) {
        break label43;
      }
      str1 = paramFileManagerEntity.strThumbPath;
    }
    for (;;)
    {
      a(paramAsyncImageView, str1, paramFileManagerEntity.nFileType);
      return;
      label43:
      str1 = str2;
      if (paramFileManagerEntity.strFilePath != null)
      {
        str1 = str2;
        if (paramFileManagerEntity.strFilePath.length() > 0) {
          str1 = paramFileManagerEntity.strFilePath;
        }
      }
    }
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString, int paramInt)
  {
    paramAsyncImageView.setImageResource(d(paramInt));
    switch (paramInt)
    {
    }
    do
    {
      return;
      paramAsyncImageView.setDefaultImage(2130838612);
      paramAsyncImageView.setAsyncImage(paramString);
      return;
      paramAsyncImageView.setDefaultImage(2130838593);
    } while (!FileUtil.b(paramString));
    paramAsyncImageView.setApkIconAsyncImage(paramString);
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString, boolean paramBoolean)
  {
    String str = FileUtil.a(paramString);
    if (str == null) {
      paramAsyncImageView.setImageResource(2130838626);
    }
    do
    {
      return;
      paramAsyncImageView.setImageResource(b(paramString));
    } while (!paramBoolean);
    switch (a(str))
    {
    case 1: 
    default: 
      return;
    case 0: 
      paramAsyncImageView.setDefaultImage(2130838612);
      paramAsyncImageView.setAsyncImage(paramString);
      return;
    }
    paramAsyncImageView.setDefaultImage(2130838627);
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  public static void a(String paramString)
  {
    FMToastUtil.a(paramString);
  }
  
  public static void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQi", 0);
    paramString = "qlink_new_count_" + paramString;
    localSharedPreferences.edit().putInt(paramString, paramInt).commit();
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQi", 0);
    paramString1 = "qlink_new_flag_" + paramString1 + "_" + paramString2;
    localSharedPreferences.edit().putBoolean(paramString1, paramBoolean).commit();
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQi", 0);
    paramString = "qlink_new_flag_" + paramString;
    localSharedPreferences.edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public static boolean a()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && ((localNetworkInfo.getType() == 0) || (50 == localNetworkInfo.getType()));
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == FMConstants.cG;
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 6: 
    case 8: 
    case 14: 
    default: 
      QLog.e("FileManagerUtil", 1, "unknow errCode:" + String.valueOf(paramInt));
      bool = false;
    case 0: 
      return bool;
    case 1: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131558735));
      return true;
    case 2: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131558736));
      return true;
    case 3: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131558735));
      return true;
    case 4: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131558735));
      return true;
    case 5: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131558736));
      return true;
    case 7: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131558736));
      return true;
    case 9: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131558736));
      return true;
    case 10: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131558736));
      return true;
    case 11: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131558736));
      return true;
    case 12: 
      FMToastUtil.a(2131558742);
      return true;
    case 13: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131558736));
      return true;
    }
    FMToastUtil.a(2131558779);
    return true;
  }
  
  public static boolean a(long paramLong)
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {}
    do
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "nSessionID[" + String.valueOf(paramLong) + "]是否在队列中[" + String.valueOf(jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong))) + "]");
      }
    } while (!jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong)));
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = FMConfig.a(paramQQAppInterface, FMConfig.eOfflineFuntion.OpenForQQMusic, FMConfig.eOpenForQQAppSubKey.FunctionalSwitch);
    if (paramQQAppInterface == null) {
      return false;
    }
    return Boolean.valueOf(paramQQAppInterface).booleanValue();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity == null) || (paramFileManagerEntity.fileName == null) || ("".equals(paramFileManagerEntity.fileName))) {}
    while (f("com.tencent.mtt") < 510000) {
      return false;
    }
    return a(paramQQAppInterface, paramFileManagerEntity.fileName);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = FileUtil.a(paramString);
    return (paramQQAppInterface != null) && (paramQQAppInterface.length() > 0) && (".txt|.doc|.docx|.ppt|.pdf|.epub|.zip|.rar|.mp4|.flv|.avi|.3gp|.3gpp|.webm|.ts|.ogv|.m3u8|.asf|.wmv|.rmvb|.rm|.f4v|.mkv|.dat|.mov|.mpg|.xls|.xlsx|.pptx|".indexOf(paramQQAppInterface) >= 0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    paramQQAppInterface = FMConfig.a(paramQQAppInterface, paramString, FMConfig.eOnlinePreViewSubkey.FileMaxSize);
    if (paramQQAppInterface == null) {}
    while (Integer.parseInt(paramQQAppInterface) * 1048576 < paramLong) {
      return false;
    }
    return true;
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.cloudType == 3) {
      return false;
    }
    switch (paramFileManagerEntity.nOpType)
    {
    case 0: 
    case 1: 
    case 5: 
    case 6: 
    case 8: 
    case 2: 
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    return BaseApplication.getContext().getSharedPreferences("mobileQQi", 0).getBoolean("qlink_new_flag_" + paramString1 + "_" + paramString2, true);
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    case 101: 
    default: 
      return null;
    case 100: 
      return paramQQAppInterface.a().k(paramString);
    }
    return paramQQAppInterface.a().f(paramString);
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 1717	java/io/BufferedInputStream
    //   5: dup
    //   6: new 1719	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 1720	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 1723	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: sipush 10240
    //   21: newarray byte
    //   23: astore 4
    //   25: ldc_w 1725
    //   28: invokestatic 1730	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   31: astore_2
    //   32: aload_0
    //   33: aload 4
    //   35: invokevirtual 1736	java/io/InputStream:read	([B)I
    //   38: istore_1
    //   39: iload_1
    //   40: ifle +39 -> 79
    //   43: aload_2
    //   44: aload 4
    //   46: iconst_0
    //   47: iload_1
    //   48: invokevirtual 1740	java/security/MessageDigest:update	([BII)V
    //   51: goto -19 -> 32
    //   54: astore_2
    //   55: aload_3
    //   56: astore_2
    //   57: aload_0
    //   58: ifnull +9 -> 67
    //   61: aload_0
    //   62: invokevirtual 1743	java/io/InputStream:close	()V
    //   65: aload_3
    //   66: astore_2
    //   67: aload_2
    //   68: areturn
    //   69: astore_2
    //   70: aload_2
    //   71: invokevirtual 1744	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   74: aconst_null
    //   75: astore_2
    //   76: goto -44 -> 32
    //   79: aload_0
    //   80: ifnull +7 -> 87
    //   83: aload_0
    //   84: invokevirtual 1743	java/io/InputStream:close	()V
    //   87: aload_2
    //   88: ifnull +25 -> 113
    //   91: aload_2
    //   92: invokevirtual 1748	java/security/MessageDigest:digest	()[B
    //   95: astore_2
    //   96: aload_2
    //   97: astore_3
    //   98: aload_3
    //   99: astore_2
    //   100: aload_0
    //   101: ifnull -34 -> 67
    //   104: aload_0
    //   105: invokevirtual 1743	java/io/InputStream:close	()V
    //   108: aload_3
    //   109: areturn
    //   110: astore_0
    //   111: aload_3
    //   112: areturn
    //   113: aload_3
    //   114: astore_2
    //   115: aload_0
    //   116: ifnull -49 -> 67
    //   119: aload_0
    //   120: invokevirtual 1743	java/io/InputStream:close	()V
    //   123: aconst_null
    //   124: areturn
    //   125: astore_0
    //   126: aconst_null
    //   127: areturn
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_0
    //   131: aload_3
    //   132: astore_2
    //   133: aload_0
    //   134: ifnull -67 -> 67
    //   137: aload_0
    //   138: invokevirtual 1743	java/io/InputStream:close	()V
    //   141: aconst_null
    //   142: areturn
    //   143: astore_0
    //   144: aconst_null
    //   145: areturn
    //   146: astore_2
    //   147: aconst_null
    //   148: astore_0
    //   149: aload_0
    //   150: ifnull +7 -> 157
    //   153: aload_0
    //   154: invokevirtual 1743	java/io/InputStream:close	()V
    //   157: aload_2
    //   158: athrow
    //   159: astore 4
    //   161: goto -74 -> 87
    //   164: astore_0
    //   165: aconst_null
    //   166: areturn
    //   167: astore_0
    //   168: goto -11 -> 157
    //   171: astore_2
    //   172: goto -23 -> 149
    //   175: astore_2
    //   176: goto -45 -> 131
    //   179: astore_0
    //   180: aconst_null
    //   181: astore_0
    //   182: goto -127 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramString	String
    //   38	10	1	i	int
    //   31	13	2	localMessageDigest	java.security.MessageDigest
    //   54	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   56	12	2	localObject1	Object
    //   69	2	2	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   75	58	2	localObject2	Object
    //   146	12	2	localObject3	Object
    //   171	1	2	localObject4	Object
    //   175	1	2	localIOException1	java.io.IOException
    //   1	131	3	localObject5	Object
    //   23	22	4	arrayOfByte	byte[]
    //   159	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   18	25	54	java/io/FileNotFoundException
    //   25	32	54	java/io/FileNotFoundException
    //   32	39	54	java/io/FileNotFoundException
    //   43	51	54	java/io/FileNotFoundException
    //   70	74	54	java/io/FileNotFoundException
    //   83	87	54	java/io/FileNotFoundException
    //   91	96	54	java/io/FileNotFoundException
    //   25	32	69	java/security/NoSuchAlgorithmException
    //   104	108	110	java/io/IOException
    //   119	123	125	java/io/IOException
    //   2	18	128	java/io/IOException
    //   137	141	143	java/io/IOException
    //   2	18	146	finally
    //   83	87	159	java/io/IOException
    //   61	65	164	java/io/IOException
    //   153	157	167	java/io/IOException
    //   18	25	171	finally
    //   25	32	171	finally
    //   32	39	171	finally
    //   43	51	171	finally
    //   70	74	171	finally
    //   83	87	171	finally
    //   91	96	171	finally
    //   18	25	175	java/io/IOException
    //   25	32	175	java/io/IOException
    //   32	39	175	java/io/IOException
    //   43	51	175	java/io/IOException
    //   70	74	175	java/io/IOException
    //   91	96	175	java/io/IOException
    //   2	18	179	java/io/FileNotFoundException
  }
  
  /* Error */
  public static byte[] a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 1751	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)J
    //   4: lstore_2
    //   5: new 1719	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 1720	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: lload_2
    //   15: ldc2_w 1752
    //   18: lcmp
    //   19: ifge +69 -> 88
    //   22: aload_0
    //   23: lload_2
    //   24: invokestatic 1759	com/tencent/qphone/base/util/MD5:getPartfileMd5	(Ljava/lang/String;J)[B
    //   27: astore 4
    //   29: aload 4
    //   31: invokestatic 1765	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   34: astore 5
    //   36: aload_0
    //   37: invokestatic 1766	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   40: astore_0
    //   41: aload_0
    //   42: ifnull +35 -> 77
    //   45: aload_0
    //   46: invokevirtual 94	java/lang/String:length	()I
    //   49: ifle +28 -> 77
    //   52: new 51	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   59: aload 5
    //   61: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 142
    //   66: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_0
    //   70: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: pop
    //   77: aload_1
    //   78: ifnull +7 -> 85
    //   81: aload_1
    //   82: invokevirtual 1767	java/io/FileInputStream:close	()V
    //   85: aload 4
    //   87: areturn
    //   88: ldc2_w 1752
    //   91: lstore_2
    //   92: goto -70 -> 22
    //   95: astore_0
    //   96: aload_0
    //   97: invokevirtual 1768	java/io/IOException:printStackTrace	()V
    //   100: aload 4
    //   102: areturn
    //   103: astore_0
    //   104: aconst_null
    //   105: astore_0
    //   106: aload_0
    //   107: ifnull +7 -> 114
    //   110: aload_0
    //   111: invokevirtual 1767	java/io/FileInputStream:close	()V
    //   114: aconst_null
    //   115: areturn
    //   116: astore_0
    //   117: aload_0
    //   118: invokevirtual 1768	java/io/IOException:printStackTrace	()V
    //   121: goto -7 -> 114
    //   124: astore_0
    //   125: aconst_null
    //   126: astore_1
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 1767	java/io/FileInputStream:close	()V
    //   135: aload_0
    //   136: athrow
    //   137: astore_1
    //   138: aload_1
    //   139: invokevirtual 1768	java/io/IOException:printStackTrace	()V
    //   142: goto -7 -> 135
    //   145: astore_0
    //   146: goto -19 -> 127
    //   149: astore_0
    //   150: aload_1
    //   151: astore_0
    //   152: goto -46 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramString1	String
    //   0	155	1	paramString2	String
    //   4	88	2	l	long
    //   27	74	4	arrayOfByte	byte[]
    //   34	26	5	str	String
    // Exception table:
    //   from	to	target	type
    //   81	85	95	java/io/IOException
    //   5	14	103	java/io/IOException
    //   110	114	116	java/io/IOException
    //   5	14	124	finally
    //   131	135	137	java/io/IOException
    //   22	41	145	finally
    //   45	77	145	finally
    //   22	41	149	java/io/IOException
    //   45	77	149	java/io/IOException
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 2008: 
    default: 
      return -1;
    case 1000: 
    case 1001: 
    case 1002: 
    case 2000: 
    case 2001: 
    case 2002: 
      return 2;
    case 1004: 
    case 2004: 
      return 3;
    case 1005: 
    case 2005: 
    case 2006: 
      return 0;
    }
    return 1;
  }
  
  public static int b(String paramString)
  {
    paramString = FileUtil.a(paramString);
    if (paramString == null) {
      return 2130838626;
    }
    return d(a(paramString));
  }
  
  public static long b()
  {
    return MessageUtils.a(MessageUtils.a());
  }
  
  public static String b()
  {
    return AppConstants.as;
  }
  
  public static String b(long paramLong)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("##0.0");
    double d1 = 1024.0D * 1024.0D;
    double d2 = 1024.0D * d1;
    if (paramLong < 1024.0D) {
      return localDecimalFormat.format(paramLong) + "B/s";
    }
    if (paramLong < d1) {
      return localDecimalFormat.format(paramLong / 1024.0D) + "K/s";
    }
    if (paramLong < d2) {
      return localDecimalFormat.format(paramLong / d1) + "M/s";
    }
    return localDecimalFormat.format(paramLong / d2) + "G/s";
  }
  
  public static String b(String paramString)
  {
    int i = paramString.lastIndexOf(File.separator);
    int j = paramString.lastIndexOf(".");
    Object localObject2 = "";
    Object localObject1 = "";
    String str2 = "";
    String str1 = str2;
    if (i > 0)
    {
      if ((j <= 0) || (j <= i)) {
        break label160;
      }
      localObject1 = paramString.substring(i, j);
    }
    for (str1 = paramString.substring(j);; str1 = str2)
    {
      str2 = paramString.substring(0, i);
      localObject2 = localObject1;
      localObject1 = str2;
      File localFile = new File(paramString);
      i = 1;
      str2 = paramString;
      paramString = localFile;
      while (paramString.exists())
      {
        str2 = (String)localObject1 + (String)localObject2 + "(" + i + ")" + str1;
        paramString = new File(str2);
        i += 1;
      }
      label160:
      localObject1 = paramString.substring(i);
    }
    return str2;
  }
  
  public static URL b(String paramString, int paramInt1, int paramInt2, File paramFile)
  {
    long l = paramFile.lastModified();
    paramString = paramString + "|" + paramInt1 + "|" + paramInt2 + "|" + l;
    try
    {
      paramString = new URL("fileassistantimage", "", paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramString.getMessage(), paramString);
      }
    }
    return null;
  }
  
  public static void b() {}
  
  /* Error */
  public static void b(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 31	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: ifnonnull +13 -> 19
    //   9: new 33	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 36	java/util/ArrayList:<init>	()V
    //   16: putstatic 31	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   19: getstatic 31	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   22: lload_0
    //   23: invokestatic 549	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   26: invokevirtual 1645	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   29: istore_2
    //   30: iload_2
    //   31: ifeq +7 -> 38
    //   34: ldc 2
    //   36: monitorexit
    //   37: return
    //   38: getstatic 31	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   41: lload_0
    //   42: invokestatic 549	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   45: invokevirtual 911	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   48: pop
    //   49: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq -18 -> 34
    //   55: ldc_w 1640
    //   58: iconst_2
    //   59: new 51	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   66: ldc_w 1642
    //   69: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: lload_0
    //   73: invokestatic 437	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   76: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc_w 1803
    //   82: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 74	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: goto -57 -> 34
    //   94: astore_3
    //   95: ldc 2
    //   97: monitorexit
    //   98: aload_3
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramLong	long
    //   29	2	2	bool	boolean
    //   94	5	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	94	finally
    //   19	30	94	finally
    //   38	91	94	finally
  }
  
  public static void b(Activity paramActivity, String paramString)
  {
    if ((paramString == null) || (!FileUtil.a(paramString)))
    {
      FMToastUtil.a(2131558735);
      return;
    }
    String str = MimeTypesTools.a(paramActivity, paramString);
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), str);
    paramString = paramActivity.getPackageManager().queryIntentActivities(localIntent, 65536);
    if ((paramString.size() == 1) && (((ResolveInfo)paramString.get(0)).activityInfo.name.equals("com.tencent.mobileqq.activity.JumpActivity"))) {}
    for (int i = 1;; i = 0)
    {
      if ((paramString.size() > 0) && (i == 0)) {
        try
        {
          paramActivity.startActivity(localIntent);
          return;
        }
        catch (ActivityNotFoundException paramActivity)
        {
          FMToastUtil.a(2131558528);
          return;
        }
      }
      FMToastUtil.a(2131558528);
      return;
    }
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = QlinkHelper.c();
    Bundle localBundle = new Bundle();
    localBundle.putInt("string_from", 3);
    localBundle.putString("string_uin", paramString2);
    localBundle.putString("string_nick", paramString3);
    localIntent.putExtra("string_bundle", localBundle);
    QlinkPluginProxyActivity.a(paramActivity, paramString1, localIntent, -1, null);
  }
  
  public static void b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.strSrcName == null) {
      paramFileManagerEntity.strSrcName = paramFileManagerEntity.fileName;
    }
    while (paramFileManagerEntity.strSrcName.length() != 0) {
      return;
    }
    paramFileManagerEntity.strSrcName = paramFileManagerEntity.fileName;
  }
  
  public static void b(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQi", 0);
    paramString = "qlink_guide_flag_" + paramString;
    localSharedPreferences.edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public static boolean b(long paramLong)
  {
    if (jdField_b_of_type_JavaUtilArrayList == null) {
      jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (jdField_b_of_type_JavaUtilArrayList.size() == 0)
    {
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-6101L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-7004L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-7010L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-20103L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-25081L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-25092L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-30017L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-9527L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-91245L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-91354L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-91999L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-98064L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-98071L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-98075L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-98081L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-98084L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-98085L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-98090L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-98091L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-98095L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(8L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(900L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(4606L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9001L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9003L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9004L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9005L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9009L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9014L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9023L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9024L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9035L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9037L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9040L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9041L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9042L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9043L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9045L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9047L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9048L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9049L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9050L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9051L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9052L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9053L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9054L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9056L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9057L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9060L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9061L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9072L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9080L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9081L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9322L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9361L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(90451L));
    }
    return jdField_b_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = FMConfig.a(paramQQAppInterface, FMConfig.eOfflineFuntion.OpenForQQBrowse, FMConfig.eOpenForQQAppSubKey.FunctionalSwitch);
    if (paramQQAppInterface == null) {
      return false;
    }
    return Boolean.valueOf(paramQQAppInterface).booleanValue();
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity == null) || (paramFileManagerEntity.fileName == null) || ("".equals(paramFileManagerEntity.fileName))) {}
    int i;
    do
    {
      String str;
      do
      {
        return false;
        str = FMConfig.a(paramQQAppInterface, FMConfig.eOfflineFuntion.OpenForQQMusic, FMConfig.eOpenForQQAppSubKey.SupportVersion);
      } while (str == null);
      i = Integer.valueOf(str).intValue();
    } while (f("com.tencent.qqmusic") < i);
    return b(paramQQAppInterface, paramFileManagerEntity.fileName);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = FMConfig.a(paramQQAppInterface, FMConfig.eOfflineFuntion.OpenForQQMusic, FMConfig.eOpenForQQAppSubKey.FormatSupport);
    String str = FileUtil.a(paramString);
    if ((paramQQAppInterface != null) && (str != null) && (str.length() > 0) && (paramQQAppInterface.indexOf(str) >= 0)) {}
    while (a(paramString) == 1) {
      return true;
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("mobileQQi", 0).getBoolean("qlink_new_flag_" + paramString, true);
  }
  
  public static int c(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    case 1000: 
    case 2000: 
    case 2008: 
    default: 
      return -1;
    case 1003: 
    case 2003: 
      return 1;
    case 1005: 
    case 2005: 
      return 0;
    case 1004: 
    case 2004: 
    case 4001: 
      return 3;
    case 1001: 
    case 1002: 
    case 2001: 
    case 2002: 
      return 2;
    case 0: 
      return 0;
    case 1: 
      return 1;
    case 3: 
      return 3;
    }
    return 2;
  }
  
  @TargetApi(9)
  public static int c(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      i = -1;
    }
    Object localObject;
    do
    {
      return i;
      localObject = FileUtil.b(paramString);
    } while (b().equalsIgnoreCase((String)localObject));
    try
    {
      localObject = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString, "-");
      if (Build.VERSION.SDK_INT < 9)
      {
        ((SharedPreferences.Editor)localObject).commit();
        return 0;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return -2;
    }
    ((SharedPreferences.Editor)localObject).apply();
    return 0;
  }
  
  public static String c(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null)
    {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewRotateScreenFunctionalSwitch", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocFileType", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocInterfacePage", "qq_document_previewer.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocPreviewMode", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxFileType", "2");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxInterfacePage", "qq_document_previewer.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxPreviewMode", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfFileType", "7");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfInterfacePage", "qq_document_previewer.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfPreviewMode", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptFileType", "5");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptInterfacePage", "qq_ppt_previewer.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptPreviewMode", "4");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxFileType", "6");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxInterfacePage", "qq_ppt_previewer.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxPreviewMode", "5");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfFileType", "8");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfInterfacePage", "qq_pdf_previewer.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfPreviewMode", "3");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewzipFileMaxSize", "100");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewzipFileType", "13");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewzipInterfacePage", "qq_compress_previewer.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewzipPreviewMode", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrarFileMaxSize", "100");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrarFileType", "14");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrarInterfacePage", "qq_compress_previewer.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrarPreviewMode", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreView7zFileMaxSize", "100");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreView7zFileType", "15");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreView7zInterfacePage", "qq_compress_previewer.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreView7zPreviewMode", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtFileType", "16");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtInterfacePage", "qq_txt_previewer.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtPreviewMode", "2");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigOfflineFileListMerge", "true");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigOpenForQQMusicFunctionalSwitch", "true");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigOpenForQQMusicSupportVersion", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigOpenForQQMusicFormatSupport", ".mp3|.m4a|.ogg|");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigOpenForQQBrowseFunctionalSwitch", "true");
    }
    String str = (String)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((str == null) && (QLog.isColorLevel())) {
      QLog.e("FileManagerUtil", 2, "key[" + paramString + "],value null!");
    }
    return str;
  }
  
  /* Error */
  public static void c(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 31	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 31	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   18: lload_0
    //   19: invokestatic 549	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   22: invokevirtual 2137	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   25: pop
    //   26: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq -18 -> 11
    //   32: ldc_w 1640
    //   35: iconst_2
    //   36: new 51	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 1642
    //   46: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: lload_0
    //   50: invokestatic 437	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   53: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 2139
    //   59: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 74	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: goto -57 -> 11
    //   71: astore_2
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_2
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramLong	long
    //   6	2	2	localArrayList	ArrayList
    //   71	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	71	finally
    //   15	68	71	finally
  }
  
  public static boolean c(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("mobileQQi", 0).getBoolean("qlink_guide_flag_" + paramString, true);
  }
  
  private static int d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2130838626;
    case 2: 
      return 2130838627;
    case 0: 
      return 2130838612;
    case 1: 
      return 2130838613;
    case 3: 
      return 2130838598;
    case 4: 
      return 2130838631;
    case 6: 
      return 2130838630;
    case 5: 
      return 2130838593;
    case 7: 
      return 2130838616;
    case 8: 
      return 2130838599;
    case 9: 
      return 2130838615;
    }
    return 2130838620;
  }
  
  public static int d(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      i = -1;
    }
    Object localObject;
    do
    {
      return i;
      localObject = FileUtil.b(paramString);
    } while (b().equalsIgnoreCase((String)localObject));
    try
    {
      localObject = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).edit();
      ((SharedPreferences.Editor)localObject).remove(paramString);
      ((SharedPreferences.Editor)localObject).commit();
      return 0;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -2;
  }
  
  public static String d(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 16);
    int i = paramString.length();
    String str = paramString.substring(0, 8);
    paramString = paramString.substring(i - 8);
    return str + "..." + paramString;
  }
  
  public static int e(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("mobileQQi", 0).getInt("qlink_new_count_" + paramString, 0);
  }
  
  public static String e(String paramString)
  {
    String str;
    if (paramString == null)
    {
      str = null;
      return str;
    }
    label176:
    for (;;)
    {
      try
      {
        ByteArrayBuffer localByteArrayBuffer = new ByteArrayBuffer(paramString.length());
        str = paramString;
        if ("AnDrDQ_Fm_String".length() == 0) {
          break;
        }
        if (!paramString.equals(null))
        {
          int i = 0;
          int j = 0;
          if (j < paramString.length())
          {
            if (i <= "AnDrDQ_Fm_String".length() - 1) {
              break label176;
            }
            i %= "AnDrDQ_Fm_String".length();
            int m = paramString.codePointAt(j) + "AnDrDQ_Fm_String".codePointAt(i);
            int k = m;
            if (m > 65535) {
              k = m % 65535;
            }
            localByteArrayBuffer.append(k);
            j += 1;
            i += 1;
            continue;
          }
        }
        paramString = HexUtil.bytes2HexStr(localByteArrayBuffer.toByteArray());
        str = "#_#" + paramString + "O_O";
        break;
      }
      finally {}
    }
  }
  
  public static int f(String paramString)
  {
    Object localObject2 = BaseApplication.getContext().getPackageManager();
    Object localObject1 = ((PackageManager)localObject2).getInstalledPackages(0);
    localObject2 = ((PackageManager)localObject2).getInstalledApplications(0);
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      Object localObject3 = (PackageInfo)((List)localObject1).get(i);
      localObject3 = ((ApplicationInfo)((List)localObject2).get(i)).publicSourceDir;
      i += 1;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PackageInfo)((Iterator)localObject1).next();
      if (((PackageInfo)localObject2).packageName.equalsIgnoreCase(paramString)) {
        return ((PackageInfo)localObject2).versionCode;
      }
    }
    return -1;
  }
  
  public static String f(String paramString)
  {
    int i = 0;
    Object localObject;
    if (paramString == null)
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      try
      {
        paramString.toUpperCase();
        byte[] arrayOfByte = HexUtil.hexStr2Bytes(paramString);
        String str = "";
        localObject = paramString;
        if ("AnDrDQ_Fm_String".length() == 0) {
          break;
        }
        localObject = str;
        if (!paramString.equals("AnDrDQ_Fm_String"))
        {
          int j = 0;
          paramString = str;
          localObject = paramString;
          if (j < arrayOfByte.length)
          {
            if (i <= "AnDrDQ_Fm_String".length() - 1) {
              break label172;
            }
            i %= "AnDrDQ_Fm_String".length();
            m = "AnDrDQ_Fm_String".codePointAt(i);
            if (arrayOfByte[j] < 0)
            {
              k = arrayOfByte[j] + 256;
              break label175;
              paramString = paramString + (char)k;
              i += 1;
              j += 1;
              continue;
            }
            k = arrayOfByte[j];
            break label175;
          }
        }
        break;
      }
      finally {}
      label172:
      continue;
      label175:
      int m = k + 65535 - m;
      int k = m;
      if (m > 65535) {
        k = m % 65535;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil
 * JD-Core Version:    0.7.0.1
 */