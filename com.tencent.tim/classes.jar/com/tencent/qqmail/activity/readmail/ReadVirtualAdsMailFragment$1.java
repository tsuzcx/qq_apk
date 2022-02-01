package com.tencent.qqmail.activity.readmail;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.qqmail.utilities.ui.QMImageButton;

class ReadVirtualAdsMailFragment$1
  implements View.OnTouchListener
{
  ReadVirtualAdsMailFragment$1(ReadVirtualAdsMailFragment paramReadVirtualAdsMailFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (ImageView)paramView;
    if (paramView.isEnabled()) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return false;
      paramView.setAlpha(QMImageButton.mOpacityPressed);
      continue;
      paramView.setAlpha(QMImageButton.mOpacityNormal);
      if (!paramView.isPressed()) {
        paramView.setAlpha(QMImageButton.mOpacityNormal);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadVirtualAdsMailFragment.1
 * JD-Core Version:    0.7.0.1
 */