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

public class udh
  extends swl
  implements slx<szt, tbn>
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private udj jdField_a_of_type_Udj;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public udh(int paramInt, FeedVideoInfo paramFeedVideoInfo)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramFeedVideoInfo.feedId;
    this.jdField_a_of_type_Int = paramFeedVideoInfo.mVideoPullType;
    this.jdField_b_of_type_JavaLangString = paramFeedVideoInfo.mVideoNextCookie;
    this.jdField_b_of_type_Int = paramFeedVideoInfo.mVideoSeq;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      urk.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt) });
      vkw.a(false, "initial video page loader failed because feedId is null. from page " + paramInt);
    }
  }
  
  public udh(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = paramInt3;
    this.d = true;
    if (TextUtils.isEmpty(paramString))
    {
      urk.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt1) });
      vkw.a(false, "initial video page loader failed because feedId is null. from page " + paramInt1);
    }
  }
  
  private void a(udk paramudk)
  {
    udj localudj = this.jdField_a_of_type_Udj;
    if (localudj == null)
    {
      sgi.a().dispatch(this.jdField_c_of_type_JavaLangString, paramudk);
      return;
    }
    localudj.a(paramudk);
  }
  
  private void e()
  {
    if (VideoListFeedItem.isFakeFeedId(this.jdField_a_of_type_JavaLangString))
    {
      localObject = new udk(new ErrorMessage(), this.jdField_a_of_type_JavaLangString);
      ((udk)localObject).jdField_a_of_type_Boolean = true;
      ((udk)localObject).jdField_c_of_type_Boolean = true;
      sgi.a().dispatch((Dispatcher.Dispatchable)localObject);
      return;
    }
    if ((this.d) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      f();
      return;
    }
    Object localObject = new szt();
    ((szt)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ((szt)localObject).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    ((szt)localObject).jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    slv.a().a((slz)localObject, this);
    urk.a("Q.qqstory.home.data:VideoListPageLoader", "send video list request. request=%s.", ((szt)localObject).toString());
  }
  
  private void f()
  {
    szd localszd = new szd();
    localszd.jdField_a_of_type_JavaUtilList = new ArrayList(1);
    localszd.jdField_a_of_type_JavaUtilList.add(new uiw(this.jdField_a_of_type_JavaLangString, 0, "", "0"));
    slv.a().a(localszd, new udi(this));
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
  
  public void a(@NonNull szt paramszt, @Nullable tbn paramtbn, @NonNull ErrorMessage paramErrorMessage)
  {
    urk.a("Q.qqstory.home.data:VideoListPageLoader", "get video list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      urk.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    udk localudk = new udk(paramErrorMessage, this.jdField_a_of_type_JavaLangString);
    localudk.d = this.jdField_a_of_type_Boolean;
    if ((paramtbn == null) || (paramErrorMessage.isFail()))
    {
      a(localudk);
      return;
    }
    boolean bool = TextUtils.isEmpty(paramszt.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_JavaLangString = paramtbn.jdField_a_of_type_JavaLangString;
    localudk.jdField_a_of_type_JavaUtilList = paramtbn.jdField_a_of_type_JavaUtilArrayList;
    localudk.jdField_c_of_type_Boolean = bool;
    localudk.jdField_a_of_type_Boolean = paramtbn.jdField_a_of_type_Boolean;
    if ((!localudk.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      localudk.jdField_a_of_type_Boolean = true;
    }
    localudk.jdField_b_of_type_JavaLangString = paramtbn.jdField_c_of_type_JavaLangString;
    localudk.jdField_a_of_type_JavaUtilList = ((uje)sqg.a(11)).a(this.jdField_a_of_type_JavaLangString, localudk.jdField_a_of_type_JavaUtilList, bool);
    localudk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = new FeedVideoInfo(paramszt.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, localudk.jdField_a_of_type_Boolean);
    paramszt = new ArrayList(localudk.jdField_a_of_type_JavaUtilList.size());
    paramtbn = localudk.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtbn.hasNext()) {
      paramszt.add(((StoryVideoItem)paramtbn.next()).mVid);
    }
    sxs.a(paramszt);
    try
    {
      this.jdField_b_of_type_Boolean = true;
      a(localudk);
      urk.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from network: %s", localudk);
      return;
    }
    finally {}
  }
  
  public void a(udj paramudj)
  {
    this.jdField_a_of_type_Udj = paramudj;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     udh
 * JD-Core Version:    0.7.0.1
 */