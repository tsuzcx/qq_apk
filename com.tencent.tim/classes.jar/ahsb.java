import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;

public class ahsb
  extends ahsa
{
  private ImageView Ak;
  
  public ahsb(Context paramContext, View paramView, ViewGroup paramViewGroup)
  {
    super(paramContext, paramView, paramViewGroup);
    this.Ak = ((ImageView)paramView.findViewById(2131363286));
  }
  
  public void a(FeedsItemData paramFeedsItemData)
  {
    this.itemView.setBackgroundDrawable(ahtz.a(this.itemView.getContext(), 8.0F, 8.0F, 8.0F, 8.0F));
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.itemView.getResources().getDrawable(2130847948);
    localURLDrawableOptions.mFailedDrawable = this.itemView.getResources().getDrawable(2130847948);
    this.Ak.setImageDrawable(URLDrawable.getDrawable(paramFeedsItemData.coverImgUrl, localURLDrawableOptions));
    this.Ak.setOnClickListener(new ahsc(this, paramFeedsItemData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahsb
 * JD-Core Version:    0.7.0.1
 */