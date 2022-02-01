import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.17;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.7;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.8;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.9;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsVideo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class aguu
  extends agts
{
  private accd jdField_a_of_type_Accd;
  private smq.m jdField_a_of_type_Smq$m;
  private String bJk = "";
  private String bJn;
  private apsd.c c;
  private int cYL;
  
  public aguu(Activity paramActivity, List<agsd> paramList, int paramInt)
  {
    super(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileModel<FileAssistant>", 1, "FileBrowserModel init: type = troop");
    }
    V(paramList, paramInt);
  }
  
  private ArrayList<ShareActionSheetBuilder.ActionSheetItem> a(FileManagerEntity paramFileManagerEntity)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ahbr.a(2, agqm.d(this.e, paramFileManagerEntity)));
    localArrayList.add(ahbr.a(26, new agux(this, paramFileManagerEntity)));
    localArrayList.add(ahbr.a(27, agqm.e(this.e, paramFileManagerEntity)));
    localArrayList.add(ahbr.a(144, atxh.f(this.e, paramFileManagerEntity)));
    return localArrayList;
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, apcy paramapcy)
  {
    long l = paramFileManagerEntity.lastTime;
    Object localObject = paramFileManagerEntity.selfUin;
    boolean bool1 = paramFileManagerEntity.bSend;
    boolean bool2 = paramFileManagerEntity.isZipInnerFile;
    FileManagerEntity localFileManagerEntity = ahav.a(paramapcy);
    paramFileManagerEntity.copyFrom(localFileManagerEntity);
    paramFileManagerEntity.lastTime = l;
    paramFileManagerEntity.selfUin = ((String)localObject);
    paramFileManagerEntity.bSend = bool1;
    paramFileManagerEntity.isZipInnerFile = bool2;
    if ((this.cYK == 3) && (getFileType() == 2))
    {
      localObject = new SessionInfo();
      ((SessionInfo)localObject).cZ = 1;
      l = this.ba.getLong("troopfile_shmsgseq");
      MessageRecord localMessageRecord = this.mAppInterface.b().a(String.valueOf(paramFileManagerEntity.TroopUin), 1, l, -2017);
      Rect localRect = (Rect)this.ba.getParcelable("file_browser_params_thumb_bound");
      if (this.e != null)
      {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new TroopFileModel.8(this, localMessageRecord, (SessionInfo)localObject, paramFileManagerEntity, paramapcy, localFileManagerEntity, localRect), 100L);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new TroopFileModel.9(this, localMessageRecord), 300L);
      }
    }
    if (bG() == 3) {
      if (this.jdField_a_of_type_Aguk$d != null) {
        this.jdField_a_of_type_Aguk$d.djG();
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("TroopFileModel<FileAssistant>", 2, "file download finished, but file not exist.");
  }
  
  private boolean a(int paramInt, aguk.b paramb)
  {
    if ((paramInt == -133) || (paramInt == -132) || (paramInt == -134))
    {
      paramb.djD();
      if (QLog.isDevelopLevel()) {
        QLog.i("TroopFileModel<FileAssistant>", 4, "file invalidate retCode = " + paramInt);
      }
    }
    do
    {
      return true;
      if ((paramInt != -103) && (paramInt != -301)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("TroopFileModel<FileAssistant>", 4, "file invalidate retCode = " + paramInt);
    return true;
    return false;
  }
  
  private ArrayList<ShareActionSheetBuilder.ActionSheetItem> b(FileManagerEntity paramFileManagerEntity)
  {
    ArrayList localArrayList = new ArrayList();
    int j = bM();
    int i;
    if ((j != 0) && (this.e != null) && (this.e.shouldDisplayColorNote()))
    {
      i = 70;
      if (j != 1) {
        break label411;
      }
      i = 70;
    }
    for (;;)
    {
      localArrayList.add(ahbr.a(i, new aguy(this, j)));
      String str2 = getFilePath();
      boolean bool1 = ahbj.fileExistsAndNotEmpty(str2);
      if ((ahav.getFileType(paramFileManagerEntity.fileName) == 0) && (bool1)) {
        localArrayList.add(ahbr.a(39, null));
      }
      if (ahav.q(paramFileManagerEntity)) {
        localArrayList.add(ahbr.a(6, agqm.b(this.e, paramFileManagerEntity)));
      }
      boolean bool2 = aetq.a().ahU();
      long l = ahav.d(this.mAppInterface, paramFileManagerEntity.fileName);
      String str1 = aeuc.a().ud();
      Object localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject = aobw.cjR;
      }
      if ((bool2) && (aobw.v(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileName, (String)localObject)) && (paramFileManagerEntity.fileSize <= l))
      {
        localObject = ahbr.a(119, agqm.a(paramFileManagerEntity, this.mContext));
        anot.a(this.mAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
        localArrayList.add(localObject);
      }
      if (agyj.c(paramFileManagerEntity, bool1))
      {
        localArrayList.add(ahbr.a(122, agqm.a(this.mContext, paramFileManagerEntity, str2)));
        localArrayList.add(ahbr.a(123, agqm.b(this.mContext, paramFileManagerEntity, str2)));
      }
      paramFileManagerEntity = apsv.a(this.mAppInterface, paramFileManagerEntity);
      if ((paramFileManagerEntity != null) && (paramFileManagerEntity.Id != null) && (getFileType() == 0) && ((aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.ThumbnailFile_Large)) || (aqhq.fileExistsAndNotEmpty(str2)))) {
        localArrayList.add(ahbr.a(52, new aguz(this)));
      }
      if ((bool1) && (QbSdk.isInDefaultBrowser(this.mContext, str2))) {
        localArrayList.add(ahbr.a(132, null));
      }
      return localArrayList;
      label411:
      if (j == 2) {
        i = 82;
      }
    }
  }
  
  private void d(apcy paramapcy)
  {
    this.mContext.runOnUiThread(new TroopFileModel.7(this, paramapcy));
  }
  
  public void F(String paramString, Bundle paramBundle)
  {
    anot.a(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public agss a()
  {
    if (this.jdField_a_of_type_Agss == null) {
      this.jdField_a_of_type_Agss = new agvj(this);
    }
    return this.jdField_a_of_type_Agss;
  }
  
  public agsu a()
  {
    return new agvg(this);
  }
  
  public agsv a()
  {
    if (this.jdField_a_of_type_Agsv == null) {
      this.jdField_a_of_type_Agsv = new agvi(this);
    }
    return this.jdField_a_of_type_Agsv;
  }
  
  public agtf a()
  {
    Object localObject = this.jdField_c_of_type_Agsd.b();
    localObject = apsv.a(this.mAppInterface, (FileManagerEntity)localObject);
    return new agtf(this.mAppInterface, (apcy)localObject);
  }
  
  public void a(agsd paramagsd, int paramInt)
  {
    ateh localateh = (ateh)this.mAppInterface.getBusinessHandler(180);
    if (localateh != null) {
      localateh.a(paramagsd.b(), paramInt, 3);
    }
  }
  
  public void a(aguk.b paramb)
  {
    if (this.jdField_a_of_type_Smq$m == null) {
      this.jdField_a_of_type_Smq$m = new agvd(this, paramb);
    }
    ThreadManager.post(new TroopFileModel.17(this, this.jdField_c_of_type_Agsd.b(), paramb), 8, null, true);
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    int j = 1;
    if (paramActionSheetItem == null) {}
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_c_of_type_Agsd.b();
      Object localObject2 = getFilePath();
      if ((localObject1 != null) || (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        int k = paramActionSheetItem.action;
        int i;
        if (k == 73)
        {
          agqm.d(this.e, (FileManagerEntity)localObject1).onClick(null);
          i = j;
        }
        while (i != 0)
        {
          Ow(k);
          return;
          if (k == 72)
          {
            int m = paramActionSheetItem.uinType;
            paramActionSheetItem = paramActionSheetItem.uin;
            i = j;
            if (!TextUtils.isEmpty(paramActionSheetItem))
            {
              ahbr.a(this.mAppInterface, this.mContext, (FileManagerEntity)localObject1, true, paramActionSheetItem, m);
              i = j;
            }
          }
          else if (k == 52)
          {
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
            i = j;
            if (aqhq.fileExistsAndNotEmpty(paramActionSheetItem))
            {
              OCRPerformFragment.b(this.mContext, paramActionSheetItem, 1, -1002, null);
              i = j;
            }
          }
          else if (k == 132)
          {
            QbSdk.clearDefaultBrowser(this.mContext, getFilePath());
            ahav.F(this.mContext, getFilePath());
            i = j;
          }
          else
          {
            i = 0;
            super.a(paramActionSheetItem);
          }
        }
      }
    }
  }
  
  public boolean a(aguk.b paramb)
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
    agrn.a(this.mAppInterface, localFileManagerEntity.TroopUin, new agvc(this, paramb, localTroopInfo, localTroopManager));
    return true;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList1 = null;
    int i = bG();
    if ((i != 5) && (i != 4)) {
      localObject1 = super.a();
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject2 = this.jdField_c_of_type_Agsd.b();
          localObject1 = localArrayList1;
        } while (localObject2 == null);
        localObject1 = localArrayList1;
      } while (((FileManagerEntity)localObject2).isZipInnerFile);
      localObject1 = localArrayList1;
    } while (((FileManagerEntity)localObject2).status == 16);
    Object localObject1 = a((FileManagerEntity)localObject2);
    localArrayList1 = b((FileManagerEntity)localObject2);
    Object localObject2 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {
      ((ArrayList)localObject2).addAll((Collection)localObject1);
    }
    if ((localArrayList1 != null) && (!localArrayList1.isEmpty())) {
      localArrayList2.addAll(localArrayList1);
    }
    return new ArrayList[] { localObject2, localArrayList2 };
  }
  
  public String aA()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    StringBuilder localStringBuilder = new StringBuilder(ahbj.g(getFileSize()));
    if ((104 == localFileManagerEntity.busId) && (localFileManagerEntity.lastTime > 0L))
    {
      localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131693588));
      localStringBuilder.append(apsv.i(BaseApplicationImpl.getContext(), localFileManagerEntity.lastTime));
    }
    return localStringBuilder.toString();
  }
  
  public boolean amt()
  {
    return true;
  }
  
  public String ax()
  {
    return "biz_src_jc_file";
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
        localObject = ahav.el(((FileManagerEntity)localObject).nFileType);
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
  
  public aebf b()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    apcy localapcy = apsv.a(this.mAppInterface, localFileManagerEntity);
    if (localapcy == null)
    {
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file info is null.");
      return new agsm();
    }
    long l = localFileManagerEntity.TroopUin;
    if ((localapcy.Status == 3) || (localapcy.Status == 2) || (localapcy.Status == 1))
    {
      if ((TextUtils.isEmpty(localapcy.FilePath)) && (aqhq.fileExistsAndNotEmpty(localapcy.LocalFile)))
      {
        QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload.");
        return new agso(localapcy.LocalFile);
      }
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload, but local file is not exist.");
      return new agsm();
    }
    return new agsr(l, localapcy);
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    String str = getFilePath();
    boolean bool = ahbj.fileExistsAndNotEmpty(str);
    localArrayList1.add(ahbr.a(2, agqm.d(this.e, localFileManagerEntity)));
    localArrayList1.add(ahbr.a(26, new agva(this, localFileManagerEntity)));
    if (!bool) {
      localArrayList1.add(ahbr.a(27, agqm.e(this.e, localFileManagerEntity)));
    }
    for (;;)
    {
      WXShareHelper localWXShareHelper = WXShareHelper.a();
      if ((bool) && (localWXShareHelper.isWXinstalled()) && (localWXShareHelper.aGT())) {
        localArrayList1.add(ahbr.a(9, agqm.b(this.mContext, str)));
      }
      if (bool) {
        localArrayList1.add(ahbr.a(64, new agvb(this)));
      }
      if (bool) {
        localArrayList2.add(ahbr.a(39, null));
      }
      if (ahav.q(this.jdField_c_of_type_Agsd.b())) {
        localArrayList1.add(ahbr.a(6, agqm.b(this.e, localFileManagerEntity)));
      }
      if (agyj.c(localFileManagerEntity, bool))
      {
        localArrayList2.add(ahbr.a(122, agqm.a(this.mContext, localFileManagerEntity, str)));
        localArrayList2.add(ahbr.a(123, agqm.b(this.mContext, localFileManagerEntity, str)));
      }
      kM(localArrayList2);
      if ((bool) && (QbSdk.isInDefaultBrowser(this.mContext, str))) {
        localArrayList2.add(ahbr.a(132, null));
      }
      return new ArrayList[] { localArrayList1, localArrayList2 };
      localArrayList1.add(ahbr.a(27, agqm.a(this.e, str)));
    }
  }
  
  public int bE()
  {
    int j = 7;
    int m = getFileType();
    int k = super.bE();
    if ((this.cYK == 3) && (m == 2)) {
      return 8;
    }
    if (k != 0) {
      return k;
    }
    int i = j;
    switch (m)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      return i;
      i = 6;
      continue;
      i = j;
      if (ahav.b(this.mAppInterface, this.jdField_c_of_type_Agsd, false))
      {
        i = j;
        if (ahav.b(this.mContext, getFileName(), getFileSize()))
        {
          i = 5;
          continue;
          i = 8;
          continue;
          if (!aqhq.fileExistsAndNotEmpty(getFilePath())) {
            i = 11;
          } else {
            i = k;
          }
        }
      }
    }
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
      QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel getFileStatus : troopFileStatus[" + k + "] can not change troop file status to FMConstants status");
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
  
  public int bM()
  {
    int i = getFileType();
    if ((i != 0) && (i != 2) && (i != 13)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {}
      Object localObject;
      do
      {
        do
        {
          return 0;
          localObject = this.jdField_c_of_type_Agsd.b();
          localObject = apsv.a(this.mAppInterface, (FileManagerEntity)localObject);
        } while (localObject == null);
        if (((((apcy)localObject).Status == 3) || (((apcy)localObject).Status == 2) || (((apcy)localObject).Status == 1)) && (TextUtils.isEmpty(((apcy)localObject).FilePath)))
        {
          QLog.i("TroopFileModel<FileAssistant>", 1, "getColorLabelShowType: troop file is upload, can not add color note.");
          return 0;
        }
      } while ((TextUtils.isEmpty(((apcy)localObject).FilePath)) && (!aqhq.fileExistsAndNotEmpty(getFilePath())));
      if ((this.e != null) && (this.e.bZ())) {
        return 2;
      }
      return 1;
    }
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
  
  public Intent f()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    if (localFileManagerEntity == null) {
      return null;
    }
    return ahbr.a(this.mAppInterface, localFileManagerEntity);
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
    smq.a(this.mAppInterface, this.jdField_c_of_type_Agsd.b().TroopUin, this.jdField_c_of_type_Agsd.b().strTroopFilePath, this.jdField_c_of_type_Agsd.b().busId, new aguv(this));
    smq.a(this.mAppInterface, this.jdField_c_of_type_Agsd.b().TroopUin, this.jdField_c_of_type_Agsd.b().busId, this.jdField_c_of_type_Agsd.b().strTroopFilePath, new agvf(this));
  }
  
  protected void ix()
  {
    if (this.jdField_a_of_type_Accd != null) {}
    do
    {
      return;
      this.jdField_a_of_type_Accd = new agvh(this);
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "add troopObserver");
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      localQQAppInterface.addObserver(this.jdField_a_of_type_Accd);
      if (this.jdField_c_of_type_Apsd$c == null)
      {
        FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
        if (localFileManagerEntity != null)
        {
          this.jdField_c_of_type_Apsd$c = new apsd.c(this.mContext, localFileManagerEntity.TroopUin, this.mAppInterface);
          apsd.a(localQQAppInterface, this.jdField_c_of_type_Apsd$c);
        }
      }
    } while ((!aqhq.fileExistsAndNotEmpty(getFilePath())) || (this.aab != 0L) || (getFileType() == 0));
    a(this.jdField_c_of_type_Agsd, 4);
  }
  
  protected void removeObserver()
  {
    if (this.jdField_a_of_type_Accd != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del troopObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_Accd);
    }
    if (this.jdField_c_of_type_Apsd$c != null) {
      apsd.b(this.mAppInterface, this.jdField_c_of_type_Apsd$c);
    }
    this.jdField_a_of_type_Accd = null;
    this.jdField_c_of_type_Apsd$c = null;
    this.jdField_a_of_type_Smq$m = null;
  }
  
  public List<aguk.a> u()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.BG != null)
    {
      Iterator localIterator = this.BG.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new agsz((agsd)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  public String vM()
  {
    Object localObject = this.jdField_c_of_type_Agsd.b();
    localObject = apsv.a(this.mAppInterface, (FileManagerEntity)localObject);
    if (localObject != null) {
      return ((apcy)localObject).mExcitingSpeed;
    }
    return null;
  }
  
  public String vN()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.yybApkPackageName;
    }
    return "";
  }
  
  public String vO()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.yybApkName;
    }
    return "";
  }
  
  public String vP()
  {
    if (getFileType() == 5)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
      if (localFileManagerEntity != null) {
        return localFileManagerEntity.yybApkIconUrl;
      }
    }
    return "";
  }
  
  public String ve()
  {
    if (bE() == 2)
    {
      Object localObject = this.jdField_c_of_type_Agsd.b();
      localObject = apsv.a(this.mAppInterface, (FileManagerEntity)localObject);
      if (TextUtils.isEmpty(this.bJk))
      {
        this.bJk = (((apcy)localObject).FilePath + "_" + System.currentTimeMillis());
        QLog.i("TroopFileModel<FileAssistant>", 1, "getContextId: troop video file random contextId: " + this.bJk);
      }
      return this.bJk;
    }
    return super.ve();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aguu
 * JD-Core Version:    0.7.0.1
 */