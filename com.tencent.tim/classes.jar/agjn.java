import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.bubble.OfflineFileBubbleModel.1;
import com.tencent.mobileqq.filemanager.bubble.OfflineFileBubbleModel.3;
import com.tencent.mobileqq.filemanager.bubble.OfflineFileBubbleModel.4;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class agjn
  extends agjs
{
  private boolean bdH = true;
  private boolean bdI;
  private MessageForFile c;
  private FileManagerEntity f;
  
  public agjn(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, ArrayList<Integer> paramArrayList)
  {
    if (16 == paramFileManagerEntity.status) {}
    while ((paramFileManagerEntity.getCloudType() == 0) || (j(paramFileManagerEntity)) || (wja.eU(5) != 1)) {
      return;
    }
    paramArrayList.add(Integer.valueOf(17));
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, ArrayList<Integer> paramArrayList)
  {
    if (16 == paramFileManagerEntity.status) {}
    while ((paramFileManagerEntity.getCloudType() == 0) || (j(paramFileManagerEntity)) || (paramFileManagerEntity.sendCloudUnsuccessful())) {
      return;
    }
    paramArrayList.add(Integer.valueOf(9));
  }
  
  private void c(FileManagerEntity paramFileManagerEntity, ArrayList<Integer> paramArrayList)
  {
    int i = 1;
    if (16 == paramFileManagerEntity.status) {}
    for (;;)
    {
      return;
      if (this.bdH)
      {
        this.bdI = aetq.a().ahT();
        this.bdH = false;
      }
      Object localObject = aeuc.a().ud();
      long l = ahav.d(this.mApp, paramFileManagerEntity.fileName);
      if ((this.bdI) && (aobw.v(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileName, (String)localObject)))
      {
        if (paramFileManagerEntity.status != 16) {}
        while ((i != 0) && (paramFileManagerEntity.fileSize <= l))
        {
          paramArrayList.add(Integer.valueOf(21));
          anot.a(this.mApp, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
          return;
          if (!TextUtils.isEmpty(paramFileManagerEntity.getFilePath()))
          {
            localObject = new VFSFile(paramFileManagerEntity.getFilePath());
            if ((localObject != null) && (((VFSFile)localObject).exists())) {}
          }
          else
          {
            i = 0;
          }
        }
      }
    }
  }
  
  private void d(FileManagerEntity paramFileManagerEntity, ArrayList<Integer> paramArrayList)
  {
    if ((16 != paramFileManagerEntity.status) && (paramFileManagerEntity.getCloudType() != 0) && (!j(paramFileManagerEntity))) {
      paramArrayList.add(Integer.valueOf(23));
    }
  }
  
  private void dgZ()
  {
    if ((this.c.isMultiMsg) && (!ahav.a(this.c, this.mApp, this.mContext))) {}
    Object localObject2;
    do
    {
      return;
      localObject2 = ahav.a(this.mApp, this.c);
      if (ahbr.v((FileManagerEntity)localObject2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OfflineFileBubbleModel", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
    return;
    Object localObject1 = new ahau.a();
    ((ahau.a)localObject1).bJE = "file_viewer_in";
    ((ahau.a)localObject1).cYX = 9;
    ((ahau.a)localObject1).bJF = ahbj.getExtension(((FileManagerEntity)localObject2).fileName);
    ((ahau.a)localObject1).bJH = ahav.H(((FileManagerEntity)localObject2).getCloudType(), ((FileManagerEntity)localObject2).peerType);
    ahau.a(this.mApp.getCurrentAccountUin(), (ahau.a)localObject1);
    ahau.JH("0X8004AE3");
    if (avlx.a().E((FileManagerEntity)localObject2))
    {
      avlx.a().L(this.mContext, ((FileManagerEntity)localObject2).getFilePath(), true);
      return;
    }
    if ((((FileManagerEntity)localObject2).TroopUin != 0L) && (!TextUtils.isEmpty(((FileManagerEntity)localObject2).strTroopFileID)) && (!TextUtils.isEmpty(((FileManagerEntity)localObject2).strTroopFilePath)))
    {
      localObject1 = new ForwardFileInfo();
      ((ForwardFileInfo)localObject1).p(((FileManagerEntity)localObject2).nSessionId);
      ((ForwardFileInfo)localObject1).Oj(4);
      ((ForwardFileInfo)localObject1).setType(10006);
      ((ForwardFileInfo)localObject1).setLocalPath(((FileManagerEntity)localObject2).getFilePath());
      ((ForwardFileInfo)localObject1).setFileName(((FileManagerEntity)localObject2).fileName);
      ((ForwardFileInfo)localObject1).setFileSize(((FileManagerEntity)localObject2).fileSize);
      ((ForwardFileInfo)localObject1).jA(((FileManagerEntity)localObject2).TroopUin);
      localObject2 = (Activity)this.mContext;
      Intent localIntent = new Intent((Context)localObject2, TroopFileDetailBrowserActivity.class);
      localIntent.putExtra("fileinfo", (Parcelable)localObject1);
      localIntent.putExtra("removemementity", true);
      localIntent.putExtra("forward_from_troop_file", true);
      localIntent.putExtra("not_forward", true);
      ((Activity)localObject2).startActivityForResult(localIntent, 102);
      return;
    }
    int i = 0;
    if (((FileManagerEntity)localObject2).peerType == 0) {
      i = 1;
    }
    for (;;)
    {
      localObject1 = new agvl(this.mApp, this.mContext, (FileManagerEntity)localObject2, 10004);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("file_browser_extra_params_uin", this.h.aTl);
      ((agvl)localObject1).cB((Bundle)localObject2);
      localObject1 = new agvn(this.mContext, (agvq)localObject1);
      ((agvn)localObject1).Oy(i);
      ((agvn)localObject1).djN();
      return;
      if (((FileManagerEntity)localObject2).peerType == 3000) {
        i = 5;
      }
    }
  }
  
  private void dhb()
  {
    FileManagerEntity localFileManagerEntity = ahav.a(this.mApp, this.c);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "fetchVideoFileThumb. can not find a FileManagerEntity");
      return;
    }
    if ((ahbj.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) && (ahav.p(localFileManagerEntity)))
    {
      ThreadManager.executeOnSubThread(new OfflineFileBubbleModel.3(this, localFileManagerEntity));
      return;
    }
    if (this.f.peerType == 3000)
    {
      this.mApp.a().b(localFileManagerEntity);
      return;
    }
    this.mApp.a().a(localFileManagerEntity);
  }
  
  private void dhc()
  {
    FileManagerEntity localFileManagerEntity = ahav.a(this.mApp, this.c);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "fetchImageFileThumb. can not find a FileManagerEntity");
      return;
    }
    if (ahbj.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath()))
    {
      ThreadManager.executeOnSubThread(new OfflineFileBubbleModel.4(this, localFileManagerEntity));
      return;
    }
    if (ahbh.u(localFileManagerEntity))
    {
      this.mApp.a().a(localFileManagerEntity, 7);
      return;
    }
    this.mApp.a().a(localFileManagerEntity, 5);
  }
  
  private List<Integer> eR()
  {
    FileManagerEntity localFileManagerEntity = ahav.a(this.mApp, this.c);
    ArrayList localArrayList = new ArrayList();
    if (localFileManagerEntity == null) {
      return localArrayList;
    }
    a(localFileManagerEntity, localArrayList);
    b(localFileManagerEntity, localArrayList);
    c(localFileManagerEntity, localArrayList);
    localArrayList.add(Integer.valueOf(10));
    if (QLog.isColorLevel()) {
      QLog.i("msgrevoke", 2, "FileMenuitem entity.status:" + localFileManagerEntity.status);
    }
    if ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1) || ((localFileManagerEntity.status == 3) && (localFileManagerEntity.nOpType == 1))) {
      localArrayList.add(Integer.valueOf(14));
    }
    if ((localFileManagerEntity.getCloudType() != 0) && (!j(localFileManagerEntity)) && (!localFileManagerEntity.sendCloudUnsuccessful())) {
      localArrayList.add(Integer.valueOf(19));
    }
    if ((localFileManagerEntity.getCloudType() != 1) || (localFileManagerEntity.status != 2)) {
      localArrayList.add(Integer.valueOf(15));
    }
    localArrayList.add(Integer.valueOf(16));
    if (16 != localFileManagerEntity.status) {
      localArrayList.add(Integer.valueOf(11));
    }
    localArrayList.add(Integer.valueOf(18));
    if ((localFileManagerEntity.getCloudType() != 0) && (!j(localFileManagerEntity)) && (!localFileManagerEntity.sendCloudUnsuccessful())) {
      localArrayList.add(Integer.valueOf(20));
    }
    d(localFileManagerEntity, localArrayList);
    return localArrayList;
  }
  
  private List<Integer> eS()
  {
    FileManagerEntity localFileManagerEntity = ahav.a(this.mApp, this.c);
    ArrayList localArrayList = new ArrayList();
    if ((this.c.isSendFromLocal()) && (localFileManagerEntity.status == 2)) {
      localArrayList.add(Integer.valueOf(6));
    }
    for (;;)
    {
      localArrayList.add(Integer.valueOf(18));
      if ((!localFileManagerEntity.sendCloudUnsuccessful()) && (augo.g(this.mApp, this.c))) {
        localArrayList.add(Integer.valueOf(25));
      }
      return localArrayList;
      if (!ahbh.t(localFileManagerEntity))
      {
        localArrayList.add(Integer.valueOf(10));
        if ((localFileManagerEntity.getCloudType() != 0) && (!j(localFileManagerEntity)))
        {
          if (!localFileManagerEntity.sendCloudUnsuccessful()) {
            localArrayList.add(Integer.valueOf(9));
          }
          localArrayList.add(Integer.valueOf(17));
        }
        localArrayList.add(Integer.valueOf(11));
      }
      if ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1) || ((localFileManagerEntity.status == 3) && (localFileManagerEntity.nOpType == 1))) {
        localArrayList.add(Integer.valueOf(14));
      }
      localArrayList.add(Integer.valueOf(16));
      if ((localFileManagerEntity.getCloudType() != 1) || (localFileManagerEntity.status != 2)) {
        localArrayList.add(Integer.valueOf(15));
      }
    }
  }
  
  private List<Integer> eT()
  {
    FileManagerEntity localFileManagerEntity = ahav.a(this.mApp, this.c);
    ArrayList localArrayList = new ArrayList();
    if (localFileManagerEntity.status != 16) {
      localArrayList.add(Integer.valueOf(12));
    }
    if ((this.c.isSendFromLocal()) && (localFileManagerEntity.status == 2)) {
      localArrayList.add(Integer.valueOf(6));
    }
    for (;;)
    {
      localArrayList.add(Integer.valueOf(18));
      if ((!localFileManagerEntity.sendCloudUnsuccessful()) && (augo.g(this.mApp, this.c))) {
        localArrayList.add(Integer.valueOf(25));
      }
      return localArrayList;
      if (localFileManagerEntity.status != 16)
      {
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          localArrayList.add(Integer.valueOf(9));
        }
        localArrayList.add(Integer.valueOf(10));
        if (ahav.q(localFileManagerEntity)) {
          localArrayList.add(Integer.valueOf(17));
        }
        if ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1) || ((localFileManagerEntity.status == 3) && ((localFileManagerEntity.nOpType == 1) || (localFileManagerEntity.nOpType == 8)))) {
          localArrayList.add(Integer.valueOf(14));
        }
      }
      localArrayList.add(Integer.valueOf(16));
      if (localFileManagerEntity.status != 16) {
        localArrayList.add(Integer.valueOf(11));
      }
      if ((localFileManagerEntity.getCloudType() != 1) || (localFileManagerEntity.status != 2)) {
        localArrayList.add(Integer.valueOf(15));
      }
    }
  }
  
  private void gH(View paramView)
  {
    int i = 1;
    if ((this.c.isMultiMsg) && (!ahav.a(this.c, this.mApp, this.mContext))) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
        localFileManagerEntity = ahav.a(this.mApp, this.c);
        if (localFileManagerEntity == null)
        {
          QLog.e("OfflineFileBubbleModel", 1, "get Entity by Msg faild!");
          return;
        }
      } while (localFileManagerEntity.status == 16);
      if (ahbr.v(localFileManagerEntity)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OfflineFileBubbleModel", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
    return;
    if ((localFileManagerEntity.sendCloudUnsuccessful()) && (!ahbj.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())))
    {
      ahao.JD(acfp.m(2131706299));
      return;
    }
    ahau.a locala = new ahau.a();
    locala.bJE = "file_viewer_in";
    locala.cYX = 9;
    locala.bJF = ahbj.getExtension(localFileManagerEntity.fileName);
    locala.bJH = ahav.H(localFileManagerEntity.getCloudType(), localFileManagerEntity.peerType);
    ahau.a(this.mApp.getCurrentAccountUin(), locala);
    ahau.JH("0X8004AE3");
    QLog.i("OfflineFileBubbleModel", 1, "handle item click: file peerType[" + localFileManagerEntity.peerType + "]");
    if (localFileManagerEntity.peerType == 0) {}
    for (;;)
    {
      paramView = sxx.getViewRect(paramView);
      ahbr.a(this.mApp, this.mContext, this.h, this.c, paramView, i, 10004, localFileManagerEntity, false, false);
      return;
      if (localFileManagerEntity.peerType == 3000) {
        i = 5;
      }
    }
  }
  
  private void gI(View paramView)
  {
    if ((this.c.isMultiMsg) && (!ahav.a(this.c, this.mApp, this.mContext))) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return;
      localFileManagerEntity = ahav.a(this.mApp, this.c);
    } while ((localFileManagerEntity.status == 16) && (!ahav.s(localFileManagerEntity)));
    paramView = sxx.getViewRect(paramView);
    ahbr.a(this.mContext, paramView, this.c, this.h, false, false);
  }
  
  private boolean j(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFileManagerEntity != null) {
      if (paramFileManagerEntity.nOpType != 24)
      {
        bool1 = bool2;
        if (paramFileManagerEntity.nOpType != 25) {}
      }
      else if (paramFileManagerEntity.status != 2)
      {
        bool1 = bool2;
        if (paramFileManagerEntity.status != 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void n(FileManagerEntity paramFileManagerEntity)
  {
    anot.a(this.mApp, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
    if (agzy.a(this.c).bd(false))
    {
      if (armm.a((Activity)this.mContext, 5, new agjp(this))) {
        ahal.a(this.mContext, 2131693826, 2131693830, new agjq(this));
      }
      return;
    }
    ahav.a(this.mApp, this.c, this.mContext);
  }
  
  private void o(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = ahav.a(this.mApp, this.c);
    anot.a(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
    int i = 0;
    if (paramFileManagerEntity.peerType == 0) {
      i = 1;
    }
    for (;;)
    {
      ahbr.a(this.mApp, this.mContext, this.h, this.c, null, i, 10004, paramFileManagerEntity, true, false);
      return;
      if (paramFileManagerEntity.peerType == 3000) {
        i = 5;
      } else {
        QLog.w("OfflineFileBubbleModel", 1, "entranceType is unknow ,peerType:" + paramFileManagerEntity.peerType);
      }
    }
  }
  
  private void p(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject = new ahau.a();
    ((ahau.a)localObject).bJE = "file_forward";
    ((ahau.a)localObject).cYX = 9;
    ((ahau.a)localObject).nFileSize = paramFileManagerEntity.fileSize;
    ((ahau.a)localObject).bJF = ahbj.getExtension(paramFileManagerEntity.fileName);
    ((ahau.a)localObject).bJH = ahav.H(paramFileManagerEntity.getCloudType(), paramFileManagerEntity.peerType);
    ahau.a(this.mApp.getCurrentAccountUin(), (ahau.a)localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("forward_type", 0);
    ((Bundle)localObject).putBoolean("not_forward", true);
    ((Bundle)localObject).putParcelable("fileinfo", ahhq.a(paramFileManagerEntity, this.c));
    ((Bundle)localObject).putInt("forward_source_uin_type", this.h.cZ);
    Intent localIntent = new Intent();
    localIntent.putExtras((Bundle)localObject);
    localIntent.putExtra("forward_text", acfp.m(2131706233) + ahav.kY(paramFileManagerEntity.fileName) + acfp.m(2131706234) + ahbj.g(paramFileManagerEntity.fileSize) + "。");
    localIntent.putExtra("direct_send_if_dataline_forward", true);
    localIntent.putExtra("forward _key_nojump", true);
    localIntent.putExtra("forward_source_uin_type", this.h.cZ);
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {
      QQToast.a(this.mContext, 2131696348, 1).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
    }
    for (;;)
    {
      anot.a(this.mApp, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "6", "", "", "");
      if (this.c.isMultiMsg) {
        anot.a(this.mApp, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
      }
      return;
      ahgq.f((Activity)this.mContext, localIntent, 21);
    }
  }
  
  private void q(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      paramFileManagerEntity = ansj.a(ansj.nJ(paramFileManagerEntity.getFilePath()));
      if (paramFileManagerEntity != null)
      {
        SessionInfo localSessionInfo = new SessionInfo();
        localSessionInfo.aTl = this.c.frienduin;
        localSessionInfo.cZ = this.c.istroop;
        ujt.a(this.mApp, localSessionInfo, paramFileManagerEntity);
      }
      return;
    }
    catch (Exception paramFileManagerEntity)
    {
      QQToast.a(this.mContext, acfp.m(2131706231), 1).show();
    }
  }
  
  private void r(FileManagerEntity paramFileManagerEntity) {}
  
  public int Eh()
  {
    if (this.f == null) {
      return 0;
    }
    return ahbh.a(this.f).width;
  }
  
  public int Ei()
  {
    if (this.f == null) {
      return 0;
    }
    return ahbh.a(this.f).height;
  }
  
  public int Ej()
  {
    if (this.f == null) {
      return -1;
    }
    boolean bool = this.c.isSend();
    if (this.c.isMultiMsg) {
      bool = ahav.c(this.mApp, this.c);
    }
    switch (this.f.status)
    {
    default: 
    case 1: 
    case 2: 
    case 14: 
    case 15: 
      do
      {
        do
        {
          do
          {
            return 0;
            if (!bool) {
              break;
            }
          } while (!aqhq.fileExistsAndNotEmpty(this.f.getFilePath()));
          return 2;
        } while (!aqhq.fileExistsAndNotEmpty(this.f.getFilePath()));
        return 5;
        if (bool) {
          return 1;
        }
        return 4;
      } while (9 != this.f.nOpType);
      return 1;
    }
    if (bool)
    {
      if (this.f.bOnceSuccess) {
        return 6;
      }
      return 3;
    }
    return 6;
  }
  
  public int Ek()
  {
    if (this.f == null) {
      return 0;
    }
    return (int)(this.f.fProgress * 100.0F);
  }
  
  public int El()
  {
    int j = 1;
    int i;
    if (this.f == null) {
      i = 0;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (ahbr.b(this.f.imgWidth, this.f.imgHeight, this.f.fileSize));
      i = j;
    } while (this.f.thumbInvalidCode == 1);
    if (this.f.thumbInvalidCode == 2) {
      return 2;
    }
    return super.El();
  }
  
  public void NU(int paramInt)
  {
    if ((this.c == null) || (this.f == null)) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        do
        {
          return;
          localFileManagerEntity = ahav.a(this.mApp, this.c);
          switch (paramInt)
          {
          default: 
            return;
          case 2131364851: 
            ApolloUtil.De(localFileManagerEntity.getFilePath());
            return;
          case 2131372030: 
            long l1 = anaz.gQ();
            long l2 = this.c.time;
            if ((this.c.msgtype == -2005) && (this.c.istroop == 3000) && (l1 - l2 > 604800L))
            {
              ahao.JD(acfp.m(2131706235));
              anot.a(this.mApp, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "6", "", "", "");
              return;
            }
            ahau.JH("0X8005E4B");
            return;
          case 2131365686: 
            ujt.b(this.mContext, this.mApp, this.c);
            this.mApp.a().k(localFileManagerEntity);
          }
        } while (ahav.getFileType(this.f.fileName) != 0);
        anot.a(this.mApp, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
        return;
        n(localFileManagerEntity);
        return;
        p(localFileManagerEntity);
        return;
        anot.a(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          QQToast.a(this.mContext, 2131696348, 1).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
          return;
        }
        ahav.a(this.mApp, this.c, this.mContext);
        return;
        new aviz(3).a(this.mApp, (Activity)this.mContext, localFileManagerEntity, this.c, false);
      } while (!this.c.isMultiMsg);
      anot.a(this.mApp, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
      return;
      aoag.a(localFileManagerEntity, this.mContext, this.mApp, 1);
      anot.a(this.mApp, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    } while (!this.c.isMultiMsg);
    anot.a(this.mApp, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
    return;
    o(localFileManagerEntity);
    return;
    q(localFileManagerEntity);
    return;
    r(localFileManagerEntity);
    return;
    ((augo)this.mApp.getManager(374)).B(this.c);
  }
  
  protected void R(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForFile)) {
      QLog.e("OfflineFileBubbleModel", 1, "setBubbleModelData. is not a MessageForFile");
    }
    do
    {
      return;
      this.c = ((MessageForFile)paramChatMessage);
      this.f = ahav.a(this.mApp, this.c);
    } while (this.f != null);
    QLog.e("OfflineFileBubbleModel", 1, "setBubbleModelData. can not find a FileManagerEntity");
  }
  
  public aghj a()
  {
    return new aghf(this.mApp, this.mContext);
  }
  
  public aghl a()
  {
    return new aghh(this.mApp, this.mContext);
  }
  
  public List<Integer> ab(int paramInt)
  {
    if (this.c == null) {
      return new ArrayList();
    }
    if (paramInt == 1) {
      return eR();
    }
    if (paramInt == 2) {
      return eS();
    }
    if (paramInt == 3) {
      return eT();
    }
    return new ArrayList();
  }
  
  public List<Integer> ac(int paramInt)
  {
    Object localObject;
    if (this.c == null) {
      localObject = new ArrayList();
    }
    ArrayList localArrayList;
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        return localObject;
        localFileManagerEntity = ahav.a(this.mApp, this.c);
        localArrayList = new ArrayList();
        localObject = localArrayList;
      } while (16 == localFileManagerEntity.status);
      if ((localFileManagerEntity.getCloudType() != 0) && (!j(localFileManagerEntity))) {
        localArrayList.add(Integer.valueOf(9));
      }
      localObject = localArrayList;
    } while (wja.eU(5) != 1);
    localArrayList.add(Integer.valueOf(17));
    return localArrayList;
  }
  
  public boolean alo()
  {
    if (this.c == null) {
      return false;
    }
    return this.c.isSend();
  }
  
  public boolean alp()
  {
    boolean bool = true;
    if (this.f == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              if (ahav.getFileType(this.f.fileName) != 2) {
                break;
              }
            } while ((!this.f.isSend()) || (this.f.status != 0));
            return true;
            switch (this.f.status)
            {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 9: 
            case 12: 
            case 13: 
            case 15: 
            default: 
              return false;
            }
          } while ((this.f.status != 0) || (this.f.isSend() != true) || (this.f.bOnceSuccess));
          return true;
        } while (13 != this.f.nOpType);
        return false;
        if (10 == this.f.nOpType) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      } while (13 != this.f.nOpType);
      return false;
    } while ((!this.f.isSend()) || (this.f.bOnceSuccess));
    return true;
  }
  
  public int bF()
  {
    if (this.f == null) {
      return 0;
    }
    long l1 = 604800L;
    if (this.f.peerType == 3000) {
      l1 = 1296000L;
    }
    long l2 = this.f.srvTime;
    l2 = (anaz.gQ() * 1000L - l2) / 1000L;
    if ((l2 > 0L) && (l2 > l1)) {}
    for (int j = 1;; j = 0)
    {
      int i;
      switch (this.f.status)
      {
      case 1: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 13: 
      default: 
        i = 0;
        label162:
        if (j != 0) {
          i = 6;
        }
        break;
      }
      for (;;)
      {
        return i;
        if (j != 0)
        {
          i = 6;
          break label162;
        }
        i = 1;
        break label162;
        i = 1;
        break label162;
        i = 3;
        break label162;
        if (9 != this.f.nOpType) {
          break;
        }
        i = 3;
        break label162;
        i = 2;
        break label162;
        i = 4;
        break label162;
      }
    }
  }
  
  public void dgX()
  {
    if (this.cdE)
    {
      dhe();
      if (QLog.isColorLevel()) {
        QLog.i("OfflineFileBubbleModel", 1, "fetchFileThumb.");
      }
      if ((this.c != null) && (this.f != null)) {
        break label41;
      }
    }
    label41:
    int i;
    do
    {
      return;
      i = ahav.getFileType(this.f.fileName);
      if (i == 2)
      {
        dhb();
        return;
      }
    } while (i != 0);
    dhc();
  }
  
  public void dgY()
  {
    if ((this.c == null) || (this.f == null)) {
      return;
    }
    String str = this.f.fileName + this.f.nSessionId;
    if (!this.mApp.a().mA(str))
    {
      anot.a(null, "dc00898", "", "", "0X800A686", "0X800A686", 0, 0, "", "", "", "");
      this.mApp.a().IZ(str);
    }
    this.mApp.a().a().dgD();
  }
  
  public void dha()
  {
    if (this.f == null) {
      return;
    }
    String str1 = this.mContext.getString(2131693557);
    String str2 = this.mContext.getString(2131693556);
    ausj localausj = (ausj)auss.a(this.mContext, null);
    localausj.addButton(str1);
    localausj.addCancelButton(this.mContext.getString(2131721058));
    localausj.setMainTitle(str2);
    localausj.a(new agjo(this, localausj));
    localausj.show();
  }
  
  public long fE()
  {
    if (this.f == null) {}
    long l;
    do
    {
      do
      {
        do
        {
          return 0L;
        } while (this.f.getCloudType() == 0);
        if (this.f.status == 16) {
          return -1L;
        }
      } while (aqhq.fileExistsAndNotEmpty(this.f.getFilePath()));
      l = this.f.srvTime;
      l = (anaz.gQ() * 1000L - l) / 1000L;
    } while (l <= 0L);
    if (l > 604800L) {
      return -1L;
    }
    return 604800L - l;
  }
  
  public String getFileName()
  {
    if (this.f == null) {
      return "";
    }
    return this.f.fileName;
  }
  
  public long getFileSize()
  {
    if (this.f == null) {
      return 0L;
    }
    return this.f.fileSize;
  }
  
  public void ia(int paramInt1, int paramInt2)
  {
    if ((this.c != null) && (this.f == null)) {}
  }
  
  public void u(int paramInt, View paramView)
  {
    if (this.c == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = ahav.a(this.mApp, this.c);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "get Entity by Msg faild!");
      return;
    }
    int i = 11;
    switch (ahav.getFileType(localFileManagerEntity.fileName))
    {
    }
    for (;;)
    {
      anot.a(this.mApp, "dc00898", "", "", "0X800A68B", "0X800A68B", i, 0, "4", "", "", "");
      if (paramInt != 1) {
        break;
      }
      dgZ();
      return;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
      continue;
      i = 9;
      continue;
      i = 10;
    }
    if (paramInt == 2)
    {
      gI(paramView);
      return;
    }
    if (paramInt == 3)
    {
      gH(paramView);
      return;
    }
    dgZ();
  }
  
  public String uZ()
  {
    Object localObject;
    if (this.c == null) {
      localObject = "";
    }
    FileManagerEntity localFileManagerEntity;
    int i;
    do
    {
      String str;
      do
      {
        do
        {
          return localObject;
          localFileManagerEntity = ahav.a(this.mApp, this.c);
          if (localFileManagerEntity == null) {
            return "";
          }
          localObject = localFileManagerEntity.strMiddleThumPath;
          i = ahav.getFileType(localFileManagerEntity.fileName);
          if (i != 0) {
            break;
          }
          str = localFileManagerEntity.strMiddleThumPath;
          localObject = str;
        } while (ahbj.fileExistsAndNotEmpty(str));
        localObject = str;
      } while (!ahbj.fileExistsAndNotEmpty(localFileManagerEntity.strLargeThumPath));
      if (ahbh.u(localFileManagerEntity))
      {
        ThreadManagerV2.executeOnSubThread(new OfflineFileBubbleModel.1(this, localFileManagerEntity));
        return str;
      }
      return localFileManagerEntity.strLargeThumPath;
    } while (i != 2);
    return localFileManagerEntity.strLargeThumPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agjn
 * JD-Core Version:    0.7.0.1
 */