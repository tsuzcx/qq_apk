import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.VideoCoverPickerProviderView;
import dov.com.qq.im.capture.view.VideoCoverPickerProviderView.a;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.List;

class ayfs
  implements VideoCoverPickerProviderView.a
{
  ayfs(ayfr paramayfr) {}
  
  public void aF(long paramLong, boolean paramBoolean)
  {
    this.a.aJ(paramLong, paramBoolean);
  }
  
  public void ePn()
  {
    VideoCoverPickerProviderView localVideoCoverPickerProviderView = (VideoCoverPickerProviderView)this.a.b.jdField_a_of_type_Ayeh.a.a(113);
    boolean bool;
    Object localObject;
    if (localVideoCoverPickerProviderView != null)
    {
      bool = this.a.b.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.getBooleanExtra("extra_is_need_gaussion_blur", false);
      if ((this.a.b.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakeVideoSource))
      {
        localObject = (EditTakeVideoSource)this.a.b.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
        localVideoCoverPickerProviderView.setVideo(((EditTakeVideoSource)localObject).sourcePath, 0L, ((EditTakeVideoSource)localObject).d.mDuration, ((EditTakeVideoSource)localObject).getWidth(), ((EditTakeVideoSource)localObject).getHeight(), ((EditTakeVideoSource)localObject).d.rotation, true, bool);
      }
    }
    else
    {
      return;
    }
    if ((this.a.b.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalVideoSource))
    {
      localObject = (EditLocalVideoSource)this.a.b.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
      localVideoCoverPickerProviderView.setVideo(((EditLocalVideoSource)localObject).sourcePath, ((EditLocalVideoSource)localObject).startTime, ((EditLocalVideoSource)localObject).endTime, ((EditLocalVideoSource)localObject).getWidth(), ((EditLocalVideoSource)localObject).getHeight(), ((EditLocalVideoSource)localObject).d.rotation, true, bool);
      return;
    }
    throw new IllegalArgumentException("SegmentEdit init error");
  }
  
  public void oM(List<Long> paramList)
  {
    aydt localaydt = (aydt)this.a.a(aydt.class);
    if (localaydt != null) {
      localaydt.oO(paramList);
    }
  }
  
  public void og(long paramLong)
  {
    ayfr.a(this.a, true);
    aydt localaydt = (aydt)this.a.a(aydt.class);
    if (localaydt != null) {
      localaydt.e(paramLong, true, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayfs
 * JD-Core Version:    0.7.0.1
 */