package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.token.yc;
import com.tencent.token.yq;

public class AbnormalLoginActivity
  extends BaseActivity
{
  private yc mAdapter;
  private ListView mListView;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296283);
    this.mListView = ((ListView)findViewById(2131165757));
    this.mAdapter = new yc(this);
    this.mListView.setScrollingCacheEnabled(true);
    this.mListView.setAdapter(this.mAdapter);
    findViewById(2131165191).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(AbnormalLoginActivity.this, ModifyQQPwdActivity.class);
        yq.a().a(AbnormalLoginActivity.this, paramAnonymousView, yq.b);
      }
    });
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mAdapter = null;
    this.mListView.setAdapter(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.AbnormalLoginActivity
 * JD-Core Version:    0.7.0.1
 */