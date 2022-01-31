package com.tencent.mobileqq.activity.converse;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

public class TroopAssistBanner
  extends BaseBanner
{
  public TroopAssistBanner(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Int = 108;
    this.b = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public View a(Context paramContext)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(paramContext, 2130903130, null);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.converse.TroopAssistBanner
 * JD-Core Version:    0.7.0.1
 */