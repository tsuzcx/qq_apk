import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;

class vwx
  implements DialogInterface.OnClickListener
{
  vwx(vwo paramvwo, VideoViewVideoHolder paramVideoViewVideoHolder, StoryVideoItem paramStoryVideoItem, wkv paramwkv) {}
  
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
    this.jdField_a_of_type_Vwo.a("");
    if (StoryVideoItem.isFakeVid(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid))
    {
      ((ukd)urr.a(3)).c(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      paramDialogInterface = new uqw(new ErrorMessage(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, false);
      paramDialogInterface.b = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid;
      paramDialogInterface.a = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoIndex;
      if (paramDialogInterface.a == 0L) {
        paramDialogInterface.a = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mCreateTime;
      }
      uht.a().dispatch(paramDialogInterface);
    }
    for (;;)
    {
      wta.a("play_video", "suc_del", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mStoryType == 2)
      {
        ((xlf)vhj.a().getManager(208)).a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, 0, false, new vwy(this));
      }
      else
      {
        this.jdField_a_of_type_Wkv.a(this.jdField_a_of_type_Vwo.a.b, 0, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        this.jdField_a_of_type_Wkv.a(this.jdField_a_of_type_Vwo.a.b, 1, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        new uyc().a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vwx
 * JD-Core Version:    0.7.0.1
 */