import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsVideo;
import com.tencent.tim.filemanager.fileviewer.model.TroopFileModel.11;
import com.tencent.tim.filemanager.fileviewer.model.TroopFileModel.8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class auau
  extends atzs
{
  private accd jdField_a_of_type_Accd;
  private smq.m jdField_a_of_type_Smq$m;
  private atgd b;
  private String bJk = "";
  private String bJn;
  private apsd.c c;
  
  public auau(Activity paramActivity, List<agsd> paramList, int paramInt)
  {
    super(paramActivity);
    V(paramList, paramInt);
  }
  
  private void d(apcy paramapcy)
  {
    this.mContext.runOnUiThread(new TroopFileModel.8(this, paramapcy));
  }
  
  protected apcy a(FileManagerEntity paramFileManagerEntity)
  {
    return apsv.a(this.mAppInterface, paramFileManagerEntity);
  }
  
  public atyz a()
  {
    if (this.jdField_a_of_type_Atyz == null) {
      this.jdField_a_of_type_Atyz = new aube(this);
    }
    return this.jdField_a_of_type_Atyz;
  }
  
  public atza a()
  {
    return new auba(this);
  }
  
  public atzb a()
  {
    if (this.jdField_a_of_type_Atzb == null) {
      this.jdField_a_of_type_Atzb = new aubd(this);
    }
    return this.jdField_a_of_type_Atzb;
  }
  
  public void a(agsd paramagsd, int paramInt)
  {
    ateh localateh = (ateh)this.mAppInterface.getBusinessHandler(180);
    if (localateh != null) {
      localateh.a(paramagsd.b(), paramInt, 3);
    }
  }
  
  public void a(atzy.b paramb)
  {
    if (this.jdField_a_of_type_Smq$m == null) {
      this.jdField_a_of_type_Smq$m = new auax(this, paramb);
    }
    ThreadManager.post(new TroopFileModel.11(this, this.jdField_c_of_type_Agsd.b(), paramb), 8, null, true);
  }
  
  public boolean a(atzy.b paramb)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    TroopManager localTroopManager = (TroopManager)this.mAppInterface.getManager(52);
    if (localTroopManager == null) {}
    TroopInfo localTroopInfo;
    do
    {
      return false;
      localTroopInfo = localTroopManager.b(String.valueOf(localFileManagerEntity.TroopUin));
    } while (localTroopInfo == null);
    if (NetConnInfoCenter.getServerTimeMillis() <= localTroopInfo.mTroopFileVideoReqInterval)
    {
      if (localTroopInfo.mTroopFileVideoIsWhite != 0)
      {
        if (paramb != null) {
          paramb.djB();
        }
        anot.a(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "0", "", "", "");
        return true;
      }
      if (paramb != null) {
        paramb.djC();
      }
      if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {}
      for (paramb = "0";; paramb = "-1")
      {
        anot.a(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", paramb, "-1", "-1");
        break;
      }
    }
    atye.a(this.mAppInterface, localFileManagerEntity.TroopUin, new aubf(this, paramb, localTroopInfo, localTroopManager));
    return true;
  }
  
  public String aA()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    StringBuilder localStringBuilder = new StringBuilder(aueh.g(getFileSize()));
    if ((104 == localFileManagerEntity.busId) && (localFileManagerEntity.lastTime > 0L))
    {
      localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131693588));
      localStringBuilder.append(apsv.i(BaseApplicationImpl.getContext(), localFileManagerEntity.lastTime));
    }
    return localStringBuilder.toString();
  }
  
  public void ax(int paramInt)
  {
    super.ax(paramInt);
    Object localObject;
    String str;
    if (paramInt == 6)
    {
      localObject = this.jdField_c_of_type_Agsd.b();
      if (localObject != null)
      {
        str = String.valueOf(((FileManagerEntity)localObject).TroopUin);
        if (localObject == null) {
          break label79;
        }
        localObject = audx.el(((FileManagerEntity)localObject).nFileType);
        label45:
        anot.a(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, str, "", (String)localObject, "1");
      }
    }
    label79:
    do
    {
      return;
      str = "";
      break;
      localObject = "unknow";
      break label45;
      if (paramInt == 4)
      {
        if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {}
        for (str = "0";; str = "-1")
        {
          anot.a(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", str, "-1", "-1");
          return;
        }
      }
    } while (paramInt != 8);
    anot.a(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "video_file_preview", 0, 0, "", "", "", "");
  }
  
  public int bE()
  {
    int j = 7;
    int k = getFileType();
    int i = super.bE();
    if (i != 0) {}
    do
    {
      do
      {
        return i;
        switch (k)
        {
        case 1: 
        case 3: 
        default: 
          return 7;
        case 0: 
          return 6;
        case 4: 
          i = j;
        }
      } while (!audx.b(this.mAppInterface, this.jdField_c_of_type_Agsd));
      i = j;
    } while (!audx.b(this.mContext, getFileName(), getFileSize()));
    return 5;
    return 8;
  }
  
  public int bF()
  {
    int j = 1;
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    int k = apsv.a(this.mAppInterface, localFileManagerEntity).Status;
    int i;
    if ((k == 3) || (k == 2) || (k == 10) || (k == 9)) {
      i = 3;
    }
    do
    {
      do
      {
        return i;
        if ((k == 8) || (k == 1) || (k == 4)) {
          return 2;
        }
        i = j;
      } while (k == 6);
      i = j;
    } while (k == 11);
    if (k == 12) {
      return 16;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileModel", 2, "TroopFileModel getFileStatus : can not change troop file status to FMConstants status");
    }
    return super.bF();
  }
  
  public int bK()
  {
    int i = 2;
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    int j = apsv.a(this.mAppInterface, localFileManagerEntity).Status;
    if ((j == 3) || (j == 2) || (j == 1)) {
      i = 1;
    }
    return i;
  }
  
  public boolean cn()
  {
    if (this.mAppInterface == null) {}
    int i;
    do
    {
      return false;
      i = bL();
    } while (((i != 5) && (i != 2)) || (!QLog.isColorLevel()));
    QLog.i("TroopFileModel", 2, "can not auto download file : [fileStatus] = " + i);
    return false;
  }
  
  public void djr()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    super.djr();
    if (bG() == 4)
    {
      apcy localapcy = apsv.a(this.mAppInterface, localFileManagerEntity);
      this.mAppInterface.a().a(new apcq(this.mAppInterface, localFileManagerEntity.TroopUin, localapcy));
      a(this.jdField_c_of_type_Agsd, 5);
    }
  }
  
  public ArrayList<aufa.b> er()
  {
    int i = bG();
    if ((i == 5) || (i == 4))
    {
      FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
      if ((localFileManagerEntity == null) || (localFileManagerEntity.isZipInnerFile)) {}
      while (localFileManagerEntity.status == 16) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(aufa.a(2130837660, "发给好友", atxh.b(this.e, localFileManagerEntity, this.mContext)));
      localArrayList.add(aufa.a(2130837668, "存云文件", atxh.f(this.e, localFileManagerEntity)));
      if ((localFileManagerEntity != null) && (ault.cm(localFileManagerEntity.strFilePath, localFileManagerEntity.fileName))) {
        localArrayList.add(aufa.a(2130837657, "在线编辑", atxh.a(localFileManagerEntity, this.mContext)));
      }
      String str = getFilePath();
      boolean bool = aueh.fileExistsAndNotEmpty(str);
      if ((bool) && (auen.sW(str)) && (auen.cx(this.e.getApp())))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileModel", 2, "TroopFileModel getMenu add wpsedit btn ");
        }
        localArrayList.add(aufa.a(2130837659, this.mContext.getString(2131693885), atxh.a(this.e, localFileManagerEntity, this.mContext, null)));
      }
      if (bool) {
        localArrayList.add(aufa.a(2130837671, "邮件", atxh.b(this.mContext, str, localFileManagerEntity, null)));
      }
      return localArrayList;
    }
    return super.er();
  }
  
  public long getUin()
  {
    if (this.jdField_c_of_type_Agsd != null) {
      return this.jdField_c_of_type_Agsd.b().TroopUin;
    }
    return super.getUin();
  }
  
  public void iC()
  {
    if (this.jdField_c_of_type_Agsd != null)
    {
      smq.a(this.mAppInterface, this.jdField_c_of_type_Agsd.b().TroopUin, this.jdField_c_of_type_Agsd.b().strTroopFilePath, this.jdField_c_of_type_Agsd.b().busId, new auav(this));
      smq.a(this.mAppInterface, this.jdField_c_of_type_Agsd.b().TroopUin, this.jdField_c_of_type_Agsd.b().busId, this.jdField_c_of_type_Agsd.b().strTroopFilePath, new auaz(this));
    }
  }
  
  protected void ix()
  {
    if (this.jdField_a_of_type_Accd == null)
    {
      this.jdField_a_of_type_Accd = new aubb(this);
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "add troopObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.jdField_a_of_type_Accd);
    }
    if (this.jdField_c_of_type_Apsd$c == null)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
      if (localFileManagerEntity != null)
      {
        this.jdField_c_of_type_Apsd$c = new apsd.c(this.mContext, localFileManagerEntity.TroopUin, this.mAppInterface);
        apsd.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this.jdField_c_of_type_Apsd$c);
      }
    }
    if (this.b == null)
    {
      this.b = new aubc(this);
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.b);
    }
    if ((aqhq.fileExistsAndNotEmpty(getFilePath())) && (this.aab == 0L) && (getFileType() != 0)) {
      a(this.jdField_c_of_type_Agsd, 4);
    }
  }
  
  protected void removeObserver()
  {
    if (this.jdField_a_of_type_Accd != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del troopObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_Accd);
      this.jdField_a_of_type_Accd = null;
    }
    if (this.jdField_c_of_type_Apsd$c != null)
    {
      apsd.b(this.mAppInterface, this.jdField_c_of_type_Apsd$c);
      this.jdField_c_of_type_Apsd$c = null;
    }
    if (this.b != null)
    {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.b);
      this.b = null;
    }
    this.jdField_a_of_type_Accd = null;
    this.jdField_c_of_type_Apsd$c = null;
    this.jdField_a_of_type_Smq$m = null;
  }
  
  public List<atzy.a> u()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.BG != null)
    {
      Iterator localIterator = this.BG.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new atze((agsd)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  public String ve()
  {
    if (bE() == 2)
    {
      apcy localapcy = a(this.jdField_c_of_type_Agsd.b());
      if (TextUtils.isEmpty(this.bJk))
      {
        this.bJk = (localapcy.FilePath + "_" + System.currentTimeMillis());
        QLog.i("TroopFileModel", 1, "getContextId: troop video file random contextId: " + this.bJk);
      }
      return this.bJk;
    }
    return super.ve();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auau
 * JD-Core Version:    0.7.0.1
 */