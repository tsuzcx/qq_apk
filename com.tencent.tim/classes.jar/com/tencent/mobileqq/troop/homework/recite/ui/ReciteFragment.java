package com.tencent.mobileqq.troop.homework.recite.ui;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import apir;
import apit;
import apix;
import apiy;
import apiz;
import apja;
import apjb;
import apjc;
import apjd;
import apje;
import apjf;
import apka;
import apkb;
import apkb.b;
import apkd;
import apke;
import apki;
import apkp;
import aprb.a;
import aprc;
import aqcx;
import aqfr;
import aqha;
import aqju;
import aqnt;
import aqnt.a;
import auvw;
import auvw.a;
import auvw.b;
import com.qq.wx.voice.recognizer.VoiceRecognizer;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.homework.entry.ui.api.AbsHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.homework.recite.data.WordInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.protofile.homework.hw_recite_score.hw_recite_score.ReqReciteScore;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import jnm;
import org.json.JSONException;
import org.json.JSONObject;

public class ReciteFragment
  extends AbsHomeWorkFragment
  implements View.OnClickListener, AbsListView.OnScrollListener, CompoundButton.OnCheckedChangeListener, apkb.b, aprb.a, aqnt.a, ReciteRecordLayout.a
{
  View Iz;
  CheckBox U;
  apkb jdField_a_of_type_Apkb;
  apkd jdField_a_of_type_Apkd;
  protected apki a;
  public apkp a;
  protected aprc a;
  public ArticleInfo a;
  ReciteDisplayView.b jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$b;
  ReciteRecordLayout jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout;
  TextView aaM;
  TextView aaN;
  TextView aaO = null;
  protected apit b;
  protected aqnt b;
  ReciteDisplayView b;
  protected boolean cQV;
  protected int dUA = 0;
  protected auvw e;
  Button hn;
  public Handler mHandler;
  long mStartTime = 0L;
  TextView mTitleTv = null;
  
  public static final String oE(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("《"))
    {
      str = paramString;
      if (paramString.endsWith("》")) {
        str = paramString.substring(1, paramString.length() - 1);
      }
    }
    return str;
  }
  
  public static void x(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    AbsHomeWorkFragment.a((Activity)paramContext, ReciteFragment.class, localIntent, paramInt, paramString);
  }
  
  public int Lr()
  {
    return this.dUA;
  }
  
  public void RN(boolean paramBoolean)
  {
    if (this.leftViewNotBack != null) {
      this.leftViewNotBack.setVisibility(8);
    }
    if (this.rightViewText != null) {
      this.rightViewText.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.isRecording()) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.stopRecord();
    }
    this.hn.setVisibility(0);
    if (paramBoolean)
    {
      this.dUA = 2;
      if (this.jdField_a_of_type_Apkd == null) {
        this.jdField_a_of_type_Apkd = new apkd(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$b, this.jdField_a_of_type_Apkp.cpP);
      }
      this.jdField_a_of_type_Apkp.cpP = this.jdField_a_of_type_Apkd.Bp();
      this.leftView.setVisibility(8);
      this.U.setVisibility(0);
      this.aaM.setVisibility(0);
      this.hn.setText(acfp.m(2131713732));
      this.rightViewImg.setVisibility(8);
    }
    for (;;)
    {
      VoiceRecognizer.shareInstance().destroy();
      this.jdField_a_of_type_Apkp.arE = ((System.currentTimeMillis() - this.mStartTime) / 1000L);
      return;
      this.dUA = 0;
      this.jdField_b_of_type_Apit.reset();
      this.leftView.setVisibility(0);
      this.U.setVisibility(8);
      this.aaM.setVisibility(8);
      this.hn.setText(acfp.m(2131713731));
      this.rightViewImg.setVisibility(0);
    }
  }
  
  public void SP(@Nullable String paramString) {}
  
  protected void SV(String paramString)
  {
    if ((this.jdField_b_of_type_Aqnt != null) && (this.jdField_b_of_type_Aqnt.getState() == 3)) {
      this.jdField_b_of_type_Aqnt.start();
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Aqnt == null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$b != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$b.dZR();
        }
        this.jdField_b_of_type_Aqnt = new aqnt(paramString, new Handler(), 1);
        this.jdField_b_of_type_Aqnt.cf(super.getActivity());
        this.jdField_b_of_type_Aqnt.a(this);
        this.jdField_b_of_type_Aqnt.start();
        this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.smoothScrollToPosition(0);
      }
      return;
      if (this.jdField_b_of_type_Aqnt != null) {
        eae();
      }
    }
  }
  
  protected void a(Button paramButton, ReciteRecordLayout paramReciteRecordLayout)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new apja(this, paramButton));
    paramButton.startAnimation(localAlphaAnimation);
    paramButton = new AlphaAnimation(0.0F, 1.0F);
    paramButton.setDuration(300L);
    paramButton.setStartOffset(160L);
    paramReciteRecordLayout.setVisibility(0);
    paramReciteRecordLayout.startAnimation(paramButton);
  }
  
  public void a(String paramString1, String paramString2, double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReciteFragmentReciteDetect", 2, "startTime:" + paramDouble1 + ", chinese:" + paramString1 + ", pinyin:" + paramString2 + ", isEnd:" + paramBoolean);
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    this.jdField_a_of_type_Apkb.a(paramDouble1, paramString2.split(" "));
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo = ArticleInfo.onHandleGetArticleDetail(paramBundle, paramJSONObject);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo != null)
    {
      dZW();
      return;
    }
    super.finish();
  }
  
  public void b(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView = ((ReciteDisplayView)findViewById(2131376868));
    this.hn = ((Button)findViewById(2131376867));
    this.hn.setOnClickListener(this);
    this.U = ((CheckBox)findViewById(2131364367));
    this.U.setOnCheckedChangeListener(this);
    this.aaM = ((TextView)findViewById(2131380877));
    this.aaM.setOnClickListener(this);
    if (!ThemeUtil.isInNightMode(super.getQQAppInterface()))
    {
      this.vg.changeBg(true);
      this.vg.setBackgroundResource(2130838900);
      this.rightViewImg.setImageResource(2130844617);
      this.rightViewImg.setOnClickListener(new apix(this));
      if (this.dUA != 3) {
        break label348;
      }
      this.hn.setVisibility(8);
      this.U.setVisibility(0);
      this.aaM.setVisibility(0);
      this.rightViewImg.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout = ((ReciteRecordLayout)findViewById(2131376985));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.setOnReciteListener(this);
      this.jdField_b_of_type_Apit = new apit(super.getActivity(), this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView);
      this.jdField_b_of_type_Apit.a((SpriteVideoView)findViewById(2131379038));
      this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.addFooterView(this.jdField_b_of_type_Apit.mContentView);
      this.jdField_b_of_type_Apit.OY();
      dZV();
      this.aaN = ((TextView)findViewById(2131380136));
      if (this.dUA == 3) {
        this.jdField_b_of_type_Apit.a(false, this.jdField_a_of_type_Apkp.cpO, this.jdField_a_of_type_Apkp.dUR, this.jdField_a_of_type_Apkp.arE, this.jdField_a_of_type_Apkp.clt, this.jdField_a_of_type_Apkp.dUH);
      }
      this.Iz = findViewById(2131368104);
      return;
      this.rightViewImg.setImageResource(2130844618);
      break;
      label348:
      this.hn.setVisibility(0);
      this.U.setVisibility(8);
      this.aaM.setVisibility(8);
      this.rightViewImg.setVisibility(0);
    }
  }
  
  public void b(WordInfo paramWordInfo)
  {
    if (paramWordInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$b != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$b.a(paramWordInfo);
    }
    if (this.jdField_a_of_type_Apkd == null) {
      this.jdField_a_of_type_Apkd = new apkd(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$b, this.jdField_a_of_type_Apkp.cpP);
    }
    this.jdField_a_of_type_Apkd.be(paramWordInfo.paragraphPos, paramWordInfo.wordPos, paramWordInfo.getStatus());
  }
  
  public void bd(int paramInt1, int paramInt2, int paramInt3)
  {
    RN(true);
    int i = (int)this.jdField_a_of_type_Apkp.arE;
    if (QLog.isColorLevel()) {
      QLog.d("ReciteFragment", 2, new Object[] { "onCompleteRecite wordTotalCount=", Integer.valueOf(paramInt1), ", errorCount=", Integer.valueOf(paramInt2), ", remindCount=", Integer.valueOf(paramInt3), " time=", Integer.valueOf(i) });
    }
    hw_recite_score.ReqReciteScore localReqReciteScore = new hw_recite_score.ReqReciteScore();
    localReqReciteScore.error_times.set(paramInt2);
    localReqReciteScore.remind_times.set(paramInt3);
    localReqReciteScore.total_time.set((int)this.jdField_a_of_type_Apkp.arE);
    localReqReciteScore.total_word.set(paramInt1);
    if ((paramInt1 <= 0) || (i <= 0)) {
      return;
    }
    jnm.a(super.getActivity().app, new apjd(this, paramInt3, paramInt2), localReqReciteScore.toByteArray(), "HwSvc.get_recite_score");
  }
  
  public void c(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_Apkd != null) {
      this.jdField_a_of_type_Apkd.eat();
    }
    this.U.setChecked(false);
    if (this.jdField_b_of_type_Aqnt != null)
    {
      this.jdField_b_of_type_Aqnt.release();
      this.jdField_b_of_type_Aqnt = null;
    }
  }
  
  public void c(String paramString, double paramDouble)
  {
    this.jdField_a_of_type_Apkp.mFilePath = paramString;
    if (QLog.isColorLevel()) {
      QLog.i("ReciteFragment", 2, "onRecordEnd: totalTime = " + paramDouble);
    }
  }
  
  public void c(String paramString, int paramInt1, int paramInt2)
  {
    List localList;
    ReciteDisplayView.b localb;
    if ((this.jdField_a_of_type_Apkd == null) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo != null))
    {
      localList = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs;
      localb = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$b;
      if (this.jdField_a_of_type_Apkp == null) {
        break label76;
      }
    }
    label76:
    for (paramString = this.jdField_a_of_type_Apkp.cpP;; paramString = null)
    {
      this.jdField_a_of_type_Apkd = new apkd(localList, localb, paramString);
      if (this.jdField_a_of_type_Apkd != null) {
        this.jdField_a_of_type_Apkd.WO(paramInt2);
      }
      return;
    }
  }
  
  public void d(String paramString, int paramInt1, int paramInt2) {}
  
  protected void dZV()
  {
    this.jdField_a_of_type_Apki = new apki();
    QQAppInterface localQQAppInterface = super.getQQAppInterface();
    if (localQQAppInterface != null) {
      this.jdField_a_of_type_Aprc = this.jdField_a_of_type_Apki.a(localQQAppInterface, this, this.jdField_a_of_type_Apkp.cpK, this.jdField_a_of_type_Apkp.HW, 10003);
    }
  }
  
  public void dZW()
  {
    this.dUA = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs != null))
    {
      if ((this.mTitleTv == null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.title)))
      {
        this.mTitleTv = new TextView(super.getActivity());
        this.mTitleTv.setTextSize(1, 32.0F);
        this.mTitleTv.setTextColor(Color.parseColor("#424245"));
        this.mTitleTv.setText(oE(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.title));
        this.mTitleTv.setGravity(1);
        this.mTitleTv.setPadding(0, aqcx.dip2px(getActivity(), 26.0F), 0, 0);
        this.mTitleTv.setIncludeFontPadding(false);
        this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.addHeaderView(this.mTitleTv);
      }
      if ((this.aaO == null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.author)))
      {
        this.aaO = new TextView(super.getActivity());
        this.aaO.setTextSize(1, 18.0F);
        this.aaO.setTextColor(Color.parseColor("#777777"));
        this.aaO.setText(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.author);
        this.aaO.setGravity(1);
        this.aaO.setIncludeFontPadding(false);
        this.aaO.setPadding(0, aqcx.dip2px(getActivity(), 16.0F), 0, aqcx.dip2px(getActivity(), 12.0F));
        this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.addHeaderView(this.aaO);
      }
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.iterator();
      while (localIterator.hasNext()) {
        ((ParagraphInfo)localIterator.next()).resetWordsReciteStatus();
      }
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.size())
      {
        ((ParagraphInfo)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.get(i)).resetWordsReciteStatus();
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$b = new ReciteDisplayView.b(this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView, super.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.type, ReciteDisplayView.b.dUw);
      this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setArticleInfo(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo);
      this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setFragment(this);
      this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$b);
      this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setOnScrollListener(this);
      this.Iz.setVisibility(0);
      return;
    }
    QQToast.a(super.getActivity(), acfp.m(2131713740), 0).show();
  }
  
  public void dZX()
  {
    RN(false);
    dZW();
  }
  
  public void dZY()
  {
    RN(false);
    dZW();
  }
  
  public void dZZ()
  {
    if (this.jdField_a_of_type_Apkp != null) {}
    for (String str = this.jdField_a_of_type_Apkp.mTroopUin;; str = "")
    {
      aqfr.b("Grp_edu", "Grp_recite", "Disturb_Recite_Again_Clk", 0, 0, new String[] { str });
      return;
    }
  }
  
  public void eaa()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReciteFragment", 2, "repeatRecite");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.stopRecord();
    }
    aqju localaqju = aqha.a(super.getActivity(), 230).setMessage(2131699902).setNegativeButton(acfp.m(2131713733), new apjc(this)).setPositiveButton(acfp.m(2131713741), new apjb(this));
    localaqju.setCancelable(false);
    localaqju.show();
  }
  
  public void eab()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.isEmpty())) {
      QQToast.a(c(this), acfp.m(2131713737), 0).show();
    }
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        localQQAppInterface = super.getQQAppInterface();
      } while (localQQAppInterface == null);
      if (QLog.isColorLevel())
      {
        TroopManager localTroopManager = (TroopManager)localQQAppInterface.getManager(52);
        QLog.d("ReciteFragment", 2, "StartRecite ReciteConfig| MaxAllowWrongNum = " + localTroopManager.a.dUr + "; MaxDetectNumInRecite = " + localTroopManager.a.dUq);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.isRecording()) {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.stopRecord();
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.a(super.getActivity())));
    this.dUA = 1;
    this.jdField_b_of_type_Apit.reset();
    eae();
    this.U.setChecked(false);
    eag();
    this.U.setVisibility(8);
    this.aaM.setVisibility(8);
    a(this.hn, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout);
    this.jdField_a_of_type_Apkb = new apkb(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo, this, localQQAppInterface, this.jdField_a_of_type_Apkp.mTroopUin);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.setmReciteDetectManager(this.jdField_a_of_type_Apkb);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$b = new ReciteDisplayView.b(this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView, super.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.type, ReciteDisplayView.b.dUx);
    this.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$b);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$b.notifyDataSetChanged();
    setLeftButton(acfp.m(2131713735), this);
    setRightButton(2131699900, this);
    this.rightViewImg.setVisibility(8);
    this.jdField_a_of_type_Apkd = new apkd(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView$b, null);
    this.mStartTime = System.currentTimeMillis();
    this.Iz.setVisibility(0);
  }
  
  protected void eac()
  {
    Object localObject = super.getQQAppInterface();
    localObject = aqha.a(super.getActivity(), 230).setMessage(2131699901).setNegativeButton(acfp.m(2131713739), new apjf(this)).setPositiveButton(acfp.m(2131713738), new apje(this, (QQAppInterface)localObject));
    ((aqju)localObject).setCancelable(false);
    ((aqju)localObject).show();
  }
  
  protected void ead()
  {
    if ((this.jdField_b_of_type_Aqnt != null) && (this.jdField_b_of_type_Aqnt.getState() == 2)) {
      this.jdField_b_of_type_Aqnt.pause();
    }
  }
  
  protected void eae()
  {
    if (this.jdField_b_of_type_Aqnt != null)
    {
      this.jdField_b_of_type_Aqnt.release();
      this.jdField_b_of_type_Aqnt = null;
    }
  }
  
  protected void eaf()
  {
    if (this.e == null)
    {
      this.e = new auvw.b(auvw.a(super.getActivity()).b(0).a(true).a(acfp.m(2131713736)).a(17.0F).b(0).c(50).a(-1)).b(-16777216).a(3).a().a();
      this.e.setOutsideTouchable(false);
      this.e.setFocusable(false);
      this.e.setAlignMode(82);
      this.e.setOnClickListener(new apiy(this));
    }
    if (!this.e.isShowing())
    {
      this.e.jb(this.rightViewImg);
      apka.Y(super.getQQAppInterface(), true);
    }
  }
  
  public void eag()
  {
    if (this.e != null)
    {
      this.e.dismiss();
      this.e = null;
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131560822;
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    paramBundle = paramBundle.getString("HomeWorkConstants:homework_default_request_key");
    try
    {
      this.jdField_a_of_type_Apkp = new apkp(new JSONObject(paramBundle));
      if (this.jdField_a_of_type_Apkp.bGG == 1) {}
      for (this.dUA = 3;; this.dUA = 0)
      {
        this.mHandler = new Handler();
        new apke(super.getActivity(), "3171", "libWXVoice.so", "WXVoice").execute();
        return;
      }
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReciteFragment", 2, paramBundle, new Object[0]);
        }
      }
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout != null) {}
    for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.onBackEvent();; bool = true)
    {
      switch (this.dUA)
      {
      }
      while ((bool) && (super.onBackEvent()))
      {
        return true;
        eac();
        return true;
        bool = true;
      }
      return false;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Apkp.mFilePath))
    {
      if (!paramBoolean) {
        break label37;
      }
      SV(this.jdField_a_of_type_Apkp.mFilePath);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      label37:
      ead();
    }
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = super.getQQAppInterface();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.dUA == 0)
      {
        if (!apke.ah(super.getActivity(), "libWXVoice.so"))
        {
          aqju localaqju = aqha.a(super.getActivity(), 230).setMessage(2131699697).setNegativeButton(2131699698, new apiz(this));
          localaqju.setCancelable(false);
          localaqju.show();
        }
        eab();
        if (localQQAppInterface != null) {
          aqfr.a(localQQAppInterface, this.jdField_a_of_type_Apkp.mTroopUin, "Grp_recite", "In_Recite_Clk", 0, 0, new String[] { this.jdField_a_of_type_Apkp.mTroopUin, "", this.jdField_a_of_type_Apkp.cpO, "" });
        }
      }
      else if (this.dUA == 2)
      {
        try
        {
          bK(apkp.a(this.jdField_a_of_type_Apkp));
          b(this);
          if (localQQAppInterface == null) {
            continue;
          }
          aqfr.a(localQQAppInterface, this.jdField_a_of_type_Apkp.mTroopUin, "Grp_recite", "Finish_Recite_Clk", 0, 0, new String[] { this.jdField_a_of_type_Apkp.mTroopUin, "", this.jdField_a_of_type_Apkp.cpO, "" });
          aqfr.b("Grp_edu", "Grp_recite", "Finish_Recite_Clk_another", 0, 0, new String[] { this.jdField_a_of_type_Apkp.mTroopUin, String.valueOf(this.jdField_a_of_type_Apkp.dUH), String.valueOf(this.jdField_a_of_type_Apkp.arE), String.valueOf(this.jdField_a_of_type_Apkp.clt) });
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        continue;
        eab();
        if (localJSONException != null)
        {
          aqfr.b("Grp_edu", "Grp_recite", "Finish_Recite_Again_Clk", 0, 0, new String[] { this.jdField_a_of_type_Apkp.mTroopUin, String.valueOf(this.jdField_a_of_type_Apkp.dUH), String.valueOf(this.jdField_a_of_type_Apkp.arE), String.valueOf(this.jdField_a_of_type_Apkp.clt) });
          continue;
          if (this.dUA == 1)
          {
            eac();
            continue;
            if (this.jdField_a_of_type_Apkb != null) {
              this.jdField_a_of_type_Apkb.eas();
            }
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_b_of_type_Apit != null) {
      this.jdField_b_of_type_Apit.onDestroy();
    }
    if (this.jdField_a_of_type_Aprc != null) {
      this.jdField_a_of_type_Aprc.cancel(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.onDestroy();
    }
    eae();
    eag();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_b_of_type_Apit != null) {
      this.jdField_b_of_type_Apit.onPause();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout.onPause();
    }
    ead();
    this.U.setChecked(false);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_b_of_type_Apit != null) {
      this.jdField_b_of_type_Apit.onPause();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
    {
      setTitle("");
      return;
    }
    setTitle(oE(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.title));
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((this.dUA == 0) && (!this.cQV))
    {
      this.cQV = true;
      if (!apka.bM(super.getQQAppInterface())) {
        eaf();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment
 * JD-Core Version:    0.7.0.1
 */