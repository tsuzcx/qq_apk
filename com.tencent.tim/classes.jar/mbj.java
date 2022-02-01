import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.qphone.base.util.QLog;

public class mbj
  implements ljc.c
{
  public mbj(ComponentContentRecommend paramComponentContentRecommend, RecommendFollowInfo paramRecommendFollowInfo) {}
  
  public void f(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ComponentContentRecommend.TAG, 2, "978 resp, result : " + paramBoolean + ", data : " + paramInt + ", distUin : " + paramString);
    }
    if (paramBoolean)
    {
      paramString = this.a;
      if (paramInt != 2) {
        break label93;
      }
    }
    label93:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.isFollowed = paramBoolean;
      this.this$0.a(this.a);
      ComponentContentRecommend.a(this.this$0).notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mbj
 * JD-Core Version:    0.7.0.1
 */