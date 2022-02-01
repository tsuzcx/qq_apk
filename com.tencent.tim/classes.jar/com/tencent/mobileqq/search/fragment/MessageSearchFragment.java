package com.tencent.mobileqq.search.fragment;

import amlt;
import amnf;
import amwd;
import amwf;

public class MessageSearchFragment
  extends BaseSearchFragment
{
  protected int IT()
  {
    return 40;
  }
  
  public void Id(String paramString)
  {
    super.fO(paramString, 2);
  }
  
  protected amlt a()
  {
    return new amnf(this, this.jdField_a_of_type_ComTencentWidgetListView, this.c);
  }
  
  protected amwd a()
  {
    return new amwf(this.d);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Amwd.pause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Amwd.resume();
  }
  
  protected String vn()
  {
    return getString(2131719282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.MessageSearchFragment
 * JD-Core Version:    0.7.0.1
 */