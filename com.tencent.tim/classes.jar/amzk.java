import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeURLImageView;

public class amzk
  implements amxy
{
  protected TextView Bj;
  protected ImageView DF;
  protected View Hp;
  protected View Hq;
  protected TextView Zu;
  public int acL;
  protected ImageView imageView;
  protected TextView tD;
  protected TextView titleView;
  protected View view;
  
  protected amzk() {}
  
  public amzk(View paramView)
  {
    this.view = paramView;
    aDR();
  }
  
  public amzk(ViewGroup paramViewGroup, int paramInt)
  {
    this.acL = paramInt;
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    if (lr(paramInt)) {}
    for (this.view = localLayoutInflater.inflate(paramInt, null, false);; this.view = localLayoutInflater.inflate(paramInt, paramViewGroup, false))
    {
      aDR();
      return;
    }
  }
  
  public TextView N()
  {
    return this.Bj;
  }
  
  public TextView O()
  {
    return this.Zu;
  }
  
  public View P(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.view;
    }
    return this.view.findViewById(2131377855);
  }
  
  protected void aDR()
  {
    View localView = this.view.findViewById(2131379769);
    if (localView != null)
    {
      this.titleView = ((TextView)localView);
      this.titleView.setEditableFactory(aofr.a);
    }
    localView = this.view.findViewById(2131378922);
    if (localView != null) {
      this.tD = ((TextView)localView);
    }
    localView = this.view.findViewById(2131365748);
    if (localView != null) {
      this.Bj = ((TextView)localView);
    }
    localView = this.view.findViewById(2131367065);
    if (localView != null) {
      this.Zu = ((TextView)localView);
    }
    localView = this.view.findViewById(2131368820);
    if (localView != null) {
      this.imageView = ((ImageView)localView);
    }
    if ((this.imageView instanceof ThemeImageView)) {
      ((ThemeImageView)this.imageView).setSupportMaskView(false);
    }
    for (;;)
    {
      localView = this.view.findViewById(2131377282);
      if (localView != null) {
        this.DF = ((ImageView)localView);
      }
      this.Hp = this.view.findViewById(2131366004);
      this.Hq = this.view.findViewById(2131377295);
      refreshView();
      return;
      if ((this.imageView instanceof ThemeURLImageView)) {
        ((ThemeURLImageView)this.imageView).setSupportMaskView(false);
      }
    }
  }
  
  public View g(String paramString)
  {
    return null;
  }
  
  public TextView getTitleView()
  {
    return this.titleView;
  }
  
  public View getView()
  {
    return this.view;
  }
  
  public boolean lr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  public void refreshView()
  {
    if (lr(this.acL)) {}
  }
  
  public ImageView v()
  {
    return this.DF;
  }
  
  public ImageView w()
  {
    return this.imageView;
  }
  
  public TextView z()
  {
    return this.tD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amzk
 * JD-Core Version:    0.7.0.1
 */