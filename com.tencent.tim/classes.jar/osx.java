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

public class osx
  extends PopupWindow
  implements View.OnClickListener, Animation.AnimationListener
{
  private static final int[] dF = { 2131721928, 2130851941 };
  private static final int[] dG = { 2131721927, 2130851940 };
  private osx.a jdField_a_of_type_Osx$a;
  private osx.b jdField_a_of_type_Osx$b;
  private osx.c jdField_a_of_type_Osx$c;
  private Activity activity;
  private boolean ayf;
  private int bfM;
  private int bfN;
  private WindowManager.LayoutParams c;
  private View nG;
  private Animation u;
  
  private osx(Activity paramActivity, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramInt1, paramInt2, paramBoolean);
    this.activity = paramActivity;
    bgU();
  }
  
  private static int a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int j = p(paramContext, 2131299280) * paramInt + p(paramContext, 2131299278);
    int i = j;
    if (paramBoolean) {
      i = j + (paramInt - 1) * 1;
    }
    return i;
  }
  
  private static View a(Activity paramActivity, List<osx.a> paramList)
  {
    View localView = LayoutInflater.from(paramActivity).inflate(2131560206, null);
    a(paramActivity, localView, paramList);
    return localView;
  }
  
  private static osx.a a(Context paramContext, int[] paramArrayOfInt, boolean paramBoolean)
  {
    osx.a locala = new osx.a();
    locala.id = paramArrayOfInt[0];
    locala.title = paramContext.getResources().getString(paramArrayOfInt[0]);
    locala.iconId = paramArrayOfInt[1];
    locala.ayg = paramBoolean;
    return locala;
  }
  
  public static osx a(Activity paramActivity, boolean paramBoolean, osx.b paramb, osx.c paramc)
  {
    List localList = b(paramActivity, paramBoolean);
    if ((localList == null) || (localList.size() == 0)) {
      throw new IllegalArgumentException("parameter items can not be null or zero-length array.");
    }
    int i = q(paramActivity, localList.size());
    int j = aqnm.dip2px(145.0F);
    paramActivity = new osx(paramActivity, a(paramActivity, localList), j, i, true);
    paramActivity.setAnimationStyle(2131755036);
    paramActivity.setBackgroundDrawable(new ColorDrawable(0));
    paramActivity.setOutsideTouchable(false);
    a(paramActivity, 1002);
    if (AppSetting.enableTalkBack) {
      a(paramActivity);
    }
    paramActivity.dz(paramActivity.getContentView());
    paramActivity.bfN = i;
    paramActivity.jdField_a_of_type_Osx$b = paramb;
    paramActivity.jdField_a_of_type_Osx$c = paramc;
    paramActivity.ayf = false;
    return paramActivity;
  }
  
  private static void a(Context paramContext, View paramView, List<osx.a> paramList)
  {
    paramView = (LinearLayout)paramView.findViewById(2131370713);
    paramView.removeAllViews();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      osx.a locala = (osx.a)paramList.next();
      View localView = LayoutInflater.from(paramContext).inflate(2131560205, null);
      ImageView localImageView1 = (ImageView)localView.findViewById(2131382335);
      ImageView localImageView2 = (ImageView)localView.findViewById(2131369788);
      TextView localTextView = (TextView)localView.findViewById(2131380768);
      localImageView2.setBackgroundResource(locala.iconId);
      localTextView.setText(locala.title);
      if (locala.ayg) {
        localImageView1.setVisibility(0);
      }
      for (;;)
      {
        localView.setTag(locala);
        paramView.addView(localView);
        break;
        localImageView1.setVisibility(8);
      }
    }
  }
  
  public static void a(PopupWindow paramPopupWindow)
  {
    int i = 0;
    if (!AppSetting.enableTalkBack) {}
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
  
  private static List<osx.a> b(Context paramContext, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(paramContext, dF, paramBoolean));
    localArrayList.add(a(paramContext, dG, false));
    return localArrayList;
  }
  
  private void bgU()
  {
    int j = -1;
    int i;
    if (this.c == null)
    {
      this.c = new WindowManager.LayoutParams();
      this.c.type = 1000;
      this.c.format = -3;
      this.c.flags = 40;
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        WindowManager.LayoutParams localLayoutParams = this.c;
        localLayoutParams.flags |= 0x4000000;
      }
      this.c.width = -1;
      i = j;
      if (this.activity.getWindow() != null)
      {
        i = j;
        if (this.activity.getWindow().getDecorView() != null)
        {
          i = this.activity.getWindow().getDecorView().getHeight();
          if (i > 0) {
            break label245;
          }
          i = j;
        }
      }
    }
    label245:
    for (;;)
    {
      this.c.height = i;
      this.c.windowAnimations = 2131755551;
      if (this.nG == null)
      {
        this.nG = new View(this.activity);
        this.nG.setBackgroundColor(this.activity.getResources().getColor(2131165628));
        this.nG.setContentDescription(acfp.m(2131709804));
        this.nG.setOnClickListener(new osy(this));
      }
      if ((AppSetting.enableTalkBack) && (Build.VERSION.SDK_INT >= 14)) {
        getContentView().setAccessibilityDelegate(new osz(this));
      }
      return;
    }
  }
  
  private void dz(View paramView)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof osx.a))) {
      paramView.setOnClickListener(this);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        dz(paramView.getChildAt(i));
        i += 1;
      }
    }
  }
  
  public static int p(Context paramContext, int paramInt)
  {
    return paramContext.getResources().getDimensionPixelSize(paramInt);
  }
  
  public static int q(Context paramContext, int paramInt)
  {
    int i = paramInt - 2;
    if (i > 0) {}
    for (paramInt = i * wja.dp2px(52.0F, paramContext.getResources()) + wja.dp2px(62.0F, paramContext.getResources()) * 2;; paramInt = wja.dp2px(62.0F, paramContext.getResources()) * paramInt) {
      return paramInt + p(paramContext, 2131299278);
    }
  }
  
  public void dismiss()
  {
    try
    {
      if (ImmersiveUtils.hasNotchInScreen(this.activity)) {
        ((ViewGroup)this.activity.getWindow().getDecorView()).removeView(this.nG);
      }
      while (Build.VERSION.SDK_INT >= 11)
      {
        super.dismiss();
        if ((this.jdField_a_of_type_Osx$b != null) && (this.jdField_a_of_type_Osx$a != null)) {
          this.jdField_a_of_type_Osx$b.a(this.jdField_a_of_type_Osx$a);
        }
        this.jdField_a_of_type_Osx$a = null;
        if (this.jdField_a_of_type_Osx$c != null) {
          this.jdField_a_of_type_Osx$c.onDismiss();
        }
        return;
        this.activity.getWindowManager().removeView(this.nG);
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
      } while ((!isShowing()) || ((this.u != null) && (!this.u.hasEnded())));
      if (this.u == null)
      {
        this.u = AnimationUtils.loadAnimation(this.activity, 2130772395);
        this.u.setAnimationListener(this);
      }
      getContentView().startAnimation(this.u);
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WSPopupMenuDialog", 2, "onAnimationEnd");
    }
    if ((this.jdField_a_of_type_Osx$b != null) && (this.jdField_a_of_type_Osx$a != null)) {
      this.jdField_a_of_type_Osx$b.a(this.jdField_a_of_type_Osx$a);
    }
    this.jdField_a_of_type_Osx$a = null;
    if (this.jdField_a_of_type_Osx$c != null) {
      this.jdField_a_of_type_Osx$c.onDismiss();
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
    this.jdField_a_of_type_Osx$a = ((osx.a)paramView.getTag());
    dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    int j = getMaxAvailableHeight(paramView, paramInt2);
    if (j != this.bfM)
    {
      int i = 0;
      if (j < this.bfN) {
        i = (1 - p(this.activity, 2131299278) + j) / (p(this.activity, 2131299280) + 1);
      }
      if (i <= 0) {
        break label130;
      }
      setHeight(a(this.activity, i, this.ayf));
    }
    for (;;)
    {
      this.bfM = j;
      try
      {
        if (ImmersiveUtils.hasNotchInScreen(this.activity)) {
          ((ViewGroup)this.activity.getWindow().getDecorView()).addView(this.nG, this.c);
        }
        for (;;)
        {
          super.showAsDropDown(paramView, paramInt1, paramInt2);
          return;
          label130:
          setHeight(this.bfN);
          break;
          this.activity.getWindowManager().addView(this.nG, this.c);
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
      if (ImmersiveUtils.hasNotchInScreen(this.activity)) {
        ((ViewGroup)this.activity.getWindow().getDecorView()).addView(this.nG, this.c);
      }
      for (;;)
      {
        super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
        return;
        this.activity.getWindowManager().addView(this.nG, this.c);
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
  
  public static class a
  {
    public boolean ayg;
    public int iconId;
    public int id;
    public String title;
  }
  
  public static abstract interface b
  {
    public abstract void a(osx.a parama);
  }
  
  public static abstract interface c
  {
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     osx
 * JD-Core Version:    0.7.0.1
 */