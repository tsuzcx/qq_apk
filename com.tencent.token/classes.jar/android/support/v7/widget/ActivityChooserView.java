package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.token.ei;
import com.tencent.token.fe;
import com.tencent.token.go.d;
import com.tencent.token.go.f;
import com.tencent.token.go.g;
import com.tencent.token.go.h;
import com.tencent.token.go.j;
import com.tencent.token.hw;
import com.tencent.token.id;
import com.tencent.token.id.a;
import com.tencent.token.id.c;
import com.tencent.token.it;
import com.tencent.token.je;
import java.util.List;

public class ActivityChooserView
  extends ViewGroup
{
  final a a;
  final View b;
  final Drawable c;
  final FrameLayout d;
  final FrameLayout e;
  final ImageView f;
  ei g;
  final DataSetObserver h = new DataSetObserver()
  {
    public final void onChanged()
    {
      super.onChanged();
      ActivityChooserView.this.a.notifyDataSetChanged();
    }
    
    public final void onInvalidated()
    {
      super.onInvalidated();
      ActivityChooserView.this.a.notifyDataSetInvalidated();
    }
  };
  PopupWindow.OnDismissListener i;
  boolean j;
  int k = 4;
  int l;
  private final b m;
  private final ImageView n;
  private final int o;
  private final ViewTreeObserver.OnGlobalLayoutListener p = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      if (ActivityChooserView.this.c())
      {
        if (!ActivityChooserView.this.isShown())
        {
          ActivityChooserView.this.getListPopupWindow().c();
          return;
        }
        ActivityChooserView.this.getListPopupWindow().b();
        if (ActivityChooserView.this.g != null) {
          ActivityChooserView.this.g.a(true);
        }
      }
    }
  };
  private ListPopupWindow q;
  private boolean r;
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = paramContext.obtainStyledAttributes(paramAttributeSet, go.j.ActivityChooserView, paramInt, 0);
    this.k = ((TypedArray)localObject).getInt(go.j.ActivityChooserView_initialActivityCount, 4);
    paramAttributeSet = ((TypedArray)localObject).getDrawable(go.j.ActivityChooserView_expandActivityOverflowButtonDrawable);
    ((TypedArray)localObject).recycle();
    LayoutInflater.from(getContext()).inflate(go.g.abc_activity_chooser_view, this, true);
    this.m = new b();
    this.b = findViewById(go.f.activity_chooser_view_content);
    this.c = this.b.getBackground();
    this.e = ((FrameLayout)findViewById(go.f.default_activity_button));
    this.e.setOnClickListener(this.m);
    this.e.setOnLongClickListener(this.m);
    this.f = ((ImageView)this.e.findViewById(go.f.image));
    localObject = (FrameLayout)findViewById(go.f.expand_activities_button);
    ((FrameLayout)localObject).setOnClickListener(this.m);
    ((FrameLayout)localObject).setAccessibilityDelegate(new View.AccessibilityDelegate()
    {
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
      {
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
        paramAnonymousView = fe.a(paramAnonymousAccessibilityNodeInfo);
        if (Build.VERSION.SDK_INT >= 19) {
          paramAnonymousView.a.setCanOpenPopup(true);
        }
      }
    });
    ((FrameLayout)localObject).setOnTouchListener(new it((View)localObject)
    {
      public final hw a()
      {
        return ActivityChooserView.this.getListPopupWindow();
      }
      
      public final boolean b()
      {
        ActivityChooserView.this.a();
        return true;
      }
      
      public final boolean c()
      {
        ActivityChooserView.this.b();
        return true;
      }
    });
    this.d = ((FrameLayout)localObject);
    this.n = ((ImageView)((FrameLayout)localObject).findViewById(go.f.image));
    this.n.setImageDrawable(paramAttributeSet);
    this.a = new a();
    this.a.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        super.onChanged();
        ActivityChooserView localActivityChooserView = ActivityChooserView.this;
        if (localActivityChooserView.a.getCount() > 0) {
          localActivityChooserView.d.setEnabled(true);
        } else {
          localActivityChooserView.d.setEnabled(false);
        }
        int i = localActivityChooserView.a.a.a();
        int j = localActivityChooserView.a.a.c();
        if ((i != 1) && ((i <= 1) || (j <= 0)))
        {
          localActivityChooserView.e.setVisibility(8);
        }
        else
        {
          localActivityChooserView.e.setVisibility(0);
          Object localObject = localActivityChooserView.a.a.b();
          PackageManager localPackageManager = localActivityChooserView.getContext().getPackageManager();
          localActivityChooserView.f.setImageDrawable(((ResolveInfo)localObject).loadIcon(localPackageManager));
          if (localActivityChooserView.l != 0)
          {
            localObject = ((ResolveInfo)localObject).loadLabel(localPackageManager);
            localObject = localActivityChooserView.getContext().getString(localActivityChooserView.l, new Object[] { localObject });
            localActivityChooserView.e.setContentDescription((CharSequence)localObject);
          }
        }
        if (localActivityChooserView.e.getVisibility() == 0)
        {
          localActivityChooserView.b.setBackgroundDrawable(localActivityChooserView.c);
          return;
        }
        localActivityChooserView.b.setBackgroundDrawable(null);
      }
    });
    paramContext = paramContext.getResources();
    this.o = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(go.d.abc_config_prefDialogWidth));
  }
  
  final void a(int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final boolean a()
  {
    if (!getListPopupWindow().q.isShowing())
    {
      if (!this.r) {
        return false;
      }
      this.j = false;
      a(this.k);
      return true;
    }
    return false;
  }
  
  public final boolean b()
  {
    if (getListPopupWindow().q.isShowing())
    {
      getListPopupWindow().c();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this.p);
      }
    }
    return true;
  }
  
  public final boolean c()
  {
    return getListPopupWindow().q.isShowing();
  }
  
  public id getDataModel()
  {
    return this.a.a;
  }
  
  ListPopupWindow getListPopupWindow()
  {
    if (this.q == null)
    {
      this.q = new ListPopupWindow(getContext());
      this.q.a(this.a);
      ListPopupWindow localListPopupWindow = this.q;
      localListPopupWindow.k = this;
      localListPopupWindow.f();
      localListPopupWindow = this.q;
      b localb = this.m;
      localListPopupWindow.l = localb;
      localListPopupWindow.a(localb);
    }
    return this.q;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    id localid = this.a.a;
    if (localid != null) {
      localid.registerObserver(this.h);
    }
    this.r = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.a.a;
    if (localObject != null) {
      ((id)localObject).unregisterObserver(this.h);
    }
    localObject = getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this.p);
    }
    if (c()) {
      b();
    }
    this.r = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!c()) {
      b();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = this.b;
    int i1 = paramInt2;
    if (this.e.getVisibility() != 0) {
      i1 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localView, paramInt1, i1);
    setMeasuredDimension(localView.getMeasuredWidth(), localView.getMeasuredHeight());
  }
  
  public void setActivityChooserModel(id paramid)
  {
    a locala = this.a;
    id localid = locala.c.a.a;
    if ((localid != null) && (locala.c.isShown())) {
      localid.unregisterObserver(locala.c.h);
    }
    locala.a = paramid;
    if ((paramid != null) && (locala.c.isShown())) {
      paramid.registerObserver(locala.c.h);
    }
    locala.notifyDataSetChanged();
    if (getListPopupWindow().q.isShowing())
    {
      b();
      a();
    }
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt)
  {
    String str = getContext().getString(paramInt);
    this.n.setContentDescription(str);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable)
  {
    this.n.setImageDrawable(paramDrawable);
  }
  
  public void setInitialActivityCount(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.i = paramOnDismissListener;
  }
  
  public void setProvider(ei paramei)
  {
    this.g = paramei;
  }
  
  public static class InnerLayout
    extends LinearLayout
  {
    private static final int[] a = { 16842964 };
    
    public InnerLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = je.a(paramContext, paramAttributeSet, a);
      setBackgroundDrawable(paramContext.a(0));
      paramContext.a.recycle();
    }
  }
  
  final class a
    extends BaseAdapter
  {
    id a;
    boolean b;
    private int d = 4;
    private boolean e;
    private boolean f;
    
    a() {}
    
    public final int a()
    {
      int k = this.d;
      this.d = 2147483647;
      int i = 0;
      int m = View.MeasureSpec.makeMeasureSpec(0, 0);
      int n = View.MeasureSpec.makeMeasureSpec(0, 0);
      int i1 = getCount();
      View localView = null;
      int j = 0;
      while (i < i1)
      {
        localView = getView(i, localView, null);
        localView.measure(m, n);
        j = Math.max(j, localView.getMeasuredWidth());
        i += 1;
      }
      this.d = k;
      return j;
    }
    
    public final void a(int paramInt)
    {
      if (this.d != paramInt)
      {
        this.d = paramInt;
        notifyDataSetChanged();
      }
    }
    
    public final void a(boolean paramBoolean)
    {
      if (this.f != paramBoolean)
      {
        this.f = paramBoolean;
        notifyDataSetChanged();
      }
    }
    
    public final void a(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((this.b != paramBoolean1) || (this.e != paramBoolean2))
      {
        this.b = paramBoolean1;
        this.e = paramBoolean2;
        notifyDataSetChanged();
      }
    }
    
    public final int getCount()
    {
      int j = this.a.a();
      int i = j;
      if (!this.b)
      {
        i = j;
        if (this.a.b() != null) {
          i = j - 1;
        }
      }
      j = Math.min(i, this.d);
      i = j;
      if (this.f) {
        i = j + 1;
      }
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      switch (getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 1: 
        return null;
      }
      int i = paramInt;
      if (!this.b)
      {
        i = paramInt;
        if (this.a.b() != null) {
          i = paramInt + 1;
        }
      }
      return this.a.a(i);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      if ((this.f) && (paramInt == getCount() - 1)) {
        return 1;
      }
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      switch (getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 1: 
        if (paramView != null)
        {
          localView = paramView;
          if (paramView.getId() == 1) {}
        }
        else
        {
          localView = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(go.g.abc_activity_chooser_view_list_item, paramViewGroup, false);
          localView.setId(1);
          ((TextView)localView.findViewById(go.f.title)).setText(ActivityChooserView.this.getContext().getString(go.h.abc_activity_chooser_view_see_all));
        }
        return localView;
      }
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getId() == go.f.list_item) {}
      }
      else
      {
        localView = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(go.g.abc_activity_chooser_view_list_item, paramViewGroup, false);
      }
      paramView = ActivityChooserView.this.getContext().getPackageManager();
      paramViewGroup = (ImageView)localView.findViewById(go.f.icon);
      ResolveInfo localResolveInfo = (ResolveInfo)getItem(paramInt);
      paramViewGroup.setImageDrawable(localResolveInfo.loadIcon(paramView));
      ((TextView)localView.findViewById(go.f.title)).setText(localResolveInfo.loadLabel(paramView));
      if ((this.b) && (paramInt == 0) && (this.e))
      {
        localView.setActivated(true);
        return localView;
      }
      localView.setActivated(false);
      return localView;
    }
    
    public final int getViewTypeCount()
    {
      return 3;
    }
  }
  
  final class b
    implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
  {
    b() {}
    
    public final void onClick(View paramView)
    {
      if (paramView == ActivityChooserView.this.e)
      {
        ActivityChooserView.this.b();
        paramView = ActivityChooserView.this.a.a.b();
        int i = ActivityChooserView.this.a.a.a(paramView);
        paramView = ActivityChooserView.this.a.a.b(i);
        if (paramView != null)
        {
          paramView.addFlags(524288);
          ActivityChooserView.this.getContext().startActivity(paramView);
        }
        return;
      }
      if (paramView == ActivityChooserView.this.d)
      {
        paramView = ActivityChooserView.this;
        paramView.j = false;
        paramView.a(paramView.k);
        return;
      }
      throw new IllegalArgumentException();
    }
    
    public final void onDismiss()
    {
      if (ActivityChooserView.this.i != null) {
        ActivityChooserView.this.i.onDismiss();
      }
      if (ActivityChooserView.this.g != null) {
        ActivityChooserView.this.g.a(false);
      }
    }
    
    public final void onItemClick(AdapterView<?> arg1, View paramView, int paramInt, long paramLong)
    {
      switch (((ActivityChooserView.a)???.getAdapter()).getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 1: 
        ActivityChooserView.this.a(2147483647);
        return;
      }
      ActivityChooserView.this.b();
      if (ActivityChooserView.this.j) {
        if (paramInt > 0) {
          paramView = ActivityChooserView.this.a.a;
        }
      }
      for (;;)
      {
        synchronized (paramView.b)
        {
          paramView.d();
          id.a locala1 = (id.a)paramView.c.get(paramInt);
          id.a locala2 = (id.a)paramView.c.get(0);
          if (locala2 == null) {
            break label261;
          }
          f = locala2.b - locala1.b + 5.0F;
          paramView.a(new id.c(new ComponentName(locala1.a.activityInfo.packageName, locala1.a.activityInfo.name), System.currentTimeMillis(), f));
          return;
        }
        return;
        if (!ActivityChooserView.this.a.b) {
          paramInt += 1;
        }
        ??? = ActivityChooserView.this.a.a.b(paramInt);
        if (??? != null)
        {
          ???.addFlags(524288);
          ActivityChooserView.this.getContext().startActivity(???);
        }
        return;
        label261:
        float f = 1.0F;
      }
    }
    
    public final boolean onLongClick(View paramView)
    {
      if (paramView == ActivityChooserView.this.e)
      {
        if (ActivityChooserView.this.a.getCount() > 0)
        {
          paramView = ActivityChooserView.this;
          paramView.j = true;
          paramView.a(paramView.k);
        }
        return true;
      }
      throw new IllegalArgumentException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActivityChooserView
 * JD-Core Version:    0.7.0.1
 */