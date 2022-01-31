import android.app.Activity;
import android.content.Context;
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
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import javax.annotation.Nullable;

public abstract class wbp<E>
  extends wbn<E>
  implements wbw
{
  private static final String jdField_a_of_type_JavaLangString = wbp.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private RecyclerView.AdapterDataObserver jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver = new wbq(this);
  private wbr jdField_a_of_type_Wbr;
  private wbs jdField_a_of_type_Wbs;
  private final wca jdField_a_of_type_Wca = new wca();
  protected boolean a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = String.valueOf(hashCode());
  protected boolean b;
  private boolean c;
  
  public wbp(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    setHasStableIds(true);
  }
  
  private void c(wca paramwca)
  {
    if (this.jdField_a_of_type_Wbr != null)
    {
      this.jdField_a_of_type_Wbr.a(paramwca, this);
      return;
    }
    a(paramwca);
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
  
  protected Context a()
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
  
  public wbs a()
  {
    return this.jdField_a_of_type_Wbs;
  }
  
  public wbv a(String paramString)
  {
    if (this.jdField_a_of_type_Wbs != null) {
      return this.jdField_a_of_type_Wbs.a(paramString);
    }
    return null;
  }
  
  public wca a()
  {
    return this.jdField_a_of_type_Wca;
  }
  
  protected void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState) {}
  
  public abstract void a(Bundle paramBundle);
  
  public void a(String paramString, wbv paramwbv) {}
  
  protected void a(wbp paramwbp, int paramInt) {}
  
  public void a(wbr paramwbr)
  {
    this.jdField_a_of_type_Wbr = paramwbr;
  }
  
  public void a(wbs paramwbs)
  {
    this.jdField_a_of_type_Wbs = paramwbs;
  }
  
  public abstract void a(wca paramwca);
  
  public boolean a()
  {
    return true;
  }
  
  public int b(int paramInt)
  {
    return paramInt - this.jdField_a_of_type_Int;
  }
  
  public void b(View paramView)
  {
    if (a() != null) {
      a().addView(paramView);
    }
  }
  
  public void b(String paramString, wbv paramwbv)
  {
    if (this.jdField_a_of_type_Wbs != null) {
      this.jdField_a_of_type_Wbs.a(paramString, paramwbv);
    }
  }
  
  public void b(wca paramwca)
  {
    if (this.jdField_a_of_type_Wbr != null)
    {
      this.jdField_a_of_type_Wbr.a(paramwca, this);
      return;
    }
    c(paramwca);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int c(int paramInt)
  {
    return this.jdField_a_of_type_Int + paramInt;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Wca.a(2);
    this.jdField_a_of_type_Wca.a(null);
    if (this.jdField_a_of_type_Wbr != null)
    {
      this.jdField_a_of_type_Wbr.a(this.jdField_a_of_type_Wca, this);
      return;
    }
    c(this.jdField_a_of_type_Wca);
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
  
  protected void e()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      a(a());
      this.jdField_a_of_type_Wca.a(1);
      c(this.jdField_a_of_type_Wca);
      this.jdField_a_of_type_Boolean = true;
    }
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
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    registerAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    this.jdField_b_of_type_Boolean = true;
    unregisterAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if (e()) {
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wbp
 * JD-Core Version:    0.7.0.1
 */