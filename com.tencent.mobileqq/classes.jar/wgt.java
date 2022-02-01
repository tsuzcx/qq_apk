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

public class wgt
  extends JobSegment<List<wgh>, List<wgh>>
  implements wgj, wgn
{
  private HashMap<String, wgf> jdField_a_of_type_JavaUtilHashMap;
  private wgu jdField_a_of_type_Wgu;
  
  public wgt(wgu paramwgu)
  {
    this.jdField_a_of_type_Wgu = paramwgu;
  }
  
  public void a(ErrorMessage paramErrorMessage, HashMap<String, AddressItem> paramHashMap)
  {
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "handlePOIResult errorMessage=%s", new Object[] { paramErrorMessage.toString() });
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
        localObject = (wgf)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        ((wgf)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = paramHashMap;
        localObject = ((wgf)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((wgh)((Iterator)localObject).next()).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = paramHashMap;
        }
      }
    }
    paramErrorMessage = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      paramHashMap = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        localObject = (wgf)((Map.Entry)paramHashMap.next()).getValue();
        paramErrorMessage.addAll(((wgf)localObject).jdField_a_of_type_JavaUtilList);
        if (((wgh)((wgf)localObject).jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem == null) {
          yuk.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "后台返回的POI数据里缺少了 ：" + ((wgf)localObject).jdField_a_of_type_Whl);
        }
      }
    }
    yuk.a("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "this segment is finish  : result=%s", paramErrorMessage);
    notifyResult(paramErrorMessage);
  }
  
  public void a(ErrorMessage paramErrorMessage, List<String> paramList)
  {
    String str = paramErrorMessage.toString();
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "handleBlackResult errorMessage=%s, blackGeohash count=%d", new Object[] { str, Integer.valueOf(i) });
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
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramList);
      }
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.size() == 0)
    {
      notifyResult(new ArrayList());
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilHashMap.size() == 1) && (this.jdField_a_of_type_JavaUtilHashMap.get("EMPTY") != null))
    {
      a(new ErrorMessage(), null);
      return;
    }
    paramErrorMessage = new wgi();
    paramErrorMessage.a(this.jdField_a_of_type_JavaUtilHashMap);
    paramErrorMessage.a(this);
    paramErrorMessage.a();
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "sendPOIRequest total count:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()) });
  }
  
  protected void a(JobContext paramJobContext, List<wgh> paramList)
  {
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "start PreProcessSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(paramList);
      return;
    }
    int i = ((wfv)wth.a(30)).a().b();
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "PreProcessSegment geohashlevel=%d", new Object[] { Integer.valueOf(i) });
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    paramJobContext = paramList.iterator();
    while (paramJobContext.hasNext())
    {
      paramList = (wgh)paramJobContext.next();
      if ((paramList.jdField_a_of_type_Double == 0.0D) && (paramList.b == 0.0D)) {}
      for (paramList.c = "EMPTY";; paramList.c = whk.a(paramList.jdField_a_of_type_Double, paramList.b, i))
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramList.c)) {
          break label192;
        }
        ((wgf)this.jdField_a_of_type_JavaUtilHashMap.get(paramList.c)).jdField_a_of_type_JavaUtilList.add(paramList);
        break;
      }
      label192:
      wgf localwgf = new wgf(paramList.c);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramList);
      localwgf.jdField_a_of_type_JavaUtilList = localArrayList;
      if ((!TextUtils.isEmpty(localwgf.jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(localwgf.jdField_a_of_type_JavaLangString, "EMPTY"))) {
        localwgf.jdField_a_of_type_Whl = whk.a(localwgf.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramList.c, localwgf);
    }
    yuk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "group by geohash count:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()) });
    if ((this.jdField_a_of_type_JavaUtilHashMap.size() == 1) && (this.jdField_a_of_type_JavaUtilHashMap.get("EMPTY") != null))
    {
      a(new ErrorMessage(), null);
      return;
    }
    paramJobContext = new wgm();
    paramJobContext.a(this.jdField_a_of_type_JavaUtilHashMap);
    paramJobContext.a(this);
    paramJobContext.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgt
 * JD-Core Version:    0.7.0.1
 */