package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;

@GwtIncompatible
abstract class LineBuffer
{
  private StringBuilder line = new StringBuilder();
  private boolean sawReturn;
  
  @CanIgnoreReturnValue
  private boolean finishLine(boolean paramBoolean)
    throws IOException
  {
    String str;
    if (this.sawReturn) {
      if (paramBoolean) {
        str = "\r\n";
      }
    }
    for (;;)
    {
      handleLine(this.line.toString(), str);
      this.line = new StringBuilder();
      this.sawReturn = false;
      return paramBoolean;
      str = "\r";
      continue;
      if (paramBoolean) {
        str = "\n";
      } else {
        str = "";
      }
    }
  }
  
  protected void add(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    boolean bool;
    if ((this.sawReturn) && (paramInt2 > 0)) {
      if (paramArrayOfChar[paramInt1] == '\n')
      {
        bool = true;
        if (!finishLine(bool)) {
          break label261;
        }
      }
    }
    label258:
    label261:
    for (int j = paramInt1 + 1;; j = paramInt1)
    {
      int n = paramInt1 + paramInt2;
      int i = j;
      int k = j;
      int m;
      for (;;)
      {
        if (i < n)
        {
          j = k;
          m = i;
          switch (paramArrayOfChar[i])
          {
          default: 
            m = i;
            j = k;
          case '\013': 
          case '\f': 
            i = m + 1;
            k = j;
            continue;
            bool = false;
            break;
          case '\r': 
            this.line.append(paramArrayOfChar, k, i - k);
            this.sawReturn = true;
            if (i + 1 >= n) {
              break label258;
            }
            if (paramArrayOfChar[(i + 1)] == '\n')
            {
              bool = true;
              label171:
              if (!finishLine(bool)) {
                break label258;
              }
              i += 1;
            }
            break;
          }
        }
      }
      for (;;)
      {
        m = i;
        j = i + 1;
        break;
        bool = false;
        break label171;
        this.line.append(paramArrayOfChar, k, i - k);
        finishLine(true);
        j = i + 1;
        m = i;
        break;
        this.line.append(paramArrayOfChar, k, paramInt1 + paramInt2 - k);
        return;
      }
    }
  }
  
  protected void finish()
    throws IOException
  {
    if ((this.sawReturn) || (this.line.length() > 0)) {
      finishLine(false);
    }
  }
  
  protected abstract void handleLine(String paramString1, String paramString2)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.LineBuffer
 * JD-Core Version:    0.7.0.1
 */