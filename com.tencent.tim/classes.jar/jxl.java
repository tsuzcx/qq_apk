import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager.1;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.AdInfo;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.PhoneInfo;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.ReqBody;

public class jxl
{
  private static jxl jdField_a_of_type_Jxl;
  private lun jdField_a_of_type_Lun = lun.a();
  private ArrayList<jxc> items = new ArrayList();
  private final Object mDataLock = new Object();
  
  public static jxl a()
  {
    if (jdField_a_of_type_Jxl == null) {
      jdField_a_of_type_Jxl = new jxl();
    }
    return jdField_a_of_type_Jxl;
  }
  
  private void sendPbReq(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      long l = System.currentTimeMillis();
      paramToServiceMsg.extraData.putLong("time_stamp", l);
      this.jdField_a_of_type_Lun.g(paramToServiceMsg);
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt, jxc paramjxc)
  {
    if ((paramjxc == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      oidb_cmd0x886.PhoneInfo localPhoneInfo = jxp.a();
      try
      {
        l1 = Long.parseLong(paramAppInterface.getCurrentAccountUin());
        paramAppInterface = paramjxc.makeReportAdInfo(paramInt);
        long l2 = NetConnInfoCenter.getServerTimeMillis();
        String str = arwv.toMD5(l1 + paramjxc.Ux + paramInt + l2);
        oidb_cmd0x886.ReqBody localReqBody = new oidb_cmd0x886.ReqBody();
        localReqBody.uint64_uin.set(l1);
        localReqBody.msg_phone_info.set(localPhoneInfo);
        localReqBody.msg_ad_info.set(paramAppInterface);
        localReqBody.uint64_client_time.set(l2);
        localReqBody.bytes_uuid.set(ByteStringMicro.copyFromUtf8(str));
        localReqBody.enum_ad_display.set(1);
        sendPbReq(lup.makeOIDBPkg("OidbSvc.0x886", 2182, 0, localReqBody.toByteArray()));
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramAppInterface = new StringBuilder("AdReport(");
        paramAppInterface.append(paramInt).append(") msgID=").append(paramjxc.Ux);
        QLog.d("AdvertisementRecentUserManager", 2, paramAppInterface.toString());
        return;
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          long l1 = 0L;
          paramAppInterface.printStackTrace();
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if ((paramRecentUser != null) && (paramRecentUser.uin != null)) {
      synchronized (this.mDataLock)
      {
        jxc localjxc = b(paramRecentUser.uin);
        if ((localjxc != null) && (NetConnInfoCenter.getServerTimeMillis() - localjxc.pushTime > 86400000L))
        {
          localObject1 = (ProxyManager)paramQQAppInterface.getManager(18);
          if (localObject1 == null)
          {
            localObject1 = null;
            if (localObject1 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AdvertisementRecentUserManager", 2, "deleteItem uin:" + paramRecentUser.uin);
              }
              aajt.a().Av(paramRecentUser.uin + "-" + paramRecentUser.getType());
              ((acxw)localObject1).f(paramRecentUser);
              aalb.l(paramQQAppInterface, localjxc.mSenderUin, 1008);
              paramQQAppInterface.b().ca(localjxc.mSenderUin, 1008);
            }
            ThreadManager.executeOnFileThread(new AdvertisementRecentUserManager.1(this, localjxc));
          }
        }
        else
        {
          return;
        }
        Object localObject1 = ((ProxyManager)localObject1).a();
      }
    }
  }
  
  public void aAV()
  {
    Iterator localIterator = this.items.iterator();
    while (localIterator.hasNext()) {
      ((jxc)localIterator.next()).hasReport = false;
    }
  }
  
  public jxc b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "getAdvertisementItem uin:" + paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.mDataLock)
      {
        Iterator localIterator = this.items.iterator();
        while (localIterator.hasNext())
        {
          jxc localjxc = (jxc)localIterator.next();
          if (paramString.equals(localjxc.mSenderUin)) {
            return localjxc;
          }
        }
      }
    }
    return null;
  }
  
  public void b(jxc paramjxc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "putAdvertisementItem uin:" + paramjxc.mSenderUin);
    }
    synchronized (this.mDataLock)
    {
      this.items.add(paramjxc);
      return;
    }
  }
  
  public String dY(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "getTrueUin uin:" + paramString);
    }
    synchronized (this.mDataLock)
    {
      Iterator localIterator = this.items.iterator();
      while (localIterator.hasNext())
      {
        jxc localjxc = (jxc)localIterator.next();
        if (localjxc.mSenderUin.equals(paramString))
        {
          paramString = localjxc.a.UD;
          return paramString;
        }
      }
      return null;
    }
  }
  
  public void lw(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "removeUinItem uin:" + paramString);
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mDataLock)
    {
      Iterator localIterator = this.items.iterator();
      while (localIterator.hasNext())
      {
        jxc localjxc = (jxc)localIterator.next();
        if (paramString.equals(localjxc.mSenderUin)) {
          localArrayList.add(localjxc);
        }
      }
    }
    this.items.removeAll(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jxl
 * JD-Core Version:    0.7.0.1
 */