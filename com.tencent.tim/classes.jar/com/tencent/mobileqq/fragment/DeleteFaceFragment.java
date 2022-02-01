package com.tencent.mobileqq.fragment;

import ahmt;
import ahmu;
import ahmw;
import ahmx;
import aiak;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aneg;
import anot;
import com.tencent.mobileqq.activity.QQIdentiferActivity;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.troop.TroopBaseProxyActivity;
import java.util.Arrays;
import java.util.List;
import wja;

public class DeleteFaceFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private static final List<Integer> Ca = Arrays.asList(new Integer[] { Integer.valueOf(206), Integer.valueOf(205), Integer.valueOf(203) });
  public Dialog X;
  private FragmentActivity activity;
  private Dialog x;
  
  private void Kn(String paramString)
  {
    if (anQ())
    {
      QLog.d("DeleteFaceFragment", 1, "getSkeyError, activity is empty");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("DeleteFaceFragment", 1, "errorMSg is empty");
      return;
    }
    QQToast.a(getActivity(), paramString, 0).show();
    bSZ();
  }
  
  private void a(String paramString1, String paramString2, FaceDetectForThirdPartyManager.AppConf paramAppConf)
  {
    Intent localIntent = new Intent(this.activity, QQIdentiferActivity.class);
    localIntent.putExtra("platformAppId", 101868556);
    localIntent.putExtra("srcAppId", 101868556);
    localIntent.putExtra("srcOpenId", paramString2);
    localIntent.putExtra("key", paramString1);
    localIntent.putExtra("method", "deleteFace");
    localIntent.putExtra("serviceType", 2);
    localIntent.putExtra("FaceRecognition.AppConf", paramAppConf);
    localIntent.putExtra("key_identification_type", paramAppConf.mode);
    startActivityForResult(localIntent, 22);
  }
  
  private void aH(String paramString1, String paramString2, String paramString3)
  {
    aiak.a(this.activity, paramString1, "deleteFace", paramString2, 0L, 101868556, new ahmx(this, paramString1, paramString3));
  }
  
  private boolean anQ()
  {
    return (this.activity == null) || (this.activity.isFinishing());
  }
  
  private void gh(String paramString1, String paramString2)
  {
    aneg.a(101868556, paramString1, "skey", paramString2, "clean", new ahmw(this, paramString1));
  }
  
  public Drawable B(int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(wja.dp2px(6.0F, getResources()));
    localGradientDrawable.setColor(paramInt);
    return localGradientDrawable;
  }
  
  public void bSZ()
  {
    if ((this.X != null) && (this.X.isShowing())) {
      this.X.dismiss();
    }
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299627);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (anQ()) {
      QLog.e("DeleteFaceFragment", 1, "onActivityResult activity is null");
    }
    do
    {
      do
      {
        do
        {
          return;
          bSZ();
        } while ((paramInt2 != -1) || (paramIntent == null));
        if (paramIntent.getBooleanExtra("key_face_scan_result", false))
        {
          this.activity.setResult(paramInt2, paramIntent);
          this.activity.finish();
          return;
        }
      } while (paramIntent.getBundleExtra("data") == null);
      paramIntent = paramIntent.getBundleExtra("data");
      paramInt1 = paramIntent.getInt("ret", -1);
    } while (!Ca.contains(Integer.valueOf(paramInt1)));
    paramIntent = paramIntent.getString("errMsg");
    QQToast.a(this.activity, paramIntent, 0).show();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    FragmentActivity localFragmentActivity = getActivity();
    if (i == 2131369579) {
      localFragmentActivity.finish();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(null, "dc00898", "", "", "0X800A855", "0X800A855", 0, 0, "", "", "", "");
      TextView localTextView1 = (TextView)this.x.findViewById(2131365867);
      TextView localTextView2 = (TextView)this.x.findViewById(2131365863);
      TextView localTextView3 = (TextView)this.x.findViewById(2131365852);
      TextView localTextView4 = (TextView)this.x.findViewById(2131365858);
      localTextView1.setText(getString(2131693364));
      localTextView2.setText(getString(2131693365));
      localTextView3.setText(getString(2131693362));
      localTextView4.setText(getString(2131693363));
      localTextView3.setOnClickListener(new ahmt(this));
      localTextView4.setOnClickListener(new ahmu(this, localFragmentActivity));
      this.x.show();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.activity = getActivity();
    paramLayoutInflater = paramLayoutInflater.inflate(2131561298, paramViewGroup, false);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131380645);
    paramViewGroup.setOnClickListener(this);
    paramViewGroup.setBackgroundDrawable(B(getResources().getColor(2131167061)));
    ((TextView)paramLayoutInflater.findViewById(2131369627)).setText(getString(2131693216));
    ((TextView)paramLayoutInflater.findViewById(2131369579)).setOnClickListener(this);
    paramViewGroup = paramLayoutInflater.findViewById(2131377498);
    paramBundle = (LinearLayout.LayoutParams)paramViewGroup.getLayoutParams();
    paramBundle.topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
    paramViewGroup.setLayoutParams(paramBundle);
    this.x = new ReportDialog(getActivity(), 2131756467);
    this.x.setContentView(2131559127);
    anot.a(null, "dc00898", "", "", "0X800A86F", "0X800A86F", 0, 0, "", "", "", "");
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.X != null) && (this.X.isShowing())) {
      bSZ();
    }
  }
  
  public void showLoadingView()
  {
    if (this.X == null)
    {
      this.X = TroopBaseProxyActivity.a(getActivity());
      this.X.findViewById(2131372861).getLayoutParams().width = -2;
      TextView localTextView = (TextView)this.X.findViewById(2131373180);
      localTextView.setSingleLine();
      localTextView.setPadding(15, 0, 15, 0);
      localTextView.setText(getString(2131693162));
    }
    this.X.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.DeleteFaceFragment
 * JD-Core Version:    0.7.0.1
 */