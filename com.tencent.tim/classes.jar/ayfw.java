import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tribe.async.async.JobSegment;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.paster.InteractPasterParcelData;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalGifSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.12;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.5;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.7;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.9;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.a;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.b;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

public class ayfw
  extends aygy
  implements aydg, IEventReceiver, DoodleLayout.a, DoodleLayout.b
{
  public static final String azB = plr.atc;
  public static String cWP = "EditVideoDoodle";
  ayfw.a jdField_a_of_type_Ayfw$a;
  ayfw.b jdField_a_of_type_Ayfw$b;
  ayfw.c jdField_a_of_type_Ayfw$c;
  public aykn.e a;
  public ProviderViewEditContainer a;
  protected DoodleLayout a;
  PtvTemplateManager.a jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$a = new ayfz(this);
  private final long aCL;
  private long aCr;
  public boolean aGP;
  public boolean aGQ;
  private ayho b;
  protected Handler bn = new Handler(Looper.getMainLooper());
  public int bpW = 1;
  protected Runnable du = new EditVideoDoodle.7(this);
  private boolean dyY;
  protected boolean mDestroyed;
  protected byte[] mMosaicMask;
  private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener = new aygd(this);
  private ViewStub y;
  
  public ayfw(@NonNull aygz paramaygz, long paramLong)
  {
    super(paramaygz);
    this.jdField_b_of_type_Ayho = new ayfx(this);
    this.jdField_a_of_type_Aykn$e = new ayge(this);
    this.aCL = paramLong;
  }
  
  private void eRx()
  {
    int k;
    int j;
    int i;
    float f;
    if ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Ld()) && (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 14) && (this.jdField_b_of_type_Aygz.a() != null) && (!this.jdField_b_of_type_Aygz.a().isLandTakePicToVideo()) && ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalVideoSource)))
    {
      k = ((EditLocalVideoSource)this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a).d.rotation;
      j = this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getWidth();
      i = this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getHeight();
      if ((k == 90) || (k == 270))
      {
        j = Math.min(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getWidth(), this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getHeight());
        i = Math.max(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getWidth(), this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getHeight());
      }
      f = j / i;
      if (!this.jdField_b_of_type_Aygz.a().getTakePicToVideo()) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.eSA();
      }
      j = ankt.SCREEN_WIDTH;
      i = ankt.cIE;
      if (ankt.bA(getContext())) {
        break label328;
      }
      i = ankt.getRealHeight(getContext());
    }
    for (;;)
    {
      k = (int)(j / f);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = j;
        localLayoutParams.height = k;
        localLayoutParams.addRule(16);
        localLayoutParams.setMargins(0, i / 2 - (int)(j / f) / 2, 0, 0);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setLayoutParams(localLayoutParams);
      }
      return;
      label328:
      i = ankt.cIE;
      if (Build.MODEL.equals("Lenovo L78011")) {
        i -= ayxa.getStatusBarHeight(getContext());
      }
    }
  }
  
  private void rp(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (paramString.isFile())
    {
      bool = paramString.delete();
      ram.w("Q.qqstory.publish.edit.StoryDoodle", "delete file : " + bool);
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      ram.w("Q.qqstory.publish.edit.StoryDoodle", "create folder : " + bool);
    }
  }
  
  private void setVisibility(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        bsC();
      } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getVisibility() == paramInt);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setVisibility(paramInt);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleGLViewVisibility(paramInt);
      return;
    } while ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getVisibility() == paramInt));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setVisibility(paramInt);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleGLViewVisibility(paramInt);
  }
  
  public boolean KS()
  {
    if (System.currentTimeMillis() < this.BK) {}
    while ((!aygz.r(this.aCL, 1)) || (!TextUtils.isEmpty(a().cb(this.jdField_b_of_type_Aygz.tj())))) {
      return false;
    }
    if (this.jdField_b_of_type_Aygz.bqq == 28) {
      this.jdField_b_of_type_Aygz.changeState(0);
    }
    return true;
  }
  
  public boolean La()
  {
    return this.jdField_b_of_type_Aygz.La();
  }
  
  public void M(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a().N(paramInt1, paramInt2, paramBoolean);
    if ((!paramBoolean) && (this.jdField_b_of_type_Aygz.bQ != null))
    {
      Bundle localBundle = this.jdField_b_of_type_Aygz.bQ.getBundle(ayjn.TAG);
      if (localBundle != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().eC(localBundle);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().eC(this.jdField_b_of_type_Aygz.bQ.getBundle("DynamicFaceLayer"));
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a() != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().eC(this.jdField_b_of_type_Aygz.bQ.getBundle(ayjw.TAG));
      }
    }
  }
  
  public void S(byte[] paramArrayOfByte)
  {
    if (!this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.La())
    {
      this.mMosaicMask = paramArrayOfByte;
      VideoSourceHelper.nativeSetMosaic(16, this.mMosaicMask);
      ayhm localayhm = (ayhm)a(ayhm.class);
      if (localayhm != null) {
        localayhm.h(16, paramArrayOfByte);
      }
    }
  }
  
  public Bitmap U()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return null;
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.U();
  }
  
  public Bitmap W()
  {
    return this.jdField_b_of_type_Aygz.W();
  }
  
  public Bitmap a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return null;
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramInt, paramBoolean);
  }
  
  public JobSegment<ayqb, ayqb> a(int paramInt)
  {
    if (((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakeVideoSource)) || ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalVideoSource))) {
      return (JobSegment)ppf.a(ayqm.class, new Object[] { this, (aydh)a(aydh.class), Integer.valueOf(paramInt) });
    }
    return (JobSegment)ppf.a(ayqc.class, new Object[] { this, (aydh)a(aydh.class), Integer.valueOf(paramInt) });
  }
  
  @NonNull
  public DoodleLayout a()
  {
    bsC();
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    super.a(paramInt, paramayqb);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      ram.w("Q.qqstory.publish.edit.StoryDoodle", "editVideoPrePublish but doodle layout is null");
      return;
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.bue();
    }
    paramayqb.g.videoDoodleDescription = a().cb(paramInt);
    this.jdField_b_of_type_Aygz.a().setWordId(a().Iu());
    this.jdField_b_of_type_Aygz.a().setStickerId(a().Iv());
    paramayqb.g.putExtra("all_doodle_text", a().It());
    paramayqb.g.mMosaicMask = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.f(paramInt);
    paramayqb.g.mMosaicSize = 16;
    if (a().B(paramInt).size() > 0)
    {
      localObject1 = (axsu)axov.a(4);
      paramayqb.g.videoLocationDescription = ((axsu)localObject1).If();
    }
    label281:
    label338:
    int i;
    label397:
    Object localObject3;
    int j;
    if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Ld())
    {
      if ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalVideoSource))
      {
        paramayqb.g.videoLongitude = ((EditLocalVideoSource)this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a).d.longitude;
        paramayqb.g.videoLatitude = ((EditLocalVideoSource)this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a).d.latitude;
      }
    }
    else
    {
      if (a().eR(paramInt))
      {
        localObject2 = this.jdField_b_of_type_Aygz;
        if (!this.jdField_b_of_type_Aygz.La()) {
          break label960;
        }
        localObject1 = "2";
        ((aygz)localObject2).c("change_graffiti", 0, 0, new String[] { localObject1 });
        ras.so("0X80076C0");
      }
      if (a().eQ(paramInt))
      {
        localObject2 = this.jdField_b_of_type_Aygz;
        if (!this.jdField_b_of_type_Aygz.La()) {
          break label968;
        }
        localObject1 = "2";
        ((aygz)localObject2).c("change_color", 0, 0, new String[] { localObject1 });
        ras.so("0X80076C4");
      }
      if ((!(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakePhotoSource)) && (!(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalPhotoSource))) {
        break label976;
      }
      i = 1;
      localObject2 = a().g(paramInt);
      if ((localObject2 != null) && (localObject2.length == 2))
      {
        if (localObject2[0] <= 0) {
          break label989;
        }
        localObject3 = this.jdField_b_of_type_Aygz;
        j = this.jdField_b_of_type_Aygz.tk();
        if (!this.jdField_b_of_type_Aygz.La()) {
          break label981;
        }
        localObject1 = "2";
        label456:
        ((aygz)localObject3).d("pub_graffiti", j, 0, new String[] { "1", "", localObject1 });
        ras.bv("0X80076E0", ras.bpq);
        ras.bw("0X80075EA", ras.bpo);
        paramayqb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
        paramayqb.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasGraffiti = true;
        label528:
        if (localObject2[1] <= 0) {
          break label1020;
        }
        localObject3 = this.jdField_b_of_type_Aygz;
        j = this.jdField_b_of_type_Aygz.tk();
        if (!this.jdField_b_of_type_Aygz.La()) {
          break label1012;
        }
        localObject1 = "2";
        label565:
        ((aygz)localObject3).d("pub_mosaics", j, 0, new String[] { "1", "", localObject1 });
        ras.so("0X80076E1");
        ras.sp("0X80075EB");
        paramayqb.aIB = true;
        if (localObject2[0] == 0) {
          paramayqb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
        }
      }
    }
    Object localObject5;
    Object localObject6;
    for (;;)
    {
      localObject2 = a().h(paramInt);
      if ((localObject2 == null) || (localObject2.length != 2)) {
        break label1395;
      }
      localObject4 = a().b(paramInt);
      localObject1 = a().B(paramInt);
      localObject3 = new StringBuilder();
      localObject4 = ((Map)localObject4).entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (Map.Entry)((Iterator)localObject4).next();
        localObject6 = (List)((Map.Entry)localObject5).getValue();
        if ((localObject6 != null) && (((List)localObject6).size() > 0))
        {
          localObject5 = (String)((Map.Entry)localObject5).getKey();
          localObject6 = ((List)localObject6).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            String str = (String)((Iterator)localObject6).next();
            ((StringBuilder)localObject3).append((String)localObject5).append(':').append(str).append(',');
          }
        }
      }
      if ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalPhotoSource))
      {
        paramayqb.g.videoLongitude = ((EditLocalPhotoSource)this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a).d.longitude;
        paramayqb.g.videoLatitude = ((EditLocalPhotoSource)this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a).d.latitude;
        break;
      }
      if (!(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalGifSource)) {
        break;
      }
      paramayqb.g.videoLongitude = ((EditLocalGifSource)this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a).d.longitude;
      paramayqb.g.videoLatitude = ((EditLocalGifSource)this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a).d.latitude;
      break;
      label960:
      localObject1 = "1";
      break label281;
      label968:
      localObject1 = "1";
      break label338;
      label976:
      i = 0;
      break label397;
      label981:
      localObject1 = "1";
      break label456;
      label989:
      if ((i == 0) || (!ayqh.eV(0))) {
        break label528;
      }
      ras.bw("0X80075EA", ras.bpo);
      break label528;
      label1012:
      localObject1 = "1";
      break label565;
      label1020:
      if ((i != 0) && (ayqh.eV(1))) {
        ras.sp("0X80075EB");
      }
    }
    if (((StringBuilder)localObject3).length() > 0) {
      ((StringBuilder)localObject3).deleteCharAt(((StringBuilder)localObject3).length() - 1);
    }
    ram.b("Q.qqstory.publish.edit.StoryDoodle", "faceReportString = %s", localObject3);
    Object localObject4 = new StringBuilder();
    if (((List)localObject1).size() > 0)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((StringBuilder)localObject4).append(((ayjn.b)((Iterator)localObject1).next()).name).append(',');
      }
      ((StringBuilder)localObject4).deleteCharAt(((StringBuilder)localObject4).length() - 1);
    }
    ram.b("Q.qqstory.publish.edit.StoryDoodle", "poiReportString = %s", localObject4);
    if (localObject2[0] > 0)
    {
      localObject5 = this.jdField_b_of_type_Aygz;
      j = this.jdField_b_of_type_Aygz.tk();
      int k = localObject2[0];
      localObject6 = ((StringBuilder)localObject3).toString();
      if (this.jdField_b_of_type_Aygz.La())
      {
        localObject1 = "2";
        ((aygz)localObject5).d("pub_face", j, 0, new String[] { String.valueOf(k), localObject6, localObject1 });
        ras.bv("0X80076E3", ras.bpq);
        ras.bw("0X80075ED", ras.bpo);
        paramayqb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
        paramayqb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject3).toString();
        label1288:
        if (localObject2[1] <= 0) {
          break label1701;
        }
        this.jdField_b_of_type_Aygz.d("pub_poi", this.jdField_b_of_type_Aygz.tk(), 0, new String[] { String.valueOf(localObject2[1]), ((StringBuilder)localObject4).toString() });
        ras.so("0X80076E4");
        ras.sp("0X80075EE");
        if (localObject2[0] <= 0) {
          break label1672;
        }
        paramayqb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = (paramayqb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 + "," + ((StringBuilder)localObject4).toString());
        label1395:
        localObject2 = a().cb(paramInt);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1721;
        }
        j = 1;
        label1416:
        if (j == 0) {
          break label1735;
        }
        localObject3 = this.jdField_b_of_type_Aygz;
        i = this.jdField_b_of_type_Aygz.tk();
        if (!this.jdField_b_of_type_Aygz.La()) {
          break label1727;
        }
        localObject1 = "2";
        label1450:
        ((aygz)localObject3).d("pub_text", i, 0, new String[] { "1", localObject2, localObject1 });
        ras.bv("0X80076E2", ras.bpq);
        ras.bw("0X80075EC", ras.bpo);
        paramayqb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("3");
        paramayqb.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasText = true;
      }
    }
    for (;;)
    {
      localObject3 = a().A(paramInt);
      if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
        break label1785;
      }
      localObject1 = "";
      paramInt = 0;
      while (paramInt < ((List)localObject3).size())
      {
        localObject2 = (String)localObject1 + (String)((List)localObject3).get(paramInt);
        localObject1 = localObject2;
        if (paramInt != ((List)localObject3).size() - 1) {
          localObject1 = (String)localObject2 + ",";
        }
        paramInt += 1;
      }
      localObject1 = "1";
      break;
      if ((i == 0) || (!ayqh.eV(2))) {
        break label1288;
      }
      ras.bw("0X80075ED", ras.bpo);
      break label1288;
      label1672:
      paramayqb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
      paramayqb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject4).toString();
      break label1395;
      label1701:
      if ((i == 0) || (!ayqh.eV(3))) {
        break label1395;
      }
      ras.sp("0X80075EE");
      break label1395;
      label1721:
      j = 0;
      break label1416;
      label1727:
      localObject1 = "1";
      break label1450;
      label1735:
      if ((i != 0) && (ayqh.eV(4))) {
        ras.bw("0X80075EC", ras.bpo);
      }
    }
    this.jdField_b_of_type_Aygz.d("person_gra", this.jdField_b_of_type_Aygz.tk(), 0, new String[] { localObject1 });
    label1785:
    Object localObject2 = axol.getAppInterface().getCurrentAccountUin();
    if (ayna.dAa) {}
    for (Object localObject1 = paramayqb.g.videoLocationDescription;; localObject1 = "")
    {
      ShortVideoUtils.hp((String)localObject2, (String)localObject1);
      if (((a().a() == null) || (a().a().oJ == null) || (a().a().oJ.size() <= 0)) && ((a().a() == null) || (a().a().oJ == null) || (a().a().oJ.size() <= 0))) {
        break;
      }
      paramayqb.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasFace = true;
      return;
    }
  }
  
  public void a(aynd.a parama)
  {
    if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 1) {
      ((psr)psx.a(10)).n("has_show_add_poi_paster_guide", Boolean.valueOf(true));
    }
    boolean bool = this.jdField_b_of_type_Aygz.eP(6);
    if (this.jdField_b_of_type_Aygz.La())
    {
      parama = "2";
      if (!bool) {
        break label107;
      }
    }
    label107:
    for (String str = "1";; str = "0")
    {
      rar.a("video_edit", "add_place", 0, 0, new String[] { parama, "", str, "" });
      return;
      parama = "1";
      break;
    }
  }
  
  public void asq()
  {
    this.jdField_b_of_type_Aygz.a(true, 0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  public void aw(Map<Long, TrackerStickerParam.MotionInfo> paramMap)
  {
    a().aw(paramMap);
  }
  
  public void brZ()
  {
    if (this.aGQ) {
      a().brZ();
    }
  }
  
  public void bsC()
  {
    Object localObject1;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      ram.d("Q.qqstory.publish.edit.StoryDoodle", "makeSureInitLayout");
      localObject1 = this.y.getParent();
      if ((localObject1 == null) || (!(localObject1 instanceof ViewGroup))) {
        break label741;
      }
    }
    label741:
    for (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)this.y.inflate());; this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)y(2131366036)))
    {
      if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.entryType == axcg.c.getId()) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.dzQ = true;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
      if (!aygz.r(this.aCL, 1)) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.bul();
      }
      this.aGQ = true;
      eRx();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.eSd();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setupPersonality();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(720, 1280);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicSize(16);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicStandardSize(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getWidth(), this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.getHeight());
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleEventListener(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBtnOperationHelper(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditVideoParams(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditVideoDoodle(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.eSL();
      if (this.jdField_b_of_type_Aygz.bQ != null)
      {
        if (this.jdField_b_of_type_Aygz.bQ.getBundle(ayjn.TAG) != null) {
          this.jdField_b_of_type_Aygz.bQ.getBundle(ayjn.TAG).putBoolean("edit_type_photo", this.jdField_b_of_type_Aygz.La());
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().eC(this.jdField_b_of_type_Aygz.bQ.getBundle(ayjn.TAG));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().eC(this.jdField_b_of_type_Aygz.bQ.getBundle("DynamicFaceLayer"));
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a() != null)
        {
          if (this.jdField_b_of_type_Aygz.bQ.getBundle(ayjw.TAG) != null) {
            this.jdField_b_of_type_Aygz.bQ.getBundle(ayjw.TAG).putBoolean("edit_type_photo", this.jdField_b_of_type_Aygz.La());
          }
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().eC(this.jdField_b_of_type_Aygz.bQ.getBundle(ayjw.TAG));
        }
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a() != null)
        {
          localObject1 = this.jdField_b_of_type_Aygz.bQ.getBundle("VoteLayer");
          if (localObject1 != null)
          {
            localObject1 = (InteractPasterParcelData)((Bundle)localObject1).getParcelable("vote_paster");
            localObject2 = (aydl)this.jdField_b_of_type_Aygz.a(aydl.class);
            if (localObject2 != null) {
              ((aydl)localObject2).a((InteractPasterParcelData)localObject1);
            }
          }
        }
      }
      axvy.a().a(this.jdField_b_of_type_Aygz.RP(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
      localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView;
      if (localObject1 != null)
      {
        ((DoodleEditView)localObject1).setFrom(1);
        ((DoodleEditView)localObject1).ZC(aygz.r(this.aCL, 134217728));
      }
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer == null)
      {
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer = this.jdField_b_of_type_Aygz.jdField_a_of_type_Ayeh.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer;
        if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
          this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setLiuHaiParentView(this.jdField_b_of_type_Aygz.ok);
        }
        if ((localObject1 != null) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null))
        {
          int i = 0;
          if ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalVideoSource)) {
            i = ((EditLocalVideoSource)this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a).startTime;
          }
          this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setVideoSegmentPickerListener(new ayga(this, i));
          this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setStickerListener(((DoodleEditView)localObject1).a());
          ((DoodleEditView)localObject1).setDoodleEditViewListener(new aygb(this));
        }
        y(2131366228).setOnTouchListener(new aygc(this));
      }
      localObject1 = pmi.a();
      Object localObject2 = new ayfw.b(this);
      this.jdField_a_of_type_Ayfw$b = ((ayfw.b)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      localObject1 = pmi.a();
      localObject2 = new ayfw.a(this);
      this.jdField_a_of_type_Ayfw$a = ((ayfw.a)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      localObject1 = pmi.a();
      localObject2 = new ayfw.c(this);
      this.jdField_a_of_type_Ayfw$c = ((ayfw.c)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      return;
    }
  }
  
  public void bsE()
  {
    this.jdField_a_of_type_Ayii.getRootView().postDelayed(new EditVideoDoodle.9(this), 200L);
  }
  
  public void bsF()
  {
    this.jdField_b_of_type_Aygz.bsF();
  }
  
  public void bsa()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {}
  }
  
  public void c(Animation paramAnimation)
  {
    this.jdField_b_of_type_Aygz.e(paramAnimation);
  }
  
  public void close()
  {
    this.jdField_b_of_type_Aygz.bsV();
  }
  
  public void cm(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.cm(paramJSONObject);
  }
  
  public void d(int paramInt1, int paramInt2, Object paramObject)
  {
    this.dyY = false;
    switch (paramInt2)
    {
    case 8: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 25: 
    case 26: 
    case 27: 
    case 31: 
    case 32: 
    case 35: 
    case 37: 
    case 38: 
    case 39: 
    case 43: 
    case 45: 
    default: 
      setVisibility(0);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              setVisibility(4);
              return;
              setVisibility(0);
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.resetUI();
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.ZD(true);
              return;
              setVisibility(0);
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.resetUI();
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.Zs(false);
              return;
            } while ((paramInt1 == 9) || (paramInt1 == paramInt2));
            bsC();
            setVisibility(0);
            return;
          } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null);
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.resetUI();
          return;
          setVisibility(8);
          return;
          if (paramInt1 != 9)
          {
            bsC();
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.buh();
            setVisibility(0);
          }
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.ZD(true);
          return;
        } while (paramInt1 == 8);
        bsC();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.bui();
        setVisibility(0);
        return;
      } while (paramInt1 != 36);
      this.dyY = true;
      return;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.Zs(true);
    } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.resetUI();
  }
  
  public void d(Bitmap paramBitmap, boolean paramBoolean)
  {
    ayhm localayhm = (ayhm)a(ayhm.class);
    if (localayhm != null) {
      localayhm.c(paramBitmap, paramBoolean);
    }
  }
  
  public void d(Animation paramAnimation)
  {
    this.jdField_b_of_type_Aygz.f(paramAnimation);
  }
  
  public void e(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    a().a(acfp.m(2131705547), true, 0L, new ayfy(this));
    this.jdField_b_of_type_Aygz.f(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  protected boolean e(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.e(paramMessage);
    case 6: 
      setVisibility(0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.xp(this.jdField_b_of_type_Aygz.tj());
      switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getCurrentState())
      {
      }
      for (;;)
      {
        return true;
        this.jdField_b_of_type_Aygz.changeState(0);
      }
    case 11: 
      this.BK = ((Long)paramMessage.obj).longValue();
      return true;
    }
    paramMessage = (Long[])paramMessage.obj;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTimeStamp(paramMessage[0].longValue(), false);
    }
    return true;
  }
  
  public void eNv()
  {
    if (this.dyY)
    {
      this.dyY = false;
      return;
    }
    this.jdField_b_of_type_Aygz.changeState(0);
  }
  
  public void eNw()
  {
    a().bpm();
  }
  
  public void eRy()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null)) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.bue();
    }
  }
  
  public void eb(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    long l;
    do
    {
      return;
      l = SystemClock.elapsedRealtime();
    } while (l - this.aCr <= 4000L);
    this.bn.post(new EditVideoDoodle.12(this));
    this.aCr = l;
  }
  
  public int ed(int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return 0;
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.ed(paramInt);
  }
  
  public byte[] f(int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.f(paramInt);
    }
    return null;
  }
  
  public void h(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_b_of_type_Aygz.a(false, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public boolean isEmpty()
  {
    return (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.isEmpty());
  }
  
  public void ol(long paramLong)
  {
    a().setFaceLayerPosition(paramLong);
  }
  
  public boolean onBackPressed()
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.aOc())) {
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.aQP()))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.s(7, null);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.ZD(false);
      return true;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getVisibility() == 0)) {}
    switch (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getCurrentState())
    {
    case 4: 
    case 5: 
    default: 
      return false;
    case 1: 
    case 2: 
    case 3: 
      this.jdField_b_of_type_Aygz.changeState(0);
      return true;
    case 0: 
      return false;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.aUp();
    return true;
  }
  
  public void onCreate()
  {
    rp(azB);
    this.y = ((ViewStub)y(2131366037));
    QQStoryContext.a();
    AppInterface localAppInterface = QQStoryContext.c();
    PtvTemplateManager.a(localAppInterface).a(localAppInterface, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$a, false);
    ThreadManager.excute(new EditVideoDoodle.5(this), 64, null, true);
    a(aydg.class, this);
  }
  
  public void onDestroy()
  {
    this.mDestroyed = true;
    if (this.jdField_a_of_type_Ayfw$b != null) {
      pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Ayfw$b);
    }
    if (this.jdField_a_of_type_Ayfw$a != null) {
      pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Ayfw$a);
    }
    if (this.jdField_a_of_type_Ayfw$c != null) {
      pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Ayfw$c);
    }
    this.bn.removeCallbacks(this.du);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setVideoSegmentPickerListener(null);
    }
    axvy.a().aeL(this.jdField_b_of_type_Aygz.RP());
  }
  
  public void onPause()
  {
    super.onPause();
    NativeGifImage.pauseAll();
    ApngImage.pauseByTag(13);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Lb())
    {
      NativeGifImage.resumeAll();
      ApngImage.playByTag(13);
      return;
    }
    NativeGifImage.pauseAll();
    ApngImage.pauseByTag(13);
  }
  
  public void q(int paramInt, Object paramObject)
  {
    ram.d("Q.qqstory.publish.edit.StoryDoodle", "onStateChanged : " + paramInt);
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.mDestroyed)) {
      return;
    }
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
    case 7: 
      if ((this.jdField_b_of_type_Aygz.eO(13)) || (this.jdField_b_of_type_Aygz.eO(14)) || (this.jdField_b_of_type_Aygz.eO(15)) || (this.jdField_b_of_type_Aygz.eO(16)))
      {
        ram.w("Q.qqstory.publish.edit.StoryDoodle", "do nothing because edit ui is showing the guide");
        return;
      }
      if (this.dyY)
      {
        this.jdField_b_of_type_Aygz.changeState(36);
        return;
      }
      this.jdField_b_of_type_Aygz.changeState(0);
      return;
    case 2: 
      this.jdField_b_of_type_Aygz.r(7, paramObject);
      return;
    case 3: 
      this.jdField_b_of_type_Aygz.r(5, paramObject);
      return;
    case 4: 
      this.jdField_b_of_type_Aygz.changeState(9);
      return;
    case 5: 
      this.jdField_b_of_type_Aygz.r(8, paramObject);
      return;
    }
    this.jdField_b_of_type_Aygz.changeState(8);
  }
  
  public void s(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.s(paramBitmap);
    }
  }
  
  public void ss(String paramString)
  {
    aygz localaygz = this.jdField_b_of_type_Aygz;
    if (this.jdField_b_of_type_Aygz.La()) {}
    for (String str = "2";; str = "1")
    {
      localaygz.c("exp_editpoi", 0, 0, new String[] { str });
      ras.so("0X80076CF");
      ras.sp("0X80075E4");
      paramString = new ayfw.e(this.jdField_b_of_type_Ayho, paramString);
      this.jdField_b_of_type_Aygz.r(3, paramString);
      return;
    }
  }
  
  public int ta()
  {
    return 16;
  }
  
  public int tb()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return 0;
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.ts();
  }
  
  public boolean y(int paramInt)
  {
    return (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.y(paramInt));
  }
  
  static class a
    extends QQUIEventReceiver<ayfw, aykn.a>
  {
    public a(@NonNull ayfw paramayfw)
    {
      super();
    }
    
    public void a(@NonNull ayfw paramayfw, @NonNull aykn.a parama) {}
    
    public Class acceptEventClass()
    {
      return aykn.a.class;
    }
  }
  
  static class b
    extends QQUIEventReceiver<ayfw, aykn.b>
  {
    public b(@NonNull ayfw paramayfw)
    {
      super();
    }
    
    public void a(@NonNull ayfw paramayfw, @NonNull aykn.b paramb) {}
    
    public Class acceptEventClass()
    {
      return aykn.b.class;
    }
  }
  
  static class c
    extends QQUIEventReceiver<ayfw, aykn.c>
  {
    public c(@NonNull ayfw paramayfw)
    {
      super();
    }
    
    public void a(@NonNull ayfw paramayfw, @NonNull aykn.c paramc) {}
    
    public Class acceptEventClass()
    {
      return aykn.c.class;
    }
  }
  
  public static class d
    extends aynj
  {
    private final List<aymz> Nw = new ArrayList();
    private final ConcurrentLinkedQueue<aymz> Y = new ConcurrentLinkedQueue();
    private boolean dyZ = true;
    
    public void Zm(boolean paramBoolean)
    {
      this.dyZ = paramBoolean;
    }
    
    public aymz a(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.Nw.size())) {
        return (aymz)this.Nw.get(paramInt);
      }
      return null;
    }
    
    public void a(aymz paramaymz)
    {
      ram.d("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + paramaymz);
      int i = this.Nw.indexOf(paramaymz);
      if (i >= 0)
      {
        this.Nw.set(i, paramaymz);
        xA(i);
      }
    }
    
    public boolean aQw()
    {
      return this.dyZ;
    }
    
    public aymz b(String paramString)
    {
      if (this.Y.isEmpty()) {
        e(((axsu)axov.a(4)).hU());
      }
      Iterator localIterator = this.Y.iterator();
      while (localIterator.hasNext())
      {
        aymz localaymz = (aymz)localIterator.next();
        if ((localaymz != null) && (TextUtils.equals(paramString, localaymz.id))) {
          return localaymz;
        }
      }
      return null;
    }
    
    public void e(Collection<aymz> paramCollection)
    {
      ram.d("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
      try
      {
        this.Y.clear();
        this.Nw.clear();
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext())
        {
          aymz localaymz = (aymz)paramCollection.next();
          if (localaymz != null)
          {
            this.Y.add(localaymz);
            if (localaymz.hide == 0) {
              this.Nw.add(localaymz);
            }
          }
        }
      }
      finally {}
      buP();
    }
    
    public int getCount()
    {
      return this.Nw.size();
    }
  }
  
  public static class e
  {
    public final ayho c;
    public final String location;
    
    public e(ayho paramayho, String paramString)
    {
      this.c = paramayho;
      this.location = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayfw
 * JD-Core Version:    0.7.0.1
 */