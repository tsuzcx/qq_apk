import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class atuf
  extends atsy
{
  private atsn e = new atug(this);
  
  public atuf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    paramQQAppInterface.a().addObserver(this.e);
  }
  
  private atuf.a a(long paramLong, boolean paramBoolean)
  {
    atsy.a locala = a(paramLong);
    if (locala == null) {
      return null;
    }
    if ((locala instanceof atuf.a)) {
      return (atuf.a)locala;
    }
    QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] getSession  ID[" + paramLong + "] no instance");
    return null;
  }
  
  public void a(long paramLong, aqog paramaqog)
  {
    paramaqog.busiType = 0;
  }
  
  public void a(long paramLong, atuq.a parama) {}
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, atuq.a parama)
  {
    atuf.a locala = a(paramLong, false);
    if (locala == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      locala.h.strLargeThumPath = paramString;
      audx.K(locala.h);
      this.app.a().u(locala.h);
    }
    this.app.a().b(paramBoolean, 50, new Object[] { locala.h, Integer.valueOf(locala.videoSize) });
    super.a(paramLong, paramBoolean, paramInt, paramString, parama);
  }
  
  public boolean a(long paramLong, atuq.a parama)
  {
    parama = a(paramLong, false);
    if (parama == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    this.app.a().m(parama.h.Uuid, parama.h.fileIdCrc, paramLong);
    return true;
  }
  
  public String b(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (paramFileManagerEntity.Uuid == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  download. uuid = null nSession[" + paramFileManagerEntity.nSessionId + "]");
      this.app.a().b(false, 50, new Object[] { paramFileManagerEntity });
      return null;
    }
    int i = cT(paramFileManagerEntity.fileName);
    if (-1 == i)
    {
      this.app.a().b(false, 50, new Object[] { paramFileManagerEntity });
      return null;
    }
    dhg();
    Object localObject1 = paramFileManagerEntity.Uuid.replace("/", "");
    Object localObject2 = audn.a().wb() + C(paramInt, (String)localObject1);
    localObject1 = localObject2;
    if (!aueh.fileExistsAndNotEmpty((String)localObject2))
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5)) {
        localObject1 = audn.a().wb() + C(paramInt, atad.toMD5(paramFileManagerEntity.strFileMd5));
      }
    }
    if (aqhq.fileExistsAndNotEmpty((String)localObject1) == true)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + (String)localObject1);
      return localObject1;
    }
    localObject2 = new atuf.a(paramFileManagerEntity);
    ((atuf.a)localObject2).videoSize = paramInt;
    ((atuf.a)localObject2).videoType = i;
    a((atsy.a)localObject2, (String)localObject1);
    QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + ((atuf.a)localObject2).sessionid + "]");
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
 * Qualified Name:     atuf
 * JD-Core Version:    0.7.0.1
 */