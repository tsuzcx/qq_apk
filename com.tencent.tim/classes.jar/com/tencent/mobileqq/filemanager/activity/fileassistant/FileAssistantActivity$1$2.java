package com.tencent.mobileqq.filemanager.activity.fileassistant;

import acfp;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

class FileAssistantActivity$1$2
  implements Runnable
{
  FileAssistantActivity$1$2(FileAssistantActivity.1 param1) {}
  
  public void run()
  {
    this.a.this$0.I = ((ViewStub)this.a.this$0.findViewById(2131382101));
    View localView = this.a.this$0.I.inflate();
    this.a.this$0.I.setVisibility(0);
    ((TextView)localView.findViewById(2131380973)).setText(acfp.m(2131706205));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.1.2
 * JD-Core Version:    0.7.0.1
 */