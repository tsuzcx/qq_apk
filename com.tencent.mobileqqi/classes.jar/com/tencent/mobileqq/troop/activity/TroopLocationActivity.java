package com.tencent.mobileqq.troop.activity;

import NearbyGroup.GroupArea;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import gyq;
import gyr;
import java.util.ArrayList;

public class TroopLocationActivity
  extends IphoneTitleBarActivity
  implements OverScrollViewListener
{
  public static final int a = 30;
  public static final String a = "TroopLocationActivity";
  public static final int b = 1;
  public static final String b = "lat";
  public static final int c = 2;
  public static final String c = "lon";
  public static final int d = 3;
  public static final String d = "location_name";
  public static final int e = 1000;
  public static final String e = "from";
  public static final int f = 800;
  public static final String f = "near_troop_last_refresh_time";
  GroupArea jdField_a_of_type_NearbyGroupGroupArea;
  public Context a;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public LBSHandler a;
  public LBSObserver a;
  public TroopLocationActivity.TroopsAdapter a;
  public TroopLocationActivity.UIHandler a;
  public PullRefreshHeader a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public ArrayList a;
  public boolean a;
  public TextView b;
  public int g;
  public String g;
  public int h = 0;
  public int i = 0;
  public int j = -1;
  
  public TroopLocationActivity()
  {
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new gyr(this);
  }
  
  public long a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("near_troop_last_refresh_time", 0L);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
  }
  
  public void a(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this, paramInt, paramString, 0).b(d());
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("near_troop_last_refresh_time", paramLong).commit();
  }
  
  public void a(Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = getIntent();
    }
    if (localIntent == null) {
      return;
    }
    this.jdField_g_of_type_Int = localIntent.getIntExtra("lat", 0);
    this.h = localIntent.getIntExtra("lon", 0);
    this.jdField_g_of_type_JavaLangString = localIntent.getStringExtra("location_name");
    this.i = localIntent.getIntExtra("from", 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_g_of_type_JavaLangString);
    e();
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 169	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 83	com/tencent/mobileqq/troop/activity/TroopLocationActivity:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12: bipush 8
    //   14: invokevirtual 173	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   17: checkcast 175	com/tencent/mobileqq/model/FriendManager
    //   20: astore 10
    //   22: aconst_null
    //   23: astore 9
    //   25: aload 10
    //   27: ifnull +13 -> 40
    //   30: aload 10
    //   32: aload_1
    //   33: invokeinterface 178 2 0
    //   38: astore 9
    //   40: aload 9
    //   42: ifnull -35 -> 7
    //   45: aload 9
    //   47: getfield 183	com/tencent/mobileqq/data/TroopInfo:strLocation	Ljava/lang/String;
    //   50: aload_0
    //   51: getfield 150	com/tencent/mobileqq/troop/activity/TroopLocationActivity:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokevirtual 189	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifeq -50 -> 7
    //   60: aload_0
    //   61: getfield 67	com/tencent/mobileqq/troop/activity/TroopLocationActivity:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   64: invokevirtual 193	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   67: astore 10
    //   69: aload 10
    //   71: invokeinterface 198 1 0
    //   76: ifeq +27 -> 103
    //   79: aload 10
    //   81: invokeinterface 202 1 0
    //   86: checkcast 204	NearbyGroup/GroupInfo
    //   89: getfield 208	NearbyGroup/GroupInfo:lCode	J
    //   92: invokestatic 214	java/lang/Long:toString	(J)Ljava/lang/String;
    //   95: aload_1
    //   96: invokevirtual 189	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   99: ifeq -30 -> 69
    //   102: return
    //   103: aload 9
    //   105: getfield 217	com/tencent/mobileqq/data/TroopInfo:troopcode	Ljava/lang/String;
    //   108: invokestatic 221	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   111: lstore_3
    //   112: aload 9
    //   114: getfield 224	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   117: invokestatic 221	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   120: lstore 5
    //   122: aload 9
    //   124: getfield 227	com/tencent/mobileqq/data/TroopInfo:troopowneruin	Ljava/lang/String;
    //   127: invokestatic 221	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   130: lstore 7
    //   132: lload 5
    //   134: lconst_0
    //   135: lcmp
    //   136: ifeq -129 -> 7
    //   139: new 204	NearbyGroup/GroupInfo
    //   142: dup
    //   143: invokespecial 228	NearbyGroup/GroupInfo:<init>	()V
    //   146: astore_1
    //   147: aload_1
    //   148: lload 5
    //   150: putfield 208	NearbyGroup/GroupInfo:lCode	J
    //   153: aload_1
    //   154: lload_3
    //   155: putfield 231	NearbyGroup/GroupInfo:lUin	J
    //   158: aload_1
    //   159: aload 9
    //   161: getfield 234	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   164: putfield 237	NearbyGroup/GroupInfo:strName	Ljava/lang/String;
    //   167: aload_1
    //   168: aload 9
    //   170: getfield 183	com/tencent/mobileqq/data/TroopInfo:strLocation	Ljava/lang/String;
    //   173: putfield 238	NearbyGroup/GroupInfo:strLocation	Ljava/lang/String;
    //   176: aload 9
    //   178: getfield 241	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   181: ifne +49 -> 230
    //   184: iconst_1
    //   185: istore_2
    //   186: aload_1
    //   187: iload_2
    //   188: putfield 244	NearbyGroup/GroupInfo:iMemberCnt	I
    //   191: aload_1
    //   192: aload 9
    //   194: getfield 247	com/tencent/mobileqq/data/TroopInfo:mRichFingerMemo	Ljava/lang/String;
    //   197: putfield 250	NearbyGroup/GroupInfo:strIntro	Ljava/lang/String;
    //   200: aload_1
    //   201: lload 7
    //   203: putfield 253	NearbyGroup/GroupInfo:lCreator	J
    //   206: aload_0
    //   207: getfield 67	com/tencent/mobileqq/troop/activity/TroopLocationActivity:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   210: iconst_0
    //   211: aload_1
    //   212: invokevirtual 257	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   215: aload_0
    //   216: getfield 259	com/tencent/mobileqq/troop/activity/TroopLocationActivity:jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity$TroopsAdapter	Lcom/tencent/mobileqq/troop/activity/TroopLocationActivity$TroopsAdapter;
    //   219: ifnull -212 -> 7
    //   222: aload_0
    //   223: getfield 259	com/tencent/mobileqq/troop/activity/TroopLocationActivity:jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity$TroopsAdapter	Lcom/tencent/mobileqq/troop/activity/TroopLocationActivity$TroopsAdapter;
    //   226: invokevirtual 264	com/tencent/mobileqq/troop/activity/TroopLocationActivity$TroopsAdapter:notifyDataSetChanged	()V
    //   229: return
    //   230: aload 9
    //   232: getfield 241	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   235: istore_2
    //   236: goto -50 -> 186
    //   239: astore_1
    //   240: return
    //   241: astore_1
    //   242: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	TroopLocationActivity
    //   0	243	1	paramString	String
    //   185	51	2	k	int
    //   111	44	3	l1	long
    //   120	29	5	l2	long
    //   130	72	7	l3	long
    //   23	208	9	localTroopInfo	com.tencent.mobileqq.data.TroopInfo
    //   20	60	10	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   122	132	239	java/lang/NumberFormatException
    //   103	122	241	java/lang/NumberFormatException
  }
  
  public void a(boolean paramBoolean)
  {
    e();
    if (paramBoolean) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity$UIHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)) {}
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity$UIHandler.sendEmptyMessageDelayed(3, 800L);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      a(System.currentTimeMillis());
      return;
      a(1, getString(2131562097));
    } while (this.jdField_a_of_type_ComTencentWidgetXListView == null);
    this.jdField_a_of_type_ComTencentWidgetXListView.B();
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
    if ((!e()) && (!a(true))) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity$UIHandler.sendEmptyMessageDelayed(2, 1000L);
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    int k;
    if (!paramBoolean)
    {
      k = this.jdField_a_of_type_JavaUtilArrayList.size();
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(this.jdField_g_of_type_JavaLangString, this.jdField_g_of_type_Int, this.h, k, 30);
      return true;
      this.jdField_a_of_type_Boolean = true;
      k = 0;
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void d()
  {
    setContentView(2130903412);
    if (this.k != null) {
      this.k.setText(2131561694);
    }
    c(2131561889, new gyq(this));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131232531));
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837729);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903323, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903413, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131230796));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232532));
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_AndroidViewView);
    setTitle(2131562191);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity$TroopsAdapter = new TroopLocationActivity.TroopsAdapter(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity$TroopsAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity$TroopsAdapter);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    f();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity$UIHandler = new TroopLocationActivity.UIHandler(this);
    this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler = ((LBSHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(3));
    a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    d();
    a(null);
    return true;
  }
  
  protected void doOnDestroy()
  {
    e();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity$UIHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity$UIHandler = null;
    b(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity$TroopsAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopLocationActivity$TroopsAdapter.b();
    }
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.requestFocusFromTouch();
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
    }
    a(paramIntent);
  }
  
  public void e()
  {
    d();
    a(true);
  }
  
  public void f()
  {
    TroopCreateLogic localTroopCreateLogic = (TroopCreateLogic)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(30);
    if (localTroopCreateLogic == null) {}
    while (localTroopCreateLogic.l != 1) {
      return;
    }
    a(localTroopCreateLogic.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopLocationActivity
 * JD-Core Version:    0.7.0.1
 */