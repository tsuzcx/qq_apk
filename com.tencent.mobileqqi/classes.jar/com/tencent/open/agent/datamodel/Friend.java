package com.tencent.open.agent.datamodel;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import hjv;

public class Friend
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new hjv();
  public int a;
  public String a;
  public int b;
  public String b;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  
  public Friend()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
  }
  
  public Friend(Friend paramFriend)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramFriend.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramFriend.jdField_b_of_type_JavaLangString;
    this.c = paramFriend.c;
    this.d = paramFriend.d;
    this.jdField_a_of_type_Int = paramFriend.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramFriend.jdField_b_of_type_Int;
    this.e = paramFriend.e;
    this.f = paramFriend.f;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (paramObject == this) {
          return true;
        }
      } while (paramObject.getClass() != getClass());
      paramObject = (Friend)paramObject;
    } while (this.jdField_a_of_type_JavaLangString == null);
    return this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString);
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaLangString != null) {
      return this.jdField_a_of_type_JavaLangString.hashCode();
    }
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.agent.datamodel.Friend
 * JD-Core Version:    0.7.0.1
 */