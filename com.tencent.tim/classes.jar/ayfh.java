import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.XEditTextEx;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditGifImage;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@TargetApi(11)
public class ayfh
  extends aygy
  implements View.OnClickListener, ayde
{
  public static final LongSparseArray<ayfh.a> a;
  public static long aCG;
  public static final int[] dW = { 2131366210, 2131366211, 2131366215, 2131366216, 2131366217, 2131366218, 2131366219, 2131366220, 2131366221, 2131366222, 2131366212, 2131366213, 2131366214 };
  public static int eJY;
  private long BI;
  private ImageView IO;
  private ImageView IP;
  private ImageView IQ;
  private ImageView IR;
  private View Ni;
  private View Nj;
  private View Nk;
  private View Nl;
  private LayoutTransition jdField_a_of_type_AndroidAnimationLayoutTransition = new LayoutTransition();
  private HorizontalAlumbListLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout;
  public long aCF;
  private long aCH;
  private boolean aGO;
  private TextView ahV;
  protected LongSparseArray<ImageView> b;
  private EditText bM;
  boolean btC = true;
  private aygz c;
  public HashSet<Integer> ca = new HashSet();
  protected ViewGroup cu;
  private ViewGroup cv;
  private boolean dyP;
  boolean dyQ = false;
  boolean dyR = false;
  private boolean dyS;
  public boolean dyT;
  private boolean dyU = true;
  private boolean dyV;
  private boolean dyW;
  private HorizontalScrollView e;
  private int eJZ;
  private LinearLayout eX;
  protected SparseArray<Long> el = new SparseArray();
  private RelativeLayout fQ;
  private RelativeLayout fR;
  private ViewGroup ff;
  protected ViewGroup fg;
  protected ViewGroup fh;
  protected ViewGroup fi;
  protected ViewGroup fj;
  private ViewGroup fk;
  protected ViewGroup fl;
  private ViewGroup fm;
  private ImageView[] k;
  private ImageView ng;
  private View oE;
  private View oG;
  protected BubblePopupWindow popup;
  protected TextView yj;
  private TextView yk;
  private TextView yl;
  private TextView ym;
  
  static
  {
    aCG = 2750423236735L;
    eJY = 268435456;
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray = new LongSparseArray();
  }
  
  public ayfh(@NonNull aygz paramaygz, long paramLong)
  {
    super(paramaygz);
    this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray = new LongSparseArray();
    this.aCF = paramLong;
    this.c = paramaygz;
  }
  
  @Nullable
  private String a(ayjn paramayjn)
  {
    Object localObject1 = null;
    if (paramayjn != null)
    {
      localObject1 = paramayjn.aN();
      paramayjn = new StringBuilder();
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        Object localObject3 = (List)((Map.Entry)localObject2).getValue();
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          localObject2 = (String)((Map.Entry)localObject2).getKey();
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            String str = (String)((Iterator)localObject3).next();
            paramayjn.append((String)localObject2).append('_').append(str).append(',');
          }
        }
      }
      localObject1 = paramayjn.toString();
    }
    return localObject1;
  }
  
  private ImageView[] a(long paramLong, @NonNull ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    if ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg() == 102) || (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg() == 11) || (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg() == 12)) {
      this.dyR = true;
    }
    int n = dW.length;
    paramLong = (aCG | eJY) & 0x723182FF & paramLong;
    int j = 0;
    int i = 0;
    long l;
    while (i < 41)
    {
      l = 1L << i;
      m = j;
      if ((paramLong & l & aCG) == l) {
        m = j + 1;
      }
      i += 1;
      j = m;
    }
    ram.b("Q.qqstory.record.EditVideoButton", "initEditButtons, needFirstStepButtonCount = %d", Integer.valueOf(j));
    if (n < j) {
      throw new IllegalArgumentException("too many parts, there is no enough view to show");
    }
    ImageView[] arrayOfImageView = new ImageView[n];
    i = 0;
    while (i < n)
    {
      paramViewGroup = y(dW[i]);
      if ((paramViewGroup instanceof ImageView))
      {
        arrayOfImageView[i] = ((ImageView)paramViewGroup);
        i += 1;
      }
      else
      {
        throw new IllegalArgumentException("can not find ImageView by id : " + dW[i] + ", view : " + paramViewGroup);
      }
    }
    this.el.clear();
    eRj();
    j = 0;
    i = 11;
    n = 0;
    int m = j;
    if (n < 41)
    {
      l = 1L << n;
      m = i;
      int i1 = j;
      label333:
      ayfh.a locala;
      if ((paramLong & l) == l)
      {
        if ((aCG & l) != l) {
          break label460;
        }
        paramViewGroup = arrayOfImageView[j];
        j += 1;
        locala = (ayfh.a)jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.get(l);
        if (locala == null) {
          break label555;
        }
      }
      for (;;)
      {
        try
        {
          paramViewGroup.setImageDrawable(new BitmapDrawable(BitmapFactory.decodeResource(getResources(), locala.iconResId)));
          if (l == 33554432L) {
            this.Nl = paramViewGroup;
          }
          paramViewGroup.setContentDescription(locala.C);
          paramViewGroup.setOnClickListener(paramOnClickListener);
          this.el.put(paramViewGroup.getId(), Long.valueOf(locala.aCI));
          this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(locala.aCI, paramViewGroup);
          i1 = j;
          m = i;
          n += 1;
          i = m;
          j = i1;
          break;
          label460:
          if (((eJY & l) == l) && (i < dW.length))
          {
            paramViewGroup = dW;
            m = i + 1;
            paramViewGroup = (ImageView)y(paramViewGroup[i]);
            i = m;
            break label333;
          }
          ram.e("Q.qqstory.record.EditVideoButton", "initEditButtons second step buttons not enough");
          m = i;
          i1 = j;
          continue;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          ram.e("Q.qqstory.record.EditVideoButton", "decodeResource OutOfMemoryError : %s", new Object[] { locala.C });
          continue;
        }
        label555:
        ram.e("Q.qqstory.record.EditVideoButton", "EntryButtonInfo info is null ?!");
        m = i;
        i1 = j;
      }
    }
    for (;;)
    {
      j = i;
      if (m >= 11) {
        break;
      }
      arrayOfImageView[m].setOnClickListener(null);
      arrayOfImageView[m].setVisibility(8);
      m += 1;
    }
    while (j < dW.length)
    {
      arrayOfImageView[j].setOnClickListener(null);
      arrayOfImageView[j].setVisibility(8);
      j += 1;
    }
    return arrayOfImageView;
  }
  
  private void aff(int paramInt)
  {
    int j = 3;
    boolean bool;
    int i;
    if ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 3))
    {
      bool = this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Le();
      if (!bool) {
        break label105;
      }
      i = 628;
      switch (paramInt)
      {
      default: 
        paramInt = -1;
      }
    }
    for (;;)
    {
      if (!bool) {
        break label156;
      }
      LpReportInfo_pf00064.allReport(i, paramInt);
      return;
      label105:
      i = 615;
      break;
      paramInt = j;
      if (!bool)
      {
        paramInt = 1;
        continue;
        paramInt = j;
        if (bool)
        {
          paramInt = 2;
          continue;
          if (bool) {}
          paramInt = 4;
          continue;
          if (bool) {}
          paramInt = 4;
        }
      }
    }
    label156:
    LpReportInfo_pf00064.report(i, paramInt);
  }
  
  private void afg(int paramInt)
  {
    if (rma.a().tG() == 22) {
      LpReportInfo_pf00064.allReport(680, 2, paramInt);
    }
  }
  
  private void bsB()
  {
    if ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Le()) || (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Lf()))
    {
      if (!this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.aGr) {
        break label79;
      }
      as(true, false);
      this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.a.removeMessages(994);
      this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.a.sendEmptyMessage(995);
    }
    label79:
    do
    {
      return;
      this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.a.sendEmptyMessageDelayed(994, 0L);
    } while (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.aGp);
    this.yl.setVisibility(0);
    this.yl.setText("0%");
    this.ng.setImageResource(2130848992);
    this.eX.setClickable(false);
    this.eX.setOnClickListener(null);
  }
  
  private void d(View... paramVarArgs)
  {
    float f1 = acej.aV();
    int j;
    int i;
    if (f1 > 16.0F)
    {
      j = paramVarArgs.length;
      i = 0;
    }
    for (;;)
    {
      View localView;
      if (i < j)
      {
        localView = paramVarArgs[i];
        if ((localView != null) && (localView.getLayoutParams() != null)) {}
      }
      else
      {
        return;
      }
      if ((localView instanceof TextView))
      {
        float f2 = ((TextView)localView).getTextSize();
        float f3 = 16.0F / f1;
        ((TextView)localView).setTextSize(0, f2 * f3);
      }
      i += 1;
    }
  }
  
  private void eRb()
  {
    if (this.cu != null)
    {
      View localView = this.cu.findViewById(2131374679);
      if (localView != null) {
        this.cu.removeView(localView);
      }
    }
    if (this.jdField_b_of_type_Aygz.jdField_a_of_type_Aygn != null) {
      this.jdField_b_of_type_Aygz.jdField_a_of_type_Aygn.dLp();
    }
  }
  
  private void eRj()
  {
    eRi();
    if ((this.jdField_b_of_type_Aygz.b() != null) && ((this.jdField_b_of_type_Aygz.b().getActivity() instanceof EditPicActivity))) {
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(32L, new ayfh.a(32L, 2130845392, acfp.m(2131705607)));
    }
    int i = this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi;
    if ((i == 2) || (i == 6))
    {
      if (this.jdField_b_of_type_Aygz.La())
      {
        jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1L, new ayfh.a(536870912L, 2130845400, acfp.m(2131705697)));
        jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(536870912L, new ayfh.a(1L, 2130845404, acfp.m(2131705637)));
      }
    }
    else
    {
      if ((i != 3) || (rma.a().tG() != 22)) {
        break label436;
      }
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1L, new ayfh.a(2L, 2130845402, acfp.m(2131705525)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(2L, new ayfh.a(549755813888L, 2130845391, acfp.m(2131705683)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(8L, new ayfh.a(16L, 2130845409, acfp.m(2131705680)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(16L, new ayfh.a(8L, 2130845406, acfp.m(2131705495)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(549755813888L, new ayfh.a(1L, 2130845404, acfp.m(2131705508)));
    }
    label436:
    while ((i != 3) || (!this.jdField_b_of_type_Aygz.La()))
    {
      return;
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1L, new ayfh.a(536870912L, 2130845400, acfp.m(2131705536)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(2L, new ayfh.a(8L, 2130845406, acfp.m(2131705578)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(8L, new ayfh.a(64L, 2130845395, acfp.m(2131705692)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(64L, new ayfh.a(1L, 2130845404, acfp.m(2131705515)));
      jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(536870912L, new ayfh.a(2L, 2130845402, acfp.m(2131705512)));
      break;
    }
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1L, new ayfh.a(536870912L, 2130845400, acfp.m(2131705636)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(536870912L, new ayfh.a(1L, 2130845404, acfp.m(2131705572)));
  }
  
  private void eRk()
  {
    Object localObject = this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.mExtra;
    RelativeLayout.LayoutParams localLayoutParams;
    if ((localObject != null) && (((Bundle)localObject).getInt("video_redbag_get", 0) == LocalMediaInfo.REDBAG_TYPE_GET) && (!this.dyS))
    {
      this.dyS = true;
      this.fR = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131561954, null));
      localObject = (RelativeLayout)y(2131364110);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      if (this.jdField_b_of_type_Aygz.ok == null) {
        break label154;
      }
      if (!this.jdField_b_of_type_Aygz.dzj) {
        break label144;
      }
      localLayoutParams.bottomMargin = this.jdField_b_of_type_Aygz.ok.getHeight();
      localLayoutParams.addRule(12, -1);
    }
    for (;;)
    {
      ((RelativeLayout)localObject).addView(this.fR, localLayoutParams);
      ram.w("Q.qqstory.record.EditVideoButton", "VideoRedbag, editVideoButton show redbag tips");
      return;
      label144:
      localLayoutParams.addRule(12, -1);
      continue;
      label154:
      localLayoutParams.addRule(2, 2131364112);
    }
  }
  
  private void eRl()
  {
    if ((this.aCF & 0x20000) != 0L) {}
    label153:
    for (;;)
    {
      return;
      Object localObject = null;
      if ((this.aCF & 0x4000000) != 0L) {
        localObject = y(2131362222);
      }
      for (;;)
      {
        if (localObject == null) {
          break label153;
        }
        localObject = ((View)localObject).getLayoutParams();
        if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
          break;
        }
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = 0;
        return;
        if ((this.aCF & 0x0) != 0L) {
          localObject = y(2131381577);
        } else if ((this.aCF & 0x0) != 0L) {
          localObject = y(2131363871);
        } else if ((this.aCF & 0x2000) != 0L) {
          localObject = this.IP;
        } else if ((this.aCF & 0x4000) != 0L) {
          localObject = y(2131380035);
        }
      }
    }
  }
  
  private void eRn()
  {
    axxe.a(this.IP, 200L, null);
    this.jdField_b_of_type_Aygz.eRI();
    if ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 2) || (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 5) || (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 6)) {}
    for (int i = 1;; i = 0)
    {
      rar.a("video_edit_aio", "download_clk", 0, i, new String[0]);
      rar.a("video_edit_new", "clk_download", 0, i, new String[0]);
      return;
    }
  }
  
  private void eRo()
  {
    eRp();
    Object localObject = ayva.a().a();
    if (localObject != null) {
      rar.a("video_edit_transition", "pub_effects", ayih.lZ(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.getIntExtra("extra_transiton_src_from", -1)), 0, new String[] { ((TransitionCategoryItem)localObject).transId, ((TransitionCategoryItem)localObject).cVO, ((TransitionCategoryItem)localObject).cVN, ((TransitionCategoryItem)localObject).themeId });
    }
    if ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.mMode == 5) && (prt.a != null)) {
      rar.a("video_edit_text", "clk_pub", prt.a.mOpIn, 0, new String[] { prt.a.auI, prt.a.auJ, prt.a.auK });
    }
    if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.getBooleanExtra("is_video_forward", false)) {
      if (this.bM.getText().toString().length() <= 0) {
        break label393;
      }
    }
    label393:
    for (localObject = "1";; localObject = "0")
    {
      rar.a("video_edit", "pub_transmit", 0, 0, new String[] { "1", localObject });
      if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg() == 1) {
        rar.b("time_edit", 1, (int)(System.currentTimeMillis() - this.jdField_b_of_type_Aygz.iY()), new String[] { rar.bY(this.jdField_b_of_type_Aygz.QD()), "0", "", "" });
      }
      if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg() == 1) {
        rar.b("clk_function", 1, 0, new String[] { ShortVideoUtils.a(this.ca), "", "", "" });
      }
      if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.th() == 122) {
        AIOLongShotHelper.report("0X8009DEF");
      }
      if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.aQz()) {
        anot.a(null, "dc00898", "", "", "0X800A06E", "0X800A06E", 0, 0, "", "", "", "");
      }
      return;
    }
  }
  
  private void eRp()
  {
    int j;
    try
    {
      localJSONObject = new JSONObject();
      n = this.jdField_b_of_type_Aygz.QD();
      i1 = this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.th();
      if (n == 9) {
        break label606;
      }
      if (n != 2) {
        break label612;
      }
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject;
      int n;
      int i1;
      Object localObject1;
      Object localObject3;
      int i;
      String[] arrayOfString;
      Object localObject4;
      int i2;
      while (QLog.isColorLevel())
      {
        QLog.e("Q.qqstory.record.EditVideoButton", 2, localException, new Object[0]);
        return;
        localObject2 = null;
        continue;
        localObject2 = null;
        continue;
        localObject2 = null;
        continue;
        localObject4 = null;
        localObject3 = null;
        continue;
        i = 0;
        continue;
        j = 1;
      }
      return;
    }
    localObject1 = a(this.jdField_b_of_type_Aygz.jdField_a_of_type_Ayfw.a().a());
    localObject3 = this.jdField_b_of_type_Aygz.jdField_a_of_type_Ayfw.a().a();
    localObject1 = (String)localObject1 + a((ayjn)localObject3);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localJSONObject.put("sticker", localObject1);
    }
    localObject1 = (awrz)axov.a(13);
    if (((awrz)localObject1).QB() == 4) {
      i = 2;
    }
    int m;
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject3 = ((awrz)localObject1).ag();
        arrayOfString = ((awrz)localObject1).af();
        if (j != 0)
        {
          localObject3 = localObject3[1];
          localObject4 = arrayOfString[1];
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            localJSONObject.put("effect", localObject3);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            localJSONObject.put("filter", localObject4);
          }
          localObject1 = (axro)axov.a(8);
          if ((localObject1 == null) || (((axro)localObject1).c() == null)) {
            break label586;
          }
          localObject1 = String.valueOf(((axro)localObject1).c().mItemId);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localJSONObject.put("music", localObject1);
          }
          if (j != 0)
          {
            localObject1 = (ayzs)axov.a(3);
            if (localObject1 == null) {
              break label580;
            }
            localObject1 = ((ayzs)localObject1).IC();
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              localJSONObject.put("face", localObject1);
            }
          }
          localObject1 = this.jdField_b_of_type_Aygz.jdField_a_of_type_Ayfw.a().a().a();
          if (localObject1 != null)
          {
            localObject1 = String.valueOf(((DynamicTextItem)localObject1).getType());
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              localJSONObject.put("text", localObject1);
            }
            rar.a("video_edit_new", "send_clk", RR(), 0, new String[] { rar.bY(n), localJSONObject.toString(), String.valueOf(i), String.valueOf(i1) });
            return;
            if (((awrz)localObject1).QB() != 8) {
              break label601;
            }
            i = 1;
          }
        }
        else
        {
          i2 = localObject3.length;
          m = 0;
          localObject1 = null;
        }
      }
    }
    for (;;)
    {
      if (m < i2)
      {
        localObject4 = localObject3[m];
        if (localObject4 != null) {
          localObject1 = (String)localObject4 + ",";
        }
      }
      else
      {
        i2 = arrayOfString.length;
        m = 0;
        String str = null;
        for (;;)
        {
          localObject3 = localObject1;
          localObject4 = str;
          if (m >= i2) {
            break;
          }
          localObject3 = arrayOfString[m];
          if (localObject3 != null) {
            str = (String)localObject3 + ",";
          }
          m += 1;
        }
        Object localObject2;
        label580:
        label586:
        label601:
        label606:
        label612:
        j = 0;
        break;
      }
      m += 1;
    }
  }
  
  private void eRq()
  {
    this.jdField_b_of_type_Aygz.eRM();
    this.jdField_b_of_type_Aygz.eRy();
    this.jdField_b_of_type_Aygz.changeState(0);
    this.fh.setVisibility(0);
    this.fh.setAlpha(0.0F);
    this.yj.setVisibility(0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new axwc.a(this.fi, "translationY", 0.0F, rpq.dip2px(getContext(), 160.0F), 300L, 0L));
    localArrayList.add(new axwc.a(this.fi, "alpha", 1.0F, 0.0F, 300L, 0L));
    localArrayList.add(new axwc.a(this.fh, "translationY", getResources().getDimension(2131298491), 0.0F, 300L, 300L));
    localArrayList.add(new axwc.a(this.fh, "alpha", 0.0F, 1.0F, 300L, 300L));
    localArrayList.add(new axwc.a(this.yj, "translationY", -1.0F * getResources().getDimension(2131298492), 0.0F, 300L, 300L));
    localArrayList.add(new axwc.a(this.yj, "alpha", 0.0F, 1.0F, 300L, 300L));
    localArrayList.add(new axwc.a(this.fl, "translationY", 0.0F, -1.0F * getResources().getDimension(2131298492), 300L, 0L));
    localArrayList.add(new axwc.a(this.fl, "alpha", 1.0F, 0.0F, 300L, 0L));
    localArrayList.add(new axwc.a(this.fj, "translationY", 0.0F, -1.0F * getResources().getDimension(2131298492), 300L, 0L));
    localArrayList.add(new axwc.a(this.fj, "alpha", 1.0F, 0.0F, 300L, 0L));
    axwc.a(localArrayList, new ayfq(this));
    this.BK = (System.currentTimeMillis() + 600L);
    this.jdField_b_of_type_Aygz.a(Message.obtain(null, 11, Long.valueOf(this.BK)));
    this.jdField_b_of_type_Aygz.a(Message.obtain(null, 12, 1, (int)this.BK));
  }
  
  private void eRr()
  {
    QzoneModuleManager.getInstance().downloadModule("cyber_clink_version_2.jar", new ayfj(this));
  }
  
  private void jA(View paramView)
  {
    int i = 1;
    TextView localTextView;
    int j;
    int m;
    if ((paramView instanceof TextView))
    {
      localTextView = (TextView)paramView;
      j = this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg();
      m = this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.th();
      if (j != 101) {
        break label67;
      }
      localTextView.setText(acfp.m(2131705652));
      localTextView.setContentDescription(acfp.m(2131705669));
    }
    label67:
    do
    {
      return;
      if (j == 102)
      {
        localTextView.setText(acfp.m(2131705521));
        localTextView.setContentDescription(acfp.m(2131705557));
        return;
      }
      if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 2)
      {
        paramView = acfp.m(2131705702);
        j = this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.th();
        if ((j == 122) || (j == 125) || (j == 133) || (EditVideoParams.oA(j)) || (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.aQz())) {
          paramView = getString(2131690179);
        }
        if ((this.jdField_a_of_type_Ayii.getActivity() != null) && (this.jdField_a_of_type_Ayii.getActivity().getIntent() != null) && (this.jdField_a_of_type_Ayii.getActivity().getIntent().getBooleanExtra("input_full_screen_mode", false))) {}
        for (;;)
        {
          if (i != 0) {
            paramView = getString(2131721079);
          }
          localTextView.setText(paramView);
          localTextView.setContentDescription(paramView);
          return;
          i = 0;
        }
      }
      if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 8)
      {
        localTextView.setText(acfp.m(2131705481));
        localTextView.setContentDescription(acfp.m(2131705517));
        return;
      }
      if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 1)
      {
        paramView = acfp.m(2131705549);
        if (m == 20) {
          paramView = acfp.m(2131705626);
        }
        localTextView.setText(paramView);
        localTextView.setContentDescription(paramView);
        return;
      }
      if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 3)
      {
        paramView = this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.getStringExtra("extra_publish_text");
        if (!TextUtils.isEmpty(paramView))
        {
          localTextView.setText(paramView);
          localTextView.setContentDescription(paramView);
          return;
        }
        localTextView.setText(acfp.m(2131705622));
        localTextView.setContentDescription(acfp.m(2131705528));
        return;
      }
      if ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 5) || (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 6))
      {
        localTextView.setText(acfp.m(2131705688));
        localTextView.setContentDescription(acfp.m(2131705703));
        paramView = localTextView.getLayoutParams();
        paramView.width = wja.dp2px(70.0F, localTextView.getContext().getResources());
        localTextView.setLayoutParams(paramView);
        return;
      }
    } while (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi != 7);
    localTextView.setText(acfp.m(2131721053));
    localTextView.setContentDescription(acfp.m(2131721053));
  }
  
  private void jz(View paramView)
  {
    int i = paramView.getId();
    switch (i)
    {
    case 2131366223: 
    default: 
    case 2131365426: 
    case 2131365427: 
    case 2131365428: 
    case 2131365406: 
    case 2131372995: 
    case 2131362743: 
    case 2131380030: 
      do
      {
        do
        {
          long l;
          do
          {
            return;
            l = SystemClock.uptimeMillis();
          } while ((l - this.aCH < 800L) || (this.jdField_a_of_type_Ayii.getActivity().isFinishing()));
          this.aCH = l;
          paramView = (aydl)a(aydl.class);
          if ((paramView != null) && (!paramView.aQs()))
          {
            this.jdField_b_of_type_Aygz.bta();
            return;
          }
          if (rma.a().tG() == 22)
          {
            LpReportInfo_pf00064.allReport(680, 2, 7);
            LpReportInfo_pf00064.allReport(680, 11, 1);
          }
          eRb();
          this.jdField_b_of_type_Aygz.bsX();
          axim.a().eKB();
          axip.a().eLu();
          axiy.i("Q.qqstory.record.EditVideoButton", "【Click】+ control_publish");
          eRo();
          return;
          eRb();
          rar.b("clk_reshoot", RR(), 0, new String[0]);
          if ((this.jdField_b_of_type_Aygz instanceof aytw)) {
            ((aytw)this.jdField_b_of_type_Aygz).dAR = true;
          }
          if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.aQz()) {
            anot.a(null, "dc00898", "", "", "0X800A06F", "0X800A06F", 0, 0, "", "", "", "");
          }
          this.jdField_b_of_type_Aygz.bsV();
          if ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.mMode == 5) && (prt.a != null)) {
            rar.a("video_edit_text", "clk_goback", prt.a.mOpIn, 0, new String[0]);
          }
        } while ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.mMode != 2) || (rma.a().tF() != 13) || (this.jdField_a_of_type_Ayii == null) || (this.jdField_a_of_type_Ayii.getActivity() == null));
        rar.a("video_edit_new", "back_smartalbum", this.jdField_a_of_type_Ayii.getActivity().getIntent(), new String[0]);
        return;
        eRq();
        eRb();
        return;
        this.ca.add(Integer.valueOf(12));
        axxe.a(paramView, 200L, new ayfl(this));
        rar.b("clk_control", RR(), 0, new String[0]);
        return;
        bsB();
        return;
        if ((this.c != null) && (!this.c.aQC()))
        {
          this.c.a(new ayfm(this));
          return;
        }
      } while ((this.c == null) || (!this.c.aQC()));
      eRn();
      return;
    case 2131362222: 
      this.ca.add(Integer.valueOf(10));
      axxe.a(paramView, 200L, new ayfn(this));
      return;
    case 2131380011: 
      this.jdField_b_of_type_Aygz.eRJ();
      return;
    case 2131379233: 
      this.jdField_b_of_type_Aygz.changeState(34);
      return;
    }
    paramView = new ayov(getContext(), this.jdField_b_of_type_Aygz);
    paramView.setOnShowListener(new ayfo(this));
    paramView.setOnDismissListener(new ayfp(this, paramView));
    paramView.init();
    if (i == 2131366530)
    {
      paramView.bo(this.bM.getText().toString(), false);
      return;
    }
    paramView.bo(this.bM.getText().toString(), true);
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    super.a(paramInt, paramayqb);
    paramayqb.dAq = this.dyT;
    if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.getBooleanExtra("is_video_forward", false))
    {
      Object localObject2 = this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams;
      Object localObject1 = ((EditVideoParams)localObject2).getStringExtra("vip_forward_uid");
      String str1 = ((EditVideoParams)localObject2).getStringExtra("vip_forward_vid");
      String str2 = ((EditVideoParams)localObject2).getStringExtra("vip_forward_feedid");
      String str3 = ((EditVideoParams)localObject2).getStringExtra("vip_forward_name");
      String str4 = ((EditVideoParams)localObject2).getStringExtra("vip_forward_avatrname");
      localObject2 = new pty();
      ((pty)localObject2).styleType = 5;
      ((pty)localObject2).a = new pty.a();
      ((pty)localObject2).a.avo = ((String)localObject1);
      ((pty)localObject2).a.vid = str1;
      ((pty)localObject2).a.feedID = str2;
      ((pty)localObject2).a.nickName = str3;
      ((pty)localObject2).a.headUrl = str4;
      ((pty)localObject2).a.avq = "1";
      str1 = this.bM.getText().toString();
      if (str1.length() > 0)
      {
        localObject1 = str1;
        if (aofy.Z(str1)) {
          localObject1 = anbk.nm(str1);
        }
        ((pty)localObject2).a.avp = ((String)localObject1);
      }
      paramayqb.g.setLinkInfo((pty)localObject2);
    }
  }
  
  public void afh(int paramInt)
  {
    this.IP.setVisibility(paramInt);
  }
  
  public void as(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      this.eX.setVisibility(8);
      this.eX.setClickable(false);
      this.eX.setOnClickListener(null);
      this.ym.setVisibility(8);
      this.ng.setVisibility(8);
      this.yl.setVisibility(8);
      this.fQ.setVisibility(8);
      return;
    }
    if (!paramBoolean2)
    {
      this.eX.setVisibility(0);
      this.eX.setClickable(true);
      this.eX.setOnClickListener(this);
      this.ym.setVisibility(0);
      this.ng.setVisibility(0);
      this.ng.setImageResource(2130848560);
      this.yl.setVisibility(4);
      this.fQ.setVisibility(0);
      return;
    }
    this.eX.setClickable(true);
    this.eX.setOnClickListener(this);
    this.yl.setVisibility(4);
    this.ng.setImageResource(2130848561);
  }
  
  public void at(boolean paramBoolean1, boolean paramBoolean2)
  {
    n(paramBoolean1, paramBoolean2, true);
  }
  
  public View c(long paramLong)
  {
    if (this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray != null) {
      return (View)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(paramLong);
    }
    return null;
  }
  
  public View cN()
  {
    if (this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray != null) {
      return (View)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(16L);
    }
    return null;
  }
  
  public void d(int paramInt1, int paramInt2, Object paramObject)
  {
    if ((this.popup != null) && (this.popup.isShowing())) {
      this.popup.dismiss();
    }
    switch (paramInt2)
    {
    case 20: 
    case 22: 
    case 25: 
    case 33: 
    case 35: 
    case 38: 
    case 39: 
    case 41: 
    default: 
    case 0: 
    case 27: 
    case 31: 
    case 32: 
    case 10: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 19: 
    case 24: 
    case 7: 
    case 5: 
    case 6: 
    case 18: 
    case 8: 
    case 9: 
    case 23: 
    case 1: 
    case 3: 
    case 4: 
    case 12: 
    case 34: 
    case 37: 
    case 42: 
    case 11: 
    case 21: 
    case 28: 
    case 2: 
    case 29: 
    case 30: 
    case 36: 
    case 40: 
      label237:
      label246:
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
                do
                {
                  do
                  {
                    return;
                    o(null);
                    this.fg.setBackgroundColor(this.eJZ);
                    if (paramInt1 == 9)
                    {
                      paramInt2 = 1;
                      if (paramInt1 != 23) {
                        break label403;
                      }
                      i = 1;
                      if ((i | paramInt2) == 0) {
                        break label409;
                      }
                      n(true, true, false);
                    }
                    for (;;)
                    {
                      if ((this.fm != null) && (this.fm.getVisibility() != 0)) {
                        this.fm.setVisibility(0);
                      }
                      if (this.dyU)
                      {
                        this.jdField_b_of_type_Aygz.a(Message.obtain(null, 12, 3, (int)this.BK));
                        this.dyU = false;
                      }
                      if ((!this.dyW) || (!this.jdField_b_of_type_Aygz.La())) {
                        break;
                      }
                      if ((this.yj != null) && (this.yj.getVisibility() != 0)) {
                        this.yj.setVisibility(0);
                      }
                      if ((this.IP == null) || (this.IP.getVisibility() == 0) || ((this.aCF & 0x2000) == 0L)) {
                        break;
                      }
                      this.IP.setVisibility(0);
                      return;
                      paramInt2 = 0;
                      break label237;
                      i = 0;
                      break label246;
                      if (paramInt1 == 27) {
                        n(true, true, false);
                      } else {
                        at(true, false);
                      }
                    }
                    n(false, true, false);
                    ras.bw("0X80080E5", ras.bpo);
                    return;
                    this.fg.setVisibility(8);
                    return;
                  } while (paramInt1 != 31);
                  this.fg.setVisibility(0);
                  return;
                  o(null);
                  at(true, false);
                  return;
                  o((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(536870912L));
                  this.fg.setBackgroundColor(getResources().getColor(2131165400));
                  if (paramInt1 == 8) {
                    if ((paramObject != null) && ((paramObject instanceof Boolean))) {
                      n(true, true, ((Boolean)paramObject).booleanValue());
                    }
                  }
                  for (;;)
                  {
                    if ((this.fm != null) && (this.fm.getVisibility() == 0)) {
                      this.fm.setVisibility(8);
                    }
                    if (((this.aCF & 0x0) == 0L) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout == null)) {
                      break;
                    }
                    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setVisibility(8);
                    return;
                    at(true, true);
                    continue;
                    at(true, false);
                  }
                  if ((paramInt1 != paramInt2) && (this.dyR)) {
                    o((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(1L));
                  }
                  int j = -1;
                  int i = j;
                  if (paramObject != null)
                  {
                    i = j;
                    if ((paramObject instanceof Integer)) {
                      i = ((Integer)paramObject).intValue();
                    }
                  }
                  if (QLog.isColorLevel()) {
                    QLog.i("Q.qqstory.record.EditVideoButton", 2, "editVideoStateChanged text old:" + paramInt1 + " new:" + paramInt2 + " softInputMode:" + i);
                  }
                  if (i == 0) {
                    this.fg.setVisibility(8);
                  }
                  for (;;)
                  {
                    x(false, false, true);
                    if (this.fm != null) {
                      this.fm.setVisibility(8);
                    }
                    if ((!this.dyW) || (!this.jdField_b_of_type_Aygz.La())) {
                      break;
                    }
                    if ((this.yj != null) && (this.yj.getVisibility() == 0)) {
                      this.yj.setVisibility(4);
                    }
                    if ((this.IP == null) || (this.IP.getVisibility() != 0)) {
                      break;
                    }
                    afh(4);
                    return;
                    at(true, false);
                  }
                  o((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(8L));
                  x(false, false, true);
                } while (this.fm == null);
                this.fm.setVisibility(8);
                return;
                o((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(1024L));
                return;
                if ((paramObject != null) && ((paramObject instanceof Boolean)))
                {
                  at(false, ((Boolean)paramObject).booleanValue());
                  return;
                }
                at(false, true);
                return;
                at(false, true);
                return;
                at(false, false);
                return;
                o((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(4L));
                at(false, false);
                return;
                o((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(32768L));
                at(false, false);
                return;
                o((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(2097152L));
                return;
                o((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(2L));
                x(false, false, true);
              } while (this.fm == null);
              this.fm.setVisibility(8);
              return;
              o((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(64L));
              x(false, false, true);
            } while (this.fm == null);
            this.fm.setVisibility(8);
            return;
            o((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(32L));
            x(false, false, true);
          } while (this.fm == null);
          this.fm.setVisibility(8);
          return;
          x(false, false, true);
        } while (this.fm == null);
        this.fm.setVisibility(8);
        return;
        o((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(16L));
        x(false, false, true);
      } while (this.fm == null);
      label403:
      label409:
      this.fm.setVisibility(8);
      return;
    }
    o((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(1073741824L));
  }
  
  protected boolean e(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.e(paramMessage);
      ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(paramMessage.arg1);
      if (localImageView != null)
      {
        ram.d("Q.qqstory.record.EditVideoButton", "perform button click %s", localImageView);
        localImageView.performClick();
      }
      else
      {
        ram.w("Q.qqstory.record.EditVideoButton", "can not find view performing click by enable mask %d", new Object[] { Integer.valueOf(paramMessage.arg1) });
        continue;
        if (this.Nl != null)
        {
          this.Nl.setAlpha(1.0F);
          this.dyV = false;
          continue;
          eRb();
        }
      }
    }
  }
  
  public void eQJ()
  {
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(16L);
    if (localImageView != null) {
      localImageView.setImageResource(2130845408);
    }
  }
  
  public void eRi()
  {
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(2L, new ayfh.a(2L, 2130845402, acfp.m(2131705609)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(536870912L, new ayfh.a(536870912L, 2130845400, acfp.m(2131705556)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1L, new ayfh.a(1L, 2130845404, acfp.m(2131705648)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(8L, new ayfh.a(8L, 2130845406, acfp.m(2131705610)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(512L, new ayfh.a(512L, 2130847567, acfp.m(2131705589)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(4L, new ayfh.a(4L, 2130845393, acfp.m(2131705653)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1048576L, new ayfh.a(1048576L, 2130847707, acfp.m(2131705567)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(32768L, new ayfh.a(32768L, 2130845405, "GIF快慢"));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(65536L, new ayfh.a(65536L, 2130847404, "生成GIF"));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(2097152L, new ayfh.a(2097152L, 2130845405, acfp.m(2131705709)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(64L, new ayfh.a(64L, 2130845395, acfp.m(2131705643)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(32L, new ayfh.a(32L, 2130845392, acfp.m(2131705693)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(268435456L, new ayfh.a(268435456L, 2130845399, acfp.m(2131705581)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(16L, new ayfh.a(16L, 2130845409, acfp.m(2131705699)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(33554432L, new ayfh.a(33554432L, 2130845401, acfp.m(2131705679)));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(1073741824L, new ayfh.a(1073741824L, 2130845403, "跳转到P图"));
    jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(549755813888L, new ayfh.a(549755813888L, 2130845391, acfp.m(2131705560)));
  }
  
  protected void eRm()
  {
    if (this.jdField_b_of_type_Aygz.eO(33))
    {
      this.jdField_b_of_type_Aygz.changeState(0);
      return;
    }
    this.jdField_b_of_type_Aygz.r(33, Integer.valueOf(1001));
  }
  
  public void n(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean2)
    {
      this.BK = (System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        this.BK += 500L;
      }
      if (paramBoolean1) {
        ayjd.t(this.cu, paramBoolean3);
      }
      for (;;)
      {
        this.jdField_b_of_type_Aygz.a(Message.obtain(null, 11, Long.valueOf(this.BK)));
        if (!paramBoolean1) {
          break;
        }
        i = 0;
        while (i < this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.size())
        {
          ((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.valueAt(i)).setVisibility(0);
          i += 1;
        }
        ayjd.s(this.cu, paramBoolean3);
      }
    }
    this.cu.setAnimation(null);
    Object localObject = this.cu;
    if (paramBoolean1) {}
    for (int i = 0;; i = 8)
    {
      ((ViewGroup)localObject).setVisibility(i);
      this.BK = 0L;
      break;
    }
    if ((this.aCF & 0x20000) != 0L)
    {
      this.oE.setVisibility(0);
      this.Nj.setVisibility(0);
    }
    if (((this.aCF & 0x0) != 0L) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null))
    {
      localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout;
      if (!paramBoolean1) {
        break label335;
      }
    }
    label335:
    for (i = 0;; i = 8)
    {
      ((HorizontalAlumbListLayout)localObject).setVisibility(i);
      if (paramBoolean1)
      {
        if (this.ff.getVisibility() != 0) {
          this.ff.setVisibility(0);
        }
        if (this.fg.getVisibility() != 0) {
          this.fg.setVisibility(0);
        }
      }
      if ((this.jdField_b_of_type_Aygz.ok != null) && (this.fg == this.fh) && (!paramBoolean1) && (this.fg.getVisibility() == 0)) {
        this.fg.setVisibility(4);
      }
      if ((this.fR != null) && (!paramBoolean1)) {
        this.fR.setVisibility(8);
      }
      return;
    }
  }
  
  protected void o(@Nullable ImageView paramImageView)
  {
    int i = 0;
    while (i < this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.size())
    {
      ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.valueAt(i);
      if (localImageView != null) {
        localImageView.clearColorFilter();
      }
      i += 1;
    }
    if (paramImageView != null) {
      paramImageView.setColorFilter(getResources().getColor(2131166534), PorterDuff.Mode.SRC_IN);
    }
    if (this.aGO)
    {
      paramImageView = (ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(2L);
      if (paramImageView != null) {
        paramImageView.setColorFilter(getResources().getColor(2131166534), PorterDuff.Mode.SRC_IN);
      }
    }
  }
  
  public boolean onBackPressed()
  {
    if (System.currentTimeMillis() < this.BK) {
      return true;
    }
    if (this.fg == this.fi)
    {
      eRq();
      eRb();
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    int j;
    if (Math.abs(SystemClock.uptimeMillis() - this.BI) > 500L)
    {
      this.BI = SystemClock.uptimeMillis();
      j = paramView.getId();
      if (this.BK <= System.currentTimeMillis()) {
        break label91;
      }
      ram.w("Q.qqstory.record.EditVideoButton", "animation is playing, please wait, animation end time: %d, now: %d.", new Object[] { Long.valueOf(this.BK), Long.valueOf(System.currentTimeMillis()) });
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ram.w("Q.qqstory.record.EditVideoButton", "you click button too fast, ignore it !");
      continue;
      label91:
      if (this.fR != null) {
        this.fR.setVisibility(8);
      }
      Object localObject1 = dW;
      int m = localObject1.length;
      int i = 0;
      for (;;)
      {
        if (i >= m) {
          break label2266;
        }
        if (localObject1[i] == j)
        {
          long l = ((Long)this.el.get(j)).longValue();
          ram.w("Q.qqstory.record.EditVideoButton", "onClick : mask=%d, view=%s", new Object[] { Long.valueOf(l), paramView });
          ras.aP(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg(), "0X8007822");
          eRb();
          i = this.jdField_b_of_type_Aygz.a(Message.obtain(null, 1, new Object[] { Long.valueOf(l), paramView }));
          if (i > 0)
          {
            ram.i("Q.qqstory.record.EditVideoButton", "%d parts intercept the click event : " + i);
            break;
          }
          this.jdField_b_of_type_Aygz.eRM();
          this.jdField_b_of_type_Aygz.bta();
          j = -1;
          switch ((int)(l >> 31))
          {
          default: 
            label296:
            switch ((int)(0xFFFFFFFF & l))
            {
            default: 
              i = j;
            }
            break;
          }
          for (;;)
          {
            localObject1 = null;
            if (i != -1) {
              localObject1 = new ayfk(this, i);
            }
            if ((aCG & l) != l) {
              break;
            }
            axxe.a(paramView, 200L, (View.OnClickListener)localObject1);
            break;
            if (rma.a().tG() == 22) {
              LpReportInfo_pf00064.allReport(680, 2, 2);
            }
            localObject1 = new ArrayList(rma.a().getPhotoList());
            Object localObject2 = avpw.d.a();
            Object localObject3 = new Bundle();
            ((Bundle)localObject3).putParcelableArrayList("qzone_slide_show_matters", (ArrayList)localObject1);
            avpw.f(this.jdField_a_of_type_Ayii.getActivity(), (avpw.d)localObject2, (Bundle)localObject3, 666);
            break label296;
            this.ca.add(Integer.valueOf(2));
            if (this.jdField_b_of_type_Aygz.eO(2))
            {
              this.jdField_b_of_type_Aygz.changeState(0);
              i = -1;
              afg(1);
              rar.b("clk_music", RR(), 0, new String[0]);
            }
            else
            {
              boolean bool = this.jdField_b_of_type_Aygz.eP(4);
              localObject1 = (prw)((psd)psx.a(20)).a(1);
              if (((prw)localObject1).a((prw.a)((prw)localObject1).getData()))
              {
                localObject1 = "2";
                label677:
                if (!this.jdField_b_of_type_Aygz.La()) {
                  break label751;
                }
                localObject2 = "2";
                label692:
                if (!bool) {
                  break label759;
                }
              }
              label751:
              label759:
              for (localObject3 = "1";; localObject3 = "0")
              {
                rar.a("video_edit", "clk_music", 0, 0, new String[] { localObject2, localObject1, localObject3, "" });
                i = 2;
                break;
                localObject1 = "1";
                break label677;
                localObject2 = "1";
                break label692;
              }
              this.ca.add(Integer.valueOf(6));
              bool = this.jdField_b_of_type_Aygz.eP(5);
              if (this.jdField_b_of_type_Aygz.La())
              {
                localObject1 = "2";
                label805:
                if (!bool) {
                  break label965;
                }
              }
              label965:
              for (localObject2 = "1";; localObject2 = "0")
              {
                rar.a("video_edit", "clk_graffiti", 0, 0, new String[] { localObject1, "", localObject2, "" });
                rar.b("clk_graffiti", RR(), 0, new String[0]);
                ras.aP(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg(), "0X8007821");
                this.jdField_b_of_type_Aygz.f("608", "10", "0", true);
                ras.bw("0X80075C4", ras.bpo);
                ras.aP(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg(), "0X800781E");
                aff(536870912);
                if (!this.jdField_b_of_type_Aygz.eO(7)) {
                  break label973;
                }
                this.jdField_b_of_type_Aygz.changeState(0);
                i = j;
                break;
                localObject1 = "1";
                break label805;
              }
              label973:
              i = 7;
              continue;
              this.ca.add(Integer.valueOf(1));
              ras.bw("0X80075C6", ras.bpo);
              ras.aP(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg(), "0X8007820");
              rar.b("clk_text", RR(), 0, new String[0]);
              aff(1);
              if (this.jdField_b_of_type_Aygz.eO(5)) {
                this.jdField_b_of_type_Aygz.changeState(0);
              }
              for (;;)
              {
                afg(9);
                i = j;
                break;
                this.jdField_b_of_type_Aygz.eRK();
              }
              this.ca.add(Integer.valueOf(3));
              this.jdField_b_of_type_Aygz.eP(3);
              rar.a("video_edit_new", "clk_sticker", RR(), 0, new String[0]);
              afg(12);
              ras.bw("0X80075C7", ras.bpo);
              aff(8);
              this.jdField_b_of_type_Aygz.f("608", "11", "0", true);
              ras.aP(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg(), "0X800781D");
              if (this.jdField_b_of_type_Aygz.eO(6))
              {
                this.jdField_b_of_type_Aygz.changeState(0);
                i = j;
              }
              else
              {
                i = 6;
                continue;
                localObject2 = this.jdField_b_of_type_Aygz;
                if (this.jdField_b_of_type_Aygz.La()) {}
                for (localObject1 = "2";; localObject1 = "1")
                {
                  ((aygz)localObject2).c("add_tag", 0, 0, new String[] { localObject1 });
                  this.jdField_b_of_type_Aygz.changeState(1);
                  i = j;
                  break;
                }
                ras.bw("0X80075C8", ras.bpo);
                if ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 3)) {
                  LpReportInfo_pf00064.report(615, 5);
                }
                this.jdField_b_of_type_Aygz.btd();
                i = j;
                continue;
                this.ca.add(Integer.valueOf(7));
                ras.bw("0X80075C5", ras.bpo);
                if ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 3)) {
                  LpReportInfo_pf00064.report(615, 2);
                }
                this.jdField_b_of_type_Aygz.btb();
                rar.a("video_edit_new", "clk_cut", RR(), 0, new String[0]);
                i = j;
                continue;
                rar.a("video_edit", "edit_alt", 0, 0, new String[0]);
                this.jdField_b_of_type_Aygz.changeState(18);
                i = j;
                continue;
                rar.a("video_edit", "share_to_group", 0, 0, new String[0]);
                rar.a("story_grp", "clk_share_grp", 0, 0, new String[] { "", "", "", "" });
                this.jdField_b_of_type_Aygz.changeState(25);
                i = j;
                continue;
                this.jdField_b_of_type_Aygz.changeState(21);
                i = j;
                if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
                {
                  i = j;
                  if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 3) {
                    if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Le())
                    {
                      LpReportInfo_pf00064.allReport(628, 5, 1);
                      i = j;
                    }
                    else
                    {
                      LpReportInfo_pf00064.report(615, 5);
                      i = j;
                      continue;
                      if (!this.aGO) {}
                      for (bool = true;; bool = false)
                      {
                        this.aGO = bool;
                        this.jdField_b_of_type_Aygz.tD(this.aGO);
                        localObject1 = (ImageView)paramView;
                        localObject2 = (ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(2L);
                        if (!this.aGO) {
                          break label1667;
                        }
                        ((ImageView)localObject1).setImageResource(2130847405);
                        i = j;
                        if (localObject2 == null) {
                          break;
                        }
                        ((ImageView)localObject2).setColorFilter(getResources().getColor(2131166534), PorterDuff.Mode.SRC_IN);
                        i = j;
                        break;
                      }
                      label1667:
                      ((ImageView)localObject1).setImageResource(2130847404);
                      i = j;
                      if (localObject2 != null)
                      {
                        ((ImageView)localObject2).clearColorFilter();
                        i = j;
                        continue;
                        if (this.jdField_b_of_type_Aygz.eO(28))
                        {
                          this.jdField_b_of_type_Aygz.changeState(0);
                          i = j;
                        }
                        else
                        {
                          this.jdField_b_of_type_Aygz.changeState(28);
                          i = j;
                          continue;
                          i = RR();
                          if (this.jdField_b_of_type_Aygz.La()) {}
                          for (localObject1 = "1";; localObject1 = "2")
                          {
                            rar.a("video_edit_new", "clk_filter", i, 0, new String[] { "", localObject1, "", "" });
                            if (!this.jdField_b_of_type_Aygz.eO(29)) {
                              break label1822;
                            }
                            this.jdField_b_of_type_Aygz.changeState(0);
                            i = j;
                            break;
                          }
                          label1822:
                          this.jdField_b_of_type_Aygz.changeState(29);
                          i = j;
                          continue;
                          this.ca.add(Integer.valueOf(4));
                          if (this.jdField_b_of_type_Aygz.eO(30)) {
                            this.jdField_b_of_type_Aygz.changeState(0);
                          }
                          for (i = j;; i = 30)
                          {
                            rar.b("clk_effect", RR(), 0, new String[0]);
                            afg(10);
                            break;
                          }
                          localObject1 = (ayfb)a(ayfb.class);
                          i = j;
                          if (localObject1 != null)
                          {
                            if (((ayfb)localObject1).RQ() == 0)
                            {
                              if (this.jdField_b_of_type_Aygz.eO(40)) {
                                this.jdField_b_of_type_Aygz.changeState(0);
                              }
                              for (i = j;; i = 40)
                              {
                                rar.a("video_edit_transition", "clk_transition", ayih.lZ(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.getIntExtra("extra_transiton_src_from", -1)), 0, new String[0]);
                                afg(11);
                                break;
                              }
                            }
                            ((ayfb)localObject1).eRa();
                            rar.a("video_edit_transition", "exp_toastFail", ayih.lZ(this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.getIntExtra("extra_transiton_src_from", -1)), 0, new String[0]);
                            break;
                            this.ca.add(Integer.valueOf(5));
                            if (this.dyV)
                            {
                              QQToast.a(getContext(), acfp.m(2131705583), 0).show();
                              break;
                            }
                            if (!this.jdField_b_of_type_Aygz.eO(0)) {
                              this.jdField_b_of_type_Aygz.changeState(0);
                            }
                            this.jdField_b_of_type_Aygz.eRN();
                            anot.a(null, "dc00899", "grp_story", "", "video_edit", "edit_linkbar", 0, 0, "2", "0", "", "");
                            i = j;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          if (this.jdField_b_of_type_Aygz.bqq == 26)
          {
            this.jdField_b_of_type_Aygz.changeState(0);
            label2162:
            if ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi != 2) && (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi != 5) && (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi != 6)) {
              break label2254;
            }
          }
          label2254:
          for (i = 1;; i = 0)
          {
            rar.a("video_edit_aio", "ttpt_clk", 0, i, new String[0]);
            rar.a("video_edit_new", "clk_pitu", 0, i, new String[0]);
            i = j;
            break;
            this.jdField_b_of_type_Aygz.changeState(26);
            break label2162;
          }
        }
        i += 1;
      }
      label2266:
      jz(paramView);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.yj = ((TextView)y(2131365427));
    this.yj.setOnClickListener(this);
    this.IO = ((ImageView)y(2131365428));
    this.IO.setOnClickListener(this);
    this.yk = ((TextView)y(2131365426));
    this.yk.setOnClickListener(this);
    this.Ni = y(2131366223);
    this.Ni.setVisibility(8);
    this.Ni.setOnClickListener(this);
    jA(this.yk);
    this.cu = ((ViewGroup)y(2131364110));
    this.cv = ((ViewGroup)y(2131366486));
    this.k = a(this.aCF, this.cv, this);
    this.ff = ((ViewGroup)y(2131364118));
    this.fh = ((ViewGroup)y(2131364112));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout = ((HorizontalAlumbListLayout)y(2131372286));
    if (aygz.F(this.aCF, 17179869184L))
    {
      this.eJZ = getResources().getColor(2131166769);
      this.bM = ((XEditTextEx)y(2131366530));
      this.bM.setEditableFactory(TroopBarPublishUtils.a);
      tat.b(getContext(), this.bM);
      y(2131366530).setOnClickListener(this);
      y(2131366345).setOnClickListener(this);
      this.fm = ((ViewGroup)y(2131370675));
      this.fm.setVisibility(0);
    }
    Object localObject;
    if (this.jdField_b_of_type_Aygz.ok != null)
    {
      localObject = (ViewGroup)this.fh.getParent();
      ((ViewGroup)localObject).removeView(this.fh);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.fh.getLayoutParams();
      localLayoutParams.topMargin = aqnm.dip2px(14.0F);
      localLayoutParams.addRule(10, -1);
      localLayoutParams.addRule(12, 0);
      this.jdField_b_of_type_Aygz.ok.addView(this.fh, localLayoutParams);
      if (aygz.F(this.aCF, 17179869184L))
      {
        ((ViewGroup)localObject).removeView(this.fm);
        localLayoutParams = (RelativeLayout.LayoutParams)this.fm.getLayoutParams();
        localLayoutParams.bottomMargin = this.jdField_b_of_type_Aygz.ok.getLayoutParams().height;
        ((ViewGroup)localObject).addView(this.fm, localLayoutParams);
      }
    }
    this.fi = ((ViewGroup)y(2131364114));
    this.fj = ((ViewGroup)y(2131379224));
    this.fg = this.fh;
    this.e = ((HorizontalScrollView)y(2131366487));
    this.e.getViewTreeObserver().addOnScrollChangedListener(new ayfi(this));
    this.fk = ((ViewGroup)y(2131373803));
    this.ahV = ((TextView)y(2131373799));
    this.fl = ((ViewGroup)y(2131365406));
    this.fl.setOnClickListener(this);
    this.oE = y(2131372995);
    this.Nj = ((PressDarkImageButton)y(2131379091));
    if ((this.aCF & 0x20000) != 0L)
    {
      this.oE.setVisibility(0);
      this.oE.setOnClickListener(this);
      this.Nj.setVisibility(0);
      this.Nj.setOnClickListener(this);
    }
    this.IP = ((ImageView)y(2131380030));
    if ((this.aCF & 0x2000) != 0L)
    {
      if ((this.jdField_b_of_type_Aygz instanceof aytw)) {
        this.IP.setImageResource(2130848752);
      }
      this.IP.setVisibility(0);
      this.IP.setOnClickListener(this);
      this.IQ = ((ImageView)y(2131380035));
      if (this.jdField_b_of_type_Aygz.b == null) {
        this.IQ.setVisibility(8);
      }
      this.IR = ((ImageView)y(2131380011));
      if ((this.aCF & 0x0) == 0L) {
        break label1286;
      }
      this.IR.setOnClickListener(this);
      if ((QzoneModuleManager.getInstance().isModuleDownloaded("cyber_clink_version_2.jar")) && (!QzoneModuleManager.getInstance().checkIfNeedUpdate("cyber_clink_version_2.jar"))) {
        break label1275;
      }
      eRr();
      label783:
      eRl();
      if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg() == 102) {
        this.IP.setVisibility(4);
      }
      this.eX = ((LinearLayout)y(2131362743));
      this.ym = ((TextView)y(2131362747));
      this.fQ = ((RelativeLayout)y(2131362744));
      this.ng = ((ImageView)y(2131362745));
      this.yl = ((TextView)y(2131362746));
      this.eX.setVisibility(8);
      this.ym.setVisibility(8);
      this.fQ.setVisibility(8);
      this.ng.setVisibility(8);
      this.yl.setVisibility(8);
      d(new View[] { this.yj, this.yk });
      d(this.k);
      this.jdField_a_of_type_AndroidAnimationLayoutTransition.setAnimator(3, ObjectAnimator.ofFloat(null, "alpha", new float[] { 1.0F, 0.0F }));
      this.jdField_a_of_type_AndroidAnimationLayoutTransition.setDuration(3, 500L);
      this.jdField_a_of_type_AndroidAnimationLayoutTransition.setAnimator(2, ObjectAnimator.ofFloat(null, "alpha", new float[] { 0.0F, 1.0F }));
      this.jdField_a_of_type_AndroidAnimationLayoutTransition.setDuration(2, 500L);
      this.oG = y(2131379233);
      this.Nk = y(2131362222);
      if ((this.aCF & 0x4000000) == 0L) {
        break label1298;
      }
      this.oG.setVisibility(0);
      this.oG.setOnClickListener(this);
      this.Nk.setOnClickListener(this);
      label1088:
      int i = this.jdField_a_of_type_Ayii.getActivity().getIntent().getIntExtra("pic_entrance_type", -1);
      if ((!this.jdField_b_of_type_Aygz.La()) || (i == 1) || (i == 2) || (i == 3) || (i == 11) || (i == 13)) {
        break label1319;
      }
      this.yj.setText(acfp.m(2131705705));
      this.yj.setContentDescription(acfp.m(2131705569));
    }
    for (;;)
    {
      a(ayde.class, this);
      this.dyP = false;
      this.btC = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).getBoolean("showFlashPic", true);
      if (this.jdField_b_of_type_Aygz.La()) {
        this.ahV.setText(acfp.m(2131705618));
      }
      localObject = this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.mExtra;
      if (localObject != null) {
        this.dyW = ((Bundle)localObject).getBoolean("key_enable_edit_title_bar", false);
      }
      return;
      this.IP.setVisibility(8);
      break;
      label1275:
      this.IR.setVisibility(0);
      break label783;
      label1286:
      this.IR.setVisibility(8);
      break label783;
      label1298:
      this.oG.setVisibility(8);
      this.Nk.setVisibility(8);
      break label1088;
      label1319:
      if (this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.mMode == 0)
      {
        this.yj.setText(acfp.m(2131705519));
        this.yj.setContentDescription(acfp.m(2131705542));
      }
      else
      {
        this.yj.setText(acfp.m(2131705654));
        this.yj.setContentDescription(acfp.m(2131705598));
        this.IO.setVisibility(0);
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_b_of_type_Aygz.bqq == 0) && (!this.dyP))
    {
      if (((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakePhotoSource)) || ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakeVideoSource)) || ((this.jdField_b_of_type_Aygz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditRecordVideoSource)))
      {
        int i = wja.dp2px(-48.0F, getResources());
        ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.ff, "translationY", new float[] { i, 0.0F });
        localObjectAnimator1.setDuration(800L);
        i = wja.dp2px(getResources().getDimension(2131298491), getResources());
        ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.fg, "translationY", new float[] { i, 0.0F });
        localObjectAnimator2.setDuration(800L);
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
        localAnimatorSet.start();
      }
      this.dyP = true;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    eRk();
  }
  
  public void tz(boolean paramBoolean)
  {
    int i = 1;
    int j = 0;
    if (paramBoolean) {}
    for (;;)
    {
      ram.w("Q.qqstory.record.EditVideoButton", "setEnableButtonEnable: %d", new Object[] { Integer.valueOf(i) });
      this.yk.setEnabled(paramBoolean);
      i = j;
      while (i < this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.size())
      {
        long l = this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.keyAt(i);
        ((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(l)).setEnabled(paramBoolean);
        i += 1;
      }
      i = 0;
    }
  }
  
  public void wP(int paramInt)
  {
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(1048576L);
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void x(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = 0;
    if (paramBoolean2)
    {
      this.BK = (System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        this.BK += 500L;
      }
      if (paramBoolean1) {
        ayjd.t(this.fg, paramBoolean3);
      }
      for (;;)
      {
        this.jdField_b_of_type_Aygz.a(Message.obtain(null, 11, Long.valueOf(this.BK)));
        if (!paramBoolean1) {
          break;
        }
        i = 0;
        while (i < this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.size())
        {
          ((ImageView)this.jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.valueAt(i)).setVisibility(0);
          i += 1;
        }
        ayjd.s(this.fg, paramBoolean3);
      }
    }
    this.fg.setAnimation(null);
    Object localObject = this.fg;
    if (paramBoolean1) {}
    for (int i = 0;; i = 8)
    {
      ((ViewGroup)localObject).setVisibility(i);
      this.BK = 0L;
      break;
    }
    if ((this.aCF & 0x20000) != 0L)
    {
      this.oE.setVisibility(0);
      this.Nj.setVisibility(0);
    }
    if (((this.aCF & 0x0) != 0L) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null))
    {
      localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout;
      if (!paramBoolean1) {
        break label236;
      }
    }
    label236:
    for (i = j;; i = 8)
    {
      ((HorizontalAlumbListLayout)localObject).setVisibility(i);
      return;
    }
  }
  
  public static class a
  {
    public final CharSequence C;
    public final long aCI;
    public final int iconResId;
    
    public a(long paramLong, int paramInt, CharSequence paramCharSequence)
    {
      this.aCI = paramLong;
      this.iconResId = paramInt;
      this.C = paramCharSequence;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayfh
 * JD-Core Version:    0.7.0.1
 */