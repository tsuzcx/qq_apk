package com.tencent.mobileqq.widget.datepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.AttributeSet;
import arkk;
import arkl;
import atau.a;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class DatePickerView
  extends RecyclerView
{
  protected arkl a;
  private TypedArray b;
  protected arkk b;
  protected Context mContext;
  
  public DatePickerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DatePickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DatePickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode())
    {
      this.jdField_b_of_type_AndroidContentResTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.qd);
      setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
      init(paramContext);
    }
  }
  
  public void b(int paramInt1, int paramInt2, ArrayList<MessageRecord> paramArrayList)
  {
    if (this.a != null)
    {
      this.a.b(paramInt1, paramInt2, paramArrayList);
      this.a.notifyDataSetChanged();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
        localStringBuilder.append("[shmsgseq:").append(localMessageRecord.shmsgseq).append(", time:").append(localMessageRecord.time).append(", senderUin").append(localMessageRecord.senderuin).append("], ");
      }
      QLog.d("DatePickerView", 2, "addOrUpdateMsgData:" + paramInt1 + "-" + (paramInt2 + 1) + " | MessageRecordList: " + localStringBuilder.toString());
    }
  }
  
  public void init(Context paramContext)
  {
    this.mContext = paramContext;
    setLayoutManager(new LinearLayoutManager(paramContext));
    setVerticalScrollBarEnabled(false);
    setFadingEdgeLength(0);
  }
  
  public void setController(arkk paramarkk)
  {
    this.jdField_b_of_type_Arkk = paramarkk;
    if (this.a == null) {
      this.a = new arkl(getContext(), paramarkk, this.jdField_b_of_type_AndroidContentResTypedArray);
    }
    this.a.notifyDataSetChanged();
    setAdapter(this.a);
    scrollToPosition(this.a.getItemCount() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.datepicker.DatePickerView
 * JD-Core Version:    0.7.0.1
 */