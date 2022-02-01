import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.msg.data.DeviceCommonMsgProcessor;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class szd
  extends szg
{
  syz jdField_a_of_type_Syz = new syz();
  szc jdField_a_of_type_Szc = new szc();
  private Set<Long> aW = new HashSet(10);
  private ConcurrentHashMap<Long, Long> cA = new ConcurrentHashMap(10);
  private ConcurrentHashMap<String, szd.d> cz = new ConcurrentHashMap(20);
  private final aook f = new sze(this, Looper.getMainLooper());
  private final ArrayList<szd.a> mCallbacks = new ArrayList();
  
  private void a(long paramLong1, String paramString, long paramLong2, int paramInt)
  {
    if (!this.cz.containsKey(paramLong1 + ""))
    {
      paramString = new szd.d(paramString, paramLong2, paramInt, "", 0L);
      this.cz.put(String.valueOf(paramLong1), paramString);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("DeviceAVFileMsgObserver", 2, "found resume");
  }
  
  private void a(Session paramSession)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      MessageForDevShortVideo localMessageForDevShortVideo = (MessageForDevShortVideo)anbi.d(-4503);
      localMessageForDevShortVideo.videoFileName = paramSession.strFilePathSrc;
      localMessageForDevShortVideo.msgtype = -4503;
      localMessageForDevShortVideo.istroop = 9501;
      localMessageForDevShortVideo.issend = 0;
      localMessageForDevShortVideo.isread = false;
      localMessageForDevShortVideo.selfuin = ((QQAppInterface)localObject).getCurrentAccountUin();
      localMessageForDevShortVideo.senderuin = Long.toString(paramSession.msgHeader.uint64_src_uin);
      localMessageForDevShortVideo.frienduin = Long.toString(paramSession.msgHeader.uint64_src_uin);
      localMessageForDevShortVideo.uuid = "";
      localMessageForDevShortVideo.videoFileFormat = 2;
      localMessageForDevShortVideo.videoFileSize = ((int)paramSession.uFileSizeSrc);
      localMessageForDevShortVideo.videoFileStatus = 2000;
      localMessageForDevShortVideo.videoFileProgress = 0;
      localMessageForDevShortVideo.fileType = 19;
      localMessageForDevShortVideo.lastModified = 0L;
      localMessageForDevShortVideo.fileSessionId = paramSession.uSessionID;
      localMessageForDevShortVideo.msg = localMessageForDevShortVideo.getSummary();
      localMessageForDevShortVideo.serial();
      a(paramSession.uSessionID, localMessageForDevShortVideo.frienduin, localMessageForDevShortVideo.uniseq, localMessageForDevShortVideo.istroop);
      ((QQAppInterface)localObject).b().b(localMessageForDevShortVideo, ((QQAppInterface)localObject).getCurrentAccountUin());
      if (QLog.isColorLevel()) {
        QLog.d("DeviceAVFileMsgObserver", 2, "recievemsg msg.uniseq:" + localMessageForDevShortVideo.uniseq + " ===> filesize:" + localMessageForDevShortVideo.videoFileSize + " fileStatus:" + ShortVideoUtils.ff(localMessageForDevShortVideo.videoFileStatus));
      }
    }
  }
  
  private void b(Session paramSession, boolean paramBoolean)
  {
    szd.d locald = (szd.d)this.cz.get(String.valueOf(paramSession.uSessionID));
    if (locald == null) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (paramSession.actionInfo.strServiceName.equalsIgnoreCase(szy.aIm))
    {
      this.jdField_a_of_type_Szc.a(paramSession, locald.mPeerUin, locald.mUniseq, locald.mUinType, paramBoolean);
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 instanceof QQAppInterface))
      {
        localObject1 = (QQAppInterface)localObject1;
        localObject2 = ((syw)((QQAppInterface)localObject1).getBusinessHandler(51)).a(Long.parseLong(locald.mPeerUin));
        if (localObject2 == null) {
          break label380;
        }
      }
    }
    label157:
    label171:
    label367:
    label380:
    for (int i = ((DeviceInfo)localObject2).productId;; i = 0)
    {
      if (localObject2 != null) {}
      for (long l = ((DeviceInfo)localObject2).din;; l = 0L)
      {
        int j;
        if (paramSession.actionInfo.strServiceName.compareTo(szy.aIn) == 0) {
          if (paramBoolean)
          {
            j = 0;
            tar.a((AppRuntime)localObject1, l, "Net_SendMsg_Audio", 0, j, i);
            localObject1 = ((QQAppInterface)localObject1).getHandler(Conversation.class);
            if (localObject1 != null) {
              ((MqqHandler)localObject1).sendEmptyMessage(1009);
            }
            localObject1 = this.f.obtainMessage();
            localObject2 = new szd.c();
            if (!paramBoolean) {
              break label367;
            }
          }
        }
        for (i = 1003;; i = 1005)
        {
          ((szd.c)localObject2).mStatus = i;
          ((szd.c)localObject2).mUniseq = locald.mUniseq;
          ((Message)localObject1).obj = localObject2;
          this.f.sendMessageDelayed((Message)localObject1, 0L);
          this.cz.remove(String.valueOf(paramSession.uSessionID));
          return;
          if (!paramSession.actionInfo.strServiceName.equalsIgnoreCase(szy.aIn)) {
            break;
          }
          this.jdField_a_of_type_Syz.a(paramSession, locald.mPeerUin, locald.mUniseq, locald.mUinType, paramBoolean);
          break;
          j = 1;
          break label157;
          if (paramSession.actionInfo.strServiceName.compareTo(szy.aIm) != 0) {
            break label171;
          }
          if (paramBoolean) {}
          for (j = 0;; j = 1)
          {
            tar.a((AppRuntime)localObject1, l, "Net_SendMsg_Video", 0, j, i);
            break;
          }
        }
      }
    }
  }
  
  public String a(DataPoint paramDataPoint)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(paramDataPoint.mValue);
        long l1 = ((JSONObject)localObject1).optLong("msg_time", anaz.gQ());
        long l2 = ((JSONObject)localObject1).optLong("duration", 0L);
        String str2 = ((JSONObject)localObject1).optString("file_key", "");
        String str3 = ((JSONObject)localObject1).optString("file_url", "");
        String str1 = ((JSONObject)localObject1).optString("file_mini", "");
        if (TextUtils.isEmpty(str1))
        {
          str1 = ((JSONObject)localObject1).optString("media_mini", "");
          localObject1 = ((JSONObject)localObject1).optString("fkey2", "");
          Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject2 instanceof QQAppInterface))
          {
            localObject2 = (QQAppInterface)localObject2;
            if (QLog.isColorLevel()) {
              QLog.d("DeviceAVFileMsgObserver", 2, "receive audiomsg length:" + l2);
            }
            MessageForDevPtt localMessageForDevPtt = (MessageForDevPtt)anbi.d(-4501);
            localMessageForDevPtt.url = "";
            localMessageForDevPtt.channeltype = 1;
            localMessageForDevPtt.urlAtServer = str2;
            if (!TextUtils.isEmpty(str3))
            {
              localMessageForDevPtt.channeltype = 2;
              localMessageForDevPtt.urlAtServer = str3;
              localMessageForDevPtt.itemType = 2;
              localMessageForDevPtt.sttAbility = 0;
              localMessageForDevPtt.longPttVipFlag = 0;
              localMessageForDevPtt.c2cViaOffline = true;
              localMessageForDevPtt.msgtype = -4501;
              localMessageForDevPtt.istroop = 9501;
              localMessageForDevPtt.issend = 0;
              localMessageForDevPtt.isread = false;
              localMessageForDevPtt.selfuin = ((QQAppInterface)localObject2).getCurrentAccountUin();
              localMessageForDevPtt.senderuin = Long.toString(paramDataPoint.mDin);
              localMessageForDevPtt.frienduin = Long.toString(paramDataPoint.mDin);
              localMessageForDevPtt.time = l1;
              localMessageForDevPtt.msg = localMessageForDevPtt.getSummary();
              localMessageForDevPtt.voiceLength = ((int)l2);
              if (QLog.isColorLevel()) {
                QLog.d("DeviceAVFileMsgObserver", 2, "voiceLength onReceiveAudioMsg " + localMessageForDevPtt.voiceLength);
              }
              localMessageForDevPtt.serial();
              localMessageForDevPtt.saveExtInfoToExtStr("smartdevice_ptt_channeltype", String.valueOf(localMessageForDevPtt.channeltype));
              ((QQAppInterface)localObject2).b().b(localMessageForDevPtt, ((QQAppInterface)localObject2).getCurrentAccountUin());
              return localMessageForDevPtt.msg;
            }
            if (TextUtils.isEmpty(str1)) {
              continue;
            }
            localMessageForDevPtt.channeltype = 3;
            localMessageForDevPtt.urlAtServer = str1;
            localMessageForDevPtt.strFileKey2 = ((String)localObject1);
            continue;
          }
          return "";
        }
      }
      catch (JSONException paramDataPoint)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceAVFileMsgObserver", 2, "getString from json error:" + paramDataPoint.getMessage());
        }
      }
    }
  }
  
  public void a(View paramView, szd.b paramb)
  {
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext())
    {
      szd.a locala = (szd.a)localIterator.next();
      if (locala.getView() == paramView)
      {
        locala.callback = new WeakReference(paramb);
        return;
      }
    }
    this.mCallbacks.add(new szd.a(paramView, paramb));
  }
  
  public void a(MessageForDevPtt paramMessageForDevPtt)
  {
    if (this.aW.contains(Long.valueOf(paramMessageForDevPtt.uniseq))) {}
    do
    {
      long l;
      do
      {
        do
        {
          do
          {
            return;
            if (!this.cA.containsKey(Long.valueOf(paramMessageForDevPtt.uniseq))) {
              break;
            }
            l = ((Long)this.cA.get(Long.valueOf(paramMessageForDevPtt.uniseq))).longValue();
          } while (anaz.gQ() - l < 3600L);
        } while (TextUtils.isEmpty(paramMessageForDevPtt.urlAtServer));
        localObject = BaseApplicationImpl.getApplication().getRuntime();
      } while (!(localObject instanceof QQAppInterface));
      Object localObject = (QQAppInterface)localObject;
      DeviceFileHandler localDeviceFileHandler = (DeviceFileHandler)((QQAppInterface)localObject).getBusinessHandler(50);
      if (paramMessageForDevPtt.channeltype == 0) {}
      try
      {
        paramMessageForDevPtt.channeltype = Integer.parseInt(paramMessageForDevPtt.getExtInfoFromExtStr("smartdevice_ptt_channeltype"));
        l = localDeviceFileHandler.a((QQAppInterface)localObject, paramMessageForDevPtt.urlAtServer, paramMessageForDevPtt.strFileKey2, paramMessageForDevPtt.channeltype, 2108);
        this.aW.add(Long.valueOf(paramMessageForDevPtt.uniseq));
        localObject = String.valueOf(l);
        if (!this.cz.containsKey(localObject))
        {
          paramMessageForDevPtt = new szd.d(paramMessageForDevPtt.frienduin, paramMessageForDevPtt.uniseq, paramMessageForDevPtt.istroop, "", 0L);
          this.cz.put(localObject, paramMessageForDevPtt);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("DeviceAVFileMsgObserver", 2, "found resume");
  }
  
  public void a(Session paramSession, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceAVFileMsgObserver", 2, "onServiceSessionProgress : service@" + paramSession.actionInfo.strServiceName);
    }
    szd.d locald = (szd.d)this.cz.get(String.valueOf(paramSession.uSessionID));
    Message localMessage;
    szd.c localc;
    if (locald != null)
    {
      if (!paramSession.actionInfo.strServiceName.equalsIgnoreCase(szy.aIm)) {
        break label165;
      }
      this.jdField_a_of_type_Szc.a(paramSession, locald.mPeerUin, locald.mUniseq, locald.mUinType, paramFloat);
      localMessage = this.f.obtainMessage();
      localc = new szd.c();
      if (!paramSession.bSend) {
        break label205;
      }
    }
    label165:
    label205:
    for (localc.mStatus = 1002;; localc.mStatus = 2002)
    {
      localc.oy = paramFloat;
      localc.mUniseq = locald.mUniseq;
      localMessage.obj = localc;
      this.f.sendMessageDelayed(localMessage, 0L);
      return;
      if (!paramSession.actionInfo.strServiceName.equalsIgnoreCase(szy.aIn)) {
        break;
      }
      this.jdField_a_of_type_Syz.a(paramSession, locald.mPeerUin, locald.mUniseq, locald.mUinType, paramFloat);
      break;
    }
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceAVFileMsgObserver", 2, "onServiceSessionComplete : service@" + paramSession.actionInfo.strServiceName);
    }
    if (paramSession == null) {
      QLog.e("DeviceAVFileMsgObserver", 1, "onServiceSessionComplete, session == null !!!!!");
    }
    szd.d locald;
    do
    {
      return;
      if (paramSession.bSend)
      {
        b(paramSession, paramBoolean);
        return;
      }
      locald = (szd.d)this.cz.get(String.valueOf(paramSession.uSessionID));
    } while (locald == null);
    label135:
    Object localObject1;
    Object localObject2;
    if (paramSession.actionInfo.strServiceName.equalsIgnoreCase(szy.aIm))
    {
      DeviceCommonMsgProcessor.c(paramSession, paramBoolean);
      this.jdField_a_of_type_Szc.a(paramSession, locald.mPeerUin, locald.mUniseq, locald.mUinType, paramBoolean);
      localObject1 = this.f.obtainMessage();
      localObject2 = new szd.c();
      if (!paramBoolean) {
        break label432;
      }
    }
    label432:
    for (int i = 2003;; i = 2005)
    {
      ((szd.c)localObject2).mStatus = i;
      ((szd.c)localObject2).mUniseq = locald.mUniseq;
      ((Message)localObject1).obj = localObject2;
      this.f.sendMessageDelayed((Message)localObject1, 0L);
      this.cz.remove(String.valueOf(paramSession.uSessionID));
      this.aW.remove(Long.valueOf(locald.mUniseq));
      if (!paramBoolean) {
        break label439;
      }
      this.cA.remove(Long.valueOf(locald.mUniseq));
      return;
      if ((paramSession.actionInfo.strServiceName.equalsIgnoreCase(szy.aIn)) || (!paramSession.actionInfo.strServiceName.equalsIgnoreCase(szy.aIo))) {
        break label135;
      }
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject1 instanceof QQAppInterface)) {
        break label135;
      }
      localObject1 = (QQAppInterface)localObject1;
      localObject2 = ((QQAppInterface)localObject1).b().a(locald.mPeerUin, locald.mUinType, locald.mUniseq);
      if (localObject2 == null) {
        break;
      }
      if (!(localObject2 instanceof MessageForDevPtt)) {
        break label135;
      }
      MessageForDevPtt localMessageForDevPtt = (MessageForDevPtt)localObject2;
      localMessageForDevPtt.url = paramSession.strFilePathSrc;
      if (paramBoolean) {}
      for (localMessageForDevPtt.fileSize = ahav.getFileSizes(paramSession.strFilePathSrc);; localMessageForDevPtt.fileSize = -1L)
      {
        localMessageForDevPtt.msg = localMessageForDevPtt.getSummary();
        localMessageForDevPtt.serial();
        ((QQAppInterface)localObject1).b().c(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, localMessageForDevPtt.msgData);
        break;
      }
    }
    label439:
    this.cA.put(Long.valueOf(locald.mUniseq), Long.valueOf(anaz.gQ()));
  }
  
  public void a(MessageRecord paramMessageRecord, float paramFloat)
  {
    Message localMessage = this.f.obtainMessage();
    szd.c localc = new szd.c();
    localc.mStatus = 1002;
    localc.mUniseq = paramMessageRecord.uniseq;
    localc.oy = paramFloat;
    localMessage.obj = localc;
    this.f.sendMessageDelayed(localMessage, 0L);
  }
  
  public void a(MessageRecord paramMessageRecord, Boolean paramBoolean)
  {
    Message localMessage = this.f.obtainMessage();
    szd.c localc = new szd.c();
    int i;
    if (paramBoolean.booleanValue())
    {
      i = 1003;
      localc.mStatus = i;
      localc.mUniseq = paramMessageRecord.uniseq;
      if (!paramBoolean.booleanValue()) {
        break label89;
      }
    }
    label89:
    for (float f1 = 1.0F;; f1 = 0.0F)
    {
      localc.oy = f1;
      localMessage.obj = localc;
      this.f.sendMessageDelayed(localMessage, 0L);
      return;
      i = 1005;
      break;
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject1 = (QQAppInterface)localObject1;
      localObject2 = (syw)((QQAppInterface)localObject1).getBusinessHandler(51);
      if ((!paramString1.equalsIgnoreCase(szy.aIn)) || (localObject2 == null) || (!((syw)localObject2).bm(paramLong1))) {
        break label192;
      }
      localObject1 = new Session();
      ((Session)localObject1).uSessionID = ((syw)localObject2).a(paramLong1, paramString2, paramInt2);
      ((Session)localObject1).strFilePathSrc = paramString2;
      ((Session)localObject1).uFileSizeSrc = ahav.getFileSizes(paramString2);
      localObject2 = String.valueOf(((Session)localObject1).uSessionID);
      if (this.cz.containsKey(localObject2)) {
        break label221;
      }
      paramString2 = new szd.d(String.valueOf(paramLong1), paramLong2, paramInt1, paramString2, ((Session)localObject1).uFileSizeSrc);
      this.cz.put(localObject2, paramString2);
      label154:
      if (!aqiw.isNetSupport(BaseApplication.getContext()))
      {
        if (!paramString1.equalsIgnoreCase(szy.aIm)) {
          break label238;
        }
        this.jdField_a_of_type_Szc.a((Session)localObject1, String.valueOf(paramLong1), paramLong2, paramInt1, false);
      }
    }
    label192:
    label221:
    label238:
    while (!paramString1.equalsIgnoreCase(szy.aIn))
    {
      return;
      localObject2 = ((DeviceFileHandler)((QQAppInterface)localObject1).getBusinessHandler(50)).a(paramString2, paramString1, null, paramLong1);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      return;
      if (!QLog.isColorLevel()) {
        break label154;
      }
      QLog.d("DeviceAVFileMsgObserver", 2, "found resume");
      break label154;
    }
    this.jdField_a_of_type_Syz.a((Session)localObject1, String.valueOf(paramLong1), paramLong2, paramInt1, false);
  }
  
  public void b(Session paramSession)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceAVFileMsgObserver", 2, "onServiceSessionNew : service@" + paramSession.actionInfo.strServiceName);
    }
    if ((!paramSession.bSend) && (paramSession.actionInfo.strServiceName.equalsIgnoreCase(szy.aIm))) {
      a(paramSession);
    }
  }
  
  public void b(MessageRecord paramMessageRecord, float paramFloat)
  {
    Message localMessage = this.f.obtainMessage();
    szd.c localc = new szd.c();
    if (paramMessageRecord.isSendFromLocal()) {}
    for (int i = 1002;; i = 2002)
    {
      localc.mStatus = i;
      localc.mUniseq = paramMessageRecord.uniseq;
      localc.oy = paramFloat;
      localMessage.obj = localc;
      this.f.sendMessageDelayed(localMessage, 0L);
      return;
    }
  }
  
  public void b(MessageRecord paramMessageRecord, Boolean paramBoolean)
  {
    Message localMessage = this.f.obtainMessage();
    szd.c localc = new szd.c();
    int i;
    if (paramMessageRecord.isSendFromLocal()) {
      if (paramBoolean.booleanValue())
      {
        i = 1003;
        localc.mStatus = i;
        localc.mUniseq = paramMessageRecord.uniseq;
        if (!paramBoolean.booleanValue()) {
          break label119;
        }
      }
    }
    label119:
    for (float f1 = 1.0F;; f1 = 0.0F)
    {
      localc.oy = f1;
      localMessage.obj = localc;
      this.f.sendMessageDelayed(localMessage, 0L);
      return;
      i = 1005;
      break;
      if (paramBoolean.booleanValue())
      {
        i = 2003;
        break;
      }
      i = 2005;
      break;
    }
  }
  
  public void bCd()
  {
    this.cA.clear();
  }
  
  public void bh(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    float f1;
    do
    {
      return;
      int i = paramBundle.getInt("cookie", 0);
      f1 = paramBundle.getFloat("percent", 0.0F);
      localObject = new Session();
      ((Session)localObject).uSessionID = i;
      paramBundle = (szd.d)this.cz.get(String.valueOf(i));
    } while (paramBundle == null);
    this.jdField_a_of_type_Syz.a((Session)localObject, paramBundle.mPeerUin, paramBundle.mUniseq, paramBundle.mUinType, f1);
    Object localObject = this.f.obtainMessage();
    szd.c localc = new szd.c();
    localc.mStatus = 1002;
    localc.oy = f1;
    localc.mUniseq = paramBundle.mUniseq;
    ((Message)localObject).obj = localc;
    this.f.sendMessageDelayed((Message)localObject, 0L);
  }
  
  public void bi(Bundle paramBundle)
  {
    boolean bool = true;
    if (paramBundle == null) {}
    szd.d locald;
    do
    {
      return;
      j = paramBundle.getInt("cookie", 0);
      i = paramBundle.getInt("err_code", 1);
      paramBundle = new Session();
      paramBundle.uSessionID = j;
      locald = (szd.d)this.cz.get(String.valueOf(paramBundle.uSessionID));
    } while (locald == null);
    paramBundle.strFilePathSrc = locald.aIg;
    paramBundle.uFileSizeSrc = locald.mFileSize;
    Object localObject1 = this.jdField_a_of_type_Syz;
    Object localObject2 = locald.mPeerUin;
    long l = locald.mUniseq;
    int j = locald.mUinType;
    if (i == 0)
    {
      ((syz)localObject1).a(paramBundle, (String)localObject2, l, j, bool);
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 instanceof QQAppInterface))
      {
        localObject1 = (QQAppInterface)localObject1;
        localObject2 = ((syw)((QQAppInterface)localObject1).getBusinessHandler(51)).a(Long.parseLong(locald.mPeerUin));
        if (localObject2 != null) {
          j = ((DeviceInfo)localObject2).productId;
        }
        if (localObject2 != null) {
          l = ((DeviceInfo)localObject2).din;
        }
        localObject1 = ((QQAppInterface)localObject1).getHandler(Conversation.class);
        if (localObject1 != null) {
          ((MqqHandler)localObject1).sendEmptyMessage(1009);
        }
      }
      localObject1 = this.f.obtainMessage();
      localObject2 = new szd.c();
      if (i != 0) {
        break label301;
      }
    }
    label301:
    for (int i = 1003;; i = 1005)
    {
      ((szd.c)localObject2).mStatus = i;
      ((szd.c)localObject2).mUniseq = locald.mUniseq;
      ((Message)localObject1).obj = localObject2;
      this.f.sendMessageDelayed((Message)localObject1, 0L);
      this.cz.remove(String.valueOf(paramBundle.uSessionID));
      return;
      bool = false;
      break;
    }
  }
  
  public boolean bp(long paramLong)
  {
    Iterator localIterator = this.cz.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((szd.d)this.cz.get(str)).mUniseq == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public void c(Session paramSession)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceAVFileMsgObserver", 2, "onServiceSessionStart : service@" + paramSession.actionInfo.strServiceName);
    }
    szd.d locald = (szd.d)this.cz.get(String.valueOf(paramSession.uSessionID));
    if (locald == null) {
      return;
    }
    Message localMessage = this.f.obtainMessage();
    szd.c localc = new szd.c();
    if (paramSession.bSend) {}
    for (localc.mStatus = 1001;; localc.mStatus = 2001)
    {
      localc.mUniseq = locald.mUniseq;
      localMessage.obj = localc;
      this.f.sendMessageDelayed(localMessage, 0L);
      return;
    }
  }
  
  void dispatchMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceAVFileMsgObserver", 2, "handleMessage" + ((szd.c)paramMessage.obj).mUniseq + " status " + paramMessage.what + "retCode " + paramMessage.arg1);
    }
    int i = 0;
    if (i < this.mCallbacks.size())
    {
      Object localObject = (szd.a)this.mCallbacks.get(i);
      View localView = ((szd.a)localObject).getView();
      localObject = ((szd.a)localObject).a();
      if ((localView != null) && (localObject != null)) {
        ((szd.b)localObject).a(localView, (szd.c)paramMessage.obj);
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
  
  class a
  {
    WeakReference<szd.b> callback;
    WeakReference<View> view;
    
    public a(View paramView, szd.b paramb)
    {
      this.view = new WeakReference(paramView);
      this.callback = new WeakReference(paramb);
    }
    
    public szd.b a()
    {
      return (szd.b)this.callback.get();
    }
    
    public View getView()
    {
      return (View)this.view.get();
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, szd.c paramc);
  }
  
  public class c
  {
    public int mStatus;
    public long mUniseq;
    public float oy;
    
    public c() {}
  }
  
  class d
  {
    String aIg;
    long mFileSize;
    String mPeerUin;
    int mUinType;
    long mUniseq;
    
    public d(String paramString1, long paramLong1, int paramInt, String paramString2, long paramLong2)
    {
      this.mPeerUin = paramString1;
      this.mUniseq = paramLong1;
      this.mUinType = paramInt;
      this.aIg = paramString2;
      this.mFileSize = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     szd
 * JD-Core Version:    0.7.0.1
 */