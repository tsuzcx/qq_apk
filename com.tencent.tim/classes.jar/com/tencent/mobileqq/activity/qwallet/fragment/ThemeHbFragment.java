package com.tencent.mobileqq.activity.qwallet.fragment;

import aaao;
import aaay;
import aabc;
import aabd;
import aabe;
import aadw;
import aagc;
import acfp;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqds;
import avor;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.widget.RollNumberView;
import com.tencent.mobileqq.activity.qwallet.widget.RollNumberView.OnRollListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.io.File;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zxd;
import zxt;

public class ThemeHbFragment
  extends BaseHbFragment
  implements aaao, View.OnClickListener, Animation.AnimationListener, RollNumberView.OnRollListener
{
  private JSONArray A;
  public JSONArray B;
  private JSONArray C;
  private TextView NH;
  private TextView NI;
  private TextView NJ;
  private a jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentThemeHbFragment$a = new a();
  private zxd jdField_a_of_type_Zxd;
  private Animation ax;
  private aadw jdField_b_of_type_Aadw;
  private RollNumberView jdField_b_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView;
  private String bbG;
  private String bci;
  public String bcj = "1";
  private String bck = "";
  private String bcl;
  private String bcm = "1";
  private boolean buT;
  private int cfV;
  private int cfW;
  private int cfX;
  private Button eX;
  private Drawable ej;
  private LinearLayout hT;
  private RelativeLayout iI;
  private int[] je;
  private long mlastInvalidatetime;
  private View rootView;
  private ImageView vQ;
  private ImageView vR;
  private JSONArray y;
  private View zl;
  private View zm;
  private View zn;
  
  private void Ab(String paramString)
  {
    zS(paramString);
    if ((64 == this.channel) || (this.channel == 64) || (this.channel == 16384))
    {
      paramString = a(-11001, "", "");
      this.mActivity.setResult(-1, paramString);
    }
    if (isAdded())
    {
      this.mActivity.csV();
      this.mActivity.finish();
      this.mActivity.overridePendingTransition(0, 0);
    }
  }
  
  private void bM(Bundle paramBundle)
  {
    this.NH.setVisibility(0);
    this.vQ.setVisibility(0);
    this.bbG = paramBundle.getString("group_count");
    this.buT = paramBundle.getBoolean("isGroupThemeHb");
    try
    {
      FN(Integer.valueOf(paramBundle.getString("theme_type")).intValue());
      if ((this.buT) && (this.NJ != null))
      {
        this.NJ.setText(String.format(getString(2131698992), new Object[] { this.bcj }));
        this.NJ.setVisibility(0);
      }
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  private void bN(Bundle paramBundle)
  {
    this.NH.setVisibility(4);
    this.vQ.setVisibility(8);
    paramBundle = aqds.a().d(this.mActivity);
    if (paramBundle == null) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject("{\"hb_face_desc\":\" 让对方做表情领红包\",\"hb_face_imgurl\":\"\",\"hb_face_money_array\":[\"0.18\",\"1.18\",\"2.18\",\"6.18\",\"8.18\",\"18.00\"]}");
        paramBundle = localJSONObject;
        if (paramBundle != null) {
          break;
        }
        this.mActivity.m(acfp.m(2131715310));
        this.mActivity.finish();
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    this.NI.setText(paramBundle.optString("hb_face_desc"));
    Object localObject = paramBundle.optString("hb_face_imgurl");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = zxt.a().a(this.mQApp, (String)localObject);
      this.vR.setImageBitmap((Bitmap)localObject);
    }
    this.C = paramBundle.optJSONArray("hb_face_money_array");
    ctt();
  }
  
  private int c(double paramDouble)
  {
    if (paramDouble >= 0.0D) {
      try
      {
        if ((64 == this.channel) && (!TextUtils.isEmpty(this.bbG)))
        {
          this.jdField_b_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.reset(paramDouble);
          String str = avor.aB(this.bcl, this.bbG);
          this.NH.setText(this.bck);
          this.eX.setText(String.format(getString(2131698993), new Object[] { this.bbG, str }));
          this.bcl = str;
          return 0;
        }
        this.jdField_b_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.reset(paramDouble);
        return 0;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return -1;
  }
  
  private void cts()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentThemeHbFragment$a.postDelayed(new ThemeHbFragment.1(this), 10L);
  }
  
  private void ctt()
  {
    int j = new Random(System.currentTimeMillis()).nextInt(this.C.length());
    int i = j;
    if (j == this.cfX) {
      i = j + 1;
    }
    this.cfX = i;
    if (this.cfX >= this.C.length()) {}
    for (i = 0;; i = this.cfX)
    {
      this.cfX = i;
      try
      {
        String str = this.C.optString(this.cfX);
        this.bcl = str;
        float f = Float.parseFloat(str);
        this.jdField_b_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.reset(f);
        this.jdField_b_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.roll();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void ctu()
  {
    if ((TextUtils.isEmpty(this.bci)) || (!isAdded()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeHbFragment", 2, "theme config bak img error...");
      }
      return;
    }
    this.ej = zxt.a().a(this.mQApp, this.bci);
    if (QLog.isColorLevel()) {
      QLog.i("ThemeHbFragment", 2, "setImageBgProcess mHbDrawable = " + this.ej);
    }
    if (this.ej != null)
    {
      this.vQ.setBackgroundDrawable(null);
      this.vQ.setImageDrawable(this.ej);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ThemeHbFragment", 2, "setImageBgProcess not exist, start download...");
    }
    zxt.a().a(this.mQApp, this.bci, new aabc(this));
  }
  
  private void ctv()
  {
    if ((TextUtils.isEmpty(this.bci)) || (!isAdded())) {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeHbFragment", 2, "setAnimFrameBgProcess theme config bak img error...");
      }
    }
    String str;
    do
    {
      return;
      str = zxt.a().a(this.mQApp, this.bci);
      if (QLog.isColorLevel()) {
        QLog.i("ThemeHbFragment", 2, "setAnimFrameBgProcess zipName = " + str);
      }
    } while (iI(str));
    if (QLog.isColorLevel()) {
      QLog.i("ThemeHbFragment", 2, "setAnimFrameBgProcess not exist, start download...");
    }
    zxt.a().a(this.mQApp, this.bci, ".zip", new aabd(this));
  }
  
  private void ctw()
  {
    long l = System.currentTimeMillis();
    if (l - this.mlastInvalidatetime < 2000L) {
      return;
    }
    this.mlastInvalidatetime = l;
    Object localObject2 = "";
    String str;
    for (Object localObject1 = localObject2;; str = "theme.pack.go") {
      try
      {
        if (this.A != null)
        {
          localObject1 = localObject2;
          if (this.cfV < this.A.length())
          {
            localObject1 = localObject2;
            if (this.cfV >= 0) {
              localObject1 = this.A.optString(this.cfV);
            }
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = getResources().getString(2131699043);
        }
        localObject1 = this.mActivity.Y();
        ((Map)localObject1).put("total_num", this.bcj);
        ((Map)localObject1).put("total_amount", avor.hX(this.bcl));
        ((Map)localObject1).put("wishing", localObject2);
        ((Map)localObject1).put("resource_type", this.jdField_b_of_type_Aadw.resource_type + "");
        ((Map)localObject1).put("channel", this.channel + "");
        ((Map)localObject1).put("type", this.jdField_b_of_type_Aadw.id + "");
        ((Map)localObject1).put("bus_type", this.bcm);
        if (this.buT)
        {
          ((Map)localObject1).put("groupid", this.mActivity.mGroupId);
          ((Map)localObject1).put("theme_type", this.mActivity.bbI);
        }
        this.mLogic.Z((Map)localObject1);
        if (this.channel == 16384)
        {
          localObject1 = "bqredpacket.order.send";
          zS((String)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
  
  private void ctx()
  {
    QLog.i("ThemeHbFragment", 2, "clickFaceAction...");
    this.mActivity.zX(this.bcl);
  }
  
  private void cty()
  {
    Object localObject;
    if (this.buT) {
      if ((this.B != null) && (this.y != null)) {
        localObject = new Random();
      }
    }
    for (;;)
    {
      int i;
      try
      {
        if (this.cfW <= 0) {
          break label444;
        }
        i = fK(((Random)localObject).nextInt(this.cfW));
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          this.bcj = this.B.optString(i, "1");
          localObject = this.y.optString(i, "0.1");
          this.bcl = avor.aB(this.bcj, (String)localObject);
          this.bck = this.A.optString(i, getString(2131698544));
          j = i;
          if (c(new BigDecimal((String)localObject).doubleValue()) == 0)
          {
            this.jdField_b_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.roll();
            this.NH.setText(this.bck);
            if (this.NJ != null) {
              this.NJ.setText(String.format(getString(2131698992), new Object[] { this.bcj }));
            }
            this.eX.setText(getString(2131699008) + " " + this.bcl + acfp.m(2131715311));
            j = i;
          }
          if ((this.je != null) && (this.je.length > j)) {
            this.je[j] = 1;
          }
          this.cfV = j;
          return;
        }
        catch (Exception localException3)
        {
          int j;
          break label272;
        }
        localException1 = localException1;
        i = 0;
      }
      label272:
      j = i;
      continue;
      if ((this.A != null) && (this.y != null))
      {
        i = this.A.length();
        if (i > 0)
        {
          j = this.y.length();
          if ((j > 0) && (j == i))
          {
            i = fK(new Random().nextInt(j));
            try
            {
              this.bcl = this.y.optString(i);
              double d = new BigDecimal(this.bcl).doubleValue();
              this.bck = this.A.optString(i);
              if (c(d) == 0) {
                this.jdField_b_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.roll();
              }
              if ((this.je != null) && (this.je.length > i)) {
                this.je[i] = 1;
              }
              this.cfV = i;
              return;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                localException2.printStackTrace();
              }
            }
            label444:
            i = 0;
          }
        }
      }
    }
  }
  
  private boolean iI(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists()) || (this.hT == null)) {
      return false;
    }
    int i = (int)this.mActivity.getResources().getDimension(2131298432);
    this.jdField_a_of_type_Zxd = new zxd(this.mActivity, this.hT, i, true, new aabe(this));
    this.jdField_a_of_type_Zxd.bi(paramString, true);
    return true;
  }
  
  private void initView()
  {
    int j = 0;
    if ((this.rootView == null) || (!isAdded())) {
      return;
    }
    ImageView localImageView = (ImageView)this.rootView.findViewById(2131364689);
    if (localImageView != null)
    {
      if (aagc.H(this.mActivity))
      {
        i = 8;
        localImageView.setVisibility(i);
        localImageView.setOnClickListener(this);
      }
    }
    else
    {
      localImageView = (ImageView)this.rootView.findViewById(2131364687);
      if (localImageView != null) {
        if (!aagc.H(this.mActivity)) {
          break label321;
        }
      }
    }
    label321:
    for (int i = j;; i = 8)
    {
      localImageView.setVisibility(i);
      localImageView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView = ((RollNumberView)this.rootView.findViewById(2131379608));
      this.ax = AnimationUtils.loadAnimation(this.mActivity, 2130772269);
      this.ax.setAnimationListener(this);
      this.NH = ((TextView)this.rootView.findViewById(2131368341));
      this.vQ = ((ImageView)this.rootView.findViewById(2131368351));
      this.eX = ((Button)this.rootView.findViewById(2131378006));
      this.iI = ((RelativeLayout)this.rootView.findViewById(2131379610));
      this.hT = ((LinearLayout)this.rootView.findViewById(2131362717));
      this.zn = this.rootView.findViewById(2131368353);
      this.zm = this.rootView.findViewById(2131374411);
      this.zl = this.rootView.findViewById(2131379609);
      this.vR = ((ImageView)this.rootView.findViewById(2131368330));
      this.NI = ((TextView)this.rootView.findViewById(2131368332));
      this.NJ = ((TextView)this.rootView.findViewById(2131368174));
      return;
      i = 0;
      break;
    }
  }
  
  private void kJ()
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.setLisener(this);
    this.eX.setOnClickListener(this);
    this.zn.setOnClickListener(this);
    this.zl.setOnClickListener(this);
    this.zl.setVisibility(0);
    if (64 == this.channel) {
      this.bcm = "1";
    }
    if (isAdded()) {
      ((InputMethodManager)this.mActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.iI.getWindowToken(), 0);
    }
  }
  
  private void zS(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.mActivity.zY(paramString);
    }
  }
  
  public void FN(int paramInt)
    throws Exception
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeHbFragment", 2, "parseThemeConfig themeId = " + paramInt);
    }
    this.jdField_b_of_type_Aadw = ((RedPacketManager)RedPacketManager.getInstance()).getThemeRedPkgConfById(paramInt);
    if (this.jdField_b_of_type_Aadw == null) {
      this.mActivity.m(getString(2131699127));
    }
    int i;
    label266:
    label337:
    label342:
    do
    {
      do
      {
        return;
        this.A = this.jdField_b_of_type_Aadw.D;
        this.y = this.jdField_b_of_type_Aadw.C;
        this.bci = this.jdField_b_of_type_Aadw.bgUrl;
        if (this.buT)
        {
          this.A = this.jdField_b_of_type_Aadw.E;
          this.y = this.jdField_b_of_type_Aadw.F;
          this.B = this.jdField_b_of_type_Aadw.B;
          if (this.B == null) {
            this.B = new JSONArray();
          }
        }
        if (this.y == null) {
          this.y = new JSONArray();
        }
        if (this.A == null) {
          this.A = new JSONArray();
        }
        if (1 != this.jdField_b_of_type_Aadw.resource_type) {
          break;
        }
        ctv();
        if (!this.buT) {
          break label342;
        }
      } while ((this.B == null) || (this.y == null));
      i = this.B.length();
      paramInt = this.y.length();
      int j = this.A.length();
      if (j > paramInt)
      {
        paramInt = j;
        this.cfW = paramInt;
        if (this.cfW <= i) {
          break label337;
        }
      }
      for (paramInt = this.cfW;; paramInt = i)
      {
        this.cfW = paramInt;
        this.je = new int[this.cfW];
        return;
        this.bci += ".png";
        ctu();
        break;
        break label266;
      }
      if (this.y == null)
      {
        QLog.i("ThemeHbFragment", 2, "mArrMoney error, null checked...");
        return;
      }
      i = this.y.length();
      paramInt = this.A.length();
      Object localObject = getString(2131698544);
      if (i > paramInt) {
        while (paramInt < i)
        {
          this.A.put(localObject);
          paramInt += 1;
        }
      }
      if (i < paramInt)
      {
        localObject = new JSONArray();
        paramInt = 0;
        while (paramInt < i)
        {
          ((JSONArray)localObject).put(this.A.get(paramInt));
          paramInt += 1;
        }
        this.A = ((JSONArray)localObject);
      }
    } while (i <= 0);
    this.je = new int[i];
  }
  
  public Intent a(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    if (paramInt == 0) {
      localIntent.putExtra("data", paramString2);
    }
    for (;;)
    {
      localIntent.putExtra("result", paramInt);
      return localIntent;
      localIntent.putExtra("retmsg", paramString1);
    }
  }
  
  public void complete()
  {
    if ((this.cfV >= 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentThemeHbFragment$a != null))
    {
      Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentThemeHbFragment$a.obtainMessage();
      localMessage.what = 100;
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentThemeHbFragment$a.sendMessage(localMessage);
    }
  }
  
  public void ctk()
  {
    this.mlastInvalidatetime = System.currentTimeMillis();
  }
  
  public int fK(int paramInt)
  {
    if ((this.je == null) || (this.je.length <= paramInt) || (paramInt < 0))
    {
      i = 0;
      return i;
    }
    int k = this.je.length;
    int i = 0;
    label33:
    int j;
    if (i < k)
    {
      j = (paramInt + i) % k;
      if (this.je[j] != 0) {}
    }
    for (;;)
    {
      if (i == k)
      {
        j = 0;
        for (;;)
        {
          i = paramInt;
          if (j >= k) {
            break;
          }
          this.je[j] = 0;
          j += 1;
        }
        i += 1;
        break label33;
      }
      return j;
      j = 0;
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    cty();
    this.zm.setVisibility(0);
    this.zn.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    QLog.i("ThemeHbFragment", 2, "onAnimationStart...");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131368353: 
    case 2131378006: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.channel == 16384)
        {
          zS("bqredpacket.order.randomamount");
          ctt();
        }
        else
        {
          zS("theme.pack.change");
          cty();
          continue;
          if (this.channel == 16384) {
            ctx();
          } else {
            ctw();
          }
        }
      }
    }
    if (this.jdField_a_of_type_Zxd != null) {
      this.jdField_a_of_type_Zxd.stop();
    }
    if (this.channel == 16384) {}
    for (String str = "bqredpacket.order.close";; str = "theme.pack.back")
    {
      Ab(str);
      break;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = getArguments();
    if (this.channel == 16384) {
      zS("bqredpacket.order.expose");
    }
    int i;
    if (this.channel == 16384)
    {
      i = 2131562111;
      this.rootView = paramLayoutInflater.inflate(i, null);
      initView();
      if (this.channel != 16384) {
        break label103;
      }
      bN(paramViewGroup);
    }
    for (;;)
    {
      cts();
      kJ();
      paramLayoutInflater = this.rootView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      i = 2131562117;
      break;
      label103:
      bM(paramViewGroup);
    }
  }
  
  public void onDestroyView()
  {
    this.ej = null;
    this.vQ = null;
    super.onDestroyView();
  }
  
  class a
    extends Handler
  {
    a() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        return;
      } while (TextUtils.isEmpty(ThemeHbFragment.a(ThemeHbFragment.this)));
      ThemeHbFragment.a(ThemeHbFragment.this).setText(ThemeHbFragment.a(ThemeHbFragment.this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment
 * JD-Core Version:    0.7.0.1
 */