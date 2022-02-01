package com.tencent.mobileqq.profile.PersonalityLabel;

import acfp;
import alcd;
import alcf;
import alcf.a;
import alcj;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import aqgv;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView.b;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import lk;
import rwt;
import wja;

public class PersonalityLabelShareActivity
  extends IphoneTitleBarActivity
  implements alcf.a, View.OnClickListener, TagCloudView.b
{
  ImageView CC;
  View FP;
  View FQ;
  View FR;
  boolean UL = false;
  TextView Xf;
  alcf a;
  TagCloudView b;
  int bYd = 0;
  Bitmap bd;
  PersonalityLabel c;
  Button cw;
  View de;
  Bitmap fM;
  Bitmap fN;
  Drawable fk;
  Button gD;
  Drawable mDefaultDrawable;
  float mDensity;
  boolean mEnable = true;
  TextPaint mPaint = new TextPaint(7);
  
  private void bwA()
  {
    this.mEnable = false;
    ThreadManager.postImmediately(new PersonalityLabelShareActivity.2(this), null, true);
  }
  
  private void dEW()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        requestPermissions(new alcd(this), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      bwA();
      return;
    }
    bwA();
  }
  
  private void dEX()
  {
    ArrayList localArrayList = new ArrayList(this.c.getSize());
    Object localObject3 = null;
    if (this.mDefaultDrawable == null) {
      this.mDefaultDrawable = getResources().getDrawable(2131165579);
    }
    Object localObject1 = this.c.getLatestThumbLocalUrl();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = new File((String)localObject1);
    }
    for (;;)
    {
      try
      {
        localObject1 = URLDrawable.getDrawable(new URL("file:///" + ((File)localObject1).getAbsolutePath()), this.mDefaultDrawable, this.mDefaultDrawable);
        alcj.a(localArrayList, this.c, this.mDensity);
        this.b.setTags(localArrayList);
        this.b.setTagIcon((Drawable)localObject1);
        return;
      }
      catch (MalformedURLException localMalformedURLException2)
      {
        localObject1 = localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("PersonalityLabelDeleteActivity", 2, localMalformedURLException2.getMessage(), localMalformedURLException2);
        localObject1 = localObject3;
        continue;
      }
      catch (Exception localException1)
      {
        localObject1 = localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("PersonalityLabelDeleteActivity", 2, localException1.getMessage(), localException1);
        localObject1 = localObject3;
        continue;
      }
      String str = this.c.getLatestThumbUrl();
      if ((!TextUtils.isEmpty(str)) && ((str.startsWith("http")) || (str.startsWith("https"))))
      {
        localObject1 = URLDrawable.getDrawable(str, this.mDefaultDrawable, this.mDefaultDrawable);
      }
      else
      {
        localObject1 = localObject3;
        if (!TextUtils.isEmpty(str))
        {
          localObject1 = new File(str);
          Object localObject2;
          try
          {
            localObject1 = URLDrawable.getDrawable(new URL("file:///" + ((File)localObject1).getAbsolutePath()), this.mDefaultDrawable, this.mDefaultDrawable);
          }
          catch (MalformedURLException localMalformedURLException1)
          {
            localMalformedURLException1.printStackTrace();
            localObject2 = localObject3;
          }
          catch (Exception localException2)
          {
            localObject2 = localObject3;
          }
          if (QLog.isColorLevel())
          {
            QLog.i("PersonalityLabelDeleteActivity", 2, localException2.getMessage(), localException2);
            localObject2 = localObject3;
          }
        }
      }
    }
  }
  
  Bitmap aC()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelDeleteActivity", 2, "getQRBitmap start");
    }
    int m;
    Object localObject1;
    int i;
    int j;
    int k;
    try
    {
      localObject2 = rwt.a(String.format(alcf.SHARE_URL, new Object[] { this.app.getCurrentAccountUin() }), 29);
      m = ((lk)localObject2).getWidth();
      localObject1 = new int[m * m];
      i = 0;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        try
        {
          new Canvas((Bitmap)localObject1).drawBitmap((Bitmap)localObject2, null, new Rect(0, 0, this.bYd, this.bYd), null);
          ((Bitmap)localObject2).recycle();
          if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelDeleteActivity", 2, "getQRBitmap end");
          }
          return localObject1;
        }
        catch (Exception localException2)
        {
          localObject2 = localObject1;
          continue;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Object localObject2 = localObject1;
          continue;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        localObject2 = null;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i("PersonalityLabelDeleteActivity", 2, localOutOfMemoryError1.getMessage());
          localObject1 = localObject2;
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localObject2 = null;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i("PersonalityLabelDeleteActivity", 2, localException1.getMessage());
          localObject1 = localObject2;
        }
      }
    }
    if (j < m) {
      if (((lk)localObject2).get(j, i)) {
        k = -16777216;
      }
    }
    label307:
    for (;;)
    {
      localObject2 = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject2).setPixels((int[])localObject1, 0, m, 0, 0, m, m);
      localObject1 = Bitmap.createBitmap(this.bYd, this.bYd, Bitmap.Config.ARGB_8888);
      for (;;)
      {
        if (i >= m) {
          break label307;
        }
        j = 0;
        break;
        for (;;)
        {
          localObject1[(i * m + j)] = k;
          j += 1;
          break;
          k = -1;
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  Bitmap aD()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 300	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:de	Landroid/view/View;
    //   4: invokevirtual 303	android/view/View:getWidth	()I
    //   7: istore_2
    //   8: aload_0
    //   9: getfield 300	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:de	Landroid/view/View;
    //   12: invokevirtual 306	android/view/View:getHeight	()I
    //   15: istore_3
    //   16: iload_2
    //   17: iload_3
    //   18: getstatic 267	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   21: invokestatic 273	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   24: astore 4
    //   26: new 279	android/graphics/Canvas
    //   29: dup
    //   30: aload 4
    //   32: invokespecial 282	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   35: astore 5
    //   37: aload 5
    //   39: iconst_m1
    //   40: invokevirtual 309	android/graphics/Canvas:drawColor	(I)V
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 173	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:b	Lcom/tencent/mobileqq/profile/PersonalityLabel/tagCloud/TagCloudView;
    //   48: invokevirtual 312	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:b	(Landroid/view/View;)Landroid/graphics/Point;
    //   51: astore 6
    //   53: aload 5
    //   55: invokevirtual 315	android/graphics/Canvas:save	()I
    //   58: pop
    //   59: aload 5
    //   61: aload 6
    //   63: getfield 320	android/graphics/Point:x	I
    //   66: i2f
    //   67: aload 6
    //   69: getfield 323	android/graphics/Point:y	I
    //   72: i2f
    //   73: invokevirtual 327	android/graphics/Canvas:translate	(FF)V
    //   76: aload_0
    //   77: getfield 329	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:fN	Landroid/graphics/Bitmap;
    //   80: ifnull +18 -> 98
    //   83: aload 5
    //   85: aload_0
    //   86: getfield 329	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:fN	Landroid/graphics/Bitmap;
    //   89: fconst_0
    //   90: fconst_0
    //   91: aload_0
    //   92: getfield 59	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:mPaint	Landroid/text/TextPaint;
    //   95: invokevirtual 332	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   98: aload 5
    //   100: invokevirtual 335	android/graphics/Canvas:restore	()V
    //   103: aload_0
    //   104: aload_0
    //   105: getfield 337	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:FQ	Landroid/view/View;
    //   108: invokevirtual 312	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:b	(Landroid/view/View;)Landroid/graphics/Point;
    //   111: astore 7
    //   113: aload_0
    //   114: aload_0
    //   115: getfield 339	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:FP	Landroid/view/View;
    //   118: invokevirtual 312	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:b	(Landroid/view/View;)Landroid/graphics/Point;
    //   121: astore 6
    //   123: aload_0
    //   124: aload_0
    //   125: getfield 341	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:FR	Landroid/view/View;
    //   128: invokevirtual 312	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:b	(Landroid/view/View;)Landroid/graphics/Point;
    //   131: astore 8
    //   133: aload 5
    //   135: invokevirtual 315	android/graphics/Canvas:save	()I
    //   138: pop
    //   139: ldc_w 342
    //   142: aload_0
    //   143: invokevirtual 119	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:getResources	()Landroid/content/res/Resources;
    //   146: invokestatic 348	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   149: istore_2
    //   150: ldc_w 349
    //   153: aload_0
    //   154: invokevirtual 119	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:getResources	()Landroid/content/res/Resources;
    //   157: invokestatic 348	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   160: istore_3
    //   161: aload 5
    //   163: aload 8
    //   165: getfield 320	android/graphics/Point:x	I
    //   168: aload 7
    //   170: getfield 320	android/graphics/Point:x	I
    //   173: iadd
    //   174: aload 6
    //   176: getfield 320	android/graphics/Point:x	I
    //   179: iadd
    //   180: i2f
    //   181: aload 8
    //   183: getfield 323	android/graphics/Point:y	I
    //   186: aload 7
    //   188: getfield 323	android/graphics/Point:y	I
    //   191: iadd
    //   192: aload 6
    //   194: getfield 323	android/graphics/Point:y	I
    //   197: iadd
    //   198: i2f
    //   199: invokevirtual 327	android/graphics/Canvas:translate	(FF)V
    //   202: aload_0
    //   203: getfield 351	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:fk	Landroid/graphics/drawable/Drawable;
    //   206: iconst_0
    //   207: iconst_0
    //   208: iload_2
    //   209: iload_3
    //   210: invokevirtual 356	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   213: aload_0
    //   214: getfield 351	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:fk	Landroid/graphics/drawable/Drawable;
    //   217: aload 5
    //   219: invokevirtual 360	android/graphics/drawable/Drawable:draw	(Landroid/graphics/Canvas;)V
    //   222: aload 5
    //   224: invokevirtual 335	android/graphics/Canvas:restore	()V
    //   227: aload_0
    //   228: aload_0
    //   229: getfield 362	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:Xf	Landroid/widget/TextView;
    //   232: invokevirtual 312	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:b	(Landroid/view/View;)Landroid/graphics/Point;
    //   235: astore 8
    //   237: aload 5
    //   239: invokevirtual 315	android/graphics/Canvas:save	()I
    //   242: pop
    //   243: aload_0
    //   244: getfield 362	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:Xf	Landroid/widget/TextView;
    //   247: invokevirtual 368	android/widget/TextView:getLayout	()Landroid/text/Layout;
    //   250: astore 9
    //   252: aload 8
    //   254: getfield 320	android/graphics/Point:x	I
    //   257: aload 7
    //   259: getfield 320	android/graphics/Point:x	I
    //   262: iadd
    //   263: aload 6
    //   265: getfield 320	android/graphics/Point:x	I
    //   268: iadd
    //   269: i2f
    //   270: fstore_1
    //   271: aload 8
    //   273: getfield 323	android/graphics/Point:y	I
    //   276: istore_2
    //   277: aload 5
    //   279: fload_1
    //   280: aload 7
    //   282: getfield 323	android/graphics/Point:y	I
    //   285: iload_2
    //   286: iadd
    //   287: aload 6
    //   289: getfield 323	android/graphics/Point:y	I
    //   292: iadd
    //   293: i2f
    //   294: invokevirtual 327	android/graphics/Canvas:translate	(FF)V
    //   297: aload 9
    //   299: aload 5
    //   301: invokevirtual 371	android/text/Layout:draw	(Landroid/graphics/Canvas;)V
    //   304: aload 5
    //   306: invokevirtual 335	android/graphics/Canvas:restore	()V
    //   309: aload 5
    //   311: invokevirtual 315	android/graphics/Canvas:save	()I
    //   314: pop
    //   315: aload_0
    //   316: aload_0
    //   317: getfield 373	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:CC	Landroid/widget/ImageView;
    //   320: invokevirtual 312	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:b	(Landroid/view/View;)Landroid/graphics/Point;
    //   323: astore 7
    //   325: aload 6
    //   327: getfield 320	android/graphics/Point:x	I
    //   330: aload 7
    //   332: getfield 320	android/graphics/Point:x	I
    //   335: iadd
    //   336: i2f
    //   337: fstore_1
    //   338: aload 6
    //   340: getfield 323	android/graphics/Point:y	I
    //   343: istore_2
    //   344: aload 5
    //   346: fload_1
    //   347: aload 7
    //   349: getfield 323	android/graphics/Point:y	I
    //   352: iload_2
    //   353: iadd
    //   354: i2f
    //   355: invokevirtual 327	android/graphics/Canvas:translate	(FF)V
    //   358: aload 5
    //   360: aload_0
    //   361: getfield 375	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:fM	Landroid/graphics/Bitmap;
    //   364: aconst_null
    //   365: new 284	android/graphics/Rect
    //   368: dup
    //   369: iconst_0
    //   370: iconst_0
    //   371: aload_0
    //   372: getfield 50	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:bYd	I
    //   375: aload_0
    //   376: getfield 50	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelShareActivity:bYd	I
    //   379: invokespecial 287	android/graphics/Rect:<init>	(IIII)V
    //   382: aconst_null
    //   383: invokevirtual 291	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   386: aload 5
    //   388: invokevirtual 335	android/graphics/Canvas:restore	()V
    //   391: aload 4
    //   393: areturn
    //   394: astore 6
    //   396: aconst_null
    //   397: astore 5
    //   399: aload 5
    //   401: astore 4
    //   403: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq -15 -> 391
    //   409: ldc 191
    //   411: iconst_2
    //   412: aload 6
    //   414: invokevirtual 297	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   417: invokestatic 225	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   420: aload 5
    //   422: areturn
    //   423: astore 6
    //   425: aconst_null
    //   426: astore 5
    //   428: aload 5
    //   430: astore 4
    //   432: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   435: ifeq -44 -> 391
    //   438: ldc 191
    //   440: iconst_2
    //   441: aload 6
    //   443: invokevirtual 199	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   446: invokestatic 225	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   449: aload 5
    //   451: areturn
    //   452: astore 6
    //   454: aload 4
    //   456: astore 5
    //   458: goto -30 -> 428
    //   461: astore 6
    //   463: aload 4
    //   465: astore 5
    //   467: goto -68 -> 399
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	this	PersonalityLabelShareActivity
    //   270	77	1	f	float
    //   7	347	2	i	int
    //   15	195	3	j	int
    //   24	440	4	localObject1	Object
    //   35	431	5	localObject2	Object
    //   51	288	6	localPoint1	Point
    //   394	19	6	localOutOfMemoryError1	OutOfMemoryError
    //   423	19	6	localException1	Exception
    //   452	1	6	localException2	Exception
    //   461	1	6	localOutOfMemoryError2	OutOfMemoryError
    //   111	237	7	localPoint2	Point
    //   131	141	8	localPoint3	Point
    //   250	48	9	localLayout	android.text.Layout
    // Exception table:
    //   from	to	target	type
    //   16	26	394	java/lang/OutOfMemoryError
    //   16	26	423	java/lang/Exception
    //   26	98	452	java/lang/Exception
    //   98	391	452	java/lang/Exception
    //   26	98	461	java/lang/OutOfMemoryError
    //   98	391	461	java/lang/OutOfMemoryError
  }
  
  public void ac(Bitmap paramBitmap)
  {
    this.fN = paramBitmap;
    if (this.bd != null)
    {
      this.bd.recycle();
      this.bd = null;
    }
  }
  
  public Point b(View paramView)
  {
    Rect localRect = new Rect();
    paramView.getDrawingRect(localRect);
    ((ViewGroup)paramView.getParent()).offsetDescendantRectToMyCoords(paramView, localRect);
    int i = localRect.top;
    return new Point(localRect.left, i);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 != 1) {
        break label25;
      }
      rwt.ez(2, 2131717163);
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label25:
      if (paramInt1 == 21)
      {
        Intent localIntent = wja.a(new Intent(this, SplashActivity.class), null);
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        startActivity(localIntent);
        finish();
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561532);
    this.c = ((PersonalityLabel)getIntent().getParcelableExtra("data"));
    initViews();
    this.fk = getResources().getDrawable(2130846588);
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    initTitle();
  }
  
  public void iW(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mEnable = paramBoolean;
      return;
    }
  }
  
  void initTitle()
  {
    setLeftViewName(2131690700);
    this.rightViewText.setVisibility(8);
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusDrawable(null);
      this.mSystemBarComp.setStatusBarDrawable(null);
      this.mSystemBarComp.setStatusColor(-16777216);
      this.mSystemBarComp.setStatusBarColor(-16777216);
    }
  }
  
  void initViews()
  {
    this.mDensity = getResources().getDisplayMetrics().density;
    Object localObject = (BounceScrollView)findViewById(2131363709);
    ((BounceScrollView)localObject).setVerticalScrollBarEnabled(false);
    ((BounceScrollView)localObject).mScrollFlag = 1;
    this.b = ((TagCloudView)findViewById(2131379240));
    this.b.setOnUpdateDrawingListener(this);
    this.b.setMinHeight((int)(this.mDensity * 150.0F));
    this.b.setThreshold((int)(this.mDensity * 7.5F));
    this.de = findViewById(2131372834);
    this.FP = findViewById(2131369241);
    this.FQ = findViewById(2131379520);
    this.FR = findViewById(2131370900);
    this.de.setOnClickListener(this);
    this.CC = ((ImageView)findViewById(2131375288));
    this.Xf = ((TextView)findViewById(2131379401));
    this.bYd = getResources().getDimensionPixelSize(2131298780);
    localObject = aqgv.s(this.app, this.app.getCurrentAccountUin());
    String str1 = acfp.m(2131709459);
    String str2 = acfp.m(2131709479);
    int i = getResources().getDisplayMetrics().widthPixels - wja.dp2px(20.0F, getResources()) * 5 - wja.dp2px(1.0F, getResources()) - this.bYd - wja.dp2px(10.0F, getResources());
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(this.Xf.getTextSize());
    String str3 = str1 + (String)localObject + str2;
    String str4 = (String)TextUtils.ellipsize(str3, localTextPaint, i, TextUtils.TruncateAt.END);
    if (TextUtils.equals(str3, str4)) {
      this.Xf.setText(str4);
    }
    for (;;)
    {
      this.cw = ((Button)findViewById(2131363978));
      this.gD = ((Button)findViewById(2131364001));
      this.cw.setOnClickListener(this);
      this.gD.setOnClickListener(this);
      this.fM = aC();
      if (this.fM == null)
      {
        QQToast.a(this, 1, acfp.m(2131709458), 0).show();
        finish();
      }
      this.CC.setImageBitmap(this.fM);
      dEX();
      return;
      do
      {
        localObject = (String)((String)localObject).subSequence(0, ((String)localObject).length() - 1);
        str3 = str1 + (String)localObject + "..." + str2;
        str4 = (String)TextUtils.ellipsize(str3, localTextPaint, i, TextUtils.TruncateAt.END);
      } while (!TextUtils.equals(str3, str4));
      this.Xf.setText(str4);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364001) {
      if (!this.mEnable) {
        QQToast.a(this, 2131701501, 0).show();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.bd == null) {
        this.bd = aD();
      }
      if (this.bd == null)
      {
        QQToast.a(this, 1, 2131701502, 0).show();
      }
      else
      {
        if (this.a == null) {
          this.a = new alcf(this, this.app, this, this);
        }
        this.a.ad(this.bd);
        this.a.c(null);
        continue;
        if (paramView.getId() == 2131363978)
        {
          if (this.mEnable)
          {
            if (this.bd == null) {
              this.bd = aD();
            }
            if (this.bd == null) {
              QQToast.a(this, 1, 2131701502, 0).show();
            } else if (!this.UL) {
              dEW();
            } else {
              QQToast.a(this, 0, acfp.m(2131709463), 0).show();
            }
          }
        }
        else if (paramView.getId() == 2131372834)
        {
          this.UL = false;
          if (this.bd != null)
          {
            this.bd.recycle();
            this.bd = null;
          }
          dEX();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelShareActivity
 * JD-Core Version:    0.7.0.1
 */