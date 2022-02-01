import android.graphics.Color;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class zee
  extends RecyclerView.Adapter
{
  public List<String> rN = new ArrayList();
  
  public zee(List<String> paramList)
  {
    if (paramList != null)
    {
      this.rN.clear();
      this.rN.addAll(paramList);
    }
  }
  
  public int getItemCount()
  {
    if (this.rN != null) {
      return this.rN.size();
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ImageView localImageView = ((zee.a)paramViewHolder).vi;
    if (!TextUtils.isEmpty((String)this.rN.get(paramInt)))
    {
      if (paramInt != 0) {
        break label108;
      }
      String str = (String)this.rN.get(paramInt);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
      localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
      localURLDrawableOptions.mPlayGifImage = akyr.lP(str);
      localURLDrawableOptions.mUseAutoScaleParams = true;
      localImageView.setImageDrawable(URLDrawable.getFileDrawable(str, localURLDrawableOptions));
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      label108:
      if (paramInt == 1)
      {
        localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        localImageView.setPadding(0, 0, 0, 0);
        localImageView.setImageDrawable(null);
        localImageView.setBackgroundColor(Color.parseColor("#9A989EB4"));
      }
      else if (paramInt == 2)
      {
        localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        localImageView.setPadding(0, 0, 0, 0);
        localImageView.setImageDrawable(null);
        localImageView.setBackgroundColor(Color.parseColor("#48989EB4"));
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new zee.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559284, paramViewGroup, false));
  }
  
  class a
    extends RecyclerView.ViewHolder
  {
    ImageView vi;
    
    a(View paramView)
    {
      super();
      this.vi = ((ImageView)paramView.findViewById(2131378680));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zee
 * JD-Core Version:    0.7.0.1
 */