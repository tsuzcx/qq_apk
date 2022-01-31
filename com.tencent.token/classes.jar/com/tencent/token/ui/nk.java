package com.tencent.token.ui;

import android.os.Message;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.token.global.h;
import org.json.JSONException;
import org.json.JSONObject;

class nk
  extends cb
{
  nk(LoginMsgChangePwdActivity paramLoginMsgChangePwdActivity)
  {
    super(paramLoginMsgChangePwdActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.dismissDialog();
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (paramMessage.arg1 == 0) {}
    try
    {
      paramMessage = new JSONObject((String)paramMessage.obj);
      LoginMsgChangePwdActivity.access$000(this.a).setText(paramMessage.getString("abnormal_login_btn_word"));
      LoginMsgChangePwdActivity.access$100(this.a).setText(paramMessage.getString("abnormal_login_big_word"));
      LoginMsgChangePwdActivity.access$200(this.a).setText(paramMessage.getString("abnormal_login_small_word"));
      this.a.setTitle(paramMessage.getString("abnormal_login_title"));
      h.c("test config: " + paramMessage);
      return;
    }
    catch (JSONException paramMessage)
    {
      paramMessage.printStackTrace();
      LoginMsgChangePwdActivity.access$000(this.a).setText(2131231162);
      LoginMsgChangePwdActivity.access$100(this.a).setText(2131231164);
      LoginMsgChangePwdActivity.access$200(this.a).setText(2131231163);
      return;
    }
    catch (Exception paramMessage)
    {
      for (;;)
      {
        paramMessage.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nk
 * JD-Core Version:    0.7.0.1
 */