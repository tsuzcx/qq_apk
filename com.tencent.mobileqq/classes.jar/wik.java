import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

class wik
  extends uhn
{
  wik(wij paramwij) {}
  
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
        paramString = (uhl)vhj.a().getManager(181);
        if (!paramBoolean2) {
          break label128;
        }
        if (!paramString.h()) {
          paramString.b();
        }
        QQToast.a(vhj.a(), 2, alpo.a(2131711322), 0).a();
      }
      for (;;)
      {
        wij.a(this.a).e();
        wij.a(this.a).c();
        return;
        paramInt = 0;
        break;
        label128:
        QQToast.a(vhj.a(), 2, alpo.a(2131711318), 0).a();
      }
    }
    QQToast.a(vhj.a(), 1, alpo.a(2131711327), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wik
 * JD-Core Version:    0.7.0.1
 */