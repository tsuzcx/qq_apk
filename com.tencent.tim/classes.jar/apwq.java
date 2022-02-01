import android.os.Bundle;
import com.tencent.mobileqq.highway.transaction.Transaction;

public class apwq
  extends apwr
{
  public apwq(apwo paramapwo, int paramInt)
  {
    super(paramapwo, paramInt);
  }
  
  public void ecw()
  {
    if (this.b != null) {
      this.b.cancelTransaction();
    }
  }
  
  public void ecx()
  {
    if (rc(this.a.filePath)) {
      return;
    }
    onFailed();
  }
  
  public void ecy()
  {
    if (this.cST) {
      ecz();
    }
  }
  
  public void ecz()
  {
    boolean bool = true;
    Bundle localBundle = new Bundle();
    localBundle.putInt("isVideo", 0);
    if (this.picUrl != null)
    {
      localBundle.putInt("result", 1);
      localBundle.putString("url", this.picUrl);
    }
    for (;;)
    {
      apwp.a().b(bool, this.callbackId, localBundle);
      return;
      localBundle.putInt("result", 0);
      localBundle.putString("error", "");
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apwq
 * JD-Core Version:    0.7.0.1
 */