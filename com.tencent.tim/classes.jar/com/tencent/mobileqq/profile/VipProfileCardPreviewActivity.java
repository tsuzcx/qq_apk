package com.tencent.mobileqq.profile;

import acci;
import accn;
import alcl;
import alcs;
import alct;
import alds;
import aldu;
import aldv;
import alft;
import alfx;
import alfy;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import anot;
import aqep;
import arhz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profile.view.VipScaledViewPager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.ProfileCardScrollImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;
import com.tencent.widget.CirclePageIndicator;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VipProfileCardPreviewActivity
  extends VipProfileCardBaseActivity
  implements View.OnClickListener
{
  public ImageView CD;
  public List<alct> EQ = Collections.synchronizedList(new ArrayList());
  private volatile long LJ = -1L;
  public List<String> V = Collections.synchronizedList(new ArrayList());
  public alcl a;
  public StylePagerAdapter a;
  public VipScaledViewPager a;
  public String aNh = "is_binding_shop";
  public int aPN;
  public long agw = -1L;
  public CirclePageIndicator b;
  public String bVU = "0";
  String bVV = null;
  public accn cardObserver = new aldv(this);
  public Button cl;
  int crd = 0;
  public boolean cwp;
  public boolean cwq;
  public boolean cwr;
  public boolean cws;
  volatile boolean cwt = false;
  public Drawable dB;
  public int dsA = -1;
  public int dsn = -1;
  public int dso;
  public int dsp;
  public int dsq;
  public int dsr;
  public int dss;
  public int dst;
  public int dsu;
  public int dsv;
  public int dsw = -1;
  public int dsx;
  public int dsy;
  public int dsz;
  HashMap<String, String> gF = new HashMap();
  Runnable hn;
  public int mBtnHeight;
  public float mDensityScale = 1.0F;
  public View mask;
  public ArrayList<Long> yE = new ArrayList();
  public float yr;
  public float ys = 1.666667F;
  public float yt = 1.775F;
  
  public void Oa(String paramString)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = aqep.I(this.mContext, paramString);
      localObject = new File(paramString);
      if ((((File)localObject).isFile()) && (((File)localObject).exists()))
      {
        localObject = "profilecard_preview:" + paramString;
        Pair localPair = (Pair)BaseApplicationImpl.sImageCache.get(localObject);
        if ((localPair == null) || (localPair.first == null)) {
          break label127;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "get image form sImageCache filePath=" + paramString);
        }
        this.dB = ((Drawable.ConstantState)localPair.first).newDrawable();
      }
    }
    return;
    label127:
    gX(paramString, (String)localObject);
  }
  
  void Ob(String paramString)
  {
    aldu localaldu = new aldu(this, Long.parseLong(this.app.getCurrentAccountUin()), paramString, alft.a(this.app), "qqprofile", paramString);
    localaldu.fe = alft.a(this.app);
    localaldu.fileId = alft.c(this.app, paramString);
    dFp();
    paramString = (alfy)this.app.getManager(90);
    paramString.a(this.app, null);
    localaldu.a();
    paramString.a(this.app, localaldu, null);
  }
  
  public void SI(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) || (this.EQ == null) || (paramInt < 0) || (paramInt >= this.EQ.size())) {}
    Object localObject;
    do
    {
      do
      {
        alct localalct;
        do
        {
          do
          {
            do
            {
              return;
              localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.findViewById(paramInt);
            } while ((localObject == null) || (((View)localObject).getTag() == null));
            localObject = (VipProfileCardPreviewActivity.StylePagerAdapter.a)((View)localObject).getTag();
          } while (localObject == null);
          localObject = ((VipProfileCardPreviewActivity.StylePagerAdapter.a)localObject).a;
          localalct = (alct)this.EQ.get(paramInt);
        } while (localalct == null);
        switch (localalct.c.animation)
        {
        default: 
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "cancel ANIMATION_NONE");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "cancel ANIMATION_SCROLL");
      }
      ((ProfileCardScrollImageView)localObject).eiA();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "cancel ANIMATION_FADE_IN_OUT");
      }
      if (this.hn != null) {
        this.mHandler.removeCallbacks(this.hn);
      }
      localObject = ((ProfileCardScrollImageView)localObject).getDrawable();
    } while ((localObject == null) || (!(localObject instanceof TransitionDrawable)));
    ((TransitionDrawable)localObject).resetTransition();
  }
  
  void SJ(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) || (this.EQ == null)) {}
    View localView;
    do
    {
      return;
      localView = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.findViewById(paramInt);
    } while ((localView == null) || (localView.getTag() == null));
    a((VipProfileCardPreviewActivity.StylePagerAdapter.a)localView.getTag(), (alct)this.EQ.get(paramInt), paramInt);
  }
  
  public void SK(int paramInt)
  {
    if ((this.EQ == null) || (paramInt < 0) || (paramInt >= this.EQ.size()) || (this.EQ.get(paramInt) == null)) {
      return;
    }
    alct localalct = (alct)this.EQ.get(paramInt);
    if (localalct.c.agr == alcs.agq)
    {
      this.cl.setText(2131697298);
      this.bVU = "3";
      return;
    }
    a(localalct.c, this.jdField_a_of_type_Alcl, false);
    if (this.dsg == 4)
    {
      this.cl.setText(2131697306);
      this.bVU = "2";
      return;
    }
    if (this.dsg == 2)
    {
      this.cl.setText(2131697307);
      this.bVU = "1";
      return;
    }
    this.cl.setText(2131697301);
    this.bVU = "0";
  }
  
  public void W(int paramInt, List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        dv(paramInt, (String)paramList.next());
      }
    }
  }
  
  public void ZM()
  {
    setLeftViewName(2131691039);
    setTitle(2131697297);
  }
  
  public List<String> a(alct paramalct)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramalct == null) || (paramalct.c == null)) {}
    for (;;)
    {
      return localArrayList;
      if (this.dsl == 1) {
        localArrayList.add(paramalct.c.bVz);
      }
      while (paramalct.c.animation == 2)
      {
        if (this.dsl != 1) {
          break label95;
        }
        localArrayList.add(paramalct.c.bVD);
        return localArrayList;
        localArrayList.add(paramalct.c.bVv);
      }
    }
    label95:
    localArrayList.add(paramalct.c.bVH);
    return localArrayList;
  }
  
  public void a(int paramInt, alct paramalct)
  {
    if (paramalct == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "startDownload pos = " + paramInt + ", status = " + paramalct.status);
      }
    } while ((paramalct.status == 2) || (paramalct.status == 1));
    paramalct.status = 1;
    paramalct = a(paramalct);
    this.V.addAll(paramalct);
    W(paramInt, paramalct);
  }
  
  /* Error */
  public void a(VipProfileCardPreviewActivity.StylePagerAdapter.a parama, alct paramalct, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokevirtual 466	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:a	(Lalct;)Z
    //   5: ifeq +69 -> 74
    //   8: aload_2
    //   9: iconst_2
    //   10: putfield 453	alct:status	I
    //   13: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +35 -> 51
    //   19: ldc 208
    //   21: iconst_2
    //   22: new 172	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 468
    //   32: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload_3
    //   36: invokevirtual 448	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: ldc_w 470
    //   42: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: aload_2
    //   53: invokevirtual 455	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:a	(Lalct;)Ljava/util/List;
    //   56: astore 7
    //   58: aload 7
    //   60: ifnull +13 -> 73
    //   63: aload 7
    //   65: invokeinterface 295 1 0
    //   70: ifne +43 -> 113
    //   73: return
    //   74: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq -4 -> 73
    //   80: ldc 208
    //   82: iconst_2
    //   83: new 172	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 468
    //   93: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: iload_3
    //   97: invokevirtual 448	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   100: ldc_w 472
    //   103: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: return
    //   113: aload_2
    //   114: getfield 318	alct:c	Lalcs;
    //   117: getfield 362	alcs:agr	J
    //   120: getstatic 365	alcs:agq	J
    //   123: lcmp
    //   124: ifne +239 -> 363
    //   127: aload_1
    //   128: getfield 475	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$a:d	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   131: iconst_0
    //   132: invokevirtual 480	com/tencent/mobileqq/hiboom/HiBoomTextView:setVisibility	(I)V
    //   135: sipush 2000
    //   138: istore 5
    //   140: getstatic 485	aldz:bVY	Ljava/lang/String;
    //   143: astore 8
    //   145: getstatic 489	aldz:di	Landroid/util/SparseArray;
    //   148: ifnull +205 -> 353
    //   151: getstatic 489	aldz:di	Landroid/util/SparseArray;
    //   154: invokevirtual 492	android/util/SparseArray:size	()I
    //   157: ifle +196 -> 353
    //   160: getstatic 489	aldz:di	Landroid/util/SparseArray;
    //   163: iconst_0
    //   164: invokevirtual 496	android/util/SparseArray:keyAt	(I)I
    //   167: istore 5
    //   169: aload_1
    //   170: getfield 475	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$a:d	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   173: iload 5
    //   175: iconst_1
    //   176: getstatic 501	ahxs:c	Lahxo$a;
    //   179: invokevirtual 505	com/tencent/mobileqq/hiboom/HiBoomTextView:setHiBoom	(IILahxo$a;)V
    //   182: aload_1
    //   183: getfield 475	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$a:d	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   186: aload 8
    //   188: invokevirtual 508	com/tencent/mobileqq/hiboom/HiBoomTextView:setText	(Ljava/lang/CharSequence;)V
    //   191: aload_0
    //   192: getfield 510	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:dsy	I
    //   195: i2f
    //   196: aload_0
    //   197: invokevirtual 514	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:getResources	()Landroid/content/res/Resources;
    //   200: invokevirtual 520	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   203: getfield 525	android/util/DisplayMetrics:widthPixels	I
    //   206: i2f
    //   207: fdiv
    //   208: fstore 4
    //   210: aload_1
    //   211: getfield 475	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$a:d	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   214: fload 4
    //   216: invokevirtual 529	com/tencent/mobileqq/hiboom/HiBoomTextView:setScaleX	(F)V
    //   219: aload_1
    //   220: getfield 475	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$a:d	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   223: fload 4
    //   225: invokevirtual 532	com/tencent/mobileqq/hiboom/HiBoomTextView:setScaleY	(F)V
    //   228: aload_2
    //   229: getfield 318	alct:c	Lalcs;
    //   232: getfield 323	alcs:animation	I
    //   235: tableswitch	default:+25 -> 260, 0:+26->261, 1:+140->375, 2:+549->784
    //   261: aload_1
    //   262: getfield 310	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$a:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   265: iconst_0
    //   266: invokevirtual 536	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setIsScroll	(Z)V
    //   269: new 172	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   276: ldc_w 538
    //   279: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_0
    //   283: getfield 154	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:mContext	Landroid/content/Context;
    //   286: aload 7
    //   288: iconst_0
    //   289: invokeinterface 313 2 0
    //   294: checkcast 406	java/lang/String
    //   297: invokestatic 159	aqep:I	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   300: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: aload_0
    //   307: getfield 510	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:dsy	I
    //   310: aload_0
    //   311: getfield 540	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:dsx	I
    //   314: aload_1
    //   315: getfield 310	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$a:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   318: invokevirtual 349	com/tencent/mobileqq/widget/ProfileCardScrollImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   321: aload_1
    //   322: getfield 310	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$a:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   325: invokevirtual 349	com/tencent/mobileqq/widget/ProfileCardScrollImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   328: iconst_0
    //   329: invokestatic 545	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Z)Lcom/tencent/image/URLDrawable;
    //   332: astore_2
    //   333: aload_1
    //   334: getfield 310	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$a:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   337: aload_2
    //   338: invokevirtual 549	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   341: aload_1
    //   342: getfield 310	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$a:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   345: iload_3
    //   346: invokestatic 555	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   349: invokevirtual 559	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setTag	(Ljava/lang/Object;)V
    //   352: return
    //   353: aload_0
    //   354: getfield 233	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   357: invokestatic 563	aldz:k	(Lmqq/app/AppRuntime;)V
    //   360: goto -191 -> 169
    //   363: aload_1
    //   364: getfield 475	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$a:d	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   367: bipush 8
    //   369: invokevirtual 480	com/tencent/mobileqq/hiboom/HiBoomTextView:setVisibility	(I)V
    //   372: goto -144 -> 228
    //   375: aload_1
    //   376: getfield 310	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$a:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   379: iconst_1
    //   380: invokevirtual 536	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setIsScroll	(Z)V
    //   383: aload_0
    //   384: getfield 154	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:mContext	Landroid/content/Context;
    //   387: aload 7
    //   389: iconst_0
    //   390: invokeinterface 313 2 0
    //   395: checkcast 406	java/lang/String
    //   398: invokestatic 159	aqep:I	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   401: astore 8
    //   403: new 565	java/io/BufferedInputStream
    //   406: dup
    //   407: new 567	java/io/FileInputStream
    //   410: dup
    //   411: new 161	java/io/File
    //   414: dup
    //   415: aload 8
    //   417: invokespecial 163	java/io/File:<init>	(Ljava/lang/String;)V
    //   420: invokespecial 570	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   423: invokespecial 573	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   426: astore 7
    //   428: aload 7
    //   430: astore_2
    //   431: new 575	android/graphics/BitmapFactory$Options
    //   434: dup
    //   435: invokespecial 576	android/graphics/BitmapFactory$Options:<init>	()V
    //   438: astore 9
    //   440: aload 7
    //   442: astore_2
    //   443: aload 9
    //   445: iconst_1
    //   446: putfield 579	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   449: aload 7
    //   451: astore_2
    //   452: aload 9
    //   454: aload_0
    //   455: getfield 582	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:dsm	I
    //   458: putfield 585	android/graphics/BitmapFactory$Options:inDensity	I
    //   461: aload 7
    //   463: astore_2
    //   464: aload 9
    //   466: aload_0
    //   467: getfield 582	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:dsm	I
    //   470: putfield 588	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   473: aload 7
    //   475: astore_2
    //   476: aload 9
    //   478: aload_0
    //   479: getfield 582	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:dsm	I
    //   482: putfield 591	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   485: aload 7
    //   487: astore_2
    //   488: aload 7
    //   490: aconst_null
    //   491: aload 9
    //   493: invokestatic 597	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   496: pop
    //   497: aload 7
    //   499: astore_2
    //   500: aload 9
    //   502: getfield 600	android/graphics/BitmapFactory$Options:outWidth	I
    //   505: istore 5
    //   507: aload 7
    //   509: astore_2
    //   510: aload 9
    //   512: getfield 603	android/graphics/BitmapFactory$Options:outHeight	I
    //   515: aload_0
    //   516: getfield 510	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:dsy	I
    //   519: imul
    //   520: iload 5
    //   522: idiv
    //   523: istore 6
    //   525: aload 7
    //   527: astore_2
    //   528: aload_0
    //   529: aload_0
    //   530: getfield 540	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:dsx	I
    //   533: iload 6
    //   535: isub
    //   536: putfield 605	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:dsz	I
    //   539: aload 7
    //   541: astore_2
    //   542: aload_1
    //   543: getfield 310	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$a:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   546: getstatic 611	android/widget/ImageView$ScaleType:MATRIX	Landroid/widget/ImageView$ScaleType;
    //   549: invokevirtual 615	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   552: aload 7
    //   554: astore_2
    //   555: new 617	android/graphics/Matrix
    //   558: dup
    //   559: invokespecial 618	android/graphics/Matrix:<init>	()V
    //   562: astore 9
    //   564: aload 7
    //   566: astore_2
    //   567: aload 9
    //   569: aload_0
    //   570: getfield 510	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:dsy	I
    //   573: i2f
    //   574: iload 5
    //   576: i2f
    //   577: fdiv
    //   578: aload_0
    //   579: getfield 510	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:dsy	I
    //   582: i2f
    //   583: iload 5
    //   585: i2f
    //   586: fdiv
    //   587: invokevirtual 622	android/graphics/Matrix:postScale	(FF)Z
    //   590: pop
    //   591: aload 7
    //   593: astore_2
    //   594: aload_1
    //   595: getfield 310	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$a:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   598: aload 9
    //   600: invokevirtual 626	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setImageMatrix	(Landroid/graphics/Matrix;)V
    //   603: aload 7
    //   605: astore_2
    //   606: getstatic 189	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   609: aload 8
    //   611: invokevirtual 195	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   614: checkcast 628	android/graphics/drawable/Drawable
    //   617: astore 9
    //   619: aload 9
    //   621: ifnull +71 -> 692
    //   624: aload 7
    //   626: astore_2
    //   627: aload_1
    //   628: getfield 310	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$a:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   631: aload 9
    //   633: invokevirtual 549	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   636: aload 7
    //   638: astore_2
    //   639: aload_1
    //   640: getfield 310	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$a:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   643: iload_3
    //   644: invokestatic 555	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   647: invokevirtual 559	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setTag	(Ljava/lang/Object;)V
    //   650: aload 7
    //   652: astore_2
    //   653: aload_0
    //   654: getfield 86	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:dsw	I
    //   657: iload_3
    //   658: if_icmpne +11 -> 669
    //   661: aload 7
    //   663: astore_2
    //   664: aload_0
    //   665: iload_3
    //   666: invokevirtual 631	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:yK	(I)V
    //   669: aload 7
    //   671: ifnull -598 -> 73
    //   674: aload 7
    //   676: invokevirtual 634	java/io/BufferedInputStream:close	()V
    //   679: return
    //   680: astore_1
    //   681: ldc 208
    //   683: iconst_1
    //   684: ldc_w 636
    //   687: aload_1
    //   688: invokestatic 640	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   691: return
    //   692: aload 7
    //   694: astore_2
    //   695: new 642	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$5
    //   698: dup
    //   699: aload_0
    //   700: aload 8
    //   702: iload_3
    //   703: invokespecial 645	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$5:<init>	(Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;Ljava/lang/String;I)V
    //   706: bipush 8
    //   708: aconst_null
    //   709: iconst_1
    //   710: invokestatic 651	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   713: goto -44 -> 669
    //   716: astore_2
    //   717: aload 7
    //   719: astore_1
    //   720: aload_2
    //   721: astore 7
    //   723: aload_1
    //   724: astore_2
    //   725: ldc 208
    //   727: iconst_1
    //   728: ldc_w 636
    //   731: aload 7
    //   733: invokestatic 640	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   736: aload_1
    //   737: ifnull -664 -> 73
    //   740: aload_1
    //   741: invokevirtual 634	java/io/BufferedInputStream:close	()V
    //   744: return
    //   745: astore_1
    //   746: ldc 208
    //   748: iconst_1
    //   749: ldc_w 636
    //   752: aload_1
    //   753: invokestatic 640	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   756: return
    //   757: astore_1
    //   758: aconst_null
    //   759: astore_2
    //   760: aload_2
    //   761: ifnull +7 -> 768
    //   764: aload_2
    //   765: invokevirtual 634	java/io/BufferedInputStream:close	()V
    //   768: aload_1
    //   769: athrow
    //   770: astore_2
    //   771: ldc 208
    //   773: iconst_1
    //   774: ldc_w 636
    //   777: aload_2
    //   778: invokestatic 640	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   781: goto -13 -> 768
    //   784: aload_1
    //   785: getfield 310	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$a:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   788: iconst_0
    //   789: invokevirtual 536	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setIsScroll	(Z)V
    //   792: aload 7
    //   794: invokeinterface 295 1 0
    //   799: iconst_1
    //   800: if_icmple -727 -> 73
    //   803: aload 7
    //   805: iconst_0
    //   806: invokeinterface 313 2 0
    //   811: checkcast 653	java/lang/CharSequence
    //   814: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   817: ifne -744 -> 73
    //   820: aload 7
    //   822: iconst_1
    //   823: invokeinterface 313 2 0
    //   828: checkcast 653	java/lang/CharSequence
    //   831: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   834: ifne -761 -> 73
    //   837: new 172	java/lang/StringBuilder
    //   840: dup
    //   841: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   844: aload 7
    //   846: iconst_0
    //   847: invokeinterface 313 2 0
    //   852: checkcast 406	java/lang/String
    //   855: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: aload 7
    //   860: iconst_1
    //   861: invokeinterface 313 2 0
    //   866: checkcast 406	java/lang/String
    //   869: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   875: astore_2
    //   876: getstatic 189	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   879: aload_2
    //   880: invokevirtual 195	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   883: instanceof 197
    //   886: ifeq +53 -> 939
    //   889: getstatic 189	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   892: aload_2
    //   893: invokevirtual 195	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   896: checkcast 197	android/util/Pair
    //   899: getfield 201	android/util/Pair:first	Ljava/lang/Object;
    //   902: checkcast 628	android/graphics/drawable/Drawable
    //   905: astore_2
    //   906: aload_1
    //   907: getfield 310	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$a:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   910: aload_2
    //   911: invokevirtual 549	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   914: aload_1
    //   915: getfield 310	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$a:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   918: iload_3
    //   919: invokestatic 555	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   922: invokevirtual 559	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setTag	(Ljava/lang/Object;)V
    //   925: aload_0
    //   926: getfield 86	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:dsw	I
    //   929: iload_3
    //   930: if_icmpne -857 -> 73
    //   933: aload_0
    //   934: iload_3
    //   935: invokevirtual 631	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:yK	(I)V
    //   938: return
    //   939: new 655	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$6
    //   942: dup
    //   943: aload_0
    //   944: aload 7
    //   946: aload_2
    //   947: iload_3
    //   948: invokespecial 658	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$6:<init>	(Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;Ljava/util/List;Ljava/lang/String;I)V
    //   951: bipush 8
    //   953: aconst_null
    //   954: iconst_1
    //   955: invokestatic 651	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   958: return
    //   959: astore_1
    //   960: goto -200 -> 760
    //   963: astore 7
    //   965: aconst_null
    //   966: astore_1
    //   967: goto -244 -> 723
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	970	0	this	VipProfileCardPreviewActivity
    //   0	970	1	parama	VipProfileCardPreviewActivity.StylePagerAdapter.a
    //   0	970	2	paramalct	alct
    //   0	970	3	paramInt	int
    //   208	16	4	f	float
    //   138	446	5	i	int
    //   523	13	6	j	int
    //   56	889	7	localObject1	Object
    //   963	1	7	localException	Exception
    //   143	558	8	str	String
    //   438	194	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   674	679	680	java/lang/Exception
    //   431	440	716	java/lang/Exception
    //   443	449	716	java/lang/Exception
    //   452	461	716	java/lang/Exception
    //   464	473	716	java/lang/Exception
    //   476	485	716	java/lang/Exception
    //   488	497	716	java/lang/Exception
    //   500	507	716	java/lang/Exception
    //   510	525	716	java/lang/Exception
    //   528	539	716	java/lang/Exception
    //   542	552	716	java/lang/Exception
    //   555	564	716	java/lang/Exception
    //   567	591	716	java/lang/Exception
    //   594	603	716	java/lang/Exception
    //   606	619	716	java/lang/Exception
    //   627	636	716	java/lang/Exception
    //   639	650	716	java/lang/Exception
    //   653	661	716	java/lang/Exception
    //   664	669	716	java/lang/Exception
    //   695	713	716	java/lang/Exception
    //   740	744	745	java/lang/Exception
    //   403	428	757	finally
    //   764	768	770	java/lang/Exception
    //   431	440	959	finally
    //   443	449	959	finally
    //   452	461	959	finally
    //   464	473	959	finally
    //   476	485	959	finally
    //   488	497	959	finally
    //   500	507	959	finally
    //   510	525	959	finally
    //   528	539	959	finally
    //   542	552	959	finally
    //   555	564	959	finally
    //   567	591	959	finally
    //   594	603	959	finally
    //   606	619	959	finally
    //   627	636	959	finally
    //   639	650	959	finally
    //   653	661	959	finally
    //   664	669	959	finally
    //   695	713	959	finally
    //   725	736	959	finally
    //   403	428	963	java/lang/Exception
  }
  
  public void a(String paramString, UpsImageUploadResult paramUpsImageUploadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "url from UPS:" + paramUpsImageUploadResult.url);
    }
    this.gF.put(paramString, paramUpsImageUploadResult.url);
    gY(paramString, paramUpsImageUploadResult.url);
  }
  
  public boolean a(alct paramalct)
  {
    if ((paramalct == null) || (paramalct.c == null)) {
      return false;
    }
    paramalct = a(paramalct);
    if ((paramalct == null) || (paramalct.size() == 0)) {
      return false;
    }
    paramalct = paramalct.iterator();
    while (paramalct.hasNext())
    {
      String str = (String)paramalct.next();
      if (!aqep.aj(this.mContext, str)) {
        return false;
      }
    }
    return true;
  }
  
  public void addObserver(acci paramacci)
  {
    if (this.app != null) {
      this.app.addObserver(paramacci);
    }
  }
  
  boolean att()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem();
    alct localalct = (alct)this.EQ.get(i);
    if ((localalct != null) && (localalct.c != null)) {
      return localalct.c.agr == alcs.agq;
    }
    return false;
  }
  
  void c(long[] paramArrayOfLong)
  {
    label147:
    int m;
    if (paramArrayOfLong != null)
    {
      int i = 0;
      if (i < paramArrayOfLong.length)
      {
        l = paramArrayOfLong[i];
        if (l == alcs.agk)
        {
          k = 0;
          Object localObject = this.mContext;
          Context localContext = this.mContext;
          localObject = ((Context)localObject).getSharedPreferences("is_binding_shop", 0);
          j = k;
          if (localObject != null)
          {
            boolean bool = ((SharedPreferences)localObject).getBoolean(this.aNh, false);
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "isBinding=" + bool);
            }
            j = k;
            if (bool)
            {
              this.yE.add(Long.valueOf(l));
              j = 1;
            }
          }
          this.cws = true;
          if (this.dsw == i)
          {
            this.dsw = 0;
            if (this.agu == alcs.agc) {
              this.dsw = 0;
            }
            if ((j != 0) && (this.dsw == 0)) {
              anot.a(this.app, "CliOper", "", "", "Shop_Malltemplate", "0X8005B93", 0, 0, "", "", "", "");
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (j == 0) {
            break label147;
          }
          this.dsw += 1;
          break label147;
          this.yE.add(Long.valueOf(l));
        }
      }
      long l = alcs.agk;
      if ((this.yE.contains(Long.valueOf(l))) && (this.yE.contains(Long.valueOf(alcs.agq))))
      {
        this.yE.remove(Long.valueOf(l));
        this.yE.add(1, Long.valueOf(l));
      }
      int j = 0;
      i = 0;
      int k = 0;
      m = i;
      if (j < this.yE.size())
      {
        l = ((Long)this.yE.get(j)).longValue();
        if (l == this.agu)
        {
          i = 1;
          m = 1;
          this.dsw = j;
        }
        for (;;)
        {
          j += 1;
          k = m;
          break;
          m = k;
          if (l == this.agw)
          {
            int n = 1;
            i = n;
            m = k;
            if (k == 0)
            {
              this.dsw = j;
              i = n;
              m = k;
            }
          }
        }
      }
    }
    else
    {
      m = 0;
    }
    if ((m == 0) && (this.yE.size() > 0))
    {
      this.yE.add(Long.valueOf(this.agw));
      if (this.dsw == -1) {
        this.dsw = (this.yE.size() - 1);
      }
    }
    if (this.dsw == -1)
    {
      this.dsw = 0;
      this.cwp = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initStyleAndBg mWebStyleList = " + this.yE.toString() + ", mCurrentStyleId = " + this.agu + ", mWebStyleId = " + this.agw + ", mCurrentViewPos = " + this.dsw + ", mStyleListNull = " + this.cwp);
    }
  }
  
  int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    int m = j;
    if (paramInt1 != 0)
    {
      m = j;
      if (paramInt2 != 0)
      {
        m = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label43;
          }
          m = j;
        }
      }
    }
    label43:
    int k;
    label55:
    do
    {
      do
      {
        return m;
        j = paramOptions.outHeight;
        k = paramOptions.outWidth;
        m = i;
      } while (j <= paramInt2);
      m = i;
    } while (k <= paramInt1);
    int n = Math.round(j / paramInt2);
    m = Math.round(k / paramInt1);
    if (n > m) {}
    for (;;)
    {
      m = i;
      if (n < 2) {
        break;
      }
      k /= 2;
      j /= 2;
      i *= 2;
      break label55;
      n = m;
    }
  }
  
  protected void dFg()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) {
      return;
    }
    SK(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem());
  }
  
  public void dFm()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initTemplateListData start.");
    }
    if ((this.EQ == null) || (this.yE == null)) {
      return;
    }
    Object localObject2 = null;
    ArrayList localArrayList = dp();
    if (this.agw == 0L)
    {
      localObject1 = new alcs();
      ((alcs)localObject1).agr = 0L;
      ((alcs)localObject1).bVx = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
      ((alcs)localObject1).bVt = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
      ((alcs)localObject1).bVz = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
      ((alcs)localObject1).bVv = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
      ((alcs)localObject1).bVr = "0";
      ((alcs)localObject1).name = getString(2131697290);
      localArrayList.add(localObject1);
    }
    Object localObject1 = localObject2;
    int i;
    Object localObject3;
    label413:
    int j;
    int k;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0)
      {
        localObject1 = new ArrayList();
        if (this.cwp)
        {
          i = 0;
          if (i < localArrayList.size())
          {
            localObject2 = (alcs)localArrayList.get(i);
            if (this.agu == ((alcs)localObject2).agr) {
              this.dsw = i;
            }
            if (((alcs)localObject2).agr == alcs.agk)
            {
              this.cws = true;
              localObject3 = this.mContext;
              Context localContext = this.mContext;
              localObject3 = ((Context)localObject3).getSharedPreferences("is_binding_shop", 0);
              if ((localObject3 != null) && (((SharedPreferences)localObject3).getBoolean(this.aNh, false))) {
                this.yE.add(Long.valueOf(((alcs)localObject2).agr));
              }
              if (this.dsw == i)
              {
                this.dsw = 0;
                anot.a(this.app, "CliOper", "", "", "Shop_Malltemplate", "0X8005B93", 0, 0, "", "", "", "");
              }
            }
            for (;;)
            {
              i += 1;
              break;
              this.yE.add(Long.valueOf(((alcs)localObject2).agr));
            }
          }
          long l = alcs.agk;
          if ((this.yE.contains(Long.valueOf(l))) && (this.yE.contains(Long.valueOf(alcs.agq))))
          {
            this.yE.remove(Long.valueOf(l));
            this.yE.add(1, Long.valueOf(l));
          }
        }
        i = 0;
        if (i < this.yE.size())
        {
          j = 0;
          k = 0;
          label428:
          if (k < localArrayList.size())
          {
            localObject2 = (alcs)localArrayList.get(k);
            if (((Long)this.yE.get(i)).longValue() != ((alcs)localObject2).agr) {
              break label927;
            }
            localObject3 = new alct();
            ((alct)localObject3).c = ((alcs)localObject2);
            if (a((alct)localObject3))
            {
              ((alct)localObject3).status = 2;
              label502:
              a(((alct)localObject3).c);
              ((ArrayList)localObject1).add(localObject3);
              j = 1;
            }
          }
        }
      }
    }
    label914:
    label927:
    for (;;)
    {
      k += 1;
      break label428;
      ((alct)localObject3).status = 0;
      break label502;
      if (j == 0)
      {
        this.yE.remove(i);
        if ((this.dsw > 0) && (i <= this.dsw)) {
          this.dsw -= 1;
        }
        i -= 1;
      }
      for (;;)
      {
        i += 1;
        break label413;
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
          {
            if ((!this.cwr) && (this.EQ != null)) {
              this.EQ.clear();
            }
            if (this.EQ == null) {
              break;
            }
            this.EQ.addAll((Collection)localObject1);
            this.cwq = true;
            if (!QLog.isColorLevel()) {
              break label914;
            }
            i = 0;
          }
          for (;;)
          {
            if (i < this.EQ.size())
            {
              if (QLog.isColorLevel()) {
                QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initTemplateListData, style : " + ((alct)this.EQ.get(i)).c.agr + ", status : " + ((alct)this.EQ.get(i)).status + ", position : " + i);
              }
              i += 1;
              continue;
              localObject1 = new ArrayList();
              i = 0;
              if (i < localArrayList.size())
              {
                localObject2 = new alct();
                ((alct)localObject2).c = ((alcs)localArrayList.get(i));
                if (a((alct)localObject2))
                {
                  ((alct)localObject2).status = 2;
                  label830:
                  a(((alct)localObject2).c);
                  if (((alct)localObject2).c.agr != alcs.agk) {
                    break label870;
                  }
                }
                for (;;)
                {
                  i += 1;
                  break;
                  ((alct)localObject2).status = 0;
                  break label830;
                  label870:
                  ((ArrayList)localObject1).add(localObject2);
                }
              }
              if (this.EQ == null) {
                break;
              }
              this.EQ.clear();
              this.EQ.addAll((Collection)localObject1);
              this.cwq = true;
            }
          }
        }
        this.mHandler.sendEmptyMessage(1);
        return;
      }
    }
  }
  
  public void dFn()
  {
    if ((this.EQ != null) && (this.EQ.size() > 0))
    {
      if (this.dsw != -1)
      {
        alct localalct = (alct)this.EQ.get(this.dsw);
        a(this.dsw, localalct);
      }
      int i = 0;
      if (i < this.EQ.size())
      {
        if ((this.dsw != -1) && (i == this.dsw)) {}
        for (;;)
        {
          i += 1;
          break;
          a(i, (alct)this.EQ.get(i));
        }
      }
    }
  }
  
  public void dFo()
  {
    int i = 0;
    dFk();
    Object localObject = getIntent();
    if (localObject != null)
    {
      String str;
      if (((Intent)localObject).hasExtra("preview"))
      {
        this.crd = 0;
        str = ((Intent)localObject).getStringExtra("preview");
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initStyleAndBg preview = " + str);
        }
        try
        {
          localObject = new JSONObject(str);
          if (((JSONObject)localObject).has("entryId")) {
            this.drV = ((JSONObject)localObject).getInt("entryId");
          }
          localObject = ((JSONObject)localObject).getJSONObject("item");
          this.jdField_a_of_type_Alcl = new alcl();
          this.jdField_a_of_type_Alcl.id = ((JSONObject)localObject).optInt("id");
          this.jdField_a_of_type_Alcl.name = ((JSONObject)localObject).optString("name");
          this.jdField_a_of_type_Alcl.type = ((JSONObject)localObject).optInt("type");
          this.jdField_a_of_type_Alcl.image_url = ((JSONObject)localObject).optString("image_url");
          this.jdField_a_of_type_Alcl.bVl = ((JSONObject)localObject).optString("thumb_url");
          this.jdField_a_of_type_Alcl.drF = ((JSONObject)localObject).optInt("auth");
          this.jdField_a_of_type_Alcl.drG = ((JSONObject)localObject).optInt("limitefree_type");
          this.jdField_a_of_type_Alcl.drH = ((JSONObject)localObject).optInt("limitefree_btime");
          this.jdField_a_of_type_Alcl.drI = ((JSONObject)localObject).optInt("limitefree_etime");
          this.jdField_a_of_type_Alcl.color = ((JSONObject)localObject).optInt("color");
          this.jdField_a_of_type_Alcl.tag = ((JSONObject)localObject).optInt("tag");
          this.jdField_a_of_type_Alcl.drJ = ((JSONObject)localObject).optInt("tag_btime");
          this.jdField_a_of_type_Alcl.drK = ((JSONObject)localObject).optInt("tag_etime");
          this.jdField_a_of_type_Alcl.drL = ((JSONObject)localObject).optInt("background_btime");
          this.jdField_a_of_type_Alcl.drM = ((JSONObject)localObject).optInt("background_etime");
          this.dsl = this.jdField_a_of_type_Alcl.color;
          a(this.jdField_a_of_type_Alcl);
          this.agw = ((JSONObject)localObject).optInt("style");
          if (this.jdField_a_of_type_Alcl.id == 160)
          {
            this.agw = 1L;
            localObject = l();
            c((long[])localObject);
            Oa(this.jdField_a_of_type_Alcl.image_url);
            return;
          }
          JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("style_list");
          long[] arrayOfLong = new long[localJSONArray.length()];
          for (;;)
          {
            localObject = arrayOfLong;
            if (i >= localJSONArray.length()) {
              break;
            }
            arrayOfLong[i] = localJSONArray.getLong(i);
            i += 1;
          }
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initStyleAndBg JSONException json = " + str);
        }
        catch (JSONException localJSONException)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
      }
      else if (localJSONException.hasExtra("custom_card_background"))
      {
        this.crd = 1;
        this.bVV = localJSONException.getStringExtra("custom_card_background");
        this.jdField_a_of_type_Alcl = new alcl();
        this.jdField_a_of_type_Alcl.id = 160;
        this.agw = 1L;
        c(l());
        gX(this.bVV, null);
      }
    }
  }
  
  void dFp()
  {
    this.G = new arhz(this, getTitleBarHeight());
    this.G.setCancelable(false);
    this.G.setMessage(2131697318);
    try
    {
      this.G.show();
      this.mHandler.sendEmptyMessageDelayed(25, 30000L);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void dFq()
  {
    bF();
    this.mHandler.removeMessages(25);
  }
  
  void dFr()
  {
    if (!TextUtils.isEmpty(this.bVV))
    {
      File localFile = new File(this.bVV);
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
  
  @TargetApi(16)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.cwt = false;
    setContentView(2131562235);
    getWindow().setBackgroundDrawable(null);
    this.mContext = this;
    this.mask = findViewById(2131374954);
    float f;
    label420:
    QQAppInterface localQQAppInterface;
    if ((this.app != null) && (ThemeUtil.isInNightMode(this.app)))
    {
      if (this.mask != null) {
        this.mask.setVisibility(0);
      }
      if (this.app != null) {
        this.aNh += this.app.getCurrentAccountUin();
      }
      this.b = ((CirclePageIndicator)findViewById(2131372828));
      this.cl = ((Button)findViewById(2131372618));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager = ((VipScaledViewPager)findViewById(2131381929));
      this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity$StylePagerAdapter = new StylePagerAdapter(this.mContext);
      if (Build.MODEL.equals("HUAWEI C8812E")) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setLayerType(1, null);
      }
      this.mDensityScale = (this.mDensity / 2.0F);
      if (this.mScreenHeight / this.mScreenWidth <= (this.ys + this.yt) / 2.0F) {
        break label792;
      }
      f = this.mScreenHeight / (1136.0F * this.mDensityScale);
      this.dso = Math.round(aqep.dpToPx(this.mContext, 15) * f);
      this.dsp = Math.round(aqep.dpToPx(this.mContext, 15) * f);
      this.dsq = Math.round(aqep.dpToPx(this.mContext, 15) * f);
      this.mBtnHeight = aqep.dpToPx(this.mContext, 45);
      this.aPN = Math.round(aqep.dpToPx(this.mContext, 3) * f);
      this.dss = Math.round(aqep.dpToPx(this.mContext, 7) * f);
      this.dsr = Math.round(aqep.f(this.mContext, 14.5F) * f);
      this.dst = Math.round(aqep.dpToPx(this.mContext, 20) * f);
      this.dsu = Math.round(f * aqep.dpToPx(this.mContext, 15));
      this.yr = 0.824503F;
      this.dsv = 18;
      paramBundle = (RelativeLayout.LayoutParams)this.cl.getLayoutParams();
      paramBundle.height = this.mBtnHeight;
      int i = this.dsq;
      paramBundle.leftMargin = i;
      paramBundle.rightMargin = i;
      paramBundle.bottomMargin = this.dsp;
      this.cl.setTextSize(1, this.dsv);
      this.cl.setLayoutParams(paramBundle);
      paramBundle = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      paramBundle.topMargin = this.dsr;
      paramBundle.bottomMargin = this.dsr;
      this.b.setLayoutParams(paramBundle);
      this.b.setCirclePadding(this.dss);
      this.b.setRadius(this.aPN);
      i = getResources().getDimensionPixelSize(2131299627);
      int j = aqep.e(getResources());
      this.dsn = (this.mScreenHeight - this.dst - this.dsp - this.mBtnHeight - this.aPN * 2 - this.dsr * 2 - i - j);
      this.dsx = this.dsn;
      this.dsy = Math.round(this.dsx / 1.78F);
      this.b.setStrokeWidth(0.0F);
      addObserver(this.cardObserver);
      ThreadManager.post(new VipProfileCardPreviewActivity.1(this), 8, null, true);
      ZM();
      this.cl.setOnClickListener(this);
      if (this.app != null) {
        this.app.addObserver(this.g, true);
      }
      this.b.setOnPageChangeListener(new alds(this));
      if (this.app != null)
      {
        localQQAppInterface = this.app;
        if (this.jdField_a_of_type_Alcl != null) {
          break label988;
        }
      }
    }
    label792:
    label988:
    for (paramBundle = "";; paramBundle = Integer.toString(this.jdField_a_of_type_Alcl.id))
    {
      anot.a(localQQAppInterface, "CliOper", "", "", "card_mall", "0X8004D59", 0, 0, paramBundle, "", "", VipUtils.d(this.app, this.app.getCurrentAccountUin()));
      return true;
      if (this.mask == null) {
        break;
      }
      this.mask.setVisibility(8);
      break;
      f = this.mScreenHeight / (800.0F * this.mDensityScale);
      this.dso = Math.round(aqep.dpToPx(this.mContext, 11) * f);
      this.dsp = Math.round(aqep.dpToPx(this.mContext, 10) * f);
      this.dsq = Math.round(aqep.dpToPx(this.mContext, 11) * f);
      this.mBtnHeight = aqep.dpToPx(this.mContext, 40);
      this.aPN = Math.round(aqep.dpToPx(this.mContext, 3) * f);
      this.dss = Math.round(aqep.dpToPx(this.mContext, 7) * f);
      this.dsr = Math.round(aqep.f(this.mContext, 16.5F) * f);
      this.dst = Math.round(aqep.dpToPx(this.mContext, 20) * f);
      this.dsu = Math.round(f * aqep.dpToPx(this.mContext, 15));
      this.dsv = 16;
      this.yr = 0.8192771F;
      break label420;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.cwt = true;
    if (this.cardObserver != null)
    {
      this.app.removeObserver(this.cardObserver);
      this.cardObserver = null;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.app != null) {
      this.app.removeObserver(this.g);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.app != null) {
      this.app.addObserver(this.g, true);
    }
  }
  
  public void dv(int paramInt, String paramString)
  {
    ThreadManager.post(new VipProfileCardPreviewActivity.4(this, paramInt, paramString), 5, null, true);
  }
  
  void gX(String paramString1, String paramString2)
  {
    ThreadManager.post(new VipProfileCardPreviewActivity.7(this, paramString1, paramString2), 8, null, true);
  }
  
  void gY(String paramString1, String paramString2)
  {
    if ((this.EQ == null) || (this.EQ.size() == 0)) {}
    alcl localalcl;
    alcs localalcs;
    do
    {
      return;
      localalcl = new alcl();
      localalcl.id = 160;
      localalcs = ((alct)this.EQ.get(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem())).c;
    } while ((localalcs == null) || (this.cwt) || (isFinishing()) || (!a(localalcs, localalcl, true)));
    e(gx(), 0L, paramString2, aqep.fb(paramString1));
  }
  
  long gx()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem();
    return ((alct)this.EQ.get(i)).c.agr;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  /* Error */
  android.graphics.Bitmap j(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: getstatic 1247	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   6: astore 4
    //   8: iconst_1
    //   9: istore_3
    //   10: aload 8
    //   12: astore 6
    //   14: iload_3
    //   15: iconst_2
    //   16: if_icmpgt +185 -> 201
    //   19: new 575	android/graphics/BitmapFactory$Options
    //   22: dup
    //   23: invokespecial 576	android/graphics/BitmapFactory$Options:<init>	()V
    //   26: astore 9
    //   28: aload 9
    //   30: aload 4
    //   32: putfield 1250	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   35: aload 9
    //   37: aload_0
    //   38: getfield 582	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:dsm	I
    //   41: putfield 585	android/graphics/BitmapFactory$Options:inDensity	I
    //   44: aload 9
    //   46: aload_0
    //   47: getfield 582	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:dsm	I
    //   50: putfield 588	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   53: aload 9
    //   55: aload_0
    //   56: getfield 582	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:dsm	I
    //   59: putfield 591	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   62: new 565	java/io/BufferedInputStream
    //   65: dup
    //   66: new 567	java/io/FileInputStream
    //   69: dup
    //   70: new 161	java/io/File
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 163	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: invokespecial 570	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   81: invokespecial 573	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: astore 4
    //   86: iload_2
    //   87: ifeq +37 -> 124
    //   90: aload 9
    //   92: iconst_1
    //   93: putfield 579	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   96: aload 4
    //   98: aconst_null
    //   99: aload 9
    //   101: invokestatic 597	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   104: pop
    //   105: aload 9
    //   107: aload_0
    //   108: aload 9
    //   110: aload_0
    //   111: getfield 510	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:dsy	I
    //   114: aload_0
    //   115: getfield 540	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:dsx	I
    //   118: invokevirtual 1252	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   121: putfield 1255	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   124: aload 9
    //   126: iconst_0
    //   127: putfield 579	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   130: new 565	java/io/BufferedInputStream
    //   133: dup
    //   134: new 567	java/io/FileInputStream
    //   137: dup
    //   138: new 161	java/io/File
    //   141: dup
    //   142: aload_1
    //   143: invokespecial 163	java/io/File:<init>	(Ljava/lang/String;)V
    //   146: invokespecial 570	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   149: invokespecial 573	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   152: astore 5
    //   154: aload 5
    //   156: astore 6
    //   158: aload 4
    //   160: astore 7
    //   162: aload 5
    //   164: aconst_null
    //   165: aload 9
    //   167: invokestatic 597	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   170: astore 9
    //   172: aload 9
    //   174: astore_1
    //   175: aload 4
    //   177: ifnull +8 -> 185
    //   180: aload 4
    //   182: invokevirtual 634	java/io/BufferedInputStream:close	()V
    //   185: aload_1
    //   186: astore 6
    //   188: aload 5
    //   190: ifnull +11 -> 201
    //   193: aload 5
    //   195: invokevirtual 634	java/io/BufferedInputStream:close	()V
    //   198: aload_1
    //   199: astore 6
    //   201: aload 6
    //   203: areturn
    //   204: astore 4
    //   206: ldc 208
    //   208: iconst_1
    //   209: ldc_w 1257
    //   212: aload 4
    //   214: invokestatic 640	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   217: aload_1
    //   218: areturn
    //   219: astore 4
    //   221: aconst_null
    //   222: astore 5
    //   224: aconst_null
    //   225: astore 4
    //   227: aload 5
    //   229: astore 6
    //   231: aload 4
    //   233: astore 7
    //   235: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +47 -> 285
    //   241: aload 5
    //   243: astore 6
    //   245: aload 4
    //   247: astore 7
    //   249: ldc 208
    //   251: iconst_2
    //   252: new 172	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   259: ldc_w 1259
    //   262: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_1
    //   266: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc_w 1261
    //   272: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: iload_3
    //   276: invokevirtual 448	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   279: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: aload 5
    //   287: astore 6
    //   289: aload 4
    //   291: astore 7
    //   293: getstatic 1264	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   296: astore 9
    //   298: aload 4
    //   300: ifnull +8 -> 308
    //   303: aload 4
    //   305: invokevirtual 634	java/io/BufferedInputStream:close	()V
    //   308: aload 5
    //   310: ifnull +8 -> 318
    //   313: aload 5
    //   315: invokevirtual 634	java/io/BufferedInputStream:close	()V
    //   318: iload_3
    //   319: iconst_1
    //   320: iadd
    //   321: istore_3
    //   322: aload 9
    //   324: astore 4
    //   326: goto -316 -> 10
    //   329: astore 4
    //   331: ldc 208
    //   333: iconst_1
    //   334: ldc_w 1257
    //   337: aload 4
    //   339: invokestatic 640	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   342: goto -24 -> 318
    //   345: astore 6
    //   347: aconst_null
    //   348: astore 4
    //   350: aconst_null
    //   351: astore 5
    //   353: invokestatic 206	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq +53 -> 409
    //   359: ldc 208
    //   361: iconst_2
    //   362: new 172	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 1259
    //   372: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_1
    //   376: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: ldc_w 1266
    //   382: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: aload 6
    //   387: invokevirtual 1269	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   390: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: ldc_w 1261
    //   396: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: iload_3
    //   400: invokevirtual 448	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   403: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: aload 5
    //   411: ifnull +8 -> 419
    //   414: aload 5
    //   416: invokevirtual 634	java/io/BufferedInputStream:close	()V
    //   419: aload 8
    //   421: astore 6
    //   423: aload 4
    //   425: ifnull -224 -> 201
    //   428: aload 4
    //   430: invokevirtual 634	java/io/BufferedInputStream:close	()V
    //   433: aconst_null
    //   434: areturn
    //   435: astore_1
    //   436: ldc 208
    //   438: iconst_1
    //   439: ldc_w 1257
    //   442: aload_1
    //   443: invokestatic 640	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   446: aconst_null
    //   447: areturn
    //   448: astore_1
    //   449: aconst_null
    //   450: astore 4
    //   452: aconst_null
    //   453: astore 5
    //   455: aload 5
    //   457: ifnull +8 -> 465
    //   460: aload 5
    //   462: invokevirtual 634	java/io/BufferedInputStream:close	()V
    //   465: aload 4
    //   467: ifnull +8 -> 475
    //   470: aload 4
    //   472: invokevirtual 634	java/io/BufferedInputStream:close	()V
    //   475: aload_1
    //   476: athrow
    //   477: astore 4
    //   479: ldc 208
    //   481: iconst_1
    //   482: ldc_w 1257
    //   485: aload 4
    //   487: invokestatic 640	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   490: goto -15 -> 475
    //   493: astore_1
    //   494: aload 4
    //   496: astore 5
    //   498: aconst_null
    //   499: astore 4
    //   501: goto -46 -> 455
    //   504: astore_1
    //   505: aload 7
    //   507: astore 5
    //   509: aload 6
    //   511: astore 4
    //   513: goto -58 -> 455
    //   516: astore_1
    //   517: goto -62 -> 455
    //   520: astore 6
    //   522: aload 4
    //   524: astore 5
    //   526: aconst_null
    //   527: astore 4
    //   529: goto -176 -> 353
    //   532: astore 6
    //   534: aload 4
    //   536: astore 7
    //   538: aload 5
    //   540: astore 4
    //   542: aload 7
    //   544: astore 5
    //   546: goto -193 -> 353
    //   549: astore 5
    //   551: aconst_null
    //   552: astore 5
    //   554: goto -327 -> 227
    //   557: astore 6
    //   559: goto -332 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	562	0	this	VipProfileCardPreviewActivity
    //   0	562	1	paramString	String
    //   0	562	2	paramBoolean	boolean
    //   9	391	3	i	int
    //   6	175	4	localObject1	Object
    //   204	9	4	localException1	Exception
    //   219	1	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   225	100	4	localObject2	Object
    //   329	9	4	localException2	Exception
    //   348	123	4	localObject3	Object
    //   477	18	4	localException3	Exception
    //   499	42	4	localObject4	Object
    //   152	393	5	localObject5	Object
    //   549	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   552	1	5	localObject6	Object
    //   12	276	6	localObject7	Object
    //   345	41	6	localException4	Exception
    //   421	89	6	localObject8	Object
    //   520	1	6	localException5	Exception
    //   532	1	6	localException6	Exception
    //   557	1	6	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   160	383	7	localObject9	Object
    //   1	419	8	localObject10	Object
    //   26	297	9	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   180	185	204	java/lang/Exception
    //   193	198	204	java/lang/Exception
    //   19	86	219	java/lang/OutOfMemoryError
    //   303	308	329	java/lang/Exception
    //   313	318	329	java/lang/Exception
    //   19	86	345	java/lang/Exception
    //   414	419	435	java/lang/Exception
    //   428	433	435	java/lang/Exception
    //   19	86	448	finally
    //   460	465	477	java/lang/Exception
    //   470	475	477	java/lang/Exception
    //   90	124	493	finally
    //   124	154	493	finally
    //   162	172	504	finally
    //   235	241	504	finally
    //   249	285	504	finally
    //   293	298	504	finally
    //   353	409	516	finally
    //   90	124	520	java/lang/Exception
    //   124	154	520	java/lang/Exception
    //   162	172	532	java/lang/Exception
    //   90	124	549	java/lang/OutOfMemoryError
    //   124	154	549	java/lang/OutOfMemoryError
    //   162	172	557	java/lang/OutOfMemoryError
  }
  
  public boolean onBackEvent()
  {
    anot.a(this.app, "CliOper", "", "", "card_mall", "0X8004C28", 0, 0, "", "", "", VipUtils.d(this.app, this.app.getCurrentAccountUin()));
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager != null) && (this.EQ != null) && (this.EQ.size() > 0))
      {
        Object localObject;
        if (this.crd == 0)
        {
          int i = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem();
          localObject = (alct)this.EQ.get(i);
          anot.a(this.app, "CliOper", "", "", "card_mall", "0X8004C27", 0, 0, this.bVU, Long.toString(((alct)localObject).c.agr), "", VipUtils.d(this.app, this.app.getCurrentAccountUin()));
          if (((alct)localObject).c.agr == alcs.agk) {
            anot.a(this.app, "CliOper", "", "", "Shop_Malltemplateclk", "0X8005B92", 0, 0, "", "", "", "");
          }
          if (a(((alct)localObject).c, this.jdField_a_of_type_Alcl, true)) {
            if (this.jdField_a_of_type_Alcl.id != 160) {
              ay(((alct)localObject).c.agr, this.jdField_a_of_type_Alcl.id);
            } else {
              e(gx(), this.jdField_a_of_type_Alcl.id, this.jdField_a_of_type_Alcl.image_url, this.jdField_a_of_type_Alcl.color);
            }
          }
        }
        else if (this.crd == 1)
        {
          anot.a(this.app, "CliOper", "", "", "card_mall", "0X8004C27", 0, 0, this.bVU, "-1", "", VipUtils.d(this.app, this.app.getCurrentAccountUin()));
          if (att())
          {
            localObject = new Intent(this, VipProfileCardDiyActivity.class);
            ((Intent)localObject).putExtra("extra_from", 3);
            ((Intent)localObject).putExtra("extra_card_id", 0L);
            ((Intent)localObject).putExtra("extra_card_path", this.bVV);
            startActivity((Intent)localObject);
          }
          else
          {
            aqep.a(this.bVV, 100, 0.56338F);
            if (!TextUtils.isEmpty((CharSequence)this.gF.get(this.bVV))) {
              gY(this.bVV, (String)this.gF.get(this.bVV));
            } else {
              Ob(this.bVV);
            }
          }
        }
      }
    }
  }
  
  @TargetApi(16)
  protected boolean p(Message paramMessage)
  {
    int i = 0;
    switch (paramMessage.what)
    {
    default: 
      if (paramMessage.what != 2) {
        break label396;
      }
      if (Build.VERSION.SDK_INT >= 16) {
        this.CD.setBackground(this.dB);
      }
      break;
    }
    for (;;)
    {
      return true;
      paramMessage = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getLayoutParams();
      paramMessage.height = this.dsn;
      paramMessage.topMargin = this.dst;
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setLayoutParams(paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setScale(this.yr);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setGap(this.dsu);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity$StylePagerAdapter);
      this.b.setViewPager(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager);
      this.b.setVisibility(0);
      dFn();
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setCurrentItem(this.dsw);
      SK(this.dsw);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initiate now mCurrentViewPos = " + this.dsw);
      }
      if (this.cws)
      {
        paramMessage = (CardHandler)this.app.getBusinessHandler(2);
        if (paramMessage != null)
        {
          long l = NetConnInfoCenter.getServerTimeMillis();
          if (Math.abs(l - this.LJ) <= 60000L) {
            break label286;
          }
          this.LJ = l;
          paramMessage.Ds(this.app.getCurrentAccountUin());
        }
      }
      for (;;)
      {
        return true;
        label286:
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "try getShoppingBindNo too frequently to req");
        }
      }
      int j = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getChildCount();
      while (i < j)
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getChildAt(i);
        if ((paramMessage.getTag() instanceof VipProfileCardPreviewActivity.StylePagerAdapter.a)) {
          ((VipProfileCardPreviewActivity.StylePagerAdapter.a)paramMessage.getTag()).a.setBackgroundDrawable(this.dB);
        }
        i += 1;
      }
      return true;
      SJ(paramMessage.arg1);
      return true;
      SJ(paramMessage.arg1);
      return true;
      this.CD.setBackgroundDrawable(this.dB);
    }
    label396:
    if (paramMessage.what == 3)
    {
      Toast.makeText(this.mContext.getApplicationContext(), 2131697284, 0).show();
      return true;
    }
    if (paramMessage.what == 20)
    {
      SJ(paramMessage.arg1);
      return true;
    }
    if (paramMessage.what == 5)
    {
      Toast.makeText(this.mContext.getApplicationContext(), 2131697312, 0).show();
      if ((this.drV == 1) || (this.drV == 2)) {
        if (this.crd == 1) {
          BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.closeWeb"), "com.tencent.tim.msg.permission.pushnotify");
        }
      }
      for (;;)
      {
        dFr();
        finish();
        return true;
        paramMessage = new Intent();
        paramMessage.putExtra("uin", this.app.getCurrentAccountUin());
        paramMessage.putExtra("entryId", this.drV);
        setResult(-1, paramMessage);
        continue;
        paramMessage = new Intent(this, FriendProfileCardActivity.class);
        paramMessage.putExtra("AllInOne", new ProfileActivity.AllInOne(this.app.getCurrentAccountUin(), 0));
        paramMessage.setFlags(67108864);
        startActivity(paramMessage);
      }
    }
    if (paramMessage.what == 21)
    {
      if (this.EQ != null) {
        ((alct)this.EQ.get(paramMessage.arg1)).status = -1;
      }
      return true;
    }
    if ((paramMessage.what == 24) || (paramMessage.what == 25))
    {
      if (paramMessage.what == 25) {
        bF();
      }
      Toast.makeText(getApplicationContext(), getResources().getString(2131697317), 1).show();
      return true;
    }
    return false;
  }
  
  public void yK(int paramInt)
  {
    if (this.dsA != -1)
    {
      SI(this.dsA);
      this.dsA = -1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) || (this.EQ == null) || (paramInt < 0) || (paramInt >= this.EQ.size())) {}
    do
    {
      alct localalct;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.findViewById(paramInt);
              } while ((localObject == null) || (((View)localObject).getTag() == null));
              localObject = (VipProfileCardPreviewActivity.StylePagerAdapter.a)((View)localObject).getTag();
            } while (localObject == null);
            localObject = ((VipProfileCardPreviewActivity.StylePagerAdapter.a)localObject).a;
            localalct = (alct)this.EQ.get(paramInt);
          } while ((localalct == null) || (((ProfileCardScrollImageView)localObject).getTag() == null));
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "startAnimation pos = " + paramInt);
          }
          switch (localalct.c.animation)
          {
          default: 
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "no animation to start !");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "start ANIMATION_SCROLL");
        }
      } while (localalct.c.agr == alcs.agq);
      ((ProfileCardScrollImageView)localObject).setScrollDuration(1500);
      ((ProfileCardScrollImageView)localObject).YD(this.dsz);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "start ANIMATION_FADE_IN_OUT");
      }
      localObject = ((ProfileCardScrollImageView)localObject).getDrawable();
    } while (!(localObject instanceof TransitionDrawable));
    Object localObject = (TransitionDrawable)localObject;
    ((TransitionDrawable)localObject).setCrossFadeEnabled(true);
    ((TransitionDrawable)localObject).startTransition(1500);
    this.hn = new VipProfileCardPreviewActivity.3(this, (TransitionDrawable)localObject);
    this.mHandler.postDelayed(this.hn, 2000L);
  }
  
  public class StylePagerAdapter
    extends PagerAdapter
  {
    public Context mContext;
    public LayoutInflater mInflater;
    
    public StylePagerAdapter(Context paramContext)
    {
      this.mContext = paramContext;
      this.mInflater = LayoutInflater.from(this.mContext);
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "destroyItem, pos = " + paramInt);
      }
      paramObject = (View)paramObject;
      a locala = (a)paramObject.getTag();
      paramViewGroup.removeView(paramObject);
    }
    
    public int getCount()
    {
      return VipProfileCardPreviewActivity.this.EQ.size();
    }
    
    @TargetApi(16)
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "instantiateItem, pos = " + paramInt);
      }
      View localView = this.mInflater.inflate(2131562234, paramViewGroup, false);
      a locala = new a();
      locala.a = ((ProfileCardScrollImageView)localView.findViewById(2131367838));
      locala.d = ((HiBoomTextView)localView.findViewById(2131368517));
      localView.setTag(locala);
      locala.a.setScaleType(ImageView.ScaleType.FIT_XY);
      Object localObject = (RelativeLayout.LayoutParams)locala.a.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = VipProfileCardPreviewActivity.this.dsy;
      ((RelativeLayout.LayoutParams)localObject).height = VipProfileCardPreviewActivity.this.dsx;
      locala.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (Build.VERSION.SDK_INT >= 16) {
        locala.a.setBackground(VipProfileCardPreviewActivity.this.dB);
      }
      for (;;)
      {
        localObject = this.mContext.getResources().getDrawable(2130848291);
        locala.a.setImageDrawable((Drawable)localObject);
        localView.setId(paramInt);
        localObject = (alct)VipProfileCardPreviewActivity.this.EQ.get(paramInt);
        paramViewGroup.addView(localView);
        VipProfileCardPreviewActivity.this.a(locala, (alct)localObject, paramInt);
        return localView;
        locala.a.setBackgroundDrawable(VipProfileCardPreviewActivity.this.dB);
      }
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public class a
    {
      ProfileCardScrollImageView a;
      HiBoomTextView d;
      
      public a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPreviewActivity
 * JD-Core Version:    0.7.0.1
 */