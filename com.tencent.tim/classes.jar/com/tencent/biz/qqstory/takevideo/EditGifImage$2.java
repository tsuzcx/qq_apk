package com.tencent.biz.qqstory.takevideo;

import com.tencent.image.URLImageView;
import cooperation.qzone.widget.FastAnimationDrawable;
import rcb;
import rdc;

class EditGifImage$2
  implements Runnable
{
  EditGifImage$2(EditGifImage paramEditGifImage) {}
  
  public void run()
  {
    FastAnimationDrawable localFastAnimationDrawable = this.this$0.a;
    this.this$0.a.stop();
    this.this$0.a = this.this$0.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable;
    this.this$0.t.setImageDrawable(this.this$0.a);
    this.this$0.a.start();
    this.this$0.jdField_b_of_type_CooperationQzoneWidgetFastAnimationDrawable = localFastAnimationDrawable;
    this.this$0.aGr = true;
    this.this$0.jdField_b_of_type_Rdc.a.as(true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditGifImage.2
 * JD-Core Version:    0.7.0.1
 */