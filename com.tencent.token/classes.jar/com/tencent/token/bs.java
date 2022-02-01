package com.tencent.token;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public final class bs
{
  /* Error */
  public static Animator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_1
    //   10: iload_3
    //   11: invokevirtual 18	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   14: astore 7
    //   16: aload 7
    //   18: astore 4
    //   20: aload 7
    //   22: astore 5
    //   24: aload 7
    //   26: astore 6
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: aload 7
    //   33: aload 7
    //   35: invokestatic 24	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   38: aconst_null
    //   39: iconst_0
    //   40: fconst_1
    //   41: invokestatic 27	com/tencent/token/bs:a	(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/animation/AnimatorSet;IF)Landroid/animation/Animator;
    //   44: astore_0
    //   45: aload 7
    //   47: ifnull +10 -> 57
    //   50: aload 7
    //   52: invokeinterface 33 1 0
    //   57: aload_0
    //   58: areturn
    //   59: astore_0
    //   60: goto +123 -> 183
    //   63: astore_0
    //   64: aload 5
    //   66: astore 4
    //   68: new 35	java/lang/StringBuilder
    //   71: dup
    //   72: ldc 37
    //   74: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: astore_1
    //   78: aload 5
    //   80: astore 4
    //   82: aload_1
    //   83: iload_3
    //   84: invokestatic 47	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   87: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 5
    //   93: astore 4
    //   95: new 53	android/content/res/Resources$NotFoundException
    //   98: dup
    //   99: aload_1
    //   100: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokespecial 58	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   106: astore_1
    //   107: aload 5
    //   109: astore 4
    //   111: aload_1
    //   112: aload_0
    //   113: invokevirtual 62	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   116: pop
    //   117: aload 5
    //   119: astore 4
    //   121: aload_1
    //   122: athrow
    //   123: astore_0
    //   124: aload 6
    //   126: astore 4
    //   128: new 35	java/lang/StringBuilder
    //   131: dup
    //   132: ldc 37
    //   134: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: astore_1
    //   138: aload 6
    //   140: astore 4
    //   142: aload_1
    //   143: iload_3
    //   144: invokestatic 47	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   147: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 6
    //   153: astore 4
    //   155: new 53	android/content/res/Resources$NotFoundException
    //   158: dup
    //   159: aload_1
    //   160: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokespecial 58	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   166: astore_1
    //   167: aload 6
    //   169: astore 4
    //   171: aload_1
    //   172: aload_0
    //   173: invokevirtual 62	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   176: pop
    //   177: aload 6
    //   179: astore 4
    //   181: aload_1
    //   182: athrow
    //   183: aload 4
    //   185: ifnull +10 -> 195
    //   188: aload 4
    //   190: invokeinterface 33 1 0
    //   195: aload_0
    //   196: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramContext	Context
    //   0	197	1	paramResources	Resources
    //   0	197	2	paramTheme	Resources.Theme
    //   0	197	3	paramInt	int
    //   7	182	4	localObject1	Object
    //   1	117	5	localObject2	Object
    //   4	174	6	localObject3	Object
    //   14	37	7	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   9	16	59	finally
    //   28	45	59	finally
    //   68	78	59	finally
    //   82	91	59	finally
    //   95	107	59	finally
    //   111	117	59	finally
    //   121	123	59	finally
    //   128	138	59	finally
    //   142	151	59	finally
    //   155	167	59	finally
    //   171	177	59	finally
    //   181	183	59	finally
    //   9	16	63	java/io/IOException
    //   28	45	63	java/io/IOException
    //   9	16	123	org/xmlpull/v1/XmlPullParserException
    //   28	45	123	org/xmlpull/v1/XmlPullParserException
  }
  
  private static Animator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, AnimatorSet paramAnimatorSet, int paramInt, float paramFloat)
  {
    int k = paramXmlPullParser.getDepth();
    Object localObject3 = null;
    Object localObject2 = null;
    int j;
    int i;
    for (;;)
    {
      int m = paramXmlPullParser.next();
      j = 0;
      i = 0;
      if (((m == 3) && (paramXmlPullParser.getDepth() <= k)) || (m == 1)) {
        break;
      }
      if (m == 2)
      {
        Object localObject1 = paramXmlPullParser.getName();
        if (((String)localObject1).equals("objectAnimator"))
        {
          localObject1 = a(paramContext, paramResources, paramTheme, paramAttributeSet, paramFloat, paramXmlPullParser);
        }
        else if (((String)localObject1).equals("animator"))
        {
          localObject1 = a(paramContext, paramResources, paramTheme, paramAttributeSet, null, paramFloat, paramXmlPullParser);
        }
        else if (((String)localObject1).equals("set"))
        {
          localObject1 = new AnimatorSet();
          localObject3 = db.a(paramResources, paramTheme, paramAttributeSet, bo.h);
          j = db.a((TypedArray)localObject3, paramXmlPullParser, "ordering", 0, 0);
          a(paramContext, paramResources, paramTheme, paramXmlPullParser, paramAttributeSet, (AnimatorSet)localObject1, j, paramFloat);
          ((TypedArray)localObject3).recycle();
        }
        else
        {
          if (!((String)localObject1).equals("propertyValuesHolder")) {
            break label301;
          }
          localObject1 = a(paramContext, paramResources, paramTheme, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser));
          if ((localObject1 != null) && (localObject3 != null) && ((localObject3 instanceof ValueAnimator))) {
            ((ValueAnimator)localObject3).setValues((PropertyValuesHolder[])localObject1);
          }
          i = 1;
          localObject1 = localObject3;
        }
        localObject3 = localObject1;
        if (paramAnimatorSet != null)
        {
          localObject3 = localObject1;
          if (i == 0)
          {
            Object localObject4 = localObject2;
            if (localObject2 == null) {
              localObject4 = new ArrayList();
            }
            ((ArrayList)localObject4).add(localObject1);
            localObject3 = localObject1;
            localObject2 = localObject4;
            continue;
            label301:
            paramContext = new StringBuilder("Unknown animator name: ");
            paramContext.append(paramXmlPullParser.getName());
            throw new RuntimeException(paramContext.toString());
          }
        }
      }
    }
    if ((paramAnimatorSet != null) && (localObject2 != null))
    {
      paramContext = new Animator[localObject2.size()];
      paramResources = localObject2.iterator();
      i = j;
      while (paramResources.hasNext())
      {
        paramContext[i] = ((Animator)paramResources.next());
        i += 1;
      }
      if (paramInt == 0)
      {
        paramAnimatorSet.playTogether(paramContext);
        return localObject3;
      }
      paramAnimatorSet.playSequentially(paramContext);
    }
    return localObject3;
  }
  
  private static Keyframe a(Keyframe paramKeyframe, float paramFloat)
  {
    if (paramKeyframe.getType() == Float.TYPE) {
      return Keyframe.ofFloat(paramFloat);
    }
    if (paramKeyframe.getType() == Integer.TYPE) {
      return Keyframe.ofInt(paramFloat);
    }
    return Keyframe.ofObject(paramFloat);
  }
  
  private static ObjectAnimator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    a(paramContext, paramResources, paramTheme, paramAttributeSet, localObjectAnimator, paramFloat, paramXmlPullParser);
    return localObjectAnimator;
  }
  
  private static PropertyValuesHolder a(TypedArray paramTypedArray, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Object localObject = paramTypedArray.peekValue(paramInt2);
    int j;
    if (localObject != null) {
      j = 1;
    } else {
      j = 0;
    }
    int m;
    if (j != 0) {
      m = ((TypedValue)localObject).type;
    } else {
      m = 0;
    }
    localObject = paramTypedArray.peekValue(paramInt3);
    int k;
    if (localObject != null) {
      k = 1;
    } else {
      k = 0;
    }
    int n;
    if (k != 0) {
      n = ((TypedValue)localObject).type;
    } else {
      n = 0;
    }
    int i = paramInt1;
    if (paramInt1 == 4) {
      if (((j != 0) && (a(m))) || ((k != 0) && (a(n)))) {
        i = 3;
      } else {
        i = 0;
      }
    }
    if (i == 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (i == 2)
    {
      localObject = paramTypedArray.getString(paramInt2);
      paramTypedArray = paramTypedArray.getString(paramInt3);
      dd.b[] arrayOfb1 = dd.b((String)localObject);
      dd.b[] arrayOfb2 = dd.b(paramTypedArray);
      if ((arrayOfb1 != null) || (arrayOfb2 != null))
      {
        if (arrayOfb1 != null)
        {
          a locala = new a((byte)0);
          if (arrayOfb2 != null)
          {
            if (dd.a(arrayOfb1, arrayOfb2)) {
              return PropertyValuesHolder.ofObject(paramString, locala, new Object[] { arrayOfb1, arrayOfb2 });
            }
            paramString = new StringBuilder(" Can't morph from ");
            paramString.append((String)localObject);
            paramString.append(" to ");
            paramString.append(paramTypedArray);
            throw new InflateException(paramString.toString());
          }
          return PropertyValuesHolder.ofObject(paramString, locala, new Object[] { arrayOfb1 });
        }
        if (arrayOfb2 != null) {
          return PropertyValuesHolder.ofObject(paramString, new a((byte)0), new Object[] { arrayOfb2 });
        }
      }
      return null;
    }
    if (i == 3) {
      localObject = bt.a();
    } else {
      localObject = null;
    }
    if (paramInt1 != 0)
    {
      float f1;
      if (j != 0)
      {
        if (m == 5) {
          f1 = paramTypedArray.getDimension(paramInt2, 0.0F);
        } else {
          f1 = paramTypedArray.getFloat(paramInt2, 0.0F);
        }
        if (k != 0)
        {
          float f2;
          if (n == 5) {
            f2 = paramTypedArray.getDimension(paramInt3, 0.0F);
          } else {
            f2 = paramTypedArray.getFloat(paramInt3, 0.0F);
          }
          paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1, f2 });
        }
        else
        {
          paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1 });
        }
      }
      else
      {
        if (n == 5) {
          f1 = paramTypedArray.getDimension(paramInt3, 0.0F);
        } else {
          f1 = paramTypedArray.getFloat(paramInt3, 0.0F);
        }
        paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1 });
      }
    }
    else if (j != 0)
    {
      if (m == 5) {
        paramInt1 = (int)paramTypedArray.getDimension(paramInt2, 0.0F);
      } else if (a(m)) {
        paramInt1 = paramTypedArray.getColor(paramInt2, 0);
      } else {
        paramInt1 = paramTypedArray.getInt(paramInt2, 0);
      }
      if (k != 0)
      {
        if (n == 5) {
          paramInt2 = (int)paramTypedArray.getDimension(paramInt3, 0.0F);
        } else if (a(n)) {
          paramInt2 = paramTypedArray.getColor(paramInt3, 0);
        } else {
          paramInt2 = paramTypedArray.getInt(paramInt3, 0);
        }
        paramTypedArray = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1, paramInt2 });
      }
      else
      {
        paramTypedArray = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1 });
      }
    }
    else if (k != 0)
    {
      if (n == 5) {
        paramInt1 = (int)paramTypedArray.getDimension(paramInt3, 0.0F);
      } else if (a(n)) {
        paramInt1 = paramTypedArray.getColor(paramInt3, 0);
      } else {
        paramInt1 = paramTypedArray.getInt(paramInt3, 0);
      }
      paramTypedArray = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1 });
    }
    else
    {
      paramTypedArray = null;
    }
    if ((paramTypedArray != null) && (localObject != null)) {
      paramTypedArray.setEvaluator((TypeEvaluator)localObject);
    }
    return paramTypedArray;
  }
  
  private static ValueAnimator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, ValueAnimator paramValueAnimator, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    TypedArray localTypedArray = db.a(paramResources, paramTheme, paramAttributeSet, bo.g);
    paramTheme = db.a(paramResources, paramTheme, paramAttributeSet, bo.k);
    paramResources = paramValueAnimator;
    if (paramValueAnimator == null) {
      paramResources = new ValueAnimator();
    }
    a(paramResources, localTypedArray, paramTheme, paramFloat, paramXmlPullParser);
    int i = db.a(localTypedArray, paramXmlPullParser, "interpolator", 0);
    if (i > 0) {
      paramResources.setInterpolator(br.a(paramContext, i));
    }
    localTypedArray.recycle();
    if (paramTheme != null) {
      paramTheme.recycle();
    }
    return paramResources;
  }
  
  private static void a(ValueAnimator paramValueAnimator, TypedArray paramTypedArray1, TypedArray paramTypedArray2, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    long l1 = db.a(paramTypedArray1, paramXmlPullParser, "duration", 1, 300);
    long l2 = db.a(paramTypedArray1, paramXmlPullParser, "startOffset", 2, 0);
    int j = db.a(paramTypedArray1, paramXmlPullParser, "valueType", 7, 4);
    Object localObject;
    if ((db.a(paramXmlPullParser, "valueFrom")) && (db.a(paramXmlPullParser, "valueTo")))
    {
      int i = j;
      if (j == 4)
      {
        localObject = paramTypedArray1.peekValue(5);
        if (localObject != null) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          j = ((TypedValue)localObject).type;
        } else {
          j = 0;
        }
        localObject = paramTypedArray1.peekValue(6);
        int k;
        if (localObject != null) {
          k = 1;
        } else {
          k = 0;
        }
        int m;
        if (k != 0) {
          m = ((TypedValue)localObject).type;
        } else {
          m = 0;
        }
        if (((i != 0) && (a(j))) || ((k != 0) && (a(m)))) {
          i = 3;
        } else {
          i = 0;
        }
      }
      localObject = a(paramTypedArray1, i, 5, 6, "");
      if (localObject != null) {
        paramValueAnimator.setValues(new PropertyValuesHolder[] { localObject });
      }
    }
    paramValueAnimator.setDuration(l1);
    paramValueAnimator.setStartDelay(l2);
    paramValueAnimator.setRepeatCount(db.a(paramTypedArray1, paramXmlPullParser, "repeatCount", 3, 0));
    paramValueAnimator.setRepeatMode(db.a(paramTypedArray1, paramXmlPullParser, "repeatMode", 4, 1));
    if (paramTypedArray2 != null)
    {
      paramValueAnimator = (ObjectAnimator)paramValueAnimator;
      paramTypedArray1 = db.b(paramTypedArray2, paramXmlPullParser, "pathData", 1);
      if (paramTypedArray1 != null)
      {
        localObject = db.b(paramTypedArray2, paramXmlPullParser, "propertyXName", 2);
        paramXmlPullParser = db.b(paramTypedArray2, paramXmlPullParser, "propertyYName", 3);
        if ((localObject == null) && (paramXmlPullParser == null))
        {
          paramValueAnimator = new StringBuilder();
          paramValueAnimator.append(paramTypedArray2.getPositionDescription());
          paramValueAnimator.append(" propertyXName or propertyYName is needed for PathData");
          throw new InflateException(paramValueAnimator.toString());
        }
        a(dd.a(paramTypedArray1), paramValueAnimator, 0.5F * paramFloat, (String)localObject, paramXmlPullParser);
        return;
      }
      paramValueAnimator.setPropertyName(db.b(paramTypedArray2, paramXmlPullParser, "propertyName", 0));
    }
  }
  
  private static void a(Path paramPath, ObjectAnimator paramObjectAnimator, float paramFloat, String paramString1, String paramString2)
  {
    PathMeasure localPathMeasure = new PathMeasure(paramPath, false);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Float.valueOf(0.0F));
    float f1 = 0.0F;
    float f2;
    do
    {
      f2 = f1 + localPathMeasure.getLength();
      localArrayList.add(Float.valueOf(f2));
      f1 = f2;
    } while (localPathMeasure.nextContour());
    paramPath = new PathMeasure(paramPath, false);
    int n = Math.min(100, (int)(f2 / paramFloat) + 1);
    float[] arrayOfFloat2 = new float[n];
    float[] arrayOfFloat1 = new float[n];
    float[] arrayOfFloat3 = new float[2];
    f2 /= (n - 1);
    int i = 0;
    paramFloat = 0.0F;
    int k;
    for (int j = 0;; j = k)
    {
      localPathMeasure = null;
      if (i >= n) {
        break;
      }
      paramPath.getPosTan(paramFloat, arrayOfFloat3, null);
      arrayOfFloat2[i] = arrayOfFloat3[0];
      arrayOfFloat1[i] = arrayOfFloat3[1];
      f1 = paramFloat + f2;
      int m = j + 1;
      paramFloat = f1;
      k = j;
      if (m < localArrayList.size())
      {
        paramFloat = f1;
        k = j;
        if (f1 > ((Float)localArrayList.get(m)).floatValue())
        {
          paramFloat = f1 - ((Float)localArrayList.get(m)).floatValue();
          paramPath.nextContour();
          k = m;
        }
      }
      i += 1;
    }
    if (paramString1 != null) {
      paramPath = PropertyValuesHolder.ofFloat(paramString1, arrayOfFloat2);
    } else {
      paramPath = null;
    }
    paramString1 = localPathMeasure;
    if (paramString2 != null) {
      paramString1 = PropertyValuesHolder.ofFloat(paramString2, arrayOfFloat1);
    }
    if (paramPath == null)
    {
      paramObjectAnimator.setValues(new PropertyValuesHolder[] { paramString1 });
      return;
    }
    if (paramString1 == null)
    {
      paramObjectAnimator.setValues(new PropertyValuesHolder[] { paramPath });
      return;
    }
    paramObjectAnimator.setValues(new PropertyValuesHolder[] { paramPath, paramString1 });
  }
  
  private static void a(Keyframe[] paramArrayOfKeyframe, float paramFloat, int paramInt1, int paramInt2)
  {
    paramFloat /= (paramInt2 - paramInt1 + 2);
    while (paramInt1 <= paramInt2)
    {
      paramArrayOfKeyframe[paramInt1].setFraction(paramArrayOfKeyframe[(paramInt1 - 1)].getFraction() + paramFloat);
      paramInt1 += 1;
    }
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt >= 28) && (paramInt <= 31);
  }
  
  private static PropertyValuesHolder[] a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    Object localObject2 = null;
    int j;
    for (;;)
    {
      i = paramXmlPullParser.getEventType();
      if ((i == 3) || (i == 1)) {
        break;
      }
      if (i != 2)
      {
        paramXmlPullParser.next();
      }
      else
      {
        Object localObject1;
        if (paramXmlPullParser.getName().equals("propertyValuesHolder"))
        {
          TypedArray localTypedArray = db.a(paramResources, paramTheme, paramAttributeSet, bo.i);
          String str = db.b(localTypedArray, paramXmlPullParser, "propertyName", 3);
          int i1 = db.a(localTypedArray, paramXmlPullParser, "valueType", 2, 4);
          j = i1;
          Object localObject3 = null;
          Object localObject4;
          float f;
          int k;
          for (;;)
          {
            i = paramXmlPullParser.next();
            if ((i == 3) || (i == 1)) {
              break;
            }
            if (paramXmlPullParser.getName().equals("keyframe"))
            {
              i = j;
              if (j == 4)
              {
                localObject1 = db.a(paramResources, paramTheme, Xml.asAttributeSet(paramXmlPullParser), bo.j);
                localObject4 = db.a((TypedArray)localObject1, paramXmlPullParser, "value");
                if (localObject4 != null) {
                  i = 1;
                } else {
                  i = 0;
                }
                if ((i != 0) && (a(((TypedValue)localObject4).type))) {
                  i = 3;
                } else {
                  i = 0;
                }
                ((TypedArray)localObject1).recycle();
              }
              localObject4 = db.a(paramResources, paramTheme, Xml.asAttributeSet(paramXmlPullParser), bo.j);
              f = db.a((TypedArray)localObject4, paramXmlPullParser, "fraction", 3, -1.0F);
              localObject1 = db.a((TypedArray)localObject4, paramXmlPullParser, "value");
              if (localObject1 != null) {
                k = 1;
              } else {
                k = 0;
              }
              if (i == 4)
              {
                if ((k != 0) && (a(((TypedValue)localObject1).type))) {
                  j = 3;
                } else {
                  j = 0;
                }
              }
              else {
                j = i;
              }
              if (k != 0)
              {
                if (j != 3) {
                  switch (j)
                  {
                  default: 
                    localObject1 = null;
                    break;
                  case 0: 
                    localObject1 = Keyframe.ofFloat(f, db.a((TypedArray)localObject4, paramXmlPullParser, "value", 0, 0.0F));
                    break;
                  }
                } else {
                  localObject1 = Keyframe.ofInt(f, db.a((TypedArray)localObject4, paramXmlPullParser, "value", 0, 0));
                }
              }
              else if (j == 0) {
                localObject1 = Keyframe.ofFloat(f);
              } else {
                localObject1 = Keyframe.ofInt(f);
              }
              j = db.a((TypedArray)localObject4, paramXmlPullParser, "interpolator", 1);
              if (j > 0) {
                ((Keyframe)localObject1).setInterpolator(br.a(paramContext, j));
              }
              ((TypedArray)localObject4).recycle();
              localObject4 = localObject3;
              if (localObject1 != null)
              {
                localObject4 = localObject3;
                if (localObject3 == null) {
                  localObject4 = new ArrayList();
                }
                ((ArrayList)localObject4).add(localObject1);
              }
              paramXmlPullParser.next();
              localObject3 = localObject4;
            }
            else
            {
              i = j;
            }
            j = i;
          }
          if (localObject3 != null)
          {
            k = ((ArrayList)localObject3).size();
            if (k > 0)
            {
              localObject1 = (Keyframe)((ArrayList)localObject3).get(0);
              localObject4 = (Keyframe)((ArrayList)localObject3).get(k - 1);
              f = ((Keyframe)localObject4).getFraction();
              i = k;
              if (f < 1.0F) {
                if (f < 0.0F)
                {
                  ((Keyframe)localObject4).setFraction(1.0F);
                  i = k;
                }
                else
                {
                  ((ArrayList)localObject3).add(((ArrayList)localObject3).size(), a((Keyframe)localObject4, 1.0F));
                  i = k + 1;
                }
              }
              f = ((Keyframe)localObject1).getFraction();
              int m = i;
              if (f != 0.0F) {
                if (f < 0.0F)
                {
                  ((Keyframe)localObject1).setFraction(0.0F);
                  m = i;
                }
                else
                {
                  ((ArrayList)localObject3).add(0, a((Keyframe)localObject1, 0.0F));
                  m = i + 1;
                }
              }
              localObject1 = new Keyframe[m];
              ((ArrayList)localObject3).toArray((Object[])localObject1);
              i = 0;
              while (i < m)
              {
                localObject3 = localObject1[i];
                if (((Keyframe)localObject3).getFraction() < 0.0F) {
                  if (i == 0)
                  {
                    ((Keyframe)localObject3).setFraction(0.0F);
                  }
                  else
                  {
                    int i2 = m - 1;
                    if (i == i2)
                    {
                      ((Keyframe)localObject3).setFraction(1.0F);
                    }
                    else
                    {
                      k = i + 1;
                      int n = i;
                      while ((k < i2) && (localObject1[k].getFraction() < 0.0F))
                      {
                        n = k;
                        k += 1;
                      }
                      a((Keyframe[])localObject1, localObject1[(n + 1)].getFraction() - localObject1[(i - 1)].getFraction(), i, n);
                    }
                  }
                }
                i += 1;
              }
              localObject3 = PropertyValuesHolder.ofKeyframe(str, (Keyframe[])localObject1);
              localObject1 = localObject3;
              if (j != 3) {
                break label864;
              }
              ((PropertyValuesHolder)localObject3).setEvaluator(bt.a());
              localObject1 = localObject3;
              break label864;
            }
          }
          localObject1 = null;
          label864:
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = a(localTypedArray, i1, 0, 1, str);
          }
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = new ArrayList();
            }
            ((ArrayList)localObject1).add(localObject3);
          }
          localTypedArray.recycle();
        }
        else
        {
          localObject1 = localObject2;
        }
        paramXmlPullParser.next();
        localObject2 = localObject1;
      }
    }
    int i = 0;
    if (localObject2 != null)
    {
      j = localObject2.size();
      paramContext = new PropertyValuesHolder[j];
      while (i < j)
      {
        paramContext[i] = ((PropertyValuesHolder)localObject2.get(i));
        i += 1;
      }
      return paramContext;
    }
    return null;
  }
  
  static final class a
    implements TypeEvaluator<dd.b[]>
  {
    private dd.b[] a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bs
 * JD-Core Version:    0.7.0.1
 */