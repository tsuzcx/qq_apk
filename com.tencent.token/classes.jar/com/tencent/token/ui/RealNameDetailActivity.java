package com.tencent.token.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.token.ui.base.ScrollLayout;

public class RealNameDetailActivity
  extends Activity
{
  ImageView iv1;
  ImageView iv2;
  ImageView iv3;
  ImageView iv4;
  int tab;
  
  private void initview()
  {
    setContentView(2130903170);
    Object localObject = (ScrollLayout)findViewById(2131296436);
    ((ScrollLayout)localObject).a(this.tab);
    ((ScrollLayout)localObject).a(new uv(this));
    localObject = (Button)findViewById(2131296982);
    this.iv1 = ((ImageView)findViewById(2131296978));
    this.iv2 = ((ImageView)findViewById(2131296979));
    this.iv3 = ((ImageView)findViewById(2131296980));
    this.iv4 = ((ImageView)findViewById(2131296981));
    switch (this.tab)
    {
    }
    for (;;)
    {
      ((Button)localObject).setOnClickListener(new uw(this));
      return;
      this.iv1.setImageResource(2130837779);
      continue;
      this.iv2.setImageResource(2130837779);
      continue;
      this.iv3.setImageResource(2130837779);
      continue;
      this.iv4.setImageResource(2130837779);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    this.tab = getIntent().getIntExtra("index", 0);
    initview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameDetailActivity
 * JD-Core Version:    0.7.0.1
 */