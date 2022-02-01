import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.av.VideoCallStateMonitor.1;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class igx
{
  private boolean Ou;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private igx.b jdField_a_of_type_Igx$b;
  private int alh;
  private volatile int ali;
  private int alj;
  private List<igx.a> fa;
  private long kD;
  private VideoAppInterface mApp;
  private String mPeerUin;
  private long mSessionId;
  private volatile long mStartTime;
  private volatile long mStartTimeStamp;
  
  public igx(@NonNull VideoAppInterface paramVideoAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCallStateMonitor", 2, "VideoCallStateMonitor <" + this + "> created");
    }
    this.mApp = paramVideoAppInterface;
    this.mPeerUin = paramString;
    if (TextUtils.isEmpty(this.mPeerUin)) {
      this.mPeerUin = "0";
    }
    this.jdField_a_of_type_ComTencentAvVideoController = VideoController.a();
    this.alh = 0;
    this.kD = 0L;
    this.mStartTime = 0L;
    this.mStartTimeStamp = 0L;
    this.fa = new ArrayList();
    this.mSessionId = 0L;
    this.jdField_a_of_type_Igx$b = new igx.b(this);
    this.ali = 0;
    this.alj = 2;
  }
  
  private long a(Map<String, Integer> paramMap, String paramString)
  {
    if ((paramMap != null) && (paramMap.containsKey(paramString))) {
      return ((Integer)paramMap.get(paramString)).intValue();
    }
    return -1L;
  }
  
  private void a(long paramLong, Map<String, Integer> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    this.alh += 1;
    this.kD += a(paramMap, "summary.total-pss");
    long l = this.kD / this.alh;
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.mPeerUin, "avgMemory", String.valueOf(l));
    if (QLog.isColorLevel()) {
      QLog.d("VideoCallStateMonitor", 2, "call avg pss: " + l + "kb");
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCallStateMonitor", 2, String.format("report memory type=%s value=%sKB, time=%s", new Object[] { Integer.valueOf(kw()), paramMap.toString(), Long.valueOf(paramLong) }));
    }
    this.fa.add(new igx.a(kw(), a(paramMap, "summary.total-pss"), a(paramMap, "summary.java-heap"), a(paramMap, "summary.native-heap"), a(paramMap, "summary.code"), a(paramMap, "summary.graphics"), paramLong));
  }
  
  private void als()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCallStateMonitor", 2, "postReportMemory size = " + this.fa.size());
    }
    int j = this.fa.size();
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    long l1;
    long l2;
    long l3;
    long l4;
    long l5;
    long l6;
    int i;
    Object localObject3;
    igx.a locala;
    if (j >= 4)
    {
      l1 = ((igx.a)this.fa.get(j - 1 - 1)).kE;
      l2 = ((igx.a)this.fa.get(1)).kE;
      l3 = ((igx.a)this.fa.get(j - 1 - 1)).kF;
      l4 = ((igx.a)this.fa.get(1)).kF;
      l5 = ((igx.a)this.fa.get(j - 1 - 1)).kG;
      l6 = ((igx.a)this.fa.get(1)).kG;
      i = 1;
      if (i >= j - 1 - 1) {
        break label1063;
      }
      localObject3 = (igx.a)this.fa.get(i);
      locala = (igx.a)this.fa.get(i + 1);
      if ((((igx.a)localObject3).alj != 0) && (((igx.a)localObject3).alj != locala.alj))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, session type changed");
        }
        i = 1;
      }
    }
    for (;;)
    {
      label292:
      double d2;
      double d3;
      double d1;
      if (i == 0)
      {
        d2 = 0.0D;
        d3 = 0.0D;
        localObject3 = ((List)localObject1).iterator();
        d1 = 0.0D;
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            d1 = ((Double)((Iterator)localObject3).next()).doubleValue() + d1;
            continue;
            this.alj = locala.alj;
            if ((!((igx.a)localObject3).isValid()) || (!locala.isValid())) {
              if (QLog.isColorLevel()) {
                QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, cannot get memory info");
              }
            }
          }
        }
      }
      label1005:
      do
      {
        do
        {
          return;
          d1 = locala.mTimeStamp - ((igx.a)localObject3).mTimeStamp;
          d2 = locala.kE - ((igx.a)localObject3).kE;
          d3 = locala.kF - ((igx.a)localObject3).kF;
          double d4 = locala.kG - ((igx.a)localObject3).kG;
          if (d1 <= 0.0D)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, timestamp fatal error");
            }
            i = 1;
            break label292;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoCallStateMonitor", 2, String.format("total pss grow %skb, java pss grow %skb, native pss grow %skb [in %sms]", new Object[] { Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d1) }));
          }
          ((List)localObject1).add(Double.valueOf(d2 * 1000.0D / d1));
          ((List)localObject2).add(Double.valueOf(1000.0D * d3 / d1));
          localArrayList.add(Double.valueOf(d4 * 1000.0D / d1));
          i += 1;
          break;
          localObject3 = ((List)localObject2).iterator();
          while (((Iterator)localObject3).hasNext()) {
            d2 = ((Double)((Iterator)localObject3).next()).doubleValue() + d2;
          }
          localObject3 = localArrayList.iterator();
          while (((Iterator)localObject3).hasNext()) {
            d3 = ((Double)((Iterator)localObject3).next()).doubleValue() + d3;
          }
          d1 /= ((List)localObject1).size();
          d2 /= ((List)localObject2).size();
          d3 /= localArrayList.size();
          localObject2 = new HashMap(9);
          ((HashMap)localObject2).put("selfUin", this.mApp.getCurrentAccountUin());
          ((HashMap)localObject2).put("peerUin", this.mPeerUin);
          ((HashMap)localObject2).put("sessionId", String.valueOf(this.mSessionId));
          ((HashMap)localObject2).put("startTimestamp", String.valueOf(this.mStartTimeStamp));
          if (this.Ou)
          {
            localObject1 = "1";
            ((HashMap)localObject2).put("firstChat", localObject1);
            ((HashMap)localObject2).put("chatType", String.valueOf(this.alj));
            ((HashMap)localObject2).put("device_memory", String.valueOf(aqgz.getSystemTotalMemory() / 1024L));
            ((HashMap)localObject2).put("totalPss_growth", String.valueOf(l1 - l2));
            ((HashMap)localObject2).put("totalPss_growthRate", String.valueOf(d1));
            ((HashMap)localObject2).put("javaPss_growth", String.valueOf(l3 - l4));
            ((HashMap)localObject2).put("javaPss_growthRate", String.valueOf(d2));
            ((HashMap)localObject2).put("nativePss_growth", String.valueOf(l5 - l6));
            ((HashMap)localObject2).put("nativePss_growthRate", String.valueOf(d3));
            if (this.mStartTime <= 0L) {
              break label1005;
            }
          }
          for (localObject1 = String.valueOf(SystemClock.uptimeMillis() - this.mStartTime);; localObject1 = "")
          {
            ((HashMap)localObject2).put("call_dur", localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("VideoCallStateMonitor", 2, "postReportMemory success: " + ((HashMap)localObject2).toString());
            }
            ThreadManager.post(new VideoCallStateMonitor.1(this, (HashMap)localObject2), 5, null, false);
            return;
            localObject1 = "0";
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, skip");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("VideoCallStateMonitor", 2, "postReportMemory failed, node size = " + j);
      return;
      label1063:
      i = 0;
    }
  }
  
  private void bw(long paramLong)
  {
    if (paramLong > 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCallStateMonitor", 2, "call avail mem: " + paramLong + "kb");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.mPeerUin, "availMem2", String.valueOf(paramLong));
    }
  }
  
  private void bx(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCallStateMonitor", 2, "call time: " + paramLong + "ms");
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.mPeerUin, "callDur", String.valueOf(paramLong));
  }
  
  private void km(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCallStateMonitor", 2, "begin monitor " + paramInt);
    }
    Map localMap = aqgz.g(this.mApp.getApp());
    if (a(localMap, "summary.total-pss") <= 0L) {
      if (QLog.isColorLevel()) {
        QLog.e("VideoCallStateMonitor", 1, "getTotalPss error!");
      }
    }
    for (;;)
    {
      if (this.mStartTime > 0L)
      {
        long l = SystemClock.uptimeMillis() - this.mStartTime;
        if (l > 0L) {
          bx(l);
        }
      }
      return;
      a(SystemClock.uptimeMillis(), localMap);
      bw(aqgz.getSystemAvaialbeMemory() / 1000L);
    }
  }
  
  private int kw()
  {
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b().amI;
    if (i == 1) {
      return 1;
    }
    if (i == 2) {
      return 2;
    }
    if (i == 0) {
      return 0;
    }
    return 2;
  }
  
  public void alr()
  {
    if (this.ali == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCallStateMonitor", 2, "startCallMonitor");
      }
      this.Ou = this.jdField_a_of_type_ComTencentAvVideoController.OG;
      this.mStartTime = SystemClock.uptimeMillis();
      this.mStartTimeStamp = System.currentTimeMillis();
      this.mSessionId = this.jdField_a_of_type_ComTencentAvVideoController.getChatRoomId(this.mPeerUin);
      this.jdField_a_of_type_Igx$b.startTimer();
      this.ali = 1;
      return;
    }
    QLog.e("VideoCallStateMonitor", 1, "startCallMonitor state error");
  }
  
  public void stopMonitor()
  {
    if (this.ali != 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCallStateMonitor", 2, "stopMonitor " + Log.getStackTraceString(new RuntimeException()));
      }
      this.ali = 2;
      this.jdField_a_of_type_Igx$b.stopTimer();
      return;
    }
    QLog.e("VideoCallStateMonitor", 1, "stopMonitor state error");
  }
  
  static class a
  {
    int alj;
    long kE;
    long kF;
    long kG;
    long kH;
    long kI;
    long mTimeStamp;
    
    a(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
    {
      this.alj = paramInt;
      this.kE = paramLong1;
      this.kF = paramLong2;
      this.kG = paramLong3;
      this.kH = paramLong4;
      this.kI = paramLong5;
      this.mTimeStamp = paramLong6;
    }
    
    boolean isValid()
    {
      return (this.kE > 0L) && (this.kF > 0L) && (this.kG > 0L);
    }
  }
  
  static class b
    extends Handler
  {
    WeakReference<igx> bi;
    
    b(igx paramigx)
    {
      this.bi = new WeakReference(paramigx);
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      igx localigx = (igx)this.bi.get();
      if (localigx != null) {}
      switch (paramMessage.what)
      {
      case 2: 
      default: 
      case 1: 
        do
        {
          return;
          igx.a(localigx, paramMessage.what);
        } while (igx.a(localigx) == 2);
        sendMessageDelayed(obtainMessage(paramMessage.what), 15000L);
        return;
      }
      igx.a(localigx);
    }
    
    public void startTimer()
    {
      sendMessage(obtainMessage(1));
    }
    
    public void stopTimer()
    {
      sendMessage(obtainMessage(3));
      removeMessages(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     igx
 * JD-Core Version:    0.7.0.1
 */