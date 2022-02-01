import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat.ReadInJoyDynamicChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBBCircleFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyFollowFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyTribeChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class ldw
{
  static ldw a;
  String TAG = "ReadInJoyFragmentFactory";
  WeakReference<ReadInJoyNewFeedsActivity> w = null;
  
  public static ReadInJoyBaseFragment a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return ReadInJoyRecommendFeedsFragment.a();
    case 1: 
      ReadInJoyVideoChannelFragment localReadInJoyVideoChannelFragment = new ReadInJoyVideoChannelFragment();
      localReadInJoyVideoChannelFragment.qQ(1002);
      return localReadInJoyVideoChannelFragment;
    case 2: 
      return ReadInJoyFollowFragment.a();
    }
    return new ReadInJoySelfFragment();
  }
  
  public static ldw a()
  {
    try
    {
      if (a == null) {
        a = new ldw();
      }
      return a;
    }
    finally {}
  }
  
  public Fragment a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramTabChannelCoverInfo == null)
    {
      QLog.d(this.TAG, 1, "tabChannelCoverInfo is null.");
      paramTabChannelCoverInfo = (TabChannelCoverInfo)localObject2;
      return paramTabChannelCoverInfo;
    }
    QLog.d(this.TAG, 2, new Object[] { "new Fragment, channelName = ", paramTabChannelCoverInfo.mChannelCoverName, ", channelID = ", Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId) });
    QLog.d(this.TAG, 1, "ReadInJoyConstnats.RECOMMEND= 0");
    if (paramTabChannelCoverInfo.mChannelCoverId == lhn.oC()) {
      localObject1 = ReadInJoyRecommendFeedsFragment.a();
    }
    for (;;)
    {
      paramTabChannelCoverInfo = (TabChannelCoverInfo)localObject1;
      if (!(localObject1 instanceof ReadInJoyBaseFragment)) {
        break;
      }
      ((ReadInJoyBaseFragment)localObject1).no(true);
      return localObject1;
      switch (paramTabChannelCoverInfo.mChannelCoverId)
      {
      default: 
        if (ntp.ej(paramTabChannelCoverInfo.mChannelJumpUrl))
        {
          localObject1 = ReadInJoyViolaChannelFragment.a(paramTabChannelCoverInfo.mChannelCoverId, paramTabChannelCoverInfo.mChannelCoverName, paramTabChannelCoverInfo.mChannelVersion);
          ((ReadInJoyViolaChannelFragment)localObject1).setUrl(paramTabChannelCoverInfo.mChannelJumpUrl);
        }
        break;
      case 0: 
        localObject1 = ReadInJoyRecommendFeedsFragment.a();
        break;
      case 56: 
        localObject1 = new ReadInJoyVideoChannelFragment();
        ((ReadInJoyVideoChannelFragment)localObject1).qQ(1003);
        break;
      case 70: 
        localObject1 = new ReadInJoyBBCircleFragment();
        break;
      case 41522: 
        localObject1 = new ReadInJoyPicWaterFallFragment();
        break;
      case 41450: 
        localObject1 = new ReadInJoyTribeChannelFragment();
        continue;
        if (paramTabChannelCoverInfo.bid > 0L)
        {
          localObject2 = ReadInJoyDynamicChannelBaseFragment.a(ReadInJoyDynamicChannelBaseFragment.bl(paramTabChannelCoverInfo.mChannelCoverId));
          if (localObject2 != null)
          {
            localObject2 = ((npi)localObject2).a();
            if (localObject2 == null) {
              continue;
            }
            if (!TextUtils.isEmpty(((lan)localObject2).eG("cgi"))) {}
            for (paramTabChannelCoverInfo = ReadInJoyCGIDynamicChannelFragment.a(paramTabChannelCoverInfo.mChannelCoverId, 0, paramTabChannelCoverInfo.mChannelCoverName);; paramTabChannelCoverInfo = ReadInJoyDynamicChannelFragment.a(paramTabChannelCoverInfo.mChannelCoverId, 0, paramTabChannelCoverInfo.mChannelCoverName))
            {
              localObject1 = paramTabChannelCoverInfo;
              break;
            }
          }
        }
        localObject1 = ReadInJoySubChannelFragment.a(paramTabChannelCoverInfo.mChannelCoverId, paramTabChannelCoverInfo.mChannelType, paramTabChannelCoverInfo.mChannelCoverName);
      }
    }
  }
  
  public void aKX()
  {
    if (this.w != null)
    {
      this.w.clear();
      this.w = null;
    }
  }
  
  public void b(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity)
  {
    this.w = new WeakReference(paramReadInJoyNewFeedsActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ldw
 * JD-Core Version:    0.7.0.1
 */