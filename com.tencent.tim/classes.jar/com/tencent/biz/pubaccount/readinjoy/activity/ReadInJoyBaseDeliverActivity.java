package com.tencent.biz.pubaccount.readinjoy.activity;

import afmf;
import afmi;
import afqh;
import afqr;
import afqv;
import aiaa;
import anbk;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import aofy;
import aprb.a;
import aqiw;
import arhz;
import ausj;
import auss;
import awit;
import com.tencent.biz.pubaccount.readinjoy.biu.AtFriendsSpan;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem.ReadInJoyDraftboxContent;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.VisibleSetParam;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyTopicSelectionFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord;
import com.tencent.biz.pubaccount.readinjoy.view.text.TopicSpan;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import kbp;
import khe;
import khf;
import khg;
import khh;
import khi;
import khj;
import khk;
import khl;
import khm;
import khn;
import kho;
import khp;
import kpo;
import kqx;
import kwt;
import kxm;
import lbz;
import liq;
import mkt;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyBaseDeliverActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, aprb.a
{
  protected static int aIQ = 8;
  public boolean BE;
  public EditText N;
  protected String Zm;
  protected String Zn;
  protected String Zo;
  protected String Zp = "";
  private aiaa jdField_a_of_type_Aiaa = new khp(this);
  private Editable.Factory jdField_a_of_type_AndroidTextEditable$Factory = new khk(this);
  public ReadInJoyDraftboxItem.ReadInJoyDraftboxContent a;
  public VisibleSetParam a;
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private PublicAccountHotPicPanel jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel;
  public TroopBarPOI a;
  private XPanelContainer.c jdField_a_of_type_ComTencentWidgetXPanelContainer$c = new khl(this);
  public liq a;
  public int aIK = 1;
  public int aIL = 1;
  protected int aIM = kwt.aMj;
  public int aIN;
  public int aIO;
  protected int aIP;
  private int aIR;
  public int aIS = -1;
  public boolean acX;
  public boolean aeY;
  protected boolean aeZ;
  protected boolean afa;
  private boolean afb = true;
  public boolean afc;
  protected boolean afd = true;
  protected boolean afe = true;
  protected boolean aff;
  protected boolean afg = true;
  protected boolean afh = true;
  protected boolean afi;
  public boolean afj;
  protected boolean afk;
  public boolean afl;
  protected ViewTreeObserver.OnGlobalLayoutListener b;
  public ReadInJoyDraftboxItem.ReadInJoyDraftboxContent b;
  protected INetInfoHandler b;
  public XPanelContainer c;
  private afmf d = new khm(this);
  private ImageView hX;
  protected ImageView hY;
  protected ImageView hZ;
  protected ImageView ia;
  protected arhz j;
  protected ArrayList<TroopBarPOI> kd;
  private String mCallback;
  protected int mFrom;
  protected boolean mIsVisible = true;
  public int mResult = 0;
  protected TextView nS;
  private TextView nT;
  protected Dialog o;
  public long sc = -1L;
  protected TextWatcher textWatcher = new khe(this);
  public ausj x;
  
  public ReadInJoyBaseDeliverActivity()
  {
    this.jdField_a_of_type_Liq = lbz.a().a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVisibleSetParam = VisibleSetParam.b;
  }
  
  public static int U(String paramString)
  {
    try
    {
      int i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      switch (i)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      case 6: 
        return 90;
      case 3: 
        return 180;
      }
      return 270;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, afmi paramafmi, EditText paramEditText)
  {
    int i;
    int k;
    if ((paramafmi instanceof afqv))
    {
      i = paramEditText.getSelectionStart();
      k = paramEditText.getSelectionEnd();
      if ((i < 0) || (k < 0) || (k < i)) {}
    }
    do
    {
      afqr localafqr;
      int m;
      int n;
      do
      {
        try
        {
          paramEditText.getEditableText().replace(i, k, aofy.fx(((afqv)paramafmi).code));
          return;
        }
        catch (IllegalArgumentException paramQQAppInterface)
        {
          QLog.e("ReadInJoyBaseDeliverActivity", 2, "sendEmoticon: ", paramQQAppInterface);
          return;
        }
        if (!(paramafmi instanceof afqr)) {
          break;
        }
        localafqr = (afqr)paramafmi;
        i = paramEditText.getSelectionStart();
        k = paramEditText.getSelectionEnd();
        m = localafqr.ahx;
        n = localafqr.code;
      } while ((i < 0) || (k < 0) || (k < i) || (n == -1));
      if (m == 1) {}
      for (;;)
      {
        try
        {
          paramafmi = aofy.fx(n);
          paramEditText.getEditableText().replace(i, k, paramafmi);
          paramEditText.requestFocus();
        }
        catch (IllegalArgumentException paramafmi)
        {
          QLog.e("ReadInJoyBaseDeliverActivity", 2, "sendEmoticon: ", paramafmi);
          continue;
        }
        localafqr.o(paramQQAppInterface, null);
        return;
        paramafmi = aofy.fw(n);
      }
    } while (!(paramafmi instanceof afqh));
    paramQQAppInterface = (afqh)paramafmi;
    if (paramQQAppInterface.e == null)
    {
      QLog.e("ReadInJoyBaseDeliverActivity", 1, "kandian fail to send small_emotion.");
      return;
    }
    new QueryTask(new khn(), new kho(paramEditText)).bq(paramQQAppInterface);
  }
  
  private void aDa()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new ReadInJoyBaseDeliverActivity.16(this));
    }
    while ((this.o == null) || (!this.o.isShowing())) {
      return;
    }
    this.o.dismiss();
  }
  
  public static String ig()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", kxm.aMw);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  private void lV(boolean paramBoolean)
  {
    if (this.nT != null) {
      this.nT.setSelected(paramBoolean);
    }
  }
  
  public static Bitmap rotaingImageView(int paramInt, Bitmap paramBitmap)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(paramInt);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  public void a(int paramInt, CharSequence paramCharSequence)
  {
    ThreadManager.getUIHandler().post(new ReadInJoyBaseDeliverActivity.17(this, paramInt, paramCharSequence));
  }
  
  protected void a(TopicInfo paramTopicInfo)
  {
    if ((this.N != null) && (paramTopicInfo != null))
    {
      int k = this.N.getSelectionStart();
      Editable localEditable = this.N.getEditableText();
      if (localEditable != null)
      {
        int i = k;
        if (!TextUtils.isEmpty(localEditable.toString()))
        {
          i = k;
          if (k > 0)
          {
            i = k;
            if (localEditable.toString().substring(k - 1, k).equals("#"))
            {
              localEditable.delete(k - 1, k);
              i = k - 1;
              this.N.setSelection(i);
            }
          }
        }
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramTopicInfo.jS() + " ");
        localSpannableStringBuilder.setSpan(new TopicSpan(paramTopicInfo), 0, localSpannableStringBuilder.length(), 33);
        localEditable.insert(i, localSpannableStringBuilder);
        k = localSpannableStringBuilder.length();
        this.N.setSelection(i + k);
      }
    }
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
          break label318;
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
          QLog.d("ReadInJoyBaseDeliverActivity", 2, "get poi list error: " + paramJSONObject.toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name))
          {
            paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.Tr;
            d(1, new String[] { paramJSONObject });
            return;
            if (this.kd.size() > 0) {
              this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)this.kd.get(0));
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
            {
              paramJSONObject = String.format("current poi = (name:%s lati:%d long:%d)", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.latitude), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.longitude) });
              QLog.d("ReadInJoyBaseDeliverActivity", 2, paramJSONObject);
              continue;
            }
            paramJSONObject = "current poi null";
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
      label318:
      paramInt = 0;
    }
  }
  
  protected void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, long paramLong)
  {
    if (this.x == null)
    {
      this.x = ((ausj)auss.a(this, null));
      this.x.addCancelButton(2131721058);
      this.x.a(new khf(this));
      this.x.a(new khg(this, paramBoolean2, paramLong, paramBoolean1, paramInt));
    }
    if (!this.x.isShowing())
    {
      this.acX = false;
      this.x.show();
    }
  }
  
  public void aAt()
  {
    if ((this.j != null) && (this.j.isShowing())) {
      this.j.dismiss();
    }
  }
  
  protected void aCS()
  {
    kbp.a(null, "", "0X80096D8", "0X80096D8", 0, 0, "", "", "", "", false);
    Intent localIntent = new Intent(this, TroopBarPublishLocationSelectActivity.class);
    localIntent.putParcelableArrayListExtra("current_location_list", this.kd);
    localIntent.putExtra("key_selected_poi", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
    startActivityForResult(localIntent, 1002);
    overridePendingTransition(2130772004, 2130772005);
  }
  
  public void aCT() {}
  
  protected void aCU()
  {
    if (this.afe) {
      md("1");
    }
  }
  
  protected void aCV()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("searchTopicFrom", this.mFrom);
    PublicFragmentActivity.startForResult(this, localIntent, ReadInJoyTopicSelectionFragment.class, 3001);
  }
  
  protected void aCW()
  {
    if (this.aIK == 2)
    {
      oM(1);
      return;
    }
    oM(2);
  }
  
  protected void aCX() {}
  
  protected void aCY() {}
  
  protected void aCZ()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(new ReadInJoyBaseDeliverActivity.13(this));
      return;
    }
    new khh(this);
    new khi(this);
    this.o.show();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i;
    if ((paramEditable instanceof kpo))
    {
      i = ((kpo)paramEditable).nz();
      if (this.nS != null)
      {
        if ((this.afk) && (i - this.aIM <= 0)) {
          break label170;
        }
        this.nS.setText(String.valueOf(this.aIM - i));
        this.nS.setVisibility(0);
      }
      label62:
      if (i - this.aIM <= 0) {
        break label189;
      }
      if (this.nS != null) {
        this.nS.setTextColor(Color.parseColor("#FF4222"));
      }
      this.afa = true;
      label96:
      if (!this.aeZ) {
        break label217;
      }
      this.aeZ = false;
    }
    for (;;)
    {
      if ((this.afg) && (mkt.a(this.N.getText())))
      {
        if (!(this instanceof ReadInJoyDeliverBiuActivity)) {
          break label225;
        }
        kbp.a(null, "", "0X8009579", "0X8009579", 0, 0, "", "", "", ig(), false);
      }
      return;
      i = paramEditable.length();
      break;
      label170:
      if (!this.afk) {
        break label62;
      }
      this.nS.setVisibility(8);
      break label62;
      label189:
      if (this.nS != null) {
        this.nS.setTextColor(Color.parseColor("#BBBBBB"));
      }
      this.afa = false;
      break label96;
      label217:
      this.aeY = true;
    }
    label225:
    kbp.a(null, "", "0X800953B", "0X800953B", 0, 0, "", "", "", ig(), false);
  }
  
  protected Integer b()
  {
    Object localObject = this.N.getEditableText();
    localObject = (TopicSpan[])((Editable)localObject).getSpans(0, ((Editable)localObject).length(), TopicSpan.class);
    if (localObject != null) {
      return Integer.valueOf(localObject.length);
    }
    return Integer.valueOf(0);
  }
  
  protected void d(int paramInt, String... paramVarArgs)
  {
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramVarArgs = "";
      paramInt = i;
      if (this.nT != null) {
        this.nT.setText(paramVarArgs);
      }
      if (AppSetting.enableTalkBack) {
        if (paramInt == 0) {
          break label208;
        }
      }
      break;
    }
    for (;;)
    {
      if (this.nT != null) {
        this.nT.setContentDescription(paramVarArgs);
      }
      return;
      paramVarArgs = "";
      lV(false);
      paramInt = i;
      break;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
        QQToast.a(this, paramVarArgs[0], 1).show(getTitleBarHeight());
      }
      lV(false);
      paramVarArgs = "";
      paramInt = i;
      break;
      lV(false);
      paramVarArgs = "";
      paramInt = i;
      break;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!TextUtils.isEmpty(paramVarArgs[0])))
      {
        if (TextUtils.isEmpty(paramVarArgs[0]))
        {
          d(3, new String[0]);
          return;
        }
        paramVarArgs = paramVarArgs[0];
        lV(true);
        paramInt = 1;
        break;
      }
      d(0, new String[0]);
      lV(false);
      return;
      label208:
      paramVarArgs = getString(2131698482);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
        r(paramInt2, paramIntent);
        return;
      } while ((paramIntent == null) || (paramInt2 != -1));
      a((TopicInfo)paramIntent.getParcelableExtra("EXTRA_SELECTED_TOPIC"));
      return;
    } while ((paramIntent == null) || (paramInt2 != -1));
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramIntent.getParcelableExtra("key_selected_poi"));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onActivityResult: ").append(paramInt2);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
      {
        paramIntent = String.format("current poi = (name:%s lati:%d long:%d)", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.latitude), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.longitude) });
        QLog.d("ReadInJoyBaseDeliverActivity", 2, paramIntent);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
        break label253;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name)) {
        break label242;
      }
    }
    label242:
    for (paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.Tr;; paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name)
    {
      d(1, new String[] { paramIntent });
      return;
      paramIntent = "current poi null";
      break;
    }
    label253:
    d(0, new String[0]);
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onDestory();
    }
    if (this.N != null) {
      this.N.removeTextChangedListener(this.textWatcher);
    }
    if (this.c != null)
    {
      this.c.exR();
      this.c.setOnPanelChangeListener(null);
      this.c.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
    if (this.j != null)
    {
      this.j.dismiss();
      this.j = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_b_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_b_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.setPublicAccountGifListener(null);
      this.jdField_a_of_type_Aiaa = null;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.aIL = this.aIK;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (!this.mIsVisible) {
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyBaseDeliverActivity.1(this), 300L);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    int i = 0;
    for (;;)
    {
      if (i < localViewGroup.getChildCount())
      {
        View localView = localViewGroup.getChildAt(i);
        if ((localView instanceof TopGestureLayout)) {
          ((TopGestureLayout)localView).setInterceptTouchFlag(false);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void finish()
  {
    if (this.c != null) {
      this.c.aJS();
    }
    if (this.afd) {
      setResult(this.mResult, getIntent());
    }
    super.finish();
    overridePendingTransition(2130771989, 2130771990);
  }
  
  public String ih()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", kxm.aMw);
      ((JSONObject)localObject).put("topicid", il());
      ((JSONObject)localObject).put("topic_num", b());
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public String ii()
  {
    Object localObject = this.N.getEditableText();
    if ((localObject == null) || (((Editable)localObject).length() <= 0)) {
      localObject = "";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "getCommentString result=" + (String)localObject);
      }
      return localObject;
      String str2 = UUID.randomUUID().toString();
      String str1 = mkt.V(localObject.toString(), str2).trim();
      if (str1.length() <= 0)
      {
        localObject = "";
      }
      else
      {
        localObject = str1;
        if (!this.afl) {
          localObject = str1.replaceAll("\n|\r\n", "");
        }
        localObject = anbk.nm(mkt.W((String)localObject, str2));
      }
    }
  }
  
  protected String il()
  {
    Object localObject = this.N.getEditableText();
    localObject = (TopicSpan[])((Editable)localObject).getSpans(0, ((Editable)localObject).length(), TopicSpan.class);
    if ((localObject != null) && (localObject.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder().append(localObject[0].b().cO());
      int k = localObject.length;
      int i = 1;
      while (i < k)
      {
        localStringBuilder.append("|").append(localObject[i].b().cO());
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return "0";
  }
  
  protected void initData()
  {
    Intent localIntent = getIntent();
    this.aIP = localIntent.getIntExtra("arg_ad_tag", 0);
    this.Zm = localIntent.getStringExtra("arg_topic_id");
    this.Zn = localIntent.getStringExtra("arg_topic_name");
    this.mCallback = localIntent.getStringExtra("arg_callback");
    this.Zo = getIntent().getStringExtra("arg_ugc_edit_cookie");
    if (this.aff) {}
    for (;;)
    {
      try
      {
        a(TopicInfo.a().a(Long.valueOf(this.Zm).longValue()).a("#" + this.Zn).a());
        if (this.afk) {
          break label339;
        }
        int i = awit.o(this.app);
        if (i > 0) {
          this.aIM = i;
        }
        this.nS.setText(String.valueOf(this.aIM));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseDeliverActivity", 2, "initData count=" + i + ", mMaxWordCount=" + this.aIM);
        }
        if (this.afi)
        {
          this.jdField_b_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new a(null);
          AppNetConnInfo.registerConnectionChangeReceiver(this, this.jdField_b_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
        }
        i = ((Integer)awit.f("sp_key_deliver_ugc_paste_link_hint_count", Integer.valueOf(0))).intValue();
        if ((i < 2) && (this.afg) && (!(this instanceof ReadInJoyDeliverBiuActivity)) && (TextUtils.isEmpty(this.N.getEditableText()))) {
          awit.H("sp_key_deliver_ugc_paste_link_hint_count", Integer.valueOf(i + 1));
        }
        if (this.nT != null) {
          this.nT.setOnClickListener(this);
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "initData: fail to add topic from intent");
        continue;
      }
      if (this.ia != null)
      {
        this.ia.setVisibility(4);
        continue;
        label339:
        this.aIM = kwt.aMm;
        this.nS.setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseDeliverActivity", 2, "initData unlimited mode");
        }
      }
    }
  }
  
  protected void initViews()
  {
    this.N = ((EditText)findViewById(2131369276));
    if (this.mIsVisible) {
      this.N.requestFocus();
    }
    this.N.addTextChangedListener(this.textWatcher);
    try
    {
      this.N.setEditableFactory(this.jdField_a_of_type_AndroidTextEditable$Factory);
      this.N.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
      this.hX = ((ImageView)findViewById(2131366307));
      this.hX.setOnClickListener(this);
      this.hZ = ((ImageView)findViewById(2131363023));
      if (this.hZ != null) {
        this.hZ.setOnClickListener(this);
      }
      this.ia = ((ImageView)findViewById(2131380071));
      if (this.ia != null) {
        this.ia.setOnClickListener(this);
      }
      this.nS = ((TextView)findViewById(2131364450));
      this.j = new arhz(this, super.getTitleBarHeight());
      this.j.setCanceledOnTouchOutside(true);
      this.c = ((XPanelContainer)findViewById(2131377546));
      this.c.X(this.N, false);
      this.c.setOnPanelChangeListener(this.jdField_a_of_type_ComTencentWidgetXPanelContainer$c);
      if (this.afh)
      {
        this.aIN = XPanelContainer.eva;
        if (this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener == null) {
          this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new khj(this);
        }
        this.c.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      Object localObject;
      if (ThemeUtil.isInNightMode(this.app))
      {
        localObject = new View(this);
        ((View)localObject).setBackgroundColor(1996488704);
        addContentView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
      }
      this.nT = ((TextView)findViewById(2131364093));
      if (this.nT != null)
      {
        this.nT.setOnClickListener(this);
        localObject = this.nT;
        if (((Integer)awit.f(kqx.READINJOY_UGC_LBS, Integer.valueOf(1))).intValue() == 1)
        {
          i = 0;
          ((TextView)localObject).setVisibility(i);
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ReadInJoyBaseDeliverActivity", 1, "input set error", localException);
        continue;
        int i = 8;
      }
    }
  }
  
  public void lW(boolean paramBoolean)
  {
    if (this.afb != paramBoolean)
    {
      this.afb = paramBoolean;
      this.rightViewText.setEnabled(paramBoolean);
      if (paramBoolean) {
        this.rightViewText.setTextColor(Color.parseColor("#262626"));
      }
    }
    else
    {
      return;
    }
    this.rightViewText.setTextColor(Color.parseColor("#BBBBBB"));
  }
  
  protected void lX(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNet2None isFromWifi=" + paramBoolean);
    }
  }
  
  protected void lY(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNet2Mobile isFromWifi=" + paramBoolean);
    }
  }
  
  protected void lZ(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNet2Wifi isFromMobile=" + paramBoolean);
    }
  }
  
  protected void md(String paramString)
  {
    this.c.aJS();
    PublicFragmentActivity.startForResult(this, new Intent(), ReadInJoySelectMemberFragment.class, 10000);
  }
  
  protected void me(String paramString) {}
  
  public void oM(int paramInt)
  {
    this.aIK = paramInt;
    if (paramInt == 1)
    {
      if (this.hX != null) {
        this.hX.setImageResource(2130843781);
      }
      if (this.hY != null) {
        this.hY.setImageResource(2130843783);
      }
      if ((this.c != null) && (this.c.vm() != 1)) {
        this.c.abp(1);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt != 2) {
              break;
            }
            if (this.hX != null) {
              this.hX.setImageResource(2130850239);
            }
            if ((this.c != null) && (this.c.vm() != 3)) {
              this.c.abp(3);
            }
          } while (this.hY == null);
          this.hY.setImageResource(2130843783);
          return;
          if (paramInt != 0) {
            break;
          }
          if (this.hY != null) {
            this.hY.setImageResource(2130843783);
          }
          if ((this.c != null) && (this.c.vm() != 0)) {
            this.c.aJS();
          }
        } while (this.hX == null);
        this.hX.setImageResource(2130843781);
        return;
      } while (paramInt != 3);
      if ((this.c != null) && (this.c.vm() != 24)) {
        this.c.abp(24);
      }
      if (this.hX != null) {
        this.hX.setImageResource(2130843781);
      }
    } while (this.hY == null);
    this.hY.setImageResource(2130850239);
  }
  
  protected void onCancel()
  {
    onBackEvent();
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
      onCancel();
      continue;
      zp();
      continue;
      aCW();
      continue;
      aCU();
      continue;
      if (b().intValue() < 10)
      {
        aCV();
        continue;
        aCS();
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 == 1) && (paramInt2 == 0) && (isResume()))
    {
      paramCharSequence = paramCharSequence.toString().substring(paramInt1, paramInt1 + 1);
      if ((this.afe) && (paramCharSequence.equals("@"))) {
        md("2");
      }
      if ((this.aff) && (paramCharSequence.equals("#")) && (b().intValue() < 10)) {
        aCV();
      }
    }
  }
  
  protected void r(int paramInt, Intent paramIntent)
  {
    if ((paramIntent == null) || (!this.afe)) {}
    Editable localEditable;
    do
    {
      do
      {
        return;
        paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
      } while ((this.N == null) || (paramIntent == null));
      int i = this.N.getSelectionStart();
      localEditable = this.N.getEditableText();
      paramInt = i;
      if (localEditable != null)
      {
        paramInt = i;
        if (!TextUtils.isEmpty(localEditable.toString()))
        {
          paramInt = i;
          if (i > 0)
          {
            paramInt = i;
            if (localEditable.toString().substring(i - 1, i).equals("@"))
            {
              localEditable.delete(i - 1, i);
              paramInt = i - 1;
              this.N.setSelection(paramInt);
            }
          }
        }
      }
      if (this.aIR <= 0)
      {
        this.aIR = getResources().getDisplayMetrics().widthPixels;
        this.aIR = (this.aIR - this.N.getPaddingLeft() - this.N.getPaddingRight());
      }
    } while (localEditable == null);
    Iterator localIterator = paramIntent.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        try
        {
          l = Long.parseLong(localResultRecord.getUin());
          if (l != 0L)
          {
            paramIntent = ReadInJoyUserInfoModule.a(l, null);
            if (paramIntent != null)
            {
              paramIntent = paramIntent.nick;
              paramIntent = new SpannableStringBuilder("@" + paramIntent + " ");
              paramIntent.setSpan(new AtFriendsSpan(localResultRecord.getUin(), 0L, paramIntent, getApplicationContext(), this.N.getPaint(), this.aIR), 0, paramIntent.length(), 33);
              localEditable.insert(paramInt, paramIntent);
              paramInt = paramIntent.length() + paramInt;
            }
          }
        }
        catch (NumberFormatException paramIntent)
        {
          for (;;)
          {
            QLog.d("ReadInJoyBaseDeliverActivity", 2, paramIntent.getMessage());
            long l = 0L;
            continue;
            paramIntent = ReadInJoyUserInfoModule.getDefaultNickName();
          }
        }
      }
    }
    this.N.setSelection(paramInt);
  }
  
  protected void showLoading(int paramInt)
  {
    if (this.j != null)
    {
      this.j.setMessage(paramInt);
      if (!this.j.isShowing()) {
        this.j.show();
      }
    }
  }
  
  public boolean zp()
  {
    if (this.afa) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "onDeliver overlong!");
      }
    }
    do
    {
      return false;
      if (aqiw.isNetworkAvailable(getApplicationContext())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyBaseDeliverActivity", 2, "onDeliver network error!");
    return false;
    return true;
  }
  
  class a
    implements INetInfoHandler
  {
    private a() {}
    
    public void onNetMobile2None()
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNetMobile2None");
      }
      ReadInJoyBaseDeliverActivity.this.lX(false);
    }
    
    public void onNetMobile2Wifi(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNetMobile2Wifi");
      }
      ReadInJoyBaseDeliverActivity.this.lZ(true);
    }
    
    public void onNetNone2Mobile(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNetNone2Mobile");
      }
      ReadInJoyBaseDeliverActivity.this.lY(false);
    }
    
    public void onNetNone2Wifi(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNetNone2Wifi");
      }
      ReadInJoyBaseDeliverActivity.this.lZ(false);
    }
    
    public void onNetWifi2Mobile(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNetWifi2Mobile");
      }
      ReadInJoyBaseDeliverActivity.this.lY(true);
    }
    
    public void onNetWifi2None()
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNetWifi2None");
      }
      ReadInJoyBaseDeliverActivity.this.lX(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity
 * JD-Core Version:    0.7.0.1
 */