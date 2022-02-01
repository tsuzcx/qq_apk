import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pxm
  extends pxe
  implements ppv.b<pzd, qam>
{
  private pxm.b a;
  protected String avL;
  private final List<String> mP;
  
  public pxm(String paramString1, String paramString2)
  {
    this.mP = new ArrayList();
    this.mP.add(paramString1);
    this.avL = paramString2;
  }
  
  public pxm(List<String> paramList, String paramString)
  {
    this.mP = paramList;
    this.avL = paramString;
  }
  
  public void a(@NonNull pzd parampzd, @Nullable qam paramqam, @NonNull ErrorMessage paramErrorMessage)
  {
    parampzd = new pxm.a();
    parampzd.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    parampzd.avL = this.avL;
    if ((paramErrorMessage.isSuccess()) && (paramqam != null))
    {
      paramErrorMessage = new ArrayList();
      qqe localqqe = (qqe)psx.a(7);
      if ((paramqam.mQ != null) && (!paramqam.mQ.isEmpty()))
      {
        paramqam = paramqam.mQ.iterator();
        while (paramqam.hasNext()) {
          paramErrorMessage.add(localqqe.a((ShareGroupItem)paramqam.next()));
        }
      }
      if (!paramErrorMessage.isEmpty()) {
        parampzd.jdField_b_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = ((ShareGroupItem)paramErrorMessage.get(0));
      }
      parampzd.mQ = paramErrorMessage;
      bnw();
    }
    for (;;)
    {
      pmi.a().dispatch(parampzd);
      paramqam = this.a;
      if (paramqam != null) {
        paramqam.a(parampzd);
      }
      return;
      notifyError();
    }
  }
  
  public void sendRequest()
  {
    pzd localpzd = new pzd();
    localpzd.nt = this.mP;
    ppv.a().a(localpzd, this);
  }
  
  public static class a
    extends plt
  {
    public String avL;
    public ShareGroupItem b;
    public List<ShareGroupItem> mQ;
  }
  
  public static abstract interface b
  {
    public abstract void a(pxm.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxm
 * JD-Core Version:    0.7.0.1
 */