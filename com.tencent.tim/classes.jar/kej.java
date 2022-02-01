import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class kej
  implements View.OnTouchListener
{
  public kej(ShopWebViewFragment paramShopWebViewFragment, JSONObject paramJSONObject1, JSONObject paramJSONObject2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      this.b.lastY = ((int)paramMotionEvent.getY());
      return false;
      int i = (int)(this.b.lastY - paramMotionEvent.getY());
      this.b.lastY = ((int)paramMotionEvent.getY());
      if ((i < 0) && (this.b.aIl > 0)) {
        this.b.aIl = 0;
      }
      if ((i > 0) && (this.b.aIl < 0)) {
        this.b.aIl = 0;
      }
      paramView = this.b;
      paramView.aIl = (i + paramView.aIl);
      return false;
      try
      {
        this.val$data.put("y_offset", this.b.aIl);
        paramView = WebViewPlugin.toJsScript("onScroll", this.val$data, this.U);
        if (this.b.j != null)
        {
          this.b.j.callJs(paramView);
          return false;
        }
      }
      catch (JSONException paramView)
      {
        paramView.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kej
 * JD-Core Version:    0.7.0.1
 */