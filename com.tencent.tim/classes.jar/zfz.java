import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.b;
import com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryViewPagerAdapter;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FadeIconImageView;

public class zfz
  extends zer
  implements View.OnClickListener, SimpleSlidingIndicator.b
{
  TextView MO;
  ChatHistoryViewPagerAdapter jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter;
  zgs jdField_a_of_type_Zgs;
  QQViewPager b;
  SimpleSlidingIndicator jdField_c_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
  FadeIconImageView jdField_c_of_type_ComTencentWidgetFadeIconImageView;
  int cbR;
  int cbS = -1;
  public int cdo = 0;
  
  public zfz(FragmentActivity paramFragmentActivity)
  {
    super(paramFragmentActivity);
  }
  
  private void EN(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.history.CommonViewController", 2, "switchToTabPos mCurrentTabPos:" + this.cbR + "  pos:" + paramInt);
    }
    this.cbR = paramInt;
    this.jdField_c_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(this.cbR, false);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.cbR, false);
  }
  
  private void EO(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.CommonViewController", 2, "onPageChange. position:" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter.fZ(paramInt, this.cbS);
    this.jdField_c_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(paramInt, true);
    this.cbR = paramInt;
  }
  
  public void BB(boolean paramBoolean)
  {
    if (this.MO != null) {
      this.MO.setEnabled(paramBoolean);
    }
  }
  
  public void Fg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1600: 
      this.MO.setVisibility(8);
      this.jdField_c_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
      return;
    case 1601: 
      this.MO.setVisibility(8);
      this.jdField_c_of_type_ComTencentWidgetFadeIconImageView.setVisibility(0);
      return;
    case 1602: 
      this.MO.setVisibility(0);
      this.MO.setText(2131690235);
      this.jdField_c_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
      this.cdo = 1;
      return;
    }
    this.MO.setVisibility(0);
    this.MO.setText(2131721058);
    this.jdField_c_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
    this.cdo = 2;
  }
  
  protected int[] J()
  {
    return null;
  }
  
  protected int[] K()
  {
    return null;
  }
  
  public ChatHistoryBaseFragment a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter.a(this.cbR, false);
    }
    return null;
  }
  
  public void coI()
  {
    if (this.cdo == 2)
    {
      this.MO.setText(2131690235);
      this.cdo = 1;
      if (this.jdField_b_of_type_Zgr != null) {
        this.jdField_b_of_type_Zgr.coR();
      }
    }
  }
  
  public int d(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.history.CommonViewController", 2, "onContactTabChange. position:" + paramInt + " fromUserClick:" + paramBoolean);
    }
    this.cbS = this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
    this.cbR = paramInt;
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt, false);
    return 0;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ChatHistoryBaseFragment localChatHistoryBaseFragment = a();
    if (localChatHistoryBaseFragment != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.CommonViewController", 2, "onActivityResult, cur Fragment = " + localChatHistoryBaseFragment.getClass().getName());
      }
      localChatHistoryBaseFragment.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.history.CommonViewController", 2, "onActivityResult, cur Fragment is null ");
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
      this.mActivity.finish();
      continue;
      if (this.cdo == 1)
      {
        if (this.jdField_b_of_type_Zgr != null) {
          this.jdField_b_of_type_Zgr.coQ();
        }
        this.MO.setText(2131721058);
        this.cdo = 2;
      }
      else if (this.cdo == 2)
      {
        if (this.jdField_b_of_type_Zgr != null) {
          this.jdField_b_of_type_Zgr.coR();
        }
        this.MO.setText(2131690235);
        this.cdo = 1;
        continue;
        if (this.jdField_b_of_type_Zgr != null) {
          this.jdField_b_of_type_Zgr.coP();
        }
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    C(2131369579).setOnClickListener(this);
    this.MO = ((TextView)C(2131369612));
    this.MO.setOnClickListener(this);
    this.MO.setVisibility(8);
    this.jdField_c_of_type_ComTencentWidgetFadeIconImageView = ((FadeIconImageView)C(2131369578));
    this.jdField_c_of_type_ComTencentWidgetFadeIconImageView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
    this.jdField_c_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)C(2131378499));
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)C(2131364459));
    this.jdField_a_of_type_Zgs = new zgs();
    int[] arrayOfInt1 = J();
    int[] arrayOfInt2 = K();
    if ((arrayOfInt1 != null) && (arrayOfInt2 != null))
    {
      this.jdField_a_of_type_Zgs.a(a(), arrayOfInt1, arrayOfInt2);
      this.jdField_c_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setTabData(this.jdField_a_of_type_Zgs.cW, arrayOfInt1);
    }
    this.jdField_c_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter = new ChatHistoryViewPagerAdapter(getFragmentManager(), a(), this, this.jdField_a_of_type_Zgs, this.mUin);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter);
    if (arrayOfInt1 != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setOffscreenPageLimit(arrayOfInt1.length);
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(new zga(this));
    EN(0);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter.doOnDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter.sx(this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter.Fm(this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
  }
  
  public int yh()
  {
    return this.jdField_a_of_type_Zgs.jd[this.cbR];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zfz
 * JD-Core Version:    0.7.0.1
 */