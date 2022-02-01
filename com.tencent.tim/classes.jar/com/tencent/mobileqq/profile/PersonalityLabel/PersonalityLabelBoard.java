package com.tencent.mobileqq.profile.PersonalityLabel;

import albg;
import alcj;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqep;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class PersonalityLabelBoard
  extends LinearLayout
  implements albg, Handler.Callback, View.OnClickListener
{
  View FK;
  public View FL;
  public TextView Xa;
  public TextView Xb;
  public TextView Xc;
  public TagCloudView a;
  private String aGC;
  WeakReference<a> aS;
  QQAppInterface app;
  PersonalityLabel b;
  private boolean cvP;
  private boolean cvQ = true;
  LinearLayout.LayoutParams g;
  public Button gV;
  LinearLayout jQ;
  View mContainer;
  Drawable mDefaultDrawable;
  float mDensity;
  protected LayoutInflater mInflater;
  private int mMode = 0;
  Runnable mScrollRunnable = new PersonalityLabelBoard.2(this);
  ColorStateList mTextColors = ColorStateList.valueOf(-16777216);
  Handler mUIHandler = new Handler(Looper.getMainLooper(), this);
  private String mUin;
  
  public PersonalityLabelBoard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  @TargetApi(11)
  public PersonalityLabelBoard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public PersonalityLabelBoard(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, View paramView)
  {
    super(paramContext);
    this.app = paramQQAppInterface;
    this.mContainer = paramView;
    init();
    if (!TextUtils.equals(paramString, paramQQAppInterface.getCurrentAccountUin())) {
      this.mMode = 1;
    }
    this.mUin = paramString;
  }
  
  private void a(PersonalityLabel paramPersonalityLabel)
  {
    ArrayList localArrayList = new ArrayList(paramPersonalityLabel.getSize());
    URLDrawable localURLDrawable = null;
    if (this.mDefaultDrawable == null) {
      this.mDefaultDrawable = getResources().getDrawable(2131165579);
    }
    String str = paramPersonalityLabel.getLatestThumbUrl();
    if (!TextUtils.isEmpty(str)) {
      localURLDrawable = URLDrawable.getDrawable(str, this.mDefaultDrawable, this.mDefaultDrawable);
    }
    alcj.a(localArrayList, paramPersonalityLabel, this.mDensity);
    this.a.setTags(localArrayList);
    this.a.setTagIcon(localURLDrawable);
    if (AppSetting.enableTalkBack)
    {
      paramPersonalityLabel = new StringBuilder();
      paramPersonalityLabel.append("个性标签");
      this.a.setContentDescription(paramPersonalityLabel.toString());
    }
  }
  
  private void a(PersonalityLabel paramPersonalityLabel, boolean paramBoolean)
  {
    if (this.mMode == 1) {}
    for (int i = paramPersonalityLabel.praiseCount + paramPersonalityLabel.unreadCount; (i <= 0) && (paramPersonalityLabel.unreadCount <= 0); i = paramPersonalityLabel.praiseCount)
    {
      if (this.FL.getVisibility() != 8) {
        this.FL.setVisibility(8);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("获得");
    localStringBuilder.append(i);
    localStringBuilder.append("个赞");
    if (!TextUtils.equals(this.Xb.getText(), localStringBuilder)) {
      this.Xb.setText(localStringBuilder);
    }
    if (this.FL.getVisibility() != 0) {
      this.FL.setVisibility(0);
    }
    if (this.mMode == 0) {
      if (paramPersonalityLabel.unreadCount <= 0) {
        if (this.Xc.getVisibility() != 8) {
          this.Xc.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack)
      {
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append("个性标签").append("，").append(this.Xb.getText());
        if (this.mMode == 0)
        {
          if (paramPersonalityLabel.unreadCount > 0) {
            localStringBuilder.append("，").append("新增").append(paramPersonalityLabel.unreadCount).append("个赞");
          }
          localStringBuilder.append("，").append("点按两次查看");
        }
        this.FL.setContentDescription(localStringBuilder.toString());
      }
      if ((!paramBoolean) || (this.mMode != 0) || (paramPersonalityLabel.unreadCount <= 0)) {
        break;
      }
      anot.a(this.app, "dc00898", "", "", "0X8007FCD", "0X8007FCD", 0, 0, "0", "0", "", "");
      return;
      if (this.Xc.getVisibility() != 0) {
        this.Xc.setVisibility(0);
      }
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append("+");
      localStringBuilder.append(paramPersonalityLabel.unreadCount);
      if (!TextUtils.equals(this.Xc.getText(), localStringBuilder))
      {
        this.Xc.setText(localStringBuilder);
        continue;
        if (this.Xc.getVisibility() != 8) {
          this.Xc.setVisibility(8);
        }
      }
    }
  }
  
  private void dEN()
  {
    NB(true);
  }
  
  private void init()
  {
    this.mDensity = getResources().getDisplayMetrics().density;
    this.mInflater = LayoutInflater.from(getContext());
    this.g = new LinearLayout.LayoutParams(-1, -2);
    setOrientation(1);
    setLayoutParams(this.g);
  }
  
  public void NB(boolean paramBoolean)
  {
    if (this.cvP) {}
    do
    {
      do
      {
        return;
        this.cvP = true;
        Intent localIntent = new Intent(getContext(), PersonalityLabelGalleryActivity.class);
        localIntent.putExtra("fromType", 0);
        localIntent.putExtra("uin", this.mUin);
        if ((this.mMode == 1) && (!TextUtils.isEmpty(this.aGC))) {
          localIntent.putExtra("nickname", this.aGC);
        }
        ((Activity)getContext()).startActivityForResult(localIntent, 1029);
      } while (!paramBoolean);
      anot.a(this.app, "dc00898", "", "", "0X8007FCB", "0X8007FCB", 0, 0, "0", "0", "", "");
    } while ((this.b == null) || (this.b.unreadCount <= 0));
    anot.a(this.app, "dc00898", "", "", "0X8007FCE", "0X8007FCE", 0, 0, "0", "0", "", "");
  }
  
  public void a(PersonalityLabel paramPersonalityLabel, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelBoard", 2, "onGetPersonalityLabels isServer:" + paramBoolean1 + ", scroll:" + paramBoolean2 + "," + paramPersonalityLabel.toString());
    }
    if ((paramPersonalityLabel.getSize() > 0) && (this.FK == null))
    {
      this.FK = this.mInflater.inflate(2131561586, this, false);
      this.a = ((TagCloudView)this.FK.findViewById(2131379188));
      this.FL = this.FK.findViewById(2131382426);
      this.Xb = ((TextView)this.FK.findViewById(2131381024));
      this.Xc = ((TextView)this.FK.findViewById(2131381026));
      this.a.setOnClickListener(this);
      this.FL.setOnClickListener(this);
      this.a.setMinHeight((int)(this.mDensity * 150.0F));
      this.a.setThreshold((int)(this.mDensity * 7.5F));
      if (getChildCount() <= 0) {
        break label410;
      }
    }
    label410:
    for (View localView = getChildAt(0);; localView = null)
    {
      if (paramPersonalityLabel.getSize() != 0) {
        break label416;
      }
      if ((localView == this.FK) || (localView == null))
      {
        removeAllViews();
        addView(this.jQ);
      }
      this.b = paramPersonalityLabel;
      if ((paramBoolean2) && (this.b.isCloseByUser == 0))
      {
        this.mUIHandler.removeCallbacks(this.mScrollRunnable);
        this.mUIHandler.postDelayed(this.mScrollRunnable, 100L);
      }
      return;
      if ((paramPersonalityLabel.getSize() != 0) || (this.jQ != null)) {
        break;
      }
      if (this.cvQ) {}
      for (this.jQ = ((LinearLayout)this.mInflater.inflate(2131561587, this, false));; this.jQ = ((LinearLayout)this.mInflater.inflate(2131561588, this, false)))
      {
        this.gV = ((Button)this.jQ.findViewById(2131380516));
        this.gV.setOnClickListener(this);
        this.Xa = ((TextView)this.jQ.findViewById(2131380517));
        this.Xa.setTextColor(this.mTextColors);
        break;
      }
    }
    label416:
    if ((localView == this.jQ) || (localView == null))
    {
      removeAllViews();
      addView(this.FK);
      a(paramPersonalityLabel);
    }
    for (;;)
    {
      a(paramPersonalityLabel, paramBoolean1);
      break;
      if (localView == this.FK) {
        if (!paramPersonalityLabel.equals(this.b)) {
          a(paramPersonalityLabel);
        } else if (QLog.isColorLevel()) {
          QLog.i("PersonalityLabelBoard", 2, "onGetPersonalityLabels same data");
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.FL)
    {
      if (this.mMode != 0) {
        break label237;
      }
      anot.a(this.app, "dc00898", "", "", "0X80081D7", "0X80081D7", 0, 0, "", "", "", "");
      Object localObject = new Intent(getContext(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", "https://ti.qq.com/cgi-node/specialtag/zanlist?_wv=1027&asyncMode=3");
      getContext().startActivity((Intent)localObject);
      localObject = this.b;
      ((PersonalityLabel)localObject).praiseCount += this.b.unreadCount;
      this.b.unreadCount = 0;
      if (this.b.praiseCount > 0) {}
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      postDelayed(new PersonalityLabelBoard.1(this), 500L);
      if ((getContext() instanceof FriendProfileCardActivity)) {
        ((FriendProfileCardActivity)getContext()).bOr();
      }
      for (;;)
      {
        if (paramView != this.gV) {
          break label244;
        }
        aqep.a(this.app.getCurrentAccountUin(), this.app, (Activity)getContext(), true);
        anot.a(this.app, "dc00898", "", "", "0X8007FCC", "0X8007FCC", 0, 0, "0", "0", "", "");
        break;
        label237:
        dEN();
      }
      label244:
      if (paramView == this.a) {
        dEN();
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mUIHandler.removeCallbacks(this.mScrollRunnable);
  }
  
  public void onResume()
  {
    this.cvP = false;
  }
  
  public void setIsNormalTheme(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelBoard", 2, "setIsNormalTheme:" + paramBoolean + " old:" + this.cvQ);
    }
    View localView;
    LinearLayout localLinearLayout;
    if (this.cvQ != paramBoolean)
    {
      this.cvQ = paramBoolean;
      if (getChildCount() <= 0) {
        break label182;
      }
      localView = getChildAt(0);
      localLinearLayout = this.jQ;
      if (localLinearLayout != null) {
        if (!this.cvQ) {
          break label187;
        }
      }
    }
    label182:
    label187:
    for (this.jQ = ((LinearLayout)this.mInflater.inflate(2131561587, this, false));; this.jQ = ((LinearLayout)this.mInflater.inflate(2131561588, this, false)))
    {
      this.gV = ((Button)this.jQ.findViewById(2131380516));
      this.gV.setOnClickListener(this);
      this.Xa = ((TextView)this.jQ.findViewById(2131380517));
      this.Xa.setTextColor(this.mTextColors);
      if ((localView != null) && (localView == localLinearLayout))
      {
        removeAllViews();
        addView(this.jQ);
      }
      return;
      localView = null;
      break;
    }
  }
  
  public void setNick(String paramString)
  {
    if (!TextUtils.equals(paramString, this.aGC)) {
      this.aGC = paramString;
    }
  }
  
  public void setScrollListener(a parama)
  {
    this.aS = new WeakReference(parama);
  }
  
  public void setTextColors(ColorStateList paramColorStateList)
  {
    this.mTextColors = paramColorStateList;
    if (this.Xa != null) {
      this.Xa.setTextColor(this.mTextColors);
    }
  }
  
  public static abstract interface a
  {
    public abstract void AN(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard
 * JD-Core Version:    0.7.0.1
 */