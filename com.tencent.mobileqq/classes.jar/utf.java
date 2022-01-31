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
public class utf
  extends uur
  implements View.OnClickListener, urx
{
  public static final SparseArray<utg> a;
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
    jdField_a_of_type_ArrayOfInt = new int[] { 2131299891, 2131299892, 2131299896, 2131299897, 2131299898, 2131299899, 2131299900, 2131299901, 2131299902, 2131299903, 2131299893 };
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(32, new utg(32, 2130845562, ajjy.a(2131638042)));
    jdField_a_of_type_AndroidUtilSparseArray.put(1, new utg(1, 2130845477, ajjy.a(2131638043)));
    jdField_a_of_type_AndroidUtilSparseArray.put(4, new utg(4, 2130845774, ajjy.a(2131637964)));
    jdField_a_of_type_AndroidUtilSparseArray.put(8, new utg(8, 2130845417, ajjy.a(2131638101)));
    jdField_a_of_type_AndroidUtilSparseArray.put(128, new utg(128, 2130845605, ajjy.a(2131638061)));
    jdField_a_of_type_AndroidUtilSparseArray.put(16, new utg(16, 2130845306, ajjy.a(2131637983)));
    jdField_a_of_type_AndroidUtilSparseArray.put(2, new utg(2, 2130845402, ajjy.a(2131637932)));
    jdField_a_of_type_AndroidUtilSparseArray.put(131072, new utg(131072, 2130845746, ajjy.a(2131638017)));
    jdField_a_of_type_AndroidUtilSparseArray.put(1024, new utg(1024, 2130844985, ajjy.a(2131637944)));
    jdField_a_of_type_AndroidUtilSparseArray.put(4096, new utg(4096, 2130845458, "GIF快慢"));
    jdField_a_of_type_AndroidUtilSparseArray.put(8192, new utg(8192, 2130845441, "生成GIF"));
    jdField_a_of_type_AndroidUtilSparseArray.put(262144, new utg(262144, 2130845472, "跳转到P图"));
  }
  
  public utf(@NonNull uut paramuut, int paramInt)
  {
    super(paramuut);
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
      paramImageView.setColorFilter(a().getColor(2131100752), PorterDuff.Mode.MULTIPLY);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramImageView = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(32);
      if (paramImageView != null) {
        paramImageView.setColorFilter(a().getColor(2131100754), PorterDuff.Mode.MULTIPLY);
      }
    }
  }
  
  private void a(View... paramVarArgs)
  {
    float f1 = ajia.a();
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
      urk.b("Q.qqstory.record.EditVideoButton", "new size : " + localView.toString() + ", height=" + localLayoutParams.height + ", width=" + localLayoutParams.width);
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
      urk.a("Q.qqstory.record.EditVideoButton", "initEditButtons, needButtonCount = %d", Integer.valueOf(paramInt));
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
            localObject = (utg)jdField_a_of_type_AndroidUtilSparseArray.get(i1);
          }
          try
          {
            paramViewGroup.setImageDrawable(new BitmapDrawable(BitmapFactory.decodeResource(a(), ((utg)localObject).b)));
            paramViewGroup.setContentDescription(((utg)localObject).a);
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
              urk.e("Q.qqstory.record.EditVideoButton", "decodeResource OutOfMemoryError : %s", new Object[] { ((utg)localObject).a });
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
    int i = this.jdField_a_of_type_Uwe.a().getResources().getDisplayMetrics().widthPixels - vms.a(this.jdField_a_of_type_Uwe.a(), 72.0F);
    int j = vms.a(this.jdField_a_of_type_Uwe.a(), 48.0F);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getLayoutParams();
    if ((i >= j * 5) && (i < j * 6)) {}
    for (localLayoutParams.width = ((int)(j * 4.5D));; localLayoutParams.width = ((int)(j * 3.5D))) {
      do
      {
        urk.b("Q.qqstory.record.EditVideoButton", "new size : " + this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.toString() + ", width=" + localLayoutParams.width);
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setLayoutParams(localLayoutParams);
        return;
      } while ((i < j * 4) || (i >= j * 5));
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) || (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.f()))
    {
      if (!this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.d) {
        break label79;
      }
      a(true, false);
      this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.removeMessages(994);
      this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.sendEmptyMessage(995);
    }
    label79:
    do
    {
      return;
      this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.sendEmptyMessageDelayed(994, 0L);
    } while (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.b);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText("0%");
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847015);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
  }
  
  public void X_()
  {
    super.X_();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131299189));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131299188));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = a(2131305682);
    this.jdField_b_of_type_AndroidViewView = a(2131305677);
    this.jdField_c_of_type_AndroidViewView = a(2131305685);
    a(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131298210));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)a(2131300122));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131300121));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = a(this.jdField_a_of_type_Int, this.jdField_b_of_type_AndroidViewViewGroup, this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131311766));
    Object localObject;
    if ((this.jdField_a_of_type_Int & 0x400) != 0)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject = (utg)jdField_a_of_type_AndroidUtilSparseArray.get(1024);
    }
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(a(), ((utg)localObject).b);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(localBitmap));
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(((utg)localObject).a);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView = a(2131311024);
      if ((this.jdField_a_of_type_Int & 0x400000) != 0)
      {
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131297028));
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131297032));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131297029));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131297030));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131297031));
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
        urp.a("pub_control", "exp_entry", 0, 0, new String[0]);
        if (!(this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeGifSource)) {
          break label695;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131637918));
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131638108));
        localObject = this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle;
        if ((localObject != null) && (((Bundle)localObject).getInt("video_redbag_get", 0) == LocalMediaInfo.REDBAG_TYPE_GET))
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131298215));
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          urk.d("Q.qqstory.record.EditVideoButton", "VideoRedbag, editVideoButton show redbag tips");
        }
        a(urx.class, this);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        urk.e("Q.qqstory.record.EditVideoButton", "decodeResource OutOfMemoryError : %s", new Object[] { ((utg)localObject).a });
        continue;
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        continue;
        label683:
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        continue;
        label695:
        if ((this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131638096));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131637928));
        }
        else if (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.c())
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131638063));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131638146));
        }
        else if ((this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.d()) && (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131638013));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131638082));
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131638142));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131637958));
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
      urq.b("0X80080E5", urq.jdField_a_of_type_Int);
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
  
  public void a(int paramInt, @NonNull vfh paramvfh)
  {
    super.a(paramInt, paramvfh);
  }
  
  void a(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      int i = this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a();
      if ((i != 101) && (i != 104)) {
        break label56;
      }
      paramView.setText(ajjy.a(2131638111));
      paramView.setContentDescription(ajjy.a(2131638106));
    }
    label56:
    do
    {
      return;
      if ((this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 2))
      {
        paramView.setText(ajjy.a(2131638088));
        paramView.setContentDescription(ajjy.a(2131637941));
        return;
      }
      if (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)
      {
        String str = this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_publish_text");
        if (!TextUtils.isEmpty(str))
        {
          paramView.setText(str);
          paramView.setContentDescription(str);
          return;
        }
        paramView.setText(ajjy.a(2131637926));
        paramView.setContentDescription(ajjy.a(2131638098));
        return;
      }
      if ((this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 6))
      {
        paramView.setText(ajjy.a(2131637954));
        paramView.setContentDescription(ajjy.a(2131638138));
        return;
      }
    } while (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 8);
    paramView.setText(ajjy.a(2131637943));
    paramView.setContentDescription(ajjy.a(2131638113));
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846589);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846590);
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
        uwv.b(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
        if ((this.jdField_a_of_type_Int & 0x4000) != 0) {
          uwv.b(this.jdField_a_of_type_AndroidViewView, paramBoolean3);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Uut.a(Message.obtain(null, 11, Long.valueOf(this.jdField_c_of_type_Long)));
        if (!paramBoolean1) {
          break;
        }
        i = 0;
        while (i < this.jdField_b_of_type_AndroidUtilSparseArray.size())
        {
          ((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i)).setVisibility(0);
          i += 1;
        }
        uwv.a(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
        if ((this.jdField_a_of_type_Int & 0x4000) != 0) {
          uwv.a(this.jdField_a_of_type_AndroidViewView, paramBoolean3);
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
        urk.b("Q.qqstory.record.EditVideoButton", "perform button click %s", localImageView);
        localImageView.performClick();
      }
      else
      {
        urk.d("Q.qqstory.record.EditVideoButton", "can not find view performing click by enable mask %d", new Object[] { Integer.valueOf(paramMessage.arg1) });
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
      if (this.jdField_c_of_type_Long <= System.currentTimeMillis()) {}
    }
    else
    {
      urk.d("Q.qqstory.record.EditVideoButton", "you click button too fast, ignore it !");
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
        urk.d("Q.qqstory.record.EditVideoButton", "onClick : mask=%d, view=%s", new Object[] { Integer.valueOf(i), paramView });
        urq.a(this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007822");
        j = this.jdField_a_of_type_Uut.a(Message.obtain(null, 1, i, 0, paramView));
        if (j > 0)
        {
          urk.c("Q.qqstory.record.EditVideoButton", "%d parts intercept the click event : " + j);
          return;
        }
        this.jdField_a_of_type_Uut.p();
        switch (i)
        {
        default: 
          return;
        case 1: 
          bool = this.jdField_a_of_type_Uut.b(5);
          if (this.jdField_a_of_type_Uut.a())
          {
            paramView = "2";
            if (!bool) {
              break label641;
            }
            localObject = "1";
            urp.a("video_edit", "clk_graffiti", 0, 0, new String[] { paramView, "", localObject, "" });
            urq.a(this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007821");
            this.jdField_a_of_type_Uut.a("608", "10", "0", true);
            urq.b("0X80075C4", urq.jdField_a_of_type_Int);
            urq.a(this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X800781E");
            if ((this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3))
            {
              if (!this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) {
                break label649;
              }
              LpReportInfo_pf00064.allReport(628, 3);
            }
          }
        case 32: 
          for (;;)
          {
            if (!this.jdField_a_of_type_Uut.a(7)) {
              break label660;
            }
            this.jdField_a_of_type_Uut.a(0);
            return;
            bool = this.jdField_a_of_type_Uut.b(4);
            paramView = (soy)((sph)sqg.a(20)).a(1);
            if (paramView.a((spb)paramView.a()))
            {
              paramView = "2";
              if (!this.jdField_a_of_type_Uut.a()) {
                break label618;
              }
              localObject = "2";
              if (!bool) {
                break label626;
              }
            }
            for (String str = "1";; str = "0")
            {
              urp.a("video_edit", "clk_music", 0, 0, new String[] { localObject, paramView, str, "" });
              this.jdField_a_of_type_Uut.a(2);
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
          this.jdField_a_of_type_Uut.a(7);
          return;
        case 4: 
          urq.b("0X80075C6", urq.jdField_a_of_type_Int);
          urq.a(this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007820");
          if ((this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3))
          {
            if (!this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) {
              break label751;
            }
            LpReportInfo_pf00064.allReport(628, 2);
          }
          for (;;)
          {
            this.jdField_a_of_type_Uut.a(5, Boolean.TRUE);
            return;
            LpReportInfo_pf00064.allReport(615, 3, 1);
          }
        case 8: 
          bool = this.jdField_a_of_type_Uut.b(3);
          if (this.jdField_a_of_type_Uut.a())
          {
            paramView = "2";
            if (!bool) {
              break label946;
            }
            localObject = "1";
            urp.a("video_edit", "add_face", 0, 0, new String[] { paramView, "", localObject, "" });
            urq.b("0X80075C7", urq.jdField_a_of_type_Int);
            if ((this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3))
            {
              if (!this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) {
                break label954;
              }
              LpReportInfo_pf00064.allReport(628, 4);
            }
          }
          for (;;)
          {
            this.jdField_a_of_type_Uut.a("608", "11", "0", true);
            urq.a(this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X800781D");
            if (!this.jdField_a_of_type_Uut.a(6)) {
              break label965;
            }
            this.jdField_a_of_type_Uut.a(0);
            return;
            paramView = "1";
            break;
            localObject = "0";
            break label796;
            LpReportInfo_pf00064.allReport(615, 4, 1);
          }
          ((uyz)sqg.a(8)).a(false);
          this.jdField_a_of_type_Uut.a(6);
          return;
        case 128: 
          localObject = this.jdField_a_of_type_Uut;
          if (this.jdField_a_of_type_Uut.a()) {}
          for (paramView = "2";; paramView = "1")
          {
            ((uut)localObject).a("add_tag", 0, 0, new String[] { paramView });
            this.jdField_a_of_type_Uut.a(1);
            return;
          }
        case 16: 
          urq.b("0X80075C8", urq.jdField_a_of_type_Int);
          if ((this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
            LpReportInfo_pf00064.allReport(615, 5, 1);
          }
          this.jdField_a_of_type_Uut.s();
          return;
        case 2: 
          urq.b("0X80075C5", urq.jdField_a_of_type_Int);
          if ((this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
            LpReportInfo_pf00064.allReport(615, 2, 1);
          }
          this.jdField_a_of_type_Uut.q();
          return;
        case 131072: 
          urp.a("video_edit", "share_to_group", 0, 0, new String[0]);
          urp.a("story_grp", "clk_share_grp", 0, 0, new String[] { "", "", "", "" });
          this.jdField_a_of_type_Uut.a(25);
          return;
        case 1024: 
          this.jdField_a_of_type_Uut.a(19);
          return;
        case 4096: 
          this.jdField_a_of_type_Uut.a(21);
          if ((this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 3)) {
            break;
          }
          if (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e())
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
          this.jdField_a_of_type_Uut.a(this.jdField_a_of_type_Boolean);
          paramView = (ImageView)paramView;
          localObject = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(32);
          if (this.jdField_a_of_type_Boolean)
          {
            paramView.setImageResource(2130845442);
            if (localObject == null) {
              break;
            }
            ((ImageView)localObject).setColorFilter(a().getColor(2131100754), PorterDuff.Mode.MULTIPLY);
            return;
          }
          paramView.setImageResource(2130845441);
          if (localObject == null) {
            break;
          }
          ((ImageView)localObject).clearColorFilter();
          return;
        case 262144: 
          label339:
          label618:
          label626:
          if ((this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
            LpReportInfo_pf00064.allReport(615, 11);
          }
          label557:
          label751:
          if (this.jdField_a_of_type_Uut.b == 26)
          {
            this.jdField_a_of_type_Uut.a(0);
            return;
          }
          label641:
          label649:
          label660:
          label796:
          label946:
          label954:
          label965:
          this.jdField_a_of_type_Uut.a(26);
          return;
        }
      }
      i += 1;
    }
    switch (j)
    {
    default: 
      return;
    case 2131297028: 
      g();
      return;
    case 2131299188: 
      if ((this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.allReport(615, 8);
      }
      this.jdField_a_of_type_Uut.e();
      return;
    case 2131299189: 
      if ((this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.allReport(615, 10);
      }
      for (;;)
      {
        this.jdField_a_of_type_Uut.d();
        return;
        if (((this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 9)) && (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 10)) {
          awqx.b(null, "dc00899", "Grp_tribe", "", "video_edit", "Clk_left", 0, 0, "", "", "", "");
        }
      }
    case 2131305677: 
      if (this.jdField_a_of_type_Uut.a(22))
      {
        this.jdField_a_of_type_Uut.a(0);
        return;
      }
      this.jdField_a_of_type_Uut.a(22);
      return;
    case 2131311766: 
      label1448:
      if ((this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.allReport(615, 9);
      }
      this.jdField_a_of_type_Uut.a(19);
      return;
    }
    this.jdField_a_of_type_Uut.a(28);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utf
 * JD-Core Version:    0.7.0.1
 */