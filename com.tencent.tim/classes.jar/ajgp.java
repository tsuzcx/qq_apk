import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupJniProxy;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.1;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.2;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.3;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.4;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ajgp
{
  private static ajgp b;
  public MsgBackupNotifier a;
  private long aco;
  public long acp;
  public MsgBackupJniProxy b;
  protected String bRi;
  private ajea c;
  public MsgBackupEndPoint c;
  protected boolean cnK;
  private boolean con;
  private boolean coo;
  private boolean cop;
  private boolean coq;
  public MsgBackupEndPoint d;
  public int dah;
  public MsgBackupEndPoint e;
  public MsgBackupEndPoint f;
  private long lastProgressTime;
  private final Object mLock = new Object();
  
  private void Mx(String paramString)
  {
    try
    {
      paramString = new JSONArray(paramString);
      if (paramString.length() == 1)
      {
        paramString = (JSONObject)paramString.get(0);
        if ("exit".equals(paramString.optString("cmd")))
        {
          paramString = paramString.optString("sig");
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "-------------------exit-------------------");
          }
          if ((TextUtils.equals(paramString, ajdt.a().xj())) && (this.jdField_c_of_type_Ajea != null)) {
            this.jdField_c_of_type_Ajea.exit(true);
          }
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "MBR_UDP_CMD_EXIT parse json error!", paramString);
    }
  }
  
  private void My(String arg1)
  {
    int j = 0;
    Object localObject1;
    int i;
    try
    {
      localObject1 = ajee.a().fZ;
      ??? = new JSONArray(???);
      if (???.length() < 1) {
        break label251;
      }
      i = 0;
      if (i >= ???.length()) {
        break label251;
      }
      Object localObject3 = (JSONObject)???.get(i);
      ((JSONObject)localObject3).optString("cmd");
      String str = ((JSONObject)localObject3).optString("chatUin");
      int k = ((JSONObject)localObject3).optInt("chatType");
      localObject3 = ajgv.aq(str, k);
      ajew localajew = (ajew)((ConcurrentHashMap)localObject1).get(localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "client notify this session has received success! keyFromUin = " + (String)localObject3 + ", mMList = " + localObject1);
      }
      if (localajew != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "udp 通知 此会话接受完成 chatUin = " + str + ", uinType = " + ajgv.fk(k));
        }
        localajew.isCompleted = true;
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "client notify this session has received success! chatUin = " + str + ", chatType = " + k);
      }
    }
    catch (JSONException ???)
    {
      QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "MBR_UDP_CMD_SYNC_RECV_DONE parse json error!", ???);
    }
    label250:
    return;
    label345:
    for (;;)
    {
      label251:
      synchronized (this.mLock)
      {
        localObject1 = ((ConcurrentHashMap)localObject1).values().iterator();
        i = j;
        if (((Iterator)localObject1).hasNext())
        {
          if (((ajew)((Iterator)localObject1).next()).isCompleted)
          {
            i += 1;
            break label345;
          }
        }
        else
        {
          if (this.jdField_c_of_type_Ajea == null) {
            break label250;
          }
          this.jdField_c_of_type_Ajea.iC(i, ajee.dio);
          return;
        }
      }
      break label345;
      i += 1;
      break;
    }
  }
  
  private void Mz(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        ConcurrentHashMap localConcurrentHashMap = ajee.a().ga;
        paramString = new JSONArray(paramString);
        if (paramString.length() >= 1)
        {
          i = 0;
          if (i < paramString.length())
          {
            Object localObject = (JSONObject)paramString.get(i);
            String str = ((JSONObject)localObject).optString("cmd");
            if ("chat_list_count".equals(str))
            {
              ajee.dio = ((JSONObject)localObject).optInt("listCount");
              ajgt.dxs();
              ajgt.a.acq = ajee.dio;
            }
            if ("chat_ready".equals(str))
            {
              str = ((JSONObject)localObject).optString("chatUin");
              int j = ((JSONObject)localObject).optInt("chatType");
              long l = ((JSONObject)localObject).optLong("dbSize");
              localObject = new ajew();
              ((ajew)localObject).isCompleted = false;
              ((ajew)localObject).uY = false;
              ((ajew)localObject).uin = str;
              ((ajew)localObject).uinType = ajgv.fk(j);
              ((ajew)localObject).dbSize = l;
              str = ajgv.aq(((ajew)localObject).uin, j);
              if (localConcurrentHashMap.get(str) == null) {
                localConcurrentHashMap.put(str, localObject);
              }
            }
          }
          else
          {
            kq(3);
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "MBR_UDP_CMD_SYNC_RECV_DONE parse json error!", paramString);
        return;
      }
      i += 1;
    }
  }
  
  private int a(ConcurrentHashMap<String, ajew> paramConcurrentHashMap)
  {
    paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
    int i = 0;
    if (paramConcurrentHashMap.hasNext())
    {
      if (!((ajew)paramConcurrentHashMap.next()).isCompleted) {
        break label45;
      }
      i += 1;
    }
    label45:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private MsgBackupJniProxy a(Context paramContext)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy == null) {
      this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy = new MsgBackupJniProxy(paramContext);
    }
    return this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "recvMessageUdp udpdetected = " + this.coo + ", ipFrom = " + paramInt1 + ", port = " + paramInt2 + ", cmd = " + paramInt3 + ", cookie = " + paramLong + ", data = " + paramString);
    }
    if (paramInt3 == 256) {}
    do
    {
      return;
      if (paramInt3 == 257)
      {
        Mz(paramString);
        return;
      }
      if (paramInt3 == 258)
      {
        My(paramString);
        return;
      }
    } while (paramInt3 != 259);
    Mx(paramString);
  }
  
  private void a(long paramLong, int paramInt, ajex paramajex, ConcurrentHashMap<String, ajew> paramConcurrentHashMap, ajew paramajew, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap1)
  {
    if (paramajex.cnR)
    {
      ajgt.dxs();
      Object localObject = ajgt.a;
      ((ajgs)localObject).acC += 1L;
      localObject = ajgt.a;
      ((ajgs)localObject).acG += 1L;
      localObject = new ajgs.a();
      ((ajgs.a)localObject).fileType = 1;
      ((ajgs.a)localObject).diY = 0;
      ((ajgs.a)localObject).errorCode = paramInt;
      ajgt.a.xI.add(localObject);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "dbMList receivedCompleted  called not success, so again task = " + paramajex);
      }
      if ((!TextUtils.isEmpty(paramajex.path)) && (!TextUtils.isEmpty(paramajex.url))) {
        a(paramLong, paramajex, paramConcurrentHashMap, paramajew, paramConcurrentHashMap1);
      }
    }
  }
  
  private void a(long paramLong, int paramInt, String paramString, ajex paramajex, ConcurrentHashMap<String, ajew> paramConcurrentHashMap, ajew paramajew, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap1, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap2)
  {
    if (paramInt == 0)
    {
      a(paramLong, paramString, paramConcurrentHashMap1, paramConcurrentHashMap2);
      return;
    }
    a(paramLong, paramInt, paramajex, paramConcurrentHashMap, paramajew, paramConcurrentHashMap1);
  }
  
  private void a(long paramLong, int paramInt, ConcurrentHashMap<String, ajew> paramConcurrentHashMap, ajew paramajew, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap1, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap2)
  {
    ajex localajex = (ajex)paramConcurrentHashMap2.get(Long.valueOf(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "ResReq receivedCompleted  called  task = " + localajex + ", resMList.size = " + paramConcurrentHashMap2.size() + ", errCode = " + paramInt);
    }
    if (localajex != null) {
      a(paramLong, paramInt, paramConcurrentHashMap, paramajew, paramConcurrentHashMap1, paramConcurrentHashMap2, localajex);
    }
  }
  
  private void a(long paramLong, int paramInt, ConcurrentHashMap<String, ajew> paramConcurrentHashMap, ajew paramajew, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap1, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap2, ajex paramajex)
  {
    if (paramInt == 0)
    {
      b(paramLong, paramConcurrentHashMap, paramajew, paramConcurrentHashMap1, paramConcurrentHashMap2, paramajex);
      return;
    }
    b(paramLong, paramInt, paramConcurrentHashMap, paramajew, paramConcurrentHashMap1, paramConcurrentHashMap2, paramajex);
  }
  
  private void a(long paramLong, ajex paramajex, ConcurrentHashMap<String, ajew> paramConcurrentHashMap, ajew paramajew, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap1)
  {
    if ((paramajex.ao > 3) && (this.cop))
    {
      b(paramLong, paramajex, paramConcurrentHashMap, paramajew, paramConcurrentHashMap1);
      return;
    }
    if (aqz())
    {
      ajgv.o("recvFile panic error! dbMList receivedCompleted", new Object[0]);
      return;
    }
    paramajex.ao = ((short)(paramajex.ao + 1));
    this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.acp, paramLong, paramajex.url, paramajex.path, paramajex.cnS, paramajex.fileSize, false);
  }
  
  private void a(long paramLong1, String paramString1, int paramInt, long paramLong2, ConcurrentHashMap<String, ajew> paramConcurrentHashMap, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted, fid = " + paramLong1 + ", url = " + paramString1 + ", errCode = " + paramInt + ", context = " + paramLong2 + ", recvBuf = " + paramString2);
      }
      try
      {
        paramString1 = new JSONArray(paramString2);
        if (paramString1.length() > 0)
        {
          paramString2 = (JSONObject)paramString1.get(0);
          if ("chat_list_count".equals(paramString2.optString("cmd")))
          {
            a(paramConcurrentHashMap, paramString1, paramString2);
            return;
          }
          a(paramConcurrentHashMap, paramString1);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted parse json error!", paramString1);
        return;
      }
      if ((paramConcurrentHashMap.size() < ajee.dio) || (ajee.dio <= 0))
      {
        ajgv.o("client cache is deal completedly! so get next session!", new Object[0]);
        QO(3);
      }
    }
  }
  
  private void a(long paramLong1, String paramString1, int paramInt1, String paramString2, byte[] paramArrayOfByte, int paramInt2, int paramInt3, long paramLong2)
  {
    if (ajgv.cow) {
      paramString1 = ajgv.c(paramString1, this.f.ipv4, this.f.port, this.bRi);
    }
    for (;;)
    {
      ConcurrentHashMap localConcurrentHashMap2 = ajee.a().ge;
      ajex localajex = (ajex)localConcurrentHashMap2.get(Long.valueOf(paramLong1));
      ConcurrentHashMap localConcurrentHashMap1 = ajee.a().ga;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted called! mfidMlist.size = " + localConcurrentHashMap2.size() + ", mClientCanRecvMList.size = " + localConcurrentHashMap1.size() + ", path = " + paramString2 + ",url = " + paramString1 + ", fid = " + paramLong1 + ",errorCode = " + paramInt1 + ", task = " + localajex + "，mFidMList " + localConcurrentHashMap2.toString() + ", MsgBackupManager.sessionCount = " + ajee.dio);
      }
      if (localajex != null) {
        if (paramInt1 == 0) {
          a(paramLong1, paramString1, paramInt1, paramString2, paramArrayOfByte, paramLong2, localConcurrentHashMap2, localConcurrentHashMap1);
        }
      }
      do
      {
        return;
        a(paramLong1, localConcurrentHashMap2, localajex);
        return;
        paramArrayOfByte = ajgv.aq(ajee.bQU, ajgv.cS(ajee.dip));
        paramString1 = (ajew)localConcurrentHashMap1.get(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted key = " + paramArrayOfByte + ", mClientCanRecvMList = " + localConcurrentHashMap1 + ", sessionInfo = " + paramString1 + ", errCode = " + paramInt1);
        }
      } while (paramString1 == null);
      paramArrayOfByte = paramString1.gg;
      localConcurrentHashMap2 = paramString1.gf;
      localajex = (ajex)paramArrayOfByte.get(Long.valueOf(paramLong1));
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted  dbMList task = " + localajex + ", dbMList = " + paramArrayOfByte.toString() + ". sessionInfo.hashcode = " + paramString1.hashCode());
      }
      if (localajex != null)
      {
        a(paramLong1, paramInt1, paramString2, localajex, localConcurrentHashMap1, paramString1, paramArrayOfByte, localConcurrentHashMap2);
        return;
      }
      a(paramLong1, paramInt1, localConcurrentHashMap1, paramString1, paramArrayOfByte, localConcurrentHashMap2);
      return;
    }
  }
  
  private void a(long paramLong1, String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte, long paramLong2, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap, ConcurrentHashMap<String, ajew> paramConcurrentHashMap1)
  {
    paramConcurrentHashMap.remove(Long.valueOf(paramLong1));
    if ((this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null) && (TextUtils.isEmpty(paramString2)))
    {
      if (aqz()) {
        ajgv.o("getRecvBuffer called operator is closed! please clear handler msg!........", new Object[0]);
      }
    }
    else {
      return;
    }
    a(paramLong1, paramString1, paramInt, paramLong2, paramConcurrentHashMap1, v(paramArrayOfByte));
  }
  
  private void a(long paramLong, String paramString, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached success, url = " + paramString);
    }
    if (aqz()) {
      ajgv.o("getres onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
    }
    Object localObject;
    do
    {
      return;
      localObject = ajgt.a;
      ((ajgs)localObject).acs += 1L;
      localObject = ajgt.a;
      ((ajgs)localObject).acv += 1L;
      paramString = ajgv.t(paramString);
      long l = Long.parseLong((String)paramString.get("fid"));
      localObject = (String)paramString.get("filepath");
      ajgv.o("res url parse fid = %d,filepath = %s", new Object[] { Long.valueOf(l), localObject });
      paramString = (String)localObject;
      if (ajgv.cox) {
        paramString = Uri.decode((String)localObject);
      }
      ajgv.o("res url parse fid = %d,filepath = %s", new Object[] { Long.valueOf(l), paramString });
      localObject = new ajgs.b();
      ((ajgs.b)localObject).cot = false;
      ((ajgs.b)localObject).fileSize = 0L;
      ajee.a().gc.put(Long.valueOf(l), localObject);
      localObject = new ajex();
      ((ajex)localObject).ao = 0;
      ((ajex)localObject).cnR = true;
      ((ajex)localObject).path = ajgv.mb(paramString);
      ((ajex)localObject).sessionId = paramLong;
      paramConcurrentHashMap.put(Long.valueOf(l), localObject);
      this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.d(this.acp, paramLong, l, ((ajex)localObject).path);
    } while (!QLog.isColorLevel());
    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onHttpRequest, send res file, fileRes path = " + ((ajex)localObject).path + ", mFidMList.size = " + paramConcurrentHashMap.size());
  }
  
  private void a(long paramLong, String paramString, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap1, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap2)
  {
    paramConcurrentHashMap1.remove(Long.valueOf(paramLong));
    if (paramString.endsWith(".db"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted db success, path = " + paramString + ", dbMList.size = " + paramConcurrentHashMap1.size() + ", resMList.size = " + paramConcurrentHashMap2.size());
      }
      paramConcurrentHashMap1 = paramString.substring(paramString.lastIndexOf("/") + 1);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted db success, dbName = " + paramConcurrentHashMap1);
      }
      paramConcurrentHashMap1 = new ajek();
      paramConcurrentHashMap1.dir = 1;
      paramConcurrentHashMap1.bQV = paramString;
      ajee.a().e(paramConcurrentHashMap1);
    }
  }
  
  private void a(long paramLong1, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap, long paramLong2, String paramString)
  {
    ajex localajex = new ajex();
    localajex.ao = 0;
    localajex.cnR = false;
    localajex.msg = paramString;
    localajex.sessionId = paramLong1;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "sendPreparedSession  postinfo httpGetReached, client request server's already session, fid = " + paramLong2 + ", msg = " + paramString);
    }
    paramConcurrentHashMap.put(Long.valueOf(paramLong2), localajex);
    this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.e(this.acp, paramLong1, paramLong2, paramString);
  }
  
  private void a(long paramLong, ConcurrentHashMap<String, ajew> paramConcurrentHashMap, ajew arg4, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap1, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap2, ajex paramajex)
  {
    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "isTcpDetected = " + this.cop + ", isResRequestAllFinished" + ???.ds.get() + ", resReq fileTask receivedCompleted retry over time task = " + paramajex);
    paramConcurrentHashMap2.remove(Long.valueOf(paramLong));
    int i = paramConcurrentHashMap2.size();
    int j = paramConcurrentHashMap1.size();
    if ((i == 0) && (j == 0) && (???.ds.get()))
    {
      ???.isCompleted = true;
      a(???);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "last session transport completed!, uin = " + ajee.bQU + ", uintype = " + ajee.dip + ", task = " + paramajex);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "mclient will get db mClientCanRecvMList.size = " + paramConcurrentHashMap.size());
      }
    }
    label324:
    for (;;)
    {
      synchronized (this.mLock)
      {
        paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
        i = 0;
        if (paramConcurrentHashMap.hasNext())
        {
          if (!((ajew)paramConcurrentHashMap.next()).isCompleted) {
            break label324;
          }
          i += 1;
          break label324;
        }
        if (this.jdField_c_of_type_Ajea != null) {
          this.jdField_c_of_type_Ajea.iC(i, ajee.dio);
        }
        if (i == ajee.dio) {
          return;
        }
      }
      if (!kq(2))
      {
        ajgv.o("this session res has received! over time  so get next session!", new Object[0]);
        QO(3);
        return;
      }
    }
  }
  
  private void a(long paramLong, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap, ajex paramajex)
  {
    if (paramajex.cnR)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "mfidMlist fileTask receivedCompleted  called not success, so again task = " + paramajex);
      }
      if ((!TextUtils.isEmpty(paramajex.path)) && (!TextUtils.isEmpty(paramajex.url)))
      {
        if (paramajex.ao <= 3) {
          break label109;
        }
        paramConcurrentHashMap.remove(Long.valueOf(paramLong));
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " mfidMlist fileTask receivedCompleted retry over time task = " + paramajex);
      }
    }
    label109:
    do
    {
      return;
      if (aqz())
      {
        ajgv.o("recvFile panic error! mfidMlist fileTask receivedCompleted", new Object[0]);
        return;
      }
      paramajex.ao = ((short)(paramajex.ao + 1));
      this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.acp, paramLong, paramajex.url, paramajex.path, paramajex.cnS, paramajex.fileSize, true);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted mfidMlist called not success, so again task = " + paramajex);
      }
    } while (TextUtils.isEmpty(paramajex.url));
    if (paramajex.ao > 3)
    {
      paramConcurrentHashMap.remove(Long.valueOf(paramLong));
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted mfidMlist retry over time task = " + paramajex);
      return;
    }
    if (aqz())
    {
      ajgv.o("receivedCompleted mfidMlist  operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    paramajex.ao = ((short)(paramajex.ao + 1));
    this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.m(this.acp, paramLong, paramajex.url);
  }
  
  private void a(long paramLong, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap, Map<String, String> paramMap)
  {
    if (aqz())
    {
      ajgv.o("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    long l = Long.parseLong((String)paramMap.get("fid"));
    a(paramLong, paramConcurrentHashMap, l, k(l, 1));
  }
  
  private void a(long paramLong, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap, ConcurrentHashMap<String, ajew> paramConcurrentHashMap1, Map<String, String> arg5)
  {
    if (???.size() >= 3)
    {
      if (aqz()) {
        ajgv.o("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
      }
    }
    else {
      return;
    }
    long l = Long.parseLong((String)???.get("fid"));
    String str = (String)???.get("chatUin");
    int i = Integer.parseInt((String)???.get("chatType"));
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached: client report 会话 uin =" + str + " 接收完成, chatType = " + i + "：mServerReadyMList.size = " + paramConcurrentHashMap1.size());
    }
    ??? = (ajew)paramConcurrentHashMap1.get(ajgv.aq(str, i));
    if (??? != null)
    {
      ???.isCompleted = true;
      if (this.jdField_c_of_type_Ajea == null) {}
    }
    for (;;)
    {
      synchronized (this.mLock)
      {
        paramConcurrentHashMap1 = paramConcurrentHashMap1.values().iterator();
        i = 0;
        if (paramConcurrentHashMap1.hasNext())
        {
          if (((ajew)paramConcurrentHashMap1.next()).isCompleted) {
            i += 1;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached: client report session completed! hasCompletedCount = " + i);
          }
          if (this.jdField_c_of_type_Ajea != null) {
            this.jdField_c_of_type_Ajea.iC(i, ajee.dio);
          }
          if ((i != ajee.dio) || (QLog.isColorLevel())) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, client report session transport completed! fid = " + l + ", msg = []");
          }
          a(paramLong, paramConcurrentHashMap, l, k(l, 3));
          return;
        }
      }
    }
  }
  
  private void a(ajew paramajew)
  {
    if (this.coo)
    {
      QN(258);
      return;
    }
    b(this.acp, false, paramajew.uin, paramajew.uinType);
  }
  
  private void a(ConcurrentHashMap<String, ajew> paramConcurrentHashMap, JSONArray paramJSONArray)
    throws JSONException
  {
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject = (JSONObject)paramJSONArray.get(i);
      if ("chat_ready".equals(((JSONObject)localObject).optString("cmd")))
      {
        String str = ((JSONObject)localObject).optString("chatUin");
        int j = ((JSONObject)localObject).optInt("chatType");
        long l = ((JSONObject)localObject).optLong("dbSize");
        localObject = new ajew();
        ((ajew)localObject).uY = false;
        ((ajew)localObject).uin = str;
        ((ajew)localObject).dbSize = l;
        ((ajew)localObject).uinType = ajgv.fk(j);
        paramConcurrentHashMap.put(ajgv.aq(((ajew)localObject).uin, j), localObject);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted  会话 uin =" + str + ", uintype = " + ((ajew)localObject).uinType + "：mClientCanRecvMList.size = " + paramConcurrentHashMap.size());
        }
      }
      i += 1;
    }
    kq(4);
  }
  
  private void a(ConcurrentHashMap<String, ajew> paramConcurrentHashMap, JSONArray paramJSONArray, JSONObject paramJSONObject)
    throws JSONException
  {
    ajee.dio = paramJSONObject.optInt("listCount");
    ajgt.dxs();
    ajgt.a.acq = ajee.dio;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted, 会话总个数：MsgBackupManager.sessionCount = " + ajee.dio);
    }
    int i = 1;
    while (i < paramJSONArray.length())
    {
      Object localObject = (JSONObject)paramJSONArray.get(i);
      if ("chat_ready".equals(((JSONObject)localObject).optString("cmd")))
      {
        paramJSONObject = ((JSONObject)localObject).optString("chatUin");
        int j = ((JSONObject)localObject).optInt("chatType");
        long l = ((JSONObject)localObject).optLong("dbSize");
        localObject = new ajew();
        ((ajew)localObject).uY = false;
        ((ajew)localObject).uin = paramJSONObject;
        ((ajew)localObject).uinType = ajgv.fk(j);
        ((ajew)localObject).dbSize = l;
        String str = ajgv.aq(((ajew)localObject).uin, j);
        if (paramConcurrentHashMap.get(str) == null) {
          paramConcurrentHashMap.put(str, localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted  会话 uin =" + paramJSONObject + ", uintype = " + ((ajew)localObject).uinType + "：mClientCanRecvMList= " + paramConcurrentHashMap);
        }
      }
      i += 1;
    }
    kq(4);
  }
  
  private boolean a(long paramLong, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap, Map<String, String> paramMap)
  {
    if (!ajee.cnL)
    {
      long l = Long.parseLong((String)paramMap.get("fid"));
      paramMap = new ajex();
      paramMap.ao = 0;
      paramMap.cnR = false;
      paramMap.msg = "[]";
      paramMap.sessionId = paramLong;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, postinfo ui is not ready!" + l + ", msg = " + "[]");
      }
      paramConcurrentHashMap.put(Long.valueOf(l), paramMap);
      this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.e(this.acp, paramLong, l, "[]");
      return true;
    }
    return false;
  }
  
  private boolean a(ConcurrentHashMap<String, ajew> paramConcurrentHashMap, boolean paramBoolean)
  {
    Iterator localIterator = paramConcurrentHashMap.values().iterator();
    int i = 0;
    ajew localajew;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localajew = (ajew)localIterator.next();
        if (!localajew.uY) {
          if (localajew.dbSize <= 0L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, curDealUin is not null! dbsize 等于 0 ！客户端不会去请求了，只是通知server端，该会话已经接受完成了！uin = " + localajew.uin + ", uintype = " + localajew.uinType + ", dbsize = " + localajew.dbSize);
            }
            localajew.isCompleted = true;
            localajew.uY = true;
            a(localajew);
            if (this.jdField_c_of_type_Ajea == null) {
              continue;
            }
            i = a(paramConcurrentHashMap);
            if (this.jdField_c_of_type_Ajea != null) {
              this.jdField_c_of_type_Ajea.iC(i, ajee.dio);
            }
            if (i == ajee.dio) {
              ajgv.c("MsgBackup_MsgBackupTransportProcessor", "curDealUin is not null! session transport completed! dbSize is 0!------------->", new Object[0]);
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((!paramBoolean) && (i != ajee.dio))
      {
        QO(5);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNextSessionDb called with warning step2 , , hasFinishedC = " + i);
        }
      }
      return paramBoolean;
      break;
      i = a(paramConcurrentHashMap);
      if (this.jdField_c_of_type_Ajea != null) {
        this.jdField_c_of_type_Ajea.iC(i, ajee.dio);
      }
      if (i == ajee.dio)
      {
        ajgv.c("MsgBackup_MsgBackupTransportProcessor", "curDealUin is not null! session transport completed!------------->", new Object[0]);
      }
      else
      {
        localajew.uY = true;
        ajee.bQU = localajew.uin;
        ajee.dip = localajew.uinType;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, current uin = " + ajee.bQU + ", uintype = " + ajee.dip + ", dbsize = " + localajew.dbSize);
        }
        c(this.acp, localajew.uin, localajew.uinType, false);
        paramBoolean = true;
      }
    }
  }
  
  private void aA(long paramLong, String paramString)
  {
    if (aqz()) {
      ajgv.o("http get reached! but can not understand this request! session is valid........", new Object[0]);
    }
    do
    {
      return;
      paramString = (String)ajgv.t(paramString).get("fid");
    } while (TextUtils.isEmpty(paramString));
    long l = Long.parseLong(paramString);
    ajgv.o("http get reached! but can not understand this request! session is valid........", new Object[0]);
    this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.refuseFileRequest(this.acp, paramLong, l, "404");
  }
  
  public static ajgp b()
  {
    if (jdField_b_of_type_Ajgp == null) {}
    try
    {
      if (jdField_b_of_type_Ajgp == null) {
        jdField_b_of_type_Ajgp = new ajgp();
      }
      return jdField_b_of_type_Ajgp;
    }
    finally {}
  }
  
  private void b(long paramLong, int paramInt, ConcurrentHashMap<String, ajew> paramConcurrentHashMap, ajew paramajew, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap1, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap2, ajex paramajex)
  {
    Object localObject;
    if (paramajex.cnR)
    {
      ajgt.dxs();
      localObject = ajgt.a;
      ((ajgs)localObject).acw += 1L;
      localObject = ajgt.a;
      ((ajgs)localObject).acG += 1L;
      localObject = new ajgs.a();
      if (!ajee.a().k.contains(Long.valueOf(paramLong))) {
        break label218;
      }
      ajgs localajgs = ajgt.a;
      localajgs.acz += 1L;
      ajee.a().k.remove(Long.valueOf(paramLong));
    }
    label218:
    for (((ajgs.a)localObject).diY = 2;; ((ajgs.a)localObject).diY = 1)
    {
      ((ajgs.a)localObject).fileType = 2;
      ((ajgs.a)localObject).errorCode = paramInt;
      ajgt.a.xI.add(localObject);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "resReq fileTask receivedCompleted  called not success, so again task = " + paramajex);
      }
      if ((!TextUtils.isEmpty(paramajex.path)) && (!TextUtils.isEmpty(paramajex.url)))
      {
        if ((paramajex.ao <= 3) || (!this.cop)) {
          break;
        }
        a(paramLong, paramConcurrentHashMap, paramajew, paramConcurrentHashMap1, paramConcurrentHashMap2, paramajex);
      }
      return;
    }
    if (aqz())
    {
      ajgv.o("recvFile panic error! resReq fileTask receivedCompleted", new Object[0]);
      return;
    }
    paramajex.ao = ((short)(paramajex.ao + 1));
    this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.acp, paramLong, paramajex.url, paramajex.path, paramajex.cnS, paramajex.fileSize, true);
  }
  
  private void b(long paramLong, ajex arg3, ConcurrentHashMap<String, ajew> paramConcurrentHashMap, ajew paramajew, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap1)
  {
    ajee.din += 1;
    ajgv.c("MsgBackup_MsgBackupTransportProcessor", "MsgBackup_Manager skipSessionCount = %d", new Object[] { Integer.valueOf(ajee.din) });
    paramConcurrentHashMap1.remove(Long.valueOf(paramLong));
    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "isTcpDetected = " + this.cop + ", 此会话db一直失败，扔掉，通知对端dbMList receivedCompleted retry over time task = " + ???);
    paramajew.isCompleted = true;
    a(paramajew);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup", 2, "getdb failed !  mclient will get db mClientCanRecvMList.size = " + paramConcurrentHashMap.size());
    }
    label247:
    for (;;)
    {
      synchronized (this.mLock)
      {
        paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
        int i = 0;
        if (paramConcurrentHashMap.hasNext())
        {
          if (!((ajew)paramConcurrentHashMap.next()).isCompleted) {
            break label247;
          }
          i += 1;
          break label247;
        }
        if (this.jdField_c_of_type_Ajea != null) {
          this.jdField_c_of_type_Ajea.iC(i, ajee.dio);
        }
        if (i == ajee.dio) {
          return;
        }
      }
      if (!kq(2))
      {
        ajgv.o("this session db has received error! so get next session!", new Object[0]);
        QO(3);
        return;
      }
    }
  }
  
  private void b(long paramLong, String paramString, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap, ConcurrentHashMap<String, ajew> paramConcurrentHashMap1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached success, url = " + paramString);
    }
    if (aqz())
    {
      ajgv.o("getmsg onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    boolean bool2 = this.cnK;
    if (this.jdField_c_of_type_Ajea != null) {}
    long l;
    for (boolean bool1 = true;; bool1 = false)
    {
      ajgv.c("MsgBackup_MsgBackupTransportProcessor", "getmsg isTransportStart = %b, mCallBack is not null = %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((this.jdField_c_of_type_Ajea != null) && (!this.cnK))
      {
        this.cnK = true;
        this.jdField_c_of_type_Ajea.LU(true);
      }
      localObject1 = ajgv.t(paramString);
      l = Long.parseLong((String)((Map)localObject1).get("fid"));
      if (ajee.cnL) {
        break;
      }
      paramString = new ajex();
      paramString.ao = 0;
      paramString.cnR = false;
      paramString.msg = "[]";
      paramString.sessionId = paramLong;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, getmsg ui is not ready!" + l + ", msg = " + "[]");
      }
      paramConcurrentHashMap.put(Long.valueOf(l), paramString);
      this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.e(this.acp, paramLong, l, "[]");
      return;
    }
    paramString = new ajgs.b();
    paramString.cot = false;
    paramString.fileSize = 0L;
    ajee.a().gb.put(Long.valueOf(l), paramString);
    paramString = (String)((Map)localObject1).get("chatUin");
    int j = Integer.parseInt((String)((Map)localObject1).get("chatType"));
    Object localObject1 = ajgv.j(paramString, j, null);
    ??? = new ajex();
    ((ajex)???).ao = 0;
    ((ajex)???).cnR = true;
    ((ajex)???).sessionId = paramLong;
    ((ajex)???).path = ((String)localObject1);
    paramConcurrentHashMap.put(Long.valueOf(l), ???);
    int i = 0;
    for (;;)
    {
      synchronized (this.mLock)
      {
        paramConcurrentHashMap1 = paramConcurrentHashMap1.values().iterator();
        if (paramConcurrentHashMap1.hasNext())
        {
          if (((ajew)paramConcurrentHashMap1.next()).isCompleted) {
            i += 1;
          }
        }
        else
        {
          if (this.jdField_c_of_type_Ajea != null) {
            this.jdField_c_of_type_Ajea.iC(i, ajee.dio);
          }
          this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.d(this.acp, paramLong, l, (String)localObject1);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onHttpRequest, send db uin = " + paramString + ", uinType = " + ajgv.fk(j) + ", dbpath = " + (String)localObject1 + ", fid = " + l + ", mFidMList.size = " + paramConcurrentHashMap.size());
          return;
        }
      }
    }
  }
  
  private void b(long paramLong, ConcurrentHashMap<String, ajew> paramConcurrentHashMap, ajew arg4, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap1, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap2, ajex paramajex)
  {
    paramConcurrentHashMap2.remove(Long.valueOf(paramLong));
    int i = paramConcurrentHashMap2.size();
    int j = paramConcurrentHashMap1.size();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "ResReq receivedCompleted  called success, isResRequestAllFinished " + ???.ds.get() + ", task = " + paramajex + ", resMList.size = " + i);
    }
    if ((i == 0) && (j == 0) && (???.ds.get()))
    {
      ???.isCompleted = true;
      a(???);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "last session transport completed!, uin = " + ajee.bQU + ", uintype = " + ajee.dip + ", task = " + paramajex);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup", 2, "mclient will get db mClientCanRecvMList.size = " + paramConcurrentHashMap.size());
      }
    }
    label329:
    for (;;)
    {
      synchronized (this.mLock)
      {
        paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
        i = 0;
        if (paramConcurrentHashMap.hasNext())
        {
          if (!((ajew)paramConcurrentHashMap.next()).isCompleted) {
            break label329;
          }
          i += 1;
          break label329;
        }
        if (this.jdField_c_of_type_Ajea != null) {
          this.jdField_c_of_type_Ajea.iC(i, ajee.dio);
        }
        if (i == ajee.dio) {
          return;
        }
      }
      if (!kq(2))
      {
        ajgv.o("this session res has received! so get next session!", new Object[0]);
        QO(3);
        return;
      }
    }
  }
  
  private void b(long paramLong, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap, Map<String, String> paramMap)
  {
    if (aqz())
    {
      ajgv.o("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    long l = Long.parseLong((String)paramMap.get("fid"));
    if (this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4 = ajgv.dB((String)paramMap.get("ip"));
      this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port = Integer.parseInt((String)paramMap.get("udpport"));
    }
    if (this.d != null)
    {
      this.d.ipv4 = ajgv.dB((String)paramMap.get("ip"));
      this.d.port = Integer.parseInt((String)paramMap.get("tcpport"));
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, client report its port and ipv4, fid = " + l + ", msg = []");
    }
    a(paramLong, paramConcurrentHashMap, l, k(l, 2));
  }
  
  private void c(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    if (aqz()) {
      ajgv.o("requestFromFile called------> operator is closed! please clear handler msg!........", new Object[0]);
    }
    while (this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy == null) {
      return;
    }
    long l = ajgv.go();
    String str1 = ajgv.J(this.f.ipv4, this.f.port);
    String str2 = "getmsg?fid=" + l + "&chatUin=" + paramString + "&chatType=" + ajgv.cS(paramInt);
    str1 = str1 + ajgv.bl(str2, this.bRi);
    str2 = ajgv.j(paramString, ajgv.cS(paramInt), null);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestFromFile fid = " + l + ", url = " + str1 + ", path = " + str2);
    }
    ajex localajex = new ajex();
    localajex.cnR = true;
    localajex.ao = 0;
    localajex.path = str2;
    localajex.url = str1;
    paramString = ajgv.aq(paramString, ajgv.cS(paramInt));
    ConcurrentHashMap localConcurrentHashMap = ajee.a().ga;
    ajgt.dxs();
    Object localObject = ajgt.a;
    ((ajgs)localObject).acB += 1L;
    localObject = (ajew)localConcurrentHashMap.get(paramString);
    if (localObject != null)
    {
      ((ajew)localObject).gg.put(Long.valueOf(l), localajex);
      localajex.fileSize = ((ajew)localObject).dbSize;
      localajex.cnS = ajgv.cl(((ajew)localObject).dbSize);
      ajgs localajgs = ajgt.a;
      localajgs.acu += localajex.fileSize;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestFromFile , sessionInfo.dbMList = " + ((ajew)localObject).gg + ". sessionInfo.hashcode = " + localObject.hashCode() + ", task.isSmallerFile = " + localajex.cnS);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestFromFile fid = " + l + ", mClientCanRecvMList = " + localConcurrentHashMap + ", keyFromUin = " + paramString + ", task.isSmallerFile = " + localajex.cnS);
    }
    this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(paramLong, l, str1, str2, localajex.cnS, localajex.fileSize, false);
    boolean bool = this.cnK;
    if (this.jdField_c_of_type_Ajea != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ajgv.c("MsgBackup_MsgBackupTransportProcessor", "requestFromFile isTransportStart = %b, mCallBack is not null = %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
      if ((this.jdField_c_of_type_Ajea == null) || (this.cnK)) {
        break;
      }
      this.cnK = true;
      this.jdField_c_of_type_Ajea.LU(true);
      return;
    }
  }
  
  private void c(long paramLong, String paramString, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap, ConcurrentHashMap<String, ajew> paramConcurrentHashMap1)
  {
    if (aqz()) {
      ajgv.o("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached success, url = " + paramString);
      }
      paramString = ajgv.t(paramString);
    } while (a(paramLong, paramConcurrentHashMap, paramString));
    if (paramString.size() == 1)
    {
      a(paramLong, paramConcurrentHashMap, paramString);
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)paramString.get("exit")))
    {
      c(paramLong, paramConcurrentHashMap, paramString);
      return;
    }
    if (paramString.size() == 4)
    {
      b(paramLong, paramConcurrentHashMap, paramString);
      return;
    }
    a(paramLong, paramConcurrentHashMap, paramConcurrentHashMap1, paramString);
  }
  
  private void c(long paramLong, ConcurrentHashMap<Long, ajex> paramConcurrentHashMap, Map<String, String> paramMap)
  {
    if (aqz())
    {
      ajgv.o("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    long l = Long.parseLong((String)paramMap.get("fid"));
    if ((!TextUtils.isEmpty((String)paramMap.get("exit"))) && (this.jdField_c_of_type_Ajea != null)) {
      this.jdField_c_of_type_Ajea.exit(true);
    }
    paramMap = new ajex();
    paramMap.ao = 0;
    paramMap.cnR = false;
    paramMap.msg = "[]";
    paramMap.sessionId = paramLong;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, notify has exit!, fid = " + l + ", msg = " + "[]");
    }
    paramConcurrentHashMap.put(Long.valueOf(l), paramMap);
    this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.e(this.acp, paramLong, l, "[]");
  }
  
  private void d(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (ajgv.cow) {
      paramString = ajgv.bk(paramString, this.bRi);
    }
    for (;;)
    {
      ajgt.dxs();
      ConcurrentHashMap localConcurrentHashMap1 = ajee.a().ge;
      ConcurrentHashMap localConcurrentHashMap2 = ajee.a().fZ;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, MsgBackupManager.curDealType = " + ajee.bQU + ", MsgBackupManager.curDealType = " + ajee.dip);
      }
      if ((this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null) && (paramString != null))
      {
        if (paramString.contains("/postinfo?")) {
          c(paramLong, paramString, localConcurrentHashMap1, localConcurrentHashMap2);
        }
      }
      else {
        return;
      }
      if (paramString.contains("/getmsg?"))
      {
        b(paramLong, paramString, localConcurrentHashMap1, localConcurrentHashMap2);
        return;
      }
      if (paramString.contains("/getres?"))
      {
        a(paramLong, paramString, localConcurrentHashMap1);
        return;
      }
      aA(paramLong, paramString);
      return;
    }
  }
  
  private void dxp()
  {
    this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.stop(this.acp);
    this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.destroySession(this.acp);
    this.acp = 0L;
    ajgo.a().dxo();
  }
  
  private String k(long paramLong, int paramInt)
  {
    int i = ajee.dio;
    Object localObject3 = ajee.a().fZ;
    ((ConcurrentHashMap)localObject3).size();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "getSessionJsonRsp, fid = " + paramLong + ", mServerReadyMList.size = " + ((ConcurrentHashMap)localObject3).size() + ", mDataCache = " + i + ", from = " + paramInt);
    }
    JSONArray localJSONArray = new JSONArray();
    ??? = new JSONObject();
    int j;
    try
    {
      if (((ConcurrentHashMap)localObject3).size() <= 0) {
        break label354;
      }
      ((JSONObject)???).put("cmd", "chat_list_count");
      ((JSONObject)???).put("listCount", i);
      localJSONArray.put(???);
      j = 0;
      synchronized (this.mLock)
      {
        localObject3 = ((ConcurrentHashMap)localObject3).values().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ajew localajew = (ajew)((Iterator)localObject3).next();
          i = j;
          if (localajew.isCompleted) {
            i = j + 1;
          }
          j = i;
          if (!localajew.cnP)
          {
            JSONObject localJSONObject = new JSONObject();
            String str2 = localajew.uin;
            j = localajew.uinType;
            localJSONObject.put("cmd", "chat_ready");
            localJSONObject.put("chatUin", str2);
            localJSONObject.put("chatType", ajgv.cS(j));
            localJSONObject.put("dbSize", localajew.dbSize);
            localJSONArray.put(localJSONObject);
            localajew.cnP = true;
            j = i;
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return "[]";
    }
    if ((3 == paramInt) && (this.jdField_c_of_type_Ajea != null)) {
      this.jdField_c_of_type_Ajea.iC(j, ajee.dio);
    }
    label354:
    String str1 = localJSONException.toString();
    return str1;
  }
  
  private String v(byte[] paramArrayOfByte)
  {
    String str = "";
    if (paramArrayOfByte != null) {}
    try
    {
      str = new String(paramArrayOfByte, "utf-8");
      return str;
    }
    catch (Exception paramArrayOfByte)
    {
      ajgv.c("MsgBackup", "receivedCompleted String byte transport string error!!!", new Object[0]);
    }
    return "";
  }
  
  private String xk()
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cmd", "exit");
      localJSONObject.put("sig", ajdt.a().xj());
      localJSONArray.put(localJSONObject);
      return localJSONArray.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void LX(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Ajea != null) {
      this.jdField_c_of_type_Ajea.exit(paramBoolean);
    }
  }
  
  public void Mv(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ajee.a().dwA();
      ajgv.aqD();
      if (this.a == null) {
        this.a = new MsgBackupNotifier();
      }
      ajee.a().ga.clear();
      QK(1);
      ajee.a().ga.clear();
      ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.1(this, paramString));
    }
  }
  
  public void Mw(String paramString)
  {
    this.bRi = paramString;
  }
  
  public void QK(int paramInt)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null) && (!aqz()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "stop called! operator = " + this.acp + ". from = " + paramInt);
      }
      ajee.a().clearSessionData();
      if (Looper.getMainLooper() == Looper.myLooper()) {
        ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.5(this));
      }
    }
    else
    {
      return;
    }
    dxp();
  }
  
  public void QL(int paramInt)
  {
    if (aqz()) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint start panic error!");
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null)
      {
        if (paramInt == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint start for MBRROLE_SERVER");
          }
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint clientTcpEndPoint.ipv4 = " + ajgv.ez(this.d.ipv4) + ", clientUdpEndpoint.port = " + this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port + ", clientTcpEndPoint.port" + this.d.port);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint serverUdpEndpoint.ipv4 = " + ajgv.ez(this.f.ipv4) + ", serverUdpEndpoint.port = " + this.e.port + ", serverTcpEndPoint.port" + this.f.port);
          this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.setPeerEndpoint(this.acp, this.d.ipv4, this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port, this.d.port);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint end， operator = " + this.acp);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint start for MBRROLE_CLIENT");
          }
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint clientTcpEndPoint.ipv4 = " + ajgv.ez(this.d.ipv4) + ", clientUdpEndpoint.port = " + this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port + ", clientTcpEndPoint.port" + this.d.port);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint serverUdpEndpoint.ipv4 = " + ajgv.ez(this.f.ipv4) + ", serverUdpEndpoint.port = " + this.e.port + ", serverTcpEndPoint.port" + this.f.port);
          this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.setPeerEndpoint(this.acp, this.f.ipv4, this.e.port, this.f.port);
        }
      }
    }
  }
  
  public void QM(int paramInt)
  {
    if (aqz()) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setEncryptKey panic error!");
      }
    }
    while (this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy == null) {
      return;
    }
    if (paramInt == 2) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setEncryptKey start for MBRROLE_SERVER");
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.az(this.acp, this.bRi);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setEncryptKey end， session = " + this.acp + ", encryptkey = " + this.bRi);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setEncryptKey start for MBRROLE_CLIENT");
      }
    }
  }
  
  public void QN(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null)
    {
      if (!this.coo) {
        break label120;
      }
      if (!aqz()) {
        break label37;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "sendMessageUdp panic error!");
      }
    }
    label37:
    label120:
    while (!QLog.isColorLevel())
    {
      long l;
      do
      {
        return;
        l = ajgv.go();
        String str = d(paramInt, l);
        this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.acp, paramInt, str, l);
      } while (!QLog.isColorLevel());
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "sendMessageUdp udpdetected = " + this.coo + ", cmd = " + paramInt + ", cookieIndex = " + l);
      return;
    }
    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "sendMessageUdp is error! please use tcp get! udpdetected = " + this.coo + ", cmd = " + paramInt);
  }
  
  public void QO(int paramInt)
  {
    if ((this.f == null) || (this.e == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNotifyServer server ip and port is not set! this method will be called in processConfirmRsp!");
      }
    }
    long l;
    String str;
    do
    {
      do
      {
        return;
      } while ((this.dah != 1) || (!this.cop));
      if (aqz())
      {
        ajgv.o("requestSessionList called------>MBRROLE_CLIENT  operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestSessionList is called! isTcpDetected = " + this.cop + ", from = " + paramInt);
      }
      if (!this.con)
      {
        this.con = true;
        b(this.acp, true, "", 0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestSessionList, isTcpDetected = " + this.cop + ", client will get ready session list from server------>");
      }
      l = ajgv.go();
      str = ajgv.J(this.f.ipv4, this.f.port);
      localObject = "postinfo?fid=" + l;
      ajgv.c("MsgBackup_MsgBackupTransportProcessor", (String)localObject, new Object[0]);
      localObject = ajgv.bl((String)localObject, this.bRi);
      str = str + (String)localObject;
    } while ((TextUtils.isEmpty(str)) || (this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy == null));
    Object localObject = new ajex();
    ((ajex)localObject).cnR = false;
    ((ajex)localObject).ao = 0;
    ((ajex)localObject).url = str;
    ajee.a().ge.put(Long.valueOf(l), localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestSessionList fid = " + l + ", url = " + str);
    }
    this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.m(this.acp, l, str);
  }
  
  public void T(String paramString1, int paramInt, String paramString2)
  {
    ajee.a().dwA();
    ajgv.aqD();
    ajee.a().b().QE(paramInt);
    ajee.a().b().Mr(paramString2);
    ajee.a().ga.clear();
    QK(1);
    if (paramInt == 1)
    {
      if (this.a == null) {
        this.a = new MsgBackupNotifier();
      }
      ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.3(this, paramString1));
    }
    if (paramInt == 2)
    {
      if (this.a == null) {
        this.a = new MsgBackupNotifier();
      }
      ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.4(this, paramString1));
    }
  }
  
  public MsgBackupEndPoint a()
  {
    return this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint;
  }
  
  public void a(MsgBackupEndPoint paramMsgBackupEndPoint)
  {
    this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint = paramMsgBackupEndPoint;
  }
  
  public boolean aqA()
  {
    return this.cop;
  }
  
  public boolean aqz()
  {
    return this.acp == 0L;
  }
  
  public MsgBackupEndPoint b()
  {
    return this.d;
  }
  
  public void b(long paramLong, boolean paramBoolean, String paramString, int paramInt)
  {
    if ((this.f == null) || (this.e == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNotifyServer server ip and port is not set! this method will be called in processConfirmRsp!");
      }
    }
    for (;;)
    {
      return;
      if ((this.dah != 1) || (!this.cop)) {
        break;
      }
      if (aqz())
      {
        ajgv.o("requestNotifyServer called------>MBRROLE_CLIENT  operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNotifyServer, isTcpDetected = " + this.cop);
      }
      long l = ajgv.go();
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = "postinfo?fid=" + l + "&chatUin=" + paramString + "&chatType=" + ajgv.cS(paramInt);
        ajgv.c("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
        paramString = ajgv.J(this.f.ipv4, this.f.port) + ajgv.bl(paramString, this.bRi);
      }
      while ((!TextUtils.isEmpty(paramString)) && (this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null))
      {
        ajex localajex = new ajex();
        localajex.ao = 0;
        localajex.cnR = false;
        localajex.url = paramString;
        ajee.a().ge.put(Long.valueOf(l), localajex);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNotifyServer fid = " + l + ", url = " + paramString);
        }
        this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.m(paramLong, l, paramString);
        return;
        if (paramBoolean)
        {
          paramString = "postinfo?fid=" + l + "&ip=" + ajgv.ez(this.d.ipv4) + "&tcpport=" + this.d.port + "&udpport=" + this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port;
          ajgv.c("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
          paramString = ajgv.J(this.f.ipv4, this.f.port) + ajgv.bl(paramString, this.bRi);
        }
        else
        {
          paramString = "postinfo?fid=" + l;
          ajgv.c("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
          paramString = ajgv.J(this.f.ipv4, this.f.port) + ajgv.bl(paramString, this.bRi);
        }
      }
    }
    ajgv.c("MsgBackup_MsgBackupTransportProcessor", "requestNotifyServer is called error!", new Object[0]);
  }
  
  public void b(ajea paramajea)
  {
    this.jdField_c_of_type_Ajea = paramajea;
  }
  
  public void b(MsgBackupEndPoint paramMsgBackupEndPoint)
  {
    ajgu.acM = 0L;
    ajgu.track(null, "cost_connect_total");
    this.d = paramMsgBackupEndPoint;
  }
  
  protected boolean b(ConcurrentHashMap<String, ajew> paramConcurrentHashMap)
  {
    ajew localajew = (ajew)paramConcurrentHashMap.get(ajgv.aq(ajee.bQU, ajgv.cS(ajee.dip)));
    if (localajew != null)
    {
      if (localajew.isCompleted)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, last uin = " + ajee.bQU + ", uintype = " + ajee.dip);
        }
        return a(paramConcurrentHashMap, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "current session not completed! requestNextSessionDb !, current uin = " + ajee.bQU + ", uintype = " + ajee.dip);
      }
    }
    return false;
  }
  
  public MsgBackupEndPoint c()
  {
    return this.e;
  }
  
  public void c(MsgBackupEndPoint paramMsgBackupEndPoint)
  {
    this.e = paramMsgBackupEndPoint;
  }
  
  protected boolean c(ConcurrentHashMap<String, ajew> paramConcurrentHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, last uin = " + ajee.bQU + ", uintype = " + ajee.dip);
    }
    Iterator localIterator = paramConcurrentHashMap.values().iterator();
    ajew localajew;
    while (localIterator.hasNext())
    {
      localajew = (ajew)localIterator.next();
      if (!localajew.uY)
      {
        if (localajew.dbSize > 0L) {
          break label266;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !,  curDealUin  null! dbsize 等于 0 ！客户端不会去请求了，只是通知server端，该会话已经接受完成了！uin = " + localajew.uin + ", uintype = " + localajew.uinType + ", dbSize = " + localajew.dbSize);
        }
        localajew.isCompleted = true;
        localajew.uY = true;
        a(localajew);
        if (this.jdField_c_of_type_Ajea != null)
        {
          i = a(paramConcurrentHashMap);
          if ((this.jdField_c_of_type_Ajea != null) && (!this.cnK))
          {
            this.cnK = true;
            this.jdField_c_of_type_Ajea.LU(true);
          }
          if (this.jdField_c_of_type_Ajea != null) {
            this.jdField_c_of_type_Ajea.iC(i, ajee.dio);
          }
          if ((i == ajee.dio) && (this.jdField_c_of_type_Ajea != null)) {
            ajgv.c("MsgBackup_MsgBackupTransportProcessor", "session transport completed! dbSize is 0------------->", new Object[0]);
          }
        }
      }
    }
    return false;
    label266:
    localajew.uY = true;
    ajee.bQU = localajew.uin;
    ajee.dip = localajew.uinType;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, uin = " + ajee.bQU + ", uintype = " + ajee.dip + ", dbsize = " + localajew.dbSize);
    }
    int i = a(paramConcurrentHashMap);
    if ((this.jdField_c_of_type_Ajea != null) && (!this.cnK))
    {
      this.cnK = true;
      this.jdField_c_of_type_Ajea.LU(true);
    }
    if (this.jdField_c_of_type_Ajea != null) {
      this.jdField_c_of_type_Ajea.iC(i, ajee.dio);
    }
    if (i == ajee.dio)
    {
      ajgv.c("MsgBackup_MsgBackupTransportProcessor", "session transport completed!------------->", new Object[0]);
      return false;
    }
    c(this.acp, localajew.uin, localajew.uinType, false);
    return true;
  }
  
  public void clearState()
  {
    this.coo = false;
    this.cop = false;
    this.lastProgressTime = 0L;
    this.aco = 0L;
    this.cnK = false;
  }
  
  public void cw(String paramString, boolean paramBoolean)
  {
    ajee.a().dwA();
    ajgv.aqD();
    if (this.a == null) {
      this.a = new MsgBackupNotifier();
    }
    QK(1);
    ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.2(this, paramString, paramBoolean));
  }
  
  public MsgBackupEndPoint d()
  {
    return this.f;
  }
  
  public String d(int paramInt, long paramLong)
  {
    int j = 0;
    Object localObject1 = new JSONArray();
    if (paramInt == 256) {}
    for (;;)
    {
      Object localObject3;
      try
      {
        ??? = ((JSONArray)localObject1).toString();
        localObject1 = ajee.a().gd;
        localObject3 = new ajex();
        ((ajex)localObject3).msg = ((String)???);
        ((ajex)localObject3).cmd = paramInt;
        ((ajex)localObject3).ao = 0;
        ((ConcurrentHashMap)localObject1).put(Long.valueOf(paramLong), localObject3);
        localObject1 = ???;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "getSessionJson, cookie = " + paramLong + ", msg = " + (String)???);
        return ???;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "[]";
      }
      int i;
      Object localObject4;
      Object localObject5;
      if (paramInt == 257)
      {
        if (!ajee.cnL)
        {
          ??? = ((JSONArray)localObject1).toString();
          localObject1 = ajee.a().gd;
          localObject3 = new ajex();
          ((ajex)localObject3).msg = ((String)???);
          ((ajex)localObject3).cmd = paramInt;
          ((ajex)localObject3).ao = 0;
          ((ConcurrentHashMap)localObject1).put(Long.valueOf(paramLong), localObject3);
          localObject1 = ???;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "MsgBackupManager.sUIReady = " + ajee.cnL + ", getSessionJson is called! cookie = " + paramLong + ", msg = " + (String)???);
          return ???;
        }
        ??? = ajee.a().bi;
        localObject3 = ajee.a().fZ;
        i = ajee.dio;
        if (((ConcurrentHashMap)localObject3).size() > 0)
        {
          ??? = new JSONObject();
          ((JSONObject)???).put("cmd", "chat_list_count");
          ((JSONObject)???).put("listCount", i);
          localJSONException.put(???);
          synchronized (this.mLock)
          {
            localObject3 = ((ConcurrentHashMap)localObject3).values().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (ajew)((Iterator)localObject3).next();
              i = j;
              if (((ajew)localObject4).isCompleted) {
                i = j + 1;
              }
              j = i;
              if (!((ajew)localObject4).cnP)
              {
                localObject5 = ((ajew)localObject4).uin;
                j = ((ajew)localObject4).uinType;
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("cmd", "chat_ready");
                localJSONObject.put("chatUin", localObject5);
                localJSONObject.put("chatType", ajgv.cS(j));
                localJSONObject.put("dbSize", ((ajew)localObject4).dbSize);
                localJSONException.put(localJSONObject);
                ((ajew)localObject4).cnP = true;
                j = i;
              }
            }
          }
          if (this.jdField_c_of_type_Ajea != null) {
            this.jdField_c_of_type_Ajea.iC(j, ajee.dio);
          }
        }
      }
      else if (paramInt == 258)
      {
        ??? = ajee.a().ga.values().iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (ajew)((Iterator)???).next();
          if ((!((ajew)localObject3).cnQ) && (((ajew)localObject3).isCompleted))
          {
            localObject4 = ((ajew)localObject3).uin;
            i = ((ajew)localObject3).uinType;
            localObject5 = new JSONObject();
            ((JSONObject)localObject5).put("cmd", "chat_transfer_complete");
            ((JSONObject)localObject5).put("chatUin", localObject4);
            ((JSONObject)localObject5).put("chatType", ajgv.cS(i));
            str.put(localObject5);
            ((ajew)localObject3).cnQ = true;
          }
        }
      }
      else if (paramInt == 259)
      {
        ??? = new JSONObject();
        ((JSONObject)???).put("cmd", "exit");
        ((JSONObject)???).put("sig", ajdt.a().xj());
        str.put(???);
      }
    }
    return str;
  }
  
  public void d(MsgBackupEndPoint paramMsgBackupEndPoint)
  {
    ajgu.acM = 0L;
    ajgu.track(null, "cost_connect_total");
    this.f = paramMsgBackupEndPoint;
  }
  
  public void dxq()
  {
    String str = xk();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitUdpNotify create exit : " + str + ", isUdpDetected = " + this.coo);
    }
    if (this.coo) {
      QN(259);
    }
    label64:
    long l;
    do
    {
      do
      {
        do
        {
          break label64;
          do
          {
            return;
          } while (this.dah != 1);
          if ((this.f != null) && (this.e != null)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitForTcp called- for client-------------->>>");
        return;
      } while (!this.cop);
      if (aqz())
      {
        ajgv.o("exiNotifyForTransfer called------> operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitForTcp, isTcpDetected = " + this.cop);
      }
      l = ajgv.go();
      str = ajgv.J(this.f.ipv4, this.f.port);
      localObject = "postinfo?fid=" + l + "&exit=1";
      ajgv.c("MsgBackup_MsgBackupTransportProcessor", (String)localObject, new Object[0]);
      localObject = ajgv.bl((String)localObject, this.bRi);
      str = str + (String)localObject;
    } while ((TextUtils.isEmpty(str)) || (this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy == null));
    Object localObject = new ajex();
    ((ajex)localObject).ao = 0;
    ((ajex)localObject).cnR = false;
    ((ajex)localObject).url = str;
    ajee.a().ge.put(Long.valueOf(l), localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitForTcp fid = " + l + ", url = " + str);
    }
    this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.m(this.acp, l, str);
  }
  
  public void dxr()
  {
    Object localObject = xk();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitUdpNotify create exit : " + (String)localObject);
    }
    if (this.coo)
    {
      QN(259);
      return;
    }
    localObject = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cmd", "exit");
      localJSONObject.put("sig", ajdt.a().xj());
      ((JSONArray)localObject).put(localJSONObject);
      ajdv.a().Ms(((JSONArray)localObject).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void exit()
  {
    int i = ajdt.a().Gi();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exit ---------> bizType = " + i);
    }
    if (i == 3)
    {
      dxq();
      return;
    }
    if (i == 1)
    {
      dxr();
      return;
    }
    dxr();
  }
  
  protected void g(ConcurrentHashMap<String, ajew> paramConcurrentHashMap)
  {
    if (!TextUtils.isEmpty(ajee.bQU))
    {
      ajew localajew = (ajew)paramConcurrentHashMap.get(ajgv.aq(ajee.bQU, ajgv.cS(ajee.dip)));
      if (localajew != null)
      {
        localajew.isCompleted = true;
        ajgv.c("MsgBackup_MsgBackupTransportProcessor", "requestNextSessionDb MsgBackupController MsgBackupManager.curDealUin = %s, MsgBackupManager.curDealType = %d", new Object[] { ajee.bQU, Integer.valueOf(ajee.dip) });
        a(localajew);
        if (this.jdField_c_of_type_Ajea != null)
        {
          int i = a(paramConcurrentHashMap);
          if (this.jdField_c_of_type_Ajea != null) {
            this.jdField_c_of_type_Ajea.iC(i, ajee.dio);
          }
          if ((i != ajee.dio) || (this.jdField_c_of_type_Ajea == null)) {}
        }
      }
    }
  }
  
  public int getRole()
  {
    return this.dah;
  }
  
  public boolean kq(int paramInt)
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        if ((!this.cop) && (paramInt == 3))
        {
          this.coq = true;
          ajgv.c("MsgBackup_MsgBackupTransportProcessor", "requestNextSessionDb tcp is disconnect!", new Object[0]);
          return bool2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, from = " + paramInt);
        }
        ConcurrentHashMap localConcurrentHashMap1 = ajee.a().ga;
        if ((paramInt == 1) || (paramInt == 6)) {
          g(localConcurrentHashMap1);
        }
        boolean bool1;
        if (!TextUtils.isEmpty(ajee.bQU))
        {
          bool1 = b(localConcurrentHashMap1);
          if ((localConcurrentHashMap1.size() == 0) || (TextUtils.isEmpty(ajee.bQU)))
          {
            QO(5);
            if (QLog.isColorLevel()) {
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNextSessionDb called with warning step1");
            }
          }
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNextSessionDb called with from = " + paramInt + ", ret = " + bool1 + ", sessionCount = " + ajee.dio);
            bool2 = bool1;
          }
        }
        else
        {
          bool1 = c(localConcurrentHashMap2);
        }
      }
      finally {}
    }
  }
  
  public String ma(String paramString)
  {
    return ajgv.b(paramString, this.f.ipv4, this.f.port, this.bRi);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onDestroy called! operator = " + this.acp);
    }
    clearState();
    QK(2);
  }
  
  public void onHttpRequest(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (this.dah == 2) {
      d(paramLong, paramInt1, paramInt2, paramString);
    }
  }
  
  public void onRecvComplete(long paramLong1, String paramString1, int paramInt1, String paramString2, byte[] paramArrayOfByte, int paramInt2, int paramInt3, long paramLong2)
  {
    ajgv.c("MsgBackup_MsgBackupTransportProcessor", "onRecvComplete from jni fid = %d,url = %s,errcode = %d,path = %s ", new Object[] { Long.valueOf(paramLong1), paramString1, Integer.valueOf(paramInt1), paramString2 });
    ajgu.complete(paramLong1);
    a(paramLong1, paramString1, paramInt1, paramString2, paramArrayOfByte, paramInt2, paramInt3, paramLong2);
  }
  
  public void onRecvMessage(int paramInt1, int paramInt2, int paramInt3, String paramString, long paramLong)
  {
    a(paramInt1, paramInt2, paramInt3, paramString, paramLong);
  }
  
  public void onRecvProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    ajgu.au(paramLong1, paramLong2);
    if (this.lastProgressTime > 0L)
    {
      paramLong2 = SystemClock.elapsedRealtime() - this.lastProgressTime;
      if (paramLong2 > 1500L)
      {
        paramLong3 = this.aco + paramLong3;
        if (this.jdField_c_of_type_Ajea != null)
        {
          this.jdField_c_of_type_Ajea.kg(1000L * paramLong3 / paramLong2);
          ajgu.av(paramLong1, paramLong3 * 1000L / paramLong2);
        }
        this.aco = 0L;
        this.lastProgressTime = SystemClock.elapsedRealtime();
        return;
      }
      this.aco += paramLong3;
      return;
    }
    this.lastProgressTime = SystemClock.elapsedRealtime();
    this.aco += paramLong3;
  }
  
  public void onRecvStart(long paramLong1, String paramString, long paramLong2, long paramLong3, long paramLong4) {}
  
  public void onSendComplete(long paramLong1, boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong2)
  {
    ajgu.complete(paramLong1);
    ajgt.dxs();
    Object localObject;
    label184:
    ajex localajex;
    if (ajee.a().gc.containsKey(Long.valueOf(paramLong1)))
    {
      localObject = (ajgs.b)ajee.a().gc.get(Long.valueOf(paramLong1));
      if (localObject != null)
      {
        boolean bool = ajgv.cl(((ajgs.b)localObject).fileSize);
        if (bool)
        {
          localObject = ajgt.a;
          ((ajgs)localObject).acy += 1L;
        }
        if (!paramBoolean)
        {
          localObject = ajgt.a;
          ((ajgs)localObject).acG += 1L;
          localObject = new ajgs.a();
          ((ajgs.a)localObject).fileType = 2;
          if (!bool) {
            break label273;
          }
          paramInt2 = 2;
          ((ajgs.a)localObject).diY = paramInt2;
          ((ajgs.a)localObject).errorCode = paramInt1;
          ajgt.a.xI.add(localObject);
          if (bool)
          {
            localObject = ajgt.a;
            ((ajgs)localObject).acz += 1L;
          }
        }
      }
      ajee.a().gc.remove(Long.valueOf(paramLong1));
      localObject = ajee.a().ge;
      localajex = (ajex)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong1));
      if (localajex == null) {
        break label724;
      }
      if (!paramBoolean) {
        break label426;
      }
      ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete  task = " + localajex + ", mFidMList.size = " + ((ConcurrentHashMap)localObject).size());
      }
    }
    label273:
    label426:
    label579:
    label724:
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          return;
          paramInt2 = 1;
          break;
          if (!ajee.a().gb.containsKey(Long.valueOf(paramLong1))) {
            break label184;
          }
          if ((ajgs.b)ajee.a().gb.get(Long.valueOf(paramLong1)) != null)
          {
            localObject = ajgt.a;
            ((ajgs)localObject).acB += 1L;
            if (!paramBoolean)
            {
              localObject = ajgt.a;
              ((ajgs)localObject).acC += 1L;
              localObject = ajgt.a;
              ((ajgs)localObject).acG += 1L;
              localObject = new ajgs.a();
              ((ajgs.a)localObject).fileType = 1;
              ((ajgs.a)localObject).diY = 0;
              ((ajgs.a)localObject).errorCode = paramInt1;
              ajgt.a.xI.add(localObject);
            }
          }
          ajee.a().gb.remove(Long.valueOf(paramLong1));
          break label184;
          if (!localajex.cnR) {
            break label579;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "fileTask onSendComplete  called not success, so again  task = " + localajex);
          }
        } while (TextUtils.isEmpty(localajex.path));
        if (localajex.ao > 3)
        {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete fileTask  retry over time task = " + localajex);
          ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
          return;
        }
        if (aqz())
        {
          ajgv.o("fileTask onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
          return;
        }
        localajex.ao = ((short)(localajex.ao + 1));
        this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.d(this.acp, localajex.sessionId, paramLong1, localajex.path);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete  called not success, so again task = " + localajex);
        }
      } while (TextUtils.isEmpty(localajex.msg));
      if (localajex.ao > 3)
      {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete retry over time task = " + localajex);
        ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
        return;
      }
      if (aqz())
      {
        ajgv.o("onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      localajex.ao = ((short)(localajex.ao + 1));
      this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.e(this.acp, localajex.sessionId, paramLong1, localajex.msg);
      return;
    }
    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete  called, please check your mFidMList whether contains this task, before execute, should add in mFidMList!, path = " + paramString + ", fid = " + paramLong1);
  }
  
  public void onSendMessage(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    Object localObject;
    ajex localajex;
    if (2 == this.dah)
    {
      localObject = ajee.a().gd;
      localajex = (ajex)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong1));
      if (localajex != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage, success = " + paramBoolean + ", cookie = " + paramLong1 + ", role = MBRROLE_SERVER");
        }
        if (!paramBoolean) {
          break label98;
        }
        ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
      }
    }
    label98:
    int i;
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
              do
              {
                return;
                if (!aqz()) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage role = MBRROLE_CLIENT: panic error!");
              return;
              if (localajex.ao > 3)
              {
                ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " mfidMlist fileTask receivedCompleted retry over time task = " + localajex);
                return;
              }
              localajex.ao = ((short)(localajex.ao + 1));
              localObject = localajex.msg;
              i = localajex.cmd;
              if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage role = MBRROLE_CLIENT: " + localajex);
              }
            } while (TextUtils.isEmpty((CharSequence)localObject));
            this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.acp, i, (String)localObject, paramLong1);
            return;
          } while (1 != this.dah);
          localObject = ajee.a().gd;
          localajex = (ajex)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong1));
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage, success = " + paramBoolean + ", cookie = " + paramLong1 + ", role = MBRROLE_CLIENT");
          }
        } while (localajex == null);
        if (paramBoolean)
        {
          ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
          return;
        }
        if (!aqz()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage role = MBRROLE_CLIENT: panic error!");
      return;
      if (localajex.ao > 3)
      {
        ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " mfidMlist fileTask receivedCompleted retry over time task = " + localajex);
        return;
      }
      localObject = localajex.msg;
      i = localajex.cmd;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage  role = MBRROLE_CLIENT: " + localajex);
      }
    } while (TextUtils.isEmpty((CharSequence)localObject));
    this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.acp, i, (String)localObject, paramLong1);
  }
  
  public void onSendProgress(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, long paramLong4, int paramInt2, int paramInt3, long paramLong5)
  {
    ajgu.au(paramLong1, paramLong3);
    ajgt.dxs();
    if (ajee.a().gc.containsKey(Long.valueOf(paramLong1)))
    {
      paramString = (ajgs.b)ajee.a().gc.get(Long.valueOf(paramLong1));
      if ((paramString != null) && (!paramString.cot))
      {
        paramString.cot = true;
        paramString.fileSize = paramLong3;
        paramString = ajgt.a;
        paramString.act += paramLong3;
      }
    }
    while (this.lastProgressTime > 0L)
    {
      paramLong2 = SystemClock.elapsedRealtime() - this.lastProgressTime;
      if (paramLong2 > 1500L)
      {
        paramLong3 = this.aco + paramLong4;
        if (this.jdField_c_of_type_Ajea != null)
        {
          this.jdField_c_of_type_Ajea.kg(1000L * paramLong3 / paramLong2);
          ajgu.av(paramLong1, paramLong3 * 1000L / paramLong2);
        }
        this.aco = 0L;
        this.lastProgressTime = SystemClock.elapsedRealtime();
        return;
        if (ajee.a().gb.containsKey(Long.valueOf(paramLong1)))
        {
          paramString = (ajgs.b)ajee.a().gb.get(Long.valueOf(paramLong1));
          if ((paramString != null) && (!paramString.cot))
          {
            paramString.cot = true;
            paramString.fileSize = paramLong3;
            paramString = ajgt.a;
            paramString.acu += paramLong3;
          }
        }
      }
      else
      {
        this.aco += paramLong4;
        return;
      }
    }
    this.lastProgressTime = SystemClock.elapsedRealtime();
    this.aco += paramLong4;
  }
  
  public void onServoPortChanged(int paramInt1, int paramInt2) {}
  
  public void onTcpConnStateChanged(int paramInt)
  {
    if (paramInt != 0) {}
    for (this.cop = true;; this.cop = false)
    {
      if (this.cop) {
        ajgu.track("cost_connect_total", null);
      }
      ajgt.dxs();
      ajgt.a.connectType = paramInt;
      if (this.jdField_c_of_type_Ajea != null) {
        this.jdField_c_of_type_Ajea.LT(this.cop);
      }
      if ((this.cop) && (this.coq))
      {
        this.coq = false;
        ajgv.c("MsgBackup_MsgBackupTransportProcessor", "tcp is disconnect!, before has cached this request msg, so request again!", new Object[0]);
        kq(3);
      }
      QO(2);
      return;
    }
  }
  
  public void onUdpDetected(boolean paramBoolean)
  {
    this.coo = paramBoolean;
    ajgt.dxs();
    ajgt.a.udpDetected = this.coo;
  }
  
  public void onUdpPortChanged(int paramInt1, int paramInt2)
  {
    if (this.dah == 1) {
      if ((this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint != null) && (this.d != null))
      {
        this.d.ipv4 = paramInt1;
        this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4 = paramInt1;
        this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port = paramInt2;
      }
    }
    while ((this.dah != 2) || (this.e == null) || (this.f == null)) {
      return;
    }
    this.f.ipv4 = paramInt1;
    this.e.ipv4 = paramInt1;
    this.e.port = paramInt2;
  }
  
  public void onVersoBind(int paramInt1, int paramInt2) {}
  
  public void onVersoPortChanged(int paramInt1, int paramInt2) {}
  
  public void q(String paramString1, String paramString2, long paramLong)
  {
    if (aqz()) {
      ajgv.o("clientGetResFile called---> operator is closed! please clear handler msg!........", new Object[0]);
    }
    do
    {
      return;
      ajgt.dxs();
      localObject = ajgt.a;
      ((ajgs)localObject).acv += 1L;
      localObject = ajee.a().ga;
      if ((paramString1 != null) || (paramString2 != null)) {
        break;
      }
      ajgv.c("MsgBackup_MsgBackupTransportProcessor", "clientGetResFile MsgBackupManager.curDealUin = %s, MsgBackupManager.curDealType = %d", new Object[] { ajee.bQU, Integer.valueOf(ajee.dip) });
      paramString1 = (ajew)((ConcurrentHashMap)localObject).get(ajgv.aq(ajee.bQU, ajgv.cS(ajee.dip)));
    } while (paramString1 == null);
    ajgv.c("MsgBackup_MsgBackupTransportProcessor", "clientGetResFile sessionInfo is not null reslist size = %d, dbsize = %d", new Object[] { Integer.valueOf(paramString1.gf.size()), Integer.valueOf(paramString1.gg.size()) });
    if ((paramString1.gf.size() == 0) && (paramString1.gg.size() == 0)) {
      kq(6);
    }
    paramString1.ds.set(true);
    return;
    new File(paramString2).getParentFile().mkdirs();
    long l = ajgv.go();
    paramString1 = ajgv.bl(String.format("getres?fid=%d&filepath=%s", new Object[] { Long.valueOf(l), paramString1 }), this.bRi);
    paramString1 = ajgv.J(this.f.ipv4, this.f.port) + paramString1;
    ajex localajex = new ajex();
    localajex.ao = 0;
    localajex.cnR = true;
    localajex.path = paramString2;
    localajex.url = paramString1;
    localajex.cnS = ajgv.cl(paramLong);
    localajex.fileSize = paramLong;
    ajgs localajgs = ajgt.a;
    localajgs.act += paramLong;
    Object localObject = (ajew)((ConcurrentHashMap)localObject).get(ajgv.aq(ajee.bQU, ajgv.cS(ajee.dip)));
    if (localObject != null) {
      ((ajew)localObject).gf.put(Long.valueOf(l), localajex);
    }
    this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.acp, l, paramString1, paramString2, localajex.cnS, localajex.fileSize, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajgp
 * JD-Core Version:    0.7.0.1
 */