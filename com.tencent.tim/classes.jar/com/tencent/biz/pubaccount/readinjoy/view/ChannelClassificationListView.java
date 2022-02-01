package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import aqcx;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kbp;
import kxm;
import ncq;
import ncr;
import org.json.JSONException;
import org.json.JSONObject;

public class ChannelClassificationListView<T extends b>
  extends DisableSlideHorizontalListView
{
  private ChannelClassificationListView<T>.a a;
  private int mChannelId;
  private ArrayList<T> mDataList = new ArrayList();
  private AdapterView.OnItemClickListener mItemClickListener;
  
  public ChannelClassificationListView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ChannelClassificationListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.a = new a(null);
    setAdapter(this.a);
    setDividerWidth(aqcx.dip2px(getContext(), 10.0F));
    setOnScrollStateChangedListener(new ncq(this));
  }
  
  public void setData(int paramInt, ArrayList<T> paramArrayList)
  {
    this.mChannelId = paramInt;
    this.mDataList = paramArrayList;
    this.a.notifyDataSetChanged();
  }
  
  public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.mItemClickListener = paramOnItemClickListener;
  }
  
  public class a
    extends BaseAdapter
  {
    private a() {}
    
    public T a(int paramInt)
    {
      return (ChannelClassificationListView.b)ChannelClassificationListView.a(ChannelClassificationListView.this).get(paramInt);
    }
    
    public int getCount()
    {
      return ChannelClassificationListView.a(ChannelClassificationListView.this).size();
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(ChannelClassificationListView.this.getContext()).inflate(2131562911, paramViewGroup, false);
        paramView.setOnClickListener(new ncr(this, paramViewGroup));
      }
      for (;;)
      {
        Object localObject = (ChannelClassificationListView.b)ChannelClassificationListView.a(ChannelClassificationListView.this).get(paramInt);
        paramView.setTag(Integer.valueOf(paramInt));
        ((TextView)paramView).setText(((ChannelClassificationListView.b)localObject).getName());
        if (!((ChannelClassificationListView.b)localObject).hasReport())
        {
          ((ChannelClassificationListView.b)localObject).setHasReport(true);
          localObject = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject).put("subchannelid", a(paramInt).jq());
          ((JSONObject)localObject).put("subchannelname", a(paramInt).getName());
          ((JSONObject)localObject).put("channelid", ChannelClassificationListView.a(ChannelClassificationListView.this));
          kbp.a(null, kxm.getLongAccountUin() + "", "0X8009932", "0X8009932", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract String getName();
    
    public abstract boolean hasReport();
    
    public abstract String jq();
    
    public abstract void setHasReport(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView
 * JD-Core Version:    0.7.0.1
 */