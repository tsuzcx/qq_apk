package com.tencent.mobileqq.vipav;

import acfp;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqcu;
import aqdf;
import aqdj;
import aqep;
import aqgv;
import aqha;
import aqhu;
import aqiq;
import aqju;
import aqpr;
import aqwu;
import aqxb;
import aqxc;
import aqxd;
import aqxe;
import aqxf;
import arhz;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x4Req;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import wja;

public class VipFunCallPreviewActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener, View.OnClickListener
{
  ImageView Fq;
  View Ji;
  View Jj;
  View Jk;
  View Jl;
  public View Jm;
  public View Jn;
  final String TAG = "VipFunCallPreviewActivity";
  TextView WH;
  aqdf jdField_a_of_type_Aqdf;
  aqiq jdField_a_of_type_Aqiq = aqiq.a();
  protected aqxb a;
  public VipFullScreenVideoView a;
  TextView abI;
  TextView abJ;
  long aub;
  public boolean cWL;
  boolean cWM;
  int cnz;
  final String cyt = "FT";
  public String cyu;
  public int eds;
  final int edt = 201605;
  public int edu;
  int feeType;
  View hO;
  public Button hy;
  Bundle mDialogData;
  public Handler mUiHandler = new aqxc(this, Looper.getMainLooper());
  public ArrayList<String> mUins = new ArrayList();
  arhz progessDialog;
  TextView titleTV;
  public String toUin;
  
  public VipFunCallPreviewActivity()
  {
    this.jdField_a_of_type_Aqxb = new aqxe(this);
  }
  
  void G(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VipFunCallPreviewActivity", 2, "showFriends uins == null");
      }
      return;
    }
    this.mUins.clear();
    Object localObject1 = (RelativeLayout)super.findViewById(2131382019);
    int i = ((RelativeLayout)localObject1).getChildCount() - 1;
    while (i >= 0)
    {
      localObject2 = ((RelativeLayout)localObject1).getChildAt(i);
      if ((localObject2 != null) && ((localObject2 instanceof ImageView)) && ("FT".equals(((View)localObject2).getTag()))) {
        ((RelativeLayout)localObject1).removeView((View)localObject2);
      }
      i -= 1;
    }
    Object localObject2 = paramArrayList.iterator();
    i = 0;
    label105:
    if (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (String)((Iterator)localObject2).next();
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        break label528;
      }
      this.mUins.add(localObject3);
      if (i >= 5) {
        break label528;
      }
      ImageView localImageView = new ImageView(this);
      localImageView.setTag("FT");
      localImageView.setImageBitmap(e((String)localObject3, 1));
      ((RelativeLayout)localObject1).addView(localImageView);
      localObject3 = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      int j = wja.dp2px(40.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject3).height = j;
      ((RelativeLayout.LayoutParams)localObject3).width = j;
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131373351);
      ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131373351);
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = wja.dp2px(i * 30, getResources());
      i += 1;
    }
    label528:
    for (;;)
    {
      break label105;
      localObject1 = (TextView)super.findViewById(2131381019);
      if (i > 0)
      {
        ((RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams()).leftMargin = wja.dp2px((i - 1) * 30 + 40 + 10, getResources());
        if (5 < paramArrayList.size()) {
          ((TextView)localObject1).setText(String.format(acfp.m(2131716764), new Object[] { Integer.valueOf(paramArrayList.size()) }));
        }
        for (;;)
        {
          ((TextView)localObject1).setVisibility(0);
          this.Jj.setVisibility(0);
          this.Jn.setVisibility(0);
          this.Jm.setVisibility(8);
          this.hy.setVisibility(8);
          if (!paramBoolean) {
            break;
          }
          if ((this.Jn instanceof Button)) {
            ((Button)this.Jn).setText(acfp.m(2131716748));
          }
          this.Jn.setEnabled(false);
          return;
          ((TextView)localObject1).setText(acfp.m(2131716754));
        }
        this.Jn.setEnabled(true);
        if (!(this.Jn instanceof Button)) {
          break;
        }
        ((Button)this.Jn).setText(acfp.m(2131716751));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("VipFunCallPreviewActivity", 2, "showFriends set views GONE");
      }
      ((TextView)localObject1).setVisibility(8);
      this.Jj.setVisibility(8);
      this.Jn.setVisibility(8);
      this.Jm.setVisibility(0);
      this.hy.setVisibility(0);
      return;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      QLog.e("VipFunCallPreviewActivity", 1, "doOnActivityResult, requestCode = " + paramInt1 + " resultCode = " + paramInt2);
      return;
    }
    Object localObject2 = this.app;
    paramInt1 = this.eds;
    if (paramIntent != null) {}
    for (Object localObject1 = "0";; localObject1 = "1")
    {
      VasWebviewUtil.reportVASTo00145((AppInterface)localObject2, String.valueOf(paramInt1), "preview", "ClickFriendsEdit", (String)localObject1, new String[0]);
      if (paramIntent == null) {
        break;
      }
      localObject2 = paramIntent.getParcelableArrayListExtra("result_set");
      localObject1 = null;
      paramIntent = (Intent)localObject1;
      if (localObject2 == null) {
        break label187;
      }
      paramIntent = (Intent)localObject1;
      if (((ArrayList)localObject2).size() <= 0) {
        break label187;
      }
      paramIntent = new ArrayList();
      localObject1 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramIntent.add(((ResultRecord)((Iterator)localObject1).next()).uin);
      }
    }
    label187:
    G(paramIntent, false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    int k = 0;
    Object localObject2 = null;
    super.doOnCreate(paramBundle);
    super.setContentView(2131563325);
    this.jdField_a_of_type_Aqdf = new aqdf(this, this.app);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      if ((paramBundle.hasExtra("callId")) && (paramBundle.hasExtra("key_to_uin")))
      {
        this.toUin = paramBundle.getStringExtra("key_to_uin");
        this.eds = paramBundle.getIntExtra("callId", 0);
      }
      if (paramBundle.hasExtra("ringId")) {
        this.cnz = paramBundle.getIntExtra("ringId", 0);
      }
    }
    for (paramBundle = paramBundle.getBundleExtra("bundle");; paramBundle = null)
    {
      if (this.eds <= 0)
      {
        QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate funcallid Error.");
        super.finish();
        return true;
      }
      if (paramBundle != null) {
        this.feeType = paramBundle.getInt("feeType");
      }
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = ((VipFullScreenVideoView)super.findViewById(2131381588));
      boolean bool = aqwu.a(this.app, 0, null).getBoolean("key_fun_call_soundon", true);
      String str;
      Object localObject1;
      int j;
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null)
      {
        this.edu = aqwu.getResourceType();
        str = aqwu.a(this.app, this.eds, this.edu, null);
        localObject1 = str;
        if (str == null)
        {
          localObject1 = str;
          if (paramBundle != null)
          {
            aqwu.a(this.app, this.eds, paramBundle, null, true);
            localObject1 = aqwu.a(this.app, this.eds, this.edu, null);
          }
        }
        if (localObject1 == null)
        {
          QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate resourceFilePath == null Error.");
          showTips(3, this.eds, null, acfp.m(2131716774), null, null, null);
          return true;
        }
        if (this.edu == 6) {
          if (aqwu.a(this, this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, (String)localObject1, this.edu, null, this.eds, true))
          {
            j = 0;
            i = j;
            if (bool)
            {
              ege();
              i = j;
            }
            label352:
            this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.setOnTouchListener(new aqxd(this));
          }
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          i = 1;
          label373:
          ThreadManager.post(new VipFunCallPreviewActivity.3(this, i), 8, null, true);
          this.Fq = ((ImageView)super.findViewById(2131363164));
          if (this.Fq != null) {
            this.Fq.setBackgroundDrawable(aqdj.a(this.app, 1, this.toUin));
          }
          this.WH = ((TextView)super.findViewById(2131363167));
          if (this.WH != null) {
            this.WH.setText(aqgv.o(this.app, this.toUin));
          }
          this.abI = ((TextView)super.findViewById(2131363159));
          this.titleTV = ((TextView)super.findViewById(2131366750));
          this.hO = super.findViewById(2131379771);
          this.abJ = ((TextView)super.findViewById(2131369579));
          this.abJ.setOnClickListener(this);
          this.Ji = super.findViewById(2131373351);
          this.Jj = super.findViewById(2131381018);
          this.Jk = super.findViewById(2131369906);
          this.Jl = super.findViewById(2131369905);
          this.Jm = super.findViewById(2131378117);
          this.Jn = super.findViewById(2131378115);
          this.Jj.setOnClickListener(this);
          this.Jk.setOnClickListener(this);
          this.Jl.setOnClickListener(this);
          if (!bool) {
            onClick(this.Jk);
          }
          this.Jm.setOnClickListener(this);
          this.Jn.setOnClickListener(this);
          this.hy = ((Button)super.findViewById(2131378116));
          this.hy.setOnClickListener(this);
          this.app.addObserver(this.jdField_a_of_type_Aqxb, false);
          if (aqwu.a(this.app, this.app.getAccount(), 6, true, null) != this.eds) {
            break label885;
          }
          this.Jn.setVisibility(0);
          if ((this.Jn instanceof Button)) {
            ((Button)this.Jn).setText(acfp.m(2131716757));
          }
          this.Jn.setEnabled(false);
          this.hy.setVisibility(8);
          this.Jm.setVisibility(8);
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(this.cyu)) {
            break label1129;
          }
          this.cyu = this.mUins.toString();
          return true;
          QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate VipFunCallManager.play Error.");
          j = 1;
          break;
          if (this.edu != 7) {
            break label1131;
          }
          paramBundle = aqcu.decodeFile((String)localObject1);
          if (paramBundle != null)
          {
            paramBundle = new BitmapDrawable(paramBundle);
            label831:
            if (paramBundle == null) {
              break label866;
            }
            this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.setBackgroundDrawable(paramBundle);
          }
          for (j = 0;; j = 1)
          {
            i = j;
            if (!bool) {
              break;
            }
            ege();
            i = j;
            break;
            paramBundle = null;
            break label831;
            label866:
            QLog.e("VipFunCallPreviewActivity", 1, "doOnCreate BitmapDrawable == null.");
          }
          i = 0;
          break label373;
          label885:
          localObject1 = aqwu.a(this.app, 1, null);
          if (localObject1 != null)
          {
            Object localObject3 = ((SharedPreferences)localObject1).getString("group", null);
            str = String.valueOf(this.eds);
            paramBundle = localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              paramBundle = localObject2;
              if (!TextUtils.isEmpty(str))
              {
                localObject3 = ((String)localObject3).split(",");
                i = 0;
              }
            }
            for (;;)
            {
              paramBundle = localObject2;
              if (i < localObject3.length)
              {
                if (str.equals(localObject3[i])) {
                  paramBundle = ((SharedPreferences)localObject1).getString("group_" + str, null);
                }
              }
              else
              {
                if (TextUtils.isEmpty(paramBundle)) {
                  break;
                }
                paramBundle = paramBundle.split(",");
                if ((paramBundle.length < 3) || (paramBundle[2].length() <= 2)) {
                  break;
                }
                paramBundle = paramBundle[2].split("-");
                localObject1 = new ArrayList();
                i = k;
                while (i < paramBundle.length)
                {
                  if ((paramBundle[i] != null) && (paramBundle[i].length() > 4)) {
                    ((ArrayList)localObject1).add(paramBundle[i]);
                  }
                  i += 1;
                }
              }
              i += 1;
            }
            Collections.sort((List)localObject1);
            this.cyu = ((ArrayList)localObject1).toString();
            G((ArrayList)localObject1, true);
          }
        }
        label1129:
        break;
        label1131:
        i = 0;
        break label352;
        i = 0;
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Aqxb);
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
    if ((this.jdField_a_of_type_Aqiq != null) && (!this.jdField_a_of_type_Aqiq.isPlaying())) {
      this.jdField_a_of_type_Aqiq.release();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if ((this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.isPlaying()) && (this.edu == 6)) {
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.pause();
    }
    if ((this.jdField_a_of_type_Aqiq != null) && (this.jdField_a_of_type_Aqiq.isPlaying())) {
      this.jdField_a_of_type_Aqiq.pause();
    }
  }
  
  @TargetApi(9)
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null) && (!this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.isPlaying()) && (this.edu == 6)) {
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.resume();
    }
    if ((this.jdField_a_of_type_Aqiq != null) && (!this.jdField_a_of_type_Aqiq.isPlaying())) {
      this.jdField_a_of_type_Aqiq.start();
    }
  }
  
  Bitmap e(String paramString, int paramInt)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Aqdf.b(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Aqdf.isPausing()) {
      this.jdField_a_of_type_Aqdf.i(paramString, paramInt, true);
    }
    return aqhu.G();
  }
  
  protected void ege()
  {
    if (this.jdField_a_of_type_Aqiq != null)
    {
      this.cWM = true;
      File localFile = new File(aqpr.p(this.cnz, 3));
      if (!localFile.exists()) {
        break label70;
      }
      this.jdField_a_of_type_Aqiq.a(getApplicationContext(), Uri.fromFile(localFile));
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqiq.bz(true);
      this.jdField_a_of_type_Aqiq.start();
      return;
      label70:
      this.jdField_a_of_type_Aqiq.a(getApplicationContext(), Uri.parse("android.resource://" + getPackageName() + "/" + 2131230756));
    }
  }
  
  public boolean onBackEvent()
  {
    Collections.sort(this.mUins);
    if ((!this.mUins.toString().equals(this.cyu)) && (showTips(5, this.eds, null, acfp.m(2131716756), null, null, null))) {
      return true;
    }
    super.onBackEvent();
    return false;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = 12;
    boolean bool = false;
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (this.mDialogData == null) {}
    int j;
    label160:
    label178:
    label249:
    do
    {
      String str;
      do
      {
        do
        {
          for (;;)
          {
            return;
            j = this.mDialogData.getInt("funcType", 4);
            str = this.mDialogData.getString("url");
            int k = this.mDialogData.getInt("fcID", this.eds);
            if (QLog.isColorLevel()) {
              QLog.d("VipFunCallPreviewActivity", 1, "DialogInterface funcType=" + j + ", url:" + str);
            }
            if ((1 != j) && (2 != j) && (12 != j) && (11 != j)) {
              break;
            }
            if (paramInt == 1)
            {
              if ((12 == j) || (11 == j))
              {
                paramInt = 1;
                if (paramInt == 0) {
                  break label275;
                }
                StringBuilder localStringBuilder = new StringBuilder();
                if (paramInt == 0) {
                  break label280;
                }
                str = "mvip.g.a.ld_n_";
                str = str + k;
                if (QLog.isColorLevel()) {
                  QLog.d("VipOpenVipDialog", 2, "onClick:aid=" + str);
                }
                if ((1 != j) && (11 != j)) {
                  break label294;
                }
                if (paramInt != 0) {
                  break label288;
                }
                bool = true;
                VipUtils.a(this, false, i, bool, str);
              }
              for (;;)
              {
                if (paramDialogInterface == null) {
                  break label312;
                }
                paramDialogInterface.dismiss();
                return;
                paramInt = 0;
                break;
                i = 3;
                break label160;
                str = "mvip.g.a.ld_xq_";
                break label178;
                bool = false;
                break label249;
                if (paramInt == 0) {
                  bool = true;
                }
                VipUtils.a(this, true, i, bool, str);
              }
            }
          }
          if (5 != j) {
            break;
          }
        } while (paramInt != 1);
        super.finish();
        return;
        if ((6 != j) && (4 != j)) {
          break;
        }
      } while ((paramInt != 1) || (TextUtils.isEmpty(str)));
      paramDialogInterface = new Intent(this, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", str);
      paramDialogInterface.putExtra("isShowAd", false);
      super.startActivity(paramDialogInterface);
      return;
    } while (3 != j);
    label275:
    label280:
    label288:
    label294:
    label312:
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.abJ == paramView)
      {
        if (!onBackEvent()) {
          super.finish();
        }
      }
      else
      {
        if (paramView != this.Jk) {
          break;
        }
        this.Jk.setVisibility(8);
        this.Jl.setVisibility(0);
        if ((this.jdField_a_of_type_Aqiq != null) && (this.jdField_a_of_type_Aqiq.isPlaying())) {
          this.jdField_a_of_type_Aqiq.pause();
        }
        aqwu.a(this.app, 0, null).edit().putBoolean("key_fun_call_soundon", false).commit();
      }
    }
    if (paramView == this.Jl)
    {
      this.Jk.setVisibility(0);
      this.Jl.setVisibility(8);
      if (this.cWM) {
        if ((this.jdField_a_of_type_Aqiq != null) && (!this.jdField_a_of_type_Aqiq.isPlaying())) {
          this.jdField_a_of_type_Aqiq.start();
        }
      }
      for (;;)
      {
        aqwu.a(this.app, 0, null).edit().putBoolean("key_fun_call_soundon", true).commit();
        break;
        ege();
      }
    }
    Object localObject2;
    Object localObject1;
    int i;
    if ((paramView == this.Jj) || (paramView == this.Jm)) {
      if (paramView == this.Jm)
      {
        localObject2 = aqwu.a(this.app, 1, null).getString("group", null);
        localObject1 = String.valueOf(this.eds);
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          localObject2 = ((String)localObject2).split(",");
          if (localObject2.length >= 5)
          {
            i = 0;
            label300:
            if (i >= localObject2.length) {
              break label726;
            }
            if (!((String)localObject1).equals(localObject2[i])) {}
          }
        }
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        showTips(6, this.eds, null, acfp.m(2131716762), null, null, null);
        VasWebviewUtil.reportVASTo00145(this.app, String.valueOf(this.eds), "preview", "ClickGroupList", "1", new String[0]);
        break;
        i += 1;
        break label300;
      }
      VasWebviewUtil.reportVASTo00145(this.app, String.valueOf(this.eds), "preview", "ClickGroupList", "0", new String[0]);
      localObject1 = new Intent(this, SelectMemberActivity.class);
      ((Intent)localObject1).putExtra("param_type", 8998);
      ((Intent)localObject1).putExtra("param_entrance", 22);
      ((Intent)localObject1).putExtra("param_only_friends", true);
      ((Intent)localObject1).putExtra("param_donot_need_contacts", true);
      ((Intent)localObject1).putExtra("param_uins_selected_friends", this.mUins);
      super.startActivityForResult((Intent)localObject1, 201605);
      break;
      if (paramView == this.hy)
      {
        long l = System.currentTimeMillis();
        if (l - this.aub <= 500L) {
          break;
        }
        this.aub = l;
        localObject1 = (aqxf)this.app.getBusinessHandler(46);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("callId", this.eds);
        ((Bundle)localObject2).putInt("ringId", this.cnz);
        ((Bundle)localObject2).putInt("from", 1);
        setProgessDialog(true, 2131721022);
        ((aqxf)localObject1).J(3, localObject2);
        break;
      }
      if (paramView != this.Jn) {
        break;
      }
      localObject1 = new VipFunCallAndRing.TSsoCmd0x4Req();
      localObject2 = new ArrayList();
      Iterator localIterator = this.mUins.iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject2).add(Long.valueOf(Long.parseLong((String)localIterator.next())));
      }
      ((VipFunCallAndRing.TSsoCmd0x4Req)localObject1).rpt_uins.set((List)localObject2);
      ((VipFunCallAndRing.TSsoCmd0x4Req)localObject1).i32_funcall_id.set(this.eds);
      ((VipFunCallAndRing.TSsoCmd0x4Req)localObject1).i32_ring_id.set(this.cnz);
      setProgessDialog(true, 2131721022);
      ((aqxf)this.app.getBusinessHandler(46)).J(4, localObject1);
      break;
      label726:
      i = -1;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      Object localObject = new Rect();
      super.getWindow().findViewById(16908290).getDrawingRect((Rect)localObject);
      ((Rect)localObject).width();
      ((Rect)localObject).height();
      aqep.dpToPx(this, 102);
      int i = aqep.e(getResources());
      if (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null) {
        this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.setVisibility(0);
      }
      if (this.hO != null)
      {
        localObject = (FrameLayout.LayoutParams)this.hO.getLayoutParams();
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          ((FrameLayout.LayoutParams)localObject).topMargin = i;
        }
        this.hO.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.Fq != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.Fq.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = (i + aqep.dpToPx(this, 25) + (int)getResources().getDimension(2131299627));
        this.Fq.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.WH != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.WH.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = aqep.dpToPx(this, 25);
        this.WH.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.abI != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.abI.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = aqep.dpToPx(this, 10);
        this.abI.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.titleTV != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.titleTV.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = aqep.dpToPx(this, 30);
        this.titleTV.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void setProgessDialog(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.progessDialog == null)
      {
        this.progessDialog = new arhz(this, getTitleBarHeight());
        this.progessDialog.setCancelable(true);
      }
      this.progessDialog.setMessage(paramInt);
      this.progessDialog.show();
    }
    while ((this.progessDialog == null) || (!this.progessDialog.isShowing())) {
      return;
    }
    this.progessDialog.dismiss();
  }
  
  public boolean showTips(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    boolean bool2 = false;
    this.mDialogData = new Bundle();
    this.mDialogData.putInt("funcType", paramInt1);
    this.mDialogData.putString("url", paramString5);
    this.mDialogData.putInt("fcID", paramInt2);
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = acfp.m(2131716773);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = acfp.m(2131716752);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString3)) {
          paramString3 = acfp.m(2131716747);
        }
        for (;;)
        {
          if (TextUtils.isEmpty(paramString4)) {
            paramString4 = acfp.m(2131716771);
          }
          for (;;)
          {
            paramString1 = aqha.a(this, 0, paramString1, paramString2, paramString3, paramString4, this, this);
            boolean bool1 = bool2;
            if (paramString1 != null)
            {
              bool1 = bool2;
              if (!super.isFinishing())
              {
                paramString1.show();
                bool1 = true;
              }
            }
            return bool1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFunCallPreviewActivity
 * JD-Core Version:    0.7.0.1
 */