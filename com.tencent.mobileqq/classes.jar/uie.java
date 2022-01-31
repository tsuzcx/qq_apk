import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class uie
  implements DialogInterface.OnClickListener
{
  uie(uhw paramuhw, VideoViewVideoHolder paramVideoViewVideoHolder, StoryVideoItem paramStoryVideoItem) {}
  
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
    svl.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
    vei.a("play_video", "suc_del", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uie
 * JD-Core Version:    0.7.0.1
 */