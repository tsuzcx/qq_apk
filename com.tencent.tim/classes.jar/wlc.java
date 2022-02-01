import android.content.Context;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public final class wlc
  implements ahal.a
{
  public wlc(ArrayList paramArrayList, Context paramContext, int paramInt1, QQAppInterface paramQQAppInterface, String paramString1, int paramInt2, String paramString2) {}
  
  public void aD()
  {
    Iterator localIterator = this.qd.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Uri)localIterator.next();
      localObject = ahhm.b(this.val$mContext, (Uri)localObject);
      if (this.bPa == 1) {
        this.val$app.a().a((String)localObject, this.val$uin, 0L, this.bES);
      } else {
        this.val$app.a().a((String)localObject, this.aSR, this.val$uin, this.bPa, true, 0L, this.bES);
      }
    }
  }
  
  public void aE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wlc
 * JD-Core Version:    0.7.0.1
 */