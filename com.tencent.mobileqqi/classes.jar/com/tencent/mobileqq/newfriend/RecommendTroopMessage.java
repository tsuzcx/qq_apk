package com.tencent.mobileqq.newfriend;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.RecommendTroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import gdi;
import java.util.ArrayList;
import java.util.List;

public class RecommendTroopMessage
  extends NewFriendMessage
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public TroopObserver a;
  private List jdField_a_of_type_JavaUtilList;
  
  public RecommendTroopMessage()
  {
    super(3);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new gdi(this);
  }
  
  public RecommendTroopMessage(int paramInt)
  {
    super(3, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new gdi(this);
  }
  
  public RecommendTroopMessage(RecommendTroopInfo paramRecommendTroopInfo, QQAppInterface paramQQAppInterface)
  {
    super(3);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new gdi(this);
    if (paramRecommendTroopInfo != null)
    {
      this.o = 1;
      this.jdField_a_of_type_JavaUtilList = new ArrayList(1);
      this.jdField_a_of_type_JavaUtilList.add(paramRecommendTroopInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public RecommendTroopMessage(List paramList, QQAppInterface paramQQAppInterface)
  {
    super(3);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new gdi(this);
    if (paramList != null)
    {
      this.o = paramList.size();
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() < 1) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localStringBuilder.append(((RecommendTroopInfo)this.jdField_a_of_type_JavaUtilList.get(i)).name);
      if (i != this.jdField_a_of_type_JavaUtilList.size() - 1) {
        localStringBuilder.append("、");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a(ImageView paramImageView)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramImageView.getContext().getResources().getDrawable(2130840144);
    }
    paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  private void a(RecommendTroopInfo paramRecommendTroopInfo, String paramString1, String paramString2)
  {
    if (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramRecommendTroopInfo.uin) != null) {}
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp_recommend", "Direct_joingrp", 0, 0, "", "", "", "");
      return;
      if (paramRecommendTroopInfo.option != 3)
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AddFriendLogicActivity.class);
        localIntent.putExtra("uin", paramRecommendTroopInfo.uin);
        localIntent.putExtra("troop_code", paramRecommendTroopInfo.uin);
        localIntent.putExtra("name", paramRecommendTroopInfo.name);
        localIntent.putExtra("group_option", paramRecommendTroopInfo.option);
        localIntent.putExtra("type", 1);
        localIntent.putExtra("param_last_activity_name", this.jdField_a_of_type_AndroidContentContext.getString(2131559258));
        localIntent.putExtra("stat_option", 3017);
        localIntent.putExtra("join_group_question", paramString1);
        localIntent.putExtra("join_group_answer", paramString2);
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      }
    }
  }
  
  private int e()
  {
    if (this.o > 1) {
      return 2130903560;
    }
    if (this.o == 1) {
      return 2130903561;
    }
    return 0;
  }
  
  public View a(ViewGroup paramViewGroup, View paramView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    if (this.o > 0)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(e(), paramViewGroup, false);
      Object localObject = (ImageView)paramView.findViewById(2131232919);
      paramViewGroup = (TextView)paramView.findViewById(2131232921);
      a((ImageView)localObject);
      if (this.o > 1)
      {
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131560407) + "(" + this.o + ")";
        paramViewGroup.setText((CharSequence)localObject);
        paramViewGroup.setContentDescription((CharSequence)localObject);
        paramViewGroup = (TextView)paramView.findViewById(2131232922);
        localObject = a();
        paramViewGroup.setText((CharSequence)localObject);
        paramViewGroup.setContentDescription((CharSequence)localObject);
      }
    }
    else
    {
      return paramView;
    }
    paramViewGroup.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131560408) + " " + ((RecommendTroopInfo)this.jdField_a_of_type_JavaUtilList.get(0)).name);
    paramViewGroup.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131560409) + ((RecommendTroopInfo)this.jdField_a_of_type_JavaUtilList.get(0)).name);
    return paramView;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.RecommendTroopMessage
 * JD-Core Version:    0.7.0.1
 */