package cooperation.qzone.font;

import avsw;
import avtz.a;
import avua;
import java.io.File;

public class FontManager$3
  implements Runnable
{
  public FontManager$3(avua paramavua, int paramInt1, int paramInt2, avtz.a parama, String paramString1, String paramString2) {}
  
  public void run()
  {
    File localFile = new File(avua.a(this.this$0, this.If, this.iJ));
    if (localFile.exists())
    {
      if (this.a == null) {
        break label152;
      }
      avua.access$100().H(localFile.getAbsolutePath(), true);
      this.a.d(this.If, localFile.getAbsolutePath(), this.vr);
    }
    label152:
    while ((avua.a(this.this$0, this.If, this.cNN, this.iJ, this.vr, this.a)) || (this.a == null))
    {
      return;
      if (this.iJ == 1)
      {
        localFile = new File(avua.a(this.this$0, this.If, 0));
        if (localFile.exists())
        {
          String str = avua.a(this.this$0, this.If, 1);
          if (avua.a(this.this$0, localFile.getAbsolutePath(), str))
          {
            this.a.d(this.If, str, this.vr);
            return;
          }
        }
      }
    }
    this.a.d(this.If, null, this.vr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.font.FontManager.3
 * JD-Core Version:    0.7.0.1
 */