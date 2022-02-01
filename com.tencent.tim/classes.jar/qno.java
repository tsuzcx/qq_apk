import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

class qno
  implements DialogInterface.OnClickListener
{
  qno(qng paramqng, VideoViewVideoHolder paramVideoViewVideoHolder, StoryVideoItem paramStoryVideoItem) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.sH(false);
    }
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    pnx.qT(this.j.mVid);
    rar.a("play_video", "suc_del", 0, 0, new String[] { "", "", "", this.j.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qno
 * JD-Core Version:    0.7.0.1
 */