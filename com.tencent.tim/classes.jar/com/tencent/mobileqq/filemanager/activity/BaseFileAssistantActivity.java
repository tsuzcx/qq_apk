package com.tencent.mobileqq.filemanager.activity;

import acfp;
import aeub;
import aeuc;
import agbe;
import agbf;
import agfj;
import aghq;
import agkh;
import agmz;
import ahav;
import ahbk;
import ahbo;
import ahbp;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aoaf;
import avhc;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import wja;
import ymn;

public abstract class BaseFileAssistantActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public TextView Sd;
  final String TAG = "BaseFileAssistantActivity<FileAssistant>";
  protected long Yf;
  public long Yg = -1L;
  private ahbk jdField_a_of_type_Ahbk;
  private ahbo jdField_a_of_type_Ahbo;
  public QfileEditBottomBar a;
  public SendBottomBar a;
  private ymn jdField_a_of_type_Ymn;
  boolean aQ = true;
  public boolean aWg;
  private String bGi;
  private String bGj;
  protected String bGk;
  protected String bGl;
  protected String bGm;
  public String bGn = "";
  public String bGo = "doc|.docx|.xls|.xlsx";
  private int cWq;
  private int cWr;
  private int cWs;
  private int cWt;
  protected int cWu = -1;
  protected int cWv;
  public int cWw = 20971520;
  protected boolean ccA;
  protected boolean ccB;
  protected boolean ccC;
  public boolean ccD;
  protected boolean ccE;
  public boolean ccF;
  public boolean ccs;
  public boolean cct;
  private boolean ccu = true;
  private boolean ccv;
  private boolean ccw;
  private boolean ccx;
  private boolean ccy;
  protected boolean ccz;
  aghq e = new agbf(this);
  public RelativeLayout layout;
  private int mFromFlag;
  public int tabType = -1;
  protected ArrayList<FileInfo> wz;
  
  private void aC()
  {
    iq();
  }
  
  private void bm(Bundle paramBundle)
  {
    Intent localIntent = wja.a(new Intent(this, SplashActivity.class), new int[] { 2 });
    localIntent.putExtras(new Bundle(paramBundle));
    localIntent.addFlags(67108864);
    startActivity(localIntent);
  }
  
  private void deQ()
  {
    if (this.layout == null) {
      this.layout = ((RelativeLayout)findViewById(2131373347));
    }
    if ((akI()) || (akK())) {
      this.layout.setVisibility(0);
    }
    for (;;)
    {
      IM(akL());
      return;
      this.layout.setVisibility(8);
    }
  }
  
  private void initBottomBar()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar = ((SendBottomBar)findViewById(2131377980));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar = ((QfileEditBottomBar)findViewById(2131366191));
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(8);
    if (akI())
    {
      deM();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.dmH();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(0);
    }
    while (!akK()) {
      return;
    }
    deM();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.dmH();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setVisibility(0);
  }
  
  public void C(View.OnClickListener paramOnClickListener)
  {
    this.Sd.setOnClickListener(paramOnClickListener);
    this.Sd.setVisibility(0);
  }
  
  public int DW()
  {
    return this.cWq;
  }
  
  public int DX()
  {
    return this.cWr;
  }
  
  public int DY()
  {
    return this.cWt;
  }
  
  public int DZ()
  {
    return this.cWs;
  }
  
  public int Ea()
  {
    return this.cWv;
  }
  
  public boolean H()
  {
    return this.aQ;
  }
  
  public void IL(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      startTitleProgress();
      return;
    }
    stopTitleProgress();
  }
  
  public void IM(boolean paramBoolean) {}
  
  protected void IN(boolean paramBoolean)
  {
    this.ccu = paramBoolean;
  }
  
  protected void IO(boolean paramBoolean)
  {
    this.ccv = paramBoolean;
  }
  
  public void IP(boolean paramBoolean)
  {
    this.ccw = paramBoolean;
  }
  
  public void IQ(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mFromFlag |= 0x2;
      return;
    }
    this.mFromFlag &= 0xFFFFFFFD;
  }
  
  public void NM(int paramInt)
  {
    super.setContentViewNoTitle(2131561032);
    ((RelativeLayout)findViewById(2131363323)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    this.rightViewText = ((TextView)findViewById(2131377933));
    initUI();
    deP();
  }
  
  public int[] R()
  {
    return null;
  }
  
  public ahbo a()
  {
    return this.jdField_a_of_type_Ahbo;
  }
  
  public SendBottomBar a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar;
  }
  
  public ymn a()
  {
    return this.jdField_a_of_type_Ymn;
  }
  
  public void a(agfj paramagfj) {}
  
  public void a(ahbk paramahbk)
  {
    deP();
    this.jdField_a_of_type_Ahbk = paramahbk;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setClickListener(paramahbk);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setClickListener(paramahbk);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(paramBoolean1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setEditBtnVisible(paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  public void aM()
  {
    this.aQ = false;
    new Handler().postDelayed(new BaseFileAssistantActivity.1(this), 1500L);
  }
  
  public boolean akH()
  {
    return this.ccu;
  }
  
  public boolean akI()
  {
    return this.ccv;
  }
  
  public boolean akJ()
  {
    return this.ccx;
  }
  
  public boolean akK()
  {
    return this.ccw;
  }
  
  public boolean akL()
  {
    return (akI()) || (akK());
  }
  
  public boolean akM()
  {
    return (this.ccz) || (this.ccB);
  }
  
  public boolean akN()
  {
    return this.ccA;
  }
  
  public boolean akO()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.amW();
  }
  
  public boolean akP()
  {
    return (this.mFromFlag & 0x2) == 2;
  }
  
  public boolean akQ()
  {
    return (this.mFromFlag & 0x1) == 1;
  }
  
  public ListView b()
  {
    return null;
  }
  
  public void deK()
  {
    this.rightViewText.setVisibility(0);
  }
  
  public void deL()
  {
    this.rightViewText.setVisibility(8);
  }
  
  public void deM()
  {
    this.Sd.setVisibility(8);
  }
  
  public void deN()
  {
    setTitle(this.bGk);
    if ((this.tabType == 1) && (!akL())) {
      this.Sd.setVisibility(0);
    }
  }
  
  public void deO()
  {
    if (akL())
    {
      agmz.clearSelected();
      IP(false);
      if (akI())
      {
        setResult(5);
        finish();
        return;
      }
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131693524);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setVisibility(8);
      setTitle(this.bGk);
      refreshUI();
      resetUI();
      if (this.tabType == 1) {
        this.Sd.setVisibility(0);
      }
      IM(false);
      return;
    }
    if (this.jdField_a_of_type_Ahbk != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BaseFileAssistantActivity<FileAssistant>", 2, "onRightEditClick");
      }
      this.jdField_a_of_type_Ahbk.dfO();
    }
    agmz.clearSelected();
    IP(true);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131693507);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setVisibility(0);
    refreshUI();
    this.Sd.setVisibility(8);
    IM(true);
  }
  
  public void deP()
  {
    if (this.jdField_a_of_type_Ahbo == null) {
      this.jdField_a_of_type_Ahbo = new ahbp();
    }
  }
  
  public void deR()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.dmH();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.dmH();
    long l = agmz.fN();
    if ((!this.ccD) && (this.tabType != 8) && (!ahav.bm(this)) && (akL()))
    {
      if (agmz.fN() == 0L) {
        deN();
      }
    }
    else {
      return;
    }
    setTitle(acfp.m(2131703103) + l + acfp.m(2131703102));
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.dmH();
    if ((paramInt2 == -1) && (paramInt1 == 109)) {
      this.jdField_a_of_type_Ymn.cy(paramIntent);
    }
    if (paramInt2 == 4)
    {
      if ((this.ccy) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
        bm(paramIntent.getExtras());
      }
      setResult(4, paramIntent);
      finish();
    }
    do
    {
      return;
      if ((paramInt2 == -1) && (paramInt1 != 103) && (paramInt1 != 12289))
      {
        setResult(-1, paramIntent);
        finish();
        return;
      }
      if (paramInt2 == 5)
      {
        setResult(5, null);
        finish();
        return;
      }
    } while (paramInt2 != 10);
    setResult(10, paramIntent);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.app.a().addObserver(this.e);
    paramBundle = getIntent();
    IO(paramBundle.getBooleanExtra("selectMode", akI()));
    boolean bool;
    int i;
    if (!akI())
    {
      bool = true;
      IN(paramBundle.getBooleanExtra("enableDelete", bool));
      this.bGi = paramBundle.getStringExtra("targetUin");
      this.bGj = paramBundle.getStringExtra("srcDiscGroup");
      this.cWq = paramBundle.getIntExtra("peerType", 0);
      this.ccy = paramBundle.getBooleanExtra("rootEntrace", true);
      this.cWr = paramBundle.getIntExtra("busiType", 0);
      this.cWt = paramBundle.getIntExtra("enterfrom", 0);
      this.cWs = paramBundle.getIntExtra("sendprepare", -100);
      this.ccx = paramBundle.getBooleanExtra("apautocreate", false);
      this.ccD = paramBundle.getBooleanExtra("STRING_SingleSelect", false);
      this.ccB = paramBundle.getBooleanExtra("qlinkselect", false);
      this.ccC = paramBundle.getBooleanExtra("only_show_local_tab", false);
      this.cWu = paramBundle.getIntExtra("max_select_count", -1);
      this.Yf = paramBundle.getLongExtra("max_select_size", 0L);
      this.bGm = paramBundle.getStringExtra("send_btn_custom_text");
      this.wz = paramBundle.getParcelableArrayListExtra("default_select_file_info_list");
      this.bGl = paramBundle.getStringExtra("custom_title");
      this.cWv = paramBundle.getIntExtra("approval_attachment_customid", 0);
      this.ccE = paramBundle.getBooleanExtra("select_file_support_send_docs_file", false);
      this.ccF = paramBundle.getBooleanExtra(aoaf.cjs, false);
      this.bGn = paramBundle.getStringExtra(aoaf.cjt);
      this.Yg = paramBundle.getLongExtra("qrlogin_appid", -1L);
      this.ccs = paramBundle.getBooleanExtra("isTroopFile", false);
      this.cct = paramBundle.getBooleanExtra("isOverSpace", false);
      paramBundle.putExtra("uintype", 0);
      this.jdField_a_of_type_Ymn = new ymn(this, 109);
      this.jdField_a_of_type_Ymn.onCreate();
      if ("FileAssistant".equalsIgnoreCase(getIntent().getStringExtra("from"))) {
        IQ(true);
      }
      if (-1 == this.cWu)
      {
        if (!this.ccB) {
          break label522;
        }
        i = 100;
        label406:
        this.cWu = i;
      }
      if (!this.ccF) {
        break label528;
      }
      agmz.Og(1);
      paramBundle = aeuc.a().ud();
      if (!TextUtils.isEmpty(paramBundle)) {
        this.bGo = paramBundle;
      }
      long l2 = aeuc.a().fy();
      long l1 = l2;
      if (l2 == 0L) {
        l1 = 20971520L;
      }
      this.Yf = l1;
    }
    for (;;)
    {
      agmz.jz(this.Yf);
      if (this.wz == null) {
        break label538;
      }
      paramBundle = this.wz.iterator();
      while (paramBundle.hasNext()) {
        agmz.d((FileInfo)paramBundle.next());
      }
      bool = false;
      break;
      label522:
      i = 20;
      break label406;
      label528:
      agmz.Og(this.cWu);
    }
    label538:
    if (QLog.isColorLevel()) {
      QLog.d("BaseFileAssistantActivity<FileAssistant>", 2, ">>>>>" + getClass().getSimpleName() + "<<<<< doOnCreate ");
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseFileAssistantActivity<FileAssistant>", 2, ">>>>>" + getClass().getSimpleName() + "<<<<< doOnDestroy ");
    }
    this.jdField_a_of_type_Ymn.onDestroy();
    if (this.e != null) {
      this.app.a().deleteObserver(this.e);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.cg();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.cg();
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void doOnResume()
  {
    this.aQ = true;
    deR();
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.onResume();
    }
    super.doOnResume();
  }
  
  public int eA()
  {
    return -1;
  }
  
  public void ei(ArrayList<FileManagerEntity> paramArrayList) {}
  
  public void ej(ArrayList<FileManagerEntity> paramArrayList) {}
  
  public void ek(ArrayList<WeiYunFileInfo> paramArrayList) {}
  
  public void finish()
  {
    super.finish();
    if (this.ccy)
    {
      if (DX() == 1) {
        this.app.a().ezY();
      }
      if (akL()) {
        agmz.clearSelected();
      }
    }
  }
  
  protected void initUI()
  {
    if (this.Sd == null)
    {
      this.Sd = ((TextView)findViewById(2131377775));
      deM();
    }
    aC();
    if (getIntent().getIntExtra("localSdCardfile", -1) == 1408041716) {
      deL();
    }
    initBottomBar();
    deQ();
  }
  
  public void iq()
  {
    if (akL())
    {
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(getString(2131693507));
    }
    for (;;)
    {
      this.rightViewText.setOnClickListener(new agbe(this));
      return;
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131693524);
    }
  }
  
  public void m(Set<FileInfo> paramSet) {}
  
  public void onClick(View paramView) {}
  
  public void refreshUI()
  {
    initUI();
  }
  
  protected void resetUI() {}
  
  public int sB()
  {
    return this.tabType;
  }
  
  public void setCheckAllEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setCheckAllEnable(paramBoolean);
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(2131561032);
    ((RelativeLayout)findViewById(2131363323)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    initUI();
    deP();
  }
  
  public void setDocsCheck(boolean paramBoolean)
  {
    if (!this.ccE)
    {
      QLog.i("BaseFileAssistantActivity<FileAssistant>", 1, "biz not support docs send!");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setDocsCheck(paramBoolean);
  }
  
  public void setFromWeiXin(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mFromFlag |= 0x1;
      return;
    }
    this.mFromFlag &= 0xFFFFFFFE;
  }
  
  public void setSelectAllOrCancelAll(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setSelectAllOrCancelAll(paramBoolean);
    }
  }
  
  public void setSortType(int paramInt) {}
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("selectMode", akI());
    paramIntent.putExtra("enableDelete", akH());
    paramIntent.putExtra("targetUin", this.bGi);
    paramIntent.putExtra("srcDiscGroup", this.bGj);
    paramIntent.putExtra("peerType", this.cWq);
    paramIntent.putExtra("busiType", this.cWr);
    paramIntent.putExtra("enterfrom", this.cWt);
    paramIntent.putExtra("sendprepare", this.cWs);
    paramIntent.putExtra("apautocreate", this.ccx);
    paramIntent.putExtra("qlinkselect", this.ccB);
    paramIntent.putExtra("max_select_size", this.Yf);
    paramIntent.putExtra("max_select_count", this.cWu);
    paramIntent.putExtra("send_btn_custom_text", this.bGm);
    paramIntent.putExtra("custom_title", this.bGl);
    paramIntent.putExtra("rootEntrace", false);
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public String uV()
  {
    return this.bGi;
  }
  
  public String uW()
  {
    return this.bGj;
  }
  
  public String uX()
  {
    return this.bGm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */