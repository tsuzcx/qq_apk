package cooperation.qzone.model;

import NS_MOBILE_MATERIAL.MaterialFile;
import NS_MOBILE_MATERIAL.MaterialItem;
import NS_MOBILE_PHOTO.Album;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import avuj;
import com.tencent.qphone.base.util.BaseApplication;

public class BusinessAlbumInfo
  extends BaseBusinessAlbumInfo
{
  public static final Parcelable.Creator<BusinessAlbumInfo> CREATOR = new avuj();
  
  private BusinessAlbumInfo(Parcel paramParcel)
  {
    this.mUin = paramParcel.readLong();
    this.mAlbumId = paramParcel.readString();
    this.ahT = paramParcel.readInt();
    this.mTotal = paramParcel.readInt();
    this.Hl = paramParcel.readString();
    this.mTitle = paramParcel.readString();
    this.aAs = paramParcel.readLong();
    this.mAlbumType = paramParcel.readInt();
    this.aAt = paramParcel.readLong();
    this.eyD = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.doR = bool;
      this.opmask = paramParcel.readInt();
      this.allow_share = paramParcel.readInt();
      this.cNU = paramParcel.readString();
      this.eyE = paramParcel.readInt();
      this.eyF = paramParcel.readInt();
      this.sortType = paramParcel.readInt();
      return;
      bool = false;
    }
  }
  
  public BusinessAlbumInfo(String paramString)
  {
    super(paramString);
  }
  
  public static BusinessAlbumInfo a(Album paramAlbum)
  {
    boolean bool = true;
    if (paramAlbum == null) {
      return null;
    }
    BusinessAlbumInfo localBusinessAlbumInfo = new BusinessAlbumInfo(paramAlbum.albumid);
    localBusinessAlbumInfo.ahT = paramAlbum.priv;
    localBusinessAlbumInfo.mTitle = paramAlbum.name;
    localBusinessAlbumInfo.mTotal = paramAlbum.total;
    localBusinessAlbumInfo.mUin = paramAlbum.uin;
    localBusinessAlbumInfo.mAlbumType = paramAlbum.type;
    localBusinessAlbumInfo.aAt = paramAlbum.svrtime;
    localBusinessAlbumInfo.Hl = paramAlbum.coverurl;
    if ((aZ(paramAlbum.type) == 1) && (paramAlbum.material != null) && (paramAlbum.individual != 0L)) {}
    for (;;)
    {
      localBusinessAlbumInfo.doR = bool;
      localBusinessAlbumInfo.opmask = paramAlbum.opmask;
      localBusinessAlbumInfo.allow_share = paramAlbum.allow_share;
      localBusinessAlbumInfo.cNU = a(paramAlbum);
      localBusinessAlbumInfo.eyE = paramAlbum.is_share;
      localBusinessAlbumInfo.sortType = paramAlbum.sort_type;
      return localBusinessAlbumInfo;
      bool = false;
    }
  }
  
  public static BusinessAlbumInfo a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new BusinessAlbumInfo(paramString);
  }
  
  public static BusinessAlbumInfo a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4, long paramLong, int paramInt5, int paramInt6, boolean paramBoolean1, String paramString4, boolean paramBoolean2)
  {
    paramString1 = new BusinessAlbumInfo(paramString1);
    paramString1.mAlbumType = paramInt1;
    paramString1.mTitle = paramString2;
    paramString1.Hl = paramString3;
    paramString1.ahT = paramInt2;
    paramString1.mTotal = paramInt3;
    paramString1.eyD = paramInt4;
    boolean bool;
    if (paramLong == 1L)
    {
      bool = true;
      paramString1.doR = bool;
      paramString1.opmask = paramInt5;
      paramString1.allow_share = paramInt6;
      if (!paramBoolean1) {
        break label115;
      }
      paramInt1 = 1;
      label77:
      paramString1.eyE = paramInt1;
      if (paramLong == 1L) {
        paramString1.cNU = paramString4;
      }
      if (!paramBoolean2) {
        break label120;
      }
    }
    label115:
    label120:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString1.eyF = paramInt1;
      return paramString1;
      bool = false;
      break;
      paramInt1 = 0;
      break label77;
    }
  }
  
  public static String a(Album paramAlbum)
  {
    if ((paramAlbum == null) || (paramAlbum.individual != 1L) || (paramAlbum.material == null)) {}
    while ((paramAlbum.material.stBanner == null) || (TextUtils.isEmpty(paramAlbum.material.stBanner.strUrl))) {
      return null;
    }
    return paramAlbum.material.stBanner.strUrl;
  }
  
  public static int aZ(int paramInt)
  {
    int i = 8;
    if (paramInt == 8) {
      i = 5;
    }
    do
    {
      return i;
      if (paramInt == 9) {
        return 6;
      }
    } while (paramInt == 11);
    return 1;
  }
  
  public static String ai(int paramInt)
  {
    int j = 0;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    while (i == 0)
    {
      return null;
      i = 2131717939;
      continue;
      i = 2131717940;
      continue;
      i = 2131717686;
      continue;
      i = 2131717684;
      continue;
      i = 2131717689;
      continue;
      i = 2131717685;
    }
    return BaseApplication.getContext().getResources().getString(i);
  }
  
  public String GD()
  {
    return a.dY(this.ahT);
  }
  
  public boolean aLH()
  {
    return this.eyE == 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (BusinessAlbumInfo)paramObject;
        if (this.mAlbumId != null) {
          break;
        }
      } while (paramObject.mAlbumId == null);
      return false;
    } while (this.mAlbumId.equals(paramObject.mAlbumId));
    return false;
  }
  
  public int hashCode()
  {
    if (this.mAlbumId == null) {}
    for (int i = 0;; i = this.mAlbumId.hashCode()) {
      return i + 31;
    }
  }
  
  public static class a
  {
    public static String dY(int paramInt)
    {
      return BusinessAlbumInfo.ai(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.model.BusinessAlbumInfo
 * JD-Core Version:    0.7.0.1
 */