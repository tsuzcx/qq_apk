import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;

class ugz
  extends sgc
{
  ugz(ugy paramugy) {}
  
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
        paramString = (sga)tfy.a().getManager(181);
        if (!paramBoolean2) {
          break label128;
        }
        if (!paramString.h()) {
          paramString.b();
        }
        bbmy.a(tfy.a(), 2, ajjy.a(2131645151), 0).a();
      }
      for (;;)
      {
        ugy.a(this.a).e();
        ugy.a(this.a).c();
        return;
        paramInt = 0;
        break;
        label128:
        bbmy.a(tfy.a(), 2, ajjy.a(2131645147), 0).a();
      }
    }
    bbmy.a(tfy.a(), 1, ajjy.a(2131645156), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugz
 * JD-Core Version:    0.7.0.1
 */