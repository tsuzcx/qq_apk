package android.support.v4.view;

import android.graphics.Rect;

public class WindowInsetsCompat
{
  public WindowInsetsCompat consumeStableInsets()
  {
    return this;
  }
  
  public WindowInsetsCompat consumeSystemWindowInsets()
  {
    return this;
  }
  
  public int getStableInsetBottom()
  {
    return 0;
  }
  
  public int getStableInsetLeft()
  {
    return 0;
  }
  
  public int getStableInsetRight()
  {
    return 0;
  }
  
  public int getStableInsetTop()
  {
    return 0;
  }
  
  public int getSystemWindowInsetBottom()
  {
    return 0;
  }
  
  public int getSystemWindowInsetLeft()
  {
    return 0;
  }
  
  public int getSystemWindowInsetRight()
  {
    return 0;
  }
  
  public int getSystemWindowInsetTop()
  {
    return 0;
  }
  
  public boolean hasInsets()
  {
    return false;
  }
  
  public boolean hasStableInsets()
  {
    return false;
  }
  
  public boolean hasSystemWindowInsets()
  {
    return false;
  }
  
  public boolean isConsumed()
  {
    return false;
  }
  
  public boolean isRound()
  {
    return false;
  }
  
  public WindowInsetsCompat replaceSystemWindowInsets(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return this;
  }
  
  public WindowInsetsCompat replaceSystemWindowInsets(Rect paramRect)
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     android.support.v4.view.WindowInsetsCompat
 * JD-Core Version:    0.7.0.1
 */