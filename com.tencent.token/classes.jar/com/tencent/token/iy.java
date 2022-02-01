package com.tencent.token;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class iy
{
  private static final PorterDuff.Mode c = PorterDuff.Mode.SRC_IN;
  private static iy d;
  private static final b e = new b();
  private static final int[] f = { hg.e.abc_textfield_search_default_mtrl_alpha, hg.e.abc_textfield_default_mtrl_alpha, hg.e.abc_ab_share_pack_mtrl_alpha };
  private static final int[] g = { hg.e.abc_ic_commit_search_api_mtrl_alpha, hg.e.abc_seekbar_tick_mark_material, hg.e.abc_ic_menu_share_mtrl_alpha, hg.e.abc_ic_menu_copy_mtrl_am_alpha, hg.e.abc_ic_menu_cut_mtrl_alpha, hg.e.abc_ic_menu_selectall_mtrl_alpha, hg.e.abc_ic_menu_paste_mtrl_am_alpha };
  private static final int[] h = { hg.e.abc_textfield_activated_mtrl_alpha, hg.e.abc_textfield_search_activated_mtrl_alpha, hg.e.abc_cab_background_top_mtrl_alpha, hg.e.abc_text_cursor_material, hg.e.abc_text_select_handle_left_mtrl_dark, hg.e.abc_text_select_handle_middle_mtrl_dark, hg.e.abc_text_select_handle_right_mtrl_dark, hg.e.abc_text_select_handle_left_mtrl_light, hg.e.abc_text_select_handle_middle_mtrl_light, hg.e.abc_text_select_handle_right_mtrl_light };
  private static final int[] i = { hg.e.abc_popup_background_mtrl_mult, hg.e.abc_cab_background_internal_bg, hg.e.abc_menu_hardkey_panel_mtrl_mult };
  private static final int[] j = { hg.e.abc_tab_indicator_material, hg.e.abc_textfield_search_material };
  private static final int[] k = { hg.e.abc_btn_check_material, hg.e.abc_btn_radio_material };
  public final Object a = new Object();
  public final WeakHashMap<Context, er<WeakReference<Drawable.ConstantState>>> b = new WeakHashMap(0);
  private WeakHashMap<Context, ey<ColorStateList>> l;
  private em<String, c> m;
  private ey<String> n;
  private TypedValue o;
  private boolean p;
  
  private static long a(TypedValue paramTypedValue)
  {
    return paramTypedValue.assetCookie << 32 | paramTypedValue.data;
  }
  
  private static ColorStateList a(Context paramContext)
  {
    return e(paramContext, js.a(paramContext, hg.a.colorButtonNormal));
  }
  
  private static PorterDuff.Mode a(int paramInt)
  {
    if (paramInt == hg.e.abc_switch_thumb_material) {
      return PorterDuff.Mode.MULTIPLY;
    }
    return null;
  }
  
  private static PorterDuffColorFilter a(int paramInt, PorterDuff.Mode paramMode)
  {
    PorterDuffColorFilter localPorterDuffColorFilter2 = e.a(paramInt, paramMode);
    PorterDuffColorFilter localPorterDuffColorFilter1 = localPorterDuffColorFilter2;
    if (localPorterDuffColorFilter2 == null)
    {
      localPorterDuffColorFilter1 = new PorterDuffColorFilter(paramInt, paramMode);
      e.a(paramInt, paramMode, localPorterDuffColorFilter1);
    }
    return localPorterDuffColorFilter1;
  }
  
  private Drawable a(Context paramContext, long paramLong)
  {
    for (;;)
    {
      synchronized (this.a)
      {
        er localer = (er)this.b.get(paramContext);
        if (localer == null) {
          return null;
        }
        int i1 = eo.a(localer.c, localer.e, paramLong);
        if ((i1 >= 0) && (localer.d[i1] != er.a))
        {
          localObject1 = localer.d[i1];
          localObject1 = (WeakReference)localObject1;
          if (localObject1 != null)
          {
            localObject1 = (Drawable.ConstantState)((WeakReference)localObject1).get();
            if (localObject1 != null)
            {
              paramContext = ((Drawable.ConstantState)localObject1).newDrawable(paramContext.getResources());
              return paramContext;
            }
            i1 = eo.a(localer.c, localer.e, paramLong);
            if ((i1 >= 0) && (localer.d[i1] != er.a))
            {
              localer.d[i1] = er.a;
              localer.b = true;
            }
          }
          return null;
        }
      }
      Object localObject1 = null;
    }
  }
  
  public static iy a()
  {
    if (d == null)
    {
      iy localiy = new iy();
      d = localiy;
      if (Build.VERSION.SDK_INT < 24)
      {
        localiy.a("vector", new d());
        localiy.a("animated-vector", new a());
      }
    }
    return d;
  }
  
  private void a(Context paramContext, int paramInt, ColorStateList paramColorStateList)
  {
    if (this.l == null) {
      this.l = new WeakHashMap();
    }
    ey localey2 = (ey)this.l.get(paramContext);
    ey localey1 = localey2;
    if (localey2 == null)
    {
      localey1 = new ey();
      this.l.put(paramContext, localey1);
    }
    localey1.b(paramInt, paramColorStateList);
  }
  
  private static void a(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = paramDrawable;
    if (ji.c(paramDrawable)) {
      localDrawable = paramDrawable.mutate();
    }
    paramDrawable = paramMode;
    if (paramMode == null) {
      paramDrawable = c;
    }
    localDrawable.setColorFilter(a(paramInt, paramDrawable));
  }
  
  static void a(Drawable paramDrawable, ju paramju, int[] paramArrayOfInt)
  {
    if ((ji.c(paramDrawable)) && (paramDrawable.mutate() != paramDrawable)) {
      return;
    }
    if ((!paramju.d) && (!paramju.c))
    {
      paramDrawable.clearColorFilter();
    }
    else
    {
      boolean bool = paramju.d;
      Object localObject2 = null;
      ColorStateList localColorStateList;
      if (bool) {
        localColorStateList = paramju.a;
      } else {
        localColorStateList = null;
      }
      if (paramju.c) {
        paramju = paramju.b;
      } else {
        paramju = c;
      }
      Object localObject1 = localObject2;
      if (localColorStateList != null) {
        if (paramju == null) {
          localObject1 = localObject2;
        } else {
          localObject1 = a(localColorStateList.getColorForState(paramArrayOfInt, 0), paramju);
        }
      }
      paramDrawable.setColorFilter((ColorFilter)localObject1);
    }
    if (Build.VERSION.SDK_INT <= 23) {
      paramDrawable.invalidateSelf();
    }
  }
  
  private void a(String paramString, c paramc)
  {
    if (this.m == null) {
      this.m = new em();
    }
    this.m.put(paramString, paramc);
  }
  
  static boolean a(Context paramContext, int paramInt, Drawable paramDrawable)
  {
    PorterDuff.Mode localMode = c;
    boolean bool = a(f, paramInt);
    int i2 = 16842801;
    int i1;
    if (bool)
    {
      i2 = hg.a.colorControlNormal;
      i1 = 1;
      paramInt = -1;
    }
    else if (a(h, paramInt))
    {
      i2 = hg.a.colorControlActivated;
      i1 = 1;
      paramInt = -1;
    }
    else if (a(i, paramInt))
    {
      localMode = PorterDuff.Mode.MULTIPLY;
      i1 = 1;
      paramInt = -1;
    }
    else if (paramInt == hg.e.abc_list_divider_mtrl_alpha)
    {
      i2 = 16842800;
      paramInt = Math.round(40.799999F);
      i1 = 1;
    }
    else if (paramInt == hg.e.abc_dialog_material_background)
    {
      i1 = 1;
      paramInt = -1;
    }
    else
    {
      i1 = 0;
      paramInt = -1;
      i2 = 0;
    }
    if (i1 != 0)
    {
      Drawable localDrawable = paramDrawable;
      if (ji.c(paramDrawable)) {
        localDrawable = paramDrawable.mutate();
      }
      localDrawable.setColorFilter(a(js.a(paramContext, i2), localMode));
      if (paramInt != -1) {
        localDrawable.setAlpha(paramInt);
      }
      return true;
    }
    return false;
  }
  
  private boolean a(Context paramContext, long paramLong, Drawable paramDrawable)
  {
    Drawable.ConstantState localConstantState = paramDrawable.getConstantState();
    if (localConstantState != null) {
      synchronized (this.a)
      {
        er localer = (er)this.b.get(paramContext);
        paramDrawable = localer;
        if (localer == null)
        {
          paramDrawable = new er();
          this.b.put(paramContext, paramDrawable);
        }
        paramDrawable.a(paramLong, new WeakReference(localConstantState));
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(Drawable paramDrawable)
  {
    return ((paramDrawable instanceof ck)) || ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()));
  }
  
  private static boolean a(int[] paramArrayOfInt, int paramInt)
  {
    int i2 = paramArrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (paramArrayOfInt[i1] == paramInt) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private static ColorStateList b(Context paramContext)
  {
    return e(paramContext, js.a(paramContext, hg.a.colorAccent));
  }
  
  private static ColorStateList c(Context paramContext)
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    ColorStateList localColorStateList = js.b(paramContext, hg.a.colorSwitchThumbNormal);
    if ((localColorStateList != null) && (localColorStateList.isStateful()))
    {
      arrayOfInt[0] = js.a;
      arrayOfInt1[0] = localColorStateList.getColorForState(arrayOfInt[0], 0);
      arrayOfInt[1] = js.e;
      arrayOfInt1[1] = js.a(paramContext, hg.a.colorControlActivated);
      arrayOfInt[2] = js.h;
      arrayOfInt1[2] = localColorStateList.getDefaultColor();
    }
    else
    {
      arrayOfInt[0] = js.a;
      arrayOfInt1[0] = js.c(paramContext, hg.a.colorSwitchThumbNormal);
      arrayOfInt[1] = js.e;
      arrayOfInt1[1] = js.a(paramContext, hg.a.colorControlActivated);
      arrayOfInt[2] = js.h;
      arrayOfInt1[2] = js.a(paramContext, hg.a.colorSwitchThumbNormal);
    }
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }
  
  private Drawable c(Context paramContext, int paramInt)
  {
    if (this.o == null) {
      this.o = new TypedValue();
    }
    TypedValue localTypedValue = this.o;
    paramContext.getResources().getValue(paramInt, localTypedValue, true);
    long l1 = a(localTypedValue);
    Object localObject = a(paramContext, l1);
    if (localObject != null) {
      return localObject;
    }
    if (paramInt == hg.e.abc_cab_background_top_material) {
      localObject = new LayerDrawable(new Drawable[] { a(paramContext, hg.e.abc_cab_background_internal_bg, false), a(paramContext, hg.e.abc_cab_background_top_mtrl_alpha, false) });
    }
    if (localObject != null)
    {
      ((Drawable)localObject).setChangingConfigurations(localTypedValue.changingConfigurations);
      a(paramContext, l1, (Drawable)localObject);
    }
    return localObject;
  }
  
  private ColorStateList d(Context paramContext, int paramInt)
  {
    WeakHashMap localWeakHashMap = this.l;
    if (localWeakHashMap != null)
    {
      paramContext = (ey)localWeakHashMap.get(paramContext);
      if (paramContext != null) {
        return (ColorStateList)paramContext.a(paramInt);
      }
      return null;
    }
    return null;
  }
  
  private void d(Context paramContext)
  {
    if (this.p) {
      return;
    }
    this.p = true;
    paramContext = a(paramContext, hg.e.abc_vector_test, false);
    if ((paramContext != null) && (a(paramContext))) {
      return;
    }
    this.p = false;
    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
  }
  
  private static ColorStateList e(Context paramContext, int paramInt)
  {
    int i3 = js.a(paramContext, hg.a.colorControlHighlight);
    int i1 = js.c(paramContext, hg.a.colorButtonNormal);
    paramContext = js.a;
    int[] arrayOfInt1 = js.d;
    int i2 = dq.a(i3, paramInt);
    int[] arrayOfInt2 = js.b;
    i3 = dq.a(i3, paramInt);
    return new ColorStateList(new int[][] { paramContext, arrayOfInt1, arrayOfInt2, js.h }, new int[] { i1, i2, i3, paramInt });
  }
  
  final Drawable a(Context paramContext, int paramInt)
  {
    Object localObject1 = this.m;
    TypedValue localTypedValue;
    long l1;
    Drawable localDrawable;
    Object localObject2;
    if ((localObject1 != null) && (!((em)localObject1).isEmpty()))
    {
      localObject1 = this.n;
      if (localObject1 != null)
      {
        localObject1 = (String)((ey)localObject1).a(paramInt);
        if (("appcompat_skip_skip".equals(localObject1)) || ((localObject1 != null) && (this.m.get(localObject1) == null))) {
          return null;
        }
      }
      else
      {
        this.n = new ey();
      }
      if (this.o == null) {
        this.o = new TypedValue();
      }
      localTypedValue = this.o;
      localObject1 = paramContext.getResources();
      ((Resources)localObject1).getValue(paramInt, localTypedValue, true);
      l1 = a(localTypedValue);
      localDrawable = a(paramContext, l1);
      if (localDrawable != null) {
        return localDrawable;
      }
      localObject2 = localDrawable;
      if (localTypedValue.string != null)
      {
        localObject2 = localDrawable;
        if (localTypedValue.string.toString().endsWith(".xml")) {
          localObject2 = localDrawable;
        }
      }
    }
    try
    {
      XmlResourceParser localXmlResourceParser = ((Resources)localObject1).getXml(paramInt);
      localObject2 = localDrawable;
      AttributeSet localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
      int i1;
      do
      {
        localObject2 = localDrawable;
        i1 = localXmlResourceParser.next();
      } while ((i1 != 2) && (i1 != 1));
      if (i1 == 2)
      {
        localObject2 = localDrawable;
        localObject1 = localXmlResourceParser.getName();
        localObject2 = localDrawable;
        this.n.b(paramInt, localObject1);
        localObject2 = localDrawable;
        c localc = (c)this.m.get(localObject1);
        localObject1 = localDrawable;
        if (localc != null)
        {
          localObject2 = localDrawable;
          localObject1 = localc.a(paramContext, localXmlResourceParser, localAttributeSet, paramContext.getTheme());
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          ((Drawable)localObject1).setChangingConfigurations(localTypedValue.changingConfigurations);
          localObject2 = localObject1;
          a(paramContext, l1, (Drawable)localObject1);
          localObject2 = localObject1;
        }
      }
      else
      {
        localObject2 = localDrawable;
        throw new XmlPullParserException("No start tag found");
      }
    }
    catch (Exception paramContext)
    {
      label365:
      break label365;
    }
    if (localObject2 == null) {
      this.n.b(paramInt, "appcompat_skip_skip");
    }
    return localObject2;
    return null;
  }
  
  public final Drawable a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    d(paramContext);
    Object localObject2 = a(paramContext, paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = c(paramContext, paramInt);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = dj.a(paramContext, paramInt);
    }
    localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = a(paramContext, paramInt, paramBoolean, (Drawable)localObject2);
    }
    if (localObject1 != null) {
      ji.b((Drawable)localObject1);
    }
    return localObject1;
  }
  
  final Drawable a(Context paramContext, int paramInt, boolean paramBoolean, Drawable paramDrawable)
  {
    Object localObject = b(paramContext, paramInt);
    if (localObject != null)
    {
      paramContext = paramDrawable;
      if (ji.c(paramDrawable)) {
        paramContext = paramDrawable.mutate();
      }
      paramContext = dy.d(paramContext);
      dy.a(paramContext, (ColorStateList)localObject);
      paramDrawable = a(paramInt);
      localObject = paramContext;
      if (paramDrawable != null)
      {
        dy.a(paramContext, paramDrawable);
        return paramContext;
      }
    }
    else
    {
      if (paramInt == hg.e.abc_seekbar_track_material)
      {
        localObject = (LayerDrawable)paramDrawable;
        a(((LayerDrawable)localObject).findDrawableByLayerId(16908288), js.a(paramContext, hg.a.colorControlNormal), c);
        a(((LayerDrawable)localObject).findDrawableByLayerId(16908303), js.a(paramContext, hg.a.colorControlNormal), c);
        a(((LayerDrawable)localObject).findDrawableByLayerId(16908301), js.a(paramContext, hg.a.colorControlActivated), c);
        return paramDrawable;
      }
      if ((paramInt != hg.e.abc_ratingbar_material) && (paramInt != hg.e.abc_ratingbar_indicator_material) && (paramInt != hg.e.abc_ratingbar_small_material))
      {
        localObject = paramDrawable;
        if (!a(paramContext, paramInt, paramDrawable))
        {
          localObject = paramDrawable;
          if (paramBoolean) {
            return null;
          }
        }
      }
      else
      {
        localObject = (LayerDrawable)paramDrawable;
        a(((LayerDrawable)localObject).findDrawableByLayerId(16908288), js.c(paramContext, hg.a.colorControlNormal), c);
        a(((LayerDrawable)localObject).findDrawableByLayerId(16908303), js.a(paramContext, hg.a.colorControlActivated), c);
        a(((LayerDrawable)localObject).findDrawableByLayerId(16908301), js.a(paramContext, hg.a.colorControlActivated), c);
        localObject = paramDrawable;
      }
    }
    return localObject;
  }
  
  final ColorStateList b(Context paramContext, int paramInt)
  {
    ColorStateList localColorStateList1 = d(paramContext, paramInt);
    ColorStateList localColorStateList2 = localColorStateList1;
    if (localColorStateList1 == null)
    {
      if (paramInt == hg.e.abc_edit_text_material) {
        localColorStateList1 = hi.a(paramContext, hg.c.abc_tint_edittext);
      } else if (paramInt == hg.e.abc_switch_track_mtrl_alpha) {
        localColorStateList1 = hi.a(paramContext, hg.c.abc_tint_switch_track);
      } else if (paramInt == hg.e.abc_switch_thumb_material) {
        localColorStateList1 = c(paramContext);
      } else if (paramInt == hg.e.abc_btn_default_mtrl_shape) {
        localColorStateList1 = a(paramContext);
      } else if (paramInt == hg.e.abc_btn_borderless_material) {
        localColorStateList1 = e(paramContext, 0);
      } else if (paramInt == hg.e.abc_btn_colored_material) {
        localColorStateList1 = b(paramContext);
      } else if ((paramInt != hg.e.abc_spinner_mtrl_am_alpha) && (paramInt != hg.e.abc_spinner_textfield_background_material))
      {
        if (a(g, paramInt)) {
          localColorStateList1 = js.b(paramContext, hg.a.colorControlNormal);
        } else if (a(j, paramInt)) {
          localColorStateList1 = hi.a(paramContext, hg.c.abc_tint_default);
        } else if (a(k, paramInt)) {
          localColorStateList1 = hi.a(paramContext, hg.c.abc_tint_btn_checkable);
        } else if (paramInt == hg.e.abc_seekbar_thumb_material) {
          localColorStateList1 = hi.a(paramContext, hg.c.abc_tint_seek_thumb);
        }
      }
      else {
        localColorStateList1 = hi.a(paramContext, hg.c.abc_tint_spinner);
      }
      localColorStateList2 = localColorStateList1;
      if (localColorStateList1 != null)
      {
        a(paramContext, paramInt, localColorStateList1);
        localColorStateList2 = localColorStateList1;
      }
    }
    return localColorStateList2;
  }
  
  static final class a
    implements iy.c
  {
    public final Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        paramContext = ce.a(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        label15:
        break label15;
      }
      return null;
    }
  }
  
  static final class b
    extends es<Integer, PorterDuffColorFilter>
  {
    public b()
    {
      super();
    }
    
    private static int b(int paramInt, PorterDuff.Mode paramMode)
    {
      return (paramInt + 31) * 31 + paramMode.hashCode();
    }
    
    final PorterDuffColorFilter a(int paramInt, PorterDuff.Mode paramMode)
    {
      return (PorterDuffColorFilter)a(Integer.valueOf(b(paramInt, paramMode)));
    }
    
    final PorterDuffColorFilter a(int paramInt, PorterDuff.Mode paramMode, PorterDuffColorFilter paramPorterDuffColorFilter)
    {
      return (PorterDuffColorFilter)a(Integer.valueOf(b(paramInt, paramMode)), paramPorterDuffColorFilter);
    }
  }
  
  static abstract interface c
  {
    public abstract Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme);
  }
  
  static final class d
    implements iy.c
  {
    public final Drawable a(Context paramContext, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    {
      try
      {
        paramContext = ck.a(paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        label14:
        break label14;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.iy
 * JD-Core Version:    0.7.0.1
 */