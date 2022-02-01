package com.tencent.ttpic.videoshelf.ui;

import android.content.Context;
import android.content.ContextWrapper;

final class VideoShelfView$1
  extends ContextWrapper
{
  VideoShelfView$1(Context paramContext)
  {
    super(paramContext);
  }
  
  public Object getSystemService(String paramString)
  {
    if ("audio".equals(paramString)) {
      return getApplicationContext().getSystemService(paramString);
    }
    return super.getSystemService(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.ui.VideoShelfView.1
 * JD-Core Version:    0.7.0.1
 */