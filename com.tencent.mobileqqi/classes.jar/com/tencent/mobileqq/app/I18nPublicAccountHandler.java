package com.tencent.mobileqq.app;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.i18n.pa.proto.QQiPublicAccount.CityInfo;
import com.tencent.i18n.pa.proto.QQiPublicAccount.FetchPublicAccountWhiteListResp;
import com.tencent.i18n.pa.proto.QQiPublicAccount.FetchRecomendedPublicAccountsReq;
import com.tencent.i18n.pa.proto.QQiPublicAccount.FetchRecomendedPublicAccountsResp;
import com.tencent.i18n.pa.proto.QQiPublicAccount.Position;
import com.tencent.i18n.protocal.util.I18nNetworkUtil;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import fcv;
import fcw;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class I18nPublicAccountHandler
  extends BusinessHandler
{
  private static final String a = "I18nPublicAccountHandler";
  
  I18nPublicAccountHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private QQiPublicAccount.CityInfo a(QQiPublicAccount.Position paramPosition)
  {
    QQiPublicAccount.CityInfo localCityInfo = new QQiPublicAccount.CityInfo();
    Geocoder localGeocoder = new Geocoder(BaseApplicationImpl.getContext(), Locale.ENGLISH);
    if (paramPosition != null) {}
    try
    {
      for (paramPosition = localGeocoder.getFromLocation(paramPosition.latitude.get(), paramPosition.longitude.get(), 1); (paramPosition != null) && (paramPosition.size() > 0); paramPosition = localGeocoder.getFromLocation(31.222000000000001D, 121.523D, 1))
      {
        paramPosition = (Address)paramPosition.get(0);
        if (paramPosition.getAdminArea() != null) {
          localCityInfo.admin_area.set(paramPosition.getAdminArea());
        }
        if (paramPosition.getCountryName() != null) {
          localCityInfo.country.set(paramPosition.getCountryName());
        }
        if (paramPosition.getSubAdminArea() == null) {
          return localCityInfo;
        }
        localCityInfo.sub_admin_area.set(paramPosition.getSubAdminArea());
        return localCityInfo;
      }
      QLog.d("I18nPublicAccountHandler", 4, "addresses == null");
      return localCityInfo;
    }
    catch (IOException paramPosition)
    {
      QLog.d("I18nPublicAccountHandler", 4, paramPosition.getMessage());
    }
    return localCityInfo;
  }
  
  protected Class a()
  {
    return I18nPublicAccountObserver.class;
  }
  
  public void a()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.a.a(), "QQiSvc.querypublicaccountwhitelist");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    a(localToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramToServiceMsg.getServiceCmd();
    QLog.d("I18nPublicAccountHandler", 4, "ServiceCmd " + paramToServiceMsg);
    boolean bool;
    if ("QQiSvc.querypublicaccountwhitelist".equals(paramToServiceMsg))
    {
      bool = paramFromServiceMsg.isSuccess();
      if (bool) {}
    }
    int i;
    while (!"QQiSvc.queryrecommendpublicaccount".equals(paramToServiceMsg))
    {
      for (;;)
      {
        return;
        paramFromServiceMsg = new QQiPublicAccount.FetchPublicAccountWhiteListResp();
        paramToServiceMsg = new fcv();
        try
        {
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          i = paramFromServiceMsg.uint32_error_code.get();
          paramObject = paramFromServiceMsg.string_error_string.get();
          paramToServiceMsg.jdField_a_of_type_Int = i;
          paramToServiceMsg.jdField_a_of_type_JavaLangString = paramObject;
          if (i == 0)
          {
            paramObject = (I18nPublicAccountsManagerImp)this.a.getManager(53);
            if (paramObject != null) {
              paramObject.a(paramFromServiceMsg.uin64_white_account_list.get());
            }
            paramToServiceMsg.jdField_a_of_type_JavaUtilList = paramFromServiceMsg.uin64_white_account_list.get();
          }
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          for (;;)
          {
            paramToServiceMsg.jdField_a_of_type_Int = -1;
            paramFromServiceMsg.printStackTrace();
          }
        }
      }
      a(90001, bool, paramToServiceMsg);
      return;
    }
    paramToServiceMsg = new fcw();
    if (paramFromServiceMsg.isSuccess()) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new QQiPublicAccount.FetchRecomendedPublicAccountsResp();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        i = paramFromServiceMsg.uint32_error_code.get();
        paramToServiceMsg.jdField_a_of_type_Int = i;
        paramToServiceMsg.jdField_a_of_type_JavaLangString = paramFromServiceMsg.string_error_string.get();
        if (i != 0) {
          break;
        }
        paramObject = paramFromServiceMsg.list_public_account.get();
        I18nPublicAccountsManagerImp localI18nPublicAccountsManagerImp = (I18nPublicAccountsManagerImp)this.a.getManager(53);
        i = paramFromServiceMsg.uint32_next_fetch_time.get();
        if (localI18nPublicAccountsManagerImp != null) {
          localI18nPublicAccountsManagerImp.a(paramObject, i);
        }
        bool = true;
      }
      catch (Exception paramFromServiceMsg)
      {
        paramToServiceMsg.jdField_a_of_type_Int = -1;
        bool = false;
        continue;
      }
      a(90002, bool, paramToServiceMsg);
      return;
      paramToServiceMsg.jdField_a_of_type_Int = paramFromServiceMsg.getResultCode();
      bool = false;
    }
  }
  
  public void a(List paramList, long paramLong)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.a.a(), "QQiSvc.queryrecommendpublicaccount");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    QQiPublicAccount.FetchRecomendedPublicAccountsReq localFetchRecomendedPublicAccountsReq = new QQiPublicAccount.FetchRecomendedPublicAccountsReq();
    if (paramList != null) {
      localFetchRecomendedPublicAccountsReq.list_public_account_uin.set(paramList);
    }
    localFetchRecomendedPublicAccountsReq.uint32_next_fetch_time.set((int)paramLong);
    localFetchRecomendedPublicAccountsReq.language.set(String.valueOf(LocaleUtil.a()));
    QQiPublicAccount.Position localPosition = new QQiPublicAccount.Position();
    LocationManager localLocationManager = (LocationManager)BaseApplicationImpl.getContext().getSystemService("location");
    List localList = localLocationManager.getAllProviders();
    int i;
    if (localList != null)
    {
      i = 0;
      paramList = null;
      if (i < localList.size())
      {
        paramList = (String)localList.get(i);
        if (paramList != null)
        {
          paramList = localLocationManager.getLastKnownLocation(paramList);
          label153:
          if (paramList == null) {
            break label266;
          }
        }
      }
    }
    for (;;)
    {
      if (paramList != null)
      {
        localPosition.latitude.set(paramList.getLatitude());
        localPosition.longitude.set(paramList.getLongitude());
      }
      for (;;)
      {
        localFetchRecomendedPublicAccountsReq.cityPosition.set(localPosition);
        localFetchRecomendedPublicAccountsReq.cityInfo.set(a(localPosition));
        localFetchRecomendedPublicAccountsReq.ipAddress.set(I18nNetworkUtil.a());
        localFetchRecomendedPublicAccountsReq.cityPosition.setHasFlag(true);
        localFetchRecomendedPublicAccountsReq.cityInfo.setHasFlag(true);
        localFetchRecomendedPublicAccountsReq.setHasFlag(true);
        localToServiceMsg.putWupBuffer(localFetchRecomendedPublicAccountsReq.toByteArray());
        a(localToServiceMsg);
        return;
        paramList = null;
        break label153;
        label266:
        i += 1;
        break;
        localPosition.latitude.set(0.0D);
        localPosition.longitude.set(0.0D);
      }
      continue;
      paramList = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.I18nPublicAccountHandler
 * JD-Core Version:    0.7.0.1
 */