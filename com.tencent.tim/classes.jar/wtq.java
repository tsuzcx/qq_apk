import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.PatchedButton;
import dov.com.qq.im.ptv.AIOLongCaptureCtrl;

public class wtq
  implements wvs, wwf
{
  private BaseChatPie a;
  public AIOLongCaptureCtrl b;
  protected PatchedButton c;
  
  wtq(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public int[] C()
  {
    return new int[] { 0, 8 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.c = ((PatchedButton)this.a.mAIORootView.findViewById(2131381621));
      this.b = new AIOLongCaptureCtrl(new wtr(this));
      ayag.a(this.c, this.b);
      return;
    }
    ayag.b(this.c, this.b);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.b != null) {
      this.b.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wtq
 * JD-Core Version:    0.7.0.1
 */