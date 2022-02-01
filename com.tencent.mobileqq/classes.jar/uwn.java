import UserGrowth.stGetPersonalFeedListReq;
import UserGrowth.stGetPersonalFeedListRsp;
import java.util.ArrayList;

public class uwn
  extends urg<stGetPersonalFeedListRsp>
{
  public uwn(String paramString1, String paramString2, boolean paramBoolean, ArrayList<String> paramArrayList, int paramInt)
  {
    super("GetPersonalFeedList", paramInt);
    stGetPersonalFeedListReq localstGetPersonalFeedListReq = new stGetPersonalFeedListReq();
    localstGetPersonalFeedListReq.personId = paramString1;
    localstGetPersonalFeedListReq.attach_info = paramString2;
    localstGetPersonalFeedListReq.isFirst = paramBoolean;
    localstGetPersonalFeedListReq.context_feedids = paramArrayList;
    localstGetPersonalFeedListReq.scene = paramInt;
    this.a = localstGetPersonalFeedListReq;
    uya.d("PersonalFeedListRequest", "stSimpleGetFeedListReq  = " + localstGetPersonalFeedListReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uwn
 * JD-Core Version:    0.7.0.1
 */