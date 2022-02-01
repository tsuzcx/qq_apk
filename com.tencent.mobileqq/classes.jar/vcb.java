import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

class vcb
  implements uze
{
  vcb(vbr paramvbr, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(int paramInt)
  {
    if (paramInt == uzf.a)
    {
      vbr.a(this.jdField_a_of_type_Vbr, 48);
      if (vbr.a(this.jdField_a_of_type_Vbr).a(vbr.a(this.jdField_a_of_type_Vbr), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment))
      {
        localObject = this.jdField_a_of_type_Vbr.a().getResources().getString(2131697326);
        bhlq.a(this.jdField_a_of_type_Vbr.a(), 230, (String)localObject, null, 2131690580, 2131690562, new vcc(this), new vcd(this)).show();
      }
    }
    do
    {
      do
      {
        return;
        vbr.a(this.jdField_a_of_type_Vbr).a(this.jdField_a_of_type_Vbr.a().hashCode(), vbr.a(this.jdField_a_of_type_Vbr), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
        return;
        if (paramInt == uzf.b)
        {
          vbr.a(this.jdField_a_of_type_Vbr, 49);
          localObject = this.jdField_a_of_type_Vbr.a().getResources().getString(2131697184);
          bhlq.a(this.jdField_a_of_type_Vbr.a(), 230, (String)localObject, null, 2131690580, 2131690562, new vce(this), new vcf(this)).show();
          return;
        }
        if (paramInt != uzf.c) {
          break;
        }
        vbr.a(this.jdField_a_of_type_Vbr, 46);
        localObject = (ClipboardManager)this.jdField_a_of_type_Vbr.a().getSystemService("clipboard");
      } while (localObject == null);
      ((ClipboardManager)localObject).setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.content.get()));
      return;
      if (paramInt == uzf.e)
      {
        vbr.a(this.jdField_a_of_type_Vbr, 47);
        if (uzg.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.get())) {}
        for (paramInt = 0;; paramInt = 2)
        {
          localObject = this.jdField_a_of_type_Vbr.a().getResources().getString(2131697189);
          bhlq.a(this.jdField_a_of_type_Vbr.a(), 230, (String)localObject, null, 2131690580, 2131690562, new vcg(this, paramInt), new vch(this)).show();
          return;
        }
      }
    } while (paramInt != uzf.d);
    Object localObject = new vax().b(vbr.a(this.jdField_a_of_type_Vbr).id.get()).c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get()).a(vbr.a(this.jdField_a_of_type_Vbr).poster.id.get()).e(String.valueOf(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.createTime.get())).a();
    vwj.a(new vaw().a("wezone_comment").d((String)localObject).c(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.id.get()).b("25041").a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcb
 * JD-Core Version:    0.7.0.1
 */