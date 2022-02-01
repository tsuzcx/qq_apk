package com.qq.ac.sdk.bean;

import java.util.List;
import java.util.Map;

public final class AcMultiPictureListResponse
  extends BaseResponse<List<AcPicture>>
{
  public final Map<String, List<AcPicture>> getData()
  {
    return this.mapData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.qq.ac.sdk.bean.AcMultiPictureListResponse
 * JD-Core Version:    0.7.0.1
 */