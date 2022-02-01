package com.tencent.qqmail.bottle.fragment;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.utilities.StatusBarUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.fragment.app.Fragment;
import moai.fragment.app.FragmentManager;
import moai.fragment.app.FragmentTransaction;
import moai.fragment.base.BaseFragmentActivity;

public class BottleFragmentActivity
  extends BaseFragmentActivity
{
  private static final String ARG_BOTTLE_ID = "bottlefragment_bottleid";
  private static final String ARG_PICK_KEY = "bottlefragment_pickkey";
  private static final String ARG_TYPE = "bottlefragment_type";
  private static final int TYPE_BAECH_PICKKEY = 3;
  private static final int TYPE_BEACH = 1;
  private static final int TYPE_CONVERSATION = 2;
  private int animationType;
  
  public static Intent createBeachIntent(String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), BottleFragmentActivity.class);
    localIntent.putExtra("bottlefragment_type", 3);
    localIntent.putExtra("bottlefragment_pickkey", paramString);
    return localIntent;
  }
  
  public static Intent createConversationIntent(String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), BottleFragmentActivity.class);
    localIntent.putExtra("bottlefragment_type", 2);
    localIntent.putExtra("bottlefragment_bottleid", paramString);
    return localIntent;
  }
  
  public static Intent createIntent()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), BottleFragmentActivity.class);
    localIntent.putExtra("bottlefragment_type", 1);
    return localIntent;
  }
  
  private void initializeFragment()
  {
    if (!BottleManager.available())
    {
      QMLog.log(6, TAG, "Bottle is unavailable!!");
      return;
    }
    switch (getIntent().getIntExtra("bottlefragment_type", 1))
    {
    default: 
      return;
    case 1: 
      localObject = new BottleBeachFragment();
      getSupportFragmentManager().beginTransaction().add(2131367566, (Fragment)localObject, localObject.getClass().getSimpleName()).commit();
      return;
    case 2: 
      localObject = new BottleConversationFragment(getIntent().getStringExtra("bottlefragment_bottleid"));
      getSupportFragmentManager().beginTransaction().add(2131367566, (Fragment)localObject, localObject.getClass().getSimpleName()).commit();
      return;
    }
    Object localObject = new BottleBeachFragment(getIntent().getStringExtra("bottlefragment_pickkey"));
    getSupportFragmentManager().beginTransaction().add(2131367566, (Fragment)localObject, localObject.getClass().getSimpleName()).commit();
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
    this.animationType = getIntent().getIntExtra("animationType", 0);
    if (this.animationType == 1) {
      overridePendingTransition(2130772401, 2130772430);
    }
    for (;;)
    {
      initializeFragment();
      StatusBarUtil.immerseWhite(this);
      return;
      if (this.animationType == 2) {
        overridePendingTransition(2130772422, 2130772419);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleFragmentActivity
 * JD-Core Version:    0.7.0.1
 */