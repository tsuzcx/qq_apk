package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import acfp;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqmr;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qwallet.plugin.FakeUrl;
import rpq;
import whn;

public class ReminderCardItemPage
  extends ActivateBasePage
  implements View.OnClickListener
{
  private TextView HE;
  private TextView HF;
  private TextView HG;
  private TextView HH;
  private TextView HI;
  public AcsMsg a;
  private ActivateFriendActivity a;
  private RoundImageView b;
  private Button dO;
  private RelativeLayout hn;
  private RelativeLayout ho;
  private QQAppInterface mApp;
  private ImageView rV;
  
  public ReminderCardItemPage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReminderCardItemPage(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity = ((ActivateFriendActivity)paramContext);
    this.mApp = paramQQAppInterface;
  }
  
  private void ct(String paramString, int paramInt)
  {
    if (aqmr.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      Object localObject = Uri.parse(paramString);
      if (localObject != null)
      {
        localObject = ((Uri)localObject).getScheme();
        if (!aqmr.isEmpty((String)localObject))
        {
          if ((((String)localObject).startsWith("http")) || (((String)localObject).startsWith("https")))
          {
            if (paramInt != 0) {
              break label79;
            }
            FakeUrl.gotoH5(getContext(), paramString, true, true);
          }
          while (((String)localObject).startsWith("mqqapi"))
          {
            FakeUrl.gotoMqq(getContext(), paramString);
            return;
            label79:
            FakeUrl.gotoResultH5(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity, paramString, true, paramInt);
          }
        }
      }
    }
  }
  
  private void i(ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestHeight = paramImageView.getHeight();
    localURLDrawableOptions.mRequestWidth = paramImageView.getWidth();
    localURLDrawableOptions.mUseMemoryCache = false;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    if (paramString != null) {
      paramImageView.setImageDrawable(paramString);
    }
  }
  
  private void xg(String paramString)
  {
    ct(paramString, 0);
  }
  
  public void b(AcsMsg paramAcsMsg)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_WalletAcsMsg = paramAcsMsg;
        if (paramAcsMsg == null)
        {
          this.HE.setVisibility(4);
          this.hn.setVisibility(0);
          this.ho.setVisibility(8);
          this.dO.setVisibility(8);
          i(this.rV, "https://i.gtimg.cn/channel/imglib/201905/upload_d06258d2e506e8f9f37614f2826e8234.png");
          return;
        }
        this.HE.setVisibility(0);
        this.hn.setVisibility(8);
        this.ho.setVisibility(0);
        this.dO.setVisibility(0);
        this.HE.setText(whn.h(paramAcsMsg.notice_time * 1000L, "HH:mm"));
        RoundImageView localRoundImageView = this.b;
        if (TextUtils.isEmpty(paramAcsMsg.banner_url))
        {
          str = "https://i.gtimg.cn/channel/imglib/201910/upload_a62b5e83214048120b15b81f8a2d7ec3.png";
          i(localRoundImageView, str);
          this.HI.setText(whn.h(paramAcsMsg.sub_time * 1000L, "yyyy.MM.dd") + acfp.m(2131717571) + paramAcsMsg.busi_name + acfp.m(2131717572));
          this.HF.setText(paramAcsMsg.title);
          this.HG.setText(paramAcsMsg.content);
          this.dO.setText(paramAcsMsg.btn_text);
          this.dO.setTag(paramAcsMsg.jump_url);
          return;
        }
      }
      catch (Throwable paramAcsMsg)
      {
        QLog.e("ReminderCardItemPage", 1, "initData throw an exception: " + paramAcsMsg);
        return;
      }
      String str = paramAcsMsg.banner_url;
    }
  }
  
  public void initUI()
  {
    this.mRootView = this.mInflater.inflate(2131561178, this, false);
    this.rV = ((ImageView)this.mRootView.findViewById(2131364299));
    this.HE = ((TextView)this.mRootView.findViewById(2131364300));
    this.hn = ((RelativeLayout)this.mRootView.findViewById(2131364298));
    this.ho = ((RelativeLayout)this.mRootView.findViewById(2131364295));
    this.b = ((RoundImageView)this.mRootView.findViewById(2131364296));
    this.b.setmRadius(rpq.dip2px(getContext(), 5.0F), true);
    this.HF = ((TextView)this.mRootView.findViewById(2131364301));
    this.HG = ((TextView)this.mRootView.findViewById(2131364294));
    this.HH = ((TextView)this.mRootView.findViewById(2131364292));
    this.HH.setOnClickListener(this);
    this.dO = ((Button)this.mRootView.findViewById(2131364293));
    this.dO.setOnClickListener(this);
    this.HI = ((TextView)this.mRootView.findViewById(2131364297));
    addView(this.mRootView);
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
      if (this.jdField_a_of_type_WalletAcsMsg != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReminderCardItemPage", 2, "do report: QQnotice.aio.detail.all");
        }
        anot.a(this.mApp, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.all", 0, 0, "", "", this.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_WalletAcsMsg.msg_id);
      }
      if (1 == QzoneConfig.getInstance().getConfig("QZoneSetting", "QQRemindAllRemindUseH5", 1))
      {
        ct(QzoneConfig.getInstance().getConfig("H5Url", "QQRemindAllRemind", "https://h5.qianbao.qq.com/notice?_wv=1027&_wvx=10&_wwv=4"), 2001);
      }
      else
      {
        ReminderListFragment.bx(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity);
        continue;
        if (this.jdField_a_of_type_WalletAcsMsg != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReminderCardItemPage", 2, "do report: QQnotice.aio.detail.click");
          }
          anot.a(this.mApp, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.click", 0, 0, "", "", this.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_WalletAcsMsg.msg_id);
        }
        xg((String)paramView.getTag());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderCardItemPage
 * JD-Core Version:    0.7.0.1
 */