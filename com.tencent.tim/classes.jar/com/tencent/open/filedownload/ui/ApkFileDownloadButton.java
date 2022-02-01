package com.tencent.open.filedownload.ui;

import acfp;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqai;
import aqha;
import aqju;
import arvv;
import arwk;
import arwl;
import arwm;
import arwn;
import arwt;
import aryx;
import asap;
import asaq;
import asar;
import asas;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.File;
import mqq.os.MqqHandler;

public class ApkFileDownloadButton
  extends RelativeLayout
  implements View.OnClickListener
{
  private a a;
  protected TextView adg;
  private TextView adh;
  private TextView adi;
  private ProgressBar at;
  public asap c;
  private int elt = 1;
  private Button hE;
  private Context mContext;
  private aryx mDownloadListener = new asaq(this);
  protected RelativeLayout mI;
  private String mSource = "";
  
  public ApkFileDownloadButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ApkFileDownloadButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ApkFileDownloadButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void B(DownloadInfo paramDownloadInfo)
  {
    if (AppNetConnInfo.isMobileConn())
    {
      asar localasar = new asar(this);
      paramDownloadInfo = new asas(this, paramDownloadInfo);
      aqha.a(this.mContext, 230, acfp.m(2131702418), acfp.m(2131702416), 2131721058, 2131692648, paramDownloadInfo, localasar).show();
      arwk.a(arwl.a().k(this.c.pageId).j("5").l("0").m(this.c.via).a(this.c.name).b(this.c.packageName).g(this.c.url));
      return;
    }
    ems();
    C(paramDownloadInfo);
  }
  
  private void C(DownloadInfo paramDownloadInfo)
  {
    DownloadInfo localDownloadInfo;
    if (paramDownloadInfo == null)
    {
      localDownloadInfo = new DownloadInfo();
      localDownloadInfo.pageId = this.c.pageId;
      localDownloadInfo.kx = this.c.kx;
      localDownloadInfo.cDH = this.c.cDH;
      localDownloadInfo.via = this.c.via;
      localDownloadInfo.urlStr = this.c.url;
      localDownloadInfo.packageName = this.c.packageName;
      localDownloadInfo.pushTitle = this.c.name;
      localDownloadInfo.sendTime = ("_" + GlobalUtil.calcMD5AsString(this.c.url));
      localDownloadInfo.ddi = true;
      localDownloadInfo.source = this.mSource;
      localDownloadInfo.emb();
    }
    for (;;)
    {
      arvv.a().b(localDownloadInfo);
      if (this.a != null) {
        this.a.emu();
      }
      return;
      paramDownloadInfo.packageName = this.c.packageName;
      paramDownloadInfo.ddi = true;
      if ((paramDownloadInfo.getState() == 4) && (new File(paramDownloadInfo.filePath).exists()))
      {
        this.c.state = 4;
        this.c.progress = 100;
        updateUI();
      }
      localDownloadInfo = paramDownloadInfo;
      if (TextUtils.isEmpty(paramDownloadInfo.source))
      {
        paramDownloadInfo.source = this.mSource;
        localDownloadInfo = paramDownloadInfo;
      }
    }
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2131559858, this);
    initView();
    arvv.a().a(this.mDownloadListener);
  }
  
  private void initView()
  {
    setClickable(true);
    this.mI = ((RelativeLayout)findViewById(2131377462));
    this.adh = ((TextView)findViewById(2131381148));
    this.at = ((ProgressBar)findViewById(2131373668));
    this.hE = ((Button)findViewById(2131363934));
    this.hE.setOnClickListener(this);
    this.adg = ((TextView)findViewById(2131381139));
    this.adg.setText(gx(1));
    this.adg.setOnClickListener(this);
    this.adi = ((TextView)findViewById(2131381140));
  }
  
  private void setProgress(float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    if (paramFloat < 0.0F) {
      paramFloat = f2;
    }
    for (;;)
    {
      if (paramFloat > 1.0F) {
        paramFloat = f1;
      }
      for (;;)
      {
        this.at.setProgress((int)(paramFloat * 100.0F));
        return;
      }
    }
  }
  
  private void setProgress(int paramInt)
  {
    setProgress(paramInt * 1.0F / 100.0F);
  }
  
  protected void D(DownloadInfo paramDownloadInfo)
  {
    arvv.a().d(paramDownloadInfo);
  }
  
  protected String DD()
  {
    return acfp.m(2131702419);
  }
  
  protected String DE()
  {
    if ((this.c.state == 4) || (this.c.progress == 100)) {
      return gx(4);
    }
    if (this.c.length == 0L) {
      return DD();
    }
    String str1 = aqai.a((float)(this.c.length * this.c.progress / 100L), true, 2);
    String str2 = aqai.a((float)this.c.length, true, 2);
    return DD() + "(" + str1 + "/" + str2 + ")";
  }
  
  protected void Ur(boolean paramBoolean)
  {
    bme();
    emt();
    if (paramBoolean) {
      arwk.b(arwm.a().a("202").k(this.c.pageId).j(this.c.kx).l(this.c.cDH).m(this.c.via).a(this.c.name).b(this.c.packageName).g(this.c.url));
    }
  }
  
  protected void Us(boolean paramBoolean)
  {
    if (this.c == null)
    {
      arwt.i("ApkFileDownloadButton_", "[onClick] mApkInfo == null!");
      return;
    }
    arwt.i("ApkFileDownloadButton_", "[onClick] state=" + this.c.state);
    arvv.a().a(this.mDownloadListener);
    DownloadInfo localDownloadInfo = arvv.a().e(this.c.url);
    if (localDownloadInfo != null)
    {
      this.c.state = localDownloadInfo.getState();
      if (TextUtils.isEmpty(localDownloadInfo.source)) {
        localDownloadInfo.source = this.mSource;
      }
    }
    switch (this.c.state)
    {
    default: 
      if ((localDownloadInfo != null) && ((localDownloadInfo.getState() != 4) || (new File(localDownloadInfo.filePath).exists()))) {
        break;
      }
    }
    for (String str = "900";; str = "400")
    {
      B(localDownloadInfo);
      for (;;)
      {
        if (paramBoolean) {
          arwk.b(arwm.a().a(str).k(this.c.pageId).j(this.c.kx).l(this.c.cDH).m(this.c.via).a(this.c.name).b(this.c.packageName).g(this.c.url));
        }
        dC(str, paramBoolean);
        return;
        if ((localDownloadInfo == null) || (localDownloadInfo.getState() != 4) || (!new File(localDownloadInfo.filePath).exists())) {
          break;
        }
        str = "305";
        this.c.state = 4;
        updateUI();
        emt();
        D(localDownloadInfo);
      }
      if ((localDownloadInfo == null) || ((localDownloadInfo.getState() == 4) && (!new File(localDownloadInfo.filePath).exists()))) {}
      for (str = "900";; str = "400")
      {
        B(localDownloadInfo);
        break;
      }
    }
  }
  
  protected void Xw(String paramString) {}
  
  protected void Xx(String paramString)
  {
    this.adh.setText(paramString);
  }
  
  public boolean a(DownloadInfo paramDownloadInfo, asap paramasap)
  {
    if ((paramDownloadInfo == null) || (paramasap == null)) {
      return false;
    }
    return TextUtils.equals(paramDownloadInfo.urlStr, paramasap.url);
  }
  
  public void bme()
  {
    pauseTask();
    arvv.a().b(this.mDownloadListener);
  }
  
  public void cD(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (this.a != null)) {
      this.a.emv();
    }
    Us(paramBoolean1);
  }
  
  public void cE(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (this.a != null)) {
      this.a.dlX();
    }
    Ur(paramBoolean1);
  }
  
  protected void dC(String paramString, boolean paramBoolean) {}
  
  public void destroy()
  {
    arvv.a().b(this.mDownloadListener);
    this.mDownloadListener = null;
  }
  
  protected void emr()
  {
    this.adi.setVisibility(8);
  }
  
  public void ems()
  {
    ThreadManager.getUIHandler().post(new ApkFileDownloadButton.2(this));
  }
  
  protected void emt()
  {
    ThreadManager.getUIHandler().post(new ApkFileDownloadButton.3(this));
  }
  
  protected String gw(int paramInt)
  {
    return "default";
  }
  
  protected String gx(int paramInt)
  {
    if (paramInt == 4) {
      return acfp.m(2131702422);
    }
    return acfp.m(2131702424);
  }
  
  public final void onClick(View paramView)
  {
    if (paramView == this.hE)
    {
      if (this.a != null) {
        this.a.dlX();
      }
      Ur(true);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.adg)
      {
        if (this.a != null) {
          this.a.emv();
        }
        Us(true);
      }
    }
  }
  
  public void pauseTask()
  {
    if (this.c.state != 4) {
      arvv.a().fx(this.c.url);
    }
  }
  
  public void resetUI()
  {
    this.c.state = 1;
    updateUI();
    emt();
  }
  
  public void setApkInfo(asap paramasap)
  {
    this.c = asap.a(paramasap);
    updateUI();
  }
  
  public void setEventCallback(a parama)
  {
    this.a = parama;
  }
  
  public void setSource(String paramString)
  {
    this.mSource = paramString;
  }
  
  protected void updateUI()
  {
    Xx(DE());
    if (this.c.state == 4) {
      this.c.progress = 100;
    }
    this.adg.setText(gx(this.c.state));
    setProgress(this.c.progress);
    int i = 1;
    if (this.c.state == 4) {
      i = 3;
    }
    if (this.mI.getVisibility() == 0) {
      i = 2;
    }
    this.adi.setText(gw(i));
  }
  
  protected void vG()
  {
    emt();
    if (this.a != null) {
      this.a.vG();
    }
  }
  
  public static abstract class a
  {
    public void dlX() {}
    
    public void emu() {}
    
    public void emv() {}
    
    public void vG() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.filedownload.ui.ApkFileDownloadButton
 * JD-Core Version:    0.7.0.1
 */