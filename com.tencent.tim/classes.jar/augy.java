import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class augy
  extends augv
  implements auhk.a
{
  public auhk.b a;
  protected Bundle bundle = new Bundle();
  protected Context context;
  protected int epo;
  
  public augy(int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, auhk.b paramb)
  {
    super(paramQQAppInterface, paramb);
    this.context = paramContext;
    this.a = paramb;
    this.epo = paramInt;
  }
  
  protected void onDestroy()
  {
    if (this.a != null) {
      this.a.dismiss();
    }
  }
  
  public void setBundle(Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (;;)
    {
      this.bundle = paramBundle;
      return;
      paramBundle = new Bundle();
    }
  }
  
  public void show()
  {
    this.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     augy
 * JD-Core Version:    0.7.0.1
 */