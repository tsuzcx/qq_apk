package com.tencent.open.agent;

import ahlw;
import android.graphics.Bitmap;
import android.os.Message;
import arrq;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;
import svi.a;

public class OpenAuthorityFragment$8$4
  implements Runnable
{
  public OpenAuthorityFragment$8$4(arrq paramarrq, svi.a parama) {}
  
  public void run()
  {
    ahlw.Kj("KEY_GET_APP_ICON");
    Bitmap localBitmap = OpenAuthorityFragment.P(this.jdField_a_of_type_Svi$a.url.get());
    ahlw.a("KEY_GET_APP_ICON", OpenAuthorityFragment.a(this.jdField_a_of_type_Arrq.this$0));
    OpenAuthorityFragment.a(this.jdField_a_of_type_Arrq.this$0).G(OpenAuthorityFragment.a(this.jdField_a_of_type_Arrq.this$0), localBitmap);
    if (localBitmap != null)
    {
      Message localMessage = new Message();
      localMessage.obj = localBitmap;
      localMessage.what = 4;
      this.jdField_a_of_type_Arrq.this$0.b.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.8.4
 * JD-Core Version:    0.7.0.1
 */