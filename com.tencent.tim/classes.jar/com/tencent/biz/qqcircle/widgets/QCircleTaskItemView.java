package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import phj;
import qqcircle.TaskCenterReader.TaskRecord;

public class QCircleTaskItemView
  extends BaseWidgetView<TaskCenterReader.TaskRecord>
{
  TextView wL;
  TextView wM;
  TextView wN;
  
  public QCircleTaskItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a(TaskCenterReader.TaskRecord paramTaskRecord)
  {
    Object localObject;
    if (paramTaskRecord != null)
    {
      this.wL.setText(paramTaskRecord.title.get());
      this.wM.setText(String.format("%s（%d/%d）", new Object[] { paramTaskRecord.desc.get(), Integer.valueOf(paramTaskRecord.haveDone.get()), Integer.valueOf(paramTaskRecord.maxCnt.get()) }));
      TextView localTextView = this.wN;
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramTaskRecord.haveDone.get() >= paramTaskRecord.maxCnt.get()) {
        break label171;
      }
      localObject = "去";
      localTextView.setText((String)localObject + "完成");
      localObject = this.wN;
      if (paramTaskRecord.haveDone.get() >= paramTaskRecord.maxCnt.get()) {
        break label177;
      }
    }
    label171:
    label177:
    for (int i = 2130844763;; i = 0)
    {
      ((TextView)localObject).setBackgroundResource(i);
      this.wN.setOnClickListener(new phj(this, paramTaskRecord));
      return;
      localObject = "已";
      break;
    }
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.wL = ((TextView)findViewById(2131380965));
    this.wM = ((TextView)findViewById(2131380963));
    this.wN = ((TextView)findViewById(2131380962));
  }
  
  public int getLayoutId()
  {
    return 2131560955;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTaskItemView
 * JD-Core Version:    0.7.0.1
 */