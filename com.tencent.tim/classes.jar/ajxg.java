import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.1.2.1;

public class ajxg
  implements ajxd.a
{
  ajxg(ajxe paramajxe) {}
  
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean) {
      ThreadManagerV2.excute(new ShortVideoShareUtil.1.2.1(this, (ajpj)this.a.val$app.getManager(106)), 16, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajxg
 * JD-Core Version:    0.7.0.1
 */