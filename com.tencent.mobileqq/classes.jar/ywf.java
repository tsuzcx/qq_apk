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
public class ywf
  extends yxr
  implements View.OnClickListener, yux
{
  public static final SparseArray<ywg> a;
  public static final int[] a;
  public int a;
  private long jdField_a_of_type_Long;
  private LayoutTransition jdField_a_of_type_AndroidAnimationLayoutTransition = new LayoutTransition();
  protected SparseIntArray a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView;
  private SparseArray<ImageView> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131365833, 2131365834, 2131365838, 2131365839, 2131365840, 2131365841, 2131365842, 2131365843, 2131365844, 2131365845, 2131365835 };
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(32, new ywg(32, 2130846659, anzj.a(2131702726)));
    jdField_a_of_type_AndroidUtilSparseArray.put(1, new ywg(1, 2130846574, anzj.a(2131702727)));
    jdField_a_of_type_AndroidUtilSparseArray.put(4, new ywg(4, 2130846868, anzj.a(2131702648)));
    jdField_a_of_type_AndroidUtilSparseArray.put(8, new ywg(8, 2130846515, anzj.a(2131702785)));
    jdField_a_of_type_AndroidUtilSparseArray.put(128, new ywg(128, 2130846702, anzj.a(2131702745)));
    jdField_a_of_type_AndroidUtilSparseArray.put(16, new ywg(16, 2130846404, anzj.a(2131702667)));
    jdField_a_of_type_AndroidUtilSparseArray.put(2, new ywg(2, 2130846500, anzj.a(2131702616)));
    jdField_a_of_type_AndroidUtilSparseArray.put(131072, new ywg(131072, 2130846841, anzj.a(2131702701)));
    jdField_a_of_type_AndroidUtilSparseArray.put(1024, new ywg(1024, 2130845923, anzj.a(2131702628)));
    jdField_a_of_type_AndroidUtilSparseArray.put(4096, new ywg(4096, 2130846555, "GIF快慢"));
    jdField_a_of_type_AndroidUtilSparseArray.put(8192, new ywg(8192, 2130846539, "生成GIF"));
    jdField_a_of_type_AndroidUtilSparseArray.put(262144, new ywg(262144, 2130846569, "跳转到P图"));
  }
  
  public ywf(@NonNull yxt paramyxt, int paramInt)
  {
    super(paramyxt);
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(@Nullable ImageView paramImageView)
  {
    int i = 0;
    while (i < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localImageView != null) {
        localImageView.clearColorFilter();
      }
      i += 1;
    }
    if (paramImageView != null) {
      paramImageView.setColorFilter(a().getColor(2131166472), PorterDuff.Mode.MULTIPLY);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramImageView = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(32);
      if (paramImageView != null) {
        paramImageView.setColorFilter(a().getColor(2131166474), PorterDuff.Mode.MULTIPLY);
      }
    }
  }
  
  private void a(View... paramVarArgs)
  {
    float f1 = anxh.a();
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
      yuk.b("Q.qqstory.record.EditVideoButton", "new size : " + localView.toString() + ", height=" + localLayoutParams.height + ", width=" + localLayoutParams.width);
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
  
  private ImageView[] a(int paramInt, @NonNull ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    int m = paramViewGroup.getChildCount();
    if (m != jdField_a_of_type_ArrayOfInt.length) {
      throw new IllegalArgumentException("布局文件中的子View个数与EDIT_BUTTON_IDS数组长度不同");
    }
    int j = 0;
    int n = paramInt & 0x630BF;
    int i = 0;
    paramInt = j;
    if (i < 23)
    {
      j = 1 << i;
      if ((n & j) != j) {
        break label418;
      }
      paramInt += 1;
    }
    label418:
    for (;;)
    {
      i += 1;
      break;
      yuk.a("Q.qqstory.record.EditVideoButton", "initEditButtons, needButtonCount = %d", Integer.valueOf(paramInt));
      if (m < paramInt) {
        throw new IllegalArgumentException("too many parts, there is no enough view to show");
      }
      ImageView[] arrayOfImageView = new ImageView[m];
      i = 0;
      Object localObject;
      while (i < m)
      {
        localObject = paramViewGroup.findViewById(jdField_a_of_type_ArrayOfInt[i]);
        if ((localObject instanceof ImageView))
        {
          arrayOfImageView[i] = ((ImageView)localObject);
          i += 1;
        }
        else
        {
          throw new IllegalArgumentException("can not find ImageView by id : " + jdField_a_of_type_ArrayOfInt[i] + ", view : " + localObject);
        }
      }
      this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
      j = 0;
      i = 0;
      int k;
      for (;;)
      {
        k = i;
        if (j < 23)
        {
          int i1 = 1 << j;
          k = i;
          if ((n & i1) == i1)
          {
            paramViewGroup = arrayOfImageView[i];
            localObject = (ywg)jdField_a_of_type_AndroidUtilSparseArray.get(i1);
          }
          try
          {
            paramViewGroup.setImageDrawable(new BitmapDrawable(BitmapFactory.decodeResource(a(), ((ywg)localObject).b)));
            paramViewGroup.setContentDescription(((ywg)localObject).a);
            paramViewGroup.setOnClickListener(paramOnClickListener);
            this.jdField_a_of_type_AndroidUtilSparseIntArray.put(paramViewGroup.getId(), i1);
            this.jdField_b_of_type_AndroidUtilSparseArray.put(i1, paramViewGroup);
            k = i + 1;
            j += 1;
            i = k;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            for (;;)
            {
              yuk.e("Q.qqstory.record.EditVideoButton", "decodeResource OutOfMemoryError : %s", new Object[] { ((ywg)localObject).a });
            }
          }
        }
      }
      while (k < m)
      {
        arrayOfImageView[k].setOnClickListener(null);
        arrayOfImageView[k].setVisibility(8);
        k += 1;
      }
      if (paramInt >= 6) {
        f();
      }
      return arrayOfImageView;
    }
  }
  
  private void f()
  {
    int i = this.jdField_a_of_type_Yze.a().getResources().getDisplayMetrics().widthPixels - zps.a(this.jdField_a_of_type_Yze.a(), 72.0F);
    int j = zps.a(this.jdField_a_of_type_Yze.a(), 48.0F);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getLayoutParams();
    if ((i >= j * 5) && (i < j * 6)) {}
    for (localLayoutParams.width = ((int)(j * 4.5D));; localLayoutParams.width = ((int)(j * 3.5D))) {
      do
      {
        yuk.b("Q.qqstory.record.EditVideoButton", "new size : " + this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.toString() + ", width=" + localLayoutParams.width);
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setLayoutParams(localLayoutParams);
        return;
      } while ((i < j * 4) || (i >= j * 5));
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) || (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.f()))
    {
      if (!this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.d) {
        break label79;
      }
      a(true, false);
      this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.removeMessages(994);
      this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.sendEmptyMessage(995);
    }
    label79:
    do
    {
      return;
      this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.sendEmptyMessageDelayed(994, 0L);
    } while (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.b);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText("0%");
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848134);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
  }
  
  public void W_()
  {
    super.W_();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131365110));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131365109));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = a(2131372402);
    this.jdField_b_of_type_AndroidViewView = a(2131372397);
    this.jdField_c_of_type_AndroidViewView = a(2131372405);
    a(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364054));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)a(2131366097));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131366096));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = a(this.jdField_a_of_type_Int, this.jdField_b_of_type_AndroidViewViewGroup, this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131379182));
    Object localObject;
    if ((this.jdField_a_of_type_Int & 0x400) != 0)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject = (ywg)jdField_a_of_type_AndroidUtilSparseArray.get(1024);
    }
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(a(), ((ywg)localObject).b);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(localBitmap));
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(((ywg)localObject).a);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView = a(2131378384);
      if ((this.jdField_a_of_type_Int & 0x400000) != 0)
      {
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131362718));
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131362722));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131362719));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131362720));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131362721));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        a(new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView });
        a(this.jdField_a_of_type_ArrayOfAndroidWidgetImageView);
        this.jdField_a_of_type_AndroidAnimationLayoutTransition.setAnimator(3, ObjectAnimator.ofFloat(null, "alpha", new float[] { 1.0F, 0.0F }));
        this.jdField_a_of_type_AndroidAnimationLayoutTransition.setDuration(3, 500L);
        this.jdField_a_of_type_AndroidAnimationLayoutTransition.setAnimator(2, ObjectAnimator.ofFloat(null, "alpha", new float[] { 0.0F, 1.0F }));
        this.jdField_a_of_type_AndroidAnimationLayoutTransition.setDuration(2, 500L);
        if ((this.jdField_a_of_type_Int & 0x4000) == 0) {
          break label683;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
        yup.a("pub_control", "exp_entry", 0, 0, new String[0]);
        if (!(this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeGifSource)) {
          break label695;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131702602));
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anzj.a(2131702792));
        localObject = this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle;
        if ((localObject != null) && (((Bundle)localObject).getInt("video_redbag_get", 0) == LocalMediaInfo.REDBAG_TYPE_GET))
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131364059));
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          yuk.d("Q.qqstory.record.EditVideoButton", "VideoRedbag, editVideoButton show redbag tips");
        }
        a(yux.class, this);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        yuk.e("Q.qqstory.record.EditVideoButton", "decodeResource OutOfMemoryError : %s", new Object[] { ((ywg)localObject).a });
        continue;
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        continue;
        label683:
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        continue;
        label695:
        if ((this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131702780));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anzj.a(2131702612));
        }
        else if (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.c())
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131702747));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anzj.a(2131702830));
        }
        else if ((this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.d()) && (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131702697));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anzj.a(2131702766));
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131702826));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anzj.a(2131702642));
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(32);
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      if (paramInt1 < paramInt2) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramInt1 * 100 / paramInt2 + "%");
      }
    }
    else {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText("99%");
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
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
      a(null);
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
        b(true, true);
        return;
        paramInt2 = 0;
        break;
      }
      if (paramInt1 == 27)
      {
        a(true, true, false);
        return;
      }
      b(true, false);
      return;
    case 27: 
      a(false, true, false);
      yuq.b("0X80080E5", yuq.jdField_a_of_type_Int);
      return;
    case 10: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 24: 
      a(null);
      b(true, false);
      return;
    case 7: 
      a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(1));
      if (paramInt1 == 8)
      {
        if ((paramObject != null) && ((paramObject instanceof Boolean)))
        {
          a(true, true, ((Boolean)paramObject).booleanValue());
          return;
        }
        b(true, true);
        return;
      }
      b(true, false);
      return;
    case 5: 
      a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(4));
      b(false, false);
      return;
    case 6: 
      a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(8));
      b(false, false);
      return;
    case 8: 
      if ((paramObject != null) && ((paramObject instanceof Boolean)))
      {
        b(false, ((Boolean)paramObject).booleanValue());
        return;
      }
      b(false, true);
      return;
    case 9: 
    case 23: 
      b(false, true);
      return;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 12: 
    case 28: 
      b(false, false);
      return;
    case 11: 
      a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(2));
      b(false, false);
      return;
    case 21: 
      label174:
      label180:
      a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(4096));
      b(false, false);
      return;
    }
    a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(262144));
  }
  
  public void a(int paramInt, @NonNull zih paramzih)
  {
    super.a(paramInt, paramzih);
  }
  
  void a(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      int i = this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a();
      if ((i != 101) && (i != 104)) {
        break label56;
      }
      paramView.setText(anzj.a(2131702795));
      paramView.setContentDescription(anzj.a(2131702790));
    }
    label56:
    do
    {
      return;
      if ((this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 2))
      {
        paramView.setText(anzj.a(2131702772));
        paramView.setContentDescription(anzj.a(2131702625));
        return;
      }
      if (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)
      {
        String str = this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_publish_text");
        if (!TextUtils.isEmpty(str))
        {
          paramView.setText(str);
          paramView.setContentDescription(str);
          return;
        }
        paramView.setText(anzj.a(2131702610));
        paramView.setContentDescription(anzj.a(2131702782));
        return;
      }
      if ((this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 6))
      {
        paramView.setText(anzj.a(2131702638));
        paramView.setContentDescription(anzj.a(2131702822));
        return;
      }
    } while (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 8);
    paramView.setText(anzj.a(2131702627));
    paramView.setContentDescription(anzj.a(2131702797));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
    int i = 0;
    while (i < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      int j = this.jdField_b_of_type_AndroidUtilSparseArray.keyAt(i);
      ((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(j)).setEnabled(paramBoolean);
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    if (!paramBoolean2)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847701);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847702);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean2)
    {
      this.jdField_c_of_type_Long = (System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        this.jdField_c_of_type_Long += 500L;
      }
      if (paramBoolean1)
      {
        yzv.b(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
        if ((this.jdField_a_of_type_Int & 0x4000) != 0) {
          yzv.b(this.jdField_a_of_type_AndroidViewView, paramBoolean3);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Yxt.a(Message.obtain(null, 11, Long.valueOf(this.jdField_c_of_type_Long)));
        if (!paramBoolean1) {
          break;
        }
        i = 0;
        while (i < this.jdField_b_of_type_AndroidUtilSparseArray.size())
        {
          ((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i)).setVisibility(0);
          i += 1;
        }
        yzv.a(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
        if ((this.jdField_a_of_type_Int & 0x4000) != 0) {
          yzv.a(this.jdField_a_of_type_AndroidViewView, paramBoolean3);
        }
      }
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramBoolean1) {}
    for (int i = 0;; i = 8)
    {
      localViewGroup.setVisibility(i);
      this.jdField_c_of_type_Long = 0L;
      break;
    }
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (!paramBoolean1)) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramMessage.arg1);
      if (localImageView != null)
      {
        yuk.b("Q.qqstory.record.EditVideoButton", "perform button click %s", localImageView);
        localImageView.performClick();
      }
      else
      {
        yuk.d("Q.qqstory.record.EditVideoButton", "can not find view performing click by enable mask %d", new Object[] { Integer.valueOf(paramMessage.arg1) });
      }
    }
  }
  
  public void b(int paramInt)
  {
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(131072);
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, true);
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    int j;
    if (Math.abs(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) > 1000L)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      j = paramView.getId();
      if (this.jdField_c_of_type_Long <= System.currentTimeMillis()) {
        break label63;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      yuk.d("Q.qqstory.record.EditVideoButton", "you click button too fast, ignore it !");
      continue;
      label63:
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      Object localObject1 = jdField_a_of_type_ArrayOfInt;
      int k = localObject1.length;
      int i = 0;
      for (;;)
      {
        if (i >= k) {
          break label1514;
        }
        if (localObject1[i] == j)
        {
          i = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(j);
          yuk.d("Q.qqstory.record.EditVideoButton", "onClick : mask=%d, view=%s", new Object[] { Integer.valueOf(i), paramView });
          yuq.a(this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007822");
          j = this.jdField_a_of_type_Yxt.a(Message.obtain(null, 1, i, 0, paramView));
          if (j > 0)
          {
            yuk.c("Q.qqstory.record.EditVideoButton", "%d parts intercept the click event : " + j);
            break;
          }
          this.jdField_a_of_type_Yxt.p();
          switch (i)
          {
          }
          for (;;)
          {
            break;
            bool = this.jdField_a_of_type_Yxt.b(4);
            localObject1 = (wrz)((wsi)wth.a(20)).a(1);
            if (((wrz)localObject1).a((wsc)((wrz)localObject1).a()))
            {
              localObject1 = "2";
              label367:
              if (!this.jdField_a_of_type_Yxt.a()) {
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
              yup.a("video_edit", "clk_music", 0, 0, new String[] { localObject2, localObject1, str, "" });
              this.jdField_a_of_type_Yxt.a(2);
              break;
              localObject1 = "1";
              break label367;
              localObject2 = "1";
              break label382;
            }
            bool = this.jdField_a_of_type_Yxt.b(5);
            if (this.jdField_a_of_type_Yxt.a())
            {
              localObject1 = "2";
              label488:
              if (!bool) {
                break label668;
              }
              localObject2 = "1";
              label498:
              yup.a("video_edit", "clk_graffiti", 0, 0, new String[] { localObject1, "", localObject2, "" });
              yuq.a(this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007821");
              this.jdField_a_of_type_Yxt.a("608", "10", "0", true);
              yuq.b("0X80075C4", yuq.jdField_a_of_type_Int);
              yuq.a(this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X800781E");
              if ((this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3))
              {
                if (!this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) {
                  break label676;
                }
                LpReportInfo_pf00064.allReport(628, 3);
              }
            }
            for (;;)
            {
              if (!this.jdField_a_of_type_Yxt.a(7)) {
                break label687;
              }
              this.jdField_a_of_type_Yxt.a(0);
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
            this.jdField_a_of_type_Yxt.a(7);
            continue;
            yuq.b("0X80075C6", yuq.jdField_a_of_type_Int);
            yuq.a(this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007820");
            if ((this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3))
            {
              if (!this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) {
                break label782;
              }
              LpReportInfo_pf00064.allReport(628, 2);
            }
            for (;;)
            {
              this.jdField_a_of_type_Yxt.a(5, Boolean.TRUE);
              break;
              label782:
              LpReportInfo_pf00064.allReport(615, 3, 1);
            }
            bool = this.jdField_a_of_type_Yxt.b(3);
            if (this.jdField_a_of_type_Yxt.a())
            {
              localObject1 = "2";
              label818:
              if (!bool) {
                break label982;
              }
              localObject2 = "1";
              label828:
              yup.a("video_edit", "add_face", 0, 0, new String[] { localObject1, "", localObject2, "" });
              yuq.b("0X80075C7", yuq.jdField_a_of_type_Int);
              if ((this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3))
              {
                if (!this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) {
                  break label990;
                }
                LpReportInfo_pf00064.allReport(628, 4);
              }
            }
            for (;;)
            {
              this.jdField_a_of_type_Yxt.a("608", "11", "0", true);
              yuq.a(this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X800781D");
              if (!this.jdField_a_of_type_Yxt.a(6)) {
                break label1001;
              }
              this.jdField_a_of_type_Yxt.a(0);
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
            ((zbz)wth.a(8)).a(false);
            this.jdField_a_of_type_Yxt.a(6);
            continue;
            Object localObject2 = this.jdField_a_of_type_Yxt;
            if (this.jdField_a_of_type_Yxt.a()) {}
            for (localObject1 = "2";; localObject1 = "1")
            {
              ((yxt)localObject2).a("add_tag", 0, 0, new String[] { localObject1 });
              this.jdField_a_of_type_Yxt.a(1);
              break;
            }
            yuq.b("0X80075C8", yuq.jdField_a_of_type_Int);
            if ((this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
              LpReportInfo_pf00064.allReport(615, 5, 1);
            }
            this.jdField_a_of_type_Yxt.s();
            continue;
            yuq.b("0X80075C5", yuq.jdField_a_of_type_Int);
            if ((this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
              LpReportInfo_pf00064.allReport(615, 2, 1);
            }
            this.jdField_a_of_type_Yxt.q();
            continue;
            yup.a("video_edit", "share_to_group", 0, 0, new String[0]);
            yup.a("story_grp", "clk_share_grp", 0, 0, new String[] { "", "", "", "" });
            this.jdField_a_of_type_Yxt.a(25);
            continue;
            this.jdField_a_of_type_Yxt.a(19);
            continue;
            this.jdField_a_of_type_Yxt.a(21);
            if ((this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
              if (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e())
              {
                LpReportInfo_pf00064.allReport(628, 5, 1);
              }
              else
              {
                LpReportInfo_pf00064.allReport(615, 5, 1);
                continue;
                if (!this.jdField_a_of_type_Boolean) {
                  bool = true;
                }
                this.jdField_a_of_type_Boolean = bool;
                this.jdField_a_of_type_Yxt.a(this.jdField_a_of_type_Boolean);
                localObject1 = (ImageView)paramView;
                localObject2 = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(32);
                if (this.jdField_a_of_type_Boolean)
                {
                  ((ImageView)localObject1).setImageResource(2130846540);
                  if (localObject2 != null) {
                    ((ImageView)localObject2).setColorFilter(a().getColor(2131166474), PorterDuff.Mode.MULTIPLY);
                  }
                }
                else
                {
                  ((ImageView)localObject1).setImageResource(2130846539);
                  if (localObject2 != null)
                  {
                    ((ImageView)localObject2).clearColorFilter();
                    continue;
                    if ((this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
                      LpReportInfo_pf00064.allReport(615, 11);
                    }
                    if (this.jdField_a_of_type_Yxt.b == 26) {
                      this.jdField_a_of_type_Yxt.a(0);
                    } else {
                      this.jdField_a_of_type_Yxt.a(26);
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
      case 2131362718: 
        g();
        break;
      case 2131365109: 
        if ((this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
          LpReportInfo_pf00064.allReport(615, 8);
        }
        this.jdField_a_of_type_Yxt.e();
        break;
      case 2131365110: 
        if ((this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
          LpReportInfo_pf00064.allReport(615, 10);
        }
        for (;;)
        {
          this.jdField_a_of_type_Yxt.d();
          break;
          if (((this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 9)) && (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 10)) {
            bdll.b(null, "dc00899", "Grp_tribe", "", "video_edit", "Clk_left", 0, 0, "", "", "", "");
          }
        }
      case 2131372397: 
        if (this.jdField_a_of_type_Yxt.a(22)) {
          this.jdField_a_of_type_Yxt.a(0);
        } else {
          this.jdField_a_of_type_Yxt.a(22);
        }
        break;
      case 2131379182: 
        if ((this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
          LpReportInfo_pf00064.allReport(615, 9);
        }
        this.jdField_a_of_type_Yxt.a(19);
        break;
      case 2131378384: 
        label1514:
        this.jdField_a_of_type_Yxt.a(28);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywf
 * JD-Core Version:    0.7.0.1
 */