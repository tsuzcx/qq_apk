import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import java.util.ArrayList;
import java.util.List;

public class axdf
  extends BaseFilter
{
  private List<Frame> Mv = new ArrayList();
  private Frame frame = new Frame();
  
  public axdf()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public Frame a()
  {
    float f1 = 2.0F / this.Mv.size();
    int i = 0;
    while (i < this.Mv.size())
    {
      float f2 = -1.0F + i * f1;
      float f3 = f2 + f1;
      setPositions(new float[] { f2, -1.0F, f2, 1.0F, f3, 1.0F, f3, -1.0F });
      Frame localFrame = (Frame)this.Mv.get(i);
      RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height, this.Mv.size() * 64, 64, -1, 0.0D, this.frame);
      i += 1;
    }
    return this.frame;
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    this.frame.clear();
  }
  
  public void oE(List<Frame> paramList)
  {
    this.Mv = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axdf
 * JD-Core Version:    0.7.0.1
 */