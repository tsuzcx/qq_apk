package com.tencent.tim.cloudfile;

import aaja;
import accn;
import ahav;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqha;
import aqiw;
import aqju;
import aqmj;
import atdt.a;
import ateh;
import atgc;
import atgi;
import atgo;
import atgp;
import atgq;
import atgr;
import atgu;
import atgv;
import atgw;
import atgx;
import atgy;
import atgz;
import atha;
import athb;
import athc;
import athd;
import athe;
import athf;
import athg;
import athh;
import athu;
import atin;
import atiu;
import ativ;
import atiz;
import atjx;
import atlz;
import atsj;
import atso;
import aueh;
import auhh;
import auhk.g;
import auhr;
import aurf;
import com.tencent.cloudfile.CloudFile;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardHandler.AutoSaveCloudStateGetPrg;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.widget.CloudSendBottomBar;
import com.tencent.tim.teamwork.PadInfo;
import com.tencent.tim.widget.PullRefreshHeader;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.PinnedDividerSwipListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class CloudFileSendRecvActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, auhk.g
{
  private TextView FO;
  private View HI;
  private View Ko;
  private View Kp;
  private View Kq;
  List<FileManagerEntity> Kt = new ArrayList();
  private accn jdField_a_of_type_Accn;
  private atdt.a jdField_a_of_type_Atdt$a = new atgu(this);
  private ateh jdField_a_of_type_Ateh;
  private ativ jdField_a_of_type_Ativ;
  public atlz a;
  private auhr jdField_a_of_type_Auhr;
  private TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  private CloudFileSendRecvSyncer.a jdField_a_of_type_ComTencentTimCloudfileCloudFileSendRecvSyncer$a;
  private CloudSendBottomBar jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar;
  private aaja jdField_b_of_type_Aaja;
  private atjx jdField_b_of_type_Atjx;
  private auhh jdField_b_of_type_Auhh;
  private PullRefreshHeader jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader;
  private PinnedDividerSwipListView jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView;
  public int bQb = 0;
  private int cWx = -1;
  private boolean dfB;
  private boolean dhC;
  private boolean dhD;
  private volatile boolean dhE;
  public boolean dhF;
  protected boolean dhG;
  private boolean dhH;
  private boolean dhI;
  private boolean dhu;
  private boolean dhv;
  private boolean dhy;
  private int epB;
  private int epC;
  private RelativeLayout fD;
  private FileInfo h;
  Runnable io = new CloudFileSendRecvActivity.12(this);
  private ImageView lW;
  private RelativeLayout mRoot;
  private int type = -1;
  protected final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  private ImageView vq;
  private View xR;
  
  private void Vy(boolean paramBoolean)
  {
    int j = 1;
    this.Kp.setVisibility(8);
    this.Kq.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.i("SendRecvActivity", 2, "before get switch");
    }
    if (((CardHandler)this.app.getBusinessHandler(2)).a() == CardHandler.AutoSaveCloudStateGetPrg.GetSuc) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = aqmj.ac(this.app, "tim_cloudfile_autosave_flag");
      Object localObject = (atgc)this.app.getManager(373);
      int k = athu.a(this.app, this, (float)((atgc)localObject).it(), (float)((atgc)localObject).getTotalSpace(), 0, 2);
      if (k == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SendRecvActivity", 2, "has record upload failed, show top banner");
        }
        aap(k);
        i = 0;
      }
      for (;;)
      {
        if ((aqmj.e(this, this.app.getCurrentUin(), 2)) && (i == 0))
        {
          localObject = new athd(this);
          this.Kq.setVisibility(0);
          TextView localTextView = (TextView)this.Kq.findViewById(2131364729);
          FixSizeImageView localFixSizeImageView = (FixSizeImageView)this.Kq.findViewById(2131364728);
          SpannableString localSpannableString = new SpannableString(getString(2131691563));
          localSpannableString.setSpan(localObject, localSpannableString.length() - 6, localSpannableString.length(), 17);
          localTextView.setText(localSpannableString);
          localTextView.setMovementMethod(LinkMovementMethod.getInstance());
          localFixSizeImageView.setOnClickListener(new athe(this));
        }
        return;
        if ((this.dhG) && (bool) && (i != 0) && ((aqmj.aW(this, this.app.getCurrentUin())) || (this.dhI)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("SendRecvActivity", 2, "switch is on");
          }
          ets();
          this.dhI = true;
          i = j;
        }
        else if ((!bool) && (i != 0) && (aqmj.aV(this, this.app.getCurrentUin())))
        {
          if (QLog.isColorLevel()) {
            QLog.i("SendRecvActivity", 2, "switch is off");
          }
          etr();
          i = 0;
        }
        else
        {
          this.Kp.setVisibility(8);
          this.Kq.setVisibility(8);
          if (paramBoolean) {
            ThreadManager.post(this.io, 5, null, true);
          }
          i = 0;
        }
      }
    }
  }
  
  private void X(boolean paramBoolean, List<Long> paramList)
  {
    View localView1 = this.Ko.findViewById(2131364812);
    View localView2 = this.Ko.findViewById(2131364811);
    if (paramBoolean)
    {
      ThreadManager.getUIHandler().post(new CloudFileSendRecvActivity.14(this, localView1, paramList, localView2));
      return;
    }
    ThreadManager.getUIHandler().post(new CloudFileSendRecvActivity.15(this));
  }
  
  private FileInfo a()
  {
    return this.h;
  }
  
  private void aC()
  {
    Drawable localDrawable1 = getResources().getDrawable(2130839371);
    Drawable localDrawable2 = getResources().getDrawable(2130839372);
    new ColorDrawable(0).setBounds(0, 0, localDrawable2.getIntrinsicWidth(), localDrawable2.getIntrinsicHeight());
    localDrawable1.setBounds(0, 0, localDrawable2.getIntrinsicWidth(), localDrawable2.getIntrinsicHeight());
    localDrawable2.setBounds(0, 0, localDrawable2.getIntrinsicWidth(), localDrawable2.getIntrinsicHeight());
    this.centerView.setText(getResources().getString(2131719501));
    this.FO = ((TextView)findViewById(2131369630));
  }
  
  private void aap(int paramInt)
  {
    this.Kp.setVisibility(0);
    TextView localTextView = (TextView)this.Kp.findViewById(2131364729);
    FixSizeImageView localFixSizeImageView = (FixSizeImageView)this.Kp.findViewById(2131364728);
    localTextView.setText("容量超出已停止同步，请及时清理。");
    localFixSizeImageView.setOnClickListener(new athf(this, paramInt));
  }
  
  private void ckE()
  {
    List localList = this.jdField_a_of_type_Auhr.hk();
    this.jdField_a_of_type_Atlz.setMode(0);
    this.jdField_a_of_type_Atlz.mx(localList);
    if ((this.dhF) && (this.jdField_b_of_type_Aaja != null))
    {
      if ((localList != null) && (localList.size() != 0)) {
        break label88;
      }
      this.jdField_b_of_type_Aaja.setShow(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ativ != null)
      {
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
        this.jdField_a_of_type_Ativ.setVisible(false);
      }
      return;
      label88:
      this.jdField_b_of_type_Aaja.setShow(true);
    }
    this.jdField_a_of_type_Ativ.setVisible(true);
  }
  
  private void etr()
  {
    this.Kp.setVisibility(0);
    TextView localTextView = (TextView)this.Kp.findViewById(2131364729);
    Object localObject1 = getResources().getString(2131691593);
    Object localObject2 = getResources().getString(2131691591);
    int i = ((String)localObject1).indexOf((String)localObject2);
    int j = ((String)localObject2).length();
    localObject1 = new SpannableString((CharSequence)localObject1);
    localObject2 = new ForegroundColorSpan(getResources().getColor(2131165781));
    try
    {
      ((SpannableString)localObject1).setSpan(localObject2, i, j + i, 33);
      label102:
      localTextView.setText((CharSequence)localObject1);
      localTextView.setOnClickListener(new athg(this));
      ((FixSizeImageView)this.Kp.findViewById(2131364728)).setOnClickListener(new athh(this));
      return;
    }
    catch (Exception localException)
    {
      break label102;
    }
  }
  
  private void ets()
  {
    this.Kp.setVisibility(0);
    TextView localTextView = (TextView)this.Kp.findViewById(2131364729);
    Object localObject1 = getResources().getString(2131691592);
    Object localObject2 = getResources().getString(2131691591);
    int i = ((String)localObject1).indexOf((String)localObject2);
    int j = ((String)localObject2).length();
    localObject1 = new SpannableString((CharSequence)localObject1);
    localObject2 = new ForegroundColorSpan(getResources().getColor(2131165781));
    try
    {
      ((SpannableString)localObject1).setSpan(localObject2, i, j + i, 33);
      label102:
      localTextView.setOnClickListener(new atgp(this));
      ((FixSizeImageView)this.Kp.findViewById(2131364728)).setOnClickListener(new atgq(this));
      aqmj.I(this, this.app.getCurrentUin(), false);
      return;
    }
    catch (Exception localException)
    {
      break label102;
    }
  }
  
  private void ett()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendRecvActivity", 2, "initSendRecvTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = new TabBarView(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnselectColor(getResources().getColor(2131165692));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131693844));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131693846));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(2, getString(2131693850));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(3, getString(2131693853));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(4, getString(2131693849));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(0);
  }
  
  private void initBottomBar()
  {
    if (!this.dhF)
    {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar = ((CloudSendBottomBar)findViewById(2131377980));
      IO(true);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setLeftAction(this.epC);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setRightAction(this.epB);
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setVisibility(0);
      return;
    }
    this.xR = LayoutInflater.from(this).inflate(2131560998, this.mRoot, false);
    this.mRoot.addView(this.xR);
    ((RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView.getLayoutParams()).addRule(2, 2131366191);
    this.xR.setVisibility(8);
    this.lW = ((ImageView)findViewById(2131366197));
    this.vq = ((ImageView)findViewById(2131366194));
    this.lW.setOnClickListener(this);
    this.vq.setOnClickListener(this);
  }
  
  private void initListView()
  {
    this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView = ((PinnedDividerSwipListView)findViewById(2131367047));
    this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView.setDivider(null);
    this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView.setDragEnable(true);
    this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView.setOverscrollHeader(getResources().getDrawable(2130839646));
    this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131563195, this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView, false));
    this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView.setOverScrollHeader(this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader);
    this.jdField_a_of_type_Ativ = new ativ(this, "sp_key_refresh_time_cloud_file" + Arrays.toString(a().Y()), this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView, this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader, new atgx(this));
    this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView.setOnScrollListener(this.jdField_a_of_type_Ativ);
    this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView.setOverScrollListener(this.jdField_a_of_type_Ativ);
    if (this.dhF)
    {
      localObject = LayoutInflater.from(this).inflate(2131558989, this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
      this.Ko = ((View)localObject).findViewById(2131377556);
      this.Ko.setVisibility(8);
      this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView((View)localObject);
      this.Kp = LayoutInflater.from(this).inflate(2131558967, this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
      this.Kq = LayoutInflater.from(this).inflate(2131558988, this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView, false);
      localObject = new LinearLayout(this);
      ((LinearLayout)localObject).setOrientation(1);
      this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView((View)localObject);
      this.jdField_b_of_type_Aaja = new aaja(this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView, this.mRoot, this.fD, this, null, 31);
    }
    ett();
    Object localObject = new LinearLayout(this);
    ((LinearLayout)localObject).setOrientation(1);
    if (this.dhF) {
      ((LinearLayout)localObject).addView(this.Kp);
    }
    ((LinearLayout)localObject).addView(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView);
    this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView.addHeaderView((View)localObject);
  }
  
  private void nG(List<FileManagerEntity> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      localArrayList1.add(athu.a(this.app, localFileManagerEntity));
    }
    if (QLog.isColorLevel()) {
      QLog.i("SendRecvActivity", 2, "before checking " + paramList.size());
    }
    atgi.a().a(localArrayList1, new atgr(this, paramList, localArrayList2));
  }
  
  public void IO(boolean paramBoolean)
  {
    this.dfB = paramBoolean;
    etu();
  }
  
  public void IP(boolean paramBoolean)
  {
    this.dhC = paramBoolean;
    if (!paramBoolean)
    {
      this.rightViewText.setVisibility(8);
      this.xR.setVisibility(8);
      if (this.dhF) {
        Vz(true);
      }
      aC();
    }
    for (;;)
    {
      etu();
      return;
      Vz(false);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131693507);
      this.xR.setVisibility(0);
      this.lW.setEnabled(false);
      this.vq.setEnabled(false);
      this.leftView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      this.leftView.setText(getString(2131691565));
      this.centerView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      this.centerView.setTextSize(20.0F);
    }
  }
  
  public int Oo()
  {
    return this.bQb;
  }
  
  public boolean Pp()
  {
    return isResume();
  }
  
  protected void Vz(boolean paramBoolean)
  {
    this.dhD = paramBoolean;
    if (!paramBoolean) {
      this.rightViewText.setVisibility(8);
    }
  }
  
  public boolean akK()
  {
    return this.dhC;
  }
  
  public void b(FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_Atlz.GW.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof FileManagerEntity))
      {
        localObject = (FileManagerEntity)localObject;
        if ((((FileManagerEntity)localObject).cloudId != null) && (paramFileManagerEntity.cloudId != null) && (Arrays.equals(((FileManagerEntity)localObject).cloudId, paramFileManagerEntity.cloudId)))
        {
          ((FileManagerEntity)localObject).setfProgress(paramFileManagerEntity.getfProgress());
          ((FileManagerEntity)localObject).status = paramFileManagerEntity.status;
          if ((paramBoolean) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).strFilePath)) && (!TextUtils.isEmpty(paramFileManagerEntity.strFilePath))) {
            ((FileManagerEntity)localObject).strFilePath = paramFileManagerEntity.strFilePath;
          }
        }
      }
    }
    ThreadManager.getUIHandler().post(new CloudFileSendRecvActivity.22(this, paramBoolean, paramString));
  }
  
  public void dfI()
  {
    setTitle(String.format("已选 %d 项", new Object[] { Integer.valueOf(atiz.Ou()) }));
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 4) {
      if (paramIntent == null) {
        break label202;
      }
    }
    label202:
    for (paramIntent = (FileInfo)paramIntent.getParcelableExtra("key_selected_dir");; paramIntent = null)
    {
      if ((paramIntent != null) && (atiz.Ou() > 0))
      {
        Iterator localIterator = atiz.eo().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          if ((localObject instanceof PadInfo)) {
            ((ateh)this.app.getBusinessHandler(180)).a(paramIntent.Y(), athu.a((PadInfo)localObject));
          } else if (((localObject instanceof FileManagerEntity)) && (this.jdField_b_of_type_Auhh != null) && (paramIntent.Y() != null)) {
            this.jdField_b_of_type_Auhh.a(((FileManagerEntity)localObject).cloudFile.pLogicDirKey, aueh.a((FileManagerEntity)localObject), paramIntent.Y(), 4);
          }
        }
        atiz.clearSelected();
      }
      return;
      if (paramInt1 == 10)
      {
        ((atgc)this.app.getManager(373)).nD(this.jdField_a_of_type_Atlz.GW);
        this.jdField_a_of_type_Atlz.notifyDataSetChanged();
        return;
      }
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
  }
  
  public void doOnBackPressed()
  {
    if (this.dhC)
    {
      IP(false);
      return;
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.dhF = getIntent().getBooleanExtra("send_recv", false);
    this.dhG = getIntent().getBooleanExtra("bSendRecvSyncActivityEnter", false);
    this.jdField_a_of_type_Ateh = ((ateh)this.app.getBusinessHandler(180));
    setContentView(2131561028);
    this.h = ((FileInfo)getIntent().getParcelableExtra("key_file_info"));
    aC();
    this.leftView.setOnClickListener(new atgo(this));
    this.rightViewText.setOnClickListener(new atgy(this));
    initContentView();
    this.epB = getIntent().getIntExtra("key_bottom_bar_right_action", 0);
    this.epC = getIntent().getIntExtra("key_bottom_bar_left_action", 2);
    initBottomBar();
    if (this.dhF)
    {
      Vy(true);
      IP(false);
      if (this.jdField_a_of_type_ComTencentTimCloudfileCloudFileSendRecvSyncer$a == null)
      {
        this.jdField_a_of_type_ComTencentTimCloudfileCloudFileSendRecvSyncer$a = new athb(this);
        CloudFileSendRecvSyncer.a().addObserver(this.jdField_a_of_type_ComTencentTimCloudfileCloudFileSendRecvSyncer$a);
      }
      if (this.jdField_a_of_type_Accn == null)
      {
        this.jdField_a_of_type_Accn = new athc(this);
        this.app.addObserver(this.jdField_a_of_type_Accn);
      }
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ThreadManager.remove(this.io);
    if (this.jdField_a_of_type_Auhr != null) {
      this.jdField_a_of_type_Auhr.destroy();
    }
    if (this.jdField_b_of_type_Atjx != null) {
      this.jdField_b_of_type_Atjx.onDestroy();
    }
    if (this.jdField_a_of_type_Atlz != null) {
      this.jdField_a_of_type_Atlz.onDestroy();
    }
    if (this.dhF) {
      atiz.clearSelected();
    }
    if (this.jdField_a_of_type_ComTencentTimCloudfileCloudFileSendRecvSyncer$a != null)
    {
      CloudFileSendRecvSyncer.a().deleteObserver(this.jdField_a_of_type_ComTencentTimCloudfileCloudFileSendRecvSyncer$a);
      this.jdField_a_of_type_ComTencentTimCloudfileCloudFileSendRecvSyncer$a = null;
    }
    if ((this.jdField_a_of_type_Accn != null) && (this.app != null))
    {
      this.app.removeObserver(this.jdField_a_of_type_Accn);
      this.jdField_a_of_type_Accn = null;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar != null) {
      this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.doOnPause();
    }
  }
  
  public void doOnResume()
  {
    this.dhE = true;
    if (this.dhF) {
      if (this.dhH) {
        Vy(false);
      }
    }
    for (;;)
    {
      super.doOnResume();
      this.dhH = true;
      return;
      IO(true);
      if (this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar != null) {
        this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.doOnPause();
      }
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.dhE = false;
  }
  
  public void etu()
  {
    if ((akK()) || (this.dfB))
    {
      this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView.setDragEnable(false);
      this.jdField_a_of_type_Atlz.Vq(true);
    }
    do
    {
      return;
      this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView.setDragEnable(true);
      this.jdField_a_of_type_Atlz.Vq(false);
    } while (!this.dhF);
    atiz.clearSelected();
  }
  
  public void etv()
  {
    Object localObject2 = atiz.el();
    if (((List)localObject2).size() == 0) {
      return;
    }
    atgz localatgz = new atgz(this, (List)localObject2);
    atha localatha = new atha(this);
    Object localObject1 = getString(2131691611);
    if (((List)localObject2).size() == 1)
    {
      localObject2 = (atiu)((List)localObject2).get(0);
      if (((atiu)localObject2).getCloudFileType() == 0) {
        localObject1 = getString(2131691611);
      }
    }
    for (;;)
    {
      aqha.a(this, 230, null, (String)localObject1, localatgz, localatha).show();
      return;
      if (((atiu)localObject2).getCloudFileType() == 1)
      {
        localObject1 = (atin)localObject2;
        int i = ((atin)localObject1).subDirCount + ((atin)localObject1).subFileCount;
        if (i > 0)
        {
          localObject1 = getString(2131691609, new Object[] { ((atin)localObject1).name, Integer.valueOf(i) });
        }
        else
        {
          localObject1 = getString(2131691610, new Object[] { ((atin)localObject1).name });
          continue;
          localObject1 = ((List)localObject2).iterator();
          int j = 0;
          i = 0;
          label210:
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (!(localObject2 instanceof atin)) {
              break label326;
            }
            localObject2 = (atin)localObject2;
            j = ((atin)localObject2).subDirCount;
            j = i + (((atin)localObject2).subFileCount + j);
            i = 1;
          }
          for (;;)
          {
            int k = j;
            j = i;
            i = k;
            break label210;
            if (i > 0)
            {
              localObject1 = getString(2131691607, new Object[] { Integer.valueOf(i) });
              break;
            }
            if (j != 0)
            {
              localObject1 = getString(2131691608);
              break;
            }
            localObject1 = getString(2131691611);
            break;
            label326:
            k = i;
            i = j;
            j = k;
          }
        }
      }
    }
  }
  
  public void etw()
  {
    ArrayList localArrayList = atiz.el();
    if (localArrayList.size() == 0) {
      return;
    }
    localArrayList = new ArrayList(localArrayList);
    this.jdField_b_of_type_Auhh.nS(localArrayList);
    IP(false);
  }
  
  public void etx()
  {
    this.Kt.clear();
    this.Kt.addAll(atiz.el());
    if (this.Kt.size() == 0) {
      return;
    }
    Iterator localIterator = this.Kt.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      this.jdField_a_of_type_Auhr.bF(localObject);
    }
    IP(false);
  }
  
  public void f(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Ativ != null) {
      this.jdField_a_of_type_Ativ.cG(paramBoolean1, paramBoolean2);
    }
    if (paramInt == 1) {
      this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView.springBackOverScrollHeaderView();
    }
    if (paramInt == 2) {
      this.dhy = false;
    }
    if (paramInt == -1) {
      this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView.springBackOverScrollHeaderView();
    }
    ckE();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label81:
    do
    {
      return true;
      if (this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader != null)
      {
        if (paramMessage.arg1 != 1) {
          break label81;
        }
        this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader.tT(0);
      }
      for (;;)
      {
        paramMessage = new Message();
        paramMessage.what = 112;
        this.uiHandler.sendMessageDelayed(paramMessage, 500L);
        return true;
        this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader.tT(1);
      }
    } while (this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView == null);
    this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView.springBackOverScrollHeaderView();
    return true;
  }
  
  public void initContentView()
  {
    this.mRoot = ((RelativeLayout)findViewById(2131377546));
    this.fD = ((RelativeLayout)findViewById(2131377361));
    this.HI = findViewById(2131370942);
    this.HI.setOnClickListener(this);
    this.jdField_a_of_type_Auhr = new auhr(this.app, this, a().Y(), this.type);
    this.jdField_a_of_type_Auhr.create();
    this.jdField_b_of_type_Atjx = new atjx(this.app, this, this);
    this.jdField_b_of_type_Auhh = ((auhh)this.jdField_b_of_type_Atjx.a(2));
    this.dhv = true;
    this.jdField_a_of_type_Atlz = new atlz(this.app, this, this);
    this.jdField_a_of_type_Atlz.a(this.jdField_a_of_type_Atdt$a);
    initListView();
    this.jdField_a_of_type_Atlz.setMode(3);
    this.jdField_b_of_type_ComTencentWidgetPinnedDividerSwipListView.setAdapter(this.jdField_a_of_type_Atlz);
    this.jdField_a_of_type_Atlz.setOnClickListener(this.jdField_a_of_type_Auhr);
    if (this.dhF) {
      this.jdField_a_of_type_Atlz.setOnLongClickListener(new atgv(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(new atgw(this));
    if (!this.dhF)
    {
      atsj localatsj = (atsj)this.app.a().a(3);
      if (localatsj != null) {
        this.cWx = localatsj.Ox();
      }
    }
    if ((this.cWx >= 0) && (this.cWx <= 4))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(this.cWx, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
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
      if (!aqiw.isNetSupport(this))
      {
        ahav.JI(getString(2131694663));
      }
      else
      {
        etx();
        continue;
        if (!aqiw.isNetSupport(this))
        {
          ahav.JI(getString(2131694663));
        }
        else
        {
          etw();
          continue;
          etv();
        }
      }
    }
  }
  
  public void onLoading()
  {
    this.jdField_a_of_type_Atlz.setMode(3);
    this.jdField_a_of_type_Atlz.notifyDataSetChanged();
    if (this.bQb != 0)
    {
      this.jdField_a_of_type_Auhr.euX();
      return;
    }
    if (this.dhv)
    {
      this.jdField_a_of_type_Auhr.initData();
      this.dhv = false;
      return;
    }
    this.jdField_a_of_type_Auhr.VN(true);
  }
  
  public void qw(String paramString)
  {
    if (this.dhE) {
      QQToast.a(this.app.getApp(), 1, paramString, 0).show(getTitleBarHeight());
    }
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
    if (this.jdField_a_of_type_Auhr != null) {
      this.jdField_a_of_type_Auhr.setType(paramInt);
    }
  }
  
  public void showSuccessToast(String paramString)
  {
    if (this.dhE) {
      QQToast.a(this.app.getApp(), 2, paramString, 0).show(getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileSendRecvActivity
 * JD-Core Version:    0.7.0.1
 */