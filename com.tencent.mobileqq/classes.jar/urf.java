import UserGrowth.stGetPersonalFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class urf
{
  private volatile String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  private ArrayList<String> a(List<uru> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        uru localuru = (uru)paramList.next();
        if ((localuru != null) && ((localuru.a() instanceof stSimpleMetaFeed))) {
          localArrayList.add(((stSimpleMetaFeed)localuru.a()).id);
        }
      }
    }
    return localArrayList;
  }
  
  public static urf a()
  {
    return urh.a();
  }
  
  private void a(stGetPersonalFeedListRsp paramstGetPersonalFeedListRsp, ure paramure)
  {
    if ((paramure instanceof uuf))
    {
      paramure = ((uuf)paramure).a();
      if (!(paramure instanceof WSVerticalPageFragment)) {
        break label61;
      }
    }
    label61:
    for (paramure = (WSVerticalPageFragment)paramure;; paramure = null)
    {
      if ((paramure != null) && (paramure.getActivity() != null) && (!paramure.getActivity().isFinishing())) {
        ugb.a().a(paramstGetPersonalFeedListRsp.config, "global_key_personal_feed_list");
      }
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<uru> paramList, ure paramure, Object paramObject)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      upe.e("WSArkCardDataManagerLog", "[WSArkCardDataManager.java][onTaskResponse] finished!");
      return;
    }
    ArrayList localArrayList = a(paramList);
    urg localurg = new urg(this, System.currentTimeMillis(), paramBoolean2, paramure, paramBoolean1, paramObject);
    if (paramBoolean1) {}
    for (paramList = "";; paramList = this.jdField_a_of_type_JavaLangString)
    {
      paramObject = "";
      paramure = paramObject;
      if (localArrayList != null)
      {
        paramure = paramObject;
        if (localArrayList.size() > 0) {
          paramure = (String)localArrayList.get(0);
        }
      }
      upe.d("terry_d", "[WSVerticalDataManager.java] PersonalFeedListRequest isFirst = " + paramBoolean2 + " feedId = " + paramure + " attachInfo = " + paramList);
      paramString = new uju(new uns(paramString, paramList, paramBoolean2, localArrayList, paramInt), null, localurg, 4013);
      ujn.a().a(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urf
 * JD-Core Version:    0.7.0.1
 */