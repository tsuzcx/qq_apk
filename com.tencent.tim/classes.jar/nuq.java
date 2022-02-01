import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.ActionSheetHelper.1;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class nuq
  implements ausj.e
{
  public static String TAG = "BridgeModule.ActionSheetHelper";
  public boolean auU;
  private int bcK;
  private WeakReference<BridgeModule> cA;
  private ausj mActionSheet;
  
  public nuq(BridgeModule paramBridgeModule)
  {
    this.cA = new WeakReference(paramBridgeModule);
  }
  
  private void f(JSONObject paramJSONObject, String paramString)
  {
    int k = 0;
    if ((paramJSONObject == null) || (this.cA == null)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = ((BridgeModule)this.cA.get()).getViolaInstance().getActivity();
    } while (localObject1 == null);
    for (;;)
    {
      int n;
      try
      {
        localObject1 = ausj.b((Context)localObject1);
        Object localObject2 = paramJSONObject.optString("title");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((ausj)localObject1).setMainTitle((CharSequence)localObject2);
        }
        localObject2 = paramJSONObject.optJSONArray("items");
        int m = paramJSONObject.optInt("selected", -1);
        this.auU = false;
        String str = paramJSONObject.optString("close");
        if (TextUtils.isEmpty(str)) {
          break label367;
        }
        this.auU = true;
        ((ausj)localObject1).addButton(str, 3);
        i = 1;
        j = i;
        if (localObject2 != null)
        {
          j = i;
          if (((JSONArray)localObject2).length() > 0)
          {
            n = ((JSONArray)localObject2).length();
            j = k;
            if (m >= 0)
            {
              j = k;
              if (m < n)
              {
                j = 0;
                if (j >= n) {
                  break label378;
                }
                str = ((JSONArray)localObject2).getString(j);
                if (j != m) {
                  break label372;
                }
                bool = true;
                ((ausj)localObject1).addRadioButton(str, bool);
                j += 1;
                continue;
              }
            }
            if (j >= n) {
              break label378;
            }
            ((ausj)localObject1).addButton(((JSONArray)localObject2).getString(j));
            j += 1;
            continue;
          }
        }
        paramJSONObject = paramJSONObject.optString("cancel");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          ((ausj)localObject1).addCancelButton(paramJSONObject);
        }
        ((ausj)localObject1).a(new nur(this, paramString));
        ((ausj)localObject1).a(new nus(this, paramString));
        ((ausj)localObject1).setOnCancelListener(new nut(this, paramString));
        ((ausj)localObject1).a(this);
        this.mActionSheet = ((ausj)localObject1);
        this.bcK = j;
        this.mActionSheet.show();
        return;
      }
      catch (JSONException paramJSONObject) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(TAG, 2, "showActionSheet error:" + paramJSONObject.getMessage());
      return;
      label367:
      int i = 0;
      continue;
      label372:
      boolean bool = false;
      continue;
      label378:
      int j = i + n;
    }
  }
  
  public void e(JSONObject paramJSONObject, String paramString)
  {
    if (this.cA == null) {
      return;
    }
    if (Looper.myLooper() == null) {
      Looper.prepare();
    }
    new Handler(BaseActivity.sTopActivity.getMainLooper()).post(new ActionSheetHelper.1(this, paramJSONObject, paramString));
  }
  
  public void onDismissOperations() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nuq
 * JD-Core Version:    0.7.0.1
 */