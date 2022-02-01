class rpx
  implements Cloneable
{
  public String aBH;
  public String audioCodec;
  public int btZ = -1;
  public int bua = -1;
  public double duration = -1.0D;
  public String format;
  public int height = -1;
  public String path;
  public String rotate = "0";
  public String videoCodec;
  public int width = -1;
  
  public rpx(String paramString)
  {
    this.path = paramString;
  }
  
  public rpx a()
    throws CloneNotSupportedException
  {
    return (rpx)super.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rpx
 * JD-Core Version:    0.7.0.1
 */