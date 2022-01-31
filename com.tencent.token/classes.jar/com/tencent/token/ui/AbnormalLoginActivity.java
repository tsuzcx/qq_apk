package com.tencent.token.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class AbnormalLoginActivity
  extends BaseActivity
{
  private b mAdapter;
  private ListView mListView;
  
  static
  {
    if (!AbnormalLoginActivity.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    this.mListView = ((ListView)findViewById(2131296262));
    assert (this.mListView != null);
    this.mAdapter = new b(this);
    this.mListView.setScrollingCacheEnabled(true);
    this.mListView.setAdapter(this.mAdapter);
    findViewById(2131296264).setOnClickListener(new a(this));
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