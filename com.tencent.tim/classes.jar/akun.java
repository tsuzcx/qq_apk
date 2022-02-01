import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionEntity;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler.1;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler.2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime.Status;
import tencent.im.cs.cmd0xe59.cmd0xe59.ReqBody;
import tencent.im.cs.cmd0xe59.cmd0xe59.RspBody;
import tencent.im.groupstatus.ImStatus.ImStatusDataPush;
import tencent.im.oidb.cmd0xe62.ReqBody;
import tencent.im.statsvc.business.info.businessinfo.ReqBody;
import tencent.im.statsvc.business.info.businessinfo.RspBody;
import tencent.im.statsvc.song.StatSvcStatSong.ReqBody;
import tencent.im.statsvc.song.StatSvcStatSong.RspBody;

public class akun
  extends accg
{
  private Friends g;
  
  public akun(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void kH(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      int i;
      try
      {
        paramToServiceMsg = new businessinfo.RspBody();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        i = paramToServiceMsg.uint32_error_code.get();
        paramFromServiceMsg = paramToServiceMsg.string_error_msg.get();
        int j = paramToServiceMsg.uint32_interval.get();
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusHandler", 2, new Object[] { "handleRecvSetLocationBusinessInfo,errorCode  = ", Integer.valueOf(i), " errorMsg=", paramFromServiceMsg, " interval=", Integer.valueOf(j) });
        }
        if (i != 0) {
          break label146;
        }
        ((aktp)this.mApp.getManager(369)).kv(j);
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      notifyUI(3, bool, null);
      return;
      boolean bool = false;
      continue;
      label146:
      if (i == 0) {
        bool = true;
      }
    }
  }
  
  private void kI(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      int i;
      try
      {
        paramFromServiceMsg = new businessinfo.RspBody();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        i = paramFromServiceMsg.uint32_error_code.get();
        paramObject = paramFromServiceMsg.string_error_msg.get();
        int j = paramFromServiceMsg.uint32_interval.get();
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusHandler", 2, new Object[] { "handleRecvSetLocationBusinessInfo,errorCode  = ", Integer.valueOf(i), " errorMsg=", paramObject, " interval=", Integer.valueOf(j) });
        }
        if (i == 0)
        {
          paramFromServiceMsg = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramToServiceMsg.getAttribute("online_status_permission_item");
          if (paramFromServiceMsg != null)
          {
            paramObject = (aktw)this.mApp.getManager(370);
            OnlineStatusPermissionEntity localOnlineStatusPermissionEntity = new OnlineStatusPermissionEntity();
            localOnlineStatusPermissionEntity.allHasPermission = paramFromServiceMsg.isAllHasPermission();
            localOnlineStatusPermissionEntity.hasPermissionList = paramFromServiceMsg.getPermissionUins();
            localOnlineStatusPermissionEntity.onlineStateType = -1L;
            paramObject.a(localOnlineStatusPermissionEntity);
          }
          ((aktp)this.mApp.getManager(369)).kv(j);
          if (!((Boolean)paramToServiceMsg.getAttribute("from_register", Boolean.valueOf(false))).booleanValue())
          {
            this.app.a(AppRuntime.Status.online, -1L);
            break label265;
            notifyUI(2, bool, null);
          }
        }
        else
        {
          this.app.runOnUiThread(new OnlineStatusHandler.1(this));
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      label265:
      while (i != 0)
      {
        bool = false;
        break;
      }
      boolean bool = true;
    }
  }
  
  private void m(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      paramFromServiceMsg = new businessinfo.RspBody();
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      int i = paramFromServiceMsg.uint32_error_code.get();
      paramObject = paramFromServiceMsg.string_error_msg.get();
      int j = paramFromServiceMsg.uint32_interval.get();
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusHandler", 2, new Object[] { "handleRecvSetBatteryBusinessInfo,errorCode  = ", Integer.valueOf(i), " errorMsg=", paramObject, " interval=", Integer.valueOf(j) });
      }
      if (i == 0) {}
      return;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      paramFromServiceMsg.printStackTrace();
    }
  }
  
  private void n(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Bundle localBundle = new Bundle();
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramObject = (SvcRespRegister)paramObject;
      long l1 = paramObject.timeStamp;
      byte b = paramObject.cReplyCode;
      long l2 = paramObject.iStatus;
      long l3 = paramObject.uExtOnlineStatus;
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusHandler", 2, new Object[] { "handleRecvSetOnlineStatus timeStamp:", Long.valueOf(l1), " cCode:", Byte.valueOf(b), " iStatus:", Long.valueOf(l2), " extOnlineStatus:", Long.valueOf(l3) });
      }
      if (b == 0)
      {
        localBundle.putLong("onlineStatus", l2);
        localBundle.putLong("extStatus", l3);
        this.mApp.setOnlineStatus(AppRuntime.Status.build((int)l2));
        this.mApp.setExtOnlineStatus(l3);
        ((aktp)this.mApp.getManager(369)).dDr();
        notifyUI(1, true, localBundle);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusHandler", 2, new Object[] { "handleRecvSetOnlineStatus res:", Boolean.valueOf(paramFromServiceMsg.isSuccess()) });
    }
    notifyUI(1, false, localBundle);
  }
  
  public void J(int paramInt, Bundle paramBundle)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "StatSvc.SyncBusinessInfo");
    businessinfo.ReqBody localReqBody = new businessinfo.ReqBody();
    switch (paramInt)
    {
    default: 
      QLog.w("OnlineStatusHandler", 1, "error type:" + paramInt);
      return;
    case 1: 
      int i = paramBundle.getInt("BatteryInfo", 0);
      localReqBody.int32_battery_status.set(i);
      localReqBody.uint32_status.set(AppRuntime.Status.online.getValue());
      localReqBody.uint32_ext_status.set(1000);
    }
    for (;;)
    {
      localToServiceMsg.addAttribute("business_type", Integer.valueOf(paramInt));
      localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
      sendPbReq(localToServiceMsg);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("OnlineStatusHandler", 2, new Object[] { "requestSynBusinessInfo type:", Integer.valueOf(paramInt) });
      return;
      paramBundle = paramBundle.getByteArray("LocationInfo");
      localReqBody.uint32_status.set(AppRuntime.Status.online.getValue());
      localReqBody.uint32_ext_status.set(-1);
      localReqBody.bytes_business_info.set(ByteStringMicro.copyFrom(paramBundle));
      paramBundle = new cmd0xe62.ReqBody();
      localReqBody.private_info.set(paramBundle);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "StatSvc.SetBusinessInfo");
    businessinfo.ReqBody localReqBody = new businessinfo.ReqBody();
    switch (paramInt)
    {
    }
    do
    {
      for (;;)
      {
        localToServiceMsg.addAttribute("from_register", Boolean.valueOf(paramBundle.getBoolean("from_register", false)));
        localToServiceMsg.addAttribute("business_type", Integer.valueOf(paramInt));
        localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
        sendPbReq(localToServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusHandler", 2, new Object[] { "requestSetBusinessInfo type:", Integer.valueOf(paramInt) });
        }
        return;
        i = paramBundle.getInt("BatteryInfo", 0);
        localReqBody.uint32_status.set(AppRuntime.Status.online.getValue());
        localReqBody.uint32_ext_status.set(1000);
        localReqBody.int32_battery_status.set(i);
      }
      localObject = paramBundle.getByteArray("LocationInfo");
      localReqBody.uint32_status.set(AppRuntime.Status.online.getValue());
      localReqBody.uint32_ext_status.set(-1);
      localReqBody.bytes_business_info.set(ByteStringMicro.copyFrom((byte[])localObject));
    } while (paramOnlineStatusPermissionItem == null);
    Object localObject = new cmd0xe62.ReqBody();
    PBUInt32Field localPBUInt32Field = ((cmd0xe62.ReqBody)localObject).set_type;
    if (paramOnlineStatusPermissionItem.isAllHasPermission()) {}
    for (int i = 1;; i = 2)
    {
      localPBUInt32Field.set(i);
      if (paramOnlineStatusPermissionItem.getPermissionUins() != null) {
        ((cmd0xe62.ReqBody)localObject).rpt_uint64_uin.set(paramOnlineStatusPermissionItem.getPermissionUins());
      }
      localReqBody.private_info.set((MessageMicro)localObject);
      localToServiceMsg.addAttribute("online_status_permission_item", paramOnlineStatusPermissionItem);
      break;
    }
  }
  
  public void a(akun.a parama)
  {
    long l = c().k(this.app);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusHandler", 2, new Object[] { "pushMusicStatus curExtStatus:", Long.valueOf(l), ", ", parama });
    }
    Object localObject = parama;
    if (parama == null) {
      localObject = new akun.a();
    }
    if (l == 1028L)
    {
      parama = new StatSvcStatSong.ReqBody();
      parama.bool_need_convert.set(((akun.a)localObject).cuA);
      parama.uint32_song_type.set(((akun.a)localObject).songType);
      parama.uint32_remaining_time.set(((akun.a)localObject).dpi);
      parama.uint32_source_type.set(((akun.a)localObject).sourceType);
      parama.bytes_song_id.set(ByteStringMicro.copyFromUtf8(((akun.a)localObject).songId));
      parama.bytes_song_name.set(ByteStringMicro.copyFromUtf8(((akun.a)localObject).songName));
      parama.bytes_singer_name.set(ByteStringMicro.copyFromUtf8(((akun.a)localObject).singerName));
      parama.bool_pause_flag.set(((akun.a)localObject).cuB);
      parama.uint32_song_play_time.set(((akun.a)localObject).duration);
      localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "StatSvc.SetSong");
      ((ToServiceMsg)localObject).extraData.putBoolean("req_pb_protocol_flag", true);
      ((ToServiceMsg)localObject).putWupBuffer(parama.toByteArray());
      sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, AppRuntime.Status paramStatus, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusHandler", 2, new Object[] { "requestSetOnlineStatus onlineStatus:", paramStatus, " extStatus:", Long.valueOf(paramLong1), " largeSeq:", Long.valueOf(paramLong2) });
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramQQAppInterface.getCurrentAccountUin(), "StatSvc.SetStatusFromClient");
    Bundle localBundle = localToServiceMsg.extraData;
    localBundle.putLong("K_SEQ", paramLong2);
    localBundle.putSerializable("onlineStatus", paramStatus);
    localBundle.putLong("extOnlineStatus", paramLong1);
    if ((paramStatus == AppRuntime.Status.online) && (paramLong1 == 1000L))
    {
      localBundle.putInt("batteryCapacity", paramQQAppInterface.getBatteryCapacity());
      localBundle.putInt("powerConnect", paramQQAppInterface.getPowerConnect());
    }
    send(localToServiceMsg);
  }
  
  public void a(MusicInfo paramMusicInfo, int paramInt, boolean paramBoolean, long paramLong)
  {
    if (paramMusicInfo == null)
    {
      a(null);
      return;
    }
    akun.a locala = new akun.a();
    locala.cuA = true;
    locala.songId = paramMusicInfo.id;
    locala.songName = paramMusicInfo.name;
    locala.songType = 1;
    if ((paramMusicInfo.CB != null) && (!paramMusicInfo.CB.isEmpty())) {
      locala.singerName = ((String)paramMusicInfo.CB.get(0));
    }
    locala.dpi = paramInt;
    locala.sourceType = akum.b().sourceType;
    locala.cuB = paramBoolean;
    locala.duration = ((int)paramLong);
    a(locala);
  }
  
  public void a(SongInfo paramSongInfo, int paramInt, boolean paramBoolean, long paramLong)
  {
    if (paramSongInfo == null)
    {
      a(null);
      return;
    }
    akun.a locala = new akun.a();
    locala.cuA = false;
    locala.songId = paramSongInfo.mid;
    if ((TextUtils.isEmpty(paramSongInfo.mid)) || (paramSongInfo.mid.equals("0")))
    {
      locala.songId = mE(paramSongInfo.detailUrl);
      if (TextUtils.isEmpty(locala.songId))
      {
        QLog.d("OnlineStatusHandler", 1, "pushMusicStatus, songMid is null");
        return;
      }
    }
    locala.songName = paramSongInfo.title;
    locala.songType = 1;
    if (TextUtils.isEmpty(paramSongInfo.singer)) {}
    for (paramSongInfo = paramSongInfo.summary;; paramSongInfo = paramSongInfo.singer)
    {
      locala.singerName = paramSongInfo;
      if (locala.singerName == null) {
        locala.singerName = "";
      }
      locala.dpi = paramInt;
      locala.sourceType = akum.b().sourceType;
      locala.cuB = paramBoolean;
      locala.duration = ((int)paramLong);
      a(locala);
      return;
    }
  }
  
  public boolean asO()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity != null) && ((localBaseActivity instanceof SplashActivity))) {
      return ((SplashActivity)localBaseActivity).getCurrentTab() == MainFragment.bIm;
    }
    return false;
  }
  
  public aiwn b(String paramString)
  {
    aiwn localaiwn2 = aiwv.a(paramString, true);
    aiwn localaiwn1 = localaiwn2;
    if (localaiwn2 == null) {
      localaiwn1 = aiwv.a(paramString, false);
    }
    return localaiwn1;
  }
  
  public akti c()
  {
    return akti.a();
  }
  
  public URL i(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setInstanceFollowRedirects(false);
      paramString.setRequestProperty("Accept-Encoding", "identity");
      paramString.connect();
      if (paramString.getResponseCode() == 302)
      {
        paramString = new URL(paramString.getHeaderField("Location"));
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      QLog.d("OnlineStatusHandler", 1, "redirectShortUrl, ", paramString);
    }
    return null;
  }
  
  public void i(Friends paramFriends)
  {
    String str = paramFriends.songId;
    if (QLog.isColorLevel()) {
      QLog.e("OnlineStatusHandler", 2, new Object[] { "getMusicLyric, id:", str });
    }
    if (akum.b().gu.containsKey(str))
    {
      QLog.e("OnlineStatusHandler", 1, "getMusicLyric return, getting status");
      return;
    }
    this.g = paramFriends;
    akum.b().gu.put(str, new aiwn(0, 0, null));
    cmd0xe59.ReqBody localReqBody = new cmd0xe59.ReqBody();
    localReqBody.song_id.set(ByteStringMicro.copyFromUtf8(str));
    localReqBody.zip_compress_flag.set(true);
    if (!TextUtils.isEmpty(paramFriends.songName)) {
      localReqBody.song_name.set(ByteStringMicro.copyFromUtf8(paramFriends.songName));
    }
    if (!TextUtils.isEmpty(paramFriends.singerName)) {
      localReqBody.singer_name.set(ByteStringMicro.copyFromUtf8(paramFriends.singerName));
    }
    paramFriends = makeOIDBPkg("OidbSvc.0xe59", 3673, 0, localReqBody.toByteArray());
    paramFriends.getAttributes().put("songId", str);
    sendPbReq(paramFriends);
  }
  
  public void kJ(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = (String)paramToServiceMsg.getAttribute("songId", "");
    if (paramFromServiceMsg != null) {}
    for (;;)
    {
      Object localObject;
      boolean bool1;
      try
      {
        if ((!paramFromServiceMsg.isSuccess()) || (TextUtils.isEmpty(str)))
        {
          akum.b().gu.remove(str);
          return;
        }
        localObject = new cmd0xe59.RspBody();
        parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
        bool1 = ((cmd0xe59.RspBody)localObject).safe_hit_flag.get();
        int i = ((cmd0xe59.RspBody)localObject).ret.get();
        int j = ((cmd0xe59.RspBody)localObject).sub_ret.get();
        paramObject = ((cmd0xe59.RspBody)localObject).msg.get().toStringUtf8();
        boolean bool2 = ((cmd0xe59.RspBody)localObject).zip_compress_flag.get();
        if ((i != 0) || (bool1)) {
          break label343;
        }
        paramFromServiceMsg = new aiwn(0, 0, new ArrayList());
        paramToServiceMsg = paramFromServiceMsg;
        if (((cmd0xe59.RspBody)localObject).song_lyric.has())
        {
          localObject = ((cmd0xe59.RspBody)localObject).song_lyric.get().toByteArray();
          paramToServiceMsg = paramFromServiceMsg;
          if (localObject.length > 0)
          {
            if (!bool2) {
              break label330;
            }
            paramToServiceMsg = new String(anbg.A((byte[])localObject));
            paramToServiceMsg = b(paramToServiceMsg);
          }
        }
        if (paramToServiceMsg != null) {
          akum.b().gu.put(str, paramToServiceMsg);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("OnlineStatusHandler", 2, new Object[] { "handleGetMusicLyric, ret:", Integer.valueOf(i), " subRet:", Integer.valueOf(j), " errorMsg:", paramObject, " zipFlag:", Boolean.valueOf(bool2), " safeHitFlag:", Boolean.valueOf(bool1) });
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("OnlineStatusHandler", 1, "handleGetMusicLyric", paramToServiceMsg);
        akum.b().gu.remove(str);
        return;
      }
      label330:
      paramToServiceMsg = new String((byte[])localObject);
      continue;
      label343:
      akum.b().gu.remove(str);
      if ((bool1) && (this.g != null) && (str.equals(this.g.songId)))
      {
        this.g.songName = "";
        this.g.singerName = "";
        akum.b().al.add(this.g.songId);
        ((FriendListHandler)this.app.getBusinessHandler(1)).bE(this.g.uin, false);
      }
    }
  }
  
  public String mE(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = i(paramString);
    } while (paramString == null);
    return Uri.parse(paramString.toString()).getQueryParameter("songmid");
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("StatSvc.SetStatusFromClient");
      this.allowCmdSet.add("StatSvc.SetBusinessInfo");
      this.allowCmdSet.add("StatSvc.SyncBusinessInfo");
      this.allowCmdSet.add("StatSvc.SetSong");
      this.allowCmdSet.add("ImStatus.ReqPushStatus");
      this.allowCmdSet.add("OidbSvc.0xe59");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  public void o(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg != null) {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          return;
        }
        StatSvcStatSong.RspBody localRspBody = new StatSvcStatSong.RspBody();
        localRspBody.mergeFrom((byte[])paramObject);
        int i = localRspBody.error_code.get();
        paramObject = localRspBody.error_msg.get();
        paramFromServiceMsg = "";
        if (localRspBody.bytes_song_id.get() != null) {
          paramFromServiceMsg = localRspBody.bytes_song_id.get().toStringUtf8();
        }
        QLog.d("OnlineStatusHandler", 1, new Object[] { "handlePushMusicStatusRsp, errorCode:", Integer.valueOf(i), " errorMsg:", paramObject, " convertSongId:", paramFromServiceMsg });
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.e("OnlineStatusHandler", 1, "handlePushMusicStatusRsp, ", paramFromServiceMsg);
      }
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return aktr.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      int i;
      do
      {
        return;
        str = paramFromServiceMsg.getServiceCmd();
        if ((msgCmdFilter(str)) && (QLog.isColorLevel())) {
          QLog.d("OnlineStatusHandler", 2, "onReceive, msgCmdFilter is true,cmd  = " + str);
        }
        if ("StatSvc.SetSong".equals(str))
        {
          o(paramFromServiceMsg, paramObject);
          return;
        }
        if ("StatSvc.SetStatusFromClient".equals(str))
        {
          n(paramFromServiceMsg, paramObject);
          return;
        }
        if ("StatSvc.SyncBusinessInfo".equals(str))
        {
          kH(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (!"StatSvc.SetBusinessInfo".equals(str)) {
          break;
        }
        i = ((Integer)paramToServiceMsg.getAttribute("business_type", Integer.valueOf(-1))).intValue();
        if (i == 2)
        {
          kI(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
      } while (i != 1);
      m(paramFromServiceMsg, paramObject);
      return;
      if ("ImStatus.ReqPushStatus".equals(str))
      {
        p(paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xe59".equals(str));
    kJ(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void p(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    if (paramFromServiceMsg != null) {}
    for (;;)
    {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          return;
        }
        paramFromServiceMsg = new ImStatus.ImStatusDataPush();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = String.valueOf(paramFromServiceMsg.uint64_uin.get());
        int k = paramFromServiceMsg.uint32_music_info_refresh.get();
        if (k == 1)
        {
          paramFromServiceMsg = this.app.b().oA();
          i = j;
          if (paramObject != null)
          {
            if (paramObject.equals(paramFromServiceMsg)) {
              break label222;
            }
            i = j;
            if (paramObject.equals(this.app.getCurrentAccountUin())) {
              break label222;
            }
          }
          boolean bool = asO();
          if ((i != 0) || (bool)) {
            x().postDelayed(new OnlineStatusHandler.2(this, paramObject), 500L);
          }
          QLog.d("OnlineStatusHandler", 1, new Object[] { "handleRecvMusicStatusPush, uin:", aqmr.getSimpleUinForPrint(paramObject), " currentChatUin:", aqmr.getSimpleUinForPrint(paramFromServiceMsg), " needRefresh:", Integer.valueOf(k), " isContactShown:", Boolean.valueOf(bool) });
          return;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.e("OnlineStatusHandler", 1, "handlePushMusicStatusRsp, ", paramFromServiceMsg);
      }
      return;
      label222:
      int i = 1;
    }
  }
  
  public Handler x()
  {
    return ThreadManager.getSubThreadHandler();
  }
  
  public static class a
  {
    public boolean cuA;
    public boolean cuB;
    public int dpi;
    public int duration;
    public String singerName = "";
    public String songId = "";
    public String songName = "";
    public int songType;
    public int sourceType;
    
    @NonNull
    public String toString()
    {
      return "MusicStatus[needConvert:" + this.cuA + ", , songId:" + this.songId + ", songName:" + this.songName + ", songType:" + this.songType + ", singerName:" + this.singerName + ", remainTime:" + this.dpi + ", sourceType:" + this.sourceType + ", pauseFlag:" + this.cuB + ", duration:" + this.duration;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akun
 * JD-Core Version:    0.7.0.1
 */