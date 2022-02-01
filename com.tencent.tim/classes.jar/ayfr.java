import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.VideoCoverPickerProviderView;
import dov.com.qq.im.capture.view.VideoCoverPickerProviderView.a;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.HashSet;

public class ayfr
  extends aygy
  implements View.OnClickListener
{
  private View Nm;
  private long aCF;
  public long aCJ;
  public long aCK;
  private boolean aEi;
  private long ahP;
  private VideoCoverPickerProviderView.a b;
  private boolean dyX;
  public long videoDuration;
  
  public ayfr(@NonNull aygz paramaygz, long paramLong)
  {
    super(paramaygz);
    this.aCF = paramLong;
  }
  
  private void eRs()
  {
    if (this.jdField_b_of_type_DovComQqImCaptureViewVideoCoverPickerProviderView$a == null) {
      this.jdField_b_of_type_DovComQqImCaptureViewVideoCoverPickerProviderView$a = new ayfs(this);
    }
  }
  
  public void aJ(long paramLong, boolean paramBoolean)
  {
    this.aEi = false;
    Object localObject = (aydt)a(aydt.class);
    if (localObject != null) {
      ((aydt)localObject).aI(this.ahP, false);
    }
    localObject = (aydu)a(aydu.class);
    if (localObject != null) {
      ((aydu)localObject).bsg();
    }
    this.jdField_b_of_type_Aygz.changeState(0);
    if (paramBoolean)
    {
      this.dyX = true;
      this.aCK = this.aCJ;
      QQToast.a(getContext(), 2, acfp.m(2131705682), 0).show();
      if (paramLong != 0L) {
        anot.a(null, "dc00899", "grp_story", "", "video_edit_cover", "done_cover", vu(), 1, "", "", "", "");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoCover", 2, new Object[] { "SegmentPickerFinish, coverTime: ", Long.valueOf(this.aCJ) });
      }
      return;
      this.aCJ = this.aCK;
    }
  }
  
  protected boolean e(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.e(paramMessage);
      if ((this.jdField_b_of_type_Aygz.bqq == 42) && (this.aEi)) {
        this.aCJ = ((Long[])(Long[])paramMessage.obj)[1].longValue();
      }
    }
  }
  
  public void eRt()
  {
    if (this.aCJ != 0L) {
      anot.a(null, "dc00899", "grp_story", "", "video_edit_cover", "pub_cover", vu(), 1, "", "", "", "");
    }
  }
  
  public boolean onBackPressed()
  {
    boolean bool = false;
    if (this.jdField_b_of_type_Aygz.bqq == 42)
    {
      aJ(0L, false);
      bool = true;
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_b_of_type_Aygz.a() != null) {
        this.jdField_b_of_type_Aygz.a().ca.add(Integer.valueOf(9));
      }
      QLog.d("EditVideoCover", 1, new Object[] { "Click, current covertime, ", Long.valueOf(this.aCJ) });
      this.jdField_b_of_type_Aygz.changeState(42);
      eRs();
      ProviderViewEditContainer localProviderViewEditContainer = this.jdField_b_of_type_Aygz.jdField_a_of_type_Ayeh.a;
      VideoCoverPickerProviderView localVideoCoverPickerProviderView = (VideoCoverPickerProviderView)localProviderViewEditContainer.a(113);
      if (localVideoCoverPickerProviderView != null)
      {
        aydt localaydt = (aydt)a(aydt.class);
        if (localaydt != null)
        {
          localVideoCoverPickerProviderView.setPlayMode(localaydt.getPlayMode());
          localVideoCoverPickerProviderView.setUseIFrameVideo(localaydt.aQt());
          localaydt.pausePlay();
          if ((!this.dyX) && (localaydt.getPlayMode() == 1)) {
            this.aCJ = (this.videoDuration * 1000000L);
          }
          localaydt.aI(this.aCJ / 1000000L, true);
        }
      }
      localProviderViewEditContainer.setVideoCoverPickerListener(this.jdField_b_of_type_DovComQqImCaptureViewVideoCoverPickerProviderView$a);
      localProviderViewEditContainer.s(113, new Object[] { Long.valueOf(this.aCJ / 1000000L) });
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.Nm = y(2131381577);
    if ((this.aCF & 0x0) != 0L)
    {
      this.Nm.setVisibility(0);
      this.Nm.setOnClickListener(this);
    }
    this.videoDuration = this.jdField_b_of_type_Aygz.getVideoTime();
    if ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalVideoSource)) {
      this.ahP = ((EditLocalVideoSource)this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a).startTime;
    }
  }
  
  public void setEnable(boolean paramBoolean)
  {
    if (this.Nm != null) {
      this.Nm.setEnabled(paramBoolean);
    }
  }
  
  public int vu()
  {
    int i = 1;
    int j = this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.getIntExtra("extra_transiton_src_from", -1);
    if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Ld()) {
      i = 4;
    }
    do
    {
      return i;
      if (j == 1) {
        return 0;
      }
    } while (j == 2);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayfr
 * JD-Core Version:    0.7.0.1
 */