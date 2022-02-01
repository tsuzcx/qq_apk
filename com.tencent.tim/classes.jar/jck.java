import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

class jck
  implements View.OnTouchListener
{
  jck(jci paramjci) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = jci.a(this.b).wv();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      int i = Calendar.getInstance().get(11) * 60 + Calendar.getInstance().get(12);
      if (paramView.getId() == 2131374210)
      {
        jci.a(this.b, 0);
        if (((jci.a(this.b).b().amX != 2) && (jci.a(this.b).b().amX != 3)) || (jci.b(this.b) == 2) || (jci.b(this.b) == 3) || (bool) || (!jll.xQ())) {
          break label616;
        }
        jci.a(this.b, true);
        paramView = new jcm(this);
        if ((jci.a(this.b).b().amY <= i) && (i < jci.a(this.b).b().amZ)) {
          break label590;
        }
        paramView = aqha.a(jci.a(this.b), 0, null, acfp.m(2131710324), acfp.m(2131710322), acfp.m(2131710321), paramView, paramView);
        if (paramView != null)
        {
          paramView.show();
          jll.axM();
        }
      }
      for (;;)
      {
        anot.a(null, "CliOper", "", "", "0X800A564", "0X800A564", 0, 0, "", "", "", "");
        return false;
        if (paramView.getId() == 2131374213)
        {
          jci.a(this.b, 1);
          break;
        }
        QLog.i("QavDoubleVideoSharpnessMangaer", 1, "hdModeFreeUse. curMinute = " + i + ", startTime = " + jci.a(this.b).b().amY + ", endTime = " + jci.a(this.b).b().amZ + ", tips = " + jci.a(this.b).b().MV);
        if ((bool) || ((jci.a(this.b).b().amY <= i) && (i < jci.a(this.b).b().amZ)))
        {
          if (paramView.getId() == 2131374220)
          {
            jci.a(this.b, 2);
            break;
          }
          jci.a(this.b, 3);
          break;
        }
        jci.a(this.b, true);
        if (paramView.getId() == 2131374220) {
          jci.b(this.b, 2);
        }
        for (;;)
        {
          paramView = new jcl(this);
          if ((jci.a(this.b).b().amY > i) || (i >= jci.a(this.b).b().amZ))
          {
            paramView = aqha.a(jci.a(this.b), 0, acfp.m(2131710318), null, acfp.m(2131710319), acfp.m(2131710320), paramView, paramView);
            if (paramView != null) {
              paramView.show();
            }
          }
          anot.a(null, "CliOper", "", "", "0X800A562", "0X800A562", 0, 0, "", "", "", "");
          return false;
          jci.b(this.b, 3);
        }
        label590:
        this.b.atC();
        jci.a(this.b, false);
        jci.a(this.b);
      }
      label616:
      jci.a(this.b);
      anot.a(null, "CliOper", "", "", "0X800A344", "0X800A344", jci.b(this.b) + 1, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jck
 * JD-Core Version:    0.7.0.1
 */