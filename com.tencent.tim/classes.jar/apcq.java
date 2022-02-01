import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

public class apcq
  extends agku
{
  long TroopUin;
  QQAppInterface app;
  accd e = null;
  apcy f;
  
  public apcq(QQAppInterface paramQQAppInterface, long paramLong, apcy paramapcy)
  {
    this.app = paramQQAppInterface;
    this.f = paramapcy;
    this.TroopUin = paramLong;
    ix();
  }
  
  private void ix()
  {
    this.e = new apcr(this);
    this.app.addObserver(this.e);
  }
  
  public int Em()
  {
    return 3;
  }
  
  public boolean alr()
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.app, this.TroopUin);
    if (localTroopFileTransferManager == null) {
      return false;
    }
    if (this.f.Id != null) {
      localTroopFileTransferManager.e(this.f.Id);
    }
    for (;;)
    {
      return true;
      localTroopFileTransferManager.i(this.f.FilePath, this.f.FileName, this.f.BusId);
    }
  }
  
  public void clear()
  {
    if (this.e != null) {
      this.app.removeObserver(this.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apcq
 * JD-Core Version:    0.7.0.1
 */