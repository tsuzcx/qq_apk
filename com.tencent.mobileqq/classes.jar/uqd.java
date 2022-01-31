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

public class uqd
  extends tjh
  implements syt<tmp, toj>
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private uqf jdField_a_of_type_Uqf;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public uqd(int paramInt, FeedVideoInfo paramFeedVideoInfo)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramFeedVideoInfo.feedId;
    this.jdField_a_of_type_Int = paramFeedVideoInfo.mVideoPullType;
    this.jdField_b_of_type_JavaLangString = paramFeedVideoInfo.mVideoNextCookie;
    this.jdField_b_of_type_Int = paramFeedVideoInfo.mVideoSeq;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      veg.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt) });
      vxs.a(false, "initial video page loader failed because feedId is null. from page " + paramInt);
    }
  }
  
  public uqd(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = paramInt3;
    this.d = true;
    if (TextUtils.isEmpty(paramString))
    {
      veg.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt1) });
      vxs.a(false, "initial video page loader failed because feedId is null. from page " + paramInt1);
    }
  }
  
  private void a(uqg paramuqg)
  {
    uqf localuqf = this.jdField_a_of_type_Uqf;
    if (localuqf == null)
    {
      ste.a().dispatch(this.jdField_c_of_type_JavaLangString, paramuqg);
      return;
    }
    localuqf.a(paramuqg);
  }
  
  private void e()
  {
    if (VideoListFeedItem.isFakeFeedId(this.jdField_a_of_type_JavaLangString))
    {
      localObject = new uqg(new ErrorMessage(), this.jdField_a_of_type_JavaLangString);
      ((uqg)localObject).jdField_a_of_type_Boolean = true;
      ((uqg)localObject).jdField_c_of_type_Boolean = true;
      ste.a().dispatch((Dispatcher.Dispatchable)localObject);
      return;
    }
    if ((this.d) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      f();
      return;
    }
    Object localObject = new tmp();
    ((tmp)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ((tmp)localObject).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    ((tmp)localObject).jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    syr.a().a((syv)localObject, this);
    veg.a("Q.qqstory.home.data:VideoListPageLoader", "send video list request. request=%s.", ((tmp)localObject).toString());
  }
  
  private void f()
  {
    tlz localtlz = new tlz();
    localtlz.jdField_a_of_type_JavaUtilList = new ArrayList(1);
    localtlz.jdField_a_of_type_JavaUtilList.add(new uvs(this.jdField_a_of_type_JavaLangString, 0, "", "0"));
    syr.a().a(localtlz, new uqe(this));
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
  
  public void a(@NonNull tmp paramtmp, @Nullable toj paramtoj, @NonNull ErrorMessage paramErrorMessage)
  {
    veg.a("Q.qqstory.home.data:VideoListPageLoader", "get video list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      veg.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    uqg localuqg = new uqg(paramErrorMessage, this.jdField_a_of_type_JavaLangString);
    localuqg.d = this.jdField_a_of_type_Boolean;
    if ((paramtoj == null) || (paramErrorMessage.isFail()))
    {
      a(localuqg);
      return;
    }
    boolean bool = TextUtils.isEmpty(paramtmp.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_JavaLangString = paramtoj.jdField_a_of_type_JavaLangString;
    localuqg.jdField_a_of_type_JavaUtilList = paramtoj.jdField_a_of_type_JavaUtilArrayList;
    localuqg.jdField_c_of_type_Boolean = bool;
    localuqg.jdField_a_of_type_Boolean = paramtoj.jdField_a_of_type_Boolean;
    if ((!localuqg.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      localuqg.jdField_a_of_type_Boolean = true;
    }
    localuqg.jdField_b_of_type_JavaLangString = paramtoj.jdField_c_of_type_JavaLangString;
    localuqg.jdField_a_of_type_JavaUtilList = ((uwa)tdc.a(11)).a(this.jdField_a_of_type_JavaLangString, localuqg.jdField_a_of_type_JavaUtilList, bool);
    localuqg.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = new FeedVideoInfo(paramtmp.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, localuqg.jdField_a_of_type_Boolean);
    paramtmp = new ArrayList(localuqg.jdField_a_of_type_JavaUtilList.size());
    paramtoj = localuqg.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtoj.hasNext()) {
      paramtmp.add(((StoryVideoItem)paramtoj.next()).mVid);
    }
    tko.a(paramtmp);
    try
    {
      this.jdField_b_of_type_Boolean = true;
      a(localuqg);
      veg.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from network: %s", localuqg);
      return;
    }
    finally {}
  }
  
  public void a(uqf paramuqf)
  {
    this.jdField_a_of_type_Uqf = paramuqf;
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
 * Qualified Name:     uqd
 * JD-Core Version:    0.7.0.1
 */