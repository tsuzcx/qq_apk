package dov.com.qq.im.aeeditor.module.edit;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;
import aaqh;
import acfp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import aqha;
import aqju;
import axaq;
import axim;
import axip;
import axiy;
import axiz;
import axji;
import axjj.b.a;
import axjj.b.b;
import axjk;
import axjp;
import axjp.a;
import axki;
import axkj;
import axkn;
import axkt;
import axku;
import axmc;
import axmd;
import axme;
import axmf;
import axmg;
import axmh;
import axmi;
import axmj;
import axmk;
import axml;
import axmn;
import axmr;
import axmw;
import axnb.a;
import axng.a;
import axnl;
import axnm;
import axnn;
import axnw;
import axnw.a;
import axoe;
import axoh;
import ayva;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.video.FrameVideoHelper.a;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.tavcut.util.Util;
import com.tencent.tavcut.util.VideoUtil;
import com.tencent.tavcut.view.TAVCutVideoView;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.data.MusicData;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.controlpanel.AEEditorControlPanelContainer;
import dov.com.qq.im.aeeditor.module.controlpanel.VideoControlPanel;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel.a;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper.MusicDownloadRunnable;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper.a;
import dov.com.qq.im.aeeditor.module.toolbar.AEEditorToolBar;
import dov.com.qq.im.aeeditor.module.toolbar.AEEditorToolBar.a;
import dov.com.qq.im.aeeditor.module.toolbar.VideoEditToolBar;
import dov.com.qq.im.aeeditor.module.toolbar.VideoEditToolBar.a;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import rxc.a;

public class AEEditorVideoEditFragment
  extends AEEditorCommonEditFragment
  implements axjp.a, axng.a, FrameVideoHelper.a, AEEditorFilterControlPanel.a, AEEditorMusicHelper.a, VideoEditToolBar.a, rxc.a<CLIENT.StSmartMatchMusicRsp>
{
  private static final String TAG = AEEditorVideoEditFragment.class.getSimpleName();
  private ArrayList<String> FM;
  private ImageView Ir;
  private axki jdField_a_of_type_Axki = new axki();
  private axnb.a jdField_a_of_type_Axnb$a;
  private axnn jdField_a_of_type_Axnn = axnl.a();
  private Size jdField_a_of_type_ComTencentTavcutBeanSize;
  private TAVCutVideoSession jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
  private MusicData jdField_a_of_type_ComTencentWeseevideoModelDataMusicData;
  private VideoControlPanel jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel;
  private ProgressBar aB;
  private long aCo;
  private long aCp;
  private TextView aho;
  private axnb.a jdField_b_of_type_Axnb$a;
  private Size jdField_b_of_type_ComTencentTavcutBeanSize;
  private MoviePlayer jdField_b_of_type_ComTencentTavcutPlayerMoviePlayer;
  private boolean cSH;
  private String cVq;
  private BroadcastReceiver cb;
  private boolean dvm;
  private boolean dvn;
  private boolean dvo;
  private boolean dvp = true;
  private boolean dvq;
  private boolean dvr;
  private int eFX = -1;
  private LocalMediaInfo mLocalMediaInfo;
  private HashMap<Integer, Float> rl = new HashMap();
  private TAVCutVideoView tavCutVideoView;
  private String videoPath;
  
  static
  {
    File localFile = new File(axjj.b.a.cVc);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  private void KZ(boolean paramBoolean)
  {
    cZ(paramBoolean, false);
  }
  
  private void Yw(boolean paramBoolean)
  {
    if (this.Ir != null) {
      this.Ir.setSelected(paramBoolean);
    }
  }
  
  private Size a()
  {
    this.jdField_b_of_type_ComTencentTavcutBeanSize = VideoUtil.getVideoSize(this.videoPath);
    return this.jdField_a_of_type_Axnn.a(this.jdField_b_of_type_ComTencentTavcutBeanSize);
  }
  
  private void a(@Nullable axnb.a parama, boolean paramBoolean)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null) {
      return;
    }
    if ((parama == null) || (!this.dvq))
    {
      parama = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
      if (this.dvp) {}
      for (;;)
      {
        parama.setMainVolume(f1);
        if (this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(0.0F);
        return;
        f1 = 0.0F;
      }
    }
    Object localObject = AEEditorMusicHelper.b(parama);
    boolean bool = AEEditorMusicHelper.uh((String)localObject);
    if ((this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData != null) && (!paramBoolean)) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(0.0F);
    }
    if (bool)
    {
      parama.downloadStatus = 2;
      this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = AEEditorMusicHelper.a((String)localObject, parama.Rh(), parama.Ri());
      if (paramBoolean)
      {
        parama = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
        if (this.dvp) {}
        for (;;)
        {
          parama.setMainVolume(f1);
          return;
          f1 = 0.0F;
        }
      }
      parama = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
      localObject = this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData;
      f1 = f2;
      if (this.dvp) {
        f1 = 1.0F;
      }
      if (!this.dvj) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        parama.setBgmMusic((MusicData)localObject, f1, 1.0F, paramBoolean);
        if ((this.dvj) || (this.Ir.getVisibility() != 0)) {
          break;
        }
        Yw(true);
        return;
      }
    }
    if ((getActivity() == null) || (getActivity().getAppInterface() == null))
    {
      axiy.i(TAG, "[updateSoundAndMusicConfig], activity=null OR appInterface=null");
      return;
    }
    if (parama.downloadStatus == 1)
    {
      axiy.i(TAG, "[updateSoundAndMusicConfig], editorMusicInfo=" + parama + ", downloadStatus=STATUS_DOWNLOADING");
      return;
    }
    parama.downloadStatus = 1;
    ThreadManager.excute(new AEEditorMusicHelper.MusicDownloadRunnable(getActivity().getAppInterface(), parama, parama.Ia(), (String)localObject, this), 128, null, true);
  }
  
  private void b(@NonNull axnb.a parama, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) || (parama.aPf())) {}
    label129:
    for (;;)
    {
      return;
      List localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.hS();
      Iterator localIterator = localList.iterator();
      axnb.a locala;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          locala = (axnb.a)localIterator.next();
          if ((locala != null) && (!locala.aPf()) && (!locala.dvv) && (parama.getSongMid().equals(locala.getSongMid()))) {
            if (paramBoolean) {
              locala.downloadStatus = 2;
            }
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label129;
        }
        this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.oH(localList);
        return;
        locala.downloadStatus = 0;
        break;
      }
    }
  }
  
  private void bI(String paramString1, String paramString2, String paramString3)
  {
    if (getActivity() == null)
    {
      axiy.e(TAG, "activity is null.");
      return;
    }
    Intent localIntent = new Intent();
    Size localSize = a();
    localIntent.putExtra("ae_editor_video_flag", true);
    localIntent.putExtra("ae_editor_video_path", paramString1);
    localIntent.putExtra("ae_editor_video_thumb_path", paramString2);
    localIntent.putExtra("ae_editor_video_session_id", paramString3);
    localIntent.putExtra("ae_editor_video_export_size_height", localSize.getHeight());
    localIntent.putExtra("ae_editor_video_export_size_width", localSize.getWidth());
    localIntent.putStringArrayListExtra("ae_editor_video_text_cache", this.FM);
    localIntent.putExtra("ae_editor_video_from", this.eFX);
    getActivity().setResult(-1, localIntent);
    getActivity().finish();
  }
  
  private void c(@NonNull VsMusicItemInfo paramVsMusicItemInfo)
  {
    if (TextUtils.isEmpty(paramVsMusicItemInfo.mSongMid)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramVsMusicItemInfo.mSongMid);
    AEEditorMusicHelper.a(localArrayList, new axmd(this, paramVsMusicItemInfo));
  }
  
  private void cZ(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((this.dvo) && (this.jdField_b_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (!this.jdField_b_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying()))
      {
        if (paramBoolean2) {
          this.jdField_b_of_type_ComTencentTavcutPlayerMoviePlayer.seekToTime(CMTime.fromMs(0L));
        }
        this.jdField_b_of_type_ComTencentTavcutPlayerMoviePlayer.play();
      }
      return;
    }
    if ((this.jdField_b_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (this.jdField_b_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying()))
    {
      this.dvo = true;
      this.jdField_b_of_type_ComTencentTavcutPlayerMoviePlayer.pause();
      return;
    }
    this.dvo = false;
  }
  
  private void eMH()
  {
    this.cb = new axmc(this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    BaseApplicationImpl.getApplication().registerReceiver(this.cb, localIntentFilter);
  }
  
  private void eMI()
  {
    Long localLong1 = g();
    Long localLong2 = h();
    if ((localLong1 != null) && (localLong1 != null))
    {
      this.aCp = (Long.valueOf(localLong2.longValue() - localLong1.longValue()).longValue() / 1000L);
      this.aCo = (localLong1.longValue() / 1000L);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setClip(Long.valueOf(localLong1.longValue() / 1000L), Long.valueOf(this.aCp));
      jQ("视频裁剪Range", axoh.cv(this.aCo) + "~" + axoh.cv(localLong2.longValue() / 1000L));
    }
  }
  
  private void eMJ()
  {
    if (this.jdField_b_of_type_ComTencentTavcutPlayerMoviePlayer == null) {
      return;
    }
    if (!this.jdField_b_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying())
    {
      this.jdField_b_of_type_ComTencentTavcutPlayerMoviePlayer.play();
      return;
    }
    this.jdField_b_of_type_ComTencentTavcutPlayerMoviePlayer.pause();
  }
  
  private void eMM()
  {
    long l = 0L;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) {
      l = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L;
    }
    axip.a().a().mDuration = l;
    if ((this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel() != null) && (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList().size() > 0) && (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList().get(0) != null) && (((StickerModel)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList().get(0)).getTextItems() != null)) {
      axip.a().a().eFl = ((StickerModel)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList().get(0)).getTextItems().size();
    }
    axim.a().eKH();
  }
  
  private void eMx()
  {
    if (this.jdField_b_of_type_ComTencentTavcutPlayerMoviePlayer != null)
    {
      this.jdField_b_of_type_ComTencentTavcutPlayerMoviePlayer.release();
      this.jdField_b_of_type_ComTencentTavcutPlayerMoviePlayer = null;
    }
    this.jdField_b_of_type_ComTencentTavcutPlayerMoviePlayer = new MoviePlayer();
    this.jdField_b_of_type_ComTencentTavcutPlayerMoviePlayer.setLoopPlay(true);
    this.jdField_b_of_type_ComTencentTavcutPlayerMoviePlayer.setBackColor(getResources().getColor(2131165276));
    this.jdField_b_of_type_ComTencentTavcutPlayerMoviePlayer.addPlayerListener(new axmi(this));
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = null;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = new TAVCutVideoSession();
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localSessionConfig.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    localSessionConfig.setMaxIntermediateRenderSize(this.jdField_a_of_type_Axnn.Rn());
    StickerEditViewIconConfig localStickerEditViewIconConfig = new StickerEditViewIconConfig();
    localStickerEditViewIconConfig.setDeleteIconResId(2130837975);
    localStickerEditViewIconConfig.setEditIconResId(2130837973);
    localStickerEditViewIconConfig.setZoomIconResId(2130837976);
    localSessionConfig.setStickerEditViewIconConfig(localStickerEditViewIconConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setSessionConfig(localSessionConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setVideoPath(this.videoPath);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addPlayer(this.jdField_b_of_type_ComTencentTavcutPlayerMoviePlayer);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTAVCutVideoView(this.tavCutVideoView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setStickerOperationCallback(new axmj(this));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.init(getActivity());
    eMI();
    this.cVq = Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString());
    this.jdField_a_of_type_ComTencentTavcutBeanSize = a();
  }
  
  private void eMy()
  {
    if ((!this.dvm) && (!TextUtils.isEmpty(this.cVo)) && (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) && (this.dvn))
    {
      this.dvm = true;
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.ade(this.cVo);
    }
  }
  
  private Long g()
  {
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("starttime"))) {
      return Long.valueOf(localBundle.getLong("starttime"));
    }
    axiy.e(TAG, "no video clip start time");
    return null;
  }
  
  private String getVideoPath()
  {
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("select_path"))) {
      return localBundle.getString("select_path");
    }
    axiy.e(TAG, "no video paths");
    return null;
  }
  
  private int h(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return 3;
      }
      return 2;
    }
    if (paramBoolean2) {
      return 1;
    }
    return 0;
  }
  
  private Long h()
  {
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("endtime"))) {
      return Long.valueOf(localBundle.getLong("endtime"));
    }
    axiy.e(TAG, "no video clip start time");
    return null;
  }
  
  private void h(@NonNull String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AEEditorMusicHelper.a(paramString, paramInt1, paramInt2, paramLong, 0L, this);
  }
  
  private void jw(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel = ((VideoControlPanel)this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer);
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.setMusicOperationCallback(this);
    this.aB = ((ProgressBar)paramView.findViewById(2131381868));
    this.Ir = ((ImageView)paramView.findViewById(2131379263));
    this.Ir.setOnClickListener(new axmg(this));
    Yw(true);
    this.aho = ((TextView)paramView.findViewById(2131379264));
    this.tavCutVideoView = ((TAVCutVideoView)paramView.findViewById(2131379262));
    this.tavCutVideoView.setOnClickListener(new axmh(this));
  }
  
  public String HV()
  {
    return acfp.m(2131689957);
  }
  
  protected int Rd()
  {
    return 0;
  }
  
  public void Yx(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) {}
    List localList;
    do
    {
      return;
      this.dvq = paramBoolean;
      axip.a().a().eFk = h(this.dvp, this.dvq);
      localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.hS();
    } while (CollectionUtils.isEmpty(localList));
    Object localObject;
    int j;
    int i;
    if (paramBoolean)
    {
      if ((this.jdField_b_of_type_Axnb$a == null) || (this.jdField_b_of_type_Axnb$a.aPf())) {
        break label405;
      }
      int k = 0;
      localObject = null;
      j = 0;
      i = 0;
      if (k < localList.size())
      {
        axnb.a locala = (axnb.a)localList.get(k);
        int m;
        if ((locala != null) && (!locala.aPf())) {
          if (locala.dvv)
          {
            m = j;
            j = i;
            i = m;
          }
        }
        for (;;)
        {
          m = k + 1;
          k = j;
          j = i;
          i = k;
          k = m;
          break;
          if (this.jdField_b_of_type_Axnb$a.getSongMid().equals(locala.getSongMid()))
          {
            locala.selected = true;
            i = 1;
            j = k;
            localObject = locala;
          }
          else
          {
            locala.selected = false;
            m = i;
            i = j;
            j = m;
          }
        }
      }
    }
    for (;;)
    {
      if (j != 0)
      {
        this.jdField_b_of_type_Axnb$a = ((axnb.a)localObject);
        this.jdField_a_of_type_Axnb$a = ((axnb.a)localObject);
        label227:
        this.jdField_a_of_type_Axnb$a.selected = true;
        axip.a().a().cUW = this.jdField_a_of_type_Axnb$a.getSongMid();
        axim.a().eKM();
      }
      for (;;)
      {
        a(this.jdField_a_of_type_Axnb$a, false);
        this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.oH(localList);
        if (paramBoolean) {
          this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.aej(i);
        }
        if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar == null) || (!(this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar))) {
          break;
        }
        ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).YB(paramBoolean);
        return;
        this.jdField_b_of_type_Axnb$a = null;
        this.jdField_a_of_type_Axnb$a = ((axnb.a)localList.get(0));
        break label227;
        this.jdField_b_of_type_Axnb$a = this.jdField_a_of_type_Axnb$a;
        this.jdField_a_of_type_Axnb$a = null;
        localObject = localList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((axnb.a)((Iterator)localObject).next()).selected = false;
        }
        axip.a().a().cUW = "none";
        i = 0;
      }
      label405:
      localObject = null;
      j = 0;
      i = 0;
    }
  }
  
  public void Yy(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) {
      return;
    }
    this.dvp = paramBoolean;
    axip.a().a().eFk = h(this.dvp, this.dvq);
    a(this.jdField_a_of_type_Axnb$a, true);
  }
  
  protected axmw a()
  {
    return new axmk(this);
  }
  
  protected axnw.a a()
  {
    return new axml(this);
  }
  
  protected AEEditorFilterControlPanel.a a()
  {
    return this;
  }
  
  protected AEEditorToolBar.a a()
  {
    return this;
  }
  
  public void a(int paramInt, axkn paramaxkn)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.13(this, paramaxkn));
    }
    if (paramInt == 0)
    {
      axiy.i(TAG, "onAIFilterApplySuccess");
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.15(this));
      if ((this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) && (paramaxkn != null)) {
        break label107;
      }
    }
    label107:
    axku localaxku;
    do
    {
      return;
      axiy.i(TAG, "onAIFilterAppliedFailed:" + paramInt);
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.14(this));
      break;
      this.jdField_a_of_type_Axki.a(this.videoPath, paramaxkn);
      this.FM = a(paramaxkn);
      localaxku = (axku)paramaxkn;
    } while (localaxku == null);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setLutImage(null);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setAEKitAIFilter(localaxku.lutPath, 0.8F, localaxku.adjustParam, 0, 0.0F);
    aO(new String[] { "智能滤镜label", localaxku.sceneLabel, "智能滤镜errCode", String.valueOf(paramInt) });
    paramaxkn = "none";
    Iterator localIterator = NewEnhanceCategories.newEnhanceTypes.iterator();
    if (localIterator.hasNext())
    {
      NewEnhanceCategories localNewEnhanceCategories = (NewEnhanceCategories)localIterator.next();
      if (!localNewEnhanceCategories.serverLabel.equals(localaxku.sceneLabel)) {
        break label301;
      }
      paramaxkn = localNewEnhanceCategories.filterType;
    }
    label301:
    for (;;)
    {
      break;
      axip.a().a().cUV = ("lut_aieffect_" + paramaxkn);
      axip.a().a().Ek = -1.0F;
      return;
    }
  }
  
  public void a(int paramInt, String paramString, float paramFloat, AEEditorFilterBean paramAEEditorFilterBean)
  {
    eMs();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.YA(true);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.cancelAIFilter();
    if (this.rl.containsKey(Integer.valueOf(paramInt))) {}
    for (float f = ((Float)this.rl.get(Integer.valueOf(paramInt))).floatValue();; f = paramFloat)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(f);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setLutImage(paramString);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setLutAlpha(f);
      axip.a().a().cUV = paramAEEditorFilterBean.getSid();
      axip.a().a().Ek = paramFloat;
      return;
    }
  }
  
  public void a(@Nullable axnb.a parama, int paramInt)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null) || (parama == null) || (parama.aPf())) {
      return;
    }
    this.dvq = true;
    this.jdField_b_of_type_Axnb$a = this.jdField_a_of_type_Axnb$a;
    this.jdField_a_of_type_Axnb$a = parama;
    axip.a().a().eFk = h(this.dvp, this.dvq);
    axip.a().a().cUW = parama.getSongMid();
    axim.a().eKM();
    List localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.hS();
    Iterator localIterator = localList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      axnb.a locala = (axnb.a)localIterator.next();
      if ((locala != null) && (!locala.aPf()) && (!locala.dvv))
      {
        if (parama.getSongMid().equals(locala.getSongMid()))
        {
          locala.selected = true;
          this.jdField_a_of_type_Axnb$a = locala;
          parama = locala;
          i = 1;
        }
        for (;;)
        {
          break;
          locala.selected = false;
        }
      }
    }
    int j = paramInt;
    if (i == 0)
    {
      parama.selected = true;
      i = localList.size() - 1;
      if (paramInt <= i) {
        break label278;
      }
      j = i + 1;
      localList.add(parama);
    }
    for (;;)
    {
      a(parama, false);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.oH(localList);
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.aej(j);
      if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar == null) || (!(this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar))) {
        break;
      }
      ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).YB(true);
      return;
      label278:
      localList.add(paramInt, parama);
      j = paramInt;
    }
  }
  
  public void a(@NonNull axnb.a parama, boolean paramBoolean, @NonNull String paramString)
  {
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.12(this, parama, paramBoolean, paramString));
  }
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.10(this));
      return;
    }
    if (this.mLocalMediaInfo != null)
    {
      paramBoolean = true;
      if ((this.mLocalMediaInfo == null) && (aaqh.cix != 2)) {
        break label77;
      }
    }
    label77:
    for (int i = 0;; i = 1)
    {
      AEEditorMusicHelper.a(paramArrayList, axaq.a().b(), paramBoolean, this.mLocalMediaInfo, i, this);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  public boolean aOM()
  {
    if (this.cVq.equals(Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString()))) {
      return false;
    }
    Object localObject = getActivity();
    getActivity().getIntent().putExtra("startTimeEdit", g());
    getActivity().getIntent().putExtra("endTimeEdit", h());
    localObject = aqha.a((Context)localObject, 230).setTitle(acfp.m(2131689965)).setMessage(((Context)localObject).getString(2131689966)).setPositiveButton(((Context)localObject).getString(2131689965), new axmf(this)).setNegativeButton(((Context)localObject).getString(2131689950), new axme(this));
    if (localObject != null) {}
    try
    {
      if (!((aqju)localObject).isShowing()) {
        ((aqju)localObject).show();
      }
      label144:
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label144;
    }
  }
  
  protected boolean aOT()
  {
    return false;
  }
  
  public boolean aOV()
  {
    boolean bool2 = false;
    Object localObject = this.jdField_a_of_type_Axki.a(this.videoPath);
    boolean bool1;
    if ((localObject != null) && ((localObject instanceof axku)))
    {
      axiy.i(TAG, "onAIFilterRequest: has cache");
      bool1 = ((axku)localObject).bGa;
      if (!bool1) {
        break label98;
      }
      eMp();
      localObject = new axkt(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
      ((axkt)localObject).a(this);
      axjp.a().a(getActivity().getAppInterface(), getActivity(), (axkj)localObject);
    }
    for (;;)
    {
      if (!bool1) {
        bool2 = true;
      }
      return bool2;
      bool1 = true;
      break;
      label98:
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.YA(false);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.select(1);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setLutImage(null);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setAEKitAIFilter(((axkn)localObject).getLutPath(), 0.8F, ((axkn)localObject).getAdjustParam(), 0, 0.0F);
      aO(new String[] { "智能滤镜label", ((axkn)localObject).getSceneLabel(), "智能滤镜errCode", "0" });
    }
  }
  
  public boolean aOW()
  {
    return true;
  }
  
  public void applyCurrentSticker()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.applyCurrentSticker();
    }
  }
  
  public void b(boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    int k = 0;
    if ((!paramBoolean) || (paramStSmartMatchMusicRsp == null) || (CollectionUtils.isEmpty(paramStSmartMatchMusicRsp.vecMusic.get()))) {
      axiy.e(TAG, "[VSDispatchObserver.onVSRspCallBack.onReceive], music - request music list failed");
    }
    do
    {
      return;
      if ((paramStSmartMatchMusicRsp.extInfo != null) && (paramStSmartMatchMusicRsp.extInfo.mapInfo.size() != 0))
      {
        paramString = paramStSmartMatchMusicRsp.extInfo.mapInfo.get().iterator();
        while (paramString.hasNext())
        {
          localObject = (COMM.Entry)paramString.next();
          if ((localObject != null) && (((COMM.Entry)localObject).key.get().equals("CommonInfo"))) {
            axip.a().a().cUX = ((COMM.Entry)localObject).value.get();
          }
        }
      }
    } while (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer == null);
    paramString = AEEditorMusicHelper.bC(paramStSmartMatchMusicRsp.vecMusic.get());
    paramStSmartMatchMusicRsp = AEEditorMusicHelper.bD(paramString);
    List localList = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.hS();
    Object localObject = new LinkedList();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramString.iterator();
    paramString = "";
    if (localIterator.hasNext())
    {
      VsMusicItemInfo localVsMusicItemInfo = (VsMusicItemInfo)localIterator.next();
      if (!TextUtils.isEmpty(paramString)) {}
      for (paramString = paramString + "," + localVsMusicItemInfo.mSongMid;; paramString = paramString + localVsMusicItemInfo.mSongMid) {
        break;
      }
    }
    axip.a().a().cUY = paramString;
    int i = 0;
    int j = k;
    if (i < localList.size())
    {
      paramString = (axnb.a)localList.get(i);
      if ((paramString == null) || (paramString.aPf()) || (paramString.dvv)) {}
      for (;;)
      {
        i += 1;
        break;
        ((List)localObject).add(paramString);
        localHashMap.put(paramString.getSongMid(), paramString);
      }
    }
    if (j < paramStSmartMatchMusicRsp.size())
    {
      paramString = (axnb.a)paramStSmartMatchMusicRsp.get(j);
      if ((paramString == null) || (paramString.aPf())) {}
      for (;;)
      {
        j += 1;
        break;
        if (localHashMap.get(paramString.getSongMid()) == null) {
          ((List)localObject).add(paramString);
        }
      }
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.oH((List)localObject);
  }
  
  public void doOnBackPressed()
  {
    if (getArguments() != null) {
      getArguments().clear();
    }
    this.aCo = 0L;
    this.aCp = 0L;
  }
  
  public void eLK()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.cancelLoading();
    }
    QQToast.a(this.context, "资源下载中，请稍后再试", 0).show();
  }
  
  public void eMB()
  {
    eMs();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.YA(false);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.cancelAIFilter();
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setLutImage(null);
  }
  
  public void eMC() {}
  
  public void eMD() {}
  
  public void eME() {}
  
  public void eMF()
  {
    this.jdField_a_of_type_Axnw.a(getActivity(), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession, 0);
    KZ(false);
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.coy();
  }
  
  public void eMK()
  {
    getActivity().getIntent().putExtra("startTimeEdit", g());
    getActivity().getIntent().putExtra("endTimeEdit", h());
    axim.a().eKK();
    a().M(getModuleId(), getArguments());
  }
  
  public void eML()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(acfp.m(2131689946));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.coy();
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelVideoControlPanel.eMj();
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar)) {
      ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).ewk();
    }
    for (;;)
    {
      axim.a().eKJ();
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.hide();
    }
  }
  
  public void eMN()
  {
    AEEditorMusicHelper.gH(getActivity());
  }
  
  public void eMO()
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar instanceof VideoEditToolBar)) {
      ((VideoEditToolBar)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar).eNe();
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(acfp.m(2131689957));
      this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.cox();
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.show();
    }
  }
  
  protected void eMl()
  {
    this.videoPath = getVideoPath();
    this.cSH = axiz.aOK();
  }
  
  protected void eMm()
  {
    axjp.a().eLJ();
  }
  
  protected void eMn() {}
  
  public void eMo()
  {
    axiy.i(TAG, "exportVideo");
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.8(this));
    String str1 = axjj.b.b.cVg;
    Object localObject = new File(str1);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    File localFile = new File(this.videoPath);
    localObject = String.valueOf(System.currentTimeMillis());
    String str2 = str1 + File.separator + "output_" + (String)localObject + "_" + ayva.getFileNameWithoutExtension(localFile.getName()) + ".jpg";
    str1 = str1 + File.separator + "output_" + (String)localObject + "_" + ayva.getFileNameWithoutExtension(localFile.getName()) + ".mp4";
    eMM();
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.applyCurrentSticker();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getEffectVideoFrame(0L, 1080, new axmn(this, str2, (String)localObject, str1));
      return;
    }
    axjk.a().a((String)localObject, this.videoPath, str1, str2, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel());
    if (getActivity() == null)
    {
      axoe.a(BaseApplicationImpl.getContext(), str1, str2, (String)localObject, a(), this.FM, this.eFX);
      return;
    }
    bI(str1, str2, (String)localObject);
  }
  
  protected void eMr()
  {
    this.dvn = true;
    eMy();
  }
  
  public int getLayoutResourceId()
  {
    return 2131558620;
  }
  
  public String getModuleId()
  {
    return "AEEditorVideoEdit";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    axiy.i(TAG, "onCreate");
    super.onCreate(paramBundle);
    AEEditorMusicHelper.gG(getActivity());
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      this.eFX = getActivity().getIntent().getIntExtra("editorFrom", -1);
      paramBundle = (HashMap)getActivity().getIntent().getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        paramBundle = paramBundle.entrySet().iterator();
        while (paramBundle.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramBundle.next();
          if (localEntry.getValue() != null) {
            this.mLocalMediaInfo = ((LocalMediaInfo)localEntry.getValue());
          }
        }
      }
    }
  }
  
  public void onDestroyView()
  {
    axiy.i(TAG, "onDestroyView");
    super.onDestroyView();
    if (getArguments() != null) {
      getArguments().clear();
    }
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer.hide();
    }
    if (this.cb != null) {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.cb);
    }
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
    }
    this.rl.clear();
    this.dvp = true;
    this.dvq = false;
    this.jdField_a_of_type_Axnb$a = null;
    this.jdField_b_of_type_Axnb$a = null;
    this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = null;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    this.dvr = paramBoolean;
    if (!paramBoolean)
    {
      eMI();
      cZ(true, true);
      return;
    }
    KZ(false);
  }
  
  public void onPause()
  {
    super.onPause();
    axiy.i(TAG, "onPause");
    if (!this.dvr) {
      KZ(false);
    }
  }
  
  public void onResume()
  {
    axiy.i(TAG, "onResume");
    super.onResume();
    if (!this.dvr) {
      KZ(true);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    axiy.i(TAG, "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    jw(paramView);
    eMx();
    eMy();
    eMH();
    axip.a().a().cUW = "none";
    axip.a().a().eFk = h(this.dvp, this.dvq);
    paramView = VideoUtil.getVideoSize(this.videoPath);
    h(this.videoPath, paramView.getWidth(), paramView.getHeight(), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L);
    aO(new String[] { "设备级别", axnm.Ic(), "视频最大预览尺寸", String.valueOf(this.jdField_a_of_type_Axnn.Rn()), "视频原始尺寸", String.format("width=%d, height=%d", new Object[] { Integer.valueOf(this.jdField_b_of_type_ComTencentTavcutBeanSize.getWidth()), Integer.valueOf(this.jdField_b_of_type_ComTencentTavcutBeanSize.getHeight()) }), "视频导出尺寸", String.format("width=%d, height=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentTavcutBeanSize.getWidth()), Integer.valueOf(this.jdField_a_of_type_ComTencentTavcutBeanSize.getHeight()) }), "视频导出码率", String.valueOf(this.jdField_a_of_type_Axnn.Ro()), "视频导出帧率", String.valueOf(this.jdField_a_of_type_Axnn.Rp()) });
    if ((TextUtils.isEmpty(this.cVo)) && (aOu()))
    {
      if (axmr.a().aPb())
      {
        axiy.i(TAG, "single image + first time : aifilter auto request");
        aOV();
        eMu();
      }
    }
    else {
      return;
    }
    axiy.e(TAG, "single image + first time : aifilter res not ready, do not request");
  }
  
  public void v(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setLutAlpha(paramFloat);
    this.rl.put(Integer.valueOf(paramInt), Float.valueOf(paramFloat));
    axip.a().a().Ek = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment
 * JD-Core Version:    0.7.0.1
 */