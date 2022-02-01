import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.file.DeviceProto.MsgFileKey;
import com.tencent.device.msg.data.DevSingleStructMsgProcessor.1;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct.a;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.oidb.device.MiniFileProto.MiniFile;

public class szv
  extends szg
{
  private final QQAppInterface app;
  private ConcurrentHashMap<Long, szv.b> cB = new ConcurrentHashMap(20);
  private ConcurrentHashMap<Long, Long> cC = new ConcurrentHashMap(10);
  private ArrayList<szv.a> mCallbacks = new ArrayList();
  
  public szv(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private void a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    int i = 0;
    if (i < this.mCallbacks.size())
    {
      Object localObject = (szv.a)this.mCallbacks.get(i);
      View localView = ((szv.a)localObject).getView();
      localObject = ((szv.a)localObject).a();
      if ((localView != null) && (localObject != null)) {
        ((MessageForDeviceSingleStruct.a)localObject).a(localView, paramMessageForDeviceSingleStruct);
      }
      for (;;)
      {
        i += 1;
        break;
        this.mCallbacks.remove(i);
        i -= 1;
      }
    }
  }
  
  private void b(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    if (!this.cB.containsKey(Long.valueOf(paramLong1)))
    {
      paramString = new szv.b(paramString, paramInt, paramLong2);
      this.cB.put(Long.valueOf(paramLong1), paramString);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("DevSingleStructMsgProcessor", 2, "found resume");
  }
  
  public long a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    long l1;
    if ((paramMessageForDeviceSingleStruct == null) || (TextUtils.isEmpty(paramMessageForDeviceSingleStruct.strMediaKey)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevSingleStructMsgProcessor", 2, "mr is null or strMediaKey is empty in downloadMediaFile!");
      }
      l1 = 0L;
      return l1;
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      paramMessageForDeviceSingleStruct = Looper.getMainLooper();
      if (Thread.currentThread() == paramMessageForDeviceSingleStruct.getThread()) {
        ahao.OS(2131695432);
      }
      for (;;)
      {
        return 0L;
        new Handler(paramMessageForDeviceSingleStruct).post(new DevSingleStructMsgProcessor.1(this));
      }
    }
    if (this.cB.containsKey(Long.valueOf(paramMessageForDeviceSingleStruct.nMediaSessionID))) {
      return paramMessageForDeviceSingleStruct.nMediaSessionID;
    }
    Object localObject = (DeviceFileHandler)this.app.getBusinessHandler(50);
    int i = 0;
    switch (paramMessageForDeviceSingleStruct.nDataType)
    {
    }
    for (;;)
    {
      long l2 = ((DeviceFileHandler)localObject).a(this.app, paramMessageForDeviceSingleStruct.strMediaKey, paramMessageForDeviceSingleStruct.strFileKey2, paramMessageForDeviceSingleStruct.nMediaChannelType, i);
      localObject = this.app.b().a(paramMessageForDeviceSingleStruct.frienduin, paramMessageForDeviceSingleStruct.istroop, paramMessageForDeviceSingleStruct.uniseq);
      if ((localObject instanceof MessageForDeviceSingleStruct)) {
        ((MessageForDeviceSingleStruct)localObject).nMediaSessionID = l2;
      }
      paramMessageForDeviceSingleStruct.nMediaSessionID = l2;
      l1 = l2;
      if (l2 == 0L) {
        break;
      }
      b(l2, paramMessageForDeviceSingleStruct.frienduin, paramMessageForDeviceSingleStruct.istroop, paramMessageForDeviceSingleStruct.uniseq);
      return l2;
      i = 2154;
      continue;
      i = 2201;
    }
  }
  
  public long a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct, View paramView, MessageForDeviceSingleStruct.a parama)
  {
    long l1;
    if ((paramMessageForDeviceSingleStruct == null) || (TextUtils.isEmpty(paramMessageForDeviceSingleStruct.strCoverKey)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevSingleStructMsgProcessor", 2, "mr is null or strCoverKey is empty in downloadCoverFile!");
      }
      l1 = 0L;
      return l1;
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {
      return 0L;
    }
    if (paramView != null)
    {
      Iterator localIterator = this.mCallbacks.iterator();
      while (localIterator.hasNext())
      {
        szv.a locala = (szv.a)localIterator.next();
        if (locala.getView() == paramView) {
          locala.callback = new WeakReference(parama);
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.mCallbacks.add(new szv.a(paramView, parama));
      }
      if (this.cB.containsKey(Long.valueOf(paramMessageForDeviceSingleStruct.nCoverSessionID))) {
        return paramMessageForDeviceSingleStruct.nCoverSessionID;
      }
      if (this.cC.containsKey(Long.valueOf(paramMessageForDeviceSingleStruct.uniseq)))
      {
        l1 = ((Long)this.cC.get(Long.valueOf(paramMessageForDeviceSingleStruct.uniseq))).longValue();
        if (anaz.gQ() - l1 < 3600L) {
          return paramMessageForDeviceSingleStruct.nCoverSessionID;
        }
      }
      long l2 = ((DeviceFileHandler)this.app.getBusinessHandler(50)).a(this.app, paramMessageForDeviceSingleStruct.strCoverKey, paramMessageForDeviceSingleStruct.strCoverKey2, paramMessageForDeviceSingleStruct.nCoverChannelType, 2154);
      paramView = this.app.b().a(paramMessageForDeviceSingleStruct.frienduin, paramMessageForDeviceSingleStruct.istroop, paramMessageForDeviceSingleStruct.uniseq);
      if ((paramView instanceof MessageForDeviceSingleStruct)) {
        ((MessageForDeviceSingleStruct)paramView).nCoverSessionID = l2;
      }
      paramMessageForDeviceSingleStruct.nCoverSessionID = l2;
      l1 = l2;
      if (l2 == 0L) {
        break;
      }
      b(l2, paramMessageForDeviceSingleStruct.frienduin, paramMessageForDeviceSingleStruct.istroop, paramMessageForDeviceSingleStruct.uniseq);
      return l2;
    }
  }
  
  public MessageForDeviceSingleStruct a(Long paramLong)
  {
    paramLong = (szv.b)this.cB.get(paramLong);
    if (paramLong == null) {
      return null;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      paramLong = ((QQAppInterface)localAppRuntime).b().a(paramLong.mPeerUin, paramLong.mUinType, paramLong.mUniseq);
      if (paramLong == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DevSingleStructMsgProcessor", 2, "device file msg null");
        }
        return null;
      }
      if ((paramLong instanceof MessageForDeviceSingleStruct)) {
        return (MessageForDeviceSingleStruct)paramLong;
      }
    }
    return null;
  }
  
  public void a(Session paramSession, float paramFloat)
  {
    MessageForDeviceSingleStruct localMessageForDeviceSingleStruct;
    if (!paramSession.bSend)
    {
      localMessageForDeviceSingleStruct = a(Long.valueOf(paramSession.uSessionID));
      if (localMessageForDeviceSingleStruct != null) {
        break label24;
      }
    }
    label24:
    do
    {
      do
      {
        return;
      } while (localMessageForDeviceSingleStruct.nMediaSessionID != paramSession.uSessionID);
      localMessageForDeviceSingleStruct.nMediaFileStatus = 3;
      localMessageForDeviceSingleStruct.nMediaProgress = paramFloat;
    } while (localMessageForDeviceSingleStruct.nMediaFileSize != 0L);
    localMessageForDeviceSingleStruct.nMediaFileSize = paramSession.uFileSizeSrc;
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    MessageForDeviceSingleStruct localMessageForDeviceSingleStruct;
    if (!paramSession.bSend)
    {
      localMessageForDeviceSingleStruct = a(Long.valueOf(paramSession.uSessionID));
      if (localMessageForDeviceSingleStruct != null) {
        break label24;
      }
    }
    label24:
    label298:
    do
    {
      return;
      if (localMessageForDeviceSingleStruct.nCoverSessionID == paramSession.uSessionID)
      {
        localMessageForDeviceSingleStruct.strCoverPath = paramSession.strFilePathSrc;
        if (paramBoolean) {
          this.cC.remove(Long.valueOf(localMessageForDeviceSingleStruct.uniseq));
        }
      }
      for (;;)
      {
        localMessageForDeviceSingleStruct.serial();
        this.app.b().c(localMessageForDeviceSingleStruct.frienduin, 9501, localMessageForDeviceSingleStruct.uniseq, localMessageForDeviceSingleStruct.msgData);
        if ((localMessageForDeviceSingleStruct.nCoverSessionID == paramSession.uSessionID) && (paramBoolean)) {
          a(localMessageForDeviceSingleStruct);
        }
        if ((localMessageForDeviceSingleStruct.nMediaSessionID == paramSession.uSessionID) && (paramBoolean)) {
          a(localMessageForDeviceSingleStruct);
        }
        this.cB.remove(Long.valueOf(paramSession.uSessionID));
        return;
        this.cC.put(Long.valueOf(localMessageForDeviceSingleStruct.uniseq), Long.valueOf(anaz.gQ()));
        continue;
        if (localMessageForDeviceSingleStruct.nMediaSessionID != paramSession.uSessionID) {
          break;
        }
        localMessageForDeviceSingleStruct.strMediaPath = paramSession.strFilePathSrc;
        localMessageForDeviceSingleStruct.nMediaProgress = 1.0F;
        if (paramBoolean) {}
        for (localMessageForDeviceSingleStruct.nMediaFileStatus = 5;; localMessageForDeviceSingleStruct.nMediaFileStatus = 6)
        {
          for (;;)
          {
            if (!TextUtils.isEmpty(localMessageForDeviceSingleStruct.strCoverKey)) {
              break label298;
            }
            localMessageForDeviceSingleStruct.strCoverPath = paramSession.strFilePathSrc;
            try
            {
              localMessageForDeviceSingleStruct.strCoverMD5 = new BigInteger(1, paramSession.vFileMD5Src).toString(16);
            }
            catch (Exception localException) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("DevSingleStructMsgProcessor", 2, "error get file md5 in : onServiceSessionComplete" + localException.getMessage());
          break;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("DevSingleStructMsgProcessor", 2, "error:can not find session id in message record");
  }
  
  public boolean a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    return this.cB.containsKey(Long.valueOf(paramMessageForDeviceSingleStruct.nMediaSessionID));
  }
  
  public String b(DataPoint paramDataPoint)
  {
    int i = 3;
    MessageForDeviceSingleStruct localMessageForDeviceSingleStruct = (MessageForDeviceSingleStruct)anbi.d(-4502);
    localMessageForDeviceSingleStruct.msgtype = -4502;
    localMessageForDeviceSingleStruct.istroop = 9501;
    localMessageForDeviceSingleStruct.issend = 0;
    localMessageForDeviceSingleStruct.isread = false;
    localMessageForDeviceSingleStruct.selfuin = this.app.getCurrentAccountUin();
    localMessageForDeviceSingleStruct.senderuin = Long.toString(paramDataPoint.mDin);
    localMessageForDeviceSingleStruct.frienduin = Long.toString(paramDataPoint.mDin);
    localMessageForDeviceSingleStruct.nDataType = 1;
    localMessageForDeviceSingleStruct.parseFromJson(paramDataPoint.mValue);
    localMessageForDeviceSingleStruct.msg = localMessageForDeviceSingleStruct.strTitle;
    Object localObject = (DeviceFileHandler)this.app.getBusinessHandler(50);
    DeviceProto.MsgFileKey localMsgFileKey;
    if ((!TextUtils.isEmpty(localMessageForDeviceSingleStruct.strCoverKey)) && (localMessageForDeviceSingleStruct.nCoverChannelType == 1)) {
      localMsgFileKey = ((DeviceFileHandler)localObject).a(localMessageForDeviceSingleStruct.strCoverKey);
    }
    for (;;)
    {
      int j;
      try
      {
        localMessageForDeviceSingleStruct.strCoverMD5 = new BigInteger(1, localMsgFileKey.bytes_file_md5.get().toByteArray()).toString(16);
        if ((TextUtils.isEmpty(localMessageForDeviceSingleStruct.strMediaKey)) || (localMessageForDeviceSingleStruct.nMediaChannelType != 1)) {
          break label522;
        }
        localObject = ((DeviceFileHandler)localObject).a(localMessageForDeviceSingleStruct.strMediaKey);
        if (localObject != null)
        {
          localMessageForDeviceSingleStruct.strMediaFileName = ((DeviceProto.MsgFileKey)localObject).str_file_name.get();
          localMessageForDeviceSingleStruct.nMediaFileSize = ((DeviceProto.MsgFileKey)localObject).uint64_file_length.get();
        }
        this.app.b().b(localMessageForDeviceSingleStruct, this.app.getCurrentAccountUin());
        if (localMessageForDeviceSingleStruct.nDataType == 2) {
          i = 4;
        }
        localObject = ((syw)this.app.getBusinessHandler(51)).a(paramDataPoint.mDin);
        if (localObject == null) {
          break label636;
        }
        j = ((DeviceInfo)localObject).productId;
        tar.a(this.app, paramDataPoint.mDin, "Usr_AIO_ReceiveMsg", i, 0, j);
        if ((localObject != null) && (((DeviceInfo)localObject).isAdmin == 1) && (!TextUtils.isEmpty(localMessageForDeviceSingleStruct.faceRect))) {
          tar.a(this.app, paramDataPoint.mDin, "FR_StrangerComming", 0, 0, 0);
        }
        return localMessageForDeviceSingleStruct.msg;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("DevSingleStructMsgProcessor", 2, "Exception in onReceiveSingleStructMsg: " + localException2.getMessage());
        continue;
      }
      if ((!TextUtils.isEmpty(localMessageForDeviceSingleStruct.strCoverKey)) && (localMessageForDeviceSingleStruct.nCoverChannelType == 3))
      {
        try
        {
          localMessageForDeviceSingleStruct.strCoverMD5 = new BigInteger(1, ((MiniFileProto.MiniFile)new MiniFileProto.MiniFile().mergeFrom(Base64.decode(localMessageForDeviceSingleStruct.strCoverKey2, 2))).md5.get().toByteArray()).toString(16);
        }
        catch (Exception localException3) {}
        if (QLog.isColorLevel())
        {
          QLog.d("DevSingleStructMsgProcessor", 2, "Exception in onReceiveSingleStructMsg: " + localException3.getMessage());
          continue;
          label522:
          if ((!TextUtils.isEmpty(localMessageForDeviceSingleStruct.strMediaKey)) && (localMessageForDeviceSingleStruct.nMediaChannelType == 3))
          {
            try
            {
              localObject = (MiniFileProto.MiniFile)new MiniFileProto.MiniFile().mergeFrom(Base64.decode(localMessageForDeviceSingleStruct.strFileKey2, 2));
              localMessageForDeviceSingleStruct.strMediaFileName = ((MiniFileProto.MiniFile)localObject).name.get();
              localMessageForDeviceSingleStruct.nMediaFileSize = ((MiniFileProto.MiniFile)localObject).length.get();
            }
            catch (Exception localException1) {}
            if (QLog.isColorLevel())
            {
              QLog.d("DevSingleStructMsgProcessor", 2, "Exception in onReceiveSingleStructMsg: " + localException1.getMessage());
              continue;
              label636:
              j = 0;
            }
          }
        }
      }
    }
  }
  
  public boolean b(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    if (this.cB.containsKey(Long.valueOf(paramMessageForDeviceSingleStruct.nMediaSessionID))) {
      this.cB.remove(Long.valueOf(paramMessageForDeviceSingleStruct.nMediaSessionID));
    }
    paramMessageForDeviceSingleStruct.nMediaFileStatus = 6;
    paramMessageForDeviceSingleStruct.nMediaProgress = 0.0F;
    paramMessageForDeviceSingleStruct.serial();
    this.app.b().c(paramMessageForDeviceSingleStruct.frienduin, 9501, paramMessageForDeviceSingleStruct.uniseq, paramMessageForDeviceSingleStruct.msgData);
    ((DeviceFileHandler)this.app.getBusinessHandler(50)).g(0, paramMessageForDeviceSingleStruct.nMediaSessionID, false);
    return true;
  }
  
  public void bCh()
  {
    this.cC.clear();
  }
  
  public void c(Session paramSession)
  {
    MessageForDeviceSingleStruct localMessageForDeviceSingleStruct;
    if (!paramSession.bSend)
    {
      localMessageForDeviceSingleStruct = a(Long.valueOf(paramSession.uSessionID));
      if (localMessageForDeviceSingleStruct != null) {
        break label24;
      }
    }
    label24:
    while (localMessageForDeviceSingleStruct.nMediaSessionID != paramSession.uSessionID) {
      return;
    }
    localMessageForDeviceSingleStruct.nMediaFileStatus = 2;
  }
  
  class a
  {
    WeakReference<MessageForDeviceSingleStruct.a> callback;
    WeakReference<View> view;
    
    public a(View paramView, MessageForDeviceSingleStruct.a parama)
    {
      this.view = new WeakReference(paramView);
      this.callback = new WeakReference(parama);
    }
    
    public MessageForDeviceSingleStruct.a a()
    {
      return (MessageForDeviceSingleStruct.a)this.callback.get();
    }
    
    public View getView()
    {
      return (View)this.view.get();
    }
  }
  
  public class b
  {
    public String mPeerUin;
    public int mUinType;
    public long mUniseq;
    
    public b(String paramString, int paramInt, long paramLong)
    {
      this.mPeerUin = paramString;
      this.mUinType = paramInt;
      this.mUniseq = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     szv
 * JD-Core Version:    0.7.0.1
 */