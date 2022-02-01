import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.ProteusLog;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class lrl
{
  public static void a(@NonNull View paramView, @NonNull JSONObject paramJSONObject)
    throws JSONException
  {
    int i = paramView.getLeft();
    int j = paramView.getRight();
    int k = paramView.getTop();
    int m = paramView.getBottom();
    Object localObject1 = paramView.getClass().getSimpleName();
    Object localObject2 = new Rect(i, k, j, m);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("name", localObject1);
    localJSONObject.put("visibility", paramView.getVisibility());
    localJSONObject.put("bounds", localObject2);
    paramJSONObject.put("view", localJSONObject);
    if ((paramView instanceof ViewGroup))
    {
      j = ((ViewGroup)paramView).getChildCount();
      localObject1 = new JSONArray();
      i = 0;
      while (i < j)
      {
        localObject2 = new JSONObject();
        a(((ViewGroup)paramView).getChildAt(i), (JSONObject)localObject2);
        ((JSONArray)localObject1).put(localObject2);
        i += 1;
      }
      paramJSONObject.put("children", localObject1);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 1, paramString2);
  }
  
  private static void dumpViewBaseHierarchy(@NonNull ViewBase paramViewBase, @NonNull JSONObject paramJSONObject)
    throws JSONException
  {
    Object localObject1 = new Rect(paramViewBase.getDrawLeft(), paramViewBase.getDrawTop(), paramViewBase.getWidth(), paramViewBase.getHeight());
    Object localObject2 = paramViewBase.getClass().getSimpleName();
    Object localObject3 = paramViewBase.getName();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("name", localObject2);
    localJSONObject.put("id", localObject3);
    localJSONObject.put("visibility", paramViewBase.getVisibility());
    localJSONObject.put("bounds", localObject1);
    paramJSONObject.put("view", localJSONObject);
    if ((paramViewBase instanceof Layout))
    {
      localObject1 = ((Layout)paramViewBase).getSubViews();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        paramViewBase = new JSONArray();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ViewBase)((Iterator)localObject1).next();
          localObject3 = new JSONObject();
          dumpViewBaseHierarchy((ViewBase)localObject2, (JSONObject)localObject3);
          paramViewBase.put(localObject3);
        }
        paramJSONObject.put("children", paramViewBase);
      }
    }
  }
  
  public static void e(@NonNull View paramView, String paramString)
  {
    if (shouldLog()) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      a(paramView, localJSONObject);
      d(paramString, "logViewHierarchy: " + localJSONObject.toString());
      return;
    }
    catch (Exception paramView)
    {
      QLog.e(paramString, 1, "[logViewHierarchy] ", paramView);
    }
  }
  
  public static void logViewBaseHierarchy(@NonNull ViewBase paramViewBase, String paramString)
  {
    if (shouldLog()) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      dumpViewBaseHierarchy(paramViewBase, localJSONObject);
      d(paramString, "logViewBaseHierarchy: " + localJSONObject.toString());
      return;
    }
    catch (Exception paramViewBase)
    {
      QLog.e(paramString, 1, "[logViewBaseHierarchy] ", paramViewBase);
    }
  }
  
  public static boolean shouldLog()
  {
    return true;
  }
  
  public static class a
    implements LogUtil.ProteusLog
  {
    public void d(String paramString1, int paramInt, String paramString2)
    {
      QLog.d(paramString1, paramInt, paramString2);
    }
    
    public void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
    {
      QLog.d(paramString1, paramInt, paramString2, paramThrowable);
    }
    
    public void e(String paramString1, int paramInt, String paramString2)
    {
      QLog.e(paramString1, paramInt, paramString2);
    }
    
    public void e(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
    {
      QLog.e(paramString1, paramInt, paramString2, paramThrowable);
    }
    
    public void i(String paramString1, int paramInt, String paramString2)
    {
      QLog.i(paramString1, paramInt, paramString2);
    }
    
    public void i(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
    {
      QLog.i(paramString1, paramInt, paramString2, paramThrowable);
    }
    
    public boolean isColorLevel()
    {
      return QLog.isColorLevel();
    }
    
    public void w(String paramString1, int paramInt, String paramString2)
    {
      QLog.w(paramString1, paramInt, paramString2);
    }
    
    public void w(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
    {
      QLog.w(paramString1, paramInt, paramString2, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lrl
 * JD-Core Version:    0.7.0.1
 */