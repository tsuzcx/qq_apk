import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.conn.ConnManager.1;
import com.tencent.mobileqq.richmedia.conn.ConnManager.2;
import com.tencent.mobileqq.richmedia.conn.ConnManager.3;
import com.tencent.mobileqq.richmedia.conn.ConnManager.4;
import com.tencent.mobileqq.richmedia.conn.LiteTcpConnection;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class alyi
  implements alyl
{
  private static String TAG = "PeakAudioTransHandler ConnManager";
  protected ConcurrentLinkedQueue<byte[]> F = new ConcurrentLinkedQueue();
  private alyj jdField_a_of_type_Alyj;
  private alyk jdField_a_of_type_Alyk;
  private ambx jdField_a_of_type_Ambx;
  private AppInterface mApp;
  private Handler mMainHandler;
  private ArrayList<alyj> zd = new ArrayList();
  
  public alyi(AppInterface paramAppInterface, ambx paramambx)
  {
    this.mApp = paramAppInterface;
    this.jdField_a_of_type_Ambx = paramambx;
    this.mMainHandler = new Handler(Looper.getMainLooper());
  }
  
  private void kS(long paramLong)
  {
    this.mMainHandler.post(new ConnManager.4(this, paramLong));
  }
  
  public void a(long paramLong, alyk paramalyk)
  {
    if (QLog.isColorLevel()) {
      QLog.e(TAG, 2, "onDisConnect connId = " + paramLong + ",sendDataQueue size =" + this.F.size() + " mTCPstate =" + this.jdField_a_of_type_Ambx.Ix());
    }
    this.jdField_a_of_type_Ambx.Um(10);
    this.jdField_a_of_type_Alyj = null;
    this.F.clear();
    this.zd.clear();
    if (this.jdField_a_of_type_Ambx.avq())
    {
      ((amby)this.mApp.getBusinessHandler(0)).a(String.valueOf(paramLong), "TransInfo.ExitSession", null, 0, 0, false);
      return;
    }
    QLog.e(TAG, 1, "onDisConnect : session not open need not sso exit");
  }
  
  public void a(alyj paramalyj, long paramLong)
  {
    if (paramalyj == null) {
      QLog.e(TAG, 1, "openNewConnection : endPoint is null");
    }
    do
    {
      return;
      if ((TextUtils.isEmpty(paramalyj.host)) || (paramalyj.port == 0))
      {
        QLog.e(TAG, 1, "openNewConnection : endPoint is illegal");
        return;
      }
      if (!this.jdField_a_of_type_Ambx.avq())
      {
        QLog.e(TAG, 1, "openNewConnection : Session not Open");
        return;
      }
      if (!this.jdField_a_of_type_Ambx.avv())
      {
        QLog.e(TAG, 1, "openNewConnection : TCP not Close mTCPstate =" + this.jdField_a_of_type_Ambx.Ix());
        return;
      }
      QLog.d(TAG, 1, "openNewConnection : host:" + paramalyj.host + ",port=" + paramalyj.port);
      this.jdField_a_of_type_Alyj = paramalyj;
      if (this.jdField_a_of_type_Alyk != null) {
        this.jdField_a_of_type_Alyk.disConnect();
      }
      this.jdField_a_of_type_Alyk = new LiteTcpConnection(this, paramLong, paramalyj, 3000, 10000);
    } while (this.jdField_a_of_type_Alyk == null);
    this.jdField_a_of_type_Alyk.a(this);
    this.jdField_a_of_type_Alyk.connect();
    this.jdField_a_of_type_Ambx.Um(11);
  }
  
  public void a(boolean paramBoolean, long paramLong, alyk paramalyk, alyj paramalyj, int paramInt)
  {
    int j = 0;
    paramalyk = (amby)this.mApp.getBusinessHandler(0);
    if (paramalyj == null)
    {
      QLog.e(TAG, 2, "onConnect failed ep = null return");
      kS(paramLong);
    }
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        this.mMainHandler.post(new ConnManager.1(this, paramalyk, paramLong, paramalyj));
        return;
      }
      paramalyk = paramalyj.host;
      int i = paramalyj.port;
      if ((this.jdField_a_of_type_Alyj == null) || (!paramalyk.equals(this.jdField_a_of_type_Alyj.host)) || (i != this.jdField_a_of_type_Alyj.port))
      {
        QLog.e(TAG, 2, "onConnect ip or port changed ");
        kS(paramLong);
        return;
      }
      if (!this.jdField_a_of_type_Ambx.avx())
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, "onConnect reConnect state legal lSessionID = " + paramLong);
        }
        kS(paramLong);
        return;
      }
      if (!this.jdField_a_of_type_Ambx.avu())
      {
        QLog.e(TAG, 1, "onConnect : TCP not in Opening state = " + this.jdField_a_of_type_Ambx.Ix());
        kT(paramLong);
        return;
      }
      if (this.jdField_a_of_type_Alyj.dAi >= 1)
      {
        QLog.d(TAG, 2, "reConnect > 1 return");
        paramInt = 0;
        for (;;)
        {
          i = j;
          if (paramInt < this.zd.size())
          {
            paramalyk = (alyj)this.zd.get(paramInt);
            if ((paramalyk != this.jdField_a_of_type_Alyj) && (paramalyk.dAi == 0))
            {
              this.jdField_a_of_type_Alyj = paramalyk;
              i = 1;
            }
          }
          else
          {
            if (i == 0) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "onConnect failed change ip new ip = " + this.jdField_a_of_type_Alyj.host + ", port =" + this.jdField_a_of_type_Alyj.port);
            }
            a(this.jdField_a_of_type_Alyj, paramLong);
            return;
          }
          paramInt += 1;
        }
        QLog.e(TAG, 2, "onConnect  not ip notify  connect failed ");
        kS(paramLong);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onConnect failed reconnect ip = " + this.jdField_a_of_type_Alyj.host + ", port =" + this.jdField_a_of_type_Alyj.port);
      }
      if (paramInt == 3) {
        this.mMainHandler.postDelayed(new ConnManager.2(this, paramLong), 2000L);
      }
      while (this.jdField_a_of_type_Alyj != null)
      {
        paramalyk = this.jdField_a_of_type_Alyj;
        paramalyk.dAi += 1;
        return;
        this.mMainHandler.post(new ConnManager.3(this, paramLong));
      }
    }
  }
  
  public void br(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      this.F.add(paramArrayOfByte);
    }
    if (this.jdField_a_of_type_Alyk != null) {
      this.jdField_a_of_type_Alyk.wakeupChannel();
    }
  }
  
  public void eM(ArrayList<alyj> paramArrayList)
  {
    this.zd.clear();
    this.zd.addAll(paramArrayList);
  }
  
  public byte[] getData()
  {
    if (!this.F.isEmpty()) {
      return (byte[])this.F.poll();
    }
    return null;
  }
  
  public boolean hasNet()
  {
    return aqiw.bW(this.mApp.getApp().getApplicationContext());
  }
  
  public void kT(long paramLong)
  {
    if (this.jdField_a_of_type_Alyk != null)
    {
      if (!this.jdField_a_of_type_Ambx.avt()) {
        QLog.e(TAG, 1, "closeConnection : TCP not opened  mTCPstate =" + this.jdField_a_of_type_Ambx.Ix());
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Ambx.Um(13);
    this.jdField_a_of_type_Alyk.disConnect();
    this.jdField_a_of_type_Alyk = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alyi
 * JD-Core Version:    0.7.0.1
 */