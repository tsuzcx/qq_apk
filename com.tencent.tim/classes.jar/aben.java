import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;

public class aben
  extends BaseAdapter
  implements Handler.Callback
{
  vbi a;
  boolean bCd = false;
  Drawable ep;
  Drawable eq;
  MqqHandler g;
  Context mContext;
  int minSize;
  
  public aben(Context paramContext)
  {
    this.mContext = paramContext;
    this.minSize = ((int)this.mContext.getResources().getDimension(2131297899));
    this.ep = paramContext.getResources().getDrawable(2130851853);
    this.eq = paramContext.getResources().getDrawable(2130851854);
    this.g = new aqgw(Looper.getMainLooper(), this);
  }
  
  public void Dw(boolean paramBoolean)
  {
    this.bCd = paramBoolean;
  }
  
  public void a(vbi.b paramb, View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      gh(paramView);
      paramView.setTag(paramb.thumbnail);
      paramb = (ImageView)paramView.findViewById(2131368820);
    } while (paramb == null);
    paramb.setImageDrawable(this.ep);
  }
  
  public void a(vbi paramvbi)
  {
    this.a = paramvbi;
  }
  
  public void b(ImageProgressCircle paramImageProgressCircle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "showProgress() progressCircle = " + paramImageProgressCircle);
    }
    if (paramImageProgressCircle == null) {}
    while (this.g.hasMessages(1, paramImageProgressCircle)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramImageProgressCircle;
    this.g.sendMessageDelayed(localMessage, 550L);
  }
  
  public void b(vbi.b paramb, View paramView)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "loadThumbImage() path = " + paramb.thumbnail);
    }
    try
    {
      URL localURL = new URL("profile_img_thumb", null, paramb.thumbnail);
      if (this.a != null) {
        localObject1 = this.a.am();
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.eq;
      }
      localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject2, this.ep);
      paramView.setTag(paramb.thumbnail);
      ((ImageView)paramView.findViewById(2131368820)).setImageDrawable((Drawable)localObject1);
      return;
    }
    catch (MalformedURLException paramb)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.PhotoWall", 2, paramb.toString());
    }
  }
  
  public void c(vbi.b paramb, View paramView)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "loadBigImage() path = " + paramb.filePath);
    }
    if (paramView == null) {
      return;
    }
    URL localURL;
    for (;;)
    {
      try
      {
        gh(paramView);
        localObject1 = URLDrawable.getDrawable(new URL("profile_img_thumb", null, paramb.thumbnail));
        localURL = new URL("profile_img_big_fhd", null, paramb.filePath);
        if (((URLDrawable)localObject1).getStatus() == 1)
        {
          if (i == 0) {
            break label164;
          }
          localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject1, this.ep);
          paramView.setTag(paramb.filePath);
          paramb = (ImageView)paramView.findViewById(2131368820);
          if (paramb == null) {
            break;
          }
          paramb.setImageDrawable((Drawable)localObject1);
          return;
        }
      }
      catch (MalformedURLException paramb)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.PhotoWall", 2, paramb.toString());
        }
        paramView.setTag(null);
        return;
      }
      i = 0;
    }
    label164:
    if (this.a != null) {}
    for (Object localObject1 = this.a.am();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.eq;
      }
      localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject2, this.ep);
      break;
    }
  }
  
  public void destroy()
  {
    this.g.removeMessages(1);
  }
  
  public int getCount()
  {
    if (this.a != null) {
      return this.a.getCount();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.a != null) {
      return this.a.a(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = paramView;
    View localView;
    ImageView localImageView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559434, null);
      paramView = (ImageProgressCircle)localView.findViewById(2131368926);
      paramView.setVisibility(4);
      localImageView = (ImageView)localView.findViewById(2131368820);
      localImageView.setMinimumWidth(this.minSize);
      localImageView.setMinimumHeight(this.minSize);
      localObject = (vbi.b)getItem(paramInt);
      if (localObject != null)
      {
        if (!this.bCd) {
          break label177;
        }
        localObject = this.a.app.a(this.a.toUin, (byte)1, false, false);
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = aqhu.aV();
        }
        localImageView.setImageDrawable(paramView);
      }
    }
    for (;;)
    {
      localObject = localView;
      if (AppSetting.enableTalkBack)
      {
        localImageView.setContentDescription(this.mContext.getString(2131692186));
        localObject = localView;
      }
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
      return localObject;
      label177:
      if (((vbi.b)localObject).state == 6)
      {
        c((vbi.b)localObject, localView);
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.PhotoWall", 2, paramInt + "," + ((vbi.b)localObject).filePath);
        }
      }
      else if ((((vbi.b)localObject).state == 3) || (((vbi.b)localObject).state == 4))
      {
        b((vbi.b)localObject, localView);
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.PhotoWall", 2, "thumb: " + paramInt + "," + ((vbi.b)localObject).thumbnail);
        }
        if (((vbi.b)localObject).showProgress) {
          b(paramView);
        }
      }
      else
      {
        localImageView.setImageResource(2130851854);
      }
    }
  }
  
  public void gh(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
        paramView = (ImageProgressCircle)paramView.findViewById(2131368926);
      } while (paramView == null);
      this.g.removeMessages(1, paramView);
    } while (paramView.getVisibility() == 4);
    paramView.setVisibility(4);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && ((paramMessage.obj instanceof ImageProgressCircle)))
    {
      paramMessage = (ImageProgressCircle)paramMessage.obj;
      if (paramMessage.getVisibility() != 0) {
        paramMessage.setVisibility(0);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aben
 * JD-Core Version:    0.7.0.1
 */