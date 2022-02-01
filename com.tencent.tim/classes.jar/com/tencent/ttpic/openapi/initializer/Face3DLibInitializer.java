package com.tencent.ttpic.openapi.initializer;

import com.google.gson.JsonArray;
import com.tencent.ttpic.filter.Face3DLibJNI;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.util.GsonUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Face3DLibInitializer
  extends Feature
{
  public static final ModelInfo[] FACE_3D_FILTER_MODEL;
  public static final ModelInfo[] FACE_3D_SO_MODEL;
  public static int[] face3DIndices = new int[20208];
  public static Face3DLibJNI face3DLibJNI;
  public static float[] face3DUV;
  public static final SharedLibraryInfo[] sharedLibraries = { new SharedLibraryInfo("face3DLib") };
  
  static
  {
    FACE_3D_SO_MODEL = new ModelInfo[] { new ModelInfo(true, "Face3DLib", "2DTo3D_Edge.txt"), new ModelInfo(true, "Face3DLib", "2DTo3D_Edge_16_youtu.txt"), new ModelInfo(true, "Face3DLib", "2DTo3Dyoutu.txt"), new ModelInfo(true, "Face3DLib", "forehead.txt"), new ModelInfo(true, "Face3DLib", "mean.bin"), new ModelInfo(true, "Face3DLib", "mouthandjaw.txt"), new ModelInfo(true, "Face3DLib", "normalised_pca_basis_roi.bin"), new ModelInfo(true, "Face3DLib", "sharevertex.txt"), new ModelInfo(true, "Face3DLib", "up.txt"), new ModelInfo(true, "Face3DLib", "All_68_youtu.txt"), new ModelInfo(true, "Face3DLib", "blendshape_47.bin"), new ModelInfo(true, "Face3DLib", "blendshape_47_nnls_68.bin") };
    FACE_3D_FILTER_MODEL = new ModelInfo[] { new ModelInfo(true, "Face3DLib", "face3d_indices_config.dat"), new ModelInfo(true, "Face3DLib", "face3d_uv_config.dat") };
    face3DLibJNI = Face3DLibJNI.getInstance();
    face3DUV = new float[17240];
  }
  
  private boolean loadFace3DIndices(String paramString1, String paramString2)
  {
    paramString1 = VideoTemplateParser.parseVideoMaterialFileAsJSONObject(paramString1, paramString2, false, VideoTemplateParser.decryptListener);
    if (paramString1 == null) {}
    do
    {
      return false;
      paramString1 = GsonUtils.optJsonArray(paramString1, "index");
    } while ((paramString1 == null) || (paramString1.size() == 0));
    int i = 0;
    while (i < paramString1.size())
    {
      face3DIndices[i] = GsonUtils.optInt(paramString1, i, 0);
      i += 1;
    }
    return true;
  }
  
  private boolean loadFace3DUV(String paramString1, String paramString2)
  {
    int i = 0;
    paramString1 = VideoTemplateParser.parseVideoMaterialFileAsJSONObject(paramString1, paramString2, false, VideoTemplateParser.decryptListener);
    if (paramString1 == null) {}
    do
    {
      return false;
      paramString1 = GsonUtils.optJsonArray(paramString1, "uv");
    } while ((paramString1 == null) || (paramString1.size() == 0));
    while (i < paramString1.size())
    {
      face3DUV[(i + 10344)] = ((float)GsonUtils.optDouble(paramString1, i, 0.0D));
      i += 1;
    }
    return true;
  }
  
  protected boolean destroyImpl()
  {
    return false;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, FACE_3D_SO_MODEL);
    Collections.addAll(localArrayList, FACE_3D_FILTER_MODEL);
    return localArrayList;
  }
  
  public String getName()
  {
    return "Face3DLib";
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return Arrays.asList(sharedLibraries);
  }
  
  public boolean initFace3D()
  {
    if (!loadAllSoFiles()) {}
    while ((!loadFace3DUV(getFinalResourcesDir(), "face3d_uv_config")) || (!loadFace3DIndices(getFinalResourcesDir(), "face3d_indices_config"))) {
      return false;
    }
    return face3DLibJNI.init(getFinalResourcesDir());
  }
  
  protected boolean initImpl()
  {
    return initFace3D();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.Face3DLibInitializer
 * JD-Core Version:    0.7.0.1
 */