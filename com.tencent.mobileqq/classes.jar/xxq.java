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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

@TargetApi(11)
public class xxq
  extends xzb
  implements View.OnClickListener, xwi
{
  public static final SparseArray<xxr> a;
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
    jdField_a_of_type_ArrayOfInt = new int[] { 2131365865, 2131365866, 2131365868, 2131365869, 2131365870, 2131365871, 2131365872, 2131365873, 2131365874, 2131365875, 2131365867 };
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(32, new xxr(32, 2130846567, amtj.a(2131702958)));
    jdField_a_of_type_AndroidUtilSparseArray.put(1, new xxr(1, 2130846482, amtj.a(2131702959)));
    jdField_a_of_type_AndroidUtilSparseArray.put(4, new xxr(4, 2130846776, amtj.a(2131702883)));
    jdField_a_of_type_AndroidUtilSparseArray.put(8, new xxr(8, 2130846423, amtj.a(2131703017)));
    jdField_a_of_type_AndroidUtilSparseArray.put(128, new xxr(128, 2130846610, amtj.a(2131702977)));
    jdField_a_of_type_AndroidUtilSparseArray.put(16, new xxr(16, 2130846312, amtj.a(2131702902)));
    jdField_a_of_type_AndroidUtilSparseArray.put(2, new xxr(2, 2130846408, amtj.a(2131702851)));
    jdField_a_of_type_AndroidUtilSparseArray.put(131072, new xxr(131072, 2130846749, amtj.a(2131702935)));
    jdField_a_of_type_AndroidUtilSparseArray.put(1024, new xxr(1024, 2130845823, amtj.a(2131702863)));
    jdField_a_of_type_AndroidUtilSparseArray.put(4096, new xxr(4096, 2130846463, "GIF快慢"));
    jdField_a_of_type_AndroidUtilSparseArray.put(8192, new xxr(8192, 2130846447, "生成GIF"));
    jdField_a_of_type_AndroidUtilSparseArray.put(262144, new xxr(262144, 2130846477, "跳转到P图"));
  }
  
  public xxq(@NonNull xzd paramxzd, int paramInt)
  {
    super(paramxzd);
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
      paramImageView.setColorFilter(a().getColor(2131166491), PorterDuff.Mode.MULTIPLY);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramImageView = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(32);
      if (paramImageView != null) {
        paramImageView.setColorFilter(a().getColor(2131166493), PorterDuff.Mode.MULTIPLY);
      }
    }
  }
  
  private void a(View... paramVarArgs)
  {
    float f1 = FontSettingManager.getFontLevel();
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
      xvv.b("Q.qqstory.record.EditVideoButton", "new size : " + localView.toString() + ", height=" + localLayoutParams.height + ", width=" + localLayoutParams.width);
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
      xvv.a("Q.qqstory.record.EditVideoButton", "initEditButtons, needButtonCount = %d", Integer.valueOf(paramInt));
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
            localObject = (xxr)jdField_a_of_type_AndroidUtilSparseArray.get(i1);
          }
          try
          {
            paramViewGroup.setImageDrawable(new BitmapDrawable(BitmapFactory.decodeResource(a(), ((xxr)localObject).b)));
            paramViewGroup.setContentDescription(((xxr)localObject).a);
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
              xvv.e("Q.qqstory.record.EditVideoButton", "decodeResource OutOfMemoryError : %s", new Object[] { ((xxr)localObject).a });
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
        g();
      }
      return arrayOfImageView;
    }
  }
  
  private void g()
  {
    int i = this.jdField_a_of_type_Yan.a().getResources().getDisplayMetrics().widthPixels - UIUtils.dip2px(this.jdField_a_of_type_Yan.a(), 72.0F);
    int j = UIUtils.dip2px(this.jdField_a_of_type_Yan.a(), 48.0F);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getLayoutParams();
    if ((i >= j * 5) && (i < j * 6)) {}
    for (localLayoutParams.width = ((int)(j * 4.5D));; localLayoutParams.width = ((int)(j * 3.5D))) {
      do
      {
        xvv.b("Q.qqstory.record.EditVideoButton", "new size : " + this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.toString() + ", width=" + localLayoutParams.width);
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setLayoutParams(localLayoutParams);
        return;
      } while ((i < j * 4) || (i >= j * 5));
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.isEditLocalGif()) || (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.isEditTakeGif()))
    {
      if (!this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.d) {
        break label79;
      }
      a(true, false);
      this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.removeMessages(994);
      this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.sendEmptyMessage(995);
    }
    label79:
    do
    {
      return;
      this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.sendEmptyMessageDelayed(994, 0L);
    } while (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.b);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText("0%");
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848045);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
  }
  
  public void Q_()
  {
    super.Q_();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131365137));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131365136));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = a(2131372369);
    this.jdField_b_of_type_AndroidViewView = a(2131372364);
    this.jdField_c_of_type_AndroidViewView = a(2131372372);
    a(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364078));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)a(2131366126));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131366125));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = a(this.jdField_a_of_type_Int, this.jdField_b_of_type_AndroidViewViewGroup, this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131378952));
    Object localObject;
    if ((this.jdField_a_of_type_Int & 0x400) != 0)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject = (xxr)jdField_a_of_type_AndroidUtilSparseArray.get(1024);
    }
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(a(), ((xxr)localObject).b);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(localBitmap));
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(((xxr)localObject).a);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView = a(2131378151);
      if ((this.jdField_a_of_type_Int & 0x400000) != 0)
      {
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131362723));
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131362727));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131362724));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131362725));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131362726));
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
        xwa.a("pub_control", "exp_entry", 0, 0, new String[0]);
        if (!(this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource instanceof EditTakeGifSource)) {
          break label695;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131702837));
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(amtj.a(2131703024));
        localObject = this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mExtra;
        if ((localObject != null) && (((Bundle)localObject).getInt("video_redbag_get", 0) == LocalMediaInfo.REDBAG_TYPE_GET))
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131364082));
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          xvv.d("Q.qqstory.record.EditVideoButton", "VideoRedbag, editVideoButton show redbag tips");
        }
        a(xwi.class, this);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        xvv.e("Q.qqstory.record.EditVideoButton", "decodeResource OutOfMemoryError : %s", new Object[] { ((xxr)localObject).a });
        continue;
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        continue;
        label683:
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        continue;
        label695:
        if ((this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource instanceof EditLocalGifSource))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131703012));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(amtj.a(2131702847));
        }
        else if (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.isEditCamera())
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131702979));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(amtj.a(2131703061));
        }
        else if ((this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.isEditLocal()) && (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 1))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131702931));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(amtj.a(2131702998));
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131703057));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(amtj.a(2131702877));
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
      xwb.b("0X80080E5", xwb.jdField_a_of_type_Int);
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
  
  public void a(int paramInt, @NonNull yjh paramyjh)
  {
    super.a(paramInt, paramyjh);
  }
  
  void a(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getBussinessId() != 104) {
        break label48;
      }
      paramView.setText(amtj.a(2131703027));
      paramView.setContentDescription(amtj.a(2131703022));
    }
    label48:
    do
    {
      return;
      if ((this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 1) || (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 2))
      {
        paramView.setText(amtj.a(2131703004));
        paramView.setContentDescription(amtj.a(2131702860));
        return;
      }
      if (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 3)
      {
        String str = this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getStringExtra("extra_publish_text");
        if (!TextUtils.isEmpty(str))
        {
          paramView.setText(str);
          paramView.setContentDescription(str);
          return;
        }
        paramView.setText(amtj.a(2131702845));
        paramView.setContentDescription(amtj.a(2131703014));
        return;
      }
      if ((this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 5) || (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 6))
      {
        paramView.setText(amtj.a(2131702873));
        paramView.setContentDescription(amtj.a(2131703053));
        return;
      }
    } while (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId != 8);
    paramView.setText(amtj.a(2131702862));
    paramView.setContentDescription(amtj.a(2131703029));
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847611);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847612);
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
        ybe.b(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
        if ((this.jdField_a_of_type_Int & 0x4000) != 0) {
          ybe.b(this.jdField_a_of_type_AndroidViewView, paramBoolean3);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Xzd.a(Message.obtain(null, 11, Long.valueOf(this.jdField_c_of_type_Long)));
        if (!paramBoolean1) {
          break;
        }
        i = 0;
        while (i < this.jdField_b_of_type_AndroidUtilSparseArray.size())
        {
          ((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i)).setVisibility(0);
          i += 1;
        }
        ybe.a(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
        if ((this.jdField_a_of_type_Int & 0x4000) != 0) {
          ybe.a(this.jdField_a_of_type_AndroidViewView, paramBoolean3);
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
        xvv.b("Q.qqstory.record.EditVideoButton", "perform button click %s", localImageView);
        localImageView.performClick();
      }
      else
      {
        xvv.d("Q.qqstory.record.EditVideoButton", "can not find view performing click by enable mask %d", new Object[] { Integer.valueOf(paramMessage.arg1) });
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
      xvv.d("Q.qqstory.record.EditVideoButton", "you click button too fast, ignore it !");
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
          break label1434;
        }
        if (localObject1[i] == j)
        {
          i = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(j);
          xvv.d("Q.qqstory.record.EditVideoButton", "onClick : mask=%d, view=%s", new Object[] { Integer.valueOf(i), paramView });
          j = this.jdField_a_of_type_Xzd.a(Message.obtain(null, 1, i, 0, paramView));
          if (j > 0)
          {
            xvv.c("Q.qqstory.record.EditVideoButton", "%d parts intercept the click event : " + j);
            break;
          }
          this.jdField_a_of_type_Xzd.p();
          switch (i)
          {
          }
          for (;;)
          {
            break;
            bool = this.jdField_a_of_type_Xzd.b(4);
            localObject1 = (vtp)((vty)vux.a(20)).a(1);
            if (((vtp)localObject1).a((vts)((vtp)localObject1).a()))
            {
              localObject1 = "2";
              label351:
              if (!this.jdField_a_of_type_Xzd.a()) {
                break label431;
              }
              localObject2 = "2";
              label366:
              if (!bool) {
                break label439;
              }
            }
            label431:
            label439:
            for (String str = "1";; str = "0")
            {
              xwa.a("video_edit", "clk_music", 0, 0, new String[] { localObject2, localObject1, str, "" });
              this.jdField_a_of_type_Xzd.a(2);
              break;
              localObject1 = "1";
              break label351;
              localObject2 = "1";
              break label366;
            }
            bool = this.jdField_a_of_type_Xzd.b(5);
            if (this.jdField_a_of_type_Xzd.a())
            {
              localObject1 = "2";
              label472:
              if (!bool) {
                break label620;
              }
              localObject2 = "1";
              label482:
              xwa.a("video_edit", "clk_graffiti", 0, 0, new String[] { localObject1, "", localObject2, "" });
              this.jdField_a_of_type_Xzd.a("608", "10", "0", true);
              xwb.b("0X80075C4", xwb.jdField_a_of_type_Int);
              if ((this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 3))
              {
                if (!this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.isEditLocalGif()) {
                  break label628;
                }
                LpReportInfo_pf00064.allReport(628, 3);
              }
            }
            for (;;)
            {
              if (!this.jdField_a_of_type_Xzd.a(7)) {
                break label639;
              }
              this.jdField_a_of_type_Xzd.a(0);
              break;
              localObject1 = "1";
              break label472;
              label620:
              localObject2 = "0";
              break label482;
              label628:
              LpReportInfo_pf00064.allReport(615, 1, 1);
            }
            label639:
            this.jdField_a_of_type_Xzd.a(7);
            continue;
            xwb.b("0X80075C6", xwb.jdField_a_of_type_Int);
            if ((this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 3))
            {
              if (!this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.isEditLocalGif()) {
                break label718;
              }
              LpReportInfo_pf00064.allReport(628, 2);
            }
            for (;;)
            {
              this.jdField_a_of_type_Xzd.a(5, Boolean.TRUE);
              break;
              label718:
              LpReportInfo_pf00064.allReport(615, 3, 1);
            }
            bool = this.jdField_a_of_type_Xzd.b(3);
            if (this.jdField_a_of_type_Xzd.a())
            {
              localObject1 = "2";
              label754:
              if (!bool) {
                break label902;
              }
              localObject2 = "1";
              label764:
              xwa.a("video_edit", "add_face", 0, 0, new String[] { localObject1, "", localObject2, "" });
              xwb.b("0X80075C7", xwb.jdField_a_of_type_Int);
              if ((this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 3))
              {
                if (!this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.isEditLocalGif()) {
                  break label910;
                }
                LpReportInfo_pf00064.allReport(628, 4);
              }
            }
            for (;;)
            {
              this.jdField_a_of_type_Xzd.a("608", "11", "0", true);
              if (!this.jdField_a_of_type_Xzd.a(6)) {
                break label921;
              }
              this.jdField_a_of_type_Xzd.a(0);
              break;
              localObject1 = "1";
              break label754;
              label902:
              localObject2 = "0";
              break label764;
              label910:
              LpReportInfo_pf00064.allReport(615, 4, 1);
            }
            label921:
            ((ydh)vux.a(8)).a(false);
            this.jdField_a_of_type_Xzd.a(6);
            continue;
            Object localObject2 = this.jdField_a_of_type_Xzd;
            if (this.jdField_a_of_type_Xzd.a()) {}
            for (localObject1 = "2";; localObject1 = "1")
            {
              ((xzd)localObject2).a("add_tag", 0, 0, new String[] { localObject1 });
              this.jdField_a_of_type_Xzd.a(1);
              break;
            }
            xwb.b("0X80075C8", xwb.jdField_a_of_type_Int);
            if ((this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 3)) {
              LpReportInfo_pf00064.allReport(615, 5, 1);
            }
            this.jdField_a_of_type_Xzd.s();
            continue;
            xwb.b("0X80075C5", xwb.jdField_a_of_type_Int);
            if ((this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 3)) {
              LpReportInfo_pf00064.allReport(615, 2, 1);
            }
            this.jdField_a_of_type_Xzd.q();
            continue;
            xwa.a("video_edit", "share_to_group", 0, 0, new String[0]);
            xwa.a("story_grp", "clk_share_grp", 0, 0, new String[] { "", "", "", "" });
            this.jdField_a_of_type_Xzd.a(25);
            continue;
            this.jdField_a_of_type_Xzd.a(19);
            continue;
            this.jdField_a_of_type_Xzd.a(21);
            if ((this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 3)) {
              if (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.isEditLocalGif())
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
                this.jdField_a_of_type_Xzd.a(this.jdField_a_of_type_Boolean);
                localObject1 = (ImageView)paramView;
                localObject2 = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(32);
                if (this.jdField_a_of_type_Boolean)
                {
                  ((ImageView)localObject1).setImageResource(2130846448);
                  if (localObject2 != null) {
                    ((ImageView)localObject2).setColorFilter(a().getColor(2131166493), PorterDuff.Mode.MULTIPLY);
                  }
                }
                else
                {
                  ((ImageView)localObject1).setImageResource(2130846447);
                  if (localObject2 != null)
                  {
                    ((ImageView)localObject2).clearColorFilter();
                    continue;
                    if ((this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 3)) {
                      LpReportInfo_pf00064.allReport(615, 11);
                    }
                    if (this.jdField_a_of_type_Xzd.b == 26) {
                      this.jdField_a_of_type_Xzd.a(0);
                    } else {
                      this.jdField_a_of_type_Xzd.a(26);
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
      case 2131362723: 
        h();
        break;
      case 2131365136: 
        if ((this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 3)) {
          LpReportInfo_pf00064.allReport(615, 8);
        }
        this.jdField_a_of_type_Xzd.e();
        break;
      case 2131365137: 
        if ((this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 3)) {
          LpReportInfo_pf00064.allReport(615, 10);
        }
        for (;;)
        {
          this.jdField_a_of_type_Xzd.d();
          break;
          if (((this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId != 9)) && (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 10)) {
            bcef.b(null, "dc00899", "Grp_tribe", "", "video_edit", "Clk_left", 0, 0, "", "", "", "");
          }
        }
      case 2131372364: 
        if (this.jdField_a_of_type_Xzd.a(22)) {
          this.jdField_a_of_type_Xzd.a(0);
        } else {
          this.jdField_a_of_type_Xzd.a(22);
        }
        break;
      case 2131378952: 
        if ((this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 3)) {
          LpReportInfo_pf00064.allReport(615, 9);
        }
        this.jdField_a_of_type_Xzd.a(19);
        break;
      case 2131378151: 
        label1434:
        this.jdField_a_of_type_Xzd.a(28);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxq
 * JD-Core Version:    0.7.0.1
 */