package com.tencent.mobileqq.forward;

import ahgg.a;
import ahki;
import android.os.Bundle;
import arts;
import artv.b;
import com.tencent.mobileqq.app.QQAppInterface;

class ForwardSdkBaseOption$9$1
  implements Runnable
{
  ForwardSdkBaseOption$9$1(ForwardSdkBaseOption.9 param9) {}
  
  public void run()
  {
    this.a.this$0.ij(1004, ahgg.a.S.intValue());
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "84");
    localBundle.putString("intext_1", "" + artv.b.kK(this.a.this$0.cZW));
    localBundle.putString("intext_2", "" + artv.b.u(this.a.this$0.bf.getInt("uintype"), this.a.this$0.bf.getString("uin")));
    localBundle.putString("intext_3", "0");
    localBundle.putString("intext_4", "5");
    arts.a().a(localBundle, "", this.a.this$0.app.getCurrentAccountUin(), false, this.a.this$0.isSdkShare);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.9.1
 * JD-Core Version:    0.7.0.1
 */