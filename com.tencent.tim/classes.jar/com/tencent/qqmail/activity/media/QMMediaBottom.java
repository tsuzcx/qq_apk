package com.tencent.qqmail.activity.media;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.media.QMAlbumManager.QMMediaIntentType;
import com.tencent.qqmail.utilities.thread.Threads;

public class QMMediaBottom
  extends FrameLayout
{
  public Button addButton;
  private Runnable hideDelay = new QMMediaBottom.1(this);
  private WindowManager windowManager;
  
  public QMMediaBottom(Context paramContext)
  {
    super(paramContext);
  }
  
  public QMMediaBottom(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QMMediaBottom(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static String getAddStringByIntentType(QMAlbumManager.QMMediaIntentType paramQMMediaIntentType)
  {
    int i;
    if (paramQMMediaIntentType == QMAlbumManager.QMMediaIntentType.QMMediaIntentType_PUSH) {
      i = 2131721600;
    }
    for (;;)
    {
      return QMApplicationContext.sharedInstance().getString(i);
      if (paramQMMediaIntentType == QMAlbumManager.QMMediaIntentType.QMMediaIntentType_NOTE) {
        i = 2131689806;
      } else if (paramQMMediaIntentType == QMAlbumManager.QMMediaIntentType.QMMediaIntentType_FTN) {
        i = 2131721609;
      } else if (paramQMMediaIntentType == QMAlbumManager.QMMediaIntentType.QMMediaIntentType_Merge) {
        i = 2131692048;
      } else if (paramQMMediaIntentType == QMAlbumManager.QMMediaIntentType.QMMediaIntentType_FEEDBACK) {
        i = 2131689701;
      } else {
        i = 2131689803;
      }
    }
  }
  
  private void showFloatedBottom()
  {
    if ((getParent() == null) && (this.windowManager != null))
    {
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
      localLayoutParams.height = getResources().getDimensionPixelSize(2131297366);
      localLayoutParams.width = -1;
      localLayoutParams.type = 2002;
      localLayoutParams.flags = 8;
      localLayoutParams.format = 1;
      localLayoutParams.gravity = 81;
      this.windowManager.addView(this, localLayoutParams);
    }
  }
  
  public void hideFloatedBottom(boolean paramBoolean)
  {
    if ((getParent() != null) && (this.windowManager != null)) {
      this.windowManager.removeView(this);
    }
    if (paramBoolean) {
      this.windowManager = null;
    }
  }
  
  public void init(Context paramContext)
  {
    this.addButton = ((Button)findViewById(2131362195));
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  public void showAndAutoHide()
  {
    showFloatedBottom();
    Threads.removeCallbackOnMain(this.hideDelay);
    Threads.runOnMainThread(this.hideDelay, 1000L);
  }
  
  public void updateAddButton(QMAlbumManager.QMMediaIntentType paramQMMediaIntentType, int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    paramQMMediaIntentType = getAddStringByIntentType(paramQMMediaIntentType);
    if (paramInt == 0) {
      this.addButton.setEnabled(false);
    }
    for (;;)
    {
      this.addButton.setText(paramQMMediaIntentType);
      return;
      paramQMMediaIntentType = paramQMMediaIntentType + "(" + paramInt + ")";
      this.addButton.setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.QMMediaBottom
 * JD-Core Version:    0.7.0.1
 */