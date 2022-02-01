package dov.com.qq.im.aeeditor.module.clip.video;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import axiz;
import axle;
import axlf;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.timeline.TimelineBuilder;
import com.tencent.tavcut.timeline.TimelineView;
import com.tencent.tavkit.composition.TAVSource;

public class AEEditorMvClipMenu
  extends FrameLayout
{
  private float El = 1.0F;
  private ImageView Iq;
  private CMTimeRange jdField_a_of_type_ComTencentTavCoremediaCMTimeRange;
  private IPlayer.PlayerStatus jdField_a_of_type_ComTencentTavPlayerIPlayer$PlayerStatus;
  private TimelineView jdField_a_of_type_ComTencentTavcutTimelineTimelineView;
  TAVSource jdField_a_of_type_ComTencentTavkitCompositionTAVSource;
  private a jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu$a;
  private CMTimeRange b;
  private boolean cSH;
  private boolean dvf;
  private RelativeLayout fl;
  private IPlayer.PlayerStatus mPlayerStatus;
  
  public AEEditorMvClipMenu(@NonNull Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public AEEditorMvClipMenu(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public AEEditorMvClipMenu(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void Yt(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu$a != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu$a.Yv(paramBoolean);
    }
  }
  
  private void Yu(boolean paramBoolean)
  {
    this.dvf = paramBoolean;
  }
  
  private void a(CMTimeRange paramCMTimeRange)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu$a != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu$a.b(paramCMTimeRange);
    }
  }
  
  private void eLW() {}
  
  private void eLX()
  {
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setSliderChangeListener(new axle(this));
  }
  
  private void eLY()
  {
    this.Iq.setOnClickListener(new axlf(this));
  }
  
  private void eLZ()
  {
    if (!this.Iq.isSelected()) {}
    for (boolean bool = true;; bool = false)
    {
      Yt(bool);
      return;
    }
  }
  
  private void init()
  {
    initView();
  }
  
  private void initView()
  {
    this.cSH = axiz.aOK();
    inflate(getContext(), 2131558621, this);
    this.Iq = ((ImageView)findViewById(2131372142));
    this.fl = ((RelativeLayout)findViewById(2131372143));
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView = new TimelineView(getContext(), null, 2130837993, 2130837951, 2130837950, 2130837977, 2130837978, 2130838013, 2130838014);
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setSliderFrameColor(getResources().getColor(2131165285));
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setIndicatorRes(2130838012);
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setDurationBgRes(2130837991);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setLayoutParams(localLayoutParams);
    this.fl.addView(this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView);
    eLW();
    eLX();
    eLY();
  }
  
  private void seek(CMTime paramCMTime)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu$a != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu$a.a(paramCMTime);
    }
  }
  
  public void a(TAVSource paramTAVSource, long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView != null) {
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setClipData(paramTAVSource, paramLong1, paramLong2, paramLong3);
    }
  }
  
  public void aR(long paramLong1, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange.getDuration();
    Log.e("MvClipMenu", "updateTimeLineView: newTimeRange " + this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange);
    CMTimeRange localCMTimeRange = this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange;
    long l2 = ((CMTime)localObject).getTimeUs() / 1000L;
    if (paramLong1 != -1L)
    {
      if (paramLong2 == -1L) {
        break label167;
      }
      label70:
      localObject = new TimelineBuilder();
      if (l2 <= 60000L) {
        break label187;
      }
    }
    label167:
    label187:
    for (long l1 = 60000L;; l1 = l2)
    {
      localObject = ((TimelineBuilder)localObject).setMaxSelectDurationMs(l1).setLockMode(false).setSliderBarMode(true).setShowDuration(true);
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setTimelineBuilder((TimelineBuilder)localObject);
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setClipData(this.jdField_a_of_type_ComTencentTavkitCompositionTAVSource, l2, paramLong1, paramLong2);
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setSpeed(1.0F);
      return;
      paramLong1 = localCMTimeRange.getStart().multi(1.0F).getTimeUs() / 1000L;
      break;
      paramLong2 = localCMTimeRange.getEnd().multi(1.0F).getTimeUs() / 1000L;
      break label70;
    }
  }
  
  public void bindPlayer(MoviePlayer paramMoviePlayer)
  {
    if (this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView != null) {
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.bindPlayer(paramMoviePlayer);
    }
  }
  
  public void release()
  {
    if (this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView != null) {
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.release();
    }
  }
  
  public void setMvClipMenuListener(a parama)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu$a = parama;
  }
  
  public void setPlayPosition(CMTime paramCMTime)
  {
    if (this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView != null) {
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.setPlayPosition(((float)(paramCMTime.getTimeUs() / 1000L) * 1.0F));
    }
  }
  
  public void setPlayStatus(IPlayer.PlayerStatus paramPlayerStatus)
  {
    this.mPlayerStatus = paramPlayerStatus;
    ImageView localImageView;
    if (this.Iq != null)
    {
      localImageView = this.Iq;
      if ((paramPlayerStatus != IPlayer.PlayerStatus.PLAYING) && (paramPlayerStatus != IPlayer.PlayerStatus.REPLAY)) {
        break label39;
      }
    }
    label39:
    for (boolean bool = true;; bool = false)
    {
      localImageView.setSelected(bool);
      return;
    }
  }
  
  public void setTAVSource(TAVSource paramTAVSource)
  {
    this.jdField_a_of_type_ComTencentTavkitCompositionTAVSource = paramTAVSource;
  }
  
  public void setTime(CMTimeRange paramCMTimeRange)
  {
    this.b = paramCMTimeRange;
    this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange = paramCMTimeRange;
    Log.e("MvClipMenu", "setTime: newTimeRange " + this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange);
  }
  
  public void setTimeLineViewSpeed(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView != null) {
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView.updateSpeed(paramFloat);
    }
  }
  
  public static abstract interface a
  {
    public abstract void Yv(boolean paramBoolean);
    
    public abstract void a(CMTime paramCMTime);
    
    public abstract void b(CMTimeRange paramCMTimeRange);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.video.AEEditorMvClipMenu
 * JD-Core Version:    0.7.0.1
 */