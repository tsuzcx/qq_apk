import android.content.Intent;
import com.tencent.cloudfile.CloudFile;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atyo
{
  private List<agsd> BE;
  private agsd a;
  private FileManagerEntity c;
  private int cYK;
  private QQAppInterface mApp;
  private int mCurrentIndex;
  private int mType = 0;
  private String mUin;
  
  public atyo(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  private boolean W(Intent paramIntent)
  {
    Object localObject = atwb.da();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0)) {
      return false;
    }
    int k = paramIntent.getIntExtra("clicked_file_hashcode", 0);
    this.BE = new ArrayList();
    paramIntent = ((ArrayList)localObject).iterator();
    int i = 0;
    int j = 0;
    if (paramIntent.hasNext())
    {
      localObject = (FileInfo)paramIntent.next();
      if ((i == 0) && (((FileInfo)localObject).hashCode() == k))
      {
        this.mCurrentIndex = j;
        this.BE.add(atyn.a(this.mApp, this.c));
        i = 1;
      }
      for (;;)
      {
        j += 1;
        break;
        this.BE.add(atyn.a((FileInfo)localObject));
      }
    }
    atwb.dip();
    return true;
  }
  
  private boolean X(Intent paramIntent)
  {
    paramIntent = paramIntent.getParcelableArrayListExtra("local_weiyun_list");
    if ((paramIntent == null) || (paramIntent.size() == 0)) {
      return false;
    }
    this.BE = new ArrayList();
    paramIntent = paramIntent.iterator();
    int i = 0;
    while (paramIntent.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)paramIntent.next();
      if ((localWeiYunFileInfo.bIk != null) && (localWeiYunFileInfo.bIk.equalsIgnoreCase(this.c.WeiYunFileId))) {
        this.mCurrentIndex = i;
      }
      while (audx.fM(localWeiYunFileInfo.strFileName) == 0)
      {
        i += 1;
        this.BE.add(atyn.a(this.mApp, localWeiYunFileInfo));
        break;
      }
    }
    return true;
  }
  
  private boolean Y(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringArrayListExtra("Aio_Uinseq_ImageList");
    if (paramIntent == null) {
      return false;
    }
    this.BE = new ArrayList();
    paramIntent = paramIntent.iterator();
    int i = 0;
    while (paramIntent.hasNext())
    {
      long l = Long.parseLong((String)paramIntent.next());
      FileManagerEntity localFileManagerEntity = this.mApp.a().a(l, this.c.peerUin, this.c.peerType, -1L);
      if (localFileManagerEntity != null)
      {
        if (localFileManagerEntity.nSessionId == this.c.nSessionId) {
          this.mCurrentIndex = i;
        }
        while (aW(localFileManagerEntity.nFileType, localFileManagerEntity.getCloudType()))
        {
          this.BE.add(atyn.a(this.mApp, localFileManagerEntity));
          i += 1;
          break;
        }
      }
    }
    return true;
  }
  
  private boolean Z(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringArrayListExtra("Aio_SessionId_ImageList");
    if (paramIntent == null) {
      return false;
    }
    this.BE = new ArrayList();
    paramIntent = paramIntent.iterator();
    int i = 0;
    while (paramIntent.hasNext())
    {
      long l = Long.parseLong((String)paramIntent.next());
      FileManagerEntity localFileManagerEntity = this.mApp.a().c(l);
      if (localFileManagerEntity != null)
      {
        if (localFileManagerEntity.nSessionId == this.c.nSessionId) {
          this.mCurrentIndex = i;
        }
        while (aW(localFileManagerEntity.nFileType, localFileManagerEntity.getCloudType()))
        {
          this.BE.add(atyn.a(this.mApp, localFileManagerEntity));
          i += 1;
          break;
        }
      }
    }
    return true;
  }
  
  private FileManagerEntity a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.WeiYunDirKey = paramWeiYunFileInfo.dirKey;
    localFileManagerEntity.WeiYunFileId = paramWeiYunFileInfo.bIk;
    localFileManagerEntity.fileName = paramWeiYunFileInfo.strFileName;
    localFileManagerEntity.strLargeThumPath = paramWeiYunFileInfo.encodeUrl;
    localFileManagerEntity.strFileSHA = paramWeiYunFileInfo.sha;
    localFileManagerEntity.strFileMd5 = paramWeiYunFileInfo.md5;
    localFileManagerEntity.lastTime = paramWeiYunFileInfo.mtime;
    localFileManagerEntity.srvTime = paramWeiYunFileInfo.mtime;
    localFileManagerEntity.fileSize = paramWeiYunFileInfo.nFileSize;
    localFileManagerEntity.nFileType = 0;
    localFileManagerEntity.cloudType = 2;
    return localFileManagerEntity;
  }
  
  private boolean a(Intent paramIntent, ForwardFileInfo paramForwardFileInfo)
  {
    boolean bool;
    if (paramIntent.getBooleanExtra("is_in_zip", false))
    {
      bool = b(paramForwardFileInfo);
      this.mType = 1;
      if (bool) {
        break label275;
      }
      QLog.e("FileViewerParamParser", 1, "parseImageGallery type[" + paramForwardFileInfo.getType() + "] return false");
    }
    label275:
    while (this.BE.size() != 0)
    {
      return bool;
      switch (paramForwardFileInfo.getType())
      {
      case 10005: 
      case 10008: 
      case 10011: 
      case 10012: 
      case 10013: 
      default: 
        if (QLog.isDevelopLevel()) {
          QLog.w("FileViewerParamParser", 4, "parseImageGallery: type[" + paramForwardFileInfo.getType() + "] is not implemented");
        }
      case 10000: 
      case 10006: 
      case 10002: 
        do
        {
          bool = false;
          break;
          bool = W(paramIntent);
          break;
        } while (!QLog.isDevelopLevel());
        QLog.w("FileViewerParamParser", 4, "parseImageGallery: not support OfflineFile type");
        bool = false;
        break;
      case 10003: 
        bool = X(paramIntent);
        break;
      case 10001: 
        bool = amp();
        break;
      case 10004: 
        bool = Y(paramIntent);
        break;
      case 10009: 
        bool = Z(paramIntent);
        break;
      case 10007: 
        bool = amq();
        break;
      case 10010: 
        bool = amr();
        break;
      case 10014: 
        bool = ah(paramIntent);
        break;
      }
    }
    QLog.e("FileViewerParamParser", 1, "parseImageGallery type[" + paramForwardFileInfo.getType() + "] list is empty");
    return false;
  }
  
  private static boolean aW(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {}
    while (paramInt2 == 0) {
      return false;
    }
    return true;
  }
  
  private boolean ah(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringArrayListExtra("local_tim_cloud_sessionid_list");
    if (paramIntent == null) {
      return false;
    }
    this.BE = new ArrayList();
    paramIntent = paramIntent.iterator();
    int i = 0;
    while (paramIntent.hasNext())
    {
      long l = Long.parseLong((String)paramIntent.next());
      FileManagerEntity localFileManagerEntity = this.mApp.a().a(0L, "", 0, l);
      if (localFileManagerEntity != null)
      {
        if (localFileManagerEntity.nSessionId == this.c.nSessionId) {
          this.mCurrentIndex = i;
        }
        while (aW(localFileManagerEntity.nFileType, localFileManagerEntity.getCloudType()))
        {
          this.BE.add(atyn.a(this.mApp, localFileManagerEntity));
          i += 1;
          break;
        }
      }
    }
    return true;
  }
  
  private boolean amp()
  {
    Object localObject = this.mApp.a().eV();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return false;
    }
    this.BE = new ArrayList();
    localObject = ((List)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if ((this.mUin == null) || (this.mUin.trim().length() == 0) || (this.mUin.equals(localFileManagerEntity.peerUin)))
      {
        if (localFileManagerEntity.nSessionId == this.c.nSessionId) {
          this.mCurrentIndex = i;
        }
        while (aW(localFileManagerEntity.nFileType, localFileManagerEntity.getCloudType()))
        {
          i += 1;
          this.BE.add(atyn.a(this.mApp, localFileManagerEntity));
          break;
        }
      }
    }
    return true;
  }
  
  private boolean amq()
  {
    Object localObject3 = atwb.db();
    Object localObject2 = atwb.ep();
    Object localObject1 = atwb.dd();
    this.BE = new ArrayList();
    if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject3).next();
        if (localFileManagerEntity.nFileType == 0) {
          this.BE.add(atyn.a(this.mApp, localFileManagerEntity));
        }
      }
    }
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FileInfo)((Iterator)localObject2).next();
        if (((FileInfo)localObject3).getType() == 0) {
          this.BE.add(atyn.a((FileInfo)localObject3));
        }
      }
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeiYunFileInfo)((Iterator)localObject1).next();
        if (audx.fM(((WeiYunFileInfo)localObject2).strFileName) == 0) {
          this.BE.add(atyn.a(this.mApp, (WeiYunFileInfo)localObject2));
        }
      }
    }
    return this.BE.size() > 0;
  }
  
  private boolean amr()
  {
    Object localObject = this.mApp.a().eV();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return false;
    }
    this.BE = new ArrayList();
    localObject = ((List)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if ((5 == localFileManagerEntity.getCloudType()) && (this.c.nOlSenderProgress == localFileManagerEntity.nOlSenderProgress) && ((this.mUin == null) || (this.mUin.trim().length() == 0) || (this.mUin.equals(localFileManagerEntity.peerUin))))
      {
        if (localFileManagerEntity.nSessionId == this.c.nSessionId) {
          this.mCurrentIndex = i;
        }
        while (aW(localFileManagerEntity.nFileType, localFileManagerEntity.getCloudType()))
        {
          i += 1;
          this.BE.add(atyn.a(this.mApp, localFileManagerEntity));
          break;
        }
      }
    }
    return true;
  }
  
  private boolean b(ForwardFileInfo paramForwardFileInfo)
  {
    paramForwardFileInfo = paramForwardFileInfo.de();
    this.BE = new ArrayList();
    paramForwardFileInfo = paramForwardFileInfo.iterator();
    int i = 0;
    while (paramForwardFileInfo.hasNext())
    {
      Object localObject = (Long)paramForwardFileInfo.next();
      localObject = this.mApp.a().c(((Long)localObject).longValue());
      if (localObject != null)
      {
        if (aueh.fileExistsAndNotEmpty(((FileManagerEntity)localObject).getFilePath())) {
          ((FileManagerEntity)localObject).status = 1;
        }
        if (((FileManagerEntity)localObject).nSessionId == this.c.nSessionId) {
          this.mCurrentIndex = i;
        }
        while (aW(((FileManagerEntity)localObject).nFileType, ((FileManagerEntity)localObject).getCloudType()))
        {
          this.BE.add(atyn.a(this.mApp, (FileManagerEntity)localObject));
          i += 1;
          break;
        }
      }
    }
    return true;
  }
  
  private static boolean c(int paramInt, Intent paramIntent)
  {
    paramIntent = paramIntent.getStringArrayListExtra("local_tim_cloud_sessionid_list");
    if (paramInt != 0) {}
    while (paramIntent == null) {
      return false;
    }
    return true;
  }
  
  public int EI()
  {
    return this.mCurrentIndex;
  }
  
  public boolean V(Intent paramIntent)
  {
    boolean bool2 = false;
    this.cYK = paramIntent.getIntExtra("qfile_browser_entrance_type", -1);
    ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
    if (localForwardFileInfo == null) {
      return false;
    }
    long l = localForwardFileInfo.fR();
    this.c = this.mApp.a().b(l);
    Object localObject;
    if ((this.c == null) && (localForwardFileInfo.Ev() == 2))
    {
      localObject = localForwardFileInfo.a();
      if (localObject != null) {
        this.c = a((WeiYunFileInfo)localObject);
      }
    }
    if ((this.c == null) && (localForwardFileInfo.Ev() == 9))
    {
      this.c = new FileManagerEntity();
      this.c.fileSize = localForwardFileInfo.getFileSize();
      this.c.fileName = localForwardFileInfo.getFileName();
      this.c.cloudId = localForwardFileInfo.Y();
      this.c.cloudIdHex = aqhs.bytes2HexStr(this.c.cloudId);
      this.c.pDirKey = localForwardFileInfo.Z();
      this.c.nFileType = audx.fM(localForwardFileInfo.getFileName());
      this.c.cloudFile = new CloudFile();
      this.c.cloudFile.cloudId = localForwardFileInfo.Y();
      this.c.cloudFile.type = 2;
      this.c.cloudFile.pDirKey = localForwardFileInfo.Z();
      this.c.cloudFile.pLogicDirKey = localForwardFileInfo.Z();
      this.c.cloudFile.showName = localForwardFileInfo.getFileName();
      this.c.cloudType = 9;
    }
    if ((this.c != null) && (this.c.cloudType == 9))
    {
      localObject = this.mApp.a().a(this.c.cloudId);
      if (localObject != null)
      {
        this.c.strFilePath = ((FileManagerEntity)localObject).strFilePath;
        this.c.setfProgress(((FileManagerEntity)localObject).getfProgress());
        this.c.status = ((FileManagerEntity)localObject).status;
      }
    }
    if (this.c == null)
    {
      QLog.e("FileViewerParamParser", 1, "FileViewerParamParsernot found, bug. sessionid:" + String.valueOf(l));
      return false;
    }
    if ((5 != this.c.cloudType) && (9 != this.c.cloudType)) {
      audx.I(this.c);
    }
    boolean bool1 = aW(this.c.nFileType, this.c.getCloudType());
    if (this.c.getCloudType() == 9) {
      bool1 = c(this.c.nFileType, paramIntent);
    }
    if (this.c.nOpType == 16) {
      bool1 = bool2;
    }
    for (;;)
    {
      if (bool1) {
        return a(paramIntent, localForwardFileInfo);
      }
      this.a = atyn.a(this.mApp, this.c);
      this.mType = 3;
      return true;
    }
  }
  
  public agsd a()
  {
    return this.a;
  }
  
  public atxf.a a(BaseActivity paramBaseActivity)
  {
    return new atyp(this, paramBaseActivity);
  }
  
  public List<agsd> fc()
  {
    return this.BE;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public void setUin(String paramString)
  {
    this.mUin = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atyo
 * JD-Core Version:    0.7.0.1
 */