import android.content.Context;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.haoliyou.JefsClass;
import java.lang.ref.WeakReference;

public class ahwg
  implements adwq
{
  public ahwg(JefsClass paramJefsClass, Runnable paramRunnable, WeakReference paramWeakReference, String paramString) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString1, String paramString2)
  {
    if ((!paramBoolean1) || ((paramBoolean2) && (this.gC != null)))
    {
      JefsClass.a(this.this$0, this.gC);
      return;
    }
    paramString1 = (Context)this.hb.get();
    if (paramString1 != null) {
      if ((paramString1 instanceof BaseActivity))
      {
        paramString1 = ((BaseActivity)paramString1).app;
        if (this.val$src != null) {
          break label111;
        }
      }
    }
    label111:
    for (paramString2 = "";; paramString2 = this.val$src)
    {
      anot.a(paramString1, "dc00898", "", "", "0X8009C5A", "0X8009C5A", 0, 0, "1", "", paramString2, "");
      return;
      paramString1 = null;
      break;
      paramString1 = null;
      break;
    }
  }
  
  public boolean afK()
  {
    return this.gC != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahwg
 * JD-Core Version:    0.7.0.1
 */