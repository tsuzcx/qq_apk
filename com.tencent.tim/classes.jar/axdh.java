import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.filter.AEGifSticker;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.view.RendererUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class axdh
{
  private axde jdField_a_of_type_Axde = new axde();
  private axdh.a jdField_a_of_type_Axdh$a;
  private AEGifSticker jdField_a_of_type_ComTencentAekitApiStandardFilterAEGifSticker;
  private BaseFilter d = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private boolean dug = true;
  private boolean duh;
  private BaseFilter e = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private double faceDetectScale = 1.0D;
  private Frame k = new Frame();
  private Frame l = new Frame();
  private int surfaceHeight;
  private int surfaceWidth;
  
  private Frame a(Frame paramFrame, List<List<PointF>> paramList, List<float[]> paramList1)
  {
    Object localObject = paramFrame;
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEGifSticker != null)
    {
      localObject = new HashSet();
      ((Set)localObject).add(Integer.valueOf(1));
      ((Set)localObject).add(Integer.valueOf(2));
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEGifSticker.updateFaceParams(paramList, paramList1, (Set)localObject);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEGifSticker.updateVideoSize(paramFrame.width, paramFrame.height, this.faceDetectScale * 2.0D);
      localObject = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEGifSticker.render(paramFrame);
    }
    return localObject;
  }
  
  public void Yb(boolean paramBoolean)
  {
    this.duh = paramBoolean;
  }
  
  public Frame a(Frame paramFrame, int paramInt1, int paramInt2, List<List<PointF>> paramList, List<float[]> paramList1)
  {
    if (this.dug)
    {
      this.jdField_a_of_type_Axde.a(paramFrame, paramInt1, paramInt2, this.k);
      paramFrame = this.k;
    }
    for (;;)
    {
      if ((this.duh) && (this.jdField_a_of_type_Axdh$a != null))
      {
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        float f1 = -1.0F + this.jdField_a_of_type_Axdh$a.x * 2.0F;
        float f2 = -1.0F + this.jdField_a_of_type_Axdh$a.y * 2.0F;
        float f3 = this.jdField_a_of_type_Axdh$a.width * 2.0F + f1;
        float f4 = this.jdField_a_of_type_Axdh$a.height * 2.0F + f2;
        this.d.setPositions(new float[] { f1, f2, f1, f4, f3, f4, f3, f2 });
        this.d.RenderProcess(this.jdField_a_of_type_Axdh$a.eED, paramFrame.width, paramFrame.height, -1, 0.0D, paramFrame);
        GLES20.glDisable(3042);
      }
      this.e.RenderProcess(paramFrame.getTextureId(), 320, 320, -1, 0.0D, this.l);
      return a(this.l, paramList, paramList1);
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_Axdh$a = new axdh.a();
    axdm localaxdm = new axdm((int)(320.0F * paramFloat3), (int)(320.0F * paramFloat4));
    localaxdm.setText(paramString1);
    localaxdm.setTextSize(paramInt1);
    localaxdm.setTextColor(paramString2);
    localaxdm.setOutlineColor(paramString3);
    localaxdm.setOutlineWidth(paramInt2);
    localaxdm.draw();
    paramString1 = localaxdm.aT();
    this.jdField_a_of_type_Axdh$a.eED = RendererUtils.createTexture(paramString1);
    localaxdm.release();
    this.jdField_a_of_type_Axdh$a.x = paramFloat1;
    this.jdField_a_of_type_Axdh$a.y = paramFloat2;
    this.jdField_a_of_type_Axdh$a.width = paramFloat3;
    this.jdField_a_of_type_Axdh$a.height = paramFloat4;
  }
  
  public void acp(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEGifSticker != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEGifSticker.clear();
    }
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEGifSticker = new AEGifSticker(paramString);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEGifSticker.apply();
  }
  
  public void clear()
  {
    this.jdField_a_of_type_Axde.ClearGLSL();
    this.k.clear();
    this.d.ClearGLSL();
    this.e.ClearGLSL();
    this.l.clear();
    if (this.jdField_a_of_type_Axdh$a != null)
    {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = this.jdField_a_of_type_Axdh$a.eED;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    }
  }
  
  public void initial()
  {
    this.jdField_a_of_type_Axde.apply();
    this.d.apply();
    this.e.apply();
  }
  
  public void onSurfaceChanged(int paramInt1, int paramInt2)
  {
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
  }
  
  public void setFaceDetectScale(double paramDouble)
  {
    this.faceDetectScale = paramDouble;
  }
  
  class a
  {
    public int eED;
    public float height;
    public float width;
    public float x;
    public float y;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axdh
 * JD-Core Version:    0.7.0.1
 */