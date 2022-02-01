import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoNormalItemHolder.1;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nav
  extends nai
{
  public static final String TAG = nav.class.getSimpleName();
  private KandianUrlImageView O;
  private KandianUrlImageView U;
  private ReadInJoyNickNameTextView a;
  private ViewGroup aQ;
  private boolean aqW;
  private ViewGroup bX;
  private ImageView kn;
  private QQAppInterface mApp;
  private ReadInJoyHeadImageView n;
  
  nav(View paramView, Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    super(paramView, paramActivity, 0);
    this.mApp = paramQQAppInterface;
    this.aQ = ((ViewGroup)paramView.findViewById(2131368438));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131368439));
    this.n = ((ReadInJoyHeadImageView)paramView.findViewById(2131368436));
    this.bX = ((ViewGroup)paramView.findViewById(2131368437));
    this.O = ((KandianUrlImageView)paramView.findViewById(2131368441));
    this.kn = ((ImageView)paramView.findViewById(2131378181));
    if (this.bS != null) {
      this.bS.setVisibility(0);
    }
    this.kn.setOnClickListener(this);
    this.bX.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(this);
    this.U = ((KandianUrlImageView)paramView.findViewById(2131370907));
  }
  
  private void aVi()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.post(new MultiVideoNormalItemHolder.1(this));
  }
  
  private void aVj()
  {
    for (;;)
    {
      try
      {
        if ((TextUtils.isEmpty(this.c.WE)) || (!muj.Es()))
        {
          this.U.setVisibility(8);
          return;
        }
        if (this.c.WE.endsWith("zip"))
        {
          lae locallae = lae.a(this.c.WE);
          locallae.setRepeatCount(0);
          this.U.setImageDrawable(locallae);
          if (this.aqW)
          {
            locallae.playAnimation();
            this.aqW = false;
          }
          this.U.setVisibility(0);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      localObject = URLDrawable.getDrawable(this.c.WE, (URLDrawable.URLDrawableOptions)localObject);
      this.U.setImageDrawable((Drawable)localObject);
    }
  }
  
  private void aVk()
  {
    int[] arrayOfInt;
    if (this.U.getVisibility() == 0)
    {
      arrayOfInt = nap.a(this.mActivity, this.c, this.isFullScreen);
      if ((arrayOfInt[0] >= 0) && (arrayOfInt[1] >= 0)) {}
    }
    else
    {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.U.getLayoutParams();
    localLayoutParams.topMargin = arrayOfInt[0];
    localLayoutParams.rightMargin = arrayOfInt[1];
    if (this.isFullScreen) {
      localLayoutParams.width = wja.dp2px(91.0F, this.mActivity.getResources());
    }
    for (localLayoutParams.height = wja.dp2px(28.0F, this.mActivity.getResources());; localLayoutParams.height = wja.dp2px(24.0F, this.mActivity.getResources()))
    {
      this.U.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = wja.dp2px(78.0F, this.mActivity.getResources());
    }
  }
  
  private void s(VideoInfo paramVideoInfo)
  {
    if (!TextUtils.isEmpty(paramVideoInfo.vIconUrl))
    {
      this.O.setVisibility(0);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = this.O.getHeight();
      localURLDrawableOptions.mRequestWidth = this.O.getWidth();
      paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.vIconUrl, localURLDrawableOptions);
      this.O.setImageDrawable(paramVideoInfo);
      return;
    }
    this.O.setVisibility(8);
  }
  
  public void HN()
  {
    super.HN();
    if ((this.U != null) && ((this.U.getDrawable() instanceof lae)))
    {
      ((lae)this.U.getDrawable()).playAnimation();
      return;
    }
    this.aqW = true;
  }
  
  public void aEx()
  {
    super.aEx();
    if (!this.c.adB)
    {
      if (!TextUtils.isEmpty(this.c.accountName))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.c.accountName);
        VideoFeedsAccessibilityHelper.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, this.c.accountName);
        VideoFeedsAccessibilityHelper.h(this.n, this.c.accountName);
      }
      kmg.a(this.c, this.n);
    }
    s(this.c);
  }
  
  public void aEy()
  {
    super.aEy();
    if (this.c.playCount > 0) {
      aVi();
    }
    for (;;)
    {
      aVj();
      aVk();
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setMaxWidth(2147483647);
    }
  }
  
  public void aEz()
  {
    super.aEz();
    s(this.c);
    aVi();
    aVj();
    aVk();
  }
  
  public void d(VideoInfo paramVideoInfo)
  {
    super.d(paramVideoInfo);
  }
  
  public void mq(boolean paramBoolean)
  {
    super.mq(paramBoolean);
    this.aqW = false;
  }
  
  public void nY(boolean paramBoolean)
  {
    super.nY(paramBoolean);
    aVk();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    nav localnav = (nav)paramView.getTag();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Naq$d.S(this.c);
      continue;
      this.jdField_a_of_type_Naq$d.R(this.c);
      continue;
      this.jdField_a_of_type_Naq$d.Q(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nav
 * JD-Core Version:    0.7.0.1
 */