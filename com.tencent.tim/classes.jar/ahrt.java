import android.annotation.SuppressLint;
import android.os.Handler;
import android.widget.FrameLayout;
import com.tencent.mobileqq.gamecenter.view.FullPopVideoView;
import com.tencent.mobileqq.gamecenter.view.FullPopVideoView.a;

public class ahrt
  extends ahrq
  implements FullPopVideoView.a
{
  private ahsi a;
  @SuppressLint({"HandlerLeak"})
  private Handler cT;
  private int daR;
  private int daS;
  
  @SuppressLint({"NewApi"})
  private void dpu()
  {
    if (this.jdField_a_of_type_Ahsi != null)
    {
      ahsi localahsi = this.jdField_a_of_type_Ahsi;
      localahsi.top += this.daR;
      localahsi = this.jdField_a_of_type_Ahsi;
      localahsi.bottom -= this.daS;
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.setOutlineProvider(this.jdField_a_of_type_Ahsi);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.setClipToOutline(true);
      if (this.jdField_a_of_type_Ahsi.top > this.jdField_a_of_type_Ahsi.bottom)
      {
        this.cT.removeMessages(4);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.stop();
        this.bI.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.cT.sendEmptyMessageDelayed(4, 5L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahrt
 * JD-Core Version:    0.7.0.1
 */