package cooperation.qzone.contentbox;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import aqnm;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import java.util.ArrayList;

public class QzoneMsgPagerAdapter
  extends PagerAdapter
{
  private static final int IMAGE_HEIGHT = aqnm.dpToPx(230.0F);
  private static final int IMAGE_WIDTH = aqnm.getScreenWidth() - aqnm.dpToPx(24.0F);
  private ArrayList<String> nZ;
  private ArrayList<AnyScaleTypeImageView> views;
  
  public QzoneMsgPagerAdapter(Context paramContext, ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {}
    for (int i = 0;; i = paramArrayList.size())
    {
      this.views = new ArrayList(i);
      while (j < i)
      {
        AnyScaleTypeImageView localAnyScaleTypeImageView = new AnyScaleTypeImageView(paramContext);
        localAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ThemeUtil.setColorFilterIfNeed(localAnyScaleTypeImageView);
        this.views.add(localAnyScaleTypeImageView);
        j += 1;
      }
    }
    this.nZ = paramArrayList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((this.views == null) || (this.views.size() == 0) || (paramInt < 0) || (paramInt >= this.views.size())) {
      return;
    }
    paramObject = (AnyScaleTypeImageView)this.views.get(paramInt);
    paramObject.setImageDrawable(null);
    paramViewGroup.removeView(paramObject);
  }
  
  public int getCount()
  {
    if (this.views == null) {
      return 0;
    }
    return this.views.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if ((this.views == null) || (this.views.size() == 0) || (paramInt < 0) || (paramInt >= this.views.size())) {
      return null;
    }
    AnyScaleTypeImageView localAnyScaleTypeImageView = (AnyScaleTypeImageView)this.views.get(paramInt);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = IMAGE_WIDTH;
    localURLDrawableOptions.mRequestHeight = IMAGE_HEIGHT;
    if ((this.nZ != null) && (this.nZ.get(paramInt) != null))
    {
      if ((!((String)this.nZ.get(paramInt)).startsWith("http")) && (!((String)this.nZ.get(paramInt)).startsWith("https"))) {
        break label157;
      }
      localAnyScaleTypeImageView.setImageDrawable(URLDrawable.getDrawable((String)this.nZ.get(paramInt), localURLDrawableOptions));
    }
    for (;;)
    {
      paramViewGroup.addView(localAnyScaleTypeImageView);
      return this.views.get(paramInt);
      label157:
      localAnyScaleTypeImageView.setImageDrawable(URLDrawable.getFileDrawable((String)this.nZ.get(paramInt), localURLDrawableOptions));
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.QzoneMsgPagerAdapter
 * JD-Core Version:    0.7.0.1
 */