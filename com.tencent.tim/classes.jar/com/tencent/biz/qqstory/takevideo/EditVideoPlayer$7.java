package com.tencent.biz.qqstory.takevideo;

import java.util.List;
import ram;
import rdm;

public class EditVideoPlayer$7
  implements Runnable
{
  public EditVideoPlayer$7(rdm paramrdm) {}
  
  public void run()
  {
    this.this$0.oD = ((MultiBlockVideoPlayer)this.this$0.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(true, 10000L, 6, this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.getWidth(), this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.getHeight(), this.this$0.mI);
    ram.b("Q.qqstory.record.EditVideoPlayer", "onLoadSuccess getMultiVideoInfo find %d blocks", Integer.valueOf(this.this$0.oD.size()));
    if (this.this$0.oD.size() > 0) {}
    try
    {
      ((MultiBlockVideoPlayer)this.this$0.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).setCurrentVideoFragment((MultiBlockVideoPlayer.a)this.this$0.oD.get(0));
      rdm.a(this.this$0);
      return;
    }
    catch (MultiBlockVideoPlayer.MultiOperateException localMultiOperateException)
    {
      for (;;)
      {
        ram.e("Q.qqstory.record.EditVideoPlayer", "onLoadSuccess setCurrentVideoFragment failed", localMultiOperateException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPlayer.7
 * JD-Core Version:    0.7.0.1
 */