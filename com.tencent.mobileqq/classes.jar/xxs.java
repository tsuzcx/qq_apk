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
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
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

public class xxs
  extends xzb
  implements IEventReceiver, xwj, yev, yew
{
  public static final String a;
  public int a;
  protected Handler a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  bbpx jdField_a_of_type_Bbpx = new xxy(this);
  protected DoodleLayout a;
  protected Runnable a;
  xxz jdField_a_of_type_Xxz;
  xya jdField_a_of_type_Xya;
  xyb jdField_a_of_type_Xyb;
  protected xyc a;
  private xzv jdField_a_of_type_Xzv = new xxt(this);
  public ydu a;
  private yfx jdField_a_of_type_Yfx = new xxx(this);
  protected ygb a;
  public boolean a;
  protected byte[] a;
  private final int b;
  public boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = vkm.e;
  }
  
  public xxs(@NonNull xzd paramxzd, int paramInt)
  {
    super(paramxzd);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRunnable = new EditVideoDoodle.4(this);
    this.jdField_a_of_type_Ydu = new xxw(this);
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
      this.jdField_a_of_type_Xyc.a(a());
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
      xvv.d("Q.qqstory.publish.edit.StoryDoodle", "delete file : " + bool);
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      xvv.d("Q.qqstory.publish.edit.StoryDoodle", "create folder : " + bool);
    }
  }
  
  private void j()
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      xvv.b("Q.qqstory.publish.edit.StoryDoodle", "makeSureInitLayout");
      localObject1 = this.jdField_a_of_type_AndroidViewViewStub.getParent();
      if ((localObject1 == null) || (!(localObject1 instanceof ViewGroup))) {
        break label459;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
      if (!xzd.a(this.jdField_b_of_type_Int, 4)) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.i();
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(720, 1280);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setDownloadListener(this.jdField_a_of_type_Yfx);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setAdapter(this.jdField_a_of_type_Xyc);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicSize(16);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicStandardSize(this.jdField_a_of_type_Xzd.a.mEditSource.getWidth(), this.jdField_a_of_type_Xzd.a.mEditSource.getHeight());
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleEventListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBtnOperationHelper(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditVideoParams(this.jdField_a_of_type_Xzd.a);
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a;
      if (localObject1 != null) {
        ((DoodleEditView)localObject1).setDoodleEditViewListener(new xxu(this));
      }
      if ((this.jdField_a_of_type_Xzd.a.mBusinessId == 10) || (this.jdField_a_of_type_Xzd.a.mBusinessId == 12))
      {
        if (!(this.jdField_a_of_type_Xzd.a.mEditSource instanceof EditTakeVideoSource)) {
          break label476;
        }
        int i = yqs.b(this.jdField_a_of_type_Xzd.a.mEditSource.getSourcePath());
        if ((i == 270) || (i == 90))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(1280, this.jdField_a_of_type_Xzd.a.mEditSource.getWidth() * 1280 / this.jdField_a_of_type_Xzd.a.mEditSource.getHeight());
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((int)DeviceInfoUtil.getWidth(), (int)(DeviceInfoUtil.getWidth() * this.jdField_a_of_type_Xzd.a.mEditSource.getWidth() / this.jdField_a_of_type_Xzd.a.mEditSource.getHeight()));
        }
      }
    }
    for (;;)
    {
      localObject1 = vli.a();
      Object localObject2 = new xya(this);
      this.jdField_a_of_type_Xya = ((xya)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      localObject1 = vli.a();
      localObject2 = new xxz(this);
      this.jdField_a_of_type_Xxz = ((xxz)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      localObject1 = vli.a();
      localObject2 = new xyb(this);
      this.jdField_a_of_type_Xyb = ((xyb)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      return;
      label459:
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)a(2131365709));
      break;
      label476:
      if ((this.jdField_a_of_type_Xzd.a.mEditSource instanceof EditLocalVideoSource))
      {
        localObject1 = (EditLocalVideoSource)this.jdField_a_of_type_Xzd.a.mEditSource;
        if ((((EditLocalVideoSource)localObject1).getWidth() * 1.0F / ((EditLocalVideoSource)localObject1).getHeight() >= (float)DeviceInfoUtil.getWidth() * 1.0F / (float)DeviceInfoUtil.getHeight()) && (((EditLocalVideoSource)localObject1).a.rotation == 0))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(1280, this.jdField_a_of_type_Xzd.a.mEditSource.getHeight() * 1280 / this.jdField_a_of_type_Xzd.a.mEditSource.getWidth());
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((int)DeviceInfoUtil.getWidth(), (int)(DeviceInfoUtil.getWidth() * this.jdField_a_of_type_Xzd.a.mEditSource.getHeight() / this.jdField_a_of_type_Xzd.a.mEditSource.getWidth()));
        }
        else if ((((EditLocalVideoSource)localObject1).getWidth() * 1.0F / ((EditLocalVideoSource)localObject1).getHeight() < 1.0F) && ((((EditLocalVideoSource)localObject1).a.rotation == 90) || (((EditLocalVideoSource)localObject1).a.rotation == 270)))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(1280, this.jdField_a_of_type_Xzd.a.mEditSource.getHeight() * 1280 / this.jdField_a_of_type_Xzd.a.mEditSource.getWidth());
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((int)DeviceInfoUtil.getWidth(), (int)(DeviceInfoUtil.getWidth() * this.jdField_a_of_type_Xzd.a.mEditSource.getWidth() / this.jdField_a_of_type_Xzd.a.mEditSource.getHeight()));
        }
      }
    }
  }
  
  private void k()
  {
    new babh(this.jdField_a_of_type_Yan.getActivity(), new xxv(this)).a();
  }
  
  public void Q_()
  {
    super.Q_();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.g();
  }
  
  public void S_()
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
  
  public JobSegment<yjh, yjh> a(int paramInt)
  {
    if (((this.jdField_a_of_type_Xzd.a.mEditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_Xzd.a.mEditSource instanceof EditLocalVideoSource))) {
      return new yjr(this, (xwk)a(xwk.class), paramInt);
    }
    return new yji(this, (xwk)a(xwk.class), paramInt);
  }
  
  @NonNull
  protected Collection<yfy> a()
  {
    Object localObject = ((ydh)vux.a(8)).a();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ydg localydg = (ydg)((Iterator)localObject).next();
      xvv.b("Q.qqstory.publish.edit.StoryDoodle", "add doodle emoji item = " + localydg);
      if (localydg.jdField_a_of_type_Int == 1)
      {
        yge localyge = new yge(localydg.jdField_a_of_type_JavaLangString);
        localyge.b = localydg.d;
        localyge.c = localydg.b;
        localyge.d = localydg.c;
        localyge.f = localydg.a();
        localyge.a(localydg.f);
        if (("1".equals(localyge.jdField_a_of_type_JavaLangString)) && (!NetworkUtil.isNetworkAvailable(a()))) {
          localyge.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getDrawable(2130846375);
        }
        localArrayList.add(localyge);
      }
      else if (localydg.jdField_a_of_type_Int == 2)
      {
        if ((!TextUtils.isEmpty(localydg.b)) && (NetworkUtil.isNetworkAvailable(a()))) {
          this.jdField_a_of_type_Ygb.c = localydg.b;
        }
        for (;;)
        {
          localArrayList.add(this.jdField_a_of_type_Ygb);
          break;
          this.jdField_a_of_type_Ygb.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getDrawable(2130846518);
        }
      }
    }
    xvv.b("Q.qqstory.publish.edit.StoryDoodle", "getDoodleFacePackages, size = " + localArrayList.size());
    return localArrayList;
  }
  
  public void a()
  {
    b(jdField_a_of_type_JavaLangString);
    QQStoryContext.a();
    Object localObject1 = QQStoryContext.a();
    PtvTemplateManager.a((AppInterface)localObject1).a((AppInterface)localObject1, this.jdField_a_of_type_Bbpx, false);
    Object localObject2 = (ydh)vux.a(8);
    ((ydh)localObject2).a(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131365710));
    this.jdField_a_of_type_Xyc = new xyc(null);
    if (this.jdField_a_of_type_Ygb == null)
    {
      this.jdField_a_of_type_Ygb = new ygb("Location-Package");
      this.jdField_a_of_type_Ygb.jdField_a_of_type_Boolean = true;
      localObject1 = ydh.c((ydh)localObject2, "0");
      localObject2 = ydh.a((ydh)localObject2, "0");
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!NetworkUtil.isNetworkAvailable(a()))) {
        break label156;
      }
      this.jdField_a_of_type_Ygb.c = ((String)localObject2);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ygb.a((String)localObject1);
      a(xwj.class, this);
      return;
      label156:
      this.jdField_a_of_type_Ygb.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a().getDrawable(2130846518);
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
  
  public void a(int paramInt, @NonNull yjh paramyjh)
  {
    super.a(paramInt, paramyjh);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      xvv.d("Q.qqstory.publish.edit.StoryDoodle", "editVideoPrePublish but doodle layout is null");
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.c();
    paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription = a().a(paramInt);
    paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mMosaicMask = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramInt);
    paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mMosaicSize = 16;
    Object localObject1 = a().b(paramInt);
    if (((List)localObject1).size() == 1) {
      paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoLocationDescription = ((ycd)((List)localObject1).get(0)).a();
    }
    Object localObject2;
    label202:
    int i;
    label261:
    Object localObject3;
    int j;
    if (a().b(paramInt))
    {
      localObject2 = this.jdField_a_of_type_Xzd;
      if (this.jdField_a_of_type_Xzd.a())
      {
        localObject1 = "2";
        ((xzd)localObject2).a("change_graffiti", 0, 0, new String[] { localObject1 });
        xwb.a("0X80076C0");
      }
    }
    else
    {
      if (a().a(paramInt))
      {
        localObject2 = this.jdField_a_of_type_Xzd;
        if (!this.jdField_a_of_type_Xzd.a()) {
          break label690;
        }
        localObject1 = "2";
        ((xzd)localObject2).a("change_color", 0, 0, new String[] { localObject1 });
        xwb.a("0X80076C4");
      }
      if ((!(this.jdField_a_of_type_Xzd.a.mEditSource instanceof EditTakePhotoSource)) && (!(this.jdField_a_of_type_Xzd.a.mEditSource instanceof EditLocalPhotoSource))) {
        break label698;
      }
      i = 1;
      localObject2 = a().a(paramInt);
      if ((localObject2 != null) && (localObject2.length == 2))
      {
        if (localObject2[0] <= 0) {
          break label711;
        }
        localObject3 = this.jdField_a_of_type_Xzd;
        j = this.jdField_a_of_type_Xzd.b();
        if (!this.jdField_a_of_type_Xzd.a()) {
          break label703;
        }
        localObject1 = "2";
        label320:
        ((xzd)localObject3).b("pub_graffiti", j, 0, new String[] { "1", "", localObject1 });
        xwb.a("0X80076E0", xwb.jdField_b_of_type_Int);
        xwb.b("0X80075EA", xwb.jdField_a_of_type_Int);
        paramyjh.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
        paramyjh.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasGraffiti = true;
        label392:
        if (localObject2[1] <= 0) {
          break label742;
        }
        localObject3 = this.jdField_a_of_type_Xzd;
        j = this.jdField_a_of_type_Xzd.b();
        if (!this.jdField_a_of_type_Xzd.a()) {
          break label734;
        }
        localObject1 = "2";
        label429:
        ((xzd)localObject3).b("pub_mosaics", j, 0, new String[] { "1", "", localObject1 });
        xwb.a("0X80076E1");
        xwb.b("0X80075EB");
        paramyjh.jdField_b_of_type_Boolean = true;
        if (localObject2[0] == 0) {
          paramyjh.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
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
      if ((i == 0) || (!yjl.a(0))) {
        break label392;
      }
      xwb.b("0X80075EA", xwb.jdField_a_of_type_Int);
      break label392;
      label734:
      localObject1 = "1";
      break label429;
      label742:
      if ((i != 0) && (yjl.a(1))) {
        xwb.b("0X80075EB");
      }
    }
    if (((StringBuilder)localObject3).length() > 0) {
      ((StringBuilder)localObject3).deleteCharAt(((StringBuilder)localObject3).length() - 1);
    }
    xvv.a("Q.qqstory.publish.edit.StoryDoodle", "faceReportString = %s", localObject3);
    Object localObject4 = new StringBuilder();
    if (((List)localObject1).size() > 0)
    {
      localObject5 = ((List)localObject1).iterator();
      while (((Iterator)localObject5).hasNext()) {
        ((StringBuilder)localObject4).append(((ycd)((Iterator)localObject5).next()).e).append(',');
      }
      ((StringBuilder)localObject4).deleteCharAt(((StringBuilder)localObject4).length() - 1);
      ((ycd)((List)localObject1).get(0)).a();
    }
    xvv.a("Q.qqstory.publish.edit.StoryDoodle", "poiReportString = %s", localObject4);
    if (localObject2[0] > 0)
    {
      localObject5 = this.jdField_a_of_type_Xzd;
      j = this.jdField_a_of_type_Xzd.b();
      int k = localObject2[0];
      localObject6 = ((StringBuilder)localObject3).toString();
      if (this.jdField_a_of_type_Xzd.a())
      {
        localObject1 = "2";
        label946:
        ((xzd)localObject5).b("pub_face", j, 0, new String[] { String.valueOf(k), localObject6, localObject1 });
        xwb.a("0X80076E3", xwb.jdField_b_of_type_Int);
        xwb.b("0X80075ED", xwb.jdField_a_of_type_Int);
        paramyjh.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
        paramyjh.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject3).toString();
        label1023:
        if (localObject2[1] <= 0) {
          break label1432;
        }
        this.jdField_a_of_type_Xzd.b("pub_poi", this.jdField_a_of_type_Xzd.b(), 0, new String[] { String.valueOf(localObject2[1]), ((StringBuilder)localObject4).toString() });
        xwb.a("0X80076E4");
        xwb.b("0X80075EE");
        if (localObject2[0] <= 0) {
          break label1403;
        }
        paramyjh.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = (paramyjh.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 + "," + ((StringBuilder)localObject4).toString());
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
        localObject3 = this.jdField_a_of_type_Xzd;
        i = this.jdField_a_of_type_Xzd.b();
        if (!this.jdField_a_of_type_Xzd.a()) {
          break label1458;
        }
        localObject1 = "2";
        label1185:
        ((xzd)localObject3).b("pub_text", i, 0, new String[] { "1", localObject2, localObject1 });
        xwb.a("0X80076E2", xwb.jdField_b_of_type_Int);
        xwb.b("0X80075EC", xwb.jdField_a_of_type_Int);
        paramyjh.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("3");
        paramyjh.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasText = true;
      }
    }
    for (;;)
    {
      localObject2 = a().a(paramInt);
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break;
      }
      paramyjh = "";
      paramInt = 0;
      while (paramInt < ((List)localObject2).size())
      {
        localObject1 = paramyjh + (String)((List)localObject2).get(paramInt);
        paramyjh = (yjh)localObject1;
        if (paramInt != ((List)localObject2).size() - 1) {
          paramyjh = (String)localObject1 + ",";
        }
        paramInt += 1;
      }
      localObject1 = "1";
      break label946;
      if ((i == 0) || (!yjl.a(2))) {
        break label1023;
      }
      xwb.b("0X80075ED", xwb.jdField_a_of_type_Int);
      break label1023;
      label1403:
      paramyjh.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
      paramyjh.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject4).toString();
      break label1130;
      label1432:
      if ((i == 0) || (!yjl.a(3))) {
        break label1130;
      }
      xwb.b("0X80075EE");
      break label1130;
      label1452:
      j = 0;
      break label1151;
      label1458:
      localObject1 = "1";
      break label1185;
      label1466:
      if ((i != 0) && (yjl.a(4))) {
        xwb.b("0X80075EC", xwb.jdField_a_of_type_Int);
      }
    }
    this.jdField_a_of_type_Xzd.b("person_gra", this.jdField_a_of_type_Xzd.b(), 0, new String[] { paramyjh });
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramBitmap);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Xzd.a.getEnableHWEncode())
    {
      xzp localxzp = (xzp)a(xzp.class);
      if (localxzp != null) {
        localxzp.a(paramBitmap, paramBoolean);
      }
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    a().a(paramMotionEvent);
  }
  
  public void a(Animation paramAnimation)
  {
    this.jdField_a_of_type_Xzd.a(paramAnimation);
  }
  
  public void a(String paramString)
  {
    xzd localxzd = this.jdField_a_of_type_Xzd;
    if (this.jdField_a_of_type_Xzd.a()) {}
    for (String str = "2";; str = "1")
    {
      localxzd.a("exp_editpoi", 0, 0, new String[] { str });
      xwb.a("0X80076CF");
      xwb.b("0X80075E4");
      paramString = new xyd(this.jdField_a_of_type_Xzv, paramString);
      this.jdField_a_of_type_Xzd.a(3, paramString);
      return;
    }
  }
  
  public void a(ygc paramygc)
  {
    if (this.jdField_a_of_type_Xzd.a.mBusinessId == 1) {
      ((vuq)vux.a(10)).b("has_show_add_poi_paster_guide", Boolean.valueOf(true));
    }
    boolean bool = this.jdField_a_of_type_Xzd.b(6);
    if (this.jdField_a_of_type_Xzd.a())
    {
      paramygc = "2";
      if (!bool) {
        break label107;
      }
    }
    label107:
    for (String str = "1";; str = "0")
    {
      xwa.a("video_edit", "add_place", 0, 0, new String[] { paramygc, "", str, "" });
      return;
      paramygc = "1";
      break;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (!this.jdField_a_of_type_Xzd.a.isEditPhoto())
    {
      this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      VideoSourceHelper.nativeSetMosaic(16, this.jdField_a_of_type_ArrayOfByte);
      xzp localxzp = (xzp)a(xzp.class);
      if (localxzp != null) {
        localxzp.a(16, paramArrayOfByte);
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
      this.jdField_a_of_type_Xzd.a(0);
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
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(this.jdField_a_of_type_Xzd.a());
    switch (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c())
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Xzd.a(0);
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
    return this.jdField_a_of_type_Xzd.a();
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
    QQToast.a(a(), amtj.a(2131702844), 0).a();
  }
  
  public void b(int paramInt, Object paramObject)
  {
    xvv.b("Q.qqstory.publish.edit.StoryDoodle", "onStateChanged : " + paramInt);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return;
    }
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
      if ((this.jdField_a_of_type_Xzd.a(13)) || (this.jdField_a_of_type_Xzd.a(14)) || (this.jdField_a_of_type_Xzd.a(15)) || (this.jdField_a_of_type_Xzd.a(16)))
      {
        xvv.d("Q.qqstory.publish.edit.StoryDoodle", "do nothing because edit ui is showing the guide");
        return;
      }
      this.jdField_a_of_type_Xzd.a(0);
      return;
    case 2: 
      this.jdField_a_of_type_Xzd.a(7, paramObject);
      return;
    case 3: 
      this.jdField_a_of_type_Xzd.a(5);
      return;
    case 4: 
      this.jdField_a_of_type_Xzd.a(9);
      return;
    case 5: 
      this.jdField_a_of_type_Xzd.a(8, paramObject);
      return;
    }
    this.jdField_a_of_type_Xzd.a(8);
  }
  
  public void b(Animation paramAnimation)
  {
    this.jdField_a_of_type_Xzd.b(paramAnimation);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a());
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Xya != null) {
      vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xya);
    }
    if (this.jdField_a_of_type_Xxz != null) {
      vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xxz);
    }
    if (this.jdField_a_of_type_Xyb != null) {
      vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xyb);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setDownloadListener(null);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = null;
    }
    this.jdField_a_of_type_Xyc = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public boolean e_()
  {
    if ((xzd.a(this.jdField_b_of_type_Int, 4)) && (TextUtils.isEmpty(a().a(this.jdField_a_of_type_Xzd.a()))))
    {
      if (this.jdField_a_of_type_Xzd.a.mBusinessId != 2) {
        this.jdField_a_of_type_Xzd.a(5);
      }
      do
      {
        return true;
        if (this.jdField_a_of_type_Xzd.jdField_b_of_type_Int == 0)
        {
          this.jdField_a_of_type_Xzd.a(27);
          return true;
        }
      } while (this.jdField_a_of_type_Xzd.jdField_b_of_type_Int != 27);
      this.jdField_a_of_type_Xzd.a(0);
      return true;
    }
    return false;
  }
  
  public void f()
  {
    super.f();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Yan.a().postDelayed(new EditVideoDoodle.7(this), 200L);
  }
  
  public void h()
  {
    this.jdField_a_of_type_Xzd.d();
  }
  
  public void i()
  {
    this.jdField_a_of_type_Xzd.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxs
 * JD-Core Version:    0.7.0.1
 */