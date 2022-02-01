import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditGifImage;
import com.tencent.biz.qqstory.takevideo.EditLocalGifSource;
import com.tencent.biz.qqstory.takevideo.EditTakeGifSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

@TargetApi(11)
public class rcb
  extends rdb
  implements View.OnClickListener, raz
{
  public static final SparseArray<rcb.a> aR;
  public static final int[] dW = { 2131366210, 2131366211, 2131366215, 2131366216, 2131366217, 2131366218, 2131366219, 2131366220, 2131366221, 2131366222, 2131366212 };
  private long BI;
  protected SparseIntArray F = new SparseIntArray();
  private LayoutTransition a;
  private boolean aGO;
  private SparseArray<ImageView> aS = new SparseArray();
  public int bpT;
  private ViewGroup cu;
  private ViewGroup cv;
  private HorizontalScrollView e;
  private LinearLayout eX;
  private RelativeLayout fQ;
  private RelativeLayout fR;
  private ImageView[] k;
  private ImageView ng;
  private ImageView nh;
  private View oD;
  private View oE;
  private View oF;
  private View oG;
  private TextView yj;
  private TextView yk;
  private TextView yl;
  private TextView ym;
  
  static
  {
    aR = new SparseArray();
    aR.put(32, new rcb.a(32, 2130847524, acfp.m(2131705604)));
    aR.put(1, new rcb.a(1, 2130847439, acfp.m(2131705605)));
    aR.put(4, new rcb.a(4, 2130847734, acfp.m(2131705526)));
    aR.put(8, new rcb.a(8, 2130847380, acfp.m(2131705663)));
    aR.put(128, new rcb.a(128, 2130847567, acfp.m(2131705623)));
    aR.put(16, new rcb.a(16, 2130847269, acfp.m(2131705545)));
    aR.put(2, new rcb.a(2, 2130847365, acfp.m(2131705494)));
    aR.put(131072, new rcb.a(131072, 2130847707, acfp.m(2131705579)));
    aR.put(1024, new rcb.a(1024, 2130846825, acfp.m(2131705506)));
    aR.put(4096, new rcb.a(4096, 2130847420, "GIF快慢"));
    aR.put(8192, new rcb.a(8192, 2130847404, "生成GIF"));
    aR.put(262144, new rcb.a(262144, 2130847434, "跳转到P图"));
  }
  
  public rcb(@NonNull rdc paramrdc, int paramInt)
  {
    super(paramrdc);
    this.jdField_a_of_type_AndroidAnimationLayoutTransition = new LayoutTransition();
    this.bpT = paramInt;
  }
  
  private ImageView[] a(int paramInt, @NonNull ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    int n = paramViewGroup.getChildCount();
    if (n != dW.length) {
      throw new IllegalArgumentException("布局文件中的子View个数与EDIT_BUTTON_IDS数组长度不同");
    }
    int j = 0;
    int i1 = paramInt & 0x630BF;
    int i = 0;
    paramInt = j;
    if (i < 23)
    {
      j = 1 << i;
      if ((i1 & j) != j) {
        break label415;
      }
      paramInt += 1;
    }
    label415:
    for (;;)
    {
      i += 1;
      break;
      ram.b("Q.qqstory.record.EditVideoButton", "initEditButtons, needButtonCount = %d", Integer.valueOf(paramInt));
      if (n < paramInt) {
        throw new IllegalArgumentException("too many parts, there is no enough view to show");
      }
      ImageView[] arrayOfImageView = new ImageView[n];
      i = 0;
      Object localObject;
      while (i < n)
      {
        localObject = paramViewGroup.findViewById(dW[i]);
        if ((localObject instanceof ImageView))
        {
          arrayOfImageView[i] = ((ImageView)localObject);
          i += 1;
        }
        else
        {
          throw new IllegalArgumentException("can not find ImageView by id : " + dW[i] + ", view : " + localObject);
        }
      }
      this.F.clear();
      j = 0;
      i = 0;
      int m;
      for (;;)
      {
        m = i;
        if (j < 23)
        {
          int i2 = 1 << j;
          m = i;
          if ((i1 & i2) == i2)
          {
            paramViewGroup = arrayOfImageView[i];
            localObject = (rcb.a)aR.get(i2);
          }
          try
          {
            paramViewGroup.setImageDrawable(new BitmapDrawable(BitmapFactory.decodeResource(getResources(), ((rcb.a)localObject).iconResId)));
            paramViewGroup.setContentDescription(((rcb.a)localObject).C);
            paramViewGroup.setOnClickListener(paramOnClickListener);
            this.F.put(paramViewGroup.getId(), i2);
            this.aS.put(i2, paramViewGroup);
            m = i + 1;
            j += 1;
            i = m;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            for (;;)
            {
              ram.e("Q.qqstory.record.EditVideoButton", "decodeResource OutOfMemoryError : %s", new Object[] { ((rcb.a)localObject).C });
            }
          }
        }
      }
      while (m < n)
      {
        arrayOfImageView[m].setOnClickListener(null);
        arrayOfImageView[m].setVisibility(8);
        m += 1;
      }
      if (paramInt >= 6) {
        bsA();
      }
      return arrayOfImageView;
    }
  }
  
  private void bsA()
  {
    int i = this.jdField_a_of_type_Rel.getContext().getResources().getDisplayMetrics().widthPixels - rpq.dip2px(this.jdField_a_of_type_Rel.getContext(), 72.0F);
    int j = rpq.dip2px(this.jdField_a_of_type_Rel.getContext(), 48.0F);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
    if ((i >= j * 5) && (i < j * 6)) {}
    for (localLayoutParams.width = ((int)(j * 4.5D));; localLayoutParams.width = ((int)(j * 3.5D))) {
      do
      {
        ram.d("Q.qqstory.record.EditVideoButton", "new size : " + this.e.toString() + ", width=" + localLayoutParams.width);
        this.e.setLayoutParams(localLayoutParams);
        return;
      } while ((i < j * 4) || (i >= j * 5));
    }
  }
  
  private void bsB()
  {
    if ((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.Le()) || (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.Lf()))
    {
      if (!this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.aGr) {
        break label79;
      }
      as(true, false);
      this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.removeMessages(994);
      this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.sendEmptyMessage(995);
    }
    label79:
    do
    {
      return;
      this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.sendEmptyMessageDelayed(994, 0L);
    } while (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.aGp);
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
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localLayoutParams.height = ((int)(localLayoutParams.height * (16.0F / f1)));
      localLayoutParams.width = ((int)(localLayoutParams.width * (16.0F / f1)));
      ram.d("Q.qqstory.record.EditVideoButton", "new size : " + localView.toString() + ", height=" + localLayoutParams.height + ", width=" + localLayoutParams.width);
      localView.setLayoutParams(localLayoutParams);
      if ((localView instanceof TextView))
      {
        float f2 = ((TextView)localView).getTextSize();
        float f3 = 16.0F / f1;
        ((TextView)localView).setTextSize(0, f2 * f3);
      }
      i += 1;
    }
  }
  
  private void o(@Nullable ImageView paramImageView)
  {
    int i = 0;
    while (i < this.aS.size())
    {
      ImageView localImageView = (ImageView)this.aS.valueAt(i);
      if (localImageView != null) {
        localImageView.clearColorFilter();
      }
      i += 1;
    }
    if (paramImageView != null) {
      paramImageView.setColorFilter(getResources().getColor(2131166755), PorterDuff.Mode.MULTIPLY);
    }
    if (this.aGO)
    {
      paramImageView = (ImageView)this.aS.get(32);
      if (paramImageView != null) {
        paramImageView.setColorFilter(getResources().getColor(2131166757), PorterDuff.Mode.MULTIPLY);
      }
    }
  }
  
  public void a(int paramInt, @NonNull rkm paramrkm)
  {
    super.a(paramInt, paramrkm);
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
  
  public void d(int paramInt1, int paramInt2, Object paramObject)
  {
    switch (paramInt2)
    {
    case 18: 
    case 19: 
    case 20: 
    case 22: 
    case 25: 
    default: 
      return;
    case 0: 
      o(null);
      if (paramInt1 == 9)
      {
        paramInt2 = 1;
        if (paramInt1 != 23) {
          break label174;
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((i | paramInt2) == 0) {
          break label180;
        }
        at(true, true);
        return;
        paramInt2 = 0;
        break;
      }
      if (paramInt1 == 27)
      {
        n(true, true, false);
        return;
      }
      at(true, false);
      return;
    case 27: 
      n(false, true, false);
      ras.bw("0X80080E5", ras.bpo);
      return;
    case 10: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 24: 
      o(null);
      at(true, false);
      return;
    case 7: 
      o((ImageView)this.aS.get(1));
      if (paramInt1 == 8)
      {
        if ((paramObject != null) && ((paramObject instanceof Boolean)))
        {
          n(true, true, ((Boolean)paramObject).booleanValue());
          return;
        }
        at(true, true);
        return;
      }
      at(true, false);
      return;
    case 5: 
      o((ImageView)this.aS.get(4));
      at(false, false);
      return;
    case 6: 
      o((ImageView)this.aS.get(8));
      at(false, false);
      return;
    case 8: 
      if ((paramObject != null) && ((paramObject instanceof Boolean)))
      {
        at(false, ((Boolean)paramObject).booleanValue());
        return;
      }
      at(false, true);
      return;
    case 9: 
    case 23: 
      at(false, true);
      return;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 12: 
    case 28: 
      at(false, false);
      return;
    case 11: 
      o((ImageView)this.aS.get(2));
      at(false, false);
      return;
    case 21: 
      label174:
      label180:
      o((ImageView)this.aS.get(4096));
      at(false, false);
      return;
    }
    o((ImageView)this.aS.get(262144));
  }
  
  void dO(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      int i = this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.tg();
      if ((i != 101) && (i != 104)) {
        break label56;
      }
      paramView.setText(acfp.m(2131705673));
      paramView.setContentDescription(acfp.m(2131705668));
    }
    label56:
    do
    {
      return;
      if ((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 1) || (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 2))
      {
        paramView.setText(acfp.m(2131705650));
        paramView.setContentDescription(acfp.m(2131705503));
        return;
      }
      if (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 3)
      {
        String str = this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getStringExtra("extra_publish_text");
        if (!TextUtils.isEmpty(str))
        {
          paramView.setText(str);
          paramView.setContentDescription(str);
          return;
        }
        paramView.setText(acfp.m(2131705488));
        paramView.setContentDescription(acfp.m(2131705660));
        return;
      }
      if ((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 5) || (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 6))
      {
        paramView.setText(acfp.m(2131705516));
        paramView.setContentDescription(acfp.m(2131705700));
        return;
      }
    } while (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi != 8);
    paramView.setText(acfp.m(2131705505));
    paramView.setContentDescription(acfp.m(2131705675));
  }
  
  protected boolean e(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.e(paramMessage);
      ImageView localImageView = (ImageView)this.aS.get(paramMessage.arg1);
      if (localImageView != null)
      {
        ram.d("Q.qqstory.record.EditVideoButton", "perform button click %s", localImageView);
        localImageView.performClick();
      }
      else
      {
        ram.w("Q.qqstory.record.EditVideoButton", "can not find view performing click by enable mask %d", new Object[] { Integer.valueOf(paramMessage.arg1) });
      }
    }
  }
  
  public void ea(int paramInt1, int paramInt2)
  {
    if (this.fQ != null)
    {
      if (paramInt1 < paramInt2) {
        this.yl.setText(paramInt1 * 100 / paramInt2 + "%");
      }
    }
    else {
      return;
    }
    this.yl.setText("99%");
  }
  
  public void n(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean2)
    {
      this.BK = (System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        this.BK += 500L;
      }
      if (paramBoolean1)
      {
        rex.t(this.cu, paramBoolean3);
        if ((this.bpT & 0x4000) != 0) {
          rex.t(this.oD, paramBoolean3);
        }
      }
      for (;;)
      {
        this.b.a(Message.obtain(null, 11, Long.valueOf(this.BK)));
        if (!paramBoolean1) {
          break;
        }
        i = 0;
        while (i < this.aS.size())
        {
          ((ImageView)this.aS.valueAt(i)).setVisibility(0);
          i += 1;
        }
        rex.s(this.cu, paramBoolean3);
        if ((this.bpT & 0x4000) != 0) {
          rex.s(this.oD, paramBoolean3);
        }
      }
    }
    this.cu.setAnimation(null);
    ViewGroup localViewGroup = this.cu;
    if (paramBoolean1) {}
    for (int i = 0;; i = 8)
    {
      localViewGroup.setVisibility(i);
      this.BK = 0L;
      break;
    }
    if ((this.fR != null) && (!paramBoolean1)) {
      this.fR.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    int j;
    if (Math.abs(SystemClock.uptimeMillis() - this.BI) > 1000L)
    {
      this.BI = SystemClock.uptimeMillis();
      j = paramView.getId();
      if (this.BK <= System.currentTimeMillis()) {
        break label63;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ram.w("Q.qqstory.record.EditVideoButton", "you click button too fast, ignore it !");
      continue;
      label63:
      if (this.fR != null) {
        this.fR.setVisibility(8);
      }
      Object localObject1 = dW;
      int m = localObject1.length;
      int i = 0;
      for (;;)
      {
        if (i >= m) {
          break label1515;
        }
        if (localObject1[i] == j)
        {
          i = this.F.get(j);
          ram.w("Q.qqstory.record.EditVideoButton", "onClick : mask=%d, view=%s", new Object[] { Integer.valueOf(i), paramView });
          ras.aP(this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.tg(), "0X8007822");
          j = this.b.a(Message.obtain(null, 1, i, 0, paramView));
          if (j > 0)
          {
            ram.i("Q.qqstory.record.EditVideoButton", "%d parts intercept the click event : " + j);
            break;
          }
          this.b.bta();
          switch (i)
          {
          }
          for (;;)
          {
            break;
            bool = this.b.eP(4);
            localObject1 = (prw)((psd)psx.a(20)).a(1);
            if (((prw)localObject1).a((prw.a)((prw)localObject1).getData()))
            {
              localObject1 = "2";
              label367:
              if (!this.b.La()) {
                break label447;
              }
              localObject2 = "2";
              label382:
              if (!bool) {
                break label455;
              }
            }
            label447:
            label455:
            for (String str = "1";; str = "0")
            {
              rar.a("video_edit", "clk_music", 0, 0, new String[] { localObject2, localObject1, str, "" });
              this.b.changeState(2);
              break;
              localObject1 = "1";
              break label367;
              localObject2 = "1";
              break label382;
            }
            bool = this.b.eP(5);
            if (this.b.La())
            {
              localObject1 = "2";
              label488:
              if (!bool) {
                break label668;
              }
              localObject2 = "1";
              label498:
              rar.a("video_edit", "clk_graffiti", 0, 0, new String[] { localObject1, "", localObject2, "" });
              ras.aP(this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.tg(), "0X8007821");
              this.b.f("608", "10", "0", true);
              ras.bw("0X80075C4", ras.bpo);
              ras.aP(this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.tg(), "0X800781E");
              if ((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 3))
              {
                if (!this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.Le()) {
                  break label676;
                }
                LpReportInfo_pf00064.allReport(628, 3);
              }
            }
            for (;;)
            {
              if (!this.b.eO(7)) {
                break label687;
              }
              this.b.changeState(0);
              break;
              localObject1 = "1";
              break label488;
              label668:
              localObject2 = "0";
              break label498;
              label676:
              LpReportInfo_pf00064.allReport(615, 1, 1);
            }
            label687:
            this.b.changeState(7);
            continue;
            ras.bw("0X80075C6", ras.bpo);
            ras.aP(this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.tg(), "0X8007820");
            if ((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 3))
            {
              if (!this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.Le()) {
                break label782;
              }
              LpReportInfo_pf00064.allReport(628, 2);
            }
            for (;;)
            {
              this.b.r(5, Boolean.TRUE);
              break;
              label782:
              LpReportInfo_pf00064.allReport(615, 3, 1);
            }
            bool = this.b.eP(3);
            if (this.b.La())
            {
              localObject1 = "2";
              label818:
              if (!bool) {
                break label982;
              }
              localObject2 = "1";
              label828:
              rar.a("video_edit", "add_face", 0, 0, new String[] { localObject1, "", localObject2, "" });
              ras.bw("0X80075C7", ras.bpo);
              if ((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 3))
              {
                if (!this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.Le()) {
                  break label990;
                }
                LpReportInfo_pf00064.allReport(628, 4);
              }
            }
            for (;;)
            {
              this.b.f("608", "11", "0", true);
              ras.aP(this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.tg(), "0X800781D");
              if (!this.b.eO(6)) {
                break label1001;
              }
              this.b.changeState(0);
              break;
              localObject1 = "1";
              break label818;
              label982:
              localObject2 = "0";
              break label828;
              label990:
              LpReportInfo_pf00064.allReport(615, 4, 1);
            }
            label1001:
            ((rgp)psx.a(8)).j(false);
            this.b.changeState(6);
            continue;
            Object localObject2 = this.b;
            if (this.b.La()) {}
            for (localObject1 = "2";; localObject1 = "1")
            {
              ((rdc)localObject2).c("add_tag", 0, 0, new String[] { localObject1 });
              this.b.changeState(1);
              break;
            }
            ras.bw("0X80075C8", ras.bpo);
            if ((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 3)) {
              LpReportInfo_pf00064.allReport(615, 5, 1);
            }
            this.b.btd();
            continue;
            ras.bw("0X80075C5", ras.bpo);
            if ((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 3)) {
              LpReportInfo_pf00064.allReport(615, 2, 1);
            }
            this.b.btb();
            continue;
            rar.a("video_edit", "share_to_group", 0, 0, new String[0]);
            rar.a("story_grp", "clk_share_grp", 0, 0, new String[] { "", "", "", "" });
            this.b.changeState(25);
            continue;
            this.b.changeState(19);
            continue;
            this.b.changeState(21);
            if ((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 3)) {
              if (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.Le())
              {
                LpReportInfo_pf00064.allReport(628, 5, 1);
              }
              else
              {
                LpReportInfo_pf00064.allReport(615, 5, 1);
                continue;
                if (!this.aGO) {
                  bool = true;
                }
                this.aGO = bool;
                this.b.tD(this.aGO);
                localObject1 = (ImageView)paramView;
                localObject2 = (ImageView)this.aS.get(32);
                if (this.aGO)
                {
                  ((ImageView)localObject1).setImageResource(2130847405);
                  if (localObject2 != null) {
                    ((ImageView)localObject2).setColorFilter(getResources().getColor(2131166757), PorterDuff.Mode.MULTIPLY);
                  }
                }
                else
                {
                  ((ImageView)localObject1).setImageResource(2130847404);
                  if (localObject2 != null)
                  {
                    ((ImageView)localObject2).clearColorFilter();
                    continue;
                    if ((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 3)) {
                      LpReportInfo_pf00064.allReport(615, 11);
                    }
                    if (this.b.bqq == 26) {
                      this.b.changeState(0);
                    } else {
                      this.b.changeState(26);
                    }
                  }
                }
              }
            }
          }
        }
        i += 1;
      }
      switch (j)
      {
      default: 
        break;
      case 2131362743: 
        bsB();
        break;
      case 2131365426: 
        if ((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 3)) {
          LpReportInfo_pf00064.allReport(615, 8);
        }
        this.b.bsX();
        break;
      case 2131365427: 
        if ((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 3)) {
          LpReportInfo_pf00064.allReport(615, 10);
        }
        for (;;)
        {
          this.b.bsV();
          break;
          if (((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi != 9)) && (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 10)) {
            anot.a(null, "dc00899", "Grp_tribe", "", "video_edit", "Clk_left", 0, 0, "", "", "", "");
          }
        }
      case 2131372992: 
        if (this.b.eO(22)) {
          this.b.changeState(0);
        } else {
          this.b.changeState(22);
        }
        break;
      case 2131380030: 
        if ((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 3)) {
          LpReportInfo_pf00064.allReport(615, 9);
        }
        this.b.changeState(19);
        break;
      case 2131379178: 
        label1515:
        this.b.changeState(28);
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.yj = ((TextView)y(2131365427));
    this.yj.setOnClickListener(this);
    this.yk = ((TextView)y(2131365426));
    this.yk.setOnClickListener(this);
    this.oD = y(2131372997);
    this.oE = y(2131372992);
    this.oF = y(2131373000);
    dO(this.yk);
    this.cu = ((ViewGroup)y(2131364110));
    this.e = ((HorizontalScrollView)y(2131366487));
    this.cv = ((ViewGroup)y(2131366486));
    this.k = a(this.bpT, this.cv, this);
    this.nh = ((ImageView)y(2131380030));
    Object localObject;
    if ((this.bpT & 0x400) != 0)
    {
      this.nh.setVisibility(0);
      localObject = (rcb.a)aR.get(1024);
    }
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), ((rcb.a)localObject).iconResId);
      this.nh.setImageDrawable(new BitmapDrawable(localBitmap));
      this.nh.setContentDescription(((rcb.a)localObject).C);
      this.nh.setOnClickListener(this);
      this.oG = y(2131379178);
      if ((this.bpT & 0x400000) != 0)
      {
        this.oG.setVisibility(0);
        this.oG.setOnClickListener(this);
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
        if ((this.bpT & 0x4000) == 0) {
          break label682;
        }
        this.oD.setVisibility(0);
        this.oE.setOnClickListener(this);
        rar.a("pub_control", "exp_entry", 0, 0, new String[0]);
        if (!(this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditTakeGifSource)) {
          break label694;
        }
        this.yj.setText(acfp.m(2131705480));
        this.yj.setContentDescription(acfp.m(2131705670));
        localObject = this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mExtra;
        if ((localObject != null) && (((Bundle)localObject).getInt("video_redbag_get", 0) == LocalMediaInfo.REDBAG_TYPE_GET))
        {
          this.fR = ((RelativeLayout)y(2131364115));
          this.fR.setVisibility(0);
          ram.w("Q.qqstory.record.EditVideoButton", "VideoRedbag, editVideoButton show redbag tips");
        }
        a(raz.class, this);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        ram.e("Q.qqstory.record.EditVideoButton", "decodeResource OutOfMemoryError : %s", new Object[] { ((rcb.a)localObject).C });
        continue;
        this.oG.setVisibility(8);
        continue;
        label682:
        this.oD.setVisibility(8);
        continue;
        label694:
        if ((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalGifSource))
        {
          this.yj.setText(acfp.m(2131705658));
          this.yj.setContentDescription(acfp.m(2131705490));
        }
        else if (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.Lc())
        {
          this.yj.setText(acfp.m(2131705625));
          this.yj.setContentDescription(acfp.m(2131705708));
        }
        else if ((this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.Ld()) && (this.b.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.asi == 1))
        {
          this.yj.setText(acfp.m(2131705575));
          this.yj.setContentDescription(acfp.m(2131705644));
        }
        else
        {
          this.yj.setText(acfp.m(2131705704));
          this.yj.setContentDescription(acfp.m(2131705520));
        }
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void tz(boolean paramBoolean)
  {
    this.yk.setEnabled(paramBoolean);
    int i = 0;
    while (i < this.aS.size())
    {
      int j = this.aS.keyAt(i);
      ((ImageView)this.aS.get(j)).setEnabled(paramBoolean);
      i += 1;
    }
  }
  
  public void wO(int paramInt)
  {
    ImageView localImageView = (ImageView)this.aS.get(32);
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void wP(int paramInt)
  {
    ImageView localImageView = (ImageView)this.aS.get(131072);
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public static class a
  {
    public final CharSequence C;
    public final int bpU;
    public final int iconResId;
    
    public a(int paramInt1, int paramInt2, CharSequence paramCharSequence)
    {
      this.bpU = paramInt1;
      this.iconResId = paramInt2;
      this.C = paramCharSequence;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rcb
 * JD-Core Version:    0.7.0.1
 */