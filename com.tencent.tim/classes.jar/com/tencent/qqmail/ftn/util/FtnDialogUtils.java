package com.tencent.qqmail.ftn.util;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.qqmail.model.ImageSizeInfo;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;

public class FtnDialogUtils
{
  private static final String BRACKET_LEFT = "(";
  private static final String BRACKET_RIGHT = ")";
  private static final String LARGE_TITLE = "大";
  private static final String LOW_TITLE = "小";
  private static final String MID_TITLE = "中";
  private static final String REAL_TITLE = "原图";
  
  public static QMBottomDialog createChooseCompressImageDialog(Context paramContext, ImageSizeInfo paramImageSizeInfo, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3, View.OnClickListener paramOnClickListener4, View.OnClickListener paramOnClickListener5)
  {
    if (paramImageSizeInfo == null) {
      return null;
    }
    String str3 = StringExtention.getHumanReadable(paramImageSizeInfo.realSize);
    String str1 = setCompressTitle("小", StringExtention.getHumanReadable(paramImageSizeInfo.lowSize));
    String str2 = setCompressTitle("中", StringExtention.getHumanReadable(paramImageSizeInfo.middleSize));
    paramImageSizeInfo = setCompressTitle("大", StringExtention.getHumanReadable(paramImageSizeInfo.highSize));
    str3 = setCompressTitle("原图", str3);
    String str4 = paramContext.getResources().getString(2131691246);
    paramContext = new QMBottomDialog.BottomListSheetBuilder(paramContext);
    paramContext.setTitle(2131691946);
    paramContext.setOnSheetItemClickListener(new FtnDialogUtils.3(str1, paramOnClickListener1, str2, paramOnClickListener2, paramImageSizeInfo, paramOnClickListener3, str3, paramOnClickListener4, str4, paramOnClickListener5));
    paramContext.addItem(str1);
    paramContext.addItem(str2);
    paramContext.addItem(paramImageSizeInfo);
    paramContext.addItem(str3);
    paramContext.addItem(str4);
    paramContext = paramContext.build();
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.show();
    return paramContext;
  }
  
  public static QMUIDialog createDeleteConfirmDialog(Context paramContext, View.OnClickListener paramOnClickListener, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    QMUIDialogAction localQMUIDialogAction1 = new QMUIDialogAction(paramContext, 2131691246, null);
    localQMUIDialogAction1.setOnClickListener(new FtnDialogUtils.1(paramOnClickListener, localQMUIDialogAction1));
    QMUIDialogAction localQMUIDialogAction2 = new QMUIDialogAction(paramContext, 0, 2131694052, 0, 2, null);
    localQMUIDialogAction2.setOnClickListener(new FtnDialogUtils.2(paramOnClickListener, localQMUIDialogAction2));
    paramContext = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(paramContext).setTitle(2131692499)).setMessage(2131692506).addAction(localQMUIDialogAction1)).addAction(localQMUIDialogAction2)).create();
    paramContext.setOnDismissListener(paramOnDismissListener);
    paramContext.show();
    localQMUIDialogAction1.getButton().setTag(Integer.valueOf(7));
    localQMUIDialogAction2.getButton().setTag(Integer.valueOf(4));
    return paramContext;
  }
  
  private static String setCompressTitle(String paramString1, String paramString2)
  {
    return paramString1 + "(" + paramString2 + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.util.FtnDialogUtils
 * JD-Core Version:    0.7.0.1
 */