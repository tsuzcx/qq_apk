package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.widget.Gallery;
import vbc;
import vbi;

public class FriendProfileImageActivity$6$1
  implements Runnable
{
  public FriendProfileImageActivity$6$1(vbc paramvbc) {}
  
  public void run()
  {
    if (this.a.this$0.bHi != this.a.this$0.jdField_a_of_type_Vbi.getCurrentIndex()) {
      this.a.this$0.bHi = this.a.this$0.jdField_a_of_type_Vbi.getCurrentIndex();
    }
    View localView;
    do
    {
      return;
      localView = this.a.this$0.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
    } while (localView == null);
    this.a.this$0.sG = localView;
    this.a.this$0.jdField_a_of_type_Vbi.setCurrentIndex(this.a.this$0.jdField_a_of_type_Vbi.getCurrentIndex());
    this.a.this$0.a(this.a.this$0.jdField_a_of_type_ComTencentWidgetGallery, this.a.this$0.jdField_a_of_type_Vbi.getCurrentIndex());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.6.1
 * JD-Core Version:    0.7.0.1
 */