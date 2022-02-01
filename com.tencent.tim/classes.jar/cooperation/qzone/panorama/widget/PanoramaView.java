package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.util.AttributeSet;
import avwn;
import avwo;
import avwp;
import avwq;
import avwq.a;
import avwr;
import avws;
import avxa.a;
import avxf;
import avxg;
import com.tencent.mobileqq.apollo.GLTextureView;

public class PanoramaView
  extends GLTextureView
{
  private avwp jdField_a_of_type_Avwp = new avxf(this);
  private avwq.a jdField_a_of_type_Avwq$a = new avxg(this);
  private avwq jdField_a_of_type_Avwq;
  private avwr jdField_a_of_type_Avwr;
  private avxa.a jdField_a_of_type_Avxa$a;
  private avwn b;
  private Context context;
  
  public PanoramaView(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
  }
  
  public PanoramaView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public void ac(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Avwr != null) {
      this.jdField_a_of_type_Avwr.ab(paramFloat1, paramFloat2);
    }
  }
  
  public void b(avxa.a parama, avwo paramavwo)
  {
    if (parama == null) {
      return;
    }
    this.jdField_a_of_type_Avxa$a = parama;
    setEGLContextClientVersion(2);
    this.jdField_a_of_type_Avwr = new avwr(parama, paramavwo);
    setRenderer(this.jdField_a_of_type_Avwr);
    setRenderMode(parama.getRenderMode());
    if (parama.aLO()) {
      setOnTouchListener(new avws(this, this.context, this.jdField_a_of_type_Avwp, parama));
    }
    this.jdField_a_of_type_Avwq = new avwq(this.context, this.jdField_a_of_type_Avwq$a);
  }
  
  public String getRenderThreadName()
  {
    return "PanoramaViewThread";
  }
  
  public void hb(int paramInt)
  {
    if (this.jdField_a_of_type_Avxa$a == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Avxa$a.b(paramInt);
      setRenderMode(paramInt);
      if (paramInt == 0) {
        this.jdField_a_of_type_Avxa$a.a(false);
      }
      while ((this.jdField_a_of_type_Avwq != null) && (this.jdField_a_of_type_Avxa$a.aLN()))
      {
        this.jdField_a_of_type_Avwq.eCa();
        return;
        this.jdField_a_of_type_Avxa$a.a(true);
      }
    }
  }
  
  public void onPause()
  {
    if ((this.jdField_a_of_type_Avwr != null) && (this.jdField_a_of_type_Avxa$a != null))
    {
      super.onPause();
      if ((this.jdField_a_of_type_Avwq != null) && (this.jdField_a_of_type_Avxa$a.aLN())) {
        this.jdField_a_of_type_Avwq.eCb();
      }
    }
  }
  
  public void onRecycled()
  {
    if (this.jdField_a_of_type_Avwr != null)
    {
      super.onPause();
      if (this.jdField_a_of_type_Avwq != null) {
        this.jdField_a_of_type_Avwq.eCb();
      }
      if (this.jdField_a_of_type_Avwr != null) {
        this.jdField_a_of_type_Avwr.onRecycled();
      }
    }
  }
  
  public void onResume()
  {
    if ((this.jdField_a_of_type_Avwr != null) && (this.jdField_a_of_type_Avxa$a != null))
    {
      this.jdField_a_of_type_Avxa$a.WS(true);
      super.onResume();
      if ((this.jdField_a_of_type_Avwq != null) && (this.jdField_a_of_type_Avxa$a.aLN())) {
        this.jdField_a_of_type_Avwq.eCa();
      }
    }
  }
  
  public void setOnPanoramaClickListener(avwn paramavwn)
  {
    this.b = paramavwn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaView
 * JD-Core Version:    0.7.0.1
 */