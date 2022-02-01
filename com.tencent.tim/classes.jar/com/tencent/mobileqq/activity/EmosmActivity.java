package com.tencent.mobileqq.activity;

import acdz;
import acea;
import acfp;
import afie;
import afif;
import afkd;
import afkm;
import afkn;
import ajdg;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import anot;
import aqiw;
import arhz;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.emosm.view.DragSortListView.f;
import com.tencent.mobileqq.emosm.view.DragSortListView.j;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import uwh;
import uwi;
import uwj;
import uwk;
import uwl;
import uwm;
import uwn;
import uwo;
import uwp;
import uwq;
import uwr;

public class EmosmActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public TextView De;
  TextView Df;
  TextView Dg;
  public Button W;
  public afie<EmoticonPackage> a;
  afkm jdField_a_of_type_Afkm;
  afkn jdField_a_of_type_Afkn;
  DragSortListView.f jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$f = new uwk(this);
  DragSortListView.j jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$j = new uwl(this);
  public DragSortListView a;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  public boolean aVT;
  public boolean aVU;
  public boolean aVV = false;
  public boolean aVW;
  acea b = new uwh(this);
  public int bGO;
  public View bK;
  public ajdg c;
  public Runnable dP;
  public WeakReference<Activity> mActivity = new WeakReference(this);
  public int mLaunchMode;
  public ArrayList<EmoticonPackage> pg = new ArrayList();
  public arhz progressDialog;
  private View sA;
  View ss;
  View st;
  View su;
  View sv;
  View sw;
  public View sx;
  View sy;
  View sz;
  
  private void a(EmoticonResp paramEmoticonResp)
  {
    int i;
    if (paramEmoticonResp != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_Afie.getCount())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.jdField_a_of_type_Afie.getItem(i);
        if (!localEmoticonPackage.epId.equals(paramEmoticonResp.delEpId + "")) {
          break label88;
        }
        if (localEmoticonPackage.type != 1) {
          break label83;
        }
      }
      label83:
      for (i = 5;; i = 4)
      {
        ajdg.fd(String.valueOf(paramEmoticonResp.resultcode), i);
        return;
      }
      label88:
      i += 1;
    }
  }
  
  private void aH()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131363636));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131363636));
    this.sA = findViewById(2131378593);
    this.sA.setBackgroundColor(getResources().getColor(2131165783));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.iD(findViewById(2131366365));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.iE(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
    Drawable localDrawable = getResources().getDrawable(2130851351);
    localDrawable.setAlpha(235);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.ae(localDrawable);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.YI(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.bg(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.YK(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onCreate();
  }
  
  public void AG(int paramInt)
  {
    this.jdField_a_of_type_Afie.setNotifyOnChange(true);
    int i = 0;
    for (;;)
    {
      EmoticonPackage localEmoticonPackage;
      if (i < this.jdField_a_of_type_Afie.getCount())
      {
        localEmoticonPackage = (EmoticonPackage)this.jdField_a_of_type_Afie.getItem(i);
        if (!localEmoticonPackage.epId.equals(paramInt + "")) {
          break label177;
        }
        this.jdField_a_of_type_Afie.remove(localEmoticonPackage);
        if (localEmoticonPackage.type != 1) {
          break label172;
        }
      }
      label172:
      for (paramInt = 5;; paramInt = 4)
      {
        ajdg.fd("0", paramInt);
        String str = localEmoticonPackage.epId;
        if ((3 != localEmoticonPackage.jobType) && (1 != localEmoticonPackage.jobType) && (5 != localEmoticonPackage.jobType)) {
          ThreadManager.getFileThreadHandler().post(new EmosmActivity.2(this, str));
        }
        if (3 == localEmoticonPackage.jobType) {
          anot.a(this.app, "CliOper", "", "", "MbGuanli", "MbDianjiShanchu", 0, 0, "", "", "", "");
        }
        return;
      }
      label177:
      i += 1;
    }
  }
  
  public void AH(int paramInt)
  {
    if (this.mLaunchMode == paramInt) {
      return;
    }
    this.mLaunchMode = paramInt;
    this.aVW = false;
    runOnUiThread(this.dP);
  }
  
  public afif a(DragSortListView paramDragSortListView)
  {
    paramDragSortListView = new afif(paramDragSortListView);
    paramDragSortListView.setDragHandleId(2131366134);
    paramDragSortListView.setClickRemoveId(2131364671);
    paramDragSortListView.setRemoveEnabled(true);
    paramDragSortListView.setSortEnabled(true);
    paramDragSortListView.setDragInitMode(0);
    paramDragSortListView.setRemoveMode(0);
    paramDragSortListView.Mw(2);
    return paramDragSortListView;
  }
  
  public void bF()
  {
    if (this.aVU) {
      setTitle(String.format(getResources().getString(2131693337), new Object[] { Integer.valueOf(0) }));
    }
    this.progressDialog.dismiss();
    if ((this.mLaunchMode == 2) && (this.jdField_a_of_type_Afie.getCount() == 0)) {
      anot.a(this.app, "CliOper", "", "", "0X80060AA", "0X80060AA", 0, 0, "", "", "", "");
    }
  }
  
  public void bNE()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.setToastIcon(2130840061);
    localQQToast.setDuration(1500);
    localQQToast.setToastMsg(acfp.m(2131705796));
    localQQToast.show(0);
  }
  
  void bNF()
  {
    String str = super.getIntent().getStringExtra("options");
    try
    {
      if (TextUtils.isEmpty(str))
      {
        this.leftView.setText(2131693088);
        return;
      }
      str = new JSONObject(str).optString("leftText", getString(2131693088));
      this.leftView.setText(str);
      return;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmosmActivity", 2, localJSONException.getMessage());
      }
    }
  }
  
  public void bNG()
  {
    if (this.aVV) {
      return;
    }
    this.c.a(0, new uwr(this));
  }
  
  public void bNH()
  {
    if (this.aVW) {
      this.c.a(0, new uwj(this));
    }
  }
  
  void bcH()
  {
    if ((this.W != null) && (this.W.getVisibility() == 0)) {
      this.W.setEnabled(false);
    }
    this.c.a(0, new uwi(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559314);
    super.setContentBackgroundResource(2130838900);
    super.setTitle(2131693347);
    bNF();
    this.De = this.rightViewText;
    this.De.setVisibility(0);
    this.De.setText(2131693336);
    this.De.setOnClickListener(new uwm(this));
    this.W = ((Button)super.findViewById(2131364104));
    this.W.setOnClickListener(this);
    this.Df = ((TextView)super.findViewById(2131366620));
    this.Df.setOnClickListener(new uwn(this));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = ((DragSortListView)super.findViewById(16908298));
      paramBundle = a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setFloatViewManager(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnTouchListener(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDelImmediately(false);
      this.bK = View.inflate(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getContext(), 2131559315, null);
      this.ss = this.bK.findViewById(2131366354);
      this.st = this.bK.findViewById(2131366355);
      this.Dg = ((TextView)this.bK.findViewById(2131366356));
      this.ss.setOnClickListener(this);
      this.ss.setBackgroundDrawable(getResources().getDrawable(2130840170));
      this.su = this.bK.findViewById(2131366350);
      this.sv = this.bK.findViewById(2131366351);
      this.sw = this.bK.findViewById(2131366352);
      this.su.setOnClickListener(this);
      this.su.setBackgroundDrawable(getResources().getDrawable(2130840170));
      this.sx = this.bK.findViewById(2131366367);
      this.sy = this.bK.findViewById(2131366368);
      this.sz = this.bK.findViewById(2131366369);
      this.sx.setBackgroundResource(2130840170);
      this.sx.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.addHeaderView(this.bK);
      this.c = ((ajdg)this.app.getManager(14));
      paramBundle = super.getIntent();
      this.mLaunchMode = paramBundle.getIntExtra("extra_launch_mode", 1);
      this.dP = new EmosmActivity.5(this);
      this.dP.run();
      this.jdField_a_of_type_Afie = new afie(this, this.pg);
      this.jdField_a_of_type_Afie.cRa = -16745986;
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setAdapter(this.jdField_a_of_type_Afie);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDropListener(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$f);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setRemoveListener(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$j);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnItemClickListener(new uwo(this));
      this.aVT = false;
      this.jdField_a_of_type_Afkm = new uwp(this);
      afkd.a().a(this.jdField_a_of_type_Afkm);
      this.jdField_a_of_type_Afkn = new uwq(this);
      afkd.a().a(this.jdField_a_of_type_Afkn);
      this.bGO = paramBundle.getIntExtra("extra_launch_source", 2);
      if ((this.bGO == 2) || (this.bGO == 1))
      {
        this.W.setVisibility(8);
        this.aVU = false;
        this.De.setText(2131693336);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
        this.jdField_a_of_type_Afie.setEditMode(false);
        this.jdField_a_of_type_Afie.notifyDataSetChanged();
      }
      aH();
      AH(1);
      this.progressDialog = new arhz(this);
      super.addObserver(this.b);
      anot.a(this.app, "CliOper", "", "", "ep_mall", "View_mine", 0, 0, "", "", "", "");
      bool = true;
    }
    catch (OutOfMemoryError paramBundle)
    {
      do
      {
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = null;
      } while (!QLog.isColorLevel());
      QLog.e("EmosmActivity", 2, paramBundle.getMessage());
    }
    return bool;
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.b);
    afkd.a().b(this.jdField_a_of_type_Afkm);
    afkd.a().b(this.jdField_a_of_type_Afkn);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onDestroy();
    }
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmosmActivity", 2, "emosm activity ..............onPause");
    }
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onPause();
    }
  }
  
  public void doOnResume()
  {
    this.aVT = false;
    if (QLog.isColorLevel()) {
      QLog.d("EmosmActivity", 2, "emosm activity ..............onResume");
    }
    ((acdz)this.app.getBusinessHandler(12)).gT(0, 0);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.onResume();
    }
    super.doOnResume();
  }
  
  public void finish()
  {
    afkd.a().b(this.jdField_a_of_type_Afkm);
    afkd.a().b(this.jdField_a_of_type_Afkn);
    this.jdField_a_of_type_Afie.clearCache();
    super.finish();
  }
  
  public boolean onBackEvent()
  {
    if (this.mLaunchMode != 1)
    {
      if (this.aVU)
      {
        this.De.setText(2131693336);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
        this.jdField_a_of_type_Afie.setEditMode(false);
        this.aVU = false;
        this.W.setVisibility(8);
        xd(this.aVU);
      }
      AH(1);
      return true;
    }
    return super.onBackEvent();
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
      Object localObject1;
      if (!aqiw.isNetSupport(this))
      {
        localObject1 = new QQToast(this);
        ((QQToast)localObject1).setToastIcon(2130840061);
        ((QQToast)localObject1).setDuration(1500);
        ((QQToast)localObject1).setToastMsg(acfp.m(2131705795));
        ((QQToast)localObject1).show(0);
      }
      else
      {
        this.progressDialog.setMessage(getString(2131693100));
        this.progressDialog.show();
        Object localObject2 = this.jdField_a_of_type_Afie.eJ();
        if (((List)localObject2).size() > 0)
        {
          URLDrawable.clearMemoryCache();
          localObject1 = (acdz)this.app.getBusinessHandler(12);
          ArrayList localArrayList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            localArrayList.add(Integer.valueOf(Integer.parseInt(((EmoticonPackage)((Iterator)localObject2).next()).epId)));
          }
          ((acdz)localObject1).dB(localArrayList);
          this.W.setEnabled(false);
          if (QLog.isColorLevel()) {
            QLog.d("EmosmActivity", 2, "delete packages:" + localArrayList.toString());
          }
          anot.a(this.app, "CliOper", "", "", "EmosSetting", "EpDelete", 0, 0, "", "", "", "");
          if (this.mLaunchMode == 1)
          {
            anot.a(this.app, "dc00898", "", "", "0X800AB12", "0X800AB12", localArrayList.size(), 0, "", "", "", "");
          }
          else
          {
            anot.a(this.app, "dc00898", "", "", "0X800AB19", "0X800AB19", localArrayList.size(), 0, "", "", "", "");
            continue;
            startActivity(new Intent(this, FavEmosmManageActivity.class));
            anot.a(this.app, "dc00898", "", "", "0X800AB0B", "0X800AB0B", 0, 0, "", "", "", "");
            continue;
            localObject1 = new Intent(this, FavEmosmManageActivity.class);
            ((Intent)localObject1).putExtra("camera_emo_mode", 1);
            startActivity((Intent)localObject1);
            anot.a(this.app, "dc00898", "", "", "0X800AB0C", "0X800AB0C", 0, 0, "", "", "", "");
            continue;
            AH(2);
            anot.a(this.app, "dc00898", "", "", "0X800AB0D", "0X800AB0D", 0, 0, "", "", "", "");
          }
        }
      }
    }
  }
  
  protected void onRestart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "emosm activity ..............onRestart");
    }
    super.onRestart();
  }
  
  public void xd(boolean paramBoolean)
  {
    boolean bool2 = true;
    float f2 = 0.5F;
    Object localObject = this.st;
    float f1;
    label41:
    label61:
    label81:
    label101:
    label119:
    boolean bool1;
    if (paramBoolean)
    {
      f1 = 0.5F;
      ((View)localObject).setAlpha(f1);
      localObject = this.Dg;
      if (!paramBoolean) {
        break label190;
      }
      f1 = 0.5F;
      ((TextView)localObject).setAlpha(f1);
      localObject = this.sv;
      if (!paramBoolean) {
        break label195;
      }
      f1 = 0.5F;
      ((View)localObject).setAlpha(f1);
      localObject = this.sw;
      if (!paramBoolean) {
        break label200;
      }
      f1 = 0.5F;
      ((View)localObject).setAlpha(f1);
      localObject = this.sy;
      if (!paramBoolean) {
        break label205;
      }
      f1 = 0.5F;
      ((View)localObject).setAlpha(f1);
      localObject = this.sz;
      if (!paramBoolean) {
        break label210;
      }
      f1 = f2;
      ((View)localObject).setAlpha(f1);
      localObject = this.ss;
      if (paramBoolean) {
        break label215;
      }
      bool1 = true;
      label138:
      ((View)localObject).setEnabled(bool1);
      localObject = this.su;
      if (paramBoolean) {
        break label221;
      }
      bool1 = true;
      label158:
      ((View)localObject).setEnabled(bool1);
      localObject = this.sx;
      if (paramBoolean) {
        break label227;
      }
    }
    label190:
    label195:
    label200:
    label205:
    label210:
    label215:
    label221:
    label227:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((View)localObject).setEnabled(paramBoolean);
      return;
      f1 = 1.0F;
      break;
      f1 = 1.0F;
      break label41;
      f1 = 1.0F;
      break label61;
      f1 = 1.0F;
      break label81;
      f1 = 1.0F;
      break label101;
      f1 = 1.0F;
      break label119;
      bool1 = false;
      break label138;
      bool1 = false;
      break label158;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity
 * JD-Core Version:    0.7.0.1
 */