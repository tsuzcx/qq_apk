package btmsdkobf;

import android.database.ContentObserver;
import android.util.Log;

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
    if (this.ah != null)
    {
      this.ah.b(this.ag, this.af);
      return;
    }
    Log.e("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.j
 * JD-Core Version:    0.7.0.1
 */