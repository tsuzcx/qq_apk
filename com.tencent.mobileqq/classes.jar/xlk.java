import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

class xlk
  extends vlc
{
  xlk(xlj paramxlj) {}
  
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
        paramString = (vla)wkp.a().getManager(181);
        if (!paramBoolean2) {
          break label128;
        }
        if (!paramString.h()) {
          paramString.b();
        }
        QQToast.a(wkp.a(), 2, amtj.a(2131710051), 0).a();
      }
      for (;;)
      {
        xlj.a(this.a).e();
        xlj.a(this.a).c();
        return;
        paramInt = 0;
        break;
        label128:
        QQToast.a(wkp.a(), 2, amtj.a(2131710047), 0).a();
      }
    }
    QQToast.a(wkp.a(), 1, amtj.a(2131710056), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xlk
 * JD-Core Version:    0.7.0.1
 */