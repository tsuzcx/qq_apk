import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditGifImage;
import com.tencent.image.AbstractGifImage.DoAccumulativeRunnable;
import com.tencent.image.NativeGifImage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.widget.FastAnimationDrawable;

public class rbc
  extends rdb
  implements View.OnClickListener
{
  protected boolean aGy;
  protected double bm;
  protected int bpA = 50;
  protected int bpB;
  protected final int bpx = AbstractGifImage.DoAccumulativeRunnable.DELAY;
  protected int bpy;
  protected int bpz;
  protected LinearLayout dK;
  protected int delayTime = -1;
  protected TextView eu;
  protected TextView fg;
  protected SeekBar mSeekBar;
  protected int maxSpeed;
  
  public rbc(@NonNull rdc paramrdc)
  {
    super(paramrdc);
  }
  
  private void bse()
  {
    this.maxSpeed = awdu.eAn;
    this.bpB = (this.bpz * awdu.eAo);
    this.bm = ((this.maxSpeed - this.bpB) / 100.0D);
    if (QLog.isColorLevel()) {
      QLog.d("EditGifSpeedControl", 2, "calculateSpeedChangeByLimit | defaultY:" + this.bpz + " maxSpeed:" + this.maxSpeed + " minSpeed:" + this.bpB + " k1:" + this.bm);
    }
  }
  
  public void a(@NonNull rkm paramrkm)
  {
    if (this.delayTime == -1) {
      if (this.b.a.aGo)
      {
        paramrkm.a.bsS = ((int)this.b.a.a.getDuration());
        paramrkm.a.aGy = this.aGy;
        if (QLog.isColorLevel()) {
          QLog.d("EditGifSpeedControl", 2, "editVideoPrePublish | get defaultY:" + this.bpz + " isDelayTimeChange:" + this.aGy);
        }
      }
    }
    do
    {
      return;
      rkq localrkq = paramrkm.a;
      if (NativeGifImage.GIF_DEFAULT_DELAY != -1) {}
      for (int i = NativeGifImage.GIF_DEFAULT_DELAY;; i = awdu.bpx)
      {
        localrkq.bsS = i;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditGifSpeedControl", 2, "editVideoPrePublish | get delayTime:" + this.delayTime + " isDelayTimeChange:" + this.aGy);
      }
      paramrkm.a.bsS = this.delayTime;
      paramrkm.a.aGy = this.aGy;
      if (this.delayTime < this.bpz)
      {
        LpReportInfo_pf00064.allReport(628, 5, 3);
        return;
      }
    } while (this.delayTime <= this.bpz);
    LpReportInfo_pf00064.allReport(628, 5, 2);
  }
  
  public boolean onBackPressed()
  {
    boolean bool = false;
    if (this.b.bqq == 21)
    {
      NativeGifImage.QZONE_DELAY = this.bpz;
      if (this.b.a.a != null) {
        this.b.a.a.setDuration(NativeGifImage.QZONE_DELAY);
      }
      this.delayTime = this.bpz;
      this.bpA = this.bpy;
      if (QLog.isColorLevel()) {
        QLog.d("EditGifSpeedControl", 2, "onBackPressed | delayTime:" + this.delayTime + " barPosition:" + this.bpA);
      }
      this.dK.setVisibility(8);
      this.b.changeState(0);
      bool = true;
      LpReportInfo_pf00064.allReport(628, 5, 4);
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.dK.setVisibility(8);
      if (this.b.bqq == 21)
      {
        this.b.changeState(0);
        continue;
        onBackPressed();
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    NativeGifImage.QZONE_DELAY = -1;
    this.bpy = 50;
    if (QLog.isColorLevel()) {
      QLog.d("EditGifSpeedControl", 2, "onCreate | defaultX:" + this.bpy + " defaultY:" + this.bpz + " delayTime:" + this.delayTime);
    }
    bse();
    this.dK = ((LinearLayout)y(2131377926));
    this.eu = ((TextView)y(2131377921));
    this.eu.setOnClickListener(this);
    this.fg = ((TextView)y(2131377922));
    this.fg.setOnClickListener(this);
    this.mSeekBar = ((SeekBar)y(2131368029));
    this.mSeekBar.setVisibility(0);
    this.mSeekBar.setProgress(this.bpy);
    this.mSeekBar.setMax(100);
    this.mSeekBar.setOnSeekBarChangeListener(new rbd(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("EditGifSpeedControl", 2, "onDestroy | DEFAULT_DELAY:" + this.bpx);
    }
    AbstractGifImage.DoAccumulativeRunnable.DELAY = this.bpx;
    NativeGifImage.QZONE_DELAY = -1;
  }
  
  public void p(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      this.dK.setVisibility(8);
      return;
    }
    if (this.delayTime == -1)
    {
      if (!this.b.a.aGo) {
        break label194;
      }
      paramInt = (int)this.b.a.a.getDuration();
      this.delayTime = paramInt;
      this.bpz = paramInt;
    }
    for (NativeGifImage.QZONE_DELAY = paramInt;; NativeGifImage.QZONE_DELAY = paramInt)
    {
      bse();
      paramInt = (int)((this.bpz - this.bpB) / this.bm);
      this.bpA = paramInt;
      this.bpy = paramInt;
      this.dK.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("EditGifSpeedControl", 2, "editVideoStateChanged | delayTime:" + this.delayTime + " barPosition:" + this.bpA);
      }
      this.mSeekBar.setProgress(this.bpA);
      this.bpz = this.delayTime;
      this.bpy = this.bpA;
      return;
      label194:
      paramInt = NativeGifImage.GIF_DEFAULT_DELAY;
      this.delayTime = paramInt;
      this.bpz = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rbc
 * JD-Core Version:    0.7.0.1
 */