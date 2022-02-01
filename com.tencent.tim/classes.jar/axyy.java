import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class axyy
  implements axzc
{
  private final axzb[] a;
  
  axyy(axzb[] paramArrayOfaxzb)
  {
    this.a = paramArrayOfaxzb;
  }
  
  public void a(axzf paramaxzf, axzd.a parama)
  {
    int j = 0;
    axzh localaxzh = new axzh();
    axzb[] arrayOfaxzb = this.a;
    int k = arrayOfaxzb.length;
    int i = 0;
    while (i < k)
    {
      arrayOfaxzb[i].a(paramaxzf, parama, false, localaxzh);
      i += 1;
    }
    arrayOfaxzb = this.a;
    k = arrayOfaxzb.length;
    i = j;
    while (i < k)
    {
      arrayOfaxzb[i].a(paramaxzf, parama, true, localaxzh);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axyy
 * JD-Core Version:    0.7.0.1
 */