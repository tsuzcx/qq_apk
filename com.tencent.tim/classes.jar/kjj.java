import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class kjj
  extends lce
{
  public kjj(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, SparseArray<ChannelInfo> paramSparseArray)
  {
    if (paramInt == 56)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.video.SubChannelActivity", 2, "onGetChannelStatusUpdate(): success == " + paramBoolean);
      }
      if ((paramBoolean) && (paramSparseArray != null) && (paramSparseArray.size() > 0))
      {
        paramSparseArray = (ChannelInfo)paramSparseArray.get(ReadInJoyVideoSubChannelActivity.a(this.this$0));
        if (paramSparseArray != null) {
          ReadInJoyVideoSubChannelActivity.b(this.this$0, paramSparseArray, true);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramInt != ReadInJoyVideoSubChannelActivity.c(this.this$0)) || (ReadInJoyVideoSubChannelActivity.a(this.this$0) == null)) {
      return;
    }
    paramInt = lbz.a().a(Integer.valueOf(paramInt));
    if (paramBoolean1) {
      if ((paramList != null) && (paramInt > 0))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder("onChannelRefreshed ");
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            Long localLong = (Long)localIterator.next();
            localStringBuilder.append("recommendSeq = " + localLong + ",\n ");
          }
          QLog.d("Q.readinjoy.video.SubChannelActivity", 1, localStringBuilder.toString());
        }
        msv.a().of(true);
        this.this$0.setAdapterData(paramList, 1);
        ReadInJoyVideoSubChannelActivity.a(this.this$0).sN(0);
      }
    }
    for (;;)
    {
      ReadInJoyVideoSubChannelActivity.a(this.this$0, paramBoolean1, paramInt);
      this.this$0.bP(paramList);
      return;
      if (ReadInJoyVideoSubChannelActivity.a(this.this$0).isEmpty())
      {
        ReadInJoyVideoSubChannelActivity.a(this.this$0, this.this$0.getResources().getString(2131718494));
        continue;
        if (ReadInJoyVideoSubChannelActivity.a(this.this$0).isEmpty()) {
          ReadInJoyVideoSubChannelActivity.a(this.this$0, this.this$0.getResources().getString(2131718448));
        }
      }
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    boolean bool = true;
    if ((paramInt != ReadInJoyVideoSubChannelActivity.c(this.this$0)) || (ReadInJoyVideoSubChannelActivity.a(this.this$0) == null))
    {
      ReadInJoyVideoSubChannelActivity.d(this.this$0, false);
      return;
    }
    if ((paramBoolean1) && ((paramList == null) || (paramList.size() == ReadInJoyVideoSubChannelActivity.a(this.this$0).getCount())))
    {
      paramBoolean2 = true;
      if ((paramBoolean1) && (paramList != null)) {
        this.this$0.setAdapterData(paramList, 2);
      }
      paramList = this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
      if (paramBoolean2) {
        break label243;
      }
    }
    label243:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      paramList.lA(paramBoolean1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.SubChannelActivity", 2, "autoLoad:" + ReadInJoyVideoSubChannelActivity.c(this.this$0) + " noMoreData:" + paramBoolean2 + " fore:" + GesturePWDUtils.isAppOnForeground(ReadInJoyVideoSubChannelActivity.a(this.this$0)));
      }
      if ((!ReadInJoyVideoSubChannelActivity.c(this.this$0)) && (paramBoolean2) && (GesturePWDUtils.isAppOnForeground(ReadInJoyVideoSubChannelActivity.a(this.this$0))))
      {
        paramList = this.this$0.getResources().getString(2131718335);
        QQToast.a(ReadInJoyVideoSubChannelActivity.a(this.this$0).getApplicationContext(), paramList, 0).show();
      }
      ReadInJoyVideoSubChannelActivity.d(this.this$0, false);
      return;
      paramBoolean2 = false;
      break;
    }
  }
  
  public void j(int paramInt, List<Long> paramList)
  {
    if ((paramInt != ReadInJoyVideoSubChannelActivity.c(this.this$0)) || (ReadInJoyVideoSubChannelActivity.a(this.this$0) == null)) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.this$0.setAdapterData(paramList, 1);
      Object localObject1 = (Long)paramList.get(0);
      Object localObject2 = lbz.a().a(ReadInJoyVideoSubChannelActivity.c(this.this$0), ((Long)localObject1).longValue());
      StringBuilder localStringBuilder = new StringBuilder().append("load history successful ! first article title : ");
      if (localObject2 != null)
      {
        localObject1 = ((ArticleInfo)localObject2).mTitle;
        localObject1 = kxm.ev((String)localObject1);
        localStringBuilder = new StringBuilder().append((String)localObject1).append(" articleID : ");
        if (localObject2 == null) {
          break label252;
        }
      }
      label252:
      for (localObject1 = Long.valueOf(((ArticleInfo)localObject2).mArticleID);; localObject1 = "-1")
      {
        QLog.d("Q.readinjoy.video.SubChannelActivity", 1, localObject1);
        if (!QLog.isColorLevel()) {
          break label270;
        }
        localObject1 = new StringBuilder("onChannelArticleLoaded ");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = (Long)paramList.next();
          ((StringBuilder)localObject1).append("recommendSeq = " + localObject2 + ",\n ");
        }
        localObject1 = "";
        break;
      }
      QLog.d("Q.readinjoy.video.SubChannelActivity", 1, ((StringBuilder)localObject1).toString());
    }
    label270:
    this.this$0.jdField_a_of_type_Kxa.sX = 0L;
    paramList = this.this$0;
    if (!ReadInJoyVideoSubChannelActivity.b(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      bool = ReadInJoyVideoSubChannelActivity.b(paramList, bool);
      if (!ReadInJoyVideoSubChannelActivity.b(this.this$0)) {
        ReadInJoyVideoSubChannelActivity.c(this.this$0, true);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.readinjoy.video.SubChannelActivity", 2, "onChannelArticleLoaded: hasRefresh" + bool);
      return;
    }
  }
  
  public void k(int paramInt, List<Long> paramList)
  {
    if ((paramInt != ReadInJoyVideoSubChannelActivity.c(this.this$0)) || (paramList == null) || (ReadInJoyVideoSubChannelActivity.a(this.this$0) == null)) {
      return;
    }
    ReadInJoyVideoSubChannelActivity.a(this.this$0).cV(lbz.a().a(Integer.valueOf(ReadInJoyVideoSubChannelActivity.c(this.this$0)), paramList));
    ReadInJoyVideoSubChannelActivity.a(this.this$0).notifyDataSetChanged();
  }
  
  public void pe(int paramInt)
  {
    if (paramInt == 97) {
      ReadInJoyVideoSubChannelActivity.b(this.this$0, true);
    }
    while (paramInt != 98) {
      return;
    }
    ReadInJoyVideoSubChannelActivity.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kjj
 * JD-Core Version:    0.7.0.1
 */