package com.tencent.mobileqq.troop.activity;

import NearbyGroup.RspActivity;
import NearbyGroup.RspGetNearbyGroup;
import NearbyGroup.RspHotGrp;
import NearbyGroup.RspTopic;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.LBSObserver;
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
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import eif;
import eig;
import eih;
import eij;
import eik;
import eil;
import eim;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.cs.nearby_troop_activity.nearby_troop_activity.ActivityDigest;
import tencent.im.cs.nearby_troop_activity.nearby_troop_activity.RspBody;
import tencent.im.cs.nearby_troop_hot.nearby_troop_hot.HotQunMsg;
import tencent.im.cs.nearby_troop_hot.nearby_troop_hot.HotQunRsp;
import tencent.im.cs.nearby_troop_hot.nearby_troop_hot.QunInfo;
import tencent.im.cs.nearby_troop_hot.nearby_troop_hot.RetInfo;
import tencent.im.cs.nearby_troop_post.nearby_troop_post.RspBody;
import tencent.im.cs.nearby_troop_post.nearby_troop_post.RspNearbyPostInfo;

public class NearbyTroopsView
  extends NearbyTroopsBaseView
  implements View.OnClickListener, View.OnTouchListener, NearbyTroopsMapView.NearbyTroopsMapViewObserver, OverScrollViewListener
{
  public static final String b = "NearbyTroopsActivity";
  public static final String c = "near_troop_last_refresh_time";
  public static final boolean c = true;
  public static final String d = "lat";
  public static final String e = "lon";
  public static final String f = "from";
  public static final int g = 1000;
  public static final String g = "mode";
  public static final int h = 800;
  public static final String h = "_nearby_troops_5_0.nb";
  public static final int i = 2;
  public static final String i = "location_name";
  public static final int j = 3;
  public static final int k = 4;
  public static final int l = 0;
  public static final int m = 1;
  public static final int n = 1;
  public static final int o = 2;
  public static final int p = 3;
  public static final int q = 4;
  public static final int r = 5;
  public static final int s = 6;
  public static final int t = 7;
  public static final int u = 0;
  public static final int v = 1;
  public Context a;
  public GestureDetector a;
  Button jdField_a_of_type_AndroidWidgetButton;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  public FriendListObserver a;
  public LBSObserver a;
  public NearbyTroopsView.UIHandler a;
  public NearbyTroopsExpandableListViewAdapter a;
  public NearbyTroopsExpandableListView a;
  public NearbyTroopsMapView a;
  public PullRefreshHeader a;
  public MapController a;
  eim jdField_a_of_type_Eim;
  public String a;
  public ArrayList a;
  public String[] a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  Button jdField_b_of_type_AndroidWidgetButton;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public ArrayList b;
  public int c;
  View c;
  public ArrayList c;
  public int d;
  View d;
  public boolean d;
  public int e;
  View e;
  public boolean e;
  public int f;
  public View f;
  boolean f;
  public boolean g = false;
  public boolean h = false;
  public String j;
  public int w = 0;
  
  public NearbyTroopsView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new eig(this);
    this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new eih(this);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().getPreferences().getLong("near_troop_last_refresh_time", 0L);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    j();
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().getPreferences().edit().putLong("near_troop_last_refresh_time", paramLong).commit();
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
                GroupAreaWrapper.ActivityInfo localActivityInfo = new GroupAreaWrapper.ActivityInfo(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a());
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
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
      return;
    }
    nearby_troop_hot.HotQunMsg localHotQunMsg = new nearby_troop_hot.HotQunMsg();
    try
    {
      localHotQunMsg.mergeFrom(paramRspGetNearbyGroup.stRspHotGrp.strRspHotGrp);
      if ((localHotQunMsg == null) || (!localHotQunMsg.msg_rsp_body.has()))
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
        return;
      }
    }
    catch (Exception paramRspGetNearbyGroup)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
      return;
    }
    if ((localHotQunMsg.msg_rsp_body.ret_info == null) || (!localHotQunMsg.msg_rsp_body.ret_info.has()) || (localHotQunMsg.msg_rsp_body.qun_info == null) || (!localHotQunMsg.msg_rsp_body.qun_info.has()))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
      return;
    }
    if (((nearby_troop_hot.RetInfo)localHotQunMsg.msg_rsp_body.ret_info.get()).ret_code.get() != 0)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
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
        GroupAreaWrapper.TopicInfo localTopicInfo = new GroupAreaWrapper.TopicInfo(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a());
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
  
  public void a(Intent paramIntent)
  {
    a(false, paramIntent);
  }
  
  public void a(Intent paramIntent, NearbyTroopsBaseView.INearbyTroopContext paramINearbyTroopContext)
  {
    super.a(paramIntent, paramINearbyTroopContext);
    a(true, paramIntent);
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
  
  void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    this.jdField_a_of_type_JavaLangString = paramString3;
    if (!this.jdField_d_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    l();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(true));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "hot", "exp", 0, 0, "", "", "", "");
  }
  
  /* Error */
  public void a(ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 495	java/io/ObjectOutputStream
    //   3: dup
    //   4: aload_0
    //   5: getfield 127	com/tencent/mobileqq/troop/activity/NearbyTroopsView:jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsBaseView$INearbyTroopContext;
    //   8: invokeinterface 498 1 0
    //   13: ldc 39
    //   15: iconst_0
    //   16: invokevirtual 504	android/app/Activity:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   19: invokespecial 507	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore 7
    //   24: aload 7
    //   26: astore 6
    //   28: aload 7
    //   30: aload_1
    //   31: invokevirtual 510	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   34: aload 7
    //   36: astore 6
    //   38: aload 7
    //   40: aload_2
    //   41: invokevirtual 510	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   44: aload 7
    //   46: astore 6
    //   48: aload 7
    //   50: aload_3
    //   51: invokevirtual 510	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   54: aload 7
    //   56: astore 6
    //   58: aload 7
    //   60: iload 4
    //   62: invokevirtual 513	java/io/ObjectOutputStream:writeInt	(I)V
    //   65: aload 7
    //   67: astore 6
    //   69: aload 7
    //   71: iload 5
    //   73: invokevirtual 513	java/io/ObjectOutputStream:writeInt	(I)V
    //   76: aload 7
    //   78: astore 6
    //   80: aload 7
    //   82: invokevirtual 516	java/io/ObjectOutputStream:flush	()V
    //   85: aload 7
    //   87: ifnull +8 -> 95
    //   90: aload 7
    //   92: invokevirtual 519	java/io/ObjectOutputStream:close	()V
    //   95: return
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 522	java/io/IOException:printStackTrace	()V
    //   101: return
    //   102: astore_1
    //   103: aconst_null
    //   104: astore 7
    //   106: aload 7
    //   108: astore 6
    //   110: aload_1
    //   111: invokevirtual 523	java/io/FileNotFoundException:printStackTrace	()V
    //   114: aload 7
    //   116: ifnull -21 -> 95
    //   119: aload 7
    //   121: invokevirtual 519	java/io/ObjectOutputStream:close	()V
    //   124: return
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual 522	java/io/IOException:printStackTrace	()V
    //   130: return
    //   131: astore_1
    //   132: aconst_null
    //   133: astore 7
    //   135: aload 7
    //   137: astore 6
    //   139: aload_1
    //   140: invokevirtual 522	java/io/IOException:printStackTrace	()V
    //   143: aload 7
    //   145: ifnull -50 -> 95
    //   148: aload 7
    //   150: invokevirtual 519	java/io/ObjectOutputStream:close	()V
    //   153: return
    //   154: astore_1
    //   155: aload_1
    //   156: invokevirtual 522	java/io/IOException:printStackTrace	()V
    //   159: return
    //   160: astore_1
    //   161: aconst_null
    //   162: astore 6
    //   164: aload 6
    //   166: ifnull +8 -> 174
    //   169: aload 6
    //   171: invokevirtual 519	java/io/ObjectOutputStream:close	()V
    //   174: aload_1
    //   175: athrow
    //   176: astore_2
    //   177: aload_2
    //   178: invokevirtual 522	java/io/IOException:printStackTrace	()V
    //   181: goto -7 -> 174
    //   184: astore_1
    //   185: goto -21 -> 164
    //   188: astore_1
    //   189: goto -54 -> 135
    //   192: astore_1
    //   193: goto -87 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	NearbyTroopsView
    //   0	196	1	paramArrayList1	ArrayList
    //   0	196	2	paramArrayList2	ArrayList
    //   0	196	3	paramArrayList3	ArrayList
    //   0	196	4	paramInt1	int
    //   0	196	5	paramInt2	int
    //   26	144	6	localObjectOutputStream1	java.io.ObjectOutputStream
    //   22	127	7	localObjectOutputStream2	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   90	95	96	java/io/IOException
    //   0	24	102	java/io/FileNotFoundException
    //   119	124	125	java/io/IOException
    //   0	24	131	java/io/IOException
    //   148	153	154	java/io/IOException
    //   0	24	160	finally
    //   169	174	176	java/io/IOException
    //   28	34	184	finally
    //   38	44	184	finally
    //   48	54	184	finally
    //   58	65	184	finally
    //   69	76	184	finally
    //   80	85	184	finally
    //   110	114	184	finally
    //   139	143	184	finally
    //   28	34	188	java/io/IOException
    //   38	44	188	java/io/IOException
    //   48	54	188	java/io/IOException
    //   58	65	188	java/io/IOException
    //   69	76	188	java/io/IOException
    //   80	85	188	java/io/IOException
    //   28	34	192	java/io/FileNotFoundException
    //   38	44	192	java/io/FileNotFoundException
    //   48	54	192	java/io/FileNotFoundException
    //   58	65	192	java/io/FileNotFoundException
    //   69	76	192	java/io/FileNotFoundException
    //   80	85	192	java/io/FileNotFoundException
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)) {}
    }
    while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView == null)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendEmptyMessageDelayed(3, 800L);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      a(System.currentTimeMillis());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(1, this.jdField_a_of_type_AndroidContentContext.getString(2131363353));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.B();
  }
  
  public void a(boolean paramBoolean, Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    if (paramBoolean)
    {
      a(2130903318);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903274, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView, false));
      this.jdField_f_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903320, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView, false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView = ((NearbyTroopsExpandableListView)findViewById(2131297688));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_f_of_type_AndroidViewView.findViewById(2131297703));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131297705));
      this.jdField_c_of_type_AndroidViewView = findViewById(2131297689);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131297690));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131297691));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_f_of_type_AndroidViewView.findViewById(2131297706));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setContentBackground(2130837633);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setOverScrollListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a_(this.jdField_f_of_type_AndroidViewView);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.setContentDescription("");
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new eij(this));
      TextView localTextView = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a();
      if (localTextView != null)
      {
        localTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131362834));
        localTextView.setTag(new eil(this, 3, null));
        localTextView.setOnClickListener(this);
        localTextView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setFocusable(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setLongClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView = ((NearbyTroopsMapView)this.jdField_f_of_type_AndroidViewView.findViewById(2131297701));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.setUIHandler(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getController();
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setZoom(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.getMinZoomLevel());
      this.jdField_b_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131297702);
    }
    if (this.w == 1) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(this.j);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.setBuiltInZoomControls(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.setObserver(null);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.setObserver(this);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(new eil(this, 4, null));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView = findViewById(2131297080);
      this.jdField_d_of_type_AndroidViewView.setTag(new eil(this, 3, null));
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView.setLongClickable(true);
      this.jdField_d_of_type_AndroidViewView.setOnTouchListener(new eik(this));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131362833));
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131362833));
      this.jdField_d_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131362834));
      this.jdField_b_of_type_AndroidViewView.setTag(new eil(this, 2, null));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131362835));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter = new NearbyTroopsExpandableListViewAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler, this, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.a(54, 54);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setGroupIndicator(null);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.setFaceAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter);
      if ((paramBoolean) || (this.w != 1)) {
        break;
      }
      b(false);
      return;
      paramIntent = paramIntent.getStringExtra("config_res_plugin_item_name");
      if (!TextUtils.isEmpty(paramIntent)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(paramIntent);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(2131362829, -1);
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (!NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext)) {
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
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramInt1, paramInt2, (int)d1, bool);
        return true;
      }
      bool = true;
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a()) {
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
    if (!NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext))
    {
      if (!this.jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.d(2);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendEmptyMessageDelayed(2, 1000L);
      return false;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.removeMessages(3);
    if (this.w == 1)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramBoolean, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, 1, this.j);
      return true;
    }
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramBoolean, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, 1, null);
    return true;
  }
  
  public boolean a(boolean paramBoolean, Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a();
    this.jdField_f_of_type_Boolean = false;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler = new NearbyTroopsView.UIHandler(this, this);
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new eif(this));
    }
    if (paramIntent != null) {}
    for (;;)
    {
      this.w = paramIntent.getIntExtra("mode", 0);
      this.jdField_b_of_type_Int = paramIntent.getIntExtra("lat", 0);
      this.jdField_c_of_type_Int = paramIntent.getIntExtra("lon", 0);
      this.jdField_f_of_type_Int = paramIntent.getIntExtra("from", 0);
      if (this.w != 1) {
        break;
      }
      this.j = paramIntent.getStringExtra("location_name");
      if (!TextUtils.isEmpty(this.j)) {
        break;
      }
      i();
      return true;
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().getIntent();
    }
    a(paramBoolean, paramIntent);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.b();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendEmptyMessage(6);
    return true;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (!this.jdField_d_of_type_Boolean) {}
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
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView == null) {
      return;
    }
    if (this.jdField_d_of_type_Boolean)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "nearbygrp_map", "Clk_map", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(-1, -1);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.b(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.requestFocusFromTouch();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setSelection(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a = false;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.a(true);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    while ((this.jdField_d_of_type_Boolean) && (this.w == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.b(0);
      return;
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.a(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a = true;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (((Boolean)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getTag()).booleanValue() == true) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      if (this.g) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      } else {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.b(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(0);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.g();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.onResume();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.onPause();
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.onStop();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.onRestart();
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    SOSOMapLBSApi.getInstance().removeLocationUpdate();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler = null;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView.onDestroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.h();
      this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter = null;
    }
  }
  
  public void j() {}
  
  /* Error */
  public void k()
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
    //   45: new 926	java/io/ObjectInputStream
    //   48: dup
    //   49: aload_0
    //   50: getfield 88	com/tencent/mobileqq/troop/activity/NearbyTroopsView:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   53: ldc 39
    //   55: invokevirtual 930	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   58: invokespecial 933	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore 12
    //   63: aload 12
    //   65: astore 11
    //   67: aload 12
    //   69: invokevirtual 936	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   72: checkcast 291	java/util/ArrayList
    //   75: astore 8
    //   77: aload 12
    //   79: astore 11
    //   81: aload 12
    //   83: invokevirtual 936	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   86: checkcast 291	java/util/ArrayList
    //   89: astore 10
    //   91: aload 12
    //   93: astore 11
    //   95: aload 12
    //   97: invokevirtual 936	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   100: checkcast 291	java/util/ArrayList
    //   103: astore 9
    //   105: aload 12
    //   107: astore 11
    //   109: iload 7
    //   111: istore_3
    //   112: aload 12
    //   114: invokevirtual 939	java/io/ObjectInputStream:readInt	()I
    //   117: istore_2
    //   118: aload 12
    //   120: astore 11
    //   122: iload_2
    //   123: istore_3
    //   124: iload_2
    //   125: istore_1
    //   126: iload_2
    //   127: istore 4
    //   129: iload_2
    //   130: istore 5
    //   132: aload 12
    //   134: invokevirtual 939	java/io/ObjectInputStream:readInt	()I
    //   137: istore 6
    //   139: iload 6
    //   141: istore_1
    //   142: aload 12
    //   144: ifnull +1056 -> 1200
    //   147: aload 12
    //   149: invokevirtual 940	java/io/ObjectInputStream:close	()V
    //   152: aload 8
    //   154: astore 11
    //   156: aload 9
    //   158: astore 8
    //   160: aload 11
    //   162: astore 9
    //   164: aload 9
    //   166: ifnonnull +995 -> 1161
    //   169: new 291	java/util/ArrayList
    //   172: dup
    //   173: invokespecial 941	java/util/ArrayList:<init>	()V
    //   176: astore 9
    //   178: aload 10
    //   180: ifnonnull +978 -> 1158
    //   183: new 291	java/util/ArrayList
    //   186: dup
    //   187: invokespecial 941	java/util/ArrayList:<init>	()V
    //   190: astore 10
    //   192: aload 8
    //   194: ifnonnull +961 -> 1155
    //   197: new 291	java/util/ArrayList
    //   200: dup
    //   201: invokespecial 941	java/util/ArrayList:<init>	()V
    //   204: astore 8
    //   206: aload 9
    //   208: invokevirtual 294	java/util/ArrayList:size	()I
    //   211: ifne +464 -> 675
    //   214: aload 10
    //   216: invokevirtual 294	java/util/ArrayList:size	()I
    //   219: ifne +456 -> 675
    //   222: aload 8
    //   224: invokevirtual 294	java/util/ArrayList:size	()I
    //   227: ifne +448 -> 675
    //   230: return
    //   231: astore 11
    //   233: aload 11
    //   235: invokevirtual 522	java/io/IOException:printStackTrace	()V
    //   238: aload 8
    //   240: astore 11
    //   242: aload 9
    //   244: astore 8
    //   246: aload 11
    //   248: astore 9
    //   250: goto -86 -> 164
    //   253: astore 13
    //   255: aconst_null
    //   256: astore 12
    //   258: aconst_null
    //   259: astore 8
    //   261: aconst_null
    //   262: astore 9
    //   264: iconst_0
    //   265: istore_1
    //   266: aconst_null
    //   267: astore 10
    //   269: aload 12
    //   271: astore 11
    //   273: aload 13
    //   275: invokevirtual 942	java/io/StreamCorruptedException:printStackTrace	()V
    //   278: aload 12
    //   280: ifnull +897 -> 1177
    //   283: aload 12
    //   285: invokevirtual 940	java/io/ObjectInputStream:close	()V
    //   288: aload 9
    //   290: astore 11
    //   292: aload 10
    //   294: astore 9
    //   296: iload_1
    //   297: istore_2
    //   298: aload 8
    //   300: astore 10
    //   302: iconst_0
    //   303: istore_1
    //   304: aload 11
    //   306: astore 8
    //   308: goto -144 -> 164
    //   311: astore 11
    //   313: aload 11
    //   315: invokevirtual 522	java/io/IOException:printStackTrace	()V
    //   318: aload 9
    //   320: astore 11
    //   322: aload 10
    //   324: astore 9
    //   326: iload_1
    //   327: istore_2
    //   328: aload 8
    //   330: astore 10
    //   332: iconst_0
    //   333: istore_1
    //   334: aload 11
    //   336: astore 8
    //   338: goto -174 -> 164
    //   341: astore 10
    //   343: aconst_null
    //   344: astore 14
    //   346: aload 19
    //   348: astore 8
    //   350: aload 14
    //   352: astore 11
    //   354: aload 10
    //   356: invokevirtual 523	java/io/FileNotFoundException:printStackTrace	()V
    //   359: aload 8
    //   361: astore 11
    //   363: aload 9
    //   365: astore 10
    //   367: aload 13
    //   369: astore 12
    //   371: iload_3
    //   372: istore_2
    //   373: aload 14
    //   375: ifnull +789 -> 1164
    //   378: aload 14
    //   380: invokevirtual 940	java/io/ObjectInputStream:close	()V
    //   383: iconst_0
    //   384: istore_1
    //   385: aload 8
    //   387: astore 11
    //   389: aload 13
    //   391: astore 8
    //   393: aload 9
    //   395: astore 10
    //   397: aload 11
    //   399: astore 9
    //   401: iload_3
    //   402: istore_2
    //   403: goto -239 -> 164
    //   406: astore 10
    //   408: aload 10
    //   410: invokevirtual 522	java/io/IOException:printStackTrace	()V
    //   413: iconst_0
    //   414: istore_1
    //   415: aload 8
    //   417: astore 11
    //   419: aload 13
    //   421: astore 8
    //   423: aload 9
    //   425: astore 10
    //   427: aload 11
    //   429: astore 9
    //   431: iload_3
    //   432: istore_2
    //   433: goto -269 -> 164
    //   436: astore 10
    //   438: aconst_null
    //   439: astore 14
    //   441: iload_2
    //   442: istore_3
    //   443: aload 15
    //   445: astore 13
    //   447: aload 17
    //   449: astore 9
    //   451: aload 20
    //   453: astore 8
    //   455: aload 14
    //   457: astore 11
    //   459: aload 10
    //   461: invokevirtual 522	java/io/IOException:printStackTrace	()V
    //   464: aload 8
    //   466: astore 11
    //   468: aload 9
    //   470: astore 10
    //   472: aload 13
    //   474: astore 12
    //   476: iload_3
    //   477: istore_2
    //   478: aload 14
    //   480: ifnull +684 -> 1164
    //   483: aload 14
    //   485: invokevirtual 940	java/io/ObjectInputStream:close	()V
    //   488: iconst_0
    //   489: istore_1
    //   490: aload 8
    //   492: astore 11
    //   494: aload 13
    //   496: astore 8
    //   498: aload 9
    //   500: astore 10
    //   502: aload 11
    //   504: astore 9
    //   506: iload_3
    //   507: istore_2
    //   508: goto -344 -> 164
    //   511: astore 10
    //   513: aload 10
    //   515: invokevirtual 522	java/io/IOException:printStackTrace	()V
    //   518: iconst_0
    //   519: istore_1
    //   520: aload 8
    //   522: astore 11
    //   524: aload 13
    //   526: astore 8
    //   528: aload 9
    //   530: astore 10
    //   532: aload 11
    //   534: astore 9
    //   536: iload_3
    //   537: istore_2
    //   538: goto -374 -> 164
    //   541: astore 10
    //   543: aconst_null
    //   544: astore 14
    //   546: iload 6
    //   548: istore_3
    //   549: aload 16
    //   551: astore 13
    //   553: aload 18
    //   555: astore 9
    //   557: aload 21
    //   559: astore 8
    //   561: aload 14
    //   563: astore 11
    //   565: aload 10
    //   567: invokevirtual 943	java/lang/ClassNotFoundException:printStackTrace	()V
    //   570: aload 8
    //   572: astore 11
    //   574: aload 9
    //   576: astore 10
    //   578: aload 13
    //   580: astore 12
    //   582: iload_3
    //   583: istore_2
    //   584: aload 14
    //   586: ifnull +578 -> 1164
    //   589: aload 14
    //   591: invokevirtual 940	java/io/ObjectInputStream:close	()V
    //   594: iconst_0
    //   595: istore_1
    //   596: aload 8
    //   598: astore 11
    //   600: aload 13
    //   602: astore 8
    //   604: aload 9
    //   606: astore 10
    //   608: aload 11
    //   610: astore 9
    //   612: iload_3
    //   613: istore_2
    //   614: goto -450 -> 164
    //   617: astore 10
    //   619: aload 10
    //   621: invokevirtual 522	java/io/IOException:printStackTrace	()V
    //   624: iconst_0
    //   625: istore_1
    //   626: aload 8
    //   628: astore 11
    //   630: aload 13
    //   632: astore 8
    //   634: aload 9
    //   636: astore 10
    //   638: aload 11
    //   640: astore 9
    //   642: iload_3
    //   643: istore_2
    //   644: goto -480 -> 164
    //   647: astore 8
    //   649: aconst_null
    //   650: astore 11
    //   652: aload 11
    //   654: ifnull +8 -> 662
    //   657: aload 11
    //   659: invokevirtual 940	java/io/ObjectInputStream:close	()V
    //   662: aload 8
    //   664: athrow
    //   665: astore 9
    //   667: aload 9
    //   669: invokevirtual 522	java/io/IOException:printStackTrace	()V
    //   672: goto -10 -> 662
    //   675: aload_0
    //   676: iconst_1
    //   677: putfield 102	com/tencent/mobileqq/troop/activity/NearbyTroopsView:jdField_e_of_type_Boolean	Z
    //   680: iload_2
    //   681: ifeq +48 -> 729
    //   684: iload_1
    //   685: ifeq +44 -> 729
    //   688: aload_0
    //   689: getfield 660	com/tencent/mobileqq/troop/activity/NearbyTroopsView:jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController	Lcom/tencent/tencentmap/mapsdk/map/MapController;
    //   692: aload_0
    //   693: getfield 650	com/tencent/mobileqq/troop/activity/NearbyTroopsView:jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsMapView	Lcom/tencent/mobileqq/troop/widget/NearbyTroopsMapView;
    //   696: invokevirtual 859	com/tencent/mobileqq/troop/widget/NearbyTroopsMapView:getMaxZoomLevel	()I
    //   699: iconst_1
    //   700: isub
    //   701: invokevirtual 669	com/tencent/tencentmap/mapsdk/map/MapController:setZoom	(I)I
    //   704: pop
    //   705: aload_0
    //   706: getfield 660	com/tencent/mobileqq/troop/activity/NearbyTroopsView:jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController	Lcom/tencent/tencentmap/mapsdk/map/MapController;
    //   709: new 446	com/tencent/tencentmap/mapsdk/map/GeoPoint
    //   712: dup
    //   713: iload_2
    //   714: iload_1
    //   715: invokespecial 749	com/tencent/tencentmap/mapsdk/map/GeoPoint:<init>	(II)V
    //   718: invokevirtual 946	com/tencent/tencentmap/mapsdk/map/MapController:setCenter	(Lcom/tencent/tencentmap/mapsdk/map/GeoPoint;)V
    //   721: aload_0
    //   722: getfield 576	com/tencent/mobileqq/troop/activity/NearbyTroopsView:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   725: iconst_0
    //   726: invokevirtual 614	android/view/View:setVisibility	(I)V
    //   729: aload 9
    //   731: invokevirtual 950	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   734: astore 11
    //   736: aload 11
    //   738: invokeinterface 955 1 0
    //   743: ifeq +70 -> 813
    //   746: aload 11
    //   748: invokeinterface 958 1 0
    //   753: checkcast 960	NearbyGroup/GroupInfo
    //   756: getfield 964	NearbyGroup/GroupInfo:dwGroupFlagExt	J
    //   759: ldc2_w 800
    //   762: land
    //   763: lconst_0
    //   764: lcmp
    //   765: ifeq -29 -> 736
    //   768: aload_0
    //   769: getfield 127	com/tencent/mobileqq/troop/activity/NearbyTroopsView:jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsBaseView$INearbyTroopContext;
    //   772: invokeinterface 218 1 0
    //   777: ldc_w 966
    //   780: ldc_w 479
    //   783: ldc_w 479
    //   786: ldc_w 968
    //   789: ldc_w 970
    //   792: bipush 45
    //   794: iconst_0
    //   795: ldc_w 479
    //   798: ldc_w 479
    //   801: ldc_w 479
    //   804: ldc_w 479
    //   807: invokestatic 488	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   810: goto -74 -> 736
    //   813: aload_0
    //   814: getfield 701	com/tencent/mobileqq/troop/activity/NearbyTroopsView:jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter	Lcom/tencent/mobileqq/troop/data/NearbyTroopsExpandableListViewAdapter;
    //   817: aload 9
    //   819: aload 10
    //   821: aload 8
    //   823: invokevirtual 973	com/tencent/mobileqq/troop/data/NearbyTroopsExpandableListViewAdapter:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    //   826: aload_0
    //   827: getfield 545	com/tencent/mobileqq/troop/activity/NearbyTroopsView:jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView	Lcom/tencent/mobileqq/troop/widget/NearbyTroopsExpandableListView;
    //   830: iconst_1
    //   831: invokevirtual 805	com/tencent/mobileqq/troop/widget/NearbyTroopsExpandableListView:a	(Z)V
    //   834: return
    //   835: astore 8
    //   837: goto -185 -> 652
    //   840: astore 10
    //   842: aload 21
    //   844: astore 8
    //   846: aload 18
    //   848: astore 9
    //   850: aload 16
    //   852: astore 13
    //   854: iload 6
    //   856: istore_3
    //   857: aload 12
    //   859: astore 14
    //   861: goto -300 -> 561
    //   864: astore 10
    //   866: aload 18
    //   868: astore 9
    //   870: aload 16
    //   872: astore 13
    //   874: iload 6
    //   876: istore_3
    //   877: aload 12
    //   879: astore 14
    //   881: goto -320 -> 561
    //   884: astore 11
    //   886: aload 10
    //   888: astore 9
    //   890: aload 11
    //   892: astore 10
    //   894: aload 16
    //   896: astore 13
    //   898: iload 6
    //   900: istore_3
    //   901: aload 12
    //   903: astore 14
    //   905: goto -344 -> 561
    //   908: astore 11
    //   910: aload 9
    //   912: astore 13
    //   914: aload 10
    //   916: astore 9
    //   918: aload 11
    //   920: astore 10
    //   922: aload 12
    //   924: astore 14
    //   926: goto -365 -> 561
    //   929: astore 10
    //   931: aload 20
    //   933: astore 8
    //   935: aload 17
    //   937: astore 9
    //   939: aload 15
    //   941: astore 13
    //   943: iload_2
    //   944: istore_3
    //   945: aload 12
    //   947: astore 14
    //   949: goto -494 -> 455
    //   952: astore 10
    //   954: aload 17
    //   956: astore 9
    //   958: aload 15
    //   960: astore 13
    //   962: iload_2
    //   963: istore_3
    //   964: aload 12
    //   966: astore 14
    //   968: goto -513 -> 455
    //   971: astore 11
    //   973: aload 10
    //   975: astore 9
    //   977: aload 11
    //   979: astore 10
    //   981: aload 15
    //   983: astore 13
    //   985: iload_2
    //   986: istore_3
    //   987: aload 12
    //   989: astore 14
    //   991: goto -536 -> 455
    //   994: astore 11
    //   996: aload 9
    //   998: astore 13
    //   1000: aload 10
    //   1002: astore 9
    //   1004: aload 11
    //   1006: astore 10
    //   1008: iload_1
    //   1009: istore_3
    //   1010: aload 12
    //   1012: astore 14
    //   1014: goto -559 -> 455
    //   1017: astore 10
    //   1019: aload 19
    //   1021: astore 8
    //   1023: aload 12
    //   1025: astore 14
    //   1027: goto -677 -> 350
    //   1030: astore 10
    //   1032: aload 12
    //   1034: astore 14
    //   1036: goto -686 -> 350
    //   1039: astore 11
    //   1041: aload 10
    //   1043: astore 9
    //   1045: aload 11
    //   1047: astore 10
    //   1049: aload 12
    //   1051: astore 14
    //   1053: goto -703 -> 350
    //   1056: astore 11
    //   1058: aload 9
    //   1060: astore 13
    //   1062: aload 10
    //   1064: astore 9
    //   1066: aload 11
    //   1068: astore 10
    //   1070: iload 4
    //   1072: istore_3
    //   1073: aload 12
    //   1075: astore 14
    //   1077: goto -727 -> 350
    //   1080: astore 13
    //   1082: aconst_null
    //   1083: astore 10
    //   1085: iconst_0
    //   1086: istore_1
    //   1087: aconst_null
    //   1088: astore 9
    //   1090: aconst_null
    //   1091: astore 8
    //   1093: goto -824 -> 269
    //   1096: astore 13
    //   1098: iconst_0
    //   1099: istore_1
    //   1100: aload 8
    //   1102: astore 10
    //   1104: aconst_null
    //   1105: astore 9
    //   1107: aconst_null
    //   1108: astore 8
    //   1110: goto -841 -> 269
    //   1113: astore 13
    //   1115: aconst_null
    //   1116: astore 9
    //   1118: iconst_0
    //   1119: istore_1
    //   1120: aload 8
    //   1122: astore 11
    //   1124: aload 10
    //   1126: astore 8
    //   1128: aload 11
    //   1130: astore 10
    //   1132: goto -863 -> 269
    //   1135: astore 13
    //   1137: iload 5
    //   1139: istore_1
    //   1140: aload 8
    //   1142: astore 11
    //   1144: aload 10
    //   1146: astore 8
    //   1148: aload 11
    //   1150: astore 10
    //   1152: goto -883 -> 269
    //   1155: goto -949 -> 206
    //   1158: goto -966 -> 192
    //   1161: goto -983 -> 178
    //   1164: aload 12
    //   1166: astore 8
    //   1168: iconst_0
    //   1169: istore_1
    //   1170: aload 11
    //   1172: astore 9
    //   1174: goto -1010 -> 164
    //   1177: aload 9
    //   1179: astore 11
    //   1181: aload 10
    //   1183: astore 9
    //   1185: iload_1
    //   1186: istore_2
    //   1187: aload 8
    //   1189: astore 10
    //   1191: iconst_0
    //   1192: istore_1
    //   1193: aload 11
    //   1195: astore 8
    //   1197: goto -1033 -> 164
    //   1200: aload 8
    //   1202: astore 11
    //   1204: aload 9
    //   1206: astore 8
    //   1208: aload 11
    //   1210: astore 9
    //   1212: goto -1048 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1215	0	this	NearbyTroopsView
    //   36	1157	1	i1	int
    //   28	1159	2	i2	int
    //   44	1029	3	i3	int
    //   38	1033	4	i4	int
    //   41	1097	5	i5	int
    //   30	869	6	i6	int
    //   33	77	7	i7	int
    //   75	558	8	localObject1	Object
    //   647	175	8	localArrayList	ArrayList
    //   835	1	8	localObject2	Object
    //   844	363	8	localObject3	Object
    //   16	625	9	localObject4	Object
    //   665	153	9	localIOException1	java.io.IOException
    //   848	363	9	localObject5	Object
    //   89	242	10	localObject6	Object
    //   341	14	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   365	31	10	localObject7	Object
    //   406	3	10	localIOException2	java.io.IOException
    //   425	1	10	localObject8	Object
    //   436	24	10	localIOException3	java.io.IOException
    //   470	31	10	localObject9	Object
    //   511	3	10	localIOException4	java.io.IOException
    //   530	1	10	localObject10	Object
    //   541	25	10	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   576	31	10	localObject11	Object
    //   617	3	10	localIOException5	java.io.IOException
    //   636	184	10	localObject12	Object
    //   840	1	10	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   864	23	10	localClassNotFoundException3	java.lang.ClassNotFoundException
    //   892	29	10	localClassNotFoundException4	java.lang.ClassNotFoundException
    //   929	1	10	localIOException6	java.io.IOException
    //   952	22	10	localIOException7	java.io.IOException
    //   979	28	10	localIOException8	java.io.IOException
    //   1017	1	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   1030	12	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   1047	143	10	localObject13	Object
    //   65	96	11	localObject14	Object
    //   231	3	11	localIOException9	java.io.IOException
    //   240	65	11	localObject15	Object
    //   311	3	11	localIOException10	java.io.IOException
    //   320	427	11	localObject16	Object
    //   884	7	11	localClassNotFoundException5	java.lang.ClassNotFoundException
    //   908	11	11	localClassNotFoundException6	java.lang.ClassNotFoundException
    //   971	7	11	localIOException11	java.io.IOException
    //   994	11	11	localIOException12	java.io.IOException
    //   1039	7	11	localFileNotFoundException4	java.io.FileNotFoundException
    //   1056	11	11	localFileNotFoundException5	java.io.FileNotFoundException
    //   1122	87	11	localObject17	Object
    //   61	1104	12	localObject18	Object
    //   25	1	13	localObject19	Object
    //   253	167	13	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   445	616	13	localObject20	Object
    //   1080	1	13	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   1096	1	13	localStreamCorruptedException3	java.io.StreamCorruptedException
    //   1113	1	13	localStreamCorruptedException4	java.io.StreamCorruptedException
    //   1135	1	13	localStreamCorruptedException5	java.io.StreamCorruptedException
    //   344	732	14	localObject21	Object
    //   19	963	15	localObject22	Object
    //   22	873	16	localObject23	Object
    //   10	945	17	localObject24	Object
    //   13	854	18	localObject25	Object
    //   7	1013	19	localObject26	Object
    //   1	931	20	localObject27	Object
    //   4	839	21	localObject28	Object
    // Exception table:
    //   from	to	target	type
    //   147	152	231	java/io/IOException
    //   45	63	253	java/io/StreamCorruptedException
    //   283	288	311	java/io/IOException
    //   45	63	341	java/io/FileNotFoundException
    //   378	383	406	java/io/IOException
    //   45	63	436	java/io/IOException
    //   483	488	511	java/io/IOException
    //   45	63	541	java/lang/ClassNotFoundException
    //   589	594	617	java/io/IOException
    //   45	63	647	finally
    //   657	662	665	java/io/IOException
    //   67	77	835	finally
    //   81	91	835	finally
    //   95	105	835	finally
    //   112	118	835	finally
    //   132	139	835	finally
    //   273	278	835	finally
    //   354	359	835	finally
    //   459	464	835	finally
    //   565	570	835	finally
    //   67	77	840	java/lang/ClassNotFoundException
    //   81	91	864	java/lang/ClassNotFoundException
    //   95	105	884	java/lang/ClassNotFoundException
    //   112	118	908	java/lang/ClassNotFoundException
    //   132	139	908	java/lang/ClassNotFoundException
    //   67	77	929	java/io/IOException
    //   81	91	952	java/io/IOException
    //   95	105	971	java/io/IOException
    //   112	118	994	java/io/IOException
    //   132	139	994	java/io/IOException
    //   67	77	1017	java/io/FileNotFoundException
    //   81	91	1030	java/io/FileNotFoundException
    //   95	105	1039	java/io/FileNotFoundException
    //   112	118	1056	java/io/FileNotFoundException
    //   132	139	1056	java/io/FileNotFoundException
    //   67	77	1080	java/io/StreamCorruptedException
    //   81	91	1096	java/io/StreamCorruptedException
    //   95	105	1113	java/io/StreamCorruptedException
    //   112	118	1135	java/io/StreamCorruptedException
    //   132	139	1135	java/io/StreamCorruptedException
  }
  
  public void l()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    if (this.h)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837905);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837904);
  }
  
  public void m()
  {
    if (this.w == 1)
    {
      a(true);
      return;
    }
    k();
    a(true);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (paramView.getId() == 2131297706)
          {
            TroopCreateEnterActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), 2, 51);
            return;
          }
        } while (!(paramView.getTag() instanceof eil));
        switch (((eil)paramView.getTag()).jdField_a_of_type_Int)
        {
        default: 
          return;
        }
      } while (this.jdField_d_of_type_Boolean);
      b(true);
      return;
    } while (!this.jdField_d_of_type_Boolean);
    b(false);
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "nearbygrp_map", "Clk_back", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Eim = new eim(this, 1, 1, 1, 8);
    SOSOMapLBSApi.getInstance().verifyRegCode("QQ2013", "LWPAH-5CHEJ-Y6CR2-AQPLX-IV2JQ");
    SOSOMapLBSApi.getInstance().requestLocationUpdate(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().getApplicationContext(), this.jdField_a_of_type_Eim);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setHasHotTroopRedDot(boolean paramBoolean)
  {
    this.h = paramBoolean;
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.NearbyTroopsView
 * JD-Core Version:    0.7.0.1
 */