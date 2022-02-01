import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

public abstract class agts
  extends aguk
{
  protected List<agsd> BG;
  private TeamWorkFileImportInfo a;
  protected String aEI;
  protected String aEJ;
  protected String aEK;
  protected long aab;
  protected String bJj;
  private String bJk = "";
  public agsd c;
  public QQAppInterface mAppInterface;
  protected String str_download_dns;
  
  public agts(Activity paramActivity)
  {
    super(paramActivity);
    this.mContext = paramActivity;
    this.mAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private ArrayList<ShareActionSheetBuilder.ActionSheetItem> a(FileManagerEntity paramFileManagerEntity)
  {
    int j = 0;
    String str = getFilePath();
    boolean bool = ahbj.fileExistsAndNotEmpty(str);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ahbr.a(2, agqm.a(this.e, paramFileManagerEntity, this.mContext)));
    localArrayList.add(ahbr.a(26, new agtx(this, paramFileManagerEntity)));
    aetd localaetd = aete.a();
    int i;
    if ((localaetd != null) && (paramFileManagerEntity != null) && (localaetd.es().contains(ahbj.getExtension(paramFileManagerEntity.fileName).replace(".", "").toLowerCase())))
    {
      i = 1;
      if (i != 0)
      {
        localArrayList.add(ahbr.a(120, agqm.a(paramFileManagerEntity, this.mContext, true)));
        aodb.aN(getAppInterface(), "0X800A21C");
      }
      if (avlx.a().F(paramFileManagerEntity)) {
        localArrayList.add(ahbr.a(118, null));
      }
      i = j;
      if (paramFileManagerEntity != null)
      {
        i = j;
        if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId))
        {
          i = j;
          if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunDirKey)) {
            i = 1;
          }
        }
      }
      if (i == 0)
      {
        if (!bool) {
          break label325;
        }
        localArrayList.add(ahbr.a(27, agqm.a(this.e, str)));
      }
      label228:
      if ((paramFileManagerEntity == null) || ((paramFileManagerEntity.getCloudType() != 3) && (paramFileManagerEntity.getCloudType() != 5) && (paramFileManagerEntity.getCloudType() != 1) && ((paramFileManagerEntity.getCloudType() != 9) || (paramFileManagerEntity.fromCloudFile)))) {
        break label355;
      }
      localArrayList.add(ahbr.a(144, atxh.a(this.mContext, paramFileManagerEntity)));
    }
    for (;;)
    {
      if (bool) {
        localArrayList.add(ahbr.a(64, agqm.a(this.mContext, str)));
      }
      return localArrayList;
      i = 0;
      break;
      label325:
      if (bG() != 1) {
        break label228;
      }
      localArrayList.add(ahbr.a(27, agqm.a(this.e, paramFileManagerEntity)));
      break label228;
      label355:
      if (bool)
      {
        paramFileManagerEntity = new FileManagerEntity();
        paramFileManagerEntity.strFilePath = str;
        paramFileManagerEntity.setCloudType(3);
        paramFileManagerEntity.fileSize = getFileSize();
        localArrayList.add(ahbr.a(144, atxh.a(this.mContext, paramFileManagerEntity)));
      }
    }
  }
  
  private ArrayList<ShareActionSheetBuilder.ActionSheetItem> b(FileManagerEntity paramFileManagerEntity)
  {
    String str = getFilePath();
    boolean bool1 = ahbj.fileExistsAndNotEmpty(str);
    ArrayList localArrayList = new ArrayList();
    int j = bM();
    int i;
    if ((j != 0) && (this.e != null) && (this.e.shouldDisplayColorNote()))
    {
      i = 70;
      if (j != 1) {
        break label481;
      }
      i = 70;
    }
    for (;;)
    {
      localArrayList.add(ahbr.a(i, new agty(this, j)));
      if ((ahav.getFileType(paramFileManagerEntity.fileName) == 0) && (bool1)) {
        localArrayList.add(ahbr.a(39, null));
      }
      if (ahav.q(paramFileManagerEntity)) {
        localArrayList.add(ahbr.a(6, agqm.b(this.e, paramFileManagerEntity)));
      }
      Object localObject2 = aeuc.a();
      Object localObject1 = aetq.a();
      if ((localObject2 != null) && (localObject1 != null))
      {
        localObject2 = ((aeub)localObject2).ud();
        boolean bool2 = ((aetp)localObject1).ahU();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = aobw.cjR;
        }
        long l = ahav.d(this.mAppInterface, paramFileManagerEntity.fileName);
        if ((bool2) && (aobw.v(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileName, (String)localObject1)) && (paramFileManagerEntity.fileSize <= l))
        {
          localObject1 = ahbr.a(119, agqm.a(paramFileManagerEntity, this.mContext));
          anot.a(this.mAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
          localArrayList.add(localObject1);
        }
      }
      if (agyj.c(paramFileManagerEntity, bool1))
      {
        localArrayList.add(ahbr.a(122, agqm.a(this.mContext, paramFileManagerEntity, str)));
        localArrayList.add(ahbr.a(123, agqm.b(this.mContext, paramFileManagerEntity, str)));
      }
      if ((aklr.ae(this.mAppInterface.getCurrentAccountUin(), 1)) && (getFileType() == 0) && ((aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath)) || (aqhq.fileExistsAndNotEmpty(str)))) {
        localArrayList.add(ahbr.a(52, null));
      }
      if (getFileType() == 0) {
        kL(localArrayList);
      }
      if (bool1)
      {
        if (((acde)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(8)).b.B(getFileName())) {
          localArrayList.add(ahbr.a(121, agqm.b(this.e, getFilePath())));
        }
        if (QbSdk.isInDefaultBrowser(this.mContext, str)) {
          localArrayList.add(ahbr.a(132, null));
        }
      }
      return localArrayList;
      label481:
      if (j == 2) {
        i = 82;
      }
    }
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
    if ((localObject != null) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).WeiYunFileId))) {
      this.mAppInterface.a().a(new agms(this.mAppInterface, this.jdField_c_of_type_Agsd.getFileId(), this.jdField_c_of_type_Agsd.b().WeiYunDirKey));
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Agku == null) {
        this.jdField_c_of_type_Agku = this.mAppInterface.a().a();
      }
      if (this.b == null) {
        this.b = new agtt(this, j);
      }
      if (this.jdField_c_of_type_Agku != null)
      {
        this.jdField_c_of_type_Agku.a(this.b);
        this.jdField_c_of_type_Agku.alr();
      }
      return;
      if (i == 2)
      {
        if (this.jdField_c_of_type_Agsd.b() == null) {}
        for (localObject = "";; localObject = this.jdField_c_of_type_Agsd.b().dirKey)
        {
          this.mAppInterface.a().a(new agms(this.mAppInterface, this.jdField_c_of_type_Agsd.getFileId(), (String)localObject));
          break;
        }
      }
      if ((i == 1) || (i == 3))
      {
        if (j == 3000) {
          this.mAppInterface.a().a(new agjx(this.mAppInterface, this.jdField_c_of_type_Agsd.getUuid(), this.jdField_c_of_type_Agsd.ay()));
        } else {
          this.mAppInterface.a().a(new aglj(this.mAppInterface, this.jdField_c_of_type_Agsd.getUuid(), this.jdField_c_of_type_Agsd.getFileId()));
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase", 2, "loadZipFilesForOthers error. can not handle zip file");
      }
    }
  }
  
  private QQAppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
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
  
  public agsu a()
  {
    if (this.jdField_a_of_type_Agsu == null) {
      this.jdField_a_of_type_Agsu = new agtw(this);
    }
    return this.jdField_a_of_type_Agsu;
  }
  
  public TeamWorkFileImportInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  }
  
  public void a(int paramInt, aguk.a parama)
  {
    agsd localagsd = ((agsx)parama).b();
    if (localagsd == null) {
      ahao.JE(BaseApplicationImpl.getContext().getString(2131693595));
    }
    do
    {
      return;
      if ((ahav.o(localagsd.b())) && (1 == localagsd.getCloudType())) {
        ahao.JE(BaseApplicationImpl.getContext().getString(2131693595));
      }
    } while (localagsd.vF() != null);
    localagsd.setState(1);
    parama.setState(1);
  }
  
  protected void a(agsd paramagsd, int paramInt) {}
  
  public void a(aguk.b paramb) {}
  
  public void a(aguk.d paramd)
  {
    this.jdField_a_of_type_Aguk$d = paramd;
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {}
    int i;
    do
    {
      Object localObject1;
      do
      {
        do
        {
          do
          {
            Object localObject2;
            do
            {
              do
              {
                return;
                localObject1 = this.jdField_c_of_type_Agsd.b();
                localObject2 = getFilePath();
              } while ((localObject1 == null) && (TextUtils.isEmpty((CharSequence)localObject2)));
              i = paramActionSheetItem.action;
              Ow(i);
              if (i == 73)
              {
                agqm.a(this.e, (FileManagerEntity)localObject1, this.mContext).onClick(null);
                return;
              }
              if (i != 72) {
                break;
              }
              i = paramActionSheetItem.uinType;
              paramActionSheetItem = paramActionSheetItem.uin;
            } while (TextUtils.isEmpty(paramActionSheetItem));
            ahbr.b(this.mAppInterface, this.mContext, (FileManagerEntity)localObject1, true, paramActionSheetItem, i);
            return;
            if (i == 39)
            {
              if (!CheckPermission.isHasStoragePermission(this.mContext))
              {
                CheckPermission.requestSDCardPermission((AppActivity)this.mContext, new agub(this));
                return;
              }
              ahav.by(this.mContext, getFilePath());
              return;
            }
            if (i != 52) {
              break;
            }
            localObject1 = getFilePath();
            paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
            if (!aqhq.fileExistsAndNotEmpty((String)localObject1))
            {
              localObject2 = this.jdField_c_of_type_Agsd.b();
              paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
              if (localObject2 != null) {
                paramActionSheetItem = ((FileManagerEntity)localObject2).strLargeThumPath;
              }
            }
          } while (!aqhq.fileExistsAndNotEmpty(paramActionSheetItem));
          OCRPerformFragment.b(this.mContext, paramActionSheetItem, 1, -1004, null);
          return;
          if (i != 55) {
            break;
          }
          localObject1 = az();
        } while (!aqhq.fileExistsAndNotEmpty((String)localObject1));
        ahbr.c(this.mContext, (String)localObject1, paramActionSheetItem.argus, null, 1);
        anot.a(null, "dc00898", "", "", "0X800AD47", "0X800AD47", agsg.hJ(this.cYK), 0, "", "", "", "");
        return;
        if (i != 56) {
          break;
        }
        localObject1 = az();
      } while (!aqhq.fileExistsAndNotEmpty((String)localObject1));
      ahbr.c(this.mContext, (String)localObject1, paramActionSheetItem.argus, null, 2);
      anot.a(null, "dc00898", "", "", "0X800AD48", "0X800AD48", agsg.hJ(this.cYK), 0, "", "", "", "");
      return;
      if (i == 118)
      {
        agqm.c(this.e, (FileManagerEntity)localObject1).onClick(null);
        return;
      }
    } while (i != 132);
    QbSdk.clearDefaultBrowser(this.mContext, getFilePath());
    ahav.F(this.mContext, getFilePath());
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString6, short paramShort, String paramString7, smq.j paramj)
  {
    String str1;
    String str2;
    if (paramBoolean)
    {
      str1 = "https://";
      str2 = str1 + paramString1 + ":" + paramShort + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + aurr.encodeUrl(paramString4) + "&";
      if (!ahbr.amL()) {
        break label351;
      }
    }
    label351:
    for (paramString7 = str1 + paramString7 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + aurr.encodeUrl(paramString4) + "&";; paramString7 = str2)
    {
      if (paramFileManagerEntity.getCloudType() == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramString1 = new aprc(paramString7, "GET", new agtv(this, new ArrayList(), paramString4, paramFileManagerEntity, bool, paramString5, paramBoolean, paramString6, paramString1, paramShort, paramString3, paramInt, paramString2, paramj), 1000, null);
        paramString2 = new Bundle();
        paramString2.putString("version", aqgz.getQQVersion());
        paramString2.putString("Cookie", "FTN5K=" + paramString5);
        if (paramBoolean) {
          paramString2.putString("Referer", "https://" + paramString6);
        }
        paramString3 = new HashMap();
        paramString3.put("BUNDLE", paramString2);
        paramString3.put("CONTEXT", this.mAppInterface.getApp().getApplicationContext());
        paramString1.J(paramString3);
        return;
        str1 = "http://";
        break;
      }
    }
  }
  
  protected void a(boolean paramBoolean, agzy paramagzy, long paramLong, ahal.a parama)
  {
    paramagzy.a(paramBoolean, this.mContext, parama);
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    Object localObject1 = this.jdField_c_of_type_Agsd.b();
    Object localObject2 = getFilePath();
    boolean bool = ahbj.fileExistsAndNotEmpty((String)localObject2);
    if ((localObject1 == null) && (TextUtils.isEmpty((CharSequence)localObject2))) {}
    while ((bF() == 16) || ((!bool) && (localObject1 != null) && (((FileManagerEntity)localObject1).isZipInnerFile))) {
      return null;
    }
    if ((localObject1 == null) && (bool)) {}
    for (;;)
    {
      try
      {
        localObject2 = ahav.a(new FileInfo((String)localObject2));
        localObject1 = localObject2;
        if (localObject1 == null) {
          break;
        }
        localObject2 = a((FileManagerEntity)localObject1);
        localObject1 = b((FileManagerEntity)localObject1);
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty())) {
          localArrayList1.addAll((Collection)localObject2);
        }
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {
          localArrayList2.addAll((Collection)localObject1);
        }
        return new ArrayList[] { localArrayList1, localArrayList2 };
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
      }
    }
  }
  
  public String aA()
  {
    return ahbj.g(getFileSize());
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
    } while ((localFileManagerEntity == null) || (!localFileManagerEntity.isZipInnerFile) || (!ahbj.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())));
    localFileManagerEntity.status = 1;
  }
  
  public void aI(int paramInt)
  {
    if (this.jdField_c_of_type_Agsd == null) {
      return;
    }
    if ((this.e != null) && (this.e.bY())) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = aobw.a(this.jdField_c_of_type_Agsd.b(), bool);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.dNQ = paramInt;
      return;
    }
  }
  
  public void at(boolean paramBoolean)
  {
    if ((this.jdField_c_of_type_Agsd != null) && (this.jdField_c_of_type_Agsd.b() != null)) {
      this.jdField_c_of_type_Agsd.b().bCannotPlay = true;
    }
  }
  
  public String ax()
  {
    return "biz_src_jc_file";
  }
  
  public void ax(int paramInt) {}
  
  public String ay()
  {
    if (this.jdField_c_of_type_Agsd != null) {
      return this.jdField_c_of_type_Agsd.ay();
    }
    return "";
  }
  
  public String az()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    if (localFileManagerEntity == null) {
      return "";
    }
    int i = ahav.getFileType(localFileManagerEntity.fileName);
    if (i == 0)
    {
      if (aqhq.fileExistsAndNotEmpty(getFilePath())) {
        return getFilePath();
      }
    }
    else if ((i == 2) && (aqhq.fileExistsAndNotEmpty(this.bJl))) {
      return this.bJl;
    }
    return super.az();
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FileManagerEntity localFileManagerEntity1 = this.jdField_c_of_type_Agsd.b();
    String str = getFilePath();
    boolean bool = ahbj.fileExistsAndNotEmpty(str);
    localArrayList1.add(ahbr.a(2, agqm.a(this.e, localFileManagerEntity1, this.mContext)));
    localArrayList1.add(ahbr.a(26, new agtz(this, localFileManagerEntity1)));
    if (!bool)
    {
      localArrayList1.add(ahbr.a(27, agqm.a(this.e, localFileManagerEntity1)));
      if ((localFileManagerEntity1 == null) || ((localFileManagerEntity1.getCloudType() != 3) && (localFileManagerEntity1.getCloudType() != 5) && (localFileManagerEntity1.getCloudType() != 1) && ((localFileManagerEntity1.getCloudType() != 9) || (localFileManagerEntity1.fromCloudFile)))) {
        break label369;
      }
      localArrayList1.add(ahbr.a(144, atxh.a(this.mContext, localFileManagerEntity1)));
    }
    for (;;)
    {
      if (bool) {
        localArrayList1.add(ahbr.a(64, new agua(this)));
      }
      if (bool) {
        localArrayList2.add(ahbr.a(39, null));
      }
      if (ahav.q(this.jdField_c_of_type_Agsd.b())) {
        localArrayList2.add(ahbr.a(6, agqm.b(this.e, localFileManagerEntity1)));
      }
      if (agyj.c(localFileManagerEntity1, bool))
      {
        localArrayList2.add(ahbr.a(122, agqm.a(this.mContext, localFileManagerEntity1, str)));
        localArrayList2.add(ahbr.a(123, agqm.b(this.mContext, localFileManagerEntity1, str)));
      }
      kM(localArrayList2);
      kM(localArrayList2);
      if ((bool) && (QbSdk.isInDefaultBrowser(this.mContext, str))) {
        localArrayList2.add(ahbr.a(132, null));
      }
      return new ArrayList[] { localArrayList1, localArrayList2 };
      localArrayList1.add(ahbr.a(27, agqm.a(this.e, str)));
      break;
      label369:
      if (bool)
      {
        FileManagerEntity localFileManagerEntity2 = new FileManagerEntity();
        localFileManagerEntity2.strFilePath = str;
        localFileManagerEntity2.setCloudType(3);
        localFileManagerEntity2.fileSize = getFileSize();
        localArrayList1.add(ahbr.a(144, atxh.a(this.mContext, localFileManagerEntity2)));
      }
    }
  }
  
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
    int j = 2;
    int k = 1;
    int m = bI();
    int i;
    if ((bG() == 0) && (m != 10)) {
      i = 4;
    }
    do
    {
      return i;
      i = k;
      switch (m)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.w("FileBrowserModelBase<FileAssistant>", 2, "error. a unknow transfer type");
        }
        i = 2;
      }
      do
      {
        return i;
        i = k;
      } while (ahbj.fileExistsAndNotEmpty(getFilePath()));
      i = j;
    } while (!QLog.isColorLevel());
    QLog.i("FileBrowserModelBase<FileAssistant>", 1, "file is send,but not has localfile,return download status!");
    return 2;
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
    } while (ahbj.fileExistsAndNotEmpty(str));
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
      return ahav.o(this.jdField_c_of_type_Agsd.b());
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
    if ((ahav.b(this.mAppInterface, this.jdField_c_of_type_Agsd, true)) && (ahav.b(this.mContext, getFileName(), getFileSize()))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean cn()
  {
    if (this.mAppInterface == null) {}
    do
    {
      int i;
      do
      {
        return false;
        i = bL();
        if ((i != 5) && (i != 2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("FileBrowserModelBase", 2, "can not auto download file : [fileStatus] = " + i);
      return false;
    } while (!aqiw.bW(BaseApplicationImpl.getContext()));
    aepv.a locala = ((agiq)this.mAppInterface.getManager(317)).a(apqz.lb(getFileName()));
    long l = this.jdField_c_of_type_Agsd.getFileSize();
    if (((aqiw.isWifiConnected(BaseApplicationImpl.getContext())) && (l <= locala.cOu)) || (l <= locala.cOw)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean co()
  {
    if (this.jdField_c_of_type_Agsd == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return false;
      localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.isUserClick = false;
    } while ((getAppInterface() == null) || (localFileManagerEntity == null) || (!aobw.j(getFilePath(), getFileName(), getFileSize())) || (!aqiw.isNetSupport(BaseApplicationImpl.getContext())) || ((TextUtils.isEmpty(localFileManagerEntity.Uuid)) && (TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath)) && (TextUtils.isEmpty(localFileManagerEntity.getFilePath()))));
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.fileName = localFileManagerEntity.fileName;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.fileSize = localFileManagerEntity.fileSize;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.filePath = localFileManagerEntity.getFilePath();
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.nFileType = localFileManagerEntity.nFileType;
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserModelBase", 2, "file size:" + localFileManagerEntity.fileSize + " isTroopFile:" + TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath) + " isOfflineFile:" + TextUtils.isEmpty(localFileManagerEntity.Uuid) + "isLocalFile: " + TextUtils.isEmpty(localFileManagerEntity.getFilePath()));
    }
    if (this.e != null) {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.isFromAIO = this.e.bY();
    }
    if (!TextUtils.isEmpty(localFileManagerEntity.peerUin))
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.peerType = localFileManagerEntity.peerType;
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.peerUin = localFileManagerEntity.peerUin;
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.troopUin = String.valueOf(localFileManagerEntity.TroopUin);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.dNP = localFileManagerEntity.busId;
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.cjE = localFileManagerEntity.strTroopFilePath;
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.msgUniseq = localFileManagerEntity.uniseq;
      if (localFileManagerEntity.status != 16) {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.cKX = true;
      }
    }
    return true;
  }
  
  public void cqt()
  {
    super.cqt();
    if (this.jdField_c_of_type_Agku != null)
    {
      this.jdField_c_of_type_Agku.clear();
      this.jdField_c_of_type_Agku = null;
    }
  }
  
  public void djr()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    String str;
    if (bG() == 2)
    {
      if (this.jdField_c_of_type_Agsd.b() != null) {
        break label97;
      }
      if (this.jdField_c_of_type_Agsd.b() != null) {
        break label81;
      }
      str = "";
    }
    for (;;)
    {
      this.mAppInterface.a().a(new agms(this.mAppInterface, localFileManagerEntity.WeiYunFileId, str));
      a(this.jdField_c_of_type_Agsd, 5);
      return;
      label81:
      str = this.jdField_c_of_type_Agsd.b().dirKey;
      continue;
      label97:
      str = this.jdField_c_of_type_Agsd.b().WeiYunDirKey;
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
    if (this.jdField_c_of_type_Agku != null)
    {
      this.jdField_c_of_type_Agku.clear();
      this.jdField_c_of_type_Agku = null;
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ix();
    long l;
    if (ahav.isLocalFile(getFilePath()))
    {
      l = new File(getFilePath()).lastModified();
      if (this.aab != 0L) {
        break label48;
      }
      this.aab = l;
    }
    label48:
    while (this.aab == l) {
      return;
    }
    QLog.e("FileBrowserModelBase", 1, "local file is modified, and refresh file. filepath:" + getFilePath());
    this.aab = l;
  }
  
  public void eH(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((ateh)this.mAppInterface.getBusinessHandler(180)).notifyUI(30, true, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public Intent f()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    if (localFileManagerEntity == null) {
      return null;
    }
    return ahbr.a(this.mAppInterface, this.mContext, localFileManagerEntity);
  }
  
  public String getCurrentAccountUin()
  {
    if (this.mAppInterface != null) {
      return this.mAppInterface.getCurrentAccountUin();
    }
    return super.getCurrentAccountUin();
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
        ahau.JH((String)localObject1);
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
      agfk.a(this.mAppInterface, this.mContext, localFileManagerEntity, null);
      return;
    }
    try
    {
      localFileManagerEntity = ahav.a(new FileInfo(getFilePath()));
      agfk.a(this.mAppInterface, this.mContext, localFileManagerEntity, null);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
  
  public void iC()
  {
    String str;
    if (this.jdField_c_of_type_Agsd.b().bSend) {
      str = this.mAppInterface.getCurrentNickname();
    }
    for (;;)
    {
      Object localObject = new SimpleDateFormat("yyyy.MM.dd");
      localObject = " 于" + ((SimpleDateFormat)localObject).format(new Date(this.jdField_c_of_type_Agsd.b().srvTime)) + "上传";
      if (this.jdField_a_of_type_Aguk$e != null) {
        this.jdField_a_of_type_Aguk$e.fQ(str, (String)localObject);
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
      ahao.JD(BaseApplicationImpl.getContext().getString(2131693819));
      return;
    }
    djw();
    djr();
    if (aobw.i(getFilePath(), getFileName(), getFileSize()))
    {
      aobw.a(getAppInterface(), this.mContext, "FileBrowserModelBase", a());
      aobw.a(a(), null, "0X8009ECE");
      return;
    }
    Intent localIntent = new Intent(this.mContext, FilePreviewActivity.class);
    localIntent.putExtra("offline_file_type", 0);
    localIntent.putExtra("offline_file_name", getFileName());
    localIntent.putExtra("offline_file_size", getFileSize());
    if (co())
    {
      localIntent.putExtra("offline_file_show_team_work_menu", true);
      localIntent.putExtra("key_team_work_file_import_info", this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
    }
    this.mContext.startActivity(localIntent);
    this.mContext.overridePendingTransition(2130772289, 2130772290);
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
      return this.jdField_c_of_type_Agsd.b().fProgress;
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
  
  public List<aguk.a> u()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.BG != null)
    {
      Iterator localIterator = this.BG.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new agsx((agsd)localIterator.next()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agts
 * JD-Core Version:    0.7.0.1
 */