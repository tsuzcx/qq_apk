package com.tencent.qqmail.activity.compose;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.utilities.ui.QMUIKit;

class PickSenderViewControl$PickSenderDialogBuilder$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  PickSenderViewControl$PickSenderDialogBuilder$2(PickSenderViewControl.PickSenderDialogBuilder paramPickSenderDialogBuilder) {}
  
  public void onGlobalLayout()
  {
    Log.d("cgine", "OnGlobalLayoutListene被触发");
    Object localObject = PickSenderViewControl.PickSenderDialogBuilder.access$1600(this.this$1).getWindow().getDecorView();
    Rect localRect = new Rect();
    ((View)localObject).getWindowVisibleDisplayFrame(localRect);
    PickSenderViewControl.PickSenderDialogBuilder.access$1702(this.this$1, PickSenderViewControl.PickSenderDialogBuilder.access$1800(this.this$1));
    PickSenderViewControl.PickSenderDialogBuilder.access$1802(this.this$1, QMUIKit.getScreenHeight(PickSenderViewControl.PickSenderDialogBuilder.access$1900(this.this$1)));
    int j = PickSenderViewControl.PickSenderDialogBuilder.access$1800(this.this$1) - PickSenderViewControl.PickSenderDialogBuilder.access$2000(this.this$1) * 2 - PickSenderViewControl.PickSenderDialogBuilder.access$2100(this.this$1).getMeasuredHeight() - QMUIKit.getStatusBarHeight(PickSenderViewControl.PickSenderDialogBuilder.access$1900(this.this$1));
    int i = j;
    if (PickSenderViewControl.PickSenderDialogBuilder.access$2200(this.this$1) != null) {
      i = j - PickSenderViewControl.PickSenderDialogBuilder.access$2300(this.this$1).getMeasuredHeight();
    }
    j = i;
    if (PickSenderViewControl.PickSenderDialogBuilder.access$2400(this.this$1) != null) {
      j = i - Math.max(PickSenderViewControl.PickSenderDialogBuilder.access$2500(this.this$1).getMeasuredHeight(), QMUIKit.dpToPx(64));
    }
    if (PickSenderViewControl.PickSenderDialogBuilder.access$1700(this.this$1) != PickSenderViewControl.PickSenderDialogBuilder.access$1800(this.this$1))
    {
      Log.d("cgine", "屏幕旋转，高度改变:mScreenHeight:" + PickSenderViewControl.PickSenderDialogBuilder.access$1800(this.this$1) + ";oldScreenHeight: " + PickSenderViewControl.PickSenderDialogBuilder.access$1700(this.this$1));
      PickSenderViewControl.PickSenderDialogBuilder.access$2602(this.this$1, PickSenderViewControl.access$1000(this.this$1.this$0).getMeasuredHeight());
      if (j < PickSenderViewControl.PickSenderDialogBuilder.access$2600(this.this$1)) {
        PickSenderViewControl.PickSenderDialogBuilder.access$2602(this.this$1, j);
      }
      PickSenderViewControl.PickSenderDialogBuilder.access$2700(this.this$1).height = PickSenderViewControl.PickSenderDialogBuilder.access$2600(this.this$1);
      PickSenderViewControl.access$1000(this.this$1.this$0).setLayoutParams(PickSenderViewControl.PickSenderDialogBuilder.access$2700(this.this$1));
    }
    i = PickSenderViewControl.PickSenderDialogBuilder.access$1800(this.this$1) - localRect.bottom;
    if ((i >= PickSenderViewControl.PickSenderDialogBuilder.access$2800(this.this$1) + 5) || (i <= PickSenderViewControl.PickSenderDialogBuilder.access$2800(this.this$1) - 5))
    {
      Log.d("cgine", "anchorHeightChange:anchorShouldHeight: " + i + ";mAnchorHeight: " + PickSenderViewControl.PickSenderDialogBuilder.access$2800(this.this$1));
      PickSenderViewControl.access$1000(this.this$1.this$0).postDelayed(new PickSenderViewControl.PickSenderDialogBuilder.2.1(this), 100L);
      PickSenderViewControl.PickSenderDialogBuilder.access$2802(this.this$1, i);
      localObject = (LinearLayout.LayoutParams)PickSenderViewControl.PickSenderDialogBuilder.access$2900(this.this$1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = PickSenderViewControl.PickSenderDialogBuilder.access$2800(this.this$1);
      PickSenderViewControl.PickSenderDialogBuilder.access$3000(this.this$1).setLayoutParams((ViewGroup.LayoutParams)localObject);
      PickSenderViewControl.PickSenderDialogBuilder.access$2700(this.this$1).height = (PickSenderViewControl.PickSenderDialogBuilder.access$2600(this.this$1) - i);
      PickSenderViewControl.access$1000(this.this$1.this$0).setLayoutParams(PickSenderViewControl.PickSenderDialogBuilder.access$2700(this.this$1));
      if (PickSenderViewControl.PickSenderDialogBuilder.access$2800(this.this$1) <= 0) {
        break label571;
      }
      if (!PickSenderViewControl.access$000(this.this$1.this$0).isFocused())
      {
        PickSenderViewControl.access$000(this.this$1.this$0).requestFocus();
        PickSenderViewControl.access$000(this.this$1.this$0).setSelection(PickSenderViewControl.access$000(this.this$1.this$0).getText().toString().length());
      }
    }
    return;
    label571:
    PickSenderViewControl.access$000(this.this$1.this$0).clearFocus();
    PickSenderViewControl.access$900(this.this$1.this$0).requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.PickSenderViewControl.PickSenderDialogBuilder.2
 * JD-Core Version:    0.7.0.1
 */