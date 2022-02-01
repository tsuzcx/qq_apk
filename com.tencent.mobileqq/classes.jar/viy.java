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

public class viy
  extends JobSegment<List<vim>, List<vim>>
  implements vio, vis
{
  private HashMap<String, vik> jdField_a_of_type_JavaUtilHashMap;
  private viz jdField_a_of_type_Viz;
  
  public viy(viz paramviz)
  {
    this.jdField_a_of_type_Viz = paramviz;
  }
  
  public void a(ErrorMessage paramErrorMessage, HashMap<String, AddressItem> paramHashMap)
  {
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "handlePOIResult errorMessage=%s", new Object[] { paramErrorMessage.toString() });
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
        localObject = (vik)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        ((vik)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = paramHashMap;
        localObject = ((vik)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((vim)((Iterator)localObject).next()).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem = paramHashMap;
        }
      }
    }
    paramErrorMessage = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      paramHashMap = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        localObject = (vik)((Map.Entry)paramHashMap.next()).getValue();
        paramErrorMessage.addAll(((vik)localObject).jdField_a_of_type_JavaUtilList);
        if (((vim)((vik)localObject).jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem == null) {
          xvv.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "后台返回的POI数据里缺少了 ：" + ((vik)localObject).jdField_a_of_type_Vjq);
        }
      }
    }
    xvv.a("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "this segment is finish  : result=%s", paramErrorMessage);
    notifyResult(paramErrorMessage);
  }
  
  public void a(ErrorMessage paramErrorMessage, List<String> paramList)
  {
    String str = paramErrorMessage.toString();
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "handleBlackResult errorMessage=%s, blackGeohash count=%d", new Object[] { str, Integer.valueOf(i) });
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
    paramErrorMessage = new vin();
    paramErrorMessage.a(this.jdField_a_of_type_JavaUtilHashMap);
    paramErrorMessage.a(this);
    paramErrorMessage.a();
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "sendPOIRequest total count:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()) });
  }
  
  protected void a(JobContext paramJobContext, List<vim> paramList)
  {
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "start PreProcessSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(paramList);
      return;
    }
    int i = ((via)vux.a(30)).a().b();
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "PreProcessSegment geohashlevel=%d", new Object[] { Integer.valueOf(i) });
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    paramJobContext = paramList.iterator();
    while (paramJobContext.hasNext())
    {
      paramList = (vim)paramJobContext.next();
      if ((paramList.jdField_a_of_type_Double == 0.0D) && (paramList.b == 0.0D)) {}
      for (paramList.c = "EMPTY";; paramList.c = vjp.a(paramList.jdField_a_of_type_Double, paramList.b, i))
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramList.c)) {
          break label192;
        }
        ((vik)this.jdField_a_of_type_JavaUtilHashMap.get(paramList.c)).jdField_a_of_type_JavaUtilList.add(paramList);
        break;
      }
      label192:
      vik localvik = new vik(paramList.c);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramList);
      localvik.jdField_a_of_type_JavaUtilList = localArrayList;
      if ((!TextUtils.isEmpty(localvik.jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(localvik.jdField_a_of_type_JavaLangString, "EMPTY"))) {
        localvik.jdField_a_of_type_Vjq = vjp.a(localvik.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramList.c, localvik);
    }
    xvv.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.PreProcessSegment", "group by geohash count:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()) });
    if ((this.jdField_a_of_type_JavaUtilHashMap.size() == 1) && (this.jdField_a_of_type_JavaUtilHashMap.get("EMPTY") != null))
    {
      a(new ErrorMessage(), null);
      return;
    }
    paramJobContext = new vir();
    paramJobContext.a(this.jdField_a_of_type_JavaUtilHashMap);
    paramJobContext.a(this);
    paramJobContext.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     viy
 * JD-Core Version:    0.7.0.1
 */