import android.net.Uri;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnOverScrollHandler;

class arce
  implements TouchWebView.OnOverScrollHandler
{
  arce(arcd paramarcd, TouchWebView paramTouchWebView, RefreshView paramRefreshView) {}
  
  public void onBack()
  {
    this.b.zQ = false;
    this.g.onBack();
    this.b.ff(true);
  }
  
  public void onOverScroll(int paramInt)
  {
    Object localObject;
    if (!this.b.zQ)
    {
      this.b.zQ = true;
      localObject = this.h.getUrl();
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      localObject = Uri.parse((String)localObject);
      if ((localObject != null) && (((Uri)localObject).isHierarchical())) {
        this.b.ix.setText(acfp.m(2131715090) + ((Uri)localObject).getHost() + acfp.m(2131715083));
      }
      this.b.ix.setVisibility(0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        this.b.ix.setVisibility(8);
      }
    }
    this.g.onOverScroll(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arce
 * JD-Core Version:    0.7.0.1
 */