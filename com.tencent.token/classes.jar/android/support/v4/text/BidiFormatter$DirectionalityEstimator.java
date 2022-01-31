package android.support.v4.text;

class BidiFormatter$DirectionalityEstimator
{
  private static final byte[] DIR_TYPE_CACHE = new byte[1792];
  private static final int DIR_TYPE_CACHE_SIZE = 1792;
  private int charIndex;
  private final boolean isHtml;
  private char lastChar;
  private final int length;
  private final CharSequence text;
  
  static
  {
    int i = 0;
    while (i < 1792)
    {
      DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
      i += 1;
    }
  }
  
  BidiFormatter$DirectionalityEstimator(CharSequence paramCharSequence, boolean paramBoolean)
  {
    this.text = paramCharSequence;
    this.isHtml = paramBoolean;
    this.length = paramCharSequence.length();
  }
  
  private static byte getCachedDirectionality(char paramChar)
  {
    if (paramChar < '܀') {
      return DIR_TYPE_CACHE[paramChar];
    }
    return Character.getDirectionality(paramChar);
  }
  
  private byte skipEntityBackward()
  {
    int i = this.charIndex;
    do
    {
      if (this.charIndex <= 0) {
        break;
      }
      CharSequence localCharSequence = this.text;
      int j = this.charIndex - 1;
      this.charIndex = j;
      this.lastChar = localCharSequence.charAt(j);
      if (this.lastChar == '&') {
        return 12;
      }
    } while (this.lastChar != ';');
    this.charIndex = i;
    this.lastChar = ';';
    return 13;
  }
  
  private byte skipEntityForward()
  {
    char c;
    do
    {
      if (this.charIndex >= this.length) {
        break;
      }
      CharSequence localCharSequence = this.text;
      int i = this.charIndex;
      this.charIndex = (i + 1);
      c = localCharSequence.charAt(i);
      this.lastChar = c;
    } while (c != ';');
    return 12;
  }
  
  private byte skipTagBackward()
  {
    int j = this.charIndex;
    label148:
    for (;;)
    {
      CharSequence localCharSequence;
      int k;
      if (this.charIndex > 0)
      {
        localCharSequence = this.text;
        k = this.charIndex - 1;
        this.charIndex = k;
        this.lastChar = localCharSequence.charAt(k);
        if (this.lastChar == '<') {
          return 12;
        }
        if (this.lastChar != '>') {}
      }
      else
      {
        this.charIndex = j;
        this.lastChar = '>';
        return 13;
      }
      if ((this.lastChar == '"') || (this.lastChar == '\''))
      {
        k = this.lastChar;
        for (;;)
        {
          if (this.charIndex <= 0) {
            break label148;
          }
          localCharSequence = this.text;
          int m = this.charIndex - 1;
          this.charIndex = m;
          int i = localCharSequence.charAt(m);
          this.lastChar = i;
          if (i == k) {
            break;
          }
        }
      }
    }
  }
  
  private byte skipTagForward()
  {
    int j = this.charIndex;
    label133:
    while (this.charIndex < this.length)
    {
      CharSequence localCharSequence = this.text;
      int k = this.charIndex;
      this.charIndex = (k + 1);
      this.lastChar = localCharSequence.charAt(k);
      if (this.lastChar == '>') {
        return 12;
      }
      if ((this.lastChar == '"') || (this.lastChar == '\''))
      {
        k = this.lastChar;
        for (;;)
        {
          if (this.charIndex >= this.length) {
            break label133;
          }
          localCharSequence = this.text;
          int m = this.charIndex;
          this.charIndex = (m + 1);
          int i = localCharSequence.charAt(m);
          this.lastChar = i;
          if (i == k) {
            break;
          }
        }
      }
    }
    this.charIndex = j;
    this.lastChar = '<';
    return 13;
  }
  
  byte dirTypeBackward()
  {
    this.lastChar = this.text.charAt(this.charIndex - 1);
    byte b1;
    if (Character.isLowSurrogate(this.lastChar))
    {
      int i = Character.codePointBefore(this.text, this.charIndex);
      this.charIndex -= Character.charCount(i);
      b1 = Character.getDirectionality(i);
    }
    do
    {
      byte b2;
      do
      {
        return b1;
        this.charIndex -= 1;
        b2 = getCachedDirectionality(this.lastChar);
        b1 = b2;
      } while (!this.isHtml);
      if (this.lastChar == '>') {
        return skipTagBackward();
      }
      b1 = b2;
    } while (this.lastChar != ';');
    return skipEntityBackward();
  }
  
  byte dirTypeForward()
  {
    this.lastChar = this.text.charAt(this.charIndex);
    byte b1;
    if (Character.isHighSurrogate(this.lastChar))
    {
      int i = Character.codePointAt(this.text, this.charIndex);
      this.charIndex += Character.charCount(i);
      b1 = Character.getDirectionality(i);
    }
    do
    {
      byte b2;
      do
      {
        return b1;
        this.charIndex += 1;
        b2 = getCachedDirectionality(this.lastChar);
        b1 = b2;
      } while (!this.isHtml);
      if (this.lastChar == '<') {
        return skipTagForward();
      }
      b1 = b2;
    } while (this.lastChar != '&');
    return skipEntityForward();
  }
  
  int getEntryDir()
  {
    this.charIndex = 0;
    int j = 0;
    int k = 0;
    int i = 0;
    while ((this.charIndex < this.length) && (j == 0)) {
      switch (dirTypeForward())
      {
      case 9: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      default: 
        j = i;
        break;
      case 14: 
      case 15: 
        i += 1;
        k = -1;
        break;
      case 16: 
      case 17: 
        i += 1;
        k = 1;
        break;
      case 18: 
        i -= 1;
        k = 0;
        break;
      case 0: 
        if (i == 0) {
          return -1;
        }
        j = i;
        break;
      case 1: 
      case 2: 
        if (i == 0) {
          return 1;
        }
        j = i;
      }
    }
    if (j == 0) {
      return 0;
    }
    if (k != 0) {
      return k;
    }
    for (;;)
    {
      if (this.charIndex <= 0) {
        break label268;
      }
      switch (dirTypeBackward())
      {
      default: 
        break;
      case 14: 
      case 15: 
        if (j == i) {
          break;
        }
        i -= 1;
        break;
      case 16: 
      case 17: 
        if (j == i) {
          return 1;
        }
        i -= 1;
        break;
      case 18: 
        i += 1;
      }
    }
    label268:
    return 0;
  }
  
  int getExitDir()
  {
    int m = 0;
    this.charIndex = this.length;
    int j = 0;
    int i = 0;
    for (;;)
    {
      int k = m;
      if (this.charIndex > 0) {}
      switch (dirTypeBackward())
      {
      case 9: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      default: 
        if (j == 0) {
          j = i;
        }
        break;
      case 0: 
        if (i == 0)
        {
          k = -1;
          return k;
        }
        if (j == 0) {
          j = i;
        }
        break;
      case 14: 
      case 15: 
        if (j == i) {
          return -1;
        }
        i -= 1;
        break;
      case 1: 
      case 2: 
        if (i == 0) {
          return 1;
        }
        if (j == 0) {
          j = i;
        }
        break;
      case 16: 
      case 17: 
        if (j == i) {
          return 1;
        }
        i -= 1;
        break;
      case 18: 
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.text.BidiFormatter.DirectionalityEstimator
 * JD-Core Version:    0.7.0.1
 */