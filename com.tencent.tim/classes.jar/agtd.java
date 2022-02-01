import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class agtd
  extends agta
{
  private final String TAG = "VideoForDisc<QFile>";
  
  public agtd(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface, paramFileManagerEntity);
  }
  
  public void a(agkw.a parama)
  {
    this.c.nOpType = 1;
    this.mApp.a().a(this.c.nSessionId, this.c.fileName, Long.parseLong(this.c.peerUin), this.c.Uuid, new agte(this, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agtd
 * JD-Core Version:    0.7.0.1
 */