import android.media.AudioManager;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class agxc
  implements View.OnClickListener
{
  agxc(agxa paramagxa) {}
  
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
      if (agxa.a(this.this$0) != null)
      {
        boolean bool2 = agxa.a(this.this$0).isPlaying();
        if (bool2)
        {
          agxa.a(this.this$0).removeCallbacks(this.this$0.eu);
          ahau.JH("0X8004BE5");
          this.this$0.mAudioManager.abandonAudioFocus(agxa.a(this.this$0));
          agxa.a(this.this$0);
          label130:
          localObject = this.this$0.jdField_a_of_type_Agyc;
          if (bool2) {
            break label171;
          }
        }
        for (;;)
        {
          ((agyc)localObject).JU(bool1);
          break;
          agxa.b(this.this$0);
          agxa.c(this.this$0);
          break label130;
          label171:
          bool1 = false;
        }
        Object localObject = this.this$0.jdField_a_of_type_Aguk.b();
        agxa.a(this.this$0, (ArrayList[])localObject);
        String str = this.this$0.vE() + "(" + ahbj.g(this.this$0.jdField_a_of_type_Aguk.getFileSize()) + ")";
        this.this$0.a((ArrayList[])localObject, str);
        continue;
        this.this$0.djY();
        continue;
        int i = this.this$0.jdField_a_of_type_Aguk.bL();
        int j = this.this$0.jdField_a_of_type_Aguk.bK();
        if ((i == 6) && (j == 1) && (this.this$0.jdField_a_of_type_Aguk.a() != null)) {
          this.this$0.jdField_a_of_type_Aguk.a().djp();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agxc
 * JD-Core Version:    0.7.0.1
 */