package oicq.wlogin_sdk.request;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import oicq.wlogin_sdk.b.ao;
import oicq.wlogin_sdk.b.at;
import oicq.wlogin_sdk.b.ay;
import oicq.wlogin_sdk.b.bc;
import oicq.wlogin_sdk.b.ch;
import oicq.wlogin_sdk.code2d.fetch_code;
import oicq.wlogin_sdk.code2d.fetch_code.QRCodeCustom;
import oicq.wlogin_sdk.devicelock.DevlockBase;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.devicelock.DevlockRst;
import oicq.wlogin_sdk.devicelock.i;
import oicq.wlogin_sdk.devicelock.j;
import oicq.wlogin_sdk.devicelock.l;
import oicq.wlogin_sdk.report.report_t1;
import oicq.wlogin_sdk.report.report_t2;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.EcdhCrypt;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.InternationMsg;
import oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.RSACrypt;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class WtloginHelper
  extends WtloginListener
{
  private long mAysncSeq = 0L;
  private Context mContext = null;
  private y mG = new y(null);
  private Handler mHelperHandler = newHelperHandler();
  private WtloginListener mListener = null;
  private int mMainSigMap = 996082;
  private int mMiscBitmap = 32636;
  private long mOpenAppid = 715019303L;
  private oicq.wlogin_sdk.a.h mRegStatus = new oicq.wlogin_sdk.a.h();
  private int mSubSigMap = 66560;
  
  public WtloginHelper(Context paramContext)
  {
    this.mContext = paramContext;
    this.mG.a(paramContext);
    RequestInit();
    util.LOGD("WtloginHelper create end");
  }
  
  private void AsyncGenRSAKey()
  {
    util.LOGD("async rsakey Begin!");
    new WtloginHelper.1(this, "AsyncGenRSAKey").start();
  }
  
  private int CheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, int paramInt)
  {
    if ((paramString == null) || (paramArrayOfByte == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    if (paramInt == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramString, paramArrayOfByte, paramWUserSigInfo, paramArrayOfByte1, "CheckPictureAndGetSt").RunReq(2);
      return -1001;
    }
    paramInt = 0;
    if (paramWUserSigInfo._seqence == 0L) {
      paramWUserSigInfo._seqence = this.mAysncSeq;
    }
    y localy = this.mG.a(paramWUserSigInfo._seqence);
    paramWUserSigInfo._seqence = localy.h;
    k localk = y.b(paramWUserSigInfo._seqence);
    util.LOGI("user:" + paramString + " CheckPictureAndGetSt" + " Seq:" + localy.h + " ...", paramString);
    localy.g = paramString;
    localk.k = new ErrMsg();
    Object localObject2;
    Object localObject1;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      localObject2 = localy.b(paramString);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        paramInt = 1;
        localObject1 = localObject2;
      }
    }
    int i;
    for (;;)
    {
      if (paramInt == 1) {
        localy.f = ((Long)localObject1).longValue();
      }
      int j = new s(localy).a(paramArrayOfByte, this.mMiscBitmap, this.mSubSigMap, localk.d, paramWUserSigInfo);
      i = j;
      if (j == 204) {
        i = new u(localy).a(this.mMiscBitmap, this.mSubSigMap, localk.d, paramWUserSigInfo);
      }
      if (i == 0) {
        break;
      }
      paramInt = i;
      paramArrayOfByte = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      if (paramArrayOfByte != null) {
        break label1290;
      }
      paramArrayOfByte = new Ticket();
      label312:
      y.ae.commit_t2(localy.f, localy.g, util.format_ret_code(paramInt), paramInt);
      if (paramInt != 0) {
        break label1262;
      }
      if ((paramArrayOfByte._sig != null) && (paramArrayOfByte._sig.length != 0)) {
        RequestReport(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localy.f, localk.b);
      }
      label379:
      if ((localy.d != null) && (localy.d.f() != 0))
      {
        this.mG.d = localy.d;
        RequestReportError(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localy.f, localk.b, 1);
      }
      y.b();
      localy.h();
      util.LOGI("user:" + paramString + " CheckPictureAndGetSt" + " Seq:" + localy.h + " ret=" + paramInt, "" + localy.f);
      return paramInt;
      localObject1 = Long.valueOf(Long.parseLong(paramString));
      paramInt = 1;
    }
    if (!util.check_uin_account(paramString).booleanValue())
    {
      paramArrayOfByte = localy.b(paramString);
      if (paramArrayOfByte == null) {
        break label1293;
      }
      paramInt = 1;
    }
    label1290:
    label1293:
    for (;;)
    {
      if (paramInt == 0)
      {
        paramInt = -1003;
        break;
        long l = Long.parseLong(paramString);
        paramInt = 1;
        paramArrayOfByte = Long.valueOf(l);
        continue;
      }
      localy.f = paramArrayOfByte.longValue();
      if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
      {
        localy.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
        util.LOGI("MSF SSO SEQ:" + localy.i, paramString);
      }
      for (;;)
      {
        localObject1 = localy.a(paramArrayOfByte.longValue(), localk.b);
        if (localObject1 == null) {
          break label817;
        }
        paramWUserSigInfo.get_clone((WloginSigInfo)localObject1);
        if ((localk.d == null) || (paramArrayOfByte1 == null) || (localk.d.length * 2 != paramArrayOfByte1.length)) {
          break;
        }
        paramInt = 0;
        while ((localk.d != null) && (paramInt < localk.d.length))
        {
          localObject1 = localy.a(paramArrayOfByte.longValue(), localk.d[paramInt]);
          if (localObject1 != null)
          {
            paramArrayOfByte1[(paramInt * 2)] = ((byte[])((WloginSigInfo)localObject1)._userSt_Key.clone());
            paramArrayOfByte1[(paramInt * 2 + 1)] = ((byte[])((WloginSigInfo)localObject1)._userStSig.clone());
          }
          paramInt += 1;
        }
        localy.i = 0;
      }
      paramInt = 0;
      break;
      label817:
      if ((paramWUserSigInfo._in_ksid != null) && (paramWUserSigInfo._in_ksid.length > 0)) {}
      for (localObject1 = (byte[])paramWUserSigInfo._in_ksid.clone();; localObject1 = y.W)
      {
        if (localk.g == 0) {
          break label1011;
        }
        paramInt = new p(localy).a(localk.b, localk.c, 1, localy.f, 0, y.Z, localk.f, null, this.mMiscBitmap, this.mSubSigMap, localk.d, localk.e, localk.c, 1, y.w, 0, 0, 1, (byte[])localObject1, paramWUserSigInfo);
        i = paramInt;
        if (paramInt == 204) {
          i = new u(localy).a(this.mMiscBitmap, this.mSubSigMap, localk.d, paramWUserSigInfo);
        }
        paramInt = i;
        if (i != 0) {
          break;
        }
        localObject1 = localy.a(paramArrayOfByte.longValue(), localk.b);
        if (localObject1 != null) {
          break label1130;
        }
        paramInt = -1004;
        break;
      }
      label1011:
      localObject2 = new byte[4];
      util.int64_to_buf32((byte[])localObject2, 0, System.currentTimeMillis() / 1000L + y.Y);
      if (localk.D) {}
      for (paramInt = 3;; paramInt = 1)
      {
        paramInt = new p(localy).a(localk.b, localk.c, 1, localy.f, 0, y.Z, (byte[])localObject2, 0, localk.f, paramInt, this.mMiscBitmap, this.mSubSigMap, localk.d, localk.e, localk.c, 1, y.w, 0, 0, 1, (byte[])localObject1, paramWUserSigInfo);
        break;
      }
      label1130:
      paramWUserSigInfo.get_clone((WloginSigInfo)localObject1);
      if ((localk.d != null) && (paramArrayOfByte1 != null) && (localk.d.length * 2 == paramArrayOfByte1.length))
      {
        paramInt = 0;
        while ((localk.d != null) && (paramInt < localk.d.length))
        {
          localObject1 = localy.a(paramArrayOfByte.longValue(), localk.d[paramInt]);
          if (localObject1 != null)
          {
            paramArrayOfByte1[(paramInt * 2)] = ((byte[])((WloginSigInfo)localObject1)._userSt_Key.clone());
            paramArrayOfByte1[(paramInt * 2 + 1)] = ((byte[])((WloginSigInfo)localObject1)._userStSig.clone());
          }
          paramInt += 1;
        }
      }
      paramInt = 0;
      break;
      label1262:
      RequestReportError(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localy.f, localk.b, 0);
      break label379;
      break label312;
    }
  }
  
  private int CheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, int paramInt)
  {
    if ((paramString == null) || (paramArrayOfByte == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    if (paramInt == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramString, paramArrayOfByte, paramWUserSigInfo, paramArrayOfByte1, "CheckSMSAndGetSt").RunReq(4);
      return -1001;
    }
    if (paramWUserSigInfo._seqence == 0L) {
      paramWUserSigInfo._seqence = this.mAysncSeq;
    }
    y localy = this.mG.a(paramWUserSigInfo._seqence);
    paramWUserSigInfo._seqence = localy.h;
    k localk = y.b(paramWUserSigInfo._seqence);
    util.LOGI("user:" + paramString + " CheckSMSAndGetSt" + " Seq:" + localy.h + " ...", paramString);
    localy.g = paramString;
    localy.f = 0L;
    localk.k = new ErrMsg();
    if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
    {
      localy.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
      util.LOGI("MSF SSO SEQ:" + localy.i, paramString);
    }
    while (!util.check_uin_account(paramString).booleanValue())
    {
      localLong = localy.b(paramString);
      if (localLong != null) {
        break label764;
      }
      util.LOGI("user:" + paramString + " have not found uin record.", paramString);
      paramInt = -1003;
      paramArrayOfByte = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      if (paramArrayOfByte != null) {
        break label761;
      }
      paramArrayOfByte = new Ticket();
      label303:
      y.ae.commit_t2(localy.f, localy.g, util.format_ret_code(paramInt), paramInt);
      if (paramInt != 0) {
        break label733;
      }
      if ((paramArrayOfByte._sig != null) && (paramArrayOfByte._sig.length != 0)) {
        RequestReport(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localy.f, localk.b);
      }
      label370:
      if ((localy.d != null) && (localy.d.f() != 0))
      {
        this.mG.d = localy.d;
        RequestReportError(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localy.f, localk.b, 1);
      }
      y.b();
      localy.h();
      util.LOGI("user:" + paramString + " CheckSMSAndGetSt" + " Seq:" + localy.h + " ret=" + paramInt, "" + localy.f);
      return paramInt;
      localy.i = 0;
    }
    Long localLong = Long.valueOf(Long.parseLong(paramString));
    label733:
    label761:
    label764:
    for (;;)
    {
      localy.f = localLong.longValue();
      int i = new t(localy).a(paramArrayOfByte, this.mMiscBitmap, this.mSubSigMap, localk.d, paramWUserSigInfo);
      paramInt = i;
      if (i != 0) {
        break;
      }
      paramArrayOfByte = localy.a(localLong.longValue(), localk.b);
      if (paramArrayOfByte == null)
      {
        paramInt = -1004;
        break;
      }
      paramWUserSigInfo.get_clone(paramArrayOfByte);
      if ((localk.d != null) && (paramArrayOfByte1 != null) && (localk.d.length * 2 == paramArrayOfByte1.length))
      {
        paramInt = 0;
        while ((localk.d != null) && (paramInt < localk.d.length))
        {
          paramArrayOfByte = localy.a(localLong.longValue(), localk.d[paramInt]);
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte1[(paramInt * 2)] = ((byte[])paramArrayOfByte._userSt_Key.clone());
            paramArrayOfByte1[(paramInt * 2 + 1)] = ((byte[])paramArrayOfByte._userStSig.clone());
          }
          paramInt += 1;
        }
      }
      paramInt = 0;
      break;
      RequestReportError(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localy.f, localk.b, 0);
      break label370;
      break label303;
    }
  }
  
  private int CheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, String paramString, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    oicq.wlogin_sdk.a.h.v = false;
    oicq.wlogin_sdk.a.h.w = 0L;
    if ((paramString == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    if (paramInt == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramLong1, paramLong2, paramString, paramWUserSigInfo, "CheckSMSVerifyLoginAccount").RunReq(12);
      return -1001;
    }
    Object localObject = this.mG.a(0L);
    paramWUserSigInfo._seqence = ((y)localObject).h;
    this.mAysncSeq = ((y)localObject).h;
    k localk = y.b(((y)localObject).h);
    ((y)localObject).g = paramString;
    util.LOGI("user:" + paramString + " Seq:" + ((y)localObject).h + " CheckSMSVerifyLoginAccount ...", paramString);
    localk.j = paramWUserSigInfo._login_bitmap;
    localk.k = new ErrMsg();
    int i = new aa((y)localObject).a(paramLong1, paramLong2, this.mMainSigMap, y.W, paramString, this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
    paramInt = i;
    if (i == 208) {
      paramInt = 0;
    }
    localObject = new StringBuilder().append("user:").append(((y)localObject).g).append(" Seq:").append(((y)localObject).h).append(" CheckSMSVerifyLoginAccount ret=");
    if (paramInt > 0) {}
    for (paramWUserSigInfo = Integer.toHexString(paramInt);; paramWUserSigInfo = Integer.valueOf(paramInt))
    {
      util.LOGI(paramWUserSigInfo, paramString);
      return paramInt;
    }
  }
  
  private WloginSigInfo FindUserSig(long paramLong1, long paramLong2)
  {
    return this.mG.a(paramLong1, paramLong2);
  }
  
  private byte[] GetA1ByAccount(String paramString, long paramLong)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject2;
    Object localObject1;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      localObject2 = this.mG.b(paramString);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label111;
      }
      localObject1 = null;
    }
    while ((localObject1 == null) || (((WloginSigInfo)localObject1)._en_A1 == null) || (((WloginSigInfo)localObject1)._en_A1.length <= 0))
    {
      util.LOGI("userAccount:" + paramString + " dwAppid:" + paramLong + " GetA1ByAccount return: null", paramString);
      return null;
      localObject1 = Long.valueOf(Long.parseLong(paramString));
      label111:
      localObject2 = this.mG.a(((Long)localObject1).longValue(), paramLong);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localObject2;
      }
    }
    util.LOGI("userAccount:" + paramString + " dwAppid:" + paramLong + " GetA1ByAccount return: not null", paramString);
    return (byte[])((WloginSigInfo)localObject1)._en_A1.clone();
  }
  
  private int GetA1WithA1(String paramString, long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2)
  {
    if ((paramString == null) || (paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte3 == null) || (paramWUserSigInfo == null) || (paramWFastLoginInfo == null)) {
      return -1017;
    }
    int i = paramInt1 | 0xC0;
    if (paramInt2 == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramString, paramLong1, paramLong2, i, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramArrayOfByte2, paramArrayOfByte3, paramWUserSigInfo, paramWFastLoginInfo, "GetA1WithA1").RunReq(6);
      return -1001;
    }
    y localy = this.mG.a(0L);
    paramWUserSigInfo._seqence = localy.h;
    Object localObject1 = y.b(localy.h);
    util.LOGI("wtlogin login with GetA1WithA1:" + paramString + " dwSrcAppid:" + paramLong1 + " dwMainSigMap:" + i + " dwSubSrcAppid:" + paramLong2 + " dstAppName:" + new String(paramArrayOfByte1) + " dwDstAppid:" + paramLong4 + " dwSubDstAppid:" + paramLong5 + " Seq:" + localy.h + " ...", paramString);
    paramInt1 = util.get_saved_network_type(this.mContext);
    y.B = util.get_network_type(this.mContext);
    if (paramInt1 != y.B)
    {
      util.set_net_retry_type(this.mContext, 0);
      util.save_network_type(this.mContext, y.B);
    }
    y.D = util.get_apn_string(this.mContext).getBytes();
    localy.g = paramString;
    localy.f = 0L;
    ((k)localObject1).a = paramLong1;
    ((k)localObject1).b = paramLong1;
    ((k)localObject1).c = paramLong2;
    ((k)localObject1).e = i;
    ((k)localObject1).k = new ErrMsg();
    y.ae.add_t2(new report_t2("login", new String(y.A), System.currentTimeMillis(), paramLong4, paramLong5, null));
    Object localObject2;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      localObject2 = localy.b(paramString);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label724;
      }
      util.LOGI("user:" + paramString + " have not found uin record.", paramString);
      paramInt1 = -1003;
      paramArrayOfByte2 = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      if (paramArrayOfByte2 != null) {
        break label964;
      }
      paramArrayOfByte2 = new Ticket();
    }
    label964:
    for (;;)
    {
      y.ae.commit_t2(localy.f, localy.g, util.format_ret_code(paramInt1), paramInt1);
      if (paramInt1 == 0) {
        if ((paramArrayOfByte2._sig != null) && (paramArrayOfByte2._sig.length != 0)) {
          RequestReport(0, paramArrayOfByte2._sig, paramArrayOfByte2._sig_key, localy.f, paramLong1);
        }
      }
      for (;;)
      {
        if ((localy.d != null) && (localy.d.f() != 0))
        {
          this.mG.d = localy.d;
          RequestReportError(0, paramArrayOfByte2._sig, paramArrayOfByte2._sig_key, localy.f, paramLong1, 1);
        }
        y.b();
        localy.h();
        util.LOGI("wtlogin login with GetA1WithA1:" + paramString + " dwSrcAppid:" + paramLong1 + " dwMainSigMap:" + i + " dwSubSrcAppid:" + paramLong2 + " dstAppName:" + new String(paramArrayOfByte1) + " dwDstAppid:" + paramLong4 + " dwSubDstAppid:" + paramLong5 + " Seq:" + localy.h + " ret=" + paramInt1, paramString);
        return paramInt1;
        localObject1 = Long.valueOf(Long.parseLong(paramString));
        label724:
        localy.f = ((Long)localObject1).longValue();
        localObject2 = GetA1ByAccount(paramString, paramLong1);
        byte[] arrayOfByte = GetNoPicSigByAccount(paramString, paramLong1);
        if ((localObject2 == null) || (localObject2.length <= 0))
        {
          util.LOGI("user:" + paramString + " have no a1 or pic_sig.", paramString);
          paramInt1 = -1016;
          break;
        }
        util.LOGI("user:" + paramString + " login with A1 exchange A1.", paramString);
        paramInt2 = new q(localy).a(((Long)localObject1).longValue(), paramLong1, paramLong2, 1, i, (byte[])localObject2, arrayOfByte, this.mMiscBitmap, this.mSubSigMap, null, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramArrayOfByte2, paramArrayOfByte3, paramWUserSigInfo);
        paramInt1 = paramInt2;
        if (paramInt2 != 0) {
          break;
        }
        paramArrayOfByte2 = localy.a(((Long)localObject1).longValue(), paramLong1);
        if (paramArrayOfByte2 == null)
        {
          paramInt1 = -1004;
          break;
        }
        paramWUserSigInfo.get_clone(paramArrayOfByte2);
        paramWFastLoginInfo.get_clone(localy.j);
        paramInt1 = paramInt2;
        break;
        RequestReportError(0, paramArrayOfByte2._sig, paramArrayOfByte2._sig_key, localy.f, paramLong1, 0);
      }
    }
  }
  
  private int GetFastLoginInfo(byte[] paramArrayOfByte, k paramk)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 3) || (paramk == null)) {
      return -1017;
    }
    util.LOGD("fast login info:" + util.buf_to_string(paramArrayOfByte));
    oicq.wlogin_sdk.b.h localh = new oicq.wlogin_sdk.b.h();
    oicq.wlogin_sdk.b.n localn = new oicq.wlogin_sdk.b.n();
    bc localbc = new bc();
    Object localObject = new ao();
    int i = paramArrayOfByte.length;
    if (localh.b(paramArrayOfByte, 3, i) < 0)
    {
      util.LOGI("fast login info no tgtgt data", "");
      return -1017;
    }
    if (localn.b(paramArrayOfByte, 3, i) < 0)
    {
      util.LOGI("fast login info no gtkey data", "");
      return -1017;
    }
    if (localbc.b(paramArrayOfByte, 3, i) < 0)
    {
      util.LOGI("fast login info no nopicsig data", "");
      return -1017;
    }
    if (((ao)localObject).b(paramArrayOfByte, 3, i) > 0)
    {
      paramArrayOfByte = ((ao)localObject).b();
      localObject = y.y;
      util.LOGD("new imei:" + util.buf_to_string(paramArrayOfByte) + " old imei:" + util.buf_to_string((byte[])localObject));
      if (!Arrays.equals(paramArrayOfByte, (byte[])localObject))
      {
        util.LOGI("fast login info imei not equal", "");
        util.save_file_imei(y.r, paramArrayOfByte);
        y.y = (byte[])paramArrayOfByte.clone();
        y.z = (byte[])paramArrayOfByte.clone();
      }
    }
    paramk.f = o.b(localh.b(), localn.b());
    paramk.h = localbc.b();
    return 0;
  }
  
  public static WFastLoginInfo GetFastLoginUrl(String paramString, long paramLong)
  {
    if (paramString != null) {
      try
      {
        if (paramString.length() != 0)
        {
          util.LOGI("packageName:" + paramString + " uin:" + paramLong, "");
          if (paramLong == 1689053018L) {}
          for (String str = "http://imgcache.qq.com/wtlogin" + "/test";; str = "http://imgcache.qq.com/wtlogin" + "/app")
          {
            paramString = paramString.split("\\.");
            int i = 0;
            while (i < paramString.length)
            {
              str = str + "/";
              str = str + paramString[i];
              i += 1;
            }
          }
          paramString = new WFastLoginInfo();
          paramString.iconUrl = (str + "/icon.png");
          paramString.adUrl = (str + "/ad_img.png");
          paramString.profileUrl = (str + "/profile.js");
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
    }
    return null;
  }
  
  private byte[] GetNoPicSigByAccount(String paramString, long paramLong)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject2;
    Object localObject1;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      localObject2 = this.mG.b(paramString);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label111;
      }
      localObject1 = null;
    }
    while ((localObject1 == null) || (((WloginSigInfo)localObject1)._noPicSig == null) || (((WloginSigInfo)localObject1)._noPicSig.length <= 0))
    {
      util.LOGI("userAccount:" + paramString + " dwAppid:" + paramLong + " GetNoPicSigByAccount return: null", paramString);
      return null;
      localObject1 = Long.valueOf(Long.parseLong(paramString));
      label111:
      localObject2 = this.mG.a(((Long)localObject1).longValue(), paramLong);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localObject2;
      }
    }
    util.LOGI("userAccount:" + paramString + " dwAppid:" + paramLong + " GetNoPicSigByAccount return: not null", paramString);
    return (byte[])((WloginSigInfo)localObject1)._noPicSig.clone();
  }
  
  private int GetStWithPasswd(String paramString1, long paramLong1, int paramInt1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean1, String paramString2, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, boolean paramBoolean2, int paramInt2)
  {
    if ((paramString1 == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    int j = paramInt1 | 0xC0;
    if (paramInt2 == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramString1, paramLong1, j, paramLong2, paramArrayOfLong, paramBoolean1, paramString2, paramWUserSigInfo, paramArrayOfByte, paramBoolean2, "GetStWithPasswd").RunReq(0);
      return -1001;
    }
    paramInt1 = 1;
    y localy;
    k localk;
    Object localObject1;
    Object localObject2;
    if ((paramBoolean2) && (!oicq.wlogin_sdk.a.h.v))
    {
      if (paramWUserSigInfo._seqence == 0L) {
        paramWUserSigInfo._seqence = this.mAysncSeq;
      }
      localy = this.mG.a(paramWUserSigInfo._seqence);
      paramWUserSigInfo._seqence = localy.h;
      localk = y.b(localy.h);
      util.LOGI("wtlogin login with GetStWithPasswd:user:" + paramString1 + " dwAppid:" + paramLong1 + " dwMainSigMap:" + j + " dwSubAppid:" + paramLong2 + " Seq:" + localy.h + " ...", paramString1);
      localk.D = paramBoolean2;
      if (oicq.wlogin_sdk.a.h.w != 0L)
      {
        localk.B = oicq.wlogin_sdk.a.h.w;
        oicq.wlogin_sdk.a.h.w = 0L;
      }
      localObject1 = paramString2;
      if (paramBoolean2)
      {
        localObject1 = paramString2;
        if (paramString2.length() == 0) {
          localObject1 = localk.C;
        }
      }
      oicq.wlogin_sdk.a.h.v = false;
      oicq.wlogin_sdk.a.h.x = "";
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() > 16) {
          localObject2 = ((String)localObject1).substring(0, 16);
        }
      }
      paramInt2 = util.get_saved_network_type(this.mContext);
      y.B = util.get_network_type(this.mContext);
      if (paramInt2 != y.B)
      {
        util.set_net_retry_type(this.mContext, 0);
        util.save_network_type(this.mContext, y.B);
      }
      y.D = util.get_apn_string(this.mContext).getBytes();
      localy.g = paramString1;
      localy.f = 0L;
      localk.a = paramLong1;
      localk.b = paramLong1;
      localk.d = null;
      localk.c = paramLong2;
      localk.e = j;
      localk.j = paramWUserSigInfo._login_bitmap;
      localk.k = new ErrMsg();
      if (paramArrayOfLong != null) {
        localk.d = ((long[])paramArrayOfLong.clone());
      }
      if ((paramWUserSigInfo._reserveData == null) || (paramWUserSigInfo._reserveData.length <= 3)) {
        break label936;
      }
      localy.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
      util.LOGI("MSF SSO SEQ:" + localy.i, paramString1);
      label508:
      y.ae.add_t2(new report_t2("login", new String(y.A), System.currentTimeMillis(), paramLong1, paramLong2, paramArrayOfLong));
      if (util.check_uin_account(paramString1).booleanValue()) {
        break label945;
      }
      localObject1 = localy.b(paramString1);
      paramString2 = (String)localObject1;
      if (localObject1 == null)
      {
        paramInt1 = 0;
        paramString2 = (String)localObject1;
      }
      label576:
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break label980;
      }
      if (!paramBoolean1) {
        break label967;
      }
    }
    try
    {
      localk.f = ((byte[])((String)localObject2).getBytes("ISO-8859-1").clone());
      label613:
      localk.g = 0;
      label619:
      if (paramInt1 != 0) {
        break label1203;
      }
      if (paramString1.length() <= util.MAX_NAME_LEN) {
        break label1131;
      }
      paramInt1 = -1008;
    }
    catch (Exception paramArrayOfLong)
    {
      label936:
      label945:
      for (;;)
      {
        label639:
        paramInt1 = -1013;
      }
    }
    paramArrayOfLong = GetUserSigInfoTicket(paramWUserSigInfo, 128);
    if (paramArrayOfLong == null) {
      paramArrayOfLong = new Ticket();
    }
    for (;;)
    {
      y.ae.commit_t2(localy.f, localy.g, util.format_ret_code(paramInt1), paramInt1);
      if (paramInt1 == 0) {
        if ((paramArrayOfLong._sig != null) && (paramArrayOfLong._sig.length != 0)) {
          RequestReport(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localy.f, localk.b);
        }
      }
      for (;;)
      {
        if ((localy.d != null) && (localy.d.f() != 0))
        {
          this.mG.d = localy.d;
          RequestReportError(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localy.f, localk.b, 1);
        }
        y.b();
        localy.h();
        util.LOGI("wtlogin login with GetStWithPasswd:user:" + paramString1 + " dwAppid:" + paramLong1 + " dwMainSigMap:" + j + " dwSubAppid:" + paramLong2 + " Seq:" + localy.h + " ret=" + paramInt1, "" + localy.f);
        return paramInt1;
        localy = this.mG.a(0L);
        paramWUserSigInfo._seqence = localy.h;
        this.mAysncSeq = localy.h;
        break;
        localy.i = 0;
        break label508;
        paramString2 = Long.valueOf(Long.parseLong(paramString1));
        break label576;
        label967:
        localk.f = MD5.toMD5Byte((String)localObject2);
        break label613;
        label980:
        if ((paramWUserSigInfo._fastLoginBuf != null) && (paramWUserSigInfo._fastLoginBuf.length > 0))
        {
          util.LOGI("GetFastLoginInfo ...", paramString1);
          if (GetFastLoginInfo(paramWUserSigInfo._fastLoginBuf, localk) >= 0) {
            break label1070;
          }
          util.LOGI("GetFastLoginInfo failed", paramString1);
          paramInt1 = -1017;
          break label639;
        }
        if ((oicq.wlogin_sdk.code2d.c.q != null) && (oicq.wlogin_sdk.code2d.c.q.length > 0))
        {
          localk.f = oicq.wlogin_sdk.code2d.c.q;
          localk.h = oicq.wlogin_sdk.code2d.c.r;
          oicq.wlogin_sdk.code2d.c.q = null;
          oicq.wlogin_sdk.code2d.c.r = null;
        }
        for (;;)
        {
          label1070:
          if ((localk.f != null) && (localk.f.length >= 16)) {
            break label1122;
          }
          paramInt1 = -1016;
          break;
          localk.f = GetA1ByAccount(paramString1, paramLong1);
          localk.h = GetNoPicSigByAccount(paramString1, paramLong1);
        }
        label1122:
        localk.g = 1;
        break label619;
        label1131:
        paramInt2 = new x(localy).a(paramLong1, paramLong2, 1, j, paramString1.getBytes(), y.w, 0, 0, 1, this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, paramWUserSigInfo);
        paramInt1 = paramInt2;
        if (paramInt2 != 0) {
          break label639;
        }
        paramString2 = localy.b(paramString1);
        if (paramString2 == null)
        {
          paramInt1 = -1003;
          break label639;
        }
        label1203:
        localy.f = paramString2.longValue();
        util.LOGD("GetStWithPasswd uin=" + localy.f);
        if ((paramWUserSigInfo._in_ksid != null) && (paramWUserSigInfo._in_ksid.length > 0)) {}
        for (localObject1 = (byte[])paramWUserSigInfo._in_ksid.clone();; localObject1 = y.W)
        {
          if (localk.g == 0) {
            break label1472;
          }
          util.LOGI("user:" + paramString1 + " login with saved A1.", "" + localy.f);
          paramInt1 = new p(localy).a(paramLong1, paramLong2, 1, localy.f, 0, y.Z, localk.f, localk.h, this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, j, paramLong2, 1, y.w, 0, 0, 1, (byte[])localObject1, paramWUserSigInfo);
          paramInt2 = paramInt1;
          if (paramInt1 == 204) {
            paramInt2 = new u(localy).a(this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, paramWUserSigInfo);
          }
          paramInt1 = paramInt2;
          if (paramInt2 != 0) {
            break;
          }
          localObject1 = localy.a(paramString2.longValue(), paramLong1);
          if (localObject1 != null) {
            break label1624;
          }
          paramInt1 = -1004;
          break;
        }
        label1472:
        util.LOGI("user:" + paramString1 + " login with input password.", "" + localy.f);
        localObject2 = new byte[4];
        util.int64_to_buf32((byte[])localObject2, 0, System.currentTimeMillis() / 1000L + y.Y);
        if (paramBoolean2) {}
        for (paramInt1 = 3;; paramInt1 = 1)
        {
          paramInt1 = new p(localy).a(paramLong1, paramLong2, 1, localy.f, 0, y.Z, (byte[])localObject2, 0, localk.f, paramInt1, this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, j, paramLong2, 1, y.w, 0, 0, 1, (byte[])localObject1, paramWUserSigInfo);
          break;
        }
        label1624:
        paramWUserSigInfo.get_clone((WloginSigInfo)localObject1);
        paramInt1 = paramInt2;
        if (paramArrayOfLong == null) {
          break label639;
        }
        paramInt1 = paramInt2;
        if (paramArrayOfByte == null) {
          break label639;
        }
        paramInt1 = paramInt2;
        if (paramArrayOfLong.length * 2 != paramArrayOfByte.length) {
          break label639;
        }
        int i = 0;
        for (;;)
        {
          paramInt1 = paramInt2;
          if (paramArrayOfLong == null) {
            break;
          }
          paramInt1 = paramInt2;
          if (i >= paramArrayOfLong.length) {
            break;
          }
          localObject1 = localy.a(paramString2.longValue(), paramArrayOfLong[i]);
          if (localObject1 != null)
          {
            paramArrayOfByte[(i * 2)] = ((byte[])((WloginSigInfo)localObject1)._userSt_Key.clone());
            paramArrayOfByte[(i * 2 + 1)] = ((byte[])((WloginSigInfo)localObject1)._userStSig.clone());
          }
          i += 1;
        }
        if ((paramInt1 != 2) && (paramInt1 != 160)) {
          RequestReportError(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localy.f, localk.b, 0);
        }
      }
    }
  }
  
  private int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt1, long paramLong4, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2, int paramInt2)
  {
    if ((paramString == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    int j = paramInt1 | 0xC0;
    if (paramInt2 == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramString, paramLong1, paramLong2, paramLong3, j, paramLong4, paramArrayOfLong, paramWUserSigInfo, paramArrayOfByte1, paramArrayOfByte2, "GetStWithoutPasswd").RunReq(5);
      return -1001;
    }
    y localy = this.mG.a(0L);
    paramWUserSigInfo._seqence = localy.h;
    k localk = y.b(localy.h);
    util.LOGI("wtlogin login with GetStWithoutPasswd:user:" + paramString + " dwSrcAppid:" + paramLong1 + " dwDstAppid:" + paramLong2 + " dwDstAppPri:" + paramLong3 + " dwMainSigMap:" + j + " dwSubDstAppid:" + paramLong4 + " Seq:" + localy.h + " ...", paramString);
    paramInt1 = util.get_saved_network_type(this.mContext);
    y.B = util.get_network_type(this.mContext);
    if (paramInt1 != y.B)
    {
      util.set_net_retry_type(this.mContext, 0);
      util.save_network_type(this.mContext, y.B);
    }
    y.D = util.get_apn_string(this.mContext).getBytes();
    localy.g = paramString;
    localy.f = 0L;
    localk.a = paramLong1;
    localk.b = paramLong2;
    localk.c = paramLong4;
    localk.e = j;
    localk.k = new ErrMsg();
    if (paramArrayOfLong != null) {
      localk.d = ((long[])paramArrayOfLong.clone());
    }
    if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
    {
      localy.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
      util.LOGI("MSF SSO SEQ:" + localy.i, paramString);
    }
    for (;;)
    {
      y.ae.add_t2(new report_t2("exchg", new String(y.A), System.currentTimeMillis(), paramLong2, paramLong4, paramArrayOfLong));
      if (util.check_uin_account(paramString).booleanValue()) {
        break;
      }
      localLong = localy.b(paramString);
      if (localLong != null) {
        break label1801;
      }
      util.LOGI("user:" + paramString + " have not found uin record.", paramString);
      paramInt1 = -1003;
      paramArrayOfLong = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      if (paramArrayOfLong != null) {
        break label1798;
      }
      paramArrayOfLong = new Ticket();
      label497:
      y.ae.commit_t2(localy.f, localy.g, util.format_ret_code(paramInt1), paramInt1);
      if (paramInt1 != 0) {
        break label1768;
      }
      if ((paramArrayOfLong._sig != null) && (paramArrayOfLong._sig.length != 0)) {
        RequestReport(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localy.f, localk.b);
      }
      label568:
      if ((localy.d != null) && (localy.d.f() != 0))
      {
        this.mG.d = localy.d;
        RequestReportError(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localy.f, localk.b, 1);
      }
      y.b();
      localy.h();
      util.LOGI("wtlogin login with GetStWithoutPasswd:user:" + paramString + " dwSrcAppid:" + paramLong1 + " dwDstAppid:" + paramLong2 + " dwDstAppPri:" + paramLong3 + " dwMainSigMap:" + j + " dwSubDstAppid:" + paramLong4 + " Seq:" + localy.h + " ret=" + paramInt1, "" + localy.f);
      return paramInt1;
      localy.i = 0;
    }
    Long localLong = Long.valueOf(Long.parseLong(paramString));
    label1798:
    label1801:
    for (;;)
    {
      localy.f = localLong.longValue();
      if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length == 4) && (paramArrayOfByte2[0] != null) && (paramArrayOfByte2[0].length == 1) && (paramArrayOfByte2[0][0] == 1))
      {
        util.LOGI("user:" + paramString + " exchange A2 from A2/D2/KEY.", "" + localy.f);
        if ((paramArrayOfByte2[1] == null) || (paramArrayOfByte2[2] == null) || (paramArrayOfByte2[3] == null))
        {
          paramInt1 = -1004;
          break;
        }
        localy.b = MD5.toMD5Byte(paramArrayOfByte2[3]);
        paramInt2 = new r(localy).a(localLong.longValue(), paramLong2, paramLong4, 1, j, paramArrayOfByte2[1], this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, paramArrayOfByte2[2], paramWUserSigInfo);
      }
      for (;;)
      {
        paramInt1 = paramInt2;
        if (paramInt2 != 0) {
          break;
        }
        paramArrayOfByte2 = localy.a(localLong.longValue(), paramLong2);
        if (paramArrayOfByte2 != null) {
          break label1635;
        }
        paramInt1 = -1004;
        break;
        if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length == 3) && (paramArrayOfByte2[0] != null) && (paramArrayOfByte2[0].length == 1) && (paramArrayOfByte2[0][0] == 2))
        {
          util.LOGI("user:" + paramString + " exchange A2 from A2/A2KEY.", "" + localy.f);
          if ((paramArrayOfByte2[1] == null) || (paramArrayOfByte2[2] == null))
          {
            paramInt1 = -1004;
            break;
          }
          localy.b = paramArrayOfByte2[2];
          paramInt2 = new r(localy).a(localLong.longValue(), paramLong2, paramLong4, 1, j, paramArrayOfByte2[1], this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, null, paramWUserSigInfo);
          continue;
        }
        byte[] arrayOfByte1 = GetA1ByAccount(String.valueOf(localy.f), paramLong1);
        byte[] arrayOfByte2 = GetNoPicSigByAccount(String.valueOf(localy.f), paramLong1);
        if ((arrayOfByte1 != null) && (arrayOfByte1.length > 0) && (arrayOfByte2 != null) && (arrayOfByte2.length > 0))
        {
          util.LOGI("user:" + paramString + " exchange A2 from A1.", "" + localy.f);
          localk.f = arrayOfByte1;
          localk.h = arrayOfByte2;
          if ((paramWUserSigInfo._in_ksid != null) && (paramWUserSigInfo._in_ksid.length > 0)) {}
          for (paramArrayOfByte2 = (byte[])paramWUserSigInfo._in_ksid.clone();; paramArrayOfByte2 = y.W)
          {
            paramInt2 = new ad(localy).a(paramLong2, 1, localy.f, 0, y.Z, arrayOfByte1, arrayOfByte2, this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, j, paramLong4, 1, y.w, 0, 0, 1, paramArrayOfByte2, paramLong1, paramWUserSigInfo);
            paramInt1 = paramInt2;
            if (paramInt2 == 204) {
              paramInt1 = new u(localy).a(this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, paramWUserSigInfo);
            }
            paramInt2 = paramInt1;
            break;
          }
        }
        util.LOGI("user:" + paramString + " exchange A2 from A2.", "" + localy.f);
        paramArrayOfByte2 = localy.a(localLong.longValue(), paramLong1);
        if ((paramArrayOfByte2 == null) || (paramArrayOfByte2._TGT == null) || (paramArrayOfByte2._TGT.length == 0) || (paramArrayOfByte2.iSExpireA2(y.f())))
        {
          paramInt1 = -1004;
          break;
        }
        util.LOGI("user:" + paramString + " exchange A2 from A2 without Priority.", "" + localy.f);
        localy.b = paramArrayOfByte2._TGTKey;
        paramInt2 = new r(localy).a(localLong.longValue(), paramLong2, paramLong4, 1, j, paramArrayOfByte2._TGT, this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, null, paramWUserSigInfo);
      }
      label1635:
      paramWUserSigInfo.get_clone(paramArrayOfByte2);
      paramInt1 = paramInt2;
      if (paramArrayOfLong == null) {
        break;
      }
      paramInt1 = paramInt2;
      if (paramArrayOfByte1 == null) {
        break;
      }
      paramInt1 = paramInt2;
      if (paramArrayOfLong.length * 2 != paramArrayOfByte1.length) {
        break;
      }
      int i = 0;
      for (;;)
      {
        paramInt1 = paramInt2;
        if (paramArrayOfLong == null) {
          break;
        }
        paramInt1 = paramInt2;
        if (i >= paramArrayOfLong.length) {
          break;
        }
        paramArrayOfByte2 = localy.a(localLong.longValue(), paramArrayOfLong[i]);
        if (paramArrayOfByte2 != null)
        {
          paramArrayOfByte1[(i * 2)] = ((byte[])paramArrayOfByte2._userSt_Key.clone());
          paramArrayOfByte1[(i * 2 + 1)] = ((byte[])paramArrayOfByte2._userStSig.clone());
        }
        i += 1;
      }
      label1768:
      RequestReportError(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localy.f, localk.b, 0);
      break label568;
      break label497;
    }
  }
  
  public static byte[] GetTicketSig(WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    paramWUserSigInfo = GetUserSigInfoTicket(paramWUserSigInfo, paramInt);
    if (paramWUserSigInfo != null) {
      return paramWUserSigInfo._sig;
    }
    return new byte[0];
  }
  
  public static byte[] GetTicketSigKey(WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if ((paramInt != 64) && (paramInt != 262144) && (paramInt != 128) && (paramInt != 16384) && (paramInt != 32768)) {
      throw null;
    }
    paramWUserSigInfo = GetUserSigInfoTicket(paramWUserSigInfo, paramInt);
    if (paramWUserSigInfo != null) {
      return paramWUserSigInfo._sig_key;
    }
    return new byte[0];
  }
  
  public static Ticket GetUserSigInfoTicket(WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if (paramWUserSigInfo == null)
    {
      util.LOGI("userInfo is null " + Integer.toHexString(paramInt), "");
      return null;
    }
    if (paramWUserSigInfo._tickets == null)
    {
      util.LOGI("tickets is null " + Integer.toHexString(paramInt), "");
      return null;
    }
    util.LOGI(" ticket type:" + Integer.toHexString(paramInt), "");
    if ((paramWUserSigInfo != null) && (paramWUserSigInfo._tickets != null))
    {
      int i = 0;
      while (i < paramWUserSigInfo._tickets.size())
      {
        Ticket localTicket = (Ticket)paramWUserSigInfo._tickets.get(i);
        if (localTicket._type == paramInt)
        {
          util.LOGI(" type:" + Integer.toHexString(paramInt) + " sig:" + util.buf_len(localTicket._sig) + " key:" + util.buf_len(localTicket._sig_key) + " create time:" + localTicket._create_time + " expire time:" + localTicket._expire_time, "");
          return localTicket;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private void OnDeviceLockRequest(String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    DevlockRst localDevlockRst = DevlockBase.rst;
    localDevlockRst.commRsp = new oicq.wlogin_sdk.devicelock.h();
    DevlockInfo localDevlockInfo = new DevlockInfo();
    ErrMsg localErrMsg = new ErrMsg(0, "", "", "");
    if (paramInt != 0)
    {
      util.LOGI("OnDeviceLockRequest ret:" + paramInt, paramString);
      localErrMsg.setMessage(util.get_error_msg(paramInt));
      localErrMsg.setTitle(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_5));
    }
    switch (paramTransReqContext.get_subcmd())
    {
    }
    int i;
    label594:
    do
    {
      do
      {
        do
        {
          return;
          i = paramInt;
          if (paramInt == 0)
          {
            paramInt = new oicq.wlogin_sdk.devicelock.a().parse_rsp(paramTransReqContext.get_body());
            util.LOGI("CheckDevLockStatus ret:" + paramInt, paramString);
            i = paramInt;
            if (paramInt != -1009)
            {
              tlvCommRsp2ErrMsg(localDevlockRst.commRsp, localErrMsg);
              if ((localDevlockRst.devSetupInfo != null) && (localDevlockRst.devSetupInfo.get_data_len() > 0))
              {
                localDevlockInfo.DevSetup = localDevlockRst.devSetupInfo.a;
                localDevlockInfo.AllowSet = localDevlockRst.devSetupInfo.b;
                if ((localDevlockRst.devGuideInfo == null) || (localDevlockRst.devGuideInfo.get_data_len() <= 0)) {
                  break label594;
                }
              }
            }
          }
          for (localDevlockInfo.ProtectIntro = new String(localDevlockRst.devGuideInfo.a);; localDevlockInfo.ProtectIntro = new String(localDevlockRst.devSetupInfo.d))
          {
            localDevlockInfo.WarningInfo = new String(localDevlockRst.devSetupInfo.g);
            localDevlockInfo.WarningTitle = new String(localDevlockRst.devSetupInfo.e);
            localDevlockInfo.WarningMsg = new String(localDevlockRst.devSetupInfo.f);
            localDevlockInfo.WarningInfoType = localDevlockRst.devSetupInfo.c;
            if ((localDevlockRst.mbMobileInfo != null) && (localDevlockRst.mbMobileInfo.get_data_len() > 0))
            {
              localDevlockInfo.CountryCode = new String(localDevlockRst.mbMobileInfo.a);
              localDevlockInfo.Mobile = new String(localDevlockRst.mbMobileInfo.b);
              localDevlockInfo.MbItemSmsCodeStatus = localDevlockRst.mbMobileInfo.c;
              localDevlockInfo.AvailableMsgCount = localDevlockRst.mbMobileInfo.d;
              localDevlockInfo.TimeLimit = localDevlockRst.mbMobileInfo.e;
            }
            i = paramInt;
            if (localDevlockRst.mbGuideInfo != null)
            {
              i = paramInt;
              if (localDevlockRst.mbGuideInfo.get_data_len() > 0)
              {
                localDevlockInfo.MbGuideType = localDevlockRst.mbGuideInfo.c;
                localDevlockInfo.MbGuideInfoType = localDevlockRst.mbGuideInfo.d;
                localDevlockInfo.MbGuideInfo = new String(localDevlockRst.mbGuideInfo.b);
                localDevlockInfo.MbGuideMsg = new String(localDevlockRst.mbGuideInfo.a);
                i = paramInt;
              }
            }
            if (this.mListener == null) {
              break;
            }
            this.mListener.OnCheckDevLockStatus(paramWUserSigInfo, localDevlockInfo, i, localErrMsg);
            return;
          }
          i = paramInt;
          if (paramInt == 0)
          {
            paramInt = new oicq.wlogin_sdk.devicelock.b().parse_rsp(paramTransReqContext.get_body());
            util.LOGI("CloseDevLock ret:" + paramInt, paramString);
            i = paramInt;
            if (paramInt != -1009)
            {
              tlvCommRsp2ErrMsg(localDevlockRst.commRsp, localErrMsg);
              i = paramInt;
            }
          }
        } while (this.mListener == null);
        this.mListener.OnCloseDevLock(paramWUserSigInfo, i, localErrMsg);
        return;
        i = paramInt;
        if (paramInt == 0)
        {
          paramInt = new oicq.wlogin_sdk.devicelock.d().parse_rsp(paramTransReqContext.get_body());
          util.LOGI("AskDevLockSms ret:" + paramInt, paramString);
          i = paramInt;
          if (paramInt != -1009)
          {
            tlvCommRsp2ErrMsg(localDevlockRst.commRsp, localErrMsg);
            i = paramInt;
            if (localDevlockRst.smsInfo != null)
            {
              localDevlockInfo.AvailableMsgCount = localDevlockRst.smsInfo.a;
              localDevlockInfo.TimeLimit = localDevlockRst.smsInfo.b;
              i = paramInt;
            }
          }
        }
      } while (this.mListener == null);
      this.mListener.OnAskDevLockSms(paramWUserSigInfo, localDevlockInfo, i, localErrMsg);
      return;
      i = paramInt;
      if (paramInt == 0)
      {
        paramInt = new oicq.wlogin_sdk.devicelock.f().parse_rsp(paramTransReqContext.get_body());
        util.LOGI("CheckDevLockSms ret:" + paramInt, paramString);
        i = paramInt;
        if (paramInt != -1009)
        {
          tlvCommRsp2ErrMsg(localDevlockRst.commRsp, localErrMsg);
          i = paramInt;
        }
      }
    } while (this.mListener == null);
    this.mListener.OnCheckDevLockSms(paramWUserSigInfo, i, localErrMsg);
  }
  
  private void OnRequestCode2d(String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if (this.mListener == null) {
      return;
    }
    oicq.wlogin_sdk.code2d.c localc = oicq.wlogin_sdk.code2d.b._status;
    if (paramInt != 0) {
      util.LOGI("OnRequestCode2d ret:" + paramInt, paramString);
    }
    switch (paramTransReqContext.get_subcmd())
    {
    default: 
      util.LOGW("OnRequestName unhandle cmd", "", paramString);
      this.mListener.OnException(new ErrMsg(), 9, paramWUserSigInfo);
      return;
    case 19: 
      if (paramInt != 0)
      {
        this.mListener.OnVerifyCode(paramString, localc.d, localc.c, localc.e, paramWUserSigInfo, localc.f, paramInt);
        return;
      }
      localc.b = new oicq.wlogin_sdk.code2d.e().a(paramTransReqContext.get_body());
      util.LOGI("VerifyCode ret:" + localc.b, paramString);
      if ((localc.b == 0) && (localc.g != null) && (localc.g.length > 0)) {
        this.mG.a(localc.a, paramLong1, localc.g);
      }
      this.mListener.OnVerifyCode(paramString, localc.d, localc.c, localc.e, paramWUserSigInfo, localc.f, localc.b);
      return;
    case 20: 
      if (paramInt != 0)
      {
        this.mListener.OnCloseCode(paramString, localc.d, localc.c, paramWUserSigInfo, localc.f, paramInt);
        return;
      }
      localc.b = new oicq.wlogin_sdk.code2d.a().a(paramTransReqContext.get_body(), paramLong1, y.r);
      util.LOGI("CloseCode ret:" + localc.b, paramString);
      oicq.wlogin_sdk.code2d.c.s = false;
      this.mListener.OnCloseCode(paramString, localc.d, localc.c, paramWUserSigInfo, localc.f, localc.b);
      return;
    case 49: 
      if (paramInt == 0)
      {
        paramInt = new fetch_code().get_response(paramTransReqContext.get_body());
        util.LOGI("FetchCodeSig ret:" + localc.b, paramString);
      }
      break;
    }
    for (;;)
    {
      this.mListener.OnFetchCodeSig(localc.j, localc.k, localc.l, paramWUserSigInfo, localc.f, paramInt);
      return;
      if (paramInt == 0)
      {
        paramInt = new oicq.wlogin_sdk.code2d.d().a(paramTransReqContext.get_body());
        util.LOGI("QueryCodeResult ret:" + localc.b, paramString);
      }
      for (;;)
      {
        this.mListener.OnQueryCodeResult(localc.a, localc.m, new String(localc.n), localc.o, new String(localc.p), localc.e, localc.c, paramWUserSigInfo, localc.f, paramInt);
        return;
      }
    }
  }
  
  private void OnRequestRegister(String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    String str = InternationMsg.a(InternationMsg.MSG_TYPE.MSG_3);
    if (paramInt != 0) {
      if (this.mListener != null) {
        this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
      }
    }
    label281:
    label895:
    do
    {
      oicq.wlogin_sdk.a.h localh;
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
                                          do
                                          {
                                            do
                                            {
                                              do
                                              {
                                                return;
                                                localh = this.mRegStatus;
                                                if (paramTransReqContext.get_subcmd() != 10) {
                                                  break label281;
                                                }
                                                paramInt = oicq.wlogin_sdk.a.a.a(paramTransReqContext.get_body(), localh);
                                                if (paramInt == 0) {
                                                  break;
                                                }
                                              } while (this.mListener == null);
                                              this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
                                              return;
                                              util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localh.d, "");
                                              if (localh.d != 0) {
                                                break;
                                              }
                                            } while (this.mListener == null);
                                            this.mListener.OnRegCheckDownloadMsg(paramWUserSigInfo, localh.l, localh.m);
                                            return;
                                            if (localh.d != 2) {
                                              break;
                                            }
                                          } while (this.mListener == null);
                                          this.mListener.OnRegCheckUploadMsg(paramWUserSigInfo, localh.n, localh.o);
                                          return;
                                          if (localh.d != 3) {
                                            break;
                                          }
                                        } while (this.mListener == null);
                                        this.mListener.OnRegCheckValidUrl(paramWUserSigInfo, localh.p);
                                        return;
                                        util.LOGW("OnRequestRegister 0xa return code:", String.valueOf(localh.d), paramString);
                                      } while (this.mListener == null);
                                      this.mListener.OnRegError(paramWUserSigInfo, localh.d, localh.f);
                                      return;
                                      if (paramTransReqContext.get_subcmd() != 3) {
                                        break label528;
                                      }
                                      paramInt = oicq.wlogin_sdk.a.a.a(paramTransReqContext.get_body(), localh);
                                      if (paramInt == 0) {
                                        break;
                                      }
                                    } while (this.mListener == null);
                                    this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
                                    return;
                                    util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localh.d, "");
                                    if (localh.d != 0) {
                                      break;
                                    }
                                  } while (this.mListener == null);
                                  this.mListener.OnRegQueryClientSendedMsgStatus(paramWUserSigInfo, localh.d, localh.q, localh.r);
                                  return;
                                  if (localh.d != 3) {
                                    break;
                                  }
                                } while (this.mListener == null);
                                this.mListener.OnRegCheckValidUrl(paramWUserSigInfo, localh.p);
                                return;
                                if (localh.d != 4) {
                                  break;
                                }
                              } while (this.mListener == null);
                              this.mListener.OnRegQueryClientSendedMsgStatus(paramWUserSigInfo, localh.d, localh.q, localh.r);
                              return;
                              util.LOGW("OnRequestRegister 0x3 return code:", String.valueOf(localh.d), paramString);
                            } while (this.mListener == null);
                            this.mListener.OnRegError(paramWUserSigInfo, localh.d, localh.f);
                            return;
                            if (paramTransReqContext.get_subcmd() != 4) {
                              break label775;
                            }
                            paramInt = oicq.wlogin_sdk.a.a.a(paramTransReqContext.get_body(), localh);
                            if (paramInt == 0) {
                              break;
                            }
                          } while (this.mListener == null);
                          this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
                          return;
                          util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localh.d, "");
                          if (localh.d != 0) {
                            break;
                          }
                        } while (this.mListener == null);
                        this.mListener.OnRegRequestServerResendMsg(paramWUserSigInfo, localh.d, localh.q, localh.r);
                        return;
                        if (localh.d != 3) {
                          break;
                        }
                      } while (this.mListener == null);
                      this.mListener.OnRegCheckValidUrl(paramWUserSigInfo, localh.p);
                      return;
                      if (localh.d != 5) {
                        break;
                      }
                    } while (this.mListener == null);
                    this.mListener.OnRegRequestServerResendMsg(paramWUserSigInfo, localh.d, localh.q, localh.r);
                    return;
                    util.LOGW("OnRequestRegister 0x4 return code:", String.valueOf(localh.d), paramString);
                  } while (this.mListener == null);
                  this.mListener.OnRegError(paramWUserSigInfo, localh.d, localh.f);
                  return;
                  if (paramTransReqContext.get_subcmd() != 5) {
                    break label895;
                  }
                  paramInt = oicq.wlogin_sdk.a.a.b(paramTransReqContext.get_body(), localh);
                  if (paramInt == 0) {
                    break;
                  }
                } while (this.mListener == null);
                this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
                return;
                util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localh.d, "");
              } while (this.mListener == null);
              this.mListener.OnRegSubmitMsgChk(paramWUserSigInfo, localh.d, localh.f);
              return;
              if (paramTransReqContext.get_subcmd() != 6) {
                break label1250;
              }
              paramInt = oicq.wlogin_sdk.a.a.c(paramTransReqContext.get_body(), localh);
              if (paramInt == 0) {
                break;
              }
            } while (this.mListener == null);
            this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
            return;
            util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localh.d, "");
          } while (this.mListener == null);
          if ((localh.b != null) && (localh.b.indexOf("-") > 0))
          {
            paramInt = localh.b.indexOf("-");
            paramString = localh.b.substring(0, paramInt);
            if (!paramString.equals("86")) {
              break label1172;
            }
          }
          for (localh.b = localh.b.substring(paramInt + 1);; localh.b = ("00" + paramString + localh.b.substring(paramInt + 1)))
          {
            if ((localh.b != null) && (localh.b.length() != 0)) {
              this.mG.d(localh.b);
            }
            util.LOGI("userAccount: " + localh.b);
            if (oicq.wlogin_sdk.a.h.x.length() <= 0) {
              break;
            }
            this.mListener.OnRegGetSMSVerifyLoginAccount(paramWUserSigInfo, localh.d, localh.s, localh.t, localh.u, localh.f);
            return;
          }
          this.mListener.OnRegGetAccount(paramWUserSigInfo, localh.d, localh.s, localh.t, localh.u, localh.f);
          return;
          if (paramTransReqContext.get_subcmd() != 7) {
            break label1371;
          }
          paramInt = oicq.wlogin_sdk.a.a.d(paramTransReqContext.get_body(), localh);
          if (paramInt == 0) {
            break;
          }
        } while (this.mListener == null);
        this.mListener.OnRegError(paramWUserSigInfo, paramInt, str.getBytes());
        return;
        util.LOGI("reg cmd:" + paramTransReqContext.get_subcmd() + " ret:" + localh.d, "");
      } while (this.mListener == null);
      this.mListener.OnRegQueryAccount(paramWUserSigInfo, localh.d, localh.f);
      return;
      util.LOGW("OnRequestRegister unhandle cmd:" + paramTransReqContext.get_subcmd(), "", paramString);
    } while (this.mListener == null);
    label528:
    label1172:
    label1250:
    this.mListener.OnRegError(paramWUserSigInfo, -1010, str.getBytes());
    label775:
    label1371:
    return;
  }
  
  private int RefreshPictureData(String paramString, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    int i = 0;
    if ((paramString == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    if (paramInt == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramString, paramWUserSigInfo, "RefreshPictureData").RunReq(1);
      return -1001;
    }
    if (paramWUserSigInfo._seqence == 0L) {
      paramWUserSigInfo._seqence = this.mAysncSeq;
    }
    y localy = this.mG.a(paramWUserSigInfo._seqence);
    paramWUserSigInfo._seqence = localy.h;
    k localk = y.b(localy.h);
    util.LOGI("user:" + paramString + " Seq:" + localy.h + " RefreshPictureData ...", "" + paramString);
    localy.g = paramString;
    localk.k = new ErrMsg();
    Long localLong;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      localLong = localy.b(paramString);
      if (localLong == null) {
        break label330;
      }
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt == 1) {
        localy.f = localLong.longValue();
      }
      paramInt = new v(localy).a(this.mMiscBitmap, this.mSubSigMap, localk.d, paramWUserSigInfo);
      if (paramInt == 2) {
        paramInt = i;
      }
      for (;;)
      {
        util.LOGI("user:" + paramString + " Seq:" + localy.h + " RefreshPictureData ret=" + paramInt, "" + paramString);
        return paramInt;
        localLong = Long.valueOf(Long.parseLong(paramString));
        paramInt = 1;
        break;
      }
      label330:
      paramInt = 0;
    }
  }
  
  private int RefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if ((paramString == null) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    if (paramInt == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramString, paramLong, paramWUserSigInfo, "RefreshSMSData").RunReq(3);
      return -1001;
    }
    if (paramWUserSigInfo._seqence == 0L) {
      paramWUserSigInfo._seqence = this.mAysncSeq;
    }
    y localy = this.mG.a(paramWUserSigInfo._seqence);
    paramWUserSigInfo._seqence = localy.h;
    k localk = y.b(localy.h);
    util.LOGI("user:" + paramString + " smsAppid:" + paramLong + " Seq:" + localy.h + " RefreshSMSData ...", "" + paramString);
    localy.g = paramString;
    localk.k = new ErrMsg();
    Long localLong;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      localLong = localy.b(paramString);
      if (localLong == null) {
        break label367;
      }
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt == 1) {
        localy.f = localLong.longValue();
      }
      int i = new w(localy).a(paramLong, this.mMiscBitmap, this.mSubSigMap, localk.d, paramWUserSigInfo);
      paramInt = i;
      if (i == 160) {
        paramInt = 0;
      }
      util.LOGI("user:" + paramString + " smsAppid:" + paramLong + " Seq:" + localy.h + " RefreshSMSData ret=" + paramInt, "" + paramString);
      return paramInt;
      localLong = Long.valueOf(Long.parseLong(paramString));
      paramInt = 1;
      continue;
      label367:
      paramInt = 0;
    }
  }
  
  private int RefreshSMSVerifyLoginCode(String paramString, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return -1017;
    }
    if (paramInt == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramString, paramWUserSigInfo, "RefreshSMSVerifyLoginCode").RunReq(14);
      return -1001;
    }
    if (paramWUserSigInfo._seqence == 0L) {
      paramWUserSigInfo._seqence = this.mAysncSeq;
    }
    Object localObject = this.mG.a(paramWUserSigInfo._seqence);
    paramWUserSigInfo._seqence = ((y)localObject).h;
    k localk = y.b(((y)localObject).h);
    util.LOGI("user:" + paramString + " Seq:" + ((y)localObject).h + " RefreshSMSVerifyLoginCode ...", paramString);
    ((y)localObject).g = paramString;
    localk.k = new ErrMsg();
    paramInt = new ab((y)localObject).a(this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
    localObject = new StringBuilder().append("user:").append(((y)localObject).g).append(" Seq:").append(((y)localObject).h).append(" RefreshSMSVerifyLoginCode ret=");
    if (paramInt > 0) {}
    for (paramWUserSigInfo = Integer.toHexString(paramInt);; paramWUserSigInfo = Integer.valueOf(paramInt))
    {
      util.LOGI(paramWUserSigInfo, paramString);
      return paramInt;
    }
  }
  
  private int RequestInit()
  {
    try
    {
      int i = util.get_saved_network_type(this.mContext);
      y.d();
      int j = ShareKeyInit();
      AsyncGenRSAKey();
      util.LOGI("WtloginHelper init ok, ret:" + j + " android version:" + new String(y.H) + " saved_network_type:" + i + " network_type:" + y.B + " release time:" + util.get_release_time() + " at " + y.l(), "");
      return j;
    }
    finally {}
  }
  
  private int RequestReport(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2)
  {
    if (paramInt == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramArrayOfByte1, paramArrayOfByte2, paramLong1, paramLong2, "RequestReport").RunReq(7);
      return -1001;
    }
    y localy = this.mG.a(0L);
    localy.f = paramLong1;
    util.LOGI("user:" + paramLong1 + " appid:" + paramLong2 + " Seq:" + localy.h + " RequestReport...", "" + paramLong1);
    paramInt = new ae(localy).a(paramLong1, null, paramArrayOfByte1, paramArrayOfByte2, paramLong2, new WUserSigInfo());
    localy.i();
    util.LOGI("user:" + paramLong1 + " appid:" + paramLong2 + " Seq:" + localy.h + " RequestReport ret=" + paramInt, "" + paramLong1);
    return paramInt;
  }
  
  private int RequestReportError(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramArrayOfByte1, paramArrayOfByte2, paramLong1, paramLong2, paramInt2, "RequestReportError").RunReq(8);
      return -1001;
    }
    y localy = this.mG.a(0L);
    localy.d = this.mG.d;
    localy.f = paramLong1;
    util.LOGI("user:" + paramLong1 + " appid:" + paramLong2 + " Seq:" + localy.h + " RequestReportError...", "" + paramLong1);
    paramInt1 = new z(localy).a(paramLong1, null, paramArrayOfByte1, paramArrayOfByte2, paramLong2, paramInt2);
    util.LOGI("user:" + paramLong1 + " appid:" + paramLong2 + " Seq:" + localy.h + " RequestReportError ret=" + paramInt1, "" + paramLong1);
    return paramInt1;
  }
  
  private int ShareKeyInit()
  {
    Object localObject = new EcdhCrypt(this.mContext);
    int i = ((EcdhCrypt)localObject).GenereateKey();
    byte[] arrayOfByte = ((EcdhCrypt)localObject).get_c_pub_key();
    localObject = ((EcdhCrypt)localObject).get_g_share_key();
    if ((arrayOfByte != null) && (arrayOfByte.length > 0) && (localObject != null) && (localObject.length > 0))
    {
      this.mG.n = ((byte[])arrayOfByte.clone());
      this.mG.o = ((byte[])((byte[])localObject).clone());
      return i;
    }
    this.mG.n = util.string_to_buf("020b03cf3d99541f29ffec281bebbd4ea211292ac1f53d7128");
    this.mG.o = util.string_to_buf("4da0f614fc9f29c2054c77048a6566d7");
    return i;
  }
  
  private int VerifySMSVerifyLoginCode(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {
      return -1017;
    }
    if (paramInt == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramString1, paramString2, paramWUserSigInfo, "VerifySMSVerifyLoginCode").RunReq(13);
      return -1001;
    }
    if (paramWUserSigInfo._seqence == 0L) {
      paramWUserSigInfo._seqence = this.mAysncSeq;
    }
    y localy = this.mG.a(paramWUserSigInfo._seqence);
    paramWUserSigInfo._seqence = localy.h;
    k localk = y.b(localy.h);
    util.LOGI("user:" + localy.g + " code:" + paramString2 + " Seq:" + localy.h + " VerifySMSVerifyLoginCode ...", paramString1);
    localy.g = paramString1;
    localk.k = new ErrMsg();
    localk.C = util.get_mpasswd();
    paramInt = new ac(localy).a(paramString2, this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
    paramWUserSigInfo = new StringBuilder().append("user:").append(paramString1).append(" code:").append(paramString2).append(" Seq:").append(localy.h).append(" VerifySMSVerifyLoginAccount ret=");
    if (paramInt > 0) {}
    for (paramString2 = Integer.toHexString(paramInt);; paramString2 = Integer.valueOf(paramInt))
    {
      util.LOGI(paramString2, paramString1);
      return paramInt;
    }
  }
  
  private Handler newHelperHandler()
  {
    try
    {
      if (Looper.myLooper() == null) {
        return null;
      }
      Handler localHandler = new Handler();
      return localHandler;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  private void tlvCommRsp2ErrMsg(oicq.wlogin_sdk.devicelock.h paramh, ErrMsg paramErrMsg)
  {
    if ((paramh == null) || (paramh.get_data_len() == 0)) {
      return;
    }
    paramErrMsg.setType(paramh.e);
    paramErrMsg.setOtherinfo(new String(paramh.f));
    paramErrMsg.setTitle(new String(paramh.c));
    paramErrMsg.setMessage(new String(paramh.d));
  }
  
  public int AskDevLockSms(String paramString, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    if (paramString == null) {
      return -1017;
    }
    Object localObject = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject)._uin;
    util.LOGI("AskDevLockSms ...", paramString);
    localObject = new oicq.wlogin_sdk.devicelock.d();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_devlock_req();
    localTransReqContext.set_subcmd(((oicq.wlogin_sdk.devicelock.d)localObject).get_msgType());
    localTransReqContext._body = ((oicq.wlogin_sdk.devicelock.d)localObject).a(l, paramLong1, paramLong2);
    if ((localTransReqContext._body == null) || (localTransReqContext._body.length == 0)) {
      return -1017;
    }
    return RequestTransport(0, 1, paramString, paramLong1, ((oicq.wlogin_sdk.devicelock.d)localObject).Role, localTransReqContext, paramWUserSigInfo);
  }
  
  public void CancelRequest()
  {
    this.mG.q = 1;
  }
  
  public int CheckDevLockSms(String paramString1, long paramLong1, long paramLong2, String paramString2, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    if (paramString1 == null) {
      return -1017;
    }
    Object localObject1 = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString1, (WloginSimpleInfo)localObject1).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject1)._uin;
    Object localObject2 = FindUserSig(l, paramLong1);
    if (localObject2 == null) {
      return -1004;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      DevlockBase.rst.setSppKey(paramArrayOfByte);
    }
    util.LOGI("CheckDevLockSms ...", paramString1);
    oicq.wlogin_sdk.devicelock.f localf = new oicq.wlogin_sdk.devicelock.f();
    TransReqContext localTransReqContext = new TransReqContext();
    localObject1 = Build.VERSION.RELEASE;
    paramArrayOfByte = (byte[])localObject1;
    if (localObject1 == null) {
      paramArrayOfByte = "";
    }
    localTransReqContext.set_devlock_req();
    localTransReqContext.set_subcmd(localf.get_msgType());
    localObject1 = ((WloginSigInfo)localObject2)._TGT;
    localObject2 = y.y;
    byte[] arrayOfByte1 = y.C;
    byte[] arrayOfByte2 = "5.2.3.1".getBytes();
    byte[] arrayOfByte3 = "android".getBytes();
    paramArrayOfByte = paramArrayOfByte.getBytes();
    if (paramString2 == null) {}
    for (paramString2 = null;; paramString2 = paramString2.getBytes())
    {
      localTransReqContext._body = localf.a(l, paramLong1, paramLong2, (byte[])localObject1, (byte[])localObject2, arrayOfByte1, arrayOfByte2, arrayOfByte3, paramArrayOfByte, paramString2);
      if ((localTransReqContext._body != null) && (localTransReqContext._body.length != 0)) {
        break;
      }
      return -1017;
    }
    return RequestTransport(0, 1, paramString1, paramLong1, localf.Role, localTransReqContext, paramWUserSigInfo);
  }
  
  public int CheckDevLockStatus(String paramString, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    if (paramString == null) {
      return -1017;
    }
    Object localObject = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject)._uin;
    localObject = FindUserSig(l, paramLong1);
    if (localObject == null) {
      return -1004;
    }
    util.LOGI("CheckDevLockStatus ...", paramString);
    DevlockBase.rst = new DevlockRst();
    oicq.wlogin_sdk.devicelock.a locala = new oicq.wlogin_sdk.devicelock.a();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_devlock_req();
    localTransReqContext.set_subcmd(locala.get_msgType());
    localTransReqContext._body = locala.a(l, paramLong1, paramLong2, ((WloginSigInfo)localObject)._TGT, y.y, y.C, "5.2.3.1".getBytes(), y.I, y.H);
    if ((localTransReqContext._body == null) || (localTransReqContext._body.length == 0)) {
      return -1017;
    }
    return RequestTransport(0, 1, paramString, paramLong1, locala.Role, localTransReqContext, paramWUserSigInfo);
  }
  
  public int CheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    s.D = false;
    return CheckPictureAndGetSt(paramString, paramArrayOfByte, paramWUserSigInfo, (byte[][])null, 0);
  }
  
  public int CheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1)
  {
    s.D = false;
    return CheckPictureAndGetSt(paramString, paramArrayOfByte, paramWUserSigInfo, paramArrayOfByte1, 0);
  }
  
  public int CheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    return CheckSMSAndGetSt(paramString, paramArrayOfByte, paramWUserSigInfo, (byte[][])null, 0);
  }
  
  public int CheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1)
  {
    return CheckSMSAndGetSt(paramString, paramArrayOfByte, paramWUserSigInfo, paramArrayOfByte1, 0);
  }
  
  public int CheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, String paramString, WUserSigInfo paramWUserSigInfo)
  {
    return CheckSMSVerifyLoginAccount(paramLong1, paramLong2, paramString, paramWUserSigInfo, 0);
  }
  
  public int CheckWebsigAndGetSt(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    s.D = true;
    return CheckPictureAndGetSt(paramString1, paramString2.getBytes(), paramWUserSigInfo, (byte[][])null, 0);
  }
  
  public int CheckWebsigAndGetSt(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte)
  {
    s.D = true;
    return CheckPictureAndGetSt(paramString1, paramString2.getBytes(), paramWUserSigInfo, paramArrayOfByte, 0);
  }
  
  /* Error */
  public Boolean ClearUserLoginData(String paramString, long paramLong)
  {
    // Byte code:
    //   0: new 122	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   7: ldc 125
    //   9: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: aload_1
    //   13: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc_w 1271
    //   19: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: lload_2
    //   23: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   26: ldc_w 1511
    //   29: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: aload_1
    //   36: invokestatic 146	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_1
    //   40: ifnull +10 -> 50
    //   43: aload_1
    //   44: invokevirtual 573	java/lang/String:length	()I
    //   47: ifgt +8 -> 55
    //   50: iconst_1
    //   51: invokestatic 1514	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   54: areturn
    //   55: aload_0
    //   56: monitorenter
    //   57: aload_1
    //   58: invokestatic 163	oicq/wlogin_sdk/tools/util:check_uin_account	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   61: invokevirtual 169	java/lang/Boolean:booleanValue	()Z
    //   64: ifne +66 -> 130
    //   67: aload_0
    //   68: getfield 38	oicq/wlogin_sdk/request/WtloginHelper:mG	Loicq/wlogin_sdk/request/y;
    //   71: aload_1
    //   72: invokevirtual 172	oicq/wlogin_sdk/request/y:b	(Ljava/lang/String;)Ljava/lang/Long;
    //   75: astore 5
    //   77: aload 5
    //   79: ifnonnull +34 -> 113
    //   82: iconst_0
    //   83: istore 4
    //   85: aload 5
    //   87: astore_1
    //   88: iload 4
    //   90: iconst_1
    //   91: if_icmpne +15 -> 106
    //   94: aload_0
    //   95: getfield 38	oicq/wlogin_sdk/request/WtloginHelper:mG	Loicq/wlogin_sdk/request/y;
    //   98: aload_1
    //   99: invokevirtual 178	java/lang/Long:longValue	()J
    //   102: lload_2
    //   103: invokevirtual 1517	oicq/wlogin_sdk/request/y:b	(JJ)V
    //   106: aload_0
    //   107: monitorexit
    //   108: iconst_1
    //   109: invokestatic 1514	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   112: areturn
    //   113: aload_0
    //   114: getfield 38	oicq/wlogin_sdk/request/WtloginHelper:mG	Loicq/wlogin_sdk/request/y;
    //   117: aload_1
    //   118: invokevirtual 1168	oicq/wlogin_sdk/request/y:d	(Ljava/lang/String;)V
    //   121: iconst_1
    //   122: istore 4
    //   124: aload 5
    //   126: astore_1
    //   127: goto -39 -> 88
    //   130: aload_1
    //   131: invokestatic 259	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   134: invokestatic 263	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   137: astore_1
    //   138: iconst_1
    //   139: istore 4
    //   141: goto -53 -> 88
    //   144: astore_1
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_1
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	WtloginHelper
    //   0	149	1	paramString	String
    //   0	149	2	paramLong	long
    //   83	57	4	i	int
    //   75	50	5	localLong	Long
    // Exception table:
    //   from	to	target	type
    //   57	77	144	finally
    //   94	106	144	finally
    //   106	108	144	finally
    //   113	121	144	finally
    //   130	138	144	finally
    //   145	147	144	finally
  }
  
  public int CloseCode(String paramString, long paramLong, byte[] paramArrayOfByte, int paramInt, List<byte[]> paramList, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject)._uin;
    localObject = FindUserSig(l, paramLong);
    if (localObject == null) {
      return -1004;
    }
    util.LOGI("user:" + paramString + " CloseCode ...", paramString);
    oicq.wlogin_sdk.code2d.a locala = new oicq.wlogin_sdk.code2d.a();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(locala.get_cmd());
    localTransReqContext._body = locala.a(l, paramLong, 1L, paramArrayOfByte, ((WloginSigInfo)localObject)._TGT, y.y, paramInt, paramList, ((WloginSigInfo)localObject)._en_A1, ((WloginSigInfo)localObject)._noPicSig, this.mMiscBitmap, 0L);
    return RequestTransport(0, 1, paramString, paramLong, locala._role, localTransReqContext, paramWUserSigInfo);
  }
  
  public int CloseDevLock(String paramString, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    if (paramString == null) {
      return -1017;
    }
    Object localObject = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject)._uin;
    WloginSigInfo localWloginSigInfo = FindUserSig(l, paramLong1);
    if (localWloginSigInfo == null) {
      return -1004;
    }
    util.LOGI("CloseDevLock ...", paramString);
    oicq.wlogin_sdk.devicelock.b localb = new oicq.wlogin_sdk.devicelock.b();
    TransReqContext localTransReqContext = new TransReqContext();
    String str = Build.VERSION.RELEASE;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localTransReqContext.set_devlock_req();
    localTransReqContext.set_subcmd(localb.get_msgType());
    localTransReqContext._body = localb.a(l, paramLong1, paramLong2, localWloginSigInfo._TGT, y.y, y.C, "5.2.3.1".getBytes(), "android".getBytes(), ((String)localObject).getBytes());
    if ((localTransReqContext._body == null) || (localTransReqContext._body.length == 0)) {
      return -1017;
    }
    return RequestTransport(0, 1, paramString, paramLong1, localb.Role, localTransReqContext, paramWUserSigInfo);
  }
  
  public int FetchCodeSig(long paramLong1, long paramLong2, fetch_code.QRCodeCustom paramQRCodeCustom, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI(" FetchCodeSig ...", "");
    fetch_code localfetch_code = new fetch_code();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(localfetch_code.get_cmd());
    long l = this.mMiscBitmap;
    localTransReqContext._body = localfetch_code.get_request(0L, paramLong1, paramLong2, new byte[0], paramQRCodeCustom, l, 0L);
    return RequestTransport(0, 1, null, paramLong1, localfetch_code._role, localTransReqContext, paramWUserSigInfo);
  }
  
  public int GetA1WithA1(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo)
  {
    return GetA1WithA1(paramString, paramLong1, paramLong2, this.mMainSigMap, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramArrayOfByte2, paramArrayOfByte3, paramWUserSigInfo, paramWFastLoginInfo, 0);
  }
  
  public byte[] GetA2A2KeyBuf(String paramString, long paramLong)
  {
    Ticket localTicket = GetLocalTicket(paramString, paramLong, 64);
    if ((localTicket == null) || (localTicket._sig == null) || (localTicket._sig.length <= 0) || (localTicket._sig_key == null) || (localTicket._sig_key.length <= 0)) {}
    while ((y.z == null) || (y.z.length <= 0)) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramString.getBytes().length + 2 + 8 + 2 + localTicket._sig.length + 2 + localTicket._sig_key.length];
    util.int16_to_buf(arrayOfByte, 0, paramString.getBytes().length);
    System.arraycopy(paramString.getBytes(), 0, arrayOfByte, 2, paramString.getBytes().length);
    int i = paramString.getBytes().length + 2;
    util.int64_to_buf(arrayOfByte, i, paramLong);
    i += 8;
    util.int16_to_buf(arrayOfByte, i, localTicket._sig.length);
    i += 2;
    System.arraycopy(localTicket._sig, 0, arrayOfByte, i, localTicket._sig.length);
    i += localTicket._sig.length;
    util.int16_to_buf(arrayOfByte, i, localTicket._sig_key.length);
    i += 2;
    System.arraycopy(localTicket._sig_key, 0, arrayOfByte, i, localTicket._sig_key.length);
    i = localTicket._sig_key.length;
    return cryptor.encrypt(arrayOfByte, 0, arrayOfByte.length, y.z);
  }
  
  public List<WloginLoginInfo> GetAllLoginInfo()
  {
    return this.mG.k();
  }
  
  public long GetAppidFromUrl(String paramString)
  {
    if (paramString == null) {
      return -1L;
    }
    int i = paramString.indexOf("f=");
    if ((i == -1) || (i + 2 >= paramString.length())) {
      return -1L;
    }
    i += 2;
    String str = "";
    for (;;)
    {
      if ((i >= paramString.length()) || (paramString.charAt(i) == '&')) {}
      try
      {
        long l = Long.parseLong(str);
        return l;
      }
      catch (Exception paramString) {}
      str = str + paramString.charAt(i);
      i += 1;
    }
    return -1L;
  }
  
  public Boolean GetBasicUserInfo(String paramString, WloginSimpleInfo paramWloginSimpleInfo)
  {
    if (paramString == null) {
      return Boolean.valueOf(false);
    }
    int i;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      paramString = this.mG.b(paramString);
      if (paramString != null) {
        break label176;
      }
      i = 0;
    }
    for (;;)
    {
      if (i == 1)
      {
        paramString = this.mG.d(paramString.longValue());
        if (paramString == null)
        {
          i = 0;
          label57:
          if (i != 1) {
            break label170;
          }
        }
      }
      label170:
      for (boolean bool = true;; bool = false)
      {
        return Boolean.valueOf(bool);
        paramString = Long.valueOf(Long.parseLong(paramString));
        i = 1;
        break;
        util.LOGD(getClass().getName() + "found:" + paramString._uin);
        if (paramWloginSimpleInfo != null) {
          paramWloginSimpleInfo.get_clone(new WloginSimpleInfo(paramString._uin, paramString._face, paramString._age, paramString._gender, paramString._nick, paramString._img_type, paramString._img_format, paramString._img_url));
        }
        break label57;
      }
      label176:
      i = 1;
    }
  }
  
  public DevlockInfo GetDevLockInfo(String paramString)
  {
    return GetDevLockInfo(paramString, 0L);
  }
  
  public DevlockInfo GetDevLockInfo(String paramString, long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = this.mAysncSeq;
    }
    return y.b(l).x;
  }
  
  public byte[] GetGuid()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (y.y != null)
    {
      localObject1 = localObject2;
      if (y.y.length > 0)
      {
        localObject1 = new byte[y.y.length];
        System.arraycopy(y.y, 0, localObject1, 0, y.y.length);
      }
    }
    return localObject1;
  }
  
  public WloginLastLoginInfo GetLastLoginInfo()
  {
    Object localObject = this.mG.k();
    if (localObject == null) {}
    label124:
    label125:
    for (;;)
    {
      return null;
      Iterator localIterator = ((List)localObject).iterator();
      localObject = null;
      while (localIterator.hasNext())
      {
        WloginLoginInfo localWloginLoginInfo = (WloginLoginInfo)localIterator.next();
        if (localObject == null)
        {
          localObject = localWloginLoginInfo;
        }
        else
        {
          if (localWloginLoginInfo.mCreateTime <= ((WloginLoginInfo)localObject).mCreateTime) {
            break label124;
          }
          localObject = localWloginLoginInfo;
        }
      }
      for (;;)
      {
        break;
        if (localObject == null) {
          break label125;
        }
        if ((((WloginLoginInfo)localObject).mAccount != null) && (((WloginLoginInfo)localObject).mAccount.length() > 0)) {
          return new WloginLastLoginInfo(((WloginLoginInfo)localObject).mAccount, ((WloginLoginInfo)localObject).mUin);
        }
        return new WloginLastLoginInfo(String.valueOf(((WloginLoginInfo)localObject).mUin), ((WloginLoginInfo)localObject).mUin);
      }
    }
  }
  
  public WUserSigInfo GetLocalSig(String paramString, long paramLong)
  {
    if (paramString == null)
    {
      util.LOGI("userAccount null", "");
      return null;
    }
    Object localObject2;
    Object localObject1;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      localObject2 = this.mG.b(paramString);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label56;
      }
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      localObject1 = Long.valueOf(Long.parseLong(paramString));
      label56:
      localObject2 = this.mG.a(((Long)localObject1).longValue(), paramLong);
      if (localObject2 != null)
      {
        localObject1 = new WUserSigInfo();
        ((WUserSigInfo)localObject1).uin = paramString;
        ((WUserSigInfo)localObject1).get_clone((WloginSigInfo)localObject2);
        paramString = (String)localObject1;
      }
      else
      {
        paramString = null;
      }
    }
  }
  
  public Ticket GetLocalTicket(String paramString, long paramLong, int paramInt)
  {
    util.LOGI("GetLocalTicket", paramString);
    if (paramString == null)
    {
      util.LOGI("userAccount null", "");
      return null;
    }
    return GetUserSigInfoTicket(GetLocalSig(paramString, paramLong), paramInt);
  }
  
  public int GetOpenKeyWithPasswd(String paramString1, long paramLong, int paramInt, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithPasswd(paramString1, this.mOpenAppid, paramInt, paramLong, null, false, paramString2, paramWUserSigInfo, (byte[][])null, false, 0);
  }
  
  public int GetOpenKeyWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithoutPasswd(paramString, paramLong1, this.mOpenAppid, -1L, paramInt, paramLong2, null, paramWUserSigInfo, (byte[][])null, (byte[][])null, 0);
  }
  
  public byte[] GetPictureData(String paramString)
  {
    return GetPictureData(paramString, 0L);
  }
  
  public byte[] GetPictureData(String paramString, long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = this.mAysncSeq;
    }
    return y.b(l).n.f();
  }
  
  public byte[] GetPicturePrompt(String paramString)
  {
    return GetPicturePrompt(paramString, 0L);
  }
  
  public byte[] GetPicturePrompt(String paramString, long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = this.mAysncSeq;
    }
    return y.b(l).o.b();
  }
  
  public int GetStViaSMSVerifyLogin(String paramString, long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("user:" + paramString + " GetStViaSMSVerifyLogin ...", paramString);
    if (oicq.wlogin_sdk.a.h.v) {}
    for (String str = oicq.wlogin_sdk.a.h.x;; str = "") {
      return GetStWithPasswd(paramString, paramLong1, paramInt, paramLong2, null, false, str, paramWUserSigInfo, (byte[][])null, true, 0);
    }
  }
  
  public int GetStViaSMSVerifyLogin(String paramString, long paramLong1, long paramLong2, long[] paramArrayOfLong, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    byte[][] arrayOfByte = (byte[][])null;
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      int i = paramArrayOfLong.length;
      arrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { i, 0 });
    }
    for (;;)
    {
      util.LOGI("user:" + paramString + " GetStViaSMSVerifyLogin ...", paramString);
      if (oicq.wlogin_sdk.a.h.v) {}
      for (String str = oicq.wlogin_sdk.a.h.x;; str = "") {
        return GetStWithPasswd(paramString, paramLong1, paramInt, paramLong2, paramArrayOfLong, false, str, paramWUserSigInfo, arrayOfByte, true, 0);
      }
    }
  }
  
  public int GetStWithPasswd(String paramString1, long paramLong1, int paramInt, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean, String paramString2, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte)
  {
    return GetStWithPasswd(paramString1, paramLong1, paramInt, paramLong2, paramArrayOfLong, paramBoolean, paramString2, paramWUserSigInfo, paramArrayOfByte, false, 0);
  }
  
  public int GetStWithPasswd(String paramString1, long paramLong1, long paramLong2, int paramInt, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithPasswd(paramString1, paramLong1, paramInt, paramLong2, null, false, paramString2, paramWUserSigInfo, (byte[][])null, false, 0);
  }
  
  public int GetStWithPasswd(String paramString1, long paramLong, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithPasswd(paramString1, paramLong, this.mMainSigMap, 1L, null, false, paramString2, paramWUserSigInfo, (byte[][])null, false, 0);
  }
  
  public int GetStWithPasswdMd5(String paramString1, long paramLong1, long paramLong2, int paramInt, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithPasswd(paramString1, paramLong1, paramInt, paramLong2, null, true, paramString2, paramWUserSigInfo, (byte[][])null, false, 0);
  }
  
  public int GetStWithPasswdMd5(String paramString1, long paramLong, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithPasswd(paramString1, paramLong, this.mMainSigMap, 1L, null, true, paramString2, paramWUserSigInfo, (byte[][])null, false, 0);
  }
  
  public int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2)
  {
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, paramLong3, paramInt, paramLong4, paramArrayOfLong, paramWUserSigInfo, paramArrayOfByte1, paramArrayOfByte2, 0);
  }
  
  public int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, -1L, paramInt, paramLong3, null, paramWUserSigInfo, (byte[][])null, (byte[][])null, 0);
  }
  
  public int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo)
  {
    byte[][] arrayOfByte = new byte[4][];
    arrayOfByte[0] = new byte[1];
    arrayOfByte[0][0] = 1;
    arrayOfByte[1] = paramArrayOfByte1;
    arrayOfByte[2] = paramArrayOfByte2;
    arrayOfByte[3] = paramArrayOfByte3;
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, -1L, paramInt, paramLong3, null, paramWUserSigInfo, (byte[][])null, arrayOfByte, 0);
  }
  
  public int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, -1L, this.mMainSigMap, 1L, null, paramWUserSigInfo, (byte[][])null, (byte[][])null, 0);
  }
  
  public int GetStWithoutPasswd(byte[] paramArrayOfByte, long paramLong, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return -1017;
    }
    Object localObject = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, y.z);
    if ((localObject == null) || (localObject.length <= 0)) {
      return -1017;
    }
    if (2 > localObject.length) {
      return -1017;
    }
    int i = util.buf_to_int16((byte[])localObject, 0);
    if ((i <= 0) || (i + 2 > localObject.length)) {
      return -1017;
    }
    paramArrayOfByte = new String((byte[])localObject, 2, i);
    i += 2;
    if (i + 8 > localObject.length) {
      return -1017;
    }
    long l = util.buf_to_int64((byte[])localObject, i);
    int j = i + 8;
    if (j + 2 > localObject.length) {
      return -1017;
    }
    i = util.buf_to_int16((byte[])localObject, j);
    j += 2;
    if ((i <= 0) || (j + i > localObject.length)) {
      return -1017;
    }
    byte[] arrayOfByte1 = new byte[i];
    System.arraycopy(localObject, j, arrayOfByte1, 0, arrayOfByte1.length);
    j += i;
    if (j + 2 > localObject.length) {
      return -1017;
    }
    i = util.buf_to_int16((byte[])localObject, j);
    j += 2;
    if ((i <= 0) || (j + i > localObject.length)) {
      return -1017;
    }
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(localObject, j, arrayOfByte2, 0, arrayOfByte2.length);
    localObject = new byte[3][];
    localObject[0] = new byte[1];
    localObject[0][0] = 2;
    localObject[1] = arrayOfByte1;
    localObject[2] = arrayOfByte2;
    return GetStWithoutPasswd(paramArrayOfByte, l, paramLong, -1L, paramInt, 1L, null, paramWUserSigInfo, (byte[][])null, (byte[][])localObject, 0);
  }
  
  public long GetTimeDifference()
  {
    return y.X;
  }
  
  public Boolean IsNeedLoginWithPasswd(String paramString, long paramLong)
  {
    boolean bool = false;
    int i = 1;
    if (paramString == null) {
      return Boolean.valueOf(true);
    }
    for (;;)
    {
      try
      {
        if (!util.check_uin_account(paramString).booleanValue())
        {
          Long localLong = this.mG.b(paramString);
          localObject = localLong;
          if (localLong == null)
          {
            bool = true;
            util.LOGI("user:" + paramString + " appid:" + paramLong + " need password:" + bool + " flag=" + i, paramString);
            return Boolean.valueOf(bool);
          }
        }
        else
        {
          localObject = Long.valueOf(Long.parseLong(paramString));
        }
        Object localObject = this.mG.a(((Long)localObject).longValue(), paramLong);
        if ((localObject != null) && (((WloginSigInfo)localObject)._en_A1 != null) && (((WloginSigInfo)localObject)._en_A1.length != 0) && (((WloginSigInfo)localObject)._noPicSig != null) && (((WloginSigInfo)localObject)._noPicSig.length != 0))
        {
          i = 2;
          continue;
        }
        if ((localObject == null) || (((WloginSigInfo)localObject)._TGT == null) || (((WloginSigInfo)localObject)._TGT.length == 0) || (((WloginSigInfo)localObject).iSExpireA2(y.f()))) {
          break label228;
        }
        i = 0;
      }
      finally {}
      continue;
      label228:
      bool = true;
      i = 3;
    }
  }
  
  public Boolean IsUserHaveA1(String paramString, long paramLong)
  {
    if (paramString == null) {
      return Boolean.valueOf(false);
    }
    Object localObject2;
    Object localObject1;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      localObject2 = this.mG.b(paramString);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label117;
      }
      localObject1 = null;
    }
    while ((localObject1 == null) || (((WloginSigInfo)localObject1)._en_A1 == null) || (((WloginSigInfo)localObject1)._en_A1.length <= 0))
    {
      util.LOGI("userAccount:" + paramString + " dwAppid:" + paramLong + " IsUserHaveA1 return: null", paramString);
      return Boolean.valueOf(false);
      localObject1 = Long.valueOf(Long.parseLong(paramString));
      label117:
      localObject2 = this.mG.a(((Long)localObject1).longValue(), paramLong);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localObject2;
      }
    }
    util.LOGI("userAccount:" + paramString + " dwAppid:" + paramLong + " IsUserHaveA1 return: not null", paramString);
    return Boolean.valueOf(true);
  }
  
  public boolean IsWtLoginUrl(String paramString)
  {
    if (paramString == null) {}
    do
    {
      int i;
      do
      {
        return false;
        i = paramString.indexOf("?k=");
      } while ((i == -1) || (i + 3 + 32 > paramString.length()));
      i += 3;
      paramString = paramString.substring(i, i + 32);
    } while (util.base64_decode_url(paramString.getBytes(), paramString.length()) == null);
    return true;
  }
  
  public Intent PrepareQloginIntent(long paramLong1, long paramLong2, String paramString)
  {
    if (!util.CheckMayFastLogin(this.mContext)) {
      return null;
    }
    Object localObject2 = util.get_rsa_pubkey(this.mContext);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length != 0) {}
    }
    else
    {
      localObject1 = util.string_to_buf("30818902818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d0203010001");
    }
    localObject2 = new Intent();
    ((Intent)localObject2).setClassName("com.tencent.mobileqq", "com.tencent.open.agent.AgentActivity");
    Bundle localBundle = new Bundle();
    localBundle.putLong("dstSsoVer", 1L);
    localBundle.putLong("dstAppid", paramLong1);
    localBundle.putLong("subDstAppid", paramLong2);
    localBundle.putByteArray("dstAppVer", paramString.getBytes());
    localBundle.putByteArray("publickey", (byte[])localObject1);
    ((Intent)localObject2).putExtra("key_params", localBundle);
    ((Intent)localObject2).putExtra("key_action", "action_quick_login");
    return localObject2;
  }
  
  public Intent PrepareQloginResult(String paramString, long paramLong1, long paramLong2, int paramInt, WFastLoginInfo paramWFastLoginInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("quicklogin_uin", paramString);
    paramString = (byte[])paramWFastLoginInfo._outA1.clone();
    if ((paramString != null) && (paramString.length > 0))
    {
      paramString = new RSACrypt(this.mContext).EncryptData(util.get_cp_pubkey(this.mContext, paramLong1, paramLong2), paramString);
      util.LOGD("encrypt buff:" + util.buf_to_string(paramString));
      localIntent.putExtra("quicklogin_buff", paramString);
    }
    localIntent.putExtra("quicklogin_ret", paramInt);
    return localIntent;
  }
  
  public int QueryCodeResult(long paramLong, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI(" QueryCodeResult ...", "");
    oicq.wlogin_sdk.code2d.d locald = new oicq.wlogin_sdk.code2d.d();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(locald.get_cmd());
    localTransReqContext._body = locald.a(0L, paramLong, oicq.wlogin_sdk.code2d.c.i, new byte[0]);
    return RequestTransport(0, 1, null, paramLong, locald._role, localTransReqContext, paramWUserSigInfo);
  }
  
  public void RefreshMemorySig()
  {
    this.mG.j();
  }
  
  public int RefreshPictureData(String paramString, WUserSigInfo paramWUserSigInfo)
  {
    WUserSigInfo localWUserSigInfo = paramWUserSigInfo;
    if (paramWUserSigInfo == null) {
      localWUserSigInfo = new WUserSigInfo();
    }
    return RefreshPictureData(paramString, localWUserSigInfo, 0);
  }
  
  public int RefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo)
  {
    if (paramWUserSigInfo == null) {
      paramWUserSigInfo = new WUserSigInfo();
    }
    for (;;)
    {
      return RefreshSMSData(paramString, paramLong, paramWUserSigInfo, 0);
    }
  }
  
  public int RefreshSMSVerifyLoginCode(String paramString, WUserSigInfo paramWUserSigInfo)
  {
    return RefreshSMSVerifyLoginCode(paramString, paramWUserSigInfo, 0);
  }
  
  public int RegGetAccount(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    if ((paramArrayOfByte3 == null) || (paramArrayOfByte3.length <= 0)) {
      return -1017;
    }
    util.LOGI("RegGetAccount ...", "");
    oicq.wlogin_sdk.a.b localb = new oicq.wlogin_sdk.a.b();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.h localh = this.mRegStatus;
    if (paramArrayOfByte1 != null) {}
    for (localh.j = ((byte[])paramArrayOfByte1.clone());; localh.j = new byte[0])
    {
      if (paramInt == 4) {
        localh.b = "";
      }
      localTransReqContext.set_register_req();
      localTransReqContext.set_subcmd(localb.a());
      localTransReqContext._body = localb.a(localh.e, paramArrayOfByte1, paramArrayOfByte3, paramArrayOfByte4, paramInt, localh.b.getBytes(), paramArrayOfByte2, false, null, 0L, y.C, y.x);
      return RequestTransport(0, 1, null, 0L, localh.i, localTransReqContext, paramWUserSigInfo);
    }
  }
  
  public int RegGetSMSVerifyLoginAccount(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("RegGetSMSVerifyLoginAccount ...", "");
    oicq.wlogin_sdk.a.b localb = new oicq.wlogin_sdk.a.b();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.h localh = this.mRegStatus;
    if (paramArrayOfByte1 != null) {}
    for (localh.j = ((byte[])paramArrayOfByte1.clone());; localh.j = new byte[0])
    {
      oicq.wlogin_sdk.a.h.v = true;
      oicq.wlogin_sdk.a.h.x = util.get_mpasswd();
      localTransReqContext.set_register_req();
      localTransReqContext.set_subcmd(localb.a());
      localTransReqContext._body = localb.a(localh.e, paramArrayOfByte1, oicq.wlogin_sdk.a.h.x.getBytes(), paramArrayOfByte3, 1, localh.b.getBytes(), paramArrayOfByte2, true, GetGuid(), localh.h, y.C, y.x);
      return RequestTransport(0, 1, null, 0L, localh.i, localTransReqContext, paramWUserSigInfo);
    }
  }
  
  public int RegQueryAccount(int paramInt, byte[] paramArrayOfByte, long paramLong, WUserSigInfo paramWUserSigInfo)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    util.LOGI("RegQueryAccount ...", "");
    this.mRegStatus = new oicq.wlogin_sdk.a.h();
    this.mRegStatus.b = new String(arrayOfByte);
    paramArrayOfByte = new oicq.wlogin_sdk.a.c();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.h localh = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(paramArrayOfByte.a());
    localTransReqContext._body = paramArrayOfByte.a(paramInt, arrayOfByte, paramLong);
    return RequestTransport(0, 1, null, 0L, localh.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RegQueryClientSendedMsgStatus(WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("RegQueryClientSendedMsgStatus ...", "");
    oicq.wlogin_sdk.a.d locald = new oicq.wlogin_sdk.a.d();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.h localh = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(locald.a());
    localTransReqContext._body = locald.b(localh.e, this.mRegStatus.o);
    return RequestTransport(0, 1, null, 0L, localh.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RegRequestServerResendMsg(WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("RegRequestServerResendMsg ...", "");
    oicq.wlogin_sdk.a.e locale = new oicq.wlogin_sdk.a.e();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.h localh = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(locale.a());
    localTransReqContext._body = locale.b(localh.e, null);
    return RequestTransport(0, 1, null, 0L, localh.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RegSubmitMobile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length <= 0) || (paramArrayOfByte3 == null)) {
      return -1017;
    }
    byte[] arrayOfByte = y.C;
    long l1 = 0L;
    Object localObject1 = new byte[0];
    Object localObject2 = GetLastLoginInfo();
    paramArrayOfByte2 = (byte[])localObject1;
    if (localObject2 != null)
    {
      long l2 = ((WloginLastLoginInfo)localObject2).mUin;
      localObject2 = GetLocalTicket(((WloginLastLoginInfo)localObject2).mAccount, paramLong1, 64);
      l1 = l2;
      paramArrayOfByte2 = (byte[])localObject1;
      if (localObject2 != null)
      {
        l1 = l2;
        paramArrayOfByte2 = (byte[])localObject1;
        if (((Ticket)localObject2)._sig != null)
        {
          paramArrayOfByte2 = ((Ticket)localObject2)._sig;
          l1 = l2;
        }
      }
    }
    util.LOGI("has uin? " + l1 + ", a2: " + paramArrayOfByte2.length);
    util.LOGI("RegSubmitMobile mobile ..." + new String(paramArrayOfByte1) + " appname: " + new String(arrayOfByte) + "...", "");
    this.mRegStatus.c = new String(paramArrayOfByte1);
    localObject1 = new oicq.wlogin_sdk.a.f();
    localObject2 = new TransReqContext();
    oicq.wlogin_sdk.a.h localh = this.mRegStatus;
    localh.k = paramArrayOfByte1;
    localh.g = paramLong1;
    localh.h = paramLong2;
    ((TransReqContext)localObject2).set_register_req();
    ((TransReqContext)localObject2).set_subcmd(((oicq.wlogin_sdk.a.f)localObject1).a());
    ((TransReqContext)localObject2)._body = ((oicq.wlogin_sdk.a.f)localObject1).a(paramArrayOfByte1, arrayOfByte, paramArrayOfByte3, paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, null, util.get_IMEI(this.mContext), util.get_IMSI(this.mContext), y.W, l1, paramArrayOfByte2, GetGuid());
    return RequestTransport(0, 1, null, 0L, localh.i, (TransReqContext)localObject2, paramWUserSigInfo);
  }
  
  public int RegSubmitMsgChk(byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    if (paramArrayOfByte == null) {
      return -1017;
    }
    util.LOGI("RegSubmitMsgChk ...", "");
    oicq.wlogin_sdk.a.g localg = new oicq.wlogin_sdk.a.g();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.h localh = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(localg.a());
    localTransReqContext._body = localg.b(localh.e, paramArrayOfByte);
    return RequestTransport(0, 1, null, 0L, localh.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RequestTransport(int paramInt1, int paramInt2, String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo)
  {
    if (paramInt1 == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramInt2, paramString, paramLong1, paramLong2, paramTransReqContext, paramWUserSigInfo, "RequestTransport").RunReq(9);
      return -1001;
    }
    y localy = this.mG.a(0L);
    util.LOGI("user:" + paramString + " encrypt:" + paramInt2 + " appid:" + paramLong1 + " role:" + paramLong2 + " Seq:" + localy.h + " RequestTransport...", paramString);
    localy.g = paramString;
    if (paramInt2 != 0) {
      if (paramString == null)
      {
        localy.m = 0;
        paramInt1 = new ae(localy).a(0L, paramTransReqContext, null, null, paramLong1, paramLong2, paramWUserSigInfo);
      }
    }
    for (;;)
    {
      localy.i();
      util.LOGI("user:" + paramString + " encrypt:" + paramInt2 + " appid:" + paramLong1 + " role:" + paramLong2 + " Seq:" + localy.h + " RequestTransport ret=" + paramInt1, paramString);
      return paramInt1;
      WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
      if ((paramString == null) || (!GetBasicUserInfo(paramString, localWloginSimpleInfo).booleanValue()))
      {
        paramInt1 = -1003;
      }
      else
      {
        WloginSigInfo localWloginSigInfo = localy.a(localWloginSimpleInfo._uin, paramLong1);
        if (localWloginSigInfo == null)
        {
          paramInt1 = -1004;
        }
        else
        {
          localy.f = localWloginSimpleInfo._uin;
          paramInt1 = new ae(localy).a(localWloginSimpleInfo._uin, paramTransReqContext, localWloginSigInfo._userStSig, localWloginSigInfo._userSt_Key, paramLong1, paramLong2, paramWUserSigInfo);
          continue;
          localy.f = 0L;
          paramInt1 = new ae(localy).a(localy.f, paramTransReqContext, null, null, paramLong1, paramLong2, paramWUserSigInfo);
        }
      }
    }
  }
  
  public int RequestTransportMsf(int paramInt1, int paramInt2, String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext)
  {
    if (paramInt1 == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramInt2, paramString, paramLong1, paramLong2, paramTransReqContext, "RequestTransportMsf").RunReq(10);
      return -1001;
    }
    y localy = this.mG.a(0L);
    util.LOGI("user:" + paramString + " encrypt:" + paramInt2 + " appid:" + paramLong1 + " role:" + paramLong2 + " Seq:" + localy.h + " RequestTransportMsf...", paramString);
    localy.g = paramString;
    Object localObject1;
    if (paramInt2 != 0)
    {
      localObject1 = new WloginSimpleInfo();
      if ((paramString == null) || (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1).booleanValue())) {
        paramInt1 = -1003;
      }
    }
    for (;;)
    {
      localy.i();
      util.LOGI("user:" + paramString + " encrypt:" + paramInt2 + " appid:" + paramLong1 + " role:" + paramLong2 + " Seq:" + localy.h + " RequestTransportMsf ret=" + paramInt1, paramString);
      return paramInt1;
      Object localObject2 = localy.a(((WloginSimpleInfo)localObject1)._uin, paramLong1);
      if (localObject2 == null)
      {
        paramInt1 = -1004;
      }
      else
      {
        localy.f = ((WloginSimpleInfo)localObject1)._uin;
        paramInt1 = new ae(localy).a(((WloginSimpleInfo)localObject1)._uin, paramTransReqContext, ((WloginSigInfo)localObject2)._userStSig, ((WloginSigInfo)localObject2)._userSt_Key, ((WloginSigInfo)localObject2)._TGT, paramLong1, paramLong2, new WUserSigInfo());
        continue;
        if ((util.check_uin_account(paramString).booleanValue()) && (Long.parseLong(paramString) == 0L))
        {
          localy.f = 0L;
          localObject1 = new ae(localy);
          localObject2 = new WUserSigInfo();
          paramInt1 = ((ae)localObject1).a(0L, paramTransReqContext, null, null, new byte[0], paramLong1, paramLong2, (WUserSigInfo)localObject2);
        }
        else
        {
          localObject1 = new WloginSimpleInfo();
          if ((paramString == null) || (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1).booleanValue()))
          {
            paramInt1 = -1003;
          }
          else
          {
            localObject2 = localy.a(((WloginSimpleInfo)localObject1)._uin, paramLong1);
            if (localObject2 == null)
            {
              paramInt1 = -1004;
            }
            else
            {
              localy.f = ((WloginSimpleInfo)localObject1)._uin;
              paramInt1 = new ae(localy).a(((WloginSimpleInfo)localObject1)._uin, paramTransReqContext, null, null, ((WloginSigInfo)localObject2)._TGT, paramLong1, paramLong2, new WUserSigInfo());
            }
          }
        }
      }
    }
  }
  
  public WUserSigInfo ResolveQloginIntent(Intent paramIntent)
  {
    if (paramIntent == null) {}
    String str;
    do
    {
      do
      {
        return null;
      } while (paramIntent.getExtras().getInt("quicklogin_ret") != 0);
      str = paramIntent.getExtras().getString("quicklogin_uin");
      paramIntent = paramIntent.getExtras().getByteArray("quicklogin_buff");
    } while ((str == null) || (paramIntent == null));
    util.LOGI("len:" + paramIntent.length + " quicklogin_buff:" + util.buf_to_string(paramIntent));
    WUserSigInfo localWUserSigInfo = new WUserSigInfo();
    localWUserSigInfo._fastLoginBuf = new RSACrypt(this.mContext).DecryptData(null, paramIntent);
    localWUserSigInfo.uin = str;
    return localWUserSigInfo;
  }
  
  public void SetAppClientVersion(int paramInt)
  {
    y.u = paramInt;
  }
  
  public void SetCanWebVerify(boolean paramBoolean)
  {
    p.D = paramBoolean;
  }
  
  public void SetImgType(int paramInt)
  {
    y.v = paramInt;
    this.mMiscBitmap |= 0x80;
  }
  
  public void SetListener(WtloginListener paramWtloginListener)
  {
    this.mListener = paramWtloginListener;
  }
  
  public void SetLocalId(int paramInt)
  {
    y.s = paramInt;
  }
  
  public void SetMsfTransportFlag(int paramInt)
  {
    this.mG.k = paramInt;
    if (paramInt != 0)
    {
      y.Z = new byte[4];
      y.Y = 0L;
      this.mG.l = 45000;
    }
  }
  
  public void SetPicType(int paramInt)
  {
    y.w = paramInt;
  }
  
  public void SetRegDevLockFlag(int paramInt)
  {
    y.x = paramInt;
  }
  
  public void SetSigMap(int paramInt)
  {
    this.mMainSigMap = (paramInt | 0xC0);
  }
  
  public void SetTestHost(int paramInt, String paramString)
  {
    o.a(paramInt, paramString);
  }
  
  public void SetTimeOut(int paramInt)
  {
    this.mG.l = paramInt;
  }
  
  public int VerifyCode(String paramString, long paramLong, boolean paramBoolean, byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject1 = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject1)._uin;
    WloginSigInfo localWloginSigInfo = FindUserSig(l, paramLong);
    if (localWloginSigInfo == null) {
      return -1004;
    }
    Object localObject3 = new ch();
    Object localObject2 = new byte[0];
    localObject1 = localObject2;
    if (localWloginSigInfo._G != null)
    {
      localObject1 = localObject2;
      if (localWloginSigInfo._G.length > 0)
      {
        localObject1 = localObject2;
        if (localWloginSigInfo._dpwd != null)
        {
          localObject1 = localObject2;
          if (localWloginSigInfo._dpwd.length > 0)
          {
            localObject1 = localObject2;
            if (localWloginSigInfo._randseed != null)
            {
              localObject1 = localObject2;
              if (localWloginSigInfo._randseed.length > 0)
              {
                ((ch)localObject3).a(localWloginSigInfo._G, l, y.y, localWloginSigInfo._dpwd, paramLong, 1L, localWloginSigInfo._randseed);
                localObject1 = ((ch)localObject3).b();
              }
            }
          }
        }
      }
    }
    util.LOGI("user:" + paramString + " VerifyCode ...", paramString);
    localObject2 = new oicq.wlogin_sdk.code2d.e();
    localObject3 = new TransReqContext();
    ((TransReqContext)localObject3).set_code2d_func_req();
    ((TransReqContext)localObject3).set_subcmd(((oicq.wlogin_sdk.code2d.e)localObject2).get_cmd());
    ((TransReqContext)localObject3)._body = ((oicq.wlogin_sdk.code2d.e)localObject2).a(l, paramLong, paramBoolean, paramArrayOfByte, paramArrayOfInt, localWloginSigInfo._TGT, y.y, y.C, paramInt, (byte[])localObject1);
    return RequestTransport(0, 1, paramString, paramLong, ((oicq.wlogin_sdk.code2d.e)localObject2)._role, (TransReqContext)localObject3, paramWUserSigInfo);
  }
  
  public int VerifySMSVerifyLoginCode(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return VerifySMSVerifyLoginCode(paramString1, paramString2, paramWUserSigInfo, 0);
  }
  
  public boolean getHasPassword(long paramLong)
  {
    String str = this.mG.e(paramLong);
    util.LOGI("getHasPasswd ..." + String.valueOf(str), "" + paramLong);
    if (str == null) {}
    UinInfo localUinInfo;
    do
    {
      return true;
      localUinInfo = this.mG.c(str);
    } while (localUinInfo == null);
    boolean bool = localUinInfo.getHasPassword();
    util.LOGI("getHasPasswd userAccount: " + str + ", uin: " + paramLong + " hasPasswd: " + bool, "");
    return bool;
  }
  
  public void setHasPassword(long paramLong, boolean paramBoolean)
  {
    String str = this.mG.e(paramLong);
    util.LOGI("setHasPasswd ..." + String.valueOf(str), "");
    if (str == null) {
      return;
    }
    this.mG.a(str, Long.valueOf(paramLong), paramBoolean);
    util.LOGI("setHasPasswd userAccount: " + str + ", uin: " + paramLong + " hasPassword:" + paramBoolean, "");
  }
  
  public void setMsgType(int paramInt1, int paramInt2, int paramInt3)
  {
    oicq.wlogin_sdk.devicelock.DevlockBase.a.a = paramInt1;
    oicq.wlogin_sdk.devicelock.DevlockBase.a.b = paramInt2;
    oicq.wlogin_sdk.devicelock.DevlockBase.a.c = paramInt3;
  }
  
  public class HelperThread
    extends Thread
  {
    boolean isSelfLooper = false;
    byte[] mAppName2;
    byte[] mAppSign2;
    byte[] mAppVer2;
    long mAppid1;
    long mAppid2;
    long mDwAppid;
    long mDwDstAppPri;
    long mDwDstAppid;
    long[] mDwDstSubAppidList;
    int mDwMainSigMap;
    long[] mDwSubAppidList;
    long mDwSubDstAppid;
    int mEncrypt;
    WFastLoginInfo mFastLoginInfo;
    Handler mHandler;
    WtloginHelper mHelper;
    boolean mIsSmslogin = false;
    String mMsgCode;
    byte[] mPictureData;
    boolean mPwdMd5;
    int mReportErrType;
    TransReqContext mReqContext;
    int mReqType;
    byte[][] mReserve;
    long mRole;
    byte[][] mST;
    byte[] mST1;
    byte[] mST1Key;
    long mSmsAppid;
    long mSsoVer2;
    long mSubAppid1;
    long mSubAppid2;
    long mUIN;
    String mUserAccount;
    byte[] mUserInput;
    String mUserPasswd;
    WUserSigInfo mUserSigInfo = null;
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, int paramInt, String paramString1, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mEncrypt = paramInt;
      this.mUserAccount = paramString1;
      this.mDwAppid = paramLong1;
      this.mRole = paramLong2;
      this.mReqContext = paramTransReqContext;
      setName(paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, int paramInt, String paramString1, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mEncrypt = paramInt;
      this.mUserAccount = paramString1;
      this.mDwAppid = paramLong1;
      this.mRole = paramLong2;
      this.mReqContext = paramTransReqContext;
      this.mUserSigInfo = paramWUserSigInfo;
      setName(paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, long paramLong1, long paramLong2, String paramString1, WUserSigInfo paramWUserSigInfo, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mAppid1 = paramLong1;
      this.mSubAppid1 = paramLong2;
      this.mUserSigInfo = paramWUserSigInfo;
      setName(paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, long paramLong1, int paramInt, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean1, String paramString2, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, boolean paramBoolean2, String paramString3)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mDwAppid = paramLong1;
      this.mDwMainSigMap = paramInt;
      this.mDwSubDstAppid = paramLong2;
      this.mDwSubAppidList = paramArrayOfLong;
      this.mPwdMd5 = paramBoolean1;
      this.mUserPasswd = paramString2;
      this.mUserSigInfo = paramWUserSigInfo;
      this.mST = paramArrayOfByte;
      this.mIsSmslogin = paramBoolean2;
      setName(paramString3);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, long paramLong1, long paramLong2, int paramInt, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mAppid1 = paramLong1;
      this.mSubAppid1 = paramLong2;
      this.mDwMainSigMap = paramInt;
      this.mAppName2 = paramArrayOfByte1;
      this.mSsoVer2 = paramLong4;
      this.mAppid2 = paramLong4;
      this.mSubAppid2 = paramLong5;
      this.mAppVer2 = paramArrayOfByte2;
      this.mAppSign2 = paramArrayOfByte3;
      this.mUserSigInfo = paramWUserSigInfo;
      this.mFastLoginInfo = paramWFastLoginInfo;
      setName(paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mDwAppid = paramLong1;
      this.mDwDstAppid = paramLong2;
      this.mDwDstAppPri = paramLong3;
      this.mDwMainSigMap = paramInt;
      this.mDwSubDstAppid = paramLong4;
      this.mDwDstSubAppidList = paramArrayOfLong;
      this.mUserSigInfo = paramWUserSigInfo;
      this.mST = paramArrayOfByte1;
      this.mReserve = paramArrayOfByte2;
      setName(paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, long paramLong, WUserSigInfo paramWUserSigInfo, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mSmsAppid = paramLong;
      this.mUserSigInfo = paramWUserSigInfo;
      setName(paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, String paramString3)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mMsgCode = paramString2;
      this.mUserSigInfo = paramWUserSigInfo;
      setName(paramString3);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, WUserSigInfo paramWUserSigInfo, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mUserSigInfo = paramWUserSigInfo;
      setName(paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mUserInput = paramArrayOfByte;
      this.mUserSigInfo = paramWUserSigInfo;
      this.mST = paramArrayOfByte1;
      setName(paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, int paramInt, String paramString)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mST1 = paramArrayOfByte1;
      this.mST1Key = paramArrayOfByte2;
      this.mUIN = paramLong1;
      this.mDwAppid = paramLong2;
      this.mReportErrType = paramInt;
      setName(paramString);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, String paramString)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mST1 = paramArrayOfByte1;
      this.mST1Key = paramArrayOfByte2;
      this.mUIN = paramLong1;
      this.mDwAppid = paramLong2;
      setName(paramString);
    }
    
    private void quitSelfLooper()
    {
      try
      {
        if (this.isSelfLooper)
        {
          Looper.myLooper().quit();
          this.mHandler = null;
        }
        return;
      }
      catch (Exception localException)
      {
        util.printException(localException, "");
      }
    }
    
    public void RunReq(int paramInt)
    {
      this.mReqType = paramInt;
      start();
    }
    
    public void run()
    {
      if (this.mHelper.mListener == null) {
        return;
      }
      int k = this.mHelper.mG.q;
      boolean bool;
      if (this.mHandler == null)
      {
        bool = true;
        label32:
        this.isSelfLooper = bool;
        if (this.isSelfLooper)
        {
          Looper.prepare();
          this.mHandler = WtloginHelper.this.newHelperHandler();
        }
      }
      for (;;)
      {
        int i;
        try
        {
          if (this.mHandler == null) {
            throw new Exception("Handler should not be null!");
          }
        }
        catch (Exception localException)
        {
          util.printException(localException, "");
          this.mHandler.post(new WtloginHelper.HelperThread.13(this, k));
          return;
          bool = false;
          break label32;
          if (this.mReqType == 0)
          {
            i = this.mHelper.GetStWithPasswd(this.mUserAccount, this.mDwAppid, this.mDwMainSigMap, this.mDwSubDstAppid, this.mDwSubAppidList, this.mPwdMd5, this.mUserPasswd, this.mUserSigInfo, this.mST, this.mIsSmslogin, 1);
            util.LOGD(getClass().getName() + "run ReqType=" + this.mReqType + "ret=" + i);
            this.mHandler.post(new WtloginHelper.HelperThread.1(this, k, i));
            return;
          }
          if (this.mReqType == 1)
          {
            i = this.mHelper.RefreshPictureData(this.mUserAccount, this.mUserSigInfo, 1);
            util.LOGD(getClass().getName() + "run ReqType=" + this.mReqType + "ret=" + i);
            this.mHandler.post(new WtloginHelper.HelperThread.2(this, k, i));
            continue;
          }
        }
        finally
        {
          if (this.isSelfLooper) {
            Looper.loop();
          }
        }
        if (this.mReqType == 2)
        {
          i = this.mHelper.CheckPictureAndGetSt(this.mUserAccount, this.mUserInput, this.mUserSigInfo, this.mST, 1);
          util.LOGD(getClass().getName() + "run ReqType=" + this.mReqType + "ret=" + i);
          this.mHandler.post(new WtloginHelper.HelperThread.3(this, k, i));
        }
        else if (this.mReqType == 3)
        {
          i = this.mHelper.RefreshSMSData(this.mUserAccount, this.mSmsAppid, this.mUserSigInfo, 1);
          util.LOGD(getClass().getName() + "run ReqType=" + this.mReqType + "ret=" + i);
          this.mHandler.post(new WtloginHelper.HelperThread.4(this, k, i));
        }
        else if (this.mReqType == 4)
        {
          i = this.mHelper.CheckSMSAndGetSt(this.mUserAccount, this.mUserInput, this.mUserSigInfo, this.mST, 1);
          util.LOGD(getClass().getName() + "run ReqType=" + this.mReqType + "ret=" + i);
          this.mHandler.post(new WtloginHelper.HelperThread.5(this, k, i));
        }
        else if (this.mReqType == 5)
        {
          int j = this.mHelper.GetStWithoutPasswd(this.mUserAccount, this.mDwAppid, this.mDwDstAppid, this.mDwDstAppPri, this.mDwMainSigMap, this.mDwSubDstAppid, this.mDwDstSubAppidList, this.mUserSigInfo, this.mST, this.mReserve, 1);
          i = j;
          if (j == 1) {
            i = 15;
          }
          util.LOGD(getClass().getName() + "run ReqType=" + this.mReqType + "ret=" + i);
          this.mHandler.post(new WtloginHelper.HelperThread.6(this, k, i));
        }
        else if (this.mReqType == 6)
        {
          i = this.mHelper.GetA1WithA1(this.mUserAccount, this.mAppid1, this.mSubAppid1, this.mDwMainSigMap, this.mAppName2, this.mSsoVer2, this.mAppid2, this.mSubAppid2, this.mAppVer2, this.mAppSign2, this.mUserSigInfo, this.mFastLoginInfo, 1);
          util.LOGD(getClass().getName() + "run ReqType=" + this.mReqType + "ret=" + i);
          this.mHandler.post(new WtloginHelper.HelperThread.7(this, k, i));
        }
        else if (this.mReqType == 7)
        {
          i = this.mHelper.RequestReport(1, this.mST1, this.mST1Key, this.mUIN, this.mDwAppid);
          util.LOGD(getClass().getName() + "run ReqType=" + this.mReqType + "ret=" + i);
        }
        else if (this.mReqType == 9)
        {
          i = this.mHelper.RequestTransport(1, this.mEncrypt, this.mUserAccount, this.mDwAppid, this.mRole, this.mReqContext, this.mUserSigInfo);
          util.LOGD(getClass().getName() + "run ReqType=" + this.mReqType + "ret=" + i);
          this.mHandler.post(new WtloginHelper.HelperThread.8(this, k, i));
        }
        else if (this.mReqType == 10)
        {
          i = this.mHelper.RequestTransportMsf(1, this.mEncrypt, this.mUserAccount, this.mDwAppid, this.mRole, this.mReqContext);
          util.LOGD(getClass().getName() + "run ReqType=" + this.mReqType + "ret=" + i);
          this.mHandler.post(new WtloginHelper.HelperThread.9(this, k, i));
        }
        else if (this.mReqType == 12)
        {
          i = this.mHelper.CheckSMSVerifyLoginAccount(this.mAppid1, this.mSubAppid1, this.mUserAccount, this.mUserSigInfo, 1);
          util.LOGD(getClass().getName() + "run ReqType=" + this.mReqType + "ret=" + i);
          this.mHandler.post(new WtloginHelper.HelperThread.10(this, k, i));
        }
        else if (this.mReqType == 13)
        {
          i = this.mHelper.VerifySMSVerifyLoginCode(this.mUserAccount, this.mMsgCode, this.mUserSigInfo, 1);
          util.LOGD(getClass().getName() + "run ReqType=" + this.mReqType + "ret=" + i);
          this.mHandler.post(new WtloginHelper.HelperThread.11(this, k, i));
        }
        else if (this.mReqType == 14)
        {
          i = this.mHelper.RefreshSMSVerifyLoginCode(this.mUserAccount, this.mUserSigInfo, 1);
          util.LOGD(getClass().getName() + "run ReqType=" + this.mReqType + "ret=" + i);
          this.mHandler.post(new WtloginHelper.HelperThread.12(this, k, i));
        }
        else if (this.mReqType == 8)
        {
          this.mHelper.RequestReportError(1, this.mST1, this.mST1Key, this.mUIN, this.mDwAppid, this.mReportErrType);
        }
      }
    }
  }
  
  public static final class SigType
  {
    public static final int WLOGIN_A2 = 64;
    public static final int WLOGIN_A5 = 2;
    public static final int WLOGIN_A8 = 16;
    public static final int WLOGIN_AQSIG = 2097152;
    public static final int WLOGIN_D2 = 262144;
    public static final int WLOGIN_LSKEY = 512;
    public static final int WLOGIN_OPENKEY = 16384;
    public static final int WLOGIN_PSKEY = 1048576;
    public static final int WLOGIN_SID = 524288;
    public static final int WLOGIN_SIG64 = 8192;
    public static final int WLOGIN_SKEY = 4096;
    public static final int WLOGIN_ST = 128;
    public static final int WLOGIN_STWEB = 32;
    public static final int WLOGIN_TOKEN = 32768;
    public static final int WLOGIN_VKEY = 131072;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper
 * JD-Core Version:    0.7.0.1
 */