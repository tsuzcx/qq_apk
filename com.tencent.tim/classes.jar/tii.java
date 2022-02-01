import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.common.app.BaseApplicationImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class tii
  implements View.OnTouchListener
{
  private long Cd;
  private long Es;
  private tii.a a;
  private int bBA;
  private int bBz;
  private int mDownX;
  private int mDownY;
  private List<WeakReference<View>> pQ = new ArrayList();
  
  String a(String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = this.Es;
    long l2 = this.Cd;
    long l3 = System.currentTimeMillis();
    long l4 = this.Es;
    long l5 = System.currentTimeMillis();
    long l6 = this.Cd;
    int i;
    int j;
    int k;
    Object localObject;
    if (paramBoolean1)
    {
      i = 1;
      j = ankt.aD(BaseApplicationImpl.getContext());
      k = ankt.aC(BaseApplicationImpl.getContext());
      localObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("g", String.valueOf(l1 - l2));
        ((JSONObject)localObject).put("sc", String.valueOf(l3 - l4));
        ((JSONObject)localObject).put("ec", String.valueOf(l5 - l6));
        ((JSONObject)localObject).put("aa", String.valueOf(this.mDownX));
        ((JSONObject)localObject).put("ab", String.valueOf(this.mDownY));
        ((JSONObject)localObject).put("ba", String.valueOf(this.bBz));
        ((JSONObject)localObject).put("bb", String.valueOf(this.bBA));
        ((JSONObject)localObject).put("d", String.valueOf(0));
        ((JSONObject)localObject).put("p", String.valueOf(paramLong));
        ((JSONObject)localObject).put("f", String.valueOf(0));
        ((JSONObject)localObject).put("x", String.valueOf(i));
        ((JSONObject)localObject).put("sz", String.valueOf(-999));
        ((JSONObject)localObject).put("da", String.valueOf(k));
        ((JSONObject)localObject).put("db", String.valueOf(j));
        if (!paramBoolean2) {
          continue;
        }
        i = 2;
        ((JSONObject)localObject).put("vca", String.valueOf(i));
      }
      catch (Exception localException)
      {
        String str;
        tkw.e("GdtMotiveVideoClickCoordinateReportHelper", "getReportString error", localException);
        continue;
        paramString = "?";
        continue;
      }
      str = ((JSONObject)localObject).toString();
      localObject = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = paramString;
        if (!paramString.contains("&s={"))
        {
          localObject = new StringBuilder().append(paramString);
          if (!paramString.contains("?")) {
            continue;
          }
          paramString = "&";
          localObject = paramString + "s=" + str;
          tkw.e("GdtMotiveVideoClickCoordinateReportHelper", "getReportString click url result : " + (String)localObject);
        }
      }
      return localObject;
      i = 0;
      break;
      i = 1;
    }
  }
  
  void ek(View paramView)
  {
    this.pQ.add(new WeakReference(paramView));
    paramView.setOnTouchListener(this);
  }
  
  public void onDestroy()
  {
    this.a = null;
    Iterator localIterator = this.pQ.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)((WeakReference)localIterator.next()).get();
      if (localView != null) {
        localView.setOnTouchListener(null);
      }
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      this.Cd = System.currentTimeMillis();
      this.mDownX = ((int)paramMotionEvent.getRawX());
      this.mDownY = ((int)paramMotionEvent.getRawY());
      continue;
      this.Es = System.currentTimeMillis();
      this.bBz = ((int)paramMotionEvent.getRawX());
      this.bBA = ((int)paramMotionEvent.getRawY());
      if (this.a != null) {
        this.a.a(this.Cd, this.Es, this.mDownX, this.mDownY, this.bBz, this.bBA);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tii
 * JD-Core Version:    0.7.0.1
 */