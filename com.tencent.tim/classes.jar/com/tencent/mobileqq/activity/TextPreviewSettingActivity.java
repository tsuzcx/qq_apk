package com.tencent.mobileqq.activity;

import abgl;
import acff;
import acfp;
import acle;
import adxm;
import adxn;
import adxp;
import adyd;
import adye;
import ahxr;
import ahxs;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import anec;
import aqdj;
import aqgm;
import aqqj;
import aquy;
import aquz;
import aqva;
import aqvc;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.addon.DiyPendantEntity;
import com.tencent.mobileqq.addon.DiyPendantSticker;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jpa;
import jqo;
import ku;
import vxh;
import vxi;

public class TextPreviewSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private ku a;
  private String aQm;
  private int bLf;
  private int bLg;
  private int bLh;
  private int bLi;
  ExtensionInfo c = null;
  aquy d = new vxi(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  private int mFontId;
  private int mFontType;
  private Handler mHandler;
  private View vg;
  private View vh;
  private View vi;
  private View vj;
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface, aquy paramaquy)
  {
    File localFile = new File(ku.dV + File.separatorChar + paramInt + File.separatorChar + "fontname.png");
    Object localObject2 = aqqj.getUrl("fontAioImg");
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ((String)localObject2).replace("[id]", Integer.toString(paramInt));
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("TextPreviewSettingActivity", 2, "getFontInfo fontId=" + paramInt + " will down ,file path=" + localFile.getAbsolutePath());
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("font_id", paramInt);
    localObject1 = new aquz((String)localObject1, localFile);
    ((aqva)paramQQAppInterface.getManager(47)).a(1).a((aquz)localObject1, paramaquy, (Bundle)localObject2);
  }
  
  private void aDZ()
  {
    Intent localIntent = getIntent();
    this.bLf = localIntent.getIntExtra("bubbleId", 0);
    this.bLg = localIntent.getIntExtra("bubbleDiyId", 0);
    if (this.bLg == 0) {
      this.bLg = acle.R(localIntent.getLongExtra("bubbleId", 0L));
    }
    this.bLh = localIntent.getIntExtra("HiBoomId", 0);
    this.mFontId = localIntent.getIntExtra("fontId", 0);
    this.bLi = localIntent.getIntExtra("fontEffectId", 0);
    this.aQm = localIntent.getStringExtra("real_msg_sender_uin");
    this.bLi = localIntent.getIntExtra("fontEffectId", 0);
  }
  
  private void bVZ()
  {
    Object localObject3 = (BubbleManager)this.app.getManager(44);
    Object localObject2 = ((BubbleManager)localObject3).a(this.bLf, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = adyd.c;
    }
    boolean bool;
    Object localObject4;
    if ((this.aQm != null) && (!this.aQm.equals(this.app.getAccount())))
    {
      bool = false;
      localObject2 = (TextView)findViewById(2131364058);
      if ((this.bLg <= 0) || (localObject1 == adyd.c)) {
        break label416;
      }
      localObject4 = (HashMap)adxn.a().eO.get(Integer.valueOf(this.bLf));
      if ((localObject4 != null) && (((HashMap)localObject4).size() > 0))
      {
        localObject4 = ((HashMap)localObject4).values().iterator();
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
        } while (!((adye)((Iterator)localObject4).next()).type.equalsIgnoreCase("static"));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject4 = (TextView)super.findViewById(2131364053);
        if (localObject4 != null) {
          ((TextView)localObject4).setText(getResources().getText(2131690238));
        }
      }
      ((adxp)localObject1).a(this.app, bool, true, false, (View)localObject2, this.aQm, this.bLg);
      label227:
      localObject3 = ((BubbleManager)localObject3).a(((adxp)localObject1).bubbleId, true);
      localObject2 = acfp.m(2131715265);
      if (bool)
      {
        i = Color.parseColor("#FFFFFF");
        label258:
        localObject1 = new File(((adxp)localObject1).bvW);
        if ((localObject3 == null) || (!((File)localObject1).exists())) {
          break label558;
        }
        localObject1 = ((adxm)localObject3).name;
        i = ((adxm)localObject3).fontColor;
      }
      for (;;)
      {
        localObject2 = (TextView)findViewById(2131364054);
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setTextColor(i);
        this.a = ((ku)this.app.getManager(42));
        if (this.a != null) {}
        for (bool = this.a.cy;; bool = false)
        {
          localObject1 = (ImageView)findViewById(2131367444);
          if (this.bLh > 0)
          {
            localObject2 = (ahxs)this.app.getManager(219);
            localObject3 = ((ahxs)localObject2).a(this.bLh);
            if (((ahxr)localObject3).fm != null) {
              ((ImageView)localObject1).setImageBitmap(((ahxr)localObject3).fm);
            }
          }
          label416:
          while (!bool)
          {
            return;
            bool = true;
            break;
            ((adxp)localObject1).a(this.app, bool, true, false, (View)localObject2, false);
            break label227;
            i = Color.parseColor("#808080");
            break label258;
            ThreadManagerV2.excute(new TextPreviewSettingActivity.3(this, (ahxs)localObject2), 64, null, true);
            return;
          }
          if (this.mFontId == -1)
          {
            if (this.c == null) {
              break label545;
            }
            this.mFontId = ((int)this.c.uVipFont);
            this.mFontType = this.c.vipFontType;
          }
          for (;;)
          {
            localObject2 = getResources().getDrawable(2130847933);
            if (this.mFontId != 0) {
              ThreadManager.post(new TextPreviewSettingActivity.4(this), 8, null, true);
            }
            ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
            return;
            label545:
            this.mFontId = 0;
          }
        }
        label558:
        localObject1 = localObject2;
      }
    }
  }
  
  private void bWd()
  {
    Object localObject1 = (anec)this.app.getManager(12);
    int i;
    if (localObject1 != null) {
      if (((anec)localObject1).ee("100005.100006") != -1) {
        i = 1;
      }
    }
    for (;;)
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("hide_left_button", false);
      localIntent.putExtra("show_right_close_button", false);
      long l;
      label94:
      String str;
      Object localObject3;
      label160:
      label204:
      DiyPendantSticker localDiyPendantSticker;
      int j;
      int k;
      int m;
      label261:
      int n;
      if (this.c != null)
      {
        l = this.c.pendantId;
        str = aqqj.e(this, "pendantDetail", String.valueOf(l), "mvip.gexinghua.mobile.faceaddon.client_tab_store");
        localObject2 = abgl.a().g;
        localObject3 = new StringBuilder().append(this.aQm).append("_");
        if (this.c == null) {
          break label369;
        }
        localObject1 = Integer.valueOf(this.c.pendantDiyId);
        localObject1 = (DiyPendantEntity)((LRULinkedHashMap)localObject2).get(localObject1);
        if (localObject1 == null) {
          break label554;
        }
        localObject3 = new ArrayList();
        Iterator localIterator = ((DiyPendantEntity)localObject1).getStickerInfoList().iterator();
        if (!localIterator.hasNext()) {
          break label397;
        }
        localDiyPendantSticker = (DiyPendantSticker)localIterator.next();
        j = localDiyPendantSticker.type;
        k = localDiyPendantSticker.stickerId;
        m = localDiyPendantSticker.angle;
        if (!TextUtils.isEmpty(localDiyPendantSticker.text)) {
          break label377;
        }
        localObject1 = "0";
        n = localDiyPendantSticker.fontId;
        if (!TextUtils.isEmpty(localDiyPendantSticker.fontColor)) {
          break label387;
        }
      }
      label387:
      for (Object localObject2 = "0";; localObject2 = localDiyPendantSticker.fontColor)
      {
        ((List)localObject3).add(String.format("%d,%d,%d,%s,%d,%s,%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), localObject1, Integer.valueOf(n), localObject2, Integer.valueOf(localDiyPendantSticker.fontType) }));
        break label204;
        i = 0;
        break;
        l = 0L;
        break label94;
        label369:
        localObject1 = "";
        break label160;
        label377:
        localObject1 = localDiyPendantSticker.text;
        break label261;
      }
      label397:
      localObject1 = TextUtils.join(";", (Iterable)localObject3);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = URLEncoder.encode((String)localObject1);
      }
      label554:
      for (localObject1 = jpa.r(str, "stickerInfo=" + (String)localObject1);; localObject1 = str)
      {
        localIntent.putExtra("url", (String)localObject1);
        localIntent.putExtra("business", 512L);
        localIntent.putExtra("individuation_url_type", 40301);
        localIntent.putExtra("isShowAd", false);
        VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject1, 512L, localIntent, false, -1);
        localObject1 = this.aQm;
        if (i != 0) {}
        for (i = 1;; i = 0)
        {
          VasWebviewUtil.reportCommercialDrainage((String)localObject1, "bigtextpage", "pendant_enter", "", 1, 0, i, "", String.valueOf(l), "");
          return;
        }
      }
      i = 0;
    }
  }
  
  private void bWe()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    Object localObject1 = (anec)this.app.getManager(12);
    boolean bool;
    if (localObject1 != null) {
      if (((anec)localObject1).ee("100005.100003") != -1) {
        bool = true;
      }
    }
    for (;;)
    {
      localIntent.putExtra("updateFlag", bool);
      localIntent.putExtra("scrollToBubble", true);
      localIntent.putExtra("individuation_url_type", 40301);
      Object localObject2 = aqqj.e(this, "bubbleDetail", String.valueOf(this.bLf), "mvip.gongneng.android.bubble.index_dynamic_tab");
      localObject1 = adxn.a();
      Object localObject4 = this.aQm + "_" + this.bLg;
      Object localObject3 = localObject2;
      String str;
      if (this.bLg > 0)
      {
        str = (String)((adxn)localObject1).jM.get(localObject4);
        localObject4 = (HashMap)((adxn)localObject1).jN.get(localObject4);
        localObject1 = localObject2;
        if (localObject4 != null)
        {
          localObject1 = localObject2;
          if (((HashMap)localObject4).size() > 0)
          {
            localObject3 = (String)((HashMap)localObject4).get("TL");
            localObject1 = localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              localObject1 = jpa.r((String)localObject2, "tl=" + (String)localObject3);
            }
            localObject3 = (String)((HashMap)localObject4).get("TR");
            localObject2 = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              localObject2 = jpa.r((String)localObject1, "tr=" + (String)localObject3);
            }
            localObject1 = (String)((HashMap)localObject4).get("BL");
            localObject3 = localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject3 = jpa.r((String)localObject2, "bl=" + (String)localObject1);
            }
            localObject2 = (String)((HashMap)localObject4).get("BR");
            localObject1 = localObject3;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = jpa.r((String)localObject3, "br=" + (String)localObject2);
            }
          }
        }
        localObject3 = localObject1;
        if (TextUtils.isEmpty(str)) {}
      }
      for (;;)
      {
        try
        {
          localObject2 = jpa.r((String)localObject1, "diyText=" + URLEncoder.encode(str, "UTF-8"));
          localObject1 = localObject2;
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.i("TextPreviewSettingActivity", 2, "TextPreviewActivity bubble url: " + jqo.filterKeyForLog((String)localObject1, new String[0]));
          }
          VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject1, 64L, localIntent, false, -1);
          localObject1 = this.aQm;
          if (!bool) {
            break label561;
          }
          i = 1;
          VasWebviewUtil.reportCommercialDrainage((String)localObject1, "bigtextpage", "bubble_enter", "", 1, 0, i, "", String.valueOf(this.bLf), "");
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          com.tencent.qphone.base.util.QLog.e("TextPreviewSettingActivity", 1, "URLEncoder.encode error!", localUnsupportedEncodingException);
          localObject3 = localObject1;
        }
        bool = false;
        break;
        localObject1 = localObject3;
        continue;
        label561:
        int i = 0;
      }
      bool = false;
    }
  }
  
  private void bWf()
  {
    if (this.bLh > 0)
    {
      localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("fontId", this.bLh);
      ((Intent)localObject).putExtra("fromAIO", true);
      ((Intent)localObject).putExtra("individuation_url_type", 40301);
      VasWebviewUtil.openQQBrowserWithoutAD(this, aqqj.e(this, "fontDetail", String.valueOf(this.bLh), "mvip.gexinghua.mobile.font.client_tab_store"), 4096L, (Intent)localObject, false, -1);
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "HighFont", "ClickDetail", "", 1, 0, 0, "", "" + this.bLh, "");
      return;
    }
    Object localObject = (anec)this.app.getManager(12);
    boolean bool;
    if (localObject != null) {
      if (((anec)localObject).ee("100005.100011") != -1) {
        bool = true;
      }
    }
    for (;;)
    {
      localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("updateFlag", bool);
      ((Intent)localObject).putExtra("fontId", this.mFontId);
      ((Intent)localObject).putExtra("fromAIO", true);
      ((Intent)localObject).putExtra("individuation_url_type", 40301);
      VasWebviewUtil.openQQBrowserWithoutAD(this, aqqj.e(this, "fontDetail", String.valueOf(this.mFontId), "mvip.gexinghua.mobile.font.client_tab_store"), 4096L, (Intent)localObject, false, -1);
      localObject = this.aQm;
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        VasWebviewUtil.reportCommercialDrainage((String)localObject, "bigtextpage", "font_enter", "", 1, 0, i, "", String.valueOf(this.mFontId), "");
        return;
        bool = false;
        break;
      }
      bool = false;
    }
  }
  
  private void bWg()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("individuation_url_type", 40301);
    String str2;
    String str1;
    if (this.bLi == 0)
    {
      str2 = aqqj.o(this, "aioNoMagicFontEntrance", null);
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=1027&_wvx=3";
      }
      if (TextUtils.isEmpty(str1)) {
        break label201;
      }
      str1 = str1.replace("[id]", this.bLi + "");
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.i("TextPreviewSettingActivity", 2, "mFontEffectId=" + this.bLi + " url=" + str1);
      }
      VasWebviewUtil.openQQBrowserWithoutAD(this, str1, 0L, localIntent, false, -1);
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage(this.aQm, "bigtextpage", "font_size", "", 1, 0, 0, "", String.valueOf(this.bLi), "");
      return;
      str2 = aqqj.o(this, "aioMagicFontEntrance", null);
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {
        break;
      }
      str1 = "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=16778243&_wvx=3";
      break;
      label201:
      com.tencent.qphone.base.util.QLog.e("TextPreviewSettingActivity", 2, "url is empty.");
    }
  }
  
  private void d(AppInterface paramAppInterface)
  {
    aqdj localaqdj;
    if (paramAppInterface != null)
    {
      localaqdj = aqdj.a(paramAppInterface, 1, 4, this.aQm);
      if ((this.c == null) || (!this.c.isPendantValid())) {
        break label139;
      }
      paramAppInterface = ((AvatarPendantManager)paramAppInterface.getManager(46)).a(this.c.pendantId);
      if (!aqgm.cT(this.c.pendantId)) {
        break label115;
      }
      paramAppInterface = paramAppInterface.a(2, PendantInfo.ebQ, this.aQm, this.c.pendantDiyId);
    }
    for (;;)
    {
      ((ImageView)findViewById(2131368375)).setImageDrawable(localaqdj);
      ((ImageView)findViewById(2131372984)).setImageDrawable(paramAppInterface);
      return;
      label115:
      paramAppInterface = paramAppInterface.a(1, PendantInfo.ebQ, this.aQm, this.c.pendantDiyId);
      continue;
      label139:
      paramAppInterface = null;
    }
  }
  
  void BI(int paramInt)
  {
    Object localObject2 = (ku)this.app.getManager(42);
    int i = paramInt;
    if (paramInt == 0) {
      i = ((ku)localObject2).iG;
    }
    Object localObject1 = getResources().getDrawable(2130848023);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Object localObject3 = getResources().getDrawable(2130848023);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject3);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject3);
    switch (i)
    {
    default: 
      localObject1 = (String)getResources().getText(2131690240);
      localObject1 = getResources().getDrawable(2130848039);
    }
    for (;;)
    {
      ((ImageView)findViewById(2131371066)).setImageDrawable((Drawable)localObject1);
      return;
      localObject3 = ((ku)localObject2).ee;
      try
      {
        localObject2 = URLDrawable.getDrawable(((ku)localObject2).eh, localURLDrawableOptions);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        com.tencent.qphone.base.util.QLog.e("TextPreviewSettingActivity", 1, "font effect exception, " + localException.getMessage());
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      ForwardUtils.a(this.app, paramIntent, this);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558692);
    paramBundle = getAppInterface();
    if (paramBundle == null)
    {
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("TextPreviewSettingActivity", 0, "get AppInterface failed in TextPreviewSettingActivity#doOnCreate");
      }
      return false;
    }
    aDZ();
    this.c = ((acff)paramBundle.getManager(51)).a(this.aQm);
    setTitle(acfp.m(2131715256));
    setContentBackgroundResource(2130838900);
    this.vg = findViewById(2131372963);
    this.vh = findViewById(2131364048);
    this.vi = findViewById(2131367417);
    this.vj = findViewById(2131371064);
    d(paramBundle);
    this.vg.setOnClickListener(this);
    this.vh.setOnClickListener(this);
    this.vi.setOnClickListener(this);
    this.vj.setOnClickListener(this);
    this.mHandler = new vxh(this, Looper.getMainLooper());
    this.a = ((ku)paramBundle.getManager(42));
    BI(this.bLi);
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    bVZ();
    Object localObject = (WebProcessManager)this.app.getManager(13);
    if (localObject != null) {
      ((WebProcessManager)localObject).egu();
    }
    localObject = adxn.a();
    String str = this.aQm + "_" + this.bLg;
    if ((this.bLg > 0) && ((!((adxn)localObject).jM.containsKey(str)) || (!((adxn)localObject).jN.containsKey(str)))) {
      ThreadManager.post(new TextPreviewSettingActivity.2(this, (adxn)localObject, str), 5, null, false);
    }
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
      bWd();
      continue;
      bWe();
      continue;
      bWf();
      continue;
      bWg();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewSettingActivity
 * JD-Core Version:    0.7.0.1
 */