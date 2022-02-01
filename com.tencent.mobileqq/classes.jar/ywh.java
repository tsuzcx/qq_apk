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

public class ywh
  extends yxr
  implements IEventReceiver, yuy, zdu, zdv
{
  public static final String a;
  public int a;
  protected Handler a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  bcwm jdField_a_of_type_Bcwm = new ywn(this);
  protected DoodleLayout a;
  protected Runnable a;
  ywo jdField_a_of_type_Ywo;
  ywp jdField_a_of_type_Ywp;
  ywq jdField_a_of_type_Ywq;
  protected ywr a;
  private yyl jdField_a_of_type_Yyl = new ywi(this);
  public zcm a;
  private zew jdField_a_of_type_Zew = new ywm(this);
  protected zfa a;
  public boolean a;
  protected byte[] a;
  private final int b;
  public boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = win.e;
  }
  
  public ywh(@NonNull yxt paramyxt, int paramInt)
  {
    super(paramyxt);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRunnable = new EditVideoDoodle.4(this);
    this.jdField_a_of_type_Zcm = new ywl(this);
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
      this.jdField_a_of_type_Ywr.a(a());
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
      yuk.d("Q.qqstory.publish.edit.StoryDoodle", "delete file : " + bool);
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      yuk.d("Q.qqstory.publish.edit.StoryDoodle", "create folder : " + bool);
    }
  }
  
  private void j()
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      yuk.b("Q.qqstory.publish.edit.StoryDoodle", "makeSureInitLayout");
      localObject1 = this.jdField_a_of_type_AndroidViewViewStub.getParent();
      if ((localObject1 == null) || (!(localObject1 instanceof ViewGroup))) {
        break label459;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
      if (!yxt.a(this.jdField_b_of_type_Int, 4)) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.i();
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(720, 1280);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setDownloadListener(this.jdField_a_of_type_Zew);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setAdapter(this.jdField_a_of_type_Ywr);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicSize(16);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicStandardSize(this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleEventListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBtnOperationHelper(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditVideoParams(this.jdField_a_of_type_Yxt.a);
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a;
      if (localObject1 != null) {
        ((DoodleEditView)localObject1).setDoodleEditViewListener(new ywj(this));
      }
      if ((this.jdField_a_of_type_Yxt.a.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Yxt.a.jdField_a_of_type_Int == 12))
      {
        if (!(this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
          break label476;
        }
        int i = zqb.b(this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
        if ((i == 270) || (i == 90))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(1280, this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() * 1280 / this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((int)bhlo.k(), (int)(bhlo.k() * this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() / this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b()));
        }
      }
    }
    for (;;)
    {
      localObject1 = wjj.a();
      Object localObject2 = new ywp(this);
      this.jdField_a_of_type_Ywp = ((ywp)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      localObject1 = wjj.a();
      localObject2 = new ywo(this);
      this.jdField_a_of_type_Ywo = ((ywo)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      localObject1 = wjj.a();
      localObject2 = new ywq(this);
      this.jdField_a_of_type_Ywq = ((ywq)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      return;
      label459:
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)a(2131365676));
      break;
      label476:
      if ((this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        localObject1 = (EditLocalVideoSource)this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        if ((((EditLocalVideoSource)localObject1).a() * 1.0F / ((EditLocalVideoSource)localObject1).b() >= (float)bhlo.k() * 1.0F / (float)bhlo.l()) && (((EditLocalVideoSource)localObject1).a.rotation == 0))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(1280, this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() * 1280 / this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((int)bhlo.k(), (int)(bhlo.k() * this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() / this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a()));
        }
        else if ((((EditLocalVideoSource)localObject1).a() * 1.0F / ((EditLocalVideoSource)localObject1).b() < 1.0F) && ((((EditLocalVideoSource)localObject1).a.rotation == 90) || (((EditLocalVideoSource)localObject1).a.rotation == 270)))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(1280, this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() * 1280 / this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((int)bhlo.k(), (int)(bhlo.k() * this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() / this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b()));
        }
      }
    }
  }
  
  private void k()
  {
    new bbgn(this.jdField_a_of_type_Yze.getActivity(), new ywk(this)).a();
  }
  
  public void W_()
  {
    super.W_();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.g();
  }
  
  public void Z_()
  {
    if (this.jdField_b_of_type_Boolean) {
      a().b();
    }
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
  
  public JobSegment<zih, zih> a(int paramInt)
  {
    if (((this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))) {
      return new zir(this, (yuz)a(yuz.class), paramInt);
    }
    return new zii(this, (yuz)a(yuz.class), paramInt);
  }
  
  @NonNull
  protected Collection<zex> a()
  {
    Object localObject = ((zbz)wth.a(8)).a();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      zby localzby = (zby)((Iterator)localObject).next();
      yuk.b("Q.qqstory.publish.edit.StoryDoodle", "add doodle emoji item = " + localzby);
      if (localzby.jdField_a_of_type_Int == 1)
      {
        zfd localzfd = new zfd(localzby.jdField_a_of_type_JavaLangString);
        localzfd.b = localzby.d;
        localzfd.c = localzby.b;
        localzfd.d = localzby.c;
        localzfd.f = localzby.a();
        localzfd.a(localzby.f);
        if (("1".equals(localzfd.jdField_a_of_type_JavaLangString)) && (!bhnv.g(a()))) {
          localzfd.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getDrawable(2130846467);
        }
        localArrayList.add(localzfd);
      }
      else if (localzby.jdField_a_of_type_Int == 2)
      {
        if ((!TextUtils.isEmpty(localzby.b)) && (bhnv.g(a()))) {
          this.jdField_a_of_type_Zfa.c = localzby.b;
        }
        for (;;)
        {
          localArrayList.add(this.jdField_a_of_type_Zfa);
          break;
          this.jdField_a_of_type_Zfa.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getDrawable(2130846610);
        }
      }
    }
    yuk.b("Q.qqstory.publish.edit.StoryDoodle", "getDoodleFacePackages, size = " + localArrayList.size());
    return localArrayList;
  }
  
  public void a()
  {
    b(jdField_a_of_type_JavaLangString);
    QQStoryContext.a();
    Object localObject1 = QQStoryContext.a();
    PtvTemplateManager.a((AppInterface)localObject1).a((AppInterface)localObject1, this.jdField_a_of_type_Bcwm, false);
    Object localObject2 = (zbz)wth.a(8);
    ((zbz)localObject2).a(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131365677));
    this.jdField_a_of_type_Ywr = new ywr(null);
    if (this.jdField_a_of_type_Zfa == null)
    {
      this.jdField_a_of_type_Zfa = new zfa("Location-Package");
      this.jdField_a_of_type_Zfa.jdField_a_of_type_Boolean = true;
      localObject1 = zbz.c((zbz)localObject2, "0");
      localObject2 = zbz.a((zbz)localObject2, "0");
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!bhnv.g(a()))) {
        break label156;
      }
      this.jdField_a_of_type_Zfa.c = ((String)localObject2);
    }
    for (;;)
    {
      this.jdField_a_of_type_Zfa.a((String)localObject1);
      a(yuy.class, this);
      return;
      label156:
      this.jdField_a_of_type_Zfa.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getDrawable(2130846610);
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
  
  public void a(int paramInt, @NonNull zih paramzih)
  {
    super.a(paramInt, paramzih);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      yuk.d("Q.qqstory.publish.edit.StoryDoodle", "editVideoPrePublish but doodle layout is null");
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.c();
    paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription = a().a(paramInt);
    paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mMosaicMask = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramInt);
    paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mMosaicSize = 16;
    Object localObject1 = a().b(paramInt);
    if (((List)localObject1).size() == 1) {
      paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLocationDescription = ((zau)((List)localObject1).get(0)).a();
    }
    Object localObject2;
    label202:
    int i;
    label261:
    Object localObject3;
    int j;
    if (a().b(paramInt))
    {
      localObject2 = this.jdField_a_of_type_Yxt;
      if (this.jdField_a_of_type_Yxt.a())
      {
        localObject1 = "2";
        ((yxt)localObject2).a("change_graffiti", 0, 0, new String[] { localObject1 });
        yuq.a("0X80076C0");
      }
    }
    else
    {
      if (a().a(paramInt))
      {
        localObject2 = this.jdField_a_of_type_Yxt;
        if (!this.jdField_a_of_type_Yxt.a()) {
          break label690;
        }
        localObject1 = "2";
        ((yxt)localObject2).a("change_color", 0, 0, new String[] { localObject1 });
        yuq.a("0X80076C4");
      }
      if ((!(this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) && (!(this.jdField_a_of_type_Yxt.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))) {
        break label698;
      }
      i = 1;
      localObject2 = a().a(paramInt);
      if ((localObject2 != null) && (localObject2.length == 2))
      {
        if (localObject2[0] <= 0) {
          break label711;
        }
        localObject3 = this.jdField_a_of_type_Yxt;
        j = this.jdField_a_of_type_Yxt.b();
        if (!this.jdField_a_of_type_Yxt.a()) {
          break label703;
        }
        localObject1 = "2";
        label320:
        ((yxt)localObject3).b("pub_graffiti", j, 0, new String[] { "1", "", localObject1 });
        yuq.a("0X80076E0", yuq.jdField_b_of_type_Int);
        yuq.b("0X80075EA", yuq.jdField_a_of_type_Int);
        paramzih.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
        paramzih.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasGraffiti = true;
        label392:
        if (localObject2[1] <= 0) {
          break label742;
        }
        localObject3 = this.jdField_a_of_type_Yxt;
        j = this.jdField_a_of_type_Yxt.b();
        if (!this.jdField_a_of_type_Yxt.a()) {
          break label734;
        }
        localObject1 = "2";
        label429:
        ((yxt)localObject3).b("pub_mosaics", j, 0, new String[] { "1", "", localObject1 });
        yuq.a("0X80076E1");
        yuq.b("0X80075EB");
        paramzih.jdField_b_of_type_Boolean = true;
        if (localObject2[0] == 0) {
          paramzih.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
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
      if ((i == 0) || (!zil.a(0))) {
        break label392;
      }
      yuq.b("0X80075EA", yuq.jdField_a_of_type_Int);
      break label392;
      label734:
      localObject1 = "1";
      break label429;
      label742:
      if ((i != 0) && (zil.a(1))) {
        yuq.b("0X80075EB");
      }
    }
    if (((StringBuilder)localObject3).length() > 0) {
      ((StringBuilder)localObject3).deleteCharAt(((StringBuilder)localObject3).length() - 1);
    }
    yuk.a("Q.qqstory.publish.edit.StoryDoodle", "faceReportString = %s", localObject3);
    Object localObject4 = new StringBuilder();
    if (((List)localObject1).size() > 0)
    {
      localObject5 = ((List)localObject1).iterator();
      while (((Iterator)localObject5).hasNext()) {
        ((StringBuilder)localObject4).append(((zau)((Iterator)localObject5).next()).e).append(',');
      }
      ((StringBuilder)localObject4).deleteCharAt(((StringBuilder)localObject4).length() - 1);
      ((zau)((List)localObject1).get(0)).a();
    }
    yuk.a("Q.qqstory.publish.edit.StoryDoodle", "poiReportString = %s", localObject4);
    if (localObject2[0] > 0)
    {
      localObject5 = this.jdField_a_of_type_Yxt;
      j = this.jdField_a_of_type_Yxt.b();
      int k = localObject2[0];
      localObject6 = ((StringBuilder)localObject3).toString();
      if (this.jdField_a_of_type_Yxt.a())
      {
        localObject1 = "2";
        label946:
        ((yxt)localObject5).b("pub_face", j, 0, new String[] { String.valueOf(k), localObject6, localObject1 });
        yuq.a("0X80076E3", yuq.jdField_b_of_type_Int);
        yuq.b("0X80075ED", yuq.jdField_a_of_type_Int);
        paramzih.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
        paramzih.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject3).toString();
        label1023:
        if (localObject2[1] <= 0) {
          break label1432;
        }
        this.jdField_a_of_type_Yxt.b("pub_poi", this.jdField_a_of_type_Yxt.b(), 0, new String[] { String.valueOf(localObject2[1]), ((StringBuilder)localObject4).toString() });
        yuq.a("0X80076E4");
        yuq.b("0X80075EE");
        if (localObject2[0] <= 0) {
          break label1403;
        }
        paramzih.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = (paramzih.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 + "," + ((StringBuilder)localObject4).toString());
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
        localObject3 = this.jdField_a_of_type_Yxt;
        i = this.jdField_a_of_type_Yxt.b();
        if (!this.jdField_a_of_type_Yxt.a()) {
          break label1458;
        }
        localObject1 = "2";
        label1185:
        ((yxt)localObject3).b("pub_text", i, 0, new String[] { "1", localObject2, localObject1 });
        yuq.a("0X80076E2", yuq.jdField_b_of_type_Int);
        yuq.b("0X80075EC", yuq.jdField_a_of_type_Int);
        paramzih.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("3");
        paramzih.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasText = true;
      }
    }
    for (;;)
    {
      localObject2 = a().a(paramInt);
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break;
      }
      paramzih = "";
      paramInt = 0;
      while (paramInt < ((List)localObject2).size())
      {
        localObject1 = paramzih + (String)((List)localObject2).get(paramInt);
        paramzih = (zih)localObject1;
        if (paramInt != ((List)localObject2).size() - 1) {
          paramzih = (String)localObject1 + ",";
        }
        paramInt += 1;
      }
      localObject1 = "1";
      break label946;
      if ((i == 0) || (!zil.a(2))) {
        break label1023;
      }
      yuq.b("0X80075ED", yuq.jdField_a_of_type_Int);
      break label1023;
      label1403:
      paramzih.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
      paramzih.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject4).toString();
      break label1130;
      label1432:
      if ((i == 0) || (!zil.a(3))) {
        break label1130;
      }
      yuq.b("0X80075EE");
      break label1130;
      label1452:
      j = 0;
      break label1151;
      label1458:
      localObject1 = "1";
      break label1185;
      label1466:
      if ((i != 0) && (zil.a(4))) {
        yuq.b("0X80075EC", yuq.jdField_a_of_type_Int);
      }
    }
    this.jdField_a_of_type_Yxt.b("person_gra", this.jdField_a_of_type_Yxt.b(), 0, new String[] { paramzih });
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramBitmap);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Yxt.a.g())
    {
      yyf localyyf = (yyf)a(yyf.class);
      if (localyyf != null) {
        localyyf.a(paramBitmap, paramBoolean);
      }
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    a().a(paramMotionEvent);
  }
  
  public void a(Animation paramAnimation)
  {
    this.jdField_a_of_type_Yxt.a(paramAnimation);
  }
  
  public void a(String paramString)
  {
    yxt localyxt = this.jdField_a_of_type_Yxt;
    if (this.jdField_a_of_type_Yxt.a()) {}
    for (String str = "2";; str = "1")
    {
      localyxt.a("exp_editpoi", 0, 0, new String[] { str });
      yuq.a("0X80076CF");
      yuq.b("0X80075E4");
      paramString = new yws(this.jdField_a_of_type_Yyl, paramString);
      this.jdField_a_of_type_Yxt.a(3, paramString);
      return;
    }
  }
  
  public void a(zfb paramzfb)
  {
    if (this.jdField_a_of_type_Yxt.a.jdField_a_of_type_Int == 1) {
      ((wta)wth.a(10)).b("has_show_add_poi_paster_guide", Boolean.valueOf(true));
    }
    boolean bool = this.jdField_a_of_type_Yxt.b(6);
    if (this.jdField_a_of_type_Yxt.a())
    {
      paramzfb = "2";
      if (!bool) {
        break label107;
      }
    }
    label107:
    for (String str = "1";; str = "0")
    {
      yup.a("video_edit", "add_place", 0, 0, new String[] { paramzfb, "", str, "" });
      return;
      paramzfb = "1";
      break;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (!this.jdField_a_of_type_Yxt.a.a())
    {
      this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      VideoSourceHelper.nativeSetMosaic(16, this.jdField_a_of_type_ArrayOfByte);
      yyf localyyf = (yyf)a(yyf.class);
      if (localyyf != null) {
        localyyf.a(16, paramArrayOfByte);
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
      this.jdField_a_of_type_Yxt.a(0);
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
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(this.jdField_a_of_type_Yxt.a());
    switch (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c())
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Yxt.a(0);
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
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b();
  }
  
  public Bitmap b()
  {
    return this.jdField_a_of_type_Yxt.a();
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
    QQToast.a(a(), anzj.a(2131702609), 0).a();
  }
  
  public void b(int paramInt, Object paramObject)
  {
    yuk.b("Q.qqstory.publish.edit.StoryDoodle", "onStateChanged : " + paramInt);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return;
    }
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
      if ((this.jdField_a_of_type_Yxt.a(13)) || (this.jdField_a_of_type_Yxt.a(14)) || (this.jdField_a_of_type_Yxt.a(15)) || (this.jdField_a_of_type_Yxt.a(16)))
      {
        yuk.d("Q.qqstory.publish.edit.StoryDoodle", "do nothing because edit ui is showing the guide");
        return;
      }
      this.jdField_a_of_type_Yxt.a(0);
      return;
    case 2: 
      this.jdField_a_of_type_Yxt.a(7, paramObject);
      return;
    case 3: 
      this.jdField_a_of_type_Yxt.a(5);
      return;
    case 4: 
      this.jdField_a_of_type_Yxt.a(9);
      return;
    case 5: 
      this.jdField_a_of_type_Yxt.a(8, paramObject);
      return;
    }
    this.jdField_a_of_type_Yxt.a(8);
  }
  
  public void b(Animation paramAnimation)
  {
    this.jdField_a_of_type_Yxt.b(paramAnimation);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a());
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ywp != null) {
      wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Ywp);
    }
    if (this.jdField_a_of_type_Ywo != null) {
      wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Ywo);
    }
    if (this.jdField_a_of_type_Ywq != null) {
      wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Ywq);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setDownloadListener(null);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = null;
    }
    this.jdField_a_of_type_Ywr = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Yze.a().postDelayed(new EditVideoDoodle.7(this), 200L);
  }
  
  public void g()
  {
    this.jdField_a_of_type_Yxt.d();
  }
  
  public boolean g_()
  {
    if ((yxt.a(this.jdField_b_of_type_Int, 4)) && (TextUtils.isEmpty(a().a(this.jdField_a_of_type_Yxt.a()))))
    {
      if (this.jdField_a_of_type_Yxt.a.jdField_a_of_type_Int != 2) {
        this.jdField_a_of_type_Yxt.a(5);
      }
      do
      {
        return true;
        if (this.jdField_a_of_type_Yxt.jdField_b_of_type_Int == 0)
        {
          this.jdField_a_of_type_Yxt.a(27);
          return true;
        }
      } while (this.jdField_a_of_type_Yxt.jdField_b_of_type_Int != 27);
      this.jdField_a_of_type_Yxt.a(0);
      return true;
    }
    return false;
  }
  
  public void h()
  {
    super.h();
  }
  
  public void i()
  {
    this.jdField_a_of_type_Yxt.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywh
 * JD-Core Version:    0.7.0.1
 */