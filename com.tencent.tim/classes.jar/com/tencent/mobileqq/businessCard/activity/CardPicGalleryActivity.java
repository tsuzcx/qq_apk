package com.tencent.mobileqq.businessCard.activity;

import acbn;
import acfp;
import achs;
import acle;
import aclh;
import adld;
import adzg;
import adzh;
import adzi;
import adzj;
import adzk;
import adzl;
import adzm;
import adzn;
import adzo;
import adzp;
import adzq;
import ahgq;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqep;
import aqha;
import aqju;
import aqnm;
import ausj;
import aviz;
import avjg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Gallery;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import wja;

public class CardPicGalleryActivity
  extends BaseActivity
  implements View.OnClickListener
{
  TextView HU;
  long VN;
  Gallery b;
  public boolean bSu;
  public boolean bSv = false;
  private boolean bSw;
  String bwt;
  int cLG;
  ViewGroup dY;
  BaseAdapter f = new adzh(this);
  private aclh g = new adzi(this);
  public int gQ;
  View hY;
  public Drawable mDefaultDrawable;
  String mDesc;
  public int mIndex = -1;
  public int mMode = 1;
  public ImageView qe;
  public ArrayList<String> ve;
  
  private void d(URLDrawable paramURLDrawable, String paramString)
  {
    new adzq(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private void l(URLDrawable paramURLDrawable)
  {
    m(paramURLDrawable);
  }
  
  private void m(URLDrawable paramURLDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        requestPermissions(new adzn(this, paramURLDrawable), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      n(paramURLDrawable);
      return;
    }
    n(paramURLDrawable);
  }
  
  public void Qq()
  {
    if ((this.mMode == 1) && (!this.bSu)) {}
    label15:
    do
    {
      do
      {
        do
        {
          do
          {
            break label15;
            break label15;
            do
            {
              return;
            } while (this.b == null);
            localObject = this.b.getSelectedView();
          } while (localObject == null);
          localObject = ((ImageView)((View)localObject).findViewById(2131364317)).getDrawable();
        } while ((localObject == null) || (!(localObject instanceof URLDrawable)));
        localObject = (URLDrawable)localObject;
      } while ((this.mDefaultDrawable == null) && (((URLDrawable)localObject).getStatus() != 1));
      ausj localausj = ausj.b(this);
      a(localausj);
      localausj.a(new adzl(this, (URLDrawable)localObject, localausj));
      localausj.setOnBottomCancelListener(new adzm(this, localausj));
      localausj.show();
    } while (2 != this.mMode);
    if (this.app != null) {}
    for (Object localObject = this.app.getCurrentAccountUin();; localObject = "")
    {
      VasWebviewUtil.reportCommercialDrainage((String)localObject, "defaultcard", "click_more", "", 1, 0, 0, "", Integer.toString(this.cLG), "");
      return;
    }
  }
  
  String a(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = paramURLDrawable.getFileInLocal();
    if (paramURLDrawable == null) {
      return null;
    }
    return paramURLDrawable.getAbsolutePath();
  }
  
  public void a(int paramInt, URLDrawable paramURLDrawable)
  {
    switch (this.mMode)
    {
    default: 
      return;
    case 1: 
      b(paramInt, paramURLDrawable);
      return;
    }
    c(paramInt, paramURLDrawable);
  }
  
  protected void a(ausj paramausj)
  {
    switch (this.mMode)
    {
    default: 
      return;
    case 1: 
      paramausj.addButton(2131700772);
      if (this.bSw) {
        paramausj.addButton(2131700754, 3);
      }
      paramausj.addCancelButton(2131721058);
      return;
    }
    if ((this.cLG > 0) && (!this.bSv)) {
      paramausj.addButton(2131694766);
    }
    paramausj.addButton(2131694752);
    paramausj.addButton(2131694762);
    paramausj.addButton(2131694750);
    paramausj.addCancelButton(2131721058);
  }
  
  protected void b(int paramInt, URLDrawable paramURLDrawable)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      l(paramURLDrawable);
      return;
    }
    paramURLDrawable = new Intent();
    paramURLDrawable.putExtra("delete_pic", true);
    setResult(-1, paramURLDrawable);
    finish();
  }
  
  protected void c(int paramInt, URLDrawable paramURLDrawable)
  {
    int i;
    if (this.cLG != 0)
    {
      i = paramInt;
      if (!this.bSv) {}
    }
    else
    {
      i = paramInt + 1;
    }
    paramInt = 0;
    switch (i)
    {
    }
    for (;;)
    {
      QQAppInterface localQQAppInterface = this.app;
      if (this.bSv) {}
      for (paramURLDrawable = "1";; paramURLDrawable = "2")
      {
        anot.a(localQQAppInterface, "dc00898", "", "", "0X800A88C", "0X800A88C", paramInt, 0, paramURLDrawable, "", "", "");
        return;
        if ((this.app == null) || (this.cLG <= 0)) {
          break label369;
        }
        ((acle)this.app.getBusinessHandler(13)).JQ(this.cLG);
        if (this.app != null) {}
        for (paramURLDrawable = this.app.getCurrentAccountUin();; paramURLDrawable = "")
        {
          VasWebviewUtil.reportCommercialDrainage(paramURLDrawable, "defaultcard", "set_mydefaultcard", "", 1, 0, 0, "", Integer.toString(this.cLG), "");
          paramInt = 5;
          break;
        }
        c(paramURLDrawable, (String)this.ve.get(this.mIndex));
        if (this.app != null) {}
        for (paramURLDrawable = this.app.getCurrentAccountUin();; paramURLDrawable = "")
        {
          VasWebviewUtil.reportCommercialDrainage(paramURLDrawable, "defaultcard", "send", "", 1, 0, 0, "", Integer.toString(this.cLG), "");
          paramInt = 1;
          break;
        }
        l(paramURLDrawable);
        if (this.app != null) {}
        for (paramURLDrawable = this.app.getCurrentAccountUin();; paramURLDrawable = "")
        {
          VasWebviewUtil.reportCommercialDrainage(paramURLDrawable, "defaultcard", "save", "", 1, 0, 0, "", Integer.toString(this.cLG), "");
          paramInt = 2;
          break;
        }
        k(paramURLDrawable);
        if (this.app != null) {}
        for (paramURLDrawable = this.app.getCurrentAccountUin();; paramURLDrawable = "")
        {
          VasWebviewUtil.reportCommercialDrainage(paramURLDrawable, "defaultcard", "collect", "", 1, 0, 0, "", Integer.toString(this.cLG), "");
          paramInt = 3;
          break;
        }
      }
      label369:
      paramInt = 5;
    }
  }
  
  void c(URLDrawable paramURLDrawable, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    String str = a(paramURLDrawable);
    localBundle.putBoolean("forward_urldrawable", true);
    localBundle.putString("forward_urldrawable_thumb_url", paramString);
    localBundle.putString("forward_filepath", str);
    localBundle.putString("forward_urldrawable_big_url", paramURLDrawable.getURL().toString());
    localBundle.putString("forward_extra", str);
    paramURLDrawable = new Intent();
    paramURLDrawable.putExtras(localBundle);
    ahgq.f(this, paramURLDrawable, 21);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10) {}
    while ((paramInt1 != 21) || (paramInt2 != -1)) {
      return;
    }
    Intent localIntent = wja.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    startActivity(localIntent);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.isClearCoverLayer = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131561244);
    paramBundle = getIntent();
    this.ve = paramBundle.getStringArrayListExtra("business_card_pics");
    this.bSu = paramBundle.getBooleanExtra("is_edit_mode", false);
    this.mMode = paramBundle.getIntExtra("extra_mode", 1);
    this.gQ = paramBundle.getIntExtra("extra_default", 0);
    this.bSw = paramBundle.getBooleanExtra("is_from_profile", false);
    this.cLG = paramBundle.getIntExtra("default_card_id", 0);
    this.bSv = paramBundle.getBooleanExtra("is_from_mine_profile", false);
    this.hY = findViewById(2131379873);
    adld.l(this, this.hY);
    this.HU = ((TextView)findViewById(2131363226));
    this.HU.setOnClickListener(this);
    this.b = ((Gallery)findViewById(2131367833));
    this.qe = ((ImageView)findViewById(2131367840));
    this.qe.setOnClickListener(this);
    if ((this.mMode == 1) && (!this.bSu)) {
      this.qe.setVisibility(8);
    }
    this.b.setSpacing(getResources().getDimensionPixelSize(2131297406));
    this.b.setAdapter(this.f);
    this.b.setOnItemSelectedListener(new adzg(this));
    this.dY = ((ViewGroup)super.findViewById(2131364316));
    Object localObject2;
    Object localObject1;
    label536:
    int i;
    if (this.mMode == 2)
    {
      this.HU.setVisibility(8);
      this.b.setOnItemClickListener(new adzj(this));
      this.b.setOnItemLongClickListener(new adzk(this));
      this.dY.setOnClickListener(this);
      paramBundle = BaseApplicationImpl.getApplication().getSharedPreferences("profile_sp", 0);
      this.VN = paramBundle.getLong("recommend_id", 0L);
      this.bwt = paramBundle.getString("recommend_url", "");
      this.mDesc = paramBundle.getString("recommend_desc", "");
      localObject2 = (TextView)this.dY.findViewById(2131379444);
      paramBundle = (ImageView)this.dY.findViewById(2131369011);
      localObject1 = getResources().getDrawable(2130851854);
      if ((!TextUtils.isEmpty(this.bwt)) && (!TextUtils.isEmpty(this.mDesc)))
      {
        ((TextView)localObject2).setText(this.mDesc);
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = aqnm.dip2px(75.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = aqnm.dip2px(80.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        paramBundle.setImageDrawable(URLDrawable.getDrawable(this.bwt, (URLDrawable.URLDrawableOptions)localObject2));
        if (this.bSv) {
          this.dY.setVisibility(8);
        }
        localObject1 = this.app;
        if (this.app == null) {
          break label637;
        }
        paramBundle = this.app.getCurrentAccountUin();
        anot.a((QQAppInterface)localObject1, "CliOper", "", paramBundle, "card_mall", "0X8007B2A", 0, 0, String.valueOf(this.VN), "", "", "");
        paramBundle = this.app;
        if (!this.bSv) {
          break label643;
        }
        i = 1;
        label581:
        anot.a(paramBundle, "dc00898", "", "", "0X800A88B", "0X800A88B", i, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      addObserver(this.g);
      return true;
      ((TextView)localObject2).setText(acfp.m(2131703507));
      paramBundle.setImageDrawable((Drawable)localObject1);
      break;
      label637:
      paramBundle = "";
      break label536;
      label643:
      i = 2;
      break label581;
      this.dY.setVisibility(8);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.app != null) && (((achs)this.app.getManager(92)).iw(hashCode()))) {
      this.app.removeHandler(getClass());
    }
    removeObserver(this.g);
  }
  
  void k(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = a(paramURLDrawable);
    try
    {
      aviz.b(paramURLDrawable).b(this, this.app.getCurrentAccountUin());
      avjg.a(null, 40, 3);
      return;
    }
    catch (Exception paramURLDrawable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("qqBaseActivity", 2, "", paramURLDrawable);
      }
      QQToast.a(this, getString(2131694176), 0).show();
    }
  }
  
  public void n(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable.getStatus() != 1) {}
    String str;
    for (;;)
    {
      return;
      new File(acbn.oM).mkdirs();
      str = acbn.oM + Utils.Crc64String(paramURLDrawable.getURL().toString());
      File localFile = new File(str);
      if (!localFile.exists()) {
        try
        {
          if (localFile.createNewFile())
          {
            d(paramURLDrawable, localFile.getPath());
            return;
          }
        }
        catch (IOException paramURLDrawable)
        {
          QQToast.a(this, getString(2131696986), 0).show();
          return;
        }
      }
    }
    aqha.a(this, 230).setTitle(getString(2131718959)).setMessage(getString(2131696979)).setPositiveButton(getString(2131718798), new adzp(this, paramURLDrawable, str)).setNegativeButton(getString(2131696322), new adzo(this)).show();
  }
  
  public boolean onBackEvent()
  {
    finish();
    overridePendingTransition(0, 2130772440);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.qe) {
      Qq();
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (paramView != this.HU) {
          break;
        }
        onBackEvent();
      }
    } while (paramView != this.dY);
    aqep.a(this, this.app.getCurrentAccountUin(), "inside.friendCardBackground", 1, 1, 1, "recommendId=" + this.VN, false);
    QQAppInterface localQQAppInterface = this.app;
    if (this.app != null)
    {
      str = this.app.getCurrentAccountUin();
      label105:
      anot.a(localQQAppInterface, "CliOper", "", str, "card_mall", "0X8004DC0", 0, 0, String.valueOf(this.VN), "", "", "");
      if (this.app == null) {
        break label180;
      }
    }
    label180:
    for (String str = this.app.getCurrentAccountUin();; str = "")
    {
      VasWebviewUtil.reportCommercialDrainage(str, "defaultcard", "click_card_others", "", 1, 0, 0, "", "", "");
      break;
      str = "";
      break label105;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      Qq();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public static class a
  {
    public URLImageView I;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity
 * JD-Core Version:    0.7.0.1
 */