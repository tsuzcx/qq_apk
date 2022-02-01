package com.tencent.mobileqq.activity.contacts.friend;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.widget.SingleLineTextView;
import java.util.HashMap;
import java.util.Map;
import zap.a;

public class FriendItemLayout
  extends FrameLayout
{
  private static int ccu;
  private static Map<CharSequence, Integer> ig = new HashMap(5);
  private zap.a a;
  
  public FriendItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FriendItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void cnA()
  {
    int j = ((FrameLayout.LayoutParams)this.a.d.getLayoutParams()).leftMargin;
    int i = j;
    Object localObject;
    if (this.a.d.getVisibility() != 8)
    {
      localObject = this.a.d.getText();
      if (ig.containsKey(localObject))
      {
        i = ((Integer)ig.get(localObject)).intValue();
        this.a.d.setFixedWidth(i);
        i = i + ccu + j;
      }
    }
    else
    {
      j = i;
      if (this.a.a != null)
      {
        j = i;
        if (this.a.a.getVisibility() != 8)
        {
          localObject = this.a.a.t();
          if (!ig.containsKey(localObject)) {
            break label414;
          }
          j = ((Integer)ig.get(localObject)).intValue();
        }
      }
    }
    for (;;)
    {
      j = i + (j + ccu);
      i = j;
      if (this.a.uL.getVisibility() != 8)
      {
        localObject = (FrameLayout.LayoutParams)this.a.uL.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).leftMargin = j;
        i = j + (((FrameLayout.LayoutParams)localObject).width + ccu);
      }
      j = i;
      if (this.a.uN.getVisibility() != 8)
      {
        localObject = (FrameLayout.LayoutParams)this.a.uN.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).leftMargin = i;
        j = i + (((FrameLayout.LayoutParams)localObject).width + ccu);
      }
      i = j;
      if (this.a.ay.getVisibility() != 8)
      {
        localObject = (FrameLayout.LayoutParams)this.a.ay.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).leftMargin = j;
        i = j + (((FrameLayout.LayoutParams)localObject).width + ccu);
      }
      ((FrameLayout.LayoutParams)this.a.m.getLayoutParams()).leftMargin = i;
      i = getContext().getResources().getDimensionPixelSize(2131296995);
      i = this.a.b.a(this, this.a, i);
      ((FrameLayout.LayoutParams)this.a.hE.getLayoutParams()).rightMargin = i;
      return;
      i = (int)this.a.d.j().measureText((CharSequence)localObject, 0, ((CharSequence)localObject).length());
      ig.put(localObject, Integer.valueOf(i));
      break;
      label414:
      j = this.a.a.He();
      ig.put(localObject, Integer.valueOf(j));
    }
  }
  
  public zap.a a()
  {
    this.a = new zap.a();
    this.a.pQ = ((ImageView)findViewById(2131368698));
    this.a.xp = ((ImageView)findViewById(2131369830));
    this.a.l = ((SingleLineTextView)findViewById(2131379402));
    this.a.d = ((SimpleTextView)findViewById(2131380833));
    this.a.uL = ((ImageView)findViewById(2131369910));
    this.a.uN = ((ImageView)findViewById(2131369862));
    this.a.ay = ((URLImageView)findViewById(2131369864));
    this.a.m = ((SingleLineTextView)findViewById(2131379404));
    this.a.uO = ((ImageView)findViewById(2131369920));
    this.a.b = ((MutualMarkIconsView)findViewById(2131372138));
    this.a.az = ((URLImageView)findViewById(2131369790));
    this.a.hE = ((LinearLayout)findViewById(2131372363));
    this.a.a = ((OnlineStatusView)findViewById(2131366592));
    this.a.m.setExtendTextColor(RichStatus.sActionColor, 1);
    this.a.m.setExtendTextSize(12.0F, 1);
    this.a.m.setGravity(19);
    if (this.a.a != null) {
      this.a.a.setViewStyle(2);
    }
    if (ccu == 0) {
      ccu = getContext().getResources().getDimensionPixelSize(2131297003);
    }
    return this.a;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    cnA();
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.FriendItemLayout
 * JD-Core Version:    0.7.0.1
 */