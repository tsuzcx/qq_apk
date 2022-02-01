import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.widget.Toast;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QQProxyForQlink.1;
import cooperation.qlink.QlAndQQInterface;
import cooperation.qlink.QlAndQQInterface.DailogClickInfo;
import cooperation.qlink.QlAndQQInterface.InsertFMFileInfo;
import cooperation.qlink.QlAndQQInterface.ReportInfo;
import cooperation.qlink.QlAndQQInterface.ReportPerformanceInfo;
import cooperation.qlink.QlAndQQInterface.SendFileInfo;
import cooperation.qlink.QlAndQQInterface.SendFileInfos;
import cooperation.qlink.QlAndQQInterface.UserInfo;
import cooperation.qlink.QlAndQQInterface.WorkState;
import cooperation.qlink.QlinkBridgeActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class avhc
{
  private QlAndQQInterface.WorkState a = new QlAndQQInterface.WorkState(false, 1, null, null, 0, 0, false);
  private Timer ah;
  private QQAppInterface app;
  private BroadcastReceiver bV;
  private aqju bf;
  private int ewY;
  private int ewZ = -1;
  private BroadcastReceiver qqAccountReceiver;
  
  public avhc(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private void a(Activity paramActivity, int paramInt, String paramString, rwe paramrwe)
  {
    if (paramActivity == null) {
      return;
    }
    String str = acfp.m(2131712110);
    if (1 == paramInt) {
      paramString = str + acfp.m(2131712113) + paramString + acfp.m(2131712108);
    }
    for (;;)
    {
      aqha.a(paramActivity, 230, paramActivity.getString(2131700492), paramString, 2131700486, 2131700486, new avhl(this, paramrwe), null).show();
      return;
      if (2 == paramInt) {
        paramString = str + acfp.m(2131712112) + paramString + acfp.m(2131712107);
      } else {
        paramString = acfp.m(2131712109);
      }
    }
  }
  
  public static void c(Context paramContext, int paramInt, Bundle paramBundle)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQProxyForQlink", 2, "[QLINK] QQ - startQlink failed context=null!");
      }
      Toast.makeText(BaseApplication.getContext(), acfp.m(2131712111), 0).show();
      return;
    }
    Intent localIntent = new Intent(paramContext, QlinkBridgeActivity.class);
    localIntent.putExtra("_from_", paramInt);
    if (paramBundle != null) {
      localIntent.putExtra("_param_", paramBundle);
    }
    if ((paramContext instanceof sse)) {
      localIntent.setFlags(276824064);
    }
    if ((9 == paramInt) || (10 == paramInt)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  /* Error */
  private void eAa()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 169	avhc:ah	Ljava/util/Timer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: ldc 108
    //   16: iconst_1
    //   17: ldc 171
    //   19: invokestatic 174	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aload_0
    //   23: new 176	java/util/Timer
    //   26: dup
    //   27: invokespecial 177	java/util/Timer:<init>	()V
    //   30: putfield 169	avhc:ah	Ljava/util/Timer;
    //   33: aload_0
    //   34: getfield 169	avhc:ah	Ljava/util/Timer;
    //   37: new 179	cooperation/qlink/QQProxyForQlink$9
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 181	cooperation/qlink/QQProxyForQlink$9:<init>	(Lavhc;)V
    //   45: lconst_0
    //   46: ldc2_w 182
    //   49: invokevirtual 187	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
    //   52: goto -41 -> 11
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	avhc
    //   6	2	1	localTimer	Timer
    //   55	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	55	finally
    //   14	52	55	finally
  }
  
  private void eAb()
  {
    try
    {
      if (this.ah != null)
      {
        QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ cancelQlinkHeartTimer");
        this.ah.cancel();
        this.ah = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void eAc()
  {
    if (this.qqAccountReceiver != null)
    {
      if ((this.app == null) || (this.app.getApp() == null)) {
        QLog.e("QQProxyForQlink", 1, "unregisterAccountReceiver error.");
      }
    }
    else {
      return;
    }
    this.app.getApp().unregisterReceiver(this.qqAccountReceiver);
    this.qqAccountReceiver = null;
  }
  
  /* Error */
  private void eAd()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 208	avhc:bV	Landroid/content/BroadcastReceiver;
    //   8: ifnonnull +58 -> 66
    //   11: aload_0
    //   12: new 210	avhe
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 211	avhe:<init>	(Lavhc;)V
    //   20: putfield 208	avhc:bV	Landroid/content/BroadcastReceiver;
    //   23: new 213	android/content/IntentFilter
    //   26: dup
    //   27: invokespecial 214	android/content/IntentFilter:<init>	()V
    //   30: astore_2
    //   31: aload_2
    //   32: ldc 216
    //   34: invokevirtual 220	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   37: aload_0
    //   38: getfield 34	avhc:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   41: ifnull +11 -> 52
    //   44: aload_0
    //   45: getfield 34	avhc:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   48: invokevirtual 200	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   51: astore_1
    //   52: aload_1
    //   53: ifnull +16 -> 69
    //   56: aload_1
    //   57: aload_0
    //   58: getfield 208	avhc:bV	Landroid/content/BroadcastReceiver;
    //   61: aload_2
    //   62: invokevirtual 224	com/tencent/qphone/base/util/BaseApplication:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   65: pop
    //   66: aload_0
    //   67: monitorexit
    //   68: return
    //   69: ldc 108
    //   71: iconst_1
    //   72: ldc 226
    //   74: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_0
    //   78: aconst_null
    //   79: putfield 208	avhc:bV	Landroid/content/BroadcastReceiver;
    //   82: goto -16 -> 66
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	avhc
    //   1	56	1	localBaseApplication	BaseApplication
    //   85	4	1	localObject	Object
    //   30	32	2	localIntentFilter	IntentFilter
    // Exception table:
    //   from	to	target	type
    //   4	37	85	finally
    //   37	52	85	finally
    //   56	66	85	finally
    //   69	82	85	finally
  }
  
  /* Error */
  private void eAe()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 208	avhc:bV	Landroid/content/BroadcastReceiver;
    //   6: ifnull +28 -> 34
    //   9: aload_0
    //   10: getfield 34	avhc:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: ifnull +13 -> 26
    //   16: aload_0
    //   17: getfield 34	avhc:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 200	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   23: ifnonnull +14 -> 37
    //   26: ldc 108
    //   28: iconst_1
    //   29: ldc 229
    //   31: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: getfield 34	avhc:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   41: invokevirtual 200	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   44: aload_0
    //   45: getfield 208	avhc:bV	Landroid/content/BroadcastReceiver;
    //   48: invokevirtual 206	com/tencent/qphone/base/util/BaseApplication:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 208	avhc:bV	Landroid/content/BroadcastReceiver;
    //   56: goto -22 -> 34
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	avhc
    //   59	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   26	34	59	finally
    //   37	56	59	finally
  }
  
  private void registerAccountReceiver()
  {
    IntentFilter localIntentFilter;
    if (this.qqAccountReceiver == null)
    {
      this.qqAccountReceiver = new avhd(this);
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
      localIntentFilter.addAction("mqq.intent.action.LOGOUT");
      if (this.app == null) {
        break label95;
      }
    }
    label95:
    for (BaseApplication localBaseApplication = this.app.getApp();; localBaseApplication = null)
    {
      if (localBaseApplication != null)
      {
        localBaseApplication.registerReceiver(this.qqAccountReceiver, localIntentFilter);
        return;
      }
      QLog.e("QQProxyForQlink", 1, "registerAccountReceiver error. fail");
      this.qqAccountReceiver = null;
      return;
    }
  }
  
  public int PC()
  {
    return this.a.mTransferingCount;
  }
  
  public void ZU(int paramInt)
  {
    int i = this.a.mTransferingCount;
    this.a.mTransferingCount = paramInt;
    if (i != this.a.mTransferingCount)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QQProxyForQlink", 4, "[QLINK]-QQ UI_LOG:notifyGoingonTransChanged.count:" + paramInt);
      }
      MqqHandler localMqqHandler = this.app.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(1134025, null).sendToTarget();
      }
    }
  }
  
  public void ZV(int paramInt)
  {
    if (1 == paramInt) {
      ahav.eo(this.app.getApplication().getApplicationContext());
    }
  }
  
  public QlAndQQInterface.WorkState a()
  {
    return this.a;
  }
  
  public void a(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3, String paramString)
  {
    if (this.bf != null) {}
    label403:
    for (;;)
    {
      return;
      String str2 = aqgv.A(this.app, this.a.mPeerUin);
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (!this.a.mPeerUin.equalsIgnoreCase(str2)) {}
      }
      else
      {
        if (this.a.mPeerNick == null) {
          break label224;
        }
        str1 = this.a.mPeerNick;
      }
      if (this.a.mMode == 1)
      {
        gK("0X8004854", 1);
        paramOnClickListener3 = paramActivity.getResources().getString(2131700532) + str1 + paramActivity.getResources().getString(2131700533);
        if ((paramString != null) && (!paramString.equalsIgnoreCase(this.a.mPeerUin)))
        {
          this.bf = aqha.a(paramActivity, 230, paramActivity.getResources().getString(2131700493), paramOnClickListener3, paramActivity.getResources().getString(2131700534), paramActivity.getResources().getString(2131700534), paramOnClickListener2, null);
          label194:
          this.bf.show();
        }
      }
      for (;;)
      {
        if (this.bf == null) {
          break label403;
        }
        this.bf.setOnDismissListener(new avhi(this));
        return;
        label224:
        str1 = this.a.mPeerUin;
        break;
        this.bf = aqha.a(paramActivity, 230, paramActivity.getResources().getString(2131700493), paramOnClickListener3, paramActivity.getResources().getString(2131700534), paramActivity.getResources().getString(2131700535), paramOnClickListener1, paramOnClickListener2);
        break label194;
        if (this.a.mMode == 2)
        {
          gK("0X8004856", 1);
          paramOnClickListener1 = str1 + paramActivity.getResources().getString(2131700531);
          this.bf = aqha.a(paramActivity, 230, paramActivity.getResources().getString(2131700493), paramOnClickListener1, paramActivity.getResources().getString(2131700530), paramActivity.getResources().getString(2131700530), paramOnClickListener3, null);
          this.bf.show();
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("QQProxyForQlink", 2, "[QLINK] QQ - working but op err");
        }
      }
    }
  }
  
  public void a(Activity paramActivity, ArrayList<String> paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    if (paramActivity == null) {}
    label166:
    do
    {
      return;
      switch (paramInt2)
      {
      }
      for (;;)
      {
        if (this.a.mWorking) {
          break label166;
        }
        Object localObject = null;
        paramString = localObject;
        if (paramArrayList != null)
        {
          paramString = localObject;
          if (paramArrayList.size() > 0)
          {
            paramString = new Bundle();
            paramString.putStringArrayList("string_filepaths", paramArrayList);
          }
        }
        c(paramActivity, paramInt1, paramString);
        if (!paramBoolean) {
          break;
        }
        paramActivity.finish();
        return;
        gK("0X800484F", 1);
        continue;
        gK("0X800485B", 1);
        continue;
        gK("0X800485E", 1);
        continue;
        gK("0X8004858", 1);
        continue;
        gK("0X800566F", 1);
      }
      if ((15 != paramInt1) || ((paramArrayList != null) && (paramArrayList.size() != 0))) {
        break;
      }
      c(paramActivity, paramInt1, new Bundle());
    } while (!paramBoolean);
    paramActivity.finish();
    return;
    a(paramActivity, new avhf(this, paramArrayList, paramActivity, paramInt1, paramBoolean), new avhg(this), new avhh(this), paramString);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap)
  {
    if (QLog.isDevelopLevel())
    {
      Object localObject2 = "";
      Object localObject1 = localObject2;
      if (paramHashMap != null)
      {
        localObject1 = localObject2;
        if (paramHashMap.size() > 0)
        {
          localObject2 = paramHashMap.entrySet().iterator();
          Map.Entry localEntry;
          for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + " " + (String)localEntry.getKey() + ":" + (String)localEntry.getValue()) {
            localEntry = (Map.Entry)((Iterator)localObject2).next();
          }
        }
      }
      QLog.d("QQProxyForQlink", 4, "QLINK_PERFORMANCE: tagName=" + paramString2 + " uin:" + paramString1 + " success:" + paramBoolean + (String)localObject1);
    }
    avhp.b(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap);
  }
  
  public void a(AppActivity paramAppActivity, String paramString, rwe paramrwe)
  {
    if ((paramAppActivity == null) || (paramString == null)) {
      return;
    }
    avho.a locala = avho.a(paramString);
    if (locala == null)
    {
      aqha.a(paramAppActivity, 230, paramAppActivity.getString(2131700492), paramAppActivity.getString(2131700512), 2131700486, 2131700486, new avhj(this, paramrwe), null).show();
      return;
    }
    if (this.a.mWorking)
    {
      a(paramAppActivity, this.a.mMode, this.a.mPeerNick, paramrwe);
      return;
    }
    boolean bool = "qlink".equalsIgnoreCase(paramAppActivity.getIntent().getStringExtra("from"));
    if (bool) {
      abH(1);
    }
    paramrwe = new Bundle();
    paramrwe.putString("url", paramString);
    paramrwe.putString("key", locala.key);
    paramrwe.putString("peerUin", locala.peerUin);
    paramrwe.putString("peerNick", locala.peerNick);
    paramrwe.putString("peerOS", locala.cKQ);
    paramrwe.putString("apSSID", locala.cKR);
    paramrwe.putString("preSharedKey", locala.preSharedKey);
    paramrwe.putBoolean("fromqlink", bool);
    paramString = paramAppActivity.getIntent().getStringExtra("subfrom");
    if (paramString != null) {
      paramrwe.putString("subfrom", paramString);
    }
    this.app.a();
    c(paramAppActivity, 11, paramrwe);
    paramAppActivity.finish();
  }
  
  public void a(AppActivity paramAppActivity, rwe paramrwe)
  {
    if (paramAppActivity == null) {
      return;
    }
    aqha.a(paramAppActivity, 230, paramAppActivity.getString(2131700510), paramAppActivity.getString(2131700511), 2131700486, 2131700486, new avhk(this, paramrwe), null).show();
  }
  
  public void abH(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("cmd", paramInt);
    this.app.a().f("cmd.sendsimplecmd", localBundle);
  }
  
  public void aoq()
  {
    QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ UI_LOG:QQProxyForQlink. onAppDestroy");
    eAc();
    eAe();
    eAb();
    this.app = null;
  }
  
  public boolean b(QlAndQQInterface.SendFileInfos paramSendFileInfos)
  {
    boolean bool = true;
    this.app.a().gK("0X8004763", 1);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable(QlAndQQInterface.cKP, paramSendFileInfos);
    int i = this.app.a().f("cmd.sendfilemsgs", localBundle);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ QQ2QlSendFileMsgs:" + i);
    }
    if (i == -1) {
      bool = false;
    }
    return bool;
  }
  
  public void c(QlAndQQInterface.DailogClickInfo paramDailogClickInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable(QlAndQQInterface.cKP, paramDailogClickInfo);
    int i = this.app.a().f("cmd.senddailogclickinfo", localBundle);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ sendDailogClick:" + i);
    }
  }
  
  public void c(QlAndQQInterface.InsertFMFileInfo paramInsertFMFileInfo)
  {
    if (paramInsertFMFileInfo == null) {
      return;
    }
    String str = ahav.getFileName(paramInsertFMFileInfo.filePath);
    long l1 = ahav.getFileSizes(paramInsertFMFileInfo.filePath);
    long l2 = anbi.d(-1000).uniseq;
    FileManagerEntity localFileManagerEntity = this.app.a().b(l2, paramInsertFMFileInfo.uin, 0);
    localFileManagerEntity.setCloudType(5);
    localFileManagerEntity.nSessionId = paramInsertFMFileInfo.sessionId;
    localFileManagerEntity.setFilePath(paramInsertFMFileInfo.filePath);
    localFileManagerEntity.nFileType = ahav.getFileType(paramInsertFMFileInfo.filePath);
    localFileManagerEntity.strThumbPath = paramInsertFMFileInfo.thumbPath;
    localFileManagerEntity.fileName = str;
    localFileManagerEntity.fileSize = l1;
    localFileManagerEntity.srvTime = (anaz.gQ() * 1000L);
    localFileManagerEntity.msgSeq = ahav.bA();
    localFileManagerEntity.msgUid = ahav.ge();
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = paramInsertFMFileInfo.uin;
    localFileManagerEntity.nOlSenderProgress = paramInsertFMFileInfo.transSeq;
    acff localacff = (acff)this.app.getManager(51);
    if (localacff.e(String.valueOf(localFileManagerEntity.peerUin)) != null)
    {
      localFileManagerEntity.peerType = 0;
      localFileManagerEntity.peerNick = ahav.a(this.app, paramInsertFMFileInfo.uin, null, 0);
      localFileManagerEntity.status = 1;
      if ((!localacff.isFriend(paramInsertFMFileInfo.uin)) && (!paramInsertFMFileInfo.bSend)) {
        break label356;
      }
      localFileManagerEntity.nOpType = 0;
      localFileManagerEntity.bSend = true;
      aoon.a(paramInsertFMFileInfo.filePath, 0L, 0, true);
      this.app.a().s(localFileManagerEntity);
    }
    for (;;)
    {
      this.app.a().u(localFileManagerEntity);
      QLog.d("QQProxyForQlink", 4, "insertFM sessionid:" + paramInsertFMFileInfo.sessionId + " transeq:" + localFileManagerEntity.nOlSenderProgress + " filePath:" + paramInsertFMFileInfo.filePath);
      return;
      localFileManagerEntity.peerType = 1003;
      break;
      label356:
      localFileManagerEntity.nOpType = 1;
      localFileManagerEntity.bSend = false;
      aoon.a(paramInsertFMFileInfo.filePath, l1, 0, false, null);
      aojs.a(this.app.getAccount(), str, 0, null);
      this.app.a().s(localFileManagerEntity);
    }
  }
  
  public void d(QlAndQQInterface.UserInfo paramUserInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable(QlAndQQInterface.cKP, paramUserInfo);
    int i = this.app.a().f("cmd.senduserinfo", localBundle);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ sendUserInfo:" + i);
    }
  }
  
  public void dU(Bundle paramBundle)
  {
    paramBundle = (QlAndQQInterface.WorkState)paramBundle.getSerializable("wstate");
    this.a.mForIphone = paramBundle.mForIphone;
    this.a.mMode = paramBundle.mMode;
    this.a.mPeerNick = paramBundle.mPeerNick;
    this.a.mPeerUin = paramBundle.mPeerUin;
    this.a.mState = paramBundle.mState;
    this.a.mTransferingCount = paramBundle.mTransferingCount;
    this.a.mWorking = paramBundle.mWorking;
  }
  
  public void dV(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (paramBundle.getBoolean("qlinkexit", false))
      {
        QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ qlink is exit:");
        this.a = new QlAndQQInterface.WorkState(false, 1, null, null, 0, 0, false);
        eAb();
        return;
      }
      paramBundle = (QlAndQQInterface.WorkState)paramBundle.getSerializable("wstate");
      if (paramBundle != null)
      {
        this.a.mForIphone = paramBundle.mForIphone;
        this.a.mMode = paramBundle.mMode;
        this.a.mPeerNick = paramBundle.mPeerNick;
        this.a.mPeerUin = paramBundle.mPeerUin;
        this.a.mState = paramBundle.mState;
        this.a.mTransferingCount = paramBundle.mTransferingCount;
        this.a.mWorking = paramBundle.mWorking;
      }
    }
    for (;;)
    {
      this.ewY = 0;
      return;
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ respHeart. no wstate error");
      continue;
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ respHeart. info = null");
    }
  }
  
  public void dhm()
  {
    QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ UI_LOG:QQProxyForQlink. onAppInit");
    if ((this.app != null) && (this.app.getApp() != null)) {
      ThreadManager.executeOnSubThread(new QQProxyForQlink.1(this));
    }
  }
  
  public void ea(Bundle paramBundle)
  {
    int i = paramBundle.getInt("Event", 0);
    switch (i)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("QQProxyForQlink", 2, "[QLINK] QQ - unimplement event[" + i + "]");
      }
    case 18: 
    case 19: 
      do
      {
        return;
        gK(paramBundle.getString("action_name"), paramBundle.getInt(QlAndQQInterface.cKP));
        return;
        paramBundle = (QlAndQQInterface.ReportInfo)paramBundle.getSerializable(QlAndQQInterface.cKP);
      } while (!(paramBundle.data instanceof QlAndQQInterface.ReportPerformanceInfo));
      paramBundle = (QlAndQQInterface.ReportPerformanceInfo)paramBundle.data;
      a(paramBundle.mUin, paramBundle.mTagName, paramBundle.mSuccess, paramBundle.mDuration, paramBundle.mSize, paramBundle.mParams);
      return;
    case 20: 
      avhp.erH();
      return;
    case 21: 
      avhp.erI();
      return;
    case 15: 
      c((QlAndQQInterface.InsertFMFileInfo)paramBundle.getSerializable(QlAndQQInterface.cKP));
      return;
    case 16: 
      ZU(paramBundle.getInt(QlAndQQInterface.cKP));
      return;
    case 17: 
      getUserInfo(paramBundle.getString(QlAndQQInterface.cKP));
      return;
    case 22: 
      erJ();
      return;
    case 23: 
      dU(paramBundle.getBundle(QlAndQQInterface.cKP));
      return;
    case 24: 
      dV(paramBundle.getBundle(QlAndQQInterface.cKP));
      return;
    }
    ZV(paramBundle.getInt(QlAndQQInterface.cKP));
  }
  
  public void erJ()
  {
    QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ nofityQlinkStart");
    eAa();
  }
  
  public void ezW() {}
  
  public void ezX()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("param", 1);
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().f("cmd.sendheart", localBundle);
    }
  }
  
  public void ezY() {}
  
  public void ezZ()
  {
    if (this.bf != null)
    {
      this.bf.dismiss();
      this.bf = null;
    }
  }
  
  public boolean g(String paramString, List<String> paramList)
  {
    if ((paramList == null) || (paramString == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("QQProxyForQlink", 2, "[QLINK]-QQ sendFileMsgs. param error");
      }
    }
    do
    {
      return false;
      if (paramList.size() > 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QQProxyForQlink", 2, "[QLINK]-QQ sendFileMsgs. no any file");
    return false;
    QlAndQQInterface.SendFileInfos localSendFileInfos = new QlAndQQInterface.SendFileInfos();
    localSendFileInfos.strUin = paramString;
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      QlAndQQInterface.SendFileInfo localSendFileInfo = new QlAndQQInterface.SendFileInfo();
      localSendFileInfo.sessionid = ahav.d().longValue();
      localSendFileInfo.filePath = paramList;
      localSendFileInfo.fileSize = ahav.getFileSizes(paramList);
      localSendFileInfos.infos.add(localSendFileInfo);
    }
    return b(localSendFileInfos);
  }
  
  public void gK(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProxyForQlink", 4, "QLINK_CLICK_EVENT: act=" + paramString + " count:" + paramInt);
    }
    anot.b(this.app, "CliOper", "", "", paramString, paramString, 0, paramInt, 0, "", "", "", "");
  }
  
  public void getUserInfo(String paramString)
  {
    String str = aqgv.o(this.app, paramString);
    acff localacff = (acff)this.app.getManager(51);
    QlAndQQInterface.UserInfo localUserInfo = new QlAndQQInterface.UserInfo();
    localUserInfo.uin = paramString;
    if (str != null) {}
    for (localUserInfo.nick = str;; localUserInfo.nick = paramString)
    {
      paramString = localacff.e(paramString);
      localUserInfo.isFriend = false;
      if (paramString != null) {
        localUserInfo.isFriend = paramString.isFriend();
      }
      d(localUserInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     avhc
 * JD-Core Version:    0.7.0.1
 */