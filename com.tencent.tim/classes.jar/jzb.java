import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import java.net.URL;
import org.json.JSONObject;

public class jzb
  extends jyy
{
  private oud b;
  public int mHeight;
  public String mPicUrl;
  public int mWidth;
  
  public static jzb a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return null;
      try
      {
        jzb localjzb = new jzb();
        localjzb.mPicUrl = paramJSONObject.optString("imageUrl");
        localjzb.mWidth = paramJSONObject.optInt("imageWidth");
        localjzb.mHeight = paramJSONObject.optInt("imageHeight");
        boolean bool = TextUtils.isEmpty(localjzb.mPicUrl);
        if (!bool) {
          return localjzb;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return null;
  }
  
  public View a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, jyt paramjyt, boolean paramBoolean)
  {
    super.a(paramContext, paramString1, paramString2, paramString3, paramInt, paramjyt, paramBoolean);
    paramString1 = LayoutInflater.from(paramContext).inflate(2131560426, null);
    paramString2 = (ResizeURLImageView)paramString1.findViewById(2131373254);
    if (!TextUtils.isEmpty(this.mPicUrl)) {}
    try
    {
      paramString3 = new URL(this.mPicUrl);
      paramString2.setImage(paramString3);
      if (noy.a().a(paramString3)) {
        this.aEG = 2;
      }
      for (;;)
      {
        d(paramContext, paramString1);
        return paramString1;
        this.aEG = 1;
        this.b = new jzc(this, paramString1, paramString2);
        paramString2.setPublicAccountImageDownListener(this.b);
        paramString1.findViewById(2131370791).setVisibility(0);
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
    }
  }
  
  public void aBp()
  {
    if (this.mApp != null)
    {
      jzf localjzf = (jzf)this.mApp.getManager(248);
      if (localjzf != null) {
        localjzf.lz(this.mPicUrl);
      }
    }
  }
  
  public void aBq()
  {
    this.aEG = 1;
    this.jn.findViewById(2131370791).setVisibility(0);
    this.jn.findViewById(2131366692).setVisibility(8);
    try
    {
      URL localURL = new URL(this.mPicUrl);
      ((ResizeURLImageView)this.jn.findViewById(2131373254)).setImage(localURL);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.b = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.aEG == 3) {
      aBq();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jzb
 * JD-Core Version:    0.7.0.1
 */