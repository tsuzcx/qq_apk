package com.tencent.qqmail.bottle.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmail.bottle.controller.BottleManager;

final class CommonUI
{
  private static final String TAG = "CommonUI";
  
  public static void showBottlerDetail(Context paramContext, BottleManager paramBottleManager, String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4)
  {
    ReportDialog localReportDialog = new ReportDialog(paramContext, 2131756097);
    localReportDialog.setContentView(LayoutInflater.from(paramContext).inflate(2131558777, null));
    localReportDialog.setCanceledOnTouchOutside(true);
    ImageView localImageView = (ImageView)localReportDialog.findViewById(2131363592);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131363607);
    localTextView.setText(BottleManager.formatNickName(paramString1));
    if (paramBoolean)
    {
      paramContext = paramContext.getResources().getDrawable(2130838980);
      paramContext.setBounds(0, 0, paramContext.getMinimumWidth(), paramContext.getMinimumHeight());
      localTextView.setCompoundDrawables(null, null, paramContext, null);
    }
    for (;;)
    {
      paramContext = new boolean[1];
      paramContext[0] = 0;
      boolean bool = paramBottleManager.loadAvatar(paramString3, paramString4, 2, new CommonUI.1(paramContext, paramString4, paramString3, localImageView));
      paramBoolean = bool;
      if (!bool) {
        paramBoolean = paramBottleManager.loadAvatar(paramString2, paramString4, 2, new CommonUI.2(paramContext, paramString4, paramString2, localImageView));
      }
      if (!paramBoolean) {
        localImageView.setImageBitmap(paramBottleManager.getDefalAvatar(paramString4, 2));
      }
      localReportDialog.show();
      return;
      paramContext = paramContext.getResources().getDrawable(2130838979);
      paramContext.setBounds(0, 0, paramContext.getMinimumWidth(), paramContext.getMinimumHeight());
      localTextView.setCompoundDrawables(null, null, paramContext, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.CommonUI
 * JD-Core Version:    0.7.0.1
 */