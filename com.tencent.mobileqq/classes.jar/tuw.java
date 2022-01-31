import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StUser;

class tuw
  implements tqy
{
  tuw(tuu paramtuu, FeedCloudMeta.StComment paramStComment) {}
  
  public void a(int paramInt)
  {
    Object localObject;
    if (paramInt == tqz.a)
    {
      tuk.a(this.jdField_a_of_type_Tuu.a, 48);
      if (this.jdField_a_of_type_Tuu.a.a().a(tuk.a(this.jdField_a_of_type_Tuu.a), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment))
      {
        localObject = tuk.a(this.jdField_a_of_type_Tuu.a).getString(2131698365);
        bdcd.a(tuk.a(this.jdField_a_of_type_Tuu.a), 230, (String)localObject, null, 2131690648, 2131690626, new tux(this), new tuy(this)).show();
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Tuu.a.a().b(tuk.a(this.jdField_a_of_type_Tuu.a), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment);
        tuk.b(this.jdField_a_of_type_Tuu.a, true);
        return;
        if (paramInt == tqz.b)
        {
          tuk.a(this.jdField_a_of_type_Tuu.a, 49);
          localObject = tuk.b(this.jdField_a_of_type_Tuu.a).getString(2131698278);
          bdcd.a(tuk.b(this.jdField_a_of_type_Tuu.a), 230, (String)localObject, null, 2131690648, 2131690626, new tuz(this), new tva(this)).show();
          return;
        }
        if (paramInt != tqz.c) {
          break;
        }
        tuk.a(this.jdField_a_of_type_Tuu.a, 46);
        localObject = (ClipboardManager)tuk.c(this.jdField_a_of_type_Tuu.a).getSystemService("clipboard");
      } while (localObject == null);
      ((ClipboardManager)localObject).setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.content.get()));
      return;
    } while (paramInt != tqz.e);
    tuk.a(this.jdField_a_of_type_Tuu.a, 47);
    if (tra.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.get())) {}
    for (paramInt = 0;; paramInt = 2)
    {
      localObject = tuk.c(this.jdField_a_of_type_Tuu.a).getString(2131698282);
      bdcd.a(tuk.d(this.jdField_a_of_type_Tuu.a), 230, (String)localObject, null, 2131690648, 2131690626, new tvb(this, paramInt), new tvc(this)).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tuw
 * JD-Core Version:    0.7.0.1
 */