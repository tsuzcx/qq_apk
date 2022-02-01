package com.tencent.av.share;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import ivc.b;

public class ShareChat$SharePanel$5
  implements Runnable
{
  public ShareChat$SharePanel$5(ivc.b paramb, QQAppInterface paramQQAppInterface, TroopInfoData paramTroopInfoData, Intent paramIntent, Context paramContext, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (this.val$app != null)
      {
        Bitmap localBitmap = this.val$app.a(this.b.troopUin, (byte)1, false, false);
        this.val$intent.putExtra("face", localBitmap);
      }
      this.val$context.startActivity(this.val$intent);
      return;
    }
    catch (Exception localException)
    {
      this.this$0.C(5, this.atW, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.5
 * JD-Core Version:    0.7.0.1
 */