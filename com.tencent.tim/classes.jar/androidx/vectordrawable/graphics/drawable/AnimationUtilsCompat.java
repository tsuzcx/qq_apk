package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.annotation.RestrictTo;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AnimationUtilsCompat
{
  private static Interpolator createInterpolatorFromXml(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    paramResources = null;
    int i = paramXmlPullParser.getDepth();
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        return paramResources;
      }
      if (j == 2)
      {
        paramResources = Xml.asAttributeSet(paramXmlPullParser);
        paramTheme = paramXmlPullParser.getName();
        if (paramTheme.equals("linearInterpolator"))
        {
          paramResources = new LinearInterpolator();
        }
        else if (paramTheme.equals("accelerateInterpolator"))
        {
          paramResources = new AccelerateInterpolator(paramContext, paramResources);
        }
        else if (paramTheme.equals("decelerateInterpolator"))
        {
          paramResources = new DecelerateInterpolator(paramContext, paramResources);
        }
        else if (paramTheme.equals("accelerateDecelerateInterpolator"))
        {
          paramResources = new AccelerateDecelerateInterpolator();
        }
        else if (paramTheme.equals("cycleInterpolator"))
        {
          paramResources = new CycleInterpolator(paramContext, paramResources);
        }
        else if (paramTheme.equals("anticipateInterpolator"))
        {
          paramResources = new AnticipateInterpolator(paramContext, paramResources);
        }
        else if (paramTheme.equals("overshootInterpolator"))
        {
          paramResources = new OvershootInterpolator(paramContext, paramResources);
        }
        else if (paramTheme.equals("anticipateOvershootInterpolator"))
        {
          paramResources = new AnticipateOvershootInterpolator(paramContext, paramResources);
        }
        else if (paramTheme.equals("bounceInterpolator"))
        {
          paramResources = new BounceInterpolator();
        }
        else
        {
          if (!paramTheme.equals("pathInterpolator")) {
            break;
          }
          paramResources = new PathInterpolatorCompat(paramContext, paramResources, paramXmlPullParser);
        }
      }
    }
    throw new RuntimeException("Unknown interpolator name: " + paramXmlPullParser.getName());
    return paramResources;
  }
  
  /* Error */
  public static Interpolator loadInterpolator(Context paramContext, int paramInt)
    throws android.content.res.Resources.NotFoundException
  {
    // Byte code:
    //   0: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 21
    //   5: if_icmplt +11 -> 16
    //   8: aload_0
    //   9: iload_1
    //   10: invokestatic 130	android/view/animation/AnimationUtils:loadInterpolator	(Landroid/content/Context;I)Landroid/view/animation/Interpolator;
    //   13: astore_0
    //   14: aload_0
    //   15: areturn
    //   16: aconst_null
    //   17: astore_2
    //   18: aconst_null
    //   19: astore 4
    //   21: aconst_null
    //   22: astore_3
    //   23: iload_1
    //   24: ldc 131
    //   26: if_icmpne +23 -> 49
    //   29: new 133	androidx/interpolator/view/animation/FastOutLinearInInterpolator
    //   32: dup
    //   33: invokespecial 134	androidx/interpolator/view/animation/FastOutLinearInInterpolator:<init>	()V
    //   36: astore_0
    //   37: iconst_0
    //   38: ifeq -24 -> 14
    //   41: new 136	java/lang/NullPointerException
    //   44: dup
    //   45: invokespecial 137	java/lang/NullPointerException:<init>	()V
    //   48: athrow
    //   49: iload_1
    //   50: ldc 138
    //   52: if_icmpne +23 -> 75
    //   55: new 140	androidx/interpolator/view/animation/FastOutSlowInInterpolator
    //   58: dup
    //   59: invokespecial 141	androidx/interpolator/view/animation/FastOutSlowInInterpolator:<init>	()V
    //   62: astore_0
    //   63: iconst_0
    //   64: ifeq -50 -> 14
    //   67: new 136	java/lang/NullPointerException
    //   70: dup
    //   71: invokespecial 137	java/lang/NullPointerException:<init>	()V
    //   74: athrow
    //   75: iload_1
    //   76: ldc 142
    //   78: if_icmpne +23 -> 101
    //   81: new 144	androidx/interpolator/view/animation/LinearOutSlowInInterpolator
    //   84: dup
    //   85: invokespecial 145	androidx/interpolator/view/animation/LinearOutSlowInInterpolator:<init>	()V
    //   88: astore_0
    //   89: iconst_0
    //   90: ifeq -76 -> 14
    //   93: new 136	java/lang/NullPointerException
    //   96: dup
    //   97: invokespecial 137	java/lang/NullPointerException:<init>	()V
    //   100: athrow
    //   101: aload_0
    //   102: invokevirtual 151	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   105: iload_1
    //   106: invokevirtual 157	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   109: astore 5
    //   111: aload 5
    //   113: astore_3
    //   114: aload 5
    //   116: astore_2
    //   117: aload 5
    //   119: astore 4
    //   121: aload_0
    //   122: aload_0
    //   123: invokevirtual 151	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   126: aload_0
    //   127: invokevirtual 161	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   130: aload 5
    //   132: invokestatic 163	androidx/vectordrawable/graphics/drawable/AnimationUtilsCompat:createInterpolatorFromXml	(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;)Landroid/view/animation/Interpolator;
    //   135: astore_0
    //   136: aload_0
    //   137: astore_2
    //   138: aload_2
    //   139: astore_0
    //   140: aload 5
    //   142: ifnull -128 -> 14
    //   145: aload 5
    //   147: invokeinterface 168 1 0
    //   152: aload_2
    //   153: areturn
    //   154: astore 4
    //   156: aload_3
    //   157: astore_2
    //   158: new 120	android/content/res/Resources$NotFoundException
    //   161: dup
    //   162: new 102	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   169: ldc 170
    //   171: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: iload_1
    //   175: invokestatic 176	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   178: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokespecial 177	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   187: astore_0
    //   188: aload_3
    //   189: astore_2
    //   190: aload_0
    //   191: aload 4
    //   193: invokevirtual 181	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   196: pop
    //   197: aload_3
    //   198: astore_2
    //   199: aload_0
    //   200: athrow
    //   201: astore_0
    //   202: aload_2
    //   203: ifnull +9 -> 212
    //   206: aload_2
    //   207: invokeinterface 168 1 0
    //   212: aload_0
    //   213: athrow
    //   214: astore_0
    //   215: aload 4
    //   217: astore_2
    //   218: new 120	android/content/res/Resources$NotFoundException
    //   221: dup
    //   222: new 102	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   229: ldc 170
    //   231: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: iload_1
    //   235: invokestatic 176	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   238: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokespecial 177	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   247: astore_3
    //   248: aload 4
    //   250: astore_2
    //   251: aload_3
    //   252: aload_0
    //   253: invokevirtual 181	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   256: pop
    //   257: aload 4
    //   259: astore_2
    //   260: aload_3
    //   261: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	paramContext	Context
    //   0	262	1	paramInt	int
    //   17	243	2	localObject1	Object
    //   22	239	3	localObject2	Object
    //   19	101	4	localObject3	Object
    //   154	104	4	localXmlPullParserException	XmlPullParserException
    //   109	37	5	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   29	37	154	org/xmlpull/v1/XmlPullParserException
    //   55	63	154	org/xmlpull/v1/XmlPullParserException
    //   81	89	154	org/xmlpull/v1/XmlPullParserException
    //   101	111	154	org/xmlpull/v1/XmlPullParserException
    //   121	136	154	org/xmlpull/v1/XmlPullParserException
    //   29	37	201	finally
    //   55	63	201	finally
    //   81	89	201	finally
    //   101	111	201	finally
    //   121	136	201	finally
    //   158	188	201	finally
    //   190	197	201	finally
    //   199	201	201	finally
    //   218	248	201	finally
    //   251	257	201	finally
    //   260	262	201	finally
    //   29	37	214	java/io/IOException
    //   55	63	214	java/io/IOException
    //   81	89	214	java/io/IOException
    //   101	111	214	java/io/IOException
    //   121	136	214	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat
 * JD-Core Version:    0.7.0.1
 */