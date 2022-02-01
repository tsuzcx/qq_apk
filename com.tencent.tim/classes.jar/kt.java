import android.graphics.Typeface;
import com.etrump.mixlayout.ETFont;

public class kt
{
  public ETFont b;
  public boolean cx;
  public String dU;
  public int iB;
  public int mFontId;
  public String mFontPath;
  public int mFontType;
  public Typeface mTypeface;
  
  public kt() {}
  
  public kt(int paramInt1, int paramInt2, String paramString)
  {
    this.mFontId = paramInt1;
    this.mFontType = paramInt2;
    this.mFontPath = paramString;
  }
  
  public kt(int paramInt, String paramString)
  {
    this.mFontId = paramInt;
    this.mFontPath = paramString;
  }
  
  public String toString()
  {
    return "[id=" + this.mFontId + ",path=" + this.mFontPath + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kt
 * JD-Core Version:    0.7.0.1
 */