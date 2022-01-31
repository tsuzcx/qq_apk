import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;

class uif
  implements DialogInterface.OnClickListener
{
  uif(uhw paramuhw, VideoViewVideoHolder paramVideoViewVideoHolder, StoryVideoItem paramStoryVideoItem, uwd paramuwd) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.c(false);
    }
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    this.jdField_a_of_type_Uhw.a("");
    if (StoryVideoItem.isFakeVid(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid))
    {
      ((svl)tcz.a(3)).c(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      paramDialogInterface = new tce(new ErrorMessage(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, false);
      paramDialogInterface.b = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid;
      paramDialogInterface.a = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoIndex;
      if (paramDialogInterface.a == 0L) {
        paramDialogInterface.a = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mCreateTime;
      }
      stb.a().dispatch(paramDialogInterface);
    }
    for (;;)
    {
      vei.a("play_video", "suc_del", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mStoryType == 2)
      {
        ((vwn)tsr.a().getManager(208)).a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, 0, false, new uig(this));
      }
      else
      {
        this.jdField_a_of_type_Uwd.a(this.jdField_a_of_type_Uhw.a.b, 0, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        this.jdField_a_of_type_Uwd.a(this.jdField_a_of_type_Uhw.a.b, 1, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        new tjk().a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uif
 * JD-Core Version:    0.7.0.1
 */