public class aqae
{
  public int type;
  public String value;
  
  public aqae() {}
  
  public aqae(int paramInt, String paramString)
  {
    this.type = paramInt;
    this.value = paramString;
  }
  
  public void a(aqae paramaqae)
  {
    if (paramaqae != null)
    {
      this.type = paramaqae.type;
      this.value = paramaqae.value;
    }
  }
  
  public Object clone()
  {
    return new aqae(this.type, this.value);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof aqae))
    {
      paramObject = (aqae)paramObject;
      bool1 = bool2;
      if (paramObject.type == this.type)
      {
        bool1 = bool2;
        if (aqft.equalsWithNullCheck(paramObject.value, this.value)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqae
 * JD-Core Version:    0.7.0.1
 */