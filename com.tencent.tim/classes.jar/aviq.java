import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.mpfile.MpfileTaskInfo;
import com.dataline.mpfile.MpfileTaskRecord;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.ipc.DatalineProxyService;
import cooperation.qqdataline.ipc.DatalineRemoteManager.1;
import cooperation.qqdataline.ipc.DatalineRemoteManager.10;
import cooperation.qqdataline.ipc.DatalineRemoteManager.12;
import cooperation.qqdataline.ipc.DatalineRemoteManager.3;
import cooperation.qqdataline.ipc.DatalineRemoteManager.8;
import cooperation.qqdataline.ipc.DatalineRemoteManager.9;
import cooperation.qqdataline.ipc.MessageRecordParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;

public class aviq
  implements Observer
{
  public ArrayList<Bundle> EM = new ArrayList();
  public avix a;
  public QQAppInterface app;
  aqju bg;
  boolean dnf = false;
  boolean dng = false;
  private ServiceConnection mServiceConnection = new aviw(this);
  
  public aviq(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.app.b().addObserver(this);
    eAv();
  }
  
  private void cPi()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null) {
      if (QLog.isColorLevel()) {
        QLog.d("DatalineRemoteManager", 2, "unregisterRemoteCommand PluginCommunicationHandler.getInstance failed");
      }
    }
    while (!localPluginCommunicationHandler.containsCmd("dataline.remotecall")) {
      return;
    }
    localPluginCommunicationHandler.unregister("dataline.remotecall");
  }
  
  private void d(Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = "";
    if (paramBundle != null) {
      localObject = paramBundle.getString("notify_cmd");
    }
    if (this.a == null) {
      if (((String)localObject).equals("onReceive")) {
        if (QLog.isColorLevel()) {
          QLog.d("DatalineRemoteManager", 2, "postRemoteNotify mDatalineService not started strNotifyCmd:" + (String)localObject + " no need cached");
        }
      }
    }
    do
    {
      return;
      if (paramBoolean) {
        eAo();
      }
      if (QLog.isColorLevel()) {
        QLog.d("DatalineRemoteManager", 2, "postRemoteNotify mDatalineService not started strNotifyCmd:" + (String)localObject + " cached");
      }
      localObject = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject).getThread())
      {
        new Handler((Looper)localObject).post(new DatalineRemoteManager.9(this, paramBundle));
        return;
      }
      eb(paramBundle);
      this.EM.add(paramBundle);
      return;
      eAu();
      if (paramBundle != null) {}
      try
      {
        paramBundle.setClassLoader(getClass().getClassLoader());
        if (QLog.isColorLevel()) {
          QLog.d("DatalineRemoteManager", 2, "postRemoteNotify send success strNotifyCmd:" + (String)localObject);
        }
        this.a.b("com.qqdataline.action.notify", paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("DatalineRemoteManager", 2, "postRemoteNotify send failed strNotifyCmd:" + (String)localObject);
  }
  
  private void eAo()
  {
    if ((this.a == null) && (!this.dnf))
    {
      this.dnf = true;
      if (QLog.isColorLevel()) {
        QLog.d("DatalineRemoteManager", 2, "mDatalineService start service");
      }
      DatalineProxyService.d(this.app, this.mServiceConnection);
    }
  }
  
  private void eAp()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new DatalineRemoteManager.1(this));
      return;
    }
    eAq();
  }
  
  private void eAq()
  {
    if (this.bg != null) {
      return;
    }
    if (!BaseActivity.mAppForground)
    {
      nt(3);
      return;
    }
    if (BaseActivity.sTopActivity == null)
    {
      nt(3);
      return;
    }
    if (!CheckPermission.isHasStoragePermission(BaseActivity.sTopActivity))
    {
      CheckPermission.requestSDCardPermission(BaseActivity.sTopActivity, new avis(this));
      return;
    }
    eAs();
  }
  
  private void eAr()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new DatalineRemoteManager.3(this));
      return;
    }
    eAt();
  }
  
  private void eAs()
  {
    nt(0);
    this.dng = false;
    this.bg = aqha.a(BaseActivity.sTopActivity, 230, acfp.m(2131704635), acfp.m(2131704639), 2131696322, 2131721952, new avit(this), new aviu(this));
    this.bg.setOnDismissListener(new aviv(this));
    TextView localTextView = (TextView)this.bg.findViewById(2131365863);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localTextView.setLayoutParams(localLayoutParams);
    localTextView.setMinHeight(aqcx.dip2px(BaseActivity.sTopActivity, 35.0F));
    localTextView.setGravity(17);
    this.bg.show();
  }
  
  private void eAt()
  {
    if (this.bg != null)
    {
      this.bg.dismiss();
      this.bg = null;
    }
  }
  
  private void eAu()
  {
    if (this.EM.isEmpty()) {}
    for (;;)
    {
      return;
      Object localObject1 = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject1).getThread())
      {
        new Handler((Looper)localObject1).post(new DatalineRemoteManager.10(this));
        return;
      }
      while (!this.EM.isEmpty())
      {
        Bundle localBundle = (Bundle)this.EM.remove(0);
        localObject1 = "";
        Object localObject2 = localObject1;
        if (localBundle != null) {}
        try
        {
          localObject2 = localBundle.getString("notify_cmd");
          localObject1 = localObject2;
          localBundle.setClassLoader(getClass().getClassLoader());
          localObject1 = localObject2;
          this.a.b("com.qqdataline.action.notify", localBundle);
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localObject1 = localObject2;
          QLog.d("DatalineRemoteManager", 2, "doPostCachedMsg send success strNotifyCmd:" + (String)localObject2);
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
        }
        if (QLog.isColorLevel()) {
          QLog.d("DatalineRemoteManager", 2, "doPostCachedMsg send failed strNotifyCmd:" + (String)localObject1);
        }
      }
    }
  }
  
  private void eAv()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null) {
      if (QLog.isColorLevel()) {
        QLog.d("DatalineRemoteManager", 2, "registerRemoteCommand PluginCommunicationHandler.getInstance failed");
      }
    }
    while (localPluginCommunicationHandler.containsCmd("dataline.remotecall")) {
      return;
    }
    localPluginCommunicationHandler.register(new avir(this, "dataline.remotecall"));
  }
  
  private void eb(Bundle paramBundle)
  {
    Object localObject = "";
    if (paramBundle != null) {
      localObject = paramBundle.getString("notify_cmd");
    }
    if (((String)localObject).equals("onReceiveRegisterProxySvcPack"))
    {
      paramBundle = this.EM.iterator();
      do
      {
        if (!paramBundle.hasNext()) {
          break;
        }
        localObject = (Bundle)paramBundle.next();
      } while (!((Bundle)localObject).getString("notify_cmd").equals("onReceiveRegisterProxySvcPack"));
    }
    do
    {
      do
      {
        this.EM.remove(localObject);
        return;
        while (!((String)localObject).equals("UpdateUnreadMsgsNum")) {}
        paramBundle = this.EM.iterator();
      } while (!paramBundle.hasNext());
      localObject = (Bundle)paramBundle.next();
    } while (!((Bundle)localObject).getString("notify_cmd").equals("UpdateUnreadMsgsNum"));
    this.EM.remove(localObject);
  }
  
  private void fw()
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread()) {
      new Handler((Looper)localObject).post(new DatalineRemoteManager.12(this));
    }
    while (BaseActivity.sTopActivity == null) {
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("string_from", true);
    ((Bundle)localObject).putBoolean("string_uin", false);
    ((Bundle)localObject).putLong("device_din", 0L);
    ((Bundle)localObject).putInt("sTitleID", 0);
    avio.b(BaseActivity.sTopActivity, (Bundle)localObject, "com.qqdataline.activity.LiteWifiphotoActivity");
    BaseActivity.sTopActivity.overridePendingTransition(2130772009, 0);
  }
  
  private boolean nt(int paramInt)
  {
    if (paramInt == 2) {
      avim.uu("0X800672B");
    }
    Object localObject;
    for (;;)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("notify_cmd", "authWifiphoto");
      ((Bundle)localObject).putInt("authresult", paramInt);
      localObject = o((Bundle)localObject);
      if (localObject != null) {
        break;
      }
      return false;
      if (paramInt == 1)
      {
        avim.uu("0X800672C");
        if (this.app != null)
        {
          localObject = this.app.getHandler(Conversation.class);
          if (localObject != null)
          {
            Message localMessage = ((MqqHandler)localObject).obtainMessage(1134022);
            localMessage.arg1 = 0;
            ((MqqHandler)localObject).sendMessage(localMessage);
          }
          localObject = new Intent();
          ((Intent)localObject).setAction("com.tencent.dataline.wifiphoto.ACTION_WIFIPHOTO_REFUSE_AUTH");
          this.app.getApp().sendBroadcast((Intent)localObject);
        }
      }
    }
    return ((Bundle)localObject).getBoolean("result");
  }
  
  private Bundle o(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str;
    do
    {
      return null;
      str = paramBundle.getString("notify_cmd");
      if (this.a == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DatalineRemoteManager", 2, "mDatalineService not started strNotifyCmd:" + str);
        }
        eAo();
        return null;
      }
      eAu();
      try
      {
        paramBundle.setClassLoader(getClass().getClassLoader());
        if (QLog.isColorLevel()) {
          QLog.d("DatalineRemoteManager", 2, "sendRemoteNotify send success strNotifyCmd:" + str);
        }
        paramBundle = this.a.transfer("com.qqdataline.action.notify", paramBundle);
        if (paramBundle != null) {
          paramBundle.setClassLoader(getClass().getClassLoader());
        }
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("DatalineRemoteManager", 2, "sendRemoteNotify send failed strNotifyCmd:" + str);
    return null;
  }
  
  private Bundle p(Bundle paramBundle)
  {
    Object localObject1 = null;
    Object localObject2 = paramBundle.getString("invoke_cmd");
    long l1;
    int i;
    int j;
    if (((String)localObject2).equals("DatalineHandler_sendC2CMessage_ToService"))
    {
      l1 = paramBundle.getLong("uCookie");
      localObject1 = paramBundle.getString("toUin");
      i = paramBundle.getInt("c2cCmd");
      j = paramBundle.getInt("subCmd");
      int k = paramBundle.getInt("datalineCmd");
      localObject2 = paramBundle.getByteArray("bodyContent");
      long l2 = paramBundle.getLong("nSessionId");
      paramBundle = new Bundle();
      paramBundle.putParcelable("ToServiceMsg", ((acde)this.app.getBusinessHandler(8)).a(l1, (String)localObject1, i, j, k, (byte[])localObject2, l2));
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return paramBundle;
            if (((String)localObject2).equals("BusinessHandler_sendPbReq"))
            {
              ((acde)this.app.getBusinessHandler(8)).sendPbReq((ToServiceMsg)paramBundle.getParcelable("ToServiceMsg"));
              return null;
            }
            if (!((String)localObject2).equals("DataLineMsgProxy_getInitMpfileTaskRecordList")) {
              break;
            }
            localObject2 = this.app.a().a();
            paramBundle = (Bundle)localObject1;
          } while (localObject2 == null);
          localObject2 = ((acxv)localObject2).el();
          paramBundle = (Bundle)localObject1;
        } while (((List)localObject2).size() <= 0);
        paramBundle = new MessageRecordParcel[((List)localObject2).size()];
        i = 0;
        while (i < paramBundle.length)
        {
          paramBundle[i] = new MessageRecordParcel((MessageRecord)((List)localObject2).get(i));
          i += 1;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putParcelableArray("result", paramBundle);
        return localObject1;
        if (((String)localObject2).equals("DataLineMPfile_browserMpfileInfo"))
        {
          a((MpfileTaskInfo)paramBundle.getParcelable("taskInfo"), paramBundle.getLong("din"));
          return null;
        }
        if (!((String)localObject2).equals("DataLineWifiphoto_showWifiphotoBar")) {
          break;
        }
        i = paramBundle.getInt("what");
        j = paramBundle.getInt("status");
        localObject2 = this.app.getHandler(Conversation.class);
        paramBundle = (Bundle)localObject1;
      } while (localObject2 == null);
      paramBundle = ((MqqHandler)localObject2).obtainMessage(i);
      paramBundle.arg1 = j;
      ((MqqHandler)localObject2).sendMessage(paramBundle);
      return null;
      if (((String)localObject2).equals("DataLineMsgProxy_add_DataLineMsgRecord"))
      {
        a((DataLineMsgRecord)((MessageRecordParcel)paramBundle.getParcelable("Entity")).getMessageRecord(), null);
        return null;
      }
      if (((String)localObject2).equals("DataLineMsgProxy_add_MpfileTaskRecord"))
      {
        a((MpfileTaskRecord)((MessageRecordParcel)paramBundle.getParcelable("Entity")).getMessageRecord(), null);
        return null;
      }
      if (((String)localObject2).equals("DataLineMsgProxy_update"))
      {
        a(paramBundle.getString("tableName"), (ContentValues)paramBundle.getParcelable("value"), paramBundle.getString("whereClause"), paramBundle.getStringArray("whereArgs"), null);
        return null;
      }
      if (((String)localObject2).equals("DataLineMsgProxy_delete"))
      {
        a(paramBundle.getString("tableName"), paramBundle.getString("whereClause"), paramBundle.getStringArray("whereArgs"), null);
        return null;
      }
      boolean bool;
      if (((String)localObject2).equals("RouterHandler_datalineSendCCMsg"))
      {
        bool = RouterHandler.a(paramBundle.getLong("din"), paramBundle.getInt("nCookie"), paramBundle.getByteArray("buffer"));
        paramBundle = new Bundle();
        paramBundle.putBoolean("result", bool);
        return paramBundle;
      }
      if (((String)localObject2).equals("RouterHandler_datalineSendCSMsg"))
      {
        bool = RouterHandler.d(paramBundle.getInt("nUserCmd"), paramBundle.getInt("nCookie"), paramBundle.getByteArray("buffer"));
        paramBundle = new Bundle();
        paramBundle.putBoolean("result", bool);
        return paramBundle;
      }
      if (((String)localObject2).equals("RouterHandler_getSelfDeviceUin"))
      {
        l1 = RouterHandler.y();
        paramBundle = new Bundle();
        paramBundle.putLong("result", l1);
        return paramBundle;
      }
      if (((String)localObject2).equals("DatalineHandler_saveFileManagerEntity"))
      {
        localObject1 = paramBundle.getString("strFilePath");
        i = paramBundle.getInt("nOpType");
        l1 = paramBundle.getLong("sCurDIN");
        paramBundle = ahav.getFileName((String)localObject1);
        localObject2 = this.app.getCurrentAccountUin();
        FileManagerEntity localFileManagerEntity = this.app.a().b(-1L, (String)localObject2, 6000);
        localFileManagerEntity.nOpType = i;
        localFileManagerEntity.fileSize = ahav.getFileSizes((String)localObject1);
        localFileManagerEntity.isReaded = true;
        localFileManagerEntity.peerUin = ((String)localObject2);
        if (l1 == 0L) {}
        for (localFileManagerEntity.peerNick = this.app.getApplication().getString(2131696154);; localFileManagerEntity.peerNick = this.app.getApplication().getString(2131696167))
        {
          localFileManagerEntity.setFilePath((String)localObject1);
          localFileManagerEntity.srvTime = (anaz.gQ() * 1000L);
          localFileManagerEntity.fileName = paramBundle;
          localFileManagerEntity.setCloudType(3);
          localFileManagerEntity.bSend = false;
          localFileManagerEntity.status = 1;
          localFileManagerEntity.fProgress = 1.0F;
          this.app.a().s(localFileManagerEntity);
          return null;
        }
      }
      if (((String)localObject2).equals("DatalineHandler_showWifiphotoActivity"))
      {
        fw();
        return null;
      }
      if (((String)localObject2).equals("BusinessHandler_makeSureProxyServiceStart"))
      {
        eAo();
        return null;
      }
      if (((String)localObject2).equals("DatalineHandler_showWifiphotoAuthDlg"))
      {
        eAp();
        return null;
      }
      if (((String)localObject2).equals("DatalineHandler_dismissReqAuthDlg"))
      {
        eAr();
        return null;
      }
      paramBundle = (Bundle)localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("DatalineRemoteManager", 2, "OnRemoteInvoke unknow invokeCmd");
    return null;
  }
  
  public void Z(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "cancelMpfile");
    localBundle.putString("strDataLineMPFileID", paramString);
    o(localBundle);
  }
  
  public long a(long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "addMpFileDownloadTask");
    localBundle.putLong("taskId", paramLong1);
    localBundle.putLong("din", paramLong2);
    localBundle.putString("fileId", paramString1);
    localBundle.putString("fileName", paramString2);
    localBundle.putLong("totalSize", paramLong3);
    paramString1 = o(localBundle);
    if (paramString1 == null) {
      return -1L;
    }
    return paramString1.getLong("result");
  }
  
  public long a(long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3, long paramLong4, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "addMpFileDownloadTaskWithBuildConn");
    localBundle.putLong("taskId", paramLong1);
    localBundle.putLong("din", paramLong2);
    localBundle.putString("fileId", paramString1);
    localBundle.putString("fileName", paramString2);
    localBundle.putLong("totalSize", paramLong3);
    localBundle.putLong("startPCSessionID", paramLong4);
    localBundle.putInt("PC_Version", paramInt);
    paramString1 = o(localBundle);
    if (paramString1 == null) {
      return -1L;
    }
    return paramString1.getLong("result");
  }
  
  public avip a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getMpFileServerInfo");
    localBundle = o(localBundle);
    if (localBundle == null) {
      return null;
    }
    avip localavip = new avip();
    localavip.serverIp = localBundle.getString("ServerInfo.serverIp");
    localavip.serverPort = localBundle.getInt("ServerInfo.serverPort");
    return localavip;
  }
  
  public MpfileTaskInfo a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getMpFileDownloadTask");
    localBundle.putString("fileId", paramString);
    paramString = o(localBundle);
    if (paramString == null) {
      return null;
    }
    return (MpfileTaskInfo)paramString.getParcelable("result");
  }
  
  public void a(MpfileTaskInfo paramMpfileTaskInfo, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = ahav.a(paramMpfileTaskInfo, paramLong);
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    if (ahav.mI(localFileManagerEntity.getFilePath())) {
      localForwardFileInfo.setType(10000);
    }
    for (;;)
    {
      localForwardFileInfo.Oj(7);
      localForwardFileInfo.p(localFileManagerEntity.nSessionId);
      localForwardFileInfo.setFileName(paramMpfileTaskInfo.fileName);
      localForwardFileInfo.jB(paramMpfileTaskInfo.taskId);
      localForwardFileInfo.setFileSize(paramMpfileTaskInfo.totalSize);
      localForwardFileInfo.setLocalPath(paramMpfileTaskInfo.filePath);
      paramMpfileTaskInfo = Looper.getMainLooper();
      if (Thread.currentThread() == paramMpfileTaskInfo.getThread()) {
        break;
      }
      new Handler(paramMpfileTaskInfo).post(new DatalineRemoteManager.8(this, localFileManagerEntity, localForwardFileInfo));
      return;
      localForwardFileInfo.setType(10009);
    }
    paramMpfileTaskInfo = new Intent(this.app.getApplication().getApplicationContext(), FileBrowserActivity.class);
    paramMpfileTaskInfo.addFlags(268435456);
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 1))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
      paramMpfileTaskInfo.putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
    }
    paramMpfileTaskInfo.putExtra("fileinfo", localForwardFileInfo);
    this.app.getApplication().getApplicationContext().startActivity(paramMpfileTaskInfo);
  }
  
  public void a(Entity paramEntity, ProxyListener paramProxyListener)
  {
    if ((paramEntity instanceof DataLineMsgRecord)) {
      this.app.a(0).a(paramEntity, paramProxyListener);
    }
    while (!(paramEntity instanceof MpfileTaskRecord)) {
      return;
    }
    this.app.a().a().a((MpfileTaskRecord)paramEntity);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "onReceive");
    if (paramToServiceMsg != null) {
      localBundle.putParcelable("ToServiceMsg", paramToServiceMsg);
    }
    if (paramFromServiceMsg != null) {
      localBundle.putParcelable("FromServiceMsg", paramFromServiceMsg);
    }
    if (paramArrayOfByte != null) {
      localBundle.putByteArray("data", paramArrayOfByte);
    }
    d(localBundle, true);
  }
  
  public void a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    if (paramString1.equals(DataLineMsgRecord.tableName())) {
      this.app.a(0).a(paramString1, paramContentValues, paramString2, paramArrayOfString, paramProxyListener);
    }
    while (!paramString1.equals(MpfileTaskRecord.tableName())) {
      return;
    }
    this.app.a().a().a(paramString1, paramContentValues, paramString2, paramArrayOfString, paramProxyListener);
  }
  
  public void a(String paramString1, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    if (paramString1.equals(DataLineMsgRecord.tableName())) {
      this.app.a(0).a(paramString1, paramString2, paramArrayOfString, paramProxyListener);
    }
    while (!paramString1.equals(MpfileTaskRecord.tableName())) {
      return;
    }
    this.app.a().a().a(paramString1, paramString2, paramArrayOfString, paramProxyListener);
  }
  
  public void a(msg_comm.Msg paramMsg)
  {
    paramMsg = paramMsg.toByteArray();
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "handleDataLinePushMsg_210");
    localBundle.putByteArray("msgBytes", paramMsg);
    d(localBundle, true);
  }
  
  public void a(msg_comm.Msg paramMsg, SubMsgType0x7.MsgBody paramMsgBody)
  {
    paramMsg = paramMsg.toByteArray();
    paramMsgBody = paramMsgBody.toByteArray();
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "DoCCPush");
    localBundle.putByteArray("msgBytes", paramMsg);
    localBundle.putByteArray("ccBytes", paramMsgBody);
    d(localBundle, true);
  }
  
  public boolean aT()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getIsNeedReCreateConnection");
    localBundle = o(localBundle);
    if (localBundle == null) {
      return true;
    }
    return localBundle.getBoolean("result");
  }
  
  public String ae()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getMpFileSaveFolder");
    localBundle = o(localBundle);
    if (localBundle == null) {
      return null;
    }
    return localBundle.getString("result");
  }
  
  public String ah()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getMpFileThumbSaveFolder");
    localBundle = o(localBundle);
    if (localBundle == null) {
      return null;
    }
    return localBundle.getString("result");
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "onReceiveRegisterProxySvcPack");
    localBundle.putInt("iPcOnlineStatus", paramInt1);
    localBundle.putInt("iIsSupportDataLine", paramInt2);
    localBundle.putInt("iIsSupportPrintable", paramInt3);
    localBundle.putInt("iIsSupportViewPCFile", paramInt4);
    localBundle.putLong("iPcVersion", paramLong);
    d(localBundle, false);
  }
  
  public void eAn()
  {
    if (this.app.b() != null) {
      this.app.b().deleteObserver(this);
    }
    cPi();
  }
  
  public long f(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "startConnectPC");
    localBundle.putInt("MPFPBtype", paramInt);
    localBundle = o(localBundle);
    if (localBundle == null) {
      return -1L;
    }
    return localBundle.getLong("result");
  }
  
  public long j(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "setMpFileDownloadPwd");
    localBundle.putString("pwd", paramString);
    paramString = o(localBundle);
    if (paramString == null) {
      return -1L;
    }
    return paramString.getLong("result");
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = this.app.b();
    if (paramObservable != null)
    {
      int i = paramObservable.bl();
      paramObservable = new Bundle();
      paramObservable.putString("notify_cmd", "UpdateUnreadMsgsNum");
      paramObservable.putInt("unread", i);
      d(paramObservable, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aviq
 * JD-Core Version:    0.7.0.1
 */