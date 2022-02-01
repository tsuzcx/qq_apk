import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.widget.RatingBar.a;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class vsv
  implements RatingBar.a
{
  public vsv(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public void c(Object paramObject, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScoreActivity", 2, "ratingScore : " + paramInt);
    }
    this.a.GS = paramInt;
    if (paramInt <= 3) {}
    for (;;)
    {
      try
      {
        if (jjy.cK("qav_score_bad.jpg")) {
          this.a.mIcon.setBackgroundDrawable(new BitmapDrawable(this.a.getResources(), jjy.ht() + "qav_score_bad.jpg"));
        }
        ScoreQAVFragment.a(this.a).setVisibility(0);
        this.a.jk.setVisibility(0);
        this.a.kn.setText(2131698063);
        if ((this.a.mDatas != null) && (this.a.mDatas.size() > 0))
        {
          ScoreQAVFragment.a(this.a).setAdapter(ScoreQAVFragment.a(this.a));
          if (paramInt <= 0) {
            break label398;
          }
          this.a.mCommitBtn.setEnabled(true);
          this.a.mCommitBtn.setTextColor(Color.parseColor("#FFFFFF"));
          this.a.px.clear();
          return;
        }
      }
      catch (OutOfMemoryError paramObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("ScoreActivity", 2, "mIcon OOM: " + paramObject);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ScoreActivity", 2, "mDatas is invalid!");
        continue;
      }
      if (paramInt > 3)
      {
        ScoreQAVFragment.a(this.a).setVisibility(8);
        try
        {
          if (jjy.cK("qav_score_good.jpg")) {
            this.a.mIcon.setBackgroundDrawable(new BitmapDrawable(this.a.getResources(), jjy.ht() + "qav_score_good.jpg"));
          }
          this.a.jk.setVisibility(4);
          this.a.kn.setText(2131698063);
        }
        catch (OutOfMemoryError paramObject)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("ScoreActivity", 2, "mIcon OOM: " + paramObject);
            }
          }
        }
        label398:
        this.a.mCommitBtn.setEnabled(false);
        this.a.mCommitBtn.setTextColor(Color.parseColor("#BBBBBB"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vsv
 * JD-Core Version:    0.7.0.1
 */