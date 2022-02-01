package oicq.wlogin_sdk.request;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.code2d.fetch_code;
import oicq.wlogin_sdk.code2d.fetch_code.QRCodeCustom;
import oicq.wlogin_sdk.devicelock.DevlockBase;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.devicelock.DevlockRst;
import oicq.wlogin_sdk.devicelock.TLV_CommRsp;
import oicq.wlogin_sdk.devicelock.i;
import oicq.wlogin_sdk.devicelock.j;
import oicq.wlogin_sdk.devicelock.k;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.report.report_t2;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tlv_type.RegTLV;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t105;
import oicq.wlogin_sdk.tlv_type.tlv_t106;
import oicq.wlogin_sdk.tlv_type.tlv_t10c;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t150;
import oicq.wlogin_sdk.tlv_type.tlv_t165;
import oicq.wlogin_sdk.tlv_type.tlv_t16a;
import oicq.wlogin_sdk.tlv_type.tlv_t400;
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
  static final Object __sync_top = new Object();
  static int __top;
  private boolean isForLocal = false;
  private long mAysncSeq = 0L;
  private Context mContext = null;
  private t mG = new t(null);
  private Handler mHelperHandler = newHelperHandler();
  private WtloginListener mListener = null;
  private int mMainSigMap = 16724722;
  private int mMiscBitmap = 16252796;
  private long mOpenAppid = 715019303L;
  private oicq.wlogin_sdk.a.h mRegStatus = new oicq.wlogin_sdk.a.h();
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
  
  public WtloginHelper(Context paramContext, boolean paramBoolean)
  {
    localInit(paramContext, paramBoolean);
  }
  
  private void AsyncGenRSAKey()
  {
    if (this.isForLocal) {
      return;
    }
    new WtloginHelper.2(this, "AsyncGenRSAKey").start();
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
      t localt = this.mG.a(paramWUserSigInfo._seqence);
      paramWUserSigInfo._seqence = localt.h;
      async_context localasync_context = t.b(paramWUserSigInfo._seqence);
      Object localObject1 = new StringBuilder("user:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" CheckPictureAndGetSt Seq:");
      ((StringBuilder)localObject1).append(localt.h);
      ((StringBuilder)localObject1).append(" ...");
      util.LOGI(((StringBuilder)localObject1).toString(), paramString);
      localt.g = paramString;
      localasync_context._last_err_msg = new ErrMsg();
      long l1;
      if (!util.check_uin_account(paramString).booleanValue())
      {
        l1 = localt.b(paramString);
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
        localt.f = l1;
        paramWUserSigInfo.uin = String.valueOf(l1);
      }
      localObject1 = new o(localt);
      int j = this.mMiscBitmap;
      int k = this.mSubSigMap;
      Object localObject2 = localasync_context._sub_appid_list;
      int i = paramInt;
      j = ((o)localObject1).a(paramArrayOfByte, j, k, (long[])localObject2, paramWUserSigInfo);
      paramInt = j;
      if (j == 204) {
        paramInt = new q(localt).a(this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo);
      }
      if ((paramInt != 0) && (paramInt != 160)) {
        break label1152;
      }
      long l2;
      if (!util.check_uin_account(paramString).booleanValue())
      {
        l2 = localt.b(paramString);
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
        localt.f = l1;
        paramWUserSigInfo.uin = String.valueOf(l1);
        if (paramInt != 160)
        {
          if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
          {
            localt.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
            paramArrayOfByte = new StringBuilder("MSF SSO SEQ:");
            paramArrayOfByte.append(localt.i);
            util.LOGI(paramArrayOfByte.toString(), paramString);
          }
          else
          {
            localt.i = 0;
          }
          paramArrayOfByte = localt.a(l1, localasync_context._appid);
          if (paramArrayOfByte != null)
          {
            paramWUserSigInfo.get_clone(paramArrayOfByte);
            if ((localasync_context._sub_appid_list != null) && (paramArrayOfByte1 != null) && (localasync_context._sub_appid_list.length * 2 == paramArrayOfByte1.length))
            {
              paramInt = 0;
              while ((localasync_context._sub_appid_list != null) && (paramInt < localasync_context._sub_appid_list.length))
              {
                paramArrayOfByte = localt.a(l1, localasync_context._sub_appid_list[paramInt]);
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
              paramArrayOfByte = t.aa;
            }
            if (localasync_context._tmp_pwd_type != 0)
            {
              localObject2 = new l(localt, this.mContext);
              ((l)localObject2).g();
              l1 = localasync_context._appid;
              l2 = localasync_context._sub_appid;
              localObject1 = localasync_context;
              paramInt = ((l)localObject2).a(l1, l2, localt.f, 0, t.ad, ((async_context)localObject1)._tmp_pwd, null, this.mMiscBitmap, this.mSubSigMap, ((async_context)localObject1)._sub_appid_list, ((async_context)localObject1)._main_sigmap, ((async_context)localObject1)._sub_appid, t.y, 0, 0, 1, paramArrayOfByte, paramWUserSigInfo);
            }
            else
            {
              localObject1 = localasync_context;
              localObject2 = new byte[4];
              util.int64_to_buf32((byte[])localObject2, 0, System.currentTimeMillis() / 1000L + t.ac);
              if (((async_context)localObject1)._isSmslogin) {
                paramInt = 3;
              } else {
                paramInt = 1;
              }
              l locall = new l(localt, this.mContext);
              locall.g();
              paramInt = locall.a(((async_context)localObject1)._appid, ((async_context)localObject1)._sub_appid, localt.f, 0, t.ad, (byte[])localObject2, ((async_context)localObject1)._tmp_pwd, paramInt, this.mMiscBitmap, this.mSubSigMap, ((async_context)localObject1)._sub_appid_list, ((async_context)localObject1)._main_sigmap, ((async_context)localObject1)._sub_appid, t.y, 0, 0, 1, paramArrayOfByte, paramWUserSigInfo);
            }
            paramArrayOfByte = localasync_context;
            if (paramInt == 204) {
              paramInt = new q(localt).a(this.mMiscBitmap, this.mSubSigMap, paramArrayOfByte._sub_appid_list, paramWUserSigInfo);
            }
            if ((paramInt == 0) || (paramInt == 160))
            {
              l1 = localt.b(paramString);
              paramWUserSigInfo.uin = String.valueOf(l1);
              if (paramInt != 160)
              {
                localObject1 = localt.a(l1, paramArrayOfByte._appid);
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
                      localObject1 = localt.a(l1, paramArrayOfByte._sub_appid_list[paramInt]);
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
      label1152:
      paramArrayOfByte = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      if (paramArrayOfByte == null) {
        paramArrayOfByte = new Ticket();
      }
      t.an.commit_t2(localt.f, localt.g, util.format_ret_code(paramInt), paramInt);
      if (paramInt == 0)
      {
        if ((paramArrayOfByte._sig != null) && (paramArrayOfByte._sig.length != 0)) {
          RequestReport(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localt.f, localasync_context._appid);
        }
      }
      else
      {
        paramWUserSigInfo = paramArrayOfByte;
        RequestReportError(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, localt.f, localasync_context._appid, 0);
      }
      if ((localt.d != null) && (localt.d.get_bitmap() != 0))
      {
        this.mG.d = localt.d;
        RequestReportError(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localt.f, localasync_context._appid, 1);
      }
      t.b();
      localt.h();
      paramArrayOfByte = new StringBuilder("user:");
      paramArrayOfByte.append(paramString);
      paramArrayOfByte.append(" CheckPictureAndGetSt Seq:");
      paramArrayOfByte.append(localt.h);
      paramArrayOfByte.append(" ret=");
      paramArrayOfByte.append(paramInt);
      paramString = paramArrayOfByte.toString();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(localt.f);
      util.LOGI(paramString, paramArrayOfByte.toString());
      return paramInt;
    }
    return -1017;
  }
  
  private int CheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, int paramInt)
  {
    if ((paramString != null) && (paramArrayOfByte != null) && (paramWUserSigInfo != null))
    {
      if (paramInt == 0)
      {
        new HelperThread(this, this.mHelperHandler, paramString, paramArrayOfByte, paramWUserSigInfo, paramArrayOfByte1, "CheckSMSAndGetSt").RunReq(4);
        return -1001;
      }
      if (paramWUserSigInfo._seqence == 0L) {
        paramWUserSigInfo._seqence = this.mAysncSeq;
      }
      t localt = this.mG.a(paramWUserSigInfo._seqence);
      paramWUserSigInfo._seqence = localt.h;
      async_context localasync_context = t.b(paramWUserSigInfo._seqence);
      StringBuilder localStringBuilder = new StringBuilder("user:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" CheckSMSAndGetSt Seq:");
      localStringBuilder.append(localt.h);
      localStringBuilder.append(" ...");
      util.LOGI(localStringBuilder.toString(), paramString);
      localt.g = paramString;
      localt.f = 0L;
      localasync_context._last_err_msg = new ErrMsg();
      if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
      {
        localt.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
        localStringBuilder = new StringBuilder("MSF SSO SEQ:");
        localStringBuilder.append(localt.i);
        util.LOGI(localStringBuilder.toString(), paramString);
      }
      else
      {
        localt.i = 0;
      }
      long l;
      if (!util.check_uin_account(paramString).booleanValue())
      {
        l = localt.b(paramString);
        if (l == 0L)
        {
          paramArrayOfByte = new StringBuilder("user:");
          paramArrayOfByte.append(paramString);
          paramArrayOfByte.append(" have not found uin record.");
          util.LOGI(paramArrayOfByte.toString(), paramString);
          paramInt = -1003;
          break label521;
        }
      }
      else
      {
        l = Long.parseLong(paramString);
      }
      localt.f = l;
      paramWUserSigInfo.uin = String.valueOf(l);
      paramInt = new p(localt).a(paramArrayOfByte, this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo);
      if (paramInt == 0)
      {
        paramArrayOfByte = localt.a(l, localasync_context._appid);
        if (paramArrayOfByte == null)
        {
          paramInt = -1004;
        }
        else
        {
          paramWUserSigInfo.get_clone(paramArrayOfByte);
          if ((localasync_context._sub_appid_list != null) && (paramArrayOfByte1 != null) && (localasync_context._sub_appid_list.length * 2 == paramArrayOfByte1.length))
          {
            paramInt = 0;
            while ((localasync_context._sub_appid_list != null) && (paramInt < localasync_context._sub_appid_list.length))
            {
              paramArrayOfByte = localt.a(l, localasync_context._sub_appid_list[paramInt]);
              if (paramArrayOfByte != null)
              {
                int i = paramInt * 2;
                paramArrayOfByte1[i] = ((byte[])paramArrayOfByte._userSt_Key.clone());
                paramArrayOfByte1[(i + 1)] = ((byte[])paramArrayOfByte._userStSig.clone());
              }
              paramInt += 1;
            }
          }
          paramInt = 0;
        }
      }
      label521:
      paramArrayOfByte = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      if (paramArrayOfByte == null) {
        paramArrayOfByte = new Ticket();
      }
      t.an.commit_t2(localt.f, localt.g, util.format_ret_code(paramInt), paramInt);
      if (paramInt == 0)
      {
        if ((paramArrayOfByte._sig != null) && (paramArrayOfByte._sig.length != 0)) {
          RequestReport(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localt.f, localasync_context._appid);
        }
      }
      else {
        RequestReportError(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localt.f, localasync_context._appid, 0);
      }
      if ((localt.d != null) && (localt.d.get_bitmap() != 0))
      {
        this.mG.d = localt.d;
        RequestReportError(0, paramArrayOfByte._sig, paramArrayOfByte._sig_key, localt.f, localasync_context._appid, 1);
      }
      t.b();
      localt.h();
      paramArrayOfByte = new StringBuilder("user:");
      paramArrayOfByte.append(paramString);
      paramArrayOfByte.append(" CheckSMSAndGetSt Seq:");
      paramArrayOfByte.append(localt.h);
      paramArrayOfByte.append(" ret=");
      paramArrayOfByte.append(paramInt);
      paramString = paramArrayOfByte.toString();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(localt.f);
      util.LOGI(paramString, paramArrayOfByte.toString());
      return paramInt;
    }
    return -1017;
  }
  
  private int CheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, String paramString, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    int i = 0;
    oicq.wlogin_sdk.a.h.x = false;
    oicq.wlogin_sdk.a.h.y = 0L;
    if ((paramString != null) && (paramWUserSigInfo != null))
    {
      if (paramInt == 0)
      {
        new HelperThread(this, this.mHelperHandler, paramLong1, paramLong2, paramString, paramWUserSigInfo, "CheckSMSVerifyLoginAccount").RunReq(12);
        return -1001;
      }
      t localt = this.mG.a(0L);
      paramWUserSigInfo._seqence = localt.h;
      this.mAysncSeq = localt.h;
      Object localObject = t.b(localt.h);
      localt.g = paramString;
      StringBuilder localStringBuilder = new StringBuilder("user:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" Seq:");
      localStringBuilder.append(localt.h);
      localStringBuilder.append(" CheckSMSVerifyLoginAccount ...");
      util.LOGI(localStringBuilder.toString(), paramString);
      ((async_context)localObject)._login_bitmap = paramWUserSigInfo._login_bitmap;
      ((async_context)localObject)._last_err_msg = new ErrMsg();
      paramInt = new v(localt).a(paramLong1, paramLong2, this.mMainSigMap, t.aa, paramString, this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
      if (paramInt == 208) {
        paramInt = i;
      }
      localObject = new StringBuilder("user:");
      ((StringBuilder)localObject).append(localt.g);
      ((StringBuilder)localObject).append(" Seq:");
      ((StringBuilder)localObject).append(localt.h);
      ((StringBuilder)localObject).append(" CheckSMSVerifyLoginAccount ret=");
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
  
  private WloginSigInfo FindUserSig(long paramLong1, long paramLong2)
  {
    return this.mG.a(paramLong1, paramLong2);
  }
  
  private byte[] GetA1ByAccount(String paramString, long paramLong)
  {
    if (paramString == null) {
      return null;
    }
    long l1;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      long l2 = this.mG.b(paramString);
      l1 = l2;
      if (l2 == 0L)
      {
        localObject = null;
        break label61;
      }
    }
    else
    {
      l1 = Long.parseLong(paramString);
    }
    Object localObject = this.mG.a(l1, paramLong);
    label61:
    if ((localObject != null) && (((WloginSigInfo)localObject)._en_A1 != null) && (((WloginSigInfo)localObject)._en_A1.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder("userAccount:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" dwAppid:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" GetA1ByAccount return: not null");
      util.LOGI(localStringBuilder.toString(), paramString);
      return (byte[])((WloginSigInfo)localObject)._en_A1.clone();
    }
    localObject = new StringBuilder("userAccount:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" dwAppid:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" GetA1ByAccount return: null");
    util.LOGI(((StringBuilder)localObject).toString(), paramString);
    return null;
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
      t localt = this.mG.a(0L);
      paramWUserSigInfo._seqence = localt.h;
      Object localObject1 = t.b(localt.h);
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
      ((StringBuilder)localObject2).append(localt.h);
      ((StringBuilder)localObject2).append(" ...");
      util.LOGI(((StringBuilder)localObject2).toString(), paramString);
      paramInt1 = util.get_saved_network_type(this.mContext);
      t.D = util.get_network_type(this.mContext);
      if (paramInt1 != t.D)
      {
        util.set_net_retry_type(this.mContext, 0);
        util.save_network_type(this.mContext, t.D);
      }
      t.F = util.get_apn_string(this.mContext).getBytes();
      localt.g = paramString;
      localt.f = 0L;
      ((async_context)localObject1)._sappid = paramLong1;
      ((async_context)localObject1)._appid = paramLong1;
      ((async_context)localObject1)._sub_appid = paramLong2;
      ((async_context)localObject1)._main_sigmap = i;
      ((async_context)localObject1)._last_err_msg = new ErrMsg();
      t.an.add_t2(new report_t2("login", new String(t.C), System.currentTimeMillis(), paramLong4, paramLong5, null));
      long l1;
      if (!util.check_uin_account(paramString).booleanValue())
      {
        long l2 = localt.b(paramString);
        l1 = l2;
        if (l2 == 0L)
        {
          paramArrayOfByte2 = new StringBuilder("user:");
          paramArrayOfByte2.append(paramString);
          paramArrayOfByte2.append(" have not found uin record.");
          util.LOGI(paramArrayOfByte2.toString(), paramString);
          paramInt1 = -1003;
          break label731;
        }
      }
      else
      {
        l1 = Long.parseLong(paramString);
      }
      localt.f = l1;
      localt.j();
      localObject1 = GetA1ByAccount(paramString, paramLong1);
      localObject2 = GetNoPicSigByAccount(paramString, paramLong1);
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        StringBuilder localStringBuilder = new StringBuilder("user:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" login with A1 exchange A1.");
        util.LOGI(localStringBuilder.toString(), paramString);
        paramInt2 = new m(localt).a(l1, paramLong1, paramLong2, 1, i, (byte[])localObject1, (byte[])localObject2, this.mMiscBitmap, this.mSubSigMap, null, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramArrayOfByte2, paramArrayOfByte3, paramWUserSigInfo);
        paramInt1 = paramInt2;
        if (paramInt2 == 0)
        {
          paramArrayOfByte2 = localt.a(l1, paramLong1);
          if (paramArrayOfByte2 == null)
          {
            paramInt1 = -1004;
          }
          else
          {
            paramWUserSigInfo.get_clone(paramArrayOfByte2);
            paramWFastLoginInfo.get_clone(localt.j);
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
      label731:
      paramArrayOfByte2 = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      if (paramArrayOfByte2 == null) {
        paramArrayOfByte2 = new Ticket();
      }
      t.an.commit_t2(localt.f, localt.g, util.format_ret_code(paramInt1), paramInt1);
      if (paramInt1 == 0)
      {
        if ((paramArrayOfByte2._sig != null) && (paramArrayOfByte2._sig.length != 0)) {
          RequestReport(0, paramArrayOfByte2._sig, paramArrayOfByte2._sig_key, localt.f, paramLong1);
        }
      }
      else
      {
        paramArrayOfByte3 = paramArrayOfByte2;
        RequestReportError(0, paramArrayOfByte3._sig, paramArrayOfByte3._sig_key, localt.f, paramLong1, 0);
      }
      if ((localt.d != null) && (localt.d.get_bitmap() != 0))
      {
        this.mG.d = localt.d;
        RequestReportError(0, paramArrayOfByte2._sig, paramArrayOfByte2._sig_key, localt.f, paramLong1, 1);
      }
      t.b();
      localt.h();
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
      paramArrayOfByte2.append(localt.h);
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
        localObject = t.A;
        StringBuilder localStringBuilder = new StringBuilder("new guid:");
        localStringBuilder.append(util.buf_to_string(paramArrayOfByte));
        localStringBuilder.append(" old guid:");
        localStringBuilder.append(util.buf_to_string((byte[])localObject));
        util.LOGD(localStringBuilder.toString());
        if (!Arrays.equals(paramArrayOfByte, (byte[])localObject))
        {
          util.LOGI("fast login info guid not equal", "");
          util.saveGuidToFile(t.t, paramArrayOfByte);
          t.A = (byte[])paramArrayOfByte.clone();
          t.B = (byte[])paramArrayOfByte.clone();
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
        ((StringBuilder)localObject).append("http://imgcache.qq.com/wtlogin");
        ((StringBuilder)localObject).append("/test");
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("http://imgcache.qq.com/wtlogin");
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
  
  private byte[] GetNoPicSigByAccount(String paramString, long paramLong)
  {
    if (paramString == null) {
      return null;
    }
    long l1;
    if (!util.check_uin_account(paramString).booleanValue())
    {
      long l2 = this.mG.b(paramString);
      l1 = l2;
      if (l2 == 0L)
      {
        localObject = null;
        break label61;
      }
    }
    else
    {
      l1 = Long.parseLong(paramString);
    }
    Object localObject = this.mG.a(l1, paramLong);
    label61:
    if ((localObject != null) && (((WloginSigInfo)localObject)._noPicSig != null) && (((WloginSigInfo)localObject)._noPicSig.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder("userAccount:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" dwAppid:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" GetNoPicSigByAccount return: not null");
      util.LOGI(localStringBuilder.toString(), paramString);
      return (byte[])((WloginSigInfo)localObject)._noPicSig.clone();
    }
    localObject = new StringBuilder("userAccount:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" dwAppid:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" GetNoPicSigByAccount return: null");
    util.LOGI(((StringBuilder)localObject).toString(), paramString);
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
      paramWtTicketPromise = this.mG.a(0L);
      paramWUserSigInfo._seqence = paramWtTicketPromise.h;
      async_context localasync_context = t.b(paramWtTicketPromise.h);
      Object localObject1 = new StringBuilder("start GetStWithoutPasswd:user:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" dwSrcAppid:");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(" dwDstAppid:");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append(" dwDstAppPri:");
      ((StringBuilder)localObject1).append(paramLong3);
      ((StringBuilder)localObject1).append(" dwMainSigMap:0x");
      ((StringBuilder)localObject1).append(Integer.toHexString(paramInt1));
      ((StringBuilder)localObject1).append(" dwSubDstAppid:");
      ((StringBuilder)localObject1).append(paramLong4);
      ((StringBuilder)localObject1).append(" Seq:");
      ((StringBuilder)localObject1).append(paramWtTicketPromise.h);
      util.LOGI(((StringBuilder)localObject1).toString(), paramString);
      paramInt2 = util.get_saved_network_type(this.mContext);
      t.D = util.get_network_type(this.mContext);
      if (paramInt2 != t.D)
      {
        util.set_net_retry_type(this.mContext, 0);
        util.save_network_type(this.mContext, t.D);
      }
      t.F = util.get_apn_string(this.mContext).getBytes();
      paramWtTicketPromise.g = paramString;
      paramWtTicketPromise.f = 0L;
      localasync_context._sappid = paramLong1;
      localasync_context._appid = paramLong2;
      localasync_context._sub_appid = paramLong4;
      localasync_context._main_sigmap = paramInt1;
      localasync_context._last_err_msg = new ErrMsg();
      if (paramArrayOfLong != null) {
        localasync_context._sub_appid_list = ((long[])paramArrayOfLong.clone());
      }
      if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
      {
        paramWtTicketPromise.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
        localObject1 = new StringBuilder("MSF SSO SEQ:");
        ((StringBuilder)localObject1).append(paramWtTicketPromise.i);
        util.LOGI(((StringBuilder)localObject1).toString(), paramString);
      }
      else
      {
        paramWtTicketPromise.i = 0;
      }
      t.an.add_t2(new report_t2("exchg", new String(t.C), System.currentTimeMillis(), paramLong2, paramLong4, paramArrayOfLong));
      long l;
      if (!util.check_uin_account(paramString).booleanValue())
      {
        l = paramWtTicketPromise.b(paramString);
        if (l == 0L)
        {
          paramArrayOfLong = new StringBuilder("user:");
          paramArrayOfLong.append(paramString);
          paramArrayOfLong.append(" have not found uin record.");
          util.LOGI(paramArrayOfLong.toString(), paramString);
          paramInt2 = paramInt1;
          paramArrayOfLong = paramWtTicketPromise;
          paramInt1 = -1003;
          break label1753;
        }
      }
      else
      {
        l = Long.parseLong(paramString);
      }
      paramWtTicketPromise.f = l;
      paramWUserSigInfo.uin = String.valueOf(l);
      Object localObject2;
      if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length == 4) && (paramArrayOfByte2[0] != null) && (paramArrayOfByte2[0].length == 1) && (paramArrayOfByte2[0][0] == 1))
      {
        localObject1 = new StringBuilder("user:");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" exchange A2 from A2/D2/KEY.");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramWtTicketPromise.f);
        util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
        if ((paramArrayOfByte2[1] != null) && (paramArrayOfByte2[1].length != 0) && (paramArrayOfByte2[2] != null) && (paramArrayOfByte2[2].length != 0) && (paramArrayOfByte2[3] != null) && (paramArrayOfByte2[3].length != 0))
        {
          paramWtTicketPromise.b = MD5.toMD5Byte(paramArrayOfByte2[3]);
          paramInt2 = new n(paramWtTicketPromise).a(l, paramLong2, paramLong4, 1, paramInt1, paramArrayOfByte2[1], this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, paramArrayOfByte2[2], paramWUserSigInfo);
        }
        else
        {
          paramInt2 = paramInt1;
          paramArrayOfLong = paramWtTicketPromise;
          paramInt1 = -1004;
          break label1753;
        }
      }
      else if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length == 3) && (paramArrayOfByte2[0] != null) && (paramArrayOfByte2[0].length == 1) && (paramArrayOfByte2[0][0] == 2))
      {
        localObject1 = new StringBuilder("user:");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" exchange A2 from A2/A2KEY.");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramWtTicketPromise.f);
        util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
        if ((paramArrayOfByte2[1] != null) && (paramArrayOfByte2[1].length != 0) && (paramArrayOfByte2[2] != null) && (paramArrayOfByte2[2].length != 0))
        {
          paramWtTicketPromise.b = paramArrayOfByte2[2];
          paramInt2 = new n(paramWtTicketPromise).a(l, paramLong2, paramLong4, 1, paramInt1, paramArrayOfByte2[1], this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, null, paramWUserSigInfo);
        }
        else
        {
          paramInt2 = paramInt1;
          paramArrayOfLong = paramWtTicketPromise;
          paramInt1 = -1004;
          break label1753;
        }
      }
      else
      {
        paramWtTicketPromise.j();
        localObject1 = GetA1ByAccount(String.valueOf(paramWtTicketPromise.f), paramLong1);
        localObject2 = GetNoPicSigByAccount(String.valueOf(paramWtTicketPromise.f), paramLong1);
        if ((localObject1 != null) && (localObject1.length > 0) && (localObject2 != null) && (localObject2.length > 0))
        {
          paramArrayOfByte2 = new StringBuilder("user:");
          paramArrayOfByte2.append(paramString);
          paramArrayOfByte2.append(" exchange A2 from A1.");
          paramArrayOfByte2 = paramArrayOfByte2.toString();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramWtTicketPromise.f);
          util.LOGI(paramArrayOfByte2, ((StringBuilder)localObject3).toString());
          paramArrayOfByte2 = localasync_context;
          paramArrayOfByte2._tmp_pwd = ((byte[])localObject1);
          paramArrayOfByte2._tmp_no_pic_sig = ((byte[])localObject2);
          if ((paramWUserSigInfo._in_ksid != null) && (paramWUserSigInfo._in_ksid.length > 0)) {
            paramArrayOfByte2 = (byte[])paramWUserSigInfo._in_ksid.clone();
          } else {
            paramArrayOfByte2 = t.aa;
          }
          localObject3 = new y(paramWtTicketPromise, this.mContext);
          WloginSigInfo localWloginSigInfo = FindUserSig(l, paramLong1);
          if (localWloginSigInfo != null) {
            ((y)localObject3).a(localWloginSigInfo);
          }
          i = ((y)localObject3).a(paramLong2, 1, paramWtTicketPromise.f, 0, t.ad, (byte[])localObject1, (byte[])localObject2, this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, paramInt1, paramLong4, 1, t.y, 0, 0, 1, paramArrayOfByte2, paramLong1, paramWUserSigInfo);
          paramInt2 = i;
          if (i == 204) {
            paramInt2 = new q(paramWtTicketPromise).a(this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, paramWUserSigInfo);
          }
        }
        else
        {
          paramArrayOfByte2 = new StringBuilder("user:");
          paramArrayOfByte2.append(paramString);
          paramArrayOfByte2.append(" exchange A2 from A2.");
          paramArrayOfByte2 = paramArrayOfByte2.toString();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramWtTicketPromise.f);
          util.LOGI(paramArrayOfByte2, ((StringBuilder)localObject1).toString());
          paramArrayOfByte2 = paramWtTicketPromise.a(l, paramLong1);
          if ((paramArrayOfByte2 == null) || (paramArrayOfByte2._TGT == null) || (paramArrayOfByte2._TGT.length == 0) || (paramArrayOfByte2.iSExpireA2(t.f()))) {
            break label1736;
          }
          localObject1 = new StringBuilder("user:");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append(" exchange A2 from A2 without Priority.");
          localObject1 = ((StringBuilder)localObject1).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramWtTicketPromise.f);
          util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
          printTicket(paramArrayOfByte2);
          paramWtTicketPromise.b = paramArrayOfByte2._TGTKey;
          paramInt2 = new n(paramWtTicketPromise).a(l, paramLong2, paramLong4, 1, paramInt1, paramArrayOfByte2._TGT, this.mMiscBitmap, this.mSubSigMap, paramArrayOfLong, null, paramWUserSigInfo);
        }
      }
      if (paramInt2 == 0)
      {
        paramArrayOfByte2 = paramWtTicketPromise;
        localObject1 = paramArrayOfByte2.a(l, paramLong2);
        if (localObject1 == null)
        {
          paramInt2 = paramInt1;
          paramInt1 = -1004;
          paramArrayOfLong = paramArrayOfByte2;
          break label1753;
        }
        paramWUserSigInfo.get_clone((WloginSigInfo)localObject1);
        if ((paramArrayOfLong != null) && (paramArrayOfByte1 != null) && (paramArrayOfLong.length * 2 == paramArrayOfByte1.length))
        {
          i = 0;
          while (i < paramArrayOfLong.length)
          {
            localObject1 = paramArrayOfByte2.a(l, paramArrayOfLong[i]);
            if (localObject1 != null)
            {
              int j = i * 2;
              paramArrayOfByte1[j] = ((byte[])((WloginSigInfo)localObject1)._userSt_Key.clone());
              paramArrayOfByte1[(j + 1)] = ((byte[])((WloginSigInfo)localObject1)._userStSig.clone());
            }
            i += 1;
          }
          i = paramInt1;
        }
        else
        {
          i = paramInt1;
        }
      }
      else
      {
        i = paramInt1;
      }
      paramArrayOfLong = paramWtTicketPromise;
      paramInt1 = paramInt2;
      paramInt2 = i;
      break label1753;
      label1736:
      paramArrayOfLong = paramWtTicketPromise;
      int i = -1004;
      paramInt2 = paramInt1;
      paramInt1 = i;
      label1753:
      paramWUserSigInfo = GetUserSigInfoTicket(paramWUserSigInfo, 128);
      if (paramWUserSigInfo == null) {
        paramWUserSigInfo = new Ticket();
      }
      t.an.commit_t2(paramArrayOfLong.f, paramArrayOfLong.g, util.format_ret_code(paramInt1), paramInt1);
      if (paramInt1 == 0)
      {
        if ((paramWUserSigInfo._sig != null) && (paramWUserSigInfo._sig.length != 0)) {
          RequestReport(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, paramArrayOfLong.f, localasync_context._appid);
        }
      }
      else {
        RequestReportError(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, paramArrayOfLong.f, localasync_context._appid, 0);
      }
      if ((paramArrayOfLong.d != null) && (paramArrayOfLong.d.get_bitmap() != 0))
      {
        this.mG.d = paramArrayOfLong.d;
        RequestReportError(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, paramArrayOfLong.f, localasync_context._appid, 1);
      }
      t.b();
      paramArrayOfLong.h();
      paramWUserSigInfo = new StringBuilder("end GetStWithoutPasswd:user:");
      paramWUserSigInfo.append(paramString);
      paramWUserSigInfo.append(" dwSrcAppid:");
      paramWUserSigInfo.append(paramLong1);
      paramWUserSigInfo.append(" dwDstAppid:");
      paramWUserSigInfo.append(paramLong2);
      paramWUserSigInfo.append(" dwDstAppPri:");
      paramWUserSigInfo.append(paramLong3);
      paramWUserSigInfo.append(" dwMainSigMap:0x");
      paramWUserSigInfo.append(Integer.toHexString(paramInt2));
      paramWUserSigInfo.append(" dwSubDstAppid:");
      paramWUserSigInfo.append(paramLong4);
      paramWUserSigInfo.append(" Seq:");
      paramWUserSigInfo.append(paramArrayOfLong.h);
      paramWUserSigInfo.append(" ret=");
      paramWUserSigInfo.append(paramInt1);
      paramString = paramWUserSigInfo.toString();
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append(paramArrayOfLong.f);
      util.LOGI(paramString, paramWUserSigInfo.toString());
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
    if (paramInt == 4194304)
    {
      util.LOGI("get lhsig", "");
      return new Ticket(4194304, WloginSigInfo._LHSig, null, t.f(), 0L);
    }
    if (paramInt == 67108864)
    {
      util.LOGI("get qrpushsig", "");
      return new Ticket(67108864, WloginSigInfo._QRPUSHSig, null, t.f(), 0L);
    }
    if (paramWUserSigInfo == null)
    {
      paramWUserSigInfo = new StringBuilder("userInfo is null ");
      paramWUserSigInfo.append(Integer.toHexString(paramInt));
      util.LOGI(paramWUserSigInfo.toString(), "");
      return null;
    }
    if (paramWUserSigInfo._tickets == null)
    {
      localObject = new StringBuilder("tickets is null ");
      ((StringBuilder)localObject).append(Integer.toHexString(paramInt));
      util.LOGI(((StringBuilder)localObject).toString(), paramWUserSigInfo.uin);
      return null;
    }
    Object localObject = new StringBuilder("GetUserSigInfoTicket ticket type:0x");
    ((StringBuilder)localObject).append(Integer.toHexString(paramInt));
    util.LOGI(((StringBuilder)localObject).toString(), "");
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
    return null;
  }
  
  private void OnDeviceLockRequest(String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    DevlockRst localDevlockRst = DevlockBase.rst;
    localDevlockRst.commRsp = new TLV_CommRsp();
    DevlockInfo localDevlockInfo = new DevlockInfo();
    int j = 0;
    ErrMsg localErrMsg = new ErrMsg(0, "", "", "");
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
          int k = new oicq.wlogin_sdk.devicelock.b().parse_rsp(paramTransReqContext.get_body());
          util.LOGI("CloseDevLock ret:".concat(String.valueOf(k)), paramString);
          i = k;
          if (k != -1009)
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
              paramInt = j;
              for (;;)
              {
                i = k;
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
              i = k;
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
    if (this.mListener == null) {
      return;
    }
    oicq.wlogin_sdk.code2d.c localc = oicq.wlogin_sdk.code2d.b._status;
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
          this.mListener.OnCloseCode(paramString, localc.d, localc.c, paramWUserSigInfo, localc.f, paramInt);
          return;
        }
        oicq.wlogin_sdk.code2d.a locala = new oicq.wlogin_sdk.code2d.a();
        if (paramWUserSigInfo == null) {
          paramWUserSigInfo = new WUserSigInfo();
        }
        localc.b = locala.a(paramTransReqContext.get_body(), paramLong1, t.t, paramWUserSigInfo.loginTLVMap);
        paramTransReqContext = new StringBuilder("CloseCode ret:");
        paramTransReqContext.append(localc.b);
        util.LOGI(paramTransReqContext.toString(), paramString);
        oicq.wlogin_sdk.code2d.c.t = false;
        this.mListener.OnCloseCode(paramString, localc.d, localc.c, paramWUserSigInfo, localc.f, localc.b);
        return;
      case 19: 
        if (paramInt != 0)
        {
          this.mListener.OnVerifyCode(paramString, localc.d, localc.c, localc.e, paramWUserSigInfo, localc.f, paramInt);
          return;
        }
        localc.b = new oicq.wlogin_sdk.code2d.e().a(paramTransReqContext.get_body());
        paramTransReqContext = new StringBuilder("VerifyCode ret:");
        paramTransReqContext.append(localc.b);
        util.LOGI(paramTransReqContext.toString(), paramString);
        if ((localc.b == 0) && (localc.g != null) && (localc.g.length > 0)) {
          this.mG.a(localc.a, paramLong1, localc.g);
        }
        this.mListener.OnVerifyCode(paramString, localc.d, localc.c, localc.e, paramWUserSigInfo, localc.f, localc.b);
        return;
      }
      if (paramInt == 0)
      {
        paramInt = new oicq.wlogin_sdk.code2d.d().a(paramTransReqContext.get_body());
        paramTransReqContext = new StringBuilder("QueryCodeResult ret:");
        paramTransReqContext.append(localc.b);
        util.LOGI(paramTransReqContext.toString(), paramString);
      }
      this.mListener.OnQueryCodeResult(localc.a, localc.e, localc.c, paramWUserSigInfo, localc.f, paramInt);
      return;
    }
    if (paramInt == 0)
    {
      paramInt = new fetch_code().get_response(paramTransReqContext.get_body());
      paramTransReqContext = new StringBuilder("FetchCodeSig ret:");
      paramTransReqContext.append(localc.b);
      util.LOGI(paramTransReqContext.toString(), paramString);
    }
    this.mListener.OnFetchCodeSig(localc.j, localc.k, localc.l, paramWUserSigInfo, localc.f, paramInt);
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
          paramInt = oicq.wlogin_sdk.a.a.f(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.h)localObject1);
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
          paramString.append(((oicq.wlogin_sdk.a.h)localObject1).d);
          util.LOGI(paramString.toString(), "");
          paramWUserSigInfo.regTLVMap = ((oicq.wlogin_sdk.a.h)localObject1).B;
          ((oicq.wlogin_sdk.a.h)localObject1).B = new HashMap();
          this.mListener.OnQuickRegisterGetAccount(paramWUserSigInfo, ((oicq.wlogin_sdk.a.h)localObject1).d, ((oicq.wlogin_sdk.a.h)localObject1).f);
          return;
        case 16: 
          paramInt = oicq.wlogin_sdk.a.a.e(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.h)localObject1);
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
          paramString.append(((oicq.wlogin_sdk.a.h)localObject1).d);
          util.LOGI(paramString.toString(), "");
          this.mListener.OnQuickRegisterCheckAccount(paramWUserSigInfo, ((oicq.wlogin_sdk.a.h)localObject1).d, ((oicq.wlogin_sdk.a.h)localObject1).f);
          return;
        }
        break;
      case 7: 
        paramInt = oicq.wlogin_sdk.a.a.d(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.h)localObject1);
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
        paramString.append(((oicq.wlogin_sdk.a.h)localObject1).d);
        util.LOGI(paramString.toString(), "");
        paramString = this.mListener;
        if (paramString == null) {
          break;
        }
        paramString.OnRegQueryAccount(paramWUserSigInfo, ((oicq.wlogin_sdk.a.h)localObject1).d, ((oicq.wlogin_sdk.a.h)localObject1).f);
        return;
      case 6: 
        paramInt = oicq.wlogin_sdk.a.a.c(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.h)localObject1);
        if (paramInt != 0)
        {
          paramString = this.mListener;
          if (paramString == null) {
            break;
          }
          paramString.OnRegError(paramWUserSigInfo, paramInt, ((String)localObject2).getBytes());
          return;
        }
        paramWUserSigInfo.regTLVMap = ((oicq.wlogin_sdk.a.h)localObject1).B;
        ((oicq.wlogin_sdk.a.h)localObject1).B = new HashMap();
        paramString = new StringBuilder("reg cmd:");
        paramString.append(paramTransReqContext.get_subcmd());
        paramString.append(" ret:");
        paramString.append(((oicq.wlogin_sdk.a.h)localObject1).d);
        util.LOGI(paramString.toString(), "");
        if (this.mListener == null) {
          break;
        }
        if ((((oicq.wlogin_sdk.a.h)localObject1).b != null) && (((oicq.wlogin_sdk.a.h)localObject1).b.indexOf("-") > 0))
        {
          paramInt = ((oicq.wlogin_sdk.a.h)localObject1).b.indexOf("-");
          paramString = ((oicq.wlogin_sdk.a.h)localObject1).b.substring(0, paramInt);
          if (paramString.equals("86"))
          {
            ((oicq.wlogin_sdk.a.h)localObject1).b = ((oicq.wlogin_sdk.a.h)localObject1).b.substring(paramInt + 1);
          }
          else
          {
            paramTransReqContext = new StringBuilder("00");
            paramTransReqContext.append(paramString);
            paramTransReqContext.append(((oicq.wlogin_sdk.a.h)localObject1).b.substring(paramInt + 1));
            ((oicq.wlogin_sdk.a.h)localObject1).b = paramTransReqContext.toString();
          }
        }
        if ((((oicq.wlogin_sdk.a.h)localObject1).b != null) && (((oicq.wlogin_sdk.a.h)localObject1).b.length() != 0))
        {
          this.mG.d(((oicq.wlogin_sdk.a.h)localObject1).b);
          this.mG.a(((oicq.wlogin_sdk.a.h)localObject1).b, Long.valueOf(((oicq.wlogin_sdk.a.h)localObject1).u));
        }
        paramString = new StringBuilder("reg userAccount: ");
        paramString.append(((oicq.wlogin_sdk.a.h)localObject1).b);
        paramString = paramString.toString();
        paramTransReqContext = new StringBuilder();
        paramTransReqContext.append(((oicq.wlogin_sdk.a.h)localObject1).u);
        util.LOGI(paramString, paramTransReqContext.toString());
        if (oicq.wlogin_sdk.a.h.z.length() > 0)
        {
          this.mListener.OnRegGetSMSVerifyLoginAccount(paramWUserSigInfo, ((oicq.wlogin_sdk.a.h)localObject1).d, ((oicq.wlogin_sdk.a.h)localObject1).u, ((oicq.wlogin_sdk.a.h)localObject1).v, ((oicq.wlogin_sdk.a.h)localObject1).w, ((oicq.wlogin_sdk.a.h)localObject1).f);
          return;
        }
        this.mListener.OnRegGetAccount(paramWUserSigInfo, ((oicq.wlogin_sdk.a.h)localObject1).d, ((oicq.wlogin_sdk.a.h)localObject1).u, ((oicq.wlogin_sdk.a.h)localObject1).v, ((oicq.wlogin_sdk.a.h)localObject1).w, ((oicq.wlogin_sdk.a.h)localObject1).f);
        return;
      case 5: 
        paramInt = oicq.wlogin_sdk.a.a.b(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.h)localObject1);
        if (paramInt != 0)
        {
          paramString = this.mListener;
          if (paramString == null) {
            break;
          }
          paramString.OnRegError(paramWUserSigInfo, paramInt, ((String)localObject2).getBytes());
          return;
        }
        paramWUserSigInfo.regTLVMap = ((oicq.wlogin_sdk.a.h)localObject1).B;
        ((oicq.wlogin_sdk.a.h)localObject1).B = new HashMap();
        paramString = new StringBuilder("reg cmd:");
        paramString.append(paramTransReqContext.get_subcmd());
        paramString.append(" ret:");
        paramString.append(((oicq.wlogin_sdk.a.h)localObject1).d);
        util.LOGI(paramString.toString(), "");
        paramString = this.mListener;
        if (paramString == null) {
          break;
        }
        paramString.OnRegSubmitMsgChk(paramWUserSigInfo, ((oicq.wlogin_sdk.a.h)localObject1).d, ((oicq.wlogin_sdk.a.h)localObject1).f);
        return;
      case 4: 
        paramInt = oicq.wlogin_sdk.a.a.a(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.h)localObject1);
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
        ((StringBuilder)localObject2).append(((oicq.wlogin_sdk.a.h)localObject1).d);
        util.LOGI(((StringBuilder)localObject2).toString(), "");
        if (((oicq.wlogin_sdk.a.h)localObject1).d == 0)
        {
          paramString = this.mListener;
          if (paramString == null) {
            break;
          }
          paramString.OnRegRequestServerResendMsg(paramWUserSigInfo, ((oicq.wlogin_sdk.a.h)localObject1).d, ((oicq.wlogin_sdk.a.h)localObject1).s, ((oicq.wlogin_sdk.a.h)localObject1).t);
          return;
        }
        if (((oicq.wlogin_sdk.a.h)localObject1).d == 3)
        {
          paramString = this.mListener;
          if (paramString == null) {
            break;
          }
          paramString.OnRegCheckValidUrl(paramWUserSigInfo, ((oicq.wlogin_sdk.a.h)localObject1).r);
          return;
        }
        if (((oicq.wlogin_sdk.a.h)localObject1).d == 5)
        {
          paramString = this.mListener;
          if (paramString == null) {
            break;
          }
          paramString.OnRegRequestServerResendMsg(paramWUserSigInfo, ((oicq.wlogin_sdk.a.h)localObject1).d, ((oicq.wlogin_sdk.a.h)localObject1).s, ((oicq.wlogin_sdk.a.h)localObject1).t);
          return;
        }
        util.LOGW("OnRequestRegister 0x4 return code:", String.valueOf(((oicq.wlogin_sdk.a.h)localObject1).d), paramString);
        paramString = this.mListener;
        if (paramString == null) {
          break;
        }
        paramString.OnRegError(paramWUserSigInfo, ((oicq.wlogin_sdk.a.h)localObject1).d, ((oicq.wlogin_sdk.a.h)localObject1).f);
        return;
      case 3: 
        paramInt = oicq.wlogin_sdk.a.a.a(3, paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.h)localObject1);
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
        ((StringBuilder)localObject2).append(((oicq.wlogin_sdk.a.h)localObject1).d);
        util.LOGI(((StringBuilder)localObject2).toString(), "");
        if ((((oicq.wlogin_sdk.a.h)localObject1).d != 0) && (((oicq.wlogin_sdk.a.h)localObject1).d != 4) && (((oicq.wlogin_sdk.a.h)localObject1).d != 31) && (((oicq.wlogin_sdk.a.h)localObject1).d != 118))
        {
          if (((oicq.wlogin_sdk.a.h)localObject1).d == 3)
          {
            paramString = this.mListener;
            if (paramString == null) {
              break;
            }
            paramString.OnRegCheckValidUrl(paramWUserSigInfo, ((oicq.wlogin_sdk.a.h)localObject1).r);
            return;
          }
          util.LOGW("OnRequestRegister 0x3 return code:", String.valueOf(((oicq.wlogin_sdk.a.h)localObject1).d), paramString);
          paramString = this.mListener;
          if (paramString == null) {
            break;
          }
          paramString.OnRegError(paramWUserSigInfo, ((oicq.wlogin_sdk.a.h)localObject1).d, ((oicq.wlogin_sdk.a.h)localObject1).f);
          return;
        }
        if (((oicq.wlogin_sdk.a.h)localObject1).d == 0)
        {
          paramWUserSigInfo.regTLVMap = ((oicq.wlogin_sdk.a.h)localObject1).B;
          ((oicq.wlogin_sdk.a.h)localObject1).B = new HashMap();
        }
        this.mListener.OnRegQueryClientSentMsgStatus(paramWUserSigInfo, ((oicq.wlogin_sdk.a.h)localObject1).d, ((oicq.wlogin_sdk.a.h)localObject1).s, ((oicq.wlogin_sdk.a.h)localObject1).t, new String(((oicq.wlogin_sdk.a.h)localObject1).f));
        return;
      }
    }
    else
    {
      paramInt = oicq.wlogin_sdk.a.a.a(paramTransReqContext.get_body(), (oicq.wlogin_sdk.a.h)localObject1);
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
      ((StringBuilder)localObject2).append(((oicq.wlogin_sdk.a.h)localObject1).d);
      util.LOGI(((StringBuilder)localObject2).toString(), "");
      if (((oicq.wlogin_sdk.a.h)localObject1).d == 0)
      {
        paramString = this.mListener;
        if (paramString != null) {
          paramString.OnRegCheckDownloadMsg(paramWUserSigInfo, ((oicq.wlogin_sdk.a.h)localObject1).m, ((oicq.wlogin_sdk.a.h)localObject1).n);
        }
      }
      else if (((oicq.wlogin_sdk.a.h)localObject1).d == 2)
      {
        paramString = this.mListener;
        if (paramString != null) {
          paramString.OnRegCheckUploadMsg(paramWUserSigInfo, new String(((oicq.wlogin_sdk.a.h)localObject1).q));
        }
      }
      else if (((oicq.wlogin_sdk.a.h)localObject1).d == 3)
      {
        paramString = this.mListener;
        if (paramString != null) {
          paramString.OnRegCheckValidUrl(paramWUserSigInfo, ((oicq.wlogin_sdk.a.h)localObject1).r);
        }
      }
      else
      {
        if ((((oicq.wlogin_sdk.a.h)localObject1).d == 6) || (((oicq.wlogin_sdk.a.h)localObject1).d == 44)) {
          break label1877;
        }
        util.LOGW("OnRequestRegister 0xa return code:", String.valueOf(((oicq.wlogin_sdk.a.h)localObject1).d), paramString);
        paramString = this.mListener;
        if (paramString != null)
        {
          paramString.OnRegError(paramWUserSigInfo, ((oicq.wlogin_sdk.a.h)localObject1).d, ((oicq.wlogin_sdk.a.h)localObject1).f);
          return;
        }
      }
    }
    return;
    label1877:
    paramString = this.mListener;
    if (paramString != null) {
      paramString.OnRegCheckWebSig(paramWUserSigInfo, new String(((oicq.wlogin_sdk.a.h)localObject1).r), new String(((oicq.wlogin_sdk.a.h)localObject1).f));
    }
    ((oicq.wlogin_sdk.a.h)localObject1).r = new byte[0];
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
      t localt = this.mG.a(paramWUserSigInfo._seqence);
      paramWUserSigInfo._seqence = localt.h;
      async_context localasync_context = t.b(localt.h);
      StringBuilder localStringBuilder = new StringBuilder("user:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" Seq:");
      localStringBuilder.append(localt.h);
      localStringBuilder.append(" RefreshPictureData ...");
      util.LOGI(localStringBuilder.toString(), String.valueOf(paramString));
      localt.g = paramString;
      localasync_context._last_err_msg = new ErrMsg();
      long l;
      if (!util.check_uin_account(paramString).booleanValue())
      {
        l = localt.b(paramString);
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
        localt.f = l;
      }
      int i = new r(localt).a(this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo);
      paramInt = i;
      if (i == 2) {
        paramInt = 0;
      }
      paramWUserSigInfo = new StringBuilder("user:");
      paramWUserSigInfo.append(paramString);
      paramWUserSigInfo.append(" Seq:");
      paramWUserSigInfo.append(localt.h);
      paramWUserSigInfo.append(" RefreshPictureData ret=");
      paramWUserSigInfo.append(paramInt);
      util.LOGI(paramWUserSigInfo.toString(), String.valueOf(paramString));
      return paramInt;
    }
    return -1017;
  }
  
  private int RefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, int paramInt)
  {
    if ((paramString != null) && (paramWUserSigInfo != null))
    {
      if (paramInt == 0)
      {
        new HelperThread(this, this.mHelperHandler, paramString, paramLong, paramWUserSigInfo, "RefreshSMSData").RunReq(3);
        return -1001;
      }
      if (paramWUserSigInfo._seqence == 0L) {
        paramWUserSigInfo._seqence = this.mAysncSeq;
      }
      t localt = this.mG.a(paramWUserSigInfo._seqence);
      paramWUserSigInfo._seqence = localt.h;
      async_context localasync_context = t.b(localt.h);
      StringBuilder localStringBuilder = new StringBuilder("user:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" smsAppid:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" Seq:");
      localStringBuilder.append(localt.h);
      localStringBuilder.append(" RefreshSMSData ...");
      util.LOGI(localStringBuilder.toString(), String.valueOf(paramString));
      localt.g = paramString;
      localasync_context._last_err_msg = new ErrMsg();
      long l;
      if (!util.check_uin_account(paramString).booleanValue())
      {
        l = localt.b(paramString);
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
        localt.f = l;
      }
      int i = new s(localt).a(paramLong, this.mMiscBitmap, this.mSubSigMap, localasync_context._sub_appid_list, paramWUserSigInfo);
      paramInt = i;
      if (i == 160) {
        paramInt = 0;
      }
      paramWUserSigInfo = new StringBuilder("user:");
      paramWUserSigInfo.append(paramString);
      paramWUserSigInfo.append(" smsAppid:");
      paramWUserSigInfo.append(paramLong);
      paramWUserSigInfo.append(" Seq:");
      paramWUserSigInfo.append(localt.h);
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
      t localt = this.mG.a(paramWUserSigInfo._seqence);
      paramWUserSigInfo._seqence = localt.h;
      Object localObject = t.b(localt.h);
      StringBuilder localStringBuilder = new StringBuilder("user:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" Seq:");
      localStringBuilder.append(localt.h);
      localStringBuilder.append(" RefreshSMSVerifyLoginCode ...");
      util.LOGI(localStringBuilder.toString(), paramString);
      localt.g = paramString;
      ((async_context)localObject)._last_err_msg = new ErrMsg();
      paramInt = new w(localt).a(this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
      localObject = new StringBuilder("user:");
      ((StringBuilder)localObject).append(localt.g);
      ((StringBuilder)localObject).append(" Seq:");
      ((StringBuilder)localObject).append(localt.h);
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
  
  private int RegSubmitMobile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0) && (paramArrayOfByte4 != null))
    {
      if (paramArrayOfByte1 == null) {
        paramArrayOfByte3 = new byte[0];
      } else {
        paramArrayOfByte3 = paramArrayOfByte1;
      }
      byte[] arrayOfByte = t.E;
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
      oicq.wlogin_sdk.a.h localh = this.mRegStatus;
      localh.k = paramArrayOfByte2;
      localh.g = paramLong1;
      localh.h = paramLong2;
      localTransReqContext.set_register_req();
      localTransReqContext.set_subcmd(((oicq.wlogin_sdk.a.f)localObject).a());
      localTransReqContext._body = ((oicq.wlogin_sdk.a.f)localObject).a(paramArrayOfByte2, arrayOfByte, paramArrayOfByte4, paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, null, util.generateGuid(this.mContext), util.get_IMSI(this.mContext), t.aa, l, paramArrayOfByte1, GetGuid(), paramArrayOfByte3, paramWUserSigInfo.extraRegTLVMap);
      return RequestTransport(0, 1, null, 0L, localh.i, localTransReqContext, paramWUserSigInfo);
    }
    return -1017;
  }
  
  private int RequestInit()
  {
    oicq.wlogin_sdk.tools.d.a(this.mContext);
    try
    {
      int i = util.get_saved_network_type(this.mContext);
      t.d();
      int j = ShareKeyInit();
      AsyncGenRSAKey();
      StringBuilder localStringBuilder = new StringBuilder("init ok ret:");
      localStringBuilder.append(j);
      localStringBuilder.append(" os ver:");
      localStringBuilder.append(new String(t.J));
      localStringBuilder.append(" saved_network_type:");
      localStringBuilder.append(i);
      localStringBuilder.append(" network_type:");
      localStringBuilder.append(t.D);
      localStringBuilder.append(" svn 2202 at ");
      localStringBuilder.append(t.l());
      util.LOGI(localStringBuilder.toString(), "");
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
    t localt = this.mG.a(0L);
    localt.f = paramLong1;
    StringBuilder localStringBuilder = new StringBuilder("user:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" appid:");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(" Seq:");
    localStringBuilder.append(localt.h);
    localStringBuilder.append(" RequestReport...");
    util.LOGI(localStringBuilder.toString(), String.valueOf(paramLong1));
    paramInt = new z(localt).a(paramLong1, null, paramArrayOfByte1, paramArrayOfByte2, paramLong2, new WUserSigInfo());
    localt.i();
    paramArrayOfByte1 = new StringBuilder("user:");
    paramArrayOfByte1.append(paramLong1);
    paramArrayOfByte1.append(" appid:");
    paramArrayOfByte1.append(paramLong2);
    paramArrayOfByte1.append(" Seq:");
    paramArrayOfByte1.append(localt.h);
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
    t localt = this.mG.a(0L);
    localt.d = this.mG.d;
    localt.f = paramLong1;
    StringBuilder localStringBuilder = new StringBuilder("user:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" appid:");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(" Seq:");
    localStringBuilder.append(localt.h);
    localStringBuilder.append(" RequestReportError...");
    util.LOGI(localStringBuilder.toString(), String.valueOf(paramLong1));
    paramInt1 = new u(localt).a(paramLong1, null, paramArrayOfByte1, paramArrayOfByte2, paramLong2, paramInt2);
    paramArrayOfByte1 = new StringBuilder("user:");
    paramArrayOfByte1.append(paramLong1);
    paramArrayOfByte1.append(" appid:");
    paramArrayOfByte1.append(paramLong2);
    paramArrayOfByte1.append(" Seq:");
    paramArrayOfByte1.append(localt.h);
    paramArrayOfByte1.append(" RequestReportError ret=");
    paramArrayOfByte1.append(paramInt1);
    util.LOGI(paramArrayOfByte1.toString(), String.valueOf(paramLong1));
    return paramInt1;
  }
  
  private int ShareKeyInit()
  {
    util.LOGI("start ShareKeyInit", "");
    EcdhCrypt localEcdhCrypt = new EcdhCrypt(this.mContext);
    if (this.isForLocal) {
      return localEcdhCrypt.initShareKeyByDefault();
    }
    int i = localEcdhCrypt.initShareKey();
    util.LOGI("end ShareKeyInit", "");
    this.mG.n = localEcdhCrypt.get_c_pub_key();
    this.mG.p = localEcdhCrypt.get_g_share_key();
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
      t localt = this.mG.a(paramWUserSigInfo._seqence);
      paramWUserSigInfo._seqence = localt.h;
      async_context localasync_context = t.b(localt.h);
      StringBuilder localStringBuilder = new StringBuilder("user:");
      localStringBuilder.append(localt.g);
      localStringBuilder.append(" code:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" Seq:");
      localStringBuilder.append(localt.h);
      localStringBuilder.append(" VerifySMSVerifyLoginCode ...");
      util.LOGI(localStringBuilder.toString(), paramString1);
      localt.g = paramString1;
      localasync_context._last_err_msg = new ErrMsg();
      localasync_context._mpasswd = util.get_mpasswd();
      paramInt = new x(localt).a(paramString2, this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
      paramWUserSigInfo = new StringBuilder("user:");
      paramWUserSigInfo.append(paramString1);
      paramWUserSigInfo.append(" code:");
      paramWUserSigInfo.append(paramString2);
      paramWUserSigInfo.append(" Seq:");
      paramWUserSigInfo.append(localt.h);
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
    t.at = paramString;
    util.LOGI("set log dir ".concat(String.valueOf(paramString)), "");
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
    t localt = this.mG.a(0L);
    localt.f = Long.parseLong(paramString1);
    localt.g = paramQuickLoginParam.userAccount;
    localWUserSigInfo._seqence = localt.h;
    this.mAysncSeq = localt.h;
    async_context localasync_context = t.b(localt.h);
    Object localObject = new StringBuilder("getStWithPtSig seq:");
    ((StringBuilder)localObject).append(localt.h);
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
    paramInt = new c(localt, paramString2).a(this.mMiscBitmap, this.mSubSigMap, localWUserSigInfo);
    if (paramInt != 0)
    {
      paramString2 = new StringBuilder("VerifyPTSig seq ");
      paramString2.append(localt.h);
      paramString2.append(" ret ");
      paramString2.append(paramInt);
      util.LOGI(paramString2.toString(), paramString1);
      return paramInt;
    }
    localasync_context._tmp_pwd = MD5.toMD5Byte(localasync_context._mpasswd.getBytes());
    paramString2 = new l(localt, this.mContext);
    paramString2.g();
    paramInt = paramString2.a(paramQuickLoginParam.appid, paramQuickLoginParam.subAppid, localt.f, 0, t.ad, util.getRequestInitTime(), localasync_context._tmp_pwd, 4, this.mMiscBitmap, this.mSubSigMap, paramQuickLoginParam.dstSubAppidList, paramQuickLoginParam.sigMap, paramQuickLoginParam.subAppid, t.y, 0, 0, 1, t.aa, localWUserSigInfo);
    if (paramInt == 204) {
      paramInt = new q(localt).a(this.mMiscBitmap, this.mSubSigMap, paramQuickLoginParam.dstSubAppidList, localWUserSigInfo);
    }
    if (paramInt != 0)
    {
      paramString2 = new StringBuilder("getStWithPtSig seq:");
      paramString2.append(localt.h);
      paramString2.append(" ret:");
      paramString2.append(paramInt);
      util.LOGI(paramString2.toString(), paramString1);
      return paramInt;
    }
    paramString2 = localt.a(localt.f, paramQuickLoginParam.appid);
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
        paramString2 = localt.a(localt.f, paramQuickLoginParam.dstSubAppidList[i]);
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
    t.an.commit_t2(localt.f, localt.g, util.format_ret_code(paramInt), paramInt);
    if (paramInt == 0)
    {
      if ((paramString2._sig != null) && (paramString2._sig.length != 0)) {
        RequestReport(0, paramString2._sig, paramString2._sig_key, localt.f, localasync_context._appid);
      }
    }
    else
    {
      i = paramInt;
      paramQuickLoginParam = paramString2;
      if ((i != 2) && (i != 160)) {
        RequestReportError(0, paramQuickLoginParam._sig, paramQuickLoginParam._sig_key, localt.f, localasync_context._appid, 0);
      }
    }
    if ((localt.d != null) && (localt.d.get_bitmap() != 0))
    {
      this.mG.d = localt.d;
      RequestReportError(0, paramString2._sig, paramString2._sig_key, localt.f, localasync_context._appid, 1);
    }
    t.b();
    localt.h();
    paramString2 = new StringBuilder("getStWithPtSig seq:");
    paramString2.append(localt.h);
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
    t localt = this.mG.a(0L);
    ((WUserSigInfo)localObject1)._seqence = localt.h;
    this.mAysncSeq = localt.h;
    async_context localasync_context = t.b(localt.h);
    paramInt = util.get_saved_network_type(this.mContext);
    t.D = util.get_network_type(this.mContext);
    int j = t.D;
    int i = 0;
    if (paramInt != j)
    {
      util.set_net_retry_type(this.mContext, 0);
      util.save_network_type(this.mContext, t.D);
    }
    t.F = util.get_apn_string(this.mContext).getBytes();
    paramQuickLoginParam.sigMap |= 0xC0;
    localt.g = paramString;
    localt.f = Long.parseLong(paramString);
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
      localt.i = util.buf_to_int32(((WUserSigInfo)localObject1)._reserveData, 0);
      localObject2 = new StringBuilder("MSF SSO SEQ:");
      ((StringBuilder)localObject2).append(localt.i);
      util.LOGI(((StringBuilder)localObject2).toString(), paramString);
    }
    else
    {
      localt.i = 0;
    }
    if ((((WUserSigInfo)localObject1)._fastLoginBuf != null) && (((WUserSigInfo)localObject1)._fastLoginBuf.length != 0))
    {
      if (GetFastLoginInfo(((WUserSigInfo)localObject1)._fastLoginBuf, localasync_context) < 0)
      {
        paramQuickLoginParam = new StringBuilder("GetFastLoginInfo fast login buff is failed seq:");
        paramQuickLoginParam.append(localt.i);
        util.LOGI(paramQuickLoginParam.toString(), paramString);
        return -1017;
      }
      localObject2 = new l(localt, this.mContext);
      ((l)localObject2).g();
      paramInt = ((l)localObject2).a(paramQuickLoginParam.appid, paramQuickLoginParam.subAppid, localt.f, 0, t.ad, localasync_context._tmp_pwd, localasync_context._tmp_no_pic_sig, this.mMiscBitmap, this.mSubSigMap, paramQuickLoginParam.dstSubAppidList, paramQuickLoginParam.sigMap, paramQuickLoginParam.subAppid, t.y, 0, 0, 1, t.aa, (WUserSigInfo)localObject1);
      if (paramInt == 204) {
        paramInt = new q(localt).a(this.mMiscBitmap, this.mSubSigMap, paramQuickLoginParam.dstSubAppidList, (WUserSigInfo)localObject1);
      }
      if (paramInt != 0)
      {
        paramQuickLoginParam = new StringBuilder("getStWithQQSig seq:");
        paramQuickLoginParam.append(localt.h);
        paramQuickLoginParam.append(" ret:");
        paramQuickLoginParam.append(paramInt);
        util.LOGI(paramQuickLoginParam.toString(), paramString);
        return paramInt;
      }
      localObject2 = localt.a(localt.f, paramQuickLoginParam.appid);
      if (localObject2 == null) {
        return -1004;
      }
      ((WUserSigInfo)localObject1).get_clone((WloginSigInfo)localObject2);
      if (paramQuickLoginParam.dstSubAppidList != null)
      {
        ((WUserSigInfo)localObject1).stList = new byte[paramQuickLoginParam.dstSubAppidList.length * 2][];
        while (i < paramQuickLoginParam.dstSubAppidList.length)
        {
          localObject2 = localt.a(localt.f, paramQuickLoginParam.dstSubAppidList[i]);
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
      t.an.commit_t2(localt.f, localt.g, util.format_ret_code(paramInt), paramInt);
      if (paramInt == 0)
      {
        if ((paramQuickLoginParam._sig != null) && (paramQuickLoginParam._sig.length != 0)) {
          RequestReport(0, paramQuickLoginParam._sig, paramQuickLoginParam._sig_key, localt.f, localasync_context._appid);
        }
      }
      else
      {
        localObject1 = paramQuickLoginParam;
        i = paramInt;
        if ((i != 2) && (i != 160)) {
          RequestReportError(0, ((Ticket)localObject1)._sig, ((Ticket)localObject1)._sig_key, localt.f, localasync_context._appid, 0);
        }
      }
      if ((localt.d != null) && (localt.d.get_bitmap() != 0))
      {
        this.mG.d = localt.d;
        RequestReportError(0, paramQuickLoginParam._sig, paramQuickLoginParam._sig_key, localt.f, localasync_context._appid, 1);
      }
      t.b();
      localt.h();
      paramQuickLoginParam = new StringBuilder("getStWithQQSig seq:");
      paramQuickLoginParam.append(localt.h);
      paramQuickLoginParam.append(" ret:");
      paramQuickLoginParam.append(paramInt);
      util.LOGI(paramQuickLoginParam.toString(), paramString);
      return paramInt;
    }
    paramQuickLoginParam = new StringBuilder("fast login buff is null seq:");
    paramQuickLoginParam.append(localt.i);
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
      t localt = this.mG.a(0L);
      paramWUserSigInfo._seqence = localt.h;
      this.mAysncSeq = localt.h;
      oicq.wlogin_sdk.a.h.z = "";
      async_context localasync_context = t.b(localt.h);
      Object localObject1 = new StringBuilder("start getStWithQrSig:user:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" appid:");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(" sigMap:0x");
      ((StringBuilder)localObject1).append(Integer.toHexString(i));
      ((StringBuilder)localObject1).append(" subAppid:");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append(" Seq:");
      ((StringBuilder)localObject1).append(localt.h);
      util.LOGI(((StringBuilder)localObject1).toString(), paramString);
      paramInt1 = util.get_saved_network_type(this.mContext);
      t.D = util.get_network_type(this.mContext);
      if (paramInt1 != t.D)
      {
        util.set_net_retry_type(this.mContext, 0);
        util.save_network_type(this.mContext, t.D);
      }
      t.F = util.get_apn_string(this.mContext).getBytes();
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
      localt.g = paramString;
      localt.f = l;
      localasync_context._sappid = paramLong1;
      localasync_context._appid = paramLong1;
      localasync_context._sub_appid_list = null;
      localasync_context._sub_appid = paramLong2;
      localasync_context._main_sigmap = i;
      localasync_context._login_bitmap = paramWUserSigInfo._login_bitmap;
      localasync_context._last_err_msg = new ErrMsg();
      if ((paramWUserSigInfo._reserveData != null) && (paramWUserSigInfo._reserveData.length > 3))
      {
        localt.i = util.buf_to_int32(paramWUserSigInfo._reserveData, 0);
        localObject1 = new StringBuilder("MSF SSO SEQ:");
        ((StringBuilder)localObject1).append(localt.i);
        util.LOGI(((StringBuilder)localObject1).toString(), paramString);
      }
      else
      {
        localt.i = 0;
      }
      t.an.add_t2(new report_t2("login", new String(t.C), System.currentTimeMillis(), paramLong1, paramLong2, null));
      if ((oicq.wlogin_sdk.code2d.c.q != null) && (oicq.wlogin_sdk.code2d.c.q.length > 0))
      {
        localasync_context._tmp_pwd = oicq.wlogin_sdk.code2d.c.q;
        localasync_context._tmp_no_pic_sig = oicq.wlogin_sdk.code2d.c.r;
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
        localasync_context.tgtQR = oicq.wlogin_sdk.code2d.c.s;
        oicq.wlogin_sdk.code2d.c.q = null;
        oicq.wlogin_sdk.code2d.c.r = null;
        oicq.wlogin_sdk.code2d.c.s = null;
      }
      if ((localasync_context._tmp_pwd != null) && (localasync_context._tmp_pwd.length >= 16))
      {
        localasync_context._tmp_pwd_type = 1;
        if ((paramWUserSigInfo._in_ksid != null) && (paramWUserSigInfo._in_ksid.length > 0)) {
          localObject1 = (byte[])paramWUserSigInfo._in_ksid.clone();
        } else {
          localObject1 = t.aa;
        }
        if (localasync_context._tmp_pwd_type != 0)
        {
          Object localObject2 = new StringBuilder("user:");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(" login with qrsig");
          util.LOGI(((StringBuilder)localObject2).toString(), paramString);
          localObject2 = new l(localt, this.mContext);
          ((l)localObject2).g();
          paramInt1 = ((l)localObject2).a(paramLong1, paramLong2, localt.f, 0, t.ad, localasync_context._tmp_pwd, localasync_context._tmp_no_pic_sig, this.mMiscBitmap, this.mSubSigMap, null, i, paramLong2, t.y, 0, 0, 1, (byte[])localObject1, paramWUserSigInfo);
        }
        else
        {
          paramInt1 = 0;
        }
        paramInt2 = paramInt1;
        if (paramInt1 == 204) {
          paramInt2 = new q(localt).a(this.mMiscBitmap, this.mSubSigMap, null, paramWUserSigInfo);
        }
        if ((paramInt2 == 0) || (paramInt2 == 160))
        {
          localObject1 = localt.a(l, paramLong1);
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
      t.an.commit_t2(localt.f, localt.g, util.format_ret_code(paramInt1), paramInt1);
      if (paramInt1 == 0)
      {
        if ((paramWUserSigInfo._sig != null) && (paramWUserSigInfo._sig.length != 0)) {
          RequestReport(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, localt.f, localasync_context._appid);
        }
      }
      else
      {
        localObject1 = paramWUserSigInfo;
        if ((paramInt1 != 2) && (paramInt1 != 160)) {
          RequestReportError(0, ((Ticket)localObject1)._sig, ((Ticket)localObject1)._sig_key, localt.f, localasync_context._appid, 0);
        }
      }
      if ((localt.d != null) && (localt.d.get_bitmap() != 0))
      {
        this.mG.d = localt.d;
        RequestReportError(0, paramWUserSigInfo._sig, paramWUserSigInfo._sig_key, localt.f, localasync_context._appid, 1);
      }
      t.b();
      localt.h();
      paramWUserSigInfo = new StringBuilder("end getStWithQrSig user:");
      paramWUserSigInfo.append(paramString);
      paramWUserSigInfo.append(" appid:");
      paramWUserSigInfo.append(paramLong1);
      paramWUserSigInfo.append(" sigMap:0x");
      paramWUserSigInfo.append(Integer.toHexString(i));
      paramWUserSigInfo.append(" subAppid:");
      paramWUserSigInfo.append(paramLong2);
      paramWUserSigInfo.append(" Seq:");
      paramWUserSigInfo.append(localt.h);
      paramWUserSigInfo.append(" ret=");
      paramWUserSigInfo.append(paramInt1);
      paramString = paramWUserSigInfo.toString();
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append(localt.f);
      util.LOGI(paramString, paramWUserSigInfo.toString());
      return paramInt1;
    }
    return -1017;
  }
  
  private int isPskeyExpired(int paramInt1, String[] paramArrayOfString, Ticket paramTicket, long paramLong, int paramInt2)
  {
    if ((paramInt1 == 1048576) && (paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int k = paramArrayOfString.length;
      int i = 0;
      int j;
      for (paramInt1 = 0;; paramInt1 = j)
      {
        boolean bool5 = true;
        if (i >= k) {
          break;
        }
        Object localObject2 = paramArrayOfString[i];
        j = paramInt1;
        if (localObject2 != null)
        {
          j = paramInt1;
          if (((String)localObject2).length() != 0)
          {
            int m = ((String)localObject2).indexOf('(');
            j = ((String)localObject2).indexOf(')');
            boolean bool1;
            boolean bool2;
            Object localObject1;
            if ((m == 0) && (j > 0))
            {
              m = Integer.valueOf(((String)localObject2).substring(m + 1, j)).intValue();
              if ((m & 0x100000) > 0) {
                bool1 = true;
              } else {
                bool1 = false;
              }
              if ((m & 0x8000000) > 0) {
                bool2 = true;
              } else {
                bool2 = false;
              }
              localObject1 = ((String)localObject2).substring(j + 1);
            }
            else
            {
              localObject1 = localObject2;
              bool2 = false;
              bool1 = true;
            }
            boolean bool3;
            if ((bool1) && ((paramTicket._pskey_map.get(localObject1) == null) || (Ticket.isPskeyExpired(((Long)paramTicket._pskey_expire.get(localObject1)).longValue())))) {
              bool3 = true;
            } else {
              bool3 = false;
            }
            if (bool2)
            {
              bool4 = bool5;
              if (paramTicket._pt4token_map.get(localObject1) == null) {
                break label274;
              }
              if (Ticket.isPskeyExpired(((Long)paramTicket._pt4token_expire.get(localObject1)).longValue()))
              {
                bool4 = bool5;
                break label274;
              }
            }
            boolean bool4 = false;
            label274:
            if ((!bool3) && (!bool4)) {
              break label368;
            }
            j = paramInt1 + 1;
            paramArrayOfString[paramInt1] = localObject2;
            localObject2 = new StringBuilder("isPskeyExpired refresh ");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(" need refresh pskey:");
            ((StringBuilder)localObject2).append(bool3);
            ((StringBuilder)localObject2).append(" and pt4token:");
            ((StringBuilder)localObject2).append(bool4);
            util.LOGI(((StringBuilder)localObject2).toString(), "");
            paramInt1 = j;
            label368:
            localObject2 = new StringBuilder("isPskeyExpired domain ");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(" get pskey:");
            ((StringBuilder)localObject2).append(bool1);
            ((StringBuilder)localObject2).append(" get pt4token:");
            ((StringBuilder)localObject2).append(bool2);
            util.LOGI(((StringBuilder)localObject2).toString(), "");
            j = paramInt1;
          }
        }
        i += 1;
      }
      i = paramInt1;
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
  
  public static void setCustomerGuid(Context paramContext, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("set customer guid ");
    localStringBuilder.append(util.buf_to_string(paramArrayOfByte));
    util.LOGI(localStringBuilder.toString(), "");
    t.ai = paramArrayOfByte;
    util.saveGuidToFile(paramContext, paramArrayOfByte);
  }
  
  public static void setExtraLoginTlvValue(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    tlv_t localtlv_t = new tlv_t(paramInt);
    localtlv_t.set_data(paramArrayOfByte, paramArrayOfByte.length);
    paramWUserSigInfo.extraLoginTLVMap.put(Integer.valueOf(paramInt), localtlv_t);
  }
  
  public static void setExtraRegTlvValue(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    RegTLV localRegTLV = new RegTLV(paramInt);
    localRegTLV.set_data(paramArrayOfByte, paramArrayOfByte.length);
    paramWUserSigInfo.extraRegTLVMap.put(Integer.valueOf(paramInt), localRegTLV);
  }
  
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
    t.as = paramBoolean;
  }
  
  public static void setProductType(int paramInt)
  {
    t.au = paramInt;
  }
  
  public static void setRegisterFlg(int paramInt)
  {
    t.ah = paramInt | t.ah;
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
    this.mG.s = 1;
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
    localObject2 = t.A;
    byte[] arrayOfByte1 = t.E;
    byte[] arrayOfByte2 = "6.0.0.2202".getBytes();
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
    localTransReqContext._body = locala.a(l, paramLong1, paramLong2, ((WloginSigInfo)localObject)._TGT, t.A, t.E, "6.0.0.2202".getBytes(), t.K, t.J);
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
    o.I = false;
    return CheckPictureAndGetSt(paramString, paramArrayOfByte, paramWUserSigInfo, null, 0);
  }
  
  public int CheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1)
  {
    o.I = false;
    return CheckPictureAndGetSt(paramString, paramArrayOfByte, paramWUserSigInfo, paramArrayOfByte1, 0);
  }
  
  public int CheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    return CheckSMSAndGetSt(paramString, paramArrayOfByte, paramWUserSigInfo, null, 0);
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
    o.I = true;
    return CheckPictureAndGetSt(paramString1, paramString2.getBytes(), paramWUserSigInfo, null, 0);
  }
  
  public int CheckWebsigAndGetSt(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte)
  {
    o.I = true;
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
    this.mG.j();
    localObject1 = FindUserSig(l, paramLong);
    if (localObject1 == null) {
      return -1004;
    }
    Object localObject2 = new StringBuilder("user:");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" CloseCode ...");
    util.LOGI(((StringBuilder)localObject2).toString(), paramString);
    localObject2 = new oicq.wlogin_sdk.code2d.a();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(((oicq.wlogin_sdk.code2d.a)localObject2).get_cmd());
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST((WloginSigInfo)localObject1);
    localTransReqContext._body = ((oicq.wlogin_sdk.code2d.a)localObject2).a(l, paramLong, 1L, paramArrayOfByte, ((WloginSigInfo)localObject1)._userStSig, t.A, paramInt, paramList, ((WloginSigInfo)localObject1)._en_A1, ((WloginSigInfo)localObject1)._noPicSig, this.mMiscBitmap, 0L);
    return RequestTransport(0, 1, paramString, paramLong, ((oicq.wlogin_sdk.code2d.a)localObject2)._role, localTransReqContext, paramWUserSigInfo);
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
    localTransReqContext._body = localb.a(l, paramLong1, paramLong2, localWloginSigInfo._TGT, t.A, t.E, "6.0.0.2202".getBytes(), "android".getBytes(), ((String)localObject).getBytes());
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
      if (t.B != null)
      {
        if (t.B.length <= 0) {
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
        return cryptor.encrypt(arrayOfByte, 0, i, t.B);
      }
      return null;
    }
    return null;
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
    return t.b(l)._devlock_info;
  }
  
  public byte[] GetGuid()
  {
    Object localObject2 = t.a(this.mContext);
    if (localObject2 != null) {
      return localObject2;
    }
    Object localObject1 = localObject2;
    if (t.A != null)
    {
      localObject1 = localObject2;
      if (t.A.length > 0)
      {
        localObject1 = new byte[t.A.length];
        System.arraycopy(t.A, 0, localObject1, 0, t.A.length);
      }
    }
    localObject2 = new StringBuilder("get guid ");
    ((StringBuilder)localObject2).append(util.buf_to_string((byte[])localObject1));
    util.LOGI(((StringBuilder)localObject2).toString(), "");
    return localObject1;
  }
  
  public WloginLastLoginInfo GetLastLoginInfo()
  {
    Object localObject = this.mG.k();
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
    return t.b(l)._t105.get_pic();
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
    return t.b(l)._t165.get_data();
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
  
  public Ticket GetPskey(String paramString, long paramLong, String[] paramArrayOfString, WtTicketPromise paramWtTicketPromise)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArray("domains", paramArrayOfString);
    String str = "";
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(paramArrayOfString[i]);
      localStringBuilder.append(",");
      str = localStringBuilder.toString();
      i += 1;
    }
    paramArrayOfString = new StringBuilder("GetPskey appid ");
    paramArrayOfString.append(paramLong);
    paramArrayOfString.append(" domains ");
    paramArrayOfString.append(str);
    util.LOGI(paramArrayOfString.toString(), paramString);
    return GetTicket(paramString, paramLong, 1048576, paramWtTicketPromise, localBundle);
  }
  
  public Ticket GetSkey(String paramString, long paramLong, WtTicketPromise paramWtTicketPromise)
  {
    return GetTicket(paramString, paramLong, 4096, paramWtTicketPromise, null);
  }
  
  public int GetStViaSMSVerifyLogin(String paramString, long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject = new StringBuilder("user:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" GetStViaSMSVerifyLogin ...");
    util.LOGI(((StringBuilder)localObject).toString(), paramString);
    if (oicq.wlogin_sdk.a.h.x) {
      localObject = oicq.wlogin_sdk.a.h.z;
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
    if (oicq.wlogin_sdk.a.h.x) {
      localObject = oicq.wlogin_sdk.a.h.z;
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
      Object localObject = cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, t.B);
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
    Ticket localTicket;
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
        localTicket = GetUserSigInfoTicket((WUserSigInfo)localObject1, paramInt);
        if ((localTicket != null) && (localTicket._sig != null) && (localTicket._sig.length != 0))
        {
          long l = t.f();
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
          localTicket = localObject1[j];
          if ((localTicket != null) && (localTicket.length() > 0)) {
            ((WUserSigInfo)localObject2)._domains.add(localTicket);
          }
          j += 1;
        }
      }
      GetStWithoutPasswd(paramString, paramLong, paramLong, i, paramInt, (WUserSigInfo)localObject2, new WtloginHelper.1(this, paramWtTicketPromise, paramString, paramLong, paramInt, paramBundle));
    }
    paramWtTicketPromise = new StringBuilder("get null for sigType:0x");
    paramWtTicketPromise.append(Integer.toHexString(paramInt));
    util.LOGI(paramWtTicketPromise.toString(), paramString);
    return null;
  }
  
  public long GetTimeDifference()
  {
    return t.ab;
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
            break label255;
          }
          if (!((WloginSigInfo)localObject).iSExpireA2(t.f())) {
            break label246;
          }
          break label255;
        }
        localObject = new StringBuilder("user:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" appid:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" need password:");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(" flag=");
        ((StringBuilder)localObject).append(i);
        util.LOGI(((StringBuilder)localObject).toString(), paramString);
        return Boolean.valueOf(bool1);
      }
      finally {}
      label246:
      int i = 0;
      boolean bool1 = false;
      continue;
      label255:
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
    oicq.wlogin_sdk.code2d.d locald = new oicq.wlogin_sdk.code2d.d();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(locald.get_cmd());
    StringBuilder localStringBuilder = new StringBuilder("qrsig ");
    localStringBuilder.append(util.buf_to_string(oicq.wlogin_sdk.code2d.c.i));
    util.LOGI(localStringBuilder.toString());
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
    return RefreshSMSData(paramString, paramLong, paramWUserSigInfo, 0);
  }
  
  public int RefreshSMSVerifyLoginCode(String paramString, WUserSigInfo paramWUserSigInfo)
  {
    return RefreshSMSVerifyLoginCode(paramString, paramWUserSigInfo, 0);
  }
  
  public int RegGetAccount(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
    {
      util.LOGI("RegGetAccount ...", "");
      oicq.wlogin_sdk.a.b localb = new oicq.wlogin_sdk.a.b();
      TransReqContext localTransReqContext = new TransReqContext();
      oicq.wlogin_sdk.a.h localh = this.mRegStatus;
      if (paramArrayOfByte1 != null) {
        localh.j = ((byte[])paramArrayOfByte1.clone());
      } else {
        localh.j = new byte[0];
      }
      if (paramInt == 4) {
        localh.b = "";
      }
      localTransReqContext.set_register_req();
      localTransReqContext.set_subcmd(localb.a());
      localTransReqContext._body = localb.a(localh.e, paramArrayOfByte1, paramArrayOfByte3, paramArrayOfByte4, paramInt, localh.b.getBytes(), paramArrayOfByte2, false, GetGuid(), 0L, t.E, t.z, paramWUserSigInfo.extraRegTLVMap);
      return RequestTransport(0, 1, null, 0L, localh.i, localTransReqContext, paramWUserSigInfo);
    }
    return -1017;
  }
  
  public int RegGetSMSVerifyLoginAccount(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("RegGetSMSVerifyLoginAccount ...", "");
    oicq.wlogin_sdk.a.b localb = new oicq.wlogin_sdk.a.b();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.h localh = this.mRegStatus;
    if (paramArrayOfByte1 != null) {
      localh.j = ((byte[])paramArrayOfByte1.clone());
    } else {
      localh.j = new byte[0];
    }
    oicq.wlogin_sdk.a.h.x = true;
    oicq.wlogin_sdk.a.h.z = util.get_mpasswd();
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(localb.a());
    localTransReqContext._body = localb.a(localh.e, paramArrayOfByte1, oicq.wlogin_sdk.a.h.z.getBytes(), paramArrayOfByte3, 1, localh.b.getBytes(), paramArrayOfByte2, true, GetGuid(), localh.h, t.E, t.z, paramWUserSigInfo.extraRegTLVMap);
    return RequestTransport(0, 1, null, 0L, localh.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RegQueryAccount(int paramInt, byte[] paramArrayOfByte, long paramLong, WUserSigInfo paramWUserSigInfo)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = new byte[0];
    }
    util.LOGI("RegQueryAccount ...", "");
    this.mRegStatus = new oicq.wlogin_sdk.a.h();
    this.mRegStatus.b = new String(paramArrayOfByte);
    oicq.wlogin_sdk.a.c localc = new oicq.wlogin_sdk.a.c();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.h localh = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(localc.a());
    localTransReqContext._body = localc.a(paramInt, paramArrayOfByte, paramLong);
    return RequestTransport(0, 1, null, 0L, localh.i, localTransReqContext, paramWUserSigInfo);
  }
  
  public int RegQueryClientSentMsgStatus(WUserSigInfo paramWUserSigInfo)
  {
    util.LOGI("RegQueryClientSentMsgStatus ...", "");
    oicq.wlogin_sdk.a.d locald = new oicq.wlogin_sdk.a.d();
    TransReqContext localTransReqContext = new TransReqContext();
    oicq.wlogin_sdk.a.h localh = this.mRegStatus;
    localTransReqContext.set_register_req();
    localTransReqContext.set_subcmd(locald.a());
    localTransReqContext._body = locald.b(localh.e, this.mRegStatus.p);
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
  
  public int RegSubmitMobile(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    if (paramString == null) {
      paramString = new byte[0];
    } else {
      paramString = paramString.getBytes();
    }
    return RegSubmitMobile(paramString, paramArrayOfByte1, null, paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramWUserSigInfo);
  }
  
  public int RegSubmitMobile(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    return RegSubmitMobile(null, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramWUserSigInfo);
  }
  
  public int RegSubmitMsgChk(byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo)
  {
    if (paramArrayOfByte == null) {
      return -1017;
    }
    util.LOGI("RegSubmitMsgChk ...", "");
    g localg = new g();
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
    t localt = this.mG.a(0L);
    Object localObject = new StringBuilder("user:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" encrypt:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" appid:");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(" role:");
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append(" Seq:");
    ((StringBuilder)localObject).append(localt.h);
    ((StringBuilder)localObject).append(" RequestTransport...");
    util.LOGI(((StringBuilder)localObject).toString(), paramString);
    localt.g = paramString;
    if (paramInt2 != 0)
    {
      if (paramString == null)
      {
        localt.m = 0;
        paramInt1 = new z(localt).a(0L, paramTransReqContext, null, null, paramLong1, paramLong2, paramWUserSigInfo);
      }
      else
      {
        localObject = new WloginSimpleInfo();
        if ((paramString != null) && (GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject).booleanValue()))
        {
          WloginSigInfo localWloginSigInfo = localt.a(((WloginSimpleInfo)localObject)._uin, paramLong1);
          if (localWloginSigInfo == null)
          {
            paramInt1 = -1004;
          }
          else
          {
            localt.f = ((WloginSimpleInfo)localObject)._uin;
            paramInt1 = new z(localt).a(((WloginSimpleInfo)localObject)._uin, paramTransReqContext, localWloginSigInfo._userStSig, localWloginSigInfo._userSt_Key, paramLong1, paramLong2, paramWUserSigInfo);
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
      localt.f = 0L;
      paramInt1 = new z(localt).a(localt.f, paramTransReqContext, null, null, paramLong1, paramLong2, paramWUserSigInfo);
    }
    localt.i();
    paramTransReqContext = new StringBuilder("user:");
    paramTransReqContext.append(paramString);
    paramTransReqContext.append(" encrypt:");
    paramTransReqContext.append(paramInt2);
    paramTransReqContext.append(" appid:");
    paramTransReqContext.append(paramLong1);
    paramTransReqContext.append(" role:");
    paramTransReqContext.append(paramLong2);
    paramTransReqContext.append(" Seq:");
    paramTransReqContext.append(localt.h);
    paramTransReqContext.append(" RequestTransport ret=");
    paramTransReqContext.append(paramInt1);
    util.LOGI(paramTransReqContext.toString(), paramString);
    return paramInt1;
  }
  
  public int RequestTransportMsf(int paramInt1, int paramInt2, String paramString, long paramLong1, long paramLong2, TransReqContext paramTransReqContext)
  {
    if (paramInt1 == 0)
    {
      new HelperThread(this, this.mHelperHandler, paramInt2, paramString, paramLong1, paramLong2, paramTransReqContext, "RequestTransportMsf").RunReq(10);
      return -1001;
    }
    t localt = this.mG.a(0L);
    Object localObject1 = new StringBuilder("user:");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" encrypt:");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(" appid:");
    ((StringBuilder)localObject1).append(paramLong1);
    ((StringBuilder)localObject1).append(" role:");
    ((StringBuilder)localObject1).append(paramLong2);
    ((StringBuilder)localObject1).append(" Seq:");
    ((StringBuilder)localObject1).append(localt.h);
    ((StringBuilder)localObject1).append(" RequestTransportMsf...");
    util.LOGI(((StringBuilder)localObject1).toString(), paramString);
    localt.g = paramString;
    paramInt1 = -1004;
    Object localObject2;
    if (paramInt2 != 0)
    {
      localObject1 = new WloginSimpleInfo();
      if ((paramString != null) && (GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1).booleanValue()))
      {
        localObject2 = localt.a(((WloginSimpleInfo)localObject1)._uin, paramLong1);
        if (localObject2 != null)
        {
          localt.f = ((WloginSimpleInfo)localObject1)._uin;
          paramInt1 = new z(localt).a(((WloginSimpleInfo)localObject1)._uin, paramTransReqContext, ((WloginSigInfo)localObject2)._userStSig, ((WloginSigInfo)localObject2)._userSt_Key, ((WloginSigInfo)localObject2)._TGT, paramLong1, paramLong2, new WUserSigInfo());
        }
      }
      else
      {
        paramInt1 = -1003;
      }
    }
    else if ((util.check_uin_account(paramString).booleanValue()) && (Long.parseLong(paramString) == 0L))
    {
      localt.f = 0L;
      localObject1 = new z(localt);
      localObject2 = new WUserSigInfo();
      paramInt1 = ((z)localObject1).a(0L, paramTransReqContext, null, null, new byte[0], paramLong1, paramLong2, (WUserSigInfo)localObject2);
    }
    else
    {
      localObject1 = new WloginSimpleInfo();
      if ((paramString != null) && (GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1).booleanValue()))
      {
        localObject2 = localt.a(((WloginSimpleInfo)localObject1)._uin, paramLong1);
        if (localObject2 != null)
        {
          localt.f = ((WloginSimpleInfo)localObject1)._uin;
          paramInt1 = new z(localt).a(((WloginSimpleInfo)localObject1)._uin, paramTransReqContext, null, null, ((WloginSigInfo)localObject2)._TGT, paramLong1, paramLong2, new WUserSigInfo());
        }
      }
      else
      {
        paramInt1 = -1003;
      }
    }
    localt.i();
    paramTransReqContext = new StringBuilder("user:");
    paramTransReqContext.append(paramString);
    paramTransReqContext.append(" encrypt:");
    paramTransReqContext.append(paramInt2);
    paramTransReqContext.append(" appid:");
    paramTransReqContext.append(paramLong1);
    paramTransReqContext.append(" role:");
    paramTransReqContext.append(paramLong2);
    paramTransReqContext.append(" Seq:");
    paramTransReqContext.append(localt.h);
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
    if (paramIntent.getExtras().getInt("quicklogin_ret") != 0) {
      return null;
    }
    String str = paramIntent.getExtras().getString("quicklogin_uin");
    paramIntent = paramIntent.getExtras().getByteArray("quicklogin_buff");
    if (str != null)
    {
      if (paramIntent == null) {
        return null;
      }
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
    return null;
  }
  
  public void SetAppClientVersion(int paramInt)
  {
    t.w = paramInt;
  }
  
  public void SetCanWebVerify(int paramInt)
  {
    l.I = paramInt;
  }
  
  public void SetDevlockMobileType(int paramInt)
  {
    s.I = paramInt;
  }
  
  public void SetImgType(int paramInt)
  {
    t.x = paramInt;
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
    t.u = paramInt;
  }
  
  public void SetMsfTransportFlag(int paramInt)
  {
    t localt = this.mG;
    localt.k = paramInt;
    if (paramInt != 0)
    {
      t.ad = new byte[4];
      t.ac = 0L;
      localt.l = 45000;
    }
  }
  
  public int SetNeedForPayToken(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      l.J = paramString1.getBytes();
      if (paramArrayOfByte != null) {
        l.L = paramArrayOfByte;
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
      l.K = paramString1.getBytes();
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        return 0;
      }
      return -2;
    }
    return -1;
  }
  
  public void SetPicType(int paramInt)
  {
    t.y = paramInt;
  }
  
  public void SetRegDevLockFlag(int paramInt)
  {
    t.z = paramInt;
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
      ((tlv_t400)localObject1).get_tlv_400(localWloginSigInfo._G, l, t.A, localWloginSigInfo._dpwd, paramLong, 1L, localWloginSigInfo._randseed);
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
    localObject2 = new oicq.wlogin_sdk.code2d.e();
    TransReqContext localTransReqContext = new TransReqContext();
    localTransReqContext.set_code2d_func_req();
    localTransReqContext.set_subcmd(((oicq.wlogin_sdk.code2d.e)localObject2).get_cmd());
    localTransReqContext.setSTEncryptMethod();
    localTransReqContext.setWtST(localWloginSigInfo);
    localTransReqContext._body = ((oicq.wlogin_sdk.code2d.e)localObject2).a(l, paramLong, paramBoolean, paramArrayOfByte, paramArrayOfInt, localWloginSigInfo._userStSig, t.A, t.E, paramInt, (byte[])localObject1);
    return RequestTransport(0, 1, paramString, paramLong, ((oicq.wlogin_sdk.code2d.e)localObject2)._role, localTransReqContext, paramWUserSigInfo);
  }
  
  public int VerifySMSVerifyLoginCode(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo)
  {
    return VerifySMSVerifyLoginCode(paramString1, paramString2, paramWUserSigInfo, 0);
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
    util.LOGI("onQuickLoginActivityResultData isRetFromWeb ".concat(String.valueOf(bool)));
    if (!bool)
    {
      paramIntent = ResolveQloginIntentReserved(paramIntent);
      if (paramIntent == null)
      {
        util.LOGI("onActivityResultData ResolveQloginIntent failed", "");
        return -1017;
      }
      paramQuickLoginParam.userSigInfo.uin = paramIntent.uin;
      paramQuickLoginParam.userSigInfo._fastLoginBuf = paramIntent._fastLoginBuf;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramIntent.uin);
      return getStWithQQSig(localStringBuilder.toString(), paramQuickLoginParam);
    }
    paramQuickLoginParam.userAccount = getUserInputFromQuickLoginResultData(paramIntent);
    return getStWithPtSig(paramIntent.getStringExtra("uin"), paramIntent.getStringExtra("sig"), paramQuickLoginParam);
  }
  
  public int quickLogin(Activity paramActivity, long paramLong1, long paramLong2, String paramString, QuickLoginParam paramQuickLoginParam)
  {
    try
    {
      localMethod = Class.forName("oicq.wlogin_sdk.quicklogin.QuickLogin").getMethod("jumpToLoginActivity", new Class[] { Context.class, Activity.class, Long.TYPE, Long.TYPE, String.class, QuickLoginParam.class });
    }
    catch (Exception paramActivity)
    {
      Method localMethod;
      int i;
      label111:
      break label111;
    }
    try
    {
      i = ((Integer)localMethod.invoke(null, new Object[] { this.mContext, paramActivity, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, paramQuickLoginParam })).intValue();
      return i;
    }
    catch (Exception paramActivity) {}
    return 0;
    return 0;
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
    t.ag = paramBoolean;
  }
  
  public void setCallSource(int paramInt)
  {
    t.af = paramInt;
  }
  
  public void setForQCall()
  {
    t.ar = true;
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
    String ptSig;
    WtloginHelper.QuickLoginParam quickLoginParam;
    
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
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, long paramLong1, int paramInt, long paramLong2, WUserSigInfo paramWUserSigInfo, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.mDwAppid = paramLong1;
      this.mDwMainSigMap = paramInt;
      this.mDwSubDstAppid = paramLong2;
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
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, String paramString2, WtloginHelper.QuickLoginParam paramQuickLoginParam, String paramString3)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.ptSig = paramString2;
      this.quickLoginParam = paramQuickLoginParam;
      this.mUserSigInfo = paramQuickLoginParam.userSigInfo;
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
    
    HelperThread(WtloginHelper paramWtloginHelper, Handler paramHandler, String paramString1, WtloginHelper.QuickLoginParam paramQuickLoginParam, String paramString2)
    {
      this.mHelper = paramWtloginHelper;
      this.mHandler = paramHandler;
      this.mUserAccount = paramString1;
      this.quickLoginParam = paramQuickLoginParam;
      this.mUserSigInfo = paramQuickLoginParam.userSigInfo;
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
      //   1: getfield 78	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   4: invokestatic 245	oicq/wlogin_sdk/request/WtloginHelper:access$100	(Loicq/wlogin_sdk/request/WtloginHelper;)Loicq/wlogin_sdk/request/WtloginListener;
      //   7: ifnonnull +11 -> 18
      //   10: aload_0
      //   11: getfield 155	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mPromise	Loicq/wlogin_sdk/request/WtTicketPromise;
      //   14: ifnonnull +4 -> 18
      //   17: return
      //   18: aload_0
      //   19: getfield 78	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   22: invokestatic 249	oicq/wlogin_sdk/request/WtloginHelper:access$200	(Loicq/wlogin_sdk/request/WtloginHelper;)Loicq/wlogin_sdk/request/t;
      //   25: getfield 254	oicq/wlogin_sdk/request/t:s	I
      //   28: istore_1
      //   29: aload_0
      //   30: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   33: ifnonnull +9 -> 42
      //   36: iconst_1
      //   37: istore 4
      //   39: goto +6 -> 45
      //   42: iconst_0
      //   43: istore 4
      //   45: aload_0
      //   46: iload 4
      //   48: putfield 72	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:isSelfLooper	Z
      //   51: aload_0
      //   52: getfield 72	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:isSelfLooper	Z
      //   55: ifeq +17 -> 72
      //   58: invokestatic 257	android/os/Looper:prepare	()V
      //   61: aload_0
      //   62: aload_0
      //   63: getfield 67	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:this$0	Loicq/wlogin_sdk/request/WtloginHelper;
      //   66: invokestatic 261	oicq/wlogin_sdk/request/WtloginHelper:access$300	(Loicq/wlogin_sdk/request/WtloginHelper;)Landroid/os/Handler;
      //   69: putfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   72: aload_0
      //   73: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   76: ifnull +1126 -> 1202
      //   79: aload_0
      //   80: getfield 201	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   83: ifne +73 -> 156
      //   86: aload_0
      //   87: getfield 78	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   90: aload_0
      //   91: getfield 86	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   94: aload_0
      //   95: getfield 88	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
      //   98: aload_0
      //   99: getfield 105	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwMainSigMap	I
      //   102: aload_0
      //   103: getfield 107	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwSubDstAppid	J
      //   106: aload_0
      //   107: getfield 110	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwSubAppidList	[J
      //   110: aload_0
      //   111: getfield 112	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mPwdMd5	Z
      //   114: aload_0
      //   115: getfield 114	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserPasswd	Ljava/lang/String;
      //   118: aload_0
      //   119: getfield 74	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   122: aload_0
      //   123: getfield 116	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST	[[B
      //   126: aload_0
      //   127: getfield 76	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mIsSmslogin	Z
      //   130: iconst_1
      //   131: invokestatic 265	oicq/wlogin_sdk/request/WtloginHelper:access$400	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;JIJ[JZLjava/lang/String;Loicq/wlogin_sdk/request/WUserSigInfo;[[BZI)I
      //   134: istore_2
      //   135: aload_0
      //   136: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   139: new 267	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$2
      //   142: dup
      //   143: aload_0
      //   144: iload_1
      //   145: iload_2
      //   146: invokespecial 270	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$2:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   149: invokevirtual 276	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   152: pop
      //   153: goto +965 -> 1118
      //   156: aload_0
      //   157: getfield 201	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   160: iconst_1
      //   161: if_icmpne +41 -> 202
      //   164: aload_0
      //   165: getfield 78	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   168: aload_0
      //   169: getfield 86	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   172: aload_0
      //   173: getfield 74	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   176: iconst_1
      //   177: invokestatic 280	oicq/wlogin_sdk/request/WtloginHelper:access$600	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;Loicq/wlogin_sdk/request/WUserSigInfo;I)I
      //   180: istore_2
      //   181: aload_0
      //   182: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   185: new 282	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$3
      //   188: dup
      //   189: aload_0
      //   190: iload_1
      //   191: iload_2
      //   192: invokespecial 283	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$3:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   195: invokevirtual 276	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   198: pop
      //   199: goto +919 -> 1118
      //   202: aload_0
      //   203: getfield 201	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   206: iconst_2
      //   207: if_icmpne +49 -> 256
      //   210: aload_0
      //   211: getfield 78	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   214: aload_0
      //   215: getfield 86	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   218: aload_0
      //   219: getfield 152	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserInput	[B
      //   222: aload_0
      //   223: getfield 74	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   226: aload_0
      //   227: getfield 116	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST	[[B
      //   230: iconst_1
      //   231: invokestatic 287	oicq/wlogin_sdk/request/WtloginHelper:access$700	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;[BLoicq/wlogin_sdk/request/WUserSigInfo;[[BI)I
      //   234: istore_2
      //   235: aload_0
      //   236: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   239: new 289	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$4
      //   242: dup
      //   243: aload_0
      //   244: iload_1
      //   245: iload_2
      //   246: invokespecial 290	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$4:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   249: invokevirtual 276	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   252: pop
      //   253: goto +865 -> 1118
      //   256: aload_0
      //   257: getfield 201	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   260: iconst_3
      //   261: if_icmpne +45 -> 306
      //   264: aload_0
      //   265: getfield 78	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   268: aload_0
      //   269: getfield 86	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   272: aload_0
      //   273: getfield 134	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSmsAppid	J
      //   276: aload_0
      //   277: getfield 74	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   280: iconst_1
      //   281: invokestatic 294	oicq/wlogin_sdk/request/WtloginHelper:access$800	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;JLoicq/wlogin_sdk/request/WUserSigInfo;I)I
      //   284: istore_2
      //   285: aload_0
      //   286: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   289: new 296	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$5
      //   292: dup
      //   293: aload_0
      //   294: iload_1
      //   295: iload_2
      //   296: invokespecial 297	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$5:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   299: invokevirtual 276	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   302: pop
      //   303: goto +815 -> 1118
      //   306: aload_0
      //   307: getfield 201	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   310: iconst_4
      //   311: if_icmpne +49 -> 360
      //   314: aload_0
      //   315: getfield 78	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   318: aload_0
      //   319: getfield 86	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   322: aload_0
      //   323: getfield 152	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserInput	[B
      //   326: aload_0
      //   327: getfield 74	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   330: aload_0
      //   331: getfield 116	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST	[[B
      //   334: iconst_1
      //   335: invokestatic 300	oicq/wlogin_sdk/request/WtloginHelper:access$900	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;[BLoicq/wlogin_sdk/request/WUserSigInfo;[[BI)I
      //   338: istore_2
      //   339: aload_0
      //   340: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   343: new 302	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$6
      //   346: dup
      //   347: aload_0
      //   348: iload_1
      //   349: iload_2
      //   350: invokespecial 303	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$6:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   353: invokevirtual 276	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   356: pop
      //   357: goto +761 -> 1118
      //   360: aload_0
      //   361: getfield 201	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   364: iconst_5
      //   365: if_icmpne +119 -> 484
      //   368: aload_0
      //   369: getfield 78	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   372: astore 15
      //   374: aload_0
      //   375: getfield 86	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   378: astore 16
      //   380: aload_0
      //   381: getfield 88	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
      //   384: lstore 5
      //   386: aload_0
      //   387: getfield 157	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwDstAppid	J
      //   390: lstore 7
      //   392: aload_0
      //   393: getfield 159	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwDstAppPri	J
      //   396: lstore 9
      //   398: aload_0
      //   399: getfield 105	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwMainSigMap	I
      //   402: istore_2
      //   403: aload_0
      //   404: getfield 107	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwSubDstAppid	J
      //   407: lstore 11
      //   409: aload_0
      //   410: getfield 161	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwDstSubAppidList	[J
      //   413: astore 17
      //   415: aload_0
      //   416: getfield 74	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   419: astore 18
      //   421: aload_0
      //   422: getfield 116	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST	[[B
      //   425: astore 19
      //   427: aload 15
      //   429: aload 16
      //   431: lload 5
      //   433: lload 7
      //   435: lload 9
      //   437: iload_2
      //   438: lload 11
      //   440: aload 17
      //   442: aload 18
      //   444: aload 19
      //   446: aload_0
      //   447: getfield 163	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReserve	[[B
      //   450: iconst_1
      //   451: aload_0
      //   452: getfield 155	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mPromise	Loicq/wlogin_sdk/request/WtTicketPromise;
      //   455: invokestatic 307	oicq/wlogin_sdk/request/WtloginHelper:access$1000	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;JJJIJ[JLoicq/wlogin_sdk/request/WUserSigInfo;[[B[[BILoicq/wlogin_sdk/request/WtTicketPromise;)I
      //   458: istore_2
      //   459: aload_0
      //   460: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   463: astore 15
      //   465: aload 15
      //   467: new 309	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$7
      //   470: dup
      //   471: aload_0
      //   472: iload_1
      //   473: iload_2
      //   474: invokespecial 310	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$7:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   477: invokevirtual 276	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   480: pop
      //   481: goto +637 -> 1118
      //   484: iload_1
      //   485: istore_2
      //   486: aload_0
      //   487: getfield 201	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   490: bipush 6
      //   492: if_icmpne +119 -> 611
      //   495: aload_0
      //   496: getfield 78	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   499: astore 15
      //   501: aload_0
      //   502: getfield 86	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   505: astore 16
      //   507: aload_0
      //   508: getfield 100	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppid1	J
      //   511: lstore 5
      //   513: aload_0
      //   514: getfield 102	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSubAppid1	J
      //   517: lstore 7
      //   519: aload_0
      //   520: getfield 105	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwMainSigMap	I
      //   523: istore_3
      //   524: aload_0
      //   525: getfield 119	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppName2	[B
      //   528: astore 17
      //   530: aload_0
      //   531: getfield 121	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSsoVer2	J
      //   534: lstore 9
      //   536: aload_0
      //   537: getfield 123	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppid2	J
      //   540: lstore 11
      //   542: aload_0
      //   543: getfield 125	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSubAppid2	J
      //   546: lstore 13
      //   548: aload 15
      //   550: aload 16
      //   552: lload 5
      //   554: lload 7
      //   556: iload_3
      //   557: aload 17
      //   559: lload 9
      //   561: lload 11
      //   563: lload 13
      //   565: aload_0
      //   566: getfield 127	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppVer2	[B
      //   569: aload_0
      //   570: getfield 129	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppSign2	[B
      //   573: aload_0
      //   574: getfield 74	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   577: aload_0
      //   578: getfield 131	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mFastLoginInfo	Loicq/wlogin_sdk/request/WFastLoginInfo;
      //   581: iconst_1
      //   582: invokestatic 314	oicq/wlogin_sdk/request/WtloginHelper:access$1200	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;JJI[BJJJ[B[BLoicq/wlogin_sdk/request/WUserSigInfo;Loicq/wlogin_sdk/request/WFastLoginInfo;I)I
      //   585: istore_3
      //   586: aload_0
      //   587: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   590: astore 15
      //   592: aload 15
      //   594: new 316	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$8
      //   597: dup
      //   598: aload_0
      //   599: iload_2
      //   600: iload_3
      //   601: invokespecial 317	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$8:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   604: invokevirtual 276	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   607: pop
      //   608: goto +510 -> 1118
      //   611: aload_0
      //   612: getfield 201	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   615: bipush 7
      //   617: if_icmpne +31 -> 648
      //   620: aload_0
      //   621: getfield 78	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   624: iconst_1
      //   625: aload_0
      //   626: getfield 166	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST1	[B
      //   629: aload_0
      //   630: getfield 168	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST1Key	[B
      //   633: aload_0
      //   634: getfield 170	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUIN	J
      //   637: aload_0
      //   638: getfield 88	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
      //   641: invokestatic 321	oicq/wlogin_sdk/request/WtloginHelper:access$1300	(Loicq/wlogin_sdk/request/WtloginHelper;I[B[BJJ)I
      //   644: pop
      //   645: goto +473 -> 1118
      //   648: aload_0
      //   649: getfield 201	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   652: bipush 9
      //   654: if_icmpne +57 -> 711
      //   657: aload_0
      //   658: getfield 78	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   661: iconst_1
      //   662: aload_0
      //   663: getfield 84	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mEncrypt	I
      //   666: aload_0
      //   667: getfield 86	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   670: aload_0
      //   671: getfield 88	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
      //   674: aload_0
      //   675: getfield 90	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mRole	J
      //   678: aload_0
      //   679: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqContext	Loicq/wlogin_sdk/request/TransReqContext;
      //   682: aload_0
      //   683: getfield 74	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   686: invokevirtual 325	oicq/wlogin_sdk/request/WtloginHelper:RequestTransport	(IILjava/lang/String;JJLoicq/wlogin_sdk/request/TransReqContext;Loicq/wlogin_sdk/request/WUserSigInfo;)I
      //   689: istore_3
      //   690: aload_0
      //   691: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   694: new 327	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$9
      //   697: dup
      //   698: aload_0
      //   699: iload_2
      //   700: iload_3
      //   701: invokespecial 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$9:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   704: invokevirtual 276	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   707: pop
      //   708: goto +410 -> 1118
      //   711: aload_0
      //   712: getfield 201	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   715: bipush 10
      //   717: if_icmpne +53 -> 770
      //   720: aload_0
      //   721: getfield 78	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   724: iconst_1
      //   725: aload_0
      //   726: getfield 84	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mEncrypt	I
      //   729: aload_0
      //   730: getfield 86	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   733: aload_0
      //   734: getfield 88	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
      //   737: aload_0
      //   738: getfield 90	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mRole	J
      //   741: aload_0
      //   742: getfield 92	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqContext	Loicq/wlogin_sdk/request/TransReqContext;
      //   745: invokevirtual 332	oicq/wlogin_sdk/request/WtloginHelper:RequestTransportMsf	(IILjava/lang/String;JJLoicq/wlogin_sdk/request/TransReqContext;)I
      //   748: istore_3
      //   749: aload_0
      //   750: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   753: new 334	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$10
      //   756: dup
      //   757: aload_0
      //   758: iload_2
      //   759: iload_3
      //   760: invokespecial 335	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$10:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   763: invokevirtual 276	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   766: pop
      //   767: goto +351 -> 1118
      //   770: aload_0
      //   771: getfield 201	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   774: bipush 12
      //   776: if_icmpne +49 -> 825
      //   779: aload_0
      //   780: getfield 78	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   783: aload_0
      //   784: getfield 100	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppid1	J
      //   787: aload_0
      //   788: getfield 102	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSubAppid1	J
      //   791: aload_0
      //   792: getfield 86	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   795: aload_0
      //   796: getfield 74	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   799: iconst_1
      //   800: invokestatic 339	oicq/wlogin_sdk/request/WtloginHelper:access$1700	(Loicq/wlogin_sdk/request/WtloginHelper;JJLjava/lang/String;Loicq/wlogin_sdk/request/WUserSigInfo;I)I
      //   803: istore_3
      //   804: aload_0
      //   805: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   808: new 341	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$11
      //   811: dup
      //   812: aload_0
      //   813: iload_2
      //   814: iload_3
      //   815: invokespecial 342	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$11:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   818: invokevirtual 276	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   821: pop
      //   822: goto +296 -> 1118
      //   825: aload_0
      //   826: getfield 201	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   829: bipush 13
      //   831: if_icmpne +45 -> 876
      //   834: aload_0
      //   835: getfield 78	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   838: aload_0
      //   839: getfield 86	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   842: aload_0
      //   843: getfield 137	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mMsgCode	Ljava/lang/String;
      //   846: aload_0
      //   847: getfield 74	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   850: iconst_1
      //   851: invokestatic 346	oicq/wlogin_sdk/request/WtloginHelper:access$1800	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;Ljava/lang/String;Loicq/wlogin_sdk/request/WUserSigInfo;I)I
      //   854: istore_3
      //   855: aload_0
      //   856: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   859: new 348	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$12
      //   862: dup
      //   863: aload_0
      //   864: iload_2
      //   865: iload_3
      //   866: invokespecial 349	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$12:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   869: invokevirtual 276	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   872: pop
      //   873: goto +245 -> 1118
      //   876: aload_0
      //   877: getfield 201	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   880: bipush 14
      //   882: if_icmpne +41 -> 923
      //   885: aload_0
      //   886: getfield 78	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   889: aload_0
      //   890: getfield 86	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   893: aload_0
      //   894: getfield 74	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   897: iconst_1
      //   898: invokestatic 352	oicq/wlogin_sdk/request/WtloginHelper:access$1900	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;Loicq/wlogin_sdk/request/WUserSigInfo;I)I
      //   901: istore_3
      //   902: aload_0
      //   903: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   906: new 354	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$13
      //   909: dup
      //   910: aload_0
      //   911: iload_2
      //   912: iload_3
      //   913: invokespecial 355	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$13:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   916: invokevirtual 276	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   919: pop
      //   920: goto +198 -> 1118
      //   923: aload_0
      //   924: getfield 201	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   927: bipush 8
      //   929: if_icmpne +35 -> 964
      //   932: aload_0
      //   933: getfield 78	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   936: iconst_1
      //   937: aload_0
      //   938: getfield 166	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST1	[B
      //   941: aload_0
      //   942: getfield 168	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST1Key	[B
      //   945: aload_0
      //   946: getfield 170	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUIN	J
      //   949: aload_0
      //   950: getfield 88	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
      //   953: aload_0
      //   954: getfield 172	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReportErrType	I
      //   957: invokestatic 359	oicq/wlogin_sdk/request/WtloginHelper:access$2000	(Loicq/wlogin_sdk/request/WtloginHelper;I[B[BJJI)I
      //   960: pop
      //   961: goto +157 -> 1118
      //   964: aload_0
      //   965: getfield 201	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   968: bipush 15
      //   970: if_icmpne +41 -> 1011
      //   973: aload_0
      //   974: getfield 78	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   977: aload_0
      //   978: getfield 86	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   981: aload_0
      //   982: getfield 142	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:quickLoginParam	Loicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;
      //   985: iconst_1
      //   986: invokestatic 363	oicq/wlogin_sdk/request/WtloginHelper:access$2100	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;Loicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;I)I
      //   989: istore_3
      //   990: aload_0
      //   991: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   994: new 365	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$14
      //   997: dup
      //   998: aload_0
      //   999: iload_2
      //   1000: iload_3
      //   1001: invokespecial 366	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$14:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   1004: invokevirtual 276	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   1007: pop
      //   1008: goto +110 -> 1118
      //   1011: aload_0
      //   1012: getfield 201	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   1015: bipush 16
      //   1017: if_icmpne +45 -> 1062
      //   1020: aload_0
      //   1021: getfield 78	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   1024: aload_0
      //   1025: getfield 86	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   1028: aload_0
      //   1029: getfield 140	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:ptSig	Ljava/lang/String;
      //   1032: aload_0
      //   1033: getfield 142	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:quickLoginParam	Loicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;
      //   1036: iconst_1
      //   1037: invokestatic 370	oicq/wlogin_sdk/request/WtloginHelper:access$2200	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;Ljava/lang/String;Loicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;I)I
      //   1040: istore_3
      //   1041: aload_0
      //   1042: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   1045: new 372	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$15
      //   1048: dup
      //   1049: aload_0
      //   1050: iload_2
      //   1051: iload_3
      //   1052: invokespecial 373	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$15:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   1055: invokevirtual 276	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   1058: pop
      //   1059: goto +59 -> 1118
      //   1062: aload_0
      //   1063: getfield 201	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   1066: bipush 17
      //   1068: if_icmpne +50 -> 1118
      //   1071: aload_0
      //   1072: getfield 78	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
      //   1075: aload_0
      //   1076: getfield 86	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
      //   1079: aload_0
      //   1080: getfield 88	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
      //   1083: aload_0
      //   1084: getfield 107	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwSubDstAppid	J
      //   1087: aload_0
      //   1088: getfield 105	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwMainSigMap	I
      //   1091: aload_0
      //   1092: getfield 74	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
      //   1095: iconst_1
      //   1096: invokestatic 377	oicq/wlogin_sdk/request/WtloginHelper:access$2300	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;JJILoicq/wlogin_sdk/request/WUserSigInfo;I)I
      //   1099: istore_3
      //   1100: aload_0
      //   1101: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   1104: new 379	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$16
      //   1107: dup
      //   1108: aload_0
      //   1109: iload_2
      //   1110: iload_3
      //   1111: invokespecial 380	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$16:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
      //   1114: invokevirtual 276	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   1117: pop
      //   1118: aload_0
      //   1119: getfield 72	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:isSelfLooper	Z
      //   1122: ifeq +6 -> 1128
      //   1125: invokestatic 383	android/os/Looper:loop	()V
      //   1128: aload_0
      //   1129: getfield 201	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   1132: bipush 7
      //   1134: if_icmpeq +199 -> 1333
      //   1137: getstatic 208	oicq/wlogin_sdk/request/WtloginHelper:__sync_top	Ljava/lang/Object;
      //   1140: astore 15
      //   1142: aload 15
      //   1144: monitorenter
      //   1145: getstatic 218	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1148: ifle +11 -> 1159
      //   1151: getstatic 218	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1154: iconst_1
      //   1155: isub
      //   1156: putstatic 218	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1159: new 224	java/lang/StringBuilder
      //   1162: dup
      //   1163: ldc_w 385
      //   1166: invokespecial 228	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1169: astore 16
      //   1171: aload 16
      //   1173: getstatic 218	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1176: invokevirtual 232	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1179: pop
      //   1180: aload 16
      //   1182: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1185: ldc 191
      //   1187: invokestatic 240	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
      //   1190: aload 15
      //   1192: monitorexit
      //   1193: return
      //   1194: astore 16
      //   1196: aload 15
      //   1198: monitorexit
      //   1199: aload 16
      //   1201: athrow
      //   1202: new 180	java/lang/Exception
      //   1205: dup
      //   1206: ldc_w 387
      //   1209: invokespecial 388	java/lang/Exception:<init>	(Ljava/lang/String;)V
      //   1212: athrow
      //   1213: astore 15
      //   1215: goto +10 -> 1225
      //   1218: astore 16
      //   1220: goto +114 -> 1334
      //   1223: astore 15
      //   1225: aload 15
      //   1227: ldc 191
      //   1229: invokestatic 197	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
      //   1232: aload_0
      //   1233: getfield 80	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
      //   1236: new 390	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$17
      //   1239: dup
      //   1240: aload_0
      //   1241: iload_1
      //   1242: invokespecial 393	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$17:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;I)V
      //   1245: invokevirtual 276	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   1248: pop
      //   1249: aload_0
      //   1250: getfield 72	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:isSelfLooper	Z
      //   1253: ifeq +6 -> 1259
      //   1256: invokestatic 383	android/os/Looper:loop	()V
      //   1259: aload_0
      //   1260: getfield 201	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   1263: bipush 7
      //   1265: if_icmpeq +68 -> 1333
      //   1268: getstatic 208	oicq/wlogin_sdk/request/WtloginHelper:__sync_top	Ljava/lang/Object;
      //   1271: astore 15
      //   1273: aload 15
      //   1275: monitorenter
      //   1276: getstatic 218	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1279: ifle +11 -> 1290
      //   1282: getstatic 218	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1285: iconst_1
      //   1286: isub
      //   1287: putstatic 218	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1290: new 224	java/lang/StringBuilder
      //   1293: dup
      //   1294: ldc_w 385
      //   1297: invokespecial 228	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1300: astore 16
      //   1302: aload 16
      //   1304: getstatic 218	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1307: invokevirtual 232	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1310: pop
      //   1311: aload 16
      //   1313: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1316: ldc 191
      //   1318: invokestatic 240	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
      //   1321: aload 15
      //   1323: monitorexit
      //   1324: return
      //   1325: astore 16
      //   1327: aload 15
      //   1329: monitorexit
      //   1330: aload 16
      //   1332: athrow
      //   1333: return
      //   1334: aload_0
      //   1335: getfield 72	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:isSelfLooper	Z
      //   1338: ifeq +6 -> 1344
      //   1341: invokestatic 383	android/os/Looper:loop	()V
      //   1344: aload_0
      //   1345: getfield 201	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
      //   1348: bipush 7
      //   1350: if_icmpeq +70 -> 1420
      //   1353: getstatic 208	oicq/wlogin_sdk/request/WtloginHelper:__sync_top	Ljava/lang/Object;
      //   1356: astore 15
      //   1358: aload 15
      //   1360: monitorenter
      //   1361: getstatic 218	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1364: ifle +11 -> 1375
      //   1367: getstatic 218	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1370: iconst_1
      //   1371: isub
      //   1372: putstatic 218	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1375: new 224	java/lang/StringBuilder
      //   1378: dup
      //   1379: ldc_w 385
      //   1382: invokespecial 228	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1385: astore 17
      //   1387: aload 17
      //   1389: getstatic 218	oicq/wlogin_sdk/request/WtloginHelper:__top	I
      //   1392: invokevirtual 232	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1395: pop
      //   1396: aload 17
      //   1398: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1401: ldc 191
      //   1403: invokestatic 240	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
      //   1406: aload 15
      //   1408: monitorexit
      //   1409: goto +11 -> 1420
      //   1412: astore 16
      //   1414: aload 15
      //   1416: monitorexit
      //   1417: aload 16
      //   1419: athrow
      //   1420: aload 16
      //   1422: athrow
      //   1423: astore 15
      //   1425: goto -200 -> 1225
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1428	0	this	HelperThread
      //   28	1214	1	i	int
      //   134	976	2	j	int
      //   523	588	3	k	int
      //   37	10	4	bool	boolean
      //   384	169	5	l1	long
      //   390	165	7	l2	long
      //   396	164	9	l3	long
      //   407	155	11	l4	long
      //   546	18	13	l5	long
      //   1213	1	15	localException1	Exception
      //   1223	3	15	localException2	Exception
      //   1423	1	15	localException3	Exception
      //   378	803	16	localObject3	Object
      //   1194	6	16	localObject4	Object
      //   1218	1	16	localObject5	Object
      //   1300	12	16	localStringBuilder	StringBuilder
      //   1325	6	16	localObject6	Object
      //   1412	9	16	localObject7	Object
      //   413	984	17	localObject8	Object
      //   419	24	18	localWUserSigInfo	WUserSigInfo
      //   425	20	19	arrayOfByte	byte[][]
      // Exception table:
      //   from	to	target	type
      //   1145	1159	1194	finally
      //   1159	1193	1194	finally
      //   1196	1199	1194	finally
      //   465	481	1213	java/lang/Exception
      //   486	548	1213	java/lang/Exception
      //   592	608	1213	java/lang/Exception
      //   611	645	1213	java/lang/Exception
      //   648	708	1213	java/lang/Exception
      //   711	767	1213	java/lang/Exception
      //   770	822	1213	java/lang/Exception
      //   825	873	1213	java/lang/Exception
      //   876	920	1213	java/lang/Exception
      //   923	961	1213	java/lang/Exception
      //   964	1008	1213	java/lang/Exception
      //   1011	1059	1213	java/lang/Exception
      //   1062	1118	1213	java/lang/Exception
      //   1202	1213	1213	java/lang/Exception
      //   72	153	1218	finally
      //   156	199	1218	finally
      //   202	253	1218	finally
      //   256	303	1218	finally
      //   306	357	1218	finally
      //   360	427	1218	finally
      //   427	465	1218	finally
      //   465	481	1218	finally
      //   486	548	1218	finally
      //   548	592	1218	finally
      //   592	608	1218	finally
      //   611	645	1218	finally
      //   648	708	1218	finally
      //   711	767	1218	finally
      //   770	822	1218	finally
      //   825	873	1218	finally
      //   876	920	1218	finally
      //   923	961	1218	finally
      //   964	1008	1218	finally
      //   1011	1059	1218	finally
      //   1062	1118	1218	finally
      //   1202	1213	1218	finally
      //   1225	1249	1218	finally
      //   72	153	1223	java/lang/Exception
      //   156	199	1223	java/lang/Exception
      //   202	253	1223	java/lang/Exception
      //   256	303	1223	java/lang/Exception
      //   306	357	1223	java/lang/Exception
      //   360	427	1223	java/lang/Exception
      //   1276	1290	1325	finally
      //   1290	1324	1325	finally
      //   1327	1330	1325	finally
      //   1361	1375	1412	finally
      //   1375	1409	1412	finally
      //   1414	1417	1412	finally
      //   427	465	1423	java/lang/Exception
      //   548	592	1423	java/lang/Exception
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