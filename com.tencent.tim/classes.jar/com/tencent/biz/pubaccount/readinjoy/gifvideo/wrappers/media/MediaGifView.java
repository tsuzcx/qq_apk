package com.tencent.biz.pubaccount.readinjoy.gifvideo.wrappers.media;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.gif.GifView;
import lfu;

public class MediaGifView
  extends GifView
  implements lfu
{
  public MediaGifView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MediaGifView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MediaGifView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void aLR()
  {
    aLE();
  }
  
  public void aLS()
  {
    aLF();
  }
  
  public void aLT() {}
  
  public void aLU() {}
  
  public boolean isPlaying()
  {
    return false;
  }
  
  public void setMediaCoverUrl(String paramString)
  {
    setCoverUrl(paramString);
  }
  
  public void setMediaPlayUrl(String paramString)
  {
    setGifUrl(paramString);
  }
  
  public void setMediaPlayVid(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.wrappers.media.MediaGifView
 * JD-Core Version:    0.7.0.1
 */