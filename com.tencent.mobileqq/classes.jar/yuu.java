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

public class yuu
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private List<WeakReference<View>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private yuv jdField_a_of_type_Yuv;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private int c;
  private int d;
  
  String a(String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = this.jdField_b_of_type_Long;
    long l2 = this.jdField_a_of_type_Long;
    long l3 = System.currentTimeMillis();
    long l4 = this.jdField_b_of_type_Long;
    long l5 = System.currentTimeMillis();
    long l6 = this.jdField_a_of_type_Long;
    int i;
    int j;
    int k;
    Object localObject;
    if (paramBoolean1)
    {
      i = 1;
      j = axlk.b(BaseApplicationImpl.getContext());
      k = axlk.a(BaseApplicationImpl.getContext());
      localObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("g", String.valueOf(l1 - l2));
        ((JSONObject)localObject).put("sc", String.valueOf(l3 - l4));
        ((JSONObject)localObject).put("ec", String.valueOf(l5 - l6));
        ((JSONObject)localObject).put("aa", String.valueOf(this.jdField_a_of_type_Int));
        ((JSONObject)localObject).put("ab", String.valueOf(this.jdField_b_of_type_Int));
        ((JSONObject)localObject).put("ba", String.valueOf(this.c));
        ((JSONObject)localObject).put("bb", String.valueOf(this.d));
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
        yxp.d("GdtMotiveVideoClickCoordinateReportHelper", "getReportString error", localException);
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
          yxp.d("GdtMotiveVideoClickCoordinateReportHelper", "getReportString click url result : " + (String)localObject);
        }
      }
      return localObject;
      i = 0;
      break;
      i = 1;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Yuv = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)((WeakReference)localIterator.next()).get();
      if (localView != null) {
        localView.setOnTouchListener(null);
      }
    }
  }
  
  void a(View paramView)
  {
    this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramView));
    paramView.setOnTouchListener(this);
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
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getRawX());
      this.jdField_b_of_type_Int = ((int)paramMotionEvent.getRawY());
      continue;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.c = ((int)paramMotionEvent.getRawX());
      this.d = ((int)paramMotionEvent.getRawY());
      if (this.jdField_a_of_type_Yuv != null) {
        this.jdField_a_of_type_Yuv.a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yuu
 * JD-Core Version:    0.7.0.1
 */