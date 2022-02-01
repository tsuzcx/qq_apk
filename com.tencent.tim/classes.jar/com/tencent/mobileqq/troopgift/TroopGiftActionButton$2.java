package com.tencent.mobileqq.troopgift;

import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import aptj;

class TroopGiftActionButton$2
  implements Runnable
{
  TroopGiftActionButton$2(TroopGiftActionButton paramTroopGiftActionButton, String paramString) {}
  
  public void run()
  {
    int i;
    if (this.this$0.mAnimationDrawable == null)
    {
      this.this$0.mAnimationDrawable = new AnimationDrawable();
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (i < 7) {
        localObject = String.format("%sInteractGiftButton/image_0%d.png", new Object[] { aptj.oS(this.crL), Integer.valueOf(i) });
      }
      try
      {
        this.this$0.mAnimationDrawable.addFrame(new BitmapDrawable(BitmapFactory.decodeFile((String)localObject)), 50);
        label82:
        i += 1;
        continue;
        this.this$0.EQ.setImageDrawable(this.this$0.mAnimationDrawable);
        this.this$0.mAnimationDrawable.setOneShot(true);
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        this.this$0.addView(this.this$0.EQ, (ViewGroup.LayoutParams)localObject);
        this.this$0.mAnimationDrawable.start();
        this.this$0.EQ.setVisibility(0);
        this.this$0.mHandler.postDelayed(new TroopGiftActionButton.2.1(this), 350L);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        break label82;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftActionButton.2
 * JD-Core Version:    0.7.0.1
 */