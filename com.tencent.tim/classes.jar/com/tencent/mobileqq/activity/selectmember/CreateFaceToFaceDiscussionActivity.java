package com.tencent.mobileqq.activity.selectmember;

import aawo;
import aawq;
import aawr;
import aaws;
import aawt;
import aawu;
import aawv;
import acff;
import acfp;
import achz;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import anot;
import aqdf;
import aqdf.a;
import aqgv;
import aqhu;
import aqiw;
import arhz;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mqq.os.MqqHandler;
import tencent.im.nearfield_discuss.nearfield_discuss.GPS;
import tencent.im.nearfield_discuss.nearfield_discuss.LBSInfo;
import tencent.im.nearfield_discuss.nearfield_discuss.UserProfile;

public class CreateFaceToFaceDiscussionActivity
  extends LbsBaseActivity
  implements View.OnClickListener, aqdf.a
{
  private TextView Bi;
  public TranslateAnimation E;
  private TextView GS;
  final int MSG_SHOW_TOAST = 2;
  public TextView OB;
  public TextView OC;
  public TextView OD;
  public int TYPE_DISCUSS = 0;
  private achz jdField_a_of_type_Achz = new aawu(this);
  public a a;
  nearfield_discuss.LBSInfo jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$LBSInfo;
  public nearfield_discuss.UserProfile a;
  public boolean aCH = true;
  BroadcastReceiver aU;
  public LinearLayout aV;
  public int aea = -1;
  AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
  TableLayout jdField_b_of_type_AndroidWidgetTableLayout;
  boolean bAA = false;
  public boolean bAB;
  private boolean bAC;
  public boolean bAD = true;
  acff c;
  public TableLayout c;
  public arhz c;
  final int cmj = 0;
  final int cmk = 1;
  final int cml = 50;
  final int cmm = 11;
  public int cmn = 0;
  aqdf d;
  private Bitmap dk;
  private Runnable fm = new CreateFaceToFaceDiscussionActivity.3(this);
  public Button fo;
  View gk;
  TranslateAnimation h;
  public LinearLayout hZ;
  public StringBuffer j = new StringBuffer(4);
  public GridView k;
  public ImageView ku;
  public Context mContext;
  public Handler mHandler = new aaws(this);
  public long mInterval = 60000L;
  public Drawable mProgressDrawable;
  private TextView mRightBtn;
  private TextView mTitle;
  public View progress;
  StringBuilder sb = new StringBuilder();
  public List<nearfield_discuss.UserProfile> vx = new ArrayList();
  public ImageView wA;
  public ImageView wB;
  public ImageView wC;
  public ImageView wD;
  public ImageView wE;
  public ImageView wF;
  public ImageView wG;
  public ImageView wH;
  public ImageView wI;
  public ImageView wJ;
  public ImageView wK;
  public ImageView wL;
  public ImageView wM;
  public ImageView wz;
  
  private void Ad()
  {
    this.wD = ((ImageView)findViewById(2131372626));
    this.wE = ((ImageView)findViewById(2131381039));
    this.wF = ((ImageView)findViewById(2131379627));
    this.wG = ((ImageView)findViewById(2131367551));
    this.wH = ((ImageView)findViewById(2131367141));
    this.wI = ((ImageView)findViewById(2131378458));
    this.wJ = ((ImageView)findViewById(2131378156));
    this.wK = ((ImageView)findViewById(2131366299));
    this.wL = ((ImageView)findViewById(2131372400));
    this.wM = ((ImageView)findViewById(2131382432));
    this.ku = ((ImageView)findViewById(2131365697));
    this.wD.setOnClickListener(this);
    this.wE.setOnClickListener(this);
    this.wF.setOnClickListener(this);
    this.wG.setOnClickListener(this);
    this.wH.setOnClickListener(this);
    this.wI.setOnClickListener(this);
    this.wJ.setOnClickListener(this);
    this.wK.setOnClickListener(this);
    this.wL.setOnClickListener(this);
    this.wM.setOnClickListener(this);
    this.ku.setOnClickListener(this);
    this.wz = ((ImageView)findViewById(2131365921));
    this.wA = ((ImageView)findViewById(2131365923));
    this.wB = ((ImageView)findViewById(2131365922));
    this.wC = ((ImageView)findViewById(2131365920));
    this.progress = findViewById(2131373699);
    this.mProgressDrawable = getResources().getDrawable(2130839657);
    this.hZ = ((LinearLayout)findViewById(2131365375));
    this.OD = ((TextView)findViewById(2131382312));
    this.fo = ((Button)findViewById(2131365522));
    this.fo.setOnClickListener(this);
    this.OB = ((TextView)findViewById(2131379598));
    this.jdField_b_of_type_AndroidWidgetTableLayout = ((TableLayout)findViewById(2131365909));
    this.jdField_c_of_type_AndroidWidgetTableLayout = ((TableLayout)findViewById(2131372582));
    this.OC = ((TextView)findViewById(2131379600));
    this.OC.setVisibility(4);
    this.gk = findViewById(2131365997);
    this.gk.setVisibility(4);
    this.mTitle = ((TextView)findViewById(2131369627));
    this.mTitle.setText(getString(2131689888));
    this.mTitle.setContentDescription(getString(2131689888));
    this.Bi = ((TextView)findViewById(2131369579));
    this.GS = ((TextView)findViewById(2131369581));
    this.mRightBtn = ((TextView)findViewById(2131369612));
    this.mTitle.setText(getString(2131689891));
    this.mTitle.setContentDescription(getString(2131689891));
    this.OB.setText(getString(2131719419));
    this.OB.setContentDescription(getString(2131719419));
    this.OC.setText(getString(2131719420));
    this.OC.setContentDescription(getString(2131719420));
    if (this.bAC)
    {
      this.Bi.setVisibility(0);
      this.mRightBtn.setVisibility(4);
      this.GS.setVisibility(4);
      this.Bi.setText(2131691039);
      this.Bi.setContentDescription(acfp.m(2131704517));
      this.Bi.setOnClickListener(new aawq(this));
    }
    for (;;)
    {
      this.aV = ((LinearLayout)findViewById(2131363674));
      this.aV.setVisibility(4);
      return;
      this.Bi.setVisibility(4);
      this.GS.setVisibility(4);
      this.mRightBtn.setVisibility(0);
      this.mRightBtn.setText(2131721058);
      this.mRightBtn.setContentDescription(acfp.m(2131704514));
      this.mRightBtn.setOnClickListener(new aawr(this));
    }
  }
  
  private void GK(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        requestPermissions(new aawv(this, paramInt), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      GL(paramInt);
      return;
    }
    GL(paramInt);
  }
  
  private void GL(int paramInt)
  {
    ThreadManager.post(new CreateFaceToFaceDiscussionActivity.10(this, paramInt), 8, null, false);
  }
  
  private nearfield_discuss.LBSInfo a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramSosoLbsInfo == null) {
      paramSosoLbsInfo = this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$LBSInfo;
    }
    nearfield_discuss.LBSInfo localLBSInfo;
    do
    {
      return paramSosoLbsInfo;
      localLBSInfo = new nearfield_discuss.LBSInfo();
      nearfield_discuss.GPS localGPS = new nearfield_discuss.GPS();
      localGPS.int32_lat.set((int)(paramSosoLbsInfo.a.cd * 1000000.0D));
      localGPS.int32_lon.set((int)(paramSosoLbsInfo.a.ce * 1000000.0D));
      localGPS.int32_alt.set(-1);
      localGPS.eType.set(1);
      localLBSInfo.msg_gps.set(localGPS);
      localStringBuffer.append(" GPS: ").append(paramSosoLbsInfo.a.cd * 1000000.0D).append(",").append(paramSosoLbsInfo.a.ce * 1000000.0D);
      this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$LBSInfo = localLBSInfo;
      paramSosoLbsInfo = localLBSInfo;
    } while (!QLog.isColorLevel());
    QLog.i("CreateFaceToFaceDiscussionActivity", 2, localStringBuffer.toString());
    return localLBSInfo;
  }
  
  private void a(View paramView, nearfield_discuss.UserProfile paramUserProfile)
  {
    String str = String.valueOf(paramUserProfile.uint64_uin.get());
    paramUserProfile = paramUserProfile.str_nick.get();
    b localb = (b)paramView.getTag();
    Bitmap localBitmap = this.d.b(1, str);
    paramView = localBitmap;
    if (localBitmap == null)
    {
      this.d.a(str, 1, false, (byte)1);
      if (this.dk == null) {
        this.dk = aqhu.G();
      }
      paramView = this.dk;
    }
    localb.up.setImageBitmap(paramView);
    if (this.jdField_c_of_type_Acff == null) {
      this.jdField_c_of_type_Acff = ((acff)this.app.getManager(51));
    }
    if ((str != null) && (this.jdField_c_of_type_Acff.isFriend(str))) {}
    for (paramView = aqgv.s(this.app, str);; paramView = paramUserProfile)
    {
      localb.KX.setText(paramView);
      ViewCompat.setImportantForAccessibility(localb.KX, 1);
      ViewCompat.setImportantForAccessibility(localb.up, 1);
      localb.KX.setContentDescription(paramView);
      localb.up.setContentDescription(paramView + acfp.m(2131704515));
      localb.uin = str;
      return;
    }
  }
  
  private void a(nearfield_discuss.UserProfile paramUserProfile)
  {
    if (paramUserProfile == null) {}
    String str1;
    String str2;
    do
    {
      return;
      str1 = this.app.getAccount();
      str2 = aqgv.B(this.app, str1);
      paramUserProfile.str_nick.set(str2);
    } while ((!TextUtils.isEmpty(str2)) && (!TextUtils.equals(str2, str1)));
    ThreadManager.getSubThreadHandler().post(this.fm);
  }
  
  private void czT()
  {
    this.bAB = true;
    if (this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.2F);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(400L);
    }
    this.OB.setAnimation(this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_b_of_type_AndroidWidgetTableLayout.setAnimation(this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.start();
    this.jdField_b_of_type_AndroidWidgetTableLayout.setVisibility(4);
    this.OC.setVisibility(0);
    this.gk.setVisibility(0);
    this.E = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.OB.getBottom());
    this.E.setAnimationListener(new aawt(this));
    this.E.setDuration(500L);
    this.hZ.setAnimation(this.E);
    this.h = new TranslateAnimation(0.0F, 0.0F, this.aV.getHeight(), 0.0F);
    this.h.setDuration(500L);
    this.aV.setAnimation(this.h);
    this.aV.setVisibility(0);
    anot.a(this.app, "CliOper", "", "", "0X80041AA", "0X80041AA", 0, 0, this.j.toString(), "", "", "");
  }
  
  private void czU()
  {
    int i = 1;
    if (aqiw.isNetSupport(this))
    {
      this.jdField_c_of_type_Arhz = new arhz(this, getResources().getDimensionPixelSize(2131299627));
      this.jdField_c_of_type_Arhz.setMessage(2131721338);
      this.jdField_c_of_type_Arhz.show();
      if (this.aCH) {}
      for (;;)
      {
        GK(i);
        return;
        i = 0;
      }
    }
    aL(1, getString(2131696348));
  }
  
  private void gg(View paramView)
  {
    b localb = (b)paramView.getTag();
    localb.up.setImageResource(2130846117);
    localb.KX.setText(null);
    localb.uin = "";
    ViewCompat.setImportantForAccessibility(localb.KX, 2);
    ViewCompat.setImportantForAccessibility(localb.up, 2);
    ViewCompat.setImportantForAccessibility(paramView, 2);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131755343);
    super.doOnCreate(paramBundle);
    setContentView(2131563057);
    this.mContext = getApplicationContext();
    paramBundle = getIntent();
    this.cmn = paramBundle.getIntExtra("create_source", 0);
    this.bAC = paramBundle.getBooleanExtra("fromFace2FaceActivity", false);
    Ad();
    this.app.addObserver(this.jdField_a_of_type_Achz);
    this.aea = Math.abs(new Random().nextInt());
    this.d = new aqdf(this, this.app);
    this.d.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity$a = new a();
    this.k = ((GridView)findViewById(2131368143));
    this.k.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity$a);
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile = new nearfield_discuss.UserProfile();
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile.uint64_uin.set(Long.parseLong(this.app.getAccount()));
    a(this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile);
    this.bAB = false;
    this.aU = new aawo(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    registerReceiver(this.aU, paramBundle);
    R(new CreateFaceToFaceDiscussionActivity.2(this));
    anot.a(this.app, "dc00899", "Grp_create_new", "", "face_create", "exp", 0, 0, "", "" + this.cmn, "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Achz);
    this.mHandler.removeMessages(1);
    ThreadManager.getSubThreadHandler().removeCallbacks(this.fm);
    if ((this.bAA) && (aqiw.isNetSupport(this))) {
      GK(4);
    }
    if (this.d != null)
    {
      this.d.destory();
      this.d = null;
    }
    try
    {
      unregisterReceiver(this.aU);
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      if (this.bAB)
      {
        anot.a(this.app, "CliOper", "", "", "0X80041AE", "0X80041AE", 0, 0, "", "", "", "");
        finish();
        if (this.bAC) {
          overridePendingTransition(2130772000, 2130772001);
        }
      }
    }
    for (;;)
    {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
      anot.a(this.app, "CliOper", "", "", "0X80041A9", "0X80041A9", 0, 0, "", "", "", "");
      break;
      switch (paramInt)
      {
      default: 
        break;
      case 7: 
        this.wM.performClick();
        break;
      case 8: 
        this.wD.performClick();
        break;
      case 9: 
        this.wE.performClick();
        break;
      case 10: 
        this.wF.performClick();
        break;
      case 11: 
        this.wG.performClick();
        break;
      case 12: 
        this.wH.performClick();
        break;
      case 13: 
        this.wI.performClick();
        break;
      case 14: 
        this.wJ.performClick();
        break;
      case 15: 
        this.wK.performClick();
        break;
      case 16: 
        this.wL.performClick();
        break;
      case 67: 
        this.ku.performClick();
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if ((this.bAB) && (this.mHandler.hasMessages(0))) {
      this.mHandler.removeMessages(0);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.bAB)
    {
      if (this.mHandler.hasMessages(0)) {
        this.mHandler.removeMessages(0);
      }
      this.mHandler.sendEmptyMessage(0);
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(16);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130771990);
  }
  
  public String getDescription()
  {
    int i = 0;
    this.sb.delete(0, this.sb.length());
    int m = this.j.length();
    if (m > 0) {
      while (i < m)
      {
        this.sb.append(this.j.charAt(i));
        if (i < m - 1) {
          this.sb.append(65292);
        }
        i += 1;
      }
    }
    return this.sb.toString();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365522)
    {
      this.bAA = false;
      czU();
      if (this.vx.size() == 0) {
        anot.a(this.app, "dc00899", "Grp_create_new", "", "suc_create", "clk_now", 0, 0, "", "" + this.cmn, "", "");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = this.j.length();
      if (i < 4)
      {
        label212:
        int m;
        switch (paramView.getId())
        {
        default: 
          this.jdField_c_of_type_AndroidWidgetTableLayout.setContentDescription(getDescription());
          m = this.j.length();
          i = -1;
          switch (this.j.charAt(m - 1))
          {
          }
          break;
        }
        for (;;)
        {
          switch (m)
          {
          default: 
            break;
          case 1: 
            this.wz.setImageResource(i);
            break;
            this.j.append('1');
            break label212;
            this.j.append('2');
            break label212;
            this.j.append('3');
            break label212;
            this.j.append('4');
            break label212;
            this.j.append('5');
            break label212;
            this.j.append('6');
            break label212;
            this.j.append('7');
            break label212;
            this.j.append('8');
            break label212;
            this.j.append('9');
            break label212;
            this.j.append('0');
            break label212;
            if ((i > 0) && (i < 4)) {
              this.j.deleteCharAt(i - 1);
            }
            this.jdField_c_of_type_AndroidWidgetTableLayout.setContentDescription(getDescription());
            switch (i)
            {
            }
            for (;;)
            {
              break;
              this.wz.setImageResource(2130846142);
              continue;
              this.wA.setImageResource(2130846142);
              continue;
              this.wB.setImageResource(2130846142);
              continue;
              this.wC.setImageResource(2130846142);
            }
            i = 2130846132;
            continue;
            i = 2130846133;
            continue;
            i = 2130846134;
            continue;
            i = 2130846135;
            continue;
            i = 2130846136;
            continue;
            i = 2130846137;
            continue;
            i = 2130846138;
            continue;
            i = 2130846139;
            continue;
            i = 2130846140;
            continue;
            i = 2130846141;
          }
        }
        this.wA.setImageResource(i);
        continue;
        this.wB.setImageResource(i);
        continue;
        this.wC.setImageResource(i);
        this.wD.setEnabled(false);
        this.wE.setEnabled(false);
        this.wF.setEnabled(false);
        this.wG.setEnabled(false);
        this.wH.setEnabled(false);
        this.wI.setEnabled(false);
        this.wJ.setEnabled(false);
        this.wK.setEnabled(false);
        this.wL.setEnabled(false);
        this.wM.setEnabled(false);
        this.ku.setEnabled(false);
        if ((this.j.toString().equals("1234")) || (this.j.toString().equals("1111")) || (this.j.toString().equals("2222")) || (this.j.toString().equals("3333")) || (this.j.toString().equals("0000")))
        {
          if (this.mHandler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
          }
          this.mHandler.sendEmptyMessageDelayed(1, 600L);
          QQToast.a(this.mContext, getString(2131721219), 0).show();
          anot.a(this.app, "CliOper", "", "", "0X80041AD", "0X80041AD", 0, 0, "", "", "", "");
        }
        else
        {
          this.progress.setVisibility(0);
          this.progress.setBackgroundDrawable(this.mProgressDrawable);
          ((Animatable)this.mProgressDrawable).start();
          if (aqiw.isNetSupport(this))
          {
            this.jdField_b_of_type_AndroidWidgetTableLayout.setEnabled(false);
            GK(2);
            this.bAA = true;
          }
          else
          {
            aL(1, getString(2131696348));
            ((Animatable)this.mProgressDrawable).stop();
            this.progress.setVisibility(4);
            if (this.mHandler.hasMessages(1)) {
              this.mHandler.removeMessages(1);
            }
            this.mHandler.sendEmptyMessageDelayed(1, 600L);
          }
        }
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramInt2 = this.k.getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      Object localObject = this.k.getChildAt(paramInt1).getTag();
      if ((localObject != null) && ((localObject instanceof b)))
      {
        localObject = (b)localObject;
        if (((b)localObject).uin.equals(paramString)) {
          ((b)localObject).up.setImageBitmap(paramBitmap);
        }
      }
      paramInt1 += 1;
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public class a
    extends BaseAdapter
  {
    CreateFaceToFaceDiscussionActivity.b a;
    LayoutInflater inflater = LayoutInflater.from(CreateFaceToFaceDiscussionActivity.this.mContext);
    
    public a() {}
    
    public int getCount()
    {
      if (CreateFaceToFaceDiscussionActivity.this.vx == null) {
        return 0;
      }
      if (CreateFaceToFaceDiscussionActivity.this.vx.size() < 50) {
        return CreateFaceToFaceDiscussionActivity.this.vx.size() + 1;
      }
      return CreateFaceToFaceDiscussionActivity.this.vx.size();
    }
    
    public Object getItem(int paramInt)
    {
      if (CreateFaceToFaceDiscussionActivity.this.vx == null) {
        return null;
      }
      return (nearfield_discuss.UserProfile)CreateFaceToFaceDiscussionActivity.this.vx.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = this.inflater.inflate(2131561366, null);
        this.a = new CreateFaceToFaceDiscussionActivity.b(CreateFaceToFaceDiscussionActivity.this);
        this.a.up = ((ImageView)paramView.findViewById(2131368698));
        this.a.KX = ((TextView)paramView.findViewById(2131372190));
        paramView.setTag(this.a);
      }
      label238:
      for (;;)
      {
        if ((paramInt == getCount() - 1) && (getCount() < 50)) {
          CreateFaceToFaceDiscussionActivity.a(CreateFaceToFaceDiscussionActivity.this, paramView);
        }
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          this.a = ((CreateFaceToFaceDiscussionActivity.b)paramView.getTag());
          if (!this.a.bAE) {
            break label238;
          }
          paramView = this.inflater.inflate(2131561366, null);
          this.a = new CreateFaceToFaceDiscussionActivity.b(CreateFaceToFaceDiscussionActivity.this);
          this.a.up = ((ImageView)paramView.findViewById(2131368698));
          this.a.KX = ((TextView)paramView.findViewById(2131372190));
          paramView.setTag(this.a);
          this.a.bAE = false;
          break;
          CreateFaceToFaceDiscussionActivity.a(CreateFaceToFaceDiscussionActivity.this, paramView, (nearfield_discuss.UserProfile)CreateFaceToFaceDiscussionActivity.this.vx.get(paramInt));
        }
      }
    }
  }
  
  class b
  {
    TextView KX;
    boolean bAE;
    String uin;
    ImageView up;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity
 * JD-Core Version:    0.7.0.1
 */