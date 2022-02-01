public class avty
{
  public String cNJ;
  public String cNK;
  public int fontId;
  
  public avty() {}
  
  public avty(int paramInt)
  {
    this.fontId = paramInt;
    this.cNJ = "";
    this.cNK = "";
  }
  
  public String toString()
  {
    return "[id=" + this.fontId + ",fTypePath=" + this.cNJ + ", tTYpePath=" + this.cNK + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avty
 * JD-Core Version:    0.7.0.1
 */