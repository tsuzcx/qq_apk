package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.token.da;
import com.tencent.token.er;
import com.tencent.token.fc;
import com.tencent.token.fl;
import com.tencent.token.fo;
import com.tencent.token.fr;
import com.tencent.token.ft;
import com.tencent.token.fv;
import com.tencent.token.gn;
import com.tencent.token.gv;
import com.tencent.token.gx;
import com.tencent.token.hc;
import com.tencent.token.hf;
import com.tencent.token.hg.a;
import com.tencent.token.hg.c;
import com.tencent.token.hg.f;
import com.tencent.token.hg.g;
import com.tencent.token.hg.i;
import com.tencent.token.hg.j;
import com.tencent.token.hi;
import com.tencent.token.ho;
import com.tencent.token.ho.a;
import com.tencent.token.hq;
import com.tencent.token.hr;
import com.tencent.token.ib;
import com.tencent.token.id;
import com.tencent.token.id.a;
import com.tencent.token.ik;
import com.tencent.token.ik.a;
import com.tencent.token.il;
import com.tencent.token.iy;
import com.tencent.token.jg;
import com.tencent.token.jk;
import com.tencent.token.jk.a;
import com.tencent.token.jt;
import com.tencent.token.kb;
import com.tencent.token.kc;
import java.lang.reflect.Constructor;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public class AppCompatDelegateImplV9
  extends gx
  implements LayoutInflater.Factory2, id.a
{
  private static final boolean o;
  private ViewGroup A;
  private TextView B;
  private View C;
  private boolean D;
  private boolean E;
  private boolean F;
  private PanelFeatureState[] G;
  private PanelFeatureState H;
  private boolean I;
  private final Runnable J = new Runnable()
  {
    public final void run()
    {
      if ((AppCompatDelegateImplV9.this.v & 0x1) != 0) {
        AppCompatDelegateImplV9.this.h(0);
      }
      if ((AppCompatDelegateImplV9.this.v & 0x1000) != 0) {
        AppCompatDelegateImplV9.this.h(108);
      }
      AppCompatDelegateImplV9 localAppCompatDelegateImplV9 = AppCompatDelegateImplV9.this;
      localAppCompatDelegateImplV9.u = false;
      localAppCompatDelegateImplV9.v = 0;
    }
  };
  private boolean K;
  private Rect L;
  private Rect M;
  private AppCompatViewInflater N;
  ho p;
  ActionBarContextView q;
  PopupWindow r;
  Runnable s;
  fr t = null;
  boolean u;
  int v;
  private jg w;
  private a x;
  private d y;
  private boolean z;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 21) {
      bool = true;
    } else {
      bool = false;
    }
    o = bool;
  }
  
  protected AppCompatDelegateImplV9(Context paramContext, Window paramWindow, gv paramgv)
  {
    super(paramContext, paramWindow, paramgv);
  }
  
  private View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (this.N == null)
    {
      localObject1 = this.b.obtainStyledAttributes(hg.j.AppCompatTheme).getString(hg.j.AppCompatTheme_viewInflaterClass);
      if ((localObject1 == null) || (AppCompatViewInflater.class.getName().equals(localObject1))) {}
    }
    try
    {
      this.N = ((AppCompatViewInflater)Class.forName((String)localObject1).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    }
    catch (Throwable localThrowable)
    {
      label75:
      Object localObject2;
      boolean bool1;
      AppCompatViewInflater localAppCompatViewInflater;
      boolean bool2;
      boolean bool3;
      int i;
      int j;
      break label75;
    }
    localObject2 = new StringBuilder("Failed to instantiate custom view inflater ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(". Falling back to default.");
    this.N = new AppCompatViewInflater();
    break label127;
    this.N = new AppCompatViewInflater();
    label127:
    if (o)
    {
      if ((paramAttributeSet instanceof XmlPullParser))
      {
        if (((XmlPullParser)paramAttributeSet).getDepth() > 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
      }
      else {
        bool1 = a((ViewParent)paramView);
      }
    }
    else {
      bool1 = false;
    }
    localAppCompatViewInflater = this.N;
    bool2 = o;
    bool3 = kb.a();
    if ((bool1) && (paramView != null)) {
      paramView = paramView.getContext();
    } else {
      paramView = paramContext;
    }
    Object localObject1 = paramView.obtainStyledAttributes(paramAttributeSet, hg.j.View, 0, 0);
    if (bool2) {
      i = ((TypedArray)localObject1).getResourceId(hg.j.View_android_theme, 0);
    } else {
      i = 0;
    }
    j = i;
    if (i == 0) {
      j = ((TypedArray)localObject1).getResourceId(hg.j.View_theme, 0);
    }
    ((TypedArray)localObject1).recycle();
    localObject1 = paramView;
    if (j != 0) {
      if ((paramView instanceof hq))
      {
        localObject1 = paramView;
        if (((hq)paramView).a == j) {}
      }
      else
      {
        localObject1 = new hq(paramView, j);
      }
    }
    localObject2 = localObject1;
    if (bool3) {
      localObject2 = jt.a((Context)localObject1);
    }
    i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 2001146706: 
      if (paramString.equals("Button")) {
        i = 2;
      }
      break;
    case 1666676343: 
      if (paramString.equals("EditText")) {
        i = 3;
      }
      break;
    case 1601505219: 
      if (paramString.equals("CheckBox")) {
        i = 6;
      }
      break;
    case 1413872058: 
      if (paramString.equals("AutoCompleteTextView")) {
        i = 9;
      }
      break;
    case 1125864064: 
      if (paramString.equals("ImageView")) {
        i = 1;
      }
      break;
    case 776382189: 
      if (paramString.equals("RadioButton")) {
        i = 7;
      }
      break;
    case -339785223: 
      if (paramString.equals("Spinner")) {
        i = 4;
      }
      break;
    case -658531749: 
      if (paramString.equals("SeekBar")) {
        i = 12;
      }
      break;
    case -937446323: 
      if (paramString.equals("ImageButton")) {
        i = 5;
      }
      break;
    case -938935918: 
      if (paramString.equals("TextView")) {
        i = 0;
      }
      break;
    case -1346021293: 
      if (paramString.equals("MultiAutoCompleteTextView")) {
        i = 10;
      }
      break;
    case -1455429095: 
      if (paramString.equals("CheckedTextView")) {
        i = 8;
      }
      break;
    case -1946472170: 
      if (paramString.equals("RatingBar")) {
        i = 11;
      }
      break;
    }
    switch (i)
    {
    default: 
      paramView = null;
      break;
    case 12: 
      paramView = new AppCompatSeekBar((Context)localObject2, paramAttributeSet);
      break;
    case 11: 
      paramView = new AppCompatRatingBar((Context)localObject2, paramAttributeSet);
      break;
    case 10: 
      paramView = new AppCompatMultiAutoCompleteTextView((Context)localObject2, paramAttributeSet);
      break;
    case 9: 
      paramView = new AppCompatAutoCompleteTextView((Context)localObject2, paramAttributeSet);
      break;
    case 8: 
      paramView = new AppCompatCheckedTextView((Context)localObject2, paramAttributeSet);
      break;
    case 7: 
      paramView = new AppCompatRadioButton((Context)localObject2, paramAttributeSet);
      break;
    case 6: 
      paramView = new AppCompatCheckBox((Context)localObject2, paramAttributeSet);
      break;
    case 5: 
      paramView = new AppCompatImageButton((Context)localObject2, paramAttributeSet);
      break;
    case 4: 
      paramView = new AppCompatSpinner((Context)localObject2, paramAttributeSet);
      break;
    case 3: 
      paramView = new AppCompatEditText((Context)localObject2, paramAttributeSet);
      break;
    case 2: 
      paramView = new AppCompatButton((Context)localObject2, paramAttributeSet);
      break;
    case 1: 
      paramView = new AppCompatImageView((Context)localObject2, paramAttributeSet);
      break;
    case 0: 
      paramView = new AppCompatTextView((Context)localObject2, paramAttributeSet);
    }
    localObject1 = paramView;
    if (paramView == null)
    {
      localObject1 = paramView;
      if (paramContext != localObject2) {
        localObject1 = localAppCompatViewInflater.a((Context)localObject2, paramString, paramAttributeSet);
      }
    }
    if (localObject1 != null)
    {
      paramView = ((View)localObject1).getContext();
      if ((paramView instanceof ContextWrapper))
      {
        if ((Build.VERSION.SDK_INT >= 15) && (!fo.t((View)localObject1))) {
          return localObject1;
        }
        paramView = paramView.obtainStyledAttributes(paramAttributeSet, AppCompatViewInflater.a);
        paramString = paramView.getString(0);
        if (paramString != null) {
          ((View)localObject1).setOnClickListener(new AppCompatViewInflater.a((View)localObject1, paramString));
        }
        paramView.recycle();
      }
    }
    return localObject1;
  }
  
  private void a(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (!paramPanelFeatureState.o)
    {
      if (this.n) {
        return;
      }
      if (paramPanelFeatureState.a == 0)
      {
        if ((this.b.getResources().getConfiguration().screenLayout & 0xF) == 4) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          return;
        }
      }
      Object localObject = this.c.getCallback();
      if ((localObject != null) && (!((Window.Callback)localObject).onMenuOpened(paramPanelFeatureState.a, paramPanelFeatureState.j)))
      {
        a(paramPanelFeatureState, true);
        return;
      }
      WindowManager localWindowManager = (WindowManager)this.b.getSystemService("window");
      if (localWindowManager == null) {
        return;
      }
      if (!b(paramPanelFeatureState, paramKeyEvent)) {
        return;
      }
      if ((paramPanelFeatureState.g != null) && (!paramPanelFeatureState.q))
      {
        if (paramPanelFeatureState.i != null)
        {
          paramKeyEvent = paramPanelFeatureState.i.getLayoutParams();
          if ((paramKeyEvent != null) && (paramKeyEvent.width == -1))
          {
            i = -1;
            break label343;
          }
        }
      }
      else
      {
        if (paramPanelFeatureState.g == null)
        {
          a(paramPanelFeatureState);
          if (paramPanelFeatureState.g != null) {}
        }
        else if ((paramPanelFeatureState.q) && (paramPanelFeatureState.g.getChildCount() > 0))
        {
          paramPanelFeatureState.g.removeAllViews();
        }
        if (!c(paramPanelFeatureState)) {
          break label409;
        }
        if (!paramPanelFeatureState.a()) {
          return;
        }
        localObject = paramPanelFeatureState.h.getLayoutParams();
        paramKeyEvent = (KeyEvent)localObject;
        if (localObject == null) {
          paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
        }
        i = paramPanelFeatureState.b;
        paramPanelFeatureState.g.setBackgroundResource(i);
        localObject = paramPanelFeatureState.h.getParent();
        if ((localObject != null) && ((localObject instanceof ViewGroup))) {
          ((ViewGroup)localObject).removeView(paramPanelFeatureState.h);
        }
        paramPanelFeatureState.g.addView(paramPanelFeatureState.h, paramKeyEvent);
        if (!paramPanelFeatureState.h.hasFocus()) {
          paramPanelFeatureState.h.requestFocus();
        }
      }
      int i = -2;
      label343:
      paramPanelFeatureState.n = false;
      paramKeyEvent = new WindowManager.LayoutParams(i, -2, paramPanelFeatureState.d, paramPanelFeatureState.e, 1002, 8519680, -3);
      paramKeyEvent.gravity = paramPanelFeatureState.c;
      paramKeyEvent.windowAnimations = paramPanelFeatureState.f;
      localWindowManager.addView(paramPanelFeatureState.g, paramKeyEvent);
      paramPanelFeatureState.o = true;
      return;
      label409:
      return;
    }
  }
  
  private boolean a(PanelFeatureState paramPanelFeatureState)
  {
    paramPanelFeatureState.a(n());
    paramPanelFeatureState.g = new c(paramPanelFeatureState.l);
    paramPanelFeatureState.c = 81;
    return true;
  }
  
  private boolean a(PanelFeatureState paramPanelFeatureState, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool1 = paramKeyEvent.isSystem();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if (!paramPanelFeatureState.m)
    {
      bool1 = bool2;
      if (!b(paramPanelFeatureState, paramKeyEvent)) {}
    }
    else
    {
      bool1 = bool2;
      if (paramPanelFeatureState.j != null) {
        bool1 = paramPanelFeatureState.j.performShortcut(paramInt, paramKeyEvent, 1);
      }
    }
    return bool1;
  }
  
  private boolean a(ViewParent paramViewParent)
  {
    if (paramViewParent == null) {
      return false;
    }
    View localView = this.c.getDecorView();
    for (;;)
    {
      if (paramViewParent == null) {
        return true;
      }
      if ((paramViewParent == localView) || (!(paramViewParent instanceof View))) {
        break;
      }
      if (fo.s((View)paramViewParent)) {
        return false;
      }
      paramViewParent = paramViewParent.getParent();
    }
    return false;
  }
  
  private boolean b(PanelFeatureState paramPanelFeatureState)
  {
    Context localContext = this.b;
    if (paramPanelFeatureState.a != 0)
    {
      localObject1 = localContext;
      if (paramPanelFeatureState.a != 108) {}
    }
    else
    {
      localObject1 = localContext;
      if (this.w != null)
      {
        TypedValue localTypedValue = new TypedValue();
        Resources.Theme localTheme = localContext.getTheme();
        localTheme.resolveAttribute(hg.a.actionBarTheme, localTypedValue, true);
        localObject1 = null;
        if (localTypedValue.resourceId != 0)
        {
          localObject1 = localContext.getResources().newTheme();
          ((Resources.Theme)localObject1).setTo(localTheme);
          ((Resources.Theme)localObject1).applyStyle(localTypedValue.resourceId, true);
          ((Resources.Theme)localObject1).resolveAttribute(hg.a.actionBarWidgetTheme, localTypedValue, true);
        }
        else
        {
          localTheme.resolveAttribute(hg.a.actionBarWidgetTheme, localTypedValue, true);
        }
        Object localObject2 = localObject1;
        if (localTypedValue.resourceId != 0)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localContext.getResources().newTheme();
            ((Resources.Theme)localObject2).setTo(localTheme);
          }
          ((Resources.Theme)localObject2).applyStyle(localTypedValue.resourceId, true);
        }
        localObject1 = localContext;
        if (localObject2 != null)
        {
          localObject1 = new hq(localContext, 0);
          ((Context)localObject1).getTheme().setTo((Resources.Theme)localObject2);
        }
      }
    }
    Object localObject1 = new id((Context)localObject1);
    ((id)localObject1).a(this);
    paramPanelFeatureState.a((id)localObject1);
    return true;
  }
  
  private boolean b(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (this.n) {
      return false;
    }
    if (paramPanelFeatureState.m) {
      return true;
    }
    Object localObject = this.H;
    if ((localObject != null) && (localObject != paramPanelFeatureState)) {
      a((PanelFeatureState)localObject, false);
    }
    localObject = this.c.getCallback();
    if (localObject != null) {
      paramPanelFeatureState.i = ((Window.Callback)localObject).onCreatePanelView(paramPanelFeatureState.a);
    }
    int i;
    if ((paramPanelFeatureState.a != 0) && (paramPanelFeatureState.a != 108)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      jg localjg = this.w;
      if (localjg != null) {
        localjg.g();
      }
    }
    if ((paramPanelFeatureState.i == null) && ((i == 0) || (!(this.g instanceof hc))))
    {
      if ((paramPanelFeatureState.j == null) || (paramPanelFeatureState.r))
      {
        if (paramPanelFeatureState.j == null)
        {
          b(paramPanelFeatureState);
          if (paramPanelFeatureState.j == null) {
            return false;
          }
        }
        if ((i != 0) && (this.w != null))
        {
          if (this.x == null) {
            this.x = new a();
          }
          this.w.a(paramPanelFeatureState.j, this.x);
        }
        paramPanelFeatureState.j.d();
        if (!((Window.Callback)localObject).onCreatePanelMenu(paramPanelFeatureState.a, paramPanelFeatureState.j))
        {
          paramPanelFeatureState.a(null);
          if (i != 0)
          {
            paramPanelFeatureState = this.w;
            if (paramPanelFeatureState != null) {
              paramPanelFeatureState.a(null, this.x);
            }
          }
          return false;
        }
        paramPanelFeatureState.r = false;
      }
      paramPanelFeatureState.j.d();
      if (paramPanelFeatureState.s != null)
      {
        paramPanelFeatureState.j.b(paramPanelFeatureState.s);
        paramPanelFeatureState.s = null;
      }
      if (!((Window.Callback)localObject).onPreparePanel(0, paramPanelFeatureState.i, paramPanelFeatureState.j))
      {
        if (i != 0)
        {
          paramKeyEvent = this.w;
          if (paramKeyEvent != null) {
            paramKeyEvent.a(null, this.x);
          }
        }
        paramPanelFeatureState.j.e();
        return false;
      }
      if (paramKeyEvent != null) {
        i = paramKeyEvent.getDeviceId();
      } else {
        i = -1;
      }
      boolean bool;
      if (KeyCharacterMap.load(i).getKeyboardType() != 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramPanelFeatureState.p = bool;
      paramPanelFeatureState.j.setQwertyMode(paramPanelFeatureState.p);
      paramPanelFeatureState.j.e();
    }
    paramPanelFeatureState.m = true;
    paramPanelFeatureState.n = false;
    this.H = paramPanelFeatureState;
    return true;
  }
  
  private boolean c(PanelFeatureState paramPanelFeatureState)
  {
    if (paramPanelFeatureState.i != null)
    {
      paramPanelFeatureState.h = paramPanelFeatureState.i;
      return true;
    }
    if (paramPanelFeatureState.j == null) {
      return false;
    }
    if (this.y == null) {
      this.y = new d();
    }
    paramPanelFeatureState.h = ((View)paramPanelFeatureState.a(this.y));
    return paramPanelFeatureState.h != null;
  }
  
  private void f(int paramInt)
  {
    this.v = (1 << paramInt | this.v);
    if (!this.u)
    {
      fo.a(this.c.getDecorView(), this.J);
      this.u = true;
    }
  }
  
  private static int j(int paramInt)
  {
    if (paramInt == 8) {
      return 108;
    }
    if (paramInt == 9) {
      return 109;
    }
    return paramInt;
  }
  
  private void t()
  {
    if (!this.z)
    {
      this.A = u();
      Object localObject = o();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        b((CharSequence)localObject);
      }
      v();
      this.z = true;
      localObject = g(0);
      if ((!this.n) && ((localObject == null) || (((PanelFeatureState)localObject).j == null))) {
        f(108);
      }
    }
  }
  
  private ViewGroup u()
  {
    Object localObject1 = this.b.obtainStyledAttributes(hg.j.AppCompatTheme);
    if (((TypedArray)localObject1).hasValue(hg.j.AppCompatTheme_windowActionBar))
    {
      if (((TypedArray)localObject1).getBoolean(hg.j.AppCompatTheme_windowNoTitle, false)) {
        c(1);
      } else if (((TypedArray)localObject1).getBoolean(hg.j.AppCompatTheme_windowActionBar, false)) {
        c(108);
      }
      if (((TypedArray)localObject1).getBoolean(hg.j.AppCompatTheme_windowActionBarOverlay, false)) {
        c(109);
      }
      if (((TypedArray)localObject1).getBoolean(hg.j.AppCompatTheme_windowActionModeOverlay, false)) {
        c(10);
      }
      this.l = ((TypedArray)localObject1).getBoolean(hg.j.AppCompatTheme_android_windowIsFloating, false);
      ((TypedArray)localObject1).recycle();
      this.c.getDecorView();
      localObject1 = LayoutInflater.from(this.b);
      Object localObject2;
      if (!this.m)
      {
        if (this.l)
        {
          localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(hg.g.abc_dialog_title_material, null);
          this.j = false;
          this.i = false;
        }
        else if (this.i)
        {
          localObject1 = new TypedValue();
          this.b.getTheme().resolveAttribute(hg.a.actionBarTheme, (TypedValue)localObject1, true);
          if (((TypedValue)localObject1).resourceId != 0) {
            localObject1 = new hq(this.b, ((TypedValue)localObject1).resourceId);
          } else {
            localObject1 = this.b;
          }
          localObject2 = (ViewGroup)LayoutInflater.from((Context)localObject1).inflate(hg.g.abc_screen_toolbar, null);
          this.w = ((jg)((ViewGroup)localObject2).findViewById(hg.f.decor_content_parent));
          this.w.setWindowCallback(this.c.getCallback());
          if (this.j) {
            this.w.a(109);
          }
          if (this.D) {
            this.w.a(2);
          }
          localObject1 = localObject2;
          if (this.E)
          {
            this.w.a(5);
            localObject1 = localObject2;
          }
        }
        else
        {
          localObject1 = null;
        }
      }
      else
      {
        if (this.k) {
          localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(hg.g.abc_screen_simple_overlay_action_mode, null);
        } else {
          localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(hg.g.abc_screen_simple, null);
        }
        if (Build.VERSION.SDK_INT >= 21) {
          fo.a((View)localObject1, new fl()
          {
            public final fv a(View paramAnonymousView, fv paramAnonymousfv)
            {
              int i = paramAnonymousfv.b();
              int j = AppCompatDelegateImplV9.this.i(i);
              fv localfv = paramAnonymousfv;
              if (i != j) {
                localfv = paramAnonymousfv.a(paramAnonymousfv.a(), j, paramAnonymousfv.c(), paramAnonymousfv.d());
              }
              return fo.a(paramAnonymousView, localfv);
            }
          });
        } else {
          ((jk)localObject1).setOnFitSystemWindowsListener(new jk.a()
          {
            public final void a(Rect paramAnonymousRect)
            {
              paramAnonymousRect.top = AppCompatDelegateImplV9.this.i(paramAnonymousRect.top);
            }
          });
        }
      }
      if (localObject1 != null)
      {
        if (this.w == null) {
          this.B = ((TextView)((ViewGroup)localObject1).findViewById(hg.f.title));
        }
        kc.b((View)localObject1);
        localObject2 = (ContentFrameLayout)((ViewGroup)localObject1).findViewById(hg.f.action_bar_activity_content);
        ViewGroup localViewGroup = (ViewGroup)this.c.findViewById(16908290);
        if (localViewGroup != null)
        {
          while (localViewGroup.getChildCount() > 0)
          {
            View localView = localViewGroup.getChildAt(0);
            localViewGroup.removeViewAt(0);
            ((ContentFrameLayout)localObject2).addView(localView);
          }
          localViewGroup.setId(-1);
          ((ContentFrameLayout)localObject2).setId(16908290);
          if ((localViewGroup instanceof FrameLayout)) {
            ((FrameLayout)localViewGroup).setForeground(null);
          }
        }
        this.c.setContentView((View)localObject1);
        ((ContentFrameLayout)localObject2).setAttachListener(new ContentFrameLayout.a()
        {
          public final void a()
          {
            AppCompatDelegateImplV9.this.s();
          }
        });
        return localObject1;
      }
      localObject1 = new StringBuilder("AppCompat does not support the current theme features: { windowActionBar: ");
      ((StringBuilder)localObject1).append(this.i);
      ((StringBuilder)localObject1).append(", windowActionBarOverlay: ");
      ((StringBuilder)localObject1).append(this.j);
      ((StringBuilder)localObject1).append(", android:windowIsFloating: ");
      ((StringBuilder)localObject1).append(this.l);
      ((StringBuilder)localObject1).append(", windowActionModeOverlay: ");
      ((StringBuilder)localObject1).append(this.k);
      ((StringBuilder)localObject1).append(", windowNoTitle: ");
      ((StringBuilder)localObject1).append(this.m);
      ((StringBuilder)localObject1).append(" }");
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
    }
    ((TypedArray)localObject1).recycle();
    throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
  }
  
  private void v()
  {
    ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)this.A.findViewById(16908290);
    Object localObject = this.c.getDecorView();
    localContentFrameLayout.a(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
    localObject = this.b.obtainStyledAttributes(hg.j.AppCompatTheme);
    ((TypedArray)localObject).getValue(hg.j.AppCompatTheme_windowMinWidthMajor, localContentFrameLayout.getMinWidthMajor());
    ((TypedArray)localObject).getValue(hg.j.AppCompatTheme_windowMinWidthMinor, localContentFrameLayout.getMinWidthMinor());
    if (((TypedArray)localObject).hasValue(hg.j.AppCompatTheme_windowFixedWidthMajor)) {
      ((TypedArray)localObject).getValue(hg.j.AppCompatTheme_windowFixedWidthMajor, localContentFrameLayout.getFixedWidthMajor());
    }
    if (((TypedArray)localObject).hasValue(hg.j.AppCompatTheme_windowFixedWidthMinor)) {
      ((TypedArray)localObject).getValue(hg.j.AppCompatTheme_windowFixedWidthMinor, localContentFrameLayout.getFixedWidthMinor());
    }
    if (((TypedArray)localObject).hasValue(hg.j.AppCompatTheme_windowFixedHeightMajor)) {
      ((TypedArray)localObject).getValue(hg.j.AppCompatTheme_windowFixedHeightMajor, localContentFrameLayout.getFixedHeightMajor());
    }
    if (((TypedArray)localObject).hasValue(hg.j.AppCompatTheme_windowFixedHeightMinor)) {
      ((TypedArray)localObject).getValue(hg.j.AppCompatTheme_windowFixedHeightMinor, localContentFrameLayout.getFixedHeightMinor());
    }
    ((TypedArray)localObject).recycle();
    localContentFrameLayout.requestLayout();
  }
  
  private void w()
  {
    if (!this.z) {
      return;
    }
    throw new AndroidRuntimeException("Window feature must be requested before adding content");
  }
  
  final PanelFeatureState a(Menu paramMenu)
  {
    PanelFeatureState[] arrayOfPanelFeatureState = this.G;
    int j = 0;
    int i;
    if (arrayOfPanelFeatureState != null) {
      i = arrayOfPanelFeatureState.length;
    } else {
      i = 0;
    }
    while (j < i)
    {
      PanelFeatureState localPanelFeatureState = arrayOfPanelFeatureState[j];
      if ((localPanelFeatureState != null) && (localPanelFeatureState.j == paramMenu)) {
        return localPanelFeatureState;
      }
      j += 1;
    }
    return null;
  }
  
  public final <T extends View> T a(int paramInt)
  {
    t();
    return this.c.findViewById(paramInt);
  }
  
  protected View a(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if ((this.d instanceof LayoutInflater.Factory))
    {
      paramString = ((LayoutInflater.Factory)this.d).onCreateView(paramString, paramContext, paramAttributeSet);
      if (paramString != null) {
        return paramString;
      }
    }
    return null;
  }
  
  public final ho a(ho.a parama)
  {
    if (parama != null)
    {
      Object localObject = this.p;
      if (localObject != null) {
        ((ho)localObject).c();
      }
      parama = new b(parama);
      localObject = a();
      if (localObject != null)
      {
        this.p = ((ActionBar)localObject).a(parama);
        if ((this.p != null) && (this.f != null)) {
          this.f.onSupportActionModeStarted(this.p);
        }
      }
      if (this.p == null) {
        this.p = b(parama);
      }
      return this.p;
    }
    throw new IllegalArgumentException("ActionMode callback can not be null.");
  }
  
  final void a(int paramInt, PanelFeatureState paramPanelFeatureState, Menu paramMenu)
  {
    Object localObject1 = paramPanelFeatureState;
    Object localObject2 = paramMenu;
    if (paramMenu == null)
    {
      PanelFeatureState localPanelFeatureState = paramPanelFeatureState;
      if (paramPanelFeatureState == null)
      {
        localPanelFeatureState = paramPanelFeatureState;
        if (paramInt >= 0)
        {
          localObject1 = this.G;
          localPanelFeatureState = paramPanelFeatureState;
          if (paramInt < localObject1.length) {
            localPanelFeatureState = localObject1[paramInt];
          }
        }
      }
      localObject1 = localPanelFeatureState;
      localObject2 = paramMenu;
      if (localPanelFeatureState != null)
      {
        localObject2 = localPanelFeatureState.j;
        localObject1 = localPanelFeatureState;
      }
    }
    if ((localObject1 != null) && (!((PanelFeatureState)localObject1).o)) {
      return;
    }
    if (!this.n) {
      this.d.onPanelClosed(paramInt, (Menu)localObject2);
    }
  }
  
  public final void a(Configuration arg1)
  {
    if ((this.i) && (this.z))
    {
      localObject1 = a();
      if (localObject1 != null) {
        ((ActionBar)localObject1).a(???);
      }
    }
    Object localObject1 = iy.a();
    Object localObject3 = this.b;
    for (;;)
    {
      int j;
      int i;
      synchronized (((iy)localObject1).a)
      {
        localObject1 = (er)((iy)localObject1).b.get(localObject3);
        if (localObject1 != null)
        {
          j = ((er)localObject1).e;
          localObject3 = ((er)localObject1).d;
          i = 0;
          break label115;
          ((er)localObject1).e = 0;
          ((er)localObject1).b = false;
        }
        else
        {
          k();
          return;
        }
      }
      label115:
      while (i < j)
      {
        localObject3[i] = null;
        i += 1;
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (((this.d instanceof Activity)) && (da.b((Activity)this.d) != null))
    {
      paramBundle = this.g;
      if (paramBundle == null)
      {
        this.K = true;
        return;
      }
      paramBundle.a(true);
    }
  }
  
  final void a(PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramPanelFeatureState.a == 0))
    {
      localObject = this.w;
      if ((localObject != null) && (((jg)localObject).c()))
      {
        b(paramPanelFeatureState.j);
        return;
      }
    }
    Object localObject = (WindowManager)this.b.getSystemService("window");
    if ((localObject != null) && (paramPanelFeatureState.o) && (paramPanelFeatureState.g != null))
    {
      ((WindowManager)localObject).removeView(paramPanelFeatureState.g);
      if (paramBoolean) {
        a(paramPanelFeatureState.a, paramPanelFeatureState, null);
      }
    }
    paramPanelFeatureState.m = false;
    paramPanelFeatureState.n = false;
    paramPanelFeatureState.o = false;
    paramPanelFeatureState.h = null;
    paramPanelFeatureState.q = true;
    if (this.H == paramPanelFeatureState) {
      this.H = null;
    }
  }
  
  public final void a(Toolbar paramToolbar)
  {
    if (!(this.d instanceof Activity)) {
      return;
    }
    ActionBar localActionBar = a();
    if (!(localActionBar instanceof hf))
    {
      this.h = null;
      if (localActionBar != null) {
        localActionBar.h();
      }
      if (paramToolbar != null)
      {
        paramToolbar = new hc(paramToolbar, ((Activity)this.d).getTitle(), this.e);
        this.g = paramToolbar;
        this.c.setCallback(paramToolbar.c);
      }
      else
      {
        this.g = null;
        this.c.setCallback(this.e);
      }
      g();
      return;
    }
    throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
  }
  
  public final void a(View paramView)
  {
    t();
    ViewGroup localViewGroup = (ViewGroup)this.A.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.d.onContentChanged();
  }
  
  public final void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    t();
    ViewGroup localViewGroup = (ViewGroup)this.A.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.d.onContentChanged();
  }
  
  public final void a(id paramid)
  {
    paramid = this.w;
    if ((paramid != null) && (paramid.b()) && ((!ViewConfiguration.get(this.b).hasPermanentMenuKey()) || (this.w.d())))
    {
      paramid = this.c.getCallback();
      if (!this.w.c())
      {
        if ((paramid != null) && (!this.n))
        {
          if ((this.u) && ((0x1 & this.v) != 0))
          {
            this.c.getDecorView().removeCallbacks(this.J);
            this.J.run();
          }
          PanelFeatureState localPanelFeatureState = g(0);
          if ((localPanelFeatureState.j != null) && (!localPanelFeatureState.r) && (paramid.onPreparePanel(0, localPanelFeatureState.i, localPanelFeatureState.j)))
          {
            paramid.onMenuOpened(108, localPanelFeatureState.j);
            this.w.e();
          }
        }
      }
      else
      {
        this.w.f();
        if (!this.n) {
          paramid.onPanelClosed(108, g(0).j);
        }
      }
      return;
    }
    paramid = g(0);
    paramid.q = true;
    a(paramid, false);
    a(paramid, null);
  }
  
  public final boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = a();
    if ((localObject != null) && (((ActionBar)localObject).a(paramInt, paramKeyEvent))) {
      return true;
    }
    localObject = this.H;
    if ((localObject != null) && (a((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      paramKeyEvent = this.H;
      if (paramKeyEvent != null) {
        paramKeyEvent.n = true;
      }
      return true;
    }
    if (this.H == null)
    {
      localObject = g(0);
      b((PanelFeatureState)localObject, paramKeyEvent);
      boolean bool = a((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent);
      ((PanelFeatureState)localObject).m = false;
      if (bool) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean a(KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getKeyCode();
    boolean bool = true;
    if ((i == 82) && (this.d.dispatchKeyEvent(paramKeyEvent))) {
      return true;
    }
    int j = paramKeyEvent.getKeyCode();
    if (paramKeyEvent.getAction() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    PanelFeatureState localPanelFeatureState;
    if (i != 0)
    {
      if (j != 4)
      {
        if (j != 82) {
          return false;
        }
        if (paramKeyEvent.getRepeatCount() == 0)
        {
          localPanelFeatureState = g(0);
          if (!localPanelFeatureState.o) {
            b(localPanelFeatureState, paramKeyEvent);
          }
        }
        return true;
      }
      if ((paramKeyEvent.getFlags() & 0x80) == 0) {
        bool = false;
      }
      this.I = bool;
      return false;
    }
    if (j != 4)
    {
      if (j != 82) {
        return false;
      }
      if (this.p == null)
      {
        localPanelFeatureState = g(0);
        jg localjg = this.w;
        if ((localjg != null) && (localjg.b()) && (!ViewConfiguration.get(this.b).hasPermanentMenuKey()))
        {
          if (!this.w.c())
          {
            if ((!this.n) && (b(localPanelFeatureState, paramKeyEvent)))
            {
              bool = this.w.e();
              break label334;
            }
          }
          else
          {
            bool = this.w.f();
            break label334;
          }
        }
        else
        {
          if ((localPanelFeatureState.o) || (localPanelFeatureState.n)) {
            break label320;
          }
          if (localPanelFeatureState.m)
          {
            if (localPanelFeatureState.r)
            {
              localPanelFeatureState.m = false;
              bool = b(localPanelFeatureState, paramKeyEvent);
            }
            else
            {
              bool = true;
            }
            if (bool)
            {
              a(localPanelFeatureState, paramKeyEvent);
              bool = true;
              break label334;
            }
          }
        }
        bool = false;
        break label334;
        label320:
        bool = localPanelFeatureState.o;
        a(localPanelFeatureState, true);
        label334:
        if (bool)
        {
          paramKeyEvent = (AudioManager)this.b.getSystemService("audio");
          if (paramKeyEvent != null) {
            paramKeyEvent.playSoundEffect(0);
          }
        }
      }
      return true;
    }
    bool = this.I;
    this.I = false;
    paramKeyEvent = g(0);
    if ((paramKeyEvent != null) && (paramKeyEvent.o))
    {
      if (!bool) {
        a(paramKeyEvent, true);
      }
      return true;
    }
    paramKeyEvent = this.p;
    if (paramKeyEvent != null)
    {
      paramKeyEvent.c();
      i = 1;
    }
    else
    {
      paramKeyEvent = a();
      if ((paramKeyEvent != null) && (paramKeyEvent.g())) {
        i = 1;
      } else {
        i = 0;
      }
    }
    return i != 0;
  }
  
  public final boolean a(id paramid, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = this.c.getCallback();
    if ((localCallback != null) && (!this.n))
    {
      paramid = a(paramid.k());
      if (paramid != null) {
        return localCallback.onMenuItemSelected(paramid.a, paramMenuItem);
      }
    }
    return false;
  }
  
  public final ho b(ho.a parama)
  {
    q();
    Object localObject1 = this.p;
    if (localObject1 != null) {
      ((ho)localObject1).c();
    }
    if ((this.f != null) && (!this.n)) {}
    try
    {
      localObject1 = this.f.onWindowStartingSupportActionMode(parama);
    }
    catch (AbstractMethodError localAbstractMethodError)
    {
      label49:
      boolean bool;
      Object localObject2;
      Resources.Theme localTheme;
      int i;
      break label49;
    }
    localObject1 = null;
    if (localObject1 != null)
    {
      this.p = ((ho)localObject1);
    }
    else
    {
      localObject1 = this.q;
      bool = true;
      if (localObject1 == null) {
        if (this.l)
        {
          localObject2 = new TypedValue();
          localObject1 = this.b.getTheme();
          ((Resources.Theme)localObject1).resolveAttribute(hg.a.actionBarTheme, (TypedValue)localObject2, true);
          if (((TypedValue)localObject2).resourceId != 0)
          {
            localTheme = this.b.getResources().newTheme();
            localTheme.setTo((Resources.Theme)localObject1);
            localTheme.applyStyle(((TypedValue)localObject2).resourceId, true);
            localObject1 = new hq(this.b, 0);
            ((Context)localObject1).getTheme().setTo(localTheme);
          }
          else
          {
            localObject1 = this.b;
          }
          this.q = new ActionBarContextView((Context)localObject1);
          this.r = new PopupWindow((Context)localObject1, null, hg.a.actionModePopupWindowStyle);
          gn.a(this.r, 2);
          this.r.setContentView(this.q);
          this.r.setWidth(-1);
          ((Context)localObject1).getTheme().resolveAttribute(hg.a.actionBarSize, (TypedValue)localObject2, true);
          i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject2).data, ((Context)localObject1).getResources().getDisplayMetrics());
          this.q.setContentHeight(i);
          this.r.setHeight(-2);
          this.s = new Runnable()
          {
            public final void run()
            {
              AppCompatDelegateImplV9.this.r.showAtLocation(AppCompatDelegateImplV9.this.q, 55, 0, 0);
              AppCompatDelegateImplV9.this.q();
              if (AppCompatDelegateImplV9.this.p())
              {
                AppCompatDelegateImplV9.this.q.setAlpha(0.0F);
                AppCompatDelegateImplV9 localAppCompatDelegateImplV9 = AppCompatDelegateImplV9.this;
                localAppCompatDelegateImplV9.t = fo.f(localAppCompatDelegateImplV9.q).a(1.0F);
                AppCompatDelegateImplV9.this.t.a(new ft()
                {
                  public final void a(View paramAnonymous2View)
                  {
                    AppCompatDelegateImplV9.this.q.setVisibility(0);
                  }
                  
                  public final void b(View paramAnonymous2View)
                  {
                    AppCompatDelegateImplV9.this.q.setAlpha(1.0F);
                    AppCompatDelegateImplV9.this.t.a(null);
                    AppCompatDelegateImplV9.this.t = null;
                  }
                });
                return;
              }
              AppCompatDelegateImplV9.this.q.setAlpha(1.0F);
              AppCompatDelegateImplV9.this.q.setVisibility(0);
            }
          };
        }
        else
        {
          localObject1 = (ViewStubCompat)this.A.findViewById(hg.f.action_mode_bar_stub);
          if (localObject1 != null)
          {
            ((ViewStubCompat)localObject1).setLayoutInflater(LayoutInflater.from(n()));
            this.q = ((ActionBarContextView)((ViewStubCompat)localObject1).a());
          }
        }
      }
      if (this.q != null)
      {
        q();
        this.q.c();
        localObject1 = this.q.getContext();
        localObject2 = this.q;
        if (this.r != null) {
          bool = false;
        }
        localObject1 = new hr((Context)localObject1, (ActionBarContextView)localObject2, parama, bool);
        if (parama.a((ho)localObject1, ((ho)localObject1).b()))
        {
          ((ho)localObject1).d();
          this.q.a((ho)localObject1);
          this.p = ((ho)localObject1);
          if (p())
          {
            this.q.setAlpha(0.0F);
            this.t = fo.f(this.q).a(1.0F);
            this.t.a(new ft()
            {
              public final void a(View paramAnonymousView)
              {
                AppCompatDelegateImplV9.this.q.setVisibility(0);
                AppCompatDelegateImplV9.this.q.sendAccessibilityEvent(32);
                if ((AppCompatDelegateImplV9.this.q.getParent() instanceof View)) {
                  fo.j((View)AppCompatDelegateImplV9.this.q.getParent());
                }
              }
              
              public final void b(View paramAnonymousView)
              {
                AppCompatDelegateImplV9.this.q.setAlpha(1.0F);
                AppCompatDelegateImplV9.this.t.a(null);
                AppCompatDelegateImplV9.this.t = null;
              }
            });
          }
          else
          {
            this.q.setAlpha(1.0F);
            this.q.setVisibility(0);
            this.q.sendAccessibilityEvent(32);
            if ((this.q.getParent() instanceof View)) {
              fo.j((View)this.q.getParent());
            }
          }
          if (this.r != null) {
            this.c.getDecorView().post(this.s);
          }
        }
        else
        {
          this.p = null;
        }
      }
    }
    if ((this.p != null) && (this.f != null)) {
      this.f.onSupportActionModeStarted(this.p);
    }
    return this.p;
  }
  
  public final void b(int paramInt)
  {
    t();
    ViewGroup localViewGroup = (ViewGroup)this.A.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(this.b).inflate(paramInt, localViewGroup);
    this.d.onContentChanged();
  }
  
  public final void b(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    t();
    ((ViewGroup)this.A.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.d.onContentChanged();
  }
  
  final void b(id paramid)
  {
    if (this.F) {
      return;
    }
    this.F = true;
    this.w.h();
    Window.Callback localCallback = this.c.getCallback();
    if ((localCallback != null) && (!this.n)) {
      localCallback.onPanelClosed(108, paramid);
    }
    this.F = false;
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    Object localObject = this.w;
    if (localObject != null)
    {
      ((jg)localObject).setWindowTitle(paramCharSequence);
      return;
    }
    if (this.g != null)
    {
      this.g.a(paramCharSequence);
      return;
    }
    localObject = this.B;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
  }
  
  public final void c()
  {
    t();
  }
  
  public final boolean c(int paramInt)
  {
    paramInt = j(paramInt);
    if ((this.m) && (paramInt == 108)) {
      return false;
    }
    if ((this.i) && (paramInt == 1)) {
      this.i = false;
    }
    switch (paramInt)
    {
    default: 
      return this.c.requestFeature(paramInt);
    case 109: 
      w();
      this.j = true;
      return true;
    case 108: 
      w();
      this.i = true;
      return true;
    case 10: 
      w();
      this.k = true;
      return true;
    case 5: 
      w();
      this.E = true;
      return true;
    case 2: 
      w();
      this.D = true;
      return true;
    }
    w();
    this.m = true;
    return true;
  }
  
  public final void d(int paramInt)
  {
    Object localObject;
    if (paramInt == 108)
    {
      localObject = a();
      if (localObject != null) {
        ((ActionBar)localObject).c(false);
      }
      return;
    }
    if (paramInt == 0)
    {
      localObject = g(paramInt);
      if (((PanelFeatureState)localObject).o) {
        a((PanelFeatureState)localObject, false);
      }
    }
  }
  
  public void e()
  {
    ActionBar localActionBar = a();
    if (localActionBar != null) {
      localActionBar.b(false);
    }
  }
  
  public final boolean e(int paramInt)
  {
    if (paramInt == 108)
    {
      ActionBar localActionBar = a();
      if (localActionBar != null) {
        localActionBar.c(true);
      }
      return true;
    }
    return false;
  }
  
  public final void f()
  {
    ActionBar localActionBar = a();
    if (localActionBar != null) {
      localActionBar.b(true);
    }
  }
  
  public final PanelFeatureState g(int paramInt)
  {
    Object localObject2 = this.G;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > paramInt) {}
    }
    else
    {
      localObject1 = new PanelFeatureState[paramInt + 1];
      if (localObject2 != null) {
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      }
      this.G = ((PanelFeatureState[])localObject1);
    }
    Object localObject3 = localObject1[paramInt];
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = new PanelFeatureState(paramInt);
      localObject1[paramInt] = localObject2;
    }
    return localObject2;
  }
  
  public final void g()
  {
    ActionBar localActionBar = a();
    if ((localActionBar != null) && (localActionBar.f())) {
      return;
    }
    f(0);
  }
  
  public void h()
  {
    if (this.u) {
      this.c.getDecorView().removeCallbacks(this.J);
    }
    super.h();
    if (this.g != null) {
      this.g.h();
    }
  }
  
  final void h(int paramInt)
  {
    PanelFeatureState localPanelFeatureState = g(paramInt);
    if (localPanelFeatureState.j != null)
    {
      Bundle localBundle = new Bundle();
      localPanelFeatureState.j.a(localBundle);
      if (localBundle.size() > 0) {
        localPanelFeatureState.s = localBundle;
      }
      localPanelFeatureState.j.d();
      localPanelFeatureState.j.clear();
    }
    localPanelFeatureState.r = true;
    localPanelFeatureState.q = true;
    if (((paramInt == 108) || (paramInt == 0)) && (this.w != null))
    {
      localPanelFeatureState = g(0);
      if (localPanelFeatureState != null)
      {
        localPanelFeatureState.m = false;
        b(localPanelFeatureState, null);
      }
    }
  }
  
  final int i(int paramInt)
  {
    Object localObject1 = this.q;
    int i1 = 0;
    int i;
    int m;
    if ((localObject1 != null) && ((((ActionBarContextView)localObject1).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.q.getLayoutParams();
      boolean bool = this.q.isShown();
      int n = 1;
      int j;
      int k;
      if (bool)
      {
        if (this.L == null)
        {
          this.L = new Rect();
          this.M = new Rect();
        }
        Object localObject2 = this.L;
        Rect localRect = this.M;
        ((Rect)localObject2).set(0, paramInt, 0, 0);
        kc.a(this.A, (Rect)localObject2, localRect);
        if (localRect.top == 0) {
          i = paramInt;
        } else {
          i = 0;
        }
        if (((ViewGroup.MarginLayoutParams)localObject1).topMargin != i)
        {
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramInt;
          localObject2 = this.C;
          if (localObject2 == null)
          {
            this.C = new View(this.b);
            this.C.setBackgroundColor(this.b.getResources().getColor(hg.c.abc_input_method_navigation_guard));
            this.A.addView(this.C, -1, new ViewGroup.LayoutParams(-1, paramInt));
          }
          else
          {
            localObject2 = ((View)localObject2).getLayoutParams();
            if (((ViewGroup.LayoutParams)localObject2).height != paramInt)
            {
              ((ViewGroup.LayoutParams)localObject2).height = paramInt;
              this.C.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
          }
          m = 1;
        }
        else
        {
          m = 0;
        }
        if (this.C == null) {
          n = 0;
        }
        j = m;
        i = n;
        k = paramInt;
        if (!this.k)
        {
          j = m;
          i = n;
          k = paramInt;
          if (n != 0)
          {
            k = 0;
            j = m;
            i = n;
          }
        }
      }
      else if (((ViewGroup.MarginLayoutParams)localObject1).topMargin != 0)
      {
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;
        j = 1;
        i = 0;
        k = paramInt;
      }
      else
      {
        j = 0;
        i = 0;
        k = paramInt;
      }
      m = i;
      paramInt = k;
      if (j != 0)
      {
        this.q.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        m = i;
        paramInt = k;
      }
    }
    else
    {
      m = 0;
    }
    localObject1 = this.C;
    if (localObject1 != null)
    {
      if (m != 0) {
        i = i1;
      } else {
        i = 8;
      }
      ((View)localObject1).setVisibility(i);
    }
    return paramInt;
  }
  
  public final void j()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.b);
    if (localLayoutInflater.getFactory() == null)
    {
      fc.b(localLayoutInflater, this);
      return;
    }
    localLayoutInflater.getFactory2();
  }
  
  public final void m()
  {
    t();
    if (this.i)
    {
      if (this.g != null) {
        return;
      }
      if ((this.d instanceof Activity)) {
        this.g = new hf((Activity)this.d, this.j);
      } else if ((this.d instanceof Dialog)) {
        this.g = new hf((Dialog)this.d);
      }
      if (this.g != null) {
        this.g.a(this.K);
      }
      return;
    }
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView = a(paramString, paramContext, paramAttributeSet);
    if (localView != null) {
      return localView;
    }
    return a(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  final boolean p()
  {
    if (this.z)
    {
      ViewGroup localViewGroup = this.A;
      if ((localViewGroup != null) && (fo.q(localViewGroup))) {
        return true;
      }
    }
    return false;
  }
  
  final void q()
  {
    fr localfr = this.t;
    if (localfr != null) {
      localfr.b();
    }
  }
  
  final void r()
  {
    a(g(0), true);
  }
  
  final void s()
  {
    Object localObject = this.w;
    if (localObject != null) {
      ((jg)localObject).h();
    }
    if (this.r != null)
    {
      this.c.getDecorView().removeCallbacks(this.s);
      if (!this.r.isShowing()) {}
    }
    try
    {
      this.r.dismiss();
      label54:
      this.r = null;
      q();
      localObject = g(0);
      if ((localObject != null) && (((PanelFeatureState)localObject).j != null)) {
        ((PanelFeatureState)localObject).j.close();
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label54;
    }
  }
  
  public static final class PanelFeatureState
  {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    ViewGroup g;
    View h;
    View i;
    public id j;
    ib k;
    Context l;
    boolean m;
    boolean n;
    boolean o;
    public boolean p;
    boolean q;
    boolean r;
    Bundle s;
    
    PanelFeatureState(int paramInt)
    {
      this.a = paramInt;
      this.q = false;
    }
    
    final il a(ik.a parama)
    {
      if (this.j == null) {
        return null;
      }
      if (this.k == null)
      {
        this.k = new ib(this.l, hg.g.abc_list_menu_item_layout);
        ib localib = this.k;
        localib.h = parama;
        this.j.a(localib);
      }
      return this.k.a(this.g);
    }
    
    final void a(Context paramContext)
    {
      TypedValue localTypedValue = new TypedValue();
      Resources.Theme localTheme = paramContext.getResources().newTheme();
      localTheme.setTo(paramContext.getTheme());
      localTheme.resolveAttribute(hg.a.actionBarPopupTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      localTheme.resolveAttribute(hg.a.panelMenuListTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      } else {
        localTheme.applyStyle(hg.i.Theme_AppCompat_CompactMenu, true);
      }
      paramContext = new hq(paramContext, 0);
      paramContext.getTheme().setTo(localTheme);
      this.l = paramContext;
      paramContext = paramContext.obtainStyledAttributes(hg.j.AppCompatTheme);
      this.b = paramContext.getResourceId(hg.j.AppCompatTheme_panelBackground, 0);
      this.f = paramContext.getResourceId(hg.j.AppCompatTheme_android_windowAnimationStyle, 0);
      paramContext.recycle();
    }
    
    final void a(id paramid)
    {
      Object localObject = this.j;
      if (paramid == localObject) {
        return;
      }
      if (localObject != null) {
        ((id)localObject).b(this.k);
      }
      this.j = paramid;
      if (paramid != null)
      {
        localObject = this.k;
        if (localObject != null) {
          paramid.a((ik)localObject);
        }
      }
    }
    
    public final boolean a()
    {
      if (this.h == null) {
        return false;
      }
      if (this.i != null) {
        return true;
      }
      return this.k.b().getCount() > 0;
    }
    
    static class SavedState
      implements Parcelable
    {
      public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
      int a;
      boolean b;
      Bundle c;
      
      static SavedState a(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        SavedState localSavedState = new SavedState();
        localSavedState.a = paramParcel.readInt();
        int i = paramParcel.readInt();
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        localSavedState.b = bool;
        if (localSavedState.b) {
          localSavedState.c = paramParcel.readBundle(paramClassLoader);
        }
        return localSavedState;
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
    }
  }
  
  final class a
    implements ik.a
  {
    a() {}
    
    public final void a(id paramid, boolean paramBoolean)
    {
      AppCompatDelegateImplV9.this.b(paramid);
    }
    
    public final boolean a(id paramid)
    {
      Window.Callback localCallback = AppCompatDelegateImplV9.this.c.getCallback();
      if (localCallback != null) {
        localCallback.onMenuOpened(108, paramid);
      }
      return true;
    }
  }
  
  final class b
    implements ho.a
  {
    private ho.a b;
    
    public b(ho.a parama)
    {
      this.b = parama;
    }
    
    public final void a(ho paramho)
    {
      this.b.a(paramho);
      if (AppCompatDelegateImplV9.this.r != null) {
        AppCompatDelegateImplV9.this.c.getDecorView().removeCallbacks(AppCompatDelegateImplV9.this.s);
      }
      if (AppCompatDelegateImplV9.this.q != null)
      {
        AppCompatDelegateImplV9.this.q();
        paramho = AppCompatDelegateImplV9.this;
        paramho.t = fo.f(paramho.q).a(0.0F);
        AppCompatDelegateImplV9.this.t.a(new ft()
        {
          public final void b(View paramAnonymousView)
          {
            AppCompatDelegateImplV9.this.q.setVisibility(8);
            if (AppCompatDelegateImplV9.this.r != null) {
              AppCompatDelegateImplV9.this.r.dismiss();
            } else if ((AppCompatDelegateImplV9.this.q.getParent() instanceof View)) {
              fo.j((View)AppCompatDelegateImplV9.this.q.getParent());
            }
            AppCompatDelegateImplV9.this.q.removeAllViews();
            AppCompatDelegateImplV9.this.t.a(null);
            AppCompatDelegateImplV9.this.t = null;
          }
        });
      }
      if (AppCompatDelegateImplV9.this.f != null) {
        AppCompatDelegateImplV9.this.f.onSupportActionModeFinished(AppCompatDelegateImplV9.this.p);
      }
      AppCompatDelegateImplV9.this.p = null;
    }
    
    public final boolean a(ho paramho, Menu paramMenu)
    {
      return this.b.a(paramho, paramMenu);
    }
    
    public final boolean a(ho paramho, MenuItem paramMenuItem)
    {
      return this.b.a(paramho, paramMenuItem);
    }
    
    public final boolean b(ho paramho, Menu paramMenu)
    {
      return this.b.b(paramho, paramMenu);
    }
  }
  
  final class c
    extends ContentFrameLayout
  {
    public c(Context paramContext)
    {
      super();
    }
    
    public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (AppCompatDelegateImplV9.this.a(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        int i = (int)paramMotionEvent.getX();
        int j = (int)paramMotionEvent.getY();
        if ((i >= -5) && (j >= -5) && (i <= getWidth() + 5) && (j <= getHeight() + 5)) {
          i = 0;
        } else {
          i = 1;
        }
        if (i != 0)
        {
          AppCompatDelegateImplV9.this.r();
          return true;
        }
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    public final void setBackgroundResource(int paramInt)
    {
      setBackgroundDrawable(hi.b(getContext(), paramInt));
    }
  }
  
  final class d
    implements ik.a
  {
    d() {}
    
    public final void a(id paramid, boolean paramBoolean)
    {
      id localid = paramid.k();
      int i;
      if (localid != paramid) {
        i = 1;
      } else {
        i = 0;
      }
      AppCompatDelegateImplV9 localAppCompatDelegateImplV9 = AppCompatDelegateImplV9.this;
      if (i != 0) {
        paramid = localid;
      }
      paramid = localAppCompatDelegateImplV9.a(paramid);
      if (paramid != null)
      {
        if (i != 0)
        {
          AppCompatDelegateImplV9.this.a(paramid.a, paramid, localid);
          AppCompatDelegateImplV9.this.a(paramid, true);
          return;
        }
        AppCompatDelegateImplV9.this.a(paramid, paramBoolean);
      }
    }
    
    public final boolean a(id paramid)
    {
      if ((paramid == null) && (AppCompatDelegateImplV9.this.i))
      {
        Window.Callback localCallback = AppCompatDelegateImplV9.this.c.getCallback();
        if ((localCallback != null) && (!AppCompatDelegateImplV9.this.n)) {
          localCallback.onMenuOpened(108, paramid);
        }
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV9
 * JD-Core Version:    0.7.0.1
 */