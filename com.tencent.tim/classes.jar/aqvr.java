import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqvr
{
  private List<awlz> Jj;
  private ViewGroup bD;
  private Activity mActivity;
  
  private aqvr(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.Jj = new ArrayList();
  }
  
  public static aqvr a(@NonNull Activity paramActivity)
  {
    return new aqvr(paramActivity);
  }
  
  private awlz a(@NonNull JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("type");
    Object localObject = new awma();
    View localView = ((awma)localObject).a(this.mActivity, str);
    if (localView == null)
    {
      rom.fail("type=" + str + " is illegal json=" + paramJSONObject, new Object[0]);
      return null;
    }
    localObject = ((awma)localObject).a(str, localView);
    if (localView == null)
    {
      rom.fail("type=" + str + " create null view model json=" + paramJSONObject, new Object[0]);
      return null;
    }
    ((awlz)localObject).ck(paramJSONObject);
    return localObject;
  }
  
  public aqvr a(@NonNull ViewGroup paramViewGroup)
  {
    this.bD = paramViewGroup;
    return this;
  }
  
  public aqvr a(@NonNull JSONArray paramJSONArray)
  {
    if (this.bD == null) {
      this.bD = new FrameLayout(this.mActivity);
    }
    efT();
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = a((JSONObject)localObject);
        if (localObject != null)
        {
          ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
          this.bD.addView(((awlz)localObject).getView(), localLayoutParams);
          this.Jj.add(localObject);
        }
      }
    }
    return this;
  }
  
  public aqvr a(@NonNull JSONObject paramJSONObject)
  {
    paramJSONObject = a(paramJSONObject);
    if (this.bD == null) {
      this.bD = new FrameLayout(this.mActivity);
    }
    efT();
    if (paramJSONObject == null) {
      return this;
    }
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.bD.addView(paramJSONObject.getView(), localLayoutParams);
    this.Jj.add(paramJSONObject);
    return this;
  }
  
  public void efT()
  {
    if (this.bD != null) {
      this.bD.removeAllViews();
    }
    Iterator localIterator = this.Jj.iterator();
    while (localIterator.hasNext()) {
      ((awlz)localIterator.next()).onDestory();
    }
    this.Jj.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqvr
 * JD-Core Version:    0.7.0.1
 */