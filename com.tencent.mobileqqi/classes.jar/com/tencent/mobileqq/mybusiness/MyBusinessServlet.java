package com.tencent.mobileqq.mybusiness;

import MyCarrier.Attr;
import MyCarrier.Carrier;
import MyCarrier.Cell;
import MyCarrier.GPS;
import MyCarrier.LBSInfo;
import MyCarrier.ReqCarrier;
import MyCarrier.RspCarrier;
import MyCarrier.Wifi;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoAttribute;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class MyBusinessServlet
  extends MSFServlet
{
  public static final String a = "MyBusinessServlet";
  
  private LBSInfo a()
  {
    Object localObject1 = (QQAppInterface)getAppRuntime();
    ((QQAppInterface)localObject1).a();
    localObject1 = ((QQAppInterface)localObject1).a();
    GPS localGPS = new GPS(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Int, ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b, -1, 0);
    ArrayList localArrayList = new ArrayList();
    Object localObject3;
    if (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject2 = ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SosoInterface.SosoCell)((Iterator)localObject2).next();
        localArrayList.add(new Cell((short)((SosoInterface.SosoCell)localObject3).jdField_a_of_type_Int, (short)((SosoInterface.SosoCell)localObject3).b, ((SosoInterface.SosoCell)localObject3).c, ((SosoInterface.SosoCell)localObject3).d, (short)((SosoInterface.SosoCell)localObject3).e));
      }
    }
    Object localObject2 = new ArrayList();
    if (((SosoInterface.SosoLbsInfo)localObject1).b != null)
    {
      localObject3 = ((SosoInterface.SosoLbsInfo)localObject1).b.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        SosoInterface.SosoWifi localSosoWifi = (SosoInterface.SosoWifi)((Iterator)localObject3).next();
        ((ArrayList)localObject2).add(new Wifi(localSosoWifi.jdField_a_of_type_Long, (short)localSosoWifi.jdField_a_of_type_Int));
      }
    }
    return new LBSInfo(localGPS, (ArrayList)localObject2, localArrayList, new Attr(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.a, ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.b, ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.c));
  }
  
  public QQAppInterface a()
  {
    return (QQAppInterface)getAppRuntime();
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RspCarrier)decodePacket(paramFromServiceMsg.getWupBuffer(), "RspCarrier", new RspCarrier());
      localBundle.putSerializable("result", paramFromServiceMsg.carrrier);
      localBundle.putSerializable("refreshTime", Integer.valueOf(paramFromServiceMsg.refreshTime));
      paramFromServiceMsg = paramFromServiceMsg.carrrier;
      if (QLog.isDevelopLevel())
      {
        QLog.d("MyBusinessServlet", 4, "----->receiveCarrierQuery sucess");
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierCity      " + paramFromServiceMsg.carrierCity);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierExtraInfo " + paramFromServiceMsg.carrierExtraInfo);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierId        " + paramFromServiceMsg.carrierId);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierLogo      " + paramFromServiceMsg.carrierLogo);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierName      " + paramFromServiceMsg.carrierName);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierProvince  " + paramFromServiceMsg.carrierProvince);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierURL       " + paramFromServiceMsg.carrierURL);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery redhotfilter     " + paramFromServiceMsg.redhotfilter);
      }
      notifyObserver(paramIntent, 1, true, localBundle, MyBusinessObserver.class);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MyBusinessServlet", 4, "----->receiveCarrierQuery sucess failed");
    }
    notifyObserver(paramIntent, 1, false, localBundle, MyBusinessObserver.class);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MyBusinessServlet", 4, "......onReceive cmd = " + paramFromServiceMsg.getServiceCmd());
    }
    if ("CarrierEntry.queryCarrier".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramIntent, paramFromServiceMsg);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (1 == paramIntent.getIntExtra("cmd_id", -1))
    {
      String str1 = paramIntent.getStringExtra("phone_number");
      int i = paramIntent.getIntExtra("bind_from", 0);
      String str2 = paramIntent.getStringExtra("opt_info");
      paramIntent = new LBSInfo();
      if (TextUtils.isEmpty(str1)) {
        paramIntent = a();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("MyBusinessServlet", 4, "......onSend bindMobile = " + str1 + ", bindType = " + i + ", info = " + paramIntent);
      }
      paramIntent = new ReqCarrier(str1, i, paramIntent, str2);
      paramPacket.setSSOCommand("CarrierEntry.queryCarrier");
      paramPacket.setServantName("CarrierEntry");
      paramPacket.setFuncName("queryCarrier");
      paramPacket.addRequestPacket("ReqCarrier", paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mybusiness.MyBusinessServlet
 * JD-Core Version:    0.7.0.1
 */