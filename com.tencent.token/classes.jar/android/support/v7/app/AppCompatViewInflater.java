package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.du;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class AppCompatViewInflater
{
  static final int[] a = { 16843375 };
  private static final Class<?>[] b = { Context.class, AttributeSet.class };
  private static final String[] c = { "android.widget.", "android.view.", "android.webkit." };
  private static final Map<String, Constructor<? extends View>> d = new du();
  private final Object[] e = new Object[2];
  
  private View a(Context paramContext, String paramString1, String paramString2)
  {
    Constructor localConstructor = (Constructor)d.get(paramString1);
    Object localObject = localConstructor;
    if (localConstructor == null) {}
    try
    {
      localObject = paramContext.getClassLoader();
      if (paramString2 == null) {
        break label119;
      }
      paramContext = new StringBuilder();
      paramContext.append(paramString2);
      paramContext.append(paramString1);
      paramContext = paramContext.toString();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        continue;
        paramContext = paramString1;
      }
    }
    localObject = ((ClassLoader)localObject).loadClass(paramContext).asSubclass(View.class).getConstructor(b);
    d.put(paramString1, localObject);
    ((Constructor)localObject).setAccessible(true);
    paramContext = (View)((Constructor)localObject).newInstance(this.e);
    return paramContext;
    return null;
  }
  
  /* Error */
  final View a(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore 5
    //   3: aload_2
    //   4: ldc 109
    //   6: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +14 -> 23
    //   12: aload_3
    //   13: aconst_null
    //   14: ldc 115
    //   16: invokeinterface 119 3 0
    //   21: astore 5
    //   23: aload_0
    //   24: getfield 52	android/support/v7/app/AppCompatViewInflater:e	[Ljava/lang/Object;
    //   27: iconst_0
    //   28: aload_1
    //   29: aastore
    //   30: aload_0
    //   31: getfield 52	android/support/v7/app/AppCompatViewInflater:e	[Ljava/lang/Object;
    //   34: iconst_1
    //   35: aload_3
    //   36: aastore
    //   37: iconst_m1
    //   38: aload 5
    //   40: bipush 46
    //   42: invokevirtual 123	java/lang/String:indexOf	(I)I
    //   45: if_icmpne +72 -> 117
    //   48: iconst_0
    //   49: istore 4
    //   51: iload 4
    //   53: getstatic 41	android/support/v7/app/AppCompatViewInflater:c	[Ljava/lang/String;
    //   56: arraylength
    //   57: if_icmpge +45 -> 102
    //   60: aload_0
    //   61: aload_1
    //   62: aload 5
    //   64: getstatic 41	android/support/v7/app/AppCompatViewInflater:c	[Ljava/lang/String;
    //   67: iload 4
    //   69: aaload
    //   70: invokespecial 125	android/support/v7/app/AppCompatViewInflater:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/view/View;
    //   73: astore_2
    //   74: aload_2
    //   75: ifnull +18 -> 93
    //   78: aload_0
    //   79: getfield 52	android/support/v7/app/AppCompatViewInflater:e	[Ljava/lang/Object;
    //   82: astore_1
    //   83: aload_1
    //   84: iconst_0
    //   85: aconst_null
    //   86: aastore
    //   87: aload_1
    //   88: iconst_1
    //   89: aconst_null
    //   90: aastore
    //   91: aload_2
    //   92: areturn
    //   93: iload 4
    //   95: iconst_1
    //   96: iadd
    //   97: istore 4
    //   99: goto -48 -> 51
    //   102: aload_0
    //   103: getfield 52	android/support/v7/app/AppCompatViewInflater:e	[Ljava/lang/Object;
    //   106: astore_1
    //   107: aload_1
    //   108: iconst_0
    //   109: aconst_null
    //   110: aastore
    //   111: aload_1
    //   112: iconst_1
    //   113: aconst_null
    //   114: aastore
    //   115: aconst_null
    //   116: areturn
    //   117: aload_0
    //   118: aload_1
    //   119: aload 5
    //   121: aconst_null
    //   122: invokespecial 125	android/support/v7/app/AppCompatViewInflater:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/view/View;
    //   125: astore_1
    //   126: aload_0
    //   127: getfield 52	android/support/v7/app/AppCompatViewInflater:e	[Ljava/lang/Object;
    //   130: astore_2
    //   131: aload_2
    //   132: iconst_0
    //   133: aconst_null
    //   134: aastore
    //   135: aload_2
    //   136: iconst_1
    //   137: aconst_null
    //   138: aastore
    //   139: aload_1
    //   140: areturn
    //   141: astore_1
    //   142: aload_0
    //   143: getfield 52	android/support/v7/app/AppCompatViewInflater:e	[Ljava/lang/Object;
    //   146: astore_2
    //   147: aload_2
    //   148: iconst_0
    //   149: aconst_null
    //   150: aastore
    //   151: aload_2
    //   152: iconst_1
    //   153: aconst_null
    //   154: aastore
    //   155: aload_1
    //   156: athrow
    //   157: aload_0
    //   158: getfield 52	android/support/v7/app/AppCompatViewInflater:e	[Ljava/lang/Object;
    //   161: astore_1
    //   162: aload_1
    //   163: iconst_0
    //   164: aconst_null
    //   165: aastore
    //   166: aload_1
    //   167: iconst_1
    //   168: aconst_null
    //   169: aastore
    //   170: aconst_null
    //   171: areturn
    //   172: astore_1
    //   173: goto -16 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	AppCompatViewInflater
    //   0	176	1	paramContext	Context
    //   0	176	2	paramString	String
    //   0	176	3	paramAttributeSet	AttributeSet
    //   49	49	4	i	int
    //   1	119	5	str	String
    // Exception table:
    //   from	to	target	type
    //   23	48	141	finally
    //   51	74	141	finally
    //   117	126	141	finally
    //   23	48	172	java/lang/Exception
    //   51	74	172	java/lang/Exception
    //   117	126	172	java/lang/Exception
  }
  
  static final class a
    implements View.OnClickListener
  {
    private final View a;
    private final String b;
    private Method c;
    private Context d;
    
    public a(View paramView, String paramString)
    {
      this.a = paramView;
      this.b = paramString;
    }
    
    public final void onClick(View paramView)
    {
      if (this.c == null)
      {
        Object localObject = this.a.getContext();
        while (localObject != null)
        {
          try
          {
            if (!((Context)localObject).isRestricted())
            {
              Method localMethod = localObject.getClass().getMethod(this.b, new Class[] { View.class });
              if (localMethod != null)
              {
                this.c = localMethod;
                this.d = ((Context)localObject);
              }
            }
          }
          catch (NoSuchMethodException localNoSuchMethodException)
          {
            label67:
            int i;
            break label67;
          }
          if ((localObject instanceof ContextWrapper)) {
            localObject = ((ContextWrapper)localObject).getBaseContext();
          } else {
            localObject = null;
          }
        }
        i = this.a.getId();
        if (i == -1)
        {
          paramView = "";
        }
        else
        {
          paramView = new StringBuilder(" with id '");
          paramView.append(this.a.getContext().getResources().getResourceEntryName(i));
          paramView.append("'");
          paramView = paramView.toString();
        }
        localObject = new StringBuilder("Could not find method ");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
        ((StringBuilder)localObject).append(this.a.getClass());
        ((StringBuilder)localObject).append(paramView);
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
      else
      {
        try
        {
          this.c.invoke(this.d, new Object[] { paramView });
          return;
        }
        catch (InvocationTargetException paramView)
        {
          throw new IllegalStateException("Could not execute method for android:onClick", paramView);
        }
        catch (IllegalAccessException paramView)
        {
          throw new IllegalStateException("Could not execute non-public method for android:onClick", paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatViewInflater
 * JD-Core Version:    0.7.0.1
 */