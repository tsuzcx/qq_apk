import android.graphics.Bitmap;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity.a;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public class aowl
  implements TroopCreateLogicActivity.a
{
  public aowl(TroopCreateLogicActivity paramTroopCreateLogicActivity, String paramString1, String paramString2, String paramString3) {}
  
  public void ah(Bitmap paramBitmap)
  {
    WXShareHelper.a().a(this.a.b);
    WXShareHelper.a().b(this.a.Qt, this.val$name, paramBitmap, this.val$desc, this.cnm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aowl
 * JD-Core Version:    0.7.0.1
 */