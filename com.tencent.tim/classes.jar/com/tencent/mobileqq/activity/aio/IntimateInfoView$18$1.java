package com.tencent.mobileqq.activity.aio;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import wll;
import wll.b;

class IntimateInfoView$18$1
  implements Runnable
{
  IntimateInfoView$18$1(IntimateInfoView.18 param18, Bitmap paramBitmap1, Bitmap paramBitmap2) {}
  
  @RequiresApi(api=16)
  public void run()
  {
    if ((wll.a(this.a.this$0) != null) && (wll.b.a(wll.a(this.a.this$0)) != null))
    {
      int i = wll.b.a(wll.a(this.a.this$0)).indexOf(this.a.a);
      RelativeLayout localRelativeLayout = (RelativeLayout)wll.a(this.a.this$0).getChild(i);
      if (localRelativeLayout != null)
      {
        ImageView localImageView = (ImageView)localRelativeLayout.findViewById(2131367693);
        if (this.dA != null) {
          localImageView.setImageBitmap(this.dA);
        }
        if (this.dB != null) {
          localRelativeLayout.setBackgroundDrawable(new BitmapDrawable(this.dB));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.18.1
 * JD-Core Version:    0.7.0.1
 */