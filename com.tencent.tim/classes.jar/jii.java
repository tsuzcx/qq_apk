import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;

class jii
  extends iya
{
  String Rj = "AVRedbag_GameMode";
  
  jii(jih paramjih) {}
  
  protected void a(iya.b paramb)
  {
    AVActivity localAVActivity = this.this$0.getAVActivity();
    if ((!this.this$0.xu()) || (localAVActivity == null)) {
      return;
    }
    if (paramb.avB == 1) {
      iwu.b(this.this$0.mApp, 1045, 2131698031);
    }
    for (;;)
    {
      paramb.Wa = true;
      paramb.Rj = this.Rj;
      return;
      if (paramb.avB == 2) {
        iwu.b(this.this$0.mApp, 1045, 2131698030);
      }
    }
  }
  
  protected void a(iya.c paramc)
  {
    jht localjht = this.this$0.a();
    if (localjht == null) {}
    int i;
    do
    {
      do
      {
        return;
      } while (!localjht.wI());
      i = paramc.W().getId();
    } while ((i != 2131697529) && (i != 2131697530));
    if (i == 2131697529) {
      this.this$0.aAb = paramc.avD;
    }
    paramc.Rj = this.Rj;
    paramc.VZ = false;
  }
  
  protected void c(iya.d paramd)
  {
    AVActivity localAVActivity = this.this$0.getAVActivity();
    if ((!this.this$0.xu()) || (localAVActivity == null)) {
      return;
    }
    iwu.b(this.this$0.mApp, 1045, 2131698026);
    paramd.Wa = true;
    paramd.Rj = this.Rj;
  }
  
  protected void d(iya.d paramd)
  {
    AVActivity localAVActivity = this.this$0.getAVActivity();
    if ((!this.this$0.xu()) || (localAVActivity == null)) {
      return;
    }
    iwu.b(this.this$0.mApp, 1045, 2131698028);
    paramd.Wa = true;
    paramd.Rj = this.Rj;
  }
  
  protected void e(iya.d paramd)
  {
    jht localjht = this.this$0.a();
    if (localjht == null) {}
    while ((localjht.a == null) || (localjht.a.b == null) || (localjht.a.b.Zx) || (!this.this$0.mApp.b().b().PY) || (this.this$0.getAVActivity() == null) || (!this.this$0.xu())) {
      return;
    }
    iwu.b(this.this$0.mApp, 1045, 2131698027);
    paramd.Wa = true;
    paramd.Rj = this.Rj;
  }
  
  protected void f(iya.d paramd)
  {
    paramd = this.this$0.a();
    if ((paramd != null) && (paramd.wI())) {
      jij.awH();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jii
 * JD-Core Version:    0.7.0.1
 */