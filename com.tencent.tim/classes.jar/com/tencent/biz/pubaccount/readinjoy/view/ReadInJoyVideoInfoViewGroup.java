package com.tencent.biz.pubaccount.readinjoy.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import aqcx;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import java.util.Set;
import kbp;
import kct;
import kxm;
import ndi;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;

public class ReadInJoyVideoInfoViewGroup
  extends LinearLayout
{
  private final int aVO = 10;
  private Set<Long> ak;
  private BaseArticleInfo j;
  private BaseAdapter mAdapter;
  private int mChannelID;
  private Context mContext;
  private boolean mIsInited;
  private int mWidth;
  
  public ReadInJoyVideoInfoViewGroup(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public ReadInJoyVideoInfoViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  @TargetApi(11)
  public ReadInJoyVideoInfoViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  private void createContent()
  {
    int k;
    int i;
    articlesummary.ChannelInfo localChannelInfo;
    int m;
    if ((getMeasuredWidth() != 0) && (this.j != null) && (!this.mIsInited))
    {
      removeAllViews();
      k = getMeasuredWidth();
      if (this.j.mLabelListObj != null)
      {
        i = 0;
        if (i < this.j.mLabelListObj.size())
        {
          localChannelInfo = (articlesummary.ChannelInfo)this.j.mLabelListObj.get(i);
          if (this.mChannelID == localChannelInfo.uint32_channel_id.get()) {
            m = k;
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      k = m;
      break;
      Object localObject2 = kxm.a(localChannelInfo);
      m = k;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        continue;
      }
      Object localObject1 = new ReadInJoyVideoTopicTextView(this.mContext);
      ((ReadInJoyVideoTopicTextView)localObject1).setTopicText((String)localObject2);
      int n = ((ReadInJoyVideoTopicTextView)localObject1).getViewWidth();
      m = n;
      if (i != 0) {
        m = n + aqcx.dip2px(this.mContext, 10.0F);
      }
      JSONObject localJSONObject;
      if (k > aqcx.dip2px(this.mContext, 1.0F) + m)
      {
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        if (i != 0) {
          ((LinearLayout.LayoutParams)localObject2).setMargins(aqcx.dip2px(this.mContext, 10.0F), 0, 0, 0);
        }
        ((ReadInJoyVideoTopicTextView)localObject1).setId(2131376715);
        ((ReadInJoyVideoTopicTextView)localObject1).setTag(localChannelInfo);
        if ((this.mAdapter instanceof ndi)) {
          ((ReadInJoyVideoTopicTextView)localObject1).setOnClickListener((ndi)this.mAdapter);
        }
        ((ReadInJoyVideoTopicTextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        addView((View)localObject1);
        if (!this.ak.contains(Long.valueOf(this.j.mArticleID))) {
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("channel_id", this.mChannelID);
        label306:
        if (localChannelInfo.uint32_is_topic.get() == 1)
        {
          localObject1 = "0X80088BA";
          label322:
          if (localChannelInfo.uint32_is_topic.get() != 1) {
            break label408;
          }
        }
        label408:
        for (localObject2 = "0X80088BA";; localObject2 = "0X8007BE5")
        {
          kbp.a(null, "", (String)localObject1, (String)localObject2, 0, 0, "2", "", localChannelInfo.uint32_channel_id.get() + "", kct.a("", "", "", "", localJSONObject), false);
          m = k - m;
          break;
          localObject1 = "0X8007BE5";
          break label322;
        }
        this.ak.add(Long.valueOf(this.j.mArticleID));
        this.mIsInited = true;
        return;
      }
      catch (Exception localException)
      {
        break label306;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = getDefaultSize(0, paramInt1);
    int i = k;
    if (k == 0) {
      i = this.mWidth;
    }
    this.mWidth = i;
    super.onMeasure(paramInt1, paramInt2);
    createContent();
  }
  
  public void setArticleInfo(BaseArticleInfo paramBaseArticleInfo, BaseAdapter paramBaseAdapter, int paramInt, Set<Long> paramSet)
  {
    this.j = paramBaseArticleInfo;
    this.mAdapter = paramBaseAdapter;
    this.mChannelID = paramInt;
    this.mIsInited = false;
    this.ak = paramSet;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyVideoInfoViewGroup
 * JD-Core Version:    0.7.0.1
 */