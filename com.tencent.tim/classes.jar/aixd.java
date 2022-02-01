import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import com.tencent.mobileqq.lyric.common.TimerTaskManager.TimerTaskRunnable;
import com.tencent.mobileqq.lyric.widget.LyricView;
import com.tencent.mobileqq.lyric.widget.LyricViewController.10;
import com.tencent.mobileqq.lyric.widget.LyricViewController.2;
import com.tencent.mobileqq.lyric.widget.LyricViewController.3;
import com.tencent.mobileqq.lyric.widget.LyricViewController.4;
import com.tencent.mobileqq.lyric.widget.LyricViewController.5;
import com.tencent.mobileqq.lyric.widget.LyricViewController.9;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;
import com.tencent.mobileqq.lyric.widget.LyricViewScroll;
import com.tencent.mobileqq.lyric.widget.LyricViewScroll.a;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class aixd
{
  protected final String TASK_ID = "task_name_lyric_draw_" + System.currentTimeMillis();
  protected aixb a;
  public LyricViewInternal a;
  private LyricViewScroll.a jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$a = new aixe(this);
  private LyricViewScroll jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll;
  public long abR;
  public aiwn b;
  protected TimerTaskManager.TimerTaskRunnable b;
  protected TimerTaskManager c = aiws.a();
  public volatile boolean cmo;
  private boolean cmp;
  private volatile int deK;
  public int dfN;
  public int dfO;
  private boolean mIsPlaying;
  protected volatile boolean mIsScrolling;
  
  public aixd(LyricView paramLyricView)
  {
    this.jdField_a_of_type_Aixb = new aixb();
    this.jdField_b_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable = new LyricViewController.2(this);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll = paramLyricView.a();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal = paramLyricView.a();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.setScrollListener(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$a);
  }
  
  private void onRefresh()
  {
    this.jdField_b_of_type_Aiwn = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.c();
    aiwn localaiwn = this.jdField_b_of_type_Aiwn;
    if ((localaiwn == null) || (localaiwn.isEmpty()) || (this.mIsScrolling))
    {
      if (this.mIsScrolling) {
        Log.d("ModuleController", "onRefresh -> is scrolling");
      }
      return;
    }
    int j = (int)(SystemClock.elapsedRealtime() - this.abR);
    int i = j;
    if (this.cmo)
    {
      i = j;
      if (j >= this.dfO) {
        i = this.dfO;
      }
    }
    this.deK = i;
    iA(localaiwn.jdMethod_if(i), i);
  }
  
  protected void Qn(int paramInt)
  {
    this.mIsScrolling = false;
    if ((this.jdField_b_of_type_Aiwn != null) || (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal != null))
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.ij(paramInt);
      if ((this.jdField_b_of_type_Aiwn == null) || (this.jdField_b_of_type_Aiwn.isEmpty())) {
        Log.w("ModuleController", "onScrollStop -> scroll without measured lyric");
      }
    }
    else
    {
      return;
    }
    Log.d("ModuleController", "onScrollStop -> scroll to lineNo：" + paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_b_of_type_Aiwn.xs.size()))
    {
      if (this.jdField_b_of_type_Aiwn.xs.get(paramInt) == null)
      {
        Log.w("ModuleController", "onScrollStop -> current sentence is null");
        return;
      }
      long l2 = ((aiwp)this.jdField_b_of_type_Aiwn.xs.get(paramInt)).mStartTime;
      Log.d("ModuleController", "onScrollStop -> start time of current sentence：" + l2);
      long l1 = l2;
      if (this.cmo)
      {
        if ((this.dfN < 0) || (l2 >= this.dfN)) {
          break label303;
        }
        l1 = this.dfN;
      }
      for (;;)
      {
        Log.d("ModuleController", "onScrollStop -> correct start time：" + l1);
        l2 = l1;
        if (l1 < 0L) {
          l2 = 0L;
        }
        l1 = (l2 / 10L + 1L) * 10L;
        Log.d("ModuleController", "onScrollStop -> output time：" + l1);
        this.jdField_a_of_type_Aixb.kd(l1);
        if ((this.mIsPlaying) || (!this.cmp)) {
          break;
        }
        seek((int)l1);
        return;
        label303:
        l1 = l2;
        if (this.dfO >= 0)
        {
          l1 = l2;
          if (l2 > this.dfO) {
            l1 = this.dfO;
          }
        }
      }
    }
    Log.w("ModuleController", "onScrollStop -> scroll out of lyric scope");
  }
  
  protected void Qo(int paramInt)
  {
    if ((this.jdField_b_of_type_Aiwn != null) || (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal != null))
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.ii(paramInt);
      if ((this.jdField_b_of_type_Aiwn == null) || (this.jdField_b_of_type_Aiwn.isEmpty())) {
        Log.w("ModuleController", "onScrolling -> scroll without measured lyric");
      }
    }
    else
    {
      return;
    }
    if ((paramInt >= 0) && (paramInt < this.jdField_b_of_type_Aiwn.xs.size()))
    {
      if (this.jdField_b_of_type_Aiwn.xs.get(paramInt) == null)
      {
        Log.w("ModuleController", "onScrollStop -> current sentence is null");
        return;
      }
      long l2 = ((aiwp)this.jdField_b_of_type_Aiwn.xs.get(paramInt)).mStartTime;
      long l1 = l2;
      if (this.cmo)
      {
        if ((this.dfN < 0) || (l2 >= this.dfN)) {
          break label177;
        }
        l1 = this.dfN;
      }
      for (;;)
      {
        l2 = l1;
        if (l1 < 0L) {
          l2 = 0L;
        }
        l1 = l2 / 10L;
        this.jdField_a_of_type_Aixb.ke((l1 + 1L) * 10L);
        return;
        label177:
        l1 = l2;
        if (this.dfO >= 0)
        {
          l1 = l2;
          if (l2 > this.dfO) {
            l1 = this.dfO;
          }
        }
      }
    }
    Log.w("ModuleController", "onScrollStop -> scroll out of lyric scope");
  }
  
  public void a(aiwn paramaiwn1, aiwn paramaiwn2, aiwn paramaiwn3)
  {
    Log.v("ModuleController", "setLyric begin");
    aiws.w().post(new LyricViewController.3(this, paramaiwn3, paramaiwn1, paramaiwn2));
  }
  
  public void a(LyricView paramLyricView)
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll = paramLyricView.a();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal = paramLyricView.a();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.setScrollListener(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$a);
  }
  
  protected void iA(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal != null) && (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.getWindowToken() != null)) {
      ThreadManager.getUIHandler().post(new LyricViewController.9(this, paramInt1, paramInt2));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll != null) && (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.getWindowToken() != null)) {
      ThreadManager.getUIHandler().post(new LyricViewController.10(this));
    }
  }
  
  public boolean isPlaying()
  {
    return this.mIsPlaying;
  }
  
  public void pause()
  {
    this.c.cancel(this.TASK_ID);
    this.mIsPlaying = false;
  }
  
  public void seek(int paramInt)
  {
    Log.d("ModuleController", "seek " + paramInt);
    aiws.w().post(new LyricViewController.5(this, paramInt));
  }
  
  public void start()
  {
    Log.d("ModuleController", "start");
    aiws.w().post(new LyricViewController.4(this));
    this.c.a(this.TASK_ID, 100L, 100L, this.jdField_b_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable);
    this.mIsPlaying = true;
  }
  
  public void stop()
  {
    Log.d("ModuleController", "stop");
    this.c.cancel(this.TASK_ID);
    this.abR = 0L;
    this.mIsPlaying = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixd
 * JD-Core Version:    0.7.0.1
 */