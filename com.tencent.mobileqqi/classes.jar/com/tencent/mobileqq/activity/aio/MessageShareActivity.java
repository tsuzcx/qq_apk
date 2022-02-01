package com.tencent.mobileqq.activity.aio;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class MessageShareActivity
  extends BaseActivity
  implements Handler.Callback, Runnable
{
  protected static final int a = 1;
  protected static final String a = "MessageShareActivity";
  protected static final int b = 2;
  protected static final int c = 3;
  protected Dialog a;
  protected Bundle a;
  protected final Handler a;
  
  public MessageShareActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidOsBundle = null;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      throw new IllegalArgumentException();
    }
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    super.doOnDestroy();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
      int i = this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", -1);
      switch (i)
      {
      default: 
        return true;
      }
      long l = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
      paramMessage = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
      this.jdField_a_of_type_AndroidOsBundle.putLong("res_share_id", l);
      this.jdField_a_of_type_AndroidOsBundle.putString("res_pkg_name", paramMessage);
      this.jdField_a_of_type_AndroidOsBundle.putString("res_detail_url", str);
      paramMessage = new Intent(this, ChatActivity.class);
      str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      int j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
      l = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
      if (i == 11)
      {
        localObject = new Intent();
        ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(l), "shareToQQ" })));
        paramMessage.putExtra("activity_finish_run_pendingIntent", PendingIntent.getActivity(this, 0, (Intent)localObject, 268435456));
      }
      Object localObject = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
      if (localObject != null)
      {
        if ((localObject instanceof StructMsgForImageShare)) {
          StructMsgForImageShare.sendAndUploadImageShare(this.b, (StructMsgForImageShare)localObject, str, j);
        }
        paramMessage.putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject).getBytes());
        paramMessage.setFlags(67108864);
        paramMessage.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        startActivity(paramMessage);
      }
      finish();
      return true;
    case 2: 
      ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131232068)).setText(getApplicationContext().getResources().getString(2131558927));
      this.jdField_a_of_type_AndroidAppDialog.findViewById(2131232067).setVisibility(4);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 800L);
      return true;
    }
    finish();
    return true;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(new View(this));
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624405);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903319);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131232068)).setText(2131562664);
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      handleMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1));
      return;
    }
    QLog.d("MessageShareActivity", 2, "getExtras() is null !!!!!");
    this.jdField_a_of_type_AndroidAppDialog.show();
    handleMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2));
  }
  
  public void run()
  {
    try
    {
      d();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 333L);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MessageShareActivity", 2, "doShare() cause exception !!!!!");
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 333L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MessageShareActivity
 * JD-Core Version:    0.7.0.1
 */