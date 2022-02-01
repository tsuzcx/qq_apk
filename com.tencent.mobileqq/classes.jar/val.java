import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

class val
  implements uxv
{
  val(vab paramvab, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(int paramInt)
  {
    if (paramInt == uxw.a)
    {
      vab.a(this.jdField_a_of_type_Vab, 48);
      if (vab.a(this.jdField_a_of_type_Vab).a(vab.a(this.jdField_a_of_type_Vab), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment))
      {
        localObject = this.jdField_a_of_type_Vab.a().getResources().getString(2131697249);
        bglp.a(this.jdField_a_of_type_Vab.a(), 230, (String)localObject, null, 2131690582, 2131690566, new vam(this), new van(this)).show();
      }
    }
    do
    {
      do
      {
        return;
        vab.a(this.jdField_a_of_type_Vab).a(this.jdField_a_of_type_Vab.a().hashCode(), vab.a(this.jdField_a_of_type_Vab), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
        return;
        if (paramInt == uxw.b)
        {
          vab.a(this.jdField_a_of_type_Vab, 49);
          localObject = this.jdField_a_of_type_Vab.a().getResources().getString(2131697123);
          bglp.a(this.jdField_a_of_type_Vab.a(), 230, (String)localObject, null, 2131690582, 2131690566, new vao(this), new vap(this)).show();
          return;
        }
        if (paramInt != uxw.c) {
          break;
        }
        vab.a(this.jdField_a_of_type_Vab, 46);
        localObject = (ClipboardManager)this.jdField_a_of_type_Vab.a().getSystemService("clipboard");
      } while (localObject == null);
      ((ClipboardManager)localObject).setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.content.get()));
      return;
      if (paramInt == uxw.e)
      {
        vab.a(this.jdField_a_of_type_Vab, 47);
        if (uxx.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.get())) {}
        for (paramInt = 0;; paramInt = 2)
        {
          localObject = this.jdField_a_of_type_Vab.a().getResources().getString(2131697128);
          bglp.a(this.jdField_a_of_type_Vab.a(), 230, (String)localObject, null, 2131690582, 2131690566, new vaq(this, paramInt), new var(this)).show();
          return;
        }
      }
    } while (paramInt != uxw.d);
    Object localObject = new uzh().b(vab.a(this.jdField_a_of_type_Vab).id.get()).c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get()).a(vab.a(this.jdField_a_of_type_Vab).poster.id.get()).e(String.valueOf(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.createTime.get())).a();
    vtl.a(new uzg().a("wezone_comment").d((String)localObject).c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.id.get()).b("25041").a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     val
 * JD-Core Version:    0.7.0.1
 */