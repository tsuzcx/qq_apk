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

public class xwn
  extends wpx
  implements wfk<wtf, wuz>
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private xwp jdField_a_of_type_Xwp;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public xwn(int paramInt, FeedVideoInfo paramFeedVideoInfo)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramFeedVideoInfo.feedId;
    this.jdField_a_of_type_Int = paramFeedVideoInfo.mVideoPullType;
    this.jdField_b_of_type_JavaLangString = paramFeedVideoInfo.mVideoNextCookie;
    this.jdField_b_of_type_Int = paramFeedVideoInfo.mVideoSeq;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      ykq.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt) });
      zdl.a(false, "initial video page loader failed because feedId is null. from page " + paramInt);
    }
  }
  
  public xwn(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = paramInt3;
    this.d = true;
    if (TextUtils.isEmpty(paramString))
    {
      ykq.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt1) });
      zdl.a(false, "initial video page loader failed because feedId is null. from page " + paramInt1);
    }
  }
  
  private void a(xwq paramxwq)
  {
    xwp localxwp = this.jdField_a_of_type_Xwp;
    if (localxwp == null)
    {
      wad.a().dispatch(this.jdField_c_of_type_JavaLangString, paramxwq);
      return;
    }
    localxwp.a(paramxwq);
  }
  
  private void e()
  {
    if (VideoListFeedItem.isFakeFeedId(this.jdField_a_of_type_JavaLangString))
    {
      localObject = new xwq(new ErrorMessage(), this.jdField_a_of_type_JavaLangString);
      ((xwq)localObject).jdField_a_of_type_Boolean = true;
      ((xwq)localObject).jdField_c_of_type_Boolean = true;
      wad.a().dispatch((Dispatcher.Dispatchable)localObject);
      return;
    }
    if ((this.d) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      f();
      return;
    }
    Object localObject = new wtf();
    ((wtf)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ((wtf)localObject).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    ((wtf)localObject).jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    wfi.a().a((wfm)localObject, this);
    ykq.a("Q.qqstory.home.data:VideoListPageLoader", "send video list request. request=%s.", ((wtf)localObject).toString());
  }
  
  private void f()
  {
    wsp localwsp = new wsp();
    localwsp.jdField_a_of_type_JavaUtilList = new ArrayList(1);
    localwsp.jdField_a_of_type_JavaUtilList.add(new ycc(this.jdField_a_of_type_JavaLangString, 0, "", "0"));
    wfi.a().a(localwsp, new xwo(this));
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
  
  public void a(@NonNull wtf paramwtf, @Nullable wuz paramwuz, @NonNull ErrorMessage paramErrorMessage)
  {
    ykq.a("Q.qqstory.home.data:VideoListPageLoader", "get video list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      ykq.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    xwq localxwq = new xwq(paramErrorMessage, this.jdField_a_of_type_JavaLangString);
    localxwq.d = this.jdField_a_of_type_Boolean;
    if ((paramwuz == null) || (paramErrorMessage.isFail()))
    {
      a(localxwq);
      return;
    }
    boolean bool = TextUtils.isEmpty(paramwtf.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_JavaLangString = paramwuz.jdField_a_of_type_JavaLangString;
    localxwq.jdField_a_of_type_JavaUtilList = paramwuz.jdField_a_of_type_JavaUtilArrayList;
    localxwq.jdField_c_of_type_Boolean = bool;
    localxwq.jdField_a_of_type_Boolean = paramwuz.jdField_a_of_type_Boolean;
    if ((!localxwq.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      localxwq.jdField_a_of_type_Boolean = true;
    }
    localxwq.jdField_b_of_type_JavaLangString = paramwuz.jdField_c_of_type_JavaLangString;
    localxwq.jdField_a_of_type_JavaUtilList = ((yck)wjs.a(11)).a(this.jdField_a_of_type_JavaLangString, localxwq.jdField_a_of_type_JavaUtilList, bool);
    localxwq.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = new FeedVideoInfo(paramwtf.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, localxwq.jdField_a_of_type_Boolean);
    paramwtf = new ArrayList(localxwq.jdField_a_of_type_JavaUtilList.size());
    paramwuz = localxwq.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwuz.hasNext()) {
      paramwtf.add(((StoryVideoItem)paramwuz.next()).mVid);
    }
    wre.a(paramwtf);
    try
    {
      this.jdField_b_of_type_Boolean = true;
      a(localxwq);
      ykq.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from network: %s", localxwq);
      return;
    }
    finally {}
  }
  
  public void a(xwp paramxwp)
  {
    this.jdField_a_of_type_Xwp = paramxwp;
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
 * Qualified Name:     xwn
 * JD-Core Version:    0.7.0.1
 */