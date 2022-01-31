import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StUser;

class tvl
  implements tqy
{
  tvl(tvj paramtvj, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(int paramInt)
  {
    Object localObject;
    if (paramInt == tqz.a)
    {
      tuz.a(this.jdField_a_of_type_Tvj.a, 48);
      if (this.jdField_a_of_type_Tvj.a.a().a(tuz.a(this.jdField_a_of_type_Tvj.a), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment))
      {
        localObject = tuz.a(this.jdField_a_of_type_Tvj.a).getString(2131698377);
        bdgm.a(tuz.a(this.jdField_a_of_type_Tvj.a), 230, (String)localObject, null, 2131690648, 2131690626, new tvm(this), new tvn(this)).show();
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Tvj.a.a().b(tuz.a(this.jdField_a_of_type_Tvj.a), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
        tuz.b(this.jdField_a_of_type_Tvj.a, true);
        return;
        if (paramInt == tqz.b)
        {
          tuz.a(this.jdField_a_of_type_Tvj.a, 49);
          localObject = tuz.b(this.jdField_a_of_type_Tvj.a).getString(2131698280);
          bdgm.a(tuz.b(this.jdField_a_of_type_Tvj.a), 230, (String)localObject, null, 2131690648, 2131690626, new tvo(this), new tvp(this)).show();
          return;
        }
        if (paramInt != tqz.c) {
          break;
        }
        tuz.a(this.jdField_a_of_type_Tvj.a, 46);
        localObject = (ClipboardManager)tuz.c(this.jdField_a_of_type_Tvj.a).getSystemService("clipboard");
      } while (localObject == null);
      ((ClipboardManager)localObject).setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.content.get()));
      return;
    } while (paramInt != tqz.e);
    tuz.a(this.jdField_a_of_type_Tvj.a, 47);
    if (tra.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.get())) {}
    for (paramInt = 0;; paramInt = 2)
    {
      localObject = tuz.c(this.jdField_a_of_type_Tvj.a).getString(2131698284);
      bdgm.a(tuz.d(this.jdField_a_of_type_Tvj.a), 230, (String)localObject, null, 2131690648, 2131690626, new tvq(this, paramInt), new tvr(this)).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tvl
 * JD-Core Version:    0.7.0.1
 */