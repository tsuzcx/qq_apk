package com.tencent.mobileqq.troop.activity;

import NearbyGroup.RspActivity;
import NearbyGroup.RspGetNearbyGroup;
import NearbyGroup.RspHotGrp;
import NearbyGroup.RspTopic;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.GroupAreaWrapper;
import com.tencent.mobileqq.troop.data.GroupAreaWrapper.ActivityInfo;
import com.tencent.mobileqq.troop.data.GroupAreaWrapper.TopicInfo;
import com.tencent.mobileqq.troop.data.NearbyTroops;
import com.tencent.mobileqq.troop.data.NearbyTroopsExpandableListViewAdapter;
import com.tencent.mobileqq.troop.widget.NearbyTroopsExpandableListView;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView.NearbyTroopsMapViewObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FakeTextView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import gpp;
import gpq;
import gpr;
import gps;
import gpu;
import gpv;
import gpw;
import gpx;
import gpy;
import gpz;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.nearby_troop_activity.nearby_troop_activity.ActivityDigest;
import tencent.im.cs.nearby_troop_activity.nearby_troop_activity.RspBody;
import tencent.im.cs.nearby_troop_hot.nearby_troop_hot.HotQunMsg;
import tencent.im.cs.nearby_troop_hot.nearby_troop_hot.HotQunRsp;
import tencent.im.cs.nearby_troop_hot.nearby_troop_hot.QunInfo;
import tencent.im.cs.nearby_troop_hot.nearby_troop_hot.RetInfo;
import tencent.im.cs.nearby_troop_post.nearby_troop_post.RspBody;
import tencent.im.cs.nearby_troop_post.nearby_troop_post.RspNearbyPostInfo;

public class NearbyTroopsActivity
  extends LbsBaseActivity
  implements View.OnClickListener, View.OnTouchListener, NearbyTroopsMapView.NearbyTroopsMapViewObserver, OverScrollViewListener
{
  public static final boolean a = true;
  public static final String b = "NearbyTroopsActivity";
  public static final String c = "near_troop_last_refresh_time";
  public static final String d = "lat";
  public static final String e = "lon";
  public static final String f = "from";
  public static final int g = 1000;
  public static final String g = "mode";
  public static final int h = 800;
  public static final String h = "_nearby_troops_5_0.nb";
  public static final int i = 1;
  public static final String i = "location_name";
  public static final int j = 2;
  public static final int k = 3;
  public static final int l = 4;
  public static final int m = 0;
  public static final int n = 1;
  public static final int o = 1;
  public static final int p = 2;
  public static final int q = 3;
  public static final int r = 4;
  public static final int s = 5;
  public static final int t = 6;
  public static final int u = 7;
  public static final int v = 0;
  public static final int w = 1;
  public Context a;
  public Drawable a;
  public GestureDetector a;
  protected View.OnClickListener a;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  protected ImageView a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public FriendListObserver a;
  public LBSHandler a;
  public LBSObserver a;
  public NearbyTroopsActivity.UIHandler a;
  public NearbyTroopsExpandableListViewAdapter a;
  public NearbyTroopsExpandableListView a;
  public NearbyTroopsMapView a;
  public PullRefreshHeader a;
  public MapController a;
  gpz jdField_a_of_type_Gpz;
  public String a;
  public ArrayList a;
  public String[] a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  Button jdField_b_of_type_AndroidWidgetButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public ArrayList b;
  public boolean b;
  public int c;
  View c;
  protected TextView c;
  public ArrayList c;
  public boolean c;
  public int d;
  View jdField_d_of_type_AndroidViewView;
  protected TextView d;
  boolean jdField_d_of_type_Boolean = false;
  public int e;
  public View e;
  public int f = 0;
  public String j;
  public String k;
  public int x = 0;
  
  public NearbyTroopsActivity()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new gpp(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new gpr(this);
    this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new gps(this);
  }
  
  private void c(boolean paramBoolean)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    this.jdField_a_of_type_ArrayOfJavaLangString = getResources().getStringArray(2131689495);
    localActionSheet.d(this.jdField_a_of_type_ArrayOfJavaLangString[2]);
    localActionSheet.a(new gpw(this));
    int i1 = 0;
    while (i1 < 2)
    {
      localActionSheet.a(this.jdField_a_of_type_ArrayOfJavaLangString[i1], false);
      i1 += 1;
    }
    localActionSheet.a(new gpx(this, localActionSheet));
    localActionSheet.show();
  }
  
  public long a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("near_troop_last_refresh_time", 0L);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("near_troop_last_refresh_time", paramLong).commit();
  }
  
  public void a(RspActivity paramRspActivity)
  {
    if (paramRspActivity == null) {}
    for (;;)
    {
      return;
      Object localObject1 = new nearby_troop_activity.RspBody();
      try
      {
        localObject1 = (nearby_troop_activity.RspBody)((nearby_troop_activity.RspBody)localObject1).mergeFrom(paramRspActivity.strRspAct);
        if (((nearby_troop_activity.RspBody)localObject1).has())
        {
          Object localObject2 = ((nearby_troop_activity.RspBody)localObject1).rpt_activity;
          if ((localObject2 != null) && (((PBRepeatMessageField)localObject2).has()))
          {
            localObject2 = ((PBRepeatMessageField)localObject2).get();
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
              localObject2 = (nearby_troop_activity.ActivityDigest)((List)localObject2).get(0);
              if (localObject2 != null)
              {
                GroupAreaWrapper.ActivityInfo localActivityInfo = new GroupAreaWrapper.ActivityInfo(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
                localActivityInfo.d = ((nearby_troop_activity.ActivityDigest)localObject2).str_loc_name.get();
                localActivityInfo.jdField_b_of_type_JavaLangString = ((nearby_troop_activity.RspBody)localObject1).str_wording.get();
                localActivityInfo.jdField_a_of_type_Int = ((nearby_troop_activity.ActivityDigest)localObject2).uint32_distance.get();
                localActivityInfo.jdField_b_of_type_Int = ((int)((nearby_troop_activity.ActivityDigest)localObject2).uint64_enroll.get());
                localActivityInfo.c = ((nearby_troop_activity.ActivityDigest)localObject2).str_name.get();
                localActivityInfo.jdField_a_of_type_JavaLangString = ((nearby_troop_activity.RspBody)localObject1).str_title.get();
                localActivityInfo.e = ((nearby_troop_activity.ActivityDigest)localObject2).str_cover_url.get();
                localActivityInfo.f = ((nearby_troop_activity.RspBody)localObject1).str_url_list.get();
                localActivityInfo.g = ((nearby_troop_activity.ActivityDigest)localObject2).str_url_info.get();
                localObject1 = new GroupAreaWrapper(localActivityInfo);
                if (this.jdField_c_of_type_JavaUtilArrayList.size() > paramRspActivity.shShowPos)
                {
                  this.jdField_c_of_type_JavaUtilArrayList.add(paramRspActivity.shShowPos, localObject1);
                  return;
                }
                this.jdField_c_of_type_JavaUtilArrayList.add(localObject1);
                return;
              }
            }
          }
        }
      }
      catch (Exception paramRspActivity) {}
    }
  }
  
  public void a(RspGetNearbyGroup paramRspGetNearbyGroup)
  {
    if ((paramRspGetNearbyGroup == null) || (paramRspGetNearbyGroup.stRspHotGrp == null))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
      return;
    }
    nearby_troop_hot.HotQunMsg localHotQunMsg = new nearby_troop_hot.HotQunMsg();
    try
    {
      localHotQunMsg.mergeFrom(paramRspGetNearbyGroup.stRspHotGrp.strRspHotGrp);
      if ((localHotQunMsg == null) || (!localHotQunMsg.msg_rsp_body.has()))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
        return;
      }
    }
    catch (Exception paramRspGetNearbyGroup)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
      return;
    }
    if ((localHotQunMsg.msg_rsp_body.ret_info == null) || (!localHotQunMsg.msg_rsp_body.ret_info.has()) || (localHotQunMsg.msg_rsp_body.qun_info == null) || (!localHotQunMsg.msg_rsp_body.qun_info.has()))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
      return;
    }
    if (((nearby_troop_hot.RetInfo)localHotQunMsg.msg_rsp_body.ret_info.get()).ret_code.get() != 0)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
      return;
    }
    paramRspGetNearbyGroup = (nearby_troop_hot.QunInfo)localHotQunMsg.msg_rsp_body.qun_info.get();
    a(paramRspGetNearbyGroup.title.get(), paramRspGetNearbyGroup.desc.get(), paramRspGetNearbyGroup.url.get());
  }
  
  public void a(RspTopic paramRspTopic)
  {
    if (paramRspTopic == null) {}
    for (;;)
    {
      return;
      Object localObject = new nearby_troop_post.RspBody();
      try
      {
        ((nearby_troop_post.RspBody)localObject).mergeFrom(paramRspTopic.strRspTopic);
        label22:
        if (!((nearby_troop_post.RspBody)localObject).has()) {
          continue;
        }
        localObject = ((nearby_troop_post.RspBody)localObject).msg_subcmd0x1_rsp_nearbypostinfo;
        if ((localObject == null) || (!((nearby_troop_post.RspNearbyPostInfo)localObject).has())) {
          continue;
        }
        GroupAreaWrapper.TopicInfo localTopicInfo = new GroupAreaWrapper.TopicInfo(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        localTopicInfo.d = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_post_address.get();
        localTopicInfo.jdField_b_of_type_JavaLangString = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_desc.get();
        localTopicInfo.jdField_a_of_type_Int = ((nearby_troop_post.RspNearbyPostInfo)localObject).uint32_distance.get();
        localTopicInfo.jdField_b_of_type_Int = ((nearby_troop_post.RspNearbyPostInfo)localObject).uint32_post_replys.get();
        localTopicInfo.c = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_post_title.get();
        localTopicInfo.jdField_a_of_type_JavaLangString = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_title.get();
        localTopicInfo.e = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_post_picture_url.get();
        localTopicInfo.g = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_post_url.get();
        localTopicInfo.f = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_title_url.get();
        localObject = new GroupAreaWrapper(localTopicInfo);
        if (this.jdField_c_of_type_JavaUtilArrayList.size() > paramRspTopic.shShowPos)
        {
          this.jdField_c_of_type_JavaUtilArrayList.add(paramRspTopic.shShowPos, localObject);
          return;
        }
        this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
        return;
      }
      catch (Exception localException)
      {
        break label22;
      }
    }
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    a(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
    if ((paramGeoPoint.getLatitudeE6() != this.jdField_d_of_type_Int) || (paramGeoPoint.getLongitudeE6() != this.jdField_e_of_type_Int))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, 0);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    localLayoutParams.topMargin = 0;
    this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    setTitle(paramCharSequence);
  }
  
  void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
    this.jdField_a_of_type_JavaLangString = paramString3;
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(true));
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "hot", "exp", 0, 0, "", "", "", "");
  }
  
  /* Error */
  public void a(ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 550	java/io/ObjectOutputStream
    //   3: dup
    //   4: aload_0
    //   5: ldc 40
    //   7: iconst_0
    //   8: invokevirtual 554	com/tencent/mobileqq/troop/activity/NearbyTroopsActivity:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   11: invokespecial 557	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   14: astore 7
    //   16: aload 7
    //   18: astore 6
    //   20: aload 7
    //   22: aload_1
    //   23: invokevirtual 560	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   26: aload 7
    //   28: astore 6
    //   30: aload 7
    //   32: aload_2
    //   33: invokevirtual 560	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   36: aload 7
    //   38: astore 6
    //   40: aload 7
    //   42: aload_3
    //   43: invokevirtual 560	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   46: aload 7
    //   48: astore 6
    //   50: aload 7
    //   52: iload 4
    //   54: invokevirtual 563	java/io/ObjectOutputStream:writeInt	(I)V
    //   57: aload 7
    //   59: astore 6
    //   61: aload 7
    //   63: iload 5
    //   65: invokevirtual 563	java/io/ObjectOutputStream:writeInt	(I)V
    //   68: aload 7
    //   70: astore 6
    //   72: aload 7
    //   74: invokevirtual 566	java/io/ObjectOutputStream:flush	()V
    //   77: aload 7
    //   79: ifnull +8 -> 87
    //   82: aload 7
    //   84: invokevirtual 569	java/io/ObjectOutputStream:close	()V
    //   87: return
    //   88: astore_1
    //   89: aload_1
    //   90: invokevirtual 572	java/io/IOException:printStackTrace	()V
    //   93: return
    //   94: astore_1
    //   95: aconst_null
    //   96: astore 7
    //   98: aload 7
    //   100: astore 6
    //   102: aload_1
    //   103: invokevirtual 573	java/io/FileNotFoundException:printStackTrace	()V
    //   106: aload 7
    //   108: ifnull -21 -> 87
    //   111: aload 7
    //   113: invokevirtual 569	java/io/ObjectOutputStream:close	()V
    //   116: return
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 572	java/io/IOException:printStackTrace	()V
    //   122: return
    //   123: astore_1
    //   124: aconst_null
    //   125: astore 7
    //   127: aload 7
    //   129: astore 6
    //   131: aload_1
    //   132: invokevirtual 572	java/io/IOException:printStackTrace	()V
    //   135: aload 7
    //   137: ifnull -50 -> 87
    //   140: aload 7
    //   142: invokevirtual 569	java/io/ObjectOutputStream:close	()V
    //   145: return
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 572	java/io/IOException:printStackTrace	()V
    //   151: return
    //   152: astore_1
    //   153: aconst_null
    //   154: astore 6
    //   156: aload 6
    //   158: ifnull +8 -> 166
    //   161: aload 6
    //   163: invokevirtual 569	java/io/ObjectOutputStream:close	()V
    //   166: aload_1
    //   167: athrow
    //   168: astore_2
    //   169: aload_2
    //   170: invokevirtual 572	java/io/IOException:printStackTrace	()V
    //   173: goto -7 -> 166
    //   176: astore_1
    //   177: goto -21 -> 156
    //   180: astore_1
    //   181: goto -54 -> 127
    //   184: astore_1
    //   185: goto -87 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	NearbyTroopsActivity
    //   0	188	1	paramArrayList1	ArrayList
    //   0	188	2	paramArrayList2	ArrayList
    //   0	188	3	paramArrayList3	ArrayList
    //   0	188	4	paramInt1	int
    //   0	188	5	paramInt2	int
    //   18	144	6	localObjectOutputStream1	java.io.ObjectOutputStream
    //   14	127	7	localObjectOutputStream2	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   82	87	88	java/io/IOException
    //   0	16	94	java/io/FileNotFoundException
    //   111	116	117	java/io/IOException
    //   0	16	123	java/io/IOException
    //   140	145	146	java/io/IOException
    //   0	16	152	finally
    //   161	166	168	java/io/IOException
    //   20	26	176	finally
    //   30	36	176	finally
    //   40	46	176	finally
    //   50	57	176	finally
    //   61	68	176	finally
    //   72	77	176	finally
    //   102	106	176	finally
    //   131	135	176	finally
    //   20	26	180	java/io/IOException
    //   30	36	180	java/io/IOException
    //   40	46	180	java/io/IOException
    //   50	57	180	java/io/IOException
    //   61	68	180	java/io/IOException
    //   72	77	180	java/io/IOException
    //   20	26	184	java/io/FileNotFoundException
    //   30	36	184	java/io/FileNotFoundException
    //   40	46	184	java/io/FileNotFoundException
    //   50	57	184	java/io/FileNotFoundException
    //   61	68	184	java/io/FileNotFoundException
    //   72	77	184	java/io/FileNotFoundException
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity$UIHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)) {}
    }
    while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView == null)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity$UIHandler.sendEmptyMessageDelayed(3, 800L);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      a(System.currentTimeMillis());
      return;
    }
    a(1, getString(2131562097));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.B();
  }
  
  public void a(boolean paramBoolean, Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    if (paramBoolean)
    {
      setContentView(2130903385);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903325, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView, false));
      this.jdField_e_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903386, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView, false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView = ((NearbyTroopsExpandableListView)findViewById(2131232397));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131232401));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131232403));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131232404));
      this.jdField_b_of_type_AndroidViewView = findViewById(2131232398);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131232399));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131232400));
      this.p.setVisibility(0);
      this.p.setImageResource(2130838011);
      this.p.setTag(new gpy(this, 1, null));
      this.p.setOnClickListener(this);
      this.p.setContentDescription(getString(2131563180));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setContentBackground(2130837729);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setOverScrollListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a_(this.jdField_e_of_type_AndroidViewView);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setContentDescription("");
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new gpu(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setFocusable(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setLongClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView = ((NearbyTroopsMapView)this.jdField_e_of_type_AndroidViewView.findViewById(2131232405));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.setUIHandler(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity$UIHandler);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getController();
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setZoom(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getMinZoomLevel());
      this.jdField_a_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView.findViewById(2131232406);
      this.jdField_k_of_type_JavaLangString = paramIntent.getExtras().getString("leftViewText");
    }
    if ((this.jdField_k_of_type_AndroidWidgetTextView != null) && ((this.jdField_k_of_type_AndroidWidgetTextView instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      TextView localTextView = this.jdField_k_of_type_AndroidWidgetTextView;
      paramIntent = this.jdField_k_of_type_JavaLangString;
      if (this.f == 10) {
        paramIntent = getString(2131561692);
      }
      Object localObject = paramIntent;
      if (paramIntent == null) {
        localObject = getString(2131561692);
      }
      localTextView.setText((CharSequence)localObject);
    }
    if (this.x == 1) {
      a(this.j);
    }
    for (;;)
    {
      this.m.setText(getString(2131559299));
      this.m.setTag(new gpy(this, 3, null));
      this.m.setOnClickListener(this);
      this.m.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.setBuiltInZoomControls(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.setObserver(this);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(new gpy(this, 4, null));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131231643);
      this.jdField_c_of_type_AndroidViewView.setTag(new gpy(this, 3, null));
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView.setLongClickable(true);
      this.jdField_c_of_type_AndroidViewView.setOnTouchListener(new gpv(this));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131562793));
      this.jdField_c_of_type_AndroidViewView.setContentDescription(getString(2131561844));
      this.jdField_a_of_type_AndroidViewView.setTag(new gpy(this, 2, null));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131562027));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter = new NearbyTroopsExpandableListViewAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity$UIHandler);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setGroupIndicator(null);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter);
      if ((paramBoolean) || (this.x != 1)) {
        break;
      }
      b(false);
      return;
      c(2131562439, -1);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (!NetworkUtil.e(this)) {
      return false;
    }
    GeoPoint localGeoPoint = new GeoPoint(paramInt1, paramInt2);
    if (NearbyTroops.a(new GeoPoint(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int), localGeoPoint) >= 10000.0D) {}
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getHeight() >= this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getWidth()) {}
      for (int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getHeight();; i1 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getWidth())
      {
        Projection localProjection = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getProjection();
        Point localPoint = localProjection.toPixels(localGeoPoint, null);
        double d1 = NearbyTroops.a(localProjection.fromPixels(localPoint.x - i1, localPoint.y - i1), localGeoPoint);
        this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(paramInt1, paramInt2, (int)d1, bool);
        return true;
      }
      bool = true;
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
    if (!c()) {
      a(true);
    }
    return true;
  }
  
  public boolean a(long paramLong)
  {
    return (0x100000 & paramLong) != 0L;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (!NetworkUtil.e(this))
    {
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.e(2);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity$UIHandler.sendEmptyMessageDelayed(2, 1000L);
      return false;
    }
    if (paramBoolean) {
      d();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity$UIHandler.removeMessages(3);
    if (this.x == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(paramBoolean, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, 1, this.j);
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(paramBoolean, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, 1, null);
    return true;
  }
  
  public boolean a(boolean paramBoolean, Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_d_of_type_Boolean = false;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity$UIHandler = new NearbyTroopsActivity.UIHandler(this, this);
      if ((getAppRuntime() instanceof QQAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler = ((LBSHandler)((QQAppInterface)getAppRuntime()).a(3));
      }
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this, new gpq(this));
      a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    if (paramIntent != null) {}
    for (Intent localIntent = paramIntent;; localIntent = getIntent())
    {
      this.x = localIntent.getIntExtra("mode", 0);
      this.jdField_b_of_type_Int = localIntent.getIntExtra("lat", 0);
      this.jdField_c_of_type_Int = localIntent.getIntExtra("lon", 0);
      this.f = localIntent.getIntExtra("from", 0);
      if (this.x != 1) {
        break;
      }
      this.j = localIntent.getStringExtra("location_name");
      if (!TextUtils.isEmpty(this.j)) {
        break label227;
      }
      finish();
      return true;
    }
    if (this.f == 1) {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "nearbygrp_entry", "Clk_nearbygrp", 0, 0, "", "", "", "");
    }
    label227:
    a(paramBoolean, paramIntent);
    d();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity$UIHandler.sendEmptyMessageDelayed(6, 500L);
    return true;
  }
  
  protected String a_()
  {
    if (this.jdField_d_of_type_Boolean) {
      return getString(2131562048);
    }
    return super.a_();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      GeoPoint localGeoPoint = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getMapCenter();
      a(localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6());
    } while (paramInt2 == this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getMaxZoomLevel() - 1);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
  }
  
  public void b(GeoPoint paramGeoPoint) {}
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView == null) {}
    do
    {
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "nearbygrp_map", "Clk_map", 0, 0, "", "", "", "");
        c(-1, -1);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.b(true);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.requestFocusFromTouch();
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setSelection(0);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a = false;
        this.p.setVisibility(8);
        this.m.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.a(true);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        return;
      }
      this.m.setVisibility(8);
      this.p.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.a(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a = true;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    } while (((Boolean)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getTag()).booleanValue() != true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (paramInt1 != -1)
    {
      setTitle(paramInt1);
      getSupportActionBar().setTitle(paramInt1);
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, 0);
    if (paramInt2 == -1)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      localLayoutParams.topMargin = 0;
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.topMargin = Utils.a(BaseApplication.getContext(), 6.0F);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramInt2);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      getSupportActionBar().setSubtitle(paramInt2);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected boolean c()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      bool = true;
    }
    return bool;
  }
  
  protected boolean d()
  {
    return true;
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
    e();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a(true, getIntent());
    return true;
  }
  
  protected void doOnDestroy()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity$UIHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsActivity$UIHandler = null;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.onDestroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.e();
      this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter = null;
    }
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a(false, paramIntent);
  }
  
  protected void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.onPause();
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.onResume();
    }
    super.doOnResume();
  }
  
  protected void doOnStop()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.onStop();
    }
    super.doOnStop();
  }
  
  public void e() {}
  
  protected boolean e()
  {
    return true;
  }
  
  /* Error */
  public void f()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 20
    //   3: aconst_null
    //   4: astore 21
    //   6: aconst_null
    //   7: astore 19
    //   9: aconst_null
    //   10: astore 17
    //   12: aconst_null
    //   13: astore 18
    //   15: aconst_null
    //   16: astore 9
    //   18: aconst_null
    //   19: astore 15
    //   21: aconst_null
    //   22: astore 16
    //   24: aconst_null
    //   25: astore 13
    //   27: iconst_0
    //   28: istore_2
    //   29: iconst_0
    //   30: istore 6
    //   32: iconst_0
    //   33: istore 7
    //   35: iconst_0
    //   36: istore_1
    //   37: iconst_0
    //   38: istore 4
    //   40: iconst_0
    //   41: istore 5
    //   43: iconst_0
    //   44: istore_3
    //   45: new 1036	java/io/ObjectInputStream
    //   48: dup
    //   49: aload_0
    //   50: ldc 40
    //   52: invokevirtual 1040	com/tencent/mobileqq/troop/activity/NearbyTroopsActivity:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   55: invokespecial 1043	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   58: astore 12
    //   60: aload 12
    //   62: astore 11
    //   64: aload 12
    //   66: invokevirtual 1046	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   69: checkcast 334	java/util/ArrayList
    //   72: astore 8
    //   74: aload 12
    //   76: astore 11
    //   78: aload 12
    //   80: invokevirtual 1046	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   83: checkcast 334	java/util/ArrayList
    //   86: astore 10
    //   88: aload 12
    //   90: astore 11
    //   92: aload 12
    //   94: invokevirtual 1046	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   97: checkcast 334	java/util/ArrayList
    //   100: astore 9
    //   102: aload 12
    //   104: astore 11
    //   106: iload 7
    //   108: istore_3
    //   109: aload 12
    //   111: invokevirtual 1049	java/io/ObjectInputStream:readInt	()I
    //   114: istore_2
    //   115: aload 12
    //   117: astore 11
    //   119: iload_2
    //   120: istore_3
    //   121: iload_2
    //   122: istore_1
    //   123: iload_2
    //   124: istore 4
    //   126: iload_2
    //   127: istore 5
    //   129: aload 12
    //   131: invokevirtual 1049	java/io/ObjectInputStream:readInt	()I
    //   134: istore 6
    //   136: iload 6
    //   138: istore_1
    //   139: aload 12
    //   141: ifnull +1051 -> 1192
    //   144: aload 12
    //   146: invokevirtual 1050	java/io/ObjectInputStream:close	()V
    //   149: aload 8
    //   151: astore 11
    //   153: aload 9
    //   155: astore 8
    //   157: aload 11
    //   159: astore 9
    //   161: aload 9
    //   163: ifnonnull +990 -> 1153
    //   166: new 334	java/util/ArrayList
    //   169: dup
    //   170: invokespecial 1051	java/util/ArrayList:<init>	()V
    //   173: astore 9
    //   175: aload 10
    //   177: ifnonnull +973 -> 1150
    //   180: new 334	java/util/ArrayList
    //   183: dup
    //   184: invokespecial 1051	java/util/ArrayList:<init>	()V
    //   187: astore 10
    //   189: aload 8
    //   191: ifnonnull +956 -> 1147
    //   194: new 334	java/util/ArrayList
    //   197: dup
    //   198: invokespecial 1051	java/util/ArrayList:<init>	()V
    //   201: astore 8
    //   203: aload 9
    //   205: invokevirtual 337	java/util/ArrayList:size	()I
    //   208: ifne +464 -> 672
    //   211: aload 10
    //   213: invokevirtual 337	java/util/ArrayList:size	()I
    //   216: ifne +456 -> 672
    //   219: aload 8
    //   221: invokevirtual 337	java/util/ArrayList:size	()I
    //   224: ifne +448 -> 672
    //   227: return
    //   228: astore 11
    //   230: aload 11
    //   232: invokevirtual 572	java/io/IOException:printStackTrace	()V
    //   235: aload 8
    //   237: astore 11
    //   239: aload 9
    //   241: astore 8
    //   243: aload 11
    //   245: astore 9
    //   247: goto -86 -> 161
    //   250: astore 13
    //   252: aconst_null
    //   253: astore 12
    //   255: aconst_null
    //   256: astore 8
    //   258: aconst_null
    //   259: astore 9
    //   261: iconst_0
    //   262: istore_1
    //   263: aconst_null
    //   264: astore 10
    //   266: aload 12
    //   268: astore 11
    //   270: aload 13
    //   272: invokevirtual 1052	java/io/StreamCorruptedException:printStackTrace	()V
    //   275: aload 12
    //   277: ifnull +892 -> 1169
    //   280: aload 12
    //   282: invokevirtual 1050	java/io/ObjectInputStream:close	()V
    //   285: aload 9
    //   287: astore 11
    //   289: aload 10
    //   291: astore 9
    //   293: iload_1
    //   294: istore_2
    //   295: aload 8
    //   297: astore 10
    //   299: iconst_0
    //   300: istore_1
    //   301: aload 11
    //   303: astore 8
    //   305: goto -144 -> 161
    //   308: astore 11
    //   310: aload 11
    //   312: invokevirtual 572	java/io/IOException:printStackTrace	()V
    //   315: aload 9
    //   317: astore 11
    //   319: aload 10
    //   321: astore 9
    //   323: iload_1
    //   324: istore_2
    //   325: aload 8
    //   327: astore 10
    //   329: iconst_0
    //   330: istore_1
    //   331: aload 11
    //   333: astore 8
    //   335: goto -174 -> 161
    //   338: astore 10
    //   340: aconst_null
    //   341: astore 14
    //   343: aload 19
    //   345: astore 8
    //   347: aload 14
    //   349: astore 11
    //   351: aload 10
    //   353: invokevirtual 573	java/io/FileNotFoundException:printStackTrace	()V
    //   356: aload 8
    //   358: astore 11
    //   360: aload 9
    //   362: astore 10
    //   364: aload 13
    //   366: astore 12
    //   368: iload_3
    //   369: istore_2
    //   370: aload 14
    //   372: ifnull +784 -> 1156
    //   375: aload 14
    //   377: invokevirtual 1050	java/io/ObjectInputStream:close	()V
    //   380: iconst_0
    //   381: istore_1
    //   382: aload 8
    //   384: astore 11
    //   386: aload 13
    //   388: astore 8
    //   390: aload 9
    //   392: astore 10
    //   394: aload 11
    //   396: astore 9
    //   398: iload_3
    //   399: istore_2
    //   400: goto -239 -> 161
    //   403: astore 10
    //   405: aload 10
    //   407: invokevirtual 572	java/io/IOException:printStackTrace	()V
    //   410: iconst_0
    //   411: istore_1
    //   412: aload 8
    //   414: astore 11
    //   416: aload 13
    //   418: astore 8
    //   420: aload 9
    //   422: astore 10
    //   424: aload 11
    //   426: astore 9
    //   428: iload_3
    //   429: istore_2
    //   430: goto -269 -> 161
    //   433: astore 10
    //   435: aconst_null
    //   436: astore 14
    //   438: iload_2
    //   439: istore_3
    //   440: aload 15
    //   442: astore 13
    //   444: aload 17
    //   446: astore 9
    //   448: aload 20
    //   450: astore 8
    //   452: aload 14
    //   454: astore 11
    //   456: aload 10
    //   458: invokevirtual 572	java/io/IOException:printStackTrace	()V
    //   461: aload 8
    //   463: astore 11
    //   465: aload 9
    //   467: astore 10
    //   469: aload 13
    //   471: astore 12
    //   473: iload_3
    //   474: istore_2
    //   475: aload 14
    //   477: ifnull +679 -> 1156
    //   480: aload 14
    //   482: invokevirtual 1050	java/io/ObjectInputStream:close	()V
    //   485: iconst_0
    //   486: istore_1
    //   487: aload 8
    //   489: astore 11
    //   491: aload 13
    //   493: astore 8
    //   495: aload 9
    //   497: astore 10
    //   499: aload 11
    //   501: astore 9
    //   503: iload_3
    //   504: istore_2
    //   505: goto -344 -> 161
    //   508: astore 10
    //   510: aload 10
    //   512: invokevirtual 572	java/io/IOException:printStackTrace	()V
    //   515: iconst_0
    //   516: istore_1
    //   517: aload 8
    //   519: astore 11
    //   521: aload 13
    //   523: astore 8
    //   525: aload 9
    //   527: astore 10
    //   529: aload 11
    //   531: astore 9
    //   533: iload_3
    //   534: istore_2
    //   535: goto -374 -> 161
    //   538: astore 10
    //   540: aconst_null
    //   541: astore 14
    //   543: iload 6
    //   545: istore_3
    //   546: aload 16
    //   548: astore 13
    //   550: aload 18
    //   552: astore 9
    //   554: aload 21
    //   556: astore 8
    //   558: aload 14
    //   560: astore 11
    //   562: aload 10
    //   564: invokevirtual 1053	java/lang/ClassNotFoundException:printStackTrace	()V
    //   567: aload 8
    //   569: astore 11
    //   571: aload 9
    //   573: astore 10
    //   575: aload 13
    //   577: astore 12
    //   579: iload_3
    //   580: istore_2
    //   581: aload 14
    //   583: ifnull +573 -> 1156
    //   586: aload 14
    //   588: invokevirtual 1050	java/io/ObjectInputStream:close	()V
    //   591: iconst_0
    //   592: istore_1
    //   593: aload 8
    //   595: astore 11
    //   597: aload 13
    //   599: astore 8
    //   601: aload 9
    //   603: astore 10
    //   605: aload 11
    //   607: astore 9
    //   609: iload_3
    //   610: istore_2
    //   611: goto -450 -> 161
    //   614: astore 10
    //   616: aload 10
    //   618: invokevirtual 572	java/io/IOException:printStackTrace	()V
    //   621: iconst_0
    //   622: istore_1
    //   623: aload 8
    //   625: astore 11
    //   627: aload 13
    //   629: astore 8
    //   631: aload 9
    //   633: astore 10
    //   635: aload 11
    //   637: astore 9
    //   639: iload_3
    //   640: istore_2
    //   641: goto -480 -> 161
    //   644: astore 8
    //   646: aconst_null
    //   647: astore 11
    //   649: aload 11
    //   651: ifnull +8 -> 659
    //   654: aload 11
    //   656: invokevirtual 1050	java/io/ObjectInputStream:close	()V
    //   659: aload 8
    //   661: athrow
    //   662: astore 9
    //   664: aload 9
    //   666: invokevirtual 572	java/io/IOException:printStackTrace	()V
    //   669: goto -10 -> 659
    //   672: aload_0
    //   673: iconst_1
    //   674: putfield 106	com/tencent/mobileqq/troop/activity/NearbyTroopsActivity:jdField_c_of_type_Boolean	Z
    //   677: iload_2
    //   678: ifeq +48 -> 726
    //   681: iload_1
    //   682: ifeq +44 -> 726
    //   685: aload_0
    //   686: getfield 710	com/tencent/mobileqq/troop/activity/NearbyTroopsActivity:jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController	Lcom/tencent/tencentmap/mapsdk/map/MapController;
    //   689: aload_0
    //   690: getfield 700	com/tencent/mobileqq/troop/activity/NearbyTroopsActivity:jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView	Lcom/tencent/mobileqq/troop/widget/NearbyTroopsMapView;
    //   693: invokevirtual 928	com/tencent/mobileqq/troop/widget/NearbyTroopsMapView:getMaxZoomLevel	()I
    //   696: iconst_1
    //   697: isub
    //   698: invokevirtual 719	com/tencent/tencentmap/mapsdk/map/MapController:setZoom	(I)I
    //   701: pop
    //   702: aload_0
    //   703: getfield 710	com/tencent/mobileqq/troop/activity/NearbyTroopsActivity:jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController	Lcom/tencent/tencentmap/mapsdk/map/MapController;
    //   706: new 482	com/tencent/tencentmap/mapsdk/map/GeoPoint
    //   709: dup
    //   710: iload_2
    //   711: iload_1
    //   712: invokespecial 803	com/tencent/tencentmap/mapsdk/map/GeoPoint:<init>	(II)V
    //   715: invokevirtual 1056	com/tencent/tencentmap/mapsdk/map/MapController:setCenter	(Lcom/tencent/tencentmap/mapsdk/map/GeoPoint;)V
    //   718: aload_0
    //   719: getfield 622	com/tencent/mobileqq/troop/activity/NearbyTroopsActivity:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   722: iconst_0
    //   723: invokevirtual 677	android/view/View:setVisibility	(I)V
    //   726: aload 9
    //   728: invokevirtual 1060	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   731: astore 11
    //   733: aload 11
    //   735: invokeinterface 1065 1 0
    //   740: ifeq +65 -> 805
    //   743: aload 11
    //   745: invokeinterface 1068 1 0
    //   750: checkcast 1070	NearbyGroup/GroupInfo
    //   753: getfield 1074	NearbyGroup/GroupInfo:dwGroupFlagExt	J
    //   756: ldc2_w 852
    //   759: land
    //   760: lconst_0
    //   761: lcmp
    //   762: ifeq -29 -> 733
    //   765: aload_0
    //   766: getfield 184	com/tencent/mobileqq/troop/activity/NearbyTroopsActivity:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   769: ldc_w 1076
    //   772: ldc_w 534
    //   775: ldc_w 534
    //   778: ldc_w 1078
    //   781: ldc_w 1080
    //   784: bipush 45
    //   786: iconst_0
    //   787: ldc_w 534
    //   790: ldc_w 534
    //   793: ldc_w 534
    //   796: ldc_w 534
    //   799: invokestatic 543	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   802: goto -69 -> 733
    //   805: aload_0
    //   806: getfield 775	com/tencent/mobileqq/troop/activity/NearbyTroopsActivity:jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter	Lcom/tencent/mobileqq/troop/data/NearbyTroopsExpandableListViewAdapter;
    //   809: aload 9
    //   811: aload 10
    //   813: aload 8
    //   815: invokevirtual 1083	com/tencent/mobileqq/troop/data/NearbyTroopsExpandableListViewAdapter:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    //   818: aload_0
    //   819: getfield 594	com/tencent/mobileqq/troop/activity/NearbyTroopsActivity:jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView	Lcom/tencent/mobileqq/troop/widget/NearbyTroopsExpandableListView;
    //   822: iconst_1
    //   823: invokevirtual 857	com/tencent/mobileqq/troop/widget/NearbyTroopsExpandableListView:a	(Z)V
    //   826: return
    //   827: astore 8
    //   829: goto -180 -> 649
    //   832: astore 10
    //   834: aload 21
    //   836: astore 8
    //   838: aload 18
    //   840: astore 9
    //   842: aload 16
    //   844: astore 13
    //   846: iload 6
    //   848: istore_3
    //   849: aload 12
    //   851: astore 14
    //   853: goto -295 -> 558
    //   856: astore 10
    //   858: aload 18
    //   860: astore 9
    //   862: aload 16
    //   864: astore 13
    //   866: iload 6
    //   868: istore_3
    //   869: aload 12
    //   871: astore 14
    //   873: goto -315 -> 558
    //   876: astore 11
    //   878: aload 10
    //   880: astore 9
    //   882: aload 11
    //   884: astore 10
    //   886: aload 16
    //   888: astore 13
    //   890: iload 6
    //   892: istore_3
    //   893: aload 12
    //   895: astore 14
    //   897: goto -339 -> 558
    //   900: astore 11
    //   902: aload 9
    //   904: astore 13
    //   906: aload 10
    //   908: astore 9
    //   910: aload 11
    //   912: astore 10
    //   914: aload 12
    //   916: astore 14
    //   918: goto -360 -> 558
    //   921: astore 10
    //   923: aload 20
    //   925: astore 8
    //   927: aload 17
    //   929: astore 9
    //   931: aload 15
    //   933: astore 13
    //   935: iload_2
    //   936: istore_3
    //   937: aload 12
    //   939: astore 14
    //   941: goto -489 -> 452
    //   944: astore 10
    //   946: aload 17
    //   948: astore 9
    //   950: aload 15
    //   952: astore 13
    //   954: iload_2
    //   955: istore_3
    //   956: aload 12
    //   958: astore 14
    //   960: goto -508 -> 452
    //   963: astore 11
    //   965: aload 10
    //   967: astore 9
    //   969: aload 11
    //   971: astore 10
    //   973: aload 15
    //   975: astore 13
    //   977: iload_2
    //   978: istore_3
    //   979: aload 12
    //   981: astore 14
    //   983: goto -531 -> 452
    //   986: astore 11
    //   988: aload 9
    //   990: astore 13
    //   992: aload 10
    //   994: astore 9
    //   996: aload 11
    //   998: astore 10
    //   1000: iload_1
    //   1001: istore_3
    //   1002: aload 12
    //   1004: astore 14
    //   1006: goto -554 -> 452
    //   1009: astore 10
    //   1011: aload 19
    //   1013: astore 8
    //   1015: aload 12
    //   1017: astore 14
    //   1019: goto -672 -> 347
    //   1022: astore 10
    //   1024: aload 12
    //   1026: astore 14
    //   1028: goto -681 -> 347
    //   1031: astore 11
    //   1033: aload 10
    //   1035: astore 9
    //   1037: aload 11
    //   1039: astore 10
    //   1041: aload 12
    //   1043: astore 14
    //   1045: goto -698 -> 347
    //   1048: astore 11
    //   1050: aload 9
    //   1052: astore 13
    //   1054: aload 10
    //   1056: astore 9
    //   1058: aload 11
    //   1060: astore 10
    //   1062: iload 4
    //   1064: istore_3
    //   1065: aload 12
    //   1067: astore 14
    //   1069: goto -722 -> 347
    //   1072: astore 13
    //   1074: aconst_null
    //   1075: astore 10
    //   1077: iconst_0
    //   1078: istore_1
    //   1079: aconst_null
    //   1080: astore 9
    //   1082: aconst_null
    //   1083: astore 8
    //   1085: goto -819 -> 266
    //   1088: astore 13
    //   1090: iconst_0
    //   1091: istore_1
    //   1092: aload 8
    //   1094: astore 10
    //   1096: aconst_null
    //   1097: astore 9
    //   1099: aconst_null
    //   1100: astore 8
    //   1102: goto -836 -> 266
    //   1105: astore 13
    //   1107: aconst_null
    //   1108: astore 9
    //   1110: iconst_0
    //   1111: istore_1
    //   1112: aload 8
    //   1114: astore 11
    //   1116: aload 10
    //   1118: astore 8
    //   1120: aload 11
    //   1122: astore 10
    //   1124: goto -858 -> 266
    //   1127: astore 13
    //   1129: iload 5
    //   1131: istore_1
    //   1132: aload 8
    //   1134: astore 11
    //   1136: aload 10
    //   1138: astore 8
    //   1140: aload 11
    //   1142: astore 10
    //   1144: goto -878 -> 266
    //   1147: goto -944 -> 203
    //   1150: goto -961 -> 189
    //   1153: goto -978 -> 175
    //   1156: aload 12
    //   1158: astore 8
    //   1160: iconst_0
    //   1161: istore_1
    //   1162: aload 11
    //   1164: astore 9
    //   1166: goto -1005 -> 161
    //   1169: aload 9
    //   1171: astore 11
    //   1173: aload 10
    //   1175: astore 9
    //   1177: iload_1
    //   1178: istore_2
    //   1179: aload 8
    //   1181: astore 10
    //   1183: iconst_0
    //   1184: istore_1
    //   1185: aload 11
    //   1187: astore 8
    //   1189: goto -1028 -> 161
    //   1192: aload 8
    //   1194: astore 11
    //   1196: aload 9
    //   1198: astore 8
    //   1200: aload 11
    //   1202: astore 9
    //   1204: goto -1043 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1207	0	this	NearbyTroopsActivity
    //   36	1149	1	i1	int
    //   28	1151	2	i2	int
    //   44	1021	3	i3	int
    //   38	1025	4	i4	int
    //   41	1089	5	i5	int
    //   30	861	6	i6	int
    //   33	74	7	i7	int
    //   72	558	8	localObject1	Object
    //   644	170	8	localArrayList	ArrayList
    //   827	1	8	localObject2	Object
    //   836	363	8	localObject3	Object
    //   16	622	9	localObject4	Object
    //   662	148	9	localIOException1	java.io.IOException
    //   840	363	9	localObject5	Object
    //   86	242	10	localObject6	Object
    //   338	14	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   362	31	10	localObject7	Object
    //   403	3	10	localIOException2	java.io.IOException
    //   422	1	10	localObject8	Object
    //   433	24	10	localIOException3	java.io.IOException
    //   467	31	10	localObject9	Object
    //   508	3	10	localIOException4	java.io.IOException
    //   527	1	10	localObject10	Object
    //   538	25	10	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   573	31	10	localObject11	Object
    //   614	3	10	localIOException5	java.io.IOException
    //   633	179	10	localObject12	Object
    //   832	1	10	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   856	23	10	localClassNotFoundException3	java.lang.ClassNotFoundException
    //   884	29	10	localClassNotFoundException4	java.lang.ClassNotFoundException
    //   921	1	10	localIOException6	java.io.IOException
    //   944	22	10	localIOException7	java.io.IOException
    //   971	28	10	localIOException8	java.io.IOException
    //   1009	1	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   1022	12	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   1039	143	10	localObject13	Object
    //   62	96	11	localObject14	Object
    //   228	3	11	localIOException9	java.io.IOException
    //   237	65	11	localObject15	Object
    //   308	3	11	localIOException10	java.io.IOException
    //   317	427	11	localObject16	Object
    //   876	7	11	localClassNotFoundException5	java.lang.ClassNotFoundException
    //   900	11	11	localClassNotFoundException6	java.lang.ClassNotFoundException
    //   963	7	11	localIOException11	java.io.IOException
    //   986	11	11	localIOException12	java.io.IOException
    //   1031	7	11	localFileNotFoundException4	java.io.FileNotFoundException
    //   1048	11	11	localFileNotFoundException5	java.io.FileNotFoundException
    //   1114	87	11	localObject17	Object
    //   58	1099	12	localObject18	Object
    //   25	1	13	localObject19	Object
    //   250	167	13	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   442	611	13	localObject20	Object
    //   1072	1	13	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   1088	1	13	localStreamCorruptedException3	java.io.StreamCorruptedException
    //   1105	1	13	localStreamCorruptedException4	java.io.StreamCorruptedException
    //   1127	1	13	localStreamCorruptedException5	java.io.StreamCorruptedException
    //   341	727	14	localObject21	Object
    //   19	955	15	localObject22	Object
    //   22	865	16	localObject23	Object
    //   10	937	17	localObject24	Object
    //   13	846	18	localObject25	Object
    //   7	1005	19	localObject26	Object
    //   1	923	20	localObject27	Object
    //   4	831	21	localObject28	Object
    // Exception table:
    //   from	to	target	type
    //   144	149	228	java/io/IOException
    //   45	60	250	java/io/StreamCorruptedException
    //   280	285	308	java/io/IOException
    //   45	60	338	java/io/FileNotFoundException
    //   375	380	403	java/io/IOException
    //   45	60	433	java/io/IOException
    //   480	485	508	java/io/IOException
    //   45	60	538	java/lang/ClassNotFoundException
    //   586	591	614	java/io/IOException
    //   45	60	644	finally
    //   654	659	662	java/io/IOException
    //   64	74	827	finally
    //   78	88	827	finally
    //   92	102	827	finally
    //   109	115	827	finally
    //   129	136	827	finally
    //   270	275	827	finally
    //   351	356	827	finally
    //   456	461	827	finally
    //   562	567	827	finally
    //   64	74	832	java/lang/ClassNotFoundException
    //   78	88	856	java/lang/ClassNotFoundException
    //   92	102	876	java/lang/ClassNotFoundException
    //   109	115	900	java/lang/ClassNotFoundException
    //   129	136	900	java/lang/ClassNotFoundException
    //   64	74	921	java/io/IOException
    //   78	88	944	java/io/IOException
    //   92	102	963	java/io/IOException
    //   109	115	986	java/io/IOException
    //   129	136	986	java/io/IOException
    //   64	74	1009	java/io/FileNotFoundException
    //   78	88	1022	java/io/FileNotFoundException
    //   92	102	1031	java/io/FileNotFoundException
    //   109	115	1048	java/io/FileNotFoundException
    //   129	136	1048	java/io/FileNotFoundException
    //   64	74	1072	java/io/StreamCorruptedException
    //   78	88	1088	java/io/StreamCorruptedException
    //   92	102	1105	java/io/StreamCorruptedException
    //   109	115	1127	java/io/StreamCorruptedException
    //   129	136	1127	java/io/StreamCorruptedException
  }
  
  public void g()
  {
    if (this.x == 1)
    {
      a(true);
      return;
    }
    f();
    a(true);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof gpy))) {}
    do
    {
      do
      {
        return;
        switch (((gpy)paramView.getTag()).jdField_a_of_type_Int)
        {
        default: 
          return;
        case 1: 
          c(true);
          return;
        }
      } while (this.jdField_b_of_type_Boolean);
      b(true);
      return;
    } while (!this.jdField_b_of_type_Boolean);
    b(false);
    return;
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "nearbygrp_map", "Clk_back", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Gpz = new gpz(this, 1, 1, 1, 8);
    SOSOMapLBSApi.getInstance().verifyRegCode("QQ2013", "LWPAH-5CHEJ-Y6CR2-AQPLX-IV2JQ");
    SOSOMapLBSApi.getInstance().requestLocationUpdate(getApplicationContext(), this.jdField_a_of_type_Gpz);
  }
  
  protected void onRestart()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.onRestart();
    }
    super.onRestart();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setContentView(int paramInt)
  {
    this.jdField_c_of_type_Float = getResources().getDisplayMetrics().density;
    super.g(paramInt);
    getIntent();
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130840102));
    if (this.jdField_k_of_type_AndroidWidgetTextView != null) {
      return;
    }
    b((ViewGroup)findViewById(2131231447));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231375));
    this.jdField_d_of_type_AndroidWidgetTextView = new FakeTextView(this);
    this.m = ((TextView)findViewById(2131231379));
    this.p = ((ImageView)findViewById(2131231460));
    b(this.m);
    b(this.p);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this);
    this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231455));
    this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    b(this.jdField_k_of_type_AndroidWidgetTextView);
  }
  
  public void setTitle(int paramInt)
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramInt);
    super.setTitle(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    super.setTitle(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.NearbyTroopsActivity
 * JD-Core Version:    0.7.0.1
 */