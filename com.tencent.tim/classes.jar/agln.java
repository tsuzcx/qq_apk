import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agln
  extends agjw
{
  private aghq c = new aglo(this);
  
  public agln(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    paramQQAppInterface.a().addObserver(this.c);
  }
  
  private agln.a a(long paramLong, boolean paramBoolean)
  {
    agjw.a locala = a(paramLong);
    if (locala == null) {
      return null;
    }
    if ((locala instanceof agln.a)) {
      return (agln.a)locala;
    }
    QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] getSession  ID[" + paramLong + "] no instance");
    return null;
  }
  
  public List<String> a(long paramLong, String paramString, int paramInt)
  {
    Object localObject = a(paramLong, false);
    if ((localObject != null) && (((agln.a)localObject).h != null) && (!TextUtils.isEmpty(paramString)) && (agke.a().l(this.app, 1)))
    {
      QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] offlineVideo thumb. is config enable IPv6. domain[" + paramString + "]");
      paramString = new agke.a(paramString, paramInt);
      localObject = agke.a().a(this.app, paramString, 1);
      if ((localObject != null) && (!((agke.c)localObject).alz()))
      {
        paramString = new ArrayList();
        localObject = ((agke.c)localObject).Bb.iterator();
        while (((Iterator)localObject).hasNext())
        {
          agke.b localb = (agke.b)((Iterator)localObject).next();
          paramString.add(localb.mIp + ":" + localb.mPort);
        }
        QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] offlineVideo thumb. use IPv6. hostlist:" + paramString.toString());
        return paramString;
      }
      QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] offlineVideo thumb. use IPv4");
    }
    return null;
  }
  
  public void a(long paramLong, agly.a parama) {}
  
  public void a(long paramLong, aqog paramaqog)
  {
    paramaqog.busiType = 0;
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, agly.a parama)
  {
    agln.a locala = a(paramLong, false);
    if (locala == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      locala.h.strLargeThumPath = paramString;
      ahav.K(locala.h);
      this.app.a().u(locala.h);
    }
    this.app.a().b(paramBoolean, 50, new Object[] { locala.h, Integer.valueOf(locala.videoSize) });
    super.a(paramLong, paramBoolean, paramInt, paramString, parama);
  }
  
  public boolean a(long paramLong, agly.a parama)
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
    Object localObject2 = ahaf.a().wb() + C(paramInt, (String)localObject1);
    localObject1 = localObject2;
    if (!ahbj.fileExistsAndNotEmpty((String)localObject2))
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5)) {
        localObject1 = ahaf.a().wb() + C(paramInt, atad.toMD5(paramFileManagerEntity.strFileMd5));
      }
    }
    if (aqhq.fileExistsAndNotEmpty((String)localObject1) == true)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + (String)localObject1);
      return localObject1;
    }
    localObject2 = new agln.a(paramFileManagerEntity);
    ((agln.a)localObject2).videoSize = paramInt;
    ((agln.a)localObject2).videoType = i;
    a((agjw.a)localObject2, (String)localObject1);
    QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + ((agln.a)localObject2).sessionid + "]");
    return null;
  }
  
  public void b(long paramLong, agly.a parama) {}
  
  public static class a
    extends agjw.a
  {
    int videoSize;
    int videoType;
    
    public a(FileManagerEntity paramFileManagerEntity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     agln
 * JD-Core Version:    0.7.0.1
 */