import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend.a;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class mbg
  extends BaseAdapter
{
  public mbg(ComponentContentRecommend paramComponentContentRecommend) {}
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public int getCount()
  {
    return ComponentContentRecommend.a(this.this$0).size();
  }
  
  public Object getItem(int paramInt)
  {
    return ComponentContentRecommend.a(this.this$0).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)ComponentContentRecommend.a(this.this$0).get(paramInt);
    ComponentContentRecommend.a(this.this$0).mRecommendFollowInfos.reportMap.put(Long.valueOf(localRecommendFollowInfo.uin), localRecommendFollowInfo);
    ComponentContentRecommend.a locala;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.this$0.getContext()).inflate(2131562915, null, false);
      locala = new ComponentContentRecommend.a(this.this$0);
      locala.k = ((ReadInJoyHeadImageView)paramView.findViewById(2131368406));
      locala.a = ((RingAvatarView)paramView.findViewById(2131376630));
      locala.jk = ((ImageView)paramView.findViewById(2131368464));
      locala.h = ((ReadInJoyNickNameTextView)paramView.findViewById(2131379870));
      locala.qp = ((TextView)paramView.findViewById(2131365744));
      locala.qq = ((TextView)paramView.findViewById(2131363870));
      locala.ev = paramView.findViewById(2131365990);
      paramView.setTag(locala);
    }
    for (;;)
    {
      if (locala != null) {}
      try
      {
        locala.k.setImage(new URL(localRecommendFollowInfo.headUrl));
        mbh localmbh = new mbh(this, localRecommendFollowInfo);
        locala.k.setOnClickListener(localmbh);
        locala.h.setOnClickListener(localmbh);
        locala.qp.setOnClickListener(localmbh);
        if (localRecommendFollowInfo.isStar)
        {
          locala.a.aXX();
          if (!localRecommendFollowInfo.isVip) {
            break label457;
          }
          locala.jk.setVisibility(0);
          locala.h.setText(localRecommendFollowInfo.nickName);
          locala.qp.setText(localRecommendFollowInfo.recommendReason);
          if (!localRecommendFollowInfo.isFollowed) {
            break label470;
          }
          locala.qq.setTextColor(Color.parseColor("#777777"));
          locala.qq.setBackgroundResource(2130850283);
          locala.qq.setOnClickListener(new mbi(this, localRecommendFollowInfo));
          locala.ev.setVisibility(8);
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          locala = (ComponentContentRecommend.a)paramView.getTag();
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.e(ComponentContentRecommend.TAG, 2, "getView, followItem.headUrl = " + localRecommendFollowInfo.headUrl + ", e = " + QLog.getStackTraceString(localMalformedURLException));
          localMalformedURLException.printStackTrace();
          continue;
          locala.a.showNormal();
          continue;
          label457:
          locala.jk.setVisibility(8);
          continue;
          label470:
          locala.qq.setTextColor(-1);
          locala.qq.setBackgroundResource(2130850252);
          locala.qq.setCompoundDrawablePadding(wja.dp2px(3.0F, this.this$0.getResources()));
        }
      }
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mbg
 * JD-Core Version:    0.7.0.1
 */