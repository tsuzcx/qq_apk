package cooperation.qzone.model;

import NS_MOBILE_COVER_DATE.CoverPackageInfo;
import NS_MOBILE_COVER_DATE.GameCoverInfo;
import NS_MOBILE_COVER_DATE.feeds_cover;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avuk;
import avul;
import avum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CoverCacheData
  implements Parcelable
{
  public static final Parcelable.Creator<CoverCacheData> CREATOR = new avuk();
  public ArrayList<Map<Integer, String>> EY = new ArrayList();
  public GameCoverInfo a;
  public PackageInfo a;
  public int alian;
  public String cNV = "";
  public String coverId = "";
  public HashMap<String, String> cy = new HashMap();
  public int eyG;
  public HashMap<String, String> qI = new HashMap();
  public HashMap<String, String> qJ;
  public String type = "";
  public long uin;
  
  public static CoverCacheData a(long paramLong, feeds_cover paramfeeds_cover)
  {
    Object localObject;
    if (paramfeeds_cover == null) {
      localObject = null;
    }
    CoverCacheData localCoverCacheData;
    do
    {
      return localObject;
      localCoverCacheData = new CoverCacheData();
      localCoverCacheData.uin = paramLong;
      localCoverCacheData.coverId = paramfeeds_cover.id;
      localCoverCacheData.type = paramfeeds_cover.type;
      localCoverCacheData.eyG = paramfeeds_cover.photoWallCombinePic;
      if (paramfeeds_cover.MulRelsotionUrl != null) {
        localCoverCacheData.cy.putAll(paramfeeds_cover.MulRelsotionUrl);
      }
      if (paramfeeds_cover.packageInfo != null)
      {
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo = new PackageInfo();
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.prePic = paramfeeds_cover.packageInfo.prePic;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.PackageUrl = paramfeeds_cover.packageInfo.PackageUrl;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.md5 = paramfeeds_cover.packageInfo.md5;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.weather = paramfeeds_cover.packageInfo.weather;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.eyH = paramfeeds_cover.packageInfo.daytime;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.coverStyle = paramfeeds_cover.packageInfo.coverStyle;
      }
      if (paramfeeds_cover.gameCoverInfo != null)
      {
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo = new GameCoverInfo();
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo.xCoordLU = paramfeeds_cover.gameCoverInfo.xCoordLU;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo.yCoordLU = paramfeeds_cover.gameCoverInfo.yCoordLU;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo.xCoordRD = paramfeeds_cover.gameCoverInfo.xCoordRD;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo.yCoordRD = paramfeeds_cover.gameCoverInfo.yCoordRD;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo.jmpUrl = paramfeeds_cover.gameCoverInfo.jmpUrl;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo.schema = paramfeeds_cover.gameCoverInfo.schema;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo.jmpType = paramfeeds_cover.gameCoverInfo.jmpType;
      }
      if ((paramfeeds_cover.vecUrls != null) && (paramfeeds_cover.vecUrls.size() > 0)) {
        localCoverCacheData.EY.addAll(paramfeeds_cover.vecUrls);
      }
      localObject = localCoverCacheData;
    } while (paramfeeds_cover.mapExtInfo == null);
    localCoverCacheData.qI.putAll(paramfeeds_cover.mapExtInfo);
    return localCoverCacheData;
  }
  
  public static CoverCacheData a(long paramLong, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp)
  {
    Object localObject;
    if (parammobile_sub_get_cover_rsp == null) {
      localObject = null;
    }
    CoverCacheData localCoverCacheData;
    do
    {
      do
      {
        return localObject;
        localCoverCacheData = new CoverCacheData();
        localCoverCacheData.uin = paramLong;
        localCoverCacheData.type = parammobile_sub_get_cover_rsp.type;
        localCoverCacheData.eyG = parammobile_sub_get_cover_rsp.photoWallCombinePic;
        if (parammobile_sub_get_cover_rsp.MulRelsotionUrl != null) {
          localCoverCacheData.cy.putAll(parammobile_sub_get_cover_rsp.MulRelsotionUrl);
        }
        if (parammobile_sub_get_cover_rsp.packageInfo != null)
        {
          localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo = new PackageInfo();
          localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.prePic = parammobile_sub_get_cover_rsp.packageInfo.prePic;
          localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.PackageUrl = parammobile_sub_get_cover_rsp.packageInfo.PackageUrl;
          localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.md5 = parammobile_sub_get_cover_rsp.packageInfo.md5;
          localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.weather = parammobile_sub_get_cover_rsp.packageInfo.weather;
          localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.eyH = parammobile_sub_get_cover_rsp.packageInfo.daytime;
          localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.coverStyle = parammobile_sub_get_cover_rsp.packageInfo.coverStyle;
        }
        localObject = localCoverCacheData;
      } while (parammobile_sub_get_cover_rsp.vecUrls == null);
      localObject = localCoverCacheData;
    } while (parammobile_sub_get_cover_rsp.vecUrls.size() <= 0);
    localCoverCacheData.EY.addAll(parammobile_sub_get_cover_rsp.vecUrls);
    return localCoverCacheData;
  }
  
  public boolean aLI()
  {
    return ("CustomVideoCover".equals(this.type)) || ("VideoCover".equals(this.type));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.uin);
    paramParcel.writeString(this.coverId);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.cNV);
    paramParcel.writeMap(this.cy);
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo, paramInt);
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo, paramInt);
    paramParcel.writeList(this.EY);
    paramParcel.writeInt(this.eyG);
    paramParcel.writeMap(this.qI);
    paramParcel.writeMap(this.qJ);
    paramParcel.writeInt(this.alian);
  }
  
  public static class GameCoverInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<GameCoverInfo> CREATOR = new avul();
    public int jmpType;
    public String jmpUrl = "";
    public String schema = "";
    public double xCoordLU;
    public double xCoordRD;
    public double yCoordLU;
    public double yCoordRD;
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeDouble(this.xCoordLU);
      paramParcel.writeDouble(this.yCoordLU);
      paramParcel.writeDouble(this.xCoordRD);
      paramParcel.writeDouble(this.yCoordRD);
      paramParcel.writeString(this.jmpUrl);
      paramParcel.writeString(this.schema);
      paramParcel.writeInt(this.jmpType);
    }
  }
  
  public static class PackageInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<PackageInfo> CREATOR = new avum();
    public String PackageUrl;
    public String cNW;
    public int coverStyle = -1;
    public int eyH;
    public String md5;
    public String prePic;
    public int weather;
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.prePic);
      paramParcel.writeString(this.PackageUrl);
      paramParcel.writeString(this.md5);
      paramParcel.writeInt(this.weather);
      paramParcel.writeInt(this.eyH);
      paramParcel.writeInt(this.coverStyle);
      paramParcel.writeString(this.cNW);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.model.CoverCacheData
 * JD-Core Version:    0.7.0.1
 */