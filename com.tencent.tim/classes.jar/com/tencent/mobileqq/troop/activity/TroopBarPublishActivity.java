package com.tencent.mobileqq.troop.activity;

import acfp;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aniq;
import anot;
import aoqv;
import aora;
import aork;
import aorm;
import aorm.b;
import aorm.d;
import aour;
import aous;
import aout;
import aouu;
import aouv;
import aoux;
import aova;
import aovb;
import aovc;
import aovd;
import aove;
import aovf;
import aovg;
import aovh;
import aovj;
import aovk;
import aovl;
import aprl;
import aprv;
import aqcx;
import aqfy;
import aqha;
import aqhu;
import aqmj;
import aqmz;
import arhz;
import aurd;
import ayyh;
import ayyh.a;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopBarAbsDataEntity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams.ChangeFace;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams.ComboInfo;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams.Filter;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams.Music;
import com.tencent.mobileqq.tribe.videoupload.TribeVideoUploadTask;
import com.tencent.mobileqq.tribe.view.TEditText;
import com.tencent.mobileqq.tribe.view.TribeThemeSpan;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.troop.widget.PublishItemBar;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.troop.widget.TribeHotPicPanel;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import jnl;
import jqc;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pog;
import poj;
import rox;
import rrb;
import rsz;

public class TroopBarPublishActivity
  extends AbsPublishActivity
  implements TextWatcher
{
  public static final String CLASS_NAME = TroopBarPublishActivity.class.getName();
  public static String cne = "";
  protected ImageView Ed;
  public List<TroopBarMyBar> Hm;
  private List<aorm.d> Hn;
  private JSONArray P;
  Animation.AnimationListener a;
  public aora a;
  public aorm.d a;
  public TroopBarMyBar a;
  private TextView aae;
  protected TextView aaf;
  public aoqv b;
  private aorm jdField_b_of_type_Aorm;
  private TribeVideoUploadTask jdField_b_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask;
  private TroopBarPublishUtils.PicUploadThread jdField_b_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread;
  private JSONObject bP;
  protected boolean cOQ;
  public boolean cOR;
  boolean cOS = false;
  private boolean cOT = true;
  protected boolean cOU;
  protected boolean cOV;
  protected String cnc;
  public String cnd = "";
  public String cnf = "";
  protected String cng;
  private String cnh;
  public String cni = "    ";
  protected String cnj;
  protected int dRM;
  public final int dRN = 5;
  public int dRO;
  public int dRP;
  public int dRQ;
  public int dRR = -1;
  private int dRS = 0;
  private Handler dw = new aous(this);
  private Handler dx = new aovd(this);
  public PublishVideoEntry k;
  protected CharSequence mContentText = "";
  private String mTitle;
  public String mVideoPath;
  protected RelativeLayout mg;
  
  public TroopBarPublishActivity()
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new aovg(this);
  }
  
  private String AS()
  {
    switch (this.dRS)
    {
    default: 
      return "1";
    case 150: 
      return "4";
    case 700: 
      return "3";
    }
    return "2";
  }
  
  private boolean aAD()
  {
    return (this.mProgress != null) && (this.mProgress.isShowing());
  }
  
  private void bf(String paramString, long paramLong)
  {
    aniq.dFI = 2000000;
    String str1 = paramString + ".doodle.mp4";
    String str2 = paramString + ".tmp.mp4";
    Object localObject = new ayyh.a(aniq.dFI, this.k);
    ((ayyh.a)localObject).TV(2);
    int i = new ayyh().a(paramString, str1, (ayyh.a)localObject, this.k);
    if (i != 0)
    {
      if (i == -1) {
        rox.copyFile(paramString, str1);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("tribe_publish_TroopBarPublishActivity", 1, "onCompositeFinish step 1 timeCost:" + (SystemClock.uptimeMillis() - paramLong) + "ms bitrate:" + aniq.dFI);
      }
      paramString = new MediaMetadataRetriever();
      paramString.setDataSource(str1);
      localObject = paramString.getFrameAtTime();
      this.jdField_a_of_type_Aora.width = ((Bitmap)localObject).getWidth();
      this.jdField_a_of_type_Aora.height = ((Bitmap)localObject).getHeight();
      paramString.release();
      if (this.k.videoRangeEnd == 0) {
        break label309;
      }
    }
    label309:
    for (this.jdField_a_of_type_Aora.duration = (this.k.videoRangeEnd - this.k.videoRangeStart); (this.k.isMuteRecordVoice) && (TextUtils.isEmpty(this.k.backgroundMusicPath)); this.jdField_a_of_type_Aora.duration = ((int)this.k.videoDuration))
    {
      bh(str1, paramLong);
      return;
      QLog.i("tribe_publish_TroopBarPublishActivity", 1, "getVideoMeta failed. merge file path:" + paramString + " merge result:" + i);
      bh(null, paramLong);
      return;
    }
    if (TextUtils.isEmpty(this.k.backgroundMusicPath))
    {
      paramString = this.k.mLocalRawVideoDir;
      try
      {
        if (this.k.videoRangeEnd == 0) {}
        for (i = rrb.a(str1, paramString, str2, 0);; i = rrb.a(str1, paramString, str2, 0, this.k.videoRangeStart, this.k.videoRangeEnd))
        {
          rox.deleteFile(str1);
          if ((i != 0) && (i != -8)) {
            break;
          }
          bg(str2, paramLong);
          return;
        }
        QLog.i("tribe_publish_TroopBarPublishActivity", 1, "merge voice failed. merge file path:" + str1 + " merge result:" + i);
      }
      catch (Exception paramString)
      {
        QLog.d("TroopBarPublishActivity", 1, "e = " + paramString);
        bh(null, paramLong);
        return;
      }
      bh(null, paramLong);
      return;
    }
    new pog().a(this.k, str1, str2, true, new aoux(this, str1, paramLong, str2));
  }
  
  private void bg(String paramString, long paramLong)
  {
    if (AudioHelper.aCi())
    {
      int i = poj.bc(paramString);
      if (i == 0)
      {
        QLog.i("tribe_publish_TroopBarPublishActivity", 1, "isHuaweiGreen: reEncodeVideoWithFFMpeg succeed. output path = " + paramString);
        bh(paramString, paramLong);
        return;
      }
      QLog.i("tribe_publish_TroopBarPublishActivity", 1, "isHuaweiGreen: reEncodeVideoWithFFMpeg failed. errorCode = " + i);
      bh(null, paramLong);
      return;
    }
    bh(paramString, paramLong);
  }
  
  private void dL(Intent paramIntent)
  {
    this.dRR = paramIntent.getIntExtra("theme_id", -1);
    this.cnf = paramIntent.getStringExtra("theme_name");
    if (this.cOV)
    {
      if (!TextUtils.isEmpty(this.cnf))
      {
        this.cnf = ("#" + this.cnf);
        return;
      }
      this.cnf = acfp.m(2131715582);
      return;
    }
    this.cnf = "";
  }
  
  private void dXe()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText == null) || (this.bA == null)) {
      return;
    }
    int j = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getText().length();
    if (TextUtils.isEmpty(this.cnf))
    {
      i = 0;
      if (j > i) {
        break label176;
      }
      this.bA.setVisibility(0);
      if (this.dRR != -1) {
        break label169;
      }
    }
    label169:
    for (int i = 2130843431;; i = 2130843432)
    {
      Object localObject = new SpannableStringBuilder(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getText());
      ((SpannableStringBuilder)localObject).append(this.bwy);
      localObject = new SpannableString((CharSequence)localObject);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(0), 0, this.cnf.length(), 33);
      if (!TextUtils.isEmpty(this.cnf)) {
        ((SpannableString)localObject).setSpan(new rsz(this, i), 0, 1, 33);
      }
      this.bA.setText((CharSequence)localObject);
      return;
      i = this.cnf.length() + 1;
      break;
    }
    label176:
    this.bA.setVisibility(8);
  }
  
  private void dXf()
  {
    this.bA.setEnabled(false);
    if (!TextUtils.isEmpty(this.cnf)) {
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setMovementMethod(LinkMovementMethod.getInstance());
    }
    this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.addTextChangedListener(new aovl(this));
    this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setOnSelectionChangedListener(new aout(this));
    if (this.dRS == 700) {
      this.cnf = "";
    }
    Rl(false);
    if ((this.cOV) && (!TextUtils.isEmpty(this.cnf)) && (!aqmj.c(this, this.app.getCurrentAccountUin(), "tribe_video_post_has_show_tips", false))) {
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.post(new TroopBarPublishActivity.11(this));
    }
  }
  
  private void dXg()
  {
    if ((this.Hn == null) || (this.Hn.size() <= 0) || (!this.cOq)) {
      return;
    }
    if (this.Hn.size() == 1) {
      this.cni = "  ";
    }
    anot.a(null, "dc00899", "Grp_tribe", "", "pub_page", "exp_prefix", 0, 0, this.mBid, "", "", "");
    this.jdField_a_of_type_Aorm$d = ((aorm.d)this.Hn.get(0));
    this.jdField_b_of_type_Aorm = new aorm(this, this.v);
    this.jdField_b_of_type_Aorm.a(new a(null));
    this.jdField_b_of_type_Aoqv = new aoqv(this.v, this.jdField_b_of_type_Aorm, this.Hn);
    this.bz.setEnabled(false);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Aorm$d.cmJ)) {
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setMovementMethod(LinkMovementMethod.getInstance());
    }
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.addTextChangedListener(new aouu(this));
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setOnSelectionChangedListener(new aouv(this));
    Rm(false);
    this.jdField_b_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.setFocusableInTouchMode(true);
    int i = this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText().length();
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(i);
  }
  
  private void dXh()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText == null) || (this.bz == null) || (this.jdField_a_of_type_Aorm$d == null)) {
      return;
    }
    if (this.jdField_a_of_type_Aorm$d != null) {}
    for (int i = this.jdField_a_of_type_Aorm$d.cmJ.length() + this.jdField_a_of_type_Aorm$d.cmK.length() + this.jdField_a_of_type_Aorm$d.cmI.length();; i = 0)
    {
      int m = this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText().length();
      SpannableString localSpannableString;
      if ((this.jdField_a_of_type_Aorm$d == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Aorm$d.cmJ)))
      {
        j = 0;
        if (m > j) {
          break label330;
        }
        this.bz.setVisibility(0);
        localSpannableString = new SpannableString(new SpannableStringBuilder(this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText()).append(this.cmM));
        if (i > localSpannableString.length()) {
          break label282;
        }
        localSpannableString.setSpan(new ForegroundColorSpan(0), 0, this.cni.length() + i - 1, 33);
        label176:
        if ((this.Hn != null) && (this.Hn.size() > 1)) {
          if ((this.jdField_b_of_type_Aoqv == null) || (!this.jdField_b_of_type_Aoqv.aAw())) {
            break label323;
          }
        }
      }
      label282:
      label323:
      for (int j = 2130843429;; j = 2130843430)
      {
        if ((this.jdField_a_of_type_Aorm$d != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aorm$d.cmJ))) {
          localSpannableString.setSpan(new rsz(this, j), i + 1, i + 2, 33);
        }
        this.bz.setText(localSpannableString);
        return;
        j = this.cni.length() + i;
        break;
        QLog.e("TroopBarPublishActivity", 2, "updateTitlePrefix spannableString = " + localSpannableString + " prefixNum = " + i);
        break label176;
      }
      label330:
      this.bz.setVisibility(4);
      return;
    }
  }
  
  private void dXj()
  {
    QLog.i("tribe_publish_TroopBarPublishActivity", 1, "cancelUploadVideoTask");
    if (this.jdField_b_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask.bme();
      this.jdField_b_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask = null;
    }
  }
  
  public static String get(Context paramContext, String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (paramContext != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramString)) {
        str1 = paramContext.getSharedPreferences("bitapp_config", 0).getString(paramString, "");
      }
    }
    return str1;
  }
  
  public static boolean m(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramContext = paramContext.getSharedPreferences("bitapp_config", 0).edit();
        paramContext.putString(paramString1, paramString2);
        bool1 = paramContext.commit();
      }
    }
    return bool1;
  }
  
  public String AR()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.bP != null) {
        localJSONObject.put("suggestDestination", this.bP);
      }
      String str1 = this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText().toString();
      String str2 = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getText().toString();
      localJSONObject.put("inputTitle", str1);
      localJSONObject.put("inputContent", str2);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONObject.toString();
  }
  
  public void Rl(boolean paramBoolean)
  {
    int m = 0;
    Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getText();
    Object localObject3;
    int j;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject3 = (TribeThemeSpan[])((Spanned)localObject1).getSpans(0, ((CharSequence)localObject1).length(), TribeThemeSpan.class);
      j = 0;
      localObject2 = localObject1;
      if (j < localObject3.length)
      {
        int n = localObject3[j].end;
        if (TextUtils.isEmpty(this.cnf))
        {
          i = 0;
          label77:
          n = i + n;
          if (n <= ((CharSequence)localObject1).length()) {
            break label132;
          }
          i = ((CharSequence)localObject1).length();
        }
        for (;;)
        {
          localObject1 = ((CharSequence)localObject1).subSequence(i, ((CharSequence)localObject1).length());
          j += 1;
          break;
          i = 1;
          break label77;
          label132:
          i = n;
          if (!paramBoolean) {
            i = n - 1;
          }
        }
      }
    }
    else
    {
      localObject2 = localObject1;
    }
    if (this.dRR == -1)
    {
      i = -8947849;
      if (this.dRR != -1) {
        break label358;
      }
      j = 2130843431;
      label175:
      localObject3 = new StringBuilder().append(this.cnf);
      if (!TextUtils.isEmpty(this.cnf)) {
        break label365;
      }
      localObject1 = "";
      label205:
      localObject1 = new SpannableString((String)localObject1 + localObject2);
      ((SpannableString)localObject1).setSpan(new TribeThemeSpan(i, 0, this.cnf.length()), 0, this.cnf.length(), 33);
      if (!TextUtils.isEmpty(this.cnf)) {
        ((SpannableString)localObject1).setSpan(new rsz(this, j), 0, 1, 33);
      }
      ((SpannableString)localObject1).setSpan(new aovj(this, i), 0, this.cnf.length(), 33);
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setText((CharSequence)localObject1);
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText;
      if (!TextUtils.isEmpty(this.cnf)) {
        break label373;
      }
    }
    label358:
    label365:
    label373:
    for (int i = m;; i = this.cnf.length() + 1)
    {
      ((TEditText)localObject1).setSelection(i);
      dXe();
      return;
      i = -18432;
      break;
      j = 2130843432;
      break label175;
      localObject1 = " ";
      break label205;
    }
  }
  
  public void Rm(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aorm$d == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText();
    Object localObject2;
    if (localObject1 != null)
    {
      TribeThemeSpan[] arrayOfTribeThemeSpan = (TribeThemeSpan[])((Spanned)localObject1).getSpans(0, ((CharSequence)localObject1).length(), TribeThemeSpan.class);
      j = 0;
      localObject2 = localObject1;
      if (j < arrayOfTribeThemeSpan.length)
      {
        int m = arrayOfTribeThemeSpan[j].end;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Aorm$d.cmJ))
        {
          i = 0;
          label85:
          m = i + m;
          if (m <= ((CharSequence)localObject1).length()) {
            break label146;
          }
          i = ((CharSequence)localObject1).length();
        }
        for (;;)
        {
          localObject1 = ((CharSequence)localObject1).subSequence(i, ((CharSequence)localObject1).length());
          j += 1;
          break;
          i = this.cni.length();
          break label85;
          label146:
          i = m;
          if (!paramBoolean) {
            i = m - 1;
          }
        }
      }
    }
    else
    {
      localObject2 = localObject1;
    }
    localObject1 = new SpannableStringBuilder(this.jdField_a_of_type_Aorm$d.cmI).append(this.jdField_a_of_type_Aorm$d.cmJ).append(this.jdField_a_of_type_Aorm$d.cmK);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Aorm$d.cmJ)) {
      ((SpannableStringBuilder)localObject1).append(this.cni);
    }
    ((SpannableStringBuilder)localObject1).append(localObject2);
    localObject1 = new SpannableString((CharSequence)localObject1);
    int i = this.jdField_a_of_type_Aorm$d.cmI.length();
    int j = this.jdField_a_of_type_Aorm$d.cmJ.length();
    j = this.jdField_a_of_type_Aorm$d.cmK.length() + (i + j);
    ((SpannableString)localObject1).setSpan(new TribeThemeSpan(-16777216, 0, j), 0, j, 33);
    if ((this.Hn != null) && (this.Hn.size() > 1)) {
      if ((this.jdField_b_of_type_Aoqv == null) || (!this.jdField_b_of_type_Aoqv.aAw())) {
        break label418;
      }
    }
    label418:
    for (i = 2130843429;; i = 2130843430)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aorm$d.cmJ)) {
        ((SpannableString)localObject1).setSpan(new rsz(this, i), j + 1, j + 2, 33);
      }
      ((SpannableString)localObject1).setSpan(new aovk(this), 0, j + this.cni.length() - 1, 33);
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setText((CharSequence)localObject1);
      dXh();
      return;
    }
  }
  
  protected void Wd(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0)
    {
      i = paramInt;
      if (this.jdField_a_of_type_Aora != null) {
        i = 4;
      }
    }
    super.Wd(i);
  }
  
  public void Wm(int paramInt)
  {
    boolean bool = false;
    if (paramInt == 8)
    {
      this.cu.remove(paramInt);
      localObject1 = this.jdField_a_of_type_Aour;
      if (this.cu.size() < this.dRQ) {
        bool = true;
      }
      ((aour)localObject1).C(bool, true);
      this.jdField_a_of_type_Aour.bF(this.cu);
    }
    label126:
    do
    {
      return;
      this.dRO = 0;
      this.cOR = true;
      localObject1 = a(1.0F, 0.0F);
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getChildAt(paramInt);
      if (localObject2 != null) {
        ((View)localObject2).startAnimation((Animation)localObject1);
      }
      paramInt += 1;
      if (paramInt < this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getCount())
      {
        int i;
        int j;
        if (paramInt % 5 == 0)
        {
          i = -1;
          j = 4;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getChildAt(paramInt);
          localObject2 = b(j, i);
          ((Animation)localObject2).setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
          if (localObject1 != null) {
            break label174;
          }
        }
        for (;;)
        {
          paramInt += 1;
          break;
          i = 0;
          j = -1;
          break label126;
          ((View)localObject1).startAnimation((Animation)localObject2);
          this.dRO += 1;
        }
      }
      paramInt = this.cu.size();
    } while ((paramInt != 4) && (paramInt != 8));
    label174:
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_a_of_type_Aour.KZ());
    ((TranslateAnimation)localObject1).setDuration(200L);
    ((TranslateAnimation)localObject1).setFillAfter(true);
    this.HO.startAnimation((Animation)localObject1);
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    super.a(paramJSONObject, paramInt, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("TroopBarPublishActivity", 2, "onResult requestCode = " + paramInt + " result = " + paramJSONObject);
    }
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (paramJSONObject != null)
      {
        if (paramJSONObject.optInt("retcode", -1) == -1) {
          break;
        }
        if ((this.cOm) && (this.cOQ))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = null;
          this.mBid = null;
        }
      }
      if (this.cOm) {
        hideProgressDialog();
      }
    } while (!this.cOQ);
    this.cOQ = false;
    return;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.flag = paramJSONObject.optInt("flag");
    }
    this.cOs = paramJSONObject.optBoolean("photoOrContent");
    this.mFrom = paramJSONObject.optString("from");
    this.cOj = paramJSONObject.optBoolean("needCategory", true);
    this.bSH = paramJSONObject.optBoolean("needFace", true);
    for (;;)
    {
      try
      {
        paramBundle = paramJSONObject.getJSONObject("publish_condition");
        if (paramBundle.optInt("requireType", 0) == 0) {
          continue;
        }
        bool = true;
        this.cOu = bool;
        if (this.cOm)
        {
          if (!this.cOQ) {
            continue;
          }
          this.dRA |= paramBundle.optInt("optionType");
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.flag == 1)) {
            this.dRA |= 0x1;
          }
        }
        if (this.dRS == 700)
        {
          this.dRA &= 0xB;
          this.dRA &= 0x7;
        }
        if (paramBundle.optInt("recordTimeLimit") != 0) {
          continue;
        }
        paramInt = 60000;
        this.dRz = paramInt;
        this.dRC = paramBundle.optInt("forbiddenType", 0);
        this.cmU = paramBundle.optString("forbiddenMsg", getString(2131699468));
      }
      catch (JSONException paramBundle)
      {
        boolean bool;
        continue;
      }
      aAx();
      this.mHandler.postDelayed(new TroopBarPublishActivity.3(this), 200L);
      bD(paramJSONObject);
      break;
      bool = false;
      continue;
      this.dRA = paramBundle.optInt("optionType");
      continue;
      paramInt = paramBundle.optInt("recordTimeLimit");
      paramInt *= 1000;
    }
  }
  
  public boolean aAC()
  {
    return TextUtils.isEmpty(get(this, "is_first_enter"));
  }
  
  /* Error */
  void aN(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: aload_1
    //   5: invokespecial 924	com/tencent/mobileqq/troop/activity/AbsPublishActivity:aN	(Lorg/json/JSONObject;)V
    //   8: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +30 -> 41
    //   14: ldc_w 330
    //   17: iconst_2
    //   18: new 184	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 926
    //   28: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 338	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_1
    //   42: ldc_w 928
    //   45: invokevirtual 842	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   48: invokestatic 934	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   51: lstore_3
    //   52: lload_3
    //   53: lconst_0
    //   54: lcmp
    //   55: ifne +526 -> 581
    //   58: aload_1
    //   59: ldc_w 665
    //   62: invokevirtual 937	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   65: ifeq +516 -> 581
    //   68: aload_0
    //   69: aload_1
    //   70: ldc_w 665
    //   73: invokevirtual 940	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   76: putfield 663	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:bP	Lorg/json/JSONObject;
    //   79: aload_0
    //   80: getfield 663	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:bP	Lorg/json/JSONObject;
    //   83: ifnull +498 -> 581
    //   86: aload_0
    //   87: getfield 663	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:bP	Lorg/json/JSONObject;
    //   90: ldc_w 928
    //   93: invokevirtual 943	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   96: lstore_3
    //   97: aload_0
    //   98: getfield 663	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:bP	Lorg/json/JSONObject;
    //   101: ldc_w 945
    //   104: invokevirtual 842	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: astore 6
    //   109: aload_0
    //   110: iconst_1
    //   111: putfield 95	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:cOS	Z
    //   114: aload_0
    //   115: aload_1
    //   116: ldc_w 947
    //   119: iconst_0
    //   120: invokevirtual 850	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   123: putfield 387	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:cOV	Z
    //   126: aload_0
    //   127: aload_1
    //   128: ldc_w 949
    //   131: invokevirtual 842	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   134: putfield 951	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:cnc	Ljava/lang/String;
    //   137: new 660	org/json/JSONObject
    //   140: dup
    //   141: aload_0
    //   142: getfield 951	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:cnc	Ljava/lang/String;
    //   145: invokespecial 953	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   148: astore 8
    //   150: aload_0
    //   151: aload 8
    //   153: ldc_w 955
    //   156: iconst_0
    //   157: invokevirtual 811	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   160: putfield 105	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:dRS	I
    //   163: aload_0
    //   164: aload_1
    //   165: ldc_w 957
    //   168: invokevirtual 961	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   171: putfield 963	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:P	Lorg/json/JSONArray;
    //   174: aload_0
    //   175: getfield 518	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:cOq	Z
    //   178: ifeq +35 -> 213
    //   181: aload_0
    //   182: getfield 147	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:Hn	Ljava/util/List;
    //   185: ifnull +12 -> 197
    //   188: aload_0
    //   189: getfield 147	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:Hn	Ljava/util/List;
    //   192: invokeinterface 966 1 0
    //   197: aload_0
    //   198: aload_0
    //   199: getfield 963	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:P	Lorg/json/JSONArray;
    //   202: invokestatic 969	aoqv:i	(Lorg/json/JSONArray;)Ljava/util/List;
    //   205: putfield 147	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:Hn	Ljava/util/List;
    //   208: aload_0
    //   209: aconst_null
    //   210: putfield 963	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:P	Lorg/json/JSONArray;
    //   213: aload_0
    //   214: aload_1
    //   215: ldc_w 971
    //   218: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   221: putfield 973	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:dRM	I
    //   224: lload_3
    //   225: lconst_0
    //   226: lcmp
    //   227: ifle +330 -> 557
    //   230: aload_0
    //   231: getfield 95	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:cOS	Z
    //   234: ifne +306 -> 540
    //   237: aload_0
    //   238: new 827	com/tencent/mobileqq/troop/data/TroopBarMyBar
    //   241: dup
    //   242: lload_3
    //   243: aload_1
    //   244: ldc_w 975
    //   247: invokevirtual 842	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   250: invokespecial 978	com/tencent/mobileqq/troop/data/TroopBarMyBar:<init>	(JLjava/lang/String;)V
    //   253: putfield 818	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   256: aload_0
    //   257: new 184	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   264: aload_0
    //   265: getfield 490	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   268: invokevirtual 495	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   271: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc_w 980
    //   277: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_0
    //   281: getfield 818	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   284: getfield 982	com/tencent/mobileqq/troop/data/TroopBarMyBar:bid	Ljava/lang/String;
    //   287: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc_w 980
    //   293: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_0
    //   297: getfield 105	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:dRS	I
    //   300: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: putfield 985	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:uP	Ljava/lang/String;
    //   309: aload_0
    //   310: aload_0
    //   311: getfield 818	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   314: getfield 982	com/tencent/mobileqq/troop/data/TroopBarMyBar:bid	Ljava/lang/String;
    //   317: putfield 531	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:mBid	Ljava/lang/String;
    //   320: aload_0
    //   321: getfield 105	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:dRS	I
    //   324: sipush 700
    //   327: if_icmpne +13 -> 340
    //   330: aload_0
    //   331: aload_0
    //   332: getfield 872	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:dRA	I
    //   335: iconst_3
    //   336: iand
    //   337: putfield 872	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:dRA	I
    //   340: aload_0
    //   341: ldc_w 524
    //   344: putfield 988	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:cmV	Ljava/lang/String;
    //   347: aload_0
    //   348: ldc_w 526
    //   351: putfield 991	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:mOpType	Ljava/lang/String;
    //   354: aload_0
    //   355: aload_1
    //   356: ldc_w 993
    //   359: invokevirtual 842	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   362: putfield 995	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:cnj	Ljava/lang/String;
    //   365: aload_0
    //   366: getfield 995	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:cnj	Ljava/lang/String;
    //   369: putstatic 1000	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:cnl	Ljava/lang/String;
    //   372: aload_0
    //   373: aload_1
    //   374: invokevirtual 1003	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:bC	(Lorg/json/JSONObject;)V
    //   377: aload_1
    //   378: ldc_w 1005
    //   381: invokevirtual 825	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   384: istore_2
    //   385: iload_2
    //   386: iconst_1
    //   387: if_icmplt +179 -> 566
    //   390: iload_2
    //   391: bipush 6
    //   393: if_icmpgt +173 -> 566
    //   396: iconst_1
    //   397: istore 5
    //   399: iload 5
    //   401: putstatic 1008	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:cOY	Z
    //   404: return
    //   405: astore 6
    //   407: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq +15 -> 425
    //   413: ldc_w 330
    //   416: iconst_2
    //   417: aload 6
    //   419: invokevirtual 1011	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   422: invokestatic 338	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: lconst_0
    //   426: lstore_3
    //   427: goto -375 -> 52
    //   430: astore 8
    //   432: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   435: ifeq -272 -> 163
    //   438: ldc_w 330
    //   441: iconst_2
    //   442: new 184	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   449: ldc_w 1013
    //   452: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload 7
    //   457: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   460: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 617	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: goto -303 -> 163
    //   469: astore 7
    //   471: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   474: ifeq -300 -> 174
    //   477: ldc_w 330
    //   480: iconst_2
    //   481: new 184	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   488: ldc_w 1015
    //   491: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload_1
    //   495: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   498: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 617	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   504: goto -330 -> 174
    //   507: astore 7
    //   509: ldc_w 330
    //   512: iconst_2
    //   513: new 184	java/lang/StringBuilder
    //   516: dup
    //   517: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   520: ldc_w 1017
    //   523: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: aload 7
    //   528: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   531: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   534: invokestatic 617	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   537: goto -324 -> 213
    //   540: aload_0
    //   541: new 827	com/tencent/mobileqq/troop/data/TroopBarMyBar
    //   544: dup
    //   545: lload_3
    //   546: aload 6
    //   548: invokespecial 978	com/tencent/mobileqq/troop/data/TroopBarMyBar:<init>	(JLjava/lang/String;)V
    //   551: putfield 818	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   554: goto -298 -> 256
    //   557: aload_0
    //   558: bipush 15
    //   560: putfield 872	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:dRA	I
    //   563: goto -243 -> 320
    //   566: iconst_0
    //   567: istore 5
    //   569: goto -170 -> 399
    //   572: astore 7
    //   574: aload 8
    //   576: astore 7
    //   578: goto -146 -> 432
    //   581: aconst_null
    //   582: astore 6
    //   584: goto -470 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	587	0	this	TroopBarPublishActivity
    //   0	587	1	paramJSONObject	JSONObject
    //   384	10	2	i	int
    //   51	495	3	l	long
    //   397	171	5	bool	boolean
    //   107	1	6	str	String
    //   405	142	6	localNumberFormatException	NumberFormatException
    //   582	1	6	localObject1	Object
    //   1	455	7	localObject2	Object
    //   469	1	7	localException1	Exception
    //   507	20	7	localException2	Exception
    //   572	1	7	localJSONException1	JSONException
    //   576	1	7	localObject3	Object
    //   148	4	8	localJSONObject	JSONObject
    //   430	145	8	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   41	52	405	java/lang/NumberFormatException
    //   137	150	430	org/json/JSONException
    //   163	174	469	java/lang/Exception
    //   181	197	507	java/lang/Exception
    //   197	213	507	java/lang/Exception
    //   150	163	572	org/json/JSONException
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    this.cLP = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getSelectionStart();
    this.cLQ = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getSelectionEnd();
    String str = aprv.f(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
    int j;
    if (str == null)
    {
      i = 0;
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishActivity", 2, "onTextChanged: " + i + "--" + this.cLP + "--" + this.cLQ);
      }
      if ((this.cLO <= 0) || (i <= this.cLO)) {
        break label265;
      }
      j = i - this.cLO;
      paramEditable.delete(this.cLP - j, this.cLQ);
      this.cLP -= j;
      this.cLQ -= j;
      i = j;
      if (!this.aG.booleanValue())
      {
        QQToast.a(this, this.cmW, 0).show(getTitleBarHeight());
        this.aG = Boolean.valueOf(true);
      }
    }
    for (int i = j;; i = 0)
    {
      if (this.cLP + i >= 0) {
        break label278;
      }
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(0);
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishActivity", 2, "onTextChanged: editStart + diff < 0 -> " + (i + this.cLP));
      }
      return;
      i = str.length();
      break;
      label265:
      this.aG = Boolean.valueOf(false);
    }
    label278:
    this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(i + this.cLP);
  }
  
  public Animation b(float paramFloat1, float paramFloat2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, paramFloat1, 1, 0.0F, 1, paramFloat2);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setDuration(200L);
    return localTranslateAnimation;
  }
  
  protected void bC(JSONObject paramJSONObject)
  {
    this.cOm = paramJSONObject.optBoolean("share_from_app");
    this.bN = paramJSONObject.optJSONObject("share_info");
    if (!this.cOm) {
      return;
    }
    aqmz.j(this.app, "share_ask", paramJSONObject.optString("bid"));
    this.cOr = true;
    this.bSH = true;
    this.cOj = false;
    this.mFrom = "";
    this.dRw = 4;
    this.dRx = 25;
    this.cmM = getString(2131698490, new Object[] { Integer.valueOf(this.dRw), Integer.valueOf(this.dRx) });
    this.cLN = 10;
    this.cLO = 700;
    this.bwy = getString(2131698474, new Object[] { Integer.valueOf(this.cLN), Integer.valueOf(this.cLO) });
    this.dRA |= 0x1;
  }
  
  protected void bD(JSONObject paramJSONObject)
  {
    if ((this.cOm) && (this.cOQ) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.name = paramJSONObject.optString("barName");
      this.ZZ.setText(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.name);
      this.ZZ.setTextColor(Color.parseColor("#638EC3"));
      this.ZZ.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.name);
    }
  }
  
  public void bh(String paramString, long paramLong)
  {
    if (isFinishing())
    {
      pog.b(pog.a(this.cng));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("tribe_publish_TroopBarPublishActivity", 1, "onCompositeFinish total timeCost:" + (SystemClock.uptimeMillis() - paramLong) + "ms");
    }
    this.mHandler.post(new TroopBarPublishActivity.16(this, paramString));
  }
  
  public void bsq()
  {
    int j = 2;
    try
    {
      aurd.hide(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
      if (!aAD())
      {
        if ("barindex".equals(this.mFrom))
        {
          i = 1;
          anot.a(null, "dc00899", "Grp_tribe", "", "post", "Clk_post ", i, 0, AS(), "", "", "");
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.mStop = true;
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = null;
        }
        if (!this.aaf.getText().toString().equals(acfp.m(2131715604))) {
          break label115;
        }
        dXi();
      }
      label115:
      Object localObject1;
      do
      {
        return;
        i = 2;
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$AudioUploadTask != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$AudioUploadTask.La() != 0))
        {
          xa(true);
          this.rightViewText.setEnabled(false);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(false);
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(false);
          return;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) && (this.dRM == 0))
        {
          QQToast.a(this, 2131698481, 1).show(getTitleBarHeight());
          if (this.ZZ != null)
          {
            this.ZZ.setTextColor(Color.parseColor("#FF725A"));
            localObject1 = getResources().getDrawable(2130844395);
            ((Drawable)localObject1).setColorFilter(new LightingColorFilter(0, -36262));
            this.ZZ.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject1, null, null, null);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
          for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid)
          {
            aprv.report("pub_page", "fail", (String)localObject1, "8", AS(), "");
            return;
          }
        }
        if (this.cOq)
        {
          localObject1 = aprv.f(this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label2032;
          }
          localObject2 = ((String)localObject1).trim();
          int m = ((String)localObject2).length();
          i = m;
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Aorm$d != null)
          {
            i = m;
            localObject1 = localObject2;
            if (m > this.cni.length() + this.jdField_a_of_type_Aorm$d.cmK.length() + this.jdField_a_of_type_Aorm$d.cmJ.length() + this.jdField_a_of_type_Aorm$d.cmI.length())
            {
              i = m - this.cni.length();
              localObject1 = localObject2;
            }
          }
          if (i < this.dRw)
          {
            QQToast.a(this, getString(2131698487, new Object[] { Integer.valueOf(this.dRw) }), 0).show(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid)
            {
              aprv.report("pub_page", "fail", (String)localObject1, "0", AS(), "");
              return;
            }
          }
          if (i > this.dRx)
          {
            QQToast.a(this, getString(2131698488, new Object[] { Integer.valueOf(this.dRx) }), 0).show(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid)
            {
              aprv.report("pub_page", "fail", (String)localObject1, "1", AS(), "");
              return;
            }
          }
        }
        else
        {
          if ((TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getText().toString())) && ((this.cu == null) || (this.cu.isEmpty())))
          {
            QQToast.a(this, 2131698472, 0).show(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid)
            {
              aprv.report("pub_page", "fail", (String)localObject1, "35", AS(), "");
              return;
            }
          }
          localObject1 = null;
        }
        localObject3 = aprv.f(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
        localObject2 = localObject3;
        if (!TextUtils.isEmpty(this.cnf))
        {
          localObject2 = localObject3;
          if (((String)localObject3).startsWith(this.cnf)) {
            localObject2 = ((String)localObject3).substring(this.cnf.length());
          }
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label2027;
        }
        localObject2 = ((String)localObject2).trim();
        i = ((String)localObject2).length();
        if ((!this.cOs) || (this.cu.isEmpty()))
        {
          if (i < this.cLN)
          {
            QQToast.a(this, getString(2131698470, new Object[] { Integer.valueOf(this.cLN) }), 0).show(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid)
            {
              aprv.report("pub_page", "fail", (String)localObject1, "2", AS(), "");
              return;
            }
          }
          if (i > this.cLO)
          {
            QQToast.a(this, getString(2131698471, new Object[] { Integer.valueOf(this.cLO) }), 0).show(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid)
            {
              aprv.report("pub_page", "fail", (String)localObject1, "4", AS(), "");
              return;
            }
          }
        }
      } while (!r(this.dRA, false));
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.flag == 1) && ((this.cu == null) || (this.cu.isEmpty())))
      {
        QQToast.a(this, 2131698483, 0).show(getTitleBarHeight());
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
        for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid)
        {
          aprv.report("pub_page", "fail", (String)localObject1, "9", AS(), "");
          return;
        }
      }
      if (!jqc.ak(this))
      {
        QQToast.a(this, 2131696206, 0).show(getTitleBarHeight());
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
        for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid)
        {
          aprv.report("pub_page", "fail", (String)localObject1, "7", AS(), "");
          return;
        }
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid))) && ((this.Hm == null) || (this.Hm.size() == 0)))
      {
        dWZ();
        aprl.e("pub_page_new", "auto_choose_tribe", 0, 0, new String[] { "" });
        return;
      }
      if (this.cOU)
      {
        QQToast.a(this, acfp.m(2131715599), 0).show();
        return;
      }
      xa(true);
      this.rightViewText.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(false);
      i = 0;
      while (i < this.cu.size())
      {
        localObject3 = (String)this.cu.get(i);
        if ((Pic_list)aprv.w.get(localObject3) == null)
        {
          a(1, this.mHandler);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
          for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid)
          {
            aprv.report("pub_page", "fail", (String)localObject1, "10", AS(), "");
            return;
          }
        }
        i += 1;
      }
      if ((this.jdField_a_of_type_Aora != null) && (TextUtils.isEmpty(this.jdField_a_of_type_Aora.thumbUrl)))
      {
        db(this.cnh, false);
        return;
      }
      if ((!TextUtils.isEmpty(this.mVideoPath)) && (this.jdField_a_of_type_Aora != null) && (TextUtils.isEmpty(this.jdField_a_of_type_Aora.url)))
      {
        dc(this.mVideoPath, false);
        return;
      }
      Object localObject3 = TroopBarPublishUtils.a((String)localObject2, this.cu, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo, this.jdField_a_of_type_Aora);
      Object localObject2 = new JSONObject();
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(this.mBid)) {
            break label1862;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null)
          {
            l = 0L;
            ((JSONObject)localObject2).put("bid", l);
            ((JSONObject)localObject2).put("post", localObject3);
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              break label2024;
            }
            localObject1 = "###...^_^###";
            if (this.jdField_a_of_type_Aorm$d != null)
            {
              if (a(this.jdField_a_of_type_Aorm$d, this.cni) == null) {
                break label2037;
              }
              localObject1 = this.jdField_a_of_type_Aorm$d.cmI + this.jdField_a_of_type_Aorm$d.cmJ + this.jdField_a_of_type_Aorm$d.cmK + a(this.jdField_a_of_type_Aorm$d, this.cni);
            }
            this.mTitle = ((String)localObject1);
            ((JSONObject)localObject2).put("title", localObject1);
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
            {
              ((JSONObject)localObject2).put("uid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.uid);
              ((JSONObject)localObject2).put("lat", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.latitude));
              ((JSONObject)localObject2).put("lon", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.longitude));
            }
            if (this.jdField_a_of_type_Aora == null) {
              break label2045;
            }
            i = 210;
            ((JSONObject)localObject2).put("type", i);
            ((JSONObject)localObject2).put("extparam", this.cnc);
            ((JSONObject)localObject2).put("version", "3.4.4.3058");
            if ((this.ZZ == null) || (this.ZZ.getVisibility() != 0)) {
              break label2050;
            }
            i = j;
            ((JSONObject)localObject2).put("pubsource", i);
            if (this.dRM != 1) {
              break label1895;
            }
            ((JSONObject)localObject2).put("pversion", 1);
            if ((this.Hm == null) || (this.Hm.size() <= 0)) {
              break label1895;
            }
            localObject1 = new ArrayList(this.Hm.size());
            localObject3 = this.Hm.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            ((List)localObject1).add(((TroopBarMyBar)((Iterator)localObject3).next()).bid);
            continue;
          }
          l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid);
        }
        catch (Exception localException1)
        {
          QQToast.a(this, 1, 2131698503, 0).show(getTitleBarHeight());
          localException1.printStackTrace();
          return;
        }
        continue;
        label1862:
        long l = Long.parseLong(this.mBid);
      }
      ((JSONObject)localObject2).put("bid_list", new JSONArray(localException1).toString());
      label1895:
      if (this.dRR == -1) {}
      for (i = 0;; i = this.dRR)
      {
        ((JSONObject)localObject2).put("theme_id", i);
        NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), jnl.class);
        localNewIntent.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.publish_post");
        localObject3 = new WebSsoBody.WebSsoRequestBody();
        ((WebSsoBody.WebSsoRequestBody)localObject3).type.set(0);
        ((WebSsoBody.WebSsoRequestBody)localObject3).data.set(((JSONObject)localObject2).toString());
        localNewIntent.putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject3).toByteArray());
        localNewIntent.setObserver(new aovh(this));
        this.app.startServlet(localNewIntent);
        return;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        continue;
        label2024:
        continue;
        label2027:
        int i = 0;
        continue;
        label2032:
        i = 0;
        continue;
        label2037:
        String str = "###...^_^###";
        continue;
        label2045:
        i = 0;
        continue;
        label2050:
        i = 1;
      }
    }
  }
  
  public void c(View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Aour.bT(paramInt))
    {
      i(this, TroopBarPublishActivity.class.getName());
      return;
    }
    aqfy.clearCache();
    paramView = new Intent();
    paramView.putExtra("ALBUM_ID", "$RecentAlbumId");
    paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.mActivity.getClass().getName());
    paramView.putExtra("back_btn_text", this.mActivity.getString(2131699469));
    paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.cu);
    paramView.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    paramView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", this.cu.size());
    paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
    paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    paramView.putExtra("PhotoConst.IS_OVERLOAD", false);
    paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    paramView.putExtra("from_tribe_class_name", this.mActivity.getClass().getSimpleName());
    paramView.putExtra("enter_from", 24);
    paramView.setClass(this.mActivity, NewPhotoPreviewActivity.class);
    paramView.addFlags(603979776);
    this.mActivity.startActivity(paramView);
    aqfy.anim(this, true, true);
    if ((this.ZZ != null) && (this.ZZ.getVisibility() == 0))
    {
      paramInt = 2;
      if (!TextUtils.isEmpty(this.mBid)) {
        break label291;
      }
    }
    label291:
    for (paramView = "0";; paramView = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid)
    {
      anot.a(null, "P_CliOper", "Grp_tribe", "", "pub_page", "choose_photo", paramInt, 0, paramView, "", "", "");
      return;
      paramInt = 1;
      break;
    }
  }
  
  protected void dM(Intent paramIntent)
  {
    this.cnh = paramIntent.getStringExtra("thumbPath");
    this.cng = paramIntent.getStringExtra("fakeVid");
    String str1 = paramIntent.getStringExtra("videoPath");
    String str2 = paramIntent.getStringExtra("videoDoodleDescription");
    if ((this.cnh == null) || (this.cng == null) || (str1 == null)) {
      return;
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams;
      try
      {
        Bitmap localBitmap = aqhu.d(this.cnh, null);
        int i = localBitmap.getWidth();
        int j = localBitmap.getHeight();
        localLayoutParams = (LinearLayout.LayoutParams)this.mg.getLayoutParams();
        if (i > j)
        {
          localLayoutParams.width = aqcx.dip2px(this, 216.0F);
          localLayoutParams.height = aqcx.dip2px(this, 130.0F);
          this.mg.setVisibility(0);
          this.mg.setLayoutParams(localLayoutParams);
          this.Ed.setImageBitmap(localBitmap);
          this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setPadding(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingLeft(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingTop(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingRight(), 0);
          this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setMinLines(1);
          this.bA.setPadding(this.bA.getPaddingLeft(), this.bA.getPaddingTop(), this.bA.getPaddingRight(), 0);
          this.bA.setMinLines(1);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(8);
          this.Ed.setOnClickListener(new aovc(this));
          this.jdField_a_of_type_Aora = new aora();
          this.jdField_a_of_type_Aora.text = str2;
          this.jdField_a_of_type_Aora.Wb(paramIntent.getIntExtra("captureMode", 0));
          hQ(str1, this.cng);
          return;
        }
      }
      catch (OutOfMemoryError paramIntent)
      {
        QLog.e("TroopBarPublishActivity", 2, QLog.getStackTraceString(paramIntent));
        return;
      }
      localLayoutParams.width = aqcx.dip2px(this, 130.0F);
      localLayoutParams.height = aqcx.dip2px(this, 216.0F);
    }
  }
  
  protected void dWJ()
  {
    if (this.jdField_a_of_type_Aora == null) {
      super.dWJ();
    }
    this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setHint("");
    dXe();
    dXh();
  }
  
  public void dWZ()
  {
    cne = AR();
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    StringBuilder localStringBuilder1 = new StringBuilder("https://buluo.qq.com/mobile/publish_tribe.html?_wv=1027");
    localStringBuilder1.append("&timestamp=" + this.aiL);
    StringBuilder localStringBuilder2 = new StringBuilder().append("&optionType=");
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.getCurType())
    {
      localStringBuilder1.append(i);
      localStringBuilder1.append("&supportMultiSelect=" + this.dRM);
      localIntent.putExtra("url", localStringBuilder1.toString());
      startActivityForResult(localIntent, 1004);
      return;
    }
  }
  
  protected void dXa()
  {
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null)
    {
      str1 = "0";
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {
        break label49;
      }
    }
    label49:
    for (String str2 = "0";; str2 = "1")
    {
      aprv.report("pub_page", "choose_tribe", str1, str2, "", "");
      return;
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid;
      break;
    }
  }
  
  protected void dXb()
  {
    if ((this.cOm) && (this.bN != null))
    {
      Object localObject3 = this.bN.optString("share_title");
      Object localObject2 = this.bN.optString("share_content");
      String str = this.bN.optString("share_img_list");
      if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText != null)
      {
        TEditText localTEditText = this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localTEditText.setText((CharSequence)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setHint(this.cmM);
        this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.dRx) });
      }
      dXh();
      if (this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText != null)
      {
        localObject3 = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText;
        if (localObject2 != null) {
          break label206;
        }
      }
      label206:
      for (Object localObject1 = "";; localObject1 = localObject2)
      {
        ((TEditText)localObject3).setText((CharSequence)localObject1);
        dXe();
        if (TextUtils.isEmpty(str)) {
          return;
        }
        localObject1 = str.split(";");
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          return;
        }
        localObject2 = new ArrayList();
        int i = 0;
        while (i < localObject1.length)
        {
          ((ArrayList)localObject2).add(localObject1[i]);
          i += 1;
        }
      }
      a(this.mHandler, (ArrayList)localObject2);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.mStop = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, null, this.cu, "https://upload.buluo.qq.com/cgi-bin/bar/upload/image");
      ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
    }
  }
  
  public void dXc()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText != null)
    {
      if (this.aae != null)
      {
        localObject = this.aae.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().heightPixels;
        this.aae.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.aae.requestLayout();
      }
      if ((this.dRS != 700) && ((this.Hn == null) || (this.Hn.size() <= 0))) {
        break label98;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText != null) {
        this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.requestFocus();
      }
    }
    return;
    label98:
    int i = aqcx.dip2px(this, 40.0F);
    if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getMeasuredHeight() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.measure(200, -2147483648);
      int j = this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getMeasuredHeight();
      if (j != 0) {
        i = j;
      }
    }
    for (;;)
    {
      if (!this.cOT)
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText().toString())) {
          break;
        }
        try
        {
          localObject = View.class.getDeclaredField("mScrollY");
          ((Field)localObject).setAccessible(true);
          ((Field)localObject).set(this.jdField_a_of_type_ComTencentWidgetScrollView, Integer.valueOf(i));
          this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.requestFocus();
          return;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          localNoSuchFieldException.printStackTrace();
          return;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
          return;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getVisibility() != 0) {
        break;
      }
      j(i, 800, 600, true);
      return;
    }
  }
  
  public void dXd()
  {
    m(this, "is_first_enter", "true");
  }
  
  public void dXi()
  {
    aqha.a(this, 230, null, acfp.m(2131715591), acfp.m(2131715586), acfp.m(2131715575), new aova(this), new aovb(this)).show();
  }
  
  public void dXk()
  {
    TribeVideoPublishParams localTribeVideoPublishParams = (TribeVideoPublishParams)getIntent().getSerializableExtra(TribeVideoPublishParams.BUNDLE_EXTRA_KEY);
    if ("barindex".equals(this.mFrom)) {}
    for (int i = 1;; i = 2)
    {
      if (localTribeVideoPublishParams.combo0Info != null) {
        anot.a(this.app, "dc00899", "Grp_tribe", "", "video_shoot", "pub_packages", i, 0, localTribeVideoPublishParams.combo0Info.id, localTribeVideoPublishParams.combo0Info.type, "", "");
      }
      if ((localTribeVideoPublishParams.changeFace != null) && (!TextUtils.isEmpty(localTribeVideoPublishParams.changeFace.id))) {
        anot.a(this.app, "dc00899", "Grp_tribe", "", "video_shoot", "pub_changeface", i, 0, localTribeVideoPublishParams.changeFace.id, localTribeVideoPublishParams.changeFace.type, "", "");
      }
      if (localTribeVideoPublishParams.filter != null) {
        anot.a(this.app, "dc00899", "Grp_tribe", "", "video_shoot", "pub_filter", i, 0, localTribeVideoPublishParams.filter.id, localTribeVideoPublishParams.filter.typeId, "", "");
      }
      if (localTribeVideoPublishParams.beauty > 0) {
        anot.a(this.app, "dc00899", "Grp_tribe", "", "video_shoot", "pub_beauty", i, 0, "" + localTribeVideoPublishParams.beauty, "", "", "");
      }
      if (localTribeVideoPublishParams.hasGraffiti) {
        anot.a(this.app, "dc00899", "Grp_tribe", "", "video_edit", "pub_graffiti", i, 0, "", "", "", "");
      }
      if (localTribeVideoPublishParams.hasText) {
        anot.a(this.app, "dc00899", "Grp_tribe", "", "video_edit", "pub_text", i, 0, "", "", "", "");
      }
      if (localTribeVideoPublishParams.hasFace) {
        anot.a(this.app, "dc00899", "Grp_tribe", "", "video_edit", "pub_face", i, 0, "", "", "", "");
      }
      if (localTribeVideoPublishParams.music == null) {
        break;
      }
      anot.a(this.app, "dc00899", "Grp_tribe", "", "video_edit", "pub_music", i, 0, localTribeVideoPublishParams.music.name, localTribeVideoPublishParams.music.type, "", "");
      return;
    }
    if (localTribeVideoPublishParams.isSoundOn)
    {
      anot.a(this.app, "dc00899", "Grp_tribe", "", "video_edit", "sound_on", i, 0, "", "", "", "");
      return;
    }
    anot.a(this.app, "dc00899", "Grp_tribe", "", "video_edit", "sound_off", i, 0, "", "", "", "");
  }
  
  protected void db(String paramString, boolean paramBoolean)
  {
    QLog.d("tribe_publish_TroopBarPublishActivity", 2, "start uploadVideoThumb " + paramBoolean);
    if (!paramBoolean) {
      xa(true);
    }
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramString);
    if (this.jdField_b_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, this.dx, localArrayList, this.cmO);
      ThreadManager.post(this.jdField_b_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
    }
  }
  
  public void dc(String paramString, boolean paramBoolean)
  {
    Object localObject = new StringBuilder().append("start uploadVideo. mTribeVideoUploadTask is running?");
    if (this.jdField_b_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("tribe_publish_TroopBarPublishActivity", 1, bool);
      if (!paramBoolean) {
        xa(true);
      }
      localObject = new aork();
      ((aork)localObject).mLocalVideoPath = paramString;
      if (this.jdField_b_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask = new TribeVideoUploadTask(this, this.dx, (aork)localObject);
        ThreadManager.post(this.jdField_b_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask, 8, null, true);
      }
      return;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {}
    label120:
    label761:
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        return;
      case 1002: 
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramIntent.getParcelableExtra("key_selected_poi"));
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name))
          {
            paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.Tr;
            d(1, new String[] { paramIntent });
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
              break label171;
            }
          }
        }
        for (paramIntent = "0";; paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid)
        {
          aprv.report("pub_page", "choose_place", paramIntent, "2", "", "");
          return;
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name;
          break;
          d(0, new String[0]);
          break label120;
        }
      case 1004: 
        Object localObject1 = paramIntent.getStringExtra("tribeList");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          this.Hm = null;
        }
        while ((this.ZZ != null) && (this.kJ != null))
        {
          if ((this.Hm == null) || (this.Hm.size() <= 0)) {
            break label723;
          }
          this.kJ.removeAllViews();
          paramInt2 = aqcx.dip2px(this, 20.0F);
          int i = aqcx.dip2px(this, 10.0F);
          int j = aqcx.dip2px(this, 6.0F);
          paramInt1 = 0;
          for (;;)
          {
            for (;;)
            {
              if (paramInt1 >= this.Hm.size()) {
                break label646;
              }
              localObject1 = (TroopBarMyBar)this.Hm.get(paramInt1);
              if (paramInt1 == 0)
              {
                this.mBid = ((TroopBarMyBar)localObject1).bid;
                this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = ((TroopBarMyBar)localObject1);
              }
              Object localObject2 = new TextView(this);
              Object localObject3 = new LinearLayout.LayoutParams(-2, paramInt2);
              ((LinearLayout.LayoutParams)localObject3).rightMargin = i;
              ((TextView)localObject2).setPadding(j, 0, j, 0);
              ((LinearLayout.LayoutParams)localObject3).gravity = 16;
              ((TextView)localObject2).setTextColor(Color.parseColor("#FFB800"));
              ((TextView)localObject2).setBackgroundResource(2130844392);
              ((TextView)localObject2).setText(((TroopBarMyBar)localObject1).name);
              ((TextView)localObject2).setTextSize(1, 14.0F);
              ((TextView)localObject2).setContentDescription(((TroopBarMyBar)localObject1).name);
              ((TextView)localObject2).setOnClickListener(this);
              ((TextView)localObject2).setTag(2131374436, localObject1);
              this.kJ.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
              paramInt1 += 1;
              continue;
              this.Hm = new ArrayList(((String)localObject1).length());
              try
              {
                localObject1 = new JSONArray((String)localObject1);
                paramInt1 = 0;
                while (paramInt1 < ((JSONArray)localObject1).length())
                {
                  localObject3 = ((JSONArray)localObject1).getJSONObject(paramInt1);
                  localObject2 = ((JSONObject)localObject3).optString("tribeName");
                  localObject3 = ((JSONObject)localObject3).optString("bid");
                  try
                  {
                    this.Hm.add(new TroopBarMyBar(Long.parseLong((String)localObject3), (String)localObject2));
                    this.cnd = (this.cnd + (String)localObject3 + "|");
                    paramInt1 += 1;
                  }
                  catch (NumberFormatException localNumberFormatException)
                  {
                    for (;;)
                    {
                      QLog.e("TroopBarPublishActivity", 1, "TroopBarPublishActivity.doOnActivityResult(). name=" + (String)localObject2 + " bid=" + (String)localObject3, localNumberFormatException);
                    }
                  }
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
              }
              catch (JSONException localJSONException) {}
            }
            QLog.e("TroopBarPublishActivity", 2, "TroopBarPublishActivity.doOnActivityResult(). ", localJSONException);
            break;
          }
          this.ZZ.setVisibility(8);
          this.kJ.setVisibility(0);
        }
        while (this.jdField_a_of_type_Aora == null)
        {
          if (this.cu.size() <= 0) {
            break label761;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.Gs(1);
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.isShown())) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.kd(5, 1);
          return;
          this.mBid = "";
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = null;
          this.ZZ.setVisibility(0);
          this.kJ.setVisibility(8);
          this.kJ.removeAllViews();
        }
        if (this.dRS == 700) {
          this.dRA &= 0x3;
        }
        We(paramIntent.getIntExtra("optionType", this.dRA));
        return;
      }
    } while (!QLog.isColorLevel());
    label171:
    label723:
    QLog.d("TroopBarPublishActivity", 2, "doOnActivityResult, REQUEST_CODE_SELECT_MYBAR");
    label646:
    return;
    dM(paramIntent);
    return;
    dL(paramIntent);
    Rl(true);
  }
  
  public void doOnDestroy()
  {
    dXj();
    if ((!this.cOU) && (!TextUtils.isEmpty(this.cng))) {
      pog.b(pog.a(this.cng));
    }
    if (this.jdField_b_of_type_Aoqv != null) {
      this.jdField_b_of_type_Aoqv.onDestroy();
    }
    TroopBarPublishUtils.cOY = false;
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.HP != null) && (!this.cOv) && (this.cOl)) {
      this.mHandler.postDelayed(new TroopBarPublishActivity.2(this), 200L);
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((!this.cOn) && (this.cOm) && (this.bN != null)) {
      aqmz.h(this, this.bN.optLong("share_app_id"));
    }
    String str1;
    if (!this.cOn)
    {
      if (((this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText == null) || (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.length() <= 0)) && ((this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText == null) || (this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.length() <= 0)) && ((this.cu == null) || (this.cu.size() <= 0))) {
        break label128;
      }
      str1 = "0";
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label134;
      }
    }
    label128:
    label134:
    for (String str2 = "0";; str2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid)
    {
      aprv.report("pub_page", "un", str2, str1, "", "");
      return;
      str1 = "1";
      break;
    }
  }
  
  protected void hQ(String paramString1, String paramString2)
  {
    long l = SystemClock.uptimeMillis();
    this.cOU = true;
    ThreadManager.post(new TroopBarPublishActivity.14(this, paramString2, paramString1, l), 8, null, true);
  }
  
  protected void initUI()
  {
    super.initUI();
    this.aae = ((TextView)findViewById(2131374293));
    this.cOT = aAC();
    if (this.ZZ != null) {
      this.ZZ.setTag(2131374436, this.ZZ);
    }
    dXc();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVideoCallback(this.dw);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setMusicCallback(this.dw);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setAudioCallback(this.dw);
    label269:
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null)
    {
      if ((!this.cOm) && (!this.cOS)) {
        this.ZZ.setVisibility(8);
      }
      if ((this.cOS) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null))
      {
        this.ZZ.setVisibility(0);
        this.ZZ.setText(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.name);
        this.ZZ.setTextColor(Color.parseColor("#638EC3"));
        this.ZZ.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.name);
      }
      if ((!"barindex".equals(this.mFrom)) && (this.mGroupType == 1))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("bid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid);
        this.cOQ = true;
        aprv.b(this, (Bundle)localObject, "https://buluo.qq.com/cgi-bin/bar/bar_publish_info", 8, null, this);
      }
      if (this.cOm) {
        am(2131720190);
      }
      dXb();
      if (this.mSystemBarComp != null) {
        break label491;
      }
      setImmersiveStatus(-16777216);
      this.mg = ((RelativeLayout)findViewById(2131374491));
      this.Ed = ((ImageView)findViewById(2131374490));
      this.aaf = ((TextView)findViewById(2131374489));
      dM(getIntent());
      if (this.jdField_a_of_type_Aora != null)
      {
        dL(getIntent());
        this.uP = null;
      }
      dXf();
      dXg();
      StringBuffer localStringBuffer = new StringBuffer();
      if ((this.dRA & 0x1) == 1) {
        localStringBuffer.append("0");
      }
      if ((this.dRA & 0x2) == 2) {
        localStringBuffer.append("1");
      }
      if ((this.ZZ == null) || (this.ZZ.getVisibility() != 0)) {
        break label522;
      }
      i = 2;
      label409:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label527;
      }
      localObject = "0";
      label420:
      anot.a(null, "P_CliOper", "Grp_tribe", "", "pub_page", "exp", i, 0, (String)localObject, this.cmL, localStringBuffer.toString(), "");
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label538;
      }
    }
    label522:
    label527:
    label538:
    for (Object localObject = "0";; localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid)
    {
      aprv.report("pub_page", "choose_place", (String)localObject, "0", "", "");
      return;
      this.ZZ.setVisibility(0);
      break;
      label491:
      this.mSystemBarComp.setStatusBarDrawable(null);
      this.mSystemBarComp.setStatusBarColor(-16777216);
      this.mSystemBarComp.setStatusColor(-16777216);
      break label269;
      i = 1;
      break label409;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid;
      break label420;
    }
  }
  
  public void j(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.mHandler.postDelayed(new TroopBarPublishActivity.6(this, paramInt1, paramInt3, paramBoolean), paramInt2);
  }
  
  public void jM(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if ((paramInt1 >= 0) && (paramInt1 < this.cu.size()))
    {
      if (this.cu.size() == 1)
      {
        Wd(0);
        this.cu.remove(paramInt1);
        localObject = this.jdField_a_of_type_Aour;
        if (this.cu.size() < paramInt2) {
          bool = true;
        }
        ((aour)localObject).C(bool, true);
        this.jdField_a_of_type_Aour.bF(this.cu);
      }
    }
    else {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label134;
      }
    }
    label134:
    for (Object localObject = "0";; localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid)
    {
      aprv.report("pub_page", "del_photo", (String)localObject, "", "", "");
      return;
      if (this.cOR) {
        break;
      }
      this.dRP = paramInt1;
      this.dRQ = paramInt2;
      Wm(paramInt1);
      break;
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Aora != null)
    {
      aqha.a(this, 230, acfp.m(2131715594), acfp.m(2131715607), acfp.m(2131715590), acfp.m(2131715578), new aove(this), new aovf(this)).show();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getTag(2131374436) != null) {
      dWZ();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131370259: 
        dXa();
      }
    }
    int i;
    label85:
    String str1;
    if ((this.ZZ != null) && (this.ZZ.getVisibility() == 0))
    {
      i = 2;
      if (!TextUtils.isEmpty(this.mBid)) {
        break label146;
      }
      str1 = "0";
      label99:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
        break label157;
      }
    }
    label146:
    label157:
    for (String str2 = "0";; str2 = "1")
    {
      anot.a(null, "P_CliOper", "Grp_tribe", "", "pub_page", "Clk_place", i, 0, str1, str2, "", "");
      break;
      i = 1;
      break label85;
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.bid;
      break label99;
    }
  }
  
  public static class Pic_list
    extends TroopBarAbsDataEntity
  {
    protected static final String JSON_KEY_H = "h";
    protected static final String JSON_KEY_TYPE = "type";
    protected static final String JSON_KEY_TYPE_INFO = "type_info";
    protected static final String JSON_KEY_URL = "url";
    protected static final String JSON_KEY_W = "w";
    protected static final long serialVersionUID = 10008L;
    public boolean canReuse = true;
    public int h;
    public String type;
    public String url;
    public int w;
    
    public Pic_list() {}
    
    public Pic_list(JSONObject paramJSONObject)
    {
      super();
      this.url = paramJSONObject.optString("url", "");
      this.w = paramJSONObject.optInt("w", -1);
      this.h = paramJSONObject.optInt("h", -1);
      paramJSONObject = paramJSONObject.optJSONObject("type_info");
      if (paramJSONObject != null) {
        this.type = paramJSONObject.optString("type", "");
      }
    }
    
    public JSONObject getJsonObject()
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("url", this.url);
        localJSONObject1.put("w", this.w);
        localJSONObject1.put("h", this.h);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("type", this.type);
        localJSONObject1.put("type_info", localJSONObject2);
        return localJSONObject1;
      }
      catch (JSONException localJSONException) {}
      return null;
    }
    
    public void readExternal(ObjectInput paramObjectInput)
      throws IOException, ClassNotFoundException
    {
      this.url = paramObjectInput.readUTF();
      this.w = paramObjectInput.readInt();
      this.h = paramObjectInput.readInt();
      this.type = paramObjectInput.readUTF();
    }
    
    public void writeExternal(ObjectOutput paramObjectOutput)
      throws IOException
    {
      paramObjectOutput.writeUTF(this.url);
      paramObjectOutput.writeInt(this.w);
      paramObjectOutput.writeInt(this.h);
      paramObjectOutput.writeUTF(this.type);
    }
  }
  
  class a
    implements aorm.b
  {
    private a() {}
    
    public void a(aorm.d paramd)
    {
      TroopBarPublishActivity.this.a = paramd;
      TroopBarPublishActivity.this.b.hide();
      TroopBarPublishActivity.this.Rm(true);
      anot.a(null, "dc00899", "Grp_tribe", "", "pub_page", "choose_prefix", 0, 0, TroopBarPublishActivity.this.mBid, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity
 * JD-Core Version:    0.7.0.1
 */