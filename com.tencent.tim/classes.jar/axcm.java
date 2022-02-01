import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.filter.BaseFilter;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class axcm
{
  private List<Frame> Fw = new ArrayList();
  private axdf jdField_a_of_type_Axdf = new axdf();
  private axdg jdField_a_of_type_Axdg = new axdg();
  private axcm.a b;
  private BaseFilter copyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  
  private Bitmap aS()
  {
    this.jdField_a_of_type_Axdf.oE(this.Fw);
    return RendererUtils.saveTexture(this.jdField_a_of_type_Axdf.a());
  }
  
  public void b(int paramInt1, List<PointF> paramList, int paramInt2, int paramInt3)
  {
    paramList = this.jdField_a_of_type_Axdg.a(paramInt1, paramList, paramInt2, paramInt3);
    paramList = this.copyFilter.RenderProcess(paramList.getTextureId(), 64, 64);
    this.Fw.add(paramList);
  }
  
  public void clear()
  {
    Iterator localIterator = this.Fw.iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).clear();
    }
    this.copyFilter.clearGLSLSelf();
    this.jdField_a_of_type_Axdg.clearGLSLSelf();
    this.jdField_a_of_type_Axdf.clearGLSLSelf();
  }
  
  public void ctT()
  {
    if (!this.Fw.isEmpty())
    {
      AppInterface localAppInterface = QQStoryContext.c();
      axbm localaxbm = (axbm)localAppInterface.getBusinessHandler(3);
      localAppInterface.addObserver(new axcn(this, localAppInterface));
      localaxbm.ap(aS());
      return;
    }
    this.b.a(new axdd());
  }
  
  public int getFrameCount()
  {
    return this.Fw.size();
  }
  
  public void init()
  {
    this.copyFilter.apply();
    this.jdField_a_of_type_Axdg.apply();
    this.jdField_a_of_type_Axdf.apply();
  }
  
  public void reset()
  {
    Iterator localIterator = this.Fw.iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).unlock();
    }
    this.Fw.clear();
  }
  
  public void setRecommendTextCallback(axcm.a parama)
  {
    this.b = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(axdd paramaxdd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axcm
 * JD-Core Version:    0.7.0.1
 */