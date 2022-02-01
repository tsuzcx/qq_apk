package com.tencent.mobileqq.activity.qquserguide;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.widget.QQVideoView;
import com.tencent.qphone.base.util.QLog;
import enr;
import ens;
import ent;

public class UserguideVideoFragment
  extends UserguideFragment
  implements View.OnClickListener
{
  static boolean jdField_b_of_type_Boolean = false;
  public int a;
  public Button a;
  public ImageView a;
  public QQVideoView a;
  public String a;
  boolean a;
  private int jdField_b_of_type_Int;
  private int c;
  
  @Deprecated
  public UserguideVideoFragment()
  {
    this.jdField_a_of_type_JavaLangString = "UserGuide";
  }
  
  public UserguideVideoFragment(UserguideActivity paramUserguideActivity)
  {
    super(paramUserguideActivity);
    this.jdField_a_of_type_JavaLangString = "UserGuide";
  }
  
  private int[] a()
  {
    int[] arrayOfInt = new int[2];
    int k = this.jdField_b_of_type_Int;
    int m = this.c;
    int j;
    if (k * 720 >= 480 * m) {
      j = 600 * m / 720;
    }
    for (int i = 900 * m / 720;; i = 900 * k / 480)
    {
      arrayOfInt[0] = j;
      arrayOfInt[1] = i;
      if ((j < k) || (i < m))
      {
        arrayOfInt[0] = k;
        arrayOfInt[1] = m;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("userguide", 4, "fight....video desireSize  w = " + arrayOfInt[0] + "... y = " + arrayOfInt[1]);
      }
      return arrayOfInt;
      j = 600 * k / 480;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (paramViewGroup == null) {
      return null;
    }
    paramLayoutInflater = paramLayoutInflater.inflate(2130903651, null);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131233238));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView = ((QQVideoView)paramLayoutInflater.findViewById(2131233236));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131233239));
    paramViewGroup = Uri.parse("android.resource://" + a().getPackageName() + "/" + 2131165211);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setVideoURI(paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.requestFocus();
    paramViewGroup = a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setDimension(paramViewGroup[0], paramViewGroup[1]);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setOnCompletionListener(new enr(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setOnErrorListener(new ens(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setOnPreparedListener(new ent(this));
    return paramLayoutInflater;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.seekTo(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.start();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_b_of_type_Int = a().getResources().getDisplayMetrics().widthPixels;
    this.c = a().getResources().getDisplayMetrics().heightPixels;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.canPause())
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.getCurrentPosition();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.pause();
      this.jdField_a_of_type_Boolean = true;
    }
    super.b();
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.start();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.isPlaying())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.stopPlayback();
    }
    super.c();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qquserguide.UserguideVideoFragment
 * JD-Core Version:    0.7.0.1
 */