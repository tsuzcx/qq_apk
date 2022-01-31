import LBS.Attr;
import LBS.Cell;
import LBS.GPS;
import LBS.LBSInfo;
import LBS.Wifi;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoAttribute;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.lbs.member_lbs.Cell;
import tencent.im.lbs.member_lbs.GPS;
import tencent.im.lbs.member_lbs.LBSInfo;
import tencent.im.lbs.member_lbs.ReqBody;
import tencent.im.lbs.member_lbs.Wifi;

public class yxl
  extends SosoInterface.OnLocationListener
{
  public yxl(BizTroopHandler paramBizTroopHandler, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("ReportSelfLbsInfo, onLocationFinish errCode=").append(paramInt).append(", info.mLocation==null?");
      if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null)) {
        break label198;
      }
    }
    label198:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.troopMemberDistance", 2, bool);
      if ((paramInt != 0) || (paramSosoLbsInfo == null) || (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null)) {
        return;
      }
      localObject2 = new GPS((int)(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c * 1000000.0D), (int)(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d * 1000000.0D), -1, 0);
      localObject3 = new ArrayList();
      if (paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList == null) {
        break;
      }
      localObject1 = paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (SosoInterface.SosoCell)((Iterator)localObject1).next();
        ((ArrayList)localObject3).add(new Cell((short)((SosoInterface.SosoCell)localObject4).jdField_a_of_type_Int, (short)((SosoInterface.SosoCell)localObject4).b, ((SosoInterface.SosoCell)localObject4).c, ((SosoInterface.SosoCell)localObject4).d, (short)((SosoInterface.SosoCell)localObject4).e));
      }
    }
    Object localObject4 = new ArrayList();
    Object localObject5;
    if (paramSosoLbsInfo.b != null)
    {
      localObject1 = paramSosoLbsInfo.b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject5 = (SosoInterface.SosoWifi)((Iterator)localObject1).next();
        ((ArrayList)localObject4).add(new Wifi(((SosoInterface.SosoWifi)localObject5).jdField_a_of_type_Long, (short)((SosoInterface.SosoWifi)localObject5).jdField_a_of_type_Int));
      }
    }
    Object localObject1 = null;
    if (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute != null) {
      localObject1 = new Attr(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.a, paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.b, paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.c);
    }
    Object localObject3 = new LBSInfo((GPS)localObject2, (ArrayList)localObject4, (ArrayList)localObject3, (Attr)localObject1);
    paramSosoLbsInfo = new ToServiceMsg("mobileqq.service", this.a.b.getCurrentAccountUin(), "GrpMemberLBS.ReportLBS");
    localObject1 = new member_lbs.ReqBody();
    Object localObject2 = new member_lbs.LBSInfo();
    if (localObject3 != null)
    {
      if ((((LBSInfo)localObject3).stGps != null) && (((LBSInfo)localObject3).stGps.iLon != 0) && (((LBSInfo)localObject3).stGps.iLat != 0))
      {
        localObject4 = new member_lbs.GPS();
        ((member_lbs.GPS)localObject4).int64_longitude.set(((LBSInfo)localObject3).stGps.iLon);
        ((member_lbs.GPS)localObject4).int64_latitude.set(((LBSInfo)localObject3).stGps.iLat);
        ((member_lbs.GPS)localObject4).uint32_gps_type.set(((LBSInfo)localObject3).stGps.eType);
        ((member_lbs.LBSInfo)localObject2).msg_gps.set((MessageMicro)localObject4);
      }
      localObject4 = new ArrayList();
      Object localObject6;
      if (((LBSInfo)localObject3).vWifis != null)
      {
        localObject5 = ((LBSInfo)localObject3).vWifis.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (Wifi)((Iterator)localObject5).next();
          member_lbs.Wifi localWifi = new member_lbs.Wifi();
          localWifi.int64_mac.set(((Wifi)localObject6).lMac);
          localWifi.int32_rssi.set(((Wifi)localObject6).shRssi);
          ((ArrayList)localObject4).add(localWifi);
        }
        ((member_lbs.LBSInfo)localObject2).rpt_msg_wifis.set((List)localObject4);
      }
      if (((LBSInfo)localObject3).vCells != null)
      {
        localObject4 = new ArrayList();
        localObject3 = ((LBSInfo)localObject3).vCells.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject5 = (Cell)((Iterator)localObject3).next();
          localObject6 = new member_lbs.Cell();
          ((member_lbs.Cell)localObject6).int32_mobile_country_code.set(((Cell)localObject5).shMcc);
          ((member_lbs.Cell)localObject6).int32_mobile_network_code.set(((Cell)localObject5).shMnc);
          ((member_lbs.Cell)localObject6).int32_location_area_code.set(((Cell)localObject5).iLac);
          ((member_lbs.Cell)localObject6).int32_cell_id.set(((Cell)localObject5).iCellId);
          ((member_lbs.Cell)localObject6).int32_rssi.set(((Cell)localObject5).shRssi);
          ((ArrayList)localObject4).add(localObject6);
        }
        ((member_lbs.LBSInfo)localObject2).rpt_msg_cells.set((List)localObject4);
      }
    }
    ((member_lbs.ReqBody)localObject1).msg_lbsinfo.set((MessageMicro)localObject2);
    paramSosoLbsInfo.putWupBuffer(((member_lbs.ReqBody)localObject1).toByteArray());
    this.a.b(paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     yxl
 * JD-Core Version:    0.7.0.1
 */