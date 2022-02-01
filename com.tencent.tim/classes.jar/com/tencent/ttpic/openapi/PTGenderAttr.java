package com.tencent.ttpic.openapi;

import java.util.ArrayList;

public class PTGenderAttr
{
  public static final int GENDER_FEMALE = 0;
  public static final int GENDER_MALE = 1;
  private ArrayList<GenderInfo> genderInfos;
  
  public void addGenderInfo(long paramLong, float[] paramArrayOfFloat, int paramInt1, int paramInt2, float paramFloat)
  {
    if (this.genderInfos == null) {
      this.genderInfos = new ArrayList();
    }
    this.genderInfos.add(new GenderInfo(paramLong, paramArrayOfFloat, paramInt1, paramInt2, paramFloat));
  }
  
  public ArrayList<GenderInfo> getGenderInfos()
  {
    return this.genderInfos;
  }
  
  public class GenderInfo
  {
    public float confidence;
    public int curGender;
    public long faceId;
    public int gender;
    public float[] rect = new float[4];
    
    GenderInfo(long paramLong, float[] paramArrayOfFloat, int paramInt1, int paramInt2, float paramFloat)
    {
      this.faceId = paramLong;
      this.rect = paramArrayOfFloat;
      this.gender = paramInt1;
      this.confidence = paramFloat;
      this.curGender = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.PTGenderAttr
 * JD-Core Version:    0.7.0.1
 */