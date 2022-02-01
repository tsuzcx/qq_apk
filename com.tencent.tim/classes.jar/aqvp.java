import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.vip.diy.TemplateLikeView;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqvp
  extends awlz
{
  private String bWn = "";
  
  public aqvp(String paramString1, View paramView, String paramString2)
  {
    super(paramString1, paramView);
    this.bWn = paramString2;
    ((TemplateLikeView)paramView).tA(1);
  }
  
  protected ViewGroup.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams, JSONObject paramJSONObject)
  {
    this.JO = -2;
    this.mViewHeight = gi(paramJSONObject.optString("height"));
    paramLayoutParams.width = -2;
    paramLayoutParams.height = -2;
    int i = rpq.dip2px(this.ey.getContext(), paramJSONObject.optInt("lpd", 2) / 2);
    int j = rpq.dip2px(this.ey.getContext(), paramJSONObject.optInt("rpd", 2) / 2);
    ((TemplateLikeView)this.ey).setContainerLayoutParams(this.JO, this.mViewHeight, i, j);
    return paramLayoutParams;
  }
  
  protected URLDrawable a(String paramString, DownloadParams.DecodeHandler paramDecodeHandler)
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = paramString;
    if (!paramString.startsWith("http"))
    {
      str = paramString;
      if (!TextUtils.isEmpty(this.bWn)) {
        if (!this.bWn.startsWith("http")) {
          break label114;
        }
      }
    }
    for (str = this.bWn + paramString;; str = paramString)
    {
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mLoadingDrawable = aoop.TRANSPARENT;
      paramString.mFailedDrawable = aoop.TRANSPARENT;
      paramString.mPlayGifImage = false;
      if (paramDecodeHandler != null) {
        paramString.mMemoryCacheKeySuffix = paramDecodeHandler.toString();
      }
      paramString = URLDrawable.getDrawable(str, paramString);
      paramString.setDecodeHandler(paramDecodeHandler);
      return paramString;
      label114:
      QLog.e("JsonInflateViewModel", 1, "it have the illegal url prefix=" + this.bWn);
    }
  }
  
  public void onDestory()
  {
    super.onDestory();
  }
  
  protected void setAttribute(String paramString1, String paramString2)
  {
    if ("bg".equals(paramString1)) {
      if ((this.ey instanceof TemplateLikeView)) {
        ((TemplateLikeView)this.ey).setVoteContainerBackground(a(paramString2, null));
      }
    }
    do
    {
      return;
      if (!"style".equals(paramString1)) {
        break;
      }
    } while (!(this.ey instanceof TemplateLikeView));
    paramString1 = (TemplateLikeView)this.ey;
    if ("1".equals(paramString2)) {}
    for (int i = 0;; i = 1)
    {
      paramString1.tA(i);
      return;
    }
    super.setAttribute(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqvp
 * JD-Core Version:    0.7.0.1
 */