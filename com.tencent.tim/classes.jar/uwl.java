import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.emosm.view.DragSortListView.j;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class uwl
  implements DragSortListView.j
{
  public uwl(EmosmActivity paramEmosmActivity) {}
  
  public void remove(int paramInt)
  {
    paramInt -= this.this$0.a.getHeaderViewsCount();
    if (paramInt < 0) {
      return;
    }
    Object localObject = (EmoticonPackage)this.this$0.pg.get(paramInt);
    if (!aqiw.isNetSupport(this.this$0))
    {
      localObject = new QQToast(this.this$0);
      ((QQToast)localObject).setToastIcon(2130840061);
      ((QQToast)localObject).setDuration(1500);
      ((QQToast)localObject).setToastMsg(acfp.m(2131705794));
      ((QQToast)localObject).show(0);
      return;
    }
    this.this$0.progressDialog.setMessage(this.this$0.getString(2131693100));
    this.this$0.progressDialog.show();
    ((acdz)this.this$0.app.getBusinessHandler(12)).IS(Integer.parseInt(((EmoticonPackage)localObject).epId));
    URLDrawable.clearMemoryCache();
    if (this.this$0.mLaunchMode == 1)
    {
      anot.a(this.this$0.app, "dc00898", "", "", "0X800AB12", "0X800AB12", 1, 0, "", "", "", "");
      return;
    }
    anot.a(this.this$0.app, "dc00898", "", "", "0X800AB15", "0X800AB15", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uwl
 * JD-Core Version:    0.7.0.1
 */