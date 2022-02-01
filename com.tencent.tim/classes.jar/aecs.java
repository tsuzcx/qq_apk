import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.list.DefaultItemBuilder.1;
import com.tencent.mobileqq.dinifly.Cancellable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class aecs
  implements aecu
{
  private Cancellable a;
  
  private void a(aeci.d paramd)
  {
    if ((paramd == null) || (paramd.drawable == null))
    {
      QLog.e("DefaultItemBuilder", 1, "lottie loaded but still null");
      return;
    }
    QLog.d("DefaultItemBuilder", 4, "play animation");
    LottieDrawable localLottieDrawable = (LottieDrawable)paramd.drawable;
    localLottieDrawable.setRepeatCount(-1);
    localLottieDrawable.playAnimation();
    int i = wja.dp2px(24.0F, paramd.title.getResources());
    localLottieDrawable.setBounds(new Rect(0, 0, i, i));
    paramd.title.setCompoundDrawablesWithIntrinsicBounds(null, null, paramd.drawable, null);
  }
  
  private void a(Context paramContext, aeci.d paramd, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramd.drawable instanceof aebj))
    {
      if (!paramBoolean) {
        a(paramd);
      }
      return;
    }
    ThreadManagerV2.excute(new DefaultItemBuilder.1(this, paramString1, paramContext, paramString2, paramd, paramBoolean), 16, null, true);
  }
  
  protected int a(ColorNote paramColorNote)
  {
    int i = 2130840645;
    switch (aebs.gV(paramColorNote.getServiceType()) & 0xFFFF0000)
    {
    default: 
      i = 2130845244;
    case 17170432: 
    case 17235968: 
      return i;
    case 16973824: 
      return 2130845188;
    case 17039360: 
      return 2130839453;
    case 16842752: 
      return 2130839454;
    case 16908288: 
      return 2130839455;
    }
    return 2130844988;
  }
  
  public int a(ColorNote paramColorNote, boolean paramBoolean)
  {
    int i;
    switch (paramColorNote.getServiceType() & 0xFFFF0000)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      if (aebs.h(paramColorNote))
      {
        if (!paramBoolean) {
          break;
        }
        i = 2130839474;
      }
      return i;
      if (paramBoolean)
      {
        i = 2130839466;
      }
      else
      {
        i = 2130839467;
        continue;
        if (paramBoolean)
        {
          i = 2130839460;
        }
        else
        {
          i = 2130839461;
          continue;
          if (paramBoolean)
          {
            i = 2130839463;
          }
          else
          {
            i = 2130839464;
            continue;
            if (paramBoolean)
            {
              i = 2130839472;
            }
            else
            {
              i = 2130839473;
              continue;
              if (paramBoolean)
              {
                i = 2130839469;
              }
              else
              {
                i = 2130839470;
                continue;
                if (paramBoolean) {
                  i = 2130839476;
                } else {
                  i = 2130839477;
                }
              }
            }
          }
        }
      }
    }
    return 2130839475;
  }
  
  public void a(aeci.d paramd, int paramInt, boolean paramBoolean)
  {
    localColorNote = paramd.a(paramInt);
    localResources = paramd.yq.getContext().getResources();
    paramInt = a(localColorNote);
    for (;;)
    {
      try
      {
        localObject1 = new URL(localColorNote.getPicUrl());
        bool = "resdrawable".equals(((URL)localObject1).getProtocol());
        if (!bool) {
          continue;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Object localObject1;
        boolean bool;
        URLDrawable.URLDrawableOptions localURLDrawableOptions;
        localObject2 = localResources.getDrawable(paramInt);
        QLog.e("DefaultItemBuilder", 1, localMalformedURLException, new Object[0]);
        continue;
      }
      catch (NullPointerException localNullPointerException)
      {
        Object localObject2 = localResources.getDrawable(paramInt);
        QLog.e("DefaultItemBuilder", 1, localNullPointerException, new Object[0]);
        continue;
        paramd.title.setCompoundDrawablesWithIntrinsicBounds(null, null, paramd.drawable, null);
        ((aebi)paramd.drawable).start(300);
        localObject2 = paramd.container;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839466;
        ((View)localObject2).setBackgroundResource(paramInt);
        paramd.Bs.setBackgroundResource(2130839480);
        continue;
        paramInt = 2130839467;
        continue;
        paramd.title.setCompoundDrawables(null, null, null, null);
        localObject2 = paramd.container;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839460;
        ((View)localObject2).setBackgroundResource(paramInt);
        paramd.Bs.setBackgroundResource(2130839478);
        continue;
        paramInt = 2130839461;
        continue;
        paramd.title.setCompoundDrawables(null, null, null, null);
        localObject2 = paramd.container;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839463;
        ((View)localObject2).setBackgroundResource(paramInt);
        paramd.Bs.setBackgroundResource(2130839479);
        continue;
        paramInt = 2130839464;
        continue;
        paramd.title.setCompoundDrawables(null, null, null, null);
        localObject2 = paramd.container;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839472;
        ((View)localObject2).setBackgroundResource(paramInt);
        paramd.Bs.setBackgroundResource(2130839482);
        continue;
        paramInt = 2130839473;
        continue;
        paramd.title.setCompoundDrawables(null, null, null, null);
        localObject2 = paramd.container;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839469;
        ((View)localObject2).setBackgroundResource(paramInt);
        paramd.Bs.setBackgroundResource(2130839481);
        continue;
        paramInt = 2130839470;
        continue;
        localObject2 = paramd.container;
        if (!paramBoolean) {
          continue;
        }
        paramInt = 2130839476;
        ((View)localObject2).setBackgroundResource(paramInt);
        paramd.Bs.setBackgroundResource(2130839484);
        if (!aebs.i(localColorNote)) {
          continue;
        }
        a(paramd.yq.getContext(), paramd, "colornote/data_black.json", "colornote/images", false);
        continue;
        paramInt = 2130839477;
        continue;
        paramd.title.setCompoundDrawables(null, null, null, null);
        continue;
        paramInt = 2130839475;
        continue;
      }
      try
      {
        localObject1 = localResources.getDrawable(Integer.parseInt(((URL)localObject1).getHost()));
        paramd.yq.setImageDrawable((Drawable)localObject1);
        bool = aebs.h(localColorNote);
        switch (aebs.gV(localColorNote.getServiceType() & 0xFFFF0000))
        {
        default: 
          paramd.title.setCompoundDrawables(null, null, null, null);
          if (bool)
          {
            localObject1 = paramd.container;
            if (!paramBoolean) {
              continue;
            }
            paramInt = 2130839474;
            ((View)localObject1).setBackgroundResource(paramInt);
          }
          paramd.title.setText(localColorNote.getMainTitle());
          paramd.xW.setText(localColorNote.getSubTitle());
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localObject2 = localResources.getDrawable(paramInt);
        continue;
      }
      if ("uindrawable".equals(((URL)localObject2).getProtocol()))
      {
        localObject2 = aecx.n(((URL)localObject2).getQuery());
      }
      else
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = wja.dp2px(40.0F, localResources);
        localURLDrawableOptions.mRequestHeight = wja.dp2px(40.0F, localResources);
        localURLDrawableOptions.mLoadingDrawable = localResources.getDrawable(paramInt);
        localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
        localObject2 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
      }
    }
  }
  
  public void a(ColorNote paramColorNote, View paramView, ImageView paramImageView, boolean paramBoolean)
  {
    i = a(paramColorNote, paramBoolean);
    if (i != 0) {
      paramView.setBackgroundResource(i);
    }
    paramView = paramView.getContext().getResources();
    i = a(paramColorNote);
    for (;;)
    {
      try
      {
        paramColorNote = new URL(paramColorNote.getPicUrl());
        paramBoolean = "resdrawable".equals(paramColorNote.getProtocol());
        if (!paramBoolean) {
          continue;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions;
        paramColorNote = paramView.getDrawable(i);
        QLog.e("DefaultItemBuilder", 1, localMalformedURLException, new Object[0]);
        continue;
      }
      catch (NullPointerException localNullPointerException)
      {
        paramColorNote = paramView.getDrawable(i);
        QLog.e("DefaultItemBuilder", 1, localNullPointerException, new Object[0]);
        continue;
      }
      try
      {
        paramColorNote = paramView.getDrawable(Integer.parseInt(paramColorNote.getHost()));
        paramImageView.setImageDrawable(paramColorNote);
        return;
      }
      catch (NumberFormatException paramColorNote)
      {
        paramColorNote = paramView.getDrawable(i);
        continue;
      }
      if ("uindrawable".equals(paramColorNote.getProtocol()))
      {
        paramColorNote = aecx.n(paramColorNote.getQuery());
      }
      else
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = wja.dp2px(40.0F, paramView);
        localURLDrawableOptions.mRequestHeight = wja.dp2px(40.0F, paramView);
        localURLDrawableOptions.mLoadingDrawable = paramView.getDrawable(i);
        localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
        paramColorNote = URLDrawable.getDrawable(paramColorNote, localURLDrawableOptions);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aecs
 * JD-Core Version:    0.7.0.1
 */