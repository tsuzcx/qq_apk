import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStorySubmitRateData;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStorySubmitRateData;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tribe.async.dispatch.Dispatcher;

public class pya
  implements ppv.b<pyl<qqstory_service.ReqStorySubmitRateData>, pzy>
{
  public static final String CMD = ppf.fQ("StorySvc.submit_rate_data");
  public final int aCm;
  public final String feedId;
  public final String vid;
  
  pya(String paramString1, String paramString2, int paramInt)
  {
    this.feedId = paramString1;
    this.vid = paramString2;
    this.aCm = paramInt;
  }
  
  public static void r(@Nullable String paramString1, String paramString2, int paramInt)
  {
    new pya(paramString1, paramString2, paramInt).sendRequest();
  }
  
  private void sendRequest()
  {
    ram.a("Q.qqstory.pollData.SendVidRateDataHandler", "sendRequest() feed=%s, vid=%s, rate=%d", this.feedId, this.vid, Integer.valueOf(this.aCm));
    Object localObject = new qqstory_service.ReqStorySubmitRateData();
    ((qqstory_service.ReqStorySubmitRateData)localObject).vid.set(ByteStringMicro.copyFromUtf8(this.vid));
    ((qqstory_service.ReqStorySubmitRateData)localObject).rate_data.set(this.aCm);
    localObject = new pyl(CMD, (MessageMicro)localObject, null);
    ppv.a().a((ppw)localObject, this);
  }
  
  public void a(@NonNull pyl<qqstory_service.ReqStorySubmitRateData> parampyl, @Nullable pzy parampzy, @NonNull ErrorMessage paramErrorMessage)
  {
    int j = -1;
    parampyl = (psu)psx.a(5);
    StoryVideoItem localStoryVideoItem = parampyl.a(this.vid);
    int i;
    long l;
    label57:
    pya.a locala;
    if (localStoryVideoItem != null)
    {
      i = localStoryVideoItem.mRateResult;
      if (localStoryVideoItem != null) {
        j = localStoryVideoItem.mTotalRateCount;
      }
      if (localStoryVideoItem == null) {
        break label205;
      }
      l = localStoryVideoItem.mTotalScore;
      locala = new pya.a();
      if ((!paramErrorMessage.isFail()) && (parampzy != null)) {
        break label213;
      }
      ram.e("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request Error:%s", new Object[] { paramErrorMessage.toString() });
      locala.b = paramErrorMessage;
      locala.feedId = this.feedId;
      locala.vid = this.vid;
      locala.aCm = i;
      locala.blm = j;
      locala.AB = l;
    }
    for (;;)
    {
      if (localStoryVideoItem != null)
      {
        localStoryVideoItem.mRateResult = locala.aCm;
        localStoryVideoItem.mTotalRateCount = locala.blm;
        localStoryVideoItem.mTotalScore = locala.AB;
        parampyl.a(localStoryVideoItem);
      }
      pmi.a().dispatch(locala);
      rpk.aC(QQStoryContext.a());
      return;
      i = -1;
      break;
      label205:
      l = -1L;
      break label57;
      label213:
      paramErrorMessage = new qqstory_service.RspStorySubmitRateData();
      try
      {
        paramErrorMessage.mergeFrom(parampzy.bytes);
        locala.b = new ErrorMessage(paramErrorMessage.result.error_code.get(), paramErrorMessage.result.error_desc.get().toStringUtf8());
        locala.feedId = this.feedId;
        locala.vid = this.vid;
        locala.aCm = this.aCm;
        locala.blm = paramErrorMessage.total_rate_count.get();
        locala.AB = paramErrorMessage.total_rate_score.get();
        locala.commentId = paramErrorMessage.comment_id.get();
        locala.Ao = paramErrorMessage.fake_id.get();
        ram.d("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond() feed=%s, vid=%s, rate=%s, rateCount=%s, rateScore=%s, commentId=%s, commentFakeId=%s", new Object[] { this.feedId, this.vid, Integer.valueOf(locala.aCm), Integer.valueOf(locala.blm), Long.valueOf(locala.AB), Integer.valueOf(locala.commentId), Long.valueOf(locala.Ao) });
      }
      catch (InvalidProtocolBufferMicroException parampyl)
      {
        parampyl.printStackTrace();
        ram.e("Q.qqstory.pollData.SendVidRateDataHandler", "onCmdRespond Request parse Error!", parampyl);
      }
    }
  }
  
  public static final class a
    extends plt
  {
    public long AB;
    public long Ao;
    public int aCm;
    public int blm;
    public int commentId;
    public String feedId;
    public String vid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pya
 * JD-Core Version:    0.7.0.1
 */