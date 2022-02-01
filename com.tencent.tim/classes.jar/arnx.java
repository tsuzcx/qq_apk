import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;

public class arnx
{
  public arnw a;
  public Context mContext;
  private Map<String, Object> oG;
  
  public arnx(Context paramContext, arnw paramarnw)
  {
    this.mContext = paramContext;
    this.a = paramarnw;
  }
  
  public Object v(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (TextUtils.isEmpty(paramString)) {
      return localObject2;
    }
    if (this.oG == null) {
      this.oG = new LinkedHashMap();
    }
    if (this.oG.containsKey(paramString)) {
      return this.oG.get(paramString);
    }
    if (TextUtils.equals(paramString, "intchk")) {
      localObject1 = new aroa(this);
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
      this.oG.put(paramString, localObject1);
      return localObject1;
      if (TextUtils.equals(paramString, "app_scan")) {
        localObject1 = new arnz(this);
      } else if (TextUtils.equals(paramString, "sig_check")) {
        localObject1 = new arob(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arnx
 * JD-Core Version:    0.7.0.1
 */