package com.tencent.mobileqq.richstatus;

import abgd;
import abgd.a;
import acfp;
import aclv;
import amfg;
import amfk;
import amfo;
import amfp;
import amfq;
import amfr;
import amfs;
import amft;
import amfu;
import amfv;
import amfw;
import amfx;
import amfy;
import amhd;
import amhj;
import amih;
import amij;
import amin;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aofk;
import aqft;
import aqha;
import aqhq;
import aqiw;
import aqju;
import aqnm;
import aqqs;
import aurd;
import avpw;
import avpw.d;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureManager.TopicInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.richstatus.topic.TopicEditTextView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.XListView;
import cooperation.qzone.LbsDataV2.PoiInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import jll;
import mqq.app.AppActivity;
import wja;

public class SignTextEditFragment
  extends IphoneTitleBarFragment
  implements abgd.a, Handler.Callback, TextWatcher, View.OnClickListener, AdapterView.c
{
  private static long aiE;
  private static final int[][] w = { { 2130847026, Color.parseColor("#03081A"), Color.parseColor("#B0B3BF") }, { 2130839524, -1, -1 } };
  View GA;
  public CheckBox P;
  XListView Q;
  TextView Ye;
  TextView Yf;
  TextView Yg;
  abgd jdField_a_of_type_Abgd;
  private amhj jdField_a_of_type_Amhj;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new amfq(this);
  TopicEditTextView jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView;
  private long aiD;
  aclv b;
  TextView bI;
  FrameLayout bU;
  int bnN;
  amfk c;
  public RichStatus c;
  public boolean cCr;
  private boolean cCs;
  private boolean cCt;
  String caa;
  private String cab;
  private boolean ceP;
  private amfk d = new amfp(this);
  private int dBI = -1;
  private int dBJ;
  private AtomicBoolean dI = new AtomicBoolean(false);
  public int fromType;
  Drawable fu;
  public Observer g = new amfx(this);
  RelativeLayout lP;
  public QQAppInterface mApp;
  private String mCachePoiId;
  View mEmptyView;
  ImageView mO;
  int mStart;
  public Handler mSubHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  public Handler mUIHandler = new Handler(Looper.getMainLooper(), this);
  
  public SignTextEditFragment()
  {
    this.jdField_c_of_type_Amfk = new amfw(this);
  }
  
  private void Bz(int paramInt)
  {
    if (!isAdded()) {
      return;
    }
    this.mO.setVisibility(8);
    this.mEmptyView.setVisibility(0);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.bI.getLayoutParams();
    localLayoutParams.topMargin = wja.dp2px(80.0F, getResources());
    this.bI.setLayoutParams(localLayoutParams);
    if (paramInt == 1)
    {
      this.mEmptyView.setVisibility(8);
      try
      {
        this.bI.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131167385)));
        this.bI.setText(acfp.m(2131714577));
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SignTextEditFragment", 2, localException1.toString());
          }
        }
      }
    }
    try
    {
      this.bI.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131167385)));
      this.mO.setImageResource(2130851444);
      if (paramInt == 3)
      {
        this.bI.setText(acfp.m(2131714589));
        return;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SignTextEditFragment", 2, localException2.toString());
        }
      }
      if (paramInt == 2)
      {
        this.bI.setText(acfp.m(2131714590));
        return;
      }
      this.mEmptyView.setVisibility(8);
    }
  }
  
  private void J(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == this.dBI) && (paramInt2 == this.dBJ)) {
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, "onAtKeyChanged return");
      }
    }
    long l;
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.i("SignTextEditFragment", 2, String.format("onAtKeyChanged [%d, %d, [%s] ]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
      }
      this.dBI = paramInt1;
      this.dBJ = paramInt2;
      if ((paramInt1 < 0) || (paramInt2 <= 0) || (TextUtils.isEmpty(paramString)))
      {
        this.aiD = 0L;
        this.Q.setTag(null);
        dNf();
        return;
      }
      l = b(paramString, this.dBI, paramInt2);
    } while (l <= 0L);
    this.aiD = l;
  }
  
  private void N(TextView paramTextView)
  {
    paramTextView = paramTextView.getCompoundDrawables();
    int i = wja.dp2px(16.0F, getResources());
    if (paramTextView[0] != null) {
      paramTextView[0].setBounds(0, 0, i, i);
    }
  }
  
  private void Pa(boolean paramBoolean)
  {
    int j = aqnm.PxToDp(aqnm.getScreenWidth());
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, "width_1x=" + j);
    }
    if ((j < 354) && (paramBoolean))
    {
      this.cCt = true;
      localObject = (RelativeLayout.LayoutParams)this.Yg.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = aqnm.dpToPx(28.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin += aqnm.dpToPx(8.0F);
      localObject = (RelativeLayout.LayoutParams)this.GA.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 0);
    }
    Object localObject = this.Yf.getText().toString();
    TextPaint localTextPaint = this.Yf.getPaint();
    int k = (int)(Layout.getDesiredWidth((CharSequence)localObject, localTextPaint) + 0.5F) - (int)(Layout.getDesiredWidth(amfg.bZZ, localTextPaint) + 0.5F);
    int i;
    if (this.cCt)
    {
      i = aqnm.dpToPx(j - 16 - 85 - 4 - 85 - 4 - 93 - 4 - 8 - 16);
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, String.format("isNarrow=%b widthLeft=%d needMoreLen=%d width=%d", new Object[] { Boolean.valueOf(this.cCt), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) }));
      }
      localObject = (RelativeLayout.LayoutParams)this.Yf.getLayoutParams();
      if (k >= i) {
        break label310;
      }
    }
    label310:
    for (((RelativeLayout.LayoutParams)localObject).width = -2;; ((RelativeLayout.LayoutParams)localObject).width = (i + aqnm.dpToPx(85.0F)))
    {
      this.Yf.requestLayout();
      return;
      i = aqnm.dpToPx(j - 354);
      break;
    }
  }
  
  private void Pb(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, "updateSignViewShow");
    }
    if (this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      return;
    }
    Object localObject1 = this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.toSpannableStringWithoutAction(null);
    e(this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus);
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (!TextUtils.isEmpty(this.caa))
      {
        localObject2 = this.caa;
        localObject1 = localObject2;
        if (paramBoolean)
        {
          this.caa = null;
          localObject1 = localObject2;
        }
      }
      this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.ensureContent();
      localObject2 = localObject1;
      if (this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.tplId != 0)
      {
        this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, ((CharSequence)localObject1).toString());
        localObject2 = localObject1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("updateSignViewShow content=%s", new Object[] { localObject2 }));
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.setText(new aofk((CharSequence)localObject2, 1, 20));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.setSelection(this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getEditableText().length());
    aurd.aO(this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView);
    dNc();
    Pc(ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null));
  }
  
  private void Pc(boolean paramBoolean)
  {
    if (!isAdded()) {
      return;
    }
    if (paramBoolean)
    {
      this.rightViewText.setTextColor(Color.parseColor("#A8A8A8"));
      this.rightViewText.setBackgroundDrawable(getResources().getDrawable(2130846101));
      this.Yf.setBackgroundDrawable(getResources().getDrawable(2130846101));
      this.Ye.setBackgroundDrawable(getResources().getDrawable(2130846101));
      this.GA.setBackgroundDrawable(getResources().getDrawable(2130846101));
      this.rightViewText.setOnTouchListener(jll.a);
      localObject = this.rightViewText;
      if (this.ceP) {}
      for (float f = 1.0F;; f = 0.5F)
      {
        ((TextView)localObject).setAlpha(f);
        this.rightViewText.setEnabled(this.ceP);
        return;
      }
    }
    paramBoolean = isColorDark(this.centerView.getCurrentTextColor());
    if ("2105".equals(ThemeUtil.getCurrentThemeId())) {
      paramBoolean = true;
    }
    Object localObject = w;
    label179:
    TextView localTextView;
    if (paramBoolean)
    {
      i = 1;
      localObject = localObject[i];
      this.rightViewText.setBackgroundResource(localObject[0]);
      localTextView = this.rightViewText;
      if (!this.ceP) {
        break label236;
      }
    }
    label236:
    for (int i = localObject[1];; i = localObject[2])
    {
      localTextView.setTextColor(i);
      this.rightViewText.setOnTouchListener(null);
      break;
      i = 0;
      break label179;
    }
  }
  
  public static void a(Activity paramActivity, RichStatus paramRichStatus, String paramString, Bundle paramBundle, int paramInt)
  {
    if (System.currentTimeMillis() - aiE < 500L) {
      return;
    }
    aiE = System.currentTimeMillis();
    Intent localIntent = new Intent();
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.putExtra("rich_status", paramRichStatus);
    localIntent.putExtra("template_info_text", paramString);
    PublicFragmentActivity.startForResult(paramActivity, localIntent, SignTextEditFragment.class, paramInt);
  }
  
  private void a(CheckBox paramCheckBox, boolean paramBoolean)
  {
    paramCheckBox.setOnCheckedChangeListener(null);
    paramCheckBox.setChecked(paramBoolean);
    paramCheckBox.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  private void a(AdapterView<?> paramAdapterView, SignatureManager.TopicInfo paramTopicInfo)
  {
    Object localObject = paramAdapterView.getTag();
    if ((localObject instanceof Object[]))
    {
      paramAdapterView = (Object[])localObject;
      if (((Object[])localObject).length == 4)
      {
        i = ((Integer)paramAdapterView[0]).intValue();
        int j = ((Integer)paramAdapterView[1]).intValue();
        localObject = (String)paramAdapterView[2];
        if (((Long)paramAdapterView[3]).longValue() == this.aiD) {
          h(paramTopicInfo.topicId, paramTopicInfo.topicStr, i, j);
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (!lh(this.dBI)) {
          break label174;
        }
        h(paramTopicInfo.topicId, paramTopicInfo.topicStr, this.dBI, 0);
      }
      for (;;)
      {
        J(-1, 0, "");
        anot.a(null, "dc00898", "", "", "0X800A642", "0X800A642", 0, 0, "0", "0", "", "");
        return;
        label174:
        X(paramTopicInfo.topicId, paramTopicInfo.topicStr, this.dBI);
      }
    }
  }
  
  private RichStatus b()
  {
    try
    {
      RichStatus localRichStatus = (RichStatus)aqhq.o("file_richstatus_draft_" + this.mApp.getCurrentAccountUin());
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, String.format("readDraft %s", new Object[] { localRichStatus }));
      }
      return localRichStatus;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  private boolean c(RichStatus paramRichStatus)
  {
    String str1 = this.mCachePoiId;
    RichStatus localRichStatus = paramRichStatus;
    if (paramRichStatus == null)
    {
      localRichStatus = new RichStatus(null);
      localRichStatus.setEmptyStatus(true);
      str1 = "";
    }
    aqhq.y("file_richstatus_draft_" + this.mApp.getCurrentAccountUin(), localRichStatus);
    String str2 = this.mApp.getAccount();
    paramRichStatus = str2;
    if (str2 == null) {
      paramRichStatus = "noLogin";
    }
    this.mApp.getApp().getSharedPreferences(paramRichStatus, 4).edit().putString("sign_location_id_draft_" + this.mApp.getCurrentAccountUin(), str1).commit();
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("saveDraft %s", new Object[] { localRichStatus.getPlainText() }));
    }
    return true;
  }
  
  private void d(RichStatus paramRichStatus)
  {
    boolean bool1 = false;
    int i = 1;
    aqqs localaqqs = amhd.a().a(paramRichStatus.tplId);
    int j = paramRichStatus.tplId;
    if ((localaqqs.er.get()) || (localaqqs.a != null))
    {
      boolean bool2 = localaqqs.er.get();
      if (localaqqs.a != null) {
        bool1 = true;
      }
      QLog.d("SignTextEditFragment", 1, new Object[] { "insureNotImageSign set2Default tplId isParsing=", Boolean.valueOf(bool2), " isImageItem=", Boolean.valueOf(bool1) });
    }
    for (;;)
    {
      paramRichStatus.tplId = i;
      return;
      i = j;
    }
  }
  
  private void dNc()
  {
    if (!isAdded()) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.fu == null)
        {
          this.fu = getResources().getDrawable(2130847029);
          int i = wja.dp2px(16.0F, getResources());
          this.fu.setBounds(i, i, i, i);
          this.Yf.setCompoundDrawablesWithIntrinsicBounds(this.fu, null, null, null);
        }
        if (TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.locationText)) {
          continue;
        }
        this.Yf.setText(this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.locationText);
        this.Yf.setTextColor(-11692801);
        this.Yf.getBackground().setColorFilter(-11692801, PorterDuff.Mode.SRC_ATOP);
        this.Yf.getBackground().setAlpha(33);
        this.fu.setColorFilter(-11692801, PorterDuff.Mode.SRC_ATOP);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("SignTextEditFragment", 2, localOutOfMemoryError.getMessage(), localOutOfMemoryError);
        continue;
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("SignTextEditFragment", 2, localThrowable.getMessage(), localThrowable);
        continue;
      }
      Pa(false);
      return;
      this.Yf.setTextColor(-7894119);
      this.Yf.setText(amfg.bZZ);
      this.Yf.getBackground().setColorFilter(null);
      this.Yf.getBackground().setAlpha(255);
      this.fu.setColorFilter(null);
    }
  }
  
  private void dNd()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SignTextEditFragment", 1, "publishRichStatus");
    }
    if (this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.getTotalLenForShow() > 80)
    {
      Message localMessage = new Message();
      localMessage.what = 4;
      this.mUIHandler.sendMessage(localMessage);
      return;
    }
    if (this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.bOnlyHasTopic())
    {
      this.mUIHandler.sendEmptyMessage(5);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getText().length() == 0)
    {
      aqha.a(getActivity(), 230, acfp.m(2131714582), acfp.m(2131714588), acfp.m(2131714576), acfp.m(2131714580), new amfu(this), new amfv(this)).show();
      return;
    }
    dNe();
  }
  
  private void dNe()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("publishRichStatusReal %s [tplId=%d fontId=%d, fontType=%d]", new Object[] { this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus, Integer.valueOf(this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.tplId), Integer.valueOf(this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.fontId), Integer.valueOf(this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.fontType) }));
    }
    RichStatus localRichStatus = new RichStatus(null);
    localRichStatus.copyFrom(this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus);
    d(localRichStatus);
    this.jdField_a_of_type_Amhj.a(localRichStatus, 1);
    this.jdField_a_of_type_Amhj.addListener(this.jdField_c_of_type_Amfk);
  }
  
  private void e(RichStatus paramRichStatus)
  {
    if (paramRichStatus == null) {}
    for (int i = 0;; i = paramRichStatus.getTotalLenForShow())
    {
      this.Yg.setText(i + "/" + 80);
      int j = ((Integer)this.Yg.getTag()).intValue();
      paramRichStatus = this.Yg;
      if (80 - i <= 0) {
        j = Color.parseColor("#FF596A");
      }
      paramRichStatus.setTextColor(j);
      return;
    }
  }
  
  private void f(RichStatus paramRichStatus)
  {
    if ((paramRichStatus == null) || (paramRichStatus.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, String.format("mergeByDraft empty", new Object[0]));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("mergeByDraft draft=%s", new Object[] { paramRichStatus }));
    }
    this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.ensureContent();
    if (paramRichStatus.plainText != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.clear();
      this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.addAll(paramRichStatus.plainText);
    }
    if ((this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus != null) && (this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.topics != null) && (paramRichStatus.topics != null))
    {
      this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.topics.clear();
      this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.topics.addAll(paramRichStatus.topics);
    }
    if ((this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus != null) && (this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos != null) && (paramRichStatus.topicsPos != null))
    {
      this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.clear();
      this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.addAll(paramRichStatus.topicsPos);
    }
    this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = paramRichStatus.locationText;
    this.ceP = true;
  }
  
  private <T extends View> T findViewById(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  public static boolean isColorDark(int paramInt)
  {
    return 1.0D - (0.299D * Color.red(paramInt) + 0.587D * Color.green(paramInt) + 0.114D * Color.blue(paramInt)) / 255.0D >= 0.5D;
  }
  
  private boolean lh(int paramInt)
  {
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getEditableText();
    return (paramInt >= 0) && (localEditable.length() > paramInt) && (localEditable.charAt(paramInt) == '#') && (amin.a(localEditable, paramInt) == null);
  }
  
  private boolean vz()
  {
    Bundle localBundle = getArguments();
    int i;
    String str2;
    for (;;)
    {
      try
      {
        this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus = ((RichStatus)localBundle.getSerializable("rich_status"));
        this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.actionText = null;
        this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.actionId = 0;
        this.caa = localBundle.getString("template_info_text");
        this.fromType = localBundle.getInt("from_type");
        String str1;
        if (QLog.isColorLevel())
        {
          i = this.fromType;
          if (this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus == null)
          {
            str1 = "null";
            QLog.i("SignTextEditFragment", 2, String.format("initData from=%d status=%s", new Object[] { Integer.valueOf(i), str1 }));
          }
        }
        else
        {
          if ((this.fromType != 1) && (this.fromType != 2)) {
            break label283;
          }
          this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
          this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.copyFrom(this.jdField_a_of_type_Amhj.a(true));
          this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.actionText = null;
          this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.actionId = 0;
          i = localBundle.getInt("key_sign_topic_id", -1);
          str1 = localBundle.getString("key_sign_topic_name");
          if ((i >= 0) && (amin.oE(str1))) {
            break;
          }
          return false;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SignTextEditFragment", 2, localException.getMessage(), localException);
        }
        return false;
      }
      str2 = this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.getPlainText();
    }
    this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.topics.clear();
    this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.topics.add(new Pair(Integer.valueOf(i), str2));
    this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.plainText = null;
    this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.ensureContent();
    this.ceP = true;
    label283:
    if (this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
    }
    for (;;)
    {
      return true;
      amhd.a().a(this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    }
  }
  
  public void X(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onTagSelectedInsert(%d,%s) index=%d selStart=%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(this.dBI), Integer.valueOf(paramInt2) }));
    }
    if ((!amin.oE(paramString)) || (paramInt1 < 0)) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getText().length();
    int i;
    if (paramInt2 < 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getSelectionStart() >= 0) {
        i = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getSelectionStart();
      }
    }
    Editable localEditable;
    for (;;)
    {
      localEditable = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getText();
      if (localEditable.length() + paramString.length() <= 80) {
        break;
      }
      paramString = new Message();
      paramString.what = 3;
      this.mUIHandler.sendMessage(paramString);
      return;
      i = 0;
      continue;
      i = j;
      if (paramInt2 <= j) {
        i = paramInt2;
      }
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    amih localamih = new amih(null, amin.b(-11692801, -2142399233), new Pair(Integer.valueOf(paramInt1), paramString));
    if (i > 0) {
      localSpannableStringBuilder.insert(0, localEditable.subSequence(0, i));
    }
    if (localEditable.length() > i) {
      localSpannableStringBuilder.insert(localSpannableStringBuilder.length(), localEditable.subSequence(i, localEditable.length()));
    }
    localSpannableStringBuilder.insert(i, paramString);
    localSpannableStringBuilder.setSpan(localamih, i, paramString.length() + i, 33);
    if (QLog.isDevelopLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onTagSelectedInsert [%d dstLen=%d] [src=%s,dst=%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(localSpannableStringBuilder.length()), localEditable.toString(), localSpannableStringBuilder.toString() }));
    }
    this.cCs = true;
    localEditable.delete(0, localEditable.length());
    localEditable.insert(0, localSpannableStringBuilder);
    this.cCs = false;
    if ((i >= 0) && (paramString.length() + i <= this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getEditableText().length()))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.setSelection(i + paramString.length());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.setSelection(this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getEditableText().length());
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().equals(this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.toSpannableStringWithoutAction().toString()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SignTextEditFragment", 2, "afterTextChanged text not changed");
      }
      return;
    }
    this.ceP |= true;
    Pc(ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null));
    this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.ensureContent();
    Object localObject = amin.a(paramEditable);
    this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, localObject);
    this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.topics.clear();
    this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.topics.addAll(amin.a(paramEditable));
    this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.clear();
    this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.addAll(amin.b(paramEditable));
    e(this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus);
    int i = 80 - this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.getTotalLenForShow();
    if (i >= 0) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, String.format("afterTextChanged [%s]", new Object[] { this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.getPlainText() }));
      }
      if (this.cCs) {
        break;
      }
      int k = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getSelectionStart();
      localObject = "";
      int m = amin.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getEditableText(), k);
      int j = k - 1 - m;
      i = j;
      if (j < 0) {
        i = 0;
      }
      paramEditable = (Editable)localObject;
      if (m >= 0)
      {
        paramEditable = (Editable)localObject;
        if (i > 0) {
          paramEditable = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getEditableText().subSequence(m + 1, k).toString();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("SignTextEditFragment", 2, String.format("------------------[selStart=%d, indexAt=%d, len=%d key=[%s] ]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), paramEditable }));
      }
      J(m, i, paramEditable);
      return;
      amin.a(paramEditable, i, this.mStart, this.bnN);
      localObject = new Message();
      ((Message)localObject).what = 4;
      this.mUIHandler.sendMessage((Message)localObject);
      localObject = amin.a(paramEditable);
      this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, localObject);
      this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.topics.clear();
      this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.topics.addAll(amin.a(paramEditable));
      this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.clear();
      this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.addAll(amin.b(paramEditable));
    }
  }
  
  public long b(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Abgd != null) && ((this.jdField_a_of_type_Abgd.dz() == null) || (this.jdField_a_of_type_Abgd.dz().size() <= 0))) {
      Bz(1);
    }
    if (aqiw.isNetSupport(getActivity()))
    {
      SignatureHandler localSignatureHandler = (SignatureHandler)this.mApp.getBusinessHandler(41);
      if (localSignatureHandler != null)
      {
        long l = System.currentTimeMillis();
        localSignatureHandler.d(paramString, paramInt1, paramInt2, l);
        return l;
      }
    }
    else
    {
      Bz(2);
    }
    return 0L;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mStart = paramInt1;
    this.bnN = paramInt3;
  }
  
  public void dF(int paramInt, String paramString)
  {
    if (paramInt == 100)
    {
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = acfp.m(2131714591);
      }
      QQToast.a(BaseApplication.context, 2, str, 0).show();
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = acfp.m(2131714586);
    }
    QQToast.a(BaseApplication.context, 1, str, 0).show();
  }
  
  public void dNf()
  {
    if ((this.jdField_a_of_type_Abgd != null) && (this.jdField_a_of_type_Abgd.dA() != null) && (this.jdField_a_of_type_Abgd.dA().size() > 0)) {
      if (this.jdField_a_of_type_Abgd.f(this.jdField_a_of_type_Abgd.dA(), false)) {
        this.jdField_a_of_type_Abgd.notifyDataSetChanged();
      }
    }
    SignatureHandler localSignatureHandler;
    do
    {
      return;
      Bz(1);
      if (!aqiw.isNetSupport(getActivity())) {
        break;
      }
      localSignatureHandler = (SignatureHandler)this.mApp.getBusinessHandler(41);
    } while (localSignatureHandler == null);
    localSignatureHandler.cMx();
    return;
    Bz(2);
  }
  
  void dNg()
  {
    aurd.hide(this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView);
    if (Build.VERSION.SDK_INT > 23)
    {
      FragmentActivity localFragmentActivity = getActivity();
      if (localFragmentActivity != null)
      {
        if (localFragmentActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
          localFragmentActivity.requestPermissions(new amfy(this, localFragmentActivity), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        }
      }
      else {
        return;
      }
      dNh();
      return;
    }
    dNh();
  }
  
  public void dNh()
  {
    avpw.d locald = avpw.d.a();
    locald.cMP = this.mApp.getCurrentAccountUin();
    locald.nickname = this.mApp.getCurrentNickname();
    if (TextUtils.isEmpty(this.mCachePoiId))
    {
      this.mCachePoiId = this.mApp.getPreferences().getString("sign_location_id_draft_" + this.mApp.getCurrentAccountUin(), "");
      if (TextUtils.isEmpty(this.mCachePoiId)) {
        this.mCachePoiId = this.mApp.getPreferences().getString("sign_location_id_" + this.mApp.getCurrentAccountUin(), "");
      }
    }
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(this.mCachePoiId))
    {
      localBundle.putInt("key_lbs_state", 1);
      localBundle.putString("key_current_poi_id", this.mCachePoiId);
    }
    avpw.a(getActivity(), locald, 18, localBundle);
    getActivity().overridePendingTransition(2130771991, 2130772002);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getString(2131693017));
    setRightButtonText(acfp.m(2131714581), this);
    this.jdField_a_of_type_Amhj = ((amhj)this.mApp.getManager(15));
    if (!vz())
    {
      getActivity().finish();
      return;
    }
    this.rightViewText.setBackgroundDrawable(getResources().getDrawable(2130846100));
    paramLayoutInflater = (RelativeLayout.LayoutParams)this.rightViewText.getLayoutParams();
    paramLayoutInflater.height = wja.dp2px(29.0F, getResources());
    paramLayoutInflater.width = wja.dp2px(60.0F, getResources());
    paramLayoutInflater.setMargins(0, 0, wja.dp2px(14.0F, getResources()), 0);
    this.rightViewText.setGravity(17);
    this.rightViewText.setLayoutParams(paramLayoutInflater);
    this.rightViewText.setTextSize(1, 14.0F);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView = ((TopicEditTextView)findViewById(2131366278));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.setMovementMethod(amij.getInstance());
    this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.setOnEditorActionListener(new amfo(this));
    this.Ye = ((TextView)findViewById(2131362176));
    this.Yf = ((TextView)findViewById(2131362172));
    this.Ye.setOnTouchListener(jll.a);
    this.Yf.setOnTouchListener(jll.a);
    N(this.Ye);
    N(this.Yf);
    this.Yg = ((TextView)findViewById(2131370395));
    this.Yg.setTag(new Integer(-5196865));
    this.GA = findViewById(2131370746);
    this.P = ((CheckBox)findViewById(2131364369));
    this.GA.setOnTouchListener(jll.a);
    this.GA.setOnClickListener(this);
    Pa(true);
    this.Ye.setOnClickListener(this);
    this.Yf.setOnClickListener(this);
    this.bU = ((FrameLayout)findViewById(2131367203));
    this.lP = ((RelativeLayout)findViewById(2131366245));
    this.Q = ((XListView)findViewById(2131370584));
    this.Q.setOnItemClickListener(this);
    this.Q.setOnTouchListener(new amfr(this));
    this.mEmptyView = findViewById(2131366438);
    this.mO = ((ImageView)this.mEmptyView.findViewById(2131366414));
    this.bI = ((TextView)this.mEmptyView.findViewById(2131366429));
    this.jdField_a_of_type_Abgd = new abgd(getActivity(), this.mApp, this.Q, this);
    this.Q.setAdapter(this.jdField_a_of_type_Abgd);
    this.Q.setEmptyView(this.mEmptyView);
    if (this.jdField_a_of_type_Amhj != null) {
      this.jdField_a_of_type_Amhj.addListener(this.d);
    }
    this.mUIHandler.sendEmptyMessage(8);
    this.mSubHandler.sendEmptyMessage(0);
    Pb(false);
    if ((getActivity() != null) && (getActivity().getWindow() != null)) {
      getActivity().getWindow().setSoftInputMode(32);
    }
    if (ThemeUtil.isNowThemeIsNight(this.mApp, false, null))
    {
      this.bU.setBackgroundColor(Color.parseColor("#000000"));
      this.mEmptyView.setBackgroundColor(Color.parseColor("#000000"));
      this.lP.setBackgroundColor(Color.parseColor("#000000"));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.setTextColor(Color.parseColor("#ffffff"));
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "0X800A63E", "0X800A63E", 0, 0, "0", "0", "", "");
      return;
      this.bU.setBackgroundColor(Color.parseColor("#ffffff"));
      this.mEmptyView.setBackgroundColor(Color.parseColor("#f5f6fa"));
      this.lP.setBackgroundColor(Color.parseColor("#ffffff"));
      this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.setTextColor(Color.parseColor("#000000"));
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561706;
  }
  
  public void h(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onTagSelectedReplace[%d,%s] index=%d len=%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getText().length();
    if (paramInt2 >= i) {}
    while (!lh(paramInt2)) {
      return;
    }
    if (i - paramInt3 + paramString.length() > 80)
    {
      paramString = new Message();
      paramString.what = 3;
      this.mUIHandler.sendMessage(paramString);
      return;
    }
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getEditableText();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (paramInt2 > 0) {
      localSpannableStringBuilder.insert(0, localEditable.subSequence(0, paramInt2));
    }
    if (localEditable.length() > paramInt2 + paramInt3 + 1) {
      localSpannableStringBuilder.insert(localSpannableStringBuilder.length(), localEditable.subSequence(paramInt2 + paramInt3 + 1, localEditable.length()));
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onTagSelectedReplace remove before=%s after=%s", new Object[] { localEditable, localSpannableStringBuilder }));
    }
    this.cCs = true;
    localEditable.delete(0, localEditable.length());
    localEditable.insert(0, localSpannableStringBuilder);
    this.cCs = false;
    X(paramInt1, paramString, paramInt2 + 1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = b();
      this.mUIHandler.obtainMessage(2, paramMessage).sendToTarget();
      continue;
      c((RichStatus)paramMessage.obj);
      continue;
      paramMessage = (RichStatus)paramMessage.obj;
      if ((this.fromType != 1) && (this.fromType != 2))
      {
        f(paramMessage);
        Pb(true);
        continue;
        c((RichStatus)paramMessage.obj);
        this.mUIHandler.sendEmptyMessage(7);
        continue;
        if (getActivity() != null)
        {
          getActivity().finish();
          continue;
          QQToast.a(getActivity(), 1, acfp.m(2131714584), 1).show();
          continue;
          QQToast.a(getActivity(), 1, acfp.m(2131714574), 1).show();
          continue;
          QQToast.a(getActivity(), 1, acfp.m(2131714579), 1).show();
          continue;
          dNf();
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onActivityResult requestCode=0x%x resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (paramInt1 == 17)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramInt1 = paramIntent.getIntExtra("key_sign_topic_id", -1);
        paramIntent = paramIntent.getStringExtra("key_sign_topic_name");
        if ((paramInt1 > 0) && (!TextUtils.isEmpty(paramIntent))) {
          X(paramInt1, paramIntent, this.dBI);
        }
      }
      this.dBI = -1;
      this.dBJ = 0;
    }
    for (;;)
    {
      return;
      if ((paramInt1 == 18) && (paramIntent != null))
      {
        paramIntent = (LbsDataV2.PoiInfo)paramIntent.getParcelableExtra("key_select_poi");
        String str = this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.locationText;
        if (paramIntent == null) {
          this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = "";
        }
        while (!aqft.equalsWithNullCheck(str, this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.locationText))
        {
          this.ceP = true;
          Pb(false);
          return;
          if (paramIntent.poiName.equals(acfp.m(2131714587)))
          {
            this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = "";
            this.mCachePoiId = "";
          }
          else
          {
            this.jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = paramIntent.poiName;
            this.mCachePoiId = paramIntent.poiId;
          }
        }
      }
    }
  }
  
  public boolean onBackEvent()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("publish_ever", this.cCr);
    localFragmentActivity.setResult(-1, localIntent);
    int i = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getText().length();
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onBackEvent len=%d bChanged=%b bPublishEver=%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.ceP), Boolean.valueOf(this.cCr) }));
    }
    if ((this.ceP) && (i > 0) && (isAdded())) {
      aqha.a(getActivity(), acfp.m(2131714578), 2131721000, 2131720999, new amfs(this), new amft(this)).show();
    }
    for (;;)
    {
      return true;
      if ((i == 0) || ((!this.ceP) && (this.cCr))) {
        this.mSubHandler.obtainMessage(6, null).sendToTarget();
      } else {
        localFragmentActivity.finish();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    if (paramView.getId() == this.rightViewText.getId())
    {
      anot.a(null, "dc00898", "", "", "0X800A63F", "0X800A63F", 0, 0, "0", "0", "", "");
      if (!aqiw.isNetSupport(getActivity())) {
        QQToast.a(getActivity(), 2131694663, 0).show();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      dNd();
      continue;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131362172: 
        dNg();
        anot.a(null, "dc00898", "", "", "0X800A641", "0X800A641", 0, 0, "0", "0", "", "");
        break;
      case 2131362176: 
        this.dBI = this.jdField_a_of_type_ComTencentMobileqqRichstatusTopicTopicEditTextView.getSelectionStart();
        amin.u(getActivity(), "https://ti.qq.com/signature/searchtopic?_wv=3&&_wwv=128", 17);
        anot.a(null, "dc00898", "", "", "0X800A640", "0X800A640", 0, 0, "0", "0", "", "");
        break;
      case 2131370746: 
        CheckBox localCheckBox = this.P;
        if (!this.P.isChecked()) {
          bool = true;
        }
        localCheckBox.setChecked(bool);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = new a(null);
    this.mApp = getActivity().app;
    this.mApp.addObserver(this.b);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Amhj.removeListener(this.d);
    this.jdField_a_of_type_Amhj.removeListener(this.jdField_c_of_type_Amfk);
    this.mSubHandler.removeCallbacksAndMessages(null);
    this.mUIHandler.removeCallbacksAndMessages(null);
    this.mApp.removeObserver(this.b);
    amhd.a().deleteObserver(this.g);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_Abgd != null) && (this.jdField_a_of_type_Abgd.dz() != null) && (this.jdField_a_of_type_Abgd.dz().size() > paramInt)) {
      a(paramAdapterView, this.jdField_a_of_type_Abgd.a(paramInt));
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  class a
    extends aclv
  {
    private a() {}
    
    public void aM(boolean paramBoolean, Object paramObject)
    {
      if (paramObject == null) {
        SignTextEditFragment.a(SignTextEditFragment.this, 2);
      }
      for (;;)
      {
        return;
        paramObject = (Bundle)paramObject;
        int i = paramObject.getInt("param_searchResult", 0);
        paramObject = (ArrayList)paramObject.getSerializable("param_topicInfoList");
        if ((paramObject == null) || (paramObject.size() <= 0)) {
          if (i == 0) {
            SignTextEditFragment.a(SignTextEditFragment.this, 3);
          }
        }
        while (SignTextEditFragment.this.a.f(paramObject, true))
        {
          SignTextEditFragment.this.a.notifyDataSetChanged();
          return;
          SignTextEditFragment.a(SignTextEditFragment.this, 2);
          continue;
          SignTextEditFragment.a(SignTextEditFragment.this, 4);
        }
      }
    }
    
    public void aN(boolean paramBoolean, Object paramObject)
    {
      if (paramObject == null)
      {
        SignTextEditFragment.a(SignTextEditFragment.this, 2);
        return;
      }
      Object localObject = (Bundle)paramObject;
      int j = ((Bundle)localObject).getInt("param_atIndex");
      int k = ((Bundle)localObject).getInt("param_atKeyLen");
      paramObject = ((Bundle)localObject).getString("param_atKey");
      long l = ((Bundle)localObject).getLong("param_reqTs");
      localObject = (ArrayList)((Bundle)localObject).getSerializable("param_topicInfoList");
      int i;
      if (localObject == null)
      {
        i = 0;
        if (QLog.isColorLevel()) {
          QLog.i("SignTextEditFragment", 2, String.format("onGetTopicWithKey[%b,%d] key=[%s] [atIndex=%d, keyLen=%d],reqTs=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), paramObject, Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l) }));
        }
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          break label240;
        }
        SignTextEditFragment.a(SignTextEditFragment.this, 3);
      }
      for (;;)
      {
        if (SignTextEditFragment.this.a.f((List)localObject, false)) {
          SignTextEditFragment.this.a.notifyDataSetChanged();
        }
        SignTextEditFragment.this.Q.setTag(new Object[] { Integer.valueOf(j), Integer.valueOf(k), paramObject, Long.valueOf(l) });
        return;
        i = ((List)localObject).size();
        break;
        label240:
        SignTextEditFragment.a(SignTextEditFragment.this, 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignTextEditFragment
 * JD-Core Version:    0.7.0.1
 */