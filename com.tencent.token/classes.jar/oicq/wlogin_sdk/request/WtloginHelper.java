package oicq.wlogin_sdk.request;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.secprotocol.ByteData;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import oicq.wlogin_sdk.code2d.fetch_code;
import oicq.wlogin_sdk.code2d.fetch_code.QRCodeCustom;
import oicq.wlogin_sdk.devicelock.DevlockBase;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.devicelock.DevlockRst;
import oicq.wlogin_sdk.devicelock.TLV_CommRsp;
import oicq.wlogin_sdk.devicelock.j;
import oicq.wlogin_sdk.devicelock.k;
import oicq.wlogin_sdk.listener.PrivacyListener;
import oicq.wlogin_sdk.listener.QimeiListener;
import oicq.wlogin_sdk.listener.ReportListener;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.report.report_t2;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tlv_type.RegTLV;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t105;
import oicq.wlogin_sdk.tlv_type.tlv_t106;
import oicq.wlogin_sdk.tlv_type.tlv_t10c;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t150;
import oicq.wlogin_sdk.tlv_type.tlv_t165;
import oicq.wlogin_sdk.tlv_type.tlv_t16a;
import oicq.wlogin_sdk.tlv_type.tlv_t400;
import oicq.wlogin_sdk.tlv_type.tlv_t543;
import oicq.wlogin_sdk.tlv_type.tlv_t546;
import oicq.wlogin_sdk.tools.EcdhCrypt;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.InternationMsg;
import oicq.wlogin_sdk.tools.InternationMsg.MSG_TYPE;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.RSACrypt;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class WtloginHelper
{
  static final Object GET_ST_WITHOUT_PASSWORD_LOCK = new Object();
  static final Object GET_TICKET_LOCK = new Object();
  static final Object __sync_top = new Object();
  static int __top;
  private static b mWtDataSender;
  private boolean isForLocal = false;
  private long mAysncSeq = 0L;
  private Context mContext = null;
  private u mG = new u(null);
  private Handler mHelperHandler = initHelperHandler();
  private WtloginListener mListener = null;
  private int mMainSigMap = 16724722;
  private int mMiscBitmap = 150470524;
  private long mOpenAppid = 715019303L;
  private oicq.wlogin_sdk.a.i mRegStatus = new oicq.wlogin_sdk.a.i();
  private int mSubSigMap = 66560;
  
  public WtloginHelper(Context paramContext)
  {
    this.isForLocal = false;
    this.mContext = paramContext;
    this.mG.b(paramContext);
    RequestInit();
  }
  
  public WtloginHelper(Context paramContext, Object paramObject)
  {
    WtloginMsfListener.TicketMgr = paramObject;
    localInit(paramContext, this.isForLocal);
  }
  
  public WtloginHelper(Context paramContext, Object paramObject, PrivacyListener paramPrivacyListener)
  {
    WtloginMsfListener.TicketMgr = paramObject;
    util.privacyListener = paramPrivacyListener;
    localInit(paramContext, this.isForLocal);
  }
  
  public WtloginHelper(Context paramContext, PrivacyListener paramPrivacyListener)
  {
    util.privacyListener = paramPrivacyListener;
    localInit(paramContext, this.isForLocal);
  }
  
  public WtloginHelper(Context paramContext, boolean paramBoolean)
  {
    localInit(paramContext, paramBoolean);
  }
  
  public WtloginHelper(Context paramContext, boolean paramBoolean, PrivacyListener paramPrivacyListener)
  {
    util.privacyListener = paramPrivacyListener;
    localInit(paramContext, paramBoolean);
  }
  
  private void AsyncGenRSAKey()
  {
    if (this.isForLocal) {
      return;
    }
    new WtloginHelper.2(this, "Wtlogin_AsyncGenRSAKey").start();
  }
  
  private int CheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, int paramInt)
  {
    if ((paramString != null) && (paramArrayOfByte != null) && (paramWUserSigInfo != null))
    {
      if (paramInt == 0)
      {
        new HelperThread(this, this.mHelperHandler, paramString, paramArrayOfByte, paramWUserSigInfo, paramArrayOfByte1, "CheckPictureAndGetSt").RunReq(2);
        return -1001;
      }
      if (paramWUserSigInfo._seqence == 0L) {
        paramWUserSigInfo._seqence = this.mAysncSeq;
      }
      u localu = this.mG.a(paramWUserSigInfo._seqence);
      paramWUserSigInfo._seqence = localu.h;
      async_context localasync_context = u.b(paramWUserSigInfo._seqence);
      Object localObject1 = new StringBuilder("user:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" CheckPictureAndGetSt Seq:");
      ((StringBuilder)localObject1).append(localu.h);
      ((StringBuilder)localObject1).append(" ...");
      util.LOGI(((StringBuilder)localObject1).toString(), paramString);
      localu.g = paramString;
      localasync_context._last_err_msg = new ErrMsg();
      long l1;
      if (!util.check_uin_account(paramString).booleanValue())
      {
        l1 = localu.b(paramString);
        if (l1 != 0L) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
      }
      else
      {
        l1 = Long.parseLong(paramString);
        paramInt = 1;
      }
      if (paramInt == 1)
      {
        localu.f = l1;
        paramWUserSigInfo.uin = String.valueOf(l1);
      }
      if ((u.an == null) || (u.an.length == 0))
      {
        oicq.wlogin_sdk.pow.b.b(localasync_context._t546.get_data());
        util.LOGI("syncCalcPow", "");
      }
      localObject1 = new p(localu);
      int j = this.mMiscBitmap;
      int k = this.mSubSigMap;
      Object localObject2 = localasync_context._sub_appid_list;
      int i = paramInt;
      j = ((p)localObject1).a(paramArrayOfByte, j, k, (long[])localObject2, paramWUserSigInfo);
      paramInt = j;
      if (j == 204) {
        paramInt = new r(localu).a(this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo);
      }
      if ((paramInt != 0) && (paramInt != 160)) {
        break label1206;
      }
      long l2;
      if (!util.check_uin_account(paramString).booleanValue())
      {
        l2 = localu.b(paramString);
        l1 = l2;
        if (l2 != 0L)
        {
          i = 1;
          l1 = l2;
        }
      }
      else
      {
        l1 = Long.parseLong(paramString);
        i = 1;
      }
      if ((localasync_context._msalt == 0L) && (i == 0))
      {
        paramInt = -1003;
      }
      else
      {
        localu.f = l1;
        paramWUserSigInfo.uin = String.valueOf(l1);
        if (paramInt != 160)
        {
          if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
          {
            localu.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
            paramArrayOfByte = new StringBuilder("MSF SSO SEQ:");
            paramArrayOfByte.append(localu.i);
            util.LOGI(paramArrayOfByte.toString(), paramString);
          }
          else
          {
            localu.i = 0;
          }
          paramArrayOfByte = localu.a(l1, localasync_context._appid);
          if (paramArrayOfByte != null)
          {
            paramWUserSigInfo.get_clone(paramArrayOfByte);
            if ((localasync_context._sub_appid_list != null) && (paramArrayOfByte1 != null) && (localasync_context._sub_appid_list.length * 2 == paramArrayOfByte1.length))
            {
              paramInt = 0;
              while ((localasync_context._sub_appid_list != null) && (paramInt < localasync_context._sub_appid_list.length))
              {
                paramArrayOfByte = localu.a(l1, localasync_context._sub_appid_list[paramInt]);
                if (paramArrayOfByte != null)
                {
                  i = paramInt * 2;
                  paramArrayOfByte1[i] = ((byte[])paramArrayOfByte._userSt_Key.clone());
                  paramArrayOfByte1[(i + 1)] = ((byte[])paramArrayOfByte._userStSig.clone());
                }
                paramInt += 1;
              }
            }
            paramInt = 0;
          }
          else
          {
            if ((paramWUserSigInfo._in_ksid != null) && (paramWUserSigInfo._in_ksid.length > 0)) {
              paramArrayOfByte = (byte[])paramWUserSigInfo._in_ksid.clone();
            } else {
              paramArrayOfByte = u.ad;
            }
            if (localasync_context._tmp_pwd_type != 0)
            {
              localObject2 = new m(localu, this.mContext);
              ((m)localObject2).g();
              l1 = localasync_context._appid;
              l2 = localasync_context._sub_appid;
              localObject1 = localasync_context;
              paramInt = ((m)localObject2).a(l1, l2, localu.f, 0, u.ag, ((async_context)localObject1)._tmp_pwd, null, this.mMiscBitmap, this.mSubSigMap, ((async_context)localObject1)._sub_appid_list, ((async_context)localObject1)._main_sigmap, ((async_context)localObject1)._sub_appid, u.z, 0, 0, 1, paramArrayOfByte, paramWUserSigInfo);
            }
            else
            {
              localObject1 = localasync_context;
              localObject2 = new byte[4];
              util.int64_to_buf32((byte[])localObject2, 0, System.currentTimeMillis() / 1000L + u.af);
              if (((async_context)localObject1)._isSmslogin) {
                paramInt = 3;
              } else {
                paramInt = 1;
              }
              m localm = new m(localu, this.mContext);
              localm.g();
              paramInt = localm.a(((async_context)localObject1)._appid, ((async_context)localObject1)._sub_appid, localu.f, 0, u.ag, (byte[])localObject2, ((async_context)localObject1)._tmp_pwd, paramInt, this.mMiscBitmap, this.mSubSigMap, ((async_context)localObject1)._sub_appid_list, ((async_context)localObject1)._main_sigmap, ((async_context)localObject1)._sub_appid, u.z, 0, 0, 1, paramArrayOfByte, paramWUserSigInfo);
            }
            paramArrayOfByte = localasync_context;
            if (paramInt == 204) {
              paramInt = new r(localu).a(this.mMiscBitmap, this.mSubSigMap, paramArrayOfByte._sub_appid_list, paramWUserSigInfo);
            }
            if ((paramInt == 0) || (paramInt == 160))
            {
              if (paramArrayOfByte.ifQQLoginInQim(u.aA)) {
                l1 = paramArrayOfByte._uin;
              } else {
                l1 = localu.b(paramString);
              }
              paramWUserSigInfo.uin = String.valueOf(l1);
              if (paramInt != 160)
              {
                localObject1 = localu.a(l1, paramArrayOfByte._appid);
                if (localObject1 == null)
                {
                  paramInt = -1004;
                }
                else
                {
                  paramWUserSigInfo.get_clone((WloginSigInfo)localObject1);
                  if ((paramArrayOfByte._sub_appid_list != null) && (paramArrayOfByte1 != null) && (paramArrayOfByte._sub_appid_list.length * 2 == paramArrayOfByte1.length))
                  {
                    paramInt = 0;
                    while ((paramArrayOfByte._sub_appid_list != null) && (paramInt < paramArrayOfByte._sub_appid_list.length))
                    {
                      localObject1 = localu.a(l1, paramArrayOfByte._sub_appid_list[paramInt]);
                      if (localObject1 != null)
                      {
                        i = paramInt * 2;
                        paramArrayOfByte1[i] = ((byte[])((WloginSigInfo)localObject1)._userSt_Key.clone());
                        paramArrayOfByte1[(i + 1)] = ((byte[])((WloginSigInfo)localObject1)._userStSig.clone());
                      }
                      paramInt += 1;
                    }
                  }
                  paramInt = 0;
                }
              }
            }
          }
        }
      }
      label1206:
      paramArrayOfByte = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      if (paramArrayOfByte == null) {
        paramArrayOfByte = new Ticket();
      }
      u.at.commit_t2(localu.f, localu.g, util.format_ret_code(paramInt), paramInt);
      if (paramInt == 0)
      {
        if ((paramArrayOfByte._sig != null) && (paramArrayOfByte._sig.length != 0)) {
          RequestReport(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localu.f, localasync_context._appid);
        }
      }
      else
      {
        paramWUserSigInfo = paramArrayOfByte;
        RequestReportError(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, localu.f, localasync_context._appid, 0);
      }
      if ((localu.d != null) && (localu.d.get_bitmap() != 0))
      {
        this.mG.d = localu.d;
        RequestReportError(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localu.f, localasync_context._appid, 1);
      }
      oicq.wlogin_sdk.report.c.a();
      u.b();
      localu.i();
      paramArrayOfByte = new StringBuilder("user:");
      paramArrayOfByte.append(paramString);
      paramArrayOfByte.append(" CheckPictureAndGetSt Seq:");
      paramArrayOfByte.append(localu.h);
      paramArrayOfByte.append(" ret=");
      paramArrayOfByte.append(paramInt);
      paramString = paramArrayOfByte.toString();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(localu.f);
      util.LOGI(paramString, paramArrayOfByte.toString());
      return paramInt;
    }
    return -1017;
  }
  
  private int CheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte1, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, byte[] paramArrayOfByte2, int paramInt)
  {
    if ((paramString != null) && (paramArrayOfByte1 != null) && (paramWUserSigInfo != null))
    {
      if (paramInt == 0)
      {
        new HelperThread(this, this.mHelperHandler, paramString, paramArrayOfByte1, paramWUserSigInfo, paramArrayOfByte, paramArrayOfByte2, "CheckSMSAndGetSt").RunReq(4);
        return -1001;
      }
      if (paramWUserSigInfo._seqence == 0L) {
        paramWUserSigInfo._seqence = this.mAysncSeq;
      }
      u localu = this.mG.a(paramWUserSigInfo._seqence);
      paramWUserSigInfo._seqence = localu.h;
      async_context localasync_context = u.b(paramWUserSigInfo._seqence);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
      localStringBuilder.append("user:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" CheckSMSAndGetSt Seq:");
      localStringBuilder.append(localu.h);
      localStringBuilder.append("_msalt");
      localStringBuilder.append(Long.toHexString(localasync_context._msalt));
      localStringBuilder.append(" ...");
      util.LOGI(localStringBuilder.toString(), paramString);
      localu.g = paramString;
      localu.f = 0L;
      localasync_context._last_err_msg = new ErrMsg();
      if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
      {
        localu.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
        localStringBuilder = new StringBuilder("MSF SSO SEQ:");
        localStringBuilder.append(localu.i);
        util.LOGI(localStringBuilder.toString(), paramString);
      }
      else
      {
        localu.i = 0;
      }
      if (isGateWay(paramWUserSigInfo)) {
        return checkSMSAndGetStForGateWay(localu, localasync_context, paramString, paramArrayOfByte1, paramWUserSigInfo, paramArrayOfByte2);
      }
      long l;
      if (!util.check_uin_account(paramString).booleanValue())
      {
        l = localu.b(paramString);
        if (l == 0L)
        {
          paramArrayOfByte1 = new StringBuilder("user:");
          paramArrayOfByte1.append(paramString);
          paramArrayOfByte1.append(" have not found uin record.");
          util.LOGI(paramArrayOfByte1.toString(), paramString);
          paramInt = -1003;
          break label690;
        }
      }
      else
      {
        l = Long.parseLong(paramString);
      }
      localu.f = l;
      paramWUserSigInfo.uin = String.valueOf(l);
      int i = new q(localu).a(paramArrayOfByte1, this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo, paramArrayOfByte2);
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
      paramArrayOfByte1.append("user:");
      paramArrayOfByte1.append(paramString);
      paramArrayOfByte1.append("ret");
      paramArrayOfByte1.append(i);
      paramArrayOfByte1.append(",uin:");
      paramArrayOfByte1.append(l);
      paramArrayOfByte1.append("CheckSMSAndGetSt extraData:");
      if (paramArrayOfByte2 != null) {
        paramInt = paramArrayOfByte2.length;
      } else {
        paramInt = 0;
      }
      paramArrayOfByte1.append(paramInt);
      util.LOGI(paramArrayOfByte1.toString(), "");
      if (i == 0)
      {
        paramArrayOfByte1 = localu.a(l, localasync_context._appid);
        if (paramArrayOfByte1 == null)
        {
          paramInt = -1004;
        }
        else
        {
          paramWUserSigInfo.get_clone(paramArrayOfByte1);
          if ((localasync_context._sub_appid_list != null) && (paramArrayOfByte != null) && (localasync_context._sub_appid_list.length * 2 == paramArrayOfByte.length))
          {
            paramInt = 0;
            while ((localasync_context._sub_appid_list != null) && (paramInt < localasync_context._sub_appid_list.length))
            {
              paramArrayOfByte1 = localu.a(l, localasync_context._sub_appid_list[paramInt]);
              if (paramArrayOfByte1 != null)
              {
                i = paramInt * 2;
                paramArrayOfByte[i] = ((byte[])paramArrayOfByte1._userSt_Key.clone());
                paramArrayOfByte[(i + 1)] = ((byte[])paramArrayOfByte1._userStSig.clone());
              }
              paramInt += 1;
            }
          }
          paramInt = 0;
        }
      }
      else
      {
        paramInt = i;
      }
      label690:
      paramArrayOfByte1 = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      if (paramArrayOfByte1 == null) {
        paramArrayOfByte1 = new Ticket();
      }
      u.at.commit_t2(localu.f, localu.g, util.format_ret_code(paramInt), paramInt);
      if (paramInt == 0)
      {
        if ((paramArrayOfByte1._sig != null) && (paramArrayOfByte1._sig.length != 0)) {
          RequestReport(0, paramArrayOfByte1._sig, paramArrayOfByte1._sig_key, localu.f, localasync_context._appid);
        }
      }
      else {
        RequestReportError(0, paramArrayOfByte1._sig, paramArrayOfByte1._sig_key, localu.f, localasync_context._appid, 0);
      }
      if ((localu.d != null) && (localu.d.get_bitmap() != 0))
      {
        this.mG.d = localu.d;
        RequestReportError(0, paramArrayOfByte1._sig, paramArrayOfByte1._sig_key, localu.f, localasync_context._appid, 1);
      }
      u.b();
      localu.i();
      paramArrayOfByte1 = new StringBuilder("user:");
      paramArrayOfByte1.append(paramString);
      paramArrayOfByte1.append(" CheckSMSAndGetSt Seq:");
      paramArrayOfByte1.append(localu.h);
      paramArrayOfByte1.append(" ret=");
      paramArrayOfByte1.append(paramInt);
      paramString = paramArrayOfByte1.toString();
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append(localu.f);
      util.LOGI(paramString, paramArrayOfByte1.toString());
      return paramInt;
    }
    return -1017;
  }
  
  private int CheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, String paramString, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2)
  {
    int i = 0;
    oicq.wlogin_sdk.a.i.y = false;
    oicq.wlogin_sdk.a.i.z = 0L;
    if (((paramLong3 == -1L) && (paramString == null)) || (paramWUserSigInfo == null)) {
      return -1017;
    }
    if (paramInt2 == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramLong1, paramLong2, paramString, paramInt1, paramLong3, paramWUserSigInfo, "CheckSMSVerifyLoginAccount").RunReq(12);
      return -1001;
    }
    u localu = this.mG.a(0L);
    paramWUserSigInfo._seqence = localu.h;
    this.mAysncSeq = localu.h;
    Object localObject = u.b(localu.h);
    localu.g = paramString;
    StringBuilder localStringBuilder = new StringBuilder("user:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" Seq:");
    localStringBuilder.append(localu.h);
    localStringBuilder.append(" CheckSMSVerifyLoginAccount ...");
    util.LOGI(localStringBuilder.toString(), paramString);
    ((async_context)localObject)._login_bitmap = paramWUserSigInfo._login_bitmap;
    ((async_context)localObject)._last_err_msg = new ErrMsg();
    paramInt1 = new y(localu).a(paramLong1, paramLong2, this.mMainSigMap, u.ad, paramString, this.mMiscBitmap, this.mSubSigMap, null, paramInt1, paramLong3, paramWUserSigInfo);
    if (paramInt1 == 208) {
      paramInt1 = i;
    }
    localObject = new StringBuilder("user:");
    ((StringBuilder)localObject).append(localu.g);
    ((StringBuilder)localObject).append(" Seq:");
    ((StringBuilder)localObject).append(localu.h);
    ((StringBuilder)localObject).append(" CheckSMSVerifyLoginAccount ret=");
    if (paramInt1 > 0) {
      paramWUserSigInfo = Integer.toHexString(paramInt1);
    } else {
      paramWUserSigInfo = Integer.valueOf(paramInt1);
    }
    ((StringBuilder)localObject).append(paramWUserSigInfo);
    util.LOGI(((StringBuilder)localObject).toString(), paramString);
    return paramInt1;
  }
  
  private WloginSigInfo FindUserSig(long paramLong1, long paramLong2)
  {
    return this.mG.a(paramLong1, paramLong2);
  }
  
  private int GetA1WithA1(String paramString, long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2)
  {
    if ((paramString != null) && (paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte3 != null) && (paramWUserSigInfo != null) && (paramWFastLoginInfo != null))
    {
      int i = paramInt1 | 0xC0;
      if (paramInt2 == 0)
      {
        new HelperThread(this, this.mHelperHandler, paramString, paramLong1, paramLong2, i, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramArrayOfByte2, paramArrayOfByte3, paramWUserSigInfo, paramWFastLoginInfo, "GetA1WithA1").RunReq(6);
        return -1001;
      }
      u localu = this.mG.a(0L);
      paramWUserSigInfo._seqence = localu.h;
      Object localObject1 = u.b(localu.h);
      Object localObject2 = new StringBuilder("wtlogin login with GetA1WithA1:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" dwSrcAppid:");
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append(" dwMainSigMap:");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" dwSubSrcAppid:");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append(" dstAppName:");
      ((StringBuilder)localObject2).append(new String(paramArrayOfByte1));
      ((StringBuilder)localObject2).append(" dwDstAppid:");
      ((StringBuilder)localObject2).append(paramLong4);
      ((StringBuilder)localObject2).append(" dwSubDstAppid:");
      ((StringBuilder)localObject2).append(paramLong5);
      ((StringBuilder)localObject2).append(" Seq:");
      ((StringBuilder)localObject2).append(localu.h);
      ((StringBuilder)localObject2).append(" ...");
      util.LOGI(((StringBuilder)localObject2).toString(), paramString);
      paramInt1 = util.get_saved_network_type(this.mContext);
      u.E = util.get_network_type(this.mContext);
      if (paramInt1 != u.E)
      {
        util.set_net_retry_type(this.mContext, 0);
        util.save_network_type(this.mContext, u.E);
      }
      u.G = util.get_apn_string(this.mContext).getBytes();
      localu.g = paramString;
      localu.f = 0L;
      ((async_context)localObject1)._sappid = paramLong1;
      ((async_context)localObject1)._appid = paramLong1;
      ((async_context)localObject1)._sub_appid = paramLong2;
      ((async_context)localObject1)._main_sigmap = i;
      ((async_context)localObject1)._last_err_msg = new ErrMsg();
      u.at.add_t2(new report_t2("login", new String(u.D), System.currentTimeMillis(), paramLong4, paramLong5, null));
      long l1;
      if (!util.check_uin_account(paramString).booleanValue())
      {
        long l2 = localu.b(paramString);
        l1 = l2;
        if (l2 == 0L)
        {
          paramArrayOfByte2 = new StringBuilder("user:");
          paramArrayOfByte2.append(paramString);
          paramArrayOfByte2.append(" have not found uin record.");
          util.LOGI(paramArrayOfByte2.toString(), paramString);
          paramInt1 = -1003;
          break label737;
        }
      }
      else
      {
        l1 = Long.parseLong(paramString);
      }
      localu.f = l1;
      localu.k();
      localObject2 = getA1AndNopicSigByAccount(paramString, paramLong1);
      localObject1 = ((A1AndNopicSig)localObject2).a1;
      localObject2 = ((A1AndNopicSig)localObject2).noPicSig;
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        StringBuilder localStringBuilder = new StringBuilder("user:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" login with A1 exchange A1.");
        util.LOGI(localStringBuilder.toString(), paramString);
        paramInt2 = new n(localu).a(l1, paramLong1, paramLong2, 1, i, (byte[])localObject1, (byte[])localObject2, this.mMiscBitmap, this.mSubSigMap, null, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramArrayOfByte2, paramArrayOfByte3, paramWUserSigInfo);
        paramInt1 = paramInt2;
        if (paramInt2 == 0)
        {
          paramArrayOfByte2 = localu.a(l1, paramLong1);
          if (paramArrayOfByte2 == null)
          {
            paramInt1 = -1004;
          }
          else
          {
            paramWUserSigInfo.get_clone(paramArrayOfByte2);
            paramWFastLoginInfo.get_clone(localu.j);
            paramInt1 = paramInt2;
          }
        }
      }
      else
      {
        paramArrayOfByte2 = new StringBuilder("user:");
        paramArrayOfByte2.append(paramString);
        paramArrayOfByte2.append(" have no a1 or pic_sig.");
        util.LOGI(paramArrayOfByte2.toString(), paramString);
        paramInt1 = -1016;
      }
      label737:
      paramArrayOfByte2 = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      if (paramArrayOfByte2 == null) {
        paramArrayOfByte2 = new Ticket();
      }
      u.at.commit_t2(localu.f, localu.g, util.format_ret_code(paramInt1), paramInt1);
      if (paramInt1 == 0)
      {
        if ((paramArrayOfByte2._sig != null) && (paramArrayOfByte2._sig.length != 0)) {
          RequestReport(0, paramArrayOfByte2._sig, paramArrayOfByte2._sig_key, localu.f, paramLong1);
        }
      }
      else
      {
        paramArrayOfByte3 = paramArrayOfByte2;
        RequestReportError(0, paramArrayOfByte3._sig, paramArrayOfByte3._sig_key, localu.f, paramLong1, 0);
      }
      if ((localu.d != null) && (localu.d.get_bitmap() != 0))
      {
        this.mG.d = localu.d;
        RequestReportError(0, paramArrayOfByte2._sig, paramArrayOfByte2._sig_key, localu.f, paramLong1, 1);
      }
      u.b();
      localu.i();
      paramArrayOfByte2 = new StringBuilder("wtlogin login with GetA1WithA1:");
      paramArrayOfByte2.append(paramString);
      paramArrayOfByte2.append(" dwSrcAppid:");
      paramArrayOfByte2.append(paramLong1);
      paramArrayOfByte2.append(" dwMainSigMap:");
      paramArrayOfByte2.append(i);
      paramArrayOfByte2.append(" dwSubSrcAppid:");
      paramArrayOfByte2.append(paramLong2);
      paramArrayOfByte2.append(" dstAppName:");
      paramArrayOfByte2.append(new String(paramArrayOfByte1));
      paramArrayOfByte2.append(" dwDstAppid:");
      paramArrayOfByte2.append(paramLong4);
      paramArrayOfByte2.append(" dwSubDstAppid:");
      paramArrayOfByte2.append(paramLong5);
      paramArrayOfByte2.append(" Seq:");
      paramArrayOfByte2.append(localu.h);
      paramArrayOfByte2.append(" ret=");
      paramArrayOfByte2.append(paramInt1);
      util.LOGI(paramArrayOfByte2.toString(), paramString);
      return paramInt1;
    }
    return -1017;
  }
  
  private int GetFastLoginInfo(byte[] paramArrayOfByte, async_context paramasync_context)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 3))
    {
      if (paramasync_context == null) {
        return -1017;
      }
      tlv_t106 localtlv_t106 = new tlv_t106();
      tlv_t10c localtlv_t10c = new tlv_t10c();
      tlv_t16a localtlv_t16a = new tlv_t16a();
      Object localObject = new tlv_t145();
      int i = paramArrayOfByte.length;
      if (localtlv_t106.get_tlv(paramArrayOfByte, 3, i) < 0)
      {
        util.LOGI("fast login info no tgtgt data", "");
        return -1017;
      }
      if (localtlv_t10c.get_tlv(paramArrayOfByte, 3, i) < 0)
      {
        util.LOGI("fast login info no gtkey data", "");
        return -1017;
      }
      if (localtlv_t16a.get_tlv(paramArrayOfByte, 3, i) < 0)
      {
        util.LOGI("fast login info no nopicsig data", "");
        return -1017;
      }
      if (((tlv_t145)localObject).get_tlv(paramArrayOfByte, 3, i) > 0)
      {
        paramArrayOfByte = ((tlv_t145)localObject).get_data();
        localObject = u.B;
        StringBuilder localStringBuilder = new StringBuilder("new guid:");
        localStringBuilder.append(util.buf_to_string(paramArrayOfByte));
        localStringBuilder.append(" old guid:");
        localStringBuilder.append(util.buf_to_string((byte[])localObject));
        util.LOGD(localStringBuilder.toString());
        if (!Arrays.equals(paramArrayOfByte, (byte[])localObject))
        {
          util.LOGI("fast login info guid not equal", "");
          util.saveGuidToFile(u.u, paramArrayOfByte);
          u.B = (byte[])paramArrayOfByte.clone();
          u.C = (byte[])paramArrayOfByte.clone();
        }
      }
      paramasync_context._tmp_pwd = oicq_request.b(localtlv_t106.get_data(), localtlv_t10c.get_data());
      paramasync_context._tmp_no_pic_sig = localtlv_t16a.get_data();
      return 0;
    }
    return -1017;
  }
  
  public static WFastLoginInfo GetFastLoginUrl(String paramString, long paramLong)
  {
    if (paramString != null) {}
    try
    {
      if (paramString.length() == 0) {
        return null;
      }
      Object localObject = new StringBuilder("packageName:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" uin:");
      ((StringBuilder)localObject).append(paramLong);
      util.LOGI(((StringBuilder)localObject).toString(), "");
      if (paramLong == 1689053018L)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://imgcache.qq.com/wtlogin");
        ((StringBuilder)localObject).append("/test");
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://imgcache.qq.com/wtlogin");
        ((StringBuilder)localObject).append("/app");
        localObject = ((StringBuilder)localObject).toString();
      }
      paramString = paramString.split("\\.");
      int i = 0;
      while (i < paramString.length)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("/");
        localObject = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(paramString[i]);
        localObject = localStringBuilder.toString();
        i += 1;
      }
      paramString = new WFastLoginInfo();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/icon.png");
      paramString.iconUrl = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/ad_img.png");
      paramString.adUrl = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/profile.js");
      paramString.profileUrl = localStringBuilder.toString();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
    return null;
  }
  
  private int GetStWithPasswd(String paramString1, long paramLong1, int paramInt1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean1, String paramString2, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, boolean paramBoolean2, int paramInt2)
  {
    return 0;
  }
  
  private int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt1, long paramLong4, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2, int paramInt2, WtTicketPromise paramWtTicketPromise)
  {
    if ((paramString != null) && (paramWUserSigInfo != null))
    {
      paramInt1 |= 0xC0;
      if (2L == paramLong4) {
        paramInt1 &= 0xFDFFFFFF;
      }
      if (paramInt2 == 0)
      {
        new HelperThread(this, this.mHelperHandler, paramWtTicketPromise, paramString, paramLong1, paramLong2, paramLong3, paramInt1, paramLong4, paramArrayOfLong, paramWUserSigInfo, paramArrayOfByte1, paramArrayOfByte2, "GetStWithoutPasswd").RunReq(5);
        return -1001;
      }
      paramInt1 = realGetStWithoutPasswd(paramString, paramLong1, paramLong2, paramLong3, paramInt1, paramLong4, paramArrayOfLong, paramWUserSigInfo, paramArrayOfByte1, paramArrayOfByte2, paramWtTicketPromise);
      if ((paramInt1 != 0) && (paramInt1 != -1000)) {
        oicq.wlogin_sdk.report.event.c.a(new oicq.wlogin_sdk.report.event.b("wtlogin_change_ticket_error", String.valueOf(paramInt1), "").a(paramString).c(true));
      }
      return paramInt1;
    }
    return -1017;
  }
  
  private int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, WUserSigInfo paramWUserSigInfo, WtTicketPromise paramWtTicketPromise)
  {
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, -1L, paramInt, paramLong3, null, paramWUserSigInfo, null, null, 0, paramWtTicketPromise);
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
    if ((paramInt != 64) && (paramInt != 262144) && (paramInt != 128) && (paramInt != 16384) && (paramInt != 32768) && (paramInt != 16777216)) {
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
    if (paramInt == 4194304) {
      return new Ticket(4194304, WloginSigInfo._LHSig, null, u.f(), 0L);
    }
    if (paramInt == 67108864) {
      return new Ticket(67108864, WloginSigInfo._QRPUSHSig, null, u.f(), 0L);
    }
    if (paramWUserSigInfo == null)
    {
      paramWUserSigInfo = new StringBuilder("GetUserSigInfoTicket userInfo is null ");
      paramWUserSigInfo.append(Integer.toHexString(paramInt));
      util.LOGI(paramWUserSigInfo.toString(), "");
      return null;
    }
    Object localObject;
    if (paramWUserSigInfo._tickets == null)
    {
      localObject = new StringBuilder("GetUserSigInfoTicket tickets is null ");
      ((StringBuilder)localObject).append(Integer.toHexString(paramInt));
      util.LOGI(((StringBuilder)localObject).toString(), paramWUserSigInfo.uin);
      return null;
    }
    if (paramWUserSigInfo._tickets != null)
    {
      int i = 0;
      while (i < paramWUserSigInfo._tickets.size())
      {
        localObject = (Ticket)paramWUserSigInfo._tickets.get(i);
        if (((Ticket)localObject)._type == paramInt)
        {
          StringBuilder localStringBuilder = new StringBuilder("GetUserSigInfoTicket type:0x");
          localStringBuilder.append(Integer.toHexString(paramInt));
          localStringBuilder.append(" sig:");
          localStringBuilder.append(util.buf_len(((Ticket)localObject)._sig));
          localStringBuilder.append(" key:");
          localStringBuilder.append(util.buf_len(((Ticket)localObject)._sig_key));
          localStringBuilder.append(" create time:");
          localStringBuilder.append(((Ticket)localObject)._create_time);
          localStringBuilder.append(" expire time:");
          localStringBuilder.append(((Ticket)localObject)._expire_time);
          util.LOGI(localStringBuilder.toString(), "");
          util.LOGI(((Ticket)localObject).getContent(), paramWUserSigInfo.uin);
          return localObject;
        }
        i += 1;
      }
    }
    paramWUserSigInfo = new StringBuilder("GetUserSigInfoTicket type null: 0x");
    paramWUserSigInfo.append(Integer.toHexString(paramInt));
    util.LOGI(paramWUserSigInfo.toString(), "");
    return null;
  }
  
  private void OnDeviceLockRequest(String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    DevlockRst localDevlockRst = DevlockBase.rst;
    localDevlockRst.commRsp = new TLV_CommRsp();
    DevlockInfo localDevlockInfo = new DevlockInfo();
    ErrMsg localErrMsg = new ErrMsg(0, 0, "", "", "");
    if (paramInt != 0)
    {
      util.LOGI("OnDeviceLockRequest ret:".concat(String.valueOf(paramInt)), paramString);
      localErrMsg.setMessage(util.get_error_msg(paramInt));
      localErrMsg.setTitle(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_5));
    }
    int i = paramTransReqContext.get_subcmd();
    if (i != 5)
    {
      if (i != 12)
      {
        switch (i)
        {
        default: 
          return;
        case 8: 
          i = paramInt;
          if (paramInt == 0)
          {
            paramInt = new oicq.wlogin_sdk.devicelock.f().parse_rsp(paramTransReqContext.get_body());
            util.LOGI("CheckDevLockSms ret:".concat(String.valueOf(paramInt)), paramString);
            i = paramInt;
            if (paramInt != -1009)
            {
              tlvCommRsp2ErrMsg(localDevlockRst.commRsp, localErrMsg);
              i = paramInt;
            }
          }
          paramString = this.mListener;
          if (paramString == null) {
            break;
          }
          paramString.OnCheckDevLockSms(paramWUserSigInfo, i, localErrMsg);
          return;
        case 7: 
          i = paramInt;
          if (paramInt == 0)
          {
            paramInt = new oicq.wlogin_sdk.devicelock.d().parse_rsp(paramTransReqContext.get_body());
            util.LOGI("AskDevLockSms ret:".concat(String.valueOf(paramInt)), paramString);
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
          paramString = this.mListener;
          if (paramString == null) {
            break;
          }
          paramString.OnAskDevLockSms(paramWUserSigInfo, localDevlockInfo, i, localErrMsg);
          return;
        }
      }
      else
      {
        i = paramInt;
        if (paramInt == 0)
        {
          int j = new oicq.wlogin_sdk.devicelock.b().parse_rsp(paramTransReqContext.get_body());
          util.LOGI("CloseDevLock ret:".concat(String.valueOf(j)), paramString);
          i = j;
          if (j != -1009)
          {
            tlvCommRsp2ErrMsg(localDevlockRst.commRsp, localErrMsg);
            try
            {
              if (!util.check_uin_account(paramString).booleanValue()) {
                paramLong2 = this.mG.b(paramString);
              } else {
                paramLong2 = Long.parseLong(paramString);
              }
              this.mG.b(paramLong2, paramLong1);
              paramInt = 0;
              for (;;)
              {
                i = j;
                if (paramInt >= paramWUserSigInfo._tickets.size()) {
                  break;
                }
                if (((Ticket)paramWUserSigInfo._tickets.get(paramInt))._type == 33554432) {
                  paramWUserSigInfo._tickets.remove(paramInt);
                }
                paramInt += 1;
              }
              paramString = this.mListener;
            }
            catch (Exception paramString)
            {
              util.printException(paramString);
              i = j;
            }
          }
        }
        if (paramString != null) {
          paramString.OnCloseDevLock(paramWUserSigInfo, i, localErrMsg);
        }
      }
    }
    else
    {
      i = paramInt;
      if (paramInt == 0)
      {
        paramInt = new oicq.wlogin_sdk.devicelock.a().parse_rsp(paramTransReqContext.get_body());
        util.LOGI("CheckDevLockStatus ret:".concat(String.valueOf(paramInt)), paramString);
        i = paramInt;
        if (paramInt != -1009)
        {
          tlvCommRsp2ErrMsg(localDevlockRst.commRsp, localErrMsg);
          if ((localDevlockRst.devSetupInfo != null) && (localDevlockRst.devSetupInfo.get_data_len() > 0))
          {
            localDevlockInfo.DevSetup = localDevlockRst.devSetupInfo.a;
            localDevlockInfo.AllowSet = localDevlockRst.devSetupInfo.b;
            if ((localDevlockRst.devGuideInfo != null) && (localDevlockRst.devGuideInfo.get_data_len() > 0)) {
              localDevlockInfo.ProtectIntro = new String(localDevlockRst.devGuideInfo.a);
            } else {
              localDevlockInfo.ProtectIntro = new String(localDevlockRst.devSetupInfo.d);
            }
            localDevlockInfo.WarningInfo = new String(localDevlockRst.devSetupInfo.g);
            localDevlockInfo.WarningTitle = new String(localDevlockRst.devSetupInfo.e);
            localDevlockInfo.WarningMsg = new String(localDevlockRst.devSetupInfo.f);
            localDevlockInfo.WarningInfoType = localDevlockRst.devSetupInfo.c;
          }
          if ((localDevlockRst.mbMobileInfo != null) && (localDevlockRst.mbMobileInfo.get_data_len() > 0))
          {
            localDevlockInfo.CountryCode = new String(localDevlockRst.mbMobileInfo.a);
            localDevlockInfo.Mobile = new String(localDevlockRst.mbMobileInfo.b);
            localDevlockInfo.MbItemSmsCodeStatus = localDevlockRst.mbMobileInfo.c;
            localDevlockInfo.AvailableMsgCount = localDevlockRst.mbMobileInfo.d;
            localDevlockInfo.TimeLimit = localDevlockRst.mbMobileInfo.e;
          }
          if ((localDevlockRst.mbGuideInfo != null) && (localDevlockRst.mbGuideInfo.get_data_len() > 0))
          {
            localDevlockInfo.MbGuideType = localDevlockRst.mbGuideInfo.c;
            localDevlockInfo.MbGuideInfoType = localDevlockRst.mbGuideInfo.d;
            localDevlockInfo.MbGuideInfo = new String(localDevlockRst.mbGuideInfo.b);
            localDevlockInfo.MbGuideMsg = new String(localDevlockRst.mbGuideInfo.a);
          }
          i = paramInt;
          if (localDevlockRst.transferInfo != null)
          {
            i = paramInt;
            if (localDevlockRst.transferInfo.get_data_len() > 0)
            {
              localDevlockInfo.TransferInfo = localDevlockRst.transferInfo.get_data();
              i = paramInt;
            }
          }
        }
      }
      paramString = this.mListener;
      if (paramString != null)
      {
        paramString.OnCheckDevLockStatus(paramWUserSigInfo, localDevlockInfo, i, localErrMsg);
        return;
      }
    }
  }
  
  private void OnRequestCode2d(String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if (this.mListener == null)
    {
      util.LOGI("OnRequestCode2d mListener is null", paramString);
      return;
    }
    oicq.wlogin_sdk.code2d.d locald = oicq.wlogin_sdk.code2d.c._status;
    if (paramInt != 0) {
      util.LOGI("OnRequestCode2d ret:".concat(String.valueOf(paramInt)), paramString);
    }
    int i = paramTransReqContext.get_subcmd();
    if (i != 49)
    {
      switch (i)
      {
      default: 
        util.LOGW("OnRequestName unhandle cmd", "", paramString);
        this.mListener.OnException(new ErrMsg(), 9, paramWUserSigInfo);
        return;
      case 20: 
        if (paramInt != 0)
        {
          this.mListener.OnCloseCode(paramString, locald.d, locald.c, paramWUserSigInfo, locald.f, paramInt);
          return;
        }
        oicq.wlogin_sdk.code2d.b localb = new oicq.wlogin_sdk.code2d.b();
        if (paramWUserSigInfo == null) {
          paramWUserSigInfo = new WUserSigInfo();
        }
        locald.b = localb.a(paramTransReqContext.get_body(), paramLong1, u.u, paramWUserSigInfo.loginTLVMap);
        paramTransReqContext = new StringBuilder("CloseCode ret:");
        paramTransReqContext.append(locald.b);
        util.LOGI(paramTransReqContext.toString(), paramString);
        oicq.wlogin_sdk.code2d.d.t = false;
        this.mListener.OnCloseCode(paramString, locald.d, locald.c, paramWUserSigInfo, locald.f, locald.b);
        return;
      case 19: 
        if (paramInt != 0)
        {
          this.mListener.OnVerifyCode(paramString, locald.d, locald.c, locald.e, paramWUserSigInfo, locald.f, paramInt);
          return;
        }
        locald.b = new oicq.wlogin_sdk.code2d.f().a(paramTransReqContext.get_body());
        paramTransReqContext = new StringBuilder("VerifyCode ret:");
        paramTransReqContext.append(locald.b);
        util.LOGI(paramTransReqContext.toString(), paramString);
        if ((locald.b == 0) && (locald.g != null) && (locald.g.length > 0)) {
          this.mG.a(locald.a, paramLong1, locald.g);
        }
        this.mListener.OnVerifyCode(paramString, locald.d, locald.c, locald.e, paramWUserSigInfo, locald.f, locald.b);
        return;
      }
      if (paramInt == 0)
      {
        paramInt = new oicq.wlogin_sdk.code2d.e().a(paramTransReqContext.get_body());
        paramTransReqContext = new StringBuilder("QueryCodeResult ret:");
        paramTransReqContext.append(locald.b);
        util.LOGI(paramTransReqContext.toString(), paramString);
      }
      this.mListener.OnQueryCodeResult(locald.a, locald.e, locald.c, paramWUserSigInfo, locald.f, paramInt);
      return;
    }
    if (paramInt == 0) {
      paramInt = new fetch_code().get_response(paramTransReqContext.get_body());
    }
    paramTransReqContext = new StringBuilder("FetchCodeSig ret:");
    paramTransReqContext.append(locald.b);
    util.LOGI(paramTransReqContext.toString(), paramString);
    this.mListener.OnFetchCodeSig(locald.j, locald.k, locald.l, paramWUserSigInfo, locald.f, paramInt);
  }
  
  private void OnRequestRegister(String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if (this.mListener == null) {
      return;
    }
    Object localObject2 = InternationMsg.a(InternationMsg.MSG_TYPE.MSG_3);
    if (paramInt != 0)
    {
      paramString = this.mListener;
      if (paramString != null) {
        paramString.OnRegError(paramWUserSigInfo, paramInt, ((String)localObject2).getBytes());
      }
      return;
    }
    Object localObject1 = this.mRegStatus;
    paramInt = paramTransReqContext.get_subcmd();
    if (paramInt != 10)
    {
      if ((paramInt != 1749) && (paramInt != 2170) && (paramInt != 2172)) {}
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          localObject1 = new StringBuilder("OnRequestRegister unhandle cmd:");
          ((StringBuilder)localObject1).append(paramTransReqContext.get_subcmd());
          util.LOGW(((StringBuilder)localObject1).toString(), "", paramString);
          paramString = this.mListener;
          if (paramString == null) {
            break;
          }
          paramString.OnRegError(paramWUserSigInfo, -1010, ((String)localObject2).getBytes());
          return;
        case 17: 
          paramInt = oicq.wlogin_sdk.a.a.f(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.i)localObject1);
          if (paramInt != 0)
          {
            paramString = this.mListener;
            if (paramString != null) {
              paramString.OnRegError(paramWUserSigInfo, paramInt, ((String)localObject2).getBytes());
            }
          }
          paramString = new StringBuilder("reg cmd:");
          paramString.append(paramTransReqContext.get_subcmd());
          paramString.append(" ret:");
          paramString.append(((oicq.wlogin_sdk.a.i)localObject1).d);
          util.LOGI(paramString.toString(), "");
          paramWUserSigInfo.regTLVMap = ((oicq.wlogin_sdk.a.i)localObject1).C;
          ((oicq.wlogin_sdk.a.i)localObject1).C = new HashMap();
          this.mListener.OnQuickRegisterGetAccount(paramWUserSigInfo, ((oicq.wlogin_sdk.a.i)localObject1).d, ((oicq.wlogin_sdk.a.i)localObject1).f);
          return;
        case 16: 
          paramInt = oicq.wlogin_sdk.a.a.e(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.i)localObject1);
          if (paramInt != 0)
          {
            paramString = this.mListener;
            if (paramString != null) {
              paramString.OnRegError(paramWUserSigInfo, paramInt, ((String)localObject2).getBytes());
            }
          }
          paramString = new StringBuilder("reg cmd:");
          paramString.append(paramTransReqContext.get_subcmd());
          paramString.append(" ret:");
          paramString.append(((oicq.wlogin_sdk.a.i)localObject1).d);
          util.LOGI(paramString.toString(), "");
          this.mListener.OnQuickRegisterCheckAccount(paramWUserSigInfo, ((oicq.wlogin_sdk.a.i)localObject1).d, ((oicq.wlogin_sdk.a.i)localObject1).f);
          return;
        }
        break;
      case 7: 
        paramInt = oicq.wlogin_sdk.a.a.d(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.i)localObject1);
        if (paramInt != 0)
        {
          paramString = this.mListener;
          if (paramString != null) {
            paramString.OnRegError(paramWUserSigInfo, paramInt, ((String)localObject2).getBytes());
          }
          return;
        }
        paramString = new StringBuilder("reg cmd:");
        paramString.append(paramTransReqContext.get_subcmd());
        paramString.append(" ret:");
        paramString.append(((oicq.wlogin_sdk.a.i)localObject1).d);
        util.LOGI(paramString.toString(), "");
        paramString = this.mListener;
        if (paramString == null) {
          break;
        }
        paramString.OnRegQueryAccount(paramWUserSigInfo, ((oicq.wlogin_sdk.a.i)localObject1).d, ((oicq.wlogin_sdk.a.i)localObject1).f);
        return;
      case 6: 
        paramInt = oicq.wlogin_sdk.a.a.c(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.i)localObject1);
        if (paramInt != 0)
        {
          paramString = this.mListener;
          if (paramString == null) {
            break;
          }
          paramString.OnRegError(paramWUserSigInfo, paramInt, ((String)localObject2).getBytes());
          return;
        }
        paramWUserSigInfo.regTLVMap = ((oicq.wlogin_sdk.a.i)localObject1).C;
        ((oicq.wlogin_sdk.a.i)localObject1).C = new HashMap();
        paramString = new StringBuilder("reg cmd:");
        paramString.append(paramTransReqContext.get_subcmd());
        paramString.append(" ret:");
        paramString.append(((oicq.wlogin_sdk.a.i)localObject1).d);
        util.LOGI(paramString.toString(), "");
        if (this.mListener == null) {
          break;
        }
        if ((((oicq.wlogin_sdk.a.i)localObject1).b != null) && (((oicq.wlogin_sdk.a.i)localObject1).b.indexOf("-") > 0))
        {
          paramInt = ((oicq.wlogin_sdk.a.i)localObject1).b.indexOf("-");
          paramString = ((oicq.wlogin_sdk.a.i)localObject1).b.substring(0, paramInt);
          if (paramString.equals("86"))
          {
            ((oicq.wlogin_sdk.a.i)localObject1).b = ((oicq.wlogin_sdk.a.i)localObject1).b.substring(paramInt + 1);
          }
          else
          {
            paramTransReqContext = new StringBuilder("00");
            paramTransReqContext.append(paramString);
            paramTransReqContext.append(((oicq.wlogin_sdk.a.i)localObject1).b.substring(paramInt + 1));
            ((oicq.wlogin_sdk.a.i)localObject1).b = paramTransReqContext.toString();
          }
        }
        if ((((oicq.wlogin_sdk.a.i)localObject1).b != null) && (((oicq.wlogin_sdk.a.i)localObject1).b.length() != 0))
        {
          this.mG.d(((oicq.wlogin_sdk.a.i)localObject1).b);
          this.mG.a(((oicq.wlogin_sdk.a.i)localObject1).b, Long.valueOf(((oicq.wlogin_sdk.a.i)localObject1).v));
        }
        paramString = new StringBuilder("reg userAccount: ");
        paramString.append(((oicq.wlogin_sdk.a.i)localObject1).b);
        paramString = paramString.toString();
        paramTransReqContext = new StringBuilder();
        paramTransReqContext.append(((oicq.wlogin_sdk.a.i)localObject1).v);
        util.LOGI(paramString, paramTransReqContext.toString());
        if ((oicq.wlogin_sdk.a.i.A.length() > 0) && (oicq.wlogin_sdk.a.i.y))
        {
          this.mListener.OnRegGetSMSVerifyLoginAccount(paramWUserSigInfo, ((oicq.wlogin_sdk.a.i)localObject1).d, ((oicq.wlogin_sdk.a.i)localObject1).v, ((oicq.wlogin_sdk.a.i)localObject1).w, ((oicq.wlogin_sdk.a.i)localObject1).x, ((oicq.wlogin_sdk.a.i)localObject1).f);
          return;
        }
        this.mListener.OnRegGetAccount(paramWUserSigInfo, ((oicq.wlogin_sdk.a.i)localObject1).d, ((oicq.wlogin_sdk.a.i)localObject1).v, ((oicq.wlogin_sdk.a.i)localObject1).w, ((oicq.wlogin_sdk.a.i)localObject1).x, ((oicq.wlogin_sdk.a.i)localObject1).f);
        return;
      case 5: 
        paramInt = oicq.wlogin_sdk.a.a.b(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.i)localObject1);
        if (paramInt != 0)
        {
          paramString = this.mListener;
          if (paramString == null) {
            break;
          }
          paramString.OnRegError(paramWUserSigInfo, paramInt, ((String)localObject2).getBytes());
          return;
        }
        paramWUserSigInfo.regTLVMap = ((oicq.wlogin_sdk.a.i)localObject1).C;
        ((oicq.wlogin_sdk.a.i)localObject1).C = new HashMap();
        paramString = new StringBuilder("reg cmd:");
        paramString.append(paramTransReqContext.get_subcmd());
        paramString.append(" ret:");
        paramString.append(((oicq.wlogin_sdk.a.i)localObject1).d);
        util.LOGI(paramString.toString(), "");
        paramString = this.mListener;
        if (paramString == null) {
          break;
        }
        paramString.OnRegSubmitMsgChk(paramWUserSigInfo, ((oicq.wlogin_sdk.a.i)localObject1).d, ((oicq.wlogin_sdk.a.i)localObject1).f);
        return;
      case 4: 
        paramInt = oicq.wlogin_sdk.a.a.a(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.i)localObject1);
        if (paramInt != 0)
        {
          paramString = this.mListener;
          if (paramString == null) {
            break;
          }
          paramString.OnRegError(paramWUserSigInfo, paramInt, ((String)localObject2).getBytes());
          return;
        }
        localObject2 = new StringBuilder("reg cmd:");
        ((StringBuilder)localObject2).append(paramTransReqContext.get_subcmd());
        ((StringBuilder)localObject2).append(" ret:");
        ((StringBuilder)localObject2).append(((oicq.wlogin_sdk.a.i)localObject1).d);
        util.LOGI(((StringBuilder)localObject2).toString(), "");
        if (((oicq.wlogin_sdk.a.i)localObject1).d == 0)
        {
          paramString = this.mListener;
          if (paramString == null) {
            break;
          }
          paramString.OnRegRequestServerResendMsg(paramWUserSigInfo, ((oicq.wlogin_sdk.a.i)localObject1).d, ((oicq.wlogin_sdk.a.i)localObject1).t, ((oicq.wlogin_sdk.a.i)localObject1).u);
          return;
        }
        if (((oicq.wlogin_sdk.a.i)localObject1).d == 3)
        {
          paramString = this.mListener;
          if (paramString == null) {
            break;
          }
          paramString.OnRegCheckValidUrl(paramWUserSigInfo, ((oicq.wlogin_sdk.a.i)localObject1).r);
          return;
        }
        if (((oicq.wlogin_sdk.a.i)localObject1).d == 5)
        {
          paramString = this.mListener;
          if (paramString == null) {
            break;
          }
          paramString.OnRegRequestServerResendMsg(paramWUserSigInfo, ((oicq.wlogin_sdk.a.i)localObject1).d, ((oicq.wlogin_sdk.a.i)localObject1).t, ((oicq.wlogin_sdk.a.i)localObject1).u);
          return;
        }
        util.LOGW("OnRequestRegister 0x4 return code:", String.valueOf(((oicq.wlogin_sdk.a.i)localObject1).d), paramString);
        paramString = this.mListener;
        if (paramString == null) {
          break;
        }
        paramString.OnRegError(paramWUserSigInfo, ((oicq.wlogin_sdk.a.i)localObject1).d, ((oicq.wlogin_sdk.a.i)localObject1).f);
        return;
      case 3: 
        paramInt = oicq.wlogin_sdk.a.a.a(3, paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.i)localObject1);
        if (paramInt != 0)
        {
          paramString = this.mListener;
          if (paramString == null) {
            break;
          }
          paramString.OnRegError(paramWUserSigInfo, paramInt, ((String)localObject2).getBytes());
          return;
        }
        localObject2 = new StringBuilder("reg cmd:");
        ((StringBuilder)localObject2).append(paramTransReqContext.get_subcmd());
        ((StringBuilder)localObject2).append(" ret:");
        ((StringBuilder)localObject2).append(((oicq.wlogin_sdk.a.i)localObject1).d);
        util.LOGI(((StringBuilder)localObject2).toString(), "");
        if ((((oicq.wlogin_sdk.a.i)localObject1).d != 0) && (((oicq.wlogin_sdk.a.i)localObject1).d != 4) && (((oicq.wlogin_sdk.a.i)localObject1).d != 31) && (((oicq.wlogin_sdk.a.i)localObject1).d != 118))
        {
          if (((oicq.wlogin_sdk.a.i)localObject1).d == 3)
          {
            paramString = this.mListener;
            if (paramString == null) {
              break;
            }
            paramString.OnRegCheckValidUrl(paramWUserSigInfo, ((oicq.wlogin_sdk.a.i)localObject1).r);
            return;
          }
          util.LOGW("OnRequestRegister 0x3 return code:", String.valueOf(((oicq.wlogin_sdk.a.i)localObject1).d), paramString);
          paramString = this.mListener;
          if (paramString == null) {
            break;
          }
          paramString.OnRegError(paramWUserSigInfo, ((oicq.wlogin_sdk.a.i)localObject1).d, ((oicq.wlogin_sdk.a.i)localObject1).f);
          return;
        }
        if (((oicq.wlogin_sdk.a.i)localObject1).d == 0)
        {
          paramWUserSigInfo.regTLVMap = ((oicq.wlogin_sdk.a.i)localObject1).C;
          ((oicq.wlogin_sdk.a.i)localObject1).C = new HashMap();
        }
        this.mListener.OnRegQueryClientSentMsgStatus(paramWUserSigInfo, ((oicq.wlogin_sdk.a.i)localObject1).d, ((oicq.wlogin_sdk.a.i)localObject1).t, ((oicq.wlogin_sdk.a.i)localObject1).u, new String(((oicq.wlogin_sdk.a.i)localObject1).f));
        return;
        paramString = new StringBuilder("reg cmd:");
        paramString.append(paramTransReqContext.get_subcmd());
        util.LOGI(paramString.toString());
        this.mListener.onModifyQIMPassword(paramWUserSigInfo, paramTransReqContext.get_subcmd(), paramTransReqContext.get_body());
        return;
      }
    }
    else
    {
      paramInt = oicq.wlogin_sdk.a.a.a(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.i)localObject1);
      if (paramInt != 0)
      {
        paramString = this.mListener;
        if (paramString != null) {
          paramString.OnRegError(paramWUserSigInfo, paramInt, ((String)localObject2).getBytes());
        }
        return;
      }
      localObject2 = new StringBuilder("reg cmd:");
      ((StringBuilder)localObject2).append(paramTransReqContext.get_subcmd());
      ((StringBuilder)localObject2).append(" ret:");
      ((StringBuilder)localObject2).append(((oicq.wlogin_sdk.a.i)localObject1).d);
      util.LOGI(((StringBuilder)localObject2).toString(), "");
      if (((oicq.wlogin_sdk.a.i)localObject1).d == 0)
      {
        paramString = this.mListener;
        if (paramString != null) {
          paramString.OnRegCheckDownloadMsg(paramWUserSigInfo, ((oicq.wlogin_sdk.a.i)localObject1).m, ((oicq.wlogin_sdk.a.i)localObject1).n);
        }
      }
      else if (((oicq.wlogin_sdk.a.i)localObject1).d == 2)
      {
        paramString = this.mListener;
        if (paramString != null) {
          paramString.OnRegCheckUploadMsg(paramWUserSigInfo, new String(((oicq.wlogin_sdk.a.i)localObject1).q));
        }
      }
      else if (((oicq.wlogin_sdk.a.i)localObject1).d == 3)
      {
        paramString = this.mListener;
        if (paramString != null) {
          paramString.OnRegCheckValidUrl(paramWUserSigInfo, ((oicq.wlogin_sdk.a.i)localObject1).r);
        }
      }
      else
      {
        if ((((oicq.wlogin_sdk.a.i)localObject1).d == 6) || (((oicq.wlogin_sdk.a.i)localObject1).d == 44)) {
          break label2085;
        }
        if (((oicq.wlogin_sdk.a.i)localObject1).d == 51)
        {
          paramString = this.mListener;
          if (paramString != null) {
            paramString.OnGuaranteeCheckValidUrl(paramWUserSigInfo, ((oicq.wlogin_sdk.a.i)localObject1).r);
          }
        }
        else if (((oicq.wlogin_sdk.a.i)localObject1).d == 58)
        {
          paramString = this.mListener;
          if (paramString != null) {
            paramString.OnRegCheckIframe(paramWUserSigInfo, ((oicq.wlogin_sdk.a.i)localObject1).r, null);
          }
        }
        else if (((oicq.wlogin_sdk.a.i)localObject1).d == 59)
        {
          paramString = new StringBuilder("OnRegCheckError REG_CHECK_ERROR_FACE regSig= ");
          paramString.append(util.printByte(((oicq.wlogin_sdk.a.i)localObject1).s));
          util.LOGW(paramString.toString(), "");
          paramString = this.mListener;
          if (paramString != null) {
            paramString.OnRegError(paramWUserSigInfo, 59, ((oicq.wlogin_sdk.a.i)localObject1).s);
          }
        }
        else
        {
          util.LOGW("OnRequestRegister 0xa return code:", String.valueOf(((oicq.wlogin_sdk.a.i)localObject1).d), paramString);
          paramString = this.mListener;
          if (paramString != null)
          {
            paramString.OnRegError(paramWUserSigInfo, ((oicq.wlogin_sdk.a.i)localObject1).d, ((oicq.wlogin_sdk.a.i)localObject1).f);
            return;
          }
        }
      }
    }
    return;
    label2085:
    paramString = this.mListener;
    if (paramString != null) {
      paramString.OnRegCheckWebSig(paramWUserSigInfo, new String(((oicq.wlogin_sdk.a.i)localObject1).r), new String(((oicq.wlogin_sdk.a.i)localObject1).f));
    }
    ((oicq.wlogin_sdk.a.i)localObject1).r = new byte[0];
  }
  
  private int RefreshPictureData(String paramString, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if ((paramString != null) && (paramWUserSigInfo != null))
    {
      if (paramInt == 0)
      {
        new HelperThread(this, this.mHelperHandler, paramString, paramWUserSigInfo, "RefreshPictureData").RunReq(1);
        return -1001;
      }
      if (paramWUserSigInfo._seqence == 0L) {
        paramWUserSigInfo._seqence = this.mAysncSeq;
      }
      u localu = this.mG.a(paramWUserSigInfo._seqence);
      paramWUserSigInfo._seqence = localu.h;
      async_context localasync_context = u.b(localu.h);
      StringBuilder localStringBuilder = new StringBuilder("user:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" Seq:");
      localStringBuilder.append(localu.h);
      localStringBuilder.append(" RefreshPictureData ...");
      util.LOGI(localStringBuilder.toString(), String.valueOf(paramString));
      localu.g = paramString;
      localasync_context._last_err_msg = new ErrMsg();
      long l;
      if (!util.check_uin_account(paramString).booleanValue())
      {
        l = localu.b(paramString);
        if (l != 0L) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
      }
      else
      {
        l = Long.parseLong(paramString);
        paramInt = 1;
      }
      if (paramInt == 1) {
        localu.f = l;
      }
      int i = new s(localu).a(this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo);
      paramInt = i;
      if (i == 2) {
        paramInt = 0;
      }
      paramWUserSigInfo = new StringBuilder("user:");
      paramWUserSigInfo.append(paramString);
      paramWUserSigInfo.append(" Seq:");
      paramWUserSigInfo.append(localu.h);
      paramWUserSigInfo.append(" RefreshPictureData ret=");
      paramWUserSigInfo.append(paramInt);
      util.LOGI(paramWUserSigInfo.toString(), String.valueOf(paramString));
      return paramInt;
    }
    return -1017;
  }
  
  private int RefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramString != null) && (paramWUserSigInfo != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
      ((StringBuilder)localObject).append("RefreshSMSData _seqence:");
      ((StringBuilder)localObject).append(paramWUserSigInfo._seqence);
      ((StringBuilder)localObject).append(" mAysncSeq:");
      ((StringBuilder)localObject).append(this.mAysncSeq);
      util.LOGI(((StringBuilder)localObject).toString(), "");
      if (paramInt == 0)
      {
        new HelperThread(this, this.mHelperHandler, paramString, paramLong, paramWUserSigInfo, paramArrayOfByte, "RefreshSMSData").RunReq(3);
        return -1001;
      }
      if (paramWUserSigInfo._seqence == 0L) {
        paramWUserSigInfo._seqence = this.mAysncSeq;
      }
      localObject = this.mG.a(paramWUserSigInfo._seqence);
      paramWUserSigInfo._seqence = ((u)localObject).h;
      async_context localasync_context = u.b(((u)localObject).h);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
      localStringBuilder.append("RefreshSMSData user:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" smsAppid:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" Seq:");
      localStringBuilder.append(((u)localObject).h);
      localStringBuilder.append(" RefreshSMSData ...");
      util.LOGI(localStringBuilder.toString(), String.valueOf(paramString));
      ((u)localObject).g = paramString;
      localasync_context._last_err_msg = new ErrMsg();
      boolean bool = util.check_uin_account(paramString).booleanValue();
      int i = 0;
      long l;
      if (!bool)
      {
        l = ((u)localObject).b(paramString);
        if (l != 0L) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
      }
      else
      {
        l = Long.parseLong(paramString);
        paramInt = 1;
      }
      if (paramInt == 1) {
        ((u)localObject).f = l;
      }
      paramInt = new t((u)localObject).a(paramLong, this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo, paramArrayOfByte);
      if (paramInt == 160) {
        paramInt = i;
      }
      paramWUserSigInfo = new StringBuilder("user:");
      paramWUserSigInfo.append(paramString);
      paramWUserSigInfo.append(" smsAppid:");
      paramWUserSigInfo.append(paramLong);
      paramWUserSigInfo.append(" Seq:");
      paramWUserSigInfo.append(((u)localObject).h);
      paramWUserSigInfo.append(" RefreshSMSData ret=");
      paramWUserSigInfo.append(paramInt);
      util.LOGI(paramWUserSigInfo.toString(), String.valueOf(paramString));
      return paramInt;
    }
    return -1017;
  }
  
  private int RefreshSMSVerifyLoginCode(String paramString, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramInt == 0)
      {
        new HelperThread(this, this.mHelperHandler, paramString, paramWUserSigInfo, "RefreshSMSVerifyLoginCode").RunReq(14);
        return -1001;
      }
      if (paramWUserSigInfo._seqence == 0L) {
        paramWUserSigInfo._seqence = this.mAysncSeq;
      }
      u localu = this.mG.a(paramWUserSigInfo._seqence);
      paramWUserSigInfo._seqence = localu.h;
      Object localObject = u.b(localu.h);
      StringBuilder localStringBuilder = new StringBuilder("user:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" Seq:");
      localStringBuilder.append(localu.h);
      localStringBuilder.append(" RefreshSMSVerifyLoginCode ...");
      util.LOGI(localStringBuilder.toString(), paramString);
      localu.g = paramString;
      ((async_context)localObject)._last_err_msg = new ErrMsg();
      paramInt = new z(localu).a(this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
      localObject = new StringBuilder("user:");
      ((StringBuilder)localObject).append(localu.g);
      ((StringBuilder)localObject).append(" Seq:");
      ((StringBuilder)localObject).append(localu.h);
      ((StringBuilder)localObject).append(" RefreshSMSVerifyLoginCode ret=");
      if (paramInt > 0) {
        paramWUserSigInfo = Integer.toHexString(paramInt);
      } else {
        paramWUserSigInfo = Integer.valueOf(paramInt);
      }
      ((StringBuilder)localObject).append(paramWUserSigInfo);
      util.LOGI(((StringBuilder)localObject).toString(), paramString);
      return paramInt;
    }
    return -1017;
  }
  
  private int RegSubmitMobile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo, Map<String, Object> paramMap)
  {
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0) && (paramArrayOfByte4 != null))
    {
      if (paramArrayOfByte1 == null) {
        paramArrayOfByte3 = new byte[0];
      } else {
        paramArrayOfByte3 = paramArrayOfByte1;
      }
      byte[] arrayOfByte = u.F;
      paramArrayOfByte1 = new byte[0];
      Object localObject = GetLastLoginInfo();
      long l;
      if (localObject != null)
      {
        l = ((WloginLastLoginInfo)localObject).mUin;
        localObject = GetLocalTicket(((WloginLastLoginInfo)localObject).mAccount, paramLong1, 64);
        if ((localObject != null) && (((Ticket)localObject)._sig != null)) {
          paramArrayOfByte1 = ((Ticket)localObject)._sig;
        }
      }
      else
      {
        l = 0L;
      }
      localObject = new StringBuilder("has uin? ");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(", a2: ");
      ((StringBuilder)localObject).append(paramArrayOfByte1.length);
      util.LOGI(((StringBuilder)localObject).toString());
      localObject = new StringBuilder("RegSubmitMobile mobile ...");
      ((StringBuilder)localObject).append(new String(paramArrayOfByte2));
      ((StringBuilder)localObject).append(" appname: ");
      ((StringBuilder)localObject).append(new String(arrayOfByte));
      ((StringBuilder)localObject).append("...");
      util.LOGI(((StringBuilder)localObject).toString(), "");
      this.mRegStatus.c = new String(paramArrayOfByte2);
      localObject = new oicq.wlogin_sdk.a.f();
      TransReqContext localTransReqContext = new TransReqContext();
      oicq.wlogin_sdk.a.i locali = this.mRegStatus;
      locali.k = paramArrayOfByte2;
      locali.g = paramLong1;
      locali.h = paramLong2;
      localTransReqContext.set_register_req();
      localTransReqContext.set_subcmd(((oicq.wlogin_sdk.a.f)localObject).a());
      localTransReqContext._body = ((oicq.wlogin_sdk.a.f)localObject).a(paramArrayOfByte2, arrayOfByte, paramArrayOfByte4, paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, null, util.generateGuid(this.mContext), util.get_IMSI(this.mContext), u.ad, l, paramArrayOfByte1, GetGuid(), paramArrayOfByte3, paramWUserSigInfo.extraRegTLVMap, paramMap);
      return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.i.i, localTransReqContext, paramWUserSigInfo);
    }
    return -1017;
  }
  
  private void RequestInit()
  {
    try
    {
      u.d();
      ShareKeyInit();
      AsyncGenRSAKey();
      Object localObject1 = u.B;
      localObject1 = util.buf_to_string((byte[])localObject1, localObject1.length);
      ByteData.getInstance().processFilterSwitch(true, "com.tencent.mobileqq:msf");
      ByteData.getInstance().init(this.mContext, "1", (String)localObject1, "", "init", "6.0.0.2484");
      ByteData.getInstance().setData("init");
      try
      {
        localObject1 = u.m();
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).endsWith(":MSF")))
        {
          oicq.wlogin_sdk.tools.d.a().a(this.mG);
          oicq.wlogin_sdk.tools.d.a().b();
        }
      }
      catch (Throwable localThrowable)
      {
        util.printThrowable(localThrowable, "RequestInit");
      }
      return;
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
    u localu = this.mG.a(0L);
    localu.f = paramLong1;
    StringBuilder localStringBuilder = new StringBuilder("user:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" appid:");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(" Seq:");
    localStringBuilder.append(localu.h);
    localStringBuilder.append(" RequestReport...");
    util.LOGI(localStringBuilder.toString(), String.valueOf(paramLong1));
    paramInt = new ac(localu).a(paramLong1, null, paramArrayOfByte1, paramArrayOfByte2, paramLong2, new WUserSigInfo());
    localu.j();
    paramArrayOfByte1 = new StringBuilder("user:");
    paramArrayOfByte1.append(paramLong1);
    paramArrayOfByte1.append(" appid:");
    paramArrayOfByte1.append(paramLong2);
    paramArrayOfByte1.append(" Seq:");
    paramArrayOfByte1.append(localu.h);
    paramArrayOfByte1.append(" RequestReport ret=");
    paramArrayOfByte1.append(paramInt);
    util.LOGI(paramArrayOfByte1.toString(), String.valueOf(paramLong1));
    return paramInt;
  }
  
  private int RequestReportError(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramArrayOfByte1, paramArrayOfByte2, paramLong1, paramLong2, paramInt2, "RequestReportError").RunReq(8);
      return -1001;
    }
    u localu = this.mG.a(0L);
    localu.d = this.mG.d;
    localu.f = paramLong1;
    StringBuilder localStringBuilder = new StringBuilder("user:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" appid:");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(" Seq:");
    localStringBuilder.append(localu.h);
    localStringBuilder.append(" RequestReportError...");
    util.LOGI(localStringBuilder.toString(), String.valueOf(paramLong1));
    paramInt1 = new x(localu).a(paramLong1, null, paramArrayOfByte1, paramArrayOfByte2, paramLong2, paramInt2);
    paramArrayOfByte1 = new StringBuilder("user:");
    paramArrayOfByte1.append(paramLong1);
    paramArrayOfByte1.append(" appid:");
    paramArrayOfByte1.append(paramLong2);
    paramArrayOfByte1.append(" Seq:");
    paramArrayOfByte1.append(localu.h);
    paramArrayOfByte1.append(" RequestReportError ret=");
    paramArrayOfByte1.append(paramInt1);
    util.LOGI(paramArrayOfByte1.toString(), String.valueOf(paramLong1));
    return paramInt1;
  }
  
  public static void SetWatchQQLicense(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte)
  {
    setExtraProductLoginTlvValue(paramWUserSigInfo, 1322, paramArrayOfByte);
    setExtraRegTlvValue(paramWUserSigInfo, 38, paramArrayOfByte);
  }
  
  private int ShareKeyInit()
  {
    util.LOGI("start ShareKeyInit", "");
    EcdhCrypt localEcdhCrypt = new EcdhCrypt(this.mContext);
    if (this.isForLocal) {
      return localEcdhCrypt.initShareKeyByDefault();
    }
    try
    {
      Pair localPair = oicq.wlogin_sdk.tools.d.a().c();
      if (localPair != null) {
        localEcdhCrypt.setPubKey((String)localPair.first, ((Integer)localPair.second).intValue());
      }
    }
    catch (Throwable localThrowable)
    {
      util.printThrowable(localThrowable, "ShareKeyInit");
    }
    int i = util.getInitKeyTime(this.mContext);
    if (i > 3)
    {
      i = localEcdhCrypt.initShareKeyByDefault();
    }
    else
    {
      util.saveInitKeyTime(this.mContext, i + 1);
      int j = localEcdhCrypt.initShareKey();
      i = j;
      if (j == 0)
      {
        util.saveInitKeyTime(this.mContext, 0);
        i = j;
      }
    }
    util.LOGI("end ShareKeyInit", "");
    this.mG.n = localEcdhCrypt.get_c_pub_key();
    this.mG.p = localEcdhCrypt.get_g_share_key();
    this.mG.r = localEcdhCrypt.get_pub_key_ver();
    return i;
  }
  
  private int VerifySMSVerifyLoginCode(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null) && (paramString2.length() != 0))
    {
      if (paramInt == 0)
      {
        new HelperThread(this, this.mHelperHandler, paramString1, paramString2, paramWUserSigInfo, "VerifySMSVerifyLoginCode").RunReq(13);
        return -1001;
      }
      if (paramWUserSigInfo._seqence == 0L) {
        paramWUserSigInfo._seqence = this.mAysncSeq;
      }
      u localu = this.mG.a(paramWUserSigInfo._seqence);
      paramWUserSigInfo._seqence = localu.h;
      async_context localasync_context = u.b(localu.h);
      StringBuilder localStringBuilder = new StringBuilder("user:");
      localStringBuilder.append(localu.g);
      localStringBuilder.append(" code:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" Seq:");
      localStringBuilder.append(localu.h);
      localStringBuilder.append(" VerifySMSVerifyLoginCode ...");
      util.LOGI(localStringBuilder.toString(), paramString1);
      localu.g = paramString1;
      localasync_context._last_err_msg = new ErrMsg();
      localasync_context._mpasswd = util.get_mpasswd();
      paramInt = new aa(localu).a(paramString2, this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
      paramWUserSigInfo = new StringBuilder("user:");
      paramWUserSigInfo.append(paramString1);
      paramWUserSigInfo.append(" code:");
      paramWUserSigInfo.append(paramString2);
      paramWUserSigInfo.append(" Seq:");
      paramWUserSigInfo.append(localu.h);
      paramWUserSigInfo.append(" VerifySMSVerifyLoginAccount ret=");
      if (paramInt > 0) {
        paramString2 = Integer.toHexString(paramInt);
      } else {
        paramString2 = Integer.valueOf(paramInt);
      }
      paramWUserSigInfo.append(paramString2);
      util.LOGI(paramWUserSigInfo.toString(), paramString1);
      return paramInt;
    }
    return -1017;
  }
  
  public static void customizeLogDir(String paramString)
  {
    u.az = paramString;
    util.LOGI("set log dir ".concat(String.valueOf(paramString)), "");
  }
  
  private A1AndNopicSig getA1AndNopicSigByAccount(String paramString, long paramLong)
  {
    A1AndNopicSig localA1AndNopicSig = new A1AndNopicSig(null);
    StringBuffer localStringBuffer = new StringBuffer("getA1AndNopicSigByAccount,userAccount=");
    localStringBuffer.append(paramString);
    paramString = getSigInfo(paramString, paramLong);
    if (paramString != null)
    {
      if ((paramString._en_A1 != null) && (paramString._en_A1.length > 0))
      {
        localA1AndNopicSig.a1 = ((byte[])paramString._en_A1.clone());
        localStringBuffer.append(",a1=");
        localStringBuffer.append(localA1AndNopicSig.a1.length);
      }
      else
      {
        localStringBuffer.append(",a1=null");
      }
      if ((paramString._noPicSig != null) && (paramString._noPicSig.length > 0))
      {
        localA1AndNopicSig.noPicSig = ((byte[])paramString._noPicSig.clone());
        localStringBuffer.append(",noPicSig=");
        localStringBuffer.append(localA1AndNopicSig.noPicSig.length);
      }
      else
      {
        localStringBuffer.append(",noPicSig=null");
      }
    }
    else
    {
      localStringBuffer.append(",info == null");
    }
    util.LOGI(localStringBuffer.toString(), "");
    return localA1AndNopicSig;
  }
  
  public static byte[] getLoginResultData(WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    paramWUserSigInfo = (tlv_t)paramWUserSigInfo.loginResultTLVMap.get(Integer.valueOf(paramInt));
    if (paramWUserSigInfo != null) {
      return paramWUserSigInfo.get_data();
    }
    return null;
  }
  
  public static String getLoginResultField(WUserSigInfo paramWUserSigInfo)
  {
    Object localObject = (tlv_t)paramWUserSigInfo.loginResultTLVMap.get(Integer.valueOf(1320));
    if (localObject != null)
    {
      localObject = new String(((tlv_t)localObject).get_data());
      util.LOGI("getLoginResultField get str ".concat(String.valueOf(localObject)), paramWUserSigInfo.uin);
      return localObject;
    }
    util.LOGI("getLoginResultField get null", paramWUserSigInfo.uin);
    return "";
  }
  
  public static String getLoginResultField_S(WUserSigInfo paramWUserSigInfo)
  {
    Object localObject = (tlv_t)paramWUserSigInfo.loginResultTLVMap.get(Integer.valueOf(1328));
    if (localObject != null)
    {
      localObject = new String(((tlv_t)localObject).get_data());
      util.LOGI("getLoginResultField2 get str ".concat(String.valueOf(localObject)), paramWUserSigInfo.uin);
      return localObject;
    }
    util.LOGI("getLoginResultField2 get null", paramWUserSigInfo.uin);
    return "";
  }
  
  public static byte[] getLoginTlvValue(WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    paramWUserSigInfo = (tlv_t)paramWUserSigInfo.loginTLVMap.get(Integer.valueOf(paramInt));
    if (paramWUserSigInfo != null) {
      return paramWUserSigInfo.get_data();
    }
    return null;
  }
  
  public static byte[] getRegTlvValue(WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    paramWUserSigInfo = (tlv_t)paramWUserSigInfo.regTLVMap.get(Integer.valueOf(paramInt));
    if (paramWUserSigInfo != null) {
      return paramWUserSigInfo.get_data();
    }
    return null;
  }
  
  private WloginSigInfo getSigInfo(String paramString, long paramLong)
  {
    if (paramString == null) {
      return null;
    }
    long l1;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      long l2 = this.mG.b(paramString);
      l1 = l2;
      if (l2 == 0L) {
        return null;
      }
    }
    else
    {
      l1 = Long.parseLong(paramString);
    }
    return this.mG.a(l1, paramLong);
  }
  
  private int getStWithPtSig(String paramString1, String paramString2, QuickLoginParam paramQuickLoginParam)
  {
    return getStWithPtSig(paramString1, paramString2, paramQuickLoginParam, 0);
  }
  
  private int getStWithPtSig(String paramString1, String paramString2, QuickLoginParam paramQuickLoginParam, int paramInt)
  {
    if (paramInt == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramString1, paramString2, paramQuickLoginParam, "getStWithPtSig").RunReq(16);
      return -1001;
    }
    WUserSigInfo localWUserSigInfo = paramQuickLoginParam.userSigInfo;
    localWUserSigInfo.uin = paramString1;
    u localu = this.mG.a(0L);
    localu.f = Long.parseLong(paramString1);
    localu.g = paramQuickLoginParam.userAccount;
    localWUserSigInfo._seqence = localu.h;
    this.mAysncSeq = localu.h;
    async_context localasync_context = u.b(localu.h);
    Object localObject = new StringBuilder("getStWithPtSig seq:");
    ((StringBuilder)localObject).append(localu.h);
    util.LOGI(((StringBuilder)localObject).toString(), paramString1);
    localasync_context._last_err_msg = new ErrMsg();
    paramQuickLoginParam.sigMap |= 0xC0;
    localasync_context._mpasswd = util.get_mpasswd();
    localasync_context._msalt = util.constructSalt();
    localasync_context._sappid = paramQuickLoginParam.appid;
    localasync_context._appid = paramQuickLoginParam.appid;
    localasync_context._sub_appid = paramQuickLoginParam.subAppid;
    localasync_context._main_sigmap = paramQuickLoginParam.sigMap;
    localasync_context._sub_appid_list = paramQuickLoginParam.dstSubAppidList;
    paramInt = new d(localu, paramString2).a(this.mMiscBitmap, this.mSubSigMap, localWUserSigInfo);
    if (paramInt != 0)
    {
      paramString2 = new StringBuilder("VerifyPTSig seq ");
      paramString2.append(localu.h);
      paramString2.append(" ret ");
      paramString2.append(paramInt);
      util.LOGI(paramString2.toString(), paramString1);
      return paramInt;
    }
    localasync_context._tmp_pwd = MD5.toMD5Byte(localasync_context._mpasswd.getBytes());
    paramString2 = new m(localu, this.mContext);
    paramString2.g();
    paramInt = paramString2.a(paramQuickLoginParam.appid, paramQuickLoginParam.subAppid, localu.f, 0, u.ag, util.getRequestInitTime(), localasync_context._tmp_pwd, 4, this.mMiscBitmap, this.mSubSigMap, paramQuickLoginParam.dstSubAppidList, paramQuickLoginParam.sigMap, paramQuickLoginParam.subAppid, u.z, 0, 0, 1, u.ad, localWUserSigInfo);
    if (paramInt == 204) {
      paramInt = new r(localu).a(this.mMiscBitmap, this.mSubSigMap, paramQuickLoginParam.dstSubAppidList, localWUserSigInfo);
    }
    if (paramInt != 0)
    {
      paramString2 = new StringBuilder("getStWithPtSig seq:");
      paramString2.append(localu.h);
      paramString2.append(" ret:");
      paramString2.append(paramInt);
      util.LOGI(paramString2.toString(), paramString1);
      return paramInt;
    }
    paramString2 = localu.a(localu.f, paramQuickLoginParam.appid);
    if (paramString2 == null) {
      return -1004;
    }
    localWUserSigInfo.get_clone(paramString2);
    int i;
    if (paramQuickLoginParam.dstSubAppidList != null)
    {
      localWUserSigInfo.stList = new byte[paramQuickLoginParam.dstSubAppidList.length * 2][];
      i = 0;
      while (i < paramQuickLoginParam.dstSubAppidList.length)
      {
        paramString2 = localu.a(localu.f, paramQuickLoginParam.dstSubAppidList[i]);
        if (paramString2 != null)
        {
          localObject = localWUserSigInfo.stList;
          int j = i * 2;
          localObject[j] = ((byte[])paramString2._userSt_Key.clone());
          localWUserSigInfo.stList[(j + 1)] = ((byte[])paramString2._userStSig.clone());
        }
        i += 1;
      }
    }
    paramString2 = GetUserSigInfoTicket(localWUserSigInfo, 128);
    if (paramString2 == null) {
      paramString2 = new Ticket();
    }
    u.at.commit_t2(localu.f, localu.g, util.format_ret_code(paramInt), paramInt);
    if (paramInt == 0)
    {
      if ((paramString2._sig != null) && (paramString2._sig.length != 0)) {
        RequestReport(0, paramString2._sig, paramString2._sig_key, localu.f, localasync_context._appid);
      }
    }
    else
    {
      i = paramInt;
      paramQuickLoginParam = paramString2;
      if ((i != 2) && (i != 160)) {
        RequestReportError(0, paramQuickLoginParam._sig, paramQuickLoginParam._sig_key, localu.f, localasync_context._appid, 0);
      }
    }
    if ((localu.d != null) && (localu.d.get_bitmap() != 0))
    {
      this.mG.d = localu.d;
      RequestReportError(0, paramString2._sig, paramString2._sig_key, localu.f, localasync_context._appid, 1);
    }
    oicq.wlogin_sdk.report.c.a();
    u.b();
    localu.i();
    paramString2 = new StringBuilder("getStWithPtSig seq:");
    paramString2.append(localu.h);
    paramString2.append(" ret ");
    paramString2.append(paramInt);
    util.LOGI(paramString2.toString(), paramString1);
    return paramInt;
  }
  
  private int getStWithQQSig(String paramString, QuickLoginParam paramQuickLoginParam)
  {
    return getStWithQQSig(paramString, paramQuickLoginParam, 0);
  }
  
  private int getStWithQQSig(String paramString, QuickLoginParam paramQuickLoginParam, int paramInt)
  {
    if (paramInt == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramString, paramQuickLoginParam, "getStWithQQSig").RunReq(15);
      return -1001;
    }
    Object localObject1 = paramQuickLoginParam.userSigInfo;
    ((WUserSigInfo)localObject1).uin = paramString;
    u localu = this.mG.a(0L);
    ((WUserSigInfo)localObject1)._seqence = localu.h;
    this.mAysncSeq = localu.h;
    async_context localasync_context = u.b(localu.h);
    paramInt = util.get_saved_network_type(this.mContext);
    u.E = util.get_network_type(this.mContext);
    int j = u.E;
    int i = 0;
    if (paramInt != j)
    {
      util.set_net_retry_type(this.mContext, 0);
      util.save_network_type(this.mContext, u.E);
    }
    u.G = util.get_apn_string(this.mContext).getBytes();
    paramQuickLoginParam.sigMap |= 0xC0;
    localu.g = paramString;
    localu.f = Long.parseLong(paramString);
    localasync_context._sappid = paramQuickLoginParam.appid;
    localasync_context._appid = paramQuickLoginParam.appid;
    localasync_context._sub_appid = paramQuickLoginParam.subAppid;
    localasync_context._main_sigmap = paramQuickLoginParam.sigMap;
    localasync_context._login_bitmap = ((WUserSigInfo)localObject1)._login_bitmap;
    localasync_context._last_err_msg = new ErrMsg();
    if (paramQuickLoginParam.dstSubAppidList != null) {
      localasync_context._sub_appid_list = ((long[])paramQuickLoginParam.dstSubAppidList.clone());
    } else {
      localasync_context._sub_appid_list = null;
    }
    Object localObject2;
    if ((((WUserSigInfo)localObject1)._reserveData != null) && (((WUserSigInfo)localObject1)._reserveData.length > 3))
    {
      localu.i = util.buf_to_int32(((WUserSigInfo)localObject1)._reserveData, 0);
      localObject2 = new StringBuilder("getStWithQQSig MSF SSO SEQ:");
      ((StringBuilder)localObject2).append(localu.i);
      util.LOGI(((StringBuilder)localObject2).toString(), paramString);
    }
    else
    {
      localu.i = 0;
    }
    if ((((WUserSigInfo)localObject1)._fastLoginBuf != null) && (((WUserSigInfo)localObject1)._fastLoginBuf.length != 0))
    {
      if (GetFastLoginInfo(((WUserSigInfo)localObject1)._fastLoginBuf, localasync_context) < 0)
      {
        paramQuickLoginParam = new StringBuilder("getStWithQQSig GetFastLoginInfo fast login buff is failed seq:");
        paramQuickLoginParam.append(localu.i);
        util.LOGI(paramQuickLoginParam.toString(), paramString);
        return -1017;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getStWithQQSig quickLoginParam appid=");
      ((StringBuilder)localObject2).append(paramQuickLoginParam.appid);
      ((StringBuilder)localObject2).append("|subAppid=");
      ((StringBuilder)localObject2).append(paramQuickLoginParam.subAppid);
      util.LOGI(((StringBuilder)localObject2).toString(), paramString);
      localObject2 = new m(localu, this.mContext);
      ((m)localObject2).g();
      paramInt = ((m)localObject2).a(paramQuickLoginParam.appid, paramQuickLoginParam.subAppid, localu.f, 0, u.ag, localasync_context._tmp_pwd, localasync_context._tmp_no_pic_sig, this.mMiscBitmap, this.mSubSigMap, paramQuickLoginParam.dstSubAppidList, paramQuickLoginParam.sigMap, paramQuickLoginParam.subAppid, u.z, 0, 0, 1, u.ad, (WUserSigInfo)localObject1);
      if (paramInt == 204) {
        paramInt = new r(localu).a(this.mMiscBitmap, this.mSubSigMap, paramQuickLoginParam.dstSubAppidList, (WUserSigInfo)localObject1);
      }
      if (paramInt != 0)
      {
        paramQuickLoginParam = new StringBuilder("getStWithQQSig error seq:");
        paramQuickLoginParam.append(localu.h);
        paramQuickLoginParam.append(" ret:");
        paramQuickLoginParam.append(paramInt);
        util.LOGI(paramQuickLoginParam.toString(), paramString);
        return paramInt;
      }
      localObject2 = localu.a(localu.f, paramQuickLoginParam.appid);
      if (localObject2 == null)
      {
        util.LOGI("getStWithQQSig get_siginfo return null", paramString);
        return -1004;
      }
      ((WUserSigInfo)localObject1).get_clone((WloginSigInfo)localObject2);
      if (paramQuickLoginParam.dstSubAppidList != null)
      {
        ((WUserSigInfo)localObject1).stList = new byte[paramQuickLoginParam.dstSubAppidList.length * 2][];
        while (i < paramQuickLoginParam.dstSubAppidList.length)
        {
          localObject2 = localu.a(localu.f, paramQuickLoginParam.dstSubAppidList[i]);
          if (localObject2 != null)
          {
            byte[][] arrayOfByte = ((WUserSigInfo)localObject1).stList;
            j = i * 2;
            arrayOfByte[j] = ((byte[])((WloginSigInfo)localObject2)._userSt_Key.clone());
            ((WUserSigInfo)localObject1).stList[(j + 1)] = ((byte[])((WloginSigInfo)localObject2)._userStSig.clone());
          }
          i += 1;
        }
      }
      paramQuickLoginParam = GetUserSigInfoTicket((WUserSigInfo)localObject1, 128);
      if (paramQuickLoginParam == null) {
        paramQuickLoginParam = new Ticket();
      }
      u.at.commit_t2(localu.f, localu.g, util.format_ret_code(paramInt), paramInt);
      if (paramInt == 0)
      {
        if ((paramQuickLoginParam._sig != null) && (paramQuickLoginParam._sig.length != 0)) {
          RequestReport(0, paramQuickLoginParam._sig, paramQuickLoginParam._sig_key, localu.f, localasync_context._appid);
        }
      }
      else
      {
        localObject1 = paramQuickLoginParam;
        i = paramInt;
        if ((i != 2) && (i != 160)) {
          RequestReportError(0, ((Ticket)localObject1)._sig, ((Ticket)localObject1)._sig_key, localu.f, localasync_context._appid, 0);
        }
      }
      if ((localu.d != null) && (localu.d.get_bitmap() != 0))
      {
        this.mG.d = localu.d;
        RequestReportError(0, paramQuickLoginParam._sig, paramQuickLoginParam._sig_key, localu.f, localasync_context._appid, 1);
      }
      oicq.wlogin_sdk.report.c.a();
      u.b();
      localu.i();
      paramQuickLoginParam = new StringBuilder("getStWithQQSig seq:");
      paramQuickLoginParam.append(localu.h);
      paramQuickLoginParam.append(" ret:");
      paramQuickLoginParam.append(paramInt);
      util.LOGI(paramQuickLoginParam.toString(), paramString);
      return paramInt;
    }
    paramQuickLoginParam = new StringBuilder("getStWithQQSig fast login buff is null seq:");
    paramQuickLoginParam.append(localu.i);
    util.LOGI(paramQuickLoginParam.toString(), paramString);
    return -1017;
  }
  
  private int getStWithQrSig(String paramString, long paramLong1, long paramLong2, int paramInt1, WUserSigInfo paramWUserSigInfo, int paramInt2)
  {
    if (paramString != null)
    {
      if (paramWUserSigInfo == null) {
        return -1017;
      }
      int i = paramInt1 | 0xC0;
      if (paramInt2 == 0)
      {
        new HelperThread(this, this.mHelperHandler, paramString, paramLong1, i, paramLong2, paramWUserSigInfo, "getStWithQrSig").RunReq(17);
        return -1001;
      }
      u localu = this.mG.a(0L);
      paramWUserSigInfo._seqence = localu.h;
      this.mAysncSeq = localu.h;
      oicq.wlogin_sdk.a.i.A = "";
      async_context localasync_context = u.b(localu.h);
      Object localObject1 = new StringBuilder("start getStWithQrSig:user:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" appid:");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(" sigMap:0x");
      ((StringBuilder)localObject1).append(Integer.toHexString(i));
      ((StringBuilder)localObject1).append(" subAppid:");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append(" Seq:");
      ((StringBuilder)localObject1).append(localu.h);
      util.LOGI(((StringBuilder)localObject1).toString(), paramString);
      paramInt1 = util.get_saved_network_type(this.mContext);
      u.E = util.get_network_type(this.mContext);
      if (paramInt1 != u.E)
      {
        util.set_net_retry_type(this.mContext, 0);
        util.save_network_type(this.mContext, u.E);
      }
      u.G = util.get_apn_string(this.mContext).getBytes();
      if (!util.check_uin_account(paramString).booleanValue())
      {
        paramWUserSigInfo = new StringBuilder("userAccount ");
        paramWUserSigInfo.append(paramString);
        paramWUserSigInfo.append(" isn't valid");
        util.LOGI(paramWUserSigInfo.toString(), "");
        return -1017;
      }
      long l = Long.parseLong(paramString);
      paramWUserSigInfo.uin = paramString;
      localu.g = paramString;
      localu.f = l;
      localasync_context._sappid = paramLong1;
      localasync_context._appid = paramLong1;
      localasync_context._sub_appid_list = null;
      localasync_context._sub_appid = paramLong2;
      localasync_context._main_sigmap = i;
      localasync_context._login_bitmap = paramWUserSigInfo._login_bitmap;
      localasync_context._last_err_msg = new ErrMsg();
      if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
      {
        localu.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
        localObject1 = new StringBuilder("MSF SSO SEQ:");
        ((StringBuilder)localObject1).append(localu.i);
        util.LOGI(((StringBuilder)localObject1).toString(), paramString);
      }
      else
      {
        localu.i = 0;
      }
      u.at.add_t2(new report_t2("login", new String(u.D), System.currentTimeMillis(), paramLong1, paramLong2, null));
      if ((oicq.wlogin_sdk.code2d.d.q != null) && (oicq.wlogin_sdk.code2d.d.q.length > 0))
      {
        localasync_context._tmp_pwd = oicq.wlogin_sdk.code2d.d.q;
        localasync_context._tmp_no_pic_sig = oicq.wlogin_sdk.code2d.d.r;
        if ((localasync_context._tmp_no_pic_sig != null) && (localasync_context._tmp_no_pic_sig.length != 0))
        {
          localObject1 = new StringBuilder("no pic sig length ");
          ((StringBuilder)localObject1).append(localasync_context._tmp_no_pic_sig.length);
          util.LOGI(((StringBuilder)localObject1).toString(), paramString);
        }
        else
        {
          util.LOGI("no pic sig length is 0", paramString);
        }
        localasync_context.tgtQR = oicq.wlogin_sdk.code2d.d.s;
        oicq.wlogin_sdk.code2d.d.q = null;
        oicq.wlogin_sdk.code2d.d.r = null;
        oicq.wlogin_sdk.code2d.d.s = null;
      }
      if ((localasync_context._tmp_pwd != null) && (localasync_context._tmp_pwd.length >= 16))
      {
        localasync_context._tmp_pwd_type = 1;
        if ((paramWUserSigInfo._in_ksid != null) && (paramWUserSigInfo._in_ksid.length > 0)) {
          localObject1 = (byte[])paramWUserSigInfo._in_ksid.clone();
        } else {
          localObject1 = u.ad;
        }
        if (localasync_context._tmp_pwd_type != 0)
        {
          Object localObject2 = new StringBuilder("user:");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(" login with qrsig");
          util.LOGI(((StringBuilder)localObject2).toString(), paramString);
          localObject2 = new m(localu, this.mContext);
          ((m)localObject2).g();
          paramInt1 = ((m)localObject2).a(paramLong1, paramLong2, localu.f, 0, u.ag, localasync_context._tmp_pwd, localasync_context._tmp_no_pic_sig, this.mMiscBitmap, this.mSubSigMap, null, i, paramLong2, u.z, 0, 0, 1, (byte[])localObject1, paramWUserSigInfo);
        }
        else
        {
          paramInt1 = 0;
        }
        paramInt2 = paramInt1;
        if (paramInt1 == 204) {
          paramInt2 = new r(localu).a(this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
        }
        if ((paramInt2 == 0) || (paramInt2 == 160))
        {
          localObject1 = localu.a(l, paramLong1);
          if (localObject1 == null) {
            paramInt1 = -1004;
          } else {
            paramWUserSigInfo.get_clone((WloginSigInfo)localObject1);
          }
        }
        else
        {
          paramInt1 = paramInt2;
        }
      }
      else
      {
        paramInt1 = -1016;
      }
      paramWUserSigInfo = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      if (paramWUserSigInfo == null) {
        paramWUserSigInfo = new Ticket();
      }
      u.at.commit_t2(localu.f, localu.g, util.format_ret_code(paramInt1), paramInt1);
      if (paramInt1 == 0)
      {
        if ((paramWUserSigInfo._sig != null) && (paramWUserSigInfo._sig.length != 0)) {
          RequestReport(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, localu.f, localasync_context._appid);
        }
      }
      else
      {
        localObject1 = paramWUserSigInfo;
        if ((paramInt1 != 2) && (paramInt1 != 160)) {
          RequestReportError(0, ((Ticket)localObject1)._sig, ((Ticket)localObject1)._sig_key, localu.f, localasync_context._appid, 0);
        }
      }
      if ((localu.d != null) && (localu.d.get_bitmap() != 0))
      {
        this.mG.d = localu.d;
        RequestReportError(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, localu.f, localasync_context._appid, 1);
      }
      oicq.wlogin_sdk.report.c.a();
      u.b();
      localu.i();
      paramWUserSigInfo = new StringBuilder("end getStWithQrSig user:");
      paramWUserSigInfo.append(paramString);
      paramWUserSigInfo.append(" appid:");
      paramWUserSigInfo.append(paramLong1);
      paramWUserSigInfo.append(" sigMap:0x");
      paramWUserSigInfo.append(Integer.toHexString(i));
      paramWUserSigInfo.append(" subAppid:");
      paramWUserSigInfo.append(paramLong2);
      paramWUserSigInfo.append(" Seq:");
      paramWUserSigInfo.append(localu.h);
      paramWUserSigInfo.append(" ret=");
      paramWUserSigInfo.append(paramInt1);
      paramString = paramWUserSigInfo.toString();
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append(localu.f);
      util.LOGI(paramString, paramWUserSigInfo.toString());
      return paramInt1;
    }
    return -1017;
  }
  
  private int getTicketByGateway(long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo, StringBuilder paramStringBuilder, u paramu, async_context paramasync_context)
  {
    paramasync_context._tmp_pwd = MD5.toMD5Byte(paramasync_context._mpasswd.getBytes());
    Object localObject = new m(paramu, this.mContext);
    ((m)localObject).g();
    int i = ((m)localObject).a(paramLong1, paramLong2, paramu.f, 0, u.ag, util.getRequestInitTime(), paramasync_context._tmp_pwd, 4, this.mMiscBitmap, this.mSubSigMap, null, paramInt, paramLong2, u.z, 0, 0, 1, u.ad, paramWUserSigInfo);
    paramStringBuilder.append(",retPasswd =");
    paramStringBuilder.append(i);
    paramInt = i;
    if (i == 204)
    {
      paramInt = new r(paramu).a(this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
      paramStringBuilder.append("，devlock = ");
      paramStringBuilder.append(paramInt);
    }
    if (paramInt != 0)
    {
      paramStringBuilder.append(",fail");
      util.LOGI(paramStringBuilder.toString(), "");
      return -2005;
    }
    localObject = paramu.a(paramu.f, paramLong1);
    if (localObject == null)
    {
      paramStringBuilder.append(",info == null");
      util.LOGI(paramStringBuilder.toString(), "");
      return -1004;
    }
    paramWUserSigInfo.get_clone((WloginSigInfo)localObject);
    paramWUserSigInfo = GetUserSigInfoTicket(paramWUserSigInfo, 128);
    if (paramWUserSigInfo == null) {
      paramWUserSigInfo = new Ticket();
    }
    u.at.commit_t2(paramu.f, paramu.g, util.format_ret_code(paramInt), paramInt);
    if (paramInt == 0)
    {
      if ((paramWUserSigInfo._sig != null) && (paramWUserSigInfo._sig.length != 0)) {
        RequestReport(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, paramu.f, paramasync_context._appid);
      }
    }
    else if ((paramInt != 2) && (paramInt != 160)) {
      RequestReportError(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, paramu.f, paramasync_context._appid, 0);
    }
    paramStringBuilder = paramu;
    if ((paramStringBuilder.d != null) && (paramStringBuilder.d.get_bitmap() != 0))
    {
      this.mG.d = paramStringBuilder.d;
      RequestReportError(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, paramStringBuilder.f, paramasync_context._appid, 1);
    }
    oicq.wlogin_sdk.report.c.a();
    u.b();
    paramu.i();
    return 0;
  }
  
  public static b getWtDataSender()
  {
    return mWtDataSender;
  }
  
  private Handler initHelperHandler()
  {
    try
    {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        return null;
      }
      Handler localHandler = new Handler();
      return localHandler;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  private boolean isGateWay(WUserSigInfo paramWUserSigInfo)
  {
    boolean bool;
    if (paramWUserSigInfo.businessType == 2) {
      bool = true;
    } else {
      bool = false;
    }
    util.LOGI("quickLoginByGateway isGateWay = ".concat(String.valueOf(bool)));
    return bool;
  }
  
  private int isPskeyExpired(int paramInt1, String[] paramArrayOfString, Ticket paramTicket, long paramLong, int paramInt2)
  {
    if ((paramInt1 == 1048576) && (paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int i1 = paramArrayOfString.length;
      int k = 0;
      int j;
      for (paramInt1 = 0;; paramInt1 = j)
      {
        int n = 1;
        if (k >= i1) {
          break;
        }
        String str2 = paramArrayOfString[k];
        j = paramInt1;
        if (str2 != null)
        {
          j = paramInt1;
          if (str2.length() != 0)
          {
            i = str2.indexOf('(');
            int m = str2.indexOf(')');
            String str1;
            if ((i == 0) && (m > 0))
            {
              j = Integer.valueOf(str2.substring(i + 1, m)).intValue();
              if ((j & 0x100000) > 0) {
                i = 1;
              } else {
                i = 0;
              }
              if ((j & 0x8000000) > 0) {
                j = 1;
              } else {
                j = 0;
              }
              str1 = str2.substring(m + 1);
            }
            else
            {
              str1 = str2;
              j = 0;
              i = 1;
            }
            StringBuilder localStringBuilder = new StringBuilder("isPskeyExpired domain ");
            localStringBuilder.append(str1);
            localStringBuilder.append(" req_pskey:");
            Object localObject;
            if (i != 0) {
              localObject = "1";
            } else {
              localObject = "0";
            }
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(" req_pt4t:");
            if (j != 0) {
              localObject = "1";
            } else {
              localObject = "0";
            }
            localStringBuilder.append((String)localObject);
            util.LOGI(localStringBuilder.toString(), "");
            if ((i != 0) && ((paramTicket._pskey_map.get(str1) == null) || (Ticket.isPskeyExpired(((Long)paramTicket._pskey_expire.get(str1)).longValue())))) {
              i = 1;
            } else {
              i = 0;
            }
            if (j != 0)
            {
              m = n;
              if (paramTicket._pt4token_map.get(str1) == null) {
                break label375;
              }
              if (Ticket.isPskeyExpired(((Long)paramTicket._pt4token_expire.get(str1)).longValue()))
              {
                m = n;
                break label375;
              }
            }
            m = 0;
            label375:
            if (i == 0)
            {
              j = paramInt1;
              if (m == 0) {}
            }
            else
            {
              paramArrayOfString[paramInt1] = str2;
              localObject = new StringBuilder("PskeyExpired:");
              ((StringBuilder)localObject).append(str1);
              ((StringBuilder)localObject).append("pskey:");
              if (i != 0) {
                str1 = "1";
              } else {
                str1 = "0";
              }
              ((StringBuilder)localObject).append(str1);
              ((StringBuilder)localObject).append(",pt4t:");
              if (m != 0) {
                str1 = "1";
              } else {
                str1 = "0";
              }
              ((StringBuilder)localObject).append(str1);
              util.LOGI(((StringBuilder)localObject).toString(), "");
              j = paramInt1 + 1;
            }
          }
        }
        k += 1;
      }
      int i = paramInt1;
      if (paramInt1 == 0) {
        return 3;
      }
      while (i < paramArrayOfString.length)
      {
        paramTicket = new StringBuilder("isPskeyExpired domain ");
        paramTicket.append(paramArrayOfString[i]);
        paramTicket.append(" cleared");
        util.LOGI(paramTicket.toString(), "");
        paramArrayOfString[i] = null;
        i += 1;
      }
      if (paramInt2 == 1) {
        return 1;
      }
      RefreshMemorySig();
      return 2;
    }
    return 0;
  }
  
  private void localInit(Context paramContext, boolean paramBoolean)
  {
    this.isForLocal = paramBoolean;
    try
    {
      this.mContext = paramContext.getApplicationContext();
    }
    catch (Throwable localThrowable)
    {
      this.mContext = paramContext;
      util.printThrowable(localThrowable, "");
    }
    this.mG.b(paramContext);
    RequestInit();
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
  
  private void printTicket(WloginSigInfo paramWloginSigInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder("a1 ");
    localStringBuilder.append(paramWloginSigInfo._en_A1.length);
    util.LOGI(localStringBuilder.toString());
    localStringBuilder = new StringBuilder("a2 ");
    localStringBuilder.append(paramWloginSigInfo._TGT.length);
    util.LOGI(localStringBuilder.toString());
    localStringBuilder = new StringBuilder("skey ");
    localStringBuilder.append(paramWloginSigInfo._sKey.length);
    util.LOGI(localStringBuilder.toString());
    localStringBuilder = new StringBuilder("pskey ");
    localStringBuilder.append(paramWloginSigInfo._psKey.length);
    util.LOGI(localStringBuilder.toString());
    localStringBuilder = new StringBuilder("superkey ");
    localStringBuilder.append(paramWloginSigInfo._superKey.length);
    util.LOGI(localStringBuilder.toString());
    localStringBuilder = new StringBuilder("d2 ");
    localStringBuilder.append(paramWloginSigInfo._D2.length);
    util.LOGI(localStringBuilder.toString());
    localStringBuilder = new StringBuilder("d2key ");
    localStringBuilder.append(paramWloginSigInfo._D2Key.length);
    util.LOGI(localStringBuilder.toString());
  }
  
  private int quickLoginByGateway(long paramLong1, long paramLong2, int paramInt1, WUserSigInfo paramWUserSigInfo, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramLong1, paramLong2, paramInt1, paramWUserSigInfo, "quickLoginByWeChat").RunReq(19);
      return -1001;
    }
    StringBuilder localStringBuilder = new StringBuilder("quickLoginByGateway ");
    localStringBuilder.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
    if (paramWUserSigInfo == null)
    {
      localStringBuilder.append(",userSigInfo == null");
      paramWUserSigInfo = new WUserSigInfo();
    }
    u localu = this.mG.a(0L);
    paramWUserSigInfo._seqence = localu.h;
    paramInt1 |= 0x400C0;
    async_context localasync_context = u.b(localu.h);
    localasync_context._mpasswd = util.get_mpasswd();
    localasync_context._msalt = util.constructSalt();
    localasync_context._sappid = paramLong1;
    localasync_context._appid = paramLong1;
    localasync_context._sub_appid = paramLong2;
    localasync_context._main_sigmap = paramInt1;
    localStringBuilder.append(",seq=");
    localStringBuilder.append(localu.h);
    localStringBuilder.append(",_mpasswd=");
    localStringBuilder.append(localasync_context._mpasswd);
    localStringBuilder.append(",_msalt=");
    localStringBuilder.append(Long.toHexString(localasync_context._msalt));
    localStringBuilder.append(",_appid=");
    localStringBuilder.append(localasync_context._appid);
    localStringBuilder.append(",_sub_appid=");
    localStringBuilder.append(localasync_context._sappid);
    localStringBuilder.append(",_sappid=");
    localStringBuilder.append(localasync_context._sub_appid);
    localStringBuilder.append(",dwMainSigMap=");
    localStringBuilder.append(localasync_context._main_sigmap);
    paramInt2 = new v(localu).a(paramWUserSigInfo);
    localStringBuilder.append(",tlv104=");
    localStringBuilder.append(localasync_context._t104.get_data_len());
    localStringBuilder.append(",ret=");
    localStringBuilder.append(paramInt2);
    if (paramInt2 != 0)
    {
      util.LOGI(localStringBuilder.toString(), "");
      return paramInt2;
    }
    localStringBuilder.append(",uin=");
    localStringBuilder.append(localasync_context._uin);
    paramWUserSigInfo.uin = String.valueOf(localasync_context._uin);
    paramWUserSigInfo.extraLoginTLVMap.put(Integer.valueOf(260), localasync_context._t104);
    localasync_context._t104 = new tlv_t104();
    paramInt1 = getTicketByGateway(paramLong1, paramLong2, paramInt1, paramWUserSigInfo, localStringBuilder, localu, localasync_context);
    util.LOGI(localStringBuilder.toString(), "");
    return paramInt1;
  }
  
  private int realGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2, WtTicketPromise paramWtTicketPromise)
  {
    u localu = this.mG.a(0L);
    paramWUserSigInfo._seqence = localu.h;
    Object localObject1 = u.b(localu.h);
    Object localObject2 = new StringBuilder("start GetStWithoutPasswd: dwSrcAppid:");
    ((StringBuilder)localObject2).append(paramLong1);
    ((StringBuilder)localObject2).append(" dwDstAppid:");
    ((StringBuilder)localObject2).append(paramLong2);
    ((StringBuilder)localObject2).append(" dwDstAppPri:");
    ((StringBuilder)localObject2).append(paramLong3);
    ((StringBuilder)localObject2).append(" dwMainSigMap:0x");
    ((StringBuilder)localObject2).append(Integer.toHexString(paramInt));
    ((StringBuilder)localObject2).append(" dwSubDstAppid:");
    ((StringBuilder)localObject2).append(paramLong4);
    ((StringBuilder)localObject2).append(" Seq:");
    ((StringBuilder)localObject2).append(localu.h);
    ((StringBuilder)localObject2).append("|");
    if (paramWtTicketPromise != null) {
      paramWtTicketPromise = "1";
    } else {
      paramWtTicketPromise = "0";
    }
    ((StringBuilder)localObject2).append(paramWtTicketPromise);
    ((StringBuilder)localObject2).append(" at ");
    ((StringBuilder)localObject2).append(u.m());
    util.LOGI(((StringBuilder)localObject2).toString(), paramString);
    int i = util.get_saved_network_type(this.mContext);
    u.E = util.get_network_type(this.mContext);
    if (i != u.E)
    {
      util.set_net_retry_type(this.mContext, 0);
      util.save_network_type(this.mContext, u.E);
    }
    u.G = util.get_apn_string(this.mContext).getBytes();
    localu.g = paramString;
    localu.f = 0L;
    ((async_context)localObject1)._sappid = paramLong1;
    ((async_context)localObject1)._appid = paramLong2;
    ((async_context)localObject1)._sub_appid = paramLong4;
    ((async_context)localObject1)._main_sigmap = paramInt;
    ((async_context)localObject1)._last_err_msg = new ErrMsg();
    if (paramArrayOfLong != null) {
      ((async_context)localObject1)._sub_appid_list = ((long[])paramArrayOfLong.clone());
    }
    if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
    {
      localu.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
      paramWtTicketPromise = new StringBuilder("MSF SSO SEQ:");
      paramWtTicketPromise.append(localu.i);
      util.LOGI(paramWtTicketPromise.toString(), paramString);
    }
    else
    {
      localu.i = 0;
    }
    u.at.add_t2(new report_t2("exchg", new String(u.D), System.currentTimeMillis(), paramLong2, paramLong4, paramArrayOfLong));
    long l2;
    long l1;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      l2 = localu.b(paramString);
      l1 = l2;
      if (l2 == 0L)
      {
        paramArrayOfLong = new StringBuilder("user:");
        paramArrayOfLong.append(paramString);
        paramArrayOfLong.append(" have not found uin record.");
        util.LOGI(paramArrayOfLong.toString(), paramString);
        paramArrayOfByte2 = (byte[][])localObject1;
        i = -1003;
        break label1696;
      }
    }
    else
    {
      l1 = Long.parseLong(paramString);
    }
    localu.f = l1;
    paramWUserSigInfo.uin = String.valueOf(l1);
    int j;
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length == 4) && (paramArrayOfByte2[0] != null) && (paramArrayOfByte2[0].length == 1) && (paramArrayOfByte2[0][0] == 1))
    {
      paramWtTicketPromise = new StringBuilder("user:");
      paramWtTicketPromise.append(paramString);
      paramWtTicketPromise.append(" exchange A2 from A2/D2/KEY.");
      paramWtTicketPromise = paramWtTicketPromise.toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localu.f);
      util.LOGI(paramWtTicketPromise, ((StringBuilder)localObject2).toString());
      if ((paramArrayOfByte2[1] != null) && (paramArrayOfByte2[1].length != 0) && (paramArrayOfByte2[2] != null) && (paramArrayOfByte2[2].length != 0) && (paramArrayOfByte2[3] != null) && (paramArrayOfByte2[3].length != 0))
      {
        localu.b = MD5.toMD5Byte(paramArrayOfByte2[3]);
        i = new o(localu).a(l1, paramLong2, paramLong4, 1, paramInt, paramArrayOfByte2[1], this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, paramArrayOfByte2[2], paramWUserSigInfo);
        paramArrayOfByte2 = (byte[][])localObject1;
      }
      else
      {
        paramArrayOfByte2 = (byte[][])localObject1;
        i = -1004;
        break label1696;
      }
    }
    else
    {
      l2 = l1;
      if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length == 3) && (paramArrayOfByte2[0] != null) && (paramArrayOfByte2[0].length == 1) && (paramArrayOfByte2[0][0] == 2))
      {
        paramWtTicketPromise = new StringBuilder("user:");
        paramWtTicketPromise.append(paramString);
        paramWtTicketPromise.append(" exchange A2 from A2/A2KEY.");
        paramWtTicketPromise = paramWtTicketPromise.toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localu.f);
        util.LOGI(paramWtTicketPromise, ((StringBuilder)localObject2).toString());
        if ((paramArrayOfByte2[1] != null) && (paramArrayOfByte2[1].length != 0) && (paramArrayOfByte2[2] != null) && (paramArrayOfByte2[2].length != 0))
        {
          localu.b = paramArrayOfByte2[2];
          i = new o(localu).a(l2, paramLong2, paramLong4, 1, paramInt, paramArrayOfByte2[1], this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, null, paramWUserSigInfo);
          paramArrayOfByte2 = (byte[][])localObject1;
        }
        else
        {
          paramArrayOfByte2 = (byte[][])localObject1;
          i = -1004;
          break label1696;
        }
      }
      else
      {
        localu.k();
        paramArrayOfByte2 = getA1AndNopicSigByAccount(String.valueOf(localu.f), paramLong1);
        paramWtTicketPromise = paramArrayOfByte2.a1;
        localObject2 = paramArrayOfByte2.noPicSig;
        if ((paramWtTicketPromise != null) && (paramWtTicketPromise.length > 0) && (localObject2 != null) && (localObject2.length > 0))
        {
          paramArrayOfByte2 = new StringBuilder("user:");
          paramArrayOfByte2.append(paramString);
          paramArrayOfByte2.append(" exchange A2 from A1.");
          paramArrayOfByte2 = paramArrayOfByte2.toString();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(localu.f);
          util.LOGI(paramArrayOfByte2, ((StringBuilder)localObject3).toString());
          ((async_context)localObject1)._tmp_pwd = paramWtTicketPromise;
          ((async_context)localObject1)._tmp_no_pic_sig = ((byte[])localObject2);
          if ((paramWUserSigInfo._in_ksid != null) && (paramWUserSigInfo._in_ksid.length > 0)) {
            paramArrayOfByte2 = (byte[])paramWUserSigInfo._in_ksid.clone();
          } else {
            paramArrayOfByte2 = u.ad;
          }
          localObject3 = new ab(localu, this.mContext);
          WloginSigInfo localWloginSigInfo = FindUserSig(l2, paramLong1);
          if (localWloginSigInfo != null) {
            ((ab)localObject3).a(localWloginSigInfo);
          }
          i = this.mMiscBitmap;
          if (u.ac) {
            i |= 0x2000000;
          }
          i = ((ab)localObject3).a(paramLong2, 1, localu.f, 0, u.ag, paramWtTicketPromise, (byte[])localObject2, i, this.mSubSigMap, paramArrayOfLong, paramInt, paramLong4, 1, u.z, 0, 0, 1, paramArrayOfByte2, paramLong1, paramWUserSigInfo);
          if (i == 204) {
            i = new r(localu).a(this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, paramWUserSigInfo);
          }
          paramArrayOfByte2 = (byte[][])localObject1;
        }
        else
        {
          paramArrayOfByte2 = new StringBuilder("user:");
          paramArrayOfByte2.append(paramString);
          paramArrayOfByte2.append(" exchange A2 from A2.");
          paramArrayOfByte2 = paramArrayOfByte2.toString();
          paramWtTicketPromise = new StringBuilder();
          paramWtTicketPromise.append(localu.f);
          util.LOGI(paramArrayOfByte2, paramWtTicketPromise.toString());
          paramArrayOfByte2 = localu.a(l2, paramLong1);
          if ((paramArrayOfByte2 == null) || (paramArrayOfByte2._TGT == null) || (paramArrayOfByte2._TGT.length == 0) || (paramArrayOfByte2.iSExpireA2(u.f()))) {
            break label1687;
          }
          paramWtTicketPromise = new StringBuilder("user:");
          paramWtTicketPromise.append(paramString);
          paramWtTicketPromise.append(" exchange A2 from A2 without Priority.");
          paramWtTicketPromise = paramWtTicketPromise.toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localu.f);
          util.LOGI(paramWtTicketPromise, ((StringBuilder)localObject2).toString());
          printTicket(paramArrayOfByte2);
          localu.b = paramArrayOfByte2._TGTKey;
          paramWtTicketPromise = new o(localu);
          localObject2 = paramArrayOfByte2._TGT;
          i = this.mMiscBitmap;
          j = this.mSubSigMap;
          paramArrayOfByte2 = (byte[][])localObject1;
          i = paramWtTicketPromise.a(l2, paramLong2, paramLong4, 1, paramInt, (byte[])localObject2, i, j, paramArrayOfLong, null, paramWUserSigInfo);
        }
      }
    }
    if (i == 0)
    {
      paramWtTicketPromise = localu;
      localObject1 = paramWtTicketPromise.a(l1, paramLong2);
      if (localObject1 == null)
      {
        i = -1004;
      }
      else
      {
        paramWUserSigInfo.get_clone((WloginSigInfo)localObject1);
        if ((paramArrayOfLong != null) && (paramArrayOfByte1 != null) && (paramArrayOfLong.length * 2 == paramArrayOfByte1.length))
        {
          j = 0;
          while (j < paramArrayOfLong.length)
          {
            localObject1 = paramWtTicketPromise.a(l1, paramArrayOfLong[j]);
            if (localObject1 != null)
            {
              int k = j * 2;
              paramArrayOfByte1[k] = ((byte[])((WloginSigInfo)localObject1)._userSt_Key.clone());
              paramArrayOfByte1[(k + 1)] = ((byte[])((WloginSigInfo)localObject1)._userStSig.clone());
            }
            j += 1;
          }
        }
      }
    }
    break label1696;
    label1687:
    paramArrayOfByte2 = (byte[][])localObject1;
    i = -1004;
    label1696:
    paramArrayOfLong = GetUserSigInfoTicket(paramWUserSigInfo, 128);
    if (paramArrayOfLong == null) {
      paramArrayOfLong = new Ticket();
    }
    u.at.commit_t2(localu.f, localu.g, util.format_ret_code(i), i);
    if (i == 0)
    {
      if ((paramArrayOfLong._sig != null) && (paramArrayOfLong._sig.length != 0)) {
        RequestReport(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localu.f, paramArrayOfByte2._appid);
      }
    }
    else {
      RequestReportError(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localu.f, paramArrayOfByte2._appid, 0);
    }
    if ((localu.d != null) && (localu.d.get_bitmap() != 0))
    {
      this.mG.d = localu.d;
      RequestReportError(0, paramArrayOfLong._sig, paramArrayOfLong._sig_key, localu.f, paramArrayOfByte2._appid, 1);
    }
    oicq.wlogin_sdk.report.c.a();
    u.b();
    localu.i();
    paramArrayOfLong = new StringBuilder("end GetStWithoutPasswd:user:");
    paramArrayOfLong.append(paramString);
    paramArrayOfLong.append(" dwSrcAppid:");
    paramArrayOfLong.append(paramLong1);
    paramArrayOfLong.append(" dwDstAppid:");
    paramArrayOfLong.append(paramLong2);
    paramArrayOfLong.append(" dwDstAppPri:");
    paramArrayOfLong.append(paramLong3);
    paramArrayOfLong.append(" dwMainSigMap:0x");
    paramArrayOfLong.append(Integer.toHexString(paramInt));
    paramArrayOfLong.append(" dwSubDstAppid:");
    paramArrayOfLong.append(paramLong4);
    paramArrayOfLong.append(" Seq:");
    paramArrayOfLong.append(localu.h);
    paramArrayOfLong.append(" ret=");
    paramArrayOfLong.append(i);
    paramString = paramArrayOfLong.toString();
    paramArrayOfLong = new StringBuilder();
    paramArrayOfLong.append(localu.f);
    util.LOGI(paramString, paramArrayOfLong.toString());
    return i;
  }
  
  public static void setCustomerGuid(Context paramContext, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("set customer guid ");
    localStringBuilder.append(util.buf_to_string(paramArrayOfByte));
    util.LOGI(localStringBuilder.toString(), "");
    u.al = paramArrayOfByte;
    util.saveGuidToFile(paramContext, paramArrayOfByte);
  }
  
  public static void setExtraLoginTlvValue(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    tlv_t localtlv_t = new tlv_t(paramInt);
    localtlv_t.set_data(paramArrayOfByte, paramArrayOfByte.length);
    paramWUserSigInfo.extraLoginTLVMap.put(Integer.valueOf(paramInt), localtlv_t);
    int i = paramArrayOfByte[0];
    paramArrayOfByte = new StringBuilder("setExtraLoginTlvValue tag:");
    paramArrayOfByte.append(paramInt);
    paramArrayOfByte.append(" value[0]: ");
    paramArrayOfByte.append(i & 0xFF);
    util.LOGI(paramArrayOfByte.toString(), paramWUserSigInfo.uin);
  }
  
  private static void setExtraProductLoginTlvValue(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    tlv_t localtlv_t = new tlv_t(paramInt);
    localtlv_t.set_data(paramArrayOfByte, paramArrayOfByte.length);
    paramWUserSigInfo._loginExtraProductTLVMap.put(Integer.valueOf(paramInt), localtlv_t);
    int i = paramArrayOfByte[0];
    paramArrayOfByte = new StringBuilder("setExtraProductLoginTlvValue tag:");
    paramArrayOfByte.append(paramInt);
    paramArrayOfByte.append(" value[0]: ");
    paramArrayOfByte.append(i & 0xFF);
    util.LOGI(paramArrayOfByte.toString(), paramWUserSigInfo.uin);
  }
  
  public static void setExtraRegTlvValue(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    RegTLV localRegTLV = new RegTLV(paramInt);
    localRegTLV.set_data(paramArrayOfByte, paramArrayOfByte.length);
    paramWUserSigInfo.extraRegTLVMap.put(Integer.valueOf(paramInt), localRegTLV);
  }
  
  @Deprecated
  public static void setExtraRegTlvValueWatchQQLicense(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte)
  {
    setExtraRegTlvValue(paramWUserSigInfo, 38, paramArrayOfByte);
  }
  
  public static void setLoadEncryptSo(boolean paramBoolean)
  {
    util.loadEncryptSo = paramBoolean;
  }
  
  public static void setLoadSoFlg(boolean paramBoolean)
  {
    u.ay = paramBoolean;
  }
  
  public static void setProductType(int paramInt)
  {
    u.aA = paramInt;
  }
  
  public static void setQimeiListener(QimeiListener paramQimeiListener)
  {
    util.qimeiListener = paramQimeiListener;
  }
  
  public static void setRegisterFlg(int paramInt)
  {
    u.ak = paramInt | u.ak;
  }
  
  public static void setReportListener(ReportListener paramReportListener)
  {
    oicq.wlogin_sdk.report.c.a(paramReportListener);
  }
  
  public static void setSecTransInfo(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    u.aB = paramString1;
    u.aC = paramString2;
    u.aD = paramInt;
    u.aE = paramString3;
  }
  
  public static void setWtDataSender(b paramb)
  {
    mWtDataSender = paramb;
  }
  
  private void tlvCommRsp2ErrMsg(TLV_CommRsp paramTLV_CommRsp, ErrMsg paramErrMsg)
  {
    if (paramTLV_CommRsp != null)
    {
      if (paramTLV_CommRsp.get_data_len() == 0) {
        return;
      }
      paramErrMsg.setType(paramTLV_CommRsp.ErrInfoType);
      paramErrMsg.setOtherinfo(new String(paramTLV_CommRsp.ErrInfo));
      paramErrMsg.setTitle(new String(paramTLV_CommRsp.ErrTitle));
      paramErrMsg.setMessage(new String(paramTLV_CommRsp.ErrMsg));
      return;
    }
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
    if (localTransReqContext._body != null)
    {
      if (localTransReqContext._body.length == 0) {
        return -1017;
      }
      return RequestTransport(0, 1, paramString, paramLong1, ((oicq.wlogin_sdk.devicelock.d)localObject).Role, localTransReqContext, paramWUserSigInfo);
    }
    return -1017;
  }
  
  public void CancelRequest()
  {
    this.mG.t = 1;
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
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST((WloginSigInfo)localObject2);
    localObject1 = ((WloginSigInfo)localObject2)._TGT;
    localObject2 = u.B;
    byte[] arrayOfByte1 = u.F;
    byte[] arrayOfByte2 = "6.0.0.2484".getBytes();
    byte[] arrayOfByte3 = "android".getBytes();
    paramArrayOfByte = paramArrayOfByte.getBytes();
    if (paramString2 == null) {
      paramString2 = null;
    } else {
      paramString2 = paramString2.getBytes();
    }
    localTransReqContext._body = localf.a(l, paramLong1, paramLong2, (byte[])localObject1, (byte[])localObject2, arrayOfByte1, arrayOfByte2, arrayOfByte3, paramArrayOfByte, paramString2);
    if (localTransReqContext._body != null)
    {
      if (localTransReqContext._body.length == 0) {
        return -1017;
      }
      return RequestTransport(0, 1, paramString1, paramLong1, localf.Role, localTransReqContext, paramWUserSigInfo);
    }
    return -1017;
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
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST((WloginSigInfo)localObject);
    localTransReqContext._body = locala.a(l, paramLong1, paramLong2, ((WloginSigInfo)localObject)._TGT, u.B, u.F, "6.0.0.2484".getBytes(), u.L, u.K);
    if (localTransReqContext._body != null)
    {
      if (localTransReqContext._body.length == 0) {
        return -1017;
      }
      return RequestTransport(0, 1, paramString, paramLong1, locala.Role, localTransReqContext, paramWUserSigInfo);
    }
    return -1017;
  }
  
  public int CheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    p.K = false;
    return CheckPictureAndGetSt(paramString, paramArrayOfByte, paramWUserSigInfo, null, 0);
  }
  
  public int CheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1)
  {
    p.K = false;
    return CheckPictureAndGetSt(paramString, paramArrayOfByte, paramWUserSigInfo, paramArrayOfByte1, 0);
  }
  
  public int CheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    return CheckSMSAndGetSt(paramString, paramArrayOfByte, paramWUserSigInfo, null, null, 0);
  }
  
  public int CheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte1, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, byte[] paramArrayOfByte2)
  {
    return CheckSMSAndGetSt(paramString, paramArrayOfByte1, paramWUserSigInfo, paramArrayOfByte, paramArrayOfByte2, 0);
  }
  
  public int CheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, int paramInt, long paramLong3, WUserSigInfo paramWUserSigInfo)
  {
    return CheckSMSVerifyLoginAccount(paramLong1, paramLong2, null, paramInt, paramLong3, paramWUserSigInfo, 0);
  }
  
  public int CheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, String paramString, WUserSigInfo paramWUserSigInfo)
  {
    return CheckSMSVerifyLoginAccount(paramLong1, paramLong2, paramString, 1, -1L, paramWUserSigInfo, 0);
  }
  
  public int CheckWebsigAndGetSt(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    p.K = true;
    return CheckPictureAndGetSt(paramString1, paramString2.getBytes(), paramWUserSigInfo, null, 0);
  }
  
  public int CheckWebsigAndGetSt(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte)
  {
    p.K = true;
    return CheckPictureAndGetSt(paramString1, paramString2.getBytes(), paramWUserSigInfo, paramArrayOfByte, 0);
  }
  
  public void ClearPSkey(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder("user:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" appid:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" ClearPSkey ...");
    util.LOGI(localStringBuilder.toString(), paramString);
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return;
      }
      int i = 1;
      try
      {
        long l1;
        if (!util.check_uin_account(paramString).booleanValue())
        {
          long l2 = this.mG.b(paramString);
          l1 = l2;
          if (l2 == 0L)
          {
            i = 0;
            l1 = l2;
          }
        }
        else
        {
          l1 = Long.parseLong(paramString);
        }
        if (i != 0) {
          this.mG.d(l1, paramLong);
        }
        return;
      }
      finally {}
    }
  }
  
  public Boolean ClearUserLoginData(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder("user:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" appid:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" ClearUserLoginData ...");
    util.LOGI(localStringBuilder.toString(), paramString);
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        long l;
        int i;
        if (!util.check_uin_account(paramString).booleanValue())
        {
          l = this.mG.b(paramString);
          if (l == 0L)
          {
            i = 0;
          }
          else
          {
            this.mG.d(paramString);
            i = 1;
          }
        }
        else
        {
          l = Long.parseLong(paramString);
          i = 1;
        }
        if (i == 1) {
          this.mG.e(l, paramLong);
        }
        WloginSigInfo._QRPUSHSig = new byte[0];
        WloginSigInfo._LHSig = new byte[0];
        return Boolean.TRUE;
      }
      finally {}
    }
    return Boolean.TRUE;
  }
  
  public int CloseCode(String paramString, long paramLong, byte[] paramArrayOfByte, int paramInt, List<byte[]> paramList, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject1 = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject1)._uin;
    this.mG.k();
    localObject1 = FindUserSig(l, paramLong);
    if (localObject1 == null) {
      return -1004;
    }
    Object localObject2 = new StringBuilder("user:");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" CloseCode ...");
    util.LOGI(((StringBuilder)localObject2).toString(), paramString);
    localObject2 = new oicq.wlogin_sdk.code2d.b();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(((oicq.wlogin_sdk.code2d.b)localObject2).get_cmd());
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST((WloginSigInfo)localObject1);
    localTransReqContext._body = ((oicq.wlogin_sdk.code2d.b)localObject2).a(l, paramLong, 1L, paramArrayOfByte, ((WloginSigInfo)localObject1)._TGT, u.B, paramInt, paramList, ((WloginSigInfo)localObject1)._en_A1, ((WloginSigInfo)localObject1)._noPicSig, this.mMiscBitmap, 0L);
    return RequestTransport(0, 1, paramString, paramLong, ((oicq.wlogin_sdk.code2d.b)localObject2)._role, localTransReqContext, paramWUserSigInfo);
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
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST(localWloginSigInfo);
    localTransReqContext._body = localb.a(l, paramLong1, paramLong2, localWloginSigInfo._TGT, u.B, u.F, "6.0.0.2484".getBytes(), "android".getBytes(), ((String)localObject).getBytes());
    if (localTransReqContext._body != null)
    {
      if (localTransReqContext._body.length == 0) {
        return -1017;
      }
      return RequestTransport(0, 1, paramString, paramLong1, localb.Role, localTransReqContext, paramWUserSigInfo);
    }
    return -1017;
  }
  
  public int FetchCodeSig(long paramLong1, long paramLong2, fetch_code.QRCodeCustom paramQRCodeCustom, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI(" FetchCodeSig ...", "");
    fetch_code localfetch_code = new fetch_code();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(localfetch_code.get_cmd());
    long l = this.mMiscBitmap;
    byte[] arrayOfByte = WloginSigInfo._QRPUSHSig;
    localTransReqContext._body = localfetch_code.get_request(0L, paramLong1, paramLong2, new byte[0], paramQRCodeCustom, l, 0L, arrayOfByte);
    return RequestTransport(0, 1, null, paramLong1, localfetch_code._role, localTransReqContext, paramWUserSigInfo);
  }
  
  public int GetA1WithA1(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo)
  {
    return GetA1WithA1(paramString, paramLong1, paramLong2, this.mMainSigMap, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramArrayOfByte2, paramArrayOfByte3, paramWUserSigInfo, paramWFastLoginInfo, 0);
  }
  
  public byte[] GetA2A2KeyBuf(String paramString, long paramLong)
  {
    Ticket localTicket = GetLocalTicket(paramString, paramLong, 64);
    if ((localTicket != null) && (localTicket._sig != null) && (localTicket._sig.length > 0) && (localTicket._sig_key != null))
    {
      if (localTicket._sig_key.length <= 0) {
        return null;
      }
      if (u.C != null)
      {
        if (u.C.length <= 0) {
          return null;
        }
        int i = paramString.getBytes().length + 2 + 8 + 2 + localTicket._sig.length + 2 + localTicket._sig_key.length;
        byte[] arrayOfByte = new byte[i];
        util.int16_to_buf(arrayOfByte, 0, paramString.getBytes().length);
        System.arraycopy(paramString.getBytes(), 0, arrayOfByte, 2, paramString.getBytes().length);
        int j = paramString.getBytes().length + 2;
        util.int64_to_buf(arrayOfByte, j, paramLong);
        j += 8;
        util.int16_to_buf(arrayOfByte, j, localTicket._sig.length);
        j += 2;
        System.arraycopy(localTicket._sig, 0, arrayOfByte, j, localTicket._sig.length);
        j += localTicket._sig.length;
        util.int16_to_buf(arrayOfByte, j, localTicket._sig_key.length);
        System.arraycopy(localTicket._sig_key, 0, arrayOfByte, j + 2, localTicket._sig_key.length);
        return cryptor.encrypt(arrayOfByte, 0, i, u.C);
      }
      return null;
    }
    return null;
  }
  
  public List<WloginLoginInfo> GetAllLoginInfo()
  {
    return this.mG.l();
  }
  
  public long GetAppidFromUrl(String paramString)
  {
    if (paramString == null) {
      return -1L;
    }
    int i = paramString.indexOf("f=");
    String str;
    if (i != -1)
    {
      i += 2;
      if (i >= paramString.length()) {
        return -1L;
      }
      str = "";
      while ((i < paramString.length()) && (paramString.charAt(i) != '&'))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(paramString.charAt(i));
        str = localStringBuilder.toString();
        i += 1;
      }
    }
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (Exception paramString) {}
    return -1L;
    return -1L;
  }
  
  public Boolean GetBasicUserInfo(String paramString, WloginSimpleInfo paramWloginSimpleInfo)
  {
    if (paramString == null) {
      return Boolean.FALSE;
    }
    boolean bool2 = util.check_uin_account(paramString).booleanValue();
    boolean bool1 = false;
    long l;
    int i;
    if (!bool2)
    {
      l = this.mG.b(paramString);
      if (l == 0L) {
        i = 0;
      } else {
        i = 1;
      }
    }
    else
    {
      l = Long.parseLong(paramString);
      i = 1;
    }
    int j = i;
    if (i == 1)
    {
      paramString = this.mG.d(l);
      if (paramString == null)
      {
        j = 0;
      }
      else
      {
        paramWloginSimpleInfo.setUin(paramString._uin);
        paramWloginSimpleInfo.setFace(paramString._face);
        paramWloginSimpleInfo.setGender(paramString._gender);
        paramWloginSimpleInfo.setNick(paramString._nick);
        paramWloginSimpleInfo.setAge(paramString._age);
        paramWloginSimpleInfo.setImgType(paramString._img_type);
        paramWloginSimpleInfo.setImgFormat(paramString._img_format);
        paramWloginSimpleInfo.setImgUrl(paramString._img_url);
        paramWloginSimpleInfo.setMainDisplayName(paramString.mainDisplayName);
        j = i;
      }
    }
    if (j == 1) {
      bool1 = true;
    }
    return Boolean.valueOf(bool1);
  }
  
  public Boolean GetBasicUserInfoForQQLoginInQimOnly(WUserSigInfo paramWUserSigInfo, WloginSimpleInfo paramWloginSimpleInfo)
  {
    long l = Long.parseLong(paramWUserSigInfo.uin);
    paramWUserSigInfo = this.mG.d(l);
    boolean bool = false;
    int i;
    if (paramWUserSigInfo == null)
    {
      i = 0;
    }
    else
    {
      paramWloginSimpleInfo.setUin(paramWUserSigInfo._uin);
      paramWloginSimpleInfo.setFace(paramWUserSigInfo._face);
      paramWloginSimpleInfo.setGender(paramWUserSigInfo._gender);
      paramWloginSimpleInfo.setNick(paramWUserSigInfo._nick);
      paramWloginSimpleInfo.setAge(paramWUserSigInfo._age);
      paramWloginSimpleInfo.setImgType(paramWUserSigInfo._img_type);
      paramWloginSimpleInfo.setImgFormat(paramWUserSigInfo._img_format);
      paramWloginSimpleInfo.setImgUrl(paramWUserSigInfo._img_url);
      paramWloginSimpleInfo.setMainDisplayName(paramWUserSigInfo.mainDisplayName);
      i = 1;
    }
    if (i == 1) {
      bool = true;
    }
    return Boolean.valueOf(bool);
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
    return u.b(l)._devlock_info;
  }
  
  public byte[] GetGuid()
  {
    Object localObject2 = u.a(this.mContext);
    if (localObject2 != null) {
      return localObject2;
    }
    Object localObject1 = localObject2;
    if (u.B != null)
    {
      localObject1 = localObject2;
      if (u.B.length > 0)
      {
        localObject1 = new byte[u.B.length];
        System.arraycopy(u.B, 0, localObject1, 0, u.B.length);
      }
    }
    localObject2 = new StringBuilder("get guid ");
    ((StringBuilder)localObject2).append(util.buf_to_string((byte[])localObject1));
    util.LOGI(((StringBuilder)localObject2).toString(), "");
    return localObject1;
  }
  
  public WloginLastLoginInfo GetLastLoginInfo()
  {
    Object localObject = this.mG.l();
    if (localObject == null) {
      return null;
    }
    Iterator localIterator = ((List)localObject).iterator();
    localObject = null;
    while (localIterator.hasNext())
    {
      WloginLoginInfo localWloginLoginInfo = (WloginLoginInfo)localIterator.next();
      if (localObject == null) {
        localObject = localWloginLoginInfo;
      } else if (localWloginLoginInfo.mCreateTime > ((WloginLoginInfo)localObject).mCreateTime) {
        localObject = localWloginLoginInfo;
      }
    }
    if (localObject == null) {
      return null;
    }
    if ((((WloginLoginInfo)localObject).mAccount != null) && (((WloginLoginInfo)localObject).mAccount.length() > 0)) {
      return new WloginLastLoginInfo(((WloginLoginInfo)localObject).mAccount, ((WloginLoginInfo)localObject).mUin);
    }
    return new WloginLastLoginInfo(String.valueOf(((WloginLoginInfo)localObject).mUin), ((WloginLoginInfo)localObject).mUin);
  }
  
  public WUserSigInfo GetLocalSig(String paramString, long paramLong)
  {
    if (paramString == null)
    {
      util.LOGI("userAccount null", "");
      return null;
    }
    WUserSigInfo localWUserSigInfo;
    try
    {
      long l1;
      if (!util.check_uin_account(paramString).booleanValue())
      {
        long l2 = this.mG.b(paramString);
        l1 = l2;
        if (l2 == 0L) {
          return null;
        }
      }
      else
      {
        l1 = Long.parseLong(paramString);
      }
      WloginSigInfo localWloginSigInfo = this.mG.a(l1, paramLong);
      if (localWloginSigInfo != null)
      {
        localWUserSigInfo = new WUserSigInfo();
        try
        {
          localWUserSigInfo.uin = paramString;
          localWUserSigInfo.get_clone(localWloginSigInfo);
          StringBuilder localStringBuilder = new StringBuilder("skey in sigInfo ");
          localStringBuilder.append(util.getMaskBytes(localWloginSigInfo._sKey, 2, 2));
          util.LOGI(localStringBuilder.toString(), paramString);
          return localWUserSigInfo;
        }
        catch (Exception localException1) {}
      }
      else
      {
        return null;
      }
    }
    catch (Exception localException2)
    {
      localWUserSigInfo = null;
      util.printException(localException2, paramString);
    }
    return localWUserSigInfo;
  }
  
  public Ticket GetLocalTicket(String paramString, long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("GetLocalTicket appid ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" type 0x");
    localStringBuilder.append(String.format("%x", new Object[] { Integer.valueOf(paramInt) }));
    util.LOGI(localStringBuilder.toString(), paramString);
    if (paramString == null)
    {
      util.LOGI("userAccount null", "");
      return null;
    }
    return GetUserSigInfoTicket(GetLocalSig(paramString, paramLong), paramInt);
  }
  
  public int GetOpenKeyWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithoutPasswd(paramString, paramLong1, this.mOpenAppid, -1L, paramInt, paramLong2, null, paramWUserSigInfo, null, null, 0, null);
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
    return u.b(l)._t105.get_pic();
  }
  
  @Deprecated
  public byte[] GetPicturePrompt(String paramString)
  {
    return GetPicturePrompt(paramString, 0L);
  }
  
  @Deprecated
  public byte[] GetPicturePrompt(String paramString, long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = this.mAysncSeq;
    }
    return u.b(l)._t165.get_data();
  }
  
  public String GetPicturePromptValue(String paramString)
  {
    return GetPicturePromptValue(paramString, 0L);
  }
  
  public String GetPicturePromptValue(String paramString, long paramLong)
  {
    paramString = GetPicturePrompt(paramString, paramLong);
    if ((paramString != null) && (paramString.length > 3))
    {
      int i = 0;
      int k = util.buf_to_int32(paramString, 0);
      int j = 4;
      while (i < k)
      {
        int n = paramString.length;
        int m = j + 1;
        if (n < m) {
          break;
        }
        n = util.buf_to_int8(paramString, j);
        int i1 = paramString.length;
        j = m + n;
        if (i1 < j) {
          break;
        }
        String str1 = new String(paramString, m, n);
        if (paramString.length < j + 2) {
          break;
        }
        m = util.buf_to_int32(paramString, j);
        n = j + 4;
        i1 = paramString.length;
        j = n + m;
        if (i1 < j) {
          break;
        }
        String str2 = new String(paramString, n, m);
        if (str1.equals("pic_reason")) {
          return str2;
        }
        i += 1;
      }
    }
    return "";
  }
  
  public Ticket GetPskey(String paramString, long paramLong, String[] arg4, WtTicketPromise paramWtTicketPromise)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArray("domains", ???);
    String str = "";
    int i = 0;
    StringBuilder localStringBuilder;
    while (i < ???.length)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(???[i]);
      localStringBuilder.append(",");
      str = localStringBuilder.toString();
      i += 1;
    }
    synchronized (GET_TICKET_LOCK)
    {
      localStringBuilder = new StringBuilder("GetPskey appid ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" domains ");
      localStringBuilder.append(str);
      util.LOGI(localStringBuilder.toString(), paramString);
      paramString = GetTicket(paramString, paramLong, 1048576, paramWtTicketPromise, localBundle);
      return paramString;
    }
  }
  
  public Ticket GetSkey(String paramString, long paramLong, WtTicketPromise paramWtTicketPromise)
  {
    synchronized (GET_TICKET_LOCK)
    {
      paramString = GetTicket(paramString, paramLong, 4096, paramWtTicketPromise, null);
      return paramString;
    }
  }
  
  public int GetStViaSMSVerifyLogin(String paramString, long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject = new StringBuilder("user:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" GetStViaSMSVerifyLogin ...");
    util.LOGI(((StringBuilder)localObject).toString(), paramString);
    if (oicq.wlogin_sdk.a.i.y) {
      localObject = oicq.wlogin_sdk.a.i.A;
    } else {
      localObject = "";
    }
    return GetStWithPasswd(paramString, paramLong1, paramInt, paramLong2, null, false, (String)localObject, paramWUserSigInfo, null, true, 0);
  }
  
  public int GetStViaSMSVerifyLogin(String paramString, long paramLong1, long paramLong2, long[] paramArrayOfLong, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    byte[][] arrayOfByte;
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0)) {
      arrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { paramArrayOfLong.length, 0 });
    } else {
      arrayOfByte = null;
    }
    Object localObject = new StringBuilder("user:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" GetStViaSMSVerifyLogin ...");
    util.LOGI(((StringBuilder)localObject).toString(), paramString);
    if (oicq.wlogin_sdk.a.i.y) {
      localObject = oicq.wlogin_sdk.a.i.A;
    } else {
      localObject = "";
    }
    return GetStWithPasswd(paramString, paramLong1, paramInt, paramLong2, paramArrayOfLong, false, (String)localObject, paramWUserSigInfo, arrayOfByte, true, 0);
  }
  
  public int GetStWithPasswdMd5(String paramString1, long paramLong1, long paramLong2, int paramInt, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithPasswd(paramString1, paramLong1, paramInt, paramLong2, null, true, paramString2, paramWUserSigInfo, null, false, 0);
  }
  
  @Deprecated
  public int GetStWithPasswdMd5(String paramString1, long paramLong, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithPasswd(paramString1, paramLong, this.mMainSigMap, 1L, null, true, paramString2, paramWUserSigInfo, null, false, 0);
  }
  
  public int GetStWithPasswdReserved(String paramString1, long paramLong1, int paramInt, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean, String paramString2, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte)
  {
    return GetStWithPasswd(paramString1, paramLong1, paramInt, paramLong2, paramArrayOfLong, paramBoolean, paramString2, paramWUserSigInfo, paramArrayOfByte, false, 0);
  }
  
  public int GetStWithPasswdReserved(String paramString1, long paramLong1, long paramLong2, int paramInt, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithPasswd(paramString1, paramLong1, paramInt, paramLong2, null, false, paramString2, paramWUserSigInfo, null, false, 0);
  }
  
  @Deprecated
  public int GetStWithPasswdReserved(String paramString1, long paramLong, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithPasswd(paramString1, paramLong, this.mMainSigMap, 1L, null, false, paramString2, paramWUserSigInfo, null, false, 0);
  }
  
  public int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2)
  {
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, paramLong3, paramInt, paramLong4, paramArrayOfLong, paramWUserSigInfo, paramArrayOfByte1, paramArrayOfByte2, 0, null);
  }
  
  public int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, -1L, paramInt, paramLong3, null, paramWUserSigInfo, null, null, 0, null);
  }
  
  public int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo)
  {
    byte[][] arrayOfByte = new byte[4][];
    arrayOfByte[0] = new byte[1];
    arrayOfByte[0][0] = 1;
    arrayOfByte[1] = paramArrayOfByte1;
    arrayOfByte[2] = paramArrayOfByte2;
    arrayOfByte[3] = paramArrayOfByte3;
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, -1L, paramInt, paramLong3, null, paramWUserSigInfo, null, arrayOfByte, 0, null);
  }
  
  @Deprecated
  public int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    return GetStWithoutPasswd(paramString, paramLong1, paramLong2, -1L, this.mMainSigMap, 1L, null, paramWUserSigInfo, null, null, 0, null);
  }
  
  public int GetStWithoutPasswd(byte[] paramArrayOfByte, long paramLong, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return -1017;
      }
      Object localObject = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, u.C);
      if (localObject != null)
      {
        if (localObject.length <= 0) {
          return -1017;
        }
        if (2 > localObject.length) {
          return -1017;
        }
        int j = util.buf_to_int16((byte[])localObject, 0);
        if (j > 0)
        {
          int i = j + 2;
          if (i > localObject.length) {
            return -1017;
          }
          paramArrayOfByte = new String((byte[])localObject, 2, j);
          j = i + 8;
          if (j > localObject.length) {
            return -1017;
          }
          long l = util.buf_to_int64((byte[])localObject, i);
          i = j + 2;
          if (i > localObject.length) {
            return -1017;
          }
          int k = util.buf_to_int16((byte[])localObject, j);
          if (k > 0)
          {
            j = i + k;
            if (j > localObject.length) {
              return -1017;
            }
            byte[] arrayOfByte1 = new byte[k];
            System.arraycopy(localObject, i, arrayOfByte1, 0, k);
            i = j + 2;
            if (i > localObject.length) {
              return -1017;
            }
            j = util.buf_to_int16((byte[])localObject, j);
            if (j > 0)
            {
              if (i + j > localObject.length) {
                return -1017;
              }
              byte[] arrayOfByte2 = new byte[j];
              System.arraycopy(localObject, i, arrayOfByte2, 0, j);
              localObject = new byte[3][];
              localObject[0] = new byte[1];
              localObject[0][0] = 2;
              localObject[1] = arrayOfByte1;
              localObject[2] = arrayOfByte2;
              return GetStWithoutPasswd(paramArrayOfByte, l, paramLong, -1L, paramInt, 1L, null, paramWUserSigInfo, null, (byte[][])localObject, 0, null);
            }
            return -1017;
          }
          return -1017;
        }
        return -1017;
      }
      return -1017;
    }
    return -1017;
  }
  
  public Ticket GetTicket(String paramString, long paramLong, int paramInt, WtTicketPromise paramWtTicketPromise, Bundle paramBundle)
  {
    Object localObject2 = new StringBuilder("GetTicket ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append(" sig ");
    ((StringBuilder)localObject2).append(Integer.toHexString(paramInt));
    ((StringBuilder)localObject2).append(" ");
    Object localObject1;
    if (paramBundle == null) {
      localObject1 = "null";
    } else {
      localObject1 = Integer.valueOf(paramBundle.size());
    }
    ((StringBuilder)localObject2).append(localObject1);
    util.LOGI(((StringBuilder)localObject2).toString(), "");
    localObject2 = null;
    int j = 2;
    label446:
    do
    {
      localObject1 = GetLocalSig(paramString, paramLong);
      if (localObject1 == null)
      {
        if (j != 1)
        {
          RefreshMemorySig();
          i = j - 1;
          localObject1 = localObject2;
        }
        else
        {
          localObject1 = localObject2;
          break;
        }
      }
      else
      {
        Ticket localTicket = GetUserSigInfoTicket((WUserSigInfo)localObject1, paramInt);
        if ((localTicket != null) && (localTicket._sig != null) && (localTicket._sig.length != 0))
        {
          long l = u.f();
          if ((paramBundle != null) && (paramInt == 1048576)) {
            localObject1 = paramBundle.getStringArray("domains");
          } else {
            localObject1 = localObject2;
          }
          i = isPskeyExpired(paramInt, (String[])localObject1, localTicket, l, j);
          if (i != 1)
          {
            if (i == 2)
            {
              i = j - 1;
              break label446;
            }
            if (i == 3) {
              return localTicket;
            }
            localObject2 = new StringBuilder("GetTicket sigType:0x");
            ((StringBuilder)localObject2).append(Integer.toHexString(paramInt));
            ((StringBuilder)localObject2).append(" expires in ");
            ((StringBuilder)localObject2).append((localTicket._expire_time - l) / 60L / 60L);
            ((StringBuilder)localObject2).append("h");
            util.LOGI(((StringBuilder)localObject2).toString(), "");
            if (paramInt == 4096)
            {
              if (true == Ticket.isSkeyExpired(localTicket._expire_time))
              {
                if (j != 1)
                {
                  RefreshMemorySig();
                  i = j - 1;
                  break label446;
                }
              }
              else {
                return localTicket;
              }
            }
            else if (l >= localTicket._expire_time)
            {
              if (j != 1)
              {
                RefreshMemorySig();
                i = j - 1;
                break label446;
              }
            }
            else {
              return localTicket;
            }
          }
          break;
        }
        else
        {
          localObject1 = localObject2;
          if (j == 1) {
            break;
          }
          RefreshMemorySig();
          i = j - 1;
          localObject1 = localObject2;
        }
      }
      localObject2 = localObject1;
      j = i;
    } while (i > 0);
    int i = 1;
    if (IsNeedLoginWithPasswd(paramString, paramLong).booleanValue())
    {
      paramBundle = new ErrMsg();
      paramBundle.setType(-1004);
      if (paramWtTicketPromise != null) {
        paramWtTicketPromise.Failed(paramBundle);
      }
    }
    else
    {
      localObject2 = new WUserSigInfo();
      if (paramBundle != null) {
        i = paramBundle.getInt("subappid", 1);
      }
      if (localObject1 != null)
      {
        j = 0;
        int k = Math.min(20, localObject1.length);
        while (j < k)
        {
          paramBundle = localObject1[j];
          if ((paramBundle != null) && (paramBundle.length() > 0)) {
            ((WUserSigInfo)localObject2)._domains.add(paramBundle);
          }
          j += 1;
        }
      }
      GetStWithoutPasswd(paramString, paramLong, paramLong, i, paramInt, (WUserSigInfo)localObject2, new WtloginHelper.1(this, paramString, paramLong, paramInt, paramWtTicketPromise));
    }
    paramWtTicketPromise = new StringBuilder("get null for sigType:0x");
    paramWtTicketPromise.append(Integer.toHexString(paramInt));
    util.LOGI(paramWtTicketPromise.toString(), paramString);
    return null;
  }
  
  public long GetTimeDifference()
  {
    return u.ae;
  }
  
  public Boolean IsNeedLoginWithPasswd(String paramString, long paramLong)
  {
    if (paramString == null) {
      return Boolean.TRUE;
    }
    for (;;)
    {
      try
      {
        boolean bool2 = util.check_uin_account(paramString).booleanValue();
        bool1 = true;
        long l1;
        if (!bool2)
        {
          long l2 = this.mG.b(paramString);
          l1 = l2;
          if (l2 == 0L)
          {
            i = 1;
            continue;
          }
        }
        else
        {
          l1 = Long.parseLong(paramString);
        }
        Object localObject = this.mG.a(l1, paramLong);
        if ((localObject != null) && (((WloginSigInfo)localObject)._en_A1 != null) && (((WloginSigInfo)localObject)._en_A1.length != 0) && (((WloginSigInfo)localObject)._noPicSig != null) && (((WloginSigInfo)localObject)._noPicSig.length != 0))
        {
          i = 2;
          bool1 = false;
        }
        else
        {
          if ((localObject == null) || (((WloginSigInfo)localObject)._TGT == null) || (((WloginSigInfo)localObject)._TGT.length == 0)) {
            break label240;
          }
          if (!((WloginSigInfo)localObject).iSExpireA2(u.f())) {
            break label231;
          }
          break label240;
        }
        localObject = new StringBuilder("NeedLoginWithPasswd:");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(" appid:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" flag=");
        ((StringBuilder)localObject).append(i);
        util.LOGI(((StringBuilder)localObject).toString(), paramString);
        return Boolean.valueOf(bool1);
      }
      finally {}
      label231:
      int i = 0;
      boolean bool1 = false;
      continue;
      label240:
      i = 3;
    }
  }
  
  public Boolean IsUserHaveA1(String paramString, long paramLong)
  {
    if (paramString == null) {
      return Boolean.FALSE;
    }
    long l1;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      long l2 = this.mG.b(paramString);
      l1 = l2;
      if (l2 == 0L)
      {
        localObject = null;
        break label63;
      }
    }
    else
    {
      l1 = Long.parseLong(paramString);
    }
    Object localObject = this.mG.a(l1, paramLong);
    label63:
    if ((localObject != null) && (((WloginSigInfo)localObject)._en_A1 != null) && (((WloginSigInfo)localObject)._en_A1.length > 0))
    {
      localObject = new StringBuilder("userAccount:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" dwAppid:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" IsUserHaveA1 return: not null");
      util.LOGI(((StringBuilder)localObject).toString(), paramString);
      return Boolean.TRUE;
    }
    localObject = new StringBuilder("userAccount:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" dwAppid:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" IsUserHaveA1 return: null");
    util.LOGI(((StringBuilder)localObject).toString(), paramString);
    return Boolean.FALSE;
  }
  
  public boolean IsWtLoginUrl(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int i = paramString.indexOf("?k=");
    if (i != -1)
    {
      i += 3;
      int j = i + 32;
      if (j > paramString.length()) {
        return false;
      }
      paramString = paramString.substring(i, j);
      return util.base64_decode_url(paramString.getBytes(), paramString.length()) != null;
    }
    return false;
  }
  
  public byte[] PickupQRCode(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (!paramString.matches(".*[?&]k=([^&$]+).*")) {
      return null;
    }
    paramString = paramString.replaceAll(".*[?&]k=([^&$]+).*", "$1");
    return util.base64_decode_url(paramString.getBytes(), paramString.length());
  }
  
  public Intent PrepareQloginIntent(long paramLong1, long paramLong2, String paramString)
  {
    Object localObject1 = "com.tencent.mobileqq";
    boolean bool1 = util.isMQQExist(this.mContext);
    boolean bool2 = util.isPackageExist(this.mContext, "com.tencent.minihd.qq");
    if (!bool1) {
      if (bool2) {
        localObject1 = "com.tencent.minihd.qq";
      } else {
        return null;
      }
    }
    Object localObject3 = util.get_rsa_pubkey(this.mContext);
    Object localObject2;
    if (localObject3 != null)
    {
      localObject2 = localObject3;
      if (localObject3.length != 0) {}
    }
    else
    {
      localObject2 = util.string_to_buf("30818902818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d0203010001");
    }
    localObject3 = new Intent();
    ((Intent)localObject3).setClassName((String)localObject1, "com.tencent.open.agent.AgentActivity");
    localObject1 = new Bundle();
    ((Bundle)localObject1).putLong("dstSsoVer", 1L);
    ((Bundle)localObject1).putLong("dstAppid", paramLong1);
    ((Bundle)localObject1).putLong("subDstAppid", paramLong2);
    ((Bundle)localObject1).putByteArray("dstAppVer", paramString.getBytes());
    ((Bundle)localObject1).putByteArray("publickey", (byte[])localObject2);
    ((Intent)localObject3).putExtra("key_params", (Bundle)localObject1);
    ((Intent)localObject3).putExtra("key_action", "action_quick_login");
    return localObject3;
  }
  
  public Intent PrepareQloginResult(String paramString, long paramLong1, long paramLong2, int paramInt, WFastLoginInfo paramWFastLoginInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("quicklogin_uin", paramString);
    paramString = (byte[])paramWFastLoginInfo._outA1.clone();
    if ((paramString != null) && (paramString.length > 0)) {
      localIntent.putExtra("quicklogin_buff", new RSACrypt(this.mContext).EncryptData(util.get_cp_pubkey(this.mContext, paramLong1, paramLong2), paramString));
    }
    localIntent.putExtra("quicklogin_ret", paramInt);
    localIntent.putExtra("user_json", paramWFastLoginInfo.userJson);
    return localIntent;
  }
  
  public Intent PrepareSilenceLoginIntent(long paramLong1, long paramLong2, String paramString)
  {
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
  
  public int QueryCodeResult(long paramLong, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI(" QueryCodeResult ...", "");
    oicq.wlogin_sdk.code2d.e locale = new oicq.wlogin_sdk.code2d.e();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(locale.get_cmd());
    StringBuilder localStringBuilder = new StringBuilder("qrsig ");
    localStringBuilder.append(util.buf_to_string(oicq.wlogin_sdk.code2d.d.i));
    util.LOGI(localStringBuilder.toString());
    localTransReqContext._body = locale.a(0L, paramLong, oicq.wlogin_sdk.code2d.d.i, new byte[0]);
    return RequestTransport(0, 1, null, paramLong, locale._role, localTransReqContext, paramWUserSigInfo);
  }
  
  public void RefreshMemorySig()
  {
    this.mG.k();
  }
  
  public int RefreshPictureData(String paramString, WUserSigInfo paramWUserSigInfo)
  {
    WUserSigInfo localWUserSigInfo = paramWUserSigInfo;
    if (paramWUserSigInfo == null) {
      localWUserSigInfo = new WUserSigInfo();
    }
    return RefreshPictureData(paramString, localWUserSigInfo, 0);
  }
  
  public int RefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte)
  {
    if (paramWUserSigInfo == null) {
      paramWUserSigInfo = new WUserSigInfo();
    }
    return RefreshSMSData(paramString, paramLong, paramWUserSigInfo, paramArrayOfByte, 0);
  }
  
  public int RefreshSMSVerifyLoginCode(String paramString, WUserSigInfo paramWUserSigInfo)
  {
    return RefreshSMSVerifyLoginCode(paramString, paramWUserSigInfo, 0);
  }
  
  public int RegGetAccount(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    return RegGetAccount(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, null, paramInt, paramWUserSigInfo);
  }
  
  public int RegGetAccount(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
    {
      util.LOGI("RegGetAccount ...", "");
      oicq.wlogin_sdk.a.b localb = new oicq.wlogin_sdk.a.b();
      TransReqContext localTransReqContext = new TransReqContext();
      oicq.wlogin_sdk.a.i locali = this.mRegStatus;
      if (paramArrayOfByte1 != null) {
        locali.j = ((byte[])paramArrayOfByte1.clone());
      } else {
        locali.j = new byte[0];
      }
      if ((paramInt == 4) || (paramInt == 5)) {
        locali.b = "";
      }
      oicq.wlogin_sdk.a.i.y = false;
      oicq.wlogin_sdk.a.i.z = 0L;
      localTransReqContext.set_register_req();
      localTransReqContext.set_subcmd(localb.a());
      localTransReqContext._body = localb.a(locali.e, paramArrayOfByte1, paramArrayOfByte3, paramArrayOfByte4, paramInt, locali.b.getBytes(), paramArrayOfByte2, false, GetGuid(), 0L, u.F, paramArrayOfByte5, u.A, paramArrayOfByte6, paramWUserSigInfo.extraRegTLVMap);
      return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.i.i, localTransReqContext, paramWUserSigInfo);
    }
    return -1017;
  }
  
  public int RegGetSMSVerifyLoginAccount(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("RegGetSMSVerifyLoginAccount ...", "");
    oicq.wlogin_sdk.a.b localb = new oicq.wlogin_sdk.a.b();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.i locali = this.mRegStatus;
    if (paramArrayOfByte1 != null) {
      locali.j = ((byte[])paramArrayOfByte1.clone());
    } else {
      locali.j = new byte[0];
    }
    oicq.wlogin_sdk.a.i.y = true;
    oicq.wlogin_sdk.a.i.A = util.get_mpasswd();
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(localb.a());
    localTransReqContext._body = localb.a(locali.e, paramArrayOfByte1, oicq.wlogin_sdk.a.i.A.getBytes(), paramArrayOfByte3, 1, locali.b.getBytes(), paramArrayOfByte2, true, GetGuid(), locali.h, u.F, paramArrayOfByte4, u.A, null, paramWUserSigInfo.extraRegTLVMap);
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.i.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RegQueryAccount(int paramInt, byte[] paramArrayOfByte, long paramLong, WUserSigInfo paramWUserSigInfo)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = new byte[0];
    }
    util.LOGI("RegQueryAccount ...", "");
    this.mRegStatus = new oicq.wlogin_sdk.a.i();
    this.mRegStatus.b = new String(paramArrayOfByte);
    oicq.wlogin_sdk.a.c localc = new oicq.wlogin_sdk.a.c();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(localc.a());
    localTransReqContext._body = localc.a(paramInt, paramArrayOfByte, paramLong);
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.i.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RegQueryClientSentMsgStatus(WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("RegQueryClientSentMsgStatus ...", "");
    oicq.wlogin_sdk.a.d locald = new oicq.wlogin_sdk.a.d();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.i locali = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(locald.a());
    localTransReqContext._body = locald.b(locali.e, this.mRegStatus.p);
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.i.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RegRequestServerResendMsg(WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("RegRequestServerResendMsg ...", "");
    oicq.wlogin_sdk.a.e locale = new oicq.wlogin_sdk.a.e();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.i locali = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(locale.a());
    localTransReqContext._body = locale.b(locali.e, null);
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.i.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RegSubmitMobile(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo, Map<String, Object> paramMap)
  {
    if (paramString == null) {
      paramString = new byte[0];
    } else {
      paramString = paramString.getBytes();
    }
    return RegSubmitMobile(paramString, paramArrayOfByte1, null, paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramWUserSigInfo, paramMap);
  }
  
  public int RegSubmitMobile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    return RegSubmitMobile(null, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramWUserSigInfo, null);
  }
  
  public int RegSubmitMsgChk(byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    if (paramArrayOfByte == null) {
      return -1017;
    }
    util.LOGI("RegSubmitMsgChk ...", "");
    oicq.wlogin_sdk.a.h localh = new oicq.wlogin_sdk.a.h();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.i locali = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(localh.a());
    localTransReqContext._body = localh.b(locali.e, paramArrayOfByte);
    return RequestTransport(0, 1, null, 0L, oicq.wlogin_sdk.a.i.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RequestTransport(int paramInt1, int paramInt2, String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo)
  {
    if (paramInt1 == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramInt2, paramString, paramLong1, paramLong2, paramTransReqContext, paramWUserSigInfo, "RequestTransport").RunReq(9);
      return -1001;
    }
    u localu = this.mG.a(0L);
    Object localObject = new StringBuilder("encrypt:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" appid:");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(" role:");
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append(" Seq:");
    ((StringBuilder)localObject).append(localu.h);
    ((StringBuilder)localObject).append("subcmd=");
    ((StringBuilder)localObject).append(paramTransReqContext._subcmd);
    ((StringBuilder)localObject).append(" RequestTransport...");
    util.LOGI(((StringBuilder)localObject).toString(), paramString);
    localu.g = paramString;
    if (paramInt2 != 0)
    {
      if (paramString == null)
      {
        localu.m = 0;
        paramInt1 = new ac(localu).a(0L, paramTransReqContext, null, null, paramLong1, paramLong2, paramWUserSigInfo);
      }
      else
      {
        localObject = new WloginSimpleInfo();
        if ((paramString != null) && (GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject).booleanValue()))
        {
          WloginSigInfo localWloginSigInfo = localu.a(((WloginSimpleInfo)localObject)._uin, paramLong1);
          if (localWloginSigInfo == null)
          {
            paramInt1 = -1004;
          }
          else
          {
            localu.f = ((WloginSimpleInfo)localObject)._uin;
            paramInt1 = new ac(localu).a(((WloginSimpleInfo)localObject)._uin, paramTransReqContext, localWloginSigInfo._userStSig, localWloginSigInfo._userSt_Key, paramLong1, paramLong2, paramWUserSigInfo);
          }
        }
        else
        {
          paramInt1 = -1003;
        }
      }
    }
    else
    {
      localu.f = 0L;
      paramInt1 = new ac(localu).a(localu.f, paramTransReqContext, null, null, paramLong1, paramLong2, paramWUserSigInfo);
    }
    localu.j();
    paramWUserSigInfo = new StringBuilder("encrypt:");
    paramWUserSigInfo.append(paramInt2);
    paramWUserSigInfo.append(" appid:");
    paramWUserSigInfo.append(paramLong1);
    paramWUserSigInfo.append(" role:");
    paramWUserSigInfo.append(paramLong2);
    paramWUserSigInfo.append(" Seq:");
    paramWUserSigInfo.append(localu.h);
    paramWUserSigInfo.append("subcmd=");
    paramWUserSigInfo.append(paramTransReqContext._subcmd);
    paramWUserSigInfo.append(" RequestTransport ret=");
    paramWUserSigInfo.append(paramInt1);
    util.LOGI(paramWUserSigInfo.toString(), paramString);
    return paramInt1;
  }
  
  public int RequestTransportMsf(int paramInt1, int paramInt2, String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext)
  {
    if (paramInt1 == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramInt2, paramString, paramLong1, paramLong2, paramTransReqContext, "RequestTransportMsf").RunReq(10);
      return -1001;
    }
    u localu = this.mG.a(0L);
    Object localObject1 = new StringBuilder("user:");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" encrypt:");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(" appid:");
    ((StringBuilder)localObject1).append(paramLong1);
    ((StringBuilder)localObject1).append(" role:");
    ((StringBuilder)localObject1).append(paramLong2);
    ((StringBuilder)localObject1).append(" Seq:");
    ((StringBuilder)localObject1).append(localu.h);
    ((StringBuilder)localObject1).append(" RequestTransportMsf...");
    util.LOGI(((StringBuilder)localObject1).toString(), paramString);
    localu.g = paramString;
    paramInt1 = -1004;
    Object localObject2;
    if (paramInt2 != 0)
    {
      localObject1 = new WloginSimpleInfo();
      if ((paramString != null) && (GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1).booleanValue()))
      {
        localObject2 = localu.a(((WloginSimpleInfo)localObject1)._uin, paramLong1);
        if (localObject2 != null)
        {
          localu.f = ((WloginSimpleInfo)localObject1)._uin;
          paramInt1 = new ac(localu).a(((WloginSimpleInfo)localObject1)._uin, paramTransReqContext, ((WloginSigInfo)localObject2)._userStSig, ((WloginSigInfo)localObject2)._userSt_Key, ((WloginSigInfo)localObject2)._TGT, paramLong1, paramLong2, new WUserSigInfo());
        }
      }
      else
      {
        paramInt1 = -1003;
      }
    }
    else if ((util.check_uin_account(paramString).booleanValue()) && (Long.parseLong(paramString) == 0L))
    {
      localu.f = 0L;
      localObject1 = new ac(localu);
      localObject2 = new WUserSigInfo();
      paramInt1 = ((ac)localObject1).a(0L, paramTransReqContext, null, null, new byte[0], paramLong1, paramLong2, (WUserSigInfo)localObject2);
    }
    else
    {
      localObject1 = new WloginSimpleInfo();
      if ((paramString != null) && (GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1).booleanValue()))
      {
        localObject2 = localu.a(((WloginSimpleInfo)localObject1)._uin, paramLong1);
        if (localObject2 != null)
        {
          localu.f = ((WloginSimpleInfo)localObject1)._uin;
          paramInt1 = new ac(localu).a(((WloginSimpleInfo)localObject1)._uin, paramTransReqContext, null, null, ((WloginSigInfo)localObject2)._TGT, paramLong1, paramLong2, new WUserSigInfo());
        }
      }
      else
      {
        paramInt1 = -1003;
      }
    }
    localu.j();
    paramTransReqContext = new StringBuilder("user:");
    paramTransReqContext.append(paramString);
    paramTransReqContext.append(" encrypt:");
    paramTransReqContext.append(paramInt2);
    paramTransReqContext.append(" appid:");
    paramTransReqContext.append(paramLong1);
    paramTransReqContext.append(" role:");
    paramTransReqContext.append(paramLong2);
    paramTransReqContext.append(" Seq:");
    paramTransReqContext.append(localu.h);
    paramTransReqContext.append(" RequestTransportMsf ret=");
    paramTransReqContext.append(paramInt1);
    util.LOGI(paramTransReqContext.toString(), paramString);
    return paramInt1;
  }
  
  public WUserSigInfo ResolveQloginIntentReserved(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    if (paramIntent.getExtras().getInt("quicklogin_ret") != 0)
    {
      util.LOGI("ResolveQloginIntentReserved quicklogin_ret is null", "");
      return null;
    }
    String str = paramIntent.getExtras().getString("quicklogin_uin");
    paramIntent = paramIntent.getExtras().getByteArray("quicklogin_buff");
    if ((str != null) && (paramIntent != null))
    {
      WUserSigInfo localWUserSigInfo = new WUserSigInfo();
      localWUserSigInfo._fastLoginBuf = new RSACrypt(this.mContext).DecryptData(null, paramIntent);
      if (localWUserSigInfo._fastLoginBuf == null)
      {
        util.LOGI("rsa decrypt failed", "");
        return null;
      }
      localWUserSigInfo.uin = str;
      return localWUserSigInfo;
    }
    util.LOGI("ResolveQloginIntentReserved uin or buff is null", "");
    return null;
  }
  
  public void SetAppClientVersion(int paramInt)
  {
    u.x = paramInt;
  }
  
  public void SetCanWebVerify(int paramInt)
  {
    m.K = paramInt;
    StringBuilder localStringBuilder = new StringBuilder("SetCanWebVerify old:");
    localStringBuilder.append(m.K);
    localStringBuilder.append(" canWebVerify:");
    localStringBuilder.append(paramInt);
    util.LOGI(localStringBuilder.toString(), "");
  }
  
  public void SetDevlockMobileType(int paramInt)
  {
    t.K = paramInt;
  }
  
  public void SetImgType(int paramInt)
  {
    u.y = paramInt;
    this.mMiscBitmap |= 0x80;
  }
  
  public WtloginListener SetListener(WtloginListener paramWtloginListener)
  {
    WtloginListener localWtloginListener = this.mListener;
    this.mListener = paramWtloginListener;
    return localWtloginListener;
  }
  
  public void SetLocalId(int paramInt)
  {
    u.v = paramInt;
  }
  
  public void SetMsfTransportFlag(int paramInt)
  {
    u localu = this.mG;
    localu.k = paramInt;
    if (paramInt != 0)
    {
      u.ag = new byte[4];
      u.af = 0L;
      localu.l = 45000;
    }
  }
  
  public int SetNeedForPayToken(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      m.L = paramString1.getBytes();
      if (paramArrayOfByte != null) {
        m.N = paramArrayOfByte;
      }
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (paramString2.length() != 0) {}
      }
      else
      {
        paramString1 = util.getChannelId(this.mContext, null);
      }
      m.M = paramString1.getBytes();
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        return 0;
      }
      return -2;
    }
    return -1;
  }
  
  public void SetPicType(int paramInt)
  {
    u.z = paramInt;
  }
  
  public void SetRegDevLockFlag(int paramInt)
  {
    u.A = paramInt;
  }
  
  public void SetSigMap(int paramInt)
  {
    this.mMainSigMap = (paramInt | 0xC0);
  }
  
  public void SetTestHost(int paramInt, String paramString)
  {
    oicq_request.a(paramInt, paramString);
  }
  
  public void SetTimeOut(int paramInt)
  {
    this.mG.l = paramInt;
  }
  
  public void SetUinDeviceToken(boolean paramBoolean)
  {
    u.ac = paramBoolean;
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
    localObject1 = new tlv_t400();
    if ((localWloginSigInfo._G != null) && (localWloginSigInfo._G.length > 0) && (localWloginSigInfo._dpwd != null) && (localWloginSigInfo._dpwd.length > 0) && (localWloginSigInfo._randseed != null) && (localWloginSigInfo._randseed.length > 0))
    {
      ((tlv_t400)localObject1).get_tlv_400(localWloginSigInfo._G, l, u.B, localWloginSigInfo._dpwd, paramLong, 1L, localWloginSigInfo._randseed);
      localObject1 = ((tlv_t400)localObject1).get_data();
    }
    else
    {
      localObject1 = new byte[0];
    }
    Object localObject2 = new StringBuilder("user:");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" VerifyCode ...");
    util.LOGI(((StringBuilder)localObject2).toString(), paramString);
    localObject2 = new oicq.wlogin_sdk.code2d.f();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(((oicq.wlogin_sdk.code2d.f)localObject2).get_cmd());
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST(localWloginSigInfo);
    localTransReqContext._body = ((oicq.wlogin_sdk.code2d.f)localObject2).a(l, paramLong, paramBoolean, paramArrayOfByte, paramArrayOfInt, localWloginSigInfo._TGT, u.B, u.F, paramInt, (byte[])localObject1);
    return RequestTransport(0, 1, paramString, paramLong, ((oicq.wlogin_sdk.code2d.f)localObject2)._role, localTransReqContext, paramWUserSigInfo);
  }
  
  public int VerifySMSVerifyLoginCode(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return VerifySMSVerifyLoginCode(paramString1, paramString2, paramWUserSigInfo, 0);
  }
  
  public int cancelCode(String paramString, long paramLong, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject1 = new WloginSimpleInfo();
    if (!GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1).booleanValue()) {
      return -1003;
    }
    long l = ((WloginSimpleInfo)localObject1)._uin;
    this.mG.k();
    localObject1 = FindUserSig(l, paramLong);
    if (localObject1 == null) {
      return -1004;
    }
    Object localObject2 = new StringBuilder("user:");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" CancelCode ...");
    util.LOGI(((StringBuilder)localObject2).toString(), paramString);
    localObject2 = new oicq.wlogin_sdk.code2d.a();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(((oicq.wlogin_sdk.code2d.a)localObject2).get_cmd());
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST((WloginSigInfo)localObject1);
    localTransReqContext._body = ((oicq.wlogin_sdk.code2d.a)localObject2).a(l, paramLong, paramArrayOfByte, ((WloginSigInfo)localObject1)._TGT);
    return RequestTransport(0, 1, paramString, paramLong, ((oicq.wlogin_sdk.code2d.a)localObject2)._role, localTransReqContext, paramWUserSigInfo);
  }
  
  protected int checkSMSAndGetStForGateWay(u paramu, async_context paramasync_context, String paramString, byte[] paramArrayOfByte1, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2)
  {
    paramString = new StringBuilder("checkSMSAndGetStForGateWay");
    paramString.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
    paramString.append(",seq=");
    paramString.append(paramu.h);
    paramString.append(",_mpasswd=");
    paramString.append(paramasync_context._mpasswd);
    paramString.append(",_msalt=");
    paramString.append(Long.toHexString(paramasync_context._msalt));
    paramString.append(",_appid=");
    paramString.append(paramasync_context._appid);
    paramString.append(",_sub_appid=");
    paramString.append(paramasync_context._sappid);
    paramString.append(",_sappid=");
    paramString.append(paramasync_context._sub_appid);
    paramString.append(",dwMainSigMap=");
    paramString.append(paramasync_context._main_sigmap);
    paramu.f = 0L;
    paramWUserSigInfo.uin = "";
    int i = new q(paramu).b(2).a(paramArrayOfByte1, this.mMiscBitmap, this.mSubSigMap, paramasync_context._sub_appid_list, paramWUserSigInfo, paramArrayOfByte2);
    if (i != 0)
    {
      paramString.append("，request_checksms fail ret = ");
      paramString.append(i);
      util.LOGI(paramString.toString(), "");
      return i;
    }
    long l1 = paramasync_context._sappid;
    long l2 = paramasync_context._sappid;
    i = paramasync_context._main_sigmap;
    paramString.append("，_ui=");
    paramString.append(paramu.f);
    paramWUserSigInfo.uin = String.valueOf(paramu.f);
    i = getTicketByGateway(l1, l2, i, paramWUserSigInfo, paramString, paramu, paramasync_context);
    util.LOGI(paramString.toString(), "");
    return i;
  }
  
  public boolean getHasPassword(long paramLong)
  {
    String str = this.mG.e(paramLong);
    Object localObject = new StringBuilder("getHasPasswd ...");
    ((StringBuilder)localObject).append(String.valueOf(str));
    util.LOGI(((StringBuilder)localObject).toString(), String.valueOf(paramLong));
    if (str == null) {
      return true;
    }
    localObject = this.mG.c(str);
    if (localObject == null) {
      return true;
    }
    boolean bool = ((UinInfo)localObject).getHasPassword();
    localObject = new StringBuilder("getHasPasswd userAccount: ");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(", uin: ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" hasPasswd: ");
    ((StringBuilder)localObject).append(bool);
    util.LOGI(((StringBuilder)localObject).toString(), "");
    return bool;
  }
  
  public int getStWithQrSig(String paramString, long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    return getStWithQrSig(paramString, paramLong1, paramLong2, paramInt, paramWUserSigInfo, 0);
  }
  
  public String getUserAccountFromQuickLoginResultData(Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("isRetFromWeb", false);
    util.LOGI("getUserAccountFromQuickLoginResultData isRetFromWeb ".concat(String.valueOf(bool)));
    if (!bool) {
      paramIntent = paramIntent.getStringExtra("quicklogin_uin");
    } else {
      paramIntent = paramIntent.getStringExtra("uin");
    }
    Object localObject = paramIntent;
    if (paramIntent == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public String getUserInputFromQuickLoginResultData(Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("isRetFromWeb", false);
    util.LOGI("getUserAccountFromQuickLoginResultData isRetFromWeb ".concat(String.valueOf(bool)));
    if (true == bool) {
      return paramIntent.getStringExtra("input");
    }
    return "";
  }
  
  public int modifyQIMPassword(int paramInt, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      util.LOGI("modifyQIMPassword : cmd=".concat(String.valueOf(paramInt)));
      TransReqContext localTransReqContext = new TransReqContext();
      localTransReqContext.set_register_req();
      localTransReqContext.set_subcmd(paramInt);
      localTransReqContext._body = paramArrayOfByte;
      int i = 6084;
      if (paramInt == 1749) {
        i = 5063;
      }
      return RequestTransport(0, 1, null, 16L, i, localTransReqContext, paramWUserSigInfo);
    }
    return -1017;
  }
  
  public int onQuickLoginActivityResultData(QuickLoginParam paramQuickLoginParam, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      util.LOGI("onActivityResultData data is null", "");
      return -1017;
    }
    if (paramQuickLoginParam == null)
    {
      util.LOGI("onActivityResultData quickLoginParam is null", "");
      return -1017;
    }
    boolean bool = paramIntent.getBooleanExtra("isRetFromWeb", false);
    util.LOGI("onQuickLoginActivityResultData isRetFromWeb ".concat(String.valueOf(bool)), "");
    if (!bool)
    {
      paramIntent = ResolveQloginIntentReserved(paramIntent);
      if (paramIntent == null)
      {
        util.LOGI("onActivityResultData ResolveQloginIntent failed", "");
        return -1017;
      }
      StringBuilder localStringBuilder = new StringBuilder("onActivityResultData userSigInfo form QQ :uin=");
      localStringBuilder.append(paramIntent.uin);
      util.LOGI(localStringBuilder.toString(), "");
      paramQuickLoginParam.userSigInfo.uin = paramIntent.uin;
      paramQuickLoginParam.userSigInfo._fastLoginBuf = paramIntent._fastLoginBuf;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramIntent.uin);
      return getStWithQQSig(localStringBuilder.toString(), paramQuickLoginParam);
    }
    paramQuickLoginParam.userAccount = getUserInputFromQuickLoginResultData(paramIntent);
    return getStWithPtSig(paramIntent.getStringExtra("uin"), paramIntent.getStringExtra("sig"), paramQuickLoginParam);
  }
  
  public int quickLogin(Activity paramActivity, long paramLong1, long paramLong2, String paramString, QuickLoginParam paramQuickLoginParam)
  {
    Object localObject = new StringBuilder("quickLogin start ");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    util.LOGI(((StringBuilder)localObject).toString(), "");
    try
    {
      localObject = Class.forName("oicq.wlogin_sdk.quicklogin.QuickLogin").getMethod("jumpToLoginActivity", new Class[] { Context.class, Activity.class, Long.TYPE, Long.TYPE, String.class, QuickLoginParam.class });
    }
    catch (Exception paramActivity)
    {
      int i;
      label143:
      break label143;
    }
    try
    {
      i = ((Integer)((Method)localObject).invoke(null, new Object[] { this.mContext, paramActivity, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, paramQuickLoginParam })).intValue();
      return i;
    }
    catch (Exception paramActivity) {}
    return 0;
    return 0;
  }
  
  public int quickLoginByGateway(long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    return quickLoginByGateway(paramLong1, paramLong2, paramInt, paramWUserSigInfo, 0);
  }
  
  public int quickLoginByWeChat(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, QuickLoginParam paramQuickLoginParam, int paramInt)
  {
    if (paramInt == 0)
    {
      new HelperThread(this, this.mHelperHandler, "", paramArrayOfByte1, paramArrayOfByte2, paramQuickLoginParam, "quickLoginByWeChat").RunReq(18);
      return -1001;
    }
    WUserSigInfo localWUserSigInfo = paramQuickLoginParam.userSigInfo;
    u localu = this.mG.a(0L);
    localu.g = paramQuickLoginParam.userAccount;
    localWUserSigInfo._seqence = localu.h;
    this.mAysncSeq = localu.h;
    async_context localasync_context = u.b(localu.h);
    StringBuilder localStringBuilder = new StringBuilder("quickLoginByWeChat seq:");
    localStringBuilder.append(localu.h);
    util.LOGI(localStringBuilder.toString(), "");
    localasync_context._last_err_msg = new ErrMsg();
    paramQuickLoginParam.sigMap |= 0xC0;
    localasync_context._mpasswd = util.get_mpasswd();
    localasync_context._msalt = util.constructSalt();
    localasync_context._sappid = paramQuickLoginParam.appid;
    localasync_context._appid = paramQuickLoginParam.appid;
    localasync_context._sub_appid = paramQuickLoginParam.subAppid;
    localasync_context._main_sigmap = paramQuickLoginParam.sigMap;
    localasync_context._sub_appid_list = paramQuickLoginParam.dstSubAppidList;
    paramInt = new w(localu).a(paramArrayOfByte1, paramArrayOfByte2, localWUserSigInfo);
    util.LOGI("quickLoginByWeChat request_login_by_wechat ret".concat(String.valueOf(paramInt)));
    if (paramInt != 0)
    {
      paramArrayOfByte1 = new StringBuilder("quickLoginByWeChat seq ");
      paramArrayOfByte1.append(localu.h);
      paramArrayOfByte1.append(" ret ");
      paramArrayOfByte1.append(paramInt);
      util.LOGI(paramArrayOfByte1.toString());
      return paramInt;
    }
    localasync_context._tmp_pwd = MD5.toMD5Byte(localasync_context._mpasswd.getBytes());
    paramArrayOfByte1 = new m(localu, this.mContext);
    paramArrayOfByte1.g();
    paramInt = paramArrayOfByte1.a(paramQuickLoginParam.appid, paramQuickLoginParam.subAppid, localu.f, 0, u.ag, util.getRequestInitTime(), localasync_context._tmp_pwd, 4, this.mMiscBitmap, this.mSubSigMap, paramQuickLoginParam.dstSubAppidList, paramQuickLoginParam.sigMap, paramQuickLoginParam.subAppid, u.z, 0, 0, 1, u.ad, localWUserSigInfo);
    if (paramInt == 204)
    {
      paramArrayOfByte1 = new StringBuilder("quickLoginByWeChat seq:");
      paramArrayOfByte1.append(localu.h);
      paramArrayOfByte1.append(" ret:SEC_GUID");
      util.LOGI(paramArrayOfByte1.toString(), "");
      paramInt = new r(localu).a(this.mMiscBitmap, this.mSubSigMap, paramQuickLoginParam.dstSubAppidList, localWUserSigInfo);
    }
    if (paramInt != 0)
    {
      paramArrayOfByte1 = new StringBuilder("quickLoginByWeChat seq:");
      paramArrayOfByte1.append(localu.h);
      paramArrayOfByte1.append(" ret:");
      paramArrayOfByte1.append(paramInt);
      util.LOGI(paramArrayOfByte1.toString(), "");
      return paramInt;
    }
    paramArrayOfByte1 = localu.a(localu.f, paramQuickLoginParam.appid);
    if (paramArrayOfByte1 == null)
    {
      util.LOGI("quickLoginByWeChat WloginSigInfo is null", "");
      return -1004;
    }
    localWUserSigInfo.get_clone(paramArrayOfByte1);
    paramArrayOfByte1 = GetUserSigInfoTicket(localWUserSigInfo, 128);
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte1 = new Ticket();
    }
    u.at.commit_t2(localu.f, localu.g, util.format_ret_code(paramInt), paramInt);
    if (paramInt == 0)
    {
      if ((paramArrayOfByte1._sig != null) && (paramArrayOfByte1._sig.length != 0)) {
        RequestReport(0, paramArrayOfByte1._sig, paramArrayOfByte1._sig_key, localu.f, localasync_context._appid);
      }
    }
    else
    {
      int i = paramInt;
      paramArrayOfByte2 = paramArrayOfByte1;
      if ((i != 2) && (i != 160)) {
        RequestReportError(0, paramArrayOfByte2._sig, paramArrayOfByte2._sig_key, localu.f, localasync_context._appid, 0);
      }
    }
    if ((localu.d != null) && (localu.d.get_bitmap() != 0))
    {
      this.mG.d = localu.d;
      RequestReportError(0, paramArrayOfByte1._sig, paramArrayOfByte1._sig_key, localu.f, localasync_context._appid, 1);
    }
    oicq.wlogin_sdk.report.c.a();
    u.b();
    localu.i();
    paramArrayOfByte1 = new StringBuilder("quickLoginByWeChat seq:");
    paramArrayOfByte1.append(localu.h);
    paramArrayOfByte1.append(" ret ");
    paramArrayOfByte1.append(paramInt);
    util.LOGI(paramArrayOfByte1.toString(), "");
    return paramInt;
  }
  
  public int quickRegisterCheckAccount(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    return 0;
  }
  
  public int quickRegisterGetAccount(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, WUserSigInfo paramWUserSigInfo)
  {
    return 0;
  }
  
  public void setBabyQFlg(boolean paramBoolean)
  {
    u.aj = paramBoolean;
  }
  
  public void setCallSource(int paramInt)
  {
    u.ai = paramInt;
  }
  
  public void setForQCall()
  {
    u.ax = true;
    WtloginMsfListener.CLIENT_CLASSNAME = "com.tencent.lightalk.msf.core.auth.WtProvider";
  }
  
  public void setHasPassword(long paramLong, boolean paramBoolean)
  {
    String str = this.mG.e(paramLong);
    StringBuilder localStringBuilder = new StringBuilder("setHasPasswd ...");
    localStringBuilder.append(String.valueOf(str));
    util.LOGI(localStringBuilder.toString(), "");
    if (str == null) {
      return;
    }
    this.mG.a(str, Long.valueOf(paramLong), paramBoolean);
    localStringBuilder = new StringBuilder("setHasPasswd userAccount: ");
    localStringBuilder.append(str);
    localStringBuilder.append(", uin: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" hasPassword:");
    localStringBuilder.append(paramBoolean);
    util.LOGI(localStringBuilder.toString(), "");
  }
  
  public void setMsgType(int paramInt1, int paramInt2, int paramInt3)
  {
    oicq.wlogin_sdk.devicelock.DevlockBase.a.a = paramInt1;
    oicq.wlogin_sdk.devicelock.DevlockBase.a.b = paramInt2;
    oicq.wlogin_sdk.devicelock.DevlockBase.a.c = paramInt3;
  }
  
  static class A1AndNopicSig
  {
    byte[] a1 = null;
    byte[] noPicSig = null;
  }
  
  static class A1SRC
  {
    public static final int A1SRC_PASSWORD = 1;
    public static final int A1SRC_PTSIG = 4;
    public static final int A1SRC_QUICKLOGIN = 2;
    public static final int A1SRC_SMS = 3;
  }
  
  public class HelperThread
    extends Thread
  {
    public static final String THREAD_NAME_PRE = "Wtlogin_";
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
    byte[] mExtraData;
    int mExtraFlag = 1;
    long mExtraUin = -1L;
    WFastLoginInfo mFastLoginInfo;
    Handler mHandler;
    WtloginHelper mHelper;
    boolean mIsSmslogin = false;
    String mMsgCode;
    byte[] mPictureData;
    WtTicketPromise mPromise;
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
    byte[] mWxAppid;
    String ptSig;
    WtloginHelper.QuickLoginParam quickLoginParam;
    byte[] weChatCode;
    
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
      setName("Wtlogin_".concat(String.valueOf(paramString2)));
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
      setName("Wtlogin_".concat(String.valueOf(paramString2)));
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo, String paramString)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mAppid1 = paramLong1;
      this.mSubAppid1 = paramLong2;
      this.mUserSigInfo = paramWUserSigInfo;
      this.mDwMainSigMap = paramInt;
      setName("Wtlogin_".concat(String.valueOf(paramString)));
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, long paramLong1, long paramLong2, String paramString1, int paramInt, long paramLong3, WUserSigInfo paramWUserSigInfo, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mAppid1 = paramLong1;
      this.mSubAppid1 = paramLong2;
      this.mUserSigInfo = paramWUserSigInfo;
      this.mExtraFlag = paramInt;
      this.mExtraUin = paramLong3;
      setName("Wtlogin_".concat(String.valueOf(paramString2)));
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, long paramLong, String paramString)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUIN = paramLong;
      setName("Wtlogin_".concat(String.valueOf(paramString)));
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, long paramLong1, int paramInt, long paramLong2, WUserSigInfo paramWUserSigInfo, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mDwAppid = paramLong1;
      this.mDwMainSigMap = paramInt;
      this.mDwSubDstAppid = paramLong2;
      this.mUserSigInfo = paramWUserSigInfo;
      setName("Wtlogin_".concat(String.valueOf(paramString2)));
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
      setName("Wtlogin_".concat(String.valueOf(paramString3)));
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
      setName("Wtlogin_".concat(String.valueOf(paramString2)));
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mSmsAppid = paramLong;
      this.mUserSigInfo = paramWUserSigInfo;
      this.mExtraData = paramArrayOfByte;
      setName("Wtlogin_".concat(String.valueOf(paramString2)));
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, String paramString3)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mMsgCode = paramString2;
      this.mUserSigInfo = paramWUserSigInfo;
      setName("Wtlogin_".concat(String.valueOf(paramString3)));
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, String paramString2, WtloginHelper.QuickLoginParam paramQuickLoginParam, String paramString3)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.ptSig = paramString2;
      this.quickLoginParam = paramQuickLoginParam;
      this.mUserSigInfo = paramQuickLoginParam.userSigInfo;
      setName("Wtlogin_".concat(String.valueOf(paramString3)));
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, WUserSigInfo paramWUserSigInfo, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mUserSigInfo = paramWUserSigInfo;
      setName("Wtlogin_".concat(String.valueOf(paramString2)));
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, WtloginHelper.QuickLoginParam paramQuickLoginParam, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.quickLoginParam = paramQuickLoginParam;
      this.mUserSigInfo = paramQuickLoginParam.userSigInfo;
      setName("Wtlogin_".concat(String.valueOf(paramString2)));
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mUserInput = paramArrayOfByte;
      this.mUserSigInfo = paramWUserSigInfo;
      this.mST = paramArrayOfByte1;
      setName("Wtlogin_".concat(String.valueOf(paramString2)));
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, byte[] paramArrayOfByte1, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, byte[] paramArrayOfByte2, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mUserInput = paramArrayOfByte1;
      this.mUserSigInfo = paramWUserSigInfo;
      this.mST = paramArrayOfByte;
      this.mExtraData = paramArrayOfByte2;
      setName("Wtlogin_".concat(String.valueOf(paramString2)));
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, WtloginHelper.QuickLoginParam paramQuickLoginParam, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.weChatCode = paramArrayOfByte2;
      this.mWxAppid = paramArrayOfByte1;
      this.quickLoginParam = paramQuickLoginParam;
      this.mUserSigInfo = paramQuickLoginParam.userSigInfo;
      setName(paramString2);
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, WtTicketPromise paramWtTicketPromise, String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mPromise = paramWtTicketPromise;
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
      setName("Wtlogin_".concat(String.valueOf(paramString2)));
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
      setName("Wtlogin_".concat(String.valueOf(paramString)));
    }
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, String paramString)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mST1 = paramArrayOfByte1;
      this.mST1Key = paramArrayOfByte2;
      this.mUIN = paramLong1;
      this.mDwAppid = paramLong2;
      setName("Wtlogin_".concat(String.valueOf(paramString)));
    }
    
    private void quitSelfLooper()
    {
      try
      {
        if (this.isSelfLooper)
        {
          Looper localLooper = Looper.myLooper();
          if (localLooper != null) {
            localLooper.quit();
          }
          this.mHandler = null;
        }
        return;
      }
      catch (Exception localException)
      {
        util.printException(localException, "");
      }
    }
    
    private void saveContextCommonDataIntoExtentMap(async_context paramasync_context)
    {
      StringBuilder localStringBuilder;
      if (paramasync_context._t543 != null)
      {
        localStringBuilder = new StringBuilder("context from seq ");
        localStringBuilder.append(this.mUserSigInfo._seqence);
        localStringBuilder.append(" tlv543 length ");
        localStringBuilder.append(paramasync_context._t543.get_data_len());
        util.LOGI(localStringBuilder.toString(), this.mUserAccount);
        this.mUserSigInfo.loginResultTLVMap.put(Integer.valueOf(1347), paramasync_context._t543);
      }
      if (paramasync_context.tlv543In119 != null)
      {
        localStringBuilder = new StringBuilder("context from seq ");
        localStringBuilder.append(this.mUserSigInfo._seqence);
        localStringBuilder.append(" tlv543In119 length ");
        localStringBuilder.append(paramasync_context.tlv543In119.get_data_len());
        util.LOGI(localStringBuilder.toString(), this.mUserAccount);
        this.mUserSigInfo.loginResultTLVMap.put(Integer.valueOf(1676611), paramasync_context.tlv543In119);
      }
    }
    
    private void saveContextDataIntoExtentMap(async_context paramasync_context, int paramInt)
    {
      StringBuilder localStringBuilder;
      if ((paramInt == 0) && (paramasync_context.tlv528 != null))
      {
        localStringBuilder = new StringBuilder("context from seq ");
        localStringBuilder.append(this.mUserSigInfo._seqence);
        localStringBuilder.append(" tlv528 length ");
        localStringBuilder.append(paramasync_context.tlv528.get_data_len());
        util.LOGI(localStringBuilder.toString(), this.mUserAccount);
        this.mUserSigInfo.loginResultTLVMap.put(Integer.valueOf(1320), paramasync_context.tlv528);
      }
      if ((paramInt == 0) && (paramasync_context.tlv530 != null))
      {
        localStringBuilder = new StringBuilder("context from seq ");
        localStringBuilder.append(this.mUserSigInfo._seqence);
        localStringBuilder.append(" tlv530 length ");
        localStringBuilder.append(paramasync_context.tlv530.get_data_len());
        util.LOGI(localStringBuilder.toString(), this.mUserAccount);
        this.mUserSigInfo.loginResultTLVMap.put(Integer.valueOf(1328), paramasync_context.tlv530);
      }
      if ((paramInt == 0) && (paramasync_context.tlv113 != null))
      {
        localStringBuilder = new StringBuilder("context from seq ");
        localStringBuilder.append(this.mUserSigInfo._seqence);
        localStringBuilder.append(" tlv113 length ");
        localStringBuilder.append(paramasync_context.tlv113.get_data_len());
        util.LOGI(localStringBuilder.toString(), this.mUserAccount);
        this.mUserSigInfo.loginResultTLVMap.put(Integer.valueOf(275), paramasync_context.tlv113);
      }
    }
    
    private void saveContextSigSessionDataIntoExtentMap(async_context paramasync_context)
    {
      if (paramasync_context._t104 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder("context from seq ");
        localStringBuilder.append(this.mUserSigInfo._seqence);
        localStringBuilder.append(" tlv104 length ");
        localStringBuilder.append(paramasync_context._t104.get_data_len());
        util.LOGI(localStringBuilder.toString(), this.mUserAccount);
        this.mUserSigInfo.loginResultTLVMap.put(Integer.valueOf(260), paramasync_context._t104);
      }
    }
    
    public void RunReq(int paramInt)
    {
      this.mReqType = paramInt;
      if (this.mReqType == 7)
      {
        start();
        return;
      }
      synchronized (WtloginHelper.__sync_top)
      {
        Object localObject2 = new Timer();
        WtloginHelper.HelperThread.1 local1 = new WtloginHelper.HelperThread.1(this);
        paramInt = WtloginHelper.__top;
        WtloginHelper.__top = paramInt + 1;
        ((Timer)localObject2).schedule(local1, paramInt * 500);
        localObject2 = new StringBuilder("push queue ");
        ((StringBuilder)localObject2).append(WtloginHelper.__top);
        util.LOGI(((StringBuilder)localObject2).toString(), "");
        return;
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   4: invokestatic 371	oicq/wlogin_sdk/request/WtloginHelper:access$200	(Loicq/wlogin_sdk/request/WtloginHelper;)Loicq/wlogin_sdk/request/WtloginListener;
      //   7: ifnonnull +11 -> 18
      //   10: aload_0
      //   11: getfield 191	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mPromise	Loicq/wlogin_sdk/request/WtTicketPromise;
      //   14: ifnonnull +4 -> 18
      //   17: return
      //   18: aload_0
      //   19: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   22: invokestatic 375	oicq/wlogin_sdk/request/WtloginHelper:access$300	(Loicq/wlogin_sdk/request/WtloginHelper;)Loicq/wlogin_sdk/request/u;
      //   25: getfield 380	oicq/wlogin_sdk/request/u:t	I
      //   28: istore_1
      //   29: aload_0
      //   30: getfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   33: ifnonnull +9 -> 42
      //   36: iconst_1
      //   37: istore 4
      //   39: goto +6 -> 45
      //   42: iconst_0
      //   43: istore 4
      //   45: aload_0
      //   46: iload 4
      //   48: putfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:isSelfLooper	Z
      //   51: aload_0
      //   52: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:isSelfLooper	Z
      //   55: ifeq +17 -> 72
      //   58: invokestatic 383	android/os/Looper:prepare	()V
      //   61: aload_0
      //   62: aload_0
      //   63: getfield 75	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:this$0	Loicq/wlogin_sdk/request/WtloginHelper;
      //   66: invokestatic 387	oicq/wlogin_sdk/request/WtloginHelper:access$400	(Loicq/wlogin_sdk/request/WtloginHelper;)Landroid/os/Handler;
      //   69: putfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   72: aload_0
      //   73: getfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   76: ifnull +1462 -> 1538
      //   79: aload_0
      //   80: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   83: ifne +73 -> 156
      //   86: aload_0
      //   87: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   90: aload_0
      //   91: getfield 100	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   94: aload_0
      //   95: getfield 102	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
      //   98: aload_0
      //   99: getfield 128	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwMainSigMap	I
      //   102: aload_0
      //   103: getfield 135	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwSubDstAppid	J
      //   106: aload_0
      //   107: getfield 138	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwSubAppidList	[J
      //   110: aload_0
      //   111: getfield 140	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mPwdMd5	Z
      //   114: aload_0
      //   115: getfield 142	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserPasswd	Ljava/lang/String;
      //   118: aload_0
      //   119: getfield 82	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   122: aload_0
      //   123: getfield 144	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST	[[B
      //   126: aload_0
      //   127: getfield 84	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mIsSmslogin	Z
      //   130: iconst_1
      //   131: invokestatic 391	oicq/wlogin_sdk/request/WtloginHelper:access$500	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;JIJ[JZLjava/lang/String;Loicq/wlogin_sdk/request/WUserSigInfo;[[BZI)I
      //   134: istore_2
      //   135: aload_0
      //   136: getfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   139: new 393	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$2
      //   142: dup
      //   143: aload_0
      //   144: iload_1
      //   145: iload_2
      //   146: invokespecial 396	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$2:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   149: invokevirtual 402	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   152: pop
      //   153: goto +1301 -> 1454
      //   156: aload_0
      //   157: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   160: iconst_1
      //   161: if_icmpne +41 -> 202
      //   164: aload_0
      //   165: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   168: aload_0
      //   169: getfield 100	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   172: aload_0
      //   173: getfield 82	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   176: iconst_1
      //   177: invokestatic 406	oicq/wlogin_sdk/request/WtloginHelper:access$900	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;Loicq/wlogin_sdk/request/WUserSigInfo;I)I
      //   180: istore_2
      //   181: aload_0
      //   182: getfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   185: new 408	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$3
      //   188: dup
      //   189: aload_0
      //   190: iload_1
      //   191: iload_2
      //   192: invokespecial 409	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$3:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   195: invokevirtual 402	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   198: pop
      //   199: goto +1255 -> 1454
      //   202: aload_0
      //   203: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   206: iconst_2
      //   207: if_icmpne +49 -> 256
      //   210: aload_0
      //   211: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   214: aload_0
      //   215: getfield 100	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   218: aload_0
      //   219: getfield 182	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserInput	[B
      //   222: aload_0
      //   223: getfield 82	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   226: aload_0
      //   227: getfield 144	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST	[[B
      //   230: iconst_1
      //   231: invokestatic 413	oicq/wlogin_sdk/request/WtloginHelper:access$1000	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;[BLoicq/wlogin_sdk/request/WUserSigInfo;[[BI)I
      //   234: istore_2
      //   235: aload_0
      //   236: getfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   239: new 415	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$4
      //   242: dup
      //   243: aload_0
      //   244: iload_1
      //   245: iload_2
      //   246: invokespecial 416	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$4:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   249: invokevirtual 402	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   252: pop
      //   253: goto +1201 -> 1454
      //   256: aload_0
      //   257: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   260: iconst_3
      //   261: if_icmpne +49 -> 310
      //   264: aload_0
      //   265: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   268: aload_0
      //   269: getfield 100	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   272: aload_0
      //   273: getfield 162	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSmsAppid	J
      //   276: aload_0
      //   277: getfield 82	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   280: aload_0
      //   281: getfield 164	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mExtraData	[B
      //   284: iconst_1
      //   285: invokestatic 420	oicq/wlogin_sdk/request/WtloginHelper:access$1100	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;JLoicq/wlogin_sdk/request/WUserSigInfo;[BI)I
      //   288: istore_2
      //   289: aload_0
      //   290: getfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   293: new 422	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$5
      //   296: dup
      //   297: aload_0
      //   298: iload_1
      //   299: iload_2
      //   300: invokespecial 423	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$5:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   303: invokevirtual 402	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   306: pop
      //   307: goto +1147 -> 1454
      //   310: aload_0
      //   311: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   314: iconst_4
      //   315: if_icmpne +53 -> 368
      //   318: aload_0
      //   319: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   322: aload_0
      //   323: getfield 100	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   326: aload_0
      //   327: getfield 182	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserInput	[B
      //   330: aload_0
      //   331: getfield 82	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   334: aload_0
      //   335: getfield 144	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST	[[B
      //   338: aload_0
      //   339: getfield 164	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mExtraData	[B
      //   342: iconst_1
      //   343: invokestatic 427	oicq/wlogin_sdk/request/WtloginHelper:access$1200	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;[BLoicq/wlogin_sdk/request/WUserSigInfo;[[B[BI)I
      //   346: istore_2
      //   347: aload_0
      //   348: getfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   351: new 429	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$6
      //   354: dup
      //   355: aload_0
      //   356: iload_1
      //   357: iload_2
      //   358: invokespecial 430	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$6:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   361: invokevirtual 402	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   364: pop
      //   365: goto +1089 -> 1454
      //   368: aload_0
      //   369: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   372: iconst_5
      //   373: if_icmpne +243 -> 616
      //   376: getstatic 433	oicq/wlogin_sdk/request/WtloginHelper:GET_ST_WITHOUT_PASSWORD_LOCK	Ljava/lang/Object;
      //   379: astore 16
      //   381: aload 16
      //   383: monitorenter
      //   384: aload_0
      //   385: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   388: astore 15
      //   390: aload_0
      //   391: getfield 100	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   394: astore 17
      //   396: aload_0
      //   397: getfield 102	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
      //   400: lstore 5
      //   402: aload_0
      //   403: getfield 193	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwDstAppid	J
      //   406: lstore 7
      //   408: aload_0
      //   409: getfield 195	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwDstAppPri	J
      //   412: lstore 9
      //   414: aload_0
      //   415: getfield 128	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwMainSigMap	I
      //   418: istore_2
      //   419: aload_0
      //   420: getfield 135	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwSubDstAppid	J
      //   423: lstore 11
      //   425: aload_0
      //   426: getfield 197	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwDstSubAppidList	[J
      //   429: astore 18
      //   431: aload 15
      //   433: aload 17
      //   435: lload 5
      //   437: lload 7
      //   439: lload 9
      //   441: iload_2
      //   442: lload 11
      //   444: aload 18
      //   446: aload_0
      //   447: getfield 82	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   450: aload_0
      //   451: getfield 144	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST	[[B
      //   454: aload_0
      //   455: getfield 199	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReserve	[[B
      //   458: iconst_1
      //   459: aload_0
      //   460: getfield 191	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mPromise	Loicq/wlogin_sdk/request/WtTicketPromise;
      //   463: invokestatic 437	oicq/wlogin_sdk/request/WtloginHelper:access$1400	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;JJJIJ[JLoicq/wlogin_sdk/request/WUserSigInfo;[[B[[BILoicq/wlogin_sdk/request/WtTicketPromise;)I
      //   466: istore_3
      //   467: iload_3
      //   468: istore_2
      //   469: iload_2
      //   470: bipush 20
      //   472: if_icmpne +1292 -> 1764
      //   475: ldc_w 439
      //   478: ldc 241
      //   480: invokestatic 290	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
      //   483: aload_0
      //   484: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   487: aload_0
      //   488: getfield 100	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   491: aload_0
      //   492: getfield 102	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
      //   495: aload_0
      //   496: getfield 193	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwDstAppid	J
      //   499: aload_0
      //   500: getfield 195	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwDstAppPri	J
      //   503: aload_0
      //   504: getfield 128	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwMainSigMap	I
      //   507: aload_0
      //   508: getfield 135	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwSubDstAppid	J
      //   511: aload_0
      //   512: getfield 197	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwDstSubAppidList	[J
      //   515: aload_0
      //   516: getfield 82	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   519: aload_0
      //   520: getfield 144	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST	[[B
      //   523: aload_0
      //   524: getfield 199	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReserve	[[B
      //   527: iconst_1
      //   528: aload_0
      //   529: getfield 191	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mPromise	Loicq/wlogin_sdk/request/WtTicketPromise;
      //   532: invokestatic 437	oicq/wlogin_sdk/request/WtloginHelper:access$1400	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;JJJIJ[JLoicq/wlogin_sdk/request/WUserSigInfo;[[B[[BILoicq/wlogin_sdk/request/WtTicketPromise;)I
      //   535: istore_2
      //   536: goto +3 -> 539
      //   539: iload_2
      //   540: ifne +26 -> 566
      //   543: iload_3
      //   544: bipush 20
      //   546: if_icmpne +20 -> 566
      //   549: new 441	oicq/wlogin_sdk/report/event/b
      //   552: dup
      //   553: ldc_w 443
      //   556: ldc 241
      //   558: ldc 241
      //   560: invokespecial 446	oicq/wlogin_sdk/report/event/b:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   563: invokestatic 452	oicq/wlogin_sdk/report/event/c:a	(Loicq/wlogin_sdk/report/event/b;)V
      //   566: aload 16
      //   568: monitorexit
      //   569: aload_0
      //   570: getfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   573: astore 15
      //   575: iload_1
      //   576: istore_3
      //   577: iload_3
      //   578: istore_1
      //   579: aload 15
      //   581: new 454	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$7
      //   584: dup
      //   585: aload_0
      //   586: iload_3
      //   587: iload_2
      //   588: invokespecial 455	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$7:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   591: invokevirtual 402	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   594: pop
      //   595: goto +859 -> 1454
      //   598: astore 15
      //   600: goto +961 -> 1561
      //   603: astore 15
      //   605: goto +5 -> 610
      //   608: astore 15
      //   610: aload 16
      //   612: monitorexit
      //   613: aload 15
      //   615: athrow
      //   616: iload_1
      //   617: istore_2
      //   618: iload_2
      //   619: istore_1
      //   620: aload_0
      //   621: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   624: bipush 6
      //   626: if_icmpne +139 -> 765
      //   629: iload_2
      //   630: istore_1
      //   631: aload_0
      //   632: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   635: astore 15
      //   637: iload_2
      //   638: istore_1
      //   639: aload_0
      //   640: getfield 100	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   643: astore 16
      //   645: iload_2
      //   646: istore_1
      //   647: aload_0
      //   648: getfield 124	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppid1	J
      //   651: lstore 5
      //   653: iload_2
      //   654: istore_1
      //   655: aload_0
      //   656: getfield 126	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSubAppid1	J
      //   659: lstore 7
      //   661: iload_2
      //   662: istore_1
      //   663: aload_0
      //   664: getfield 128	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwMainSigMap	I
      //   667: istore_3
      //   668: iload_2
      //   669: istore_1
      //   670: aload_0
      //   671: getfield 147	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppName2	[B
      //   674: astore 17
      //   676: iload_2
      //   677: istore_1
      //   678: aload_0
      //   679: getfield 149	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSsoVer2	J
      //   682: lstore 9
      //   684: iload_2
      //   685: istore_1
      //   686: aload_0
      //   687: getfield 151	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppid2	J
      //   690: lstore 11
      //   692: iload_2
      //   693: istore_1
      //   694: aload_0
      //   695: getfield 153	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSubAppid2	J
      //   698: lstore 13
      //   700: aload 15
      //   702: aload 16
      //   704: lload 5
      //   706: lload 7
      //   708: iload_3
      //   709: aload 17
      //   711: lload 9
      //   713: lload 11
      //   715: lload 13
      //   717: aload_0
      //   718: getfield 155	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppVer2	[B
      //   721: aload_0
      //   722: getfield 157	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppSign2	[B
      //   725: aload_0
      //   726: getfield 82	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   729: aload_0
      //   730: getfield 159	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mFastLoginInfo	Loicq/wlogin_sdk/request/WFastLoginInfo;
      //   733: iconst_1
      //   734: invokestatic 459	oicq/wlogin_sdk/request/WtloginHelper:access$1600	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;JJI[BJJJ[B[BLoicq/wlogin_sdk/request/WUserSigInfo;Loicq/wlogin_sdk/request/WFastLoginInfo;I)I
      //   737: istore_3
      //   738: aload_0
      //   739: getfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   742: astore 15
      //   744: iload_2
      //   745: istore_1
      //   746: aload 15
      //   748: new 461	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$8
      //   751: dup
      //   752: aload_0
      //   753: iload_2
      //   754: iload_3
      //   755: invokespecial 462	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$8:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   758: invokevirtual 402	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   761: pop
      //   762: goto +692 -> 1454
      //   765: iload_2
      //   766: istore_1
      //   767: aload_0
      //   768: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   771: bipush 7
      //   773: if_icmpne +33 -> 806
      //   776: iload_2
      //   777: istore_1
      //   778: aload_0
      //   779: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   782: iconst_1
      //   783: aload_0
      //   784: getfield 202	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST1	[B
      //   787: aload_0
      //   788: getfield 204	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST1Key	[B
      //   791: aload_0
      //   792: getfield 132	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUIN	J
      //   795: aload_0
      //   796: getfield 102	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
      //   799: invokestatic 466	oicq/wlogin_sdk/request/WtloginHelper:access$1700	(Loicq/wlogin_sdk/request/WtloginHelper;I[B[BJJ)I
      //   802: pop
      //   803: goto +651 -> 1454
      //   806: iload_2
      //   807: istore_1
      //   808: aload_0
      //   809: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   812: bipush 9
      //   814: if_icmpne +61 -> 875
      //   817: iload_2
      //   818: istore_1
      //   819: aload_0
      //   820: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   823: iconst_1
      //   824: aload_0
      //   825: getfield 98	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mEncrypt	I
      //   828: aload_0
      //   829: getfield 100	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   832: aload_0
      //   833: getfield 102	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
      //   836: aload_0
      //   837: getfield 104	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mRole	J
      //   840: aload_0
      //   841: getfield 106	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqContext	Loicq/wlogin_sdk/request/TransReqContext;
      //   844: aload_0
      //   845: getfield 82	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   848: invokevirtual 470	oicq/wlogin_sdk/request/WtloginHelper:RequestTransport	(IILjava/lang/String;JJLoicq/wlogin_sdk/request/TransReqContext;Loicq/wlogin_sdk/request/WUserSigInfo;)I
      //   851: istore_3
      //   852: iload_2
      //   853: istore_1
      //   854: aload_0
      //   855: getfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   858: new 472	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$9
      //   861: dup
      //   862: aload_0
      //   863: iload_3
      //   864: iload_2
      //   865: invokespecial 473	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$9:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   868: invokevirtual 402	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   871: pop
      //   872: goto +582 -> 1454
      //   875: iload_2
      //   876: istore_1
      //   877: aload_0
      //   878: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   881: bipush 10
      //   883: if_icmpne +57 -> 940
      //   886: iload_2
      //   887: istore_1
      //   888: aload_0
      //   889: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   892: iconst_1
      //   893: aload_0
      //   894: getfield 98	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mEncrypt	I
      //   897: aload_0
      //   898: getfield 100	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   901: aload_0
      //   902: getfield 102	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
      //   905: aload_0
      //   906: getfield 104	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mRole	J
      //   909: aload_0
      //   910: getfield 106	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqContext	Loicq/wlogin_sdk/request/TransReqContext;
      //   913: invokevirtual 477	oicq/wlogin_sdk/request/WtloginHelper:RequestTransportMsf	(IILjava/lang/String;JJLoicq/wlogin_sdk/request/TransReqContext;)I
      //   916: istore_3
      //   917: iload_2
      //   918: istore_1
      //   919: aload_0
      //   920: getfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   923: new 479	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$10
      //   926: dup
      //   927: aload_0
      //   928: iload_2
      //   929: iload_3
      //   930: invokespecial 480	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$10:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   933: invokevirtual 402	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   936: pop
      //   937: goto +517 -> 1454
      //   940: iload_2
      //   941: istore_1
      //   942: aload_0
      //   943: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   946: bipush 12
      //   948: if_icmpne +61 -> 1009
      //   951: iload_2
      //   952: istore_1
      //   953: aload_0
      //   954: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   957: aload_0
      //   958: getfield 124	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppid1	J
      //   961: aload_0
      //   962: getfield 126	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSubAppid1	J
      //   965: aload_0
      //   966: getfield 100	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   969: aload_0
      //   970: getfield 90	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mExtraFlag	I
      //   973: aload_0
      //   974: getfield 88	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mExtraUin	J
      //   977: aload_0
      //   978: getfield 82	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   981: iconst_1
      //   982: invokestatic 484	oicq/wlogin_sdk/request/WtloginHelper:access$2100	(Loicq/wlogin_sdk/request/WtloginHelper;JJLjava/lang/String;IJLoicq/wlogin_sdk/request/WUserSigInfo;I)I
      //   985: istore_3
      //   986: iload_2
      //   987: istore_1
      //   988: aload_0
      //   989: getfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   992: new 486	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$11
      //   995: dup
      //   996: aload_0
      //   997: iload_2
      //   998: iload_3
      //   999: invokespecial 487	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$11:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   1002: invokevirtual 402	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   1005: pop
      //   1006: goto +448 -> 1454
      //   1009: iload_2
      //   1010: istore_1
      //   1011: aload_0
      //   1012: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   1015: bipush 13
      //   1017: if_icmpne +49 -> 1066
      //   1020: iload_2
      //   1021: istore_1
      //   1022: aload_0
      //   1023: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   1026: aload_0
      //   1027: getfield 100	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   1030: aload_0
      //   1031: getfield 167	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mMsgCode	Ljava/lang/String;
      //   1034: aload_0
      //   1035: getfield 82	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   1038: iconst_1
      //   1039: invokestatic 491	oicq/wlogin_sdk/request/WtloginHelper:access$2200	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;Ljava/lang/String;Loicq/wlogin_sdk/request/WUserSigInfo;I)I
      //   1042: istore_3
      //   1043: iload_2
      //   1044: istore_1
      //   1045: aload_0
      //   1046: getfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   1049: new 493	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$12
      //   1052: dup
      //   1053: aload_0
      //   1054: iload_2
      //   1055: iload_3
      //   1056: invokespecial 494	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$12:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   1059: invokevirtual 402	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   1062: pop
      //   1063: goto +391 -> 1454
      //   1066: iload_2
      //   1067: istore_1
      //   1068: aload_0
      //   1069: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   1072: bipush 14
      //   1074: if_icmpne +45 -> 1119
      //   1077: iload_2
      //   1078: istore_1
      //   1079: aload_0
      //   1080: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   1083: aload_0
      //   1084: getfield 100	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   1087: aload_0
      //   1088: getfield 82	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   1091: iconst_1
      //   1092: invokestatic 497	oicq/wlogin_sdk/request/WtloginHelper:access$2400	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;Loicq/wlogin_sdk/request/WUserSigInfo;I)I
      //   1095: istore_3
      //   1096: iload_2
      //   1097: istore_1
      //   1098: aload_0
      //   1099: getfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   1102: new 499	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$13
      //   1105: dup
      //   1106: aload_0
      //   1107: iload_2
      //   1108: iload_3
      //   1109: invokespecial 500	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$13:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   1112: invokevirtual 402	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   1115: pop
      //   1116: goto +338 -> 1454
      //   1119: iload_2
      //   1120: istore_1
      //   1121: aload_0
      //   1122: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   1125: bipush 8
      //   1127: if_icmpne +37 -> 1164
      //   1130: iload_2
      //   1131: istore_1
      //   1132: aload_0
      //   1133: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   1136: iconst_1
      //   1137: aload_0
      //   1138: getfield 202	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST1	[B
      //   1141: aload_0
      //   1142: getfield 204	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST1Key	[B
      //   1145: aload_0
      //   1146: getfield 132	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUIN	J
      //   1149: aload_0
      //   1150: getfield 102	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
      //   1153: aload_0
      //   1154: getfield 206	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReportErrType	I
      //   1157: invokestatic 504	oicq/wlogin_sdk/request/WtloginHelper:access$2500	(Loicq/wlogin_sdk/request/WtloginHelper;I[B[BJJI)I
      //   1160: pop
      //   1161: goto +293 -> 1454
      //   1164: iload_2
      //   1165: istore_1
      //   1166: aload_0
      //   1167: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   1170: bipush 15
      //   1172: if_icmpne +45 -> 1217
      //   1175: iload_2
      //   1176: istore_1
      //   1177: aload_0
      //   1178: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   1181: aload_0
      //   1182: getfield 100	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   1185: aload_0
      //   1186: getfield 172	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:quickLoginParam	Loicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;
      //   1189: iconst_1
      //   1190: invokestatic 508	oicq/wlogin_sdk/request/WtloginHelper:access$2600	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;Loicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;I)I
      //   1193: istore_3
      //   1194: iload_2
      //   1195: istore_1
      //   1196: aload_0
      //   1197: getfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   1200: new 510	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$14
      //   1203: dup
      //   1204: aload_0
      //   1205: iload_2
      //   1206: iload_3
      //   1207: invokespecial 511	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$14:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   1210: invokevirtual 402	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   1213: pop
      //   1214: goto +240 -> 1454
      //   1217: iload_2
      //   1218: istore_1
      //   1219: aload_0
      //   1220: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   1223: bipush 16
      //   1225: if_icmpne +49 -> 1274
      //   1228: iload_2
      //   1229: istore_1
      //   1230: aload_0
      //   1231: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   1234: aload_0
      //   1235: getfield 100	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   1238: aload_0
      //   1239: getfield 170	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:ptSig	Ljava/lang/String;
      //   1242: aload_0
      //   1243: getfield 172	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:quickLoginParam	Loicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;
      //   1246: iconst_1
      //   1247: invokestatic 515	oicq/wlogin_sdk/request/WtloginHelper:access$2700	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;Ljava/lang/String;Loicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;I)I
      //   1250: istore_3
      //   1251: iload_2
      //   1252: istore_1
      //   1253: aload_0
      //   1254: getfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   1257: new 517	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$15
      //   1260: dup
      //   1261: aload_0
      //   1262: iload_2
      //   1263: iload_3
      //   1264: invokespecial 518	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$15:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   1267: invokevirtual 402	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   1270: pop
      //   1271: goto +183 -> 1454
      //   1274: iload_2
      //   1275: istore_1
      //   1276: aload_0
      //   1277: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   1280: bipush 17
      //   1282: if_icmpne +57 -> 1339
      //   1285: iload_2
      //   1286: istore_1
      //   1287: aload_0
      //   1288: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   1291: aload_0
      //   1292: getfield 100	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   1295: aload_0
      //   1296: getfield 102	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
      //   1299: aload_0
      //   1300: getfield 135	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwSubDstAppid	J
      //   1303: aload_0
      //   1304: getfield 128	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwMainSigMap	I
      //   1307: aload_0
      //   1308: getfield 82	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   1311: iconst_1
      //   1312: invokestatic 522	oicq/wlogin_sdk/request/WtloginHelper:access$2800	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;JJILoicq/wlogin_sdk/request/WUserSigInfo;I)I
      //   1315: istore_3
      //   1316: iload_2
      //   1317: istore_1
      //   1318: aload_0
      //   1319: getfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   1322: new 524	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$16
      //   1325: dup
      //   1326: aload_0
      //   1327: iload_2
      //   1328: iload_3
      //   1329: invokespecial 525	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$16:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   1332: invokevirtual 402	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   1335: pop
      //   1336: goto +118 -> 1454
      //   1339: iload_2
      //   1340: istore_1
      //   1341: aload_0
      //   1342: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   1345: bipush 18
      //   1347: if_icmpne +49 -> 1396
      //   1350: iload_2
      //   1351: istore_1
      //   1352: aload_0
      //   1353: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   1356: aload_0
      //   1357: getfield 188	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mWxAppid	[B
      //   1360: aload_0
      //   1361: getfield 186	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:weChatCode	[B
      //   1364: aload_0
      //   1365: getfield 172	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:quickLoginParam	Loicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;
      //   1368: iconst_1
      //   1369: invokevirtual 529	oicq/wlogin_sdk/request/WtloginHelper:quickLoginByWeChat	([B[BLoicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;I)I
      //   1372: istore_3
      //   1373: iload_2
      //   1374: istore_1
      //   1375: aload_0
      //   1376: getfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   1379: new 531	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$17
      //   1382: dup
      //   1383: aload_0
      //   1384: iload_2
      //   1385: iload_3
      //   1386: invokespecial 532	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$17:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   1389: invokevirtual 402	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   1392: pop
      //   1393: goto +61 -> 1454
      //   1396: iload_2
      //   1397: istore_1
      //   1398: aload_0
      //   1399: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   1402: bipush 19
      //   1404: if_icmpne +50 -> 1454
      //   1407: iload_2
      //   1408: istore_1
      //   1409: aload_0
      //   1410: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   1413: aload_0
      //   1414: getfield 124	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppid1	J
      //   1417: aload_0
      //   1418: getfield 126	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSubAppid1	J
      //   1421: aload_0
      //   1422: getfield 128	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwMainSigMap	I
      //   1425: aload_0
      //   1426: getfield 82	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   1429: iconst_1
      //   1430: invokestatic 536	oicq/wlogin_sdk/request/WtloginHelper:access$2900	(Loicq/wlogin_sdk/request/WtloginHelper;JJILoicq/wlogin_sdk/request/WUserSigInfo;I)I
      //   1433: istore_3
      //   1434: iload_2
      //   1435: istore_1
      //   1436: aload_0
      //   1437: getfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   1440: new 538	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$18
      //   1443: dup
      //   1444: aload_0
      //   1445: iload_2
      //   1446: iload_3
      //   1447: invokespecial 539	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$18:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   1450: invokevirtual 402	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   1453: pop
      //   1454: aload_0
      //   1455: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:isSelfLooper	Z
      //   1458: ifeq +6 -> 1464
      //   1461: invokestatic 542	android/os/Looper:loop	()V
      //   1464: aload_0
      //   1465: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   1468: bipush 7
      //   1470: if_icmpeq +199 -> 1669
      //   1473: getstatic 350	oicq/wlogin_sdk/request/WtloginHelper:__sync_top	Ljava/lang/Object;
      //   1476: astore 15
      //   1478: aload 15
      //   1480: monitorenter
      //   1481: getstatic 360	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1484: ifle +11 -> 1495
      //   1487: getstatic 360	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1490: iconst_1
      //   1491: isub
      //   1492: putstatic 360	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1495: new 255	java/lang/StringBuilder
      //   1498: dup
      //   1499: ldc_w 544
      //   1502: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1505: astore 16
      //   1507: aload 16
      //   1509: getstatic 360	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1512: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1515: pop
      //   1516: aload 16
      //   1518: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1521: ldc 241
      //   1523: invokestatic 290	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
      //   1526: aload 15
      //   1528: monitorexit
      //   1529: return
      //   1530: astore 16
      //   1532: aload 15
      //   1534: monitorexit
      //   1535: aload 16
      //   1537: athrow
      //   1538: new 230	java/lang/Exception
      //   1541: dup
      //   1542: ldc_w 546
      //   1545: invokespecial 547	java/lang/Exception:<init>	(Ljava/lang/String;)V
      //   1548: athrow
      //   1549: astore 15
      //   1551: goto +10 -> 1561
      //   1554: astore 16
      //   1556: goto +114 -> 1670
      //   1559: astore 15
      //   1561: aload 15
      //   1563: ldc 241
      //   1565: invokestatic 247	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
      //   1568: aload_0
      //   1569: getfield 94	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   1572: new 549	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$19
      //   1575: dup
      //   1576: aload_0
      //   1577: iload_1
      //   1578: invokespecial 552	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$19:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;I)V
      //   1581: invokevirtual 402	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   1584: pop
      //   1585: aload_0
      //   1586: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:isSelfLooper	Z
      //   1589: ifeq +6 -> 1595
      //   1592: invokestatic 542	android/os/Looper:loop	()V
      //   1595: aload_0
      //   1596: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   1599: bipush 7
      //   1601: if_icmpeq +68 -> 1669
      //   1604: getstatic 350	oicq/wlogin_sdk/request/WtloginHelper:__sync_top	Ljava/lang/Object;
      //   1607: astore 15
      //   1609: aload 15
      //   1611: monitorenter
      //   1612: getstatic 360	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1615: ifle +11 -> 1626
      //   1618: getstatic 360	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1621: iconst_1
      //   1622: isub
      //   1623: putstatic 360	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1626: new 255	java/lang/StringBuilder
      //   1629: dup
      //   1630: ldc_w 544
      //   1633: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1636: astore 16
      //   1638: aload 16
      //   1640: getstatic 360	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1643: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1646: pop
      //   1647: aload 16
      //   1649: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1652: ldc 241
      //   1654: invokestatic 290	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
      //   1657: aload 15
      //   1659: monitorexit
      //   1660: return
      //   1661: astore 16
      //   1663: aload 15
      //   1665: monitorexit
      //   1666: aload 16
      //   1668: athrow
      //   1669: return
      //   1670: aload_0
      //   1671: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:isSelfLooper	Z
      //   1674: ifeq +6 -> 1680
      //   1677: invokestatic 542	android/os/Looper:loop	()V
      //   1680: aload_0
      //   1681: getfield 343	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   1684: bipush 7
      //   1686: if_icmpeq +70 -> 1756
      //   1689: getstatic 350	oicq/wlogin_sdk/request/WtloginHelper:__sync_top	Ljava/lang/Object;
      //   1692: astore 15
      //   1694: aload 15
      //   1696: monitorenter
      //   1697: getstatic 360	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1700: ifle +11 -> 1711
      //   1703: getstatic 360	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1706: iconst_1
      //   1707: isub
      //   1708: putstatic 360	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1711: new 255	java/lang/StringBuilder
      //   1714: dup
      //   1715: ldc_w 544
      //   1718: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1721: astore 17
      //   1723: aload 17
      //   1725: getstatic 360	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1728: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1731: pop
      //   1732: aload 17
      //   1734: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1737: ldc 241
      //   1739: invokestatic 290	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
      //   1742: aload 15
      //   1744: monitorexit
      //   1745: goto +11 -> 1756
      //   1748: astore 16
      //   1750: aload 15
      //   1752: monitorexit
      //   1753: aload 16
      //   1755: athrow
      //   1756: aload 16
      //   1758: athrow
      //   1759: astore 15
      //   1761: goto -1151 -> 610
      //   1764: goto -1225 -> 539
      //   1767: astore 15
      //   1769: goto -1159 -> 610
      //   1772: astore 15
      //   1774: iload_2
      //   1775: istore_1
      //   1776: goto -215 -> 1561
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1779	0	this	HelperThread
      //   28	1748	1	i	int
      //   134	1641	2	j	int
      //   466	981	3	k	int
      //   37	10	4	bool	boolean
      //   400	305	5	l1	long
      //   406	301	7	l2	long
      //   412	300	9	l3	long
      //   423	291	11	l4	long
      //   698	18	13	l5	long
      //   388	192	15	localObject1	Object
      //   598	1	15	localException1	Exception
      //   603	1	15	localObject2	Object
      //   608	6	15	localObject3	Object
      //   1549	1	15	localException2	Exception
      //   1559	3	15	localException3	Exception
      //   1759	1	15	localObject6	Object
      //   1767	1	15	localObject7	Object
      //   1772	1	15	localException4	Exception
      //   379	1138	16	localObject8	Object
      //   1530	6	16	localObject9	Object
      //   1554	1	16	localObject10	Object
      //   1636	12	16	localStringBuilder	StringBuilder
      //   1661	6	16	localObject11	Object
      //   1748	9	16	localObject12	Object
      //   394	1339	17	localObject13	Object
      //   429	16	18	arrayOfLong	long[]
      // Exception table:
      //   from	to	target	type
      //   569	575	598	java/lang/Exception
      //   431	467	603	finally
      //   566	569	603	finally
      //   384	431	608	finally
      //   1481	1495	1530	finally
      //   1495	1529	1530	finally
      //   1532	1535	1530	finally
      //   579	595	1549	java/lang/Exception
      //   613	616	1549	java/lang/Exception
      //   620	629	1549	java/lang/Exception
      //   631	637	1549	java/lang/Exception
      //   639	645	1549	java/lang/Exception
      //   647	653	1549	java/lang/Exception
      //   655	661	1549	java/lang/Exception
      //   663	668	1549	java/lang/Exception
      //   670	676	1549	java/lang/Exception
      //   678	684	1549	java/lang/Exception
      //   686	692	1549	java/lang/Exception
      //   694	700	1549	java/lang/Exception
      //   746	762	1549	java/lang/Exception
      //   767	776	1549	java/lang/Exception
      //   778	803	1549	java/lang/Exception
      //   808	817	1549	java/lang/Exception
      //   819	852	1549	java/lang/Exception
      //   854	872	1549	java/lang/Exception
      //   877	886	1549	java/lang/Exception
      //   888	917	1549	java/lang/Exception
      //   919	937	1549	java/lang/Exception
      //   942	951	1549	java/lang/Exception
      //   953	986	1549	java/lang/Exception
      //   988	1006	1549	java/lang/Exception
      //   1011	1020	1549	java/lang/Exception
      //   1022	1043	1549	java/lang/Exception
      //   1045	1063	1549	java/lang/Exception
      //   1068	1077	1549	java/lang/Exception
      //   1079	1096	1549	java/lang/Exception
      //   1098	1116	1549	java/lang/Exception
      //   1121	1130	1549	java/lang/Exception
      //   1132	1161	1549	java/lang/Exception
      //   1166	1175	1549	java/lang/Exception
      //   1177	1194	1549	java/lang/Exception
      //   1196	1214	1549	java/lang/Exception
      //   1219	1228	1549	java/lang/Exception
      //   1230	1251	1549	java/lang/Exception
      //   1253	1271	1549	java/lang/Exception
      //   1276	1285	1549	java/lang/Exception
      //   1287	1316	1549	java/lang/Exception
      //   1318	1336	1549	java/lang/Exception
      //   1341	1350	1549	java/lang/Exception
      //   1352	1373	1549	java/lang/Exception
      //   1375	1393	1549	java/lang/Exception
      //   1398	1407	1549	java/lang/Exception
      //   1409	1434	1549	java/lang/Exception
      //   1436	1454	1549	java/lang/Exception
      //   1538	1549	1549	java/lang/Exception
      //   72	153	1554	finally
      //   156	199	1554	finally
      //   202	253	1554	finally
      //   256	307	1554	finally
      //   310	365	1554	finally
      //   368	384	1554	finally
      //   569	575	1554	finally
      //   579	595	1554	finally
      //   613	616	1554	finally
      //   620	629	1554	finally
      //   631	637	1554	finally
      //   639	645	1554	finally
      //   647	653	1554	finally
      //   655	661	1554	finally
      //   663	668	1554	finally
      //   670	676	1554	finally
      //   678	684	1554	finally
      //   686	692	1554	finally
      //   694	700	1554	finally
      //   700	744	1554	finally
      //   746	762	1554	finally
      //   767	776	1554	finally
      //   778	803	1554	finally
      //   808	817	1554	finally
      //   819	852	1554	finally
      //   854	872	1554	finally
      //   877	886	1554	finally
      //   888	917	1554	finally
      //   919	937	1554	finally
      //   942	951	1554	finally
      //   953	986	1554	finally
      //   988	1006	1554	finally
      //   1011	1020	1554	finally
      //   1022	1043	1554	finally
      //   1045	1063	1554	finally
      //   1068	1077	1554	finally
      //   1079	1096	1554	finally
      //   1098	1116	1554	finally
      //   1121	1130	1554	finally
      //   1132	1161	1554	finally
      //   1166	1175	1554	finally
      //   1177	1194	1554	finally
      //   1196	1214	1554	finally
      //   1219	1228	1554	finally
      //   1230	1251	1554	finally
      //   1253	1271	1554	finally
      //   1276	1285	1554	finally
      //   1287	1316	1554	finally
      //   1318	1336	1554	finally
      //   1341	1350	1554	finally
      //   1352	1373	1554	finally
      //   1375	1393	1554	finally
      //   1398	1407	1554	finally
      //   1409	1434	1554	finally
      //   1436	1454	1554	finally
      //   1538	1549	1554	finally
      //   1561	1585	1554	finally
      //   72	153	1559	java/lang/Exception
      //   156	199	1559	java/lang/Exception
      //   202	253	1559	java/lang/Exception
      //   256	307	1559	java/lang/Exception
      //   310	365	1559	java/lang/Exception
      //   368	384	1559	java/lang/Exception
      //   1612	1626	1661	finally
      //   1626	1660	1661	finally
      //   1663	1666	1661	finally
      //   1697	1711	1748	finally
      //   1711	1745	1748	finally
      //   1750	1753	1748	finally
      //   475	536	1759	finally
      //   549	566	1759	finally
      //   610	613	1767	finally
      //   700	744	1772	java/lang/Exception
    }
  }
  
  public static class LoginSourceType
  {
    public static final int IM = 10;
    public static final int QQConn = 20;
    public static final int QQWallet = 40;
    public static final int unknown = 0;
    public static final int webView = 30;
    public static final int webViewForceRefresh = 31;
    public static final int webViewOnTimeRefresh = 32;
  }
  
  public static class QuickLoginParam
  {
    public long appid;
    public long dstAppid;
    public long[] dstSubAppidList;
    public int finishAnimEnter = 0;
    public int finishAnimExit = 0;
    public boolean forceWebLogin = false;
    public boolean isUserAccountLocked = false;
    public int sigMap;
    public int startAnimEnter = 0;
    public int startAnimExit = 0;
    public long subAppid = 1L;
    public String titleBackgroundColor = "#3F51B5";
    public String titleTextColor = "#FFFFFF";
    public String userAccount;
    public WUserSigInfo userSigInfo = new WUserSigInfo();
    public String webViewActivityClassName;
  }
  
  public class QuickLoginRequestCode
  {
    public static final int REQUEST_PT_LOGIN = 1202;
    public static final int REQUEST_QQ_LOGIN = 1201;
    
    public QuickLoginRequestCode() {}
  }
  
  public static class RegTLVType
  {
    public static final int ADDRESS_BOOK = 7;
    public static final int APPID = 2;
    public static final int APPNAME = 14;
    public static final int CALL_BACK_URL = 5;
    public static final int EMAIL_URL = 4;
    public static final int GUID = 10;
    public static final int HAS_ADDRESS_BOOK = 8;
    public static final int ID = 1;
    public static final int LANGUAGE = 3;
    public static final int LIMIT_PHONE_REG = 51;
    public static final int MPASSWD = 11;
    public static final int MSALT = 12;
    public static final int NEW_UIN = 31;
    public static final int NICK_NAME = 6;
    public static final int NOPASSWD_REG = 9;
    public static final int PHONE_NUMBER = 30;
    public static final int PHONE_NUMBER_BOUND_UIN = 36;
    public static final int PICTURE_ID = 17;
    public static final int PICTURE_URL = 40;
    public static final int REGISTER_SIG = 16;
    public static final int REG_SIG = 33;
    public static final int SET_DEVLOCK_FLG = 15;
    public static final int SUBAPPID = 13;
  }
  
  public static final class SigType
  {
    public static final int WLOGIN_A2 = 64;
    public static final int WLOGIN_A5 = 2;
    public static final int WLOGIN_AQSIG = 2097152;
    public static final int WLOGIN_D2 = 262144;
    public static final int WLOGIN_DA2 = 33554432;
    public static final int WLOGIN_LHSIG = 4194304;
    public static final int WLOGIN_LSKEY = 512;
    public static final int WLOGIN_OPENKEY = 16384;
    public static final int WLOGIN_PAYTOKEN = 8388608;
    public static final int WLOGIN_PF = 16777216;
    public static final int WLOGIN_PSKEY = 1048576;
    public static final int WLOGIN_PT4Token = 134217728;
    public static final int WLOGIN_QRPUSH = 67108864;
    public static final int WLOGIN_RESERVED = 16;
    public static final int WLOGIN_SID = 524288;
    public static final int WLOGIN_SIG64 = 8192;
    public static final int WLOGIN_SKEY = 4096;
    public static final int WLOGIN_ST = 128;
    public static final int WLOGIN_STWEB = 32;
    public static final int WLOGIN_TOKEN = 32768;
    public static final int WLOGIN_VKEY = 131072;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper
 * JD-Core Version:    0.7.0.1
 */