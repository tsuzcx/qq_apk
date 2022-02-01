package com.tencent.tim.filemanager.activity;

import aeub;
import aeuc;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import atnt;
import atnu;
import atsn;
import atti;
import atwb;
import auei;
import auej;
import auek;
import avhc;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.widget.CloudSendBottomBar;
import com.tencent.tim.filemanager.widget.QfileEditBottomBar;
import com.tencent.tim.filemanager.widget.SendBottomBar;
import java.util.ArrayList;
import java.util.Iterator;
import wja;

public abstract class BaseFileAssistantActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public TextView Sd;
  final String TAG = "BaseFileAssistantActivity<FileAssistant>";
  protected long Yf;
  private auei jdField_a_of_type_Auei;
  private auej jdField_a_of_type_Auej;
  public QfileEditBottomBar a;
  public SendBottomBar a;
  boolean aQ = true;
  private String bGi;
  private String bGj;
  protected String bGk;
  protected String bGl;
  protected String bGm;
  public String bGn = "";
  public String bGo = "doc|.docx|.xls|.xlsx";
  atsn c = new atnu(this);
  private String cHM;
  private int cWq;
  private int cWr;
  private int cWs;
  private int cWt;
  protected int cWu = -1;
  protected int cWv;
  protected boolean ccA;
  protected boolean ccB;
  protected boolean ccC;
  public boolean ccD;
  public boolean ccF;
  private boolean ccu = true;
  private boolean ccv;
  private boolean ccw;
  private boolean ccx;
  private boolean ccy;
  protected boolean ccz;
  protected boolean dip;
  protected boolean diq;
  protected boolean dir;
  private boolean dis;
  public int eqG;
  public RelativeLayout layout;
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
    if ((this.dis) && ((this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar == null) || ((this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar instanceof CloudSendBottomBar))))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131363322);
      findViewById(2131377980).setVisibility(8);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar = new CloudSendBottomBar(this);
      Object localObject = new FileInfo();
      ((FileInfo)localObject).bf(getIntent().getByteArrayExtra("key_parent_dir_key"));
      if (getIntent().hasExtra("key_parent_dir_name")) {
        ((FileInfo)localObject).setName(getIntent().getStringExtra("key_parent_dir_name"));
      }
      ((CloudSendBottomBar)this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar).setDestinationFileInfo((FileInfo)localObject);
      ((CloudSendBottomBar)this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar).setLeftAction(getIntent().getIntExtra("key_bottom_bar_left_action", 0));
      ((CloudSendBottomBar)this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar).setRightAction(getIntent().getIntExtra("key_bottom_bar_right_action", 0));
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      localRelativeLayout.addView(this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar, (ViewGroup.LayoutParams)localObject);
    }
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileEditBottomBar == null) {
          this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileEditBottomBar = ((QfileEditBottomBar)findViewById(2131366191));
        }
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileEditBottomBar.setVisibility(8);
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar.setVisibility(8);
        if (!akI()) {
          break;
        }
        deM();
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar.dmH();
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar.setVisibility(0);
        return;
        if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar == null) {
          this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar = ((SendBottomBar)findViewById(2131377980));
        }
      }
    } while (!akK());
    deM();
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileEditBottomBar.dmH();
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileEditBottomBar.setVisibility(0);
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
  
  public int DZ()
  {
    return this.cWs;
  }
  
  public String EU()
  {
    return this.cHM;
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
  
  public void IO(boolean paramBoolean)
  {
    this.ccv = paramBoolean;
  }
  
  public void IP(boolean paramBoolean)
  {
    this.ccw = paramBoolean;
  }
  
  public void NM(int paramInt)
  {
    super.setContentViewNoTitle(2131563201);
    ((RelativeLayout)findViewById(2131363323)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    this.rightViewText = ((TextView)findViewById(2131377933));
    initUI();
    deP();
  }
  
  public auej a()
  {
    return this.jdField_a_of_type_Auej;
  }
  
  public void a(auei paramauei)
  {
    deP();
    this.jdField_a_of_type_Auei = paramauei;
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar.setClickListener(paramauei);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileEditBottomBar.setClickListener(paramauei);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar.setEditBtnVisible(paramBoolean1);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileEditBottomBar.setEditBtnVisible(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
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
  
  public void deP()
  {
    if (this.jdField_a_of_type_Auej == null) {
      this.jdField_a_of_type_Auej = new auek();
    }
  }
  
  public void deR()
  {
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar.dmH();
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileEditBottomBar.dmH();
    long l = atwb.fN();
    if ((!this.ccD) && (this.tabType != 9) && (akL()))
    {
      if (atwb.fN() == 0L) {
        deN();
      }
    }
    else {
      return;
    }
    setTitle("已选" + l + "个");
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar.dmH();
    if ((paramInt2 == -1) && (paramInt1 == 2)) {
      if ((paramIntent.hasExtra("key_selected_dir")) && (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar != null) && ((this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar instanceof CloudSendBottomBar))) {
        ((CloudSendBottomBar)this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar).setDestinationFileInfo((FileInfo)paramIntent.getParcelableExtra("key_selected_dir"));
      }
    }
    do
    {
      return;
      if (paramInt2 == 4)
      {
        if ((this.ccy) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
          bm(paramIntent.getExtras());
        }
        setResult(4, paramIntent);
        finish();
        return;
      }
      if ((paramInt2 == -1) && (paramInt1 != 103))
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
  
  public void doOnBackPressed()
  {
    if (akK())
    {
      atwb.clearSelected();
      IP(false);
      this.rightViewText.setVisibility(8);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileEditBottomBar.setVisibility(8);
      setTitle(this.bGk);
      refreshUI();
      resetUI();
      if (this.tabType == 1) {
        this.Sd.setVisibility(0);
      }
      IM(false);
      this.rightViewText.setVisibility(8);
      return;
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.app.a().addObserver(this.c);
    paramBundle = getIntent();
    IO(paramBundle.getBooleanExtra("selectMode", akI()));
    boolean bool;
    int i;
    if (!akI())
    {
      bool = true;
      IN(paramBundle.getBooleanExtra("enableDelete", bool));
      this.bGi = paramBundle.getStringExtra("targetUin");
      this.cHM = paramBundle.getStringExtra("targetNickName");
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
      this.diq = paramBundle.getBooleanExtra("only_show_recent_tab", false);
      this.dir = paramBundle.getBooleanExtra("only_show_cloud_tab", false);
      this.dip = paramBundle.getBooleanExtra("only_show_weiyun_tab", false);
      this.cWu = paramBundle.getIntExtra("max_select_count", -1);
      this.Yf = paramBundle.getLongExtra("max_select_size", 0L);
      this.bGm = paramBundle.getStringExtra("send_btn_custom_text");
      this.wz = paramBundle.getParcelableArrayListExtra("default_select_file_info_list");
      this.bGl = paramBundle.getStringExtra("custom_title");
      this.cWv = paramBundle.getIntExtra("approval_attachment_customid", 0);
      this.dis = paramBundle.getBooleanExtra("is_using_cloud_bottom_bar", false);
      this.eqG = paramBundle.getIntExtra("qfile_selecter_entrance_type", 4);
      this.ccF = paramBundle.getBooleanExtra("key_from_web_open_native_files_to_import_docs", false);
      this.bGn = paramBundle.getStringExtra("key_from_web_import_docs_folderid");
      if (-1 == this.cWu)
      {
        if (!this.ccB) {
          break label489;
        }
        i = 50;
        label373:
        this.cWu = i;
      }
      if (!this.ccF) {
        break label495;
      }
      atwb.Og(1);
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
      atwb.jz(this.Yf);
      if (this.wz == null) {
        break label505;
      }
      paramBundle = this.wz.iterator();
      while (paramBundle.hasNext()) {
        atwb.d((FileInfo)paramBundle.next());
      }
      bool = false;
      break;
      label489:
      i = 20;
      break label373;
      label495:
      atwb.Og(this.cWu);
    }
    label505:
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
    if (this.c != null) {
      this.app.a().deleteObserver(this.c);
    }
    if ((this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar != null) && ((this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar instanceof CloudSendBottomBar))) {
      ((CloudSendBottomBar)this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar).destroy();
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    if ((this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar != null) && ((this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar instanceof CloudSendBottomBar))) {
      ((CloudSendBottomBar)this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar).doOnPause();
    }
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void doOnResume()
  {
    this.aQ = true;
    deR();
    AbstractGifImage.resumeAll();
    ApngImage.resumeAll();
    if ((this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar != null) && ((this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar instanceof CloudSendBottomBar))) {
      ((CloudSendBottomBar)this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar).doOnResume();
    }
    super.doOnResume();
  }
  
  public void ei(ArrayList<FileManagerEntity> paramArrayList) {}
  
  public void ej(ArrayList<FileManagerEntity> paramArrayList) {}
  
  public void ek(ArrayList<WeiYunFileInfo> paramArrayList) {}
  
  public void eul()
  {
    if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileEditBottomBar != null) {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileEditBottomBar.setVisibility(8);
    }
    setTitle(this.bGk);
    refreshUI();
    resetUI();
    if ((this.Sd != null) && (this.tabType == 1)) {
      this.Sd.setVisibility(0);
    }
    IM(false);
  }
  
  public void eum()
  {
    if (akL())
    {
      atwb.clearSelected();
      IP(false);
      if (akI())
      {
        if ((this.eqG == 4) || (this.eqG == 6)) {
          setResult(-1);
        }
        for (;;)
        {
          finish();
          return;
          setResult(5);
        }
      }
      this.rightViewText.setVisibility(8);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileEditBottomBar.setVisibility(8);
      setTitle(this.bGk);
      refreshUI();
      resetUI();
      if (this.tabType == 1) {
        this.Sd.setVisibility(0);
      }
      IM(false);
      this.rightViewText.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_Auei != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BaseFileAssistantActivity<FileAssistant>", 2, "onRightEditClick");
      }
      this.jdField_a_of_type_Auei.dfO();
    }
    atwb.clearSelected();
    IP(true);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131693507);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetQfileEditBottomBar.setVisibility(0);
    refreshUI();
    this.Sd.setVisibility(8);
    IM(true);
  }
  
  public void finish()
  {
    super.finish();
    if (this.ccy)
    {
      if (DX() == 1) {
        this.app.a().ezY();
      }
      if ((akL()) && (this.eqG != 4) && (this.eqG != 6)) {
        atwb.clearSelected();
      }
    }
  }
  
  public void fn(ArrayList<FileInfo> paramArrayList) {}
  
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
    this.rightViewText.setOnClickListener(new atnt(this));
  }
  
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
  
  public void setCheckAll(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar.setCheckAll(paramBoolean);
  }
  
  public void setCheckAllEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetSendBottomBar.setCheckAllEnable(paramBoolean);
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(2131563201);
    ((RelativeLayout)findViewById(2131363323)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    initUI();
    deP();
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.BaseFileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */