import UserGrowth.stFeedStatus;
import UserGrowth.stGetPersonalFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vot
{
  private volatile String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  private ArrayList<String> a(List<vpj> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        vpj localvpj = (vpj)paramList.next();
        if ((localvpj != null) && ((localvpj.a() instanceof stSimpleMetaFeed))) {
          localArrayList.add(((stSimpleMetaFeed)localvpj.a()).id);
        }
      }
    }
    return localArrayList;
  }
  
  public static vot a()
  {
    return vow.a();
  }
  
  private void a(stGetPersonalFeedListRsp paramstGetPersonalFeedListRsp, vos paramvos)
  {
    if ((paramvos instanceof vrx))
    {
      paramvos = ((vrx)paramvos).a();
      if (!(paramvos instanceof WSVerticalPageFragment)) {
        break label62;
      }
    }
    label62:
    for (paramvos = (WSVerticalPageFragment)paramvos;; paramvos = null)
    {
      if ((paramvos != null) && (paramvos.getActivity() != null) && (!paramvos.getActivity().isFinishing())) {
        vau.a().a(10007, paramstGetPersonalFeedListRsp.config);
      }
      return;
    }
  }
  
  private void a(stGetPersonalFeedListRsp paramstGetPersonalFeedListRsp, vov paramvov)
  {
    if (paramstGetPersonalFeedListRsp.contextFeedStatus != null)
    {
      paramvov.jdField_a_of_type_JavaLangString = paramstGetPersonalFeedListRsp.contextFeedStatus.feedId;
      paramvov.b = paramstGetPersonalFeedListRsp.contextFeedStatus.msg;
      vmp.e("WSArkCardDataManagerLog", "[WSArkCardDataManager.java][setExtParams] extParams:" + paramvov);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<vpj> paramList, vos paramvos, Object paramObject)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      vmp.e("WSArkCardDataManagerLog", "[WSArkCardDataManager.java][onTaskResponse] finished!");
      return;
    }
    ArrayList localArrayList = a(paramList);
    vou localvou = new vou(this, System.currentTimeMillis(), paramBoolean2, paramvos, paramBoolean1);
    if (paramBoolean1) {}
    for (paramList = "";; paramList = this.jdField_a_of_type_JavaLangString)
    {
      paramObject = "";
      paramvos = paramObject;
      if (localArrayList != null)
      {
        paramvos = paramObject;
        if (localArrayList.size() > 0) {
          paramvos = (String)localArrayList.get(0);
        }
      }
      vmp.d("terry_d", "[WSVerticalDataManager.java] PersonalFeedListRequest isFirst = " + paramBoolean2 + " feedId = " + paramvos + " attachInfo = " + paramList);
      paramString = new vfr(new vlc(paramString, paramList, paramBoolean2, localArrayList, paramInt), null, localvou, 4013);
      vfk.a().a(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vot
 * JD-Core Version:    0.7.0.1
 */