import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

class wmt
  extends ulw
{
  wmt(wms paramwms) {}
  
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
        paramString = (ulu)vls.a().getManager(181);
        if (!paramBoolean2) {
          break label128;
        }
        if (!paramString.h()) {
          paramString.b();
        }
        QQToast.a(vls.a(), 2, alud.a(2131711334), 0).a();
      }
      for (;;)
      {
        wms.a(this.a).e();
        wms.a(this.a).c();
        return;
        paramInt = 0;
        break;
        label128:
        QQToast.a(vls.a(), 2, alud.a(2131711330), 0).a();
      }
    }
    QQToast.a(vls.a(), 1, alud.a(2131711339), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wmt
 * JD-Core Version:    0.7.0.1
 */