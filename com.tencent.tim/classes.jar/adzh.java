import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class adzh
  extends BaseAdapter
{
  public adzh(CardPicGalleryActivity paramCardPicGalleryActivity) {}
  
  public int getCount()
  {
    if (this.a.ve != null) {
      return this.a.ve.size();
    }
    return 0;
  }
  
  public String getItem(int paramInt)
  {
    if ((this.a.ve != null) && (paramInt < this.a.ve.size()) && (paramInt >= 0)) {
      return (String)this.a.ve.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    CardPicGalleryActivity.a locala;
    Object localObject;
    if (paramView == null)
    {
      paramView = this.a.getLayoutInflater().inflate(2131561245, null);
      locala = new CardPicGalleryActivity.a();
      locala.I = ((URLImageView)paramView.findViewById(2131364317));
      paramView.setTag(locala);
      localObject = getItem(paramInt);
      if ((this.a.gQ != 0) && (this.a.mDefaultDrawable == null)) {
        this.a.mDefaultDrawable = this.a.getResources().getDrawable(this.a.gQ);
      }
      if (localObject == null) {}
    }
    else
    {
      try
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if (this.a.mDefaultDrawable == null) {
          break label210;
        }
        localObject = URLDrawable.getDrawable((String)localObject, this.a.mDefaultDrawable, this.a.mDefaultDrawable);
        label139:
        locala.I.setImageDrawable((Drawable)localObject);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions;
          localException1.printStackTrace();
          continue;
          this.a.qe.setVisibility(0);
        }
      }
      if ((this.a.mMode == 1) && (!this.a.bSu)) {
        this.a.qe.setVisibility(8);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      locala = (CardPicGalleryActivity.a)paramView.getTag();
      break;
      label210:
      localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
      break label139;
      try
      {
        if (this.a.mDefaultDrawable != null)
        {
          localObject = URLDrawable.getDrawable("https://aaa", this.a.mDefaultDrawable, this.a.mDefaultDrawable);
          localException1.I.setImageDrawable((Drawable)localObject);
        }
        for (;;)
        {
          this.a.qe.setVisibility(8);
          break;
          localException1.I.setImageDrawable(null);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adzh
 * JD-Core Version:    0.7.0.1
 */