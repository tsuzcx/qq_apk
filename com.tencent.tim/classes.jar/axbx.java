import android.support.annotation.Nullable;

public class axbx
{
  private String cTF;
  private String cTG;
  
  public axbx(@Nullable String paramString1, @Nullable String paramString2)
  {
    this.cTF = paramString1;
    this.cTG = paramString2;
  }
  
  @Nullable
  public String HF()
  {
    return this.cTF;
  }
  
  @Nullable
  public String HG()
  {
    return this.cTG;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof axbx))) {}
    do
    {
      return false;
      paramObject = (axbx)paramObject;
    } while ((aqmr.isEmpty(this.cTF)) || (aqmr.isEmpty(this.cTG)) || (!this.cTF.equals(paramObject.HF())) || (!this.cTG.equals(paramObject.HG())));
    return true;
  }
  
  public int hashCode()
  {
    int j = 0;
    int i;
    if (this.cTG == null)
    {
      i = 0;
      if (this.cTF != null) {
        break label40;
      }
    }
    for (;;)
    {
      return (i + 527) * 31 + j;
      i = this.cTG.hashCode();
      break;
      label40:
      j = this.cTF.hashCode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axbx
 * JD-Core Version:    0.7.0.1
 */