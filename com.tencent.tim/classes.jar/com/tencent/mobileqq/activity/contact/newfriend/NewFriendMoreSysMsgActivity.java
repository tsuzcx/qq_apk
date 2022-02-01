package com.tencent.mobileqq.activity.contact.newfriend;

import abfd;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import ysf;
import ysm;

public class NewFriendMoreSysMsgActivity
  extends BaseActivity
{
  private abfd a;
  
  public static void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, NewFriendMoreSysMsgActivity.class);
    localIntent.putExtra("first_visible_index", paramInt2);
    paramActivity.startActivityForResult(localIntent, paramInt1);
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    int i = getIntent().getIntExtra("first_visible_index", 0);
    setContentView(2131561504);
    paramBundle = (LinearLayout)findViewById(2131377546);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    paramBundle = (SwipListView)findViewById(2131379116);
    View localView = findViewById(2131372405);
    TextView localTextView = (TextView)findViewById(2131369627);
    localTextView.setVisibility(0);
    localTextView.setText(2131696302);
    setTitle(getString(2131696302));
    localTextView = (TextView)findViewById(2131369579);
    localTextView.setVisibility(0);
    localTextView.setText("");
    localTextView.setOnClickListener(new ysm(this));
    localTextView = (TextView)findViewById(2131369612);
    localTextView.setVisibility(0);
    localTextView.setText(2131701777);
    this.a = new abfd(this, this.app, paramBundle, localView, localTextView, this.mFlingHandler, i);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ysf localysf = (ysf)this.app.getManager(34);
    localysf.clt();
    localysf.cly();
    this.a.onDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgActivity
 * JD-Core Version:    0.7.0.1
 */