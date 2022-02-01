import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetCommentListRsp;

class oyi
  implements ryu<Object>
{
  oyi(oyh paramoyh, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void s(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 4)) {
      oyh.a(this.a, ((Boolean)paramVarArgs[0]).booleanValue(), ((Long)paramVarArgs[1]).longValue(), (String)paramVarArgs[2], (FeedCloudRead.StGetCommentListRsp)paramVarArgs[3], this.b, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oyi
 * JD-Core Version:    0.7.0.1
 */