import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images.Thumbnails;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.SerializationPB.PicInfo;
import com.tencent.biz.qqstory.database.StoryAlbumPicEntry;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;

public class uja
{
  public double a;
  public int a;
  public long a;
  public AddressItem a;
  private LocalMediaInfo a;
  public String a;
  public double b;
  public int b;
  public long b;
  @Deprecated
  public String b;
  public int c;
  public long c;
  public String c;
  private int d;
  public long d;
  public String d;
  public long e;
  
  public Bitmap a(Context paramContext, int paramInt, BitmapFactory.Options paramOptions)
  {
    
    if (paramContext == null)
    {
      xqq.a("Need the context to get thumbnail!", new Object[0]);
      return null;
    }
    if ((paramInt != 1) && (paramInt != 3))
    {
      xqq.a("kind is illegal", new Object[0]);
      return null;
    }
    return MediaStore.Images.Thumbnails.getThumbnail(paramContext.getContentResolver(), this.jdField_a_of_type_Long, paramInt, paramOptions);
  }
  
  public SerializationPB.PicInfo a()
  {
    SerializationPB.PicInfo localPicInfo = new SerializationPB.PicInfo();
    localPicInfo.id.set(this.jdField_a_of_type_Long);
    PBStringField localPBStringField = localPicInfo.path;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      str = "";
      localPBStringField.set(str);
      localPBStringField = localPicInfo.thumb;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label196;
      }
    }
    label196:
    for (String str = "";; str = this.jdField_b_of_type_JavaLangString)
    {
      localPBStringField.set(str);
      localPicInfo.width.set(this.jdField_a_of_type_Int);
      localPicInfo.height.set(this.jdField_b_of_type_Int);
      localPicInfo.orientation.set(this.jdField_c_of_type_Int);
      localPicInfo.create_time.set(this.jdField_b_of_type_Long);
      localPicInfo.lat.set(this.jdField_a_of_type_Double);
      localPicInfo.lng.set(this.jdField_b_of_type_Double);
      localPicInfo.geo_hash.set(this.jdField_c_of_type_JavaLangString);
      localPicInfo.state.set(this.jdField_d_of_type_Int);
      localPicInfo.mime.set(this.jdField_d_of_type_JavaLangString);
      localPicInfo.size.set(this.e);
      localPicInfo.db_create_time.set(this.jdField_d_of_type_Long);
      return localPicInfo;
      str = this.jdField_a_of_type_JavaLangString;
      break;
    }
  }
  
  public StoryAlbumPicEntry a()
  {
    StoryAlbumPicEntry localStoryAlbumPicEntry = new StoryAlbumPicEntry();
    localStoryAlbumPicEntry.path = this.jdField_a_of_type_JavaLangString;
    localStoryAlbumPicEntry.thumbPath = this.jdField_b_of_type_JavaLangString;
    localStoryAlbumPicEntry.width = this.jdField_a_of_type_Int;
    localStoryAlbumPicEntry.height = this.jdField_b_of_type_Int;
    localStoryAlbumPicEntry.orientation = this.jdField_c_of_type_Int;
    localStoryAlbumPicEntry.createTime = this.jdField_b_of_type_Long;
    localStoryAlbumPicEntry.gpsLat = this.jdField_a_of_type_Double;
    localStoryAlbumPicEntry.gpsLng = this.jdField_b_of_type_Double;
    localStoryAlbumPicEntry.geohashString = this.jdField_c_of_type_JavaLangString;
    localStoryAlbumPicEntry.state = this.jdField_d_of_type_Int;
    localStoryAlbumPicEntry.mime = this.jdField_d_of_type_JavaLangString;
    localStoryAlbumPicEntry.size = this.e;
    return localStoryAlbumPicEntry;
  }
  
  public LocalMediaInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo._id = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.orientation = this.jdField_c_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mMimeType = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.fileSize = this.e;
      LocalMediaInfo localLocalMediaInfo1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      LocalMediaInfo localLocalMediaInfo2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      int i = AlbumThumbDownloader.THUMB_WIDHT;
      localLocalMediaInfo2.thumbHeight = i;
      localLocalMediaInfo1.thumbWidth = i;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  }
  
  public void a(SerializationPB.PicInfo paramPicInfo)
  {
    this.jdField_a_of_type_Long = paramPicInfo.id.get();
    this.jdField_a_of_type_JavaLangString = paramPicInfo.path.get();
    this.jdField_b_of_type_JavaLangString = paramPicInfo.thumb.get();
    this.jdField_a_of_type_Int = paramPicInfo.width.get();
    this.jdField_b_of_type_Int = paramPicInfo.height.get();
    this.jdField_c_of_type_Int = paramPicInfo.orientation.get();
    this.jdField_b_of_type_Long = paramPicInfo.create_time.get();
    this.jdField_a_of_type_Double = paramPicInfo.lat.get();
    this.jdField_b_of_type_Double = paramPicInfo.lng.get();
    this.jdField_c_of_type_JavaLangString = paramPicInfo.geo_hash.get();
    this.jdField_d_of_type_Int = paramPicInfo.state.get();
    this.jdField_d_of_type_JavaLangString = paramPicInfo.mime.get();
    this.e = paramPicInfo.size.get();
    this.jdField_d_of_type_Long = paramPicInfo.db_create_time.get();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_d_of_type_Int = i;
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Int == 1;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof uja)) {
      return this.jdField_a_of_type_JavaLangString.equals(((uja)paramObject).jdField_a_of_type_JavaLangString);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PicInfo=[");
    localStringBuilder.append(" mId:").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" mPath:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" mThumbPath:").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" width:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" height:").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" orientation:").append(this.jdField_c_of_type_Int);
    localStringBuilder.append(" mCreateTime:").append(this.jdField_b_of_type_Long);
    localStringBuilder.append(" mDBCreateTime:").append(this.jdField_d_of_type_Long);
    localStringBuilder.append(" mGpsLat:").append(this.jdField_a_of_type_Double);
    localStringBuilder.append(" mGpsLng:").append(this.jdField_b_of_type_Double);
    localStringBuilder.append(" mGeohashString:").append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(" mState:").append(this.jdField_d_of_type_Int);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uja
 * JD-Core Version:    0.7.0.1
 */