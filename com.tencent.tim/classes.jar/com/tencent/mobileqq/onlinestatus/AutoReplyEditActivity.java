package com.tencent.mobileqq.onlinestatus;

import aksu;
import aksv;
import aksw;
import aksx;
import aksy;
import aksz;
import akta;
import aktb;
import aktc;
import aktd;
import aktf;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import aqha;
import aqju;
import aurd;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.profile.view.SoftInputDetectView.a;
import com.tencent.mobileqq.theme.ThemeUtil;

public class AutoReplyEditActivity
  extends IphoneTitleBarFragment
  implements SoftInputDetectView.a
{
  private ImageView Cb;
  private EditText bw;
  private boolean cuv;
  private boolean cuw;
  private boolean cux;
  private AutoReplyText jdField_d_of_type_ComTencentMobileqqDataAutoReplyText;
  private EmoticonMainPanel jdField_d_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private ViewGroup et;
  private ImageView gR;
  private View.OnTouchListener j = new aksu(this);
  private QQAppInterface mApp;
  private Handler mUIHandler;
  
  private void Nj(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Nk(false);
      this.mUIHandler.postDelayed(new AutoReplyEditActivity.7(this), 0L);
      return;
    }
    aurd.hide(this.bw);
  }
  
  private void Nk(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Nj(false);
      localObject = this.mUIHandler;
      AutoReplyEditActivity.8 local8 = new AutoReplyEditActivity.8(this);
      if (this.cuv) {}
      for (long l = 500L;; l = 10L)
      {
        ((Handler)localObject).postDelayed(local8, l);
        return;
      }
    }
    this.cuw = false;
    Object localObject = this.et.getLayoutParams();
    this.gR.setImageResource(2130850880);
    this.gR.setContentDescription(getActivity().getString(2131690680));
    this.gR.setOnClickListener(new aktf(this));
    this.jdField_d_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(8);
    ((ViewGroup.LayoutParams)localObject).height = -2;
    this.et.setMinimumHeight(0);
    this.et.setLayoutParams((ViewGroup.LayoutParams)localObject);
    dDp();
  }
  
  private static EmoticonMainPanel a(@NonNull QQAppInterface paramQQAppInterface, @NonNull BaseActivity paramBaseActivity, @NonNull View paramView, int paramInt, @NonNull EditText paramEditText)
  {
    paramView = (EmoticonMainPanel)paramView.findViewById(paramInt);
    paramView.setCallBack(new aksx(paramEditText, paramQQAppInterface, paramBaseActivity));
    paramView.bYZ = true;
    paramView.bZc = true;
    paramView.bYX = false;
    paramView.bYY = true;
    paramView.bZb = true;
    paramView.a(paramQQAppInterface, 100002, paramBaseActivity, paramBaseActivity.getTitleBarHeight(), null, null, false, new aksy());
    paramView.a.setOverScrollMode(2);
    return paramView;
  }
  
  public static void a(Activity paramActivity, int paramInt, AutoReplyText paramAutoReplyText)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("AutoReplyEditActivity:text", paramAutoReplyText);
    PublicFragmentActivity.startForResult(paramActivity, localIntent, AutoReplyEditActivity.class, paramInt);
  }
  
  private void aQy()
  {
    aqju localaqju = aqha.a(getActivity(), 230).setMessage(getString(2131690684));
    localaqju.setPositiveButton(2131721079, new aksv(this));
    localaqju.setNegativeButton(2131721058, new aksw(this));
    localaqju.show();
  }
  
  private void dDp()
  {
    if ((this.cuw) || (this.cuv))
    {
      this.Cb.setImageResource(2130837592);
      this.Cb.setContentDescription(getActivity().getString(2131690682));
      return;
    }
    this.Cb.setImageResource(2130837593);
    this.Cb.setContentDescription(getActivity().getString(2131690685));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void dh(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    setTitle(getString(2131690668));
    setLeftButton(2131721058, new aksz(this));
    setRightButton(2131721066, new akta(this));
    ((SoftInputDetectView)this.mContentView.findViewById(2131369291)).setOnImStateChangedListener(this);
    this.jdField_d_of_type_ComTencentMobileqqDataAutoReplyText = ((AutoReplyText)localBundle.getParcelable("AutoReplyEditActivity:text"));
    this.et = ((ViewGroup)this.mContentView.findViewById(2131366347));
    this.bw = ((EditText)this.mContentView.findViewById(2131363138));
    this.bw.setEditableFactory(new aktb(this));
    if (this.jdField_d_of_type_ComTencentMobileqqDataAutoReplyText != null) {
      if (this.jdField_d_of_type_ComTencentMobileqqDataAutoReplyText.getTextId() == 2147483647) {
        this.cux = false;
      }
    }
    for (;;)
    {
      this.bw.setFocusable(true);
      this.bw.setFocusableInTouchMode(true);
      this.bw.requestFocus();
      this.jdField_d_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = a(this.mApp, getActivity(), this.mContentView, 2131366348, this.bw);
      this.jdField_d_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(8);
      if (TextUtils.isEmpty(this.bw.getText())) {
        this.rightViewText.setEnabled(false);
      }
      this.bw.addTextChangedListener(new aktc(this));
      this.gR = ((ImageView)this.mContentView.findViewById(2131366375));
      this.gR.setOnTouchListener(this.j);
      this.Cb = ((ImageView)this.mContentView.findViewById(2131366378));
      this.Cb.setOnTouchListener(this.j);
      this.Cb.setOnClickListener(new aktd(this));
      if (!ThemeUtil.isDefaultTheme())
      {
        this.mContentView.findViewById(2131380010).setVisibility(8);
        this.mContentView.findViewById(2131363661).setVisibility(8);
      }
      return;
      this.bw.setText(this.jdField_d_of_type_ComTencentMobileqqDataAutoReplyText.getRawText());
      continue;
      this.cux = true;
    }
  }
  
  private boolean nN(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int k;
    int i;
    if (paramString != null)
    {
      k = paramString.length();
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < k)
      {
        int m = paramString.charAt(i);
        if ((m != 32) && (m != 10) && (m != 13) && (m != 9)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void aq(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      Nk(false);
    }
    this.cuv = paramBoolean;
    dDp();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mApp = getActivity().app;
    this.mUIHandler = new Handler();
    this.cuv = false;
    this.cux = false;
    this.cuw = false;
    dh(getArguments());
  }
  
  public int getContentLayoutId()
  {
    return 2131558448;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(16);
    paramActivity.getWindow().getDecorView().setBackgroundResource(2130838900);
  }
  
  public boolean onBackEvent()
  {
    if ((!getActivity().isFinishing()) && (this.jdField_d_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getVisibility() == 0))
    {
      Nk(false);
      return true;
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity
 * JD-Core Version:    0.7.0.1
 */