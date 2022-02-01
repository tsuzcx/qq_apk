package com.tencent.mobileqq.portal;

import alab;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import aqgv;
import aqgz;
import aqiw;
import aqnv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.PageReqInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.PageRespInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReportConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfigByPage;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqReportConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfigByPage;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Screen;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.InflaterInputStream;
import jnl;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.os.MqqHandler;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.cs.cmd0x6ff.subcmd0x501.ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.RspBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody;
import tencent.im.new_year_2014.PackData.Pack;
import tencent.im.new_year_2014.PackServer.GetNewPackReq;
import tencent.im.new_year_2014.PackServer.GetNewPackResp;
import tencent.im.new_year_2014.PackServer.PkgReq;
import tencent.im.new_year_2014.PackServer.PkgResp;
import tencent.im.new_year_2014.Unisso.UniSsoServerReq;
import tencent.im.new_year_2014.Unisso.UniSsoServerRsp;
import tencent.im.new_year_ranking.PackRanking.PkgReq;
import tencent.im.new_year_ranking.PackRanking.PkgResp;
import tencent.im.new_year_ranking.PackRanking.QueryRankingReq;
import tencent.im.new_year_ranking.PackRanking.QueryRankingResp;
import tencent.im.new_year_ranking.PackRanking.RankingElem;
import tencent.im.new_year_ranking.PackRanking.RankingInfo;
import tencent.im.new_year_report.PackReport.PkgReq;
import tencent.im.new_year_report.PackReport.Report;
import tencent.im.new_year_report.PackReport.ReportElem;
import tencent.im.new_year_report.PackShareReport.PkgHead;
import tencent.im.new_year_report.PackShareReport.PkgReq;
import tencent.im.new_year_report.PackShareReport.ReportShareReq;

public class RedPacketServlet
  extends jnl
{
  private static int doS;
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.Servlet", 2, "requestResult, reqType " + paramInt3 + ", reqNumber " + paramInt2);
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), RedPacketServlet.class);
    localNewIntent.putExtra("k_cmd", 8);
    localNewIntent.putExtra("k_uin", paramAppRuntime.getAccount());
    localNewIntent.putExtra("k_type", paramInt1);
    localNewIntent.putExtra("k_count", paramInt2);
    localNewIntent.putExtra("key_seq", paramInt4);
    localNewIntent.putExtra("k_r_type", paramInt3);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  private static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.Servlet", 2, "getConfig, " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramArrayOfByte1 + ", " + paramArrayOfByte2);
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), RedPacketServlet.class);
    localNewIntent.putExtra("k_cmd", 2);
    localNewIntent.putExtra("k_offset", paramInt2);
    localNewIntent.putExtra("k_id", paramInt3);
    localNewIntent.putExtra("k_version", paramInt1);
    localNewIntent.putExtra("k_cookie", paramArrayOfByte1);
    localNewIntent.putExtra("k_buff", paramArrayOfByte2);
    if (paramInt2 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localNewIntent.putExtra("k_new_page", bool);
      paramAppRuntime.startServlet(localNewIntent);
      return;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt, ArrayList<BrashReportItem> paramArrayList, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.Servlet", 2, "reportBrashCount, " + paramBundle);
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), RedPacketServlet.class);
    localNewIntent.putExtra("k_cmd", 7);
    localNewIntent.putExtra("k_id", paramInt);
    localNewIntent.putExtra("k_uin", paramAppRuntime.getAccount());
    localNewIntent.putExtra("k_b_ing", paramBoolean);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("k_b_list", paramArrayList);
    localBundle.putAll(paramBundle);
    localNewIntent.putExtras(localBundle);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  private void e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramInt6 < 2) || (!aqiw.isNetworkAvailable(BaseApplicationImpl.sApplication))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.Servlet", 2, "reportConfig, " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramInt4 + ", " + paramInt5);
    }
    NewIntent localNewIntent = new NewIntent(getAppRuntime().getApplication(), RedPacketServlet.class);
    localNewIntent.putExtra("k_cmd", 4);
    localNewIntent.putExtra("k_type", paramInt1);
    localNewIntent.putExtra("k_version", paramInt2);
    localNewIntent.putExtra("k_id", paramInt3);
    localNewIntent.putExtra("k_opt", paramInt4);
    localNewIntent.putExtra("k_code", paramInt5);
    getAppRuntime().startServlet(localNewIntent);
  }
  
  public static void h(AppRuntime paramAppRuntime, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.Servlet", 2, "requestResult, " + paramInt);
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), RedPacketServlet.class);
    localNewIntent.putExtra("k_cmd", 1);
    localNewIntent.putExtra("k_id", paramInt);
    localNewIntent.putExtra("k_uin", paramAppRuntime.getAccount());
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  private byte[] inflate(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return null;
    }
    return paramArrayOfByte;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int n = paramIntent.getIntExtra("k_cmd", -1);
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.Servlet", 2, "onReceive, cmd = " + n);
    }
    int i1 = paramIntent.getIntExtra("k_retry", 0);
    boolean bool2 = paramFromServiceMsg.isSuccess();
    boolean bool1;
    if (bool2)
    {
      Object localObject1 = aqnv.J(paramFromServiceMsg.getWupBuffer());
      switch (n)
      {
      case 3: 
      case 5: 
      case 6: 
      default: 
        paramFromServiceMsg = null;
        bool1 = bool2;
      case 1: 
      case 2: 
        for (;;)
        {
          if ((!bool1) && (i1 < 2))
          {
            paramIntent.putExtra("k_retry", i1 + 1);
            if (n == 7)
            {
              ThreadManager.getSubThreadHandler().postDelayed(new RedPacketServlet.1(this, paramIntent), 60000L);
              label182:
              return;
            }
          }
          try
          {
            paramFromServiceMsg = new Bundle();
            try
            {
              i = paramIntent.getIntExtra("k_id", -1);
              localObject3 = new Unisso.UniSsoServerRsp();
              ((Unisso.UniSsoServerRsp)localObject3).mergeFrom((byte[])localObject1);
              l1 = ((Unisso.UniSsoServerRsp)localObject3).ret.get();
              if (QLog.isColorLevel()) {
                QLog.d("PortalManager.Servlet", 2, "onReceive, result = " + l1);
              }
              if (l1 != 0L) {
                break label645;
              }
              localObject1 = new PackServer.PkgResp();
              ((PackServer.PkgResp)localObject1).mergeFrom(((Unisso.UniSsoServerRsp)localObject3).rspdata.get().toByteArray());
              j = ((PackServer.PkgResp)localObject1).errcode.get();
              paramFromServiceMsg.putInt("k_code", j);
              paramFromServiceMsg.putInt("k_id", i);
              if ((((PackServer.PkgResp)localObject1).grab_interval.has()) || (((PackServer.PkgResp)localObject1).report_active_interval.has()) || (((PackServer.PkgResp)localObject1).report_normal_interval.has()))
              {
                localObject3 = (PortalManager)((QQAppInterface)getAppRuntime()).getManager(79);
                if (localObject3 != null)
                {
                  if (!((PackServer.PkgResp)localObject1).grab_interval.has()) {
                    break label2606;
                  }
                  l1 = ((PackServer.PkgResp)localObject1).grab_interval.get();
                  label394:
                  if (!((PackServer.PkgResp)localObject1).report_active_interval.has()) {
                    break label2614;
                  }
                  l2 = ((PackServer.PkgResp)localObject1).report_active_interval.get();
                  label416:
                  if (!((PackServer.PkgResp)localObject1).report_normal_interval.has()) {
                    break label2622;
                  }
                  l3 = ((PackServer.PkgResp)localObject1).report_normal_interval.get();
                  label438:
                  ((PortalManager)localObject3).v(l1, l2, l3);
                }
              }
              if (j != 0) {
                break label2599;
              }
              localObject1 = (PackServer.GetNewPackResp)((PackServer.PkgResp)localObject1).get_new_pack.get();
              localObject3 = (PackData.Pack)((PackServer.GetNewPackResp)localObject1).data.get();
              paramFromServiceMsg.putInt("k_busi", ((PackData.Pack)localObject3).business.get());
              paramFromServiceMsg.putInt("k_type", ((PackData.Pack)localObject3).type.get());
              paramFromServiceMsg.putBoolean("k_s_follow", ((PackServer.GetNewPackResp)localObject1).follow.get());
              paramFromServiceMsg.putInt("key_award_id", ((PackData.Pack)localObject3).business.get());
              paramFromServiceMsg.putInt("key_promotion_id", ((PackData.Pack)localObject3).promotion_id.get());
              switch (((PackData.Pack)localObject3).type.get())
              {
              case 1: 
                paramFromServiceMsg.putInt("k_money", ((PackData.Pack)localObject3).money.get());
              }
            }
            catch (Throwable localThrowable1) {}
          }
          catch (Throwable localThrowable3)
          {
            for (;;)
            {
              int i;
              Object localObject3;
              long l1;
              int j;
              long l2;
              long l3;
              label604:
              Object localObject4;
              Object localObject5;
              paramFromServiceMsg = null;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("PortalManager.Servlet", 2, "", localThrowable1);
          }
          bool1 = false;
          continue;
          paramFromServiceMsg.putString("k_url", ((PackData.Pack)localObject3).url.get());
          break label2599;
          label645:
          bool1 = true;
          paramFromServiceMsg.putInt("k_type", -1);
          break label2603;
          localObject4 = (PortalManager)((QQAppInterface)getAppRuntime()).getManager(79);
          localObject5 = new ConfigurationService.RespGetConfigByPage();
          ((ConfigurationService.RespGetConfigByPage)localObject5).mergeFrom(localThrowable1);
          i = ((ConfigurationService.RespGetConfigByPage)localObject5).result.get();
          paramFromServiceMsg = new Bundle();
          if (i != 0) {
            bool1 = false;
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        int k;
        int m;
        Object localObject6;
        Object localObject2;
        Object localObject7;
        Object localObject8;
        label2582:
        label2592:
        label2599:
        label2603:
        label2606:
        label2614:
        label2622:
        try
        {
          ((PortalManager)localObject4).clearData();
          paramFromServiceMsg.putInt("k_code", 3);
          e(1004, 0, 0, 1, i, i1);
          continue;
          if (((ConfigurationService.RespGetConfigByPage)localObject5).type.get() != 1004)
          {
            e(1004, 0, 0, 1, 3, i1);
            bool1 = false;
          }
          else
          {
            i = paramIntent.getIntExtra("k_version", -1);
            j = ((ConfigurationService.PageRespInfo)((ConfigurationService.RespGetConfigByPage)localObject5).page_info.get()).version.get();
            k = ((ConfigurationService.PageRespInfo)((ConfigurationService.RespGetConfigByPage)localObject5).page_info.get()).task_id.get();
            m = paramIntent.getIntExtra("k_offset", 0);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("PortalManager.Servlet", 1, "onReceive, " + m + ", " + i + ", " + j);
            continue;
            ((PortalManager)localObject4).clearData();
            paramFromServiceMsg.putInt("k_code", 3);
            localObject6 = (ConfigurationService.PageRespInfo)((ConfigurationService.RespGetConfigByPage)localObject5).page_info.get();
            localObject2 = paramIntent.getByteArrayExtra("k_buff");
            localObject3 = ((ConfigurationService.RespGetConfigByPage)localObject5).content.get().toByteArray();
            if (localObject2 == null) {
              break label2663;
            }
            i = localObject2.length;
            localObject7 = new ByteArrayBuffer(i + localObject3.length);
            if (localObject2 != null) {
              ((ByteArrayBuffer)localObject7).append((byte[])localObject2, 0, localObject2.length);
            }
            ((ByteArrayBuffer)localObject7).append((byte[])localObject3, 0, localObject3.length);
            localObject3 = ((ByteArrayBuffer)localObject7).buffer();
            i = ((ConfigurationService.PageRespInfo)localObject6).next_offset.get();
            if (i == -1)
            {
              localObject2 = ((ConfigurationService.PageRespInfo)localObject6).md5.get();
              localObject7 = alab.w((byte[])localObject3);
              i = ((ConfigurationService.PageRespInfo)localObject6).total_size.get();
              if (QLog.isColorLevel()) {
                QLog.d("PortalManager.Servlet", 1, "onReceive, " + i + ", " + (String)localObject2 + ", " + (String)localObject7);
              }
              bool1 = bool2;
              if (i != 0) {
                if (TextUtils.equals((CharSequence)localObject7, (CharSequence)localObject2))
                {
                  localObject2 = localObject3;
                  if (((ConfigurationService.PageRespInfo)localObject6).compress.get() == 1) {
                    localObject2 = inflate((byte[])localObject3);
                  }
                  if (localObject2 == null)
                  {
                    e(1004, j, ((ConfigurationService.PageRespInfo)((ConfigurationService.RespGetConfigByPage)localObject5).page_info.get()).task_id.get(), 1, 4, 2);
                    bool1 = bool2;
                  }
                  else
                  {
                    localObject3 = null;
                    if (((ConfigurationService.RespGetConfigByPage)localObject5).delay_time.has()) {
                      localObject3 = (ArrayList)((ConfigurationService.RespGetConfigByPage)localObject5).delay_time.get();
                    }
                    localObject2 = PortalManager.a(new String((byte[])localObject2, "utf-8"), j, k, (ArrayList)localObject3);
                    if (localObject2 == null)
                    {
                      e(1004, j, ((ConfigurationService.PageRespInfo)((ConfigurationService.RespGetConfigByPage)localObject5).page_info.get()).task_id.get(), 1, 5, i1);
                      bool1 = false;
                    }
                    else
                    {
                      e(1004, j, ((ConfigurationService.PageRespInfo)((ConfigurationService.RespGetConfigByPage)localObject5).page_info.get()).task_id.get(), 1, 0, 2);
                      localObject2 = ((PortalManager)localObject4).a((PortalManager.RedPacketConfig)localObject2);
                      paramFromServiceMsg.putInt("k_code", 4);
                      paramFromServiceMsg.putSerializable("k_cache", (Serializable)localObject2);
                      bool1 = bool2;
                    }
                  }
                }
                else
                {
                  bool1 = false;
                  e(1004, j, ((ConfigurationService.PageRespInfo)((ConfigurationService.RespGetConfigByPage)localObject5).page_info.get()).task_id.get(), 1, 6, i1);
                }
              }
            }
            else
            {
              if (i == 0) {
                break label2668;
              }
              a(getAppRuntime(), j, ((ConfigurationService.PageRespInfo)localObject6).next_offset.get(), ((ConfigurationService.PageRespInfo)localObject6).task_id.get(), ((ConfigurationService.PageRespInfo)localObject6).cookies.get().toByteArray(), (byte[])localObject3);
              return;
              ((PortalManager)localObject4).a(null);
              paramFromServiceMsg.putInt("k_code", 2);
              bool1 = bool2;
              continue;
              bool1 = true;
              paramFromServiceMsg = new Bundle();
              break;
              paramFromServiceMsg = new Bundle();
              bool1 = bool2;
              break;
              paramFromServiceMsg = new Bundle();
              bool1 = bool2;
              break;
              paramFromServiceMsg = new Bundle();
            }
          }
        }
        catch (Throwable localThrowable2) {}
        label2663:
        label2668:
        try
        {
          for (;;)
          {
            localObject3 = new Unisso.UniSsoServerRsp();
            ((Unisso.UniSsoServerRsp)localObject3).mergeFrom((byte[])localObject2);
            localObject5 = new PackRanking.PkgResp();
            ((PackRanking.PkgResp)localObject5).mergeFrom(((Unisso.UniSsoServerRsp)localObject3).rspdata.get().toByteArray());
            i = ((PackRanking.PkgResp)localObject5).retcode.get();
            paramFromServiceMsg.putInt("k_code", i);
            paramFromServiceMsg.putInt("key_seq", paramIntent.getIntExtra("key_seq", -1));
            paramFromServiceMsg.putInt("k_r_type", paramIntent.getIntExtra("k_r_type", -1));
            if (i != 0) {
              break label2592;
            }
            localObject4 = (QQAppInterface)getAppRuntime();
            localObject3 = null;
            localObject2 = null;
            localObject5 = (PackRanking.QueryRankingResp)((PackRanking.PkgResp)localObject5).query_ranking.get();
            if (((PackRanking.QueryRankingResp)localObject5).rank_swipe.has()) {
              localObject3 = (PackRanking.RankingInfo)((PackRanking.QueryRankingResp)localObject5).rank_swipe.get();
            }
            if (((PackRanking.QueryRankingResp)localObject5).rank_combo.has()) {
              localObject2 = (PackRanking.RankingInfo)((PackRanking.QueryRankingResp)localObject5).rank_combo.get();
            }
            localObject5 = new JSONObject();
            ((JSONObject)localObject5).put("errorCode", i);
            localObject6 = getAppRuntime().getAccount();
            if (localObject3 != null)
            {
              localObject7 = new JSONObject();
              ((JSONObject)localObject7).put("key", alab.w((String)localObject6, ((PackRanking.RankingInfo)localObject3).uin.get()));
              ((JSONObject)localObject7).put("ranking", ((PackRanking.RankingInfo)localObject3).ranking.get());
              ((JSONObject)localObject7).put("count", ((PackRanking.RankingInfo)localObject3).count.get());
              ((JSONObject)localObject7).put("nick", ((QQAppInterface)localObject4).getCurrentNickname());
              ((JSONObject)localObject5).put("totalHead", localObject7);
              if (((PackRanking.RankingInfo)localObject3).elems.has())
              {
                localObject7 = ((PackRanking.RankingInfo)localObject3).elems.get();
                if (((List)localObject7).size() > 0)
                {
                  localObject3 = new JSONArray();
                  localObject7 = ((List)localObject7).iterator();
                  i = 0;
                  while (((Iterator)localObject7).hasNext())
                  {
                    localObject8 = (PackRanking.RankingElem)((Iterator)localObject7).next();
                    i += 1;
                    JSONObject localJSONObject = new JSONObject();
                    localJSONObject.put("key", alab.w((String)localObject6, ((PackRanking.RankingElem)localObject8).uin.get()));
                    localJSONObject.put("ranking", i);
                    localJSONObject.put("count", ((PackRanking.RankingElem)localObject8).count.get());
                    localJSONObject.put("nick", aqgv.A((QQAppInterface)localObject4, String.valueOf(((PackRanking.RankingElem)localObject8).uin.get())));
                    ((JSONArray)localObject3).put(localJSONObject);
                  }
                  ((JSONObject)localObject5).put("totalList", localObject3);
                }
              }
            }
            if (localObject2 != null)
            {
              localObject3 = new JSONObject();
              ((JSONObject)localObject3).put("key", alab.w((String)localObject6, ((PackRanking.RankingInfo)localObject2).uin.get()));
              ((JSONObject)localObject3).put("ranking", ((PackRanking.RankingInfo)localObject2).ranking.get());
              ((JSONObject)localObject3).put("count", ((PackRanking.RankingInfo)localObject2).count.get());
              ((JSONObject)localObject3).put("nick", ((QQAppInterface)localObject4).getCurrentNickname());
              ((JSONObject)localObject5).put("comboHead", localObject3);
              if (((PackRanking.RankingInfo)localObject2).elems.has())
              {
                localObject3 = ((PackRanking.RankingInfo)localObject2).elems.get();
                if (((List)localObject3).size() > 0)
                {
                  localObject2 = new JSONArray();
                  localObject3 = ((List)localObject3).iterator();
                  i = 0;
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject7 = (PackRanking.RankingElem)((Iterator)localObject3).next();
                    i += 1;
                    localObject8 = new JSONObject();
                    ((JSONObject)localObject8).put("key", alab.w((String)localObject6, ((PackRanking.RankingElem)localObject7).uin.get()));
                    ((JSONObject)localObject8).put("ranking", i);
                    ((JSONObject)localObject8).put("count", ((PackRanking.RankingElem)localObject7).count.get());
                    ((JSONObject)localObject8).put("nick", aqgv.A((QQAppInterface)localObject4, String.valueOf(((PackRanking.RankingElem)localObject7).uin.get())));
                    ((JSONArray)localObject2).put(localObject8);
                  }
                  ((JSONObject)localObject5).put("comboList", localObject2);
                }
              }
            }
            paramFromServiceMsg.putString("k_result", ((JSONObject)localObject5).toString());
            bool1 = bool2;
            break;
            localObject2 = new Bundle();
            try
            {
              int i2 = paramIntent.getIntExtra("k_id", -1);
              j = -1;
              m = 0;
              i = j;
              try
              {
                localObject3 = new subcmd0x501.RspBody();
                i = j;
                paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
                i = j;
                localObject4 = new byte[paramFromServiceMsg.getInt() - 4];
                i = j;
                paramFromServiceMsg.get((byte[])localObject4);
                i = j;
                ((subcmd0x501.RspBody)localObject3).mergeFrom((byte[])localObject4);
                i = j;
                paramFromServiceMsg = (subcmd0x501.SubCmd0x501Rspbody)((subcmd0x501.RspBody)localObject3).msg_subcmd_0x501_rsp_body.get();
                i = j;
                j = paramFromServiceMsg.uint32_share_type.get();
                i = j;
                k = paramFromServiceMsg.uint32_share_channel.get();
              }
              catch (Exception paramFromServiceMsg)
              {
                for (;;)
                {
                  j = i;
                  k = m;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("PortalManager.Servlet", 2, paramFromServiceMsg.getMessage());
                    j = i;
                    k = m;
                  }
                }
              }
              paramFromServiceMsg = (PortalManager)((QQAppInterface)getAppRuntime()).getManager(79);
              if (paramFromServiceMsg != null) {
                paramFromServiceMsg.je(i2, j);
              }
              ((Bundle)localObject2).putInt("share_type", j);
              ((Bundle)localObject2).putInt("share_channel", k);
              if (!QLog.isColorLevel()) {
                break label2582;
              }
              QLog.i("PortalManager.Servlet", 2, "onReceive, shareType=" + j + ", shareChannel=" + k);
              paramFromServiceMsg = (FromServiceMsg)localObject2;
              bool1 = bool2;
            }
            catch (Throwable localThrowable5)
            {
              paramFromServiceMsg = (FromServiceMsg)localObject2;
              localObject2 = localThrowable5;
            }
          }
          break label604;
          if (n == 2) {
            e(1004, 0, 0, 1, 1, i1);
          }
          paramFromServiceMsg = null;
          bool1 = bool2;
          break;
          getAppRuntime().startServlet((NewIntent)paramIntent);
          return;
          localObject2 = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            localObject2 = new Bundle();
          }
          notifyObserver(paramIntent, n, bool1, (Bundle)localObject2, PortalManager.class);
          if (n != 10) {
            break label182;
          }
          return;
          paramFromServiceMsg = (FromServiceMsg)localObject2;
          bool1 = bool2;
          break;
          bool1 = bool2;
        }
        catch (Throwable localThrowable4) {}
      }
      bool1 = bool2;
      break;
      l1 = -1L;
      break label394;
      l2 = -1L;
      break label416;
      l3 = -1L;
      break label438;
      break;
      if ((m != 0) || (i == j)) {
        if ((m != 0) && (i == j))
        {
          continue;
          break label604;
          i = 0;
          continue;
          bool1 = false;
        }
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("k_cmd", -1);
    int j = paramIntent.getIntExtra("k_retry", 0);
    boolean bool = paramIntent.getBooleanExtra("k_new_page", false);
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1;
    Object localObject2;
    if ((j == 0) || (bool))
    {
      localObject1 = localObject4;
      localObject2 = localObject3;
      switch (i)
      {
      default: 
        localObject2 = localObject3;
        localObject1 = localObject4;
      case 3: 
      case 5: 
      case 6: 
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (localObject2 != null)
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (!bool)
          {
            paramIntent.putExtra("k_sso_id", (String)localObject2);
            paramIntent.putExtra("k_sso_data", (byte[])localObject1);
            localObject4 = localObject2;
            localObject3 = localObject1;
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager.Servlet", 2, "onSend, " + i + ", " + j + ", " + bool + ", " + (String)localObject4 + ", " + localObject3);
      }
      if ((localObject4 != null) && (localObject3 != null))
      {
        paramPacket.setSSOCommand((String)localObject4);
        paramPacket.putSendData((byte[])localObject3);
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localObject1 = new Unisso.UniSsoServerReq();
              localObject2 = new PackServer.PkgReq();
              ((PackServer.PkgReq)localObject2).cmdtype.set(1);
              ((PackServer.PkgReq)localObject2).net_type.set(aqiw.getSystemNetwork(BaseApplicationImpl.sApplication));
              localObject3 = paramIntent.getStringExtra("k_uin");
              k = doS + 1;
              doS = k;
              int m = paramIntent.getIntExtra("k_id", -1);
              ((PackServer.PkgReq)localObject2).uin.set(Long.parseLong((String)localObject3));
              ((PackServer.PkgReq)localObject2).from_id.set(1);
              localObject4 = new PackServer.GetNewPackReq();
              ((PackServer.GetNewPackReq)localObject4).promotion_id.set(m);
              ((PackServer.GetNewPackReq)localObject4).seq.set(k);
              ((PackServer.GetNewPackReq)localObject4).signature.set(ByteStringMicro.copyFrom(((String)localObject3 + m + k).getBytes()));
              ((PackServer.PkgReq)localObject2).get_new_pack.set((MessageMicro)localObject4);
              ((Unisso.UniSsoServerReq)localObject1).reqdata.set(ByteStringMicro.copyFrom(((PackServer.PkgReq)localObject2).toByteArray()));
              localObject1 = aqnv.I(((Unisso.UniSsoServerReq)localObject1).toByteArray());
              localObject2 = "NY2015.get_new_pack";
              paramIntent.putExtra("k_retry", 2);
              break;
              k = paramIntent.getIntExtra("k_id", 0);
              m = paramIntent.getIntExtra("k_offset", 0);
              int n = paramIntent.getIntExtra("k_version", 0);
              localObject2 = paramIntent.getByteArrayExtra("k_cookie");
              localObject1 = new ConfigurationService.ReqGetConfigByPage();
              localObject3 = new ConfigurationService.PageReqInfo();
              ((ConfigurationService.PageReqInfo)localObject3).task_id.set(k);
              ((ConfigurationService.PageReqInfo)localObject3).offset.set(m);
              ((ConfigurationService.PageReqInfo)localObject3).version.set(n);
              if (localObject2 != null) {
                ((ConfigurationService.PageReqInfo)localObject3).cookies.set(ByteStringMicro.copyFrom((byte[])localObject2));
              }
              ((ConfigurationService.ReqGetConfigByPage)localObject1).page_info.set((MessageMicro)localObject3);
              localObject2 = new ConfigurationService.DeviceInfo();
              localObject3 = new ConfigurationService.Screen();
              ((ConfigurationService.Screen)localObject3).setHasFlag(true);
              ((ConfigurationService.Screen)localObject3).model.set("");
              ((ConfigurationService.Screen)localObject3).width.set((int)aqgz.hI());
              ((ConfigurationService.Screen)localObject3).height.set((int)aqgz.hJ());
              ((ConfigurationService.Screen)localObject3).dpi.set(aqgz.getDispalyDpi());
              ((ConfigurationService.Screen)localObject3).multi_touch.set(aqgz.aCE());
              ((ConfigurationService.DeviceInfo)localObject2).setHasFlag(true);
              ((ConfigurationService.DeviceInfo)localObject2).screen = ((ConfigurationService.Screen)localObject3);
              ((ConfigurationService.ReqGetConfigByPage)localObject1).device_info.set((MessageMicro)localObject2);
              ((ConfigurationService.ReqGetConfigByPage)localObject1).type.set(1004);
              localObject1 = aqnv.I(((ConfigurationService.ReqGetConfigByPage)localObject1).toByteArray());
              localObject2 = "ConfigurationService.ReqGetConfigByPage";
              break;
              localObject1 = new ConfigurationService.ReqReportConfig();
              localObject2 = new ConfigurationService.ReportConfig();
              ((ConfigurationService.ReportConfig)localObject2).type.set(paramIntent.getIntExtra("k_type", -1));
              ((ConfigurationService.ReportConfig)localObject2).task_id.set(paramIntent.getIntExtra("k_id", -1));
              ((ConfigurationService.ReportConfig)localObject2).version.set(paramIntent.getIntExtra("k_version", -1));
              ((ConfigurationService.ReportConfig)localObject2).report_type.set(paramIntent.getIntExtra("k_opt", -1));
              ((ConfigurationService.ReportConfig)localObject2).result.set(paramIntent.getIntExtra("k_code", -1));
              ((ConfigurationService.ReqReportConfig)localObject1).config_list.add((MessageMicro)localObject2);
              localObject2 = "ConfigurationService.ReqReportConfig";
              localObject1 = aqnv.I(((ConfigurationService.ReqReportConfig)localObject1).toByteArray());
              paramIntent.putExtra("k_retry", 2);
              break;
              localObject1 = new Unisso.UniSsoServerReq();
              localObject2 = new PackReport.PkgReq();
              ((PackReport.PkgReq)localObject2).promotion_id.set(paramIntent.getIntExtra("k_id", -1));
              ((PackReport.PkgReq)localObject2).uin.set(Long.valueOf(paramIntent.getStringExtra("k_uin")).longValue());
              l2 = paramIntent.getLongExtra("key_seq", -1L);
              l1 = l2;
              if (l2 == -1L)
              {
                l1 = NetConnInfoCenter.getServerTimeMillis();
                paramIntent.putExtra("key_seq", l1);
              }
              ((PackReport.PkgReq)localObject2).seq.set(l1);
              localObject3 = paramIntent.getExtras();
            } while (localObject3 == null);
            localObject6 = (ArrayList)((Bundle)localObject3).getSerializable("k_b_list");
          } while (localObject6 == null);
          localObject4 = new ArrayList();
          localObject5 = new PackReport.Report();
          Object localObject6 = ((ArrayList)localObject6).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            BrashReportItem localBrashReportItem = (BrashReportItem)((Iterator)localObject6).next();
            PackReport.ReportElem localReportElem = new PackReport.ReportElem();
            localReportElem.count.set(localBrashReportItem.count);
            localReportElem.timestamp.set(localBrashReportItem.time);
            ((PackReport.Report)localObject5).elems.add(localReportElem);
          }
          localObject6 = ((PackReport.Report)localObject5).id;
          if (paramIntent.getBooleanExtra("k_b_ing", false)) {}
          for (l1 = 200L;; l1 = 100L)
          {
            ((PBUInt64Field)localObject6).set(l1);
            ((ArrayList)localObject4).add(localObject5);
            if (((Bundle)localObject3).containsKey("k_e_ctr"))
            {
              localObject5 = new PackReport.Report();
              ((PackReport.Report)localObject5).id.set(300L);
              localObject6 = new PackReport.ReportElem();
              ((PackReport.ReportElem)localObject6).count.set(((Bundle)localObject3).getInt("k_e_ctr"));
              ((PackReport.ReportElem)localObject6).timestamp.set(((Bundle)localObject3).getLong("k_s_time"));
              ((PackReport.Report)localObject5).elems.add((MessageMicro)localObject6);
              ((ArrayList)localObject4).add(localObject5);
              if (QLog.isColorLevel()) {
                QLog.d("PortalManager.Servlet", 2, "onSend, report EMPTY_COUNTER , elem.count = " + ((PackReport.ReportElem)localObject6).count.get());
              }
            }
            if (((Bundle)localObject3).containsKey("k_h_ctr"))
            {
              localObject5 = new PackReport.Report();
              ((PackReport.Report)localObject5).id.set(400L);
              localObject6 = new PackReport.ReportElem();
              ((PackReport.ReportElem)localObject6).count.set(((Bundle)localObject3).getInt("k_h_ctr"));
              ((PackReport.ReportElem)localObject6).timestamp.set(((Bundle)localObject3).getLong("k_s_time"));
              ((PackReport.Report)localObject5).elems.add((MessageMicro)localObject6);
              ((ArrayList)localObject4).add(localObject5);
              if (QLog.isColorLevel()) {
                QLog.d("PortalManager.Servlet", 2, "onSend, report HIT_COUNTER , elem.count = " + ((PackReport.ReportElem)localObject6).count.get());
              }
            }
            if (((Bundle)localObject3).containsKey("k_c_ctr"))
            {
              localObject5 = new PackReport.Report();
              ((PackReport.Report)localObject5).id.set(500L);
              localObject6 = new PackReport.ReportElem();
              ((PackReport.ReportElem)localObject6).count.set(((Bundle)localObject3).getInt("k_c_ctr"));
              ((PackReport.ReportElem)localObject6).timestamp.set(((Bundle)localObject3).getLong("k_s_time"));
              ((PackReport.Report)localObject5).elems.add((MessageMicro)localObject6);
              ((ArrayList)localObject4).add(localObject5);
              if (QLog.isColorLevel()) {
                QLog.d("PortalManager.Servlet", 2, "onSend, report reportContinuous , elem.count = " + ((PackReport.ReportElem)localObject6).count.get());
              }
            }
            ((PackReport.PkgReq)localObject2).report.set((List)localObject4);
            ((Unisso.UniSsoServerReq)localObject1).reqdata.set(ByteStringMicro.copyFrom(((PackReport.PkgReq)localObject2).toByteArray()));
            localObject1 = aqnv.I(((Unisso.UniSsoServerReq)localObject1).toByteArray());
            localObject2 = "NewYearReport.pack_report";
            paramIntent.putExtra("k_retry", 2);
            break;
          }
          localObject1 = new Unisso.UniSsoServerReq();
          localObject2 = new PackRanking.PkgReq();
          ((PackRanking.PkgReq)localObject2).uin.set(Long.valueOf(paramIntent.getStringExtra("k_uin")).longValue());
          ((PackRanking.PkgReq)localObject2).cmdtype.set(1);
          localObject3 = new PackRanking.QueryRankingReq();
          int k = paramIntent.getIntExtra("k_type", 3);
          ((PackRanking.QueryRankingReq)localObject3).flag.set(k);
          k = paramIntent.getIntExtra("k_count", 200);
          ((PackRanking.QueryRankingReq)localObject3).num.set(k);
          ((PackRanking.PkgReq)localObject2).query_ranking.set((MessageMicro)localObject3);
          ((Unisso.UniSsoServerReq)localObject1).reqdata.set(ByteStringMicro.copyFrom(((PackRanking.PkgReq)localObject2).toByteArray()));
          localObject1 = aqnv.I(((Unisso.UniSsoServerReq)localObject1).toByteArray());
          localObject2 = "NewYearReport.pack_ranking";
          paramIntent.putExtra("k_retry", 2);
          break;
          localObject1 = paramIntent.getExtras();
        } while (localObject1 == null);
        localObject2 = new Unisso.UniSsoServerReq();
        localObject3 = new PackShareReport.PkgReq();
        localObject4 = new PackShareReport.PkgHead();
        ((PackShareReport.PkgHead)localObject4).cmdtype.set(1);
        ((PackShareReport.PkgHead)localObject4).uin.set(Long.valueOf(paramIntent.getStringExtra("k_uin")).longValue());
        long l2 = paramIntent.getLongExtra("key_seq", -1L);
        long l1 = l2;
        if (l2 == -1L)
        {
          l1 = NetConnInfoCenter.getServerTimeMillis();
          paramIntent.putExtra("key_seq", l1);
        }
        ((PackShareReport.PkgHead)localObject4).seq.set(l1);
        Object localObject5 = new PackShareReport.ReportShareReq();
        ((PackShareReport.ReportShareReq)localObject5).promotion_id.set(((Bundle)localObject1).getInt("k_id", -1));
        ((PackShareReport.ReportShareReq)localObject5).share_channel.set(((Bundle)localObject1).getInt("k_s_channel", -1));
        ((PackShareReport.ReportShareReq)localObject5).share_type.set(((Bundle)localObject1).getInt("k_s_type", -1));
        ((PackShareReport.ReportShareReq)localObject5).swipe_count.set(((Bundle)localObject1).getInt("key_totalcnt", -1));
        ((PackShareReport.ReportShareReq)localObject5).combo_count.set(((Bundle)localObject1).getInt("key_combocnt", -1));
        ((PackShareReport.ReportShareReq)localObject5).win_money_count.set(((Bundle)localObject1).getInt("k_money", -1));
        ((PackShareReport.ReportShareReq)localObject5).win_goods_count.set(((Bundle)localObject1).getInt("key_goodscnt", -1));
        ((PackShareReport.ReportShareReq)localObject5).share_error.set(((Bundle)localObject1).getInt("key_errorCode", -1));
        ((PackShareReport.PkgReq)localObject3).report_share.set((MessageMicro)localObject5);
        ((PackShareReport.PkgReq)localObject3).head.set((MessageMicro)localObject4);
        ((Unisso.UniSsoServerReq)localObject2).reqdata.set(ByteStringMicro.copyFrom(((PackShareReport.PkgReq)localObject3).toByteArray()));
        localObject1 = aqnv.I(((Unisso.UniSsoServerReq)localObject2).toByteArray());
        localObject2 = "NewYearReport.pack_share";
        paramIntent.putExtra("k_retry", 2);
        break;
      } while (paramIntent.getExtras() == null);
      localObject1 = new subcmd0x501.SubCmd0x501ReqBody();
      ((subcmd0x501.SubCmd0x501ReqBody)localObject1).uint64_uin.set(Long.valueOf(paramIntent.getStringExtra("k_uin")).longValue());
      ((subcmd0x501.SubCmd0x501ReqBody)localObject1).uint32_idc_id.set(0);
      ((subcmd0x501.SubCmd0x501ReqBody)localObject1).uint32_appid.set(16);
      ((subcmd0x501.SubCmd0x501ReqBody)localObject1).uint32_login_sig_type.set(1);
      ((subcmd0x501.SubCmd0x501ReqBody)localObject1).uint32_request_flag.set(4);
      localObject2 = new subcmd0x501.ReqBody();
      ((subcmd0x501.ReqBody)localObject2).msg_subcmd_0x501_req_body.set((MessageMicro)localObject1);
      localObject1 = aqnv.I(((subcmd0x501.ReqBody)localObject2).toByteArray());
      localObject2 = "HttpConn.0x6ff_501";
      paramIntent.putExtra("k_retry", 2);
      break;
      localObject4 = paramIntent.getStringExtra("k_sso_id");
      localObject3 = paramIntent.getByteArrayExtra("k_sso_data");
      paramIntent.putExtra("k_new_page", false);
    }
  }
  
  public static class BrashReportItem
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public int count;
    public long time;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.RedPacketServlet
 * JD-Core Version:    0.7.0.1
 */