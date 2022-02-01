package cooperation.qzone;

import LBS_V2_PROTOCOL.Cell_V2;
import LBS_V2_PROTOCOL.GPS_V2;
import LBS_V2_PROTOCOL.GeoInfo_V2;
import LBS_V2_PROTOCOL.GetGeoInfoRsp_V2;
import LBS_V2_PROTOCOL.PoiInfo_V2;
import LBS_V2_PROTOCOL.Wifi_V2;
import NS_MOBILE_OPERATION.LbsInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import avph;
import avpi;
import avpj;
import avpk;
import avpl;
import avpm;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.LocalImageShootInfo;
import java.util.ArrayList;
import java.util.List;

public class LbsDataV2
{
  public static int GPS_DEFAULT_VALUE = 900000000;
  public static int LBS_REQUEST_APPID = 12103;
  public static int POI_DEFAULT_DISTANCE = 500;
  
  public static GpsInfo convertFromSoso(SosoInterface.SosoLocation paramSosoLocation)
  {
    if (paramSosoLocation == null) {
      return null;
    }
    GpsInfo localGpsInfo = new GpsInfo();
    localGpsInfo.accuracy = ((int)paramSosoLocation.accuracy);
    localGpsInfo.alt = ((int)paramSosoLocation.altitude);
    if ((paramSosoLocation.cg == 0.0D) && (paramSosoLocation.cf == 0.0D))
    {
      localGpsInfo.gpsType = 1;
      localGpsInfo.lat = ((int)(paramSosoLocation.cd * 1000000.0D));
      localGpsInfo.lon = ((int)(paramSosoLocation.ce * 1000000.0D));
      return localGpsInfo;
    }
    localGpsInfo.gpsType = 0;
    localGpsInfo.lat = ((int)(paramSosoLocation.cf * 1000000.0D));
    localGpsInfo.lon = ((int)(paramSosoLocation.cg * 1000000.0D));
    return localGpsInfo;
  }
  
  public static Cell_V2 convertToCell_V2(CellInfo paramCellInfo)
  {
    if (paramCellInfo == null) {
      return null;
    }
    Cell_V2 localCell_V2 = new Cell_V2();
    localCell_V2.shMcc = ((short)paramCellInfo.mcc);
    localCell_V2.shMnc = ((short)paramCellInfo.mnc);
    localCell_V2.iLac = paramCellInfo.lac;
    localCell_V2.iCellId = paramCellInfo.cellId;
    localCell_V2.iRssi = paramCellInfo.rssi;
    localCell_V2.dStationLat = paramCellInfo.stationLat;
    localCell_V2.dStationLon = paramCellInfo.stationLon;
    return localCell_V2;
  }
  
  public static GPS_V2 convertToGPS_V2(GpsInfo paramGpsInfo)
  {
    GPS_V2 localGPS_V2 = new GPS_V2();
    if (paramGpsInfo != null)
    {
      localGPS_V2.eType = paramGpsInfo.gpsType;
      localGPS_V2.iAlt = paramGpsInfo.alt;
      localGPS_V2.iLat = paramGpsInfo.lat;
      localGPS_V2.iLon = paramGpsInfo.lon;
    }
    return localGPS_V2;
  }
  
  public static GeoInfo convertToGeoInfo(GeoInfo_V2 paramGeoInfo_V2)
  {
    GeoInfo localGeoInfo = new GeoInfo();
    if (paramGeoInfo_V2 != null)
    {
      localGeoInfo.iDistrictCode = paramGeoInfo_V2.iDistrictCode;
      localGeoInfo.iRange = paramGeoInfo_V2.iRange;
      localGeoInfo.strCountry = paramGeoInfo_V2.strCountry;
      localGeoInfo.strProvince = paramGeoInfo_V2.strProvince;
      localGeoInfo.strCity = paramGeoInfo_V2.strCity;
      localGeoInfo.strDistrict = paramGeoInfo_V2.strDistrict;
      localGeoInfo.strTown = paramGeoInfo_V2.strTown;
      localGeoInfo.strVillage = paramGeoInfo_V2.strVillage;
      localGeoInfo.strRoad = paramGeoInfo_V2.strRoad;
      localGeoInfo.strDefaultName = paramGeoInfo_V2.strDefaultName;
    }
    return localGeoInfo;
  }
  
  public static GeoInfo convertToGeoInfo(GeoInfo_V2 paramGeoInfo_V2, GPS_V2 paramGPS_V2)
  {
    GeoInfo localGeoInfo = new GeoInfo();
    if (paramGeoInfo_V2 != null)
    {
      localGeoInfo.iDistrictCode = paramGeoInfo_V2.iDistrictCode;
      localGeoInfo.iRange = paramGeoInfo_V2.iRange;
      localGeoInfo.strCountry = paramGeoInfo_V2.strCountry;
      localGeoInfo.strProvince = paramGeoInfo_V2.strProvince;
      localGeoInfo.strCity = paramGeoInfo_V2.strCity;
      localGeoInfo.strDistrict = paramGeoInfo_V2.strDistrict;
      localGeoInfo.strTown = paramGeoInfo_V2.strTown;
      localGeoInfo.strVillage = paramGeoInfo_V2.strVillage;
      localGeoInfo.strRoad = paramGeoInfo_V2.strRoad;
      localGeoInfo.strDefaultName = paramGeoInfo_V2.strDefaultName;
    }
    localGeoInfo.gpsInfo = convertToGpsInfo(paramGPS_V2);
    return localGeoInfo;
  }
  
  public static GeoInfo_V2 convertToGeoInfo_V2(GeoInfo paramGeoInfo)
  {
    GeoInfo_V2 localGeoInfo_V2 = new GeoInfo_V2();
    if (paramGeoInfo != null)
    {
      localGeoInfo_V2.iDistrictCode = paramGeoInfo.iDistrictCode;
      localGeoInfo_V2.iRange = paramGeoInfo.iRange;
      localGeoInfo_V2.strCountry = paramGeoInfo.strCountry;
      localGeoInfo_V2.strProvince = paramGeoInfo.strProvince;
      localGeoInfo_V2.strCity = paramGeoInfo.strCity;
      localGeoInfo_V2.strDistrict = paramGeoInfo.strDistrict;
      localGeoInfo_V2.strTown = paramGeoInfo.strTown;
      localGeoInfo_V2.strVillage = paramGeoInfo.strVillage;
      localGeoInfo_V2.strRoad = paramGeoInfo.strRoad;
      localGeoInfo_V2.strDefaultName = paramGeoInfo.strDefaultName;
    }
    return localGeoInfo_V2;
  }
  
  public static GpsInfo convertToGpsInfo(GPS_V2 paramGPS_V2)
  {
    GpsInfo localGpsInfo = new GpsInfo();
    if (paramGPS_V2 != null)
    {
      localGpsInfo.gpsType = paramGPS_V2.eType;
      localGpsInfo.alt = paramGPS_V2.iAlt;
      localGpsInfo.lat = paramGPS_V2.iLat;
      localGpsInfo.lon = paramGPS_V2.iLon;
    }
    return localGpsInfo;
  }
  
  public static PoiInfo convertToPoiInfo(PoiInfo_V2 paramPoiInfo_V2)
  {
    PoiInfo localPoiInfo = new PoiInfo();
    if (paramPoiInfo_V2 != null)
    {
      localPoiInfo.address = paramPoiInfo_V2.strAddress;
      localPoiInfo.gpsInfo = convertToGpsInfo(paramPoiInfo_V2.stGps);
      localPoiInfo.city = paramPoiInfo_V2.strCity;
      localPoiInfo.country = paramPoiInfo_V2.strCity;
      localPoiInfo.districtCode = paramPoiInfo_V2.iDistrictCode;
      localPoiInfo.district = paramPoiInfo_V2.strDistrict;
      localPoiInfo.province = paramPoiInfo_V2.strProvince;
      localPoiInfo.distance = paramPoiInfo_V2.iDistance;
      localPoiInfo.poiId = paramPoiInfo_V2.strPoiId;
      localPoiInfo.poiName = paramPoiInfo_V2.strName;
      localPoiInfo.poiOrderType = paramPoiInfo_V2.iPoiOrderType;
      localPoiInfo.poiNum = paramPoiInfo_V2.iPoiNum;
      localPoiInfo.hotValue = paramPoiInfo_V2.iHotValue;
      localPoiInfo.phoneNumber = paramPoiInfo_V2.strPhone;
      localPoiInfo.poiDefaultName = paramPoiInfo_V2.strDefaultName;
      localPoiInfo.dianPingId = paramPoiInfo_V2.strDianPingId;
    }
    return localPoiInfo;
  }
  
  public static Wifi_V2 convertToWifi_V2(WifiInfo paramWifiInfo)
  {
    if (paramWifiInfo == null) {
      return null;
    }
    Wifi_V2 localWifi_V2 = new Wifi_V2();
    localWifi_V2.strMac = paramWifiInfo.mac;
    localWifi_V2.iRssi = paramWifiInfo.rssi;
    return localWifi_V2;
  }
  
  public static CellInfo covertToCellInfo(Cell_V2 paramCell_V2)
  {
    if (paramCell_V2 == null) {
      return null;
    }
    CellInfo localCellInfo = new CellInfo();
    localCellInfo.mcc = paramCell_V2.shMcc;
    localCellInfo.mnc = paramCell_V2.shMnc;
    localCellInfo.lac = paramCell_V2.iLac;
    localCellInfo.cellId = paramCell_V2.iCellId;
    localCellInfo.rssi = paramCell_V2.iRssi;
    localCellInfo.stationLat = paramCell_V2.dStationLat;
    localCellInfo.stationLon = paramCell_V2.dStationLon;
    return localCellInfo;
  }
  
  public static ArrayList<PoiInfo> fromSosoLocation(SosoInterface.SosoLocation paramSosoLocation)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramSosoLocation != null) && (paramSosoLocation.yi != null) && (!paramSosoLocation.yi.isEmpty()))
    {
      int i = 0;
      while (i < paramSosoLocation.yi.size())
      {
        PoiInfo localPoiInfo = fromTencentPoi((TencentPoi)paramSosoLocation.yi.get(i));
        localPoiInfo.country = paramSosoLocation.nation;
        localPoiInfo.province = paramSosoLocation.province;
        localPoiInfo.city = paramSosoLocation.city;
        localPoiInfo.district = paramSosoLocation.district;
        localArrayList.add(localPoiInfo);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static PoiInfo fromTencentPoi(TencentPoi paramTencentPoi)
  {
    PoiInfo localPoiInfo = new PoiInfo();
    if (paramTencentPoi != null) {
      localPoiInfo.address = paramTencentPoi.getAddress();
    }
    try
    {
      double d1 = paramTencentPoi.getLatitude();
      double d2 = paramTencentPoi.getLongitude();
      localPoiInfo.gpsInfo = new GpsInfo();
      localPoiInfo.gpsInfo.lat = ((int)(d1 * 1000000.0D));
      localPoiInfo.gpsInfo.lon = ((int)(d2 * 1000000.0D));
      localPoiInfo.gpsInfo.accuracy = -1;
      localPoiInfo.poiTypeName = paramTencentPoi.getCatalog();
      localPoiInfo.distance = ((int)paramTencentPoi.getDistance());
      localPoiInfo.poiId = paramTencentPoi.getUid();
      localPoiInfo.poiName = paramTencentPoi.getName();
      localPoiInfo.poiDefaultName = paramTencentPoi.getName();
      return localPoiInfo;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localPoiInfo.gpsInfo = null;
      }
    }
  }
  
  public static LbsInfo parceToLbsInfo(PoiInfo paramPoiInfo)
  {
    if (paramPoiInfo == null) {
      return null;
    }
    LbsInfo localLbsInfo = new LbsInfo();
    if (paramPoiInfo.gpsInfo != null)
    {
      localLbsInfo.lbs_x = String.valueOf(paramPoiInfo.gpsInfo.lon / 1000000.0D);
      localLbsInfo.lbs_y = String.valueOf(paramPoiInfo.gpsInfo.lat / 1000000.0D);
    }
    localLbsInfo.lbs_idnm = paramPoiInfo.poiDefaultName;
    if (TextUtils.isEmpty(localLbsInfo.lbs_idnm)) {
      localLbsInfo.lbs_idnm = paramPoiInfo.poiName;
    }
    localLbsInfo.lbs_nm = paramPoiInfo.address;
    localLbsInfo.s_lbs_id = paramPoiInfo.poiId;
    localLbsInfo.i_poi_num = paramPoiInfo.poiNum;
    localLbsInfo.i_poi_order_type = paramPoiInfo.poiOrderType;
    localLbsInfo.i_poi_type = paramPoiInfo.poiType;
    try
    {
      localLbsInfo.lbs_id = Integer.parseInt(paramPoiInfo.poiId);
      return localLbsInfo;
    }
    catch (Exception paramPoiInfo)
    {
      paramPoiInfo.printStackTrace();
    }
    return localLbsInfo;
  }
  
  public static LbsInfo parceToLbsInfo(LocalImageShootInfo paramLocalImageShootInfo)
  {
    Object localObject;
    if (paramLocalImageShootInfo == null) {
      localObject = null;
    }
    LbsInfo localLbsInfo;
    do
    {
      return localObject;
      localLbsInfo = new LbsInfo();
      localObject = localLbsInfo;
    } while (paramLocalImageShootInfo.a == null);
    localLbsInfo.lbs_x = String.valueOf(paramLocalImageShootInfo.a.longtitude);
    localLbsInfo.lbs_y = String.valueOf(paramLocalImageShootInfo.a.latitude);
    return localLbsInfo;
  }
  
  public static class CellInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<CellInfo> CREATOR = new avph();
    public int cellId = -1;
    public int lac = -1;
    public int mcc = -1;
    public int mnc = -1;
    public int rssi;
    public double stationLat;
    public double stationLon;
    
    public CellInfo() {}
    
    public CellInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble1, double paramDouble2)
    {
      this.mcc = paramInt1;
      this.mnc = paramInt2;
      this.lac = paramInt3;
      this.cellId = paramInt4;
      this.rssi = paramInt5;
      this.stationLat = paramDouble1;
      this.stationLon = paramDouble2;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean isValid()
    {
      return this.cellId != -1;
    }
    
    public String toString()
    {
      return "CellInfo [mcc=" + this.mcc + ", mnc=" + this.mnc + ", lac=" + this.lac + ", cellId=" + this.cellId + ", rssi=" + this.rssi + ", stationLat=" + this.stationLat + ", stationLon=" + this.stationLon + "]";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mcc);
      paramParcel.writeInt(this.mnc);
      paramParcel.writeInt(this.lac);
      paramParcel.writeInt(this.cellId);
      paramParcel.writeInt(this.rssi);
      paramParcel.writeDouble(this.stationLat);
      paramParcel.writeDouble(this.stationLon);
    }
  }
  
  public static class GeoInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<GeoInfo> CREATOR = new avpi();
    public String address;
    public LbsDataV2.GpsInfo gpsInfo;
    public int iDistrictCode;
    public int iRange = -1;
    public String strCity = "";
    public String strCountry = "";
    public String strDefaultName = "";
    public String strDistrict = "";
    public String strProvince = "";
    public String strRoad = "";
    public String strTown = "";
    public String strVillage = "";
    
    public GeoInfo() {}
    
    public GeoInfo(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
    {
      this.iDistrictCode = paramInt1;
      this.iRange = paramInt2;
      this.strCountry = paramString1;
      this.strProvince = paramString2;
      this.strCity = paramString3;
      this.strDistrict = paramString4;
      this.strTown = paramString5;
      this.strVillage = paramString6;
      this.strRoad = paramString7;
      this.strDefaultName = paramString8;
    }
    
    public GeoInfo clone()
    {
      GeoInfo localGeoInfo = new GeoInfo();
      localGeoInfo.address = this.address;
      localGeoInfo.iDistrictCode = this.iDistrictCode;
      localGeoInfo.iRange = this.iRange;
      localGeoInfo.strCountry = this.strCountry;
      localGeoInfo.strProvince = this.strProvince;
      localGeoInfo.strCity = this.strCity;
      localGeoInfo.strDistrict = this.strDistrict;
      localGeoInfo.strTown = this.strTown;
      localGeoInfo.strVillage = this.strVillage;
      localGeoInfo.strRoad = this.strRoad;
      localGeoInfo.strDefaultName = this.strDefaultName;
      if (this.gpsInfo != null) {
        localGeoInfo.gpsInfo = this.gpsInfo.clone();
      }
      return localGeoInfo;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean isValid()
    {
      return (!TextUtils.isEmpty(this.strCountry)) || (!TextUtils.isEmpty(this.strProvince)) || (!TextUtils.isEmpty(this.strCity)) || (!TextUtils.isEmpty(this.strDistrict));
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.address);
      paramParcel.writeInt(this.iDistrictCode);
      paramParcel.writeInt(this.iRange);
      paramParcel.writeString(this.strCountry);
      paramParcel.writeString(this.strProvince);
      paramParcel.writeString(this.strCity);
      paramParcel.writeString(this.strDistrict);
      paramParcel.writeString(this.strTown);
      paramParcel.writeString(this.strVillage);
      paramParcel.writeString(this.strRoad);
      paramParcel.writeString(this.strDefaultName);
      paramParcel.writeParcelable(this.gpsInfo, paramInt);
    }
  }
  
  public static class GetGeoInfoRsp
    implements Parcelable
  {
    public static final Parcelable.Creator<GetGeoInfoRsp> CREATOR = new avpj();
    public LbsDataV2.GeoInfo stGeoInfo;
    public LbsDataV2.GpsInfo stGps;
    
    public GetGeoInfoRsp() {}
    
    public GetGeoInfoRsp(LbsDataV2.GpsInfo paramGpsInfo, LbsDataV2.GeoInfo paramGeoInfo)
    {
      this.stGps = paramGpsInfo;
      this.stGeoInfo = paramGeoInfo;
    }
    
    public static GetGeoInfoRsp_V2 convertTo(GetGeoInfoRsp paramGetGeoInfoRsp)
    {
      GetGeoInfoRsp_V2 localGetGeoInfoRsp_V2 = new GetGeoInfoRsp_V2();
      if (paramGetGeoInfoRsp != null)
      {
        localGetGeoInfoRsp_V2.stGeoInfo = LbsDataV2.convertToGeoInfo_V2(paramGetGeoInfoRsp.stGeoInfo);
        localGetGeoInfoRsp_V2.stGps = LbsDataV2.convertToGPS_V2(paramGetGeoInfoRsp.stGps);
      }
      return localGetGeoInfoRsp_V2;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "GetGeoInfoRsp:{" + this.stGps + ", " + this.stGeoInfo + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(this.stGps, paramInt);
      paramParcel.writeParcelable(this.stGeoInfo, paramInt);
    }
  }
  
  public static class GpsInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<GpsInfo> CREATOR = new avpk();
    public int accuracy;
    public int alt = -10000000;
    public int gpsType = 0;
    public int lat = LbsDataV2.GPS_DEFAULT_VALUE;
    public int lon = LbsDataV2.GPS_DEFAULT_VALUE;
    
    public GpsInfo()
    {
      reset();
    }
    
    public GpsInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.lat = paramInt1;
      this.lon = paramInt2;
      this.alt = paramInt3;
      this.gpsType = paramInt4;
      this.accuracy = paramInt5;
    }
    
    public GpsInfo clone()
    {
      return new GpsInfo(this.lat, this.lon, this.alt, this.gpsType, this.accuracy);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean isValid()
    {
      return (this.lat != LbsDataV2.GPS_DEFAULT_VALUE) && (this.lon != LbsDataV2.GPS_DEFAULT_VALUE);
    }
    
    public void reset()
    {
      this.lat = LbsDataV2.GPS_DEFAULT_VALUE;
      this.lon = LbsDataV2.GPS_DEFAULT_VALUE;
      this.alt = -10000000;
      this.gpsType = 0;
      this.accuracy = -1;
    }
    
    public String toString()
    {
      return "lat: " + this.lat + ", lon: " + this.lon + ", alt: " + this.alt + ", gpsType: " + this.gpsType + ", accuracy: " + this.accuracy;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.lat);
      paramParcel.writeInt(this.lon);
      paramParcel.writeInt(this.alt);
      paramParcel.writeInt(this.gpsType);
      paramParcel.writeInt(this.accuracy);
    }
  }
  
  public static class PoiInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<PoiInfo> CREATOR = new avpl();
    public String address;
    public String city = "";
    public String country = "";
    public String dianPingId = "";
    public int distance;
    public String district = "";
    public int districtCode;
    public LbsDataV2.GpsInfo gpsInfo = new LbsDataV2.GpsInfo();
    public int hotValue;
    public String phoneNumber = "";
    public String poiDefaultName;
    public String poiId;
    public String poiName;
    public int poiNum;
    public int poiOrderType;
    public int poiType;
    public String poiTypeName;
    public String province = "";
    public int show_poi;
    
    public static PoiInfo clone(PoiInfo paramPoiInfo)
    {
      LbsDataV2.GpsInfo localGpsInfo = null;
      if (paramPoiInfo == null) {
        return null;
      }
      PoiInfo localPoiInfo = new PoiInfo();
      localPoiInfo.address = paramPoiInfo.address;
      localPoiInfo.dianPingId = paramPoiInfo.dianPingId;
      localPoiInfo.distance = paramPoiInfo.distance;
      localPoiInfo.districtCode = paramPoiInfo.districtCode;
      if (paramPoiInfo.gpsInfo != null) {
        localGpsInfo = paramPoiInfo.gpsInfo.clone();
      }
      localPoiInfo.gpsInfo = localGpsInfo;
      localPoiInfo.hotValue = paramPoiInfo.hotValue;
      localPoiInfo.phoneNumber = paramPoiInfo.phoneNumber;
      localPoiInfo.poiDefaultName = paramPoiInfo.poiDefaultName;
      localPoiInfo.poiId = paramPoiInfo.poiId;
      localPoiInfo.poiName = paramPoiInfo.poiName;
      localPoiInfo.poiNum = paramPoiInfo.poiNum;
      localPoiInfo.poiOrderType = paramPoiInfo.poiOrderType;
      localPoiInfo.poiType = paramPoiInfo.poiType;
      localPoiInfo.poiTypeName = paramPoiInfo.poiTypeName;
      localPoiInfo.show_poi = paramPoiInfo.show_poi;
      localPoiInfo.city = paramPoiInfo.city;
      localPoiInfo.province = paramPoiInfo.province;
      localPoiInfo.country = paramPoiInfo.country;
      localPoiInfo.district = paramPoiInfo.district;
      return localPoiInfo;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == null) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      return ((PoiInfo)paramObject).poiId.equals(this.poiId);
    }
    
    public String toString()
    {
      if (this.gpsInfo != null) {
        return " poiId: " + this.poiId + " poiName: " + this.poiName + " poiType: " + this.poiType + " poiTypeName: " + this.poiTypeName + " address: " + this.address + " districtCode: " + this.districtCode + " distance: " + this.distance + " phoneNumber: " + this.phoneNumber + "poiOrderType: " + this.poiOrderType + "poiNum: " + this.poiNum + " gpsInfo: " + this.gpsInfo.toString() + " ";
      }
      return "poiId: " + this.poiId + "poiName: " + this.poiName + "poiType: " + this.poiType + "poiTypeName: " + this.poiTypeName + "address: " + this.address + "districtCode: " + this.districtCode + "distance: " + this.distance + "phoneNumber: " + this.phoneNumber + "poiOrderType: " + this.poiOrderType + "poiNum: " + this.poiNum + " dianPingId:" + this.dianPingId;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.poiId);
      paramParcel.writeString(this.poiName);
      paramParcel.writeInt(this.poiType);
      paramParcel.writeString(this.poiTypeName);
      paramParcel.writeString(this.poiDefaultName);
      paramParcel.writeString(this.address);
      paramParcel.writeInt(this.districtCode);
      paramParcel.writeInt(this.distance);
      paramParcel.writeInt(this.hotValue);
      paramParcel.writeString(this.phoneNumber);
      paramParcel.writeInt(this.poiOrderType);
      paramParcel.writeInt(this.poiNum);
      paramParcel.writeString(this.dianPingId);
      paramParcel.writeParcelable(this.gpsInfo, paramInt);
      paramParcel.writeInt(this.show_poi);
      paramParcel.writeString(this.country);
      paramParcel.writeString(this.province);
      paramParcel.writeString(this.city);
      paramParcel.writeString(this.district);
    }
  }
  
  public static class PoiList
  {
    public GetGeoInfoRsp_V2 geoInfo;
    public ArrayList<LbsDataV2.PoiInfo> poiInfos = new ArrayList();
    public LbsDataV2.GpsInfo userGpsInfo;
  }
  
  public static class WifiInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<WifiInfo> CREATOR = new avpm();
    public String mac = "";
    public int rssi;
    
    public WifiInfo() {}
    
    public WifiInfo(String paramString, int paramInt)
    {
      this.mac = paramString;
      this.rssi = paramInt;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "WifiInfo [mac=" + this.mac + ", rssi=" + this.rssi + "]";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mac);
      paramParcel.writeInt(this.rssi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.LbsDataV2
 * JD-Core Version:    0.7.0.1
 */