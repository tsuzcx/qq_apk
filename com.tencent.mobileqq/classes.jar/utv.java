import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;

class utv
  extends ssy
{
  utv(utu paramutu) {}
  
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
        paramString = (ssw)tsu.a().getManager(181);
        if (!paramBoolean2) {
          break label128;
        }
        if (!paramString.h()) {
          paramString.b();
        }
        bcpw.a(tsu.a(), 2, ajyc.a(2131710939), 0).a();
      }
      for (;;)
      {
        utu.a(this.a).e();
        utu.a(this.a).c();
        return;
        paramInt = 0;
        break;
        label128:
        bcpw.a(tsu.a(), 2, ajyc.a(2131710935), 0).a();
      }
    }
    bcpw.a(tsu.a(), 1, ajyc.a(2131710944), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utv
 * JD-Core Version:    0.7.0.1
 */