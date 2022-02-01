public final class aasq
{
  public final int mHeight;
  public final int mWidth;
  
  public aasq(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public static aasq a(String paramString)
    throws NumberFormatException
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    int i = paramString.indexOf('*');
    if (i < 0) {
      i = paramString.indexOf('x');
    }
    for (;;)
    {
      if (i < 0) {
        throw a(paramString);
      }
      try
      {
        aasq localaasq = new aasq(Integer.parseInt(paramString.substring(0, i)), Integer.parseInt(paramString.substring(i + 1)));
        return localaasq;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw a(paramString);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw a(paramString);
      }
    }
  }
  
  private static NumberFormatException a(String paramString)
  {
    throw new NumberFormatException("Invalid SizeF: \"" + paramString + "\"");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (this == paramObject) {
        return true;
      }
    } while (!(paramObject instanceof aasq));
    paramObject = (aasq)paramObject;
    if ((this.mWidth == paramObject.mWidth) && (this.mHeight == paramObject.mHeight)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public String toString()
  {
    return this.mWidth + "x" + this.mHeight;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aasq
 * JD-Core Version:    0.7.0.1
 */