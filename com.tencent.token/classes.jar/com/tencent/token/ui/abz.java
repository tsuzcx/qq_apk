package com.tencent.token.ui;

import com.tencent.token.ui.base.TitleOptionMenu;

class abz
  implements Runnable
{
  abz(UtilsActivity paramUtilsActivity) {}
  
  public void run()
  {
    this.a.setRightTitleImage(2130837618, UtilsActivity.access$1700(this.a));
    UtilsActivity.access$302(this.a, this.a.getDialogMenu());
    if (UtilsActivity.access$300(this.a) != null) {
      UtilsActivity.access$300(this.a).setDisplayMode(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abz
 * JD-Core Version:    0.7.0.1
 */