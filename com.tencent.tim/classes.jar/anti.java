import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public class anti
  extends anqv
{
  protected int IX()
  {
    return 24;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    int i = 0;
    Object localObject1;
    anti.a locala;
    if ((paramView != null) && ((paramView.getTag() instanceof anti.a)))
    {
      localObject1 = (RelativeLayout)paramView;
      ((RelativeLayout)localObject1).removeAllViews();
      locala = (anti.a)paramView.getTag();
      locala.reset();
      paramView = (View)localObject1;
    }
    try
    {
      localObject1 = this.rz.iterator();
      label54:
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (anqu)((Iterator)localObject1).next();
        if ("picture".equals(((anqu)localObject2).mTypeName))
        {
          localObject2 = ((ansr)localObject2).a(paramContext, locala.Hw, true, paramBundle);
          i = wja.dp2px(30.0F, paramContext.getResources());
          paramView.addView((View)localObject2, new RelativeLayout.LayoutParams(i, i));
          locala.Hw = ((View)localObject2);
          ((View)localObject2).setVisibility(0);
          i = 1;
        }
        for (;;)
        {
          break label54;
          paramView = new RelativeLayout(paramContext);
          paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          int j = wja.dp2px(10.0F, paramContext.getResources());
          int k = wja.dp2px(13.0F, paramContext.getResources());
          paramView.setPadding(k, j, k, wja.dp2px(11.0F, paramContext.getResources()));
          locala = new anti.a(null);
          break;
          if ("title".equals(((anqu)localObject2).mTypeName))
          {
            localObject2 = (TextView)((anqu)localObject2).a(paramContext, locala.title, paramBundle);
            ((TextView)localObject2).setGravity(16);
            paramView.addView((View)localObject2, new RelativeLayout.LayoutParams(-2, wja.dp2px(30.0F, paramContext.getResources())));
            locala.title = ((TextView)localObject2);
            ((TextView)localObject2).setVisibility(0);
          }
          else if ("summary".equals(((anqu)localObject2).mTypeName))
          {
            ((anux)localObject2).setMaxLines(2147483647);
            localObject2 = (TextView)((anqu)localObject2).a(paramContext, locala.summary, paramBundle);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
            localLayoutParams.topMargin = wja.dp2px(34.0F, paramContext.getResources());
            localLayoutParams.bottomMargin = wja.dp2px(3.0F, paramContext.getResources());
            paramView.addView((View)localObject2, localLayoutParams);
            locala.summary = ((TextView)localObject2);
            ((TextView)localObject2).setVisibility(0);
          }
        }
      }
      if ((i != 0) && (locala.title != null)) {
        ((RelativeLayout.LayoutParams)locala.title.getLayoutParams()).leftMargin = wja.dp2px(38.0F, paramContext.getResources());
      }
      paramView.setTag(locala);
      return paramView;
    }
    catch (Exception paramContext) {}
    return paramView;
  }
  
  public String getName()
  {
    return "layout24";
  }
  
  static class a
  {
    public View Hw;
    public TextView summary;
    public TextView title;
    
    public void reset()
    {
      if (this.Hw != null) {
        this.Hw.setVisibility(8);
      }
      if (this.title != null) {
        this.title.setVisibility(8);
      }
      if (this.summary != null) {
        this.summary.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anti
 * JD-Core Version:    0.7.0.1
 */