package com.tencent.mobileqq.confess;

import anot;
import com.tencent.mobileqq.app.QQAppInterface;

public final class TroopConfessUtil$1
  implements Runnable
{
  public TroopConfessUtil$1(QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  public void run()
  {
    int i;
    if (this.val$app != null)
    {
      if (this.val$app.getCurrentUin().equals(this.bxv))
      {
        i = 1;
        anot.a(this.val$app, "dc00898", "", "", "0X800956F", "0X800956F", i, 0, "", "", "", "");
      }
    }
    else {
      if (this.val$from != 1) {
        break label95;
      }
    }
    label95:
    for (String str = "0X8009302";; str = "0X8009303")
    {
      anot.a(this.val$app, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      return;
      i = 2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TroopConfessUtil.1
 * JD-Core Version:    0.7.0.1
 */