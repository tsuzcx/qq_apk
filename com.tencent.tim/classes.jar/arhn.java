import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.ProfileCardVideoCoverShowView;
import com.tencent.mobileqq.widget.ProfileCardVideoCoverShowView.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class arhn
  extends BaseAdapter
{
  public arhn(ProfileCardVideoCoverShowView paramProfileCardVideoCoverShowView) {}
  
  public ProfileCardVideoCoverShowView.b a(int paramInt)
  {
    return (ProfileCardVideoCoverShowView.b)ProfileCardVideoCoverShowView.a(this.a).get(paramInt);
  }
  
  public int getCount()
  {
    return ProfileCardVideoCoverShowView.a(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131561553, null, false);
      paramView.setTag((ImageView)paramView.findViewById(2131368820));
      localObject = new StateListDrawable();
      ((StateListDrawable)localObject).addState(ProfileCardVideoCoverShowView.access$100(), new ColorDrawable(855638016));
      ((StateListDrawable)localObject).addState(ProfileCardVideoCoverShowView.g(), new ColorDrawable(0));
      paramView.findViewById(2131380117).setBackgroundDrawable((Drawable)localObject);
    }
    for (;;)
    {
      localObject = (ImageView)paramView.getTag();
      ProfileCardVideoCoverShowView.b localb = a(paramInt);
      if (TextUtils.isEmpty(localb.coverUrl))
      {
        ((ImageView)localObject).setImageDrawable(null);
        if (paramInt != 0) {
          break label240;
        }
        paramView.setPadding(wja.dp2px(12.0F, this.a.getResources()), 0, 0, 0);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
        localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
        localURLDrawableOptions.mRequestHeight = wja.dp2px(178.0F, this.a.getResources());
        localURLDrawableOptions.mRequestWidth = wja.dp2px(100.0F, this.a.getResources());
        ((ImageView)localObject).setImageDrawable(URLDrawable.getDrawable(localb.coverUrl, localURLDrawableOptions));
        break;
        label240:
        paramView.setPadding(0, 0, 0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arhn
 * JD-Core Version:    0.7.0.1
 */