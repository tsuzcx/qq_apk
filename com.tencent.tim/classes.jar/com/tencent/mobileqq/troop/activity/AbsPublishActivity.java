package com.tencent.mobileqq.troop.activity;

import afmf;
import afmi;
import afqr;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aofy;
import aoqv;
import aorm.d;
import aoro;
import aorp;
import aorr;
import aors;
import aort;
import aoru;
import aorv;
import aorw;
import aorx;
import aory;
import aour;
import aozw;
import aprb.a;
import aprl;
import aprv;
import aprv.a;
import aqcx;
import aqhu;
import arhz;
import aurd;
import ausj;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicPageView.e;
import com.tencent.mobileqq.tribe.view.TEditText;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.troop.widget.PublishItemBar;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.troop.widget.TribeHotPicPanel;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.mobileqq.widget.InputMethodLinearLayout.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ScrollView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.HashMap;
import jqg;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbsPublishActivity
  extends IphoneTitleBarActivity
  implements afmf, TextWatcher, View.OnClickListener, View.OnFocusChangeListener, View.OnTouchListener, AdapterView.OnItemClickListener, aprb.a, HotPicPageView.e, InputMethodLinearLayout.a
{
  public static Editable.Factory a;
  protected long Ap;
  protected ImageView DZ;
  protected View HM;
  public View HN;
  public View HO;
  protected View HP;
  public Uri N;
  protected TextView ZY;
  public TextView ZZ;
  public aour a;
  protected arhz a;
  public TEditText a;
  public ExtendGridView a;
  protected TroopBarPublishUtils.AudioUploadTask a;
  protected TroopBarPublishUtils.PicUploadThread a;
  public AudioInfo a;
  public TroopBarPOI a;
  public PublishItemBar a;
  public PublishItemContainer a;
  public TribeHotPicPanel a;
  protected ScrollView a;
  public ImageButton aG;
  protected Boolean aG;
  protected TextView aaa;
  protected long aiL;
  protected SosoInterface.a b;
  public TEditText b;
  protected InputMethodLinearLayout b;
  protected EditText bA;
  protected BroadcastReceiver bB = new aorx(this);
  public JSONObject bN;
  protected boolean bSH = true;
  protected FrameLayout bW;
  protected FrameLayout bX;
  protected String bwy;
  protected EditText bz;
  protected int cLN;
  protected int cLO;
  protected int cLP;
  protected int cLQ;
  protected boolean cOj = true;
  protected boolean cOk;
  protected boolean cOl;
  public boolean cOm;
  public boolean cOn;
  protected boolean cOo = true;
  protected boolean cOp = true;
  public boolean cOq = true;
  protected boolean cOr = true;
  protected boolean cOs;
  protected boolean cOt = true;
  protected boolean cOu;
  protected boolean cOv;
  int cacheTime = 0;
  public String cmL = "";
  protected String cmM;
  protected String cmN;
  protected String cmO = "https://upload.buluo.qq.com/cgi-bin/bar/upload/image";
  protected String cmP;
  protected String cmQ;
  protected String cmR;
  protected String cmS;
  protected String cmT;
  protected String cmU;
  public String cmV;
  protected String cmW = "";
  public ArrayList<String> cu = new ArrayList();
  protected int dRA;
  protected int dRB = 0;
  protected int dRC;
  protected int dRw;
  protected int dRx;
  public int dRy = 9;
  public int dRz;
  public ViewGroup eA;
  protected LinearLayout kJ;
  protected LinearLayout kK;
  protected ArrayList<TroopBarPOI> kd;
  protected ausj mActionSheet;
  public BaseActivity mActivity;
  public String mBid = "";
  protected String mContent;
  protected int mFlag;
  protected String mFrom = "";
  protected int mGroupType;
  public Handler mHandler = new aory(this);
  public String mOpType;
  public arhz mProgress;
  protected String mTroopUin;
  protected RelativeLayout me;
  protected String uP;
  protected ListView v;
  
  static
  {
    jdField_a_of_type_AndroidTextEditable$Factory = new aorr();
  }
  
  public AbsPublishActivity()
  {
    this.jdField_aG_of_type_JavaLangBoolean = Boolean.valueOf(false);
  }
  
  protected int KX()
  {
    return 2131698464;
  }
  
  protected void Rg(boolean paramBoolean)
  {
    this.cOk = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_aG_of_type_AndroidWidgetImageButton.setImageResource(2130844391);
      this.jdField_aG_of_type_AndroidWidgetImageButton.setContentDescription(getString(2131698477));
    }
  }
  
  public void Sf(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONArray(paramString);
        if ((paramString != null) && (paramString.length() > 0))
        {
          int i = 0;
          while (i < paramString.length())
          {
            JSONObject localJSONObject = paramString.optJSONObject(i);
            if (localJSONObject != null) {
              a(this.mHandler, localJSONObject.optString("imagePath"));
            }
            i += 1;
          }
        }
        return;
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("IphoneTitleBarActivity", 2, QLog.getStackTraceString(paramString));
        }
      }
    }
  }
  
  public void Wd(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return;
    case 0: 
      Resources localResources = getResources();
      paramInt = (int)localResources.getDimension(2131298460);
      int i = (int)localResources.getDimension(2131298459);
      if (this.dRA == 0) {}
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.Gs(this.dRA);
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.isShown())) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.kd(5, 1);
        }
        this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setPadding(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingLeft(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingTop(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingRight(), paramInt);
        dWG();
        return;
        paramInt = paramInt + i + localResources.getDrawable(2130843362).getIntrinsicHeight();
      }
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.Gs(1);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.isShown())) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.kd(5, 1);
      }
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setPadding(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingLeft(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingTop(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingRight(), 0);
      this.HN.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.removeAllItem();
      return;
    case 2: 
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setPadding(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingLeft(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingTop(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingRight(), 0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(8);
      this.HN.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setPadding(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingLeft(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingTop(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingRight(), 0);
  }
  
  protected void We(int paramInt)
  {
    this.dRA = paramInt;
    if (this.dRA == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.Gs(this.dRA);
  }
  
  public Animation a(float paramFloat1, float paramFloat2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillAfter(true);
    return localAlphaAnimation;
  }
  
  protected String a(aorm.d paramd, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText == null) {}
    String str;
    int i;
    do
    {
      return null;
      if (paramd == null) {
        return aprv.f(this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText);
      }
      str = aprv.f(this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText);
      i = paramd.cmI.length() + paramd.cmJ.length() + paramd.cmK.length() + paramString.length();
    } while (str.length() <= i);
    return str.substring(i, str.length());
  }
  
  protected void a(int paramInt, Handler paramHandler)
  {
    runOnUiThread(new AbsPublishActivity.10(this));
    if (((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin()) != null) {
      switch (paramInt)
      {
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      ThreadManager.post(new TroopBarPublishUtils.PicUploadThread(this, paramHandler, this.cu, this.cmO), 8, null, true);
      return;
    }
    QLog.w("IphoneTitleBarActivity", 2, "startUploadImage skey is null!!!!!!!!!!!!!!!");
  }
  
  protected void a(int paramInt, aozw paramaozw)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a(paramInt, paramaozw);
    Wd(paramInt);
    this.cu.clear();
    if ((paramaozw instanceof AudioInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)paramaozw);
    }
  }
  
  public void a(afmi paramafmi)
  {
    if (((paramafmi instanceof afqr)) && (this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText != null)) {
      ((afqr)paramafmi).a(this.app, this, this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText, null);
    }
  }
  
  public void a(afmi paramafmi1, afmi paramafmi2, Drawable paramDrawable) {}
  
  public void a(BaseActivity paramBaseActivity, aprb.a parama)
  {
    this.jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a = new aors(this, 0, true, true, this.cacheTime, false, false, "AbsPublish", paramBaseActivity, parama);
    SosoInterface.a(this.jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a);
    d(2, new String[0]);
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (isFinishing()) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("poilist");
        if (this.kd == null)
        {
          this.kd = new ArrayList();
          break label226;
          if (paramInt < paramJSONObject.length())
          {
            this.kd.add(new TroopBarPOI(paramJSONObject.getJSONObject(paramInt)));
            paramInt += 1;
            continue;
          }
        }
        else
        {
          this.kd.clear();
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBar", 2, paramJSONObject.toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name))
          {
            paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.Tr;
            d(1, new String[] { paramJSONObject });
            return;
            if (this.kd.size() <= 0) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)this.kd.get(0));
            continue;
          }
          paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name;
          continue;
        }
        d(0, new String[0]);
        return;
      }
      d(3, new String[0]);
      return;
      label226:
      paramInt = 0;
    }
  }
  
  public boolean a(afmi paramafmi)
  {
    return true;
  }
  
  protected boolean a(Handler paramHandler, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QQToast.a(this, getString(2131699467), 1).show(getTitleBarHeight());
    }
    while (this.cu == null) {
      return false;
    }
    if (this.cu.size() >= 9)
    {
      QQToast.a(this, getString(2131695977, new Object[] { Integer.valueOf(9) }), 1).show(getTitleBarHeight());
      return false;
    }
    this.cu.add(paramString);
    Message localMessage = paramHandler.obtainMessage(1005);
    localMessage.obj = paramString;
    paramHandler.sendMessage(localMessage);
    return true;
  }
  
  protected boolean a(Handler paramHandler, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 9))
    {
      QQToast.a(this, getString(2131695977, new Object[] { Integer.valueOf(9) }), 1).show(getTitleBarHeight());
      return false;
    }
    if (paramArrayList != this.cu)
    {
      this.cu.clear();
      if (paramArrayList != null) {
        this.cu.addAll(paramArrayList);
      }
    }
    for (;;)
    {
      paramHandler.sendMessage(paramHandler.obtainMessage(1005));
      return true;
      this.cu = paramArrayList;
    }
  }
  
  public boolean a(View paramView, String paramString, HotPicData paramHotPicData)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("IphoneTitleBarActivity", 1, "AbsPublishActivity.onItemClick() filePath is empty. " + paramString);
    }
    do
    {
      return true;
      aqhu.cn(this, paramString);
      a(this.mHandler, paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.mStop = true;
      }
    } while (!this.cOo);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, null, this.cu, this.cmO);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
    return true;
  }
  
  protected boolean aAx()
  {
    if (this.cOm) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "publish restore key = " + this.uP);
    }
    if (TextUtils.isEmpty(this.uP)) {
      return false;
    }
    aprv.a locala = (aprv.a)aprv.ot.get(this.uP);
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "publish restore key = " + this.uP + ", data = " + locala);
    }
    aprv.ot.clear();
    if (locala == null) {
      return false;
    }
    if (this.cu.size() <= 0) {
      this.cu = locala.cu;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = locala.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI;
    this.kd = locala.kd;
    this.cmN = locala.mTitle;
    this.cmT = locala.mContent;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = locala.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo;
    this.cmM = locala.cmM;
    this.bwy = locala.bwy;
    if ((TextUtils.isEmpty(this.cmM)) || (this.dRx <= 0))
    {
      this.dRw = 4;
      this.dRx = 25;
      this.cmM = getString(2131698490, new Object[] { Integer.valueOf(this.dRw), Integer.valueOf(this.dRx) });
    }
    if ((TextUtils.isEmpty(this.bwy)) || (this.cLN < 0) || (this.cLO <= 0))
    {
      this.cLN = 10;
      this.cLO = 700;
      this.bwy = getString(2131698474, new Object[] { Integer.valueOf(this.cLN), Integer.valueOf(this.cLO) });
    }
    return true;
  }
  
  void aN(JSONObject paramJSONObject)
  {
    this.cOj = paramJSONObject.optBoolean("needCategory");
    this.dRw = paramJSONObject.optInt("minTitleLength", 4);
    this.dRx = paramJSONObject.optInt("maxTitleLength", 25);
    this.cmM = paramJSONObject.optString("titlePlaceholder", this.cmM);
    if (!TextUtils.isEmpty(this.mFrom)) {
      this.cmL = String.valueOf(1);
    }
    dWK();
    jqg.d((String)null, 0);
    paramJSONObject = new IntentFilter();
    paramJSONObject.addAction("key_photo_delete_action");
    paramJSONObject.addAction("key_audio_delete_action");
    paramJSONObject.addAction("key_audio_play_action");
    registerReceiver(this.bB, paramJSONObject);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = aprv.f(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
    int i;
    if (paramEditable == null)
    {
      i = 0;
      if ((this.cLO <= 0) || (i <= this.cLO)) {
        break label100;
      }
      if (this.aaa.getVisibility() != 0) {
        this.aaa.setVisibility(0);
      }
      this.aaa.setText(String.valueOf(this.cLO - i));
    }
    for (;;)
    {
      if ((Build.DISPLAY.equals("moonlight-diyroms' ROMS")) && (this.jdField_a_of_type_ComTencentWidgetScrollView != null)) {
        this.jdField_a_of_type_ComTencentWidgetScrollView.scrollTo(0, 0);
      }
      return;
      i = paramEditable.length();
      break;
      label100:
      this.aaa.setVisibility(8);
      this.aaa.setText(null);
    }
  }
  
  public void am(int paramInt)
  {
    if (this.jdField_a_of_type_Arhz == null) {
      this.jdField_a_of_type_Arhz = new arhz(this.mActivity, this.mActivity.getResources().getDimensionPixelSize(2131299627));
    }
    this.jdField_a_of_type_Arhz.setMessage(paramInt);
    this.jdField_a_of_type_Arhz.setCancelable(false);
    this.jdField_a_of_type_Arhz.show();
  }
  
  protected void avV()
  {
    this.eA.setVisibility(8);
    this.jdField_aG_of_type_AndroidWidgetImageButton.setImageResource(2130844391);
    this.jdField_aG_of_type_AndroidWidgetImageButton.setContentDescription(getString(2131698477));
  }
  
  public void b(afmi paramafmi) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public abstract void bsq();
  
  abstract void c(View paramView, int paramInt, long paramLong);
  
  protected void d(int paramInt, String... paramVarArgs)
  {
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramVarArgs = "";
      paramInt = i;
      label37:
      this.ZY.setText(paramVarArgs);
      if (AppSetting.enableTalkBack) {
        if (paramInt == 0) {
          break label174;
        }
      }
      break;
    }
    for (;;)
    {
      this.ZY.setContentDescription(paramVarArgs);
      return;
      paramVarArgs = getString(2131698451);
      paramInt = i;
      break label37;
      if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
        break;
      }
      QQToast.a(this, paramVarArgs[0], 1).show(getTitleBarHeight());
      paramVarArgs = "";
      paramInt = i;
      break label37;
      paramVarArgs = "";
      paramInt = i;
      break label37;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!TextUtils.isEmpty(paramVarArgs[0])))
      {
        if (TextUtils.isEmpty(paramVarArgs[0]))
        {
          d(3, new String[0]);
          return;
        }
        paramVarArgs = paramVarArgs[0];
        paramInt = 1;
        break label37;
      }
      d(0, new String[0]);
      return;
      label174:
      paramVarArgs = getString(2131698482);
    }
  }
  
  protected void dWF()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("audio_max_length", this.dRz);
    if (this.mBid != null)
    {
      localIntent.putExtra("from", "publish");
      localIntent.putExtra("bid", this.mBid);
      localIntent.putExtra("fromflag", this.cmL);
    }
    PublicFragmentActivity.b.startForResult(this.mActivity, localIntent, PublicTransFragmentActivity.class, AudioRecordFragment.class, 1003);
  }
  
  public void dWG()
  {
    Object localObject = a(1.0F, 0.0F);
    Animation localAnimation = a(0.0F, 1.0F);
    ((Animation)localObject).setAnimationListener(new aoru(this, localAnimation));
    localAnimation.setAnimationListener(new aorv(this));
    if (this.HN.getVisibility() == 0) {
      this.HN.startAnimation((Animation)localObject);
    }
    for (int i = this.HN.getMeasuredHeight();; i = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.getMeasuredHeight())
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.getMeasuredHeight();
      localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, ((ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.getLayoutParams()).bottomMargin + j - i);
      ((TranslateAnimation)localObject).setDuration(200L);
      ((TranslateAnimation)localObject).setFillAfter(true);
      this.HO.startAnimation((Animation)localObject);
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.getVisibility() != 0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.startAnimation((Animation)localObject);
    }
  }
  
  protected void dWH()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel = ((TribeHotPicPanel)LayoutInflater.from(this.mActivity).inflate(2131563227, null));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.a(this.app, this.mActivity, this);
      this.bX.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel, -1, aqcx.dip2px(this.mActivity, 250.0F));
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.onShow();
    aprl.e("pub_page_new", "exp_gif", 0, 0, new String[] { "", "" });
  }
  
  public void dWI()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.kd(5, 0);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.isShown())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.yQ(false);
    }
  }
  
  protected void dWJ()
  {
    Object localObject2 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar != null) {
      We(this.dRA);
    }
    label124:
    Object localObject1;
    if ((this.dRA & 0x1) == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setNumColumns(5);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setOnItemClickListener(this);
      if (this.jdField_a_of_type_Aour != null) {
        this.jdField_a_of_type_Aour.onDestroy();
      }
      this.jdField_a_of_type_Aour = new aour(this, this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setAdapter(this.jdField_a_of_type_Aour);
      if (!this.bSH) {
        break label416;
      }
      this.jdField_aG_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.eA = TroopBarPublishUtils.a(this, this.bW, this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText, this);
      this.jdField_aG_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      if (!this.cOr) {
        break label428;
      }
      this.HM.setVisibility(0);
      this.HM.setOnClickListener(this);
      this.DZ.setOnClickListener(this);
      label155:
      this.ZZ.setOnClickListener(this);
      this.kJ.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setHint(this.cmM);
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.dRx), new b() });
      TEditText localTEditText;
      if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText().length() <= 0)
      {
        localTEditText = this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText;
        if (TextUtils.isEmpty(this.cmN)) {
          break label440;
        }
        localObject1 = this.cmN;
        label253:
        localTEditText.setText((CharSequence)localObject1);
      }
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setHint(this.bwy);
      if (this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getText().length() <= 0)
      {
        localTEditText = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.cmT)) {
          localObject1 = this.cmT;
        }
        localTEditText.setText((CharSequence)localObject1);
      }
      if ((this.cOr) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name)) {
          break label445;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.Tr;
        label346:
        d(1, new String[] { localObject1 });
      }
      if (this.cu.size() <= 0) {
        break label456;
      }
      a(this.mHandler, this.cu);
      Wd(1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {
        a(2, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
      }
      return;
      this.HN.setVisibility(8);
      break;
      label416:
      this.jdField_aG_of_type_AndroidWidgetImageButton.setVisibility(8);
      break label124;
      label428:
      this.HM.setVisibility(8);
      break label155;
      label440:
      localObject1 = null;
      break label253;
      label445:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name;
      break label346;
      label456:
      Wd(0);
    }
  }
  
  protected void dWK()
  {
    switch (this.dRB)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.dRA & 0x2) != 2);
        dWF();
        return;
      } while ((this.dRA & 0x1) != 1);
      this.N = TroopBarPublishUtils.a(this.mActivity, new aort(this));
      return;
    } while ((this.dRA & 0x1) != 1);
    TroopBarPublishUtils.a(this.mActivity, this.cu, this.dRy);
  }
  
  protected void ddc()
  {
    int j = 0;
    if (this.cOm) {}
    aprv.a locala;
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopBar", 2, "publish save key = " + this.uP);
      }
      if (!TextUtils.isEmpty(this.uP))
      {
        locala = new aprv.a();
        Object localObject;
        int i;
        if (this.cu != null)
        {
          localObject = new ArrayList();
          i = 0;
          while (i < this.cu.size())
          {
            ((ArrayList)localObject).add(this.cu.get(i));
            i += 1;
          }
          locala.cu = ((ArrayList)localObject);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
        {
          locala.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
          if (this.kd != null)
          {
            localObject = new ArrayList();
            i = j;
            while (i < this.kd.size())
            {
              ((ArrayList)localObject).add(new TroopBarPOI((TroopBarPOI)this.kd.get(i)));
              i += 1;
            }
            locala.kd = ((ArrayList)localObject);
          }
        }
        locala.dRw = this.dRw;
        locala.dRx = this.dRx;
        locala.cmM = this.cmM;
        locala.cLN = this.cLN;
        locala.cLO = this.cLO;
        locala.bwy = this.bwy;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {}
        try
        {
          locala.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.clone());
          if ((this instanceof TroopBarPublishActivity))
          {
            localObject = (TroopBarPublishActivity)this;
            locala.mTitle = a(((TroopBarPublishActivity)localObject).a, ((TroopBarPublishActivity)localObject).cni);
            locala.mContent = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getEditableText().toString();
            aprv.ot.put(this.uP, locala);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("TroopBar", 2, "publish save key = " + this.uP + ", data = " + locala);
          }
        }
        catch (CloneNotSupportedException localCloneNotSupportedException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("IphoneTitleBarActivity", 2, QLog.getStackTraceString(localCloneNotSupportedException));
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getEditableText().toString();; str = null)
    {
      locala.mTitle = str;
      break;
    }
  }
  
  public void delete()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText != null) {
      aofy.g(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramInt1)
          {
          default: 
            return;
          }
        } while (this.N == null);
        paramIntent = aqhu.getRealPathFromContentURI(this, this.N);
        aqhu.cn(this, paramIntent);
        a(this.mHandler, paramIntent);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.mStop = true;
        }
      } while (!this.cOo);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, null, this.cu, this.cmO);
      ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramIntent.getParcelableExtra("key_selected_poi"));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name)) {}
        for (paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.Tr;; paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name)
        {
          d(1, new String[] { paramIntent });
          return;
        }
      }
      d(0, new String[0]);
      return;
      a(2, (AudioInfo)paramIntent.getSerializableExtra("audio_info"));
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$AudioUploadTask = new TroopBarPublishUtils.AudioUploadTask(this, this.mHandler, "https://upload.buluo.qq.com/cgi-bin/bar/upload/meida", this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$AudioUploadTask, 5, null, true);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.aiL = System.currentTimeMillis();
    this.mActivity = this;
    this.cOv = true;
    paramBundle = getIntent().getExtras();
    if (paramBundle == null)
    {
      QQToast.a(this, 1, getString(2131698504, new Object[] { Integer.valueOf(990) }), 0).show(getTitleBarHeight());
      finish();
      return false;
    }
    paramBundle = paramBundle.getString("options");
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "publish option: " + paramBundle);
    }
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(paramBundle);
        this.mGroupType = paramBundle.optInt("groupType", 1);
        this.cmP = paramBundle.optString("barTitle");
        this.cmQ = paramBundle.optString("selectTitle");
        this.cmR = paramBundle.optString("selectContent");
        this.cmS = paramBundle.optString("selectUrl");
        this.cLN = paramBundle.optInt("minContentLength", 10);
        this.cLO = paramBundle.optInt("maxContentLength", 700);
        this.bwy = paramBundle.optString("contentPlaceholder", this.bwy);
        this.cmW = getString(2131698473, new Object[] { Integer.valueOf(this.cLO) });
        this.mContent = paramBundle.optString("content", null);
        this.cOs = paramBundle.optBoolean("photoOrContent");
        this.cOp = paramBundle.optBoolean("needDestination", true);
        this.cOq = paramBundle.optBoolean("needTitle", true);
        this.cOr = paramBundle.optBoolean("needLocation", true);
        this.bSH = paramBundle.optBoolean("needFace", true);
        this.cOt = paramBundle.optBoolean("isReply", true);
        this.cOo = paramBundle.optBoolean("isPreUpload", true);
        this.mFrom = paramBundle.optString("from", "");
        this.mTroopUin = paramBundle.optString("groupUin", "");
        this.mFlag = paramBundle.optInt("flag");
        if (paramBundle.optInt("recordTimeLimit") == 0)
        {
          i = 60000;
          this.dRz = i;
          if (paramBundle.optInt("requireType", 0) == 0) {
            break label642;
          }
          bool = true;
          this.cOu = bool;
          if (!"barindex".equals(this.mFrom)) {
            break label647;
          }
          i = 1;
          this.dRA = paramBundle.optInt("optionType", i);
          this.uP = paramBundle.optString("cacheKey");
          this.dRB = paramBundle.optInt("defaultCategory", 0);
          this.dRy = paramBundle.optInt("maxPhotoCount", 9);
          this.dRC = paramBundle.optInt("forbiddenType", 0);
          this.cmU = paramBundle.optString("forbiddenMsg", getString(2131699468));
          aN(paramBundle);
          if (this.dRB == 0) {
            aAx();
          }
          Sf(paramBundle.optString("image_list", null));
          initUI();
          if (Build.VERSION.SDK_INT < 23) {
            break label661;
          }
          if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            break label652;
          }
          requestPermissions(new aoro(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
          return true;
        }
      }
      catch (Exception paramBundle)
      {
        QQToast.a(this, 1, getString(2131698504, new Object[] { Integer.valueOf(999) }), 0).show(getTitleBarHeight());
        finish();
        return false;
      }
      int i = paramBundle.optInt("recordTimeLimit") * 1000;
      continue;
      label642:
      boolean bool = false;
      continue;
      label647:
      i = 0;
      continue;
      label652:
      a(this, this);
      continue;
      label661:
      a(this, this);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.stopAudio();
    try
    {
      unregisterReceiver(this.bB);
      if (!this.cOn) {
        ddc();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText != null) {
        this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.removeTextChangedListener(this);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText != null) {
        this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.removeTextChangedListener(this);
      }
      if (this.jdField_a_of_type_Aour != null) {
        this.jdField_a_of_type_Aour.onDestroy();
      }
      if (this.jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a != null) {
        SosoInterface.c(this.jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$a);
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AbsPublishActivity", 4, "unregisterReceiver(mItemDeleteReceiver) exception");
        }
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if (paramIntent != null)
      {
        a(this.mHandler, paramIntent);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.mStop = true;
        }
        if (this.cOo) {
          break label54;
        }
      }
    }
    return;
    label54:
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, null, this.cu, this.cmO);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.stopAudio();
    this.cOv = false;
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.stopAudio();
    if (this.mHandler != null)
    {
      this.mHandler.removeMessages(1001);
      this.mHandler.removeMessages(1003);
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText != null) {
      aurd.hide(this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText);
    }
    overridePendingTransition(0, 2130771990);
  }
  
  public void gq() {}
  
  public void hideProgressDialog()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing())) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  public void i(BaseActivity paramBaseActivity, String paramString)
  {
    if ((this.mActionSheet != null) && (this.mActionSheet.isShowing())) {
      return;
    }
    paramBaseActivity = ausj.b(paramBaseActivity);
    paramBaseActivity.addButton(2131719499, 1);
    paramBaseActivity.addButton(2131719488, 1);
    paramBaseActivity.addCancelButton(2131721058);
    paramBaseActivity.a(new aorp(this, paramBaseActivity));
    paramBaseActivity.show();
    this.mActionSheet = paramBaseActivity;
  }
  
  @SuppressLint({"NewApi"})
  protected void initUI()
  {
    setContentView(2131560110);
    getTitleBarView().setBackgroundColor(-1);
    setLeftButton(2131721058, null);
    this.leftViewNotBack.setTextColor(-16777216);
    setRightButton(2131698465, this);
    this.rightViewText.setTextColor(-16777216);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getWindow().addFlags(67108864);
      this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      this.mSystemBarComp.init();
    }
    if (AppSetting.enableTalkBack)
    {
      this.leftViewNotBack.setContentDescription(getString(2131698469));
      this.rightViewText.setContentDescription(getString(2131698466));
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout = ((InputMethodLinearLayout)findViewById(2131377556));
    this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)findViewById(2131377757));
    this.jdField_aG_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131368967));
    Object localObject = getResources().getDisplayMetrics();
    this.bW = ((FrameLayout)findViewById(2131370190));
    this.HM = findViewById(2131374433);
    this.ZY = ((TextView)findViewById(2131374434));
    this.ZY.setMaxWidth(((DisplayMetrics)localObject).widthPixels / 2);
    this.ZZ = ((TextView)findViewById(2131374436));
    this.ZZ.setMaxWidth(((DisplayMetrics)localObject).widthPixels / 2);
    this.kJ = ((LinearLayout)findViewById(2131374435));
    this.DZ = ((ImageView)findViewById(2131374432));
    this.v = ((ListView)findViewById(2131373550));
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText = ((TEditText)findViewById(2131366547));
    this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText = ((TEditText)findViewById(2131366529));
    this.bA = ((EditText)findViewById(2131366531));
    this.bz = ((EditText)findViewById(2131366548));
    this.aaa = ((TextView)findViewById(2131381032));
    this.HN = findViewById(2131370219);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView = ((ExtendGridView)findViewById(2131373527));
    this.bX = ((FrameLayout)findViewById(2131370217));
    this.me = ((RelativeLayout)findViewById(2131370189));
    this.kK = ((LinearLayout)findViewById(2131374479));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer = ((PublishItemContainer)findViewById(2131373816));
    this.HO = findViewById(2131366618);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar = ((PublishItemBar)this.me.findViewById(2131373815));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setCallback(this.mHandler);
    if (this.dRA == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(8);
      this.HN.setVisibility(8);
      this.HN.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setVisibility(8);
      if (!this.cOq) {
        break label786;
      }
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setOnFocusChangeListener(this);
    }
    for (;;)
    {
      localObject = getResources().getDisplayMetrics();
      if ((localObject != null) && (((DisplayMetrics)localObject).heightPixels <= 800)) {
        this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setMinLines(3);
      }
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.addTextChangedListener(this);
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setOnTouchListener(this);
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setOnFocusChangeListener(this);
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setFilters(new InputFilter[] { new a() });
      this.jdField_b_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.setOnSizeChangedListenner(this);
      this.jdField_a_of_type_ComTencentWidgetScrollView.setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentWidgetScrollView.setOverScrollMode(2);
      localObject = getResources().getDrawable(2130844388);
      ((Drawable)localObject).setColorFilter(new LightingColorFilter(0, -10591367));
      this.ZY.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      if (this.ZZ != null)
      {
        localObject = getResources().getDrawable(2130844395);
        ((Drawable)localObject).setColorFilter(new LightingColorFilter(0, -18432));
        this.ZZ.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      }
      dWJ();
      if (!TextUtils.isEmpty(this.mContent)) {
        this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setText(this.mContent);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.Gs(this.dRA);
      break;
      label786:
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setVisibility(8);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public abstract void jM(int paramInt1, int paramInt2);
  
  public boolean lS(int paramInt)
  {
    Object localObject = null;
    if ((this.dRC & paramInt) == paramInt)
    {
      switch (paramInt)
      {
      }
      while (localObject != null)
      {
        QQToast.a(this, (CharSequence)localObject, 0).show(getTitleBarHeight());
        return true;
        localObject = getString(2131699491, new Object[] { this.cmU });
        continue;
        localObject = getString(2131699490, new Object[] { this.cmU });
      }
    }
    return false;
  }
  
  public boolean onBackEvent()
  {
    if ((this.eA != null) && (this.eA.getVisibility() == 0))
    {
      avV();
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.stopAudio();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = 2;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.cOl = this.cOk;
      Object localObject1;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
        {
          requestPermissions(new aorw(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        }
        else
        {
          localObject1 = new Intent(this, TroopBarPublishLocationSelectActivity.class);
          ((Intent)localObject1).putParcelableArrayListExtra("current_location_list", this.kd);
          ((Intent)localObject1).putExtra("key_selected_poi", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
          startActivityForResult((Intent)localObject1, 1002);
          overridePendingTransition(2130772004, 2130772005);
        }
      }
      else
      {
        localObject1 = new Intent(this, TroopBarPublishLocationSelectActivity.class);
        ((Intent)localObject1).putParcelableArrayListExtra("current_location_list", this.kd);
        ((Intent)localObject1).putExtra("key_selected_poi", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        startActivityForResult((Intent)localObject1, 1002);
        overridePendingTransition(2130772004, 2130772005);
        continue;
        this.cOl = this.cOk;
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = null;
        d(0, new String[0]);
        if ((this.ZZ != null) && (this.ZZ.getVisibility() == 0)) {
          label277:
          if (!TextUtils.isEmpty(this.mBid)) {
            break label328;
          }
        }
        label328:
        for (localObject1 = "0";; localObject1 = this.mBid)
        {
          anot.a(null, "dc00899", "pub_page_new", "", "pub_page", "del_place", i, 0, (String)localObject1, "", "", "");
          break;
          i = 1;
          break label277;
        }
        localObject1 = new Intent(this, QQBrowserActivity.class);
        Object localObject2 = new StringBuilder().append("https://buluo.qq.com/mobile/publish_tribe.html?_wv=1027&timestamp=").append(this.aiL).append("&optionType=");
        int j;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer == null)
        {
          j = 0;
          label387:
          ((Intent)localObject1).putExtra("url", j);
          startActivityForResult((Intent)localObject1, 1004);
          if (!TextUtils.isEmpty(this.mBid)) {
            break label502;
          }
          localObject1 = "choose_tribe";
          label429:
          if ((this.ZZ == null) || (this.ZZ.getVisibility() != 0)) {
            break label510;
          }
          label446:
          if (!TextUtils.isEmpty(this.mBid)) {
            break label515;
          }
        }
        label515:
        for (localObject2 = "0";; localObject2 = this.mBid)
        {
          anot.a(null, "dc00899", "pub_page_new", "", "pub_page", (String)localObject1, i, 0, (String)localObject2, "", "", "");
          break;
          j = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.getCurType();
          break label387;
          label502:
          localObject1 = "change_tribe";
          break label429;
          label510:
          i = 1;
          break label446;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.stopAudio();
        bsq();
        continue;
        if (System.currentTimeMillis() - this.Ap >= 500L)
        {
          this.Ap = System.currentTimeMillis();
          dWI();
          if (this.eA != null) {
            if (this.eA.getVisibility() == 0)
            {
              this.eA.setVisibility(8);
              this.mHandler.postDelayed(new AbsPublishActivity.5(this), 200L);
            }
            else
            {
              aurd.hide(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
              this.mHandler.postDelayed(new AbsPublishActivity.6(this), 200L);
            }
          }
        }
      }
    }
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    this.HP = paramView;
    if (paramView == this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText) {
      if (paramBoolean)
      {
        this.kK.setVisibility(0);
        if (this.me.getVisibility() == 8) {
          this.me.setVisibility(0);
        }
        if (!this.cOk) {
          this.mHandler.postDelayed(new AbsPublishActivity.9(this), 200L);
        }
      }
    }
    while (paramView != this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText)
    {
      return;
      this.kK.setVisibility(8);
      return;
    }
    this.kK.setVisibility(8);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    c(paramView, paramInt, paramLong);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return false;
      if ((this instanceof TroopBarPublishActivity))
      {
        paramView = (TroopBarPublishActivity)this;
        if ((paramView.b != null) && (paramView.b.isShow()))
        {
          paramView.b.hide();
          paramView.Rm(true);
          return true;
        }
      }
      if ((1 == paramMotionEvent.getAction()) && (!this.cOk) && (((this.eA != null) && (this.eA.getVisibility() == 0)) || ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.isShown()))))
      {
        if (this.eA != null) {
          this.eA.setVisibility(8);
        }
        dWI();
        return false;
        if ((this instanceof TroopBarPublishActivity))
        {
          paramView = (TroopBarPublishActivity)this;
          if ((paramView.b != null) && (paramView.b.isShow()))
          {
            paramView.b.hide();
            paramView.Rm(true);
            return true;
          }
        }
        if ((paramMotionEvent.getAction() == 2) && (this.cOk))
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText != null) && (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.hasFocus())) {
            aurd.hide(this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText);
          }
          if (this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText != null) {
            aurd.hide(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
          }
        }
      }
    }
  }
  
  protected boolean r(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      return true;
      String str = null;
      if (((paramInt & 0x1) == 1) && (this.cu.size() == 0)) {
        str = getString(2131699470, new Object[] { getString(2131699485) });
      }
      while (str != null)
      {
        QQToast.a(this, str, 0).show(getTitleBarHeight());
        return false;
        if (((paramInt & 0x2) == 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo == null)) {
          str = getString(2131699470, new Object[] { getString(2131699471) });
        } else if ((paramInt & 0x4) == 4) {
          str = getString(2131699470, new Object[] { getString(2131699482) });
        } else if ((paramInt & 0x8) == 8) {
          str = getString(2131699470, new Object[] { getString(2131699489) });
        }
      }
    }
  }
  
  public void send() {}
  
  public void setting() {}
  
  public void uV(boolean paramBoolean)
  {
    Rg(paramBoolean);
  }
  
  public void xa(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mProgress == null) {
        this.mProgress = new arhz(this, getTitleBarHeight());
      }
      this.mProgress.setMessage(KX());
      this.mProgress.show();
    }
    while ((this.mProgress == null) || (!this.mProgress.isShowing())) {
      return;
    }
    this.mProgress.dismiss();
  }
  
  class a
    implements InputFilter
  {
    a() {}
    
    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      if (paramCharSequence != null)
      {
        paramCharSequence = paramCharSequence.toString();
        if (aprv.a(paramCharSequence, '\n') + aprv.a(paramSpanned.toString(), '\n') > 100) {
          return paramCharSequence.replaceAll("\n", "");
        }
      }
      return null;
    }
  }
  
  class b
    implements InputFilter
  {
    b() {}
    
    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      if (paramCharSequence != null)
      {
        paramCharSequence = paramCharSequence.toString();
        if (paramCharSequence.contains("\n")) {
          return paramCharSequence.replaceAll("\n", "");
        }
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.AbsPublishActivity
 * JD-Core Version:    0.7.0.1
 */