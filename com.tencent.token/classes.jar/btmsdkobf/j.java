package btmsdkobf;

import android.database.ContentObserver;

public class j
  extends ContentObserver
{
  private String af;
  private int ag;
  private i ah;
  
  public j(i parami, int paramInt, String paramString)
  {
    super(null);
    this.ah = parami;
    this.ag = paramInt;
    this.af = paramString;
  }
  
  public void onChange(boolean paramBoolean)
  {
    i locali = this.ah;
    if (locali != null) {
      locali.b(this.ag, this.af);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.j
 * JD-Core Version:    0.7.0.1
 */