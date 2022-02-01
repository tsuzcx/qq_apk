import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;

class aqyu
  implements jnn.a
{
  aqyu(aqys paramaqys) {}
  
  public void e(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = this.a.mRuntime.a(this.a.mRuntime.getActivity());
    if (paramBoolean) {
      if (this.a.cXb)
      {
        if ((localObject != null) && ((localObject instanceof ardm.n))) {
          ((ardm.n)localObject).c(true, 1, 2131692458);
        }
      }
      else {
        aqys.a(this.a);
      }
    }
    while ((localObject == null) || (!(localObject instanceof ardm.n))) {
      for (;;)
      {
        return;
        localObject = QQToast.a(BaseApplicationImpl.getContext(), 1, 2131692458, 1);
        ((QQToast)localObject).show(((QQToast)localObject).getTitleBarHeight());
      }
    }
    ((ardm.n)localObject).c(false, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqyu
 * JD-Core Version:    0.7.0.1
 */