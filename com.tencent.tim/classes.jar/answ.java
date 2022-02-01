import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;
import java.util.Iterator;

public class answ
  extends anqv
{
  private void a(Context paramContext, View paramView, answ.a parama, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      paramContext = paramContext.getResources();
      if (parama.Ht != null)
      {
        paramBundle = new RelativeLayout.LayoutParams(-1, -1);
        parama.Ht.setId(2131363083);
        paramBundle.addRule(9, -1);
        ((RelativeLayout)paramView).addView(parama.Ht);
      }
      if (parama.yg != null)
      {
        paramBundle = new RelativeLayout.LayoutParams(-1, -2);
        paramBundle.addRule(9);
        if (acej.aV() <= 16.0F) {
          break label146;
        }
      }
    }
    label146:
    for (int i = wja.dp2px(5.0F, paramContext);; i = wja.dp2px(10.0F, paramContext))
    {
      paramBundle.setMargins(wja.dp2px(20.0F, paramContext), 0, wja.dp2px(20.0F, paramContext), i);
      paramBundle.addRule(12);
      ((RelativeLayout)paramView).addView(parama.yg, paramBundle);
      return;
    }
  }
  
  protected int IX()
  {
    return 10;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    answ.a locala;
    Object localObject1;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof answ.a)))
    {
      locala = (answ.a)paramView.getTag();
      localObject1 = this.rz.iterator();
    }
    for (;;)
    {
      anqu localanqu;
      Object localObject2;
      String str;
      int j;
      int i;
      if (((Iterator)localObject1).hasNext())
      {
        localanqu = (anqu)((Iterator)localObject1).next();
        localanqu.hU = this.hU;
        localObject2 = localanqu.mTypeName;
        if ("title".equals(localObject2))
        {
          localObject2 = (StructMsgItemTitle)localanqu;
          str = ((StructMsgItemTitle)localObject2).As();
          j = ((StructMsgItemTitle)localObject2).Kq();
          i = j;
          if (TextUtils.isEmpty(str)) {}
        }
      }
      try
      {
        i = Integer.parseInt(str);
        f = acej.aV() / 16.0F;
        if (i * f > 36.0F) {
          ((StructMsgItemTitle)localObject2).fK("" + (int)(36.0F / f));
        }
        for (;;)
        {
          locala.yg = localanqu.a(paramContext, locala.yg, paramBundle);
          break;
          ((StructMsgItemTitle)localObject2).fK(str);
        }
        if (!"paaudio".equals(localObject2)) {
          continue;
        }
        locala.Ht = localanqu.a(paramContext, locala.Ht, paramBundle);
        continue;
        paramContext = locala;
        if (paramContext.yg != null) {
          ((TextView)paramContext.yg).setMaxLines(1);
        }
        paramView.setTag(paramContext);
        return paramView;
        localObject1 = paramContext.getResources();
        locala = new answ.a();
        paramView = new RelativeLayout(paramContext);
        i = wja.dp2px(15.0F, (Resources)localObject1);
        paramView.setPadding(i, i, i, i);
        i = (int)((BaseChatItemLayout.widthPixels - wja.dp2px(46.0F, (Resources)localObject1)) * 26.0F / 63.0F);
        paramView.setLayoutParams(new RelativeLayout.LayoutParams(-1, wja.dp2px(30.0F, (Resources)localObject1) + i));
        localObject1 = this.rz.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localanqu = (anqu)((Iterator)localObject1).next();
          localanqu.hU = this.hU;
          localObject2 = localanqu.mTypeName;
          if ("title".equals(localObject2))
          {
            localObject2 = (StructMsgItemTitle)localanqu;
            str = ((StructMsgItemTitle)localObject2).As();
            j = ((StructMsgItemTitle)localObject2).Kq();
            i = j;
            if (TextUtils.isEmpty(str)) {}
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt(str);
            float f = acej.aV() / 16.0F;
            if (i * f > 36.0F) {
              ((StructMsgItemTitle)localObject2).fK("" + (int)(36.0F / f));
            }
            for (;;)
            {
              locala.yg = localanqu.a(paramContext, locala.yg, paramBundle);
              break;
              ((StructMsgItemTitle)localObject2).fK(str);
            }
            if ("paaudio".equals(localObject2))
            {
              locala.Ht = localanqu.a(paramContext, locala.Ht, paramBundle);
              continue;
              a(paramContext, paramView, locala, paramBundle);
              paramContext = locala;
            }
          }
          localException1 = localException1;
          i = j;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            i = j;
          }
        }
      }
    }
  }
  
  public String getName()
  {
    return "Layout10";
  }
  
  public static class a
  {
    public View Ht;
    public View yg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     answ
 * JD-Core Version:    0.7.0.1
 */