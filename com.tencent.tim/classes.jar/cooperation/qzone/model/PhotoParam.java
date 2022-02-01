package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avuv;
import java.util.HashMap;
import java.util.Map;

public class PhotoParam
  implements Parcelable
{
  public static final Parcelable.Creator<PhotoParam> CREATOR = new avuv();
  public long aAw;
  public long aAx;
  public long aAy;
  public int albumPriv;
  public int albumType;
  public String albumanswer;
  public String albumid;
  public int albumnum;
  public int appid = 4;
  public Map<Integer, String> busi_param = new HashMap();
  public String cOe = "";
  public String cOf = "";
  public String cell_id = "";
  public String cell_subId = "";
  public int commentNum;
  public String curKey = "";
  public boolean doZ = true;
  public boolean dpa;
  public boolean dpb;
  public boolean dpc;
  public boolean dpd;
  public boolean dpe;
  public boolean dpf;
  public boolean dpg;
  public int eyK;
  public int eyL = 0;
  public String feedId = "";
  public boolean isLike;
  public boolean isVideoPicMix;
  public int likeNum;
  public long loginUin;
  public String orgKey = "";
  public long ownerUin;
  public String qunid;
  public long sharer;
  public int sortType;
  public int subid = -1;
  public String ugcKey = "";
  public int uploadnum;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("PhotoParam{");
    localStringBuffer.append("loginUin=").append(this.loginUin);
    localStringBuffer.append(", feedUin=").append(this.aAw);
    localStringBuffer.append(", ownerUin=").append(this.ownerUin);
    localStringBuffer.append(", realOwnerUin=").append(this.aAx);
    localStringBuffer.append(", albumanswer='").append(this.albumanswer).append('\'');
    localStringBuffer.append(", albumid='").append(this.albumid).append('\'');
    localStringBuffer.append(", sortType=").append(this.sortType);
    localStringBuffer.append(", albumPriv=").append(this.albumPriv);
    localStringBuffer.append(", albumnum=").append(this.albumnum);
    localStringBuffer.append(", uploadnum=").append(this.uploadnum);
    localStringBuffer.append(", albumType=").append(this.albumType);
    localStringBuffer.append(", businessPhotoFeedIndex=").append(this.eyK);
    localStringBuffer.append(", qunid='").append(this.qunid).append('\'');
    localStringBuffer.append(", isLike=").append(this.isLike);
    localStringBuffer.append(", likeNum=").append(this.likeNum);
    localStringBuffer.append(", commentNum=").append(this.commentNum);
    localStringBuffer.append(", curKey='").append(this.curKey).append('\'');
    localStringBuffer.append(", orgKey='").append(this.orgKey).append('\'');
    localStringBuffer.append(", feedId='").append(this.feedId).append('\'');
    localStringBuffer.append(", cell_id='").append(this.cell_id).append('\'');
    localStringBuffer.append(", cell_subId='").append(this.cell_subId).append('\'');
    localStringBuffer.append(", appid=").append(this.appid);
    localStringBuffer.append(", ugcKey='").append(this.ugcKey).append('\'');
    localStringBuffer.append(", canAddFavor=").append(this.doZ);
    localStringBuffer.append(", subid=").append(this.subid);
    localStringBuffer.append(", isOnePictureFeed=").append(this.dpa);
    localStringBuffer.append(", oneFeedPictruePath='").append(this.cOe).append('\'');
    localStringBuffer.append(", mFromRecent=").append(this.dpb);
    localStringBuffer.append(", busi_param=").append(this.busi_param);
    localStringBuffer.append(", isTihFeed=").append(this.dpc);
    localStringBuffer.append(", isOnlyPreView=").append(this.dpd);
    localStringBuffer.append(", isFriendPhotoBizFeed=").append(this.dpe);
    localStringBuffer.append(", isShareAlbum=").append(this.dpf);
    localStringBuffer.append(", isVideoPicMix=").append(this.isVideoPicMix);
    localStringBuffer.append(", getPhotoExType=").append(this.eyL);
    localStringBuffer.append(", sharer=").append(this.sharer);
    localStringBuffer.append(", loginNickName='").append(this.cOf).append('\'');
    localStringBuffer.append(", qzoneUserType=").append(this.aAy);
    localStringBuffer.append(", isSharedFeeds=").append(this.dpg);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeLong(this.loginUin);
    paramParcel.writeLong(this.aAw);
    paramParcel.writeLong(this.ownerUin);
    paramParcel.writeLong(this.aAx);
    paramParcel.writeString(this.albumanswer);
    paramParcel.writeString(this.albumid);
    paramParcel.writeInt(this.sortType);
    paramParcel.writeInt(this.albumPriv);
    paramParcel.writeInt(this.albumnum);
    paramParcel.writeInt(this.uploadnum);
    paramParcel.writeInt(this.albumType);
    paramParcel.writeInt(this.eyK);
    paramParcel.writeString(this.qunid);
    if (this.isLike)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.likeNum);
      paramParcel.writeInt(this.commentNum);
      paramParcel.writeString(this.curKey);
      paramParcel.writeString(this.orgKey);
      paramParcel.writeString(this.feedId);
      paramParcel.writeString(this.cell_id);
      paramParcel.writeString(this.cell_subId);
      paramParcel.writeInt(this.appid);
      paramParcel.writeMap(this.busi_param);
      paramParcel.writeString(this.ugcKey);
      if (!this.doZ) {
        break label380;
      }
      paramInt = 1;
      label209:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.subid);
      if (!this.dpa) {
        break label385;
      }
      paramInt = 1;
      label231:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.cOe);
      if (!this.dpb) {
        break label390;
      }
      paramInt = 1;
      label253:
      paramParcel.writeInt(paramInt);
      if (!this.dpc) {
        break label395;
      }
      paramInt = 1;
      label267:
      paramParcel.writeInt(paramInt);
      if (!this.dpd) {
        break label400;
      }
      paramInt = 1;
      label281:
      paramParcel.writeInt(paramInt);
      if (!this.dpe) {
        break label405;
      }
      paramInt = 1;
      label295:
      paramParcel.writeInt(paramInt);
      if (!this.dpf) {
        break label410;
      }
      paramInt = 1;
      label309:
      paramParcel.writeInt(paramInt);
      if (!this.isVideoPicMix) {
        break label415;
      }
      paramInt = 1;
      label323:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.eyL);
      paramParcel.writeLong(this.sharer);
      paramParcel.writeString(this.cOf);
      paramParcel.writeLong(this.aAy);
      if (!this.dpg) {
        break label420;
      }
    }
    label385:
    label390:
    label395:
    label400:
    label405:
    label410:
    label415:
    label420:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
      label380:
      paramInt = 0;
      break label209;
      paramInt = 0;
      break label231;
      paramInt = 0;
      break label253;
      paramInt = 0;
      break label267;
      paramInt = 0;
      break label281;
      paramInt = 0;
      break label295;
      paramInt = 0;
      break label309;
      paramInt = 0;
      break label323;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.model.PhotoParam
 * JD-Core Version:    0.7.0.1
 */