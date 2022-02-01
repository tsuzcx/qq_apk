package com.tencent.mobileqq.filemanager.widget;

import acbn;
import acfp;
import aeqs;
import aeqs.a;
import aequ;
import aesh;
import aesm;
import agfj;
import agmx;
import agmz;
import ahal;
import ahao;
import ahau;
import ahav;
import ahbj;
import ahbk;
import ahdp;
import ahdq;
import ahdr;
import ahds;
import ahdt;
import ahdu;
import ahdw;
import ahdx;
import ahdy;
import ahdz;
import ahea;
import ahee;
import ahef;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aoag;
import apsd;
import apsv;
import aqha;
import aqju;
import aqvn;
import arhz;
import armm;
import ausj;
import auss;
import avhc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SendBottomBar
  extends RelativeLayout
{
  private View Dm;
  private CheckBox N;
  private TextView SB;
  private TextView Tj;
  private TextView Tk;
  private TextView Tl;
  private TextView Tm;
  private QQBlurView a;
  private long aar;
  public ausj ah = null;
  private QQAppInterface app;
  private agfj b;
  private FrameLayout bE;
  private BaseFileAssistantActivity c;
  private int cWT;
  private boolean cgn;
  private boolean cgo;
  private boolean cgp = true;
  private boolean cgq;
  private Context context;
  private ahbk d;
  private View.OnClickListener fc = new ahee(this);
  private View.OnClickListener fe = new ahdy(this);
  private View.OnClickListener ff = new ahdz(this);
  private View.OnClickListener fg = new ahea(this);
  public aqju m = null;
  private boolean mNeedCheck;
  public arhz z;
  
  public SendBottomBar(Context paramContext)
  {
    super(paramContext, null);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131561027, this);
    this.context = paramContext;
    initUI();
  }
  
  public SendBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131561027, this, true);
    this.context = paramContext;
    initUI();
  }
  
  private void Kl(boolean paramBoolean)
  {
    boolean bool = false;
    if (paramBoolean) {
      if (agmz.fO() > 104857600L)
      {
        paramBoolean = true;
        if ((!paramBoolean) && (!this.c.cct)) {
          break label104;
        }
        if (!this.c.cct) {
          break label265;
        }
        paramBoolean = bool;
      }
    }
    label260:
    label265:
    for (;;)
    {
      Object localObject1 = aesm.d();
      if (((aesh)localObject1).isEnable())
      {
        localObject2 = VipUtils.K((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
        if (!((aesh)localObject1).a(this.context, new SendBottomBar.8(this), paramBoolean, (String)localObject2, this.c.ccs)) {}
      }
      label104:
      do
      {
        return;
        paramBoolean = false;
        break;
        if (apsv.aH(this.context) == 0)
        {
          apsd.ck(this.context, this.context.getString(2131699827));
          dmE();
          return;
        }
        if (!ahav.amK()) {
          break label260;
        }
      } while (!armm.a((Activity)this.context, 2, new ahef(this)));
      Object localObject2 = new ahdq(this);
      localObject1 = this.context.getString(2131699611);
      localObject2 = aqha.a(this.context, 230, this.context.getString(2131699824), (String)localObject1, 2131721058, 2131700020, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject2);
      if ((aequ.d().b.enable) && (!aqvn.a().pz())) {
        ((aqju)localObject2).setMessageWithoutAutoLink(aequ.d().b.a(this.context, (CharSequence)localObject1));
      }
      ((aqju)localObject2).show();
      return;
      dmE();
      return;
    }
  }
  
  private boolean amU()
  {
    int i = this.c.eA();
    if (i == -1) {
      return false;
    }
    if (!amV()) {
      return false;
    }
    this.Tl.setOnClickListener(new ahdp(this));
    Object localObject = "";
    switch (i)
    {
    }
    for (;;)
    {
      localObject = ahav.a("排序方式:\n" + (String)localObject, (String)localObject, null);
      this.Tl.setText((CharSequence)localObject);
      this.Tl.setVisibility(0);
      return true;
      localObject = acfp.m(2131714266);
      continue;
      localObject = acfp.m(2131714275);
      continue;
      localObject = acfp.m(2131714292);
    }
  }
  
  private boolean amV()
  {
    int[] arrayOfInt = this.c.R();
    if (arrayOfInt == null)
    {
      this.ah = null;
      return false;
    }
    int j = this.c.eA();
    this.ah = ((ausj)auss.a(this.c, null));
    int k = arrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      int n = arrayOfInt[i];
      ausj localausj;
      String str;
      boolean bool;
      switch (n)
      {
      default: 
        i += 1;
        break;
      case 1: 
        localausj = this.ah;
        str = acfp.m(2131714260);
        if (j == n) {}
        for (bool = true;; bool = false)
        {
          localausj.addRadioButton(str, bool);
          break;
        }
      case 0: 
        localausj = this.ah;
        str = acfp.m(2131714276);
        if (j == n) {}
        for (bool = true;; bool = false)
        {
          localausj.addRadioButton(str, bool);
          break;
        }
      case 2: 
        localausj = this.ah;
        str = acfp.m(2131714267);
        if (j == n) {}
        for (bool = true;; bool = false)
        {
          localausj.addRadioButton(str, bool);
          break;
        }
      }
    }
    this.ah.addCancelButton(acfp.m(2131714272));
    this.ah.a(new ahdx(this));
    return true;
  }
  
  private void bfC()
  {
    Intent localIntent = new Intent();
    if (this.c.Yg != -1L) {
      localIntent.putExtra("qrlogin_appid", this.c.Yg);
    }
    localIntent.putExtra("key_local_file_upload_finisth", true);
    this.c.setResult(-1, localIntent);
    this.c.finish();
  }
  
  private void dkp()
  {
    Object localObject2 = this.c.uV();
    Object localObject3 = agmz.D();
    Object localObject1 = new ArrayList();
    localObject3 = ((Set)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((ArrayList)localObject1).add(((FileInfo)((Iterator)localObject3).next()).getPath());
    }
    int i = this.c.DZ();
    if (222 == i)
    {
      this.c.getIntent().putExtra("string_filepaths", (Serializable)localObject1);
      this.c.setResult(-1, this.c.getIntent());
    }
    for (;;)
    {
      this.c.finish();
      return;
      if ((333 == i) || (666 == i) || (3333 == i) || (6666 == i))
      {
        this.c.getIntent().putExtra("string_filepaths", (Serializable)localObject1);
        this.c.setResult(i, this.c.getIntent());
      }
      else
      {
        if ((444 == i) || (555 == i))
        {
          localObject2 = this.c.getIntent();
          if (444 == i) {}
          for (boolean bool = true;; bool = false)
          {
            ((Intent)localObject2).putExtra("_INIT_SEND_IOS_", bool);
            ((Intent)localObject2).putExtra("string_filepaths", (Serializable)localObject1);
            this.c.setResult(i, this.c.getIntent());
            break;
          }
        }
        if ((777 == i) || (888 == i))
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putStringArrayList("string_filepaths", (ArrayList)localObject1);
          this.app.a();
          avhc.c(this.c, 16, (Bundle)localObject2);
        }
        else
        {
          this.app.a().g((String)localObject2, (List)localObject1);
          localObject1 = this.c.getIntent();
          ((Intent)localObject1).putExtra("_UIN_", (String)localObject2);
          ((Intent)localObject1).putExtra("_SEND_QLINK_FILE_", true);
          this.c.setResult(-1, this.c.getIntent());
        }
      }
    }
  }
  
  private void dmK()
  {
    ahau.JH("0x80087C5");
    am(2131696937);
    new Handler().postDelayed(new SendBottomBar.6(this), 100L);
  }
  
  private void dmL()
  {
    int i = 1;
    if (this.c.DW() == 1)
    {
      i = 2;
      String str = this.c.uV();
      if ((TextUtils.isEmpty(str)) || (!str.equals(acbn.bkw))) {
        break label115;
      }
      i = 3;
    }
    label115:
    for (;;)
    {
      long l = agmz.fN();
      anot.a(null, "dc00898", "", "", "0X800AA92", "0X800AA92", i, 0, "" + l, "0", "", "");
      return;
      if (this.c.DW() == 0) {
        break;
      }
      i = 4;
      break;
    }
  }
  
  private void dmM()
  {
    if (this.c.akI())
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(agmz.D());
      Intent localIntent = new Intent();
      localIntent.putParcelableArrayListExtra("reslut_select_file_info_list", localArrayList);
      localIntent.putExtra("approval_attachment_customid", this.c.Ea());
      this.c.setResult(-1, localIntent);
    }
    this.c.finish();
  }
  
  private void dmN()
  {
    if ((ahav.amK()) && (agmz.fO() > agmx.fJ()))
    {
      ahal.a(SplashActivity.sTopActivity, 2131693826, 2131693832, new ahdr(this));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(agmz.D());
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
    this.c.setResult(-1, localIntent);
    this.c.finish();
  }
  
  private void dmO()
  {
    Intent localIntent = this.c.getIntent();
    if (localIntent != null)
    {
      if (localIntent.getStringExtra("posturl") != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(agmz.D());
        localIntent.putParcelableArrayListExtra("fileinfo", localArrayList);
        this.c.setResult(-1, localIntent);
        this.c.finish();
      }
    }
    else {
      return;
    }
    this.c.setResult(-1, localIntent);
    this.c.finish();
  }
  
  private void dmP()
  {
    int k = this.c.DW();
    Object localObject1;
    int i;
    if (this.c.akO())
    {
      Object localObject2 = agmz.D();
      localObject1 = agmz.db();
      int j = 0;
      localObject2 = ((Set)localObject2).iterator();
      FileInfo localFileInfo;
      do
      {
        i = j;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localFileInfo = (FileInfo)((Iterator)localObject2).next();
      } while ((localFileInfo.getSize() <= 20971520L) || (!agmz.e(localFileInfo)));
      i = 1;
      if (i != 0) {
        break label198;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        if ((((FileManagerEntity)localObject2).fileSize > 20971520L) && (agmz.n((FileManagerEntity)localObject2))) {
          i = 1;
        }
      }
    }
    label198:
    for (;;)
    {
      if (i != 0)
      {
        ahau.JH("0X800942E");
        localObject1 = aqha.a(this.c, 2131700304);
        ((aqju)localObject1).setPositiveButton(2131721303, new ahds(this, k));
        ((aqju)localObject1).show();
        return;
      }
      OX(k);
      return;
      OX(k);
      return;
    }
  }
  
  private void dmQ()
  {
    int i = this.c.DZ();
    boolean bool = this.c.akJ();
    if ((1 == i) && (!bool))
    {
      ahal.a(this.c, 2131700519, 2131700518, new ahdt(this));
      return;
    }
    dkp();
  }
  
  private void initUI()
  {
    this.c = ((BaseFileAssistantActivity)this.context);
    this.Tk = ((TextView)findViewById(2131373569));
    this.Tl = ((TextView)findViewById(2131372449));
    this.N = ((CheckBox)findViewById(2131364571));
    this.SB = ((TextView)findViewById(2131377979));
    this.SB.setOnClickListener(this.fc);
    this.Tj = ((TextView)findViewById(2131373566));
    this.Tj.setOnClickListener(this.fe);
    this.bE = ((FrameLayout)findViewById(2131366027));
    this.bE.setVisibility(8);
    this.Tm = ((TextView)findViewById(2131366028));
    this.Tm.setVisibility(8);
    this.Dm = findViewById(2131377953);
    this.Dm.setVisibility(8);
    if (1 == this.c.DX()) {
      this.SB.setText(acfp.m(2131714270));
    }
    for (;;)
    {
      this.app = ((QQAppInterface)this.c.getAppRuntime());
      this.cgp = this.app.getPreferences().getBoolean("_fm_select_showd", false);
      return;
      if (10 == this.c.DX()) {
        this.SB.setText(2131721053);
      }
    }
  }
  
  public void Km(boolean paramBoolean)
  {
    float f2 = 1.0F;
    if (this.c.eA() != -1) {}
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
    } while (this.bE.getVisibility() == 0);
    this.bE.setVisibility(0);
    label36:
    if (paramBoolean) {}
    for (float f1 = 1.0F;; f1 = 0.0F)
    {
      if (paramBoolean) {
        f2 = 0.0F;
      }
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, f1, 1, f2);
      localTranslateAnimation.setDuration(500L);
      localTranslateAnimation.setFillAfter(true);
      this.bE.startAnimation(localTranslateAnimation);
      if (paramBoolean) {
        break;
      }
      this.bE.setVisibility(8);
      new Handler().postDelayed(new SendBottomBar.18(this), 1500L);
      return;
      if (this.bE.getVisibility() == 0) {
        break label36;
      }
      return;
    }
  }
  
  public void OX(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      ahao.OS(2131696206);
      return;
    }
    if ((ahav.amK()) && (agmz.fO() > agmx.fJ()))
    {
      ahav.a(true, this.context, new ahdu(this), paramInt);
      return;
    }
    dmE();
  }
  
  @TargetApi(19)
  protected void aH()
  {
    if (this.a != null)
    {
      this.a.onDestroy();
      this.a = null;
    }
    ListView localListView = this.c.b();
    if (localListView == null) {}
    while (!ThemeUtil.isDefaultOrDIYTheme(false)) {
      return;
    }
    this.a = ((QQBlurView)findViewById(2131381443));
    this.a.setVisibility(0);
    this.a.iD(localListView);
    this.a.iE(this.a);
    this.a.YJ(-1);
    this.a.ae(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
    this.a.YI(0);
    this.a.bg(8.0F);
    this.a.YK(8);
    this.a.onCreate();
    this.a.onResume();
  }
  
  void am(int paramInt)
  {
    if (this.z != null) {
      btB();
    }
    for (;;)
    {
      if (!this.z.isShowing()) {
        this.z.show();
      }
      return;
      this.z = new arhz(this.context, this.context.getResources().getDimensionPixelSize(2131299627));
      this.z.setCancelable(false);
      this.z.setMessage(acfp.m(2131714293));
      this.z.show();
    }
  }
  
  public boolean amW()
  {
    return this.cgn;
  }
  
  public void btB()
  {
    try
    {
      if ((this.z != null) && (this.z.isShowing())) {
        this.z.cancel();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void cg()
  {
    if (this.a != null) {
      this.a.onDestroy();
    }
  }
  
  public void dmE()
  {
    am(2131696937);
    new Handler().postDelayed(new SendBottomBar.15(this), 100L);
  }
  
  public void dmH()
  {
    boolean bool2 = true;
    aH();
    int i = this.c.DW();
    Object localObject1 = this.c.uX();
    if (localObject1 == null) {
      if (i == 5) {
        localObject1 = this.context.getResources().getString(2131700007) + this.context.getString(2131693788) + agmz.fN() + this.context.getString(2131693789);
      }
    }
    for (;;)
    {
      long l = agmz.fP();
      Object localObject2 = "";
      if (l > 0L)
      {
        localObject2 = this.context.getString(2131693579) + ahbj.g(l);
        this.Tl.setOnClickListener(null);
      }
      Object localObject3 = localObject2;
      if (agmz.fQ() > 0L)
      {
        localObject3 = localObject2;
        if (!ahav.bm(this.context))
        {
          localObject3 = localObject2;
          if (i != 8001) {
            localObject3 = (String)localObject2 + this.context.getString(2131693580) + ahbj.g(agmz.fQ());
          }
        }
      }
      if (ahav.bm(this.context)) {
        localObject3 = this.context.getString(2131693579) + agmz.fN() + acfp.m(2131714269);
      }
      if ((this.cgo) && (this.N.getVisibility() == 0))
      {
        l = agmz.fN();
        this.SB.setEnabled(true);
        this.Tl.setVisibility(0);
        if (l > 99L) {
          localObject1 = acfp.m(2131714273);
        }
        for (;;)
        {
          if (amU())
          {
            this.SB.setText(acfp.m(2131714277));
            localObject1 = this.context.getResources().getColorStateList(2131165366);
            this.SB.setBackgroundDrawable(null);
            this.SB.setTextColor((ColorStateList)localObject1);
            this.SB.setTextSize(1, 17.0F);
            this.N.setCompoundDrawables(null, null, null, null);
            this.N.setTextColor(getResources().getColor(2131167311));
            this.N.setTextSize(1, 17.0F);
            if (l > 0L)
            {
              this.Tm.setText((CharSequence)localObject3);
              this.Tm.setVisibility(0);
              this.Tm.setGravity(17);
              this.bE.setVisibility(0);
              return;
              if (i == 6001)
              {
                localObject1 = this.context.getResources().getString(2131693511) + this.context.getString(2131693788) + agmz.fN() + this.context.getString(2131693789);
                break;
              }
              if (i == 10006)
              {
                localObject1 = this.context.getResources().getString(2131721079);
                break;
              }
              if (i == 8001)
              {
                localObject1 = this.context.getString(2131721053) + this.context.getString(2131693788) + agmz.fN() + this.context.getString(2131693789);
                break;
              }
              localObject1 = this.context.getString(2131693581) + this.context.getString(2131693788) + agmz.fN() + this.context.getString(2131693789);
              break;
              if (l == 0L)
              {
                localObject1 = acfp.m(2131714280);
                this.Tl.setVisibility(8);
                this.SB.setEnabled(false);
                continue;
              }
              localObject1 = acfp.m(2131714290) + String.valueOf(l) + ")";
              continue;
            }
            this.bE.setVisibility(8);
            return;
          }
        }
        this.SB.setText((CharSequence)localObject1);
        this.Tl.setText((CharSequence)localObject3);
        return;
      }
      boolean bool1;
      if ((this.mNeedCheck) && (!ahav.bm(this.context)))
      {
        l = agmz.fN();
        localObject1 = acfp.m(2131714278) + String.valueOf(l) + ")";
        this.Tl.setVisibility(8);
        this.bE.setVisibility(0);
        this.Tm.setVisibility(0);
        this.Tm.setText((CharSequence)localObject3);
        this.N.setEnabled(true);
        localObject2 = this.SB;
        if (agmz.fN() > 0L) {}
        for (bool1 = true;; bool1 = false)
        {
          ((TextView)localObject2).setEnabled(bool1);
          this.SB.setText((CharSequence)localObject1);
          return;
        }
      }
      this.bE.setVisibility(8);
      this.Tm.setVisibility(8);
      this.N.setVisibility(8);
      switch (this.c.DX())
      {
      default: 
        i = this.Tj.getVisibility();
        if ((i == 4) || (i == 8))
        {
          this.Tl.setVisibility(0);
          this.Tk.setVisibility(8);
          if (ahav.bm(this.context)) {
            if (agmz.fN() == 0L)
            {
              this.Tl.setVisibility(8);
              if (ahav.c() == null) {
                break label1289;
              }
              bool1 = true;
              label1059:
              this.SB.setText((CharSequence)localObject1);
              if (1 == this.c.DX()) {
                this.SB.setText(acfp.m(2131714264));
              }
              localObject1 = this.SB;
              if (agmz.fN() <= 0L) {
                break label1294;
              }
            }
          }
        }
        break;
      }
      for (;;)
      {
        ((TextView)localObject1).setEnabled(bool2);
        this.Tj.setEnabled(bool1);
        return;
        i = this.Tj.getVisibility();
        if ((i == 4) || (i == 8))
        {
          this.Tl.setVisibility(0);
          this.Tk.setVisibility(8);
          this.Tl.setText(2131700498);
          localObject2 = (RelativeLayout.LayoutParams)this.Tl.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          this.Tl.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          break;
        }
        this.Tk.setVisibility(0);
        this.Tl.setVisibility(8);
        this.Tk.setText(2131700498);
        break;
        this.Tl.setVisibility(0);
        this.Tl.setText((CharSequence)localObject3);
        break;
        this.Tl.setText((CharSequence)localObject3);
        break;
        this.Tk.setVisibility(0);
        this.Tl.setVisibility(8);
        this.Tk.setText((CharSequence)localObject3);
        break;
        label1289:
        bool1 = false;
        break label1059;
        label1294:
        bool2 = false;
      }
    }
  }
  
  public void dmR()
  {
    Object localObject2 = null;
    Object localObject1 = agmz.D();
    ArrayList localArrayList = agmz.db();
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    label148:
    int i;
    if ((localObject1 != null) && (((Set)localObject1).size() > 0)) {
      if (((Set)localObject1).iterator().hasNext())
      {
        localObject1 = (FileInfo)((Set)localObject1).iterator().next();
        localTeamWorkFileImportInfo.filePath = ((FileInfo)localObject1).getPath();
        localTeamWorkFileImportInfo.fileName = ((FileInfo)localObject1).getName();
        localTeamWorkFileImportInfo.nFileType = ahav.getFileType(((FileInfo)localObject1).getName());
        localTeamWorkFileImportInfo.dNQ = 10;
        localTeamWorkFileImportInfo.fileSize = ((FileInfo)localObject1).getSize();
        if ((this.context == null) || (!(this.context instanceof FMActivity))) {
          break label360;
        }
        localObject1 = (FMActivity)this.context;
        localTeamWorkFileImportInfo.folderId = ((FMActivity)this.context).bGn;
        i = 1;
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (localArrayList != null)
      {
        localObject1 = localObject2;
        if (localArrayList.size() > 0)
        {
          localObject1 = localObject2;
          if (i == 0)
          {
            localObject1 = (FileManagerEntity)localArrayList.get(0);
            localTeamWorkFileImportInfo.filePath = ((FileManagerEntity)localObject1).getFilePath();
            localTeamWorkFileImportInfo.fileName = ((FileManagerEntity)localObject1).fileName;
            localTeamWorkFileImportInfo.nFileType = ((FileManagerEntity)localObject1).nFileType;
            localTeamWorkFileImportInfo.fileSize = ((FileManagerEntity)localObject1).fileSize;
            localTeamWorkFileImportInfo.dNQ = 10;
            localTeamWorkFileImportInfo.peerUin = ((FileManagerEntity)localObject1).peerUin;
            localTeamWorkFileImportInfo.msgUniseq = ((FileManagerEntity)localObject1).uniseq;
            localTeamWorkFileImportInfo.peerType = ((FileManagerEntity)localObject1).peerType;
            localTeamWorkFileImportInfo.nSessionId = ((FileManagerEntity)localObject1).nSessionId;
            localTeamWorkFileImportInfo.cKX = true;
            if ((this.context == null) || (!(this.context instanceof FMActivity))) {
              break label446;
            }
            localObject1 = (FMActivity)this.context;
            localTeamWorkFileImportInfo.folderId = ((FMActivity)this.context).bGn;
          }
        }
      }
      label310:
      if ((this.context instanceof BaseFileAssistantActivity)) {}
      for (i = ((BaseFileAssistantActivity)this.context).DY();; i = 0)
      {
        aoag.a(localTeamWorkFileImportInfo, this.context, this.app, i);
        if (localObject1 != null) {
          ((Activity)localObject1).finish();
        }
        return;
        localObject1 = null;
        break;
        label360:
        if ((this.context != null) && ((this.context instanceof FMLocalFileActivity)))
        {
          localObject1 = (FMLocalFileActivity)this.context;
          localTeamWorkFileImportInfo.folderId = ((FMLocalFileActivity)this.context).bGn;
          break label148;
        }
        if ((this.context == null) || (!(this.context instanceof LocalFileBrowserActivity))) {
          break label541;
        }
        localObject1 = (LocalFileBrowserActivity)this.context;
        localTeamWorkFileImportInfo.folderId = ((LocalFileBrowserActivity)this.context).bGn;
        break label148;
        label446:
        if ((this.context != null) && ((this.context instanceof FMLocalFileActivity)))
        {
          localObject1 = (FMLocalFileActivity)this.context;
          localTeamWorkFileImportInfo.folderId = ((FMLocalFileActivity)this.context).bGn;
          break label310;
        }
        localObject1 = localObject2;
        if (this.context == null) {
          break label310;
        }
        localObject1 = localObject2;
        if (!(this.context instanceof LocalFileBrowserActivity)) {
          break label310;
        }
        localObject1 = (LocalFileBrowserActivity)this.context;
        localTeamWorkFileImportInfo.folderId = ((LocalFileBrowserActivity)this.context).bGn;
        break label310;
      }
      label541:
      localObject1 = null;
      break label148;
      i = 0;
    }
  }
  
  public void dmS()
  {
    if ((this.c != null) && (this.Dm != null) && (this.Dm.getVisibility() == 0))
    {
      this.cgp = true;
      this.Dm.setVisibility(8);
    }
  }
  
  public void onResume() {}
  
  public void setAttribution(int paramInt)
  {
    this.cWT = paramInt;
  }
  
  public void setCheckAllEnable(boolean paramBoolean)
  {
    if (this.N != null) {
      this.N.setEnabled(paramBoolean);
    }
  }
  
  public void setClickListener(ahbk paramahbk)
  {
    this.d = paramahbk;
  }
  
  public void setDocsCheck(boolean paramBoolean)
  {
    boolean bool;
    if ((paramBoolean) && ((this.cgn) || (agmz.alN())))
    {
      bool = true;
      this.mNeedCheck = bool;
      if (QLog.isDebugVersion()) {
        QLog.i("TeamWorkSender", 1, "docsCheck[" + paramBoolean + "],bCheckSendToDocs[" + this.cgn + "], selectAllDocs[" + agmz.alN() + "] ,hasSelectDocsFile[" + agmz.alO() + "]");
      }
      if (agmz.fN() != 0L) {
        break label284;
      }
      this.N.setChecked(false);
      this.cgn = false;
    }
    for (this.mNeedCheck = false;; this.mNeedCheck = false)
    {
      label284:
      do
      {
        if ((this.mNeedCheck) && (!this.cgp))
        {
          this.Dm.setVisibility(0);
          new Handler().postDelayed(new SendBottomBar.16(this), 3000L);
        }
        this.app.getPreferences().edit().putBoolean("_fm_select_showd", true).apply();
        if (!this.mNeedCheck) {
          break label319;
        }
        this.N.setVisibility(0);
        this.N.setEnabled(true);
        this.N.setText(acfp.m(2131714274));
        this.N.setOnClickListener(new ahdw(this));
        this.Tl.setVisibility(8);
        this.bE.setVisibility(0);
        this.Tm.setVisibility(0);
        ahau.JH("0X800942A");
        return;
        bool = false;
        break;
      } while ((agmz.fN() <= 0L) || (agmz.alO()));
      this.N.setChecked(false);
      this.cgn = false;
    }
    label319:
    this.N.setVisibility(8);
    this.bE.setVisibility(8);
    this.Tm.setVisibility(8);
  }
  
  public void setEditBtnVisible(boolean paramBoolean)
  {
    TextView localTextView = this.Tj;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      dmH();
      return;
    }
  }
  
  public void setOnlyDocsChecked()
  {
    this.cgn = true;
    this.N.setChecked(true);
  }
  
  public void setSelectAllOrCancelAll(boolean paramBoolean)
  {
    CheckBox localCheckBox = this.N;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      localCheckBox.setChecked(bool);
      if (!paramBoolean) {
        break;
      }
      this.N.setText(acfp.m(2131714263));
      return;
    }
    this.N.setText(acfp.m(2131714287));
  }
  
  public void setSelectEvent(agfj paramagfj)
  {
    this.b = paramagfj;
  }
  
  public void setSelectedAllMode()
  {
    this.cgo = true;
    this.N.setVisibility(0);
    this.Tj.setVisibility(8);
    this.Tk.setVisibility(8);
    this.N.setOnClickListener(this.ff);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Tl.getLayoutParams();
    localLayoutParams.addRule(9, 0);
    localLayoutParams.addRule(0, 0);
    localLayoutParams.addRule(13);
    this.Tl.setGravity(1);
    this.Tl.setLayoutParams(localLayoutParams);
    this.Tl.setVisibility(0);
    this.SB.setVisibility(0);
    this.SB.setText(acfp.m(2131714286));
    this.SB.setOnClickListener(this.fg);
    if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
      this.Tm.setBackgroundDrawable(getResources().getDrawable(2130838900));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar
 * JD-Core Version:    0.7.0.1
 */