import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class oqj
  implements ola
{
  private orh jdField_a_of_type_Orh;
  private orw jdField_a_of_type_Orw;
  private ory jdField_a_of_type_Ory;
  private osf c;
  
  private WSPlayerManager a()
  {
    if ((this.c != null) && (this.c.c != null)) {
      return this.c.c.a();
    }
    return null;
  }
  
  public void a(ole paramole, int paramInt, boolean paramBoolean) {}
  
  public void a(ole paramole, long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_Ory != null) && (!this.jdField_a_of_type_Ory.Hn()))
    {
      if (paramLong2 != 0L) {
        break label65;
      }
      this.jdField_a_of_type_Ory.setProgress(0.0F);
    }
    for (;;)
    {
      if ((paramLong1 > 2000L) && (this.jdField_a_of_type_Orh != null) && (!this.jdField_a_of_type_Orh.Hm())) {
        this.jdField_a_of_type_Orh.bgx();
      }
      return;
      label65:
      float f = (float)paramLong1 / (float)paramLong2;
      this.jdField_a_of_type_Ory.setProgress(f);
    }
  }
  
  public void a(ole paramole, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ory != null)
    {
      ooz.d("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoInitiate() show");
      this.jdField_a_of_type_Ory.bgI();
      this.jdField_a_of_type_Ory.setProgress(0.0F);
    }
  }
  
  public boolean a(ole paramole)
  {
    return false;
  }
  
  public void b(ole paramole) {}
  
  public void c(ole paramole)
  {
    ooz.d("WS_VIDEO_VerticalUIDelegate", "WSVerticalPlayerUIDelegate onVideoViewLayoutSwitched()");
    if (this.jdField_a_of_type_Orw != null) {
      this.jdField_a_of_type_Orw.dB(8, 200);
    }
  }
  
  public void d(ole paramole)
  {
    if (this.jdField_a_of_type_Orw != null)
    {
      this.jdField_a_of_type_Orw.dB(8, 400);
      this.jdField_a_of_type_Orw.uW(8);
      this.jdField_a_of_type_Orw.bgH();
      this.jdField_a_of_type_Orw.hideErrorView();
    }
    if (this.jdField_a_of_type_Ory != null)
    {
      ooz.d("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoStart() hide");
      this.jdField_a_of_type_Ory.bgb();
    }
  }
  
  public void e(ole paramole)
  {
    if (this.jdField_a_of_type_Orw != null) {
      this.jdField_a_of_type_Orw.uW(0);
    }
  }
  
  public void e(osf paramosf)
  {
    this.c = paramosf;
    if (paramosf == null) {}
    do
    {
      do
      {
        return;
        if ((paramosf.a instanceof orb))
        {
          Object localObject = (orb)paramosf.a;
          ogm localogm = ((orb)localObject).b();
          if ((localogm instanceof orw)) {
            this.jdField_a_of_type_Orw = ((orw)localogm);
          }
          localObject = ((orb)localObject).c();
          if ((localObject instanceof ory)) {
            this.jdField_a_of_type_Ory = ((ory)localObject);
          }
        }
      } while (!(paramosf.a instanceof osl));
      paramosf = ((osl)paramosf.a).d();
    } while (!(paramosf instanceof orh));
    this.jdField_a_of_type_Orh = ((orh)paramosf);
  }
  
  public void f(ole paramole)
  {
    if (this.jdField_a_of_type_Orw != null)
    {
      this.jdField_a_of_type_Orw.uW(8);
      this.jdField_a_of_type_Orw.hideErrorView();
    }
  }
  
  public void g(ole paramole)
  {
    if (this.jdField_a_of_type_Orw != null)
    {
      this.jdField_a_of_type_Orw.bgH();
      this.jdField_a_of_type_Orw.dB(0, 100);
      this.jdField_a_of_type_Orw.uW(8);
    }
    if (this.jdField_a_of_type_Ory != null)
    {
      this.jdField_a_of_type_Ory.bgb();
      this.jdField_a_of_type_Ory.setProgress(0.0F);
    }
  }
  
  public void h(ole paramole)
  {
    if (this.jdField_a_of_type_Orw != null)
    {
      this.jdField_a_of_type_Orw.bgG();
      paramole = a();
      if ((paramole != null) && (paramole.isPause())) {
        this.jdField_a_of_type_Orw.uW(8);
      }
    }
  }
  
  public void i(ole paramole)
  {
    if (this.jdField_a_of_type_Ory != null)
    {
      ooz.d("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoBufferEnd() hide");
      this.jdField_a_of_type_Ory.bgb();
    }
    if (this.jdField_a_of_type_Orw != null)
    {
      this.jdField_a_of_type_Orw.bgH();
      paramole = a();
      if ((paramole != null) && (paramole.isPause())) {
        this.jdField_a_of_type_Orw.uW(0);
      }
    }
  }
  
  public void j(ole paramole)
  {
    if (this.jdField_a_of_type_Orw != null) {
      this.jdField_a_of_type_Orw.dB(0, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oqj
 * JD-Core Version:    0.7.0.1
 */