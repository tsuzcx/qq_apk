import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;
import java.util.Iterator;

public class ansx
  extends anqv
{
  protected int IX()
  {
    return 11;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject4 = paramContext.getResources();
    float f;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof ansx.a)))
    {
      localObject1 = (ansx.a)paramView.getTag();
      localObject2 = this.rz.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (anqu)((Iterator)localObject2).next();
        ((anqu)localObject3).hU = this.hU;
        localObject4 = ((anqu)localObject3).mTypeName;
        if ("title".equals(localObject4))
        {
          localObject3 = (StructMsgItemTitle)localObject3;
          ((StructMsgItemTitle)localObject3).setTextColor("#ffffff");
          f = acej.aV() / 16.0F;
          if (f > 1.0F) {
            ((StructMsgItemTitle)localObject3).fK("" + (int)(36 / f));
          }
          for (;;)
          {
            ((StructMsgItemTitle)localObject3).a(paramContext, ((ansx.a)localObject1).yg, paramBundle);
            break;
            ((StructMsgItemTitle)localObject3).fK(String.valueOf(36));
          }
        }
        if ("pavideo".equals(localObject4)) {
          ((anqu)localObject3).a(paramContext, ((ansx.a)localObject1).EY, paramBundle);
        }
      }
      if ((localObject1 != null) && (((ansx.a)localObject1).yg != null)) {
        ((TextView)((ansx.a)localObject1).yg).setMaxLines(2);
      }
      return paramView;
    }
    Object localObject2 = new RelativeLayout(paramContext);
    int i = (int)((BaseChatItemLayout.widthPixels - wja.dp2px(46.0F, (Resources)localObject4)) / 1.8D) + wja.dp2px(30.0F, (Resources)localObject4);
    ((RelativeLayout)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, i));
    int j = wja.dp2px(15.0F, (Resources)localObject4);
    ((RelativeLayout)localObject2).setPadding(j, j, j, j);
    Object localObject3 = new ansx.a();
    Object localObject1 = null;
    paramView = null;
    Object localObject5 = this.rz.iterator();
    anqu localanqu;
    String str;
    if (((Iterator)localObject5).hasNext())
    {
      localanqu = (anqu)((Iterator)localObject5).next();
      localanqu.hU = this.hU;
      str = localanqu.mTypeName;
      if ("title".equals(str))
      {
        localObject1 = (StructMsgItemTitle)localanqu;
        ((StructMsgItemTitle)localObject1).setTextColor("#ffffff");
        f = acej.aV() / 16.0F;
        if (f > 1.0F)
        {
          ((StructMsgItemTitle)localObject1).fK("" + (int)(36 / f));
          label439:
          localObject1 = ((StructMsgItemTitle)localObject1).a(paramContext, null, paramBundle);
          ((View)localObject1).setId(1001);
        }
      }
    }
    for (;;)
    {
      break;
      ((StructMsgItemTitle)localObject1).fK(String.valueOf(36));
      break label439;
      if ("pavideo".equals(str))
      {
        paramView = localanqu.a(paramContext, null, paramBundle);
        paramView.setId(1003);
        continue;
        if (paramView != null) {
          ((RelativeLayout)localObject2).addView(paramView, new RelativeLayout.LayoutParams(-1, -1));
        }
        paramBundle = new View(paramContext);
        i = (int)(i * 0.32D);
        paramBundle.setBackgroundResource(2130842597);
        localObject5 = new RelativeLayout.LayoutParams(-1, i);
        ((RelativeLayout.LayoutParams)localObject5).addRule(12, -1);
        ((RelativeLayout)localObject2).addView(paramBundle, (ViewGroup.LayoutParams)localObject5);
        if (localObject1 != null)
        {
          paramBundle = new RelativeLayout.LayoutParams(-1, -2);
          paramBundle.addRule(12, -1);
          paramBundle.bottomMargin = wja.dp2px(11.5F, (Resources)localObject4);
          paramBundle.leftMargin = wja.dp2px(20.0F, (Resources)localObject4);
          paramBundle.rightMargin = wja.dp2px(20.0F, (Resources)localObject4);
          ((RelativeLayout)localObject2).addView((View)localObject1, paramBundle);
        }
        paramBundle = new RelativeLayout.LayoutParams(wja.dp2px(52.5F, (Resources)localObject4), wja.dp2px(52.5F, (Resources)localObject4));
        paramBundle.addRule(15, -1);
        paramContext = new ImageView(paramContext);
        paramContext.setImageResource(2130842527);
        paramContext.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        paramBundle.addRule(14, -1);
        ((RelativeLayout)localObject2).addView(paramContext, paramBundle);
        if (paramView != null) {
          ((ansx.a)localObject3).EY = paramView;
        }
        if (localObject1 != null)
        {
          ((ansx.a)localObject3).yg = ((View)localObject1);
          ((TextView)((ansx.a)localObject3).yg).setMaxLines(1);
        }
        ((RelativeLayout)localObject2).setTag(localObject3);
        return localObject2;
      }
    }
  }
  
  public String getName()
  {
    return "Layout11";
  }
  
  static class a
  {
    View EY;
    View yg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ansx
 * JD-Core Version:    0.7.0.1
 */