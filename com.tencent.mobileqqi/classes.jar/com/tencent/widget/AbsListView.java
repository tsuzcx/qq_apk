package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnTouchModeChangeListener;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filter.FilterListener;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import com.tencent.util.VersionUtils;
import hzm;
import hzn;
import hzo;
import hzp;
import hzq;
import hzr;
import hzs;
import hzt;
import hzv;
import hzw;
import hzx;
import hzy;
import hzz;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class AbsListView
  extends AdapterView
  implements TextWatcher, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener, Filter.FilterListener
{
  static final int jdField_A_of_type_Int = 6;
  static final int B = 0;
  static final int C = 1;
  static final int D = 2;
  static final int E = 3;
  static final int F = 4;
  static final int G = 100;
  static final int H = 5;
  static final int I = 6;
  public static final int J = 0;
  public static final int K = 1;
  public static final int L = 2;
  public static final int M = 3;
  private static final int jdField_a_of_type_Int;
  private static final int[] jdField_a_of_type_ArrayOfInt = a("AbsListView");
  private static final int aM = -1;
  static final int ah = 3;
  private static final int jdField_b_of_type_Int;
  private static final int[] jdField_b_of_type_ArrayOfInt = { 0 };
  private static final int jdField_c_of_type_Int;
  private static final int jdField_d_of_type_Int;
  private static final int jdField_e_of_type_Int;
  private static final int jdField_f_of_type_Int;
  private static final int g;
  private static final int h;
  private static final int jdField_i_of_type_Int;
  private static final int jdField_j_of_type_Int;
  private static final int k;
  private static final int l = 30;
  private static final int m = 20;
  private static final int n = -1;
  private static final int o = 0;
  private static final int p = 1;
  public static final int q = 0;
  public static final int r = 1;
  public static final int s = 2;
  private static final boolean s = false;
  static final int jdField_t_of_type_Int = -1;
  static final int jdField_u_of_type_Int = 0;
  private static final boolean jdField_u_of_type_Boolean = false;
  static final int jdField_v_of_type_Int = 1;
  static final int jdField_w_of_type_Int = 2;
  static final int jdField_x_of_type_Int = 3;
  static final int jdField_y_of_type_Int = 4;
  static final int jdField_z_of_type_Int = 5;
  private boolean jdField_A_of_type_Boolean;
  int N = 0;
  int O;
  public int P = 0;
  public int Q = -1;
  int R = 0;
  int S = 0;
  int T = 0;
  int U = 0;
  int V = 0;
  public int W;
  public int X;
  int Y;
  int Z;
  private float jdField_a_of_type_Float;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  public SparseBooleanArray a;
  public ActionMode a;
  private ContextMenu.ContextMenuInfo jdField_a_of_type_AndroidViewContextMenu$ContextMenuInfo = null;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private InputConnection jdField_a_of_type_AndroidViewInputmethodInputConnection;
  private InputConnectionWrapper jdField_a_of_type_AndroidViewInputmethodInputConnectionWrapper;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  public ListAdapter a;
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  LongSparseArray jdField_a_of_type_ComTencentUtilLongSparseArray;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private EdgeEffect jdField_a_of_type_ComTencentWidgetEdgeEffect;
  public FastScroller a;
  hzp jdField_a_of_type_Hzp;
  private hzq jdField_a_of_type_Hzq;
  private hzr jdField_a_of_type_Hzr;
  private hzt jdField_a_of_type_Hzt;
  private hzv jdField_a_of_type_Hzv;
  hzw jdField_a_of_type_Hzw;
  private hzx jdField_a_of_type_Hzx;
  public hzy a;
  public final hzz a;
  private Object jdField_a_of_type_JavaLangObject = null;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean = false;
  public final boolean[] a;
  private int aF = -1;
  private int aG;
  private int aH = 0;
  private int aI;
  private int aJ;
  private int aK;
  private int aL = -1;
  private int aN;
  private int aO;
  private int aP = 0;
  private int aQ;
  private int aR;
  private int aS;
  private int aT;
  private int aU;
  private int aV;
  int aa;
  public int ab = -1;
  int ac;
  int ad;
  int ae = 0;
  int af = -1;
  int ag;
  int ai;
  public int aj;
  int ak = 0;
  public int al;
  public int am;
  private float jdField_b_of_type_Float = 1.0F;
  Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private EdgeEffect jdField_b_of_type_ComTencentWidgetEdgeEffect;
  private Object jdField_b_of_type_JavaLangObject = null;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private boolean jdField_b_of_type_Boolean = false;
  public Rect c;
  public Drawable c;
  private Runnable jdField_c_of_type_JavaLangRunnable;
  private boolean jdField_c_of_type_Boolean = true;
  private boolean jdField_d_of_type_Boolean;
  View jdField_e_of_type_AndroidViewView;
  boolean jdField_e_of_type_Boolean = false;
  View jdField_f_of_type_AndroidViewView;
  public boolean f;
  public boolean g;
  public boolean h;
  boolean jdField_i_of_type_Boolean;
  boolean jdField_j_of_type_Boolean;
  public boolean k;
  public boolean l;
  private boolean r;
  private boolean jdField_t_of_type_Boolean;
  private boolean jdField_v_of_type_Boolean;
  private boolean jdField_w_of_type_Boolean;
  private boolean jdField_x_of_type_Boolean;
  private boolean jdField_y_of_type_Boolean;
  private boolean jdField_z_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Int = a("AbsListView_listSelector");
    jdField_b_of_type_Int = a("AbsListView_fastScrollAlwaysVisible");
    jdField_c_of_type_Int = a("AbsListView_choiceMode");
    jdField_d_of_type_Int = a("AbsListView_smoothScrollbar");
    jdField_e_of_type_Int = a("AbsListView_fastScrollEnabled");
    jdField_f_of_type_Int = a("AbsListView_cacheColorHint");
    jdField_g_of_type_Int = a("AbsListView_transcriptMode");
    jdField_h_of_type_Int = a("AbsListView_textFilterEnabled");
    jdField_i_of_type_Int = a("AbsListView_scrollingCache");
    jdField_j_of_type_Int = a("AbsListView_stackFromBottom");
    jdField_k_of_type_Int = a("AbsListView_drawSelectorOnTop");
  }
  
  public AbsListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Hzz = new hzz(this);
    this.jdField_c_of_type_AndroidGraphicsRect = new Rect();
    this.t = false;
    this.v = false;
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[1];
    this.A = false;
    b();
    setVerticalScrollBarEnabled(true);
    paramContext = paramContext.obtainStyledAttributes(a("View"));
    initializeScrollbars(paramContext);
    paramContext.recycle();
  }
  
  public AbsListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842858);
  }
  
  public AbsListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Hzz = new hzz(this);
    this.jdField_c_of_type_AndroidGraphicsRect = new Rect();
    this.t = false;
    this.v = false;
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[1];
    this.A = false;
    b();
    paramContext = new TypedArrayWarpper(paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt, paramInt, 0));
    paramAttributeSet = paramContext.a(jdField_a_of_type_Int);
    if (paramAttributeSet != null) {
      setSelector(paramAttributeSet);
    }
    this.jdField_e_of_type_Boolean = paramContext.a(jdField_k_of_type_Int, false);
    setStackFromBottom(paramContext.a(jdField_j_of_type_Int, false));
    setScrollingCacheEnabled(paramContext.a(jdField_i_of_type_Int, true));
    setTextFilterEnabled(paramContext.a(jdField_h_of_type_Int, false));
    setTranscriptMode(paramContext.a(jdField_g_of_type_Int, 0));
    setCacheColorHint(paramContext.b(jdField_f_of_type_Int, 0));
    setFastScrollEnabled(paramContext.a(jdField_e_of_type_Int, false));
    setSmoothScrollbarEnabled(paramContext.a(jdField_d_of_type_Int, true));
    setChoiceMode(paramContext.a(jdField_c_of_type_Int, 0));
    setFastScrollAlwaysVisible(paramContext.a(jdField_b_of_type_Int, false));
    paramContext.a();
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void D()
  {
    if ((this.jdField_i_of_type_Boolean) && (!this.jdField_f_of_type_Boolean))
    {
      setChildrenDrawnWithCacheEnabled(true);
      setChildrenDrawingCacheEnabled(true);
      this.jdField_g_of_type_Boolean = true;
      this.jdField_f_of_type_Boolean = true;
    }
  }
  
  private void E()
  {
    if (this.jdField_c_of_type_JavaLangRunnable == null) {
      this.jdField_c_of_type_JavaLangRunnable = new hzn(this);
    }
    post(this.jdField_c_of_type_JavaLangRunnable);
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
  }
  
  private void G()
  {
    if (getWindowVisibility() == 0)
    {
      a(true);
      H();
      w();
    }
  }
  
  private void H()
  {
    int i1 = getResources().getDisplayMetrics().heightPixels;
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    i1 = i1 - arrayOfInt[1] - getHeight() + (int)(this.jdField_a_of_type_Float * 20.0F);
    if (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this, 81, arrayOfInt[0], i1);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetPopupWindow.update(arrayOfInt[0], i1, -1, -1);
  }
  
  private void I()
  {
    if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect != null)
    {
      this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a();
      this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a();
    }
  }
  
  static int a(Rect paramRect1, Rect paramRect2, int paramInt)
  {
    int i3;
    int i2;
    int i1;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
    case 66: 
      i3 = paramRect1.right;
      i2 = paramRect1.top + paramRect1.height() / 2;
      i1 = paramRect2.left;
      paramInt = paramRect2.top + paramRect2.height() / 2;
    }
    for (;;)
    {
      i1 -= i3;
      paramInt -= i2;
      return paramInt * paramInt + i1 * i1;
      i3 = paramRect1.left + paramRect1.width() / 2;
      i2 = paramRect1.bottom;
      paramInt = paramRect2.left;
      i1 = paramRect2.width() / 2 + paramInt;
      paramInt = paramRect2.top;
      continue;
      i3 = paramRect1.left;
      i2 = paramRect1.top + paramRect1.height() / 2;
      i1 = paramRect2.right;
      paramInt = paramRect2.top + paramRect2.height() / 2;
      continue;
      i3 = paramRect1.left + paramRect1.width() / 2;
      i2 = paramRect1.top;
      paramInt = paramRect2.left;
      i1 = paramRect2.width() / 2 + paramInt;
      paramInt = paramRect2.bottom;
      continue;
      i3 = paramRect1.right + paramRect1.width() / 2;
      i2 = paramRect1.top + paramRect1.height() / 2;
      paramInt = paramRect2.left;
      i1 = paramRect2.width() / 2 + paramInt;
      paramInt = paramRect2.top + paramRect2.height() / 2;
    }
  }
  
  public static View a(ArrayList paramArrayList, int paramInt)
  {
    int i2 = paramArrayList.size();
    if (i2 > 0)
    {
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = (View)paramArrayList.get(i1);
        if (((AbsListView.LayoutParams)localView.getLayoutParams()).jdField_b_of_type_Int == paramInt)
        {
          paramArrayList.remove(i1);
          return localView;
        }
        i1 += 1;
      }
      return (View)paramArrayList.remove(i2 - 1);
    }
    return null;
  }
  
  @TargetApi(9)
  private Object a(Object paramObject)
  {
    return null;
  }
  
  @TargetApi(9)
  private Object a(String paramString)
  {
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_AndroidGraphicsRect.set(paramInt1 - this.R, paramInt2 - this.S, this.T + paramInt3, this.U + paramInt4);
  }
  
  private void a(Canvas paramCanvas)
  {
    if (!this.jdField_b_of_type_AndroidGraphicsRect.isEmpty())
    {
      Drawable localDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      localDrawable.setBounds(this.jdField_b_of_type_AndroidGraphicsRect);
      localDrawable.draw(paramCanvas);
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = (paramMotionEvent.getAction() & 0xFF00) >> 8;
    if (paramMotionEvent.getPointerId(i1) == this.aL) {
      if (i1 != 0) {
        break label65;
      }
    }
    label65:
    for (i1 = 1;; i1 = 0)
    {
      this.Z = ((int)paramMotionEvent.getX(i1));
      this.aa = ((int)paramMotionEvent.getY(i1));
      this.ad = 0;
      this.aL = paramMotionEvent.getPointerId(i1);
      return;
    }
  }
  
  private void a(View paramView)
  {
    try
    {
      View.class.getMethod("dispatchStartTemporaryDetach", new Class[0]).invoke(paramView, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      paramView.onStartTemporaryDetach();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null)
    {
      Context localContext = getContext();
      PopupWindow localPopupWindow = new PopupWindow(localContext);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)((LayoutInflater)localContext.getSystemService("layout_inflater")).inflate(2130904041, null));
      this.jdField_a_of_type_AndroidWidgetEditText.setRawInputType(177);
      this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(268435456);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      localPopupWindow.setFocusable(false);
      localPopupWindow.setTouchable(false);
      localPopupWindow.setInputMethodMode(2);
      localPopupWindow.setContentView(this.jdField_a_of_type_AndroidWidgetEditText);
      localPopupWindow.setWidth(-2);
      localPopupWindow.setHeight(-2);
      localPopupWindow.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidWidgetPopupWindow = localPopupWindow;
      getViewTreeObserver().addOnGlobalLayoutListener(this);
      this.x = true;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131624370);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131624371);
  }
  
  private boolean a(ArrayList paramArrayList)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramArrayList == null) {
      return bool2;
    }
    int i2 = paramArrayList.size();
    int i1 = 0;
    for (;;)
    {
      bool2 = bool1;
      if (i1 >= i2) {
        break;
      }
      View localView = (View)paramArrayList.get(i1);
      if (localView.getParent() != null) {
        bool1 = false;
      }
      if (indexOfChild(localView) >= 0) {
        bool1 = false;
      }
      i1 += 1;
    }
  }
  
  @TargetApi(9)
  private void b()
  {
    setClickable(true);
    setFocusableInTouchMode(true);
    setWillNotDraw(false);
    setAlwaysDrawnWithCacheEnabled(false);
    setScrollingCacheEnabled(true);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.aI = localViewConfiguration.getScaledTouchSlop();
    this.aJ = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.aK = localViewConfiguration.getScaledMaximumFlingVelocity();
    float f1 = getResources().getDisplayMetrics().density;
    this.aj = ((int)(0.0F * f1 + 0.5F));
    int i1 = (int)(f1 * 30.0F + 0.5F);
    this.am = i1;
    this.al = i1;
    this.jdField_a_of_type_Float = getContext().getResources().getDisplayMetrics().density;
    setVerticalFadingEdgeEnabled(false);
    setFriction(0.005F);
  }
  
  private void b(View paramView)
  {
    try
    {
      View.class.getMethod("dispatchFinishTemporaryDetach", new Class[0]).invoke(paramView, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      paramView.onFinishTemporaryDetach();
    }
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    return (this.aB > 0) && (paramInt1 != -1) && (paramInt1 < paramInt2);
  }
  
  private int c(int paramInt)
  {
    if (this.mScrollY * paramInt < 0) {
      return paramInt;
    }
    return (this.au - Math.abs(this.mScrollY)) * paramInt / this.au / 2;
  }
  
  private void c()
  {
    setSelector(getResources().getDrawable(17301602));
  }
  
  private boolean c(int paramInt)
  {
    int i2 = paramInt - this.aa;
    int i3 = Math.abs(i2);
    int i1;
    if (this.mScrollY != 0) {
      i1 = 1;
    }
    while ((i1 != 0) || (i3 > this.aI))
    {
      D();
      if (i1 != 0)
      {
        this.ab = 5;
        this.ad = 0;
        Object localObject = getHandler();
        if (localObject != null) {
          ((Handler)localObject).removeCallbacks(this.jdField_a_of_type_Hzr);
        }
        setPressed(false);
        localObject = getChildAt(this.W - this.ap);
        if (localObject != null) {
          ((View)localObject).setPressed(false);
        }
        a(1);
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
        g(paramInt);
        return true;
        i1 = 0;
      }
      else
      {
        this.ab = 3;
        if (i2 > 0) {}
        for (i1 = this.aI;; i1 = -this.aI)
        {
          this.ad = i1;
          break;
        }
      }
    }
    return false;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      return;
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
  }
  
  @TargetApi(9)
  private void g(int paramInt)
  {
    int i5 = paramInt - this.aa;
    int i4 = i5 - this.ad;
    int i2;
    Object localObject;
    int i1;
    if (this.ac != -2147483648)
    {
      i2 = paramInt - this.ac;
      if (this.ab != 3) {
        break label391;
      }
      if (this.jdField_a_of_type_JavaLangObject == null) {
        this.jdField_a_of_type_JavaLangObject = a("AbsListView-scroll");
      }
      if (paramInt != this.ac)
      {
        if (((this.mGroupFlags & 0x80000) == 0) && (Math.abs(i5) > this.aI))
        {
          localObject = getParent();
          if (localObject != null) {
            ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
          }
        }
        if (this.W < 0) {
          break label341;
        }
        i1 = this.W - this.ap;
        label127:
        localObject = getChildAt(i1);
        if (localObject == null) {
          break label740;
        }
      }
    }
    label320:
    label341:
    label351:
    label479:
    label740:
    for (int i3 = ((View)localObject).getTop();; i3 = 0)
    {
      if (i2 != 0) {}
      for (boolean bool = a(i4, i2);; bool = false)
      {
        localObject = getChildAt(i1);
        if (localObject != null)
        {
          i1 = ((View)localObject).getTop();
          if (bool)
          {
            i1 = -i2 - (i1 - i3);
            overScrollBy(0, c(i1), 0, getScrollY(), 0, 0, 0, this.aj, true);
            if ((Math.abs(this.aj) == Math.abs(getScrollY())) && (this.jdField_a_of_type_AndroidViewVelocityTracker != null)) {
              this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
            }
            i2 = getOverScrollMode();
            if ((i2 == 0) || ((i2 == 1) && (!o())))
            {
              this.aP = 0;
              this.ab = 5;
              if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect != null)
              {
                if (i5 <= 0) {
                  break label351;
                }
                this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a(i1 / getHeight());
                if (!this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a()) {
                  this.jdField_b_of_type_ComTencentWidgetEdgeEffect.b();
                }
              }
            }
          }
          this.aa = paramInt;
          invalidate();
        }
        else
        {
          this.ac = paramInt;
        }
        do
        {
          return;
          i2 = i4;
          break;
          i1 = getChildCount() / 2;
          break label127;
          if (i5 >= 0) {
            break label320;
          }
          this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a(i1 / getHeight());
          if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a()) {
            break label320;
          }
          this.jdField_a_of_type_ComTencentWidgetEdgeEffect.b();
          break label320;
        } while ((this.ab != 5) || (paramInt == this.ac));
        i4 = getScrollY();
        int i6 = i4 - i2;
        if (paramInt > this.ac)
        {
          i1 = 1;
          if (this.aP == 0) {
            this.aP = i1;
          }
          i3 = -i2;
          if (((i6 >= 0) || (i4 < 0)) && ((i6 <= 0) || (i4 > 0))) {
            break label683;
          }
          i4 = -i4;
          i3 = i4;
          i2 += i4;
          if (i3 != 0)
          {
            i4 = getScrollY();
            overScrollBy(0, c(i3), 0, i4, 0, 0, 0, this.aj, true);
            i4 = getOverScrollMode();
            if ((i4 == 0) || ((i4 == 1) && (!o())))
            {
              if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect != null)
              {
                if (i5 <= 0) {
                  break label688;
                }
                this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a(i3 / getHeight());
                if (!this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a()) {
                  this.jdField_b_of_type_ComTencentWidgetEdgeEffect.b();
                }
              }
              invalidate();
            }
          }
          if (i2 != 0)
          {
            this.mScrollY = 0;
            y();
            if (i2 != 0) {
              a(i2, i2);
            }
            this.ab = 3;
            i3 = b(paramInt);
            this.ad = 0;
            localObject = getChildAt(i3 - this.ap);
            if (localObject == null) {
              break label729;
            }
          }
        }
        for (i2 = ((View)localObject).getTop();; i2 = 0)
        {
          this.X = i2;
          this.aa = paramInt;
          this.W = i3;
          this.ac = paramInt;
          this.aP = i1;
          return;
          i1 = -1;
          break;
          i2 = 0;
          break label479;
          if (i5 >= 0) {
            break label582;
          }
          this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a(i3 / getHeight());
          if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a()) {
            break label582;
          }
          this.jdField_a_of_type_ComTencentWidgetEdgeEffect.b();
          break label582;
        }
      }
    }
  }
  
  private boolean o()
  {
    int i1 = getChildCount();
    if (i1 == 0) {}
    do
    {
      return true;
      if (i1 != this.aB) {
        return false;
      }
    } while ((getChildAt(0).getTop() >= this.jdField_c_of_type_AndroidGraphicsRect.top) && (getChildAt(i1 - 1).getBottom() <= getHeight() - this.jdField_c_of_type_AndroidGraphicsRect.bottom));
    return false;
  }
  
  private boolean p()
  {
    return (this.jdField_d_of_type_Boolean) && ((a() instanceof Filterable)) && (((Filterable)a()).getFilter() != null);
  }
  
  abstract int a(int paramInt);
  
  public int a(int paramInt1, int paramInt2)
  {
    Object localObject2 = this.jdField_a_of_type_AndroidGraphicsRect;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      localObject1 = this.jdField_a_of_type_AndroidGraphicsRect;
    }
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      localObject2 = getChildAt(i1);
      if (((View)localObject2).getVisibility() == 0)
      {
        ((View)localObject2).getHitRect((Rect)localObject1);
        if (((Rect)localObject1).contains(paramInt1, paramInt2)) {
          return this.ap + i1;
        }
      }
      i1 -= 1;
    }
    return -1;
  }
  
  public long a(int paramInt1, int paramInt2)
  {
    paramInt1 = a(paramInt1, paramInt2);
    if (paramInt1 >= 0) {
      return this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt1);
    }
    return -9223372036854775808L;
  }
  
  public Drawable a()
  {
    return this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public SparseBooleanArray a()
  {
    if (this.N != 0) {
      return this.jdField_a_of_type_AndroidUtilSparseBooleanArray;
    }
    return null;
  }
  
  ContextMenu.ContextMenuInfo a(View paramView, int paramInt, long paramLong)
  {
    return new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
  }
  
  @ViewDebug.ExportedProperty
  public View a()
  {
    if ((this.aB > 0) && (this.aA >= 0)) {
      return getChildAt(this.aA - this.ap);
    }
    return null;
  }
  
  public View a(int paramInt, boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[0] = false;
    View localView2 = this.jdField_a_of_type_Hzz.b(paramInt);
    View localView1;
    if (localView2 != null)
    {
      localView1 = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(paramInt, localView2, this);
      if (localView1 != localView2)
      {
        this.jdField_a_of_type_Hzz.a(localView2, paramInt);
        paramArrayOfBoolean = localView1;
        if (this.ai != 0)
        {
          localView1.setDrawingCacheBackgroundColor(this.ai);
          paramArrayOfBoolean = localView1;
        }
      }
    }
    do
    {
      return paramArrayOfBoolean;
      paramArrayOfBoolean[0] = true;
      b(localView1);
      return localView1;
      localView1 = this.jdField_a_of_type_AndroidWidgetListAdapter.getView(paramInt, null, this);
      paramArrayOfBoolean = localView1;
    } while (this.ai == 0);
    localView1.setDrawingCacheBackgroundColor(this.ai);
    return localView1;
  }
  
  public AbsListView.LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new AbsListView.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected hzp a()
  {
    return new hzp(this);
  }
  
  public CharSequence a()
  {
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetEditText != null)) {
      return this.jdField_a_of_type_AndroidWidgetEditText.getText();
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    if (paramInt != this.aH) {
      if (AppSetting.n) {
        if (paramInt == 0) {
          break label48;
        }
      }
    }
    label48:
    for (boolean bool = true;; bool = false)
    {
      ThreadPriorityManager.a(bool);
      if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null)
      {
        this.aH = paramInt;
        this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(this, paramInt);
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Hzy == null) {
      this.jdField_a_of_type_Hzy = new hzy(this);
    }
    this.jdField_a_of_type_Hzy.b(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Hzy == null) {
      this.jdField_a_of_type_Hzy = new hzy(this);
    }
    this.jdField_a_of_type_Hzy.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt, View paramView)
  {
    if (paramInt != -1) {
      this.Q = paramInt;
    }
    Rect localRect = this.jdField_b_of_type_AndroidGraphicsRect;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    if ((paramView instanceof AbsListView.SelectionBoundsAdjuster)) {
      ((AbsListView.SelectionBoundsAdjuster)paramView).a(localRect);
    }
    a(localRect.left, localRect.top, localRect.right, localRect.bottom);
    boolean bool = this.w;
    if (paramView.isEnabled() != bool) {
      if (bool) {
        break label116;
      }
    }
    label116:
    for (bool = true;; bool = false)
    {
      this.w = bool;
      if (p() != -1) {
        refreshDrawableState();
      }
      return;
    }
  }
  
  protected void a(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramDrawable.setBounds(paramInt1, this.mScrollY + paramInt2, paramInt3, this.mScrollY + paramInt4);
    paramDrawable.draw(paramCanvas);
  }
  
  public void a(List paramList)
  {
    int i2 = getChildCount();
    AbsListView.RecyclerListener localRecyclerListener = hzz.a(this.jdField_a_of_type_Hzz);
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)localView.getLayoutParams();
      if ((localLayoutParams != null) && (this.jdField_a_of_type_Hzz.a(localLayoutParams.jdField_a_of_type_Int)))
      {
        paramList.add(localView);
        if (localRecyclerListener != null) {
          localRecyclerListener.a(localView);
        }
      }
      i1 += 1;
    }
    this.jdField_a_of_type_Hzz.a(paramList);
    removeAllViewsInLayout();
  }
  
  protected boolean a()
  {
    return this.r;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, int paramInt)
  {
    paramInt = a((int)paramFloat1, (int)paramFloat2);
    if (paramInt != -1)
    {
      long l1 = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt);
      View localView = getChildAt(paramInt - this.ap);
      if (localView != null)
      {
        this.jdField_a_of_type_AndroidViewContextMenu$ContextMenuInfo = a(localView, paramInt, l1);
        return super.showContextMenuForChild(this);
      }
    }
    return super.showContextMenu();
  }
  
  public boolean a(int paramInt)
  {
    if ((this.N != 0) && (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null)) {
      return this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt);
    }
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    int i10 = getChildCount();
    if (i10 == 0) {
      return true;
    }
    a("AbsListView.trackMotionScroll");
    int i1;
    int i5;
    int i11;
    label236:
    boolean bool1;
    label252:
    int i12;
    label304:
    label318:
    int i13;
    label386:
    View localView;
    label411:
    label543:
    label562:
    int i6;
    for (;;)
    {
      int i7;
      int i8;
      int i3;
      int i2;
      int i9;
      int i4;
      try
      {
        i7 = getChildAt(0).getTop();
        i8 = getChildAt(i10 - 1).getBottom();
        Rect localRect = this.jdField_c_of_type_AndroidGraphicsRect;
        i3 = 0;
        i2 = 0;
        if ((this.mGroupFlags & 0x22) == 34)
        {
          i3 = localRect.top;
          i2 = localRect.bottom;
        }
        i9 = getHeight();
        i1 = getHeight() - this.mPaddingBottom - this.mPaddingTop;
        if (paramInt1 < 0)
        {
          i4 = Math.max(-(i1 - 1), paramInt1);
          if (paramInt2 < 0)
          {
            i5 = Math.max(-(i1 - 1), paramInt2);
            i11 = this.ap;
            if (i11 != 0) {
              continue;
            }
            this.aN = (i7 - localRect.top);
            if (i11 + i10 != this.aB) {
              break label304;
            }
            this.aO = (localRect.bottom + i8);
            if ((i11 != 0) || (i7 < localRect.top) || (i5 < 0)) {
              break;
            }
            paramInt1 = 1;
            if (i11 + i10 != this.aB) {
              break label752;
            }
            paramInt2 = getHeight();
            i1 = localRect.bottom;
            if ((i8 > paramInt2 - i1) || (i5 > 0)) {
              break label752;
            }
            paramInt2 = 1;
            if ((paramInt1 == 0) && (paramInt2 == 0)) {
              break label763;
            }
            if (i5 == 0) {
              break label757;
            }
            bool1 = true;
            return bool1;
          }
        }
        else
        {
          i4 = Math.min(i1 - 1, paramInt1);
          continue;
        }
        i5 = Math.min(i1 - 1, paramInt2);
        continue;
        this.aN += i5;
        continue;
        this.aO += i5;
      }
      finally
      {
        A();
      }
      continue;
      for (;;)
      {
        boolean bool2 = isInTouchMode();
        if (bool2) {
          m();
        }
        i12 = k();
        i13 = this.aB - l();
        paramInt2 = 0;
        if (!bool1) {
          break label602;
        }
        paramInt1 = -i5;
        paramInt2 = paramInt1;
        if ((this.mGroupFlags & 0x22) != 34) {
          break label774;
        }
        paramInt2 = paramInt1 + localObject.top;
        break label774;
        if (i1 >= i10) {
          break label781;
        }
        localView = getChildAt(i1);
        if (localView.getBottom() < paramInt2) {
          break;
        }
        break label781;
        this.Y = (this.X + i4);
        this.q = true;
        if (paramInt1 > 0) {
          detachViewsFromParent(paramInt2, paramInt1);
        }
        offsetChildrenTopAndBottom(i5);
        if (bool1) {
          this.ap = (paramInt1 + this.ap);
        }
        invalidate();
        paramInt1 = Math.abs(i5);
        if ((i3 - i7 < paramInt1) || (i8 - (i9 - i2) < paramInt1)) {
          b(bool1);
        }
        if ((bool2) || (this.aA == -1)) {
          break label691;
        }
        paramInt1 = this.aA - this.ap;
        if ((paramInt1 >= 0) && (paramInt1 < getChildCount())) {
          a(this.aA, getChildAt(paramInt1));
        }
        this.q = false;
        f();
        awakenScrollBars();
        A();
        return false;
        bool1 = false;
      }
      i6 = i11 + i1;
      if ((i6 < i12) || (i6 >= i13)) {
        break label786;
      }
      this.jdField_a_of_type_Hzz.a(localView, i6);
      break label786;
      label602:
      paramInt1 = getHeight() - i5;
      i6 = paramInt1;
      if ((this.mGroupFlags & 0x22) != 34) {
        break label797;
      }
      i6 = paramInt1 - localView.bottom;
      break label797;
    }
    for (;;)
    {
      if (i1 >= 0)
      {
        localView = getChildAt(i1);
        if (localView.getTop() <= i6) {
          break label411;
        }
        paramInt2 = i11 + i1;
        if ((paramInt2 < i12) || (paramInt2 >= i13)) {
          break label807;
        }
        this.jdField_a_of_type_Hzz.a(localView, paramInt2);
        break label807;
        label691:
        if (this.Q != -1)
        {
          paramInt1 = this.Q - this.ap;
          if ((paramInt1 < 0) || (paramInt1 >= getChildCount())) {
            break label543;
          }
          a(-1, getChildAt(paramInt1));
          break label543;
        }
        this.jdField_b_of_type_AndroidGraphicsRect.setEmpty();
        break label543;
      }
      break label411;
      paramInt1 = 0;
      break;
      label752:
      paramInt2 = 0;
      break label236;
      label757:
      bool1 = false;
      break label252;
      label763:
      if (i5 >= 0) {
        break label562;
      }
      bool1 = true;
      break label318;
      label774:
      paramInt1 = 0;
      i1 = 0;
      break label386;
      label781:
      paramInt2 = 0;
      break label411;
      label786:
      i1 += 1;
      paramInt1 += 1;
      break label386;
      label797:
      paramInt1 = 0;
      i1 = i10 - 1;
      continue;
      label807:
      paramInt1 += 1;
      paramInt2 = i1;
      i1 -= 1;
    }
  }
  
  protected boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    if (bool) {
      if (getWindowVisibility() != 0) {
        break label60;
      }
    }
    label60:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((this.r) && (paramInt1 != 0) && (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
        H();
      }
      return bool;
    }
  }
  
  boolean a(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    if (!p()) {
      return false;
    }
    boolean bool2;
    boolean bool1;
    Object localObject;
    switch (paramInt1)
    {
    default: 
      bool2 = true;
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 66: 
      for (bool1 = false;; bool1 = false)
      {
        if (bool2)
        {
          a(true);
          if (paramKeyEvent.getRepeatCount() <= 0) {
            break;
          }
          localObject = KeyEvent.changeTimeRepeat(paramKeyEvent, paramKeyEvent.getEventTime(), 0);
        }
        switch (paramKeyEvent.getAction())
        {
        default: 
          return bool1;
          bool2 = false;
        }
      }
    case 4: 
      label118:
      if ((this.r) && (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localObject = getKeyDispatcherState();
          if (localObject != null) {
            ((KeyEvent.DispatcherState)localObject).startTracking(paramKeyEvent, this);
          }
          bool1 = true;
        }
      }
      label148:
      break;
    }
    for (;;)
    {
      bool2 = false;
      break;
      if ((paramKeyEvent.getAction() == 1) && (paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText("");
        bool1 = true;
        continue;
        bool2 = this.r;
        bool1 = false;
        break;
        bool1 = this.jdField_a_of_type_AndroidWidgetEditText.onKeyDown(paramInt1, (KeyEvent)localObject);
        break label148;
        bool1 = this.jdField_a_of_type_AndroidWidgetEditText.onKeyUp(paramInt1, (KeyEvent)localObject);
        break label148;
        bool1 = this.jdField_a_of_type_AndroidWidgetEditText.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
        break label148;
        localObject = paramKeyEvent;
        break label118;
      }
      bool1 = false;
    }
  }
  
  @TargetApi(14)
  protected boolean a(MotionEvent paramMotionEvent)
  {
    return (VersionUtils.d()) && ((paramMotionEvent.getButtonState() & 0x2) != 0) && (a(paramMotionEvent.getX(), paramMotionEvent.getY(), paramMotionEvent.getMetaState()));
  }
  
  public boolean a(View paramView, int paramInt, long paramLong)
  {
    int i1 = 1;
    int i2 = 0;
    if ((b(paramInt, ((ListAdapter)a()).getCount())) && (this.N != 0)) {
      if ((this.N == 2) || ((this.N == 3) && (this.jdField_a_of_type_AndroidViewActionMode != null))) {
        if (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt, false))
        {
          bool1 = true;
          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(paramInt, bool1);
          if ((this.jdField_a_of_type_ComTencentUtilLongSparseArray != null) && (this.jdField_a_of_type_AndroidWidgetListAdapter.hasStableIds()))
          {
            if (!bool1) {
              break label213;
            }
            this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt), Integer.valueOf(paramInt));
          }
          label126:
          if (!bool1) {
            break label233;
          }
          this.O += 1;
          label141:
          if (this.jdField_a_of_type_AndroidViewActionMode == null) {
            break label380;
          }
          this.jdField_a_of_type_Hzw.a(this.jdField_a_of_type_AndroidViewActionMode, paramInt, paramLong, bool1);
          i1 = i2;
          label167:
          this.p = true;
          q();
          requestLayout();
        }
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (i1 != 0) {
        bool2 = bool1 | super.a(paramView, paramInt, paramLong);
      }
      return bool2;
      bool1 = false;
      break;
      label213:
      this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt));
      break label126;
      label233:
      this.O -= 1;
      break label141;
      if (this.N == 1)
      {
        if (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt, false)) {}
        for (i1 = 1;; i1 = 0)
        {
          if (i1 == 0) {
            break label354;
          }
          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(paramInt, true);
          if ((this.jdField_a_of_type_ComTencentUtilLongSparseArray != null) && (this.jdField_a_of_type_AndroidWidgetListAdapter.hasStableIds()))
          {
            this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
            this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt), Integer.valueOf(paramInt));
          }
          this.O = 1;
          i1 = 1;
          break;
        }
        label354:
        if ((this.jdField_a_of_type_AndroidUtilSparseBooleanArray.size() == 0) || (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.valueAt(0))) {
          this.O = 0;
        }
      }
      label380:
      i1 = 1;
      break label167;
    }
  }
  
  public long[] a()
  {
    int i1 = 0;
    Object localObject;
    if ((this.N == 0) || (this.jdField_a_of_type_ComTencentUtilLongSparseArray == null) || (this.jdField_a_of_type_AndroidWidgetListAdapter == null))
    {
      localObject = new long[0];
      return localObject;
    }
    LongSparseArray localLongSparseArray = this.jdField_a_of_type_ComTencentUtilLongSparseArray;
    int i2 = localLongSparseArray.a();
    long[] arrayOfLong = new long[i2];
    for (;;)
    {
      localObject = arrayOfLong;
      if (i1 >= i2) {
        break;
      }
      arrayOfLong[i1] = localLongSparseArray.a(i1);
      i1 += 1;
    }
  }
  
  public void addTouchables(ArrayList paramArrayList)
  {
    int i2 = getChildCount();
    int i3 = this.ap;
    ListAdapter localListAdapter = this.jdField_a_of_type_AndroidWidgetListAdapter;
    if (localListAdapter == null) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = getChildAt(i1);
        if (localListAdapter.isEnabled(i3 + i1)) {
          paramArrayList.add(localView);
        }
        localView.addTouchables(paramArrayList);
        i1 += 1;
      }
    }
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  int b(int paramInt)
  {
    int i2 = getChildCount();
    if (i2 == 0) {
      paramInt = -1;
    }
    int i1;
    do
    {
      return paramInt;
      i1 = a(paramInt);
      paramInt = i1;
    } while (i1 != -1);
    return this.ap + i2 - 1;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Hzy == null) {
      this.jdField_a_of_type_Hzy = new hzy(this);
    }
    this.jdField_a_of_type_Hzy.a(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Hzy == null) {
      this.jdField_a_of_type_Hzy = new hzy(this);
    }
    this.jdField_a_of_type_Hzy.a(paramInt1, paramInt2);
  }
  
  abstract void b(boolean paramBoolean);
  
  public boolean b()
  {
    return (this.jdField_j_of_type_Boolean) && (this.jdField_a_of_type_ComTencentWidgetFastScroller.a());
  }
  
  protected boolean b(int paramInt)
  {
    boolean bool1 = super.onConsistencyCheck(paramInt);
    if ((paramInt & 0x1) != 0) {}
    boolean bool2;
    for (paramInt = 1;; paramInt = 0)
    {
      bool2 = bool1;
      if (paramInt == 0) {
        break label121;
      }
      localObject = hzz.a(this.jdField_a_of_type_Hzz);
      i1 = localObject.length;
      paramInt = 0;
      while (paramInt < i1)
      {
        if (localObject[paramInt] != null) {
          bool1 = false;
        }
        paramInt += 1;
      }
    }
    if (!a(hzz.a(this.jdField_a_of_type_Hzz))) {
      bool1 = false;
    }
    Object localObject = hzz.a(this.jdField_a_of_type_Hzz);
    int i1 = localObject.length;
    paramInt = 0;
    for (;;)
    {
      bool2 = bool1;
      if (paramInt >= i1) {
        break;
      }
      if (!a(localObject[paramInt])) {
        bool1 = false;
      }
      paramInt += 1;
    }
    label121:
    return bool2;
  }
  
  @TargetApi(11)
  public boolean b(View paramView, int paramInt, long paramLong)
  {
    boolean bool1 = true;
    if (this.N == 3)
    {
      bool2 = bool1;
      if (VersionUtils.e())
      {
        bool2 = bool1;
        if (this.jdField_a_of_type_AndroidViewActionMode == null)
        {
          paramView = startActionMode(this.jdField_a_of_type_Hzw);
          this.jdField_a_of_type_AndroidViewActionMode = paramView;
          bool2 = bool1;
          if (paramView != null)
          {
            setItemChecked(paramInt, true);
            performHapticFeedback(0);
            bool2 = bool1;
          }
        }
      }
      return bool2;
    }
    if (this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener != null) {}
    for (boolean bool2 = this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener.a(this, paramView, paramInt, paramLong);; bool2 = false)
    {
      bool1 = bool2;
      if (!bool2)
      {
        this.jdField_a_of_type_AndroidViewContextMenu$ContextMenuInfo = a(paramView, paramInt, paramLong);
        bool1 = super.showContextMenuForChild(this);
      }
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      performHapticFeedback(0);
      return bool1;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public int c()
  {
    return this.O;
  }
  
  void c(int paramInt)
  {
    int i1;
    if (paramInt < 0) {
      i1 = q();
    }
    for (;;)
    {
      int i2;
      float f1;
      if (i1 > -1)
      {
        View localView = getChildAt(i1 - q());
        if (localView != null)
        {
          Rect localRect = new Rect();
          i2 = i1;
          if (localView.getGlobalVisibleRect(localRect))
          {
            i2 = localView.getWidth();
            int i3 = localView.getHeight();
            int i4 = localRect.width();
            f1 = localRect.height() * i4 / (i3 * i2);
            if ((paramInt >= 0) || (f1 >= 0.75F)) {
              break label140;
            }
            i2 = i1 + 1;
          }
        }
      }
      for (;;)
      {
        b(Math.max(0, Math.min(a(), i2 + paramInt)));
        return;
        if (paramInt <= 0) {
          break label166;
        }
        i1 = r();
        break;
        label140:
        i2 = i1;
        if (paramInt > 0)
        {
          i2 = i1;
          if (f1 < 0.75F) {
            i2 = i1 - 1;
          }
        }
      }
      label166:
      i1 = -1;
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Hzt == null) {
      this.jdField_a_of_type_Hzt = new hzt(this);
    }
    int i1 = this.ap;
    int i2 = getChildCount();
    int i3 = this.mPaddingTop;
    int i4 = getHeight();
    int i5 = this.mPaddingBottom;
    if ((paramInt1 == 0) || (this.aB == 0) || (i2 == 0) || ((i1 == 0) && (getChildAt(0).getTop() == i3) && (paramInt1 < 0)) || ((i1 + i2 - 1 == this.aB - 1) && (getChildAt(i2 - 1).getBottom() == i4 - i5) && (paramInt1 > 0)))
    {
      this.jdField_a_of_type_Hzt.a();
      if (this.jdField_a_of_type_Hzy != null) {
        this.jdField_a_of_type_Hzy.a();
      }
      if (this.jdField_a_of_type_Hzv != null) {
        this.jdField_a_of_type_Hzv.b();
      }
      return;
    }
    a(2);
    this.jdField_a_of_type_Hzt.a(paramInt1, paramInt2);
  }
  
  @ViewDebug.ExportedProperty
  public boolean c()
  {
    return this.jdField_j_of_type_Boolean;
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    return paramView == this.jdField_a_of_type_AndroidWidgetEditText;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof AbsListView.LayoutParams;
  }
  
  protected int computeVerticalScrollExtent()
  {
    int i3 = getChildCount();
    if (i3 > 0)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        int i2 = i3 * 100;
        View localView = getChildAt(0);
        int i4 = localView.getTop();
        int i5 = localView.getHeight();
        int i1 = i2;
        if (i5 > 0) {
          i1 = i2 + i4 * 100 / i5;
        }
        localView = getChildAt(i3 - 1);
        i3 = localView.getBottom();
        i4 = localView.getHeight();
        i2 = i1;
        if (i4 > 0) {
          i2 = i1 - (i3 - getHeight()) * 100 / i4;
        }
        return i2;
      }
      return 1;
    }
    return 0;
  }
  
  protected int computeVerticalScrollOffset()
  {
    int i3 = 0;
    int i2 = 0;
    int i4 = this.ap;
    int i5 = getChildCount();
    int i1 = i2;
    if (i4 >= 0)
    {
      i1 = i2;
      if (i5 > 0)
      {
        if (!this.jdField_c_of_type_Boolean) {
          break label91;
        }
        View localView = getChildAt(0);
        i3 = localView.getTop();
        i5 = localView.getHeight();
        i1 = i2;
        if (i5 > 0) {
          i1 = Math.max(i4 * 100 - i3 * 100 / i5, 0);
        }
      }
    }
    return i1;
    label91:
    i2 = this.aB;
    if (i4 == 0) {
      i1 = i3;
    }
    for (;;)
    {
      float f1 = i4;
      float f2 = i5;
      return (int)(i1 / i2 * f2 + f1);
      if (i4 + i5 == i2) {
        i1 = i2;
      } else {
        i1 = i5 / 2 + i4;
      }
    }
  }
  
  protected int computeVerticalScrollRange()
  {
    if (this.jdField_c_of_type_Boolean) {
      return Math.max(this.aB * 100, 0);
    }
    return this.aB;
  }
  
  public int d()
  {
    if ((this.N == 1) && (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null) && (this.jdField_a_of_type_AndroidUtilSparseBooleanArray.size() == 1)) {
      return this.jdField_a_of_type_AndroidUtilSparseBooleanArray.keyAt(0);
    }
    return -1;
  }
  
  abstract void d(int paramInt);
  
  protected boolean d()
  {
    return (this.jdField_a_of_type_ComTencentWidgetFastScroller != null) && (this.jdField_a_of_type_ComTencentWidgetFastScroller.b());
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i2 = 0;
    if ((this.mGroupFlags & 0x22) == 34) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        i2 = paramCanvas.save();
        int i3 = getScrollX();
        int i4 = getScrollY();
        paramCanvas.clipRect(this.mPaddingLeft + i3, this.mPaddingTop + i4, i3 + this.mRight - this.mLeft - this.mPaddingRight, i4 + this.mBottom - this.mTop - this.mPaddingBottom);
        this.mGroupFlags &= 0xFFFFFFDD;
      }
      boolean bool = this.jdField_e_of_type_Boolean;
      if (!bool) {
        a(paramCanvas);
      }
      super.dispatchDraw(paramCanvas);
      if (bool) {
        a(paramCanvas);
      }
      if (i1 != 0)
      {
        paramCanvas.restoreToCount(i2);
        this.mGroupFlags |= 0x22;
      }
      return;
    }
  }
  
  protected void dispatchSetPressed(boolean paramBoolean) {}
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i1;
    int i2;
    if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect != null)
    {
      i1 = this.mScrollY;
      int i3;
      int i4;
      int i5;
      if (!this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a())
      {
        i2 = paramCanvas.save();
        i3 = this.jdField_c_of_type_AndroidGraphicsRect.left + this.aQ;
        i4 = this.jdField_c_of_type_AndroidGraphicsRect.right;
        i5 = this.aR;
        int i6 = getWidth();
        paramCanvas.translate(i3, Math.min(0, this.aN + i1));
        this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a(i6 - i3 - (i4 + i5), getHeight());
        if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect.a(paramCanvas)) {
          invalidate();
        }
        paramCanvas.restoreToCount(i2);
      }
      if (!this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a())
      {
        i2 = paramCanvas.save();
        i3 = this.jdField_c_of_type_AndroidGraphicsRect.left + this.aQ;
        i4 = this.jdField_c_of_type_AndroidGraphicsRect.right;
        i5 = this.aR;
        i4 = getWidth() - i3 - (i4 + i5);
        i5 = getHeight();
        paramCanvas.translate(i3 + -i4, Math.max(i5, i1 + this.aO));
        paramCanvas.rotate(180.0F, i4, 0.0F);
        this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a(i4, i5);
        if (this.jdField_b_of_type_ComTencentWidgetEdgeEffect.a(paramCanvas)) {
          invalidate();
        }
        paramCanvas.restoreToCount(i2);
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetFastScroller != null)
    {
      i1 = this.mScrollY;
      if (i1 != 0)
      {
        i2 = paramCanvas.save();
        paramCanvas.translate(0.0F, i1);
        this.jdField_a_of_type_ComTencentWidgetFastScroller.a(paramCanvas);
        paramCanvas.restoreToCount(i2);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetFastScroller.a(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    l();
  }
  
  public int e()
  {
    return this.N;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
    }
    if (this.jdField_a_of_type_ComTencentUtilLongSparseArray != null) {
      this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
    }
    this.O = 0;
  }
  
  @ViewDebug.ExportedProperty
  public boolean e()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int f()
  {
    return this.jdField_c_of_type_AndroidGraphicsRect.top;
  }
  
  void f()
  {
    if (this.jdField_a_of_type_ComTencentWidgetFastScroller != null) {
      this.jdField_a_of_type_ComTencentWidgetFastScroller.a(this, this.ap, getChildCount(), this.aB);
    }
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(this, this.ap, getChildCount(), this.aB);
    }
    onScrollChanged(0, 0, 0, 0);
  }
  
  @ViewDebug.ExportedProperty
  public boolean f()
  {
    return this.jdField_i_of_type_Boolean;
  }
  
  public int g()
  {
    return this.jdField_c_of_type_AndroidGraphicsRect.bottom;
  }
  
  void g()
  {
    if (getChildCount() > 0)
    {
      h();
      requestLayout();
      invalidate();
    }
  }
  
  @ViewDebug.ExportedProperty
  public boolean g()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new AbsListView.LayoutParams(paramLayoutParams);
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    int i1 = getChildCount();
    float f1 = super.getBottomFadingEdgeStrength();
    if (i1 == 0) {}
    int i2;
    float f2;
    do
    {
      return f1;
      if (this.ap + i1 - 1 < this.aB - 1) {
        return 1.0F;
      }
      i1 = getChildAt(i1 - 1).getBottom();
      i2 = getHeight();
      f2 = getVerticalFadingEdgeLength();
    } while (i1 <= i2 - this.mPaddingBottom);
    return (i1 - i2 + this.mPaddingBottom) / f2;
  }
  
  protected int getBottomPaddingOffset()
  {
    if ((this.mGroupFlags & 0x22) == 34) {
      return 0;
    }
    return this.mPaddingBottom;
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.jdField_a_of_type_AndroidViewContextMenu$ContextMenuInfo;
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    View localView = a();
    if ((localView != null) && (localView.getParent() == this))
    {
      localView.getFocusedRect(paramRect);
      offsetDescendantRectToMyCoords(localView, paramRect);
      return;
    }
    super.getFocusedRect(paramRect);
  }
  
  protected int getLeftPaddingOffset()
  {
    if ((this.mGroupFlags & 0x22) == 34) {
      return 0;
    }
    return -getPaddingLeft();
  }
  
  public int getOverScrollMode()
  {
    return this.aV;
  }
  
  protected int getRightPaddingOffset()
  {
    if ((this.mGroupFlags & 0x22) == 34) {
      return 0;
    }
    return this.mPaddingRight;
  }
  
  public int getSolidColor()
  {
    return this.ai;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    int i1 = getChildCount();
    float f1 = super.getTopFadingEdgeStrength();
    if (i1 == 0) {}
    float f2;
    do
    {
      return f1;
      if (this.ap > 0) {
        return 1.0F;
      }
      i1 = getChildAt(0).getTop();
      f2 = getVerticalFadingEdgeLength();
    } while (i1 >= this.mPaddingTop);
    return -(i1 - this.mPaddingTop) / f2;
  }
  
  protected int getTopPaddingOffset()
  {
    if ((this.mGroupFlags & 0x22) == 34) {
      return 0;
    }
    return -getPaddingTop();
  }
  
  public int getVerticalScrollbarWidth()
  {
    if (b()) {
      return Math.max(super.getVerticalScrollbarWidth(), this.jdField_a_of_type_ComTencentWidgetFastScroller.a());
    }
    return super.getVerticalScrollbarWidth();
  }
  
  public int h()
  {
    return this.jdField_c_of_type_AndroidGraphicsRect.left;
  }
  
  void h()
  {
    removeAllViewsInLayout();
    this.ap = 0;
    this.p = false;
    this.n = false;
    this.aE = -1;
    this.jdField_f_of_type_Long = -9223372036854775808L;
    e(-1);
    f(-1);
    this.ae = 0;
    this.Q = -1;
    this.jdField_b_of_type_AndroidGraphicsRect.setEmpty();
    invalidate();
  }
  
  @ViewDebug.ExportedProperty
  public boolean h()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public int i()
  {
    return this.jdField_c_of_type_AndroidGraphicsRect.right;
  }
  
  public void i() {}
  
  boolean i()
  {
    switch (this.ab)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (verifyDrawable(paramDrawable)) {
      invalidate(paramDrawable.getBounds());
    }
  }
  
  protected boolean isPaddingOffsetRequired()
  {
    return (this.mGroupFlags & 0x22) != 34;
  }
  
  protected int j()
  {
    return 0;
  }
  
  void j()
  {
    int i4 = 1;
    int i3 = 0;
    int i1;
    int i2;
    label56:
    View localView;
    if (this.jdField_e_of_type_AndroidViewView != null)
    {
      if (this.ap > 0)
      {
        i1 = 1;
        i2 = i1;
        if (i1 == 0)
        {
          i2 = i1;
          if (getChildCount() > 0)
          {
            if (getChildAt(0).getTop() >= this.jdField_c_of_type_AndroidGraphicsRect.top) {
              break label161;
            }
            i2 = 1;
          }
        }
        localView = this.jdField_e_of_type_AndroidViewView;
        if (i2 == 0) {
          break label166;
        }
        i1 = 0;
        label68:
        localView.setVisibility(i1);
      }
    }
    else if (this.jdField_f_of_type_AndroidViewView != null)
    {
      i2 = getChildCount();
      if (this.ap + i2 >= this.aB) {
        break label171;
      }
      i1 = 1;
      label101:
      if ((i1 != 0) || (i2 <= 0)) {
        break label186;
      }
      if (getChildAt(i2 - 1).getBottom() <= this.mBottom - this.jdField_c_of_type_AndroidGraphicsRect.bottom) {
        break label176;
      }
      i1 = i4;
    }
    label137:
    label161:
    label166:
    label171:
    label176:
    label186:
    for (;;)
    {
      localView = this.jdField_f_of_type_AndroidViewView;
      if (i1 != 0) {}
      for (i1 = i3;; i1 = 4)
      {
        localView.setVisibility(i1);
        return;
        i1 = 0;
        break;
        i2 = 0;
        break label56;
        i1 = 4;
        break label68;
        i1 = 0;
        break label101;
        i1 = 0;
        break label137;
      }
    }
  }
  
  public boolean j()
  {
    return ((hasFocus()) && (!isInTouchMode())) || (i());
  }
  
  @TargetApi(11)
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.jumpToCurrentState();
    }
  }
  
  int k()
  {
    return 0;
  }
  
  void k()
  {
    if ((!isEnabled()) || (!isClickable())) {}
    for (;;)
    {
      return;
      Drawable localDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      Object localObject = this.jdField_b_of_type_AndroidGraphicsRect;
      if ((localDrawable != null) && ((isFocused()) || (i())) && (!((Rect)localObject).isEmpty()))
      {
        localObject = getChildAt(this.aA - this.ap);
        if (localObject != null)
        {
          if (!((View)localObject).hasFocusable()) {
            ((View)localObject).setPressed(true);
          }
        }
        else
        {
          setPressed(true);
          boolean bool = isLongClickable();
          localDrawable = localDrawable.getCurrent();
          if ((localDrawable != null) && ((localDrawable instanceof TransitionDrawable)))
          {
            if (!bool) {
              break label172;
            }
            ((TransitionDrawable)localDrawable).startTransition(ViewConfiguration.getLongPressTimeout());
          }
          while ((bool) && (!this.p))
          {
            if (this.jdField_a_of_type_Hzq == null) {
              this.jdField_a_of_type_Hzq = new hzq(this, null);
            }
            this.jdField_a_of_type_Hzq.a();
            postDelayed(this.jdField_a_of_type_Hzq, ViewConfiguration.getLongPressTimeout());
            return;
            label172:
            ((TransitionDrawable)localDrawable).resetTransition();
          }
        }
      }
    }
  }
  
  boolean k()
  {
    if ((this.aA < 0) && (l()))
    {
      l();
      return true;
    }
    return false;
  }
  
  int l()
  {
    return 0;
  }
  
  void l()
  {
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      if (j()) {
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setState(getDrawableState());
      }
    }
    else {
      return;
    }
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setState(jdField_b_of_type_ArrayOfInt);
  }
  
  boolean l()
  {
    boolean bool2 = true;
    int i7 = getChildCount();
    if (i7 <= 0) {
      return false;
    }
    int i1 = this.jdField_c_of_type_AndroidGraphicsRect.top;
    int i2 = this.mBottom - this.mTop - this.jdField_c_of_type_AndroidGraphicsRect.bottom;
    int i6 = this.ap;
    int i3 = this.af;
    View localView;
    int i4;
    int i5;
    boolean bool1;
    if ((i3 >= i6) && (i3 < i6 + i7))
    {
      localView = getChildAt(i3 - this.ap);
      i4 = localView.getTop();
      i5 = localView.getBottom();
      if (i4 < i1) {
        i1 = getVerticalFadingEdgeLength() + i1;
      }
      for (;;)
      {
        bool1 = true;
        i2 = i3;
        this.af = -1;
        removeCallbacks(this.jdField_a_of_type_Hzt);
        if (this.jdField_a_of_type_Hzy != null) {
          this.jdField_a_of_type_Hzy.a();
        }
        if (this.jdField_a_of_type_Hzv != null) {
          this.jdField_a_of_type_Hzv.b();
        }
        this.ab = -1;
        E();
        this.aq = i1;
        i1 = a(i2, bool1);
        if ((i1 < i6) || (i1 > r())) {
          break;
        }
        this.P = 4;
        l();
        d(i1);
        f();
        label208:
        a(0);
        if (i1 < 0) {
          break label445;
        }
        bool1 = bool2;
        label221:
        return bool1;
        i1 = i4;
        if (i5 > i2) {
          i1 = i2 - localView.getMeasuredHeight() - getVerticalFadingEdgeLength();
        }
      }
    }
    if (i3 < i6)
    {
      i4 = 0;
      i2 = 0;
      label260:
      if (i4 >= i7) {
        break label491;
      }
      i3 = getChildAt(i4).getTop();
      if (i4 != 0) {
        break label488;
      }
      if ((i6 <= 0) && (i3 >= i1)) {
        break label483;
      }
      i1 = getVerticalFadingEdgeLength() + i1;
      i2 = i3;
      label301:
      if (i3 >= i1) {
        i1 = i6 + i4;
      }
    }
    for (;;)
    {
      bool1 = true;
      i2 = i1;
      i1 = i3;
      break;
      i4 += 1;
      break label260;
      int i8 = this.aB;
      i4 = i7 - 1;
      i1 = 0;
      label345:
      if (i4 >= 0)
      {
        localView = getChildAt(i4);
        i3 = localView.getTop();
        int i9 = localView.getBottom();
        if (i4 == i7 - 1) {
          if ((i6 + i7 < i8) || (i9 > i2))
          {
            i1 = i2 - getVerticalFadingEdgeLength();
            i2 = i3;
          }
        }
        for (;;)
        {
          if (i9 <= i1)
          {
            i1 = i3;
            i2 = i6 + i4;
            bool1 = false;
            break;
          }
          i4 -= 1;
          i3 = i1;
          i1 = i2;
          i2 = i3;
          break label345;
          i1 = -1;
          break label208;
          bool1 = false;
          break label221;
          i1 = i2;
          i2 = i3;
          continue;
          i5 = i1;
          i1 = i2;
          i2 = i5;
        }
      }
      label445:
      i2 = i6 + i7 - 1;
      bool1 = false;
      break;
      label483:
      i2 = i3;
      break label301;
      label488:
      break label301;
      label491:
      i1 = i6;
      i3 = i2;
    }
  }
  
  int m()
  {
    int i2 = this.aA;
    int i1 = i2;
    if (i2 < 0) {
      i1 = this.af;
    }
    return Math.min(Math.max(0, i1), this.aB - 1);
  }
  
  void m()
  {
    if (this.aA != -1)
    {
      if (this.P != 4) {
        this.af = this.aA;
      }
      if ((this.az >= 0) && (this.az != this.aA)) {
        this.af = this.az;
      }
      e(-1);
      f(-1);
      this.ae = 0;
    }
  }
  
  public boolean m()
  {
    return this.r;
  }
  
  public int n()
  {
    return this.aG;
  }
  
  public void n()
  {
    this.p = true;
    q();
    requestLayout();
    invalidate();
  }
  
  @ViewDebug.ExportedProperty(category="drawing")
  public int o()
  {
    return this.ai;
  }
  
  @TargetApi(11)
  void o()
  {
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
    int i1 = 0;
    int i2 = 0;
    long l1;
    int i5;
    int i3;
    if (i1 < this.jdField_a_of_type_ComTencentUtilLongSparseArray.a())
    {
      l1 = this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(i1);
      i5 = ((Integer)this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(i1)).intValue();
      if (l1 != this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(i5))
      {
        i3 = Math.max(0, i5 - 20);
        i4 = Math.min(i5 + 20, this.aB);
        label89:
        if (i3 >= i4) {
          break label251;
        }
        if (l1 == this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(i3))
        {
          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i3, true);
          this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(i1, Integer.valueOf(i3));
        }
      }
    }
    label251:
    for (int i4 = 1;; i4 = 0)
    {
      i3 = i1;
      if (i4 == 0)
      {
        this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(l1);
        this.O -= 1;
        if ((this.jdField_a_of_type_AndroidViewActionMode != null) && (this.jdField_a_of_type_Hzw != null)) {
          this.jdField_a_of_type_Hzw.a(this.jdField_a_of_type_AndroidViewActionMode, i5, l1, false);
        }
        i3 = i1 - 1;
        i2 = 1;
      }
      for (i1 = i2;; i1 = i2)
      {
        i2 = i1;
        i1 = i3 + 1;
        break;
        i3 += 1;
        break label89;
        this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i5, true);
        i3 = i1;
      }
      if ((i2 != 0) && (this.jdField_a_of_type_AndroidViewActionMode != null)) {
        this.jdField_a_of_type_AndroidViewActionMode.invalidate();
      }
      return;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    localViewTreeObserver.addOnTouchModeChangeListener(this);
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (!this.x)) {
      localViewTreeObserver.addOnGlobalLayoutListener(this);
    }
    if ((this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (this.jdField_a_of_type_Hzp == null))
    {
      this.jdField_a_of_type_Hzp = a();
      this.jdField_a_of_type_AndroidWidgetListAdapter.registerDataSetObserver(this.jdField_a_of_type_Hzp);
      this.p = true;
      this.aC = this.aB;
      this.aB = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount();
      requestLayout();
    }
    this.l = true;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    Object localObject;
    if (this.w)
    {
      localObject = super.onCreateDrawableState(paramInt);
      return localObject;
    }
    int i1 = ENABLED_STATE_SET[0];
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    paramInt = arrayOfInt.length - 1;
    label36:
    if (paramInt >= 0) {
      if (arrayOfInt[paramInt] != i1) {}
    }
    for (;;)
    {
      localObject = arrayOfInt;
      if (paramInt < 0) {
        break;
      }
      System.arraycopy(arrayOfInt, paramInt + 1, arrayOfInt, paramInt, arrayOfInt.length - paramInt - 1);
      return arrayOfInt;
      paramInt -= 1;
      break label36;
      paramInt = -1;
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    if (g())
    {
      a(false);
      if (this.jdField_a_of_type_AndroidViewInputmethodInputConnectionWrapper == null)
      {
        this.jdField_a_of_type_AndroidViewInputmethodInputConnection = new BaseInputConnection(this, false);
        this.jdField_a_of_type_AndroidViewInputmethodInputConnectionWrapper = new hzo(this, this.jdField_a_of_type_AndroidWidgetEditText.onCreateInputConnection(paramEditorInfo), true);
      }
      paramEditorInfo.inputType = 177;
      paramEditorInfo.imeOptions = 6;
      return this.jdField_a_of_type_AndroidViewInputmethodInputConnectionWrapper;
    }
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    F();
    this.jdField_a_of_type_Hzz.b();
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    localViewTreeObserver.removeOnTouchModeChangeListener(this);
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetPopupWindow != null))
    {
      localViewTreeObserver.removeGlobalOnLayoutListener(this);
      this.x = false;
    }
    if (this.jdField_a_of_type_AndroidWidgetListAdapter != null)
    {
      this.jdField_a_of_type_AndroidWidgetListAdapter.unregisterDataSetObserver(this.jdField_a_of_type_Hzp);
      this.jdField_a_of_type_Hzp = null;
    }
    if (this.jdField_a_of_type_JavaLangObject != null) {
      this.jdField_a_of_type_JavaLangObject = a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_b_of_type_JavaLangObject != null) {
      this.jdField_b_of_type_JavaLangObject = a(this.jdField_b_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_Hzt != null) {
      removeCallbacks(this.jdField_a_of_type_Hzt);
    }
    if (this.jdField_a_of_type_Hzy != null) {
      this.jdField_a_of_type_Hzy.a();
    }
    if (this.jdField_a_of_type_Hzv != null) {
      this.jdField_a_of_type_Hzv.b();
    }
    if (this.jdField_c_of_type_JavaLangRunnable != null) {
      removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_Hzx != null) {
      removeCallbacks(this.jdField_a_of_type_Hzx);
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null)
    {
      removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    this.l = false;
  }
  
  protected void onDisplayHint(int paramInt)
  {
    super.onDisplayHint(paramInt);
    switch (paramInt)
    {
    default: 
      if (paramInt != 4) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.y = bool;
      return;
      if ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
        break;
      }
      F();
      break;
      if ((!this.r) || (this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
        break;
      }
      G();
      break;
    }
  }
  
  public void onFilterComplete(int paramInt)
  {
    if ((this.aA < 0) && (paramInt > 0))
    {
      this.af = -1;
      l();
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if ((paramBoolean) && (this.aA < 0) && (!isInTouchMode()))
    {
      if ((!this.l) && (this.jdField_a_of_type_AndroidWidgetListAdapter != null))
      {
        this.p = true;
        this.aC = this.aB;
        this.aB = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount();
      }
      l();
    }
  }
  
  @TargetApi(12)
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getSource() & 0x2) != 0) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    int i1;
    do
    {
      float f1;
      do
      {
        do
        {
          return super.onGenericMotionEvent(paramMotionEvent);
        } while (this.ab != -1);
        f1 = paramMotionEvent.getAxisValue(9);
      } while (f1 == 0.0F);
      i1 = (int)(f1 * a());
    } while (a(i1, i1));
    return true;
  }
  
  public void onGlobalLayout()
  {
    if (isShown()) {
      if ((this.r) && (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()) && (!this.y)) {
        G();
      }
    }
    while ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
      return;
    }
    F();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i1 = paramMotionEvent.getAction();
    if ((this.jdField_a_of_type_ComTencentWidgetFastScroller != null) && (this.jdField_a_of_type_ComTencentWidgetFastScroller.a(paramMotionEvent))) {
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        switch (i1 & 0xFF)
        {
        case 4: 
        case 5: 
        default: 
          return false;
        case 0: 
          i1 = this.ab;
          if ((i1 == 6) || (i1 == 5))
          {
            this.ad = 0;
            return true;
          }
          i2 = (int)paramMotionEvent.getX();
          int i3 = (int)paramMotionEvent.getY();
          this.aL = paramMotionEvent.getPointerId(0);
          int i4 = b(i3);
          if ((i1 != 4) && (i4 >= 0))
          {
            this.X = getChildAt(i4 - this.ap).getTop();
            this.Z = i2;
            this.aa = i3;
            this.W = i4;
            this.ab = 0;
            E();
          }
          this.ac = -2147483648;
          d();
          this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
        }
      } while (i1 != 4);
      return true;
      switch (this.ab)
      {
      default: 
        return false;
      }
      int i2 = paramMotionEvent.findPointerIndex(this.aL);
      i1 = i2;
      if (i2 == -1)
      {
        this.aL = paramMotionEvent.getPointerId(0);
        i1 = 0;
      }
      if (this.p) {
        i();
      }
      i1 = (int)paramMotionEvent.getY(i1);
      B();
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    } while (!c(i1));
    return true;
    this.ab = -1;
    this.aL = -1;
    C();
    a(0);
    return false;
    a(paramMotionEvent);
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    do
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      do
      {
        return bool;
      } while (!isEnabled());
    } while ((!isClickable()) || (!isPressed()) || (this.aA < 0) || (this.jdField_a_of_type_AndroidWidgetListAdapter == null) || (this.aA >= this.jdField_a_of_type_AndroidWidgetListAdapter.getCount()));
    paramKeyEvent = getChildAt(this.aA - this.ap);
    if (paramKeyEvent != null)
    {
      a(paramKeyEvent, this.aA, this.jdField_d_of_type_Long);
      paramKeyEvent.setPressed(false);
    }
    setPressed(false);
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = 0;
    a("AbsListView.onLayout");
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      this.o = true;
      if (paramBoolean)
      {
        paramInt3 = getChildCount();
        paramInt1 = i1;
        while (paramInt1 < paramInt3)
        {
          getChildAt(paramInt1).forceLayout();
          paramInt1 += 1;
        }
        this.jdField_a_of_type_Hzz.a();
      }
      if ((this.jdField_a_of_type_ComTencentWidgetFastScroller != null) && (this.aB != this.aC)) {
        this.jdField_a_of_type_ComTencentWidgetFastScroller.a(this.aC, this.aB);
      }
      i();
      this.o = false;
      this.ag = ((paramInt4 - paramInt2) / 3);
      if (this.jdField_k_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Hzv == null) {
          this.jdField_a_of_type_Hzv = new hzv(this);
        }
        this.jdField_a_of_type_Hzv.a();
      }
      return;
    }
    finally
    {
      A();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable == null) {
      c();
    }
    Object localObject = this.jdField_c_of_type_AndroidGraphicsRect;
    ((Rect)localObject).left = (this.R + this.mPaddingLeft);
    ((Rect)localObject).top = (this.S + this.mPaddingTop);
    ((Rect)localObject).right = (this.T + this.mPaddingRight);
    ((Rect)localObject).bottom = (this.U + this.mPaddingBottom);
    if (this.aG == 1)
    {
      int i1 = getChildCount();
      if (i1 > 0)
      {
        paramInt2 = getHeight() - this.mPaddingBottom;
        localObject = getChildAt(i1 - 1);
        if (localObject == null) {
          break label148;
        }
        paramInt1 = ((View)localObject).getBottom();
        if ((i1 + this.ap < this.aU) || (paramInt1 > paramInt2)) {
          break label153;
        }
      }
    }
    label148:
    label153:
    for (boolean bool = true;; bool = false)
    {
      this.z = bool;
      return;
      paramInt1 = paramInt2;
      break;
    }
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (getScrollY() != paramInt2)
    {
      onScrollChanged(getScrollX(), paramInt2, getScrollX(), getScrollY());
      this.mScrollY = paramInt2;
      y();
      awakenScrollBars();
    }
  }
  
  @TargetApi(11)
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (AbsListView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.p = true;
    this.jdField_b_of_type_Long = paramParcelable.jdField_c_of_type_Int;
    if (paramParcelable.jdField_a_of_type_Long >= 0L)
    {
      this.n = true;
      this.jdField_a_of_type_Long = paramParcelable.jdField_a_of_type_Long;
      this.as = paramParcelable.jdField_b_of_type_Int;
      this.aq = paramParcelable.jdField_a_of_type_Int;
      this.ar = paramParcelable.jdField_a_of_type_Int;
      this.at = 0;
    }
    for (;;)
    {
      setFilterText(paramParcelable.jdField_a_of_type_JavaLangString);
      if (paramParcelable.jdField_a_of_type_AndroidUtilSparseBooleanArray != null) {
        this.jdField_a_of_type_AndroidUtilSparseBooleanArray = paramParcelable.jdField_a_of_type_AndroidUtilSparseBooleanArray;
      }
      if (paramParcelable.jdField_a_of_type_ComTencentUtilLongSparseArray != null) {
        this.jdField_a_of_type_ComTencentUtilLongSparseArray = paramParcelable.jdField_a_of_type_ComTencentUtilLongSparseArray;
      }
      this.O = paramParcelable.jdField_d_of_type_Int;
      if ((VersionUtils.e()) && (paramParcelable.jdField_a_of_type_Boolean) && (this.N == 3) && (this.jdField_a_of_type_Hzw != null)) {
        this.jdField_a_of_type_AndroidViewActionMode = startActionMode(this.jdField_a_of_type_Hzw);
      }
      requestLayout();
      return;
      if (paramParcelable.jdField_b_of_type_Long >= 0L)
      {
        e(-1);
        f(-1);
        this.Q = -1;
        if (paramParcelable.jdField_b_of_type_Int != 2147483647)
        {
          this.n = true;
          this.jdField_a_of_type_Long = paramParcelable.jdField_b_of_type_Long;
          if (!this.jdField_h_of_type_Boolean)
          {
            this.as = paramParcelable.jdField_b_of_type_Int;
            this.aq = paramParcelable.jdField_a_of_type_Int;
            this.at = 1;
          }
          else
          {
            this.as = paramParcelable.jdField_b_of_type_Int;
            this.ar = paramParcelable.jdField_a_of_type_Int;
            this.at = 2;
          }
        }
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    boolean bool = true;
    int i3 = 0;
    F();
    AbsListView.SavedState localSavedState = new AbsListView.SavedState(super.onSaveInstanceState());
    int i1;
    Object localObject;
    if ((getChildCount() > 0) && (this.aB > 0))
    {
      i1 = 1;
      localSavedState.jdField_c_of_type_Int = this.au;
      if (this.aA < 0) {
        break label288;
      }
      localSavedState.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
      if (i1 != 0)
      {
        localSavedState.jdField_b_of_type_Int = p();
        localObject = getChildAt(this.aA - this.ap);
        if (localObject != null)
        {
          if (!this.jdField_h_of_type_Boolean) {
            break label279;
          }
          i1 = this.au - ((View)localObject).getBottom();
          label114:
          localSavedState.jdField_a_of_type_Int = i1;
        }
        localSavedState.jdField_b_of_type_Long = -1L;
      }
      label128:
      localSavedState.jdField_a_of_type_JavaLangString = null;
      if (this.r)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetEditText;
        if (localObject != null)
        {
          localObject = ((EditText)localObject).getText();
          if (localObject != null) {
            localSavedState.jdField_a_of_type_JavaLangString = localObject.toString();
          }
        }
      }
      if ((this.N != 3) || (this.jdField_a_of_type_AndroidViewActionMode == null)) {
        break label553;
      }
    }
    for (;;)
    {
      localSavedState.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null) {
        localSavedState.jdField_a_of_type_AndroidUtilSparseBooleanArray = this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clone();
      }
      if (this.jdField_a_of_type_ComTencentUtilLongSparseArray == null) {
        break label566;
      }
      localObject = new LongSparseArray();
      int i2 = this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
      i1 = i3;
      while (i1 < i2)
      {
        ((LongSparseArray)localObject).a(this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(i1), this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(i1));
        i1 += 1;
      }
      i1 = 0;
      break;
      label279:
      i1 = ((View)localObject).getTop();
      break label114;
      label288:
      if (!this.jdField_h_of_type_Boolean)
      {
        if ((i1 != 0) && (this.ap >= 0))
        {
          localSavedState.jdField_a_of_type_Int = getChildAt(0).getTop();
          i2 = this.ap;
          i1 = i2;
          if (i2 >= this.aB) {
            i1 = this.aB - 1;
          }
          localSavedState.jdField_b_of_type_Int = i1;
          localSavedState.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(i1);
          break label128;
        }
        localSavedState.jdField_a_of_type_Int = 0;
        localSavedState.jdField_b_of_type_Long = -1L;
        localSavedState.jdField_b_of_type_Int = 0;
        break label128;
      }
      if ((i1 != 0) && (this.ap >= 0))
      {
        i2 = getChildCount();
        if (this.ap == -1)
        {
          i1 = -1;
          label414:
          localObject = getChildAt(i2 - 1);
          localSavedState.jdField_a_of_type_Int = (this.au - ((View)localObject).getBottom());
          i2 = i1;
          if (i1 >= this.aB) {
            i2 = this.aB - 1;
          }
          if ((((View)localObject).getBottom() > this.au - this.jdField_c_of_type_AndroidGraphicsRect.bottom) || (this.aG != 1)) {
            break label521;
          }
        }
        label521:
        for (localSavedState.jdField_b_of_type_Int = 2147483647;; localSavedState.jdField_b_of_type_Int = i2)
        {
          localSavedState.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(i2);
          break;
          i1 = this.ap + i2 - 1;
          break label414;
        }
      }
      localSavedState.jdField_a_of_type_Int = 0;
      localSavedState.jdField_b_of_type_Long = -1L;
      localSavedState.jdField_b_of_type_Int = 0;
      break label128;
      label553:
      bool = false;
    }
    localSavedState.jdField_a_of_type_ComTencentUtilLongSparseArray = ((LongSparseArray)localObject);
    label566:
    localSavedState.jdField_d_of_type_Int = this.O;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() > 0)
    {
      this.p = true;
      q();
    }
    if (this.jdField_a_of_type_ComTencentWidgetFastScroller != null) {
      this.jdField_a_of_type_ComTencentWidgetFastScroller.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (g()))
    {
      paramInt1 = paramCharSequence.length();
      bool = this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing();
      if ((bool) || (paramInt1 <= 0)) {
        break label85;
      }
      G();
    }
    for (this.r = true;; this.r = false)
    {
      label85:
      do
      {
        if ((this.jdField_a_of_type_AndroidWidgetListAdapter instanceof Filterable))
        {
          Filter localFilter = ((Filterable)this.jdField_a_of_type_AndroidWidgetListAdapter).getFilter();
          if (localFilter == null) {
            break;
          }
          localFilter.filter(paramCharSequence, this);
        }
        return;
      } while ((!bool) || (paramInt1 != 0));
      F();
    }
    throw new IllegalStateException("You cannot call onTextChanged with a non filterable adapter");
  }
  
  @TargetApi(8)
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    int i1 = 0;
    boolean bool1;
    if (!isEnabled()) {
      if ((isClickable()) || (isLongClickable())) {
        bool1 = true;
      }
    }
    do
    {
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
      if (this.jdField_a_of_type_ComTencentWidgetFastScroller == null) {
        break;
      }
      bool1 = bool2;
    } while (this.jdField_a_of_type_ComTencentWidgetFastScroller.b(paramMotionEvent));
    int i2 = paramMotionEvent.getAction();
    B();
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    int i3;
    switch (i2 & 0xFF)
    {
    case 4: 
    default: 
      return true;
    case 0: 
      switch (this.ab)
      {
      default: 
        this.aL = paramMotionEvent.getPointerId(0);
        i2 = (int)paramMotionEvent.getX();
        i3 = (int)paramMotionEvent.getY();
        i1 = a(i2, getScrollY() + i3);
        if (!this.p) {
          if ((this.ab != 4) && (i1 >= 0) && (((ListAdapter)a()).isEnabled(i1)))
          {
            this.ab = 0;
            if (this.jdField_a_of_type_JavaLangRunnable == null) {
              this.jdField_a_of_type_JavaLangRunnable = new hzs(this);
            }
            postDelayed(this.jdField_a_of_type_JavaLangRunnable, ViewConfiguration.getTapTimeout());
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      if (i1 >= 0) {
        this.X = getChildAt(i1 - this.ap).getTop();
      }
      this.Z = i2;
      this.aa = i3;
      this.W = i1;
      this.ac = -2147483648;
      for (;;)
      {
        bool1 = bool2;
        if (!a(paramMotionEvent)) {
          break;
        }
        bool1 = bool2;
        if (this.ab != 0) {
          break;
        }
        removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        return true;
        this.jdField_a_of_type_Hzt.a();
        if (this.jdField_a_of_type_Hzy != null) {
          this.jdField_a_of_type_Hzy.a();
        }
        if (this.jdField_a_of_type_Hzv != null) {
          this.jdField_a_of_type_Hzv.b();
        }
        this.ab = 5;
        this.Z = ((int)paramMotionEvent.getX());
        i1 = (int)paramMotionEvent.getY();
        this.ac = i1;
        this.aa = i1;
        this.ad = 0;
        this.aL = paramMotionEvent.getPointerId(0);
        this.aP = 0;
      }
      if (this.ab == 4)
      {
        D();
        this.jdField_a_of_type_Hzt.a();
        this.ab = 3;
        this.ad = 0;
        i1 = a(i3);
        this.jdField_a_of_type_Hzt.b();
        continue;
        i2 = paramMotionEvent.findPointerIndex(this.aL);
        if (i2 == -1) {
          this.aL = paramMotionEvent.getPointerId(0);
        }
        for (;;)
        {
          if (this.p) {
            i();
          }
          i1 = (int)paramMotionEvent.getY(i1);
          switch (this.ab)
          {
          case 4: 
          default: 
            return true;
          case 0: 
          case 1: 
          case 2: 
            c(i1);
            return true;
          }
          g(i1);
          return true;
          switch (this.ab)
          {
          }
          for (;;)
          {
            setPressed(false);
            if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect != null)
            {
              this.jdField_a_of_type_ComTencentWidgetEdgeEffect.b();
              this.jdField_b_of_type_ComTencentWidgetEdgeEffect.b();
            }
            invalidate();
            paramMotionEvent = getHandler();
            if (paramMotionEvent != null) {
              paramMotionEvent.removeCallbacks(this.jdField_a_of_type_Hzr);
            }
            C();
            this.aL = -1;
            bool1 = bool2;
            if (this.jdField_a_of_type_JavaLangObject == null) {
              break;
            }
            this.jdField_a_of_type_JavaLangObject = a(this.jdField_a_of_type_JavaLangObject);
            return true;
            i2 = this.W;
            View localView = getChildAt(i2 - this.ap);
            float f1 = paramMotionEvent.getX();
            hzx localhzx;
            Handler localHandler;
            if ((f1 > this.jdField_c_of_type_AndroidGraphicsRect.left) && (f1 < getWidth() - this.jdField_c_of_type_AndroidGraphicsRect.right))
            {
              i1 = 1;
              if (this.jdField_a_of_type_Hzx == null) {
                this.jdField_a_of_type_Hzx = new hzx(this, null);
              }
              localhzx = this.jdField_a_of_type_Hzx;
              localhzx.jdField_a_of_type_Int = i2;
              localhzx.a();
              if ((localView == null) || (localView.hasFocusable()) || (i1 == 0)) {
                break label1082;
              }
              if (this.ab != 0) {
                localView.setPressed(false);
              }
              this.af = i2;
              if ((this.ab != 0) && (this.ab != 1)) {
                break label1044;
              }
              localHandler = getHandler();
              if (localHandler != null) {
                if (this.ab != 0) {
                  break label1025;
                }
              }
            }
            label1025:
            for (paramMotionEvent = this.jdField_a_of_type_JavaLangRunnable;; paramMotionEvent = this.jdField_a_of_type_Hzr)
            {
              localHandler.removeCallbacks(paramMotionEvent);
              this.P = 0;
              if ((this.p) || (!this.jdField_a_of_type_AndroidWidgetListAdapter.isEnabled(i2))) {
                break label1033;
              }
              this.ab = 1;
              e(this.W);
              i();
              localView.setPressed(true);
              a(this.W, localView);
              setPressed(true);
              if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null)
              {
                paramMotionEvent = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getCurrent();
                if ((paramMotionEvent != null) && ((paramMotionEvent instanceof TransitionDrawable))) {
                  ((TransitionDrawable)paramMotionEvent).resetTransition();
                }
              }
              if (this.jdField_b_of_type_JavaLangRunnable != null) {
                removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
              }
              this.jdField_b_of_type_JavaLangRunnable = new hzm(this, localView, localhzx);
              postDelayed(this.jdField_b_of_type_JavaLangRunnable, ViewConfiguration.getPressedStateDuration());
              return true;
              i1 = 0;
              break;
            }
            label1033:
            this.ab = -1;
            l();
            return true;
            label1044:
            if ((!this.p) && (this.jdField_a_of_type_AndroidWidgetListAdapter.isEnabled(i2))) {
              localhzx.run();
            }
            for (;;)
            {
              this.ab = -1;
              l();
              break;
              label1082:
              localhzx.run();
            }
            i1 = getChildCount();
            if (i1 > 0)
            {
              i2 = getChildAt(0).getTop();
              i3 = getChildAt(i1 - 1).getBottom();
              int i4 = this.jdField_c_of_type_AndroidGraphicsRect.top;
              int i5 = getHeight() - this.jdField_c_of_type_AndroidGraphicsRect.bottom;
              if ((this.ap == 0) && (i2 >= i4) && (this.ap + i1 < this.aB) && (i3 <= getHeight() - i5))
              {
                this.ab = -1;
                a(0);
              }
              else
              {
                paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
                paramMotionEvent.computeCurrentVelocity(1000, this.aK);
                if (VersionUtils.b()) {}
                for (f1 = paramMotionEvent.getYVelocity(this.aL);; f1 = paramMotionEvent.getYVelocity())
                {
                  int i6 = (int)(f1 * this.jdField_b_of_type_Float);
                  if ((Math.abs(i6) <= this.aJ) || ((this.ap == 0) && (i2 == i4 - this.ak)) || ((i1 + this.ap == this.aB) && (i3 == this.aj + i5))) {
                    break label1338;
                  }
                  if (this.jdField_a_of_type_Hzt == null) {
                    this.jdField_a_of_type_Hzt = new hzt(this);
                  }
                  a(2);
                  this.jdField_a_of_type_Hzt.a(-i6);
                  break;
                }
                label1338:
                this.ab = -1;
                a(0);
                if (this.jdField_a_of_type_Hzt != null) {
                  this.jdField_a_of_type_Hzt.a();
                }
                if (this.jdField_a_of_type_Hzy != null) {
                  this.jdField_a_of_type_Hzy.a();
                }
                if (this.jdField_a_of_type_Hzv != null) {
                  this.jdField_a_of_type_Hzv.b();
                }
              }
            }
            else
            {
              this.ab = -1;
              a(0);
              continue;
              if (this.jdField_a_of_type_Hzt == null) {
                this.jdField_a_of_type_Hzt = new hzt(this);
              }
              a(2);
              this.jdField_a_of_type_Hzt.b(j());
            }
          }
          switch (this.ab)
          {
          default: 
            this.ab = -1;
            setPressed(false);
            paramMotionEvent = getChildAt(this.W - this.ap);
            if (paramMotionEvent != null) {
              paramMotionEvent.setPressed(false);
            }
            E();
            paramMotionEvent = getHandler();
            if (paramMotionEvent != null) {
              paramMotionEvent.removeCallbacks(this.jdField_a_of_type_Hzr);
            }
            C();
          }
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentWidgetEdgeEffect != null)
            {
              this.jdField_a_of_type_ComTencentWidgetEdgeEffect.b();
              this.jdField_b_of_type_ComTencentWidgetEdgeEffect.b();
            }
            this.aL = -1;
            return true;
            if (this.jdField_a_of_type_Hzt == null) {
              this.jdField_a_of_type_Hzt = new hzt(this);
            }
            this.jdField_a_of_type_Hzt.b(0);
          }
          bool1 = bool2;
          if (!VersionUtils.b()) {
            break;
          }
          a(paramMotionEvent);
          i2 = this.Z;
          i1 = this.aa;
          i2 = a(i2, i1);
          if (i2 >= 0)
          {
            this.X = getChildAt(i2 - this.ap).getTop();
            this.W = i2;
          }
          this.ac = i1;
          return true;
          bool1 = bool2;
          if (!VersionUtils.b()) {
            break;
          }
          i3 = paramMotionEvent.getActionIndex();
          i1 = paramMotionEvent.getPointerId(i3);
          i2 = (int)paramMotionEvent.getX(i3);
          i3 = (int)paramMotionEvent.getY(i3);
          this.ad = 0;
          this.aL = i1;
          this.Z = i2;
          this.aa = i3;
          i1 = a(i2, i3);
          if (i1 >= 0)
          {
            this.X = getChildAt(i1 - this.ap).getTop();
            this.W = i1;
          }
          this.ac = i3;
          return true;
          i1 = i2;
        }
      }
    }
  }
  
  public void onTouchModeChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      m();
      if ((getHeight() > 0) && (getChildCount() > 0)) {
        i();
      }
      l();
    }
    do
    {
      int i1;
      do
      {
        return;
        i1 = this.ab;
      } while ((i1 != 5) && (i1 != 6));
      if ((this.jdField_a_of_type_Hzt != null) && (this.mScrollY == 0)) {
        this.jdField_a_of_type_Hzt.a();
      }
      if (this.jdField_a_of_type_Hzy != null) {
        this.jdField_a_of_type_Hzy.a();
      }
      if (this.jdField_a_of_type_Hzv != null) {
        this.jdField_a_of_type_Hzv.b();
      }
    } while (getScrollY() == 0);
    this.mScrollY = 0;
    z();
    I();
    invalidate();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    int i1;
    if (isInTouchMode())
    {
      i1 = 0;
      if (paramBoolean) {
        break label126;
      }
      setChildrenDrawingCacheEnabled(false);
      if (this.jdField_a_of_type_Hzt != null)
      {
        removeCallbacks(this.jdField_a_of_type_Hzt);
        this.jdField_a_of_type_Hzt.a();
        if (this.jdField_a_of_type_Hzy != null) {
          this.jdField_a_of_type_Hzy.a();
        }
        if (this.jdField_a_of_type_Hzv != null) {
          this.jdField_a_of_type_Hzv.b();
        }
        if (getScrollY() != 0)
        {
          this.mScrollY = 0;
          z();
          I();
          invalidate();
        }
      }
      F();
      if (i1 == 1) {
        this.af = this.aA;
      }
    }
    for (;;)
    {
      this.aF = i1;
      return;
      i1 = 1;
      break;
      label126:
      if ((this.r) && (!this.y)) {
        G();
      }
      if ((i1 != this.aF) && (this.aF != -1)) {
        if (i1 == 1)
        {
          l();
        }
        else
        {
          m();
          this.P = 0;
          i();
        }
      }
    }
  }
  
  @TargetApi(9)
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    int i3 = this.aV;
    int i1;
    int i2;
    if (computeHorizontalScrollRange() > computeHorizontalScrollExtent())
    {
      i1 = 1;
      if (computeVerticalScrollRange() <= computeVerticalScrollExtent()) {
        break label177;
      }
      i2 = 1;
      label34:
      if ((i3 != 0) && ((i3 != 1) || (i1 == 0))) {
        break label183;
      }
      i1 = 1;
      label53:
      if ((i3 != 0) && ((i3 != 1) || (i2 == 0))) {
        break label189;
      }
      i2 = 1;
      label72:
      paramInt1 = paramInt3 + paramInt1;
      if (i1 == 0) {
        paramInt7 = 0;
      }
      paramInt2 = paramInt4 + paramInt2;
      if (i2 == 0) {
        paramInt8 = 0;
      }
      paramInt4 = -paramInt7;
      paramInt7 += paramInt5;
      paramInt3 = -this.ak;
      paramInt5 = paramInt8 + paramInt6;
      if (paramInt1 <= paramInt7) {
        break label195;
      }
      paramInt1 = paramInt7;
      paramBoolean = true;
    }
    for (;;)
    {
      label134:
      boolean bool = false;
      if (paramInt2 > paramInt5)
      {
        bool = true;
        paramInt2 = paramInt5;
      }
      label177:
      label183:
      label189:
      label195:
      label225:
      for (;;)
      {
        onOverScrolled(paramInt1, paramInt2, paramBoolean, bool);
        if ((paramBoolean) || (bool))
        {
          return true;
          i1 = 0;
          break;
          i2 = 0;
          break label34;
          i1 = 0;
          break label53;
          i2 = 0;
          break label72;
          if (paramInt1 >= paramInt4) {
            break label228;
          }
          paramBoolean = true;
          paramInt1 = paramInt4;
          break label134;
          if (paramInt2 >= paramInt3) {
            break label225;
          }
          bool = true;
          paramInt2 = paramInt3;
          continue;
        }
        return false;
      }
      label228:
      paramBoolean = false;
    }
  }
  
  protected void p()
  {
    int i3 = this.aB;
    int i4 = this.aU;
    this.aU = this.aB;
    if ((this.N != 0) && (this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (this.jdField_a_of_type_AndroidWidgetListAdapter.hasStableIds())) {
      o();
    }
    if (i3 > 0)
    {
      if (this.n)
      {
        this.n = false;
        if (this.aG == 2) {
          this.jdField_k_of_type_Boolean = true;
        }
      }
      else
      {
        switch (this.at)
        {
        default: 
          label108:
          if (!isInTouchMode())
          {
            i2 = p();
            i1 = i2;
            if (i2 >= i3) {
              i1 = i3 - 1;
            }
            i2 = i1;
            if (i1 < 0) {
              i2 = 0;
            }
            i1 = a(i2, true);
            if (i1 >= 0) {
              f(i1);
            }
          }
          break;
        }
      }
      while (this.af >= 0)
      {
        return;
        if (this.aG != 1) {
          break;
        }
        if (this.z)
        {
          this.z = false;
          this.jdField_k_of_type_Boolean = true;
          break;
        }
        if (getChildCount() <= 0) {
          break;
        }
        int i5 = getChildCount();
        int i2 = getHeight() - this.mPaddingBottom;
        View localView = getChildAt(i5 - 1);
        if (localView != null) {}
        for (i1 = localView.getBottom(); (i5 + this.ap >= i4) && (i1 <= i2); i1 = i2)
        {
          this.P = 3;
          return;
        }
        if (isInTouchMode())
        {
          this.P = 5;
          this.as = Math.min(Math.max(0, this.as), i3 - 1);
          return;
        }
        i1 = s();
        if ((i1 < 0) || (a(i1, true) != i1)) {
          break label108;
        }
        this.as = i1;
        if (this.jdField_b_of_type_Long == getHeight()) {}
        for (this.P = 5;; this.P = 2)
        {
          f(i1);
          return;
        }
        this.P = 5;
        this.as = Math.min(Math.max(0, this.as), i3 - 1);
        return;
        this.P = 5;
        this.as = Math.max(Math.min(this.as, i3 - 1), 0);
        return;
        i1 = a(i2, false);
        if (i1 < 0) {
          break label415;
        }
        f(i1);
        return;
      }
    }
    label415:
    if (this.jdField_h_of_type_Boolean) {}
    for (int i1 = 3;; i1 = 1)
    {
      this.P = i1;
      this.aA = -1;
      this.jdField_d_of_type_Long = -9223372036854775808L;
      this.az = -1;
      this.jdField_c_of_type_Long = -9223372036854775808L;
      this.n = false;
      this.Q = -1;
      x();
      return;
    }
  }
  
  public void q()
  {
    int i1 = -1;
    if (getChildCount() > 0)
    {
      this.n = true;
      this.jdField_b_of_type_Long = this.au;
      if (this.aA >= 0)
      {
        localObject1 = getChildAt(this.aA - this.ap);
        this.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
        this.as = this.az;
        if (localObject1 != null)
        {
          this.aq = ((View)localObject1).getTop();
          this.ar = (this.au - ((View)localObject1).getBottom());
        }
        this.at = 0;
      }
    }
    else
    {
      return;
    }
    Object localObject2;
    if (((this.mScrollY == 0) && (!this.jdField_h_of_type_Boolean)) || (this.mScrollY < 0))
    {
      localObject1 = getChildAt(0);
      localObject2 = (ListAdapter)a();
      if ((this.ap >= 0) && (this.ap < ((ListAdapter)localObject2).getCount())) {}
      for (this.jdField_a_of_type_Long = ((ListAdapter)localObject2).getItemId(this.ap);; this.jdField_a_of_type_Long = -1L)
      {
        this.as = this.ap;
        if (localObject1 != null)
        {
          this.aq = ((View)localObject1).getTop();
          this.ar = (this.au - ((View)localObject1).getBottom());
        }
        this.at = 1;
        return;
      }
    }
    Object localObject1 = (ListAdapter)a();
    int i2 = getChildCount();
    if (this.ap == -1)
    {
      localObject2 = getChildAt(i2 - 1);
      if ((i1 < 0) || (i1 >= ((ListAdapter)localObject1).getCount())) {
        break label318;
      }
    }
    label318:
    for (this.jdField_a_of_type_Long = ((ListAdapter)localObject1).getItemId(i1);; this.jdField_a_of_type_Long = -1L)
    {
      this.as = i1;
      if (localObject2 != null)
      {
        this.aq = ((View)localObject2).getTop();
        this.ar = (this.au - ((View)localObject2).getBottom());
      }
      this.at = 2;
      return;
      i1 = this.ap + i2 - 1;
      break;
    }
  }
  
  public void r()
  {
    if (this.r)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      this.r = false;
      if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
        F();
      }
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      C();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((!this.q) && (!this.o))
    {
      q();
      super.requestLayout();
    }
  }
  
  public void s()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void sendAccessibilityEvent(int paramInt)
  {
    if (paramInt == 4096)
    {
      int i1 = q();
      int i2 = r();
      if ((this.aS == i1) && (this.aT == i2)) {
        return;
      }
      this.aS = i1;
      this.aT = i2;
    }
    super.sendAccessibilityEvent(paramInt);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter != null) && (this.N != 0) && (this.jdField_a_of_type_AndroidWidgetListAdapter.hasStableIds()) && (this.jdField_a_of_type_ComTencentUtilLongSparseArray == null)) {
      this.jdField_a_of_type_ComTencentUtilLongSparseArray = new LongSparseArray();
    }
    if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
    }
    if (this.jdField_a_of_type_ComTencentUtilLongSparseArray != null) {
      this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
    }
  }
  
  public void setCacheColorHint(int paramInt)
  {
    if (paramInt != this.ai)
    {
      this.ai = paramInt;
      int i2 = getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        getChildAt(i1).setDrawingCacheBackgroundColor(paramInt);
        i1 += 1;
      }
      this.jdField_a_of_type_Hzz.b(paramInt);
    }
  }
  
  public void setCallbackOnUnClickItem(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  @TargetApi(11)
  public void setChoiceMode(int paramInt)
  {
    this.N = paramInt;
    if (this.jdField_a_of_type_AndroidViewActionMode != null)
    {
      this.jdField_a_of_type_AndroidViewActionMode.finish();
      this.jdField_a_of_type_AndroidViewActionMode = null;
    }
    if (this.N != 0)
    {
      if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray == null) {
        this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
      }
      if ((this.jdField_a_of_type_ComTencentUtilLongSparseArray == null) && (this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (this.jdField_a_of_type_AndroidWidgetListAdapter.hasStableIds())) {
        this.jdField_a_of_type_ComTencentUtilLongSparseArray = new LongSparseArray();
      }
      if (this.N == 3)
      {
        e();
        setLongClickable(true);
      }
    }
  }
  
  public void setDrawSelectorOnTop(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setEdgeEffectEnabled(boolean paramBoolean)
  {
    Context localContext;
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      if (!paramBoolean) {
        break label62;
      }
      if ((this.aV != 2) && (this.jdField_a_of_type_ComTencentWidgetEdgeEffect == null))
      {
        localContext = getContext();
        this.jdField_a_of_type_ComTencentWidgetEdgeEffect = new EdgeEffect(localContext);
      }
    }
    for (this.jdField_b_of_type_ComTencentWidgetEdgeEffect = new EdgeEffect(localContext);; this.jdField_b_of_type_ComTencentWidgetEdgeEffect = null)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
      label62:
      this.jdField_a_of_type_ComTencentWidgetEdgeEffect = null;
    }
  }
  
  public void setFastScrollAlwaysVisible(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.jdField_j_of_type_Boolean)) {
      setFastScrollEnabled(true);
    }
    if (this.jdField_a_of_type_ComTencentWidgetFastScroller != null) {
      this.jdField_a_of_type_ComTencentWidgetFastScroller.a(paramBoolean);
    }
    try
    {
      localMethod = View.class.getDeclaredMethod("computeOpaqueFlags", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[0]);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          Method localMethod = View.class.getDeclaredMethod("recomputePadding", new Class[0]);
          localMethod.setAccessible(true);
          localMethod.invoke(this, new Object[0]);
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.e("XListView", 2, localException1.getMessage(), localException1);
          }
        }
      }
      catch (Exception localException2)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("XListView", 2, localException2.getMessage(), localException2);
      }
    }
  }
  
  public void setFastScrollEnabled(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentWidgetFastScroller == null) {
        this.jdField_a_of_type_ComTencentWidgetFastScroller = new FastScroller(getContext(), this);
      }
    }
    while (this.jdField_a_of_type_ComTencentWidgetFastScroller == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetFastScroller.a();
    this.jdField_a_of_type_ComTencentWidgetFastScroller = null;
  }
  
  public void setFilterText(String paramString)
  {
    if ((this.jdField_d_of_type_Boolean) && (!TextUtils.isEmpty(paramString)))
    {
      a(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramString.length());
      if ((this.jdField_a_of_type_AndroidWidgetListAdapter instanceof Filterable))
      {
        if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null) {
          ((Filterable)this.jdField_a_of_type_AndroidWidgetListAdapter).getFilter().filter(paramString);
        }
        this.r = true;
        this.jdField_a_of_type_Hzp.a();
      }
    }
  }
  
  public void setFriction(float paramFloat)
  {
    if (this.jdField_a_of_type_Hzt == null) {
      this.jdField_a_of_type_Hzt = new hzt(this);
    }
    hzt.a(this.jdField_a_of_type_Hzt).a(paramFloat);
  }
  
  @TargetApi(11)
  public void setItemChecked(int paramInt, boolean paramBoolean)
  {
    if (this.N == 0) {}
    label144:
    label226:
    label368:
    for (;;)
    {
      return;
      if ((VersionUtils.e()) && (paramBoolean) && (this.N == 3) && (this.jdField_a_of_type_AndroidViewActionMode == null)) {
        this.jdField_a_of_type_AndroidViewActionMode = startActionMode(this.jdField_a_of_type_Hzw);
      }
      if ((this.N == 2) || (this.N == 3))
      {
        boolean bool = this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt);
        this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(paramInt, paramBoolean);
        if ((this.jdField_a_of_type_ComTencentUtilLongSparseArray != null) && (this.jdField_a_of_type_AndroidWidgetListAdapter.hasStableIds()))
        {
          if (paramBoolean) {
            this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt), Integer.valueOf(paramInt));
          }
        }
        else
        {
          if (bool != paramBoolean)
          {
            if (!paramBoolean) {
              break label226;
            }
            this.O += 1;
          }
          if (this.jdField_a_of_type_AndroidViewActionMode != null)
          {
            long l1 = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt);
            this.jdField_a_of_type_Hzw.a(this.jdField_a_of_type_AndroidViewActionMode, paramInt, l1, paramBoolean);
          }
        }
      }
      for (;;)
      {
        if ((this.o) || (this.q)) {
          break label368;
        }
        this.p = true;
        q();
        requestLayout();
        return;
        this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt));
        break;
        this.O -= 1;
        break label144;
        if ((this.jdField_a_of_type_ComTencentUtilLongSparseArray != null) && (this.jdField_a_of_type_AndroidWidgetListAdapter.hasStableIds())) {}
        for (int i1 = 1;; i1 = 0)
        {
          if ((paramBoolean) || (a(paramInt)))
          {
            this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
            if (i1 != 0) {
              this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
            }
          }
          if (!paramBoolean) {
            break label341;
          }
          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(paramInt, true);
          if (i1 != 0) {
            this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt), Integer.valueOf(paramInt));
          }
          this.O = 1;
          break;
        }
        if ((this.jdField_a_of_type_AndroidUtilSparseBooleanArray.size() == 0) || (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.valueAt(0))) {
          this.O = 0;
        }
      }
    }
  }
  
  public void setMaximumVelocity(int paramInt)
  {
    this.aK = paramInt;
  }
  
  public void setMultiChoiceModeListener(AbsListView.MultiChoiceModeListener paramMultiChoiceModeListener)
  {
    if (this.jdField_a_of_type_Hzw == null) {
      this.jdField_a_of_type_Hzw = new hzw(this);
    }
    this.jdField_a_of_type_Hzw.a(paramMultiChoiceModeListener);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
    f();
  }
  
  public void setOverScrollEffectPadding(int paramInt1, int paramInt2)
  {
    this.aQ = paramInt1;
    this.aR = paramInt2;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2)) {
      throw new IllegalArgumentException("Invalid overscroll mode " + paramInt);
    }
    Context localContext;
    if (paramInt != 2) {
      if ((this.jdField_a_of_type_ComTencentWidgetEdgeEffect == null) && (this.jdField_a_of_type_Boolean))
      {
        localContext = getContext();
        this.jdField_a_of_type_ComTencentWidgetEdgeEffect = new EdgeEffect(localContext);
      }
    }
    for (this.jdField_b_of_type_ComTencentWidgetEdgeEffect = new EdgeEffect(localContext);; this.jdField_b_of_type_ComTencentWidgetEdgeEffect = null)
    {
      this.aV = paramInt;
      return;
      this.jdField_a_of_type_ComTencentWidgetEdgeEffect = null;
    }
  }
  
  public void setRecyclerListener(AbsListView.RecyclerListener paramRecyclerListener)
  {
    hzz.a(this.jdField_a_of_type_Hzz, paramRecyclerListener);
  }
  
  public void setScrollIndicators(View paramView1, View paramView2)
  {
    this.jdField_e_of_type_AndroidViewView = paramView1;
    this.jdField_f_of_type_AndroidViewView = paramView2;
  }
  
  public void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if ((this.jdField_i_of_type_Boolean) && (!paramBoolean)) {
      E();
    }
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  public void setSelector(int paramInt)
  {
    setSelector(getResources().getDrawable(paramInt));
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      unscheduleDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
    }
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    Rect localRect = new Rect();
    paramDrawable.getPadding(localRect);
    this.R = localRect.left;
    this.S = localRect.top;
    this.T = localRect.right;
    this.U = localRect.bottom;
    paramDrawable.setCallback(this);
    l();
  }
  
  public void setSmoothScrollbarEnabled(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setStackFromBottom(boolean paramBoolean)
  {
    if (this.jdField_h_of_type_Boolean != paramBoolean)
    {
      this.jdField_h_of_type_Boolean = paramBoolean;
      g();
    }
  }
  
  public void setTextFilterEnabled(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setTranscriptMode(int paramInt)
  {
    this.aG = paramInt;
  }
  
  public void setVelocityScale(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void setVerticalScrollbarPosition(int paramInt)
  {
    super.setVerticalScrollbarPosition(paramInt);
    if (this.jdField_a_of_type_ComTencentWidgetFastScroller != null) {
      this.jdField_a_of_type_ComTencentWidgetFastScroller.a(paramInt);
    }
  }
  
  public boolean showContextMenuForChild(View paramView)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    int i1 = c(paramView);
    if (i1 >= 0)
    {
      long l1 = this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(i1);
      if (this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener != null) {
        bool2 = this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener.a(this, paramView, i1, l1);
      }
      bool1 = bool2;
      if (!bool2)
      {
        this.jdField_a_of_type_AndroidViewContextMenu$ContextMenuInfo = a(getChildAt(i1 - this.ap), i1, l1);
        bool1 = super.showContextMenuForChild(paramView);
      }
    }
    return bool1;
  }
  
  public void t() {}
  
  protected void u()
  {
    if (this.jdField_a_of_type_Hzt == null) {
      this.jdField_a_of_type_Hzt = new hzt(this);
    }
    this.jdField_a_of_type_Hzt.b(0);
  }
  
  protected void v()
  {
    if (this.jdField_a_of_type_Hzt != null) {
      this.jdField_a_of_type_Hzt.a();
    }
  }
  
  public boolean verifyDrawable(Drawable paramDrawable)
  {
    return (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable == paramDrawable) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.AbsListView
 * JD-Core Version:    0.7.0.1
 */