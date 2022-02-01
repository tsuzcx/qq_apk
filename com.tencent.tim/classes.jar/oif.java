import UserGrowth.stFollowFeedsRsp;
import java.util.ArrayList;

class oif
  implements oko
{
  oif(oie paramoie, boolean paramBoolean1, boolean paramBoolean2, oie.b paramb, int paramInt) {}
  
  public void a(okz paramokz)
  {
    if ((this.uk) || (this.val$isRefresh)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = paramokz.succeeded();
      if (this.jdField_a_of_type_Oie$b != null) {
        this.jdField_a_of_type_Oie$b.a(this.val$isRefresh, bool2, paramokz.bb);
      }
      if (bool2) {
        break;
      }
      ooz.e("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] task fail, code: " + paramokz.bfj + ", msg: " + paramokz.msg);
      return;
    }
    if (!(paramokz.bb instanceof stFollowFeedsRsp))
    {
      ooz.e("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] data error: " + paramokz.bb);
      return;
    }
    stFollowFeedsRsp localstFollowFeedsRsp = (stFollowFeedsRsp)paramokz.bb;
    this.jdField_a_of_type_Oie.attachInfo = localstFollowFeedsRsp.attatch_info;
    this.jdField_a_of_type_Oie.akP = localstFollowFeedsRsp.cache_size;
    if (paramokz.a != null) {
      ohy.a().f(localstFollowFeedsRsp.trace_id, paramokz.a.mapExt);
    }
    if (this.uk)
    {
      this.jdField_a_of_type_Oie.aqe = localstFollowFeedsRsp.feeds_source;
      onf.pP(this.jdField_a_of_type_Oie.aqe);
    }
    if (oor.v(localstFollowFeedsRsp.feeds))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[WSFeedDataManager.java][onTaskResponse] data empty: ");
      if (localstFollowFeedsRsp.feeds == null) {}
      for (paramokz = "null";; paramokz = "size = 0")
      {
        ooz.bY("FollowRequest", paramokz);
        return;
      }
    }
    ooz.bY("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] data received, size: " + localstFollowFeedsRsp.feeds.size());
    oie.a(this.jdField_a_of_type_Oie, localstFollowFeedsRsp.feeds, bool1, this.val$scene, localstFollowFeedsRsp.is_finished, this.jdField_a_of_type_Oie$b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oif
 * JD-Core Version:    0.7.0.1
 */