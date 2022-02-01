import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class aqwa
  extends aqvx
{
  public aqwa(Activity paramActivity, JSONObject paramJSONObject, alcn paramalcn)
  {
    super(paramActivity, paramJSONObject, paramalcn);
    this.mBorderWidth = rpq.dip2px(paramActivity, 3.0F);
  }
  
  public void O(HashMap<String, View> paramHashMap)
  {
    paramHashMap.put("map_key_qzone", this.mInflater.inflate(2131562215, null));
  }
  
  public ProfileCardFavorShowView a(Activity paramActivity)
  {
    return new ProfileCardFavorShowView(paramActivity, null, 2131562206);
  }
  
  protected void a(JSONObject paramJSONObject, View paramView, TextView paramTextView, ImageView paramImageView)
  {
    if ((paramView != null) && (paramTextView != null))
    {
      paramTextView.setTextColor(this.mColor);
      String str = s(paramJSONObject);
      if (TextUtils.isEmpty(str)) {
        break label141;
      }
      int i = rpq.dip2px(this.mActivity, 300.0F);
      int j = (int)paramTextView.getPaint().measureText(paramTextView.getText().toString());
      int k = rpq.dip2px(this.mActivity, 23.0F);
      int m = rpq.dip2px(this.mActivity, 40.0F);
      paramView.setBackgroundDrawable(a(str, new aqwa.a(Math.min(j + k, i), m)));
    }
    for (;;)
    {
      if (paramImageView != null)
      {
        paramView = t(paramJSONObject);
        if (TextUtils.isEmpty(paramView)) {
          break;
        }
        paramImageView.setImageDrawable(e(paramView));
      }
      return;
      label141:
      if (paramJSONObject != null) {
        QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, paramJSONObject.optString("type") + " bind title icon is null!");
      }
      paramView.setVisibility(8);
    }
    if (paramJSONObject != null) {
      QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, paramJSONObject.optString("type") + " bind arrow icon is null!");
    }
    paramImageView.setVisibility(8);
  }
  
  public static class a
    implements DownloadParams.DecodeHandler
  {
    private int edk;
    private int edl;
    
    public a(int paramInt1, int paramInt2)
    {
      this.edk = paramInt1;
      this.edl = paramInt2;
    }
    
    public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
    {
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        return null;
      }
      paramDownloadParams = Bitmap.createBitmap(this.edk, this.edl, Bitmap.Config.ARGB_8888);
      Paint localPaint = new Paint();
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setAntiAlias(true);
      Canvas localCanvas = new Canvas(paramDownloadParams);
      localCanvas.drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth() / 5, paramBitmap.getHeight()), new Rect(0, 0, paramBitmap.getWidth() / 5, paramDownloadParams.getHeight()), localPaint);
      localCanvas.drawBitmap(paramBitmap, new Rect(paramBitmap.getWidth() / 5, 0, paramBitmap.getWidth() - paramBitmap.getWidth() / 5, paramBitmap.getHeight()), new Rect(paramBitmap.getWidth() / 5, 0, paramDownloadParams.getWidth() - paramBitmap.getWidth() / 5, paramDownloadParams.getHeight()), localPaint);
      localCanvas.drawBitmap(paramBitmap, new Rect(paramBitmap.getWidth() - paramBitmap.getWidth() / 5, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new Rect(paramDownloadParams.getWidth() - paramBitmap.getWidth() / 5, 0, paramDownloadParams.getWidth(), paramDownloadParams.getHeight()), localPaint);
      return paramDownloadParams;
    }
    
    public String toString()
    {
      return "TitleDrawableDecoderHandler{reqW=" + this.edk + ", reqH=" + this.edl + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqwa
 * JD-Core Version:    0.7.0.1
 */