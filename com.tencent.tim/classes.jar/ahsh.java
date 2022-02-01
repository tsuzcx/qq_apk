import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;

public class ahsh
  extends ahsd
{
  private ImageView Am;
  private TextView TP;
  private TextView tvTitle;
  
  public ahsh(Context paramContext, View paramView, ViewGroup paramViewGroup)
  {
    super(paramContext, paramView, paramViewGroup);
    paramContext = LayoutInflater.from(this.mContext).inflate(2131559367, paramViewGroup, false);
    if (paramContext != null) {
      this.bJ.addView(paramContext);
    }
    this.Am = ((ImageView)paramContext.findViewById(2131369050));
    this.TP = ((TextView)paramContext.findViewById(2131380950));
    this.tvTitle = ((TextView)paramContext.findViewById(2131380810));
  }
  
  public void a(FeedsItemData paramFeedsItemData)
  {
    super.a(paramFeedsItemData);
    this.tvTitle.setText(paramFeedsItemData.title + "");
    if (TextUtils.isEmpty(paramFeedsItemData.subTitle)) {
      this.TP.setVisibility(8);
    }
    for (;;)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = this.itemView.getResources().getDrawable(2130847948);
      localURLDrawableOptions.mFailedDrawable = this.itemView.getResources().getDrawable(2130847948);
      paramFeedsItemData = URLDrawable.getDrawable(paramFeedsItemData.coverImgUrl, localURLDrawableOptions);
      this.Am.setImageDrawable(paramFeedsItemData);
      return;
      this.TP.setVisibility(0);
      this.TP.setText(paramFeedsItemData.subTitle + "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahsh
 * JD-Core Version:    0.7.0.1
 */