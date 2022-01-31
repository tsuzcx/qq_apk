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

public class wes
  extends uxw
  implements uni<vbe, vcy>
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private weu jdField_a_of_type_Weu;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public wes(int paramInt, FeedVideoInfo paramFeedVideoInfo)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramFeedVideoInfo.feedId;
    this.jdField_a_of_type_Int = paramFeedVideoInfo.mVideoPullType;
    this.jdField_b_of_type_JavaLangString = paramFeedVideoInfo.mVideoNextCookie;
    this.jdField_b_of_type_Int = paramFeedVideoInfo.mVideoSeq;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      wsv.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt) });
      xmh.a(false, "initial video page loader failed because feedId is null. from page " + paramInt);
    }
  }
  
  public wes(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = paramInt3;
    this.d = true;
    if (TextUtils.isEmpty(paramString))
    {
      wsv.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt1) });
      xmh.a(false, "initial video page loader failed because feedId is null. from page " + paramInt1);
    }
  }
  
  private void a(wev paramwev)
  {
    weu localweu = this.jdField_a_of_type_Weu;
    if (localweu == null)
    {
      uht.a().dispatch(this.jdField_c_of_type_JavaLangString, paramwev);
      return;
    }
    localweu.a(paramwev);
  }
  
  private void e()
  {
    if (VideoListFeedItem.isFakeFeedId(this.jdField_a_of_type_JavaLangString))
    {
      localObject = new wev(new ErrorMessage(), this.jdField_a_of_type_JavaLangString);
      ((wev)localObject).jdField_a_of_type_Boolean = true;
      ((wev)localObject).jdField_c_of_type_Boolean = true;
      uht.a().dispatch((Dispatcher.Dispatchable)localObject);
      return;
    }
    if ((this.d) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      f();
      return;
    }
    Object localObject = new vbe();
    ((vbe)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ((vbe)localObject).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    ((vbe)localObject).jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    ung.a().a((unk)localObject, this);
    wsv.a("Q.qqstory.home.data:VideoListPageLoader", "send video list request. request=%s.", ((vbe)localObject).toString());
  }
  
  private void f()
  {
    vao localvao = new vao();
    localvao.jdField_a_of_type_JavaUtilList = new ArrayList(1);
    localvao.jdField_a_of_type_JavaUtilList.add(new wkh(this.jdField_a_of_type_JavaLangString, 0, "", "0"));
    ung.a().a(localvao, new wet(this));
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
  
  public void a(@NonNull vbe paramvbe, @Nullable vcy paramvcy, @NonNull ErrorMessage paramErrorMessage)
  {
    wsv.a("Q.qqstory.home.data:VideoListPageLoader", "get video list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      wsv.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    wev localwev = new wev(paramErrorMessage, this.jdField_a_of_type_JavaLangString);
    localwev.d = this.jdField_a_of_type_Boolean;
    if ((paramvcy == null) || (paramErrorMessage.isFail()))
    {
      a(localwev);
      return;
    }
    boolean bool = TextUtils.isEmpty(paramvbe.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_JavaLangString = paramvcy.jdField_a_of_type_JavaLangString;
    localwev.jdField_a_of_type_JavaUtilList = paramvcy.jdField_a_of_type_JavaUtilArrayList;
    localwev.jdField_c_of_type_Boolean = bool;
    localwev.jdField_a_of_type_Boolean = paramvcy.jdField_a_of_type_Boolean;
    if ((!localwev.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      localwev.jdField_a_of_type_Boolean = true;
    }
    localwev.jdField_b_of_type_JavaLangString = paramvcy.jdField_c_of_type_JavaLangString;
    localwev.jdField_a_of_type_JavaUtilList = ((wkp)urr.a(11)).a(this.jdField_a_of_type_JavaLangString, localwev.jdField_a_of_type_JavaUtilList, bool);
    localwev.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = new FeedVideoInfo(paramvbe.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, localwev.jdField_a_of_type_Boolean);
    paramvbe = new ArrayList(localwev.jdField_a_of_type_JavaUtilList.size());
    paramvcy = localwev.jdField_a_of_type_JavaUtilList.iterator();
    while (paramvcy.hasNext()) {
      paramvbe.add(((StoryVideoItem)paramvcy.next()).mVid);
    }
    uzd.a(paramvbe);
    try
    {
      this.jdField_b_of_type_Boolean = true;
      a(localwev);
      wsv.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from network: %s", localwev);
      return;
    }
    finally {}
  }
  
  public void a(weu paramweu)
  {
    this.jdField_a_of_type_Weu = paramweu;
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
 * Qualified Name:     wes
 * JD-Core Version:    0.7.0.1
 */