package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import anot;
import aqnl;
import aqqx;
import axwf;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.io.File;

public class QQLightRecognitionGuide
  extends ReportV4Fragment
  implements Handler.Callback, View.OnClickListener
{
  private final String aOU = axwf.g().getAbsolutePath() + "/qq_recognition_guide/";
  private URLImageView ai;
  private final String auL = "qq_pic_recognition_guide.png";
  private IphoneTitleBarActivity b;
  private final int bJU = 120;
  private Handler mHandler = new Handler(Looper.getMainLooper(), this);
  
  public static void aT(String paramString, boolean paramBoolean)
  {
    paramString = "light_recognition_guide" + paramString;
    BaseApplicationImpl.getApplication().getSharedPreferences(paramString, 4).edit().putBoolean("has_show_guide", paramBoolean).apply();
  }
  
  private void vY(String paramString)
  {
    String str = this.b.getIntent().getStringExtra("method");
    if ("setFaceData".equals(str)) {
      anot.a(null, "dc00898", "", "", paramString, paramString, 0, 0, "1", "", "", "");
    }
    if ("loginVerify".equals(str)) {
      anot.c(null, "dc00898", "", "", paramString, paramString, 0, 0, "2", "", "", "");
    }
  }
  
  private void wa(String paramString)
  {
    File localFile = new File(this.aOU + this.auL);
    Object localObject = this.b.getAppInterface();
    if (((localObject == null) || (!((AppInterface)localObject).isLogin())) && (!Qu())) {}
    for (paramString = getResources().getDrawable(2130846605);; paramString = aqqx.a(this.b.getAppRuntime(), localFile.getAbsolutePath(), paramString, (Drawable)localObject, new int[] { 25 }, "-lightRecognition-", null))
    {
      this.ai.setImageDrawable(paramString);
      ApngImage.playByTag(25);
      return;
      localObject = super.getResources().getDrawable(2130846604);
    }
  }
  
  public boolean Qu()
  {
    String str = aqnl.getSoDir();
    return (!TextUtils.isEmpty(str)) && (new File(str + "libAPNG_release_813.so").exists());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 120) {
      wa("https://sqimg.qq.com/qq_product_operations/tiqq/mqq_resource/guide_animation.png");
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 22)
    {
      QLog.d("QQLightRecognitionGuide", 1, "onActivity requestCode == AuthDevActivity.REQ_IDENTIFICATION, resultCode is : " + paramInt2);
      if ((paramInt2 == -1) && (this.b != null))
      {
        this.b.setResult(paramInt2, paramIntent);
        this.b.finish();
      }
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.b = ((IphoneTitleBarActivity)paramActivity);
  }
  
  public void onClick(View paramView)
  {
    FaceDetectForThirdPartyManager.AppConf localAppConf;
    Intent localIntent1;
    if (paramView.getId() == 2131372348)
    {
      vY("0X800A85D");
      localAppConf = (FaceDetectForThirdPartyManager.AppConf)getArguments().getSerializable("FaceRecognition.AppConf");
      if (!"setFaceData".equals(this.b.getIntent().getStringExtra("method"))) {
        break label210;
      }
      QLog.d("QQLightRecognitionGuide", 1, "click next_btn, method is METHOD_SETTING_FACE_DATA");
      localIntent1 = getActivity().getIntent();
      Intent localIntent2 = new Intent(this.b, QQIdentiferActivity.class);
      localIntent2.putExtra("platformAppId", 101810106);
      localIntent2.putExtra("srcAppId", 101810106);
      localIntent2.putExtra("srcOpenId", localIntent1.getStringExtra("srcOpenId"));
      localIntent2.putExtra("key", localIntent1.getStringExtra("key"));
      localIntent2.putExtra("method", "setFaceData");
      localIntent2.putExtra("serviceType", localIntent1.getIntExtra("serviceType", -1));
      localIntent2.putExtra("FaceRecognition.AppConf", localAppConf);
      if (localAppConf != null) {
        localIntent2.putExtra("key_identification_type", localAppConf.mode);
      }
      startActivityForResult(localIntent2, 22);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label210:
      localIntent1 = new Intent();
      localIntent1.putExtra("FaceRecognition.AppConf", localAppConf);
      this.b.setResult(-1, localIntent1);
      this.b.finish();
    }
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    aT(this.b.getCurrentAccountUin(), true);
    paramLayoutInflater = paramLayoutInflater.inflate(2131561784, paramViewGroup, false);
    paramLayoutInflater.findViewById(2131372348).setOnClickListener(this);
    this.ai = ((URLImageView)paramLayoutInflater.findViewById(2131376870));
    this.mHandler.sendEmptyMessage(120);
    vY("0X800A85C");
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    super.onPause();
    ApngImage.pauseByTag(25);
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(25);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLightRecognitionGuide
 * JD-Core Version:    0.7.0.1
 */