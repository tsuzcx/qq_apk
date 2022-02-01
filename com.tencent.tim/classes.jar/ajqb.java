import android.os.Bundle;
import com.tencent.mobileqq.nearby.NearbyJsInterface;

public class ajqb
  implements skj.a
{
  public ajqb(NearbyJsInterface paramNearbyJsInterface, skj paramskj, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void callback(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("nearbyVideoConfig");
    this.j.e(new ajqc(this, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajqb
 * JD-Core Version:    0.7.0.1
 */