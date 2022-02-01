package com.tencent.mobileqq.filemanager.fileviewer;

import agmy;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;

class FileBrowserActivity$4
  implements Runnable
{
  FileBrowserActivity$4(FileBrowserActivity paramFileBrowserActivity, String paramString) {}
  
  public void run()
  {
    int i = FileBrowserActivity.a(this.this$0).getMeasuredWidth();
    String str2 = (String)TextUtils.ellipsize(this.bIU, FileBrowserActivity.a(this.this$0).getPaint(), i - 15, TextUtils.TruncateAt.END);
    String str1 = str2;
    if (str2.length() > 2)
    {
      str1 = str2;
      if (str2.substring(str2.length() - 1).equals(agmy.bIi)) {
        str1 = str2.substring(0, str2.length() - 1) + agmy.UU;
      }
    }
    FileBrowserActivity.a(this.this$0).setText(str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity.4
 * JD-Core Version:    0.7.0.1
 */