import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class kpr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public kpr(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new Rect();
    ReadInJoyDeliverBiuActivity.a(this.this$0).getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ReadInJoyDeliverBiuActivity.b(this.this$0).getRootView().getHeight();
    int j = i - ((Rect)localObject).height();
    boolean bool;
    if (j > 100)
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverBiuActivity", 2, "onGlobalLayout screenHeight:" + i + ", ExternalPanelheight:" + j + ", isShowKeybroad:" + bool);
      }
      i = ReadInJoyDeliverBiuActivity.a(this.this$0).getHeight();
      if (bool == ReadInJoyDeliverBiuActivity.a(this.this$0)) {
        break label394;
      }
      if (j > ReadInJoyDeliverBiuActivity.a(this.this$0)) {
        ReadInJoyDeliverBiuActivity.a(this.this$0, j);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverBiuActivity", 2, "onGlobalLayout mMAXExternalPanelheight:" + ReadInJoyDeliverBiuActivity.b(this.this$0));
      }
      j = i - ReadInJoyDeliverBiuActivity.c(this.this$0);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverBiuActivity", 2, "onGlobalLayout contentHeight:" + i + ", fixedHeight:" + ReadInJoyDeliverBiuActivity.d(this.this$0) + ", maxHeight:" + j);
      }
      ReadInJoyDeliverBiuActivity.a(this.this$0).setMaxHeight(j);
      ReadInJoyDeliverBiuActivity.a(this.this$0, bool);
      localObject = this.this$0;
      if (i >= ReadInJoyDeliverBiuActivity.e(this.this$0)) {
        break label372;
      }
      j = i;
      label283:
      ReadInJoyDeliverBiuActivity.b((ReadInJoyDeliverBiuActivity)localObject, j);
      localObject = this.this$0;
      if (i <= ReadInJoyDeliverBiuActivity.f(this.this$0)) {
        break label383;
      }
      label307:
      ReadInJoyDeliverBiuActivity.c((ReadInJoyDeliverBiuActivity)localObject, i);
    }
    for (;;)
    {
      ReadInJoyDeliverBiuActivity.d(this.this$0, ReadInJoyDeliverBiuActivity.h(this.this$0));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverBiuActivity", 2, "onGlobalLayout mExternalPanelheight:" + ReadInJoyDeliverBiuActivity.g(this.this$0));
      }
      return;
      bool = false;
      break;
      label372:
      j = ReadInJoyDeliverBiuActivity.e(this.this$0);
      break label283;
      label383:
      i = ReadInJoyDeliverBiuActivity.f(this.this$0);
      break label307;
      label394:
      if ((ReadInJoyDeliverBiuActivity.g(this.this$0) != ReadInJoyDeliverBiuActivity.h(this.this$0)) && (i == ReadInJoyDeliverBiuActivity.f(this.this$0)))
      {
        i -= ReadInJoyDeliverBiuActivity.h(this.this$0);
        j = i - ReadInJoyDeliverBiuActivity.i(this.this$0);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverBiuActivity", 2, "onGlobalLayout contentHeight:" + i + ", fixedHeight:" + ReadInJoyDeliverBiuActivity.j(this.this$0) + ", maxHeight:" + j);
        }
        ReadInJoyDeliverBiuActivity.b(this.this$0).setMaxHeight(j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kpr
 * JD-Core Version:    0.7.0.1
 */