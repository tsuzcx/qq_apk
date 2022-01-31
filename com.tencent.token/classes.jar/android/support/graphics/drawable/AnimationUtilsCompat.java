package android.support.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.support.annotation.RestrictTo;
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
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class AnimationUtilsCompat
{
  private static Interpolator createInterpolatorFromXml(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
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
  {
    // Byte code:
    //   0: getstatic 123	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 21
    //   5: if_icmplt +11 -> 16
    //   8: aload_0
    //   9: iload_1
    //   10: invokestatic 127	android/view/animation/AnimationUtils:loadInterpolator	(Landroid/content/Context;I)Landroid/view/animation/Interpolator;
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
    //   24: ldc 128
    //   26: if_icmpne +23 -> 49
    //   29: new 130	android/support/v4/view/animation/FastOutLinearInInterpolator
    //   32: dup
    //   33: invokespecial 131	android/support/v4/view/animation/FastOutLinearInInterpolator:<init>	()V
    //   36: astore_0
    //   37: iconst_0
    //   38: ifeq -24 -> 14
    //   41: new 133	java/lang/NullPointerException
    //   44: dup
    //   45: invokespecial 134	java/lang/NullPointerException:<init>	()V
    //   48: athrow
    //   49: iload_1
    //   50: ldc 135
    //   52: if_icmpne +23 -> 75
    //   55: new 137	android/support/v4/view/animation/FastOutSlowInInterpolator
    //   58: dup
    //   59: invokespecial 138	android/support/v4/view/animation/FastOutSlowInInterpolator:<init>	()V
    //   62: astore_0
    //   63: iconst_0
    //   64: ifeq -50 -> 14
    //   67: new 133	java/lang/NullPointerException
    //   70: dup
    //   71: invokespecial 134	java/lang/NullPointerException:<init>	()V
    //   74: athrow
    //   75: iload_1
    //   76: ldc 139
    //   78: if_icmpne +23 -> 101
    //   81: new 141	android/support/v4/view/animation/LinearOutSlowInInterpolator
    //   84: dup
    //   85: invokespecial 142	android/support/v4/view/animation/LinearOutSlowInInterpolator:<init>	()V
    //   88: astore_0
    //   89: iconst_0
    //   90: ifeq -76 -> 14
    //   93: new 133	java/lang/NullPointerException
    //   96: dup
    //   97: invokespecial 134	java/lang/NullPointerException:<init>	()V
    //   100: athrow
    //   101: aload_0
    //   102: invokevirtual 148	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   105: iload_1
    //   106: invokevirtual 154	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   109: astore 5
    //   111: aload 5
    //   113: astore_3
    //   114: aload 5
    //   116: astore_2
    //   117: aload 5
    //   119: astore 4
    //   121: aload_0
    //   122: aload_0
    //   123: invokevirtual 148	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   126: aload_0
    //   127: invokevirtual 158	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   130: aload 5
    //   132: invokestatic 160	android/support/graphics/drawable/AnimationUtilsCompat:createInterpolatorFromXml	(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;)Landroid/view/animation/Interpolator;
    //   135: astore_0
    //   136: aload_0
    //   137: astore_2
    //   138: aload_2
    //   139: astore_0
    //   140: aload 5
    //   142: ifnull -128 -> 14
    //   145: aload 5
    //   147: invokeinterface 165 1 0
    //   152: aload_2
    //   153: areturn
    //   154: astore_0
    //   155: aload_3
    //   156: astore_2
    //   157: new 167	android/content/res/Resources$NotFoundException
    //   160: dup
    //   161: new 98	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   168: ldc 169
    //   170: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: iload_1
    //   174: invokestatic 175	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   177: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokespecial 176	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   186: astore 4
    //   188: aload_3
    //   189: astore_2
    //   190: aload 4
    //   192: aload_0
    //   193: invokevirtual 180	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   196: pop
    //   197: aload_3
    //   198: astore_2
    //   199: aload 4
    //   201: athrow
    //   202: astore_0
    //   203: aload_2
    //   204: ifnull +9 -> 213
    //   207: aload_2
    //   208: invokeinterface 165 1 0
    //   213: aload_0
    //   214: athrow
    //   215: astore_0
    //   216: aload 4
    //   218: astore_2
    //   219: new 167	android/content/res/Resources$NotFoundException
    //   222: dup
    //   223: new 98	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   230: ldc 169
    //   232: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: iload_1
    //   236: invokestatic 175	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   239: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokespecial 176	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   248: astore_3
    //   249: aload 4
    //   251: astore_2
    //   252: aload_3
    //   253: aload_0
    //   254: invokevirtual 180	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   257: pop
    //   258: aload 4
    //   260: astore_2
    //   261: aload_3
    //   262: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramContext	Context
    //   0	263	1	paramInt	int
    //   17	244	2	localObject1	Object
    //   22	240	3	localObject2	Object
    //   19	240	4	localObject3	Object
    //   109	37	5	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   29	37	154	org/xmlpull/v1/XmlPullParserException
    //   55	63	154	org/xmlpull/v1/XmlPullParserException
    //   81	89	154	org/xmlpull/v1/XmlPullParserException
    //   101	111	154	org/xmlpull/v1/XmlPullParserException
    //   121	136	154	org/xmlpull/v1/XmlPullParserException
    //   29	37	202	finally
    //   55	63	202	finally
    //   81	89	202	finally
    //   101	111	202	finally
    //   121	136	202	finally
    //   157	188	202	finally
    //   190	197	202	finally
    //   199	202	202	finally
    //   219	249	202	finally
    //   252	258	202	finally
    //   261	263	202	finally
    //   29	37	215	java/io/IOException
    //   55	63	215	java/io/IOException
    //   81	89	215	java/io/IOException
    //   101	111	215	java/io/IOException
    //   121	136	215	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.graphics.drawable.AnimationUtilsCompat
 * JD-Core Version:    0.7.0.1
 */