import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

class yge
  extends wfi
{
  yge(ygd paramygd) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    paramInt = 1;
    if ((this.a.a == null) || (!TextUtils.equals(paramString, this.a.a.uid))) {
      return;
    }
    if (paramBoolean1)
    {
      paramString = this.a.a;
      if (paramBoolean2)
      {
        paramString.isSubscribe = paramInt;
        paramString = (wfg)xfe.a().getManager(181);
        if (!paramBoolean2) {
          break label128;
        }
        if (!paramString.h()) {
          paramString.b();
        }
        QQToast.a(xfe.a(), 2, anni.a(2131709710), 0).a();
      }
      for (;;)
      {
        ygd.a(this.a).e();
        ygd.a(this.a).c();
        return;
        paramInt = 0;
        break;
        label128:
        QQToast.a(xfe.a(), 2, anni.a(2131709706), 0).a();
      }
    }
    QQToast.a(xfe.a(), 1, anni.a(2131709715), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yge
 * JD-Core Version:    0.7.0.1
 */