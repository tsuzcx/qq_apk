import android.os.Handler;
import android.os.Looper;
import com.tencent.av.VideoController.b;
import com.tencent.av.app.GAudioUIObserver.1;
import com.tencent.av.service.RecvMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class iid
  implements Observer
{
  Handler mHandler = null;
  
  protected void A(long paramLong1, long paramLong2) {}
  
  protected void B(long paramLong1, long paramLong2) {}
  
  public void I(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    long l1;
    long l2;
    int j;
    switch (i)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("qav.GAudioUIObserver", 2, "OnUpdate-->Wrong notify type.Type = " + i);
      }
      return;
    case 10: 
      onServiceConnected();
      return;
    case 12: 
      a((RecvMsg)paramObject[1]);
      return;
    case 61: 
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue(), ((Boolean)paramObject[4]).booleanValue());
      return;
    case 62: 
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue());
      return;
    case 69: 
      A(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
      return;
    case 70: 
      l1 = ((Long)paramObject[1]).longValue();
      l2 = ((Long)paramObject[2]).longValue();
      i = ((Integer)paramObject[3]).intValue();
      a(jlc.a(paramObject, 4), l1, l2, i);
      return;
    case 77: 
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), true, ((Boolean)paramObject[3]).booleanValue());
      return;
    case 78: 
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), false, ((Boolean)paramObject[3]).booleanValue());
      return;
    case 90: 
    case 91: 
    case 92: 
    case 93: 
    case 94: 
    case 95: 
      l1 = ((Long)paramObject[1]).longValue();
      l2 = ((Long)paramObject[2]).longValue();
      long l3 = ((Long)paramObject[3]).longValue();
      j = ((Integer)paramObject[4]).intValue();
      a(jlc.a(paramObject, 5), i, l1, l2, l3, j);
      return;
    case 96: 
    case 97: 
    case 98: 
      l1 = ((Long)paramObject[1]).longValue();
      l2 = ((Long)paramObject[2]).longValue();
      j = ((Integer)paramObject[3]).intValue();
      a(jlc.a(paramObject, 4), i, 0L, l1, l2, j);
      return;
    case 63: 
      a(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue(), ((Integer)paramObject[4]).intValue());
      return;
    case 64: 
      b(((Long)paramObject[1]).longValue(), (ArrayList)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
      return;
    case 66: 
      bG(((Long)paramObject[1]).longValue());
      return;
    case 202: 
      l(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue());
      return;
    case 67: 
      n(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
      return;
    case 68: 
      o(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
      return;
    case 21: 
      kn(((Integer)paramObject[1]).intValue());
      return;
    case 79: 
      c(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 80: 
      l1 = ((Long)paramObject[1]).longValue();
      z(jlc.a(paramObject, 2), l1);
      return;
    case 83: 
      l1 = ((Long)paramObject[1]).longValue();
      y(jlc.a(paramObject, 2), l1);
      return;
    case 99: 
      amy();
      return;
    case 200: 
      k(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 81: 
      p(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
      return;
    case 82: 
      b((String)paramObject[1], (String[])paramObject[2]);
      return;
    case 84: 
      amz();
      return;
    case 85: 
      g(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 86: 
      h(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 87: 
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
      return;
    case 71: 
      l1 = ((Long)paramObject[1]).longValue();
      i = ((Integer)paramObject[2]).intValue();
      a(l1, ((Long)paramObject[3]).longValue(), i, true);
      return;
    case 72: 
      l1 = ((Long)paramObject[1]).longValue();
      i = ((Integer)paramObject[2]).intValue();
      a(l1, ((Long)paramObject[3]).longValue(), i, false);
      return;
    case 73: 
      l1 = ((Long)paramObject[1]).longValue();
      l2 = ((Long)paramObject[2]).longValue();
      i = ((Integer)paramObject[3]).intValue();
      a(jlc.a(paramObject, 4), l1, l2, i, true);
      return;
    case 74: 
      l1 = ((Long)paramObject[1]).longValue();
      l2 = ((Long)paramObject[2]).longValue();
      i = ((Integer)paramObject[3]).intValue();
      a(jlc.a(paramObject, 4), l1, l2, i, false);
      return;
    case 88: 
      l(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 89: 
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), (String)paramObject[3]);
      return;
    case 138: 
      a(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Boolean)paramObject[4]).booleanValue());
      return;
    case 139: 
      a(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue());
      return;
    case 140: 
      m(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
      return;
    case 141: 
      by((ArrayList)paramObject[1]);
      return;
    case 142: 
      q((ArrayList)paramObject[1], ((Integer)paramObject[2]).intValue());
      return;
    case 301: 
      bH(((Long)paramObject[1]).longValue());
      return;
    case 302: 
      c(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue());
      return;
    case 303: 
      d(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue());
      return;
    case 307: 
      amA();
      return;
    case 406: 
      amB();
      return;
    case 404: 
      B(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
      return;
    case 409: 
      R(((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
      return;
    case 500: 
      b(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), jlc.a(paramObject, 5), ((Long)paramObject[6]).longValue());
      return;
    case 502: 
      b(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), jlc.a(paramObject, 6), ((Long)paramObject[7]).longValue());
      return;
    case 309: 
      aN((String)paramObject[1], (String)paramObject[2]);
      return;
    case 410: 
      bI(((Long)paramObject[1]).longValue());
      return;
    case 707: 
      amC();
      return;
    case 513: 
      d(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), (String)paramObject[3]);
      return;
    case 514: 
      bJ(((Long)paramObject[1]).longValue());
      return;
    case 515: 
      bK(((Long)paramObject[1]).longValue());
      return;
    case 516: 
      l(((Long)paramObject[1]).longValue(), (String)paramObject[2]);
      return;
    case 209: 
      if (QLog.isColorLevel()) {
        QLog.d("qav.GAudioUIObserver", 2, "TYPE_NOTIFY_RANDOM_MULTI_OWNER_PUSH [random room owner]");
      }
      b(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
      return;
    case 210: 
      S(((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
      return;
    case 157: 
      m(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue());
      return;
    }
    c(((Integer)paramObject[1]).intValue(), (byte[])paramObject[2]);
  }
  
  protected void R(int paramInt, String paramString) {}
  
  protected void S(int paramInt, String paramString) {}
  
  protected void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  protected void a(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2) {}
  
  protected void a(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean) {}
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, int paramInt) {}
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, int paramInt, boolean paramBoolean) {}
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  protected void a(RecvMsg paramRecvMsg) {}
  
  protected void aN(String paramString1, String paramString2) {}
  
  protected void amA() {}
  
  protected void amB() {}
  
  protected void amC() {}
  
  protected void amy() {}
  
  protected void amz() {}
  
  protected void b(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, long paramLong4) {}
  
  protected void b(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3, long paramLong4) {}
  
  protected void b(long paramLong, int paramInt, String paramString) {}
  
  protected void b(long paramLong1, long paramLong2, int paramInt1, int paramInt2) {}
  
  protected void b(long paramLong1, long paramLong2, String paramString) {}
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void b(long paramLong, ArrayList<VideoController.b> paramArrayList, int paramInt1, int paramInt2) {}
  
  protected void b(String paramString, String[] paramArrayOfString) {}
  
  protected void bG(long paramLong) {}
  
  protected void bH(long paramLong) {}
  
  protected void bI(long paramLong) {}
  
  protected void bJ(long paramLong) {}
  
  protected void bK(long paramLong) {}
  
  protected void by(ArrayList<ini> paramArrayList) {}
  
  protected void c(int paramInt, byte[] paramArrayOfByte) {}
  
  protected void c(long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  protected void c(long paramLong, boolean paramBoolean, int paramInt) {}
  
  protected void d(long paramLong1, long paramLong2, String paramString) {}
  
  protected void d(long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  protected void g(int paramInt1, long paramLong, int paramInt2) {}
  
  protected void h(int paramInt1, long paramLong, int paramInt2) {}
  
  protected void k(long paramLong, int paramInt1, int paramInt2) {}
  
  protected void kn(int paramInt) {}
  
  protected void l(long paramLong, int paramInt1, int paramInt2) {}
  
  protected void l(long paramLong, String paramString) {}
  
  protected void l(long paramLong, boolean paramBoolean) {}
  
  protected void m(long paramLong, int paramInt) {}
  
  protected void m(long paramLong, boolean paramBoolean) {}
  
  protected void n(long paramLong, int paramInt) {}
  
  protected void o(long paramLong, int paramInt) {}
  
  protected void onServiceConnected() {}
  
  protected void p(long paramLong, int paramInt) {}
  
  protected void q(ArrayList<Long> paramArrayList, int paramInt) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.mHandler == null) {
        this.mHandler = new Handler(paramObservable);
      }
      this.mHandler.post(new GAudioUIObserver.1(this, paramObject));
      return;
    }
    I(paramObject);
  }
  
  protected void y(long paramLong1, long paramLong2) {}
  
  protected void z(long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iid
 * JD-Core Version:    0.7.0.1
 */