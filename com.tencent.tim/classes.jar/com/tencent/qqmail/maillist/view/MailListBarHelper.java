package com.tencent.qqmail.maillist.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.ui.QMTips;

public final class MailListBarHelper
{
  private static boolean needFolderShowHomeTip = false;
  private static boolean needFolderTopTip = false;
  
  private static boolean canShowFolderShowHomeTip(QMFolder paramQMFolder, int paramInt, boolean paramBoolean)
  {
    return (paramInt > 1) && (!paramBoolean) && (!QMFolderManager.isUniversalSection(paramQMFolder)) && (!shouldExcludeForFolderTopOrShowHome(paramQMFolder.getType()));
  }
  
  public static RelativeLayout initFolderTopOrShowHomeBar(Context paramContext, QMFolder paramQMFolder, QMTips paramQMTips)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2131558459, null);
    localRelativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, paramContext.getResources().getDimensionPixelSize(2131297431), 80));
    paramContext = (TextView)localRelativeLayout.findViewById(2131379750);
    if (needFolderShowHomeTip) {
      paramContext.setText(2131693922);
    }
    localRelativeLayout.setOnClickListener(new MailListBarHelper.1(localRelativeLayout, paramQMTips, paramQMFolder));
    localRelativeLayout.postDelayed(new MailListBarHelper.2(localRelativeLayout), 10000L);
    return localRelativeLayout;
  }
  
  public static boolean isNeedFolderShowHomeTip(QMFolder paramQMFolder, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((!SharedPreferenceUtil.getFolderShowHomeHaveTip()) && (canShowFolderShowHomeTip(paramQMFolder, paramInt2, paramBoolean)))
    {
      paramInt2 = SharedPreferenceUtil.getEnterFolderCntWhenMultiAccount(paramInt1, paramQMFolder.getId());
      if (paramInt2 < 3) {
        break label41;
      }
      SharedPreferenceUtil.setFolderShowHomeHaveTip(true);
      needFolderShowHomeTip = true;
    }
    for (;;)
    {
      return needFolderShowHomeTip;
      label41:
      SharedPreferenceUtil.setEnterFolderCntWhenMultiAccount(paramInt1, paramQMFolder.getId(), paramInt2 + 1);
    }
  }
  
  public static boolean isNeedFolderTopTip()
  {
    return needFolderTopTip;
  }
  
  public static boolean isNeedFolderTopTip(QMFolder paramQMFolder, int paramInt1, int paramInt2)
  {
    if ((!SharedPreferenceUtil.getFolderTopHaveTip()) && (shouldShowFolderTopRightView(paramQMFolder, paramInt2)))
    {
      paramInt2 = SharedPreferenceUtil.getEnterFolderCnt(paramInt1, paramQMFolder.getId());
      if (paramInt2 < 3) {
        break label40;
      }
      SharedPreferenceUtil.setFolderTopHaveTip(true);
      needFolderTopTip = true;
    }
    for (;;)
    {
      return needFolderTopTip;
      label40:
      SharedPreferenceUtil.setEnterFolderCnt(paramInt1, paramQMFolder.getId(), paramInt2 + 1);
    }
  }
  
  public static boolean isNeedInitFolderTopOrShowHomeBar()
  {
    return (needFolderTopTip) || (needFolderShowHomeTip);
  }
  
  public static void resetFolderTipFlag()
  {
    needFolderTopTip = false;
    needFolderShowHomeTip = false;
  }
  
  private static boolean shouldExcludeForFolderTopOrShowHome(int paramInt)
  {
    return (paramInt == 14) || (paramInt == 5) || (paramInt == 6);
  }
  
  public static boolean shouldShowFolderShowHomeRightView(QMFolder paramQMFolder, int paramInt)
  {
    return (paramInt > 1) && (!QMFolderManager.isUniversalSection(paramQMFolder)) && (!shouldExcludeForFolderTopOrShowHome(paramQMFolder.getType()));
  }
  
  public static boolean shouldShowFolderTopRightView(QMFolder paramQMFolder, int paramInt)
  {
    return (paramInt == 1) && (!QMFolderManager.isUniversalSection(paramQMFolder)) && (!shouldExcludeForFolderTopOrShowHome(paramQMFolder.getType()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.view.MailListBarHelper
 * JD-Core Version:    0.7.0.1
 */