package com.tencent.biz.publicAccountImageCollection;

import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

class PublicAccountImageCollectionMainActivity$9
  implements Runnable
{
  PublicAccountImageCollectionMainActivity$9(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = PublicAccountImageCollectionMainActivity.b(this.this$0);
    if (localTranslateAnimation != null)
    {
      this.this$0.ee.setVisibility(0);
      this.this$0.ee.findViewById(2131381403).setVisibility(0);
      this.this$0.ee.findViewById(2131381397).setVisibility(0);
      this.this$0.ee.findViewById(2131381398).setVisibility(0);
      this.this$0.ee.bringToFront();
      this.this$0.ee.startAnimation(localTranslateAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.9
 * JD-Core Version:    0.7.0.1
 */