package com.tencent.mobileqq.data;

import ActionMsg.MsgBody;
import android.content.Context;
import com.tencent.biz.widgets.PubAccountQQText;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MessageForText
  extends ChatMessage
{
  private static final boolean DEBUG_LOG = true;
  public static final int SPAN_TYPE_EMOJI = 1;
  public static final int SPAN_TYPE_LINK = 0;
  public static final int SPAN_TYPE_SYS_EMOTCATION = 2;
  private static final String TAG = "MessageForText";
  public String action;
  public ArrayList atInfoList;
  public String latitude;
  public String location;
  public URL locationUrl;
  public String longitude;
  public int msgVia;
  public CharSequence sb;
  public String url;
  
  protected void doParse()
  {
    Object localObject2 = this.msg;
    Object localObject1 = localObject2;
    if (this.msgtype == -1003)
    {
      localObject1 = ActionMsgUtil.a((String)localObject2);
      this.action = ((MsgBody)localObject1).action;
      localObject1 = ((MsgBody)localObject1).msg;
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    int i = ((String)localObject2).indexOf("http://maps.google.com/maps?q=");
    if (i != -1)
    {
      this.url = ((String)localObject2).substring(i);
      localObject1 = QQMessageFacade.a(this.url);
      this.latitude = localObject1[0];
      this.longitude = localObject1[1];
      this.location = localObject1[2];
      try
      {
        i = AIOUtils.a(200.0F, BaseApplication.getContext().getResources());
        int j = AIOUtils.a(100.0F, BaseApplication.getContext().getResources());
        localObject1 = new StringBuilder("http://st.map.soso.com/api");
        ((StringBuilder)localObject1).append("?size=").append(i).append("*").append(j);
        ((StringBuilder)localObject1).append("&center=").append(this.longitude).append(",").append(this.latitude);
        ((StringBuilder)localObject1).append("&zoom=14");
        ((StringBuilder)localObject1).append("&markers=").append(this.longitude).append(",").append(this.latitude).append(",").append("red");
        this.locationUrl = new URL(((StringBuilder)localObject1).toString());
        return;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        this.locationUrl = null;
        localMalformedURLException.printStackTrace();
        return;
      }
    }
    if (this.istroop == 1008)
    {
      this.sb = new PubAccountQQText((CharSequence)localObject2, 13);
      ((PubAccountQQText)this.sb).a = this.selfuin;
      ((PubAccountQQText)this.sb).b = this.frienduin;
      return;
    }
    this.sb = new QQText((CharSequence)localObject2, 13, 32, this.istroop);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForText
 * JD-Core Version:    0.7.0.1
 */