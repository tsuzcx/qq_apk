import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.model.ShareGroupCollectionItem;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class qua
  extends pxf
  implements ppv.b<pze, qan>
{
  private boolean aEU;
  private String axe;
  private String mCookie;
  public String mUnionId;
  
  private void sendRequest()
  {
    pze localpze = new pze();
    localpze.unionId = this.mUnionId;
    localpze.avV = this.mCookie;
    localpze.seqno = 0L;
    localpze.collectionCount = 10;
    localpze.blr = 10;
    ppv.a().a(localpze, this);
    ram.b("Q.qqstory.memories:ShareGroupPageLoader", "send share group list request. request=%s.", localpze.toString());
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    if (this.aEU) {
      return;
    }
    this.mCookie = "";
    sendRequest();
  }
  
  public void a(@NonNull pze parampze, @Nullable qan paramqan, @NonNull ErrorMessage paramErrorMessage)
  {
    ram.b("Q.qqstory.memories:ShareGroupPageLoader", "get share group list return:%s", paramErrorMessage.toString());
    if (this.aEU)
    {
      ram.i("Q.qqstory.memories:ShareGroupPageLoader", "don't nothing after terminate");
      return;
    }
    qua.a locala = new qua.a(paramErrorMessage, this.axe);
    locala.aCu = false;
    if ((paramqan == null) || (paramErrorMessage.isFail()))
    {
      pmi.a().dispatch(locala);
      return;
    }
    this.mCookie = paramqan.nextCookie;
    locala.oo = paramqan.mW;
    locala.bob = paramqan.blF;
    locala.isEnd = paramqan.isEnd;
    locala.isFirstPage = TextUtils.isEmpty(parampze.avV);
    paramqan = paramqan.mW;
    ((psn)psx.a(19)).d(paramqan, parampze.unionId, locala.isFirstPage);
    try
    {
      this.aCy = true;
      pmi.a().dispatch(locala);
      ram.b("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from network: %s", locala);
      return;
    }
    finally {}
  }
  
  public void aPh()
  {
    super.aPh();
    if (this.aEU) {
      return;
    }
    sendRequest();
  }
  
  public static class a
    extends pxc
  {
    public int bob;
    public String mContext;
    public List<ShareGroupCollectionItem> oo = new ArrayList();
    
    public a(ErrorMessage paramErrorMessage, String paramString)
    {
      super();
      this.mContext = paramString;
    }
    
    public String toString()
    {
      return "GetShareGroupListEvent{mShareGroupList=" + this.oo.size() + ", mShareGroupTotalCount=" + this.bob + ", errorCode=" + this.b.errorCode + ", isLocalData=" + this.aCu + ", isFirstPage=" + this.isFirstPage + ", isEnd=" + this.isEnd + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qua
 * JD-Core Version:    0.7.0.1
 */