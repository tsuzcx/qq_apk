package com.tencent.mobileqq.activity.selectmember;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import aqdj;
import aqhu;
import com.tencent.common.app.InnerFrame;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.qphone.base.util.QLog;

public abstract class SelectMemberInnerFrame
  extends InnerFrame
{
  protected InnerFrameManager a;
  public SelectMemberActivity a;
  public QQAppInterface e;
  protected LayoutInflater mLayoutInflater;
  
  public SelectMemberInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public SelectMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SelectMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract ContactSearchFragment a();
  
  public void a(ResultRecord paramResultRecord, int paramInt) {}
  
  public View bL()
  {
    View localView1 = null;
    String str = this.e.getCurrentAccountUin();
    if ((TextUtils.isEmpty(str)) && (QLog.isColorLevel())) {
      QLog.i("SelectMemberInnerFrame", 4, "my uin is null ");
    }
    View localView2;
    ImageView localImageView;
    Object localObject;
    CheckBox localCheckBox;
    if ((this instanceof FriendTeamListInnerFrame))
    {
      localView2 = getActivity().getLayoutInflater().inflate(2131560607, null);
      localImageView = (ImageView)localView2.findViewById(2131368698);
      localObject = (TextView)localView2.findViewById(2131372190);
      localCheckBox = (CheckBox)localView2.findViewById(2131364587);
      localView1 = localView2.findViewById(2131380761);
    }
    for (;;)
    {
      if (localObject != null) {
        ((TextView)localObject).setText(this.e.getCurrentNickname());
      }
      if (localImageView != null)
      {
        localImageView.setImageDrawable(aqhu.at());
        localObject = this.e.getFaceBitmapCacheKey(1, str, (byte)1, 0);
        localObject = this.e.getBitmapFromCache((String)localObject);
        if (localObject == null) {
          break label258;
        }
        localImageView.setImageBitmap((Bitmap)localObject);
      }
      for (;;)
      {
        if (localView1 != null) {
          localView1.setVisibility(8);
        }
        if (localCheckBox != null)
        {
          localCheckBox.setChecked(true);
          localCheckBox.setEnabled(false);
        }
        return localView2;
        if ((!(this instanceof TroopMemberListInnerFrame)) && (!(this instanceof DiscussionMemberListInnerFrame))) {
          break label276;
        }
        localView2 = getActivity().getLayoutInflater().inflate(2131563063, null);
        localImageView = (ImageView)localView2.findViewById(2131368698);
        localObject = (TextView)localView2.findViewById(2131372190);
        localCheckBox = (CheckBox)localView2.findViewById(2131364587);
        localView1 = localView2.findViewById(2131380761);
        break;
        label258:
        localImageView.setImageDrawable(aqdj.a(this.e, 1, str));
      }
      label276:
      localCheckBox = null;
      localObject = null;
      localImageView = null;
      localView2 = null;
    }
  }
  
  public abstract void notifyDataSetChanged();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity = ((SelectMemberActivity)getActivity());
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = a();
    this.e = b();
    this.mLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater();
  }
  
  public abstract String qN();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberInnerFrame
 * JD-Core Version:    0.7.0.1
 */