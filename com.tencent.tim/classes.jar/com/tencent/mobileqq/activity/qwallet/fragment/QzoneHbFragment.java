package com.tencent.mobileqq.activity.qwallet.fragment;

import aaai;
import aaao;
import aaau;
import aaav;
import aaaw;
import aaax;
import aaay;
import aagi;
import acfp;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import aqdj;
import aqha;
import aqju;
import avor;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.widget.RollNumberView;
import com.tencent.mobileqq.activity.qwallet.widget.RollNumberView.OnRollListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Map;
import java.util.Random;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import zxt.a;

public class QzoneHbFragment
  extends BaseHbFragment
  implements aaao, View.OnClickListener, RollNumberView.OnRollListener
{
  private TextView NG;
  private a jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment$a = new a(this);
  private RollNumberView jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView;
  zxt.a jdField_a_of_type_Zxt$a = new aaaw(this);
  private EditText aZ;
  private Animation ax;
  private String bcb;
  private String bcd = "1.00";
  private String bce;
  private String bcf;
  private String bcg;
  private boolean buR;
  private boolean buS;
  private int cfT = 1;
  private View dK;
  private Button eV;
  private Button eW;
  private String feedsid;
  private long iu;
  private String mComment;
  protected TextWatcher mTextWatcher = new aaau(this);
  private String mUin;
  private ImageView qc;
  private SharedPreferences sp;
  private JSONArray y = new JSONArray();
  private View zj;
  private View zk;
  
  private boolean Wc()
  {
    this.cfT = ((aaai)this.mQApp.getManager(245)).a("grap_hb_verify", 1, new String[] { "videoRedMinValue" });
    return Integer.valueOf(avor.hX(this.bcb)).intValue() >= this.cfT;
  }
  
  private boolean Wd()
  {
    int i = this.aZ.getText().length();
    String str = this.aZ.getText().toString();
    if ((i == 0) || (str.startsWith(".")) || (str.endsWith("."))) {}
    for (;;)
    {
      return false;
      if ((!TextUtils.isEmpty(str)) && (str.indexOf('.') != 0)) {
        if ((str.indexOf('.') > 0) && (str.indexOf('.') < str.length() - 3))
        {
          str = getString(2131699015);
          if (str != null)
          {
            this.mActivity.k(str);
            return false;
          }
        }
        else
        {
          try
          {
            double d = Double.valueOf(str).doubleValue();
            if (d > 0.0D) {
              return true;
            }
          }
          catch (Exception localException) {}
        }
      }
    }
    return false;
  }
  
  public static void b(Handler paramHandler, EditText paramEditText)
  {
    if ((paramHandler != null) && (paramEditText != null)) {
      paramHandler.postDelayed(new QzoneHbFragment.8(paramEditText), 100L);
    }
  }
  
  private void cto()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((isAdded()) && (localFragmentActivity != null)) {
      this.zk.getViewTreeObserver().addOnGlobalLayoutListener(new aaax(this, localFragmentActivity));
    }
  }
  
  private void initParam()
  {
    this.sp = getActivity().getPreferences(0);
    try
    {
      this.y.put("1.00");
      Bundle localBundle = getArguments();
      if (localBundle != null)
      {
        this.bcf = localBundle.getString("recv_name");
        this.feedsid = localBundle.getString("feedsid");
        this.mUin = localBundle.getString("recv_uin");
        this.bcg = localBundle.getString("recv_type");
        if ((32768 == this.channel) && (!this.bcg.equals("1"))) {
          this.mUin = localBundle.getString("grab_uin_list");
        }
        this.bce = localBundle.getString("send_uin");
        if (!TextUtils.isEmpty(this.bcf))
        {
          if (this.bcf.length() > 8) {
            this.bcf = (this.bcf.substring(0, 7) + "...");
          }
          this.NG.setText(this.bcf);
        }
        this.bcb = "1.00";
        this.aZ.setText(this.bcb);
      }
      this.aZ.setEnabled(false);
      this.qc.setImageDrawable(aqdj.a(this.mQApp, 1, this.mUin));
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment$a.postDelayed(new QzoneHbFragment.2(this), 10L);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.setVisibility(8);
      this.aZ.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void kJ()
  {
    this.eV.setOnClickListener(this);
    this.eW.setOnClickListener(this);
    this.dK.setOnClickListener(this);
    this.zk.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView.setLisener(this);
    this.aZ.addTextChangedListener(this.mTextWatcher);
  }
  
  private String qi()
  {
    int k = 0;
    new JSONArray();
    Object localObject3 = "";
    Object localObject1 = localObject3;
    int m;
    Random localRandom;
    int i;
    if (this.y != null)
    {
      m = this.y.length();
      localObject1 = localObject3;
      if (m > 0)
      {
        localRandom = new Random();
        i = k;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = this.sp.getString("hb_key_rand_amount", "");
        i = k;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          i = k;
          localObject1 = new JSONArray((String)localObject1);
          i = k;
          if (((JSONArray)localObject1).length() == this.y.length())
          {
            localObject3 = localObject1;
            if (localObject1 == null)
            {
              i = k;
              localObject1 = new JSONArray();
              j = 0;
              localObject3 = localObject1;
              i = k;
              if (j < this.y.length())
              {
                i = k;
                ((JSONArray)localObject1).put(j, 0);
                j += 1;
                continue;
              }
            }
            i = k;
            int j = b((JSONArray)localObject3, localRandom.nextInt(m));
            i = j;
            ((JSONArray)localObject3).put(j, 1);
            i = j;
            localObject1 = this.sp.edit();
            i = j;
            ((SharedPreferences.Editor)localObject1).putString("hb_key_rand_amount", ((JSONArray)localObject3).toString());
            i = j;
            ((SharedPreferences.Editor)localObject1).commit();
            i = j;
          }
        }
        SharedPreferences.Editor localEditor;
        Object localObject2 = null;
      }
      catch (Exception localException1)
      {
        try
        {
          localObject1 = this.y.get(i).toString();
          return localObject1;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          return "";
        }
        localException1 = localException1;
        localException1.printStackTrace();
        localEditor = this.sp.edit();
        localEditor.remove("hb_key_rand_amount");
        localEditor.commit();
      }
    }
  }
  
  private void u(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.dK = paramView.findViewById(2131374375);
    this.qc = ((ImageView)paramView.findViewById(2131374404));
    this.NG = ((TextView)paramView.findViewById(2131374376));
    this.aZ = ((EditText)paramView.findViewById(2131374373));
    this.eV = ((Button)paramView.findViewById(2131374374));
    this.eW = ((Button)paramView.findViewById(2131377993));
    this.zk = paramView.findViewById(2131377556);
    this.ax = AnimationUtils.loadAnimation(getActivity(), 2130772269);
    this.zj = paramView.findViewById(2131368336);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetRollNumberView = ((RollNumberView)paramView.findViewById(2131374405));
  }
  
  public static boolean x(@Nullable Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof Collection)) {
        break label25;
      }
      if (!((Collection)paramObject).isEmpty()) {
        break label35;
      }
    }
    label25:
    while (paramObject.toString().isEmpty()) {
      return true;
    }
    label35:
    return false;
  }
  
  public int b(JSONArray paramJSONArray, int paramInt)
  {
    int m = 0;
    int k = 0;
    if ((paramJSONArray == null) || (paramJSONArray.length() <= paramInt) || (paramInt < 0)) {
      return 0;
    }
    int i = m;
    for (;;)
    {
      try
      {
        int i1 = paramJSONArray.length();
        j = 0;
        if (j >= i1) {
          break label142;
        }
        int n = (paramInt + j) % i1;
        i = m;
        int i2 = paramJSONArray.optInt(n);
        if (i2 == 0)
        {
          i = n;
          if (j != i1) {
            break label137;
          }
          j = k;
          if (j >= i1) {
            continue;
          }
        }
      }
      catch (Exception paramJSONArray)
      {
        int j;
        paramJSONArray.printStackTrace();
        return i;
      }
      try
      {
        paramJSONArray.put(j, 0);
        j += 1;
      }
      catch (Exception paramJSONArray)
      {
        continue;
      }
      j += 1;
      continue;
      i = paramInt;
      paramJSONArray.put(paramInt, 1);
      return paramInt;
      label137:
      paramInt = i;
      continue;
      label142:
      i = 0;
    }
  }
  
  public void complete()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneHbFragment", 2, "complete---");
    }
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment$a.obtainMessage();
    localMessage.what = 101;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment$a.sendMessage(localMessage);
  }
  
  public void ctk()
  {
    this.iu = System.currentTimeMillis();
  }
  
  public void ctp()
  {
    if (!isAdded()) {
      return;
    }
    getActivity();
    String str = aagi.bcS + this.bce + "/hbThemeConfig.cfg";
    ThreadManager.getFileThreadHandler().post(new QzoneHbFragment.7(this, str));
  }
  
  public int getNavigationBarHeight(Context paramContext)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getResources();
      int j = paramContext.getIdentifier("navigation_bar_height", "dimen", "android");
      if (j > 0) {
        i = paramContext.getDimensionPixelSize(j);
      }
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (isAdded())
      {
        try
        {
          ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.zj.getWindowToken(), 0);
          this.mActivity.csV();
          this.mActivity.finish();
          this.mActivity.overridePendingTransition(0, 0);
          if (this.channel == 32768) {
            continue;
          }
          this.mActivity.s(300, "rewardhongbao.wrap.close", 2);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        if (!this.buR)
        {
          this.buR = true;
          this.eV.setText(acfp.m(2131713117));
          this.aZ.setEnabled(true);
          this.aZ.setFocusable(true);
          this.aZ.setText("");
          if (this.channel != 32768) {
            this.mActivity.s(300, "rewardhongbao.wrap.custom", 2);
          }
          b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment$a, this.aZ);
        }
        else
        {
          this.buR = false;
          this.aZ.setText(this.bcd);
          this.aZ.setEnabled(false);
          this.eV.setText(acfp.m(2131713115));
          this.aZ.setSelection(0);
          continue;
          long l = System.currentTimeMillis();
          if ((this.iu == 0L) || (System.currentTimeMillis() - this.iu >= 1000L))
          {
            this.iu = l;
            if (this.aZ != null) {
              this.bcb = this.aZ.getText().toString();
            }
            localObject = this.mActivity.Y();
            ((Map)localObject).put("total_num", "1");
            ((Map)localObject).put("total_amount", avor.hX(this.bcb));
            ((Map)localObject).put("wishing", "");
            ((Map)localObject).put("channel", this.channel + "");
            ((Map)localObject).put("feeds_name", this.bcf);
            ((Map)localObject).put("feeds_sid", this.feedsid);
            if (this.channel != 32768) {
              break label625;
            }
            if (Wc()) {
              break;
            }
            localObject = avor.i(this.cfT + "", 0, true);
            localObject = acfp.m(2131713118) + (String)localObject + acfp.m(2131713116);
            aqha.a(getActivity(), 230, null, (CharSequence)localObject, null, getString(2131698546), new aaav(this), null).show();
          }
        }
      }
    }
    if (this.bcg.equals("1"))
    {
      ((Map)localObject).put("channel", String.valueOf(1));
      ((Map)localObject).put("bus_type", "1");
    }
    for (;;)
    {
      ((Map)localObject).put("type", String.valueOf(1));
      label625:
      this.mLogic.Z((Map)localObject);
      this.mActivity.overridePendingTransition(0, 0);
      if (this.channel == 32768) {
        break;
      }
      this.mActivity.s(300, "rewardhongbao.wrap.send", 2);
      break;
      ((Map)localObject).put("channel", String.valueOf(1024));
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mActivity.getWindow().setSoftInputMode(32);
    paramLayoutInflater = paramLayoutInflater.inflate(2131562116, null);
    u(paramLayoutInflater);
    initParam();
    kJ();
    ctp();
    cto();
    if (this.channel != 32768) {
      this.mActivity.s(300, "rewardhongbao.wrap.show", 2);
    }
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    if ((this.aZ != null) && (this.mTextWatcher != null))
    {
      this.aZ.removeTextChangedListener(this.mTextWatcher);
      this.mTextWatcher = null;
    }
    super.onDestroyView();
  }
  
  public void parseConfig(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      if (this.channel == 32768) {}
      for (paramJSONObject = paramJSONObject.optJSONObject("mk_svideo_hb"); paramJSONObject != null; paramJSONObject = paramJSONObject.optJSONObject("mk_qzone_hb")) {
        try
        {
          this.mComment = paramJSONObject.optString("comment");
          this.y = paramJSONObject.optJSONArray("money_array");
          this.bcb = qi();
          if (!x(this.bcb)) {
            this.bcd = this.bcb;
          }
          paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment$a.obtainMessage();
          paramJSONObject.what = 100;
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentQzoneHbFragment$a.sendMessage(paramJSONObject);
          return;
        }
        catch (Exception paramJSONObject)
        {
          paramJSONObject.printStackTrace();
          return;
        }
      }
    }
  }
  
  public static class a
    extends Handler
  {
    WeakReference<QzoneHbFragment> mRootView;
    
    a(QzoneHbFragment paramQzoneHbFragment)
    {
      this.mRootView = new WeakReference(paramQzoneHbFragment);
    }
    
    public void handleMessage(Message paramMessage)
    {
      QzoneHbFragment localQzoneHbFragment = (QzoneHbFragment)this.mRootView.get();
      if (localQzoneHbFragment == null) {}
      do
      {
        do
        {
          do
          {
            return;
            switch (paramMessage.what)
            {
            case 102: 
            default: 
              return;
            case 100: 
              if (QLog.isColorLevel()) {
                QLog.d("QzoneHbFragment", 2, "MSG_UPDATE----1");
              }
              break;
            }
          } while ((QzoneHbFragment.a(localQzoneHbFragment) == null) || (TextUtils.isEmpty(QzoneHbFragment.a(localQzoneHbFragment))));
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("QzoneHbFragment", 2, "MSG_UPDATE----in mModifyAmountBtn.setEnabled(false)");
            }
            double d = Double.parseDouble(QzoneHbFragment.a(localQzoneHbFragment));
            QzoneHbFragment.a(localQzoneHbFragment).reset(d);
            QzoneHbFragment.a(localQzoneHbFragment).setVisibility(0);
            QzoneHbFragment.a(localQzoneHbFragment).setVisibility(8);
            QzoneHbFragment.a(localQzoneHbFragment).roll();
            QzoneHbFragment.b(localQzoneHbFragment).setEnabled(false);
            return;
          }
          catch (Exception paramMessage)
          {
            paramMessage.printStackTrace();
            return;
          }
        } while (TextUtils.isEmpty(QzoneHbFragment.a(localQzoneHbFragment)));
        QzoneHbFragment.a(localQzoneHbFragment).setText(QzoneHbFragment.a(localQzoneHbFragment));
        QzoneHbFragment.a(localQzoneHbFragment).setVisibility(8);
        QzoneHbFragment.a(localQzoneHbFragment).setVisibility(0);
        QzoneHbFragment.b(localQzoneHbFragment).setEnabled(true);
      } while (!QLog.isColorLevel());
      QLog.d("QzoneHbFragment", 2, "MSG_ROLL_STOP AmountBtn.setEnabled(true)---");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment
 * JD-Core Version:    0.7.0.1
 */