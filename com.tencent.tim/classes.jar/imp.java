import android.graphics.Color;
import android.graphics.PointF;
import android.os.SystemClock;
import com.tencent.av.AVFunDrawing.DrawingInfo;
import com.tencent.av.AVFunDrawing.MessageBody;
import com.tencent.av.AVFunDrawing.PointInfo;
import com.tencent.av.AVFunDrawing.VersionInfo;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.doodle.DoodleLogic.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class imp
{
  private static imp jdField_a_of_type_Imp;
  static int apW;
  public boolean SA = false;
  public boolean SB;
  public VideoController a;
  private imp.a jdField_a_of_type_Imp$a;
  public imq a;
  public imo[] a;
  public int apU = 1;
  public int apV;
  public ReentrantLock g;
  public boolean[] g;
  public float gh = -1.0F;
  public ConcurrentLinkedQueue<imo> m = new ConcurrentLinkedQueue();
  public int mColor = -65536;
  public int mScreenHeight;
  public int mScreenWidth;
  ConcurrentLinkedQueue<imp.b> n = new ConcurrentLinkedQueue();
  
  public imp()
  {
    this.jdField_a_of_type_ArrayOfImo = new imo[2];
    this.jdField_g_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
    this.jdField_g_of_type_ArrayOfBoolean = new boolean[2];
    this.jdField_a_of_type_ComTencentAvVideoController = VideoController.a();
    this.jdField_a_of_type_Imq = new imq(this);
  }
  
  public static imp a()
  {
    try
    {
      if (jdField_a_of_type_Imp == null) {
        jdField_a_of_type_Imp = new imp();
      }
      return jdField_a_of_type_Imp;
    }
    finally {}
  }
  
  private void offer(int paramInt)
  {
    imo localimo1 = this.jdField_a_of_type_ArrayOfImo[paramInt];
    if (localimo1 != null)
    {
      localimo1.lV = SystemClock.elapsedRealtime();
      if (this.jdField_a_of_type_Imp$a != null) {
        this.jdField_a_of_type_Imp$a.kY(paramInt);
      }
      Iterator localIterator = this.m.iterator();
      while (localIterator.hasNext())
      {
        imo localimo2 = (imo)localIterator.next();
        if (localimo1.lV - localimo2.lV <= 1200L) {
          localimo2.lV = localimo1.lV;
        }
      }
      this.m.offer(localimo1);
    }
    this.jdField_a_of_type_ArrayOfImo[paramInt] = null;
    QLog.w("DoodleLogic", 1, "offerDoodle, index[" + paramInt + "], item[" + localimo1 + "], size[" + this.m.size() + "]");
  }
  
  private void send(int paramInt)
  {
    int i = 0;
    imo localimo = this.jdField_a_of_type_ArrayOfImo[0];
    AVFunDrawing.PointInfo localPointInfo = new AVFunDrawing.PointInfo();
    localPointInfo.uint32_type.set(paramInt);
    AVFunDrawing.MessageBody localMessageBody = new AVFunDrawing.MessageBody();
    localMessageBody.uint32_msg_type.set(2);
    AVFunDrawing.DrawingInfo localDrawingInfo = new AVFunDrawing.DrawingInfo();
    if (localimo != null) {
      i = 1;
    }
    if (i != 0)
    {
      float f1 = localimo.d.x;
      float f2 = localimo.d.y;
      localPointInfo.float_x.set(f1);
      localPointInfo.float_y.set(f2);
      localDrawingInfo.uint32_pen_type.set(localimo.apU);
      localDrawingInfo.str_pen_name.set(localimo.Ov);
      localDrawingInfo.str_pen_color.set("#" + Integer.toHexString(localimo.mColor));
      localDrawingInfo.uint32_pen_width.set(localimo.mStrokeWidth);
      localDrawingInfo.uint32_screen_width.set(localimo.mScreenWidth);
      localDrawingInfo.uint32_screen_height.set(localimo.mScreenHeight);
      localDrawingInfo.msg_point_info.add(localPointInfo);
      localMessageBody.drawingInfo.set(localDrawingInfo);
      i = genSeq();
      localMessageBody.uint32_seq.set(i);
      this.n.add(new imp.b(localMessageBody));
      if (paramInt != 3) {
        break label290;
      }
      if (this.n.size() == 1) {
        ci(100L);
      }
    }
    label290:
    while (this.n.size() != 1)
    {
      return;
      ivv.jL("没有doodleItem");
      break;
    }
    aoi();
  }
  
  public imp.a a()
  {
    return this.jdField_a_of_type_Imp$a;
  }
  
  public void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    boolean bool = true;
    this.jdField_g_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        this.SA = bool;
        this.jdField_g_of_type_ArrayOfBoolean[paramInt] = true;
        if (this.SA)
        {
          this.jdField_a_of_type_ArrayOfImo[0] = imr.a(this.apU);
          this.jdField_a_of_type_ArrayOfImo[0].mColor = this.mColor;
          this.jdField_a_of_type_ArrayOfImo[0].apU = this.apU;
          this.jdField_a_of_type_ArrayOfImo[0].mScreenWidth = this.mScreenWidth;
          this.jdField_a_of_type_ArrayOfImo[0].mScreenHeight = this.mScreenHeight;
        }
        QLog.w("DoodleLogic", 1, "touch_start, index[" + paramInt + "], item[" + this.jdField_a_of_type_ArrayOfImo[paramInt] + "], pt[" + paramFloat1 + ", " + paramFloat2 + "]");
        this.jdField_a_of_type_ArrayOfImo[paramInt].q(paramFloat1, paramFloat2);
        if (this.SA) {
          send(1);
        }
        if (this.jdField_a_of_type_Imp$a != null) {
          this.jdField_a_of_type_Imp$a.invalidate();
        }
        return;
      }
      finally
      {
        this.jdField_g_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
      bool = false;
    }
  }
  
  public void a(imp.a parama)
  {
    this.jdField_a_of_type_Imp$a = parama;
  }
  
  public void aoi()
  {
    imp.b localb = (imp.b)this.n.poll();
    if (localb == null) {
      QLog.w("DoodleLogic", 1, "sendDoodle, 结束");
    }
    do
    {
      return;
      AVFunDrawing.MessageBody localMessageBody = localb.a;
      long l = AudioHelper.hF();
      localMessageBody.uint64_time.set(l);
      Object localObject = localMessageBody.toByteArray();
      this.jdField_a_of_type_ComTencentAvVideoController.a(2, (byte[])localObject);
      localObject = (AVFunDrawing.PointInfo)((AVFunDrawing.DrawingInfo)localMessageBody.drawingInfo.get()).msg_point_info.get(0);
      float f1 = ((AVFunDrawing.PointInfo)localObject).float_x.get();
      float f2 = ((AVFunDrawing.PointInfo)localObject).float_y.get();
      int i = ((AVFunDrawing.PointInfo)localObject).uint32_type.get();
      QLog.w("DoodleLogic", 1, "sendDoodle, sendtime[" + l + "], offset[" + (l - localb.lX) + "], pt[" + f1 + ", " + f2 + "], uint32_type[" + i + "], uint32_seq[" + localMessageBody.uint32_seq.get() + "], size[" + this.n.size() + "]");
    } while (this.n.size() <= 0);
    ci(1L);
  }
  
  public void aoj()
  {
    int i = 0;
    boolean bool = imr.ub();
    Object localObject = new AVFunDrawing.MessageBody();
    ((AVFunDrawing.MessageBody)localObject).uint32_msg_type.set(1);
    AVFunDrawing.VersionInfo localVersionInfo = new AVFunDrawing.VersionInfo();
    localVersionInfo.uint32_version.set(0);
    PBUInt32Field localPBUInt32Field = localVersionInfo.uint32_support_drawing;
    if (bool) {
      i = 1;
    }
    localPBUInt32Field.set(i);
    ((AVFunDrawing.MessageBody)localObject).versionInfo.set(localVersionInfo);
    i = genSeq();
    ((AVFunDrawing.MessageBody)localObject).uint32_seq.set(i);
    localObject = ((AVFunDrawing.MessageBody)localObject).toByteArray();
    this.jdField_a_of_type_ComTencentAvVideoController.a(2, (byte[])localObject);
    QLog.w("DoodleLogic", 1, "sendSelfIsSupport, isSelfSupport[" + bool + "], uint32_seq[" + i + "]");
    ivv.arh();
  }
  
  /* Error */
  public void b(int paramInt, float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 63	imp:jdField_g_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 298	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 48	imp:jdField_a_of_type_ArrayOfImo	[Limo;
    //   11: iload_1
    //   12: aaload
    //   13: ifnull +58 -> 71
    //   16: aload_0
    //   17: getfield 48	imp:jdField_a_of_type_ArrayOfImo	[Limo;
    //   20: iload_1
    //   21: aaload
    //   22: fload_2
    //   23: fload_3
    //   24: invokevirtual 411	imo:t	(FF)Z
    //   27: ifeq +44 -> 71
    //   30: iload_1
    //   31: ifne +48 -> 79
    //   34: iconst_1
    //   35: istore 4
    //   37: aload_0
    //   38: iload 4
    //   40: putfield 50	imp:SA	Z
    //   43: aload_0
    //   44: getfield 50	imp:SA	Z
    //   47: ifeq +8 -> 55
    //   50: aload_0
    //   51: iconst_2
    //   52: invokespecial 320	imp:send	(I)V
    //   55: aload_0
    //   56: getfield 100	imp:jdField_a_of_type_Imp$a	Limp$a;
    //   59: ifnull +12 -> 71
    //   62: aload_0
    //   63: getfield 100	imp:jdField_a_of_type_Imp$a	Limp$a;
    //   66: invokeinterface 323 1 0
    //   71: aload_0
    //   72: getfield 63	imp:jdField_g_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   75: invokevirtual 326	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   78: return
    //   79: iconst_0
    //   80: istore 4
    //   82: goto -45 -> 37
    //   85: astore 5
    //   87: aload_0
    //   88: getfield 63	imp:jdField_g_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   91: invokevirtual 326	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   94: aload 5
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	imp
    //   0	97	1	paramInt	int
    //   0	97	2	paramFloat1	float
    //   0	97	3	paramFloat2	float
    //   35	46	4	bool	boolean
    //   85	10	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	30	85	finally
    //   37	55	85	finally
    //   55	71	85	finally
  }
  
  public void c(int paramInt, float paramFloat1, float paramFloat2)
  {
    boolean bool = true;
    this.jdField_g_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ArrayOfImo[paramInt] == null) {
          break label170;
        }
        this.jdField_a_of_type_ArrayOfImo[paramInt].s(paramFloat1, paramFloat2);
      }
      finally
      {
        this.jdField_g_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
      this.SA = bool;
      if (this.SA) {
        send(3);
      }
      QLog.w("DoodleLogic", 1, "touch_up, index[" + paramInt + "], item[" + this.jdField_a_of_type_ArrayOfImo[paramInt] + "], pt[" + paramFloat1 + ", " + paramFloat2 + "]");
      offer(paramInt);
      if (this.jdField_a_of_type_Imp$a != null) {
        this.jdField_a_of_type_Imp$a.invalidate();
      }
      this.jdField_g_of_type_ArrayOfBoolean[paramInt] = false;
      this.jdField_g_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      return;
      bool = false;
      continue;
      label170:
      if (paramInt != 0) {}
    }
  }
  
  public void ch(long paramLong)
  {
    imo[] arrayOfimo = this.jdField_a_of_type_ArrayOfImo;
    int j = arrayOfimo.length;
    int i = 0;
    while (i < j)
    {
      imo localimo = arrayOfimo[i];
      if (localimo != null) {
        localimo.ch(paramLong);
      }
      i += 1;
    }
  }
  
  void ci(long paramLong)
  {
    if (AudioHelper.aCz()) {
      QLog.w("DoodleLogic", 1, "startSendDoodleHandle, delayMillis[" + paramLong + "]");
    }
    ThreadManager.getUIHandler().postDelayed(new DoodleLogic.1(this), paramLong);
  }
  
  int genSeq()
  {
    try
    {
      apW += 1;
      int i = apW;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int m(byte[] paramArrayOfByte)
  {
    Object localObject1 = new AVFunDrawing.MessageBody();
    int j = 0;
    int i = 0;
    int i2 = i;
    int i3 = j;
    try
    {
      paramArrayOfByte = (AVFunDrawing.MessageBody)((AVFunDrawing.MessageBody)localObject1).mergeFrom(paramArrayOfByte);
      i2 = i;
      i3 = j;
      j = paramArrayOfByte.uint32_msg_type.get();
      switch (j)
      {
      case 1: 
        i2 = j;
        i3 = j;
        localObject1 = paramArrayOfByte.versionInfo;
        i2 = j;
        i3 = j;
        this.apV = ((AVFunDrawing.VersionInfo)localObject1).uint32_version.get();
        i2 = j;
        i3 = j;
        if (((AVFunDrawing.VersionInfo)localObject1).uint32_support_drawing.get() == 0) {
          break label245;
        }
        bool = true;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        QLog.w("DoodleLogic", 1, "receiveDoodle, InvalidProtocolBufferMicroException", paramArrayOfByte);
        return i2;
        boolean bool = false;
      }
      i2 = j;
      i3 = j;
      localObject1 = paramArrayOfByte.drawingInfo;
      i2 = j;
      i3 = j;
      l1 = paramArrayOfByte.uint64_time.get();
      i2 = j;
      i3 = j;
      l2 = AudioHelper.hF();
      if (l2 <= l1) {
        break label837;
      }
      k = (int)(l2 - l1);
      i2 = j;
      i3 = j;
      if (((AVFunDrawing.DrawingInfo)localObject1).msg_point_info.size() <= 0) {
        break label977;
      }
      i2 = j;
      i3 = j;
      localObject2 = (AVFunDrawing.PointInfo)((AVFunDrawing.DrawingInfo)localObject1).msg_point_info.get(0);
      i2 = j;
      i3 = j;
      i1 = ((AVFunDrawing.PointInfo)localObject2).uint32_type.get();
      i2 = j;
      i3 = j;
      f1 = ((AVFunDrawing.PointInfo)localObject2).float_x.get();
      i2 = j;
      i3 = j;
      f2 = ((AVFunDrawing.PointInfo)localObject2).float_y.get();
      i2 = j;
      i3 = j;
      localObject2 = this.jdField_a_of_type_ArrayOfImo[1];
      if (i1 != 1) {
        break label850;
      }
      i2 = j;
      i3 = j;
      this.jdField_a_of_type_ArrayOfImo[1] = imr.a(((AVFunDrawing.DrawingInfo)localObject1).uint32_pen_type.get());
      i = i1;
      i2 = j;
      i3 = j;
      QLog.w("DoodleLogic", 1, "receiveDoodle, point_type[" + i1 + "->" + i + "], pt[" + f1 + ", " + f2 + "], uint32_seq[" + paramArrayOfByte.uint32_seq.get() + "], offset[" + k + " = " + l2 + " - " + l1 + "], old[" + localObject2 + "], new[" + this.jdField_a_of_type_ArrayOfImo[1] + "]");
      i2 = j;
      i3 = j;
      if (this.jdField_a_of_type_ArrayOfImo[1] == null) {
        break label1058;
      }
      i2 = j;
      i3 = j;
      this.jdField_a_of_type_ArrayOfImo[1].Ov = ((AVFunDrawing.DrawingInfo)localObject1).str_pen_name.get();
      i2 = j;
      i3 = j;
      this.jdField_a_of_type_ArrayOfImo[1].mColor = Color.parseColor(((AVFunDrawing.DrawingInfo)localObject1).str_pen_color.get());
      i2 = j;
      i3 = j;
      this.jdField_a_of_type_ArrayOfImo[1].mStrokeWidth = ((AVFunDrawing.DrawingInfo)localObject1).uint32_pen_width.get();
      i2 = j;
      i3 = j;
      this.jdField_a_of_type_ArrayOfImo[1].mScreenWidth = ((AVFunDrawing.DrawingInfo)localObject1).uint32_screen_width.get();
      i2 = j;
      i3 = j;
      this.jdField_a_of_type_ArrayOfImo[1].mScreenHeight = ((AVFunDrawing.DrawingInfo)localObject1).uint32_screen_height.get();
      switch (i)
      {
      case 1: 
        i2 = j;
        i3 = j;
        QLog.w("DoodleLogic", 1, "receiveDoodle, after[" + this.jdField_a_of_type_ArrayOfImo[1] + "]");
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.w("DoodleLogic", 1, "receiveDoodle, Exception", paramArrayOfByte);
      return i3;
    }
    i2 = j;
    i3 = j;
    this.SB = bool;
    i2 = j;
    i3 = j;
    QLog.w("DoodleLogic", 1, "receiveDoodle, mPeerVersion[" + this.apV + "], mIsPeerSupport[" + this.SB + "], uint32_seq[" + paramArrayOfByte.uint32_seq.get() + "]");
    i2 = j;
    i3 = j;
    ivv.arh();
    label1058:
    for (;;)
    {
      label245:
      long l1;
      long l2;
      Object localObject2;
      int i1;
      float f1;
      float f2;
      label837:
      int k = 0 - (int)(l1 - l2);
      continue;
      label850:
      if (localObject2 == null)
      {
        i2 = j;
        i3 = j;
        this.jdField_a_of_type_ArrayOfImo[1] = imr.a(((AVFunDrawing.DrawingInfo)localObject1).uint32_pen_type.get());
        if (i1 == 2)
        {
          i = 1;
          continue;
          i2 = j;
          i3 = j;
          this.jdField_a_of_type_ComTencentAvVideoController.mApp.l(new Object[] { Integer.valueOf(161) });
          i2 = j;
          i3 = j;
          a(1, f1, f2);
          continue;
          i2 = j;
          i3 = j;
          b(1, f1, f2);
          continue;
          i2 = j;
          i3 = j;
          c(1, f1, f2);
          continue;
          i2 = j;
          i3 = j;
          QLog.w("DoodleLogic", 1, "receiveDoodle, msg_point_info[null], uint32_seq[" + paramArrayOfByte.uint32_seq.get() + "], offset[" + k + " = " + l2 + " - " + l1 + "]");
          return j;
          continue;
        }
        if (i1 != 3) {}
      }
      label977:
      i = i1;
    }
  }
  
  public void reset()
  {
    this.m.clear();
    this.jdField_a_of_type_ArrayOfImo[0] = null;
    this.jdField_a_of_type_ArrayOfImo[1] = null;
    this.SB = false;
    this.apV = 0;
    this.mColor = -65536;
    this.gh = -1.0F;
    this.jdField_g_of_type_ArrayOfBoolean[0] = false;
    this.jdField_g_of_type_ArrayOfBoolean[1] = false;
    int i = this.n.size();
    this.n.clear();
    QLog.w("DoodleLogic", 1, "resetDoodle, mSendQuene[" + i + "]", new Throwable("打印调用栈"));
  }
  
  public boolean ua()
  {
    return this.apV > 0;
  }
  
  public static abstract interface a
  {
    public abstract void invalidate();
    
    public abstract void kY(int paramInt);
  }
  
  static class b
  {
    AVFunDrawing.MessageBody a;
    long lX = AudioHelper.hF();
    
    b(AVFunDrawing.MessageBody paramMessageBody)
    {
      this.a = paramMessageBody;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     imp
 * JD-Core Version:    0.7.0.1
 */