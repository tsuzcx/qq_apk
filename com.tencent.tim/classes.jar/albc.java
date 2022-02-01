import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;

public class albc
  extends akbp
{
  FriendProfilePicBrowserActivity b;
  
  public albc(FriendProfilePicBrowserActivity paramFriendProfilePicBrowserActivity, sxm paramsxm)
  {
    super(paramFriendProfilePicBrowserActivity, paramsxm);
    this.b = paramFriendProfilePicBrowserActivity;
  }
  
  protected void RK(int paramInt)
  {
    if (this.b != null) {
      this.b.Qq();
    }
  }
  
  public PicInfo a()
  {
    PicInfo localPicInfo = null;
    if (this.jdField_a_of_type_Akbt.a() != null) {
      localPicInfo = this.jdField_a_of_type_Akbt.a().a;
    }
    return localPicInfo;
  }
  
  protected RelativeLayout createLayout()
  {
    return (RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131561610, null);
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_Akbo != null) {
      this.jdField_a_of_type_Akbo.a(null);
    }
    this.b = null;
  }
  
  public int getSelectedIndex()
  {
    if (this.jdField_a_of_type_Akbt != null) {
      return this.jdField_a_of_type_Akbt.getSelectedIndex();
    }
    return -1;
  }
  
  public boolean needShowPageView()
  {
    return false;
  }
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    super.onCreate(paramViewGroup);
    if (this.jdField_a_of_type_Akbo != null) {
      this.jdField_a_of_type_Akbo.a(this.b);
    }
  }
  
  public void onExitAnimationStart()
  {
    super.onExitAnimationStart();
    if (this.b != null) {
      this.b.bPt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     albc
 * JD-Core Version:    0.7.0.1
 */