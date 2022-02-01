package com.tencent.mobileqq.activity;

import SummaryCard.RespSearch;
import SummaryCard.SearchInfo;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.qq.taf.jce.JceInputStream;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import dha;
import dhb;
import dhc;
import java.util.ArrayList;

public class SearchFriendListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String a = "param_search_resp";
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dha(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private dhb jdField_a_of_type_Dhb;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public void a(View paramView, int paramInt)
  {
    SearchInfo localSearchInfo = (SearchInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    dhc localdhc = (dhc)paramView.getTag();
    if (!TextUtils.isEmpty(localSearchInfo.strNick))
    {
      localdhc.jdField_a_of_type_AndroidWidgetTextView.setText(localSearchInfo.strNick);
      if (localSearchInfo.eSource != 1) {
        break label190;
      }
      localdhc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.b.b(String.valueOf(localSearchInfo.lUIN)));
      localdhc.b.setText(getString(2131559109) + localSearchInfo.lUIN);
    }
    for (;;)
    {
      localdhc.jdField_a_of_type_Int = paramInt;
      paramView.setContentDescription(localdhc.jdField_a_of_type_AndroidWidgetTextView.getText());
      return;
      TextView localTextView = localdhc.jdField_a_of_type_AndroidWidgetTextView;
      if (localSearchInfo.eSource == 1) {}
      for (String str = localSearchInfo.lUIN + "";; str = localSearchInfo.strMobile)
      {
        localTextView.setText(str);
        break;
      }
      label190:
      localdhc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.b.a(localSearchInfo.strMobile, (byte)3));
      localdhc.b.setText(getString(2131559110) + localSearchInfo.strMobile);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903946);
    j(2130837729);
    setTitle(getString(2131559108));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131234404));
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837729);
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    paramBundle = new JceInputStream(getIntent().getByteArrayExtra("param_search_resp"));
    RespSearch localRespSearch = new RespSearch();
    localRespSearch.readFrom(paramBundle);
    this.jdField_a_of_type_JavaUtilArrayList = localRespSearch.vRecords;
    this.jdField_a_of_type_ArrayOfByte = localRespSearch.vSecureSig;
    this.jdField_a_of_type_Dhb = new dhb(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Dhb);
    return true;
  }
  
  protected void doOnDestroy()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (localObject != null)
    {
      if (!(localObject instanceof SearchInfo)) {
        break label173;
      }
      paramView = (SearchInfo)localObject;
      localObject = new Intent(this, AddFriendLogicActivity.class);
      if (paramView.eSource != 1) {
        break label104;
      }
      ((Intent)localObject).putExtra("type", 0);
      ((Intent)localObject).putExtra("source_id", 3001);
      ((Intent)localObject).putExtra("uin", paramView.lUIN + "");
      ((Intent)localObject).putExtra("nick_name", paramView.strNick);
      startActivity((Intent)localObject);
    }
    label104:
    while (!(localObject instanceof dhc))
    {
      return;
      ((Intent)localObject).putExtra("type", 3);
      ((Intent)localObject).putExtra("uin", "");
      ((Intent)localObject).putExtra("friend_mobile_name", paramView.strNick);
      ((Intent)localObject).putExtra("friend_mobile_number", paramView.strMobile);
      if (paramView.bInContact == 1) {}
      for (int i = 3006;; i = 3014)
      {
        ((Intent)localObject).putExtra("source_id", i);
        break;
      }
    }
    label173:
    localObject = (dhc)paramView.getTag();
    paramView = (SearchInfo)this.jdField_a_of_type_JavaUtilArrayList.get(((dhc)localObject).jdField_a_of_type_Int);
    if (paramView.bIsEnterpriseQQ == 0)
    {
      AddFriendActivity.a(this, (SearchInfo)this.jdField_a_of_type_JavaUtilArrayList.get(((dhc)localObject).jdField_a_of_type_Int), this.b.a(), this.jdField_a_of_type_ArrayOfByte);
      return;
    }
    localObject = new Intent(this, EnterpriseDetailActivity.class);
    ((Intent)localObject).putExtra("uin", String.valueOf(paramView.lUIN));
    startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SearchFriendListActivity
 * JD-Core Version:    0.7.0.1
 */