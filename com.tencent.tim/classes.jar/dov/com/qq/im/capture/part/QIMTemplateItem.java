package dov.com.qq.im.capture.part;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import axpx;
import axsi;
import java.util.ArrayList;
import org.json.JSONArray;

public class QIMTemplateItem
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<QIMTemplateItem> CREATOR = new axsi();
  public JSONArray V;
  public JSONArray W;
  public JSONArray X;
  public JSONArray Y;
  public JSONArray Z;
  public JSONArray aa;
  public int categoryId;
  public String categoryName;
  public String ceV;
  public String coverUrl;
  public boolean dwd;
  public boolean dwu;
  public String iconUrl;
  public String id;
  public String localVideoPath;
  public String name;
  public String type;
  public String videoMd5;
  public String videoUrl;
  public ArrayList<String> za = new ArrayList();
  
  public QIMTemplateItem() {}
  
  public QIMTemplateItem(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.name = paramParcel.readString();
    this.ceV = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.categoryId = paramParcel.readInt();
    this.categoryName = paramParcel.readString();
    this.za = paramParcel.createStringArrayList();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.dwd = bool1;
      this.coverUrl = paramParcel.readString();
      this.videoUrl = paramParcel.readString();
      this.videoMd5 = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label163;
      }
    }
    label163:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.dwu = bool1;
      this.localVideoPath = (axpx.cVH + this.name + ".mp4");
      return;
      bool1 = false;
      break;
    }
  }
  
  public QIMTemplateItem a()
  {
    try
    {
      QIMTemplateItem localQIMTemplateItem = (QIMTemplateItem)super.clone();
      return localQIMTemplateItem;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public boolean auG()
  {
    return (this.za != null) && (this.za.contains("EMPTY"));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (paramObject.hashCode() != hashCode()) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return this.id.intern().hashCode();
  }
  
  public String toString()
  {
    return "FilterCategoryItem{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", isCombo=" + this.dwd + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.ceV);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeInt(this.categoryId);
    paramParcel.writeString(this.categoryName);
    paramParcel.writeStringList(this.za);
    if (this.dwd)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.coverUrl);
      paramParcel.writeString(this.videoUrl);
      paramParcel.writeString(this.videoMd5);
      if (!this.dwu) {
        break label118;
      }
    }
    label118:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.part.QIMTemplateItem
 * JD-Core Version:    0.7.0.1
 */