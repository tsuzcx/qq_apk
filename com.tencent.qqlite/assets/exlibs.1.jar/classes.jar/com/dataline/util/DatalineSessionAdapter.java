package com.dataline.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.method.LinkMovementMethod;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.dataline.util.file.FileUtil;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import dh;
import di;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class DatalineSessionAdapter
  extends BaseAdapter
{
  private static final int jdField_a_of_type_Int = 0;
  private static final String jdField_a_of_type_JavaLangString = "DatalineSessionAdapter";
  private static final int jdField_b_of_type_Int = 1;
  private static final int jdField_c_of_type_Int = 2;
  private static final int jdField_d_of_type_Int = 3;
  private static final int e = 4;
  private static final int f = 5;
  private static final int g = 6;
  private static final int h = 7;
  private static final int i = 8;
  private static final int j = 9;
  private static final int k = 10;
  private static final int l = 11;
  private static final int m = 12;
  private static final int n = 13;
  private static final int o = 14;
  private final long jdField_a_of_type_Long = 1024L;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new dh(this);
  private LiteActivity jdField_a_of_type_ComDatalineActivitiesLiteActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DataLineMsgSetList jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
  Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private final long jdField_b_of_type_Long;
  private final long jdField_c_of_type_Long;
  private long jdField_d_of_type_Long;
  private int p = 0;
  private int q = 0;
  
  public DatalineSessionAdapter(Context paramContext, DataLineMsgSetList paramDataLineMsgSetList, LiteActivity paramLiteActivity, QQAppInterface paramQQAppInterface)
  {
    this.b = 1048576L;
    this.c = 1073741824L;
    this.d = 0L;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = paramDataLineMsgSetList;
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity = paramLiteActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.p = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492877);
    this.q = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492878);
    a();
  }
  
  private String a(long paramLong)
  {
    double d1 = paramLong;
    BigDecimal localBigDecimal;
    if (paramLong >= 1073741824L)
    {
      localBigDecimal = new BigDecimal(d1 / 1073741824.0D);
      return localBigDecimal.setScale(2, RoundingMode.HALF_UP) + "GB";
    }
    if (paramLong >= 1048576L)
    {
      localBigDecimal = new BigDecimal(d1 / 1048576.0D);
      return localBigDecimal.setScale(2, RoundingMode.HALF_UP) + "MB";
    }
    if (paramLong >= 1024L)
    {
      localBigDecimal = new BigDecimal(d1 / 1024.0D);
      return localBigDecimal.setScale(2, RoundingMode.HALF_UP) + "KB";
    }
    return paramLong + "B";
  }
  
  private void a(GridView paramGridView)
  {
    int i1 = (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getWindowManager().getDefaultDisplay().getWidth() - AIOUtils.a(147.0F, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources()) - 2) / 3;
    paramGridView.setNumColumns(3);
    paramGridView.setColumnWidth(i1);
    paramGridView.setHorizontalSpacing(1);
    paramGridView.setSelector(new ColorDrawable(0));
    paramGridView.setTag(Integer.valueOf(i1));
    paramGridView.setClickable(true);
    paramGridView.setLongClickable(true);
    paramGridView.setAddStatesFromChildren(true);
  }
  
  private void a(ItemHolder paramItemHolder, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        Bitmap localBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130837555), paramInt1, paramInt2, false);
        Object localObject1 = ImageUtil.a(localBitmap, AIOUtils.a(12.0F, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources()));
        localObject3 = localObject1;
        if (localBitmap != null) {}
        localObject3 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          localBitmap.recycle();
          localObject3 = localObject1;
          if (localObject3 == null) {
            break;
          }
          localObject1 = new ClipDrawable(new BitmapDrawable(localObject3), 48, 2);
          paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable((Drawable)localObject1);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Object localObject3;
          Object localObject2;
          break label102;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        localObject2 = null;
      }
      label102:
      if (QLog.isColorLevel())
      {
        QLog.e("DatalineSessionAdapter", 2, "DataLineSessionAdapter OOM");
        localObject3 = localObject2;
      }
    }
    paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable(null);
  }
  
  private void a(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {}
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
    } while (paramDataLineMsgSet == null);
    int i1 = (int)(paramDataLineMsgSet.progress * 100.0F);
    paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
    FileManagerUtil.a(paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView, paramDataLineMsgSet);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(paramDataLineMsgSet.filename));
    paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(FileUtil.a(paramDataLineMsgSet.filesize));
    if (paramDataLineMsgSet.isSendFromLocal()) {
      if (paramDataLineMsgSet.fileMsgStatus == 2L) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131361895);
      }
    }
    while ((paramDataLineMsgSet.progress == 1.0F) || (!paramDataLineMsgSet.issuc) || (paramDataLineMsgSet.fileMsgStatus == 1L) || (paramDataLineMsgSet.fileMsgStatus == 2L))
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
      if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc))
      {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362026);
      }
      else if (!paramDataLineMsgSet.issuc)
      {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362029);
      }
      else
      {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(i1 + "%");
        continue;
        if (paramDataLineMsgSet.fileMsgStatus == 2L) {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131361895);
        } else if (paramDataLineMsgSet.fileMsgStatus == 1L) {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362027);
        } else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc)) {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362024);
        } else if (!paramDataLineMsgSet.issuc) {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362030);
        } else {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(i1 + "%");
        }
      }
    }
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i1);
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, RelativeLayout paramRelativeLayout, ItemHolder paramItemHolder)
  {
    paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a((int)paramDataLineMsgRecord.vipBubbleID, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
    if (paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null)
    {
      paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramRelativeLayout, null);
      if (paramDataLineMsgRecord.msgtype == -1000) {
        break label101;
      }
    }
    label101:
    for (boolean bool = true;; bool = false)
    {
      paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDataLineMsgRecord.isSendFromLocal(), true, bool, paramRelativeLayout);
      if (paramDataLineMsgRecord.msgtype == -1000) {
        a(paramItemHolder, paramRelativeLayout, paramDataLineMsgRecord, paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
      }
      a(paramRelativeLayout, paramDataLineMsgRecord);
      return;
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList == null) || (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size() == 0);
  }
  
  private boolean a(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {}
    do
    {
      return true;
      if (paramItemHolder.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView == null) {
        return false;
      }
    } while (paramDataLineMsgSet == null);
    int i1 = paramDataLineMsgSet.getCompletedCount();
    int i2 = paramDataLineMsgSet.getTotalCount();
    DataLineMsgRecord localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    if ((paramDataLineMsgSet.getAt(0) != null) && (paramDataLineMsgSet.getAt(0).strMoloIconUrl != null))
    {
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(0).strMoloIconUrl);
      if ((paramDataLineMsgSet.getTotalCount() < 2) || (paramDataLineMsgSet.getAt(1) == null) || (paramDataLineMsgSet.getAt(1).strMoloIconUrl == null)) {
        break label493;
      }
      paramItemHolder.a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(1).strMoloIconUrl);
      label128:
      if ((paramDataLineMsgSet.getTotalCount() < 3) || (paramDataLineMsgSet.getAt(2) == null) || (paramDataLineMsgSet.getAt(2).strMoloIconUrl == null)) {
        break label509;
      }
      paramItemHolder.a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(2).strMoloIconUrl);
      label173:
      if ((paramDataLineMsgSet.getTotalCount() < 4) || (paramDataLineMsgSet.getAt(3) == null) || (paramDataLineMsgSet.getAt(3).strMoloIconUrl == null)) {
        break label525;
      }
      paramItemHolder.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(3).strMoloIconUrl);
      label218:
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(paramDataLineMsgSet.getFileNames()));
      if ((localDataLineMsgRecord.strMoloSource == null) || (!localDataLineMsgRecord.strMoloSource.contains(this.jdField_a_of_type_AndroidContentContext.getString(2131361896)))) {
        break label541;
      }
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      label298:
      paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(a(paramDataLineMsgSet.getFileTotalSize()));
      if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
        break label579;
      }
      paramItemHolder.a().e.setText(localDataLineMsgRecord.strMoloSource);
      paramItemHolder.a().e.setVisibility(0);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label375:
      if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
        break label594;
      }
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label423:
      if (!paramDataLineMsgSet.isCanceled()) {
        break label609;
      }
      paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131361895);
    }
    for (;;)
    {
      if (((paramDataLineMsgSet.hasSendingOrRecving()) || (paramDataLineMsgSet.hasWaiting())) && (!paramDataLineMsgSet.isFileComing())) {
        break label710;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return true;
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130838502);
      break;
      label493:
      paramItemHolder.a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130838502);
      break label128;
      label509:
      paramItemHolder.a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130838502);
      break label173;
      label525:
      paramItemHolder.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130838502);
      break label218;
      label541:
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131361886);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      break label298;
      label579:
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label375;
      label594:
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label423;
      label609:
      if (paramDataLineMsgSet.isFileComing()) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362027);
      } else if (i1 == i2) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText("" + i2);
      } else {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(i1 + "/" + i2);
      }
    }
    label710:
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
    return true;
  }
  
  private void b(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {}
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
    } while (paramDataLineMsgSet == null);
    int i1 = (int)(paramDataLineMsgSet.progress * 100.0F);
    if (paramDataLineMsgSet.strMoloIconUrl != null)
    {
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.strMoloIconUrl);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(paramDataLineMsgSet.filename));
      if ((paramDataLineMsgSet.strMoloSource == null) || (!paramDataLineMsgSet.strMoloSource.contains(this.jdField_a_of_type_AndroidContentContext.getString(2131361896)))) {
        break label334;
      }
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      label127:
      paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(a(paramDataLineMsgSet.filesize));
      if ((paramDataLineMsgSet.strMoloSource == null) || (paramDataLineMsgSet.strMoloSource.equals(""))) {
        break label372;
      }
      paramItemHolder.a().e.setText(paramDataLineMsgSet.strMoloSource);
      paramItemHolder.a().e.setVisibility(0);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label201:
      if ((paramDataLineMsgSet.strMoloSrcIconUrl == null) || (paramDataLineMsgSet.strMoloSrcIconUrl.equals(""))) {
        break label387;
      }
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(paramDataLineMsgSet.strMoloSrcIconUrl);
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label246:
      if (paramDataLineMsgSet.fileMsgStatus != 2L) {
        break label402;
      }
      paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131361895);
    }
    for (;;)
    {
      if ((paramDataLineMsgSet.progress != 1.0F) && (paramDataLineMsgSet.issuc) && (paramDataLineMsgSet.fileMsgStatus != 1L) && (paramDataLineMsgSet.fileMsgStatus != 2L)) {
        break label515;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130838502);
      break;
      label334:
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131361886);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      break label127;
      label372:
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label201;
      label387:
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label246;
      label402:
      if (paramDataLineMsgSet.fileMsgStatus == 1L) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362027);
      } else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc)) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362024);
      } else if (!paramDataLineMsgSet.issuc) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131362030);
      } else {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(i1 + "%");
      }
    }
    label515:
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i1);
  }
  
  private boolean b(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {
      return true;
    }
    if (paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView == null) {
      return false;
    }
    if (paramDataLineMsgSet == null) {
      return true;
    }
    int i1 = paramDataLineMsgSet.getCompletedCount();
    int i2 = paramDataLineMsgSet.getTotalCount();
    DataLineMsgRecord localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    di localdi;
    label148:
    label313:
    if (i1 == i2)
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText("" + i2);
      i1 = ((Integer)paramItemHolder.a().jdField_a_of_type_AndroidWidgetGridView.getTag()).intValue();
      localdi = (di)paramItemHolder.a().jdField_a_of_type_AndroidWidgetGridView.getAdapter();
      if (localdi != null) {
        break label401;
      }
      localdi = new di(this, paramItemHolder, paramDataLineMsgSet, i1, null);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetGridView.setAdapter(localdi);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramDataLineMsgSet.printlog();
      if (((paramDataLineMsgSet.hasSendingOrRecving()) || (paramDataLineMsgSet.hasWaiting())) && (!paramDataLineMsgSet.isFileComing())) {
        break label455;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      if (!paramDataLineMsgSet.isCanceled()) {
        break label421;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131361895);
      label227:
      if (!paramDataLineMsgSet.isSendFromLocal())
      {
        paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (localDataLineMsgRecord.strMoloKey != null)
        {
          if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
            break label488;
          }
          paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(localDataLineMsgRecord.strMoloSource);
          paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
            break label503;
          }
          paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
          paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      return true;
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(i1 + "/" + i2);
      break;
      label401:
      localdi.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = paramDataLineMsgSet;
      localdi.jdField_a_of_type_ComDatalineUtilItemHolder = paramItemHolder;
      localdi.a();
      break label148;
      label421:
      if (!paramDataLineMsgSet.isFileComing()) {
        break label227;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131362027);
      break label227;
      label455:
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
      break label227;
      label488:
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label313;
      label503:
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  private void c(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {}
    DataLineMsgRecord localDataLineMsgRecord;
    label124:
    do
    {
      do
      {
        do
        {
          return;
        } while (paramDataLineMsgSet == null);
        localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
      } while (localDataLineMsgRecord == null);
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(this.p, this.q);
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImageByMargin();
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(true);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((localDataLineMsgRecord.path == null) || (!new File(localDataLineMsgRecord.path).exists())) {
        break;
      }
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(localDataLineMsgRecord.path);
      if ((localDataLineMsgRecord.progress != 1.0F) && (localDataLineMsgRecord.issuc) && (localDataLineMsgRecord.fileMsgStatus != 1L) && (localDataLineMsgRecord.fileMsgStatus != 2L)) {
        break label419;
      }
      paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if ((localDataLineMsgRecord.fileMsgStatus != 1L) || (localDataLineMsgRecord.thumbPath != null)) {
        break label404;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(2131361867);
      if (paramDataLineMsgSet.isSendFromLocal()) {
        break label475;
      }
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    } while (localDataLineMsgRecord.strMoloKey == null);
    label230:
    if ((localDataLineMsgRecord.strMoloSource != null) && (!localDataLineMsgRecord.strMoloSource.equals("")))
    {
      paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(localDataLineMsgRecord.strMoloSource);
      paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    for (;;)
    {
      if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
        break label492;
      }
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      return;
      if (localDataLineMsgRecord.thumbPath != null)
      {
        paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(localDataLineMsgRecord.thumbPath);
        break label124;
      }
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageDrawableDefault();
      break label124;
      label404:
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label230;
      label419:
      if (localDataLineMsgRecord.isSendFromLocal())
      {
        paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        int i1 = (int)(localDataLineMsgRecord.progress * 100.0F);
        paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(i1);
        break label230;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      break label230;
      label475:
      break;
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    label492:
    paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
  }
  
  private void d(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {}
    while (paramDataLineMsgSet == null) {
      return;
    }
    paramItemHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramItemHolder);
    if ((paramDataLineMsgSet.hasFailed()) && (!paramDataLineMsgSet.hasSendingOrRecving()) && (!paramDataLineMsgSet.hasWaiting())) {}
    for (int i1 = 1; i1 == 0; i1 = 0)
    {
      paramItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
    paramItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!paramDataLineMsgSet.isSendFromLocal())
    {
      paramItemHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b);
      return;
    }
    paramItemHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size() > 0)
    {
      this.d = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(0).getTime();
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(0).getMsgId()), Boolean.valueOf(true));
      int i1 = 1;
      while (i1 < this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(i1).getTime() > this.d + 180L)
        {
          this.d = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(i1).getTime();
          this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(i1).getMsgId()), Boolean.valueOf(true));
        }
        i1 += 1;
      }
    }
  }
  
  public void a(long paramLong, ListView paramListView, float paramFloat)
  {
    Object localObject = null;
    if (paramListView == null) {}
    label7:
    int i1;
    DataLineMsgSet localDataLineMsgSet;
    label243:
    do
    {
      float f1;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              i1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.getSetIndex(paramLong);
            } while (i1 == -1);
            paramListView = paramListView.getChildAt(i1 - paramListView.q());
          } while ((paramListView == null) || (i1 >= this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size()));
          localDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(i1);
          if (localDataLineMsgSet.mUpdateProcessTick == 0L) {}
          for (localDataLineMsgSet.mUpdateProcessTick = System.currentTimeMillis();; localDataLineMsgSet.mUpdateProcessTick = System.currentTimeMillis())
          {
            if (!localDataLineMsgSet.isSingle()) {
              break label350;
            }
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(paramLong);
            if (localObject == null) {
              break;
            }
            f1 = paramFloat;
            if (paramFloat < ((DataLineMsgRecord)localObject).progress) {
              f1 = ((DataLineMsgRecord)localObject).progress;
            }
            switch (((DataLineMsgRecord)localObject).msgtype)
            {
            default: 
              return;
            case -2335: 
            case -2009: 
            case -2005: 
              if (!((DataLineMsgRecord)localObject).bIsMoloImage) {
                break label243;
              }
              paramListView = (MessageProgressTextView)paramListView.findViewById(2131296967);
              if (paramListView == null) {
                break label7;
              }
              paramListView.setProgress((int)(f1 * 100.0F));
              return;
              if (System.currentTimeMillis() - localDataLineMsgSet.mUpdateProcessTick < 1000L) {
                break label7;
              }
            }
          }
          localObject = (TextView)paramListView.findViewById(2131296949);
          paramListView = (ProgressBar)paramListView.findViewById(2131296950);
          if (paramListView != null)
          {
            paramListView.setVisibility(0);
            paramListView.setProgress((int)(f1 * 100.0F));
          }
        } while (localObject == null);
        ((TextView)localObject).setText((int)(f1 * 100.0F) + "%");
        return;
        paramListView = (MessageProgressTextView)paramListView.findViewById(2131296967);
      } while (paramListView == null);
      paramListView.setProgress((int)(f1 * 100.0F));
      return;
      paramListView = (ItemHolder)paramListView.getTag();
    } while (paramListView == null);
    label350:
    int i2;
    switch (localDataLineMsgSet.getGroupType())
    {
    default: 
      paramListView = null;
      label410:
      i1 = localDataLineMsgSet.getCompletedCount();
      i2 = localDataLineMsgSet.getTotalCount();
      if (localObject != null)
      {
        if (i1 != i2) {
          break label510;
        }
        ((TextView)localObject).setText("" + i2);
      }
      break;
    }
    while (paramListView != null)
    {
      if (i1 != i2) {
        break label544;
      }
      paramListView.setVisibility(4);
      return;
      localObject = paramListView.a().jdField_d_of_type_AndroidWidgetTextView;
      paramListView = paramListView.a().jdField_a_of_type_AndroidWidgetProgressBar;
      break label410;
      paramListView = paramListView.a().jdField_a_of_type_AndroidWidgetProgressBar;
      break label410;
      label510:
      ((TextView)localObject).setText(i1 + "/" + i2);
    }
    label544:
    paramListView.setVisibility(0);
    paramListView.setProgress((int)(localDataLineMsgSet.getTotalProcess() * 100.0F));
  }
  
  protected void a(View paramView, DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord.isSendFromLocal())
    {
      paramView.setPadding(BaseChatItemLayout.l, BaseChatItemLayout.i, BaseChatItemLayout.k, BaseChatItemLayout.j);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.i, BaseChatItemLayout.l, BaseChatItemLayout.j);
  }
  
  protected void a(ItemHolder paramItemHolder, View paramView, DataLineMsgRecord paramDataLineMsgRecord, BubbleInfo paramBubbleInfo)
  {
    if (paramBubbleInfo == null) {
      return;
    }
    if ((paramBubbleInfo.a == 0) || (!paramBubbleInfo.a()))
    {
      paramBubbleInfo = paramView.getResources();
      if (paramDataLineMsgRecord.isSendFromLocal())
      {
        paramView = paramBubbleInfo.getColorStateList(2131427476);
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView);
        if (!paramDataLineMsgRecord.isSendFromLocal()) {
          break label95;
        }
      }
      label95:
      for (paramView = paramBubbleInfo.getColorStateList(2131427475);; paramView = paramBubbleInfo.getColorStateList(2131427474))
      {
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView);
        return;
        paramView = paramBubbleInfo.getColorStateList(2131427473);
        break;
      }
    }
    if (paramBubbleInfo.c == 0) {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramBubbleInfo.d == 0)
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131427474));
      return;
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.c);
    }
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramBubbleInfo.d);
  }
  
  public boolean a(long paramLong, ListView paramListView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramLong);
    if (a()) {
      return false;
    }
    if (paramListView == null) {
      return true;
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.getSetIndex(paramLong);
    if (i1 == -1) {
      return false;
    }
    View localView = paramListView.getChildAt(i1 - paramListView.q());
    if (localView == null) {
      return false;
    }
    if (i1 >= this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size()) {
      return false;
    }
    paramListView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(i1);
    if ((localObject != null) && (((DataLineMsgRecord)localObject).fileMsgStatus == 1L)) {
      if (paramListView.mUpdateMutiViewTick != 0L) {
        break label130;
      }
    }
    for (paramListView.mUpdateMutiViewTick = System.currentTimeMillis(); paramListView.isSingle(); paramListView.mUpdateMutiViewTick = System.currentTimeMillis())
    {
      return true;
      label130:
      if (System.currentTimeMillis() - paramListView.mUpdateMutiViewTick < 1000L) {
        return true;
      }
    }
    localObject = (ItemHolder)localView.getTag();
    if (localObject == null) {
      return false;
    }
    switch (paramListView.getGroupType())
    {
    }
    do
    {
      do
      {
        do
        {
          d((ItemHolder)localObject, paramListView);
          return true;
          if (!paramListView.getFirstItem().bIsMoloImage) {
            break;
          }
        } while (b((ItemHolder)localObject, paramListView));
        return false;
      } while (a((ItemHolder)localObject, paramListView));
      return false;
    } while (b((ItemHolder)localObject, paramListView));
    return false;
  }
  
  public int getCount()
  {
    if (a()) {
      return 1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (a()) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i1 = 1;
    if (a()) {
      paramInt = 13;
    }
    label113:
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      DataLineMsgSet localDataLineMsgSet;
      boolean bool;
      do
      {
        return paramInt;
        localDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
        bool = localDataLineMsgSet.isSendFromLocal();
        switch (localDataLineMsgSet.getGroupType())
        {
        default: 
          return 12;
        case -1000: 
          if (bool) {
            return 7;
          }
          return 0;
        case -2000: 
          if (!localDataLineMsgSet.isSingle()) {
            break label113;
          }
          paramInt = i1;
        }
      } while (!bool);
      return 8;
      if (bool) {
        return 9;
      }
      return 2;
      if (localDataLineMsgSet.isSingle())
      {
        if (bool) {
          return 10;
        }
        return 3;
      }
      if (bool) {
        return 11;
      }
      return 4;
      localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
      if (!localDataLineMsgSet.isSingle()) {
        break;
      }
      paramInt = i1;
    } while (localDataLineMsgRecord.bIsMoloImage);
    return 5;
    if (localDataLineMsgRecord.bIsMoloImage) {
      return 2;
    }
    return 6;
  }
  
  @TargetApi(8)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (a()) {
      if (paramView == null)
      {
        paramView = new ItemHolder();
        localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903167, null);
        ((View)localObject).setTag(paramView);
      }
    }
    DataLineMsgSet localDataLineMsgSet;
    DataLineMsgRecord localDataLineMsgRecord;
    label159:
    do
    {
      return localObject;
      paramViewGroup = (ItemHolder)paramView.getTag();
      return paramView;
      localDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
      if (localDataLineMsgSet == null) {
        return null;
      }
      paramInt = getItemViewType(paramInt);
      localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
      if (paramView != null) {
        break label2163;
      }
      localObject = new ItemHolder();
      if (paramInt != 12) {
        break;
      }
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903160, null);
      ((ItemHolder)localObject).b((TextView)paramViewGroup.findViewById(2131296979));
      paramView = paramViewGroup;
      if (((ItemHolder)localObject).b() != null)
      {
        ((ItemHolder)localObject).b().setText(2131361849);
        paramView = paramViewGroup;
      }
      paramView.setTag(localObject);
      paramViewGroup = (ViewGroup)localObject;
      paramViewGroup.a(localDataLineMsgSet);
      localObject = paramView;
    } while (paramInt == 12);
    switch (paramInt)
    {
    case 4: 
    default: 
      label232:
      a(localDataLineMsgRecord, paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout, paramViewGroup);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        localObject = (ChatBackgroundDrawable)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewViewGroup.getTag(2131296394);
        if (localObject != null)
        {
          paramInt = ChatBackground.a(((ChatBackgroundDrawable)localObject).getBitmap());
          paramViewGroup.a().setTextColor(ColorStateList.valueOf(paramInt));
        }
      }
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(localDataLineMsgSet.getMsgId())))
      {
        localObject = TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, localDataLineMsgSet.getTime() * 1000L);
        paramViewGroup.a().setVisibility(0);
        paramViewGroup.a().setText((CharSequence)localObject);
      }
      break;
    }
    for (;;)
    {
      d(paramViewGroup, localDataLineMsgSet);
      return paramView;
      if (!localDataLineMsgSet.isSendFromLocal())
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903161, null);
        label381:
        ((ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131296981));
        ((ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject);
        ((ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
        ((ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
        ((ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        ((ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        ((ItemHolder)localObject).a((ImageView)paramView.findViewById(2131296964));
        ((ItemHolder)localObject).a((TextView)paramView.findViewById(2131296713));
        break;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903162, null);
        break label381;
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903163, null);
        ((ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296989));
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetTextView.setTag(localObject);
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetTextView.setLongClickable(true);
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetTextView.setSpannableFactory(QQText.a);
        if (localDataLineMsgSet.isSendFromLocal()) {}
        for (paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427476);; paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427473))
        {
          ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewGroup);
          ((ItemHolder)localObject).a((ProgressBar)paramView.findViewById(2131296987));
          if (((ItemHolder)localObject).a() == null) {
            break;
          }
          ((ItemHolder)localObject).a().setVisibility(8);
          break;
        }
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903156, null);
        ((ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setGravity(17);
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ItemHolder)localObject).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131296283));
        ((ItemHolder)localObject).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = ((MessageProgressTextView)paramView.findViewById(2131296967));
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131296968));
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131296985));
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296969));
        ((ItemHolder)localObject).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296986));
        if (!localDataLineMsgSet.isSendFromLocal())
        {
          ((ItemHolder)localObject).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296984));
          ((ItemHolder)localObject).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131296983));
          ((ItemHolder)localObject).a().jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131296982));
        }
        if (localDataLineMsgSet.isSendFromLocal())
        {
          ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          ((ItemHolder)localObject).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
          a((ItemHolder)localObject, this.p, this.q);
        }
        for (;;)
        {
          ((ItemHolder)localObject).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(this.p, this.q);
          ((ItemHolder)localObject).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImageByMargin();
          ((ItemHolder)localObject).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(true);
          break;
          ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((ItemHolder)localObject).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
        }
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903158, null);
        ((ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296978));
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetGridView = ((GridView)paramView.findViewById(2131296977));
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131296950));
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131296985));
        ((ItemHolder)localObject).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296986));
        if (!localDataLineMsgSet.isSendFromLocal())
        {
          ((ItemHolder)localObject).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296984));
          ((ItemHolder)localObject).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131296983));
          ((ItemHolder)localObject).a().jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131296982));
        }
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetTextView.setTag(localObject);
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetTextView.setLongClickable(true);
        a(((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetGridView);
        continue;
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903152, null);
        ((ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ItemHolder)localObject).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131296945));
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296946));
        ((ItemHolder)localObject).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296948));
        ((ItemHolder)localObject).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296949));
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131296950));
        ((ItemHolder)localObject).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130839446);
        ((ItemHolder)localObject).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        continue;
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903150, null);
        ((ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ItemHolder)localObject).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131296945));
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296946));
        ((ItemHolder)localObject).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296947));
        ((ItemHolder)localObject).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296948));
        ((ItemHolder)localObject).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296949));
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131296950));
        ((ItemHolder)localObject).a().e = ((TextView)paramView.findViewById(2131296984));
        ((ItemHolder)localObject).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131296983));
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131296982));
        ((ItemHolder)localObject).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130838501);
        ((ItemHolder)localObject).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        continue;
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903157, null);
        ((ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ItemHolder)localObject).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131296971));
        ((ItemHolder)localObject).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131296972));
        ((ItemHolder)localObject).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131296973));
        ((ItemHolder)localObject).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131296974));
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296946));
        ((ItemHolder)localObject).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296947));
        ((ItemHolder)localObject).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296948));
        ((ItemHolder)localObject).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296949));
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131296950));
        ((ItemHolder)localObject).a().e = ((TextView)paramView.findViewById(2131296984));
        ((ItemHolder)localObject).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131296983));
        ((ItemHolder)localObject).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131296982));
        ((ItemHolder)localObject).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130838502);
        ((ItemHolder)localObject).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130838502);
        ((ItemHolder)localObject).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130838502);
        ((ItemHolder)localObject).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130838502);
        ((ItemHolder)localObject).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        ((ItemHolder)localObject).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        ((ItemHolder)localObject).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        ((ItemHolder)localObject).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
      }
      label2163:
      paramViewGroup = (ItemHolder)paramView.getTag();
      break label159;
      paramViewGroup.a().jdField_a_of_type_JavaLangString = localDataLineMsgRecord.msg;
      paramViewGroup.a().jdField_a_of_type_Long = localDataLineMsgRecord.sessionid;
      localObject = paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView;
      ((TextView)localObject).setText(new QQText(localDataLineMsgRecord.msg, 13, 32, 6000));
      ((TextView)localObject).setVisibility(0);
      if (paramViewGroup.a() != null)
      {
        if ((!localDataLineMsgRecord.issuc) || (localDataLineMsgRecord.progress == 1.0F)) {
          break label2290;
        }
        paramViewGroup.a().setVisibility(0);
      }
      for (;;)
      {
        ((TextView)localObject).setTextSize(0, ChatTextSizeSettingActivity.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()));
        break;
        label2290:
        paramViewGroup.a().setVisibility(8);
      }
      c(paramViewGroup, localDataLineMsgSet);
      break label232;
      b(paramViewGroup, localDataLineMsgSet);
      break label232;
      a(paramViewGroup, localDataLineMsgSet);
      break label232;
      b(paramViewGroup, localDataLineMsgSet);
      break label232;
      a(paramViewGroup, localDataLineMsgSet);
      break label232;
      if (localDataLineMsgSet.getTime() > this.d + 180L)
      {
        this.d = localDataLineMsgSet.getTime();
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(localDataLineMsgSet.getMsgId()), Boolean.valueOf(true));
        localObject = TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, localDataLineMsgSet.getTime() * 1000L);
        paramViewGroup.a().setVisibility(0);
        paramViewGroup.a().setText((CharSequence)localObject);
      }
      else
      {
        paramViewGroup.a().setVisibility(8);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 14;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.d("DatalineSessionAdapter", 2, " notifyDataSetChanged ---------->");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.util.DatalineSessionAdapter
 * JD-Core Version:    0.7.0.1
 */