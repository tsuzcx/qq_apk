package cooperation.qzone.model;

import NS_FASHION_FEEDS_TAG_PROTO.TagInfo;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avuu;
import awcp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;
import sxy;

public class PhotoInfo
  extends sxy
  implements Parcelable
{
  public static final Parcelable.Creator<PhotoInfo> CREATOR = new avuu();
  public static int SHOW_GIF;
  public static int SHOW_NEITHER_GIF_NOR_PLAY = 1;
  public static int SHOW_STATIC_PHOTO;
  public ArrayList<String> EZ = new ArrayList();
  public ArrayList<TagInfo> Fa;
  public ArrayList<FaceData> Fb;
  public GpsInfo4LocalImage a;
  public VideoInfo a;
  public long aAu;
  public long aAv;
  public Boolean aZ;
  public String albumId = "";
  public String albumName;
  public int albumPriv;
  public int allow_share;
  public int appid;
  public String bigUrl = "";
  private WeakReference<Drawable> br;
  private WeakReference<Drawable> bs;
  public Map<Integer, String> busi_param = new HashMap();
  public String cOb = "";
  public String cOc = "";
  public String cOd = "";
  public int commentCount;
  public long ctime;
  public String curkey = "";
  public String currentUrl = "";
  public long date;
  public String desc = "";
  public boolean doU;
  public boolean doV;
  public boolean doW;
  public boolean doX;
  public boolean doY;
  public int eyI;
  public int eyJ;
  public long fileSize;
  public int flag;
  public boolean hasLoaded;
  public Boolean hasLocalOrgFile;
  public boolean hasPreDownload;
  public Boolean hasQRCode;
  public boolean hasVisited;
  public boolean isFakeFeed;
  public int isIndependentUgc = -1;
  public boolean isSelected;
  public float lastScale;
  public String lloc = "";
  public int opMask;
  public int opsynflag;
  public String orgUrl = "";
  public int photoOpmask;
  public int photoType = 1;
  public int praiseCount;
  public int progress;
  public Map<Integer, String> pssBusiParam;
  public String pssCellId = "";
  public String pssCellSubId = "";
  public String pssCurLikeKey = "";
  public boolean pssHasFeedPraise;
  public String pssOrgLikeKey = "";
  public int pssSubId;
  public String pssUgcKey = "";
  public boolean quanLoaded;
  public float re;
  public int shareAlbumRight;
  public String sharePhotoUrl = "";
  public String shareQqUrl = "";
  public int shareSpaceRight;
  public String shareSummary = "";
  public String shareTitle = "";
  public String shareWeixinUrl = "";
  public int showGifState = SHOW_STATIC_PHOTO;
  public String sloc = "";
  public ArrayList<ImageTagInfo> tagList;
  public String unikey = "";
  public int uploadtime;
  public int videoflag;
  
  static
  {
    SHOW_GIF = 2;
  }
  
  public boolean aLJ()
  {
    return (this.flag & 0x4) > 0;
  }
  
  public Drawable b()
  {
    if (this.bs != null) {
      return (Drawable)this.bs.get();
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Drawable getAnimationDrawable()
  {
    Drawable localDrawable2 = b();
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 == null) {
      localDrawable1 = getThumbDrawable();
    }
    return localDrawable1;
  }
  
  public int getCutValue()
  {
    return 0;
  }
  
  public int getStartX()
  {
    return 0;
  }
  
  public int getStartY()
  {
    return 0;
  }
  
  public Drawable getThumbDrawable()
  {
    if (this.br != null) {
      return (Drawable)this.br.get();
    }
    return null;
  }
  
  public Rect getThumbRect()
  {
    return null;
  }
  
  public boolean isPanorama()
  {
    if (!awcp.a().aMh()) {}
    while ((this.flag != 32) && (this.flag != 16)) {
      return false;
    }
    return true;
  }
  
  public boolean needAnimation(boolean paramBoolean)
  {
    return true;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.bs = new WeakReference(paramDrawable);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    paramParcel.writeString(this.albumId);
    paramParcel.writeInt(this.albumPriv);
    paramParcel.writeString(this.currentUrl);
    paramParcel.writeString(this.bigUrl);
    paramParcel.writeString(this.orgUrl);
    paramParcel.writeString(this.desc);
    paramParcel.writeInt(this.praiseCount);
    paramParcel.writeInt(this.commentCount);
    int i;
    if (this.doU)
    {
      i = 1;
      paramParcel.writeInt(i);
      paramParcel.writeString(this.unikey);
      paramParcel.writeString(this.curkey);
      paramParcel.writeString(this.lloc);
      paramParcel.writeString(this.sloc);
      paramParcel.writeMap(this.busi_param);
      paramParcel.writeList(this.EZ);
      paramParcel.writeInt(this.eyI);
      paramParcel.writeInt(this.photoType);
      paramParcel.writeInt(this.opsynflag);
      paramParcel.writeInt(this.isIndependentUgc);
      paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneModelGpsInfo4LocalImage, paramInt);
      if (!this.isSelected) {
        break label556;
      }
      i = 1;
      label179:
      paramParcel.writeInt(i);
      paramParcel.writeLong(this.ctime);
      paramParcel.writeLong(this.date);
      paramParcel.writeTypedList(this.tagList);
      if (!this.isFakeFeed) {
        break label561;
      }
      i = 1;
      label217:
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.showGifState);
      paramParcel.writeInt(this.flag);
      paramParcel.writeInt(this.opMask);
      paramParcel.writeInt(this.allow_share);
      paramParcel.writeInt(this.videoflag);
      paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneModelVideoInfo, paramInt);
      paramParcel.writeString(this.albumName);
      paramParcel.writeInt(this.uploadtime);
      paramParcel.writeInt(this.photoOpmask);
      paramParcel.writeString(this.cOb);
      paramParcel.writeLong(this.aAu);
      paramParcel.writeInt(this.appid);
      paramParcel.writeString(this.pssCellId);
      paramParcel.writeString(this.pssCellSubId);
      paramParcel.writeString(this.pssUgcKey);
      paramParcel.writeInt(this.pssSubId);
      paramParcel.writeString(this.pssCurLikeKey);
      paramParcel.writeString(this.pssOrgLikeKey);
      paramParcel.writeMap(this.pssBusiParam);
      if (!this.pssHasFeedPraise) {
        break label566;
      }
      paramInt = 1;
      label384:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.shareWeixinUrl);
      paramParcel.writeString(this.shareQqUrl);
      paramParcel.writeString(this.shareTitle);
      paramParcel.writeString(this.shareSummary);
      paramParcel.writeString(this.sharePhotoUrl);
      paramParcel.writeInt(this.shareSpaceRight);
      paramParcel.writeInt(this.shareAlbumRight);
      if (!this.doV) {
        break label571;
      }
      paramInt = 1;
      label454:
      paramParcel.writeInt(paramInt);
      paramParcel.writeSerializable(this.Fb);
      if (!this.doW) {
        break label576;
      }
      paramInt = 1;
      label476:
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.aAv);
      if (!this.doX) {
        break label581;
      }
      paramInt = 1;
      label498:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.cOc);
      paramParcel.writeString(this.cOd);
      if (!this.doY) {
        break label586;
      }
    }
    label556:
    label561:
    label566:
    label571:
    label576:
    label581:
    label586:
    for (paramInt = j;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeList(this.Fa);
      paramParcel.writeFloat(this.re);
      return;
      i = 0;
      break;
      i = 0;
      break label179;
      i = 0;
      break label217;
      paramInt = 0;
      break label384;
      paramInt = 0;
      break label454;
      paramInt = 0;
      break label476;
      paramInt = 0;
      break label498;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.model.PhotoInfo
 * JD-Core Version:    0.7.0.1
 */