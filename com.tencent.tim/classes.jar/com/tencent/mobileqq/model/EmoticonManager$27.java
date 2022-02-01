package com.tencent.mobileqq.model;

import ajdg;
import aqhq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import java.io.File;
import mqq.app.MobileQQ;

public class EmoticonManager$27
  implements Runnable
{
  public EmoticonManager$27(ajdg paramajdg, int paramInt, EmosmPb.SubCmd0x5RspBQRecommend paramSubCmd0x5RspBQRecommend) {}
  
  public void run()
  {
    aqhq.a(new File(this.this$0.app.getApplication().getFilesDir(), "recommemd_emotion_file__" + this.val$businessType + this.this$0.app.getCurrentUin()).getAbsolutePath(), this.c.toByteArray(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.27
 * JD-Core Version:    0.7.0.1
 */