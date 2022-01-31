package com.tencent.mobileqq.activity.aio.photo;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.app.PeakAppInterface;
import java.util.HashSet;

public class PeakActivity
  extends BaseActivity2
{
  public static final HashSet a;
  public PeakAppInterface a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AIOGalleryUtils.a.removeMessages(1);
    String str = getClass().getName() + "@" + hashCode();
    jdField_a_of_type_JavaUtilHashSet.add(str);
    super.onCreate(paramBundle);
    if ((getAppRuntime() instanceof PeakAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)getAppRuntime());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    String str = getClass().getName() + "@" + hashCode();
    jdField_a_of_type_JavaUtilHashSet.remove(str);
    if (jdField_a_of_type_JavaUtilHashSet.size() == 0) {
      AIOGalleryUtils.a.removeMessages(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PeakActivity
 * JD-Core Version:    0.7.0.1
 */