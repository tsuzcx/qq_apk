package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import awit;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import lcc;
import lir;
import liv;
import ljw.a;
import lun;
import lup;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xdc0.oidb_0xdc0.GroupInfo;
import tencent.im.oidb.cmd0xdc0.oidb_0xdc0.LocationInfo;
import tencent.im.oidb.cmd0xdc0.oidb_0xdc0.LocationList;
import tencent.im.oidb.cmd0xdc0.oidb_0xdc0.ReqBody;
import tencent.im.oidb.cmd0xdc0.oidb_0xdc0.RspBody;

public class SelectPositionModule
  extends lir
{
  private a a;
  private volatile PositionData jdField_b_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData;
  private SosoInterface.a jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a;
  private volatile PositionData c;
  private volatile List<ljw.a> ij = new CopyOnWriteArrayList();
  private volatile long uz;
  
  public SelectPositionModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, lun paramlun, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramlun, paramHandler);
  }
  
  private PositionData a(String paramString)
  {
    Object localObject = awit.a(BaseApplicationImpl.getApplication().getRuntime(), true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).getString(paramString, "");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          JSONObject localJSONObject = new JSONObject((String)localObject);
          PositionData localPositionData = new PositionData();
          localPositionData.country = localJSONObject.getString("key_country");
          localPositionData.province = localJSONObject.getString("key_province");
          localPositionData.city = localJSONObject.getString("key_city");
          localPositionData.cityCode = localJSONObject.getString("key_citycode");
          if (QLog.isColorLevel()) {
            QLog.d("SelectPositionModule", 2, "getPositionDataByKey position = " + localPositionData + " key = " + paramString);
          }
          return localPositionData;
        }
        catch (JSONException localJSONException)
        {
          QLog.e("SelectPositionModule", 2, "getSelectedPositionData positionJson = " + (String)localObject + " exception = " + localJSONException + " key = " + paramString);
        }
      }
    }
    return null;
  }
  
  private void a(PositionData paramPositionData, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("key_country", paramPositionData.country);
      localJSONObject.put("key_province", paramPositionData.province);
      localJSONObject.put("key_city", paramPositionData.city);
      localJSONObject.put("key_citycode", paramPositionData.cityCode);
      Object localObject = awit.a(BaseApplicationImpl.getApplication().getRuntime(), true, false);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, localJSONObject.toString());
        ((SharedPreferences.Editor)localObject).commit();
        if (QLog.isColorLevel()) {
          QLog.d("SelectPositionModule", 2, "save position = " + localJSONObject + " key = " + paramString);
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("SelectPositionModule", 2, "saveSelectedPositionData error positionData = " + paramPositionData + " ,error = " + localJSONException + " key = " + paramString);
    }
  }
  
  private void aMC()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SelectPositionModule", 2, "checkNeedChangeLocalCity checkNeedChangeLocalCity mGPSPositionData = " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData);
    }
    PositionData localPositionData;
    if (this.c != null)
    {
      localPositionData = this.c;
      if (!a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData)) {
        break label171;
      }
      f(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData);
      if ((!a(localPositionData)) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.equals(localPositionData))) {
        break label135;
      }
      lcc.a().a(1, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData);
      if (QLog.isColorLevel()) {
        QLog.i("SelectPositionModule", 2, "checkNeedChangeLocalCity changeCity lastPositionData = " + localPositionData);
      }
    }
    label135:
    label171:
    do
    {
      do
      {
        do
        {
          return;
          localPositionData = e();
          break;
          aMB();
        } while (!QLog.isColorLevel());
        QLog.i("SelectPositionModule", 2, "checkNeedChangeLocalCity clearSelectedPositionData mSelectedPositionData = " + localPositionData);
        return;
      } while (!a(localPositionData));
      lcc.a().a(2, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData);
    } while (!QLog.isColorLevel());
    QLog.i("SelectPositionModule", 2, "checkNeedChangeLocalCity reserveCity mSelectedPositionData = " + localPositionData);
  }
  
  private void ar(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_0xdc0.RspBody();
    int i = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    QLog.d("SelectPositionModule", 2, new Object[] { "handle0xdc0WhiteList result = ", Integer.valueOf(i) });
    if (i == 0)
    {
      this.uz = System.currentTimeMillis();
      paramFromServiceMsg = new ArrayList();
      if (((oidb_0xdc0.RspBody)localObject).msg_location_list.has())
      {
        paramObject = (oidb_0xdc0.LocationList)((oidb_0xdc0.RspBody)localObject).msg_location_list.get();
        if ((paramObject.rpt_group_list.has()) && (paramObject.rpt_group_list.size() > 0))
        {
          i = 0;
          while (i < paramObject.rpt_group_list.size())
          {
            localObject = (oidb_0xdc0.GroupInfo)paramObject.rpt_group_list.get(i);
            if (((oidb_0xdc0.GroupInfo)localObject).bytes_name.has()) {
              paramFromServiceMsg.add(new ljw.a(((oidb_0xdc0.GroupInfo)localObject).bytes_name.get().toStringUtf8()));
            }
            if ((((oidb_0xdc0.GroupInfo)localObject).rpt_location_list.has()) && (((oidb_0xdc0.GroupInfo)localObject).rpt_location_list.size() > 0))
            {
              int j = 0;
              if (j < ((oidb_0xdc0.GroupInfo)localObject).rpt_location_list.size())
              {
                oidb_0xdc0.LocationInfo localLocationInfo = (oidb_0xdc0.LocationInfo)((oidb_0xdc0.GroupInfo)localObject).rpt_location_list.get(j);
                if ((localLocationInfo.bytes_city.has()) && (localLocationInfo.bytes_city_code.has()))
                {
                  if ((!localLocationInfo.bytes_province.has()) || (!localLocationInfo.bytes_country.has())) {
                    break label329;
                  }
                  paramFromServiceMsg.add(new ljw.a(localLocationInfo.bytes_country.get().toStringUtf8(), localLocationInfo.bytes_province.get().toStringUtf8(), localLocationInfo.bytes_city.get().toStringUtf8(), localLocationInfo.bytes_city_code.get().toStringUtf8()));
                }
                for (;;)
                {
                  j += 1;
                  break;
                  label329:
                  paramFromServiceMsg.add(new ljw.a("", "", localLocationInfo.bytes_city.get().toStringUtf8(), localLocationInfo.bytes_city_code.get().toStringUtf8()));
                }
              }
            }
            i += 1;
          }
        }
      }
      this.ij.clear();
      this.ij.addAll(paramFromServiceMsg);
      if (QLog.isColorLevel())
      {
        if (!this.ij.isEmpty())
        {
          i = 0;
          while (i < this.ij.size())
          {
            QLog.i("SelectPositionModule", 2, "handle0xdc0WhiteList result, City = " + this.ij.get(i));
            i += 1;
          }
        }
        QLog.i("SelectPositionModule", 2, "handle0xdc0WhiteList result, mCityWhiteList is empty");
      }
      if (this.a != null) {
        this.a.cx(this.ij);
      }
      if (paramToServiceMsg.extraData.getBoolean("need_check_local_city_changed", true)) {
        aMC();
      }
    }
  }
  
  private void c(PositionData paramPositionData)
  {
    PositionData localPositionData = e();
    if (paramPositionData.equals(localPositionData)) {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPositionModule", 2, "handleLocalChannel currentGPSPosition.equals(lastGPSPosition) lastGPSPosition = " + localPositionData);
      }
    }
    do
    {
      return;
      this.c = c();
      if (!paramPositionData.equals(this.c)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SelectPositionModule", 2, "handleLocalChannel currentGPSPosition.equals(lastGPSPosition) currentGPSPosition = " + paramPositionData);
    return;
    if ((System.currentTimeMillis() - this.uz >= 86400000L) || (this.ij.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPositionModule", 2, "handleLocalChannel currentGPSPosition.equals(lastGPSPosition) currentGPSPosition = " + paramPositionData);
      }
      nC(true);
      return;
    }
    aMC();
  }
  
  private PositionData d()
  {
    return a("key_selected_position");
  }
  
  private PositionData e()
  {
    return a("key_gps_position");
  }
  
  private void e(PositionData paramPositionData)
  {
    a(paramPositionData, "key_gps_position");
  }
  
  private void nC(boolean paramBoolean)
  {
    Object localObject = new oidb_0xdc0.ReqBody();
    ((oidb_0xdc0.ReqBody)localObject).uint32_req_type.set(1);
    localObject = lup.makeOIDBPkg("OidbSvc.0xdc0", 3520, 0, ((oidb_0xdc0.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("need_check_local_city_changed", paramBoolean);
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("SelectPositionModule", 2, "requestCityWhiteListListFromServer needCheckLocalCityChanged = " + paramBoolean);
    }
  }
  
  private void nq(String paramString)
  {
    Object localObject = awit.a(BaseApplicationImpl.getApplication().getRuntime(), true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString, "");
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel()) {
        QLog.d("SelectPositionModule", 2, "clearPositionDataByKey key = " + paramString);
      }
    }
  }
  
  public PositionData a()
  {
    if (this.c != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectPositionModule", 2, "positionData = " + this.c);
      }
      return this.c;
    }
    this.c = d();
    if (QLog.isColorLevel()) {
      QLog.i("SelectPositionModule", 2, "getSelectedPositionDataLastTime = " + this.c);
    }
    if (this.c != null) {
      return this.c;
    }
    return b();
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public boolean a(PositionData paramPositionData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectPositionModule", 2, "checkPositionInCityWhiteList currentPosition = " + paramPositionData);
    }
    if (paramPositionData == null) {
      QLog.e("SelectPositionModule", 2, "checkPositionInCityWhiteList currentPosition == null");
    }
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.ij.size())
      {
        ljw.a locala = (ljw.a)this.ij.get(i);
        if (paramPositionData.cityCode.equals(locala.cityCode))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SelectPositionModule", 2, "checkPositionInCityWhiteList true currentPosition = " + paramPositionData);
          }
          return true;
        }
        i += 1;
      }
    }
  }
  
  public void aEL() {}
  
  public void aMA()
  {
    QLog.d("SelectPositionModule", 2, "requestCurrentLoction");
    if (this.jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a == null) {
      this.jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a = new liv(this, 3, true, true, 0L, false, false, "readinjoy_position");
    }
    SosoInterface.a(this.jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a);
  }
  
  public void aMB()
  {
    nq("key_selected_position");
  }
  
  public List<ljw.a> aR()
  {
    if ((this.ij != null) && (!this.ij.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPositionModule", 2, "getCityWhiteList mCityWhiteList is not empty");
      }
      return this.ij;
    }
    nC(false);
    if (QLog.isColorLevel()) {
      QLog.d("SelectPositionModule", 2, "getCityWhiteList mCityWhiteList is empty");
    }
    return null;
  }
  
  public PositionData b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SelectPositionModule", 2, "getGPSPositionData mGPSPositionData = " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData);
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData == null)
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData = e();
      if (QLog.isColorLevel()) {
        QLog.i("SelectPositionModule", 2, "getGPSPositionDataLastTime mGPSPositionData = " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData);
      }
    }
    return this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData;
  }
  
  public PositionData c()
  {
    if (this.c == null) {
      this.c = d();
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectPositionModule", 2, "getSelectedPositionData mSelectedPositionData = " + this.c);
    }
    return this.c;
  }
  
  public void d(PositionData paramPositionData)
  {
    if (paramPositionData == null) {
      QLog.i("SelectPositionModule", 2, "saveSelectedPositionData positionData == null");
    }
    this.c = paramPositionData;
    a(paramPositionData, "key_selected_position");
  }
  
  public void f(PositionData paramPositionData)
  {
    int i = 0;
    while (i < this.ij.size())
    {
      ljw.a locala = (ljw.a)this.ij.get(i);
      if (paramPositionData.cityCode.equals(locala.cityCode)) {
        paramPositionData.city = locala.city;
      }
      i += 1;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xdc0")) {
      ThreadManager.getUIHandler().post(new SelectPositionModule.2(this, paramToServiceMsg, paramFromServiceMsg, paramObject));
    }
  }
  
  public static class PositionData
    implements Serializable
  {
    public String city = "";
    public String cityCode = "";
    public String cityGPS = "";
    public String country = "";
    public String province = "";
    
    public PositionData() {}
    
    public PositionData(SosoInterface.SosoLocation paramSosoLocation)
    {
      if (paramSosoLocation == null) {
        return;
      }
      this.country = paramSosoLocation.nation;
      this.province = paramSosoLocation.province;
      if ((paramSosoLocation.city != null) && (paramSosoLocation.city.endsWith("市")))
      {
        this.city = paramSosoLocation.city.substring(0, paramSosoLocation.city.length() - 1);
        if ((paramSosoLocation.cityCode != null) && (paramSosoLocation.cityCode.length() > 2))
        {
          if (!paramSosoLocation.cityCode.startsWith("11")) {
            break label151;
          }
          this.cityCode = "110000";
        }
      }
      for (;;)
      {
        this.cityGPS = paramSosoLocation.city;
        return;
        this.city = paramSosoLocation.city;
        break;
        label151:
        if (paramSosoLocation.cityCode.startsWith("12")) {
          this.cityCode = "120000";
        } else if (paramSosoLocation.cityCode.startsWith("31")) {
          this.cityCode = "310000";
        } else if (paramSosoLocation.cityCode.startsWith("50")) {
          this.cityCode = "500000";
        } else {
          this.cityCode = (paramSosoLocation.cityCode.substring(0, paramSosoLocation.cityCode.length() - 2) + "00");
        }
      }
    }
    
    public PositionData(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.country = paramString1;
      this.province = paramString2;
      this.city = paramString3;
      this.cityCode = paramString4;
      this.cityGPS = paramString3;
    }
    
    public void copy(PositionData paramPositionData)
    {
      this.country = paramPositionData.country;
      this.province = paramPositionData.province;
      this.city = paramPositionData.city;
      this.cityCode = paramPositionData.cityCode;
      this.cityGPS = paramPositionData.cityGPS;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject != null) && ((paramObject instanceof PositionData)))
      {
        paramObject = (PositionData)paramObject;
        return this.cityCode.equals(paramObject.cityCode);
      }
      return false;
    }
    
    public String toString()
    {
      return "country = " + this.country + " province = " + this.province + " city = " + this.city + " citycode = " + this.cityCode + " cityGPS = " + this.cityGPS;
    }
  }
  
  public static abstract interface a
  {
    public abstract void cx(List<ljw.a> paramList);
    
    public abstract void g(SelectPositionModule.PositionData paramPositionData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule
 * JD-Core Version:    0.7.0.1
 */