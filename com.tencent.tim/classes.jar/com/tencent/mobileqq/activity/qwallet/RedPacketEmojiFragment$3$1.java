package com.tencent.mobileqq.activity.qwallet;

import android.text.TextUtils;
import axcd;
import axce;
import com.tencent.qphone.base.util.QLog;
import zyq;

public class RedPacketEmojiFragment$3$1
  implements Runnable
{
  public RedPacketEmojiFragment$3$1(zyq paramzyq, boolean paramBoolean, axcd paramaxcd) {}
  
  public void run()
  {
    if ((this.buz) && (this.jdField_a_of_type_Axcd != null))
    {
      String str = axce.a(this.jdField_a_of_type_Axcd);
      if (QLog.isColorLevel()) {
        QLog.i("RedPacketEmojiFragment", 2, "[doLoading] onAEDownloadFinish unzipPath=" + str);
      }
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Zyq.a.bbp = str;
        this.jdField_a_of_type_Zyq.a.csy();
        return;
      }
    }
    this.jdField_a_of_type_Zyq.a.csz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment.3.1
 * JD-Core Version:    0.7.0.1
 */