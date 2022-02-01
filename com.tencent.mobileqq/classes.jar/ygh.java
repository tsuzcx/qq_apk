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

public class ygh
  extends wzm
  implements woy<xcu, xeo>
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private ygj jdField_a_of_type_Ygj;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public ygh(int paramInt, FeedVideoInfo paramFeedVideoInfo)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramFeedVideoInfo.feedId;
    this.jdField_a_of_type_Int = paramFeedVideoInfo.mVideoPullType;
    this.jdField_b_of_type_JavaLangString = paramFeedVideoInfo.mVideoNextCookie;
    this.jdField_b_of_type_Int = paramFeedVideoInfo.mVideoSeq;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      yuk.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt) });
      znw.a(false, "initial video page loader failed because feedId is null. from page " + paramInt);
    }
  }
  
  public ygh(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = paramInt3;
    this.d = true;
    if (TextUtils.isEmpty(paramString))
    {
      yuk.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt1) });
      znw.a(false, "initial video page loader failed because feedId is null. from page " + paramInt1);
    }
  }
  
  private void a(ygk paramygk)
  {
    ygj localygj = this.jdField_a_of_type_Ygj;
    if (localygj == null)
    {
      wjj.a().dispatch(this.jdField_c_of_type_JavaLangString, paramygk);
      return;
    }
    localygj.a(paramygk);
  }
  
  private void e()
  {
    if (VideoListFeedItem.isFakeFeedId(this.jdField_a_of_type_JavaLangString))
    {
      localObject = new ygk(new ErrorMessage(), this.jdField_a_of_type_JavaLangString);
      ((ygk)localObject).jdField_a_of_type_Boolean = true;
      ((ygk)localObject).jdField_c_of_type_Boolean = true;
      wjj.a().dispatch((Dispatcher.Dispatchable)localObject);
      return;
    }
    if ((this.d) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      f();
      return;
    }
    Object localObject = new xcu();
    ((xcu)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ((xcu)localObject).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    ((xcu)localObject).jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    wow.a().a((wpa)localObject, this);
    yuk.a("Q.qqstory.home.data:VideoListPageLoader", "send video list request. request=%s.", ((xcu)localObject).toString());
  }
  
  private void f()
  {
    xce localxce = new xce();
    localxce.jdField_a_of_type_JavaUtilList = new ArrayList(1);
    localxce.jdField_a_of_type_JavaUtilList.add(new ylw(this.jdField_a_of_type_JavaLangString, 0, "", "0"));
    wow.a().a(localxce, new ygi(this));
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
  
  public void a(@NonNull xcu paramxcu, @Nullable xeo paramxeo, @NonNull ErrorMessage paramErrorMessage)
  {
    yuk.a("Q.qqstory.home.data:VideoListPageLoader", "get video list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      yuk.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    ygk localygk = new ygk(paramErrorMessage, this.jdField_a_of_type_JavaLangString);
    localygk.d = this.jdField_a_of_type_Boolean;
    if ((paramxeo == null) || (paramErrorMessage.isFail()))
    {
      a(localygk);
      return;
    }
    boolean bool = TextUtils.isEmpty(paramxcu.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_JavaLangString = paramxeo.jdField_a_of_type_JavaLangString;
    localygk.jdField_a_of_type_JavaUtilList = paramxeo.jdField_a_of_type_JavaUtilArrayList;
    localygk.jdField_c_of_type_Boolean = bool;
    localygk.jdField_a_of_type_Boolean = paramxeo.jdField_a_of_type_Boolean;
    if ((!localygk.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      localygk.jdField_a_of_type_Boolean = true;
    }
    localygk.jdField_b_of_type_JavaLangString = paramxeo.jdField_c_of_type_JavaLangString;
    localygk.jdField_a_of_type_JavaUtilList = ((yme)wth.a(11)).a(this.jdField_a_of_type_JavaLangString, localygk.jdField_a_of_type_JavaUtilList, bool);
    localygk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = new FeedVideoInfo(paramxcu.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, localygk.jdField_a_of_type_Boolean);
    paramxcu = new ArrayList(localygk.jdField_a_of_type_JavaUtilList.size());
    paramxeo = localygk.jdField_a_of_type_JavaUtilList.iterator();
    while (paramxeo.hasNext()) {
      paramxcu.add(((StoryVideoItem)paramxeo.next()).mVid);
    }
    xat.a(paramxcu);
    try
    {
      this.jdField_b_of_type_Boolean = true;
      a(localygk);
      yuk.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from network: %s", localygk);
      return;
    }
    finally {}
  }
  
  public void a(ygj paramygj)
  {
    this.jdField_a_of_type_Ygj = paramygj;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygh
 * JD-Core Version:    0.7.0.1
 */