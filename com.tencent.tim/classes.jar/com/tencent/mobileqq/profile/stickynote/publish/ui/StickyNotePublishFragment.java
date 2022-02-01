package com.tencent.mobileqq.profile.stickynote.publish.ui;

import QC.SuixintieCheckInfo;
import QC.SuixintieCheckItem;
import acfp;
import aler;
import ales;
import alet;
import alet.b;
import alev;
import alew;
import alex;
import aley;
import alez;
import alfa;
import alfb;
import alfc;
import alfd;
import alfe;
import alff;
import alfg;
import alfh;
import alfi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import anlm;
import anot;
import aofk;
import aqha;
import aqiw;
import aqju;
import aqrn;
import aqro;
import aqry;
import aqsa;
import arhz;
import arml;
import aurd;
import avys;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout.a;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.profile.view.SoftInputDetectView.a;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ScrollView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jll;
import mqq.app.AppRuntime;
import wja;

public class StickyNotePublishFragment
  extends IphoneTitleBarFragment
  implements alet.b, Handler.Callback, View.OnClickListener, StickyNoteShopLayout.a, SoftInputDetectView.a
{
  private TextWatcher A = new alfi(this);
  private RecyclerView C;
  private View Ce;
  private List<alev> EU = new ArrayList();
  private CheckBox O;
  private TextView Xi;
  private arhz jdField_a_of_type_Arhz;
  private avys jdField_a_of_type_Avys = new aley(this);
  private StickyNoteShopLayout jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
  private alet jdField_b_of_type_Alet;
  private StickyNoteShopLayout jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
  private FrameLayout bP;
  private FrameLayout bz;
  private SoftInputDetectView c;
  private int cUE;
  private boolean caW = true;
  private boolean cwA;
  private boolean cwy;
  private boolean cwz = true;
  private EmoticonMainPanel d;
  private int dsL;
  private ScrollView f;
  private ImageView gR;
  private long hg;
  private XEditTextEx i;
  private LinearLayout iL;
  private ETTextView k;
  private TextView kq;
  private RelativeLayout ly;
  private RelativeLayout lz;
  private SuixintieCheckItem mClothesItem = new SuixintieCheckItem();
  private int mCurrentState = 0;
  private SuixintieCheckItem mFontItem = new SuixintieCheckItem();
  private RelativeLayout mRoot;
  public Handler mSubHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  Handler mUIHandler = new Handler(Looper.getMainLooper(), this);
  private aqrn mVasRes;
  private ImageView zg;
  private ImageView zh;
  
  private static EmoticonMainPanel b(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView, int paramInt, EditText paramEditText)
  {
    paramView = (EmoticonMainPanel)paramView.findViewById(paramInt);
    paramView.setCallBack(new alfe(paramEditText, paramQQAppInterface, paramBaseActivity));
    paramView.bYZ = true;
    paramView.bZc = true;
    paramView.bYX = false;
    paramView.bYY = true;
    paramView.bZb = true;
    paramView.a(paramQQAppInterface, 100002, paramBaseActivity, paramBaseActivity.getTitleBarHeight(), null, null, false, new alff());
    paramView.a.setOverScrollMode(2);
    return paramView;
  }
  
  public static void c(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    PublicFragmentActivity.startForResult(paramActivity, localIntent, StickyNotePublishFragment.class, paramInt);
  }
  
  private <T extends View> T findViewById(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  public void Ix(boolean paramBoolean)
  {
    FrameLayout localFrameLayout;
    if (this.bz != null)
    {
      localFrameLayout = this.bz;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int j = 0;; j = 8)
    {
      localFrameLayout.setVisibility(j);
      return;
    }
  }
  
  public void NF(boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    dcy();
    if (paramBoolean)
    {
      gA(this.d);
      this.d.setVisibility(0);
      this.gR.setImageResource(2130837612);
      this.gR.setContentDescription(getActivity().getString(2131690681));
      this.gR.setOnClickListener(new alfg(this));
      if (this.cUE > ankt.cIE / 4) {}
      for (int j = this.cUE;; j = ankt.cIE / 3)
      {
        ViewGroup.LayoutParams localLayoutParams = this.d.getLayoutParams();
        localLayoutParams.height = j;
        this.d.setMinimumHeight(localLayoutParams.height);
        this.d.setLayoutParams(localLayoutParams);
        this.iL.setVisibility(0);
        Nr(j);
        NG(false);
        return;
      }
    }
    this.d.setVisibility(8);
    this.gR.setImageResource(2130845718);
    this.gR.setContentDescription(getActivity().getString(2131690680));
    this.gR.setOnClickListener(new alfh(this));
  }
  
  public void NG(boolean paramBoolean)
  {
    if ((this.i == null) || (this.i.getText() == null)) {
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)this.bP.getLayoutParams();
    if (paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = wja.dp2px(60.0F, getResources());
      this.i.setVisibility(8);
      this.k.setVisibility(0);
      this.f.setVisibility(0);
      this.k.requestFocus();
      this.k.setText(this.i.getText().toString());
      if (this.dsL > 5)
      {
        this.k.setText(new aofk(this.i.getText().toString(), 3, 28));
        this.k.setTextSize(24.0F);
        if (!TextUtils.isEmpty(this.i.getText().toString())) {
          break label255;
        }
        ((FrameLayout.LayoutParams)this.f.getLayoutParams()).gravity = 48;
        label173:
        setFont(this.mFontItem.itemId, this.mFontItem.fontType);
        label191:
        if (!paramBoolean) {
          break label321;
        }
        localObject = this.lz;
        if (!this.cwy) {
          break label315;
        }
      }
    }
    label315:
    for (int j = 0;; j = 8)
    {
      ((RelativeLayout)localObject).setVisibility(j);
      return;
      this.k.setTextSize(28.0F);
      this.k.setText(new aofk(this.i.getText().toString(), 3, 28));
      break;
      label255:
      ((FrameLayout.LayoutParams)this.f.getLayoutParams()).gravity = 19;
      break label173;
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
      this.i.setVisibility(0);
      this.i.requestFocus();
      this.k.setVisibility(8);
      this.f.setVisibility(8);
      break label191;
    }
    label321:
    this.lz.setVisibility(8);
  }
  
  public void NH(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setRightButtonEnable(true);
      localTextView = this.rightViewText;
      localResources = getResources();
      if (this.cwA) {}
      for (j = 2131165381;; j = 2131167654)
      {
        localTextView.setTextColor(localResources.getColor(j));
        return;
      }
    }
    setRightButtonEnable(false);
    TextView localTextView = this.rightViewText;
    Resources localResources = getResources();
    if (this.cwA) {}
    for (int j = 2131165385;; j = 2131167657)
    {
      localTextView.setTextColor(localResources.getColor(j));
      return;
    }
  }
  
  public void Nr(int paramInt)
  {
    ((RelativeLayout.LayoutParams)this.iL.getLayoutParams()).bottomMargin = paramInt;
  }
  
  public alew a(QQAppInterface paramQQAppInterface)
  {
    alew localalew = new alew();
    localalew.content = "";
    localalew.cwx = false;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      localalew.content = paramQQAppInterface.getString("draft_stick_note_content", "");
      localalew.cwx = paramQQAppInterface.getBoolean("draft_stick_note_only_self_see", false);
      localalew.fontId = paramQQAppInterface.getInt("draft_stick_note_font_id", 0);
      localalew.fontType = paramQQAppInterface.getInt("draft_stick_note_font_type", 0);
      localalew.clothesId = paramQQAppInterface.getInt("draft_stick_note_clothes_id", 0);
      localalew.textColor = paramQQAppInterface.getInt("draft_stick_note_text_color", 0);
      if (QLog.isColorLevel()) {
        QLog.i("StickyNotePublishFragment", 2, "readDraft() --> sticky content is " + localalew.content + " sticky isOnlySelfSee is " + localalew.cwx);
      }
    }
    return localalew;
  }
  
  public void a(alev paramalev)
  {
    if ((paramalev != null) && (this.titleRoot != null) && (getActivity() != null))
    {
      if (paramalev.id == 999L)
      {
        this.zg.performClick();
        VasWebviewUtil.reportCommercialDrainage("friend_wall", "icon_click", "", 0, "", "3");
      }
    }
    else {
      return;
    }
    o(getActivity().app, paramalev.id);
    hU((int)paramalev.id, -1);
    this.titleRoot.setBackgroundDrawable(paramalev.fm);
    if (this.Ce != null) {
      this.Ce.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setItemId((int)paramalev.id);
  }
  
  public void a(QQAppInterface paramQQAppInterface, alew paramalew)
  {
    a(paramQQAppInterface, paramalew, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, alew paramalew, boolean paramBoolean)
  {
    if ((paramQQAppInterface != null) && (paramalew != null) && (!TextUtils.isEmpty(paramalew.content)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("StickyNotePublishFragment", 2, "saveDraft() --> sticky content is " + paramalew.content + " sticky isOnlySelfSee is " + paramalew.cwx);
      }
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      if (paramBoolean)
      {
        paramQQAppInterface.edit().putString("draft_stick_note_content", paramalew.content).commit();
        paramQQAppInterface.edit().putBoolean("draft_stick_note_only_self_see", paramalew.cwx).commit();
        paramQQAppInterface.edit().putInt("draft_stick_note_font_id", paramalew.fontId).commit();
        paramQQAppInterface.edit().putInt("draft_stick_note_font_type", paramalew.fontType).commit();
        paramQQAppInterface.edit().putInt("draft_stick_note_clothes_id", paramalew.clothesId).commit();
        paramQQAppInterface.edit().putInt("draft_stick_note_text_color", paramalew.textColor).commit();
      }
    }
    else
    {
      return;
    }
    paramQQAppInterface.edit().putString("draft_stick_note_content", paramalew.content).apply();
    paramQQAppInterface.edit().putBoolean("draft_stick_note_only_self_see", paramalew.cwx).apply();
    paramQQAppInterface.edit().putInt("draft_stick_note_font_id", paramalew.fontId).apply();
    paramQQAppInterface.edit().putInt("draft_stick_note_font_type", paramalew.fontType).apply();
    paramQQAppInterface.edit().putInt("draft_stick_note_clothes_id", paramalew.clothesId).apply();
    paramQQAppInterface.edit().putInt("draft_stick_note_text_color", paramalew.textColor).apply();
  }
  
  public void a(StickyNoteShopLayout paramStickyNoteShopLayout)
  {
    gA(paramStickyNoteShopLayout);
    Nr(paramStickyNoteShopLayout.iG(this.cUE));
    this.iL.setVisibility(0);
    paramStickyNoteShopLayout.show(0);
  }
  
  public void aq(boolean paramBoolean, int paramInt)
  {
    int j = 0;
    if (paramBoolean)
    {
      this.caW = true;
      this.cUE = paramInt;
      this.iL.setVisibility(0);
      Ix(false);
      NF(false);
      Nr(this.cUE);
      NG(false);
      int m = this.cUE;
      if (this.ly == null)
      {
        paramInt = j;
        jg(m, paramInt);
      }
    }
    do
    {
      return;
      paramInt = this.ly.getHeight();
      break;
      this.caW = false;
      NG(true);
      if (this.mCurrentState == 1)
      {
        Ix(true);
        NF(true);
        return;
      }
      if (this.mCurrentState == 0)
      {
        this.iL.setVisibility(8);
        Ix(false);
        NF(false);
        jg(0, 0);
        return;
      }
      if (this.mCurrentState == 2)
      {
        changeState(2);
        return;
      }
    } while (this.mCurrentState != 3);
    changeState(3);
  }
  
  public void changeState(int paramInt)
  {
    this.mCurrentState = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      Ix(false);
      NF(false);
      this.f.setVisibility(8);
      this.k.setVisibility(8);
      this.i.setVisibility(0);
      this.i.requestFocus();
      aurd.aO(this.i);
      return;
    case 1: 
      if (this.caW)
      {
        aurd.hide(this.i);
        return;
      }
      Ix(true);
      NF(true);
      return;
    case 2: 
      if (this.caW)
      {
        aurd.hide(this.i);
        return;
      }
      Ix(true);
      a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout);
      this.zg.setImageResource(2130851306);
      VasWebviewUtil.reportCommercialDrainage("friend_wall", "page_show", "", 0, "", "1");
      return;
    }
    if (this.caW)
    {
      aurd.hide(this.i);
      return;
    }
    Ix(true);
    a(this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout);
    this.zh.setImageResource(2130851308);
    VasWebviewUtil.reportCommercialDrainage("friend_wall", "page_show", "", 0, "", "2");
  }
  
  public void dFx()
  {
    TextView localTextView = this.leftViewNotBack;
    Resources localResources = getResources();
    if (this.cwA) {}
    for (int j = 2131165381;; j = 2131167654)
    {
      localTextView.setTextColor(localResources.getColor(j));
      NH(this.rightViewText.isEnabled());
      ImmersiveUtils.setStatusTextColor(this.cwA, getActivity().getWindow());
      return;
    }
  }
  
  public void dFy()
  {
    if (this.EU != null)
    {
      Iterator localIterator = this.EU.iterator();
      while (localIterator.hasNext()) {
        if (((alev)localIterator.next()).id == 999L) {
          localIterator.remove();
        }
      }
    }
  }
  
  public void dG(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      paramQQAppInterface.edit().putString("draft_stick_note_content", "").apply();
      paramQQAppInterface.edit().putBoolean("draft_stick_note_only_self_see", false).apply();
    }
  }
  
  public void dcy()
  {
    this.zh.setImageResource(2130851307);
    this.zg.setImageResource(2130851305);
    this.gR.setImageResource(2130845718);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    initUI();
    initData();
    this.c = ((SoftInputDetectView)findViewById(2131369291));
    this.c.setExcludeStatusBar(false);
    this.c.setOnImStateChangedListener(this);
    this.bP = ((FrameLayout)findViewById(2131367199));
    this.i = ((XEditTextEx)findViewById(2131366543));
    this.i.setEditableFactory(new alex(this));
    this.i.addTextChangedListener(this.A);
    if ((this.i.getText() == null) || (TextUtils.isEmpty(this.i.getText().toString())) || (TextUtils.isEmpty(this.i.getText().toString().trim())))
    {
      NH(false);
      this.k = ((ETTextView)findViewById(2131366552));
      this.k.setOnClickListener(new alfb(this));
      this.f = ((ScrollView)findViewById(2131379034));
      this.mRoot = ((RelativeLayout)findViewById(2131377488));
      this.mRoot.setOnTouchListener(new alfc(this));
      this.C = ((RecyclerView)findViewById(2131377610));
      paramLayoutInflater = new LinearLayoutManager(getActivity());
      paramLayoutInflater.setOrientation(0);
      this.iL = ((LinearLayout)findViewById(2131370634));
      this.ly = ((RelativeLayout)findViewById(2131377452));
      this.gR = ((ImageView)findViewById(2131369732));
      this.gR.setOnTouchListener(jll.a);
      this.zg = ((ImageView)findViewById(2131369947));
      this.zg.setOnTouchListener(jll.a);
      this.zg.setOnClickListener(this);
      this.zh = ((ImageView)findViewById(2131369948));
      this.zh.setOnTouchListener(jll.a);
      this.zh.setOnClickListener(this);
      this.O = ((CheckBox)findViewById(2131364370));
      this.cwy = false;
      this.O.setChecked(false);
      this.O.setOnCheckedChangeListener(new alfd(this));
      this.kq = ((TextView)findViewById(2131381016));
      this.Xi = ((TextView)findViewById(2131380835));
      if (!TextUtils.equals(String.valueOf(this.hg), getActivity().app.getCurrentAccountUin())) {
        break label846;
      }
      this.kq.setText(2131701749);
      this.Xi.setText(2131701749);
      label481:
      this.bz = ((FrameLayout)findViewById(2131367185));
      this.bz.setVisibility(8);
      this.d = b(getActivity().app, getActivity(), this.mContentView, 2131366348, this.i);
      NF(false);
      this.lz = ((RelativeLayout)findViewById(2131377451));
      this.mSubHandler.sendEmptyMessage(0);
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout = ((StickyNoteShopLayout)findViewById(2131363409));
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setShopCallback(this);
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setAppId(9);
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setUseId(1);
      this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout = ((StickyNoteShopLayout)findViewById(2131367441));
      this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setShopCallback(this);
      this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setAppId(5);
      this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setUseId(1);
      this.EU.addAll(aler.ES);
      if (!anlm.ayn()) {
        break label869;
      }
      this.zg.setVisibility(8);
      this.zh.setVisibility(8);
      dFy();
    }
    for (;;)
    {
      kF(l(getActivity().app));
      this.jdField_b_of_type_Alet = new alet(this.EU, getActivity(), this);
      this.C.setLayoutManager(paramLayoutInflater);
      this.C.setAdapter(this.jdField_b_of_type_Alet);
      if (this.titleRoot != null)
      {
        this.Ce = new View(getActivity());
        this.titleRoot.addView(this.Ce, 0, new RelativeLayout.LayoutParams(-1, -1));
        this.Ce.setVisibility(8);
      }
      anot.a(null, "dc00898", "", "", "0X800AB2A", "0X800AB2A", 0, 0, "0", "0", "", "");
      VasWebviewUtil.reportCommercialDrainage("friend_wall", "icon_show", "", 0, "", "");
      return;
      NH(true);
      break;
      label846:
      this.kq.setText(2131701748);
      this.Xi.setText(2131701748);
      break label481;
      label869:
      this.zg.setVisibility(0);
      this.zh.setVisibility(0);
    }
  }
  
  public void gA(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout != paramView) {
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.hide();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout != paramView) {
      this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.hide();
    }
    this.d.setVisibility(8);
  }
  
  public int getContentLayoutId()
  {
    return 2131561620;
  }
  
  public int getLineCount()
  {
    if ((this.i != null) && (this.i.getEditableText() != null))
    {
      TextPaint localTextPaint = this.i.getPaint();
      float f1 = this.i.getTextSize();
      localTextPaint.setTextSize(wja.a(2, 28, getResources()));
      StaticLayout localStaticLayout = new StaticLayout(this.i.getEditableText().toString(), localTextPaint, this.i.getWidth() - this.i.getPaddingLeft() - this.i.getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
      localTextPaint.setTextSize(f1);
      return localStaticLayout.getLineCount();
    }
    return -1;
  }
  
  public void hU(int paramInt1, int paramInt2)
  {
    this.cwA = SignTextEditFragment.isColorDark(paramInt2);
    dFx();
    if (paramInt1 > 10000)
    {
      this.Ce.setVisibility(0);
      if ((this.Ce.getBackground() instanceof VasResDrawable)) {
        ((VasResDrawable)this.Ce.getBackground()).update(paramInt1);
      }
    }
    for (this.mClothesItem.itemId = paramInt1;; this.mClothesItem.itemId = 0)
    {
      this.mClothesItem.appid = 9;
      this.i.setTextColor(paramInt2);
      this.k.mMsgId = System.currentTimeMillis();
      this.k.setTextColor(paramInt2);
      return;
      VasResDrawable localVasResDrawable = new VasResDrawable(getActivity().app, paramInt1);
      aqry localaqry = new aqry(localVasResDrawable, getActivity().app, 2130847025);
      localaqry.SR(true);
      localVasResDrawable.a(localaqry);
      this.Ce.setBackgroundDrawable(localVasResDrawable);
      break;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return false;
              } while (getActivity() == null);
              paramMessage = a(getActivity().app);
              this.mUIHandler.obtainMessage(2, paramMessage).sendToTarget();
              return false;
            } while (getActivity() == null);
            paramMessage = (String)paramMessage.obj;
            if (!TextUtils.isEmpty(paramMessage))
            {
              localObject = new alew();
              ((alew)localObject).content = paramMessage;
              ((alew)localObject).cwx = this.cwy;
              a(getActivity().app, (alew)localObject);
              return false;
            }
            dG(getActivity().app);
            return false;
          } while (getActivity() == null);
          paramMessage = (alew)paramMessage.obj;
          if ((this.i != null) && (!TextUtils.isEmpty(paramMessage.content)))
          {
            this.i.setText(paramMessage.content);
            this.i.setSelection(this.i.getEditableText().length());
            if (paramMessage.clothesId != 0)
            {
              localObject = this.EU.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((alev)((Iterator)localObject).next()).isSelected = false;
              }
              ((alev)this.EU.get(this.EU.size() - 1)).isSelected = true;
              a((alev)this.EU.get(this.EU.size() - 1));
            }
            setFont(paramMessage.fontId, paramMessage.fontType);
            hU(paramMessage.clothesId, paramMessage.textColor);
          }
        } while (this.O == null);
        this.O.setChecked(paramMessage.cwx);
        return false;
      } while (getActivity() == null);
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof alew)))
      {
        paramMessage = (alew)paramMessage.obj;
        if (!TextUtils.isEmpty(paramMessage.content))
        {
          paramMessage.cwx = this.cwy;
          a(getActivity().app, paramMessage);
        }
        for (;;)
        {
          this.mUIHandler.sendEmptyMessage(4);
          return false;
          dG(getActivity().app);
        }
      }
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage))
      {
        localObject = new alew();
        ((alew)localObject).content = paramMessage;
        ((alew)localObject).cwx = this.cwy;
        a(getActivity().app, (alew)localObject);
      }
      for (;;)
      {
        this.mUIHandler.sendEmptyMessage(4);
        return false;
        dG(getActivity().app);
      }
    } while (getActivity() == null);
    this.cwz = false;
    getActivity().finish();
    return false;
  }
  
  public boolean hasContent()
  {
    return (this.i.getText() != null) && (!TextUtils.isEmpty(this.i.getText().toString().trim()));
  }
  
  public void initData()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.hg = localBundle.getLong("key_host_uin");
      if (QLog.isColorLevel()) {
        QLog.i("StickyNotePublishFragment", 1, "host uin is " + this.hg);
      }
      return;
    }
    QLog.e("StickyNotePublishFragment", 1, "can not get host uin info");
  }
  
  public void initUI()
  {
    if ((getActivity() != null) && (getActivity().getWindow() != null))
    {
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.titleRoot.setFitsSystemWindows(false);
        this.titleRoot.setPadding(0, 0, 0, 0);
        if (getTitleBarView() != null)
        {
          getTitleBarView();
          ((ViewGroup.MarginLayoutParams)getTitleBarView().getLayoutParams()).topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
        }
      }
      Object localObject = getActivity().getWindow();
      ((Window)localObject).setSoftInputMode(16);
      ((Window)localObject).setBackgroundDrawable(new ColorDrawable(getActivity().getResources().getColor(2131167654)));
      if (ImmersiveUtils.isSupporImmersive() != 0)
      {
        localObject = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
        ((SystemBarCompact)localObject).init();
        ((SystemBarCompact)localObject).setStatusBarColor(getResources().getColor(2131167595));
      }
      if (getTitleBarView() != null) {
        getTitleBarView().setBackgroundColor(getActivity().getResources().getColor(2131167595));
      }
      setLeftButton(2131721058, this);
      this.leftViewNotBack.setTextColor(getResources().getColor(2131167654));
      localObject = (RelativeLayout.LayoutParams)this.leftViewNotBack.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = wja.dp2px(8.0F, getResources());
      this.leftViewNotBack.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.leftViewNotBack.setOnTouchListener(jll.a);
      this.leftViewNotBack.setBackgroundDrawable(null);
      setRightButton(2131721066, this);
      this.rightViewText.setTextColor(getResources().getColor(2131167654));
      localObject = (RelativeLayout.LayoutParams)this.rightViewText.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).rightMargin = wja.dp2px(3.0F, getResources());
      this.rightViewText.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.rightViewText.setOnTouchListener(jll.a);
      this.rightViewText.setBackgroundDrawable(null);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void jg(int paramInt1, int paramInt2)
  {
    if (this.Ce != null) {
      ((ViewGroup.MarginLayoutParams)this.Ce.getLayoutParams()).bottomMargin = (paramInt1 + paramInt2);
    }
  }
  
  public void kF(long paramLong)
  {
    int j;
    if ((this.EU != null) && (this.EU.size() > 0))
    {
      Iterator localIterator = this.EU.iterator();
      j = 0;
      if (localIterator.hasNext())
      {
        alev localalev = (alev)localIterator.next();
        localalev.isSelected = false;
        if (localalev.id != paramLong) {
          break label103;
        }
        localalev.isSelected = true;
        j = 1;
      }
    }
    label103:
    for (;;)
    {
      break;
      if (j == 0) {
        ((alev)this.EU.get(0)).isSelected = true;
      }
      return;
    }
  }
  
  public long l(QQAppInterface paramQQAppInterface)
  {
    long l = 0L;
    if (paramQQAppInterface != null) {
      l = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getLong("default_stick_note_bg", 0L);
    }
    return l;
  }
  
  public void o(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface != null) {
      paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit().putLong("default_stick_note_bg", paramLong).apply();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout != null) {
      this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    if (getActivity() == null) {
      return false;
    }
    if ((this.i != null) && (!TextUtils.isEmpty(this.i.getText())))
    {
      alew localalew = new alew();
      localalew.content = this.i.getText().toString();
      localalew.fontId = this.mFontItem.itemId;
      localalew.fontType = this.mFontItem.fontType;
      localalew.textColor = this.i.getCurrentTextColor();
      localalew.clothesId = this.mClothesItem.itemId;
      aqha.a(getActivity(), acfp.m(2131714578), 2131721000, 2131720999, new alez(this, localalew), new alfa(this)).show();
    }
    for (;;)
    {
      return true;
      dG(getActivity().app);
      if (getActivity() != null)
      {
        this.cwz = false;
        getActivity().finish();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    boolean bool;
    label384:
    do
    {
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          dcy();
          changeState(2);
          VasWebviewUtil.reportCommercialDrainage("friend_wall", "icon_click", "", 0, "", "1");
          continue;
          dcy();
          changeState(3);
          VasWebviewUtil.reportCommercialDrainage("friend_wall", "icon_click", "", 0, "", "2");
          continue;
          onBackEvent();
          anot.a(null, "dc00898", "", "", "0X800AB30", "0X800AB30", 0, 0, "0", "0", "", "");
          continue;
          if ((getActivity() == null) || (aqiw.isNetSupport(getActivity()))) {
            break;
          }
          QQToast.a(getActivity(), 1, getString(2131693404), 0).show();
        }
      } while ((getActivity() == null) || (this.i == null) || (this.i.getEditableText() == null) || (TextUtils.isEmpty(this.i.getEditableText().toString())));
      if (this.jdField_a_of_type_Arhz == null) {
        this.jdField_a_of_type_Arhz = new arhz(getActivity(), getActivity().getTitleBarHeight());
      }
      this.jdField_a_of_type_Arhz.setMessage(getResources().getString(2131697488));
      this.jdField_a_of_type_Arhz.show();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.mFontItem);
      localArrayList.add(this.mClothesItem);
      String str = String.valueOf(l(getActivity().app));
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      QQAppInterface localQQAppInterface = getActivity().app;
      long l1 = this.hg;
      long l2 = Long.valueOf(getActivity().app.getCurrentUin()).longValue();
      if (this.cwy) {
        break;
      }
      bool = true;
      ales.a(localBaseApplication, localQQAppInterface, l1, l2, bool, str, str, arml.encodeToString(new SuixintieCheckInfo(localArrayList).toByteArray(), 0), ales.e(this.i), this.jdField_a_of_type_Avys);
      anot.a(null, "dc00898", "", "", "0X800AB2F", "0X800AB2F", 0, 0, "0", "0", "", "");
    } while ((TextUtils.isEmpty(getActivity().getCurrentAccountUin())) || (TextUtils.isEmpty(String.valueOf(this.hg))));
    if (getActivity().getCurrentAccountUin().equals(String.valueOf(this.hg))) {}
    for (int j = 1;; j = 2)
    {
      anot.a(null, "dc00898", "", "", "0X800AB2E", "0X800AB2E", j, 0, "0", "0", "", "");
      break;
      bool = false;
      break label384;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    String str;
    if (this.cwz)
    {
      if (QLog.isColorLevel()) {
        QLog.i("StickyNotePublishFragment", 2, "save draft when exit unexpected");
      }
      if ((getActivity() != null) && (this.i != null) && (!TextUtils.isEmpty(this.i.getText())))
      {
        str = this.i.getText().toString();
        if (!TextUtils.isEmpty(str)) {
          break label98;
        }
        dG(getActivity().app);
      }
    }
    for (;;)
    {
      if (this.mVasRes != null) {
        this.mVasRes.recycle();
      }
      return;
      label98:
      alew localalew = new alew();
      localalew.content = str;
      localalew.cwx = this.cwy;
      a(getActivity().app, localalew, true);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    boolean bool;
    if ((getActivity() != null) && (getActivity().app != null))
    {
      bool = ThemeUtil.isInNightMode(getActivity().app);
      if (!bool) {
        break label62;
      }
      this.ly.setBackgroundColor(getActivity().getResources().getColor(2131165381));
    }
    for (;;)
    {
      setMask(bool);
      return;
      label62:
      this.ly.setBackgroundColor(getActivity().getResources().getColor(2131166711));
    }
  }
  
  public void setFont(int paramInt1, int paramInt2)
  {
    QLog.d("StickyNotePublishFragment", 1, " fontId:" + paramInt1 + " fontType:" + paramInt2);
    this.mFontItem.itemId = paramInt1;
    this.mFontItem.fontType = paramInt2;
    this.mFontItem.appid = 5;
    this.k.setFont(0, System.currentTimeMillis());
    this.k.mMsgId = System.currentTimeMillis();
    Object localObject = getActivity().app;
    if (this.mVasRes == null)
    {
      this.mVasRes = new aqrn(getActivity().app, paramInt1);
      localObject = new aqsa(this.mVasRes, (AppRuntime)localObject, paramInt2);
      ((aqsa)localObject).a(this.k, this.k.getTextSize(), true);
      this.mVasRes.a((aqro)localObject);
      ((aqsa)localObject).XS(-1);
      return;
    }
    ((aqsa)this.mVasRes.a()).a(this.k, this.k.getTextSize(), true);
    ((aqsa)this.mVasRes.a()).update(paramInt1, paramInt2);
  }
  
  public void setMask(boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = getActivity();
    View localView = localFragmentActivity.findViewById(2131372394);
    if (paramBoolean) {
      if (localView == null)
      {
        localView = new View(getActivity());
        localView.setBackgroundColor(1996488704);
        localView.setId(2131372394);
        localFragmentActivity.addContentView(localView, new ViewGroup.LayoutParams(-1, -1));
      }
    }
    while (localView == null)
    {
      return;
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment
 * JD-Core Version:    0.7.0.1
 */