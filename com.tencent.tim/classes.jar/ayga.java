import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.VideoSegmentPickerProviderView;
import dov.com.qq.im.capture.view.VideoSegmentPickerProviderView.a;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;

class ayga
  implements VideoSegmentPickerProviderView.a
{
  ayga(ayfw paramayfw, int paramInt) {}
  
  public void aS(long paramLong1, long paramLong2)
  {
    aydt localaydt = (aydt)this.this$0.a(aydt.class);
    if (localaydt != null) {
      localaydt.aI(this.eKc, false);
    }
    this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.bue();
    this.this$0.b.changeState(0);
  }
  
  public void ePn()
  {
    VideoSegmentPickerProviderView localVideoSegmentPickerProviderView = (VideoSegmentPickerProviderView)this.this$0.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(111);
    boolean bool;
    Object localObject;
    if (localVideoSegmentPickerProviderView != null)
    {
      bool = this.this$0.b.a.getBooleanExtra("extra_is_need_gaussion_blur", false);
      if ((this.this$0.b.a.a instanceof EditTakeVideoSource))
      {
        localObject = (EditTakeVideoSource)this.this$0.b.a.a;
        localVideoSegmentPickerProviderView.setVideo(((EditTakeVideoSource)localObject).sourcePath, 0L, ((EditTakeVideoSource)localObject).d.mDuration, ((EditTakeVideoSource)localObject).getWidth(), ((EditTakeVideoSource)localObject).getHeight(), ((EditTakeVideoSource)localObject).d.rotation, true, bool);
      }
    }
    else
    {
      return;
    }
    if ((this.this$0.b.a.a instanceof EditLocalVideoSource))
    {
      localObject = (EditLocalVideoSource)this.this$0.b.a.a;
      localVideoSegmentPickerProviderView.setVideo(((EditLocalVideoSource)localObject).sourcePath, ((EditLocalVideoSource)localObject).startTime, ((EditLocalVideoSource)localObject).endTime, ((EditLocalVideoSource)localObject).getWidth(), ((EditLocalVideoSource)localObject).getHeight(), ((EditLocalVideoSource)localObject).d.rotation, false, bool);
      return;
    }
    throw new IllegalArgumentException("SegmentEdit init error");
  }
  
  public void oM(List<Long> paramList)
  {
    aydt localaydt = (aydt)this.this$0.a(aydt.class);
    if (localaydt != null) {
      localaydt.oO(paramList);
    }
  }
  
  public void og(long paramLong)
  {
    aydt localaydt = (aydt)this.this$0.a(aydt.class);
    if (localaydt != null) {
      localaydt.aI(this.eKc + paramLong, true);
    }
  }
  
  public void oi(long paramLong)
  {
    aydt localaydt = (aydt)this.this$0.a(aydt.class);
    if (localaydt != null) {
      localaydt.aI(this.eKc + paramLong, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayga
 * JD-Core Version:    0.7.0.1
 */