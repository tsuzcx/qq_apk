package com.tencent.token.utils.bugscanuitl;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

final class j
  implements View.OnClickListener
{
  j(DetectActivity paramDetectActivity) {}
  
  public final void onClick(View paramView)
  {
    if (DetectActivity.access$100(this.a)) {
      return;
    }
    DetectActivity.access$200(this.a).setVisibility(0);
    DetectActivity.access$200(this.a).setText(2131362727);
    DetectActivity.access$300(this.a).setImageResource(2130837878);
    DetectActivity.access$300(this.a).setVisibility(0);
    DetectActivity.access$400(this.a).setVisibility(0);
    DetectActivity.access$500(this.a).setVisibility(0);
    DetectActivity.access$000(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.bugscanuitl.j
 * JD-Core Version:    0.7.0.1
 */