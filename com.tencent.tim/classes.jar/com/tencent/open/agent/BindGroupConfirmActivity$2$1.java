package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import arpv;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;

public class BindGroupConfirmActivity$2$1
  implements Runnable
{
  public BindGroupConfirmActivity$2$1(arpv paramarpv, GetAppInfoProto.MsgIconsurl paramMsgIconsurl) {}
  
  public void run()
  {
    Bitmap localBitmap = AuthorityActivity.P(this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$MsgIconsurl.url.get());
    if (localBitmap != null)
    {
      Message localMessage = new Message();
      localMessage.obj = localBitmap;
      localMessage.what = 4;
      this.jdField_a_of_type_Arpv.this$0.mHandler.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity.2.1
 * JD-Core Version:    0.7.0.1
 */