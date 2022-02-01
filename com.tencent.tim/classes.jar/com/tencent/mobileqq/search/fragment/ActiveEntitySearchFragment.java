package com.tencent.mobileqq.search.fragment;

import acja;
import acnk;
import acnl;
import acnm;
import acnn;
import amkb;
import amke;
import amkl;
import ammb;
import ammd;
import ammh;
import ammm;
import amov;
import ampf;
import ampv;
import amqy;
import amwt;
import amxk;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqdf;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pb.unite.search.DynamicTabSearch.SubHotWord;
import yvg;

public class ActiveEntitySearchFragment
  extends ReportV4Fragment
  implements amke, View.OnClickListener, AbsListView.e
{
  public static String TAG = "Q.uniteSearch." + ActiveEntitySearchFragment.class.getSimpleName();
  public View CQ;
  public ImageView Du;
  public List<Long> FI = new ArrayList();
  private List<DynamicTabSearch.SubHotWord> FJ;
  protected View GV;
  View GW;
  public View GX;
  public View GY;
  public View GZ;
  public XListView S;
  public TextView YF;
  public TextView YG;
  public TextView YH;
  public TextView YI;
  protected acnk a;
  protected acnl a;
  protected acnn a;
  public ammb a;
  private long ajP = -1L;
  public long[] as;
  protected acnm b;
  protected aqdf c;
  public yvg c;
  public boolean cDs = true;
  public boolean cDt;
  public boolean cDu = false;
  private boolean cDv = true;
  public String caF = "";
  public String caQ = "";
  private String caR;
  public boolean cj = false;
  public QQAppInterface d;
  private int dCP;
  public int dCQ = 0;
  public int dCR = 0;
  public byte[] fp;
  private int fromType;
  public Bitmap gi;
  public Button hd;
  public boolean isEnd;
  public boolean isViewCreated;
  public String keyword;
  public LinearLayout kn;
  public XListView listView;
  public View loadingView;
  private int mScrollState;
  public String name;
  public List<ampv> rc;
  
  public ActiveEntitySearchFragment()
  {
    this.jdField_a_of_type_Acnl = new ammd(this);
    this.jdField_a_of_type_Acnn = new ammh(this);
  }
  
  public static ActiveEntitySearchFragment a(int paramInt, long[] paramArrayOfLong, String paramString1, String paramString2)
  {
    ActiveEntitySearchFragment localActiveEntitySearchFragment = new ActiveEntitySearchFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", paramInt);
    localBundle.putLongArray("group_mask_long_array", paramArrayOfLong);
    localBundle.putString("group_name_string", paramString1);
    localBundle.putString("keyword", paramString2);
    localActiveEntitySearchFragment.setArguments(localBundle);
    return localActiveEntitySearchFragment;
  }
  
  public static boolean a(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if ((paramArrayOfLong1 == null) || (paramArrayOfLong2 == null) || (paramArrayOfLong1.length != paramArrayOfLong2.length)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfLong1.length) {
        break label42;
      }
      if (paramArrayOfLong1[i] != paramArrayOfLong2[i]) {
        break;
      }
      i += 1;
    }
    label42:
    return true;
  }
  
  int IS()
  {
    if (this.rc == null) {
      return 0;
    }
    return this.rc.size();
  }
  
  public void Id(String paramString)
  {
    double d2 = 0.0D;
    for (;;)
    {
      double d1;
      try
      {
        Object localObject = this.fp;
        if (localObject != null) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.w(TAG, 2, "hash = " + hashCode() + "   startSearchTAB isEnd = true mask;" + Arrays.toString(this.as) + " key=" + paramString + "  name=" + this.name + " isViewCreated" + this.isViewCreated);
        }
        this.dCR = 0;
        this.dCQ = 0;
        this.keyword = paramString;
        if (this.isViewCreated)
        {
          if (!(getActivity() instanceof amkb)) {
            break label322;
          }
          d1 = ((amkb)getActivity()).getLat();
          d2 = ((amkb)getActivity()).z();
          this.caF = (System.currentTimeMillis() + "");
          this.cj = true;
          localObject = new Bundle();
          if ((getActivity() instanceof ActiveEntitySearchActivity))
          {
            ActiveEntitySearchActivity localActiveEntitySearchActivity = (ActiveEntitySearchActivity)getActivity();
            ((Bundle)localObject).putInt("fromTypeForReport", localActiveEntitySearchActivity.dCz);
            ((Bundle)localObject).putInt("searchAvatarFrom", localActiveEntitySearchActivity.dCC);
          }
          ((Bundle)localObject).putBoolean("isLoadMore", false);
          ((Bundle)localObject).putInt("fromType", this.fromType);
          a(paramString, gf(), null, d1, d2, (Bundle)localObject);
          Pq(false);
          continue;
        }
        this.cDt = true;
      }
      finally {}
      this.caQ = paramString;
      if (QLog.isColorLevel())
      {
        QLog.i(TAG, 2, "startSearch 触发延迟逻辑");
        continue;
        label322:
        d1 = 0.0D;
      }
    }
  }
  
  public void PO(String paramString)
  {
    double d2 = 0.0D;
    for (;;)
    {
      try
      {
        this.YI.setVisibility(8);
        this.loadingView.setVisibility(0);
        if (this.fp != null) {
          amxk.b("all_result", "load_tab", new String[] { paramString, amxk.N(this.FI), "", amxk.a("UnifySearch.Unite", this.as) });
        }
        if ((getActivity() instanceof amkb))
        {
          d1 = ((amkb)getActivity()).getLat();
          d2 = ((amkb)getActivity()).z();
          this.caF = (System.currentTimeMillis() + "");
          if (QLog.isColorLevel()) {
            QLog.w(TAG, 2, "startNewSearchTAB isEnd = true mask;" + Arrays.toString(this.as) + " key=" + paramString + "  name=" + this.name + " reqTime=" + this.caF);
          }
          this.cj = true;
          Bundle localBundle = new Bundle();
          localBundle.putBoolean("isLoadMore", true);
          localBundle.putInt("fromType", this.fromType);
          a(paramString, gf(), this.fp, d1, d2, localBundle);
          Pq(true);
          return;
        }
      }
      finally {}
      double d1 = 0.0D;
    }
  }
  
  public void Pm(boolean paramBoolean)
  {
    this.cDv = paramBoolean;
  }
  
  public void Pq(boolean paramBoolean)
  {
    this.cDt = false;
    if (this.isViewCreated)
    {
      this.CQ.setVisibility(8);
      this.YH.setVisibility(8);
      if (paramBoolean) {
        this.loadingView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.GY.setVisibility(0);
  }
  
  protected ammb a()
  {
    return new ammb(this.listView, this.jdField_c_of_type_Aqdf, this, 0);
  }
  
  protected void a(String paramString, List<Long> paramList, byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, Bundle paramBundle)
  {
    if (this.b != null)
    {
      this.b.b(paramString, this.caF, 20, amkl.b(this.as), paramList, paramArrayOfByte, this.dCP, paramDouble1, paramDouble2, paramBundle);
      return;
    }
    if (this.jdField_a_of_type_Acnk != null)
    {
      this.jdField_a_of_type_Acnk.a(paramString, this.caF, 20, amkl.b(this.as), paramList, paramArrayOfByte, this.dCP, paramDouble1, paramDouble2, paramBundle);
      return;
    }
    QLog.e(TAG, 2, "handler null in frag");
  }
  
  public boolean avY()
  {
    return this.cDv;
  }
  
  protected void dOg()
  {
    if (this.fromType == 10)
    {
      this.b = ((acnm)this.d.getBusinessHandler(111));
      this.jdField_a_of_type_Acnk = null;
      this.d.addObserver(this.jdField_a_of_type_Acnn);
      return;
    }
    this.jdField_a_of_type_Acnk = ((acnk)this.d.getBusinessHandler(152));
    this.b = null;
    this.d.addObserver(this.jdField_a_of_type_Acnl);
  }
  
  public void dOl()
  {
    if ((this.rc != null) && (this.jdField_a_of_type_Ammb != null))
    {
      this.rc.clear();
      this.FI.clear();
      Pm(false);
      this.jdField_a_of_type_Ammb.cS(this.rc);
    }
    if (this.isViewCreated)
    {
      this.GY.setVisibility(8);
      this.loadingView.setVisibility(8);
      this.YH.setVisibility(8);
      this.GZ.setVisibility(8);
      this.CQ.setVisibility(8);
      this.GX.setVisibility(8);
      this.kn.removeAllViews();
    }
  }
  
  public List<Long> gf()
  {
    List localList = new PublicAccountSearchEngine(this.d, this.fromType).a(new amwt(this.keyword));
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList1 = ((acja)this.d.getManager(56)).cx();
    ArrayList localArrayList2 = new ArrayList();
    if ((localArrayList1 == null) || (localArrayList1.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "all publicAccountInfoList is null or empty");
      }
    }
    for (;;)
    {
      return localArrayList2;
      int i = 0;
      while (i < localList.size())
      {
        amqy localamqy = (amqy)localList.get(i);
        int j = 0;
        while (j < localArrayList1.size())
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localArrayList1.get(j);
          if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(localamqy.e.uin))) {
            localArrayList2.add(Long.valueOf(localPublicAccountInfo.uin));
          }
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  public void mc(List<ampv> paramList)
  {
    Object localObject;
    if (getActivity() != null)
    {
      localObject = getActivity().getIntent();
      if (localObject == null) {}
    }
    for (int i = ((Intent)localObject).getIntExtra("from_type_for_report", 0);; i = 0)
    {
      if (i == 9) {
        i = 5;
      }
      for (;;)
      {
        if (i > 0)
        {
          int j = 0;
          for (;;)
          {
            if (j < paramList.size())
            {
              if ((paramList.get(j) instanceof ampf))
              {
                localObject = (ampf)paramList.get(j);
                if ((localObject != null) && ((((ampf)localObject).a() instanceof amov)))
                {
                  localObject = (amov)((ampf)localObject).a();
                  if ((localObject != null) && (((amov)localObject).ajO == 1002L)) {
                    ((amov)localObject).Uz(i);
                  }
                }
              }
              j += 1;
              continue;
              if (i != 3) {
                break label147;
              }
              i = 4;
              break;
            }
          }
        }
        return;
        label147:
        i = 0;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag(2131368647);
    if ((localObject1 instanceof DynamicTabSearch.SubHotWord))
    {
      localObject1 = (DynamicTabSearch.SubHotWord)localObject1;
      this.dCP = ((DynamicTabSearch.SubHotWord)localObject1).word_id.get();
      Object localObject2 = getActivity();
      if ((localObject2 instanceof ActiveEntitySearchActivity))
      {
        localObject2 = (ActiveEntitySearchActivity)localObject2;
        amxk.b("sub_result", "clk_relate", new String[] { this.keyword, ((DynamicTabSearch.SubHotWord)localObject1).search_word.get().toStringUtf8(), "", "" });
        ((ActiveEntitySearchActivity)localObject2).a((DynamicTabSearch.SubHotWord)localObject1);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof UniteSearchActivity)) {
      this.cDu = true;
    }
    if ((localFragmentActivity instanceof BaseActivity))
    {
      this.d = ((BaseActivity)localFragmentActivity).app;
      this.jdField_c_of_type_Aqdf = new aqdf(getActivity(), this.d);
      if (localBundle == null) {
        break label169;
      }
      this.fromType = localBundle.getInt("fromType", -1);
      this.as = localBundle.getLongArray("group_mask_long_array");
      if (this.as == null) {
        throw new RuntimeException("mask array can not be null in ActiveEntitySearchFragment.");
      }
    }
    else
    {
      throw new IllegalStateException("Activity must be instance of BaseActivity");
    }
    if ((this.as.length == 1) && (this.as[0] == 0L)) {
      if (this.fromType != 10) {
        break label179;
      }
    }
    label169:
    label179:
    for (this.as = acnm.ac;; this.as = acnk.ac)
    {
      this.name = localBundle.getString("group_name_string");
      this.keyword = localBundle.getString("keyword");
      dOg();
      super.onCreate(paramBundle);
      return;
    }
  }
  
  /* Error */
  public View onCreateView(android.view.LayoutInflater paramLayoutInflater, android.view.ViewGroup paramViewGroup, Bundle paramBundle)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: aload_3
    //   9: invokespecial 611	android/support/v4/app/Fragment:onCreateView	(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    //   12: pop
    //   13: aload_1
    //   14: ldc_w 612
    //   17: aload_2
    //   18: iconst_0
    //   19: invokevirtual 618	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   22: astore_3
    //   23: aload_0
    //   24: aload_3
    //   25: ldc_w 619
    //   28: invokevirtual 623	android/view/View:findViewById	(I)Landroid/view/View;
    //   31: putfield 343	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:GY	Landroid/view/View;
    //   34: aload_0
    //   35: getfield 343	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:GY	Landroid/view/View;
    //   38: iconst_0
    //   39: invokevirtual 312	android/view/View:setVisibility	(I)V
    //   42: aload_0
    //   43: aload_3
    //   44: ldc_w 624
    //   47: invokevirtual 623	android/view/View:findViewById	(I)Landroid/view/View;
    //   50: putfield 408	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:GZ	Landroid/view/View;
    //   53: aload_0
    //   54: aload_3
    //   55: ldc_w 625
    //   58: invokevirtual 623	android/view/View:findViewById	(I)Landroid/view/View;
    //   61: putfield 339	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:CQ	Landroid/view/View;
    //   64: aload_0
    //   65: aload_3
    //   66: ldc_w 626
    //   69: invokevirtual 623	android/view/View:findViewById	(I)Landroid/view/View;
    //   72: checkcast 303	android/widget/TextView
    //   75: putfield 628	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:YG	Landroid/widget/TextView;
    //   78: aload_0
    //   79: aload_3
    //   80: ldc_w 629
    //   83: invokevirtual 623	android/view/View:findViewById	(I)Landroid/view/View;
    //   86: checkcast 631	android/widget/ImageView
    //   89: putfield 633	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:Du	Landroid/widget/ImageView;
    //   92: aload_0
    //   93: aload_3
    //   94: ldc_w 634
    //   97: invokevirtual 623	android/view/View:findViewById	(I)Landroid/view/View;
    //   100: checkcast 636	android/widget/Button
    //   103: putfield 638	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:hd	Landroid/widget/Button;
    //   106: aload_0
    //   107: aload_3
    //   108: ldc_w 639
    //   111: invokevirtual 623	android/view/View:findViewById	(I)Landroid/view/View;
    //   114: checkcast 641	android/widget/RelativeLayout
    //   117: putfield 643	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:GW	Landroid/view/View;
    //   120: aload_0
    //   121: aload_3
    //   122: ldc_w 644
    //   125: invokevirtual 623	android/view/View:findViewById	(I)Landroid/view/View;
    //   128: checkcast 646	com/tencent/widget/XListView
    //   131: putfield 648	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:S	Lcom/tencent/widget/XListView;
    //   134: aload_0
    //   135: getfield 339	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:CQ	Landroid/view/View;
    //   138: bipush 8
    //   140: invokevirtual 312	android/view/View:setVisibility	(I)V
    //   143: aload_0
    //   144: getfield 408	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:GZ	Landroid/view/View;
    //   147: bipush 8
    //   149: invokevirtual 312	android/view/View:setVisibility	(I)V
    //   152: aload_1
    //   153: ldc_w 649
    //   156: aconst_null
    //   157: iconst_0
    //   158: invokevirtual 618	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   161: astore 9
    //   163: aload_0
    //   164: aload 9
    //   166: ldc_w 650
    //   169: invokevirtual 623	android/view/View:findViewById	(I)Landroid/view/View;
    //   172: putfield 410	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:GX	Landroid/view/View;
    //   175: aload_0
    //   176: aload 9
    //   178: ldc_w 651
    //   181: invokevirtual 623	android/view/View:findViewById	(I)Landroid/view/View;
    //   184: checkcast 303	android/widget/TextView
    //   187: putfield 653	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:YF	Landroid/widget/TextView;
    //   190: aload_0
    //   191: aload 9
    //   193: ldc_w 654
    //   196: invokevirtual 623	android/view/View:findViewById	(I)Landroid/view/View;
    //   199: checkcast 414	android/widget/LinearLayout
    //   202: putfield 412	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:kn	Landroid/widget/LinearLayout;
    //   205: invokestatic 660	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   208: invokevirtual 664	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   211: invokestatic 670	com/tencent/mobileqq/theme/ThemeUtil:isInNightMode	(Lmqq/app/AppRuntime;)Z
    //   214: ifeq +619 -> 833
    //   217: aload_0
    //   218: getfield 410	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:GX	Landroid/view/View;
    //   221: ldc_w 671
    //   224: invokevirtual 674	android/view/View:setBackgroundResource	(I)V
    //   227: aload_0
    //   228: getfield 410	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:GX	Landroid/view/View;
    //   231: bipush 8
    //   233: invokevirtual 312	android/view/View:setVisibility	(I)V
    //   236: aload_0
    //   237: getfield 412	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:kn	Landroid/widget/LinearLayout;
    //   240: invokevirtual 417	android/widget/LinearLayout:removeAllViews	()V
    //   243: aload_1
    //   244: ldc_w 675
    //   247: aconst_null
    //   248: iconst_0
    //   249: invokevirtual 618	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   252: astore 10
    //   254: aload_0
    //   255: aload 10
    //   257: ldc_w 676
    //   260: invokevirtual 623	android/view/View:findViewById	(I)Landroid/view/View;
    //   263: putfield 309	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:loadingView	Landroid/view/View;
    //   266: aload_0
    //   267: getfield 309	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:loadingView	Landroid/view/View;
    //   270: bipush 8
    //   272: invokevirtual 312	android/view/View:setVisibility	(I)V
    //   275: aload_1
    //   276: ldc_w 677
    //   279: aconst_null
    //   280: iconst_0
    //   281: invokevirtual 618	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   284: astore_2
    //   285: aload_2
    //   286: ifnull +111 -> 397
    //   289: aload_0
    //   290: aload_2
    //   291: ldc_w 676
    //   294: invokevirtual 623	android/view/View:findViewById	(I)Landroid/view/View;
    //   297: checkcast 303	android/widget/TextView
    //   300: putfield 341	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:YH	Landroid/widget/TextView;
    //   303: aload_0
    //   304: getfield 341	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:YH	Landroid/widget/TextView;
    //   307: ldc_w 678
    //   310: invokestatic 684	acfp:m	(I)Ljava/lang/String;
    //   313: invokevirtual 688	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   316: aload_0
    //   317: getfield 341	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:YH	Landroid/widget/TextView;
    //   320: ldc_w 689
    //   323: invokevirtual 693	android/widget/TextView:setTextSize	(F)V
    //   326: aload_0
    //   327: getfield 341	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:YH	Landroid/widget/TextView;
    //   330: aload_0
    //   331: invokevirtual 242	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   334: invokevirtual 697	android/support/v4/app/FragmentActivity:getResources	()Landroid/content/res/Resources;
    //   337: ldc_w 698
    //   340: invokevirtual 704	android/content/res/Resources:getColor	(I)I
    //   343: invokevirtual 707	android/widget/TextView:setTextColor	(I)V
    //   346: aload_0
    //   347: getfield 341	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:YH	Landroid/widget/TextView;
    //   350: bipush 8
    //   352: invokevirtual 307	android/widget/TextView:setVisibility	(I)V
    //   355: aload_0
    //   356: aload_3
    //   357: putfield 709	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:GV	Landroid/view/View;
    //   360: aload_0
    //   361: aload_3
    //   362: ldc_w 710
    //   365: invokevirtual 623	android/view/View:findViewById	(I)Landroid/view/View;
    //   368: checkcast 646	com/tencent/widget/XListView
    //   371: putfield 348	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:listView	Lcom/tencent/widget/XListView;
    //   374: aload_0
    //   375: getfield 348	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:listView	Lcom/tencent/widget/XListView;
    //   378: new 712	amml
    //   381: dup
    //   382: aload_0
    //   383: invokespecial 713	amml:<init>	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)V
    //   386: invokevirtual 717	com/tencent/widget/XListView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   389: aload_0
    //   390: getfield 348	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:listView	Lcom/tencent/widget/XListView;
    //   393: aload_2
    //   394: invokevirtual 720	com/tencent/widget/XListView:addFooterView	(Landroid/view/View;)V
    //   397: aload_1
    //   398: ldc_w 677
    //   401: aconst_null
    //   402: iconst_0
    //   403: invokevirtual 618	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   406: astore_1
    //   407: aload_1
    //   408: ifnull +77 -> 485
    //   411: aload_0
    //   412: aload_1
    //   413: ldc_w 676
    //   416: invokevirtual 623	android/view/View:findViewById	(I)Landroid/view/View;
    //   419: checkcast 303	android/widget/TextView
    //   422: putfield 301	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:YI	Landroid/widget/TextView;
    //   425: aload_0
    //   426: getfield 301	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:YI	Landroid/widget/TextView;
    //   429: ldc_w 721
    //   432: invokestatic 684	acfp:m	(I)Ljava/lang/String;
    //   435: invokevirtual 688	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   438: aload_0
    //   439: getfield 301	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:YI	Landroid/widget/TextView;
    //   442: ldc_w 689
    //   445: invokevirtual 693	android/widget/TextView:setTextSize	(F)V
    //   448: aload_0
    //   449: getfield 301	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:YI	Landroid/widget/TextView;
    //   452: aload_0
    //   453: invokevirtual 242	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   456: invokevirtual 697	android/support/v4/app/FragmentActivity:getResources	()Landroid/content/res/Resources;
    //   459: ldc_w 698
    //   462: invokevirtual 704	android/content/res/Resources:getColor	(I)I
    //   465: invokevirtual 707	android/widget/TextView:setTextColor	(I)V
    //   468: aload_0
    //   469: getfield 301	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:YI	Landroid/widget/TextView;
    //   472: bipush 8
    //   474: invokevirtual 307	android/widget/TextView:setVisibility	(I)V
    //   477: aload_0
    //   478: getfield 348	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:listView	Lcom/tencent/widget/XListView;
    //   481: aload_1
    //   482: invokevirtual 720	com/tencent/widget/XListView:addFooterView	(Landroid/view/View;)V
    //   485: aload_0
    //   486: aload_0
    //   487: invokevirtual 723	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	()Lammb;
    //   490: putfield 397	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Ammb	Lammb;
    //   493: aload_0
    //   494: getfield 397	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Ammb	Lammb;
    //   497: iconst_0
    //   498: invokevirtual 726	ammb:Pp	(Z)V
    //   501: aload_0
    //   502: getfield 214	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:as	[J
    //   505: arraylength
    //   506: iconst_1
    //   507: if_icmpne +11 -> 518
    //   510: aload_0
    //   511: getfield 397	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Ammb	Lammb;
    //   514: iconst_1
    //   515: invokevirtual 726	ammb:Pp	(Z)V
    //   518: aload_0
    //   519: getfield 348	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:listView	Lcom/tencent/widget/XListView;
    //   522: aload 9
    //   524: invokevirtual 729	com/tencent/widget/XListView:addHeaderView	(Landroid/view/View;)V
    //   527: aload_0
    //   528: getfield 348	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:listView	Lcom/tencent/widget/XListView;
    //   531: aload_0
    //   532: getfield 397	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Ammb	Lammb;
    //   535: invokevirtual 733	com/tencent/widget/XListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   538: aload_0
    //   539: getfield 348	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:listView	Lcom/tencent/widget/XListView;
    //   542: aload 10
    //   544: invokevirtual 720	com/tencent/widget/XListView:addFooterView	(Landroid/view/View;)V
    //   547: aload_0
    //   548: iconst_1
    //   549: putfield 229	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:isViewCreated	Z
    //   552: invokestatic 202	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   555: ifeq +73 -> 628
    //   558: getstatic 104	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:TAG	Ljava/lang/String;
    //   561: iconst_2
    //   562: new 84	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   569: ldc 204
    //   571: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: aload_0
    //   575: invokevirtual 207	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:hashCode	()I
    //   578: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   581: ldc_w 735
    //   584: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload_0
    //   588: getfield 293	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:cDt	Z
    //   591: invokevirtual 232	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   594: ldc 223
    //   596: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: aload_0
    //   600: getfield 225	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:name	Ljava/lang/String;
    //   603: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: ldc_w 737
    //   609: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: aload_0
    //   613: getfield 214	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:as	[J
    //   616: invokestatic 219	java/util/Arrays:toString	([J)Ljava/lang/String;
    //   619: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 236	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   628: aload_0
    //   629: getfield 293	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:cDt	Z
    //   632: ifeq +275 -> 907
    //   635: dconst_0
    //   636: dstore 4
    //   638: dconst_0
    //   639: dstore 6
    //   641: aload_0
    //   642: invokevirtual 242	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   645: instanceof 244
    //   648: ifeq +31 -> 679
    //   651: aload_0
    //   652: invokevirtual 242	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   655: checkcast 244	amkb
    //   658: invokeinterface 248 1 0
    //   663: dstore 4
    //   665: aload_0
    //   666: invokevirtual 242	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   669: checkcast 244	amkb
    //   672: invokeinterface 251 1 0
    //   677: dstore 6
    //   679: aload_0
    //   680: new 84	java/lang/StringBuilder
    //   683: dup
    //   684: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   687: invokestatic 257	java/lang/System:currentTimeMillis	()J
    //   690: invokevirtual 260	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   693: ldc 110
    //   695: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   701: putfield 114	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:caF	Ljava/lang/String;
    //   704: aload_0
    //   705: aload_0
    //   706: getfield 112	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:caQ	Ljava/lang/String;
    //   709: putfield 238	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:keyword	Ljava/lang/String;
    //   712: aload_0
    //   713: iconst_1
    //   714: putfield 116	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:cj	Z
    //   717: new 151	android/os/Bundle
    //   720: dup
    //   721: invokespecial 152	android/os/Bundle:<init>	()V
    //   724: astore_1
    //   725: aload_0
    //   726: invokevirtual 242	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   729: instanceof 262
    //   732: ifeq +33 -> 765
    //   735: aload_0
    //   736: invokevirtual 242	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   739: checkcast 262	com/tencent/mobileqq/search/activity/ActiveEntitySearchActivity
    //   742: astore_2
    //   743: aload_1
    //   744: ldc_w 264
    //   747: aload_2
    //   748: getfield 267	com/tencent/mobileqq/search/activity/ActiveEntitySearchActivity:dCz	I
    //   751: invokevirtual 157	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   754: aload_1
    //   755: ldc_w 269
    //   758: aload_2
    //   759: getfield 272	com/tencent/mobileqq/search/activity/ActiveEntitySearchActivity:dCC	I
    //   762: invokevirtual 157	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   765: aload_1
    //   766: ldc_w 274
    //   769: iconst_0
    //   770: invokevirtual 278	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   773: aload_1
    //   774: ldc 153
    //   776: aload_0
    //   777: getfield 280	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:fromType	I
    //   780: invokevirtual 157	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   783: aload_0
    //   784: invokevirtual 284	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:gf	()Ljava/util/List;
    //   787: astore_2
    //   788: aload_0
    //   789: aload_0
    //   790: getfield 238	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:keyword	Ljava/lang/String;
    //   793: aload_2
    //   794: aload_0
    //   795: getfield 196	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:fp	[B
    //   798: dload 4
    //   800: dload 6
    //   802: aload_1
    //   803: invokevirtual 287	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Ljava/lang/String;Ljava/util/List;[BDDLandroid/os/Bundle;)V
    //   806: aload_0
    //   807: iconst_0
    //   808: invokevirtual 291	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:Pq	(Z)V
    //   811: aload_0
    //   812: iconst_0
    //   813: putfield 293	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:cDt	Z
    //   816: aload_0
    //   817: getfield 348	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:listView	Lcom/tencent/widget/XListView;
    //   820: aload_0
    //   821: invokevirtual 741	com/tencent/widget/XListView:setOnScrollListener	(Lcom/tencent/widget/AbsListView$e;)V
    //   824: aload_0
    //   825: aload_3
    //   826: invokestatic 747	com/tencent/qqlive/module/videoreport/inject/fragment/V4FragmentCollector:onV4FragmentViewCreated	(Landroid/support/v4/app/Fragment;Landroid/view/View;)V
    //   829: aload_0
    //   830: monitorexit
    //   831: aload_3
    //   832: areturn
    //   833: aload_0
    //   834: getfield 410	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:GX	Landroid/view/View;
    //   837: ldc_w 748
    //   840: invokevirtual 674	android/view/View:setBackgroundResource	(I)V
    //   843: goto -616 -> 227
    //   846: astore_1
    //   847: aload_0
    //   848: monitorexit
    //   849: aload_1
    //   850: athrow
    //   851: astore 11
    //   853: aload 8
    //   855: astore_2
    //   856: invokestatic 202	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   859: ifeq -574 -> 285
    //   862: getstatic 104	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:TAG	Ljava/lang/String;
    //   865: iconst_2
    //   866: aload 11
    //   868: invokestatic 752	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   871: invokestatic 446	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   874: aload 8
    //   876: astore_2
    //   877: goto -592 -> 285
    //   880: astore 8
    //   882: aload_2
    //   883: astore_1
    //   884: invokestatic 202	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   887: ifeq -480 -> 407
    //   890: getstatic 104	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:TAG	Ljava/lang/String;
    //   893: iconst_2
    //   894: aload 8
    //   896: invokestatic 752	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   899: invokestatic 446	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   902: aload_2
    //   903: astore_1
    //   904: goto -497 -> 407
    //   907: aload_0
    //   908: getfield 397	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Ammb	Lammb;
    //   911: aload_0
    //   912: getfield 187	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:rc	Ljava/util/List;
    //   915: invokevirtual 406	ammb:cS	(Ljava/util/List;)V
    //   918: aload_0
    //   919: getfield 343	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:GY	Landroid/view/View;
    //   922: bipush 8
    //   924: invokevirtual 312	android/view/View:setVisibility	(I)V
    //   927: aload_0
    //   928: getfield 408	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:GZ	Landroid/view/View;
    //   931: bipush 8
    //   933: invokevirtual 312	android/view/View:setVisibility	(I)V
    //   936: aload_0
    //   937: getfield 348	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:listView	Lcom/tencent/widget/XListView;
    //   940: iconst_0
    //   941: invokevirtual 753	com/tencent/widget/XListView:setVisibility	(I)V
    //   944: aload_0
    //   945: getfield 187	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:rc	Ljava/util/List;
    //   948: ifnull +15 -> 963
    //   951: aload_0
    //   952: getfield 187	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:rc	Ljava/util/List;
    //   955: invokeinterface 442 1 0
    //   960: ifeq +34 -> 994
    //   963: aload_0
    //   964: getfield 755	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:isEnd	Z
    //   967: ifeq -151 -> 816
    //   970: aload_0
    //   971: getfield 339	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:CQ	Landroid/view/View;
    //   974: iconst_0
    //   975: invokevirtual 312	android/view/View:setVisibility	(I)V
    //   978: aload_0
    //   979: getfield 628	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:YG	Landroid/widget/TextView;
    //   982: ldc_w 756
    //   985: invokestatic 684	acfp:m	(I)Ljava/lang/String;
    //   988: invokevirtual 688	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   991: goto -175 -> 816
    //   994: aload_0
    //   995: getfield 755	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:isEnd	Z
    //   998: ifeq -182 -> 816
    //   1001: aload_0
    //   1002: getfield 341	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:YH	Landroid/widget/TextView;
    //   1005: iconst_0
    //   1006: invokevirtual 307	android/widget/TextView:setVisibility	(I)V
    //   1009: goto -193 -> 816
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1012	0	this	ActiveEntitySearchFragment
    //   0	1012	1	paramLayoutInflater	android.view.LayoutInflater
    //   0	1012	2	paramViewGroup	android.view.ViewGroup
    //   0	1012	3	paramBundle	Bundle
    //   636	163	4	d1	double
    //   639	162	6	d2	double
    //   1	874	8	localObject	Object
    //   880	15	8	localException1	java.lang.Exception
    //   161	362	9	localView1	View
    //   252	291	10	localView2	View
    //   851	16	11	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   5	227	846	finally
    //   227	275	846	finally
    //   275	285	846	finally
    //   289	397	846	finally
    //   397	407	846	finally
    //   411	485	846	finally
    //   485	518	846	finally
    //   518	628	846	finally
    //   628	635	846	finally
    //   641	679	846	finally
    //   679	765	846	finally
    //   765	816	846	finally
    //   816	829	846	finally
    //   833	843	846	finally
    //   856	874	846	finally
    //   884	902	846	finally
    //   907	963	846	finally
    //   963	991	846	finally
    //   994	1009	846	finally
    //   275	285	851	java/lang/Exception
    //   397	407	880	java/lang/Exception
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ActiveEntitySearchActivity.cDf = false;
    this.isViewCreated = false;
    removeObserver();
    this.cj = false;
    if (this.jdField_c_of_type_Aqdf != null) {
      this.jdField_c_of_type_Aqdf.destory();
    }
    if (this.jdField_c_of_type_Yvg != null) {
      this.jdField_c_of_type_Yvg.onDetach();
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "hash = " + hashCode() + "   onDestroyView mask;" + Arrays.toString(this.as) + " key=" + this.keyword + "  name=" + this.name);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Ammb.notifyDataSetChanged();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Ammb == null) || (this.jdField_a_of_type_Ammb.getCount() == 0) || (this.mScrollState == 0)) {}
    while ((paramInt3 - paramInt1 - paramInt2 >= 10) || (this.cj) || (this.isEnd)) {
      return;
    }
    PO(this.keyword);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    QLog.d(TAG + " arend ", 4, " onScrollStateChanged" + paramInt);
    this.mScrollState = paramInt;
    if ((this.jdField_a_of_type_Ammb == null) || (this.jdField_a_of_type_Ammb.getCount() == 0)) {}
    while ((this.jdField_a_of_type_Ammb == null) || (this.jdField_a_of_type_Ammb.getCount() == 0) || (this.mScrollState == 0) || (this.mScrollState == 0) || (!this.isViewCreated) || (this.cj) || (this.isEnd) || (IS() >= 20)) {
      return;
    }
    PO(this.keyword);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.listView.setOnTouchListener(new ammm(this));
  }
  
  protected void removeObserver()
  {
    if (this.fromType == 10)
    {
      this.d.removeObserver(this.jdField_a_of_type_Acnn);
      return;
    }
    this.d.removeObserver(this.jdField_a_of_type_Acnl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment
 * JD-Core Version:    0.7.0.1
 */