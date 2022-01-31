package com.tencent.mobileqq.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.os.PowerManager;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Method;

@Deprecated
public class ReflectionUtil
{
  public static final int a = 7;
  public static final int b = 6;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  
  public static float a(Context paramContext, MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.getX(paramInt);
  }
  
  public static int a(Context paramContext)
  {
    return ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass();
  }
  
  public static int a(Context paramContext, MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getPointerCount();
  }
  
  public static int a(Context paramContext, MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.getPointerId(paramInt);
  }
  
  @TargetApi(11)
  public static int a(View paramView)
  {
    if (VersionUtils.e()) {
      return paramView.getLayerType();
    }
    return -5;
  }
  
  /* Error */
  public static int a(java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 72
    //   2: invokestatic 78	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore 5
    //   7: aload 5
    //   9: ifnonnull +5 -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: aload 5
    //   16: iconst_1
    //   17: anewarray 74	java/lang/Class
    //   20: dup
    //   21: iconst_0
    //   22: ldc 80
    //   24: aastore
    //   25: invokevirtual 84	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   28: iconst_1
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: aload_0
    //   35: aastore
    //   36: invokevirtual 90	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 94	java/lang/Object:getClass	()Ljava/lang/Class;
    //   44: ldc 96
    //   46: iconst_2
    //   47: anewarray 74	java/lang/Class
    //   50: dup
    //   51: iconst_0
    //   52: ldc 80
    //   54: aastore
    //   55: dup
    //   56: iconst_1
    //   57: getstatic 102	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   60: aastore
    //   61: invokevirtual 106	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   64: aload_0
    //   65: iconst_2
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc 108
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: iconst_1
    //   77: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   80: aastore
    //   81: invokevirtual 118	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   84: checkcast 98	java/lang/Integer
    //   87: invokevirtual 121	java/lang/Integer:intValue	()I
    //   90: istore_1
    //   91: aload_0
    //   92: invokevirtual 94	java/lang/Object:getClass	()Ljava/lang/Class;
    //   95: ldc 123
    //   97: invokevirtual 127	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   100: aconst_null
    //   101: invokevirtual 133	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   104: istore_2
    //   105: aload_0
    //   106: invokevirtual 94	java/lang/Object:getClass	()Ljava/lang/Class;
    //   109: ldc 135
    //   111: invokevirtual 127	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   114: aconst_null
    //   115: invokevirtual 133	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   118: istore_3
    //   119: aload_0
    //   120: invokevirtual 94	java/lang/Object:getClass	()Ljava/lang/Class;
    //   123: ldc 137
    //   125: invokevirtual 127	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   128: aconst_null
    //   129: invokevirtual 133	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   132: istore 4
    //   134: iload_1
    //   135: iload_2
    //   136: if_icmpeq +14 -> 150
    //   139: iload_1
    //   140: iload_3
    //   141: if_icmpeq +9 -> 150
    //   144: iload_1
    //   145: iload 4
    //   147: if_icmpne +21 -> 168
    //   150: iload_1
    //   151: bipush 90
    //   153: isub
    //   154: ireturn
    //   155: astore_0
    //   156: iconst_0
    //   157: istore_1
    //   158: aload_0
    //   159: invokevirtual 140	java/lang/Exception:printStackTrace	()V
    //   162: iload_1
    //   163: ireturn
    //   164: astore_0
    //   165: goto -7 -> 158
    //   168: iload_1
    //   169: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramString	java.lang.String
    //   90	79	1	i	int
    //   104	33	2	j	int
    //   118	24	3	k	int
    //   132	16	4	m	int
    //   5	10	5	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   0	7	155	java/lang/Exception
    //   14	91	155	java/lang/Exception
    //   91	134	164	java/lang/Exception
  }
  
  @TargetApi(7)
  public static void a(Context paramContext, Object paramObject, Uri paramUri)
  {
    try
    {
      paramObject.getClass().getMethod("onReceiveValue", new Class[] { Uri.class }).invoke(paramObject, new Object[] { paramUri });
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("reflection", 2, "e = " + paramContext.toString());
    }
  }
  
  @TargetApi(11)
  public static void a(View paramView, int paramInt, Paint paramPaint)
  {
    if (VersionUtils.e()) {
      paramView.setLayerType(paramInt, paramPaint);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      boolean bool = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static float b(Context paramContext, MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.getY(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.ReflectionUtil
 * JD-Core Version:    0.7.0.1
 */