package com.tencent.mobileqq.troopshare;

import android.content.Intent;
import android.graphics.Bitmap;
import apzg;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class TroopShareUtility$9
  implements Runnable
{
  public TroopShareUtility$9(apzg paramapzg, QQAppInterface paramQQAppInterface, TroopInfoData paramTroopInfoData, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      Bitmap localBitmap = this.val$app.a(this.b.troopUin, (byte)1, false, false);
      this.val$intent.putExtra("face", localBitmap);
      this.this$0.a.startActivity(this.val$intent);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.9
 * JD-Core Version:    0.7.0.1
 */