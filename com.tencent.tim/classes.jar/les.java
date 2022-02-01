import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.qphone.base.util.QLog;

public class les
  extends lce
{
  public les(ReadInJoySelfFragment paramReadInJoySelfFragment) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, lhs paramlhs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.SelfFragment", 2, "onGetSelfInfo retCode:" + paramInt1 + ", followCnt:" + paramInt2 + ", fansCnt:" + paramInt3 + ", isForbidden" + paramBoolean);
    }
    if (paramInt1 == 0)
    {
      this.this$0.i(paramInt2, paramInt3, paramBoolean);
      if (paramlhs != null) {
        ReadInJoySelfFragment.a(this.this$0, paramlhs);
      }
    }
    else
    {
      return;
    }
    QLog.e("Q.readinjoy.self.SelfFragment", 1, "onGetSelfInfo, columnInfoForSelfPage = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     les
 * JD-Core Version:    0.7.0.1
 */