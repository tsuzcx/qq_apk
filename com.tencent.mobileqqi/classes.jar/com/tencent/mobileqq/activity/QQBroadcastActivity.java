package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import dbf;
import dbg;
import java.util.Observer;

public class QQBroadcastActivity
  extends BaseSystemActivity
  implements Observer
{
  static final int jdField_a_of_type_Int = 1010;
  static final long jdField_a_of_type_Long = 1000L;
  public Handler a;
  public dbg a;
  
  public QQBroadcastActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new dbf(this);
  }
  
  private void d()
  {
    int i = 999;
    QQMessageFacade localQQMessageFacade = this.b.a();
    int j;
    if (localQQMessageFacade != null)
    {
      j = localQQMessageFacade.f();
      if (j <= 0) {
        break label79;
      }
      if (j <= 999) {
        break label99;
      }
    }
    for (;;)
    {
      c(getIntent().putExtra("leftViewText", getString(2131561807) + "(" + i + ")"));
      return;
      label79:
      c(getIntent().putExtra("leftViewText", getString(2131561807)));
      return;
      label99:
      i = j;
    }
  }
  
  public Cursor a()
  {
    return this.b.a(0).a(b(), 0);
  }
  
  protected CursorAdapter a()
  {
    if (this.jdField_a_of_type_Dbg == null) {
      this.jdField_a_of_type_Dbg = new dbg(this, this, this.b.a(0).a(b(), 0));
    }
    return this.jdField_a_of_type_Dbg;
  }
  
  protected CharSequence a()
  {
    return getString(2131562677);
  }
  
  protected void a()
  {
    d();
  }
  
  public String b()
  {
    return String.valueOf(AppConstants.W);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b.a().c(b(), 0);
    d();
    this.m.setVisibility(8);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Dbg != null) {
      this.jdField_a_of_type_Dbg.changeCursor(null);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBroadcastActivity
 * JD-Core Version:    0.7.0.1
 */