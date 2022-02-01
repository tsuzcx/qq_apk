import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class antp
  extends anqv
{
  private void a(Context paramContext, RelativeLayout paramRelativeLayout, Resources paramResources, antp.a parama)
  {
    paramContext = new ImageView(paramContext);
    paramContext.setImageResource(2130851401);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(9);
    localLayoutParams.leftMargin = wja.dp2px(239.0F, paramResources);
    localLayoutParams.topMargin = wja.dp2px(10.0F, paramResources);
    parama.DL = paramContext;
    paramContext.setVisibility(4);
    paramRelativeLayout.addView(paramContext, localLayoutParams);
  }
  
  private void b(Context paramContext, RelativeLayout paramRelativeLayout, Resources paramResources, antp.a parama)
  {
    paramContext = new TextView(paramContext);
    paramContext.setId(2131376828);
    paramContext.setTextColor(Color.parseColor("#777777"));
    paramContext.setTextSize(1, 14.0F);
    paramContext.setGravity(16);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, wja.dp2px(25.0F, paramResources));
    localLayoutParams.topMargin = wja.dp2px(83.0F, paramResources);
    localLayoutParams.leftMargin = wja.dp2px(30.0F, paramResources);
    parama.Rd = paramContext;
    paramRelativeLayout.addView(paramContext, localLayoutParams);
  }
  
  private void c(Context paramContext, RelativeLayout paramRelativeLayout, Resources paramResources, antp.a parama)
  {
    paramContext = new TextView(paramContext);
    paramContext.setId(2131376829);
    paramContext.setText(2131700651);
    paramContext.setTextSize(1, 22.0F);
    paramContext.setTextColor(-1);
    paramContext.setGravity(16);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, wja.dp2px(75.0F, paramResources));
    localLayoutParams.leftMargin = wja.dp2px(60.0F, paramResources);
    localLayoutParams.topMargin = wja.dp2px(8.0F, paramResources);
    parama.titleTv = paramContext;
    paramRelativeLayout.addView(paramContext, localLayoutParams);
  }
  
  protected int IX()
  {
    return 29;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    alte localalte = alte.a();
    Resources localResources = paramContext.getResources();
    int j;
    if (paramView == null)
    {
      paramBundle = new RelativeLayout(paramContext);
      paramView = new antp.a(null);
      paramBundle.setTag(-1, paramView);
      paramBundle.setId(2131376827);
      paramView.itemView = paramBundle;
      c(paramContext, paramBundle, localResources, paramView);
      b(paramContext, paramBundle, localResources, paramView);
      a(paramContext, paramBundle, localResources, paramView);
      j = 1;
      paramContext = paramBundle;
      if ((this.e != null) && (this.e.message != null)) {
        break label190;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructMsgItemLayout29", 2, "getView but parentMsg or message is null");
      }
      if (!QLog.isDebugVersion()) {
        break label384;
      }
      paramView = this.e;
      if (this.e != null) {
        break label179;
      }
    }
    label179:
    for (paramContext = "-";; paramContext = this.e.message)
    {
      throw new IllegalStateException(String.format("getView but parentMsg or message is null, %s / %s", new Object[] { paramView, paramContext }));
      paramContext = (RelativeLayout)paramView;
      paramView = (antp.a)paramContext.getTag(-1);
      j = 0;
      break;
    }
    label190:
    boolean bool = this.e.message.isSend();
    paramBundle = this.rz.iterator();
    int i = 0;
    if (paramBundle.hasNext())
    {
      anqu localanqu = (anqu)paramBundle.next();
      if ((!"type".equals(localanqu.mTypeName)) || (!(localanqu instanceof anve))) {
        break label447;
      }
      i = ((anve)localanqu).type;
    }
    label384:
    label447:
    for (;;)
    {
      break;
      if ((bool != paramView.bbe) || (i != paramView.msgType) || (j != 0))
      {
        paramContext.setBackgroundDrawable(new BitmapDrawable(localResources, localalte.a(localResources, bool, i)));
        paramView.bbe = bool;
        paramView.msgType = i;
      }
      if (bool)
      {
        paramView.Rd.setText(2131700650);
        paramView.DL.setVisibility(4);
      }
      for (;;)
      {
        if ((!bool) && (BaseApplicationImpl.sProcessId == 1))
        {
          paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          alte.a().k(paramView, this.e.message);
        }
        return paramContext;
        if ("1".equals(alte.u(this.e.message)))
        {
          paramView.Rd.setText(2131700648);
          paramView.DL.setVisibility(4);
        }
        else
        {
          paramView.Rd.setText(2131700649);
          paramView.DL.setVisibility(0);
        }
      }
    }
  }
  
  public String getName()
  {
    return "layout29";
  }
  
  static class a
    implements BaseBubbleBuilder.d
  {
    ImageView DL;
    TextView Rd;
    boolean bbe;
    View itemView;
    int msgType;
    TextView titleTv;
    
    private void Qu(boolean paramBoolean)
    {
      Drawable localDrawable = this.itemView.getBackground();
      if (localDrawable != null) {
        if (!paramBoolean) {
          break label28;
        }
      }
      label28:
      for (ColorFilter localColorFilter = null;; localColorFilter = BaseBubbleBuilder.d)
      {
        localDrawable.setColorFilter(localColorFilter);
        localDrawable.invalidateSelf();
        return;
      }
    }
    
    public void e(View paramView, MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      case 2: 
      default: 
      case 1: 
      case 3: 
        do
        {
          return;
          paramView = this.itemView.getBackground();
        } while (paramView == null);
        paramView.setColorFilter(null);
        paramView.invalidateSelf();
        return;
      }
      Qu(false);
    }
    
    public void v(View paramView, boolean paramBoolean)
    {
      Qu(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     antp
 * JD-Core Version:    0.7.0.1
 */