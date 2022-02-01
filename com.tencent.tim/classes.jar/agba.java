public abstract class agba
{
  public String bGh;
  public int type = 1;
  
  public agba(int paramInt, String paramString)
  {
    this.type = paramInt;
    this.bGh = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof agba))
    {
      paramObject = (agba)paramObject;
      if (this.bGh == null) {
        if ((this.type != paramObject.type) || (paramObject.bGh != null)) {}
      }
      while ((this.type == paramObject.type) && (this.bGh.equals(paramObject.bGh)))
      {
        return true;
        return false;
      }
      return false;
    }
    return false;
  }
  
  public String toString()
  {
    return this.bGh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agba
 * JD-Core Version:    0.7.0.1
 */