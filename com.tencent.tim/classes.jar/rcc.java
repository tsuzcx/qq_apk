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
import com.tencent.biz.qqstory.base.ErrorMessage;
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
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.a;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.b;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage.a;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.a;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.async.JobSegment;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
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

public class rcc
  extends rdb
  implements DoodleLayout.a, DoodleLayout.b, IEventReceiver, rba
{
  public static final String azB = plr.atc;
  protected DoodleLayout a;
  private FaceListPage.a jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$a = new rch(this);
  PtvTemplateManager.a jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$a = new rci(this);
  rcc.a jdField_a_of_type_Rcc$a;
  rcc.b jdField_a_of_type_Rcc$b;
  rcc.c jdField_a_of_type_Rcc$c;
  protected rcc.d a;
  private rdu jdField_a_of_type_Rdu = new rcd(this);
  public rgp.e a;
  protected rim a;
  public boolean aGP;
  public boolean aGQ;
  protected Handler bn = new Handler(Looper.getMainLooper());
  private final int bpV;
  public int bpW = 1;
  protected Runnable du = new EditVideoDoodle.4(this);
  protected byte[] mMosaicMask;
  private ViewStub y;
  
  public rcc(@NonNull rdc paramrdc, int paramInt)
  {
    super(paramrdc);
    this.jdField_a_of_type_Rgp$e = new rcg(this);
    this.bpV = paramInt;
  }
  
  private void bsC()
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      ram.d("Q.qqstory.publish.edit.StoryDoodle", "makeSureInitLayout");
      localObject1 = this.y.getParent();
      if ((localObject1 == null) || (!(localObject1 instanceof ViewGroup))) {
        break label459;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)this.y.inflate());
      if (!rdc.al(this.bpV, 4)) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.bul();
      }
      this.aGQ = true;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(720, 1280);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setDownloadListener(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$a);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setAdapter(this.jdField_a_of_type_Rcc$d);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicSize(16);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicStandardSize(this.b.a.a.getWidth(), this.b.a.a.getHeight());
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleEventListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBtnOperationHelper(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setEditVideoParams(this.b.a);
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a;
      if (localObject1 != null) {
        ((DoodleEditView)localObject1).setDoodleEditViewListener(new rce(this));
      }
      if ((this.b.a.asi == 10) || (this.b.a.asi == 12))
      {
        if (!(this.b.a.a instanceof EditTakeVideoSource)) {
          break label476;
        }
        int i = rpv.getRotation(this.b.a.a.getSourcePath());
        if ((i == 270) || (i == 90))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(1280, this.b.a.a.getWidth() * 1280 / this.b.a.a.getHeight());
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.ej((int)aqgz.getWidth(), (int)(aqgz.getWidth() * this.b.a.a.getWidth() / this.b.a.a.getHeight()));
        }
      }
    }
    for (;;)
    {
      localObject1 = pmi.a();
      Object localObject2 = new rcc.b(this);
      this.jdField_a_of_type_Rcc$b = ((rcc.b)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      localObject1 = pmi.a();
      localObject2 = new rcc.a(this);
      this.jdField_a_of_type_Rcc$a = ((rcc.a)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      localObject1 = pmi.a();
      localObject2 = new rcc.c(this);
      this.jdField_a_of_type_Rcc$c = ((rcc.c)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      return;
      label459:
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)y(2131366036));
      break;
      label476:
      if ((this.b.a.a instanceof EditLocalVideoSource))
      {
        localObject1 = (EditLocalVideoSource)this.b.a.a;
        if ((((EditLocalVideoSource)localObject1).getWidth() * 1.0F / ((EditLocalVideoSource)localObject1).getHeight() >= (float)aqgz.getWidth() * 1.0F / (float)aqgz.getHeight()) && (((EditLocalVideoSource)localObject1).d.rotation == 0))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(1280, this.b.a.a.getHeight() * 1280 / this.b.a.a.getWidth());
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.ej((int)aqgz.getWidth(), (int)(aqgz.getWidth() * this.b.a.a.getHeight() / this.b.a.a.getWidth()));
        }
        else if ((((EditLocalVideoSource)localObject1).getWidth() * 1.0F / ((EditLocalVideoSource)localObject1).getHeight() < 1.0F) && ((((EditLocalVideoSource)localObject1).d.rotation == 90) || (((EditLocalVideoSource)localObject1).d.rotation == 270)))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(1280, this.b.a.a.getHeight() * 1280 / this.b.a.a.getWidth());
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.ej((int)aqgz.getWidth(), (int)(aqgz.getWidth() * this.b.a.a.getWidth() / this.b.a.a.getHeight()));
        }
      }
    }
  }
  
  private void bsD()
  {
    new alxd(this.jdField_a_of_type_Rel.getActivity(), new rcf(this)).Qj();
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
      } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getVisibility() == paramInt);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setVisibility(paramInt);
      this.jdField_a_of_type_Rcc$d.e(b());
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleGLViewVisibility(paramInt);
      return;
    } while ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getVisibility() == paramInt));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setVisibility(paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleGLViewVisibility(paramInt);
  }
  
  public boolean G(MotionEvent paramMotionEvent)
  {
    return a().G(paramMotionEvent);
  }
  
  public void K(MotionEvent paramMotionEvent)
  {
    a().K(paramMotionEvent);
  }
  
  public boolean KS()
  {
    if ((rdc.al(this.bpV, 4)) && (TextUtils.isEmpty(a().cb(this.b.tj()))))
    {
      if (this.b.a.asi != 2) {
        this.b.changeState(5);
      }
      do
      {
        return true;
        if (this.b.bqq == 0)
        {
          this.b.changeState(27);
          return true;
        }
      } while (this.b.bqq != 27);
      this.b.changeState(0);
      return true;
    }
    return false;
  }
  
  public void S(byte[] paramArrayOfByte)
  {
    if (!this.b.a.La())
    {
      this.mMosaicMask = paramArrayOfByte;
      VideoSourceHelper.nativeSetMosaic(16, this.mMosaicMask);
      rdo localrdo = (rdo)a(rdo.class);
      if (localrdo != null) {
        localrdo.h(16, paramArrayOfByte);
      }
    }
  }
  
  public Bitmap U()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.U();
  }
  
  public Bitmap W()
  {
    return this.b.W();
  }
  
  @NonNull
  public DoodleLayout a()
  {
    bsC();
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  }
  
  public JobSegment<rkm, rkm> a(int paramInt)
  {
    if (((this.b.a.a instanceof EditTakeVideoSource)) || ((this.b.a.a instanceof EditLocalVideoSource))) {
      return new rkw(this, (rbb)a(rbb.class), paramInt);
    }
    return new rkn(this, (rbb)a(rbb.class), paramInt);
  }
  
  public void a(int paramInt, @NonNull rkm paramrkm)
  {
    super.a(paramInt, paramrkm);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      ram.w("Q.qqstory.publish.edit.StoryDoodle", "editVideoPrePublish but doodle layout is null");
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.bue();
    paramrkm.g.videoDoodleDescription = a().cb(paramInt);
    paramrkm.g.mMosaicMask = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.f(paramInt);
    paramrkm.g.mMosaicSize = 16;
    Object localObject1 = a().B(paramInt);
    if (((List)localObject1).size() == 1) {
      paramrkm.g.videoLocationDescription = ((rft.a)((List)localObject1).get(0)).getText();
    }
    Object localObject2;
    label202:
    int i;
    label261:
    Object localObject3;
    int j;
    if (a().eR(paramInt))
    {
      localObject2 = this.b;
      if (this.b.La())
      {
        localObject1 = "2";
        ((rdc)localObject2).c("change_graffiti", 0, 0, new String[] { localObject1 });
        ras.so("0X80076C0");
      }
    }
    else
    {
      if (a().eQ(paramInt))
      {
        localObject2 = this.b;
        if (!this.b.La()) {
          break label690;
        }
        localObject1 = "2";
        ((rdc)localObject2).c("change_color", 0, 0, new String[] { localObject1 });
        ras.so("0X80076C4");
      }
      if ((!(this.b.a.a instanceof EditTakePhotoSource)) && (!(this.b.a.a instanceof EditLocalPhotoSource))) {
        break label698;
      }
      i = 1;
      localObject2 = a().g(paramInt);
      if ((localObject2 != null) && (localObject2.length == 2))
      {
        if (localObject2[0] <= 0) {
          break label711;
        }
        localObject3 = this.b;
        j = this.b.tk();
        if (!this.b.La()) {
          break label703;
        }
        localObject1 = "2";
        label320:
        ((rdc)localObject3).d("pub_graffiti", j, 0, new String[] { "1", "", localObject1 });
        ras.bv("0X80076E0", ras.bpq);
        ras.bw("0X80075EA", ras.bpo);
        paramrkm.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
        paramrkm.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasGraffiti = true;
        label392:
        if (localObject2[1] <= 0) {
          break label742;
        }
        localObject3 = this.b;
        j = this.b.tk();
        if (!this.b.La()) {
          break label734;
        }
        localObject1 = "2";
        label429:
        ((rdc)localObject3).d("pub_mosaics", j, 0, new String[] { "1", "", localObject1 });
        ras.so("0X80076E1");
        ras.sp("0X80075EB");
        paramrkm.aIB = true;
        if (localObject2[0] == 0) {
          paramrkm.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("1");
        }
      }
    }
    Object localObject5;
    Object localObject6;
    for (;;)
    {
      localObject2 = a().h(paramInt);
      if ((localObject2 == null) || (localObject2.length != 2)) {
        break label1130;
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
      if ((i == 0) || (!rkq.eV(0))) {
        break label392;
      }
      ras.bw("0X80075EA", ras.bpo);
      break label392;
      label734:
      localObject1 = "1";
      break label429;
      label742:
      if ((i != 0) && (rkq.eV(1))) {
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
      localObject5 = ((List)localObject1).iterator();
      while (((Iterator)localObject5).hasNext()) {
        ((StringBuilder)localObject4).append(((rft.a)((Iterator)localObject5).next()).name).append(',');
      }
      ((StringBuilder)localObject4).deleteCharAt(((StringBuilder)localObject4).length() - 1);
      ((rft.a)((List)localObject1).get(0)).getText();
    }
    ram.b("Q.qqstory.publish.edit.StoryDoodle", "poiReportString = %s", localObject4);
    if (localObject2[0] > 0)
    {
      localObject5 = this.b;
      j = this.b.tk();
      int k = localObject2[0];
      localObject6 = ((StringBuilder)localObject3).toString();
      if (this.b.La())
      {
        localObject1 = "2";
        label946:
        ((rdc)localObject5).d("pub_face", j, 0, new String[] { String.valueOf(k), localObject6, localObject1 });
        ras.bv("0X80076E3", ras.bpq);
        ras.bw("0X80075ED", ras.bpo);
        paramrkm.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
        paramrkm.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject3).toString();
        label1023:
        if (localObject2[1] <= 0) {
          break label1432;
        }
        this.b.d("pub_poi", this.b.tk(), 0, new String[] { String.valueOf(localObject2[1]), ((StringBuilder)localObject4).toString() });
        ras.so("0X80076E4");
        ras.sp("0X80075EE");
        if (localObject2[0] <= 0) {
          break label1403;
        }
        paramrkm.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = (paramrkm.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 + "," + ((StringBuilder)localObject4).toString());
        label1130:
        localObject2 = a().cb(paramInt);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1452;
        }
        j = 1;
        label1151:
        if (j == 0) {
          break label1466;
        }
        localObject3 = this.b;
        i = this.b.tk();
        if (!this.b.La()) {
          break label1458;
        }
        localObject1 = "2";
        label1185:
        ((rdc)localObject3).d("pub_text", i, 0, new String[] { "1", localObject2, localObject1 });
        ras.bv("0X80076E2", ras.bpq);
        ras.bw("0X80075EC", ras.bpo);
        paramrkm.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("3");
        paramrkm.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.hasText = true;
      }
    }
    for (;;)
    {
      localObject2 = a().A(paramInt);
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break;
      }
      paramrkm = "";
      paramInt = 0;
      while (paramInt < ((List)localObject2).size())
      {
        localObject1 = paramrkm + (String)((List)localObject2).get(paramInt);
        paramrkm = (rkm)localObject1;
        if (paramInt != ((List)localObject2).size() - 1) {
          paramrkm = (String)localObject1 + ",";
        }
        paramInt += 1;
      }
      localObject1 = "1";
      break label946;
      if ((i == 0) || (!rkq.eV(2))) {
        break label1023;
      }
      ras.bw("0X80075ED", ras.bpo);
      break label1023;
      label1403:
      paramrkm.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("4");
      paramrkm.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves6 = ((StringBuilder)localObject4).toString();
      break label1130;
      label1432:
      if ((i == 0) || (!rkq.eV(3))) {
        break label1130;
      }
      ras.sp("0X80075EE");
      break label1130;
      label1452:
      j = 0;
      break label1151;
      label1458:
      localObject1 = "1";
      break label1185;
      label1466:
      if ((i != 0) && (rkq.eV(4))) {
        ras.bw("0X80075EC", ras.bpo);
      }
    }
    this.b.d("person_gra", this.b.tk(), 0, new String[] { paramrkm });
  }
  
  public void a(rim.a parama)
  {
    if (this.b.a.asi == 1) {
      ((psr)psx.a(10)).n("has_show_add_poi_paster_guide", Boolean.valueOf(true));
    }
    boolean bool = this.b.eP(6);
    if (this.b.La())
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
  
  @NonNull
  protected Collection<rik> b()
  {
    Object localObject = ((rgp)psx.a(8)).cd();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      rgo localrgo = (rgo)((Iterator)localObject).next();
      ram.d("Q.qqstory.publish.edit.StoryDoodle", "add doodle emoji item = " + localrgo);
      if (localrgo.mItemType == 1)
      {
        rin localrin = new rin(localrgo.awr);
        localrin.name = localrgo.awu;
        localrin.logoUrl = localrgo.aws;
        localrin.aAD = localrgo.awt;
        localrin.aAG = localrgo.getLocalEmojiFolderPath();
        localrin.sz(localrgo.awx);
        if (("1".equals(localrin.id)) && (!aqiw.isNetworkAvailable(getContext()))) {
          localrin.C = getResources().getDrawable(2130847332);
        }
        localArrayList.add(localrin);
      }
      else if (localrgo.mItemType == 2)
      {
        if ((!TextUtils.isEmpty(localrgo.aws)) && (aqiw.isNetworkAvailable(getContext()))) {
          this.jdField_a_of_type_Rim.logoUrl = localrgo.aws;
        }
        for (;;)
        {
          localArrayList.add(this.jdField_a_of_type_Rim);
          break;
          this.jdField_a_of_type_Rim.C = getResources().getDrawable(2130847475);
        }
      }
    }
    ram.d("Q.qqstory.publish.edit.StoryDoodle", "getDoodleFacePackages, size = " + localArrayList.size());
    return localArrayList;
  }
  
  public void brZ()
  {
    if (this.aGQ) {
      a().brZ();
    }
  }
  
  public void bsE()
  {
    this.jdField_a_of_type_Rel.getRootView().postDelayed(new EditVideoDoodle.7(this), 200L);
  }
  
  public void bsF()
  {
    this.b.bsF();
  }
  
  public void bsa()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setCurrentItem(1);
  }
  
  public void c(Animation paramAnimation)
  {
    this.b.e(paramAnimation);
  }
  
  public void close()
  {
    this.b.bsV();
  }
  
  public void d(int paramInt1, int paramInt2, Object paramObject)
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
            return;
            setVisibility(4);
            return;
            setVisibility(0);
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.resetUI();
            return;
            setVisibility(0);
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.resetUI();
            return;
          } while (paramInt1 == 9);
          bsC();
          if ((paramObject != null) && (paramObject == Boolean.TRUE)) {
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.xr(2);
          }
          for (;;)
          {
            setVisibility(0);
            return;
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.xr(1);
          }
        } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.resetUI();
        return;
        setVisibility(8);
        return;
      } while (paramInt1 == 9);
      bsD();
      bsC();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.buh();
      setVisibility(0);
      return;
    } while (paramInt1 == 8);
    bsC();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.bui();
    setVisibility(0);
  }
  
  public void d(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.b.a.Lg())
    {
      rdo localrdo = (rdo)a(rdo.class);
      if (localrdo != null) {
        localrdo.c(paramBitmap, paramBoolean);
      }
    }
  }
  
  public void d(Animation paramAnimation)
  {
    this.b.f(paramAnimation);
  }
  
  public void dZ(int paramInt1, int paramInt2)
  {
    a().ej(paramInt1, paramInt2);
  }
  
  public Bitmap e(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e(paramInt);
  }
  
  protected boolean e(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.e(paramMessage);
    }
    setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.xp(this.b.tj());
    switch (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getCurrentState())
    {
    }
    for (;;)
    {
      return true;
      this.b.changeState(0);
    }
  }
  
  public void eb(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 2: 
    case 3: 
    default: 
      return;
    }
    QQToast.a(getContext(), acfp.m(2131705487), 0).show();
  }
  
  public int ed(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.ed(paramInt);
  }
  
  public byte[] f(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.f(paramInt);
    }
    return null;
  }
  
  public boolean isEmpty()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.isEmpty());
  }
  
  public boolean onBackPressed()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getVisibility() == 0)) {}
    switch (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getCurrentState())
    {
    default: 
      bool = false;
    case 4: 
    case 5: 
      return bool;
    case 1: 
    case 2: 
    case 3: 
      this.b.changeState(0);
      return true;
    case 0: 
      return false;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.aUp();
    return true;
  }
  
  public void onCreate()
  {
    rp(azB);
    QQStoryContext.a();
    Object localObject1 = QQStoryContext.c();
    PtvTemplateManager.a((AppInterface)localObject1).a((AppInterface)localObject1, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$a, false);
    Object localObject2 = (rgp)psx.a(8);
    ((rgp)localObject2).cG(BaseApplicationImpl.getApplication());
    this.y = ((ViewStub)y(2131366037));
    this.jdField_a_of_type_Rcc$d = new rcc.d(null);
    if (this.jdField_a_of_type_Rim == null)
    {
      this.jdField_a_of_type_Rim = new rim("Location-Package");
      this.jdField_a_of_type_Rim.aIg = true;
      localObject1 = rgp.c((rgp)localObject2, "0");
      localObject2 = rgp.a((rgp)localObject2, "0");
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!aqiw.isNetworkAvailable(getContext()))) {
        break label156;
      }
      this.jdField_a_of_type_Rim.logoUrl = ((String)localObject2);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rim.sz((String)localObject1);
      a(rba.class, this);
      return;
      label156:
      this.jdField_a_of_type_Rim.C = getResources().getDrawable(2130847475);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Rcc$b != null) {
      pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Rcc$b);
    }
    if (this.jdField_a_of_type_Rcc$a != null) {
      pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Rcc$a);
    }
    if (this.jdField_a_of_type_Rcc$c != null) {
      pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Rcc$c);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setDownloadListener(null);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = null;
    }
    this.jdField_a_of_type_Rcc$d = null;
    this.bn.removeCallbacks(this.du);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.onResume();
  }
  
  public void q(int paramInt, Object paramObject)
  {
    ram.d("Q.qqstory.publish.edit.StoryDoodle", "onStateChanged : " + paramInt);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return;
    }
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
      if ((this.b.eO(13)) || (this.b.eO(14)) || (this.b.eO(15)) || (this.b.eO(16)))
      {
        ram.w("Q.qqstory.publish.edit.StoryDoodle", "do nothing because edit ui is showing the guide");
        return;
      }
      this.b.changeState(0);
      return;
    case 2: 
      this.b.r(7, paramObject);
      return;
    case 3: 
      this.b.changeState(5);
      return;
    case 4: 
      this.b.changeState(9);
      return;
    case 5: 
      this.b.r(8, paramObject);
      return;
    }
    this.b.changeState(8);
  }
  
  public void s(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.s(paramBitmap);
    }
  }
  
  public void ss(String paramString)
  {
    rdc localrdc = this.b;
    if (this.b.La()) {}
    for (String str = "2";; str = "1")
    {
      localrdc.c("exp_editpoi", 0, 0, new String[] { str });
      ras.so("0X80076CF");
      ras.sp("0X80075E4");
      paramString = new rcc.e(this.jdField_a_of_type_Rdu, paramString);
      this.b.r(3, paramString);
      return;
    }
  }
  
  public int ta()
  {
    return 16;
  }
  
  public int tb()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.ts();
  }
  
  public boolean y(int paramInt)
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.y(paramInt));
  }
  
  static class a
    extends QQUIEventReceiver<rcc, rgp.a>
  {
    public a(@NonNull rcc paramrcc)
    {
      super();
    }
    
    public void a(@NonNull rcc paramrcc, @NonNull rgp.a parama)
    {
      if (parama.mErrorCode != 0) {
        paramrcc.b.c("fail_face", 0, 0, new String[0]);
      }
      rcc.d locald = paramrcc.a;
      if (locald != null)
      {
        Object localObject = locald.a(parama.b.awr);
        if (!(localObject instanceof rin))
        {
          ram.w(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + parama.b.awr);
          return;
        }
        localObject = (rin)localObject;
        if (parama.mErrorCode == 0)
        {
          if (parama.aBq)
          {
            ram.d(this.TAG, "notify ui we finish downloading");
            ((rin)localObject).isDownloading = false;
            ((rin)localObject).aAG = parama.b.getLocalEmojiFolderPath();
            ((rin)localObject).brW = 0;
            ((rin)localObject).brX = 0;
            locald.a((rik)localObject);
            return;
          }
          ram.v(this.TAG, "notify ui we new progress : " + parama.Ca + " / " + parama.BZ);
          ((rin)localObject).isDownloading = true;
          ((rin)localObject).aAG = null;
          ((rin)localObject).brW = ((int)parama.BZ);
          ((rin)localObject).brX = ((int)parama.Ca);
          locald.a((rik)localObject);
          return;
        }
        ((rin)localObject).isDownloading = false;
        ((rin)localObject).aAG = null;
        ((rin)localObject).brW = 0;
        ((rin)localObject).brX = 0;
        locald.a((rik)localObject);
        ram.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + parama.mErrorCode);
        QQToast.a(paramrcc.getContext(), acfp.m(2131705694), 1).show();
        ras.so("0X80076C9");
        ras.sp("0X80075DE");
        return;
      }
      ram.d(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
    }
    
    public Class acceptEventClass()
    {
      return rgp.a.class;
    }
  }
  
  static class b
    extends QQUIEventReceiver<rcc, rgp.b>
  {
    public b(@NonNull rcc paramrcc)
    {
      super();
    }
    
    public void a(@NonNull rcc paramrcc, @NonNull rgp.b paramb)
    {
      rcc.d locald = paramrcc.a;
      if (locald != null) {
        locald.e(paramrcc.b());
      }
      for (;;)
      {
        rar.b("edit_video", "face_list_success", 0, paramb.b.errorCode, new String[0]);
        return;
        ram.d(this.TAG, "DoodleEmojiListEventReceiver adapter is null");
      }
    }
    
    public Class acceptEventClass()
    {
      return rgp.b.class;
    }
  }
  
  static class c
    extends QQUIEventReceiver<rcc, rgp.c>
  {
    public c(@NonNull rcc paramrcc)
    {
      super();
    }
    
    public void a(@NonNull rcc paramrcc, @NonNull rgp.c paramc)
    {
      rcc.d locald = paramrcc.jdField_a_of_type_Rcc$d;
      int i = paramc.mErrorCode;
      paramc = paramc.oN;
      paramrcc = paramrcc.jdField_a_of_type_Rim;
      if (locald != null)
      {
        if (i != 0)
        {
          ram.d(this.TAG, "DoodleEmojiPoiPostersReceiver, location failed.");
          paramrcc.aIg = false;
          locald.a(paramrcc);
          ras.so("0X80076CD");
          ras.sp("0X80075E2");
          return;
        }
        ram.d(this.TAG, "DoodleEmojiPoiPostersReceiver, location success.");
        paramrcc.items.clear();
        paramc = paramc.iterator();
        while (paramc.hasNext())
        {
          ptr localptr = (ptr)paramc.next();
          if ((TextUtils.isEmpty(localptr.avb)) || (TextUtils.isEmpty(localptr.name)) || (TextUtils.isEmpty(localptr.desc))) {
            ram.w(this.TAG, "find illegal content : url=%s, name=%s, des=%s", new Object[] { localptr.avb, localptr.name, localptr.desc });
          }
          rim.a locala = new rim.a();
          locala.imageUrl = localptr.avb;
          locala.name = localptr.name;
          locala.desc = localptr.desc;
          locala.thumbUrl = localptr.thumbUrl;
          locala.aAE = localptr.avc;
          paramrcc.items.add(locala);
        }
        paramrcc.aIg = false;
        locald.a(paramrcc);
        return;
      }
      ram.d(this.TAG, "DoodleEmojiPoiPostersReceiver adapter is null");
    }
    
    public Class acceptEventClass()
    {
      return rgp.c.class;
    }
  }
  
  static class d
    extends ris
  {
    private final List<rik> oz = new ArrayList();
    
    public rik a(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.oz.size())) {
        return (rik)this.oz.get(paramInt);
      }
      return null;
    }
    
    public rik a(String paramString)
    {
      Iterator localIterator = this.oz.iterator();
      while (localIterator.hasNext())
      {
        rik localrik = (rik)localIterator.next();
        if (TextUtils.equals(paramString, localrik.id)) {
          return localrik;
        }
      }
      return null;
    }
    
    public void a(rik paramrik)
    {
      ram.d("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + paramrik);
      int i = this.oz.indexOf(paramrik);
      if (i >= 0)
      {
        this.oz.set(i, paramrik);
        xA(i);
      }
    }
    
    public void e(Collection<rik> paramCollection)
    {
      ram.d("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
      this.oz.clear();
      this.oz.addAll(paramCollection);
      buP();
    }
    
    public int getCount()
    {
      return this.oz.size();
    }
  }
  
  public static class e
  {
    public final rdu b;
    public final String location;
    
    public e(rdu paramrdu, String paramString)
    {
      this.b = paramrdu;
      this.location = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rcc
 * JD-Core Version:    0.7.0.1
 */