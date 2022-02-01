package com.tencent.qqmail.activity.readmail;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.view.EditTextInWebView;
import moai.fragment.app.FragmentActivity;

class ReadMailFragment$116
  implements Runnable
{
  ReadMailFragment$116(ReadMailFragment paramReadMailFragment) {}
  
  @SuppressLint({"NewApi"})
  public void run()
  {
    synchronized (ReadMailFragment.access$17900(this.this$0))
    {
      if ((ReadMailFragment.access$17300(this.this$0) != null) && (ReadMailFragment.access$17300(this.this$0).getText() != null))
      {
        String str = ReadMailFragment.access$17300(this.this$0).getText().toString();
        this.this$0.getActivity().getSharedPreferences("quickreply", 0).edit().putString("" + ReadMailFragment.access$400(this.this$0), str).commit();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.116
 * JD-Core Version:    0.7.0.1
 */