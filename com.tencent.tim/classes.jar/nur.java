import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class nur
  implements ausj.a
{
  nur(nuq paramnuq, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = new JSONObject();
    for (;;)
    {
      try
      {
        paramView.put("index", paramInt);
        if ((!this.this$0.auU) || (paramInt != 0)) {
          continue;
        }
        paramView.put("type", 2);
        if (nuq.a(this.this$0) != null) {
          ((BridgeModule)nuq.a(this.this$0).get()).invokeCallJS(this.val$callback, paramView);
        }
      }
      catch (JSONException paramView)
      {
        continue;
      }
      nuq.a(this.this$0).dismiss();
      return;
      paramView.put("type", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nur
 * JD-Core Version:    0.7.0.1
 */