package com.tencent.widget;

import autw;
import com.tencent.qphone.base.util.QLog;

public class KandianNegativeWindow$3
  implements Runnable
{
  public KandianNegativeWindow$3(autw paramautw, StringBuilder paramStringBuilder, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    this.ab.append("x:" + this.nK);
    this.ab.append("  y:" + this.nM);
    this.ab.append("  mTriangleHeight:" + this.this$0.etI);
    this.ab.append("  mScreenWidth:" + this.this$0.mScreenWidth);
    this.ab.append("  mTriangleHeight:" + this.this$0.mScreenHeight);
    this.ab.append("  mWindowWidth:" + this.this$0.mWindowWidth);
    this.ab.append("  mChildrenItemHeight:" + this.this$0.etK);
    this.ab.append("  isNormal:" + this.dkB);
    QLog.d("KandianNegativeWindow", 1, "calculatePosition," + this.ab.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.KandianNegativeWindow.3
 * JD-Core Version:    0.7.0.1
 */