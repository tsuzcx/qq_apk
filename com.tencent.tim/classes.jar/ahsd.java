import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;

public abstract class ahsd
  extends ahsa
{
  protected ImageView Al;
  protected TextView TJ;
  protected TextView TK;
  protected TextView TN;
  protected FrameLayout bJ;
  protected RelativeLayout layoutAction;
  protected Context mContext;
  
  public ahsd(Context paramContext, View paramView, ViewGroup paramViewGroup)
  {
    super(paramContext, paramView, paramViewGroup);
    this.mContext = paramContext;
    this.TN = ((TextView)paramView.findViewById(2131380881));
    this.TJ = ((TextView)paramView.findViewById(2131380775));
    this.TK = ((TextView)paramView.findViewById(2131380545));
    this.Al = ((ImageView)paramView.findViewById(2131368981));
    this.bJ = ((FrameLayout)paramView.findViewById(2131370183));
    this.layoutAction = ((RelativeLayout)paramView.findViewById(2131370153));
  }
  
  public void a(FeedsItemData paramFeedsItemData)
  {
    this.itemView.setBackgroundDrawable(ahtz.a(this.itemView.getContext(), 8.0F, 8.0F, 8.0F, 8.0F));
    if (!TextUtils.isEmpty(paramFeedsItemData.rcmdReason))
    {
      this.TN.setVisibility(0);
      this.TN.setText(paramFeedsItemData.rcmdReason + "");
      if ((!TextUtils.isEmpty(paramFeedsItemData.label)) || (!TextUtils.isEmpty(paramFeedsItemData.operateText))) {
        break label130;
      }
      this.layoutAction.setVisibility(8);
    }
    for (;;)
    {
      this.itemView.setOnClickListener(new ahse(this, paramFeedsItemData));
      return;
      this.TN.setVisibility(8);
      break;
      label130:
      this.layoutAction.setVisibility(0);
      if (TextUtils.isEmpty(paramFeedsItemData.operateText))
      {
        this.TK.setVisibility(8);
        this.Al.setVisibility(8);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramFeedsItemData.label)) {
          break label287;
        }
        this.TJ.setVisibility(8);
        break;
        this.TK.setText(paramFeedsItemData.operateText + "");
        this.TK.setVisibility(0);
        this.Al.setVisibility(0);
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.itemView.getResources().getDrawable(2130841786);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.itemView.getResources().getDrawable(2130841786);
        localObject = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/201908/upload_edff4f642a92ef91b6cb1b7209369506.png", (URLDrawable.URLDrawableOptions)localObject);
        this.Al.setImageDrawable((Drawable)localObject);
      }
      label287:
      this.TJ.setText(paramFeedsItemData.label + "");
      this.TJ.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahsd
 * JD-Core Version:    0.7.0.1
 */