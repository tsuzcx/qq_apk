import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aoui
  extends alcb
{
  public aoui(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void b(boolean paramBoolean, String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopAvatarWallPreviewActivity", 2, "onDelPersonalityLabelPhoto,suc:" + paramBoolean + "," + paramString + "," + paramLong1 + "," + paramLong2);
    }
    if ((!paramString.equals(this.this$0.app.getCurrentAccountUin())) || (TroopAvatarWallPreviewActivity.a(this.this$0) == null)) {}
    long l1;
    long l2;
    do
    {
      do
      {
        return;
      } while ((this.this$0.mIndex < 0) || (this.this$0.mIndex > this.this$0.a.getCount() - 1) || (this.this$0.BA == null) || (this.this$0.mIndex > this.this$0.BA.size() - 1));
      l1 = TroopAvatarWallPreviewActivity.a(this.this$0).getLong("label_id", 0L);
      l2 = Long.valueOf((String)this.this$0.BA.get(this.this$0.mIndex)).longValue();
    } while ((l1 != paramLong1) || (l2 != paramLong2));
    TroopAvatarWallPreviewActivity.j(this.this$0);
    TroopAvatarWallPreviewActivity localTroopAvatarWallPreviewActivity = this.this$0;
    if (paramBoolean) {}
    for (paramString = this.this$0.getResources().getString(2131694025);; paramString = this.this$0.getResources().getString(2131692512))
    {
      TroopAvatarWallPreviewActivity.b(localTroopAvatarWallPreviewActivity, paramString);
      if (!paramBoolean) {
        break;
      }
      this.this$0.BA.remove(this.this$0.mIndex);
      this.this$0.Hj.remove(this.this$0.mIndex);
      this.this$0.dRK = this.this$0.Hj.size();
      if (this.this$0.BA.size() == 0) {
        this.this$0.finish();
      }
      if (this.this$0.mIndex >= this.this$0.a.getCount())
      {
        paramString = this.this$0;
        paramString.mIndex -= 1;
      }
      paramString = this.this$0.mIndex + 1 + "/" + this.this$0.dRK;
      this.this$0.mTextView.setText(paramString);
      this.this$0.a.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoui
 * JD-Core Version:    0.7.0.1
 */