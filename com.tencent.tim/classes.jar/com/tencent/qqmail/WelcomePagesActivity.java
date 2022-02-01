package com.tencent.qqmail;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.badge.BadgeUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.view.FullWindowHelper;
import java.util.ArrayList;
import java.util.List;

public class WelcomePagesActivity
  extends BaseActivity
  implements ViewPager.OnPageChangeListener
{
  private static final String ARG_FROM_SETTING = "from_setting";
  private static final String ARG_VERSION_KEY = "oldVersion";
  private static final String LOG = "welcomepages";
  private static final String TAG = "WelcomePagesActivity";
  private int currentIndex;
  private CheckBox[] dots;
  private boolean isFromSetting;
  private String oldVersion;
  private View.OnClickListener onDotsClickListener = new WelcomePagesActivity.4(this);
  private View view1;
  private View view2;
  private View view3;
  private View view4;
  private List<View> viewList;
  private ViewPager viewPager;
  
  public static Intent createIntent(String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), WelcomePagesActivity.class);
    localIntent.putExtra("oldVersion", paramString);
    return localIntent;
  }
  
  public static Intent createIntent(String paramString, boolean paramBoolean)
  {
    paramString = createIntent(paramString);
    paramString.putExtra("from_setting", paramBoolean);
    return paramString;
  }
  
  private void initDots()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131382227);
    this.dots = new CheckBox[this.viewList.size()];
    int i = 0;
    while (i < this.viewList.size())
    {
      this.dots[i] = ((CheckBox)localLinearLayout.getChildAt(i));
      this.dots[i].setChecked(false);
      this.dots[i].setOnClickListener(this.onDotsClickListener);
      i += 1;
    }
    this.currentIndex = 0;
    this.dots[this.currentIndex].setChecked(true);
  }
  
  private void initView()
  {
    this.viewPager = ((ViewPager)findViewById(2131382228));
    getLayoutInflater();
    Object localObject = LayoutInflater.from(this);
    if (((this.oldVersion != null) && ((this.oldVersion.startsWith("3")) || (this.oldVersion.startsWith("4")))) || (this.isFromSetting))
    {
      this.view1 = ((LayoutInflater)localObject).inflate(2131563349, null);
      this.view1.findViewById(2131382223).setVisibility(0);
      this.view2 = ((LayoutInflater)localObject).inflate(2131563349, null);
      this.view2.findViewById(2131382224).setVisibility(0);
      this.view3 = ((LayoutInflater)localObject).inflate(2131563349, null);
      this.view3.findViewById(2131382225).setVisibility(0);
      this.view4 = ((LayoutInflater)localObject).inflate(2131563349, null);
      this.view4.findViewById(2131382226).setVisibility(0);
    }
    for (;;)
    {
      this.view4.findViewById(2131382221).setOnClickListener(new WelcomePagesActivity.1(this));
      this.viewList = new ArrayList();
      this.viewList.add(this.view1);
      this.viewList.add(this.view2);
      this.viewList.add(this.view3);
      this.viewList.add(this.view4);
      localObject = new WelcomePagesActivity.2(this);
      this.viewPager.setAdapter((PagerAdapter)localObject);
      this.viewPager.setOnPageChangeListener(new WelcomePagesActivity.3(this));
      return;
      this.view1 = ((LayoutInflater)localObject).inflate(2131563348, null);
      this.view1.findViewById(2131382223).setVisibility(0);
      this.view2 = ((LayoutInflater)localObject).inflate(2131563348, null);
      this.view2.findViewById(2131382224).setVisibility(0);
      this.view3 = ((LayoutInflater)localObject).inflate(2131563348, null);
      this.view3.findViewById(2131382225).setVisibility(0);
      this.view4 = ((LayoutInflater)localObject).inflate(2131563348, null);
      this.view4.findViewById(2131382226).setVisibility(0);
    }
  }
  
  private void setCurrentDot(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.viewList.size() - 1) || (this.currentIndex == paramInt)) {
      return;
    }
    this.dots[paramInt].setChecked(true);
    this.dots[this.currentIndex].setChecked(false);
    this.currentIndex = paramInt;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    FullWindowHelper.changeToFullScreen(getWindow(), this);
    setContentView(2131563347);
    this.oldVersion = getIntent().getStringExtra("oldVersion");
    this.isFromSetting = getIntent().getBooleanExtra("from_setting", false);
    initView();
    initDots();
    QMLog.log(4, "WelcomePagesActivity", "show welcomePages:" + this.oldVersion);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.isFromSetting))
    {
      finish();
      overridePendingTransition(2130772430, 2130772025);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt) {}
  
  public void onResume()
  {
    super.onResume();
    if ((AccountManager.shareInstance().getAccountList().size() == 0) && (Build.BRAND.toLowerCase().contains("samsung"))) {
      BadgeUtil.getInstance().clearBadge();
    }
    DataCollector.logDetailEvent("DetailEvent_User_Behavior", 0L, 0L, "welcomepages");
    QMLogStream.logWithoutUmaNow(-40025, "welcomepages", "Event_Error");
    QMLogStream.submitLog(false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.WelcomePagesActivity
 * JD-Core Version:    0.7.0.1
 */