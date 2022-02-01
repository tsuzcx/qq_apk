public final class ahqg
{
  String bLo;
  private int daD = 1;
  int endOffset;
  int startOffset;
  String type = "word";
  
  public ahqg(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.bLo = paramString1;
    this.startOffset = paramInt1;
    this.endOffset = paramInt2;
    this.type = paramString2;
  }
  
  public final int Ff()
  {
    return this.startOffset;
  }
  
  public final int Fg()
  {
    return this.endOffset;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("(" + this.bLo + "," + this.startOffset + "," + this.endOffset);
    if (!this.type.equals("word")) {
      localStringBuffer.append(",type=" + this.type);
    }
    if (this.daD != 1) {
      localStringBuffer.append(",posIncr=" + this.daD);
    }
    localStringBuffer.append(")");
    return localStringBuffer.toString();
  }
  
  public final String type()
  {
    return this.type;
  }
  
  public final String wu()
  {
    return this.bLo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahqg
 * JD-Core Version:    0.7.0.1
 */