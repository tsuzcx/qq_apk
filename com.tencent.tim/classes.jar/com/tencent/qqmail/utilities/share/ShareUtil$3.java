package com.tencent.qqmail.utilities.share;

import com.tencent.qqmail.utilities.ui.QMShareFileDialogHelper.ShareFilter;

final class ShareUtil$3
  implements QMShareFileDialogHelper.ShareFilter
{
  public boolean filter(String paramString)
  {
    return (paramString.equals("com.tencent.mm")) || (paramString.equals("com.tencent.mobileqq")) || (paramString.equals("com.tencent.wework"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.share.ShareUtil.3
 * JD-Core Version:    0.7.0.1
 */