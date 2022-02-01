package com.tencent.mobileqq.search.activity;

import acdu;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqgv;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.fragment.MessageSearchDetailFragment;
import com.tencent.qphone.base.util.QLog;
import wja;

public class MessageSearchDetailActivity
  extends IphoneTitleBarActivity
{
  private static FullMessageSearchResult.SearchResultItem a;
  protected CancelReceiver a;
  private FullMessageSearchResult.SearchResultItem b;
  
  public static void a(Context paramContext, String paramString, FullMessageSearchResult.SearchResultItem paramSearchResultItem)
  {
    jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem = paramSearchResultItem;
    paramSearchResultItem = new Intent(paramContext, MessageSearchDetailActivity.class);
    paramSearchResultItem.putExtra("keyword", paramString);
    paramContext.startActivity(paramSearchResultItem);
  }
  
  void b(String paramString1, String paramString2, TextView paramTextView)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MessageSearchDetailActivity", 2, "genDiscussTitle, name == null");
      }
      return;
    }
    int i = ((acdu)this.app.getManager(53)).cn(paramString2);
    if (i <= 0)
    {
      paramTextView.setText(paramString1);
      return;
    }
    int j = getResources().getDisplayMetrics().widthPixels;
    paramString2 = (RelativeLayout.LayoutParams)((View)paramTextView.getParent()).getLayoutParams();
    int k = wja.dp2px(207.0F, getResources());
    TextPaint localTextPaint = paramTextView.getPaint();
    float f2 = j - k - localTextPaint.measureText(String.format("(%d人)", new Object[] { Integer.valueOf(i) })) - 4.0F * getResources().getDisplayMetrics().density;
    String str = paramString1;
    float f1;
    float f3;
    if (f2 > 0.0F)
    {
      f1 = localTextPaint.measureText(paramString1);
      str = paramString1;
      if (f1 > f2)
      {
        f3 = f2 - localTextPaint.measureText("…");
        paramString2 = paramString1;
      }
    }
    for (;;)
    {
      if ((f3 > 0.0F) && (f1 > f3) && (paramString2.length() > 0))
      {
        paramString2 = paramString2.substring(0, paramString2.length() - 1);
        f2 = localTextPaint.measureText(paramString2);
        f1 = f2;
        if (f2 == 0.0F)
        {
          f1 = f2;
          if (paramString2.length() > 0) {
            f1 = 1.0F + f3;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("MessageSearchDetailActivity", 2, "genDiscussTitle : name widht = " + f1);
        }
      }
      else
      {
        str = paramString1;
        if (f3 > 0.0F)
        {
          str = paramString1;
          if (paramString2.length() > 0) {
            str = paramString2 + "…";
          }
        }
        paramTextView.setText(String.format("%s(%d人)", new Object[] { str, Integer.valueOf(i) }));
        return;
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.b = jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchResult$SearchResultItem;
    if (this.b == null)
    {
      finish();
      return false;
    }
    super.setContentView(2131559029);
    if (this.b.user.getType() == 3000) {
      b(aqgv.d(this.app, this.b.user.uin, this.b.user.getType()), this.b.user.uin, this.centerView);
    }
    for (;;)
    {
      Object localObject = super.getSupportFragmentManager();
      paramBundle = MessageSearchDetailFragment.a(getIntent().getStringExtra("keyword"), this.b);
      localObject = ((FragmentManager)localObject).beginTransaction();
      ((FragmentTransaction)localObject).replace(2131365379, paramBundle);
      ((FragmentTransaction)localObject).commit();
      this.jdField_a_of_type_ComTencentMobileqqSearchActivityMessageSearchDetailActivity$CancelReceiver = new CancelReceiver();
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq.search.cancel");
      super.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqSearchActivityMessageSearchDetailActivity$CancelReceiver, paramBundle);
      return true;
      super.setTitle(aqgv.d(this.app, this.b.user.uin, this.b.user.getType()));
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqSearchActivityMessageSearchDetailActivity$CancelReceiver != null)
    {
      super.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqSearchActivityMessageSearchDetailActivity$CancelReceiver);
      this.jdField_a_of_type_ComTencentMobileqqSearchActivityMessageSearchDetailActivity$CancelReceiver = null;
    }
  }
  
  public class CancelReceiver
    extends BroadcastReceiver
  {
    public CancelReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("com.tencent.mobileqq.search.cancel".equals(paramIntent.getAction())) {
        MessageSearchDetailActivity.this.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.MessageSearchDetailActivity
 * JD-Core Version:    0.7.0.1
 */