package com.tencent.token;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class hb
  extends MenuInflater
{
  static final Class<?>[] a;
  static final Class<?>[] b;
  final Object[] c;
  final Object[] d;
  Context e;
  Object f;
  
  static
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Context.class;
    a = arrayOfClass;
    b = arrayOfClass;
  }
  
  public hb(Context paramContext)
  {
    super(paramContext);
    this.e = paramContext;
    this.c = new Object[] { paramContext };
    this.d = this.c;
  }
  
  static Object a(Object paramObject)
  {
    for (;;)
    {
      if ((paramObject instanceof Activity)) {
        return paramObject;
      }
      if (!(paramObject instanceof ContextWrapper)) {
        break;
      }
      paramObject = ((ContextWrapper)paramObject).getBaseContext();
    }
    return paramObject;
  }
  
  private void a(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
  {
    b localb = new b(paramMenu);
    int i = paramXmlPullParser.getEventType();
    do
    {
      if (i == 2)
      {
        paramMenu = paramXmlPullParser.getName();
        if (paramMenu.equals("menu"))
        {
          i = paramXmlPullParser.next();
          break;
        }
        throw new RuntimeException("Expecting menu, got ".concat(String.valueOf(paramMenu)));
      }
      j = paramXmlPullParser.next();
      i = j;
    } while (j != 1);
    i = j;
    Object localObject = null;
    int j = 0;
    int k = 0;
    int n = i;
    while (j == 0)
    {
      int m;
      switch (n)
      {
      default: 
        i = k;
        paramMenu = (Menu)localObject;
        m = j;
        break;
      case 3: 
        String str = paramXmlPullParser.getName();
        if ((k != 0) && (str.equals(localObject)))
        {
          paramMenu = null;
          i = 0;
          m = j;
        }
        else if (str.equals("group"))
        {
          localb.a();
          i = k;
          paramMenu = (Menu)localObject;
          m = j;
        }
        else if (str.equals("item"))
        {
          i = k;
          paramMenu = (Menu)localObject;
          m = j;
          if (!localb.a) {
            if ((localb.b != null) && (localb.b.e()))
            {
              localb.c();
              i = k;
              paramMenu = (Menu)localObject;
              m = j;
            }
            else
            {
              localb.b();
              i = k;
              paramMenu = (Menu)localObject;
              m = j;
            }
          }
        }
        else
        {
          i = k;
          paramMenu = (Menu)localObject;
          m = j;
          if (str.equals("menu"))
          {
            m = 1;
            i = k;
            paramMenu = (Menu)localObject;
          }
        }
        break;
      case 2: 
        i = k;
        paramMenu = (Menu)localObject;
        m = j;
        if (k == 0)
        {
          paramMenu = paramXmlPullParser.getName();
          if (paramMenu.equals("group"))
          {
            localb.a(paramAttributeSet);
            i = k;
            paramMenu = (Menu)localObject;
            m = j;
          }
          else if (paramMenu.equals("item"))
          {
            localb.b(paramAttributeSet);
            i = k;
            paramMenu = (Menu)localObject;
            m = j;
          }
          else if (paramMenu.equals("menu"))
          {
            a(paramXmlPullParser, paramAttributeSet, localb.c());
            i = k;
            paramMenu = (Menu)localObject;
            m = j;
          }
          else
          {
            i = 1;
            m = j;
          }
        }
        break;
      case 1: 
        throw new RuntimeException("Unexpected end of document");
      }
      n = paramXmlPullParser.next();
      k = i;
      localObject = paramMenu;
      j = m;
    }
  }
  
  /* Error */
  public final void inflate(int paramInt, Menu paramMenu)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 130
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: iload_1
    //   9: aload_2
    //   10: invokespecial 132	android/view/MenuInflater:inflate	(ILandroid/view/Menu;)V
    //   13: return
    //   14: aconst_null
    //   15: astore 4
    //   17: aconst_null
    //   18: astore 5
    //   20: aconst_null
    //   21: astore_3
    //   22: aload_0
    //   23: getfield 36	com/tencent/token/hb:e	Landroid/content/Context;
    //   26: invokevirtual 136	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   29: iload_1
    //   30: invokevirtual 142	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   33: astore 6
    //   35: aload 6
    //   37: astore_3
    //   38: aload 6
    //   40: astore 4
    //   42: aload 6
    //   44: astore 5
    //   46: aload_0
    //   47: aload 6
    //   49: aload 6
    //   51: invokestatic 148	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   54: aload_2
    //   55: invokespecial 120	com/tencent/token/hb:a	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    //   58: aload 6
    //   60: ifnull +11 -> 71
    //   63: aload 6
    //   65: invokeinterface 153 1 0
    //   70: return
    //   71: return
    //   72: astore_2
    //   73: goto +33 -> 106
    //   76: astore_2
    //   77: aload 4
    //   79: astore_3
    //   80: new 155	android/view/InflateException
    //   83: dup
    //   84: ldc 157
    //   86: aload_2
    //   87: invokespecial 160	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   90: athrow
    //   91: astore_2
    //   92: aload 5
    //   94: astore_3
    //   95: new 155	android/view/InflateException
    //   98: dup
    //   99: ldc 157
    //   101: aload_2
    //   102: invokespecial 160	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   105: athrow
    //   106: aload_3
    //   107: ifnull +9 -> 116
    //   110: aload_3
    //   111: invokeinterface 153 1 0
    //   116: aload_2
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	hb
    //   0	118	1	paramInt	int
    //   0	118	2	paramMenu	Menu
    //   21	90	3	localObject1	Object
    //   15	63	4	localObject2	Object
    //   18	75	5	localObject3	Object
    //   33	31	6	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   22	35	72	finally
    //   46	58	72	finally
    //   80	91	72	finally
    //   95	106	72	finally
    //   22	35	76	java/io/IOException
    //   46	58	76	java/io/IOException
    //   22	35	91	org/xmlpull/v1/XmlPullParserException
    //   46	58	91	org/xmlpull/v1/XmlPullParserException
  }
  
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    private static final Class<?>[] a = { MenuItem.class };
    private Object b;
    private Method c;
    
    public a(Object paramObject, String paramString)
    {
      this.b = paramObject;
      Class localClass = paramObject.getClass();
      try
      {
        this.c = localClass.getMethod(paramString, a);
        return;
      }
      catch (Exception paramObject)
      {
        StringBuilder localStringBuilder = new StringBuilder("Couldn't resolve menu item onClick handler ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" in class ");
        localStringBuilder.append(localClass.getName());
        paramString = new InflateException(localStringBuilder.toString());
        paramString.initCause(paramObject);
        throw paramString;
      }
    }
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      try
      {
        if (this.c.getReturnType() == Boolean.TYPE) {
          return ((Boolean)this.c.invoke(this.b, new Object[] { paramMenuItem })).booleanValue();
        }
        this.c.invoke(this.b, new Object[] { paramMenuItem });
        return true;
      }
      catch (Exception paramMenuItem)
      {
        throw new RuntimeException(paramMenuItem);
      }
    }
  }
  
  final class b
  {
    private String A;
    private String B;
    private CharSequence C;
    private CharSequence D;
    private ColorStateList E = null;
    private PorterDuff.Mode F = null;
    boolean a;
    ei b;
    private Menu d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private CharSequence m;
    private CharSequence n;
    private int o;
    private char p;
    private int q;
    private char r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private int y;
    private String z;
    
    public b(Menu paramMenu)
    {
      this.d = paramMenu;
      a();
    }
    
    private static char a(String paramString)
    {
      if (paramString == null) {
        return '\000';
      }
      return paramString.charAt(0);
    }
    
    private <T> T a(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    {
      try
      {
        paramString = hb.this.e.getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass);
        paramString.setAccessible(true);
        paramString = paramString.newInstance(paramArrayOfObject);
        return paramString;
      }
      catch (Exception paramString)
      {
        label32:
        break label32;
      }
      return null;
    }
    
    private void a(MenuItem paramMenuItem)
    {
      Object localObject = paramMenuItem.setChecked(this.u).setVisible(this.v).setEnabled(this.w);
      int i2 = this.t;
      int i1 = 0;
      boolean bool;
      if (i2 > 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((MenuItem)localObject).setCheckable(bool).setTitleCondensed(this.n).setIcon(this.o);
      i2 = this.x;
      if (i2 >= 0) {
        paramMenuItem.setShowAsAction(i2);
      }
      if (this.B != null) {
        if (!hb.this.e.isRestricted())
        {
          localObject = hb.this;
          if (((hb)localObject).f == null) {
            ((hb)localObject).f = hb.a(((hb)localObject).e);
          }
          paramMenuItem.setOnMenuItemClickListener(new hb.a(((hb)localObject).f, this.B));
        }
        else
        {
          throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
        }
      }
      if (this.t >= 2) {
        if ((paramMenuItem instanceof hn)) {
          ((hn)paramMenuItem).a(true);
        } else if ((paramMenuItem instanceof ho)) {
          localObject = (ho)paramMenuItem;
        }
      }
      try
      {
        if (((ho)localObject).e == null) {
          ((ho)localObject).e = ((dn)((ho)localObject).d).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] { Boolean.TYPE });
        }
        ((ho)localObject).e.invoke(((ho)localObject).d, new Object[] { Boolean.TRUE });
      }
      catch (Exception localException)
      {
        label282:
        break label282;
      }
      localObject = this.z;
      if (localObject != null)
      {
        paramMenuItem.setActionView((View)a((String)localObject, hb.a, hb.this.c));
        i1 = 1;
      }
      i2 = this.y;
      if ((i2 > 0) && (i1 == 0)) {
        paramMenuItem.setActionView(i2);
      }
      localObject = this.b;
      if (localObject != null) {
        em.a(paramMenuItem, (ei)localObject);
      }
      em.a(paramMenuItem, this.C);
      em.b(paramMenuItem, this.D);
      em.b(paramMenuItem, this.p, this.q);
      em.a(paramMenuItem, this.r, this.s);
      localObject = this.F;
      if (localObject != null) {
        em.a(paramMenuItem, (PorterDuff.Mode)localObject);
      }
      localObject = this.E;
      if (localObject != null) {
        em.a(paramMenuItem, (ColorStateList)localObject);
      }
    }
    
    public final void a()
    {
      this.e = 0;
      this.f = 0;
      this.g = 0;
      this.h = 0;
      this.i = true;
      this.j = true;
    }
    
    public final void a(AttributeSet paramAttributeSet)
    {
      paramAttributeSet = hb.this.e.obtainStyledAttributes(paramAttributeSet, go.j.MenuGroup);
      this.e = paramAttributeSet.getResourceId(go.j.MenuGroup_android_id, 0);
      this.f = paramAttributeSet.getInt(go.j.MenuGroup_android_menuCategory, 0);
      this.g = paramAttributeSet.getInt(go.j.MenuGroup_android_orderInCategory, 0);
      this.h = paramAttributeSet.getInt(go.j.MenuGroup_android_checkableBehavior, 0);
      this.i = paramAttributeSet.getBoolean(go.j.MenuGroup_android_visible, true);
      this.j = paramAttributeSet.getBoolean(go.j.MenuGroup_android_enabled, true);
      paramAttributeSet.recycle();
    }
    
    public final void b()
    {
      this.a = true;
      a(this.d.add(this.e, this.k, this.l, this.m));
    }
    
    public final void b(AttributeSet paramAttributeSet)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final SubMenu c()
    {
      this.a = true;
      SubMenu localSubMenu = this.d.addSubMenu(this.e, this.k, this.l, this.m);
      a(localSubMenu.getItem());
      return localSubMenu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hb
 * JD-Core Version:    0.7.0.1
 */