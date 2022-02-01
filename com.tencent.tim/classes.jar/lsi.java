import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.qphone.base.util.QLog;

class lsi
  implements ljc.c
{
  lsi(lsf paramlsf, RecommendFollowInfo paramRecommendFollowInfo) {}
  
  public void f(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, "978 resp, result : " + paramBoolean + ", data : " + paramInt + ", distUin : " + paramString);
    }
    if (paramBoolean)
    {
      paramString = this.a;
      if (paramInt != 2) {
        break label92;
      }
    }
    label92:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.isFollowed = paramBoolean;
      lsf.a(this.this$0, this.a);
      lsf.a(this.this$0).notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lsi
 * JD-Core Version:    0.7.0.1
 */