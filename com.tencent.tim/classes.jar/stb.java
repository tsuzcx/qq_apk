import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;

class stb
  implements skj.a
{
  stb(ssx paramssx) {}
  
  public void callback(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getBoolean("isSuccess")))
    {
      ArrayList localArrayList = paramBundle.getStringArrayList("uins");
      paramBundle = paramBundle.getStringArrayList("tinyIds");
      int i = 0;
      while (i < localArrayList.size())
      {
        ssx.a(this.this$0).put(paramBundle.get(i), localArrayList.get(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     stb
 * JD-Core Version:    0.7.0.1
 */