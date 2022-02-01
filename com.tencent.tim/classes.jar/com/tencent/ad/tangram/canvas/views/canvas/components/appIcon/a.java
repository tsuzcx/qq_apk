package com.tencent.ad.tangram.canvas.views.canvas.components.appIcon;

import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.c;

public class a
  extends AdCanvasComponentData
{
  public c adCanvasAppBtnComponentData;
  public long downloadCount = 0L;
  public long fileSize = 0L;
  public int logoHeight;
  public String logoUrl = null;
  public int logoWidth;
  public int marginBottom = 0;
  public int marginLeft = 0;
  public int marginRight = 0;
  public int marginTop = 0;
  public String name = null;
  public int starCount = 0;
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.logoUrl)) && (!TextUtils.isEmpty(this.name));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appIcon.a
 * JD-Core Version:    0.7.0.1
 */