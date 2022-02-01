import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.app.FMObserver.1;
import com.tencent.mobileqq.filemanager.app.FMObserver.2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class aghq
  implements Observer
{
  private void A(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)localObject[0]).intValue();
    paramArrayOfObject = (String)localObject[1];
    String str1 = (String)localObject[2];
    String str2 = (String)localObject[3];
    String str3 = (String)localObject[4];
    String str4 = (String)localObject[5];
    int j = ((Integer)localObject[6]).intValue();
    String str5 = (String)localObject[7];
    long l = ((Long)localObject[8]).longValue();
    localObject = (Bundle)localObject[9];
    QLog.i("FMObserver<FileAssistant>", 1, "OnGetOfflineVideoThumbInfo retCode[" + String.valueOf(i) + "],retMsg[" + paramArrayOfObject + "], downloadKey[" + str2 + "], downloadIp[" + str3 + "], downloadDomain[" + str4 + "], port[" + String.valueOf(j) + "]");
    a(bool, i, paramArrayOfObject, str1, str2, str3, str4, j, str5, l, (Bundle)localObject);
  }
  
  private void B(Object[] paramArrayOfObject)
  {
    ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    paramArrayOfObject = (FileManagerEntity)localObject[0];
    int i = ((Integer)localObject[1]).intValue();
    localObject = new agnk();
    ((agnk)localObject).context = paramArrayOfObject;
    ((agnk)localObject).fileId = paramArrayOfObject.Uuid;
    ((agnk)localObject).filePath = null;
    ((agnk)localObject).nSessionId = paramArrayOfObject.nSessionId;
    a((agnk)localObject, i);
  }
  
  private void C(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    paramArrayOfObject = (FileManagerEntity)localObject[0];
    if (localObject.length > 1) {}
    for (int i = ((Integer)localObject[1]).intValue();; i = 0)
    {
      if (bool)
      {
        localObject = new agnk();
        ((agnk)localObject).context = paramArrayOfObject;
        ((agnk)localObject).fileId = paramArrayOfObject.Uuid;
        ((agnk)localObject).thumbSize = i;
        if (i == 7) {
          ((agnk)localObject).filePath = paramArrayOfObject.strLargeThumPath;
        }
        for (;;)
        {
          ((agnk)localObject).nSessionId = paramArrayOfObject.nSessionId;
          a((agnk)localObject);
          return;
          if (i == 5) {
            ((agnk)localObject).filePath = paramArrayOfObject.strMiddleThumPath;
          } else {
            ((agnk)localObject).filePath = paramArrayOfObject.strThumbPath;
          }
        }
      }
      localObject = new agnk();
      ((agnk)localObject).context = paramArrayOfObject;
      ((agnk)localObject).fileId = paramArrayOfObject.Uuid;
      ((agnk)localObject).filePath = null;
      ((agnk)localObject).thumbSize = i;
      ((agnk)localObject).nSessionId = paramArrayOfObject.nSessionId;
      a((agnk)localObject);
      return;
    }
  }
  
  private void D(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    paramArrayOfObject = (Integer)localObject[0];
    localObject = (String)localObject[1];
    if (!bool)
    {
      QLog.i("FMObserver<FileAssistant>", 1, "OnVerifyPwdFailed");
      cp(paramArrayOfObject.intValue(), (String)localObject);
      return;
    }
    QLog.i("FMObserver<FileAssistant>", 1, "OnVerifyPwdSuccess");
    dfC();
  }
  
  private void E(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    paramArrayOfObject = (Object[])paramArrayOfObject[2];
    Integer localInteger = (Integer)paramArrayOfObject[0];
    String str = (String)paramArrayOfObject[1];
    if (!bool)
    {
      QLog.i("FMObserver<FileAssistant>", 1, "OnNeedVerifyPwdFailed");
      bd(localInteger.intValue(), str);
      return;
    }
    paramArrayOfObject = (Boolean)paramArrayOfObject[2];
    QLog.i("FMObserver<FileAssistant>", 1, "OnNeedVerifyPwdSuccess,  need verify[" + paramArrayOfObject + "]");
    wG(paramArrayOfObject.booleanValue());
  }
  
  private void F(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    paramArrayOfObject = (Integer)localObject[0];
    String str1 = (String)localObject[1];
    String str2 = (String)localObject[2];
    String str3 = (String)localObject[3];
    localObject = (Boolean)localObject[4];
    if (!bool)
    {
      QLog.i("FMObserver<FileAssistant>", 1, "OnDelClouldFileFaild,  uuid[" + str2 + "]strFileName[" + String.valueOf(str3) + "]errorCode[" + String.valueOf(paramArrayOfObject) + "],retMsg[" + str1 + "],bOffline[" + String.valueOf(localObject) + "]");
      a(str2, str3, paramArrayOfObject, str1, ((Boolean)localObject).booleanValue());
      return;
    }
    QLog.i("FMObserver<FileAssistant>", 1, "OnDelClouldFileSuccess,  uuid[" + str2 + "]strFileName[" + String.valueOf(str3) + "],bOffline[" + String.valueOf(localObject) + "]");
    K(str2, str3, ((Boolean)localObject).booleanValue());
  }
  
  private void G(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    paramArrayOfObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    String str1 = (String)paramArrayOfObject[1];
    long l1 = ((Long)paramArrayOfObject[2]).longValue();
    long l2 = ((Long)paramArrayOfObject[3]).longValue();
    String str2 = (String)paramArrayOfObject[4];
    long l3 = ((Long)paramArrayOfObject[5]).longValue();
    QLog.i("FMObserver<FileAssistant>", 1, "OnForwardOfflineFile, bSuccess[" + String.valueOf(bool) + "], retCode[" + String.valueOf(i) + "], retMsg[" + String.valueOf(str1) + "], totalSpace[" + String.valueOf(l1) + "], usedSpace[" + String.valueOf(l2) + "], strUuid[" + String.valueOf(str2) + "], nSessionId[" + String.valueOf(l3) + "]");
    a(bool, i, str1, l1, l2, str2, l3);
  }
  
  private void H(Object[] paramArrayOfObject)
  {
    try
    {
      bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
      if (bool) {
        bJj();
      }
      return;
    }
    catch (Exception paramArrayOfObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FMObserver<FileAssistant>", 1, "OnRefreshList param error!");
        }
        boolean bool = false;
      }
    }
  }
  
  private void I(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    switch (i)
    {
    default: 
      QLog.e("FMObserver<FileAssistant>", 1, "OnUpdate : Status[" + i + "] not processed");
      return;
    case 17: 
      W(paramObject);
      return;
    case 0: 
      bJi();
      return;
    case 25: 
      bJk();
      return;
    case 10: 
    case 13: 
      V(paramObject);
      return;
    case 16: 
      U(paramObject);
      return;
    case 11: 
    case 14: 
    case 35: 
    case 37: 
      T(paramObject);
      return;
    case 1: 
    case 12: 
    case 15: 
    case 36: 
    case 38: 
      S(paramObject);
      return;
    case 22: 
      onCompleted(paramObject[2]);
      return;
    case 4: 
      R(paramObject);
      return;
    case 18: 
      Q(paramObject);
      return;
    case 21: 
      P(paramObject);
      return;
    case 278: 
      O(paramObject);
      return;
    case 31: 
      N(paramObject);
      return;
    case 32: 
      M(paramObject);
      return;
    case 33: 
      L(paramObject);
      return;
    case 46: 
      K(paramObject);
      return;
    case 34: 
      J(paramObject);
      return;
    case 39: 
      I(paramObject);
      return;
    case 3: 
      H(paramObject);
      return;
    case 19: 
      G(paramObject);
      return;
    case 20: 
      F(paramObject);
      return;
    case 41: 
      bn(paramObject[2]);
      return;
    case 42: 
      bm(paramObject[2]);
      return;
    case 43: 
      bl(paramObject[2]);
      return;
    case 44: 
      E(paramObject);
      return;
    case 45: 
      D(paramObject);
      return;
    case 50: 
    case 51: 
      C(paramObject);
      return;
    case 52: 
      B(paramObject);
      return;
    case 191: 
      A(paramObject);
      return;
    case 192: 
      z(paramObject);
      return;
    }
    y(paramObject);
  }
  
  private void I(Object[] paramArrayOfObject)
  {
    if (((Boolean)paramArrayOfObject[1]).booleanValue())
    {
      paramArrayOfObject = (Object[])paramArrayOfObject[2];
      localObject = new agnk();
      ((agnk)localObject).fileId = ((String)paramArrayOfObject[0]);
      ((agnk)localObject).type = ((Integer)paramArrayOfObject[1]).intValue();
      ((agnk)localObject).filePath = ((String)paramArrayOfObject[2]);
      ((agnk)localObject).context = paramArrayOfObject[3];
      QLog.i("FMObserver<FileAssistant>", 1, "OnThumbDownLoadSuccess,fileId[" + ((agnk)localObject).fileId + "],filePath[" + ((agnk)localObject).filePath + "]");
      if ((((agnk)localObject).context != null) && (((agnk)localObject).filePath != null) && (((agnk)localObject).filePath.length() > 0))
      {
        if (!(((agnk)localObject).context instanceof WeiYunFileInfo)) {
          break label171;
        }
        ((WeiYunFileInfo)((agnk)localObject).context).bIz = ((agnk)localObject).filePath;
      }
      for (;;)
      {
        a((agnk)localObject);
        return;
        label171:
        if ((((agnk)localObject).context instanceof OfflineFileInfo)) {
          ((OfflineFileInfo)((agnk)localObject).context).bIz = ((agnk)localObject).filePath;
        } else if ((((agnk)localObject).context instanceof FileManagerEntity)) {
          ((FileManagerEntity)((agnk)localObject).context).strThumbPath = ((agnk)localObject).filePath;
        }
      }
    }
    Object localObject = (Object[])paramArrayOfObject[2];
    String str = (String)localObject[0];
    paramArrayOfObject = new agnk();
    paramArrayOfObject.filePath = null;
    paramArrayOfObject.fileId = str;
    paramArrayOfObject.context = localObject[1];
    localObject = new Handler();
    QLog.i("FMObserver<FileAssistant>", 1, "OnThumbDownLoadSuccess(faild),fileId[" + paramArrayOfObject.fileId + "],delay 1000ms");
    ((Handler)localObject).postDelayed(new FMObserver.2(this, paramArrayOfObject), 1000L);
  }
  
  private void J(Object[] paramArrayOfObject)
  {
    if (((Boolean)paramArrayOfObject[1]).booleanValue())
    {
      paramArrayOfObject = (Object[])paramArrayOfObject[2];
      i = ((Integer)paramArrayOfObject[0]).intValue();
      str1 = (String)paramArrayOfObject[1];
      str2 = (String)paramArrayOfObject[2];
      l = ((Long)paramArrayOfObject[3]).longValue();
      if (QLog.isColorLevel()) {
        QLog.d("FMObserver<FileAssistant>", 2, "OnOfflineSendToWeiYunSuccess, nSessionId[" + String.valueOf(l) + "]");
      }
      b(l, str2, i, str1);
      return;
    }
    paramArrayOfObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    String str1 = (String)paramArrayOfObject[1];
    String str2 = (String)paramArrayOfObject[2];
    long l = ((Long)paramArrayOfObject[3]).longValue();
    QLog.e("FMObserver<FileAssistant>", 1, "OnWeiYunSendToOfflineFaild, , nSessionId[" + String.valueOf(l) + "], errorCode[" + String.valueOf(i) + "], strErrMsg[" + String.valueOf(str1) + "]");
    e(i, l, str1);
  }
  
  private void K(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    paramArrayOfObject = (Object[])paramArrayOfObject[2];
    a(((Long)paramArrayOfObject[0]).longValue(), bool, ((Integer)paramArrayOfObject[1]).intValue(), (String)paramArrayOfObject[2]);
  }
  
  private void L(Object[] paramArrayOfObject)
  {
    if (((Boolean)paramArrayOfObject[1]).booleanValue())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FMObserver<FileAssistant>", 2, "OnWeiYunSendToOfflineSuccess");
      }
      bJl();
      return;
    }
    paramArrayOfObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    String str = (String)paramArrayOfObject[1];
    long l = ((Long)paramArrayOfObject[2]).longValue();
    QLog.e("FMObserver<FileAssistant>", 1, "OnWeiYunSendToOfflineFaild, , nSessionId[" + String.valueOf(l) + "], errorCode[" + String.valueOf(i) + "], strErrMsg[" + String.valueOf(str) + "]");
    a(Integer.valueOf(i), l, str);
  }
  
  private void M(Object[] paramArrayOfObject)
  {
    boolean bool;
    StringBuilder localStringBuilder;
    if (((Boolean)paramArrayOfObject[1]).booleanValue())
    {
      paramArrayOfObject = (Object[])paramArrayOfObject[2];
      bool = ((Boolean)paramArrayOfObject[0]).booleanValue();
      paramArrayOfObject = (List)paramArrayOfObject[1];
      localStringBuilder = new StringBuilder().append("OnWeiYunOfflineListSucess, , isEnd[").append(String.valueOf(bool)).append("], List<OfflineFileInfo> size[");
      if (paramArrayOfObject == null) {
        break label111;
      }
    }
    label111:
    for (int i = paramArrayOfObject.size();; i = 0)
    {
      QLog.i("FMObserver<FileAssistant>", 1, String.valueOf(i) + "]");
      b(Boolean.valueOf(bool), paramArrayOfObject);
      return;
    }
  }
  
  private void N(Object[] paramArrayOfObject)
  {
    if (((Boolean)paramArrayOfObject[1]).booleanValue())
    {
      Object localObject2 = (Object[])paramArrayOfObject[2];
      paramArrayOfObject = (String)localObject2[0];
      boolean bool = ((Boolean)localObject2[1]).booleanValue();
      int j = ((Integer)localObject2[2]).intValue();
      localObject1 = (String)localObject2[3];
      List localList = (List)localObject2[4];
      int k = ((Integer)localObject2[5]).intValue();
      localObject2 = new StringBuilder().append("OnWeiYunOneClassificationInfoSuccess, categoryId[").append(paramArrayOfObject).append("], isEnd[").append(String.valueOf(bool)).append("], count[").append(String.valueOf(j)).append("], localVersion[").append((String)localObject1).append("], List<WeiYunFileInfo> size[");
      if (localList != null) {}
      for (i = localList.size();; i = 0)
      {
        QLog.i("FMObserver<FileAssistant>", 1, String.valueOf(i) + "], index[" + String.valueOf(k) + "]");
        a(paramArrayOfObject, bool, j, (String)localObject1, localList, k);
        return;
      }
    }
    Object localObject1 = (Object[])paramArrayOfObject[2];
    int i = ((Integer)localObject1[0]).intValue();
    paramArrayOfObject = (String)localObject1[1];
    localObject1 = (String)localObject1[2];
    QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunOneClassificationInfoFaild, , errorCode[" + String.valueOf(i) + "], strErrMsg[" + String.valueOf(paramArrayOfObject) + "], strCategoryId[" + String.valueOf(localObject1) + "]");
    L(i, paramArrayOfObject, (String)localObject1);
  }
  
  private void O(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object[] arrayOfObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)arrayOfObject[0]).intValue();
    String str1 = (String)arrayOfObject[1];
    String str2 = (String)arrayOfObject[2];
    String str3 = (String)arrayOfObject[3];
    String str4 = (String)arrayOfObject[4];
    String str5 = (String)arrayOfObject[5];
    int j = ((Integer)arrayOfObject[6]).intValue();
    Object localObject = null;
    paramArrayOfObject = localObject;
    if (arrayOfObject.length > 7)
    {
      paramArrayOfObject = localObject;
      if (arrayOfObject[7] != null) {
        paramArrayOfObject = (String)arrayOfObject[7];
      }
    }
    QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunFilePreview retCode[" + String.valueOf(i) + "],retMsg[" + str1 + "], downloadKey[" + str2 + "], downloadIp[" + str4 + "], downloadDomain[" + str5 + "], port[" + String.valueOf(j) + "]");
    a(bool, i, str1, str2, str3, str4, str5, j, paramArrayOfObject);
  }
  
  private void P(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)localObject[0]).intValue();
    paramArrayOfObject = (String)localObject[1];
    String str1 = (String)localObject[2];
    String str2 = (String)localObject[3];
    String str3 = (String)localObject[4];
    String str4 = (String)localObject[5];
    int j = ((Integer)localObject[6]).intValue();
    localObject = (Bundle)localObject[7];
    QLog.i("FMObserver<FileAssistant>", 1, "OnDiscFilePreview retCode[" + String.valueOf(i) + "],retMsg[" + paramArrayOfObject + "], downloadKey[" + str2 + "], downloadIp[" + str3 + "], downloadDomain[" + str4 + "], port[" + String.valueOf(j) + "]");
    a(bool, i, paramArrayOfObject, str1, str2, str3, str4, j, null, (Bundle)localObject);
  }
  
  private void Q(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)localObject[0]).intValue();
    paramArrayOfObject = (String)localObject[1];
    String str1 = (String)localObject[2];
    String str2 = (String)localObject[3];
    String str3 = (String)localObject[4];
    String str4 = (String)localObject[5];
    int j = ((Integer)localObject[6]).intValue();
    localObject = (Bundle)localObject[7];
    QLog.i("FMObserver<FileAssistant>", 1, "OnFileOfflinePreview retCode[" + String.valueOf(i) + "],retMsg[" + paramArrayOfObject + "], downloadKey[" + str2 + "], downloadIp[" + str3 + "], downloadDomain[" + str4 + "], port[" + String.valueOf(j) + "]");
    b(bool, i, str1, paramArrayOfObject, str2, str3, str4, j, null, (Bundle)localObject);
  }
  
  private void R(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    int j = ((Integer)paramArrayOfObject[5]).intValue();
    if (paramArrayOfObject[6] == null) {}
    for (paramArrayOfObject = null;; paramArrayOfObject = (String)paramArrayOfObject[6])
    {
      bJi();
      QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "],errCode[" + String.valueOf(j) + "],errMsg[" + String.valueOf(paramArrayOfObject) + "], peerType[" + String.valueOf(i) + "]");
      cq(j, paramArrayOfObject);
      return;
    }
  }
  
  private void S(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    int j = ((Integer)paramArrayOfObject[5]).intValue();
    if (paramArrayOfObject[6] == null) {}
    for (paramArrayOfObject = null;; paramArrayOfObject = (String)paramArrayOfObject[6])
    {
      bJi();
      QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "],errCode[" + String.valueOf(j) + "],errMsg[" + String.valueOf(paramArrayOfObject) + "], peerType[" + String.valueOf(i) + "]");
      a(false, l1, l2, str, i, j, paramArrayOfObject);
      return;
    }
  }
  
  private void T(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    bJi();
    QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + l1 + "],nSessionId[" + l2 + "], peerType[" + i + "]");
    a(true, l1, l2, str, i, 0, null);
  }
  
  private void U(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    if (((Integer)paramArrayOfObject[5]).intValue() == 14)
    {
      a(false, l1, l2, str, i);
      return;
    }
    a(true, l1, l2, str, i);
  }
  
  private void V(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferStart uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "], strUin[" + ahav.kZ(str) + "], peerType[" + String.valueOf(i) + "]");
    c(l1, l2, str, i);
  }
  
  private void W(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    QLog.i("FMObserver<FileAssistant>", 1, "OnFileCome uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "], strUin[" + ahav.kZ(str) + "], peerType[" + String.valueOf(i) + "]");
    b(l1, l2, str, i);
  }
  
  private void bl(Object paramObject)
  {
    paramObject = (Long)((Object[])(Object[])paramObject)[0];
    QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileQueryUpProgressTimeOut, nSessionId=" + paramObject);
    jj(paramObject.longValue());
  }
  
  private void bm(Object paramObject)
  {
    paramObject = (Long)((Object[])(Object[])paramObject)[0];
    QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileRecvButSenderReplayTimeOut, nSessionId=" + paramObject);
    ji(paramObject.longValue());
  }
  
  private void bn(Object paramObject)
  {
    paramObject = (Long)((Object[])(Object[])paramObject)[0];
    QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileProgressDirectDone, nSessionId=" + paramObject);
    jh(paramObject.longValue());
  }
  
  private void onCompleted(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    Q(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue());
  }
  
  private void y(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    long l = ((Long)localObject[0]).longValue();
    int i = ((Integer)localObject[1]).intValue();
    paramArrayOfObject = (String)localObject[2];
    localObject = (String)localObject[3];
    QLog.i("FMObserver<FileAssistant>", 1, "OnZipImageThumbDownloadCompleted thumbUrl[" + (String)localObject + "]");
    a(bool, i, l, (String)localObject, paramArrayOfObject);
  }
  
  private void z(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)localObject[0]).intValue();
    paramArrayOfObject = (String)localObject[1];
    String str1 = (String)localObject[2];
    String str2 = (String)localObject[3];
    String str3 = (String)localObject[4];
    String str4 = (String)localObject[5];
    int j = ((Integer)localObject[6]).intValue();
    String str5 = (String)localObject[7];
    long l = ((Long)localObject[8]).longValue();
    localObject = (Bundle)localObject[9];
    QLog.i("FMObserver<FileAssistant>", 1, "OnGetDiscVideoThumbInfo retCode[" + String.valueOf(i) + "],retMsg[" + paramArrayOfObject + "], downloadKey[" + str2 + "], downloadIp[" + str3 + "], downloadDomain[" + str4 + "], port[" + String.valueOf(j) + "]");
    b(bool, i, paramArrayOfObject, str1, str2, str3, str4, j, str5, l, (Bundle)localObject);
  }
  
  protected void K(String paramString1, String paramString2, boolean paramBoolean) {}
  
  protected void L(int paramInt, String paramString1, String paramString2) {}
  
  protected void Q(long paramLong1, long paramLong2) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void a(agnk paramagnk) {}
  
  protected void a(agnk paramagnk, int paramInt) {}
  
  protected void a(Integer paramInteger, long paramLong, String paramString) {}
  
  protected void a(String paramString1, String paramString2, Integer paramInteger, String paramString3, boolean paramBoolean) {}
  
  protected void a(String paramString1, boolean paramBoolean, int paramInt1, String paramString2, List<WeiYunFileInfo> paramList, int paramInt2) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, long paramLong, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt) {}
  
  protected void b(long paramLong, String paramString1, int paramInt, String paramString2) {}
  
  protected void b(Boolean paramBoolean, List<OfflineFileInfo> paramList) {}
  
  protected void b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, long paramLong, Bundle paramBundle) {}
  
  protected void b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, Bundle paramBundle) {}
  
  protected void bJi() {}
  
  protected void bJj() {}
  
  protected void bJk() {}
  
  protected void bJl() {}
  
  protected void bd(int paramInt, String paramString) {}
  
  protected void c(long paramLong1, long paramLong2, String paramString, int paramInt) {}
  
  protected void cp(int paramInt, String paramString) {}
  
  protected void cq(int paramInt, String paramString) {}
  
  protected void dfC() {}
  
  protected void e(int paramInt, long paramLong, String paramString) {}
  
  protected void jh(long paramLong) {}
  
  protected void ji(long paramLong) {}
  
  protected void jj(long paramLong) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aghq
 * JD-Core Version:    0.7.0.1
 */