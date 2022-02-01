package com.tencent.mobileqq.activity;

import acfp;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqiw;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.portal.PortalManager.d;
import com.tencent.mobileqq.portal.SanHuaView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import ocp;
import org.json.JSONObject;
import vdv;

public class HongbaoShowerActivity
  extends BaseActivity
{
  private TextView DG;
  private TextView DH;
  private TextView DI;
  private TextView DJ;
  PortalManager.d jdField_a_of_type_ComTencentMobileqqPortalPortalManager$d;
  private SanHuaView jdField_a_of_type_ComTencentMobileqqPortalSanHuaView;
  private String aNA;
  private String aNB;
  private String aNw;
  private String aNx;
  private String aNy;
  private String aNz;
  private boolean aXt = true;
  boolean aXu = false;
  private Animation an;
  private int bHK;
  private String businessName;
  private Bitmap dp;
  private RelativeLayout gG;
  private RelativeLayout gH;
  public long mCreateTime = 0L;
  private String mJumpUrl;
  private int mType;
  AlphaAnimation n;
  private CheckBox q;
  private ImageView qf;
  private ImageView qg;
  private View tr;
  View ts;
  
  private JSONObject T()
  {
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject3.put("amount", this.aNy);
        localJSONObject3.put("channel", 4);
        if (this.aXu) {
          continue;
        }
        str = this.aNz;
        localJSONObject3.put("mch_icon", str);
        if (this.aXu) {
          continue;
        }
        str = this.aNA;
        localJSONObject3.put("mch_top_img", str);
        localJSONObject3.put("wishing", this.aNB);
        localJSONObject3.put("send_name", this.businessName);
        localJSONObject2.put("detailinfo", localJSONObject3);
        localJSONObject1.put("extra_data", localJSONObject2);
        localJSONObject1.put("come_from", 2);
        localJSONObject1.put("viewTag", "graphb");
        localJSONObject1.put("userId", this.app.getCurrentAccountUin());
        localJSONObject1.put("skey", getSKey());
        localJSONObject1.put("key_type", 2);
      }
      catch (Exception localException)
      {
        String str;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        localException.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager.HongbaoShowerActivity", 2, localJSONObject1.toString());
      }
      return localJSONObject1;
      str = "";
      continue;
      str = "";
    }
  }
  
  private void a(ImageView paramImageView, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      paramImageView.setImageDrawable(new BitmapDrawable(paramBitmap));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("PortalManager.HongbaoShowerActivity", 2, "HongbaoLogo == null");
  }
  
  private void bPL()
  {
    this.gH = ((RelativeLayout)findViewById(2131377429));
    this.gH.setVisibility(4);
    this.an = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
    this.an.setInterpolator(new a());
    this.an.setDuration(800L);
    this.an.setAnimationListener(new vdv(this));
    this.ts = findViewById(2131368592);
    this.n = new AlphaAnimation(0.0F, 0.7F);
    this.n.setDuration(350L);
    this.n.setFillAfter(true);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels;
    int j = localDisplayMetrics.heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView = new SanHuaView(this, i / 2, j / 2);
    this.gG.addView(this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentMobileqqPortalSanHuaView.SC(100);
  }
  
  private void bPM()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.HongbaoShowerActivity", 2, "showHongbaoResult mGiftUrl " + this.mJumpUrl);
    }
    if (!aqiw.isNetSupport(this)) {
      QQToast.a(this, acfp.m(2131707180), 1).show();
    }
    while ((this.mType != 0) && (this.mJumpUrl == null)) {
      return;
    }
    if ((this.q != null) && (this.q.isChecked())) {
      ocp.a(getAppInterface(), this, this.aNw, null, 113);
    }
    for (int i = 1;; i = 0)
    {
      switch (this.mType)
      {
      default: 
        finish();
        return;
      case 0: 
        localObject2 = T();
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("json", ((JSONObject)localObject2).toString());
        ((Bundle)localObject1).putString("callbackSn", "0");
        localObject2 = new Intent(this, PayBridgeActivity.class);
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        ((Intent)localObject2).putExtra("pay_requestcode", 5);
        startActivity((Intent)localObject2);
        localObject2 = this.app;
        if (i != 0) {}
        for (localObject1 = "1";; localObject1 = "2")
        {
          anot.a((QQAppInterface)localObject2, "dc01440", "", "", "0X80077E9", "0X80077E9", 0, 0, "1", (String)localObject1, "", "");
          break;
        }
      }
      Object localObject1 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", this.mJumpUrl);
      ((Intent)localObject1).putExtra("hide_left_button", false);
      ((Intent)localObject1).putExtra("show_right_close_button", true);
      ((Intent)localObject1).putExtra("finish_animation_up_down", true);
      ((Intent)localObject1).putExtra("hide_operation_bar", true);
      ((Intent)localObject1).addFlags(67108864);
      startActivity((Intent)localObject1);
      setResult(-1);
      Object localObject2 = this.app;
      if (i != 0) {}
      for (localObject1 = "1";; localObject1 = "2")
      {
        anot.a((QQAppInterface)localObject2, "dc01440", "", "", "0X80077E9", "0X80077E9", 0, 0, "2", (String)localObject1, "", "");
        break;
      }
    }
  }
  
  private void bPN()
  {
    ThreadManager.getUIHandler().postDelayed(new HongbaoShowerActivity.6(this), 500L);
  }
  
  public static String ct(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 2130845838: 
      return "shower_star_high_bg";
    case 2130845837: 
      return "shower_star_bg";
    }
    return "shower_business_high_bg";
  }
  
  private String getSKey()
  {
    TicketManager localTicketManager = (TicketManager)this.app.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getSkey(this.app.getCurrentAccountUin());
    }
    return "";
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield 454	com/tencent/mobileqq/activity/HongbaoShowerActivity:mActNeedImmersive	Z
    //   11: aload_0
    //   12: aload_1
    //   13: invokespecial 456	com/tencent/mobileqq/app/BaseActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   16: pop
    //   17: aload_0
    //   18: invokevirtual 460	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   21: astore_1
    //   22: aload_1
    //   23: ifnonnull +9 -> 32
    //   26: aload_0
    //   27: invokevirtual 337	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   30: iconst_0
    //   31: ireturn
    //   32: aload_0
    //   33: aload_1
    //   34: ldc_w 462
    //   37: iconst_0
    //   38: invokevirtual 466	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   41: putfield 150	com/tencent/mobileqq/activity/HongbaoShowerActivity:mType	I
    //   44: aload_0
    //   45: aload_0
    //   46: invokevirtual 460	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   49: ldc_w 468
    //   52: invokevirtual 471	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   55: putfield 295	com/tencent/mobileqq/activity/HongbaoShowerActivity:mJumpUrl	Ljava/lang/String;
    //   58: aload_0
    //   59: invokevirtual 460	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   62: ldc_w 473
    //   65: iconst_m1
    //   66: invokevirtual 466	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   69: istore_3
    //   70: aload_0
    //   71: aload_0
    //   72: invokevirtual 460	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   75: ldc_w 475
    //   78: invokevirtual 471	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   81: putfield 329	com/tencent/mobileqq/activity/HongbaoShowerActivity:aNw	Ljava/lang/String;
    //   84: aload_0
    //   85: invokevirtual 460	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   88: ldc_w 477
    //   91: iconst_m1
    //   92: invokevirtual 466	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   95: istore 4
    //   97: aload_0
    //   98: aload_0
    //   99: invokevirtual 460	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   102: ldc_w 479
    //   105: iconst_m1
    //   106: invokevirtual 466	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   109: putfield 481	com/tencent/mobileqq/activity/HongbaoShowerActivity:bHK	I
    //   112: aload_0
    //   113: invokevirtual 460	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   116: ldc_w 483
    //   119: iconst_m1
    //   120: invokevirtual 466	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   123: istore_2
    //   124: iload 4
    //   126: iconst_m1
    //   127: if_icmpeq +12 -> 139
    //   130: aload_0
    //   131: iload 4
    //   133: invokestatic 488	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   136: putfield 70	com/tencent/mobileqq/activity/HongbaoShowerActivity:aNy	Ljava/lang/String;
    //   139: aload_0
    //   140: aload_1
    //   141: ldc_w 490
    //   144: iconst_1
    //   145: invokevirtual 494	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   148: putfield 56	com/tencent/mobileqq/activity/HongbaoShowerActivity:aXt	Z
    //   151: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +125 -> 279
    //   157: ldc 132
    //   159: iconst_1
    //   160: new 286	java/lang/StringBuilder
    //   163: dup
    //   164: sipush 256
    //   167: invokespecial 496	java/lang/StringBuilder:<init>	(I)V
    //   170: iload_3
    //   171: invokevirtual 499	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: ldc_w 501
    //   177: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_0
    //   181: getfield 150	com/tencent/mobileqq/activity/HongbaoShowerActivity:mType	I
    //   184: invokevirtual 499	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: ldc_w 501
    //   190: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_0
    //   194: getfield 295	com/tencent/mobileqq/activity/HongbaoShowerActivity:mJumpUrl	Ljava/lang/String;
    //   197: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc_w 501
    //   203: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_0
    //   207: getfield 70	com/tencent/mobileqq/activity/HongbaoShowerActivity:aNy	Ljava/lang/String;
    //   210: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc_w 501
    //   216: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_0
    //   220: invokevirtual 460	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   223: ldc_w 503
    //   226: iconst_m1
    //   227: invokevirtual 466	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   230: invokevirtual 499	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   233: ldc_w 501
    //   236: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_0
    //   240: invokevirtual 460	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   243: ldc_w 479
    //   246: iconst_m1
    //   247: invokevirtual 466	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   250: invokevirtual 499	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: ldc_w 501
    //   256: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_0
    //   260: invokevirtual 460	com/tencent/mobileqq/activity/HongbaoShowerActivity:getIntent	()Landroid/content/Intent;
    //   263: ldc_w 483
    //   266: iconst_m1
    //   267: invokevirtual 466	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   270: invokevirtual 499	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: iload_3
    //   280: iflt +29 -> 309
    //   283: aload_0
    //   284: getfield 150	com/tencent/mobileqq/activity/HongbaoShowerActivity:mType	I
    //   287: iflt +22 -> 309
    //   290: aload_0
    //   291: getfield 150	com/tencent/mobileqq/activity/HongbaoShowerActivity:mType	I
    //   294: iconst_2
    //   295: if_icmpgt +14 -> 309
    //   298: aload_0
    //   299: getfield 481	com/tencent/mobileqq/activity/HongbaoShowerActivity:bHK	I
    //   302: ifge +35 -> 337
    //   305: iload_2
    //   306: ifge +31 -> 337
    //   309: aload_0
    //   310: invokevirtual 337	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   313: iconst_0
    //   314: ireturn
    //   315: astore_1
    //   316: iconst_m1
    //   317: istore_3
    //   318: iconst_m1
    //   319: istore_2
    //   320: ldc 132
    //   322: iconst_2
    //   323: ldc_w 505
    //   326: aload_1
    //   327: invokestatic 508	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   330: aload_0
    //   331: invokevirtual 337	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   334: goto -183 -> 151
    //   337: aload_0
    //   338: aload_0
    //   339: getfield 111	com/tencent/mobileqq/activity/HongbaoShowerActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   342: bipush 79
    //   344: invokevirtual 441	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   347: checkcast 510	com/tencent/mobileqq/portal/PortalManager
    //   350: aload_0
    //   351: getfield 150	com/tencent/mobileqq/activity/HongbaoShowerActivity:mType	I
    //   354: iload_3
    //   355: aload_0
    //   356: getfield 481	com/tencent/mobileqq/activity/HongbaoShowerActivity:bHK	I
    //   359: iload_2
    //   360: invokevirtual 513	com/tencent/mobileqq/portal/PortalManager:a	(IIII)Lcom/tencent/mobileqq/portal/PortalManager$d;
    //   363: putfield 515	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$d	Lcom/tencent/mobileqq/portal/PortalManager$d;
    //   366: aload_0
    //   367: getfield 515	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$d	Lcom/tencent/mobileqq/portal/PortalManager$d;
    //   370: ifnonnull +9 -> 379
    //   373: aload_0
    //   374: invokevirtual 337	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   377: iconst_0
    //   378: ireturn
    //   379: aload_0
    //   380: aload_0
    //   381: getfield 515	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$d	Lcom/tencent/mobileqq/portal/PortalManager$d;
    //   384: getfield 520	com/tencent/mobileqq/portal/PortalManager$d:bVa	Ljava/lang/String;
    //   387: putfield 95	com/tencent/mobileqq/activity/HongbaoShowerActivity:businessName	Ljava/lang/String;
    //   390: aload_0
    //   391: aload_0
    //   392: getfield 515	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$d	Lcom/tencent/mobileqq/portal/PortalManager$d;
    //   395: getfield 522	com/tencent/mobileqq/portal/PortalManager$d:aNx	Ljava/lang/String;
    //   398: putfield 523	com/tencent/mobileqq/activity/HongbaoShowerActivity:aNx	Ljava/lang/String;
    //   401: aload_0
    //   402: aload_0
    //   403: getfield 515	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$d	Lcom/tencent/mobileqq/portal/PortalManager$d;
    //   406: getfield 526	com/tencent/mobileqq/portal/PortalManager$d:fJ	Landroid/graphics/Bitmap;
    //   409: putfield 528	com/tencent/mobileqq/activity/HongbaoShowerActivity:dp	Landroid/graphics/Bitmap;
    //   412: aload_0
    //   413: aload_0
    //   414: getfield 515	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$d	Lcom/tencent/mobileqq/portal/PortalManager$d;
    //   417: getfield 531	com/tencent/mobileqq/portal/PortalManager$d:bUY	Ljava/lang/String;
    //   420: putfield 81	com/tencent/mobileqq/activity/HongbaoShowerActivity:aNz	Ljava/lang/String;
    //   423: aload_0
    //   424: aload_0
    //   425: getfield 515	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$d	Lcom/tencent/mobileqq/portal/PortalManager$d;
    //   428: getfield 534	com/tencent/mobileqq/portal/PortalManager$d:bUZ	Ljava/lang/String;
    //   431: putfield 85	com/tencent/mobileqq/activity/HongbaoShowerActivity:aNA	Ljava/lang/String;
    //   434: aload_0
    //   435: aload_0
    //   436: getfield 515	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$d	Lcom/tencent/mobileqq/portal/PortalManager$d;
    //   439: getfield 536	com/tencent/mobileqq/portal/PortalManager$d:wishing	Ljava/lang/String;
    //   442: putfield 91	com/tencent/mobileqq/activity/HongbaoShowerActivity:aNB	Ljava/lang/String;
    //   445: aload_0
    //   446: aload_0
    //   447: getfield 515	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$d	Lcom/tencent/mobileqq/portal/PortalManager$d;
    //   450: getfield 539	com/tencent/mobileqq/portal/PortalManager$d:awT	Ljava/lang/String;
    //   453: putfield 329	com/tencent/mobileqq/activity/HongbaoShowerActivity:aNw	Ljava/lang/String;
    //   456: aload_0
    //   457: getfield 515	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$d	Lcom/tencent/mobileqq/portal/PortalManager$d;
    //   460: getfield 542	com/tencent/mobileqq/portal/PortalManager$d:dqA	I
    //   463: tableswitch	default:+21 -> 484, 1:+703->1166, 2:+696->1159
    //   485: iconst_1
    //   486: putfield 58	com/tencent/mobileqq/activity/HongbaoShowerActivity:aXu	Z
    //   489: ldc_w 543
    //   492: istore_2
    //   493: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   496: ifeq +35 -> 531
    //   499: ldc 132
    //   501: iconst_1
    //   502: new 286	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   509: ldc_w 545
    //   512: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: aload_0
    //   516: getfield 515	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$d	Lcom/tencent/mobileqq/portal/PortalManager$d;
    //   519: getfield 542	com/tencent/mobileqq/portal/PortalManager$d:dqA	I
    //   522: invokevirtual 499	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   525: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   531: iload_2
    //   532: ifeq -502 -> 30
    //   535: aload_0
    //   536: iload_2
    //   537: invokespecial 548	com/tencent/mobileqq/app/BaseActivity:setContentView	(I)V
    //   540: aload_0
    //   541: aload_0
    //   542: ldc_w 549
    //   545: invokevirtual 189	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   548: checkcast 191	android/widget/RelativeLayout
    //   551: putfield 272	com/tencent/mobileqq/activity/HongbaoShowerActivity:gG	Landroid/widget/RelativeLayout;
    //   554: aload_0
    //   555: getfield 272	com/tencent/mobileqq/activity/HongbaoShowerActivity:gG	Landroid/widget/RelativeLayout;
    //   558: aload_0
    //   559: getfield 515	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$d	Lcom/tencent/mobileqq/portal/PortalManager$d;
    //   562: getfield 552	com/tencent/mobileqq/portal/PortalManager$d:tips	Ljava/lang/String;
    //   565: invokevirtual 556	android/widget/RelativeLayout:setContentDescription	(Ljava/lang/CharSequence;)V
    //   568: aload_0
    //   569: getfield 272	com/tencent/mobileqq/activity/HongbaoShowerActivity:gG	Landroid/widget/RelativeLayout;
    //   572: new 558	vdr
    //   575: dup
    //   576: aload_0
    //   577: invokespecial 559	vdr:<init>	(Lcom/tencent/mobileqq/activity/HongbaoShowerActivity;)V
    //   580: invokevirtual 563	android/widget/RelativeLayout:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   583: aload_0
    //   584: aload_0
    //   585: ldc_w 564
    //   588: invokevirtual 189	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   591: checkcast 566	android/widget/TextView
    //   594: putfield 568	com/tencent/mobileqq/activity/HongbaoShowerActivity:DH	Landroid/widget/TextView;
    //   597: aload_0
    //   598: getfield 568	com/tencent/mobileqq/activity/HongbaoShowerActivity:DH	Landroid/widget/TextView;
    //   601: aload_0
    //   602: getfield 95	com/tencent/mobileqq/activity/HongbaoShowerActivity:businessName	Ljava/lang/String;
    //   605: invokevirtual 571	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   608: aload_0
    //   609: aload_0
    //   610: ldc_w 572
    //   613: invokevirtual 189	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   616: checkcast 566	android/widget/TextView
    //   619: putfield 574	com/tencent/mobileqq/activity/HongbaoShowerActivity:DJ	Landroid/widget/TextView;
    //   622: aload_0
    //   623: getfield 574	com/tencent/mobileqq/activity/HongbaoShowerActivity:DJ	Landroid/widget/TextView;
    //   626: astore 7
    //   628: aload_0
    //   629: getfield 150	com/tencent/mobileqq/activity/HongbaoShowerActivity:mType	I
    //   632: ifne +552 -> 1184
    //   635: ldc_w 575
    //   638: invokestatic 309	acfp:m	(I)Ljava/lang/String;
    //   641: astore_1
    //   642: aload 7
    //   644: aload_1
    //   645: invokevirtual 571	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   648: aload_0
    //   649: getfield 574	com/tencent/mobileqq/activity/HongbaoShowerActivity:DJ	Landroid/widget/TextView;
    //   652: new 577	vds
    //   655: dup
    //   656: aload_0
    //   657: invokespecial 578	vds:<init>	(Lcom/tencent/mobileqq/activity/HongbaoShowerActivity;)V
    //   660: invokevirtual 582	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   663: aload_0
    //   664: ldc_w 583
    //   667: invokevirtual 189	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   670: checkcast 566	android/widget/TextView
    //   673: astore 7
    //   675: aload_0
    //   676: getfield 150	com/tencent/mobileqq/activity/HongbaoShowerActivity:mType	I
    //   679: ifne +515 -> 1194
    //   682: ldc_w 584
    //   685: invokestatic 309	acfp:m	(I)Ljava/lang/String;
    //   688: astore_1
    //   689: aload 7
    //   691: aload_1
    //   692: invokevirtual 571	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   695: aload_0
    //   696: getfield 150	com/tencent/mobileqq/activity/HongbaoShowerActivity:mType	I
    //   699: ifeq +11 -> 710
    //   702: aload_0
    //   703: getfield 150	com/tencent/mobileqq/activity/HongbaoShowerActivity:mType	I
    //   706: iconst_1
    //   707: if_icmpne +115 -> 822
    //   710: aload_0
    //   711: getfield 515	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$d	Lcom/tencent/mobileqq/portal/PortalManager$d;
    //   714: getfield 587	com/tencent/mobileqq/portal/PortalManager$d:dqP	I
    //   717: iconst_1
    //   718: if_icmpne +104 -> 822
    //   721: aload_0
    //   722: getfield 523	com/tencent/mobileqq/activity/HongbaoShowerActivity:aNx	Ljava/lang/String;
    //   725: invokestatic 593	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   728: ifne +94 -> 822
    //   731: aload_0
    //   732: ldc_w 594
    //   735: invokevirtual 189	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   738: iconst_0
    //   739: invokevirtual 597	android/view/View:setVisibility	(I)V
    //   742: aload_0
    //   743: aload_0
    //   744: ldc_w 598
    //   747: invokevirtual 189	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   750: checkcast 566	android/widget/TextView
    //   753: putfield 600	com/tencent/mobileqq/activity/HongbaoShowerActivity:DI	Landroid/widget/TextView;
    //   756: aload_0
    //   757: getfield 600	com/tencent/mobileqq/activity/HongbaoShowerActivity:DI	Landroid/widget/TextView;
    //   760: aload_0
    //   761: getfield 523	com/tencent/mobileqq/activity/HongbaoShowerActivity:aNx	Ljava/lang/String;
    //   764: invokevirtual 571	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   767: aload_0
    //   768: aload_0
    //   769: ldc_w 601
    //   772: invokevirtual 189	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   775: checkcast 320	android/widget/CheckBox
    //   778: putfield 156	com/tencent/mobileqq/activity/HongbaoShowerActivity:q	Landroid/widget/CheckBox;
    //   781: aload_0
    //   782: getfield 56	com/tencent/mobileqq/activity/HongbaoShowerActivity:aXt	Z
    //   785: ifne +11 -> 796
    //   788: aload_0
    //   789: getfield 156	com/tencent/mobileqq/activity/HongbaoShowerActivity:q	Landroid/widget/CheckBox;
    //   792: iconst_0
    //   793: invokevirtual 604	android/widget/CheckBox:setChecked	(Z)V
    //   796: aload_0
    //   797: aload_0
    //   798: ldc_w 605
    //   801: invokevirtual 189	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   804: putfield 607	com/tencent/mobileqq/activity/HongbaoShowerActivity:tr	Landroid/view/View;
    //   807: aload_0
    //   808: getfield 607	com/tencent/mobileqq/activity/HongbaoShowerActivity:tr	Landroid/view/View;
    //   811: new 609	vdt
    //   814: dup
    //   815: aload_0
    //   816: invokespecial 610	vdt:<init>	(Lcom/tencent/mobileqq/activity/HongbaoShowerActivity;)V
    //   819: invokevirtual 611	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   822: aload_0
    //   823: ldc_w 612
    //   826: invokevirtual 189	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   829: astore_1
    //   830: aload_1
    //   831: ifnull +18 -> 849
    //   834: aload_0
    //   835: getfield 150	com/tencent/mobileqq/activity/HongbaoShowerActivity:mType	I
    //   838: iconst_1
    //   839: if_icmpne +365 -> 1204
    //   842: iconst_0
    //   843: istore_2
    //   844: aload_1
    //   845: iload_2
    //   846: invokevirtual 597	android/view/View:setVisibility	(I)V
    //   849: aload_0
    //   850: invokestatic 618	java/lang/System:currentTimeMillis	()J
    //   853: putfield 54	com/tencent/mobileqq/activity/HongbaoShowerActivity:mCreateTime	J
    //   856: aload_0
    //   857: aload_0
    //   858: ldc_w 619
    //   861: invokevirtual 189	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   864: checkcast 566	android/widget/TextView
    //   867: putfield 621	com/tencent/mobileqq/activity/HongbaoShowerActivity:DG	Landroid/widget/TextView;
    //   870: aload_0
    //   871: getfield 621	com/tencent/mobileqq/activity/HongbaoShowerActivity:DG	Landroid/widget/TextView;
    //   874: new 623	vdu
    //   877: dup
    //   878: aload_0
    //   879: invokespecial 624	vdu:<init>	(Lcom/tencent/mobileqq/activity/HongbaoShowerActivity;)V
    //   882: invokevirtual 582	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   885: aload_0
    //   886: getfield 515	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$d	Lcom/tencent/mobileqq/portal/PortalManager$d;
    //   889: getfield 542	com/tencent/mobileqq/portal/PortalManager$d:dqA	I
    //   892: iconst_2
    //   893: if_icmpne +348 -> 1241
    //   896: aload_0
    //   897: ldc_w 625
    //   900: invokevirtual 189	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   903: checkcast 170	android/widget/ImageView
    //   906: astore 7
    //   908: aload 7
    //   910: ifnull +86 -> 996
    //   913: ldc_w 626
    //   916: invokestatic 628	com/tencent/mobileqq/activity/HongbaoShowerActivity:ct	(I)Ljava/lang/String;
    //   919: invokestatic 632	com/tencent/mobileqq/portal/PortalManager:getBitmapFromCache	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   922: astore_1
    //   923: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   926: ifeq +41 -> 967
    //   929: new 286	java/lang/StringBuilder
    //   932: dup
    //   933: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   936: ldc_w 634
    //   939: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: astore 8
    //   944: aload_1
    //   945: ifnull +265 -> 1210
    //   948: iconst_1
    //   949: istore 5
    //   951: ldc 132
    //   953: iconst_2
    //   954: aload 8
    //   956: iload 5
    //   958: invokevirtual 637	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   961: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   964: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   967: aload_1
    //   968: ifnonnull +450 -> 1418
    //   971: ldc_w 626
    //   974: invokestatic 628	com/tencent/mobileqq/activity/HongbaoShowerActivity:ct	(I)Ljava/lang/String;
    //   977: ldc_w 626
    //   980: invokestatic 641	com/tencent/mobileqq/portal/PortalManager:k	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   983: astore_1
    //   984: aload_1
    //   985: ifnonnull +231 -> 1216
    //   988: aload 7
    //   990: ldc_w 626
    //   993: invokevirtual 644	android/widget/ImageView:setImageResource	(I)V
    //   996: aload_0
    //   997: ldc 185
    //   999: invokevirtual 189	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   1002: checkcast 191	android/widget/RelativeLayout
    //   1005: astore 8
    //   1007: aload 8
    //   1009: ifnull +94 -> 1103
    //   1012: ldc_w 645
    //   1015: invokestatic 628	com/tencent/mobileqq/activity/HongbaoShowerActivity:ct	(I)Ljava/lang/String;
    //   1018: invokestatic 632	com/tencent/mobileqq/portal/PortalManager:getBitmapFromCache	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1021: astore 7
    //   1023: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1026: ifeq +44 -> 1070
    //   1029: new 286	java/lang/StringBuilder
    //   1032: dup
    //   1033: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   1036: ldc_w 647
    //   1039: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: astore_1
    //   1043: iload 6
    //   1045: istore 5
    //   1047: aload 7
    //   1049: ifnull +6 -> 1055
    //   1052: iconst_1
    //   1053: istore 5
    //   1055: ldc 132
    //   1057: iconst_2
    //   1058: aload_1
    //   1059: iload 5
    //   1061: invokevirtual 637	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1064: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1067: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1070: aload 7
    //   1072: astore_1
    //   1073: aload 7
    //   1075: ifnonnull +16 -> 1091
    //   1078: ldc_w 645
    //   1081: invokestatic 628	com/tencent/mobileqq/activity/HongbaoShowerActivity:ct	(I)Ljava/lang/String;
    //   1084: ldc_w 645
    //   1087: invokestatic 641	com/tencent/mobileqq/portal/PortalManager:k	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   1090: astore_1
    //   1091: aload_1
    //   1092: ifnonnull +133 -> 1225
    //   1095: aload 8
    //   1097: ldc_w 645
    //   1100: invokevirtual 650	android/widget/RelativeLayout:setBackgroundResource	(I)V
    //   1103: aload_0
    //   1104: aload_0
    //   1105: ldc_w 651
    //   1108: invokevirtual 189	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   1111: checkcast 170	android/widget/ImageView
    //   1114: putfield 653	com/tencent/mobileqq/activity/HongbaoShowerActivity:qg	Landroid/widget/ImageView;
    //   1117: aload_0
    //   1118: getfield 653	com/tencent/mobileqq/activity/HongbaoShowerActivity:qg	Landroid/widget/ImageView;
    //   1121: ifnull +28 -> 1149
    //   1124: aload_0
    //   1125: getfield 528	com/tencent/mobileqq/activity/HongbaoShowerActivity:dp	Landroid/graphics/Bitmap;
    //   1128: ifnull +21 -> 1149
    //   1131: aload_0
    //   1132: getfield 653	com/tencent/mobileqq/activity/HongbaoShowerActivity:qg	Landroid/widget/ImageView;
    //   1135: new 165	android/graphics/drawable/BitmapDrawable
    //   1138: dup
    //   1139: aload_0
    //   1140: getfield 528	com/tencent/mobileqq/activity/HongbaoShowerActivity:dp	Landroid/graphics/Bitmap;
    //   1143: invokespecial 168	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   1146: invokevirtual 656	android/widget/ImageView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1149: aload_0
    //   1150: invokespecial 658	com/tencent/mobileqq/activity/HongbaoShowerActivity:bPL	()V
    //   1153: aload_0
    //   1154: invokespecial 660	com/tencent/mobileqq/activity/HongbaoShowerActivity:bPN	()V
    //   1157: iconst_1
    //   1158: ireturn
    //   1159: ldc_w 661
    //   1162: istore_2
    //   1163: goto -670 -> 493
    //   1166: ldc_w 543
    //   1169: istore_2
    //   1170: goto -677 -> 493
    //   1173: astore_1
    //   1174: aload_1
    //   1175: invokevirtual 662	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1178: aload_0
    //   1179: invokevirtual 337	com/tencent/mobileqq/activity/HongbaoShowerActivity:finish	()V
    //   1182: iconst_0
    //   1183: ireturn
    //   1184: ldc_w 663
    //   1187: invokestatic 309	acfp:m	(I)Ljava/lang/String;
    //   1190: astore_1
    //   1191: goto -549 -> 642
    //   1194: ldc_w 664
    //   1197: invokestatic 309	acfp:m	(I)Ljava/lang/String;
    //   1200: astore_1
    //   1201: goto -512 -> 689
    //   1204: bipush 8
    //   1206: istore_2
    //   1207: goto -363 -> 844
    //   1210: iconst_0
    //   1211: istore 5
    //   1213: goto -262 -> 951
    //   1216: aload 7
    //   1218: aload_1
    //   1219: invokevirtual 667	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   1222: goto -226 -> 996
    //   1225: aload 8
    //   1227: new 165	android/graphics/drawable/BitmapDrawable
    //   1230: dup
    //   1231: aload_1
    //   1232: invokespecial 168	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   1235: invokevirtual 668	android/widget/RelativeLayout:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1238: goto -135 -> 1103
    //   1241: aload_0
    //   1242: getfield 515	com/tencent/mobileqq/activity/HongbaoShowerActivity:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$d	Lcom/tencent/mobileqq/portal/PortalManager$d;
    //   1245: getfield 542	com/tencent/mobileqq/portal/PortalManager$d:dqA	I
    //   1248: iconst_1
    //   1249: if_icmpne -100 -> 1149
    //   1252: aload_0
    //   1253: ldc_w 625
    //   1256: invokevirtual 189	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   1259: checkcast 170	android/widget/ImageView
    //   1262: astore 8
    //   1264: aload 8
    //   1266: ifnull +90 -> 1356
    //   1269: ldc_w 669
    //   1272: invokestatic 628	com/tencent/mobileqq/activity/HongbaoShowerActivity:ct	(I)Ljava/lang/String;
    //   1275: invokestatic 632	com/tencent/mobileqq/portal/PortalManager:getBitmapFromCache	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1278: astore 7
    //   1280: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1283: ifeq +40 -> 1323
    //   1286: new 286	java/lang/StringBuilder
    //   1289: dup
    //   1290: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   1293: ldc_w 671
    //   1296: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: astore_1
    //   1300: aload 7
    //   1302: ifnull +6 -> 1308
    //   1305: iconst_1
    //   1306: istore 5
    //   1308: ldc 132
    //   1310: iconst_2
    //   1311: aload_1
    //   1312: iload 5
    //   1314: invokevirtual 637	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1317: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1320: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1323: aload 7
    //   1325: astore_1
    //   1326: aload 7
    //   1328: ifnonnull +16 -> 1344
    //   1331: ldc_w 669
    //   1334: invokestatic 628	com/tencent/mobileqq/activity/HongbaoShowerActivity:ct	(I)Ljava/lang/String;
    //   1337: ldc_w 669
    //   1340: invokestatic 641	com/tencent/mobileqq/portal/PortalManager:k	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   1343: astore_1
    //   1344: aload_1
    //   1345: ifnonnull +54 -> 1399
    //   1348: aload 8
    //   1350: ldc_w 669
    //   1353: invokevirtual 644	android/widget/ImageView:setImageResource	(I)V
    //   1356: aload_0
    //   1357: aload_0
    //   1358: ldc_w 672
    //   1361: invokevirtual 189	com/tencent/mobileqq/activity/HongbaoShowerActivity:findViewById	(I)Landroid/view/View;
    //   1364: checkcast 170	android/widget/ImageView
    //   1367: putfield 674	com/tencent/mobileqq/activity/HongbaoShowerActivity:qf	Landroid/widget/ImageView;
    //   1370: aload_0
    //   1371: getfield 674	com/tencent/mobileqq/activity/HongbaoShowerActivity:qf	Landroid/widget/ImageView;
    //   1374: ifnull -225 -> 1149
    //   1377: aload_0
    //   1378: getfield 528	com/tencent/mobileqq/activity/HongbaoShowerActivity:dp	Landroid/graphics/Bitmap;
    //   1381: ifnull -232 -> 1149
    //   1384: aload_0
    //   1385: aload_0
    //   1386: getfield 674	com/tencent/mobileqq/activity/HongbaoShowerActivity:qf	Landroid/widget/ImageView;
    //   1389: aload_0
    //   1390: getfield 528	com/tencent/mobileqq/activity/HongbaoShowerActivity:dp	Landroid/graphics/Bitmap;
    //   1393: invokespecial 676	com/tencent/mobileqq/activity/HongbaoShowerActivity:a	(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)V
    //   1396: goto -247 -> 1149
    //   1399: aload 8
    //   1401: aload_1
    //   1402: invokevirtual 667	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   1405: goto -49 -> 1356
    //   1408: astore_1
    //   1409: iconst_m1
    //   1410: istore_2
    //   1411: goto -1091 -> 320
    //   1414: astore_1
    //   1415: goto -1095 -> 320
    //   1418: goto -434 -> 984
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1421	0	this	HongbaoShowerActivity
    //   0	1421	1	paramBundle	Bundle
    //   123	1288	2	i	int
    //   69	286	3	j	int
    //   95	37	4	k	int
    //   1	1312	5	bool1	boolean
    //   4	1040	6	bool2	boolean
    //   626	701	7	localObject1	Object
    //   942	458	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   32	70	315	java/lang/Exception
    //   535	540	1173	java/lang/OutOfMemoryError
    //   70	124	1408	java/lang/Exception
    //   130	139	1414	java/lang/Exception
    //   139	151	1414	java/lang/Exception
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
  }
  
  public class a
    extends OvershootInterpolator
  {
    private boolean aXv;
    
    public a() {}
    
    public float getInterpolation(float paramFloat)
    {
      if ((!this.aXv) && (paramFloat > 0.7D))
      {
        this.aXv = true;
        HongbaoShowerActivity.this.ts.setBackgroundColor(-16777216);
        HongbaoShowerActivity.this.ts.startAnimation(HongbaoShowerActivity.this.n);
        HongbaoShowerActivity.a(HongbaoShowerActivity.this).startAnimation();
      }
      return (float)(1.0D - Math.pow(2.718281828459045D, 5.0F * -paramFloat) * Math.cos(8.0F * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HongbaoShowerActivity
 * JD-Core Version:    0.7.0.1
 */