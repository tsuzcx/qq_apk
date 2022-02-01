import android.graphics.Bitmap;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity.a;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public class aowm
  implements TroopCreateLogicActivity.a
{
  public aowm(TroopCreateLogicActivity paramTroopCreateLogicActivity, String paramString1, String paramString2, String paramString3) {}
  
  public void ah(Bitmap paramBitmap)
  {
    WXShareHelper.a().a(this.a.b);
    WXShareHelper.a().a(this.a.Qt, this.val$title, paramBitmap, this.cnn, this.cnm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aowm
 * JD-Core Version:    0.7.0.1
 */