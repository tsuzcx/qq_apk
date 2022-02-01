package com.tencent.tim.cloudfile.wps;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import atmw;
import aueh;

public class WpsFilePreviewFragment$1$3
  implements Runnable
{
  public WpsFilePreviewFragment$1$3(atmw paramatmw) {}
  
  public void run()
  {
    String str = WpsFilePreviewFragment.a(this.a.a).getContext().getString(2131694114) + "(" + aueh.g(WpsFilePreviewFragment.b(this.a.a)) + ")";
    WpsFilePreviewFragment.b(this.a.a).setVisibility(0);
    WpsFilePreviewFragment.a(this.a.a).setText(str);
    WpsFilePreviewFragment.a(this.a.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.wps.WpsFilePreviewFragment.1.3
 * JD-Core Version:    0.7.0.1
 */