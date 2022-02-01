package com.dataline.activities;

import acqp;
import alkw;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import ao;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import db;

public class LiteActivity$27$8
  implements Runnable
{
  public LiteActivity$27$8(ao paramao, String paramString, int paramInt) {}
  
  public void run()
  {
    this.a.this$0.jdField_a_of_type_Db.notifyDataSetChanged();
    ClipboardManager localClipboardManager = (ClipboardManager)this.a.this$0.mListView.getContext().getSystemService("clipboard");
    ClipData localClipData = ClipData.newPlainText("msg", this.aV);
    alkw.a(localClipboardManager, localClipData);
    localClipboardManager.setPrimaryClip(localClipData);
    LiteActivity.a(this.a.this$0.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.a.this$0.mListView);
    LiteActivity.a(this.a.this$0.mListView);
    this.a.this$0.app.b().a(this.cX).cNX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.27.8
 * JD-Core Version:    0.7.0.1
 */