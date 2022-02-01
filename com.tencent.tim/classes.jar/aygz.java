import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoReaderConf;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.pkvideo.PKFilter;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.reactive.Observer;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.reactive.UIThreadOffFunction;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.tencent.biz.qqstory.takevideo.EditGifImage;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalGifSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoGuide;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.7;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.8;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.9;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class aygz
  implements IEventReceiver
{
  public static ayym a;
  protected axrg a;
  protected aydf a;
  public aydx a;
  protected ayec a;
  public ayeh a;
  protected ayep a;
  protected ayfc a;
  protected ayfe a;
  protected ayft a;
  public ayfw a;
  public aygn a;
  protected aygo a;
  protected aygt a;
  protected aygw a;
  protected ayhi a;
  protected ayhk a;
  protected ayhn a;
  protected ayhp a;
  protected ayhs a;
  protected ayhw a;
  protected ayhy a;
  protected ayia a;
  public ayic a;
  protected ayih a;
  public ayii a;
  protected ayij a;
  protected ayil a;
  protected ayoy a;
  protected ayrm a;
  private SimpleObserver<ayqb> a;
  public EditGifImage a;
  public EditPicRawImage a;
  protected EditVideoGuide a;
  public EditVideoParams a;
  protected HWEditLocalVideoPlayer a;
  protected boolean aEN;
  protected boolean aHc;
  public boolean aHd;
  public boolean aHe;
  protected final AtomicInteger ar = new AtomicInteger(1);
  protected aydc b;
  protected aydi b;
  public ayfh b;
  public ayfr b;
  protected aygg b;
  protected aygp b;
  protected aygu b;
  private VideoStoryDataBean b;
  public EditVideoArtFilter b;
  public EditVideoFilter b;
  public Bundle bQ;
  public int bqq = -1;
  private int bqr;
  public boolean dzj = true;
  public ViewGroup fn;
  protected Map<Class<? extends aygy.a>, aygy.a> gf = new HashMap();
  protected List<aygy> lu = Collections.emptyList();
  private int mFrom;
  public int mOrientation;
  protected List<Error> oC = new ArrayList();
  public RelativeLayout ok;
  public Intent w;
  
  public static boolean F(long paramLong1, long paramLong2)
  {
    return (paramLong1 & paramLong2) == paramLong2;
  }
  
  private void a(EditVideoParams.EditSource paramEditSource, Observer<ayqb> paramObserver)
  {
    ayqb localayqb = new ayqb(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    localayqb.aAU = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.getStringExtra("extra_upload_temp_directory");
    if (localayqb.aAU == null) {
      localayqb.aAU = ayqu.ce(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi);
    }
    if ((paramEditSource instanceof EditLocalGifSource)) {
      if ((!TextUtils.isEmpty(paramEditSource.getSourcePath())) || (((EditLocalGifSource)paramEditSource).ns.size() <= 0)) {
        break label139;
      }
    }
    label139:
    for (localayqb.jdField_a_of_type_Ayqh = new ayqh((String)((EditLocalGifSource)paramEditSource).ns.get(0));; localayqb.jdField_a_of_type_Ayqh = new ayqh(paramEditSource.getSourcePath()))
    {
      paramEditSource = this.lu.iterator();
      while (paramEditSource.hasNext()) {
        ((aygy)paramEditSource.next()).a(0, localayqb);
      }
    }
    d(localayqb);
    e(localayqb);
    ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { localayqb.aAU });
    this.jdField_a_of_type_Ayii.a(acfp.m(2131705613), false, 500L);
    Stream.of(localayqb).map(new ayqe((aydg)a(aydg.class), null, true)).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2)).map(new ayqs(aydw.azs + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
  }
  
  private boolean a(ayqb paramayqb)
  {
    if (paramayqb.g.doodlePath != null) {}
    do
    {
      do
      {
        return true;
      } while (paramayqb.g.doodleRawPath != null);
      if (paramayqb.g.atJsonData != null)
      {
        ram.i("Q.qqstory.publish.edit.EditVideoPartManager", "HAS AT LABELS.");
        return true;
      }
    } while ((paramayqb.g.backgroundMusicPath != null) || (paramayqb.g.isMuteRecordVoice) || (paramayqb.aIB) || (paramayqb.g.saveMode != 0));
    return false;
  }
  
  private void bsW()
  {
    xa(0);
  }
  
  private void c(EditVideoParams.EditSource paramEditSource, Observer<ayqb> paramObserver)
  {
    Object localObject = new ayqb(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    ((ayqb)localObject).g.videoMaxrate = aniq.dFI;
    ((ayqb)localObject).g.videoMinrate = aniq.dFJ;
    ((ayqb)localObject).aAU = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.getStringExtra("extra_upload_temp_directory");
    if (((ayqb)localObject).aAU == null) {
      ((ayqb)localObject).aAU = ayqu.ce(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi);
    }
    ((ayqb)localObject).jdField_a_of_type_Ayqh = new ayqh(paramEditSource.getSourcePath());
    paramEditSource = this.lu.iterator();
    while (paramEditSource.hasNext()) {
      ((aygy)paramEditSource.next()).a(0, (ayqb)localObject);
    }
    d((ayqb)localObject);
    e((ayqb)localObject);
    ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { ((ayqb)localObject).aAU });
    this.jdField_a_of_type_Ayii.a(acfp.m(2131705602), false, 500L);
    this.ar.set(1);
    this.oC.clear();
    paramEditSource = Stream.of(localObject).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2)).map(new ayqs(false)).map(new ayqx());
    localObject = this.jdField_a_of_type_Ayii.getActivity();
    if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
    for (int i = this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.tc();; i = 0)
    {
      localObject = paramEditSource.map(new ayqi((Activity)localObject, i));
      paramEditSource = (EditVideoParams.EditSource)localObject;
      if (this.jdField_a_of_type_Ayfw != null) {
        paramEditSource = ((Stream)localObject).map(this.jdField_a_of_type_Ayfw.a(0));
      }
      localObject = paramEditSource;
      if (this.jdField_a_of_type_Ayfe != null) {
        localObject = paramEditSource.map(this.jdField_a_of_type_Ayfe.a(0));
      }
      ((Stream)localObject).map(new ayqt()).map((StreamFunction)ppf.a(aypz.class, new Object[0])).map(new ayqw(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
      return;
    }
  }
  
  private void checkState()
  {
    if ((this.jdField_a_of_type_Ayii == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null)) {
      throw new IllegalStateException("have not attach ui and params");
    }
  }
  
  private void eRF()
  {
    int j = 0;
    int k = 0;
    if (this.jdField_a_of_type_Ayfw != null)
    {
      Object localObject = this.jdField_a_of_type_Ayfw.a();
      if (localObject != null) {
        ((DoodleLayout)localObject).eSE();
      }
      localObject = this.jdField_a_of_type_Ayfw.a().a();
      int i = k;
      if (localObject != null)
      {
        i = k;
        if (((ayju)localObject).a.Lt())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "preparePublish");
          }
          this.jdField_a_of_type_Ayii.a(acfp.m(2131705500), false, 500L);
          this.jdField_a_of_type_Ayfw.bpW = 2;
          this.jdField_a_of_type_Ayfw.a().buk();
          i = 1;
        }
      }
      localObject = this.jdField_a_of_type_Ayfw.a().a();
      j = i;
      if (localObject != null)
      {
        ((ayjw)localObject).eSi();
        j = i;
      }
    }
    if (j == 0) {
      bsY();
    }
  }
  
  private void eRG()
  {
    int i;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg() == 14)
    {
      ram.i("Q.qqstory.publish.edit.EditVideoPartManager", "reportPublish()  entranceType=" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.th() + " , isEditCamera:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Lc());
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.th() != 120) {
        break label320;
      }
      i = 1;
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Lc()) {
        break label325;
      }
    }
    label320:
    label325:
    for (int j = 1;; j = 2)
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject1.put("lens_id", axpa.cVC);
        localJSONObject1.put("lens_tab", a().getLensTabId());
        localJSONObject1.put("watermark_id", a().getWatermarkId());
        localJSONObject1.put("music_id", a().getSongMid());
        localJSONObject1.put("filter_id", a().getFilterId());
        localJSONObject1.put("sticker_id", a().getStickerId());
        localJSONObject1.put("word_id", a().getWordId());
        if (a().getMusicType() == 1) {
          localJSONObject1.put("music_play_time", a().getMusciPlayTime());
        }
        localJSONObject1.put("video_duration", a().getVideoDuration());
        localJSONObject2.put("music_type", a().getMusicType());
        localJSONObject2.put("filter_type", a().getFilterType());
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      sqn.a("mystatus_edit", "post_clk", i, 0, new String[] { String.valueOf(j), "", localJSONObject1.toString(), localJSONObject2.toString() });
      return;
      i = 2;
      break;
    }
  }
  
  private void f(ayqb paramayqb)
  {
    if (paramayqb.businessId != 1) {}
    do
    {
      do
      {
        return;
        localObject = awte.a(awte.eCS);
      } while ((localObject == null) || (!((QQFilterRenderManager)localObject).hasQQFilter(183)));
      localObject = ((QQFilterRenderManager)localObject).getQQFilters(183);
    } while ((localObject == null) || (((List)localObject).size() <= 0));
    Object localObject = (PKFilter)((List)localObject).get(0);
    paramayqb.g.putExtra("has_game_pk_filter", Boolean.valueOf(true));
    paramayqb.g.putExtra("game_pk_video_path", ((PKFilter)localObject).getPKVideoPath());
    paramayqb.g.putExtra("game_pk_cover_path", ((PKFilter)localObject).getPKCoverPath());
    paramayqb.g.putExtra("game_pk_result_path", ((PKFilter)localObject).getPKTitleBmgPath());
    ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "put pk encode config at manager : video=" + ((PKFilter)localObject).getPKVideoPath() + ",pkCover=" + ((PKFilter)localObject).getPKCoverPath() + " pk result=" + ((PKFilter)localObject).getPKTitleBmgPath());
  }
  
  public static boolean r(long paramLong, int paramInt)
  {
    return (paramInt & paramLong) == paramInt;
  }
  
  private void xa(int paramInt)
  {
    String str1;
    if (La())
    {
      c("pub_photo", 0, 0, new String[] { "", "5000" });
      str1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.getStringExtra("mCurrentTemplatePath");
      if (TextUtils.isEmpty(str1)) {
        break label220;
      }
      paramInt = 1;
      label52:
      if (paramInt != 0)
      {
        paramInt = tk();
        String str2 = gd(str1);
        if (!La()) {
          break label225;
        }
        str1 = "2";
        label78:
        d("pub_changeface", paramInt, 0, new String[] { "1", str2, str1 });
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.getBooleanExtra("extra_is_slide_show_video", false)) {
        rar.a("video_edit", "pub_slides", 0, 0, new String[0]);
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.th() != 104) {
        break label232;
      }
    }
    label220:
    label225:
    label232:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        rar.a("video_shoot_fromweb", "done_pub", 0, 0, new String[0]);
      }
      return;
      c("pub_video", 0, 0, new String[] { "", String.valueOf(x(paramInt)) });
      Bosses.get().postJob(new ayhd(this, "Q.qqstory.publish.edit.EditVideoPartManager"));
      break;
      paramInt = 0;
      break label52;
      str1 = "1";
      break label78;
    }
  }
  
  public Bundle F()
  {
    if (this.bQ == null) {
      return new Bundle();
    }
    return this.bQ;
  }
  
  public boolean La()
  {
    checkThread();
    checkState();
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.La();
  }
  
  public boolean Ld()
  {
    checkThread();
    checkState();
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Ld();
  }
  
  public int QD()
  {
    int j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.mMode;
    int i = j;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalVideoSource))
    {
      i = j;
      if (j != 9) {
        i = 2;
      }
    }
    return i;
  }
  
  public int RP()
  {
    if (Ld())
    {
      if (La()) {
        return 3;
      }
      return 4;
    }
    if (La()) {
      return 1;
    }
    return 2;
  }
  
  public int RR()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) {}
    switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg())
    {
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    default: 
      return 0;
    case 11: 
      return 2;
    case 4: 
    case 12: 
      return 3;
    case 3: 
      return 4;
    case 2: 
      return 5;
    }
    return 1;
  }
  
  public int RS()
  {
    if (Ld())
    {
      if (La()) {
        return 3;
      }
      return 4;
    }
    if (La()) {
      return 1;
    }
    return 2;
  }
  
  public Bitmap W()
  {
    Bitmap localBitmap = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage != null) {
      localBitmap = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage.V();
    }
    return localBitmap;
  }
  
  public void Zo(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Ayfh != null) {
      this.jdField_b_of_type_Ayfh.tz(paramBoolean);
    }
  }
  
  public int a(@NonNull Message paramMessage)
  {
    checkThread();
    if (this.aHd)
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "broadcast message ignore because of publishing");
      return 0;
    }
    Iterator localIterator = this.lu.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((aygy)localIterator.next()).f(Message.obtain(paramMessage))) {
        break label94;
      }
      i += 1;
    }
    label94:
    for (;;)
    {
      break;
      if (i == 0) {
        ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "broadcastEditVideoMessage, but no one handled", new Object[] { paramMessage });
      }
      paramMessage.recycle();
      return i;
    }
  }
  
  public ayfh a()
  {
    return this.jdField_b_of_type_Ayfh;
  }
  
  public ayfw a()
  {
    return this.jdField_a_of_type_Ayfw;
  }
  
  @Nullable
  public aygy.a a(Class<? extends aygy.a> paramClass)
  {
    if (paramClass == null) {
      throw new IllegalArgumentException("editExportClass should not be null");
    }
    return (aygy.a)this.gf.get(paramClass);
  }
  
  public VideoStoryDataBean a()
  {
    if (this.jdField_b_of_type_ComTencentBizVideostorySupportVideoStoryDataBean == null)
    {
      VideoStoryDataBean localVideoStoryDataBean2 = (VideoStoryDataBean)F().getSerializable("KEY_VIDEO_STORY_CAMERA_TYPE");
      VideoStoryDataBean localVideoStoryDataBean1 = localVideoStoryDataBean2;
      if (localVideoStoryDataBean2 == null) {
        localVideoStoryDataBean1 = new VideoStoryDataBean();
      }
      this.jdField_b_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = localVideoStoryDataBean1;
    }
    return this.jdField_b_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
  }
  
  protected SimpleObserver<ayqb> a()
  {
    if (this.jdField_a_of_type_ComTribeAsyncReactiveSimpleObserver != null) {
      return this.jdField_a_of_type_ComTribeAsyncReactiveSimpleObserver;
    }
    return new ayhf(this, SystemClock.uptimeMillis());
  }
  
  void a(Intent paramIntent, int paramInt, PublishParam paramPublishParam, TribeVideoPublishParams paramTribeVideoPublishParams)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Ayii.a(-1, paramIntent, 2130772067, 0, true);
      return;
    case 101: 
      paramIntent.setClassName("com.tencent.mobileqq", ForwardRecentActivity.class.getName());
      paramIntent.putExtra("forward_type", 21);
      paramIntent.putExtra("forward_ability_entrence_show_in_share", true);
      paramIntent.putExtra("k_qzone", true);
      paramIntent.putExtra("k_qqstory", true);
      paramIntent.putExtra("forward_thumb", paramPublishParam.thumbPath);
      paramIntent.putExtra("forward_urldrawable", true);
      paramIntent.putExtra("forward_urldrawable_big_url", paramPublishParam.thumbPath);
      paramIntent.putExtra("forward_urldrawable_thumb_url", paramPublishParam.thumbPath);
      paramIntent.putExtra("k_dataline", false);
      paramIntent.putExtra("k_smartdevice", false);
      paramIntent.putExtra("k_favorites", false);
      paramIntent.putExtra("k_phonecontacts", false);
      paramIntent.putExtra("forward_photo_shortvideo_is_edited", true);
      paramIntent.putExtra("forward_source_from_shoot_quick", true);
      this.jdField_a_of_type_Ayii.getActivity().startActivityForResult(paramIntent, 10004);
      rar.a("plus_shoot", "exp_send", 0, 0, new String[] { "", "", "", "" });
      return;
    case 11: 
      paramPublishParam = null;
      Iterator localIterator = this.lu.iterator();
      paramInt = -1;
      if (localIterator.hasNext())
      {
        aygy localaygy = (aygy)localIterator.next();
        if (!(localaygy instanceof ayda)) {
          break label403;
        }
        paramInt = ((ayda)localaygy).RO();
        paramPublishParam = ((ayda)localaygy).Ip();
      }
      break;
    }
    label403:
    for (;;)
    {
      break;
      paramIntent.putExtra("theme_id", paramInt);
      paramIntent.putExtra("theme_name", paramPublishParam);
      paramIntent.putExtra(TribeVideoPublishParams.BUNDLE_EXTRA_KEY, paramTribeVideoPublishParams);
      if (QLog.isColorLevel()) {
        QLog.i("tribe_publish", 2, "getPublishIntent");
      }
      this.jdField_a_of_type_Ayii.a(-1, paramIntent, 2130772067, 0, true);
      return;
      this.jdField_a_of_type_Ayii.a(-1, paramIntent, 2130772067, 0, true);
      return;
    }
  }
  
  public void a(ayii paramayii, EditVideoParams paramEditVideoParams)
  {
    checkThread();
    if ((paramayii == null) || (paramEditVideoParams == null)) {
      throw new IllegalArgumentException("both ui ant params should not be null");
    }
    if ((this.jdField_a_of_type_Ayii != paramayii) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != paramEditVideoParams))
    {
      this.jdField_a_of_type_Ayii = paramayii;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
      a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      paramEditVideoParams = this.lu.iterator();
    }
    while (paramEditVideoParams.hasNext())
    {
      ((aygy)paramEditVideoParams.next()).a(paramayii);
      continue;
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "duplicate attachUiAndParams ui=%s, params=%s", new Object[] { paramayii, paramEditVideoParams });
    }
  }
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    ram.b("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %s", paramEditVideoParams);
    long l = paramEditVideoParams.aCQ;
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    label188:
    label612:
    int i;
    if (paramEditVideoParams.asi == 11)
    {
      localObject = new ayda(this, l);
      this.jdField_b_of_type_Ayfh = ((ayfh)localObject);
      localArrayList.add(localObject);
      if ((!axcg.b(this.jdField_a_of_type_Ayii.getActivity().getIntent(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg())) && (!axcg.ao(this.jdField_a_of_type_Ayii.getActivity().getIntent())))
      {
        localObject = new ayeh(this);
        this.jdField_a_of_type_Ayeh = ((ayeh)localObject);
        localArrayList.add(localObject);
      }
      localObject = new aydf(this);
      this.jdField_a_of_type_Aydf = ((aydf)localObject);
      localArrayList.add(localObject);
      if (!paramEditVideoParams.La()) {
        break label1650;
      }
      localObject = new EditPicRawImage(this, l);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage = ((EditPicRawImage)localObject);
      localArrayList.add(localObject);
      if (r(l, 2048))
      {
        localObject = new EditVideoGuide(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide = ((EditVideoGuide)localObject);
        localArrayList.add(localObject);
      }
      if (r(l, 2))
      {
        if (paramEditVideoParams.asi != 14) {
          break label1783;
        }
        localArrayList.add(new srs(this));
      }
      label257:
      if ((paramEditVideoParams.Lb()) && (axsf.ON))
      {
        localObject = new ayep(this);
        this.jdField_a_of_type_Ayep = ((ayep)localObject);
        localArrayList.add(localObject);
        if (r(l, 16777216)) {
          this.jdField_a_of_type_Ayep.dyL = true;
        }
      }
      if (r(l, 1024))
      {
        localObject = new ayfe(this);
        this.jdField_a_of_type_Ayfe = ((ayfe)localObject);
        localArrayList.add(localObject);
      }
      if ((r(l, 536870912)) || (r(l, 1)) || (r(l, 8)))
      {
        localObject = new ayfw(this, l);
        this.jdField_a_of_type_Ayfw = ((ayfw)localObject);
        localArrayList.add(localObject);
        localObject = new ayhn(this);
        this.jdField_a_of_type_Ayhn = ((ayhn)localObject);
        localArrayList.add(localObject);
        localObject = new ayhp(this);
        this.jdField_a_of_type_Ayhp = ((ayhp)localObject);
        localArrayList.add(localObject);
        if ((F(l, 274877906944L)) && (paramEditVideoParams.asi == 1) && (((DynamicTextConfigManager)axov.a(7)).aPN()))
        {
          localObject = new ayft(this, paramEditVideoParams.mFrom);
          this.jdField_a_of_type_Ayft = ((ayft)localObject);
          localArrayList.add(localObject);
        }
      }
      if (r(l, 256))
      {
        if ((paramEditVideoParams.asi != 1) && (paramEditVideoParams.asi != 2) && (paramEditVideoParams.asi != 11) && (paramEditVideoParams.asi != 12) && (paramEditVideoParams.asi != 3) && (paramEditVideoParams.asi != 13)) {
          break label1813;
        }
        localObject = new ayhz(this, r(l, 2097152));
        this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter = ((EditVideoFilter)localObject);
        localArrayList.add(localObject);
      }
      if (r(l, 512))
      {
        localObject = new aygp(this);
        this.jdField_b_of_type_Aygp = ((aygp)localObject);
        localArrayList.add(localObject);
      }
      if (((paramEditVideoParams.La()) || (paramEditVideoParams.Le())) && (r(l, 128)))
      {
        localObject = new EditVideoArtFilter(this);
        this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter = ((EditVideoArtFilter)localObject);
        localArrayList.add(localObject);
      }
      if ((paramEditVideoParams.La()) && (r(l, 4)))
      {
        localObject = new aydx(this);
        this.jdField_a_of_type_Aydx = ((aydx)localObject);
        localArrayList.add(localObject);
      }
      if (r(l, 8192))
      {
        if (!axcg.ao(this.jdField_a_of_type_Ayii.getActivity().getIntent())) {
          break label1842;
        }
        localObject = new ayec(this);
        this.jdField_a_of_type_Ayec = ((ayec)localObject);
        localArrayList.add(localObject);
      }
      label793:
      if (r(l, 32768))
      {
        localObject = new aydi(this);
        this.jdField_b_of_type_Aydi = ((aydi)localObject);
        localArrayList.add(localObject);
      }
      if (r(l, 131072))
      {
        localObject = new ayhi(this);
        this.jdField_a_of_type_Ayhi = ((ayhi)localObject);
        localArrayList.add(localObject);
      }
      if (r(l, 1048576))
      {
        localObject = new ayhy(this);
        this.jdField_a_of_type_Ayhy = ((ayhy)localObject);
        localArrayList.add(localObject);
      }
      if ((paramEditVideoParams.Lb()) && (r(l, 262144)))
      {
        localObject = new aygg(this);
        this.jdField_b_of_type_Aygg = ((aygg)localObject);
        localArrayList.add(localObject);
      }
      if (r(l, 8388608))
      {
        localObject = new ayhw(this);
        this.jdField_a_of_type_Ayhw = ((ayhw)localObject);
        localArrayList.add(localObject);
      }
      if (r(l, 67108864))
      {
        localObject = new ayic(this);
        this.jdField_a_of_type_Ayic = ((ayic)localObject);
        localArrayList.add(localObject);
      }
      if (r(l, 268435456))
      {
        localObject = new ayil(this);
        this.jdField_a_of_type_Ayil = ((ayil)localObject);
        localArrayList.add(localObject);
        localObject = new ayoy(this);
        this.jdField_a_of_type_Ayoy = ((ayoy)localObject);
        localArrayList.add(localObject);
        localObject = new aygn(this, this.jdField_a_of_type_Ayil, this.jdField_a_of_type_Ayoy);
        this.jdField_a_of_type_Aygn = ((aygn)localObject);
        localArrayList.add(localObject);
      }
      if (r(l, 134217728))
      {
        localObject = new aygw(this);
        this.jdField_a_of_type_Aygw = ((aygw)localObject);
        localArrayList.add(localObject);
      }
      if (r(l, 16))
      {
        localObject = new ayih(this);
        this.jdField_a_of_type_Ayih = ((ayih)localObject);
        localArrayList.add(localObject);
      }
      if (r(l, 33554432))
      {
        localObject = new aygu(this);
        this.jdField_b_of_type_Aygu = ((aygu)localObject);
        localArrayList.add(localObject);
      }
      if (F(l, 4294967296L))
      {
        localObject = new ayfr(this, l);
        this.jdField_b_of_type_Ayfr = ((ayfr)localObject);
        localArrayList.add(localObject);
      }
      if ((axcg.c.ob(paramEditVideoParams.entryType)) && ((paramEditVideoParams.Lc()) || (paramEditVideoParams.La()) || (paramEditVideoParams.Lb())))
      {
        localObject = new ayrm(this);
        this.jdField_a_of_type_Ayrm = ((ayrm)localObject);
        localArrayList.add(localObject);
      }
      if ((paramEditVideoParams.asi == 1) && (r(paramEditVideoParams.aCQ, 131072))) {
        localArrayList.add(new ayew(this));
      }
      if (F(paramEditVideoParams.aCQ, 34359738368L))
      {
        localObject = new aygt(this);
        this.jdField_a_of_type_Aygt = ((aygt)localObject);
        localArrayList.add(localObject);
      }
      if (F(l, 137438953472L))
      {
        localObject = new ayfc(this);
        this.jdField_a_of_type_Ayfc = ((ayfc)localObject);
        localArrayList.add(localObject);
      }
      if (r(l, 16384))
      {
        i = paramEditVideoParams.mExtra.getInt("uintype", -1);
        if (i != -1) {
          break label1925;
        }
        ram.e("Q.qqstory.publish.edit.EditVideoPartManager", " curType have not set but it use BUSINESS_QQ ID, that is illegal!!");
      }
    }
    for (;;)
    {
      eS(localArrayList);
      this.lu = Collections.unmodifiableList(localArrayList);
      ram.b("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %d", Integer.valueOf(this.lu.size()));
      paramEditVideoParams = this.lu.iterator();
      while (paramEditVideoParams.hasNext()) {
        ram.b("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts : %s", ((aygy)paramEditVideoParams.next()).getClass().getSimpleName());
      }
      if (paramEditVideoParams.asi == 12)
      {
        localObject = new kqj(this, l);
        this.jdField_b_of_type_Ayfh = ((ayfh)localObject);
        localArrayList.add(localObject);
        break;
      }
      if (paramEditVideoParams.asi == 14)
      {
        localObject = new ayia(this);
        this.jdField_a_of_type_Ayia = ((ayia)localObject);
        localArrayList.add(localObject);
        break;
      }
      localObject = new ayfh(this, l);
      this.jdField_b_of_type_Ayfh = ((ayfh)localObject);
      localArrayList.add(localObject);
      break;
      label1650:
      if (paramEditVideoParams.Le())
      {
        localObject = new EditGifImage(this);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage = ((EditGifImage)localObject);
        localArrayList.add(localObject);
        break label188;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer = new HWEditLocalVideoPlayer(this);
      if (paramEditVideoParams.Ld())
      {
        if (Build.VERSION.SDK_INT < 14) {
          break label188;
        }
        localArrayList.add(new ayis(this));
        break label188;
      }
      if (paramEditVideoParams.Lg())
      {
        localArrayList.add(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer);
        break label188;
      }
      localObject = new ayhk(this);
      this.jdField_a_of_type_Ayhk = ((ayhk)localObject);
      localArrayList.add(localObject);
      break label188;
      label1783:
      localObject = new axrg(this, false);
      this.jdField_a_of_type_Axrg = ((axrg)localObject);
      localArrayList.add(localObject);
      break label257;
      label1813:
      localObject = new EditVideoFilter(this);
      this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter = ((EditVideoFilter)localObject);
      localArrayList.add(localObject);
      break label612;
      label1842:
      if (!axcg.b(this.jdField_a_of_type_Ayii.getActivity().getIntent(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg()))
      {
        localObject = new ayhs(this);
        this.jdField_a_of_type_Ayhs = ((ayhs)localObject);
        localArrayList.add(localObject);
        break label793;
      }
      localObject = new ayec(this);
      this.jdField_a_of_type_Ayec = ((ayec)localObject);
      localArrayList.add(localObject);
      break label793;
      label1925:
      this.jdField_b_of_type_Aydc = new aydc(this, i, true);
      localArrayList.add(this.jdField_b_of_type_Aydc);
    }
  }
  
  public void a(Class<? extends aygy.a> paramClass, aygy.a parama)
  {
    checkThread();
    checkState();
    if (paramClass == null) {
      throw new IllegalArgumentException("editExportClass should not be null");
    }
    if (!paramClass.isInstance(parama)) {
      throw new IllegalArgumentException("the 2nd parameter's type " + parama.getClass().getName() + " is not instance of " + paramClass.getName());
    }
    aygy.a locala = (aygy.a)this.gf.get(paramClass);
    if (locala == null) {
      ram.d("Q.qqstory.publish.edit.EditVideoPartManager", "publishEditExport for %s with %s", paramClass.getSimpleName(), parama);
    }
    for (;;)
    {
      this.gf.put(paramClass, parama);
      return;
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "publishEditExport for %s replace %s by %s", new Object[] { paramClass.getSimpleName(), locala, parama });
    }
  }
  
  protected void a(QQPermissionCallback paramQQPermissionCallback)
  {
    if (Build.VERSION.SDK_INT < 23) {}
    Activity localActivity;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Ayii == null);
      localActivity = this.jdField_a_of_type_Ayii.getActivity();
    } while (!(localActivity instanceof AppActivity));
    if (!aczy.bd(localActivity)) {}
    for (int i = 1;; i = 0)
    {
      LinkedList localLinkedList = new LinkedList();
      if (i != 0)
      {
        localLinkedList.add("android.permission.READ_EXTERNAL_STORAGE");
        localLinkedList.add("android.permission.WRITE_EXTERNAL_STORAGE");
      }
      if (localLinkedList.size() <= 0) {
        break;
      }
      ((AppActivity)localActivity).requestPermissions(paramQQPermissionCallback, 1, (String[])localLinkedList.toArray(new String[0]));
      return;
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    ayhm localayhm = (ayhm)a(ayhm.class);
    if (localayhm != null)
    {
      if (!(localayhm instanceof HWEditLocalVideoPlayer)) {
        break label41;
      }
      ((HWEditLocalVideoPlayer)localayhm).b(paramBoolean, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }
    label41:
    while (!(localayhm instanceof ayis)) {
      return;
    }
    ((ayis)localayhm).b(paramBoolean, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public boolean aQB()
  {
    checkThread();
    checkState();
    if ((this.bQ == null) || (!Ld())) {
      return false;
    }
    return this.bQ.getBoolean("KEY_FROM_PIC_TO_VIDEO", false);
  }
  
  public boolean aQC()
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      axiy.i("Q.qqstory.publish.edit.EditVideoPartManager", "checkPermission---below android6.0, no need check");
      return true;
    }
    if (this.jdField_a_of_type_Ayii == null) {
      return false;
    }
    boolean bool = aczy.bd(this.jdField_a_of_type_Ayii.getContext());
    axiy.i("Q.qqstory.publish.edit.EditVideoPartManager", "checkPermission,   grantStorage: " + bool);
    return bool;
  }
  
  public boolean aQD()
  {
    return (this.jdField_a_of_type_Ayrm != null) && (this.jdField_a_of_type_Ayrm.dAx);
  }
  
  public void adA(String paramString)
  {
    QLog.w("Q.qqstory.publish.edit.EditVideoPartManager", 1, "onDlnaVideoSaved videoPath " + paramString);
    if (paramString != null)
    {
      avpw.d locald = avpw.d.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("key_video_path", paramString);
      avpw.e(this.jdField_a_of_type_Ayii.getActivity(), locald, localBundle, -1);
    }
  }
  
  public void aw(Map<Long, TrackerStickerParam.MotionInfo> paramMap)
  {
    if (this.jdField_a_of_type_Ayfw != null) {
      this.jdField_a_of_type_Ayfw.aw(paramMap);
    }
  }
  
  public ayii b()
  {
    return this.jdField_a_of_type_Ayii;
  }
  
  public aypi b()
  {
    if (this.jdField_b_of_type_Aygu != null) {
      return this.jdField_b_of_type_Aygu.a();
    }
    return null;
  }
  
  public rmw b()
  {
    if (this.jdField_a_of_type_Ayic != null) {
      return this.jdField_a_of_type_Ayic.b();
    }
    return null;
  }
  
  public void b(EditVideoParams.EditSource paramEditSource, Observer<ayqb> paramObserver)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject1;
    int i;
    int j;
    String str1;
    float f;
    int k;
    String str2;
    boolean bool1;
    ArrayList localArrayList;
    String str3;
    String str4;
    if ((paramEditSource instanceof EditRecordVideoSource))
    {
      localObject1 = (EditRecordVideoSource)paramEditSource;
      ram.d("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + aniq.dHk + " CodecParam.mRecordTime" + aniq.bQi);
      aniq.bQi = (int)((EditRecordVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a).recordTime;
      aniq.dHk = ((EditRecordVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a).bpF;
      aniq.dFO = 0;
      aniq.dHo = 0;
      if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.tc();; i = 0)
      {
        aniq.bsT = i;
        i = ((EditRecordVideoSource)localObject1).bpK;
        j = ((EditRecordVideoSource)localObject1).bpL;
        str1 = ((EditRecordVideoSource)localObject1).sourcePath;
        f = ((EditRecordVideoSource)localObject1).mH;
        k = ((EditRecordVideoSource)localObject1).bpJ;
        str2 = ((EditRecordVideoSource)localObject1).azu;
        bool1 = ((EditRecordVideoSource)localObject1).aGI;
        localArrayList = new ArrayList();
        str3 = String.format("%s.%d", new Object[] { QQStoryContext.a().mi(), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
        ram.d("Q.qqstory.publish.edit.EditVideoPartManager", "publish video groupId=%s. fragment count=%d", str3, Integer.valueOf(localArrayList.size()));
        str4 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.getStringExtra("extra_upload_temp_directory");
        if ((!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Lb()) || (!r(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.aCQ, 262144))) {
          break label744;
        }
        localObject1 = null;
        if (this.jdField_b_of_type_Aygg != null) {
          localObject1 = this.jdField_b_of_type_Aygg.cb();
        }
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break;
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localArrayList.add(Integer.valueOf(((ayjg)((Iterator)localObject1).next()).bqJ));
        }
      }
    }
    if ((paramEditSource instanceof EditLocalVideoSource))
    {
      localObject1 = (EditLocalVideoSource)paramEditSource;
      ram.d("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + aniq.dHk + " CodecParam.mRecordTime" + aniq.bQi);
      aniq.bQi = 5000;
      aniq.dHk = 125;
      aniq.dFO = 0;
      aniq.dHo = 0;
      if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.tc();; i = 0)
      {
        aniq.bsT = i;
        j = ((EditLocalVideoSource)localObject1).getWidth();
        k = ((EditLocalVideoSource)localObject1).getHeight();
        i = Math.min(j, k);
        j = Math.max(j, k);
        str1 = ((EditLocalVideoSource)localObject1).getSourcePath();
        f = i * 1.0F / j;
        k = ((EditLocalVideoSource)localObject1).d.rotation;
        str2 = "";
        bool1 = false;
        ram.d("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo EditLocalVideoSource.mediaInfo" + ((EditLocalVideoSource)localObject1).d.toString());
        break;
      }
    }
    if ((paramEditSource instanceof EditTakeVideoSource))
    {
      localObject1 = (EditTakeVideoSource)paramEditSource;
      ram.d("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + aniq.dHk + " CodecParam.mRecordTime" + aniq.bQi);
      aniq.bQi = 5000;
      aniq.dHk = 125;
      aniq.dFO = 0;
      aniq.dHo = 0;
      if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.tc();; i = 0)
      {
        aniq.bsT = i;
        i = ((EditTakeVideoSource)localObject1).getWidth();
        j = ((EditTakeVideoSource)localObject1).getHeight();
        str1 = ((EditTakeVideoSource)localObject1).getSourcePath();
        f = i * 1.0F / j;
        k = ((EditTakeVideoSource)localObject1).d.rotation;
        str2 = "";
        bool1 = false;
        break;
      }
    }
    throw new IllegalArgumentException(acfp.m(2131705608) + paramEditSource);
    ram.e("Q.qqstory.publish.edit.EditVideoPartManager", "can not find any video fragment ! break the process of publish");
    return;
    label744:
    localArrayList.add(Integer.valueOf(0));
    this.ar.set(localArrayList.size());
    this.oC.clear();
    int m = 0;
    int n;
    Object localObject2;
    if (m < localArrayList.size())
    {
      n = ((Integer)localArrayList.get(m)).intValue();
      xa(n);
      localObject1 = new ayqb(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      ((ayqb)localObject1).g.multiFragmentGroupId = str3;
      ((ayqb)localObject1).g.createTime = (m * 1000 + l);
      ((ayqb)localObject1).g.videoMaxrate = aniq.dFI;
      if (anki.axH())
      {
        ((ayqb)localObject1).g.videoMaxrate = (anki.JM() * 1000);
        ((ayqb)localObject1).g.putExtra("composite_key_bitrate_mode", Boolean.valueOf(anki.axH()));
      }
      ((ayqb)localObject1).g.videoMinrate = aniq.dFJ;
      ((ayqb)localObject1).g.videoUploadGroupTempDir = str4;
      ((ayqb)localObject1).aAU = ayqu.ce(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi);
      localObject2 = this.jdField_a_of_type_Ayii.getActivity();
      boolean bool2;
      if ((this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) && (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.tc() == 5))
      {
        bool2 = true;
        ((ayqb)localObject1).jdField_a_of_type_Ayqj = new ayqj((Activity)localObject2, i, j, str1, f, bool2, k, 0.0D, 0.0D, str2, bool1);
        if ((!(paramEditSource instanceof EditTakeVideoSource)) && (!(paramEditSource instanceof EditLocalVideoSource))) {
          break label1148;
        }
        ((ayqb)localObject1).g.putExtra("is_hw_encode", Boolean.valueOf(true));
      }
      for (;;)
      {
        ((ayqb)localObject1).g.putExtra("thumb_rotation", Integer.valueOf(k));
        ((ayqb)localObject1).g.putExtra("composite_key_capturemode", Integer.valueOf(QD()));
        ((ayqb)localObject1).g.putExtra("composite_key_entrance", Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.th()));
        f((ayqb)localObject1);
        localObject2 = this.lu.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((aygy)((Iterator)localObject2).next()).a(n, (ayqb)localObject1);
        }
        bool2 = false;
        break;
        label1148:
        ((ayqb)localObject1).g.putExtra("is_hw_encode", Boolean.valueOf(false));
      }
      localObject2 = ((ayqb)localObject1).jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.getStringExtra("extra_text_filter_text");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (TextUtils.isEmpty(((ayqb)localObject1).g.videoDoodleDescription)) {
          ((ayqb)localObject1).g.videoDoodleDescription = ((String)localObject2);
        }
      }
      else
      {
        label1212:
        d((ayqb)localObject1);
        e((ayqb)localObject1);
        ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { ((ayqb)localObject1).aAU });
        this.jdField_a_of_type_Ayii.a(acfp.m(2131705551), false, 500L);
        localObject2 = Stream.of(localObject1).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2));
        if (((ayqb)localObject1).businessId != 1) {
          break label1684;
        }
        if ((!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakeVideoSource)) && (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalVideoSource))) {
          break label1659;
        }
        localObject1 = new ayqo(null, (ayhm)a(ayhm.class), n);
        label1339:
        localObject2 = ((Stream)localObject2).map((StreamFunction)localObject1);
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Ayfw != null)
        {
          localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_Ayfw.a(n));
          if ((this.jdField_a_of_type_Ayfw.a.a().isEmpty()) && (iX() == 0L)) {
            break label1813;
          }
          localObject1 = ((Stream)localObject1).map(new ayqd(this.jdField_a_of_type_Ayfw, (aydh)a(aydh.class), n));
        }
      }
    }
    label1684:
    label1813:
    for (;;)
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Ayfe != null) {
        localObject2 = ((Stream)localObject1).map(this.jdField_a_of_type_Ayfe.a(n));
      }
      localObject1 = localObject2;
      Object localObject3;
      if (this.jdField_a_of_type_Aygo != null)
      {
        localObject3 = this.jdField_a_of_type_Aygo.a(n);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((Stream)localObject2).map((StreamFunction)localObject3);
        }
      }
      if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalVideoSource))) {}
      for (localObject1 = ((Stream)localObject1).map(new ayqp());; localObject1 = ((Stream)localObject1).map(new ayqt()).map((StreamFunction)ppf.a(aypz.class, new Object[0])))
      {
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg() == 14) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.mExtra.putInt("VIDEO_STORY_JUMP_TO_TYPE", axcg.j(this.jdField_a_of_type_Ayii.getActivity().getIntent()));
        }
        ((Stream)localObject1).map(new ayqw(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
        m += 1;
        break;
        localObject3 = new StringBuilder();
        PublishVideoEntry localPublishVideoEntry = ((ayqb)localObject1).g;
        localPublishVideoEntry.videoDoodleDescription += (String)localObject2;
        break label1212;
        label1659:
        localObject1 = new ayqk(null, (ayhm)a(ayhm.class), n);
        break label1339;
        if (((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalVideoSource)))
        {
          localObject1 = new ayqo(null, (ayhm)a(ayhm.class), 0);
          break label1339;
        }
        localObject1 = new ayqk();
        break label1339;
      }
      paramEditSource = this.lu.iterator();
      while (paramEditSource.hasNext()) {
        ((aygy)paramEditSource.next()).eRt();
      }
      break;
    }
  }
  
  public void bsF()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide.aYE == 2)) {
      changeState(10);
    }
  }
  
  public void bsV()
  {
    checkThread();
    checkState();
    axim.a().eKC();
    String str;
    if (La())
    {
      str = "2";
      c("clk_left", 0, 0, new String[] { str });
      ras.so("0X80076B6");
      ras.sp("0X80075C2");
      ras.aP(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg(), "0X8007823");
      if (this.jdField_a_of_type_Ayfw == null) {
        break label349;
      }
    }
    label312:
    label349:
    for (int j = this.jdField_a_of_type_Ayfw.tb();; j = 0)
    {
      int i = j;
      if (this.jdField_b_of_type_Aygp != null)
      {
        i = j;
        if (!TextUtils.isEmpty(this.jdField_b_of_type_Aygp.mS())) {
          i = j + 1;
        }
      }
      j = i;
      if (this.jdField_a_of_type_Aydx != null) {
        j = i + this.jdField_a_of_type_Aydx.bpC;
      }
      i = j;
      if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
      {
        i = j;
        if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.KW()) {
          i = j + 4;
        }
      }
      ram.b("Q.qqstory.publish.edit.EditVideoPartManager", "tryQuitRecordUI, current is preview state, edit count = %d", Integer.valueOf(i));
      if (i < 3)
      {
        bsr();
        return;
        str = "1";
        break;
      }
      if (La())
      {
        str = "2";
        c("clk_left_float", 0, 0, new String[] { str });
        ras.so("0X80076B7");
        ras.sp("0X80075C3");
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.La()) {
          break label312;
        }
        str = acfp.m(2131705611);
      }
      for (;;)
      {
        ausj localausj = ausj.a(this.jdField_a_of_type_Ayii.getContext(), false);
        localausj.setMainTitle(str);
        localausj.addButton(acfp.m(2131705655), 3);
        localausj.addCancelButton(acfp.m(2131705573));
        localausj.a(new ayha(this, localausj));
        localausj.show();
        return;
        str = "1";
        break;
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Le()) || (this.aHe)) {
          str = acfp.m(2131705671);
        } else {
          str = acfp.m(2131705647);
        }
      }
    }
  }
  
  public void bsX()
  {
    if (aQC())
    {
      eRF();
      return;
    }
    a(new ayhe(this));
  }
  
  public void bsY()
  {
    if (this.jdField_a_of_type_Ayii == null) {
      QLog.e("Q.qqstory.publish.edit.EditVideoPartManager", 1, "onPreparePublishDone error, mUi is null");
    }
    label92:
    Object localObject2;
    do
    {
      return;
      cF(this.jdField_a_of_type_Ayii.getContext());
      bsn();
      localObject1 = this.jdField_a_of_type_Ayii.getActivity();
      if ((localObject1 instanceof EditPicActivity)) {}
      switch (((Activity)localObject1).getIntent().getIntExtra("editpic_cameratype", -1))
      {
      default: 
        if (getFrom() != 7) {
          break label223;
        }
        awsy.gD(this.jdField_a_of_type_Ayii.getContext());
        localObject2 = rma.a();
      }
    } while (localObject2 == null);
    Object localObject1 = ((rma)localObject2).getPhotoList();
    Object localObject3 = ((List)localObject1).iterator();
    int i = 0;
    label141:
    if (((Iterator)localObject3).hasNext())
    {
      if (((SlideItemInfo)((Iterator)localObject3).next()).mediaType != 1) {
        break label440;
      }
      i += 1;
    }
    label440:
    for (;;)
    {
      break label141;
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("sv_latest_taken_photo_time", -1L).commit();
      aytu.cxA();
      break label92;
      aytu.cxB();
      break label92;
      aytu.cxC();
      break label92;
      label223:
      break;
      int m = ((List)localObject1).size();
      int k = ((rma)localObject2).tF();
      localObject2 = this.jdField_a_of_type_Ayii.getActivity().getIntent();
      int j;
      if (localObject2 != null)
      {
        localObject3 = (EditVideoParams)((Intent)localObject2).getParcelableExtra(EditVideoParams.class.getName());
        if (localObject3 != null) {
          j = ((EditVideoParams)localObject3).getIntExtra("extra_ablum_type", -1);
        }
      }
      for (;;)
      {
        if (k == 11) {}
        for (k = 0;; k = 1)
        {
          rar.a("video_edit_slides", "clk_pub", k, 0, new String[] { rar.dZ(j) + "", ((List)localObject1).size() + "", m - i + "", i + "" });
          return;
          j = ((Intent)localObject2).getIntExtra("extra_ablum_type", -1);
          break;
        }
        j = -1;
      }
    }
  }
  
  public void bsn()
  {
    int i = 0;
    checkThread();
    checkState();
    EditVideoParams.EditSource localEditSource = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "onConfirmClick : %s", new Object[] { localEditSource });
    Intent localIntent = this.jdField_a_of_type_Ayii.getActivity().getIntent();
    if (!this.aHd)
    {
      if ((axcg.b(localIntent, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg())) || (axcg.ao(localIntent)))
      {
        if (this.jdField_a_of_type_Ayii.getActivity() != null) {
          break label191;
        }
        localObject = "";
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalVideoSource))
        {
          LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a = new EditLocalPhotoSource((String)localObject, localLocalMediaInfo);
        }
        eRI();
        this.aHd = true;
        localObject = (ayhm)a(ayhm.class);
        if (localObject != null) {
          ((ayhm)localObject).pause();
        }
        if ((!axcg.b(localIntent, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg())) && (!axcg.ao(localIntent))) {
          break;
        }
        eRG();
        return;
        label191:
        if (this.jdField_a_of_type_Ayii.getActivity().getIntent() == null) {
          localObject = "";
        } else if (this.jdField_a_of_type_Ayii.getActivity().getIntent().getBundleExtra("state") == null) {
          localObject = "";
        } else {
          localObject = this.jdField_a_of_type_Ayii.getActivity().getIntent().getBundleExtra("state").getString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH");
        }
      }
    }
    ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "requestPublish duplicate");
    return;
    Object localObject = a();
    if (((localEditSource instanceof EditRecordVideoSource)) || ((localEditSource instanceof EditLocalVideoSource)) || ((localEditSource instanceof EditTakeVideoSource)))
    {
      b(localEditSource, (Observer)localObject);
      if ((localEditSource instanceof EditLocalVideoSource)) {
        rar.a("video_edit", "pub_local", 0, 1, new String[0]);
      }
    }
    for (;;)
    {
      eRG();
      return;
      if (((localEditSource instanceof EditLocalPhotoSource)) || ((localEditSource instanceof EditTakePhotoSource)))
      {
        bsW();
        aniq.bQi = 5000;
        aniq.dHk = 125;
        aniq.dFO = 0;
        aniq.dHo = 0;
        if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
        for (i = this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.tc();; i = 0)
        {
          aniq.bsT = i;
          c(localEditSource, (Observer)localObject);
          break;
        }
      }
      if ((localEditSource instanceof EditLocalGifSource))
      {
        aniq.bQi = 5000;
        aniq.dHk = 125;
        aniq.dFO = 0;
        aniq.dHo = 0;
        if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {
          i = this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.tc();
        }
        aniq.bsT = i;
        a(localEditSource, (Observer)localObject);
      }
    }
  }
  
  protected void bsr()
  {
    ayhm localayhm = (ayhm)a(ayhm.class);
    if (localayhm != null) {
      localayhm.pause();
    }
    this.jdField_a_of_type_Ayii.a(0, null, 2130772067, 0);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg() == 1)
    {
      int i = QD();
      rar.b("time_edit", 1, (int)(System.currentTimeMillis() - iY()), new String[] { rar.bY(i), "1", "", "" });
    }
  }
  
  void bta()
  {
    if (this.jdField_a_of_type_Ayfw != null)
    {
      DoodleLayout localDoodleLayout = this.jdField_a_of_type_Ayfw.a();
      if (localDoodleLayout != null) {
        localDoodleLayout.a.bue();
      }
    }
  }
  
  void btb()
  {
    int j = 0;
    Object localObject = this.jdField_a_of_type_Aydx;
    ((aydx)localObject).bpC += tl();
    if (this.bqq == 11) {
      changeState(0);
    }
    int i;
    do
    {
      return;
      localObject = this.jdField_a_of_type_Ayfw.a();
      ((DoodleLayout)localObject).eSD();
      ayju localayju = ((DoodleLayout)localObject).a();
      i = j;
      if (localayju != null)
      {
        i = j;
        if (localayju.a.Lt())
        {
          this.jdField_a_of_type_Ayii.a(acfp.m(2131705568), false, 500L);
          this.jdField_a_of_type_Ayfw.bpW = 3;
          ((DoodleLayout)localObject).buk();
          i = 1;
        }
      }
    } while (i != 0);
    btc();
  }
  
  public void btc()
  {
    this.jdField_a_of_type_Ayii.bpm();
    Object localObject3 = this.jdField_a_of_type_Ayfw.a();
    Object localObject1 = ((DoodleLayout)localObject3).g(0);
    Object localObject2 = ((DoodleLayout)localObject3).h(0);
    this.jdField_a_of_type_Aydx.dV[0] = localObject1[0];
    this.jdField_a_of_type_Aydx.dV[1] = localObject1[1];
    this.jdField_a_of_type_Aydx.dV[2] = localObject2[0];
    this.jdField_a_of_type_Aydx.dV[3] = localObject2[1];
    this.jdField_a_of_type_Aydx.dV[4] = ((DoodleLayout)localObject3).a().tp();
    localObject2 = W();
    if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
      return;
    }
    localObject1 = localObject2;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi != 1)
    {
      localObject3 = ((DoodleLayout)localObject3).U();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        long l = SystemClock.uptimeMillis();
        localObject1 = rop.d((Bitmap)localObject2, (Bitmap)localObject3);
        ram.d("Q.qqstory.publish.edit.EditVideoPartManager", "onCropBtnPressed merge ： cost " + (SystemClock.uptimeMillis() - l));
      }
    }
    this.jdField_a_of_type_Aydx.cx = ((Bitmap)localObject1);
    changeState(11);
  }
  
  void btd()
  {
    if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter == null) {
      return;
    }
    changeState(0);
    changeState(12);
  }
  
  public void bte()
  {
    if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter != null) {
      this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.bsz();
    }
    btf();
    changeState(0);
  }
  
  public void btf()
  {
    if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter != null) {
      ThreadManager.post(new EditVideoPartManager.8(this), 5, null, true);
    }
    ThreadManager.getUIHandler().post(new EditVideoPartManager.9(this));
  }
  
  public View c(long paramLong)
  {
    if (this.jdField_b_of_type_Ayfh != null) {
      return this.jdField_b_of_type_Ayfh.c(paramLong);
    }
    return null;
  }
  
  public void c(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 1) {
      Bosses.get().postJob(new ayhb(this, "Q.qqstory.publish.edit.EditVideoPartManager", paramString, paramInt1, paramInt2, paramVarArgs));
    }
  }
  
  public void cF(Context paramContext)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.th() == 14) {
      rar.a("story_grp", "clk_send", 0, 0, new String[0]);
    }
    long l = dT();
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    int i;
    if ((localObject instanceof EditRecordVideoSource)) {
      if (((EditRecordVideoSource)localObject).bpG == 1) {
        i = 1;
      }
    }
    for (;;)
    {
      int j = tk();
      if (La())
      {
        localObject = "2";
        label81:
        d("clk_publish", j, 0, new String[] { localObject, String.valueOf(l), String.valueOf(i), arxn.bI(paramContext) });
        if (r(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.aCQ, 262144))
        {
          i = tm();
          if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Ld()) {
            break label224;
          }
        }
      }
      label224:
      for (paramContext = "0";; paramContext = "1")
      {
        d("pub_edit_more", 0, 0, new String[] { String.valueOf(i), paramContext });
        return;
        i = 2;
        break;
        if (!(localObject instanceof EditTakePhotoSource)) {
          break label231;
        }
        if (((EditTakePhotoSource)localObject).bpG == 1)
        {
          i = 1;
          break;
        }
        i = 2;
        break;
        localObject = "1";
        break label81;
      }
      label231:
      i = 3;
    }
  }
  
  View cN()
  {
    if (this.jdField_b_of_type_Ayfh != null) {
      return this.jdField_b_of_type_Ayfh.cN();
    }
    return null;
  }
  
  public final void changeState(int paramInt)
  {
    r(paramInt, null);
  }
  
  protected void checkThread()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("can not access by non-ui thread");
    }
  }
  
  public void d(ayqb paramayqb)
  {
    Object localObject = paramayqb.g.readerConfBytes;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = new qqstory_struct.VideoReaderConf();
      ((qqstory_struct.VideoReaderConf)localObject).ban_type.set(0);
      ((qqstory_struct.VideoReaderConf)localObject).setHasFlag(true);
      paramayqb.g.readerConfBytes = ((qqstory_struct.VideoReaderConf)localObject).toByteArray();
    }
  }
  
  public void d(Error paramError)
  {
    ram.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH error ：" + paramError);
    Iterator localIterator = this.lu.iterator();
    while (localIterator.hasNext()) {
      ((aygy)localIterator.next()).c(paramError);
    }
    rar.b("video_edit", "pub_error", 0, 0, new String[] { paramError.toString() });
    this.oC.add(paramError);
    if (this.ar.decrementAndGet() > 0) {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    do
    {
      return;
      this.aHd = false;
      this.jdField_a_of_type_Ayii.bpm();
      QQToast.a(this.jdField_a_of_type_Ayii.getContext(), acfp.m(2131705533), 0).show();
      paramError = (ayhm)a(ayhm.class);
    } while (paramError == null);
    paramError.play();
  }
  
  public void d(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    Bosses.get().postJob(new ayhc(this, "Q.qqstory.publish.edit.EditVideoPartManager", paramString, paramInt1, paramInt2, paramVarArgs));
  }
  
  public long dT()
  {
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    long l;
    if ((localObject instanceof EditRecordVideoSource)) {
      l = ((EditRecordVideoSource)localObject).recordTime;
    }
    for (;;)
    {
      if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      switch (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.tc())
      {
      default: 
        return l;
        if (((localObject instanceof EditTakePhotoSource)) || ((localObject instanceof EditLocalPhotoSource)) || ((localObject instanceof EditLocalGifSource)))
        {
          l = 5000L;
        }
        else if ((localObject instanceof EditLocalVideoSource))
        {
          localObject = (EditLocalVideoSource)localObject;
          l = ((EditLocalVideoSource)localObject).endTime - ((EditLocalVideoSource)localObject).startTime;
          if (l == 0L) {
            l = ((EditLocalVideoSource)localObject).d.mDuration;
          }
        }
        else if ((localObject instanceof EditTakeVideoSource))
        {
          l = ((EditTakeVideoSource)localObject).d.mDuration;
        }
        else
        {
          throw new RuntimeException(acfp.m(2131705664));
        }
        break;
      case 1: 
        return l / 2L;
      case 2: 
        return l * 2L;
      case 4: 
        return l * 4L;
      case 3: 
        return ((float)l / 1.5F);
      }
    }
  }
  
  public void e(Bitmap paramBitmap, boolean paramBoolean)
  {
    checkThread();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage.setBitmap(paramBitmap, paramBoolean);
    }
  }
  
  public void e(Animation paramAnimation) {}
  
  public void e(ayqb paramayqb)
  {
    long l = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.mExtra.getLong("troop_uin");
    if (l != 0L)
    {
      Object localObject = new qqstory_struct.VideoReaderConf();
      ((qqstory_struct.VideoReaderConf)localObject).ban_type.set(1);
      ((qqstory_struct.VideoReaderConf)localObject).user_list.set(new ArrayList());
      ((qqstory_struct.VideoReaderConf)localObject).setHasFlag(true);
      paramayqb.g.readerConfBytes = ((qqstory_struct.VideoReaderConf)localObject).toByteArray();
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Long.valueOf(l));
      if (((ArrayList)localObject).size() > 0) {
        try
        {
          qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
          byte[] arrayOfByte = paramayqb.g.spreadGroupBytes;
          if (arrayOfByte != null) {}
          try
          {
            localVideoSpreadGroupList.mergeFrom(paramayqb.g.spreadGroupBytes);
            localVideoSpreadGroupList.group_list.set((List)localObject);
            localVideoSpreadGroupList.visibility_type.set(4);
            localVideoSpreadGroupList.setHasFlag(true);
            paramayqb.g.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
            return;
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            for (;;)
            {
              ram.e("Q.qqstory.publish.edit.EditVideoPartManager", "checkTroopStory", localInvalidProtocolBufferMicroException);
            }
          }
          return;
        }
        finally {}
      }
    }
  }
  
  public void eJ(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Ayfw != null) {
      this.jdField_a_of_type_Ayfw.a().eO(paramInt, paramString);
    }
  }
  
  public boolean eO(int paramInt)
  {
    return this.bqq == paramInt;
  }
  
  public boolean eP(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGuide.bqm == paramInt) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void eRH()
  {
    if (Build.VERSION.SDK_INT < 23) {}
    while (this.jdField_a_of_type_Ayii == null) {
      return;
    }
    if (!aczy.bd(this.jdField_a_of_type_Ayii.getContext())) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = new LinkedList();
      if (i != 0)
      {
        ((List)localObject).add("android.permission.WRITE_EXTERNAL_STORAGE");
        ((List)localObject).add("android.permission.READ_EXTERNAL_STORAGE");
        axiy.i("Q.qqstory.publish.edit.EditVideoPartManager", "【storage Permission】denied");
      }
      localObject = aqha.i((String[])((List)localObject).toArray(new String[0]));
      ThreadManager.getUIHandler().post(new EditVideoPartManager.7(this, (String)localObject));
      return;
    }
  }
  
  void eRI()
  {
    if (this.jdField_a_of_type_Ayfw != null) {
      this.jdField_a_of_type_Ayfw.a().eSF();
    }
    changeState(19);
    if (rma.a().tG() == 22)
    {
      LpReportInfo_pf00064.allReport(680, 2, 6);
      LpReportInfo_pf00064.allReport(680, 12, 1);
    }
  }
  
  void eRJ()
  {
    this.jdField_a_of_type_Ayfw.a().eSF();
    changeState(47);
    if (rma.a().tG() == 22)
    {
      LpReportInfo_pf00064.allReport(680, 2, 5);
      LpReportInfo_pf00064.allReport(680, 13, 1);
    }
  }
  
  public void eRK()
  {
    if (this.jdField_a_of_type_Ayfw != null) {
      this.jdField_a_of_type_Ayfw.a().eSH();
    }
  }
  
  public void eRL()
  {
    if (this.jdField_a_of_type_Ayfw != null) {
      this.jdField_a_of_type_Ayfw.a().eSI();
    }
  }
  
  public void eRM()
  {
    if (this.jdField_a_of_type_Ayfw != null)
    {
      DoodleLayout localDoodleLayout = this.jdField_a_of_type_Ayfw.a();
      if (localDoodleLayout != null) {
        localDoodleLayout.a.eSc();
      }
      if (this.jdField_a_of_type_Ayfw != null) {
        this.jdField_a_of_type_Ayfw.eNw();
      }
    }
  }
  
  public void eRN()
  {
    if (this.jdField_b_of_type_Aygu != null) {
      this.jdField_b_of_type_Aygu.Zn(false);
    }
  }
  
  public void eRy()
  {
    checkThread();
    checkState();
    Iterator localIterator = this.lu.iterator();
    while (localIterator.hasNext()) {
      ((aygy)localIterator.next()).eRy();
    }
  }
  
  protected void eS(List<aygy> paramList) {}
  
  public void ezi()
  {
    this.jdField_a_of_type_Ayii = null;
  }
  
  public void f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    ayhm localayhm = (ayhm)a(ayhm.class);
    if (localayhm != null)
    {
      if (!(localayhm instanceof HWEditLocalVideoPlayer)) {
        break label43;
      }
      ((HWEditLocalVideoPlayer)localayhm).f(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    }
    label43:
    while (!(localayhm instanceof ayis)) {
      return;
    }
    ((ayis)localayhm).f(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  public void f(Animation paramAnimation) {}
  
  public void f(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
  
  public String gd(String paramString)
  {
    if ((paramString != null) && (paramString.length() >= PtvTemplateManager.bYM.length())) {
      return ":" + paramString.substring(PtvTemplateManager.bYM.length());
    }
    return "";
  }
  
  public int getFrom()
  {
    return this.mFrom;
  }
  
  public List<aygy> getParts()
  {
    return this.lu;
  }
  
  public long getVideoTime()
  {
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    if ((localObject instanceof EditRecordVideoSource)) {
      return ((EditRecordVideoSource)localObject).recordTime;
    }
    if (((localObject instanceof EditTakePhotoSource)) || ((localObject instanceof EditLocalPhotoSource)) || ((localObject instanceof EditLocalGifSource))) {
      return 5000L;
    }
    long l;
    if ((localObject instanceof EditLocalVideoSource))
    {
      localObject = (EditLocalVideoSource)localObject;
      l = ((EditLocalVideoSource)localObject).endTime - ((EditLocalVideoSource)localObject).startTime;
      if (l == 0L) {
        return ((EditLocalVideoSource)localObject).d.mDuration;
      }
    }
    else
    {
      if ((localObject instanceof EditTakeVideoSource)) {
        return ((EditTakeVideoSource)localObject).d.mDuration;
      }
      throw new RuntimeException(acfp.m(2131705576));
    }
    return l;
  }
  
  public long iX()
  {
    if (this.jdField_b_of_type_Ayfr != null) {
      return this.jdField_b_of_type_Ayfr.aCJ;
    }
    return 0L;
  }
  
  public long iY()
  {
    if ((this.jdField_a_of_type_Ayii instanceof EditVideoActivity)) {
      return ((EditVideoActivity)this.jdField_a_of_type_Ayii).mCreateTime;
    }
    if ((this.jdField_a_of_type_Ayii instanceof EditPicActivity)) {
      return ((EditPicActivity)this.jdField_a_of_type_Ayii).mCreateTime;
    }
    return -1L;
  }
  
  public boolean isValidate()
  {
    return this.aEN;
  }
  
  public void om(long paramLong)
  {
    if (this.jdField_a_of_type_Ayfw != null) {
      this.jdField_a_of_type_Ayfw.ol(paramLong);
    }
  }
  
  public void onActivityFinish()
  {
    Iterator localIterator = this.lu.iterator();
    while (localIterator.hasNext()) {
      ((aygy)localIterator.next()).onActivityFinish();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10004) {
      this.w = paramIntent;
    }
    Iterator localIterator = this.lu.iterator();
    while (localIterator.hasNext()) {
      ((aygy)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackPressed()
  {
    if ((this.jdField_b_of_type_Aygu != null) && (this.jdField_b_of_type_Aygu.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Ayhp });
      return true;
    }
    if ((this.jdField_a_of_type_Ayij != null) && (this.jdField_a_of_type_Ayij.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Ayhp });
      return true;
    }
    if ((this.jdField_a_of_type_Ayhp != null) && (this.jdField_a_of_type_Ayhp.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Ayhp });
      return true;
    }
    if ((this.jdField_a_of_type_Ayhn != null) && (this.jdField_a_of_type_Ayhn.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Ayhn });
      return true;
    }
    if ((this.jdField_a_of_type_Ayic != null) && (this.jdField_a_of_type_Ayic.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Ayic });
      return true;
    }
    if ((this.jdField_a_of_type_Ayil != null) && (this.jdField_a_of_type_Ayil.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Ayil });
      return true;
    }
    if ((this.jdField_a_of_type_Ayoy != null) && (this.jdField_a_of_type_Ayoy.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Ayoy });
      return true;
    }
    if ((this.jdField_a_of_type_Aygo != null) && (this.jdField_a_of_type_Aygo.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Aygo });
      return true;
    }
    if ((this.jdField_a_of_type_Axrg != null) && (this.jdField_a_of_type_Axrg.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Axrg });
      return true;
    }
    if ((this.jdField_b_of_type_Aygp != null) && (this.jdField_b_of_type_Aygp.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_b_of_type_Aygp });
      return true;
    }
    if ((this.jdField_a_of_type_Ayfw != null) && (this.jdField_a_of_type_Ayfw.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Ayfw });
      return true;
    }
    if ((this.jdField_a_of_type_Aydx != null) && (this.jdField_a_of_type_Aydx.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Aydx });
      return true;
    }
    if ((this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter != null) && (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter });
      return true;
    }
    if ((this.jdField_b_of_type_Aydi != null) && (this.jdField_b_of_type_Aydi.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_b_of_type_Aydi });
      return true;
    }
    if ((this.jdField_b_of_type_Ayfr != null) && (this.jdField_b_of_type_Ayfr.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_b_of_type_Ayfr });
      return true;
    }
    if ((this.jdField_b_of_type_Ayfh != null) && (this.jdField_b_of_type_Ayfh.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_b_of_type_Ayfh });
      return true;
    }
    if ((this.jdField_a_of_type_Ayia != null) && (this.jdField_a_of_type_Ayia.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Ayia });
      return true;
    }
    if ((this.jdField_a_of_type_Ayrm != null) && (this.jdField_a_of_type_Ayrm.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Ayrm });
      return true;
    }
    bsV();
    return true;
  }
  
  public void onCreate()
  {
    checkThread();
    checkState();
    this.aEN = true;
    Object localObject = this.jdField_a_of_type_Ayii.getActivity().getIntent();
    this.bQ = axom.e((Intent)localObject);
    Iterator localIterator = this.lu.iterator();
    while (localIterator.hasNext()) {
      ((aygy)localIterator.next()).onCreate();
    }
    if ((axcg.b((Intent)localObject, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg())) || (axcg.ao((Intent)localObject)))
    {
      ayxa.resetFullScreen(this.jdField_a_of_type_Ayii.getActivity());
      if (this.ok != null) {
        this.ok.setVisibility(8);
      }
      if (this.fn != null) {
        this.fn.setVisibility(8);
      }
    }
    if (La())
    {
      localObject = "2";
      c("exp_edit", 0, 0, new String[] { localObject });
      if (this.jdField_a_of_type_Ayhy != null) {
        rar.a("story_grp", "exp_share_grp", 0, 0, new String[] { "", "", "", "" });
      }
      if (!r(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.aCQ, 64)) {
        break label240;
      }
      jdField_a_of_type_Ayym = new ayym();
    }
    label240:
    do
    {
      return;
      localObject = "1";
      break;
      localObject = this.jdField_a_of_type_Ayii.getActivity().findViewById(2131374669);
    } while (localObject == null);
    ((View)localObject).setVisibility(8);
  }
  
  public void onDestroy()
  {
    if (this.lu != null)
    {
      Iterator localIterator = this.lu.iterator();
      while (localIterator.hasNext()) {
        ((aygy)localIterator.next()).onDestroy();
      }
      ezi();
    }
    if ((jdField_a_of_type_Ayym != null) && (!ankj.axT())) {
      jdField_a_of_type_Ayym.destory();
    }
    ayva.a().eTO();
    this.aEN = false;
  }
  
  public void onPause()
  {
    Iterator localIterator = this.lu.iterator();
    while (localIterator.hasNext()) {
      ((aygy)localIterator.next()).onPause();
    }
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    Iterator localIterator = this.lu.iterator();
    while (localIterator.hasNext()) {
      ((aygy)localIterator.next()).onRestoreInstanceState(paramBundle);
    }
  }
  
  public void onResume()
  {
    if (this.bqq == -1) {
      changeState(0);
    }
    Iterator localIterator = this.lu.iterator();
    while (localIterator.hasNext()) {
      ((aygy)localIterator.next()).onResume();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    Iterator localIterator = this.lu.iterator();
    while (localIterator.hasNext()) {
      ((aygy)localIterator.next()).onSaveInstanceState(paramBundle);
    }
    paramBundle.putInt("mEditState", this.bqq);
  }
  
  public void onStart()
  {
    Iterator localIterator = this.lu.iterator();
    while (localIterator.hasNext()) {
      ((aygy)localIterator.next()).onStart();
    }
  }
  
  public void onStop()
  {
    Iterator localIterator = this.lu.iterator();
    while (localIterator.hasNext()) {
      ((aygy)localIterator.next()).onStop();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    Iterator localIterator = this.lu.iterator();
    while (localIterator.hasNext()) {
      ((aygy)localIterator.next()).onWindowFocusChanged(paramBoolean);
    }
  }
  
  public final void r(int paramInt, Object paramObject)
  {
    checkThread();
    checkState();
    if (this.aHd)
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "change state ignore because of publishing, %s", new Throwable());
      return;
    }
    if ((this.bqq != paramInt) || (paramInt == 5) || (paramInt == 39))
    {
      if (this.aHc) {
        ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "change state while state changing, " + paramInt + " oldState:" + this.bqq, new Throwable());
      }
      this.aHc = true;
      ram.d("Q.qqstory.publish.edit.EditVideoPartManager", "changeState : %s => %s", Integer.valueOf(this.bqq), Integer.valueOf(paramInt));
      int i = this.bqq;
      this.bqq = paramInt;
      Iterator localIterator = this.lu.iterator();
      while (localIterator.hasNext()) {
        ((aygy)localIterator.next()).d(i, this.bqq, paramObject);
      }
    }
    this.aHc = false;
  }
  
  public void setFrom(int paramInt)
  {
    this.mFrom = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "setFrom " + this.mFrom);
    }
  }
  
  void tD(boolean paramBoolean)
  {
    this.aHe = paramBoolean;
    for (;;)
    {
      try
      {
        if (!this.aHe) {
          continue;
        }
        i = 3;
        VideoSourceHelper.nativeSetPlayStepFrameCount(i);
        if (!this.aHe) {
          continue;
        }
        i = 2;
        VideoSourceHelper.nativeSetPlayGapFrameCount(i);
      }
      catch (Throwable localThrowable)
      {
        int i;
        QLog.w("Q.qqstory.publish.edit.EditVideoPartManager", 1, "VideoSourceHelper error:", localThrowable);
        continue;
        VideoSourceHelper.nativeSetPlayAFMute(this.aHe);
      }
      if (this.jdField_a_of_type_Axrg == null) {
        continue;
      }
      return;
      i = 1;
      continue;
      i = 1;
    }
  }
  
  public int tj()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Lb()) && (r(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.aCQ, 262144)))
    {
      if (this.jdField_b_of_type_Aygg == null) {
        throw new IllegalStateException("mEditVideoFragment is null");
      }
      return this.jdField_b_of_type_Aygg.tf();
    }
    return 0;
  }
  
  public int tk()
  {
    switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi)
    {
    default: 
      return 999;
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 5;
  }
  
  public int tl()
  {
    int i = 0;
    if (this.jdField_a_of_type_Ayfw != null) {
      i = this.jdField_a_of_type_Ayfw.ed(tj());
    }
    int j = i;
    if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
    {
      j = i;
      if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.KW()) {
        j = i + 1;
      }
    }
    return j;
  }
  
  public int tm()
  {
    if (this.jdField_b_of_type_Aygg != null)
    {
      List localList = this.jdField_b_of_type_Aygg.cb();
      if (localList != null) {
        return localList.size();
      }
    }
    return 1;
  }
  
  public long x(int paramInt)
  {
    Object localObject;
    long l2;
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Lb()) && (r(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.aCQ, 262144)))
    {
      localObject = (ayhm)a(ayhm.class);
      if (localObject != null)
      {
        l2 = ((ayhm)localObject).w(paramInt);
        ram.b("Q.qqstory.publish.edit.EditVideoPartManager", "getRealVideoTime %d by index %d", Long.valueOf(l2), Integer.valueOf(paramInt));
      }
    }
    for (;;)
    {
      long l1 = l2;
      if (l2 <= 0L)
      {
        localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
        if (!(localObject instanceof EditRecordVideoSource)) {
          break label154;
        }
        l1 = ((EditRecordVideoSource)localObject).recordTime;
      }
      for (;;)
      {
        if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
        switch (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.tc())
        {
        default: 
          return l1;
          if (((localObject instanceof EditTakePhotoSource)) || ((localObject instanceof EditLocalPhotoSource)))
          {
            l1 = 5000L;
          }
          else if ((localObject instanceof EditLocalVideoSource))
          {
            localObject = (EditLocalVideoSource)localObject;
            l1 = ((EditLocalVideoSource)localObject).endTime - ((EditLocalVideoSource)localObject).startTime;
            if (l1 == 0L) {
              l1 = ((EditLocalVideoSource)localObject).d.mDuration;
            }
          }
          else if ((localObject instanceof EditTakeVideoSource))
          {
            l1 = ((EditTakeVideoSource)localObject).d.mDuration;
          }
          else
          {
            throw new RuntimeException(acfp.m(2131705667));
          }
          break;
        case 1: 
          return l1 / 2L;
        case 2: 
          return l1 * 2L;
        case 4: 
          return l1 * 4L;
        case 3: 
          label154:
          return ((float)l1 / 1.5F);
        }
      }
      l2 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aygz
 * JD-Core Version:    0.7.0.1
 */