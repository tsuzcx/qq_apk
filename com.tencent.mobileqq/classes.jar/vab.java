import UserGrowth.stGetPersonalFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vab
{
  private volatile String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  private ArrayList<String> a(List<vaq> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        vaq localvaq = (vaq)paramList.next();
        if ((localvaq != null) && ((localvaq.a() instanceof stSimpleMetaFeed))) {
          localArrayList.add(((stSimpleMetaFeed)localvaq.a()).id);
        }
      }
    }
    return localArrayList;
  }
  
  public static vab a()
  {
    return vad.a();
  }
  
  private void a(stGetPersonalFeedListRsp paramstGetPersonalFeedListRsp, vaa paramvaa)
  {
    if ((paramvaa instanceof vdc))
    {
      paramvaa = ((vdc)paramvaa).a();
      if (!(paramvaa instanceof WSVerticalPageFragment)) {
        break label62;
      }
    }
    label62:
    for (paramvaa = (WSVerticalPageFragment)paramvaa;; paramvaa = null)
    {
      if ((paramvaa != null) && (paramvaa.getActivity() != null) && (!paramvaa.getActivity().isFinishing())) {
        umu.a().a(10007, paramstGetPersonalFeedListRsp.config);
      }
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<vaq> paramList, vaa paramvaa, Object paramObject)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      uya.e("WSArkCardDataManagerLog", "[WSArkCardDataManager.java][onTaskResponse] finished!");
      return;
    }
    ArrayList localArrayList = a(paramList);
    vac localvac = new vac(this, System.currentTimeMillis(), paramBoolean2, paramvaa, paramBoolean1, paramObject);
    if (paramBoolean1) {}
    for (paramList = "";; paramList = this.jdField_a_of_type_JavaLangString)
    {
      paramObject = "";
      paramvaa = paramObject;
      if (localArrayList != null)
      {
        paramvaa = paramObject;
        if (localArrayList.size() > 0) {
          paramvaa = (String)localArrayList.get(0);
        }
      }
      uya.d("terry_d", "[WSVerticalDataManager.java] PersonalFeedListRequest isFirst = " + paramBoolean2 + " feedId = " + paramvaa + " attachInfo = " + paramList);
      paramString = new urj(new uwn(paramString, paramList, paramBoolean2, localArrayList, paramInt), null, localvac, 4013);
      urc.a().a(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vab
 * JD-Core Version:    0.7.0.1
 */