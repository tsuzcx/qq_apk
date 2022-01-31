import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;

class uts
  extends ssv
{
  uts(utr paramutr) {}
  
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
        paramString = (sst)tsr.a().getManager(181);
        if (!paramBoolean2) {
          break label128;
        }
        if (!paramString.h()) {
          paramString.b();
        }
        bcql.a(tsr.a(), 2, ajya.a(2131710950), 0).a();
      }
      for (;;)
      {
        utr.a(this.a).e();
        utr.a(this.a).c();
        return;
        paramInt = 0;
        break;
        label128:
        bcql.a(tsr.a(), 2, ajya.a(2131710946), 0).a();
      }
    }
    bcql.a(tsr.a(), 1, ajya.a(2131710955), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uts
 * JD-Core Version:    0.7.0.1
 */