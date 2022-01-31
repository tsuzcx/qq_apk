package com.dataline.util.file;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.dataline.activities.DLBaseFileViewActivity.DLFileState;
import fa;

public class DLFileInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new fa();
  public long a;
  public DLBaseFileViewActivity.DLFileState a;
  public String a;
  public long b;
  public String b;
  
  public DLFileInfo() {}
  
  private DLFileInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState = DLBaseFileViewActivity.DLFileState.values()[paramParcel.readInt()];
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Long = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_ComDatalineActivitiesDLBaseFileViewActivity$DLFileState.ordinal());
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.util.file.DLFileInfo
 * JD-Core Version:    0.7.0.1
 */