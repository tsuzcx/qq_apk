import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.animation.Animation;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoReaderConf;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.biz.qqstory.takevideo.EditGifImage;
import com.tencent.biz.qqstory.takevideo.EditLocalGifSource;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.biz.qqstory.takevideo.EditPicActivity;
import com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import com.tencent.biz.qqstory.takevideo.EditVideoGuide;
import com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager.8;
import com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class rdc
  implements IEventReceiver
{
  public EditGifImage a;
  public EditPicRawImage a;
  protected EditVideoGuide a;
  protected EditVideoMusic a;
  public EditVideoParams a;
  protected rbe a;
  public rbh a;
  public rbo a;
  protected rbr a;
  public rcb a;
  protected rcc a;
  protected rdk a;
  protected rdm a;
  protected rdp a;
  protected rdv a;
  protected rdz a;
  protected red a;
  protected ref a;
  protected reg a;
  protected reh a;
  public rel a;
  protected boolean aEN;
  protected boolean aHc;
  protected boolean aHd;
  public boolean aHe;
  private AtomicInteger aq = new AtomicInteger(1000);
  protected final AtomicInteger ar = new AtomicInteger(1);
  public EditVideoArtFilter b;
  public EditVideoFilter b;
  protected rbc b;
  protected rco b;
  protected rcu b;
  public int bqq = -1;
  private int bqr;
  protected Map<Class<? extends rdb.a>, rdb.a> gf = new HashMap();
  protected List<rdb> lu = Collections.emptyList();
  protected List<Error> oC = new ArrayList();
  protected Intent w;
  
  private rdb a(@NonNull EditVideoParams paramEditVideoParams)
  {
    if (paramEditVideoParams.La())
    {
      paramEditVideoParams = new EditPicRawImage(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage = paramEditVideoParams;
      return paramEditVideoParams;
    }
    if (paramEditVideoParams.Le())
    {
      paramEditVideoParams = new EditGifImage(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage = paramEditVideoParams;
      return paramEditVideoParams;
    }
    if ((paramEditVideoParams.a instanceof EditTakeVideoSource)) {
      return new HWEditLocalVideoPlayer(this);
    }
    if ((paramEditVideoParams.a instanceof EditLocalVideoSource))
    {
      if (paramEditVideoParams.Lg()) {
        return new HWEditLocalVideoPlayer(this);
      }
      paramEditVideoParams = new rbh(this);
      this.jdField_a_of_type_Rbh = paramEditVideoParams;
      return paramEditVideoParams;
    }
    if (paramEditVideoParams.Lg()) {
      return new HWEditLocalVideoPlayer(this);
    }
    paramEditVideoParams = new rdm(this);
    this.jdField_a_of_type_Rdm = paramEditVideoParams;
    return paramEditVideoParams;
  }
  
  private void a(EditVideoParams.EditSource paramEditSource)
  {
    rkm localrkm = new rkm(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
    localrkm.aAU = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getStringExtra("extra_upload_temp_directory");
    if (localrkm.aAU == null) {
      localrkm.aAU = rlc.ce(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi);
    }
    if ((paramEditSource instanceof EditLocalGifSource)) {
      if ((!TextUtils.isEmpty(paramEditSource.getSourcePath())) || (((EditLocalGifSource)paramEditSource).ns.size() <= 0)) {
        break label139;
      }
    }
    label139:
    for (localrkm.jdField_a_of_type_Rkq = new rkq((String)((EditLocalGifSource)paramEditSource).ns.get(0));; localrkm.jdField_a_of_type_Rkq = new rkq(paramEditSource.getSourcePath()))
    {
      paramEditSource = this.lu.iterator();
      while (paramEditSource.hasNext()) {
        ((rdb)paramEditSource.next()).a(0, localrkm);
      }
    }
    d(localrkm);
    e(localrkm);
    ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { localrkm.aAU });
    this.jdField_a_of_type_Rel.a(acfp.m(2131705582), false, 500L);
    Stream.of(localrkm).map(new rko((rba)a(rba.class), null, true)).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2)).map(new rla(rbn.azs + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new UIThreadOffFunction(this)).subscribe(a(localrkm));
  }
  
  private boolean a(rkm paramrkm)
  {
    if (paramrkm.g.doodlePath != null) {}
    do
    {
      do
      {
        return true;
      } while (paramrkm.g.doodleRawPath != null);
      if (paramrkm.g.atJsonData != null)
      {
        ram.i("Q.qqstory.publish.edit.EditVideoPartManager", "HAS AT LABELS.");
        return true;
      }
    } while ((paramrkm.g.backgroundMusicPath != null) || (paramrkm.g.isMuteRecordVoice) || (paramrkm.aIB) || (paramrkm.g.saveMode != 0));
    return false;
  }
  
  public static boolean al(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  private void b(EditVideoParams.EditSource paramEditSource)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
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
      aniq.bQi = (int)((EditRecordVideoSource)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).recordTime;
      aniq.dHk = ((EditRecordVideoSource)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a).bpF;
      aniq.dFO = 0;
      aniq.dHo = 0;
      if (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.tc();; i = 0)
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
        str4 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getStringExtra("extra_upload_temp_directory");
        if ((!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.Lb()) || (!al(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.bqp, 32768))) {
          break label1041;
        }
        localObject1 = null;
        if (this.jdField_b_of_type_Rco != null) {
          localObject1 = this.jdField_b_of_type_Rco.cb();
        }
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break;
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localArrayList.add(Integer.valueOf(((rfa)((Iterator)localObject1).next()).bqJ));
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
      if (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.tc();; i = 0)
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
      if (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.tc();; i = 0)
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
    throw new IllegalArgumentException(acfp.m(2131705511) + paramEditSource);
    ram.e("Q.qqstory.publish.edit.EditVideoPartManager", "can not find any video fragment ! break the process of publish");
    return;
    int m = 1;
    this.ar.set(localArrayList.size());
    this.oC.clear();
    int n = 0;
    label759:
    int i1;
    rkm localrkm;
    label914:
    label957:
    Object localObject2;
    if (n < localArrayList.size())
    {
      i1 = ((Integer)localArrayList.get(n)).intValue();
      xa(i1);
      localrkm = new rkm(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localrkm.g.multiFragmentGroupId = str3;
      localrkm.g.createTime = (n * 1000 + l);
      localrkm.g.videoMaxrate = aniq.dFI;
      localrkm.g.videoMinrate = aniq.dFJ;
      localrkm.g.videoUploadGroupTempDir = str4;
      localrkm.aAU = rlc.ce(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi);
      localObject1 = this.jdField_a_of_type_Rel.getActivity();
      boolean bool2;
      if ((this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) && (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.tc() == 5))
      {
        bool2 = true;
        localrkm.jdField_a_of_type_Rks = new rks((Activity)localObject1, i, j, str1, f, bool2, k, 0.0D, 0.0D, str2, bool1);
        if (!(paramEditSource instanceof EditLocalVideoSource)) {
          break label1065;
        }
        localrkm.bsQ = 0;
        localrkm.g.putExtra("thumb_rotation", Integer.valueOf(localrkm.bsQ));
        if (!(paramEditSource instanceof EditTakeVideoSource)) {
          break label1075;
        }
        localrkm.g.putExtra("is_hw_encode", Boolean.valueOf(true));
      }
      for (;;)
      {
        localObject1 = this.lu.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((rdb)((Iterator)localObject1).next()).a(i1, localrkm);
        }
        label1041:
        localArrayList.add(Integer.valueOf(0));
        m = 0;
        break;
        bool2 = false;
        break label914;
        label1065:
        localrkm.bsQ = k;
        break label957;
        label1075:
        localrkm.g.putExtra("is_hw_encode", Boolean.valueOf(false));
      }
      d(localrkm);
      e(localrkm);
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { localrkm.aAU });
      this.jdField_a_of_type_Rel.a(acfp.m(2131705509), false, 500L);
      localObject1 = Stream.of(localrkm).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2));
      if ((!(paramEditSource instanceof EditTakeVideoSource)) && (!(paramEditSource instanceof EditLocalVideoSource))) {
        break label1305;
      }
      localObject1 = ((Stream)localObject1).map(new rkx(null, (rdo)a(rdo.class), i1));
      label1205:
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Rcc != null) {
        localObject2 = ((Stream)localObject1).map(this.jdField_a_of_type_Rcc.a(i1));
      }
      if ((!(paramEditSource instanceof EditTakeVideoSource)) && (!(paramEditSource instanceof EditLocalVideoSource))) {
        break label1357;
      }
    }
    label1305:
    label1357:
    for (Object localObject1 = ((Stream)localObject2).map(new rky());; localObject1 = ((Stream)localObject2).map(new rlb()).map(new rkl()))
    {
      ((Stream)localObject1).map(new rle(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(a(localrkm));
      n += 1;
      break label759;
      break;
      if (m != 0)
      {
        localObject1 = ((Stream)localObject1).map(new rkt(null, (rdo)a(rdo.class), i1));
        break label1205;
      }
      localObject1 = ((Stream)localObject1).map(new rkt());
      break label1205;
    }
  }
  
  private void bsW()
  {
    xa(0);
  }
  
  private void c(EditVideoParams.EditSource paramEditSource)
  {
    rkm localrkm = new rkm(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
    localrkm.g.videoMaxrate = aniq.dFI;
    localrkm.g.videoMinrate = aniq.dFJ;
    localrkm.aAU = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getStringExtra("extra_upload_temp_directory");
    if (localrkm.aAU == null) {
      localrkm.aAU = rlc.ce(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi);
    }
    localrkm.jdField_a_of_type_Rkq = new rkq(paramEditSource.getSourcePath());
    paramEditSource = this.lu.iterator();
    while (paramEditSource.hasNext()) {
      ((rdb)paramEditSource.next()).a(0, localrkm);
    }
    d(localrkm);
    e(localrkm);
    ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { localrkm.aAU });
    this.jdField_a_of_type_Rel.a(acfp.m(2131705566), false, 500L);
    this.ar.set(1);
    this.oC.clear();
    paramEditSource = Stream.of(localrkm).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2)).map(new rla(false)).map(new rlf());
    Object localObject = this.jdField_a_of_type_Rel.getActivity();
    if (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
    for (int i = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.tc();; i = 0)
    {
      localObject = paramEditSource.map(new rkr((Activity)localObject, i));
      paramEditSource = (EditVideoParams.EditSource)localObject;
      if (this.jdField_a_of_type_Rcc != null) {
        paramEditSource = ((Stream)localObject).map(this.jdField_a_of_type_Rcc.a(0));
      }
      paramEditSource.map(new rlb()).map(new rkl()).map(new rle(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(a(localrkm));
      return;
    }
  }
  
  private void checkState()
  {
    if ((this.jdField_a_of_type_Rel == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null)) {
      throw new IllegalStateException("have not attach ui and params");
    }
  }
  
  private void xa(int paramInt)
  {
    label52:
    String str2;
    if (La())
    {
      c("pub_photo", 0, 0, new String[] { "", "5000" });
      str1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getStringExtra("mCurrentTemplatePath");
      if (TextUtils.isEmpty(str1)) {
        break label158;
      }
      paramInt = 1;
      if (paramInt != 0)
      {
        paramInt = tk();
        str2 = gd(str1);
        if (!La()) {
          break label163;
        }
      }
    }
    label158:
    label163:
    for (String str1 = "2";; str1 = "1")
    {
      d("pub_changeface", paramInt, 0, new String[] { "1", str2, str1 });
      return;
      c("pub_video", 0, 0, new String[] { "", String.valueOf(x(paramInt)) });
      Bosses.get().postJob(new rdi(this, "Q.qqstory.publish.edit.EditVideoPartManager"));
      break;
      paramInt = 0;
      break label52;
    }
  }
  
  public boolean La()
  {
    checkThread();
    checkState();
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.La();
  }
  
  public Bitmap W()
  {
    Bitmap localBitmap = null;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage != null) {
      localBitmap = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage.V();
    }
    return localBitmap;
  }
  
  public int a(@NonNull Message paramMessage)
  {
    checkThread();
    checkState();
    if (this.aHd)
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "broadcast message ignore because of publishing, %s", new Throwable());
      return 0;
    }
    Iterator localIterator = this.lu.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((rdb)localIterator.next()).f(Message.obtain(paramMessage))) {
        break label105;
      }
      i += 1;
    }
    label105:
    for (;;)
    {
      break;
      if (i == 0) {
        ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "broadcastEditVideoMessage, but no one handled. %s", new Object[] { paramMessage });
      }
      paramMessage.recycle();
      return i;
    }
  }
  
  protected SimpleObserver<rkm> a(rkm paramrkm)
  {
    return new rdj(this, paramrkm, SystemClock.uptimeMillis());
  }
  
  @Nullable
  public rdb.a a(Class<? extends rdb.a> paramClass)
  {
    if (paramClass == null) {
      throw new IllegalArgumentException("editExportClass should not be null");
    }
    return (rdb.a)this.gf.get(paramClass);
  }
  
  void a(Intent paramIntent, int paramInt, PublishParam paramPublishParam)
  {
    switch (paramInt)
    {
    case 102: 
    case 103: 
    case 105: 
    default: 
      this.jdField_a_of_type_Rel.a(-1, paramIntent, 2130772067, 0);
      return;
    }
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
    if (paramInt == 104)
    {
      paramIntent.putExtra("forward_source_from_pre_guide", true);
      this.jdField_a_of_type_Rel.getActivity().startActivityForResult(paramIntent, 10010);
      return;
    }
    paramIntent.putExtra("forward_source_from_shoot_quick", true);
    this.jdField_a_of_type_Rel.getActivity().startActivityForResult(paramIntent, 10004);
    rar.a("plus_shoot", "exp_send", 0, 0, new String[] { "", "", "", "" });
  }
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    ram.b("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %s", paramEditVideoParams);
    int i = paramEditVideoParams.bqp;
    ArrayList localArrayList = new ArrayList();
    Object localObject = new rcb(this, i);
    this.jdField_a_of_type_Rcb = ((rcb)localObject);
    localArrayList.add(localObject);
    localArrayList.add(a(paramEditVideoParams));
    if (al(i, 256))
    {
      localObject = new EditVideoGuide(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoGuide = ((EditVideoGuide)localObject);
      localArrayList.add(localObject);
    }
    if (al(i, 32))
    {
      localObject = new EditVideoMusic(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic = ((EditVideoMusic)localObject);
      localArrayList.add(localObject);
    }
    if ((al(i, 1)) || (al(i, 4)) || (al(i, 8)))
    {
      localObject = new rcc(this, i);
      this.jdField_a_of_type_Rcc = ((rcc)localObject);
      localArrayList.add(localObject);
      localObject = new rdp(this);
      this.jdField_a_of_type_Rdp = ((rdp)localObject);
      localArrayList.add(localObject);
      localObject = new rdv(this);
      this.jdField_a_of_type_Rdv = ((rdv)localObject);
      localArrayList.add(localObject);
    }
    if (al(i, 64))
    {
      if (paramEditVideoParams.asi == 1)
      {
        localObject = new rcl(this);
        this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter = ((EditVideoFilter)localObject);
        localArrayList.add(localObject);
      }
    }
    else
    {
      if (al(i, 128))
      {
        localObject = new rcu(this);
        this.jdField_b_of_type_Rcu = ((rcu)localObject);
        localArrayList.add(localObject);
      }
      if (((paramEditVideoParams.La()) || (paramEditVideoParams.Le())) && (al(i, 16)))
      {
        localObject = new EditVideoArtFilter(this);
        this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter = ((EditVideoArtFilter)localObject);
        localArrayList.add(localObject);
      }
      if ((paramEditVideoParams.La()) && (al(i, 2)))
      {
        localObject = new rbo(this);
        this.jdField_a_of_type_Rbo = ((rbo)localObject);
        localArrayList.add(localObject);
      }
      if (al(i, 1024))
      {
        if (!paramEditVideoParams.La()) {
          break label795;
        }
        localObject = new rbr(this);
        this.jdField_a_of_type_Rbr = ((rbr)localObject);
        localArrayList.add(localObject);
      }
    }
    for (;;)
    {
      if (al(i, 4096))
      {
        localObject = new rbc(this);
        this.jdField_b_of_type_Rbc = ((rbc)localObject);
        localArrayList.add(localObject);
      }
      if (al(i, 16384))
      {
        localObject = new rdk(this);
        this.jdField_a_of_type_Rdk = ((rdk)localObject);
        localArrayList.add(localObject);
      }
      if (al(i, 131072))
      {
        localObject = new ref(this);
        this.jdField_a_of_type_Ref = ((ref)localObject);
        localArrayList.add(localObject);
      }
      if ((paramEditVideoParams.Lb()) && (al(i, 32768)))
      {
        localObject = new rco(this);
        this.jdField_b_of_type_Rco = ((rco)localObject);
        localArrayList.add(localObject);
      }
      if (al(i, 2097152))
      {
        localObject = new red(this);
        this.jdField_a_of_type_Red = ((red)localObject);
        localArrayList.add(localObject);
      }
      if (al(i, 4194304))
      {
        localObject = new reh(this);
        this.jdField_a_of_type_Reh = ((reh)localObject);
        localArrayList.add(localObject);
      }
      paramEditVideoParams = paramEditVideoParams.o("extra_subtile_data");
      if (paramEditVideoParams != null)
      {
        paramEditVideoParams = new reg(this, paramEditVideoParams);
        this.jdField_a_of_type_Reg = paramEditVideoParams;
        localArrayList.add(paramEditVideoParams);
      }
      eS(localArrayList);
      this.lu = Collections.unmodifiableList(localArrayList);
      ram.b("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %d", Integer.valueOf(this.lu.size()));
      paramEditVideoParams = this.lu.iterator();
      while (paramEditVideoParams.hasNext()) {
        ram.b("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts : %s", ((rdb)paramEditVideoParams.next()).getClass().getSimpleName());
      }
      localObject = new EditVideoFilter(this);
      this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter = ((EditVideoFilter)localObject);
      localArrayList.add(localObject);
      break;
      label795:
      localObject = new rdz(this);
      this.jdField_a_of_type_Rdz = ((rdz)localObject);
      localArrayList.add(localObject);
    }
  }
  
  public void a(Class<? extends rdb.a> paramClass, rdb.a parama)
  {
    checkThread();
    checkState();
    if (paramClass == null) {
      throw new IllegalArgumentException("editExportClass should not be null");
    }
    if (!paramClass.isInstance(parama)) {
      throw new IllegalArgumentException("the 2nd parameter's type " + parama.getClass().getName() + " is not instance of " + paramClass.getName());
    }
    rdb.a locala = (rdb.a)this.gf.get(paramClass);
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
  
  public void a(rel paramrel, EditVideoParams paramEditVideoParams)
  {
    checkThread();
    if ((paramrel == null) || (paramEditVideoParams == null)) {
      throw new IllegalArgumentException("both ui ant params should not be null");
    }
    if ((this.jdField_a_of_type_Rel != paramrel) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != paramEditVideoParams))
    {
      this.jdField_a_of_type_Rel = paramrel;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
      a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      paramEditVideoParams = this.lu.iterator();
    }
    while (paramEditVideoParams.hasNext())
    {
      ((rdb)paramEditVideoParams.next()).a(paramrel);
      continue;
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "duplicate attachUiAndParams ui=%s, params=%s", new Object[] { paramrel, paramEditVideoParams });
    }
  }
  
  public void bsF()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoGuide != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoGuide.aYE == 2)) {
      changeState(10);
    }
  }
  
  public void bsV()
  {
    checkThread();
    checkState();
    Object localObject;
    if (La())
    {
      localObject = "2";
      c("clk_left", 0, 0, new String[] { localObject });
      ras.so("0X80076B6");
      ras.sp("0X80075C2");
      ras.aP(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.tg(), "0X8007823");
      if (this.jdField_a_of_type_Rcc == null) {
        break label491;
      }
    }
    label457:
    label491:
    for (int j = this.jdField_a_of_type_Rcc.tb();; j = 0)
    {
      int i = j;
      if (this.jdField_b_of_type_Rcu != null)
      {
        i = j;
        if (!TextUtils.isEmpty(this.jdField_b_of_type_Rcu.mS())) {
          i = j + 1;
        }
      }
      j = i;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic != null)
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
        j = i;
        if (localObject != null)
        {
          j = i;
          if (!TextUtils.isEmpty(((rkc)localObject).aAR)) {
            j = i + 1;
          }
        }
      }
      i = j;
      if (this.jdField_a_of_type_Rbo != null) {
        i = j + this.jdField_a_of_type_Rbo.bpC;
      }
      j = i;
      if (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
      {
        j = i;
        if (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.KW()) {
          j = i + 4;
        }
      }
      ram.b("Q.qqstory.publish.edit.EditVideoPartManager", "tryQuitRecordUI, current is preview state, edit count = %d", Integer.valueOf(j));
      if (j < 4)
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 3) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.La()) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mExtra != null) && (!acfp.m(2131705571).equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mExtra.get("extra_publish_text"))))
        {
          localObject = acfp.m(2131705620);
          aqha.a(this.jdField_a_of_type_Rel.getContext(), 230, (String)localObject, null, acfp.m(2131705595), acfp.m(2131705535), new rdd(this), new rde(this)).show();
          return;
          localObject = "1";
          break;
        }
        bsr();
        return;
      }
      if (La())
      {
        localObject = "2";
        c("clk_left_float", 0, 0, new String[] { localObject });
        ras.so("0X80076B7");
        ras.sp("0X80075C3");
        if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.La()) {
          break label457;
        }
        localObject = acfp.m(2131705499);
      }
      for (;;)
      {
        ausj localausj = ausj.a(this.jdField_a_of_type_Rel.getContext(), false);
        localausj.setMainTitle((CharSequence)localObject);
        localausj.addButton(acfp.m(2131705570), 3);
        localausj.addCancelButton(acfp.m(2131705534));
        localausj.a(new rdf(this, localausj));
        localausj.show();
        return;
        localObject = "1";
        break;
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.Le()) || (this.aHe)) {
          localObject = "放弃本次GIF编辑？";
        } else {
          localObject = acfp.m(2131705689);
        }
      }
    }
  }
  
  public void bsX()
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_Rcc != null)
    {
      rfz localrfz = this.jdField_a_of_type_Rcc.a().a();
      i = j;
      if (localrfz != null)
      {
        i = j;
        if (localrfz.a.Lt())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "preparePublish");
          }
          this.jdField_a_of_type_Rel.a(acfp.m(2131705483), false, 500L);
          this.jdField_a_of_type_Rcc.bpW = 2;
          this.jdField_a_of_type_Rcc.a().buk();
          i = 1;
        }
      }
    }
    if (i == 0) {
      bsY();
    }
  }
  
  public void bsY()
  {
    cF(this.jdField_a_of_type_Rel.getContext());
    bsn();
    Activity localActivity = this.jdField_a_of_type_Rel.getActivity();
    if ((localActivity instanceof EditPicActivity)) {}
    switch (localActivity.getIntent().getIntExtra("editpic_cameratype", -1))
    {
    default: 
      return;
    case 1: 
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("sv_latest_taken_photo_time", -1L).commit();
      aarz.cxA();
      return;
    case 2: 
      aarz.cxB();
      return;
    }
    aarz.cxC();
  }
  
  public void bsZ()
  {
    int i = 0;
    checkThread();
    checkState();
    if (!this.aHd)
    {
      this.aHd = true;
      bsW();
      EditVideoParams.EditSource localEditSource = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "onConfirmClick : %s", new Object[] { localEditSource });
      aniq.bQi = 5000;
      aniq.dHk = 125;
      aniq.dFO = 0;
      aniq.dHo = 0;
      if (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {
        i = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.tc();
      }
      aniq.bsT = i;
      c(localEditSource);
      return;
    }
    ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "duplicate publish", new Throwable());
  }
  
  public void bsn()
  {
    int i = 0;
    checkThread();
    checkState();
    Object localObject;
    if (!this.aHd)
    {
      this.aHd = true;
      localObject = (rdo)a(rdo.class);
      if (localObject != null) {
        ((rdo)localObject).pause();
      }
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "onConfirmClick : %s", new Object[] { localObject });
      if ((!(localObject instanceof EditRecordVideoSource)) && (!(localObject instanceof EditLocalVideoSource)) && (!(localObject instanceof EditTakeVideoSource))) {
        break label131;
      }
      b((EditVideoParams.EditSource)localObject);
      if ((localObject instanceof EditLocalVideoSource)) {
        rar.a("video_edit", "pub_local", 0, 0, new String[] { "1" });
      }
    }
    label131:
    do
    {
      return;
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "requestPublish duplicate");
      return;
      if (((localObject instanceof EditLocalPhotoSource)) || ((localObject instanceof EditTakePhotoSource)))
      {
        bsW();
        aniq.bQi = 5000;
        aniq.dHk = 125;
        aniq.dFO = 0;
        aniq.dHo = 0;
        if (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
        for (i = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.tc();; i = 0)
        {
          aniq.bsT = i;
          c((EditVideoParams.EditSource)localObject);
          rar.a("video_edit", "pub_local", 0, 0, new String[0]);
          return;
        }
      }
    } while (!(localObject instanceof EditLocalGifSource));
    aniq.bQi = 5000;
    aniq.dHk = 125;
    aniq.dFO = 0;
    aniq.dHo = 0;
    if (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {
      i = this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.tc();
    }
    aniq.bsT = i;
    a((EditVideoParams.EditSource)localObject);
  }
  
  protected void bsr()
  {
    this.jdField_a_of_type_Rel.a(0, null, 2130772067, 0);
  }
  
  void bta()
  {
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_Rcc.a();
    if (localDoodleLayout != null) {
      localDoodleLayout.a.bue();
    }
  }
  
  void btb()
  {
    int j = 0;
    Object localObject = this.jdField_a_of_type_Rbo;
    ((rbo)localObject).bpC += tl();
    if (this.bqq == 11) {
      changeState(0);
    }
    int i;
    do
    {
      return;
      localObject = this.jdField_a_of_type_Rcc.a();
      rfz localrfz = ((DoodleLayout)localObject).a();
      i = j;
      if (localrfz != null)
      {
        i = j;
        if (localrfz.a.Lt())
        {
          this.jdField_a_of_type_Rel.a(acfp.m(2131705707), false, 500L);
          this.jdField_a_of_type_Rcc.bpW = 3;
          ((DoodleLayout)localObject).buk();
          i = 1;
        }
      }
    } while (i != 0);
    btc();
  }
  
  public void btc()
  {
    this.jdField_a_of_type_Rel.bpm();
    Object localObject1 = this.jdField_a_of_type_Rcc.a();
    Object localObject2 = ((DoodleLayout)localObject1).g(0);
    Object localObject3 = ((DoodleLayout)localObject1).h(0);
    this.jdField_a_of_type_Rbo.dV[0] = localObject2[0];
    this.jdField_a_of_type_Rbo.dV[1] = localObject2[1];
    this.jdField_a_of_type_Rbo.dV[2] = localObject3[0];
    this.jdField_a_of_type_Rbo.dV[3] = localObject3[1];
    this.jdField_a_of_type_Rbo.dV[4] = ((DoodleLayout)localObject1).a().tp();
    localObject3 = ((DoodleLayout)localObject1).U();
    localObject2 = W();
    if (localObject2 == null) {
      return;
    }
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      long l = SystemClock.uptimeMillis();
      localObject1 = rop.d((Bitmap)localObject2, (Bitmap)localObject3);
      ram.d("Q.qqstory.publish.edit.EditVideoPartManager", "onCropBtnPressed merge ： cost " + (SystemClock.uptimeMillis() - l));
    }
    this.jdField_a_of_type_Rbo.cx = ((Bitmap)localObject1);
    changeState(11);
  }
  
  void btd()
  {
    if (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter == null) {
      return;
    }
    changeState(0);
    changeState(12);
  }
  
  public void bte()
  {
    if (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
    {
      this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.bsz();
      btf();
    }
    changeState(0);
  }
  
  public void btf()
  {
    if (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null) {
      ThreadManager.post(new EditVideoPartManager.8(this), 5, null, true);
    }
  }
  
  public void c(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 1) {
      Bosses.get().postJob(new rdg(this, "Q.qqstory.publish.edit.EditVideoPartManager", paramString, paramInt1, paramInt2, paramVarArgs));
    }
  }
  
  public void cF(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.th() == 14) {
      rar.a("story_grp", "clk_send", 0, 0, new String[0]);
    }
    long l = dT();
    paramContext = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
    int i;
    if ((paramContext instanceof EditRecordVideoSource)) {
      if (((EditRecordVideoSource)paramContext).bpG == 1) {
        i = 1;
      }
    }
    for (;;)
    {
      int j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getIntExtra("report_entrance_type", 0);
      int k = tk();
      if (La())
      {
        paramContext = "2";
        label90:
        d("clk_publish", k, 0, new String[] { paramContext, String.valueOf(l), String.valueOf(i), j + "" });
        if (al(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.bqp, 32768))
        {
          i = tm();
          if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.Ld()) {
            break label401;
          }
          paramContext = "0";
          label181:
          d("pub_edit_more", 0, 0, new String[] { String.valueOf(i), paramContext });
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.th() != 16) {
          break label408;
        }
      }
      label401:
      label408:
      for (i = 1;; i = 0)
      {
        paramContext = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getStringExtra("story_default_label");
        l = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getLongExtra("story_topic_id", 0L);
        if ((i != 0) && (!TextUtils.isEmpty(paramContext)) && (l > 0L)) {
          rar.a("content_flow", "clk_hot_pub", 0, 0, new String[] { String.valueOf(l), paramContext });
        }
        if (this.jdField_a_of_type_Reg != null) {
          anot.a(null, "dc00898", "", "", "0X8008759", "0X8008759", 0, 0, "", "", "", "");
        }
        return;
        i = 2;
        break;
        if ((paramContext instanceof EditTakeVideoSource))
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getIntExtra("currentCamera", 2) == 1)
          {
            i = 1;
            break;
          }
          i = 2;
          break;
        }
        if (!(paramContext instanceof EditTakePhotoSource)) {
          break label413;
        }
        if (((EditTakePhotoSource)paramContext).bpG == 1)
        {
          i = 1;
          break;
        }
        i = 2;
        break;
        paramContext = "1";
        break label90;
        paramContext = "1";
        break label181;
      }
      label413:
      i = 3;
    }
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
  
  public void d(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    Bosses.get().postJob(new rdh(this, "Q.qqstory.publish.edit.EditVideoPartManager", paramString, paramInt1, paramInt2, paramVarArgs));
  }
  
  public void d(rkm paramrkm)
  {
    Object localObject = paramrkm.g.readerConfBytes;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = new qqstory_struct.VideoReaderConf();
      ((qqstory_struct.VideoReaderConf)localObject).ban_type.set(0);
      ((qqstory_struct.VideoReaderConf)localObject).setHasFlag(true);
      paramrkm.g.readerConfBytes = ((qqstory_struct.VideoReaderConf)localObject).toByteArray();
    }
  }
  
  public long dT()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
    long l;
    if ((localObject instanceof EditRecordVideoSource)) {
      l = ((EditRecordVideoSource)localObject).recordTime;
    }
    for (;;)
    {
      if (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      switch (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.tc())
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
          throw new RuntimeException(acfp.m(2131705585));
        }
        break;
      case 1: 
        return l / 2L;
      case 2: 
        return l * 2L;
      }
    }
  }
  
  public void e(Bitmap paramBitmap, boolean paramBoolean)
  {
    checkThread();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage.setBitmap(paramBitmap, paramBoolean);
    }
  }
  
  public void e(Animation paramAnimation) {}
  
  public void e(rkm paramrkm)
  {
    long l = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mExtra.getLong("troop_uin");
    if (l != 0L)
    {
      Object localObject = new qqstory_struct.VideoReaderConf();
      ((qqstory_struct.VideoReaderConf)localObject).ban_type.set(1);
      ((qqstory_struct.VideoReaderConf)localObject).user_list.set(new ArrayList());
      ((qqstory_struct.VideoReaderConf)localObject).setHasFlag(true);
      paramrkm.g.readerConfBytes = ((qqstory_struct.VideoReaderConf)localObject).toByteArray();
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Long.valueOf(l));
      if (((ArrayList)localObject).size() > 0) {
        try
        {
          qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
          byte[] arrayOfByte = paramrkm.g.spreadGroupBytes;
          if (arrayOfByte != null) {}
          try
          {
            localVideoSpreadGroupList.mergeFrom(paramrkm.g.spreadGroupBytes);
            localVideoSpreadGroupList.group_list.set((List)localObject);
            localVideoSpreadGroupList.visibility_type.set(4);
            localVideoSpreadGroupList.setHasFlag(true);
            paramrkm.g.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
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
  
  public boolean eO(int paramInt)
  {
    return this.bqq == paramInt;
  }
  
  public boolean eP(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoGuide != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoGuide.bqm == paramInt) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected void eS(List<rdb> paramList) {}
  
  public void f(Animation paramAnimation) {}
  
  public void f(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
  
  public String gd(String paramString)
  {
    if ((paramString != null) && (paramString.length() >= PtvTemplateManager.bYM.length())) {
      return ":" + paramString.substring(PtvTemplateManager.bYM.length());
    }
    return "";
  }
  
  public boolean isValidate()
  {
    return this.aEN;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      Iterator localIterator = this.lu.iterator();
      while (localIterator.hasNext()) {
        ((rdb)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      this.w = paramIntent;
    }
  }
  
  public boolean onBackPressed()
  {
    if ((this.jdField_a_of_type_Rdv != null) && (this.jdField_a_of_type_Rdv.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Rdv });
      return true;
    }
    if ((this.jdField_a_of_type_Rdp != null) && (this.jdField_a_of_type_Rdp.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Rdp });
      return true;
    }
    if ((this.jdField_a_of_type_Reh != null) && (this.jdField_a_of_type_Reh.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Reh });
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic });
      return true;
    }
    if ((this.jdField_b_of_type_Rcu != null) && (this.jdField_b_of_type_Rcu.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_b_of_type_Rcu });
      return true;
    }
    if ((this.jdField_a_of_type_Rcc != null) && (this.jdField_a_of_type_Rcc.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Rcc });
      return true;
    }
    if ((this.jdField_a_of_type_Rbo != null) && (this.jdField_a_of_type_Rbo.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Rbo });
      return true;
    }
    if ((this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null) && (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter });
      return true;
    }
    if ((this.jdField_b_of_type_Rbc != null) && (this.jdField_b_of_type_Rbc.onBackPressed()))
    {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_b_of_type_Rbc });
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
    Object localObject = this.lu.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((rdb)((Iterator)localObject).next()).onCreate();
    }
    if (La()) {}
    for (localObject = "2";; localObject = "1")
    {
      c("exp_edit", 0, 0, new String[] { localObject });
      if (this.jdField_a_of_type_Ref != null) {
        rar.a("story_grp", "exp_share_grp", 0, 0, new String[] { "", "", "", "" });
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    if (this.lu != null)
    {
      Iterator localIterator = this.lu.iterator();
      while (localIterator.hasNext()) {
        ((rdb)localIterator.next()).onDestroy();
      }
    }
    this.aEN = false;
  }
  
  public void onPause()
  {
    Iterator localIterator = this.lu.iterator();
    while (localIterator.hasNext()) {
      ((rdb)localIterator.next()).onPause();
    }
    if ((!La()) || (al(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.bqp, 32)))
    {
      ram.b("Q.qqstory.publish.edit.EditVideoPartManager", "releaseAudioResource, edit photo = %s", Boolean.valueOf(La()));
      anhm.ahI();
    }
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    Iterator localIterator = this.lu.iterator();
    while (localIterator.hasNext()) {
      ((rdb)localIterator.next()).onRestoreInstanceState(paramBundle);
    }
  }
  
  public void onResume()
  {
    if (this.bqq == -1) {
      changeState(0);
    }
    Iterator localIterator = this.lu.iterator();
    while (localIterator.hasNext()) {
      ((rdb)localIterator.next()).onResume();
    }
    if ((!La()) || (al(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.bqp, 32)))
    {
      ram.b("Q.qqstory.publish.edit.EditVideoPartManager", "getAudioResource, edit photo = %s", Boolean.valueOf(La()));
      anhm.ahH();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    Iterator localIterator = this.lu.iterator();
    while (localIterator.hasNext()) {
      ((rdb)localIterator.next()).onSaveInstanceState(paramBundle);
    }
    paramBundle.putInt("mEditState", this.bqq);
  }
  
  public void onStart()
  {
    Iterator localIterator = this.lu.iterator();
    while (localIterator.hasNext()) {
      ((rdb)localIterator.next()).onStart();
    }
  }
  
  public void onStop()
  {
    Iterator localIterator = this.lu.iterator();
    while (localIterator.hasNext()) {
      ((rdb)localIterator.next()).onStop();
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
    if (this.bqq != paramInt)
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
        ((rdb)localIterator.next()).d(i, this.bqq, paramObject);
      }
    }
    this.aHc = false;
  }
  
  protected void tD(boolean paramBoolean)
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
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic == null) {
        continue;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.setMuteState(paramBoolean);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.tB(paramBoolean);
      return;
      i = 1;
      continue;
      i = 1;
    }
  }
  
  public int tj()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.Lb()) && (al(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.bqp, 32768)))
    {
      if (this.jdField_b_of_type_Rco == null) {
        throw new IllegalStateException("mEditVideoFragment is null");
      }
      return this.jdField_b_of_type_Rco.tf();
    }
    return 0;
  }
  
  public int tk()
  {
    switch (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi)
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
    if (this.jdField_a_of_type_Rcc != null) {
      i = this.jdField_a_of_type_Rcc.ed(tj());
    }
    int j = i;
    if (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
    {
      j = i;
      if (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.KW()) {
        j = i + 1;
      }
    }
    return j;
  }
  
  public int tm()
  {
    if (this.jdField_b_of_type_Rco != null)
    {
      List localList = this.jdField_b_of_type_Rco.cb();
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
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.Lb()) && (al(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.bqp, 32768)))
    {
      localObject = (rdo)a(rdo.class);
      if (localObject != null)
      {
        l2 = ((rdo)localObject).w(paramInt);
        ram.b("Q.qqstory.publish.edit.EditVideoPartManager", "getRealVideoTime %d by index %d", Long.valueOf(l2), Integer.valueOf(paramInt));
      }
    }
    for (;;)
    {
      long l1 = l2;
      if (l2 <= 0L)
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
        if (!(localObject instanceof EditRecordVideoSource)) {
          break label146;
        }
        l1 = ((EditRecordVideoSource)localObject).recordTime;
      }
      for (;;)
      {
        if (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
        switch (this.jdField_b_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.tc())
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
            throw new RuntimeException(acfp.m(2131705624));
          }
          break;
        case 1: 
          return l1 / 2L;
        case 2: 
          label146:
          return l1 * 2L;
        }
      }
      l2 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rdc
 * JD-Core Version:    0.7.0.1
 */