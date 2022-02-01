import QQService.StreamData;
import QQService.StreamInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.text.format.Time;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class aojs
  extends aojn
{
  private static List<String> Hb = new ArrayList();
  public static boolean cMg = true;
  private anvq a = (anvq)this.app.getManager(17);
  public QQAppInterface app = (QQAppInterface)this.app;
  long apz = -1L;
  public boolean cMf;
  private boolean cMh;
  boolean cMi = false;
  public boolean cMj = false;
  int dEW = -1;
  int dPh = 0;
  int dPi = 1;
  int dPj = 0;
  int dPk = -1;
  achq e = new aojt(this);
  private String friendUin;
  public boolean isStop;
  private int msgseq;
  private String peerUin;
  private long random;
  private ExecutorService s;
  private String selfUin = this.app.getCurrentAccountUin();
  public int voiceLength = 0;
  public int voiceType = 0;
  
  public aojs(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, String paramString4, int paramInt1, int paramInt2, boolean paramBoolean2, aooi paramaooi, long paramLong)
  {
    super(paramString1, paramString2, paramBoolean1, paramaooi);
    paramInt2 = paramInt1;
    if (paramInt1 == 131075)
    {
      paramInt2 = 1;
      this.cMf = true;
    }
    this.friendUin = paramString1;
    this.b.peerUin = paramString1;
    this.b.selfUin = this.selfUin;
    if ((!paramBoolean1) && (paramBoolean2))
    {
      this.b.mUin = this.selfUin;
      this.b.friendUin = paramString1;
    }
    for (this.peerUin = this.selfUin;; this.peerUin = paramString1)
    {
      QW(false);
      VS(paramInt2);
      this.b.uinType = 0;
      if (aqhq.rq(paramString3)) {
        this.b.filePath = paramString3;
      }
      if ((paramString4 != null) && (!aqhq.rq(paramString4))) {
        this.b.serverPath = paramString4;
      }
      if (paramInt2 == 65538)
      {
        this.b.fileMd5 = this.b.filePath;
        this.b.clr = "gif";
      }
      if (paramInt2 == 2) {
        aonc.VZ(AppSetting.getAppId());
      }
      if ((paramInt2 == 2) && (paramBoolean1))
      {
        paramString1 = this.app.b().a(this.peerUin, 0, paramLong);
        if (paramString1 != null)
        {
          this.random = anbk.ab(paramString1.msgUid);
          this.msgseq = ((int)paramString1.shmsgseq);
        }
        if (QLog.isColorLevel()) {
          QLog.e("streamptt", 2, "random:" + this.random + " msgseq:" + this.msgseq);
        }
      }
      return;
    }
  }
  
  public static String AK()
  {
    Time localTime = new Time();
    localTime.setToNow();
    if (localTime.month + 1 > 9) {}
    for (String str = "" + (localTime.month + 1);; str = "0" + (localTime.month + 1)) {
      return "" + localTime.year + str + "/" + localTime.monthDay;
    }
  }
  
  public static aojs.a a(byte[] paramArrayOfByte, long[] paramArrayOfLong)
  {
    aojs.a locala = new aojs.a();
    long l = paramArrayOfLong[0];
    byte[] arrayOfByte;
    if (paramArrayOfByte[0] == 1)
    {
      locala.type = paramArrayOfByte[1];
      int k = aqoj.b(paramArrayOfByte, 2) + 4;
      int j = paramArrayOfByte[k];
      int i = j;
      if (j < 0) {
        i = j + 256;
      }
      j = k + 1;
      arrayOfByte = new byte[i];
      aqoj.copyData(arrayOfByte, 0, paramArrayOfByte, j, i);
      i += j;
      l = aqoj.getLongData(paramArrayOfByte, i + 2 + aqoj.b(paramArrayOfByte, i));
      if (arrayOfByte != null) {
        if (l > 10000L) {
          paramArrayOfLong[0] = l;
        }
      }
    }
    for (paramArrayOfByte = new String(arrayOfByte);; paramArrayOfByte = null)
    {
      locala.serverPath = paramArrayOfByte;
      return locala;
    }
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    return a(paramString1, paramString2, paramInt, paramArrayOfByte, true);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    paramString1 = acbn.SDCARD_PATH + paramString1 + "/";
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = "";
      paramString2 = null;
      paramArrayOfByte = paramString1;
      paramString1 = (String)localObject;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("streamptt", 2, "getTransferFilePath dir: " + paramArrayOfByte);
      }
      localObject = new File(paramArrayOfByte);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramString1 = new File(paramArrayOfByte + paramString1 + paramString2);
      if (paramInt == 0) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "getTransferFilePath : " + paramString1.getAbsoluteFile().toString());
        }
        return paramString1.getAbsoluteFile().toString();
        paramArrayOfByte = aoqr.A(paramString1 + "ptt/" + AK() + "/", true);
        String str2 = ".amr";
        localObject = str2;
        paramString1 = paramArrayOfByte;
        if (paramString2 != null) {
          break label842;
        }
        if (QLog.isColorLevel()) {
          QLog.i("streamptt", 2, "pttdown,33333");
        }
        str1 = "stream_" + vd();
        localObject = str2;
        paramString2 = paramArrayOfByte;
        paramString1 = str1;
        if (!QLog.isColorLevel()) {
          break label857;
        }
        QLog.i("streamptt", 2, "pttdown,name = " + str1);
        paramString2 = ".amr";
        paramString1 = str1;
        break;
        str1 = paramString1 + "photo/";
        str2 = ".jpg";
        localObject = str2;
        paramString1 = str1;
        if (paramString2 != null) {
          break label842;
        }
        String str3 = vd();
        localObject = str2;
        paramString2 = str1;
        paramString1 = str3;
        if (paramArrayOfByte == null) {
          break label857;
        }
        paramString1 = str3 + HexUtil.bytes2HexStr(paramArrayOfByte).substring(0, 5);
        paramString2 = ".jpg";
        paramArrayOfByte = str1;
        break;
        localObject = acbn.bmg;
        paramString1 = paramString2;
        if (paramString2 == null)
        {
          paramString2 = vd();
          paramString1 = paramString2;
          if (paramArrayOfByte != null) {
            paramString1 = paramString2 + HexUtil.bytes2HexStr(paramArrayOfByte).substring(0, 5);
          }
        }
        paramString2 = "";
        paramArrayOfByte = (byte[])localObject;
        break;
        paramArrayOfByte = paramString1 + "ptt/";
        localObject = ".slk";
        paramString1 = paramArrayOfByte;
        if (paramString2 != null) {
          break label842;
        }
        paramString1 = "buluo_" + vd();
        paramString2 = ".slk";
        break;
        paramArrayOfByte = paramString1 + "ptt/";
        localObject = ".slk";
        paramString1 = paramArrayOfByte;
        if (paramString2 != null) {
          break label842;
        }
        paramString1 = "vs_" + vd();
        paramString2 = ".slk";
        break;
        paramArrayOfByte = paramString1 + "ptt/";
        localObject = ".slk";
        paramString1 = paramArrayOfByte;
        if (paramString2 != null) {
          break label842;
        }
        paramString1 = "homework_" + vd();
        paramString2 = ".slk";
        break;
        paramArrayOfByte = paramString1 + "ptt/";
        paramString1 = ".slk";
        if (paramString2 == null)
        {
          localObject = "ef_" + vd();
          paramString2 = paramString1;
          paramString1 = (String)localObject;
          break;
        }
        localObject = "ef_" + paramString2;
        paramString2 = paramString1;
        paramString1 = (String)localObject;
        break;
        if ((paramBoolean) && (!paramString1.exists())) {
          try
          {
            paramString1.createNewFile();
          }
          catch (IOException paramString2) {}
        }
      }
      label842:
      String str1 = "";
      paramString2 = (String)localObject;
      paramArrayOfByte = paramString1;
      paramString1 = str1;
      continue;
      label857:
      paramArrayOfByte = paramString2;
      paramString2 = (String)localObject;
    }
  }
  
  private void b(boolean paramBoolean, anbd.c paramc)
  {
    int i = paramc.aq;
    short s1 = (short)paramc.layer;
    Object localObject = paramc.key;
    if (paramBoolean) {
      if (paramc.dEW != 0)
      {
        this.dEW = paramc.dEW;
        d(this.friendUin, 0, this.b.uniseq, this.dEW);
        L(2, 9312, "friend_block");
        onError();
        anqo.Rm((String)localObject);
        anqo.py((String)localObject);
        if (paramc.dEW == 58) {
          dVk();
        }
        if (QLog.isColorLevel()) {
          QLog.e("streamptt.send", 2, "respCode = " + this.dEW);
        }
      }
    }
    do
    {
      int k;
      long l;
      int j;
      do
      {
        do
        {
          short s2;
          do
          {
            do
            {
              return;
              if (i == -1)
              {
                this.cMi = true;
                VQ(2);
                this.b.a.gu.put("param_sliceNum", String.valueOf(anqo.b((String)localObject)));
                this.b.fileSize = new File(this.b.filePath).length();
                anqo.py((String)localObject);
                this.b.serverPath = paramc.a.fileKey;
                if (paramc.a.pttTransFlag == 1) {}
                for (s2 = 1;; s2 = 0)
                {
                  this.dPk = s2;
                  this.apz = paramc.a.msgTime;
                  onSuccess();
                  return;
                }
              }
            } while (this.cMi);
            s2 = anqo.a((String)localObject);
            if (s2 > 10)
            {
              if (QLog.isColorLevel()) {
                QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: preLayer > 10");
              }
              L(2, 9310, "retry overflow");
              onError();
              anqo.Rm((String)localObject);
              anqo.py((String)localObject);
              return;
            }
            k = anqo.ev((String)localObject);
            int m = anqo.b((String)localObject);
            this.dPi = i;
            if (QLog.isColorLevel()) {
              QLog.d("streamptt.send", 2, "server reset.ResetSeq: " + i + " packnum: " + m + ",slices:" + k + " uniseq:" + this.b.uniseq + ",flowLayer:" + s1 + ",prelayer:" + s2);
            }
          } while (s2 >= s1);
          anqo.b((String)localObject, s1);
          paramc = this.app.b().a(this.friendUin, 0, this.b.uniseq);
          l = 0L;
          localObject = new Bundle();
          if (paramc != null)
          {
            l = paramc.vipSubBubbleId;
            ((Bundle)localObject).putInt("DiyTextId", paramc.vipBubbleDiyTextId);
          }
          a(true, i, (short)k, l, (Bundle)localObject);
          this.b.jJ(2, 2);
          return;
        } while (this.cMi);
        j = anqo.ev((String)localObject);
        k = anqo.a((String)localObject);
        if (paramc.layer >= k) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: info.layer < flowlayer");
      return;
      if (this.dPj == i)
      {
        if (this.dPh < 8)
        {
          this.dPh += 1;
          this.dPj = 0;
          if (QLog.isColorLevel()) {
            QLog.d("streamptt.send", 2, "client check timeout.retry:severAckSlice:" + this.dPi + " packnum: " + j + " maxSendSeq:" + this.dPj + " uniseq:" + this.b.uniseq + ",retryCount:" + this.dPh + ",flowLayer:" + k);
          }
          paramc = this.app.b().a(this.friendUin, 0, this.b.uniseq);
          l = 0L;
          localObject = new Bundle();
          if (paramc != null)
          {
            l = paramc.vipSubBubbleId;
            ((Bundle)localObject).putInt("DiyTextId", paramc.vipBubbleDiyTextId);
          }
          a(true, (short)this.dPi, (short)j, l, (Bundle)localObject);
          return;
        }
        L(2, 9310, "timeout");
        onError();
        anqo.py((String)localObject);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: sendSeqMax != shResetSeq");
  }
  
  private void d(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    QQMessageFacade.Message localMessage = this.app.b().a(paramString, paramInt1);
    this.app.a().e(paramString, paramInt1, paramLong);
    if ((localMessage != null) && (localMessage.uniseq == paramLong)) {
      localMessage.extraflag = 32768;
    }
    this.app.b().b(paramString, paramInt1, paramLong, 32768, paramInt2);
  }
  
  private void dVk()
  {
    String str1 = this.app.getCurrentAccountUin();
    String str2 = acfp.m(2131703277);
    long l = anaz.gQ();
    MessageRecord localMessageRecord = anbi.d(-2012);
    localMessageRecord.init(str1, this.friendUin, str1, str2, l, 0, 0, l);
    localMessageRecord.msgtype = -2012;
    localMessageRecord.isread = true;
    this.app.b().b(localMessageRecord, str1);
  }
  
  private static String vd()
  {
    try
    {
      Thread.sleep(1L);
      long l = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date(l));
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  public void QV(boolean paramBoolean)
  {
    label337:
    for (paramBoolean = true;; paramBoolean = false)
    {
      for (;;)
      {
        try
        {
          if (this.b.fileType != 2) {
            break;
          }
          MessageForPtt localMessageForPtt = (MessageForPtt)this.app.b().a(this.friendUin, 0, this.b.uniseq);
          localMessageForPtt.url = this.b.filePath;
          localMessageForPtt.fileSize = this.b.transferedSize;
          localMessageForPtt.itemType = this.b.fileType;
          if (this.b.dPr != 1) {
            break label337;
          }
          localMessageForPtt.isread = paramBoolean;
          localMessageForPtt.urlAtServer = this.b.serverPath;
          if (anvq.bD(this.app))
          {
            localMessageForPtt.sttAbility = 1;
            QQAppInterface localQQAppInterface = this.app;
            if (localMessageForPtt.isSend())
            {
              Object localObject = this.selfUin;
              localMessageForPtt.longPttVipFlag = anbk.k(localQQAppInterface, (String)localObject);
              localMessageForPtt.serial();
              if (QLog.isColorLevel()) {
                QLog.e("streamptt.send", 2, "Stream ptt:updataMessageDataBaseContent:time" + localMessageForPtt.time + " urlAtServer:" + localMessageForPtt.urlAtServer);
              }
              this.app.b().c(this.friendUin, 0, this.b.uniseq, localMessageForPtt.msgData);
              localMessageForPtt.time = this.apz;
              this.app.b().c(this.friendUin, 0, this.b.uniseq, this.apz);
              localObject = this.app.b().a(this.friendUin, 0);
              if ((localObject == null) || (this.b.serverPath == null) || (!this.b.serverPath.equals(((QQMessageFacade.Message)localObject).pttUrl))) {
                break;
              }
              ((QQMessageFacade.Message)localObject).pttUrl = localMessageForPtt.url;
            }
          }
          else
          {
            localMessageForPtt.sttAbility = this.dPk;
            continue;
          }
          String str = this.friendUin;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
      }
      return;
    }
  }
  
  public MessageRecord a(long paramLong1, StreamInfo paramStreamInfo, long paramLong2, Bundle paramBundle)
  {
    Object localObject1 = new byte[3];
    aqoj.a(this.b.serverPath.length(), (byte[])localObject1, 0, 3, "utf-8");
    localObject1 = (MessageForPtt)anbi.d(-2002);
    ((MessageForPtt)localObject1).voiceType = ((int)paramStreamInfo.pttFormat);
    ((MessageForPtt)localObject1).voiceLength = ((int)paramStreamInfo.pttTime);
    if (QLog.isColorLevel()) {
      QLog.d("streamptt", 2, "voiceLength createMessageDataBaseContent " + ((MessageForPtt)localObject1).voiceLength);
    }
    ((MessageForPtt)localObject1).selfuin = this.selfUin;
    ((MessageForPtt)localObject1).frienduin = this.friendUin;
    ((MessageForPtt)localObject1).senderuin = this.b.mUin;
    ((MessageForPtt)localObject1).isread = false;
    ((MessageForPtt)localObject1).time = paramStreamInfo.msgTime;
    ((MessageForPtt)localObject1).setPttStreamFlag(10001);
    ((MessageForPtt)localObject1).msgtype = -2002;
    ((MessageForPtt)localObject1).istroop = 0;
    ((MessageForPtt)localObject1).urlAtServer = this.b.serverPath;
    ((MessageForPtt)localObject1).url = MessageForPtt.getMsgFilePath(((MessageForPtt)localObject1).voiceType, this.b.filePath);
    Object localObject2 = new File(this.b.filePath);
    int i;
    if (((File)localObject2).exists())
    {
      ((MessageForPtt)localObject1).fileSize = ((File)localObject2).length();
      anot.a(this.app, "CliOper", "", "", "0X800610E", "0X800610E", 1, 0, "", "", "", "3.4.4");
      ((MessageForPtt)localObject1).itemType = 2;
      ((MessageForPtt)localObject1).isread = false;
      ((MessageForPtt)localObject1).shmsgseq = ((short)paramStreamInfo.msgSeq);
      ((MessageForPtt)localObject1).msgUid = anbk.I((int)paramStreamInfo.random);
      if ((paramStreamInfo.pttTransFlag != 1) && (!anvq.bD(this.app))) {
        break label746;
      }
      i = 1;
      label313:
      ((MessageForPtt)localObject1).sttAbility = i;
      localObject2 = this.app;
      if (!((MessageForPtt)localObject1).isSend()) {
        break label752;
      }
    }
    label746:
    label752:
    for (paramStreamInfo = this.selfUin;; paramStreamInfo = this.friendUin)
    {
      ((MessageForPtt)localObject1).longPttVipFlag = anbk.k((QQAppInterface)localObject2, paramStreamInfo);
      long l1 = System.currentTimeMillis() / 1000L;
      long l2 = ((MessageForPtt)localObject1).time;
      ((MessageForPtt)localObject1).msgRecTime = l1;
      ((MessageForPtt)localObject1).msgTime = l2;
      ((MessageForPtt)localObject1).vipSubBubbleId = ((int)paramLong2);
      ((MessageForPtt)localObject1).vipBubbleDiyTextId = paramBundle.getInt("DiyTextId", 0);
      i = paramBundle.getInt("DiyPendantId", 0);
      if (i > 0) {
        ((MessageForPtt)localObject1).saveExtInfoToExtStr("vip_pendant_diy_id", String.valueOf(i));
      }
      ((MessageForPtt)localObject1).serial();
      paramLong2 = paramLong1;
      if (paramLong1 == 4294967295L)
      {
        paramLong1 = this.app.b().S(((MessageForPtt)localObject1).frienduin);
        paramLong2 = paramLong1;
        if (QLog.isColorLevel())
        {
          QLog.e("streamptt.recv", 2, "Stream ptt:createMessageDataBaseContent: invalid bubbleID 0xffffffff. get one from cache:" + paramLong1);
          paramLong2 = paramLong1;
        }
      }
      ((MessageForPtt)localObject1).vipBubbleID = paramLong2;
      if (QLog.isColorLevel()) {
        QLog.e("streamptt.recv", 2, "Stream ptt:createMessageDataBaseContent:time" + ((MessageForPtt)localObject1).time + " urlAtServer:" + ((MessageForPtt)localObject1).urlAtServer + " bubbleId:" + paramLong2 + " msgseq:" + ((MessageForPtt)localObject1).shmsgseq + " msgUid:" + ((MessageForPtt)localObject1).msgUid);
      }
      paramStreamInfo = this.app.b().k(((MessageForPtt)localObject1).frienduin, ((MessageForPtt)localObject1).istroop);
      if ((paramStreamInfo == null) || (paramStreamInfo.size() <= 0)) {
        break label760;
      }
      paramStreamInfo = paramStreamInfo.iterator();
      do
      {
        if (!paramStreamInfo.hasNext()) {
          break;
        }
      } while (!top.a((MessageRecord)paramStreamInfo.next(), (MessageRecord)localObject1, true));
      if (QLog.isColorLevel()) {
        QLog.w("streamptt", 2, "same Ptt :" + ((MessageForPtt)localObject1).getBaseInfoString());
      }
      return null;
      ((MessageForPtt)localObject1).fileSize = 1000L;
      anot.a(this.app, "CliOper", "", "", "0X800610E", "0X800610E", 2, 0, "", "", "", "3.4.4");
      break;
      i = 0;
      break label313;
    }
    label760:
    this.app.b().b((MessageRecord)localObject1, this.selfUin);
    this.b.lG(((MessageForPtt)localObject1).uniseq);
    return localObject1;
  }
  
  public void a(StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2, long paramLong3, Bundle paramBundle)
  {
    this.b.a.cMy = true;
    VP(2);
    this.isStop = false;
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "startReceiveOneStreamPack:" + paramStreamInfo.pttFormat + ", " + paramStreamInfo.pttTime);
    }
    this.b.jJ(4, paramStreamData.vData.length);
    switch (this.b.fileType)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((!Environment.getExternalStorageState().equals("mounted")) || (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1))
          {
            if (!Environment.getExternalStorageState().equals("mounted")) {
              dN(9039, "not mounted");
            }
            for (;;)
            {
              paramStreamInfo = this.app.getPreferences().edit();
              paramStreamInfo.putBoolean("sdcard_related_download_failed", true);
              paramStreamInfo.commit();
              onError();
              return;
              dN(9040, "no enough storage");
            }
          }
          i = anqo.a(this.b.serverPath);
          if (QLog.isColorLevel()) {
            QLog.d("streamptt.recv", 2, "curFlowLayer: " + i + " received shFlowLayer:" + paramStreamInfo.shFlowLayer + ",seq" + paramStreamData.shPackSeq + ",packNum:" + paramStreamInfo.shPackNum + " lkey:" + paramLong1);
          }
          this.app.sendAppDataIncerment(this.app.getAccount(), false, aqiw.getNetworkType(this.app.getApp()), 2, 0, paramStreamData.vData.length);
          anqo.aX(this.b.serverPath, paramLong1);
          if (i != paramStreamInfo.shFlowLayer)
          {
            this.app.a().a(this.selfUin, this.peerUin, this.b.serverPath, anqo.c(this.b.serverPath), paramLong1);
            return;
          }
          if (anqo.a(this.b.serverPath, paramStreamData.shPackSeq))
          {
            this.b.jJ(2, 2);
            short s1 = (short)(anqo.a(this.b.serverPath) + 1);
            anqo.b(this.b.serverPath, s1);
            if (QLog.isColorLevel()) {
              QLog.d("streamptt.recv", 2, "startReceiveOneStreamPack JudgeReceiveError flowLayer: " + s1);
            }
            this.app.a().a(this.selfUin, this.peerUin, this.b.serverPath, anqo.c(this.b.serverPath), paramLong1);
            return;
          }
          if (paramStreamInfo.oprType == 1) {}
          for (i = 1; i != 0; i = 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("streamptt.recv", 2, "cancelled:" + this.b.serverPath);
            }
            this.app.a().m(this.friendUin, this.b.serverPath, this.b.uniseq);
            anqo.cU(this.b.serverPath, true);
            anqo.py(this.b.serverPath);
            return;
          }
          anqo.b(this.b.serverPath, paramStreamInfo.shFlowLayer);
          anqo.a(this.b.serverPath, paramStreamData.vData, paramStreamData.vData.length, paramStreamData.shPackSeq);
        } while (paramStreamInfo.shPackNum <= 0);
        this.app.a().m(this.friendUin, this.b.serverPath, this.b.uniseq);
        anqo.cU(this.b.serverPath, false);
        anqo.py(this.b.serverPath);
        paramStreamData = this.selfUin + "_" + this.peerUin + "_" + paramStreamInfo.iMsgId;
        if (!Hb.contains(paramStreamData)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("streamptt.recv", 2, "find stream stream duplicate,discard it ,key:" + paramStreamData);
      return;
      Hb.add(paramStreamData);
      long l = paramStreamInfo.iSendTime;
      paramStreamData = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(l * 1000L));
      paramStreamData = this.peerUin + "_" + paramStreamData;
      if (QLog.isColorLevel()) {
        QLog.d("streamptt.recv", 2, "stream duplicateKey:" + paramStreamData);
      }
      if (!anqo.pC(paramStreamData)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("streamptt.recv", 2, "find stream offline duplicate,stop stream recv");
    return;
    anqo.pA(paramStreamData);
    VQ(2);
    if (QLog.isColorLevel()) {
      QLog.d("streamptt.recv", 2, "startReceiveOneStreamPack received success path: " + this.b.serverPath);
    }
    this.app.a().a(this.selfUin, this.peerUin, this.b.serverPath, (short)-1, paramLong1);
    this.b.cMw = true;
    this.b.serverPath = paramStreamInfo.fileKey;
    if (paramStreamInfo.pttTransFlag == 1) {}
    for (int i = 1;; i = 0)
    {
      this.dPk = i;
      if (a(paramLong2, paramStreamInfo, paramLong3, paramBundle) != null) {
        this.app.q(1, true, true);
      }
      onSuccess();
      aomq.b(this.app, 1, true, 3);
      aomq.b(this.app, 1, true, 2);
      return;
    }
  }
  
  public void a(short paramShort, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong, Bundle paramBundle)
  {
    this.voiceType = paramInt2;
    this.voiceLength = paramInt1;
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "startSendOneStreamPack:" + paramInt2 + ", " + paramInt1 + ", " + paramShort + ", subBubbleId=" + paramLong);
    }
    this.b.a.cMy = true;
    String str = "";
    if ((this.app != null) && ("0".equals(this.app.getCurrentAccountUin()))) {}
    do
    {
      return;
      this.b.status = 1001;
      VP(2);
      this.isStop = false;
      if (this.app != null)
      {
        str = this.app.getCurrentAccountUin();
        this.app.addObserver(this.e);
      }
      VP(2);
      if (paramShort > this.dPj) {
        this.dPj = paramShort;
      }
      switch (this.b.fileType)
      {
      default: 
        return;
      }
    } while ((this.s == null) || (this.s.isShutdown()));
    this.s.execute(new BuddyTransfileProcessor.2(this, str, paramShort, paramLong, paramBundle, paramBoolean));
  }
  
  public void a(boolean paramBoolean, short paramShort1, short paramShort2, long paramLong, Bundle paramBundle)
  {
    short s1 = paramShort1;
    while (s1 <= paramShort2)
    {
      a((short)s1, true, this.voiceLength, this.voiceType, paramLong, paramBundle);
      s1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("streamptt", 2, "startSendRangeStreamPack, from slice " + paramShort1 + " to slice " + paramShort2 + ", subBubbleId=" + paramLong);
    }
  }
  
  public void dVl()
  {
    this.s = Executors.newSingleThreadExecutor();
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if (aona.lQ(this.errCode)) {
      break label10;
    }
    label10:
    label593:
    for (;;)
    {
      return;
      if ((this.b.fileType == 2) && (!this.cMh) && (!aona.lQ(this.errCode)))
      {
        long l = (System.nanoTime() - this.mStartTime) / 1000000L;
        HashMap localHashMap = new HashMap();
        if (!this.b.a.cMy) {
          localHashMap.put("param_step", this.b.b.fE(1) + ";" + this.b.a.fE(2) + ";" + this.b.c.fE(3));
        }
        if (paramBoolean)
        {
          if (this.b.actionType == 0)
          {
            localHashMap.put("param_toUin", this.peerUin);
            localHashMap.putAll(this.b.a.gu);
            anpc.a(BaseApplication.getContext()).collectPerformance(null, "actC2CStreamPttUpload", true, l, this.b.fileSize, localHashMap, "");
            if (TextUtils.isEmpty(this.b.filePath)) {
              break;
            }
            aomq.a(this.b.filePath, true, paramBoolean, 0, this.b.fileSize);
            return;
          }
          anpc.a(BaseApplication.getContext()).collectPerformance(null, "actC2CStreamPttDownload", true, l, this.b.fileSize, localHashMap, "");
          return;
        }
        if (this.b.actionType == 0) {
          if (!aojn.a(this.errCode, localHashMap))
          {
            localHashMap.put("param_FailCode", Integer.toString(this.errCode));
            if ((this.errCode == -9527) || (this.errCode == 9311) || (this.errCode == 9044) || (this.errCode == 9350) || (this.errCode == 9351))
            {
              localHashMap.put(aojn.cle, this.errDesc);
              localHashMap.put("param_toUin", this.peerUin);
              anpc.a(BaseApplication.getContext()).collectPerformance(null, "actC2CStreamPttUpload", false, l, this.b.fileSize, localHashMap, "");
              if (!TextUtils.isEmpty(this.b.filePath)) {
                aomq.a(this.b.filePath, true, paramBoolean, 0, this.b.fileSize);
              }
            }
          }
        }
        for (;;)
        {
          if (this.b.fileType != 2) {
            break label593;
          }
          aonc.aO(true, String.valueOf(this.errCode) + "_" + this.errDesc);
          return;
          localHashMap.put("param_errorDesc", this.errDesc);
          break;
          this.errCode = -9527;
          localHashMap.put("param_errorDesc", this.errDesc);
          break;
          localHashMap.put("param_FailCode", String.valueOf(this.errCode));
          localHashMap.put("param_errorDesc", this.errDesc);
          anpc.a(BaseApplication.getContext()).collectPerformance(null, "actC2CStreamPttDownload", false, l, this.b.fileSize, localHashMap, "");
        }
      }
    }
  }
  
  void onError()
  {
    if (this.s != null) {
      this.s.shutdown();
    }
    long l = (System.nanoTime() - this.mStartTime) / 1000000L;
    if ((!this.app.isLogin()) || (!this.app.isRunning())) {
      dN(9366, "account switch");
    }
    if (this.b.actionType == 0) {}
    for (String str = "streamptt.send";; str = "streamptt.recv")
    {
      QLog.d(str, 2, "onError elapsed:" + l + " errCode:" + this.errCode + " errDesc:" + this.errDesc + " reason:" + (String)this.mM.get("param_reason") + " uniseq:" + this.b.uniseq);
      this.app.removeObserver(this.e);
      doReport(false);
      if (this.b.actionType != 0) {
        break;
      }
      VR(1005);
      this.app.a().l(this.friendUin, this.b.serverPath, this.b.uniseq);
      return;
    }
    VR(2005);
    this.app.a().m(this.friendUin, this.b.serverPath, this.b.uniseq);
  }
  
  void onSuccess()
  {
    if (this.s != null) {
      this.s.shutdown();
    }
    long l = (System.nanoTime() - this.mStartTime) / 1000000L;
    Object localObject;
    if (this.b.actionType == 0)
    {
      localObject = "streamptt.send";
      QLog.d((String)localObject, 2, "onSuccess elapsed:" + l + " uniseq:" + this.b.uniseq);
      doReport(true);
      this.app.removeObserver(this.e);
      if (this.b.actionType == 0) {
        QV(true);
      }
      if (this.b.actionType != 0) {
        break label172;
      }
      VR(1003);
      this.app.a().l(this.b.mUin, this.b.filePath, this.b.uniseq);
    }
    label172:
    do
    {
      return;
      localObject = "streamptt.recv";
      break;
      VR(2003);
      this.app.a().m(this.friendUin, this.b.serverPath, this.b.uniseq);
      localObject = (MessageForPtt)this.app.b().a(this.friendUin, 0, this.b.uniseq);
    } while ((localObject == null) || (this.a == null) || (!this.a.m((MessageForPtt)localObject)));
    this.a.b((MessageForPtt)localObject, 2);
  }
  
  public void start() {}
  
  public static class a
  {
    public String serverPath;
    public byte type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aojs
 * JD-Core Version:    0.7.0.1
 */