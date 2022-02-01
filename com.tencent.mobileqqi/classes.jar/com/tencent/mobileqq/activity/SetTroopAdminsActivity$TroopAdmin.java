package com.tencent.mobileqq.activity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import did;

public class SetTroopAdminsActivity$TroopAdmin
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new did();
  public String a;
  public short a;
  public String b;
  public String c;
  
  public SetTroopAdminsActivity$TroopAdmin() {}
  
  private SetTroopAdminsActivity$TroopAdmin(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Short = ((short)paramParcel.readInt());
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Short);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SetTroopAdminsActivity.TroopAdmin
 * JD-Core Version:    0.7.0.1
 */