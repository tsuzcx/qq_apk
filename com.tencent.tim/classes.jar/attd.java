import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class attd
  extends atsy
{
  private atsn e = new atte(this);
  
  public attd(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    paramQQAppInterface.a().addObserver(this.e);
  }
  
  private attd.a a(long paramLong, boolean paramBoolean)
  {
    atsy.a locala = a(paramLong);
    if (locala == null) {
      return null;
    }
    if ((locala instanceof attd.a)) {
      return (attd.a)locala;
    }
    return null;
  }
  
  public void a(long paramLong, aqog paramaqog)
  {
    paramaqog.busiType = 0;
  }
  
  public void a(long paramLong, atuq.a parama) {}
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, atuq.a parama)
  {
    attd.a locala = a(paramLong, false);
    if (locala == null)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      locala.h.strLargeThumPath = paramString;
      audx.K(locala.h);
      this.app.a().u(locala.h);
    }
    this.app.a().b(paramBoolean, 50, new Object[] { locala.h });
    super.a(paramLong, paramBoolean, paramInt, paramString, parama);
  }
  
  public boolean a(long paramLong, atuq.a parama)
  {
    parama = a(paramLong, false);
    if (parama == null)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    this.app.a().n(parama.h.peerUin, parama.h.Uuid, paramLong);
    return true;
  }
  
  public String b(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "]");
    if (paramFileManagerEntity.Uuid == null)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  download. uuid = null nSession[" + paramFileManagerEntity.nSessionId + "]");
      this.app.a().b(false, 50, new Object[] { paramFileManagerEntity });
      return null;
    }
    int i = cT(paramFileManagerEntity.fileName);
    if (-1 == i)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  download. can not getThumb of file:" + paramFileManagerEntity.fileName);
      this.app.a().b(false, 50, new Object[] { paramFileManagerEntity });
      return null;
    }
    String str = paramFileManagerEntity.Uuid.replace("/", "");
    dhg();
    str = audn.a().wb() + C(paramInt, str);
    if (aqhq.fileExistsAndNotEmpty(str) == true) {
      return str;
    }
    paramFileManagerEntity = new attd.a(paramFileManagerEntity);
    paramFileManagerEntity.videoSize = paramInt;
    paramFileManagerEntity.videoType = i;
    a(paramFileManagerEntity, str);
    return null;
  }
  
  public void b(long paramLong, atuq.a parama) {}
  
  public static class a
    extends atsy.a
  {
    int videoSize;
    int videoType;
    
    public a(FileManagerEntity paramFileManagerEntity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     attd
 * JD-Core Version:    0.7.0.1
 */