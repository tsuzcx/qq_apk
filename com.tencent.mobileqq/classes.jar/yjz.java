import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

class yjz
  extends wjd
{
  yjz(yjy paramyjy) {}
  
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
        paramString = (wjb)xiz.a().getManager(181);
        if (!paramBoolean2) {
          break label128;
        }
        if (!paramString.h()) {
          paramString.b();
        }
        QQToast.a(xiz.a(), 2, anzj.a(2131709819), 0).a();
      }
      for (;;)
      {
        yjy.a(this.a).e();
        yjy.a(this.a).c();
        return;
        paramInt = 0;
        break;
        label128:
        QQToast.a(xiz.a(), 2, anzj.a(2131709815), 0).a();
      }
    }
    QQToast.a(xiz.a(), 1, anzj.a(2131709824), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjz
 * JD-Core Version:    0.7.0.1
 */