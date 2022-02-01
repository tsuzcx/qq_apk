import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tencent.im.oidb.cmd0x7a0.oidb_0x7a0.LoginSig;
import tencent.im.oidb.cmd0x7a0.oidb_0x7a0.ReqBody;
import tencent.im.oidb.cmd0x7a0.oidb_0x7a0.RspBody;
import tencent.im.oidb.cmd0x7a1.oidb_0x7a1.ReqBody;
import tencent.im.oidb.cmd0x7a1.oidb_0x7a1.RspBody;
import tencent.im.oidb.cmd0x7a2.oidb_0x7a2.ReqBody;
import tencent.im.oidb.cmd0x7a2.oidb_0x7a2.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class acmd
  extends accg
{
  public acmd(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void fR(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() time = " + System.currentTimeMillis());
    }
    String str3;
    String str1;
    String str2;
    anxs localanxs;
    int i;
    boolean bool1;
    label264:
    boolean bool2;
    if (paramToServiceMsg != null)
    {
      str3 = paramToServiceMsg.getUin();
      str1 = paramToServiceMsg.extraData.getString("subAccount");
      str2 = paramToServiceMsg.extraData.getString("fromWhere");
      localanxs = new anxs();
      if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
      try
      {
        localanxs.errorType = 1000;
        notifyUI(0, false, localanxs);
        if (!QLog.isColorLevel()) {
          break label1697;
        }
        QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() req == null || resp == null");
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        bool1 = false;
      }
      i = paramFromServiceMsg.getResultCode();
      localanxs.aLa = str3;
      localanxs.aQf = str1;
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
            label369:
            if (!QLog.isColorLevel()) {
              break label398;
            }
            QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
            paramObject.printStackTrace();
            continue;
            if ((paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0)) {
              break label515;
            }
            paramToServiceMsg = new HashMap();
            paramToServiceMsg.put("param_FailCode", "12008");
            paramToServiceMsg.put("fail_step", "uint32_not_rs");
            paramToServiceMsg.put("fail_location", "bindhandle");
            anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBDBindProtol", false, 0L, 0L, paramToServiceMsg, "");
            localanxs.errorType = 1001;
            notifyUI(0, false, localanxs);
            if (!QLog.isColorLevel()) {
              break label1697;
            }
            QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() !pkg.hasUint32Result() || pkg.getUint32Result() != 0 ");
            return;
            if ((paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null)) {
              break label625;
            }
            paramToServiceMsg = new HashMap();
            paramToServiceMsg.put("param_FailCode", "12008");
            paramToServiceMsg.put("fail_step", "body_buff_not");
            paramToServiceMsg.put("fail_location", "bindhandle");
            anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBDBindProtol", false, 0L, 0L, paramToServiceMsg, "");
            localanxs.errorType = 1000;
            notifyUI(0, false, localanxs);
            if (!QLog.isColorLevel()) {
              break label1697;
            }
            QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() !pkg.hasBytesBodybuffer() || pkg.getBytesBodybuffer() == null");
            return;
            paramObject = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
            paramFromServiceMsg = new oidb_0x7a0.RspBody();
            try
            {
              paramObject = (oidb_0x7a0.RspBody)paramFromServiceMsg.mergeFrom(paramObject);
              paramFromServiceMsg = paramObject;
              if (paramFromServiceMsg != null) {
                break label771;
              }
              paramToServiceMsg = new HashMap();
              paramToServiceMsg.put("param_FailCode", "12012");
              paramToServiceMsg.put("fail_step", "rsp_null");
              paramToServiceMsg.put("fail_location", "bindhandle");
              anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBDBindProtol", false, 0L, 0L, paramToServiceMsg, "");
              localanxs.errorType = 1000;
              notifyUI(0, false, localanxs);
              if (!QLog.isColorLevel()) {
                break label1697;
              }
              QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() rsp == null");
              return;
            }
            catch (InvalidProtocolBufferMicroException paramObject)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() oidb_0x7a0 parseFrom byte InvalidProtocolBufferMicroException");
                }
                paramObject.printStackTrace();
              }
              i = paramFromServiceMsg.uint32_result.get();
              localanxs.serverErrorType = i;
              if (!QLog.isColorLevel()) {
                break label819;
              }
              QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() rspResult = " + i);
              if (i != 0) {
                break label1053;
              }
              paramFromServiceMsg = new HashMap();
              paramFromServiceMsg.put("param_FailCode", "12009");
              paramFromServiceMsg.put("fail_step", "sucess_0");
              paramFromServiceMsg.put("fail_location", "bindhandle");
              anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBDBindProtol", true, 0L, 0L, paramFromServiceMsg, "");
              try
              {
                localanxs.errorType = 0;
                paramFromServiceMsg = (anxr)this.app.getManager(61);
                paramToServiceMsg = paramToServiceMsg.extraData.getString("subaccount_a2");
                if (paramFromServiceMsg != null)
                {
                  paramFromServiceMsg.a(localanxs);
                  paramFromServiceMsg.am(str1, 1);
                  paramFromServiceMsg.R(str1, paramToServiceMsg, true);
                }
                anxk.a(this.app, (byte)1, str1);
                anxk.e(this.app, false, str1);
                anxk.d(this.app, str1, false);
                paramToServiceMsg = (aeoa)aeif.a().o(607);
                if ((paramToServiceMsg != null) && (!paramToServiceMsg.bVj)) {
                  anxq.a(this.app, str1);
                }
                if (AccountManageActivity.class.getSimpleName().equals(str2)) {
                  anot.a(this.app, "CliOper", "", "", "0X8004003", "0X8004003", 0, 0, "", "", "", "");
                }
                bool1 = true;
              }
              catch (Exception paramToServiceMsg)
              {
                bool1 = true;
              }
              paramToServiceMsg = new HashMap();
              paramToServiceMsg.put("param_FailCode", "12011");
              paramToServiceMsg.put("fail_step", "Bind_fail_rsp_" + i);
              paramToServiceMsg.put("fail_location", "bindhandle");
              bool1 = false;
              if (i == 1000) {
                break label1698;
              }
              if (i != 1001) {
                break label1130;
              }
            }
          }
        }
        if (paramFromServiceMsg == null)
        {
          paramToServiceMsg = new HashMap();
          paramToServiceMsg.put("param_FailCode", "12007");
          paramToServiceMsg.put("fail_step", "pkg_null");
          paramToServiceMsg.put("fail_location", "bindhandle");
          anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBDBindProtol", false, 0L, 0L, paramToServiceMsg, "");
          localanxs.errorType = 1000;
          notifyUI(0, false, localanxs);
          if (!QLog.isColorLevel()) {
            break label1697;
          }
          QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() pkg == null ");
          return;
          paramToServiceMsg.printStackTrace();
          paramFromServiceMsg = new HashMap();
          paramFromServiceMsg.put("param_FailCode", "12013");
          paramFromServiceMsg.put("fail_step", "exception");
          paramFromServiceMsg.put("fail_location", "bindhandle");
          anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBDBindProtol", false, 0L, 0L, paramFromServiceMsg, "");
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() last exception errormsg = " + paramToServiceMsg.getMessage());
            bool2 = bool1;
          }
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      label373:
      notifyUI(0, bool1, localanxs);
      return;
      label398:
      label625:
      anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBDBindProtol", bool1, 0L, 0L, paramToServiceMsg, "");
      label515:
      label771:
      label819:
      label1130:
      localanxs.errorMsg = paramFromServiceMsg.str_errmsg.get();
      label1053:
      switch (i)
      {
      }
      for (;;)
      {
        label1192:
        paramToServiceMsg = String.valueOf(paramFromServiceMsg.uint64_err_uin.get());
        if ((str1 != null) && (paramToServiceMsg.equalsIgnoreCase(str1)))
        {
          localanxs.errorType = 1004;
          this.app.updateSubAccountLogin(localanxs.aQf, false);
          if (!QLog.isColorLevel()) {
            break label1779;
          }
          QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_SUBACCOUNT_A2_ERROR");
          break label1779;
          localanxs.errorType = 1002;
          if (!QLog.isColorLevel()) {
            break label1440;
          }
          QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_MAIN_HADBIND_ANOTHER");
          bool1 = false;
          break label373;
          localanxs.errorType = 1003;
          if (!QLog.isColorLevel()) {
            break label1440;
          }
          QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_SUB_HADBIND_ANOTHER");
          bool1 = false;
          break label373;
        }
        if ((str3 != null) && (str3.equalsIgnoreCase(paramToServiceMsg)))
        {
          localanxs.errorType = 1005;
          if (!QLog.isColorLevel()) {
            break label1779;
          }
          QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_MAINACCOUNT_A2_ERROR");
          break label1779;
        }
        localanxs.errorType = 1000;
        if (!QLog.isColorLevel()) {
          break label1779;
        }
        QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_UNKNOW");
        break label1779;
        label1440:
        label1697:
        label1698:
        do
        {
          for (;;)
          {
            if (i == 1221)
            {
              localanxs.errorType = 1011;
              if (!QLog.isColorLevel()) {
                break label1440;
              }
              QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_EQLIP_LOCK_FAIL");
              bool1 = false;
              break label373;
            }
            localanxs.errorType = 1000;
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_UNKNOW");
            }
            bool1 = false;
            break label373;
            boolean bool3 = false;
            bool1 = false;
            if ((i == 1002) || (i == 1013)) {}
            try
            {
              paramToServiceMsg = new HashMap();
              paramToServiceMsg.put("param_FailCode", "12010");
              paramToServiceMsg.put("fail_step", "timeout");
              paramToServiceMsg.put("fail_location", "bindhandle");
              anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBDBindProtol", false, 0L, 0L, paramToServiceMsg, "");
              localanxs.errorType = 1007;
              bool2 = bool3;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_SERVER_TIMEOUT");
              bool1 = false;
            }
            catch (Exception paramToServiceMsg) {}
          }
          paramToServiceMsg = new HashMap();
          paramToServiceMsg.put("param_FailCode", "12012");
          paramToServiceMsg.put("fail_step", "fali_end_rs_" + i);
          paramToServiceMsg.put("fail_location", "bindhandle");
          anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBDBindProtol", false, 0L, 0L, paramToServiceMsg, "");
          localanxs.errorType = 1000;
          bool2 = bool3;
          if (!QLog.isColorLevel()) {
            break label369;
          }
          QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_UNKNOW last");
          bool2 = bool3;
          break label369;
          break label264;
          break label264;
          str2 = null;
          str1 = null;
          str3 = null;
          break;
          return;
          bool1 = true;
          break label1130;
          if ((i == 1200) || (i == 1214) || (i == 1215) || (i == 1218) || (i == 1232) || (i == 1233) || (i == 1240) || (i == 1241)) {
            break label1192;
          }
        } while (i != 1242);
      }
      label1779:
      bool1 = false;
    }
  }
  
  private void fS(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "handlerUnBindSubAccount() start");
    }
    String str1;
    String str2;
    anxs localanxs;
    int i;
    boolean bool1;
    label301:
    boolean bool2;
    if (paramToServiceMsg != null)
    {
      str1 = paramToServiceMsg.extraData.getString("subAccount");
      str2 = paramToServiceMsg.getUin();
      localanxs = new anxs();
      if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
      try
      {
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12007");
        paramToServiceMsg.put("fail_step", "rep_null");
        paramToServiceMsg.put("fail_location", "SubBind");
        anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBUnbindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localanxs.errorType = 1000;
        notifyUI(1, false, localanxs);
        if (!QLog.isColorLevel()) {
          break label1496;
        }
        QLog.d("SUB_ACCOUNT", 2, "handlerUnBindSubAccount() req == null || resp == null");
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        bool1 = false;
      }
      i = paramFromServiceMsg.getResultCode();
      localanxs.aLa = str2;
      localanxs.aQf = str1;
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
            label409:
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "handlerUnBindSubAccount() oidb_sso parseFrom byte InvalidProtocolBufferMicroException");
            }
            paramFromServiceMsg.printStackTrace();
          }
          if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0)) {
            break label560;
          }
          paramToServiceMsg = new HashMap();
          paramToServiceMsg.put("param_FailCode", "12008");
          paramToServiceMsg.put("fail_step", "pkg32rs_null");
          paramToServiceMsg.put("fail_location", "SubBind");
          anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBUnbindProtol", false, 0L, 0L, paramToServiceMsg, "");
          localanxs.errorType = 1001;
          notifyUI(1, false, localanxs);
          if (!QLog.isColorLevel()) {
            break label1496;
          }
          QLog.d("SUB_ACCOUNT", 2, "handlerUnBindSubAccount() !pkg.hasUint32Result() || pkg.getUint32Result() != 0");
          return;
          if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
            break label674;
          }
          paramToServiceMsg = new HashMap();
          paramToServiceMsg.put("param_FailCode", "12008");
          paramToServiceMsg.put("fail_step", "bytebody_null");
          paramToServiceMsg.put("fail_location", "SubBind");
          anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBUnbindProtol", false, 0L, 0L, paramToServiceMsg, "");
          localanxs.errorType = 1000;
          notifyUI(1, false, localanxs);
          if (!QLog.isColorLevel()) {
            break label1496;
          }
          QLog.d("SUB_ACCOUNT", 2, "handlerUnBindSubAccount() !pkg.hasBytesBodybuffer() || pkg.getBytesBodybuffer() == null");
          return;
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
                QLog.d("SUB_ACCOUNT", 2, "handlerUnBindSubAccount() oidb_0x7a1 parseFrom byte InvalidProtocolBufferMicroException");
              }
              paramFromServiceMsg.printStackTrace();
            }
            i = paramToServiceMsg.uint32_result.get();
            localanxs.serverErrorType = i;
            localanxs.errorMsg = paramToServiceMsg.str_errmsg.get();
            if (!QLog.isColorLevel()) {
              break label1497;
            }
          }
          if (paramToServiceMsg != null) {
            break label824;
          }
          paramToServiceMsg = new HashMap();
          paramToServiceMsg.put("param_FailCode", "12012");
          paramToServiceMsg.put("fail_step", "rsp_null");
          paramToServiceMsg.put("fail_location", "SubBind");
          anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBUnbindProtol", false, 0L, 0L, paramToServiceMsg, "");
          localanxs.errorType = 1000;
          notifyUI(1, false, localanxs);
          if (!QLog.isColorLevel()) {
            break label1496;
          }
          QLog.d("SUB_ACCOUNT", 2, "handlerUnBindSubAccount() rsp == null");
          return;
          QLog.d("SUB_ACCOUNT", 2, "handlerUnBindSubAccount()  rspResult = " + i);
        }
        if (paramToServiceMsg == null)
        {
          paramToServiceMsg = new HashMap();
          paramToServiceMsg.put("param_FailCode", "12008");
          paramToServiceMsg.put("fail_step", "pkg_null");
          paramToServiceMsg.put("fail_location", "SubBind");
          anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBUnbindProtol", false, 0L, 0L, paramToServiceMsg, "");
          localanxs.errorType = 1000;
          notifyUI(1, false, localanxs);
          if (!QLog.isColorLevel()) {
            break label1496;
          }
          QLog.d("SUB_ACCOUNT", 2, "handlerUnBindSubAccount() pkg == null");
          return;
          paramToServiceMsg.printStackTrace();
          paramFromServiceMsg = new HashMap();
          paramFromServiceMsg.put("param_FailCode", "12013");
          paramFromServiceMsg.put("fail_step", "exception");
          paramFromServiceMsg.put("fail_location", "SubBind");
          anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBUnbindProtol", false, 0L, 0L, paramFromServiceMsg, "");
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount:   error e = " + paramToServiceMsg.getMessage());
            bool2 = bool1;
          }
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      label413:
      notifyUI(1, bool1, localanxs);
      return;
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            label560:
            label824:
            paramFromServiceMsg = new HashMap();
            label674:
            paramFromServiceMsg.put("param_FailCode", "12011");
            paramFromServiceMsg.put("fail_step", "rspResult_" + i);
            paramFromServiceMsg.put("fail_location", "SubBind");
            anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBUnbindProtol", false, 0L, 0L, paramFromServiceMsg, "");
            if ((i != 1200) && (i != 1214) && (i != 1215) && (i != 1218) && (i != 1232) && (i != 1233) && (i != 1240) && (i != 1241) && (i != 1242)) {
              break label1240;
            }
            paramToServiceMsg = String.valueOf(paramToServiceMsg.uint64_err_uin.get());
            if ((str1 == null) || (!paramToServiceMsg.equalsIgnoreCase(str1))) {
              break label1174;
            }
            if (!QLog.isColorLevel()) {
              break label1535;
            }
            QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount: server error happen subaccount a2 error? not it is not happan");
            break label1535;
            paramToServiceMsg = new HashMap();
            paramToServiceMsg.put("param_FailCode", "12009");
            paramToServiceMsg.put("fail_step", "rspResult_0");
            paramToServiceMsg.put("fail_location", "SubBind");
            anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBUnbindProtol", true, 0L, 0L, paramToServiceMsg, "");
            bool1 = true;
            try
            {
              localanxs.errorType = 0;
              anxk.aJ(this.app, str1);
            }
            catch (Exception paramToServiceMsg)
            {
              bool1 = true;
            }
          }
          break;
          label1174:
          if ((str2 != null) && (str2.equalsIgnoreCase(paramToServiceMsg)))
          {
            localanxs.errorType = 1005;
            if (!QLog.isColorLevel()) {
              break label1535;
            }
            QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount: ERRORTYPE_MAINACCOUNT_A2_ERROR");
            break label1535;
          }
          localanxs.errorType = 1000;
          if (!QLog.isColorLevel()) {
            break label1535;
          }
          QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount: ERRORTYPE_UNKNOW");
          break label1535;
          label1240:
          localanxs.errorType = 1000;
          if (QLog.isColorLevel()) {
            QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount: ERRORTYPE_UNKNOW");
          }
          bool1 = false;
          break label413;
          boolean bool3 = false;
          bool1 = false;
          if ((i == 1002) || (i == 1013)) {}
          try
          {
            paramToServiceMsg = new HashMap();
            paramToServiceMsg.put("param_FailCode", "12010");
            paramToServiceMsg.put("fail_step", "timeout");
            paramToServiceMsg.put("fail_location", "SubBind");
            anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBUnbindProtol", false, 0L, 0L, paramToServiceMsg, "");
            localanxs.errorType = 1007;
            bool2 = bool3;
            if (!QLog.isColorLevel()) {
              break label409;
            }
            QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount: ERRORTYPE_SERVER_TIMEOUT");
            bool1 = false;
          }
          catch (Exception paramToServiceMsg) {}
        }
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12012");
        paramToServiceMsg.put("fail_step", "error");
        paramToServiceMsg.put("fail_location", "SubBind");
        anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBUnbindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localanxs.errorType = 1000;
        bool2 = bool3;
        if (!QLog.isColorLevel()) {
          break label409;
        }
        QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount: ERRORTYPE_UNKNOW last");
        bool2 = bool3;
        break label409;
        break label301;
        str2 = null;
        str1 = null;
        break;
        label1496:
        return;
        label1497:
        switch (i)
        {
        }
      }
      label1535:
      bool1 = false;
    }
  }
  
  private void fT(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount:");
    }
    anxs localanxs = new anxs();
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    try
    {
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("param_FailCode", "12007");
      paramToServiceMsg.put("fail_step", "req_null");
      paramToServiceMsg.put("fail_location", "SubBind");
      anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBGetbindProtol", false, 0L, 0L, paramToServiceMsg, "");
      localanxs.errorType = 1000;
      notifyUI(2, false, localanxs);
      if (!QLog.isColorLevel()) {
        break label2103;
      }
      QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount: req == null || resp == null");
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      bool1 = false;
      i = 1;
    }
    int i = paramFromServiceMsg.getResultCode();
    localanxs.aLa = paramToServiceMsg.getUin();
    boolean bool1;
    int j;
    boolean bool2;
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
          paramFromServiceMsg.printStackTrace();
        }
        if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0)) {
          break label531;
        }
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12008");
        paramToServiceMsg.put("fail_step", "pkguint32_null");
        paramToServiceMsg.put("fail_location", "SubBind");
        anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBGetbindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localanxs.errorType = 1001;
        notifyUI(2, false, localanxs);
        if (!QLog.isColorLevel()) {
          break label2103;
        }
        QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount: !pkg.hasUint32Result() || pkg.getUint32Result() != 0");
        return;
        label531:
        if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
          break label645;
        }
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12008");
        paramToServiceMsg.put("fail_step", "bytebody_null");
        paramToServiceMsg.put("fail_location", "SubBind");
        anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBGetbindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localanxs.errorType = 1000;
        notifyUI(2, false, localanxs);
        if (!QLog.isColorLevel()) {
          break label2103;
        }
        QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount: !pkg.hasBytesBodybuffer() || pkg.getBytesBodybuffer() == null");
        return;
        label645:
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
              QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount: parseFrom byte InvalidProtocolBufferMicroException ");
            }
            paramFromServiceMsg.printStackTrace();
          }
          i = paramToServiceMsg.uint32_result.get();
          localanxs.serverErrorType = i;
          localanxs.errorMsg = paramToServiceMsg.str_errmsg.get();
          switch (i)
          {
          }
        }
        if (paramToServiceMsg != null) {
          break label796;
        }
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12012");
        paramToServiceMsg.put("fail_step", "bytebody_null");
        paramToServiceMsg.put("fail_location", "SubBind");
        anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBGetbindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localanxs.errorType = 1000;
        notifyUI(2, false, localanxs);
        if (!QLog.isColorLevel()) {
          break label2103;
        }
        QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount: rsp == null");
        return;
      }
      if (paramToServiceMsg == null)
      {
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12008");
        paramToServiceMsg.put("fail_step", "pkg_null");
        paramToServiceMsg.put("fail_location", "SubBind");
        anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBGetbindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localanxs.errorType = 1000;
        notifyUI(2, false, localanxs);
        if (QLog.isColorLevel())
        {
          QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount: pkg == null");
          return;
          paramFromServiceMsg = new HashMap();
          paramFromServiceMsg.put("param_FailCode", "12013");
          paramFromServiceMsg.put("fail_step", "exception");
          paramFromServiceMsg.put("fail_location", "SubBind");
          anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBGetbindProtol", false, 0L, 0L, paramFromServiceMsg, "");
          paramToServiceMsg.printStackTrace();
          j = i;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.e("SUB_ACCOUNT", 2, "handlerGetBindSubAccount: exception happen e = " + paramToServiceMsg.getMessage());
            bool2 = bool1;
            j = i;
          }
          if (j != 0) {
            notifyUI(2, bool2, localanxs);
          }
        }
      }
      else
      {
        label796:
        label844:
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12011");
        paramToServiceMsg.put("fail_step", "rspResult_" + i);
        paramToServiceMsg.put("fail_location", "SubBind");
        anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBGetbindProtol", false, 0L, 0L, paramToServiceMsg, "");
        if ((i == 1200) || (i == 1214) || (i == 1215) || (i == 1218) || (i == 1232) || (i == 1233) || (i == 1240) || (i == 1241) || (i == 1242))
        {
          localanxs.errorType = 1005;
          if (!QLog.isColorLevel()) {
            break label2128;
          }
          QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount: get main account a2 error rspResult = " + i);
          i = 1;
          bool1 = false;
          break label2107;
          paramFromServiceMsg = new HashMap();
          paramFromServiceMsg.put("param_FailCode", "12009");
          paramFromServiceMsg.put("fail_step", "success_0");
          paramFromServiceMsg.put("fail_location", "SubBind");
          anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBGetbindProtol", true, 0L, 0L, paramFromServiceMsg, "");
          paramFromServiceMsg = (anxr)this.app.getManager(61);
          paramObject = paramFromServiceMsg.dK();
        }
      }
    }
    for (;;)
    {
      try
      {
        localanxs.errorType = 0;
        localanxs.a(paramToServiceMsg, paramObject);
        paramObject = localanxs.dN();
        if ((paramObject != null) && (paramObject.size() > 0))
        {
          paramToServiceMsg = (anxk)this.app.getManager(62);
          paramObject = paramObject.iterator();
          if (paramObject.hasNext())
          {
            paramToServiceMsg.a((String)paramObject.next(), 1);
            continue;
          }
        }
        String str;
        if (localanxs.azm())
        {
          paramFromServiceMsg.a(localanxs);
          paramToServiceMsg = localanxs.dM();
          if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
          {
            paramObject = paramToServiceMsg.iterator();
            if (paramObject.hasNext())
            {
              str = (String)paramObject.next();
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount() hint is new,msg num=1, subUin=" + str);
              }
              i = 1 - this.app.a().A(str, 7000);
              if (i == 0) {
                continue;
              }
              this.app.a().G(str, 7000, i);
              continue;
            }
          }
          paramObject = localanxs.Bc.iterator();
          i = 1;
        }
        try
        {
          if (paramObject.hasNext())
          {
            str = (String)paramObject.next();
            bool2 = paramToServiceMsg.contains(str);
            bool1 = false;
            localObject = anxk.b(this.app, str);
            if (localObject != null) {
              bool1 = ((Boolean)((Pair)localObject).second).booleanValue();
            }
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount() subUin=" + str + " isLogin = " + bool1);
            }
            if (bool1) {
              paramFromServiceMsg.am(str, 1);
            }
          }
        }
        catch (Exception paramToServiceMsg)
        {
          Object localObject;
          bool1 = true;
        }
        try
        {
          localObject = anxs.a(localanxs);
          ((anxs)localObject).aQf = str;
          this.app.getSubAccountKey(this.app.getAccount(), ((anxs)localObject).aQf, new acme(this, (anxs)localObject, paramFromServiceMsg, bool2));
          i = 0;
        }
        catch (Exception paramToServiceMsg)
        {
          i = 0;
          bool1 = true;
        }
        if (paramFromServiceMsg.am(str, 2))
        {
          j = 1 - this.app.a().A(str, 7000);
          if (j != 0)
          {
            this.app.a().G(str, 7000, j);
            this.app.b().as(new String[] { acbn.bku, str });
          }
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount() hint need to verify,msg num=1, subUin=" + str);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount, has subaccount but islogin is false");
        }
        paramFromServiceMsg.R(str, null, bool2);
        continue;
        bool1 = true;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount, not has subaccount");
        }
        localanxs.errorType = 1008;
        anxk.aJ(this.app, "sub.uin.all");
        i = 1;
        bool1 = true;
        continue;
        localanxs.errorType = 1000;
        localanxs.cKA = true;
        if (!QLog.isColorLevel()) {
          break label2128;
        }
        QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount: get main account error rspResult = " + i);
        break label2128;
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12010");
        paramToServiceMsg.put("fail_step", "timeout");
        paramToServiceMsg.put("fail_location", "SubBind");
        anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBGetbindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localanxs.errorType = 1007;
        if (QLog.isColorLevel()) {
          QLog.e("SUB_ACCOUNT", 2, "handlerGetBindSubAccount: timeout");
        }
        localanxs.cKA = true;
        break label2128;
        if (i == 2901)
        {
          i = paramToServiceMsg.extraData.getInt("fastResendCount", 0);
          paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("request_ByteArray");
          paramFromServiceMsg = createToServiceMsg("OidbSvc.0x7a2_0");
          if (i + 1 < 3)
          {
            paramFromServiceMsg.setEnableFastResend(true);
            paramFromServiceMsg.extraData.putInt("fastResendCount", i + 1);
            paramFromServiceMsg.extraData.putByteArray("request_ByteArray", paramToServiceMsg);
          }
          paramFromServiceMsg.putWupBuffer(paramToServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount() result==2901, resend count=" + i + " setFastResend=" + paramFromServiceMsg.isFastResendEnabled());
          }
          sendPbReq(paramFromServiceMsg);
          return;
        }
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("param_FailCode", "12012");
        paramToServiceMsg.put("fail_step", "result_" + i);
        paramToServiceMsg.put("fail_location", "SubBind");
        anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actSBGetbindProtol", false, 0L, 0L, paramToServiceMsg, "");
        localanxs.errorType = 1000;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SUB_ACCOUNT", 2, "handlerGetBindSubAccount: ERRORTYPE_UNKNOW last");
        continue;
        break;
        break;
        label2103:
        return;
        break label844;
        label2107:
        j = i;
        bool2 = bool1;
      }
      catch (Exception paramToServiceMsg)
      {
        i = 1;
        bool1 = true;
      }
      break;
      label2128:
      i = 1;
      bool1 = false;
      continue;
      if (i != 1002) {
        if (i != 1013) {}
      }
    }
  }
  
  public void ER(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "unBindSubAccount: start");
    }
    Object localObject1 = new oidb_0x7a1.ReqBody();
    ((oidb_0x7a1.ReqBody)localObject1).uint32_flag.set(1);
    Object localObject2 = aqgz.getIMEI();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((oidb_0x7a1.ReqBody)localObject1).str_imei.set((String)localObject2);
    }
    ((oidb_0x7a1.ReqBody)localObject1).uint64_bind_uin.set(Long.parseLong(paramString));
    ((oidb_0x7a1.ReqBody)localObject1).uint32_clt_appid.set(this.app.getAppid());
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1953);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x7a1.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0x7a1_0");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("subAccount", paramString);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void at(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "bindSubAccount() start");
    }
    oidb_0x7a0.LoginSig localLoginSig = new oidb_0x7a0.LoginSig();
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramString2 != null) {}
    try
    {
      localObject1 = aqoj.ag(paramString2);
      if (localObject1 != null) {
        localLoginSig.bytes_sig.set(ByteStringMicro.copyFrom((byte[])localObject1));
      }
      localLoginSig.uint32_type.set(8);
      localLoginSig.uint32_appid.set(16);
      localObject1 = new oidb_0x7a0.ReqBody();
      ((oidb_0x7a0.ReqBody)localObject1).uint32_flag.set(1);
      ((oidb_0x7a0.ReqBody)localObject1).msg_bind_uin_sig.set(localLoginSig);
      localObject3 = aqgz.getIMEI();
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((oidb_0x7a0.ReqBody)localObject1).str_imei.set((String)localObject3);
      }
      ((oidb_0x7a0.ReqBody)localObject1).uint64_bind_uin.set(Long.parseLong(paramString1));
      ((oidb_0x7a0.ReqBody)localObject1).uint32_clt_appid.set(this.app.getAppid());
      localObject3 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject3).uint32_command.set(1952);
      ((oidb_sso.OIDBSSOPkg)localObject3).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject3).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x7a0.ReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg("OidbSvc.0x7a0_0");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject3).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("subAccount", paramString1);
      ((ToServiceMsg)localObject1).extraData.putString("subaccount_a2", paramString2);
      if (paramString3 != null) {
        ((ToServiceMsg)localObject1).extraData.putString("fromWhere", paramString3);
      }
      sendPbReq((ToServiceMsg)localObject1);
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
  
  public void cMB()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getBindSubAccount: start");
    }
    Object localObject1 = new oidb_0x7a2.ReqBody();
    ((oidb_0x7a2.ReqBody)localObject1).uint32_flag.set(1);
    Object localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1954);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x7a2.ReqBody)localObject1).toByteArray()));
    localObject1 = ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray();
    localObject2 = createToServiceMsg("OidbSvc.0x7a2_0");
    ((ToServiceMsg)localObject2).setEnableFastResend(true);
    ((ToServiceMsg)localObject2).extraData.putInt("fastResendCount", 0);
    ((ToServiceMsg)localObject2).extraData.putByteArray("request_ByteArray", (byte[])localObject1);
    ((ToServiceMsg)localObject2).putWupBuffer((byte[])localObject1);
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return acmf.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ((str == null) || (str.length() == 0)) {}
    do
    {
      return;
      if ("OidbSvc.0x7a0_0".equalsIgnoreCase(str))
      {
        fR(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7a1_0".equalsIgnoreCase(str))
      {
        fS(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x7a2_0".equalsIgnoreCase(str));
    try
    {
      fT(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    catch (VerifyError paramToServiceMsg)
    {
      QLog.e("SUB_ACCOUNT", 2, "handlerGetBindSubAccount VerifyError: " + paramToServiceMsg.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acmd
 * JD-Core Version:    0.7.0.1
 */