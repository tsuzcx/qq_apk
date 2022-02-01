package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import ankq;
import auwa;
import awtj;
import awwk;
import axoo;
import axqg;
import axqn;
import axug;
import axvb;
import aydk;
import ayfv;
import ayfw;
import aygt;
import aygt.a;
import aygz;
import ayio;
import ayjb;
import ayjd;
import ayjl;
import ayjm;
import ayjn;
import ayjn.b;
import ayjn.c;
import ayjn.d;
import ayjs;
import ayjt;
import ayjt.a;
import ayju;
import ayjv;
import ayjv.a;
import ayjw;
import ayjw.a;
import ayjw.c;
import aykb;
import aykb.b;
import aykd;
import aykd.a;
import aykf;
import ayki;
import ayki.a;
import aykk;
import aykw;
import aykw.a;
import aylu;
import aylv;
import aylw;
import aylx;
import ayly;
import aylz;
import ayma;
import aymb;
import aymc;
import aymd;
import ayme;
import aymf;
import aymg;
import aymh;
import aymk;
import aymp;
import aymu;
import aymy;
import ayna.c;
import aynb;
import aynd.a;
import ayob;
import ayom;
import ayon;
import ayoo;
import ayoo.a;
import ayti;
import aytj;
import aytl;
import ayxa;
import azbx;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalGifSource;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import ram;
import rar;
import ras;
import rma;

@TargetApi(14)
public class DoodleLayout
  extends RelativeLayout
  implements View.OnClickListener
{
  public static boolean aHL;
  private long Cc;
  private List<Long> Nz;
  private axqn jdField_a_of_type_Axqn;
  axug jdField_a_of_type_Axug = new axug();
  public ayjs a;
  public aykw a;
  public EditVideoParams a;
  public DoodleEditView a;
  public a a;
  public c a;
  private h jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$h;
  private j jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$j;
  public k a;
  private m jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$m = new m(null);
  public DoodleTextureView a;
  public DoodleView a;
  private StoryGuideLineView jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView;
  public HorizontalSelectColorLayout a;
  private RuntimeException jdField_a_of_type_JavaLangRuntimeException;
  private long aCT;
  private long aCU;
  public long aCV;
  public FrameLayout aH;
  private boolean aHM;
  private boolean aHN;
  public boolean aHO;
  private Comparator<aykd> au = new aylu(this);
  private ayfw jdField_b_of_type_Ayfw;
  public ayjt b;
  public aykb b;
  public b b;
  private final Condition jdField_b_of_type_JavaUtilConcurrentLocksCondition = this.g.newCondition();
  public SparseArray<ayki> ba;
  private AtomicBoolean ba;
  public SparseArray<e> bb = new SparseArray();
  private Bitmap bd;
  public int brs;
  private int brt = -1;
  private int bru = -1;
  private int brv = -1;
  private int brw = -1;
  public int brx = 0;
  public ayjn.b c;
  public DoodleView c;
  private boolean dp;
  private boolean dzM;
  private boolean dzN;
  private boolean dzO;
  private boolean dzP = true;
  public boolean dzQ;
  private boolean dzR;
  private boolean dzS = true;
  private boolean dzT;
  protected axqg e;
  public int eKA = -1;
  private int eKB;
  public int eKz = -1;
  private int entrance = -1;
  public RelativeLayout fT;
  private final Lock g = new ReentrantLock();
  public SparseBooleanArray j = new SparseBooleanArray();
  public SparseBooleanArray k = new SparseBooleanArray();
  public Rect mDisplayRect = new Rect();
  private int mMosaicSize = -1;
  private int mStartY;
  public ImageView nm;
  
  public DoodleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_ba_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_ba_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$k = new k(null);
    LayoutInflater.from(super.getContext()).inflate(2131559256, this);
    initUI();
    xq(this.brs);
    afn(this.brs);
    this.eKB = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private static void ZF(boolean paramBoolean)
  {
    if (paramBoolean) {
      ayjb.a().eRW();
    }
  }
  
  private boolean ab(boolean paramBoolean)
  {
    checkMainThread();
    ram.d("DoodleLayout", "onBackPressed, buttonState:" + this.brx + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    if ((this.brx == 0) || ((this.brx == 2) && (!paramBoolean))) {
      return false;
    }
    resetUI();
    xs(0);
    if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.Lw())
    {
      ram.d("DoodleLayout", "onBackPressed, resetDoodleView.");
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.buy();
    }
    return true;
  }
  
  private void afn(int paramInt)
  {
    this.jdField_b_of_type_Aykb = new aykb(this.jdField_c_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    this.jdField_b_of_type_Ayjt = new ayjt(this.jdField_c_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    Object localObject = new ayme(this);
    localObject = new ayki.a().a((aykf)localObject);
    if (this.brv != -1)
    {
      paramInt = this.brv;
      localObject = ((ayki.a)localObject).a(paramInt);
      if (this.brw == -1) {
        break label168;
      }
    }
    label168:
    for (paramInt = this.brw;; paramInt = 640)
    {
      localObject = ((ayki.a)localObject).b(paramInt).a();
      this.jdField_c_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig((ayki)localObject);
      this.jdField_c_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleLayout(this);
      this.jdField_b_of_type_Aykb.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$m);
      this.jdField_b_of_type_Aykb.a(new aylv(this));
      this.jdField_b_of_type_Ayjt.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$m);
      this.jdField_b_of_type_Ayjt.a(new aylw(this));
      return;
      paramInt = 480;
      break;
    }
  }
  
  private void afo(int paramInt)
  {
    Object localObject = a(this.brs);
    if (localObject != null)
    {
      localObject = ((e)localObject).nx.iterator();
      while (((Iterator)localObject).hasNext())
      {
        aykd localaykd = (aykd)((Iterator)localObject).next();
        if (localaykd != null) {
          localaykd.afk(paramInt);
        }
      }
    }
  }
  
  private void buj()
  {
    boolean bool3 = false;
    AppInterface localAppInterface = null;
    if ((super.getContext() instanceof QQStoryBaseActivity)) {
      localAppInterface = ((QQStoryBaseActivity)super.getContext()).mApp;
    }
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalGifSource))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool3;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
      {
        bool2 = bool3;
        if (!aygz.r(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.aCQ, 262144))
        {
          bool2 = bool3;
          if (!VideoEnvironment.auL())
          {
            bool2 = bool3;
            if (awtj.isSupported()) {
              bool2 = true;
            }
          }
        }
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setStrokeStrategy(new ayti(localAppInterface, bool1, bool2, KQ()), true, 2);
      eSM();
      return;
    }
  }
  
  public static void e(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    rar.a("video_edit", paramString, paramInt1, paramInt2, paramVarArgs);
  }
  
  private void eSB()
  {
    ayju localayju = a();
    if ((localayju != null) && (this.dzM))
    {
      localayju.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView);
      localayju.a.a(new ayma(this));
      if (this.dzM)
      {
        ((aymu)localayju.a.b(102)).tO(false);
        localayju.a.a(new aymb(this));
        localayju.btO();
      }
    }
  }
  
  private void eSG()
  {
    ayoo.a locala;
    Object localObject;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.Lp())
    {
      locala = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a();
      locala.aIp = false;
      if (!(locala instanceof ayjn.b)) {
        break label118;
      }
      localObject = a();
      if (((((ayjn.b)locala).eGY != 1) && (((ayjn.b)locala).eGY != 3)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Lb()))) {
        break label147;
      }
      localObject = a();
      ((ayjn.b)locala).drawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    }
    label147:
    for (;;)
    {
      if (localObject != null) {}
      label118:
      do
      {
        ((ayjn)localObject).oJ.add((ayjn.b)locala);
        do
        {
          return;
        } while (!(locala instanceof ayjw.c));
        localObject = a();
      } while (localObject == null);
      ((ayjw)localObject).mItems.add((ayjw.c)locala);
      return;
    }
  }
  
  private void initUI()
  {
    this.fT = ((RelativeLayout)super.findViewById(2131377609));
    this.nm = ((ImageView)super.findViewById(2131369885));
    if (ayxa.aRq()) {
      this.fT.setPadding(0, ayxa.Sk(), 0, 0);
    }
    this.e = new d(null);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout = ((HorizontalSelectColorLayout)super.findViewById(2131372322));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnUndoViewClickListener(new ayly(this));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnStrokeSelectedListener(new aylz(this));
    View localView = super.findViewById(2131363675);
    if (localView != null) {
      localView.setVisibility(0);
    }
    buj();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)super.findViewById(2131366033));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView = ((DoodleEditView)super.findViewById(2131366034));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setDoodleLayout(this);
    setOnTextDialogShowListener(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setOnLayerTouchListener();
    this.jdField_c_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = ((DoodleView)super.findViewById(2131366040));
    resetUI();
  }
  
  private void k(ayoo.a parama)
  {
    if (parama != null)
    {
      if (!(parama instanceof ayjt.a)) {
        break label29;
      }
      a((ayjt.a)parama);
      ram.d("DoodleLayout", "delete interact item from edit layer.");
    }
    label29:
    while (!(parama instanceof aykb.b)) {
      return;
    }
    b((aykb.b)parama);
    ram.d("DoodleLayout", "delete vote item from edit layer.");
  }
  
  private void oo(long paramLong)
  {
    SegmentKeeper.adjustTime(-1L * paramLong);
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
    if (!this.dzS) {}
    while (this.aHN == paramBoolean) {
      return;
    }
    this.aHN = paramBoolean;
    if (paramBoolean)
    {
      ram.d("DoodleLayout", "rubbish active.");
      this.fT.setBackgroundColor(getResources().getColor(2131166623));
      this.nm.setImageResource(2130847664);
      return;
    }
    ram.d("DoodleLayout", "rubbish unActive.");
    this.fT.setBackgroundColor(getResources().getColor(2131166624));
    this.nm.setImageResource(2130847664);
  }
  
  private void xq(int paramInt)
  {
    if (this.jdField_a_of_type_Ayjs == null) {
      this.jdField_a_of_type_Ayjs = new ayjs(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    }
    Object localObject1 = (e)this.bb.get(paramInt);
    localObject1 = (ayki)this.jdField_ba_of_type_AndroidUtilSparseArray.get(paramInt);
    int i;
    if (localObject1 == null)
    {
      ram.d("DoodleLayout", "initDoodleView for the %d video", Integer.valueOf(paramInt));
      Object localObject4 = a();
      localObject1 = (ayjn)((g)localObject4).a(ayjn.TAG);
      ayjl localayjl = (ayjl)((g)localObject4).a("DynamicFaceLayer");
      Object localObject2 = (ayju)((g)localObject4).a("LineLayer");
      ayjw localayjw = (ayjw)((g)localObject4).a(ayjw.TAG);
      Object localObject3 = (ayjs)((g)localObject4).a("GuideLineLayer");
      if (localObject2 != null)
      {
        aymp localaymp = (aymp)((ayju)localObject2).a(103);
        if ((localaymp != null) && (this.mMosaicSize != -1)) {
          localaymp.setMosaicSize(this.mMosaicSize);
        }
        if ((localaymp != null) && (this.brt != -1) && (this.bru != -1)) {
          localaymp.setMosaicStandardSize(this.brt, this.bru);
        }
      }
      localObject4 = new ayki.a().a((aykf)localObject4);
      if (this.brv != -1)
      {
        i = this.brv;
        localObject4 = ((ayki.a)localObject4).a(i);
        if (this.brw == -1) {
          break label516;
        }
        i = this.brw;
        label254:
        localObject4 = ((ayki.a)localObject4).b(i).a();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig((ayki)localObject4);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleLayout(this);
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
        }
        localObject3 = new e(localayjw, (ayju)localObject2, (ayjn)localObject1, localayjl, (ayjs)localObject3, (ayjm)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(ayjm.TAG));
        this.jdField_ba_of_type_AndroidUtilSparseArray.put(paramInt, localObject4);
        this.bb.put(paramInt, localObject3);
        if (localObject2 != null)
        {
          ((ayju)localObject2).a(new f(null));
          ((ayju)localObject2).a(new aymc(this));
        }
        if (localObject1 != null) {
          ((ayjn)localObject1).a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$k);
        }
        if (localayjl != null) {
          localayjl.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$k);
        }
        localObject2 = new aymd(this);
        if (localObject1 != null) {
          ((ayjn)localObject1).a((ayjn.c)localObject2);
        }
        if (localayjl != null) {
          localayjl.a((ayjn.c)localObject2);
        }
        if (!this.aHM)
        {
          localayjw.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$k);
          localayjw.a(new l(null));
        }
        this.jdField_a_of_type_Axqn = ((axqn)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("PickLayer"));
      }
    }
    for (;;)
    {
      eSB();
      this.dp = false;
      return;
      i = 480;
      break;
      label516:
      i = 640;
      break label254;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setDoodleConfig((ayki)localObject1);
    }
  }
  
  public List<String> A(int paramInt)
  {
    Object localObject = (e)this.bb.get(paramInt);
    if (localObject != null)
    {
      localObject = ((e)localObject).jdField_b_of_type_Ayju.a.ce();
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
  
  public List<ayjn.b> B(int paramInt)
  {
    e locale = (e)this.bb.get(paramInt);
    if (locale != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(locale.jdField_a_of_type_Ayjn.oK);
      localArrayList.addAll(locale.jdField_a_of_type_Ayjl.oK);
      ram.d("DoodleLayout", "Using poi list:" + localArrayList.toString());
      return Collections.unmodifiableList(localArrayList);
    }
    return Collections.emptyList();
  }
  
  public String It()
  {
    Object localObject2 = "";
    Object localObject3 = a();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((ayjw)localObject3).mItems != null)
      {
        localObject1 = localObject2;
        if (!((ayjw)localObject3).mItems.isEmpty())
        {
          localObject1 = new JSONArray();
          localObject2 = ((ayjw)localObject3).mItems.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ayjw.c)((Iterator)localObject2).next();
            if ((((ayjw.c)localObject3).c != null) && (((ayjw.c)localObject3).c.a() != null)) {
              ((JSONArray)localObject1).put(((ayjw.c)localObject3).c.a().toString());
            }
          }
          localObject1 = ((JSONArray)localObject1).toString();
        }
      }
    }
    return localObject1;
  }
  
  public String Iu()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = a();
      if ((localObject1 != null) && (((ayjw)localObject1).mItems != null) && (!((ayjw)localObject1).mItems.isEmpty()))
      {
        localObject1 = ((ayjw)localObject1).mItems.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (ayjw.c)((Iterator)localObject1).next();
          if (((ayjw.c)localObject2).c != null)
          {
            localObject2 = axug.at(((ayjw.c)localObject2).c.getType());
            if ((localObject2 != null) && (((List)localObject2).size() > 0))
            {
              localObject2 = (String)((List)localObject2).get(0);
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localStringBuilder.append((String)localObject2);
                localStringBuilder.append(",");
              }
            }
          }
        }
      }
      if (localException.length() <= 0) {
        break label155;
      }
    }
    catch (Exception localException)
    {
      return "empty";
    }
    localException.deleteCharAt(localException.length() - 1);
    return localException.toString();
    label155:
    return "empty";
  }
  
  public String Iv()
  {
    Object localObject;
    ayjn.b localb;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = a();
      if ((localObject != null) && (((ayjn)localObject).oJ != null) && (!((ayjn)localObject).oJ.isEmpty()))
      {
        localObject = ((ayjn)localObject).oJ.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localb = (ayjn.b)((Iterator)localObject).next();
          if ((localb != null) && (!TextUtils.isEmpty(localb.name)))
          {
            localStringBuilder.append(localb.name);
            localStringBuilder.append(",");
          }
        }
      }
      localObject = a();
    }
    catch (Exception localException)
    {
      return "empty";
    }
    if ((localObject != null) && (((ayjl)localObject).oJ != null) && (!((ayjl)localObject).oJ.isEmpty()))
    {
      localObject = ((ayjl)localObject).oJ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localb = (ayjn.b)((Iterator)localObject).next();
        if ((localb != null) && (!TextUtils.isEmpty(localb.name)))
        {
          localException.append(localb.name);
          localException.append(",");
        }
      }
    }
    if (localException.length() > 0)
    {
      localException.deleteCharAt(localException.length() - 1);
      return localException.toString();
    }
    return "empty";
  }
  
  public boolean KQ()
  {
    if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b != null) {
      return this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b.La();
    }
    return true;
  }
  
  public void N(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ram.d("DoodleLayout", String.format("changeDoodleViewSize, width: %d, height: %d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    setDoodleBitmapMaxSize(paramInt1, paramInt2);
    int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getWidth();
    int m = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getHeight();
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
    ((RelativeLayout.LayoutParams)localObject).height = paramInt2;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (!paramBoolean) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.buz();
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.recycleBitmap();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.onSizeChanged(paramInt1, paramInt2, i, m);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.ei(paramInt1, paramInt2);
    }
    localObject = (aymp)a().a(104);
    if (localObject != null) {
      ((aymp)localObject).buE();
    }
    if (this.dzM)
    {
      localObject = (RelativeLayout.LayoutParams)this.aH.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
      ((RelativeLayout.LayoutParams)localObject).height = paramInt2;
      this.aH.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public Bitmap U()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.U();
  }
  
  public Bitmap W()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$a == null) {
      return null;
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$a.W();
  }
  
  public void ZD(boolean paramBoolean)
  {
    this.jdField_a_of_type_Axqn.tJ(paramBoolean);
  }
  
  public void ZE(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      oo(System.currentTimeMillis());
      invalidate();
      return;
    }
    oo(this.aCU);
    setTimeStamp(this.aCT, true);
  }
  
  public void Zs(boolean paramBoolean)
  {
    ayjl localayjl = a();
    if (localayjl != null) {
      localayjl.Zs(paramBoolean);
    }
  }
  
  /* Error */
  public Bitmap a(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 329	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView;
    //   4: invokevirtual 1036	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView:getBitmapWidth	()I
    //   7: istore_3
    //   8: aload_0
    //   9: getfield 329	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView	Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView;
    //   12: invokevirtual 1039	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleView:getBitmapHeight	()I
    //   15: istore 4
    //   17: iload_3
    //   18: ifle +8 -> 26
    //   21: iload 4
    //   23: ifgt +33 -> 56
    //   26: ldc_w 313
    //   29: ldc_w 1041
    //   32: iconst_2
    //   33: anewarray 874	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: iload_3
    //   39: invokestatic 752	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: iload 4
    //   47: invokestatic 752	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aastore
    //   51: invokestatic 1044	ram:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: aconst_null
    //   55: areturn
    //   56: aload_0
    //   57: getfield 173	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_ba_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   60: iconst_0
    //   61: invokevirtual 1047	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   64: ifeq +16 -> 80
    //   67: aload_0
    //   68: iload_3
    //   69: iload 4
    //   71: getstatic 1053	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   74: invokestatic 1059	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   77: putfield 1061	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:bd	Landroid/graphics/Bitmap;
    //   80: aload_0
    //   81: getfield 178	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:g	Ljava/util/concurrent/locks/Lock;
    //   84: invokeinterface 1064 1 0
    //   89: aload_0
    //   90: getfield 1061	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:bd	Landroid/graphics/Bitmap;
    //   93: astore 9
    //   95: aload 9
    //   97: ifnonnull +123 -> 220
    //   100: ldc_w 313
    //   103: ldc_w 1066
    //   106: invokestatic 1068	ram:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_0
    //   110: getfield 186	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_b_of_type_JavaUtilConcurrentLocksCondition	Ljava/util/concurrent/locks/Condition;
    //   113: ldc2_w 1069
    //   116: getstatic 1076	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   119: invokeinterface 1082 4 0
    //   124: ifne -35 -> 89
    //   127: ldc_w 313
    //   130: ldc_w 1084
    //   133: iconst_1
    //   134: anewarray 874	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: invokestatic 1090	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   142: invokevirtual 1093	java/lang/Thread:getId	()J
    //   145: invokestatic 1098	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   148: aastore
    //   149: invokestatic 1101	ram:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload_0
    //   153: getfield 1103	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaLangRuntimeException	Ljava/lang/RuntimeException;
    //   156: ifnull -67 -> 89
    //   159: ldc_w 313
    //   162: ldc_w 1105
    //   165: aload_0
    //   166: getfield 1103	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaLangRuntimeException	Ljava/lang/RuntimeException;
    //   169: invokestatic 1108	ram:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   172: goto -83 -> 89
    //   175: astore 9
    //   177: ldc_w 313
    //   180: ldc_w 1110
    //   183: aload 9
    //   185: invokestatic 1108	ram:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: goto -99 -> 89
    //   191: astore 9
    //   193: aload_0
    //   194: getfield 178	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:g	Ljava/util/concurrent/locks/Lock;
    //   197: invokeinterface 1113 1 0
    //   202: aload 9
    //   204: athrow
    //   205: astore 9
    //   207: ldc_w 313
    //   210: ldc_w 1115
    //   213: aload 9
    //   215: invokestatic 1117	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   218: aconst_null
    //   219: areturn
    //   220: aload_0
    //   221: getfield 1061	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:bd	Landroid/graphics/Bitmap;
    //   224: astore 9
    //   226: aload_0
    //   227: aconst_null
    //   228: putfield 1061	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:bd	Landroid/graphics/Bitmap;
    //   231: new 1119	android/graphics/Canvas
    //   234: dup
    //   235: aload 9
    //   237: invokespecial 1122	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   240: astore 10
    //   242: new 1124	android/graphics/Paint
    //   245: dup
    //   246: invokespecial 1125	android/graphics/Paint:<init>	()V
    //   249: astore 11
    //   251: aload 11
    //   253: new 1127	android/graphics/PorterDuffXfermode
    //   256: dup
    //   257: getstatic 1133	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   260: invokespecial 1136	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   263: invokevirtual 1140	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   266: pop
    //   267: aload 10
    //   269: aload 11
    //   271: invokevirtual 1144	android/graphics/Canvas:drawPaint	(Landroid/graphics/Paint;)V
    //   274: aload_0
    //   275: getfield 152	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:bb	Landroid/util/SparseArray;
    //   278: iload_1
    //   279: invokevirtual 742	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   282: checkcast 20	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout$e
    //   285: astore 11
    //   287: aload 11
    //   289: ifnonnull +35 -> 324
    //   292: ldc_w 313
    //   295: ldc_w 1146
    //   298: iconst_1
    //   299: anewarray 874	java/lang/Object
    //   302: dup
    //   303: iconst_0
    //   304: iload_1
    //   305: invokestatic 752	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   308: aastore
    //   309: invokestatic 1044	ram:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   312: aload_0
    //   313: getfield 178	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:g	Ljava/util/concurrent/locks/Lock;
    //   316: invokeinterface 1113 1 0
    //   321: aload 9
    //   323: areturn
    //   324: invokestatic 1151	android/os/SystemClock:uptimeMillis	()J
    //   327: lstore 5
    //   329: aload 11
    //   331: getfield 835	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout$e:jdField_b_of_type_Ayju	Layju;
    //   334: astore 12
    //   336: aload 12
    //   338: getfield 529	ayju:a	Laymk;
    //   341: invokevirtual 1154	aymk:Lt	()Z
    //   344: ifeq +142 -> 486
    //   347: ldc_w 313
    //   350: ldc_w 1156
    //   353: invokestatic 1068	ram:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload_0
    //   357: getfield 519	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:dzM	Z
    //   360: ifeq +117 -> 477
    //   363: aload_0
    //   364: getfield 452	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   367: ifnull +110 -> 477
    //   370: aload_0
    //   371: getfield 452	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   374: getfield 1159	dov/com/tencent/biz/qqstory/takevideo/EditVideoParams:asi	I
    //   377: iconst_1
    //   378: if_icmpne +99 -> 477
    //   381: aload 12
    //   383: getfield 529	ayju:a	Laymk;
    //   386: invokevirtual 1162	aymk:Lu	()Z
    //   389: ifeq +88 -> 477
    //   392: iconst_1
    //   393: newarray int
    //   395: astore 13
    //   397: aload 13
    //   399: iconst_0
    //   400: iconst_0
    //   401: iastore
    //   402: iconst_5
    //   403: istore_1
    //   404: aload 12
    //   406: getfield 529	ayju:a	Laymk;
    //   409: new 1164	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout$13
    //   412: dup
    //   413: aload_0
    //   414: aload 12
    //   416: iload_3
    //   417: aload 13
    //   419: invokespecial 1167	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout$13:<init>	(Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout;Layju;I[I)V
    //   422: invokevirtual 1170	aymk:N	(Ljava/lang/Runnable;)V
    //   425: aload 13
    //   427: iconst_0
    //   428: iaload
    //   429: istore_3
    //   430: iload_3
    //   431: iconst_1
    //   432: if_icmpeq +54 -> 486
    //   435: iload_1
    //   436: iconst_1
    //   437: isub
    //   438: istore_3
    //   439: iload_1
    //   440: ifle +46 -> 486
    //   443: ldc2_w 1069
    //   446: invokestatic 1173	java/lang/Thread:sleep	(J)V
    //   449: ldc_w 313
    //   452: ldc_w 1175
    //   455: iload_3
    //   456: invokestatic 752	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   459: invokestatic 755	ram:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   462: iload_3
    //   463: istore_1
    //   464: goto -39 -> 425
    //   467: astore 14
    //   469: aload 14
    //   471: invokevirtual 1178	java/lang/InterruptedException:printStackTrace	()V
    //   474: goto -25 -> 449
    //   477: aload 12
    //   479: getfield 529	ayju:a	Laymk;
    //   482: iload_3
    //   483: invokevirtual 1181	aymk:xu	(I)V
    //   486: aload_0
    //   487: getfield 452	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   490: ifnull +20 -> 510
    //   493: aload_0
    //   494: getfield 452	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams;
    //   497: invokevirtual 1182	dov/com/tencent/biz/qqstory/takevideo/EditVideoParams:La	()Z
    //   500: ifeq +10 -> 510
    //   503: aload 12
    //   505: aload 10
    //   507: invokevirtual 1186	ayju:ap	(Landroid/graphics/Canvas;)V
    //   510: aload_0
    //   511: getfield 282	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_b_of_type_Ayfw	Layfw;
    //   514: getfield 1191	ayfw:b	Laygz;
    //   517: invokevirtual 1194	aygz:iX	()J
    //   520: lstore 7
    //   522: lload 7
    //   524: lconst_0
    //   525: lcmp
    //   526: ifeq +33 -> 559
    //   529: iload_2
    //   530: ifeq +29 -> 559
    //   533: aload_0
    //   534: getfield 282	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_b_of_type_Ayfw	Layfw;
    //   537: lload 7
    //   539: invokevirtual 1197	ayfw:ol	(J)V
    //   542: aload_0
    //   543: getfield 282	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:jdField_b_of_type_Ayfw	Layfw;
    //   546: invokevirtual 1200	ayfw:a	()Ldov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout;
    //   549: lload 7
    //   551: ldc2_w 1201
    //   554: ldiv
    //   555: iconst_0
    //   556: invokevirtual 1025	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:setTimeStamp	(JZ)V
    //   559: new 1204	java/util/LinkedList
    //   562: dup
    //   563: aload 11
    //   565: getfield 421	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout$e:nx	Ljava/util/ArrayList;
    //   568: invokespecial 1207	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   571: astore 11
    //   573: aload 11
    //   575: aload_0
    //   576: getfield 202	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:au	Ljava/util/Comparator;
    //   579: invokestatic 1211	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   582: aload 11
    //   584: invokevirtual 1212	java/util/LinkedList:size	()I
    //   587: iconst_1
    //   588: isub
    //   589: istore_1
    //   590: iload_1
    //   591: iflt +35 -> 626
    //   594: aload 11
    //   596: iload_1
    //   597: invokevirtual 1213	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   600: checkcast 438	aykd
    //   603: astore 12
    //   605: aload 12
    //   607: ifnull +119 -> 726
    //   610: aload 12
    //   612: aload 10
    //   614: aload 12
    //   616: invokevirtual 1217	aykd:cg	()F
    //   619: iload_2
    //   620: invokevirtual 1220	aykd:a	(Landroid/graphics/Canvas;FZ)V
    //   623: goto +103 -> 726
    //   626: iload_2
    //   627: ifeq +49 -> 676
    //   630: aload 11
    //   632: invokevirtual 1212	java/util/LinkedList:size	()I
    //   635: iconst_1
    //   636: isub
    //   637: istore_1
    //   638: iload_1
    //   639: iflt +37 -> 676
    //   642: aload 11
    //   644: iload_1
    //   645: invokevirtual 1213	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   648: checkcast 438	aykd
    //   651: astore 12
    //   653: aload 12
    //   655: ifnull +64 -> 719
    //   658: aload 12
    //   660: instanceof 769
    //   663: ifeq +56 -> 719
    //   666: aload 12
    //   668: checkcast 769	ayjl
    //   671: aload 10
    //   673: invokevirtual 1222	ayjl:cg	(Landroid/graphics/Canvas;)V
    //   676: ldc_w 313
    //   679: new 315	java/lang/StringBuilder
    //   682: dup
    //   683: invokespecial 316	java/lang/StringBuilder:<init>	()V
    //   686: ldc_w 1224
    //   689: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: invokestatic 1151	android/os/SystemClock:uptimeMillis	()J
    //   695: lload 5
    //   697: lsub
    //   698: invokevirtual 1227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   701: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokestatic 346	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   707: aload_0
    //   708: getfield 178	dov/com/tencent/biz/qqstory/takevideo/doodle/ui/doodle/DoodleLayout:g	Ljava/util/concurrent/locks/Lock;
    //   711: invokeinterface 1113 1 0
    //   716: aload 9
    //   718: areturn
    //   719: iload_1
    //   720: iconst_1
    //   721: isub
    //   722: istore_1
    //   723: goto -85 -> 638
    //   726: iload_1
    //   727: iconst_1
    //   728: isub
    //   729: istore_1
    //   730: goto -140 -> 590
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	733	0	this	DoodleLayout
    //   0	733	1	paramInt	int
    //   0	733	2	paramBoolean	boolean
    //   7	476	3	i	int
    //   15	55	4	m	int
    //   327	369	5	l1	long
    //   520	30	7	l2	long
    //   93	3	9	localBitmap1	Bitmap
    //   175	9	9	localInterruptedException1	java.lang.InterruptedException
    //   191	12	9	localObject1	Object
    //   205	9	9	localOutOfMemoryError	OutOfMemoryError
    //   224	493	9	localBitmap2	Bitmap
    //   240	432	10	localCanvas	android.graphics.Canvas
    //   249	394	11	localObject2	Object
    //   334	333	12	localObject3	Object
    //   395	31	13	arrayOfInt	int[]
    //   467	3	14	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   100	172	175	java/lang/InterruptedException
    //   89	95	191	finally
    //   100	172	191	finally
    //   177	188	191	finally
    //   220	287	191	finally
    //   292	312	191	finally
    //   324	397	191	finally
    //   404	425	191	finally
    //   443	449	191	finally
    //   449	462	191	finally
    //   469	474	191	finally
    //   477	486	191	finally
    //   486	510	191	finally
    //   510	522	191	finally
    //   533	559	191	finally
    //   559	590	191	finally
    //   594	605	191	finally
    //   610	623	191	finally
    //   630	638	191	finally
    //   642	653	191	finally
    //   658	676	191	finally
    //   676	707	191	finally
    //   67	80	205	java/lang/OutOfMemoryError
    //   443	449	467	java/lang/InterruptedException
  }
  
  public axqg a()
  {
    return this.e;
  }
  
  public ayjl a()
  {
    e locale = (e)this.bb.get(this.brs);
    if (locale == null)
    {
      ram.w("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.brs) });
      return null;
    }
    return locale.jdField_a_of_type_Ayjl;
  }
  
  public ayjm a()
  {
    e locale = (e)this.bb.get(this.brs);
    if (locale == null)
    {
      ram.w("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.brs) });
      return null;
    }
    return locale.jdField_a_of_type_Ayjm;
  }
  
  public ayjn a()
  {
    e locale = (e)this.bb.get(this.brs);
    if (locale == null)
    {
      ram.w("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.brs) });
      return null;
    }
    return locale.jdField_a_of_type_Ayjn;
  }
  
  public ayju a()
  {
    e locale = (e)this.bb.get(this.brs);
    if (locale == null)
    {
      ram.w("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.brs) });
      return null;
    }
    return locale.jdField_b_of_type_Ayju;
  }
  
  public ayjw a()
  {
    e locale = (e)this.bb.get(this.brs);
    if (locale == null)
    {
      ram.w("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.brs) });
      return null;
    }
    return locale.jdField_b_of_type_Ayjw;
  }
  
  public aykb a()
  {
    return this.jdField_b_of_type_Aykb;
  }
  
  public e a(int paramInt)
  {
    return (e)this.bb.get(paramInt);
  }
  
  protected g a()
  {
    return new g(new aykd[] { this.jdField_a_of_type_Ayjs, new axqn(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView), new ayjn(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView), new ayjl(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView), new ayju(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView), new ayjw(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView) });
  }
  
  public void a(ayjt.a parama)
  {
    b().clear();
  }
  
  public void a(DynamicTextItem paramDynamicTextItem, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.mExtra != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.La()) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.mExtra.getBoolean("key_enable_edit_title_bar"))) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramDynamicTextItem, paramInt1, paramInt2, paramBoolean, bool);
      return;
    }
  }
  
  public void a(DynamicTextItem paramDynamicTextItem, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    ram.d("DoodleLayout", "onClickInside: showEditTextDialog." + paramDynamicTextItem);
    if (paramDynamicTextItem != null) {
      paramDynamicTextItem.eOU();
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$c = new c(null);
    this.jdField_a_of_type_Aykw = new aykw(super.getContext(), paramBoolean1);
    if ((this.jdField_b_of_type_Ayfw != null) && (this.jdField_b_of_type_Ayfw.b.ok != null)) {
      this.jdField_a_of_type_Aykw.ok = this.jdField_b_of_type_Ayfw.b.ok;
    }
    if ((((Activity)getContext()).getWindow().getAttributes().flags & 0x400) == 1024)
    {
      paramBoolean1 = true;
      this.jdField_a_of_type_Aykw.Zz(paramBoolean1);
      this.jdField_a_of_type_Aykw.mMode = paramInt2;
      aykw localaykw = this.jdField_a_of_type_Aykw;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.La())) {
        break label301;
      }
      paramBoolean1 = true;
      label173:
      localaykw.setEditPhoto(paramBoolean1);
      this.jdField_a_of_type_Aykw.xn(tr());
      this.jdField_a_of_type_Aykw.Zy(paramBoolean2);
      this.jdField_a_of_type_Aykw.setContentView(2131561829);
      this.jdField_a_of_type_Aykw.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$c);
      this.jdField_a_of_type_Aykw.a(this.jdField_a_of_type_Axug);
      if (paramInt2 == 0)
      {
        if ((paramDynamicTextItem instanceof axvb)) {
          ((axvb)paramDynamicTextItem).setTextColor(aytj.R(KQ()));
        }
        this.jdField_a_of_type_Aykw.a(paramDynamicTextItem, paramInt1);
      }
      this.jdField_a_of_type_Aykw.show();
      invalidate();
      if (this.brx != 0) {
        break label307;
      }
    }
    for (;;)
    {
      setState(3);
      xs(3);
      return;
      paramBoolean1 = false;
      break;
      label301:
      paramBoolean1 = false;
      break label173;
      label307:
      if (this.brx == 1)
      {
        f(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
        setDoodleGLViewVisibility(0);
      }
      else if (this.brx == 2)
      {
        e(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
        a().tJ(false);
      }
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2, Rect paramRect, float paramFloat3)
  {
    boolean bool = false;
    if (paramRect == null) {}
    for (int i = 0;; i = paramRect.width() / 2)
    {
      if ((paramFloat1 < -i) || (paramFloat2 < -i) || (paramFloat1 > this.mDisplayRect.width() + i) || (paramFloat2 > i + this.mDisplayRect.height() + paramFloat3)) {
        bool = true;
      }
      return bool;
    }
  }
  
  public boolean a(ayjw.c paramc, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) && (paramc != null))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
      }
      eSG();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.d(paramc);
      paramc.aIp = true;
      Object localObject = paramc.mSegmentKeeper;
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.aQN()) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((SegmentKeeper)localObject).lockData(paramBoolean);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
        localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a();
        if ((localObject != null) && (((ayjv)localObject).a != null) && (paramc.c != null) && (paramc.c.aPK()))
        {
          paramc.c.eOV();
          ((ayjv)localObject).a.a(paramc, paramc.c.Rw(), 0, 0.0F, 0.0F);
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean aQO()
  {
    return (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() == a());
  }
  
  public boolean aQP()
  {
    return (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() == this.jdField_a_of_type_Axqn);
  }
  
  public boolean aQQ()
  {
    return this.dzO;
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
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
    }
    for (;;)
    {
      f(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(new aylx(this));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.startAnimation(localAlphaAnimation);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$a != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$a.d(localAlphaAnimation);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Personality", 2, "exitFullScreen");
      }
      return;
      label135:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
    }
  }
  
  public void aw(Map<Long, TrackerStickerParam.MotionInfo> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoodleLayout", 2, "notifyFinishMotionTrack");
    }
    ThreadManager.getUIHandler().post(new DoodleLayout.16(this, paramMap));
  }
  
  public ayjt b()
  {
    return this.jdField_b_of_type_Ayjt;
  }
  
  public Map<String, List<String>> b(int paramInt)
  {
    Object localObject = (e)this.bb.get(paramInt);
    if (localObject != null)
    {
      localObject = ((e)localObject).jdField_a_of_type_Ayjn.gg;
      ram.d("DoodleLayout", "Using face map:" + localObject.toString());
      return Collections.unmodifiableMap((Map)localObject);
    }
    return Collections.emptyMap();
  }
  
  public void b(ayjt.a parama, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_b_of_type_Ayfw != null)
    {
      aydk localaydk = (aydk)this.jdField_b_of_type_Ayfw.a(aydk.class);
      if (localaydk != null) {
        localaydk.a(parama, paramFloat1, paramFloat2);
      }
    }
    b().eSm();
  }
  
  public void b(aykb.b paramb)
  {
    a().clear();
  }
  
  public void b(aykb.b paramb, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_b_of_type_Ayfw != null)
    {
      ayio localayio = (ayio)this.jdField_b_of_type_Ayfw.a(ayio.class);
      if (localayio != null) {
        localayio.a(paramb, paramFloat1, paramFloat2);
      }
    }
    a().eSm();
  }
  
  public void b(aynd.a parama, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    b(parama, paramFloat1, paramFloat2, paramFloat3, null);
  }
  
  public void b(aynd.a parama, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper)
  {
    checkMainThread();
    if (parama == null) {
      ram.e("DoodleLayout", "the item is null.");
    }
    for (;;)
    {
      return;
      ram.d("DoodleLayout", "addLocationFaceItem:" + parama.toString());
      ayjn.d locald = ayon.a(parama, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getWidth(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getHeight(), paramFloat1, paramFloat2, paramFloat3);
      File localFile;
      Object localObject;
      if (locald != null)
      {
        if ((parama.dj == null) || (!(parama.dj instanceof URLDrawable))) {
          break label231;
        }
        localFile = ((URLDrawable)parama.dj).getFileInLocal();
        if ((localFile == null) || (!localFile.exists())) {
          break label231;
        }
        localObject = a();
        if (((parama.eKG == 1) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null)) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Lb())) {
          localObject = a();
        }
      }
      label231:
      for (boolean bool = ((ayjn)localObject).a(parama.packageName, parama.desc, parama.dj, locald, localFile.getAbsolutePath(), true, parama.eKG, getFrom(), paramSegmentKeeper); bool; bool = false)
      {
        this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b.a(parama);
        ras.so("0X80076CE");
        ZF(this.dzQ);
        return;
        ram.e("DoodleLayout", "create FaceLayer.ItemParams failed.");
        return;
      }
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (this.dzO) {}
    for (;;)
    {
      return;
      if (this.jdField_b_of_type_Ayfw != null) {
        break;
      }
      if (((this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b instanceof axoo)) || ((this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b instanceof awwk)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoodleLayout", 2, "mEditDoodlePart == null && mListener instanceof QIMCaptureController/AECaptureController, showLimitBorder");
        }
        if ((this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b instanceof axoo)) {}
        for (int i = ((axoo)this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b).busType; (i != 11) && (i != 12); i = 0)
        {
          g(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
          return;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoodleLayout", 2, "mEditDoodlePart != null || mListener is not instanceof QIMCaptureController/AECaptureController, broadcast showLimitBorder message");
    }
    this.jdField_b_of_type_Ayfw.b.a(Message.obtain(null, 17, 0, 0, new aygt.a(paramBoolean3, paramBoolean4, paramBoolean2, paramBoolean1, paramBoolean5)));
  }
  
  public void brZ()
  {
    ThreadManager.getUIHandler().post(new DoodleLayout.6(this));
  }
  
  public void buh()
  {
    checkMainThread();
    ram.d("DoodleLayout", "onFacePressed, buttonState:" + this.brx + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    ras.bv("0X80076BA", ras.bpq);
    if (this.brx == 0) {}
    for (;;)
    {
      setState(1);
      do
      {
        return;
        if (this.brx != 3) {
          break;
        }
        setState(1);
        this.jdField_a_of_type_Aykw.nN(false);
      } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView == null);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.tK(true);
      return;
      if (this.brx == 2)
      {
        a().tJ(false);
        e(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
      }
    }
  }
  
  public void bui()
  {
    checkMainThread();
    ram.d("DoodleLayout", "onLinePressed, buttonState:" + this.brx + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    ras.bv("0X80076B8", ras.bpq);
    ayju localayju = a();
    f(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
    localayju.tJ(true);
    eSM();
    if (localayju.a.tt() > 0)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
      if (this.brx != 0) {
        break label129;
      }
    }
    for (;;)
    {
      setState(2);
      label129:
      do
      {
        return;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
        break;
        if (this.brx != 3) {
          break label166;
        }
        setState(2);
        this.jdField_a_of_type_Aykw.nN(false);
      } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView == null);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.tK(true);
      return;
      label166:
      if (this.brx == 1)
      {
        f(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
        setDoodleGLViewVisibility(0);
      }
    }
  }
  
  public void buk()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.buk();
  }
  
  public void bul()
  {
    this.aHM = true;
    int i = 0;
    while (i < this.bb.size())
    {
      ayjw localayjw = ((e)this.bb.valueAt(i)).jdField_b_of_type_Ayjw;
      localayjw.a(null);
      localayjw.a(null);
      i += 1;
    }
  }
  
  public void c(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    if (this.jdField_a_of_type_Ayjs == null) {
      return;
    }
    this.jdField_a_of_type_Ayjs.a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
  }
  
  public String cb(int paramInt)
  {
    Object localObject = (e)this.bb.get(paramInt);
    if (localObject == null)
    {
      ram.w("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    localObject = ((e)localObject).jdField_b_of_type_Ayjw;
    if ((((ayjw)localObject).mItems != null) && (!((ayjw)localObject).mItems.isEmpty()))
    {
      localObject = ((ayjw)localObject).mItems.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ayjw.c localc = (ayjw.c)((Iterator)localObject).next();
        if (localc.c != null)
        {
          localObject = localc.c.a().toString();
          return ((String)localObject).substring(0, ((String)localObject).length() - 1);
        }
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
  
  public void cm(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.E(localJSONObject)) {
        paramJSONObject.put(ayfw.cWP, localJSONObject);
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public void d(ayjn.b paramb)
  {
    this.jdField_c_of_type_Ayjn$b = paramb;
    if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b != null)
    {
      ram.d("DoodleLayout", "selectLocation: clickItem-->" + paramb.toString());
      this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b.ss(this.jdField_c_of_type_Ayjn$b.getText());
    }
  }
  
  public void db(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.Nz == null) {
      this.Nz = new ArrayList();
    }
    long l = System.currentTimeMillis();
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        this.aCU = l;
        this.Nz.clear();
        afo(0);
        oo(this.aCU);
      }
    }
    for (this.dzN = false;; this.dzN = true)
    {
      this.aCT = l;
      return;
      this.aCU += l - this.aCT;
      break;
      this.Nz.add(Long.valueOf(l - this.aCT));
    }
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
  
  public void eNv()
  {
    if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b != null) {
      this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b.eNv();
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.bue();
    }
    ZF(this.dzQ);
  }
  
  public void eNz()
  {
    if ((this.Nz != null) && (this.Nz.size() > 0))
    {
      long l1 = System.currentTimeMillis();
      long l2 = ((Long)this.Nz.remove(this.Nz.size() - 1)).longValue();
      long l3 = this.aCU;
      this.aCU = (l2 + l1 - this.aCT + l3);
      this.aCT = l1;
      oo(this.aCU);
      setTimeStamp(l1, true);
    }
  }
  
  public void eO(int paramInt, String paramString)
  {
    checkMainThread();
    ram.d("DoodleLayout", "addNewSticker, buttonState:" + this.brx + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    ayjw localayjw = a();
    paramString = this.jdField_a_of_type_Axug.a(paramInt, Arrays.asList(new String[] { paramString }));
    a().a(getFrom());
    a().b(paramString);
    localayjw.tJ(true);
    a().setMode(4);
  }
  
  public boolean eQ(int paramInt)
  {
    return this.j.get(paramInt, false);
  }
  
  public boolean eR(int paramInt)
  {
    return this.k.get(paramInt, false);
  }
  
  public void eSA()
  {
    this.dzS = false;
  }
  
  public void eSC()
  {
    if (this.jdField_b_of_type_Ayfw != null)
    {
      ayfv localayfv = (ayfv)this.jdField_b_of_type_Ayfw.a(ayfv.class);
      if (localayfv != null) {
        localayfv.a(this);
      }
    }
  }
  
  public void eSD()
  {
    if (this.brx == 3)
    {
      setState(0);
      this.jdField_a_of_type_Aykw.nN(false);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.tK(true);
      }
    }
  }
  
  public void eSE()
  {
    if (this.brx == 3)
    {
      setState(0);
      xs(0);
      this.jdField_a_of_type_Aykw.nN(false);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.tK(true);
      }
    }
  }
  
  public void eSF()
  {
    if (this.brx == 3)
    {
      setState(0);
      xs(0);
      this.jdField_a_of_type_Aykw.nN(false);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.tK(true);
      }
    }
  }
  
  public void eSH()
  {
    checkMainThread();
    ram.d("DoodleLayout", "onTextPressed, buttonState:" + this.brx + ",activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a());
    a().tJ(true);
    DynamicTextItem localDynamicTextItem = a().a(getFrom());
    a(a().a(), false);
    if (localDynamicTextItem != null)
    {
      a(localDynamicTextItem, 0, 0, true);
      return;
    }
    QQToast.a(getContext(), getContext().getString(2131700432), 0).show();
    ThreadManager.getUIHandler().post(new DoodleLayout.12(this));
  }
  
  public void eSI()
  {
    aymp localaymp = (aymp)a().a(104);
    if (localaymp != null) {
      localaymp.buE();
    }
  }
  
  public void eSJ()
  {
    this.dzN = false;
    afo(1);
    oo(System.currentTimeMillis());
  }
  
  public void eSK()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void eSL()
  {
    if ((this.jdField_b_of_type_Ayfw != null) && (this.jdField_b_of_type_Ayfw.b.ok != null))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  public void eSM()
  {
    Object localObject = a();
    if (localObject == null) {}
    while ((aymy)((ayju)localObject).a(101) == null) {
      return;
    }
    if (this.eKz == -1)
    {
      localObject = BaseApplicationImpl.getContext().getSharedPreferences("DoodleLay_State", 4);
      if ((((SharedPreferences)localObject).contains("Line_LastType")) && (((SharedPreferences)localObject).contains("Line_LastSubType"))) {
        break label97;
      }
      this.eKz = 0;
    }
    for (this.eKA = aytl.R(KQ());; this.eKA = ((SharedPreferences)localObject).getInt("Line_LastSubType", 0))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setSelectedStroke(this.eKz, this.eKA);
      return;
      label97:
      this.eKz = ((SharedPreferences)localObject).getInt("Line_LastType", 0);
    }
  }
  
  public void eSd()
  {
    ayju localayju = a();
    if (localayju != null) {
      localayju.eSd();
    }
  }
  
  public void eSz()
  {
    try
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView != null) {
        return;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView = ((StoryGuideLineView)findViewById(2131372903));
      aygt.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleLayout", 2, "makeSureInitLayout error : " + localException.getMessage());
      }
    }
  }
  
  public int ed(int paramInt)
  {
    e locale = (e)this.bb.get(paramInt);
    if (locale != null)
    {
      paramInt = locale.jdField_b_of_type_Ayjw.tp();
      int i = locale.jdField_b_of_type_Ayju.tp();
      int m = locale.jdField_a_of_type_Ayjn.tp();
      int n = locale.jdField_a_of_type_Ayjl.tp();
      ram.d("DoodleLayout", "DoodleCount: text->" + paramInt + ",line->" + i + ",face->" + m + " " + n);
      return n + (paramInt + i + m);
    }
    return 0;
  }
  
  public void f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b != null) {
      this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b.e(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    }
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
    return locale.jdField_b_of_type_Ayju.K();
  }
  
  public void g(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleLayout", 2, "show limitView in doodleLayout  , mStoryGuideLineView : " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView);
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView == null) {
      return;
    }
    if ((!paramBoolean3) || (paramBoolean4))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.ZI(true);
      if (!paramBoolean2) {
        break label94;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.eTa();
    }
    for (;;)
    {
      if (!paramBoolean1) {
        break label104;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.eTc();
      return;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.eSZ();
      break;
      label94:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.eTb();
    }
    label104:
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.eTd();
  }
  
  public int[] g(int paramInt)
  {
    Object localObject = (e)this.bb.get(paramInt);
    if (localObject != null)
    {
      localObject = ((e)localObject).jdField_b_of_type_Ayju.a.A();
      ram.d("DoodleLayout", "normal path count:" + localObject[0] + ",mosaic path count:" + localObject[1]);
      return localObject;
    }
    return new int[] { 0, 0 };
  }
  
  public int getBusinessId()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) {
      return 0;
    }
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg();
  }
  
  public int getCurrentState()
  {
    return this.brx;
  }
  
  public int getFrom()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.getFrom() == 1)) {}
    while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.getFrom() != 0) {
      return 1;
    }
    return 0;
  }
  
  public Bitmap h(int paramInt)
  {
    e locale = (e)this.bb.get(paramInt);
    if (locale != null) {
      return locale.jdField_b_of_type_Ayju.X();
    }
    return null;
  }
  
  public int[] h(int paramInt)
  {
    Object localObject = (e)this.bb.get(paramInt);
    if (localObject != null)
    {
      localObject = ((e)localObject).jdField_a_of_type_Ayjn.z();
      ram.d("DoodleLayout", "normal face count:" + localObject[0] + ",location face count:" + localObject[1]);
      return localObject;
    }
    return new int[] { 0, 0 };
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.isEmpty();
  }
  
  public void lB(int paramInt1, int paramInt2)
  {
    this.eKz = paramInt1;
    this.eKA = paramInt2;
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("DoodleLay_State", 4).edit();
    localEditor.putInt("Line_LastType", paramInt1);
    localEditor.putInt("Line_LastSubType", paramInt2);
    localEditor.commit();
  }
  
  public void onClick(View paramView)
  {
    if (this.Cc > System.currentTimeMillis()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((!ab(false)) && (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b != null)) {
        this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b.close();
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.onDestroy();
    this.jdField_c_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.onDestroy();
    if (this.dzM) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.onDestroy();
    }
    super.onDetachedFromWindow();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() == this.jdField_a_of_type_Axqn)
    {
      xs(7);
      aykd localaykd = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(paramMotionEvent);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setActiveLayer(localaykd);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setTopLevelLayer(localaykd);
      localaykd.M(paramMotionEvent);
      this.dzT = true;
    }
    do
    {
      return true;
      if (!this.dzT) {
        break;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a().M(paramMotionEvent);
    } while ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3));
    this.dzT = false;
    return true;
    this.dzT = false;
    return false;
  }
  
  public void resetUI()
  {
    checkMainThread();
    f(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView, this.jdField_c_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView });
    setDoodleGLViewVisibility(0);
    e(new View[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout, this.fT });
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
    if ((this.brx == 3) && (this.jdField_a_of_type_Aykw != null))
    {
      setState(0);
      this.jdField_a_of_type_Aykw.nN(false);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.tK(true);
      }
      return;
    }
    setState(0);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.buy();
    this.jdField_c_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.buy();
  }
  
  public void s(int paramInt, Object paramObject)
  {
    if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b != null) {
      this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b.q(paramInt, paramObject);
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
  
  public String sQ(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = a();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((ayjn)localObject1).eO();
      if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
      {
        localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          TrackerStickerParam localTrackerStickerParam = (TrackerStickerParam)((Iterator)localObject2).next();
          if (localTrackerStickerParam.mSegmentKeeper != null) {
            localTrackerStickerParam.mSegmentKeeper.setAdjustTimeValid(false);
          }
        }
        localArrayList.addAll((Collection)localObject1);
      }
    }
    localObject1 = a();
    if (localObject1 != null)
    {
      paramString = ((ayjw)localObject1).at(paramString);
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        localObject1 = paramString.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (TrackerStickerParam)((Iterator)localObject1).next();
          if (((TrackerStickerParam)localObject2).mSegmentKeeper != null) {
            ((TrackerStickerParam)localObject2).mSegmentKeeper.setAdjustTimeValid(false);
          }
        }
        localArrayList.addAll(paramString);
      }
    }
    return TrackerStickerParam.ToJsonString(localArrayList);
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
        ((ayki)this.jdField_ba_of_type_AndroidUtilSparseArray.get(i)).bre = paramInt1;
        ((ayki)this.jdField_ba_of_type_AndroidUtilSparseArray.get(i)).brf = paramInt2;
        i += 1;
      }
    }
  }
  
  public void setDoodleBtnOperationHelper(a parama)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$a = parama;
  }
  
  public void setDoodleEventListener(b paramb)
  {
    this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b = paramb;
  }
  
  @TargetApi(14)
  public void setDoodleGLViewVisibility(int paramInt)
  {
    if (!this.dzM) {
      return;
    }
    if (!this.aHO)
    {
      ram.d("DoodleLayout", "setDoodleGLViewVisibility, soload failed, glview default invisible");
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView.xx(paramInt);
  }
  
  public void setEditMode(boolean paramBoolean)
  {
    this.dzO = true;
    this.dzP = paramBoolean;
  }
  
  public void setEditVideoDoodle(ayfw paramayfw)
  {
    this.jdField_b_of_type_Ayfw = paramayfw;
  }
  
  public void setEditVideoParams(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b(paramEditVideoParams);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.b(paramEditVideoParams);
    aHL = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.La();
    buj();
  }
  
  public void setEntrance(int paramInt)
  {
    this.entrance = paramInt;
  }
  
  public void setFaceLayerPosition(long paramLong)
  {
    int m = 0;
    Object localObject1 = a();
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((ayjn)localObject1).oJ;
      i = 0;
    }
    for (;;)
    {
      TrackerStickerParam.MotionInfo localMotionInfo;
      float f;
      if (i < ((List)localObject1).size())
      {
        ayjn.b localb = (ayjn.b)((List)localObject1).get(i);
        try
        {
          localMotionInfo = (TrackerStickerParam.MotionInfo)localb.qU.get(Long.valueOf(paramLong));
          if (localMotionInfo == null) {
            break label536;
          }
          if (!localMotionInfo.isLost)
          {
            localb.centerP.set(0.0F, 0.0F);
            localb.translateXValue = localMotionInfo.x;
            localb.translateYValue = localMotionInfo.y;
            f = localb.FM;
            localb.scaleValue = (localMotionInfo.scale * f);
          }
          else
          {
            localb.centerP.set(-2000.0F, 0.0F);
            localb.translateXValue = localMotionInfo.x;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (!QLog.isColorLevel()) {
            break label536;
          }
        }
        QLog.e("DoodleLayout", 2, "setFaceLayerPosition OOM :" + localOutOfMemoryError);
      }
      else
      {
        localObject1 = a();
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = ((ayjn)localObject1).oJ;
          i = 0;
          if (i < ((List)localObject1).size())
          {
            localObject2 = (ayjn.b)((List)localObject1).get(i);
            localMotionInfo = (TrackerStickerParam.MotionInfo)((ayjn.b)localObject2).qU.get(Long.valueOf(paramLong));
            if (localMotionInfo != null)
            {
              if (localMotionInfo.isLost) {
                break label333;
              }
              ((ayjn.b)localObject2).centerP.set(0.0F, 0.0F);
              ((ayjn.b)localObject2).translateXValue = localMotionInfo.x;
              ((ayjn.b)localObject2).translateYValue = localMotionInfo.y;
              f = ((ayjn.b)localObject2).FM;
              ((ayjn.b)localObject2).scaleValue = (localMotionInfo.scale * f);
            }
            for (;;)
            {
              i += 1;
              break;
              label333:
              ((ayjn.b)localObject2).centerP.set(-2000.0F, 0.0F);
              ((ayjn.b)localObject2).translateXValue = localMotionInfo.x;
            }
          }
        }
        localObject1 = a();
        if (localObject1 != null)
        {
          localObject1 = ((ayjw)localObject1).mItems;
          i = m;
          if (i < ((List)localObject1).size())
          {
            localObject2 = (ayjw.c)((List)localObject1).get(i);
            localMotionInfo = (TrackerStickerParam.MotionInfo)((ayjw.c)localObject2).qU.get(Long.valueOf(paramLong));
            if (localMotionInfo != null)
            {
              if (localMotionInfo.isLost) {
                break label495;
              }
              ((ayjw.c)localObject2).centerP.set(0.0F, 0.0F);
              ((ayjw.c)localObject2).translateXValue = localMotionInfo.x;
              ((ayjw.c)localObject2).translateYValue = localMotionInfo.y;
              f = ((ayjw.c)localObject2).FM;
              ((ayjw.c)localObject2).scaleValue = (localMotionInfo.scale * f);
            }
            for (;;)
            {
              i += 1;
              break;
              label495:
              ((ayjw.c)localObject2).centerP.set(-2000.0F, 0.0F);
              ((ayjw.c)localObject2).translateXValue = localMotionInfo.x;
            }
          }
        }
        ThreadManager.getUIHandler().post(new DoodleLayout.15(this));
        return;
      }
      label536:
      i += 1;
    }
  }
  
  public void setLocation(TroopBarPOI paramTroopBarPOI)
  {
    if (this.jdField_c_of_type_Ayjn$b == null)
    {
      ram.e("DoodleLayout", "ClickFaceItem not found.");
      return;
    }
    ram.d("DoodleLayout", "setLocation: clickItem-->" + this.jdField_c_of_type_Ayjn$b);
    a().a(this.jdField_c_of_type_Ayjn$b, paramTroopBarPOI);
    this.jdField_c_of_type_Ayjn$b = null;
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
      aymp localaymp = (aymp)((e)this.bb.valueAt(paramInt)).jdField_b_of_type_Ayju.a(103);
      if (localaymp != null) {
        localaymp.setMosaicSize(i);
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
        aymp localaymp = (aymp)((e)this.bb.valueAt(i)).jdField_b_of_type_Ayju.a(103);
        if (localaymp != null) {
          localaymp.setMosaicStandardSize(paramInt1, paramInt2);
        }
        i += 1;
      }
    }
  }
  
  public void setOnTextDialogShowListener(h paramh)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$h = paramh;
  }
  
  public void setRecording(boolean paramBoolean)
  {
    this.dp = paramBoolean;
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
  
  public void setTimeStamp(long paramLong, boolean paramBoolean)
  {
    if ((!this.dzN) || (paramBoolean))
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setTimeStamp(paramLong);
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setTimeStamp(paramLong);
      }
      if (this.jdField_c_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView != null) {
        this.jdField_c_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setTimeStamp(paramLong);
      }
    }
  }
  
  public void setTrackerState(ayoo.a parama, int paramInt)
  {
    if (parama == null) {}
    do
    {
      return;
      parama.eKr = paramInt;
    } while (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b == null);
    if (!parama.aQK())
    {
      float f3 = parama.centerP.x + parama.translateXValue - parama.width / 2.0F;
      float f4 = parama.centerP.y + parama.translateYValue - parama.height / 2.0F;
      float f2 = f4;
      float f1 = f3;
      if (parama.isAnchor)
      {
        f2 = f4;
        f1 = f3;
        if (parama.dzH)
        {
          f1 = parama.FJ + parama.FH - parama.width / 2.0F;
          f2 = parama.FK + parama.FI - parama.height / 2.0F;
        }
      }
      this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b.h(f1, f2, parama.width, parama.height);
      return;
    }
    this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$b.asq();
    parama.eSc();
  }
  
  public void setupPersonality()
  {
    this.aH = ((FrameLayout)super.findViewById(2131366035));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView = new DoodleTextureView(super.getContext());
    this.aH.addView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleTextureView, localLayoutParams);
    this.aHO = ankq.aya();
    if (!this.aHO)
    {
      e(new View[] { this.aH });
      setDoodleGLViewVisibility(4);
      this.dzM = false;
      return;
    }
    this.dzM = true;
    eSB();
  }
  
  protected int tr()
  {
    return azbx.dip2px(65.0F);
  }
  
  public int ts()
  {
    int i = 0;
    int m = 0;
    while (i < this.bb.size())
    {
      e locale = (e)this.bb.valueAt(i);
      m = m + locale.jdField_b_of_type_Ayjw.tp() + locale.jdField_b_of_type_Ayju.tp() + locale.jdField_a_of_type_Ayjn.tp() + locale.jdField_a_of_type_Ayjl.tp();
      i += 1;
    }
    return m;
  }
  
  public void undo()
  {
    checkMainThread();
    ayju localayju = a();
    ram.d("DoodleLayout", "undo, activeLayer:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() + ",pathCount:" + localayju.a.tt());
    if (localayju.isActive())
    {
      localayju.undo();
      if (localayju.a.tt() == 0) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
  }
  
  public void xp(int paramInt)
  {
    ram.d("DoodleLayout", "changeVideoIndex from %d to %d", Integer.valueOf(this.brs), Integer.valueOf(paramInt));
    this.brs = paramInt;
    xq(paramInt);
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
        if (!((aykd)((Iterator)localObject).next()).isEmpty()) {
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
    public abstract boolean La();
    
    public abstract void S(byte[] paramArrayOfByte);
    
    public abstract void a(aynd.a parama);
    
    public abstract void asq();
    
    public abstract void bsE();
    
    public abstract void bsF();
    
    public abstract void close();
    
    public abstract void d(Bitmap paramBitmap, boolean paramBoolean);
    
    public abstract void e(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);
    
    public abstract void eNv();
    
    public abstract void eNw();
    
    public abstract void eb(int paramInt1, int paramInt2);
    
    public abstract void h(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
    
    public abstract void q(int paramInt, Object paramObject);
    
    public abstract void ss(String paramString);
  }
  
  public class c
    implements aykw.a
  {
    private c() {}
    
    public void ZA(boolean paramBoolean)
    {
      ayjw localayjw = DoodleLayout.this.a();
      if (QLog.isColorLevel()) {
        QLog.i("DoodleLayout", 2, "onSoftKeyboardStateChange show:" + paramBoolean);
      }
      if (paramBoolean)
      {
        localayjw.tI(true);
        if (DoodleLayout.a(DoodleLayout.this) != null)
        {
          DoodleLayout.a(DoodleLayout.this).eSN();
          DoodleLayout.a(DoodleLayout.this, null);
        }
        return;
      }
      DoodleLayout.a(DoodleLayout.this, null);
      localayjw.tI(false);
      if (DoodleLayout.this.brx == 3)
      {
        DoodleLayout.this.setState(0);
        DoodleLayout.this.xs(0);
      }
      DoodleLayout.this.b.bsF();
    }
    
    public void ZB(boolean paramBoolean)
    {
      if ((DoodleLayout.this.a != null) && (!paramBoolean)) {
        DoodleLayout.d(DoodleLayout.this);
      }
      if ((!paramBoolean) || (DoodleLayout.this.a().aQI()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("DoodleLayout", 2, "onDialogLayout needAnim:" + paramBoolean + " y:" + DoodleLayout.this.a().atp);
        }
        if (DoodleLayout.a(DoodleLayout.this) != null) {
          DoodleLayout.a(DoodleLayout.this).Zv(true);
        }
        DoodleLayout.this.a().Zv(paramBoolean);
      }
      for (;;)
      {
        DoodleLayout.this.setTrackerState(DoodleLayout.this.a().a, 0);
        return;
        DoodleLayout.a(DoodleLayout.this, new aymf(this, paramBoolean));
      }
    }
    
    public void a(DynamicTextItem paramDynamicTextItem, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      ayjw localayjw = DoodleLayout.this.a();
      if (paramBoolean1) {
        if ((paramDynamicTextItem == null) || (paramDynamicTextItem.isEmpty()) || ((paramDynamicTextItem.ot(0)) && (paramDynamicTextItem.getType() == 0) && (!paramBoolean2)))
        {
          localayjw.a(paramDynamicTextItem);
          if (DoodleLayout.this.a != null) {
            DoodleLayout.this.a.a.d(null);
          }
          paramInt = 0;
        }
      }
      for (;;)
      {
        if (DoodleLayout.this.a() != null) {
          DoodleLayout.this.a().eSi();
        }
        if (paramDynamicTextItem != null) {
          paramDynamicTextItem.eOU();
        }
        if ((DoodleLayout.a(DoodleLayout.this) != null) && (paramInt != 0)) {
          DoodleLayout.a(DoodleLayout.this).Zv(false);
        }
        if (paramInt != 0)
        {
          localayjw.eSh();
          DoodleLayout.ZG(DoodleLayout.this.dzQ);
        }
        DoodleLayout.a(DoodleLayout.this, null);
        if (DoodleLayout.this.a != null) {
          DoodleLayout.this.a.tK(true);
        }
        DoodleLayout.this.eSC();
        if (QLog.isColorLevel()) {
          QLog.d("DoodleLayout", 2, "raymondguo count " + localayjw.tp() + ", items:" + localayjw.mItems.size());
        }
        return;
        localayjw.b(paramDynamicTextItem);
        paramInt = 1;
        continue;
        if (paramInt == 0)
        {
          localayjw.eSf();
          if (DoodleLayout.this.a != null) {
            DoodleLayout.this.a.a.d(null);
          }
          paramInt = 0;
        }
        else
        {
          paramInt = 1;
        }
      }
    }
    
    public void eSt() {}
    
    public void lA(int paramInt1, int paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoodleLayout", 2, "onEditTextOffsetChange centerX:" + paramInt1 + " centerY:" + paramInt2);
      }
      DoodleLayout.this.a().lz(paramInt1, paramInt2);
    }
    
    public void n(int paramInt1, int paramInt2)
    {
      if (DoodleLayout.this.brx == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DoodleLayout", 2, "onPanelChanged old:" + paramInt1 + " new:" + paramInt2);
        }
        DoodleLayout.this.s(3, new Integer(paramInt2));
      }
    }
    
    public void xo(int paramInt)
    {
      DoodleLayout.this.a().xm(paramInt);
    }
  }
  
  class d
    implements axqg
  {
    private d() {}
    
    private boolean a(aykk paramaykk, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper, boolean paramBoolean)
    {
      boolean bool;
      if ((DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || ((DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.eKg == 0) && (DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.eKf == 0)) || (DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.eKg > DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.eKf))
      {
        ayjn.d locald = new ayjn.d(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, paramaykk.drawable.getIntrinsicWidth(), paramaykk.drawable.getIntrinsicHeight());
        if ((DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 3)) {
          LpReportInfo_pf00064.report(615, 6);
        }
        ayjn localayjn = DoodleLayout.this.a();
        Object localObject = localayjn;
        if (paramaykk.eGY == 1) {
          if (DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
          {
            localObject = localayjn;
            if (!DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Lb()) {}
          }
          else
          {
            localObject = DoodleLayout.this.a();
          }
        }
        bool = ((ayjn)localObject).a(paramaykk.category, paramaykk.name, paramaykk.drawable, locald, paramString, false, paramaykk.eGY, DoodleLayout.this.getFrom(), paramSegmentKeeper);
        if ((!DoodleLayout.this.dzQ) || (!bool)) {
          break label251;
        }
      }
      label251:
      for (paramBoolean = true;; paramBoolean = false)
      {
        DoodleLayout.ZG(paramBoolean);
        return bool;
        paramFloat2 = azbx.cIE / 2;
        break;
      }
    }
    
    public void a(aykk paramaykk, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
    {
      ram.d("DoodleLayout", "onNormalFaceSelected, item : %s , x : %s , y : %s , scale : %s path: %s", new Object[] { paramaykk, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), paramString });
      if (a(paramaykk, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper, true))
      {
        DoodleLayout.sx("clk_oneface");
        ras.so("0X80076CA");
        ras.sp("0X80075DF");
      }
      if (rma.a().tG() == 22) {
        LpReportInfo_pf00064.allReport(680, 8, 1);
      }
    }
    
    public void a(ayna.c paramc, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
    {
      if (paramc == null) {
        ram.e("DoodleLayout", "the item is null.");
      }
      label143:
      label277:
      label356:
      label492:
      label504:
      label507:
      label511:
      for (;;)
      {
        return;
        ram.a("DoodleLayout", "onInformationFaceSelected, pictureUrl: %s , x : %s , y : %s , scale : %f", paramc.cWb, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
        DoodleLayout.this.checkMainThread();
        ram.d("DoodleLayout", "addLocationFaceItem:" + paramc.toString());
        boolean bool = DoodleLayout.this.getContext() instanceof EditPicActivity;
        ayob localayob;
        Object localObject1;
        if (bool)
        {
          paramc.eGY = 0;
          localayob = aynb.a(paramc, DoodleLayout.this.getContext(), -1L);
          if (!bool) {
            break label474;
          }
          if (localayob == null) {
            break label507;
          }
          localObject1 = new BitmapDrawable(DoodleLayout.this.getContext().getResources(), localayob.ba());
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label511;
          }
          ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
          if (QLog.isColorLevel()) {
            QLog.d("DoodleLayout", 2, "[" + ((Drawable)localObject1).getIntrinsicWidth() + "," + ((Drawable)localObject1).getIntrinsicHeight() + "]");
          }
          ayjn.d locald;
          Object localObject2;
          int i;
          if ((DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || ((DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.eKg == 0) && (DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.eKf == 0)) || (DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.eKg > DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.eKf))
          {
            locald = new ayjn.d(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
            localObject2 = DoodleLayout.this.a();
            if ((paramc.eGY != 3) || ((DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (!DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Lb()))) {
              break label492;
            }
            i = 3;
            localObject2 = DoodleLayout.this.a();
            if (!TextUtils.isEmpty(paramString)) {
              break label504;
            }
            paramString = paramc.cWb;
          }
          for (;;)
          {
            bool = ((ayjn)localObject2).a(paramc.packageName, paramString, (Drawable)localObject1, locald, "", paramc.dAb, paramc.location, i, localayob.getData(), 0, DoodleLayout.this.getFrom());
            if (QLog.isColorLevel()) {
              QLog.d("DoodleLayout", 2, "add Face result" + bool);
            }
            if ((DoodleLayout.this.dzQ) && (bool)) {}
            for (bool = true;; bool = false)
            {
              DoodleLayout.ZG(bool);
              return;
              paramc.eGY = 3;
              break;
              localObject1 = localayob;
              break label143;
              paramFloat2 = azbx.cIE / 2;
              break label277;
              i = 0;
              break label356;
            }
          }
          localObject1 = null;
        }
      }
    }
    
    public void a(aynd.a parama, float paramFloat1, float paramFloat2, float paramFloat3)
    {
      ram.a("DoodleLayout", "onLocationFaceSelected, pictureUrl: %s , x : %s , y : %s , scale : %f", parama.imageUrl, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
      DoodleLayout.this.b(parama, paramFloat1, paramFloat2, paramFloat3);
      if ((DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 3)) {
        LpReportInfo_pf00064.report(615, 6);
      }
      ras.sp("0X80075E3");
    }
    
    public void a(aynd.a parama, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper)
    {
      ram.d("DoodleLayout", "onComboLocationFaceSelected, pictureUrl:" + parama.imageUrl);
      DoodleLayout.this.b(parama, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper);
      if ((DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 3)) {
        LpReportInfo_pf00064.report(615, 6);
      }
      ras.sp("0X80075E3");
    }
    
    public void b(aykk paramaykk, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
    {
      ram.d("DoodleLayout", "onInformationFaceSelected, item : %s , x : %s , y : %s , scale : %s path: %s", new Object[] { paramaykk, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), paramString });
      a(paramaykk, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper, false);
    }
    
    public void eNU()
    {
      DoodleLayout.this.a().eSa();
      DoodleLayout.this.a().eSa();
      DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
    }
    
    public void jR(String paramString1, String paramString2)
    {
      DoodleLayout.this.a().jU(paramString1, paramString2);
      DoodleLayout.this.a().jU(paramString1, paramString2);
      DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
    }
  }
  
  public static class e
  {
    @NonNull
    public final ayjl a;
    @NonNull
    public final ayjm a;
    @NonNull
    public final ayjn a;
    @NonNull
    public final ayjs a;
    @NonNull
    public final ayju b;
    @NonNull
    public final ayjw b;
    public final ArrayList<aykd> nx = new ArrayList();
    
    public e(@NonNull ayjw paramayjw, @NonNull ayju paramayju, @NonNull ayjn paramayjn, @NonNull ayjl paramayjl, @NonNull ayjs paramayjs, @NonNull ayjm paramayjm)
    {
      this.jdField_b_of_type_Ayjw = paramayjw;
      this.jdField_b_of_type_Ayju = paramayju;
      this.jdField_a_of_type_Ayjn = paramayjn;
      this.jdField_a_of_type_Ayjl = paramayjl;
      this.jdField_a_of_type_Ayjm = paramayjm;
      this.jdField_a_of_type_Ayjs = paramayjs;
      this.nx.add(paramayjn);
      this.nx.add(paramayjl);
      this.nx.add(paramayju);
      this.nx.add(paramayjw);
      this.nx.add(paramayjs);
    }
  }
  
  public class f
    implements aykd.a<ayju>
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
      ((AlphaAnimation)localObject).setAnimationListener(new aymg(this));
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      if (paramBoolean3) {
        localAlphaAnimation.setStartOffset(500L);
      }
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(new aymh(this));
      if (paramBoolean2) {
        localObject = localAlphaAnimation;
      }
      for (;;)
      {
        DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.startAnimation((Animation)localObject);
        DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setAnimationEndTime(DoodleLayout.a(DoodleLayout.this));
        if (DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$a != null) {
          DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$a.d((Animation)localObject);
        }
        return;
      }
    }
    
    public boolean a(ayju paramayju, MotionEvent paramMotionEvent)
    {
      aytl localaytl = DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.a();
      if (localaytl != null) {}
      int i;
      int j;
      switch (localaytl.type)
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
            i = localaytl.subType;
            if (i != aymy.brD) {
              DoodleLayout.this.k.put(DoodleLayout.this.brs, true);
            }
            for (;;)
            {
              localObject = (aymy)paramayju.a(101);
              if (localObject != null) {
                ((aymy)localObject).setLineColor(i);
              }
              if (paramayju.bz()) {
                break;
              }
              paramayju.btR();
              break;
              DoodleLayout.this.k.put(DoodleLayout.this.brs, false);
            }
            if (paramayju.Lo()) {
              break;
            }
            paramayju.btQ();
            break;
            Object localObject = null;
            if ((DoodleLayout.this.getContext() instanceof QQStoryBaseActivity)) {
              localObject = ((QQStoryBaseActivity)DoodleLayout.this.getContext()).mApp;
            }
            paramayju.a((AppInterface)localObject, 2, localaytl.subType);
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
            DoodleLayout.this.e(new View[] { DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Personality", 2, "LineLayer draw move hide");
            return false;
            DoodleLayout.this.s(5, Boolean.valueOf(true));
            p(true, false, true);
          }
          if (paramayju.a.tt() > 0) {
            DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
          }
          if (DoodleLayout.this.brx != 5) {
            break label516;
          }
          DoodleLayout.this.xs(2);
          DoodleLayout.this.setState(2);
          DoodleLayout.this.f(new View[] { DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
          p(true, true, true);
        } while (!QLog.isColorLevel());
        QLog.d("Personality", 2, "LineLayer draw up show");
        return false;
      } while ((Math.abs(j - this.mDownX) >= 3) || (Math.abs(i - this.mDownY) >= 3));
      if (DoodleLayout.this.brx == 6)
      {
        DoodleLayout.this.s(2, Boolean.valueOf(false));
        DoodleLayout.this.setState(2);
        DoodleLayout.this.f(new View[] { DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
        if (paramayju.a.tt() > 0) {}
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
      DoodleLayout.this.e(new View[] { DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
      if (paramayju.a.tt() > 0) {}
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
    implements aykf
  {
    ArrayList<aykd> Go = null;
    
    public g(aykd... paramVarArgs)
    {
      if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
        throw new IllegalArgumentException("layers should not be null or empty");
      }
      this.Go = new ArrayList(paramVarArgs.length);
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        aykd localaykd = paramVarArgs[i];
        if (localaykd != null) {
          this.Go.add(localaykd);
        }
        i += 1;
      }
    }
    
    public aykd a(String paramString)
    {
      int j = this.Go.size();
      int i = 0;
      while (i < j)
      {
        if (((aykd)this.Go.get(i)).getTag().equals(paramString)) {
          return (aykd)this.Go.get(i);
        }
        i += 1;
      }
      return null;
    }
    
    public void a(List<aykd> paramList, DoodleView paramDoodleView)
    {
      paramList.addAll(this.Go);
    }
  }
  
  public static abstract interface h
  {
    public abstract void Zv(boolean paramBoolean);
  }
  
  public static class i
  {
    public static boolean eS(int paramInt)
    {
      return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4) || (paramInt == 5) || (paramInt == 6);
    }
  }
  
  public static abstract interface j
  {
    public abstract void eSN();
  }
  
  class k
    implements aykd.a<aykd>
  {
    private final int PADDING = ayom.dip2px(DoodleLayout.a(DoodleLayout.this), 40.0F);
    private Rect aJ;
    private boolean dzU;
    private boolean dzV;
    
    private k() {}
    
    public boolean a(aykd paramaykd, MotionEvent paramMotionEvent)
    {
      boolean bool = true;
      if ((paramaykd instanceof ayjn)) {
        localRect = new Rect();
      }
      for (Rect localRect = ((ayjn)paramaykd).c(localRect);; localRect = null)
      {
        if (ayxa.isLiuHaiUseValid()) {}
        for (float f1 = ayxa.eMW;; f1 = 0.0F)
        {
          float f2 = f1;
          if (auwa.hasNavBar(DoodleLayout.this.getContext())) {
            f2 = f1 + auwa.getNavigationBarHeight(DoodleLayout.this.getContext());
          }
          f1 = paramMotionEvent.getX();
          float f3 = paramMotionEvent.getY();
          int i = (int)Math.abs(f3 - DoodleLayout.a(DoodleLayout.this));
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
              DoodleLayout.a(DoodleLayout.this, true);
              if (DoodleLayout.d(DoodleLayout.this)) {
                ayjd.t(DoodleLayout.this.fT, false);
              }
              this.aJ = new Rect();
              DoodleLayout.this.fT.getLocalVisibleRect(this.aJ);
              paramaykd = this.aJ;
              paramaykd.top -= this.PADDING;
              paramaykd = this.aJ;
              paramaykd.bottom += this.PADDING;
              DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getGlobalVisibleRect(DoodleLayout.this.mDisplayRect);
              DoodleLayout.this.xs(4);
              DoodleLayout.a(DoodleLayout.this, (int)f3);
              this.dzU = false;
              return false;
            } while ((i <= DoodleLayout.b(DoodleLayout.this)) || (this.aJ == null));
            if ((DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.La()) || (DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Le()))
            {
              i = (int)f1;
              j = DoodleLayout.this.mDisplayRect.left;
              k = (int)f3;
              m = DoodleLayout.this.mDisplayRect.top;
              if ((this.aJ.contains(i + j, k + m)) || (DoodleLayout.this.a(f1, f3, localRect, f2)))
              {
                DoodleLayout.a(DoodleLayout.this, true);
                this.dzU = true;
              }
            }
            for (;;)
            {
              this.dzV = true;
              return false;
              DoodleLayout.a(DoodleLayout.this, false);
              this.dzU = false;
              continue;
              if ((paramMotionEvent.getPointerCount() == 1) && (this.aJ.contains((int)f1, (int)f3)) && (DoodleLayout.d(DoodleLayout.this)))
              {
                DoodleLayout.a(DoodleLayout.this, true);
                this.dzU = true;
              }
              else
              {
                DoodleLayout.a(DoodleLayout.this, false);
                this.dzU = false;
              }
            }
          }
          if ((this.aJ != null) && ((DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.La()) || (DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Le())))
          {
            i = (int)f1;
            j = DoodleLayout.this.mDisplayRect.left;
            k = (int)f3;
            m = DoodleLayout.this.mDisplayRect.top;
            if ((DoodleLayout.e(DoodleLayout.this)) && ((this.aJ.contains(i + j, k + m)) || (DoodleLayout.this.a(f1, f3, localRect, f2))))
            {
              if ((paramaykd instanceof ayjn))
              {
                ram.d("DoodleLayout", "remove face.");
                ((ayjn)paramaykd).btM();
                DoodleLayout.this.c(false, 0.0F, 0, 0, null, false, 0);
                if (QLog.isColorLevel()) {
                  QLog.d("DoodleLayout", 2, "delete face, disable guideline");
                }
                DoodleLayout.a(DoodleLayout.this, false);
                DoodleLayout.this.eNv();
                DoodleLayout.this.eSC();
              }
            }
            else
            {
              label710:
              if ((!DoodleLayout.b(DoodleLayout.this)) || (DoodleLayout.c(DoodleLayout.this)) || (!(paramaykd instanceof ayjl))) {
                break label1150;
              }
              paramaykd = (ayjl)paramaykd;
              paramMotionEvent = paramaykd.jdField_a_of_type_Ayjn$b;
              if ((!paramaykd.jdField_a_of_type_Ayoo.a(paramMotionEvent, f1, f3, false)) || (paramaykd.aHA) || (!paramMotionEvent.dzB) || (paramMotionEvent.dzC)) {
                break label1150;
              }
              DoodleLayout.this.d(paramMotionEvent);
            }
          }
          label854:
          label1144:
          label1150:
          for (i = 1;; i = 0)
          {
            if (i == 0)
            {
              DoodleLayout.this.resetUI();
              DoodleLayout.this.xs(0);
            }
            DoodleLayout.a(DoodleLayout.this, false);
            if ((DoodleLayout.a(DoodleLayout.this) == null) && (DoodleLayout.a(DoodleLayout.this) != null))
            {
              DoodleLayout.this.g(false, false, false, false);
              if ((!DoodleLayout.this.dzQ) || (!this.dzV)) {
                break label1144;
              }
            }
            for (;;)
            {
              DoodleLayout.ZG(bool);
              this.dzV = false;
              return false;
              if ((paramaykd instanceof ayjw))
              {
                ram.d("DoodleLayout", "editpic remove text.");
                ((ayjw)paramaykd).delete();
                paramaykd.tJ(false);
                break;
              }
              if (!(paramaykd instanceof ayjv)) {
                break;
              }
              paramMotionEvent = ((ayjv)paramaykd).a();
              DoodleLayout.a(DoodleLayout.this, paramMotionEvent);
              ((ayjv)paramaykd).btS();
              break;
              if ((paramMotionEvent.getPointerCount() != 1) || (this.aJ == null) || (!this.aJ.contains((int)f1, (int)f3)) || (!this.dzU)) {
                break label710;
              }
              if ((paramaykd instanceof ayjw))
              {
                ram.d("DoodleLayout", "remove text.");
                ((ayjw)paramaykd).delete();
                paramaykd.tJ(false);
              }
              for (;;)
              {
                DoodleLayout.a(DoodleLayout.this, false);
                DoodleLayout.this.eNv();
                DoodleLayout.this.eSC();
                break;
                if ((paramaykd instanceof ayjn))
                {
                  ram.d("DoodleLayout", "remove face.");
                  ((ayjn)paramaykd).btM();
                }
                else if ((paramaykd instanceof ayjv))
                {
                  paramMotionEvent = ((ayjv)paramaykd).a();
                  DoodleLayout.a(DoodleLayout.this, paramMotionEvent);
                  DoodleLayout.this.setTrackerState(((ayjv)paramaykd).a(), 0);
                  ((ayjv)paramaykd).btS();
                }
              }
              DoodleLayout.a(DoodleLayout.this).b.a(Message.obtain(null, 17, 0, 0, new aygt.a(false, false, false, false, true)));
              break label854;
              bool = false;
            }
          }
        }
      }
    }
  }
  
  class l
    implements ayjw.a
  {
    private l() {}
    
    public boolean a(ayjw.c paramc)
    {
      if ((DoodleLayout.b(DoodleLayout.this)) && (!DoodleLayout.c(DoodleLayout.this))) {
        return false;
      }
      return DoodleLayout.this.a(paramc, true);
    }
    
    public void ad(float paramFloat)
    {
      if (paramFloat >= 0.95F)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoodleLayout", 2, "onAnimate:" + paramFloat);
        }
        if ((DoodleLayout.this.a != null) && (DoodleLayout.this.a() != null) && (DoodleLayout.this.a().a() != null)) {
          DoodleLayout.this.a.a(DoodleLayout.this.a().a(), DoodleLayout.this.a().a().Rw());
        }
      }
    }
    
    public void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
    {
      DoodleLayout.this.b(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
    }
    
    public void c(DynamicTextItem paramDynamicTextItem)
    {
      if (DoodleLayout.a(DoodleLayout.this)) {
        if (QLog.isColorLevel()) {
          QLog.d("DoodleLayout", 2, "onClickInside mIsRecording");
        }
      }
      long l;
      do
      {
        return;
        l = SystemClock.uptimeMillis();
      } while (l - DoodleLayout.this.aCV <= 500L);
      DoodleLayout.this.aCV = l;
      DoodleLayout.this.a(paramDynamicTextItem, paramDynamicTextItem.Rw(), 1, true);
    }
  }
  
  class m
    implements aykd.a<aykb>
  {
    private final int PADDING = ayom.dip2px(DoodleLayout.b(DoodleLayout.this), 40.0F);
    private Rect aJ;
    
    private m() {}
    
    public boolean a(aykb paramaykb, MotionEvent paramMotionEvent)
    {
      float f3 = paramMotionEvent.getX();
      float f4 = paramMotionEvent.getY();
      if (ayxa.isLiuHaiUseValid()) {}
      for (float f1 = ayxa.eMW;; f1 = 0.0F)
      {
        if (DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a() == DoodleLayout.a(DoodleLayout.this)) {
          DoodleLayout.this.xs(7);
        }
        float f2 = f1;
        if (auwa.hasNavBar(DoodleLayout.this.getContext())) {
          f2 = f1 + auwa.getNavigationBarHeight(DoodleLayout.this.getContext());
        }
        int i = (int)Math.abs(f4 - DoodleLayout.a(DoodleLayout.this));
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
            DoodleLayout.a(DoodleLayout.this, true);
            if (DoodleLayout.d(DoodleLayout.this)) {
              ayjd.t(DoodleLayout.this.fT, false);
            }
            this.aJ = new Rect();
            DoodleLayout.this.fT.getGlobalVisibleRect(this.aJ);
            paramaykb = this.aJ;
            paramaykb.top -= this.PADDING;
            paramaykb = this.aJ;
            paramaykb.bottom += this.PADDING;
            DoodleLayout.this.c.getGlobalVisibleRect(DoodleLayout.this.mDisplayRect);
            DoodleLayout.this.xs(4);
            DoodleLayout.a(DoodleLayout.this, (int)f4);
            return false;
          } while (i <= DoodleLayout.b(DoodleLayout.this));
          if ((DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.La()) || (DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Le()))
          {
            i = (int)f3;
            j = DoodleLayout.this.mDisplayRect.left;
            k = (int)f4;
            m = DoodleLayout.this.mDisplayRect.top;
            if ((this.aJ.contains(i + j, k + m)) || (DoodleLayout.this.a(f3, f4, null, f2)))
            {
              DoodleLayout.a(DoodleLayout.this, true);
              return false;
            }
            DoodleLayout.a(DoodleLayout.this, false);
            return false;
          }
          if ((paramMotionEvent.getPointerCount() == 1) && (this.aJ.contains((int)f3, (int)f4)))
          {
            DoodleLayout.a(DoodleLayout.this, true);
            return false;
          }
          DoodleLayout.a(DoodleLayout.this, false);
          return false;
        }
        if ((this.aJ != null) && ((DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.La()) || (DoodleLayout.this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Le())))
        {
          i = (int)f3;
          j = DoodleLayout.this.mDisplayRect.left;
          k = (int)f4;
          m = DoodleLayout.this.mDisplayRect.top;
          if ((DoodleLayout.e(DoodleLayout.this)) && ((this.aJ.contains(i + j, k + m)) || (DoodleLayout.this.a(f3, f4, null, f2))))
          {
            paramaykb.clear();
            DoodleLayout.a(DoodleLayout.this, false);
            DoodleLayout.this.c(false, 0.0F, 0, 0, null, false, 0);
            if (QLog.isColorLevel()) {
              QLog.d("DoodleLayout", 2, "delete face, disable guideline");
            }
          }
        }
        for (;;)
        {
          DoodleLayout.this.resetUI();
          DoodleLayout.this.xs(0);
          DoodleLayout.a(DoodleLayout.this, false);
          if ((DoodleLayout.a(DoodleLayout.this) != null) || (DoodleLayout.a(DoodleLayout.this) == null)) {
            break;
          }
          DoodleLayout.this.g(false, false, false, false);
          return false;
          if ((paramMotionEvent.getPointerCount() == 1) && (this.aJ != null) && (this.aJ.contains((int)f3, (int)f4)))
          {
            paramaykb.clear();
            DoodleLayout.a(DoodleLayout.this, false);
          }
        }
        DoodleLayout.a(DoodleLayout.this).b.a(Message.obtain(null, 17, 0, 0, new aygt.a(false, false, false, false, true)));
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout
 * JD-Core Version:    0.7.0.1
 */