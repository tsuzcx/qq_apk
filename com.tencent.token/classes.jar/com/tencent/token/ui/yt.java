package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.m;
import java.util.List;

class yt
  implements View.OnClickListener
{
  yt(SelectCountryCodeActivity paramSelectCountryCodeActivity) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = new Intent();
    paramView.putExtra("name", ((m)SelectCountryCodeActivity.access$100(this.a).get(i)).b());
    this.a.setResult(Integer.parseInt(((m)SelectCountryCodeActivity.access$100(this.a).get(i)).a()), paramView);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yt
 * JD-Core Version:    0.7.0.1
 */