import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ahid
  extends ahgq
{
  public ahid(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public List<RecentUser> aD(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!aqft.ri(localRecentUser.uin)) && (localRecentUser.getType() != 1020) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 1001) && (localRecentUser.getType() != 10002) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 1022) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && ((localRecentUser.getType() != 1) || (!kj(localRecentUser.uin))) && ((localRecentUser.getType() != 1006) || (e(ahgg.a.Y))) && (localRecentUser.getType() != 9501) && (localRecentUser.getType() != 8001) && ((localRecentUser.getType() != 0) || (!jqs.d(this.app, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.cgP))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected boolean anl()
  {
    boolean bool1 = this.bf.getBoolean("isFromFavorite", false);
    boolean bool2 = this.mIntent.getBooleanExtra("isFromFavorites", false);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardMapOption realForwardTo isFromFavorite=" + bool1 + "isFromFav=" + bool2);
    }
    Intent localIntent = new Intent(this.mActivity, SplashActivity.class);
    localIntent.putExtras(this.bf);
    if ((bool1) || (bool2))
    {
      ForwardUtils.a(this.app, this.mActivity, this.mAppContext, localIntent, null);
      this.mActivity.setResult(-1, localIntent);
      this.mActivity.finish();
    }
    for (;;)
    {
      return true;
      if (this.cgS)
      {
        this.mActivity.startActivity(localIntent);
        this.mActivity.setResult(-1, localIntent);
        this.mActivity.finish();
      }
      else
      {
        super.anl();
      }
    }
  }
  
  protected void b(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramBoolean) {
      aoop.a((URLDrawable)paramDrawable, this.app.getCurrentAccountUin(), true);
    }
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.setBounds(0, 0, (int)(264.0F * this.mDensity), (int)(138.0F * this.mDensity));
  }
  
  protected void d(aqju paramaqju)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwwardMapOption", 2, "updateImageView:setDefaultDialogPreviewImage");
    }
    a(ahiy.a(this.mActivity.getResources().getDrawable(2130840149), this.mDensity), false, 0);
  }
  
  protected void dns()
  {
    String str = this.mIntent.getStringExtra("forward_location_string");
    this.e.setMessage(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahid
 * JD-Core Version:    0.7.0.1
 */