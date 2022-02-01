package com.tencent.mobileqq.activity.aio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import dvs;

public final class ForwardUtils$Section_Text
  extends ForwardUtils.SectionBase
{
  public static final Parcelable.Creator CREATOR = new dvs();
  public String a;
  
  public ForwardUtils$Section_Text()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public ForwardUtils$Section_Text(Parcel paramParcel)
  {
    super(paramParcel);
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
  }
  
  public ForwardUtils$Section_Text(String paramString)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.Section_Text
 * JD-Core Version:    0.7.0.1
 */