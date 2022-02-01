import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class qrl
  extends pxf
  implements ppv.b<pyt, pyt.a>
{
  private final qrl.a jdField_a_of_type_Qrl$a;
  private final qvc jdField_a_of_type_Qvc;
  private boolean aEU;
  private final String ayl;
  
  public qrl(qvc paramqvc, @NonNull String paramString)
  {
    this.jdField_a_of_type_Qvc = paramqvc;
    this.jdField_a_of_type_Qrl$a = null;
    this.ayl = paramString;
  }
  
  public qrl(qvc paramqvc, @NonNull qrl.a parama)
  {
    this.jdField_a_of_type_Qvc = paramqvc;
    this.jdField_a_of_type_Qrl$a = parama;
    this.ayl = null;
  }
  
  private void a(qrl.b paramb)
  {
    if (this.jdField_a_of_type_Qrl$a == null)
    {
      pmi.a().dispatch(this.ayl, paramb);
      return;
    }
    this.jdField_a_of_type_Qrl$a.b(paramb);
  }
  
  private void sendRequest()
  {
    pyt localpyt = new pyt();
    localpyt.jdField_a_of_type_Qvc = this.jdField_a_of_type_Qvc;
    ppv.a().a(localpyt, this);
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    if (this.aEU) {
      return;
    }
    this.jdField_a_of_type_Qvc.avr = "";
    sendRequest();
  }
  
  public void a(@NonNull pyt parampyt, @Nullable pyt.a parama, @NonNull ErrorMessage paramErrorMessage)
  {
    ram.b("Q.qqstory.detail:CommentListPageLoader", "get comment list return:%s", paramErrorMessage.toString());
    if (this.aEU)
    {
      ram.i("Q.qqstory.detail:CommentListPageLoader", "don't nothing after terminate");
      return;
    }
    qrl.b localb = new qrl.b(paramErrorMessage, this.jdField_a_of_type_Qvc.mFeedId, this.jdField_a_of_type_Qvc.mSource);
    localb.aCv = this.aCx;
    localb.mType = this.jdField_a_of_type_Qvc.mType;
    if ((parama == null) || (paramErrorMessage.isFail()))
    {
      a(localb);
      return;
    }
    ram.b("Q.qqstory.detail:CommentListPageLoader", "comment respond from cookie:%s to %s", parampyt.jdField_a_of_type_Qvc.avr, parama.nextCookie);
    boolean bool = TextUtils.isEmpty(parampyt.jdField_a_of_type_Qvc.avr);
    this.jdField_a_of_type_Qvc.avr = parama.nextCookie;
    localb.nh = parama.nh;
    localb.mTotalCount = parama.totalNum;
    localb.isFirstPage = bool;
    localb.isEnd = parama.isEnd;
    localb.aym = parama.nextCookie;
    if ((!parama.isEnd) && (parama.nh.size() == 0))
    {
      localb.isEnd = true;
      ram.w("Q.qqstory.detail:CommentListPageLoader", "comment pull should be end!!!!!!!!!!!!");
    }
    try
    {
      this.aCy = true;
      a(localb);
      ram.b("Q.qqstory.detail:CommentListPageLoader", "dispatch comment list return from network: %s", localb);
      parampyt = new qrm(this, "Q.qqstory.detail:CommentListPageLoader", localb, bool);
      Bosses.get().postJob(parampyt);
      return;
    }
    finally {}
  }
  
  public void aPh()
  {
    super.aPh();
    if (this.aEU)
    {
      rom.fail("don't call this method after terminate", new Object[0]);
      return;
    }
    sendRequest();
  }
  
  public void rT(String paramString)
  {
    this.jdField_a_of_type_Qvc.avr = paramString;
  }
  
  public void terminate()
  {
    this.aEU = true;
  }
  
  public static abstract interface a
  {
    public abstract void b(qrl.b paramb);
  }
  
  public static class b
    extends pxc
  {
    public String aym;
    public String mFeedId;
    public int mSource;
    public int mTotalCount;
    public int mType;
    public List<CommentEntry> nh = new ArrayList(0);
    
    public b(ErrorMessage paramErrorMessage, String paramString, int paramInt)
    {
      super();
      this.mFeedId = paramString;
      this.mSource = paramInt;
    }
    
    public String toString()
    {
      return "GetFeedCommentEvent{feedId='" + this.mFeedId + '\'' + ", mType=" + this.mType + ", mSource=" + this.mSource + ", mCommentEntries=" + this.nh.size() + ", mTotalCount=" + this.mTotalCount + ", isEnd=" + this.isEnd + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qrl
 * JD-Core Version:    0.7.0.1
 */