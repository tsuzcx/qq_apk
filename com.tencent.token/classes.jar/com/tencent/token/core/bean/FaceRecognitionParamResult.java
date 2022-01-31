package com.tencent.token.core.bean;

import java.io.Serializable;
import org.json.JSONObject;

public class FaceRecognitionParamResult
  implements Serializable
{
  private static final long serialVersionUID = -4652727647213939088L;
  public float mDisparityThres;
  public float mRegRayThres;
  public float mVerifyRayThres;
  
  public FaceRecognitionParamResult() {}
  
  public FaceRecognitionParamResult(JSONObject paramJSONObject)
  {
    this.mRegRayThres = ((float)paramJSONObject.getDouble("face_reg_thres"));
    this.mVerifyRayThres = ((float)paramJSONObject.getDouble("face_verify_thres"));
    this.mDisparityThres = ((float)paramJSONObject.getDouble("face_disparity_thres"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.FaceRecognitionParamResult
 * JD-Core Version:    0.7.0.1
 */