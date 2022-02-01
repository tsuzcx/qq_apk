import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.3;

public class apdn
  implements anyk.c
{
  public apdn(TroopEnterEffectController.3 param3, QQAppInterface paramQQAppInterface) {}
  
  public Bitmap a(anxy paramanxy, String paramString1, String paramString2)
  {
    if (paramString2.equals("$AVATAR$"))
    {
      paramString1 = aqdj.g(1, 1);
      paramanxy = aqdj.a(this.val$app, 1, this.a.a.uin, 1, paramString1, paramString1, new apdo(this, paramanxy));
    }
    do
    {
      try
      {
        paramString1 = apuh.f(paramanxy);
        return paramString1;
      }
      catch (OutOfMemoryError paramanxy)
      {
        return null;
      }
      if (!paramString2.equals("$SVIP$")) {
        break;
      }
      paramString1 = apdj.a(apdj.cou + this.a.a.id, this.a.a);
      paramanxy = paramString1;
      if (paramString1 == null) {
        paramanxy = apdj.a(apdj.AZ(), this.a.a);
      }
      paramString1 = paramanxy;
    } while (paramanxy != null);
    return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    try
    {
      paramanxy = aqhu.d(paramString1 + "/" + paramString2, null);
      return paramanxy;
    }
    catch (OutOfMemoryError paramanxy) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apdn
 * JD-Core Version:    0.7.0.1
 */