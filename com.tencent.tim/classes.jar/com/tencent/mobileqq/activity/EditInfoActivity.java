package com.tencent.mobileqq.activity;

import accn;
import acfd;
import acff;
import acfp;
import acle;
import aclh;
import acms;
import acnd;
import aere;
import aerf;
import afmf;
import afmi;
import afqh;
import afqr;
import alkw;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aofe;
import aofh;
import aofy;
import aqcx;
import aqho;
import aqiw;
import aqpk;
import aqpk.a;
import aqpk.b;
import aqpk.d;
import aqpk.e;
import aqpm;
import aqpm.c;
import aqpm.d;
import aqqa;
import aqrd;
import aqrf;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.a;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.profile.view.SoftInputDetectView.a;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.ClearableEditText.b;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.mobileqq.widget.ColorClearableEditText.a;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.mobileqq.widget.InputMethodLinearLayout.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.CommCardNameBuf;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.RichCardNameElem;
import uvp;
import uvq;
import uvs;
import uvt;
import uvu;
import uvv;
import uvy;
import uvz;
import uwa;
import uwb;
import uwc;
import uwd;
import uwe;
import uwf;
import uwg;

public class EditInfoActivity
  extends IphoneTitleBarActivity
  implements afmf, Handler.Callback, View.OnClickListener, aqpk.d, SoftInputDetectView.a, ClearableEditText.b, InputMethodLinearLayout.a
{
  public String AH;
  TextView Da = null;
  TextView Db;
  TextView Dc;
  TextView Dd;
  boolean Ny = true;
  private accn jdField_a_of_type_Accn = new uvs(this);
  private acfd jdField_a_of_type_Acfd = new uvt(this);
  acnd jdField_a_of_type_Acnd = new uvq(this);
  private aqpk.b jdField_a_of_type_Aqpk$b = new uvy(this);
  aqpk jdField_a_of_type_Aqpk;
  SystemAndEmojiUniversalPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel = null;
  SoftInputDetectView jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView;
  ColorNickTextView jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
  InputMethodLinearLayout jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout;
  private aqpk.a[] jdField_a_of_type_ArrayOfAqpk$a = { new aqpk.a(2, null, 0, null) };
  public EditText aA;
  public String aMT = "";
  String aMU = "";
  protected String aMV;
  String aMW;
  public boolean aVD;
  public boolean aVI;
  protected boolean aVJ;
  protected boolean aVK;
  boolean aVL = true;
  boolean aVM = false;
  public boolean aVN = false;
  boolean aVO = false;
  public boolean aVP;
  private boolean aVQ;
  private boolean aVR;
  private aclh b;
  public EllipsizingTextView b;
  protected int bGG = -1;
  public int bGH = 0;
  public int bGI = 0;
  public int bGJ = 0;
  public int bGK = 0;
  private int bGL;
  private int bGM;
  private int bGN;
  private aqrd c = new uvv(this);
  protected ViewGroup cR;
  EmoticonMainPanel d;
  protected Drawable dA;
  public LinearLayout fX = null;
  RelativeLayout gA;
  RelativeLayout gB;
  RelativeLayout gC;
  RelativeLayout gy;
  RelativeLayout gz;
  public int mAction = 0;
  public int mFromFlag = -1;
  public Handler mHandler = new Handler(this);
  boolean mIsFullScreen = false;
  RecyclerView.LayoutManager mLayoutManager;
  String mRightBtnText;
  protected String mTitle;
  public String mTroopUin;
  protected int mType = -1;
  public ImageView pR;
  ImageView pS;
  ImageView pT;
  ImageView pU;
  private ArrayList<aqpk.a> pe = new ArrayList();
  private ArrayList<Integer> pf = new ArrayList();
  RecyclerView t;
  public String uin;
  
  public EditInfoActivity()
  {
    this.jdField_b_of_type_Aclh = new uvu(this);
  }
  
  private void AE(int paramInt)
  {
    this.app.addObserver(this.jdField_b_of_type_Aclh);
    ((acle)this.app.getBusinessHandler(13)).JO(paramInt);
  }
  
  private void AF(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.bGL = 0;
      return;
      if (this.bGN == 1)
      {
        IM();
      }
      else
      {
        this.bGN = 1;
        this.gB.setVisibility(8);
        aqpm.a(this.app).dK = this.mHandler;
        this.pT.setImageResource(2130847941);
        this.pS.setImageResource(2130847946);
        this.gz.setVisibility(0);
        this.gA.setVisibility(0);
        this.t.setVisibility(8);
        ((RelativeLayout.LayoutParams)this.gz.getLayoutParams()).height = aqcx.dip2px(this, 387.0F);
        ((RelativeLayout.LayoutParams)this.gy.getLayoutParams()).bottomMargin = aqcx.dip2px(this, 387.0F);
        if (this.d == null)
        {
          this.d = ((EmoticonMainPanel)View.inflate(getBaseContext(), 2131559281, null));
          if (this.mFromFlag == 0) {
            this.d.setFilterSysFaceBeyond255Enable(true);
          }
          this.d.setCallBack(this);
          this.d.bYZ = true;
          this.d.bZc = true;
          this.d.bYX = false;
          this.d.bYY = true;
          this.d.bZb = true;
          this.d.a(this.app, 100001, this, getTitleBarHeight(), null, null, false, aqpm.a(this.app).a);
          this.d.a.setOverScrollMode(2);
          this.gA.addView(this.d);
          continue;
          if (this.bGN == 2)
          {
            IM();
          }
          else
          {
            this.bGN = 2;
            this.gB.setVisibility(8);
            aqpm.a(this.app).dK = this.mHandler;
            this.pT.setImageResource(2130847940);
            this.pS.setImageResource(2130847947);
            this.gz.setVisibility(0);
            this.gA.setVisibility(8);
            this.t.setVisibility(0);
            ((RelativeLayout.LayoutParams)this.gz.getLayoutParams()).height = aqcx.dip2px(this, 388.0F);
            ((RelativeLayout.LayoutParams)this.gy.getLayoutParams()).bottomMargin = aqcx.dip2px(this, 388.0F);
          }
        }
      }
    }
  }
  
  private boolean Ps()
  {
    return (this.aVN) && (this.uin.equals(this.app.getCurrentAccountUin()));
  }
  
  private boolean Pt()
  {
    aere localaere = aerf.c();
    if (localaere == null) {
      return Ps();
    }
    return (localaere.bVV) && (Ps());
  }
  
  private boolean a(c paramc)
  {
    boolean bool2 = false;
    if (paramc != null)
    {
      paramc.aVS = false;
      paramc.hasText = false;
    }
    Object localObject1;
    if ((this.aA instanceof ColorClearableEditText))
    {
      localObject1 = (ColorClearableEditText)this.aA;
      ((ColorClearableEditText)localObject1).ehP();
      localObject1 = ((ColorClearableEditText)localObject1).ee();
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {}
    }
    try
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      bool2 = false;
      bool1 = false;
      ColorClearableEditText.a locala;
      int i;
      boolean bool3;
      boolean bool4;
      label173:
      if (paramc == null) {
        break label244;
      }
    }
    finally
    {
      try
      {
        if (((Iterator)localObject1).hasNext())
        {
          locala = (ColorClearableEditText.a)((Iterator)localObject1).next();
          i = locala.type;
          if (i == 1)
          {
            bool3 = true;
            bool4 = bool1;
          }
          do
          {
            for (;;)
            {
              bool2 = bool3;
              bool1 = bool4;
              if (!bool4) {
                break;
              }
              bool2 = bool3;
              bool1 = bool4;
              if (!bool3) {
                break;
              }
              if (paramc != null)
              {
                paramc.aVS = bool4;
                paramc.hasText = bool3;
              }
              return true;
              if (locala.type != 3) {
                break label173;
              }
              bool4 = true;
              bool3 = bool2;
            }
            i = locala.type;
            bool3 = bool2;
            bool4 = bool1;
          } while (i != 2);
          if (paramc != null)
          {
            paramc.aVS = bool1;
            paramc.hasText = bool2;
          }
          return true;
        }
        if (paramc != null)
        {
          paramc.aVS = bool1;
          paramc.hasText = bool2;
        }
        return false;
      }
      finally
      {
        boolean bool1;
        break label229;
      }
      localObject2 = finally;
      bool1 = false;
    }
    label229:
    paramc.aVS = bool1;
    paramc.hasText = bool2;
    label244:
    throw localObject2;
  }
  
  private void bND()
  {
    SpannableString localSpannableString = new aofe(this.aA.getText().toString(), 32).k();
    aqpm.a(this.app, this.aA, localSpannableString);
  }
  
  private int vs()
  {
    if (a(new c(null)))
    {
      localObject1 = ((ColorClearableEditText)this.aA).ee();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      if (localIterator.hasNext())
      {
        localObject1 = (ColorClearableEditText.a)localIterator.next();
        Oidb_0x8fc.RichCardNameElem localRichCardNameElem = new Oidb_0x8fc.RichCardNameElem();
        switch (((ColorClearableEditText.a)localObject1).type)
        {
        }
        for (;;)
        {
          localArrayList.add(localRichCardNameElem);
          break;
          localRichCardNameElem.bytes_text.set(ByteStringMicro.copyFrom(((ColorClearableEditText.a)localObject1).text.getBytes()));
          continue;
          Object localObject2 = ((ColorClearableEditText.a)localObject1).text;
          localObject1 = localObject2;
          if (((String)localObject2).substring(0, 1).equals("<")) {
            localObject1 = ((String)localObject2).substring(1);
          }
          localObject2 = localObject1;
          if (((String)localObject1).substring(((String)localObject1).length() - 1).equals(">")) {
            localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
          }
          localRichCardNameElem.bytes_ctrl.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
        }
      }
      localObject1 = new Oidb_0x8fc.CommCardNameBuf();
      ((Oidb_0x8fc.CommCardNameBuf)localObject1).rpt_rich_card_name.set(localArrayList);
      return ((Oidb_0x8fc.CommCardNameBuf)localObject1).toByteArray().length;
    }
    Object localObject1 = this.aA.getText();
    if (localObject1 == null) {}
    int i;
    for (localObject1 = "";; localObject1 = localObject1.toString())
    {
      i = ((String)localObject1).trim().length();
      try
      {
        int j = ((String)localObject1).trim().getBytes("utf-8").length;
        return j;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        if (!QLog.isColorLevel()) {
          return i;
        }
        QLog.d("ColorNick", 2, "UnsupportedEncodingException:" + localUnsupportedEncodingException.getMessage());
      }
    }
    return i;
  }
  
  private void xb(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, this.jdField_a_of_type_ArrayOfAqpk$a);
    localArrayList.addAll(this.pe);
    this.jdField_a_of_type_Aqpk.setData(localArrayList, paramBoolean);
    ((acff)this.app.getManager(51)).e(this.uin);
  }
  
  public void IM()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((this.aA != null) && (this.Ny))
    {
      if (QLog.isColorLevel()) {
        QLog.i("EditInfoActivity", 2, String.format("showInputMethod()", new Object[0]));
      }
      localInputMethodManager.showSoftInput(this.aA, 2);
    }
  }
  
  public boolean Z(String paramString1, String paramString2)
  {
    if (this.mAction == 1)
    {
      if (TextUtils.isEmpty(paramString2))
      {
        if (TextUtils.isEmpty(paramString1))
        {
          QQToast.a(this, getString(2131694839), 0).show(getTitleBarHeight());
          return false;
        }
        QQToast.a(this, getString(2131694840), 0).show(getTitleBarHeight());
        return false;
      }
    }
    else if (this.mAction == 2)
    {
      if ((TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
      {
        QQToast.a(this, getString(2131694842), 0).show(getTitleBarHeight());
        return false;
      }
    }
    else if ((this.mAction == 5) && (!TextUtils.isEmpty(paramString2)) && (!SearchBaseActivity.Q.matcher(paramString2).matches()))
    {
      QQToast.a(this, acfp.m(2131706611), 0).show(getTitleBarHeight());
      return false;
    }
    return true;
  }
  
  public void a(afmi paramafmi)
  {
    if ((this.aA instanceof ColorClearableEditText))
    {
      this.aVR = true;
      if ((paramafmi instanceof afqr))
      {
        paramafmi = (afqr)paramafmi;
        if (paramafmi.code != -1) {}
      }
      while (!(paramafmi instanceof afqh))
      {
        return;
        int i = this.aA.getSelectionStart();
        int j = this.aA.getSelectionEnd();
        this.aA.getEditableText().replace(i, j, aofy.fy(paramafmi.code));
        this.aA.requestFocus();
        return;
      }
      aqpm.a((afqh)paramafmi, this.app, this.aA);
      return;
    }
    paramafmi.a(this.app, this, this.aA, null);
  }
  
  public void a(afmi paramafmi1, afmi paramafmi2, Drawable paramDrawable) {}
  
  public void a(aqpk.a parama)
  {
    ColorClearableEditText localColorClearableEditText;
    String str;
    int j;
    int i;
    if ((this.aA instanceof ColorClearableEditText))
    {
      this.aVR = true;
      localColorClearableEditText = (ColorClearableEditText)this.aA;
      str = aqpm.a(parama);
      aqqa[] arrayOfaqqa = (aqqa[])this.aA.getEditableText().getSpans(0, this.aA.getEditableText().length(), aqqa.class);
      if ((arrayOfaqqa == null) || (arrayOfaqqa.length <= 0)) {
        break label274;
      }
      j = this.aA.getEditableText().getSpanStart(arrayOfaqqa[0]);
      i = this.aA.getEditableText().getSpanEnd(arrayOfaqqa[0]);
      this.aA.getEditableText().removeSpan(arrayOfaqqa[0]);
    }
    for (;;)
    {
      this.aA.getEditableText().replace(j, i, str);
      switch (parama.type)
      {
      }
      do
      {
        return;
        if (parama.value != 0) {
          localColorClearableEditText.setTextColor(parama.value);
        }
        for (;;)
        {
          localColorClearableEditText.setSpecialColor(0, null, null, 0, null);
          return;
          localColorClearableEditText.setTextColor(getResources().getColor(2131167398));
        }
        localColorClearableEditText.setTextColor(getResources().getColor(2131167398));
        parama = aqpm.a(this.app).a(parama.value);
      } while (parama == null);
      localColorClearableEditText.setSpecialColor(parama.type, parama.colors, parama.positions, parama.orientation, parama.gB);
      return;
      label274:
      i = 0;
      j = 0;
    }
  }
  
  public boolean a(afmi paramafmi)
  {
    return false;
  }
  
  public void aq(boolean paramBoolean, int paramInt)
  {
    this.aVQ = paramBoolean;
    if (paramBoolean)
    {
      this.aA.setCursorVisible(true);
      this.bGN = 0;
      if (this.gz != null) {
        this.gz.setVisibility(8);
      }
      return;
    }
    if (this.bGL > 0)
    {
      AF(this.bGL);
      return;
    }
    this.gy.setVisibility(8);
    this.aA.setCursorVisible(false);
    this.gC.setVisibility(8);
  }
  
  public void b(afmi paramafmi) {}
  
  protected void b(EditText paramEditText)
  {
    this.Da = ((TextView)super.findViewById(2131366270));
    this.Da.setText(this.aMT);
    paramEditText.addTextChangedListener(new uwf(this, paramEditText));
  }
  
  public void bFw()
  {
    this.aA.setTextColor(getResources().getColor(2131167398));
    if ((this.aA instanceof ColorClearableEditText)) {
      ((ColorClearableEditText)this.aA).setSpecialColor(0, null, null, 0, null);
    }
    this.jdField_a_of_type_Aqpk.XI(-1);
    this.jdField_a_of_type_Aqpk.a.setSelect(-1);
  }
  
  public void bL(Intent paramIntent) {}
  
  protected void bNA()
  {
    this.aA = ((EditText)super.findViewById(2131366268));
    this.cR = ((ViewGroup)super.findViewById(2131377546));
    if (!TextUtils.isEmpty(this.mTitle)) {
      this.aA.setContentDescription(this.mTitle);
    }
    if (!TextUtils.isEmpty(this.aMU)) {
      this.aA.setHint(this.aMU);
    }
    if ((this.AH != null) && (this.AH.length() > 0)) {
      if (Pt()) {
        this.aA.setText(this.AH);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        if (this.bGJ == 0) {
          i = this.aA.getText().toString().getBytes("utf-8").length;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        i = 0;
      }
      try
      {
        this.aMT = ("" + (this.bGH - i));
        if (this.mFromFlag == 3) {
          break label450;
        }
        if ((!this.aVL) || (i > this.bGH)) {
          break label427;
        }
        this.rightViewText.setEnabled(true);
        b(this.aA);
        if (this.aVK) {
          this.jdField_b_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)super.findViewById(2131366269));
        }
        if (Pt())
        {
          this.aA.setTextColor(getResources().getColor(2131167398));
          bND();
        }
        if (!this.Ny)
        {
          this.Da.setVisibility(4);
          this.aA.clearFocus();
          this.aA.setFocusable(false);
          this.aA.setFocusableInTouchMode(false);
          this.aA.setOnLongClickListener(new uwd(this));
          this.aA.setLongClickable(false);
          this.aA.setTextIsSelectable(false);
          this.aA.setCustomSelectionActionModeCallback(new uwe(this));
        }
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        label389:
        label427:
        label450:
        break label389;
      }
      if (this.aVN)
      {
        this.aA.setText(aqpm.pQ(this.AH));
      }
      else
      {
        this.aA.setText(this.AH);
        continue;
        i = this.aA.getText().toString().length();
        continue;
        localUnsupportedEncodingException1.printStackTrace();
        continue;
        this.aMT = ("" + this.bGH);
        i = 0;
        continue;
        if ((i == 0) || (i > this.bGH))
        {
          this.rightViewText.setEnabled(false);
          continue;
          this.rightViewText.setEnabled(true);
        }
      }
    }
  }
  
  void bNB()
  {
    this.fX = ((LinearLayout)super.findViewById(2131366344));
    this.pR = ((ImageView)findViewById(2131379058));
    this.pR.setVisibility(0);
    this.pR.setOnClickListener(new uwg(this));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel = new SystemAndEmojiUniversalPanel.a(this).a(true).a(this).a(this.aA).a();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel.setVisibility(0);
    this.fX.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel);
    this.aA.setOnClickListener(new uvp(this));
  }
  
  public void bNC() {}
  
  protected void bNx()
  {
    super.setContentView(2131559277);
    bNA();
    Object localObject = findViewById(2131370461);
    View localView = findViewById(2131370462);
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId")))
    {
      ((View)localObject).setVisibility(8);
      localView.setVisibility(8);
    }
    if (Ps()) {
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "group_nickname", "uv", "", 1, 0, 0, "", "", "");
    }
    if (Pt())
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView = ((SoftInputDetectView)super.findViewById(2131369291));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setOnImStateChangedListener(this);
      this.aA.setEditableFactory(aofh.a);
      this.aA.setOnClickListener(this);
      this.gz = ((RelativeLayout)super.findViewById(2131364900));
      this.t = ((RecyclerView)super.findViewById(2131364885));
      this.mLayoutManager = new GridLayoutManager(this, 3);
      this.t.setLayoutManager(this.mLayoutManager);
      this.jdField_a_of_type_Aqpk = new aqpk(this, this);
      this.t.setAdapter(this.jdField_a_of_type_Aqpk);
      this.t.addOnScrollListener(this.jdField_a_of_type_Aqpk$b);
      this.gy = ((RelativeLayout)super.findViewById(2131364882));
      this.gy.setVisibility(0);
      this.pT = ((ImageView)super.findViewById(2131364883));
      this.pT.setOnClickListener(this);
      this.gy.setVisibility(8);
      this.pS = ((ImageView)super.findViewById(2131364886));
      this.pS.setOnClickListener(this);
      this.gA = ((RelativeLayout)super.findViewById(2131364887));
      findViewById(2131364896).setVisibility(8);
      this.Db = ((TextView)super.findViewById(2131364899));
      this.Dc = ((TextView)super.findViewById(2131364897));
      this.Dc.setOnClickListener(this);
      this.gB = ((RelativeLayout)super.findViewById(2131364893));
      this.pU = ((ImageView)super.findViewById(2131364891));
      this.pU.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)super.findViewById(2131364894));
      this.Dd = ((TextView)super.findViewById(2131364892));
      this.Dd.setOnClickListener(this);
      this.gC = ((RelativeLayout)super.findViewById(2131364890));
      xb(false);
      AE(0);
      localObject = this.app.getPreferences().getString("color_nick_last_edit", "");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.gB.setVisibility(8);
        if (!this.app.getPreferences().getBoolean("color_nick_guide_tips", false)) {
          this.app.getPreferences().edit().putBoolean("color_nick_guide_tips", true).commit();
        }
        if ((this.aA instanceof ColorClearableEditText)) {
          ((ColorClearableEditText)this.aA).setTextClearedListener(this);
        }
        this.aA.setFilters(new InputFilter[] { new a() });
      }
    }
    while ((!this.aVN) || (!a(null))) {
      for (;;)
      {
        return;
        this.gB.setVisibility(0);
        localObject = new aofe((CharSequence)localObject, 16).k();
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText((CharSequence)localObject);
        aqpm.a(this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, (Spannable)localObject);
        xc(true);
      }
    }
    this.aA.setText("");
  }
  
  protected void bNy()
  {
    bNx();
    if ((this.aA instanceof ClearableEditText))
    {
      this.aA.setInputType(131072);
      ((ClearableEditText)this.aA).setCanMultiLine(true);
      this.aA.setSingleLine(false);
      uwb localuwb = new uwb(this);
      this.aA.setFilters(new InputFilter[] { localuwb });
    }
  }
  
  protected void bNz()
  {
    super.setContentView(2131559276);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout = ((InputMethodLinearLayout)super.findViewById(2131377546));
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.setOnSizeChangedListenner(this);
    bNA();
    if (!this.mIsFullScreen)
    {
      this.aA.getLayoutParams().height = ((int)aqho.convertDpToPixel(this, 149.0F));
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.findViewById(2131366253).getLayoutParams();
      localLayoutParams.height = ((int)aqho.convertDpToPixel(this, 151.0F));
      localLayoutParams.weight = 0.0F;
    }
    this.aA.setEditableFactory(new uwc(this));
    if (this.aVM) {
      bNB();
    }
  }
  
  public void bsq() {}
  
  public void delete()
  {
    aofy.g(this.aA);
  }
  
  public void doAction(String paramString)
  {
    Object localObject;
    switch (this.mAction)
    {
    default: 
      localObject = new Intent();
      ((Intent)localObject).putExtra("type", this.mType);
      ((Intent)localObject).putExtra("subtype", this.bGG);
      ((Intent)localObject).putExtra("result", paramString);
      bL((Intent)localObject);
      setResult(-1, (Intent)localObject);
      e(this);
    case 1: 
      do
      {
        return;
        if (!aqiw.isNetSupport(this.app.getApplication().getApplicationContext()))
        {
          QQToast.a(this, 1, 2131696272, 0).show(getTitleBarHeight());
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EditInfoActivity", 2, String.format("edit self nick, uin: %s, result: %s", new Object[] { this.uin, paramString }));
        }
      } while ((TextUtils.isEmpty(paramString.trim())) || (!this.uin.equals(this.app.getCurrentAccountUin())));
      xa(true);
      localObject = new Bundle();
      ((Bundle)localObject).putString("nick", paramString.trim());
      ((CardHandler)this.app.getBusinessHandler(2)).cg((Bundle)localObject);
      this.aVP = true;
      return;
    }
    if (!aqiw.isNetSupport(this.app.getApplication().getApplicationContext()))
    {
      QQToast.a(this, 1, 2131696272, 0).show(getTitleBarHeight());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditInfoActivity", 2, String.format("edit friend remark, uin: %s, result: %s", new Object[] { this.uin, paramString }));
    }
    xa(true);
    ((FriendListHandler)this.app.getBusinessHandler(1)).C(this.uin, paramString, false);
    this.aVP = true;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    initData();
    initView();
    setContentBackgroundResource(2130838900);
    this.mHandler.postDelayed(new EditInfoActivity.1(this), 500L);
    if (this.aVN)
    {
      addObserver(this.jdField_a_of_type_Acnd);
      addObserver(this.c);
    }
    if (this.mAction == 1) {
      addObserver(this.jdField_a_of_type_Accn);
    }
    for (;;)
    {
      if (!this.Ny) {
        getWindow().setSoftInputMode(3);
      }
      return true;
      if (this.mAction == 2) {
        addObserver(this.jdField_a_of_type_Acfd);
      }
    }
  }
  
  public void gR()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    View localView = getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  public void gq() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.d != null)
      {
        this.d.bZe = false;
        this.d.MC(0);
        continue;
        bND();
        continue;
        xc(false);
        bNA();
        continue;
        aqpm.a(this.app).a.nb(this.pf);
        if (this.d != null) {
          this.d.a(this.app, 100001, this, getTitleBarHeight(), null, null, false, aqpm.a(this.app).a);
        }
      }
    }
  }
  
  public boolean hi(String paramString)
  {
    boolean bool = false;
    if (paramString.length() > 20) {
      return true;
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      int k = paramString.charAt(i);
      if ((k < 48) || (k > 57)) {
        bool = true;
      }
      i += 1;
    }
    return bool;
  }
  
  protected void initData()
  {
    Object localObject1 = getIntent();
    Object localObject2 = ((Intent)localObject1).getStringExtra("options");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        this.mTitle = ((JSONObject)localObject2).optString("title");
        this.AH = ((JSONObject)localObject2).optString("defaultText");
        this.mTroopUin = ((JSONObject)localObject2).optString("gc");
        this.uin = ((JSONObject)localObject2).optString("uin");
        this.bGH = ((JSONObject)localObject2).optInt("maxLength");
        this.mFromFlag = ((JSONObject)localObject2).optInt("src");
        this.aMV = acfp.m(2131705409);
        this.mRightBtnText = acfp.m(2131705406);
        this.aVN = true;
        this.bGK = 0;
        this.mType = ((Intent)localObject1).getIntExtra("edit_type", 0);
        this.bGG = ((Intent)localObject1).getIntExtra("edit_subtype", -1);
        this.aVL = ((Intent)localObject1).getBooleanExtra("canPostNull", true);
        this.aVM = ((Intent)localObject1).getBooleanExtra("support_emotion", false);
        this.mIsFullScreen = ((Intent)localObject1).getBooleanExtra("full_screen", false);
        this.aMU = ((Intent)localObject1).getStringExtra("default_hint");
        this.bGI = ((Intent)localObject1).getIntExtra("send_type", 0);
        this.mAction = ((Intent)localObject1).getIntExtra("edit_action", 0);
        this.mRightBtnText = ((Intent)localObject1).getStringExtra("right_btn");
        this.bGJ = ((Intent)localObject1).getIntExtra("count_type", 0);
        this.aMV = ((Intent)localObject1).getStringExtra("left_btn");
        this.aMW = ((Intent)localObject1).getStringExtra("link_text");
        this.Ny = ((Intent)localObject1).getBooleanExtra("edit_mode", true);
        this.aVJ = ((Intent)localObject1).getBooleanExtra("auto_remark", false);
        if ((this.aVJ) && (this.app != null) && (this.app.getCurrentAccountUin() != null) && (this.uin != null) && (!this.app.getCurrentAccountUin().equals(this.uin)) && (TextUtils.isEmpty(this.AH)))
        {
          localObject1 = (acms)this.app.getBusinessHandler(20);
          if (localObject1 != null) {
            ((acms)localObject1).Fn(this.uin);
          }
          this.aVK = true;
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(".troop.memberCard", 2, "EditInfoActivity.initData optionArgs parse error.", localJSONException);
        continue;
      }
      this.mTitle = ((Intent)localObject1).getStringExtra("title");
      this.AH = ((Intent)localObject1).getStringExtra("default_text");
      this.mTroopUin = ((Intent)localObject1).getStringExtra("troopUin");
      this.uin = ((Intent)localObject1).getStringExtra("uin");
      this.bGH = ((Intent)localObject1).getIntExtra("max_num", 0);
      this.mFromFlag = ((Intent)localObject1).getIntExtra("from", -1);
      this.aVN = ((Intent)localObject1).getBooleanExtra("isTroopNick", false);
      this.aVO = ((Intent)localObject1).getBooleanExtra("isTroopName", false);
      this.bGK = ((Intent)localObject1).getIntExtra("max_limit_mode", 0);
    }
  }
  
  void initView()
  {
    switch (this.mType)
    {
    }
    for (;;)
    {
      int i = this.aA.getText().length();
      Selection.setSelection(this.aA.getEditableText(), i);
      setTitle(this.mTitle);
      setRightButton(2131721066, new uvz(this));
      if (this.mRightBtnText != null)
      {
        this.rightViewText.setText(this.mRightBtnText);
        this.rightViewText.setContentDescription(getString(2131699992, new Object[] { this.mRightBtnText }));
      }
      if (this.aMV != null)
      {
        this.leftView.setText(this.aMV);
        this.leftView.setContentDescription(getString(2131699992, new Object[] { this.aMV }));
      }
      if (!this.Ny) {
        this.rightViewText.setVisibility(8);
      }
      if ((this.aVN) && (!this.Ny)) {
        this.aA.setOnClickListener(this);
      }
      if (this.aVO) {
        this.aA.setOnClickListener(this);
      }
      if (this.aMW != null)
      {
        TextView localTextView = (TextView)findViewById(2131379505);
        if (localTextView != null)
        {
          localTextView.setVisibility(0);
          localTextView.setText(this.aMW);
          localTextView.setOnClickListener(new uwa(this));
        }
      }
      if (this.mFromFlag == 0) {}
      return;
      bNx();
      continue;
      bNz();
      continue;
      bNy();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "group_nickname", "group_nickname_8", "", 1, 0, 0, "", "", "");
    gR();
    xc(false);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.gC.getVisibility() == 0) {
        this.gC.setVisibility(8);
      }
      Object localObject = "1";
      if (this.bGN == 2) {
        localObject = "2";
      }
      if (this.aVQ)
      {
        this.bGL = 2;
        gR();
      }
      for (;;)
      {
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "group_nickname", "group_nickname_6", "", 1, 0, 0, "", (String)localObject, "");
        break;
        AF(2);
      }
      if (this.gC.getVisibility() == 0) {
        this.gC.setVisibility(8);
      }
      localObject = "1";
      if (this.bGN == 1) {
        localObject = "2";
      }
      if (this.aVQ)
      {
        this.bGL = 1;
        gR();
      }
      for (;;)
      {
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "group_nickname", "group_nickname_5", "", 1, 0, 0, "", (String)localObject, "");
        break;
        AF(1);
      }
      aqrf.a(this, "mvip.g.a.qnc_kt", "CJCLUBT", -1, false, true);
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "group_nickname", "group_nickname_3", "", 1, 0, 0, "", "", "");
      continue;
      this.gB.setVisibility(8);
      continue;
      localObject = new aofe(this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getText().toString(), 32).k();
      this.aA.setText((CharSequence)localObject);
      aqpm.a(this.app, this.aA, (Spannable)localObject);
      this.gB.setVisibility(8);
      continue;
      if ((this.Ny) || (!this.aVO)) {
        continue;
      }
      if (!TextUtils.isEmpty(this.mTroopUin)) {
        i = 1;
      }
      if (i != 0) {}
      try
      {
        for (localObject = String.format(getString(2131721459), new Object[] { this.AH, this.mTroopUin }); !TextUtils.isEmpty((CharSequence)localObject); localObject = String.format(getString(2131721460), new Object[] { this.AH }))
        {
          if (Build.VERSION.SDK_INT >= 11) {
            break label499;
          }
          ((android.text.ClipboardManager)getSystemService("clipboard")).setText((CharSequence)localObject);
          QQToast.a(this, 2131701824, 1).show();
          break;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          String str = "";
          continue;
          label499:
          android.content.ClipboardManager localClipboardManager = (android.content.ClipboardManager)getSystemService("clipboard");
          alkw.a(localClipboardManager, str);
          localClipboardManager.setText(str);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.aVN)
    {
      removeObserver(this.jdField_a_of_type_Acnd);
      removeObserver(this.c);
    }
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiUniversalPanel.onDestory();
    }
    if (this.d != null) {
      this.d.onDestory();
    }
    this.app.removeObserver(this.jdField_b_of_type_Aclh);
    aqpm.a(this.app).dK = null;
    try
    {
      this.aA.setFocusable(false);
      this.aA.setFocusableInTouchMode(false);
      this.aA.setVisibility(8);
      this.cR.removeView(this.aA);
      removeObserver(this.jdField_a_of_type_Accn);
      removeObserver(this.jdField_a_of_type_Acfd);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EditInfoActivity", 2, "onDestroy" + localException.toString());
        }
      }
    }
  }
  
  public void onPause()
  {
    gR();
    super.onPause();
  }
  
  public void onResume()
  {
    if (this.Ny) {
      IM();
    }
    for (;;)
    {
      super.onResume();
      return;
      gR();
    }
  }
  
  public void send() {}
  
  public void setting() {}
  
  public void uV(boolean paramBoolean)
  {
    this.aVI = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout == null) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while ((this.fX == null) || (this.pR == null));
      this.fX.setVisibility(8);
      this.pR.setImageResource(2130848765);
      this.pR.setContentDescription(acfp.m(2131705405));
      return;
    } while ((!this.aVD) || (this.fX == null));
    this.fX.setVisibility(0);
  }
  
  public void xa(boolean paramBoolean)
  {
    if (this.centerView == null) {
      this.centerView = ((TextView)findViewById(2131369627));
    }
    if (paramBoolean)
    {
      this.rightViewText.setEnabled(false);
      if ((this.mTitle != null) && (this.dA == null))
      {
        this.dA = getResources().getDrawable(2130839651);
        this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.dA, null, null, null);
        ((Animatable)this.dA).start();
      }
    }
    do
    {
      return;
      this.rightViewText.setEnabled(true);
    } while ((this.mTitle == null) || (this.dA == null));
    ((Animatable)this.dA).stop();
    this.dA = null;
    this.centerView.setCompoundDrawables(null, null, null, null);
  }
  
  public void xc(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.app.getPreferences().edit().putString("color_nick_last_edit", "").commit();
    }
    if ((!paramBoolean) && (a(null)) && (this.aVR) && (!this.aA.getText().toString().equals(this.AH))) {
      this.app.getPreferences().edit().putString("color_nick_last_edit", this.aA.getText().toString()).commit();
    }
  }
  
  public class a
    implements InputFilter
  {
    Pattern pattern = Pattern.compile("[🀀-🏿]|[🐀-🟿]|[☀-⟿]", 66);
    
    public a() {}
    
    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      if (this.pattern.matcher(paramCharSequence).find()) {
        return "";
      }
      return null;
    }
  }
  
  public class b
    extends LinkMovementMethod
  {
    private EditInfoActivity.d a;
    
    private b() {}
    
    private EditInfoActivity.d a(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      int k = paramTextView.getTotalPaddingLeft();
      int m = paramTextView.getTotalPaddingTop();
      int n = paramTextView.getScrollX();
      int i1 = paramTextView.getScrollY();
      paramTextView = paramTextView.getLayout();
      i = paramTextView.getOffsetForHorizontal(paramTextView.getLineForVertical(j - m + i1), i - k + n);
      paramTextView = (EditInfoActivity.d[])paramSpannable.getSpans(i, i, EditInfoActivity.d.class);
      if (paramTextView.length > 0) {
        return paramTextView[0];
      }
      return null;
    }
    
    public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.a = a(paramTextView, paramSpannable, paramMotionEvent);
        if (this.a != null)
        {
          this.a.setPressed(true);
          Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(this.a), paramSpannable.getSpanEnd(this.a));
        }
      }
      do
      {
        return true;
        if (paramMotionEvent.getAction() != 2) {
          break;
        }
        paramTextView = a(paramTextView, paramSpannable, paramMotionEvent);
      } while ((this.a == null) || (paramTextView == this.a));
      this.a.setPressed(false);
      this.a = null;
      Selection.removeSelection(paramSpannable);
      return true;
      if (this.a != null)
      {
        this.a.setPressed(false);
        super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
      }
      this.a = null;
      Selection.removeSelection(paramSpannable);
      return true;
    }
  }
  
  public static class c
  {
    public boolean aVS;
    public boolean hasText;
  }
  
  public abstract class d
    extends ClickableSpan
  {
    private boolean mIsPressed;
    private int mNormalTextColor;
    private int mPressedTextColor;
    
    public d(int paramInt1, int paramInt2)
    {
      this.mNormalTextColor = paramInt1;
      this.mPressedTextColor = paramInt2;
    }
    
    public void setPressed(boolean paramBoolean)
    {
      this.mIsPressed = paramBoolean;
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      super.updateDrawState(paramTextPaint);
      if (this.mIsPressed) {}
      for (int i = this.mPressedTextColor;; i = this.mNormalTextColor)
      {
        paramTextPaint.setColor(i);
        paramTextPaint.setUnderlineText(false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity
 * JD-Core Version:    0.7.0.1
 */