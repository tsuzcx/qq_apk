package com.tencent.qqmail.view;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qqmail.QMApplicationContext;

public class AudioRecordingView
  extends FrameLayout
{
  private final int mKeyboardHeight;
  
  public AudioRecordingView(int paramInt)
  {
    super(QMApplicationContext.sharedInstance());
    paramInt = Math.max(paramInt, getResources().getDimensionPixelSize(2131299300));
    this.mKeyboardHeight = paramInt;
    addView(inflate(getContext(), 2131558758, null), new FrameLayout.LayoutParams(-1, paramInt));
  }
  
  private void adjustSpaces(int paramInt)
  {
    Object localObject1 = findViewById(2131376961);
    View localView = findViewById(2131376988);
    Object localObject2 = findViewById(2131376958);
    paramInt = paramInt - ((View)localObject1).getMeasuredHeight() - localView.getMeasuredHeight() - ((View)localObject2).getMeasuredHeight();
    localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(paramInt * 0.36F));
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).topMargin = ((int)(paramInt * 0.12F));
    ((LinearLayout.LayoutParams)localObject1).bottomMargin = ((int)(paramInt * 0.32F));
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      adjustSpaces(this.mKeyboardHeight);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.AudioRecordingView
 * JD-Core Version:    0.7.0.1
 */