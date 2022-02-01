package com.tencent.mobileqq.troop.activity;

import afmf;
import afmi;
import afqr;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import aofy;
import aovw;
import aovx;
import aovz;
import aowa;
import aowb;
import aowc;
import aowd;
import aowe;
import aowf;
import aowg;
import aowh;
import aowi;
import aozw;
import aprb.a;
import aprv;
import aprv.a;
import aqcx;
import aqha;
import aqhu;
import aqju;
import arhz;
import aurd;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.aio.PlusPanel.a;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicPageView.e;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.troop.widget.TribeHotPicPanel;
import com.tencent.mobileqq.troop.widget.XEditTextExWithListener;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import jnl;
import jqc;
import jqg;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wmi;

public class TroopBarReplyActivity
  extends IphoneTitleBarActivity
  implements afmf, TextWatcher, View.OnClickListener, aprb.a, HotPicPageView.e, InputMethodRelativeLayout.a
{
  public static final String CLASS_NAME = TroopBarReplyActivity.class.getName();
  private static int[] fE = { 2131695430, 2130839324, 2131699486 };
  private static final int[] fG = { 2131721242, 2130839303, 2131699473 };
  private static final int[] gb = { 2131696133, 2130839318, 2131699483 };
  private static final int[] oB = { 2131699471, 2130839325, 2131699472 };
  private static final int[] oC = { 2131699489, 2130839297, 2131699488 };
  protected long Ap;
  protected ImageView Ef;
  protected View HT;
  protected View HU;
  public Uri N;
  private CheckBox R;
  public Button X;
  public CommonRecordSoundPanel a;
  public TroopBarPublishUtils.AudioUploadTask a;
  protected TroopBarPublishUtils.PicUploadThread a;
  public AudioInfo a;
  public TroopBarPOI a;
  protected TribeHotPicPanel a;
  public XEditTextExWithListener a;
  private wmi jdField_a_of_type_Wmi;
  private ImageButton[] jdField_a_of_type_ArrayOfAndroidWidgetImageButton = new ImageButton[4];
  protected ImageButton aG;
  protected Boolean aG;
  public ImageButton aI;
  protected ImageButton aJ;
  protected ImageButton aK;
  protected ImageButton aL;
  protected ImageButton aM;
  public PublishItemContainer b;
  protected InputMethodRelativeLayout b;
  protected BroadcastReceiver bB = new aowi(this);
  protected boolean bSH = true;
  protected FrameLayout bW;
  protected FrameLayout bX;
  protected String bwy;
  private AudioInfo c;
  protected int cLN;
  protected int cLO;
  protected int cLP;
  protected int cLQ;
  public boolean cOP;
  private boolean cOZ;
  public boolean cOn;
  protected boolean cOo = true;
  protected boolean cOr = true;
  protected boolean cOs;
  protected boolean cOu;
  protected boolean cPa = true;
  protected boolean cPb;
  protected boolean cPc;
  public boolean cPd = true;
  boolean cPe;
  boolean cPf;
  int cacheTime = 0;
  protected String cmO = "https://upload.buluo.qq.com/cgi-bin/bar/upload/image";
  protected String cmR;
  protected String cmS;
  protected String cmT;
  protected String cmU;
  public String cmV;
  protected String cmW = "";
  protected String cnc;
  public ArrayList<String> cu = new ArrayList();
  protected int dRA;
  protected int dRB = 0;
  protected int dRC;
  protected int dRy = 9;
  protected int dRz;
  Handler dy = new aovz(this);
  protected ViewGroup eA;
  View.OnClickListener fW = new aowd(this);
  boolean isReply;
  protected LinearLayout kM;
  protected ArrayList<TroopBarPOI> kd;
  protected GridView l;
  public String mBid;
  protected String mCid;
  protected int mFlag;
  protected int mGroupType;
  public Handler mHandler = new aovx(this);
  public String mOpType;
  protected String mPid;
  public arhz mProgress;
  private int mRequestCode;
  protected String mTroopUin;
  private int[] oD = new int[4];
  protected String uP;
  private final int[][] y = new int[5][];
  
  public TroopBarReplyActivity()
  {
    this.jdField_aG_of_type_JavaLangBoolean = Boolean.valueOf(false);
  }
  
  private void Aj(int paramInt)
  {
    this.bW.setBackgroundResource(2130838096);
    switch (paramInt)
    {
    default: 
      this.bW.setBackgroundColor(0);
      this.l.setVisibility(8);
      this.eA.setVisibility(8);
      this.kM.setVisibility(8);
      dWI();
      cBd();
    }
    for (;;)
    {
      pb(true);
      return;
      aurd.hide(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
      this.l.setVisibility(8);
      this.eA.setVisibility(0);
      this.kM.setVisibility(8);
      dWI();
      a(this.jdField_aG_of_type_AndroidWidgetImageButton, true);
      continue;
      aurd.hide(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
      this.l.setVisibility(0);
      this.eA.setVisibility(8);
      this.kM.setVisibility(8);
      dWI();
      a(this.aJ, true);
      continue;
      aurd.hide(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.reset();
      this.kM.setVisibility(0);
      this.l.setVisibility(8);
      this.eA.setVisibility(8);
      dWI();
      a(this.aK, true);
      continue;
      aurd.hide(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
      this.l.setVisibility(8);
      this.eA.setVisibility(8);
      this.kM.setVisibility(8);
      dWH();
      a(this.aI, true);
    }
  }
  
  private void Ro(boolean paramBoolean)
  {
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.4F);
    localAlphaAnimation1.setDuration(0L);
    localAlphaAnimation1.setFillAfter(true);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.4F, 1.0F);
    localAlphaAnimation2.setDuration(0L);
    localAlphaAnimation2.setFillAfter(true);
    this.jdField_aG_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
    if (this.aI != null) {
      this.aI.setEnabled(paramBoolean);
    }
    this.aJ.setEnabled(paramBoolean);
    if (this.aK != null) {
      this.aK.setEnabled(paramBoolean);
    }
    if (this.aM != null) {
      this.aM.setEnabled(paramBoolean);
    }
    if (this.aL != null) {
      this.aL.setEnabled(paramBoolean);
    }
    this.X.setEnabled(paramBoolean);
    this.Ef.setEnabled(paramBoolean);
    findViewById(2131380165).setEnabled(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_aG_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation2);
      if (this.aI != null) {
        this.aI.startAnimation(localAlphaAnimation2);
      }
      this.aJ.startAnimation(localAlphaAnimation2);
      this.X.startAnimation(localAlphaAnimation2);
      if (this.aK != null) {
        this.aK.startAnimation(localAlphaAnimation2);
      }
      if (this.aM != null) {
        this.aM.startAnimation(localAlphaAnimation2);
      }
      if (this.aL != null) {
        this.aL.startAnimation(localAlphaAnimation2);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.startAnimation(localAlphaAnimation2);
      this.Ef.startAnimation(localAlphaAnimation2);
      pb(false);
      return;
    }
    this.jdField_aG_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation1);
    if (this.aI != null) {
      this.aI.startAnimation(localAlphaAnimation1);
    }
    this.aJ.startAnimation(localAlphaAnimation1);
    if (this.aK != null) {
      this.aK.startAnimation(localAlphaAnimation1);
    }
    if (this.aM != null) {
      this.aM.startAnimation(localAlphaAnimation1);
    }
    if (this.aL != null) {
      this.aL.startAnimation(localAlphaAnimation1);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.startAnimation(localAlphaAnimation1);
    this.Ef.startAnimation(localAlphaAnimation1);
    pb(true);
    this.X.startAnimation(localAlphaAnimation1);
  }
  
  private void Sj(String paramString)
  {
    WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = null;
    paramString = TroopBarPublishUtils.a(paramString, this.cu, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo, null);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bid", Long.parseLong(this.mBid));
      localJSONObject.put("post", paramString);
      paramString = localWebSsoRequestBody;
      if (TextUtils.isEmpty(null)) {
        paramString = "###...^_^###";
      }
      localJSONObject.put("title", paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
      {
        localJSONObject.put("uid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.uid);
        localJSONObject.put("lat", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.latitude));
        localJSONObject.put("lon", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.longitude));
      }
      localJSONObject.put("type", 0);
      localJSONObject.put("extparam", this.cnc);
      localJSONObject.put("version", "3.4.4.3058");
      localJSONObject.put("pubsource", 1);
      localJSONObject.put("theme_id", 0);
      paramString = new NewIntent(super.getApplicationContext(), jnl.class);
      paramString.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.publish_post");
      localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
      localWebSsoRequestBody.type.set(0);
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
      paramString.setObserver(new aovw(this));
      this.app.startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QQToast.a(this, 1, 2131698503, 0).show(getTitleBarHeight());
      paramString.printStackTrace();
      this.cOP = false;
    }
  }
  
  private void Sk(String paramString)
  {
    boolean bool;
    JSONObject localJSONObject;
    if (this.R != null)
    {
      bool = this.R.isChecked();
      paramString = TroopBarPublishUtils.a(paramString, this.cu, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("pid", this.mPid);
        localJSONObject.put("bid", Long.parseLong(this.mBid));
        localJSONObject.put("comment", paramString);
        if (bool) {
          localJSONObject.put("is_forward", 1);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
        {
          localJSONObject.put("uid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.uid);
          localJSONObject.put("lat", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.latitude));
          localJSONObject.put("lon", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.longitude));
        }
        localJSONObject.put("extparam", this.cnc);
        localJSONObject.put("version", "3.4.4.3058");
        this.X.setEnabled(false);
        NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), jnl.class);
        if (bool) {
          aprv.d(this.cmV, "reply_page_new", "share_interest", this.mBid, "", "", "");
        }
        if (this.mGroupType != 1) {
          break label336;
        }
        paramString = "MQUpdateSvc_com_qq_xiaoqu.web.comment";
        localNewIntent.putExtra("cmd", paramString);
        paramString = new WebSsoBody.WebSsoRequestBody();
        paramString.type.set(0);
        paramString.data.set(localJSONObject.toString());
        localNewIntent.putExtra("data", paramString.toByteArray());
        localNewIntent.setObserver(new aowf(this));
        this.app.startServlet(localNewIntent);
        return;
      }
      catch (Exception paramString)
      {
        QQToast.a(this, 1, 2131698503, 0).show(getTitleBarHeight());
        xa(false);
        this.cOP = false;
        return;
      }
      bool = false;
      break;
      label336:
      paramString = "MQUpdateSvc_com_qq_buluo.web.sbar_comment";
    }
  }
  
  private void a(ImageButton paramImageButton, boolean paramBoolean)
  {
    if (paramImageButton != null)
    {
      paramImageButton.setSelected(true);
      paramImageButton.setImageResource(2130848766);
    }
    if (paramBoolean)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton.length)
      {
        if ((this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[i] != null) && (this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[i] != paramImageButton)) {
          b(this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[i], this.oD[i]);
        }
        i += 1;
      }
    }
  }
  
  private boolean aAF()
  {
    return this.cPe;
  }
  
  private void b(ImageButton paramImageButton, int paramInt)
  {
    if (paramImageButton != null)
    {
      paramImageButton.setSelected(false);
      paramImageButton.setImageResource(paramInt);
    }
  }
  
  private void cBd()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton.length)
    {
      if (this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[i] != null) {
        b(this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[i], this.oD[i]);
      }
      i += 1;
    }
  }
  
  private void dXm()
  {
    b(this.aK, this.oD[2]);
    if (this.kM != null) {
      this.kM.setVisibility(8);
    }
  }
  
  private void dXp()
  {
    if (this.cPd) {
      aprv.d(this.cmV, this.mOpType, "Clk_photo", this.mBid, "", "", "");
    }
    if (lS(1)) {
      return;
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.getCurType() != 0) && (this.jdField_b_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.getCurType() != 1))
    {
      Wn(1);
      return;
    }
    dXn();
  }
  
  private void dXq()
  {
    if (this.cPd) {
      aprv.d(this.cmV, this.mOpType, "Clk_shoot", this.mBid, "", "", "");
    }
    if (lS(1)) {
      return;
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.getCurType() != 0) && (this.jdField_b_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.getCurType() != 1))
    {
      Wn(0);
      return;
    }
    dXo();
  }
  
  private void dXr()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.getCurType() != 0) && (this.jdField_b_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.getCurType() != 1))
    {
      Wn(6);
      return;
    }
    if (this.aI.isSelected())
    {
      dWI();
      aurd.aO(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
      return;
    }
    a(this.aI, true);
    aurd.hide(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
    this.mHandler.postDelayed(new TroopBarReplyActivity.14(this), 200L);
  }
  
  private void dXs()
  {
    if (this.cPd)
    {
      aprv.d(this.cmV, this.mOpType, "Clk_record", this.mBid, "", "", "");
      aprv.l("reply_page_new", "Clk_record", this.mBid, "", "", "");
    }
    if (lS(2)) {
      return;
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.getCurType() != 0) && (this.jdField_b_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.getCurType() != 2))
    {
      Wn(2);
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.getCurType() == 2)
    {
      Wn(5);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.RECORD_AUDIO") != 0))
    {
      requestPermissions(new aowc(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
      return;
    }
    a(this.aK, true);
    Aj(4);
  }
  
  private void fo(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getResources();
    this.aJ.setVisibility(8);
    if ((this.dRA & 0x1) == 1)
    {
      this.y[0] = fE;
      this.y[1] = fG;
    }
    for (int j = 2;; j = 0)
    {
      int i = j;
      if ((this.dRA & 0x2) == 2)
      {
        this.y[j] = oB;
        i = j + 1;
      }
      j = i;
      if ((this.dRA & 0x8) == 8)
      {
        this.y[i] = oC;
        j = i + 1;
      }
      i = j;
      if ((this.dRA & 0x4) == 4)
      {
        this.y[j] = gb;
        i = j + 1;
      }
      if (i > 0)
      {
        this.aJ.setVisibility(0);
        i = 0;
        if (i < this.y.length)
        {
          int[] arrayOfInt = this.y[i];
          if (arrayOfInt == null) {}
          for (;;)
          {
            i += 1;
            break;
            if (arrayOfInt.length == fE.length)
            {
              PlusPanel.a locala = new PlusPanel.a();
              locala.drawable = paramContext.getDrawable(arrayOfInt[1]);
              locala.actionId = arrayOfInt[1];
              locala.text = paramContext.getString(arrayOfInt[0]);
              locala.contentDescription = paramContext.getString(arrayOfInt[2]);
              locala.beg = false;
              localArrayList.add(locala);
            }
          }
        }
        this.jdField_a_of_type_Wmi.cW(localArrayList);
        this.jdField_a_of_type_Wmi.notifyDataSetChanged();
      }
      return;
    }
  }
  
  private void pb(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.HU.setVisibility(0);
      this.HU.setBackgroundColor(2130706432);
      return;
    }
    this.HU.setVisibility(4);
    this.HU.setBackgroundColor(0);
    this.HU.setBackgroundResource(2130851773);
  }
  
  public void Wn(int paramInt)
  {
    boolean bool = true;
    aqju localaqju = aqha.a(this, 230);
    localaqju.setTitle(2131699480);
    Object localObject = new aowa(this, paramInt);
    localaqju.setNegativeButton(getString(2131699478), (DialogInterface.OnClickListener)localObject);
    String str;
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      str = getString(2131699484, new Object[] { getString(2131699471) });
      localaqju.setMessage(str);
      localaqju.setPositiveButton(getString(2131699474), (DialogInterface.OnClickListener)localObject);
    }
    for (;;)
    {
      localaqju.setMessage(str);
      localaqju.show();
      return;
      str = getString(2131699484, new Object[] { getString(2131699482) });
      localaqju.setPositiveButton(getString(2131699475), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131699484, new Object[] { getString(2131699485) });
      localaqju.setPositiveButton(getString(2131699476), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131699484, new Object[] { getString(2131699485) });
      localaqju.setPositiveButton(getString(2131699476), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131699484, new Object[] { getString(2131699485) });
      localaqju.setPositiveButton(getString(2131699476), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131698502, new Object[] { Integer.valueOf(9) });
      localObject = this.jdField_b_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer;
      if (this.cu.size() < 9) {}
      for (;;)
      {
        ((PublishItemContainer)localObject).Sl(bool);
        break;
        bool = false;
      }
      str = getString(2131699487);
      localaqju.setPositiveButton(getString(2131699479), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131699484, new Object[] { getString(2131699489) });
      localaqju.setPositiveButton(getString(2131699477), (DialogInterface.OnClickListener)localObject);
    }
  }
  
  public void Wo(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("bid", this.mBid);
    localBundle.putString("pid", this.mPid);
    localBundle.putString("from", "qqbuluo");
    localBundle.putString("uin", this.app.getCurrentAccountUin());
    localBundle.putString("content", aprv.f(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener).trim());
    String str;
    if (paramInt == 3) {
      str = "video";
    }
    for (;;)
    {
      localBundle.putString("clicktype", str);
      try
      {
        localBundle.putString("floor", new JSONObject(this.cnc).getString("floor"));
        label112:
        TroopBarPublishUtils.a(this, 2, paramInt, localBundle);
        return;
        str = "music";
      }
      catch (Exception localException)
      {
        break label112;
      }
    }
  }
  
  public void a(int paramInt, aozw paramaozw)
  {
    if (paramaozw == null) {
      return;
    }
    if ((paramaozw instanceof AudioInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)paramaozw);
    }
    this.cu.clear();
    this.jdField_b_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a(paramInt, paramaozw);
    Aj(0);
    aurd.aO(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
  }
  
  public void a(afmi paramafmi)
  {
    if (((paramafmi instanceof afqr)) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener != null)) {
      ((afqr)paramafmi).a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener, null);
    }
  }
  
  public void a(afmi paramafmi1, afmi paramafmi2, Drawable paramDrawable) {}
  
  protected void a(BaseActivity paramBaseActivity, int paramInt, Handler paramHandler)
  {
    paramBaseActivity.runOnUiThread(new TroopBarReplyActivity.17(this));
    if (((TicketManager)paramBaseActivity.app.getManager(2)).getSkey(paramBaseActivity.app.getCurrentAccountUin()) != null) {
      switch (paramInt)
      {
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      ThreadManager.post(new TroopBarPublishUtils.PicUploadThread(paramBaseActivity, paramHandler, this.cu, this.cmO), 8, null, true);
      return;
    }
    QLog.w("IphoneTitleBarActivity", 2, "startUploadImage skey is null!!!!!!!!!!!!!!!");
  }
  
  protected void a(BaseActivity paramBaseActivity, aprb.a parama)
  {
    SosoInterface.a(new aowe(this, 0, true, true, this.cacheTime, false, false, "AbsPublish", paramBaseActivity, parama));
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
      QLog.e("IphoneTitleBarActivity", 2, "filePath is null");
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
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "repky restore key = " + this.uP);
    }
    if (TextUtils.isEmpty(this.uP)) {
      return false;
    }
    aprv.a locala = (aprv.a)aprv.ou.get(this.uP);
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "reply restore key = " + this.uP + ", replyData = " + locala);
    }
    aprv.ou.clear();
    if (locala == null) {
      return false;
    }
    if (this.cu.size() <= 0) {
      this.cu = locala.cu;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = locala.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI;
    this.kd = locala.kd;
    this.cLN = locala.cLN;
    this.cLO = locala.cLO;
    this.bwy = locala.bwy;
    this.cmT = locala.mContent;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = locala.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo;
    return true;
  }
  
  protected void aN(JSONObject paramJSONObject)
  {
    jqg.d((String)null, 0);
    if (this.dRB != 0) {
      dWK();
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("key_photo_delete_action");
    localIntentFilter.addAction("key_audio_delete_action");
    localIntentFilter.addAction("key_photo_add_action");
    registerReceiver(this.bB, localIntentFilter);
    this.mBid = paramJSONObject.optString("bid", "");
    this.mPid = paramJSONObject.optString("pid", "");
    this.mCid = paramJSONObject.optString("cid", "");
    if (TextUtils.isEmpty(this.mCid)) {}
    for (this.uP = (this.app.getCurrentAccountUin() + "-" + this.mBid + "-" + this.mPid);; this.uP = (this.app.getCurrentAccountUin() + "-" + this.mBid + "-" + this.mPid + "-" + this.mCid))
    {
      this.cnc = paramJSONObject.optString("extparam");
      this.cmV = "Grp_tribe";
      this.mOpType = "reply_page";
      return;
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int j = 0;
    this.cLP = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.getSelectionStart();
    this.cLQ = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.getSelectionEnd();
    String str = aprv.f(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
    int i;
    if (str == null)
    {
      i = 0;
      if ((this.cLO <= 0) || (i <= this.cLO)) {
        break label157;
      }
      i -= this.cLO;
      paramEditable.delete(this.cLP - i, this.cLQ);
      this.cLP -= i;
      this.cLQ -= i;
      if (this.jdField_aG_of_type_JavaLangBoolean.booleanValue()) {
        break label170;
      }
      QQToast.a(this, this.cmW, 0).show(getTitleBarHeight());
      this.jdField_aG_of_type_JavaLangBoolean = Boolean.valueOf(true);
    }
    label157:
    label170:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.setSelection(i + this.cLP);
      return;
      i = str.length();
      break;
      this.jdField_aG_of_type_JavaLangBoolean = Boolean.valueOf(false);
      i = j;
    }
  }
  
  public void b(afmi paramafmi) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void bsq()
  {
    Object localObject;
    if ((this.mRequestCode == 101000) || (this.cPb) || (this.cPc))
    {
      str = aprv.f(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener).replace("\n", " ");
      this.cOn = true;
      localObject = new Intent();
      ((Intent)localObject).putExtra("result", "\"" + str + "\"");
      setResult(-1, (Intent)localObject);
      finish();
    }
    while (this.cOP) {
      return;
    }
    if ((this.mGroupType == 2) && (this.cPd)) {
      aprv.d("Grp_talk", "pub_reco", "Clk_reco", this.mTroopUin, "", "", "");
    }
    this.cOP = true;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.mStop = true;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$AudioUploadTask != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$AudioUploadTask.La() != 0))
    {
      xa(true);
      return;
    }
    String str = aprv.f(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
    if (!TextUtils.isEmpty(str)) {
      str = str.trim();
    }
    for (int i = str.length();; i = 0)
    {
      if ((!this.cOs) || (this.cu.isEmpty()))
      {
        if (i == 0)
        {
          QQToast.a(this, 2131698500, 0).show(getTitleBarHeight());
          if (this.cPd) {
            aprv.report("reply_page", "fail", this.mBid, "2", "", "");
          }
          this.cOP = false;
          return;
        }
        if (i < this.cLN)
        {
          QQToast.a(this, getString(2131698498, new Object[] { Integer.valueOf(this.cLN) }), 0).show(getTitleBarHeight());
          if (this.cPd) {
            aprv.report("reply_page", "fail", this.mBid, "2", "", "");
          }
          this.cOP = false;
          return;
        }
        if (i > this.cLO)
        {
          QQToast.a(this, getString(2131698499, new Object[] { Integer.valueOf(this.cLO) }), 0).show(getTitleBarHeight());
          if (this.cPd) {
            aprv.report("reply_page", "fail", this.mBid, "4", "", "");
          }
          this.cOP = false;
          return;
        }
      }
      if (!r(this.dRA, this.cOu))
      {
        this.cOP = false;
        return;
      }
      if (!jqc.ak(this))
      {
        QQToast.a(this, 2131696206, 0).show(getTitleBarHeight());
        if (this.cPd) {
          aprv.report("reply_page", "fail", this.mBid, "7", "", "");
        }
        this.cOP = false;
        return;
      }
      xa(true);
      i = 0;
      for (;;)
      {
        if (i >= this.cu.size()) {
          break label606;
        }
        localObject = (String)this.cu.get(i);
        if ((TroopBarPublishActivity.Pic_list)aprv.w.get(localObject) == null)
        {
          this.cOP = false;
          a(this, 1, this.mHandler);
          if (!this.cPd) {
            break;
          }
          aprv.report("reply_page", "fail", this.mBid, "10", "", "");
          return;
        }
        i += 1;
      }
      label606:
      if ((aAF()) && (!this.isReply))
      {
        Sj(str);
        return;
      }
      Sk(str);
      return;
    }
  }
  
  protected void d(int paramInt, String... paramVarArgs)
  {
    boolean bool = false;
    switch (paramInt)
    {
    default: 
      paramVarArgs = "";
      label35:
      this.Ef.setSelected(bool);
      if (!bool) {
        break;
      }
    }
    for (;;)
    {
      this.Ef.setContentDescription(paramVarArgs);
      return;
      paramVarArgs = "";
      break label35;
      if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
        break;
      }
      QQToast.a(this, paramVarArgs[0], 1).show(getTitleBarHeight());
      paramVarArgs = "";
      break label35;
      paramVarArgs = "";
      break label35;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!TextUtils.isEmpty(paramVarArgs[0])))
      {
        if (TextUtils.isEmpty(paramVarArgs[0]))
        {
          d(3, new String[0]);
          return;
        }
        paramVarArgs = paramVarArgs[0];
        bool = true;
        break label35;
      }
      d(0, new String[0]);
      return;
      paramVarArgs = getString(2131698482);
    }
  }
  
  public void dWF()
  {
    this.mHandler.postDelayed(new TroopBarReplyActivity.4(this), 200L);
    this.mHandler.postDelayed(new TroopBarReplyActivity.5(this), 500L);
  }
  
  protected void dWH()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel = ((TribeHotPicPanel)LayoutInflater.from(this).inflate(2131563227, null));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.a(this.app, this, this);
      this.bX.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel, -1, aqcx.dip2px(this, 250.0F));
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.onShow();
  }
  
  protected void dWI()
  {
    b(this.aI, this.oD[1]);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.isShown())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.yQ(false);
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
        if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.RECORD_AUDIO") != 0))
        {
          requestPermissions(new aowg(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
          return;
        }
        dWF();
        return;
      } while ((this.dRA & 0x1) != 1);
      dXo();
      return;
    } while ((this.dRA & 0x1) != 1);
    dXn();
  }
  
  public void dXn()
  {
    if (this.cu.size() >= 9)
    {
      QQToast.a(this, getString(2131698502, new Object[] { Integer.valueOf(9) }), 0).show();
      return;
    }
    TroopBarPublishUtils.a(this, this.cu, this.dRy);
  }
  
  public void dXo()
  {
    if (this.cu.size() >= 9)
    {
      QQToast.a(this, getString(2131698502, new Object[] { Integer.valueOf(9) }), 0).show();
      return;
    }
    this.N = TroopBarPublishUtils.a(this, new aowb(this));
  }
  
  protected void ddc()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "reply save key = " + this.uP);
    }
    if (TextUtils.isEmpty(this.uP)) {}
    for (;;)
    {
      return;
      aprv.a locala = new aprv.a();
      ArrayList localArrayList;
      int i;
      if (this.cu != null)
      {
        localArrayList = new ArrayList();
        i = 0;
        while (i < this.cu.size())
        {
          localArrayList.add(this.cu.get(i));
          i += 1;
        }
        locala.cu = localArrayList;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
      {
        locala.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        if (this.kd != null)
        {
          localArrayList = new ArrayList();
          i = j;
          while (i < this.kd.size())
          {
            localArrayList.add(new TroopBarPOI((TroopBarPOI)this.kd.get(i)));
            i += 1;
          }
          locala.kd = localArrayList;
        }
      }
      locala.cLN = this.cLN;
      locala.cLO = this.cLO;
      locala.bwy = this.bwy;
      locala.mContent = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.getEditableText().toString();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {}
      try
      {
        locala.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.clone());
        aprv.ou.put(this.uP, locala);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopBar", 2, "reply save key = " + this.uP + ", data = " + locala);
        return;
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
  
  public void delete()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener != null) {
      aofy.g(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    cBd();
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
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, null, this.cu, "https://upload.buluo.qq.com/cgi-bin/bar/upload/image");
        ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
      } while (!this.cPd);
      aprv.report("reply_page", "choose_place", this.mBid, "2", "", "");
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
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.isRecording();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBackEvent() is called,isRecording is:" + bool);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.onBackEvent();
    this.jdField_b_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.stopAudio();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if (paramBundle == null)
    {
      QQToast.a(this, 1, getString(2131698504, new Object[] { Integer.valueOf(990) }), 0).show(getTitleBarHeight());
      finish();
      return false;
    }
    this.mRequestCode = paramBundle.getInt("requestCode", 0);
    paramBundle = paramBundle.getString("options");
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "publish option: " + paramBundle);
    }
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(paramBundle);
        this.cPe = paramBundle.optString("platform").equals("FTS");
        this.isReply = paramBundle.optBoolean("isReply");
        this.cPf = paramBundle.optBoolean("needRecord", true);
        this.cmR = paramBundle.optString("selectContent");
        this.cmS = paramBundle.optString("selectUrl");
        this.cLN = paramBundle.optInt("minContentLength", 3);
        this.cLO = paramBundle.optInt("maxContentLength", 700);
        this.bwy = paramBundle.optString("contentPlaceholder", this.bwy);
        this.cOs = paramBundle.optBoolean("photoOrContent");
        this.cOr = paramBundle.optBoolean("needLocation", true);
        this.bSH = paramBundle.optBoolean("needFace", true);
        this.cOZ = paramBundle.optBoolean("needForward", false);
        this.cOo = paramBundle.optBoolean("isPreUpload", true);
        this.mFlag = paramBundle.optInt("flag");
        if (paramBundle.optInt("recordTimeLimit") == 0)
        {
          i = 60000;
          this.dRz = i;
          if (paramBundle.optInt("requireType", 0) == 0) {
            break label607;
          }
          bool = true;
          this.cOu = bool;
          this.dRA = paramBundle.optInt("optionType", 1);
          this.uP = paramBundle.optString("cacheKey");
          this.dRB = paramBundle.optInt("defaultCategory", 0);
          this.dRy = paramBundle.optInt("maxPhotoCount", 9);
          this.dRC = paramBundle.optInt("forbiddenType", 0);
          this.cmU = paramBundle.optString("forbiddenMsg", getString(2131699468));
          this.cmW = getString(2131698473, new Object[] { Integer.valueOf(this.cLO) });
          this.mGroupType = paramBundle.optInt("groupType", 1);
          this.mTroopUin = paramBundle.optString("groupUin", "");
          this.cPa = paramBundle.optBoolean("need_plus_btn", true);
          this.cPb = paramBundle.optBoolean("content_to_web", false);
          this.cPc = paramBundle.optBoolean("sendToWeb", false);
          this.cPd = paramBundle.optBoolean("needTribeReport", true);
          if (this.cPc) {
            this.cPd = false;
          }
          aN(paramBundle);
          if (this.dRB == 0) {
            aAx();
          }
          initUI();
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
      label607:
      boolean bool = false;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_b_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer != null) {
      this.jdField_b_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.stopAudio();
    }
    if (!this.cOn) {
      ddc();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.removeTextChangedListener(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.isRecording();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onDestroy() is called,isRecording is:" + bool);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.onDestroy();
    }
    unregisterReceiver(this.bB);
    try
    {
      Field localField = Class.forName("android.widget.BubblePopupHelper").getDeclaredField("sHelper");
      localField.setAccessible(true);
      localField.set(null, null);
      if (QLog.isColorLevel()) {
        QLog.e("IphoneTitleBarActivity", 2, "doOnDestroy: cut sHelper ref true");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("IphoneTitleBarActivity", 2, "doOnDestroy: " + QLog.getStackTraceString(localException));
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
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, null, this.cu, "https://upload.buluo.qq.com/cgi-bin/bar/upload/image");
        ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.isRecording();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onPause() is called,isRecording is:" + bool);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.onPause();
    this.jdField_b_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.stopAudio();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_b_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.stopAudio();
    if (this.mHandler != null)
    {
      this.mHandler.removeMessages(1001);
      this.mHandler.removeMessages(1003);
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener != null) {
      aurd.hide(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
    }
    overridePendingTransition(0, 2130771990);
    if (((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.length() > 0)) || ((this.cu != null) && (this.cu.size() > 0))) {}
    for (String str = "0";; str = "1")
    {
      if (this.cPd) {
        aprv.report("reply_page", "un", this.mBid, str, "", "");
      }
      return;
    }
  }
  
  public void gq() {}
  
  protected void initUI()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        if (aAF())
        {
          setContentView(2131560121);
          this.dRA = 0;
          Object localObject = findViewById(2131377361);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131377556));
          this.HU = findViewById(2131380165);
          this.jdField_aG_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131368967));
          this.aI = ((ImageButton)findViewById(2131368968));
          this.aJ = ((ImageButton)findViewById(2131373427));
          this.aK = ((ImageButton)findViewById(2131363792));
          this.aL = ((ImageButton)findViewById(2131363799));
          this.aM = ((ImageButton)findViewById(2131368969));
          if ((!this.cPf) && (this.aK != null)) {
            this.aK.setVisibility(8);
          }
          this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[0] = this.jdField_aG_of_type_AndroidWidgetImageButton;
          this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[1] = this.aI;
          this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[2] = this.aK;
          this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[3] = this.aJ;
          this.oD[0] = 2130844487;
          this.oD[1] = 2130843360;
          this.oD[2] = 2130843352;
          this.oD[3] = 2130844490;
          this.Ef = ((ImageView)findViewById(2131369042));
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener = ((XEditTextExWithListener)findViewById(2131366529));
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.setOnKeyPreImeListener(new aowh(this));
          this.X = ((Button)findViewById(2131377990));
          this.jdField_b_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer = ((PublishItemContainer)findViewById(2131377146));
          this.jdField_b_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setMaxPicNum(9);
          this.HT = findViewById(2131368938);
          this.bW = ((FrameLayout)findViewById(2131370190));
          this.bX = ((FrameLayout)findViewById(2131370217));
          this.eA = TroopBarPublishUtils.a(this, this.bW, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener, this);
          this.jdField_b_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
          findViewById(2131380165).setOnClickListener(this);
          this.l = ((GridView)findViewById(2131373429));
          this.l.setVisibility(8);
          this.jdField_a_of_type_Wmi = new wmi();
          this.jdField_a_of_type_Wmi.w(this.fW);
          this.l.setAdapter(this.jdField_a_of_type_Wmi);
          fo(this);
          this.kM = ((LinearLayout)findViewById(2131363083));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)LayoutInflater.from(this).inflate(2131560053, null));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.app, this, this.dy, 1);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.reset();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setPadding(0, aqcx.dip2px(this, 20.0F), 0, aqcx.dip2px(this, 25.0F));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(this.dRz);
          this.kM.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
          this.jdField_aG_of_type_AndroidWidgetImageButton.setOnClickListener(this);
          if (this.aI != null) {
            this.aI.setOnClickListener(this);
          }
          this.Ef.setOnClickListener(this);
          this.aJ.setOnClickListener(this);
          if (aAF())
          {
            this.aK.setOnClickListener(this);
            this.aM.setOnClickListener(this);
            this.aL.setOnClickListener(this);
          }
          this.X.setSelected(true);
          this.X.setPressed(false);
          this.X.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.addTextChangedListener(this);
          if ((TextUtils.isEmpty(this.bwy)) || (this.cLN <= 0) || (this.cLO <= 0))
          {
            this.cLN = 3;
            this.cLO = 700;
            this.bwy = getString(2131698474, new Object[] { Integer.valueOf(this.cLN), Integer.valueOf(this.cLO) });
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.setHint(this.bwy);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.getText().length() <= 0)
          {
            XEditTextExWithListener localXEditTextExWithListener = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener;
            if (TextUtils.isEmpty(this.cmT)) {
              break label1087;
            }
            localObject = this.cmT;
            localXEditTextExWithListener.setText((CharSequence)localObject);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
            break label1103;
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name)) {
            break label1092;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.Tr;
          d(1, new String[] { localObject });
          a(this, this);
          localObject = this.Ef;
          if (!this.cOr) {
            break label1115;
          }
          i = 0;
          ((ImageView)localObject).setVisibility(i);
          localObject = this.jdField_aG_of_type_AndroidWidgetImageButton;
          if (!this.bSH) {
            break label1121;
          }
          i = 0;
          ((ImageButton)localObject).setVisibility(i);
          if (this.aI != null)
          {
            localObject = this.aI;
            if (!this.bSH) {
              break label1127;
            }
            i = j;
            ((ImageButton)localObject).setVisibility(i);
          }
          if (this.cu.size() <= 0) {
            break label1133;
          }
          a(this.mHandler, this.cu);
          if (!this.cPa) {
            this.aJ.setVisibility(8);
          }
          localObject = new StringBuffer();
          if ((this.dRA & 0x1) == 1) {
            ((StringBuffer)localObject).append("0");
          }
          if ((this.dRA & 0x2) == 2) {
            ((StringBuffer)localObject).append("1");
          }
          if (this.cPd)
          {
            aprv.report("reply_page", "choose_place", this.mBid, "0", ((StringBuffer)localObject).toString(), "");
            aprv.report("reply_page", "exp", String.valueOf(this.mBid), "", "", "");
          }
          return;
        }
        if (this.cOZ)
        {
          setContentView(2131560120);
          this.R = ((CheckBox)findViewById(2131377135));
          continue;
        }
        setContentView(2131560119);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        finish();
        return;
      }
      continue;
      label1087:
      String str = null;
      continue;
      label1092:
      str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.name;
      continue;
      label1103:
      d(0, new String[0]);
      continue;
      label1115:
      int i = 8;
      continue;
      label1121:
      i = 8;
      continue;
      label1127:
      i = 8;
      continue;
      label1133:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {
        a(2, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
      }
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void l(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      Aj(0);
      cBd();
    }
  }
  
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
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("IphoneTitleBarActivity", 2, "transparent_space click!!!!!!!!!!!!!!!");
      }
      this.jdField_b_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.stopAudio();
      finish();
      continue;
      Object localObject = new Intent(this, TroopBarPublishLocationSelectActivity.class);
      ((Intent)localObject).putParcelableArrayListExtra("current_location_list", this.kd);
      ((Intent)localObject).putExtra("key_selected_poi", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      startActivityForResult((Intent)localObject, 1002);
      if (this.cPd)
      {
        String str = this.mBid;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {}
        for (localObject = "0";; localObject = "1")
        {
          aprv.report("reply_page", "Clk_place", str, (String)localObject, "", "");
          break;
        }
        dXr();
        continue;
        if (System.currentTimeMillis() - this.Ap >= 500L)
        {
          this.Ap = System.currentTimeMillis();
          if (this.eA.getVisibility() == 0)
          {
            this.eA.setVisibility(8);
            aurd.aO(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
            cBd();
          }
          else
          {
            aurd.hide(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
            this.mHandler.postDelayed(new TroopBarReplyActivity.6(this), 200L);
            continue;
            this.jdField_b_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.stopAudio();
            bsq();
            continue;
            if (this.cPd)
            {
              aprv.report("reply_page", "del_photo", this.mBid, "", "", "");
              continue;
              if (this.cPd)
              {
                aprv.report("pub_page", "choose_photo", this.mBid, "", "", "");
                continue;
                if (this.l.getVisibility() == 0)
                {
                  Aj(0);
                  this.mHandler.postDelayed(new TroopBarReplyActivity.7(this), 200L);
                }
                else
                {
                  aurd.hide(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
                  this.mHandler.postDelayed(new TroopBarReplyActivity.8(this), 200L);
                  if (this.cPd)
                  {
                    aprv.d(this.cmV, this.mOpType, "Clk_add", this.mBid, "", "", "");
                    continue;
                    dXq();
                    continue;
                    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.isRecording()) {
                      if (this.aK.isSelected())
                      {
                        dXm();
                        aurd.aO(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
                      }
                      else
                      {
                        dXs();
                        continue;
                        dXp();
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected boolean r(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      return true;
      Object localObject2 = null;
      Object localObject1;
      if (((paramInt & 0x1) == 1) && (this.cu.size() == 0)) {
        localObject1 = getString(2131699470, new Object[] { getString(2131699485) });
      }
      while (localObject1 != null)
      {
        QQToast.a(this, (CharSequence)localObject1, 0).show(getTitleBarHeight());
        return false;
        localObject1 = localObject2;
        if ((paramInt & 0x2) == 2)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo == null) {
            localObject1 = getString(2131699470, new Object[] { getString(2131699471) });
          }
        }
      }
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void send() {}
  
  public void setting() {}
  
  public void xa(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mProgress == null) {
        this.mProgress = new arhz(this, getTitleBarHeight());
      }
      this.mProgress.setMessage(2131698496);
      this.mProgress.show();
    }
    while ((this.mProgress == null) || (!this.mProgress.isShowing())) {
      return;
    }
    this.mProgress.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarReplyActivity
 * JD-Core Version:    0.7.0.1
 */