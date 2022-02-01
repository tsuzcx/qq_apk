package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MethodCallsLogger
{
  private Map<String, Integer> mCalledMethods = new HashMap();
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public boolean approveCall(String paramString, int paramInt)
  {
    Integer localInteger = (Integer)this.mCalledMethods.get(paramString);
    int i;
    if (localInteger != null)
    {
      i = localInteger.intValue();
      if ((i & paramInt) == 0) {
        break label64;
      }
    }
    label64:
    for (int j = 1;; j = 0)
    {
      this.mCalledMethods.put(paramString, Integer.valueOf(i | paramInt));
      if (j != 0) {
        break label70;
      }
      return true;
      i = 0;
      break;
    }
    label70:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.lifecycle.MethodCallsLogger
 * JD-Core Version:    0.7.0.1
 */