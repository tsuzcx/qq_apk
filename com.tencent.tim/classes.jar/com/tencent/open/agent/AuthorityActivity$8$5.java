package com.tencent.open.agent;

import ahlw;
import android.graphics.Bitmap;
import android.os.Message;
import arpb;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;

public class AuthorityActivity$8$5
  implements Runnable
{
  public AuthorityActivity$8$5(arpb paramarpb, GetAppInfoProto.MsgIconsurl paramMsgIconsurl) {}
  
  public void run()
  {
    ahlw.Kj("KEY_GET_APP_ICON");
    Bitmap localBitmap = AuthorityActivity.P(this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$MsgIconsurl.url.get());
    ahlw.a("KEY_GET_APP_ICON", this.jdField_a_of_type_Arpb.this$0.jdField_a_of_type_Asav);
    this.jdField_a_of_type_Arpb.this$0.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.G(AuthorityActivity.cBq, localBitmap);
    if (localBitmap != null)
    {
      Message localMessage = new Message();
      localMessage.obj = localBitmap;
      localMessage.what = 4;
      this.jdField_a_of_type_Arpb.this$0.b.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity.8.5
 * JD-Core Version:    0.7.0.1
 */