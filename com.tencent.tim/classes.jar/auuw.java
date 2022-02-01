import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.util.List;

public class auuw
  extends PopupWindow
  implements View.OnClickListener, Animation.AnimationListener
{
  private Activity activity;
  private boolean ayf;
  private auuw.c b;
  private int bfM;
  private int bfN;
  private WindowManager.LayoutParams jdField_c_of_type_AndroidViewWindowManager$LayoutParams;
  private auuw.b jdField_c_of_type_Auuw$b;
  public boolean dkR;
  private auuw.a k;
  private View nG;
  private Animation u;
  
  private auuw(Activity paramActivity, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
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
  
  private static View a(Activity paramActivity, List<auuw.a> paramList)
  {
    View localView = LayoutInflater.from(paramActivity).inflate(2131562971, null);
    BounceScrollView localBounceScrollView = (BounceScrollView)localView.findViewById(2131363709);
    localBounceScrollView.setVerticalScrollBarEnabled(false);
    localBounceScrollView.mScrollFlag = 1;
    a(paramActivity, paramList, (LinearLayout)localBounceScrollView.findViewById(2131365360));
    return localView;
  }
  
  private static View a(Activity paramActivity, List<auuw.a> paramList, boolean paramBoolean, int paramInt)
  {
    View localView = LayoutInflater.from(paramActivity).inflate(2131562971, null);
    Object localObject1 = (BounceScrollView)localView.findViewById(2131363709);
    if (paramInt != -1) {
      ((BounceScrollView)localObject1).setBackgroundResource(paramInt);
    }
    LinearLayout localLinearLayout = (LinearLayout)((BounceScrollView)localObject1).findViewById(2131365360);
    ((BounceScrollView)localObject1).setVerticalScrollBarEnabled(false);
    ((BounceScrollView)localObject1).mScrollFlag = 1;
    new LinearLayout.LayoutParams(-1, 1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, p(paramActivity, 2131299280));
    paramInt = 0;
    auuw.a locala;
    Object localObject2;
    if (paramInt < paramList.size())
    {
      locala = (auuw.a)paramList.get(paramInt);
      if (paramInt == 0)
      {
        localObject2 = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2131562970, null);
        localObject1 = null;
      }
    }
    for (;;)
    {
      Object localObject3 = (ImageView)((LinearLayout)localObject2).findViewById(2131369088);
      TextView localTextView = (TextView)((LinearLayout)localObject2).findViewById(2131379576);
      if (locala.R != null)
      {
        ((ImageView)localObject3).setImageDrawable(locala.R);
        label173:
        if ((locala.iconId == 0) && (locala.drawable == null))
        {
          ((ImageView)localObject3).setVisibility(8);
          ((LinearLayout)localObject2).setPadding(0, 0, 0, 0);
        }
        localTextView.setText(locala.title);
        if (!TextUtils.isEmpty(locala.cuM)) {
          localTextView.setTextColor(Color.parseColor(locala.cuM));
        }
        if (locala.titleSize > 0.0F) {
          localTextView.setTextSize(locala.titleSize);
        }
        if (TextUtils.isEmpty(locala.contentDescription)) {
          break label485;
        }
        ((LinearLayout)localObject2).setContentDescription(locala.contentDescription + acfp.m(2131709806));
        label301:
        if (localObject1 != null) {
          localLinearLayout.addView((View)localObject1);
        }
        ((LinearLayout)localObject2).setTag(locala);
        if (locala.id > 0) {
          ((LinearLayout)localObject2).setId(locala.id);
        }
        localLinearLayout.addView((View)localObject2, localLayoutParams);
        paramInt += 1;
        break;
        if (paramInt == paramList.size() - 1)
        {
          localObject1 = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2131562968, null);
          if (!paramBoolean) {
            break label528;
          }
          localObject3 = o(paramActivity);
          localObject2 = localObject1;
          localObject1 = localObject3;
          continue;
        }
        if (!paramBoolean) {
          break label522;
        }
      }
      label522:
      for (localObject1 = o(paramActivity);; localObject1 = null)
      {
        localObject2 = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2131562969, null);
        break;
        if (locala.l != null)
        {
          ((ImageView)localObject3).setImageDrawable(locala.l);
          break label173;
        }
        if (locala.drawable != null)
        {
          ((ImageView)localObject3).setImageDrawable(locala.drawable);
          break label173;
        }
        ((ImageView)localObject3).setImageResource(locala.iconId);
        break label173;
        label485:
        ((LinearLayout)localObject2).setContentDescription(locala.title + acfp.m(2131709802));
        break label301;
        return localView;
      }
      label528:
      localObject3 = null;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public static auuw a(Activity paramActivity, List<auuw.a> paramList, auuw.b paramb)
  {
    return a(paramActivity, paramList, paramb, null);
  }
  
  public static auuw a(Activity paramActivity, List<auuw.a> paramList, auuw.b paramb, auuw.c paramc)
  {
    return a(paramActivity, paramList, paramb, paramc, 0);
  }
  
  public static auuw a(Activity paramActivity, List<auuw.a> paramList, auuw.b paramb, auuw.c paramc, int paramInt)
  {
    return a(paramActivity, paramList, paramb, paramc, paramInt, false);
  }
  
  public static auuw a(Activity paramActivity, List<auuw.a> paramList, auuw.b paramb, auuw.c paramc, int paramInt, boolean paramBoolean)
  {
    return a(paramActivity, paramList, paramb, paramc, paramInt, paramBoolean, -1, 2131755036);
  }
  
  public static auuw a(Activity paramActivity, List<auuw.a> paramList, auuw.b paramb, auuw.c paramc, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      throw new IllegalArgumentException("parameter items can not be null or zero-length array.");
    }
    int i = a(paramActivity, paramList.size(), paramBoolean);
    if (paramInt1 <= 0) {
      paramInt1 = p(paramActivity, 2131299279);
    }
    for (;;)
    {
      paramActivity = new auuw(paramActivity, a(paramActivity, paramList, paramBoolean, paramInt2), paramInt1, i, true);
      paramActivity.setAnimationStyle(paramInt3);
      paramActivity.setBackgroundDrawable(new ColorDrawable(0));
      paramActivity.setOutsideTouchable(false);
      if (Build.VERSION.SDK_INT >= 9) {
        a(paramActivity, 1002);
      }
      if (AppSetting.enableTalkBack) {
        a(paramActivity);
      }
      paramActivity.dz(paramActivity.getContentView());
      paramActivity.bfN = i;
      paramActivity.jdField_c_of_type_Auuw$b = paramb;
      paramActivity.b = paramc;
      paramActivity.ayf = paramBoolean;
      return paramActivity;
    }
  }
  
  private static void a(Activity paramActivity, List<auuw.a> paramList, LinearLayout paramLinearLayout)
  {
    a(paramActivity, paramList, paramLinearLayout, false);
  }
  
  private static void a(Activity paramActivity, List<auuw.a> paramList, LinearLayout paramLinearLayout, boolean paramBoolean)
  {
    int i = 0;
    if (i < paramList.size())
    {
      auuw.a locala = (auuw.a)paramList.get(i);
      LinearLayout.LayoutParams localLayoutParams;
      Object localObject;
      label68:
      ImageView localImageView;
      if (i == 0)
      {
        localLayoutParams = new LinearLayout.LayoutParams(-1, wja.dp2px(62.0F, paramActivity.getResources()));
        localObject = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2131562967, null);
        localImageView = (ImageView)((LinearLayout)localObject).findViewById(2131369088);
        TextView localTextView = (TextView)((LinearLayout)localObject).findViewById(2131379576);
        if (locala.R == null) {
          break label392;
        }
        localImageView.setImageDrawable(locala.R);
        label110:
        if ((locala.iconId == 0) && (locala.drawable == null))
        {
          localImageView.setVisibility(8);
          ((LinearLayout)localObject).setPadding(0, 0, 0, 0);
        }
        localTextView.setText(locala.title);
        if (!TextUtils.isEmpty(locala.cuM)) {
          localTextView.setTextColor(Color.parseColor(locala.cuM));
        }
        if (locala.titleSize > 0.0F) {
          localTextView.setTextSize(locala.titleSize);
        }
        if (TextUtils.isEmpty(locala.contentDescription)) {
          break label447;
        }
        ((LinearLayout)localObject).setContentDescription(locala.contentDescription + acfp.m(2131709805));
      }
      for (;;)
      {
        ((LinearLayout)localObject).setTag(locala);
        if (locala.id > 0) {
          ((LinearLayout)localObject).setId(locala.id);
        }
        paramLinearLayout.addView((View)localObject, localLayoutParams);
        i += 1;
        break;
        if (i == paramList.size() - 1)
        {
          localLayoutParams = new LinearLayout.LayoutParams(-1, wja.dp2px(62.0F, paramActivity.getResources()));
          localObject = LayoutInflater.from(paramActivity);
          if (paramBoolean) {}
          for (int j = 2131562966;; j = 2131562965)
          {
            localObject = (LinearLayout)((LayoutInflater)localObject).inflate(j, null);
            break;
          }
        }
        localLayoutParams = new LinearLayout.LayoutParams(-1, wja.dp2px(52.0F, paramActivity.getResources()));
        localObject = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2131562966, null);
        break label68;
        label392:
        if (locala.l != null)
        {
          localImageView.setImageDrawable(locala.l);
          break label110;
        }
        if (locala.drawable != null)
        {
          localImageView.setImageDrawable(locala.drawable);
          break label110;
        }
        localImageView.setImageResource(locala.iconId);
        break label110;
        label447:
        ((LinearLayout)localObject).setContentDescription(locala.title + acfp.m(2131709803));
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
        if (localMethod.getName().equals("setTouchModal")) {
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
        if (!localMethod.getName().equals("setWindowLayoutType")) {}
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
  
  public static auuw b(Activity paramActivity, List<auuw.a> paramList, auuw.b paramb, auuw.c paramc)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      throw new IllegalArgumentException("parameter items can not be null or zero-length array.");
    }
    int j = q(paramActivity, paramList.size());
    if (acha.isLocaleCN()) {}
    for (int i = p(paramActivity, 2131299274);; i = p(paramActivity, 2131299273))
    {
      paramActivity = new auuw(paramActivity, a(paramActivity, paramList), i, j, true);
      paramActivity.setAnimationStyle(2131755036);
      paramActivity.setBackgroundDrawable(new ColorDrawable(0));
      paramActivity.setOutsideTouchable(false);
      a(paramActivity, 1002);
      if (AppSetting.enableTalkBack) {
        a(paramActivity);
      }
      paramActivity.dz(paramActivity.getContentView());
      paramActivity.bfN = j;
      paramActivity.jdField_c_of_type_Auuw$b = paramb;
      paramActivity.b = paramc;
      paramActivity.ayf = false;
      return paramActivity;
    }
  }
  
  private void bgU()
  {
    int j = -1;
    int i;
    if (this.jdField_c_of_type_AndroidViewWindowManager$LayoutParams == null)
    {
      this.jdField_c_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
      this.jdField_c_of_type_AndroidViewWindowManager$LayoutParams.type = 1000;
      this.jdField_c_of_type_AndroidViewWindowManager$LayoutParams.format = -3;
      this.jdField_c_of_type_AndroidViewWindowManager$LayoutParams.flags = 40;
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        WindowManager.LayoutParams localLayoutParams = this.jdField_c_of_type_AndroidViewWindowManager$LayoutParams;
        localLayoutParams.flags |= 0x4000000;
      }
      this.jdField_c_of_type_AndroidViewWindowManager$LayoutParams.width = -1;
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
      this.jdField_c_of_type_AndroidViewWindowManager$LayoutParams.height = i;
      this.jdField_c_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131755551;
      if (this.nG == null)
      {
        this.nG = new View(this.activity);
        this.nG.setBackgroundColor(this.activity.getResources().getColor(2131165628));
        this.nG.setContentDescription(acfp.m(2131709804));
        this.nG.setOnClickListener(new auux(this));
      }
      if ((AppSetting.enableTalkBack) && (Build.VERSION.SDK_INT >= 14)) {
        getContentView().setAccessibilityDelegate(new auuy(this));
      }
      return;
    }
  }
  
  private void dz(View paramView)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof auuw.a))) {
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
  
  public static final View o(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -1);
    localLayoutParams.height = 1;
    paramContext.setBackgroundColor(Color.parseColor("#DEDFE0"));
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
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
        if ((this.jdField_c_of_type_Auuw$b != null) && (this.k != null)) {
          this.jdField_c_of_type_Auuw$b.a(this.k);
        }
        this.k = null;
        if (this.b != null) {
          this.b.onDismiss();
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
            QLog.i("PopupMenuDialog", 2, localException.toString());
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
      QLog.i("PopupMenuDialog", 2, "onAnimationEnd");
    }
    if ((this.jdField_c_of_type_Auuw$b != null) && (this.k != null)) {
      this.jdField_c_of_type_Auuw$b.a(this.k);
    }
    this.k = null;
    if (this.b != null) {
      this.b.onDismiss();
    }
    super.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PopupMenuDialog", 2, "onAnimationStart");
    }
  }
  
  public void onClick(View paramView)
  {
    this.k = ((auuw.a)paramView.getTag());
    dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onPause()
  {
    if ((Build.VERSION.SDK_INT < 9) && (isShowing())) {
      dismiss();
    }
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
          ((ViewGroup)this.activity.getWindow().getDecorView()).addView(this.nG, this.jdField_c_of_type_AndroidViewWindowManager$LayoutParams);
        }
        for (;;)
        {
          super.showAsDropDown(paramView, paramInt1, paramInt2);
          return;
          label130:
          setHeight(this.bfN);
          break;
          this.activity.getWindowManager().addView(this.nG, this.jdField_c_of_type_AndroidViewWindowManager$LayoutParams);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PopupMenuDialog", 2, localException.toString());
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
        ((ViewGroup)this.activity.getWindow().getDecorView()).addView(this.nG, this.jdField_c_of_type_AndroidViewWindowManager$LayoutParams);
      }
      for (;;)
      {
        super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
        return;
        this.activity.getWindowManager().addView(this.nG, this.jdField_c_of_type_AndroidViewWindowManager$LayoutParams);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PopupMenuDialog", 2, localException.toString());
        }
      }
    }
  }
  
  public static class a
  {
    public URLDrawable R;
    public String contentDescription;
    public String cuM;
    public Drawable drawable;
    public int iconId;
    public int id;
    public BitmapDrawable l;
    public String title;
    public float titleSize;
    
    public a() {}
    
    public a(int paramInt1, String paramString1, String paramString2, int paramInt2)
    {
      this.id = paramInt1;
      this.title = paramString1;
      this.contentDescription = paramString2;
      this.iconId = paramInt2;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(auuw.a parama);
  }
  
  public static abstract interface c
  {
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auuw
 * JD-Core Version:    0.7.0.1
 */