import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

class qtz
  extends pmd
{
  qtz(qty paramqty) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    paramInt = 1;
    if ((this.b.mUserUIItem == null) || (!TextUtils.equals(paramString, this.b.mUserUIItem.uid))) {
      return;
    }
    if (paramBoolean1)
    {
      paramString = this.b.mUserUIItem;
      if (paramBoolean2)
      {
        paramString.isSubscribe = paramInt;
        paramString = (pmb)qem.getQQAppInterface().getManager(181);
        if (!paramBoolean2) {
          break label128;
        }
        if (!paramString.Iq()) {
          paramString.blP();
        }
        QQToast.a(qem.getApplicationContext(), 2, acfp.m(2131712342), 0).show();
      }
      for (;;)
      {
        qty.a(this.b).su();
        qty.a(this.b).bqy();
        return;
        paramInt = 0;
        break;
        label128:
        QQToast.a(qem.getApplicationContext(), 2, acfp.m(2131712338), 0).show();
      }
    }
    QQToast.a(qem.getApplicationContext(), 1, acfp.m(2131712347), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qtz
 * JD-Core Version:    0.7.0.1
 */