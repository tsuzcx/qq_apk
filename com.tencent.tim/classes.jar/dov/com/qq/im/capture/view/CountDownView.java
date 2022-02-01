package dov.com.qq.im.capture.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ttpic.baseutils.audio.PlayerUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil.Player;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;

public class CountDownView
  extends RelativeLayout
{
  private static final String TAG = CountDownView.class.getSimpleName();
  private PlayerUtil.Player jdField_a_of_type_ComTencentTtpicBaseutilsAudioPlayerUtil$Player;
  private b jdField_a_of_type_DovComQqImCaptureViewCountDownView$b;
  private TextView ahE;
  private PlayerUtil.Player b;
  private Animation bi;
  private boolean dwQ;
  private int eIq;
  private AtomicBoolean eO = new AtomicBoolean(true);
  private Handler mHandler = new a(this);
  
  public CountDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bi = AnimationUtils.loadAnimation(paramContext, 2130772020);
  }
  
  private void aeM(int paramInt)
  {
    this.eIq = paramInt;
    if (paramInt == 0)
    {
      setVisibility(4);
      if (this.jdField_a_of_type_DovComQqImCaptureViewCountDownView$b != null) {
        this.jdField_a_of_type_DovComQqImCaptureViewCountDownView$b.eHn();
      }
      return;
    }
    String str = String.format(getResources().getConfiguration().locale, "%d", new Object[] { Integer.valueOf(paramInt) });
    this.ahE.setText(str);
    this.bi.reset();
    this.ahE.clearAnimation();
    this.ahE.startAnimation(this.bi);
    if (this.dwQ) {
      if (this.eO.get()) {
        this.eO.set(false);
      }
    }
    try
    {
      Thread.sleep(150L);
      if (paramInt == 1)
      {
        PlayerUtil.startPlayer(this.jdField_a_of_type_ComTencentTtpicBaseutilsAudioPlayerUtil$Player, true);
        this.mHandler.sendEmptyMessageDelayed(1, 1000L);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        LogUtils.e(localInterruptedException);
        continue;
        if (paramInt <= 3) {
          PlayerUtil.startPlayer(this.b, true);
        }
      }
    }
  }
  
  public void cA(int paramInt, boolean paramBoolean)
  {
    if (paramInt <= 0)
    {
      LogUtils.w(TAG, "Invalid input for countdown timer: " + paramInt + " seconds");
      return;
    }
    setVisibility(0);
    this.dwQ = paramBoolean;
    aeM(paramInt);
  }
  
  public void cjE()
  {
    if (this.eIq > 0)
    {
      this.eIq = 0;
      this.mHandler.removeMessages(1);
      setVisibility(4);
      if (this.jdField_a_of_type_DovComQqImCaptureViewCountDownView$b != null) {
        this.jdField_a_of_type_DovComQqImCaptureViewCountDownView$b.eHm();
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.ahE = ((TextView)findViewById(2131377104));
  }
  
  public void setCountDownListener(b paramb)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewCountDownView$b = paramb;
  }
  
  static final class a
    extends Handler
  {
    private WeakReference<CountDownView> weakReference;
    
    public a(CountDownView paramCountDownView)
    {
      this.weakReference = new WeakReference(paramCountDownView);
    }
    
    public void a(CountDownView paramCountDownView, @NotNull Message paramMessage)
    {
      if (paramMessage.what == 1) {
        CountDownView.a(paramCountDownView, CountDownView.a(paramCountDownView) - 1);
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (this.weakReference.get() == null)
      {
        removeCallbacksAndMessages(null);
        return;
      }
      try
      {
        a((CountDownView)this.weakReference.get(), paramMessage);
        return;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void eHm();
    
    public abstract void eHn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.CountDownView
 * JD-Core Version:    0.7.0.1
 */