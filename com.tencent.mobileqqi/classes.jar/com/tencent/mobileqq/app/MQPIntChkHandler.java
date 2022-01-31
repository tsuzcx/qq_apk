package com.tencent.mobileqq.app;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ims.intchk.AppInfo;
import com.tencent.ims.intchk.CheckItem;
import com.tencent.ims.intchk.CheckResult;
import com.tencent.ims.intchk.FetchCheckConfigReq;
import com.tencent.ims.intchk.FetchCheckConfigRsp;
import com.tencent.ims.intchk.ReportCheckResultReq;
import com.tencent.ims.intchk.ReportCheckResultRsp;
import com.tencent.ims.intchk.ReportStrikeResultReq;
import com.tencent.ims.intchk.ReqBody;
import com.tencent.ims.intchk.RspBody;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mqp.app.intchk.IntChkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fhv;
import fhw;
import fhx;
import fhy;
import fhz;
import java.io.ByteArrayInputStream;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MQPIntChkHandler
  extends BusinessHandler
{
  public static final String a = "IntChk";
  private static final int e = 1;
  private static final int f = 2;
  private static final int g = 3;
  private static final int h = 3;
  private static final int i = 5;
  private static final int j = 6;
  private static final int k = 7;
  private static final int l = 8;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int = 65535;
  private String jdField_c_of_type_JavaLangString = "QQ";
  private int d = 0;
  
  MQPIntChkHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private intchk.AppInfo a()
  {
    int n = 5;
    intchk.AppInfo localAppInfo = new intchk.AppInfo();
    localAppInfo.uint32_platform_type.set(1);
    String str = BaseApplication.getContext().getPackageName();
    localAppInfo.bytes_package_name.set(ByteStringMicro.copyFromUtf8(str));
    localAppInfo.bytes_app_version.set(ByteStringMicro.copyFromUtf8("6.0.1.25030"));
    localAppInfo.uint32_intchk_module_version.set(IntChkUtil.jdField_a_of_type_Int);
    int m = n;
    switch (NetworkCenter.a().a())
    {
    default: 
      m = n;
    }
    for (;;)
    {
      str = NetworkCenter.a().a();
      n = m;
      if (str != null)
      {
        n = m;
        if (str.contains("wap")) {
          n = 4;
        }
      }
      localAppInfo.uint32_net_type.set(n);
      return localAppInfo;
      m = 3;
      continue;
      m = 6;
      continue;
      m = 7;
    }
  }
  
  private void a(DialogInterface paramDialogInterface, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1) {
      this.d = 1;
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      b();
      if ((paramInt2 == 2) || (paramInt2 == 3) || (paramInt2 == 6) || (paramInt2 == 8)) {
        d();
      }
      return;
      if (paramInt2 == 2) {
        this.d = 2;
      } else if ((paramInt2 == 3) || (paramInt2 == 3)) {
        e();
      } else if ((paramInt2 == 5) || (paramInt2 == 6)) {
        f();
      } else if ((paramInt2 == 7) || (paramInt2 == 8)) {
        g();
      } else {
        this.d = 65535;
      }
    }
  }
  
  private void a(intchk.RspBody paramRspBody)
  {
    if (paramRspBody.uint32_result.has()) {}
    for (int m = paramRspBody.uint32_result.get();; m = 2)
    {
      if (m != 1) {
        if (QLog.isDevelopLevel()) {
          QLog.d("IntChk", 4, "ret result is not OK");
        }
      }
      do
      {
        return;
        if (paramRspBody.msg_check_config_rsp.has()) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("IntChk", 4, "no rsp body");
      return;
      paramRspBody = (intchk.FetchCheckConfigRsp)paramRspBody.msg_check_config_rsp.get();
      if (paramRspBody.uint32_need_intchk.has()) {
        if (QLog.isDevelopLevel()) {
          QLog.d("IntChk", 4, "update need check value");
        }
      }
      for (m = paramRspBody.uint32_need_intchk.get();; m = 2)
      {
        if (m != 1)
        {
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d("IntChk", 4, "do not need intck");
          return;
        }
        if (!paramRspBody.rpt_msg_check_item.has())
        {
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d("IntChk", 4, "no intchk items");
          return;
        }
        if (paramRspBody.uint32_intchk_id.has()) {}
        for (m = paramRspBody.uint32_intchk_id.get();; m = 0)
        {
          intchk.ReportCheckResultReq localReportCheckResultReq = new intchk.ReportCheckResultReq();
          localReportCheckResultReq.uint32_intchk_id.set(m);
          List localList = paramRspBody.rpt_msg_check_item.get();
          m = 0;
          if (m < localList.size())
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("IntChk", 4, "item:" + Integer.toString(m));
            }
            paramRspBody = (intchk.CheckItem)localList.get(m);
            if (!paramRspBody.uint32_check_item_id.has()) {
              break label602;
            }
          }
          label602:
          for (int n = paramRspBody.uint32_check_item_id.get();; n = 0)
          {
            if (paramRspBody.uint32_check_type.has()) {}
            for (int i1 = paramRspBody.uint32_check_type.get();; i1 = 1)
            {
              intchk.CheckResult localCheckResult = new intchk.CheckResult();
              localCheckResult.uint32_check_item_id.set(n);
              localCheckResult.uint32_check_type.set(i1);
              switch (i1)
              {
              }
              for (;;)
              {
                localReportCheckResultReq.rpt_msg_check_result.add(localCheckResult);
                m += 1;
                break;
                if (QLog.isDevelopLevel()) {
                  QLog.d("IntChk", 4, "MEM_CHECK");
                }
                if (a(paramRspBody)) {}
                for (n = 1;; n = 2)
                {
                  if (QLog.isDevelopLevel()) {
                    QLog.d("IntChk", 4, "MEM_CHECK_RESULT:" + Integer.toString(n));
                  }
                  localCheckResult.uint32_memchk_result.set(n);
                  break;
                }
                if (QLog.isDevelopLevel()) {
                  QLog.d("IntChk", 4, "MEM_REPORT");
                }
                localObject = HexUtil.a(a(paramRspBody));
                paramRspBody = (intchk.RspBody)localObject;
                if (localObject == null) {
                  paramRspBody = "";
                }
                if (QLog.isDevelopLevel()) {
                  QLog.d("IntChk", 4, "MEM_REPORT_CONTENT:" + paramRspBody);
                }
                localCheckResult.bytes_memreport_result.set(ByteStringMicro.copyFromUtf8(paramRspBody));
              }
              if (QLog.isDevelopLevel()) {
                QLog.d("IntChk", 4, "start report check result.");
              }
              paramRspBody = new intchk.ReqBody();
              paramRspBody.uint32_subcmd.set(2);
              paramRspBody.msg_app_info.set(a());
              paramRspBody.msg_report_check_result_req.set(localReportCheckResultReq);
              Object localObject = a("SecIntChkSvc.MainCmd");
              ((ToServiceMsg)localObject).putWupBuffer(paramRspBody.toByteArray());
              b((ToServiceMsg)localObject);
              return;
            }
          }
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString.trim()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("IntChk", 4, "strike config is empty");
      }
      return;
    }
    Object localObject = DocumentBuilderFactory.newInstance();
    try
    {
      paramString = ((DocumentBuilderFactory)localObject).newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes())).getDocumentElement();
      this.jdField_c_of_type_Int = 0;
      localObject = paramString.getAttribute("type");
      if (((String)localObject).trim().length() > 0) {
        this.jdField_c_of_type_Int = Integer.parseInt((String)localObject);
      }
      switch (this.jdField_c_of_type_Int)
      {
      case 1: 
        a(paramString);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("IntChk", 4, "exception occurred." + paramString.getMessage());
      }
      paramString.printStackTrace();
      return;
    }
    b(paramString);
    return;
    c(paramString);
    return;
  }
  
  private void a(Element paramElement)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IntChk", 4, "onShowToast");
    }
    if (paramElement == null) {
      if (QLog.isDevelopLevel()) {
        QLog.d("IntChk", 4, "elemStrike is null");
      }
    }
    String str3;
    do
    {
      do
      {
        do
        {
          return;
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.d("IntChk", 4, "toast already shown");
        return;
        localObject = paramElement.getElementsByTagName("title");
        if (((NodeList)localObject).getLength() != 0) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("IntChk", 4, "no title element.");
      return;
      str3 = ((Element)((NodeList)localObject).item(0)).getAttribute("val");
      localObject = paramElement.getElementsByTagName("wording");
      if (((NodeList)localObject).getLength() != 0) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("IntChk", 4, "no wording element.");
    return;
    String str4 = ((Element)((NodeList)localObject).item(0)).getAttribute("val");
    Object localObject = paramElement.getElementsByTagName("package_url");
    if (((NodeList)localObject).getLength() != 0) {
      this.jdField_b_of_type_JavaLangString = ((Element)((NodeList)localObject).item(0)).getAttribute("val");
    }
    localObject = paramElement.getElementsByTagName("package_name");
    if (((NodeList)localObject).getLength() != 0) {
      this.jdField_c_of_type_JavaLangString = ((Element)((NodeList)localObject).item(0)).getAttribute("val");
    }
    localObject = paramElement.getElementsByTagName("network_types");
    if (((NodeList)localObject).getLength() != 0)
    {
      this.jdField_a_of_type_Int = Integer.parseInt(((Element)((NodeList)localObject).item(0)).getAttribute("val"));
      if (this.jdField_a_of_type_Int >= 3) {
        this.jdField_a_of_type_Int = 0;
      }
    }
    String str1 = "";
    localObject = paramElement.getElementsByTagName("btn_confirm");
    if (((NodeList)localObject).getLength() > 0)
    {
      localObject = (Element)((NodeList)localObject).item(0);
      str1 = ((Element)localObject).getAttribute("text");
    }
    for (localObject = new fhv(this, Integer.parseInt(((Element)localObject).getAttribute("action")));; localObject = null)
    {
      String str2 = "";
      paramElement = paramElement.getElementsByTagName("btn_cancel");
      if (paramElement.getLength() > 0)
      {
        paramElement = (Element)paramElement.item(0);
        str2 = paramElement.getAttribute("text");
      }
      for (paramElement = new fhw(this, Integer.parseInt(paramElement.getAttribute("action")));; paramElement = null)
      {
        fhx localfhx = new fhx(this);
        if (QLog.isDevelopLevel()) {
          QLog.d("IntChk", 4, "start create toast.");
        }
        new Handler(Looper.getMainLooper()).post(new fhy(this, str3, str4, (DialogInterface.OnClickListener)localObject, paramElement, str2, str1, localfhx));
        return;
      }
    }
  }
  
  private boolean a(intchk.CheckItem paramCheckItem)
  {
    if (paramCheckItem.uint32_start_offset.has()) {}
    for (int m = paramCheckItem.uint32_start_offset.get();; m = 0)
    {
      if (paramCheckItem.uint32_end_offset.has()) {}
      for (int n = paramCheckItem.uint32_end_offset.get();; n = 0)
      {
        if (n <= m) {
          if (QLog.isDevelopLevel()) {
            QLog.d("IntChk", 4, "MEMCHECK: nEndOffset <= nStartOffset");
          }
        }
        do
        {
          String str1;
          String str2;
          do
          {
            do
            {
              return false;
              str1 = "";
              if (paramCheckItem.bytes_module_name.has()) {
                str1 = paramCheckItem.bytes_module_name.get().toStringUtf8();
              }
              if (!TextUtils.isEmpty(str1.trim())) {
                break;
              }
            } while (!QLog.isDevelopLevel());
            QLog.d("IntChk", 4, "MEMCHECK: module name is empty");
            return false;
            str2 = "";
            if (paramCheckItem.bytes_match_pattern.has()) {
              str2 = paramCheckItem.bytes_match_pattern.get().toStringUtf8();
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("IntChk", 4, "MEMCHK: start:" + Integer.toString(m) + " end:" + Integer.toString(n) + "module:" + str1 + "pattern:" + str2);
            }
            if (!TextUtils.isEmpty(str2.trim())) {
              break;
            }
          } while (!QLog.isDevelopLevel());
          QLog.d("IntChk", 4, "MEMCHK: not specified match pattern");
          return false;
          try
          {
            boolean bool = IntChkUtil.memchk(str1, m, n, HexUtil.a(str2));
            return bool;
          }
          catch (Throwable paramCheckItem) {}
        } while (!QLog.isDevelopLevel());
        QLog.d("IntChk", 4, "MEMCHK: native method not found");
        return false;
      }
    }
  }
  
  private byte[] a(intchk.CheckItem paramCheckItem)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IntChk", 4, "MEMRPT: onMemReport");
    }
    if (paramCheckItem.uint32_start_offset.has()) {}
    for (int m = paramCheckItem.uint32_start_offset.get();; m = 0)
    {
      if (paramCheckItem.uint32_end_offset.has()) {}
      for (int n = paramCheckItem.uint32_end_offset.get();; n = 0)
      {
        if (n <= m) {
          if (QLog.isDevelopLevel()) {
            QLog.d("IntChk", 4, "MEMRPT: nEndOffset <= nStartOffset");
          }
        }
        String str;
        do
        {
          return null;
          str = "";
          if (paramCheckItem.bytes_module_name.has()) {
            str = paramCheckItem.bytes_module_name.get().toStringUtf8();
          }
          if (!TextUtils.isEmpty(str.trim())) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.d("IntChk", 4, "MEMRPT: module name is empty");
        return null;
        try
        {
          paramCheckItem = IntChkUtil.memreport(str, m, n);
          return paramCheckItem;
        }
        catch (Throwable paramCheckItem)
        {
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("IntChk", 4, "MEMRPT: native method not found");
            }
            paramCheckItem = null;
          }
        }
      }
    }
  }
  
  private void b()
  {
    Object localObject = new intchk.ReportStrikeResultReq();
    ((intchk.ReportStrikeResultReq)localObject).uint32_intchk_id.set(this.jdField_b_of_type_Int);
    ((intchk.ReportStrikeResultReq)localObject).uint32_strike_type.set(this.jdField_c_of_type_Int);
    ((intchk.ReportStrikeResultReq)localObject).uint32_strike_result.set(this.d);
    if (QLog.isDevelopLevel()) {
      QLog.d("IntChk", 4, "reportStrikeResult: strike_type(" + Integer.toString(this.jdField_c_of_type_Int) + ") strike_result(" + Integer.toString(this.d) + ")");
    }
    intchk.ReqBody localReqBody = new intchk.ReqBody();
    localReqBody.uint32_subcmd.set(3);
    localReqBody.msg_app_info.set(a());
    localReqBody.msg_report_strike_result_req.set((MessageMicro)localObject);
    localObject = a("SecIntChkSvc.MainCmd");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  private void b(intchk.RspBody paramRspBody)
  {
    int n = 2;
    if (paramRspBody.uint32_result.has()) {}
    for (int m = paramRspBody.uint32_result.get();; m = 2)
    {
      if (m != 1) {
        if (QLog.isDevelopLevel()) {
          QLog.d("IntChk", 4, "ret result is not OK");
        }
      }
      do
      {
        do
        {
          do
          {
            return;
            if (paramRspBody.msg_report_check_result_rsp.has()) {
              break;
            }
          } while (!QLog.isDevelopLevel());
          QLog.d("IntChk", 4, "no check result rsp");
          return;
          paramRspBody = (intchk.ReportCheckResultRsp)paramRspBody.msg_report_check_result_rsp.get();
          m = n;
          if (paramRspBody.uint32_need_strike.has())
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("IntChk", 4, "update need strike value");
            }
            m = paramRspBody.uint32_need_strike.get();
          }
          if (m == 1) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.d("IntChk", 4, "do not need strike");
        return;
        if (paramRspBody.bytes_strike_config.has()) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("IntChk", 4, "no strike config");
      return;
      if (paramRspBody.uint32_intchk_id.has()) {
        this.jdField_b_of_type_Int = paramRspBody.uint32_intchk_id.get();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("IntChk", 4, "start strike");
      }
      a(paramRspBody.bytes_strike_config.get().toStringUtf8());
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IntChk", 4, "to:" + HexUtil.a(paramToServiceMsg.getWupBuffer()));
    }
    paramToServiceMsg = new intchk.RspBody();
    int m;
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      m = 0;
      if (!paramToServiceMsg.uint32_subcmd.has()) {
        break label116;
      }
      m = paramToServiceMsg.uint32_subcmd.get();
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      if (!QLog.isColorLevel()) {
        break label105;
      }
      QLog.d("IntChk", 2, "onReceive: RspBody parseFrom byte InvalidProtocolBufferMicroException");
      paramToServiceMsg.printStackTrace();
      return;
    }
    a(paramToServiceMsg);
    return;
    label105:
    b(paramToServiceMsg);
    return;
    label116:
    switch (m)
    {
    }
  }
  
  private void b(Element paramElement)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IntChk", 4, "onExitApp");
    }
    this.d = 5;
    b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.k();
  }
  
  private void c(Element paramElement)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IntChk", 4, "onLaunchApp");
    }
    if (paramElement == null) {}
    do
    {
      return;
      paramElement = paramElement.getElementsByTagName("package");
    } while (paramElement.getLength() == 0);
    paramElement = ((Element)paramElement.item(0)).getAttribute("val");
    if (!PackageUtil.a(BaseApplication.getContext(), paramElement))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("IntChk", 4, "app not exist:" + paramElement);
      }
      this.d = 11;
      b();
      return;
    }
    if (PackageUtil.a(BaseApplication.getContext(), paramElement, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {}
    for (int m = 13;; m = 12)
    {
      this.d = m;
      break;
    }
  }
  
  private void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IntChk", 4, "logout.");
    }
    BaseActivity localBaseActivity = BaseActivity.a;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.logout(true);
    SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
    Intent localIntent = new Intent(localBaseActivity, LoginActivity.class);
    localIntent.addFlags(335544320);
    localBaseActivity.startActivity(localIntent);
  }
  
  private void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IntChk", 4, "jump to qqdownloader.");
    }
    try
    {
      Context localContext = BaseApplication.getContext();
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("tmast://appdetails?pname=" + localContext.getPackageName()));
      localIntent.setFlags(268435456);
      localContext.startActivity(localIntent);
      this.d = 4;
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("IntChk", 4, "qqdownloader not found.");
      }
      this.d = 3;
    }
  }
  
  private void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IntChk", 4, "jump to browser.");
    }
    try
    {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("IntChk", 4, "package URL not specified.");
        }
        this.d = 20;
        return;
      }
      Context localContext = BaseApplication.getContext();
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.jdField_b_of_type_JavaLangString));
      localIntent.setFlags(268435456);
      localContext.startActivity(localIntent);
      this.d = 22;
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("IntChk", 4, "jump to browser failed.");
      }
      this.d = 23;
    }
  }
  
  @SuppressLint({"NewApi"})
  private void g()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IntChk", 4, "use download manager.");
    }
    Object localObject = BaseApplication.getContext();
    DownloadManager localDownloadManager = (DownloadManager)((Context)localObject).getSystemService("download");
    if (localDownloadManager == null) {
      this.d = 30;
    }
    do
    {
      return;
      this.d = 31;
      IntentFilter localIntentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
      ((Context)localObject).registerReceiver(new fhz(this, localDownloadManager), localIntentFilter);
      try
      {
        localObject = new DownloadManager.Request(Uri.parse(this.jdField_b_of_type_JavaLangString));
        ((DownloadManager.Request)localObject).setTitle(this.jdField_c_of_type_JavaLangString);
        if (this.jdField_a_of_type_Int != 0) {
          ((DownloadManager.Request)localObject).setAllowedNetworkTypes(this.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_Long = localDownloadManager.enqueue((DownloadManager.Request)localObject);
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isDevelopLevel());
    QLog.d("IntChk", 4, "download error:" + localThrowable.getMessage());
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IntChk", 4, "startIntChk");
    }
    Object localObject = new intchk.FetchCheckConfigReq();
    ((intchk.FetchCheckConfigReq)localObject).uint32_reserved.set(0);
    intchk.ReqBody localReqBody = new intchk.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    localReqBody.msg_app_info.set(a());
    localReqBody.msg_check_config_req.set((MessageMicro)localObject);
    localObject = a("SecIntChkSvc.MainCmd");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {}
    while ((!paramFromServiceMsg.isSuccess()) || (!"SecIntChkSvc.MainCmd".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MQPIntChkHandler
 * JD-Core Version:    0.7.0.1
 */