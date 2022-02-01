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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class uwh
  extends PopupWindow
  implements View.OnClickListener, Animation.AnimationListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131719366, 2130850836 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2131719365, 2130850835 };
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private uwk jdField_a_of_type_Uwk;
  private uwl jdField_a_of_type_Uwl;
  private uwm jdField_a_of_type_Uwm;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  
  private uwh(Activity paramActivity, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
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
    int j = a(paramContext, 2131298743) * paramInt + a(paramContext, 2131298741);
    int i = j;
    if (paramBoolean) {
      i = j + (paramInt - 1) * 1;
    }
    return i;
  }
  
  private static View a(Activity paramActivity, List<uwk> paramList)
  {
    View localView = LayoutInflater.from(paramActivity).inflate(2131560010, null);
    a(paramActivity, localView, paramList);
    return localView;
  }
  
  private static List<uwk> a(Context paramContext, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(paramContext, jdField_a_of_type_ArrayOfInt, paramBoolean));
    localArrayList.add(a(paramContext, jdField_b_of_type_ArrayOfInt, false));
    return localArrayList;
  }
  
  public static uwh a(Activity paramActivity, boolean paramBoolean, uwl paramuwl, uwm paramuwm)
  {
    List localList = a(paramActivity, paramBoolean);
    if ((localList == null) || (localList.size() == 0)) {
      throw new IllegalArgumentException("parameter items can not be null or zero-length array.");
    }
    int i = b(paramActivity, localList.size());
    int j = bhtq.a(145.0F);
    paramActivity = new uwh(paramActivity, a(paramActivity, localList), j, i, true);
    paramActivity.setAnimationStyle(2131755030);
    paramActivity.setBackgroundDrawable(new ColorDrawable(0));
    paramActivity.setOutsideTouchable(false);
    a(paramActivity, 1002);
    if (AppSetting.c) {
      a(paramActivity);
    }
    paramActivity.a(paramActivity.getContentView());
    paramActivity.jdField_b_of_type_Int = i;
    paramActivity.jdField_a_of_type_Uwl = paramuwl;
    paramActivity.jdField_a_of_type_Uwm = paramuwm;
    paramActivity.jdField_a_of_type_Boolean = false;
    return paramActivity;
  }
  
  private static uwk a(Context paramContext, int[] paramArrayOfInt, boolean paramBoolean)
  {
    uwk localuwk = new uwk();
    localuwk.jdField_a_of_type_Int = paramArrayOfInt[0];
    localuwk.jdField_a_of_type_JavaLangString = paramContext.getResources().getString(paramArrayOfInt[0]);
    localuwk.jdField_b_of_type_Int = paramArrayOfInt[1];
    localuwk.jdField_a_of_type_Boolean = paramBoolean;
    return localuwk;
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
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131755330;
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165486));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(anzj.a(2131707215));
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(new uwi(this));
      }
      if ((AppSetting.c) && (Build.VERSION.SDK_INT >= 14)) {
        getContentView().setAccessibilityDelegate(new uwj(this));
      }
      return;
    }
  }
  
  private static void a(Context paramContext, View paramView, List<uwk> paramList)
  {
    paramView = (LinearLayout)paramView.findViewById(2131370218);
    paramView.removeAllViews();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      uwk localuwk = (uwk)paramList.next();
      View localView = LayoutInflater.from(paramContext).inflate(2131560009, null);
      ImageView localImageView1 = (ImageView)localView.findViewById(2131381474);
      ImageView localImageView2 = (ImageView)localView.findViewById(2131369254);
      TextView localTextView = (TextView)localView.findViewById(2131379909);
      localImageView2.setBackgroundResource(localuwk.jdField_b_of_type_Int);
      localTextView.setText(localuwk.jdField_a_of_type_JavaLangString);
      if (localuwk.jdField_a_of_type_Boolean) {
        localImageView1.setVisibility(0);
      }
      for (;;)
      {
        localView.setTag(localuwk);
        paramView.addView(localView);
        break;
        localImageView1.setVisibility(8);
      }
    }
  }
  
  private void a(View paramView)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof uwk))) {
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
    for (paramInt = i * agej.a(52.0F, paramContext.getResources()) + agej.a(62.0F, paramContext.getResources()) * 2;; paramInt = agej.a(62.0F, paramContext.getResources()) * paramInt) {
      return paramInt + a(paramContext, 2131298741);
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
        if ((this.jdField_a_of_type_Uwl != null) && (this.jdField_a_of_type_Uwk != null)) {
          this.jdField_a_of_type_Uwl.a(this.jdField_a_of_type_Uwk);
        }
        this.jdField_a_of_type_Uwk = null;
        if (this.jdField_a_of_type_Uwm != null) {
          this.jdField_a_of_type_Uwm.a();
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
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130772330);
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
    if ((this.jdField_a_of_type_Uwl != null) && (this.jdField_a_of_type_Uwk != null)) {
      this.jdField_a_of_type_Uwl.a(this.jdField_a_of_type_Uwk);
    }
    this.jdField_a_of_type_Uwk = null;
    if (this.jdField_a_of_type_Uwm != null) {
      this.jdField_a_of_type_Uwm.a();
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
    this.jdField_a_of_type_Uwk = ((uwk)paramView.getTag());
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
        i = (1 - a(this.jdField_a_of_type_AndroidAppActivity, 2131298741) + j) / (a(this.jdField_a_of_type_AndroidAppActivity, 2131298743) + 1);
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
 * Qualified Name:     uwh
 * JD-Core Version:    0.7.0.1
 */