package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.tencent.token.ew;
import com.tencent.token.go.a;
import com.tencent.token.go.f;

public class AlertDialog
  extends AppCompatDialog
  implements DialogInterface
{
  final AlertController a = new AlertController(getContext(), this, getWindow());
  
  protected AlertDialog(Context paramContext, int paramInt)
  {
    super(paramContext, a(paramContext, paramInt));
  }
  
  static int a(Context paramContext, int paramInt)
  {
    if ((paramInt >>> 24 & 0xFF) > 0) {
      return paramInt;
    }
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(go.a.alertDialogTheme, localTypedValue, true);
    return localTypedValue.resourceId;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AlertController localAlertController = this.a;
    int i;
    if ((localAlertController.K != 0) && (localAlertController.Q == 1)) {
      i = localAlertController.K;
    } else {
      i = localAlertController.J;
    }
    localAlertController.b.setContentView(i);
    paramBundle = localAlertController.c.findViewById(go.f.parentPanel);
    Object localObject4 = paramBundle.findViewById(go.f.topPanel);
    Object localObject3 = paramBundle.findViewById(go.f.contentPanel);
    Object localObject2 = paramBundle.findViewById(go.f.buttonPanel);
    Object localObject1 = (ViewGroup)paramBundle.findViewById(go.f.customPanel);
    paramBundle = localAlertController.h;
    int i1 = 0;
    if (paramBundle != null) {
      paramBundle = localAlertController.h;
    } else if (localAlertController.i != 0) {
      paramBundle = LayoutInflater.from(localAlertController.a).inflate(localAlertController.i, (ViewGroup)localObject1, false);
    } else {
      paramBundle = null;
    }
    if (paramBundle != null) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) || (!AlertController.a(paramBundle))) {
      localAlertController.c.setFlags(131072, 131072);
    }
    if (i != 0)
    {
      localObject5 = (FrameLayout)localAlertController.c.findViewById(go.f.custom);
      ((FrameLayout)localObject5).addView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
      if (localAlertController.n) {
        ((FrameLayout)localObject5).setPadding(localAlertController.j, localAlertController.k, localAlertController.l, localAlertController.m);
      }
      if (localAlertController.g != null) {
        ((LinearLayoutCompat.LayoutParams)((ViewGroup)localObject1).getLayoutParams()).g = 0.0F;
      }
    }
    else
    {
      ((ViewGroup)localObject1).setVisibility(8);
    }
    paramBundle = ((ViewGroup)localObject1).findViewById(go.f.topPanel);
    View localView = ((ViewGroup)localObject1).findViewById(go.f.contentPanel);
    Object localObject5 = ((ViewGroup)localObject1).findViewById(go.f.buttonPanel);
    paramBundle = AlertController.a(paramBundle, (View)localObject4);
    localObject3 = AlertController.a(localView, (View)localObject3);
    localObject2 = AlertController.a((View)localObject5, (View)localObject2);
    localAlertController.A = ((NestedScrollView)localAlertController.c.findViewById(go.f.scrollView));
    localAlertController.A.setFocusable(false);
    localAlertController.A.setNestedScrollingEnabled(false);
    localAlertController.F = ((TextView)((ViewGroup)localObject3).findViewById(16908299));
    if (localAlertController.F != null) {
      if (localAlertController.f != null)
      {
        localAlertController.F.setText(localAlertController.f);
      }
      else
      {
        localAlertController.F.setVisibility(8);
        localAlertController.A.removeView(localAlertController.F);
        if (localAlertController.g != null)
        {
          localObject4 = (ViewGroup)localAlertController.A.getParent();
          i = ((ViewGroup)localObject4).indexOfChild(localAlertController.A);
          ((ViewGroup)localObject4).removeViewAt(i);
          ((ViewGroup)localObject4).addView(localAlertController.g, i, new ViewGroup.LayoutParams(-1, -1));
        }
        else
        {
          ((ViewGroup)localObject3).setVisibility(8);
        }
      }
    }
    localAlertController.o = ((Button)((ViewGroup)localObject2).findViewById(16908313));
    localAlertController.o.setOnClickListener(localAlertController.S);
    if ((TextUtils.isEmpty(localAlertController.p)) && (localAlertController.r == null))
    {
      localAlertController.o.setVisibility(8);
      i = 0;
    }
    else
    {
      localAlertController.o.setText(localAlertController.p);
      if (localAlertController.r != null)
      {
        localAlertController.r.setBounds(0, 0, localAlertController.d, localAlertController.d);
        localAlertController.o.setCompoundDrawables(localAlertController.r, null, null, null);
      }
      localAlertController.o.setVisibility(0);
      i = 1;
    }
    localAlertController.s = ((Button)((ViewGroup)localObject2).findViewById(16908314));
    localAlertController.s.setOnClickListener(localAlertController.S);
    if ((TextUtils.isEmpty(localAlertController.t)) && (localAlertController.v == null))
    {
      localAlertController.s.setVisibility(8);
    }
    else
    {
      localAlertController.s.setText(localAlertController.t);
      if (localAlertController.v != null)
      {
        localAlertController.v.setBounds(0, 0, localAlertController.d, localAlertController.d);
        localAlertController.s.setCompoundDrawables(localAlertController.v, null, null, null);
      }
      localAlertController.s.setVisibility(0);
      i |= 0x2;
    }
    localAlertController.w = ((Button)((ViewGroup)localObject2).findViewById(16908315));
    localAlertController.w.setOnClickListener(localAlertController.S);
    if ((TextUtils.isEmpty(localAlertController.x)) && (localAlertController.z == null))
    {
      localAlertController.w.setVisibility(8);
    }
    else
    {
      localAlertController.w.setText(localAlertController.x);
      if (localAlertController.r != null)
      {
        localAlertController.r.setBounds(0, 0, localAlertController.d, localAlertController.d);
        localAlertController.o.setCompoundDrawables(localAlertController.r, null, null, null);
      }
      localAlertController.w.setVisibility(0);
      i |= 0x4;
    }
    localObject4 = localAlertController.a;
    localObject5 = new TypedValue();
    ((Context)localObject4).getTheme().resolveAttribute(go.a.alertDialogCenterButtons, (TypedValue)localObject5, true);
    int j;
    if (((TypedValue)localObject5).data != 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0) {
      if (i == 1) {
        AlertController.a(localAlertController.o);
      } else if (i == 2) {
        AlertController.a(localAlertController.s);
      } else if (i == 4) {
        AlertController.a(localAlertController.w);
      }
    }
    if (i != 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      ((ViewGroup)localObject2).setVisibility(8);
    }
    if (localAlertController.G != null)
    {
      localObject4 = new ViewGroup.LayoutParams(-1, -2);
      paramBundle.addView(localAlertController.G, 0, (ViewGroup.LayoutParams)localObject4);
      localAlertController.c.findViewById(go.f.title_template).setVisibility(8);
    }
    else
    {
      localAlertController.D = ((ImageView)localAlertController.c.findViewById(16908294));
      if (((TextUtils.isEmpty(localAlertController.e) ^ true)) && (localAlertController.P))
      {
        localAlertController.E = ((TextView)localAlertController.c.findViewById(go.f.alertTitle));
        localAlertController.E.setText(localAlertController.e);
        if (localAlertController.B != 0)
        {
          localAlertController.D.setImageResource(localAlertController.B);
        }
        else if (localAlertController.C != null)
        {
          localAlertController.D.setImageDrawable(localAlertController.C);
        }
        else
        {
          localAlertController.E.setPadding(localAlertController.D.getPaddingLeft(), localAlertController.D.getPaddingTop(), localAlertController.D.getPaddingRight(), localAlertController.D.getPaddingBottom());
          localAlertController.D.setVisibility(8);
        }
      }
      else
      {
        localAlertController.c.findViewById(go.f.title_template).setVisibility(8);
        localAlertController.D.setVisibility(8);
        paramBundle.setVisibility(8);
      }
    }
    if ((localObject1 != null) && (((ViewGroup)localObject1).getVisibility() != 8)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramBundle != null) && (paramBundle.getVisibility() != 8)) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if ((localObject2 != null) && (((ViewGroup)localObject2).getVisibility() != 8)) {
      k = 1;
    } else {
      k = 0;
    }
    if ((k == 0) && (localObject3 != null))
    {
      localObject1 = ((ViewGroup)localObject3).findViewById(go.f.textSpacerNoButtons);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
    }
    if (j != 0)
    {
      if (localAlertController.A != null) {
        localAlertController.A.setClipToPadding(true);
      }
      if ((localAlertController.f == null) && (localAlertController.g == null)) {
        paramBundle = null;
      } else {
        paramBundle = paramBundle.findViewById(go.f.titleDividerNoCustom);
      }
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    else if (localObject3 != null)
    {
      paramBundle = ((ViewGroup)localObject3).findViewById(go.f.textSpacerNoTitle);
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    if ((localAlertController.g instanceof AlertController.RecycleListView))
    {
      paramBundle = (AlertController.RecycleListView)localAlertController.g;
      if ((k == 0) || (j == 0))
      {
        int i2 = paramBundle.getPaddingLeft();
        int m;
        if (j != 0) {
          m = paramBundle.getPaddingTop();
        } else {
          m = paramBundle.a;
        }
        int i3 = paramBundle.getPaddingRight();
        int n;
        if (k != 0) {
          n = paramBundle.getPaddingBottom();
        } else {
          n = paramBundle.b;
        }
        paramBundle.setPadding(i2, m, i3, n);
      }
    }
    if (i == 0)
    {
      if (localAlertController.g != null) {
        paramBundle = localAlertController.g;
      } else {
        paramBundle = localAlertController.A;
      }
      if (paramBundle != null)
      {
        i = i1;
        if (k != 0) {
          i = 2;
        }
        i = j | i;
        localObject1 = localAlertController.c.findViewById(go.f.scrollIndicatorUp);
        localObject2 = localAlertController.c.findViewById(go.f.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23)
        {
          ew.d(paramBundle, i);
          if (localObject1 != null) {
            ((ViewGroup)localObject3).removeView((View)localObject1);
          }
          if (localObject2 != null) {
            ((ViewGroup)localObject3).removeView((View)localObject2);
          }
        }
        else
        {
          paramBundle = (Bundle)localObject1;
          if (localObject1 != null)
          {
            paramBundle = (Bundle)localObject1;
            if ((i & 0x1) == 0)
            {
              ((ViewGroup)localObject3).removeView((View)localObject1);
              paramBundle = null;
            }
          }
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if ((i & 0x2) == 0)
            {
              ((ViewGroup)localObject3).removeView((View)localObject2);
              localObject1 = null;
            }
          }
          if ((paramBundle != null) || (localObject1 != null)) {
            if (localAlertController.f != null)
            {
              localAlertController.A.setOnScrollChangeListener(new AlertController.2(localAlertController, paramBundle, (View)localObject1));
              localAlertController.A.post(new AlertController.3(localAlertController, paramBundle, (View)localObject1));
            }
            else if (localAlertController.g != null)
            {
              localAlertController.g.setOnScrollListener(new AlertController.4(localAlertController, paramBundle, (View)localObject1));
              localAlertController.g.post(new AlertController.5(localAlertController, paramBundle, (View)localObject1));
            }
            else
            {
              if (paramBundle != null) {
                ((ViewGroup)localObject3).removeView(paramBundle);
              }
              if (localObject1 != null) {
                ((ViewGroup)localObject3).removeView((View)localObject1);
              }
            }
          }
        }
      }
    }
    paramBundle = localAlertController.g;
    if ((paramBundle != null) && (localAlertController.H != null))
    {
      paramBundle.setAdapter(localAlertController.H);
      i = localAlertController.I;
      if (i >= 0)
      {
        paramBundle.setItemChecked(i, true);
        paramBundle.setSelection(i);
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AlertController localAlertController = this.a;
    int i;
    if ((localAlertController.A != null) && (localAlertController.A.a(paramKeyEvent))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AlertController localAlertController = this.a;
    int i;
    if ((localAlertController.A != null) && (localAlertController.A.a(paramKeyEvent))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.a.a(paramCharSequence);
  }
  
  public static final class a
  {
    public final AlertController.a a;
    private final int b;
    
    public a(Context paramContext)
    {
      this(paramContext, AlertDialog.a(paramContext, 0));
    }
    
    private a(Context paramContext, int paramInt)
    {
      this.a = new AlertController.a(new ContextThemeWrapper(paramContext, AlertDialog.a(paramContext, paramInt)));
      this.b = paramInt;
    }
    
    public final AlertDialog a()
    {
      AlertDialog localAlertDialog = new AlertDialog(this.a.a, this.b);
      AlertController.a locala = this.a;
      AlertController localAlertController = localAlertDialog.a;
      Object localObject;
      int i;
      if (locala.g != null)
      {
        localAlertController.G = locala.g;
      }
      else
      {
        if (locala.f != null) {
          localAlertController.a(locala.f);
        }
        if (locala.d != null)
        {
          localObject = locala.d;
          localAlertController.C = ((Drawable)localObject);
          localAlertController.B = 0;
          if (localAlertController.D != null) {
            if (localObject != null)
            {
              localAlertController.D.setVisibility(0);
              localAlertController.D.setImageDrawable((Drawable)localObject);
            }
            else
            {
              localAlertController.D.setVisibility(8);
            }
          }
        }
        if (locala.c != 0) {
          localAlertController.a(locala.c);
        }
        if (locala.e != 0)
        {
          i = locala.e;
          localObject = new TypedValue();
          localAlertController.a.getTheme().resolveAttribute(i, (TypedValue)localObject, true);
          localAlertController.a(((TypedValue)localObject).resourceId);
        }
      }
      if (locala.h != null)
      {
        localObject = locala.h;
        localAlertController.f = ((CharSequence)localObject);
        if (localAlertController.F != null) {
          localAlertController.F.setText((CharSequence)localObject);
        }
      }
      if ((locala.i != null) || (locala.j != null)) {
        localAlertController.a(-1, locala.i, locala.k, null, locala.j);
      }
      if ((locala.l != null) || (locala.m != null)) {
        localAlertController.a(-2, locala.l, locala.n, null, locala.m);
      }
      if ((locala.o != null) || (locala.p != null)) {
        localAlertController.a(-3, locala.o, locala.q, null, locala.p);
      }
      if ((locala.v != null) || (locala.K != null) || (locala.w != null))
      {
        AlertController.RecycleListView localRecycleListView = (AlertController.RecycleListView)locala.b.inflate(localAlertController.L, null);
        if (locala.G)
        {
          if (locala.K == null) {
            localObject = new AlertController.a.1(locala, locala.a, localAlertController.M, locala.v, localRecycleListView);
          } else {
            localObject = new AlertController.a.2(locala, locala.a, locala.K, localRecycleListView, localAlertController);
          }
        }
        else
        {
          if (locala.H) {
            i = localAlertController.N;
          } else {
            i = localAlertController.O;
          }
          if (locala.K != null) {
            localObject = new SimpleCursorAdapter(locala.a, i, locala.K, new String[] { locala.L }, new int[] { 16908308 });
          } else if (locala.w != null) {
            localObject = locala.w;
          } else {
            localObject = new AlertController.c(locala.a, i, locala.v);
          }
        }
        localAlertController.H = ((ListAdapter)localObject);
        localAlertController.I = locala.I;
        if (locala.x != null) {
          localRecycleListView.setOnItemClickListener(new AlertController.a.3(locala, localAlertController));
        } else if (locala.J != null) {
          localRecycleListView.setOnItemClickListener(new AlertController.a.4(locala, localRecycleListView, localAlertController));
        }
        if (locala.N != null) {
          localRecycleListView.setOnItemSelectedListener(locala.N);
        }
        if (locala.H) {
          localRecycleListView.setChoiceMode(1);
        } else if (locala.G) {
          localRecycleListView.setChoiceMode(2);
        }
        localAlertController.g = localRecycleListView;
      }
      if (locala.z != null)
      {
        if (locala.E)
        {
          localObject = locala.z;
          i = locala.A;
          int j = locala.B;
          int k = locala.C;
          int m = locala.D;
          localAlertController.h = ((View)localObject);
          localAlertController.i = 0;
          localAlertController.n = true;
          localAlertController.j = i;
          localAlertController.k = j;
          localAlertController.l = k;
          localAlertController.m = m;
        }
        else
        {
          localAlertController.h = locala.z;
          localAlertController.i = 0;
          localAlertController.n = false;
        }
      }
      else if (locala.y != 0)
      {
        i = locala.y;
        localAlertController.h = null;
        localAlertController.i = i;
        localAlertController.n = false;
      }
      localAlertDialog.setCancelable(this.a.r);
      if (this.a.r) {
        localAlertDialog.setCanceledOnTouchOutside(true);
      }
      localAlertDialog.setOnCancelListener(this.a.s);
      localAlertDialog.setOnDismissListener(this.a.t);
      if (this.a.u != null) {
        localAlertDialog.setOnKeyListener(this.a.u);
      }
      return localAlertDialog;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AlertDialog
 * JD-Core Version:    0.7.0.1
 */