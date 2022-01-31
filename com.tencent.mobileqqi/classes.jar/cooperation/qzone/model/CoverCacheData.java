package cooperation.qzone.model;

import NS_MOBILE_COVER_DATE.CoverPackageInfo;
import NS_MOBILE_COVER_DATE.feeds_cover;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ihb;
import ihc;
import java.util.ArrayList;
import java.util.HashMap;

public class CoverCacheData
  extends DbCacheData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ihc();
  public static final DbCacheData.DbCreator DB_CREATOR = new ihb();
  public static final String JIGSAW = "jigsaw";
  public static final String LOCAL_URL = "local_url";
  public static final String PACKAGE_INFO = "package_info";
  public static final String PHOTO_WALL = "photo_wall";
  public static final String TYPE = "type";
  public static final String TYPE_JIGSAW = "INTEGER";
  public static final String TYPE_LOCAL_URL = "TEXT";
  public static final String TYPE_PACKAGE_DATA = "BLOB";
  public static final String TYPE_PHOTO_WALL = "BLOB";
  public static final String TYPE_TYPE = "TEXT";
  public static final String TYPE_UIN = "INTEGER";
  public static final String TYPE_URLS = "BLOB";
  public static final String UIN = "uin";
  public static final String URLS = "urls";
  public static final int VERSION = 5;
  public int isJigsawOpen = 0;
  public String local_url = "";
  public CoverCacheData.PackageInfo packageInfo;
  public ArrayList photoWall = new ArrayList();
  public String type = "";
  public long uin = 0L;
  public HashMap urls = new HashMap();
  
  public static CoverCacheData createFromResponse(long paramLong, feeds_cover paramfeeds_cover)
  {
    Object localObject;
    if (paramfeeds_cover == null) {
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
        localCoverCacheData.type = paramfeeds_cover.type;
        if (paramfeeds_cover.MulRelsotionUrl != null) {
          localCoverCacheData.urls.putAll(paramfeeds_cover.MulRelsotionUrl);
        }
        if (paramfeeds_cover.packageInfo != null)
        {
          localCoverCacheData.packageInfo = new CoverCacheData.PackageInfo();
          localCoverCacheData.packageInfo.jdField_a_of_type_JavaLangString = paramfeeds_cover.packageInfo.prePic;
          localCoverCacheData.packageInfo.jdField_b_of_type_JavaLangString = paramfeeds_cover.packageInfo.PackageUrl;
          localCoverCacheData.packageInfo.jdField_c_of_type_JavaLangString = paramfeeds_cover.packageInfo.md5;
          localCoverCacheData.packageInfo.jdField_a_of_type_Int = paramfeeds_cover.packageInfo.weather;
          localCoverCacheData.packageInfo.jdField_b_of_type_Int = paramfeeds_cover.packageInfo.daytime;
          localCoverCacheData.packageInfo.jdField_c_of_type_Int = paramfeeds_cover.packageInfo.coverStyle;
        }
        localObject = localCoverCacheData;
      } while (paramfeeds_cover.vecUrls == null);
      localObject = localCoverCacheData;
    } while (paramfeeds_cover.vecUrls.size() <= 0);
    localCoverCacheData.photoWall.addAll(paramfeeds_cover.vecUrls);
    return localCoverCacheData;
  }
  
  public static CoverCacheData createFromResponse(long paramLong, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp)
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
        if (parammobile_sub_get_cover_rsp.MulRelsotionUrl != null) {
          localCoverCacheData.urls.putAll(parammobile_sub_get_cover_rsp.MulRelsotionUrl);
        }
        if (parammobile_sub_get_cover_rsp.packageInfo != null)
        {
          localCoverCacheData.packageInfo = new CoverCacheData.PackageInfo();
          localCoverCacheData.packageInfo.jdField_a_of_type_JavaLangString = parammobile_sub_get_cover_rsp.packageInfo.prePic;
          localCoverCacheData.packageInfo.jdField_b_of_type_JavaLangString = parammobile_sub_get_cover_rsp.packageInfo.PackageUrl;
          localCoverCacheData.packageInfo.jdField_c_of_type_JavaLangString = parammobile_sub_get_cover_rsp.packageInfo.md5;
          localCoverCacheData.packageInfo.jdField_a_of_type_Int = parammobile_sub_get_cover_rsp.packageInfo.weather;
          localCoverCacheData.packageInfo.jdField_b_of_type_Int = parammobile_sub_get_cover_rsp.packageInfo.daytime;
          localCoverCacheData.packageInfo.jdField_c_of_type_Int = parammobile_sub_get_cover_rsp.packageInfo.coverStyle;
        }
        localObject = localCoverCacheData;
      } while (parammobile_sub_get_cover_rsp.vecUrls == null);
      localObject = localCoverCacheData;
    } while (parammobile_sub_get_cover_rsp.vecUrls.size() <= 0);
    localCoverCacheData.photoWall.addAll(parammobile_sub_get_cover_rsp.vecUrls);
    return localCoverCacheData;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeTo(ContentValues paramContentValues)
  {
    paramContentValues.put("uin", Long.valueOf(this.uin));
    paramContentValues.put("type", this.type);
    paramContentValues.put("local_url", this.local_url);
    paramContentValues.put("jigsaw", Integer.valueOf(this.isJigsawOpen));
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    localParcel.writeMap(this.urls);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    paramContentValues.put("urls", arrayOfByte);
    localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    localParcel.writeParcelable(this.packageInfo, 0);
    arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    paramContentValues.put("package_info", arrayOfByte);
    localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    localParcel.writeList(this.photoWall);
    arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    paramContentValues.put("photo_wall", arrayOfByte);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.uin);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.local_url);
    paramParcel.writeMap(this.urls);
    paramParcel.writeParcelable(this.packageInfo, paramInt);
    paramParcel.writeList(this.photoWall);
    paramParcel.writeInt(this.isJigsawOpen);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.model.CoverCacheData
 * JD-Core Version:    0.7.0.1
 */