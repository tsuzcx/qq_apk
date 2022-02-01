import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vsx
  extends PopupWindow
  implements View.OnClickListener, Animation.AnimationListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131720137, 2130850912 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2131720136, 2130850911 };
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private vta jdField_a_of_type_Vta;
  private vtb jdField_a_of_type_Vtb;
  private vtc jdField_a_of_type_Vtc;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  
  private vsx(Activity paramActivity, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramInt1, paramInt2, paramBoolean);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    a();
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    return paramContext.getResources().getDimensionPixelSize(paramInt);
  }
  
  private static int a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int j = a(paramContext, 2131298812) * paramInt + a(paramContext, 2131298810);
    int i = j;
    if (paramBoolean) {
      i = j + (paramInt - 1) * 1;
    }
    return i;
  }
  
  private static View a(Activity paramActivity, List<vta> paramList)
  {
    View localView = LayoutInflater.from(paramActivity).inflate(2131560060, null);
    a(paramActivity, localView, paramList);
    return localView;
  }
  
  private static List<vta> a(Context paramContext, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(paramContext, jdField_a_of_type_ArrayOfInt, paramBoolean));
    localArrayList.add(a(paramContext, jdField_b_of_type_ArrayOfInt, false));
    return localArrayList;
  }
  
  public static vsx a(Activity paramActivity, boolean paramBoolean, vtb paramvtb, vtc paramvtc)
  {
    List localList = a(paramActivity, paramBoolean);
    if ((localList == null) || (localList.size() == 0)) {
      throw new IllegalArgumentException("parameter items can not be null or zero-length array.");
    }
    int i = b(paramActivity, localList.size());
    int j = ViewUtils.dip2px(145.0F);
    paramActivity = new vsx(paramActivity, a(paramActivity, localList), j, i, true);
    paramActivity.setAnimationStyle(2131755030);
    paramActivity.setBackgroundDrawable(new ColorDrawable(0));
    paramActivity.setOutsideTouchable(false);
    a(paramActivity, 1002);
    if (AppSetting.c) {
      a(paramActivity);
    }
    paramActivity.a(paramActivity.getContentView());
    paramActivity.jdField_b_of_type_Int = i;
    paramActivity.jdField_a_of_type_Vtb = paramvtb;
    paramActivity.jdField_a_of_type_Vtc = paramvtc;
    paramActivity.jdField_a_of_type_Boolean = false;
    return paramActivity;
  }
  
  private static vta a(Context paramContext, int[] paramArrayOfInt, boolean paramBoolean)
  {
    vta localvta = new vta();
    localvta.jdField_a_of_type_Int = paramArrayOfInt[0];
    localvta.jdField_a_of_type_JavaLangString = paramContext.getResources().getString(paramArrayOfInt[0]);
    localvta.jdField_b_of_type_Int = paramArrayOfInt[1];
    localvta.jdField_a_of_type_Boolean = paramBoolean;
    return localvta;
  }
  
  private void a()
  {
    int j = -1;
    int i;
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 1000;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = -3;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 40;
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
        localLayoutParams.flags |= 0x4000000;
      }
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = -1;
      i = j;
      if (this.jdField_a_of_type_AndroidAppActivity.getWindow() != null)
      {
        i = j;
        if (this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView() != null)
        {
          i = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getHeight();
          if (i > 0) {
            break label241;
          }
          i = j;
        }
      }
    }
    label241:
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = i;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131755331;
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165500));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(anvx.a(2131707794));
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(new vsy(this));
      }
      if ((AppSetting.c) && (Build.VERSION.SDK_INT >= 14)) {
        getContentView().setAccessibilityDelegate(new vsz(this));
      }
      return;
    }
  }
  
  private static void a(Context paramContext, View paramView, List<vta> paramList)
  {
    paramView = (LinearLayout)paramView.findViewById(2131370371);
    paramView.removeAllViews();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      vta localvta = (vta)paramList.next();
      View localView = LayoutInflater.from(paramContext).inflate(2131560059, null);
      ImageView localImageView1 = (ImageView)localView.findViewById(2131381554);
      ImageView localImageView2 = (ImageView)localView.findViewById(2131369438);
      TextView localTextView = (TextView)localView.findViewById(2131379995);
      localImageView2.setBackgroundResource(localvta.jdField_b_of_type_Int);
      localTextView.setText(localvta.jdField_a_of_type_JavaLangString);
      if (localvta.jdField_a_of_type_Boolean) {
        localImageView1.setVisibility(0);
      }
      for (;;)
      {
        localView.setTag(localvta);
        paramView.addView(localView);
        break;
        localImageView1.setVisibility(8);
      }
    }
  }
  
  private void a(View paramView)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof vta))) {
      paramView.setOnClickListener(this);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i));
        i += 1;
      }
    }
  }
  
  public static void a(PopupWindow paramPopupWindow)
  {
    int i = 0;
    if (!AppSetting.c) {}
    for (;;)
    {
      return;
      Method[] arrayOfMethod = PopupWindow.class.getMethods();
      int j = arrayOfMethod.length;
      while (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        if (TextUtils.equals(localMethod.getName(), "setTouchModal")) {
          try
          {
            localMethod.invoke(paramPopupWindow, new Object[] { Boolean.valueOf(false) });
            return;
          }
          catch (Exception paramPopupWindow)
          {
            paramPopupWindow.printStackTrace();
            return;
          }
        }
        i += 1;
      }
    }
  }
  
  public static void a(PopupWindow paramPopupWindow, int paramInt)
  {
    int i = 0;
    Method[] arrayOfMethod = PopupWindow.class.getMethods();
    int j = arrayOfMethod.length;
    for (;;)
    {
      Method localMethod;
      if (i < j)
      {
        localMethod = arrayOfMethod[i];
        if (!TextUtils.equals(localMethod.getName(), "setWindowLayoutType")) {}
      }
      else
      {
        try
        {
          localMethod.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
          return;
        }
        catch (Exception paramPopupWindow)
        {
          paramPopupWindow.printStackTrace();
          return;
        }
      }
      i += 1;
    }
  }
  
  public static int b(Context paramContext, int paramInt)
  {
    int i = paramInt - 2;
    if (i > 0) {}
    for (paramInt = i * AIOUtils.dp2px(52.0F, paramContext.getResources()) + AIOUtils.dp2px(62.0F, paramContext.getResources()) * 2;; paramInt = AIOUtils.dp2px(62.0F, paramContext.getResources()) * paramInt) {
      return paramInt + a(paramContext, 2131298810);
    }
  }
  
  public void dismiss()
  {
    try
    {
      if (ImmersiveUtils.a(this.jdField_a_of_type_AndroidAppActivity)) {
        ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).removeView(this.jdField_a_of_type_AndroidViewView);
      }
      while (Build.VERSION.SDK_INT >= 11)
      {
        super.dismiss();
        if ((this.jdField_a_of_type_Vtb != null) && (this.jdField_a_of_type_Vta != null)) {
          this.jdField_a_of_type_Vtb.a(this.jdField_a_of_type_Vta);
        }
        this.jdField_a_of_type_Vta = null;
        if (this.jdField_a_of_type_Vtc != null) {
          this.jdField_a_of_type_Vtc.a();
        }
        return;
        this.jdField_a_of_type_AndroidAppActivity.getWindowManager().removeView(this.jdField_a_of_type_AndroidViewView);
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("WSPopupMenuDialog", 2, localException.toString());
          }
        }
      } while ((!isShowing()) || ((this.jdField_a_of_type_AndroidViewAnimationAnimation != null) && (!this.jdField_a_of_type_AndroidViewAnimationAnimation.hasEnded())));
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130772327);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      }
      getContentView().startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WSPopupMenuDialog", 2, "onAnimationEnd");
    }
    if ((this.jdField_a_of_type_Vtb != null) && (this.jdField_a_of_type_Vta != null)) {
      this.jdField_a_of_type_Vtb.a(this.jdField_a_of_type_Vta);
    }
    this.jdField_a_of_type_Vta = null;
    if (this.jdField_a_of_type_Vtc != null) {
      this.jdField_a_of_type_Vtc.a();
    }
    super.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WSPopupMenuDialog", 2, "onAnimationStart");
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Vta = ((vta)paramView.getTag());
    dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    int j = getMaxAvailableHeight(paramView, paramInt2);
    if (j != this.jdField_a_of_type_Int)
    {
      int i = 0;
      if (j < this.jdField_b_of_type_Int) {
        i = (1 - a(this.jdField_a_of_type_AndroidAppActivity, 2131298810) + j) / (a(this.jdField_a_of_type_AndroidAppActivity, 2131298812) + 1);
      }
      if (i <= 0) {
        break label130;
      }
      setHeight(a(this.jdField_a_of_type_AndroidAppActivity, i, this.jdField_a_of_type_Boolean));
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = j;
      try
      {
        if (ImmersiveUtils.a(this.jdField_a_of_type_AndroidAppActivity)) {
          ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
        }
        for (;;)
        {
          super.showAsDropDown(paramView, paramInt1, paramInt2);
          return;
          label130:
          setHeight(this.jdField_b_of_type_Int);
          break;
          this.jdField_a_of_type_AndroidAppActivity.getWindowManager().addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("WSPopupMenuDialog", 2, localException.toString());
          }
        }
      }
    }
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (ImmersiveUtils.a(this.jdField_a_of_type_AndroidAppActivity)) {
        ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      }
      for (;;)
      {
        super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
        return;
        this.jdField_a_of_type_AndroidAppActivity.getWindowManager().addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("WSPopupMenuDialog", 2, localException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsx
 * JD-Core Version:    0.7.0.1
 */