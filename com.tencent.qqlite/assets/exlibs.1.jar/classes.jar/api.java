import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.FriendProfileImageModel;
import com.tencent.mobileqq.activity.FriendProfileImageModel.InfoUpdateListener;
import com.tencent.mobileqq.activity.FriendProfileImageModel.ProfileImageInfo;
import com.tencent.mobileqq.adapter.FriendProfileImageAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;

public class api
  implements FriendProfileImageModel.InfoUpdateListener
{
  public api(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void a()
  {
    FriendProfileImageActivity localFriendProfileImageActivity = this.a;
    localFriendProfileImageActivity.b += 1;
  }
  
  public void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    this.a.c(paramProfileImageInfo);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "onDeleteSuccess()");
    }
    this.a.b();
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a() != 0)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterFriendProfileImageAdapter.notifyDataSetChanged();
      return;
    }
    this.a.finish();
  }
  
  public void b(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    this.a.c(paramProfileImageInfo);
    this.a.a(2131363949, 1);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "onDeleteFailed()");
    }
    this.a.b();
    this.a.jdField_a_of_type_ComTencentWidgetGallery.postDelayed(new apj(this), 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     api
 * JD-Core Version:    0.7.0.1
 */