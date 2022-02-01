package com.tencent.qqmail.inquirymail;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.inquirymail.fragment.InquiryMailAccountListFragment;
import com.tencent.qqmail.inquirymail.fragment.InquiryMailListFragment;
import com.tencent.qqmail.utilities.StatusBarUtil;
import moai.fragment.app.Fragment;
import moai.fragment.app.FragmentManager;
import moai.fragment.app.FragmentTransaction;
import moai.fragment.base.BaseFragmentActivity;

public class InquiryMailFragmentActivity
  extends BaseFragmentActivity
{
  private static final String ARG_ACCOUNT_ID = "arg_account_id";
  private static final String ARG_GO_TO_PLACE = "arg_go_to_place";
  private static final int VALUE_GO_TO_ACCOUNT_LIST = 0;
  private static final int VALUE_GO_TO_MAIL_LIST = 1;
  
  public static Intent createIntentToAccountList()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), InquiryMailFragmentActivity.class);
    localIntent.putExtra("arg_go_to_place", 0);
    return localIntent;
  }
  
  public static Intent createIntentToMailList(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), InquiryMailFragmentActivity.class);
    localIntent.putExtra("arg_go_to_place", 1);
    localIntent.putExtra("arg_account_id", paramInt);
    return localIntent;
  }
  
  private void initializeFragment()
  {
    Object localObject;
    switch (getIntent().getIntExtra("arg_go_to_place", 0))
    {
    default: 
      localObject = new InquiryMailAccountListFragment();
    }
    for (;;)
    {
      if (localObject != null) {
        getSupportFragmentManager().beginTransaction().add(2131367566, (Fragment)localObject, localObject.getClass().getSimpleName()).commit();
      }
      return;
      localObject = new InquiryMailAccountListFragment();
      continue;
      localObject = new InquiryMailListFragment(getIntent().getIntExtra("arg_account_id", 0));
    }
  }
  
  public int getContextViewId()
  {
    return 2131367566;
  }
  
  public int getHistorySize()
  {
    return QMActivityManager.shareInstance().getActivitySize();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(null);
    initializeFragment();
    StatusBarUtil.immerseWhite(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.InquiryMailFragmentActivity
 * JD-Core Version:    0.7.0.1
 */