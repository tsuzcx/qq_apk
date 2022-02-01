package com.tencent.token.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.token.aay;
import com.tencent.token.yo;

public class AbnormalLoginActivity
  extends BaseActivity
{
  private yo mAdapter;
  private ListView mListView;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296283);
    this.mListView = ((ListView)findViewById(2131165774));
    this.mAdapter = new yo(this);
    this.mListView.setScrollingCacheEnabled(true);
    this.mListView.setAdapter(this.mAdapter);
    findViewById(2131165191).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        aay.a(AbnormalLoginActivity.this);
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