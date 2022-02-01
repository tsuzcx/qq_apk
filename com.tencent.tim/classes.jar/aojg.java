import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.ExpRoamExtendInfo;

public class aojg
  extends aojr
{
  private Bdh_extinfo.UploadPicExtInfo jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$UploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
  Transaction jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = null;
  private cmd0x388.ExpRoamExtendInfo jdField_a_of_type_TencentImCsCmd0x388Cmd0x388$ExpRoamExtendInfo = new cmd0x388.ExpRoamExtendInfo();
  private long jdField_app_of_type_Long;
  QQAppInterface jdField_app_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)this.app;
  private String ckV;
  private String ckW;
  private int dOM;
  private byte[] fE;
  
  public aojg(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
    this.dOM = paramaool.dOM;
    this.jdField_b_of_type_Aoko.commandId = paramaool.dOM;
    this.ckW = paramaool.ckW;
    this.fE = paramaool.gb;
  }
  
  public static byte[] ar()
  {
    return SessionInfo.getInstance(BaseApplicationImpl.getApplication().getRuntime().getAccount()).getSessionKey();
  }
  
  public static byte[] as()
  {
    return SessionInfo.getInstance(BaseApplicationImpl.getApplication().getRuntime().getAccount()).getHttpconn_sig_session();
  }
  
  private final void sendRequest()
  {
    this.jdField_a_of_type_Aojn$a.dVf();
    aoql.a locala = a();
    if (!azQ())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Aojn$a);
      onError();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        hM("requestStart", locala.toString());
      }
    } while ((!azR()) || (locala == null));
    this.jdField_a_of_type_Aoql$a = locala;
    QLog.i("BDHCommonUploadProcessor", 1, "BDHCommonUploadProcessor commonId: " + this.dOM);
    aoqm.c(locala);
  }
  
  public static List<ExcitingTransferHostInfo> w(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (BaseApplicationImpl.sProcessId == 1)
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject2 = ConfigManager.getInstance(BaseApplication.getContext(), ((QQAppInterface)localObject1).getHwEngine());
      if (localObject2 != null)
      {
        localObject2 = ((ConfigManager)localObject2).getOtherTypeIp(((QQAppInterface)localObject1).getApp().getBaseContext(), 21, paramBoolean);
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          localObject1 = ((List)localObject2).iterator();
        }
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (EndPoint)((Iterator)localObject1).next();
          if ((localObject2 != null) && (!TextUtils.isEmpty(((EndPoint)localObject2).host)))
          {
            localArrayList.add(new ExcitingTransferHostInfo(((EndPoint)localObject2).host, ((EndPoint)localObject2).port, true));
            continue;
            HwServlet.getConfig((AppRuntime)localObject1, ((QQAppInterface)localObject1).getCurrentUin());
          }
        }
      }
    }
    return localArrayList;
  }
  
  public final int EN()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "BDHCommonUploadProcessor.resume()");
    }
    if (this.dOM == 54)
    {
      if (this.mIsPause)
      {
        this.mIsPause = false;
        if (QLog.isColorLevel()) {
          hM("resume", "");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
          this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().resumeTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        }
      }
      return super.EN();
    }
    cancel();
    sendRequest();
    return 0;
  }
  
  protected final void H(HashMap<String, String> paramHashMap)
  {
    long l2 = 0L;
    long l3 = 0L;
    long l4 = 0L;
    long l5 = 0L;
    try
    {
      l1 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    }
    catch (Exception localException3)
    {
      try
      {
        l2 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
      }
      catch (Exception localException3)
      {
        try
        {
          l3 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              l4 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
              String str1 = (String)paramHashMap.get("tc_p:");
              String str2 = (String)paramHashMap.get("rep_bdhTrans");
              String str3 = (String)paramHashMap.get("segspercnt");
              String str4 = (String)paramHashMap.get("param_conf_segSize");
              String str5 = (String)paramHashMap.get("param_conf_segNum");
              String str6 = (String)paramHashMap.get("param_conf_connNum");
              paramHashMap = (String)paramHashMap.get("param_fin_lost");
              if (str1 != null) {
                this.mM.put("X-piccachetime", str1);
              }
              if (paramHashMap != null) {
                this.mM.put("param_fin_lost", paramHashMap);
              }
              this.mM.put("param_BdhTrans", str2);
              this.mM.put("param_segspercnt", str3);
              this.mM.put("param_conf_segSize", str4);
              this.mM.put("param_conf_segNum", str5);
              this.mM.put("param_conf_connNum", str6);
              e(l1, l2, l3, l4);
              return;
              localException1 = localException1;
              long l1 = l2;
              if (QLog.isColorLevel())
              {
                QLog.w("BDHCommonUploadProcessor", 2, "upFlow_Wifi : number format exception !");
                l1 = l2;
                continue;
                localException2 = localException2;
                l2 = l3;
                if (QLog.isColorLevel())
                {
                  QLog.w("BDHCommonUploadProcessor", 2, "dwFlow_Wifi : number format exception !");
                  l2 = l3;
                  continue;
                  localException3 = localException3;
                  l3 = l4;
                  if (QLog.isColorLevel())
                  {
                    QLog.w("BDHCommonUploadProcessor", 2, "upFlow_Xg : number format exception !");
                    l3 = l4;
                  }
                }
              }
            }
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              l4 = l5;
              if (QLog.isColorLevel())
              {
                QLog.w("BDHCommonUploadProcessor", 2, "dwFlow_Xg : number format exception !");
                l4 = l5;
              }
            }
          }
        }
      }
    }
  }
  
  public final int KH()
  {
    hM("uiParam", this.h.toString());
    if (!TextUtils.isEmpty(this.h.dQ))
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      aqhu.d(this.h.dQ, (BitmapFactory.Options)localObject);
      this.mHeight = ((BitmapFactory.Options)localObject).outHeight;
      this.mWidth = ((BitmapFactory.Options)localObject).outWidth;
    }
    Object localObject = this.h.dQ;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      dN(9302, f(new Exception("filePath null")));
      onError();
      return -1;
    }
    File localFile = new File((String)localObject);
    if (!localFile.exists())
    {
      dN(9042, f(new Exception("sendFile not exist " + (String)localObject)));
      onError();
      return -1;
    }
    if (!localFile.canRead())
    {
      dN(9070, f(new Exception("sendFile not readable " + this.jdField_b_of_type_Aoko.filePath)));
      onError();
      return -1;
    }
    long l = localFile.length();
    this.jdField_b_of_type_Aoko.fileSize = l;
    this.mFileSize = l;
    if (l <= 0L)
    {
      dN(9071, f(new Exception("file size 0 " + (String)localObject)));
      onError();
      return -1;
    }
    localObject = aqhq.estimateFileType((String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.clg = ((String)localObject);
    }
    if ((this.dOM != 54) && (l >= aopb.hm()))
    {
      a(9063, (String)localObject, or((String)localObject), null);
      onError();
      return -1;
    }
    if ((this.h.en != null) && ((this.h.en instanceof aool.d))) {
      this.cLX = ((aool.d)this.h.en).cNJ;
    }
    return 0;
  }
  
  protected final long U(long paramLong)
  {
    paramLong = this.mFileSize - paramLong;
    if (!this.cMc) {}
    for (paramLong = Math.min(paramLong, this.jdField_b_of_type_Auyc.a(BaseApplication.getContext(), this.mFileSize, this.bz, -1));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  protected aoql.a a()
  {
    aoql.a locala = new aoql.a();
    aoql.a.i locali = new aoql.a.i();
    locali.fileName = this.mFileName;
    locali.fileSize = this.mFileSize;
    locali.md5 = this.bL;
    locali.width = this.mWidth;
    locali.height = this.mHeight;
    locali.cMs = this.cLX;
    locali.selfUin = this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    locali.cNY = this.h.cNE;
    locali.peerUin = this.h.mPeerUin;
    locala.b = this;
    locala.cmy = "bdh_common_up";
    locala.He.add(locali);
    locala.a = this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    locala.commandId = this.dOM;
    locala.gc = this.fE;
    return locala;
  }
  
  public final void a(aoql.a parama, aoql.b paramb)
  {
    if (paramb != null)
    {
      int i = 0;
      if (i < paramb.Hf.size())
      {
        parama = (aoql.b.a)paramb.Hf.get(i);
        if (QLog.isColorLevel()) {
          hM("procUrl", parama.toString());
        }
        a(this.jdField_a_of_type_Aojn$a, parama);
        if (QLog.isColorLevel()) {
          QLog.d("BDHCommonUploadProcessor", 2, "onBusiProtoResp()------response.result = " + parama.result);
        }
        if (parama.result == 0)
        {
          this.ckV = parama.mUkey;
          this.bz = this.mFileSize;
          if (QLog.isColorLevel()) {
            QLog.d("BDHCommonUploadProcessor", 2, "onBusiProtoResp()---- sessionKey: " + this.ckV);
          }
          this.jdField_b_of_type_Aoko.clu = parama.clu;
          this.jdField_b_of_type_Aoko.clv = parama.clv;
          this.jdField_b_of_type_Aoko.clw = parama.clw;
          this.jdField_b_of_type_Aoko.clx = parama.clx;
          this.jdField_b_of_type_Aoko.fileUrl = ("http://" + parama.clu + parama.clv);
          this.jdField_b_of_type_Aoko.thumbUrl = ("http://" + parama.clu + parama.clw);
          this.jdField_b_of_type_Aoko.clt = ("http://" + parama.clu + parama.clx);
          this.jdField_b_of_type_Aoko.serverPath = parama.resid;
          if (parama.isExist)
          {
            this.jdField_b_of_type_Aoko.dVw();
            onSuccess();
            if (QLog.isColorLevel()) {
              QLog.d("BDHCommonUploadProcessor", 2, "onBusiProtoResp()---- file is Exsit! " + this.h.dQ);
            }
            label374:
            this.jdField_app_of_type_Long = parama.groupFileID;
            this.jdField_b_of_type_Aoko.apJ = this.jdField_app_of_type_Long;
            if (QLog.isColorLevel()) {
              QLog.d("BDHCommonUploadProcessor", 2, "mFileID->" + this.jdField_app_of_type_Long + " groupUin->" + this.h.mPeerUin);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if ((this.dOM == 9) && (parama.resid != null)) {
            this.jdField_a_of_type_TencentImCsCmd0x388Cmd0x388$ExpRoamExtendInfo.bytes_resid.set(ByteStringMicro.copyFrom(parama.resid.getBytes()));
          }
          if ((this.dOM == 20) && (parama.resid != null)) {
            this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$UploadPicExtInfo.bytes_file_resid.set(ByteStringMicro.copyFrom(parama.resid.getBytes()));
          }
          this.mUkey = parama.mUkey;
          this.bz = parama.transferedSize;
          this.apw = parama.startOffset;
          diB();
          break label374;
          onError();
        }
      }
    }
  }
  
  byte[] aq()
  {
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(500);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    cmd0x346.ApplyUploadReq localApplyUploadReq = new cmd0x346.ApplyUploadReq();
    localApplyUploadReq.uint64_sender_uin.set(Long.parseLong(this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()));
    try
    {
      String str = this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      localObject = str;
      if (str.startsWith("+")) {
        localObject = str.substring(1);
      }
      long l = Long.valueOf((String)localObject).longValue();
      localApplyUploadReq.uint64_recver_uin.set(l);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        int i;
        localException.printStackTrace();
      }
    }
    localApplyUploadReq.uint32_file_type.set(2);
    localApplyUploadReq.str_file_name.set(this.mFileName);
    localApplyUploadReq.uint64_file_size.set(this.mFileSize);
    localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(this.bL));
    localReqBody.msg_apply_upload_req.set(localApplyUploadReq);
    localObject = new cmd0x346.ExtensionReq();
    ((cmd0x346.ExtensionReq)localObject).uint64_id.set(3L);
    ((cmd0x346.ExtensionReq)localObject).uint32_ptt_format.set(0);
    ((cmd0x346.ExtensionReq)localObject).uint32_ptt_time.set(this.h.dQH);
    i = aopw.KW();
    ((cmd0x346.ExtensionReq)localObject).uint32_net_type.set(i);
    ((cmd0x346.ExtensionReq)localObject).uint32_voice_type.set(2);
    ((cmd0x346.ExtensionReq)localObject).uint64_type.set(0);
    localReqBody.msg_extension_req.set((MessageMicro)localObject);
    return localReqBody.toByteArray();
  }
  
  public final int cancel()
  {
    super.cancel();
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().cancelTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    }
    return 0;
  }
  
  public final void diB()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "BDHNormalUploadProcessor.sendFile()");
    }
    this.jdField_b_of_type_Aojn$a.dVf();
    aojh localaojh = new aojh(this, SystemClock.uptimeMillis());
    if (this.dOM == 9) {
      this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.dOM, this.h.dQ, (int)this.apw, aqoj.ag(this.ckV), this.bL, localaojh, this.jdField_a_of_type_TencentImCsCmd0x388Cmd0x388$ExpRoamExtendInfo.toByteArray());
    }
    for (;;)
    {
      int i = this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.h.mUniseq + " MD5:" + this.clf + " uuid:" + this.mUuid + " Path:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 3);
      }
      if (i != 0)
      {
        a(i, "SubmitError.", "", this.jdField_b_of_type_Aojn$a);
        onError();
      }
      return;
      if (this.dOM == 20) {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.dOM, this.h.dQ, (int)this.apw, aqoj.ag(this.ckV), this.bL, localaojh, this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$UploadPicExtInfo.toByteArray());
      } else if (this.dOM == 36) {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.dOM, this.h.dQ, (int)this.apw, this.bL, localaojh, aq(), false);
      } else if (this.dOM == 40) {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.dOM, this.h.dQ, (int)this.apw, this.bL, localaojh, this.h.gb, true);
      } else if (this.dOM == 54) {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.dOM, this.h.dQ, (int)this.apw, this.bL, localaojh, this.h.gb, false);
      } else if ((this.dOM == 51) || (this.dOM == 58) || (this.dOM == 62) || (this.dOM == 65) || (this.dOM == 70) || (this.dOM == 76)) {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.dOM, this.h.dQ, (int)this.apw, this.bL, localaojh, this.h.gb, false);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.dOM, this.h.dQ, (int)this.apw, aqoj.ag(this.ckV), this.bL, localaojh);
      }
    }
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if ((!paramBoolean) && (aona.lQ(this.errCode))) {}
    while ((this.cLT) || ((paramBoolean) && ((this.dOZ & 0x2) > 0)) || ((!paramBoolean) && ((this.dOZ & 0x1) > 0))) {
      return;
    }
    int j = this.dOZ;
    int i;
    long l;
    String str;
    if (paramBoolean)
    {
      i = 2;
      this.dOZ = (i | j);
      this.mEndTime = System.currentTimeMillis();
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      HashMap localHashMap = this.mM;
      if (this.ckV != null) {
        break label158;
      }
      str = "null";
      label105:
      localHashMap.put("param_sessionKey", str);
      if (!paramBoolean) {
        break label167;
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(null, this.ckW, true, l, this.mFileSize, this.mM, "");
    }
    for (;;)
    {
      dVc();
      return;
      i = 1;
      break;
      label158:
      str = this.ckV;
      break label105;
      label167:
      if (this.errCode != -9527) {
        this.mM.remove("param_rspHeader");
      }
      this.mM.put("param_FailCode", String.valueOf(this.errCode));
      this.mM.put("param_errorDesc", this.errDesc);
      this.mM.put("param_picSize", String.valueOf(this.mFileSize));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, this.ckW, false, l, this.mFileSize, this.mM, "");
    }
  }
  
  protected final void e(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong1 != 0L) {
      this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.countFlow(true, 1, this.h.mFileType, this.h.mUinType, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.countFlow(true, 1, this.h.mFileType, this.h.mUinType, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.countFlow(true, 0, this.h.mFileType, this.h.mUinType, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.countFlow(true, 0, this.h.mFileType, this.h.mUinType, paramLong4);
    }
  }
  
  final void onError()
  {
    super.onError();
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "uploadCustomEmoticon resultError");
    }
    VR(1005);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "uploadCustomEmoticon resultError ---- errCode: " + this.errCode + ", errDesc:" + this.errDesc);
    }
    akyf.a locala;
    String str;
    if (this.h.b != null)
    {
      locala = new akyf.a();
      locala.result = -1;
      locala.errCode = this.errCode;
      locala.errStr = this.errDesc;
      if ((this.dOM == 20) && (aojn.bH(120509L).equals(this.mM.get("param_reason")))) {
        locala.errCode = 120509;
      }
      if (this.dOM == 9)
      {
        str = (String)this.mM.get("param_reason");
        if (!aojn.bH(400010L).equals(str)) {
          break label208;
        }
        locala.errCode = 400010;
      }
    }
    for (;;)
    {
      this.h.b.b(locala);
      return;
      label208:
      if (aojn.bH(400011L).equals(str)) {
        locala.errCode = 400011;
      }
    }
  }
  
  public final void onResp(aomh paramaomh)
  {
    super.onResp(paramaomh);
  }
  
  final void onSuccess()
  {
    super.onSuccess();
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "uploadCustomEmoticon resultOk");
    }
    VR(1003);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "onSuccess().");
    }
    if (this.h.b != null)
    {
      akyf.a locala = new akyf.a();
      locala.result = 0;
      if (this.dOM == 20) {
        locala.uuid = this.jdField_b_of_type_Aoko.serverPath;
      }
      this.h.b.b(locala);
    }
    if ((this.dOM == 9) || (this.dOM == 76)) {
      VR(1008);
    }
  }
  
  public void pause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "BDHCommonUploadProcessor.pause()");
    }
    if (this.dOM == 54)
    {
      if (!this.mIsPause)
      {
        this.mIsPause = true;
        if (QLog.isColorLevel()) {
          hM("pause", "");
        }
        VR(1006);
        if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
          this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().stopTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        }
      }
      return;
    }
    super.pause();
  }
  
  public final void start()
  {
    super.start();
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "BDHCommonUploadProcessor.start()");
    }
    if ((this.bL == null) && (!azT()))
    {
      onError();
      return;
    }
    if (36 == this.dOM)
    {
      this.ckV = "null";
      this.jdField_b_of_type_Aoko.filePath = this.h.dQ;
      diB();
    }
    for (;;)
    {
      VR(1001);
      return;
      if (18 == this.dOM)
      {
        this.ckV = "null";
        diB();
      }
      else if (40 == this.dOM)
      {
        diB();
      }
      else if (54 == this.dOM)
      {
        diB();
      }
      else if ((51 == this.dOM) || (62 == this.dOM))
      {
        diB();
      }
      else if (58 == this.dOM)
      {
        diB();
      }
      else if (65 == this.dOM)
      {
        diB();
      }
      else if (70 == this.dOM)
      {
        diB();
      }
      else if (76 == this.dOM)
      {
        diB();
      }
      else
      {
        sendRequest();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aojg
 * JD-Core Version:    0.7.0.1
 */