import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.widget.QQToast;

class yaf
  extends vzx
{
  yaf(yae paramyae) {}
  
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
        paramString = (vzv)wzk.a().getManager(QQManagerFactory.QQSTORY_MANAGER);
        if (!paramBoolean2) {
          break label128;
        }
        if (!paramString.h()) {
          paramString.b();
        }
        QQToast.a(wzk.a(), 2, anvx.a(2131710398), 0).a();
      }
      for (;;)
      {
        yae.a(this.a).e();
        yae.a(this.a).c();
        return;
        paramInt = 0;
        break;
        label128:
        QQToast.a(wzk.a(), 2, anvx.a(2131710394), 0).a();
      }
    }
    QQToast.a(wzk.a(), 1, anvx.a(2131710403), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yaf
 * JD-Core Version:    0.7.0.1
 */