package com.tencent.ttpic.filament;

import android.opengl.Matrix;
import android.util.Log;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.MatrixUtil;

public abstract class FurBaseFilter
  extends VideoFilterBase
{
  private static final boolean DEBUG = true;
  private static final String TAG = FurBaseFilter.class.getSimpleName();
  
  public FurBaseFilter(ShaderCreateFactory.PROGRAM_TYPE paramPROGRAM_TYPE)
  {
    super(ShaderManager.getInstance().getShader(paramPROGRAM_TYPE));
  }
  
  public void updateParams(FurConfig paramFurConfig)
  {
    initAttribParams();
    addAttribParam(new AttributeParam("normal", paramFurConfig.normal, 3));
    Matrix.perspectiveM(new float[16], 0, 45.0F, 1.333333F, 0.1F, 500.0F);
    float[] arrayOfFloat1 = MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F);
    Object localObject = new float[16];
    Matrix.setIdentityM((float[])localObject, 0);
    Matrix.translateM((float[])localObject, 0, 0.0F, 0.0F, paramFurConfig.g_fZoom);
    float[] arrayOfFloat2 = new float[16];
    Matrix.setIdentityM(arrayOfFloat2, 0);
    Matrix.rotateM(arrayOfFloat2, 0, paramFurConfig.g_fSpinY, 0.0F, 1.0F, 0.0F);
    Matrix.multiplyMM(paramFurConfig.matWorld, 0, (float[])localObject, 0, arrayOfFloat2, 0);
    Matrix.multiplyMM(paramFurConfig.worldViewProjMat, 0, arrayOfFloat1, 0, paramFurConfig.matWorld, 0);
    localObject = new float[16];
    arrayOfFloat1 = new float[16];
    int j = 0;
    int i = 0;
    while (i < 4)
    {
      localObject[(i * 4)] = getAttribParam("normal").vertices[j];
      localObject[(i * 4 + 1)] = getAttribParam("normal").vertices[(j + 1)];
      localObject[(i * 4 + 2)] = getAttribParam("normal").vertices[(j + 2)];
      localObject[(i * 4 + 3)] = 1.0F;
      Matrix.multiplyMV(arrayOfFloat1, i * 4, paramFurConfig.matWorld, 0, (float[])localObject, i * 4);
      j += 3;
      i += 1;
    }
    localObject = new StringBuilder("[resultVec] \n");
    i = 0;
    while (i < 4)
    {
      j = 0;
      while (j < 4)
      {
        ((StringBuilder)localObject).append(arrayOfFloat1[(i * 4 + j)] + ", ");
        j += 1;
      }
      ((StringBuilder)localObject).append('\n');
      i += 1;
    }
    Log.d(TAG, ((StringBuilder)localObject).toString());
    addParam(new UniformParam.FloatParam("FurLength", 0.0F));
    addParam(new UniformParam.FloatParam("Layer", 0.0F));
    addParam(new UniformParam.FloatParam("UVScale", 1.0F));
    addParam(new UniformParam.Float3fParam("vGravity", paramFurConfig.g_vGravity[0], paramFurConfig.g_vGravity[1], paramFurConfig.g_vGravity[2]));
    addParam(new UniformParam.Mat4Param("worldViewProj", paramFurConfig.worldViewProjMat));
    addParam(new UniformParam.Mat4Param("matWorld", paramFurConfig.matWorld));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filament.FurBaseFilter
 * JD-Core Version:    0.7.0.1
 */