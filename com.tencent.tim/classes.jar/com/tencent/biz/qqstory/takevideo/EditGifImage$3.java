package com.tencent.biz.qqstory.takevideo;

import com.tencent.image.URLImageView;
import cooperation.qzone.widget.FastAnimationDrawable;
import rcb;
import rdc;

class EditGifImage$3
  implements Runnable
{
  EditGifImage$3(EditGifImage paramEditGifImage) {}
  
  public void run()
  {
    FastAnimationDrawable localFastAnimationDrawable = this.this$0.a;
    this.this$0.a.stop();
    this.this$0.a = this.this$0.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable;
    this.this$0.t.setImageDrawable(this.this$0.a);
    this.this$0.a.start();
    this.this$0.aGr = false;
    this.this$0.jdField_b_of_type_Rdc.a.as(true, false);
    this.this$0.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable = localFastAnimationDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditGifImage.3
 * JD-Core Version:    0.7.0.1
 */