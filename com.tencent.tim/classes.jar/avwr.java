import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import cooperation.qzone.panorama.piece.PanoramaPieceManager;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class avwr
  implements GLSurfaceView.Renderer
{
  private avwo jdField_a_of_type_Avwo;
  private avwv jdField_a_of_type_Avwv;
  private avwy jdField_a_of_type_Avwy;
  private avxa.a jdField_a_of_type_Avxa$a;
  private Drawable gV;
  private int modeType;
  private int programId;
  private int showType;
  private int textureId;
  
  public avwr(avxa.a parama, avwo paramavwo)
  {
    this.jdField_a_of_type_Avxa$a = parama;
    this.showType = parama.getShowType();
    this.jdField_a_of_type_Avwv = parama.a();
    this.modeType = parama.PQ();
    this.jdField_a_of_type_Avwo = paramavwo;
  }
  
  public void ab(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Avwv != null) {
      this.jdField_a_of_type_Avwv.ab(paramFloat1, paramFloat2);
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    GLES20.glClear(16384);
    if ((this.jdField_a_of_type_Avxa$a != null) && (this.jdField_a_of_type_Avxa$a.aLS()))
    {
      this.gV = this.jdField_a_of_type_Avxa$a.bh();
      avxc.deleteTexture(this.textureId);
      if (this.gV != null) {
        this.textureId = avxc.a(((BitmapDrawable)this.gV).getBitmap(), false);
      }
      if (this.jdField_a_of_type_Avwo != null) {
        this.jdField_a_of_type_Avwo.Qe();
      }
    }
    if ((this.jdField_a_of_type_Avxa$a != null) && (this.jdField_a_of_type_Avxa$a.a() != null))
    {
      this.jdField_a_of_type_Avxa$a.a().eCk();
      this.jdField_a_of_type_Avwy = this.jdField_a_of_type_Avxa$a.a().a();
      this.jdField_a_of_type_Avwv.a(this.jdField_a_of_type_Avwy);
    }
    if (this.jdField_a_of_type_Avwv != null)
    {
      this.jdField_a_of_type_Avwv.setTextureId(this.textureId);
      this.jdField_a_of_type_Avwv.eCe();
      this.jdField_a_of_type_Avwv.eCf();
    }
  }
  
  public void onRecycled()
  {
    avxc.deleteTexture(this.textureId);
    avxc.b(this.jdField_a_of_type_Avwy);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    GLES20.glEnable(2884);
    float f = paramInt1 / paramInt2;
    if (this.jdField_a_of_type_Avwv != null) {
      this.jdField_a_of_type_Avwv.setScreenRatio(f);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    this.programId = avxb.getProgramId();
    GLES20.glUseProgram(this.programId);
    if (this.jdField_a_of_type_Avwv != null) {
      this.jdField_a_of_type_Avwv.aca(this.programId);
    }
    paramGL10 = this.jdField_a_of_type_Avxa$a.a();
    if ((paramGL10 != null) && (this.jdField_a_of_type_Avwv != null)) {
      paramGL10.bp(this.jdField_a_of_type_Avwv.bV());
    }
  }
  
  public void setScale(float paramFloat)
  {
    if (this.jdField_a_of_type_Avwv != null) {
      this.jdField_a_of_type_Avwv.setScale(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avwr
 * JD-Core Version:    0.7.0.1
 */