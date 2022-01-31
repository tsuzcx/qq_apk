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

public class uqa
  extends tje
  implements syq<tmm, tog>
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private uqc jdField_a_of_type_Uqc;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public uqa(int paramInt, FeedVideoInfo paramFeedVideoInfo)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramFeedVideoInfo.feedId;
    this.jdField_a_of_type_Int = paramFeedVideoInfo.mVideoPullType;
    this.jdField_b_of_type_JavaLangString = paramFeedVideoInfo.mVideoNextCookie;
    this.jdField_b_of_type_Int = paramFeedVideoInfo.mVideoSeq;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      ved.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt) });
      vxp.a(false, "initial video page loader failed because feedId is null. from page " + paramInt);
    }
  }
  
  public uqa(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = paramInt3;
    this.d = true;
    if (TextUtils.isEmpty(paramString))
    {
      ved.e("Q.qqstory.home.data:VideoListPageLoader", "initial video page loader failed because feedId is null. from page %d.", new Object[] { Integer.valueOf(paramInt1) });
      vxp.a(false, "initial video page loader failed because feedId is null. from page " + paramInt1);
    }
  }
  
  private void a(uqd paramuqd)
  {
    uqc localuqc = this.jdField_a_of_type_Uqc;
    if (localuqc == null)
    {
      stb.a().dispatch(this.jdField_c_of_type_JavaLangString, paramuqd);
      return;
    }
    localuqc.a(paramuqd);
  }
  
  private void e()
  {
    if (VideoListFeedItem.isFakeFeedId(this.jdField_a_of_type_JavaLangString))
    {
      localObject = new uqd(new ErrorMessage(), this.jdField_a_of_type_JavaLangString);
      ((uqd)localObject).jdField_a_of_type_Boolean = true;
      ((uqd)localObject).jdField_c_of_type_Boolean = true;
      stb.a().dispatch((Dispatcher.Dispatchable)localObject);
      return;
    }
    if ((this.d) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      f();
      return;
    }
    Object localObject = new tmm();
    ((tmm)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ((tmm)localObject).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    ((tmm)localObject).jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    syo.a().a((sys)localObject, this);
    ved.a("Q.qqstory.home.data:VideoListPageLoader", "send video list request. request=%s.", ((tmm)localObject).toString());
  }
  
  private void f()
  {
    tlw localtlw = new tlw();
    localtlw.jdField_a_of_type_JavaUtilList = new ArrayList(1);
    localtlw.jdField_a_of_type_JavaUtilList.add(new uvp(this.jdField_a_of_type_JavaLangString, 0, "", "0"));
    syo.a().a(localtlw, new uqb(this));
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
  
  public void a(@NonNull tmm paramtmm, @Nullable tog paramtog, @NonNull ErrorMessage paramErrorMessage)
  {
    ved.a("Q.qqstory.home.data:VideoListPageLoader", "get video list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      ved.c("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    uqd localuqd = new uqd(paramErrorMessage, this.jdField_a_of_type_JavaLangString);
    localuqd.d = this.jdField_a_of_type_Boolean;
    if ((paramtog == null) || (paramErrorMessage.isFail()))
    {
      a(localuqd);
      return;
    }
    boolean bool = TextUtils.isEmpty(paramtmm.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_JavaLangString = paramtog.jdField_a_of_type_JavaLangString;
    localuqd.jdField_a_of_type_JavaUtilList = paramtog.jdField_a_of_type_JavaUtilArrayList;
    localuqd.jdField_c_of_type_Boolean = bool;
    localuqd.jdField_a_of_type_Boolean = paramtog.jdField_a_of_type_Boolean;
    if ((!localuqd.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      localuqd.jdField_a_of_type_Boolean = true;
    }
    localuqd.jdField_b_of_type_JavaLangString = paramtog.jdField_c_of_type_JavaLangString;
    localuqd.jdField_a_of_type_JavaUtilList = ((uvx)tcz.a(11)).a(this.jdField_a_of_type_JavaLangString, localuqd.jdField_a_of_type_JavaUtilList, bool);
    localuqd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo = new FeedVideoInfo(paramtmm.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, localuqd.jdField_a_of_type_Boolean);
    paramtmm = new ArrayList(localuqd.jdField_a_of_type_JavaUtilList.size());
    paramtog = localuqd.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtog.hasNext()) {
      paramtmm.add(((StoryVideoItem)paramtog.next()).mVid);
    }
    tkl.a(paramtmm);
    try
    {
      this.jdField_b_of_type_Boolean = true;
      a(localuqd);
      ved.a("Q.qqstory.home.data:VideoListPageLoader", "dispatch video list return from network: %s", localuqd);
      return;
    }
    finally {}
  }
  
  public void a(uqc paramuqc)
  {
    this.jdField_a_of_type_Uqc = paramuqc;
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
 * Qualified Name:     uqa
 * JD-Core Version:    0.7.0.1
 */