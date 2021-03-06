package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.model.ExpressionItem;
import java.io.File;
import java.util.List;

public class StarActItem
  extends FrameSourceItem
{
  private String[] filePaths;
  private int height;
  private int[] texId;
  private int width;
  
  public StarActItem(List<ExpressionItem> paramList, String paramString, BaseFilter paramBaseFilter)
  {
    super(paramBaseFilter);
    this.texId = new int[paramList.size()];
    this.filePaths = new String[paramList.size()];
    int i = 0;
    while (i < this.filePaths.length)
    {
      this.filePaths[i] = (paramString + File.separator + "expression" + File.separator + ((ExpressionItem)paramList.get(i)).expressionID);
      i += 1;
    }
  }
  
  public void clear()
  {
    GLES20.glDeleteTextures(this.texId.length, this.texId, 0);
  }
  
  public int getOrigHeight(int paramInt)
  {
    return this.height;
  }
  
  public int getOrigWidth(int paramInt)
  {
    return this.width;
  }
  
  public int getTexture(CanvasItem paramCanvasItem, long paramLong)
  {
    return this.texId[paramCanvasItem.index];
  }
  
  public void init()
  {
    int i = 0;
    GLES20.glGenTextures(this.texId.length, this.texId, 0);
    while (i < this.filePaths.length)
    {
      Object localObject = this.filePaths[i];
      localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, 720, 1280);
      if (BitmapUtils.isLegal((Bitmap)localObject))
      {
        this.width = ((Bitmap)localObject).getWidth();
        this.height = ((Bitmap)localObject).getHeight();
        GlUtil.loadTexture(this.texId[i], (Bitmap)localObject);
        ((Bitmap)localObject).recycle();
      }
      i += 1;
    }
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.model.StarActItem
 * JD-Core Version:    0.7.0.1
 */