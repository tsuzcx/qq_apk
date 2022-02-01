import android.text.SpannableString;

class apoe
{
  public final SpannableString l;
  public final int startIndex;
  
  public apoe(int paramInt, SpannableString paramSpannableString)
  {
    this.startIndex = paramInt;
    this.l = paramSpannableString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (apoe)paramObject;
      if (this.startIndex != paramObject.startIndex) {
        return false;
      }
      if (this.l != null) {
        return this.l.equals(paramObject.l);
      }
    } while (paramObject.l == null);
    return false;
  }
  
  public int hashCode()
  {
    int j = this.startIndex;
    if (this.l != null) {}
    for (int i = this.l.hashCode();; i = 0) {
      return i + j * 31;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AtTag{");
    localStringBuilder.append("startIndex=").append(this.startIndex);
    localStringBuilder.append(", atSpan=").append(this.l);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apoe
 * JD-Core Version:    0.7.0.1
 */