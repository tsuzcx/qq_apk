import UserGrowth.stGetPersonalFeedListReq;
import UserGrowth.stGetPersonalFeedListRsp;
import java.util.ArrayList;

public class vlc
  extends vfo<stGetPersonalFeedListRsp>
{
  public vlc(String paramString1, String paramString2, boolean paramBoolean, ArrayList<String> paramArrayList, int paramInt)
  {
    super("GetPersonalFeedList", paramInt);
    stGetPersonalFeedListReq localstGetPersonalFeedListReq = new stGetPersonalFeedListReq();
    localstGetPersonalFeedListReq.personId = paramString1;
    localstGetPersonalFeedListReq.attach_info = paramString2;
    localstGetPersonalFeedListReq.isFirst = paramBoolean;
    localstGetPersonalFeedListReq.context_feedids = paramArrayList;
    localstGetPersonalFeedListReq.scene = paramInt;
    this.a = localstGetPersonalFeedListReq;
    vmp.d("PersonalFeedListRequest", "stSimpleGetFeedListReq  = " + localstGetPersonalFeedListReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlc
 * JD-Core Version:    0.7.0.1
 */