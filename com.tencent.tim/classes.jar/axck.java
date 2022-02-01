import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.io.File;
import java.util.HashMap;

public class axck
{
  private static boolean mIsInit;
  private final int GIF = 1;
  private final String TAG = "AEFontManager";
  private final int eEB = 0;
  private HashMap<String, Typeface> qY = new HashMap();
  private final int[] tN = { 0, 1 };
  
  public static axck a()
  {
    if (!mIsInit)
    {
      axck.a.b().init();
      mIsInit = true;
    }
    return axck.a.b();
  }
  
  private void b(@NonNull String paramString, @NonNull Typeface paramTypeface)
  {
    int[] arrayOfInt = this.tN;
    int j = arrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      switch (arrayOfInt[i])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        LogicDataManager.getInstance().putTypeface(paramString, paramTypeface);
      }
    }
  }
  
  public void a(@Nullable String paramString, @Nullable Typeface paramTypeface)
  {
    if ((paramString == null) || (paramTypeface == null)) {
      return;
    }
    this.qY.put(paramString, paramTypeface);
    b(paramString, paramTypeface);
  }
  
  @NonNull
  public Typeface c(@Nullable String paramString)
  {
    if (paramString != null)
    {
      if (this.qY.get(paramString) == null) {
        return Typeface.DEFAULT;
      }
      return (Typeface)this.qY.get(paramString);
    }
    return Typeface.DEFAULT;
  }
  
  public void init()
  {
    jL("jianqiaohei.ttf", FeatureManager.getResourceDir());
  }
  
  public void jL(@Nullable String paramString1, @Nullable String paramString2)
  {
    Object localObject = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      localObject = FeatureManager.getResourceDir();
    }
    paramString2 = new File((String)localObject, paramString1);
    localObject = Typeface.DEFAULT;
    if (paramString2.exists()) {
      try
      {
        a(paramString1, Typeface.createFromFile(paramString2));
        return;
      }
      catch (RuntimeException paramString1)
      {
        axiy.e("AEFontManager", "【ERROR】Typeface.createFromFile");
        return;
      }
    }
    axiy.d("AEFontManager", "文件不存在" + paramString2.getAbsolutePath());
  }
  
  static class a
  {
    private static axck a = new axck(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axck
 * JD-Core Version:    0.7.0.1
 */