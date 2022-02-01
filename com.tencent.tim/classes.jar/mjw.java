import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class mjw
  extends BaseAdapter
  implements View.OnClickListener
{
  private List<Long> jf;
  private Context mContext;
  
  public mjw(Context paramContext, List<Long> paramList)
  {
    this.mContext = paramContext;
    this.jf = paramList;
  }
  
  public int getCount()
  {
    if (this.jf != null) {
      return this.jf.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if ((this.jf == null) || (this.jf.size() <= paramInt))
    {
      localObject = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131560445, paramViewGroup, false);
      localObject = new mjw.a();
      ((mjw.a)localObject).dX = ((LinearLayout)paramView.findViewById(2131377556));
      ((mjw.a)localObject).jdField_m_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131369767));
      ((mjw.a)localObject).jdField_m_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131380821));
      paramView.setTag(localObject);
    }
    for (;;)
    {
      if (localObject != null)
      {
        long l = ((Long)this.jf.get(paramInt)).longValue();
        ((mjw.a)localObject).jdField_m_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(l);
        ((mjw.a)localObject).jdField_m_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(l);
        ((mjw.a)localObject).dX.setTag(2131376766, Integer.valueOf(paramInt));
        ((mjw.a)localObject).dX.setOnClickListener(this);
      }
      localObject = paramView;
      break;
      if ((paramView.getTag() instanceof mjw.a)) {
        localObject = (mjw.a)paramView.getTag();
      } else {
        localObject = null;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getTag(2131376766) != null)
      {
        int i = ((Integer)paramView.getTag(2131376766)).intValue();
        if ((this.jf != null) && (this.jf.size() > i)) {
          ksz.f(String.valueOf(this.jf.get(i)), this.mContext);
        }
      }
    }
  }
  
  public static class a
  {
    LinearLayout dX;
    ReadInJoyHeadImageView jdField_m_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
    ReadInJoyNickNameTextView jdField_m_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mjw
 * JD-Core Version:    0.7.0.1
 */