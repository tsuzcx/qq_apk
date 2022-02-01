import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceFile.a;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class szx
  extends szg
{
  private QQAppInterface app;
  private ConcurrentHashMap<Long, szg.b> cB = new ConcurrentHashMap(20);
  private ConcurrentHashMap<Long, Long> cC = new ConcurrentHashMap(10);
  private ArrayList<szg.a> mCallbacks = new ArrayList();
  
  public szx(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private long a(MessageForDeviceFile paramMessageForDeviceFile, View paramView, MessageForDeviceFile.a parama)
  {
    long l1;
    if ((paramMessageForDeviceFile == null) || (TextUtils.isEmpty(paramMessageForDeviceFile.strMediaKey)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceGroupChatMsgProcessor", 2, "mr is null or strCoverKey is empty in downloadCoverFile!");
      }
      l1 = 0L;
      return l1;
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {
      return 0L;
    }
    Iterator localIterator = this.mCallbacks.iterator();
    while (localIterator.hasNext())
    {
      szg.a locala = (szg.a)localIterator.next();
      if (locala.getView() == paramView) {
        locala.callback = new WeakReference(parama);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.mCallbacks.add(new szg.a(this, paramView, parama));
      }
      if (this.cB.containsKey(Long.valueOf(paramMessageForDeviceFile.uSessionID))) {
        return paramMessageForDeviceFile.uSessionID;
      }
      if (this.cC.containsKey(Long.valueOf(paramMessageForDeviceFile.uniseq)))
      {
        l1 = ((Long)this.cC.get(Long.valueOf(paramMessageForDeviceFile.uniseq))).longValue();
        if (anaz.gQ() - l1 < 3600L) {
          return paramMessageForDeviceFile.uSessionID;
        }
      }
      long l2 = ((DeviceFileHandler)this.app.getBusinessHandler(50)).a(this.app, paramMessageForDeviceFile.strMediaKey, paramMessageForDeviceFile.strFileKey2, 3, 2154);
      paramView = this.app.b().a(paramMessageForDeviceFile.frienduin, paramMessageForDeviceFile.istroop, paramMessageForDeviceFile.uniseq);
      if ((paramView instanceof MessageForDeviceFile)) {
        ((MessageForDeviceFile)paramView).uSessionID = l2;
      }
      paramMessageForDeviceFile.uSessionID = l2;
      l1 = l2;
      if (l2 == 0L) {
        break;
      }
      b(l2, paramMessageForDeviceFile.frienduin, paramMessageForDeviceFile.istroop, paramMessageForDeviceFile.uniseq);
      return l2;
    }
  }
  
  private MessageRecord a(long paramLong1, long paramLong2, JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("duration", 0);
    String str = paramJSONObject.optString("file_key", "");
    paramJSONObject = paramJSONObject.optString("fkey2", "");
    MessageForDevPtt localMessageForDevPtt = (MessageForDevPtt)anbi.b(this.app, Long.toString(paramLong2), null, 9501);
    localMessageForDevPtt.url = "";
    localMessageForDevPtt.urlAtServer = str;
    localMessageForDevPtt.strFileKey2 = paramJSONObject;
    localMessageForDevPtt.channeltype = 3;
    localMessageForDevPtt.itemType = 2;
    localMessageForDevPtt.sttAbility = 0;
    localMessageForDevPtt.longPttVipFlag = 0;
    localMessageForDevPtt.c2cViaOffline = true;
    localMessageForDevPtt.msgtype = -4501;
    localMessageForDevPtt.istroop = 9501;
    localMessageForDevPtt.issend = 0;
    localMessageForDevPtt.isread = false;
    localMessageForDevPtt.selfuin = this.app.getCurrentAccountUin();
    localMessageForDevPtt.senderuin = Long.toString(paramLong1);
    localMessageForDevPtt.frienduin = Long.toString(paramLong2);
    localMessageForDevPtt.time = anaz.gQ();
    localMessageForDevPtt.msg = (aqgv.b(this.app, localMessageForDevPtt.senderuin, true) + ": " + this.app.getApp().getString(2131692316));
    localMessageForDevPtt.voiceLength = i;
    localMessageForDevPtt.extStr = "device_groupchat";
    localMessageForDevPtt.serial();
    return localMessageForDevPtt;
  }
  
  private MessageRecord b(long paramLong1, long paramLong2, JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("media_key", "");
    String str2 = paramJSONObject.optString("cover_key", "");
    String str3 = paramJSONObject.optString("fkey2", "");
    paramJSONObject = paramJSONObject.optString("ckey2", "");
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)anbi.d(-4500);
    localMessageForDeviceFile.strServiceName = szy.aIl;
    localMessageForDeviceFile.msgtype = -4500;
    localMessageForDeviceFile.istroop = 9501;
    localMessageForDeviceFile.filePath = "";
    localMessageForDeviceFile.issend = 0;
    localMessageForDeviceFile.isread = false;
    localMessageForDeviceFile.selfuin = this.app.getCurrentAccountUin();
    localMessageForDeviceFile.senderuin = Long.toString(paramLong1);
    localMessageForDeviceFile.frienduin = Long.toString(paramLong2);
    localMessageForDeviceFile.msgStatus = 3;
    localMessageForDeviceFile.nFileStatus = 1;
    localMessageForDeviceFile.time = anaz.gQ();
    localMessageForDeviceFile.msg = (aqgv.b(this.app, localMessageForDeviceFile.senderuin, true) + ": " + this.app.getApp().getString(2131692598));
    localMessageForDeviceFile.nFileMsgType = 2;
    localMessageForDeviceFile.extStr = "device_groupchat";
    localMessageForDeviceFile.strCoverKey = str2;
    localMessageForDeviceFile.strMediaKey = str1;
    localMessageForDeviceFile.strFileKey2 = str3;
    localMessageForDeviceFile.strCoverKey2 = paramJSONObject;
    localMessageForDeviceFile.serial();
    return localMessageForDeviceFile;
  }
  
  private void b(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    if (!this.cB.containsKey(Long.valueOf(paramLong1)))
    {
      paramString = new szg.b(this, paramString, paramInt, paramLong2);
      this.cB.put(Long.valueOf(paramLong1), paramString);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("DeviceGroupChatMsgProcessor", 2, "found resume");
  }
  
  private void r(MessageRecord paramMessageRecord)
  {
    int i = 0;
    if (i < this.mCallbacks.size())
    {
      Object localObject = (szg.a)this.mCallbacks.get(i);
      View localView = ((szg.a)localObject).getView();
      localObject = ((szg.a)localObject).a();
      if ((localView != null) && (localObject != null))
      {
        j = i;
        if ((paramMessageRecord instanceof MessageForDeviceFile)) {
          ((MessageForDeviceFile.a)localObject).a(localView, (MessageForDeviceFile)paramMessageRecord);
        }
      }
      for (int j = i;; j = i - 1)
      {
        i = j + 1;
        break;
        this.mCallbacks.remove(i);
      }
    }
  }
  
  public long a(MessageRecord paramMessageRecord, View paramView, MessageForDeviceFile.a parama)
  {
    if ((paramMessageRecord instanceof MessageForDeviceFile)) {
      return a((MessageForDeviceFile)paramMessageRecord, paramView, parama);
    }
    return 0L;
  }
  
  protected MessageRecord a(long paramLong)
  {
    Object localObject1 = (szg.b)this.cB.get(Long.valueOf(paramLong));
    if (localObject1 == null) {
      localObject1 = null;
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject2 instanceof QQAppInterface)) {
        break;
      }
      localObject2 = ((QQAppInterface)localObject2).b().a(((szg.b)localObject1).mPeerUin, ((szg.b)localObject1).mUinType, ((szg.b)localObject1).mUniseq);
      localObject1 = localObject2;
    } while (localObject2 != null);
    if (QLog.isColorLevel()) {
      QLog.d("DeviceGroupChatMsgProcessor", 2, "device file msg null");
    }
    return null;
    return null;
  }
  
  public void a(DataPoint paramDataPoint)
  {
    try
    {
      localJSONObject = new JSONObject(paramDataPoint.mValue);
      l2 = localJSONObject.optLong("from_uin");
      l1 = l2;
      if (0L == l2) {
        l1 = paramDataPoint.mDin;
      }
      long l3 = localJSONObject.optLong("to_din");
      l2 = l3;
      if (0L == l3) {
        l2 = paramDataPoint.mDin;
      }
      if ((!TextUtils.isEmpty(this.app.getCurrentAccountUin())) && (String.valueOf(l1).equals(this.app.getCurrentAccountUin()))) {
        return;
      }
      localMessageRecord = null;
      if (10011 != paramDataPoint.mProperityId) {
        break label177;
      }
      localMessageRecord = a(l1, l2, localJSONObject);
    }
    catch (JSONException paramDataPoint)
    {
      JSONObject localJSONObject;
      long l2;
      long l1;
      MessageRecord localMessageRecord;
      while (QLog.isColorLevel())
      {
        QLog.d("DeviceGroupChatMsgProcessor", 2, "getString from json error:" + paramDataPoint.getMessage());
        return;
        label177:
        if (10010 == paramDataPoint.mProperityId) {
          localMessageRecord = b(l1, l2, localJSONObject);
        }
      }
    }
    this.app.b().b(localMessageRecord, this.app.getCurrentAccountUin());
    return;
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (!paramSession.bSend)
    {
      localMessageRecord = a(paramSession.uSessionID);
      if (localMessageRecord != null) {
        break label21;
      }
    }
    label21:
    label156:
    do
    {
      return;
      MessageForDeviceFile localMessageForDeviceFile;
      if ((localMessageRecord instanceof MessageForDeviceFile))
      {
        localMessageForDeviceFile = (MessageForDeviceFile)localMessageRecord;
        if (localMessageForDeviceFile.uSessionID != paramSession.uSessionID) {
          continue;
        }
        localMessageForDeviceFile.filePath = paramSession.strFilePathSrc;
        localMessageForDeviceFile.progress = 1.0F;
        if (!paramBoolean) {
          break label156;
        }
        localMessageForDeviceFile.nFileStatus = 5;
        this.cC.remove(Long.valueOf(localMessageRecord.uniseq));
      }
      for (;;)
      {
        localMessageForDeviceFile.serial();
        this.app.b().c(localMessageRecord.frienduin, 9501, localMessageRecord.uniseq, localMessageRecord.msgData);
        if ((localMessageForDeviceFile.uSessionID == paramSession.uSessionID) && (paramBoolean)) {
          r(localMessageForDeviceFile);
        }
        this.cB.remove(Long.valueOf(paramSession.uSessionID));
        return;
        localMessageForDeviceFile.nFileStatus = 6;
        this.cC.put(Long.valueOf(localMessageRecord.uniseq), Long.valueOf(anaz.gQ()));
      }
    } while (!QLog.isColorLevel());
    QLog.d("DeviceGroupChatMsgProcessor", 2, "error:can not find session id in message record");
  }
  
  public void c(Session paramSession)
  {
    Object localObject;
    if (!paramSession.bSend)
    {
      localObject = a(paramSession.uSessionID);
      if (localObject != null) {
        break label21;
      }
    }
    label21:
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof MessageForDeviceFile));
      localObject = (MessageForDeviceFile)localObject;
    } while (((MessageForDeviceFile)localObject).uSessionID != paramSession.uSessionID);
    ((MessageForDeviceFile)localObject).nFileStatus = 2;
  }
  
  public void q(MessageRecord paramMessageRecord)
  {
    Object localObject = (DeviceFileHandler)this.app.getBusinessHandler(50);
    long l;
    if ((paramMessageRecord instanceof MessageForDeviceFile))
    {
      MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)paramMessageRecord;
      l = ((DeviceFileHandler)localObject).a(this.app, localMessageForDeviceFile.strMediaKey, localMessageForDeviceFile.strFileKey2, 3, 2154);
      localObject = this.app.b().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
      if ((localObject instanceof MessageForDeviceFile)) {
        ((MessageForDeviceFile)localObject).uSessionID = l;
      }
      localMessageForDeviceFile.uSessionID = l;
    }
    for (;;)
    {
      if (l != 0L) {
        b(l, paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
      }
      return;
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     szx
 * JD-Core Version:    0.7.0.1
 */