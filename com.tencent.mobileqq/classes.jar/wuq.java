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
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

@TargetApi(11)
public class wuq
  extends wwc
  implements View.OnClickListener, wti
{
  public static final SparseArray<wur> a;
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
    jdField_a_of_type_ArrayOfInt = new int[] { 2131365554, 2131365555, 2131365559, 2131365560, 2131365561, 2131365562, 2131365563, 2131365564, 2131365565, 2131365566, 2131365556 };
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(32, new wur(32, 2130846130, alpo.a(2131704210)));
    jdField_a_of_type_AndroidUtilSparseArray.put(1, new wur(1, 2130846045, alpo.a(2131704211)));
    jdField_a_of_type_AndroidUtilSparseArray.put(4, new wur(4, 2130846340, alpo.a(2131704132)));
    jdField_a_of_type_AndroidUtilSparseArray.put(8, new wur(8, 2130845986, alpo.a(2131704269)));
    jdField_a_of_type_AndroidUtilSparseArray.put(128, new wur(128, 2130846173, alpo.a(2131704229)));
    jdField_a_of_type_AndroidUtilSparseArray.put(16, new wur(16, 2130845875, alpo.a(2131704151)));
    jdField_a_of_type_AndroidUtilSparseArray.put(2, new wur(2, 2130845971, alpo.a(2131704100)));
    jdField_a_of_type_AndroidUtilSparseArray.put(131072, new wur(131072, 2130846313, alpo.a(2131704185)));
    jdField_a_of_type_AndroidUtilSparseArray.put(1024, new wur(1024, 2130845438, alpo.a(2131704112)));
    jdField_a_of_type_AndroidUtilSparseArray.put(4096, new wur(4096, 2130846026, "GIF快慢"));
    jdField_a_of_type_AndroidUtilSparseArray.put(8192, new wur(8192, 2130846010, "生成GIF"));
    jdField_a_of_type_AndroidUtilSparseArray.put(262144, new wur(262144, 2130846040, "跳转到P图"));
  }
  
  public wuq(@NonNull wwe paramwwe, int paramInt)
  {
    super(paramwwe);
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
      paramImageView.setColorFilter(a().getColor(2131166392), PorterDuff.Mode.MULTIPLY);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramImageView = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(32);
      if (paramImageView != null) {
        paramImageView.setColorFilter(a().getColor(2131166394), PorterDuff.Mode.MULTIPLY);
      }
    }
  }
  
  private void a(View... paramVarArgs)
  {
    float f1 = alnq.a();
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
      wsv.b("Q.qqstory.record.EditVideoButton", "new size : " + localView.toString() + ", height=" + localLayoutParams.height + ", width=" + localLayoutParams.width);
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
      wsv.a("Q.qqstory.record.EditVideoButton", "initEditButtons, needButtonCount = %d", Integer.valueOf(paramInt));
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
            localObject = (wur)jdField_a_of_type_AndroidUtilSparseArray.get(i1);
          }
          try
          {
            paramViewGroup.setImageDrawable(new BitmapDrawable(BitmapFactory.decodeResource(a(), ((wur)localObject).b)));
            paramViewGroup.setContentDescription(((wur)localObject).a);
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
              wsv.e("Q.qqstory.record.EditVideoButton", "decodeResource OutOfMemoryError : %s", new Object[] { ((wur)localObject).a });
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
    int i = this.jdField_a_of_type_Wxp.a().getResources().getDisplayMetrics().widthPixels - xod.a(this.jdField_a_of_type_Wxp.a(), 72.0F);
    int j = xod.a(this.jdField_a_of_type_Wxp.a(), 48.0F);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getLayoutParams();
    if ((i >= j * 5) && (i < j * 6)) {}
    for (localLayoutParams.width = ((int)(j * 4.5D));; localLayoutParams.width = ((int)(j * 3.5D))) {
      do
      {
        wsv.b("Q.qqstory.record.EditVideoButton", "new size : " + this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.toString() + ", width=" + localLayoutParams.width);
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setLayoutParams(localLayoutParams);
        return;
      } while ((i < j * 4) || (i >= j * 5));
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) || (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.f()))
    {
      if (!this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.d) {
        break label79;
      }
      a(true, false);
      this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.removeMessages(994);
      this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.sendEmptyMessage(995);
    }
    label79:
    do
    {
      return;
      this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.sendEmptyMessageDelayed(994, 0L);
    } while (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.b);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText("0%");
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847582);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131364830));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131364829));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = a(2131371694);
    this.jdField_b_of_type_AndroidViewView = a(2131371689);
    this.jdField_c_of_type_AndroidViewView = a(2131371697);
    a(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131363820));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)a(2131365802));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131365801));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = a(this.jdField_a_of_type_Int, this.jdField_b_of_type_AndroidViewViewGroup, this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131378116));
    Object localObject;
    if ((this.jdField_a_of_type_Int & 0x400) != 0)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject = (wur)jdField_a_of_type_AndroidUtilSparseArray.get(1024);
    }
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(a(), ((wur)localObject).b);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(localBitmap));
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(((wur)localObject).a);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView = a(2131377349);
      if ((this.jdField_a_of_type_Int & 0x400000) != 0)
      {
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131362594));
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131362598));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131362595));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131362596));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131362597));
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
        wta.a("pub_control", "exp_entry", 0, 0, new String[0]);
        if (!(this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeGifSource)) {
          break label695;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131704086));
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alpo.a(2131704276));
        localObject = this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle;
        if ((localObject != null) && (((Bundle)localObject).getInt("video_redbag_get", 0) == LocalMediaInfo.REDBAG_TYPE_GET))
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131363825));
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          wsv.d("Q.qqstory.record.EditVideoButton", "VideoRedbag, editVideoButton show redbag tips");
        }
        a(wti.class, this);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        wsv.e("Q.qqstory.record.EditVideoButton", "decodeResource OutOfMemoryError : %s", new Object[] { ((wur)localObject).a });
        continue;
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        continue;
        label683:
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        continue;
        label695:
        if ((this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131704264));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alpo.a(2131704096));
        }
        else if (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.c())
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131704231));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alpo.a(2131704314));
        }
        else if ((this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.d()) && (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131704181));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alpo.a(2131704250));
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131704310));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alpo.a(2131704126));
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
      wtb.b("0X80080E5", wtb.jdField_a_of_type_Int);
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
  
  public void a(int paramInt, @NonNull xgs paramxgs)
  {
    super.a(paramInt, paramxgs);
  }
  
  void a(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      int i = this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a();
      if ((i != 101) && (i != 104)) {
        break label56;
      }
      paramView.setText(alpo.a(2131704279));
      paramView.setContentDescription(alpo.a(2131704274));
    }
    label56:
    do
    {
      return;
      if ((this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 2))
      {
        paramView.setText(alpo.a(2131704256));
        paramView.setContentDescription(alpo.a(2131704109));
        return;
      }
      if (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)
      {
        String str = this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_publish_text");
        if (!TextUtils.isEmpty(str))
        {
          paramView.setText(str);
          paramView.setContentDescription(str);
          return;
        }
        paramView.setText(alpo.a(2131704094));
        paramView.setContentDescription(alpo.a(2131704266));
        return;
      }
      if ((this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 6))
      {
        paramView.setText(alpo.a(2131704122));
        paramView.setContentDescription(alpo.a(2131704306));
        return;
      }
    } while (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 8);
    paramView.setText(alpo.a(2131704111));
    paramView.setContentDescription(alpo.a(2131704281));
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847150);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847151);
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
        wyg.b(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
        if ((this.jdField_a_of_type_Int & 0x4000) != 0) {
          wyg.b(this.jdField_a_of_type_AndroidViewView, paramBoolean3);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Wwe.a(Message.obtain(null, 11, Long.valueOf(this.jdField_c_of_type_Long)));
        if (!paramBoolean1) {
          break;
        }
        i = 0;
        while (i < this.jdField_b_of_type_AndroidUtilSparseArray.size())
        {
          ((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i)).setVisibility(0);
          i += 1;
        }
        wyg.a(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
        if ((this.jdField_a_of_type_Int & 0x4000) != 0) {
          wyg.a(this.jdField_a_of_type_AndroidViewView, paramBoolean3);
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
        wsv.b("Q.qqstory.record.EditVideoButton", "perform button click %s", localImageView);
        localImageView.performClick();
      }
      else
      {
        wsv.d("Q.qqstory.record.EditVideoButton", "can not find view performing click by enable mask %d", new Object[] { Integer.valueOf(paramMessage.arg1) });
      }
    }
  }
  
  public void ad_()
  {
    super.ad_();
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
      if (this.jdField_c_of_type_Long <= System.currentTimeMillis()) {}
    }
    else
    {
      wsv.d("Q.qqstory.record.EditVideoButton", "you click button too fast, ignore it !");
      return;
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    Object localObject = jdField_a_of_type_ArrayOfInt;
    int k = localObject.length;
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        break label1448;
      }
      if (localObject[i] == j)
      {
        i = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(j);
        wsv.d("Q.qqstory.record.EditVideoButton", "onClick : mask=%d, view=%s", new Object[] { Integer.valueOf(i), paramView });
        wtb.a(this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007822");
        j = this.jdField_a_of_type_Wwe.a(Message.obtain(null, 1, i, 0, paramView));
        if (j > 0)
        {
          wsv.c("Q.qqstory.record.EditVideoButton", "%d parts intercept the click event : " + j);
          return;
        }
        this.jdField_a_of_type_Wwe.p();
        switch (i)
        {
        default: 
          return;
        case 1: 
          bool = this.jdField_a_of_type_Wwe.b(5);
          if (this.jdField_a_of_type_Wwe.a())
          {
            paramView = "2";
            if (!bool) {
              break label641;
            }
            localObject = "1";
            wta.a("video_edit", "clk_graffiti", 0, 0, new String[] { paramView, "", localObject, "" });
            wtb.a(this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007821");
            this.jdField_a_of_type_Wwe.a("608", "10", "0", true);
            wtb.b("0X80075C4", wtb.jdField_a_of_type_Int);
            wtb.a(this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X800781E");
            if ((this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3))
            {
              if (!this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) {
                break label649;
              }
              LpReportInfo_pf00064.allReport(628, 3);
            }
          }
        case 32: 
          for (;;)
          {
            if (!this.jdField_a_of_type_Wwe.a(7)) {
              break label660;
            }
            this.jdField_a_of_type_Wwe.a(0);
            return;
            bool = this.jdField_a_of_type_Wwe.b(4);
            paramView = (uqj)((uqs)urr.a(20)).a(1);
            if (paramView.a((uqm)paramView.a()))
            {
              paramView = "2";
              if (!this.jdField_a_of_type_Wwe.a()) {
                break label618;
              }
              localObject = "2";
              if (!bool) {
                break label626;
              }
            }
            for (String str = "1";; str = "0")
            {
              wta.a("video_edit", "clk_music", 0, 0, new String[] { localObject, paramView, str, "" });
              this.jdField_a_of_type_Wwe.a(2);
              return;
              paramView = "1";
              break;
              localObject = "1";
              break label557;
            }
            paramView = "1";
            break;
            localObject = "0";
            break label339;
            LpReportInfo_pf00064.allReport(615, 1, 1);
          }
          this.jdField_a_of_type_Wwe.a(7);
          return;
        case 4: 
          wtb.b("0X80075C6", wtb.jdField_a_of_type_Int);
          wtb.a(this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007820");
          if ((this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3))
          {
            if (!this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) {
              break label751;
            }
            LpReportInfo_pf00064.allReport(628, 2);
          }
          for (;;)
          {
            this.jdField_a_of_type_Wwe.a(5, Boolean.TRUE);
            return;
            LpReportInfo_pf00064.allReport(615, 3, 1);
          }
        case 8: 
          bool = this.jdField_a_of_type_Wwe.b(3);
          if (this.jdField_a_of_type_Wwe.a())
          {
            paramView = "2";
            if (!bool) {
              break label946;
            }
            localObject = "1";
            wta.a("video_edit", "add_face", 0, 0, new String[] { paramView, "", localObject, "" });
            wtb.b("0X80075C7", wtb.jdField_a_of_type_Int);
            if ((this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3))
            {
              if (!this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) {
                break label954;
              }
              LpReportInfo_pf00064.allReport(628, 4);
            }
          }
          for (;;)
          {
            this.jdField_a_of_type_Wwe.a("608", "11", "0", true);
            wtb.a(this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X800781D");
            if (!this.jdField_a_of_type_Wwe.a(6)) {
              break label965;
            }
            this.jdField_a_of_type_Wwe.a(0);
            return;
            paramView = "1";
            break;
            localObject = "0";
            break label796;
            LpReportInfo_pf00064.allReport(615, 4, 1);
          }
          ((xak)urr.a(8)).a(false);
          this.jdField_a_of_type_Wwe.a(6);
          return;
        case 128: 
          localObject = this.jdField_a_of_type_Wwe;
          if (this.jdField_a_of_type_Wwe.a()) {}
          for (paramView = "2";; paramView = "1")
          {
            ((wwe)localObject).a("add_tag", 0, 0, new String[] { paramView });
            this.jdField_a_of_type_Wwe.a(1);
            return;
          }
        case 16: 
          wtb.b("0X80075C8", wtb.jdField_a_of_type_Int);
          if ((this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
            LpReportInfo_pf00064.allReport(615, 5, 1);
          }
          this.jdField_a_of_type_Wwe.s();
          return;
        case 2: 
          wtb.b("0X80075C5", wtb.jdField_a_of_type_Int);
          if ((this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
            LpReportInfo_pf00064.allReport(615, 2, 1);
          }
          this.jdField_a_of_type_Wwe.q();
          return;
        case 131072: 
          wta.a("video_edit", "share_to_group", 0, 0, new String[0]);
          wta.a("story_grp", "clk_share_grp", 0, 0, new String[] { "", "", "", "" });
          this.jdField_a_of_type_Wwe.a(25);
          return;
        case 1024: 
          this.jdField_a_of_type_Wwe.a(19);
          return;
        case 4096: 
          this.jdField_a_of_type_Wwe.a(21);
          if ((this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 3)) {
            break;
          }
          if (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e())
          {
            LpReportInfo_pf00064.allReport(628, 5, 1);
            return;
          }
          LpReportInfo_pf00064.allReport(615, 5, 1);
          return;
        case 8192: 
          if (!this.jdField_a_of_type_Boolean) {
            bool = true;
          }
          this.jdField_a_of_type_Boolean = bool;
          this.jdField_a_of_type_Wwe.a(this.jdField_a_of_type_Boolean);
          paramView = (ImageView)paramView;
          localObject = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(32);
          if (this.jdField_a_of_type_Boolean)
          {
            paramView.setImageResource(2130846011);
            if (localObject == null) {
              break;
            }
            ((ImageView)localObject).setColorFilter(a().getColor(2131166394), PorterDuff.Mode.MULTIPLY);
            return;
          }
          paramView.setImageResource(2130846010);
          if (localObject == null) {
            break;
          }
          ((ImageView)localObject).clearColorFilter();
          return;
        case 262144: 
          label339:
          label618:
          label626:
          if ((this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
            LpReportInfo_pf00064.allReport(615, 11);
          }
          label557:
          label751:
          if (this.jdField_a_of_type_Wwe.b == 26)
          {
            this.jdField_a_of_type_Wwe.a(0);
            return;
          }
          label641:
          label649:
          label660:
          label796:
          label946:
          label954:
          label965:
          this.jdField_a_of_type_Wwe.a(26);
          return;
        }
      }
      i += 1;
    }
    switch (j)
    {
    default: 
      return;
    case 2131362594: 
      g();
      return;
    case 2131364829: 
      if ((this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.allReport(615, 8);
      }
      this.jdField_a_of_type_Wwe.e();
      return;
    case 2131364830: 
      if ((this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.allReport(615, 10);
      }
      for (;;)
      {
        this.jdField_a_of_type_Wwe.d();
        return;
        if (((this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 9)) && (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 10)) {
          azmj.b(null, "dc00899", "Grp_tribe", "", "video_edit", "Clk_left", 0, 0, "", "", "", "");
        }
      }
    case 2131371689: 
      if (this.jdField_a_of_type_Wwe.a(22))
      {
        this.jdField_a_of_type_Wwe.a(0);
        return;
      }
      this.jdField_a_of_type_Wwe.a(22);
      return;
    case 2131378116: 
      label1448:
      if ((this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.allReport(615, 9);
      }
      this.jdField_a_of_type_Wwe.a(19);
      return;
    }
    this.jdField_a_of_type_Wwe.a(28);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wuq
 * JD-Core Version:    0.7.0.1
 */