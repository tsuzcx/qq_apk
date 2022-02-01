import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.filter.AESimpleSticker;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIAttrProvider;
import com.tencent.filter.BaseFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.facedetect.TTFaceOriginDataModel;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.filter.FacePointsFilter;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.FaceDetectUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.util.ArrayList;
import java.util.List;
import java.util.List<Liqa;>;
import org.jetbrains.annotations.NotNull;

public class ipr
  extends ipy
{
  private final String TAG = "AEFilter-" + Integer.toHexString(hashCode());
  private boolean TV;
  private boolean TW;
  private AESimpleSticker jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker;
  private FacePointsFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter;
  private AIAttr aiAttr = new AIAttr(new AIAttrProvider(null));
  private Frame b;
  private BaseFilter copyFilter;
  private boolean debug;
  private VideoMaterial material;
  private String materialPath;
  private boolean needSegment;
  
  public ipr()
  {
    super(1);
  }
  
  private Frame a(List<iqa.a> paramList, Frame paramFrame)
  {
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      float[][] arrayOfFloat = ((TTFaceOriginDataModel)((iqa.a)paramList.get(i)).fo.get(0)).facePoint;
      ArrayList localArrayList2 = new ArrayList(arrayOfFloat.length);
      int j = 0;
      while (j < arrayOfFloat.length)
      {
        localArrayList2.add(new PointF(arrayOfFloat[j][0], arrayOfFloat[j][1]));
        j += 1;
      }
      localArrayList1.add(localArrayList2);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter.updateVideoSize(paramFrame.width, paramFrame.height, 1.0D);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter.updateMultiPoints(localArrayList1);
    return this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter.render(paramFrame);
  }
  
  @NotNull
  protected Frame a(List<iqa> paramList, long paramLong)
  {
    Object localObject2 = (iqa)paramList.get(0);
    Object localObject1 = ((iqa)paramList.get(0)).frame;
    this.copyFilter.RenderProcess(((Frame)localObject1).getTextureId(), ((Frame)localObject1).width, ((Frame)localObject1).height, -1, 0.0D, this.b);
    paramList = this.b;
    ArrayList localArrayList = new ArrayList();
    if (((iqa)localObject2).ve())
    {
      int i = 0;
      while (i < ((iqa)localObject2).fp.size())
      {
        localArrayList.addAll(((iqa.a)((iqa)localObject2).fp.get(i)).fo);
        i += 1;
      }
    }
    localObject1 = FaceDetectUtil.genFaceAttr(localArrayList, ((Frame)localObject1).width, ((Frame)localObject1).height, 0);
    this.aiAttr.setFaceAttr(localObject1);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.setAIAttr(this.aiAttr);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.setFaceAttr((PTFaceAttr)localObject1);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.updateVideoSize(paramList.width, paramList.height, ((PTFaceAttr)localObject1).getFaceDetectScale());
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.setRatio(paramList.width / paramList.height);
    localObject1 = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.render(paramList);
    if ((paramList != localObject1) && (!paramList.unlock())) {
      paramList.clear();
    }
    if ((this.debug) && (((iqa)localObject2).ve()))
    {
      localObject2 = a(((iqa)localObject2).fp, (Frame)localObject1);
      paramList = (List<iqa>)localObject2;
      if (localObject2 != localObject1)
      {
        paramList = (List<iqa>)localObject2;
        if (!((Frame)localObject1).unlock()) {
          ((Frame)localObject1).clear();
        }
      }
    }
    for (paramList = (List<iqa>)localObject2;; paramList = (List<iqa>)localObject1)
    {
      localObject1 = this.copyFilter.render(paramList);
      if (paramList != localObject1) {
        paramList.unlock();
      }
      return localObject1;
    }
  }
  
  public void jt(String paramString)
  {
    this.materialPath = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.clear();
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker = null;
      return;
    }
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker != null)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.clear();
      QLog.d(this.TAG, 1, "applyMaterial: sticker#" + Integer.toHexString(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.hashCode()) + " cleared");
    }
    this.material = VideoSDKMaterialParser.parseVideoMaterial(this.materialPath, "params");
    QLog.d(this.TAG, 1, "applyMaterial: parse material=" + this.material.getId());
    this.TV = VideoMaterialUtil.isGestureDetectMaterial(this.material);
    this.TW = VideoMaterialUtil.isBodyDetectMaterial(this.material);
    this.needSegment = VideoMaterialUtil.isSegmentMaterial(this.material);
    QLog.d(this.TAG, 1, "applyMaterial: gesture=" + this.TV + ", body=" + this.TW + ", segment=" + this.needSegment);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker = new AESimpleSticker(this.material);
    QLog.d(this.TAG, 1, "onInit: create sticker#" + Integer.toHexString(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.hashCode()) + ", material=" + this.material.getId());
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.apply();
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker != null)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.clear();
      QLog.d(this.TAG, 1, "onDestroy: sticker#" + Integer.toHexString(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.hashCode()) + " cleared");
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker = null;
    }
    if (this.b != null)
    {
      this.b.clear();
      QLog.d(this.TAG, 1, "onDestroy: frame#" + Integer.toHexString(this.b.hashCode()) + " cleared");
      this.b = null;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter.clear();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter = null;
    }
  }
  
  protected void onInit()
  {
    if ((this.material != null) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker == null))
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker = new AESimpleSticker(this.material);
      QLog.d(this.TAG, 1, "onInit: create sticker#" + Integer.toHexString(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.hashCode()) + ", material=" + this.material.getId());
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESimpleSticker.apply();
    }
    if ((this.debug) && (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter == null))
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter = new FacePointsFilter();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterFacePointsFilter.apply();
    }
    this.copyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    QLog.d(this.TAG, 1, "onInit: create filter#" + Integer.toHexString(this.copyFilter.hashCode()));
    this.copyFilter.apply();
    this.copyFilter.setRotationAndFlip(0, 0, 1);
    this.b = new Frame();
    QLog.d(this.TAG, 1, "onInit: create frame#" + Integer.toHexString(this.b.hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ipr
 * JD-Core Version:    0.7.0.1
 */