package com.tencent.mobileqq.phonecontact;

import SecurityAccountServer.CompressedPackage;
import SecurityAccountServer.RequestBindMobile;
import SecurityAccountServer.RequestCancelBindMobile;
import SecurityAccountServer.RequestGetRecommendedListV2;
import SecurityAccountServer.RequestHeader;
import SecurityAccountServer.RequestQueryQQBindingStat;
import SecurityAccountServer.RequestQueryQQMobileContactsV2;
import SecurityAccountServer.RequestReBindMblWTLogin;
import SecurityAccountServer.RequestReBindMobile;
import SecurityAccountServer.RequestResendSmscode;
import SecurityAccountServer.RequestUpdateAddressBook;
import SecurityAccountServer.RequestUploadAddressBook;
import SecurityAccountServer.RequestVerifySmscode;
import SecurityAccountServer.RequestVerifyWTLogin;
import SecurityAccountServer.RespondHeader;
import SecurityAccountServer.RespondQueryQQBindingStat;
import SecurityAccountServer.ResponeBindMobile;
import SecurityAccountServer.ResponeQueryQQMobileContactsV2;
import SecurityAccountServer.ResponeReBindMobile;
import SecurityAccountServer.ResponeUpdateAddressBook;
import SecurityAccountServer.ResponeUploadAddressBook;
import SecurityAccountServer.ResponseReBindMblWTLogin;
import SecurityAccountServer.ResponseVerifyWTLogin;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.zip.InflaterInputStream;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

public class ContactBindServlet
  extends MSFServlet
{
  private static final int jdField_a_of_type_Int = 256;
  private static final String jdField_a_of_type_JavaLangString = "PhoneContact";
  private static final boolean jdField_a_of_type_Boolean = false;
  private PhoneContactManager jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private boolean b = false;
  private boolean c = false;
  
  public static RequestHeader a(int paramInt1, int paramInt2, int paramInt3)
  {
    RequestHeader localRequestHeader = new RequestHeader();
    localRequestHeader.ver = 100;
    localRequestHeader.cmd = paramInt1;
    localRequestHeader.requestID = paramInt2;
    localRequestHeader.svrSeqNo = paramInt3;
    localRequestHeader.account = "";
    localRequestHeader.appid = 0;
    localRequestHeader.sbid = "";
    localRequestHeader.channel_id = "";
    localRequestHeader.ksid = "";
    localRequestHeader.uin = 0L;
    return localRequestHeader;
  }
  
  private ResponeQueryQQMobileContactsV2 a(UniPacket paramUniPacket)
  {
    CompressedPackage localCompressedPackage = (CompressedPackage)paramUniPacket.getByClass("CompressedPackage", new CompressedPackage());
    if (localCompressedPackage != null)
    {
      ResponeQueryQQMobileContactsV2 localResponeQueryQQMobileContactsV2 = new ResponeQueryQQMobileContactsV2();
      if (localCompressedPackage.compressed) {}
      for (paramUniPacket = a(localCompressedPackage.buffer);; paramUniPacket = localCompressedPackage.buffer)
      {
        paramUniPacket = new JceInputStream(paramUniPacket);
        paramUniPacket.setServerEncoding("utf-8");
        localResponeQueryQQMobileContactsV2.readFrom(paramUniPacket);
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContactManager", 2, "getRspQueryContacts | compress != null | read from JceInputStream");
        }
        return localResponeQueryQQMobileContactsV2;
      }
    }
    return (ResponeQueryQQMobileContactsV2)paramUniPacket.getByClass("ResponeQueryQQMobileContactsV2", new ResponeQueryQQMobileContactsV2());
  }
  
  private UniPacket a(FromServiceMsg paramFromServiceMsg)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    localUniPacket.decode(paramFromServiceMsg.getWupBuffer());
    return localUniPacket;
  }
  
  private PhoneContactManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = ((PhoneContactManager)getAppRuntime().getManager(10));
    }
    return this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager;
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = false;
    Bundle localBundle = new Bundle();
    if (paramFromServiceMsg.isSuccess())
    {
      UniPacket localUniPacket = a(paramFromServiceMsg);
      RespondHeader localRespondHeader = (RespondHeader)localUniPacket.getByClass("RespondHeader", new RespondHeader());
      if (localRespondHeader == null)
      {
        notifyObserver(paramIntent, 26, false, localBundle, ContactBindObserver.class);
        return;
      }
      paramFromServiceMsg = null;
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "handleGetBindUinWithPhone respHeader.result =" + localRespondHeader.result);
      }
      boolean bool1;
      if (localRespondHeader.result == 107)
      {
        paramFromServiceMsg = String.valueOf(((ResponseVerifyWTLogin)localUniPacket.getByClass("ResponseVerifyWTLogin", new ResponseVerifyWTLogin())).preBindUin);
        bool1 = true;
      }
      for (;;)
      {
        localBundle.putBoolean("bindOK", bool2);
        localBundle.putBoolean("hadBind", bool1);
        localBundle.putString("bindUin", paramFromServiceMsg);
        notifyObserver(paramIntent, 26, true, localBundle, ContactBindObserver.class);
        return;
        if (localRespondHeader.result == 0)
        {
          bool1 = false;
          bool2 = true;
        }
        else
        {
          bool1 = false;
        }
      }
    }
    notifyObserver(paramIntent, 26, false, localBundle, ContactBindObserver.class);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 26);
    localNewIntent.putExtra("cmd_param_phone_bind_sign", paramArrayOfByte);
    localNewIntent.putExtra("cmd_param_phone_uin", paramString);
    localNewIntent.setWithouLogin(true);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      InflaterInputStream localInflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte2 = new byte[256];
      for (;;)
      {
        int i = localInflaterInputStream.read(arrayOfByte2);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte2, 0, i);
      }
      arrayOfByte1 = localThrowable.toByteArray();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return paramArrayOfByte;
    }
    byte[] arrayOfByte1;
    return arrayOfByte1;
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = false;
    Bundle localBundle = new Bundle();
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = a(paramFromServiceMsg);
      RespondHeader localRespondHeader = (RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader());
      if (localRespondHeader == null)
      {
        localBundle.putBoolean("bind_state", false);
        notifyObserver(paramIntent, 27, false, localBundle, ContactBindObserver.class);
        return;
      }
      if (localRespondHeader.result == 0)
      {
        paramFromServiceMsg = (ResponseReBindMblWTLogin)paramFromServiceMsg.getByClass("ResponseReBindMblWTLogin", new ResponseReBindMblWTLogin());
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact", 2, "handlerReBindMblWTLogin resp = " + paramFromServiceMsg.result);
        }
        bool = true;
      }
      localBundle.putBoolean("bind_state", bool);
      notifyObserver(paramIntent, 27, true, localBundle, ContactBindObserver.class);
      return;
    }
    localBundle.putBoolean("bind_state", false);
    notifyObserver(paramIntent, 27, false, localBundle, ContactBindObserver.class);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 27);
    localNewIntent.putExtra("cmd_param_phone_bind_sign", paramArrayOfByte);
    localNewIntent.putExtra("cmd_param_phone_uin", paramString);
    localNewIntent.setWithouLogin(true);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = a(paramFromServiceMsg);
      if (((RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader())).result == 105)
      {
        localBundle.putBoolean("bind_state", false);
        paramFromServiceMsg = null;
      }
      for (;;)
      {
        a().a(paramFromServiceMsg);
        notifyObserver(paramIntent, 12, true, localBundle, ContactBindObserver.class);
        return;
        paramFromServiceMsg = (RespondQueryQQBindingStat)paramFromServiceMsg.getByClass("RespondQueryQQBindingStat", new RespondQueryQQBindingStat());
        localBundle.putBoolean("bind_state", true);
      }
    }
    notifyObserver(paramIntent, 12, false, null, ContactBindObserver.class);
  }
  
  private void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      Object localObject = a(paramFromServiceMsg);
      paramFromServiceMsg = (RespondHeader)((UniPacket)localObject).getByClass("RespondHeader", new RespondHeader());
      localObject = (ResponeBindMobile)((UniPacket)localObject).getByClass("ResponeBindMobile", new ResponeBindMobile());
      a().a(((ResponeBindMobile)localObject).sessionSid);
      Bundle localBundle = new Bundle();
      localBundle.putInt("k_result", paramFromServiceMsg.result);
      if (paramFromServiceMsg.result == 107) {
        localBundle.putString("k_uin", ((ResponeBindMobile)localObject).alreadyBindedUin);
      }
      for (;;)
      {
        notifyObserver(paramIntent, 13, true, localBundle, ContactBindObserver.class);
        return;
        if (paramFromServiceMsg.result == 106) {
          localBundle.putString("k_uin", "");
        }
      }
    }
    notifyObserver(paramIntent, 13, false, null, ContactBindObserver.class);
  }
  
  private void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      Object localObject = a(paramFromServiceMsg);
      paramFromServiceMsg = (RespondHeader)((UniPacket)localObject).getByClass("RespondHeader", new RespondHeader());
      localObject = (ResponeReBindMobile)((UniPacket)localObject).getByClass("ResponeReBindMobile", new ResponeReBindMobile());
      a().a(((ResponeReBindMobile)localObject).sessionSid);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("k_result", paramFromServiceMsg.result);
      if ((paramFromServiceMsg.result == 0) || (paramFromServiceMsg.result == 104))
      {
        notifyObserver(paramIntent, 19, true, (Bundle)localObject, ContactBindObserver.class);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "BindNumberBusiness  rebind failed ,返回码不正确");
      }
      notifyObserver(paramIntent, 19, false, (Bundle)localObject, ContactBindObserver.class);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "BindNumberBusiness  rebind failed ,response isSuccess = false");
    }
    notifyObserver(paramIntent, 19, false, null, ContactBindObserver.class);
  }
  
  private void f(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RespondHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespondHeader", new RespondHeader());
      if ((paramFromServiceMsg.result == 0) || (paramFromServiceMsg.result == 105))
      {
        a().a(null);
        a().g();
        notifyObserver(paramIntent, 20, true, null, ContactBindObserver.class);
        return;
      }
      notifyObserver(paramIntent, 20, false, null, ContactBindObserver.class);
      return;
    }
    notifyObserver(paramIntent, 20, false, null, ContactBindObserver.class);
  }
  
  private void g(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RespondHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespondHeader", new RespondHeader());
      Bundle localBundle = new Bundle();
      localBundle.putInt("k_result", paramFromServiceMsg.result);
      notifyObserver(paramIntent, 16, true, localBundle, ContactBindObserver.class);
      return;
    }
    notifyObserver(paramIntent, 16, false, null, ContactBindObserver.class);
  }
  
  private void h(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = paramIntent.getExtras();
    int k = localBundle.getInt("upload_package_no");
    Object localObject = localBundle.getString("unique_phone_no");
    NewIntent localNewIntent = new NewIntent(getAppRuntime().getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 14);
    localNewIntent.putExtra("unique_phone_no", (String)localObject);
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = a(paramFromServiceMsg);
      localObject = (RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader());
      paramFromServiceMsg = (ResponeUploadAddressBook)paramFromServiceMsg.getByClass("ResponeUploadAddressBook", new ResponeUploadAddressBook());
      if (((RespondHeader)localObject).result == 0)
      {
        localObject = (ArrayList)localBundle.getSerializable("contact_list");
        int m = k * 50;
        int j = m + 50;
        int i = j;
        if (j > ((ArrayList)localObject).size()) {
          i = ((ArrayList)localObject).size();
        }
        localObject = ((ArrayList)localObject).subList(m, i);
        a().b((List)localObject);
        if (paramFromServiceMsg.nextFlag != 4294967295L)
        {
          localNewIntent.putExtra("next_flag", paramFromServiceMsg.nextFlag);
          localNewIntent.putExtra("upload_package_no", k + 1);
          localNewIntent.putExtra("contact_list", (ArrayList)localBundle.getSerializable("contact_list"));
          localNewIntent.putExtra("session_id", paramFromServiceMsg.sessionSid);
          localNewIntent.putExtra("is_resend", false);
          localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
          getAppRuntime().startServlet(localNewIntent);
          return;
        }
        notifyObserver(paramIntent, 14, true, null, ContactBindObserver.class);
        return;
      }
      if (((RespondHeader)localObject).result == 105)
      {
        a().a(null);
        notifyObserver(paramIntent, 14, false, null, ContactBindObserver.class);
        return;
      }
      if (localBundle.getBoolean("is_resend"))
      {
        notifyObserver(paramIntent, 14, false, null, ContactBindObserver.class);
        return;
      }
      localNewIntent.putExtra("is_resend", true);
      localNewIntent.putExtra("next_flag", localBundle.getLong("next_flag"));
      localNewIntent.putExtra("upload_package_no", k);
      localNewIntent.putExtra("contact_list", (ArrayList)localBundle.getSerializable("contact_list"));
      localNewIntent.putExtra("session_id", localBundle.getByteArray("session_id"));
      localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
      getAppRuntime().startServlet(localNewIntent);
      return;
    }
    if (localBundle.getBoolean("is_resend"))
    {
      notifyObserver(paramIntent, 14, false, null, ContactBindObserver.class);
      return;
    }
    localNewIntent.putExtra("is_resend", true);
    localNewIntent.putExtra("next_flag", localBundle.getLong("next_flag"));
    localNewIntent.putExtra("upload_package_no", k);
    localNewIntent.putExtra("contact_list", (ArrayList)localBundle.getSerializable("contact_list"));
    localNewIntent.putExtra("session_id", localBundle.getByteArray("session_id"));
    localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
    getAppRuntime().startServlet(localNewIntent);
  }
  
  private void i(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = paramIntent.getExtras();
    NewIntent localNewIntent = new NewIntent(getAppRuntime().getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 15);
    localNewIntent.putExtra("unique_phone_no", localBundle.getString("unique_phone_no"));
    int k = localBundle.getInt("upload_package_no");
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = a(paramFromServiceMsg);
      Object localObject = (RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader());
      paramFromServiceMsg = (ResponeUpdateAddressBook)paramFromServiceMsg.getByClass("ResponeUpdateAddressBook", new ResponeUpdateAddressBook());
      if (((RespondHeader)localObject).result == 0)
      {
        localObject = (ArrayList)localBundle.getSerializable("add_contact_list");
        int m = k * 50;
        if (m < ((List)localObject).size())
        {
          int j = m + 50;
          int i = j;
          if (j > ((List)localObject).size()) {
            i = ((List)localObject).size();
          }
          localObject = ((List)localObject).subList(m, i);
          a().b((List)localObject);
        }
        if (paramFromServiceMsg.nextFlag != 4294967295L)
        {
          localNewIntent.putExtra("next_flag", paramFromServiceMsg.nextFlag);
          localNewIntent.putExtra("upload_package_no", k + 1);
          localNewIntent.putExtra("add_contact_list", (ArrayList)localBundle.getSerializable("add_contact_list"));
          localNewIntent.putExtra("del_contact_list", (ArrayList)localBundle.getSerializable("del_contact_list"));
          localNewIntent.putExtra("session_id", paramFromServiceMsg.sessionSid);
          localNewIntent.putExtra("is_resend", false);
          localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
          getAppRuntime().startServlet(localNewIntent);
        }
        do
        {
          do
          {
            return;
            notifyObserver(paramIntent, 15, true, null, ContactBindObserver.class);
          } while ((localBundle == null) || (!localBundle.containsKey("add_contact_list")));
          paramIntent = (ArrayList)localBundle.getSerializable("rename_contact_list");
        } while (paramIntent.size() == 0);
        ((PhoneContactManagerImp)a()).a(paramIntent);
        return;
      }
      if (((RespondHeader)localObject).result == 105)
      {
        a().a(null);
        notifyObserver(paramIntent, 15, false, null, ContactBindObserver.class);
        return;
      }
      if (localBundle.getBoolean("is_resend"))
      {
        notifyObserver(paramIntent, 15, false, null, ContactBindObserver.class);
        return;
      }
      localNewIntent.putExtra("next_flag", paramFromServiceMsg.nextFlag);
      localNewIntent.putExtra("upload_package_no", k);
      localNewIntent.putExtra("add_contact_list", (ArrayList)localBundle.getSerializable("add_contact_list"));
      localNewIntent.putExtra("del_contact_list", (ArrayList)localBundle.getSerializable("del_contact_list"));
      localNewIntent.putExtra("session_id", paramFromServiceMsg.sessionSid);
      localNewIntent.putExtra("is_resend", true);
      localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
      getAppRuntime().startServlet(localNewIntent);
      return;
    }
    if (localBundle.getBoolean("is_resend"))
    {
      notifyObserver(paramIntent, 15, false, null, ContactBindObserver.class);
      return;
    }
    localNewIntent.putExtra("next_flag", localBundle.getLong("next_flag"));
    localNewIntent.putExtra("upload_package_no", k);
    localNewIntent.putExtra("add_contact_list", (ArrayList)localBundle.getSerializable("add_contact_list"));
    localNewIntent.putExtra("del_contact_list", (ArrayList)localBundle.getSerializable("del_contact_list"));
    localNewIntent.putExtra("session_id", localBundle.getByteArray("session_id"));
    localNewIntent.putExtra("is_resend", true);
    localNewIntent.setObserver(((NewIntent)paramIntent).getObserver());
    getAppRuntime().startServlet(localNewIntent);
  }
  
  private void j(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      if (((RespondHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespondHeader", new RespondHeader())).result == 0)
      {
        notifyObserver(paramIntent, 17, true, null, ContactBindObserver.class);
        return;
      }
      notifyObserver(paramIntent, 17, false, null, ContactBindObserver.class);
      return;
    }
    notifyObserver(paramIntent, 17, false, null, ContactBindObserver.class);
  }
  
  private void k(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContactManager", 2, "Query contact resp.");
      }
      paramFromServiceMsg = a(paramFromServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContactManager", 2, "after creatPacket");
      }
      Object localObject = (RespondHeader)paramFromServiceMsg.getByClass("RespondHeader", new RespondHeader());
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContactManager", 2, "after get respHeader | result = " + ((RespondHeader)localObject).result);
      }
      paramFromServiceMsg = a(paramFromServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContactManager", 2, "after queryResponse");
      }
      if (((RespondHeader)localObject).result == 0)
      {
        a().a(paramFromServiceMsg.nextFlag, paramFromServiceMsg.timeStamp, paramFromServiceMsg.alreadyBindContacts, new ArrayList());
        if (paramFromServiceMsg.nextFlag != 4294967295L)
        {
          localObject = new NewIntent(getAppRuntime().getApplication(), ContactBindServlet.class);
          ((NewIntent)localObject).putExtra("req_type", 28);
          ((NewIntent)localObject).putExtra("next_flag", paramFromServiceMsg.nextFlag);
          ((NewIntent)localObject).putExtra("time_stamp", paramIntent.getExtras().getLong("time_stamp"));
          ((NewIntent)localObject).putExtra("session_id", paramFromServiceMsg.sessionSid);
          ((NewIntent)localObject).setObserver(((NewIntent)paramIntent).getObserver());
          getAppRuntime().startServlet((NewIntent)localObject);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContactManager", 2, "Query contact finish.");
        }
        localObject = new Bundle();
        if ((paramFromServiceMsg.alreadyBindContacts != null) && (paramFromServiceMsg.alreadyBindContacts.size() > 0)) {
          ((Bundle)localObject).putBoolean("hasUpdate", true);
        }
        for (;;)
        {
          notifyObserver(paramIntent, 28, true, (Bundle)localObject, ContactBindObserver.class);
          return;
          ((Bundle)localObject).putBoolean("hasUpdate", false);
        }
      }
      notifyObserver(paramIntent, 28, false, null, ContactBindObserver.class);
      return;
    }
    notifyObserver(paramIntent, 28, false, null, ContactBindObserver.class);
  }
  
  private void l(Intent arg1, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactManager", 2, "Push Recommend resp.");
    }
    if (((RespondHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespondHeader", new RespondHeader())).requestID == 0) {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_ArrayOfInt)
        {
          if (this.b)
          {
            this.c = true;
            return;
          }
          this.b = true;
          paramFromServiceMsg = new NewIntent(getAppRuntime().getApplication(), ContactBindServlet.class);
          paramFromServiceMsg.putExtra("req_type", 29);
          paramFromServiceMsg.putExtra("next_flag", 0L);
          paramFromServiceMsg.putExtra("getRecommendedTimeStamp", getAppRuntime().getPreferences().getLong("getRecommendedTimeStamp", 0L));
          paramFromServiceMsg.putExtra("session_id", new byte[] { 0 });
          if (a().g())
          {
            paramFromServiceMsg.putExtra("recommend_type", 2);
            getAppRuntime().startServlet(paramFromServiceMsg);
          }
        }
        paramFromServiceMsg.putExtra("recommend_type", 1);
      }
    }
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "account.ResponseNotifyForRecommendUpdate" };
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (str == null) {}
    do
    {
      do
      {
        return;
        if (str.equals("account.RequestQueryQQBindingStat"))
        {
          c(paramIntent, paramFromServiceMsg);
          return;
        }
        if (str.equals("account.RequestBindMobile"))
        {
          d(paramIntent, paramFromServiceMsg);
          return;
        }
        if (str.equals("account.RequestReBindMobile"))
        {
          e(paramIntent, paramFromServiceMsg);
          return;
        }
        if (str.equals("account.RequestCancelBindMobile"))
        {
          f(paramIntent, paramFromServiceMsg);
          return;
        }
        if (str.equals("account.RequestVerifyBindingSmscode"))
        {
          g(paramIntent, paramFromServiceMsg);
          return;
        }
        if (str.equals("account.RequestResendBindingSmscode"))
        {
          j(paramIntent, paramFromServiceMsg);
          return;
        }
        if (str.equals("account.RequestQueryQQMobileContactsV2"))
        {
          k(paramIntent, paramFromServiceMsg);
          return;
        }
        if (str.equals("account.RequestUploadAddressBook"))
        {
          h(paramIntent, paramFromServiceMsg);
          return;
        }
        if (str.equals("account.RequestUpdateAddressBook"))
        {
          i(paramIntent, paramFromServiceMsg);
          return;
        }
      } while (str.equals("account.RequestGetRecommendedListV2"));
      if (str.equals("account.ResponseNotifyForRecommendUpdate"))
      {
        l(paramIntent, paramFromServiceMsg);
        return;
      }
      if (str.equals("account.RequestVerifyWTLogin_emp"))
      {
        a(paramIntent, paramFromServiceMsg);
        return;
      }
    } while (!str.equals("account.RequestReBindMblWTLogin_emp"));
    b(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null) {
      return;
    }
    paramPacket.setServantName("AccountServer");
    paramPacket.setFuncName("AccountServerFunc");
    Object localObject1 = a(0, 0, 0);
    int j;
    int i;
    Object localObject2;
    Object localObject3;
    switch (paramIntent.getInt("req_type", 0))
    {
    case 18: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    default: 
      return;
    case 12: 
      paramPacket.setSSOCommand("account.RequestQueryQQBindingStat");
      ((RequestHeader)localObject1).cmd = 12;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject1);
      paramPacket.addRequestPacket("RequestQueryQQBindingStat", new RequestQueryQQBindingStat(((PhoneContactManagerImp)a()).a()));
      return;
    case 26: 
      paramPacket.setAccount("0");
      paramPacket.setSSOCommand("account.RequestVerifyWTLogin_emp");
      ((RequestHeader)localObject1).cmd = 26;
      try
      {
        ((RequestHeader)localObject1).uin = Long.parseLong(paramIntent.getString("cmd_param_phone_uin"));
        paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject1);
        localObject1 = new RequestVerifyWTLogin();
        ((RequestVerifyWTLogin)localObject1).encryptBuffer = paramIntent.getByteArray("cmd_param_phone_bind_sign");
        paramPacket.addRequestPacket("RequestVerifyWTLogin", (JceStruct)localObject1);
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
        }
      }
    case 27: 
      paramPacket.setAccount("0");
      paramPacket.setSSOCommand("account.RequestReBindMblWTLogin_emp");
      ((RequestHeader)localObject1).cmd = 27;
      try
      {
        ((RequestHeader)localObject1).uin = Long.parseLong(paramIntent.getString("cmd_param_phone_uin"));
        paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject1);
        localObject1 = new RequestReBindMblWTLogin();
        ((RequestReBindMblWTLogin)localObject1).encryptBuffer = paramIntent.getByteArray("cmd_param_phone_bind_sign");
        paramPacket.addRequestPacket("RequestReBindMblWTLogin", (JceStruct)localObject1);
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    case 13: 
      paramPacket.setSSOCommand("account.RequestBindMobile");
      ((RequestHeader)localObject1).cmd = 13;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject1);
      localObject1 = new RequestBindMobile();
      ((RequestBindMobile)localObject1).nationCode = paramIntent.getString("country_code");
      ((RequestBindMobile)localObject1).mobileNo = paramIntent.getString("phone_number");
      ((RequestBindMobile)localObject1).type = paramIntent.getInt("cmd_param_bind_type");
      paramPacket.addRequestPacket("RequestBindMobile", (JceStruct)localObject1);
      return;
    case 19: 
      paramPacket.setSSOCommand("account.RequestReBindMobile");
      ((RequestHeader)localObject1).cmd = 19;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject1);
      localObject1 = new RequestReBindMobile();
      ((RequestReBindMobile)localObject1).nationCode = paramIntent.getString("country_code");
      ((RequestReBindMobile)localObject1).mobileNo = paramIntent.getString("phone_number");
      ((RequestReBindMobile)localObject1).type = paramIntent.getInt("cmd_param_bind_type");
      paramPacket.addRequestPacket("RequestReBindMobile", (JceStruct)localObject1);
      return;
    case 20: 
      paramPacket.setSSOCommand("account.RequestCancelBindMobile");
      ((RequestHeader)localObject1).cmd = 20;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject1);
      localObject1 = new RequestCancelBindMobile();
      ((RequestCancelBindMobile)localObject1).nationCode = paramIntent.getString("country_code");
      ((RequestCancelBindMobile)localObject1).mobileNo = paramIntent.getString("phone_number");
      paramPacket.addRequestPacket("RequestCancelBindMobile", (JceStruct)localObject1);
      return;
    case 16: 
      paramPacket.setSSOCommand("account.RequestVerifyBindingSmscode");
      ((RequestHeader)localObject1).cmd = 16;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject1);
      localObject1 = new RequestVerifySmscode();
      ((RequestVerifySmscode)localObject1).smsCode = paramIntent.getString("verify_smscode");
      ((RequestVerifySmscode)localObject1).sessionSid = paramIntent.getByteArray("session_id");
      ((RequestVerifySmscode)localObject1).type = paramIntent.getInt("cmd_param_bind_type");
      paramPacket.addRequestPacket("RequestVerifySmscode", (JceStruct)localObject1);
      return;
    case 17: 
      paramPacket.setSSOCommand("account.RequestResendBindingSmscode");
      ((RequestHeader)localObject1).cmd = 17;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject1);
      localObject1 = new RequestResendSmscode();
      ((RequestResendSmscode)localObject1).sessionSid = paramIntent.getByteArray("session_id");
      paramPacket.addRequestPacket("RequestResendSmscode", (JceStruct)localObject1);
      return;
    case 28: 
      paramPacket.setSSOCommand("account.RequestQueryQQMobileContactsV2");
      ((RequestHeader)localObject1).cmd = 28;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject1);
      localObject1 = new RequestQueryQQMobileContactsV2();
      ((RequestQueryQQMobileContactsV2)localObject1).Compressd = true;
      ((RequestQueryQQMobileContactsV2)localObject1).nextFlag = paramIntent.getLong("next_flag");
      ((RequestQueryQQMobileContactsV2)localObject1).timeStamp = paramIntent.getLong("time_stamp");
      ((RequestQueryQQMobileContactsV2)localObject1).sessionSid = paramIntent.getByteArray("session_id");
      paramPacket.addRequestPacket("RequestQueryQQMobileContactsV2", (JceStruct)localObject1);
      return;
    case 14: 
      paramPacket.setSSOCommand("account.RequestUploadAddressBook");
      ((RequestHeader)localObject1).cmd = 14;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject1);
      j = paramIntent.getInt("upload_package_no");
      localObject1 = (ArrayList)paramIntent.getSerializable("contact_list");
      if (((ArrayList)localObject1).size() > j * 50 + 50 - 1)
      {
        i = j * 50 + 50;
        localObject2 = ((ArrayList)localObject1).subList(j * 50, i);
        localObject3 = new RequestUploadAddressBook();
        ((RequestUploadAddressBook)localObject3).MobileUniqueNo = paramIntent.getString("unique_phone_no");
        ((RequestUploadAddressBook)localObject3).sessionSid = paramIntent.getByteArray("session_id");
        if ((j + 1) * 50 < ((ArrayList)localObject1).size()) {
          break label952;
        }
      }
      for (((RequestUploadAddressBook)localObject3).nextFlag = 4294967295L;; ((RequestUploadAddressBook)localObject3).nextFlag = paramIntent.getLong("next_flag"))
      {
        ((RequestUploadAddressBook)localObject3).AddressBookList = new ArrayList((Collection)localObject2);
        paramPacket.addRequestPacket("RequestUploadAddressBook", (JceStruct)localObject3);
        return;
        i = ((ArrayList)localObject1).size();
        break;
      }
    case 15: 
      label952:
      paramPacket.setSSOCommand("account.RequestUpdateAddressBook");
      ((RequestHeader)localObject1).cmd = 15;
      paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject1);
      localObject1 = (ArrayList)paramIntent.getSerializable("add_contact_list");
      localObject2 = (ArrayList)paramIntent.getSerializable("del_contact_list");
      localObject3 = new RequestUpdateAddressBook();
      ((RequestUpdateAddressBook)localObject3).MobileUniqueNo = paramIntent.getString("unique_phone_no");
      ((RequestUpdateAddressBook)localObject3).sessionSid = paramIntent.getByteArray("session_id");
      int k = paramIntent.getInt("upload_package_no") * 50;
      j = k + 50;
      if (((localObject1 == null) || (j >= ((ArrayList)localObject1).size())) && ((localObject2 == null) || (j >= ((ArrayList)localObject2).size())))
      {
        ((RequestUpdateAddressBook)localObject3).nextFlag = 4294967295L;
        if ((localObject1 == null) || (k >= ((ArrayList)localObject1).size())) {
          break label1238;
        }
        i = j;
        if (j > ((ArrayList)localObject1).size()) {
          i = ((ArrayList)localObject1).size();
        }
        ((RequestUpdateAddressBook)localObject3).AddressBookAddList = new ArrayList(((ArrayList)localObject1).subList(k, i));
        label1158:
        if ((localObject2 == null) || (k >= ((ArrayList)localObject2).size())) {
          break label1250;
        }
        j = i;
        if (i > ((ArrayList)localObject2).size()) {
          j = ((ArrayList)localObject2).size();
        }
      }
      label1238:
      label1250:
      for (((RequestUpdateAddressBook)localObject3).AddressBookDelList = new ArrayList(((ArrayList)localObject2).subList(k, j));; ((RequestUpdateAddressBook)localObject3).AddressBookDelList = null)
      {
        paramPacket.addRequestPacket("RequestUpdateAddressBook", (JceStruct)localObject3);
        return;
        ((RequestUpdateAddressBook)localObject3).nextFlag = paramIntent.getLong("next_flag");
        break;
        ((RequestUpdateAddressBook)localObject3).AddressBookAddList = null;
        i = j;
        break label1158;
      }
    }
    paramPacket.setSSOCommand("account.RequestGetRecommendedListV2");
    ((RequestHeader)localObject1).cmd = 29;
    paramPacket.addRequestPacket("RequestHeader", (JceStruct)localObject1);
    localObject1 = new RequestGetRecommendedListV2();
    ((RequestGetRecommendedListV2)localObject1).nextFlag = paramIntent.getLong("next_flag");
    ((RequestGetRecommendedListV2)localObject1).timeStamp = getAppRuntime().getPreferences().getLong("getRecommendedTimeStamp", 0L);
    ((RequestGetRecommendedListV2)localObject1).sessionSid = paramIntent.getByteArray("session_id");
    ((RequestGetRecommendedListV2)localObject1).type = paramIntent.getInt("recommend_type", 1);
    paramPacket.addRequestPacket("RequestGetRecommendedListV2", (JceStruct)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.ContactBindServlet
 * JD-Core Version:    0.7.0.1
 */