package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.IImageListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.QLog;
import efn;
import efo;
import efp;
import efq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;

public class RichStatItemBuilder
  extends AbstractChatItemBuilder
  implements IIconListener, IImageListener
{
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  RichStatItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private CharSequence a(String paramString1, String paramString2, String paramString3, String paramString4, JSONArray paramJSONArray)
  {
    paramString3 = this.jdField_a_of_type_JavaLangStringBuilder;
    paramString3.setLength(0);
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      paramString3.append(paramString1);
    }
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      paramString3.append(paramString2);
    }
    int j = Integer.parseInt(paramString4);
    int i;
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      i = 0;
      while (i < j)
      {
        paramString4 = paramJSONArray.optString(i);
        if ((paramString4 != null) && (paramString4.length() > 0)) {
          paramString3.append(paramString4);
        }
        i += 1;
      }
    }
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      int k = paramJSONArray.length();
      i = j;
      while (i < k)
      {
        paramString4 = paramJSONArray.optString(i);
        if ((paramString4 != null) && (paramString4.length() > 0)) {
          paramString3.append(paramString4);
        }
        i += 1;
      }
    }
    paramString4 = new SpannableString(paramString3.toString());
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      if ((paramString1 != null) && (paramString1.length() > 0))
      {
        i = paramString1.length() + paramString2.length();
        paramString4.setSpan(new ForegroundColorSpan(-16754769), 0, i, 33);
      }
    }
    for (;;)
    {
      paramString3.setLength(0);
      return paramString4;
      i = paramString2.length();
      break;
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        paramString4.setSpan(new ForegroundColorSpan(-8947849), 0, paramString1.length(), 33);
      }
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramString + "icon" + paramInt;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return paramString1 + "cover" + paramString2;
  }
  
  private void a(View paramView)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if ((View)((WeakReference)localIterator.next()).get() == paramView) {
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramView));
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramOnLongClickAndTouchListener = (MessageForRichState)paramMessageRecord;
    paramLinearLayout = (efq)paramViewHolder;
    paramMessageRecord = paramView;
    if (paramView == null)
    {
      paramMessageRecord = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903115, null);
      paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramMessageRecord.findViewById(2131231272));
      paramLinearLayout.c = ((TextView)paramMessageRecord.findViewById(2131231279));
      paramLinearLayout.d = ((TextView)paramMessageRecord.findViewById(2131231278));
      paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramMessageRecord.findViewById(2131231277));
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)paramMessageRecord.findViewById(2131231274));
      paramLinearLayout.e = ((TextView)paramMessageRecord.findViewById(2131231276));
      paramLinearLayout.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramMessageRecord.findViewById(2131231273));
      paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    }
    paramMessageRecord.setContentDescription(null);
    paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder.replace(0, paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder.length(), "");
    paramLinearLayout.jdField_a_of_type_Long = paramOnLongClickAndTouchListener.uniseq;
    paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a);
    paramLinearLayout.jdField_a_of_type_JavaLangString = paramOnLongClickAndTouchListener.frienduin;
    paramLinearLayout.jdField_a_of_type_Int = paramOnLongClickAndTouchListener.istroop;
    paramLinearLayout.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
    paramLinearLayout.jdField_b_of_type_JavaLangString = null;
    paramViewHolder = paramOnLongClickAndTouchListener.ver;
    if ((paramViewHolder != null) && (paramViewHolder.equals("1.0")))
    {
      if (paramOnLongClickAndTouchListener.time <= 0L) {
        break label846;
      }
      paramViewHolder = TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, paramOnLongClickAndTouchListener.time * 1000L);
      paramLinearLayout.c.setVisibility(0);
      paramLinearLayout.c.setText(paramViewHolder);
      if ((paramOnLongClickAndTouchListener.locText == null) || (paramOnLongClickAndTouchListener.locText.trim().length() <= 0)) {
        break label871;
      }
      paramLinearLayout.d.setVisibility(0);
      paramLinearLayout.d.setText(paramOnLongClickAndTouchListener.locText);
      paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label348:
      paramView = Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 10);
      paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setText(paramView + this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558905));
      CharSequence localCharSequence = a(paramOnLongClickAndTouchListener.actionText, paramOnLongClickAndTouchListener.dataText, paramOnLongClickAndTouchListener.locText, paramOnLongClickAndTouchListener.locPos, paramOnLongClickAndTouchListener.plainText);
      paramLinearLayout.e.setText(localCharSequence);
      paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder.append(paramView);
      if (paramOnLongClickAndTouchListener.time > 0L) {
        paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558906, new Object[] { paramViewHolder }));
      }
      paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558907, new Object[] { localCharSequence }));
      paramMessageRecord.setContentDescription(paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder.toString());
      paramViewHolder = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if ((paramOnLongClickAndTouchListener.dataText == null) || (paramOnLongClickAndTouchListener.dataText.length() <= 0)) {
        break label931;
      }
      if ((paramOnLongClickAndTouchListener.actionId == null) || (paramOnLongClickAndTouchListener.actionId.trim().length() == 0)) {
        paramOnLongClickAndTouchListener.actionId = "0";
      }
      if ((paramOnLongClickAndTouchListener.dataId == null) || (paramOnLongClickAndTouchListener.dataId.trim().length() == 0)) {
        paramOnLongClickAndTouchListener.dataId = "0";
      }
      paramView = a(paramOnLongClickAndTouchListener.actionId, paramOnLongClickAndTouchListener.dataId);
      if (QLog.isColorLevel()) {
        QLog.d("AIOSign", 2, "taskKey is:" + paramView);
      }
      paramLinearLayout.jdField_b_of_type_JavaLangString = paramView;
      int i = Integer.parseInt(paramOnLongClickAndTouchListener.actionId);
      int j = Integer.parseInt(paramOnLongClickAndTouchListener.dataId);
      paramView = paramOnLongClickAndTouchListener.dataText;
      paramOnLongClickAndTouchListener = paramOnLongClickAndTouchListener.frienduin;
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      paramLinearLayout.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new efn(this, i, j, paramOnLongClickAndTouchListener, paramView));
      paramViewHolder = paramViewHolder.a(i, j);
      if (QLog.isColorLevel()) {
        QLog.d("AIOSign", 2, "bmpAndType is:" + Arrays.toString(paramViewHolder));
      }
      if (((Integer)paramViewHolder[1]).intValue() != 1) {
        break label904;
      }
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.MATRIX);
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setDisplayRuleDef(new efo(this));
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageBitmap((Bitmap)paramViewHolder[0]);
    }
    label846:
    label871:
    do
    {
      do
      {
        return paramMessageRecord;
        paramLinearLayout.c.setVisibility(8);
        paramLinearLayout.c.setText("");
        paramViewHolder = null;
        break;
        paramLinearLayout.d.setVisibility(8);
        paramLinearLayout.d.setText("");
        paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label348;
        paramLinearLayout.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.FIT_START);
        paramLinearLayout.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageBitmap((Bitmap)paramViewHolder[0]);
        return paramMessageRecord;
        if ((paramOnLongClickAndTouchListener.actionText == null) || (paramOnLongClickAndTouchListener.actionText.length() <= 0)) {
          break label1043;
        }
        paramView = a(paramOnLongClickAndTouchListener.actionId, 201);
        if (QLog.isColorLevel()) {
          QLog.d("AIOSign", 2, "taskKey is:" + paramView);
        }
        paramLinearLayout.jdField_b_of_type_JavaLangString = paramView;
        paramLinearLayout.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.FIT_START);
        paramViewHolder = paramViewHolder.a(Integer.parseInt(paramOnLongClickAndTouchListener.actionId), 201);
      } while (paramViewHolder == null);
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageBitmap(paramViewHolder);
      return paramMessageRecord;
    } while (!QLog.isColorLevel());
    label904:
    label931:
    QLog.e("AIOSign", 2, "bindViewForRichSignature(),dataText is:" + paramOnLongClickAndTouchListener.dataText + ",actionText is:" + paramOnLongClickAndTouchListener.actionText);
    label1043:
    return paramMessageRecord;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new efq(this);
  }
  
  public void a()
  {
    StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    if (localStatusManager != null) {
      localStatusManager.b(this);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  void a(efq paramefq, Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return;
    }
    if (paramInt == 1)
    {
      paramefq.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.MATRIX);
      paramefq.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setDisplayRuleDef(new efp(this));
      paramefq.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageBitmap(paramBitmap);
      return;
    }
    paramefq.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.FIT_START);
    paramefq.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageBitmap(paramBitmap);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder
 * JD-Core Version:    0.7.0.1
 */