import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.cloudfile.CloudDir;
import com.tencent.cloudfile.CloudFile;
import com.tencent.cloudfile.CloudFileCallbackCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.fileviewer.model.TIMCloudFileModel.7;
import com.tencent.tim.teamwork.PadInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class auaj
  extends atzs
  implements augx
{
  private atjx jdField_a_of_type_Atjx;
  private atsn jdField_a_of_type_Atsn;
  private aths.a b;
  protected atza b;
  private atgd c;
  private boolean diK;
  private CloudFileCallbackCenter e;
  View.OnClickListener gv = new auat(this);
  private FileManagerEntity s;
  
  public auaj(Activity paramActivity, List<agsd> paramList, int paramInt)
  {
    super(paramActivity);
    V(paramList, paramInt);
    paramActivity = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (paramActivity != null) {
      this.jdField_a_of_type_Atjx = new atjx(paramActivity, this.mContext, this);
    }
  }
  
  private void a(boolean paramBoolean, ArrayList<aufa.b> paramArrayList, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (!this.diK)
    {
      paramString = aufa.a(2130837654, "复制到", atxh.a(this.mContext, paramFileManagerEntity, this.jdField_a_of_type_Atjx.a(2)));
      if ((this.mEntranceType != 1) && (this.mEntranceType != 0)) {
        paramArrayList.add(paramString);
      }
      if (this.diK) {
        break label255;
      }
      paramString = aufa.a(2130837664, "移动", atxh.b(this.mContext, paramFileManagerEntity, this.jdField_a_of_type_Atjx.a(2)));
      label97:
      if ((!Arrays.equals(((atgc)localQQAppInterface.getManager(373)).aF(), paramFileManagerEntity.pDirKey)) && (this.mEntranceType != 1)) {
        paramArrayList.add(paramString);
      }
      if ((paramBoolean) && (((acde)localQQAppInterface.getBusinessHandler(8)).b.B(getFileName()))) {
        paramArrayList.add(aufa.a(2130837666, "打印", atxh.c(this.mContext, getFilePath())));
      }
      if (this.diK) {
        break label271;
      }
    }
    label271:
    for (paramFileManagerEntity = aufa.a(2130837656, "删除", atxh.c(this.mContext, paramFileManagerEntity, this.jdField_a_of_type_Atjx.a(2)));; paramFileManagerEntity = aufa.a(2130837656, "删除", this.gv))
    {
      if ((this.mEntranceType != 1) && (this.mEntranceType != 0)) {
        paramArrayList.add(paramFileManagerEntity);
      }
      return;
      paramString = aufa.a(2130837654, "复制到", this.gv);
      break;
      label255:
      paramString = aufa.a(2130837664, "移动", this.gv);
      break label97;
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.s = paramFileManagerEntity;
    if (bL() == 6)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TIMCloudFileModel", 2, "resume c2c aio recent receive");
      }
      paramQQAppInterface.a().jk(this.s.nSessionId);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TIMCloudFileModel", 2, "start c2c aio recent receive");
      }
      if ((paramFileManagerEntity == null) || (paramFileManagerEntity.cloudType != 3)) {
        break label191;
      }
      String str = paramFileManagerEntity.getFilePath();
      boolean bool = aqhq.fileExistsAndNotEmpty(str);
      if (QLog.isColorLevel()) {
        QLog.d("TIMCloudFileModel", 2, new Object[] { "download c2c but local, file exist: ", Boolean.valueOf(bool) });
      }
      if (!bool) {
        break;
      }
      paramQQAppInterface = this.jdField_c_of_type_Agsd.b();
      paramQQAppInterface.setFilePath(str);
      paramQQAppInterface.status = 1;
      if (paramQQAppInterface.cloudFile != null)
      {
        paramQQAppInterface.cloudFile.downloadStatus = 5;
        paramQQAppInterface.cloudFile.finalPath = str;
      }
      atgi.a().a(paramQQAppInterface, str, true);
    } while (this.jdField_a_of_type_Atzy$d == null);
    this.jdField_a_of_type_Atzy$d.djG();
    return;
    paramFileManagerEntity.cloudType = 9;
    label191:
    paramQQAppInterface.a().l(paramFileManagerEntity);
  }
  
  private boolean x(FileManagerEntity paramFileManagerEntity)
  {
    long l = 604800000L;
    if (paramFileManagerEntity.peerType == 3000) {
      l = 2592000000L;
    }
    return l + paramFileManagerEntity.srvTime <= NetConnInfoCenter.getServerTimeMillis() + 5000L;
  }
  
  private boolean x(byte[] paramArrayOfByte)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    CloudFile localCloudFile = localFileManagerEntity.cloudFile;
    if (localCloudFile != null) {
      return Arrays.equals(localCloudFile.cloudId, paramArrayOfByte);
    }
    if (localFileManagerEntity.cloudId != null) {
      return Arrays.equals(localFileManagerEntity.cloudId, paramArrayOfByte);
    }
    return false;
  }
  
  public String Fa()
  {
    return "大于100MB的文件只能保存7天";
  }
  
  public boolean Pp()
  {
    return this.ajo;
  }
  
  public atyz a()
  {
    if (this.jdField_a_of_type_Atyz == null) {
      this.jdField_a_of_type_Atyz = new auao(this);
    }
    return this.jdField_a_of_type_Atyz;
  }
  
  public atza a()
  {
    if (this.jdField_b_of_type_Atza == null) {
      this.jdField_b_of_type_Atza = new auar(this);
    }
    return this.jdField_b_of_type_Atza;
  }
  
  public atzb a()
  {
    return null;
  }
  
  public void a(int paramInt, atzy.a parama)
  {
    super.a(paramInt, parama);
    ThreadManager.executeOnFileThread(new TIMCloudFileModel.7(this, paramInt));
  }
  
  protected void a(agsd paramagsd, int paramInt)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    localObject = paramagsd.b();
    int i = audx.g((FileManagerEntity)localObject);
    if (((FileManagerEntity)localObject).fromCloudFile) {
      i = 4;
    }
    for (;;)
    {
      ((ateh)this.mAppInterface.getBusinessHandler(180)).a(paramagsd.b(), paramInt, i);
      return;
    }
  }
  
  public String aC()
  {
    Object localObject = this.jdField_c_of_type_Agsd.b().cloudFile;
    if ((localObject != null) && (!aqhq.fileExists(((CloudFile)localObject).finalPath)))
    {
      localObject = athu.a((CloudFile)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return localObject;
      }
    }
    return super.aC();
  }
  
  public int bE()
  {
    int j = 7;
    int i = super.bE();
    if (i != 0) {}
    do
    {
      do
      {
        return i;
        switch (getFileType())
        {
        case 3: 
        default: 
          return 7;
        case 0: 
          return 6;
        case 2: 
          return 2;
        case 4: 
          i = j;
        }
      } while (!audx.b(this.mAppInterface, this.jdField_c_of_type_Agsd));
      i = j;
    } while (!audx.b(this.mContext, getFileName(), getFileSize()));
    return 5;
    return 1;
  }
  
  public int bL()
  {
    int i = super.bL();
    if (bI() == 10) {
      i = 6;
    }
    return i;
  }
  
  public boolean cm()
  {
    return true;
  }
  
  public void djr()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    if (bG() == 9)
    {
      if (!aJm()) {
        break label113;
      }
      atvw localatvw = new atvw(5);
      localatvw.g(localFileManagerEntity.pDirKey, new String(localFileManagerEntity.cloudId));
      localatvw.y(localFileManagerEntity.strFileSHA, localFileManagerEntity.strFileMd5, localFileManagerEntity.fileSize);
      localatvw.o(Boolean.valueOf(localFileManagerEntity.isSend()));
      localatvw.setUin(this.mAppInterface.getCurrentAccountUin());
      this.mAppInterface.a().a(localatvw);
    }
    for (;;)
    {
      a(this.jdField_c_of_type_Agsd, 5);
      return;
      label113:
      this.mAppInterface.a().a(new atge(localFileManagerEntity.pDirKey, localFileManagerEntity.cloudId));
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if ((paramIntent == null) || (!paramIntent.hasExtra("key_selected_dir"))) {
        break label382;
      }
    }
    label266:
    label340:
    label382:
    for (FileInfo localFileInfo = (FileInfo)paramIntent.getParcelableExtra("key_selected_dir");; localFileInfo = null)
    {
      Object localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(this.jdField_c_of_type_Agsd.b());
      paramIntent = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      auhk.e locale = this.jdField_a_of_type_Atjx.a(2);
      switch (paramInt1)
      {
      }
      do
      {
        for (;;)
        {
          return;
          if (localFileInfo != null)
          {
            localObject1 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = ((Iterator)localObject1).next();
              if ((localObject2 instanceof PadInfo)) {
                ((ateh)paramIntent.getBusinessHandler(180)).a(localFileInfo.Y(), athu.a((PadInfo)localObject2));
              } else if (((localObject2 instanceof FileManagerEntity)) && (locale != null) && (localFileInfo.Y() != null)) {
                locale.a(((FileManagerEntity)localObject2).cloudFile.pLogicDirKey, aueh.a((FileManagerEntity)localObject2), localFileInfo.Y(), 4);
              }
            }
          }
        }
      } while ((locale == null) || (localFileInfo == null) || (localFileInfo.Y() == null));
      Object localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      paramIntent = null;
      Object localObject3;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (!(localObject3 instanceof FileManagerEntity)) {
          break label340;
        }
        ((List)localObject1).add(aueh.a((FileManagerEntity)localObject3));
        paramIntent = ((FileManagerEntity)localObject3).pDirKey;
      }
      for (;;)
      {
        if (paramIntent != null) {
          locale.a(paramIntent, (List)localObject1, localFileInfo.Y());
        }
        break label266;
        break;
        if ((localObject3 instanceof atin))
        {
          ((List)localObject1).add(aueh.a((atin)localObject3));
          paramIntent = ((atin)localObject3).a.pLogicDirKey;
        }
      }
    }
  }
  
  public ArrayList<aufa.b> er()
  {
    if (bG() == 0) {}
    FileManagerEntity localFileManagerEntity;
    String str;
    boolean bool;
    do
    {
      return null;
      localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
      str = getFilePath();
      bool = aueh.fileExistsAndNotEmpty(str);
    } while (((localFileManagerEntity == null) && (TextUtils.isEmpty(str))) || (bF() == 16) || ((!bool) && (localFileManagerEntity != null) && (localFileManagerEntity.isZipInnerFile)));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(aufa.a(2130837660, "发给好友", atxh.a(this.jdField_e_of_type_Agsa, localFileManagerEntity, this.mContext, this.jdField_a_of_type_Atjx.a(2))));
    if ((localFileManagerEntity.getCloudType() == 3) || (localFileManagerEntity.getCloudType() == 5) || (localFileManagerEntity.getCloudType() == 1) || ((localFileManagerEntity.getCloudType() == 9) && (!localFileManagerEntity.fromCloudFile))) {
      localArrayList.add(aufa.a(2130837668, this.mContext.getString(2131693559), atxh.a(this.mContext, localFileManagerEntity)));
    }
    if ((bool) && (audx.fM(localFileManagerEntity.fileName) == 0)) {
      localArrayList.add(aufa.a(2130837669, "保存到手机", new auas(this)));
    }
    if ((localFileManagerEntity != null) && ((!localFileManagerEntity.fromCloudFile) || (audx.isLocalFile(localFileManagerEntity.getFilePath()))) && (ault.cm(localFileManagerEntity.strFilePath, localFileManagerEntity.fileName))) {
      localArrayList.add(aufa.a(2130837657, "在线编辑", atxh.a(localFileManagerEntity, this.mContext)));
    }
    if (bool) {
      localArrayList.add(aufa.a(2130837671, "邮件", atxh.b(this.mContext, str, localFileManagerEntity, null)));
    }
    a(bool, localArrayList, localFileManagerEntity, str);
    if (bool) {
      localArrayList.add(aufa.a(2130837665, "用其他应用打开", atxh.a(this.mContext, str, localFileManagerEntity, null)));
    }
    return localArrayList;
  }
  
  public void iC()
  {
    super.iC();
  }
  
  protected void ix()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (this.jdField_e_of_type_ComTencentCloudfileCloudFileCallbackCenter != null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_c_of_type_Atgd != null);
      this.jdField_c_of_type_Atgd = new auak(this);
      this.jdField_e_of_type_ComTencentCloudfileCloudFileCallbackCenter = new aual(this, localQQAppInterface);
      this.jdField_a_of_type_Atsn = new auam(this, localQQAppInterface);
      this.jdField_b_of_type_Aths$a = new auan(this);
      atgi.a().a(this.jdField_e_of_type_ComTencentCloudfileCloudFileCallbackCenter);
      localQQAppInterface.a().addObserver(this.jdField_a_of_type_Atsn);
      localQQAppInterface.addObserver(this.jdField_c_of_type_Atgd);
      aths.a().a(this.jdField_b_of_type_Aths$a);
    } while ((!aqhq.fileExistsAndNotEmpty(getFilePath())) || (this.aab != 0L) || (getFileType() == 0));
    a(this.jdField_c_of_type_Agsd, 4);
  }
  
  protected void removeObserver()
  {
    if (this.jdField_e_of_type_ComTencentCloudfileCloudFileCallbackCenter != null)
    {
      atgi.c(this.jdField_e_of_type_ComTencentCloudfileCloudFileCallbackCenter);
      this.jdField_e_of_type_ComTencentCloudfileCloudFileCallbackCenter = null;
    }
    if (this.jdField_b_of_type_Aths$a != null)
    {
      aths.a().b(this.jdField_b_of_type_Aths$a);
      this.jdField_b_of_type_Aths$a = null;
    }
    if (this.jdField_a_of_type_Atsn != null)
    {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().deleteObserver(this.jdField_a_of_type_Atsn);
      this.jdField_a_of_type_Atsn = null;
    }
    if (this.jdField_c_of_type_Atgd != null)
    {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_c_of_type_Atgd);
      this.jdField_c_of_type_Atgd = null;
    }
    if (this.jdField_a_of_type_Atjx != null) {
      this.jdField_a_of_type_Atjx.onDestroy();
    }
  }
  
  public List<atzy.a> u()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.BG != null)
    {
      Iterator localIterator = this.BG.iterator();
      while (localIterator.hasNext())
      {
        agsd localagsd = (agsd)localIterator.next();
        localArrayList.add(new atzd(localagsd, localagsd.b().cloudId, localagsd.b().pDirKey));
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auaj
 * JD-Core Version:    0.7.0.1
 */