package dov.com.qq.im.aeeditor.module.clip.video;

import acfp;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import aqha;
import aqju;
import axiy;
import axiz;
import axji;
import axlg;
import axlh;
import axli;
import axlj;
import axlk;
import axnl;
import axnn;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.view.TAVCutVideoView;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar;
import java.util.ArrayList;

public class AEEditorVideoClipFragment
  extends AEEditorBaseFragment
{
  private static final String TAG = AEEditorVideoClipFragment.class.getSimpleName();
  private axnn jdField_a_of_type_Axnn = axnl.a();
  private MoviePlayer jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
  private TAVCutVideoSession jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
  private AEEditorTopBar jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar;
  private AEEditorMvClipMenu b;
  private CMTimeRange c;
  private boolean cSH;
  private String cVn;
  private CMTimeRange d;
  private boolean dvh;
  private boolean dvi;
  private Context mContext;
  private TAVCutVideoView tavCutVideoView;
  
  private boolean aOR()
  {
    return (this.cVh != null) && (this.cVh.equals("AEEditorVideoEdit"));
  }
  
  private boolean aOS()
  {
    return (this.d != null) && (this.d != this.c);
  }
  
  private void eMa()
  {
    this.b.setMvClipMenuListener(new axli(this));
  }
  
  private void eMb()
  {
    if (this.c == null) {
      if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() > 60000000L)
      {
        localObject = CMTime.convertTimeScale(CMTime.fromMs(0L), 1000);
        localCMTime = CMTime.convertTimeScale(CMTime.fromMs(60000L), 1000).sub((CMTime)localObject);
        this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setPlayRange(new CMTimeRange((CMTime)localObject, localCMTime));
      }
    }
    long l;
    do
    {
      return;
      localObject = Long.valueOf(this.c.getStartUs());
      l = this.c.getEndUs();
    } while ((localObject == null) || (localObject == null));
    Object localObject = CMTime.convertTimeScale(CMTime.fromMs(((Long)localObject).longValue() / 1000L), 1000);
    CMTime localCMTime = CMTime.convertTimeScale(CMTime.fromMs(Long.valueOf(l).longValue() / 1000L), 1000).sub((CMTime)localObject);
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setPlayRange(new CMTimeRange((CMTime)localObject, localCMTime));
  }
  
  private void eMc()
  {
    if (this.mContext == null) {
      return;
    }
    new IntentFilter().addAction("android.media.AUDIO_BECOMING_NOISY");
    new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
  }
  
  private void eMd() {}
  
  private void eMe()
  {
    long l1 = -1L;
    long l2;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      this.b.setTime(new CMTimeRange(CMTime.CMTimeZero, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration()));
      this.b.setTAVSource(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getTAVSource());
      if (this.c == null) {
        break label108;
      }
      l2 = this.c.getStartUs() / 1000L;
      l1 = this.c.getEndUs() / 1000L;
    }
    for (;;)
    {
      this.b.aR(l2, l1);
      if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) {
        this.b.bindPlayer(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
      }
      return;
      label108:
      l2 = -1L;
    }
  }
  
  private void eMf()
  {
    if ((this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (!this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying())) {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
    }
  }
  
  private void eMg()
  {
    if ((this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying())) {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.pause();
    }
  }
  
  private CMTimeRange getTimeRange()
  {
    Bundle localBundle = getArguments();
    long l2;
    long l1;
    if (getActivity().getIntent().getExtras() != null)
    {
      l2 = getActivity().getIntent().getLongExtra("startTimeEdit", -1L);
      l1 = getActivity().getIntent().getLongExtra("endTimeEdit", -1L);
    }
    for (;;)
    {
      long l4;
      long l3;
      if (l2 != -1L)
      {
        l4 = l1;
        l3 = l2;
        if (l1 != -1L) {}
      }
      else
      {
        l4 = l1;
        l3 = l2;
        if (localBundle != null)
        {
          l4 = l1;
          l3 = l2;
          if (localBundle.containsKey("starttime"))
          {
            l4 = l1;
            l3 = l2;
            if (localBundle.containsKey("endtime"))
            {
              l3 = localBundle.getLong("starttime");
              l4 = localBundle.getLong("endtime");
            }
          }
        }
      }
      if ((l3 == -1L) || (l4 == -1L)) {
        return null;
      }
      return CMTimeRange.fromUs(l3, l4 - l3);
      l1 = -1L;
      l2 = -1L;
    }
  }
  
  private String getVideoPath()
  {
    ArrayList localArrayList = new ArrayList();
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("PhotoConst.SELECTED_PATHS"))) {
      localArrayList = localBundle.getStringArrayList("PhotoConst.SELECTED_PATHS");
    }
    while (localArrayList.size() > 0)
    {
      return (String)localArrayList.get(0);
      axiy.e(TAG, "no video paths");
    }
    return null;
  }
  
  private void initReceiver() {}
  
  private void jp(View paramView)
  {
    this.cVn = getVideoPath();
    this.c = getTimeRange();
    this.d = this.c;
    this.tavCutVideoView = ((TAVCutVideoView)paramView.findViewById(2131379260));
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = new MoviePlayer();
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setLoopPlay(true);
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setBackColor(getResources().getColor(2131165288));
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.addPlayerListener(new axlg(this));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = new TAVCutVideoSession();
    paramView = new SessionConfig();
    paramView.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    paramView.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    paramView.setMaxIntermediateRenderSize(this.jdField_a_of_type_Axnn.Rn());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setSessionConfig(paramView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setVideoPath(this.cVn);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addPlayer(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTAVCutVideoView(this.tavCutVideoView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.init(this.mContext);
    eMb();
  }
  
  private void release()
  {
    if (this.b != null) {
      this.b.release();
    }
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null)
    {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.release();
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = null;
    }
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
    }
  }
  
  private void u(View paramView)
  {
    this.b = ((AEEditorMvClipMenu)paramView.findViewById(2131372141));
    eMe();
    eMa();
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar = ((AEEditorTopBar)paramView.findViewById(2131380001));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTopBarClickListener(new axlh(this));
  }
  
  private void updateClipData()
  {
    if (this.c == null) {
      this.b.a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getTAVSource(), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L, 0L, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs());
    }
    Long localLong1;
    Long localLong2;
    do
    {
      return;
      localLong1 = Long.valueOf(this.c.getStartUs() / 1000L);
      localLong2 = Long.valueOf(this.c.getEndUs() / 1000L);
    } while ((localLong1 == null) || (localLong1 == null) || (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null));
    long l = (localLong2.longValue() - localLong1.longValue()) / 1000L;
    this.b.a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getTAVSource(), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L, localLong1.longValue(), localLong2.longValue());
  }
  
  public boolean aOM()
  {
    if (!aOS()) {
      a().cR(getActivity());
    }
    for (;;)
    {
      return true;
      Object localObject = getActivity();
      localObject = aqha.a((Context)localObject, 230).setTitle(acfp.m(2131689963)).setMessage(((Context)localObject).getString(2131689964)).setPositiveButton(((Context)localObject).getString(2131689963), new axlk(this)).setNegativeButton(((Context)localObject).getString(2131689950), new axlj(this));
      if (localObject != null) {
        try
        {
          if (!((aqju)localObject).isShowing())
          {
            ((aqju)localObject).show();
            return true;
          }
        }
        catch (Throwable localThrowable) {}
      }
    }
    return true;
  }
  
  public String getModuleId()
  {
    return "AEEditorVideoClip";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    axiy.i(TAG, "onCreate");
    super.onCreate(paramBundle);
    this.mContext = getActivity();
    this.dvi = true;
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    axiy.i(TAG, "onCreateView");
    this.cSH = axiz.aOK();
    paramLayoutInflater = paramLayoutInflater.inflate(2131558619, paramViewGroup, false);
    jp(paramLayoutInflater);
    u(paramLayoutInflater);
    initReceiver();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    axiy.i(TAG, "onDestroy");
    release();
    this.dvi = false;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (!paramBoolean)
    {
      if ((!aOR()) || (this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar == null)) {
        break label66;
      }
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setStyleAsCancelAndFinish();
    }
    while (!paramBoolean)
    {
      this.c = getTimeRange();
      this.d = this.c;
      eMb();
      if (this.dvi) {
        eMf();
      }
      return;
      label66:
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setLeftButtonAsBackArray();
    }
    eMg();
  }
  
  public void onPause()
  {
    super.onPause();
    axiy.i(TAG, "onPause");
    eMd();
    if ((this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying())) {}
    for (boolean bool = true;; bool = false)
    {
      this.dvh = bool;
      axiy.d(TAG, "onPause: mPreviousPlaying is " + this.dvh);
      eMg();
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    axiy.i(TAG, "onResume");
    eMc();
    axiy.d(TAG, "onResume: mPreviousPlaying is " + this.dvh);
    if (this.dvh) {
      eMf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment
 * JD-Core Version:    0.7.0.1
 */