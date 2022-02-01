import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Arrays;
import java.util.List;

public class qxc
  implements ppv.b<pyu, qag>, qxo
{
  protected qxo.a a;
  protected qxo.b a;
  protected qxd.a b;
  
  public Object D()
  {
    return this.b;
  }
  
  public boolean KH()
  {
    return false;
  }
  
  public void a(@NonNull pyu parampyu, @Nullable qag paramqag, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramqag != null) && (paramErrorMessage.isSuccess()) && (paramqag.nB != null) && (paramqag.nB.size() > 0))
    {
      this.b.b = ((ptp)paramqag.nB.get(0));
      parampyu = (psr)psx.a(10);
      parampyu.n("qqstory_key_story_latest_feed_feature_feed_id", this.b.b.feedId);
      parampyu.n("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(this.b.b.totalLikeCount));
      parampyu.n("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(this.b.b.bkl));
      parampyu.n("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(this.b.b.bkm));
      if (this.jdField_a_of_type_Qxo$b != null)
      {
        this.jdField_a_of_type_Qxo$b.si(getKey());
        return;
      }
      ram.w("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    int i = paramErrorMessage.errorCode;
    if (paramqag == null) {
      parampyu = "rsp is null";
    }
    for (;;)
    {
      ram.e("GetMyStoryFeatureDataStep", "请求Features失败 errorCode: %d %s", new Object[] { Integer.valueOf(i), parampyu });
      this.b.b = new ptp();
      this.b.b.feedId = this.b.feedId;
      if (this.jdField_a_of_type_Qxo$b == null) {
        break;
      }
      this.jdField_a_of_type_Qxo$b.si(getKey());
      return;
      if (paramqag.nB == null) {
        parampyu = "features is null";
      } else {
        parampyu = "invalid rsp";
      }
    }
    ram.w("GetMyStoryFeatureDataStep", "finish callBack is null");
  }
  
  public void a(qxo.a parama)
  {
    this.jdField_a_of_type_Qxo$a = parama;
  }
  
  public void a(qxo.b paramb)
  {
    this.jdField_a_of_type_Qxo$b = paramb;
  }
  
  public void an(Object paramObject)
  {
    this.b = ((qxd.a)paramObject);
  }
  
  public void dump() {}
  
  public String getKey()
  {
    return getClass().getSimpleName();
  }
  
  public void reset() {}
  
  public void run()
  {
    ram.i("GetMyStoryFeatureDataStep", "GetMyStoryFeatureDataStep");
    if ((this.b == null) || (TextUtils.isEmpty(this.b.feedId)))
    {
      if (this.jdField_a_of_type_Qxo$b != null)
      {
        this.jdField_a_of_type_Qxo$b.si(getKey());
        return;
      }
      ram.w("GetMyStoryFeatureDataStep", "finish callBack is null");
      return;
    }
    pyu localpyu = new pyu();
    localpyu.no = Arrays.asList(new String[] { this.b.feedId });
    ppv.a().a(localpyu, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qxc
 * JD-Core Version:    0.7.0.1
 */