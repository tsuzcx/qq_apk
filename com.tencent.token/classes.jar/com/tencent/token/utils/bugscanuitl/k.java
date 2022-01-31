package com.tencent.token.utils.bugscanuitl;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class k
  implements View.OnClickListener
{
  k(DetectActivity paramDetectActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a.getApplicationContext(), ResultListActivity.class);
    paramView.putExtra("result", this.a.result);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.bugscanuitl.k
 * JD-Core Version:    0.7.0.1
 */