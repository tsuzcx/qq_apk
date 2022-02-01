package com.tencent.mobileqq.mini.widget;

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
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;

public class AuthDetailDialog
  extends ReportDialog
  implements View.OnClickListener
{
  private static final String TAG = "AuthDialog";
  public static final int TYPE_BOTTOM = 1;
  public static final int TYPE_CENTER = 2;
  private int dialogType = 1;
  private TextView itemDesc1;
  private TextView itemDesc2;
  private TextView itemDesc3;
  private RelativeLayout itemLayout1;
  private RelativeLayout itemLayout2;
  private RelativeLayout itemLayout3;
  private TextView itemTitle1;
  private TextView itemTitle2;
  private TextView itemTitle3;
  private ImageView ivBack;
  private Activity mContext;
  private INTERFACE.StSubscribeMessage mCurSubMsg;
  private RelativeLayout root;
  private TextView tvCenterConfirm;
  private TextView tvTitle;
  
  public AuthDetailDialog(@NonNull Activity paramActivity, INTERFACE.StSubscribeMessage paramStSubscribeMessage, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramActivity, 2131755430);
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
    paramContext = LayoutInflater.from(paramContext).inflate(2131559575, null);
    setContentView(paramContext);
    this.root = ((RelativeLayout)paramContext.findViewById(2131365859));
    this.ivBack = ((ImageView)paramContext.findViewById(2131369663));
    this.tvTitle = ((TextView)paramContext.findViewById(2131380560));
    this.itemLayout1 = ((RelativeLayout)paramContext.findViewById(2131377384));
    this.itemLayout2 = ((RelativeLayout)paramContext.findViewById(2131377385));
    this.itemLayout3 = ((RelativeLayout)paramContext.findViewById(2131377386));
    this.itemTitle1 = ((TextView)paramContext.findViewById(2131365776));
    this.itemTitle2 = ((TextView)paramContext.findViewById(2131365777));
    this.itemTitle3 = ((TextView)paramContext.findViewById(2131365778));
    this.itemDesc1 = ((TextView)paramContext.findViewById(2131365772));
    this.itemDesc2 = ((TextView)paramContext.findViewById(2131365773));
    this.itemDesc3 = ((TextView)paramContext.findViewById(2131365774));
  }
  
  private void initCenterDialog(@NonNull Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559576, null);
    setContentView(paramContext);
    this.tvTitle = ((TextView)paramContext.findViewById(2131380560));
    this.itemLayout1 = ((RelativeLayout)paramContext.findViewById(2131377384));
    this.itemLayout2 = ((RelativeLayout)paramContext.findViewById(2131377385));
    this.itemLayout3 = ((RelativeLayout)paramContext.findViewById(2131377386));
    this.itemTitle1 = ((TextView)paramContext.findViewById(2131365776));
    this.itemTitle2 = ((TextView)paramContext.findViewById(2131365777));
    this.itemTitle3 = ((TextView)paramContext.findViewById(2131365778));
    this.itemDesc1 = ((TextView)paramContext.findViewById(2131365772));
    this.itemDesc2 = ((TextView)paramContext.findViewById(2131365773));
    this.itemDesc3 = ((TextView)paramContext.findViewById(2131365774));
    this.tvCenterConfirm = ((TextView)paramContext.findViewById(2131380629));
  }
  
  private void loadContentItem(COMM.Entry paramEntry, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.itemTitle1.setText(paramEntry.key.get());
      this.itemDesc1.setText(paramEntry.value.get());
      return;
    case 2: 
      this.itemTitle2.setText(paramEntry.key.get());
      this.itemDesc2.setText(paramEntry.value.get());
      return;
    }
    this.itemTitle3.setText(paramEntry.key.get());
    this.itemDesc3.setText(paramEntry.value.get());
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
      dismiss();
    }
  }
  
  public void show()
  {
    ArrayList localArrayList;
    if ((this.mCurSubMsg != null) && (this.mCurSubMsg.example != null))
    {
      this.tvTitle.setText(this.mCurSubMsg.example.title.get());
      localArrayList = new ArrayList(this.mCurSubMsg.example.contents.get());
      switch (localArrayList.size())
      {
      default: 
        if (2 == this.dialogType) {
          this.tvCenterConfirm.setOnClickListener(this);
        }
        break;
      }
    }
    for (;;)
    {
      super.show();
      return;
      this.itemLayout1.setVisibility(0);
      this.itemLayout2.setVisibility(8);
      this.itemLayout3.setVisibility(8);
      loadContentItem((COMM.Entry)localArrayList.get(0), 1);
      break;
      this.itemLayout1.setVisibility(0);
      this.itemLayout2.setVisibility(0);
      this.itemLayout3.setVisibility(8);
      loadContentItem((COMM.Entry)localArrayList.get(0), 1);
      loadContentItem((COMM.Entry)localArrayList.get(1), 2);
      break;
      this.itemLayout1.setVisibility(0);
      this.itemLayout2.setVisibility(0);
      this.itemLayout3.setVisibility(0);
      loadContentItem((COMM.Entry)localArrayList.get(0), 1);
      loadContentItem((COMM.Entry)localArrayList.get(1), 2);
      loadContentItem((COMM.Entry)localArrayList.get(2), 3);
      break;
      if (1 == this.dialogType) {
        this.ivBack.setOnClickListener(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.AuthDetailDialog
 * JD-Core Version:    0.7.0.1
 */