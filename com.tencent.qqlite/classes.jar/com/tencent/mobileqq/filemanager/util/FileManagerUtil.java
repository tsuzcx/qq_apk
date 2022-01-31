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
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;
import com.dataline.mpfile.MpfileDataCenter;
import com.dataline.mpfile.MpfileTaskInfo;
import com.dataline.util.file.MediaStoreUtil;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dva;
import dvb;
import dvc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import java.util.Scanner;
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
  
  public static int a(FileManagerEntity paramFileManagerEntity)
  {
    int k = 0;
    if ((-1 == paramFileManagerEntity.status) || (1 == paramFileManagerEntity.status)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = k;
      if (paramFileManagerEntity.bSend)
      {
        j = k;
        if (8 != paramFileManagerEntity.nOpType)
        {
          j = k;
          if (5 != paramFileManagerEntity.nOpType)
          {
            j = k;
            if (1 != paramFileManagerEntity.nOpType) {
              j = 1;
            }
          }
        }
      }
      if (3 != paramFileManagerEntity.cloudType) {
        break label125;
      }
      if ((j != 0) && ((j == 0) || (i == 0))) {
        break label123;
      }
      if (TextUtils.isEmpty(paramFileManagerEntity.Uuid)) {
        break;
      }
      return 1;
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId)) {
      return 2;
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.strTroopFilePath)) {
      return 4;
    }
    label123:
    return 3;
    label125:
    if (((2 == paramFileManagerEntity.cloudType) || (1 == paramFileManagerEntity.cloudType) || (4 == paramFileManagerEntity.cloudType)) && (j != 0) && (i == 0) && (!TextUtils.isEmpty(paramFileManagerEntity.strFilePath))) {
      return 3;
    }
    return paramFileManagerEntity.cloudType;
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
      jdField_b_of_type_JavaUtilHashMap.remove(".m");
      jdField_b_of_type_JavaUtilHashMap.remove(".webp");
      jdField_b_of_type_JavaUtilHashMap.put(".bmp", Integer.valueOf(0));
      jdField_b_of_type_JavaUtilHashMap.put(".jpg", Integer.valueOf(0));
      jdField_b_of_type_JavaUtilHashMap.put(".jpeg", Integer.valueOf(0));
      jdField_b_of_type_JavaUtilHashMap.put(".png", Integer.valueOf(0));
      jdField_b_of_type_JavaUtilHashMap.put(".gif", Integer.valueOf(0));
      jdField_b_of_type_JavaUtilHashMap.put(".ico", Integer.valueOf(0));
      jdField_b_of_type_JavaUtilHashMap.put(".webp", Integer.valueOf(0));
      jdField_b_of_type_JavaUtilHashMap.put(".swf", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".mov", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".mp4", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".3gp", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".avi", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".rmvb", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".wmf", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".mpg", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".rm", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".asf", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".mpeg", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".mkv", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".wmv", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".flv", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".f4a", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".webm", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".mod", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".mpe", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".fla", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".m4r", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".m4u", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".m4v", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".vob", Integer.valueOf(2));
      jdField_b_of_type_JavaUtilHashMap.put(".doc", Integer.valueOf(3));
      jdField_b_of_type_JavaUtilHashMap.put(".docx", Integer.valueOf(3));
      jdField_b_of_type_JavaUtilHashMap.put(".wps", Integer.valueOf(3));
      jdField_b_of_type_JavaUtilHashMap.put(".pages", Integer.valueOf(3));
      jdField_b_of_type_JavaUtilHashMap.put(".zip", Integer.valueOf(4));
      jdField_b_of_type_JavaUtilHashMap.put(".rar", Integer.valueOf(4));
      jdField_b_of_type_JavaUtilHashMap.put(".7z", Integer.valueOf(4));
      jdField_b_of_type_JavaUtilHashMap.put(".tar", Integer.valueOf(4));
      jdField_b_of_type_JavaUtilHashMap.put(".iso", Integer.valueOf(4));
      jdField_b_of_type_JavaUtilHashMap.put("gz", Integer.valueOf(4));
      jdField_b_of_type_JavaUtilHashMap.put(".apk", Integer.valueOf(5));
      jdField_b_of_type_JavaUtilHashMap.put(".apk.rename", Integer.valueOf(5));
      jdField_b_of_type_JavaUtilHashMap.put(".xls", Integer.valueOf(6));
      jdField_b_of_type_JavaUtilHashMap.put(".xlsx", Integer.valueOf(6));
      jdField_b_of_type_JavaUtilHashMap.put(".csv", Integer.valueOf(6));
      jdField_b_of_type_JavaUtilHashMap.put(".numbers", Integer.valueOf(6));
      jdField_b_of_type_JavaUtilHashMap.put(".et", Integer.valueOf(6));
      jdField_b_of_type_JavaUtilHashMap.put(".ppt", Integer.valueOf(7));
      jdField_b_of_type_JavaUtilHashMap.put(".pptx", Integer.valueOf(7));
      jdField_b_of_type_JavaUtilHashMap.put(".pps", Integer.valueOf(7));
      jdField_b_of_type_JavaUtilHashMap.put(".dps", Integer.valueOf(7));
      jdField_b_of_type_JavaUtilHashMap.put(".keynotes", Integer.valueOf(7));
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
        jdField_b_of_type_JavaUtilHashMap.put(".mp3", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".wav", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".m4a", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".wave", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".midi", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".wma", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".ogg", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".ape", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".acc", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".aac", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".aiff", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".mid", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".xmf", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".rtttl", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".flac", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".amr", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".mp2", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".m3u", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".m4b", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".m4p", Integer.valueOf(1));
        jdField_b_of_type_JavaUtilHashMap.put(".mpga", Integer.valueOf(1));
      }
      if (QLog.isColorLevel()) {
        QLog.w("FileManagerUtil", 2, "Unknow file Type[" + paramString + "]");
      }
    }
  }
  
  public static int a(List paramList, long paramLong)
  {
    int i = 0;
    int j = paramList.size() - 1;
    int k = i;
    if (i <= j)
    {
      k = i + j >>> 1;
      FileInfo localFileInfo = (FileInfo)paramList.get(k);
      if (localFileInfo.b() > paramLong)
      {
        k += 1;
        i = j;
        j = k;
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break;
        if (localFileInfo.b() >= paramLong) {
          break label103;
        }
        k -= 1;
        j = i;
        i = k;
      }
    }
    label103:
    return k;
  }
  
  public static long a()
  {
    int i = MobileQQService.jdField_c_of_type_Int;
    MobileQQService.jdField_c_of_type_Int = i + 1;
    return (short)(int)((int)(i & 0xFFFFFFFF) & 0xFFFF);
  }
  
  public static long a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1L;
    case 1004: 
      return 105L;
    case 1000: 
      return 104L;
    case 1001: 
      return 100L;
    case 1006: 
      return 102L;
    }
    return 124L;
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
    int j = paramString2.length() + i;
    paramString1 = new SpannableString(paramString1);
    paramString2 = new dvc(paramTipsClickedInterface);
    paramString1.setSpan(new ForegroundColorSpan(2131427331), i, j, 33);
    paramString1.setSpan(paramString2, i, j, 33);
    paramString1.setSpan(paramString2, i, j, 33);
    return paramString1;
  }
  
  public static FileManagerEntity a()
  {
    Object localObject3 = FMDataCache.c();
    Object localObject2 = FMDataCache.b();
    Object localObject1 = FMDataCache.e();
    if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject3).next();
        if (localFileManagerEntity.nFileType == 0) {
          return localFileManagerEntity;
        }
      }
    }
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FileInfo)((Iterator)localObject2).next();
        if (((FileInfo)localObject3).b() == 0) {
          return a((FileInfo)localObject3);
        }
      }
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeiYunFileInfo)((Iterator)localObject1).next();
        if (a(((WeiYunFileInfo)localObject2).jdField_b_of_type_JavaLangString) == 0) {
          return a((WeiYunFileInfo)localObject2);
        }
      }
    }
    return null;
  }
  
  public static FileManagerEntity a(MpfileTaskInfo paramMpfileTaskInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.cloudType = 7;
    localFileManagerEntity.bSend = false;
    if (paramMpfileTaskInfo.g == MpfileTaskInfo.a) {
      localFileManagerEntity.status = 3;
    }
    for (;;)
    {
      localFileManagerEntity.fileName = paramMpfileTaskInfo.jdField_d_of_type_JavaLangString;
      localFileManagerEntity.strFilePath = paramMpfileTaskInfo.jdField_e_of_type_JavaLangString;
      localFileManagerEntity.fileSize = paramMpfileTaskInfo.jdField_b_of_type_Long;
      localFileManagerEntity.nFileType = a(paramMpfileTaskInfo.jdField_d_of_type_JavaLangString);
      if (localFileManagerEntity.nFileType == 0) {
        localFileManagerEntity.strThumbPath = String.format("http://%s:%d/qqmpfile/?action=thumbnail&fileid=%s", new Object[] { MpfileDataCenter.k, Integer.valueOf(MpfileDataCenter.E), paramMpfileTaskInfo.jdField_c_of_type_JavaLangString });
      }
      localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.jdField_c_of_type_Long / (float)paramMpfileTaskInfo.jdField_b_of_type_Long);
      localFileManagerEntity.uniseq = paramMpfileTaskInfo.jdField_d_of_type_Long;
      localFileManagerEntity.strDataLineMPFileID = paramMpfileTaskInfo.jdField_c_of_type_JavaLangString;
      ((QQAppInterface)BaseApplicationImpl.a().a()).a().d(localFileManagerEntity);
      return localFileManagerEntity;
      if (paramMpfileTaskInfo.g == MpfileTaskInfo.jdField_c_of_type_Int)
      {
        localFileManagerEntity.status = 1;
        localFileManagerEntity.fProgress = 1.0F;
      }
      else if ((paramMpfileTaskInfo.g == MpfileTaskInfo.jdField_d_of_type_Int) || (paramMpfileTaskInfo.g == MpfileTaskInfo.jdField_e_of_type_Int))
      {
        localFileManagerEntity.status = 3;
        localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.jdField_c_of_type_Long / (float)paramMpfileTaskInfo.jdField_b_of_type_Long);
      }
      else
      {
        localFileManagerEntity.status = 2;
        localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.jdField_c_of_type_Long / (float)paramMpfileTaskInfo.jdField_b_of_type_Long);
      }
    }
  }
  
  public static FileManagerEntity a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a().a();
    if (paramDataLineMsgRecord.entityID != 0L) {
      localFileManagerEntity1 = localQQAppInterface.a().a(paramDataLineMsgRecord.entityID);
    }
    FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
    if (localFileManagerEntity1 == null)
    {
      localFileManagerEntity2 = new FileManagerEntity();
      localFileManagerEntity2.nSessionId = a().longValue();
      paramDataLineMsgRecord.entityID = localFileManagerEntity2.nSessionId;
    }
    localFileManagerEntity2.cloudType = 6;
    localFileManagerEntity2.bSend = paramDataLineMsgRecord.isSendFromLocal();
    if (paramDataLineMsgRecord.fileMsgStatus == 0L) {
      if (!paramDataLineMsgRecord.issuc) {
        localFileManagerEntity2.status = 0;
      }
    }
    for (;;)
    {
      localFileManagerEntity2.fileName = paramDataLineMsgRecord.filename;
      localFileManagerEntity2.strFilePath = paramDataLineMsgRecord.path;
      localFileManagerEntity2.fileSize = paramDataLineMsgRecord.filesize;
      localFileManagerEntity2.nFileType = a(paramDataLineMsgRecord.filename);
      if (localFileManagerEntity2.nFileType == 0) {
        localFileManagerEntity2.strThumbPath = paramDataLineMsgRecord.thumbPath;
      }
      if (paramDataLineMsgRecord.strMoloKey != null) {
        localFileManagerEntity2.nFileType = a(paramDataLineMsgRecord.path);
      }
      localFileManagerEntity2.fProgress = paramDataLineMsgRecord.progress;
      localFileManagerEntity2.uniseq = paramDataLineMsgRecord.sessionid;
      localQQAppInterface.a().d(localFileManagerEntity2);
      return localFileManagerEntity2;
      if (paramDataLineMsgRecord.progress != 1.0F)
      {
        localFileManagerEntity2.status = 2;
      }
      else
      {
        localFileManagerEntity2.status = 1;
        continue;
        if (paramDataLineMsgRecord.fileMsgStatus == 2L)
        {
          if (paramDataLineMsgRecord.progress == 0.0F) {
            localFileManagerEntity2.status = 0;
          } else {
            localFileManagerEntity2.status = 3;
          }
        }
        else {
          localFileManagerEntity2.status = 3;
        }
      }
    }
  }
  
  public static FileManagerEntity a(FileInfo paramFileInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.cloudType = 3;
    localFileManagerEntity.fileName = paramFileInfo.e();
    localFileManagerEntity.strFilePath = paramFileInfo.d();
    localFileManagerEntity.fileSize = paramFileInfo.a();
    if (paramFileInfo.b() == 5) {}
    for (localFileManagerEntity.nFileType = 5;; localFileManagerEntity.nFileType = a(paramFileInfo.e()))
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
    localFileManagerEntity.srvTime = paramOfflineFileInfo.jdField_d_of_type_Long;
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
    localFileManagerEntity.nWeiYunSrcType = paramWeiYunFileInfo.jdField_c_of_type_Int;
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
    if (FileUtil.a(paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString))
    {
      localFileManagerEntity.strThumbPath = paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString;
      localFileManagerEntity.fileSize = paramTroopFileStatusInfo.jdField_b_of_type_Long;
      localFileManagerEntity.nFileType = a(paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString);
      if ((6 <= paramTroopFileStatusInfo.jdField_b_of_type_Int) && (13 != paramTroopFileStatusInfo.jdField_b_of_type_Int)) {
        break label206;
      }
      localFileManagerEntity.status = 2;
    }
    for (;;)
    {
      if (paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null) {
        localFileManagerEntity.strTroopFileID = paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString();
      }
      localFileManagerEntity.strTroopFilePath = paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString;
      localFileManagerEntity.busId = paramTroopFileStatusInfo.jdField_e_of_type_Int;
      localFileManagerEntity.TroopUin = paramTroopFileStatusInfo.jdField_a_of_type_Long;
      localFileManagerEntity.peerType = 1;
      localFileManagerEntity.peerUin = String.valueOf(paramTroopFileStatusInfo.jdField_a_of_type_Long);
      ((QQAppInterface)BaseApplicationImpl.a().a()).a().d(localFileManagerEntity);
      return localFileManagerEntity;
      if (!FileUtil.a(paramTroopFileStatusInfo.jdField_b_of_type_JavaLangString)) {
        break;
      }
      localFileManagerEntity.strThumbPath = paramTroopFileStatusInfo.jdField_b_of_type_JavaLangString;
      break;
      label206:
      if (12 == paramTroopFileStatusInfo.jdField_b_of_type_Int) {
        localFileManagerEntity.status = 0;
      } else {
        localFileManagerEntity.status = 1;
      }
    }
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
        if (QLog.isColorLevel()) {
          QLog.e("FMERROR", 1, localStackTraceElement.toString());
        }
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
    case 4: 
    case 8: 
    default: 
      return "文件";
    case 1: 
      return "音乐";
    case 0: 
      return "图片";
    case 2: 
      return "视频";
    case 3: 
    case 6: 
    case 7: 
    case 9: 
      return "文档";
    }
    return "应用";
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
    long l2 = 604800000L;
    long l1 = l2;
    int i;
    int j;
    label136:
    label171:
    String str2;
    switch (paramInt)
    {
    default: 
      l1 = l2;
    case 0: 
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(l1 + paramLong);
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
      l1 = 2592000000L;
      break;
      str1 = str1 + i;
      break label136;
      str1 = str1 + "-" + j;
      break label171;
    }
    label401:
    return str1 + i;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    Object localObject = null;
    paramString = paramContext.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, "_data=?", new String[] { paramString }, "title_key");
    if (!paramString.moveToFirst()) {}
    for (;;)
    {
      return null;
      try
      {
        i = paramString.getInt(paramString.getColumnIndexOrThrow("album_id"));
        if (i == -1) {
          continue;
        }
        paramString = paramContext.getContentResolver().query(Uri.parse("content://media/external/audio/albums" + "/" + Integer.toString(i)), new String[] { "album_art" }, null, null, null);
        paramContext = localObject;
        if (paramString.getCount() > 0)
        {
          paramContext = localObject;
          if (paramString.getColumnCount() > 0)
          {
            paramString.moveToNext();
            paramContext = paramString.getString(0);
          }
        }
        paramString.close();
        return paramContext;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          int i = -1;
        }
      }
    }
  }
  
  public static String a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    int i = a(paramString);
    if (i == 0) {}
    for (paramContext = MediaStoreUtil.a(paramString, paramInt1, paramInt2); paramContext == null; paramContext = ThumbnailUtils.extractThumbnail(ThumbnailUtils.createVideoThumbnail(paramString, 3), paramInt1, paramInt2, 2)) {
      do
      {
        return null;
      } while (i != 2);
    }
    try
    {
      Object localObject = new File(AppConstants.az);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = AppConstants.az + a(paramString) + ".JPG";
      FileUtil.a(paramContext, (String)localObject);
      paramContext.recycle();
      MediaStoreUtil.a((String)localObject, MediaStoreUtil.a(paramString));
      paramContext = (Context)localObject;
    }
    catch (FileNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        QLog.w("FileManagerUtil", 1, "createThumbnail FileNotFoundException:" + paramContext.getMessage());
        paramContext = null;
      }
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        QLog.w("FileManagerUtil", 1, "createThumbnail IOException:" + paramContext.getMessage());
        paramContext = null;
      }
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        QLog.w("FileManagerUtil", 1, "createThumbnail OutOfMemoryError:" + paramContext.getMessage());
        paramContext = null;
      }
    }
    return paramContext;
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
        return "讨论组";
      }
      return localFriendManager.c(paramString1, paramString2);
    }
    paramQQAppInterface = (PhoneContactManager)paramQQAppInterface.getManager(10);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b(paramString1.replace("+86", ""));
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
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FMERROR", 1, "getFileName but strFilePath is null");
      }
      a();
      return "";
    }
    int i = paramString.length();
    int j = paramString.lastIndexOf('/') + 1;
    if ((j < 0) && (QLog.isColorLevel())) {
      QLog.e("FileManagerUtil", 2, "filepath without / ?");
    }
    return paramString.substring(j, i);
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
    Object localObject2 = new File(b()).listFiles();
    if (localObject2 == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject3;
    Object localObject1;
    if (i < localObject2.length)
    {
      FileInfo localFileInfo = localObject2[i];
      localObject3 = localFileInfo.getPath();
      if ((!paramBoolean) && (localFileInfo.getName().startsWith("."))) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          localFileInfo = new FileInfo((String)localObject3);
          if (localFileInfo != null) {
            localArrayList.add(localFileInfo);
          }
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          for (;;)
          {
            localFileNotFoundException.printStackTrace();
            localObject1 = null;
          }
        }
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
            ((FileInfo)localObject3).d(((File)localObject2).getName());
            ((FileInfo)localObject3).a(((File)localObject2).isDirectory());
            ((FileInfo)localObject3).e(((File)localObject2).getPath());
            ((FileInfo)localObject3).a(((File)localObject2).length());
            ((FileInfo)localObject3).b(((File)localObject2).lastModified());
            localArrayList.add(localObject3);
          }
        }
      }
      if (paramInt != 0) {
        break label289;
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
      label289:
      Collections.sort(localArrayList, new FileCompare());
    }
  }
  
  @TargetApi(9)
  public static Map a(Activity paramActivity)
  {
    HashMap localHashMap = new HashMap(10);
    ArrayList localArrayList = new ArrayList(10);
    Object localObject6 = new ArrayList(10);
    localArrayList.add(AppConstants.aq);
    ((List)localObject6).add(AppConstants.aq);
    try
    {
      Object localObject1 = new File("/proc/mounts");
      Object localObject5;
      if (((File)localObject1).exists())
      {
        localObject1 = new Scanner((File)localObject1);
        while (((Scanner)localObject1).hasNext())
        {
          localObject5 = ((Scanner)localObject1).nextLine();
          if ((((String)localObject5).startsWith("/dev/block/vold/")) || (((String)localObject5).startsWith("/dev/block/platform/")))
          {
            localObject5 = localObject5.split(" ")[1];
            if (!((String)localObject5).equals(AppConstants.aq)) {
              localArrayList.add(localObject5);
            }
          }
        }
      }
      Object localObject2;
      Object localObject7;
      Object localObject3;
      Object localObject4;
      int i;
      int j;
      File localFile;
      File[] arrayOfFile;
      String str;
      int k;
      while (j == 1) {}
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      try
      {
        localObject2 = new File("/system/etc/vold.fstab");
        if (((File)localObject2).exists())
        {
          localObject7 = new Scanner((File)localObject2);
          while (((Scanner)localObject7).hasNext())
          {
            localObject2 = ((Scanner)localObject7).nextLine();
            if (((String)localObject2).startsWith("dev_mount"))
            {
              localObject5 = localObject2.split(" ")[2];
              localObject2 = localObject5;
              if (((String)localObject5).contains(":")) {
                localObject2 = ((String)localObject5).substring(0, ((String)localObject5).indexOf(":"));
              }
              if (!((String)localObject2).equals(AppConstants.aq)) {
                ((List)localObject6).add(localObject2);
              }
            }
          }
        }
        for (;;) {}
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        try
        {
          localObject3 = new File("/system/etc/internal_sd.fstab");
          if (((File)localObject3).exists())
          {
            localObject7 = new Scanner((File)localObject3);
            while (((Scanner)localObject7).hasNext())
            {
              localObject3 = ((Scanner)localObject7).nextLine();
              if (((String)localObject3).startsWith("dev_mount"))
              {
                localObject5 = localObject3.split(" ")[2];
                localObject3 = localObject5;
                if (((String)localObject5).contains(":")) {
                  localObject3 = ((String)localObject5).substring(0, ((String)localObject5).indexOf(":"));
                }
                if (!((String)localObject3).equals(AppConstants.aq)) {
                  ((List)localObject6).add(localObject3);
                }
              }
            }
          }
          i += 1;
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
          try
          {
            localObject4 = new File("/system/etc/external_sd.fstab");
            if (((File)localObject4).exists())
            {
              localObject7 = new Scanner((File)localObject4);
              while (((Scanner)localObject7).hasNext())
              {
                localObject4 = ((Scanner)localObject7).nextLine();
                if (((String)localObject4).startsWith("dev_mount"))
                {
                  localObject5 = localObject4.split(" ")[2];
                  localObject4 = localObject5;
                  if (((String)localObject5).contains(":")) {
                    localObject4 = ((String)localObject5).substring(0, ((String)localObject5).indexOf(":"));
                  }
                  if (!((String)localObject4).equals(AppConstants.aq)) {
                    ((List)localObject6).add(localObject4);
                  }
                }
              }
            }
            try
            {
              paramActivity = (String[])paramActivity.getClass().getMethod("getVolumePaths", null).invoke(paramActivity, null);
              k = paramActivity.length;
              i = 0;
              if (i < k)
              {
                str = paramActivity[i];
                localObject5 = new File(str);
                if ((Build.VERSION.SDK_INT <= 9) || (((File)localObject5).getUsableSpace() <= 0L)) {
                  break label1146;
                }
                if (!localHashMap.isEmpty())
                {
                  localObject6 = localHashMap.keySet().iterator();
                  do
                  {
                    if (!((Iterator)localObject6).hasNext()) {
                      break;
                    }
                  } while (((File)localHashMap.get((String)((Iterator)localObject6).next())).getPath().equalsIgnoreCase(str) != true);
                  j = 1;
                  break label1153;
                }
                localHashMap.put("externalSdCard", localObject5);
              }
            }
            catch (IllegalArgumentException paramActivity)
            {
              paramActivity.printStackTrace();
              localArrayList.clear();
              if (localHashMap.isEmpty()) {
                localHashMap.put("sdCard", Environment.getExternalStorageDirectory());
              }
              return localHashMap;
            }
            catch (IllegalAccessException paramActivity)
            {
              for (;;)
              {
                paramActivity.printStackTrace();
              }
            }
            catch (InvocationTargetException paramActivity)
            {
              for (;;)
              {
                paramActivity.printStackTrace();
              }
            }
            catch (NoSuchMethodException paramActivity)
            {
              for (;;)
              {
                paramActivity.printStackTrace();
              }
              j = 0;
            }
          }
          catch (Exception localException4)
          {
            localException4.printStackTrace();
            for (i = 0; i < localArrayList.size(); i = j + 1)
            {
              j = i;
              if (!((List)localObject6).contains((String)localArrayList.get(i)))
              {
                localArrayList.remove(i);
                j = i - 1;
              }
            }
            ((List)localObject6).clear();
            localObject6 = new ArrayList(10);
            localObject7 = localArrayList.iterator();
            while (((Iterator)localObject7).hasNext())
            {
              localFile = new File((String)((Iterator)localObject7).next());
              if ((localFile.exists()) && (localFile.isDirectory()) && (localFile.canWrite()))
              {
                arrayOfFile = localFile.listFiles();
                str = "[";
                localObject5 = str;
                if (arrayOfFile != null)
                {
                  j = arrayOfFile.length;
                  i = 0;
                  for (;;)
                  {
                    localObject5 = str;
                    if (i >= j) {
                      break;
                    }
                    localObject5 = arrayOfFile[i];
                    str = str + ((File)localObject5).getName().hashCode() + ":" + ((File)localObject5).length() + ", ";
                    i += 1;
                  }
                }
                localObject5 = (String)localObject5 + "]";
                if (!((List)localObject6).contains(localObject5))
                {
                  str = "sdCard_" + localHashMap.size();
                  if (localHashMap.size() == 0) {
                    str = "sdCard";
                  }
                  for (;;)
                  {
                    ((List)localObject6).add(localObject5);
                    localHashMap.put(str, localFile);
                    break;
                    if (localHashMap.size() == 1) {
                      str = "externalSdCard";
                    }
                  }
                }
              }
            }
            paramActivity = (StorageManager)paramActivity.getSystemService("storage");
          }
        }
      }
    }
    label1146:
    for (;;) {}
  }
  
  public static void a()
  {
    Object localObject2 = AppConstants.ay;
    Object localObject1 = AppConstants.aA;
    File localFile = new File((String)localObject2);
    if (!FileUtils.a((String)localObject2)) {
      localFile.mkdirs();
    }
    localObject2 = new File((String)localObject1);
    if (!FileUtils.a((String)localObject1)) {
      ((File)localObject2).mkdirs();
    }
    localObject1 = new File(AppConstants.ay + ".nomedia");
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
      FMToastUtil.c((String)localObject + BaseApplicationImpl.getContext().getString(2131361981) + AppConstants.ay);
      return;
    }
    FMToastUtil.c(d(((FileManagerEntity)localObject).fileName) + BaseApplicationImpl.getContext().getString(2131362003));
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
    a(d(localFileManagerEntity.fileName) + BaseApplicationImpl.getContext().getString(2131362002));
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
        FMToastUtil.b(2131362008);
        return;
      }
      catch (Exception paramActivity)
      {
        FMToastUtil.a(2131362007);
        return;
      }
      catch (OutOfMemoryError paramActivity)
      {
        FMToastUtil.a(2131362007);
        return;
      }
    }
    FMToastUtil.a(2131362007);
  }
  
  public static void a(Context paramContext, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2131362019;
    }
    while (NetworkUtil.e(paramContext)) {
      if ((a()) && (paramFileManagerEntity.fileSize > 5242880L) && (!a(paramFileManagerEntity)))
      {
        FMDialogUtil.a(paramContext, 2131362021, i, new dva(paramFileManagerEntity, paramQQAppInterface));
        return;
        i = 2131362020;
      }
      else
      {
        c(paramFileManagerEntity.nSessionId);
        paramQQAppInterface.a().a(paramFileManagerEntity.nSessionId);
        return;
      }
    }
    FMToastUtil.a(2131363449);
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    paramString = FileUtil.a(paramString);
    if (paramString == null)
    {
      paramImageView.setImageResource(2130838578);
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
      paramAsyncImageView.setImageResource(2130838578);
      label21:
      return;
    }
    String str2 = paramDataLineMsgRecord.filename;
    String str1 = str2;
    if (a(str3) == 0)
    {
      if (!FileUtils.b(paramDataLineMsgRecord.path)) {
        break label104;
      }
      str1 = paramDataLineMsgRecord.path;
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
        if (FileUtils.b(paramDataLineMsgRecord.thumbPath)) {
          str1 = paramDataLineMsgRecord.thumbPath;
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
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramBaseActivity.getResources().getDrawable(2130837908);
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
      ((Animatable)jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6)
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
      localHashMap.put("serverip", String.valueOf(paramString2));
      localHashMap.put("param_Server", String.valueOf(paramString2));
      localHashMap.put("param_ftnIP", String.valueOf(paramString2));
      localHashMap.put("param_PeerUin", paramString3);
      localHashMap.put("param_uuid", paramString4);
      localHashMap.put("param_MD5", paramString5);
      localHashMap.put("param_fsized", String.valueOf(paramLong4));
      localHashMap.put("param_fsizeo", String.valueOf(paramLong5));
      localHashMap.put("param_retry", String.valueOf(paramInt));
      localHashMap.put("param_nSessionId", String.valueOf(paramLong1));
      localHashMap.put("param_errMsg", String.valueOf(paramString6));
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), paramString1, true, paramLong2, paramLong3, localHashMap, paramString6);
      if (QLog.isColorLevel()) {
        QLog.d("@@@@@@@", 2, "ReportFilemanagerInfo actType[" + paramString1 + "], isSuccess[" + String.valueOf(true) + "], nSessionId[" + String.valueOf(paramLong1) + "], duration[" + String.valueOf(paramLong2) + "], rpSize[" + String.valueOf(paramLong3) + "], transfSize[" + String.valueOf(paramLong4) + "], fileSize[" + String.valueOf(paramLong5) + "], retryTimes[" + String.valueOf(paramInt) + "], reserved[" + String.valueOf(paramString6) + "]");
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    long l = paramLong2;
    if (paramLong2 == 0L) {
      l = System.currentTimeMillis();
    }
    if (l < 1L) {
      paramLong2 = 0L;
    }
    for (;;)
    {
      String str3 = "";
      String str1 = str3;
      if (paramString2 != null) {
        str1 = str3;
      }
      try
      {
        if (paramString2.length() > 0) {
          str1 = paramString2.substring(paramString2.indexOf("://") + 3, paramString2.lastIndexOf(":"));
        }
        if (paramLong2 < 0L)
        {
          paramLong2 = 0L;
          int j = 0;
          int i = j;
          if (paramString9 != null)
          {
            i = j;
            if (paramString9.length() > 0)
            {
              if (paramString9.indexOf("Network is unreachable") <= 0) {
                break label776;
              }
              i = 1;
            }
          }
          for (;;)
          {
            if (NetworkUtil.e(BaseApplication.getContext()))
            {
              paramString2 = paramString9;
              if (i == 0) {}
            }
            else
            {
              paramLong3 = 9004L;
              paramString2 = paramString9 + "_NotNetWork";
            }
            paramString9 = paramString2;
            if (!paramQQAppInterface.isLogin())
            {
              paramLong3 = 9004L;
              paramString9 = paramString2 + "_NotLogin";
            }
            paramString2 = new HashMap();
            paramString2.put("serverip", String.valueOf(str1));
            paramString2.put("param_Server", String.valueOf(str1));
            paramString2.put("param_ftnIP", String.valueOf(str1));
            paramString2.put("param_PeerUin", String.valueOf(paramString3));
            paramString2.put("param_uuid", String.valueOf(paramString4));
            paramString2.put("param_MD5", paramString5);
            paramString2.put("param_FailCode", Long.toString(paramLong3));
            paramString2.put("param_errorDesc", String.valueOf(paramString6));
            paramString2.put("param_fsized", String.valueOf(paramLong5));
            paramString2.put("param_fsizeo", String.valueOf(paramLong6));
            paramString2.put("param_url", String.valueOf(paramString7));
            paramString2.put("param_rspHeader", String.valueOf(paramString8));
            paramString2.put("param_retry", String.valueOf(paramInt));
            paramString2.put("param_errMsg", String.valueOf(paramString9 + "uin[" + paramQQAppInterface.a() + "]"));
            paramString2.put("param_nSessionId", String.valueOf(paramLong1));
            StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), paramString1, false, paramLong2, paramLong4, paramString2, paramString10);
            if (QLog.isColorLevel()) {
              QLog.d("@@@@@@@", 2, "ReportFilemanagerInfo actType[" + paramString1 + "], isSuccess[" + String.valueOf(false) + "], nSessionId[" + String.valueOf(paramLong1) + "], param_FailCode[" + String.valueOf(paramLong3) + "], startTime[" + String.valueOf(l) + "], duration[" + String.valueOf(paramLong2) + "], rpSize[" + String.valueOf(paramLong4) + "], transfSize[" + String.valueOf(paramLong5) + "], fileSize[" + String.valueOf(paramLong6) + "], param_errorDesc[" + String.valueOf(paramString6) + "], retryTimes[" + String.valueOf(paramInt) + "], reserved[" + String.valueOf(paramString10) + "]");
            }
            if (QLog.isColorLevel()) {
              QLog.e("@@@@@@@", 2, "ReportFilemanagerInfo Color Log actType[" + paramString1 + "], isSuccess[" + String.valueOf(false) + "], nSessionId[" + String.valueOf(paramLong1) + "], param_FailCode[" + String.valueOf(paramLong3) + "], errMsg[" + String.valueOf(paramString9) + "]");
            }
            return;
            paramLong2 = System.currentTimeMillis() - l;
            break;
            label776:
            if (paramString9.indexOf("No route to host") > 0)
            {
              i = 1;
            }
            else
            {
              i = j;
              if (paramString9.indexOf("MalformedURLException") > 0) {
                i = 1;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str2 = paramString2;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    a(paramQQAppInterface, paramQQAppInterface.a(), paramActivity);
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
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "1", "1", null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Stop_download_2-1_3-0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "1", "0", null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Stop_download_2-2_3-1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "2", "1", null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Stop_download_2-2_3-0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "2", "0", null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Start_download_2-0_3-1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "0", "1", null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Start_download_2-0_3-0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "0", "0", null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Start_download_2-3_3-1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "3", "1", null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Start_download_2-3_3-0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "3", "0", null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Complete_download_2_1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Complete_download", 1, i, 0, "0", "1", null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Stop_download_2-0_3-1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "0", "1", null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Complete_download_2_0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Complete_download", 1, i, 0, "0", null, null, null);
    }
    i = StatisticAssist.a(paramActivity, paramString, "Stop_download_2-0_3-0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "0", "0", null, null);
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
  
  public static void a(BaseFileAssistantActivity paramBaseFileAssistantActivity)
  {
    Object localObject = a();
    if (localObject == null)
    {
      QLog.e("FileManagerUtil", 1, "none select!why you can preview!");
      return;
    }
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
    localForwardFileInfo.c(3);
    localForwardFileInfo.a(10007);
    localObject = new Intent(paramBaseFileAssistantActivity, FileBrowserActivity.class);
    ((Intent)localObject).putExtra("FromEditBarPreview", true);
    ((Intent)localObject).putExtra("fileinfo", localForwardFileInfo);
    paramBaseFileAssistantActivity.startActivityForResult((Intent)localObject, 102);
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
    if (paramFileManagerEntity.cloudType == 3)
    {
      paramFileManagerEntity.nFileType = a(paramFileManagerEntity.fileName);
      return;
    }
    if ((paramFileManagerEntity.strSrcName != null) && (paramFileManagerEntity.strSrcName.length() > 0))
    {
      paramFileManagerEntity.nFileType = a(paramFileManagerEntity.strSrcName);
      return;
    }
    paramFileManagerEntity.nFileType = a(paramFileManagerEntity.fileName);
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    a(paramFileManagerEntity);
    String str = paramFileManagerEntity.strFilePath;
    if (paramFileManagerEntity.nFileType == 0) {
      if (FileUtils.b(paramFileManagerEntity.strFilePath)) {
        str = paramFileManagerEntity.strFilePath;
      }
    }
    for (;;)
    {
      a(paramAsyncImageView, str, paramFileManagerEntity.nFileType);
      return;
      if (FileUtils.b(paramFileManagerEntity.strThumbPath))
      {
        str = paramFileManagerEntity.strThumbPath;
      }
      else if (FileUtils.b(paramFileManagerEntity.strThumbPath))
      {
        str = paramFileManagerEntity.strThumbPath;
        continue;
        if (paramFileManagerEntity.nFileType == 2) {
          if (FileUtils.b(paramFileManagerEntity.strThumbPath)) {
            str = paramFileManagerEntity.strThumbPath;
          } else {
            str = null;
          }
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
      do
      {
        return;
        paramAsyncImageView.setDefaultImage(2130838550);
        paramAsyncImageView.setAsyncImage(paramString);
        return;
        paramAsyncImageView.setDefaultImage(2130838532);
      } while (!FileUtil.b(paramString));
      paramAsyncImageView.setApkIconAsyncImage(paramString);
      return;
      paramAsyncImageView.setDefaultImage(2130838579);
    } while (!FileUtil.b(paramString));
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString, boolean paramBoolean)
  {
    String str = FileUtil.a(paramString);
    if (str == null) {
      paramAsyncImageView.setImageResource(2130838578);
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
      paramAsyncImageView.setDefaultImage(2130838550);
      paramAsyncImageView.setAsyncImage(paramString);
      return;
    }
    paramAsyncImageView.setDefaultImage(2130838579);
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  public static void a(String paramString)
  {
    FMToastUtil.a(paramString);
  }
  
  @TargetApi(10)
  public static void a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, FileManagerUtil.IGetVideoCallback paramIGetVideoCallback)
  {
    ThreadManager.b(new dvb(paramString, paramInt3, paramBoolean, paramIGetVideoCallback, paramInt1, paramInt2));
  }
  
  public static boolean a()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && ((localNetworkInfo.getType() == 0) || (50 == localNetworkInfo.getType()));
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == FMConstants.cO;
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
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil", 1, "unknow errCode:" + String.valueOf(paramInt));
      }
      bool = false;
    case 0: 
      return bool;
    case 1: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131361998));
      return true;
    case 2: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131361999));
      return true;
    case 3: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131361998));
      return true;
    case 4: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131361998));
      return true;
    case 5: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131361999));
      return true;
    case 7: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131361999));
      return true;
    case 9: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131361999));
      return true;
    case 10: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131361999));
      return true;
    case 11: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131361999));
      return true;
    case 12: 
      FMToastUtil.a(2131362005);
      return true;
    case 13: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131361999));
      return true;
    }
    FMToastUtil.a(2131362040);
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
    paramQQAppInterface = FMConfig.c(paramQQAppInterface, "OpenForQQMusic", "FunctionalSwitch");
    if (paramQQAppInterface == null) {
      return false;
    }
    return Boolean.valueOf(paramQQAppInterface).booleanValue();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity == null) || (paramFileManagerEntity.fileName == null) || ("".equals(paramFileManagerEntity.fileName))) {}
    while (e("com.tencent.mtt") < 541100) {
      return false;
    }
    return a(paramQQAppInterface, paramFileManagerEntity.fileName);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = FileUtil.a(paramString) + "|";
    return (paramQQAppInterface != null) && (paramQQAppInterface.length() > 0) && (".rar|.zip|.7z|.doc|.docx|.ppt|.pptx|.xls|.xlsx|.txt|.pdf|.epub|.chm|.html|.htm|.xml|.mht|.url|.ini|.log|.bat|.php|.js|.lrc|.jpg|.jpeg|.png|.gif|.bmp|.webp|.torrent|.m3u8|.mp4|.flv|.avi|.3gp|.3gpp|.webm|.ts|.ogv|.asf|.wmv|.rmvb|.rm|.f4v|.dat|.mov|.mpg|.mkv|.mpeg|.mpeg1|.mpeg2|.xvid|.dvd|.vcd|.vob|.divx|".contains(paramQQAppInterface.toLowerCase()));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    paramQQAppInterface = FMConfig.a(paramQQAppInterface, paramString, "FileMaxSize");
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
  
  public static byte[] a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return paramQQAppInterface.a().k(paramString);
    case 102: 
      return paramQQAppInterface.a().f(paramString);
    case 109: 
      return paramQQAppInterface.a().l(paramString);
    }
    return paramQQAppInterface.a().d(paramString);
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 1909	java/io/BufferedInputStream
    //   5: dup
    //   6: new 1911	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 1912	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 1915	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: sipush 10240
    //   21: newarray byte
    //   23: astore 4
    //   25: ldc_w 1917
    //   28: invokestatic 1922	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   31: astore_2
    //   32: aload_0
    //   33: aload 4
    //   35: invokevirtual 1928	java/io/InputStream:read	([B)I
    //   38: istore_1
    //   39: iload_1
    //   40: ifle +39 -> 79
    //   43: aload_2
    //   44: aload 4
    //   46: iconst_0
    //   47: iload_1
    //   48: invokevirtual 1932	java/security/MessageDigest:update	([BII)V
    //   51: goto -19 -> 32
    //   54: astore_2
    //   55: aload_3
    //   56: astore_2
    //   57: aload_0
    //   58: ifnull +9 -> 67
    //   61: aload_0
    //   62: invokevirtual 1933	java/io/InputStream:close	()V
    //   65: aload_3
    //   66: astore_2
    //   67: aload_2
    //   68: areturn
    //   69: astore_2
    //   70: aload_2
    //   71: invokevirtual 1934	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   74: aconst_null
    //   75: astore_2
    //   76: goto -44 -> 32
    //   79: aload_0
    //   80: ifnull +7 -> 87
    //   83: aload_0
    //   84: invokevirtual 1933	java/io/InputStream:close	()V
    //   87: aload_2
    //   88: ifnull +25 -> 113
    //   91: aload_2
    //   92: invokevirtual 1938	java/security/MessageDigest:digest	()[B
    //   95: astore_2
    //   96: aload_2
    //   97: astore_3
    //   98: aload_3
    //   99: astore_2
    //   100: aload_0
    //   101: ifnull -34 -> 67
    //   104: aload_0
    //   105: invokevirtual 1933	java/io/InputStream:close	()V
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
    //   120: invokevirtual 1933	java/io/InputStream:close	()V
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
    //   138: invokevirtual 1933	java/io/InputStream:close	()V
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
    //   154: invokevirtual 1933	java/io/InputStream:close	()V
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
    //   54	1	2	localFileNotFoundException	FileNotFoundException
    //   56	12	2	localObject1	Object
    //   69	2	2	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   75	58	2	localObject2	Object
    //   146	12	2	localObject3	Object
    //   171	1	2	localObject4	Object
    //   175	1	2	localIOException1	IOException
    //   1	131	3	localObject5	Object
    //   23	22	4	arrayOfByte	byte[]
    //   159	1	4	localIOException2	IOException
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
      return 2130838578;
    }
    return d(a(paramString));
  }
  
  public static long b()
  {
    return MessageUtils.a(MessageUtils.a());
  }
  
  private static Bitmap b(Matrix paramMatrix, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int j = paramBitmap.getWidth() - paramInt1;
    int i = paramBitmap.getHeight() - paramInt2;
    Object localObject1;
    Object localObject2;
    if ((j < 0) || (i < 0)) {
      try
      {
        localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        paramMatrix = new Canvas((Bitmap)localObject1);
        j = Math.max(0, j / 2);
        i = Math.max(0, i / 2);
        localObject2 = new Rect(j, i, Math.min(paramInt1, paramBitmap.getWidth()) + j, Math.min(paramInt2, paramBitmap.getHeight()) + i);
        i = (paramInt1 - ((Rect)localObject2).width()) / 2;
        j = (paramInt2 - ((Rect)localObject2).height()) / 2;
        paramMatrix.drawBitmap(paramBitmap, (Rect)localObject2, new Rect(i, j, paramInt1 - i, paramInt2 - j), null);
        return localObject1;
      }
      catch (OutOfMemoryError paramMatrix)
      {
        QLog.e("FileManagerUtil", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
        return null;
      }
    }
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    if (f1 / f2 > paramInt1 / paramInt2)
    {
      f1 = paramInt2 / f2;
      if ((f1 < 0.9F) || (f1 > 1.0F))
      {
        paramMatrix.setScale(f1, f1);
        label224:
        if (paramMatrix == null) {
          break label376;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          paramMatrix = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramMatrix, true);
          if (paramMatrix != paramBitmap) {
            paramBitmap.recycle();
          }
          i = Math.max(0, paramMatrix.getWidth() - paramInt1);
          j = Math.max(0, paramMatrix.getHeight() - paramInt2);
        }
        catch (OutOfMemoryError paramMatrix)
        {
          QLog.e("FileManagerUtil", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
          return null;
        }
        try
        {
          localObject2 = Bitmap.createBitmap(paramMatrix, i / 2, j / 2, paramInt1, paramInt2);
          localObject1 = localObject2;
          if (localObject2 == paramMatrix) {
            break;
          }
          localObject1 = localObject2;
          if (paramMatrix == paramBitmap) {
            break;
          }
          paramMatrix.recycle();
          return localObject2;
        }
        catch (OutOfMemoryError paramMatrix)
        {
          label376:
          QLog.e("FileManagerUtil", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
        }
      }
      paramMatrix = null;
      break label224;
      f1 = paramInt1 / f1;
      if ((f1 < 0.9F) || (f1 > 1.0F))
      {
        paramMatrix.setScale(f1, f1);
        break label224;
      }
      paramMatrix = null;
      break label224;
      paramMatrix = paramBitmap;
    }
    return null;
  }
  
  public static String b()
  {
    return AppConstants.ay;
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
    //   23: invokestatic 729	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   26: invokevirtual 1855	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   29: istore_2
    //   30: iload_2
    //   31: ifeq +7 -> 38
    //   34: ldc 2
    //   36: monitorexit
    //   37: return
    //   38: getstatic 31	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   41: lload_0
    //   42: invokestatic 729	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   45: invokevirtual 1174	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   48: pop
    //   49: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq -18 -> 34
    //   55: ldc_w 1850
    //   58: iconst_2
    //   59: new 51	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   66: ldc_w 1852
    //   69: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: lload_0
    //   73: invokestatic 635	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   76: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc_w 2030
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
      FMToastUtil.a(2131361998);
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
          FMToastUtil.a(2131361854);
          return;
        }
      }
      FMToastUtil.a(2131361854);
      return;
    }
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
    paramQQAppInterface = FMConfig.c(paramQQAppInterface, "OpenForQQBrowse", "FunctionalSwitch");
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
        str = FMConfig.c(paramQQAppInterface, "OpenForQQMusic", "SupportVersion");
      } while (str == null);
      i = Integer.valueOf(str).intValue();
    } while (e("com.tencent.qqmusic") < i);
    return b(paramQQAppInterface, paramFileManagerEntity.fileName);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = FMConfig.c(paramQQAppInterface, "OpenForQQMusic", "FormatSupport");
    String str = FileUtil.a(paramString);
    if ((paramQQAppInterface != null) && (str != null) && (str.length() > 0) && (paramQQAppInterface.indexOf(str) >= 0)) {}
    while (a(paramString) == 1) {
      return true;
    }
    return false;
  }
  
  public static boolean b(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = true;
    if (paramFileManagerEntity == null) {
      return false;
    }
    switch (a(paramFileManagerEntity))
    {
    case 3: 
    case 5: 
    default: 
      return false;
    case 1: 
    case 2: 
    case 4: 
      return true;
    }
    if (paramFileManagerEntity.nFileType == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  /* Error */
  public static byte[] b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: invokestatic 2206	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)J
    //   7: lstore_1
    //   8: new 1911	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 1912	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: astore 4
    //   18: lload_1
    //   19: ldc2_w 2207
    //   22: lcmp
    //   23: ifge +28 -> 51
    //   26: aload 4
    //   28: astore_3
    //   29: aload_0
    //   30: lload_1
    //   31: invokestatic 2214	com/tencent/qphone/base/util/MD5:getPartfileMd5	(Ljava/lang/String;J)[B
    //   34: astore_0
    //   35: aload_0
    //   36: astore_3
    //   37: aload 4
    //   39: ifnull +10 -> 49
    //   42: aload 4
    //   44: invokevirtual 2215	java/io/FileInputStream:close	()V
    //   47: aload_0
    //   48: astore_3
    //   49: aload_3
    //   50: areturn
    //   51: ldc2_w 2207
    //   54: lstore_1
    //   55: goto -29 -> 26
    //   58: astore_3
    //   59: aload_3
    //   60: invokevirtual 935	java/io/IOException:printStackTrace	()V
    //   63: ldc 23
    //   65: iconst_1
    //   66: new 51	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 2217
    //   76: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_3
    //   80: invokevirtual 2218	java/io/IOException:toString	()Ljava/lang/String;
    //   83: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 74	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: aload_0
    //   93: areturn
    //   94: astore 5
    //   96: aconst_null
    //   97: astore_0
    //   98: aload_0
    //   99: astore_3
    //   100: ldc 23
    //   102: iconst_1
    //   103: new 51	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 2220
    //   113: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload 5
    //   118: invokevirtual 2218	java/io/IOException:toString	()Ljava/lang/String;
    //   121: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 74	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload 6
    //   132: astore_3
    //   133: aload_0
    //   134: ifnull -85 -> 49
    //   137: aload_0
    //   138: invokevirtual 2215	java/io/FileInputStream:close	()V
    //   141: aconst_null
    //   142: areturn
    //   143: astore_0
    //   144: aload_0
    //   145: invokevirtual 935	java/io/IOException:printStackTrace	()V
    //   148: ldc 23
    //   150: iconst_1
    //   151: new 51	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 2217
    //   161: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_0
    //   165: invokevirtual 2218	java/io/IOException:toString	()Ljava/lang/String;
    //   168: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 74	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aconst_null
    //   178: areturn
    //   179: astore_0
    //   180: aconst_null
    //   181: astore_3
    //   182: aload_3
    //   183: ifnull +7 -> 190
    //   186: aload_3
    //   187: invokevirtual 2215	java/io/FileInputStream:close	()V
    //   190: aload_0
    //   191: athrow
    //   192: astore_3
    //   193: aload_3
    //   194: invokevirtual 935	java/io/IOException:printStackTrace	()V
    //   197: ldc 23
    //   199: iconst_1
    //   200: new 51	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 2217
    //   210: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_3
    //   214: invokevirtual 2218	java/io/IOException:toString	()Ljava/lang/String;
    //   217: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 74	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: goto -36 -> 190
    //   229: astore_0
    //   230: goto -48 -> 182
    //   233: astore 5
    //   235: aload 4
    //   237: astore_0
    //   238: goto -140 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramString	String
    //   7	48	1	l	long
    //   28	22	3	localObject1	Object
    //   58	22	3	localIOException1	IOException
    //   99	88	3	localObject2	Object
    //   192	22	3	localIOException2	IOException
    //   16	220	4	localFileInputStream	java.io.FileInputStream
    //   94	23	5	localIOException3	IOException
    //   233	1	5	localIOException4	IOException
    //   1	130	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   42	47	58	java/io/IOException
    //   8	18	94	java/io/IOException
    //   137	141	143	java/io/IOException
    //   8	18	179	finally
    //   186	190	192	java/io/IOException
    //   29	35	229	finally
    //   100	130	229	finally
    //   29	35	233	java/io/IOException
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
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreviewFunctionSwitch", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreviewWiFiMaxSize", "1000");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreview3GMaxSize", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocFileMaxSize", "20");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocFileType", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocInterfacePage", "qq_document_previewer.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocPreviewMode", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxFileMaxSize", "20");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxFileType", "2");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxInterfacePage", "qq_document_previewer.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxPreviewMode", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfFileMaxSize", "20");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfFileType", "7");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfInterfacePage", "qq_document_previewer.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfPreviewMode", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptFileMaxSize", "20");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptFileType", "5");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptInterfacePage", "qq_ppt_previewer.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptPreviewMode", "4");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxFileMaxSize", "20");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxFileType", "6");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxInterfacePage", "qq_ppt_previewer.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxPreviewMode", "5");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfFileMaxSize", "20");
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
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtFileMaxSize", "20");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtFileType", "16");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtInterfacePage", "qq_txt_previewer.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtPreviewMode", "2");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigOfflineFileListMerge", "true");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigOpenForQQMusicFunctionalSwitch", "true");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigOpenForQQMusicSupportVersion", "95");
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
    //   19: invokestatic 729	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   22: invokevirtual 2382	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   25: pop
    //   26: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq -18 -> 11
    //   32: ldc_w 1850
    //   35: iconst_2
    //   36: new 51	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 1852
    //   46: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: lload_0
    //   50: invokestatic 635	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   53: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 2384
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
  
  private static int d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2130838578;
    case 2: 
      return 2130838579;
    case 0: 
      return 2130838550;
    case 1: 
      return 2130838551;
    case 3: 
      return 2130838537;
    case 4: 
      return 2130838603;
    case 6: 
      return 2130838602;
    case 5: 
      return 2130838532;
    case 7: 
      return 2130838568;
    case 8: 
      return 2130838538;
    case 9: 
      return 2130838566;
    }
    return 2130838572;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil
 * JD-Core Version:    0.7.0.1
 */