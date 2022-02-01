package com.dataline.activities;

import acqp;
import android.content.Context;
import android.text.ClipboardManager;
import ao;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import db;

public class LiteActivity$27$7
  implements Runnable
{
  public LiteActivity$27$7(ao paramao, String paramString, int paramInt) {}
  
  public void run()
  {
    this.a.this$0.jdField_a_of_type_Db.notifyDataSetChanged();
    try
    {
      ((ClipboardManager)this.a.this$0.mListView.getContext().getSystemService("clipboard")).setText(this.aV);
      label41:
      LiteActivity.a(this.a.this$0.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.a.this$0.mListView);
      LiteActivity.a(this.a.this$0.mListView);
      this.a.this$0.app.b().a(this.cX).cNX();
      return;
    }
    catch (Exception localException)
    {
      break label41;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.27.7
 * JD-Core Version:    0.7.0.1
 */