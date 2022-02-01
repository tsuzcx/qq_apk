import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.Map;

public class qby
  extends qdh
{
  private URLDrawable e;
  private String mImageUrl;
  
  public qby()
  {
    a(false, true);
  }
  
  public qby(String paramString)
  {
    this();
    this.mImageUrl = paramString;
  }
  
  public boolean Jp()
  {
    if (TextUtils.isEmpty(this.mImageUrl)) {
      return false;
    }
    return super.Jp();
  }
  
  protected void M(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramMap.containsKey("UrlDrawableDownloadJob_iiu"))) {
      this.mImageUrl = ((String)qdv.a(this.cb, "UrlDrawableDownloadJob_iiu", this.mImageUrl));
    }
  }
  
  public void bnE()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    this.e = URLDrawable.getDrawable(this.mImageUrl, localURLDrawableOptions);
    this.e.setURLDrawableListener(new qbz(this));
    if ((this.e.getStatus() == 1) && (this.e.getCurrDrawable() != null))
    {
      p("UrlDrawableDownloadJob_dra", this.e.getCurrDrawable());
      sA(true);
      return;
    }
    this.e.startDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qby
 * JD-Core Version:    0.7.0.1
 */