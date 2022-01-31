import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortListView.RemoveListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class ckd
  implements DragSortListView.RemoveListener
{
  public ckd(EmosmActivity paramEmosmActivity) {}
  
  public void a(int paramInt)
  {
    Object localObject = (EmoticonPackage)EmosmActivity.a(this.a).get(paramInt);
    if (!NetworkUtil.e(this.a))
    {
      localObject = new QQToast(this.a);
      ((QQToast)localObject).a(2130837933);
      ((QQToast)localObject).c(1500);
      ((QQToast)localObject).a(this.a.getString(2131559056));
      ((QQToast)localObject).b(0);
      return;
    }
    EmosmActivity.a(this.a, 0);
    EmosmActivity.b(this.a, 1);
    this.a.a.a(this.a.getString(2131561933));
    this.a.a.show();
    ((EmosmHandler)this.a.b.a(11)).a(Integer.parseInt(((EmoticonPackage)localObject).epId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ckd
 * JD-Core Version:    0.7.0.1
 */