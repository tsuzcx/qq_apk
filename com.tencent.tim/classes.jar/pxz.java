import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStorySubmitPollData;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStorySubmitPollData;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;

public class pxz
  implements ppv.b<pyl<qqstory_service.ReqStorySubmitPollData>, pzy>
{
  public static final String CMD = ppf.fQ("StorySvc.submit_poll_data");
  public String feedId;
  public int index;
  public String vid;
  
  pxz(String paramString1, String paramString2, int paramInt)
  {
    this.feedId = paramString1;
    this.vid = paramString2;
    this.index = paramInt;
  }
  
  public static void q(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new pxz(paramString1, paramString2, paramInt).sendRequest();
  }
  
  private void sendRequest()
  {
    ram.a("Q.qqstory.pollData.SendVidPollDataHandler", "sendRequest() feed=%s, poll=%s, index=%d", this.feedId, this.vid, Integer.valueOf(this.index));
    Object localObject = new qqstory_service.ReqStorySubmitPollData();
    ((qqstory_service.ReqStorySubmitPollData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.vid));
    ((qqstory_service.ReqStorySubmitPollData)localObject).poll_data.set(this.index);
    localObject = new pyl(CMD, (MessageMicro)localObject, null);
    ppv.a().a((ppw)localObject, this);
  }
  
  public void a(@NonNull pyl<qqstory_service.ReqStorySubmitPollData> parampyl, @Nullable pzy parampzy, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (parampzy == null))
    {
      ram.e("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request Error:%s", paramErrorMessage);
      return;
    }
    parampyl = new qqstory_service.RspStorySubmitPollData();
    StoryVideoItem localStoryVideoItem;
    try
    {
      parampyl.mergeFrom(parampzy.bytes);
      parampzy = new pxz.a();
      parampzy.b = new ErrorMessage(parampyl.result.error_code.get(), parampyl.result.error_desc.get().toStringUtf8());
      parampzy.feedId = this.feedId;
      parampzy.vid = this.vid;
      parampzy.commentId = parampyl.comment_id.get();
      parampzy.Ao = parampyl.fake_id.get();
      parampzy.bll = this.index;
      parampzy.mR = new ArrayList(parampyl.video_poll_result.get());
      int j = parampzy.mR.size();
      paramErrorMessage = (psu)psx.a(5);
      localStoryVideoItem = paramErrorMessage.a(this.vid);
      ram.a("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond() feed=%s, vid=%s, index=%d", this.feedId, this.vid, Integer.valueOf(parampzy.bll));
      if ((localStoryVideoItem == null) || (j <= 0)) {
        break label302;
      }
      if ((localStoryVideoItem.mPollNumbers == null) || (localStoryVideoItem.mPollNumbers.length != j)) {
        localStoryVideoItem.mPollNumbers = new int[j];
      }
      int i = 0;
      while (i < j)
      {
        localStoryVideoItem.mPollNumbers[i] = ((Integer)parampyl.video_poll_result.get(i)).intValue();
        i += 1;
      }
      localStoryVideoItem.mPollResult = this.index;
    }
    catch (InvalidProtocolBufferMicroException parampyl)
    {
      parampyl.printStackTrace();
      ram.e("Q.qqstory.pollData.SendVidPollDataHandler", "onCmdRespond Request parse Error:%s", parampyl);
      return;
    }
    paramErrorMessage.a(localStoryVideoItem);
    label302:
    pmi.a().dispatch(parampzy);
    rpk.aC(QQStoryContext.a());
  }
  
  public static final class a
    extends plt
  {
    public long Ao;
    public int bll;
    public int commentId;
    public String feedId;
    public ArrayList<Integer> mR;
    public String vid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxz
 * JD-Core Version:    0.7.0.1
 */