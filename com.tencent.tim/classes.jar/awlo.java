import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.TMG.utils.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class awlo
{
  private awma a;
  private WeakReference<Context> hc;
  
  private awlo(Context paramContext)
  {
    this.hc = new WeakReference(paramContext);
  }
  
  private ViewGroup.LayoutParams a(View paramView, awlz paramawlz, JSONObject paramJSONObject)
  {
    if ((paramView == null) || (paramJSONObject == null) || (paramJSONObject.length() == 0) || (paramawlz == null)) {
      return null;
    }
    return this.a.a(paramView).a(paramJSONObject, paramawlz);
  }
  
  public static awlo a(@NonNull Context paramContext)
  {
    return new awlo(paramContext);
  }
  
  private final awlz a(String paramString, Context paramContext, JSONObject paramJSONObject)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      for (;;)
      {
        return null;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.i("JsonInflater", 0, "createViewModel：" + paramString);
          }
          paramContext = this.a.a(paramContext, paramString);
          if (paramContext != null)
          {
            paramContext = this.a.a(paramString, paramContext);
            a(paramContext, paramJSONObject);
            return paramContext;
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          QLog.e("JsonInflater", 1, "Error inflating type : " + paramString);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("JsonInflater", 0, "createViewModel fail finish");
    return null;
  }
  
  private awlz a(JSONObject paramJSONObject, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramJSONObject == null) {}
    label103:
    do
    {
      return null;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("JsonInflater", 0, "inflate: ");
        }
        if ((this.hc != null) && (this.hc.get() != null)) {
          break label103;
        }
        paramJSONObject = new StringBuilder().append("inflate: weakContext == null ： ");
        paramBoolean = bool;
        if (this.hc == null) {
          paramBoolean = true;
        }
        QLog.e("JsonInflater", 1, paramBoolean + " || weakContext.get() == null ");
        return null;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        QLog.e("JsonInflater", 1, "inflate: exception");
        paramJSONObject = null;
      }
      return paramJSONObject;
      localObject1 = (Context)this.hc.get();
    } while (localObject1 == null);
    Object localObject2 = paramJSONObject.optString("type");
    if (QLog.isColorLevel()) {
      QLog.i("JsonInflater", 0, "Creating root view:");
    }
    localObject2 = a((String)localObject2, (Context)localObject1, paramJSONObject);
    if (localObject2 == null)
    {
      QLog.e("JsonInflater", 1, "inflate: createViewModel error null return");
      return null;
    }
    View localView = ((awlz)localObject2).getView();
    if (localView == null)
    {
      QLog.e("JsonInflater", 1, "inflate: tempView error null return");
      return null;
    }
    ViewGroup.LayoutParams localLayoutParams;
    if (paramViewGroup != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("JsonInflater", 0, "generateLayoutParams");
      }
      localLayoutParams = a(paramViewGroup, (awlz)localObject2, paramJSONObject);
      localObject1 = localLayoutParams;
      if (!paramBoolean)
      {
        localObject1 = localLayoutParams;
        if (localLayoutParams != null) {
          localView.setLayoutParams(localLayoutParams);
        }
      }
    }
    for (Object localObject1 = localLayoutParams;; localObject1 = null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("JsonInflater", 0, "-----> start inflating children");
      }
      a((awlz)localObject2, localView.getContext(), paramJSONObject);
      if (QLog.isColorLevel()) {
        QLog.i("JsonInflater", 0, "-----> done inflating children");
      }
      paramJSONObject = (JSONObject)localObject2;
      if (paramViewGroup == null) {
        break;
      }
      paramJSONObject = (JSONObject)localObject2;
      if (!paramBoolean) {
        break;
      }
      paramViewGroup.addView(localView, (ViewGroup.LayoutParams)localObject1);
      ((awlz)localObject2).RB();
      paramJSONObject = (JSONObject)localObject2;
      break;
    }
  }
  
  public awlz a(String paramString, ViewGroup paramViewGroup, boolean paramBoolean, awma paramawma)
  {
    Object localObject3 = null;
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = new JSONObject(paramString);
        if (localObject1 != null)
        {
          localObject1 = a((JSONObject)localObject1, paramViewGroup, paramBoolean, paramawma);
          return localObject1;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        localObject2 = null;
        continue;
      }
      try
      {
        paramString = new JSONArray(paramString);
        localObject2 = localObject3;
        if (paramString == null) {
          continue;
        }
        return a(paramString, paramViewGroup, paramBoolean, paramawma);
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = null;
        }
      }
    }
  }
  
  public awlz a(String paramString, awma paramawma)
  {
    return a(paramString, null, true, paramawma);
  }
  
  public awlz a(@NonNull JSONArray paramJSONArray, ViewGroup paramViewGroup, boolean paramBoolean, awma paramawma)
  {
    this.a = paramawma;
    if ((this.hc == null) || (this.hc.get() == null))
    {
      paramJSONArray = new StringBuilder().append("inflate: weakContext == null ： ");
      if (this.hc == null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        QLog.e("JsonInflater", 1, paramBoolean + " || weakContext.get() == null ");
        return null;
      }
    }
    paramViewGroup = (Context)this.hc.get();
    if (paramViewGroup == null) {
      return null;
    }
    paramViewGroup = new RelativeLayout(paramViewGroup);
    paramawma = this.a.a(paramViewGroup);
    int i = 0;
    while (i < paramJSONArray.length())
    {
      awlz localawlz = a(paramJSONArray.optJSONObject(i), paramViewGroup, false);
      if (localawlz != null)
      {
        paramViewGroup.addView(localawlz.getView());
        localawlz.RB();
        paramawma.a(localawlz);
      }
      i += 1;
    }
    return paramawma;
  }
  
  public awlz a(@NonNull JSONObject paramJSONObject, ViewGroup paramViewGroup, boolean paramBoolean, awma paramawma)
  {
    rom.bvK();
    this.a = paramawma;
    return a(paramJSONObject, paramViewGroup, paramBoolean);
  }
  
  void a(awlz paramawlz, Context paramContext, JSONObject paramJSONObject)
  {
    if ((paramawlz == null) || (paramContext == null) || (paramJSONObject == null) || (paramJSONObject.length() == 0)) {}
    do
    {
      return;
      paramJSONObject = paramJSONObject.optJSONArray("child");
    } while (paramJSONObject == null);
    int i = 0;
    label34:
    if (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      if (localJSONObject == null) {
        break label147;
      }
      awlz localawlz = a(localJSONObject.optString("type"), paramContext, localJSONObject);
      ViewGroup localViewGroup = (ViewGroup)paramawlz.getView();
      ViewGroup.LayoutParams localLayoutParams = a(localViewGroup, localawlz, localJSONObject);
      a(localawlz, paramContext, localJSONObject);
      if ((localawlz != null) && (localawlz.getView() != null))
      {
        localViewGroup.addView(localawlz.getView(), localLayoutParams);
        localawlz.RB();
        paramawlz.a(localawlz);
      }
    }
    for (;;)
    {
      i += 1;
      break label34;
      break;
      label147:
      QLog.e("JsonInflater", 1, "rInflateChildren error: object = null");
    }
  }
  
  protected void a(awlz paramawlz, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {
      return;
    }
    if (paramawlz != null) {
      paramawlz.ck(paramJSONObject);
    }
    this.a.a(paramawlz, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awlo
 * JD-Core Version:    0.7.0.1
 */