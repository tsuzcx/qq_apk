import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoDoodle.4;
import com.tencent.biz.qqstory.takevideo.EditVideoDoodle.7;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.async.JobSegment;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class wzb
  extends xal
  implements IEventReceiver, wxs, xgo, xgp
{
  public static final String a;
  public int a;
  protected Handler a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  azcv jdField_a_of_type_Azcv = new wzh(this);
  protected DoodleLayout a;
  protected Runnable a;
  wzi jdField_a_of_type_Wzi;
  wzj jdField_a_of_type_Wzj;
  wzk jdField_a_of_type_Wzk;
  protected wzl a;
  private xbf jdField_a_of_type_Xbf = new wzc(this);
  public xfg a;
  private xhq jdField_a_of_type_Xhq = new wzg(this);
  protected xhu a;
  public boolean a;
  protected byte[] a;
  private final int b;
  public boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = ulg.e;
  }
  
  public wzb(@NonNull xan paramxan, int paramInt)
  {
    super(paramxan);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRunnable = new EditVideoDoodle.4(this);
    this.jdField_a_of_type_Xfg = new wzf(this);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        j();
      } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getVisibility() == paramInt);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setVisibility(paramInt);
      this.jdField_a_of_type_Wzl.a(a());
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleGLViewVisibility(paramInt);
      return;
    } while ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getVisibility() == paramInt));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setVisibility(paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleGLViewVisibility(paramInt);
  }
  
  private void b(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (paramString.isFile())
    {
      bool = paramString.delete();
      wxe.d("Q.qqstory.publish.edit.StoryDoodle", "delete file : " + bool);
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      wxe.d("Q.qqstory.publish.edit.StoryDoodle", "create folder : " + bool);
    }
  }
  
  private void j()
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      wxe.b("Q.qqstory.publish.edit.StoryDoodle", "makeSureInitLayout");
      localObject1 = this.jdField_a_of_type_AndroidViewViewStub.getParent();
      if ((localObject1 == null) || (!(localObject1 instanceof ViewGroup))) {
        break label459;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
      if (!xan.a(this.jdField_b_of_type_Int, 4)) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.i();
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(720, 1280);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setDownloadListener(this.jdField_a_of_type_Xhq);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setAdapter(this.jdField_a_of_type_Wzl);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicSize(16);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicStandardSize(this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleEventListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBtnOperationHelper(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditVideoParams(this.jdField_a_of_type_Xan.a);
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a;
      if (localObject1 != null) {
        ((DoodleEditView)localObject1).setDoodleEditViewListener(new wzd(this));
      }
      if ((this.jdField_a_of_type_Xan.a.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Xan.a.jdField_a_of_type_Int == 12))
      {
        if (!(this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
          break label476;
        }
        int i = xsv.b(this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
        if ((i == 270) || (i == 90))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(1280, this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() * 1280 / this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((int)bdgk.k(), (int)(bdgk.k() * this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() / this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b()));
        }
      }
    }
    for (;;)
    {
      localObject1 = umc.a();
      Object localObject2 = new wzj(this);
      this.jdField_a_of_type_Wzj = ((wzj)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      localObject1 = umc.a();
      localObject2 = new wzi(this);
      this.jdField_a_of_type_Wzi = ((wzi)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      localObject1 = umc.a();
      localObject2 = new wzk(this);
      this.jdField_a_of_type_Wzk = ((wzk)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      return;
      label459:
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)a(2131365398));
      break;
      label476:
      if ((this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        localObject1 = (EditLocalVideoSource)this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        if ((((EditLocalVideoSource)localObject1).a() * 1.0F / ((EditLocalVideoSource)localObject1).b() >= (float)bdgk.k() * 1.0F / (float)bdgk.l()) && (((EditLocalVideoSource)localObject1).a.rotation == 0))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(1280, this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() * 1280 / this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((int)bdgk.k(), (int)(bdgk.k() * this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() / this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a()));
        }
        else if ((((EditLocalVideoSource)localObject1).a() * 1.0F / ((EditLocalVideoSource)localObject1).b() < 1.0F) && ((((EditLocalVideoSource)localObject1).a.rotation == 90) || (((EditLocalVideoSource)localObject1).a.rotation == 270)))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(1280, this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() * 1280 / this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((int)bdgk.k(), (int)(bdgk.k() * this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() / this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b()));
        }
      }
    }
  }
  
  private void k()
  {
    new axpt(this.jdField_a_of_type_Xby.getActivity(), new wze(this)).a();
  }
  
  public int a()
  {
    return 16;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramInt);
  }
  
  public Bitmap a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
  }
  
  public Bitmap a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b(paramInt);
  }
  
  @NonNull
  public DoodleLayout a()
  {
    j();
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  }
  
  public JobSegment<xlb, xlb> a(int paramInt)
  {
    if (((this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))) {
      return new xll(this, (wxt)a(wxt.class), paramInt);
    }
    return new xlc(this, (wxt)a(wxt.class), paramInt);
  }
  
  @NonNull
  protected Collection<xhr> a()
  {
    Object localObject = ((xet)uwa.a(8)).a();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      xes localxes = (xes)((Iterator)localObject).next();
      wxe.b("Q.qqstory.publish.edit.StoryDoodle", "add doodle emoji item = " + localxes);
      if (localxes.jdField_a_of_type_Int == 1)
      {
        xhx localxhx = new xhx(localxes.jdField_a_of_type_JavaLangString);
        localxhx.b = localxes.d;
        localxhx.c = localxes.b;
        localxhx.d = localxes.c;
        localxhx.f = localxes.a();
        localxhx.a(localxes.f);
        if (("1".equals(localxhx.jdField_a_of_type_JavaLangString)) && (!bdin.g(a()))) {
          localxhx.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getDrawable(2130846011);
        }
        localArrayList.add(localxhx);
      }
      else if (localxes.jdField_a_of_type_Int == 2)
      {
        if ((!TextUtils.isEmpty(localxes.b)) && (bdin.g(a()))) {
          this.jdField_a_of_type_Xhu.c = localxes.b;
        }
        for (;;)
        {
          localArrayList.add(this.jdField_a_of_type_Xhu);
          break;
          this.jdField_a_of_type_Xhu.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getDrawable(2130846154);
        }
      }
    }
    wxe.b("Q.qqstory.publish.edit.StoryDoodle", "getDoodleFacePackages, size = " + localArrayList.size());
    return localArrayList;
  }
  
  public void a()
  {
    b(jdField_a_of_type_JavaLangString);
    QQStoryContext.a();
    Object localObject1 = QQStoryContext.a();
    PtvTemplateManager.a((AppInterface)localObject1).a((AppInterface)localObject1, this.jdField_a_of_type_Azcv, false);
    Object localObject2 = (xet)uwa.a(8);
    ((xet)localObject2).a(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131365399));
    this.jdField_a_of_type_Wzl = new wzl(null);
    if (this.jdField_a_of_type_Xhu == null)
    {
      this.jdField_a_of_type_Xhu = new xhu("Location-Package");
      this.jdField_a_of_type_Xhu.jdField_a_of_type_Boolean = true;
      localObject1 = xet.c((xet)localObject2, "0");
      localObject2 = xet.a((xet)localObject2, "0");
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!bdin.g(a()))) {
        break label156;
      }
      this.jdField_a_of_type_Xhu.c = ((String)localObject2);
    }
    for (;;)
    {
      this.jdField_a_of_type_Xhu.a((String)localObject1);
      a(wxs.class, this);
      return;
      label156:
      this.jdField_a_of_type_Xhu.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getDrawable(2130846154);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a().a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    switch (paramInt2)
    {
    case 8: 
    case 9: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    default: 
      a(0);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            a(4);
            return;
            a(0);
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.f();
            return;
            a(0);
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.f();
            return;
          } while (paramInt1 == 9);
          j();
          if ((paramObject != null) && (paramObject == Boolean.TRUE)) {
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b(2);
          }
          for (;;)
          {
            a(0);
            return;
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b(1);
          }
        } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.f();
        return;
        a(8);
        return;
      } while (paramInt1 == 9);
      k();
      j();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.d();
      a(0);
      return;
    } while (paramInt1 == 8);
    j();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e();
    a(0);
  }
  
  public void a(int paramInt, @NonNull xlb paramxlb)
  {
    super.a(paramInt, paramxlb);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      wxe.d("Q.qqstory.publish.edit.StoryDoodle", "editVideoPrePublish but doodle layout is null");
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.c();
    paramxlb.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription = a().a(paramInt);
    paramxlb.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mMosaicMask = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramInt);
    paramxlb.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mMosaicSize = 16;
    Object localObject1 = a().b(paramInt);
    if (((List)localObject1).size() == 1) {
      paramxlb.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLocationDescription = ((xdo)((List)localObject1).get(0)).a();
    }
    Object localObject2;
    label202:
    int i;
    label261:
    Object localObject3;
    int j;
    if (a().b(paramInt))
    {
      localObject2 = this.jdField_a_of_type_Xan;
      if (this.jdField_a_of_type_Xan.a())
      {
        localObject1 = "2";
        ((xan)localObject2).a("change_graffiti", 0, 0, new String[] { localObject1 });
        wxk.a("0X80076C0");
      }
    }
    else
    {
      if (a().a(paramInt))
      {
        localObject2 = this.jdField_a_of_type_Xan;
        if (!this.jdField_a_of_type_Xan.a()) {
          break label690;
        }
        localObject1 = "2";
        ((xan)localObject2).a("change_color", 0, 0, new String[] { localObject1 });
        wxk.a("0X80076C4");
      }
      if ((!(this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) && (!(this.jdField_a_of_type_Xan.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))) {
        break label698;
      }
      i = 1;
      localObject2 = a().a(paramInt);
      if ((localObject2 != null) && (localObject2.length == 2))
      {
        if (localObject2[0] <= 0) {
          break label711;
        }
        localObject3 = this.jdField_a_of_type_Xan;
        j = this.jdField_a_of_type_Xan.b();
        if (!this.jdField_a_of_type_Xan.a()) {
          break label703;
        }
        localObject1 = "2";
        label320:
        ((xan)localObject3).b("pub_graffiti", j, 0, new String[] { "1", "", localObject1 });
        wxk.a("0X80076E0", wxk.jdField_b_of_type_Int);
        wxk.b("0X80075EA", wxk.jdField_a_of_type_Int);
        paramxlb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
        paramxlb.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasGraffiti = true;
        label392:
        if (localObject2[1] <= 0) {
          break label742;
        }
        localObject3 = this.jdField_a_of_type_Xan;
        j = this.jdField_a_of_type_Xan.b();
        if (!this.jdField_a_of_type_Xan.a()) {
          break label734;
        }
        localObject1 = "2";
        label429:
        ((xan)localObject3).b("pub_mosaics", j, 0, new String[] { "1", "", localObject1 });
        wxk.a("0X80076E1");
        wxk.b("0X80075EB");
        paramxlb.jdField_b_of_type_Boolean = true;
        if (localObject2[0] == 0) {
          paramxlb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
        }
      }
    }
    Object localObject5;
    Object localObject6;
    for (;;)
    {
      localObject2 = a().b(paramInt);
      if ((localObject2 == null) || (localObject2.length != 2)) {
        break label1130;
      }
      localObject4 = a().a(paramInt);
      localObject1 = a().b(paramInt);
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
      localObject1 = "1";
      break;
      label690:
      localObject1 = "1";
      break label202;
      label698:
      i = 0;
      break label261;
      label703:
      localObject1 = "1";
      break label320;
      label711:
      if ((i == 0) || (!xlf.a(0))) {
        break label392;
      }
      wxk.b("0X80075EA", wxk.jdField_a_of_type_Int);
      break label392;
      label734:
      localObject1 = "1";
      break label429;
      label742:
      if ((i != 0) && (xlf.a(1))) {
        wxk.b("0X80075EB");
      }
    }
    if (((StringBuilder)localObject3).length() > 0) {
      ((StringBuilder)localObject3).deleteCharAt(((StringBuilder)localObject3).length() - 1);
    }
    wxe.a("Q.qqstory.publish.edit.StoryDoodle", "faceReportString = %s", localObject3);
    Object localObject4 = new StringBuilder();
    if (((List)localObject1).size() > 0)
    {
      localObject5 = ((List)localObject1).iterator();
      while (((Iterator)localObject5).hasNext()) {
        ((StringBuilder)localObject4).append(((xdo)((Iterator)localObject5).next()).e).append(',');
      }
      ((StringBuilder)localObject4).deleteCharAt(((StringBuilder)localObject4).length() - 1);
      ((xdo)((List)localObject1).get(0)).a();
    }
    wxe.a("Q.qqstory.publish.edit.StoryDoodle", "poiReportString = %s", localObject4);
    if (localObject2[0] > 0)
    {
      localObject5 = this.jdField_a_of_type_Xan;
      j = this.jdField_a_of_type_Xan.b();
      int k = localObject2[0];
      localObject6 = ((StringBuilder)localObject3).toString();
      if (this.jdField_a_of_type_Xan.a())
      {
        localObject1 = "2";
        label946:
        ((xan)localObject5).b("pub_face", j, 0, new String[] { String.valueOf(k), localObject6, localObject1 });
        wxk.a("0X80076E3", wxk.jdField_b_of_type_Int);
        wxk.b("0X80075ED", wxk.jdField_a_of_type_Int);
        paramxlb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
        paramxlb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject3).toString();
        label1023:
        if (localObject2[1] <= 0) {
          break label1432;
        }
        this.jdField_a_of_type_Xan.b("pub_poi", this.jdField_a_of_type_Xan.b(), 0, new String[] { String.valueOf(localObject2[1]), ((StringBuilder)localObject4).toString() });
        wxk.a("0X80076E4");
        wxk.b("0X80075EE");
        if (localObject2[0] <= 0) {
          break label1403;
        }
        paramxlb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = (paramxlb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 + "," + ((StringBuilder)localObject4).toString());
        label1130:
        localObject2 = a().a(paramInt);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1452;
        }
        j = 1;
        label1151:
        if (j == 0) {
          break label1466;
        }
        localObject3 = this.jdField_a_of_type_Xan;
        i = this.jdField_a_of_type_Xan.b();
        if (!this.jdField_a_of_type_Xan.a()) {
          break label1458;
        }
        localObject1 = "2";
        label1185:
        ((xan)localObject3).b("pub_text", i, 0, new String[] { "1", localObject2, localObject1 });
        wxk.a("0X80076E2", wxk.jdField_b_of_type_Int);
        wxk.b("0X80075EC", wxk.jdField_a_of_type_Int);
        paramxlb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("3");
        paramxlb.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasText = true;
      }
    }
    for (;;)
    {
      localObject2 = a().a(paramInt);
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break;
      }
      paramxlb = "";
      paramInt = 0;
      while (paramInt < ((List)localObject2).size())
      {
        localObject1 = paramxlb + (String)((List)localObject2).get(paramInt);
        paramxlb = (xlb)localObject1;
        if (paramInt != ((List)localObject2).size() - 1) {
          paramxlb = (String)localObject1 + ",";
        }
        paramInt += 1;
      }
      localObject1 = "1";
      break label946;
      if ((i == 0) || (!xlf.a(2))) {
        break label1023;
      }
      wxk.b("0X80075ED", wxk.jdField_a_of_type_Int);
      break label1023;
      label1403:
      paramxlb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
      paramxlb.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject4).toString();
      break label1130;
      label1432:
      if ((i == 0) || (!xlf.a(3))) {
        break label1130;
      }
      wxk.b("0X80075EE");
      break label1130;
      label1452:
      j = 0;
      break label1151;
      label1458:
      localObject1 = "1";
      break label1185;
      label1466:
      if ((i != 0) && (xlf.a(4))) {
        wxk.b("0X80075EC", wxk.jdField_a_of_type_Int);
      }
    }
    this.jdField_a_of_type_Xan.b("person_gra", this.jdField_a_of_type_Xan.b(), 0, new String[] { paramxlb });
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramBitmap);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Xan.a.g())
    {
      xaz localxaz = (xaz)a(xaz.class);
      if (localxaz != null) {
        localxaz.a(paramBitmap, paramBoolean);
      }
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    a().a(paramMotionEvent);
  }
  
  public void a(Animation paramAnimation)
  {
    this.jdField_a_of_type_Xan.a(paramAnimation);
  }
  
  public void a(String paramString)
  {
    xan localxan = this.jdField_a_of_type_Xan;
    if (this.jdField_a_of_type_Xan.a()) {}
    for (String str = "2";; str = "1")
    {
      localxan.a("exp_editpoi", 0, 0, new String[] { str });
      wxk.a("0X80076CF");
      wxk.b("0X80075E4");
      paramString = new wzm(this.jdField_a_of_type_Xbf, paramString);
      this.jdField_a_of_type_Xan.a(3, paramString);
      return;
    }
  }
  
  public void a(xhv paramxhv)
  {
    if (this.jdField_a_of_type_Xan.a.jdField_a_of_type_Int == 1) {
      ((uvt)uwa.a(10)).b("has_show_add_poi_paster_guide", Boolean.valueOf(true));
    }
    boolean bool = this.jdField_a_of_type_Xan.b(6);
    if (this.jdField_a_of_type_Xan.a())
    {
      paramxhv = "2";
      if (!bool) {
        break label107;
      }
    }
    label107:
    for (String str = "1";; str = "0")
    {
      wxj.a("video_edit", "add_place", 0, 0, new String[] { paramxhv, "", str, "" });
      return;
      paramxhv = "1";
      break;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (!this.jdField_a_of_type_Xan.a.a())
    {
      this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      VideoSourceHelper.nativeSetMosaic(16, this.jdField_a_of_type_ArrayOfByte);
      xaz localxaz = (xaz)a(xaz.class);
      if (localxaz != null) {
        localxaz.a(16, paramArrayOfByte);
      }
    }
  }
  
  public boolean a()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getVisibility() == 0)) {}
    switch (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c())
    {
    default: 
      bool = false;
    case 4: 
    case 5: 
      return bool;
    case 1: 
    case 2: 
    case 3: 
      this.jdField_a_of_type_Xan.a(0);
      return true;
    case 0: 
      return false;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.j();
    return true;
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(paramInt));
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.a(paramMessage);
    }
    a(0);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(this.jdField_a_of_type_Xan.a());
    switch (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c())
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Xan.a(0);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return a().a(paramMotionEvent);
  }
  
  public byte[] a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramInt);
    }
    return null;
  }
  
  public void aa_()
  {
    super.aa_();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.g();
  }
  
  public void ad_()
  {
    if (this.jdField_b_of_type_Boolean) {
      a().b();
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b();
  }
  
  public Bitmap b()
  {
    return this.jdField_a_of_type_Xan.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setCurrentItem(1);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 2: 
    case 3: 
    default: 
      return;
    }
    QQToast.a(a(), alud.a(2131704105), 0).a();
  }
  
  public void b(int paramInt, Object paramObject)
  {
    wxe.b("Q.qqstory.publish.edit.StoryDoodle", "onStateChanged : " + paramInt);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return;
    }
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
      if ((this.jdField_a_of_type_Xan.a(13)) || (this.jdField_a_of_type_Xan.a(14)) || (this.jdField_a_of_type_Xan.a(15)) || (this.jdField_a_of_type_Xan.a(16)))
      {
        wxe.d("Q.qqstory.publish.edit.StoryDoodle", "do nothing because edit ui is showing the guide");
        return;
      }
      this.jdField_a_of_type_Xan.a(0);
      return;
    case 2: 
      this.jdField_a_of_type_Xan.a(7, paramObject);
      return;
    case 3: 
      this.jdField_a_of_type_Xan.a(5);
      return;
    case 4: 
      this.jdField_a_of_type_Xan.a(9);
      return;
    case 5: 
      this.jdField_a_of_type_Xan.a(8, paramObject);
      return;
    }
    this.jdField_a_of_type_Xan.a(8);
  }
  
  public void b(Animation paramAnimation)
  {
    this.jdField_a_of_type_Xan.b(paramAnimation);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a());
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Wzj != null) {
      umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wzj);
    }
    if (this.jdField_a_of_type_Wzi != null) {
      umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wzi);
    }
    if (this.jdField_a_of_type_Wzk != null) {
      umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wzk);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setDownloadListener(null);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = null;
    }
    this.jdField_a_of_type_Wzl = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public boolean d_()
  {
    if ((xan.a(this.jdField_b_of_type_Int, 4)) && (TextUtils.isEmpty(a().a(this.jdField_a_of_type_Xan.a()))))
    {
      if (this.jdField_a_of_type_Xan.a.jdField_a_of_type_Int != 2) {
        this.jdField_a_of_type_Xan.a(5);
      }
      do
      {
        return true;
        if (this.jdField_a_of_type_Xan.jdField_b_of_type_Int == 0)
        {
          this.jdField_a_of_type_Xan.a(27);
          return true;
        }
      } while (this.jdField_a_of_type_Xan.jdField_b_of_type_Int != 27);
      this.jdField_a_of_type_Xan.a(0);
      return true;
    }
    return false;
  }
  
  public void f()
  {
    this.jdField_a_of_type_Xby.a().postDelayed(new EditVideoDoodle.7(this), 200L);
  }
  
  public void g()
  {
    this.jdField_a_of_type_Xan.d();
  }
  
  public void h()
  {
    super.h();
  }
  
  public void i()
  {
    this.jdField_a_of_type_Xan.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wzb
 * JD-Core Version:    0.7.0.1
 */