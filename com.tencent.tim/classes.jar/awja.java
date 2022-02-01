public class awja
{
  public static final String cQQ = Long.toString(1130L);
  public int eBo = 0;
  public int mNum = 0;
  public int mResourceId = 0;
  public int mStyle = 0;
  public String mText = "";
  
  public int Qm()
  {
    switch (this.mStyle)
    {
    default: 
      return 0;
    }
    return this.mNum;
  }
  
  public int a(awja paramawja)
  {
    int k = 1;
    awja localawja;
    if (this.mStyle > paramawja.mStyle)
    {
      localawja = paramawja;
      paramawja = this;
    }
    for (;;)
    {
      int i;
      switch (localawja.mStyle)
      {
      default: 
        i = 0;
        j = 0;
        label64:
        if (j == 0) {
          break;
        }
      }
      for (int j = k;; j = 0)
      {
        k = j;
        if (i != 0) {
          k = j | 0x2;
        }
        return k;
        if (paramawja.mStyle == 0) {
          break;
        }
        i = 1;
        j = 1;
        break label64;
        if ((paramawja.mStyle == 1) && (localawja.mNum == paramawja.mNum)) {
          break;
        }
        i = 1;
        j = 1;
        break label64;
        if ((paramawja.mStyle == 2) && (localawja.mText.equals(paramawja.mText))) {
          break;
        }
        i = 0;
        j = 1;
        break label64;
        if ((paramawja.mStyle == 3) && (localawja.mResourceId == paramawja.mResourceId)) {
          break;
        }
        i = 0;
        j = 1;
        break label64;
        if ((paramawja.mStyle == 4) && (localawja.mText.equals(paramawja.mText))) {
          break;
        }
        i = 0;
        j = 1;
        break label64;
      }
      localawja = this;
    }
  }
  
  public boolean aNb()
  {
    switch (this.mStyle)
    {
    }
    do
    {
      return true;
      return false;
    } while (this.mNum > 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awja
 * JD-Core Version:    0.7.0.1
 */