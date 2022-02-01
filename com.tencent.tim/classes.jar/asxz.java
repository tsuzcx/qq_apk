public class asxz
{
  private StringBuilder Y;
  private boolean mIsFollowed;
  
  public asxz()
  {
    a();
  }
  
  private void YB(String paramString)
  {
    if (this.mIsFollowed) {
      this.Y.append(paramString);
    }
    this.mIsFollowed = true;
  }
  
  private void esl()
  {
    YB(",");
  }
  
  public asxz a()
  {
    this.Y = new StringBuilder();
    this.mIsFollowed = false;
    return this;
  }
  
  public asxz a(int paramInt)
  {
    return a(String.format("%d", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public asxz a(String paramString)
  {
    esl();
    paramString = paramString.replace(',', ';');
    this.Y.append(paramString);
    return this;
  }
  
  public asxz a(byte[] paramArrayOfByte)
  {
    return a(aqhs.bytes2HexStr(paramArrayOfByte));
  }
  
  public String toString()
  {
    return this.Y.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asxz
 * JD-Core Version:    0.7.0.1
 */