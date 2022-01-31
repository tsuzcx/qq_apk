import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.activity.QRDisplayActivity.GetNicknameObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pq
  extends QRDisplayActivity.GetNicknameObserver
{
  public pq(QRDisplayActivity paramQRDisplayActivity)
  {
    super(paramQRDisplayActivity);
  }
  
  protected void a(boolean paramBoolean, List paramList1, List paramList2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(QRDisplayActivity.jdField_a_of_type_JavaLangString, 4, "onGetNicknameList: " + paramBoolean);
    }
    if ((paramBoolean) && (paramList1 != null) && (paramList2 != null))
    {
      int j = paramList2.size();
      if ((j > 0) && (paramList1.size() == j))
      {
        if (this.a.b == null) {
          this.a.b = new ArrayList();
        }
        this.a.b.addAll(paramList1);
        int i = 0;
        while (i < j)
        {
          if (this.a.a((String)paramList2.get(i)) == null) {
            this.a.a((String)paramList2.get(i), (String)paramList1.get(i));
          }
          i += 1;
        }
        Collections.sort(this.a.b, new qd(this.a));
      }
    }
    this.a.f = this.a.a(this.a.b);
    if (this.a.f != null)
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.a.f + "," + this.a.g);
      this.a.c.post(this.a.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     pq
 * JD-Core Version:    0.7.0.1
 */