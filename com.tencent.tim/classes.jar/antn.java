import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class antn
  extends anqv
{
  static HashMap<Integer, ColorDrawable> nF = new HashMap();
  static ColorDrawable o = new ColorDrawable(Color.parseColor("#8C6CF5"));
  public int dMv = -1;
  AnimationDrawable t;
  
  protected int IX()
  {
    return 28;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject1 = null;
    View localView;
    antn.a locala;
    label223:
    Object localObject2;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramContext).inflate(2131560869, null);
      locala = new antn.a();
      locala.o = ((BubbleImageView)localView.findViewById(2131363410));
      locala.o.setRadius(13.0F);
      locala.imageView = ((ImageView)localView.findViewById(2131378684));
      locala.Zx = ((TextView)localView.findViewById(2131378580));
      locala.titleTv = ((TextView)localView.findViewById(2131379822));
      locala.DK = ((ImageView)localView.findViewById(2131378579));
      localView.setTag(this.dMv, locala);
      localView.setOnClickListener(this);
      paramBundle = (ColorDrawable)nF.get(Integer.valueOf(this.dMj));
      paramView = paramBundle;
      if (paramBundle == null)
      {
        paramView = paramBundle;
        if (this.dMj != 0)
        {
          paramView = new ColorDrawable(this.dMj);
          nF.put(Integer.valueOf(this.dMj), paramView);
        }
      }
      paramBundle = paramView;
      if (paramView == null) {
        paramBundle = o;
      }
      locala.o.setImageDrawable(paramBundle);
      Iterator localIterator = this.rz.iterator();
      paramView = null;
      paramBundle = (Bundle)localObject1;
      if (!localIterator.hasNext()) {
        break label512;
      }
      localObject1 = (anqu)localIterator.next();
      localObject2 = ((anqu)localObject1).mTypeName;
      if (!"title".equals(localObject2)) {
        break label346;
      }
      localObject2 = (StructMsgItemTitle)localObject1;
      locala.titleTv.setText(((StructMsgItemTitle)localObject2).text);
      label282:
      if (!TextUtils.isEmpty(paramView)) {
        break label608;
      }
      localObject1 = (StructMsgForGeneralShare)((anqu)localObject1).e;
      paramView = ((StructMsgForGeneralShare)localObject1).animResId;
      paramBundle = ((StructMsgForGeneralShare)localObject1).atMembers;
      locala.cim = String.valueOf(((StructMsgForGeneralShare)localObject1).uniseq);
    }
    label346:
    label608:
    for (;;)
    {
      for (;;)
      {
        break label223;
        locala = (antn.a)paramView.getTag(this.dMv);
        localView = paramView;
        break;
        if (!"picture".equals(localObject2)) {
          break label460;
        }
        localObject2 = ((ansr)localObject1).aNt;
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label282;
          }
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = ((int)aqho.convertDpToPixel(paramContext, 62.5F));
          localURLDrawableOptions.mRequestHeight = ((int)aqho.convertDpToPixel(paramContext, 115.0F));
          localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
          locala.imageView.setImageDrawable((Drawable)localObject2);
          locala.imageView.setVisibility(0);
        }
        catch (Exception localException)
        {
          QLog.e("Q.robot.StructMsg", 1, localException, new Object[0]);
          locala.imageView.setVisibility(4);
        }
      }
      break label282;
      if (!"voice".equals(localException)) {
        break label282;
      }
      anse localanse = (anse)localObject1;
      locala.Zx.setText(localanse.length + "\"");
      break label282;
      locala.resId = paramView;
      locala.cbb = paramBundle;
      if (apot.a().qG(locala.cim))
      {
        if (this.t == null) {
          this.t = ((AnimationDrawable)paramContext.getResources().getDrawable(2130844697));
        }
        locala.DK.setImageDrawable(this.t);
        if (!this.t.isRunning()) {
          this.t.start();
        }
        return localView;
      }
      locala.DK.setImageResource(2130844696);
      return localView;
    }
  }
  
  public String getName()
  {
    return "layout28";
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag(this.dMv);
    if ((localObject instanceof antn.a))
    {
      localObject = (antn.a)localObject;
      if (!TextUtils.isEmpty(((antn.a)localObject).resId)) {
        break label48;
      }
      QLog.e("Q.robot.StructMsg", 2, "onClick failed , resid empty!");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label48:
      String str1 = ((antn.a)localObject).resId;
      String str2 = ((antn.a)localObject).cim;
      apot localapot = apot.a();
      if (localapot.qF(((antn.a)localObject).resId)) {
        apot.a().bb(str2, ((antn.a)localObject).resId, ((antn.a)localObject).cbb);
      } else {
        localapot.a(((antn.a)localObject).resId, new anto(this, str2, str1, (antn.a)localObject));
      }
    }
  }
  
  class a
  {
    ImageView DK;
    TextView Zx;
    String cbb;
    String cim;
    ImageView imageView;
    BubbleImageView o;
    String resId;
    TextView titleTv;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     antn
 * JD-Core Version:    0.7.0.1
 */