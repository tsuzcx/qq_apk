import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class aphi
  implements apij.a
{
  public aphi(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void i(int paramInt1, int paramInt2, int paramInt3)
  {
    long l = apii.a(this.this$0.a, paramInt1, paramInt2, paramInt3) / 1000L;
    if (!PublishHomeWorkFragment.a(this.this$0, l))
    {
      apii.a(this.this$0.a, (apii)this.this$0.a.a());
      return;
    }
    this.this$0.arB = l;
    this.this$0.a.dismiss();
    this.this$0.aK.setRightText(this.this$0.Y(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aphi
 * JD-Core Version:    0.7.0.1
 */