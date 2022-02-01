import android.os.Message;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.view.RotationSeekBar;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;

public class ayhq
  extends aygy
{
  private int Gs = -1;
  private aytw a;
  private ImageButton aR;
  private TextView ahW;
  private TextView ahX;
  private RotationSeekBar jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewRotationSeekBar;
  private HWEditLocalVideoPlayer jdField_b_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer;
  private axro c;
  private double dx = 1.0D;
  private int eKh = 0;
  private LinearLayout mw;
  private long videoDuration = -1L;
  
  public ayhq(@NonNull aytw paramaytw)
  {
    super(paramaytw);
    this.a = paramaytw;
  }
  
  private void eRO()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)y(2131366264);
    this.mw = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2131562453, localRelativeLayout, false));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, wja.dp2px(40.0F, getResources()));
    LinearLayout localLinearLayout = this.mw;
    if (this.a.dAK)
    {
      i = 0;
      localLinearLayout.setVisibility(i);
      localLayoutParams.addRule(12);
      if (ayxa.eMW <= 0) {
        break label120;
      }
    }
    label120:
    for (int i = ayxa.eMW + wja.dp2px(40.0F, getResources());; i = wja.dp2px(100.0F, getResources()))
    {
      localLayoutParams.bottomMargin = i;
      localRelativeLayout.addView(this.mw, localLayoutParams);
      return;
      i = 8;
      break;
    }
  }
  
  private void eRP()
  {
    if ((this.videoDuration < 0L) && (this.a.a != null) && (this.a.a.b() != null))
    {
      this.videoDuration = this.a.a.b().mDuration;
      this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer = this.a.a;
      this.c = ((axro)axov.a().c(8));
      if ((this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.RU() != 1) || (this.eKh == 1)) {
        break label109;
      }
      this.aR.setImageResource(2130848554);
      this.eKh = 1;
    }
    label109:
    while ((this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.RU() != 2) || (this.eKh == 2)) {
      return;
    }
    this.aR.setImageResource(2130848553);
    this.eKh = 2;
  }
  
  private static String getTimeString(long paramLong)
  {
    paramLong /= 1000L;
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  private void pause()
  {
    if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer != null) {
      this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.pause();
    }
    if (this.c != null) {
      this.c.Zx();
    }
  }
  
  private void resume()
  {
    if (this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer != null) {
      this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.play();
    }
    if (this.c != null) {
      this.c.resumeMusic();
    }
  }
  
  protected boolean e(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.e(paramMessage);
      long l;
      int i;
      if (this.a.dAK)
      {
        eRP();
        if (this.videoDuration > 0L)
        {
          l = ((Long[])(Long[])paramMessage.obj)[0].longValue();
          if (this.dx <= 0.0D) {
            break label257;
          }
          i = (int)(l * 100L / this.videoDuration);
          if ((i >= this.Gs) || (this.Gs >= 95) || (i <= 5)) {
            break label249;
          }
          i = this.Gs;
          QLog.d("EditVideo - progressBar", 2, "progress = " + i + "；lastProgress = " + this.Gs + "; need to reset");
          this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewRotationSeekBar.setProgress(i);
          this.ahW.setText(getTimeString((l * this.dx)));
          this.ahX.setText(getTimeString((this.videoDuration * this.dx)));
        }
        label214:
        if ((this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.RU() != 1) || (this.eKh == 1)) {
          break label315;
        }
        this.aR.setImageResource(2130848554);
      }
      for (this.eKh = 1;; this.eKh = 2)
      {
        label249:
        do
        {
          return true;
          this.Gs = i;
          break;
          i = (int)((this.videoDuration - l) * 100L / this.videoDuration);
          this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewRotationSeekBar.setProgress(i);
          this.ahW.setText(getTimeString(this.videoDuration - l));
          this.ahX.setText(getTimeString(this.videoDuration));
          break label214;
        } while ((this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.RU() != 2) || (this.eKh == 2));
        label257:
        label315:
        this.aR.setImageResource(2130848553);
      }
      if (paramMessage.arg1 == 28) {
        switch (paramMessage.arg2)
        {
        default: 
          break;
        case 0: 
          this.dx = 0.25D;
          break;
        case 4: 
          this.dx = 4.0D;
          break;
        case 3: 
          this.dx = 2.0D;
          break;
        case 2: 
          this.dx = 1.0D;
          break;
        case 1: 
          this.dx = 0.5D;
          break;
        case 5: 
          this.dx = -1.0D;
        }
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    eRO();
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewRotationSeekBar = ((RotationSeekBar)y(2131366171));
    this.aR = ((ImageButton)y(2131366172));
    this.ahW = ((TextView)y(2131366173));
    this.ahX = ((TextView)y(2131366170));
    this.aR.setOnClickListener(new ayhr(this));
    this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewRotationSeekBar.setEnabled(true);
  }
  
  public void p(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      this.mw.setVisibility(8);
      return;
    }
    if (this.a.dAK)
    {
      this.mw.setVisibility(0);
      return;
    }
    this.mw.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayhq
 * JD-Core Version:    0.7.0.1
 */