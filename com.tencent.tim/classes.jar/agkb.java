import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agkb
  extends agjw
{
  private aghq c = new agkc(this);
  
  public agkb(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    paramQQAppInterface.a().addObserver(this.c);
  }
  
  private agkb.a a(long paramLong, boolean paramBoolean)
  {
    agjw.a locala = a(paramLong);
    if (locala == null) {
      return null;
    }
    if ((locala instanceof agkb.a)) {
      return (agkb.a)locala;
    }
    return null;
  }
  
  public List<String> a(long paramLong, String paramString, int paramInt)
  {
    Object localObject = a(paramLong, false);
    if ((localObject != null) && (((agkb.a)localObject).h != null) && (!TextUtils.isEmpty(paramString)) && (agke.a().l(this.app, 5)))
    {
      QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] discVideo thumb. is config enable IPv6. domain[" + paramString + "]");
      paramString = new agke.a(paramString, paramInt);
      localObject = agke.a().a(this.app, paramString, 5);
      if ((localObject != null) && (!((agke.c)localObject).alz()))
      {
        paramString = new ArrayList();
        localObject = ((agke.c)localObject).Bb.iterator();
        while (((Iterator)localObject).hasNext())
        {
          agke.b localb = (agke.b)((Iterator)localObject).next();
          paramString.add(localb.mIp + ":" + localb.mPort);
        }
        QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] discVideo thumb. use IPv6. hostlist:" + paramString.toString());
        return paramString;
      }
      QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] discVideo thumb. use IPv4:");
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
    agkb.a locala = a(paramLong, false);
    if (locala == null)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
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
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    this.app.a().n(parama.h.peerUin, parama.h.Uuid, paramLong);
    return true;
  }
  
  public String b(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
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
    str = ahaf.a().wb() + C(paramInt, str);
    if (aqhq.fileExistsAndNotEmpty(str) == true)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + str);
      return str;
    }
    agkb.a locala = new agkb.a(paramFileManagerEntity);
    locala.videoSize = paramInt;
    locala.videoType = i;
    a(locala, str);
    QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + locala.sessionid + "]");
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
 * Qualified Name:     agkb
 * JD-Core Version:    0.7.0.1
 */