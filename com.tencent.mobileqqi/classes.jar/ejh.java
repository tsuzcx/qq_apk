import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.contact.newfriend.BaseNewFriendView.INewFriendContext;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;

public class ejh
  implements BaseNewFriendView.INewFriendContext
{
  public ejh(NewFriendActivity paramNewFriendActivity) {}
  
  public Activity a()
  {
    return this.a;
  }
  
  public View a()
  {
    return this.a.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public QQAppInterface a()
  {
    return this.a.b;
  }
  
  public void a()
  {
    NewFriendActivity.b(this.a);
  }
  
  public void a(int paramInt, View.OnClickListener paramOnClickListener) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      paramInt = -1;
    }
    for (;;)
    {
      if (paramInt != -1) {
        NewFriendActivity.a(this.a).a(paramInt).a(paramBoolean);
      }
      return;
      paramInt = 1;
      continue;
      paramInt = 0;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    QQToast.a(a(), paramInt, paramString, 0).b(this.a.d());
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = NewFriendActivity.a(this.a);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public View b()
  {
    return this.a.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void b()
  {
    NewFriendActivity.a(this.a);
  }
  
  public View c()
  {
    return NewFriendActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ejh
 * JD-Core Version:    0.7.0.1
 */