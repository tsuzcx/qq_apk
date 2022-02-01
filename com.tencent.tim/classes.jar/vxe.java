import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.business.sougou.WordMatchManager.HotWordItem;
import com.tencent.mobileqq.business.sougou.WordMatchManager.c;
import com.tencent.mobileqq.widget.ContainerView;

public class vxe
  implements WordMatchManager.c
{
  public vxe(TextPreviewActivity paramTextPreviewActivity) {}
  
  public void a(int paramInt, WordMatchManager.HotWordItem[] paramArrayOfHotWordItem)
  {
    adym.a(this.this$0.app, this.this$0.textString, paramArrayOfHotWordItem);
    paramArrayOfHotWordItem = aqpm.a(this.this$0.textString, this.this$0.atInfoStr, 30, this.this$0.j, 13);
    if (this.this$0.a.cj(this.this$0))
    {
      this.this$0.F = paramArrayOfHotWordItem;
      return;
    }
    this.this$0.F = null;
    this.this$0.a.setText(paramArrayOfHotWordItem);
    this.this$0.bLj = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vxe
 * JD-Core Version:    0.7.0.1
 */