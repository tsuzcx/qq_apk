import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup.a;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class mbo
  implements ljc.b
{
  public mbo(ComponentContentRecommendFollowGroup paramComponentContentRecommendFollowGroup, List paramList, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, ArrayList<lhm> paramArrayList, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ComponentContentRecommendFollowGroup", 2, "followThem, isSuccess = " + paramBoolean + ", followList = " + paramArrayList + ", errorMsg = " + paramString);
    }
    if (paramBoolean)
    {
      int i = 0;
      while (i < this.iC.size())
      {
        paramArrayList = (RecommendFollowInfo)this.iC.get(i);
        paramArrayList.isFollowed = this.tT;
        this.this$0.a(paramArrayList);
        i += 1;
      }
      ComponentContentRecommendFollowGroup.a(this.this$0).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mbo
 * JD-Core Version:    0.7.0.1
 */