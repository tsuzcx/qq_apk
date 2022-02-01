import android.content.Context;
import android.content.Intent;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public abstract class auin
  extends augv
  implements auhk.f
{
  protected auhk.g a;
  protected Context mContext;
  
  public auin(Context paramContext, QQAppInterface paramQQAppInterface, auhk.g paramg)
  {
    super(paramQQAppInterface, paramg);
    this.a = paramg;
    this.mContext = paramContext;
  }
  
  public abstract boolean aJq();
  
  public abstract boolean aJr();
  
  public abstract boolean aJs();
  
  public abstract void aaK(int paramInt);
  
  public abstract void aaL(int paramInt);
  
  public void aaN(int paramInt) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public List<atiu> hk()
  {
    return null;
  }
  
  public abstract List<auin.a> hl();
  
  public boolean isComplete()
  {
    return false;
  }
  
  public abstract View.OnClickListener x();
  
  public class a
  {
    public int erE;
    public int tabIndex;
    
    public a(int paramInt1, int paramInt2)
    {
      this.tabIndex = paramInt1;
      this.erE = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auin
 * JD-Core Version:    0.7.0.1
 */