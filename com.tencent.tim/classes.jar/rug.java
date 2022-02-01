import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.activity.QRDisplayActivity.a;
import com.tencent.biz.qrcode.activity.QRDisplayActivity.b;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class rug
  extends QRDisplayActivity.b
{
  public rug(QRDisplayActivity paramQRDisplayActivity)
  {
    super(paramQRDisplayActivity);
  }
  
  public void c(boolean paramBoolean, List<String> paramList1, List<String> paramList2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QRDisplayActivity", 4, "onGetNicknameList: " + paramBoolean);
    }
    if ((paramBoolean) && (paramList1 != null) && (paramList2 != null))
    {
      int j = paramList2.size();
      if ((j > 0) && (paramList1.size() == j))
      {
        if (this.this$0.pn == null) {
          this.this$0.pn = new ArrayList();
        }
        this.this$0.pn.addAll(paramList1);
        int i = 0;
        while (i < j)
        {
          if (this.this$0.getNickName((String)paramList2.get(i)) == null) {
            this.this$0.cB((String)paramList2.get(i), (String)paramList1.get(i));
          }
          i += 1;
        }
        Collections.sort(this.this$0.pn, new QRDisplayActivity.a(this.this$0));
      }
    }
    this.this$0.aCr = this.this$0.u(this.this$0.pn);
    if (this.this$0.aCr != null)
    {
      this.this$0.nC.setContentDescription(this.this$0.aCr + "," + this.this$0.tips);
      this.this$0.mScrollView.post(this.this$0.dy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rug
 * JD-Core Version:    0.7.0.1
 */