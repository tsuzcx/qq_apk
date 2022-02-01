import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.av.VideoConstants.EmShareState;
import com.tencent.av.app.VideoObserver.1;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.av.service.RecvMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

public class iiz
  implements Observer
{
  Handler mHandler = null;
  
  private void n(Object[] paramArrayOfObject)
  {
    int j = -1;
    try
    {
      i = Integer.parseInt(String.valueOf(paramArrayOfObject[1]));
      int k = Integer.parseInt(String.valueOf(paramArrayOfObject[2]));
      j = k;
    }
    catch (NumberFormatException paramArrayOfObject)
    {
      for (;;)
      {
        paramArrayOfObject.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("VideoObserver", 2, "Data transfer error", paramArrayOfObject);
        }
        int i = -5;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoObserver", 2, String.format("Before send, ivrRequestSeq = %d", new Object[] { Integer.valueOf(j) }));
    }
    bu(i, j);
  }
  
  private void o(Object[] paramArrayOfObject)
  {
    int i = -1;
    str = "";
    try
    {
      j = Integer.parseInt(String.valueOf(paramArrayOfObject[1]));
      i = j;
      int k = Integer.parseInt(String.valueOf(paramArrayOfObject[2]));
      i = j;
      paramArrayOfObject = String.valueOf(paramArrayOfObject[3]);
      i = j;
      j = k;
    }
    catch (NumberFormatException paramArrayOfObject)
    {
      for (;;)
      {
        paramArrayOfObject.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("VideoObserver", 2, "Data transfer error", paramArrayOfObject);
        }
        int j = -4;
        paramArrayOfObject = str;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoObserver", 2, String.format("Receive request ivrRequestSeq = %d, errorCode = %d, errorMsg = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramArrayOfObject }));
    }
    f(i, j, paramArrayOfObject);
  }
  
  private void p(Object[] paramArrayOfObject)
  {
    j = -1;
    long l1 = -1L;
    String str3 = "";
    String str4 = "";
    int i = j;
    String str2 = str3;
    String str1 = str4;
    try
    {
      int k = Integer.parseInt(String.valueOf(paramArrayOfObject[1]));
      i = j;
      str2 = str3;
      str1 = str4;
      j = Integer.parseInt(String.valueOf(paramArrayOfObject[2]));
      i = j;
      str2 = str3;
      str1 = str4;
      str3 = String.valueOf(paramArrayOfObject[3]);
      i = j;
      str2 = str3;
      str1 = str4;
      str4 = String.valueOf(paramArrayOfObject[4]);
      i = j;
      str2 = str3;
      str1 = str4;
      long l2 = Long.parseLong(String.valueOf(paramArrayOfObject[5]));
      l1 = l2;
      str1 = str4;
      str2 = str3;
      i = j;
      j = k;
    }
    catch (NumberFormatException paramArrayOfObject)
    {
      for (;;)
      {
        paramArrayOfObject.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("VideoObserver", 2, "Data transfer error", paramArrayOfObject);
        }
        j = -3;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoObserver", 2, String.format("Get data from VideoController, errorCode = %d, seq = %d, url = %s, str = %s, roomId = %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), str2, str1, Long.valueOf(l1) }));
    }
    a(j, i, str2, str1, l1);
  }
  
  protected void G(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void H(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void I(Object paramObject)
  {
    int j = -1;
    if (paramObject == null) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    switch (((Integer)arrayOfObject[0]).intValue())
    {
    case 0: 
    case 10002: 
    default: 
      return;
    case 10: 
      onServiceConnected();
      return;
    case 32: 
      if (arrayOfObject.length > 2) {
        j = ((Integer)arrayOfObject[1]).intValue();
      }
      break;
    }
    for (int i = ((Integer)arrayOfObject[2]).intValue();; i = -1)
    {
      m(jlc.a(arrayOfObject, 3), j, i);
      return;
      onServiceDisconnected();
      return;
      a((RecvMsg)arrayOfObject[1]);
      return;
      bQ(jlc.a(arrayOfObject, 1));
      return;
      i = ((Integer)arrayOfObject[1]).intValue();
      paramObject = null;
      if (arrayOfObject.length > 2) {
        paramObject = (String)arrayOfObject[2];
      }
      c(jlc.a(arrayOfObject, 3), i, paramObject);
      return;
      amT();
      return;
      bR(jlc.a(arrayOfObject, 1));
      return;
      amU();
      return;
      amV();
      return;
      iB((String)arrayOfObject[1]);
      return;
      k(((Long)arrayOfObject[1]).longValue(), ((Long)arrayOfObject[2]).longValue(), ((Long)arrayOfObject[3]).longValue());
      return;
      j(((Long)arrayOfObject[1]).longValue(), ((Long)arrayOfObject[2]).longValue(), ((Long)arrayOfObject[3]).longValue());
      return;
      amW();
      return;
      kn(((Integer)arrayOfObject[1]).intValue());
      return;
      kJ(((Integer)arrayOfObject[1]).intValue());
      return;
      G(true, ((Boolean)arrayOfObject[1]).booleanValue());
      return;
      G(false, ((Boolean)arrayOfObject[1]).booleanValue());
      return;
      hF(((Boolean)arrayOfObject[1]).booleanValue());
      return;
      boolean bool = ((Boolean)arrayOfObject[1]).booleanValue();
      q(jlc.a(arrayOfObject, 2), bool);
      return;
      iC((String)arrayOfObject[1]);
      return;
      iD((String)arrayOfObject[1]);
      return;
      String str = (String)arrayOfObject[1];
      bool = ((Boolean)arrayOfObject[2]).booleanValue();
      paramObject = str;
      if (TextUtils.isEmpty(str)) {
        paramObject = "";
      }
      U(paramObject, bool);
      return;
      amY();
      return;
      str = (String)arrayOfObject[1];
      for (;;)
      {
        for (;;)
        {
          try
          {
            if ((arrayOfObject.length <= 2) || (arrayOfObject[2] == null) || (!(arrayOfObject[2] instanceof String))) {
              break label1761;
            }
            paramObject = (String)arrayOfObject[2];
          }
          catch (Exception paramObject)
          {
            paramObject = null;
            continue;
          }
          aR(str, paramObject);
          return;
          try
          {
            if ((arrayOfObject.length <= 1) || (arrayOfObject[1] == null) || (!(arrayOfObject[1] instanceof String))) {
              break;
            }
            paramObject = (String)arrayOfObject[1];
            a(jlc.a(arrayOfObject, 2), paramObject, true);
            return;
          }
          catch (Exception paramObject)
          {
            return;
          }
        }
        W(((Integer)arrayOfObject[1]).intValue(), (String)arrayOfObject[2]);
        return;
        p(arrayOfObject);
        return;
        n(arrayOfObject);
        return;
        o(arrayOfObject);
        return;
        bool = ((Boolean)arrayOfObject[2]).booleanValue();
        V((String)arrayOfObject[1], bool);
        return;
        bv(((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
        return;
        amZ();
        return;
        ana();
        return;
        i = ((Integer)arrayOfObject[1]).intValue();
        r(jlc.a(arrayOfObject, 2), i);
        return;
        onFinish((String)arrayOfObject[1], ((Boolean)arrayOfObject[2]).booleanValue());
        return;
        a(((Boolean)arrayOfObject[1]).booleanValue(), ((Long)arrayOfObject[2]).longValue(), ((Integer)arrayOfObject[3]).intValue(), ((Integer)arrayOfObject[4]).intValue(), ((Integer)arrayOfObject[5]).intValue(), (String)arrayOfObject[6]);
        return;
        onFinish(((Long)arrayOfObject[1]).longValue());
        return;
        f((String)arrayOfObject[1], (Bitmap)arrayOfObject[2]);
        return;
        paramObject = (String)arrayOfObject[1];
        bool = ((Boolean)arrayOfObject[2]).booleanValue();
        b(jlc.a(arrayOfObject, 3), paramObject, bool);
        return;
        amX();
        return;
        iE((String)arrayOfObject[1]);
        return;
        ic((String)arrayOfObject[1]);
        return;
        id((String)arrayOfObject[1]);
        return;
        ie((String)arrayOfObject[1]);
        return;
        b((String)arrayOfObject[1], ((Long)arrayOfObject[2]).longValue(), (byte[])arrayOfObject[3]);
        return;
        b((RecvGVideoLevelInfo[])arrayOfObject[1]);
        return;
        in((String)arrayOfObject[1]);
        return;
        T((String)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
        return;
        U((String)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
        return;
        J(paramObject);
        return;
        d(((Boolean)arrayOfObject[1]).booleanValue(), (String)arrayOfObject[2], (String)arrayOfObject[3], (String)arrayOfObject[4]);
        return;
        ia(((Boolean)arrayOfObject[1]).booleanValue());
        return;
        ib(((Boolean)arrayOfObject[1]).booleanValue());
        return;
        anb();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("VideoObserver", 1, "WL_DEBUG VideoConstants.TYPE_NOTIFY_REDPACKET_FLOATWINDOW_ANIMATION");
        }
        H(((Boolean)arrayOfObject[1]).booleanValue(), ((Boolean)arrayOfObject[2]).booleanValue());
        return;
        f((byte[])arrayOfObject[2], ((Integer)arrayOfObject[3]).intValue(), ((Integer)arrayOfObject[4]).intValue());
        return;
        kt(((Integer)arrayOfObject[1]).intValue());
        return;
        bt(((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
        return;
        a((VideoConstants.EmShareState)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue(), ((Integer)arrayOfObject[3]).intValue(), ((Long)arrayOfObject[4]).longValue(), ((Integer)arrayOfObject[5]).intValue());
        return;
        i(((Integer)arrayOfObject[1]).intValue(), ((Long)arrayOfObject[2]).longValue(), ((Integer)arrayOfObject[3]).intValue());
        return;
        label1761:
        paramObject = null;
      }
    }
  }
  
  protected void J(Object paramObject) {}
  
  protected void T(String paramString, int paramInt) {}
  
  protected void U(String paramString, int paramInt) {}
  
  protected void U(String paramString, boolean paramBoolean) {}
  
  protected void V(String paramString, boolean paramBoolean) {}
  
  protected void W(int paramInt, String paramString) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong) {}
  
  protected void a(long paramLong, String paramString, boolean paramBoolean) {}
  
  public void a(VideoConstants.EmShareState paramEmShareState, int paramInt1, int paramInt2, long paramLong, int paramInt3) {}
  
  protected void a(RecvMsg paramRecvMsg) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  protected void aR(String paramString1, String paramString2) {}
  
  protected void amT() {}
  
  protected void amU() {}
  
  protected void amV() {}
  
  protected void amW() {}
  
  protected void amX() {}
  
  protected void amY() {}
  
  protected void amZ() {}
  
  protected void ana() {}
  
  protected void anb() {}
  
  protected void b(long paramLong, String paramString, boolean paramBoolean) {}
  
  protected void b(String paramString, long paramLong, byte[] paramArrayOfByte) {}
  
  protected void b(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo) {}
  
  protected void bQ(long paramLong) {}
  
  protected void bR(long paramLong) {}
  
  protected void bt(int paramInt1, int paramInt2) {}
  
  protected void bu(int paramInt1, int paramInt2) {}
  
  protected void bv(int paramInt1, int paramInt2) {}
  
  protected void c(long paramLong, int paramInt, String paramString) {}
  
  protected void d(boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  protected void f(int paramInt1, int paramInt2, String paramString) {}
  
  protected void f(String paramString, Bitmap paramBitmap) {}
  
  protected void f(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  protected void hF(boolean paramBoolean) {}
  
  public void i(int paramInt1, long paramLong, int paramInt2) {}
  
  protected void iB(String paramString) {}
  
  protected void iC(String paramString) {}
  
  protected void iD(String paramString) {}
  
  protected void iE(String paramString) {}
  
  protected void ia(boolean paramBoolean) {}
  
  protected void ib(boolean paramBoolean) {}
  
  protected void ic(String paramString) {}
  
  protected void id(String paramString) {}
  
  protected void ie(String paramString) {}
  
  protected void in(String paramString) {}
  
  protected void j(long paramLong1, long paramLong2, long paramLong3) {}
  
  protected void k(long paramLong1, long paramLong2, long paramLong3) {}
  
  protected void kJ(int paramInt) {}
  
  protected void kn(int paramInt) {}
  
  protected void kt(int paramInt) {}
  
  protected void m(long paramLong, int paramInt1, int paramInt2) {}
  
  protected void onFinish(long paramLong) {}
  
  protected void onFinish(String paramString, boolean paramBoolean) {}
  
  protected void onServiceConnected() {}
  
  protected void onServiceDisconnected() {}
  
  protected void q(long paramLong, boolean paramBoolean) {}
  
  protected void r(long paramLong, int paramInt) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.mHandler == null) {
        this.mHandler = new Handler(paramObservable);
      }
      this.mHandler.post(new VideoObserver.1(this, paramObject));
      return;
    }
    I(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iiz
 * JD-Core Version:    0.7.0.1
 */