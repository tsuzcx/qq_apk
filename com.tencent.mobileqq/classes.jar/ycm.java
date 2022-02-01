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

public class ycm
  extends wvr
  implements wld<wyz, xat>
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private yco jdField_a_of_type_Yco;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public ycm(int paramInt, FeedVideoInfo paramFeedVideoInfo)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramFeedVideoInfo.feedId;
    this.jdField_a_of_type_Int = paramFeedVideoInfo.mVideoPullType;
    this.jdField_b_of_type_JavaLangString = paramFeedVideoInfo.mVideoNextCookie;
    this.jdField_b_of_type_Int = paramFeedVideoInfo.mVideoSeq;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      yqp.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt) });
      zkb.a(false, "initial video page loader failed because feedId is null. from page " + paramInt);
    }
  }
  
  public ycm(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = paramInt3;
    this.d = true;
    if (TextUtils.isEmpty(paramString))
    {
      yqp.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt1) });
      zkb.a(false, "initial video page loader failed because feedId is null. from page " + paramInt1);
    }
  }
  
  private void a(ycp paramycp)
  {
    yco localyco = this.jdField_a_of_type_Yco;
    if (localyco == null)
    {
      wfo.a().dispatch(this.jdField_c_of_type_JavaLangString, paramycp);
      return;
    }
    localyco.a(paramycp);
  }
  
  private void e()
  {
    if (VideoListFeedItem.isFakeFeedId(this.jdField_a_of_type_JavaLangString))
    {
      localObject = new ycp(new ErrorMessage(), this.jdField_a_of_type_JavaLangString);
      ((ycp)localObject).jdField_a_of_type_Boolean = true;
      ((ycp)localObject).jdField_c_of_type_Boolean = true;
      wfo.a().dispatch((Dispatcher.Dispatchable)localObject);
      return;
    }
    if ((this.d) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      f();
      return;
    }
    Object localObject = new wyz();
    ((wyz)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ((wyz)localObject).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    ((wyz)localObject).jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    wlb.a().a((wlf)localObject, this);
    yqp.a("Q.qqstory.home.data:VideoListPageLoader", "send video list request. request=%s.", ((wyz)localObject).toString());
  }
  
  private void f()
  {
    wyj localwyj = new wyj();
    localwyj.jdField_a_of_type_JavaUtilList = new ArrayList(1);
    localwyj.jdField_a_of_type_JavaUtilList.add(new yib(this.jdField_a_of_type_JavaLangString, 0, "", "0"));
    wlb.a().a(localwyj, new ycn(this));
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
  
  public void a(@NonNull wyz paramwyz, @Nullable xat paramxat, @NonNull ErrorMessage paramErrorMessage)
  {
    yqp.a("Q.qqstory.home.data:VideoListPageLoader", "get video list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      yqp.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    ycp localycp = new ycp(paramErrorMessage, this.jdField_a_of_type_JavaLangString);
    localycp.d = this.jdField_a_of_type_Boolean;
    if ((paramxat == null) || (paramErrorMessage.isFail()))
    {
      a(localycp);
      return;
    }
    boolean bool = TextUtils.isEmpty(paramwyz.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_JavaLangString = paramxat.jdField_a_of_type_JavaLangString;
    localycp.jdField_a_of_type_JavaUtilList = paramxat.jdField_a_of_type_JavaUtilArrayList;
    localycp.jdField_c_of_type_Boolean = bool;
    localycp.jdField_a_of_type_Boolean = paramxat.jdField_a_of_type_Boolean;
    if ((!localycp.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      localycp.jdField_a_of_type_Boolean = true;
    }
    localycp.jdField_b_of_type_JavaLangString = paramxat.jdField_c_of_type_JavaLangString;
    localycp.jdField_a_of_type_JavaUtilList = ((yij)wpm.a(11)).a(this.jdField_a_of_type_JavaLangString, localycp.jdField_a_of_type_JavaUtilList, bool);
    localycp.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = new FeedVideoInfo(paramwyz.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, localycp.jdField_a_of_type_Boolean);
    paramwyz = new ArrayList(localycp.jdField_a_of_type_JavaUtilList.size());
    paramxat = localycp.jdField_a_of_type_JavaUtilList.iterator();
    while (paramxat.hasNext()) {
      paramwyz.add(((StoryVideoItem)paramxat.next()).mVid);
    }
    wwy.a(paramwyz);
    try
    {
      this.jdField_b_of_type_Boolean = true;
      a(localycp);
      yqp.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from network: %s", localycp);
      return;
    }
    finally {}
  }
  
  public void a(yco paramyco)
  {
    this.jdField_a_of_type_Yco = paramyco;
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
 * Qualified Name:     ycm
 * JD-Core Version:    0.7.0.1
 */