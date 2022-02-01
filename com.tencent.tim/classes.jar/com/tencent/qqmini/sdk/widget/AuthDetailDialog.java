package com.tencent.qqmini.sdk.widget;

import NS_COMM.COMM.Entry;
import NS_MINI_INTERFACE.INTERFACE.StExampleDetail;
import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.R.style;
import java.util.ArrayList;

public class AuthDetailDialog
  extends ReportDialog
  implements View.OnClickListener
{
  private static final String TAG = "AuthDialog";
  public static final int TYPE_BOTTOM = 1;
  public static final int TYPE_CENTER = 2;
  private DetailAdapter detailAdapter;
  private int dialogType = 1;
  private ImageView ivBack;
  private ListView lvDetail;
  private Activity mContext;
  private INTERFACE.StSubscribeMessage mCurSubMsg;
  private TextView tvCenterConfirm;
  private TextView tvTitle;
  
  public AuthDetailDialog(@NonNull Activity paramActivity, INTERFACE.StSubscribeMessage paramStSubscribeMessage, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramActivity, R.style.mini_sdk_MiniAppAuthDetailDialog);
    this.mContext = paramActivity;
    this.mCurSubMsg = paramStSubscribeMessage;
    setCanceledOnTouchOutside(true);
    this.dialogType = paramInt3;
    if (1 == paramInt3)
    {
      initBottomDialog(paramActivity);
      paramActivity = getWindow();
      if (paramActivity != null)
      {
        paramActivity.setGravity(80);
        if (paramInt1 > 0)
        {
          paramStSubscribeMessage = getWindow().getAttributes();
          paramStSubscribeMessage.height = paramInt1;
          paramStSubscribeMessage.width = paramInt2;
          paramActivity.setAttributes(paramStSubscribeMessage);
        }
      }
    }
    while (2 != paramInt3) {
      return;
    }
    initCenterDialog(paramActivity);
  }
  
  private void initBottomDialog(@NonNull Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.mini_sdk_auth_detail_dialog, null);
    setContentView(paramContext);
    this.ivBack = ((ImageView)paramContext.findViewById(R.id.iv_auth_detail_back));
    this.tvTitle = ((TextView)paramContext.findViewById(R.id.tv_auth_detail_title));
    this.lvDetail = ((ListView)paramContext.findViewById(R.id.lv_detail_items));
  }
  
  private void initCenterDialog(@NonNull Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.mini_sdk_auth_detail_dialog_center, null);
    setContentView(paramContext);
    this.tvTitle = ((TextView)paramContext.findViewById(R.id.tv_auth_detail_title));
    this.tvCenterConfirm = ((TextView)paramContext.findViewById(R.id.tv_confirm));
    this.lvDetail = ((ListView)paramContext.findViewById(R.id.lv_detail_items));
  }
  
  private void initDetailList()
  {
    if (this.lvDetail == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.mCurSubMsg.example.contents.get());
    this.detailAdapter = new DetailAdapter();
    this.detailAdapter.setData(localArrayList);
    this.lvDetail.setAdapter(this.detailAdapter);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == R.id.iv_auth_detail_back) || (i == R.id.tv_confirm)) {
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void show()
  {
    if ((this.mCurSubMsg != null) && (this.mCurSubMsg.example != null))
    {
      this.tvTitle.setText(this.mCurSubMsg.example.title.get());
      initDetailList();
      if (2 != this.dialogType) {
        break label62;
      }
      this.tvCenterConfirm.setOnClickListener(this);
    }
    for (;;)
    {
      super.show();
      return;
      label62:
      if (1 == this.dialogType) {
        this.ivBack.setOnClickListener(this);
      }
    }
  }
  
  class DetailAdapter
    extends BaseAdapter
  {
    ArrayList<COMM.Entry> detailList = new ArrayList();
    
    DetailAdapter() {}
    
    public int getCount()
    {
      if (this.detailList != null) {
        return this.detailList.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if ((paramInt > -1) && (paramInt < this.detailList.size())) {
        return this.detailList.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      COMM.Entry localEntry = (COMM.Entry)getItem(paramInt);
      Object localObject = paramView;
      if (localEntry != null)
      {
        if (paramView == null) {
          break label84;
        }
        localObject = (DetailViewHolder)paramView.getTag();
      }
      for (;;)
      {
        ((DetailViewHolder)localObject).tvTitle.setText(localEntry.key.get());
        ((DetailViewHolder)localObject).tvDesc.setText(localEntry.value.get());
        localObject = paramView;
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
        return localObject;
        label84:
        paramView = LayoutInflater.from(AuthDetailDialog.this.mContext).inflate(R.layout.mini_sdk_auth_detail_dialog_item_layout, null);
        localObject = new DetailViewHolder(paramView);
        paramView.setTag(localObject);
      }
    }
    
    public void setData(ArrayList<COMM.Entry> paramArrayList)
    {
      this.detailList = paramArrayList;
    }
    
    class DetailViewHolder
    {
      TextView tvDesc;
      TextView tvTitle;
      
      public DetailViewHolder(View paramView)
      {
        this.tvTitle = ((TextView)paramView.findViewById(R.id.detail_item_title));
        this.tvDesc = ((TextView)paramView.findViewById(R.id.detail_item_desc));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.AuthDetailDialog
 * JD-Core Version:    0.7.0.1
 */