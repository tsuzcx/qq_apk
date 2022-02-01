import android.os.Bundle;
import java.util.ArrayList;

final class adox
  extends adot.i
{
  adox(String paramString, long paramLong, ArrayList paramArrayList)
  {
    super(paramString, paramLong);
  }
  
  public void I(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {
      this.nj.add(paramBundle.getString("Nickname", ""));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adox
 * JD-Core Version:    0.7.0.1
 */