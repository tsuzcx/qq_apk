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

public class yxt
  implements IEventReceiver
{
  private int a;
  protected Intent a;
  public EditGifImage a;
  public EditPicRawImage a;
  public EditVideoArtFilter a;
  public EditVideoFilter a;
  protected EditVideoGuide a;
  protected EditVideoMusic a;
  public EditVideoParams a;
  protected List<yxr> a;
  protected Map<Class<? extends yxs>, yxs> a;
  protected final AtomicInteger a;
  protected yvb a;
  protected yvd a;
  public yvh a;
  public yvp a;
  protected yvs a;
  public ywf a;
  protected ywh a;
  protected yxb a;
  protected yxk a;
  protected yyb a;
  protected yyd a;
  protected yyg a;
  protected yym a;
  protected yyq a;
  protected yyu a;
  protected yyw a;
  protected yyx a;
  protected yyy a;
  public yze a;
  protected boolean a;
  public int b;
  protected List<Error> b;
  private AtomicInteger b;
  protected boolean b;
  protected boolean c;
  public boolean d;
  
  public yxt()
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = Collections.emptyList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1000);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private yxr a(@NonNull EditVideoParams paramEditVideoParams)
  {
    if (paramEditVideoParams.a())
    {
      paramEditVideoParams = new EditPicRawImage(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage = paramEditVideoParams;
      return paramEditVideoParams;
    }
    if (paramEditVideoParams.e())
    {
      paramEditVideoParams = new EditGifImage(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage = paramEditVideoParams;
      return paramEditVideoParams;
    }
    if ((paramEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
      return new HWEditLocalVideoPlayer(this);
    }
    if ((paramEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      if (paramEditVideoParams.g()) {
        return new HWEditLocalVideoPlayer(this);
      }
      paramEditVideoParams = new yvh(this);
      this.jdField_a_of_type_Yvh = paramEditVideoParams;
      return paramEditVideoParams;
    }
    if (paramEditVideoParams.g()) {
      return new HWEditLocalVideoPlayer(this);
    }
    paramEditVideoParams = new yyd(this);
    this.jdField_a_of_type_Yyd = paramEditVideoParams;
    return paramEditVideoParams;
  }
  
  private void a(EditVideoParams.EditSource paramEditSource)
  {
    zih localzih = new zih(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
    localzih.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_upload_temp_directory");
    if (localzih.jdField_b_of_type_JavaLangString == null) {
      localzih.jdField_b_of_type_JavaLangString = zix.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
    }
    if ((paramEditSource instanceof EditLocalGifSource)) {
      if ((!TextUtils.isEmpty(paramEditSource.a())) || (((EditLocalGifSource)paramEditSource).a.size() <= 0)) {
        break label139;
      }
    }
    label139:
    for (localzih.jdField_a_of_type_Zil = new zil((String)((EditLocalGifSource)paramEditSource).a.get(0));; localzih.jdField_a_of_type_Zil = new zil(paramEditSource.a()))
    {
      paramEditSource = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramEditSource.hasNext()) {
        ((yxr)paramEditSource.next()).a(0, localzih);
      }
    }
    a(localzih);
    b(localzih);
    yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { localzih.jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_Yze.a(anzj.a(2131702704), false, 500L);
    Stream.of(localzih).map(new zij((yuy)a(yuy.class), null, true)).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2)).map(new ziv(yvo.jdField_a_of_type_JavaLangString + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new UIThreadOffFunction(this)).subscribe(a(localzih));
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  private boolean a(zih paramzih)
  {
    if (paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath != null) {}
    do
    {
      do
      {
        return true;
      } while (paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath != null);
      if (paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.atJsonData != null)
      {
        yuk.c("Q.qqstory.publish.edit.EditVideoPartManager", "HAS AT LABELS.");
        return true;
      }
    } while ((paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath != null) || (paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isMuteRecordVoice) || (paramzih.jdField_b_of_type_Boolean) || (paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode != 0));
    return false;
  }
  
  private void b()
  {
    b(0);
  }
  
  private void b(int paramInt)
  {
    label52:
    String str2;
    if (a())
    {
      a("pub_photo", 0, 0, new String[] { "", "5000" });
      str1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("mCurrentTemplatePath");
      if (TextUtils.isEmpty(str1)) {
        break label158;
      }
      paramInt = 1;
      if (paramInt != 0)
      {
        paramInt = b();
        str2 = a(str1);
        if (!a()) {
          break label163;
        }
      }
    }
    label158:
    label163:
    for (String str1 = "2";; str1 = "1")
    {
      b("pub_changeface", paramInt, 0, new String[] { "1", str2, str1 });
      return;
      a("pub_video", 0, 0, new String[] { "", String.valueOf(a(paramInt)) });
      Bosses.get().postJob(new yxz(this, "Q.qqstory.publish.edit.EditVideoPartManager"));
      break;
      paramInt = 0;
      break label52;
    }
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
      yuk.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + bdbt.z + " CodecParam.mRecordTime" + bdbt.y);
      bdbt.y = (int)((EditRecordVideoSource)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Long;
      bdbt.z = ((EditRecordVideoSource)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Int;
      bdbt.x = 0;
      bdbt.E = 0;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
      {
        bdbt.J = i;
        i = ((EditRecordVideoSource)localObject1).f;
        j = ((EditRecordVideoSource)localObject1).g;
        str1 = ((EditRecordVideoSource)localObject1).jdField_a_of_type_JavaLangString;
        f = ((EditRecordVideoSource)localObject1).jdField_a_of_type_Float;
        k = ((EditRecordVideoSource)localObject1).e;
        str2 = ((EditRecordVideoSource)localObject1).jdField_b_of_type_JavaLangString;
        bool1 = ((EditRecordVideoSource)localObject1).jdField_a_of_type_Boolean;
        localArrayList = new ArrayList();
        str3 = String.format("%s.%d", new Object[] { QQStoryContext.a().a(), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)) });
        yuk.b("Q.qqstory.publish.edit.EditVideoPartManager", "publish video groupId=%s. fragment count=%d", str3, Integer.valueOf(localArrayList.size()));
        str4 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_upload_temp_directory");
        if ((!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b()) || (!a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 32768))) {
          break label1041;
        }
        localObject1 = null;
        if (this.jdField_a_of_type_Yxb != null) {
          localObject1 = this.jdField_a_of_type_Yxb.a();
        }
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break;
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localArrayList.add(Integer.valueOf(((yzy)((Iterator)localObject1).next()).c));
        }
      }
    }
    if ((paramEditSource instanceof EditLocalVideoSource))
    {
      localObject1 = (EditLocalVideoSource)paramEditSource;
      yuk.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + bdbt.z + " CodecParam.mRecordTime" + bdbt.y);
      bdbt.y = 5000;
      bdbt.z = 125;
      bdbt.x = 0;
      bdbt.E = 0;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
      {
        bdbt.J = i;
        j = ((EditLocalVideoSource)localObject1).a();
        k = ((EditLocalVideoSource)localObject1).b();
        i = Math.min(j, k);
        j = Math.max(j, k);
        str1 = ((EditLocalVideoSource)localObject1).a();
        f = i * 1.0F / j;
        k = ((EditLocalVideoSource)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
        str2 = "";
        bool1 = false;
        yuk.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo EditLocalVideoSource.mediaInfo" + ((EditLocalVideoSource)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.toString());
        break;
      }
    }
    if ((paramEditSource instanceof EditTakeVideoSource))
    {
      localObject1 = (EditTakeVideoSource)paramEditSource;
      yuk.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + bdbt.z + " CodecParam.mRecordTime" + bdbt.y);
      bdbt.y = 5000;
      bdbt.z = 125;
      bdbt.x = 0;
      bdbt.E = 0;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      for (i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
      {
        bdbt.J = i;
        i = ((EditTakeVideoSource)localObject1).a();
        j = ((EditTakeVideoSource)localObject1).b();
        str1 = ((EditTakeVideoSource)localObject1).a();
        f = i * 1.0F / j;
        k = ((EditTakeVideoSource)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation;
        str2 = "";
        bool1 = false;
        break;
      }
    }
    throw new IllegalArgumentException(anzj.a(2131702633) + paramEditSource);
    yuk.e("Q.qqstory.publish.edit.EditVideoPartManager", "can not find any video fragment ! break the process of publish");
    return;
    int m = 1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(localArrayList.size());
    this.jdField_b_of_type_JavaUtilList.clear();
    int n = 0;
    label759:
    int i1;
    zih localzih;
    label914:
    label957:
    Object localObject2;
    if (n < localArrayList.size())
    {
      i1 = ((Integer)localArrayList.get(n)).intValue();
      b(i1);
      localzih = new zih(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.multiFragmentGroupId = str3;
      localzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.createTime = (n * 1000 + l);
      localzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = bdbt.r;
      localzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMinrate = bdbt.s;
      localzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoUploadGroupTempDir = str4;
      localzih.jdField_b_of_type_JavaLangString = zix.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
      localObject1 = this.jdField_a_of_type_Yze.getActivity();
      boolean bool2;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() == 5))
      {
        bool2 = true;
        localzih.jdField_a_of_type_Zin = new zin((Activity)localObject1, i, j, str1, f, bool2, k, 0.0D, 0.0D, str2, bool1);
        if (!(paramEditSource instanceof EditLocalVideoSource)) {
          break label1065;
        }
        localzih.c = 0;
        localzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("thumb_rotation", Integer.valueOf(localzih.c));
        if (!(paramEditSource instanceof EditTakeVideoSource)) {
          break label1075;
        }
        localzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("is_hw_encode", Boolean.valueOf(true));
      }
      for (;;)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((yxr)((Iterator)localObject1).next()).a(i1, localzih);
        }
        label1041:
        localArrayList.add(Integer.valueOf(0));
        m = 0;
        break;
        bool2 = false;
        break label914;
        label1065:
        localzih.c = k;
        break label957;
        label1075:
        localzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("is_hw_encode", Boolean.valueOf(false));
      }
      a(localzih);
      b(localzih);
      yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { localzih.jdField_b_of_type_JavaLangString });
      this.jdField_a_of_type_Yze.a(anzj.a(2131702631), false, 500L);
      localObject1 = Stream.of(localzih).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2));
      if ((!(paramEditSource instanceof EditTakeVideoSource)) && (!(paramEditSource instanceof EditLocalVideoSource))) {
        break label1305;
      }
      localObject1 = ((Stream)localObject1).map(new zis(null, (yyf)a(yyf.class), i1));
      label1205:
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Ywh != null) {
        localObject2 = ((Stream)localObject1).map(this.jdField_a_of_type_Ywh.a(i1));
      }
      if ((!(paramEditSource instanceof EditTakeVideoSource)) && (!(paramEditSource instanceof EditLocalVideoSource))) {
        break label1357;
      }
    }
    label1305:
    label1357:
    for (Object localObject1 = ((Stream)localObject2).map(new zit());; localObject1 = ((Stream)localObject2).map(new ziw()).map(new zig()))
    {
      ((Stream)localObject1).map(new ziz(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(a(localzih));
      n += 1;
      break label759;
      break;
      if (m != 0)
      {
        localObject1 = ((Stream)localObject1).map(new zio(null, (yyf)a(yyf.class), i1));
        break label1205;
      }
      localObject1 = ((Stream)localObject1).map(new zio());
      break label1205;
    }
  }
  
  private void c(EditVideoParams.EditSource paramEditSource)
  {
    zih localzih = new zih(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
    localzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = bdbt.r;
    localzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMinrate = bdbt.s;
    localzih.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_upload_temp_directory");
    if (localzih.jdField_b_of_type_JavaLangString == null) {
      localzih.jdField_b_of_type_JavaLangString = zix.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
    }
    localzih.jdField_a_of_type_Zil = new zil(paramEditSource.a());
    paramEditSource = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramEditSource.hasNext()) {
      ((yxr)paramEditSource.next()).a(0, localzih);
    }
    a(localzih);
    b(localzih);
    yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", new Object[] { localzih.jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_Yze.a(anzj.a(2131702688), false, 500L);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    this.jdField_b_of_type_JavaUtilList.clear();
    paramEditSource = Stream.of(localzih).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2)).map(new ziv(false)).map(new zja());
    Object localObject = this.jdField_a_of_type_Yze.getActivity();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
    for (int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
    {
      localObject = paramEditSource.map(new zim((Activity)localObject, i));
      paramEditSource = (EditVideoParams.EditSource)localObject;
      if (this.jdField_a_of_type_Ywh != null) {
        paramEditSource = ((Stream)localObject).map(this.jdField_a_of_type_Ywh.a(0));
      }
      paramEditSource.map(new ziw()).map(new zig()).map(new ziz(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(a(localzih));
      return;
    }
  }
  
  private void v()
  {
    if ((this.jdField_a_of_type_Yze == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null)) {
      throw new IllegalStateException("have not attach ui and params");
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b()) && (a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 32768)))
    {
      if (this.jdField_a_of_type_Yxb == null) {
        throw new IllegalStateException("mEditVideoFragment is null");
      }
      return this.jdField_a_of_type_Yxb.a();
    }
    return 0;
  }
  
  public int a(@NonNull Message paramMessage)
  {
    o();
    v();
    if (this.jdField_b_of_type_Boolean)
    {
      yuk.b("Q.qqstory.publish.edit.EditVideoPartManager", "broadcast message ignore because of publishing, %s", new Throwable());
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((yxr)localIterator.next()).b(Message.obtain(paramMessage))) {
        break label105;
      }
      i += 1;
    }
    label105:
    for (;;)
    {
      break;
      if (i == 0) {
        yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "broadcastEditVideoMessage, but no one handled. %s", new Object[] { paramMessage });
      }
      paramMessage.recycle();
      return i;
    }
  }
  
  public long a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    long l;
    if ((localObject instanceof EditRecordVideoSource)) {
      l = ((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
      switch (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a())
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
          l = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int - ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
          if (l == 0L) {
            l = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
          }
        }
        else if ((localObject instanceof EditTakeVideoSource))
        {
          l = ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
        }
        else
        {
          throw new RuntimeException(anzj.a(2131702707));
        }
        break;
      case 1: 
        return l / 2L;
      case 2: 
        return l * 2L;
      }
    }
  }
  
  public long a(int paramInt)
  {
    Object localObject;
    long l2;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b()) && (a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 32768)))
    {
      localObject = (yyf)a(yyf.class);
      if (localObject != null)
      {
        l2 = ((yyf)localObject).a(paramInt);
        yuk.a("Q.qqstory.publish.edit.EditVideoPartManager", "getRealVideoTime %d by index %d", Long.valueOf(l2), Integer.valueOf(paramInt));
      }
    }
    for (;;)
    {
      long l1 = l2;
      if (l2 <= 0L)
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        if (!(localObject instanceof EditRecordVideoSource)) {
          break label146;
        }
        l1 = ((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
        switch (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a())
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
            l1 = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int - ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
            if (l1 == 0L) {
              l1 = ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
            }
          }
          else if ((localObject instanceof EditTakeVideoSource))
          {
            l1 = ((EditTakeVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
          }
          else
          {
            throw new RuntimeException(anzj.a(2131702746));
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
  
  public Bitmap a()
  {
    Bitmap localBitmap = null;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage != null) {
      localBitmap = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage.a();
    }
    return localBitmap;
  }
  
  protected SimpleObserver<zih> a(zih paramzih)
  {
    return new yya(this, paramzih, SystemClock.uptimeMillis());
  }
  
  public String a(String paramString)
  {
    if ((paramString != null) && (paramString.length() >= PtvTemplateManager.jdField_a_of_type_JavaLangString.length())) {
      return ":" + paramString.substring(PtvTemplateManager.jdField_a_of_type_JavaLangString.length());
    }
    return "";
  }
  
  @Nullable
  public yxs a(Class<? extends yxs> paramClass)
  {
    if (paramClass == null) {
      throw new IllegalArgumentException("editExportClass should not be null");
    }
    return (yxs)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
  }
  
  public void a()
  {
    int i = 0;
    o();
    v();
    Object localObject;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      localObject = (yyf)a(yyf.class);
      if (localObject != null) {
        ((yyf)localObject).j();
      }
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "onConfirmClick : %s", new Object[] { localObject });
      if ((!(localObject instanceof EditRecordVideoSource)) && (!(localObject instanceof EditLocalVideoSource)) && (!(localObject instanceof EditTakeVideoSource))) {
        break label131;
      }
      b((EditVideoParams.EditSource)localObject);
      if ((localObject instanceof EditLocalVideoSource)) {
        yup.a("video_edit", "pub_local", 0, 0, new String[] { "1" });
      }
    }
    label131:
    do
    {
      return;
      yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "requestPublish duplicate");
      return;
      if (((localObject instanceof EditLocalPhotoSource)) || ((localObject instanceof EditTakePhotoSource)))
      {
        b();
        bdbt.y = 5000;
        bdbt.z = 125;
        bdbt.x = 0;
        bdbt.E = 0;
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {}
        for (i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();; i = 0)
        {
          bdbt.J = i;
          c((EditVideoParams.EditSource)localObject);
          yup.a("video_edit", "pub_local", 0, 0, new String[0]);
          return;
        }
      }
    } while (!(localObject instanceof EditLocalGifSource));
    bdbt.y = 5000;
    bdbt.z = 125;
    bdbt.x = 0;
    bdbt.E = 0;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {
      i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
    }
    bdbt.J = i;
    a((EditVideoParams.EditSource)localObject);
  }
  
  public final void a(int paramInt)
  {
    a(paramInt, null);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((yxr)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
      }
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    }
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    o();
    v();
    if (this.jdField_b_of_type_Boolean)
    {
      yuk.b("Q.qqstory.publish.edit.EditVideoPartManager", "change state ignore because of publishing, %s", new Throwable());
      return;
    }
    if (this.jdField_b_of_type_Int != paramInt)
    {
      if (this.jdField_a_of_type_Boolean) {
        yuk.b("Q.qqstory.publish.edit.EditVideoPartManager", "change state while state changing, " + paramInt + " oldState:" + this.jdField_b_of_type_Int, new Throwable());
      }
      this.jdField_a_of_type_Boolean = true;
      yuk.b("Q.qqstory.publish.edit.EditVideoPartManager", "changeState : %s => %s", Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(paramInt));
      int i = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = paramInt;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((yxr)localIterator.next()).a(i, this.jdField_b_of_type_Int, paramObject);
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b() == 14) {
      yup.a("story_grp", "clk_send", 0, 0, new String[0]);
    }
    long l = a();
    paramContext = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    int i;
    if ((paramContext instanceof EditRecordVideoSource)) {
      if (((EditRecordVideoSource)paramContext).jdField_b_of_type_Int == 1) {
        i = 1;
      }
    }
    for (;;)
    {
      int j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("report_entrance_type", 0);
      int k = b();
      if (a())
      {
        paramContext = "2";
        label90:
        b("clk_publish", k, 0, new String[] { paramContext, String.valueOf(l), String.valueOf(i), j + "" });
        if (a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 32768))
        {
          i = d();
          if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.d()) {
            break label401;
          }
          paramContext = "0";
          label181:
          b("pub_edit_more", 0, 0, new String[] { String.valueOf(i), paramContext });
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b() != 16) {
          break label408;
        }
      }
      label401:
      label408:
      for (i = 1;; i = 0)
      {
        paramContext = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("story_default_label");
        l = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("story_topic_id", 0L);
        if ((i != 0) && (!TextUtils.isEmpty(paramContext)) && (l > 0L)) {
          yup.a("content_flow", "clk_hot_pub", 0, 0, new String[] { String.valueOf(l), paramContext });
        }
        if (this.jdField_a_of_type_Yyx != null) {
          bdll.b(null, "dc00898", "", "", "0X8008759", "0X8008759", 0, 0, "", "", "", "");
        }
        return;
        i = 2;
        break;
        if ((paramContext instanceof EditTakeVideoSource))
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("currentCamera", 2) == 1)
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
        if (((EditTakePhotoSource)paramContext).jdField_a_of_type_Int == 1)
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
  
  void a(Intent paramIntent, int paramInt, PublishParam paramPublishParam)
  {
    switch (paramInt)
    {
    case 102: 
    case 103: 
    case 105: 
    default: 
      this.jdField_a_of_type_Yze.a(-1, paramIntent, 2130772029, 0);
      return;
    }
    paramIntent.setClassName("com.tencent.mobileqq", ForwardRecentActivity.class.getName());
    paramIntent.putExtra("forward_type", 21);
    paramIntent.putExtra("forward_ability_entrence_show_in_share", true);
    paramIntent.putExtra("k_qzone", true);
    paramIntent.putExtra("k_qqstory", true);
    paramIntent.putExtra("forward_thumb", paramPublishParam.c);
    paramIntent.putExtra("forward_urldrawable", true);
    paramIntent.putExtra("forward_urldrawable_big_url", paramPublishParam.c);
    paramIntent.putExtra("forward_urldrawable_thumb_url", paramPublishParam.c);
    paramIntent.putExtra("k_dataline", false);
    paramIntent.putExtra("k_smartdevice", false);
    paramIntent.putExtra("k_favorites", false);
    paramIntent.putExtra("k_phonecontacts", false);
    paramIntent.putExtra("forward_photo_shortvideo_is_edited", true);
    if (paramInt == 104)
    {
      paramIntent.putExtra("forward_source_from_pre_guide", true);
      this.jdField_a_of_type_Yze.getActivity().startActivityForResult(paramIntent, 10010);
      return;
    }
    paramIntent.putExtra("forward_source_from_shoot_quick", true);
    this.jdField_a_of_type_Yze.getActivity().startActivityForResult(paramIntent, 10004);
    yup.a("plus_shoot", "exp_send", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    o();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage.a(paramBitmap, paramBoolean);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((yxr)localIterator.next()).a(paramBundle);
    }
  }
  
  public void a(Animation paramAnimation) {}
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    yuk.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %s", paramEditVideoParams);
    int i = paramEditVideoParams.jdField_b_of_type_Int;
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ywf(this, i);
    this.jdField_a_of_type_Ywf = ((ywf)localObject);
    localArrayList.add(localObject);
    localArrayList.add(a(paramEditVideoParams));
    if (a(i, 256))
    {
      localObject = new EditVideoGuide(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoGuide = ((EditVideoGuide)localObject);
      localArrayList.add(localObject);
    }
    if (a(i, 32))
    {
      localObject = new EditVideoMusic(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic = ((EditVideoMusic)localObject);
      localArrayList.add(localObject);
    }
    if ((a(i, 1)) || (a(i, 4)) || (a(i, 8)))
    {
      localObject = new ywh(this, i);
      this.jdField_a_of_type_Ywh = ((ywh)localObject);
      localArrayList.add(localObject);
      localObject = new yyg(this);
      this.jdField_a_of_type_Yyg = ((yyg)localObject);
      localArrayList.add(localObject);
      localObject = new yym(this);
      this.jdField_a_of_type_Yym = ((yym)localObject);
      localArrayList.add(localObject);
    }
    if (a(i, 64))
    {
      if (paramEditVideoParams.jdField_a_of_type_Int == 1)
      {
        localObject = new ywy(this);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter = ((EditVideoFilter)localObject);
        localArrayList.add(localObject);
      }
    }
    else
    {
      if (a(i, 128))
      {
        localObject = new yxk(this);
        this.jdField_a_of_type_Yxk = ((yxk)localObject);
        localArrayList.add(localObject);
      }
      if (((paramEditVideoParams.a()) || (paramEditVideoParams.e())) && (a(i, 16)))
      {
        localObject = new EditVideoArtFilter(this);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter = ((EditVideoArtFilter)localObject);
        localArrayList.add(localObject);
      }
      if ((paramEditVideoParams.a()) && (a(i, 2)))
      {
        localObject = new yvp(this);
        this.jdField_a_of_type_Yvp = ((yvp)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 1024))
      {
        if (!paramEditVideoParams.a()) {
          break label795;
        }
        localObject = new yvs(this);
        this.jdField_a_of_type_Yvs = ((yvs)localObject);
        localArrayList.add(localObject);
      }
    }
    for (;;)
    {
      if (a(i, 4096))
      {
        localObject = new yvb(this);
        this.jdField_a_of_type_Yvb = ((yvb)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 16384))
      {
        localObject = new yyb(this);
        this.jdField_a_of_type_Yyb = ((yyb)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 131072))
      {
        localObject = new yyw(this);
        this.jdField_a_of_type_Yyw = ((yyw)localObject);
        localArrayList.add(localObject);
      }
      if ((paramEditVideoParams.b()) && (a(i, 32768)))
      {
        localObject = new yxb(this);
        this.jdField_a_of_type_Yxb = ((yxb)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 2097152))
      {
        localObject = new yyu(this);
        this.jdField_a_of_type_Yyu = ((yyu)localObject);
        localArrayList.add(localObject);
      }
      if (a(i, 4194304))
      {
        localObject = new yyy(this);
        this.jdField_a_of_type_Yyy = ((yyy)localObject);
        localArrayList.add(localObject);
      }
      paramEditVideoParams = paramEditVideoParams.a("extra_subtile_data");
      if (paramEditVideoParams != null)
      {
        paramEditVideoParams = new yyx(this, paramEditVideoParams);
        this.jdField_a_of_type_Yyx = paramEditVideoParams;
        localArrayList.add(paramEditVideoParams);
      }
      a(localArrayList);
      this.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(localArrayList);
      yuk.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
      paramEditVideoParams = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramEditVideoParams.hasNext()) {
        yuk.a("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts : %s", ((yxr)paramEditVideoParams.next()).getClass().getSimpleName());
      }
      localObject = new EditVideoFilter(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter = ((EditVideoFilter)localObject);
      localArrayList.add(localObject);
      break;
      label795:
      localObject = new yyq(this);
      this.jdField_a_of_type_Yyq = ((yyq)localObject);
      localArrayList.add(localObject);
    }
  }
  
  public void a(Class<? extends yxs> paramClass, yxs paramyxs)
  {
    o();
    v();
    if (paramClass == null) {
      throw new IllegalArgumentException("editExportClass should not be null");
    }
    if (!paramClass.isInstance(paramyxs)) {
      throw new IllegalArgumentException("the 2nd parameter's type " + paramyxs.getClass().getName() + " is not instance of " + paramClass.getName());
    }
    yxs localyxs = (yxs)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
    if (localyxs == null) {
      yuk.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishEditExport for %s with %s", paramClass.getSimpleName(), paramyxs);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramClass, paramyxs);
      return;
      yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "publishEditExport for %s replace %s by %s", new Object[] { paramClass.getSimpleName(), localyxs, paramyxs });
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1) {
      Bosses.get().postJob(new yxx(this, "Q.qqstory.publish.edit.EditVideoPartManager", paramString, paramInt1, paramInt2, paramVarArgs));
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
  
  protected void a(List<yxr> paramList) {}
  
  public void a(yze paramyze, EditVideoParams paramEditVideoParams)
  {
    o();
    if ((paramyze == null) || (paramEditVideoParams == null)) {
      throw new IllegalArgumentException("both ui ant params should not be null");
    }
    if ((this.jdField_a_of_type_Yze != paramyze) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != paramEditVideoParams))
    {
      this.jdField_a_of_type_Yze = paramyze;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
      a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      paramEditVideoParams = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (paramEditVideoParams.hasNext())
    {
      ((yxr)paramEditVideoParams.next()).a(paramyze);
      continue;
      yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "duplicate attachUiAndParams ui=%s, params=%s", new Object[] { paramyze, paramEditVideoParams });
    }
  }
  
  public void a(zih paramzih)
  {
    Object localObject = paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.readerConfBytes;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = new qqstory_struct.VideoReaderConf();
      ((qqstory_struct.VideoReaderConf)localObject).ban_type.set(0);
      ((qqstory_struct.VideoReaderConf)localObject).setHasFlag(true);
      paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.readerConfBytes = ((qqstory_struct.VideoReaderConf)localObject).toByteArray();
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    for (;;)
    {
      try
      {
        if (!this.d) {
          continue;
        }
        i = 3;
        VideoSourceHelper.nativeSetPlayStepFrameCount(i);
        if (!this.d) {
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
        VideoSourceHelper.nativeSetPlayAFMute(this.d);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic == null) {
        continue;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramBoolean);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.b(paramBoolean);
      return;
      i = 1;
      continue;
      i = 1;
    }
  }
  
  public boolean a()
  {
    o();
    v();
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a();
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_b_of_type_Int == paramInt;
  }
  
  public int b()
  {
    switch (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int)
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
  
  public void b(Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((yxr)localIterator.next()).b(paramBundle);
    }
    paramBundle.putInt("mEditState", this.jdField_b_of_type_Int);
  }
  
  public void b(Animation paramAnimation) {}
  
  public void b(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    Bosses.get().postJob(new yxy(this, "Q.qqstory.publish.edit.EditVideoPartManager", paramString, paramInt1, paramInt2, paramVarArgs));
  }
  
  public void b(zih paramzih)
  {
    long l = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getLong("troop_uin");
    if (l != 0L)
    {
      Object localObject = new qqstory_struct.VideoReaderConf();
      ((qqstory_struct.VideoReaderConf)localObject).ban_type.set(1);
      ((qqstory_struct.VideoReaderConf)localObject).user_list.set(new ArrayList());
      ((qqstory_struct.VideoReaderConf)localObject).setHasFlag(true);
      paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.readerConfBytes = ((qqstory_struct.VideoReaderConf)localObject).toByteArray();
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Long.valueOf(l));
      if (((ArrayList)localObject).size() > 0) {
        try
        {
          qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
          byte[] arrayOfByte = paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.spreadGroupBytes;
          if (arrayOfByte != null) {}
          try
          {
            localVideoSpreadGroupList.mergeFrom(paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.spreadGroupBytes);
            localVideoSpreadGroupList.group_list.set((List)localObject);
            localVideoSpreadGroupList.visibility_type.set(4);
            localVideoSpreadGroupList.setHasFlag(true);
            paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
            return;
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            for (;;)
            {
              yuk.c("Q.qqstory.publish.edit.EditVideoPartManager", "checkTroopStory", localInvalidProtocolBufferMicroException);
            }
          }
          return;
        }
        finally {}
      }
    }
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_Yym != null) && (this.jdField_a_of_type_Yym.a()))
    {
      yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Yym });
      return true;
    }
    if ((this.jdField_a_of_type_Yyg != null) && (this.jdField_a_of_type_Yyg.a()))
    {
      yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Yyg });
      return true;
    }
    if ((this.jdField_a_of_type_Yyy != null) && (this.jdField_a_of_type_Yyy.a()))
    {
      yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Yyy });
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a()))
    {
      yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic });
      return true;
    }
    if ((this.jdField_a_of_type_Yxk != null) && (this.jdField_a_of_type_Yxk.a()))
    {
      yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Yxk });
      return true;
    }
    if ((this.jdField_a_of_type_Ywh != null) && (this.jdField_a_of_type_Ywh.a()))
    {
      yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Ywh });
      return true;
    }
    if ((this.jdField_a_of_type_Yvp != null) && (this.jdField_a_of_type_Yvp.a()))
    {
      yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Yvp });
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.a()))
    {
      yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter });
      return true;
    }
    if ((this.jdField_a_of_type_Yvb != null) && (this.jdField_a_of_type_Yvb.a()))
    {
      yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", new Object[] { this.jdField_a_of_type_Yvb });
      return true;
    }
    d();
    return true;
  }
  
  public boolean b(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoGuide != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoGuide.jdField_b_of_type_Int == paramInt) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int c()
  {
    int i = 0;
    if (this.jdField_a_of_type_Ywh != null) {
      i = this.jdField_a_of_type_Ywh.a(a());
    }
    int j = i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
    {
      j = i;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.b()) {
        j = i + 1;
      }
    }
    return j;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_Yze.a(0, null, 2130772029, 0);
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Yxb != null)
    {
      List localList = this.jdField_a_of_type_Yxb.a();
      if (localList != null) {
        return localList.size();
      }
    }
    return 1;
  }
  
  public void d()
  {
    o();
    v();
    Object localObject;
    if (a())
    {
      localObject = "2";
      a("clk_left", 0, 0, new String[] { localObject });
      yuq.a("0X80076B6");
      yuq.b("0X80075C2");
      yuq.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007823");
      if (this.jdField_a_of_type_Ywh == null) {
        break label491;
      }
    }
    label457:
    label491:
    for (int j = this.jdField_a_of_type_Ywh.b();; j = 0)
    {
      int i = j;
      if (this.jdField_a_of_type_Yxk != null)
      {
        i = j;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Yxk.a())) {
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
          if (!TextUtils.isEmpty(((zhr)localObject).g)) {
            j = i + 1;
          }
        }
      }
      i = j;
      if (this.jdField_a_of_type_Yvp != null) {
        i = j + this.jdField_a_of_type_Yvp.jdField_a_of_type_Int;
      }
      j = i;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
      {
        j = i;
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.b()) {
          j = i + 4;
        }
      }
      yuk.a("Q.qqstory.publish.edit.EditVideoPartManager", "tryQuitRecordUI, current is preview state, edit count = %d", Integer.valueOf(j));
      if (j < 4)
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a()) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle != null) && (!anzj.a(2131702693).equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.get("extra_publish_text"))))
        {
          localObject = anzj.a(2131702742);
          bhlq.a(this.jdField_a_of_type_Yze.a(), 230, (String)localObject, null, anzj.a(2131702717), anzj.a(2131702657), new yxu(this), new yxv(this)).show();
          return;
          localObject = "1";
          break;
        }
        c();
        return;
      }
      if (a())
      {
        localObject = "2";
        a("clk_left_float", 0, 0, new String[] { localObject });
        yuq.a("0X80076B7");
        yuq.b("0X80075C3");
        if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a()) {
          break label457;
        }
        localObject = anzj.a(2131702621);
      }
      for (;;)
      {
        blir localblir = blir.a(this.jdField_a_of_type_Yze.a(), false);
        localblir.a((CharSequence)localObject);
        localblir.a(anzj.a(2131702692), 3);
        localblir.d(anzj.a(2131702656));
        localblir.a(new yxw(this, localblir));
        localblir.show();
        return;
        localObject = "1";
        break;
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) || (this.d)) {
          localObject = "放弃本次GIF编辑？";
        } else {
          localObject = anzj.a(2131702811);
        }
      }
    }
  }
  
  public void e()
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_Ywh != null)
    {
      zbd localzbd = this.jdField_a_of_type_Ywh.a().a();
      i = j;
      if (localzbd != null)
      {
        i = j;
        if (localzbd.a.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "preparePublish");
          }
          this.jdField_a_of_type_Yze.a(anzj.a(2131702605), false, 500L);
          this.jdField_a_of_type_Ywh.jdField_a_of_type_Int = 2;
          this.jdField_a_of_type_Ywh.a().h();
          i = 1;
        }
      }
    }
    if (i == 0) {
      f();
    }
  }
  
  public void f()
  {
    a(this.jdField_a_of_type_Yze.a());
    a();
    Activity localActivity = this.jdField_a_of_type_Yze.getActivity();
    if ((localActivity instanceof EditPicActivity)) {}
    switch (localActivity.getIntent().getIntExtra("editpic_cameratype", -1))
    {
    default: 
      return;
    case 1: 
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("sv_latest_taken_photo_time", -1L).commit();
      alwe.c();
      return;
    case 2: 
      alwe.d();
      return;
    }
    alwe.e();
  }
  
  public void g()
  {
    int i = 0;
    o();
    v();
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      b();
      EditVideoParams.EditSource localEditSource = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "onConfirmClick : %s", new Object[] { localEditSource });
      bdbt.y = 5000;
      bdbt.z = 125;
      bdbt.x = 0;
      bdbt.E = 0;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null) {
        i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      }
      bdbt.J = i;
      c(localEditSource);
      return;
    }
    yuk.b("Q.qqstory.publish.edit.EditVideoPartManager", "duplicate publish", new Throwable());
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoGuide != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoGuide.jdField_a_of_type_Int == 2)) {
      a(10);
    }
  }
  
  public void i()
  {
    o();
    v();
    this.c = true;
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((yxr)((Iterator)localObject).next()).a();
    }
    if (a()) {}
    for (localObject = "2";; localObject = "1")
    {
      a("exp_edit", 0, 0, new String[] { localObject });
      if (this.jdField_a_of_type_Yyw != null) {
        yup.a("story_grp", "exp_share_grp", 0, 0, new String[] { "", "", "", "" });
      }
      return;
    }
  }
  
  public boolean isValidate()
  {
    return this.c;
  }
  
  public void j()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((yxr)localIterator.next()).c();
    }
  }
  
  public void k()
  {
    if (this.jdField_b_of_type_Int == -1) {
      a(0);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((yxr)localIterator.next()).W_();
    }
    if ((!a()) || (a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 32)))
    {
      yuk.a("Q.qqstory.publish.edit.EditVideoPartManager", "getAudioResource, edit photo = %s", Boolean.valueOf(a()));
      bczp.a();
    }
  }
  
  public void l()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((yxr)localIterator.next()).h();
    }
    if ((!a()) || (a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 32)))
    {
      yuk.a("Q.qqstory.publish.edit.EditVideoPartManager", "releaseAudioResource, edit photo = %s", Boolean.valueOf(a()));
      bczp.b();
    }
  }
  
  public void m()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((yxr)localIterator.next()).Y_();
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((yxr)localIterator.next()).d();
      }
    }
    this.c = false;
  }
  
  protected void o()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("can not access by non-ui thread");
    }
  }
  
  void p()
  {
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_Ywh.a();
    if (localDoodleLayout != null) {
      localDoodleLayout.a.c();
    }
  }
  
  void q()
  {
    int j = 0;
    Object localObject = this.jdField_a_of_type_Yvp;
    ((yvp)localObject).jdField_a_of_type_Int += c();
    if (this.jdField_b_of_type_Int == 11) {
      a(0);
    }
    int i;
    do
    {
      return;
      localObject = this.jdField_a_of_type_Ywh.a();
      zbd localzbd = ((DoodleLayout)localObject).a();
      i = j;
      if (localzbd != null)
      {
        i = j;
        if (localzbd.a.a())
        {
          this.jdField_a_of_type_Yze.a(anzj.a(2131702829), false, 500L);
          this.jdField_a_of_type_Ywh.jdField_a_of_type_Int = 3;
          ((DoodleLayout)localObject).h();
          i = 1;
        }
      }
    } while (i != 0);
    r();
  }
  
  public void r()
  {
    this.jdField_a_of_type_Yze.b();
    Object localObject1 = this.jdField_a_of_type_Ywh.a();
    Object localObject2 = ((DoodleLayout)localObject1).a(0);
    Object localObject3 = ((DoodleLayout)localObject1).b(0);
    this.jdField_a_of_type_Yvp.jdField_a_of_type_ArrayOfInt[0] = localObject2[0];
    this.jdField_a_of_type_Yvp.jdField_a_of_type_ArrayOfInt[1] = localObject2[1];
    this.jdField_a_of_type_Yvp.jdField_a_of_type_ArrayOfInt[2] = localObject3[0];
    this.jdField_a_of_type_Yvp.jdField_a_of_type_ArrayOfInt[3] = localObject3[1];
    this.jdField_a_of_type_Yvp.jdField_a_of_type_ArrayOfInt[4] = ((DoodleLayout)localObject1).a().a();
    localObject3 = ((DoodleLayout)localObject1).a();
    localObject2 = a();
    if (localObject2 == null) {
      return;
    }
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      long l = SystemClock.uptimeMillis();
      localObject1 = zoc.c((Bitmap)localObject2, (Bitmap)localObject3);
      yuk.b("Q.qqstory.publish.edit.EditVideoPartManager", "onCropBtnPressed merge ： cost " + (SystemClock.uptimeMillis() - l));
    }
    this.jdField_a_of_type_Yvp.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
    a(11);
  }
  
  void s()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter == null) {
      return;
    }
    a(0);
    a(12);
  }
  
  public void t()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.g();
      u();
    }
    a(0);
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null) {
      ThreadManager.post(new EditVideoPartManager.8(this), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yxt
 * JD-Core Version:    0.7.0.1
 */