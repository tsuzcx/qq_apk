package com.tencent.av.service;

import accv;
import accv.b;
import acdt;
import acdu;
import acfd;
import acff;
import acfp;
import acgr;
import acgs;
import achq;
import acms;
import acnd;
import acrc;
import afem;
import affl;
import ajdo;
import ajrs;
import ajrw;
import aljw;
import alkd;
import alkd.a;
import alkf;
import altq;
import altt;
import anaz;
import anbi;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import ankq;
import anre;
import apqk;
import apsw;
import apsw.f;
import aqdf;
import aqdf.a;
import aqdj;
import aqgo;
import aqgv;
import aqhu;
import aqiw;
import aqji;
import aqjl;
import aqmj;
import axcd;
import axce;
import axce.a;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import igd;
import igq;
import ihs;
import irz;
import itw;
import itz;
import iua.a;
import iub;
import iud;
import iuf;
import iuh;
import iuj;
import iuk;
import iul;
import ium;
import iun;
import iuo;
import iup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import jla;
import jll;
import jnl;
import jnm;
import jou;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import org.json.JSONObject;
import syw;
import tas;
import top;
import ujt;

public class QQServiceForAV
  extends AppService
  implements Observer
{
  public static IBinder b;
  public String OD = null;
  boolean Vf = false;
  private boolean Vg;
  public boolean Vh = false;
  private boolean Vi;
  public acfd a;
  public acnd a;
  ajrw jdField_a_of_type_Ajrw = new iul(this);
  alkd.a jdField_a_of_type_Alkd$a = new iuf(this);
  aqdf.a jdField_a_of_type_Aqdf$a = new iud(this);
  aqdf jdField_a_of_type_Aqdf = null;
  private a jdField_a_of_type_ComTencentAvServiceQQServiceForAV$a;
  private b jdField_a_of_type_ComTencentAvServiceQQServiceForAV$b;
  private c jdField_a_of_type_ComTencentAvServiceQQServiceForAV$c;
  private d jdField_a_of_type_ComTencentAvServiceQQServiceForAV$d;
  final iua.a jdField_a_of_type_Iua$a = new e();
  private final achq jdField_b_of_type_Achq = new iuh(this);
  private igq jdField_b_of_type_Igq;
  private ServiceConnection d = new iuk(this);
  public ArrayList<String> iB = new ArrayList();
  public ArrayList<String> iC = new ArrayList();
  public String mBindId = null;
  public int mBindType = 0;
  public final RemoteCallbackList<itz> mCallbacks = new RemoteCallbackList();
  public String mFriendUin = null;
  long mStartTime = 9223372036854775807L;
  public int mUinType = 0;
  public String nS = null;
  long og = -1L;
  
  public QQServiceForAV()
  {
    this.jdField_a_of_type_Acnd = new ium(this);
    this.jdField_a_of_type_Acfd = new iun(this);
  }
  
  private boolean cC(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      switch (i)
      {
      case 6: 
      default: 
        return false;
      }
      return true;
    }
    catch (Exception localException)
    {
      igd.aL("QQServiceForAV", "isTroopGiftGrayMsg: serviceType(" + paramString + ") cannot be parse to int");
    }
    return false;
  }
  
  public static boolean vx()
  {
    return jdField_b_of_type_AndroidOsIBinder != null;
  }
  
  public void E(long paramLong1, long paramLong2)
  {
    Object localObject2 = (QQAppInterface)getAppRuntime();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (QQAppInterface)getAppRuntime();
    }
    if (localObject1 != null)
    {
      localObject2 = new Intent();
      ((Intent)localObject2).setAction("tencent.video.q2v.GroupSystemMsg");
      ((Intent)localObject2).putExtra("type", 3);
      ((Intent)localObject2).putExtra("relationType", 1);
      ((Intent)localObject2).putExtra("relationId", paramLong1);
      ((Intent)localObject2).putExtra("userUin", paramLong2);
      ((Intent)localObject2).putExtra("needSendCmd", false);
      QLog.w("QQServiceForAV", 1, "sendAdminToVideo, troopUin[" + paramLong1 + "], userUin[" + paramLong2 + "], Action[" + "tencent.video.q2v.GroupSystemMsg" + "], type[" + 3 + "]");
      ((QQAppInterface)localObject1).getApp().sendBroadcast((Intent)localObject2);
    }
  }
  
  public Bundle a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    int i = 0;
    Object localObject1;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("getDataFromVideoProcess, mainCmd = ").append(paramInt1).append(",subCmd = ").append(paramInt2).append(",bundle = ").append(paramBundle).append(",mCallbacks =");
      if (this.mCallbacks != null)
      {
        bool = true;
        QLog.w("QQServiceForAV", 1, bool);
      }
    }
    else
    {
      localObject1 = null;
      if (this.mCallbacks == null) {
        break label217;
      }
    }
    label214:
    for (;;)
    {
      synchronized (this.mCallbacks)
      {
        int j = this.mCallbacks.beginBroadcast();
        if (i < j)
        {
          try
          {
            Object localObject2 = this.mCallbacks.getBroadcastCookie(i);
            if ((localObject2 == null) || (!(localObject2 instanceof String)) || (!localObject2.equals("video_process_cookie"))) {
              break label214;
            }
            localObject2 = ((itz)this.mCallbacks.getBroadcastItem(i)).a("video_process_cookie", paramInt1, paramInt2, paramBundle);
            localObject1 = localObject2;
            i += 1;
          }
          catch (RemoteException paramBundle) {}
          bool = false;
          break;
        }
        this.mCallbacks.finishBroadcast();
        return localObject1;
      }
    }
    label217:
    return null;
  }
  
  public boolean a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      synchronized (this.mCallbacks)
      {
        int j = this.mCallbacks.beginBroadcast();
        int i = 0;
        bool1 = false;
        if (i < j) {}
        try
        {
          Object localObject = this.mCallbacks.getBroadcastCookie(i);
          boolean bool2 = bool1;
          if ((localObject instanceof String))
          {
            bool2 = bool1;
            if (localObject.equals("video_process_cookie"))
            {
              ((itz)this.mCallbacks.getBroadcastItem(i)).c(paramString, paramInt, paramArrayOfByte);
              bool2 = true;
            }
          }
          i += 1;
          bool1 = bool2;
        }
        catch (Throwable paramString)
        {
          if (!QLog.isColorLevel()) {
            break label217;
          }
        }
        this.mCallbacks.finishBroadcast();
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder().append("onReceiveChatRoomPushMsg, msgType[").append(paramInt).append("], bytes[");
          if (paramArrayOfByte == null)
          {
            paramInt = 0;
            QLog.w("QQServiceForAV", 1, paramInt + "], ret[" + bool1 + "]");
          }
        }
        else
        {
          return bool1;
          QLog.i("QQServiceForAV", 2, "onReceiveChatRoomPushMsg", paramString);
        }
      }
      paramInt = paramArrayOfByte.length;
      continue;
      label217:
      boolean bool1 = false;
    }
  }
  
  public AppRuntime getAppRuntime()
  {
    return this.app;
  }
  
  public void getFollowStatus(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    acms localacms = (acms)localQQAppInterface.getBusinessHandler(20);
    if (localacms != null) {}
    while (!QLog.isColorLevel()) {
      try
      {
        localQQAppInterface.addObserver(this.jdField_a_of_type_Acnd);
        localacms.getFollowStatus(paramString);
        return;
      }
      catch (Exception paramString)
      {
        localQQAppInterface.removeObserver(this.jdField_a_of_type_Acnd);
        igd.aL("nearby.video.follow", "QQServiceForAV, getFollowStatus exp:" + paramString.getMessage());
        return;
      }
    }
    QLog.e("QQServiceForAV", 2, "QQServiceForAV, getFollowStatus, troopHandler==null");
  }
  
  public void j(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("client_ver", "3.4.4");
      localJSONObject.put("from", paramString2);
      if ("1".equals(paramString2))
      {
        paramString2 = localQQAppInterface.a().R(paramString1);
        if (paramString2 != null) {
          localJSONObject.put("chat_sig", new String(aqgo.encode(paramString2, 0)));
        }
      }
      localJSONObject.put("targetuin", paramString1);
      localJSONObject.put("operation", paramString3);
      localJSONObject.put("sourceid", 3088);
      localJSONObject.put("sub_sourceid", paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.video.follow", 2, "QQServiceForAV, followUser:" + localJSONObject);
      }
      paramString2 = new NewIntent(localQQAppInterface.getApplication().getApplicationContext(), jnl.class);
      paramString2.putExtra("cmd", "MQUpdateSvc_com_qq_buluo.web.follow_user");
      WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
      localWebSsoRequestBody.type.set(0);
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      paramString2.putExtra("data", localWebSsoRequestBody.toByteArray());
      paramString2.setObserver(new iuj(this, paramString1, paramString3));
      localQQAppInterface.startServlet(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("nearby.video.follow", 2, "QQServiceForAV, followUser 1:" + paramString1.toString());
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onBind");
    }
    this.Vh = true;
    QLog.i("QQServiceForAV", 1, "mBindVideoProcessConn intent=" + paramIntent);
    if (!this.Vi) {
      paramIntent = new Intent(BaseApplicationImpl.getContext(), AVServiceForQQ.class);
    }
    try
    {
      boolean bool = BaseApplicationImpl.getContext().bindService(paramIntent, this.d, 1);
      QLog.i("QQServiceForAV", 1, "mBindVideoProcessConn bind service return " + bool);
      return this.jdField_a_of_type_Iua$a;
    }
    catch (Throwable paramIntent)
    {
      for (;;)
      {
        QLog.e("QQServiceForAV", 1, "mHasBindToVideoProcess exception:" + paramIntent, paramIntent);
      }
    }
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onCreate");
    }
    if ((getAppRuntime() instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
      if (localQQAppInterface != null) {
        this.nS = localQQAppInterface.getCurrentAccountUin();
      }
    }
    super.onCreate();
    jla.bE(this);
  }
  
  public void onDestroy()
  {
    igd.aK("QQServiceForAV", "onDestroy");
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (this.jdField_a_of_type_Aqdf != null)
    {
      this.jdField_a_of_type_Aqdf.destory();
      this.jdField_a_of_type_Aqdf = null;
    }
    this.Vh = false;
    localQQAppInterface.removeObserver(this.jdField_a_of_type_Acfd);
    jdField_b_of_type_AndroidOsIBinder = null;
    if (this.jdField_b_of_type_Igq != null)
    {
      this.jdField_b_of_type_Igq.doDestroy();
      this.jdField_b_of_type_Igq = null;
    }
    super.onDestroy();
    jla.bF(this);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onStartCommand flags: " + paramInt1 + ", startId: " + paramInt2);
    }
    if ((getAppRuntime() instanceof QQAppInterface))
    {
      paramIntent = (QQAppInterface)getAppRuntime();
      if (paramIntent != null) {
        this.nS = paramIntent.getCurrentAccountUin();
      }
    }
    return 3;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    igd.aK("QQServiceForAV", "onUnbind");
    this.Vh = false;
    this.Vi = false;
    return super.onUnbind(paramIntent);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "update invalid data!");
      }
    }
    Object localObject;
    MessageRecord localMessageRecord;
    long l1;
    long l2;
    label332:
    String str;
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                localObject = (QQAppInterface)getAppRuntime();
                if (QLog.isColorLevel()) {
                  QLog.d("QQServiceForAV", 2, "update data: " + paramObject + ", mLastUniseq: " + this.og + ",mStartTime:" + this.mStartTime);
                }
              } while (!(paramObject instanceof MessageRecord));
              localMessageRecord = (MessageRecord)paramObject;
            } while ((localMessageRecord == null) || (localMessageRecord.isSendFromLocal()));
            if ((this.nS != null) && (localObject != null))
            {
              paramObservable = (Observable)localObject;
              if (((QQAppInterface)localObject).b() != null) {}
            }
            else
            {
              paramObject = (QQAppInterface)getAppRuntime();
              paramObservable = paramObject;
              if (paramObject != null)
              {
                this.nS = paramObject.getCurrentAccountUin();
                paramObservable = paramObject;
              }
            }
          } while ((TextUtils.isEmpty(this.nS)) || (TextUtils.isEmpty(this.mFriendUin)));
          if ((this.nS.equals(localMessageRecord.senderuin)) || ((!localMessageRecord.isSend()) && (!localMessageRecord.isread)) || (localMessageRecord.msgtype == -2035) || (localMessageRecord.msgtype == -2038) || ((localMessageRecord.msgtype == 2024) && (cC(localMessageRecord.getExtInfoFromExtStr("gray_tips_serviceType"))))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QQServiceForAV", 2, "update  continue 1");
        return;
        l1 = localMessageRecord.time;
        l2 = localMessageRecord.uniseq;
        if (this.og != -1L) {
          break label332;
        }
        if (l1 >= this.mStartTime) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQServiceForAV", 2, "update  continue 2");
      return;
      this.og = l2;
      paramObject = localMessageRecord.selfuin;
      str = localMessageRecord.frienduin;
      localObject = localMessageRecord.senderuin;
      i = (int)localMessageRecord.vipBubbleID;
    } while ((l2 < this.og) || (paramObject == null) || (str == null) || (localObject == null) || (!this.nS.equals(paramObject)) || (!this.mFriendUin.equals(str)));
    int j = localMessageRecord.msgtype;
    switch (j)
    {
    default: 
      paramObservable = null;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, ", vipBubbleId: " + i + ", senderUin: " + (String)localObject + ", msgtype: " + j + ", msg: " + paramObservable + ", time: " + l1 + ", uinseq: " + l2 + ", mLastUniseq: " + this.og);
      }
      if (paramObservable != null) {}
      this.og = (1L + l2);
      return;
      paramObject = localMessageRecord.msg;
      paramObservable = paramObject;
      if (paramObject != null)
      {
        paramObservable = paramObject;
        if (paramObject.indexOf("http://maps.google.com/maps?q=") != -1)
        {
          paramObservable = getResources().getString(2131721779);
          continue;
          paramObservable = getResources().getString(2131721780);
          continue;
          paramObservable = acfp.m(2131712132);
          continue;
          paramObservable = getResources().getString(2131721781);
          continue;
          paramObservable = getResources().getString(2131721778);
          continue;
          paramObservable = getResources().getString(2131721782);
          continue;
          paramObservable = getResources().getString(2131721777);
          continue;
          paramObservable = getResources().getString(2131721784);
          continue;
          if ((localMessageRecord instanceof MessageForMixedMsg))
          {
            paramObservable = (String)MessageForMixedMsg.getTextFromMixedMsg((MessageForMixedMsg)localMessageRecord);
            continue;
            try
            {
              if ((top.fL(localMessageRecord.istroop)) && ((localMessageRecord instanceof MessageForStructing)))
              {
                paramObject = (MessageForStructing)localMessageRecord;
                if (paramObject.structingMsg.mMsgServiceID != 52) {
                  break label1011;
                }
                paramObservable = new NearbyFlowerMessage(paramObservable, paramObject);
                if (!QLog.isColorLevel()) {
                  break label1011;
                }
                QLog.d("QQServiceForAV", 2, "flower message version: " + paramObservable.version);
                break label1011;
              }
              paramObservable = anre.a(localMessageRecord.msgData);
              if (paramObservable == null)
              {
                if (!QLog.isColorLevel()) {
                  break label1016;
                }
                QLog.d("QQServiceForAV", 2, "QQServiceForAV:getStructMsg is null");
                break label1016;
              }
              paramObservable = paramObservable.mMsgBrief;
            }
            catch (Exception paramObservable)
            {
              if (QLog.isColorLevel()) {
                QLog.d("StructMsg", 2, "QQServiceForAV:getStructMsg error", paramObservable);
              }
              paramObservable = null;
            }
            continue;
            paramObservable = getResources().getString(2131721783);
            continue;
            if ((localMessageRecord instanceof MessageForGrayTips))
            {
              paramObservable = MessageForGrayTips.getOrginMsg(((MessageForGrayTips)localMessageRecord).getSummaryMsg());
              continue;
            }
          }
          paramObservable = null;
          continue;
          label1011:
          paramObservable = null;
          continue;
          label1016:
          paramObservable = null;
        }
      }
    }
  }
  
  public boolean vy()
  {
    return this.iC.size() + this.iB.size() == 0;
  }
  
  static class a
    implements accv.b
  {
    private WeakReference<QQServiceForAV.e> by;
    private WeakReference<accv> bz;
    private WeakReference<iub> mCallback;
    
    public a(QQServiceForAV.e parame, accv paramaccv, iub paramiub)
    {
      this.by = new WeakReference(parame);
      this.bz = new WeakReference(paramaccv);
      this.mCallback = new WeakReference(paramiub);
    }
    
    public void D(int paramInt, boolean paramBoolean)
    {
      Object localObject = (accv)this.bz.get();
      if (localObject != null) {
        ((accv)localObject).removeListener(this);
      }
      localObject = (QQServiceForAV.e)this.by.get();
      iub localiub = (iub)this.mCallback.get();
      if ((localObject != null) && (localiub != null)) {
        ((QQServiceForAV.e)localObject).a(paramBoolean, localiub);
      }
    }
    
    public void c(iub paramiub)
    {
      this.mCallback = new WeakReference(paramiub);
    }
  }
  
  static class b
    extends acgs
  {
    private List<iub> fv = new ArrayList();
    
    public void b(boolean paramBoolean, LBSInfo paramLBSInfo)
    {
      Iterator localIterator = this.fv.iterator();
      while (localIterator.hasNext())
      {
        iub localiub = (iub)localIterator.next();
        try
        {
          localiub.a(paramBoolean, paramLBSInfo);
        }
        catch (RemoteException localRemoteException) {}
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceForAV", 2, "Call onGetUserLocation fail", localRemoteException);
        }
      }
      this.fv.clear();
    }
    
    public void d(iub paramiub)
    {
      if (paramiub != null) {
        this.fv.add(paramiub);
      }
    }
    
    public int size()
    {
      return this.fv.size();
    }
  }
  
  static class c
    implements axce.a
  {
    final WeakReference<QQServiceForAV> mRef;
    
    c(QQServiceForAV paramQQServiceForAV)
    {
      this.mRef = new WeakReference(paramQQServiceForAV);
    }
    
    public void a(axcd paramaxcd, long paramLong1, long paramLong2) {}
    
    public void a(axcd paramaxcd, String paramString, boolean paramBoolean, int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQServiceForAV", 2, "PTULibpagDownloadCallback onAEResDownloadResult, package[" + paramaxcd.index + ", isDownloaded[" + paramBoolean + ", errorType[" + paramInt + "]");
      }
      paramString = (QQServiceForAV)this.mRef.get();
      if (paramString != null)
      {
        paramString = (QQAppInterface)paramString.getAppRuntime();
        Intent localIntent = new Intent("tencent.video.q2v.ptuLibpagDownloadRet");
        localIntent.putExtra("packageIdx", paramaxcd.index);
        localIntent.putExtra("isDownloaded", paramBoolean);
        localIntent.putExtra("errorType", paramInt);
        paramString.getApp().sendBroadcast(localIntent);
      }
    }
  }
  
  static class d
    implements axce.a
  {
    final WeakReference<QQServiceForAV> mRef;
    
    d(QQServiceForAV paramQQServiceForAV)
    {
      this.mRef = new WeakReference(paramQQServiceForAV);
    }
    
    public void a(axcd paramaxcd, long paramLong1, long paramLong2) {}
    
    public void a(axcd paramaxcd, String paramString, boolean paramBoolean, int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQServiceForAV", 2, "onAEResDownloadResult, package[" + paramaxcd.index + ", isDownloaded[" + paramBoolean + ", errorType[" + paramInt + "]");
      }
      paramString = (QQServiceForAV)this.mRef.get();
      if (paramString != null)
      {
        paramString = (QQAppInterface)paramString.getAppRuntime();
        Intent localIntent = new Intent("tencent.video.q2v.ptusoDownloadRet");
        localIntent.putExtra("packageIdx", paramaxcd.index);
        localIntent.putExtra("isDownloaded", paramBoolean);
        localIntent.putExtra("errorType", paramInt);
        paramString.getApp().sendBroadcast(localIntent);
      }
    }
  }
  
  public class e
    extends iua.a
  {
    e() {}
    
    private void a(IBinder paramIBinder)
    {
      Intent localIntent = new Intent(QQServiceForAV.this.getApplicationContext(), UtilsServiceForAV.class);
      QQServiceForAV.this.getApplicationContext().stopService(localIntent);
      if (QQServiceForAV.b == null)
      {
        igd.aK("QQServiceForAV", "linkToVideoProcessDeath");
        QQServiceForAV.b = paramIBinder;
      }
      try
      {
        QQServiceForAV.b.linkToDeath(new iup(this), 0);
        return;
      }
      catch (RemoteException paramIBinder)
      {
        QQServiceForAV.b = null;
        igd.aL("QQServiceForAV", "linkToVideoProcessDeath exception msg = " + paramIBinder.getMessage());
      }
    }
    
    public void D(String paramString1, String paramString2, String paramString3)
      throws RemoteException
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "sendMessageToTroop");
      }
      paramString2 = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      if (paramString2 == null)
      {
        paramString1 = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
        return;
      }
      MessageRecord localMessageRecord = anbi.d(-1000);
      long l = anaz.gQ();
      localMessageRecord.init(paramString2.getCurrentAccountUin(), paramString3, paramString2.getCurrentAccountUin(), paramString1, l, -1000, 1, l);
      localMessageRecord.issend = 1;
      paramString2.b().a(localMessageRecord, null);
    }
    
    public void T(int paramInt, String paramString)
      throws RemoteException
    {
      QQAppInterface localQQAppInterface2 = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      QQAppInterface localQQAppInterface1 = localQQAppInterface2;
      if (localQQAppInterface2 == null) {
        localQQAppInterface1 = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      }
      QQServiceForAV.this.mUinType = paramInt;
      QQServiceForAV.this.mFriendUin = paramString;
      QQServiceForAV.this.mStartTime = anaz.gQ();
      localQQAppInterface1.b().addObserver(QQServiceForAV.this);
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "startPumpMessage uinType = " + paramInt + ", peerUin = " + paramString + ",mStartTime:" + QQServiceForAV.this.mStartTime);
      }
    }
    
    public void U(int paramInt, String paramString)
      throws RemoteException
    {
      QQServiceForAV.this.mBindId = paramString;
      QQServiceForAV.this.mBindType = paramInt;
    }
    
    public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
      throws RemoteException
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "getFaceBitmap uinType = " + paramInt + ", uin = " + paramString1 + ", extraUin = " + paramString2 + ", isRound = " + paramBoolean1);
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      byte b;
      if (paramBoolean1)
      {
        b = 2;
        switch (paramInt)
        {
        default: 
          paramString2 = localQQAppInterface.a(paramString1, b, true);
        }
      }
      for (;;)
      {
        if (paramString2 == null)
        {
          if (!QQServiceForAV.this.iC.contains(paramString1)) {
            QQServiceForAV.this.iC.add(paramString1);
          }
          localQQAppInterface.addObserver(QQServiceForAV.this.jdField_a_of_type_Acfd);
        }
        if ((paramString2 == null) && (paramBoolean2))
        {
          if (QLog.isColorLevel()) {
            QLog.w("QQServiceForAV", 2, "getFaceBitmap failed, use default face!");
          }
          if (paramInt == 1)
          {
            return aqhu.aL();
            b = 5;
            break;
            paramString2 = localQQAppInterface.a(paramString1, b, true);
            continue;
            paramString2 = localQQAppInterface.a(paramString1, b, false, false);
            continue;
            paramString2 = (BitmapDrawable)((acdt)localQQAppInterface.getBusinessHandler(6)).a(paramString1, false);
            if (paramString2 == null) {
              break label578;
            }
            paramString2 = paramString2.getBitmap();
            continue;
            if (paramString1.startsWith("+")) {
              break label573;
            }
          }
        }
        for (;;)
        {
          paramString2 = aqdj.b(localQQAppInterface, paramString2, b).aF();
          break;
          paramString2 = aqdj.a(localQQAppInterface, 200, paramString1, true).aF();
          break;
          paramString2 = ((syw)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(51)).a(Long.parseLong(paramString1));
          paramString2 = DeviceHeadMgr.getInstance().getDeviceHeadByPID(paramString2.productId);
          break;
          Object localObject = (ajdo)localQQAppInterface.getManager(11);
          if ((localObject != null) && (paramString2 != null)) {}
          for (localObject = ((ajdo)localObject).c(paramString2);; localObject = null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQServiceForAV", 2, "getFaceBitmap contact = " + localObject);
            }
            if (localObject != null)
            {
              paramString2 = aqdj.b(localQQAppInterface, paramString2, b).aF();
              break;
            }
            paramString2 = localQQAppInterface.getFaceBitmap(16, paramString1, (byte)3, true, 16);
            break;
            paramString2 = aljw.b(localQQAppInterface, paramString2);
            break;
            if (paramInt == 3000) {
              return aqhu.aN();
            }
            return aqhu.G();
            return paramString2;
          }
          label573:
          paramString2 = paramString1;
        }
        label578:
        paramString2 = null;
      }
    }
    
    public Bundle a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, Bundle paramBundle, ResultReceiver paramResultReceiver)
      throws RemoteException
    {
      boolean bool2 = false;
      StringBuilder localStringBuilder;
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder().append("requestEvent, mainCmd[").append(paramInt1).append("], subType[").append(paramInt2).append("], seq[").append(paramInt3).append("], buf[");
        if (paramArrayOfByte == null) {
          break label132;
        }
      }
      label132:
      for (boolean bool1 = true;; bool1 = false)
      {
        paramArrayOfByte = localStringBuilder.append(bool1).append("], bundle[");
        bool1 = bool2;
        if (paramBundle != null) {
          bool1 = true;
        }
        QLog.d("QQServiceForAV", 1, bool1 + "]");
        AudioHelper.I("requestEvent", paramBundle);
        if (paramBundle != null) {
          break;
        }
        return new Bundle();
      }
      switch (paramInt1)
      {
      default: 
      case 1: 
      case 2: 
      case 3: 
      case 4: 
        for (;;)
        {
          return null;
          new Handler(Looper.getMainLooper()).postDelayed(new QQServiceForAV.QQServiceForAVBinder.3(this, paramBundle), 1L);
          continue;
          new Handler(Looper.getMainLooper()).postDelayed(new QQServiceForAV.QQServiceForAVBinder.4(this, paramBundle, paramResultReceiver), 1L);
          continue;
          paramArrayOfByte = paramBundle.getString("uin");
          paramResultReceiver = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
          bool1 = aqji.a("GetInviteFlag", paramResultReceiver, paramArrayOfByte);
          aqji.c("GetInviteFlag", paramResultReceiver, paramArrayOfByte);
          paramBundle.putBoolean("enableInvite", bool1);
          return paramBundle;
          aqjl.f((QQAppInterface)QQServiceForAV.this.getAppRuntime(), paramBundle);
        }
      case 5: 
        return aqjl.a((QQAppInterface)QQServiceForAV.this.getAppRuntime(), paramBundle);
      case 6: 
        return aqji.b((QQAppInterface)QQServiceForAV.this.getAppRuntime(), paramBundle.getString("uin"));
      }
      paramArrayOfByte = paramBundle.getString("red_touch_app_id");
      paramBundle.putParcelable("red_touch_red_app_info", altt.a(((altq)((QQAppInterface)QQServiceForAV.this.getAppRuntime()).getManager(36)).getAppInfoByPath(paramArrayOfByte)));
      return paramBundle;
    }
    
    String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
    {
      String str = "";
      Object localObject1;
      if (!paramString1.startsWith("+"))
      {
        localObject1 = str;
        if (paramString2 != null)
        {
          localObject1 = str;
          if (!paramString2.startsWith("+")) {}
        }
      }
      for (str = paramString2;; str = paramString1)
      {
        localObject1 = (ajdo)paramQQAppInterface.getManager(11);
        if (localObject1 != null) {}
        label236:
        label248:
        for (localObject1 = ((ajdo)localObject1).c(str);; localObject1 = null)
        {
          if (localObject1 != null)
          {
            localObject1 = ((PhoneContact)localObject1).name;
            return localObject1;
          }
          localObject1 = aqgv.x(paramQQAppInterface, str);
          Object localObject2 = localObject1;
          if (localObject1 == null)
          {
            if (!paramString1.startsWith("+")) {
              break label253;
            }
            if ((paramString2 == null) || (paramString2.startsWith("+"))) {
              break label236;
            }
            paramString1 = paramString2;
          }
          label121:
          label253:
          for (;;)
          {
            localObject2 = paramString1;
            if (paramString1 != null)
            {
              aqgv.w(paramQQAppInterface, str, paramString1);
              localObject2 = paramString1;
            }
            if (localObject2 != null)
            {
              paramString1 = (acff)paramQQAppInterface.getManager(51);
              if (paramString1 == null) {
                break label248;
              }
            }
            for (paramString1 = paramString1.e((String)localObject2);; paramString1 = null)
            {
              if (paramString1 != null) {}
              for (paramString1 = aqgv.c(paramString1);; paramString1 = null)
              {
                if ((paramString1 == null) || (paramString1.equals(localObject2)))
                {
                  paramString1 = (FriendListHandler)paramQQAppInterface.getBusinessHandler(1);
                  localObject1 = str;
                  if (paramString1 == null) {
                    break;
                  }
                  QQServiceForAV.this.iB.add(localObject2);
                  paramQQAppInterface.addObserver(QQServiceForAV.this.jdField_a_of_type_Acfd);
                  paramString1.DG((String)localObject2);
                  return str;
                  paramString1 = null;
                  break label121;
                }
                return paramString1;
              }
            }
          }
        }
      }
    }
    
    public void a(itz paramitz)
      throws RemoteException
    {
      if (paramitz != null) {
        QQServiceForAV.this.mCallbacks.unregister(paramitz);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "unregisterCallback");
      }
      ((QQAppInterface)QQServiceForAV.this.getAppRuntime()).gi = null;
    }
    
    public void a(itz paramitz, String paramString)
      throws RemoteException
    {
      if (paramitz != null)
      {
        QQServiceForAV.this.mCallbacks.register(paramitz, paramString);
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceForAV", 2, "registerCallback");
        }
        a(paramitz.asBinder());
        paramitz = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
        paramitz.gi = null;
        paramitz.gi = new WeakReference(QQServiceForAV.this);
      }
    }
    
    public void a(iub paramiub)
      throws RemoteException
    {
      if (paramiub == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceForAV", 2, "getAddressConfig IQQServiceLocationCallback is null");
        }
        return;
      }
      Object localObject = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      localObject = (accv)QQServiceForAV.a(QQServiceForAV.this).getManager(59);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceForAV", 2, "getAddressConfig for IQQServiceLocationCallback");
        }
        if (((accv)localObject).Ai() == 1)
        {
          if (((accv)localObject).q(((accv)localObject).Ai(), true) == 0)
          {
            if (QQServiceForAV.a(QQServiceForAV.this) == null) {
              QQServiceForAV.a(QQServiceForAV.this, new QQServiceForAV.a(this, (accv)localObject, paramiub));
            }
            for (;;)
            {
              ((accv)localObject).addListener(QQServiceForAV.a(QQServiceForAV.this));
              return;
              QQServiceForAV.a(QQServiceForAV.this).c(paramiub);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQServiceForAV", 2, "ConditionSearchManager update RESULT_UPDATE_REMOTE fail");
          }
          a(false, paramiub);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceForAV", 2, "ConditionSearchManager config exist");
        }
        a(true, paramiub);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "Get ConditionSearchManager null");
      }
      a(false, paramiub);
    }
    
    public void a(boolean paramBoolean, iub paramiub)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      }
      try
      {
        for (;;)
        {
          paramiub.ae(i, "admin_region_config");
          return;
          i = -26;
        }
      }
      catch (RemoteException paramiub)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QQServiceForAV", 2, "Call onGetAddressConfig fail", paramiub);
      }
    }
    
    public void a(long[] paramArrayOfLong, String paramString)
      throws RemoteException
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "getGVideoLevelInfo uins = " + paramArrayOfLong.toString() + " troopuin = " + paramString);
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      localQQAppInterface.addObserver(QQServiceForAV.this.jdField_a_of_type_Acnd);
      acms localacms = (acms)localQQAppInterface.getBusinessHandler(20);
      if (localacms != null) {
        try
        {
          localacms.a(paramArrayOfLong, Long.parseLong(paramString));
          return;
        }
        catch (NumberFormatException paramArrayOfLong)
        {
          QLog.e("QQServiceForAV", 2, "getGVideoLevelInfo NumberFormatException !", paramArrayOfLong);
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "getGVideoLevelInfo-->can not get TroopHandle");
      }
      localQQAppInterface.removeObserver(QQServiceForAV.this.jdField_a_of_type_Acnd);
    }
    
    public long[] a(String paramString)
      throws RemoteException
    {
      paramString = ((acdu)((QQAppInterface)QQServiceForAV.this.getAppRuntime()).getManager(53)).z(paramString);
      if (paramString != null)
      {
        int j = paramString.size();
        long[] arrayOfLong = new long[j];
        int i = 0;
        while (i < j)
        {
          DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)paramString.get(i);
          if (localDiscussionMemberInfo != null) {
            arrayOfLong[i] = Long.valueOf(localDiscussionMemberInfo.memberUin).longValue();
          }
          i += 1;
        }
        return arrayOfLong;
      }
      return null;
    }
    
    public int aj(String paramString)
      throws RemoteException
    {
      int i = -1;
      if (!TextUtils.isEmpty(paramString))
      {
        if (jou.df(paramString)) {
          i = 1025;
        }
      }
      else {
        return i;
      }
      return 1024;
    }
    
    public void amF()
      throws RemoteException
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "avStartAddFriendService");
      }
      ((QQAppInterface)QQServiceForAV.this.getAppRuntime()).a();
    }
    
    public void aqJ()
      throws RemoteException
    {
      Object localObject = new StringBuilder().append("stopPumpMessage, monbind[").append(QQServiceForAV.this.Vh).append("], IBinder[");
      if (QQServiceForAV.b != null) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.w("QQServiceForAV", 1, bool + "]");
        QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
        localObject = localQQAppInterface;
        if (localQQAppInterface == null) {
          localObject = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
        }
        ((QQAppInterface)localObject).b().deleteObserver(QQServiceForAV.this);
        return;
      }
    }
    
    public void aqK()
      throws RemoteException
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "avStopAddFriendService");
      }
      ((QQAppInterface)QQServiceForAV.this.getAppRuntime()).cLu();
    }
    
    public int aw(String paramString)
      throws RemoteException
    {
      return ((QQAppInterface)QQServiceForAV.this.getAppRuntime()).a().aq(paramString);
    }
    
    public int ax(String paramString)
      throws RemoteException
    {
      return ((QQAppInterface)QQServiceForAV.this.getAppRuntime()).a().ai(paramString);
    }
    
    public boolean ay(long paramLong)
      throws RemoteException
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      acms localacms = (acms)localQQAppInterface.getBusinessHandler(20);
      if (localacms != null) {
        try
        {
          QLog.w("QQServiceForAV", 1, "getAdminMemberList, troopUin[" + paramLong + "]");
          localQQAppInterface.addObserver(QQServiceForAV.this.jdField_a_of_type_Acnd);
          localacms.a(paramLong, 0L, 2, 0, 0);
          return true;
        }
        catch (Exception localException)
        {
          localQQAppInterface.removeObserver(QQServiceForAV.this.jdField_a_of_type_Acnd);
          QLog.w("QQServiceForAV", 1, "getAdminMemberList Exception, troopUin[" + paramLong + "]", localException);
          return false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w("QQServiceForAV", 1, "getAdminMemberList null, troopUin[" + paramLong + "]");
      }
      return false;
    }
    
    String b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
    {
      ajdo localajdo = (ajdo)paramQQAppInterface.getManager(11);
      if ((localajdo != null) && (paramString2 != null)) {}
      for (paramString2 = localajdo.c(paramString2);; paramString2 = null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceForAV", 2, "getDisplayName contact = " + paramString2);
        }
        if (paramString2 != null) {
          return paramString2.name;
        }
        paramString2 = ((alkf)paramQQAppInterface.getManager(140)).a(paramString1);
        paramQQAppInterface = (alkd)paramQQAppInterface.getBusinessHandler(79);
        paramQQAppInterface.On(paramString1);
        paramQQAppInterface.a(QQServiceForAV.this.jdField_a_of_type_Alkd$a);
        if ((paramString2 != null) && (paramString2.nickname != null)) {
          return paramString2.nickname;
        }
        return "";
      }
    }
    
    public void b(itw paramitw)
      throws RemoteException
    {
      ((irz)QQServiceForAV.b(QQServiceForAV.this).getManager(254)).b(paramitw);
    }
    
    public void b(iub paramiub)
      throws RemoteException
    {
      if (paramiub == null) {
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceForAV", 2, "getUserCurrentLocation IQQServiceLocationCallback is null, no need notify");
        }
      }
      do
      {
        do
        {
          return;
          QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
          if ((localQQAppInterface.getApp() == null) || (!aqiw.isNetSupport(localQQAppInterface.getApp().getApplicationContext()))) {
            break;
          }
          if (QQServiceForAV.a(QQServiceForAV.this) == null) {
            QQServiceForAV.a(QQServiceForAV.this, new QQServiceForAV.b());
          }
          QQServiceForAV.a(QQServiceForAV.this).d(paramiub);
          if (QQServiceForAV.a(QQServiceForAV.this).size() == 1)
          {
            localQQAppInterface.addObserver(QQServiceForAV.a(QQServiceForAV.this));
            ((acgr)localQQAppInterface.getBusinessHandler(3)).cJs();
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QQServiceForAV", 2, "We are waiting getUserCurrentLocation response, so need't request again");
        return;
        try
        {
          paramiub.a(false, null);
          return;
        }
        catch (RemoteException paramiub) {}
      } while (!QLog.isColorLevel());
      QLog.e("QQServiceForAV", 2, "Call getUserCurrentLocation fail", paramiub);
    }
    
    public void b(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
      throws RemoteException
    {
      jnm.a((QQAppInterface)QQServiceForAV.this.getAppRuntime(), new iuo(this, paramString, paramInt2), paramArrayOfByte, paramString, paramInt1, paramInt2);
    }
    
    public boolean b(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
      throws RemoteException
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      FMTransC2CMsgInfo localFMTransC2CMsgInfo = new FMTransC2CMsgInfo();
      localFMTransC2CMsgInfo.subCmd = paramInt2;
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "send0x211C2CMsg");
      }
      return localQQAppInterface.a().a().a(paramString, paramInt1, paramArrayOfByte, localFMTransC2CMsgInfo);
    }
    
    public long[] b(String paramString)
    {
      apqk localapqk = (apqk)((QQAppInterface)QQServiceForAV.this.getAppRuntime()).getManager(223);
      if (localapqk != null) {
        return localapqk.d(paramString);
      }
      return null;
    }
    
    public boolean bF()
    {
      return ((QQAppInterface)QQServiceForAV.this.getAppRuntime()).a().um();
    }
    
    public void bL(long paramLong)
      throws RemoteException
    {
      ((QQAppInterface)QQServiceForAV.this.getAppRuntime()).a().ck(paramLong);
    }
    
    public void c(int paramInt1, long paramLong, int paramInt2, int paramInt3)
      throws RemoteException
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      acms localacms = (acms)localQQAppInterface.getBusinessHandler(20);
      if (localacms != null) {}
      while (!QLog.isColorLevel()) {
        try
        {
          QLog.w("QQServiceForAV", 1, "requestGrayVideoWebViewConfig, identity[" + paramInt1 + "], guin[" + paramLong + "], clientId[" + paramInt2 + "], appVersion[" + paramInt3 + "]");
          localQQAppInterface.addObserver(QQServiceForAV.this.jdField_a_of_type_Acnd);
          localacms.e(paramInt1, paramLong);
          return;
        }
        catch (Exception localException)
        {
          do
          {
            localQQAppInterface.removeObserver(QQServiceForAV.this.jdField_a_of_type_Acnd);
          } while (!QLog.isColorLevel());
          QLog.e("QQServiceForAV", 2, "requestGrayVideoWebViewConfig-->error,e=" + localException.getMessage());
          return;
        }
      }
      QLog.e("QQServiceForAV", 2, "requestGrayVideoWebViewConfig-->can not get TroopHandle");
    }
    
    public void c(itw paramitw)
      throws RemoteException
    {
      ((irz)QQServiceForAV.c(QQServiceForAV.this).getManager(254)).a(paramitw);
    }
    
    public boolean cB(String paramString)
      throws RemoteException
    {
      if (!(QQServiceForAV.j(QQServiceForAV.this) instanceof QQAppInterface)) {
        return false;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.k(QQServiceForAV.this);
      try
      {
        l = Long.parseLong(paramString);
        int i = jll.cL(1);
        l = localQQAppInterface.a().d(i, l);
        apsw localapsw = (apsw)((QQAppInterface)QQServiceForAV.l(QQServiceForAV.this)).getManager(48);
        boolean bool1 = localapsw.bg(paramString, localQQAppInterface.getCurrentAccountUin());
        boolean bool2 = localapsw.hs(paramString);
        boolean bool3 = localapsw.eL(paramString);
        paramString = localapsw.a(paramString);
        if ((l == 0L) && (((!bool3) && (bool1)) || ((!bool2) && (paramString != null) && (paramString.gagTimeStamp > 0L)))) {
          return true;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          long l = 0L;
        }
      }
      return false;
    }
    
    public boolean cf(int paramInt)
      throws RemoteException
    {
      if (QQServiceForAV.a(QQServiceForAV.this) == null)
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
        QQServiceForAV.a(QQServiceForAV.this, new igq(localQQAppInterface));
      }
      return QQServiceForAV.a(QQServiceForAV.this).cf(paramInt);
    }
    
    public boolean cz(String paramString)
      throws RemoteException
    {
      return ((QQAppInterface)QQServiceForAV.this.getAppRuntime()).a().cz(paramString);
    }
    
    public String[] d(String paramString)
      throws RemoteException
    {
      Object localObject = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      if (localObject != null)
      {
        localObject = (TroopManager)((QQAppInterface)localObject).getManager(52);
        if (localObject != null)
        {
          paramString = ((TroopManager)localObject).b(paramString);
          if (paramString == null) {
            return new String[0];
          }
          if (!TextUtils.isEmpty(paramString.Administrator)) {
            return paramString.Administrator.split("\\|");
          }
        }
      }
      return new String[0];
    }
    
    public String dd(String paramString)
      throws RemoteException
    {
      if (paramString == null) {
        return null;
      }
      ajdo localajdo = (ajdo)((QQAppInterface)QQServiceForAV.this.getAppRuntime()).getManager(11);
      if (localajdo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceForAV", 2, "getPhoneNameByPhoneNum --> can not get PhoneContactManager");
        }
        return null;
      }
      paramString = localajdo.b(paramString);
      if ((paramString == null) || (paramString.name == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceForAV", 2, "getPhoneNameByPhoneNum --> can not get phoneContact Or Name");
        }
        return null;
      }
      return paramString.name;
    }
    
    public String di(String paramString)
      throws RemoteException
    {
      Object localObject1 = null;
      Object localObject3 = null;
      if (TextUtils.isEmpty(paramString)) {
        return localObject3;
      }
      Object localObject2 = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      localObject2 = ((acff)QQServiceForAV.f(QQServiceForAV.this).getManager(51)).b(paramString);
      if (localObject2 != null)
      {
        localObject1 = ((Card)localObject2).getCardInfo();
        if ((localObject1 == null) || (((BusinessCard)localObject1).mobilesNum.isEmpty())) {
          break label258;
        }
      }
      label258:
      for (localObject1 = (String)((BusinessCard)localObject1).mobilesNum.get(0);; localObject1 = null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("QQServiceForAV", 4, "getPhoneNumByUin in  list-data phoneNumber:=" + (String)localObject1);
        }
        localObject3 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localObject3 = (PhoneContactManagerImp)QQServiceForAV.g(QQServiceForAV.this).getManager(11);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          int i = ((PhoneContactManagerImp)localObject3).xy();
          if ((i != 9) && (i != 8) && (i != 4))
          {
            localObject2 = localObject1;
            if (i != 2) {}
          }
          else
          {
            localObject2 = localObject1;
            if (((PhoneContactManagerImp)localObject3).Uy())
            {
              paramString = ((PhoneContactManagerImp)localObject3).a(paramString);
              localObject2 = localObject1;
              if (paramString != null) {
                localObject2 = paramString.mobileNo;
              }
            }
          }
        }
        localObject3 = localObject2;
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.w("QQServiceForAV", 4, "getPhoneNumByUin in  PhoneContact phoneNumber:=" + (String)localObject2);
        return localObject2;
      }
    }
    
    public String du(String paramString)
      throws RemoteException
    {
      Object localObject = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "getTroopOwner mApp = " + localObject);
      }
      if (localObject != null)
      {
        localObject = (TroopManager)((QQAppInterface)localObject).getManager(52);
        if (localObject != null)
        {
          paramString = ((TroopManager)localObject).b(paramString);
          if (paramString == null) {
            return null;
          }
          return paramString.troopowneruin;
        }
      }
      return null;
    }
    
    public String dv(String paramString)
      throws RemoteException
    {
      if (paramString == null) {
        return null;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      paramString = ((ajdo)QQServiceForAV.e(QQServiceForAV.this).getManager(11)).b(paramString);
      if (paramString == null) {
        return null;
      }
      return paramString.uin;
    }
    
    public int e(int paramInt, String paramString)
      throws RemoteException
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      if (paramInt == 1) {}
      for (boolean bool = true;; bool = false)
      {
        int i = aqji.c(localQQAppInterface, bool, paramString);
        QLog.w("QQServiceForAV", 1, "getGroupMemberNum, relationType[" + paramInt + "], uin[" + paramString + "], 成员数[" + i + "]");
        return i;
      }
    }
    
    public void e(long paramLong1, String paramString, long paramLong2)
      throws RemoteException
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      if (localQQAppInterface != null) {
        localQQAppInterface.a().e(paramLong1, paramString, paramLong2);
      }
    }
    
    public boolean e(String paramString, int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "requestDecodeStrangeFace");
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      if (QQServiceForAV.this.jdField_a_of_type_Aqdf == null)
      {
        QQServiceForAV.this.jdField_a_of_type_Aqdf = new aqdf(localQQAppInterface.getApp().getApplicationContext(), localQQAppInterface);
        QQServiceForAV.this.jdField_a_of_type_Aqdf.a(QQServiceForAV.this.jdField_a_of_type_Aqdf$a);
      }
      if (paramInt == 25) {
        return QQServiceForAV.this.jdField_a_of_type_Aqdf.b(paramString, 16, true, false);
      }
      return QQServiceForAV.this.jdField_a_of_type_Aqdf.a(paramString, 200, true, false);
    }
    
    public boolean f(String paramString, int paramInt)
      throws RemoteException
    {
      paramString = ((acdu)((QQAppInterface)QQServiceForAV.this.getAppRuntime()).getManager(53)).a(paramString);
      if (paramString != null)
      {
        paramString.mOrigin = paramInt;
        return true;
      }
      return false;
    }
    
    public void g(long paramLong, String paramString, int paramInt)
      throws RemoteException
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "reportGVideoOnlineTime uin = " + paramLong + " troopuin = " + paramString + " onlineTime" + paramInt);
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      localQQAppInterface.addObserver(QQServiceForAV.this.jdField_a_of_type_Acnd);
      acms localacms = (acms)localQQAppInterface.getBusinessHandler(20);
      if (localacms != null) {
        try
        {
          localacms.k(paramLong, Long.parseLong(paramString), paramInt);
          return;
        }
        catch (NumberFormatException paramString)
        {
          QLog.e("QQServiceForAV", 2, "getGVideoLevelInfo NumberFormatException !", paramString);
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "getGVideoLevelInfo-->can not get TroopHandle");
      }
      localQQAppInterface.removeObserver(QQServiceForAV.this.jdField_a_of_type_Acnd);
    }
    
    public boolean g(String paramString, int paramInt)
      throws RemoteException
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "avAddFriend :" + paramString);
      }
      return ((QQAppInterface)QQServiceForAV.this.getAppRuntime()).a().d(paramString, paramInt);
    }
    
    public String getDisplayName(int paramInt, String paramString1, String paramString2)
      throws RemoteException
    {
      String str2 = "";
      String str1 = paramString1;
      if (paramString1 != null) {
        str1 = paramString1.trim();
      }
      paramString1 = str2;
      QQAppInterface localQQAppInterface;
      if (!TextUtils.isEmpty(str1))
      {
        localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
        if (paramInt != 1006) {
          break label123;
        }
      }
      try
      {
        paramString1 = a(localQQAppInterface, str1, paramString2);
        for (;;)
        {
          QLog.w("QQServiceForAV", 1, "getDisplayName, uinType[" + paramInt + "], uin[" + str1 + "], extraUin[" + paramString2 + "], name[" + paramString1 + "]");
          return paramString1;
          label123:
          if (paramInt == 26)
          {
            paramString1 = aljw.m(localQQAppInterface, paramString2);
          }
          else if (paramInt == 25)
          {
            paramString1 = b(localQQAppInterface, str1, paramString2);
          }
          else if (paramInt == 1)
          {
            if (!TextUtils.isEmpty(paramString2)) {
              paramString1 = aqgv.h(localQQAppInterface, str1, paramString2);
            } else {
              paramString1 = aqgv.a(localQQAppInterface, str1, false);
            }
          }
          else
          {
            if (paramInt != 9500) {
              break;
            }
            paramString1 = ((syw)localQQAppInterface.getBusinessHandler(51)).a(Long.parseLong(str1));
            if (paramString1 == null) {
              break label463;
            }
            paramString1 = tas.a(paramString1);
          }
        }
        int i = aqgv.jZ(paramInt);
        if (i == -1) {}
        for (paramString1 = aqgv.e(localQQAppInterface, str1, paramInt);; paramString1 = aqgv.a(localQQAppInterface, str1, paramString2, i, 0))
        {
          if (!TextUtils.isEmpty(paramString1))
          {
            str2 = paramString1;
            if (!str1.equals(paramString1)) {}
          }
          else
          {
            str2 = aqgv.b(localQQAppInterface, str1, true);
          }
          paramString1 = str2;
          if (TextUtils.isEmpty(str2)) {
            paramString1 = str1;
          }
          localObject = paramString1;
          if (!str1.equals(paramString1)) {
            break;
          }
          localObject = (acff)localQQAppInterface.getManager(51);
          str2 = paramString1;
          if (localObject != null)
          {
            localObject = ((acff)localObject).e(str1);
            str2 = paramString1;
            if (localObject != null) {
              str2 = aqgv.c((Friends)localObject);
            }
          }
          if (!str1.equals(str2))
          {
            localObject = str2;
            if (!TextUtils.isEmpty(str2)) {
              break;
            }
          }
          paramString1 = (FriendListHandler)localQQAppInterface.getBusinessHandler(1);
          localObject = str2;
          if (paramString1 == null) {
            break;
          }
          QQServiceForAV.this.iB.add(str1);
          localQQAppInterface.addObserver(QQServiceForAV.this.jdField_a_of_type_Acfd);
          paramString1.DG(str1);
          localObject = str2;
          break;
        }
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          Object localObject;
          QLog.d("QQServiceForAV", 1, "getDisplayName", paramString1);
          paramString1 = "";
          continue;
          label463:
          paramString1 = str1;
          continue;
          paramString1 = (String)localObject;
        }
      }
    }
    
    public String getSKey()
      throws RemoteException
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      return ((TicketManager)localQQAppInterface.getManager(2)).getSkey(localQQAppInterface.getCurrentAccountUin());
    }
    
    public void h(int paramInt, String paramString1, String paramString2)
      throws RemoteException
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      QQServiceForAV.this.mUinType = paramInt;
      QQServiceForAV.this.mFriendUin = paramString1;
      QQServiceForAV.this.OD = paramString2;
      QQServiceForAV.this.mStartTime = anaz.gQ();
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "setPeerInfo uinType = " + paramInt + ", peerUin = " + paramString1 + ", extraUin = " + paramString2 + ",mStartTime:" + QQServiceForAV.this.mStartTime);
      }
    }
    
    public void hW(boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, String.format("keepVideoProcessAlive keepAlive=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
      QQServiceForAV.a(QQServiceForAV.this, paramBoolean);
    }
    
    public void i(String paramString1, String paramString2, String paramString3, int paramInt)
      throws RemoteException
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      if (("1".equals(paramString3)) || ("2".equals(paramString3))) {
        QQServiceForAV.this.j(paramString1, paramString2, paramString3, paramInt);
      }
      while (!"3".equals(paramString3)) {
        return;
      }
      QQServiceForAV.this.getFollowStatus(paramString1);
    }
    
    public void iX(boolean paramBoolean)
      throws RemoteException
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "listenTroopListUpdate bListen = " + paramBoolean);
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      if (localQQAppInterface != null)
      {
        if (paramBoolean) {
          localQQAppInterface.addObserver(QQServiceForAV.a(QQServiceForAV.this));
        }
      }
      else {
        return;
      }
      localQQAppInterface.removeObserver(QQServiceForAV.a(QQServiceForAV.this));
    }
    
    public void iY(boolean paramBoolean)
      throws RemoteException
    {
      SharedPreferences localSharedPreferences = aqmj.j(((QQAppInterface)QQServiceForAV.this.getAppRuntime()).getApplication().getApplicationContext());
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      if (paramBoolean)
      {
        localEditor.putBoolean("qav_random_speakeron", true);
        localEditor.commit();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceForAV", 2, "qav_random_speakeron: " + localSharedPreferences.getBoolean("qav_random_speakeron", false));
        }
        return;
        localEditor.putBoolean("qav_random_speakeron", false);
        localEditor.commit();
      }
    }
    
    public void iZ(boolean paramBoolean)
      throws RemoteException
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "playFlowerAnimation play: " + paramBoolean + ", mFlowerAnimationActive: " + QQServiceForAV.this.Vf);
      }
    }
    
    public boolean isFriend(String paramString)
      throws RemoteException
    {
      return ((acff)((QQAppInterface)QQServiceForAV.this.getAppRuntime()).getManager(51)).isFriend(paramString);
    }
    
    public void ix(String paramString)
    {
      ((altq)((QQAppInterface)QQServiceForAV.this.getAppRuntime()).getManager(36)).OS(paramString);
    }
    
    public void iy(String paramString)
    {
      altq localaltq = (altq)((QQAppInterface)QQServiceForAV.this.getAppRuntime()).getManager(36);
      localaltq.e(localaltq.getAppInfoByPath(paramString), "");
    }
    
    public void jC(String paramString)
      throws RemoteException
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "acceptAddFriend :" + paramString);
      }
      ((QQAppInterface)QQServiceForAV.this.getAppRuntime()).a().it(paramString);
    }
    
    public void jD(String paramString)
      throws RemoteException
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "acceptAddFriend :" + paramString);
      }
      ((QQAppInterface)QQServiceForAV.this.getAppRuntime()).a().is(paramString);
    }
    
    public void jE(String paramString)
      throws RemoteException
    {
      altq localaltq = (altq)((QQAppInterface)QQServiceForAV.this.getAppRuntime()).getManager(36);
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAVQ.nearby.video_chat", 2, "redTouchManagerDismiss, appId " + paramString);
      }
      localaltq.OT(paramString);
    }
    
    public void ju(String paramString)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      ajrs localajrs = (ajrs)localQQAppInterface.getBusinessHandler(60);
      localQQAppInterface.addObserver(QQServiceForAV.this.jdField_a_of_type_Ajrw);
      localajrs.MW(paramString);
    }
    
    public boolean l(int paramInt, long paramLong)
      throws RemoteException
    {
      return ((QQAppInterface)QQServiceForAV.this.getAppRuntime()).a().d(paramInt, paramLong) > 0L;
    }
    
    public int lB()
      throws RemoteException
    {
      return ((ajdo)((QQAppInterface)QQServiceForAV.this.getAppRuntime()).getManager(11)).xy();
    }
    
    @Deprecated
    public int lC()
    {
      return 0;
    }
    
    @Deprecated
    public int lD()
    {
      return 0;
    }
    
    public int lE()
    {
      return -1;
    }
    
    public void lL(int paramInt)
      throws RemoteException
    {
      Object localObject = (afem)QQServiceForAV.d(QQServiceForAV.this).getManager(77);
      if (localObject != null)
      {
        localObject = (affl)((afem)localObject).a("qq.android.qav.video");
        if (localObject != null) {
          ((affl)localObject).HL(false);
        }
      }
    }
    
    public boolean m(String paramString, boolean paramBoolean)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      localQQAppInterface.addObserver(QQServiceForAV.this.jdField_a_of_type_Acnd);
      acms localacms = (acms)localQQAppInterface.getBusinessHandler(20);
      if (localacms != null) {
        try
        {
          localacms.bN(paramString, paramBoolean);
          return true;
        }
        catch (Exception paramString)
        {
          localQQAppInterface.removeObserver(QQServiceForAV.this.jdField_a_of_type_Acnd);
          QLog.e("QQServiceForAV", 2, "joinOrExitOpenTroop-->error,e=" + paramString.getMessage());
          return false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "joinOrExitOpenTroop-->can not get TroopHandle");
      }
      localQQAppInterface.removeObserver(QQServiceForAV.this.jdField_a_of_type_Acnd);
      return false;
    }
    
    @Deprecated
    public int[] s()
    {
      return new int[3];
    }
    
    public boolean sL()
      throws RemoteException
    {
      return ((QQAppInterface)QQServiceForAV.this.getAppRuntime()).isBackground_Pause;
    }
    
    public boolean sM()
    {
      return ((QQAppInterface)QQServiceForAV.this.getAppRuntime()).a().sM();
    }
    
    public boolean sN()
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      if (localQQAppInterface.bF())
      {
        long l = localQQAppInterface.a().bG();
        int i = localQQAppInterface.a().lg();
        if (l > 0L)
        {
          int j = localQQAppInterface.a().z(l);
          if ((i == 1) && (j == 2)) {
            return true;
          }
        }
      }
      return false;
    }
    
    public boolean sO()
      throws RemoteException
    {
      return AppSetting.enableTalkBack;
    }
    
    public boolean sP()
      throws RemoteException
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      if (QQServiceForAV.a(QQServiceForAV.this) == null) {
        QQServiceForAV.a(QQServiceForAV.this, new QQServiceForAV.d(QQServiceForAV.this));
      }
      boolean bool = ankq.a(localQQAppInterface, localQQAppInterface.getApplication().getApplicationContext(), QQServiceForAV.a(QQServiceForAV.this));
      if (QLog.isDevelopLevel()) {
        QLog.w("QQServiceForAV", 4, "getEffectsSoLoadIsOk, ret[" + bool + "]");
      }
      return bool;
    }
    
    public boolean sQ()
      throws RemoteException
    {
      if (QQServiceForAV.a(QQServiceForAV.this) == null) {
        QQServiceForAV.a(QQServiceForAV.this, new QQServiceForAV.c(QQServiceForAV.this));
      }
      axce.a().a(axcd.d, QQServiceForAV.a(QQServiceForAV.this), false);
      if (QLog.isDevelopLevel()) {
        QLog.w("QQServiceForAV", 4, "try download AEKit compenent");
      }
      return false;
    }
    
    public boolean sy()
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "call isQQSVIP ");
      }
      return VipUtils.ce((QQAppInterface)QQServiceForAV.this.getAppRuntime());
    }
    
    public void t(String paramString, long paramLong)
      throws RemoteException
    {
      Object localObject = (apqk)((QQAppInterface)QQServiceForAV.this.getAppRuntime()).getManager(223);
      if (localObject != null) {
        ((apqk)localObject).Ty(paramString);
      }
      if ((paramLong > 0L) && ((QQServiceForAV.h(QQServiceForAV.this) instanceof QQAppInterface)))
      {
        localObject = (QQAppInterface)QQServiceForAV.i(QQServiceForAV.this);
        SessionInfo localSessionInfo = new SessionInfo();
        localSessionInfo.aTl = paramString;
        localSessionInfo.cZ = 1;
        ujt.a((QQAppInterface)localObject, localSessionInfo);
      }
    }
    
    public long v(String paramString)
      throws RemoteException
    {
      paramString = ((acdu)((QQAppInterface)QQServiceForAV.this.getAppRuntime()).getManager(53)).a(paramString);
      long l = 0L;
      if (paramString != null) {
        l = paramString.mOrigin;
      }
      return l;
    }
    
    public boolean w(String paramString1, String paramString2)
      throws RemoteException
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "queryTroopMember troopUin = " + paramString1 + "memUin:" + paramString2);
      }
      Object localObject = (QQAppInterface)QQServiceForAV.this.getAppRuntime();
      if (localObject != null)
      {
        localObject = (TroopManager)((QQAppInterface)localObject).getManager(52);
        if ((localObject != null) && (((TroopManager)localObject).b(paramString1, paramString2) == null)) {
          return false;
        }
      }
      return true;
    }
    
    public long y(String paramString)
      throws RemoteException
    {
      return ((QQAppInterface)QQServiceForAV.this.getAppRuntime()).a().y(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV
 * JD-Core Version:    0.7.0.1
 */