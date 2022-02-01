package com.tencent.ttpic.model;

import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.HashSet;
import java.util.Set;

public class MultiViewerItem
{
  public Set<Integer> activeParts = new HashSet();
  public boolean needOriginFrame = true;
  public int renderId;
  public VideoMaterial videoMaterial;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.model.MultiViewerItem
 * JD-Core Version:    0.7.0.1
 */