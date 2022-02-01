import java.util.HashMap;

class anpy
  implements Comparable<anpy>
{
  public int dLG;
  public HashMap<String, anpy> nA = new HashMap(10);
  public String text;
  
  public anpy() {}
  
  public anpy(String paramString)
  {
    this.text = paramString;
  }
  
  public int a(anpy paramanpy)
  {
    return paramanpy.dLG - this.dLG;
  }
  
  public anpy a(String paramString)
  {
    return (anpy)this.nA.get(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    return ((anpy)paramObject).text.equals(this.text);
  }
  
  public int hashCode()
  {
    if (this.text == null) {
      return 0;
    }
    return this.text.hashCode();
  }
  
  public boolean isLeaf()
  {
    return this.nA.isEmpty();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("FdNode{");
    localStringBuilder.append("text='").append(this.text).append('\'');
    localStringBuilder.append(", appearTimes=").append(this.dLG);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anpy
 * JD-Core Version:    0.7.0.1
 */