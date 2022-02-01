import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

public class mmg
  extends SimpleAdapter
{
  private static final String[] bz = { "key_cover_url", "key_title", "key_summary" };
  private static final int[] jdField_do = { 2131368948, 2131379604, 2131379603 };
  private Drawable GRAY_PLACEHOLDER = new ColorDrawable(Color.parseColor("#E9E9E9"));
  
  public mmg(Context paramContext, List<Map<String, CharSequence>> paramList)
  {
    super(paramContext, paramList, 2131560497, bz, jdField_do);
  }
  
  public void setViewImage(ImageView paramImageView, String paramString)
  {
    if ("create_topic".equals(paramString))
    {
      paramImageView.setImageResource(2130850371);
      return;
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = this.GRAY_PLACEHOLDER;
      localURLDrawableOptions.mFailedDrawable = this.GRAY_PLACEHOLDER;
      localURLDrawableOptions.mRequestWidth = paramImageView.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = paramImageView.getLayoutParams().height;
      paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      paramImageView.setImageDrawable(this.GRAY_PLACEHOLDER);
      QLog.e("ReadInJoyTopicListAdapt", 2, "setViewImage: illegal url  - " + paramString, localIllegalArgumentException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mmg
 * JD-Core Version:    0.7.0.1
 */