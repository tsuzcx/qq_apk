import android.content.Context;

public class auwt
{
  protected auws a;
  protected auwt.a a;
  protected boolean aJC;
  protected int bnB = 5;
  Context mContext;
  
  public auwt(auws paramauws, Context paramContext)
  {
    this.jdField_a_of_type_Auws = paramauws;
    this.mContext = paramContext;
  }
  
  public void a(auwt.a parama)
  {
    this.jdField_a_of_type_Auwt$a = parama;
    if (parama != null)
    {
      uh(true);
      ax(true, false);
    }
    this.jdField_a_of_type_Auws.setOnClickListener(new auwu(this));
  }
  
  public void abv(int paramInt)
  {
    this.bnB = paramInt;
  }
  
  public void ax(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.aJC) {
      return;
    }
    if (!paramBoolean1)
    {
      this.jdField_a_of_type_Auws.eW(5);
      return;
    }
    if (paramBoolean2) {}
    for (int i = 3;; i = 4)
    {
      this.jdField_a_of_type_Auws.eW(i);
      if ((!this.jdField_a_of_type_Auws.eO(i)) || (this.jdField_a_of_type_Auwt$a == null)) {
        break;
      }
      this.jdField_a_of_type_Auwt$a.aXi();
      return;
    }
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
      this.jdField_a_of_type_Auws.eW(3);
      return;
    }
    this.jdField_a_of_type_Auws.eW(0);
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
      } while ((this.jdField_a_of_type_Auws.getState() == 0) || (!this.jdField_a_of_type_Auws.eO(2)));
      bool = true;
      if (this.jdField_a_of_type_Auwt$a != null) {
        bool = this.jdField_a_of_type_Auwt$a.R(paramBoolean);
      }
    } while (!bool);
    this.jdField_a_of_type_Auws.eW(2);
  }
  
  public static abstract interface a
  {
    public abstract boolean R(boolean paramBoolean);
    
    public abstract void aXi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auwt
 * JD-Core Version:    0.7.0.1
 */