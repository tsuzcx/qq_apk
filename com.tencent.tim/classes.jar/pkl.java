import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class pkl
  extends JobSegment<List<pkd.a>, List<pkd.a>>
  implements pke.a, pkg.a
{
  private pkm b;
  private HashMap<String, pkc> fe;
  
  public pkl(pkm parampkm)
  {
    this.b = parampkm;
  }
  
  public void a(ErrorMessage paramErrorMessage, HashMap<String, AddressItem> paramHashMap)
  {
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "handlePOIResult errorMessage=%s", new Object[] { paramErrorMessage.toString() });
    if (paramErrorMessage.isFail())
    {
      notifyError(new ErrorMessage(paramErrorMessage.errorCode, "request POI list error:" + paramErrorMessage.getErrorMessage()));
      return;
    }
    Object localObject;
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      paramErrorMessage = paramHashMap.entrySet().iterator();
      while (paramErrorMessage.hasNext())
      {
        paramHashMap = (Map.Entry)paramErrorMessage.next();
        localObject = (String)paramHashMap.getKey();
        paramHashMap = (AddressItem)paramHashMap.getValue();
        localObject = (pkc)this.fe.get(localObject);
        ((pkc)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = paramHashMap;
        localObject = ((pkc)localObject).picList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((pkd.a)((Iterator)localObject).next()).b = paramHashMap;
        }
      }
    }
    paramErrorMessage = new ArrayList();
    if (this.fe != null)
    {
      paramHashMap = this.fe.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        localObject = (pkc)((Map.Entry)paramHashMap.next()).getValue();
        paramErrorMessage.addAll(((pkc)localObject).picList);
        if (((pkd.a)((pkc)localObject).picList.get(0)).b == null) {
          ram.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "后台返回的POI数据里缺少了 ：" + ((pkc)localObject).jdField_a_of_type_Pkx$a);
        }
      }
    }
    ram.b("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "this segment is finish  : result=%s", paramErrorMessage);
    notifyResult(paramErrorMessage);
  }
  
  public void a(ErrorMessage paramErrorMessage, List<String> paramList)
  {
    String str = paramErrorMessage.toString();
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "handleBlackResult errorMessage=%s, blackGeohash count=%d", new Object[] { str, Integer.valueOf(i) });
      if (!paramErrorMessage.isFail()) {
        break;
      }
      notifyError(new ErrorMessage(paramErrorMessage.errorCode, "request black list error:" + paramErrorMessage.getErrorMessage()));
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramErrorMessage = paramList.iterator();
      while (paramErrorMessage.hasNext())
      {
        paramList = (String)paramErrorMessage.next();
        this.fe.remove(paramList);
      }
    }
    if (this.fe.size() == 0)
    {
      notifyResult(new ArrayList());
      return;
    }
    if ((this.fe.size() == 1) && (this.fe.get("EMPTY") != null))
    {
      a(new ErrorMessage(), null);
      return;
    }
    paramErrorMessage = new pke();
    paramErrorMessage.t(this.fe);
    paramErrorMessage.a(this);
    paramErrorMessage.sendRequest();
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "sendPOIRequest total count:%d", new Object[] { Integer.valueOf(this.fe.size()) });
  }
  
  protected void a(JobContext paramJobContext, List<pkd.a> paramList)
  {
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "start PreProcessSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(paramList);
      return;
    }
    int i = ((pju)psx.a(30)).a().sg();
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "PreProcessSegment geohashlevel=%d", new Object[] { Integer.valueOf(i) });
    this.fe = new HashMap();
    paramJobContext = paramList.iterator();
    while (paramJobContext.hasNext())
    {
      paramList = (pkd.a)paramJobContext.next();
      if ((paramList.bg == 0.0D) && (paramList.bh == 0.0D)) {}
      for (paramList.asT = "EMPTY";; paramList.asT = pkx.a(paramList.bg, paramList.bh, i))
      {
        if (!this.fe.containsKey(paramList.asT)) {
          break label192;
        }
        ((pkc)this.fe.get(paramList.asT)).picList.add(paramList);
        break;
      }
      label192:
      pkc localpkc = new pkc(paramList.asT);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramList);
      localpkc.picList = localArrayList;
      if ((!TextUtils.isEmpty(localpkc.geohashString)) && (!TextUtils.equals(localpkc.geohashString, "EMPTY"))) {
        localpkc.jdField_a_of_type_Pkx$a = pkx.a(localpkc.geohashString);
      }
      this.fe.put(paramList.asT, localpkc);
    }
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "group by geohash count:%d", new Object[] { Integer.valueOf(this.fe.size()) });
    if ((this.fe.size() == 1) && (this.fe.get("EMPTY") != null))
    {
      a(new ErrorMessage(), null);
      return;
    }
    paramJobContext = new pkg();
    paramJobContext.t(this.fe);
    paramJobContext.a(this);
    paramJobContext.sendRequest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pkl
 * JD-Core Version:    0.7.0.1
 */