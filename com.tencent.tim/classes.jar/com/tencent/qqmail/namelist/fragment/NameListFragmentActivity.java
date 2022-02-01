package com.tencent.qqmail.namelist.fragment;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.StatusBarUtil;
import moai.fragment.app.Fragment;
import moai.fragment.app.FragmentManager;
import moai.fragment.app.FragmentTransaction;
import moai.fragment.base.BaseFragmentActivity;

public class NameListFragmentActivity
  extends BaseFragmentActivity
{
  private static final String ARG_ACCOUNT_ID = "account_id";
  private static final String ARG_FROM_READ_MAIL = "from_read_mail";
  private static final String ARG_GO_TO_PLACE = "arg_go_to_place";
  private static final String ARG_READ_MAIL_EMAIL = "read_mail_email";
  private static final String ARG_TYPE = "name_list_type";
  private static final int GO_TO_ACCOUNT_LIST = 0;
  private static final int GO_TO_MAIN_LIST = 1;
  private static final String TAG = "NameListFragmentActivity";
  
  public static Intent createIntentToAccountList(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), NameListFragmentActivity.class);
    localIntent.putExtra("arg_go_to_place", 0);
    localIntent.putExtra("name_list_type", paramInt);
    return localIntent;
  }
  
  public static Intent createIntentToMainList(int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), NameListFragmentActivity.class);
    localIntent.putExtra("arg_go_to_place", 1);
    localIntent.putExtra("account_id", paramInt1);
    localIntent.putExtra("name_list_type", paramInt2);
    return localIntent;
  }
  
  public static Intent createIntentToMainList(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    Intent localIntent = createIntentToMainList(paramInt1, paramInt2);
    localIntent.putExtra("from_read_mail", paramBoolean);
    localIntent.putExtra("read_mail_email", paramString);
    return localIntent;
  }
  
  private void initializeFragment()
  {
    int i = getIntent().getIntExtra("arg_go_to_place", 0);
    Object localObject = null;
    int j = getIntent().getIntExtra("name_list_type", 0);
    int k = getIntent().getIntExtra("account_id", 0);
    boolean bool = getIntent().getBooleanExtra("from_read_mail", false);
    String str = getIntent().getStringExtra("read_mail_email");
    switch (i)
    {
    }
    for (;;)
    {
      getSupportFragmentManager().beginTransaction().add(2131367566, (Fragment)localObject, localObject.getClass().getSimpleName()).commit();
      return;
      localObject = new NameListAccountListFragment(j);
      continue;
      if (bool) {
        localObject = new NameListMainFragment(k, j, bool, str);
      } else {
        localObject = new NameListMainFragment(k, j);
      }
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
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListFragmentActivity
 * JD-Core Version:    0.7.0.1
 */