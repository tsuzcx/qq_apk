package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.uidomain.SendMailInterAppsManager;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialogHelpler;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.view.AttachNamesHandlerTextView;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class PopupAdapter
  extends ArrayAdapter<String>
{
  private List<String> mList;
  
  public PopupAdapter(Context paramContext, int paramInt1, int paramInt2, List<String> paramList)
  {
    super(paramContext, paramInt1, paramInt2, paramList);
    this.mList = paramList;
  }
  
  public boolean areAllItemsEnabled()
  {
    return true;
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
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    ViewHolder localViewHolder;
    int i;
    label177:
    int j;
    label201:
    boolean bool2;
    label256:
    label271:
    Object localObject1;
    if (paramView == null)
    {
      localView = LayoutInflater.from(getContext()).inflate(2131559771, null);
      localViewHolder = new ViewHolder(null);
      localViewHolder.thirdpartyAttachNamesTextView = ((AttachNamesHandlerTextView)localView.findViewById(2131379624));
      localViewHolder.textview = ((TextView)localView.findViewById(2131373495));
      localViewHolder.imageView = ((ImageView)localView.findViewById(2131373492));
      localViewHolder.iconImageView = ((ImageView)localView.findViewById(2131373490));
      localView.setTag(localViewHolder);
      localViewHolder.textview.setVisibility(0);
      localViewHolder.textview.setText((CharSequence)this.mList.get(paramInt));
      boolean bool1 = localViewHolder.textview.getText().toString().trim().equals(QMApplicationContext.sharedInstance().getString(2131720003));
      if ((!QMSettingManager.sharedInstance().getUpgradeFromOldApp()) || (QMSettingManager.sharedInstance().getAppTopBarGuideUpgradedAccount())) {
        break label537;
      }
      i = 1;
      if (((!QMPushConfigUtil.showUpgradeVersion()) && (!QMPushConfigUtil.showBetaVersion())) || (QMSettingManager.sharedInstance().getNewVersionRead())) {
        break label543;
      }
      j = 1;
      bool2 = StringUtils.containsIgnoreCase(localViewHolder.textview.getText(), getContext().getResources().getString(2131718578));
      if ((!bool1) || ((j == 0) && (i == 0)) || (!QMPushConfigUtil.getTopbarPopWindowHasNewUnClick())) {
        break label549;
      }
      localViewHolder.imageView.setVisibility(0);
      if (!bool2) {
        break label562;
      }
      localViewHolder.textview.setVisibility(8);
      if (!bool2) {
        break label617;
      }
      localViewHolder.thirdpartyAttachNamesTextView.setVisibility(0);
      paramView = SendMailInterAppsManager.getInstance().getFilePaths();
      i = paramView.size();
      if (i <= 0) {
        break label655;
      }
      paramView = (String)paramView.get(0);
      localObject1 = paramView.split("/");
      if (!FileUtil.isFileExist(paramView)) {
        break label655;
      }
      if (localObject1.length != 0) {
        break label574;
      }
      paramView = "";
    }
    for (;;)
    {
      label340:
      localObject1 = new String[3];
      localObject1[0] = "添加 ";
      localObject1[1] = paramView;
      if (i == 1)
      {
        paramView = " 为附件";
        label366:
        localObject1[2] = paramView;
        paramView = localViewHolder.thirdpartyAttachNamesTextView;
        String str = localObject1[0];
        Object localObject2 = localObject1[1];
        localObject1 = localObject1[2];
        paramView.setText(str, new String[] { localObject2 }, (String)localObject1, false);
        label413:
        if (!bool2) {
          break label630;
        }
        localViewHolder.iconImageView.setVisibility(0);
        i = getContext().getResources().getDimensionPixelSize(2131297934);
        paramView = (LinearLayout.LayoutParams)localViewHolder.iconImageView.getLayoutParams();
        paramView.width = i;
        paramView.height = i;
        localViewHolder.iconImageView.setLayoutParams(paramView);
        ThirdPartyCallDialogHelpler.setAttachmentImage(getContext(), localViewHolder.iconImageView);
        label486:
        if (paramInt != getCount() - 1) {
          break label643;
        }
        QMUIHelper.setBackgroundResource(localView, 2130850551);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localViewHolder = (ViewHolder)paramView.getTag();
        localView = paramView;
        break;
        label537:
        i = 0;
        break label177;
        label543:
        j = 0;
        break label201;
        label549:
        localViewHolder.imageView.setVisibility(8);
        break label256;
        label562:
        localViewHolder.textview.setVisibility(0);
        break label271;
        label574:
        paramView = localObject1[(localObject1.length - 1)];
        break label340;
        paramView = " 等" + i + "个文件为附件";
        break label366;
        label617:
        localViewHolder.thirdpartyAttachNamesTextView.setVisibility(8);
        break label413;
        label630:
        localViewHolder.iconImageView.setVisibility(8);
        break label486;
        label643:
        QMUIHelper.setBackgroundResource(localView, 2130850548);
      }
      label655:
      paramView = "";
    }
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return true;
  }
  
  class ViewHolder
  {
    public ImageView iconImageView;
    public ImageView imageView;
    public TextView textview;
    public AttachNamesHandlerTextView thirdpartyAttachNamesTextView;
    
    private ViewHolder() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.PopupAdapter
 * JD-Core Version:    0.7.0.1
 */