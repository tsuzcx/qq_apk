package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.List;

public class LutItemsFilter
  implements AEFilterI
{
  private Bitmap bitmap;
  private PTDetectInfo detectInfo;
  private LutFilter lutFilter;
  
  public LutItemsFilter(List<StickerItem> paramList, String paramString)
  {
    this.lutFilter = new LutFilter(paramString, (StickerItem)paramList.get(0));
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    if ((this.detectInfo != null) && (BitmapUtils.isLegal(this.bitmap))) {
      return render(paramFrame, this.detectInfo, 0, this.bitmap);
    }
    return null;
  }
  
  public void apply()
  {
    this.lutFilter.ApplyGLSLFilter();
  }
  
  public void clear()
  {
    this.lutFilter.clearGLSLSelf();
  }
  
  public Frame render(Frame paramFrame, PTDetectInfo paramPTDetectInfo, int paramInt, Bitmap paramBitmap)
  {
    return this.lutFilter.render(paramFrame, paramPTDetectInfo, paramBitmap);
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo)) {
      this.detectInfo = ((PTDetectInfo)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.LutItemsFilter
 * JD-Core Version:    0.7.0.1
 */