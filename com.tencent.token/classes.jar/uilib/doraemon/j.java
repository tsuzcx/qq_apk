package uilib.doraemon;

import android.graphics.ColorFilter;

class j
{
  final String a;
  final String b;
  final ColorFilter c;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof j)) {
        return false;
      }
      paramObject = (j)paramObject;
    } while ((hashCode() == paramObject.hashCode()) && (this.c == paramObject.c));
    return false;
  }
  
  public int hashCode()
  {
    int i = 17;
    if (this.a != null) {
      i = this.a.hashCode() * 527;
    }
    int j = i;
    if (this.b != null) {
      j = i * 31 * this.b.hashCode();
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     uilib.doraemon.j
 * JD-Core Version:    0.7.0.1
 */