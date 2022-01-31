package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fgz;
import java.util.HashMap;
import tencent.im.oidb.cmd0x7a0.oidb_0x7a0.LoginSig;
import tencent.im.oidb.cmd0x7a0.oidb_0x7a0.ReqBody;
import tencent.im.oidb.cmd0x7a0.oidb_0x7a0.RspBody;
import tencent.im.oidb.cmd0x7a1.oidb_0x7a1.ReqBody;
import tencent.im.oidb.cmd0x7a1.oidb_0x7a1.RspBody;
import tencent.im.oidb.cmd0x7a2.oidb_0x7a2.ReqBody;
import tencent.im.oidb.cmd0x7a2.oidb_0x7a2.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class SubAccountBindHandler
  extends BusinessHandler
{
  public static final int a = 0;
  public static final String a = "OidbSvc.0x7a0_0";
  public static final int b = 1;
  public static final String b = "OidbSvc.0x7a1_0";
  public static final int c = 2;
  public static final String c = "OidbSvc.0x7a2_0";
  private static final String d = "Q.subaccount.SubAccountBindHandler";
  
  SubAccountBindHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerBindSubAccount: time = " + System.currentTimeMillis());
    }
    SubAccountBackProtocData localSubAccountBackProtocData = new SubAccountBackProtocData();
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    try
    {
      localSubAccountBackProtocData.p = 1000;
      a(0, false, localSubAccountBackProtocData);
      if (!QLog.isColorLevel()) {
        break label1656;
      }
      QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerBindSubAccount: req == null || resp == null");
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      bool1 = false;
    }
    int i = paramFromServiceMsg.getResultCode();
    String str1 = paramToServiceMsg.extraData.getString("subAccount");
    String str2 = paramToServiceMsg.getUin();
    localSubAccountBackProtocData.jdField_b_of_type_JavaLangString = str2;
    localSubAccountBackProtocData.c = str1;
    boolean bool1;
    boolean bool2;
    if (i == 1000)
    {
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerBindSubAccount: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
          }
          paramObject.printStackTrace();
        }
        if ((paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0)) {
          break label518;
        }
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12008");
        paramToServiceMsg.put("fail_step", "uint32_not_rs");
        paramToServiceMsg.put("fail_location", "bindhandle");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBDBindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localSubAccountBackProtocData.p = 1001;
        a(0, false, localSubAccountBackProtocData);
        if (!QLog.isColorLevel()) {
          break label1656;
        }
        QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerBindSubAccount: !pkg.hasUint32Result() || pkg.getUint32Result() != 0 ");
        return;
        label518:
        if ((paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null)) {
          break label628;
        }
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12008");
        paramToServiceMsg.put("fail_step", "body_buff_not");
        paramToServiceMsg.put("fail_location", "bindhandle");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBDBindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localSubAccountBackProtocData.p = 1000;
        a(0, false, localSubAccountBackProtocData);
        if (!QLog.isColorLevel()) {
          break label1656;
        }
        QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerBindSubAccount: !pkg.hasBytesBodybuffer() || pkg.getBytesBodybuffer() == null");
        return;
        label628:
        paramObject = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
        paramFromServiceMsg = new oidb_0x7a0.RspBody();
        try
        {
          paramObject = (oidb_0x7a0.RspBody)paramFromServiceMsg.mergeFrom(paramObject);
          paramFromServiceMsg = paramObject;
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerBindSubAccount: oidb_0x7a0 parseFrom byte InvalidProtocolBufferMicroException");
            }
            paramObject.printStackTrace();
          }
          i = paramFromServiceMsg.uint32_result.get();
          localSubAccountBackProtocData.q = i;
          if (!QLog.isColorLevel()) {
            break label822;
          }
          QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerBindSubAccount: rspResult = " + i);
          if (i != 0) {
            break label1065;
          }
          paramFromServiceMsg = new HashMap();
          paramFromServiceMsg.put("param_FailCode", "12009");
          paramFromServiceMsg.put("fail_step", "sucess_0");
          paramFromServiceMsg.put("fail_location", "bindhandle");
          StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBDBindProtol", true, 0L, 0L, paramFromServiceMsg, "");
        }
        if (paramFromServiceMsg != null) {
          break label774;
        }
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12012");
        paramToServiceMsg.put("fail_step", "rsp_null");
        paramToServiceMsg.put("fail_location", "bindhandle");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBDBindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localSubAccountBackProtocData.p = 1000;
        a(0, false, localSubAccountBackProtocData);
        if (!QLog.isColorLevel()) {
          break label1656;
        }
        QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerBindSubAccount: rsp == null");
        return;
      }
      if (paramFromServiceMsg == null)
      {
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12007");
        paramToServiceMsg.put("fail_step", "pkg_null");
        paramToServiceMsg.put("fail_location", "bindhandle");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBDBindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localSubAccountBackProtocData.p = 1000;
        a(0, false, localSubAccountBackProtocData);
        if (QLog.isColorLevel())
        {
          QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerBindSubAccount: pkg == null ");
          return;
          paramToServiceMsg.printStackTrace();
          paramFromServiceMsg = new HashMap();
          paramFromServiceMsg.put("param_FailCode", "12013");
          paramFromServiceMsg.put("fail_step", "exception");
          paramFromServiceMsg.put("fail_location", "bindhandle");
          StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBDBindProtol", false, 0L, 0L, paramFromServiceMsg, "");
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerBindSubAccount: last exception errormsg = " + paramToServiceMsg.getMessage());
            bool2 = bool1;
          }
          if (!bool2) {
            SubAccountAssistantImpl.a().a(this.a, System.currentTimeMillis() / 1000L);
          }
          a(0, bool2, localSubAccountBackProtocData);
        }
      }
      else
      {
        try
        {
          label774:
          label822:
          localSubAccountBackProtocData.p = 0;
          SubAccountAssistantImpl.a().a(this.a, str1);
          paramToServiceMsg = paramToServiceMsg.extraData.getString("subaccount_a2");
          SubAccountAssistantImpl.a().a(this.a, str1, paramToServiceMsg);
          DBUtils.a().a(localSubAccountBackProtocData.jdField_b_of_type_JavaLangString, this.a.a());
          SubAccountAssistantImpl.a().a(this.a, System.currentTimeMillis() / 1000L);
          long l1 = SubAccountAssistantImpl.a().a(this.a, str1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerBindSubAccount status = " + l1);
          }
          paramFromServiceMsg = SubAccountAssistantImpl.a();
          paramObject = this.a;
          long l2 = Long.parseLong(str1);
          if (paramToServiceMsg == null) {}
          for (paramToServiceMsg = null;; paramToServiceMsg = HexUtil.a(paramToServiceMsg))
          {
            paramFromServiceMsg.a(paramObject, (byte)1, l2, paramToServiceMsg, (int)l1);
            this.a.e(false);
            bool1 = true;
            break;
          }
          label1065:
          paramToServiceMsg = new HashMap();
          paramToServiceMsg.put("param_FailCode", "12011");
          paramToServiceMsg.put("fail_step", "Bind_fail_rsp_" + i);
          paramToServiceMsg.put("fail_location", "bindhandle");
          bool1 = false;
          if ((i == 1000) || (i == 1001)) {
            break label1664;
          }
          label1142:
          StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBDBindProtol", bool1, 0L, 0L, paramToServiceMsg, "");
          localSubAccountBackProtocData.a = paramFromServiceMsg.str_errmsg.get();
          switch (i)
          {
          case 1000: 
            paramToServiceMsg = String.valueOf(paramFromServiceMsg.uint64_err_uin.get());
            if ((str1 != null) && (paramToServiceMsg.equalsIgnoreCase(str1)))
            {
              localSubAccountBackProtocData.p = 1004;
              this.a.updateSubAccountLogin(localSubAccountBackProtocData.c, false);
              if (!QLog.isColorLevel()) {
                break label1745;
              }
              QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerBindSubAccount: ERRORTYPE_SUBACCOUNT_A2_ERROR");
              break label1745;
              localSubAccountBackProtocData.p = 1002;
              if (!QLog.isColorLevel()) {
                break label1751;
              }
              QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerBindSubAccount: ERRORTYPE_MAIN_HADBIND_ANOTHER");
              bool1 = false;
            }
            break;
          case 1001: 
            label1204:
            localSubAccountBackProtocData.p = 1003;
            if (!QLog.isColorLevel()) {
              break label1751;
            }
            QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerBindSubAccount: ERRORTYPE_SUB_HADBIND_ANOTHER");
            bool1 = false;
            break label1657;
            if ((str2 != null) && (str2.equalsIgnoreCase(paramToServiceMsg)))
            {
              localSubAccountBackProtocData.p = 1005;
              if (QLog.isColorLevel()) {
                QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerBindSubAccount: ERRORTYPE_MAINACCOUNT_A2_ERROR");
              }
            }
            else
            {
              localSubAccountBackProtocData.p = 1000;
              if (QLog.isColorLevel()) {
                QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerBindSubAccount: ERRORTYPE_UNKNOW");
              }
            }
            break;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          label1392:
          bool1 = true;
        }
        if (i == 1221)
        {
          localSubAccountBackProtocData.p = 1011;
          if (!QLog.isColorLevel()) {
            break label1751;
          }
          QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerBindSubAccount: ERRORTYPE_EQLIP_LOCK_FAIL");
          bool1 = false;
          break label1657;
        }
        localSubAccountBackProtocData.p = 1000;
        if (!QLog.isColorLevel()) {
          break label1751;
        }
        QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerBindSubAccount: ERRORTYPE_UNKNOW");
        break label1751;
      }
    }
    label1455:
    label1745:
    label1751:
    for (;;)
    {
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("param_FailCode", "12010");
      paramToServiceMsg.put("fail_step", "timeout");
      paramToServiceMsg.put("fail_location", "bindhandle");
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBDBindProtol", false, 0L, 0L, paramToServiceMsg, "");
      localSubAccountBackProtocData.p = 1007;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerBindSubAccount: ERRORTYPE_SERVER_TIMEOUT");
        bool1 = false;
      }
      label1656:
      label1657:
      do
      {
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12012");
        paramToServiceMsg.put("fail_step", "fali_end_rs_" + i);
        paramToServiceMsg.put("fail_location", "bindhandle");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBDBindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localSubAccountBackProtocData.p = 1000;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerBindSubAccount: ERRORTYPE_UNKNOW last");
          break label1751;
          break;
          return;
        }
        for (;;)
        {
          bool2 = bool1;
          break;
          bool1 = true;
          break label1142;
          if ((i == 1200) || (i == 1214) || (i == 1215) || (i == 1218) || (i == 1232) || (i == 1233) || (i == 1240) || (i == 1241)) {
            break label1204;
          }
          if (i != 1242) {
            break label1392;
          }
          break label1204;
          bool1 = false;
          continue;
          bool1 = false;
        }
        if (i == 1002) {
          break label1455;
        }
      } while (i != 1013);
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerUnBindSubAccount: start");
    }
    SubAccountBackProtocData localSubAccountBackProtocData = new SubAccountBackProtocData();
    boolean bool2 = false;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    try
    {
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("param_FailCode", "12007");
      paramToServiceMsg.put("fail_step", "rep_null");
      paramToServiceMsg.put("fail_location", "SubBind");
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBUnbindProtol", false, 0L, 0L, paramToServiceMsg, "");
      localSubAccountBackProtocData.p = 1000;
      a(1, false, localSubAccountBackProtocData);
      if (!QLog.isColorLevel()) {
        break label1778;
      }
      QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerUnBindSubAccount: req == null || resp == null");
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      bool2 = false;
      paramToServiceMsg = paramToServiceMsg;
    }
    int i = paramFromServiceMsg.getResultCode();
    String str1 = paramToServiceMsg.extraData.getString("subAccount");
    String str2 = paramToServiceMsg.getUin();
    localSubAccountBackProtocData.jdField_b_of_type_JavaLangString = str2;
    localSubAccountBackProtocData.c = str1;
    boolean bool1;
    if (i == 1000)
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerUnBindSubAccount: oidb_sso parseFrom byte InvalidProtocolBufferMicroException");
          }
          paramFromServiceMsg.printStackTrace();
        }
        if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0)) {
          break label555;
        }
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12008");
        paramToServiceMsg.put("fail_step", "pkg32rs_null");
        paramToServiceMsg.put("fail_location", "SubBind");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBUnbindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localSubAccountBackProtocData.p = 1001;
        a(1, false, localSubAccountBackProtocData);
        if (!QLog.isColorLevel()) {
          break label1778;
        }
        QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerUnBindSubAccount: !pkg.hasUint32Result() || pkg.getUint32Result() != 0");
        return;
        label555:
        if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
          break label669;
        }
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12008");
        paramToServiceMsg.put("fail_step", "bytebody_null");
        paramToServiceMsg.put("fail_location", "SubBind");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBUnbindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localSubAccountBackProtocData.p = 1000;
        a(1, false, localSubAccountBackProtocData);
        if (!QLog.isColorLevel()) {
          break label1778;
        }
        QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerUnBindSubAccount: !pkg.hasBytesBodybuffer() || pkg.getBytesBodybuffer() == null");
        return;
        label669:
        paramFromServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        paramToServiceMsg = new oidb_0x7a1.RspBody();
        try
        {
          paramFromServiceMsg = (oidb_0x7a1.RspBody)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
          paramToServiceMsg = paramFromServiceMsg;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerUnBindSubAccount: oidb_0x7a1 parseFrom byte InvalidProtocolBufferMicroException");
            }
            paramFromServiceMsg.printStackTrace();
          }
          i = paramToServiceMsg.uint32_result.get();
          localSubAccountBackProtocData.q = i;
          localSubAccountBackProtocData.a = paramToServiceMsg.str_errmsg.get();
          if (!QLog.isColorLevel()) {
            break label1779;
          }
        }
        if (paramToServiceMsg != null) {
          break label819;
        }
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12012");
        paramToServiceMsg.put("fail_step", "rsp_null");
        paramToServiceMsg.put("fail_location", "SubBind");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBUnbindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localSubAccountBackProtocData.p = 1000;
        a(1, false, localSubAccountBackProtocData);
        if (!QLog.isColorLevel()) {
          break label1778;
        }
        QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerUnBindSubAccount: rsp == null");
        return;
        label819:
        QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerUnBindSubAccount: rspResult = " + i);
      }
      if (paramToServiceMsg == null)
      {
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12008");
        paramToServiceMsg.put("fail_step", "pkg_null");
        paramToServiceMsg.put("fail_location", "SubBind");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBUnbindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localSubAccountBackProtocData.p = 1000;
        a(1, false, localSubAccountBackProtocData);
        if (!QLog.isColorLevel()) {
          break label1778;
        }
        QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerUnBindSubAccount: pkg == null");
        return;
        paramToServiceMsg.printStackTrace();
        paramFromServiceMsg = new HashMap();
        paramFromServiceMsg.put("param_FailCode", "12013");
        paramFromServiceMsg.put("fail_step", "exception");
        paramFromServiceMsg.put("fail_location", "SubBind");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBUnbindProtol", false, 0L, 0L, paramFromServiceMsg, "");
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.e("Q.subaccount.SubAccountBindHandler", 2, "handlerUnBindSubAccount:   error e = " + paramToServiceMsg.getMessage());
          bool1 = bool2;
        }
      }
      for (;;)
      {
        a(1, bool1, localSubAccountBackProtocData);
        return;
        label883:
        paramFromServiceMsg = new HashMap();
        paramFromServiceMsg.put("param_FailCode", "12011");
        paramFromServiceMsg.put("fail_step", "rspResult_" + i);
        paramFromServiceMsg.put("fail_location", "SubBind");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBUnbindProtol", false, 0L, 0L, paramFromServiceMsg, "");
        if ((i == 1200) || (i == 1214) || (i == 1215) || (i == 1218) || (i == 1232) || (i == 1233) || (i == 1240) || (i == 1241) || (i == 1242))
        {
          paramToServiceMsg = String.valueOf(paramToServiceMsg.uint64_err_uin.get());
          if ((str1 != null) && (paramToServiceMsg.equalsIgnoreCase(str1)))
          {
            if (!QLog.isColorLevel()) {
              break label1819;
            }
            QLog.e("Q.subaccount.SubAccountBindHandler", 2, "handlerUnBindSubAccount: server error happen subaccount a2 error? not it is not happan");
            break label1819;
            paramToServiceMsg = new HashMap();
            paramToServiceMsg.put("param_FailCode", "12009");
            paramToServiceMsg.put("fail_step", "rspResult_0");
            paramToServiceMsg.put("fail_location", "SubBind");
            StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBUnbindProtol", true, 0L, 0L, paramToServiceMsg, "");
            this.a.u();
            bool1 = true;
            try
            {
              localSubAccountBackProtocData.p = 0;
              SubAccountAssistantImpl.a().b(this.a);
              DBUtils.a().a(localSubAccountBackProtocData.jdField_b_of_type_JavaLangString, this.a.a());
              if (SubAccountAssistantImpl.a().b(this.a)) {
                SubAccountAssistantImpl.a().a(this.a, false);
              }
              SubAccountAssistantImpl.a().a(this.a, System.currentTimeMillis() / 1000L);
            }
            catch (Exception paramToServiceMsg)
            {
              bool2 = true;
            }
            break;
            paramToServiceMsg = new HashMap();
            paramToServiceMsg.put("param_FailCode", "12009");
            paramToServiceMsg.put("fail_step", "rspResult_" + i);
            paramToServiceMsg.put("fail_location", "SubBind");
            StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBUnbindProtol", true, 0L, 0L, paramToServiceMsg, "");
            localSubAccountBackProtocData.p = 1008;
            SubAccountAssistantImpl.a().c(this.a, str1);
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerUnBindSubAccount: ERRORTYPE_MAIN_NOT_BIND_THE_SUB");
            bool1 = false;
            continue;
            paramToServiceMsg = new HashMap();
            paramToServiceMsg.put("param_FailCode", "12009");
            paramToServiceMsg.put("fail_step", "rspResult_" + i);
            paramToServiceMsg.put("fail_location", "SubBind");
            StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBUnbindProtol", true, 0L, 0L, paramToServiceMsg, "");
            localSubAccountBackProtocData.p = 1002;
            SubAccountAssistantImpl.a().c(this.a, str1);
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerUnBindSubAccount: ERRORTYPE_MAIN_HADBIND_ANOTHER");
            bool1 = false;
            continue;
          }
          if ((str2 != null) && (str2.equalsIgnoreCase(paramToServiceMsg)))
          {
            localSubAccountBackProtocData.p = 1005;
            if (!QLog.isColorLevel()) {
              break label1819;
            }
            QLog.e("Q.subaccount.SubAccountBindHandler", 2, "handlerUnBindSubAccount: ERRORTYPE_MAINACCOUNT_A2_ERROR");
            break label1819;
          }
          localSubAccountBackProtocData.p = 1000;
          if (!QLog.isColorLevel()) {
            break label1819;
          }
          QLog.e("Q.subaccount.SubAccountBindHandler", 2, "handlerUnBindSubAccount: ERRORTYPE_UNKNOW");
          break label1819;
        }
        localSubAccountBackProtocData.p = 1000;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.e("Q.subaccount.SubAccountBindHandler", 2, "handlerUnBindSubAccount: ERRORTYPE_UNKNOW");
          bool1 = bool2;
        }
      }
    }
    label1819:
    for (;;)
    {
      label1586:
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("param_FailCode", "12010");
      paramToServiceMsg.put("fail_step", "timeout");
      paramToServiceMsg.put("fail_location", "SubBind");
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBUnbindProtol", false, 0L, 0L, paramToServiceMsg, "");
      localSubAccountBackProtocData.p = 1007;
      bool1 = bool2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Q.subaccount.SubAccountBindHandler", 2, "handlerUnBindSubAccount: ERRORTYPE_SERVER_TIMEOUT");
      bool1 = false;
      break;
      label1778:
      label1779:
      do
      {
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12012");
        paramToServiceMsg.put("fail_step", "error");
        paramToServiceMsg.put("fail_location", "SubBind");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBUnbindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localSubAccountBackProtocData.p = 1000;
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.subaccount.SubAccountBindHandler", 2, "handlerUnBindSubAccount: ERRORTYPE_UNKNOW last");
        bool1 = bool2;
        break;
        return;
        switch (i)
        {
        }
        break label883;
        bool1 = false;
        break;
        bool2 = false;
        if (i == 1002) {
          break label1586;
        }
      } while (i != 1013);
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerGetBindSubAccount:");
    }
    SubAccountBackProtocData localSubAccountBackProtocData = new SubAccountBackProtocData();
    int i = 1;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    boolean bool1;
    try
    {
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("param_FailCode", "12007");
      paramToServiceMsg.put("fail_step", "req_null");
      paramToServiceMsg.put("fail_location", "SubBind");
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBGetbindProtol", false, 0L, 0L, paramToServiceMsg, "");
      localSubAccountBackProtocData.p = 1000;
      a(2, false, localSubAccountBackProtocData);
      if (!QLog.isColorLevel()) {
        break label1642;
      }
      QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerGetBindSubAccount: req == null || resp == null");
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      bool1 = false;
      i = 1;
    }
    int j = paramFromServiceMsg.getResultCode();
    localSubAccountBackProtocData.jdField_b_of_type_JavaLangString = paramToServiceMsg.getUin();
    boolean bool2;
    if (j == 1000)
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
        }
        if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0)) {
          break label534;
        }
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12008");
        paramToServiceMsg.put("fail_step", "pkguint32_null");
        paramToServiceMsg.put("fail_location", "SubBind");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBGetbindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localSubAccountBackProtocData.p = 1001;
        a(2, false, localSubAccountBackProtocData);
        if (!QLog.isColorLevel()) {
          break label1642;
        }
        QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerGetBindSubAccount: !pkg.hasUint32Result() || pkg.getUint32Result() != 0");
        return;
        label534:
        if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
          break label648;
        }
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12008");
        paramToServiceMsg.put("fail_step", "bytebody_null");
        paramToServiceMsg.put("fail_location", "SubBind");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBGetbindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localSubAccountBackProtocData.p = 1000;
        a(2, false, localSubAccountBackProtocData);
        if (!QLog.isColorLevel()) {
          break label1642;
        }
        QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerGetBindSubAccount: !pkg.hasBytesBodybuffer() || pkg.getBytesBodybuffer() == null");
        return;
        label648:
        paramFromServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        paramToServiceMsg = new oidb_0x7a2.RspBody();
        try
        {
          paramFromServiceMsg = (oidb_0x7a2.RspBody)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
          paramToServiceMsg = paramFromServiceMsg;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerGetBindSubAccount: parseFrom byte InvalidProtocolBufferMicroException ");
            }
            paramFromServiceMsg.printStackTrace();
          }
          j = paramToServiceMsg.uint32_result.get();
          localSubAccountBackProtocData.q = j;
          localSubAccountBackProtocData.a = paramToServiceMsg.str_errmsg.get();
          switch (j)
          {
          }
        }
        if (paramToServiceMsg != null) {
          break label799;
        }
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12012");
        paramToServiceMsg.put("fail_step", "bytebody_null");
        paramToServiceMsg.put("fail_location", "SubBind");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBGetbindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localSubAccountBackProtocData.p = 1000;
        a(2, false, localSubAccountBackProtocData);
        if (!QLog.isColorLevel()) {
          break label1642;
        }
        QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerGetBindSubAccount: rsp == null");
        return;
      }
      if (paramToServiceMsg == null)
      {
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12008");
        paramToServiceMsg.put("fail_step", "pkg_null");
        paramToServiceMsg.put("fail_location", "SubBind");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBGetbindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localSubAccountBackProtocData.p = 1000;
        a(2, false, localSubAccountBackProtocData);
        if (QLog.isColorLevel())
        {
          QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerGetBindSubAccount: pkg == null");
          return;
          paramFromServiceMsg = new HashMap();
          paramFromServiceMsg.put("param_FailCode", "12013");
          paramFromServiceMsg.put("fail_step", "exception");
          paramFromServiceMsg.put("fail_location", "SubBind");
          StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBGetbindProtol", false, 0L, 0L, paramFromServiceMsg, "");
          paramToServiceMsg.printStackTrace();
          j = i;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.e("Q.subaccount.SubAccountBindHandler", 2, "handlerGetBindSubAccount: exception happen e = " + paramToServiceMsg.getMessage());
            bool2 = bool1;
            j = i;
          }
          if (j != 0) {
            a(2, bool2, localSubAccountBackProtocData);
          }
        }
      }
      else
      {
        label799:
        label848:
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12011");
        paramToServiceMsg.put("fail_step", "rspResult_" + j);
        paramToServiceMsg.put("fail_location", "SubBind");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBGetbindProtol", false, 0L, 0L, paramToServiceMsg, "");
        if ((j == 1200) || (j == 1214) || (j == 1215) || (j == 1218) || (j == 1232) || (j == 1233) || (j == 1240) || (j == 1241) || (j == 1242))
        {
          localSubAccountBackProtocData.p = 1005;
          if (!QLog.isColorLevel()) {
            break label1657;
          }
          QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerGetBindSubAccount: get main account a2 error rspResult = " + j);
          bool1 = false;
          break label1646;
          paramFromServiceMsg = new HashMap();
          paramFromServiceMsg.put("param_FailCode", "12009");
          paramFromServiceMsg.put("fail_step", "success_0");
          paramFromServiceMsg.put("fail_location", "SubBind");
          StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBGetbindProtol", true, 0L, 0L, paramFromServiceMsg, "");
          this.a.u();
        }
        for (;;)
        {
          try
          {
            localSubAccountBackProtocData.p = 0;
            localSubAccountBackProtocData.c = String.valueOf(paramToServiceMsg.uint64_bind_uin.get());
            if ((paramToServiceMsg.uint64_bind_uin.get() != 0L) && (localSubAccountBackProtocData.c.length() > 4))
            {
              SubAccountAssistantImpl.a().a(this.a, localSubAccountBackProtocData.c);
              DBUtils.a().a(localSubAccountBackProtocData.jdField_b_of_type_JavaLangString, this.a.a());
              bool1 = SubAccountAssistantImpl.a().a(this.a, localSubAccountBackProtocData.c);
              if (QLog.isColorLevel()) {
                QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerGetBindSubAccount isLogin = " + bool1);
              }
              if (bool1) {
                i = 0;
              }
            }
          }
          catch (Exception paramToServiceMsg)
          {
            i = 1;
            bool1 = true;
          }
          try
          {
            paramToServiceMsg = localSubAccountBackProtocData.c;
            this.a.getSubAccountKey(this.a.getAccount(), localSubAccountBackProtocData.c, new fgz(this, localSubAccountBackProtocData, paramToServiceMsg));
            bool1 = true;
          }
          catch (Exception paramToServiceMsg)
          {
            i = 0;
            bool1 = true;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerGetBindSubAccount, has subaccount but islogin is false");
          }
          SubAccountAssistantImpl.a().a(this.a, localSubAccountBackProtocData.c, null);
          i = 1;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerGetBindSubAccount, not has subaccount");
          }
          localSubAccountBackProtocData.p = 1008;
          SubAccountAssistantImpl.a().b(this.a);
          bool1 = true;
          break label1646;
          localSubAccountBackProtocData.p = 1000;
          localSubAccountBackProtocData.jdField_b_of_type_Boolean = true;
          if (!QLog.isColorLevel()) {
            break label1657;
          }
          QLog.d("Q.subaccount.SubAccountBindHandler", 2, "handlerGetBindSubAccount: get main account error rspResult = " + j);
          break label1657;
        }
      }
    }
    for (;;)
    {
      label1421:
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("param_FailCode", "12010");
      paramToServiceMsg.put("fail_step", "timeout");
      paramToServiceMsg.put("fail_location", "SubBind");
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBGetbindProtol", false, 0L, 0L, paramToServiceMsg, "");
      localSubAccountBackProtocData.p = 1007;
      if (QLog.isColorLevel()) {
        QLog.e("Q.subaccount.SubAccountBindHandler", 2, "handlerGetBindSubAccount: timeout");
      }
      label1507:
      localSubAccountBackProtocData.jdField_b_of_type_Boolean = true;
      label1642:
      label1646:
      label1657:
      do
      {
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12012");
        paramToServiceMsg.put("fail_step", "result_" + j);
        paramToServiceMsg.put("fail_location", "SubBind");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.a(), "actSBGetbindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localSubAccountBackProtocData.p = 1000;
        if (!QLog.isColorLevel()) {
          break label1507;
        }
        QLog.e("Q.subaccount.SubAccountBindHandler", 2, "handlerGetBindSubAccount: ERRORTYPE_UNKNOW last");
        break label1507;
        break;
        break;
        return;
        break label848;
        for (;;)
        {
          j = i;
          bool2 = bool1;
          break;
          bool1 = false;
        }
        if (j == 1002) {
          break label1421;
        }
      } while (j != 1013);
    }
  }
  
  protected Class a()
  {
    return SubAccountBindObserver.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountBindHandler", 2, "getBindSubAccount: start");
    }
    Object localObject = new oidb_0x7a2.ReqBody();
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1954);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(0);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x7a2.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x7a2_0");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ((str == null) || (str.length() == 0)) {}
    do
    {
      return;
      if ("OidbSvc.0x7a0_0".equalsIgnoreCase(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7a1_0".equalsIgnoreCase(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x7a2_0".equalsIgnoreCase(str));
    d(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountBindHandler", 2, "unBindSubAccount: start");
    }
    Object localObject1 = new oidb_0x7a1.ReqBody();
    Object localObject2 = Utils.b(this.a.a());
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((oidb_0x7a1.ReqBody)localObject1).str_imei.set((String)localObject2);
    }
    ((oidb_0x7a1.ReqBody)localObject1).uint64_bind_uin.set(Long.parseLong(paramString));
    ((oidb_0x7a1.ReqBody)localObject1).uint32_clt_appid.set(this.a.a());
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1953);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x7a1.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x7a1_0");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("subAccount", paramString);
    b((ToServiceMsg)localObject1);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountBindHandler", 2, "bindSubAccount: start");
    }
    oidb_0x7a0.LoginSig localLoginSig = new oidb_0x7a0.LoginSig();
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramString2 != null) {}
    try
    {
      localObject1 = PkgTools.a(paramString2);
      if (localObject1 != null) {
        localLoginSig.bytes_sig.set(ByteStringMicro.copyFrom((byte[])localObject1));
      }
      localLoginSig.uint32_type.set(8);
      localLoginSig.uint32_appid.set(16);
      localObject1 = new oidb_0x7a0.ReqBody();
      ((oidb_0x7a0.ReqBody)localObject1).msg_bind_uin_sig.set(localLoginSig);
      localObject3 = Utils.b(this.a.a());
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((oidb_0x7a0.ReqBody)localObject1).str_imei.set((String)localObject3);
      }
      ((oidb_0x7a0.ReqBody)localObject1).uint64_bind_uin.set(Long.parseLong(paramString1));
      ((oidb_0x7a0.ReqBody)localObject1).uint32_clt_appid.set(this.a.a());
      localObject3 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject3).uint32_command.set(1952);
      ((oidb_sso.OIDBSSOPkg)localObject3).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject3).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x7a0.ReqBody)localObject1).toByteArray()));
      localObject1 = a("OidbSvc.0x7a0_0");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject3).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("subAccount", paramString1);
      ((ToServiceMsg)localObject1).extraData.putString("subaccount_a2", paramString2);
      b((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject2 = localObject3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SubAccountBindHandler
 * JD-Core Version:    0.7.0.1
 */