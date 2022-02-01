package com.tencent.qqmail.view;

import android.content.Context;
import android.view.View;
import com.tencent.qqmail.utilities.ui.QMImageButton;

class QMBottomBar$2
  extends QMImageButton
{
  QMBottomBar$2(QMBottomBar paramQMBottomBar, Context paramContext)
  {
    super(paramContext);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    ((View)getParent()).setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMBottomBar.2
 * JD-Core Version:    0.7.0.1
 */