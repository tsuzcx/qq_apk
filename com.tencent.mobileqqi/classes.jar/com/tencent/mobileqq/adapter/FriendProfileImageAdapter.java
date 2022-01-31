package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.FriendProfileImageModel;
import com.tencent.mobileqq.activity.FriendProfileImageModel.ProfileImageInfo;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import eyk;
import java.net.MalformedURLException;
import java.net.URL;

public class FriendProfileImageAdapter
  extends BaseAdapter
{
  private static final int jdField_b_of_type_Int = 1;
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new eyk(this);
  private FriendProfileImageModel jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  
  public FriendProfileImageAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131427393));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130840362);
    this.b = paramContext.getResources().getDrawable(2130840363);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  public void a(View paramView)
  {
    paramView = (ImageProgressCircle)paramView.findViewById(2131230757);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1, paramView);
    if (paramView.getVisibility() != 4) {
      paramView.setVisibility(4);
    }
  }
  
  public void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo, View paramView)
  {
    a(paramView);
    paramView.setTag(paramProfileImageInfo.c);
    ((ImageView)paramView.findViewById(2131230758)).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void a(FriendProfileImageModel paramFriendProfileImageModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel = paramFriendProfileImageModel;
  }
  
  public void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "showProgress() progressCircle = " + paramImageProgressCircle);
    }
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1, paramImageProgressCircle))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramImageProgressCircle;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 550L);
    }
  }
  
  public void b(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo, View paramView)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "loadThumbImage() path = " + paramProfileImageInfo.c);
    }
    try
    {
      URL localURL = new URL("profile_img_thumb", null, paramProfileImageInfo.c);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel != null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.b;
      }
      localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject2, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramView.setTag(paramProfileImageInfo.c);
      ((ImageView)paramView.findViewById(2131230758)).setImageDrawable((Drawable)localObject1);
      return;
    }
    catch (MalformedURLException paramProfileImageInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.PhotoWall", 2, paramProfileImageInfo.toString());
    }
  }
  
  public void c(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo, View paramView)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.PhotoWall", 2, "loadBigImage() path = " + paramProfileImageInfo.d);
    }
    for (;;)
    {
      try
      {
        a(paramView);
        Object localObject1 = URLDrawable.getDrawable(new URL("profile_img_thumb", null, paramProfileImageInfo.c));
        URL localURL = new URL("profile_img_big", null, paramProfileImageInfo.d);
        if (((URLDrawable)localObject1).getStatus() == 1)
        {
          if (i != 0)
          {
            localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject1, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            paramView.setTag(paramProfileImageInfo.d);
            ((ImageView)paramView.findViewById(2131230758)).setImageDrawable((Drawable)localObject1);
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel != null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();
            Object localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = this.b;
            }
            localObject1 = URLDrawable.getDrawable(localURL, (Drawable)localObject2, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            continue;
          }
          localObject1 = null;
          continue;
        }
        i = 0;
      }
      catch (MalformedURLException paramProfileImageInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.PhotoWall", 2, paramProfileImageInfo.toString());
        }
        paramView.setTag(null);
        return;
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    ImageView localImageView;
    FriendProfileImageModel.ProfileImageInfo localProfileImageInfo;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903251, null);
      paramViewGroup = (ImageProgressCircle)paramView.findViewById(2131230757);
      paramViewGroup.setVisibility(4);
      localImageView = (ImageView)paramView.findViewById(2131230758);
      localImageView.setMinimumWidth(this.jdField_a_of_type_Int);
      localImageView.setMinimumHeight(this.jdField_a_of_type_Int);
      localProfileImageInfo = (FriendProfileImageModel.ProfileImageInfo)getItem(paramInt);
      localView = paramView;
      if (localProfileImageInfo != null)
      {
        if (localProfileImageInfo.h != 6) {
          break label148;
        }
        c(localProfileImageInfo, paramView);
        localView = paramView;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.PhotoWall", 2, paramInt + "," + localProfileImageInfo.d);
          localView = paramView;
        }
      }
    }
    label148:
    do
    {
      return localView;
      if ((localProfileImageInfo.h != 3) && (localProfileImageInfo.h != 4)) {
        break;
      }
      b(localProfileImageInfo, paramView);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.PhotoWall", 2, "thumb: " + paramInt + "," + localProfileImageInfo.c);
      }
      localView = paramView;
    } while (!localProfileImageInfo.a);
    a(paramViewGroup);
    return paramView;
    localImageView.setImageResource(2130840363);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.FriendProfileImageAdapter
 * JD-Core Version:    0.7.0.1
 */