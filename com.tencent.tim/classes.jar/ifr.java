public class ifr
{
  private final String LI;
  private Boolean n;
  
  public ifr(String paramString, boolean paramBoolean)
  {
    this.LI = paramString;
    this.n = Boolean.valueOf(paramBoolean);
  }
  
  public void aln()
  {
    if (!this.n.booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      this.n = Boolean.valueOf(bool);
      return;
    }
  }
  
  public Boolean e()
  {
    return this.n;
  }
  
  public String gt()
  {
    return this.LI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ifr
 * JD-Core Version:    0.7.0.1
 */