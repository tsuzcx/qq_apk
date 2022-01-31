package com.tencent.token.ui;

import android.os.Message;
import android.widget.Button;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

final class oj
  extends bo
{
  oj(LoginMsgIpShareActivity paramLoginMsgIpShareActivity)
  {
    super(paramLoginMsgIpShareActivity);
  }
  
  public final void handleMessage(Message paramMessage)
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
      LoginMsgIpShareActivity.access$000(this.a).setText(paramMessage.getString("ip_share_btn_word"));
      LoginMsgIpShareActivity.access$100(this.a).setText(paramMessage.getString("ip_share_big_word"));
      LoginMsgIpShareActivity.access$200(this.a).setText(paramMessage.getString("ip_share_small_word"));
      this.a.setTitle(paramMessage.getString("ip_share_title"));
      return;
    }
    catch (JSONException paramMessage)
    {
      paramMessage.printStackTrace();
      LoginMsgIpShareActivity.access$000(this.a).setText(2131362055);
      LoginMsgIpShareActivity.access$100(this.a).setText(2131362053);
      LoginMsgIpShareActivity.access$200(this.a).setText(2131362054);
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
 * Qualified Name:     com.tencent.token.ui.oj
 * JD-Core Version:    0.7.0.1
 */