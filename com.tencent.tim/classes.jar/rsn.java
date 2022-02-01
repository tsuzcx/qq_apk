import android.content.Context;

public class rsn
{
  protected auws a;
  protected boolean aJC;
  protected int bnB = 5;
  protected rsn.a c;
  Context mContext;
  
  public rsn(auws paramauws, Context paramContext)
  {
    this.a = paramauws;
    this.mContext = paramContext;
  }
  
  public void ax(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.aJC) {
      return;
    }
    if (!paramBoolean1)
    {
      this.a.eW(5);
      return;
    }
    if (paramBoolean2) {}
    for (int i = 3;; i = 4)
    {
      this.a.eW(i);
      if ((!this.a.eO(i)) || (this.c == null)) {
        break;
      }
      this.c.aXi();
      return;
    }
  }
  
  public void setOnLoadMoreListener(rsn.a parama)
  {
    this.c = parama;
    if (parama != null)
    {
      uh(true);
      ax(true, false);
    }
    this.a.setOnClickListener(new rso(this));
  }
  
  public int tV()
  {
    return this.bnB;
  }
  
  public void uh(boolean paramBoolean)
  {
    if (this.aJC == paramBoolean) {
      return;
    }
    this.aJC = paramBoolean;
    if (paramBoolean)
    {
      this.a.eW(3);
      return;
    }
    this.a.eW(0);
  }
  
  public void ui(boolean paramBoolean)
  {
    if (!this.aJC) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while ((this.a.getState() == 0) || (!this.a.eO(2)));
      bool = true;
      if (this.c != null) {
        bool = this.c.R(paramBoolean);
      }
    } while (!bool);
    this.a.eW(2);
  }
  
  public static abstract interface a
  {
    public abstract boolean R(boolean paramBoolean);
    
    public abstract void aXi();
  }
  
  public static abstract class b
    implements rsn.a
  {
    public void aXi() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rsn
 * JD-Core Version:    0.7.0.1
 */