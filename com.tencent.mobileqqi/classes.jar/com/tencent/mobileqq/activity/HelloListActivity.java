package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
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
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import cwe;
import cwf;
import cwg;
import cwh;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class HelloListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, DragRelativeLayout.OnDragModeChangedListener, Observer
{
  public static int a;
  public static String a;
  public static int b;
  public static int c;
  private Cursor jdField_a_of_type_AndroidDatabaseCursor;
  private DragRelativeLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new cwf(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private cwh jdField_a_of_type_Cwh;
  private Map jdField_a_of_type_JavaUtilMap;
  private int d;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 1;
    c = 2;
    jdField_a_of_type_JavaLangString = "source";
  }
  
  public Cursor a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1001).b(AppConstants.V, 1001);
  }
  
  public void a()
  {
    if (this.d != jdField_a_of_type_Int) {}
    QQMessageFacade localQQMessageFacade;
    do
    {
      return;
      localQQMessageFacade = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while (localQQMessageFacade == null);
    int i = localQQMessageFacade.f();
    if (i > 0)
    {
      if (i > 99)
      {
        this.k.setText(getString(2131561807) + "(" + "99+" + ")");
        return;
      }
      this.k.setText(getString(2131561807) + "(" + i + ")");
      return;
    }
    c(getIntent().putExtra("leftViewText", getString(2131561807)));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.a() == -1)
    {
      this.jdField_a_of_type_AndroidDatabaseCursor = a();
      this.jdField_a_of_type_Cwh = new cwh(this, this.jdField_a_of_type_AndroidDatabaseCursor);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Cwh);
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
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragRelativeLayout.jdField_a_of_type_JavaLangString, 1001);
        RecentUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramDragRelativeLayout.jdField_a_of_type_JavaLangString, 1001);
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.d = getIntent().getIntExtra(jdField_a_of_type_JavaLangString, 0);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1));
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    setContentView(2130903246);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout = DragRelativeLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.a(this, false);
    this.jdField_a_of_type_AndroidDatabaseCursor = a();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    setTitle(2131562371);
    a();
    findViewById(2131231768).setOnClickListener(new cwe(this));
    this.jdField_a_of_type_Cwh = new cwh(this, this.jdField_a_of_type_AndroidDatabaseCursor);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131231199));
    paramBundle = new View(this);
    paramBundle.setLayoutParams(new AbsListView.LayoutParams(-1, (int)DisplayUtils.a(this, 50.0F)));
    this.jdField_a_of_type_ComTencentWidgetXListView.b(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Cwh);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (!this.jdField_a_of_type_AndroidDatabaseCursor.isClosed()) {
      this.jdField_a_of_type_AndroidDatabaseCursor.close();
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_a_of_type_Cwh.a(a());
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.a();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a();
    this.jdField_a_of_type_Cwh.a(a());
  }
  
  public void onClick(View paramView)
  {
    ProfileActivity.AllInOne localAllInOne = (ProfileActivity.AllInOne)paramView.getTag(2130838008);
    Object localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    boolean bool = ((FriendManager)localObject).b(localAllInOne.jdField_a_of_type_JavaLangString);
    if (2131231771 == paramView.getId())
    {
      localObject = ((FriendManager)localObject).a(localAllInOne.jdField_a_of_type_JavaLangString);
      if ((localObject == null) || (bool))
      {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localAllInOne.jdField_a_of_type_JavaLangString, 1001);
        paramView = new ProfileActivity.AllInOne(localAllInOne.jdField_a_of_type_JavaLangString, 40);
        paramView.g = localAllInOne.g;
        if ((localObject != null) && ((paramView.g == null) || (paramView.g.length() == 0)))
        {
          paramView.g = ((Card)localObject).strNick;
          paramView.h = ((Card)localObject).strReMark;
        }
        ProfileActivity.a(this, paramView);
      }
    }
    while (2131231770 != paramView.getId()) {
      for (;;)
      {
        return;
        paramView = new ProfileActivity.AllInOne(localAllInOne.jdField_a_of_type_JavaLangString, 42);
      }
    }
    paramView = new Intent(this, ChatActivity.class);
    paramView.putExtra("uin", localAllInOne.jdField_a_of_type_JavaLangString);
    if (bool) {
      paramView.putExtra("uintype", 0);
    }
    for (;;)
    {
      paramView.putExtra("uinname", localAllInOne.g);
      startActivity(paramView);
      return;
      paramView.putExtra("uintype", 1001);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord)) {
      runOnUiThread(new cwg(this, (MessageRecord)paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HelloListActivity
 * JD-Core Version:    0.7.0.1
 */