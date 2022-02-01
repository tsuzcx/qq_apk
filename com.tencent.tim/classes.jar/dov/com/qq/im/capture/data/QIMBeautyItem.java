package dov.com.qq.im.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import axqi;

public class QIMBeautyItem
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<QIMBeautyItem> CREATOR = new axqi();
  public String aBF;
  public String iconUrl;
  public String id;
  public String name;
  
  public QIMBeautyItem() {}
  
  public QIMBeautyItem(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.name = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.aBF = paramParcel.readString();
  }
  
  public QIMFilterCategoryItem a()
  {
    try
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)super.clone();
      return localQIMFilterCategoryItem;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
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
  
  public boolean isDovItem()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.aBF))
    {
      bool1 = bool2;
      if (this.aBF.startsWith("qim")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    return "FilterCategoryItem{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", jumpApp=" + this.aBF + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.aBF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.data.QIMBeautyItem
 * JD-Core Version:    0.7.0.1
 */