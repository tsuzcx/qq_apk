import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.1.1.1;

public class ajxf
  implements ajxd.a
{
  ajxf(ajxe paramajxe) {}
  
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean) {
      ThreadManagerV2.excute(new ShortVideoShareUtil.1.1.1(this, (ajpj)this.a.val$app.getManager(106)), 16, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajxf
 * JD-Core Version:    0.7.0.1
 */