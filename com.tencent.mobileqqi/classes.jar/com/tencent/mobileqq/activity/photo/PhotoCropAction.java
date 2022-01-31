package com.tencent.mobileqq.activity.photo;

import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import emp;

public class PhotoCropAction
{
  public PhotoCropActivity a;
  public String[] a;
  
  public PhotoCropAction(PhotoCropActivity paramPhotoCropActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity = paramPhotoCropActivity;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity, null);
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        localActionSheet.a(this.jdField_a_of_type_ArrayOfJavaLangString[i], 1);
        i += 1;
      }
      localActionSheet.d(2131561746);
      localActionSheet.a(new emp(this, localActionSheet));
      localActionSheet.show();
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropAction
 * JD-Core Version:    0.7.0.1
 */