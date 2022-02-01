import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.app.FMObserver.1;
import com.tencent.tim.filemanager.app.FMObserver.2;
import com.weiyun.sdk.IWyFileSystem.Thumbnail;
import com.weiyun.sdk.IWyFileSystem.ThumbnailType;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class atsn
  implements Observer
{
  private void I(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    long l1;
    long l2;
    int j;
    boolean bool;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    String str2;
    String str3;
    label2321:
    Object localObject1;
    switch (i)
    {
    default: 
      QLog.e("FMObserver<FileAssistant>", 1, "OnUpdate : Status[" + i + "] not processed");
    case 17: 
    case 0: 
    case 25: 
    case 10: 
    case 13: 
    case 16: 
    case 11: 
    case 14: 
    case 35: 
    case 37: 
    case 102: 
    case 1: 
    case 12: 
    case 15: 
    case 36: 
    case 38: 
    case 22: 
    case 4: 
    case 18: 
    case 21: 
    case 278: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 101: 
    case 46: 
    case 34: 
    case 39: 
    case 40: 
    case 3: 
      for (;;)
      {
        return;
        l1 = ((Long)paramObject[1]).longValue();
        l2 = ((Long)paramObject[2]).longValue();
        String str1 = (String)paramObject[3];
        i = ((Integer)paramObject[4]).intValue();
        QLog.i("FMObserver<FileAssistant>", 1, "OnFileCome uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "], strUin[" + audx.kZ(str1) + "], peerType[" + String.valueOf(i) + "]");
        b(l1, l2, str1, i);
        return;
        bJi();
        return;
        bJk();
        return;
        l1 = ((Long)paramObject[1]).longValue();
        l2 = ((Long)paramObject[2]).longValue();
        str1 = (String)paramObject[3];
        i = ((Integer)paramObject[4]).intValue();
        QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferStart uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "], strUin[" + audx.kZ(str1) + "], peerType[" + String.valueOf(i) + "]");
        c(l1, l2, str1, i);
        return;
        l1 = ((Long)paramObject[1]).longValue();
        l2 = ((Long)paramObject[2]).longValue();
        str1 = (String)paramObject[3];
        i = ((Integer)paramObject[4]).intValue();
        if (((Integer)paramObject[5]).intValue() == 14)
        {
          a(false, l1, l2, str1, i);
          return;
        }
        a(true, l1, l2, str1, i);
        return;
        l1 = ((Long)paramObject[1]).longValue();
        l2 = ((Long)paramObject[2]).longValue();
        str1 = (String)paramObject[3];
        i = ((Integer)paramObject[4]).intValue();
        bJi();
        QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + l1 + "],nSessionId[" + l2 + "], peerType[" + i + "]");
        a(true, l1, l2, str1, i, 0, null);
        return;
        l1 = ((Long)paramObject[1]).longValue();
        l2 = ((Long)paramObject[2]).longValue();
        str1 = (String)paramObject[3];
        i = ((Integer)paramObject[4]).intValue();
        j = ((Integer)paramObject[5]).intValue();
        if (paramObject[6] == null) {}
        for (paramObject = null;; paramObject = (String)paramObject[6])
        {
          bJi();
          QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "],errCode[" + String.valueOf(j) + "],errMsg[" + String.valueOf(paramObject) + "], peerType[" + String.valueOf(i) + "]");
          a(false, l1, l2, str1, i, j, paramObject);
          return;
        }
        paramObject = (Object[])paramObject[2];
        Q(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue());
        return;
        l1 = ((Long)paramObject[1]).longValue();
        l2 = ((Long)paramObject[2]).longValue();
        str1 = (String)paramObject[3];
        i = ((Integer)paramObject[4]).intValue();
        j = ((Integer)paramObject[5]).intValue();
        if (paramObject[6] == null) {}
        for (paramObject = null;; paramObject = (String)paramObject[6])
        {
          bJi();
          QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "],errCode[" + String.valueOf(j) + "],errMsg[" + String.valueOf(paramObject) + "], peerType[" + String.valueOf(i) + "]");
          cq(j, paramObject);
          return;
        }
        bool = ((Boolean)paramObject[1]).booleanValue();
        Object[] arrayOfObject = (Object[])paramObject[2];
        i = ((Integer)arrayOfObject[0]).intValue();
        localObject2 = (String)arrayOfObject[1];
        localObject3 = (String)arrayOfObject[2];
        localObject4 = (String)arrayOfObject[3];
        str2 = (String)arrayOfObject[4];
        str3 = (String)arrayOfObject[5];
        j = ((Integer)arrayOfObject[6]).intValue();
        str1 = null;
        paramObject = str1;
        if (arrayOfObject.length > 7)
        {
          paramObject = str1;
          if (arrayOfObject[7] != null) {
            paramObject = (String)arrayOfObject[7];
          }
        }
        QLog.i("FMObserver<FileAssistant>", 1, "OnFileOfflinePreview retCode[" + String.valueOf(i) + "],retMsg[" + (String)localObject2 + "], downloadKey[" + (String)localObject4 + "], downloadIp[" + str2 + "], downloadDomain[" + str3 + "], port[" + String.valueOf(j) + "]");
        c(bool, i, (String)localObject3, (String)localObject2, (String)localObject4, str2, str3, j, paramObject);
        return;
        bool = ((Boolean)paramObject[1]).booleanValue();
        arrayOfObject = (Object[])paramObject[2];
        i = ((Integer)arrayOfObject[0]).intValue();
        localObject2 = (String)arrayOfObject[1];
        localObject3 = (String)arrayOfObject[2];
        localObject4 = (String)arrayOfObject[3];
        str2 = (String)arrayOfObject[4];
        str3 = (String)arrayOfObject[5];
        j = ((Integer)arrayOfObject[6]).intValue();
        str1 = null;
        paramObject = str1;
        if (arrayOfObject.length > 7)
        {
          paramObject = str1;
          if (arrayOfObject[7] != null) {
            paramObject = (String)arrayOfObject[7];
          }
        }
        QLog.i("FMObserver<FileAssistant>", 1, "OnDiscFilePreview retCode[" + String.valueOf(i) + "],retMsg[" + (String)localObject2 + "], downloadKey[" + (String)localObject4 + "], downloadIp[" + str2 + "], downloadDomain[" + str3 + "], port[" + String.valueOf(j) + "]");
        b(bool, i, (String)localObject2, (String)localObject3, (String)localObject4, str2, str3, j, paramObject);
        return;
        bool = ((Boolean)paramObject[1]).booleanValue();
        arrayOfObject = (Object[])paramObject[2];
        i = ((Integer)arrayOfObject[0]).intValue();
        localObject2 = (String)arrayOfObject[1];
        localObject3 = (String)arrayOfObject[2];
        localObject4 = (String)arrayOfObject[3];
        str2 = (String)arrayOfObject[4];
        str3 = (String)arrayOfObject[5];
        j = ((Integer)arrayOfObject[6]).intValue();
        str1 = null;
        paramObject = str1;
        if (arrayOfObject.length > 7)
        {
          paramObject = str1;
          if (arrayOfObject[7] != null) {
            paramObject = (String)arrayOfObject[7];
          }
        }
        QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunFilePreview retCode[" + String.valueOf(i) + "],retMsg[" + (String)localObject2 + "], downloadKey[" + (String)localObject3 + "], downloadIp[" + str2 + "], downloadDomain[" + str3 + "], port[" + String.valueOf(j) + "]");
        a(bool, i, (String)localObject2, (String)localObject3, (String)localObject4, str2, str3, j, paramObject);
        return;
        if (((Boolean)paramObject[1]).booleanValue())
        {
          paramObject = (List)paramObject[2];
          if (paramObject == null) {
            QLog.w("FMObserver<FileAssistant>", 1, "OnWeiYunClassificationTypeSuccess, but WeiYunClassificationType is null");
          }
          for (;;)
          {
            nQ(paramObject);
            return;
            QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunClassificationTypeSuccess, WeiYunClassificationType size[" + String.valueOf(paramObject.size()) + "]");
          }
        }
        paramObject = (Object[])paramObject[2];
        i = ((Integer)paramObject[0]).intValue();
        paramObject = (String)paramObject[1];
        QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunOneClassificationInfoFaild, , errorCode[" + String.valueOf(i) + "], strErrMsg[" + String.valueOf(paramObject) + "]");
        ep(i, paramObject);
        return;
        if (((Boolean)paramObject[1]).booleanValue())
        {
          paramObject = (Object[])paramObject[2];
          str1 = (String)paramObject[0];
          bool = ((Boolean)paramObject[1]).booleanValue();
          j = ((Integer)paramObject[2]).intValue();
          for (;;)
          {
            try
            {
              l1 = ((Long)paramObject[3]).longValue();
              localObject2 = (List)paramObject[4];
              int k = ((Integer)paramObject[5]).intValue();
              paramObject = new StringBuilder().append("OnWeiYunOneClassificationInfoSuccess, categoryId[").append(str1).append("], isEnd[").append(String.valueOf(bool)).append("], count[").append(String.valueOf(j)).append("], timestamp[").append(String.valueOf(l1)).append("], List<WeiYunFileInfo> size[");
              if (localObject2 == null) {
                break label2321;
              }
              i = ((List)localObject2).size();
              QLog.i("FMObserver<FileAssistant>", 1, String.valueOf(i) + "], index[" + String.valueOf(k) + "]");
              a(str1, bool, j, l1, (List)localObject2, k);
              return;
            }
            catch (ClassCastException localClassCastException) {}
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("FMObserver<FileAssistant>", 2, "fail to cast to long :" + paramObject[3]);
            return;
            i = 0;
          }
        }
        localObject1 = (Object[])paramObject[2];
        i = ((Integer)localObject1[0]).intValue();
        paramObject = (String)localObject1[1];
        localObject1 = (String)localObject1[2];
        QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunOneClassificationInfoFaild, , errorCode[" + String.valueOf(i) + "], strErrMsg[" + String.valueOf(paramObject) + "], strCategoryId[" + String.valueOf(localObject1) + "]");
        L(i, paramObject, (String)localObject1);
        return;
        if (((Boolean)paramObject[1]).booleanValue())
        {
          paramObject = (Object[])paramObject[2];
          bool = ((Boolean)paramObject[0]).booleanValue();
          paramObject = (List)paramObject[1];
          localObject1 = new StringBuilder().append("OnWeiYunOfflineListSucess, , isEnd[").append(String.valueOf(bool)).append("], List<OfflineFileInfo> size[");
          if (paramObject != null) {}
          for (i = paramObject.size();; i = 0)
          {
            QLog.i("FMObserver<FileAssistant>", 1, String.valueOf(i) + "]");
            b(Boolean.valueOf(bool), paramObject);
            return;
          }
        }
        paramObject = (Object[])paramObject[2];
        i = ((Integer)paramObject[0]).intValue();
        paramObject = (String)paramObject[1];
        QLog.e("FMObserver<FileAssistant>", 1, "OnWeiYunOfflineListFaild, , errorCode[" + String.valueOf(i) + "], strErrMsg[" + String.valueOf(paramObject) + "]");
        b(Integer.valueOf(i), paramObject);
        return;
        if (((Boolean)paramObject[1]).booleanValue())
        {
          if (QLog.isColorLevel()) {
            QLog.d("FMObserver<FileAssistant>", 2, "OnWeiYunSendToOfflineSuccess");
          }
          bJl();
          return;
        }
        paramObject = (Object[])paramObject[2];
        i = ((Integer)paramObject[0]).intValue();
        localObject1 = (String)paramObject[1];
        l1 = ((Long)paramObject[2]).longValue();
        QLog.e("FMObserver<FileAssistant>", 1, "OnWeiYunSendToOfflineFaild, , nSessionId[" + String.valueOf(l1) + "], errorCode[" + String.valueOf(i) + "], strErrMsg[" + String.valueOf(localObject1) + "]");
        a(Integer.valueOf(i), l1, (String)localObject1);
        return;
        if (((Boolean)paramObject[1]).booleanValue())
        {
          if (QLog.isColorLevel()) {
            QLog.d("FMObserver<FileAssistant>", 2, "OnTimCloudSendToOfflineSuccess");
          }
          euv();
          return;
        }
        paramObject = (Object[])paramObject[2];
        i = ((Integer)paramObject[0]).intValue();
        localObject1 = (String)paramObject[1];
        l1 = ((Long)paramObject[2]).longValue();
        QLog.e("FMObserver<FileAssistant>", 1, "OnTimCloudSendToOfflineSuccess, , nSessionId[" + String.valueOf(l1) + "], errorCode[" + String.valueOf(i) + "], strErrMsg[" + String.valueOf(localObject1) + "]");
        b(Integer.valueOf(i), l1, (String)localObject1);
        return;
        bool = ((Boolean)paramObject[1]).booleanValue();
        paramObject = (Object[])paramObject[2];
        a(((Long)paramObject[0]).longValue(), bool, ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
        return;
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
          b(l1, (String)localObject2, i, (String)localObject1);
          return;
        }
        paramObject = (Object[])paramObject[2];
        i = ((Integer)paramObject[0]).intValue();
        localObject1 = (String)paramObject[1];
        localObject2 = (String)paramObject[2];
        l1 = ((Long)paramObject[3]).longValue();
        QLog.e("FMObserver<FileAssistant>", 1, "OnWeiYunSendToOfflineFaild, , nSessionId[" + String.valueOf(l1) + "], errorCode[" + String.valueOf(i) + "], strErrMsg[" + String.valueOf(localObject1) + "]");
        e(i, l1, (String)localObject1);
        return;
        if (((Boolean)paramObject[1]).booleanValue())
        {
          localObject1 = (Object[])paramObject[2];
          paramObject = new atwh();
          localObject1 = (IWyFileSystem.Thumbnail)localObject1[0];
          paramObject.context = ((IWyFileSystem.Thumbnail)localObject1).context;
          paramObject.fileId = ((IWyFileSystem.Thumbnail)localObject1).fileId;
          paramObject.filePath = ((IWyFileSystem.Thumbnail)localObject1).filePath;
          paramObject.type = ((IWyFileSystem.Thumbnail)localObject1).type.ordinal();
          QLog.i("FMObserver<FileAssistant>", 1, "OnThumbDownLoadSuccess,fileId[" + paramObject.fileId + "],filePath[" + paramObject.filePath + "]");
          if ((paramObject.context != null) && (((IWyFileSystem.Thumbnail)localObject1).filePath != null) && (((IWyFileSystem.Thumbnail)localObject1).filePath.length() > 0))
          {
            if (!(paramObject.context instanceof WeiYunFileInfo)) {
              break label3379;
            }
            ((WeiYunFileInfo)((IWyFileSystem.Thumbnail)localObject1).context).bIz = ((IWyFileSystem.Thumbnail)localObject1).filePath;
          }
          for (;;)
          {
            a(paramObject);
            return;
            if ((paramObject.context instanceof OfflineFileInfo)) {
              ((OfflineFileInfo)((IWyFileSystem.Thumbnail)localObject1).context).bIz = ((IWyFileSystem.Thumbnail)localObject1).filePath;
            } else if ((paramObject.context instanceof FileManagerEntity)) {
              ((FileManagerEntity)((IWyFileSystem.Thumbnail)localObject1).context).strThumbPath = ((IWyFileSystem.Thumbnail)localObject1).filePath;
            }
          }
        }
        localObject1 = (Object[])paramObject[2];
        localObject2 = (String)localObject1[0];
        paramObject = new atwh();
        paramObject.filePath = null;
        paramObject.fileId = ((String)localObject2);
        paramObject.context = localObject1[1];
        localObject1 = new Handler();
        QLog.i("FMObserver<FileAssistant>", 1, "OnThumbDownLoadSuccess(faild),fileId[" + paramObject.fileId + "],delay 1000ms");
        ((Handler)localObject1).postDelayed(new FMObserver.2(this, paramObject), 1000L);
        return;
        if (((Boolean)paramObject[1]).booleanValue())
        {
          paramObject = (String)paramObject[2];
          QLog.i("FMObserver<FileAssistant>", 1, "OnGetWeiYunPriviewUrlSuccess,strUrlString[" + paramObject + "]");
          YX(paramObject);
          return;
        }
        paramObject = (Object[])paramObject[2];
        i = ((Integer)paramObject[0]).intValue();
        paramObject = (String)paramObject[1];
        QLog.e("FMObserver<FileAssistant>", 1, "OnGetWeiYunPriviewUrlFaild, , errorCode[" + String.valueOf(i) + "], strErrString[" + String.valueOf(paramObject) + "]");
        c(Integer.valueOf(i), paramObject);
        return;
        try
        {
          bool = ((Boolean)paramObject[1]).booleanValue();
          if (bool)
          {
            bJj();
            return;
          }
        }
        catch (Exception paramObject)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("FMObserver<FileAssistant>", 1, "OnRefreshList param error!");
            }
            bool = false;
          }
        }
      }
    case 19: 
      bool = ((Boolean)paramObject[1]).booleanValue();
      paramObject = (Object[])paramObject[2];
      i = ((Integer)paramObject[0]).intValue();
      localObject1 = (String)paramObject[1];
      l1 = ((Long)paramObject[2]).longValue();
      l2 = ((Long)paramObject[3]).longValue();
      localObject2 = (String)paramObject[4];
      long l3 = ((Long)paramObject[5]).longValue();
      QLog.i("FMObserver<FileAssistant>", 1, "OnForwardOfflineFile, bSuccess[" + String.valueOf(bool) + "], retCode[" + String.valueOf(i) + "], retMsg[" + String.valueOf(localObject1) + "], totalSpace[" + String.valueOf(l1) + "], usedSpace[" + String.valueOf(l2) + "], strUuid[" + String.valueOf(localObject2) + "], nSessionId[" + String.valueOf(l3) + "]");
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
        q(paramObject.longValue(), ((Integer)localObject2).intValue(), (String)localObject3);
        return;
      }
      localObject2 = (String)localObject1[3];
      localObject3 = (Integer)localObject1[4];
      localObject1 = (Long)localObject1[5];
      e(paramObject.longValue(), (String)localObject2, ((Integer)localObject3).intValue(), ((Long)localObject1).longValue());
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
      K((String)localObject2, (String)localObject3, ((Boolean)localObject4).booleanValue());
      return;
    case 41: 
      paramObject = (Long)((Object[])(Object[])paramObject[2])[0];
      QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileProgressDirectDone, nSessionId=" + paramObject);
      jh(paramObject.longValue());
      return;
    case 42: 
      paramObject = (Long)((Object[])(Object[])paramObject[2])[0];
      QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileRecvButSenderReplayTimeOut, nSessionId=" + paramObject);
      ji(paramObject.longValue());
      return;
    case 43: 
      paramObject = (Long)((Object[])(Object[])paramObject[2])[0];
      QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileQueryUpProgressTimeOut, nSessionId=" + paramObject);
      jj(paramObject.longValue());
      return;
    case 44: 
      bool = ((Boolean)paramObject[1]).booleanValue();
      paramObject = (Object[])paramObject[2];
      localObject1 = (Integer)paramObject[0];
      localObject2 = (String)paramObject[1];
      if (!bool)
      {
        QLog.i("FMObserver<FileAssistant>", 1, "OnNeedVerifyPwdFailed");
        bd(((Integer)localObject1).intValue(), (String)localObject2);
        return;
      }
      paramObject = (Boolean)paramObject[2];
      QLog.i("FMObserver<FileAssistant>", 1, "OnNeedVerifyPwdSuccess,  need verify[" + paramObject + "]");
      wG(paramObject.booleanValue());
      return;
    case 45: 
      bool = ((Boolean)paramObject[1]).booleanValue();
      localObject1 = (Object[])paramObject[2];
      paramObject = (Integer)localObject1[0];
      localObject1 = (String)localObject1[1];
      if (!bool)
      {
        QLog.i("FMObserver<FileAssistant>", 1, "OnVerifyPwdFailed");
        cp(paramObject.intValue(), (String)localObject1);
        return;
      }
      QLog.i("FMObserver<FileAssistant>", 1, "OnVerifyPwdSuccess");
      dfC();
      return;
    case 50: 
    case 51: 
      label3379:
      bool = ((Boolean)paramObject[1]).booleanValue();
      localObject1 = (Object[])paramObject[2];
      paramObject = (FileManagerEntity)localObject1[0];
      if (localObject1.length <= 1) {
        break;
      }
    }
    for (i = ((Integer)localObject1[1]).intValue();; i = 0)
    {
      if (bool)
      {
        localObject1 = new atwh();
        ((atwh)localObject1).context = paramObject;
        ((atwh)localObject1).fileId = paramObject.Uuid;
        ((atwh)localObject1).thumbSize = i;
        if (i == 7) {
          ((atwh)localObject1).filePath = paramObject.strLargeThumPath;
        }
        for (;;)
        {
          ((atwh)localObject1).nSessionId = paramObject.nSessionId;
          a((atwh)localObject1);
          return;
          if (i == 5) {
            ((atwh)localObject1).filePath = paramObject.strMiddleThumPath;
          } else {
            ((atwh)localObject1).filePath = paramObject.strThumbPath;
          }
        }
      }
      localObject1 = new atwh();
      ((atwh)localObject1).context = paramObject;
      ((atwh)localObject1).fileId = paramObject.Uuid;
      ((atwh)localObject1).filePath = null;
      ((atwh)localObject1).thumbSize = i;
      ((atwh)localObject1).nSessionId = paramObject.nSessionId;
      a((atwh)localObject1);
      return;
      ((Boolean)paramObject[1]).booleanValue();
      localObject1 = (Object[])paramObject[2];
      paramObject = (FileManagerEntity)localObject1[0];
      i = ((Integer)localObject1[1]).intValue();
      localObject1 = new atwh();
      ((atwh)localObject1).context = paramObject;
      ((atwh)localObject1).fileId = paramObject.Uuid;
      ((atwh)localObject1).filePath = null;
      ((atwh)localObject1).nSessionId = paramObject.nSessionId;
      a((atwh)localObject1, i);
      return;
      bool = ((Boolean)paramObject[1]).booleanValue();
      paramObject = (Object[])paramObject[2];
      i = ((Integer)paramObject[0]).intValue();
      localObject1 = (String)paramObject[1];
      localObject2 = (String)paramObject[2];
      localObject3 = (String)paramObject[3];
      localObject4 = (String)paramObject[4];
      str2 = (String)paramObject[5];
      j = ((Integer)paramObject[6]).intValue();
      str3 = (String)paramObject[7];
      l1 = ((Long)paramObject[8]).longValue();
      QLog.i("FMObserver<FileAssistant>", 1, "OnGetOfflineVideoThumbInfo retCode[" + String.valueOf(i) + "],retMsg[" + (String)localObject1 + "], downloadKey[" + (String)localObject3 + "], downloadIp[" + (String)localObject4 + "], downloadDomain[" + str2 + "], port[" + String.valueOf(j) + "]");
      a(bool, i, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, str2, j, str3, l1);
      return;
      bool = ((Boolean)paramObject[1]).booleanValue();
      paramObject = (Object[])paramObject[2];
      i = ((Integer)paramObject[0]).intValue();
      localObject1 = (String)paramObject[1];
      localObject2 = (String)paramObject[2];
      localObject3 = (String)paramObject[3];
      localObject4 = (String)paramObject[4];
      str2 = (String)paramObject[5];
      j = ((Integer)paramObject[6]).intValue();
      str3 = (String)paramObject[7];
      l1 = ((Long)paramObject[8]).longValue();
      QLog.i("FMObserver<FileAssistant>", 1, "OnGetDiscVideoThumbInfo retCode[" + String.valueOf(i) + "],retMsg[" + (String)localObject1 + "], downloadKey[" + (String)localObject3 + "], downloadIp[" + (String)localObject4 + "], downloadDomain[" + str2 + "], port[" + String.valueOf(j) + "]");
      b(bool, i, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, str2, j, str3, l1);
      return;
      bool = ((Boolean)paramObject[1]).booleanValue();
      localObject1 = (Object[])paramObject[2];
      l1 = ((Long)localObject1[0]).longValue();
      i = ((Integer)localObject1[1]).intValue();
      paramObject = (String)localObject1[2];
      localObject1 = (String)localObject1[3];
      QLog.i("FMObserver<FileAssistant>", 1, "OnZipImageThumbDownloadCompleted thumbUrl[" + (String)localObject1 + "]");
      a(bool, i, l1, (String)localObject1, paramObject);
      return;
    }
  }
  
  protected void K(String paramString1, String paramString2, boolean paramBoolean) {}
  
  protected void L(int paramInt, String paramString1, String paramString2) {}
  
  protected void Q(long paramLong1, long paramLong2) {}
  
  protected void YX(String paramString) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void a(atwh paramatwh) {}
  
  protected void a(atwh paramatwh, int paramInt) {}
  
  protected void a(Integer paramInteger, long paramLong, String paramString) {}
  
  protected void a(String paramString1, String paramString2, Integer paramInteger, String paramString3, boolean paramBoolean) {}
  
  protected void a(String paramString, boolean paramBoolean, int paramInt1, long paramLong, List<WeiYunFileInfo> paramList, int paramInt2) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, long paramLong) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt) {}
  
  protected void b(long paramLong, String paramString1, int paramInt, String paramString2) {}
  
  protected void b(Boolean paramBoolean, List<OfflineFileInfo> paramList) {}
  
  protected void b(Integer paramInteger, long paramLong, String paramString) {}
  
  protected void b(Integer paramInteger, String paramString) {}
  
  protected void b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6) {}
  
  protected void b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, long paramLong) {}
  
  protected void bJi() {}
  
  protected void bJj() {}
  
  protected void bJk() {}
  
  protected void bJl() {}
  
  protected void bd(int paramInt, String paramString) {}
  
  protected void c(long paramLong1, long paramLong2, String paramString, int paramInt) {}
  
  protected void c(Integer paramInteger, String paramString) {}
  
  protected void c(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6) {}
  
  protected void cp(int paramInt, String paramString) {}
  
  protected void cq(int paramInt, String paramString) {}
  
  protected void dfC() {}
  
  protected void e(int paramInt, long paramLong, String paramString) {}
  
  protected void e(long paramLong1, String paramString, int paramInt, long paramLong2) {}
  
  protected void ep(int paramInt, String paramString) {}
  
  protected void euv() {}
  
  protected void jh(long paramLong) {}
  
  protected void ji(long paramLong) {}
  
  protected void jj(long paramLong) {}
  
  protected void nQ(List<Object> paramList) {}
  
  protected void q(long paramLong, int paramInt, String paramString) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      new Handler(paramObservable).post(new FMObserver.1(this, paramObject));
      return;
    }
    I(paramObject);
  }
  
  protected void wG(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atsn
 * JD-Core Version:    0.7.0.1
 */