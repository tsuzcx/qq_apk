import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wjb
  extends vcf
  implements urr<vfn, vhh>
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private wjd jdField_a_of_type_Wjd;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public wjb(int paramInt, FeedVideoInfo paramFeedVideoInfo)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramFeedVideoInfo.feedId;
    this.jdField_a_of_type_Int = paramFeedVideoInfo.mVideoPullType;
    this.jdField_b_of_type_JavaLangString = paramFeedVideoInfo.mVideoNextCookie;
    this.jdField_b_of_type_Int = paramFeedVideoInfo.mVideoSeq;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      wxe.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt) });
      xqq.a(false, "initial video page loader failed because feedId is null. from page " + paramInt);
    }
  }
  
  public wjb(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = paramInt3;
    this.d = true;
    if (TextUtils.isEmpty(paramString))
    {
      wxe.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt1) });
      xqq.a(false, "initial video page loader failed because feedId is null. from page " + paramInt1);
    }
  }
  
  private void a(wje paramwje)
  {
    wjd localwjd = this.jdField_a_of_type_Wjd;
    if (localwjd == null)
    {
      umc.a().dispatch(this.jdField_c_of_type_JavaLangString, paramwje);
      return;
    }
    localwjd.a(paramwje);
  }
  
  private void e()
  {
    if (VideoListFeedItem.isFakeFeedId(this.jdField_a_of_type_JavaLangString))
    {
      localObject = new wje(new ErrorMessage(), this.jdField_a_of_type_JavaLangString);
      ((wje)localObject).jdField_a_of_type_Boolean = true;
      ((wje)localObject).jdField_c_of_type_Boolean = true;
      umc.a().dispatch((Dispatcher.Dispatchable)localObject);
      return;
    }
    if ((this.d) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      f();
      return;
    }
    Object localObject = new vfn();
    ((vfn)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ((vfn)localObject).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    ((vfn)localObject).jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    urp.a().a((urt)localObject, this);
    wxe.a("Q.qqstory.home.data:VideoListPageLoader", "send video list request. request=%s.", ((vfn)localObject).toString());
  }
  
  private void f()
  {
    vex localvex = new vex();
    localvex.jdField_a_of_type_JavaUtilList = new ArrayList(1);
    localvex.jdField_a_of_type_JavaUtilList.add(new woq(this.jdField_a_of_type_JavaLangString, 0, "", "0"));
    urp.a().a(localvex, new wjc(this));
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_JavaLangString = "";
    e();
  }
  
  public void a(@NonNull vfn paramvfn, @Nullable vhh paramvhh, @NonNull ErrorMessage paramErrorMessage)
  {
    wxe.a("Q.qqstory.home.data:VideoListPageLoader", "get video list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      wxe.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    wje localwje = new wje(paramErrorMessage, this.jdField_a_of_type_JavaLangString);
    localwje.d = this.jdField_a_of_type_Boolean;
    if ((paramvhh == null) || (paramErrorMessage.isFail()))
    {
      a(localwje);
      return;
    }
    boolean bool = TextUtils.isEmpty(paramvfn.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_JavaLangString = paramvhh.jdField_a_of_type_JavaLangString;
    localwje.jdField_a_of_type_JavaUtilList = paramvhh.jdField_a_of_type_JavaUtilArrayList;
    localwje.jdField_c_of_type_Boolean = bool;
    localwje.jdField_a_of_type_Boolean = paramvhh.jdField_a_of_type_Boolean;
    if ((!localwje.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      localwje.jdField_a_of_type_Boolean = true;
    }
    localwje.jdField_b_of_type_JavaLangString = paramvhh.jdField_c_of_type_JavaLangString;
    localwje.jdField_a_of_type_JavaUtilList = ((woy)uwa.a(11)).a(this.jdField_a_of_type_JavaLangString, localwje.jdField_a_of_type_JavaUtilList, bool);
    localwje.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = new FeedVideoInfo(paramvfn.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, localwje.jdField_a_of_type_Boolean);
    paramvfn = new ArrayList(localwje.jdField_a_of_type_JavaUtilList.size());
    paramvhh = localwje.jdField_a_of_type_JavaUtilList.iterator();
    while (paramvhh.hasNext()) {
      paramvfn.add(((StoryVideoItem)paramvhh.next()).mVid);
    }
    vdm.a(paramvfn);
    try
    {
      this.jdField_b_of_type_Boolean = true;
      a(localwje);
      wxe.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from network: %s", localwje);
      return;
    }
    finally {}
  }
  
  public void a(wjd paramwjd)
  {
    this.jdField_a_of_type_Wjd = paramwjd;
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    e();
  }
  
  public void d()
  {
    this.jdField_c_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wjb
 * JD-Core Version:    0.7.0.1
 */