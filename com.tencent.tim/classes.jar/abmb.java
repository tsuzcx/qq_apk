import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.lightGame.CmGameSocketConnection;
import com.tencent.mobileqq.apollo.lightGame.CmGameSocketConnection.a;
import com.tencent.mobileqq.apollo.lightGame.CmGameSocketConnection.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.apollo.CmGameMsgTunnel.TunnelMsgStream;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class abmb
  implements Handler.Callback, CmGameSocketConnection.a, INetInfoHandler
{
  private abmb.a jdField_a_of_type_Abmb$a;
  private CmGameSocketConnection jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection;
  private AtomicInteger aW = new AtomicInteger(0);
  private volatile boolean bDQ;
  private volatile boolean ch;
  private int cpS;
  private long gR;
  private auru l = new auru(Looper.getMainLooper(), this);
  private QQAppInterface mApp;
  private List<String> wn = new ArrayList();
  
  public abmb(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApplication(), this);
    try
    {
      this.gR = Long.parseLong(paramQQAppInterface.getCurrentAccountUin());
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("CmGameConnManager", 1, "parse uin exception=", paramQQAppInterface);
    }
  }
  
  private boolean YC()
  {
    QLog.d("CmGameConnManager", 1, "[createConnection]");
    if (this.jdField_a_of_type_Abmb$a == null)
    {
      QLog.e("CmGameConnManager", 1, "[createConnection] no connection info");
      return false;
    }
    if ((this.jdField_a_of_type_Abmb$a.ipList == null) || (this.jdField_a_of_type_Abmb$a.ipList.size() == 0))
    {
      QLog.e("CmGameConnManager", 1, "[createConnection] no connection host");
      return false;
    }
    CmGameSocketConnection.c localc = new CmGameSocketConnection.c();
    localc.ipList = this.jdField_a_of_type_Abmb$a.ipList;
    localc.port = this.jdField_a_of_type_Abmb$a.port;
    localc.readTimeout = 10000;
    localc.connectionTimeout = 3000;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection = new CmGameSocketConnection(localc);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection.a(this);
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection.open();
      return true;
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection.a(localc);
    }
  }
  
  private void a(CmGameMsgTunnel.TunnelMsgStream paramTunnelMsgStream)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConnManager", 2, "[handleCmGameMsgRsp]");
    }
  }
  
  private byte[] a(short paramShort, String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Abmb$a == null)
    {
      QLog.w("CmGameConnManager", 1, "[encodeMsgStream] no conn info");
      return null;
    }
    Object localObject = new CmGameMsgTunnel.TunnelMsgStream();
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).platform.set(109L);
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).osver.set(Build.VERSION.RELEASE);
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).mqqver.set("3.4.4");
    if (!TextUtils.isEmpty(paramString)) {
      ((CmGameMsgTunnel.TunnelMsgStream)localObject).cmd.set(paramString);
    }
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).seq.set(this.aW.getAndIncrement());
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).distribute_ts.set(this.jdField_a_of_type_Abmb$a.ts);
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).src_uid.set(this.gR);
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).dst_uid.set(paramLong);
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).sign.set(this.jdField_a_of_type_Abmb$a.sign);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      ((CmGameMsgTunnel.TunnelMsgStream)localObject).busi_buff.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    paramString = ((CmGameMsgTunnel.TunnelMsgStream)localObject).toByteArray();
    try
    {
      paramString = abmt.c(paramString, this.jdField_a_of_type_Abmb$a.aesKey);
      paramArrayOfByte = ByteBuffer.allocate(23);
      paramArrayOfByte.order(ByteOrder.BIG_ENDIAN);
      paramArrayOfByte.putInt(439041101);
      paramArrayOfByte.put((byte)1);
      paramArrayOfByte.putShort(paramShort);
      paramArrayOfByte.putInt(paramString.length);
      paramArrayOfByte.putInt(2);
      paramArrayOfByte.putLong(this.gR);
      paramArrayOfByte = paramArrayOfByte.array();
      localObject = new byte[paramString.length + 23];
      System.arraycopy(paramArrayOfByte, 0, localObject, 0, paramArrayOfByte.length);
      System.arraycopy(paramString, 0, localObject, 23, paramString.length);
      return localObject;
    }
    catch (Exception paramString)
    {
      QLog.w("CmGameConnManager", 1, "[encodeMsgStream] encrypt exception");
    }
    return null;
  }
  
  private byte[] a(short paramShort, String paramString, byte[] paramArrayOfByte)
  {
    return a(paramShort, paramString, 0L, paramArrayOfByte);
  }
  
  private void b(CmGameMsgTunnel.TunnelMsgStream paramTunnelMsgStream)
  {
    ((abhh)this.mApp.getManager(153)).a().b(paramTunnelMsgStream);
  }
  
  private void closeConnection()
  {
    try
    {
      this.bDQ = false;
      this.cpS = 0;
      QLog.d("CmGameConnManager", 1, "[closeConnection]");
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection.destroy();
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void disconnect()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection.isConnected())) {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection.DQ(false);
    }
  }
  
  private void openConnection()
  {
    for (;;)
    {
      try
      {
        QLog.d("CmGameConnManager", 1, "[openConnection]");
        this.bDQ = true;
        if ((isConnected()) || (this.ch))
        {
          QLog.d("CmGameConnManager", 1, new Object[] { "[openConnection] already connected or connecting, mIsConnecting=", Boolean.valueOf(this.ch) });
          return;
        }
        this.ch = true;
        if (!aqiw.bW(BaseApplicationImpl.getApplication().getApplicationContext()))
        {
          QLog.d("CmGameConnManager", 1, "[openConnection] network unavailable");
          this.ch = false;
        }
        else
        {
          ((aqrb)this.mApp.getBusinessHandler(71)).efh();
        }
      }
      finally {}
    }
  }
  
  private void reconnect()
  {
    try
    {
      QLog.d("CmGameConnManager", 1, new Object[] { "[reconnect] mShouldKeepConnect=", Boolean.valueOf(this.bDQ) });
      disconnect();
      if (this.bDQ)
      {
        this.aW.set(0);
        openConnection();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void BX(String paramString)
  {
    try
    {
      if (!this.wn.contains(paramString)) {
        this.wn.add(paramString);
      }
      QLog.d("CmGameConnManager", 1, new Object[] { "[onCmGamePageEnter] tag=", paramString, ", size=", Integer.valueOf(this.wn.size()) });
      this.l.removeMessages(2);
      if (!isConnected())
      {
        this.l.removeMessages(1);
        this.l.sendEmptyMessage(1);
      }
      return;
    }
    finally {}
  }
  
  public void BY(String paramString)
  {
    try
    {
      this.wn.remove(paramString);
      QLog.d("CmGameConnManager", 1, new Object[] { "[onCmGamePageLeave] tag=", paramString, ", size=", Integer.valueOf(this.wn.size()) });
      if (this.wn.size() == 0)
      {
        this.l.removeMessages(1);
        this.l.removeMessages(2);
        this.l.sendEmptyMessageDelayed(2, 2000L);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void DN(boolean paramBoolean)
  {
    boolean bool = aqiw.bW(BaseApplicationImpl.getApplication().getApplicationContext());
    QLog.d("CmGameConnManager", 1, new Object[] { "[onDisconnect] shouldReconnect=", Boolean.valueOf(paramBoolean), ", networkAvailable=", Boolean.valueOf(bool) });
    if ((paramBoolean) && (bool)) {
      reconnect();
    }
  }
  
  public byte[] O()
  {
    return a((short)1, "heartbeat", null);
  }
  
  public void a(abmb.a parama)
  {
    QLog.d("CmGameConnManager", 1, "[onGetConnInfoSuccess]");
    if (parama == null) {
      QLog.e("CmGameConnManager", 1, "[onGetConnInfoSuccess] gameConnInfo null");
    }
    for (;;)
    {
      return;
      if (this.bDQ) {
        this.jdField_a_of_type_Abmb$a = parama;
      }
      for (boolean bool = YC(); !bool; bool = false)
      {
        this.ch = false;
        return;
      }
    }
  }
  
  public void a(MsfSocketInputBuffer paramMsfSocketInputBuffer)
  {
    if (paramMsfSocketInputBuffer == null)
    {
      QLog.e("CmGameConnManager", 1, "[receive] buffer null");
      return;
    }
    int i = paramMsfSocketInputBuffer.getBufferlen();
    if (i <= 23)
    {
      QLog.e("CmGameConnManager", 1, "[receive] invalid buffer length");
      return;
    }
    Object localObject = ByteBuffer.wrap(paramMsfSocketInputBuffer.getBuffer(), 0, 23);
    int j = ((ByteBuffer)localObject).getInt();
    if (j != 439041101)
    {
      QLog.e("CmGameConnManager", 1, "[receive] invalid magic");
      return;
    }
    byte b = ((ByteBuffer)localObject).get();
    short s = ((ByteBuffer)localObject).getShort();
    int k = ((ByteBuffer)localObject).getInt();
    int m = ((ByteBuffer)localObject).getInt();
    long l1 = ((ByteBuffer)localObject).getLong();
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConnManager", 2, new Object[] { "[receive] header, magic=", Integer.valueOf(j), ", protocolVersion=", Byte.valueOf(b), ", type=", Short.valueOf(s), ", appid=", Integer.valueOf(m), ", bodyLength=", Integer.valueOf(k), ", srcUin=", Long.valueOf(l1) });
    }
    if (s == 6)
    {
      QLog.e("CmGameConnManager", 1, "[receive] invalid key");
      this.l.removeMessages(5);
      paramMsfSocketInputBuffer = this.l.obtainMessage(5);
      paramMsfSocketInputBuffer.obj = Boolean.valueOf(true);
      this.l.sendMessage(paramMsfSocketInputBuffer);
      return;
    }
    localObject = new byte[i - 23];
    System.arraycopy(paramMsfSocketInputBuffer.getBuffer(), 23, localObject, 0, i - 23);
    try
    {
      paramMsfSocketInputBuffer = abmt.d((byte[])localObject, this.jdField_a_of_type_Abmb$a.aesKey);
      localObject = new CmGameMsgTunnel.TunnelMsgStream();
      ((CmGameMsgTunnel.TunnelMsgStream)localObject).mergeFrom(paramMsfSocketInputBuffer);
      if (s == 3)
      {
        a((CmGameMsgTunnel.TunnelMsgStream)localObject);
        return;
      }
    }
    catch (Exception paramMsfSocketInputBuffer)
    {
      QLog.e("CmGameConnManager", 1, "[receive] get pb failed, e=", paramMsfSocketInputBuffer);
      return;
    }
    if (s == 4)
    {
      b((CmGameMsgTunnel.TunnelMsgStream)localObject);
      return;
    }
    if (s == 2)
    {
      QLog.d("CmGameConnManager", 1, new Object[] { "[receive] error, code=", Integer.valueOf(((CmGameMsgTunnel.TunnelMsgStream)localObject).ret.get()) });
      return;
    }
    QLog.e("CmGameConnManager", 1, new Object[] { "[receive] stream type not support yet, streamType=", Short.valueOf(s) });
  }
  
  public void bq(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConnManager", 2, new Object[] { "[updateMatchWebPageStatus] isAlive=", Boolean.valueOf(paramBoolean1), ", wakeup=", Boolean.valueOf(paramBoolean2) });
    }
    if (paramBoolean1)
    {
      this.l.removeMessages(7);
      this.l.sendEmptyMessageDelayed(7, 130000L);
      BX("page_tag_match");
      if ((isConnected()) && (paramBoolean2)) {
        wakeup();
      }
      return;
    }
    BY("page_tag_match");
    this.l.removeMessages(7);
  }
  
  public void cDb()
  {
    QLog.d("CmGameConnManager", 1, new Object[] { "[onGetConnInfoFailed] mShouldKeepConnect=", Boolean.valueOf(this.bDQ), ", mConnInfo=", this.jdField_a_of_type_Abmb$a });
    if ((this.bDQ) && (this.jdField_a_of_type_Abmb$a != null)) {}
    for (boolean bool = YC();; bool = false)
    {
      if (!bool) {
        this.ch = false;
      }
      return;
    }
  }
  
  public void cDc()
  {
    QLog.d("CmGameConnManager", 1, "[onConnectSuccess]");
    this.ch = false;
  }
  
  public void cDd()
  {
    QLog.d("CmGameConnManager", 1, new Object[] { "[onConnectFailed] mRetryCounter=", Integer.valueOf(this.cpS), ", mShouldKeepConnect=", Boolean.valueOf(this.bDQ) });
    this.ch = false;
    if ((this.bDQ) && (this.cpS <= 2))
    {
      this.cpS += 1;
      this.l.removeMessages(1);
      this.l.sendEmptyMessageDelayed(1, 10000L);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 3: 
    default: 
      return false;
    case 1: 
      QLog.d("CmGameConnManager", 1, "[handleMessage] MSG_OPEN_CONNECTION");
      openConnection();
      return false;
    case 2: 
      QLog.d("CmGameConnManager", 1, "[handleMessage] MSG_CLOSE_CONNECTION");
      closeConnection();
      return false;
    case 4: 
      QLog.d("CmGameConnManager", 1, "[handleMessage] MSG_DISCONNECT");
      disconnect();
      return false;
    case 5: 
      QLog.d("CmGameConnManager", 1, "[handleMessage] MSG_RECONNECT");
      if ((paramMessage.obj != null) && (((Boolean)paramMessage.obj).booleanValue()))
      {
        QLog.d("CmGameConnManager", 1, "[handleMessage] MSG_RECONNECT, reset conn info");
        this.jdField_a_of_type_Abmb$a = null;
      }
      reconnect();
      return false;
    case 7: 
      QLog.w("CmGameConnManager", 1, "[handleMessage] MSG_CHECK_MATCH_PAGE_REPORT_TIMEOUT");
      BY("page_tag_match");
      return false;
    }
    QQToast.a(BaseApplicationImpl.getContext(), (String)paramMessage.obj, 0).show();
    return false;
  }
  
  public boolean isConnected()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection.isConnected());
  }
  
  public void onDestroy()
  {
    QLog.d("CmGameConnManager", 1, "[onDestroy]");
    this.l.removeCallbacksAndMessages(null);
    closeConnection();
    AppNetConnInfo.unregisterNetInfoHandler(this);
  }
  
  public void onNetMobile2None()
  {
    QLog.d("CmGameConnManager", 1, "[onNetMobile2None]");
    this.l.removeMessages(4);
    this.l.sendEmptyMessage(4);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    QLog.d("CmGameConnManager", 1, "[onNetMobile2Wifi]");
    this.l.removeMessages(5);
    this.l.sendEmptyMessage(5);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    QLog.d("CmGameConnManager", 1, "[onNetNone2Mobile]");
    this.l.removeMessages(5);
    this.l.sendEmptyMessage(5);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    QLog.d("CmGameConnManager", 1, "[onNetNone2Wifi]");
    this.l.removeMessages(5);
    this.l.sendEmptyMessage(5);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    QLog.d("CmGameConnManager", 1, "[onNetWifi2Mobile]");
    this.l.removeMessages(5);
    this.l.sendEmptyMessage(5);
  }
  
  public void onNetWifi2None()
  {
    QLog.d("CmGameConnManager", 1, "[onNetWifi2None]");
    this.l.removeMessages(4);
    this.l.sendEmptyMessage(4);
  }
  
  public void wakeup()
  {
    QLog.d("CmGameConnManager", 1, "[wakeup]");
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection.isConnected())) {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameSocketConnection.wakeup();
    }
  }
  
  public static class a
  {
    public String aesKey;
    public List<String> ipList;
    public int port;
    public String sign;
    public long ts;
    
    public a(List<String> paramList, int paramInt, String paramString1, long paramLong, String paramString2)
    {
      this.ipList = paramList;
      this.port = paramInt;
      this.aesKey = paramString1;
      this.ts = paramLong;
      this.sign = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abmb
 * JD-Core Version:    0.7.0.1
 */