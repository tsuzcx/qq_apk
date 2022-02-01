import android.os.RemoteException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AccountNotMatchException;

public class akya
  extends akxc.a
{
  private static akya a;
  private String aTl;
  public long aeJ;
  private long afv;
  private long afw = 209715200L;
  private long afx = 157286400L;
  private long afy = 73400320L;
  private long afz = 52428800L;
  public String bUM;
  private int cZ;
  private boolean cvg;
  private boolean cvh;
  private boolean cvi;
  private boolean cvj;
  private boolean cvk;
  private boolean cvl;
  private boolean cvm;
  private boolean cvn;
  private boolean cvo;
  public int dpM;
  private int dpO;
  private int dpP = 90;
  private int dpQ = 70;
  private int dpR = 50;
  private String myUin;
  private int topicId;
  private String troopUin;
  private ArrayList<akxq> yx = new ArrayList();
  private ArrayList<akxq> yy = new ArrayList();
  
  public akya(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    this.cZ = paramInt1;
    this.aTl = paramString1;
    this.troopUin = paramString2;
    this.myUin = paramString3;
    this.topicId = paramInt2;
    long l1 = akxo.i("presend_lastDayTime", 0L);
    long l2 = System.currentTimeMillis();
    akxe.a("PresendPicMgrService", "[@]PresendPicMgrService", "currentTime = " + l2 + ", lastDayTime = " + l1 + ", curFriendUin = " + paramString1 + ",troopUin = " + paramString2 + ",myUin = " + paramString3);
    dEd();
    if (l2 - l1 > 86400000L)
    {
      akxe.a("PresendPicMgrService", "PresendPicMgrService", "more than one day, clear wastesize");
      zsz.gB(akxo.i("presend_FlowWaste", 0L));
      akxo.aw("presend_lastDayTime", l2);
      akxo.aw("presend_FlowWaste", 0L);
    }
    this.afv = akxo.i("presend_FlowWaste", 0L);
    a = this;
  }
  
  private int Hk()
  {
    int i = 0;
    int j = aqiw.getSystemNetwork(BaseApplication.getContext());
    switch (j)
    {
    }
    for (;;)
    {
      akxe.a("PresendPicMgrService", "getCancelPercent", " NetType = " + j + ", cancelpercent = " + i);
      return i;
      i = this.dpO;
      continue;
      i = this.dpP;
      continue;
      i = this.dpQ;
      continue;
      i = this.dpR;
    }
  }
  
  private akxq a(ArrayList<akxq> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      akxq localakxq = (akxq)paramArrayList.next();
      if (localakxq.localUUID.equals(paramString)) {
        return localakxq;
      }
    }
    return null;
  }
  
  private akxy a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = new akxy.a();
    akxe.a("PresendPicMgrService", "[@]buildPicUploadInfo", "curFriendUin = " + this.aTl);
    ((akxy.a)localObject).NP(this.aTl);
    ((akxy.a)localObject).setLocalPath(paramString);
    ((akxy.a)localObject).Sp(this.cZ);
    ((akxy.a)localObject).NT(this.troopUin);
    ((akxy.a)localObject).So(paramInt1);
    ((akxy.a)localObject).Sr(0);
    ((akxy.a)localObject).setEntrance(paramInt2);
    ((akxy.a)localObject).St(this.topicId);
    localObject = ((akxy.a)localObject).a();
    ((akxy)localObject).cuZ = true;
    if (avfp.is(paramString)) {
      aqip.beginPile();
    }
    try
    {
      ((akxy)localObject).yv = avfp.an(paramString);
      if ((((akxy)localObject).yv != null) && (QLog.isColorLevel())) {
        QLog.d("peak_pgjpeg", 2, "PresendPicMgrService.buildPicUploadInfo:" + ((akxy)localObject).yv.toString());
      }
      aqip.endPile("peak_pgjpeg", "PeakUtils.getSliceInfos(" + paramString + ")");
      if (paramBoolean)
      {
        ((akxy)localObject).protocolType = 1;
        akxe.a(localObject, "fixProtocolType", "sendReq.upInfo.protocolType");
        return localObject;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + paramString + "'s size is " + aqhq.getFileSizes(paramString));
        }
      }
      ((akxy)localObject).protocolType = ((akxy)localObject).getProtocolType();
    }
    return localObject;
  }
  
  public static akya a()
  {
    return a;
  }
  
  private void a(akxq paramakxq, int paramInt)
  {
    synchronized (paramakxq.b)
    {
      paramakxq.b.cva = true;
      if (paramakxq.b.picExtraObject == null)
      {
        akxe.b("PresendPicMgrService", "doCancel", " req.upInfo.picExtraObject == null!");
        return;
      }
    }
    ??? = (MessageRecord)paramakxq.b.picExtraObject;
    for (;;)
    {
      aojr localaojr;
      long l1;
      try
      {
        localaojr = (aojr)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin)).a().a(((MessageRecord)???).frienduin, ((MessageRecord)???).uniseq);
        if (localaojr != null) {
          break label243;
        }
        akxe.a("PresendPicMgrService", "doCancel", " processor == null!");
        l1 = ((MessageForPic)???).mPresendTransferedSize;
        long l2 = aqhq.getFileSizes(((MessageForPic)???).path);
        akxe.a("PresendPicMgrService", "doCancel", "picSize = " + l2);
        aN(l1, paramInt);
        akxe.a("PresendPicMgrService", "doCancel ", "PresendStatus: Path:" + paramakxq.b.localPath + ",uuid:" + paramakxq.b.localUUID + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
        return;
      }
      catch (AccountNotMatchException paramakxq) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PresendPicMgrService", 2, "no appRuntime");
      return;
      label243:
      int i = Hk();
      if (localaojr.KK() < i)
      {
        akxe.a("PresendPicMgrService", "doCancel", " processor upload less than cancelPercent:" + i + ", do cancel! ");
        localaojr.cancel();
        l1 = localaojr.fF();
      }
      else
      {
        akxe.a("PresendPicMgrService", "doCancel", " processor upload more than cancelPercent:" + i + ", do not cancel!");
        l1 = localaojr.getFileSize();
      }
    }
  }
  
  private void aN(long paramLong, int paramInt)
  {
    this.afv += paramLong;
    akxo.aw("presend_FlowWaste", this.afv);
    zsz.aj(paramLong, paramInt);
    akxe.a("PresendPicMgrService", "calcWasteFlow ", "PresendStatus:  wastesize = " + paramLong + ",mWastedUploadFlow = " + this.afv + ",cancelType = " + paramInt);
  }
  
  private void ar(MessageRecord paramMessageRecord)
  {
    ambj localambj = (ambj)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(326);
    localambj.aG(paramMessageRecord.frienduin, paramMessageRecord.uniseq);
    localambj.d(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  private boolean asU()
  {
    boolean bool = true;
    int i = aqiw.getSystemNetwork(BaseApplication.getContext());
    switch (i)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      akxe.a("PresendPicMgrService", "isOverWasteLimit", "PresendStatus : nettype = " + i + " result =  " + bool + ",mWastedUploadFlow = " + this.afv);
      return bool;
      if (this.afv <= this.afw) {
        break;
      }
      continue;
      if (this.afv <= this.afz) {
        break;
      }
      continue;
      if (this.afv <= this.afy) {
        break;
      }
      continue;
      if (this.afv <= this.afx) {
        break;
      }
    }
  }
  
  private void dEd()
  {
    Object localObject = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.pic_presend.name());
    if (DeviceProfileManager.a().isFeatureSupported(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()))
    {
      localObject = "1|1|1|1|1|1|1|1|104857600|104857600|104857600|104857600|0|90|70|50";
      akxe.a("PresendPicMgrService", "getServerConfig", "In VIP list, presendConfigString " + "1|1|1|1|1|1|1|1|104857600|104857600|104857600|104857600|0|90|70|50");
    }
    akxe.a("PresendPicMgrService", "getServerConfig", "presendConfigString = " + (String)localObject);
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length >= 16)
      {
        this.cvg = localObject[0].equals("1");
        this.cvh = localObject[1].equals("1");
        this.cvi = localObject[2].equals("1");
        this.cvj = localObject[3].equals("1");
        this.cvk = localObject[4].equals("1");
        this.cvl = localObject[5].equals("1");
        this.cvm = localObject[6].equals("1");
        this.cvn = localObject[7].equals("1");
      }
    }
    try
    {
      this.afw = Long.valueOf(localObject[8]).longValue();
      this.afz = Long.valueOf(localObject[9]).longValue();
      this.afy = Long.valueOf(localObject[10]).longValue();
      this.afx = Long.valueOf(localObject[11]).longValue();
      this.dpO = Integer.parseInt(localObject[12]);
      this.dpP = Integer.parseInt(localObject[13]);
      this.dpQ = Integer.parseInt(localObject[14]);
      this.dpR = Integer.parseInt(localObject[15]);
      akxe.a("PresendPicMgrService", "getServerConfig", "mEnablePreCompress_WIFI = " + this.cvg + "mEnablePreCompress_2G = " + this.cvh + "mEnablePreCompress_3G = " + this.cvi + "mEnablePreCompress_4G = " + this.cvj + "mEnablePreUpload_WIFI = " + this.cvk + ",mEnablePreUpload_2G = " + this.cvl + ",mEnablePreUpload_3G = " + this.cvm + ",mEnablePreUpload_4G = " + this.cvn + "mPreUpMaxWasteSizeWIFI = " + this.afw + ", mPreUpMaxWasteSize2G = " + this.afz + ",mPreUpMaxWasteSize3G = " + this.afy + ",mPreUpMaxWasteSize4G = " + this.afx + ",mCancelPercentWIFI = " + this.dpO + ",mCancelPercent2G = " + this.dpP + ",mCancelPercent3G = " + this.dpQ + ",mCancelPercent4G = " + this.dpR);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
      }
    }
  }
  
  private void v(MessageForPic paramMessageForPic)
  {
    akxe.a("PresendPicMgrService", "reuploadPhoto", " ");
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
      localQQAppInterface.b().t(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
      if (paramMessageForPic.isSendFromLocal()) {
        localQQAppInterface.a().oy(localQQAppInterface.a().y(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
      }
      akxy.a locala = new akxy.a();
      locala.setLocalPath(paramMessageForPic.path);
      locala.So(5);
      locala.NP(paramMessageForPic.frienduin);
      locala.kx(paramMessageForPic.uniseq);
      if (paramMessageForPic.fileSizeFlag == 1) {
        locala.setProtocolType(aooh.a.dQD);
      }
      for (;;)
      {
        locala.NT(paramMessageForPic.senderuin);
        locala.kc(paramMessageForPic.selfuin);
        locala.Sp(paramMessageForPic.istroop);
        locala.extLong = paramMessageForPic.extLong;
        locala.extStr = paramMessageForPic.extStr;
        akxy.b localb = new akxy.b();
        localb.msgseq = paramMessageForPic.msgseq;
        localb.shmsgseq = paramMessageForPic.shmsgseq;
        localb.msgseq = paramMessageForPic.msgseq;
        locala.a(localb);
        paramMessageForPic = akxj.a(4, 5);
        paramMessageForPic.c(locala.a());
        akxj.a(paramMessageForPic, localQQAppInterface);
        return;
        locala.setProtocolType(aooh.a.dQC);
      }
      return;
    }
    catch (AccountNotMatchException paramMessageForPic)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicMgrService", 2, "no appRuntime");
      }
    }
  }
  
  public void IP(int paramInt)
    throws RemoteException
  {
    akxe.a("PresendPicMgrService", "cancelAll", "cancelType = " + paramInt);
    resetStatus();
  }
  
  public int[] V()
  {
    try
    {
      int[] arrayOfInt = akxj.b((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin));
      return arrayOfInt;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicMgrService", 2, "getPicCompressArgConfig no appRuntime");
      }
    }
    return null;
  }
  
  public boolean[] a()
  {
    return new boolean[] { this.cvg, this.cvh, this.cvi, this.cvj };
  }
  
  boolean asT()
  {
    int i = aqiw.getSystemNetwork(BaseApplication.getContext());
    boolean bool = false;
    switch (i)
    {
    }
    for (;;)
    {
      akxe.a("PresendPicMgrService", "isPreuploadEnable", "nettype = " + i + " result =  " + bool);
      return bool;
      bool = this.cvk;
      continue;
      bool = this.cvl;
      continue;
      bool = this.cvm;
      continue;
      bool = this.cvn;
    }
  }
  
  public void b(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "presendPic in main process " + paramInt2);
    }
    akxe.a("PresendPicMgrService", "presendPic", "PresendStatus : path = " + paramString1 + ", localUUID = " + paramString2 + ",fileSize = " + aqhq.getFileSizes(paramString1) + ",entrance = " + paramInt2);
    akxq localakxq = akxj.a(2, 1052);
    paramString1 = a(paramString1, paramBoolean, paramInt1, paramInt2);
    localakxq.c(paramString1);
    localakxq.NS(paramString2);
    if (!paramString1.check())
    {
      akxe.N("PresendPicMgrService", paramString2, paramString1.b.bUI, paramString1.b.bUJ);
      paramString1.picExtraFlag = 4;
      this.yx.add(localakxq);
    }
    do
    {
      return;
      localakxq.b(new akyb(this, localakxq, paramString1));
      if ((!asT()) || (asU()) || (aqhq.getFileSizes(localakxq.b.localPath) > 512000L))
      {
        akxe.a("PresendPicMgrService", "presendPic", "set FLAG_NOT_UPLOAD!");
        localakxq.b(null);
        localakxq.b.picExtraFlag = 3;
      }
      try
      {
        akxj.a(localakxq, (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin));
        this.yx.add(localakxq);
        return;
      }
      catch (AccountNotMatchException paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.d("PresendPicMgrService", 2, "no appRuntime");
  }
  
  public void dDP()
    throws RemoteException
  {
    akxe.a("PresendPicMgrService", "sendMsg__ start!", " ");
    a = null;
    ArrayList localArrayList1 = new ArrayList();
    long l1 = 0L;
    Object localObject4;
    ArrayList localArrayList2;
    int i;
    Object localObject5;
    long l2;
    try
    {
      synchronized (this.yy)
      {
        this.cvo = true;
        localObject4 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin);
        localArrayList2 = new ArrayList(this.yx);
        ??? = new ArrayList(this.yy);
        i = 0;
        if (i >= localArrayList2.size()) {
          break label592;
        }
        localObject5 = (akxq)localArrayList2.get(i);
        if (((akxq)localObject5).b.picExtraFlag != 4) {
          break label204;
        }
        akxe.a("PresendPicMgrService", "sendMsg", "FLAG_UPLOADINFO_ERROR do not send! uuid = " + ((akxq)localObject5).localUUID);
        l2 = l1;
        i += 1;
        l1 = l2;
      }
      akxe.a("PresendPicMgrService", "sendMsg__ end!", " ");
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicMgrService", 2, "no appRuntime");
      }
    }
    for (;;)
    {
      for (;;)
      {
        dEe();
        return;
        label204:
        synchronized (((akxq)localObject5).b)
        {
          for (;;)
          {
            Object localObject7 = ((akxq)localObject5).b.picExtraObject;
            if (localObject7 == null) {}
            try
            {
              akxe.a("PresendPicMgrService", "sendMsg", "start wait! uuid = " + ((akxq)localObject5).localUUID);
              ((akxq)localObject5).b.cvb = true;
              ((akxq)localObject5).b.wait();
              akxe.a("PresendPicMgrService", "sendMsg", "finish wait! uuid = " + ((akxq)localObject5).localUUID);
              ((akxq)localObject5).b.cvc = true;
              if (((akxq)localObject5).b.picExtraObject == null)
              {
                akxe.b("PresendPicMgrService", "sendMsg", "get MR failed! uuid = " + ((akxq)localObject5).b.localUUID);
                l2 = l1;
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;)
              {
                localInterruptedException.printStackTrace();
              }
            }
          }
        }
      }
      ??? = (MessageRecord)((akxq)localObject5).b.picExtraObject;
      if (this.dpM == 1)
      {
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_album_id", this.bUM);
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(this.aeJ));
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(((akxq)localObject5).b.protocolType));
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_batch_count", String.valueOf(localArrayList2.size()));
        ((MessageRecord)???).saveExtInfoToExtStr("msg_extra_key_qzone_photo_index", String.valueOf(i));
      }
      ar((MessageRecord)???);
      if ((??? instanceof MessageForPic))
      {
        localObject2.add(((MessageForPic)???).path);
        l1 = ((MessageRecord)???).uniseq;
      }
      l2 = l1;
      if (((akxq)localObject5).b.picExtraFlag != 3) {
        break;
      }
      akxe.a("PresendPicMgrService", "sendMsg", "Pic not upload,reupload! mr = " + ???);
      v((MessageForPic)???);
      l2 = l1;
      break;
      for (;;)
      {
        label592:
        MessageRecord localMessageRecord;
        try
        {
          localObject5 = ((ArrayList)???).iterator();
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          ??? = (akxq)((Iterator)localObject5).next();
          i = ((akxq)???).b.picExtraFlag;
          localMessageRecord = (MessageRecord)((akxq)???).b.picExtraObject;
          if (!localArrayList2.contains(???)) {
            break label759;
          }
          if (i == 1)
          {
            akxe.a("PresendPicMgrService", "sendMsg", "preupload success,dosend! mr =  " + localMessageRecord);
            ((ambj)((QQAppInterface)localObject4).getManager(326)).d(localMessageRecord, null);
            continue;
          }
          akxe.a("PresendPicMgrService", "sendMsg", "preupload failed,reupload! mr =  " + localMessageRecord);
        }
        finally {}
        v((MessageForPic)localMessageRecord);
        continue;
        label759:
        akxe.a("PresendPicMgrService", "sendMsg", "unselect,do not send mr =  " + localMessageRecord);
      }
      if ((localList.size() >= 5) && (this.cZ == 1))
      {
        if (QLog.isColorLevel())
        {
          ??? = localList.iterator();
          while (((Iterator)???).hasNext())
          {
            localObject4 = (String)((Iterator)???).next();
            QLog.d("PresendPicMgrService", 2, "sendPhotoTask,  mSendPaths path=" + (String)localObject4);
          }
          QLog.d("PresendPicMgrService", 2, "sendPhotoTask,  lastMessageUniseq=" + l1);
        }
        aptk.a((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.myUin), this.aTl, this.myUin, localList, l1);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PresendPicMgrService", 2, "sendPhotoTask,  mSendPaths size=" + localList.size());
      }
    }
  }
  
  public void dEc()
  {
    int i = aqiw.getSystemNetwork(BaseApplication.getContext());
    akxe.a("PresendPicMgrService", "handletWifi2Mobile", "netType = " + i);
    if ((this.yx == null) || (this.yx.size() == 0)) {
      akxe.a("PresendPicMgrService", "handletWifi2Mobile", "mUploadReqList is Null! ");
    }
    for (;;)
    {
      return;
      Iterator localIterator;
      akxq localakxq;
      if (i == 2)
      {
        akxe.a("PresendPicMgrService", "handletWifi2Mobile", "switch to G2,cancel upload! ");
        localIterator = this.yx.iterator();
        while (localIterator.hasNext())
        {
          localakxq = (akxq)localIterator.next();
          a(localakxq, 1001);
          localakxq.b.picExtraFlag = 3;
        }
      }
      if (((i == 3) || (i == 4)) && (asU()))
      {
        akxe.a("PresendPicMgrService", "handletWifi2Mobile", "switch to G3/G4,overWastLimit,cancel upload! ");
        localIterator = this.yx.iterator();
        while (localIterator.hasNext())
        {
          localakxq = (akxq)localIterator.next();
          a(localakxq, 1002);
          localakxq.b.picExtraFlag = 3;
        }
      }
    }
  }
  
  public void dEe()
  {
    this.dpM = 0;
    this.aeJ = 0L;
    this.bUM = null;
  }
  
  public void fw(String paramString, int paramInt)
    throws RemoteException
  {
    akxe.a("PresendPicMgrService", "cancelUploadReq", " start,localUUID = " + paramString + ", cancelType = " + paramInt);
    akxq localakxq = a(this.yx, paramString);
    if (localakxq == null)
    {
      akxe.a("PresendPicMgrService", "cancelUploadReq", " find req failed ");
      return;
    }
    this.yx.remove(localakxq);
    a(localakxq, paramInt);
    akxe.a("PresendPicMgrService", "cancelUploadReq", " end,localUUID = " + paramString);
  }
  
  public void j(int paramInt, long paramLong, String paramString)
  {
    this.dpM = paramInt;
    this.aeJ = paramLong;
    this.bUM = paramString;
  }
  
  public int lk()
  {
    return this.cZ;
  }
  
  void resetStatus()
  {
    akxe.a("PresendPicMgrService", "resetStatus", "");
    this.yx.clear();
    this.yy.clear();
    this.cvo = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akya
 * JD-Core Version:    0.7.0.1
 */