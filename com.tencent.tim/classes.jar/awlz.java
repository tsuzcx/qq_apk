import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.TMG.utils.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class awlz
  implements Handler.Callback
{
  private ArrayList<awlz> Fu;
  protected int JO;
  protected View ey;
  protected String mType;
  protected Handler mUIHandler;
  protected int mViewHeight;
  
  public awlz(View paramView)
  {
    this.ey = paramView;
    this.mUIHandler = new Handler(Looper.getMainLooper(), this);
    this.Fu = new ArrayList();
  }
  
  public awlz(String paramString, View paramView)
  {
    this(paramView);
    this.mType = paramString;
  }
  
  private void abV(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Drawable localDrawable = u(paramString);
    if (localDrawable != null)
    {
      this.ey.setBackgroundDrawable(localDrawable);
      return;
    }
    throw new RuntimeException(getClass().getName() + " set background drawable = null not match value = " + paramString);
  }
  
  private int gj(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return -2;
      try
      {
        if ("fill".equals(paramString)) {
          return -1;
        }
        if (!"fit".equals(paramString))
        {
          int i = gi(paramString);
          return i;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return -2;
  }
  
  public void RB() {}
  
  protected void RC() {}
  
  protected ViewGroup.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams, JSONObject paramJSONObject)
  {
    return paramLayoutParams;
  }
  
  public ViewGroup.LayoutParams a(JSONObject paramJSONObject, awlz paramawlz)
  {
    if ((this.ey == null) || (paramJSONObject == null) || (paramJSONObject.length() == 0)) {
      return null;
    }
    Object localObject1 = paramJSONObject.optString("width");
    Object localObject2 = paramJSONObject.optString("height");
    this.JO = gj((String)localObject1);
    this.mViewHeight = gj((String)localObject2);
    if (QLog.isColorLevel()) {
      QLog.i("JsonInflateViewModel", 0, "class = " + this.ey.getClass().getSimpleName() + " width = " + this.JO + " height = " + this.mViewHeight);
    }
    localObject1 = b(this.JO, this.mViewHeight);
    localObject2 = paramJSONObject.keys();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      a(str, paramJSONObject.optString(str), (ViewGroup.LayoutParams)localObject1);
    }
    paramawlz.a((ViewGroup.LayoutParams)localObject1, paramJSONObject);
    return localObject1;
  }
  
  public awlz a(String paramString)
  {
    awlz localawlz2 = null;
    awlz localawlz1 = localawlz2;
    if (!TextUtils.isEmpty(this.mType))
    {
      if (this.Fu != null) {
        break label25;
      }
      localawlz1 = localawlz2;
    }
    label25:
    do
    {
      return localawlz1;
      if (this.Fu.size() == 0)
      {
        if (this.mType.equals(paramString)) {}
        for (paramString = this;; paramString = null) {
          return paramString;
        }
      }
      Iterator localIterator = this.Fu.iterator();
      localawlz1 = null;
      if (!localIterator.hasNext()) {
        break;
      }
      localawlz2 = (awlz)localIterator.next();
      if (localawlz2 == null) {
        break label110;
      }
      localawlz2 = localawlz2.a(paramString);
      localawlz1 = localawlz2;
    } while (localawlz2 != null);
    localawlz1 = localawlz2;
    label110:
    for (;;)
    {
      break;
      return localawlz1;
    }
  }
  
  public void a(awlz paramawlz)
  {
    if (paramawlz == null) {
      return;
    }
    if (this.Fu == null) {
      this.Fu = new ArrayList();
    }
    this.Fu.add(paramawlz);
  }
  
  protected void a(String paramString1, String paramString2, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      if (!"x".equals(paramString1)) {
        break label29;
      }
      ((ViewGroup.MarginLayoutParams)paramLayoutParams).leftMargin = gi(paramString2);
    }
    label29:
    while (!"y".equals(paramString1)) {
      return;
    }
    ((ViewGroup.MarginLayoutParams)paramLayoutParams).topMargin = gi(paramString2);
  }
  
  protected ViewGroup.LayoutParams b(int paramInt1, int paramInt2)
  {
    return new ViewGroup.LayoutParams(paramInt1, paramInt2);
  }
  
  public void ck(JSONObject paramJSONObject)
  {
    if ((this.ey == null) || (paramJSONObject == null) || (paramJSONObject.length() == 0)) {
      return;
    }
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      setAttribute(str, paramJSONObject.optString(str));
    }
    RC();
  }
  
  protected int getScreenHeight()
  {
    return aqnm.getScreenHeight();
  }
  
  protected int getScreenWidth()
  {
    return aqnm.getScreenWidth();
  }
  
  public View getView()
  {
    return this.ey;
  }
  
  protected int gi(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i;
      if (paramString.endsWith("w")) {
        i = Integer.parseInt(paramString.substring(0, paramString.indexOf("w"))) * getScreenWidth();
      }
      for (;;)
      {
        return i / 10000;
        if (paramString.endsWith("h"))
        {
          i = Integer.parseInt(paramString.substring(0, paramString.indexOf("h"))) * getScreenHeight();
        }
        else
        {
          i = Integer.parseInt(paramString);
          int j = getScreenWidth();
          i *= j;
        }
      }
      return 0;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("JsonInflateViewModel", 1, "getIntegerValue exception: value =  " + paramString);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onDestory()
  {
    Iterator localIterator = this.Fu.iterator();
    while (localIterator.hasNext())
    {
      awlz localawlz = (awlz)localIterator.next();
      if (localawlz != null) {
        localawlz.onDestory();
      }
    }
  }
  
  public void onPause()
  {
    Iterator localIterator = this.Fu.iterator();
    while (localIterator.hasNext())
    {
      awlz localawlz = (awlz)localIterator.next();
      if (localawlz != null) {
        localawlz.onPause();
      }
    }
  }
  
  public void onResume()
  {
    Iterator localIterator = this.Fu.iterator();
    while (localIterator.hasNext())
    {
      awlz localawlz = (awlz)localIterator.next();
      if (localawlz != null) {
        localawlz.onResume();
      }
    }
  }
  
  protected void setAttribute(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if ("background_color".equals(paramString1))
    {
      abV(paramString2);
      return;
    }
    if ("rotate".equals(paramString1))
    {
      this.ey.setPivotX(0.0F);
      this.ey.setPivotY(0.0F);
      this.ey.setRotation(Float.parseFloat(paramString2));
      return;
    }
    if ("id".equals(paramString1))
    {
      this.ey.setId(Integer.parseInt(paramString2));
      return;
    }
    QLog.e("JsonInflateViewModel", 1, this.mType + " illegal attr :" + paramString1 + " = " + paramString2);
  }
  
  protected Drawable u(String paramString)
  {
    ColorDrawable localColorDrawable = null;
    if (paramString.startsWith("#")) {
      localColorDrawable = new ColorDrawable(Color.parseColor(paramString));
    }
    return localColorDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awlz
 * JD-Core Version:    0.7.0.1
 */