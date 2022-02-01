import android.media.AudioManager;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aucf
  implements View.OnClickListener
{
  aucf(aucd paramaucd) {}
  
  public void onClick(View paramView)
  {
    boolean bool1 = true;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (aucd.a(this.this$0) != null)
      {
        boolean bool2 = aucd.a(this.this$0).isPlaying();
        label130:
        aucv localaucv;
        if (bool2)
        {
          aucd.a(this.this$0).removeCallbacks(this.this$0.eu);
          ahau.JH("0X8004BE5");
          this.this$0.mAudioManager.abandonAudioFocus(aucd.a(this.this$0));
          aucd.a(this.this$0);
          localaucv = this.this$0.jdField_a_of_type_Aucv;
          if (bool2) {
            break label171;
          }
        }
        for (;;)
        {
          localaucv.JU(bool1);
          break;
          aucd.b(this.this$0);
          aucd.c(this.this$0);
          break label130;
          label171:
          bool1 = false;
        }
        this.this$0.djY();
        continue;
        int i = this.this$0.jdField_a_of_type_Atzy.bL();
        int j = this.this$0.jdField_a_of_type_Atzy.bK();
        if ((i == 6) && (j == 1) && (this.this$0.jdField_a_of_type_Atzy.a() != null)) {
          this.this$0.jdField_a_of_type_Atzy.a().djp();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aucf
 * JD-Core Version:    0.7.0.1
 */