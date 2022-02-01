package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankq;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.takevideo.EditLocalGifSource;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel.a;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import ram;
import rar;
import ras;
import rdc;
import rfs;
import rft;
import rft.a;
import rft.b;
import rft.d;
import rfz;
import rga;
import rgb;
import rgb.a;
import rgb.b;
import rgf;
import rgf.a;
import rgh;
import rgj;
import rgj.a;
import rgl;
import rgm;
import rgy;
import rgy.a;
import rho;
import rhp;
import rhq;
import rhr;
import rhs;
import rht;
import rhu;
import rhv;
import rhy;
import rib;
import rig;
import rij;
import rim.a;
import riw;
import rix;
import riy.a;
import rnf;
import rni;

@TargetApi(14)
public class DoodleLayout
  extends RelativeLayout
  implements View.OnClickListener
{
  public static boolean aHL;
  private long Cc;
  public EditVideoParams a;
  public DoodleEditView a;
  public a a;
  public b a;
  public c a;
  private h jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$h;
  public j a;
  public DoodleTextureView a;
  public FacePanel a;
  public HorizontalSelectColorLayout a;
  private RuntimeException jdField_a_of_type_JavaLangRuntimeException;
  private rgf jdField_a_of_type_Rgf;
  public FrameLayout aH;
  private boolean aHM;
  private boolean aHN;
  public boolean aHO;
  public Rect aJ = new Rect();
  private final Condition b;
  public rft.a b;
  public rgy b;
  public SparseArray<rgj> ba;
  private AtomicBoolean ba;
  public SparseArray<e> bb = new SparseArray();
  private Bitmap bd;
  private int bqX;
  public int brs;
  private int brt = -1;
  private int bru = -1;
  private int brv = -1;
  private int brw = -1;
  public int brx = 0;
  public DoodleView c;
  public RelativeLayout fT;
  public RelativeLayout fW;
  private final Lock g = new ReentrantLock();
  public View iX;
  public SparseBooleanArray j = new SparseBooleanArray();
  public SparseBooleanArray k = new SparseBooleanArray();
  public Rect mDisplayRect = new Rect();
  private int mMosaicSize = -1;
  private int mStartY;
  public ImageView nm;
  public TextView yA;
  
  public DoodleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_ba_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_ba_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_b_of_type_JavaUtilConcurrentLocksCondition = this.g.newCondition();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$j = new j(null);
    init();
    this.bqX = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private boolean ab(boolean paramBoolean)
  {
    checkMainThread();
    ram.d("DoodleLayout", "onBackPressed, buttonState:" + this.brx + ",activeLayer:" + this.c.a());
    if ((this.brx == 0) || ((this.brx == 2) && (!paramBoolean))) {
      return false;
    }
    resetUI();
    xs(0);
    if (!this.c.Lw())
    {
      ram.d("DoodleLayout", "onBackPressed, resetDoodleView.");
      this.c.buy();
    }
    return true;
  }
  
  private void bug()
  {
    ram.d("DoodleLayout", "onClickInside: showEditTextDialog.");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$c = new c(null);
    this.jdField_b_of_type_Rgy = new rgy(super.getContext());
    this.jdField_b_of_type_Rgy.setEditVideoParams(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
    this.jdField_b_of_type_Rgy.xn(tr());
    this.jdField_b_of_type_Rgy.setContentView(2131561829);
    this.jdField_b_of_type_Rgy.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$c);
    this.jdField_b_of_type_Rgy.show();
  }
  
  private void buj()
  {
    AppInterface localAppInterface = null;
    if ((super.getContext() instanceof QQStoryBaseActivity)) {
      localAppInterface = ((QQStoryBaseActivity)super.getContext()).mApp;
    }
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null) || ((!(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalVideoSource)) && (!(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalGifSource)) && (!(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalPhotoSource))))
    {
      bool1 = true;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null) || (rdc.al(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.bqp, 32768))) {
        break label133;
      }
    }
    label133:
    for (boolean bool2 = true;; bool2 = false)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setStrokeStrategy(new rnf(localAppInterface, bool1, bool2), true, 1);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setSelectedStrokeWithColor(rni.ek[0]);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static void e(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    rar.a("video_edit", paramString, paramInt1, paramInt2, paramVarArgs);
  }
  
  private void init()
  {
    LayoutInflater.from(super.getContext()).inflate(2131561823, this);
    initUI();
    xq(this.brs);
  }
  
  private void initUI()
  {
    this.fW = ((RelativeLayout)super.findViewById(2131365417));
    this.yA = ((TextView)super.findViewById(2131380576));
    this.fT = ((RelativeLayout)super.findViewById(2131377609));
    this.nm = ((ImageView)super.findViewById(2131369885));
    this.iX = super.findViewById(2131371159);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel = ((FacePanel)super.findViewById(2131366650));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel.setOnFaceSelectedListener(new d(null));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout = ((HorizontalSelectColorLayout)super.findViewById(2131372322));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnUndoViewClickListener(new rho(this));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnStrokeSelectedListener(new rhp(this));
    buj();
    this.c = ((DoodleView)super.findViewById(2131366033));
    this.aH = ((FrameLayout)super.findViewById(2131366035));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView = new DoodleTextureView(super.getContext());
    this.aH.addView(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView, localLayoutParams);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView = ((DoodleEditView)super.findViewById(2131366034));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setDoodleLayout(this);
    setOnTextDialogShowListener(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setOnLayerTouchListener();
    this.aHO = ankq.aya();
    if (!this.aHO)
    {
      e(new View[] { this.aH });
      setDoodleGLViewVisibility(4);
    }
    this.yA.setOnClickListener(this);
    resetUI();
  }
  
  public static void sx(String paramString)
  {
    if (aHL) {}
    for (String str = "2";; str = "1")
    {
      e(paramString, 0, 0, new String[] { str });
      return;
    }
  }
  
  private void tM(boolean paramBoolean)
  {
    if (this.aHN != paramBoolean)
    {
      this.aHN = paramBoolean;
      if (paramBoolean)
      {
        ram.d("DoodleLayout", "rubbish active.");
        this.fT.setBackgroundColor(getResources().getColor(2131166623));
      }
    }
    else
    {
      return;
    }
    ram.d("DoodleLayout", "rubbish unActive.");
    this.fT.setBackgroundColor(getResources().getColor(2131166624));
  }
  
  private void xq(int paramInt)
  {
    Object localObject1 = (e)this.bb.get(paramInt);
    Object localObject2 = (rgj)this.jdField_ba_of_type_AndroidUtilSparseArray.get(paramInt);
    int i;
    if ((localObject1 == null) || (localObject2 == null))
    {
      ram.d("DoodleLayout", "initDoodleView for the %d video", Integer.valueOf(paramInt));
      localObject1 = new rft(this.c);
      rfz localrfz = new rfz(this.c);
      rgb localrgb = new rgb(this.c);
      localObject2 = (rib)localrfz.a(103);
      if ((localObject2 != null) && (this.mMosaicSize != -1)) {
        ((rib)localObject2).setMosaicSize(this.mMosaicSize);
      }
      if ((localObject2 != null) && (this.brt != -1) && (this.bru != -1)) {
        ((rib)localObject2).setMosaicStandardSize(this.brt, this.bru);
      }
      localObject2 = new rgj.a().a(new g(new rgf[] { localObject1, localrfz, localrgb }));
      if (this.brv != -1)
      {
        i = this.brv;
        localObject2 = ((rgj.a)localObject2).a(i);
        if (this.brw == -1) {
          break label466;
        }
        i = this.brw;
        label223:
        rgj localrgj = ((rgj.a)localObject2).b(i).a();
        this.c.setDoodleConfig(localrgj);
        this.c.setDoodleLayout(this);
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) {
          this.c.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
        }
        localObject2 = new e(localrgb, localrfz, (rft)localObject1, (rfs)this.c.a("EmptyLayer"));
        this.jdField_ba_of_type_AndroidUtilSparseArray.put(paramInt, localrgj);
        this.bb.put(paramInt, localObject2);
        localrfz.a(new f(null));
        localrfz.a(new rhq(this));
        ((rft)localObject1).a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$j);
        ((rft)localObject1).a(new rhr(this));
        localObject1 = localObject2;
        if (!this.aHM)
        {
          localrgb.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$j);
          localrgb.a(new k(null));
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      localObject2 = a();
      ((rfz)localObject2).a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView, this.c);
      ((rfz)localObject2).a.a(new rhs(this));
      ((rig)((rfz)localObject2).a.b(102)).tO(false);
      ((e)localObject1).jdField_b_of_type_Rfz.btO();
      return;
      i = 480;
      break;
      label466:
      i = 640;
      break label223;
      this.c.setDoodleConfig((rgj)localObject2);
    }
  }
  
  public List<String> A(int paramInt)
  {
    Object localObject = (e)this.bb.get(paramInt);
    if (localObject != null)
    {
      localObject = ((e)localObject).jdField_b_of_type_Rfz.a.ce();
      StringBuilder localStringBuilder = new StringBuilder().append("image doodle type count:");
      if ((localObject == null) || (((List)localObject).isEmpty())) {}
      for (paramInt = 0;; paramInt = ((List)localObject).size())
      {
        ram.d("DoodleLayout", paramInt);
        return localObject;
      }
    }
    return Collections.emptyList();
  }
  
  public List<rft.a> B(int paramInt)
  {
    Object localObject = (e)this.bb.get(paramInt);
    if (localObject != null)
    {
      localObject = ((e)localObject).jdField_b_of_type_Rft.oK;
      ram.d("DoodleLayout", "Using poi list:" + localObject.toString());
      return Collections.unmodifiableList((List)localObject);
    }
    return Collections.emptyList();
  }
  
  public boolean G(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.c.b(paramMotionEvent);
    if (paramMotionEvent != a())
    {
      ram.d("DoodleLayout", "layer accept the outside MotionEvent. Layer->" + paramMotionEvent.toString());
      this.jdField_a_of_type_Rgf = paramMotionEvent;
      return true;
    }
    ram.d("DoodleLayout", "no layer accept the outside MotionEvent.");
    this.jdField_a_of_type_Rgf = a();
    return false;
  }
  
  public void K(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Rgf != null)
    {
      this.jdField_a_of_type_Rgf.K(paramMotionEvent);
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      this.c.invalidate();
      return;
      this.jdField_a_of_type_Rgf = a();
    }
  }
  
  public Bitmap U()
  {
    return this.c.U();
  }
  
  public Bitmap W()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$a == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$a.W();
  }
  
  public FacePanel a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel;
  }
  
  public rfs a()
  {
    e locale = (e)this.bb.get(this.brs);
    if (locale == null)
    {
      ram.w("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.brs) });
      return null;
    }
    return locale.a;
  }
  
  public rft a()
  {
    e locale = (e)this.bb.get(this.brs);
    if (locale == null)
    {
      ram.w("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.brs) });
      return null;
    }
    return locale.jdField_b_of_type_Rft;
  }
  
  public rfz a()
  {
    e locale = (e)this.bb.get(this.brs);
    if (locale == null)
    {
      ram.w("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.brs) });
      return null;
    }
    return locale.jdField_b_of_type_Rfz;
  }
  
  public rgb a()
  {
    e locale = (e)this.bb.get(this.brs);
    if (locale == null)
    {
      ram.w("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.brs) });
      return null;
    }
    return locale.jdField_b_of_type_Rgb;
  }
  
  public void aUp()
  {
    if (this.brx == 6)
    {
      s(2, Boolean.valueOf(false));
      setState(2);
      if (a().a.tt() <= 0) {
        break label135;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
    }
    for (;;)
    {
      f(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(new rht(this));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.startAnimation(localAlphaAnimation);
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$a != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$a.d(localAlphaAnimation);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Personality", 2, "exitFullScreen");
      }
      return;
      label135:
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
    }
  }
  
  public Map<String, List<String>> b(int paramInt)
  {
    Object localObject = (e)this.bb.get(paramInt);
    if (localObject != null)
    {
      localObject = ((e)localObject).jdField_b_of_type_Rft.gg;
      ram.d("DoodleLayout", "Using face map:" + localObject.toString());
      return Collections.unmodifiableMap((Map)localObject);
    }
    return Collections.emptyMap();
  }
  
  public void b(rim.a parama)
  {
    checkMainThread();
    if (parama == null) {
      ram.e("DoodleLayout", "the item is null.");
    }
    boolean bool;
    do
    {
      return;
      ram.d("DoodleLayout", "addLocationFaceItem:" + parama.toString());
      rft.d locald = rix.a(parama, this.c.getWidth(), this.c.getHeight());
      if (locald == null) {
        break;
      }
      bool = false;
      if (parama.dj != null) {
        bool = a().a(null, parama.desc, parama.dj, locald);
      }
    } while (!bool);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b.a(parama);
    ras.so("0X80076CE");
    return;
    ram.e("DoodleLayout", "create FaceLayer.ItemParams failed.");
  }
  
  public boolean b(float paramFloat1, float paramFloat2, Rect paramRect)
  {
    boolean bool = false;
    if (paramRect == null) {}
    for (int i = 0;; i = paramRect.width() / 2)
    {
      if ((paramFloat1 < -i) || (paramFloat2 < -i) || (paramFloat1 > this.mDisplayRect.width() + i) || (paramFloat2 > i + this.mDisplayRect.height())) {
        bool = true;
      }
      return bool;
    }
  }
  
  public void brZ()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.post(new DoodleLayout.3(this));
    }
  }
  
  public void buh()
  {
    checkMainThread();
    ram.d("DoodleLayout", "onFacePressed, buttonState:" + this.brx + ",activeLayer:" + this.c.a());
    ras.bv("0X80076BA", ras.bpq);
    tL(true);
    super.setBackgroundColor(getResources().getColor(2131165864));
    e(new View[] { this.c });
    setDoodleGLViewVisibility(4);
    f(new View[] { this.fW });
    if (this.brx == 0) {
      f(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel });
    }
    for (;;)
    {
      setState(1);
      return;
      if (this.brx == 3)
      {
        setState(1);
        this.jdField_b_of_type_Rgy.dismiss();
        super.postDelayed(new DoodleLayout.7(this), 100L);
        return;
      }
      if (this.brx == 2)
      {
        a().tJ(false);
        e(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
        f(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel });
      }
    }
  }
  
  public void bui()
  {
    checkMainThread();
    ram.d("DoodleLayout", "onLinePressed, buttonState:" + this.brx + ",activeLayer:" + this.c.a());
    ras.bv("0X80076B8", ras.bpq);
    rfz localrfz = a();
    e(new View[] { this.fW });
    f(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
    localrfz.tJ(true);
    if (localrfz.bz())
    {
      rij localrij = (rij)localrfz.a(101);
      if (localrij != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setSelectedStrokeWithColor(localrij.mCurrentColor);
      }
    }
    if (localrfz.a.tt() > 0)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
      if (this.brx != 0) {
        break label170;
      }
    }
    for (;;)
    {
      setState(2);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
      break;
      label170:
      if (this.brx == 3)
      {
        setState(2);
        this.jdField_b_of_type_Rgy.dismiss();
        e(new View[] { this.fW });
        return;
      }
      if (this.brx == 1)
      {
        tL(false);
        e(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel });
        f(new View[] { this.c });
        setDoodleGLViewVisibility(0);
      }
    }
  }
  
  public void buk()
  {
    this.c.buk();
  }
  
  public void bul()
  {
    this.aHM = true;
    int i = 0;
    while (i < this.bb.size())
    {
      rgb localrgb = ((e)this.bb.valueAt(i)).jdField_b_of_type_Rgb;
      localrgb.a(null);
      localrgb.a(null);
      i += 1;
    }
  }
  
  public String cb(int paramInt)
  {
    Object localObject = (e)this.bb.get(paramInt);
    if (localObject != null)
    {
      localObject = ((e)localObject).jdField_b_of_type_Rgb.a();
      if (localObject != null)
      {
        ram.d("DoodleLayout", "doodle text :" + ((rgm)localObject).text);
        return ((rgm)localObject).text;
      }
    }
    return null;
  }
  
  protected void checkMainThread()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("Only the original thread that created a view hierarchy can touch its views.");
    }
  }
  
  /* Error */
  public Bitmap e(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 226	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:c	Lcom/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView;
    //   4: invokevirtual 951	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView:getBitmapWidth	()I
    //   7: istore_2
    //   8: aload_0
    //   9: getfield 226	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:c	Lcom/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView;
    //   12: invokevirtual 954	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView:getBitmapHeight	()I
    //   15: istore_3
    //   16: iload_2
    //   17: ifle +7 -> 24
    //   20: iload_3
    //   21: ifgt +31 -> 52
    //   24: ldc 210
    //   26: ldc_w 956
    //   29: iconst_2
    //   30: anewarray 671	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: iload_2
    //   36: invokestatic 517	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: iload_3
    //   43: invokestatic 517	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: aastore
    //   47: invokestatic 958	ram:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: aconst_null
    //   51: areturn
    //   52: aload_0
    //   53: getfield 136	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_ba_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   56: iconst_0
    //   57: invokevirtual 961	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   60: ifeq +15 -> 75
    //   63: aload_0
    //   64: iload_2
    //   65: iload_3
    //   66: getstatic 967	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   69: invokestatic 973	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   72: putfield 975	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:bd	Landroid/graphics/Bitmap;
    //   75: aload_0
    //   76: getfield 141	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:g	Ljava/util/concurrent/locks/Lock;
    //   79: invokeinterface 978 1 0
    //   84: aload_0
    //   85: getfield 975	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:bd	Landroid/graphics/Bitmap;
    //   88: astore 6
    //   90: aload 6
    //   92: ifnonnull +118 -> 210
    //   95: ldc 210
    //   97: ldc_w 980
    //   100: invokestatic 982	ram:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_0
    //   104: getfield 149	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_b_of_type_JavaUtilConcurrentLocksCondition	Ljava/util/concurrent/locks/Condition;
    //   107: ldc2_w 983
    //   110: getstatic 990	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   113: invokeinterface 996 4 0
    //   118: ifne -34 -> 84
    //   121: ldc 210
    //   123: ldc_w 998
    //   126: iconst_1
    //   127: anewarray 671	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: invokestatic 1004	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   135: invokevirtual 1008	java/lang/Thread:getId	()J
    //   138: invokestatic 1013	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   141: aastore
    //   142: invokestatic 719	ram:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_0
    //   146: getfield 1015	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaLangRuntimeException	Ljava/lang/RuntimeException;
    //   149: ifnull -65 -> 84
    //   152: ldc 210
    //   154: ldc_w 1017
    //   157: aload_0
    //   158: getfield 1015	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaLangRuntimeException	Ljava/lang/RuntimeException;
    //   161: invokestatic 1020	ram:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   164: goto -80 -> 84
    //   167: astore 6
    //   169: ldc 210
    //   171: ldc_w 1022
    //   174: aload 6
    //   176: invokestatic 1020	ram:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   179: goto -95 -> 84
    //   182: astore 6
    //   184: aload_0
    //   185: getfield 141	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:g	Ljava/util/concurrent/locks/Lock;
    //   188: invokeinterface 1025 1 0
    //   193: aload 6
    //   195: athrow
    //   196: astore 6
    //   198: ldc 210
    //   200: ldc_w 1027
    //   203: aload 6
    //   205: invokestatic 1029	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   208: aconst_null
    //   209: areturn
    //   210: aload_0
    //   211: getfield 975	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:bd	Landroid/graphics/Bitmap;
    //   214: astore 6
    //   216: aload_0
    //   217: aconst_null
    //   218: putfield 975	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:bd	Landroid/graphics/Bitmap;
    //   221: new 1031	android/graphics/Canvas
    //   224: dup
    //   225: aload 6
    //   227: invokespecial 1034	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   230: astore 7
    //   232: new 1036	android/graphics/Paint
    //   235: dup
    //   236: invokespecial 1037	android/graphics/Paint:<init>	()V
    //   239: astore 8
    //   241: aload 8
    //   243: new 1039	android/graphics/PorterDuffXfermode
    //   246: dup
    //   247: getstatic 1045	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   250: invokespecial 1048	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   253: invokevirtual 1052	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   256: pop
    //   257: aload 7
    //   259: aload 8
    //   261: invokevirtual 1056	android/graphics/Canvas:drawPaint	(Landroid/graphics/Paint;)V
    //   264: aload_0
    //   265: getfield 119	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:bb	Landroid/util/SparseArray;
    //   268: iload_1
    //   269: invokevirtual 507	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   272: checkcast 20	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout$e
    //   275: astore 8
    //   277: aload 8
    //   279: ifnonnull +34 -> 313
    //   282: ldc 210
    //   284: ldc_w 1058
    //   287: iconst_1
    //   288: anewarray 671	java/lang/Object
    //   291: dup
    //   292: iconst_0
    //   293: iload_1
    //   294: invokestatic 517	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   297: aastore
    //   298: invokestatic 958	ram:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: aload_0
    //   302: getfield 141	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:g	Ljava/util/concurrent/locks/Lock;
    //   305: invokeinterface 1025 1 0
    //   310: aload 6
    //   312: areturn
    //   313: invokestatic 1063	android/os/SystemClock:uptimeMillis	()J
    //   316: lstore 4
    //   318: aload 8
    //   320: getfield 633	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout$e:jdField_b_of_type_Rfz	Lrfz;
    //   323: astore 9
    //   325: aload 9
    //   327: getfield 615	rfz:a	Lrhy;
    //   330: invokevirtual 1066	rhy:Lt	()Z
    //   333: ifeq +126 -> 459
    //   336: ldc 210
    //   338: ldc_w 1068
    //   341: invokestatic 982	ram:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: aload_0
    //   345: getfield 274	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams	Lcom/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   348: getfield 1071	com/tencent/biz/qqstory/takevideo/EditVideoParams:asi	I
    //   351: iconst_1
    //   352: if_icmpne +98 -> 450
    //   355: aload 9
    //   357: getfield 615	rfz:a	Lrhy;
    //   360: invokevirtual 1074	rhy:Lu	()Z
    //   363: ifeq +87 -> 450
    //   366: iconst_1
    //   367: newarray int
    //   369: astore 10
    //   371: aload 10
    //   373: iconst_0
    //   374: iconst_0
    //   375: iastore
    //   376: iconst_5
    //   377: istore_1
    //   378: aload 9
    //   380: getfield 615	rfz:a	Lrhy;
    //   383: new 1076	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout$8
    //   386: dup
    //   387: aload_0
    //   388: aload 9
    //   390: iload_2
    //   391: aload 10
    //   393: invokespecial 1079	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout$8:<init>	(Lcom/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout;Lrfz;I[I)V
    //   396: invokevirtual 1083	rhy:N	(Ljava/lang/Runnable;)V
    //   399: aload 10
    //   401: iconst_0
    //   402: iaload
    //   403: istore_2
    //   404: iload_2
    //   405: iconst_1
    //   406: if_icmpeq +53 -> 459
    //   409: iload_1
    //   410: iconst_1
    //   411: isub
    //   412: istore_2
    //   413: iload_1
    //   414: ifle +45 -> 459
    //   417: ldc2_w 983
    //   420: invokestatic 1086	java/lang/Thread:sleep	(J)V
    //   423: ldc 210
    //   425: ldc_w 1088
    //   428: iload_2
    //   429: invokestatic 517	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   432: invokestatic 520	ram:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   435: iload_2
    //   436: istore_1
    //   437: goto -38 -> 399
    //   440: astore 11
    //   442: aload 11
    //   444: invokevirtual 1091	java/lang/InterruptedException:printStackTrace	()V
    //   447: goto -24 -> 423
    //   450: aload 9
    //   452: getfield 615	rfz:a	Lrhy;
    //   455: iload_2
    //   456: invokevirtual 1094	rhy:xu	(I)V
    //   459: aload_0
    //   460: getfield 274	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams	Lcom/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   463: ifnull +20 -> 483
    //   466: aload_0
    //   467: getfield 274	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams	Lcom/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   470: invokevirtual 1097	com/tencent/biz/qqstory/takevideo/EditVideoParams:La	()Z
    //   473: ifeq +10 -> 483
    //   476: aload 9
    //   478: aload 7
    //   480: invokevirtual 1101	rfz:ap	(Landroid/graphics/Canvas;)V
    //   483: aload 8
    //   485: getfield 1105	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout$e:nx	Ljava/util/ArrayList;
    //   488: invokevirtual 1111	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   491: astore 8
    //   493: aload 8
    //   495: invokeinterface 1116 1 0
    //   500: ifeq +21 -> 521
    //   503: aload 8
    //   505: invokeinterface 1120 1 0
    //   510: checkcast 547	rgf
    //   513: aload 7
    //   515: invokevirtual 1123	rgf:ao	(Landroid/graphics/Canvas;)V
    //   518: goto -25 -> 493
    //   521: ldc 210
    //   523: new 212	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   530: ldc_w 1125
    //   533: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: invokestatic 1063	android/os/SystemClock:uptimeMillis	()J
    //   539: lload 4
    //   541: lsub
    //   542: invokevirtual 1128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   545: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokestatic 243	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: aload_0
    //   552: getfield 141	com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:g	Ljava/util/concurrent/locks/Lock;
    //   555: invokeinterface 1025 1 0
    //   560: aload 6
    //   562: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	563	0	this	DoodleLayout
    //   0	563	1	paramInt	int
    //   7	449	2	i	int
    //   15	51	3	m	int
    //   316	224	4	l	long
    //   88	3	6	localBitmap1	Bitmap
    //   167	8	6	localInterruptedException1	java.lang.InterruptedException
    //   182	12	6	localObject1	Object
    //   196	8	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   214	347	6	localBitmap2	Bitmap
    //   230	284	7	localCanvas	android.graphics.Canvas
    //   239	265	8	localObject2	Object
    //   323	154	9	localrfz	rfz
    //   369	31	10	arrayOfInt	int[]
    //   440	3	11	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   95	164	167	java/lang/InterruptedException
    //   84	90	182	finally
    //   95	164	182	finally
    //   169	179	182	finally
    //   210	277	182	finally
    //   282	301	182	finally
    //   313	371	182	finally
    //   378	399	182	finally
    //   417	423	182	finally
    //   423	435	182	finally
    //   442	447	182	finally
    //   450	459	182	finally
    //   459	483	182	finally
    //   483	493	182	finally
    //   493	518	182	finally
    //   521	551	182	finally
    //   63	75	196	java/lang/OutOfMemoryError
    //   417	423	440	java/lang/InterruptedException
  }
  
  protected void e(View... paramVarArgs)
  {
    int m = paramVarArgs.length;
    int i = 0;
    while (i < m)
    {
      View localView = paramVarArgs[i];
      if (localView != null) {
        localView.setVisibility(4);
      }
      i += 1;
    }
  }
  
  public boolean eQ(int paramInt)
  {
    return this.j.get(paramInt, false);
  }
  
  public boolean eR(int paramInt)
  {
    return this.k.get(paramInt, false);
  }
  
  public int ed(int paramInt)
  {
    e locale = (e)this.bb.get(paramInt);
    if (locale != null)
    {
      paramInt = locale.jdField_b_of_type_Rgb.tp();
      int i = locale.jdField_b_of_type_Rfz.tp();
      int m = locale.jdField_b_of_type_Rft.tp();
      ram.d("DoodleLayout", "DoodleCount: text->" + paramInt + ",line->" + i + ",face->" + m);
      return m + (paramInt + i);
    }
    return 0;
  }
  
  public void ej(int paramInt1, int paramInt2)
  {
    ram.d("DoodleLayout", String.format("changeDoodleViewSize, width: %d, height: %d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    setDoodleBitmapMaxSize(paramInt1, paramInt2);
    int i = this.c.getWidth();
    int m = this.c.getHeight();
    Object localObject = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
    ((RelativeLayout.LayoutParams)localObject).height = paramInt2;
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.c.buz();
    this.c.recycleBitmap();
    this.c.onSizeChanged(paramInt1, paramInt2, i, m);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.ei(paramInt1, paramInt2);
    }
    localObject = (rib)a().a(104);
    if (localObject != null) {
      ((rib)localObject).buE();
    }
    localObject = (RelativeLayout.LayoutParams)this.aH.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
    ((RelativeLayout.LayoutParams)localObject).height = paramInt2;
    this.aH.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  protected void f(View... paramVarArgs)
  {
    int m = paramVarArgs.length;
    int i = 0;
    while (i < m)
    {
      View localView = paramVarArgs[i];
      if (localView != null) {
        localView.setVisibility(0);
      }
      i += 1;
    }
  }
  
  public byte[] f(int paramInt)
  {
    e locale = (e)this.bb.get(paramInt);
    if (locale == null) {
      return null;
    }
    return locale.jdField_b_of_type_Rfz.K();
  }
  
  public int[] g(int paramInt)
  {
    Object localObject = (e)this.bb.get(paramInt);
    if (localObject != null)
    {
      localObject = ((e)localObject).jdField_b_of_type_Rfz.a.A();
      ram.d("DoodleLayout", "normal path count:" + localObject[0] + ",mosaic path count:" + localObject[1]);
      return localObject;
    }
    return new int[] { 0, 0 };
  }
  
  public int getBusinessId()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi;
  }
  
  public int getCurrentState()
  {
    return this.brx;
  }
  
  public Bitmap h(int paramInt)
  {
    e locale = (e)this.bb.get(paramInt);
    if (locale != null) {
      return locale.jdField_b_of_type_Rfz.X();
    }
    return null;
  }
  
  public int[] h(int paramInt)
  {
    Object localObject = (e)this.bb.get(paramInt);
    if (localObject != null)
    {
      localObject = ((e)localObject).jdField_b_of_type_Rft.z();
      ram.d("DoodleLayout", "normal face count:" + localObject[0] + ",location face count:" + localObject[1]);
      return localObject;
    }
    return new int[] { 0, 0 };
  }
  
  public boolean isEmpty()
  {
    return this.c.isEmpty();
  }
  
  public void onClick(View paramView)
  {
    if (this.Cc > System.currentTimeMillis()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView == this.yA) && (!ab(false)) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b != null)) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b.close();
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    this.c.onDestroy();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.onDestroy();
    super.onDetachedFromWindow();
  }
  
  public void onResume()
  {
    String str = Build.MODEL;
    if (((str.equals("vivo Y75A")) || (str.equals("PACM00"))) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleLayout", 2, "onResume, onStillRequestRender");
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.requestLayout();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.invalidate();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.buf();
    }
  }
  
  public void resetUI()
  {
    checkMainThread();
    f(new View[] { this.c });
    setDoodleGLViewVisibility(0);
    e(new View[] { this.fW, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout, this.fT });
    tL(false);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
    if ((this.jdField_b_of_type_Rgy != null) && (this.jdField_b_of_type_Rgy.isShowing()))
    {
      this.jdField_b_of_type_Rgy.dismiss();
      return;
    }
    this.c.buy();
    setState(0);
  }
  
  protected void s(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b.q(paramInt, paramObject);
    }
  }
  
  public void s(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      throw new IllegalArgumentException("bitmap should not be null or recycled");
    }
    this.g.lock();
    if (this.bd != null) {
      throw new IllegalStateException("add bitmap as buffer duplicate");
    }
    this.jdField_a_of_type_JavaLangRuntimeException = null;
    try
    {
      this.bd = paramBitmap;
      this.jdField_b_of_type_JavaUtilConcurrentLocksCondition.signal();
      return;
    }
    finally
    {
      this.g.unlock();
    }
  }
  
  public void setDoodleBitmapMaxSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      ram.e("DoodleLayout", "width or height is illegal, width=" + paramInt1 + ",height=" + paramInt2);
    }
    for (;;)
    {
      return;
      ram.d("DoodleLayout", "setDoodleBitmapMaxSize, maxWidth" + paramInt1 + ",maxHeight:" + paramInt2);
      this.brv = paramInt1;
      this.brw = paramInt2;
      int i = 0;
      while (i < this.jdField_ba_of_type_AndroidUtilSparseArray.size())
      {
        ((rgj)this.jdField_ba_of_type_AndroidUtilSparseArray.get(i)).bre = paramInt1;
        ((rgj)this.jdField_ba_of_type_AndroidUtilSparseArray.get(i)).brf = paramInt2;
        i += 1;
      }
    }
  }
  
  public void setDoodleBtnOperationHelper(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$a = parama;
  }
  
  public void setDoodleEventListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b = paramb;
  }
  
  @TargetApi(14)
  public void setDoodleGLViewVisibility(int paramInt)
  {
    if (!this.aHO)
    {
      ram.d("DoodleLayout", "setDoodleGLViewVisibility, soload failed, glview default invisible");
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.xx(paramInt);
  }
  
  public void setEditVideoParams(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    this.c.b(paramEditVideoParams);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.b(paramEditVideoParams);
    aHL = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.La();
    buj();
  }
  
  public void setLocation(String paramString)
  {
    if (this.jdField_b_of_type_Rft$a == null)
    {
      ram.e("DoodleLayout", "ClickFaceItem not found.");
      return;
    }
    ram.d("DoodleLayout", "setLocation: clickItem-->" + this.jdField_b_of_type_Rft$a);
    a().a(this.jdField_b_of_type_Rft$a, paramString);
    this.jdField_b_of_type_Rft$a = null;
  }
  
  public void setMosaicSize(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1)
    {
      ram.e("DoodleLayout", "MosaicSize little than 1.");
      i = 1;
    }
    this.mMosaicSize = i;
    paramInt = 0;
    while (paramInt < this.bb.size())
    {
      rib localrib = (rib)((e)this.bb.valueAt(paramInt)).jdField_b_of_type_Rfz.a(103);
      if (localrib != null) {
        localrib.setMosaicSize(i);
      }
      paramInt += 1;
    }
  }
  
  public void setMosaicStandardSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      ram.e("DoodleLayout", "StandardMosaicSize, width or height <= 0. width:" + paramInt1 + ",height:" + paramInt2);
    }
    for (;;)
    {
      return;
      this.brt = paramInt1;
      this.bru = paramInt2;
      int i = 0;
      while (i < this.bb.size())
      {
        rib localrib = (rib)((e)this.bb.valueAt(i)).jdField_b_of_type_Rfz.a(103);
        if (localrib != null) {
          localrib.setMosaicStandardSize(paramInt1, paramInt2);
        }
        i += 1;
      }
    }
  }
  
  public void setOnTextDialogShowListener(h paramh)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$h = paramh;
  }
  
  protected void setState(int paramInt)
  {
    if (!i.eS(paramInt))
    {
      ram.e("DoodleLayout", "illegal state.");
      return;
    }
    this.brx = paramInt;
  }
  
  protected void tL(boolean paramBoolean)
  {
    int m = 0;
    View localView;
    if (paramBoolean)
    {
      i = getResources().getColor(2131165864);
      this.fW.setBackgroundColor(i);
      super.setBackgroundColor(i);
      localView = this.iX;
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (int i = m;; i = 4)
    {
      localView.setVisibility(i);
      return;
      i = 0;
      break;
    }
  }
  
  protected int tr()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.fW.getLayoutParams();
    int i = this.fW.getHeight();
    int m = localLayoutParams.topMargin;
    return localLayoutParams.bottomMargin + (i + m);
  }
  
  public int ts()
  {
    int i = 0;
    int m = 0;
    while (i < this.bb.size())
    {
      e locale = (e)this.bb.valueAt(i);
      m = m + locale.jdField_b_of_type_Rgb.tp() + locale.jdField_b_of_type_Rfz.tp() + locale.jdField_b_of_type_Rft.tp();
      i += 1;
    }
    return m;
  }
  
  public void undo()
  {
    checkMainThread();
    rfz localrfz = a();
    ram.d("DoodleLayout", "undo, activeLayer:" + this.c.a() + ",pathCount:" + localrfz.a.tt());
    if (localrfz.isActive())
    {
      localrfz.undo();
      if (localrfz.a.tt() == 0) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
  }
  
  public void xp(int paramInt)
  {
    ram.d("DoodleLayout", "changeVideoIndex from %d to %d", Integer.valueOf(this.brs), Integer.valueOf(paramInt));
    this.brs = paramInt;
    xq(paramInt);
  }
  
  public void xr(int paramInt)
  {
    checkMainThread();
    ram.d("DoodleLayout", "onTextPressed, buttonState:" + this.brx + ",activeLayer:" + this.c.a());
    String str;
    if (paramInt == 2)
    {
      str = "add_text";
      sx(str);
      if (paramInt != 2) {
        break label104;
      }
      ras.bv("0X80076B9", ras.bpq);
      label74:
      if (this.brx != 3) {
        break label113;
      }
      if (this.jdField_b_of_type_Rgy != null) {
        this.jdField_b_of_type_Rgy.dismiss();
      }
    }
    label104:
    label113:
    do
    {
      do
      {
        return;
        str = "edit_text";
        break;
        ras.so("0X80076C3");
        break label74;
        bug();
        e(new View[] { this.fW });
      } while (this.brx == 0);
      if (this.brx == 1)
      {
        tL(false);
        e(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel });
        f(new View[] { this.c });
        setDoodleGLViewVisibility(0);
        return;
      }
    } while (this.brx != 2);
    e(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
  }
  
  protected void xs(int paramInt)
  {
    s(paramInt, null);
  }
  
  public boolean y(int paramInt)
  {
    Object localObject = (e)this.bb.get(paramInt);
    if (localObject != null)
    {
      localObject = ((e)localObject).nx.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!((rgf)((Iterator)localObject).next()).isEmpty()) {
          return false;
        }
      }
    }
    return true;
  }
  
  public static abstract interface a
  {
    public abstract Bitmap W();
    
    public abstract void c(Animation paramAnimation);
    
    public abstract void d(Animation paramAnimation);
  }
  
  public static abstract interface b
  {
    public abstract void S(byte[] paramArrayOfByte);
    
    public abstract void a(rim.a parama);
    
    public abstract void bsE();
    
    public abstract void bsF();
    
    public abstract void close();
    
    public abstract void d(Bitmap paramBitmap, boolean paramBoolean);
    
    public abstract void eb(int paramInt1, int paramInt2);
    
    public abstract void q(int paramInt, Object paramObject);
    
    public abstract void ss(String paramString);
  }
  
  class c
    implements rgy.a
  {
    private c() {}
    
    public void a(boolean paramBoolean, rgm paramrgm)
    {
      rgb localrgb = DoodleLayout.this.a();
      if (paramBoolean)
      {
        localrgb.tI(true);
        switch (DoodleLayout.this.brx)
        {
        }
        for (;;)
        {
          DoodleLayout.this.setState(3);
          return;
          DoodleLayout.this.a().tJ(false);
        }
      }
      if (paramrgm.color != -1) {
        DoodleLayout.this.j.put(DoodleLayout.this.brs, true);
      }
      for (;;)
      {
        localrgb.a(paramrgm);
        localrgb.tI(false);
        DoodleLayout.this.e(new View[] { DoodleLayout.this.fW });
        DoodleLayout.this.setState(0);
        DoodleLayout.this.xs(0);
        DoodleLayout.this.a.bsF();
        return;
        DoodleLayout.this.j.put(DoodleLayout.this.brs, false);
      }
    }
    
    public void buc()
    {
      DoodleLayout.this.a().startAnimate();
    }
    
    public void xj(int paramInt)
    {
      if (DoodleLayout.this.a != null) {
        DoodleLayout.this.a.eb(3, paramInt);
      }
    }
    
    public void xo(int paramInt)
    {
      DoodleLayout.this.a().xm(paramInt);
    }
  }
  
  class d
    implements FacePanel.a
  {
    private d() {}
    
    private void bun()
    {
      DoodleLayout.this.e(new View[] { DoodleLayout.this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFacePanel, DoodleLayout.this.fW });
      DoodleLayout.this.tL(false);
      DoodleLayout.this.f(new View[] { DoodleLayout.this.c });
      DoodleLayout.this.setDoodleGLViewVisibility(0);
      DoodleLayout.this.setState(0);
      DoodleLayout.this.xs(0);
    }
    
    public void a(rgl paramrgl, float paramFloat1, float paramFloat2, float paramFloat3)
    {
      ram.a("DoodleLayout", "onNormalFaceSelected, item : %s , x : %s , y : %s , scale : %s ", paramrgl, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
      bun();
      rft.d locald = new rft.d(paramFloat1, paramFloat2 + DoodleLayout.this.tr(), paramFloat3, 0.0F, 0.0F, 0.0F, paramrgl.drawable.getIntrinsicWidth(), paramrgl.drawable.getIntrinsicHeight());
      if ((DoodleLayout.this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (DoodleLayout.this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 3))
      {
        LpReportInfo_pf00064.allReport(615, 6);
        LpReportInfo_pf00064.allReport(615, 4, 2);
      }
      if (DoodleLayout.this.a().a(paramrgl.category, paramrgl.name, paramrgl.drawable, locald))
      {
        DoodleLayout.sx("clk_oneface");
        ras.so("0X80076CA");
        ras.sp("0X80075DF");
      }
    }
    
    public void c(rim.a parama)
    {
      ram.d("DoodleLayout", "onLocationFaceSelected, pictureUrl:" + parama.imageUrl);
      bun();
      DoodleLayout.this.b(parama);
      if (DoodleLayout.this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 3) {
        LpReportInfo_pf00064.report(615, 6);
      }
      ras.sp("0X80075E3");
    }
  }
  
  public static class e
  {
    @NonNull
    public final rfs a;
    @NonNull
    public final rft b;
    @NonNull
    public final rfz b;
    @NonNull
    public final rgb b;
    public final ArrayList<rgf> nx = new ArrayList();
    
    public e(@NonNull rgb paramrgb, @NonNull rfz paramrfz, @NonNull rft paramrft, @NonNull rfs paramrfs)
    {
      this.jdField_b_of_type_Rgb = paramrgb;
      this.jdField_b_of_type_Rfz = paramrfz;
      this.jdField_b_of_type_Rft = paramrft;
      this.a = paramrfs;
      this.nx.add(paramrft);
      this.nx.add(paramrfz);
      this.nx.add(paramrgb);
    }
  }
  
  public class f
    implements rgf.a<rfz>
  {
    long Cd;
    int mDownX;
    int mDownY;
    
    private f() {}
    
    private void p(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      DoodleLayout.a(DoodleLayout.this, System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        DoodleLayout.a(DoodleLayout.this, DoodleLayout.a(DoodleLayout.this) + 500L);
      }
      Object localObject = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject).setDuration(500L);
      ((AlphaAnimation)localObject).setFillAfter(true);
      ((AlphaAnimation)localObject).setAnimationListener(new rhu(this));
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      if (paramBoolean3) {
        localAlphaAnimation.setStartOffset(500L);
      }
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(new rhv(this));
      if (paramBoolean2) {
        localObject = localAlphaAnimation;
      }
      for (;;)
      {
        DoodleLayout.this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.startAnimation((Animation)localObject);
        DoodleLayout.this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setAnimationEndTime(DoodleLayout.a(DoodleLayout.this));
        if (DoodleLayout.this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$a != null) {
          DoodleLayout.this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$a.d((Animation)localObject);
        }
        return;
      }
    }
    
    public boolean a(rfz paramrfz, MotionEvent paramMotionEvent)
    {
      rni localrni = DoodleLayout.this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.a();
      if (localrni != null) {}
      int i;
      int j;
      switch (localrni.type)
      {
      default: 
        i = Math.round(paramMotionEvent.getY());
        j = Math.round(paramMotionEvent.getX());
        switch (paramMotionEvent.getAction())
        {
        }
        break;
      }
      label516:
      do
      {
        do
        {
          do
          {
            return false;
            i = localrni.subType;
            if (i != rij.brD) {
              DoodleLayout.this.k.put(DoodleLayout.this.brs, true);
            }
            for (;;)
            {
              localObject = (rij)paramrfz.a(101);
              if (localObject != null) {
                ((rij)localObject).setLineColor(i);
              }
              if (paramrfz.bz()) {
                break;
              }
              paramrfz.btR();
              break;
              DoodleLayout.this.k.put(DoodleLayout.this.brs, false);
            }
            if (paramrfz.Lo()) {
              break;
            }
            paramrfz.btQ();
            break;
            Object localObject = null;
            if ((DoodleLayout.this.getContext() instanceof QQStoryBaseActivity)) {
              localObject = ((QQStoryBaseActivity)DoodleLayout.this.getContext()).mApp;
            }
            paramrfz.a((AppInterface)localObject, 2, localrni.subType);
            break;
            this.mDownX = Math.round(paramMotionEvent.getX());
            this.mDownY = Math.round(paramMotionEvent.getY());
            this.Cd = System.currentTimeMillis();
            return false;
          } while (((Math.abs(j - this.mDownX) < 3) && (Math.abs(i - this.mDownY) < 3)) || (DoodleLayout.this.brx == 6) || (DoodleLayout.this.brx == 5));
          DoodleLayout.this.setState(5);
          if (DoodleLayout.a(DoodleLayout.this) > System.currentTimeMillis()) {
            DoodleLayout.this.s(5, Boolean.valueOf(false));
          }
          for (;;)
          {
            DoodleLayout.this.e(new View[] { DoodleLayout.this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Personality", 2, "LineLayer draw move hide");
            return false;
            DoodleLayout.this.s(5, Boolean.valueOf(true));
            p(true, false, true);
          }
          if (paramrfz.a.tt() > 0) {
            DoodleLayout.this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
          }
          if (DoodleLayout.this.brx != 5) {
            break label516;
          }
          DoodleLayout.this.xs(2);
          DoodleLayout.this.setState(2);
          DoodleLayout.this.f(new View[] { DoodleLayout.this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
          p(true, true, true);
        } while (!QLog.isColorLevel());
        QLog.d("Personality", 2, "LineLayer draw up show");
        return false;
      } while ((Math.abs(j - this.mDownX) >= 3) || (Math.abs(i - this.mDownY) >= 3));
      if (DoodleLayout.this.brx == 6)
      {
        DoodleLayout.this.s(2, Boolean.valueOf(false));
        DoodleLayout.this.setState(2);
        DoodleLayout.this.f(new View[] { DoodleLayout.this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
        if (paramrfz.a.tt() > 0) {}
        for (bool = true;; bool = false)
        {
          p(bool, true, false);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Personality", 2, "LineLayer tap up show");
          return false;
        }
      }
      DoodleLayout.this.setState(6);
      DoodleLayout.this.xs(6);
      ras.bw("0X80080E5", ras.bpo);
      DoodleLayout.this.e(new View[] { DoodleLayout.this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
      if (paramrfz.a.tt() > 0) {}
      for (boolean bool = true;; bool = false)
      {
        p(bool, false, true);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Personality", 2, "LineLayer tap up hide");
        return false;
      }
    }
  }
  
  public static class g
    implements rgh
  {
    @NonNull
    private final rgf[] a;
    
    public g(rgf... paramVarArgs)
    {
      if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
        throw new IllegalArgumentException("layers should not be null or empty");
      }
      this.a = paramVarArgs;
    }
    
    public void a(List<rgf> paramList, DoodleView paramDoodleView)
    {
      paramList.addAll(Arrays.asList(this.a));
    }
  }
  
  static abstract interface h {}
  
  public static class i
  {
    public static boolean eS(int paramInt)
    {
      return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4) || (paramInt == 5) || (paramInt == 6);
    }
  }
  
  class j
    implements rgf.a<rgf>
  {
    private final int PADDING = riw.dip2px(DoodleLayout.a(DoodleLayout.this), 40.0F);
    private Rect aJ;
    private Handler mUiHandler = new Handler(Looper.getMainLooper());
    
    private j() {}
    
    public boolean a(rgf paramrgf, MotionEvent paramMotionEvent)
    {
      if ((paramrgf instanceof rft)) {
        localRect = new Rect();
      }
      for (Rect localRect = ((rft)paramrgf).c(localRect);; localRect = null)
      {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        int i = (int)Math.abs(f2 - DoodleLayout.a(DoodleLayout.this));
        int j;
        int k;
        int m;
        switch (paramMotionEvent.getAction() & 0xFF)
        {
        case 3: 
        case 4: 
        default: 
        case 0: 
        case 2: 
        case 5: 
        case 6: 
          do
          {
            return false;
            DoodleLayout.this.e(new View[] { DoodleLayout.this.fW });
            this.aJ = new Rect();
            DoodleLayout.this.fT.getGlobalVisibleRect(this.aJ);
            paramrgf = this.aJ;
            paramrgf.top -= this.PADDING;
            paramrgf = this.aJ;
            paramrgf.bottom += this.PADDING;
            DoodleLayout.this.c.getGlobalVisibleRect(DoodleLayout.this.mDisplayRect);
            DoodleLayout.a(DoodleLayout.this, (int)f2);
            this.mUiHandler.removeCallbacksAndMessages(null);
            this.mUiHandler.postDelayed(new DoodleLayout.TextFaceLayerTouchListener.1(this), 200L);
            return false;
          } while (i <= DoodleLayout.b(DoodleLayout.this));
          if ((DoodleLayout.this.a == null) || (DoodleLayout.this.a.La()) || (DoodleLayout.this.a.Le()) || (DoodleLayout.this.a.asi == 10) || (DoodleLayout.this.a.asi == 12))
          {
            i = (int)f1;
            j = DoodleLayout.this.mDisplayRect.left;
            k = (int)f2;
            m = DoodleLayout.this.mDisplayRect.top;
            if ((this.aJ.contains(i + j, k + m)) || (DoodleLayout.this.b(f1, f2, localRect)))
            {
              DoodleLayout.a(DoodleLayout.this, true);
              return false;
            }
            DoodleLayout.a(DoodleLayout.this, false);
            return false;
          }
          if ((paramMotionEvent.getPointerCount() == 1) && (this.aJ.contains((int)f1, (int)f2)))
          {
            DoodleLayout.a(DoodleLayout.this, true);
            return false;
          }
          DoodleLayout.a(DoodleLayout.this, false);
          return false;
        }
        this.mUiHandler.removeCallbacksAndMessages(null);
        if ((this.aJ != null) && ((DoodleLayout.this.a == null) || (DoodleLayout.this.a.La()) || (DoodleLayout.this.a.Le()) || (DoodleLayout.this.a.asi == 10) || (DoodleLayout.this.a.asi == 12)))
        {
          i = (int)f1;
          j = DoodleLayout.this.mDisplayRect.left;
          k = (int)f2;
          m = DoodleLayout.this.mDisplayRect.top;
          if ((DoodleLayout.a(DoodleLayout.this)) && ((this.aJ.contains(i + j, k + m)) || (DoodleLayout.this.b(f1, f2, localRect))))
          {
            if (!(paramrgf instanceof rft)) {
              break label661;
            }
            ram.d("DoodleLayout", "remove face.");
            ((rft)paramrgf).btM();
            DoodleLayout.a(DoodleLayout.this, false);
          }
        }
        label661:
        while ((paramMotionEvent.getPointerCount() != 1) || (this.aJ == null) || (!this.aJ.contains((int)f1, (int)f2))) {
          for (;;)
          {
            DoodleLayout.this.resetUI();
            DoodleLayout.this.xs(0);
            return false;
            if ((paramrgf instanceof rgb))
            {
              ram.d("DoodleLayout", "editpic remove text.");
              paramrgf.clear();
              paramrgf.tJ(false);
            }
            else if ((paramrgf instanceof rga))
            {
              paramMotionEvent = ((rga)paramrgf).a();
              if ((paramMotionEvent != null) && ((paramMotionEvent instanceof rgb.b)))
              {
                paramMotionEvent = DoodleLayout.this.a();
                if (paramMotionEvent != null) {
                  paramMotionEvent.clear();
                }
              }
              ((rga)paramrgf).btS();
            }
          }
        }
        if ((paramrgf instanceof rgb))
        {
          ram.d("DoodleLayout", "remove text.");
          paramrgf.clear();
          paramrgf.tJ(false);
        }
        for (;;)
        {
          DoodleLayout.a(DoodleLayout.this, false);
          break;
          if ((paramrgf instanceof rft))
          {
            ram.d("DoodleLayout", "remove face.");
            ((rft)paramrgf).btM();
          }
          else if ((paramrgf instanceof rga))
          {
            paramMotionEvent = ((rga)paramrgf).a();
            if ((paramMotionEvent != null) && ((paramMotionEvent instanceof rgb.b)))
            {
              paramMotionEvent = DoodleLayout.this.a();
              if (paramMotionEvent != null) {
                paramMotionEvent.clear();
              }
            }
            ((rga)paramrgf).btS();
          }
        }
      }
    }
  }
  
  class k
    implements rgb.a
  {
    private k() {}
    
    public boolean a(rgb.b paramb)
    {
      if ((DoodleLayout.this.a != null) && (paramb != null))
      {
        DoodleLayout.this.a.setVisibility(0);
        Object localObject;
        if (DoodleLayout.this.a.a.Lp())
        {
          localObject = DoodleLayout.this.a.a.a();
          ((riy.a)localObject).aIp = false;
          if (!(localObject instanceof rft.b)) {
            break label124;
          }
          rft localrft = DoodleLayout.this.a();
          if (localrft != null) {
            localrft.oJ.add((rft.b)localObject);
          }
        }
        for (;;)
        {
          DoodleLayout.this.a.a.b(paramb);
          paramb.aIp = true;
          DoodleLayout.this.a.requestLayout();
          return true;
          label124:
          if ((localObject instanceof rgb.b))
          {
            localObject = DoodleLayout.this.a();
            if (localObject != null) {
              ((rgb)localObject).btV();
            }
          }
        }
      }
      return false;
    }
    
    public void ad(float paramFloat)
    {
      if (paramFloat == 1.0F) {
        DoodleLayout.this.b.a(DoodleLayout.this.a().a());
      }
    }
    
    public void b(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3) {}
    
    public void btW()
    {
      DoodleLayout.this.xs(3);
    }
    
    public void btX() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout
 * JD-Core Version:    0.7.0.1
 */