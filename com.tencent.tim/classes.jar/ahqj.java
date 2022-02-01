import android.text.TextUtils;
import java.io.IOException;
import java.io.Reader;

public final class ahqj
  extends ahqi
{
  private final char[] buffer = new char['ÿ'];
  private int bufferIndex;
  private boolean chU;
  private int count;
  private int dataLen;
  private int offset;
  private final char[] p = new char[1024];
  private String tokenType = "word";
  
  public ahqj(Reader paramReader, int paramInt)
  {
    this.a = paramReader;
    this.count = paramInt;
  }
  
  public final ahqg a()
    throws IOException
  {
    int m = this.offset;
    int k = 0;
    for (;;)
    {
      this.offset += 1;
      if (this.bufferIndex >= this.dataLen)
      {
        this.dataLen = this.a.read(this.p);
        this.bufferIndex = 0;
      }
      int n;
      if (this.dataLen == -1) {
        if (k > 0)
        {
          n = m;
          if (this.chU == true)
          {
            this.chU = false;
            k = 0;
            n = m;
          }
        }
      }
      int i1;
      for (;;)
      {
        if ((n == this.count - 1) && (k == 0))
        {
          return null;
          return null;
          Object localObject = this.p;
          n = this.bufferIndex;
          this.bufferIndex = (n + 1);
          int j = localObject[n];
          localObject = Character.UnicodeBlock.of(j);
          if ((localObject == Character.UnicodeBlock.BASIC_LATIN) || (localObject == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS))
          {
            int i = j;
            char c;
            if (localObject == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
              c = (char)(j - 65248);
            }
            if (Character.isLetter(c))
            {
              if (k == 0) {
                n = this.offset - 1;
              }
              do
              {
                localObject = this.buffer;
                m = k + 1;
                localObject[k] = Character.toLowerCase(c);
                this.tokenType = "letter";
                i1 = n;
                k = m;
                if (m != 255) {
                  break label700;
                }
                k = m;
                break;
                if (TextUtils.equals(this.tokenType, "double")) {
                  break label260;
                }
                n = m;
              } while (!TextUtils.equals(this.tokenType, "digit"));
              label260:
              this.offset -= 1;
              this.bufferIndex -= 1;
              this.tokenType = "letter";
              n = m;
              if (this.chU != true) {
                continue;
              }
              this.chU = false;
              k = 0;
              n = m;
              continue;
            }
            if (Character.isDigit(c))
            {
              if (k == 0) {
                n = this.offset - 1;
              }
              do
              {
                localObject = this.buffer;
                m = k + 1;
                localObject[k] = Character.toLowerCase(c);
                this.tokenType = "digit";
                i1 = n;
                k = m;
                if (m != 255) {
                  break label700;
                }
                k = m;
                break;
                if (TextUtils.equals(this.tokenType, "double")) {
                  break label405;
                }
                n = m;
              } while (!TextUtils.equals(this.tokenType, "letter"));
              label405:
              this.offset -= 1;
              this.bufferIndex -= 1;
              this.tokenType = "digit";
              n = m;
              if (this.chU != true) {
                continue;
              }
              this.chU = false;
              k = 0;
              n = m;
              continue;
            }
            if (k <= 0) {
              break;
            }
            n = m;
            if (this.chU != true) {
              continue;
            }
            this.chU = false;
            k = 0;
            break;
          }
          if (Character.isLetter(j))
          {
            if (k == 0)
            {
              m = this.offset - 1;
              this.buffer[k] = j;
              this.tokenType = "double";
              k += 1;
              break;
            }
            if ((TextUtils.equals(this.tokenType, "letter")) || (TextUtils.equals(this.tokenType, "digit")))
            {
              this.offset -= 1;
              this.bufferIndex -= 1;
              n = m;
              continue;
            }
            localObject = this.buffer;
            n = k + 1;
            localObject[k] = j;
            this.tokenType = "double";
            i1 = m;
            k = n;
            if (n != 2) {
              break label700;
            }
            this.offset -= 1;
            this.bufferIndex -= 1;
            this.chU = true;
            k = n;
            n = m;
            continue;
          }
          if (k <= 0) {
            break;
          }
          n = m;
          if (this.chU == true)
          {
            this.chU = false;
            k = 0;
            break;
          }
        }
      }
      return new ahqg(new String(this.buffer, 0, k), n, k + n, this.tokenType);
      label700:
      m = i1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahqj
 * JD-Core Version:    0.7.0.1
 */