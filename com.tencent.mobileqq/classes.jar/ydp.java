import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import javax.annotation.Nullable;

public abstract class ydp<E>
  extends ydn<E>
  implements Application.ActivityLifecycleCallbacks, ydx
{
  private static final String jdField_a_of_type_JavaLangString = ydp.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private final RecyclerView.AdapterDataObserver jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver = new ydq(this);
  protected xzc a;
  private ydr jdField_a_of_type_Ydr;
  private yds jdField_a_of_type_Yds;
  private final yeb jdField_a_of_type_Yeb = new yeb();
  protected boolean a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = String.valueOf(hashCode());
  protected boolean b;
  protected boolean c;
  
  public ydp(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    setHasStableIds(true);
  }
  
  private void c(yeb paramyeb)
  {
    if (this.jdField_a_of_type_Ydr != null)
    {
      this.jdField_a_of_type_Ydr.a(paramyeb, this);
      return;
    }
    a(paramyeb);
  }
  
  public abstract int a();
  
  public int a(int paramInt)
  {
    return 1;
  }
  
  protected Activity a()
  {
    if ((a() != null) && (a().a() != null)) {
      return a().a().getActivity();
    }
    return null;
  }
  
  public Context a()
  {
    return a();
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public Fragment a()
  {
    if (a() != null) {
      return a().a();
    }
    return null;
  }
  
  protected FrameLayout a(@Nullable View paramView)
  {
    FrameLayout localFrameLayout = new FrameLayout(a());
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    if (paramView != null) {
      localFrameLayout.addView(paramView);
    }
    return localFrameLayout;
  }
  
  public ExtraTypeInfo a()
  {
    if (a() != null) {
      return a().a();
    }
    return null;
  }
  
  public ComponentPageView a()
  {
    if (a() != null) {
      return a().a();
    }
    return null;
  }
  
  public NestScrollRecyclerView a()
  {
    if (a() != null) {
      return a().a();
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public xzc a()
  {
    return this.jdField_a_of_type_Xzc;
  }
  
  public yds a()
  {
    return this.jdField_a_of_type_Yds;
  }
  
  public ydw a(String paramString)
  {
    if (this.jdField_a_of_type_Yds != null) {
      return this.jdField_a_of_type_Yds.a(paramString);
    }
    return null;
  }
  
  public yeb a()
  {
    return this.jdField_a_of_type_Yeb;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState) {}
  
  public abstract void a(Bundle paramBundle);
  
  public void a(RecyclerView.OnScrollListener paramOnScrollListener)
  {
    if (a() != null) {
      a().addOnScrollListener(paramOnScrollListener);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((paramView == null) || (a() == null) || (a() == null)) {
      return;
    }
    if (paramView.getLayoutParams() != null) {
      ((FrameLayout.LayoutParams)paramView.getLayoutParams()).gravity = 48;
    }
    a().addView(paramView);
    a().setPadding(0, paramInt, 0, 0);
  }
  
  public void a(String paramString, ydw paramydw) {}
  
  public void a(xzc paramxzc)
  {
    this.jdField_a_of_type_Xzc = paramxzc;
  }
  
  protected void a(ydp paramydp, int paramInt) {}
  
  public void a(ydr paramydr)
  {
    this.jdField_a_of_type_Ydr = paramydr;
  }
  
  public void a(yds paramyds)
  {
    this.jdField_a_of_type_Yds = paramyds;
  }
  
  public abstract void a(yeb paramyeb);
  
  public int b(int paramInt)
  {
    return paramInt - this.jdField_a_of_type_Int;
  }
  
  public void b(RecyclerView.OnScrollListener paramOnScrollListener)
  {
    if (a() != null) {
      a().removeOnScrollListener(paramOnScrollListener);
    }
  }
  
  public void b(View paramView)
  {
    if (a() != null) {
      a().addView(paramView);
    }
  }
  
  public void b(String paramString, ydw paramydw)
  {
    if (this.jdField_a_of_type_Yds != null) {
      this.jdField_a_of_type_Yds.a(paramString, paramydw);
    }
  }
  
  public void b(yeb paramyeb)
  {
    if (this.jdField_a_of_type_Ydr != null)
    {
      this.jdField_a_of_type_Ydr.a(paramyeb, this);
      return;
    }
    c(paramyeb);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c(int paramInt)
  {
    return this.jdField_a_of_type_Int + paramInt;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int d(int paramInt)
  {
    return this.jdField_b_of_type_Int + paramInt;
  }
  
  public void d(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void d(boolean paramBoolean)
  {
    if ((a() != null) && (a() != null))
    {
      a().a(4);
      a().setRefreshing(false);
      if (this.c) {
        a().a(paramBoolean, this);
      }
    }
  }
  
  public boolean d_()
  {
    return true;
  }
  
  protected void e(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  protected boolean e()
  {
    return false;
  }
  
  public abstract int getItemCount();
  
  public void o()
  {
    this.jdField_a_of_type_Yeb.a(2);
    this.jdField_a_of_type_Yeb.a(null);
    if (this.jdField_a_of_type_Ydr != null)
    {
      this.jdField_a_of_type_Ydr.a(this.jdField_a_of_type_Yeb, this);
      return;
    }
    c(this.jdField_a_of_type_Yeb);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    if (!hasObservers()) {
      registerAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    this.jdField_b_of_type_Boolean = true;
    if (hasObservers()) {
      unregisterAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if (e()) {
      p();
    }
  }
  
  protected void p()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      a(a());
      this.jdField_a_of_type_Yeb.a(1);
      c(this.jdField_a_of_type_Yeb);
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ydp
 * JD-Core Version:    0.7.0.1
 */