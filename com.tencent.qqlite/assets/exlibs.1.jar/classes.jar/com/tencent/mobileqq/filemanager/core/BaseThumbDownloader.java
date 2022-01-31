package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.LinkedHashMap;

public class BaseThumbDownloader
  implements ThumbHttpDownloader.WhatHappen
{
  public static final int a = 0;
  public static final String a;
  public static final int b = 1;
  private static final String b = "BaseThumbDownloader<FileAssistant>";
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = -1;
  public static final int i = 17;
  public static final int j = 18;
  public static final int k = 19;
  public static final int l = 20;
  public static final int m = 21;
  public static final int n = 22;
  public static final int o = 23;
  public QQAppInterface a;
  protected LinkedHashMap a;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.ay + ".thumbnails/";
  }
  
  public BaseThumbDownloader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected int a(String paramString)
  {
    paramString = FileUtil.a(paramString);
    if (".mp4".equalsIgnoreCase(paramString)) {
      return 17;
    }
    if (".rmvb".equalsIgnoreCase(paramString)) {
      return 18;
    }
    if (".avi".equalsIgnoreCase(paramString)) {
      return 19;
    }
    if (".wmv".equalsIgnoreCase(paramString)) {
      return 20;
    }
    if (".flv".equalsIgnoreCase(paramString)) {
      return 21;
    }
    if (".3gp".equalsIgnoreCase(paramString)) {
      return 22;
    }
    if (".mkv".equalsIgnoreCase(paramString)) {
      return 23;
    }
    return -1;
  }
  
  protected final BaseThumbDownloader.Session a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      BaseThumbDownloader.Session localSession = (BaseThumbDownloader.Session)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
      return localSession;
    }
  }
  
  public String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "64*64";
    case 0: 
      return "16*16";
    case 1: 
      return "32*32";
    case 2: 
      return "64*64";
    case 3: 
      return "128*128";
    case 4: 
      return "320*320";
    case 5: 
      return "640*640";
    }
    return "1024*1024";
  }
  
  protected String a(int paramInt, String paramString)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "x-video-";
    }
    for (;;)
    {
      return str + paramString;
      str = "micro-video-";
      continue;
      str = "minni-video-";
      continue;
      str = "small-video-";
      continue;
      str = "middle-video-";
      continue;
      str = "large-video-";
      continue;
      str = "xlarge-video-";
      continue;
      str = "screen-video-";
    }
  }
  
  protected void a()
  {
    File localFile = new File(AppConstants.az);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public final void a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] removeSession");
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(Long.valueOf(paramLong));
      return;
    }
  }
  
  public void a(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask) {}
  
  public void a(long paramLong, HttpMsg paramHttpMsg) {}
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted" + " suc:" + paramBoolean + " errCode:" + paramInt + " thumbPath:" + paramString);
    a(paramLong);
  }
  
  public final void a(long paramLong, boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrlResult" + " suc:" + paramBoolean + " strDomain:" + paramString1 + " port:" + paramInt + " urlParam:" + paramString2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramLong, paramBoolean, paramString1, paramInt, paramString2, paramString3);
  }
  
  protected final void a(BaseThumbDownloader.Session paramSession)
  {
    if (paramSession == null)
    {
      QLog.e("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb] addSession = null");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramSession.a + "] addSession");
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramSession.a), paramSession);
      return;
    }
  }
  
  protected void a(BaseThumbDownloader.Session paramSession, String paramString)
  {
    paramSession.a = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString, this);
    a(paramSession);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
  }
  
  public boolean a(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    return false;
  }
  
  public void b(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.BaseThumbDownloader
 * JD-Core Version:    0.7.0.1
 */