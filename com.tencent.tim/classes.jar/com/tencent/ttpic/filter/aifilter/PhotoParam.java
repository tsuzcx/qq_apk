package com.tencent.ttpic.filter.aifilter;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public final class PhotoParam
{
  @SerializedName("face_rects")
  @NotNull
  private final ArrayList<FaceRect> faceRects;
  @SerializedName("raw_base64")
  @NotNull
  private final String photo;
  @SerializedName("token")
  @NotNull
  private final String token;
  
  public PhotoParam(@NotNull String paramString1, @NotNull String paramString2, @NotNull ArrayList paramArrayList)
  {
    this.photo = paramString1;
    this.token = paramString2;
    this.faceRects = paramArrayList;
  }
  
  @NotNull
  public final ArrayList<FaceRect> getFaceRects()
  {
    return this.faceRects;
  }
  
  @NotNull
  public final String getPhoto()
  {
    return this.photo;
  }
  
  @NotNull
  public final String getToken()
  {
    return this.token;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.PhotoParam
 * JD-Core Version:    0.7.0.1
 */