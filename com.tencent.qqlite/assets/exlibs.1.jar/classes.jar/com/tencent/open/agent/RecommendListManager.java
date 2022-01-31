package com.tencent.open.agent;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;
import com.tencent.open.agent.datamodel.QZonePortraitData;
import com.tencent.open.base.LogUtility;
import fbw;
import java.util.HashMap;

public class RecommendListManager
  extends LinearLayout
  implements View.OnClickListener, ViewStub.OnInflateListener, ImageLoader.ImageLoadListener
{
  protected static final int a = 5;
  protected static final String a = "RecommendListManager";
  protected Handler a;
  protected SocialFriendChooser a;
  protected FriendDataManager a;
  public HashMap a;
  
  public RecommendListManager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager = FriendDataManager.a();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    int j = super.getChildCount();
    int i = 0;
    while (i < j)
    {
      ViewStub localViewStub = (ViewStub)super.getChildAt(i);
      localViewStub.setOnInflateListener(this);
      localViewStub.setOnClickListener(this);
      i += 1;
    }
    LogUtility.c("RecommendListManager", "-->onCreate()");
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new fbw(this, paramString, paramBitmap));
  }
  
  public void b()
  {
    int j = this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a();
    LogUtility.c("RecommendListManager", "-->notifyDataSetChanged() count = " + j);
    int i = j;
    if (j > 5) {
      i = 5;
    }
    j = 0;
    if (j < i)
    {
      Object localObject = super.getChildAt(j);
      if ((localObject instanceof ViewStub)) {
        ((View)localObject).setVisibility(0);
      }
      for (;;)
      {
        j += 1;
        break;
        localObject = (CheckBox)((View)localObject).findViewById(2131298744);
        Friend localFriend = this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(j);
        if (this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(localFriend.a)) {
          ((CheckBox)localObject).setChecked(true);
        } else {
          ((CheckBox)localObject).setChecked(false);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    switch (paramView.getId())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      LogUtility.c("RecommendListManager", "-->onClick() position = " + i + " v.getId() = " + paramView.getId());
      if ((i != -1) && (i < this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a()))
      {
        paramView = (CheckBox)paramView.findViewById(2131298744);
        Friend localFriend = this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(i);
        this.jdField_a_of_type_ComTencentOpenAgentSocialFriendChooser.a(localFriend);
        if (!this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(localFriend.a)) {
          break;
        }
        paramView.setChecked(true);
      }
      return;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
    }
    paramView.setChecked(false);
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    int i = -1;
    Object localObject;
    ImageView localImageView;
    switch (paramView.getId())
    {
    default: 
      LogUtility.c("RecommendListManager", "-->onInflate() position = " + i);
      paramView.setOnClickListener(this);
      paramViewStub = this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(i);
      if ((paramViewStub.d == null) || ("".equals(paramViewStub.d))) {
        paramViewStub.d = QZonePortraitData.a(this.jdField_a_of_type_ComTencentOpenAgentSocialFriendChooser.c(), paramViewStub.a);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramViewStub.d, paramView);
      localObject = (CheckBox)paramView.findViewById(2131298744);
      localImageView = (ImageView)paramView.findViewById(2131296453);
      paramView = (TextView)paramView.findViewById(2131296455);
      if (this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramViewStub.a))
      {
        ((CheckBox)localObject).setChecked(true);
        label180:
        localObject = ImageLoader.a().a(paramViewStub.d);
        if (localObject != null) {
          break label277;
        }
        localImageView.setImageResource(2130838036);
        ImageLoader.a().a(paramViewStub.d, this);
      }
      break;
    }
    for (;;)
    {
      if ((paramViewStub.c != null) && (!"".equals(paramViewStub.c))) {
        break label287;
      }
      paramView.setText(paramViewStub.b);
      return;
      i = 0;
      break;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      i = 4;
      break;
      ((CheckBox)localObject).setChecked(false);
      break label180;
      label277:
      localImageView.setImageBitmap((Bitmap)localObject);
    }
    label287:
    paramView.setText(paramViewStub.c);
  }
  
  public void setActivity(SocialFriendChooser paramSocialFriendChooser)
  {
    this.jdField_a_of_type_ComTencentOpenAgentSocialFriendChooser = paramSocialFriendChooser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.RecommendListManager
 * JD-Core Version:    0.7.0.1
 */