package com.tencent.mobileqq.activity;

import EncounterSvc.RespEncounterInfo;
import NearbyGroup.RspGetNearbyGroup;
import NearbyPubAcct.PubAcctInfo;
import NearbyPubAcct.RspGetNearbyPubAcctInfo;
import NeighborSvc.RespNeighborInfo;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.view.MenuItemCompat;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.qq.taf.jce.JceInputStream;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter.ViewHolder;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.lbs.LBSService;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.CustomDrawable1;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import cyt;
import cyu;
import cyv;
import cyw;
import cyx;
import cyy;
import cza;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public abstract class PeopleAroundBaseActivity
  extends LbsBaseActivity
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener, ActionSheet.OnButtonClickListener, AdapterView.OnItemClickListener, Observer
{
  static final int A = 0;
  static final int B = 1;
  private static final int jdField_b_of_type_Int = 7;
  static final long jdField_b_of_type_Long = 1000L;
  public static String c;
  static final int h = 30000;
  static final int i = 0;
  public static final int j = 0;
  public static final int k = 1;
  public static final int l = 2;
  public static final int m = 4;
  public static int n = 0;
  public static int w = 1;
  public static int x = 2;
  public long a;
  RspGetNearbyGroup jdField_a_of_type_NearbyGroupRspGetNearbyGroup;
  RspGetNearbyPubAcctInfo jdField_a_of_type_NearbyPubAcctRspGetNearbyPubAcctInfo;
  public View a;
  public TextView a;
  public PeopleAroundAdapter a;
  private LBSHandler jdField_a_of_type_ComTencentMobileqqAppLBSHandler;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new cyv(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public PullRefreshHeader a;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new cyx(this);
  public XListView a;
  private cza jdField_a_of_type_Cza = new cza(this);
  private String jdField_a_of_type_JavaLangString = "filter_type";
  List jdField_a_of_type_JavaUtilList;
  protected boolean a;
  int[] jdField_a_of_type_ArrayOfInt;
  long[] jdField_a_of_type_ArrayOfLong;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  protected List b;
  private String[] jdField_b_of_type_ArrayOfJavaLangString;
  private int c;
  private int jdField_d_of_type_Int = 0;
  String jdField_d_of_type_JavaLangString;
  int o;
  int p;
  public int q = 0;
  public int r = 0;
  protected int s = 0;
  protected int t = 0;
  protected int u = 0;
  public int v = 0;
  public int y = 0;
  public int z = 4;
  
  static
  {
    jdField_c_of_type_JavaLangString = "source";
  }
  
  public PeopleAroundBaseActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilList = new ArrayList(8);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    StatableBitmapDrawable localStatableBitmapDrawable = new StatableBitmapDrawable(getResources(), this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramInt, 200), false, false);
    if (this.jdField_d_of_type_Int == 0) {
      this.jdField_d_of_type_Int = ((int)(paramTextView.getTextSize() * 1.1F + 0.5F));
    }
    localStatableBitmapDrawable.setBounds(0, 0, this.jdField_d_of_type_Int, this.jdField_d_of_type_Int);
    paramTextView.setCompoundDrawables(localStatableBitmapDrawable, null, null, null);
  }
  
  private void a(boolean paramBoolean)
  {
    switch (this.jdField_p_of_type_Int)
    {
    case 3: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(0, paramBoolean, null, this.q, this.r, this.v, this.y);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(2, paramBoolean, null, this.q, this.r, this.v, this.y);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(1, paramBoolean, null, this.q, this.r, this.v, this.y);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(3, paramBoolean, this.jdField_a_of_type_ArrayOfLong, this.q, this.r, this.v, this.y);
  }
  
  private void a(int[] paramArrayOfInt)
  {
    if (this.jdField_b_of_type_ArrayOfJavaLangString == null)
    {
      this.jdField_b_of_type_ArrayOfJavaLangString = getResources().getStringArray(2131689501);
      a(this.jdField_b_of_type_JavaUtilList);
    }
    int i1;
    switch (this.jdField_p_of_type_Int)
    {
    default: 
      i1 = 0;
    }
    int i2;
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.b(this);
      i2 = 0;
      for (;;)
      {
        if (i2 >= this.jdField_b_of_type_JavaUtilList.size()) {
          break label336;
        }
        if (2131234394 != ((Integer)((Pair)this.jdField_b_of_type_JavaUtilList.get(i2)).first).intValue()) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.d((CharSequence)((Pair)this.jdField_b_of_type_JavaUtilList.get(i2)).second);
        i2 += 1;
      }
      i1 = 2131230849;
      continue;
      i1 = 2131230850;
      continue;
      i1 = 2131230851;
    }
    if ((2131230849 == ((Integer)((Pair)this.jdField_b_of_type_JavaUtilList.get(i2)).first).intValue()) || (2131230850 == ((Integer)((Pair)this.jdField_b_of_type_JavaUtilList.get(i2)).first).intValue()) || (2131230851 == ((Integer)((Pair)this.jdField_b_of_type_JavaUtilList.get(i2)).first).intValue())) {
      if (((Integer)((Pair)this.jdField_b_of_type_JavaUtilList.get(i2)).first).intValue() != i1) {
        break label375;
      }
    }
    label336:
    label375:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a((CharSequence)((Pair)this.jdField_b_of_type_JavaUtilList.get(i2)).second, 1, bool);
      break;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a((CharSequence)((Pair)this.jdField_b_of_type_JavaUtilList.get(i2)).second, 1, false);
      break;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new cyu(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
  }
  
  private void e()
  {
    int i1 = 0;
    if (getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getLong("nearby_enter_time", -100L) == -100L) {
      i1 = 1;
    }
    if (i1 != 0)
    {
      LinearLayout localLinearLayout = (LinearLayout)findViewById(2131231838);
      View localView1 = findViewById(2131233341);
      localView1.setVisibility(8);
      View localView2 = LayoutInflater.from(getApplicationContext()).inflate(2130903594, null);
      localLinearLayout.addView(localView2, new LinearLayout.LayoutParams(-1, -1));
      Drawable[] arrayOfDrawable = this.l.getCompoundDrawables();
      this.l.setCompoundDrawables(null, null, null, null);
      this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(4);
      ((Button)localView2.findViewById(2131233019)).setOnClickListener(new cyy(this, localView1, arrayOfDrawable, localLinearLayout, localView2));
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((paramInt < 0) && (paramInt >= this.jdField_b_of_type_JavaUtilList.size())) {
      return;
    }
    switch (((Integer)((Pair)this.jdField_b_of_type_JavaUtilList.get(paramInt)).first).intValue())
    {
    }
    try
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        this.jdField_c_of_type_Int = this.jdField_p_of_type_Int;
        g();
        return;
        this.jdField_p_of_type_Int = 0;
        a(true, false);
        continue;
        this.jdField_p_of_type_Int = 1;
        a(true, false);
        continue;
        this.jdField_p_of_type_Int = 2;
        a(true, false);
        continue;
        paramView = new Intent(this, VisitorsActivity.class);
        paramView.putExtra("votersOnly", true);
        paramView.putExtra("toUin", Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()));
        startActivity(paramView);
        continue;
        d(new cyw(this));
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())) {}
    for (;;)
    {
      return;
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
        if (localObject != null)
        {
          localObject = (PeopleAroundAdapter.ViewHolder)((View)localObject).getTag();
          if ((localObject != null) && (paramString.equals(((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString)))
          {
            ((PeopleAroundAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
    this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramAdapterView.a().getItem(paramInt);
    FriendManager localFriendManager;
    if ((paramAdapterView instanceof RespEncounterInfo))
    {
      paramAdapterView = (RespEncounterInfo)paramAdapterView;
      paramView = String.valueOf(paramAdapterView.lEctID);
      localFriendManager = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if ((paramAdapterView.lEctID <= 0L) || (localFriendManager == null)) {
        break label460;
      }
    }
    label460:
    for (boolean bool = localFriendManager.b(paramView);; bool = false)
    {
      if (("".equals(paramAdapterView.strCertification)) || (paramView.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())))
      {
        paramView = new ProfileActivity.AllInOne(paramView, 0);
        paramView.g = paramAdapterView.strNick;
        paramView.b = paramAdapterView.cAge;
        paramView.jdField_a_of_type_Byte = paramAdapterView.cSex;
        paramView.jdField_a_of_type_Short = paramAdapterView.wFace;
        paramView.e = this.z;
        paramView.f = 5;
        ProfileActivity.a(this, paramView);
        return;
      }
      if (bool)
      {
        paramView = new ProfileActivity.AllInOne(paramView, 40);
        paramView.g = paramAdapterView.strNick;
        paramView.b = paramAdapterView.cAge;
        paramView.jdField_a_of_type_Byte = paramAdapterView.cSex;
        paramView.jdField_a_of_type_Short = paramAdapterView.wFace;
        paramView.e = this.z;
        paramView.f = 5;
        ProfileActivity.a(this, paramView);
        return;
      }
      paramView = new ProfileActivity.AllInOne(paramView, 41);
      paramView.g = paramAdapterView.strNick;
      paramView.b = paramAdapterView.cAge;
      paramView.jdField_a_of_type_Byte = paramAdapterView.cSex;
      paramView.jdField_a_of_type_Short = paramAdapterView.wFace;
      paramView.jdField_a_of_type_ArrayOfByte = paramAdapterView.sig;
      paramView.n = paramAdapterView.enc_id;
      paramView.o = paramAdapterView.uid;
      if (QLog.isDevelopLevel()) {
        QLog.d("fight_accost", 4, "附近人列表accost_uin = " + paramView.jdField_a_of_type_JavaLangString + "accost_sig = " + paramView.jdField_a_of_type_ArrayOfByte);
      }
      paramView.e = this.z;
      paramView.f = 5;
      ProfileActivity.a(this, paramView);
      return;
      if ((paramAdapterView instanceof RespNeighborInfo))
      {
        paramAdapterView = (RespNeighborInfo)paramAdapterView;
        paramView = new ProfileActivity.AllInOne(String.valueOf(paramAdapterView.lNBID), 40);
        paramView.g = paramAdapterView.strNick;
        paramView.b = paramAdapterView.cAge;
        paramView.jdField_a_of_type_Byte = paramAdapterView.cSex;
        paramView.e = this.z;
        paramView.f = 5;
        ProfileActivity.a(this, paramView);
        return;
      }
      if ((paramAdapterView instanceof PubAcctInfo))
      {
        a(String.valueOf(((PubAcctInfo)paramAdapterView).lUin));
        return;
      }
      a(false, false);
      return;
    }
  }
  
  void a(String paramString)
  {
    PublicAccountHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString, "Pb_account_lifeservice", "mp_msg_sys_7", "nearby");
    Intent localIntent = new Intent(a(), AccountDetailActivity.class);
    localIntent.putExtra("uin", String.valueOf(paramString));
    a().startActivity(localIntent);
  }
  
  /* Error */
  public void a(String paramString1, List paramList, String paramString2)
  {
    // Byte code:
    //   0: new 612	java/io/ObjectOutputStream
    //   3: dup
    //   4: aload_0
    //   5: new 545	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 546	java/lang/StringBuilder:<init>	()V
    //   12: aload_1
    //   13: invokevirtual 552	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc_w 614
    //   19: invokevirtual 552	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 561	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: iconst_0
    //   26: invokevirtual 618	com/tencent/mobileqq/activity/PeopleAroundBaseActivity:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   29: invokespecial 621	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore 4
    //   34: aload 4
    //   36: astore_1
    //   37: aload 4
    //   39: aload_2
    //   40: invokevirtual 625	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   43: aload 4
    //   45: astore_1
    //   46: aload 4
    //   48: aload_3
    //   49: invokevirtual 628	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   52: aload 4
    //   54: astore_1
    //   55: aload 4
    //   57: aload_0
    //   58: getfield 187	com/tencent/mobileqq/activity/PeopleAroundBaseActivity:jdField_p_of_type_Int	I
    //   61: invokevirtual 631	java/io/ObjectOutputStream:writeByte	(I)V
    //   64: aload 4
    //   66: astore_1
    //   67: aload 4
    //   69: aload_0
    //   70: getfield 633	com/tencent/mobileqq/activity/PeopleAroundBaseActivity:jdField_a_of_type_NearbyGroupRspGetNearbyGroup	LNearbyGroup/RspGetNearbyGroup;
    //   73: invokevirtual 625	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   76: aload 4
    //   78: astore_1
    //   79: aload 4
    //   81: aload_0
    //   82: getfield 635	com/tencent/mobileqq/activity/PeopleAroundBaseActivity:jdField_a_of_type_Long	J
    //   85: invokevirtual 639	java/io/ObjectOutputStream:writeLong	(J)V
    //   88: aload 4
    //   90: astore_1
    //   91: aload 4
    //   93: invokevirtual 642	java/io/ObjectOutputStream:flush	()V
    //   96: aload 4
    //   98: ifnull +8 -> 106
    //   101: aload 4
    //   103: invokevirtual 645	java/io/ObjectOutputStream:close	()V
    //   106: return
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 646	java/io/IOException:printStackTrace	()V
    //   112: return
    //   113: astore_3
    //   114: aconst_null
    //   115: astore_2
    //   116: aload_2
    //   117: astore_1
    //   118: aload_3
    //   119: invokevirtual 400	java/lang/Exception:printStackTrace	()V
    //   122: aload_2
    //   123: ifnull -17 -> 106
    //   126: aload_2
    //   127: invokevirtual 645	java/io/ObjectOutputStream:close	()V
    //   130: return
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual 646	java/io/IOException:printStackTrace	()V
    //   136: return
    //   137: astore_2
    //   138: aconst_null
    //   139: astore_1
    //   140: aload_1
    //   141: ifnull +7 -> 148
    //   144: aload_1
    //   145: invokevirtual 645	java/io/ObjectOutputStream:close	()V
    //   148: aload_2
    //   149: athrow
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 646	java/io/IOException:printStackTrace	()V
    //   155: goto -7 -> 148
    //   158: astore_2
    //   159: goto -19 -> 140
    //   162: astore_3
    //   163: aload 4
    //   165: astore_2
    //   166: goto -50 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	PeopleAroundBaseActivity
    //   0	169	1	paramString1	String
    //   0	169	2	paramList	List
    //   0	169	3	paramString2	String
    //   32	132	4	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   101	106	107	java/io/IOException
    //   0	34	113	java/lang/Exception
    //   126	130	131	java/io/IOException
    //   0	34	137	finally
    //   144	148	150	java/io/IOException
    //   37	43	158	finally
    //   46	52	158	finally
    //   55	64	158	finally
    //   67	76	158	finally
    //   79	88	158	finally
    //   91	96	158	finally
    //   118	122	158	finally
    //   37	43	162	java/lang/Exception
    //   46	52	162	java/lang/Exception
    //   55	64	162	java/lang/Exception
    //   67	76	162	java/lang/Exception
    //   79	88	162	java/lang/Exception
    //   91	96	162	java/lang/Exception
  }
  
  protected void a(List paramList)
  {
    paramList.add(new Pair(Integer.valueOf(2131230849), this.jdField_b_of_type_ArrayOfJavaLangString[0]));
    paramList.add(new Pair(Integer.valueOf(2131230850), this.jdField_b_of_type_ArrayOfJavaLangString[1]));
    paramList.add(new Pair(Integer.valueOf(2131230851), this.jdField_b_of_type_ArrayOfJavaLangString[2]));
    paramList.add(new Pair(Integer.valueOf(2131230852), this.jdField_b_of_type_ArrayOfJavaLangString[4]));
    paramList.add(new Pair(Integer.valueOf(2131230853), this.jdField_b_of_type_ArrayOfJavaLangString[5]));
    paramList.add(new Pair(Integer.valueOf(2131234394), this.jdField_b_of_type_ArrayOfJavaLangString[6]));
  }
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((-2147483648 != this.q) && (-2147483648 != this.r))
    {
      if (!paramBoolean1) {
        break label62;
      }
      this.jdField_a_of_type_Cza.removeMessages(0);
      if (!paramBoolean2) {
        break label54;
      }
      e();
    }
    while (NetworkUtil.e(this))
    {
      a(paramBoolean1);
      return;
      label54:
      d();
      continue;
      label62:
      this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.b = true;
      this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.notifyDataSetChanged();
    }
    b(false, paramBoolean1);
  }
  
  void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {}
    for (;;)
    {
      try
      {
        RspGetNearbyGroup localRspGetNearbyGroup = LBSService.a(paramArrayOfByte);
        paramArrayOfByte = localRspGetNearbyGroup;
        if ((paramArrayOfByte != null) && (paramArrayOfByte.eReplyCode == 0) && (paramArrayOfByte.vGroupInfo.size() > 0))
        {
          this.jdField_a_of_type_NearbyGroupRspGetNearbyGroup = paramArrayOfByte;
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
      }
      try
      {
        JceInputStream localJceInputStream = new JceInputStream(paramArrayOfByte);
        paramArrayOfByte = new RspGetNearbyGroup();
        try
        {
          paramArrayOfByte.readFrom(localJceInputStream);
        }
        catch (Throwable localThrowable2) {}
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          paramArrayOfByte = null;
        }
      }
      localThrowable2.printStackTrace();
      continue;
      this.jdField_a_of_type_NearbyGroupRspGetNearbyGroup = null;
      return;
      paramArrayOfByte = null;
    }
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: new 705	java/io/ObjectInputStream
    //   3: dup
    //   4: aload_0
    //   5: new 545	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 546	java/lang/StringBuilder:<init>	()V
    //   12: aload_1
    //   13: invokevirtual 552	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc_w 614
    //   19: invokevirtual 552	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 561	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokevirtual 709	com/tencent/mobileqq/activity/PeopleAroundBaseActivity:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   28: invokespecial 712	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   31: astore_2
    //   32: aload_2
    //   33: astore_1
    //   34: aload_2
    //   35: invokevirtual 715	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   38: checkcast 214	java/util/List
    //   41: astore_3
    //   42: aload_3
    //   43: ifnull +63 -> 106
    //   46: aload_2
    //   47: astore_1
    //   48: aload_0
    //   49: aload_3
    //   50: putfield 717	com/tencent/mobileqq/activity/PeopleAroundBaseActivity:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   53: aload_2
    //   54: astore_1
    //   55: aload_0
    //   56: getfield 445	com/tencent/mobileqq/activity/PeopleAroundBaseActivity:jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter	Lcom/tencent/mobileqq/adapter/PeopleAroundAdapter;
    //   59: aload_3
    //   60: invokevirtual 718	com/tencent/mobileqq/adapter/PeopleAroundAdapter:a	(Ljava/util/List;)V
    //   63: aload_2
    //   64: astore_1
    //   65: aload_0
    //   66: aload_2
    //   67: invokevirtual 721	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   70: putfield 723	com/tencent/mobileqq/activity/PeopleAroundBaseActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   73: aload_2
    //   74: astore_1
    //   75: aload_0
    //   76: aload_2
    //   77: invokevirtual 727	java/io/ObjectInputStream:readByte	()B
    //   80: putfield 187	com/tencent/mobileqq/activity/PeopleAroundBaseActivity:jdField_p_of_type_Int	I
    //   83: aload_2
    //   84: astore_1
    //   85: aload_0
    //   86: aload_2
    //   87: invokevirtual 715	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   90: checkcast 685	NearbyGroup/RspGetNearbyGroup
    //   93: putfield 633	com/tencent/mobileqq/activity/PeopleAroundBaseActivity:jdField_a_of_type_NearbyGroupRspGetNearbyGroup	LNearbyGroup/RspGetNearbyGroup;
    //   96: aload_2
    //   97: astore_1
    //   98: aload_0
    //   99: aload_2
    //   100: invokevirtual 731	java/io/ObjectInputStream:readLong	()J
    //   103: putfield 635	com/tencent/mobileqq/activity/PeopleAroundBaseActivity:jdField_a_of_type_Long	J
    //   106: aload_2
    //   107: ifnull +7 -> 114
    //   110: aload_2
    //   111: invokevirtual 732	java/io/ObjectInputStream:close	()V
    //   114: aload_0
    //   115: getfield 445	com/tencent/mobileqq/activity/PeopleAroundBaseActivity:jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter	Lcom/tencent/mobileqq/adapter/PeopleAroundAdapter;
    //   118: invokevirtual 450	com/tencent/mobileqq/adapter/PeopleAroundAdapter:notifyDataSetChanged	()V
    //   121: iconst_0
    //   122: ireturn
    //   123: astore_3
    //   124: aload_2
    //   125: astore_1
    //   126: aload_3
    //   127: invokevirtual 400	java/lang/Exception:printStackTrace	()V
    //   130: goto -24 -> 106
    //   133: astore_3
    //   134: aload_2
    //   135: astore_1
    //   136: aload_3
    //   137: invokevirtual 400	java/lang/Exception:printStackTrace	()V
    //   140: aload_2
    //   141: ifnull -27 -> 114
    //   144: aload_2
    //   145: invokevirtual 732	java/io/ObjectInputStream:close	()V
    //   148: goto -34 -> 114
    //   151: astore_1
    //   152: aload_1
    //   153: invokevirtual 646	java/io/IOException:printStackTrace	()V
    //   156: goto -42 -> 114
    //   159: astore_1
    //   160: aload_1
    //   161: invokevirtual 646	java/io/IOException:printStackTrace	()V
    //   164: goto -50 -> 114
    //   167: astore_2
    //   168: aconst_null
    //   169: astore_1
    //   170: aload_1
    //   171: ifnull +7 -> 178
    //   174: aload_1
    //   175: invokevirtual 732	java/io/ObjectInputStream:close	()V
    //   178: aload_2
    //   179: athrow
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 646	java/io/IOException:printStackTrace	()V
    //   185: goto -7 -> 178
    //   188: astore_2
    //   189: goto -19 -> 170
    //   192: astore_3
    //   193: aconst_null
    //   194: astore_2
    //   195: goto -61 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	PeopleAroundBaseActivity
    //   0	198	1	paramString	String
    //   31	114	2	localObjectInputStream	java.io.ObjectInputStream
    //   167	12	2	localObject1	Object
    //   188	1	2	localObject2	Object
    //   194	1	2	localObject3	Object
    //   41	19	3	localList	List
    //   123	4	3	localException1	Exception
    //   133	4	3	localException2	Exception
    //   192	1	3	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   85	96	123	java/lang/Exception
    //   98	106	123	java/lang/Exception
    //   34	42	133	java/lang/Exception
    //   48	53	133	java/lang/Exception
    //   55	63	133	java/lang/Exception
    //   65	73	133	java/lang/Exception
    //   75	83	133	java/lang/Exception
    //   126	130	133	java/lang/Exception
    //   144	148	151	java/io/IOException
    //   110	114	159	java/io/IOException
    //   0	32	167	finally
    //   174	178	180	java/io/IOException
    //   34	42	188	finally
    //   48	53	188	finally
    //   55	63	188	finally
    //   65	73	188	finally
    //   75	83	188	finally
    //   85	96	188	finally
    //   98	106	188	finally
    //   126	130	188	finally
    //   136	140	188	finally
    //   0	32	192	java/lang/Exception
  }
  
  public abstract View b();
  
  void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      if (paramBoolean2) {
        this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      }
    }
    Object localObject = this.jdField_a_of_type_Cza;
    if (paramBoolean1) {}
    for (int i1 = 0;; i1 = 1)
    {
      localObject = ((cza)localObject).obtainMessage(0, i1, 0);
      this.jdField_a_of_type_Cza.sendMessageDelayed((Message)localObject, 1000L);
      return;
    }
  }
  
  void b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 4)) {}
    for (;;)
    {
      try
      {
        RspGetNearbyPubAcctInfo localRspGetNearbyPubAcctInfo = LBSService.a(paramArrayOfByte);
        paramArrayOfByte = localRspGetNearbyPubAcctInfo;
      }
      catch (Exception localException)
      {
        try
        {
          JceInputStream localJceInputStream = new JceInputStream(paramArrayOfByte);
          paramArrayOfByte = new RspGetNearbyPubAcctInfo();
          try
          {
            paramArrayOfByte.readFrom(localJceInputStream);
          }
          catch (Throwable localThrowable) {}
        }
        catch (Throwable paramArrayOfByte)
        {
          paramArrayOfByte = null;
        }
        continue;
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.eReplyCode == 0) && (paramArrayOfByte.vGroupInfo != null) && (paramArrayOfByte.vGroupInfo.size() > 0)) {
        this.jdField_a_of_type_NearbyPubAcctRspGetNearbyPubAcctInfo = paramArrayOfByte;
      }
      return;
      paramArrayOfByte = null;
    }
  }
  
  int c()
  {
    switch (this.jdField_p_of_type_Int)
    {
    case 3: 
    default: 
      return -1;
    case 0: 
      return 0;
    case 1: 
      return 2;
    case 2: 
      return 1;
    }
    return 3;
  }
  
  public View c()
  {
    return getLayoutInflater().inflate(2130903216, this.jdField_a_of_type_ComTencentWidgetXListView, false);
  }
  
  public abstract String c();
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    h();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ArrayOfJavaLangString = getResources().getStringArray(2131689502);
    f(2130903670);
    b(getIntent());
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) && ((getAppRuntime() instanceof QQAppInterface))) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppLBSHandler = ((LBSHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(3));
    f();
    e();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    this.jdField_c_of_type_Float = getResources().getDisplayMetrics().density;
    this.o = getIntent().getIntExtra(jdField_c_of_type_JavaLangString, n);
    this.jdField_p_of_type_Int = getIntent().getIntExtra("filter", 0);
    this.jdField_a_of_type_ArrayOfLong = getIntent().getLongArrayExtra("tags");
    this.q = getIntent().getIntExtra("lat", 0);
    this.r = getIntent().getIntExtra("lon", 0);
    this.jdField_a_of_type_JavaLangString = c();
    this.jdField_c_of_type_Int = getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getInt(this.jdField_a_of_type_JavaLangString, 0);
    if (this.jdField_p_of_type_Int == 4)
    {
      paramBundle = getIntent().getStringExtra("tagName");
      if (paramBundle != null) {
        setTitle(paramBundle);
      }
      this.jdField_a_of_type_AndroidViewView = findViewById(2131231333);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231292));
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new CustomDrawable1(this));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231334));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131562646);
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131233342));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2130903428, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131427370));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
      this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837729);
      b();
      this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter = new PeopleAroundAdapter(this, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager);
      this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.jdField_a_of_type_AndroidViewView = c();
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
      if (this.jdField_p_of_type_Int != 4) {
        break label567;
      }
      a(true, false);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
      }
      return true;
      g();
      break;
      label567:
      c(new cyt(this));
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    e();
    getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putInt(this.jdField_a_of_type_JavaLangString, this.jdField_p_of_type_Int).commit();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.l();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putLong("nearby_enter_time", System.currentTimeMillis()).commit();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    Card localCard;
    if (this.jdField_d_of_type_JavaLangString != null)
    {
      localCard = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if ((localCard == null) || (localCard.shType != 1) || (localCard.vContent == null) || (localCard.vContent.length < 0)) {}
    }
    try
    {
      this.jdField_d_of_type_JavaLangString = new String(localCard.vContent, "utf-8");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      this.jdField_d_of_type_JavaLangString = new String(localCard.vContent);
    }
  }
  
  public void f()
  {
    setTitle(2131562328);
    this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130838011);
    this.jdField_p_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_p_of_type_AndroidWidgetImageView.setContentDescription("更多操作按钮，点击展开");
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0) && (this.jdField_p_of_type_Int < this.jdField_a_of_type_ArrayOfJavaLangString.length)) {
      this.l.setText(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_p_of_type_Int]);
    }
    setTitle(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_p_of_type_Int]);
  }
  
  public void h()
  {
    a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    this.jdField_p_of_type_Int = this.jdField_c_of_type_Int;
    g();
    a(true, false);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_p_of_type_AndroidWidgetImageView)
    {
      if (this.jdField_a_of_type_ArrayOfInt == null) {
        this.jdField_a_of_type_ArrayOfInt = new int[7];
      }
      a(this.jdField_a_of_type_ArrayOfInt);
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return DialogUtil.a(this, 2131562646);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      return true;
    }
    OnClick(null, paramMenuItem.getItemId());
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
    if ((this.jdField_p_of_type_AndroidWidgetImageView != null) && (this.jdField_p_of_type_AndroidWidgetImageView.getVisibility() == 0))
    {
      if (this.jdField_b_of_type_ArrayOfJavaLangString == null)
      {
        this.jdField_b_of_type_ArrayOfJavaLangString = getResources().getStringArray(2131689501);
        a(this.jdField_b_of_type_JavaUtilList);
      }
      int i1;
      int i2;
      switch (this.jdField_p_of_type_Int)
      {
      default: 
        i1 = 0;
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.b(this);
        i2 = 0;
        label92:
        if (i2 >= this.jdField_b_of_type_JavaUtilList.size()) {
          break label334;
        }
        if (2131234394 != ((Integer)((Pair)this.jdField_b_of_type_JavaUtilList.get(i2)).first).intValue()) {
          break;
        }
      }
      for (;;)
      {
        i2 += 1;
        break label92;
        i1 = 2131230849;
        break;
        i1 = 2131230850;
        break;
        i1 = 2131230851;
        break;
        if ((2131230849 == ((Integer)((Pair)this.jdField_b_of_type_JavaUtilList.get(i2)).first).intValue()) || (2131230850 == ((Integer)((Pair)this.jdField_b_of_type_JavaUtilList.get(i2)).first).intValue()) || (2131230851 == ((Integer)((Pair)this.jdField_b_of_type_JavaUtilList.get(i2)).first).intValue()))
        {
          if (((Integer)((Pair)this.jdField_b_of_type_JavaUtilList.get(i2)).first).intValue() == i1) {}
          MenuItemCompat.setShowAsAction(paramMenu.add(0, i2, 0, (CharSequence)((Pair)this.jdField_b_of_type_JavaUtilList.get(i2)).second), 0);
        }
        else
        {
          MenuItemCompat.setShowAsAction(paramMenu.add(0, i2, 0, (CharSequence)((Pair)this.jdField_b_of_type_JavaUtilList.get(i2)).second), 0);
        }
      }
    }
    label334:
    return true;
  }
  
  public void update(Observable paramObservable, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PeopleAroundBaseActivity
 * JD-Core Version:    0.7.0.1
 */