package com.tencent.ad.tangram.canvas.views.canvas.components.pictures;

import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentData;
import java.util.ArrayList;

public class a
  extends AdCanvasComponentData
{
  public int floatingBarBackgroundColor;
  public int floatingBarTextColor;
  public ArrayList<com.tencent.ad.tangram.canvas.views.canvas.components.picture.a> imageList;
  
  public int getToLoadIdSize()
  {
    int j = 0;
    int i = j;
    if (isValid())
    {
      i = j;
      if (this.imageList != null) {
        i = 0 + this.imageList.size();
      }
    }
    return i;
  }
  
  public boolean isValid()
  {
    return super.isValid();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.pictures.a
 * JD-Core Version:    0.7.0.1
 */