package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import dnf;

public class DiscPicThumbDownloader
  extends BaseThumbDownloader
{
  private static final String b = "OfflineVideoThumbDownLoader<FileAssistant>";
  private FileTransferObserver a;
  
  public DiscPicThumbDownloader(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = new dnf(this);
  }
  
  private DiscPicThumbDownloader.PicSession a(long paramLong, boolean paramBoolean)
  {
    BaseThumbDownloader.Session localSession = a(paramLong);
    if (localSession == null) {
      return null;
    }
    if ((localSession instanceof DiscPicThumbDownloader.PicSession)) {
      return (DiscPicThumbDownloader.PicSession)localSession;
    }
    QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] getSession  ID[" + paramLong + "] no instance");
    return null;
  }
  
  private String b(int paramInt, String paramString)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "x-dsc-";
    }
    for (;;)
    {
      return str + paramString;
      str = "micro-dsc-";
      continue;
      str = "minni-dsc-";
      continue;
      str = "small-dsc-";
      continue;
      str = "middle-dsc-";
      continue;
      str = "large-dsc-";
      continue;
      str = "xlarge-dsc-";
      continue;
      str = "screen-dsc-";
    }
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "]");
    if (paramFileManagerEntity.Uuid == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  download. uuid = null nSession[" + paramFileManagerEntity.nSessionId + "]");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 50, new Object[] { paramFileManagerEntity });
      return null;
    }
    String str = paramFileManagerEntity.Uuid.replace("/", "");
    a();
    str = jdField_a_of_type_JavaLangString + b(paramInt, str);
    if (FileUtils.b(str) == true)
    {
      paramFileManagerEntity.strThumbPath = str;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 50, new Object[] { paramFileManagerEntity });
      QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 2, "download discFile Thumb existed,nSession[" + String.valueOf(paramFileManagerEntity.nSessionId) + "],discUin[" + String.valueOf(paramFileManagerEntity.peerUin) + "],path[" + str + "]");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileDiscThumb", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 0L, 0L, 0L, 0, null);
      return str;
    }
    paramFileManagerEntity = new DiscPicThumbDownloader.PicSession(paramFileManagerEntity);
    paramFileManagerEntity.jdField_a_of_type_Int = paramInt;
    a(paramFileManagerEntity, str);
    return null;
  }
  
  public void a(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    Object localObject = a(paramLong, false);
    if (localObject == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    int i;
    String str1;
    label76:
    QQAppInterface localQQAppInterface;
    long l1;
    String str2;
    String str3;
    String str4;
    String str5;
    long l2;
    long l3;
    long l4;
    long l5;
    String str6;
    if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
    {
      i = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.h;
      if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null) {
        break label224;
      }
      str1 = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.d();
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramLong = ((DiscPicThumbDownloader.PicSession)localObject).jdField_c_of_type_Long;
      l1 = ((DiscPicThumbDownloader.PicSession)localObject).b;
      str2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
      str3 = ((DiscPicThumbDownloader.PicSession)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str4 = ((DiscPicThumbDownloader.PicSession)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str5 = ((DiscPicThumbDownloader.PicSession)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l2 = i;
      l3 = paramDownloadTask.e;
      l4 = paramDownloadTask.jdField_c_of_type_Long;
      l5 = paramDownloadTask.jdField_a_of_type_Int;
      str6 = paramDownloadTask.jdField_a_of_type_JavaLangString;
      if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null) {
        break label231;
      }
    }
    label224:
    label231:
    for (localObject = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.ah;; localObject = "respose null")
    {
      FileManagerUtil.a(localQQAppInterface, paramLong, "actFileDiscThumbDetail", l1, str2, str3, str4, str5, l2, str1, l3, l4, l5, str6, (String)localObject, paramDownloadTask.jdField_c_of_type_Int, str1, "");
      return;
      i = 0;
      break;
      str1 = "start retry";
      break label76;
    }
  }
  
  public void a(long paramLong, HttpMsg paramHttpMsg)
  {
    DiscPicThumbDownloader.PicSession localPicSession = a(paramLong, false);
    if (localPicSession == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onSetHttpMsg no this session");
      return;
    }
    paramHttpMsg.e = 3000;
    paramHttpMsg.a("Cookie", "FTN5K=" + localPicSession.jdField_a_of_type_JavaLangString);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    DiscPicThumbDownloader.PicSession localPicSession = a(paramLong, false);
    if (localPicSession == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicSession.jdField_c_of_type_Long, "actFileDiscThumb", System.currentTimeMillis() - localPicSession.b, paramDownloadTask.jdField_a_of_type_JavaLangString, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramDownloadTask.e, paramDownloadTask.jdField_c_of_type_Long, paramDownloadTask.jdField_a_of_type_Int, paramDownloadTask.jdField_b_of_type_Int, null);
      localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath = paramString;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean, 50, new Object[] { localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity });
      super.a(paramLong, paramBoolean, paramInt, paramString, paramDownloadTask);
      return;
      switch (paramInt)
      {
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    long l1 = localPicSession.jdField_c_of_type_Long;
    long l2 = localPicSession.b;
    Object localObject2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
    String str2 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
    String str3 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
    String str4 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
    long l3 = paramDownloadTask.e;
    long l4 = paramDownloadTask.jdField_c_of_type_Long;
    long l5 = paramDownloadTask.jdField_a_of_type_Int;
    String str5 = paramDownloadTask.jdField_a_of_type_JavaLangString;
    if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
    {
      str1 = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.ah;
      label339:
      FileManagerUtil.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9003L, "rename error", l3, l4, l5, str5, str1, paramDownloadTask.jdField_b_of_type_Int, "rename error", "");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = localPicSession.jdField_c_of_type_Long;
      l2 = localPicSession.b;
      localObject2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
      str2 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str3 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str4 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l3 = paramDownloadTask.e;
      l4 = paramDownloadTask.jdField_c_of_type_Long;
      l5 = paramDownloadTask.jdField_a_of_type_Int;
      str5 = paramDownloadTask.jdField_a_of_type_JavaLangString;
      if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null) {
        break label1813;
      }
    }
    label1799:
    label1813:
    for (String str1 = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.ah;; str1 = "respose null")
    {
      FileManagerUtil.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9003L, "rename error", l3, l4, l5, str5, str1, paramDownloadTask.jdField_c_of_type_Int, "rename error", "");
      break;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = localPicSession.jdField_c_of_type_Long;
      l2 = localPicSession.b;
      localObject2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
      str2 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str3 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str4 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l3 = paramDownloadTask.e;
      l4 = paramDownloadTask.jdField_c_of_type_Long;
      l5 = localPicSession.jdField_a_of_type_Int;
      str5 = paramDownloadTask.jdField_a_of_type_JavaLangString;
      if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
      {
        str1 = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.ah;
        label636:
        FileManagerUtil.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9004L, "no network", l3, l4, l5, str5, str1, paramDownloadTask.jdField_b_of_type_Int, "no network", "");
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = localPicSession.jdField_c_of_type_Long;
        l2 = localPicSession.b;
        localObject2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
        str2 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str3 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str4 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = paramDownloadTask.e;
        l4 = paramDownloadTask.jdField_c_of_type_Long;
        l5 = localPicSession.jdField_a_of_type_Int;
        str5 = paramDownloadTask.jdField_a_of_type_JavaLangString;
        if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null) {
          break label836;
        }
      }
      label836:
      for (str1 = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.ah;; str1 = "respose null")
      {
        FileManagerUtil.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9004L, "no network", l3, l4, l5, str5, str1, paramDownloadTask.jdField_c_of_type_Int, "no network", "");
        break;
        str1 = "respose null";
        break label636;
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicSession.jdField_c_of_type_Long, "actFileDiscThumb", localPicSession.b, paramDownloadTask.jdField_a_of_type_JavaLangString, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, paramDownloadTask.jdField_a_of_type_JavaLangString, "", 0, "FileNotFoundException", "");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicSession.jdField_c_of_type_Long, "actFileDiscThumbDetail", localPicSession.b, paramDownloadTask.jdField_a_of_type_JavaLangString, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, paramDownloadTask.jdField_a_of_type_JavaLangString, "", 0, "size error", "");
      break;
      int i;
      label1000:
      label1018:
      long l6;
      String str6;
      if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
      {
        i = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.h;
        if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null) {
          break label1329;
        }
        str1 = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.d();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = localPicSession.jdField_c_of_type_Long;
        l2 = localPicSession.b;
        str2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
        str3 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str4 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str5 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = i;
        l4 = paramDownloadTask.e;
        l5 = paramDownloadTask.jdField_c_of_type_Long;
        l6 = paramDownloadTask.jdField_a_of_type_Int;
        str6 = paramDownloadTask.jdField_a_of_type_JavaLangString;
        if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null) {
          break label1337;
        }
        localObject1 = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.ah;
        label1127:
        FileManagerUtil.a((QQAppInterface)localObject2, l1, "actFileDiscThumb", l2, str2, str3, str4, str5, l3, str1, l4, l5, l6, str6, (String)localObject1, paramDownloadTask.jdField_b_of_type_Int, str1, "");
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = localPicSession.jdField_c_of_type_Long;
        l2 = localPicSession.b;
        str2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
        str3 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str4 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str5 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = i;
        l4 = paramDownloadTask.e;
        l5 = paramDownloadTask.jdField_c_of_type_Long;
        l6 = paramDownloadTask.jdField_a_of_type_Int;
        str6 = paramDownloadTask.jdField_a_of_type_JavaLangString;
        if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null) {
          break label1344;
        }
      }
      label1329:
      label1337:
      label1344:
      for (localObject1 = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.ah;; localObject1 = "respose null")
      {
        FileManagerUtil.a((QQAppInterface)localObject2, l1, "actFileDiscThumbDetail", l2, str2, str3, str4, str5, l3, str1, l4, l5, l6, str6, (String)localObject1, paramDownloadTask.jdField_c_of_type_Int, str1, "");
        break;
        i = 0;
        break label1000;
        str1 = "http resp err";
        break label1018;
        localObject1 = "respose null";
        break label1127;
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicSession.jdField_c_of_type_Long, "actFileDiscThumb", localPicSession.b, paramDownloadTask.jdField_a_of_type_JavaLangString, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "noRs", 0L, 0L, 0L, paramDownloadTask.jdField_a_of_type_JavaLangString, "", 0, "noRs", "");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicSession.jdField_c_of_type_Long, "actFileDiscThumbDetail", localPicSession.b, paramDownloadTask.jdField_a_of_type_JavaLangString, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "noRs", paramDownloadTask.e, paramDownloadTask.jdField_c_of_type_Long, paramDownloadTask.jdField_a_of_type_Int, paramDownloadTask.jdField_a_of_type_JavaLangString, "", 0, "noRs", "");
      break;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = localPicSession.jdField_c_of_type_Long;
      l2 = localPicSession.b;
      localObject2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
      str2 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str3 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str4 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l3 = paramDownloadTask.jdField_c_of_type_Long;
      l4 = paramDownloadTask.jdField_a_of_type_Int;
      str5 = paramDownloadTask.jdField_a_of_type_JavaLangString;
      if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
      {
        str1 = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.ah;
        label1604:
        FileManagerUtil.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9003L, "revStream write Exception", 0L, l3, l4, str5, str1, paramDownloadTask.jdField_b_of_type_Int, "revStream write Exception", "");
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = localPicSession.jdField_c_of_type_Long;
        l2 = localPicSession.b;
        localObject2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
        str2 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str3 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str4 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = paramDownloadTask.jdField_c_of_type_Long;
        l4 = paramDownloadTask.jdField_a_of_type_Int;
        str5 = paramDownloadTask.jdField_a_of_type_JavaLangString;
        if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null) {
          break label1799;
        }
      }
      for (str1 = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.ah;; str1 = "respose null")
      {
        FileManagerUtil.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9003L, "revStream write Exception", 0L, l3, l4, str5, str1, paramDownloadTask.jdField_c_of_type_Int, "revStream write Exception", "");
        break;
        str1 = "respose null";
        break label1604;
      }
      str1 = "respose null";
      break label339;
    }
  }
  
  public boolean a(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    paramDownloadTask = a(paramLong, false);
    if (paramDownloadTask == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, Long.parseLong(paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
    return true;
  }
  
  public void b(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader
 * JD-Core Version:    0.7.0.1
 */