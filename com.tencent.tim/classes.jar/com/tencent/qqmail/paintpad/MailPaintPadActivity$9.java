package com.tencent.qqmail.paintpad;

import com.tencent.qqmail.utilities.ui.QMShareFileDialogHelper.ShareFilter;

class MailPaintPadActivity$9
  implements QMShareFileDialogHelper.ShareFilter
{
  MailPaintPadActivity$9(MailPaintPadActivity paramMailPaintPadActivity) {}
  
  public boolean filter(String paramString)
  {
    return (paramString.equals("com.tencent.mm")) || (paramString.equals("com.tencent.mobileqq")) || (paramString.equals("com.tencent.wework"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.paintpad.MailPaintPadActivity.9
 * JD-Core Version:    0.7.0.1
 */