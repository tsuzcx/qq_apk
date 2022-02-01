package com.tencent.qqmail.card.fragment;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.utilities.StatusBarUtil;
import com.tencent.qqmail.utilities.cacheclear.QMClearCacheManager;
import moai.fragment.app.Fragment;
import moai.fragment.app.FragmentManager;
import moai.fragment.app.FragmentTransaction;
import moai.fragment.base.BaseFragmentActivity;

public class CardFragmentActivity
  extends BaseFragmentActivity
{
  private static final String ARG_CARD_DATA = "card_data";
  private static final String ARG_CARD_ID = "card_id";
  private static final String ARG_FROM_SCHEMA = "from_schema";
  private static final String ARG_GO_TO_PLACE = "arg_go_to_place";
  private static final String ARG_SCHEMA_TO = "schema_to";
  private static final String ARG_SCHEMA_TO_SEL = "schema_to_sel";
  private static final String ARG_SCHEMA_TO_TOTAL = "schema_to_total";
  private static final String ARG_TYPE = "card_type";
  private static final int GO_TO_BIRTHDAY = 2;
  private static final int GO_TO_CARD_PLAY_PREVIEW = 4;
  private static final int GO_TO_GALLERY = 0;
  private static final int GO_TO_POP_CHOOSE = 3;
  private static final int GO_TO_PREVIEW = 1;
  
  public static Intent createIntent(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), CardFragmentActivity.class);
    localIntent.putExtra("card_type", paramInt);
    return localIntent;
  }
  
  public static Intent createIntentToBirthday(String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), CardFragmentActivity.class);
    localIntent.putExtra("arg_go_to_place", 2);
    localIntent.putExtra("card_id", paramString);
    return localIntent;
  }
  
  public static Intent createIntentToCardPlayPreview(QMCardData paramQMCardData)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), CardFragmentActivity.class);
    localIntent.putExtra("arg_go_to_place", 4);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("card_data", paramQMCardData);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  public static Intent createIntentToGallery(int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), CardFragmentActivity.class);
    localIntent.putExtra("arg_go_to_place", 0);
    localIntent.putExtra("card_type", paramInt);
    localIntent.putExtra("from_schema", paramBoolean);
    return localIntent;
  }
  
  public static Intent createIntentToPopChoose(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), CardFragmentActivity.class);
    localIntent.putExtra("arg_go_to_place", 3);
    localIntent.putExtra("card_id", paramString1);
    localIntent.putExtra("schema_to", paramString2);
    localIntent.putExtra("schema_to_total", paramInt1);
    localIntent.putExtra("schema_to_sel", paramInt2);
    return localIntent;
  }
  
  public static Intent createIntentToPreview(String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), CardFragmentActivity.class);
    localIntent.putExtra("arg_go_to_place", 1);
    localIntent.putExtra("card_id", paramString);
    return localIntent;
  }
  
  private void initializeFragment()
  {
    int i = getIntent().getIntExtra("arg_go_to_place", 0);
    Object localObject = null;
    String str = getIntent().getStringExtra("card_id");
    int j = getIntent().getIntExtra("card_type", -1);
    switch (i)
    {
    }
    for (;;)
    {
      getSupportFragmentManager().beginTransaction().add(2131367566, (Fragment)localObject, localObject.getClass().getSimpleName()).commit();
      return;
      localObject = new CardGalleryFragment(j, getIntent().getBooleanExtra("from_schema", false));
      continue;
      localObject = new CardPreviewFragment(str);
      continue;
      localObject = new CardBirthdayChooseFragment(str);
      continue;
      localObject = new CardPopChooseFragment(str, getIntent().getStringExtra("schema_to"), getIntent().getIntExtra("schema_to_total", 0), getIntent().getIntExtra("schema_to_sel", 0), true);
      continue;
      localObject = new CardPreviewFragment(3, (QMCardData)getIntent().getSerializableExtra("card_data"), false);
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
    QMClearCacheManager.setEnterCardTime();
    initializeFragment();
    StatusBarUtil.immerseWhite(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardFragmentActivity
 * JD-Core Version:    0.7.0.1
 */