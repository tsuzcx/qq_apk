package com.tencent.component.media.image.region;

import android.graphics.Rect;
import java.util.LinkedList;

public class RegionBitmapBlockHelper
{
  public static final int REGION_BLOCK_SIZE = 1000;
  private Rect mImageRect;
  
  public RegionBitmapBlockHelper(Rect paramRect)
  {
    this.mImageRect = paramRect;
  }
  
  public LinkedList<RegionBitmapDecoder.DrawData> getDrawDatas(Rect paramRect, int paramInt)
  {
    if ((paramRect == null) || (paramRect.isEmpty())) {
      return null;
    }
    int i1 = paramInt * 1000;
    int n = paramRect.left / i1;
    int j = paramRect.right / i1;
    int i = j;
    if (paramRect.right % i1 != 0) {
      i = j + 1;
    }
    int k = paramRect.top / i1;
    int m = paramRect.bottom / i1;
    j = m;
    if (paramRect.bottom % i1 != 0) {
      j = m + 1;
    }
    paramRect = new LinkedList();
    while (k < j)
    {
      m = n;
      while (m < i)
      {
        Rect localRect = new Rect();
        localRect.left = (m * i1);
        localRect.right = (localRect.left + i1);
        localRect.top = (k * i1);
        localRect.bottom = (localRect.top + i1);
        if ((m + 1 == i) || (k + 1 == j)) {
          localRect.intersect(this.mImageRect);
        }
        RegionBitmapDecoder.DrawData localDrawData = new RegionBitmapDecoder.DrawData();
        localDrawData.mShowRect = localRect;
        localDrawData.mDecodeSample = paramInt;
        paramRect.add(localDrawData);
        m += 1;
      }
      k += 1;
    }
    return paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.region.RegionBitmapBlockHelper
 * JD-Core Version:    0.7.0.1
 */