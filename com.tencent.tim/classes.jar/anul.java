import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class anul
{
  public static View getView(Context paramContext, View paramView, wlz paramwlz, Bundle paramBundle)
  {
    paramwlz = paramContext.getResources();
    int i;
    label37:
    Object localObject;
    if (paramBundle.getInt("longMsgHolderType", -1) == 1)
    {
      i = 1;
      if ((paramView == null) || (!(paramView instanceof RelativeLayout))) {
        break label237;
      }
      ((RelativeLayout)paramView).removeAllViews();
      paramView = (RelativeLayout)paramView;
      paramView.setLayoutParams(new RelativeLayout.LayoutParams(-1, wja.dp2px(75.0F, paramwlz)));
      paramBundle = new RelativeLayout(paramContext);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      paramView.addView(paramBundle, (ViewGroup.LayoutParams)localObject);
      localObject = new ImageView(paramContext);
      paramContext = new TextView(paramContext);
      if (i == 0) {
        break label249;
      }
      ((ImageView)localObject).setImageResource(2130842519);
      paramContext.setText(paramwlz.getString(2131698661));
    }
    for (;;)
    {
      ((ImageView)localObject).setId(2131378848);
      ((ImageView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(wja.dp2px(23.5F, paramwlz), wja.dp2px(22.5F, paramwlz)));
      paramBundle.addView((View)localObject);
      paramContext.setTextSize(2, 14.0F);
      paramContext.setTextColor(Color.parseColor("#777777"));
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131378848);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = wja.dp2px(7.5F, paramwlz);
      paramBundle.addView(paramContext, (ViewGroup.LayoutParams)localObject);
      return paramView;
      i = 0;
      break;
      label237:
      paramView = new RelativeLayout(paramContext);
      break label37;
      label249:
      ((ImageView)localObject).setImageResource(2130842518);
      paramContext.setText(paramwlz.getString(2131698660));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anul
 * JD-Core Version:    0.7.0.1
 */