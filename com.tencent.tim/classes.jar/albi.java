import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PLUploadManager.1;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelPhoto;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class albi
  implements Manager
{
  Vector<albi.a> L = new Vector();
  public albi.b a;
  QQAppInterface app;
  private aook l = new albh(this, Looper.getMainLooper());
  MqqHandler q;
  
  public albi(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.l.addFilter(new Class[] { aomd.class });
    paramQQAppInterface.a().a(this.l);
    this.q = new MqqHandler(Looper.getMainLooper());
    if (QLog.isColorLevel()) {
      QLog.i("PLUploadManager", 2, "init this:" + this + " app:" + paramQQAppInterface + " handler:" + this.l);
    }
  }
  
  private albi.a a(CompressInfo paramCompressInfo, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    long l1 = System.currentTimeMillis() / 1000L;
    l1 = paramInt3 | l1 << 4;
    aool localaool = new aool();
    localaool.cNy = true;
    localaool.dQ = paramCompressInfo.srcPath;
    localaool.mUniseq = l1;
    localaool.mFileType = 56;
    Object localObject = new ime();
    int i = 56;
    while (i >= 0)
    {
      ((ime)localObject).WriteUInt8((byte)(int)(paramLong >>> i & 0xFF));
      i -= 8;
    }
    ((ime)localObject).WriteUInt32(paramInt2);
    ((ime)localObject).WriteUInt32(paramInt3);
    ((ime)localObject).WriteUInt32(0);
    ((ime)localObject).WriteUInt32(0);
    ((ime)localObject).WriteUInt32(paramInt1);
    localaool.gb = ((ime)localObject).Data();
    this.app.a().a(localaool);
    localObject = new PersonalityLabelPhoto();
    ((PersonalityLabelPhoto)localObject).localThumbPath = paramCompressInfo.destPath;
    ((PersonalityLabelPhoto)localObject).uniseq = l1;
    ((PersonalityLabelPhoto)localObject).local = true;
    albi.a locala = new albi.a();
    locala.XM = paramLong;
    locala.f = localaool;
    locala.a = ((PersonalityLabelPhoto)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("PLUploadManager", 2, "personality_label uploadPhoto() makeRequst, img_path = " + paramCompressInfo.srcPath + " uniseq:" + l1);
    }
    return locala;
  }
  
  public int a(long paramLong, PersonalityLabelInfo paramPersonalityLabelInfo, boolean paramBoolean)
  {
    int k = 0;
    List localList = paramPersonalityLabelInfo.personalityLabelPhotos;
    if ((!paramBoolean) && (localList.size() > 0))
    {
      i = localList.size() - 1;
      while (i >= 0)
      {
        if (((PersonalityLabelPhoto)localList.get(i)).fileId == -1L)
        {
          localList.remove(i);
          paramPersonalityLabelInfo.photoCount -= 1;
        }
        i -= 1;
      }
    }
    int j = 0;
    int i = k;
    while (i < this.L.size())
    {
      albi.a locala = (albi.a)this.L.get(i);
      if (locala.XM != paramLong)
      {
        i += 1;
      }
      else
      {
        k = locala.pos;
        if (k < localList.size()) {
          localList.add(k, locala.a);
        }
        for (;;)
        {
          paramPersonalityLabelInfo.photoCount += 1;
          j += 1;
          break;
          localList.add(locala.a);
        }
      }
    }
    return j;
  }
  
  public albi.a a(long paramLong, PersonalityLabelPhoto paramPersonalityLabelPhoto)
  {
    int i = 0;
    while (i < this.L.size())
    {
      if ((((albi.a)this.L.get(i)).XM == paramLong) && (((albi.a)this.L.get(i)).a.uniseq == paramPersonalityLabelPhoto.uniseq)) {
        return (albi.a)this.L.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(long paramLong, PersonalityLabelPhoto paramPersonalityLabelPhoto)
  {
    int i = 0;
    if (i < this.L.size()) {
      if ((((albi.a)this.L.get(i)).XM != paramLong) || (((albi.a)this.L.get(i)).a.uniseq != paramPersonalityLabelPhoto.uniseq)) {}
    }
    for (paramPersonalityLabelPhoto = (albi.a)this.L.get(i);; paramPersonalityLabelPhoto = null)
    {
      if (paramPersonalityLabelPhoto != null)
      {
        this.app.a().a(paramPersonalityLabelPhoto.f);
        if (QLog.isColorLevel()) {
          QLog.i("PLUploadManager", 2, "retry " + paramPersonalityLabelPhoto.f.dQ);
        }
      }
      return;
      i += 1;
      break;
    }
  }
  
  public void a(albi.b paramb)
  {
    this.a = paramb;
  }
  
  public boolean a(List<CompressInfo> paramList, long paramLong)
  {
    boolean bool = false;
    ArrayList localArrayList = new ArrayList();
    int k = (int)(System.currentTimeMillis() / 1000L);
    int j = 0;
    int i = 0;
    if (j < paramList.size())
    {
      albi.a locala = a((CompressInfo)paramList.get(j), paramLong, k, paramList.size(), j);
      if (locala == null) {
        break label245;
      }
      i += 1;
      this.L.add(0, locala);
      localArrayList.add(0, locala.a);
    }
    label245:
    for (;;)
    {
      j += 1;
      break;
      if (i > 0)
      {
        j = 0;
        if (j < this.L.size())
        {
          if (j < i) {
            ((albi.a)this.L.get(j)).pos = j;
          }
          for (;;)
          {
            j += 1;
            break;
            if (((albi.a)this.L.get(j)).XM == paramLong)
            {
              paramList = (albi.a)this.L.get(j);
              paramList.pos += i;
            }
          }
        }
        this.q.post(new PLUploadManager.1(this, localArrayList, paramLong));
      }
      if (localArrayList.size() > 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public void b(long paramLong, PersonalityLabelPhoto paramPersonalityLabelPhoto)
  {
    int i = 0;
    if (i < this.L.size()) {
      if ((((albi.a)this.L.get(i)).XM != paramLong) || (((albi.a)this.L.get(i)).a.uniseq != paramPersonalityLabelPhoto.uniseq)) {}
    }
    for (paramPersonalityLabelPhoto = (albi.a)this.L.remove(i);; paramPersonalityLabelPhoto = null)
    {
      if (i >= 0) {
        for (;;)
        {
          if (i < this.L.size())
          {
            if (((albi.a)this.L.get(i)).XM == paramLong)
            {
              albi.a locala = (albi.a)this.L.get(i);
              locala.pos -= 1;
            }
            i += 1;
            continue;
            i += 1;
            break;
          }
        }
      }
      if (paramPersonalityLabelPhoto != null)
      {
        this.app.a().a(paramPersonalityLabelPhoto.f);
        if (QLog.isColorLevel()) {
          QLog.i("PLUploadManager", 2, "delete " + paramPersonalityLabelPhoto.f.dQ);
        }
      }
      return;
      i = -1;
    }
  }
  
  public void onDestroy()
  {
    this.q.removeCallbacksAndMessages(null);
    this.app.a().b(this.l);
    if (QLog.isColorLevel()) {
      QLog.i("PLUploadManager", 2, "onDestroy this:" + this + " app:" + this.app + " handler:" + this.l);
    }
  }
  
  public class a
  {
    long XM;
    public PersonalityLabelPhoto a;
    aool f;
    int pos;
    public int progress = 0;
    public int state = 0;
    
    a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(long paramLong, albi.a parama);
    
    public abstract void e(List<PersonalityLabelPhoto> paramList, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     albi
 * JD-Core Version:    0.7.0.1
 */