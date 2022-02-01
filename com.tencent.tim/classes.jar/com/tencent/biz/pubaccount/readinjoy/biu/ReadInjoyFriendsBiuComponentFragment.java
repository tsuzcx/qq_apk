package com.tencent.biz.pubaccount.readinjoy.biu;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aofk;
import aqgo;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.a;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiBiuSameContent;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import kbp;
import kpy;
import kpz;
import kqa;
import kqb;
import kwt;
import kxl;
import kxm;
import mas;
import org.json.JSONObject;

public class ReadInjoyFriendsBiuComponentFragment
  extends PublicBaseFragment
{
  private String Wz;
  private String abD;
  private String abE;
  ListView b;
  private String channel_id;
  AdapterView.c e = new kpz(this);
  private String feeds_source;
  View.OnClickListener listener = new kpy(this);
  public FragmentActivity mActivity;
  ImageView mCloseView;
  public ArrayList<MultiBiuSameContent> mContents = new ArrayList();
  TextView oH;
  private String rowkey;
  
  private String a(long paramLong1, int paramInt, long paramLong2)
  {
    String str2 = kwt.acD.replace("uin=", "uin=" + aqgo.encodeToString(String.valueOf(paramLong1).getBytes(), 0).replace('\n', ' ').trim());
    String str1 = str2;
    if (str2.contains("&feedstype=")) {
      str1 = str2.replace("&feedstype=", "&feedstype=" + paramInt);
    }
    str1 = str1 + paramLong2;
    return str1 + "&jumptype=" + 4;
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("algorithm_id", this.abE);
      localJSONObject.put("folder_status", kxm.aMw);
      localJSONObject.put("feeds_source", this.feeds_source);
      localJSONObject.put("feeds_type", paramInt + "");
      localJSONObject.put("kandian_mode", "" + kxm.nR());
      localJSONObject.put("tab_source", "" + kxm.nQ());
      localJSONObject.put("rowkey", this.rowkey);
      localJSONObject.put("channel_id", this.channel_id);
      kbp.a(null, String.valueOf(paramLong1), paramString, paramString, 0, 0, String.valueOf(paramLong2), "0", this.abD, localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private String ao(long paramLong)
  {
    return kwt.acJ + aqgo.encodeToString(String.valueOf(paramLong).getBytes(), 2);
  }
  
  private void mo(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      kxm.aJ(this.mActivity, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoyFriendsBiuComponentFragment", 2, "jumpUrl url:" + paramString);
      }
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mActivity = getActivity();
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      localArrayList = paramBundle.getParcelableArrayList("friends_biu_list");
      this.mContents.addAll(localArrayList);
      this.Wz = paramBundle.getString("articleID");
      this.abD = paramBundle.getString("stategyID");
      this.abE = paramBundle.getString("algorithm_id");
      this.rowkey = paramBundle.getString("rowkey");
      this.channel_id = paramBundle.getString("channel_id");
      this.feeds_source = paramBundle.getString("feeds_source");
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoyFriendsBiuComponentFragment", 2, "onCreate mContents:" + this.mContents.size());
      }
    }
    while (!QLog.isColorLevel())
    {
      ArrayList localArrayList;
      return;
    }
    QLog.d("ReadInjoyFriendsBiuComponentFragment", 2, "onCreate mContents is null or empty");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560389, paramViewGroup, false);
    this.oH = ((TextView)paramLayoutInflater.findViewById(2131367733));
    this.b = ((ListView)paramLayoutInflater.findViewById(2131367660));
    this.b.setSelector(2131167595);
    this.b.setOverScrollMode(0);
    this.mCloseView = ((ImageView)paramLayoutInflater.findViewById(2131364677));
    this.mCloseView.setOnClickListener(this.listener);
    paramLayoutInflater.findViewById(2131363228).setOnClickListener(this.listener);
    paramViewGroup = (LinearLayout)paramLayoutInflater.findViewById(2131362712);
    paramBundle = new a(getActivity(), this.mContents);
    this.b.setAdapter(paramBundle);
    this.b.setOnItemClickListener(this.e);
    if (this.mContents != null) {
      this.oH.setText("Biu列表");
    }
    paramViewGroup.startAnimation(AnimationUtils.loadAnimation(getActivity(), 2130771991));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onFinish()
  {
    if (this.mActivity != null) {
      this.mActivity.overridePendingTransition(0, 0);
    }
  }
  
  public class a
    extends BaseAdapter
  {
    Context mContext;
    ArrayList<MultiBiuSameContent> mData = new ArrayList();
    
    public a(ArrayList<MultiBiuSameContent> paramArrayList)
    {
      this.mContext = paramArrayList;
      Object localObject;
      this.mData = localObject;
    }
    
    public int getCount()
    {
      return this.mData.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.mData.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {}
      for (Object localObject = new ReadInjoyFriendsBiuComponentFragment.b(ReadInjoyFriendsBiuComponentFragment.this, this.mContext);; localObject = (ReadInjoyFriendsBiuComponentFragment.b)paramView.getTag())
      {
        ((ReadInjoyFriendsBiuComponentFragment.b)localObject).a((MultiBiuSameContent)this.mData.get(paramInt), paramInt);
        localObject = ((ReadInjoyFriendsBiuComponentFragment.b)localObject).getContentView();
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject;
      }
    }
  }
  
  public class b
  {
    ReadInJoyUserInfoModule.a jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule$a = new kqa(this);
    mas jdField_a_of_type_Mas = new mas();
    public int aLh;
    private final String abF = "5";
    public String abG;
    ReadInJoyHeadImageView d;
    View mContentView;
    public ArrayList<SocializeFeedsInfo.BiuCommentInfo> mContents;
    TextView mNickName;
    public long mUin;
    TextView oI;
    TextView oJ;
    public long sG;
    
    public b(Context paramContext)
    {
      initView(paramContext);
      this.mContentView.setTag(this);
    }
    
    private void em(long paramLong)
    {
      ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(paramLong, new kqb(this, paramLong));
      String str = ReadInJoyUserInfoModule.getDefaultNickName();
      if (localReadInJoyUserInfo != null) {
        str = localReadInJoyUserInfo.nick;
      }
      this.mNickName.setText(str);
    }
    
    private boolean s(ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList)
    {
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)paramArrayList.next()).ahj)) {
            return false;
          }
        }
      }
      return true;
    }
    
    private void setComments(ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList)
    {
      paramArrayList = SocializeFeedsInfo.a(null, "5", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule$a, paramArrayList);
      this.oJ.setSpannableFactory(aofk.a);
      this.oJ.setText(paramArrayList);
    }
    
    public void a(MultiBiuSameContent paramMultiBiuSameContent, int paramInt)
    {
      em(paramMultiBiuSameContent.mUin);
      this.oJ.setOnClickListener(ReadInjoyFriendsBiuComponentFragment.this.listener);
      Object localObject = kxl.c(paramMultiBiuSameContent.aRW, true);
      if (localObject != null) {
        this.oI.setText((CharSequence)localObject);
      }
      this.d.setTag(Integer.valueOf(paramInt));
      this.d.setHeadImgByUin(paramMultiBiuSameContent.mUin);
      this.mUin = paramMultiBiuSameContent.mUin;
      this.aLh = paramMultiBiuSameContent.aLh;
      this.sG = paramMultiBiuSameContent.vd;
      this.oJ.setTag(Integer.valueOf(paramInt));
      this.mNickName.setTag(Integer.valueOf(paramInt));
      this.mNickName.setOnClickListener(ReadInjoyFriendsBiuComponentFragment.this.listener);
      this.d.setOnClickListener(ReadInjoyFriendsBiuComponentFragment.this.listener);
      this.abG = ReadInjoyFriendsBiuComponentFragment.a(ReadInjoyFriendsBiuComponentFragment.this, paramMultiBiuSameContent.mUin, paramMultiBiuSameContent.aLh, paramMultiBiuSameContent.vd);
      try
      {
        if ((paramMultiBiuSameContent.kW != null) && (!paramMultiBiuSameContent.kW.isEmpty()))
        {
          this.mContents = paramMultiBiuSameContent.kW;
          if (s(paramMultiBiuSameContent.kW))
          {
            this.oJ.setVisibility(8);
            return;
          }
          setComments(this.mContents);
          return;
        }
      }
      catch (Exception paramMultiBiuSameContent)
      {
        QLog.e("ReadInjoyFriendsBiuComponentFragment", 2, "setData: ", paramMultiBiuSameContent);
        return;
      }
      if (TextUtils.isEmpty(paramMultiBiuSameContent.ahj))
      {
        this.oJ.setVisibility(8);
        return;
      }
      localObject = new SpannableStringBuilder();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMultiBiuSameContent.ahj);
      ((SpannableStringBuilder)localObject).append(new aofk(localStringBuilder, 7, 16));
      this.oJ.setText((CharSequence)localObject);
    }
    
    public View getContentView()
    {
      return this.mContentView;
    }
    
    public void initView(Context paramContext)
    {
      this.mContentView = LayoutInflater.from(paramContext).inflate(2131560390, null);
      this.d = ((ReadInJoyHeadImageView)this.mContentView.findViewById(2131368404));
      this.mNickName = ((TextView)this.mContentView.findViewById(2131372369));
      this.oJ = ((TextView)this.mContentView.findViewById(2131364968));
      this.oI = ((TextView)this.mContentView.findViewById(2131363553));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.ReadInjoyFriendsBiuComponentFragment
 * JD-Core Version:    0.7.0.1
 */