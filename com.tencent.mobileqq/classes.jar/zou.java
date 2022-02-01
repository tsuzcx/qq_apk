import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import java.util.ArrayList;
import javax.annotation.Nullable;

public abstract class zou<E>
  extends zox<E>
  implements Application.ActivityLifecycleCallbacks, zot
{
  private static final String jdField_a_of_type_JavaLangString = zou.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private final RecyclerView.AdapterDataObserver jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver = new zov(this);
  private zoo jdField_a_of_type_Zoo;
  private zow jdField_a_of_type_Zow;
  private final zoz jdField_a_of_type_Zoz = new zoz();
  protected boolean a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = String.valueOf(hashCode());
  protected boolean b;
  
  public zou(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    setHasStableIds(true);
  }
  
  private void c(zoz paramzoz)
  {
    if (this.jdField_a_of_type_Zow != null)
    {
      this.jdField_a_of_type_Zow.a(paramzoz, this);
      return;
    }
    a(paramzoz);
  }
  
  public abstract int a();
  
  public int a(int paramInt)
  {
    return paramInt - this.jdField_a_of_type_Int;
  }
  
  protected Activity a()
  {
    if ((a() != null) && (a().a() != null)) {
      return a().a().getActivity();
    }
    return null;
  }
  
  protected Context a()
  {
    return a();
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
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
  
  public BlockContainer a()
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
  
  public ExtraTypeInfo a()
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
  
  public zoo a()
  {
    return this.jdField_a_of_type_Zoo;
  }
  
  public zos a(String paramString)
  {
    if (this.jdField_a_of_type_Zoo != null) {
      return this.jdField_a_of_type_Zoo.a(paramString);
    }
    return null;
  }
  
  public zoz a()
  {
    return this.jdField_a_of_type_Zoz;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Zoz.a(2);
    this.jdField_a_of_type_Zoz.a(null);
    if (this.jdField_a_of_type_Zow != null)
    {
      this.jdField_a_of_type_Zow.a(this.jdField_a_of_type_Zoz, this);
      return;
    }
    c(this.jdField_a_of_type_Zoz);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void a(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, RecyclerView.State paramState) {}
  
  protected void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState) {}
  
  public abstract void a(Bundle paramBundle);
  
  public void a(View paramView)
  {
    if (a() != null) {
      a().addView(paramView);
    }
  }
  
  public void a(String paramString, zos paramzos) {}
  
  public void a(zoo paramzoo)
  {
    this.jdField_a_of_type_Zoo = paramzoo;
  }
  
  protected void a(zou paramzou, int paramInt) {}
  
  public void a(zow paramzow)
  {
    this.jdField_a_of_type_Zow = paramzow;
  }
  
  public abstract void a(zoz paramzoz);
  
  public void a(boolean paramBoolean)
  {
    if ((a() != null) && (a() != null))
    {
      a().a(4);
      a().setRefreshing(false);
      if (d()) {
        a().a(paramBoolean, a().a());
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int b(int paramInt)
  {
    return this.jdField_a_of_type_Int + paramInt;
  }
  
  protected void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      a(a());
      this.jdField_a_of_type_Zoz.a(1);
      c(this.jdField_a_of_type_Zoz);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(String paramString, zos paramzos)
  {
    if (this.jdField_a_of_type_Zoo != null) {
      this.jdField_a_of_type_Zoo.a(paramString, paramzos);
    }
  }
  
  public void b(zoz paramzoz)
  {
    if (this.jdField_a_of_type_Zow != null)
    {
      this.jdField_a_of_type_Zow.a(paramzoz, this);
      return;
    }
    c(paramzoz);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public int c(int paramInt)
  {
    return 1;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a() != null)
    {
      bool1 = bool2;
      if (a().size() > 0)
      {
        bool1 = bool2;
        if (a().a().get(a().a().size() - 1) == this) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public abstract int getItemCount();
  
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
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if (b()) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zou
 * JD-Core Version:    0.7.0.1
 */