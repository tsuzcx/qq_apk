import UserGrowth.stGetPersonalFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class usg
{
  private volatile String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  private ArrayList<String> a(List<usv> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        usv localusv = (usv)paramList.next();
        if ((localusv != null) && ((localusv.a() instanceof stSimpleMetaFeed))) {
          localArrayList.add(((stSimpleMetaFeed)localusv.a()).id);
        }
      }
    }
    return localArrayList;
  }
  
  public static usg a()
  {
    return usi.a();
  }
  
  private void a(stGetPersonalFeedListRsp paramstGetPersonalFeedListRsp, usf paramusf)
  {
    if ((paramusf instanceof uvh))
    {
      paramusf = ((uvh)paramusf).a();
      if (!(paramusf instanceof WSVerticalPageFragment)) {
        break label62;
      }
    }
    label62:
    for (paramusf = (WSVerticalPageFragment)paramusf;; paramusf = null)
    {
      if ((paramusf != null) && (paramusf.getActivity() != null) && (!paramusf.getActivity().isFinishing())) {
        ugd.a().a(10007, paramstGetPersonalFeedListRsp.config);
      }
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<usv> paramList, usf paramusf, Object paramObject)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      uqf.e("WSArkCardDataManagerLog", "[WSArkCardDataManager.java][onTaskResponse] finished!");
      return;
    }
    ArrayList localArrayList = a(paramList);
    ush localush = new ush(this, System.currentTimeMillis(), paramBoolean2, paramusf, paramBoolean1, paramObject);
    if (paramBoolean1) {}
    for (paramList = "";; paramList = this.jdField_a_of_type_JavaLangString)
    {
      paramObject = "";
      paramusf = paramObject;
      if (localArrayList != null)
      {
        paramusf = paramObject;
        if (localArrayList.size() > 0) {
          paramusf = (String)localArrayList.get(0);
        }
      }
      uqf.d("terry_d", "[WSVerticalDataManager.java] PersonalFeedListRequest isFirst = " + paramBoolean2 + " feedId = " + paramusf + " attachInfo = " + paramList);
      paramString = new uko(new uot(paramString, paramList, paramBoolean2, localArrayList, paramInt), null, localush, 4013);
      ukh.a().a(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     usg
 * JD-Core Version:    0.7.0.1
 */