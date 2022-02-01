package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import java.util.List;

public class PopupAdapterDividerLine
  extends ArrayAdapter<String>
{
  private List<Integer> mImages;
  private List<String> mList;
  
  public PopupAdapterDividerLine(Context paramContext, int paramInt1, int paramInt2, List<String> paramList, List<Integer> paramList1)
  {
    super(paramContext, paramInt1, paramInt2, paramList);
    this.mList = paramList;
    this.mImages = paramList1;
  }
  
  public int getCount()
  {
    if (this.mList == null) {
      return 0;
    }
    return this.mList.size();
  }
  
  public String getItem(int paramInt)
  {
    if (this.mList == null) {
      return null;
    }
    return (String)this.mList.get(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 1;
    View localView;
    int i;
    if (paramView == null)
    {
      localView = LayoutInflater.from(getContext()).inflate(2131559772, null);
      paramView = new ViewHolder(null);
      paramView.iconImageView = ((ImageView)localView.findViewById(2131373491));
      paramView.textview = ((TextView)localView.findViewById(2131373496));
      paramView.redDotImageView = ((ImageView)localView.findViewById(2131373493));
      localView.setTag(paramView);
      paramView.textview.setText((CharSequence)this.mList.get(paramInt));
      paramView.iconImageView.setImageResource(((Integer)this.mImages.get(paramInt)).intValue());
      boolean bool1 = paramView.textview.getText().toString().trim().equals(QMApplicationContext.sharedInstance().getString(2131720003));
      if ((!QMSettingManager.sharedInstance().getUpgradeFromOldApp()) || (QMSettingManager.sharedInstance().getAppTopBarGuideUpgradedAccount())) {
        break label298;
      }
      i = 1;
      label172:
      if ((!QMPushConfigUtil.showUpgradeVersion()) || (QMSettingManager.sharedInstance().getNewVersionRead())) {
        break label304;
      }
      label187:
      boolean bool2 = paramView.textview.getText().toString().trim().equals(QMApplicationContext.sharedInstance().getString(2131719882));
      if (((!bool1) || ((j == 0) && (i == 0)) || (!QMPushConfigUtil.getTopbarPopWindowHasNewUnClick())) && (!bool2)) {
        break label310;
      }
      paramView.redDotImageView.setVisibility(0);
      label249:
      if (!bool1) {
        break label322;
      }
      QMUIHelper.setBackgroundResource(localView, 2130850550);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      ViewHolder localViewHolder = (ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localViewHolder;
      break;
      label298:
      i = 0;
      break label172;
      label304:
      j = 0;
      break label187;
      label310:
      paramView.redDotImageView.setVisibility(8);
      break label249;
      label322:
      QMUIHelper.setBackgroundResource(localView, 2130850549);
    }
  }
  
  class ViewHolder
  {
    public ImageView iconImageView;
    public ImageView redDotImageView;
    public TextView textview;
    
    private ViewHolder() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.PopupAdapterDividerLine
 * JD-Core Version:    0.7.0.1
 */