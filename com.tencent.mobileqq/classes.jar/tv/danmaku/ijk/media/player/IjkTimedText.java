package tv.danmaku.ijk.media.player;

import android.graphics.Rect;

public final class IjkTimedText
{
  private Rect mTextBounds = null;
  private String mTextChars = null;
  
  public IjkTimedText(Rect paramRect, String paramString)
  {
    this.mTextBounds = paramRect;
    this.mTextChars = paramString;
  }
  
  public Rect getBounds()
  {
    return this.mTextBounds;
  }
  
  public String getText()
  {
    return this.mTextChars;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.IjkTimedText
 * JD-Core Version:    0.7.0.1
 */