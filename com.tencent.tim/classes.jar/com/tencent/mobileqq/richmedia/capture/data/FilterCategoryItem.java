package com.tencent.mobileqq.richmedia.capture.data;

import alwh;
import alwj;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class FilterCategoryItem
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<FilterCategoryItem> CREATOR = new alwj();
  public boolean advertisement;
  public String androidopenurlheader;
  public String bYX;
  public String bYY;
  public String bYZ;
  public String badgeurl;
  public String buttonbgcolor;
  public int categoryId;
  public String iconUrl;
  public String id;
  public String name;
  public String openurl;
  public boolean popup = true;
  public String popupbtn;
  public String popupbtn2;
  public String popupcontent;
  public String popupcontent2;
  public String popupimgurl;
  public int progress;
  public String storeurl;
  public ArrayList<String> za = new ArrayList();
  
  public FilterCategoryItem() {}
  
  public FilterCategoryItem(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.name = paramParcel.readString();
    this.bYX = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.progress = paramParcel.readInt();
    this.categoryId = paramParcel.readInt();
    this.za = paramParcel.createStringArrayList();
    this.bYY = paramParcel.readString();
    this.bYZ = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.advertisement = bool1;
      this.androidopenurlheader = paramParcel.readString();
      this.openurl = paramParcel.readString();
      this.storeurl = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label215;
      }
    }
    label215:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.popup = bool1;
      this.badgeurl = paramParcel.readString();
      this.popupimgurl = paramParcel.readString();
      this.popupcontent = paramParcel.readString();
      this.popupbtn = paramParcel.readString();
      this.popupcontent2 = paramParcel.readString();
      this.popupbtn2 = paramParcel.readString();
      this.buttonbgcolor = paramParcel.readString();
      paramParcel.readInt();
      return;
      bool1 = false;
      break;
    }
  }
  
  public FilterDesc a()
  {
    if ((this.za != null) && (this.za.size() > 0)) {
      return alwh.a().a((String)this.za.get(0));
    }
    return null;
  }
  
  public boolean auG()
  {
    return (this.za != null) && (this.za.contains("EMPTY"));
  }
  
  public FilterCategoryItem b()
  {
    try
    {
      FilterCategoryItem localFilterCategoryItem = (FilterCategoryItem)super.clone();
      return localFilterCategoryItem;
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
  
  public String toString()
  {
    return "FilterCategoryItem{id='" + this.id + '\'' + ", name='" + this.name + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.bYX);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeInt(this.progress);
    paramParcel.writeInt(this.categoryId);
    paramParcel.writeStringList(this.za);
    paramParcel.writeString(this.bYY);
    paramParcel.writeString(this.bYZ);
    if (this.advertisement)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.androidopenurlheader);
      paramParcel.writeString(this.openurl);
      paramParcel.writeString(this.storeurl);
      if (!this.popup) {
        break label193;
      }
    }
    label193:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.badgeurl);
      paramParcel.writeString(this.popupimgurl);
      paramParcel.writeString(this.popupcontent);
      paramParcel.writeString(this.popupbtn);
      paramParcel.writeString(this.popupcontent2);
      paramParcel.writeString(this.popupbtn2);
      paramParcel.writeString(this.buttonbgcolor);
      paramParcel.writeInt(0);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem
 * JD-Core Version:    0.7.0.1
 */