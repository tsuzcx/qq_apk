package wf7;

import android.content.Intent;
import android.util.SparseIntArray;
import com.tencent.wifisdk.services.common.api.d;

class fy$a
  implements d
{
  private as.a rN;
  
  fy$a(fy paramfy, as.a parama)
  {
    this.rN = parama;
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    paramInt = fy.a(this.rO).indexOfValue(paramInt);
    if (paramInt >= 0)
    {
      paramInt = fy.a(this.rO).keyAt(paramInt);
      this.rN.a(paramInt, paramIntent);
    }
  }
  
  public int hashCode()
  {
    return this.rN.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.fy.a
 * JD-Core Version:    0.7.0.1
 */