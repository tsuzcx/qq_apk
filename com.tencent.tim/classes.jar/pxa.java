import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.RecommendActivityViewHolder.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class pxa
  extends pwx
{
  public static final void v(puh parampuh)
  {
    ThreadManager.post(new RecommendActivityViewHolder.1(parampuh), 8, null, true);
  }
  
  public void bey()
  {
    this.itemView.setTag(2131375232, null);
  }
  
  public void r(puh parampuh)
  {
    super.r(parampuh);
    qem.b(this.mA, parampuh.headerUrl, true, (int)aqho.convertDpToPixel(this.titleTextView.getContext(), 50.0F));
    TextView localTextView = this.titleTextView;
    String str;
    int i;
    if (TextUtils.isEmpty(parampuh.title))
    {
      str = acfp.m(2131713763);
      localTextView.setText(str);
      this.mB.setVisibility(8);
      this.xd.setVisibility(0);
      this.mC.setVisibility(0);
      if (parampuh.unreadCount <= 0) {
        break label247;
      }
      i = 1;
      label92:
      dS(1, i);
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "FollowPersonViewHolder userItem = " + parampuh.title + ", faceDrawable = " + parampuh.headerUrl);
      }
      str = (String)this.itemView.getTag(2131375232);
      if (!TextUtils.equals(parampuh.unionId, str)) {
        switch (parampuh.nodeType)
        {
        default: 
          str = "unknown";
        }
      }
    }
    for (;;)
    {
      rar.a("PGC_story", "video_exp", "exp_newsrecommend", 0, 0, new String[] { parampuh.unionId, str });
      this.itemView.setTag(2131375232, parampuh.unionId);
      return;
      str = parampuh.title;
      break;
      label247:
      i = 0;
      break label92;
      str = "2";
      continue;
      str = "3";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxa
 * JD-Core Version:    0.7.0.1
 */