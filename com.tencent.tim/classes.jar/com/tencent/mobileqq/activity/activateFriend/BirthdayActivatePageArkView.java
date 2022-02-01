package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqmu;
import aqnm;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.qphone.base.util.QLog;
import whm;
import wyw;

public class BirthdayActivatePageArkView
  extends ActivateBasePage
{
  private TextView Ht;
  public final String TAG = "BirthdayActivatePageArkView";
  wyw a;
  public ArkAppView d;
  private LinearLayout gR;
  private ImageView mCover;
  
  public BirthdayActivatePageArkView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.a != null)
    {
      QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  destroy");
      this.a.doOnEvent(2);
    }
  }
  
  public void hideEmptyView()
  {
    this.gR.setVisibility(8);
  }
  
  public void hideLoading()
  {
    ym(true);
  }
  
  public void i(long paramLong, String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject = aqmu.a(getContext(), 3, paramLong);
        this.iG.setText((CharSequence)localObject);
        if (TextUtils.isEmpty(paramString))
        {
          showEmptyView();
          return;
        }
        hideEmptyView();
        if (getContext() != null)
        {
          i = getContext().getResources().getDisplayMetrics().widthPixels;
          i -= aqnm.dpToPx(68.0F);
          paramInt -= aqnm.dpToPx(35.0F);
          localObject = new ArkAppMessage();
          ((ArkAppMessage)localObject).fromAppXml(paramString);
          if (this.a != null)
          {
            QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  initdata destroy");
            this.a.doOnEvent(2);
          }
          this.a = new wyw();
          QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  arkAppContainer  init height =" + paramInt);
          this.a.a(((ArkAppMessage)localObject).appName, ((ArkAppMessage)localObject).appView, ((ArkAppMessage)localObject).appMinVersion, ((ArkAppMessage)localObject).metaList, getResources().getDisplayMetrics().scaledDensity, new SessionInfo());
          this.d.setOnTouchListener(this.d);
          this.d.setOnLongClickListener(this.d);
          this.a.setFixSize(i, paramInt);
          this.a.setMaxSize(i, paramInt);
          this.a.setMinSize(i, paramInt);
          paramString = new whm(this);
          this.d.setLoadCallback(paramString);
          this.d.initArkView(this.a);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("BirthdayActivatePageArkView", 1, "@arkgif  initdata erro" + paramString.toString());
        return;
      }
      int i = aqnm.getScreenWidth();
    }
  }
  
  public void initUI()
  {
    this.mRootView = this.mInflater.inflate(2131561163, this, false);
    this.d = ((ArkAppView)this.mRootView.findViewById(2131374842));
    this.iG = ((TextView)this.mRootView.findViewById(2131362035));
    this.gR = ((LinearLayout)this.mRootView.findViewById(2131366445));
    this.mCover = ((ImageView)this.mRootView.findViewById(2131362052));
    this.Ht = ((TextView)this.mRootView.findViewById(2131366430));
    addView(this.mRootView);
  }
  
  public void showEmptyView()
  {
    this.gR.setVisibility(0);
    this.mCover.setImageDrawable(getResources().getDrawable(2130845628));
    this.Ht.setVisibility(0);
  }
  
  public void showLoading()
  {
    this.d.setAlpha(0.0F);
    findViewById(2131362033).setVisibility(0);
    QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  showLoading");
  }
  
  public void ym(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.d.setAlpha(1.0F);
    }
    for (;;)
    {
      findViewById(2131362033).setVisibility(8);
      QLog.i("BirthdayActivatePageArkView", 1, "@arkgif  hideLoading");
      return;
      showEmptyView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.BirthdayActivatePageArkView
 * JD-Core Version:    0.7.0.1
 */