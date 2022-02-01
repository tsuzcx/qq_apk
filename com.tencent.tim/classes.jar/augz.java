import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public abstract class augz
  extends augv
  implements auhk.e
{
  protected auhk.d a;
  protected Bundle bundle = new Bundle();
  protected Context context;
  
  public augz(QQAppInterface paramQQAppInterface, Context paramContext, auhk.d paramd)
  {
    super(paramQQAppInterface, paramd);
    this.context = paramContext;
    this.a = paramd;
  }
  
  public void nS(List<Object> paramList) {}
  
  protected void onDestroy()
  {
    if (this.a != null) {
      this.a.euU();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     augz
 * JD-Core Version:    0.7.0.1
 */