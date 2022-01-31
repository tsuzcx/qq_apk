package android.support.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
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
import android.os.Build.VERSION;
import android.support.annotation.AnimatorRes;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.support.v4.graphics.PathParser.PathDataNode;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class AnimatorInflaterCompat
{
  private static final boolean DBG_ANIMATOR_INFLATER = false;
  private static final int MAX_NUM_POINTS = 100;
  private static final String TAG = "AnimatorInflater";
  private static final int TOGETHER = 0;
  private static final int VALUE_TYPE_COLOR = 3;
  private static final int VALUE_TYPE_FLOAT = 0;
  private static final int VALUE_TYPE_INT = 1;
  private static final int VALUE_TYPE_PATH = 2;
  private static final int VALUE_TYPE_UNDEFINED = 4;
  
  private static Animator createAnimatorFromXml(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, float paramFloat)
  {
    return createAnimatorFromXml(paramContext, paramResources, paramTheme, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser), null, 0, paramFloat);
  }
  
  private static Animator createAnimatorFromXml(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, AnimatorSet paramAnimatorSet, int paramInt, float paramFloat)
  {
    Object localObject2 = null;
    ArrayList localArrayList = null;
    int j = paramXmlPullParser.getDepth();
    int i;
    Object localObject1;
    label85:
    do
    {
      do
      {
        do
        {
          i = paramXmlPullParser.next();
          if (((i == 3) && (paramXmlPullParser.getDepth() <= j)) || (i == 1)) {
            break;
          }
        } while (i != 2);
        localObject1 = paramXmlPullParser.getName();
        if (!((String)localObject1).equals("objectAnimator")) {
          break;
        }
        localObject1 = loadObjectAnimator(paramContext, paramResources, paramTheme, paramAttributeSet, paramFloat, paramXmlPullParser);
        i = 0;
        localObject2 = localObject1;
      } while (paramAnimatorSet == null);
      localObject2 = localObject1;
    } while (i != 0);
    if (localArrayList == null) {
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      localArrayList.add(localObject1);
      localObject2 = localObject1;
      break;
      if (((String)localObject1).equals("animator"))
      {
        localObject1 = loadAnimator(paramContext, paramResources, paramTheme, paramAttributeSet, null, paramFloat, paramXmlPullParser);
        i = 0;
        break label85;
      }
      if (((String)localObject1).equals("set"))
      {
        localObject1 = new AnimatorSet();
        localObject2 = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_ANIMATOR_SET);
        i = TypedArrayUtils.getNamedInt((TypedArray)localObject2, paramXmlPullParser, "ordering", 0, 0);
        createAnimatorFromXml(paramContext, paramResources, paramTheme, paramXmlPullParser, paramAttributeSet, (AnimatorSet)localObject1, i, paramFloat);
        ((TypedArray)localObject2).recycle();
        i = 0;
        break label85;
      }
      if (((String)localObject1).equals("propertyValuesHolder"))
      {
        localObject1 = loadValues(paramContext, paramResources, paramTheme, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser));
        if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof ValueAnimator))) {
          ((ValueAnimator)localObject2).setValues((PropertyValuesHolder[])localObject1);
        }
        i = 1;
        localObject1 = localObject2;
        break label85;
      }
      throw new RuntimeException("Unknown animator name: " + paramXmlPullParser.getName());
      if ((paramAnimatorSet != null) && (localArrayList != null))
      {
        paramContext = new Animator[localArrayList.size()];
        paramResources = localArrayList.iterator();
        i = 0;
        while (paramResources.hasNext())
        {
          paramContext[i] = ((Animator)paramResources.next());
          i += 1;
        }
        if (paramInt == 0) {
          paramAnimatorSet.playTogether(paramContext);
        }
      }
      else
      {
        return localObject2;
      }
      paramAnimatorSet.playSequentially(paramContext);
      return localObject2;
    }
  }
  
  private static Keyframe createNewKeyframe(Keyframe paramKeyframe, float paramFloat)
  {
    if (paramKeyframe.getType() == Float.TYPE) {
      return Keyframe.ofFloat(paramFloat);
    }
    if (paramKeyframe.getType() == Integer.TYPE) {
      return Keyframe.ofInt(paramFloat);
    }
    return Keyframe.ofObject(paramFloat);
  }
  
  private static void distributeKeyframes(Keyframe[] paramArrayOfKeyframe, float paramFloat, int paramInt1, int paramInt2)
  {
    paramFloat /= (paramInt2 - paramInt1 + 2);
    while (paramInt1 <= paramInt2)
    {
      paramArrayOfKeyframe[paramInt1].setFraction(paramArrayOfKeyframe[(paramInt1 - 1)].getFraction() + paramFloat);
      paramInt1 += 1;
    }
  }
  
  private static void dumpKeyframes(Object[] paramArrayOfObject, String paramString)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0)) {
      return;
    }
    Log.d("AnimatorInflater", paramString);
    int j = paramArrayOfObject.length;
    int i = 0;
    label22:
    Keyframe localKeyframe;
    StringBuilder localStringBuilder;
    if (i < j)
    {
      localKeyframe = (Keyframe)paramArrayOfObject[i];
      localStringBuilder = new StringBuilder().append("Keyframe ").append(i).append(": fraction ");
      if (localKeyframe.getFraction() >= 0.0F) {
        break label125;
      }
      paramString = "null";
      label71:
      localStringBuilder = localStringBuilder.append(paramString).append(", ").append(", value : ");
      if (!localKeyframe.hasValue()) {
        break label137;
      }
    }
    label137:
    for (paramString = localKeyframe.getValue();; paramString = "null")
    {
      Log.d("AnimatorInflater", paramString);
      i += 1;
      break label22;
      break;
      label125:
      paramString = Float.valueOf(localKeyframe.getFraction());
      break label71;
    }
  }
  
  private static PropertyValuesHolder getPVH(TypedArray paramTypedArray, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Object localObject = paramTypedArray.peekValue(paramInt2);
    int j;
    int m;
    label27:
    int k;
    label42:
    int n;
    label54:
    int i;
    if (localObject != null)
    {
      j = 1;
      if (j == 0) {
        break label215;
      }
      m = ((TypedValue)localObject).type;
      localObject = paramTypedArray.peekValue(paramInt3);
      if (localObject == null) {
        break label221;
      }
      k = 1;
      if (k == 0) {
        break label227;
      }
      n = ((TypedValue)localObject).type;
      i = paramInt1;
      if (paramInt1 == 4)
      {
        if (((j == 0) || (!isColorType(m))) && ((k == 0) || (!isColorType(n)))) {
          break label233;
        }
        i = 3;
      }
      label91:
      if (i != 0) {
        break label239;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      if (i == 2)
      {
        localObject = paramTypedArray.getString(paramInt2);
        paramTypedArray = paramTypedArray.getString(paramInt3);
        PathParser.PathDataNode[] arrayOfPathDataNode1 = PathParser.createNodesFromPathData((String)localObject);
        PathParser.PathDataNode[] arrayOfPathDataNode2 = PathParser.createNodesFromPathData(paramTypedArray);
        if ((arrayOfPathDataNode1 == null) && (arrayOfPathDataNode2 == null)) {
          break label692;
        }
        if (arrayOfPathDataNode1 != null)
        {
          AnimatorInflaterCompat.PathDataEvaluator localPathDataEvaluator = new AnimatorInflaterCompat.PathDataEvaluator(null);
          if (arrayOfPathDataNode2 != null)
          {
            if (!PathParser.canMorph(arrayOfPathDataNode1, arrayOfPathDataNode2))
            {
              throw new InflateException(" Can't morph from " + (String)localObject + " to " + paramTypedArray);
              j = 0;
              break;
              label215:
              m = 0;
              break label27;
              label221:
              k = 0;
              break label42;
              label227:
              n = 0;
              break label54;
              label233:
              i = 0;
              break label91;
              label239:
              paramInt1 = 0;
              continue;
            }
            paramString = PropertyValuesHolder.ofObject(paramString, localPathDataEvaluator, new Object[] { arrayOfPathDataNode1, arrayOfPathDataNode2 });
            return paramString;
          }
          return PropertyValuesHolder.ofObject(paramString, localPathDataEvaluator, new Object[] { arrayOfPathDataNode1 });
        }
        if (arrayOfPathDataNode2 == null) {
          break label692;
        }
        return PropertyValuesHolder.ofObject(paramString, new AnimatorInflaterCompat.PathDataEvaluator(null), new Object[] { arrayOfPathDataNode2 });
      }
    }
    localObject = null;
    if (i == 3) {
      localObject = ArgbEvaluator.getInstance();
    }
    float f1;
    label352:
    float f2;
    if (paramInt1 != 0) {
      if (j != 0) {
        if (m == 5)
        {
          f1 = paramTypedArray.getDimension(paramInt2, 0.0F);
          if (k == 0) {
            break label435;
          }
          if (n != 5) {
            break label424;
          }
          f2 = paramTypedArray.getDimension(paramInt3, 0.0F);
          label371:
          paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1, f2 });
        }
      }
    }
    for (;;)
    {
      paramString = paramTypedArray;
      if (paramTypedArray == null) {
        break;
      }
      paramString = paramTypedArray;
      if (localObject == null) {
        break;
      }
      paramTypedArray.setEvaluator((TypeEvaluator)localObject);
      return paramTypedArray;
      f1 = paramTypedArray.getFloat(paramInt2, 0.0F);
      break label352;
      label424:
      f2 = paramTypedArray.getFloat(paramInt3, 0.0F);
      break label371;
      label435:
      paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1 });
      continue;
      if (n == 5) {}
      for (f1 = paramTypedArray.getDimension(paramInt3, 0.0F);; f1 = paramTypedArray.getFloat(paramInt3, 0.0F))
      {
        paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1 });
        break;
      }
      if (j != 0)
      {
        if (m == 5)
        {
          paramInt1 = (int)paramTypedArray.getDimension(paramInt2, 0.0F);
          label513:
          if (k == 0) {
            break label608;
          }
          if (n != 5) {
            break label580;
          }
          paramInt2 = (int)paramTypedArray.getDimension(paramInt3, 0.0F);
        }
        for (;;)
        {
          paramTypedArray = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1, paramInt2 });
          break;
          if (isColorType(m))
          {
            paramInt1 = paramTypedArray.getColor(paramInt2, 0);
            break label513;
          }
          paramInt1 = paramTypedArray.getInt(paramInt2, 0);
          break label513;
          label580:
          if (isColorType(n)) {
            paramInt2 = paramTypedArray.getColor(paramInt3, 0);
          } else {
            paramInt2 = paramTypedArray.getInt(paramInt3, 0);
          }
        }
        label608:
        paramTypedArray = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1 });
      }
      else
      {
        if (k != 0)
        {
          if (n == 5) {
            paramInt1 = (int)paramTypedArray.getDimension(paramInt3, 0.0F);
          }
          for (;;)
          {
            paramTypedArray = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1 });
            break;
            if (isColorType(n)) {
              paramInt1 = paramTypedArray.getColor(paramInt3, 0);
            } else {
              paramInt1 = paramTypedArray.getInt(paramInt3, 0);
            }
          }
        }
        paramTypedArray = null;
      }
    }
    label692:
    return null;
  }
  
  private static int inferValueTypeFromValues(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    int k = 0;
    TypedValue localTypedValue = paramTypedArray.peekValue(paramInt1);
    int i;
    if (localTypedValue != null)
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label87;
      }
      i = localTypedValue.type;
      label27:
      paramTypedArray = paramTypedArray.peekValue(paramInt2);
      if (paramTypedArray == null) {
        break label92;
      }
      paramInt2 = 1;
      label39:
      if (paramInt2 == 0) {
        break label97;
      }
    }
    label87:
    label92:
    label97:
    for (int j = paramTypedArray.type;; j = 0)
    {
      if ((paramInt1 == 0) || (!isColorType(i)))
      {
        paramInt1 = k;
        if (paramInt2 != 0)
        {
          paramInt1 = k;
          if (!isColorType(j)) {}
        }
      }
      else
      {
        paramInt1 = 3;
      }
      return paramInt1;
      paramInt1 = 0;
      break;
      i = 0;
      break label27;
      paramInt2 = 0;
      break label39;
    }
  }
  
  private static int inferValueTypeOfKeyframe(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser)
  {
    int k = 0;
    paramResources = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_KEYFRAME);
    paramTheme = TypedArrayUtils.peekNamedValue(paramResources, paramXmlPullParser, "value", 0);
    if (paramTheme != null) {}
    for (int i = 1;; i = 0)
    {
      int j = k;
      if (i != 0)
      {
        j = k;
        if (isColorType(paramTheme.type)) {
          j = 3;
        }
      }
      paramResources.recycle();
      return j;
    }
  }
  
  private static boolean isColorType(int paramInt)
  {
    return (paramInt >= 28) && (paramInt <= 31);
  }
  
  public static Animator loadAnimator(Context paramContext, @AnimatorRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return AnimatorInflater.loadAnimator(paramContext, paramInt);
    }
    return loadAnimator(paramContext, paramContext.getResources(), paramContext.getTheme(), paramInt);
  }
  
  public static Animator loadAnimator(Context paramContext, Resources paramResources, Resources.Theme paramTheme, @AnimatorRes int paramInt)
  {
    return loadAnimator(paramContext, paramResources, paramTheme, paramInt, 1.0F);
  }
  
  /* Error */
  public static Animator loadAnimator(Context paramContext, Resources paramResources, Resources.Theme paramTheme, @AnimatorRes int paramInt, float paramFloat)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 6
    //   9: aload_1
    //   10: iload_3
    //   11: invokevirtual 360	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   14: astore 8
    //   16: aload 8
    //   18: astore 6
    //   20: aload 8
    //   22: astore 5
    //   24: aload 8
    //   26: astore 7
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: aload 8
    //   33: fload 4
    //   35: invokestatic 362	android/support/graphics/drawable/AnimatorInflaterCompat:createAnimatorFromXml	(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;F)Landroid/animation/Animator;
    //   38: astore_0
    //   39: aload 8
    //   41: ifnull +10 -> 51
    //   44: aload 8
    //   46: invokeinterface 367 1 0
    //   51: aload_0
    //   52: areturn
    //   53: astore_0
    //   54: aload 6
    //   56: astore 5
    //   58: new 369	android/content/res/Resources$NotFoundException
    //   61: dup
    //   62: new 125	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 371
    //   72: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: iload_3
    //   76: invokestatic 374	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   79: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokespecial 375	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   88: astore_1
    //   89: aload 6
    //   91: astore 5
    //   93: aload_1
    //   94: aload_0
    //   95: invokevirtual 379	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   98: pop
    //   99: aload 6
    //   101: astore 5
    //   103: aload_1
    //   104: athrow
    //   105: astore_0
    //   106: aload 5
    //   108: ifnull +10 -> 118
    //   111: aload 5
    //   113: invokeinterface 367 1 0
    //   118: aload_0
    //   119: athrow
    //   120: astore_0
    //   121: aload 7
    //   123: astore 5
    //   125: new 369	android/content/res/Resources$NotFoundException
    //   128: dup
    //   129: new 125	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   136: ldc_w 371
    //   139: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: iload_3
    //   143: invokestatic 374	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   146: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokespecial 375	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   155: astore_1
    //   156: aload 7
    //   158: astore 5
    //   160: aload_1
    //   161: aload_0
    //   162: invokevirtual 379	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   165: pop
    //   166: aload 7
    //   168: astore 5
    //   170: aload_1
    //   171: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramContext	Context
    //   0	172	1	paramResources	Resources
    //   0	172	2	paramTheme	Resources.Theme
    //   0	172	3	paramInt	int
    //   0	172	4	paramFloat	float
    //   1	168	5	localObject1	Object
    //   7	93	6	localObject2	Object
    //   4	163	7	localObject3	Object
    //   14	31	8	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   9	16	53	org/xmlpull/v1/XmlPullParserException
    //   28	39	53	org/xmlpull/v1/XmlPullParserException
    //   9	16	105	finally
    //   28	39	105	finally
    //   58	89	105	finally
    //   93	99	105	finally
    //   103	105	105	finally
    //   125	156	105	finally
    //   160	166	105	finally
    //   170	172	105	finally
    //   9	16	120	java/io/IOException
    //   28	39	120	java/io/IOException
  }
  
  private static ValueAnimator loadAnimator(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, ValueAnimator paramValueAnimator, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_ANIMATOR);
    paramTheme = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
    paramResources = paramValueAnimator;
    if (paramValueAnimator == null) {
      paramResources = new ValueAnimator();
    }
    parseAnimatorFromTypeArray(paramResources, localTypedArray, paramTheme, paramFloat, paramXmlPullParser);
    int i = TypedArrayUtils.getNamedResourceId(localTypedArray, paramXmlPullParser, "interpolator", 0, 0);
    if (i > 0) {
      paramResources.setInterpolator(AnimationUtilsCompat.loadInterpolator(paramContext, i));
    }
    localTypedArray.recycle();
    if (paramTheme != null) {
      paramTheme.recycle();
    }
    return paramResources;
  }
  
  private static Keyframe loadKeyframe(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int paramInt, XmlPullParser paramXmlPullParser)
  {
    paramAttributeSet = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_KEYFRAME);
    paramTheme = null;
    float f = TypedArrayUtils.getNamedFloat(paramAttributeSet, paramXmlPullParser, "fraction", 3, -1.0F);
    paramResources = TypedArrayUtils.peekNamedValue(paramAttributeSet, paramXmlPullParser, "value", 0);
    int j;
    int i;
    if (paramResources != null)
    {
      j = 1;
      i = paramInt;
      if (paramInt == 4)
      {
        if ((j == 0) || (!isColorType(paramResources.type))) {
          break label154;
        }
        i = 3;
      }
      label73:
      if (j == 0) {
        break label200;
      }
      paramResources = paramTheme;
      switch (i)
      {
      default: 
        paramResources = paramTheme;
      }
    }
    for (;;)
    {
      paramInt = TypedArrayUtils.getNamedResourceId(paramAttributeSet, paramXmlPullParser, "interpolator", 1, 0);
      if (paramInt > 0) {
        paramResources.setInterpolator(AnimationUtilsCompat.loadInterpolator(paramContext, paramInt));
      }
      paramAttributeSet.recycle();
      return paramResources;
      j = 0;
      break;
      label154:
      i = 0;
      break label73;
      paramResources = Keyframe.ofFloat(f, TypedArrayUtils.getNamedFloat(paramAttributeSet, paramXmlPullParser, "value", 0, 0.0F));
      continue;
      paramResources = Keyframe.ofInt(f, TypedArrayUtils.getNamedInt(paramAttributeSet, paramXmlPullParser, "value", 0, 0));
      continue;
      label200:
      if (i == 0) {
        paramResources = Keyframe.ofFloat(f);
      } else {
        paramResources = Keyframe.ofInt(f);
      }
    }
  }
  
  private static ObjectAnimator loadObjectAnimator(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    loadAnimator(paramContext, paramResources, paramTheme, paramAttributeSet, localObjectAnimator, paramFloat, paramXmlPullParser);
    return localObjectAnimator;
  }
  
  private static PropertyValuesHolder loadPvh(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
  {
    ArrayList localArrayList = null;
    int i = paramInt;
    paramInt = paramXmlPullParser.next();
    if ((paramInt != 3) && (paramInt != 1))
    {
      if (!paramXmlPullParser.getName().equals("keyframe")) {
        break label442;
      }
      paramInt = i;
      if (i == 4) {
        paramInt = inferValueTypeOfKeyframe(paramResources, paramTheme, Xml.asAttributeSet(paramXmlPullParser), paramXmlPullParser);
      }
      Keyframe localKeyframe = loadKeyframe(paramContext, paramResources, paramTheme, Xml.asAttributeSet(paramXmlPullParser), paramInt, paramXmlPullParser);
      if (localKeyframe == null) {
        break label439;
      }
      if (localArrayList != null) {
        break label436;
      }
      localArrayList = new ArrayList();
      label98:
      localArrayList.add(localKeyframe);
      label106:
      paramXmlPullParser.next();
    }
    for (;;)
    {
      i = paramInt;
      break;
      if (localArrayList != null)
      {
        paramInt = localArrayList.size();
        if (paramInt > 0)
        {
          paramContext = (Keyframe)localArrayList.get(0);
          paramResources = (Keyframe)localArrayList.get(paramInt - 1);
          float f = paramResources.getFraction();
          if (f < 1.0F) {
            if (f < 0.0F) {
              paramResources.setFraction(1.0F);
            }
          }
          for (;;)
          {
            f = paramContext.getFraction();
            int k = paramInt;
            if (f != 0.0F)
            {
              if (f < 0.0F)
              {
                paramContext.setFraction(0.0F);
                k = paramInt;
              }
            }
            else
            {
              label218:
              paramContext = new Keyframe[k];
              localArrayList.toArray(paramContext);
              paramInt = 0;
              label234:
              if (paramInt >= k) {
                break label409;
              }
              paramResources = paramContext[paramInt];
              if (paramResources.getFraction() < 0.0F)
              {
                if (paramInt != 0) {
                  break label318;
                }
                paramResources.setFraction(0.0F);
              }
            }
            for (;;)
            {
              paramInt += 1;
              break label234;
              localArrayList.add(localArrayList.size(), createNewKeyframe(paramResources, 1.0F));
              paramInt += 1;
              break;
              localArrayList.add(0, createNewKeyframe(paramContext, 0.0F));
              k = paramInt + 1;
              break label218;
              label318:
              if (paramInt != k - 1) {
                break label335;
              }
              paramResources.setFraction(1.0F);
            }
            label335:
            int j = paramInt + 1;
            int m = paramInt;
            for (;;)
            {
              if ((j >= k - 1) || (paramContext[j].getFraction() >= 0.0F))
              {
                distributeKeyframes(paramContext, paramContext[(m + 1)].getFraction() - paramContext[(paramInt - 1)].getFraction(), paramInt, m);
                break;
              }
              m = j;
              j += 1;
            }
            label409:
            paramContext = PropertyValuesHolder.ofKeyframe(paramString, paramContext);
            if (i == 3) {
              paramContext.setEvaluator(ArgbEvaluator.getInstance());
            }
            return paramContext;
          }
        }
      }
      return null;
      label436:
      break label98;
      label439:
      break label106;
      label442:
      paramInt = i;
    }
  }
  
  private static PropertyValuesHolder[] loadValues(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    ArrayList localArrayList = null;
    int i;
    for (;;)
    {
      i = paramXmlPullParser.getEventType();
      if ((i == 3) || (i == 1)) {
        break label163;
      }
      if (i == 2) {
        break;
      }
      paramXmlPullParser.next();
    }
    if (paramXmlPullParser.getName().equals("propertyValuesHolder"))
    {
      TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER);
      String str = TypedArrayUtils.getNamedString(localTypedArray, paramXmlPullParser, "propertyName", 3);
      i = TypedArrayUtils.getNamedInt(localTypedArray, paramXmlPullParser, "valueType", 2, 4);
      PropertyValuesHolder localPropertyValuesHolder = loadPvh(paramContext, paramResources, paramTheme, paramXmlPullParser, str, i);
      label140:
      label148:
      if (localPropertyValuesHolder == null)
      {
        localPropertyValuesHolder = getPVH(localTypedArray, i, 0, 1, str);
        label121:
        if (localPropertyValuesHolder != null) {
          if (localArrayList == null)
          {
            localArrayList = new ArrayList();
            localArrayList.add(localPropertyValuesHolder);
            localTypedArray.recycle();
          }
        }
      }
    }
    for (;;)
    {
      paramXmlPullParser.next();
      break;
      label163:
      paramContext = null;
      if (localArrayList != null)
      {
        int j = localArrayList.size();
        paramContext = new PropertyValuesHolder[j];
        i = 0;
        while (i < j)
        {
          paramContext[i] = ((PropertyValuesHolder)localArrayList.get(i));
          i += 1;
        }
      }
      return paramContext;
      break label140;
      break label148;
      break label121;
    }
  }
  
  private static void parseAnimatorFromTypeArray(ValueAnimator paramValueAnimator, TypedArray paramTypedArray1, TypedArray paramTypedArray2, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    long l1 = TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "duration", 1, 300);
    long l2 = TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "startOffset", 2, 0);
    int j = TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "valueType", 7, 4);
    int k = j;
    if (TypedArrayUtils.hasAttribute(paramXmlPullParser, "valueFrom"))
    {
      k = j;
      if (TypedArrayUtils.hasAttribute(paramXmlPullParser, "valueTo"))
      {
        int i = j;
        if (j == 4) {
          i = inferValueTypeFromValues(paramTypedArray1, 5, 6);
        }
        PropertyValuesHolder localPropertyValuesHolder = getPVH(paramTypedArray1, i, 5, 6, "");
        k = i;
        if (localPropertyValuesHolder != null)
        {
          paramValueAnimator.setValues(new PropertyValuesHolder[] { localPropertyValuesHolder });
          k = i;
        }
      }
    }
    paramValueAnimator.setDuration(l1);
    paramValueAnimator.setStartDelay(l2);
    paramValueAnimator.setRepeatCount(TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "repeatCount", 3, 0));
    paramValueAnimator.setRepeatMode(TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "repeatMode", 4, 1));
    if (paramTypedArray2 != null) {
      setupObjectAnimator(paramValueAnimator, paramTypedArray2, k, paramFloat, paramXmlPullParser);
    }
  }
  
  private static void setupObjectAnimator(ValueAnimator paramValueAnimator, TypedArray paramTypedArray, int paramInt, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    paramValueAnimator = (ObjectAnimator)paramValueAnimator;
    String str1 = TypedArrayUtils.getNamedString(paramTypedArray, paramXmlPullParser, "pathData", 1);
    if (str1 != null)
    {
      String str2 = TypedArrayUtils.getNamedString(paramTypedArray, paramXmlPullParser, "propertyXName", 2);
      paramXmlPullParser = TypedArrayUtils.getNamedString(paramTypedArray, paramXmlPullParser, "propertyYName", 3);
      if (((paramInt == 2) || (paramInt != 4)) || ((str2 == null) && (paramXmlPullParser == null))) {
        throw new InflateException(paramTypedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
      }
      setupPathMotion(PathParser.createPathFromPathData(str1), paramValueAnimator, 0.5F * paramFloat, str2, paramXmlPullParser);
      return;
    }
    paramValueAnimator.setPropertyName(TypedArrayUtils.getNamedString(paramTypedArray, paramXmlPullParser, "propertyName", 0));
  }
  
  private static void setupPathMotion(Path paramPath, ObjectAnimator paramObjectAnimator, float paramFloat, String paramString1, String paramString2)
  {
    Object localObject = new PathMeasure(paramPath, false);
    float f1 = 0.0F;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Float.valueOf(0.0F));
    float f2;
    do
    {
      f2 = f1 + ((PathMeasure)localObject).getLength();
      localArrayList.add(Float.valueOf(f2));
      f1 = f2;
    } while (((PathMeasure)localObject).nextContour());
    paramPath = new PathMeasure(paramPath, false);
    int k = Math.min(100, (int)(f2 / paramFloat) + 1);
    float[] arrayOfFloat1 = new float[k];
    localObject = new float[k];
    float[] arrayOfFloat2 = new float[2];
    int i = 0;
    f1 = f2 / (k - 1);
    int j = 0;
    paramFloat = 0.0F;
    if (j < k)
    {
      paramPath.getPosTan(paramFloat, arrayOfFloat2, null);
      arrayOfFloat1[j] = arrayOfFloat2[0];
      localObject[j] = arrayOfFloat2[1];
      paramFloat += f1;
      if ((i + 1 >= localArrayList.size()) || (paramFloat <= ((Float)localArrayList.get(i + 1)).floatValue())) {
        break label317;
      }
      paramFloat -= ((Float)localArrayList.get(i + 1)).floatValue();
      i += 1;
      paramPath.nextContour();
    }
    label317:
    for (;;)
    {
      j += 1;
      break;
      paramPath = null;
      localArrayList = null;
      if (paramString1 != null) {
        paramPath = PropertyValuesHolder.ofFloat(paramString1, arrayOfFloat1);
      }
      paramString1 = localArrayList;
      if (paramString2 != null) {
        paramString1 = PropertyValuesHolder.ofFloat(paramString2, (float[])localObject);
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
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.graphics.drawable.AnimatorInflaterCompat
 * JD-Core Version:    0.7.0.1
 */