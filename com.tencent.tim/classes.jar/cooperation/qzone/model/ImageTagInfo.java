package cooperation.qzone.model;

import NS_MOBILE_FEEDS.stPhotoTag;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avuq;
import java.util.ArrayList;
import java.util.Iterator;

public class ImageTagInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ImageTagInfo> CREATOR = new avuq();
  public int appId;
  public String cOa;
  public String content;
  public int direction = 2;
  public int patternId;
  public String poiTagStreet;
  public int resourceId;
  public String tagId = "";
  public int type = 0;
  public int xScale;
  public int yScale;
  
  public ImageTagInfo() {}
  
  public ImageTagInfo(stPhotoTag paramstPhotoTag)
  {
    if (paramstPhotoTag != null)
    {
      this.type = paramstPhotoTag.type;
      this.content = paramstPhotoTag.content;
      this.tagId = paramstPhotoTag.tag_id;
      this.xScale = ((int)paramstPhotoTag.x_scale);
      this.yScale = ((int)paramstPhotoTag.y_scale);
      this.direction = paramstPhotoTag.direction;
      this.poiTagStreet = paramstPhotoTag.poiTagStreet;
    }
  }
  
  private ImageTagInfo(Parcel paramParcel)
  {
    this.type = paramParcel.readInt();
    this.content = paramParcel.readString();
    this.tagId = paramParcel.readString();
    this.appId = paramParcel.readInt();
    this.resourceId = paramParcel.readInt();
    this.patternId = paramParcel.readInt();
    this.xScale = paramParcel.readInt();
    this.yScale = paramParcel.readInt();
    this.direction = paramParcel.readInt();
    this.poiTagStreet = paramParcel.readString();
    this.cOa = paramParcel.readString();
  }
  
  public static ArrayList<ImageTagInfo> at(ArrayList<stPhotoTag> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        ImageTagInfo localImageTagInfo = new ImageTagInfo((stPhotoTag)paramArrayList.next());
        if (localImageTagInfo != null) {
          localArrayList.add(localImageTagInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public static ArrayList<stPhotoTag> au(ArrayList<ImageTagInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (ImageTagInfo)paramArrayList.next();
        if (localObject != null)
        {
          localObject = new stPhotoTag(((ImageTagInfo)localObject).type, ((ImageTagInfo)localObject).content, ((ImageTagInfo)localObject).tagId, ((ImageTagInfo)localObject).xScale, ((ImageTagInfo)localObject).yScale, ((ImageTagInfo)localObject).direction, ((ImageTagInfo)localObject).poiTagStreet);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public ImageTagInfo a()
  {
    ImageTagInfo localImageTagInfo = new ImageTagInfo();
    localImageTagInfo.type = this.type;
    localImageTagInfo.content = this.content;
    localImageTagInfo.tagId = this.tagId;
    localImageTagInfo.appId = this.appId;
    localImageTagInfo.resourceId = this.resourceId;
    localImageTagInfo.patternId = this.patternId;
    localImageTagInfo.xScale = this.xScale;
    localImageTagInfo.yScale = this.yScale;
    localImageTagInfo.direction = this.direction;
    localImageTagInfo.poiTagStreet = this.poiTagStreet;
    localImageTagInfo.cOa = this.cOa;
    return localImageTagInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.tagId);
    paramParcel.writeInt(this.appId);
    paramParcel.writeInt(this.resourceId);
    paramParcel.writeInt(this.patternId);
    paramParcel.writeInt(this.xScale);
    paramParcel.writeInt(this.yScale);
    paramParcel.writeInt(this.direction);
    paramParcel.writeString(this.poiTagStreet);
    paramParcel.writeString(this.cOa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.model.ImageTagInfo
 * JD-Core Version:    0.7.0.1
 */