package com.tencent.mobileqq.activity.photo.album;

import com.tencent.widget.GestureSelectGridView;
import ztv;

public class PhotoListLogicDefault$11
  implements Runnable
{
  public PhotoListLogicDefault$11(ztv paramztv, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.mActivity != null) {
      ((NewPhotoListActivity)this.this$0.mActivity).mGridView.setSelection(this.cfg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.11
 * JD-Core Version:    0.7.0.1
 */