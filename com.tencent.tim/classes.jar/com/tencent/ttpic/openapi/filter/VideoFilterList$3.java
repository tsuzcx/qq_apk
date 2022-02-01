package com.tencent.ttpic.openapi.filter;

import com.tencent.ttpic.face.Face;
import java.util.Comparator;

class VideoFilterList$3
  implements Comparator<Face>
{
  VideoFilterList$3(VideoFilterList paramVideoFilterList) {}
  
  public int compare(Face paramFace1, Face paramFace2)
  {
    return paramFace1.faceIndex - paramFace2.faceIndex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.VideoFilterList.3
 * JD-Core Version:    0.7.0.1
 */