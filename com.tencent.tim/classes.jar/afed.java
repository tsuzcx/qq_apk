public class afed
{
  public boolean bXI;
  public int cQE;
  public String uin;
  
  public afed(String paramString, int paramInt)
  {
    this(paramString, paramInt, true);
  }
  
  public afed(String paramString, int paramInt, boolean paramBoolean)
  {
    this.uin = paramString;
    this.cQE = paramInt;
    this.bXI = paramBoolean;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ComboObject:");
    localStringBuffer.append(this.uin).append(',').append(this.cQE).append(',').append(this.bXI);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afed
 * JD-Core Version:    0.7.0.1
 */