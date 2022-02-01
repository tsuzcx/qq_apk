package com.tencent.mobileqq.startup.step;

import aljs;
import aljt;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources.NotFoundException;
import anmk;
import anmo;
import aqcv;
import aqmj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;

public class SetSplash
  extends Step
{
  public boolean cIL = true;
  
  /* Error */
  public static void a(AppActivity paramAppActivity, anmo paramanmo)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 27	mqq/app/AppActivity:getWindow	()Landroid/view/Window;
    //   4: invokevirtual 33	android/view/Window:getDecorView	()Landroid/view/View;
    //   7: sipush 1284
    //   10: invokevirtual 39	android/view/View:setSystemUiVisibility	(I)V
    //   13: getstatic 45	android/os/Build$VERSION:SDK_INT	I
    //   16: bipush 28
    //   18: if_icmplt +14 -> 32
    //   21: aload_0
    //   22: invokevirtual 27	mqq/app/AppActivity:getWindow	()Landroid/view/Window;
    //   25: invokevirtual 49	android/view/Window:getAttributes	()Landroid/view/WindowManager$LayoutParams;
    //   28: iconst_1
    //   29: putfield 54	android/view/WindowManager$LayoutParams:layoutInDisplayCutoutMode	I
    //   32: aload_0
    //   33: instanceof 56
    //   36: ifeq +71 -> 107
    //   39: aload_0
    //   40: checkcast 56	com/tencent/mobileqq/app/IphoneTitleBarActivity
    //   43: ldc 57
    //   45: invokevirtual 60	com/tencent/mobileqq/app/IphoneTitleBarActivity:setContentViewNoTitle	(I)V
    //   48: aconst_null
    //   49: astore_2
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_0
    //   53: invokevirtual 64	mqq/app/AppActivity:getAssets	()Landroid/content/res/AssetManager;
    //   56: ldc 66
    //   58: invokevirtual 72	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   61: astore_3
    //   62: aload_3
    //   63: astore_1
    //   64: aload_3
    //   65: astore_2
    //   66: new 74	android/graphics/drawable/BitmapDrawable
    //   69: dup
    //   70: aload_0
    //   71: invokevirtual 78	mqq/app/AppActivity:getResources	()Landroid/content/res/Resources;
    //   74: aload_3
    //   75: invokespecial 81	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Ljava/io/InputStream;)V
    //   78: astore 4
    //   80: aload_3
    //   81: astore_1
    //   82: aload_3
    //   83: astore_2
    //   84: aload_0
    //   85: ldc 82
    //   87: invokevirtual 86	mqq/app/AppActivity:findViewById	(I)Landroid/view/View;
    //   90: checkcast 88	android/widget/ImageView
    //   93: aload 4
    //   95: invokevirtual 92	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   98: aload_3
    //   99: ifnull +7 -> 106
    //   102: aload_3
    //   103: invokevirtual 97	java/io/InputStream:close	()V
    //   106: return
    //   107: aload_0
    //   108: ldc 57
    //   110: invokevirtual 100	mqq/app/AppActivity:setContentView	(I)V
    //   113: goto -65 -> 48
    //   116: astore_1
    //   117: ldc 102
    //   119: iconst_1
    //   120: ldc 104
    //   122: aload_1
    //   123: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   126: aload_0
    //   127: invokevirtual 113	mqq/app/AppActivity:superFinish	()V
    //   130: return
    //   131: astore_0
    //   132: ldc 102
    //   134: iconst_1
    //   135: ldc 115
    //   137: aload_0
    //   138: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   141: return
    //   142: astore_0
    //   143: aload_1
    //   144: astore_2
    //   145: aload_0
    //   146: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   149: aload_1
    //   150: ifnull -44 -> 106
    //   153: aload_1
    //   154: invokevirtual 97	java/io/InputStream:close	()V
    //   157: return
    //   158: astore_0
    //   159: ldc 102
    //   161: iconst_1
    //   162: ldc 115
    //   164: aload_0
    //   165: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   168: return
    //   169: astore_0
    //   170: aload_2
    //   171: ifnull +7 -> 178
    //   174: aload_2
    //   175: invokevirtual 97	java/io/InputStream:close	()V
    //   178: aload_0
    //   179: athrow
    //   180: astore_1
    //   181: ldc 102
    //   183: iconst_1
    //   184: ldc 115
    //   186: aload_1
    //   187: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   190: goto -12 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramAppActivity	AppActivity
    //   0	193	1	paramanmo	anmo
    //   49	126	2	localObject	Object
    //   61	42	3	localInputStream	java.io.InputStream
    //   78	16	4	localBitmapDrawable	android.graphics.drawable.BitmapDrawable
    // Exception table:
    //   from	to	target	type
    //   32	48	116	android/content/res/Resources$NotFoundException
    //   107	113	116	android/content/res/Resources$NotFoundException
    //   102	106	131	java/lang/Throwable
    //   52	62	142	java/io/IOException
    //   66	80	142	java/io/IOException
    //   84	98	142	java/io/IOException
    //   153	157	158	java/lang/Throwable
    //   52	62	169	finally
    //   66	80	169	finally
    //   84	98	169	finally
    //   145	149	169	finally
    //   174	178	180	java/lang/Throwable
  }
  
  public static boolean ayy()
  {
    long l1 = BaseApplicationImpl.getApplication().getSharedPreferences("banner_and_splash", 0).getLong("splashshowtime", 0L);
    long l2 = System.currentTimeMillis();
    if ((l2 > l1) && (l2 <= 86400000L + l1)) {
      return false;
    }
    if (l2 > l1 + 86400000L)
    {
      Object localObject2 = BaseApplicationImpl.sApplication;
      Object localObject1 = ((Context)localObject2).getFilesDir();
      long l3;
      long l4;
      int j;
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((File)localObject1).getAbsolutePath();
        localObject3 = new File((String)localObject1 + "/splashpic");
        l3 = 0L;
        l4 = 0L;
        if ((localObject3 != null) && (((File)localObject3).exists()) && (((File)localObject3).isDirectory()))
        {
          localObject3 = ((File)localObject3).listFiles();
          if (localObject3 != null)
          {
            j = localObject3.length;
            i = 0;
          }
        }
      }
      else
      {
        for (;;)
        {
          long l5;
          long l6;
          for (;;)
          {
            if (i >= j) {
              break label336;
            }
            Object localObject4 = localObject3[i];
            l5 = l4;
            l6 = l3;
            if (localObject4 != null)
            {
              localObject4 = ((File)localObject4).getName().split("_");
              l5 = l4;
              l6 = l3;
              if (localObject4 != null)
              {
                l5 = l4;
                l6 = l3;
                if (localObject4.length == 3)
                {
                  localObject4 = localObject4[0];
                  l1 = l4;
                  l2 = l3;
                  if (localObject4 != null)
                  {
                    l1 = l4;
                    l2 = l3;
                    if (((String)localObject4).trim().equals("")) {}
                  }
                  try
                  {
                    int k = ((String)localObject4).indexOf("|");
                    l2 = Long.parseLong(((String)localObject4).substring(0, k));
                    l1 = Long.parseLong(((String)localObject4).substring(k + 1));
                    l5 = l1;
                    l6 = l2;
                    if (aqcv.D(l2, l1))
                    {
                      return true;
                      localObject1 = "/data/data/com.tencent.mobileqq/files";
                    }
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      l2 = 0L;
                      l1 = 0L;
                    }
                  }
                }
              }
            }
          }
          i += 1;
          l4 = l5;
          l3 = l6;
        }
      }
      label336:
      Object localObject3 = aqmj.bk(BaseApplicationImpl.getContext());
      if (QLog.isColorLevel()) {
        QLog.i("SetSplash", 2, "bir = " + (String)localObject3);
      }
      if ((!((String)localObject3).equals("")) && (ep((String)localObject3) == 0))
      {
        localObject1 = new File((String)localObject1 + "/" + aqmj.bj((Context)localObject2) + "/" + "birthdayflashlogo.png");
        if ((localObject1 != null) && (((File)localObject1).exists()) && (((File)localObject1).length() > 1L)) {
          return true;
        }
      }
      try
      {
        l1 = anmk.q(BaseApplicationImpl.getApplication());
        localObject2 = aljs.b(BaseApplicationImpl.getContext(), l1);
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject1 = aljs.a(BaseApplicationImpl.getApplication(), l1 + "");
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            if ((((HashMap)localObject1).containsKey(localObject3)) && (((aljt)((HashMap)localObject1).get(localObject3)).atH()))
            {
              if (QLog.isColorLevel()) {
                QLog.i("SetSplash", 2, "qbosssplash should show kill");
              }
              return true;
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("SetSplash", 2, "erro", localThrowable);
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SetSplash", 2, "now time less than last show time");
    }
    return false;
  }
  
  private static int ep(String paramString)
  {
    int i = Calendar.getInstance().get(1);
    paramString = i + "-" + paramString;
    Object localObject = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      paramString = ((SimpleDateFormat)localObject).parse(paramString);
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTime(paramString);
      ((Calendar)localObject).set(11, 0);
      ((Calendar)localObject).set(12, 0);
      ((Calendar)localObject).set(13, 0);
      ((Calendar)localObject).set(14, 0);
      paramString = ((Calendar)localObject).getTime();
      localObject = Calendar.getInstance();
      ((Calendar)localObject).set(11, 0);
      ((Calendar)localObject).set(12, 0);
      ((Calendar)localObject).set(13, 0);
      ((Calendar)localObject).set(14, 0);
      localObject = ((Calendar)localObject).getTime();
      long l = (paramString.getTime() - ((Date)localObject).getTime()) / 86400000L;
      return (int)l;
    }
    catch (Exception paramString) {}
    return -1;
  }
  
  protected boolean doStep()
  {
    AppActivity localAppActivity = this.mDirector.d;
    try
    {
      boolean bool = localAppActivity.showPreview();
      if (bool) {
        return true;
      }
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SetSplash", 2, "", localNotFoundException);
      }
      if (this.mDirector.ayt()) {}
      a(localAppActivity, this.mDirector);
      this.cIL = true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash
 * JD-Core Version:    0.7.0.1
 */