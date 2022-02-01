package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.widget.SlipLimitedListView;
import djd;
import dje;
import djf;
import djg;
import djh;
import dji;
import djj;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class SpaceGateActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, DragRelativeLayout.OnDragModeChangedListener, Observer
{
  private static final int jdField_a_of_type_Int = 1;
  private static final int jdField_b_of_type_Int = 2;
  private static final int c = 3;
  private Cursor jdField_a_of_type_AndroidDatabaseCursor;
  private Handler jdField_a_of_type_AndroidOsHandler = new djg(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new djh(this);
  private View jdField_a_of_type_AndroidViewView;
  private DragRelativeLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dji(this);
  private SlipLimitedListView jdField_a_of_type_ComTencentMobileqqWidgetSlipLimitedListView;
  private djj jdField_a_of_type_Djj;
  private String jdField_a_of_type_JavaLangString;
  private Map jdField_a_of_type_JavaUtilMap;
  private String jdField_b_of_type_JavaLangString;
  
  private Cursor a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1009).b(AppConstants.N, 1009);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlipLimitedListView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlipLimitedListView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131234508);
    this.jdField_a_of_type_Djj = new djj(this, this.jdField_a_of_type_AndroidDatabaseCursor);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlipLimitedListView = ((SlipLimitedListView)findViewById(2131234507));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlipLimitedListView.setAdapter(this.jdField_a_of_type_Djj);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlipLimitedListView.setOnSlideListener(new djd(this));
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidDatabaseCursor.getCount() == 0)
    {
      b(2);
      return;
    }
    b(1);
  }
  
  private void f()
  {
    int i = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, 1009);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_JavaLangString, 1009);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.N, 1009, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    if (i == 0) {
      a(0);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.a() == -1)
    {
      this.jdField_a_of_type_AndroidDatabaseCursor = a();
      this.jdField_a_of_type_Djj.a(this.jdField_a_of_type_AndroidDatabaseCursor);
      e();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragRelativeLayout paramDragRelativeLayout)
  {
    if (paramBoolean)
    {
      paramDragRelativeLayout = paramDragRelativeLayout.a();
      if ((paramDragRelativeLayout != null) && (paramDragRelativeLayout.getTag() != null))
      {
        paramDragRelativeLayout = (ProfileActivity.AllInOne)paramDragRelativeLayout.getTag();
        if (!((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramDragRelativeLayout.jdField_a_of_type_JavaLangString)) {
          break label100;
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragRelativeLayout.jdField_a_of_type_JavaLangString, 1009);
        RecentUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramDragRelativeLayout.jdField_a_of_type_JavaLangString, 1009);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.a() == -1) {
        a(0);
      }
      return;
      label100:
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragRelativeLayout.jdField_a_of_type_JavaLangString, 1003);
      RecentUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramDragRelativeLayout.jdField_a_of_type_JavaLangString, 1003);
    }
  }
  
  public void c()
  {
    QQMessageFacade localQQMessageFacade = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int i;
    if (localQQMessageFacade != null)
    {
      i = localQQMessageFacade.f();
      if (i <= 0) {
        break label110;
      }
      if (i > 99) {
        this.k.setText(getString(2131561807) + "(" + "99+" + ")");
      }
    }
    else
    {
      return;
    }
    this.k.setText(getString(2131561807) + "(" + i + ")");
    return;
    label110:
    c(getIntent().putExtra("leftViewText", getString(2131561807)));
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.a();
    }
  }
  
  public void onClick(View paramView)
  {
    ProfileActivity.AllInOne localAllInOne = (ProfileActivity.AllInOne)paramView.getTag(2130838010);
    boolean bool = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(localAllInOne.jdField_a_of_type_JavaLangString);
    if (2131231415 == paramView.getId())
    {
      paramView = new Intent(this, ChatActivity.class);
      paramView.putExtra("uin", localAllInOne.jdField_a_of_type_JavaLangString);
      if (!bool) {
        break label98;
      }
      paramView.putExtra("uintype", 0);
    }
    for (;;)
    {
      paramView.putExtra("uinname", localAllInOne.g);
      startActivity(paramView);
      return;
      label98:
      paramView.putExtra("uintype", 1009);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903983);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1));
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout = DragRelativeLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.a(this, false);
    this.jdField_a_of_type_AndroidDatabaseCursor = a();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    setTitle(2131562365);
    c();
    d();
    e();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (!this.jdField_a_of_type_AndroidDatabaseCursor.isClosed()) {
      this.jdField_a_of_type_AndroidDatabaseCursor.close();
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.jdField_a_of_type_Djj.a(a());
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord)) {
      runOnUiThread(new dje(this, (MessageRecord)paramObject));
    }
    while ((!(paramObject instanceof RecentUser)) || (((RecentUser)paramObject).type != 1009)) {
      return;
    }
    runOnUiThread(new djf(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SpaceGateActivity
 * JD-Core Version:    0.7.0.1
 */