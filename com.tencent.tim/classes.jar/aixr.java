import android.os.Vibrator;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.magicface.magicfaceaction.Action.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class aixr
{
  public List<aiye> CJ = new ArrayList();
  public aixt a;
  public aixu a;
  aiyc.a jdField_a_of_type_Aiyc$a = new aixs(this);
  aiye jdField_a_of_type_Aiye;
  public aiyl a;
  public boolean cmA;
  public boolean cmz;
  CountDownLatch countDownLatch = new CountDownLatch(1);
  int dgg = 0;
  volatile boolean isStop = false;
  public volatile boolean isTimeout;
  public String name;
  public int playTimes = 1;
  public int timeout = -1;
  TimerTask timerTask = new Action.2(this);
  Vibrator vibrator;
  
  public void a(int paramInt, aiyh.c paramc)
  {
    if (this.jdField_a_of_type_Aixu == null) {}
    do
    {
      do
      {
        do
        {
          int i;
          do
          {
            return;
            int j = this.jdField_a_of_type_Aixu.dgq;
            i = j;
            if (this.jdField_a_of_type_Aixu.dgq > 0)
            {
              i = j;
              if (this.jdField_a_of_type_Aixu.dgq < 40) {
                i = this.jdField_a_of_type_Aixu.dgq * 2;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.i("Action", 2, "==stopValue=" + i);
            }
            if (!"end".equalsIgnoreCase(this.jdField_a_of_type_Aixu.bPZ)) {
              break;
            }
          } while (paramInt < i);
          stop();
          return;
          aixu localaixu = this.jdField_a_of_type_Aixu;
          if ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_Aixu.type)) || (paramInt < i) || (!"mic".equalsIgnoreCase(this.jdField_a_of_type_Aixu.bPV))) {
            break;
          }
          stop();
        } while (paramc == null);
        paramc.stop();
        return;
        paramc = this.jdField_a_of_type_Aixu;
      } while (!"record".equalsIgnoreCase(this.jdField_a_of_type_Aixu.type));
      paramc = this.jdField_a_of_type_Aixt;
      paramc.value += this.jdField_a_of_type_Aixu.im(paramInt);
    } while (this.jdField_a_of_type_Aixt.a == null);
    this.jdField_a_of_type_Aixt.bPW = this.jdField_a_of_type_Aixt.a.a(this.jdField_a_of_type_Aixt.value, this.jdField_a_of_type_Aixt.xb);
  }
  
  public boolean ace()
  {
    this.isTimeout = false;
    dvj();
    this.playTimes = this.jdField_a_of_type_Aiye.dgO;
    this.jdField_a_of_type_Aiyl.setFps(this.jdField_a_of_type_Aiye.fps);
    this.jdField_a_of_type_Aiyl.b(this.jdField_a_of_type_Aiyc$a);
    this.jdField_a_of_type_Aiyl.a(this.jdField_a_of_type_Aiye);
    try
    {
      this.countDownLatch.await();
      label63:
      if ((this.jdField_a_of_type_Aiye.bQd != null) && (this.jdField_a_of_type_Aiye.bQd.length() > 0)) {
        this.jdField_a_of_type_Aiyl.iX(this.jdField_a_of_type_Aiye.bQd);
      }
      if ((this.vibrator != null) && (this.jdField_a_of_type_Aiye.cmI)) {
        this.vibrator.cancel();
      }
      if ((this.isTimeout) && (!this.cmz)) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Action", 2, "===Magicaction is stop====");
      }
      return true;
    }
    catch (Exception localException)
    {
      break label63;
    }
  }
  
  public void b(int paramInt, aiyh.c paramc)
  {
    if (this.jdField_a_of_type_Aixu == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!"end".equalsIgnoreCase(this.jdField_a_of_type_Aixu.bPZ)) {
            break;
          }
        } while (paramc == null);
        stop();
        return;
        aixu localaixu = this.jdField_a_of_type_Aixu;
      } while ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_Aixu.type)) || (!"touch".equalsIgnoreCase(this.jdField_a_of_type_Aixu.bPV)) || (this.jdField_a_of_type_Aixu.dgr != paramInt));
      stop();
    } while (paramc == null);
    paramc.stop();
  }
  
  void dvj()
  {
    int i = this.CJ.size();
    if (i == 1) {
      this.jdField_a_of_type_Aiye = ((aiye)this.CJ.get(0));
    }
    aiye localaiye;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((i <= 1) || (this.jdField_a_of_type_Aixt.value < 0)) {}
        localIterator = this.CJ.iterator();
      } while (!localIterator.hasNext());
      localaiye = (aiye)localIterator.next();
    } while ((localaiye.min > this.jdField_a_of_type_Aixt.value) || (localaiye.max <= this.jdField_a_of_type_Aixt.value));
    this.jdField_a_of_type_Aiye = localaiye;
  }
  
  void dvk()
  {
    if (this.timeout > 0) {
      ThreadManager.getTimer().schedule(this.timerTask, this.timeout * 1000);
    }
  }
  
  public void dvl()
  {
    this.isTimeout = true;
  }
  
  public void stop()
  {
    this.isStop = true;
    this.jdField_a_of_type_Aiyl.anm();
    this.timerTask.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixr
 * JD-Core Version:    0.7.0.1
 */