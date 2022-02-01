package com.tencent.mobileqq.imaxad;

import aibc;
import aibg;
import com.tencent.mobileqq.app.QQAppInterface;
import jxc;

public class ImaxAdDeleteManager$1
  implements Runnable
{
  public void run()
  {
    jxc localjxc2 = this.b;
    jxc localjxc1 = localjxc2;
    if (localjxc2 == null) {
      localjxc1 = jxc.a(aibg.bf(this.val$app.getCurrentUin(), this.val$uin));
    }
    aibc.a(this.val$app.getCurrentUin(), localjxc1, this.val$uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdDeleteManager.1
 * JD-Core Version:    0.7.0.1
 */