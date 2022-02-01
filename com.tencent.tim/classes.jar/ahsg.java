import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.Gift;
import java.util.List;

public class ahsg
  extends ahsd
{
  public TextView TO;
  public LinearLayout[] c;
  public LinearLayout jf;
  public TextView[] r;
  public ImageView[] t;
  
  public ahsg(Context paramContext, View paramView, ViewGroup paramViewGroup)
  {
    super(paramContext, paramView, paramViewGroup);
    paramContext = LayoutInflater.from(this.mContext).inflate(2131559365, paramViewGroup, false);
    if (paramContext != null) {
      this.bJ.addView(paramContext);
    }
    this.TO = ((TextView)paramContext.findViewById(2131380736));
    this.jf = ((LinearLayout)paramContext.findViewById(2131370208));
    this.t = new ImageView[4];
    this.r = new TextView[4];
    this.c = new LinearLayout[4];
    this.t[0] = ((ImageView)paramContext.findViewById(2131369024));
    this.r[0] = ((TextView)paramContext.findViewById(2131380730));
    this.c[0] = ((LinearLayout)paramContext.findViewById(2131370204));
    this.t[1] = ((ImageView)paramContext.findViewById(2131369025));
    this.r[1] = ((TextView)paramContext.findViewById(2131380731));
    this.c[1] = ((LinearLayout)paramContext.findViewById(2131370205));
    this.t[2] = ((ImageView)paramContext.findViewById(2131369026));
    this.r[2] = ((TextView)paramContext.findViewById(2131380732));
    this.c[2] = ((LinearLayout)paramContext.findViewById(2131370206));
    this.t[3] = ((ImageView)paramContext.findViewById(2131369027));
    this.r[3] = ((TextView)paramContext.findViewById(2131380733));
    this.c[3] = ((LinearLayout)paramContext.findViewById(2131370207));
  }
  
  public void a(FeedsItemData paramFeedsItemData)
  {
    super.a(paramFeedsItemData);
    this.TO.setText(paramFeedsItemData.title);
    int i;
    if ((paramFeedsItemData.giftList != null) && (paramFeedsItemData.giftList.size() > 0))
    {
      this.jf.setVisibility(0);
      i = 0;
      label45:
      if (i >= 4) {
        return;
      }
      if (i >= paramFeedsItemData.giftList.size()) {
        break label176;
      }
      this.c[i].setVisibility(0);
      FeedsItemData.Gift localGift = (FeedsItemData.Gift)paramFeedsItemData.giftList.get(i);
      this.r[i].setText(localGift.text);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = this.itemView.getResources().getDrawable(2130840068);
      localURLDrawableOptions.mFailedDrawable = this.itemView.getResources().getDrawable(2130840068);
      this.t[i].setImageDrawable(URLDrawable.getDrawable(localGift.picture, localURLDrawableOptions));
    }
    for (;;)
    {
      i += 1;
      break label45;
      this.jf.setVisibility(8);
      break;
      label176:
      this.c[i].setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahsg
 * JD-Core Version:    0.7.0.1
 */