import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.mobileqq.shortvideo.ptvfilter.DoodleMagicAlgoHandler.RenderPoint;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class xdc
  extends xct
{
  Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  public String a;
  ArrayList<DoodleMagicAlgoHandler.RenderPoint> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  CopyOnWriteArrayList<PointF> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  volatile boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  volatile boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  volatile boolean jdField_c_of_type_Boolean;
  boolean d;
  boolean e = false;
  
  public xdc(int paramInt, String paramString)
  {
    super(paramInt);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public Frame a(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Int = RendererUtils.createTexture();
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
    GLES20.glBindTexture(3553, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.bindFrame(this.jdField_c_of_type_Int, paramInt1, paramInt2, 1.0D);
    GLES20.glBindFramebuffer(36160, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getFBO());
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glFlush();
    return this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  }
  
  public void a()
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame != null) && (!this.e))
    {
      this.e = true;
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
      RendererUtils.clearTexture(this.jdField_c_of_type_Int);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.b = true;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xdc
 * JD-Core Version:    0.7.0.1
 */