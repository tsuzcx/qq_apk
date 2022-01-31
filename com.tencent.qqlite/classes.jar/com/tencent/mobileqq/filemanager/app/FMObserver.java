package com.tencent.mobileqq.filemanager.app;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.Thumbnail;
import com.weiyun.sdk.IWyFileSystem.ThumbnailType;
import dob;
import doc;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class FMObserver
  implements Observer
{
  static final String a = "FMObserver<FileAssistant>";
  
  private void a(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    long l2;
    Object[] arrayOfObject;
    switch (i)
    {
    default: 
      QLog.e("FMObserver<FileAssistant>", 1, "OnUpdate : Status[" + i + "] not processed");
      return;
    case 17: 
      l1 = ((Long)paramObject[1]).longValue();
      l2 = ((Long)paramObject[2]).longValue();
      localObject1 = (String)paramObject[3];
      i = ((Integer)paramObject[4]).intValue();
      QLog.i("FMObserver<FileAssistant>", 1, "OnFileCome uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "], strUin[" + FileManagerUtil.e((String)localObject1) + "], peerType[" + String.valueOf(i) + "]");
      a(l1, l2, (String)localObject1, i);
      return;
    case 0: 
      a();
      return;
    case 25: 
      b();
      return;
    case 10: 
    case 13: 
      l1 = ((Long)paramObject[1]).longValue();
      l2 = ((Long)paramObject[2]).longValue();
      localObject1 = (String)paramObject[3];
      i = ((Integer)paramObject[4]).intValue();
      QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferStart uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "], strUin[" + FileManagerUtil.e((String)localObject1) + "], peerType[" + String.valueOf(i) + "]");
      b(l1, l2, (String)localObject1, i);
      return;
    case 16: 
      l1 = ((Long)paramObject[1]).longValue();
      l2 = ((Long)paramObject[2]).longValue();
      localObject1 = (String)paramObject[3];
      i = ((Integer)paramObject[4]).intValue();
      if (((Integer)paramObject[5]).intValue() == 14)
      {
        a(false, l1, l2, (String)localObject1, i);
        return;
      }
      a(true, l1, l2, (String)localObject1, i);
      return;
    case 11: 
    case 14: 
    case 35: 
    case 37: 
      l1 = ((Long)paramObject[1]).longValue();
      l2 = ((Long)paramObject[2]).longValue();
      localObject1 = (String)paramObject[3];
      i = ((Integer)paramObject[4]).intValue();
      a();
      QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + l1 + "],nSessionId[" + l2 + "], peerType[" + i + "]");
      a(true, l1, l2, (String)localObject1, i, 0, null);
      return;
    case 1: 
    case 12: 
    case 15: 
    case 36: 
    case 38: 
      l1 = ((Long)paramObject[1]).longValue();
      l2 = ((Long)paramObject[2]).longValue();
      localObject1 = (String)paramObject[3];
      i = ((Integer)paramObject[4]).intValue();
      j = ((Integer)paramObject[5]).intValue();
      if (paramObject[6] == null) {}
      for (paramObject = null;; paramObject = (String)paramObject[6])
      {
        a();
        QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "],errCode[" + String.valueOf(j) + "],errMsg[" + String.valueOf(paramObject) + "], peerType[" + String.valueOf(i) + "]");
        a(false, l1, l2, (String)localObject1, i, j, paramObject);
        return;
      }
    case 22: 
      paramObject = (Object[])paramObject[2];
      a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue());
      return;
    case 4: 
      l1 = ((Long)paramObject[1]).longValue();
      l2 = ((Long)paramObject[2]).longValue();
      localObject1 = (String)paramObject[3];
      i = ((Integer)paramObject[4]).intValue();
      j = ((Integer)paramObject[5]).intValue();
      if (paramObject[6] == null) {}
      for (paramObject = null;; paramObject = (String)paramObject[6])
      {
        a();
        QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "],errCode[" + String.valueOf(j) + "],errMsg[" + String.valueOf(paramObject) + "], peerType[" + String.valueOf(i) + "]");
        c(j, paramObject);
        return;
      }
    case 18: 
      bool = ((Boolean)paramObject[1]).booleanValue();
      arrayOfObject = (Object[])paramObject[2];
      i = ((Integer)arrayOfObject[0]).intValue();
      localObject2 = (String)arrayOfObject[1];
      localObject3 = (String)arrayOfObject[2];
      localObject4 = (String)arrayOfObject[3];
      str = (String)arrayOfObject[4];
      j = ((Integer)arrayOfObject[5]).intValue();
      localObject1 = null;
      paramObject = localObject1;
      if (arrayOfObject.length > 6)
      {
        paramObject = localObject1;
        if (arrayOfObject[6] != null) {
          paramObject = (String)arrayOfObject[6];
        }
      }
      QLog.i("FMObserver<FileAssistant>", 1, "OnFileOfflinePreview retCode[" + String.valueOf(i) + "],retMsg[" + (String)localObject2 + "], " + "downloadKey[" + (String)localObject3 + "], downloadIp[" + (String)localObject4 + "], downloadDomain[" + str + "], port[" + String.valueOf(j) + "]");
      b(bool, i, (String)localObject2, (String)localObject3, (String)localObject4, str, j, paramObject);
      return;
    case 21: 
      bool = ((Boolean)paramObject[1]).booleanValue();
      arrayOfObject = (Object[])paramObject[2];
      i = ((Integer)arrayOfObject[0]).intValue();
      localObject2 = (String)arrayOfObject[1];
      localObject3 = (String)arrayOfObject[2];
      localObject4 = (String)arrayOfObject[3];
      str = (String)arrayOfObject[4];
      j = ((Integer)arrayOfObject[5]).intValue();
      localObject1 = null;
      paramObject = localObject1;
      if (arrayOfObject.length > 6)
      {
        paramObject = localObject1;
        if (arrayOfObject[6] != null) {
          paramObject = (String)arrayOfObject[6];
        }
      }
      QLog.i("FMObserver<FileAssistant>", 1, "OnFileOfflinePreview retCode[" + String.valueOf(i) + "],retMsg[" + (String)localObject2 + "], " + "downloadKey[" + (String)localObject3 + "], downloadIp[" + (String)localObject4 + "], downloadDomain[" + str + "], port[" + String.valueOf(j) + "]");
      a(bool, i, (String)localObject2, (String)localObject3, (String)localObject4, str, j, paramObject);
      return;
    case 30: 
      if (((Boolean)paramObject[1]).booleanValue())
      {
        paramObject = (List)paramObject[2];
        if (paramObject == null) {
          QLog.w("FMObserver<FileAssistant>", 1, "OnWeiYunClassificationTypeSuccess, but WeiYunClassificationType is null");
        }
        for (;;)
        {
          a(paramObject);
          return;
          QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunClassificationTypeSuccess, WeiYunClassificationType size[" + String.valueOf(paramObject.size()) + "]");
        }
      }
      paramObject = (Object[])paramObject[2];
      i = ((Integer)paramObject[0]).intValue();
      paramObject = (String)paramObject[1];
      QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunOneClassificationInfoFaild, , errorCode[" + String.valueOf(i) + "]" + ", strErrMsg[" + String.valueOf(paramObject) + "]" + "");
      d(i, paramObject);
      return;
    case 31: 
      if (((Boolean)paramObject[1]).booleanValue())
      {
        localObject2 = (Object[])paramObject[2];
        paramObject = (String)localObject2[0];
        bool = ((Boolean)localObject2[1]).booleanValue();
        j = ((Integer)localObject2[2]).intValue();
        l1 = ((Long)localObject2[3]).longValue();
        localObject1 = (List)localObject2[4];
        int k = ((Integer)localObject2[5]).intValue();
        localObject2 = new StringBuilder().append("OnWeiYunOneClassificationInfoSuccess, categoryId[").append(paramObject).append("]").append(", isEnd[").append(String.valueOf(bool)).append("]").append(", count[").append(String.valueOf(j)).append("]").append(", timestamp[").append(String.valueOf(l1)).append("]").append(", List<WeiYunFileInfo> size[");
        if (localObject1 != null) {}
        for (i = ((List)localObject1).size();; i = 0)
        {
          QLog.i("FMObserver<FileAssistant>", 1, String.valueOf(i) + "]" + ", index[" + String.valueOf(k) + "]" + "");
          a(paramObject, bool, j, l1, (List)localObject1, k);
          return;
        }
      }
      localObject1 = (Object[])paramObject[2];
      i = ((Integer)localObject1[0]).intValue();
      paramObject = (String)localObject1[1];
      localObject1 = (String)localObject1[2];
      QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunOneClassificationInfoFaild, , errorCode[" + String.valueOf(i) + "]" + ", strErrMsg[" + String.valueOf(paramObject) + "]" + ", strCategoryId[" + String.valueOf(localObject1) + "]" + "");
      a(i, paramObject, (String)localObject1);
      return;
    case 32: 
      if (((Boolean)paramObject[1]).booleanValue())
      {
        paramObject = (Object[])paramObject[2];
        bool = ((Boolean)paramObject[0]).booleanValue();
        paramObject = (List)paramObject[1];
        localObject1 = new StringBuilder().append("OnWeiYunOfflineListSucess, , isEnd[").append(String.valueOf(bool)).append("]").append(", List<OfflineFileInfo> size[");
        if (paramObject != null) {}
        for (i = paramObject.size();; i = 0)
        {
          QLog.i("FMObserver<FileAssistant>", 1, String.valueOf(i) + "]" + "");
          a(Boolean.valueOf(bool), paramObject);
          return;
        }
      }
      paramObject = (Object[])paramObject[2];
      i = ((Integer)paramObject[0]).intValue();
      paramObject = (String)paramObject[1];
      QLog.e("FMObserver<FileAssistant>", 1, "OnWeiYunOfflineListFaild, , errorCode[" + String.valueOf(i) + "]" + ", strErrMsg[" + String.valueOf(paramObject) + "]" + "");
      a(Integer.valueOf(i), paramObject);
      return;
    case 33: 
      if (((Boolean)paramObject[1]).booleanValue())
      {
        if (QLog.isColorLevel()) {
          QLog.d("FMObserver<FileAssistant>", 2, "OnWeiYunSendToOfflineSuccess");
        }
        c();
        return;
      }
      paramObject = (Object[])paramObject[2];
      i = ((Integer)paramObject[0]).intValue();
      localObject1 = (String)paramObject[1];
      l1 = ((Long)paramObject[2]).longValue();
      QLog.e("FMObserver<FileAssistant>", 1, "OnWeiYunSendToOfflineFaild, , nSessionId[" + String.valueOf(l1) + "]" + ", errorCode[" + String.valueOf(i) + "]" + ", strErrMsg[" + String.valueOf(localObject1) + "]" + "");
      a(Integer.valueOf(i), l1, (String)localObject1);
      return;
    case 34: 
      if (((Boolean)paramObject[1]).booleanValue())
      {
        paramObject = (Object[])paramObject[2];
        i = ((Integer)paramObject[0]).intValue();
        localObject1 = (String)paramObject[1];
        localObject2 = (String)paramObject[2];
        l1 = ((Long)paramObject[3]).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("FMObserver<FileAssistant>", 2, "OnOfflineSendToWeiYunSuccess, nSessionId[" + String.valueOf(l1) + "]");
        }
        a(l1, (String)localObject2, i, (String)localObject1);
        return;
      }
      paramObject = (Object[])paramObject[2];
      i = ((Integer)paramObject[0]).intValue();
      localObject1 = (String)paramObject[1];
      localObject2 = (String)paramObject[2];
      l1 = ((Long)paramObject[3]).longValue();
      QLog.e("FMObserver<FileAssistant>", 1, "OnWeiYunSendToOfflineFaild, , nSessionId[" + String.valueOf(l1) + "]" + ", errorCode[" + String.valueOf(i) + "]" + ", strErrMsg[" + String.valueOf(localObject1) + "]" + "");
      a(i, l1, (String)localObject1);
      return;
    case 39: 
      if (((Boolean)paramObject[1]).booleanValue())
      {
        localObject1 = (Object[])paramObject[2];
        paramObject = new ThumbnailInfo();
        localObject1 = (IWyFileSystem.Thumbnail)localObject1[0];
        paramObject.jdField_a_of_type_JavaLangObject = ((IWyFileSystem.Thumbnail)localObject1).context;
        paramObject.jdField_a_of_type_JavaLangString = ((IWyFileSystem.Thumbnail)localObject1).fileId;
        paramObject.b = ((IWyFileSystem.Thumbnail)localObject1).filePath;
        paramObject.jdField_a_of_type_Int = ((IWyFileSystem.Thumbnail)localObject1).type.ordinal();
        QLog.i("FMObserver<FileAssistant>", 1, "OnThumbDownLoadSuccess,fileId[" + paramObject.jdField_a_of_type_JavaLangString + "],filePath[" + paramObject.b + "]");
        if ((paramObject.jdField_a_of_type_JavaLangObject != null) && (((IWyFileSystem.Thumbnail)localObject1).filePath != null) && (((IWyFileSystem.Thumbnail)localObject1).filePath.length() > 0))
        {
          if (!(paramObject.jdField_a_of_type_JavaLangObject instanceof WeiYunFileInfo)) {
            break label2960;
          }
          ((WeiYunFileInfo)((IWyFileSystem.Thumbnail)localObject1).context).g = ((IWyFileSystem.Thumbnail)localObject1).filePath;
        }
        for (;;)
        {
          a(paramObject);
          return;
          if ((paramObject.jdField_a_of_type_JavaLangObject instanceof OfflineFileInfo)) {
            ((OfflineFileInfo)((IWyFileSystem.Thumbnail)localObject1).context).c = ((IWyFileSystem.Thumbnail)localObject1).filePath;
          } else if ((paramObject.jdField_a_of_type_JavaLangObject instanceof FileManagerEntity)) {
            ((FileManagerEntity)((IWyFileSystem.Thumbnail)localObject1).context).strThumbPath = ((IWyFileSystem.Thumbnail)localObject1).filePath;
          }
        }
      }
      localObject1 = (Object[])paramObject[2];
      localObject2 = (String)localObject1[0];
      paramObject = new ThumbnailInfo();
      paramObject.b = null;
      paramObject.jdField_a_of_type_JavaLangString = ((String)localObject2);
      paramObject.jdField_a_of_type_JavaLangObject = localObject1[1];
      localObject1 = new Handler();
      QLog.i("FMObserver<FileAssistant>", 1, "OnThumbDownLoadSuccess(faild),fileId[" + paramObject.jdField_a_of_type_JavaLangString + "],delay 1000ms");
      ((Handler)localObject1).postDelayed(new doc(this, paramObject), 1000L);
      return;
    case 40: 
      if (((Boolean)paramObject[1]).booleanValue())
      {
        paramObject = (String)paramObject[2];
        QLog.i("FMObserver<FileAssistant>", 1, "OnGetWeiYunPriviewUrlSuccess,strUrlString[" + paramObject + "]");
        a(paramObject);
        return;
      }
      paramObject = (Object[])paramObject[2];
      i = ((Integer)paramObject[0]).intValue();
      paramObject = (String)paramObject[1];
      QLog.e("FMObserver<FileAssistant>", 1, "OnGetWeiYunPriviewUrlFaild, , errorCode[" + String.valueOf(i) + "]" + ", strErrString[" + String.valueOf(paramObject) + "]" + "");
      b(Integer.valueOf(i), paramObject);
      return;
    case 3: 
      e();
      return;
    case 19: 
      bool = ((Boolean)paramObject[1]).booleanValue();
      paramObject = (Object[])paramObject[2];
      i = ((Integer)paramObject[0]).intValue();
      localObject1 = (String)paramObject[1];
      l1 = ((Long)paramObject[2]).longValue();
      l2 = ((Long)paramObject[3]).longValue();
      localObject2 = (String)paramObject[4];
      long l3 = ((Long)paramObject[5]).longValue();
      QLog.i("FMObserver<FileAssistant>", 1, "OnForwardOfflineFile, bSuccess[" + String.valueOf(bool) + "]" + ", retCode[" + String.valueOf(i) + "]" + ", retMsg[" + String.valueOf(localObject1) + "]" + ", totalSpace[" + String.valueOf(l1) + "]" + ", usedSpace[" + String.valueOf(l2) + "]" + ", strUuid[" + String.valueOf(localObject2) + "]" + ", nSessionId[" + String.valueOf(l3) + "]" + "");
      a(bool, i, (String)localObject1, l1, l2, (String)localObject2, l3);
      return;
    case 190: 
      bool = ((Boolean)paramObject[1]).booleanValue();
      localObject1 = (Object[])paramObject[2];
      localObject2 = (Integer)localObject1[0];
      localObject3 = (String)localObject1[1];
      paramObject = (Long)localObject1[2];
      if (!bool)
      {
        a(paramObject.longValue(), ((Integer)localObject2).intValue(), (String)localObject3);
        return;
      }
      localObject2 = (String)localObject1[3];
      localObject3 = (Integer)localObject1[4];
      localObject1 = (Long)localObject1[5];
      a(paramObject.longValue(), (String)localObject2, ((Integer)localObject3).intValue(), ((Long)localObject1).longValue());
      return;
    case 20: 
      bool = ((Boolean)paramObject[1]).booleanValue();
      localObject4 = (Object[])paramObject[2];
      paramObject = (Integer)localObject4[0];
      localObject1 = (String)localObject4[1];
      localObject2 = (String)localObject4[2];
      localObject3 = (String)localObject4[3];
      localObject4 = (Boolean)localObject4[4];
      if (!bool)
      {
        QLog.i("FMObserver<FileAssistant>", 1, "OnDelClouldFileFaild,  uuid[" + (String)localObject2 + "]strFileName[" + String.valueOf(localObject3) + "]errorCode[" + String.valueOf(paramObject) + "],retMsg[" + (String)localObject1 + "],bOffline[" + String.valueOf(localObject4) + "]");
        a((String)localObject2, (String)localObject3, paramObject, (String)localObject1, ((Boolean)localObject4).booleanValue());
        return;
      }
      QLog.i("FMObserver<FileAssistant>", 1, "OnDelClouldFileSuccess,  uuid[" + (String)localObject2 + "]strFileName[" + String.valueOf(localObject3) + "],bOffline[" + String.valueOf(localObject4) + "]");
      a((String)localObject2, (String)localObject3, ((Boolean)localObject4).booleanValue());
      return;
    case 41: 
      paramObject = (Long)((Object[])(Object[])paramObject[2])[0];
      QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileProgressDirectDone, nSessionId=" + paramObject);
      a(paramObject.longValue());
      return;
    case 42: 
      paramObject = (Long)((Object[])(Object[])paramObject[2])[0];
      QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileRecvButSenderReplayTimeOut, nSessionId=" + paramObject);
      b(paramObject.longValue());
      return;
    case 43: 
      paramObject = (Long)((Object[])(Object[])paramObject[2])[0];
      QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileQueryUpProgressTimeOut, nSessionId=" + paramObject);
      c(paramObject.longValue());
      return;
    case 44: 
      bool = ((Boolean)paramObject[1]).booleanValue();
      paramObject = (Object[])paramObject[2];
      localObject1 = (Integer)paramObject[0];
      localObject2 = (String)paramObject[1];
      if (!bool)
      {
        QLog.i("FMObserver<FileAssistant>", 1, "OnNeedVerifyPwdFailed");
        b(((Integer)localObject1).intValue(), (String)localObject2);
        return;
      }
      paramObject = (Boolean)paramObject[2];
      QLog.i("FMObserver<FileAssistant>", 1, "OnNeedVerifyPwdSuccess,  need verify[" + paramObject + "]");
      a(paramObject.booleanValue());
      return;
    case 45: 
      bool = ((Boolean)paramObject[1]).booleanValue();
      localObject1 = (Object[])paramObject[2];
      paramObject = (Integer)localObject1[0];
      localObject1 = (String)localObject1[1];
      if (!bool)
      {
        QLog.i("FMObserver<FileAssistant>", 1, "OnVerifyPwdFailed");
        a(paramObject.intValue(), (String)localObject1);
        return;
      }
      QLog.i("FMObserver<FileAssistant>", 1, "OnVerifyPwdSuccess");
      d();
      return;
    case 50: 
      bool = ((Boolean)paramObject[1]).booleanValue();
      paramObject = (FileManagerEntity)((Object[])(Object[])paramObject[2])[0];
      if (bool)
      {
        localObject1 = new ThumbnailInfo();
        ((ThumbnailInfo)localObject1).jdField_a_of_type_JavaLangObject = paramObject;
        ((ThumbnailInfo)localObject1).b = paramObject.strThumbPath;
        a((ThumbnailInfo)localObject1);
        return;
      }
      localObject1 = new ThumbnailInfo();
      ((ThumbnailInfo)localObject1).jdField_a_of_type_JavaLangObject = paramObject;
      ((ThumbnailInfo)localObject1).jdField_a_of_type_JavaLangString = paramObject.Uuid;
      ((ThumbnailInfo)localObject1).b = null;
      a((ThumbnailInfo)localObject1);
      return;
    case 191: 
      label2960:
      bool = ((Boolean)paramObject[1]).booleanValue();
      paramObject = (Object[])paramObject[2];
      i = ((Integer)paramObject[0]).intValue();
      localObject1 = (String)paramObject[1];
      localObject2 = (String)paramObject[2];
      localObject3 = (String)paramObject[3];
      localObject4 = (String)paramObject[4];
      j = ((Integer)paramObject[5]).intValue();
      str = (String)paramObject[6];
      l1 = ((Long)paramObject[7]).longValue();
      QLog.i("FMObserver<FileAssistant>", 1, "OnGetOfflineVideoThumbInfo retCode[" + String.valueOf(i) + "],retMsg[" + (String)localObject1 + "], " + "downloadKey[" + (String)localObject2 + "], downloadIp[" + (String)localObject3 + "], downloadDomain[" + (String)localObject4 + "], port[" + String.valueOf(j) + "]");
      a(bool, i, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, j, str, l1);
      return;
    }
    boolean bool = ((Boolean)paramObject[1]).booleanValue();
    paramObject = (Object[])paramObject[2];
    i = ((Integer)paramObject[0]).intValue();
    Object localObject1 = (String)paramObject[1];
    Object localObject2 = (String)paramObject[2];
    Object localObject3 = (String)paramObject[3];
    Object localObject4 = (String)paramObject[4];
    int j = ((Integer)paramObject[5]).intValue();
    String str = (String)paramObject[6];
    long l1 = ((Long)paramObject[7]).longValue();
    QLog.i("FMObserver<FileAssistant>", 1, "OnGetDiscVideoThumbInfo retCode[" + String.valueOf(i) + "],retMsg[" + (String)localObject1 + "], " + "downloadKey[" + (String)localObject2 + "], downloadIp[" + (String)localObject3 + "], downloadDomain[" + (String)localObject4 + "], port[" + String.valueOf(j) + "]");
    b(bool, i, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, j, str, l1);
  }
  
  protected void a() {}
  
  protected void a(int paramInt, long paramLong, String paramString) {}
  
  protected void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, String paramString1, String paramString2) {}
  
  protected void a(long paramLong) {}
  
  protected void a(long paramLong, int paramInt, String paramString) {}
  
  public void a(long paramLong1, long paramLong2) {}
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt) {}
  
  protected void a(long paramLong1, String paramString, int paramInt, long paramLong2) {}
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2) {}
  
  public void a(ThumbnailInfo paramThumbnailInfo) {}
  
  protected void a(Boolean paramBoolean, List paramList) {}
  
  protected void a(Integer paramInteger, long paramLong, String paramString) {}
  
  protected void a(Integer paramInteger, String paramString) {}
  
  protected void a(String paramString) {}
  
  public void a(String paramString1, String paramString2, Integer paramInteger, String paramString3, boolean paramBoolean) {}
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean) {}
  
  protected void a(String paramString, boolean paramBoolean, int paramInt1, long paramLong, List paramList, int paramInt2) {}
  
  protected void a(List paramList) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5, long paramLong) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  protected void b() {}
  
  protected void b(int paramInt, String paramString) {}
  
  protected void b(long paramLong) {}
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt) {}
  
  protected void b(Integer paramInteger, String paramString) {}
  
  protected void b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5) {}
  
  protected void b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5, long paramLong) {}
  
  protected void c() {}
  
  protected void c(int paramInt, String paramString) {}
  
  protected void c(long paramLong) {}
  
  protected void d() {}
  
  protected void d(int paramInt, String paramString) {}
  
  public void e() {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      new Handler(paramObservable).post(new dob(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FMObserver
 * JD-Core Version:    0.7.0.1
 */