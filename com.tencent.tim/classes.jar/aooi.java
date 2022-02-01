import QQService.StreamData;
import QQService.StreamInfo;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController.1;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class aooi
  extends aojm
{
  public static HashSet<Integer> bC = new HashSet();
  ArrayList<String> Bt = new ArrayList();
  ArrayList<String> Bu = new ArrayList();
  public ConcurrentHashMap<String, byte[]> iI = new ConcurrentHashMap(20);
  public QQAppInterface mApp;
  
  static
  {
    bC.add(Integer.valueOf(8));
    bC.add(Integer.valueOf(64));
    bC.add(Integer.valueOf(22));
    bC.add(Integer.valueOf(21));
    bC.add(Integer.valueOf(34));
    bC.add(Integer.valueOf(35));
    bC.add(Integer.valueOf(36));
    bC.add(Integer.valueOf(37));
    bC.add(Integer.valueOf(38));
    bC.add(Integer.valueOf(48));
    bC.add(Integer.valueOf(23));
    bC.add(Integer.valueOf(39));
    bC.add(Integer.valueOf(40));
    bC.add(Integer.valueOf(41));
    bC.add(Integer.valueOf(50));
    bC.add(Integer.valueOf(51));
    bC.add(Integer.valueOf(56));
  }
  
  public aooi(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.TransFileController", 2, "construct transfilecontroller:" + this);
    }
    this.mApp = paramQQAppInterface;
  }
  
  public static String a(aool paramaool)
  {
    return o(paramaool.mMd5, paramaool.cmo, paramaool.mFileType);
  }
  
  private void a(aool paramaool, aojn paramaojn)
  {
    try
    {
      if (paramaool.a.mResult == -2)
      {
        aonc.a(paramaool.mUinType, paramaool.cNy, paramaool.mFileType, String.valueOf(paramaool.mUniseq), "callwait", "");
        paramaojn.wait();
        aonc.a(paramaool.mUinType, paramaool.cNy, paramaool.mFileType, String.valueOf(paramaool.mUniseq), "waitfin", "");
      }
      return;
    }
    catch (InterruptedException paramaool)
    {
      paramaool.printStackTrace();
    }
  }
  
  private void a(aool paramaool, aojn paramaojn, String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = "sync ";
      if (paramBoolean) {
        this.mApp.a().NR(paramString);
      }
      ??? = (aqoi)this.cz.get(paramString);
      if (??? == null) {
        break label418;
      }
      if (!(??? instanceof aoji)) {}
    }
    label418:
    do
    {
      do
      {
        long l;
        aool localaool;
        do
        {
          synchronized ((aoji)???)
          {
            l = ((aoji)???).hh();
            localaool = ((aoji)???).a();
            aonc.a(paramaool.mUinType, paramaool.cNy, paramaool.mFileType, String.valueOf(paramaool.mUniseq), str + "startDownloadProcessor", "status:" + l + ",key:" + paramString);
            if ((l == -1L) || (l == 2002L) || (l == 2001L))
            {
              paramaool.a = localaool.a;
              if (paramaool.b != null) {
                ((aoji)???).Bl.add(paramaool.b);
              }
              if (paramBoolean) {
                a(paramaool, (aojn)???);
              }
            }
            for (;;)
            {
              return;
              str = "aync ";
              break;
              if ((l == 2004L) || (l == 2005L))
              {
                if (paramaojn == null) {
                  continue;
                }
                this.cz.put(paramString, paramaojn);
                paramaojn.setKey(paramString);
                if (paramaojn.KH() != 0) {
                  continue;
                }
                akxo.a(this.mApp, paramaool);
                paramaojn.start();
                if (!paramBoolean) {
                  continue;
                }
                try
                {
                  aonc.a(paramaool.mUinType, paramaool.cNy, paramaool.mFileType, String.valueOf(paramaool.mUniseq), "callwait", "");
                  ???.wait();
                }
                catch (InterruptedException paramaool)
                {
                  paramaool.printStackTrace();
                }
              }
            }
          }
        } while (l != 2003L);
        paramaool.a = localaool.a;
        if (paramaool.b != null)
        {
          paramaojn = new akxb.a();
          paramaojn.result = 0;
          paramaojn.bUF = paramaool.clR;
          paramaojn.md5 = paramaool.mMd5;
          paramaojn.dpA = paramaool.mFileType;
          paramaojn.dpB = paramaool.dpB;
          paramaool.b.a(paramaojn);
        }
        return;
        aonc.a(paramaool.mUinType, paramaool.cNy, paramaool.mFileType, String.valueOf(paramaool.mUniseq), str + "startDownloadProcessor", "firs time ,key:" + paramString);
        this.cz.put(paramString, paramaojn);
        paramaojn.setKey(paramString);
      } while (paramaojn.KH() != 0);
      akxo.a(this.mApp, paramaool);
      paramaojn.start();
    } while (!paramBoolean);
    try
    {
      a(paramaool, paramaojn);
      return;
    }
    finally {}
  }
  
  private boolean a(aqoi paramaqoi)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramaqoi != null) {
      if (!(paramaqoi instanceof aojv))
      {
        bool1 = bool2;
        if (!(paramaqoi instanceof aokv)) {}
      }
      else
      {
        paramaqoi = (aojn)paramaqoi;
        bool1 = bool2;
        if (paramaqoi.hh() != 1003L)
        {
          bool1 = bool2;
          if (paramaqoi.hi() != 1003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean b(aqoi paramaqoi)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramaqoi != null)
    {
      bool1 = bool2;
      if ((paramaqoi instanceof StructLongMessageDownloadProcessor))
      {
        bool1 = bool2;
        if (((aojn)paramaqoi).hh() != 2003L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean c(aqoi paramaqoi)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramaqoi != null) {
      if (!(paramaqoi instanceof aolq))
      {
        bool1 = bool2;
        if (!(paramaqoi instanceof aolp)) {}
      }
      else
      {
        paramaqoi = (aojn)paramaqoi;
        bool1 = bool2;
        if (paramaqoi.hh() != 1003L)
        {
          bool1 = bool2;
          if (paramaqoi.hi() != 2003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean d(aqoi paramaqoi)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramaqoi != null)
    {
      bool1 = bool2;
      if ((paramaqoi instanceof aomr))
      {
        bool1 = bool2;
        if (((aojn)paramaqoi).hh() != 1003L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static String o(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (!"null".equals(paramString1)) && (!"".equals(paramString1))) {
      return paramString1 + "_" + paramInt;
    }
    return paramString2 + "_" + paramInt;
  }
  
  public boolean A(String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        paramString = paramString + paramLong;
        if (this.cz.containsKey(paramString))
        {
          paramString = (aqoi)this.cz.get(paramString);
          if (((paramString instanceof aonu)) && (((aonu)paramString).isPause()))
          {
            ((aonu)paramString).EN();
            bool = true;
            return bool;
          }
        }
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
      boolean bool = false;
    }
  }
  
  public boolean B(String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        paramString = paramString + paramLong;
        if (this.cz.containsKey(paramString))
        {
          aqoi localaqoi = (aqoi)this.cz.get(paramString);
          if (localaqoi != null)
          {
            if ((localaqoi instanceof aonu)) {
              ((aonu)localaqoi).pause();
            }
          }
          else
          {
            this.cz.remove(paramString);
            bool = true;
            return bool;
          }
          if (!(localaqoi instanceof aonn)) {
            continue;
          }
          ((aonn)localaqoi).pause();
          continue;
        }
        boolean bool = false;
      }
      finally {}
    }
  }
  
  public boolean C(String paramString, long paramLong)
  {
    paramString = paramString + paramLong;
    if (this.cz.containsKey(paramString))
    {
      aqoi localaqoi = (aqoi)this.cz.get(paramString);
      if ((localaqoi instanceof aonk))
      {
        ((aonk)localaqoi).pause();
        this.cz.remove(paramString);
        return true;
      }
    }
    return false;
  }
  
  public void Sd(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.cz.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (aqoi)((Map.Entry)localIterator.next()).getValue();
        if (a((aqoi)localObject))
        {
          localObject = (aojn)localObject;
          if ((paramString.equals(((aojn)localObject).h.mPeerUin)) && (((aojn)localObject).mIsPause))
          {
            ((aojn)localObject).EN();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "resume pic:" + ((aojn)localObject).h.mUniseq);
            }
          }
        }
      }
    }
  }
  
  public aojn a(aool paramaool)
  {
    if (paramaool == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.richmedia.TransFileController", 2, paramaool.toString());
    }
    if (paramaool.mFileType == 131078)
    {
      if (paramaool.cNy) {
        return new aoma(this, paramaool);
      }
      return new aolz(this, paramaool);
    }
    if (paramaool.mFileType == 262153)
    {
      if (paramaool.cNy) {
        return new aone(this, paramaool);
      }
      return new aond(this, paramaool);
    }
    if (paramaool.mFileType == 327689) {
      return new aolt(this, paramaool);
    }
    if (paramaool.mFileType == 327696) {
      return new aomr(this, paramaool);
    }
    if (paramaool.mFileType == 66) {
      return new aoni(this, paramaool);
    }
    if ((paramaool.mFileType == 52) && (paramaool.cNy)) {
      return new aokr(this, paramaool);
    }
    if (paramaool.mUinType == 1026) {
      return b(paramaool);
    }
    if ((paramaool.mUinType == 1) || (paramaool.mUinType == 3000)) {
      return c(paramaool);
    }
    return f(paramaool);
  }
  
  public aoom a(aool paramaool)
  {
    paramaool.cNy = false;
    paramaool.a = new aoom();
    Object localObject;
    if (this.mWorking.get()) {
      if (paramaool.mFileType == 131076)
      {
        localObject = new aooq(this, paramaool);
        a(paramaool, (aojn)localObject, a(paramaool), true);
      }
    }
    for (;;)
    {
      return paramaool.a;
      if ((paramaool.mUinType == 1) || (paramaool.mUinType == 3000))
      {
        localObject = new aoku(this, paramaool);
        break;
      }
      localObject = new aoju(this, paramaool);
      break;
      localObject = paramaool.a;
      ((aoom)localObject).mResult = -1;
      ((aoom)localObject).aqr = 9366L;
      ((aoom)localObject).clO = "transfilecontroller closed";
    }
  }
  
  public aqoi a(String paramString)
  {
    if (!this.cz.isEmpty()) {
      return (aqoi)this.cz.get(paramString);
    }
    return null;
  }
  
  public aqoi a(String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1, paramLong);
  }
  
  public void a(long paramLong1, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong2, int paramInt2)
  {
    String str = paramString2 + paramLong1;
    if (this.cz.containsKey(str))
    {
      aqoi localaqoi = a(paramString2, paramLong1);
      if ((localaqoi instanceof aokp)) {
        ((aokp)localaqoi).stopListening();
      }
    }
    paramString1 = new aokp(paramLong1, paramString1, paramQQAppInterface, paramInt1, paramString2, paramString3, paramString4, paramString5, paramLong2, paramInt2);
    this.cz.put(str, paramString1);
  }
  
  public void a(StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2, long paramLong3, long paramLong4, ptt_reserve.ReserveStruct paramReserveStruct)
  {
    Object localObject2 = anqo.R(paramStreamInfo.iMsgId, 1);
    long l1 = paramStreamInfo.lFromUIN;
    long l2 = paramStreamInfo.lToUIN;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = aojs.a(String.valueOf(l2), null, 2, null);
      int i = aqft.ag(paramStreamInfo.pttFormat);
      localObject2 = MessageForPtt.getLocalFilePath(i, (String)localObject1);
      anqo.a(this.mApp, i, (String)localObject2, 1, paramStreamInfo.iMsgId);
      anqo.aV((String)localObject2, (short)paramStreamInfo.msgSeq);
      anqo.aW((String)localObject2, paramStreamInfo.random);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.richmedia.TransFileController", 2, "onReceiveStreamAction  key is:" + (String)localObject2 + ",msgSeq is:" + paramStreamInfo.msgSeq + ",random is:" + paramStreamInfo.random);
        localObject1 = localObject2;
      }
    }
    localObject2 = new Bundle();
    im_msg_body.GeneralFlags localGeneralFlags = new im_msg_body.GeneralFlags();
    try
    {
      localGeneralFlags.mergeFrom(paramReserveStruct.bytes_general_flags.get().toByteArray());
      ((Bundle)localObject2).putInt("DiyTextId", localGeneralFlags.uint32_bubble_diy_text_id.get());
      ((Bundle)localObject2).putInt("DiyPendantId", (int)paramLong4);
      a(String.valueOf(l1), (String)localObject1, -1000L, paramStreamInfo, paramStreamData, paramLong1, paramLong2, paramLong3, (Bundle)localObject2);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramReserveStruct)
    {
      for (;;)
      {
        QLog.e("Q.richmedia.TransFileController", 1, "pb merge failed.", paramReserveStruct);
      }
    }
  }
  
  public void a(String paramString, aooi.b paramb)
  {
    if (paramString == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      Iterator localIterator = this.cz.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (aqoi)((Map.Entry)localIterator.next()).getValue();
        if (a((aqoi)localObject))
        {
          localObject = (aojn)localObject;
          if ((paramString.equals(((aojn)localObject).h.mPeerUin)) && (((aojn)localObject).isPause()))
          {
            ((aojn)localObject).cancel();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((aojn)localObject).h.mUniseq);
            }
            if (((aojn)localObject).h.F != null) {
              localArrayList.add(((aojn)localObject).h.F);
            }
          }
        }
      }
    } while (paramb == null);
    paramb.bS(localArrayList);
  }
  
  public void a(String paramString, aqoi paramaqoi)
  {
    this.cz.put(paramString, paramaqoi);
  }
  
  public boolean a(aool paramaool)
  {
    try
    {
      boolean bool = super.a(paramaool);
      return bool;
    }
    finally
    {
      paramaool = finally;
      throw paramaool;
    }
  }
  
  public boolean a(aool paramaool, MessageRecord paramMessageRecord)
  {
    try
    {
      boolean bool = a(paramaool);
      return bool;
    }
    finally
    {
      paramaool = finally;
      throw paramaool;
    }
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong1, StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong2, long paramLong3, long paramLong4, Bundle paramBundle)
  {
    if (!this.cz.containsKey(paramString1 + paramString2 + paramLong1))
    {
      if (this.mApp != null)
      {
        aojs localaojs = new aojs(paramString1, paramString2, false, null, null, 2, -1, false, this, paramLong1);
        localaojs.setId(paramLong1);
        localaojs.b().filePath = paramString2;
        localaojs.setKey(paramString1 + paramString2 + paramLong1);
        this.cz.put(paramString1 + paramString2 + paramLong1, localaojs);
        localaojs.a(paramStreamInfo, paramStreamData, paramLong2, paramLong3, paramLong4, paramBundle);
        return true;
      }
      return false;
    }
    paramString1 = (aojs)a(paramString1 + paramString2 + paramLong1);
    if (paramString1 != null) {
      paramString1.a(paramStreamInfo, paramStreamData, paramLong2, paramLong3, paramLong4, paramBundle);
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong1, short paramShort, int paramInt1, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    if (!this.cz.containsKey(paramString1 + paramLong1))
    {
      if (this.mApp != null)
      {
        paramString2 = new aojs(paramString1, paramString2, true, null, null, 2, -1, false, this, paramLong1);
        paramString2.setId(paramLong1);
        paramString2.dVl();
        paramString2.setKey(paramString1 + paramLong1);
        this.cz.put(paramString1 + paramLong1, paramString2);
        paramString2.a(paramShort, false, paramInt1, paramInt2, paramLong2, paramBundle);
        return true;
      }
      return false;
    }
    paramString1 = (aojs)a(paramString1, paramString2, paramLong1);
    if (paramString1 != null) {
      paramString1.a(paramShort, false, paramInt1, paramInt2, paramLong2, paramBundle);
    }
    return false;
  }
  
  public boolean aAr()
  {
    Iterator localIterator = this.cz.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (aqoi)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof aojn))) {
        break label171;
      }
      localObject = (aojn)localObject;
      if ((!((aojn)localObject).cLY) || (((aojn)localObject).mIsPause)) {
        break label171;
      }
      ((aojn)localObject).pause();
      if (((aojn)localObject).getKey() != null) {
        this.Bt.add(((aojn)localObject).getKey());
      }
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoSend key:" + ((aojn)localObject).getKey());
      }
      bool = true;
    }
    label171:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoSend result:" + bool);
      }
      return bool;
    }
  }
  
  public boolean aAs()
  {
    Iterator localIterator = this.cz.entrySet().iterator();
    StringBuilder localStringBuilder = new StringBuilder();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (aqoi)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof aojn))) {
        break label211;
      }
      localObject = (aojn)localObject;
      if ((!((aojn)localObject).cLZ) || (((aojn)localObject).mIsPause)) {
        break label211;
      }
      ((aojn)localObject).pause();
      if (((aojn)localObject).getKey() != null) {
        this.Bt.add(((aojn)localObject).getKey());
      }
      localStringBuilder.append(((aojn)localObject).getKey());
      localStringBuilder.append(",");
      bool = true;
    }
    label211:
    for (;;)
    {
      break;
      if ((localStringBuilder.length() > 0) && (QLog.isColorLevel())) {
        QLog.d("short_video", 2, "pauseAllShortVideoReceive key:" + localStringBuilder);
      }
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoReceive result:" + bool);
      }
      return bool;
    }
  }
  
  public boolean aAt()
  {
    this.Bu.clear();
    Iterator localIterator = this.cz.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (aqoi)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof aojn))) {
        break label178;
      }
      localObject = (aojn)localObject;
      if ((!((aojn)localObject).cLX) || (((aojn)localObject).mIsPause)) {
        break label178;
      }
      ((aojn)localObject).pause();
      if (((aojn)localObject).getKey() != null) {
        this.Bu.add(((aojn)localObject).getKey());
      }
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "pauseAllRawSend key:" + ((aojn)localObject).getKey());
      }
      bool = true;
    }
    label178:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "pauseAllRawSend result:" + bool);
      }
      return bool;
    }
  }
  
  public void aZ(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong == 0L)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.cz.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (aqoi)((Map.Entry)localIterator.next()).getValue();
        if (a((aqoi)localObject))
        {
          localObject = (aojn)localObject;
          if ((paramString.equals(((aojn)localObject).h.mPeerUin)) && (paramLong == ((aojn)localObject).h.mUniseq))
          {
            ((aojn)localObject).cancel();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((aojn)localObject).h.mUniseq);
            }
          }
        }
      }
    }
  }
  
  public void ab(ChatMessage paramChatMessage)
  {
    Object localObject = this.mApp;
    if ((paramChatMessage instanceof MessageForPtt)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!(paramChatMessage instanceof MessageForShortVideo)) {
              break;
            }
            paramChatMessage = (MessageForShortVideo)paramChatMessage;
            ((QQAppInterface)localObject).a().C(paramChatMessage.frienduin, paramChatMessage.uniseq);
          } while (paramChatMessage.busiType != 0);
          localObject = (ajlu)((QQAppInterface)localObject).getManager(324);
        } while (!((ajlu)localObject).S(paramChatMessage));
        ((ajlu)localObject).b(paramChatMessage, 0L, 0, 256);
        return;
      } while (!(paramChatMessage instanceof MessageForPic));
      paramChatMessage = (MessageForPic)paramChatMessage;
      d(paramChatMessage, 131075);
      d(paramChatMessage, 1);
      d(paramChatMessage, 131075);
      localObject = (ajlu)((QQAppInterface)localObject).getManager(324);
    } while (!((ajlu)localObject).S(paramChatMessage));
    ((ajlu)localObject).e(paramChatMessage, 0L, 0, 24);
  }
  
  public int b(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if ((!this.cz.isEmpty()) && (this.cz.containsKey(paramString1)))
    {
      paramString1 = (aqoi)this.cz.get(paramString1);
      if ((paramString1 instanceof aojn)) {
        return ((aojn)paramString1).getProgress();
      }
    }
    return 0;
  }
  
  public aojn b(aool paramaool)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PttShow", 2, "getProcessor UIN_TYPE_HOTCHAT_TOPIC  isUp = " + paramaool.cNy);
    }
    if (paramaool.cNy) {
      return new aokv(this, paramaool);
    }
    if (paramaool.mFileType == 2) {
      return new GroupPttDownloadProcessor(this, paramaool);
    }
    return null;
  }
  
  public aoom b(aool paramaool)
  {
    paramaool.cNy = false;
    paramaool.a = new aoom();
    if (this.mWorking.get()) {}
    for (;;)
    {
      synchronized (this.mWorking)
      {
        Object localObject1;
        if ((!this.mWorking.get()) || (this.mApp == null))
        {
          localObject1 = paramaool.a;
          ((aoom)localObject1).mResult = -1;
          ((aoom)localObject1).aqr = 9366L;
          ((aoom)localObject1).clO = "transfilecontroller closed";
          paramaool = paramaool.a;
          return paramaool;
        }
        try
        {
          if (paramaool.mFileType == 131076)
          {
            localObject1 = new aooq(this, paramaool);
            a(paramaool, (aojn)localObject1, a(paramaool), false);
            return paramaool.a;
          }
          if ((paramaool.mUinType == 1) || (paramaool.mUinType == 3000))
          {
            localObject1 = new aoku(this, paramaool);
            continue;
            paramaool = finally;
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          localObject2 = paramaool.a;
          ((aoom)localObject2).mResult = -1;
          ((aoom)localObject2).aqr = 9366L;
          ((aoom)localObject2).clO = "transfilecontroller closed";
          paramaool = paramaool.a;
          return paramaool;
        }
      }
      Object localObject2 = new aoju(this, paramaool);
      continue;
      localObject2 = paramaool.a;
      ((aoom)localObject2).mResult = -1;
      ((aoom)localObject2).aqr = 9366L;
      ((aoom)localObject2).clO = "transfilecontroller closed";
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent)
  {
    ThreadManager.postImmediately(new TransFileController.1(this, paramString, paramIntent, paramQQAppInterface), null, true);
  }
  
  public boolean bL(String paramString1, String paramString2)
  {
    return qk(paramString1 + paramString2);
  }
  
  public void ba(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong == 0L)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.cz.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (aqoi)((Map.Entry)localIterator.next()).getValue();
        if (c((aqoi)localObject))
        {
          localObject = (aojn)localObject;
          if ((paramString.equals(((aojn)localObject).h.mPeerUin)) && (paramLong == ((aojn)localObject).h.mUniseq))
          {
            ((aojn)localObject).cancel();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel JSPTT:" + ((aojn)localObject).h.mUniseq);
            }
          }
        }
      }
    }
  }
  
  public void bb(String paramString, long paramLong)
  {
    Iterator localIterator = this.cz.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (aqoi)((Map.Entry)localIterator.next()).getValue();
      if (b((aqoi)localObject))
      {
        ThreadManager.getSubThreadHandler().removeCallbacks((StructLongMessageDownloadProcessor)localObject);
        localObject = (aojn)localObject;
        if ((paramString.equals(((aojn)localObject).h.mPeerUin)) && (paramLong == ((aojn)localObject).h.mUniseq))
        {
          ((aojn)localObject).cancel();
          if (QLog.isColorLevel()) {
            QLog.d("cancelpic", 2, "cancel PALongMsg:" + ((aojn)localObject).h.mUniseq);
          }
        }
      }
    }
  }
  
  public void bc(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong == 0L)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.cz.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (aqoi)((Map.Entry)localIterator.next()).getValue();
        if (d((aqoi)localObject))
        {
          localObject = (aojn)localObject;
          if ((paramString.equals(((aojn)localObject).h.mPeerUin)) && (paramLong == ((aojn)localObject).h.mUniseq))
          {
            ((aojn)localObject).cancel();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "PttSliceUploadProcessor cancelVoiceTextTask:" + ((aojn)localObject).h.mUniseq);
            }
          }
        }
      }
    }
  }
  
  public int c(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if ((!this.cz.isEmpty()) && (this.cz.containsKey(paramString1)))
    {
      paramString1 = (aqoi)this.cz.get(paramString1);
      if ((paramString1 instanceof aojn)) {
        return (int)((aojn)paramString1).hh();
      }
    }
    return -1;
  }
  
  public aojn c(aool paramaool)
  {
    if (paramaool.cNy)
    {
      if ((paramaool.mFileType == 6) || (paramaool.mFileType == 17) || (paramaool.mFileType == 9)) {
        return new aonu(this, paramaool);
      }
      if (paramaool.mFileType == 20) {
        return new aonn(this, paramaool);
      }
      if (paramaool.mFileType == 55) {
        return new aooo(this, paramaool);
      }
      if (paramaool.mBusiType == 1045) {
        return new aold(this, paramaool);
      }
      if (paramaool.mFileType == 2) {
        return new aokz(this, paramaool);
      }
      return new aokv(this, paramaool);
    }
    if (paramaool.mFileType == 2) {
      return new GroupPttDownloadProcessor(this, paramaool);
    }
    if ((paramaool.mFileType == 1) || (paramaool.mFileType == 65537) || (paramaool.mFileType == 131075)) {
      return new aoku(this, paramaool);
    }
    if ((paramaool.mFileType == 6) || (paramaool.mFileType == 7) || (paramaool.mFileType == 17) || (paramaool.mFileType == 18) || (paramaool.mFileType == 9) || (paramaool.mFileType == 16)) {
      return new aonk(this, paramaool);
    }
    return null;
  }
  
  public boolean cL(long paramLong)
  {
    Iterator localIterator = this.cz.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (aqoi)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof aojr))) {
        break label175;
      }
      localObject = (aojr)localObject;
      if ((((aojr)localObject).h == null) || (!((aojr)localObject).h.cND)) {
        break label175;
      }
      ((aojr)localObject).apy = paramLong;
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicReport", 2, "initAllPSProcessorEnterAioTime ,Processor:" + localObject + ",time = " + paramLong);
      }
      bool = true;
    }
    label175:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicReport", 2, "initAllPSProcessorEnterAioTime result:" + bool);
      }
      return bool;
    }
  }
  
  public aojn d(aool paramaool)
  {
    if (paramaool.mFileType == 2) {
      return new aojz(this, paramaool);
    }
    if (paramaool.mFileType == 32) {
      return new aolq(this, paramaool);
    }
    if ((paramaool.mFileType == 6) || (paramaool.mFileType == 17) || (paramaool.mFileType == 9)) {
      return new aonu(this, paramaool);
    }
    if (bC.contains(Integer.valueOf(paramaool.mFileType))) {
      return new aomd(this, paramaool);
    }
    if (paramaool.mFileType == 20) {
      return new aonn(this, paramaool);
    }
    if (paramaool.mFileType == 24) {
      return new aojg(this, paramaool);
    }
    if ((paramaool.mFileType == 196609) || (paramaool.mFileType == 196610) || (paramaool.mFileType == 327681)) {
      return new aoob(this, paramaool);
    }
    if (paramaool.mBusiType == 1045) {
      return new aokd(this, paramaool);
    }
    return new aojv(this, paramaool);
  }
  
  public void d(MessageForPic paramMessageForPic, int paramInt)
  {
    paramMessageForPic = a(o(paramMessageForPic.md5, paramMessageForPic.uuid, paramInt));
    if ((paramMessageForPic != null) && ((paramMessageForPic instanceof aojn))) {
      ((aojn)paramMessageForPic).cancel();
    }
  }
  
  public void dWq() {}
  
  public void dWr()
  {
    if (QLog.isColorLevel()) {
      QLog.d("short_video", 2, "resumeLastShortVideoSend keys size:" + this.Bt.size());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.Bt.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = a((String)localIterator.next());
      if ((localObject != null) && ((localObject instanceof aojn)))
      {
        localObject = (aojn)localObject;
        if (((aojn)localObject).mIsPause)
        {
          ((aojn)localObject).EN();
          localStringBuilder.append(((aojn)localObject).getKey());
          localStringBuilder.append(",");
        }
      }
    }
    if ((localStringBuilder.length() > 0) && (QLog.isColorLevel())) {
      QLog.d("short_video", 2, "resumeLastShortVideoSend , key: " + localStringBuilder);
    }
    this.Bt.clear();
  }
  
  public void dWs()
  {
    if (QLog.isColorLevel()) {
      QLog.d("raw_photo", 2, "resumeLastRawSend keys size:" + this.Bu.size());
    }
    Iterator localIterator = this.Bu.iterator();
    while (localIterator.hasNext()) {
      qk((String)localIterator.next());
    }
  }
  
  public void destroy()
  {
    long l;
    if (this.mWorking.get()) {
      l = System.currentTimeMillis();
    }
    synchronized (this.mWorking)
    {
      this.mWorking.set(false);
      this.mApp.getHttpCommunicatort().close();
      dUY();
      this.mApp = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.TransFileController", 2, "destroy transfilecontroller:" + this + " elapsed:" + (System.currentTimeMillis() - l));
      }
      return;
    }
  }
  
  public aojn e(aool paramaool)
  {
    if (paramaool.mFileType == 2) {
      return new C2CPttDownloadProcessor(this, paramaool);
    }
    if (paramaool.mFileType == 32) {
      return new aolp(this, paramaool);
    }
    if (paramaool.mFileType == 33) {
      return new aomk(this, paramaool);
    }
    if ((paramaool.mFileType == 6) || (paramaool.mFileType == 7) || (paramaool.mFileType == 17) || (paramaool.mFileType == 18) || (paramaool.mFileType == 9) || (paramaool.mFileType == 16)) {
      return new aonk(this, paramaool);
    }
    if ((paramaool.mFileType == 1) || (paramaool.mFileType == 65537) || (paramaool.mFileType == 131075)) {
      return new aoju(this, paramaool);
    }
    if (paramaool.mFileType == 131079) {
      return new StructLongMessageDownloadProcessor(this, paramaool);
    }
    return null;
  }
  
  public aojn f(aool paramaool)
  {
    if (paramaool.cNy) {
      return d(paramaool);
    }
    return e(paramaool);
  }
  
  public void gf(String paramString, int paramInt)
  {
    Iterator localIterator = a(this.cz).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      aqoi localaqoi = (aqoi)this.cz.get(str);
      switch (paramInt)
      {
      case 1: 
      case 2: 
      default: 
        break;
      case 0: 
        if (((localaqoi instanceof aojs)) && (paramString.equals(((aojs)localaqoi).b.mUin)))
        {
          ((aojn)localaqoi).stop();
          this.cz.remove(str);
        }
        break;
      }
    }
  }
  
  public boolean k(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if (!this.cz.isEmpty()) {
      return this.cz.containsKey(paramString1);
    }
    return false;
  }
  
  public boolean l(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if (this.cz.containsKey(paramString1))
    {
      paramString2 = (aojs)this.cz.get(paramString1);
      if (paramString2 != null) {
        paramString2.stop();
      }
      this.cz.remove(paramString1);
      return true;
    }
    return false;
  }
  
  public boolean m(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramString2 + paramLong;
    if (this.cz.containsKey(paramString1))
    {
      paramString2 = (aojs)this.cz.get(paramString1);
      if (paramString2 != null) {
        paramString2.stop();
      }
      this.cz.remove(paramString1);
      return true;
    }
    return false;
  }
  
  public boolean qk(String paramString)
  {
    paramString = a(paramString);
    if ((paramString != null) && ((paramString instanceof aojn)))
    {
      paramString = (aojn)paramString;
      if ((paramString.cLX) && (paramString.mIsPause))
      {
        paramString.EN();
        if (QLog.isColorLevel()) {
          QLog.d("raw_photo", 2, "resumeRawSend ,key:" + paramString.getKey());
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean ql(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Iterator localIterator = this.cz.entrySet().iterator();
    boolean bool1;
    for (boolean bool2 = false; localIterator.hasNext(); bool2 = bool1)
    {
      Object localObject = (aqoi)((Map.Entry)localIterator.next()).getValue();
      bool1 = bool2;
      if (a((aqoi)localObject))
      {
        localObject = (aojn)localObject;
        bool1 = bool2;
        if (paramString.equals(((aojn)localObject).h.mPeerUin))
        {
          bool1 = bool2;
          if (!((aojn)localObject).mIsPause)
          {
            ((aojn)localObject).pause();
            bool2 = true;
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("cancelpic", 2, "pause pic:" + ((aojn)localObject).h.mUniseq);
              bool1 = bool2;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public boolean qm(String paramString)
  {
    if (paramString == null) {}
    label90:
    label91:
    for (;;)
    {
      return false;
      Iterator localIterator = this.cz.entrySet().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        aqoi localaqoi = (aqoi)((Map.Entry)localIterator.next()).getValue();
        if ((!a(localaqoi)) || (!paramString.equals(((aojn)localaqoi).h.mPeerUin))) {
          break label90;
        }
        i += 1;
      }
      for (;;)
      {
        break;
        if (i <= 1) {
          break label91;
        }
        return true;
      }
    }
  }
  
  public String y(String paramString, long paramLong)
  {
    return paramString + paramLong;
  }
  
  /* Error */
  public boolean y(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 70	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   9: aload_1
    //   10: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: lload_2
    //   14: invokevirtual 193	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: astore_1
    //   21: aload_0
    //   22: getfield 171	aooi:cz	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_1
    //   26: invokevirtual 303	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   29: ifeq +31 -> 60
    //   32: aload_0
    //   33: getfield 171	aooi:cz	Ljava/util/concurrent/ConcurrentHashMap;
    //   36: aload_1
    //   37: invokevirtual 175	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 324	aonk
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 325	aonk:pause	()V
    //   52: iconst_1
    //   53: istore 4
    //   55: aload_0
    //   56: monitorexit
    //   57: iload 4
    //   59: ireturn
    //   60: iconst_0
    //   61: istore 4
    //   63: goto -8 -> 55
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	aooi
    //   0	71	1	paramString	String
    //   0	71	2	paramLong	long
    //   53	9	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	44	66	finally
    //   48	52	66	finally
  }
  
  /* Error */
  public boolean z(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore 4
    //   5: new 70	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   12: aload_1
    //   13: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: lload_2
    //   17: invokevirtual 193	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: astore_1
    //   24: aload_0
    //   25: getfield 171	aooi:cz	Ljava/util/concurrent/ConcurrentHashMap;
    //   28: aload_1
    //   29: invokevirtual 303	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   32: ifeq +36 -> 68
    //   35: aload_0
    //   36: getfield 171	aooi:cz	Ljava/util/concurrent/ConcurrentHashMap;
    //   39: aload_1
    //   40: invokevirtual 175	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 177	aqoi
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +17 -> 65
    //   51: aload_1
    //   52: instanceof 305
    //   55: ifeq +18 -> 73
    //   58: aload_1
    //   59: checkcast 305	aonu
    //   62: invokevirtual 315	aonu:pause	()V
    //   65: iconst_1
    //   66: istore 4
    //   68: aload_0
    //   69: monitorexit
    //   70: iload 4
    //   72: ireturn
    //   73: aload_1
    //   74: instanceof 320
    //   77: ifeq -12 -> 65
    //   80: aload_1
    //   81: checkcast 320	aonn
    //   84: invokevirtual 321	aonn:pause	()V
    //   87: goto -22 -> 65
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	aooi
    //   0	95	1	paramString	String
    //   0	95	2	paramLong	long
    //   3	68	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	24	90	finally
    //   24	47	90	finally
    //   51	65	90	finally
    //   73	87	90	finally
  }
  
  public static class a
  {
    public int errCode = -99999;
    public String errDesc = "unkown error";
  }
  
  public static abstract interface b
  {
    public abstract void bS(ArrayList<MessageRecord> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aooi
 * JD-Core Version:    0.7.0.1
 */