import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.FilePreviewActivity;
import com.tencent.tim.filemanager.core.WpsFileEditManager;
import com.tencent.tim.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.tim.teamwork.TeamWorkFileImportInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public abstract class atzs
  extends atzy
{
  public List<agsd> BG;
  protected atvo a;
  private TeamWorkFileImportInfo a;
  protected String aEI;
  protected String aEJ;
  protected String aEK;
  protected long aab;
  protected boolean ajo;
  protected String bJj;
  private String bJk = "";
  public agsd c;
  public QQAppInterface mAppInterface;
  protected String str_download_dns;
  
  public atzs(Activity paramActivity)
  {
    super(paramActivity);
    this.mContext = paramActivity;
    this.mAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private agsd c()
  {
    if (this.mCurrentIndex > this.BG.size() - 1)
    {
      QLog.e("FileBrowserModelBase", 1, "index error, index[" + this.mCurrentIndex + "], size[" + this.BG.size() + "]");
      return (agsd)this.BG.get(0);
    }
    return (agsd)this.BG.get(this.mCurrentIndex);
  }
  
  private void djv()
  {
    int i = bG();
    int j = bH();
    Object localObject = this.jdField_c_of_type_Agsd.b();
    if ((localObject != null) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).WeiYunFileId)))
    {
      this.mAppInterface.a().a(new atvg(this.mAppInterface, this.jdField_c_of_type_Agsd.getFileId(), this.jdField_c_of_type_Agsd.b().WeiYunDirKey));
      if (this.jdField_c_of_type_Attt == null) {
        this.jdField_c_of_type_Attt = this.mAppInterface.a().a();
      }
      if (this.b == null) {
        this.b = new atzu(this);
      }
      this.jdField_c_of_type_Attt.a(this.b);
      this.jdField_c_of_type_Attt.alr();
    }
    do
    {
      return;
      if (i == 2)
      {
        if (this.jdField_c_of_type_Agsd.b() == null) {}
        for (localObject = "";; localObject = this.jdField_c_of_type_Agsd.b().dirKey)
        {
          this.mAppInterface.a().a(new atvg(this.mAppInterface, this.jdField_c_of_type_Agsd.getFileId(), (String)localObject));
          break;
        }
      }
      if ((i == 1) || (i == 3))
      {
        if (j == 3000)
        {
          this.mAppInterface.a().a(new atsz(this.mAppInterface, this.jdField_c_of_type_Agsd.getUuid(), this.jdField_c_of_type_Agsd.ay()));
          break;
        }
        this.mAppInterface.a().a(new atub(this.mAppInterface, this.jdField_c_of_type_Agsd.getUuid()));
        break;
      }
      if (i == 9)
      {
        localObject = this.jdField_c_of_type_Agsd.b();
        if (localObject == null) {
          break;
        }
        this.mAppInterface.a().a(new atge(((FileManagerEntity)localObject).pDirKey, ((FileManagerEntity)localObject).cloudId));
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("FileBrowserModelBase", 2, "loadZipFilesForOthers error. can not handle zip file");
  }
  
  private QQAppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public String Fa()
  {
    return "";
  }
  
  public long V()
  {
    if (this.jdField_c_of_type_Agsd != null) {
      return this.jdField_c_of_type_Agsd.fR();
    }
    return 0L;
  }
  
  protected void V(List<agsd> paramList, int paramInt)
  {
    this.BG = paramList;
    this.mCurrentIndex = paramInt;
    this.jdField_c_of_type_Agsd = c();
  }
  
  public atza a()
  {
    if (this.jdField_a_of_type_Atza == null) {
      this.jdField_a_of_type_Atza = new atzx(this);
    }
    return this.jdField_a_of_type_Atza;
  }
  
  public TeamWorkFileImportInfo a()
  {
    return this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkFileImportInfo;
  }
  
  public void a(int paramInt, atzy.a parama)
  {
    agsd localagsd = ((atzc)parama).b();
    if (localagsd == null) {
      auds.JE(BaseApplicationImpl.getContext().getString(2131693595));
    }
    do
    {
      return;
      if ((audx.o(localagsd.b())) && (1 == localagsd.getCloudType())) {
        auds.JE(BaseApplicationImpl.getContext().getString(2131693595));
      }
    } while (localagsd.vF() != null);
    localagsd.setState(1);
    parama.setState(1);
  }
  
  protected void a(agsd paramagsd, int paramInt) {}
  
  public void a(atzy.b paramb) {}
  
  public void a(atzy.d paramd)
  {
    this.jdField_a_of_type_Atzy$d = paramd;
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, smq.j paramj)
  {
    String str = "http://" + paramString1 + ":" + paramString2 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + aurr.encodeUrl(paramString4) + "&";
    if (paramFileManagerEntity.getCloudType() == 2) {}
    for (boolean bool = true;; bool = false)
    {
      paramString1 = new aprc(str, "GET", new atzw(this, new ArrayList(), paramString4, paramFileManagerEntity, bool, paramString5, paramString1, paramString2, paramString3, paramInt, paramj), 1000, null);
      paramString2 = new Bundle();
      paramString2.putString("version", aqgz.getQQVersion());
      paramString2.putString("Cookie", "FTN5K=" + paramString5);
      paramString3 = new HashMap();
      paramString3.put("BUNDLE", paramString2);
      paramString3.put("CONTEXT", this.mAppInterface.getApp().getApplicationContext());
      paramString1.J(paramString3);
      return;
    }
  }
  
  protected void a(boolean paramBoolean, audk paramaudk, long paramLong, ahal.a parama)
  {
    int i = 2131693832;
    if (!aqiw.bW(BaseApplicationImpl.getContext()))
    {
      auds.OS(2131694663);
      return;
    }
    if (paramaudk != null)
    {
      boolean bool;
      if (!paramBoolean)
      {
        bool = true;
        if (!paramaudk.bd(bool)) {
          break label81;
        }
        paramaudk = this.mContext;
        if (!paramBoolean) {
          break label73;
        }
      }
      label73:
      for (i = 2131693832;; i = 2131693828)
      {
        ahal.a(paramaudk, 2131693826, i, parama);
        return;
        bool = false;
        break;
      }
      label81:
      parama.aD();
      return;
    }
    if ((audx.amK()) && (paramLong > atvz.fJ()))
    {
      paramaudk = this.mContext;
      if (paramBoolean) {}
      for (;;)
      {
        ahal.a(paramaudk, 2131693826, i, parama);
        return;
        i = 2131693828;
      }
    }
    parama.aD();
  }
  
  public String aA()
  {
    return aueh.g(getFileSize());
  }
  
  public void aA(int paramInt)
  {
    if (this.jdField_c_of_type_Agsd != null) {
      this.jdField_c_of_type_Agsd.b().status = paramInt;
    }
  }
  
  public String aB()
  {
    if (this.jdField_c_of_type_Agsd != null) {
      return this.jdField_c_of_type_Agsd.aB();
    }
    return "";
  }
  
  public String aC()
  {
    if (this.jdField_c_of_type_Agsd != null) {
      return this.jdField_c_of_type_Agsd.vH();
    }
    return "";
  }
  
  public void aH(int paramInt)
  {
    if (paramInt == this.mCurrentIndex) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return;
      this.mCurrentIndex = paramInt;
      this.jdField_c_of_type_Agsd = c();
      localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    } while ((localFileManagerEntity == null) || (!localFileManagerEntity.isZipInnerFile) || (!aueh.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())));
    localFileManagerEntity.status = 1;
  }
  
  public boolean aJm()
  {
    boolean bool = false;
    if (!aqmj.c(this.mAppInterface.getApp(), this.mAppInterface.getCurrentUin(), "disable_wps_file_preview", false)) {
      bool = true;
    }
    return bool;
  }
  
  public void at(boolean paramBoolean)
  {
    if ((this.jdField_c_of_type_Agsd != null) && (this.jdField_c_of_type_Agsd.b() != null)) {
      this.jdField_c_of_type_Agsd.b().bCannotPlay = true;
    }
  }
  
  public void ax(int paramInt) {}
  
  public int bF()
  {
    if (this.jdField_c_of_type_Agsd != null) {
      return this.jdField_c_of_type_Agsd.bF();
    }
    return -1;
  }
  
  public int bG()
  {
    if (this.jdField_c_of_type_Agsd != null) {
      return this.jdField_c_of_type_Agsd.getCloudType();
    }
    return -1;
  }
  
  public int bH()
  {
    if (this.jdField_c_of_type_Agsd != null) {
      return this.jdField_c_of_type_Agsd.DW();
    }
    return -1;
  }
  
  public int bI()
  {
    if (this.jdField_c_of_type_Agsd != null) {
      return this.jdField_c_of_type_Agsd.getOpType();
    }
    return -1;
  }
  
  public int bK()
  {
    int i = 2;
    int j = bI();
    if ((bG() == 0) && (j != 10)) {
      i = 4;
    }
    do
    {
      return i;
      switch (j)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.w("FileBrowserModelBase<FileAssistant>", 2, "error. a unknow transfer type");
    return 2;
    return 1;
  }
  
  public int bL()
  {
    int i = 2;
    int j = bF();
    String str = getFilePath();
    if ((j == 2) || (j == 14)) {
      i = 4;
    }
    do
    {
      return i;
      if (j == 16) {
        return 5;
      }
      if ((j == 0) || (j == 3)) {
        return 6;
      }
    } while (aueh.fileExistsAndNotEmpty(str));
    return 0;
  }
  
  public boolean cg()
  {
    if (this.jdField_c_of_type_Agsd != null) {
      return this.jdField_c_of_type_Agsd.amo();
    }
    return false;
  }
  
  public boolean ch()
  {
    return this.jdField_c_of_type_Agsd == null;
  }
  
  public boolean ci()
  {
    if ((this.jdField_c_of_type_Agsd != null) && (this.jdField_c_of_type_Agsd.b() != null)) {
      return audx.o(this.jdField_c_of_type_Agsd.b());
    }
    return false;
  }
  
  public boolean cj()
  {
    if ((this.jdField_c_of_type_Agsd != null) && (this.jdField_c_of_type_Agsd.b() != null)) {
      return this.jdField_c_of_type_Agsd.b().isZipInnerFile;
    }
    return false;
  }
  
  public boolean cl()
  {
    if ((this.jdField_c_of_type_Agsd != null) && (this.jdField_c_of_type_Agsd.b() != null)) {
      return this.jdField_c_of_type_Agsd.b().isSend();
    }
    return false;
  }
  
  public boolean cm()
  {
    boolean bool = true;
    if ((bL() != 2) && (bK() == 1)) {
      return false;
    }
    if ((audx.b(this.mAppInterface, this.jdField_c_of_type_Agsd)) && (audx.b(this.mContext, getFileName(), getFileSize()))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean cm(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      str = paramString2;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = new File(paramString1);
        str = paramString2;
        if (paramString1 != null)
        {
          str = paramString2;
          if (paramString1.exists()) {
            str = paramString1.getName();
          }
        }
      }
    }
    paramString1 = aueh.getExtension(str);
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (".doc|.docx|.xls|.xlsx|".indexOf(paramString1.toLowerCase()) >= 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean cn()
  {
    boolean bool = true;
    int i = bL();
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    if ((localFileManagerEntity != null) && (localFileManagerEntity.isZipInnerFile) && (getFileType() == 5)) {}
    do
    {
      return false;
      if ((i != 5) && (i != 2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("FileBrowserModelBase", 2, "can not auto download file : [fileStatus] = " + i);
    return false;
    i = bG();
    if ((i == 1) || (i == 2) || (i == 9))
    {
      i = 1;
      if ((i == 0) || (!audx.dm(getFileSize()))) {
        break label126;
      }
    }
    for (;;)
    {
      return bool;
      i = 0;
      break;
      label126:
      bool = false;
    }
  }
  
  public boolean co()
  {
    if (this.jdField_c_of_type_Agsd == null) {}
    FileManagerEntity localFileManagerEntity;
    int i;
    do
    {
      QQAppInterface localQQAppInterface;
      do
      {
        return false;
        localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
        this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
        this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkFileImportInfo.isUserClick = false;
        localQQAppInterface = getAppInterface();
      } while (localQQAppInterface == null);
      i = localQQAppInterface.getApp().getSharedPreferences("tim_convert_teamwork_pre_" + localQQAppInterface.getCurrentUin(), 0).getInt(atwa.cIo, 20971520);
    } while ((localFileManagerEntity == null) || (!cm(getFilePath(), getFileName())) || (!aqiw.isNetSupport(BaseApplicationImpl.getContext())) || (localFileManagerEntity.fileSize > i) || ((TextUtils.isEmpty(localFileManagerEntity.Uuid)) && (TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath)) && (TextUtils.isEmpty(localFileManagerEntity.strFilePath))));
    this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkFileImportInfo.fileName = localFileManagerEntity.fileName;
    this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkFileImportInfo.fileSize = localFileManagerEntity.fileSize;
    this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkFileImportInfo.filePath = localFileManagerEntity.strFilePath;
    this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkFileImportInfo.nFileType = localFileManagerEntity.nFileType;
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserModelBase", 2, "file size:" + localFileManagerEntity.fileSize + " isTroopFile:" + TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath) + " isOfflineFile:" + TextUtils.isEmpty(localFileManagerEntity.Uuid) + "isLocalFile: " + TextUtils.isEmpty(localFileManagerEntity.strFilePath));
    }
    if (this.e != null) {
      this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkFileImportInfo.isFromAIO = this.e.bY();
    }
    if (!TextUtils.isEmpty(localFileManagerEntity.peerUin))
    {
      this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkFileImportInfo.peerType = localFileManagerEntity.peerType;
      this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkFileImportInfo.peerUin = localFileManagerEntity.peerUin;
      this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkFileImportInfo.troopUin = String.valueOf(localFileManagerEntity.TroopUin);
      this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkFileImportInfo.dNP = localFileManagerEntity.busId;
      this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkFileImportInfo.cjE = localFileManagerEntity.strTroopFilePath;
      this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkFileImportInfo.msgUniseq = localFileManagerEntity.uniseq;
      if (localFileManagerEntity.status != 16) {
        this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkFileImportInfo.cKX = true;
      }
    }
    return true;
  }
  
  public void cqt()
  {
    super.cqt();
    if (this.jdField_c_of_type_Attt != null)
    {
      this.jdField_c_of_type_Attt.clear();
      this.jdField_c_of_type_Attt = null;
    }
    if ((audx.a(this.mAppInterface, this.jdField_c_of_type_Agsd)) && (audx.b(this.mAppInterface, this.jdField_c_of_type_Agsd))) {
      this.mAppInterface.a().dhn();
    }
    if (this.jdField_a_of_type_Atvo != null) {
      WpsFileEditManager.a().deleteObserver(this.jdField_a_of_type_Atvo);
    }
  }
  
  public void djr()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    Object localObject;
    if (bG() == 2)
    {
      if (aJm())
      {
        localObject = new atvw(4);
        ((atvw)localObject).g(aqhs.hexStr2Bytes(localFileManagerEntity.WeiYunFileId.substring(0, 32)), localFileManagerEntity.WeiYunFileId.substring(32));
        ((atvw)localObject).y(localFileManagerEntity.strFileSHA, localFileManagerEntity.strFileMd5, localFileManagerEntity.fileSize);
        ((atvw)localObject).o(Boolean.valueOf(true));
        ((atvw)localObject).setUin(this.mAppInterface.getCurrentAccountUin());
        this.mAppInterface.a().a((attt)localObject);
        this.mAppInterface.a().s(localFileManagerEntity);
        a(this.jdField_c_of_type_Agsd, 5);
      }
    }
    else {
      return;
    }
    if (this.jdField_c_of_type_Agsd.b() == null) {
      if (this.jdField_c_of_type_Agsd.b() == null) {
        localObject = "";
      }
    }
    for (;;)
    {
      this.mAppInterface.a().a(new atvg(this.mAppInterface, localFileManagerEntity.WeiYunFileId, (String)localObject));
      break;
      localObject = this.jdField_c_of_type_Agsd.b().dirKey;
      continue;
      localObject = this.jdField_c_of_type_Agsd.b().WeiYunDirKey;
    }
  }
  
  public void djw()
  {
    if (this.jdField_c_of_type_Agsd != null)
    {
      this.jdField_c_of_type_Agsd.Jz(true);
      this.jdField_c_of_type_Agsd.JA(false);
    }
  }
  
  public void doOnPause()
  {
    if (this.jdField_c_of_type_Attt != null)
    {
      this.jdField_c_of_type_Attt.clear();
      this.jdField_c_of_type_Attt = null;
    }
    this.ajo = false;
  }
  
  public void doOnResume()
  {
    ix();
    this.ajo = true;
    long l;
    if (audx.isLocalFile(getFilePath()))
    {
      l = new File(getFilePath()).lastModified();
      if (this.aab != 0L) {
        break label78;
      }
      this.aab = l;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Atvo == null)
      {
        this.jdField_a_of_type_Atvo = new atzt(this);
        WpsFileEditManager.a().addObserver(this.jdField_a_of_type_Atvo);
      }
      return;
      label78:
      if (this.aab != l)
      {
        QLog.e("FileBrowserModelBase", 1, "local file is modified, and refresh file. filepath:" + getFilePath());
        this.aab = l;
        this.e.ir();
      }
    }
  }
  
  public void eH(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((ateh)this.mAppInterface.getBusinessHandler(180)).notifyUI(30, true, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public ArrayList<aufa.b> er()
  {
    Object localObject3 = this.jdField_c_of_type_Agsd.b();
    String str = getFilePath();
    boolean bool = aueh.fileExistsAndNotEmpty(str);
    if ((localObject3 == null) && (TextUtils.isEmpty(str))) {
      return null;
    }
    if (bF() == 16) {
      return null;
    }
    if ((!bool) && (localObject3 != null) && (((FileManagerEntity)localObject3).isZipInnerFile)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if (bool)
    {
      localObject1 = localObject3;
      if (localObject3 != null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = audx.a(new FileInfo(str));
        localObject3 = aufa.a(2130837660, "发给好友", atxh.a(this.e, (FileManagerEntity)localObject1, this.mContext, null));
        localArrayList.add(localObject3);
        if ((localObject1 == null) || ((((FileManagerEntity)localObject1).getCloudType() != 2) && ((((FileManagerEntity)localObject1).getCloudType() != 3) || (TextUtils.isEmpty(((FileManagerEntity)localObject1).WeiYunFileId)) || (((FileManagerEntity)localObject1).nOpType != 5)))) {
          break label447;
        }
        if ((localObject1 != null) && (ault.cm(((FileManagerEntity)localObject1).strFilePath, ((FileManagerEntity)localObject1).fileName))) {
          localArrayList.add(aufa.a(2130837657, "在线编辑", atxh.a((FileManagerEntity)localObject1, this.mContext)));
        }
        if ((bool) && (auen.sW(str)) && (auen.cx(this.e.getApp())))
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileBrowserModelBase", 2, "DefaultFileModel getMenu add wpsedit btn ");
          }
          localArrayList.add(aufa.a(2130837659, this.mContext.getString(2131693885), atxh.a(this.e, (FileManagerEntity)localObject1, this.mContext, null)));
        }
        if (bool) {
          localArrayList.add(aufa.a(2130837671, "邮件", atxh.b(this.mContext, str, (FileManagerEntity)localObject1, null)));
        }
        if ((bool) && (((acde)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(8)).b.B(getFileName()))) {
          localArrayList.add(aufa.a(2130837666, "打印", atxh.c(this.mContext, getFilePath())));
        }
        if (bool) {
          localArrayList.add(aufa.a(2130837665, "用其他应用打开", atxh.a(this.mContext, str, (FileManagerEntity)localObject1, null)));
        }
        return localArrayList;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        localObject2 = localObject3;
        continue;
      }
      aufa.b localb = aufa.a(2130837660, "发给好友", atxh.a(this.e, (FileManagerEntity)localObject3, this.mContext, null));
      Object localObject2 = localObject3;
      localObject3 = localb;
      continue;
      label447:
      if ((localObject2 != null) && ((localObject2.getCloudType() == 3) || (localObject2.getCloudType() == 5) || (localObject2.getCloudType() == 1) || ((localObject2.getCloudType() == 9) && (!localObject2.fromCloudFile))))
      {
        localArrayList.add(aufa.a(2130837668, this.mContext.getString(2131693559), atxh.a(this.mContext, localObject2)));
      }
      else if (bool)
      {
        localObject3 = new FileManagerEntity();
        ((FileManagerEntity)localObject3).strFilePath = str;
        ((FileManagerEntity)localObject3).setCloudType(3);
        ((FileManagerEntity)localObject3).fileSize = getFileSize();
        localArrayList.add(aufa.a(2130837668, this.mContext.getString(2131693559), atxh.a(this.mContext, (FileManagerEntity)localObject3)));
      }
    }
  }
  
  public String getFileName()
  {
    if (this.jdField_c_of_type_Agsd != null) {
      return this.jdField_c_of_type_Agsd.getFileName();
    }
    return "";
  }
  
  public String getFilePath()
  {
    if (this.jdField_c_of_type_Agsd != null) {
      return this.jdField_c_of_type_Agsd.getFilePath();
    }
    return "";
  }
  
  public long getFileSize()
  {
    if (this.jdField_c_of_type_Agsd != null) {
      return this.jdField_c_of_type_Agsd.getFileSize();
    }
    return 0L;
  }
  
  public int getFileType()
  {
    if (this.jdField_c_of_type_Agsd != null) {
      return this.jdField_c_of_type_Agsd.getFileType();
    }
    return -1;
  }
  
  public long getUin()
  {
    return 0L;
  }
  
  protected void iA()
  {
    Object localObject2 = null;
    if ((this.mContext instanceof FileBrowserActivity)) {}
    for (agsa localagsa = (agsa)this.mContext;; localagsa = null)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
      if (localFileManagerEntity == null) {
        return;
      }
      Object localObject1 = localObject2;
      switch (localFileManagerEntity.nOpType)
      {
      default: 
        localObject1 = localObject2;
      }
      while (localObject1 != null)
      {
        audw.JH((String)localObject1);
        return;
        if ((localagsa != null) && (localagsa.bY()))
        {
          localObject1 = "0X8004BB7";
        }
        else
        {
          localObject1 = "0X8004BCD";
          continue;
          if ((localagsa != null) && (localagsa.bY()))
          {
            localObject1 = "0X8004BB8";
          }
          else
          {
            localObject1 = "0X8004BCE";
            continue;
            if ((localagsa != null) && (localagsa.bY())) {
              localObject1 = "0X8004BB9";
            } else {
              localObject1 = "0X8004BCF";
            }
          }
        }
      }
    }
  }
  
  public void iB()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    if (localFileManagerEntity != null)
    {
      atqw.a(this.mAppInterface, this.mContext, localFileManagerEntity, null);
      return;
    }
    try
    {
      localFileManagerEntity = audx.a(new FileInfo(getFilePath()));
      atqw.a(this.mAppInterface, this.mContext, localFileManagerEntity, null);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
  
  public void iC()
  {
    if ((audx.a(this.mAppInterface, this.jdField_c_of_type_Agsd)) && (audx.b(this.mAppInterface, this.jdField_c_of_type_Agsd)))
    {
      long l = V();
      if (bG() == 2) {
        l = audx.N(getFileSize());
      }
      this.mAppInterface.a().aq(l, this.jdField_c_of_type_Agsd.b().WeiYunFileId);
    }
    String str;
    if (this.jdField_c_of_type_Agsd.b().bSend) {
      str = this.mAppInterface.getCurrentNickname();
    }
    for (;;)
    {
      Object localObject = new SimpleDateFormat("yyyy.MM.dd");
      localObject = " 于" + ((SimpleDateFormat)localObject).format(new Date(this.jdField_c_of_type_Agsd.b().srvTime)) + "上传";
      if (this.jdField_a_of_type_Atzy$e != null) {
        this.jdField_a_of_type_Atzy$e.fQ(str, (String)localObject);
      }
      if (aqiw.isNetworkAvailable(this.mContext)) {
        break;
      }
      QQToast.a(this.mContext, 1, this.mContext.getString(2131693404), 1).show(getTitleBarHeight());
      return;
      if (this.jdField_c_of_type_Agsd.b().peerType == 3000) {
        str = aqgv.m(this.mAppInterface, this.jdField_c_of_type_Agsd.b().peerUin, this.jdField_c_of_type_Agsd.b().selfUin);
      } else {
        str = this.jdField_c_of_type_Agsd.b().peerNick;
      }
    }
    djv();
  }
  
  public void iD()
  {
    if (!aqiw.isNetSupport(BaseApplicationImpl.getContext()))
    {
      auds.JD(BaseApplicationImpl.getContext().getString(2131693819));
      return;
    }
    djw();
    djr();
    Intent localIntent = new Intent(this.mContext, FilePreviewActivity.class);
    localIntent.putExtra("offline_file_type", 0);
    localIntent.putExtra("offline_file_name", getFileName());
    localIntent.putExtra("offline_file_size", getFileSize());
    if (co())
    {
      localIntent.putExtra("offline_file_show_team_work_menu", true);
      localIntent.putExtra("key_team_work_file_import_info", this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkFileImportInfo);
    }
    this.mContext.startActivity(localIntent);
    this.mContext.overridePendingTransition(2130772039, 2130772040);
  }
  
  public boolean isFromProcessingForward2c2cOrDiscItem()
  {
    if ((this.jdField_c_of_type_Agsd != null) && (this.jdField_c_of_type_Agsd.b() != null)) {
      return this.jdField_c_of_type_Agsd.b().isFromProcessingForward2c2cOrDiscItem();
    }
    return false;
  }
  
  public float k()
  {
    if ((this.jdField_c_of_type_Agsd != null) && (this.jdField_c_of_type_Agsd.b() != null)) {
      return this.jdField_c_of_type_Agsd.b().getfProgress();
    }
    return 0.0F;
  }
  
  public void l(int paramInt, String paramString)
  {
    if ((this.jdField_c_of_type_Agsd == null) || (this.jdField_c_of_type_Agsd.b() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase", 2, "onVideoPlayerError : file entity is null");
      }
      return;
    }
    paramString = this.jdField_c_of_type_Agsd.b();
    paramString.status = 16;
    paramString.mContext = "showed";
    this.mAppInterface.a().u(paramString);
  }
  
  public List<atzy.a> u()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.BG != null)
    {
      Iterator localIterator = this.BG.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new atzc((agsd)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  public String ve()
  {
    if (bE() == 2)
    {
      if ((TextUtils.isEmpty(this.bJk)) && (this.jdField_c_of_type_Agsd != null))
      {
        this.bJk = (this.jdField_c_of_type_Agsd.fR() + "_" + System.currentTimeMillis());
        QLog.i("FileBrowserModelBase", 1, "getContextId: default video file random contextId: " + this.bJk);
      }
      if (!TextUtils.isEmpty(this.bJk)) {
        return this.bJk;
      }
    }
    if (this.jdField_c_of_type_Agsd != null) {
      return this.jdField_c_of_type_Agsd.fR() + "";
    }
    return super.ve();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atzs
 * JD-Core Version:    0.7.0.1
 */