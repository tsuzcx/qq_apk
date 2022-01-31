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

public class uth
  extends uur
  implements IEventReceiver, ury, vau, vav
{
  public static final String a;
  public int a;
  protected Handler a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  awdy jdField_a_of_type_Awdy = new utn(this);
  protected DoodleLayout a;
  protected Runnable a;
  uto jdField_a_of_type_Uto;
  utp jdField_a_of_type_Utp;
  utq jdField_a_of_type_Utq;
  protected utr a;
  private uvl jdField_a_of_type_Uvl = new uti(this);
  public uzm a;
  private vbw jdField_a_of_type_Vbw = new utm(this);
  protected vca a;
  public boolean a;
  protected byte[] a;
  private final int b;
  public boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = sfm.e;
  }
  
  public uth(@NonNull uut paramuut, int paramInt)
  {
    super(paramuut);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRunnable = new EditVideoDoodle.4(this);
    this.jdField_a_of_type_Uzm = new utl(this);
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
      this.jdField_a_of_type_Utr.a(a());
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
      urk.d("Q.qqstory.publish.edit.StoryDoodle", "delete file : " + bool);
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      urk.d("Q.qqstory.publish.edit.StoryDoodle", "create folder : " + bool);
    }
  }
  
  private void j()
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      urk.b("Q.qqstory.publish.edit.StoryDoodle", "makeSureInitLayout");
      localObject1 = this.jdField_a_of_type_AndroidViewViewStub.getParent();
      if ((localObject1 == null) || (!(localObject1 instanceof ViewGroup))) {
        break label459;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
      if (!uut.a(this.jdField_b_of_type_Int, 4)) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.i();
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(720, 1280);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setDownloadListener(this.jdField_a_of_type_Vbw);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setAdapter(this.jdField_a_of_type_Utr);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicSize(16);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicStandardSize(this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleEventListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBtnOperationHelper(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditVideoParams(this.jdField_a_of_type_Uut.a);
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a;
      if (localObject1 != null) {
        ((DoodleEditView)localObject1).setDoodleEditViewListener(new utj(this));
      }
      if ((this.jdField_a_of_type_Uut.a.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Uut.a.jdField_a_of_type_Int == 12))
      {
        if (!(this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
          break label476;
        }
        int i = vnb.b(this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
        if ((i == 270) || (i == 90))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(1280, this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() * 1280 / this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((int)babp.k(), (int)(babp.k() * this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() / this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b()));
        }
      }
    }
    for (;;)
    {
      localObject1 = sgi.a();
      Object localObject2 = new utp(this);
      this.jdField_a_of_type_Utp = ((utp)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      localObject1 = sgi.a();
      localObject2 = new uto(this);
      this.jdField_a_of_type_Uto = ((uto)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      localObject1 = sgi.a();
      localObject2 = new utq(this);
      this.jdField_a_of_type_Utq = ((utq)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      return;
      label459:
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)a(2131299744));
      break;
      label476:
      if ((this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        localObject1 = (EditLocalVideoSource)this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        if ((((EditLocalVideoSource)localObject1).a() * 1.0F / ((EditLocalVideoSource)localObject1).b() >= (float)babp.k() * 1.0F / (float)babp.l()) && (((EditLocalVideoSource)localObject1).a.rotation == 0))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(1280, this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() * 1280 / this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((int)babp.k(), (int)(babp.k() * this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() / this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a()));
        }
        else if ((((EditLocalVideoSource)localObject1).a() * 1.0F / ((EditLocalVideoSource)localObject1).b() < 1.0F) && ((((EditLocalVideoSource)localObject1).a.rotation == 90) || (((EditLocalVideoSource)localObject1).a.rotation == 270)))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(1280, this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() * 1280 / this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((int)babp.k(), (int)(babp.k() * this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() / this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b()));
        }
      }
    }
  }
  
  private void k()
  {
    new auua(this.jdField_a_of_type_Uwe.getActivity(), new utk(this)).a();
  }
  
  public void X_()
  {
    super.X_();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.g();
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
  
  public JobSegment<vfh, vfh> a(int paramInt)
  {
    if (((this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))) {
      return new vfr(this, (urz)a(urz.class), paramInt);
    }
    return new vfi(this, (urz)a(urz.class), paramInt);
  }
  
  @NonNull
  protected Collection<vbx> a()
  {
    Object localObject = ((uyz)sqg.a(8)).a();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      uyy localuyy = (uyy)((Iterator)localObject).next();
      urk.b("Q.qqstory.publish.edit.StoryDoodle", "add doodle emoji item = " + localuyy);
      if (localuyy.jdField_a_of_type_Int == 1)
      {
        vcd localvcd = new vcd(localuyy.jdField_a_of_type_JavaLangString);
        localvcd.b = localuyy.d;
        localvcd.c = localuyy.b;
        localvcd.d = localuyy.c;
        localvcd.f = localuyy.a();
        localvcd.a(localuyy.f);
        if (("1".equals(localvcd.jdField_a_of_type_JavaLangString)) && (!badq.g(a()))) {
          localvcd.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getDrawable(2130845369);
        }
        localArrayList.add(localvcd);
      }
      else if (localuyy.jdField_a_of_type_Int == 2)
      {
        if ((!TextUtils.isEmpty(localuyy.b)) && (badq.g(a()))) {
          this.jdField_a_of_type_Vca.c = localuyy.b;
        }
        for (;;)
        {
          localArrayList.add(this.jdField_a_of_type_Vca);
          break;
          this.jdField_a_of_type_Vca.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getDrawable(2130845513);
        }
      }
    }
    urk.b("Q.qqstory.publish.edit.StoryDoodle", "getDoodleFacePackages, size = " + localArrayList.size());
    return localArrayList;
  }
  
  public void a()
  {
    b(jdField_a_of_type_JavaLangString);
    QQStoryContext.a();
    Object localObject1 = QQStoryContext.a();
    PtvTemplateManager.a((AppInterface)localObject1).a((AppInterface)localObject1, this.jdField_a_of_type_Awdy, false);
    Object localObject2 = (uyz)sqg.a(8);
    ((uyz)localObject2).a(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131299745));
    this.jdField_a_of_type_Utr = new utr(null);
    if (this.jdField_a_of_type_Vca == null)
    {
      this.jdField_a_of_type_Vca = new vca("Location-Package");
      this.jdField_a_of_type_Vca.jdField_a_of_type_Boolean = true;
      localObject1 = uyz.c((uyz)localObject2, "0");
      localObject2 = uyz.a((uyz)localObject2, "0");
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!badq.g(a()))) {
        break label156;
      }
      this.jdField_a_of_type_Vca.c = ((String)localObject2);
    }
    for (;;)
    {
      this.jdField_a_of_type_Vca.a((String)localObject1);
      a(ury.class, this);
      return;
      label156:
      this.jdField_a_of_type_Vca.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getDrawable(2130845513);
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
  
  public void a(int paramInt, @NonNull vfh paramvfh)
  {
    super.a(paramInt, paramvfh);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      urk.d("Q.qqstory.publish.edit.StoryDoodle", "editVideoPrePublish but doodle layout is null");
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.c();
    paramvfh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription = a().a(paramInt);
    paramvfh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mMosaicMask = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramInt);
    paramvfh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mMosaicSize = 16;
    Object localObject1 = a().b(paramInt);
    if (((List)localObject1).size() == 1) {
      paramvfh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLocationDescription = ((uxu)((List)localObject1).get(0)).a();
    }
    Object localObject2;
    label202:
    int i;
    label261:
    Object localObject3;
    int j;
    if (a().b(paramInt))
    {
      localObject2 = this.jdField_a_of_type_Uut;
      if (this.jdField_a_of_type_Uut.a())
      {
        localObject1 = "2";
        ((uut)localObject2).a("change_graffiti", 0, 0, new String[] { localObject1 });
        urq.a("0X80076C0");
      }
    }
    else
    {
      if (a().a(paramInt))
      {
        localObject2 = this.jdField_a_of_type_Uut;
        if (!this.jdField_a_of_type_Uut.a()) {
          break label690;
        }
        localObject1 = "2";
        ((uut)localObject2).a("change_color", 0, 0, new String[] { localObject1 });
        urq.a("0X80076C4");
      }
      if ((!(this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) && (!(this.jdField_a_of_type_Uut.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))) {
        break label698;
      }
      i = 1;
      localObject2 = a().a(paramInt);
      if ((localObject2 != null) && (localObject2.length == 2))
      {
        if (localObject2[0] <= 0) {
          break label711;
        }
        localObject3 = this.jdField_a_of_type_Uut;
        j = this.jdField_a_of_type_Uut.b();
        if (!this.jdField_a_of_type_Uut.a()) {
          break label703;
        }
        localObject1 = "2";
        label320:
        ((uut)localObject3).b("pub_graffiti", j, 0, new String[] { "1", "", localObject1 });
        urq.a("0X80076E0", urq.jdField_b_of_type_Int);
        urq.b("0X80075EA", urq.jdField_a_of_type_Int);
        paramvfh.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
        paramvfh.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasGraffiti = true;
        label392:
        if (localObject2[1] <= 0) {
          break label742;
        }
        localObject3 = this.jdField_a_of_type_Uut;
        j = this.jdField_a_of_type_Uut.b();
        if (!this.jdField_a_of_type_Uut.a()) {
          break label734;
        }
        localObject1 = "2";
        label429:
        ((uut)localObject3).b("pub_mosaics", j, 0, new String[] { "1", "", localObject1 });
        urq.a("0X80076E1");
        urq.b("0X80075EB");
        paramvfh.jdField_b_of_type_Boolean = true;
        if (localObject2[0] == 0) {
          paramvfh.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
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
      if ((i == 0) || (!vfl.a(0))) {
        break label392;
      }
      urq.b("0X80075EA", urq.jdField_a_of_type_Int);
      break label392;
      label734:
      localObject1 = "1";
      break label429;
      label742:
      if ((i != 0) && (vfl.a(1))) {
        urq.b("0X80075EB");
      }
    }
    if (((StringBuilder)localObject3).length() > 0) {
      ((StringBuilder)localObject3).deleteCharAt(((StringBuilder)localObject3).length() - 1);
    }
    urk.a("Q.qqstory.publish.edit.StoryDoodle", "faceReportString = %s", localObject3);
    Object localObject4 = new StringBuilder();
    if (((List)localObject1).size() > 0)
    {
      localObject5 = ((List)localObject1).iterator();
      while (((Iterator)localObject5).hasNext()) {
        ((StringBuilder)localObject4).append(((uxu)((Iterator)localObject5).next()).e).append(',');
      }
      ((StringBuilder)localObject4).deleteCharAt(((StringBuilder)localObject4).length() - 1);
      ((uxu)((List)localObject1).get(0)).a();
    }
    urk.a("Q.qqstory.publish.edit.StoryDoodle", "poiReportString = %s", localObject4);
    if (localObject2[0] > 0)
    {
      localObject5 = this.jdField_a_of_type_Uut;
      j = this.jdField_a_of_type_Uut.b();
      int k = localObject2[0];
      localObject6 = ((StringBuilder)localObject3).toString();
      if (this.jdField_a_of_type_Uut.a())
      {
        localObject1 = "2";
        label946:
        ((uut)localObject5).b("pub_face", j, 0, new String[] { String.valueOf(k), localObject6, localObject1 });
        urq.a("0X80076E3", urq.jdField_b_of_type_Int);
        urq.b("0X80075ED", urq.jdField_a_of_type_Int);
        paramvfh.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
        paramvfh.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject3).toString();
        label1023:
        if (localObject2[1] <= 0) {
          break label1432;
        }
        this.jdField_a_of_type_Uut.b("pub_poi", this.jdField_a_of_type_Uut.b(), 0, new String[] { String.valueOf(localObject2[1]), ((StringBuilder)localObject4).toString() });
        urq.a("0X80076E4");
        urq.b("0X80075EE");
        if (localObject2[0] <= 0) {
          break label1403;
        }
        paramvfh.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = (paramvfh.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 + "," + ((StringBuilder)localObject4).toString());
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
        localObject3 = this.jdField_a_of_type_Uut;
        i = this.jdField_a_of_type_Uut.b();
        if (!this.jdField_a_of_type_Uut.a()) {
          break label1458;
        }
        localObject1 = "2";
        label1185:
        ((uut)localObject3).b("pub_text", i, 0, new String[] { "1", localObject2, localObject1 });
        urq.a("0X80076E2", urq.jdField_b_of_type_Int);
        urq.b("0X80075EC", urq.jdField_a_of_type_Int);
        paramvfh.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("3");
        paramvfh.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasText = true;
      }
    }
    for (;;)
    {
      localObject2 = a().a(paramInt);
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break;
      }
      paramvfh = "";
      paramInt = 0;
      while (paramInt < ((List)localObject2).size())
      {
        localObject1 = paramvfh + (String)((List)localObject2).get(paramInt);
        paramvfh = (vfh)localObject1;
        if (paramInt != ((List)localObject2).size() - 1) {
          paramvfh = (String)localObject1 + ",";
        }
        paramInt += 1;
      }
      localObject1 = "1";
      break label946;
      if ((i == 0) || (!vfl.a(2))) {
        break label1023;
      }
      urq.b("0X80075ED", urq.jdField_a_of_type_Int);
      break label1023;
      label1403:
      paramvfh.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
      paramvfh.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject4).toString();
      break label1130;
      label1432:
      if ((i == 0) || (!vfl.a(3))) {
        break label1130;
      }
      urq.b("0X80075EE");
      break label1130;
      label1452:
      j = 0;
      break label1151;
      label1458:
      localObject1 = "1";
      break label1185;
      label1466:
      if ((i != 0) && (vfl.a(4))) {
        urq.b("0X80075EC", urq.jdField_a_of_type_Int);
      }
    }
    this.jdField_a_of_type_Uut.b("person_gra", this.jdField_a_of_type_Uut.b(), 0, new String[] { paramvfh });
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramBitmap);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Uut.a.g())
    {
      uvf localuvf = (uvf)a(uvf.class);
      if (localuvf != null) {
        localuvf.a(paramBitmap, paramBoolean);
      }
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    a().a(paramMotionEvent);
  }
  
  public void a(Animation paramAnimation)
  {
    this.jdField_a_of_type_Uut.a(paramAnimation);
  }
  
  public void a(String paramString)
  {
    uut localuut = this.jdField_a_of_type_Uut;
    if (this.jdField_a_of_type_Uut.a()) {}
    for (String str = "2";; str = "1")
    {
      localuut.a("exp_editpoi", 0, 0, new String[] { str });
      urq.a("0X80076CF");
      urq.b("0X80075E4");
      paramString = new uts(this.jdField_a_of_type_Uvl, paramString);
      this.jdField_a_of_type_Uut.a(3, paramString);
      return;
    }
  }
  
  public void a(vcb paramvcb)
  {
    if (this.jdField_a_of_type_Uut.a.jdField_a_of_type_Int == 1) {
      ((spz)sqg.a(10)).b("has_show_add_poi_paster_guide", Boolean.valueOf(true));
    }
    boolean bool = this.jdField_a_of_type_Uut.b(6);
    if (this.jdField_a_of_type_Uut.a())
    {
      paramvcb = "2";
      if (!bool) {
        break label107;
      }
    }
    label107:
    for (String str = "1";; str = "0")
    {
      urp.a("video_edit", "add_place", 0, 0, new String[] { paramvcb, "", str, "" });
      return;
      paramvcb = "1";
      break;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (!this.jdField_a_of_type_Uut.a.a())
    {
      this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      VideoSourceHelper.nativeSetMosaic(16, this.jdField_a_of_type_ArrayOfByte);
      uvf localuvf = (uvf)a(uvf.class);
      if (localuvf != null) {
        localuvf.a(16, paramArrayOfByte);
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
      this.jdField_a_of_type_Uut.a(0);
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
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(this.jdField_a_of_type_Uut.a());
    switch (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c())
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Uut.a(0);
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
    return this.jdField_a_of_type_Uut.a();
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
    bbmy.a(a(), ajjy.a(2131637925), 0).a();
  }
  
  public void b(int paramInt, Object paramObject)
  {
    urk.b("Q.qqstory.publish.edit.StoryDoodle", "onStateChanged : " + paramInt);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return;
    }
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
      if ((this.jdField_a_of_type_Uut.a(13)) || (this.jdField_a_of_type_Uut.a(14)) || (this.jdField_a_of_type_Uut.a(15)) || (this.jdField_a_of_type_Uut.a(16)))
      {
        urk.d("Q.qqstory.publish.edit.StoryDoodle", "do nothing because edit ui is showing the guide");
        return;
      }
      this.jdField_a_of_type_Uut.a(0);
      return;
    case 2: 
      this.jdField_a_of_type_Uut.a(7, paramObject);
      return;
    case 3: 
      this.jdField_a_of_type_Uut.a(5);
      return;
    case 4: 
      this.jdField_a_of_type_Uut.a(9);
      return;
    case 5: 
      this.jdField_a_of_type_Uut.a(8, paramObject);
      return;
    }
    this.jdField_a_of_type_Uut.a(8);
  }
  
  public void b(Animation paramAnimation)
  {
    this.jdField_a_of_type_Uut.b(paramAnimation);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a());
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Utp != null) {
      sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Utp);
    }
    if (this.jdField_a_of_type_Uto != null) {
      sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uto);
    }
    if (this.jdField_a_of_type_Utq != null) {
      sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Utq);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setDownloadListener(null);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = null;
    }
    this.jdField_a_of_type_Utr = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public boolean d_()
  {
    if ((uut.a(this.jdField_b_of_type_Int, 4)) && (TextUtils.isEmpty(a().a(this.jdField_a_of_type_Uut.a()))))
    {
      if (this.jdField_a_of_type_Uut.a.jdField_a_of_type_Int != 2) {
        this.jdField_a_of_type_Uut.a(5);
      }
      do
      {
        return true;
        if (this.jdField_a_of_type_Uut.jdField_b_of_type_Int == 0)
        {
          this.jdField_a_of_type_Uut.a(27);
          return true;
        }
      } while (this.jdField_a_of_type_Uut.jdField_b_of_type_Int != 27);
      this.jdField_a_of_type_Uut.a(0);
      return true;
    }
    return false;
  }
  
  public void f()
  {
    this.jdField_a_of_type_Uwe.a().postDelayed(new EditVideoDoodle.7(this), 200L);
  }
  
  public void g()
  {
    this.jdField_a_of_type_Uut.d();
  }
  
  public void h()
  {
    super.h();
  }
  
  public void i()
  {
    this.jdField_a_of_type_Uut.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uth
 * JD-Core Version:    0.7.0.1
 */