public class vgf<F, S>
{
  public F a;
  public S b;
  
  public vgf(F paramF, S paramS)
  {
    this.a = paramF;
    this.b = paramS;
  }
  
  public vgf<F, S> a(F paramF, S paramS)
  {
    this.a = paramF;
    this.b = paramS;
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof vgf)) {
        return false;
      }
      try
      {
        paramObject = (vgf)paramObject;
        if ((!this.a.equals(paramObject.a)) || (!this.b.equals(paramObject.b))) {
          return false;
        }
      }
      catch (ClassCastException paramObject) {}
    }
    return false;
  }
  
  public int hashCode()
  {
    return (this.a.hashCode() + 527) * 31 + this.b.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgf
 * JD-Core Version:    0.7.0.1
 */