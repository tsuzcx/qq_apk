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

public class xhs
  extends wbc
  implements vqp<wek, wge>
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private xhu jdField_a_of_type_Xhu;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public xhs(int paramInt, FeedVideoInfo paramFeedVideoInfo)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramFeedVideoInfo.feedId;
    this.jdField_a_of_type_Int = paramFeedVideoInfo.mVideoPullType;
    this.jdField_b_of_type_JavaLangString = paramFeedVideoInfo.mVideoNextCookie;
    this.jdField_b_of_type_Int = paramFeedVideoInfo.mVideoSeq;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      xvv.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt) });
      yos.a(false, "initial video page loader failed because feedId is null. from page " + paramInt);
    }
  }
  
  public xhs(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = paramInt3;
    this.d = true;
    if (TextUtils.isEmpty(paramString))
    {
      xvv.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt1) });
      yos.a(false, "initial video page loader failed because feedId is null. from page " + paramInt1);
    }
  }
  
  private void a(xhv paramxhv)
  {
    xhu localxhu = this.jdField_a_of_type_Xhu;
    if (localxhu == null)
    {
      vli.a().dispatch(this.jdField_c_of_type_JavaLangString, paramxhv);
      return;
    }
    localxhu.a(paramxhv);
  }
  
  private void e()
  {
    if (VideoListFeedItem.isFakeFeedId(this.jdField_a_of_type_JavaLangString))
    {
      localObject = new xhv(new ErrorMessage(), this.jdField_a_of_type_JavaLangString);
      ((xhv)localObject).jdField_a_of_type_Boolean = true;
      ((xhv)localObject).jdField_c_of_type_Boolean = true;
      vli.a().dispatch((Dispatcher.Dispatchable)localObject);
      return;
    }
    if ((this.d) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      f();
      return;
    }
    Object localObject = new wek();
    ((wek)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ((wek)localObject).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    ((wek)localObject).jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    vqn.a().a((vqr)localObject, this);
    xvv.a("Q.qqstory.home.data:VideoListPageLoader", "send video list request. request=%s.", ((wek)localObject).toString());
  }
  
  private void f()
  {
    wdu localwdu = new wdu();
    localwdu.jdField_a_of_type_JavaUtilList = new ArrayList(1);
    localwdu.jdField_a_of_type_JavaUtilList.add(new xnh(this.jdField_a_of_type_JavaLangString, 0, "", "0"));
    vqn.a().a(localwdu, new xht(this));
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
  
  public void a(@NonNull wek paramwek, @Nullable wge paramwge, @NonNull ErrorMessage paramErrorMessage)
  {
    xvv.a("Q.qqstory.home.data:VideoListPageLoader", "get video list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      xvv.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    xhv localxhv = new xhv(paramErrorMessage, this.jdField_a_of_type_JavaLangString);
    localxhv.d = this.jdField_a_of_type_Boolean;
    if ((paramwge == null) || (paramErrorMessage.isFail()))
    {
      a(localxhv);
      return;
    }
    boolean bool = TextUtils.isEmpty(paramwek.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_JavaLangString = paramwge.jdField_a_of_type_JavaLangString;
    localxhv.jdField_a_of_type_JavaUtilList = paramwge.jdField_a_of_type_JavaUtilArrayList;
    localxhv.jdField_c_of_type_Boolean = bool;
    localxhv.jdField_a_of_type_Boolean = paramwge.jdField_a_of_type_Boolean;
    if ((!localxhv.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      localxhv.jdField_a_of_type_Boolean = true;
    }
    localxhv.jdField_b_of_type_JavaLangString = paramwge.jdField_c_of_type_JavaLangString;
    localxhv.jdField_a_of_type_JavaUtilList = ((xnp)vux.a(11)).a(this.jdField_a_of_type_JavaLangString, localxhv.jdField_a_of_type_JavaUtilList, bool);
    localxhv.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = new FeedVideoInfo(paramwek.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, localxhv.jdField_a_of_type_Boolean);
    paramwek = new ArrayList(localxhv.jdField_a_of_type_JavaUtilList.size());
    paramwge = localxhv.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwge.hasNext()) {
      paramwek.add(((StoryVideoItem)paramwge.next()).mVid);
    }
    wcj.a(paramwek);
    try
    {
      this.jdField_b_of_type_Boolean = true;
      a(localxhv);
      xvv.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from network: %s", localxhv);
      return;
    }
    finally {}
  }
  
  public void a(xhu paramxhu)
  {
    this.jdField_a_of_type_Xhu = paramxhu;
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
 * Qualified Name:     xhs
 * JD-Core Version:    0.7.0.1
 */